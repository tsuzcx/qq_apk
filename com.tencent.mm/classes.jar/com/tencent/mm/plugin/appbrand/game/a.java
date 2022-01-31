package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import com.tencent.magicbrush.engine.MBRendererJNI;
import com.tencent.mm.h.b.a.af;
import com.tencent.mm.h.b.a.af.a;
import com.tencent.mm.h.b.a.af.b;
import com.tencent.mm.plugin.appbrand.game.c.f;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class a
  implements GameGLSurfaceView.n, b
{
  private long fZA;
  private boolean fZB = false;
  public f fZC = new f();
  a.a fZD = a.a.fZG;
  private j fZv;
  boolean fZw = false;
  private boolean fZx = false;
  private com.tencent.magicbrush.engine.e fZy;
  j.b fZz;
  private n fzW;
  private Context mContext;
  
  public a(j paramj, com.tencent.magicbrush.engine.e parame)
  {
    y.i("MicroMsg.GameRenderer", "GameRenderer construct [%s]", new Object[] { parame });
    this.fZA = System.currentTimeMillis();
    this.fZv = paramj;
    this.fZy = parame;
    this.mContext = this.fZv.getContext();
    this.fzW = this.fZv.getRuntime();
    if (this.fzW != null)
    {
      paramj = com.tencent.mm.plugin.appbrand.report.quality.a.wg(this.fzW.mAppId);
      if ((paramj != null) && (paramj.hau.aow())) {
        this.fZC.gbS = true;
      }
    }
  }
  
  public final void afZ()
  {
    y.i("MicroMsg.GameRenderer", "onEGLCreate");
    if (this.fZy != null) {
      this.fZy.bkI.nativeOnEGLCreated();
    }
    if (this.fZz != null) {
      this.fZz.agi();
    }
    if (this.fzW != null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.aov();
      Object localObject = this.fzW.mAppId;
      long l = this.fZA;
      af localaf = new af();
      localObject = com.tencent.mm.plugin.appbrand.report.quality.a.wg((String)localObject);
      if (localObject != null)
      {
        localaf.ckG = ((QualitySessionRuntime)localObject).appId;
        localaf.ckF = ((QualitySessionRuntime)localObject).gKi;
        localaf.clb = af.a.eC(((QualitySessionRuntime)localObject).ham);
        localaf.clc = af.b.eD(((QualitySessionRuntime)localObject).apptype);
        localaf.ckH = ((QualitySessionRuntime)localObject).han;
        localaf.cic = ((QualitySessionRuntime)localObject).scene;
        localaf.at(l);
        localaf.uT();
        localaf.as(localaf.ckM - l);
        localaf.QX();
      }
    }
  }
  
  public final void aga()
  {
    if (this.fZy != null) {
      this.fZy.bkI.nativeOnEGLSurfaceChanged();
    }
  }
  
  public final void bS(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.GameRenderer", "[alex] WindowSize onSurfaceChanged width = [%d], height = [%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.fZy != null) {
      this.fZy.bkI.nativeOnSurfaceSizeChanged(paramInt1, paramInt2);
    }
    l.gav.bT(paramInt1, paramInt2);
    if (this.fzW != null)
    {
      n localn = this.fzW;
      com.tencent.mm.plugin.appbrand.page.j localj = localn.fyx;
      y.i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
      localj.d(localn.Zy()).dispatch();
    }
  }
  
  public final void cR(boolean paramBoolean)
  {
    if (this.fZy == null) {}
    f localf;
    boolean bool;
    do
    {
      return;
      localf = this.fZC;
      if (!localf.gbR) {
        localf.gbT = System.currentTimeMillis();
      }
      bool = this.fZy.bkI.nativeCheckTimer();
    } while (paramBoolean);
    long l;
    if (bool)
    {
      if (!this.fZw)
      {
        y.w("MicroMsg.GameRenderer", "hy: onDrawFrame mFirstFrameRendered. using %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.fZA) });
        this.fZw = true;
        this.fZv.agq();
      }
      localf = this.fZC;
      if (!localf.gbR)
      {
        l = System.currentTimeMillis();
        if (localf.gbM > 0L) {
          break label143;
        }
        localf.gbM = l;
        localf.gbK = l;
      }
    }
    for (;;)
    {
      this.fZv.setSwapNow(bool);
      return;
      label143:
      localf.gbL += 1;
      localf.gbU += l - localf.gbT;
      if (localf.gbL % 20 <= 0)
      {
        localf.gbN = (20000.0D / (l - localf.gbK));
        localf.gbV = (20000.0F / (float)localf.gbU);
        localf.gbU = 0L;
        if (localf.gbS) {
          localf.gbP.add(Double.valueOf(localf.gbN));
        }
        if (localf.gbO <= 0.0D) {
          localf.gbO = localf.gbN;
        }
        for (;;)
        {
          if (localf.gbQ.size() < 30) {
            localf.gbQ.add(Double.valueOf(localf.gbN));
          }
          localf.gbK = l;
          break;
          if (localf.gbN < localf.gbO) {
            localf.gbO = localf.gbN;
          }
        }
        if (!this.fZx)
        {
          this.fZx = true;
          if (this.fzW != null) {
            this.fzW.fzG.n(9, System.currentTimeMillis() - this.fZA);
          }
        }
      }
    }
  }
  
  public final void g(Runnable paramRunnable)
  {
    if (this.fZv != null) {
      this.fZv.queueEvent(paramRunnable);
    }
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.GameRenderer", "onDestroy ");
    if (!this.fZB)
    {
      this.fZB = true;
      i locali = i.gad;
      y.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm start");
      Iterator localIterator = locali.gag.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if (locali.gae != ((Map.Entry)localObject).getValue())
        {
          localObject = (d)((Map.Entry)localObject).getValue();
          if (localObject != null) {
            ((d)localObject).destroy();
          }
        }
      }
      locali.gag.clear();
      if (locali.gae != null)
      {
        locali.gae.destroy();
        locali.gae = null;
      }
      y.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm finished");
      if (this.fZy != null) {
        this.fZy.bkI.nativeDestroy();
      }
      return;
    }
    y.w("MicroMsg.GameRenderer", "hy: called onFinalize multiple times! ");
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.GameRenderer", "onPause ");
    if (this.fZy != null) {
      this.fZy.bkI.nativePause();
    }
  }
  
  public final void onResume()
  {
    y.i("MicroMsg.GameRenderer", "onResume ");
    if (this.fZy != null) {
      this.fZy.bkI.nativeResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */