package com.tencent.mm.plugin.gwallet.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int cun;
  public Context mContext;
  public IInAppBillingService nGn;
  private ServiceConnection nGo;
  boolean nGp = false;
  public boolean nGq = false;
  public b.b nGr;
  public String nGs;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void QJ(String paramString)
  {
    AppMethodBeat.i(41703);
    ab.e("MicroMsg.IabHelper", "In-app billing error: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(41703);
  }
  
  public static int S(Bundle paramBundle)
  {
    AppMethodBeat.i(41702);
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      ab.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
      AppMethodBeat.o(41702);
      return 0;
    }
    int i;
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      AppMethodBeat.o(41702);
      return i;
    }
    if ((paramBundle instanceof Long))
    {
      i = (int)((Long)paramBundle).longValue();
      AppMethodBeat.o(41702);
      return i;
    }
    QJ("Unexpected type for bundle response code.");
    QJ(paramBundle.getClass().getName());
    paramBundle = new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
    AppMethodBeat.o(41702);
    throw paramBundle;
  }
  
  public static String xq(int paramInt)
  {
    AppMethodBeat.i(41701);
    Object localObject = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000)
    {
      int i = -1000 - paramInt;
      if ((i >= 0) && (i < arrayOfString.length))
      {
        localObject = arrayOfString[i];
        AppMethodBeat.o(41701);
        return localObject;
      }
      localObject = String.valueOf(paramInt) + ":Unknown IAB Helper Error";
      AppMethodBeat.o(41701);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= localObject.length))
    {
      localObject = String.valueOf(paramInt) + ":Unknown";
      AppMethodBeat.o(41701);
      return localObject;
    }
    localObject = localObject[paramInt];
    AppMethodBeat.o(41701);
    return localObject;
  }
  
  public final void QI(String paramString)
  {
    AppMethodBeat.i(41699);
    if (!this.nGp)
    {
      ab.e("MicroMsg.IabHelper", "Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      paramString = new IllegalStateException("IAB helper is not set up. Can't perform operation: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(41699);
      throw paramString;
    }
    AppMethodBeat.o(41699);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(41697);
    if (this.nGp)
    {
      parama = new IllegalStateException("IAB helper is already set up.");
      AppMethodBeat.o(41697);
      throw parama;
    }
    ab.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
    this.nGo = new b.1(this, parama);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    if ((this.mContext != null) && (this.mContext.getPackageManager() != null) && (this.mContext.getPackageManager().queryIntentServices(localIntent, 0) != null) && (!this.mContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()))
    {
      this.mContext.bindService(localIntent, this.nGo, 1);
      AppMethodBeat.o(41697);
      return;
    }
    parama.a(new c(-2001, "Google play not installed!"));
    AppMethodBeat.o(41697);
  }
  
  public final boolean a(ArrayList<String> paramArrayList, c paramc)
  {
    AppMethodBeat.i(41700);
    QI("query details");
    Intent localIntent = new Intent();
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ab.e("MicroMsg.IabHelper", "query list is empty!");
      paramArrayList = new c(5, "no query list or is empty");
      localIntent.putExtra("RESPONSE_CODE", 5);
      localIntent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
      paramc.a(paramArrayList, localIntent);
      AppMethodBeat.o(41700);
      return true;
    }
    try
    {
      ab.d("MicroMsg.IabHelper", "query detail list with the size is " + paramArrayList.size());
      Object localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("ITEM_ID_LIST", paramArrayList);
      paramArrayList = this.nGn.getSkuDetails(3, this.mContext.getPackageName(), "inapp", (Bundle)localObject);
      int i = S(paramArrayList);
      ab.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(i));
      if (i != 0)
      {
        ab.d("MicroMsg.IabHelper", "cannot query details");
        paramArrayList = new c(i, "cannot query details");
        localIntent.putExtra("RESPONSE_CODE", i);
        paramc.a(paramArrayList, localIntent);
        AppMethodBeat.o(41700);
        return true;
      }
      localObject = new c(i, "query list ok!");
      ab.d("MicroMsg.IabHelper", "result code : ".concat(String.valueOf(i)));
      localIntent.putExtra("RESPONSE_CODE", i);
      localIntent.putExtra("RESPONSE_QUERY_DETAIL_INFO", paramArrayList.getStringArrayList("DETAILS_LIST"));
      paramc.a((c)localObject, localIntent);
      paramArrayList = paramArrayList.getStringArrayList("DETAILS_LIST").iterator();
      while (paramArrayList.hasNext()) {
        ab.d("MicroMsg.IabHelper", (String)paramArrayList.next());
      }
      AppMethodBeat.o(41700);
    }
    catch (RemoteException paramArrayList)
    {
      QJ("RemoteException while launching query details ");
      ab.printErrStackTrace("MicroMsg.IabHelper", paramArrayList, "", new Object[0]);
      paramArrayList = new c(-1001, "Remote exception while starting purchase flow");
      localIntent.putExtra("RESPONSE_CODE", 6);
      localIntent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
      paramc.a(paramArrayList, localIntent);
      AppMethodBeat.o(41700);
      return false;
    }
    return true;
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(41698);
    ab.d("MicroMsg.IabHelper", "Disposing.");
    this.nGp = false;
    if (this.nGo != null) {
      ab.d("MicroMsg.IabHelper", "Unbinding from service.");
    }
    try
    {
      if (this.mContext != null) {
        this.mContext.unbindService(this.nGo);
      }
      this.nGo = null;
      this.nGn = null;
      AppMethodBeat.o(41698);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.IabHelper", localIllegalArgumentException.toString());
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b
 * JD-Core Version:    0.7.0.1
 */