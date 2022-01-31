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
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, a
{
  private final b fMQ = new b(this);
  private final Set<View.OnAttachStateChangeListener> fMR = new LinkedHashSet();
  private volatile ah fMU;
  private Runnable fMV = new MTextureView.1(this);
  private volatile boolean fMX;
  private volatile Object mLock = new Object();
  
  public MTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setSurfaceTextureListener(this);
    ((Activity)getContext()).getWindow().setFlags(16777216, 16777216);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.fMQ.getDrawContext().fLu = localPaint;
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fMQ.a(paramDrawCanvasArg, parama);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    this.fMQ.a(paramJSONArray, parama);
  }
  
  public final void adB()
  {
    if (this.fMU == null) {
      return;
    }
    this.fMU.removeCallbacks(this.fMV);
    this.fMU.post(this.fMV);
  }
  
  public final void adC()
  {
    this.fMQ.adC();
  }
  
  public final void adD()
  {
    this.fMQ.adD();
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    if (this.fMR.contains(paramOnAttachStateChangeListener)) {
      return;
    }
    this.fMR.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fMQ.b(paramDrawCanvasArg, parama);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    this.fMQ.b(paramJSONArray, parama);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    return this.fMQ.f(paramCanvas);
  }
  
  public d getDrawContext()
  {
    return this.fMQ.getDrawContext();
  }
  
  public String getSessionId()
  {
    return this.fMQ.getSessionId();
  }
  
  public String getTraceId()
  {
    return this.fMQ.getTraceId();
  }
  
  public final boolean isPaused()
  {
    return this.fMQ.fKW;
  }
  
  public final void onPause()
  {
    this.fMQ.onPause();
  }
  
  public final void onResume()
  {
    this.fMQ.onResume();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    c.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
    if (this.fMU == null)
    {
      paramSurfaceTexture = e.ds("MTextureView#Rending-Thread", -19);
      paramSurfaceTexture.start();
      this.fMU = new ah(paramSurfaceTexture.getLooper());
    }
    paramSurfaceTexture = lockCanvas();
    if (paramSurfaceTexture == null) {
      return;
    }
    paramSurfaceTexture.drawColor(-1);
    unlockCanvasAndPost(paramSurfaceTexture);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    c.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
    this.fMU.removeCallbacks(this.fMV);
    this.fMU.getLooper().quit();
    synchronized (this.mLock)
    {
      boolean bool = this.fMX;
      if (bool) {}
      try
      {
        this.mLock.wait(1000L);
        this.fMU = null;
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          c.e("MicroMsg.MTextureView", "await error : %s", new Object[] { Log.getStackTraceString(localInterruptedException) });
        }
      }
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    c.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.fMR.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.fMQ.setDrawActionReportable(parama);
  }
  
  public void setSessionId(String paramString)
  {
    this.fMQ.setSessionId(paramString);
  }
  
  public void setStartTime(long paramLong)
  {
    this.fMQ.setStartTime(paramLong);
  }
  
  public void setTraceId(String paramString)
  {
    this.fMQ.setTraceId(paramString);
  }
  
  public final void t(Runnable paramRunnable)
  {
    if (this.fMU == null) {
      return;
    }
    this.fMU.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView
 * JD-Core Version:    0.7.0.1
 */