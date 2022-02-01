package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, a
{
  private final b laI;
  private final Set<View.OnAttachStateChangeListener> laJ;
  private SurfaceHolder laL;
  private MMHandler laM;
  private Runnable laN;
  private volatile boolean mDestroyed;
  
  public MSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145470);
    this.laI = new b(this);
    this.laJ = new LinkedHashSet();
    this.laN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145468);
        if (MSurfaceView.a(MSurfaceView.this))
        {
          AppMethodBeat.o(145468);
          return;
        }
        Canvas localCanvas = MSurfaceView.b(MSurfaceView.this).lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145468);
          return;
        }
        localCanvas.drawColor(-1);
        MSurfaceView.this.o(localCanvas);
        MSurfaceView.b(MSurfaceView.this).unlockCanvasAndPost(localCanvas);
        AppMethodBeat.o(145468);
      }
    };
    init();
    AppMethodBeat.o(145470);
  }
  
  public MSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145471);
    this.laI = new b(this);
    this.laJ = new LinkedHashSet();
    this.laN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145468);
        if (MSurfaceView.a(MSurfaceView.this))
        {
          AppMethodBeat.o(145468);
          return;
        }
        Canvas localCanvas = MSurfaceView.b(MSurfaceView.this).lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145468);
          return;
        }
        localCanvas.drawColor(-1);
        MSurfaceView.this.o(localCanvas);
        MSurfaceView.b(MSurfaceView.this).unlockCanvasAndPost(localCanvas);
        AppMethodBeat.o(145468);
      }
    };
    init();
    AppMethodBeat.o(145471);
  }
  
  public MSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145472);
    this.laI = new b(this);
    this.laJ = new LinkedHashSet();
    this.laN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145468);
        if (MSurfaceView.a(MSurfaceView.this))
        {
          AppMethodBeat.o(145468);
          return;
        }
        Canvas localCanvas = MSurfaceView.b(MSurfaceView.this).lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145468);
          return;
        }
        localCanvas.drawColor(-1);
        MSurfaceView.this.o(localCanvas);
        MSurfaceView.b(MSurfaceView.this).unlockCanvasAndPost(localCanvas);
        AppMethodBeat.o(145468);
      }
    };
    init();
    AppMethodBeat.o(145472);
  }
  
  private void init()
  {
    AppMethodBeat.i(145473);
    this.laL = getHolder();
    this.laL.addCallback(this);
    this.laL.setFormat(-3);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.laI.getDrawContext().kZq = localPaint;
    AppMethodBeat.o(145473);
  }
  
  public final void U(Runnable paramRunnable)
  {
    AppMethodBeat.i(145481);
    if (this.laM == null)
    {
      AppMethodBeat.o(145481);
      return;
    }
    this.laM.post(paramRunnable);
    AppMethodBeat.o(145481);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145487);
    this.laI.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145487);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145485);
    this.laI.a(paramJSONArray, parama);
    AppMethodBeat.o(145485);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145490);
    if (this.laJ.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145490);
      return;
    }
    this.laJ.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145490);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145488);
    this.laI.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145488);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145486);
    this.laI.b(paramJSONArray, parama);
    AppMethodBeat.o(145486);
  }
  
  public final void bzg()
  {
    AppMethodBeat.i(145480);
    U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145469);
        if (MSurfaceView.a(MSurfaceView.this))
        {
          AppMethodBeat.o(145469);
          return;
        }
        Canvas localCanvas = MSurfaceView.b(MSurfaceView.this).lockCanvas();
        if (localCanvas == null)
        {
          AppMethodBeat.o(145469);
          return;
        }
        localCanvas.drawColor(-1);
        MSurfaceView.this.o(localCanvas);
        MSurfaceView.b(MSurfaceView.this).unlockCanvasAndPost(localCanvas);
        AppMethodBeat.o(145469);
      }
    });
    AppMethodBeat.o(145480);
  }
  
  public final void bzh()
  {
    AppMethodBeat.i(145489);
    this.laI.bzh();
    AppMethodBeat.o(145489);
  }
  
  public final void bzi()
  {
    AppMethodBeat.i(145496);
    this.laI.bzi();
    AppMethodBeat.o(145496);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145479);
    Log.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[] { Integer.valueOf(hashCode()) });
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.draw(paramCanvas);
    AppMethodBeat.o(145479);
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(145482);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.laI.getDrawContext();
    AppMethodBeat.o(145482);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145493);
    String str = this.laI.getSessionId();
    AppMethodBeat.o(145493);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145478);
    String str = this.laI.getTraceId();
    AppMethodBeat.o(145478);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.laI.mPause;
  }
  
  public final boolean o(Canvas paramCanvas)
  {
    AppMethodBeat.i(145484);
    boolean bool = this.laI.o(paramCanvas);
    AppMethodBeat.o(145484);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145492);
    this.laI.onResume();
    AppMethodBeat.o(145492);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145491);
    this.laJ.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145491);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145483);
    this.laI.setDrawActionReportable(parama);
    AppMethodBeat.o(145483);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145494);
    this.laI.setSessionId(paramString);
    AppMethodBeat.o(145494);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145495);
    this.laI.setStartTime(paramLong);
    AppMethodBeat.o(145495);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145477);
    this.laI.setTraceId(paramString);
    AppMethodBeat.o(145477);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(145475);
    Log.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(145475);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(145474);
    Log.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = false;
    if (this.laM == null)
    {
      paramSurfaceHolder = com.tencent.f.c.d.hz("MSurfaceView#Rending-Thread", -19);
      paramSurfaceHolder.start();
      this.laM = new MMHandler(paramSurfaceHolder.getLooper());
    }
    AppMethodBeat.o(145474);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(145476);
    Log.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = true;
    this.laM.getLooper().quit();
    this.laM = null;
    AppMethodBeat.o(145476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView
 * JD-Core Version:    0.7.0.1
 */