package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.magicbrush.a.d.a;
import com.tencent.magicbrush.a.d.f;
import com.tencent.magicbrush.handler.MBFontManagerJNI;
import com.tencent.magicbrush.handler.MBImageHandlerJNI;
import com.tencent.magicbrush.handler.MBJavaHandler;
import com.tencent.mm.plugin.appbrand.game.b.a.a;
import com.tencent.mm.plugin.appbrand.game.b.a.b;
import com.tencent.mm.plugin.appbrand.game.b.b.1;
import com.tencent.mm.plugin.appbrand.game.b.b.2;
import com.tencent.mm.plugin.appbrand.game.b.b.3;
import com.tencent.mm.plugin.appbrand.game.b.b.a;
import com.tencent.mm.plugin.appbrand.game.b.b.b;
import com.tencent.mm.plugin.appbrand.game.b.b.c;
import com.tencent.mm.plugin.appbrand.game.b.b.d;
import com.tencent.mm.plugin.appbrand.game.b.b.e;
import com.tencent.mm.plugin.appbrand.game.b.d.1;
import com.tencent.mm.plugin.appbrand.game.b.d.2;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class j
  extends GameGLSurfaceView
  implements b
{
  private n fzW;
  private a gai;
  private j.a gaj;
  private u gak;
  private j.d gal = new j.d((byte)0);
  private com.tencent.magicbrush.handler.c pWo = new j.4(this);
  
  public j(Context paramContext, n paramn, j.b paramb, j.a parama)
  {
    super(paramContext);
    y.i("MicroMsg.WAGameView", "new GameView");
    this.fzW = paramn;
    setEGLContextClientVersion(2);
    setEGLConfigChooser(new GameGLSurfaceView.b(this));
    setPreserveEGLContextOnPause(true);
    this.gai = new a(this, ((c)paramn.aae()).fZO);
    this.gai.fZz = paramb;
    this.gaj = parama;
    setRenderer(this.gai);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        j.a(j.this, paramAnonymousMotionEvent);
        return true;
      }
    });
    if (com.tencent.mm.plugin.appbrand.config.j.sm(this.fzW.mAppId)) {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          if ((j.a(j.this) != null) && (!j.a(j.this).fZw))
          {
            j.a(j.this).fZw = true;
            j.this.agq();
          }
        }
      }, 30000L);
    }
    this.gak = new j.3(this, paramContext.getResources().getDisplayMetrics().density);
    MBJavaHandler.setCallbackProxy(this.pWo);
    MBFontManagerJNI.registerFontManager(new com.tencent.mm.plugin.appbrand.game.b.a.1(getRuntime()));
    com.tencent.magicbrush.a.b.a(new a.a((byte)0));
    com.tencent.magicbrush.handler.a.a.a(new a.b());
    paramContext = getRuntime();
    paramn = new b.3(new b.1(this), new b.2());
    paramn.a(new b.c((byte)0), false);
    paramn.a(new b.b((byte)0), false);
    paramn.a(new b.d(paramContext, (byte)0), true);
    paramn.bmc = new b.a();
    com.tencent.magicbrush.a.a.a(new b.e((byte)0));
    MBImageHandlerJNI.register(paramn);
    d.f.a(new d.1());
    d.a.a(new d.2());
    com.github.henryye.nativeiv.b.a(new com.tencent.magicbrush.b.a.a.1());
    Assert.assertTrue(com.github.henryye.nativeiv.comm.a.kp());
  }
  
  private boolean t(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = null;
    if (paramMotionEvent == null) {}
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 6)) {
        com.tencent.mm.plugin.normsg.a.b.mGK.a("ce_mg", paramMotionEvent);
      }
      if (this.gak != null)
      {
        u localu = this.gak;
        if (paramMotionEvent == null) {}
        while ((localStringBuilder != null) && (localStringBuilder.length() != 0))
        {
          paramMotionEvent = (j.c)this.gal.ahp();
          paramMotionEvent.gan = localStringBuilder.toString();
          paramMotionEvent.gao = this.fzW.aae().ahK();
          queueEvent(paramMotionEvent);
          return true;
          int i;
          switch (paramMotionEvent.getActionMasked())
          {
          case 4: 
          default: 
            i = -1;
          }
          int k;
          int j;
          while (i != -1)
          {
            localu.gfv.setLength(0);
            localu.gfv = localu.e(localu.gfv);
            localu.gfv.append("[[");
            k = paramMotionEvent.getPointerCount();
            j = 0;
            while (j < k)
            {
              localu.gfv.append(paramMotionEvent.getPointerId(j)).append(",").append(paramMotionEvent.getX(j) / localu.gfu).append(",").append(paramMotionEvent.getY(j) / localu.gfu).append(",").append(paramMotionEvent.getPressure(j));
              if (j != k - 1) {
                localu.gfv.append(",");
              }
              j += 1;
            }
            i = 0;
            continue;
            i = 1;
            continue;
            i = 2;
            continue;
            i = 3;
          }
          localu.gfv.append("],[");
          if (i == 1)
          {
            j = 0;
            while (j < k)
            {
              localu.gfv.append(j);
              if (j != k - 1) {
                localu.gfv.append(",");
              }
              j += 1;
            }
          }
          localu.gfv.append(paramMotionEvent.getActionIndex());
          localu.gfv.append("],");
          localu.gfv.append(paramMotionEvent.getEventTime()).append(",");
          localu.gfv.append(i).append("]");
          localu.gfv = localu.f(localu.gfv);
          localStringBuilder = localu.gfv;
        }
      }
    }
  }
  
  final void agq()
  {
    y.i("MicroMsg.WAGameView", "hy: first rendered: %s ", new Object[] { this.fzW.mAppId });
    if (this.gaj != null)
    {
      this.gaj.agq();
      this.gaj = null;
    }
  }
  
  public final void g(Runnable paramRunnable)
  {
    queueEvent(paramRunnable);
  }
  
  public final a getMBRenderer()
  {
    return this.gai;
  }
  
  final n getRuntime()
  {
    return this.fzW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.j
 * JD-Core Version:    0.7.0.1
 */