package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, a
{
  private final b hga;
  private final Set<View.OnAttachStateChangeListener> hgb;
  private volatile ak hge;
  private Runnable hgf;
  private volatile boolean hgh;
  private volatile Object mLock;
  
  public MTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(103812);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    this.mLock = new Object();
    this.hgf = new MTextureView.1(this);
    init();
    AppMethodBeat.o(103812);
  }
  
  public MTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103813);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    this.mLock = new Object();
    this.hgf = new MTextureView.1(this);
    init();
    AppMethodBeat.o(103813);
  }
  
  public MTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103814);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    this.mLock = new Object();
    this.hgf = new MTextureView.1(this);
    init();
    AppMethodBeat.o(103814);
  }
  
  private void init()
  {
    AppMethodBeat.i(103815);
    setSurfaceTextureListener(this);
    ((Activity)getContext()).getWindow().setFlags(16777216, 16777216);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.hga.getDrawContext().heG = localPaint;
    AppMethodBeat.o(103815);
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(103819);
    if (this.hge == null)
    {
      AppMethodBeat.o(103819);
      return;
    }
    this.hge.post(paramRunnable);
    AppMethodBeat.o(103819);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103825);
    this.hga.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103825);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103823);
    this.hga.a(paramJSONArray, parama);
    AppMethodBeat.o(103823);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103828);
    if (this.hgb.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(103828);
      return;
    }
    this.hgb.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103828);
  }
  
  public final void axT()
  {
    AppMethodBeat.i(103818);
    if (this.hge == null)
    {
      AppMethodBeat.o(103818);
      return;
    }
    this.hge.removeCallbacks(this.hgf);
    this.hge.post(this.hgf);
    AppMethodBeat.o(103818);
  }
  
  public final void axU()
  {
    AppMethodBeat.i(103827);
    this.hga.axU();
    AppMethodBeat.o(103827);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(103834);
    this.hga.axV();
    AppMethodBeat.o(103834);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103826);
    this.hga.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103826);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103824);
    this.hga.b(paramJSONArray, parama);
    AppMethodBeat.o(103824);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(103822);
    boolean bool = this.hga.f(paramCanvas);
    AppMethodBeat.o(103822);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(103820);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.hga.getDrawContext();
    AppMethodBeat.o(103820);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(103831);
    String str = this.hga.getSessionId();
    AppMethodBeat.o(103831);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(103817);
    String str = this.hga.getTraceId();
    AppMethodBeat.o(103817);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.hga.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103830);
    this.hga.onResume();
    AppMethodBeat.o(103830);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103835);
    com.tencent.luggage.g.d.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
    if (this.hge == null)
    {
      paramSurfaceTexture = com.tencent.mm.sdk.g.d.ey("MTextureView#Rending-Thread", -19);
      paramSurfaceTexture.start();
      this.hge = new ak(paramSurfaceTexture.getLooper());
    }
    paramSurfaceTexture = lockCanvas();
    if (paramSurfaceTexture == null)
    {
      AppMethodBeat.o(103835);
      return;
    }
    paramSurfaceTexture.drawColor(-1);
    unlockCanvasAndPost(paramSurfaceTexture);
    AppMethodBeat.o(103835);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    AppMethodBeat.i(103837);
    com.tencent.luggage.g.d.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
    this.hge.removeCallbacks(this.hgf);
    this.hge.getLooper().quit();
    synchronized (this.mLock)
    {
      boolean bool = this.hgh;
      if (bool) {}
      try
      {
        this.mLock.wait(1000L);
        this.hge = null;
        AppMethodBeat.o(103837);
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.luggage.g.d.e("MicroMsg.MTextureView", "await error : %s", new Object[] { Log.getStackTraceString(localInterruptedException) });
        }
      }
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103836);
    com.tencent.luggage.g.d.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
    AppMethodBeat.o(103836);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103829);
    this.hgb.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103829);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(103821);
    this.hga.setDrawActionReportable(parama);
    AppMethodBeat.o(103821);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(103832);
    this.hga.setSessionId(paramString);
    AppMethodBeat.o(103832);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(103833);
    this.hga.setStartTime(paramLong);
    AppMethodBeat.o(103833);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(103816);
    this.hga.setTraceId(paramString);
    AppMethodBeat.o(103816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView
 * JD-Core Version:    0.7.0.1
 */