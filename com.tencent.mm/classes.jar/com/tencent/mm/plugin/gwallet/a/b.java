package com.tencent.mm.plugin.gwallet.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import com.a.a.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public int bMT;
  public a liY;
  private ServiceConnection liZ;
  boolean lja = false;
  public boolean ljb = false;
  public b.b ljc;
  public String ljd;
  public Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static int B(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      y.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    if ((paramBundle instanceof Long)) {
      return (int)((Long)paramBundle).longValue();
    }
    Fl("Unexpected type for bundle response code.");
    Fl(paramBundle.getClass().getName());
    throw new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
  }
  
  public static void Fl(String paramString)
  {
    y.e("MicroMsg.IabHelper", "In-app billing error: " + paramString);
  }
  
  public static String sq(int paramInt)
  {
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000)
    {
      int i = -1000 - paramInt;
      if ((i >= 0) && (i < arrayOfString2.length)) {
        return arrayOfString2[i];
      }
      return String.valueOf(paramInt) + ":Unknown IAB Helper Error";
    }
    if ((paramInt < 0) || (paramInt >= arrayOfString1.length)) {
      return String.valueOf(paramInt) + ":Unknown";
    }
    return arrayOfString1[paramInt];
  }
  
  public final void Fk(String paramString)
  {
    if (!this.lja)
    {
      y.e("MicroMsg.IabHelper", "Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + paramString);
    }
  }
  
  public final void a(b.a parama)
  {
    if (this.lja) {
      throw new IllegalStateException("IAB helper is already set up.");
    }
    y.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
    this.liZ = new b.1(this, parama);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    if ((this.mContext != null) && (this.mContext.getPackageManager() != null) && (this.mContext.getPackageManager().queryIntentServices(localIntent, 0) != null) && (!this.mContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()))
    {
      this.mContext.bindService(localIntent, this.liZ, 1);
      return;
    }
    parama.a(new c(-2001, "Google play not installed!"));
  }
  
  public final boolean a(ArrayList<String> paramArrayList, b.c paramc)
  {
    Fk("query details");
    Intent localIntent = new Intent();
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      y.e("MicroMsg.IabHelper", "query list is empty!");
      paramArrayList = new c(5, "no query list or is empty");
      localIntent.putExtra("RESPONSE_CODE", 5);
      localIntent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
      paramc.a(paramArrayList, localIntent);
      return true;
    }
    try
    {
      y.d("MicroMsg.IabHelper", "query detail list with the size is " + paramArrayList.size());
      Object localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("ITEM_ID_LIST", paramArrayList);
      paramArrayList = this.liY.a(3, this.mContext.getPackageName(), "inapp", (Bundle)localObject);
      int i = B(paramArrayList);
      y.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(i));
      if (i != 0)
      {
        y.d("MicroMsg.IabHelper", "cannot query details");
        paramArrayList = new c(i, "cannot query details");
        localIntent.putExtra("RESPONSE_CODE", i);
        paramc.a(paramArrayList, localIntent);
        return true;
      }
      localObject = new c(i, "query list ok!");
      y.d("MicroMsg.IabHelper", "result code : " + i);
      localIntent.putExtra("RESPONSE_CODE", i);
      localIntent.putExtra("RESPONSE_QUERY_DETAIL_INFO", paramArrayList.getStringArrayList("DETAILS_LIST"));
      paramc.a((c)localObject, localIntent);
      paramArrayList = paramArrayList.getStringArrayList("DETAILS_LIST").iterator();
      while (paramArrayList.hasNext()) {
        y.d("MicroMsg.IabHelper", (String)paramArrayList.next());
      }
      return true;
    }
    catch (RemoteException paramArrayList)
    {
      Fl("RemoteException while launching query details ");
      y.printErrStackTrace("MicroMsg.IabHelper", paramArrayList, "", new Object[0]);
      paramArrayList = new c(-1001, "Remote exception while starting purchase flow");
      localIntent.putExtra("RESPONSE_CODE", 6);
      localIntent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
      paramc.a(paramArrayList, localIntent);
      return false;
    }
  }
  
  public final void dispose()
  {
    y.d("MicroMsg.IabHelper", "Disposing.");
    this.lja = false;
    if (this.liZ != null) {
      y.d("MicroMsg.IabHelper", "Unbinding from service.");
    }
    try
    {
      if (this.mContext != null) {
        this.mContext.unbindService(this.liZ);
      }
      this.liZ = null;
      this.liY = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        y.e("MicroMsg.IabHelper", localIllegalArgumentException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b
 * JD-Core Version:    0.7.0.1
 */