package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class b
{
  public Context mContext;
  public int mRequestCode;
  public IInAppBillingService yhl;
  private ServiceConnection yhm;
  boolean yhn = false;
  public boolean yho = false;
  public b yhp;
  public String yhq;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void aBv(String paramString)
  {
    AppMethodBeat.i(64599);
    Log.e("MicroMsg.IabHelper", "In-app billing error: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(64599);
  }
  
  public static int ao(Bundle paramBundle)
  {
    AppMethodBeat.i(64598);
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      Log.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
      AppMethodBeat.o(64598);
      return 0;
    }
    int i;
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      AppMethodBeat.o(64598);
      return i;
    }
    if ((paramBundle instanceof Long))
    {
      i = (int)((Long)paramBundle).longValue();
      AppMethodBeat.o(64598);
      return i;
    }
    aBv("Unexpected type for bundle response code.");
    aBv(paramBundle.getClass().getName());
    paramBundle = new RuntimeException("Unexpected type for bundle response code: " + paramBundle.getClass().getName());
    AppMethodBeat.o(64598);
    throw paramBundle;
  }
  
  public static String getResponseDesc(int paramInt)
  {
    AppMethodBeat.i(64597);
    Object localObject = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000)
    {
      int i = -1000 - paramInt;
      if ((i >= 0) && (i < arrayOfString.length))
      {
        localObject = arrayOfString[i];
        AppMethodBeat.o(64597);
        return localObject;
      }
      localObject = String.valueOf(paramInt) + ":Unknown IAB Helper Error";
      AppMethodBeat.o(64597);
      return localObject;
    }
    if ((paramInt < 0) || (paramInt >= localObject.length))
    {
      localObject = String.valueOf(paramInt) + ":Unknown";
      AppMethodBeat.o(64597);
      return localObject;
    }
    localObject = localObject[paramInt];
    AppMethodBeat.o(64597);
    return localObject;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(64593);
    if (this.yhn)
    {
      parama = new IllegalStateException("IAB helper is already set up.");
      AppMethodBeat.o(64593);
      throw parama;
    }
    Log.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
    this.yhm = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(64588);
        b.aBw("Billing service connected.");
        b.this.yhl = IInAppBillingService.a.f(paramAnonymousIBinder);
        paramAnonymousComponentName = b.this.mContext.getPackageName();
        try
        {
          b.aBw("Checking for in-app billing 3 support.");
          int i = b.this.yhl.b(3, paramAnonymousComponentName, "inapp");
          if (i != 0)
          {
            if (parama != null) {
              parama.a(new c(i, "Error checking for billing v3 support."));
            }
            b.this.yho = false;
            AppMethodBeat.o(64588);
            return;
          }
          b.aBw("In-app billing version 3 supported for ".concat(String.valueOf(paramAnonymousComponentName)));
          i = b.this.yhl.b(3, paramAnonymousComponentName, "subs");
          if (i == 0)
          {
            b.aBw("Subscriptions AVAILABLE.");
            b.this.yho = true;
          }
          for (;;)
          {
            b.this.yhn = true;
            if (parama != null) {
              parama.a(new c(0, "Setup successful."));
            }
            AppMethodBeat.o(64588);
            return;
            b.aBw("Subscriptions NOT AVAILABLE. Response: ".concat(String.valueOf(i)));
          }
          return;
        }
        catch (RemoteException paramAnonymousComponentName)
        {
          if (parama != null) {
            parama.a(new c(-1001, "RemoteException while setting up in-app billing."));
          }
          Log.printErrStackTrace("MicroMsg.IabHelper", paramAnonymousComponentName, "", new Object[0]);
          AppMethodBeat.o(64588);
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(64587);
        b.aBw("Billing service disconnected.");
        b.this.yhl = null;
        AppMethodBeat.o(64587);
      }
    };
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    if ((this.mContext != null) && (this.mContext.getPackageManager() != null) && (this.mContext.getPackageManager().queryIntentServices(localIntent, 0) != null) && (!this.mContext.getPackageManager().queryIntentServices(localIntent, 0).isEmpty()))
    {
      this.mContext.bindService(localIntent, this.yhm, 1);
      AppMethodBeat.o(64593);
      return;
    }
    parama.a(new c(-2001, "Google play not installed!"));
    AppMethodBeat.o(64593);
  }
  
  public final boolean a(ArrayList<String> paramArrayList, c paramc)
  {
    AppMethodBeat.i(64596);
    aBu("query details");
    Intent localIntent = new Intent();
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      Log.e("MicroMsg.IabHelper", "query list is empty!");
      paramArrayList = new c(5, "no query list or is empty");
      localIntent.putExtra("RESPONSE_CODE", 5);
      localIntent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
      paramc.a(paramArrayList, localIntent);
      AppMethodBeat.o(64596);
      return true;
    }
    try
    {
      Log.d("MicroMsg.IabHelper", "query detail list with the size is " + paramArrayList.size());
      Object localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("ITEM_ID_LIST", paramArrayList);
      paramArrayList = this.yhl.getSkuDetails(3, this.mContext.getPackageName(), "inapp", (Bundle)localObject);
      int i = ao(paramArrayList);
      Log.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(i));
      if (i != 0)
      {
        Log.d("MicroMsg.IabHelper", "cannot query details");
        paramArrayList = new c(i, "cannot query details");
        localIntent.putExtra("RESPONSE_CODE", i);
        paramc.a(paramArrayList, localIntent);
        AppMethodBeat.o(64596);
        return true;
      }
      localObject = new c(i, "query list ok!");
      Log.d("MicroMsg.IabHelper", "result code : ".concat(String.valueOf(i)));
      localIntent.putExtra("RESPONSE_CODE", i);
      localIntent.putExtra("RESPONSE_QUERY_DETAIL_INFO", paramArrayList.getStringArrayList("DETAILS_LIST"));
      paramc.a((c)localObject, localIntent);
      paramArrayList = paramArrayList.getStringArrayList("DETAILS_LIST").iterator();
      while (paramArrayList.hasNext()) {
        Log.d("MicroMsg.IabHelper", (String)paramArrayList.next());
      }
      AppMethodBeat.o(64596);
    }
    catch (RemoteException paramArrayList)
    {
      aBv("RemoteException while launching query details ");
      Log.printErrStackTrace("MicroMsg.IabHelper", paramArrayList, "", new Object[0]);
      paramArrayList = new c(-1001, "Remote exception while starting purchase flow");
      localIntent.putExtra("RESPONSE_CODE", 6);
      localIntent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
      paramc.a(paramArrayList, localIntent);
      AppMethodBeat.o(64596);
      return false;
    }
    return true;
  }
  
  public final void aBu(String paramString)
  {
    AppMethodBeat.i(64595);
    if (!this.yhn)
    {
      Log.e("MicroMsg.IabHelper", "Illegal state for operation (" + paramString + "): IAB helper is not set up.");
      paramString = new IllegalStateException("IAB helper is not set up. Can't perform operation: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(64595);
      throw paramString;
    }
    AppMethodBeat.o(64595);
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(64594);
    Log.d("MicroMsg.IabHelper", "Disposing.");
    this.yhn = false;
    if (this.yhm != null) {
      Log.d("MicroMsg.IabHelper", "Unbinding from service.");
    }
    try
    {
      if (this.mContext != null) {
        this.mContext.unbindService(this.yhm);
      }
      this.yhm = null;
      this.yhl = null;
      AppMethodBeat.o(64594);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("MicroMsg.IabHelper", localIllegalArgumentException.toString());
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void b(c paramc, Intent paramIntent);
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b
 * JD-Core Version:    0.7.0.1
 */