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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class l
  implements Handler.Callback
{
  private static final l.a aKh;
  private volatile com.bumptech.glide.j aKa;
  final Map<FragmentManager, k> aKb;
  final Map<android.support.v4.app.g, SupportRequestManagerFragment> aKc;
  private final l.a aKd;
  private final android.support.v4.e.a<View, android.support.v4.app.Fragment> aKe;
  private final android.support.v4.e.a<View, android.app.Fragment> aKf;
  private final Bundle aKg;
  private final Handler handler;
  
  static
  {
    AppMethodBeat.i(77576);
    aKh = new l.1();
    AppMethodBeat.o(77576);
  }
  
  public l(l.a parama)
  {
    AppMethodBeat.i(77564);
    this.aKb = new HashMap();
    this.aKc = new HashMap();
    this.aKe = new android.support.v4.e.a();
    this.aKf = new android.support.v4.e.a();
    this.aKg = new Bundle();
    if (parama != null) {}
    for (;;)
    {
      this.aKd = parama;
      this.handler = new Handler(Looper.getMainLooper(), this);
      AppMethodBeat.o(77564);
      return;
      parama = aKh;
    }
  }
  
  @Deprecated
  private com.bumptech.glide.j a(Context paramContext, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    AppMethodBeat.i(77571);
    k localk = a(paramFragmentManager, paramBoolean);
    com.bumptech.glide.j localj = localk.aAr;
    paramFragmentManager = localj;
    if (localj == null)
    {
      paramFragmentManager = c.ac(paramContext);
      paramFragmentManager = this.aKd.a(paramFragmentManager, localk.aJU, localk.aJV, paramContext);
      localk.aAr = paramFragmentManager;
    }
    AppMethodBeat.o(77571);
    return paramFragmentManager;
  }
  
  private com.bumptech.glide.j a(Context paramContext, android.support.v4.app.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(77574);
    SupportRequestManagerFragment localSupportRequestManagerFragment = a(paramg, paramBoolean);
    com.bumptech.glide.j localj = localSupportRequestManagerFragment.aAr;
    paramg = localj;
    if (localj == null)
    {
      paramg = c.ac(paramContext);
      paramg = this.aKd.a(paramg, localSupportRequestManagerFragment.aJU, localSupportRequestManagerFragment.aJV, paramContext);
      localSupportRequestManagerFragment.aAr = paramg;
    }
    AppMethodBeat.o(77574);
    return paramg;
  }
  
  private com.bumptech.glide.j a(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(77567);
    if (com.bumptech.glide.h.j.pS())
    {
      paramFragmentActivity = af(paramFragmentActivity.getApplicationContext());
      AppMethodBeat.o(77567);
      return paramFragmentActivity;
    }
    k(paramFragmentActivity);
    paramFragmentActivity = a(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager(), l(paramFragmentActivity));
    AppMethodBeat.o(77567);
    return paramFragmentActivity;
  }
  
  private com.bumptech.glide.j ae(Context paramContext)
  {
    AppMethodBeat.i(77565);
    if (this.aKa == null) {}
    try
    {
      if (this.aKa == null)
      {
        c localc = c.ac(paramContext.getApplicationContext());
        this.aKa = this.aKd.a(localc, new b(), new g(), paramContext.getApplicationContext());
      }
      paramContext = this.aKa;
      AppMethodBeat.o(77565);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(77565);
    }
  }
  
  private com.bumptech.glide.j j(Activity paramActivity)
  {
    AppMethodBeat.i(77568);
    if (com.bumptech.glide.h.j.pS())
    {
      paramActivity = af(paramActivity.getApplicationContext());
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
  
  final SupportRequestManagerFragment a(android.support.v4.app.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(77573);
    SupportRequestManagerFragment localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)paramg.findFragmentByTag("com.bumptech.glide.manager");
    SupportRequestManagerFragment localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
    if (localSupportRequestManagerFragment2 == null)
    {
      localSupportRequestManagerFragment2 = (SupportRequestManagerFragment)this.aKc.get(paramg);
      localSupportRequestManagerFragment1 = localSupportRequestManagerFragment2;
      if (localSupportRequestManagerFragment2 == null)
      {
        localSupportRequestManagerFragment1 = new SupportRequestManagerFragment();
        localSupportRequestManagerFragment1.aKl = null;
        if (paramBoolean) {
          localSupportRequestManagerFragment1.aJU.onStart();
        }
        this.aKc.put(paramg, localSupportRequestManagerFragment1);
        paramg.beginTransaction().a(localSupportRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.handler.obtainMessage(2, paramg).sendToTarget();
      }
    }
    AppMethodBeat.o(77573);
    return localSupportRequestManagerFragment1;
  }
  
  final k a(FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    AppMethodBeat.i(77570);
    k localk2 = (k)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk2 = (k)this.aKb.get(paramFragmentManager);
      localk1 = localk2;
      if (localk2 == null)
      {
        localk1 = new k();
        localk1.aJY = null;
        if (paramBoolean) {
          localk1.aJU.onStart();
        }
        this.aKb.put(paramFragmentManager, localk1);
        paramFragmentManager.beginTransaction().add(localk1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.handler.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    AppMethodBeat.o(77570);
    return localk1;
  }
  
  public final com.bumptech.glide.j af(Context paramContext)
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
      if ((!com.bumptech.glide.h.j.pR()) || ((paramContext instanceof Application))) {
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
    paramContext = ae(paramContext);
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
      localObject = this.aKb.remove(paramMessage);
      continue;
      paramMessage = (android.support.v4.app.g)paramMessage.obj;
      localObject = this.aKc.remove(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.manager.l
 * JD-Core Version:    0.7.0.1
 */