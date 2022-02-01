package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, a
{
  private volatile Object mLock;
  private final b qUB;
  private final Set<View.OnAttachStateChangeListener> qUC;
  private volatile MMHandler qUF;
  private Runnable qUG;
  private volatile boolean qUI;
  
  public MTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145498);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    this.mLock = new Object();
    this.qUG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145497);
        if (!MTextureView.this.isAvailable())
        {
          AppMethodBeat.o(145497);
          return;
        }
        Canvas localCanvas = MTextureView.this.lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145497);
          return;
        }
        synchronized (MTextureView.a(MTextureView.this))
        {
          MTextureView.a(MTextureView.this, true);
          localCanvas.drawColor(-1);
          MTextureView.this.l(localCanvas);
          MTextureView.this.unlockCanvasAndPost(localCanvas);
        }
        synchronized (MTextureView.a(MTextureView.this))
        {
          MTextureView.a(MTextureView.this, false);
          MTextureView.a(MTextureView.this).notifyAll();
          AppMethodBeat.o(145497);
          return;
          localObject2 = finally;
          AppMethodBeat.o(145497);
          throw localObject2;
        }
      }
    };
    init();
    AppMethodBeat.o(145498);
  }
  
  public MTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145499);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    this.mLock = new Object();
    this.qUG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145497);
        if (!MTextureView.this.isAvailable())
        {
          AppMethodBeat.o(145497);
          return;
        }
        Canvas localCanvas = MTextureView.this.lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145497);
          return;
        }
        synchronized (MTextureView.a(MTextureView.this))
        {
          MTextureView.a(MTextureView.this, true);
          localCanvas.drawColor(-1);
          MTextureView.this.l(localCanvas);
          MTextureView.this.unlockCanvasAndPost(localCanvas);
        }
        synchronized (MTextureView.a(MTextureView.this))
        {
          MTextureView.a(MTextureView.this, false);
          MTextureView.a(MTextureView.this).notifyAll();
          AppMethodBeat.o(145497);
          return;
          localObject2 = finally;
          AppMethodBeat.o(145497);
          throw localObject2;
        }
      }
    };
    init();
    AppMethodBeat.o(145499);
  }
  
  public MTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145500);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    this.mLock = new Object();
    this.qUG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145497);
        if (!MTextureView.this.isAvailable())
        {
          AppMethodBeat.o(145497);
          return;
        }
        Canvas localCanvas = MTextureView.this.lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145497);
          return;
        }
        synchronized (MTextureView.a(MTextureView.this))
        {
          MTextureView.a(MTextureView.this, true);
          localCanvas.drawColor(-1);
          MTextureView.this.l(localCanvas);
          MTextureView.this.unlockCanvasAndPost(localCanvas);
        }
        synchronized (MTextureView.a(MTextureView.this))
        {
          MTextureView.a(MTextureView.this, false);
          MTextureView.a(MTextureView.this).notifyAll();
          AppMethodBeat.o(145497);
          return;
          localObject2 = finally;
          AppMethodBeat.o(145497);
          throw localObject2;
        }
      }
    };
    init();
    AppMethodBeat.o(145500);
  }
  
  private void init()
  {
    AppMethodBeat.i(145501);
    setSurfaceTextureListener(this);
    ((Activity)getContext()).getWindow().setFlags(16777216, 16777216);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.qUB.getDrawContext().qTn = localPaint;
    AppMethodBeat.o(145501);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145511);
    this.qUB.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145511);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145509);
    this.qUB.a(paramJSONArray, parama);
    AppMethodBeat.o(145509);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(145505);
    if (this.qUF == null)
    {
      AppMethodBeat.o(145505);
      return;
    }
    this.qUF.post(paramRunnable);
    AppMethodBeat.o(145505);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145514);
    if (this.qUC.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145514);
      return;
    }
    this.qUC.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145514);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145512);
    this.qUB.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145512);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145510);
    this.qUB.b(paramJSONArray, parama);
    AppMethodBeat.o(145510);
  }
  
  public final void cjV()
  {
    AppMethodBeat.i(145504);
    if (this.qUF == null)
    {
      AppMethodBeat.o(145504);
      return;
    }
    this.qUF.removeCallbacks(this.qUG);
    this.qUF.post(this.qUG);
    AppMethodBeat.o(145504);
  }
  
  public final void cjW()
  {
    AppMethodBeat.i(145513);
    this.qUB.cjW();
    AppMethodBeat.o(145513);
  }
  
  public final void cjX()
  {
    AppMethodBeat.i(145520);
    this.qUB.cjX();
    AppMethodBeat.o(145520);
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(145506);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.qUB.getDrawContext();
    AppMethodBeat.o(145506);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145517);
    String str = this.qUB.getSessionId();
    AppMethodBeat.o(145517);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145503);
    String str = this.qUB.getTraceId();
    AppMethodBeat.o(145503);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.qUB.mPause;
  }
  
  public final boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(145508);
    boolean bool = this.qUB.l(paramCanvas);
    AppMethodBeat.o(145508);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145516);
    this.qUB.onResume();
    AppMethodBeat.o(145516);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145521);
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
    if (this.qUF == null)
    {
      paramSurfaceTexture = com.tencent.threadpool.c.d.jv("MTextureView#Rending-Thread", -19);
      paramSurfaceTexture.start();
      this.qUF = new MMHandler(paramSurfaceTexture.getLooper());
    }
    paramSurfaceTexture = lockCanvas();
    if (paramSurfaceTexture == null)
    {
      AppMethodBeat.o(145521);
      return;
    }
    paramSurfaceTexture.drawColor(-1);
    unlockCanvasAndPost(paramSurfaceTexture);
    AppMethodBeat.o(145521);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1)
  {
    AppMethodBeat.i(145523);
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
    this.qUF.removeCallbacks(this.qUG);
    this.qUF.getLooper().quit();
    synchronized (this.mLock)
    {
      boolean bool = this.qUI;
      if (bool) {}
      try
      {
        this.mLock.wait(1000L);
        this.qUF = null;
        AppMethodBeat.o(145523);
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MTextureView", "await error : %s", new Object[] { android.util.Log.getStackTraceString(localInterruptedException) });
        }
      }
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145522);
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
    AppMethodBeat.o(145522);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145515);
    this.qUC.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145515);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145507);
    this.qUB.setDrawActionReportable(parama);
    AppMethodBeat.o(145507);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145518);
    this.qUB.setSessionId(paramString);
    AppMethodBeat.o(145518);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145519);
    this.qUB.setStartTime(paramLong);
    AppMethodBeat.o(145519);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145502);
    this.qUB.setTraceId(paramString);
    AppMethodBeat.o(145502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView
 * JD-Core Version:    0.7.0.1
 */