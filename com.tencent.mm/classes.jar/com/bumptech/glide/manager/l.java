package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class l
  implements Handler.Callback
{
  private static final a aMF;
  final Map<android.support.v4.app.g, SupportRequestManagerFragment> aMA;
  private final a aMB;
  private final android.support.v4.e.a<View, android.support.v4.app.Fragment> aMC;
  private final android.support.v4.e.a<View, android.app.Fragment> aMD;
  private final Bundle aME;
  private volatile j aMy;
  final Map<FragmentManager, k> aMz;
  private final Handler handler;
  
  static
  {
    AppMethodBeat.i(77576);
    aMF = new a()
    {
      public final j a(c paramAnonymousc, h paramAnonymoush, m paramAnonymousm, Context paramAnonymousContext)
      {
        AppMethodBeat.i(77563);
        paramAnonymousc = new j(paramAnonymousc, paramAnonymoush, paramAnonymousm, paramAnonymousContext);
        AppMethodBeat.o(77563);
        return paramAnonymousc;
      }
    };
    AppMethodBeat.o(77576);
  }
  
  public l(a parama)
  {
    AppMethodBeat.i(77564);
    this.aMz = new HashMap();
    this.aMA = new HashMap();
    this.aMC = new android.support.v4.e.a();
    this.aMD = new android.support.v4.e.a();
    this.aME = new Bundle();
    if (parama != null) {}
    for (;;)
    {
      this.aMB = parama;
      this.handler = new Handler(Looper.getMainLooper(), this);
      AppMethodBeat.o(77564);
      return;
      parama = aMF;
    }
  }
  
  @Deprecated
  private j a(Context paramContext, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    AppMethodBeat.i(77571);
    k localk = a(paramFragmentManager, paramBoolean);
    j localj = localk.aDc;
    paramFragmentManager = localj;
    if (localj == null)
    {
      paramFragmentManager = c.af(paramContext);
      paramFragmentManager = this.aMB.a(paramFragmentManager, localk.aMs, localk.aMt, paramContext);
      localk.aDc = paramFragmentManager;
    }
    AppMethodBeat.o(77571);
    return paramFragmentManager;
  }
  
  private j a(Context paramContext, android.support.v4.app.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(77574);
    SupportRequestManagerFragment localSupportRequestManagerFragment = a(paramg, paramBoolean);
    j localj = localSupportRequestManagerFragment.aDc;
    paramg = localj;
    if (localj == null)
    {
      paramg = c.af(paramContext);
      paramg = this.aMB.a(paramg, localSupportRequestManagerFragment.aMs, localSupportRequestManagerFragment.aMt, paramContext);
      localSupportRequestManagerFragment.aDc = paramg;
    }
    AppMethodBeat.o(77574);
    return paramg;
  }
  
  private j a(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(77567);
    if (com.bumptech.glide.g.k.qx())
    {
      paramFragmentActivity = ai(paramFragmentActivity.getApplicationContext());
      AppMethodBeat.o(77567);
      return paramFragmentActivity;
    }
    k(paramFragmentActivity);
    paramFragmentActivity = a(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager(), l(paramFragmentActivity));
    AppMethodBeat.o(77567);
    return paramFragmentActivity;
  }
  
  private j ah(Context paramContext)
  {
    AppMethodBeat.i(77565);
    if (this.aMy == null) {}
    try
    {
      if (this.aMy == null)
      {
        c localc = c.af(paramContext.getApplicationContext());
        this.aMy = this.aMB.a(localc, new b(), new g(), paramContext.getApplicationContext());
      }
      paramContext = this.aMy;
      AppMethodBeat.o(77565);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(77565);
    }
  }
  
  private j j(Activity paramActivity)
  {
    AppMethodBeat.i(77568);
    if (com.bumptech.glide.g.k.qx())
    {
      paramActivity = ai(paramActivity.getApplicationContext());
      AppMethodBeat.o(77568);
      return paramActivity;
    }
    k(paramActivity);
    paramActivity = a(paramActivity, paramActivity.getFragmentManager(), l(paramActivity));
    AppMethodBeat.o(77568);
    return paramActivity;
  }
  
  @TargetApi(17)
  private static void k(Activity paramActivity)
  {
    AppMethodBeat.i(77569);
    if ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed()))
    {
      paramActivity = new IllegalArgumentException("You cannot start a load for a destroyed activity");
      AppMethodBeat.o(77569);
      throw paramActivity;
    }
    AppMethodBeat.o(77569);
  }
  
  static boolean l(Activity paramActivity)
  {
    AppMethodBeat.i(77572);
    if (!paramActivity.isFinishing())
    {
      AppMethodBeat.o(77572);
      return true;
    }
    AppMethodBeat.o(77572);
    return false;
  }
  
  SupportRequestManagerFragment a(android.support.v4.app.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(77573);
    SupportRequestManagerFragment localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)paramg.findFragmentByTag("com.bumptech.glide.manager");
    SupportRequestManagerFragment localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
    if (localSupportRequestManagerFragment2 == null)
    {
      localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)this.aMA.get(paramg);
      localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
      if (localSupportRequestManagerFragment2 == null)
      {
        localSupportRequestManagerFragment1 = new SupportRequestManagerFragment();
        localSupportRequestManagerFragment1.aMJ = null;
        if (paramBoolean) {
          localSupportRequestManagerFragment1.aMs.onStart();
        }
        this.aMA.put(paramg, localSupportRequestManagerFragment1);
        paramg.beginTransaction().a(localSupportRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.handler.obtainMessage(2, paramg).sendToTarget();
      }
    }
    AppMethodBeat.o(77573);
    return localSupportRequestManagerFragment1;
  }
  
  k a(FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    AppMethodBeat.i(77570);
    k localk2 = (k)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk2 = (k)this.aMz.get(paramFragmentManager);
      localk1 = localk2;
      if (localk2 == null)
      {
        localk1 = new k();
        localk1.aMw = null;
        if (paramBoolean) {
          localk1.aMs.onStart();
        }
        this.aMz.put(paramFragmentManager, localk1);
        paramFragmentManager.beginTransaction().add(localk1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.handler.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    AppMethodBeat.o(77570);
    return localk1;
  }
  
  public final j ai(Context paramContext)
  {
    AppMethodBeat.i(77566);
    for (;;)
    {
      if (paramContext == null)
      {
        paramContext = new IllegalArgumentException("You cannot start a load on a null Context");
        AppMethodBeat.o(77566);
        throw paramContext;
      }
      if ((!com.bumptech.glide.g.k.qw()) || ((paramContext instanceof Application))) {
        break;
      }
      if ((paramContext instanceof FragmentActivity))
      {
        paramContext = a((FragmentActivity)paramContext);
        AppMethodBeat.o(77566);
        return paramContext;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = j((Activity)paramContext);
        AppMethodBeat.o(77566);
        return paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    paramContext = ah(paramContext);
    AppMethodBeat.o(77566);
    return paramContext;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(77575);
    boolean bool = true;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
      paramMessage = null;
      localObject = null;
    }
    for (;;)
    {
      if ((bool) && (localObject == null) && (Log.isLoggable("RMRetriever", 5))) {
        new StringBuilder("Failed to remove expected request manager fragment, manager: ").append(paramMessage);
      }
      AppMethodBeat.o(77575);
      return bool;
      paramMessage = (FragmentManager)paramMessage.obj;
      localObject = this.aMz.remove(paramMessage);
      continue;
      paramMessage = (android.support.v4.app.g)paramMessage.obj;
      localObject = this.aMA.remove(paramMessage);
    }
  }
  
  public static abstract interface a
  {
    public abstract j a(c paramc, h paramh, m paramm, Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.manager.l
 * JD-Core Version:    0.7.0.1
 */