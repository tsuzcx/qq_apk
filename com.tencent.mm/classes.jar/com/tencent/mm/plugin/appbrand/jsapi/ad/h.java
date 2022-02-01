package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class h
{
  private static final Map<String, h> sty;
  private f eqB;
  boolean mEnable;
  private g stA;
  ak.a stB;
  ak.a stC;
  String stz;
  
  static
  {
    AppMethodBeat.i(137644);
    sty = new HashMap();
    AppMethodBeat.o(137644);
  }
  
  public h()
  {
    AppMethodBeat.i(329490);
    this.mEnable = false;
    this.stz = "";
    this.stA = new g();
    this.stB = ak.a.urD;
    this.stC = ak.a.urD;
    AppMethodBeat.o(329490);
  }
  
  public static h F(f paramf)
  {
    AppMethodBeat.i(329502);
    h localh = (h)Objects.requireNonNull(aG(paramf.getAppId(), true));
    localh.stz = paramf.getAppId();
    localh.eqB = paramf;
    localh.mEnable = true;
    localh.stA.i(paramf);
    if (localh.stC != ak.a.urD) {
      localh.stA.b(localh.stC);
    }
    Log.i("MicroMsg.OrientationConfigListenerHelper", "startListen appId:%s", new Object[] { localh.stz });
    AppMethodBeat.o(329502);
    return localh;
  }
  
  public static void G(f paramf)
  {
    AppMethodBeat.i(137641);
    paramf = aG(paramf.getAppId(), false);
    if (paramf != null) {
      paramf.cuD();
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(String paramString, Configuration paramConfiguration)
  {
    AppMethodBeat.i(329517);
    paramString = (h)Objects.requireNonNull(aG(paramString, true));
    if (paramConfiguration.orientation == 2) {
      if (paramString.stB == ak.a.urH) {
        paramString.stC = ak.a.urH;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppId:%s, mEnable:%b, mOrientation:%s, mConfiguration:%s", new Object[] { paramString.stz, Boolean.valueOf(paramString.mEnable), paramString.stB, paramString.stC });
      if (paramString.mEnable) {
        paramString.c(paramString.stC);
      }
      AppMethodBeat.o(329517);
      return;
      paramString.stC = ak.a.urF;
      continue;
      if (paramConfiguration.orientation == 1) {
        paramString.stC = ak.a.urE;
      } else {
        paramString.stC = ak.a.urD;
      }
    }
  }
  
  static h aG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(329495);
    Assert.assertFalse(TextUtils.isEmpty(paramString));
    synchronized (sty)
    {
      h localh2 = (h)sty.get(paramString);
      h localh1 = localh2;
      if (localh2 == null)
      {
        if (!paramBoolean)
        {
          AppMethodBeat.o(329495);
          return null;
        }
        localh1 = new h();
        localh1.stz = paramString;
        sty.put(paramString, localh1);
      }
      AppMethodBeat.o(329495);
      return localh1;
    }
  }
  
  public static void aby(String paramString)
  {
    AppMethodBeat.i(329498);
    Assert.assertFalse(TextUtils.isEmpty(paramString));
    synchronized (sty)
    {
      paramString = (h)sty.remove(paramString);
      if (paramString != null) {
        paramString.cuD();
      }
      AppMethodBeat.o(329498);
      return;
    }
  }
  
  private void cuD()
  {
    AppMethodBeat.i(329511);
    Log.i("MicroMsg.OrientationConfigListenerHelper", "stopListen appId:%s", new Object[] { this.stz });
    this.stz = "";
    this.eqB = null;
    this.mEnable = false;
    this.stC = ak.a.urD;
    AppMethodBeat.o(329511);
  }
  
  final void c(final ak.a parama)
  {
    AppMethodBeat.i(329537);
    if (this.eqB == null)
    {
      AppMethodBeat.o(329537);
      return;
    }
    Object localObject = AndroidContextUtil.castActivityOrNull(this.eqB.getContext());
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null)
        {
          localObject = ((View)localObject).getViewTreeObserver();
          if ((localObject != null) && (((ViewTreeObserver)localObject).isAlive())) {
            break label83;
          }
        }
      }
    }
    this.stA.b(parama);
    AppMethodBeat.o(329537);
    return;
    label83:
    parama = new a(parama);
    ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      private int qQS = 0;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(329488);
        int i = this.qQS + 1;
        this.qQS = i;
        if (i < 2)
        {
          AppMethodBeat.o(329488);
          return;
        }
        this.stD.removeOnGlobalLayoutListener(this);
        parama.abz("onGlobalLayout");
        AppMethodBeat.o(329488);
      }
    });
    com.tencent.threadpool.h.ahAA.o(parama, 100L);
    AppMethodBeat.o(329537);
  }
  
  final class a
    implements Runnable
  {
    private final AtomicBoolean stG;
    
    a()
    {
      AppMethodBeat.i(329482);
      this.stG = new AtomicBoolean(false);
      AppMethodBeat.o(329482);
    }
    
    final void abz(String paramString)
    {
      AppMethodBeat.i(329487);
      if (!this.stG.getAndSet(true))
      {
        Log.v("MicroMsg.OrientationConfigListenerHelper", "dispatch (%s), appId:%s, orientation:%s", new Object[] { paramString, h.a(this.stF), parama });
        h.b(this.stF).b(parama);
      }
      AppMethodBeat.o(329487);
    }
    
    public final void run()
    {
      AppMethodBeat.i(329485);
      abz("timeout");
      AppMethodBeat.o(329485);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.h
 * JD-Core Version:    0.7.0.1
 */