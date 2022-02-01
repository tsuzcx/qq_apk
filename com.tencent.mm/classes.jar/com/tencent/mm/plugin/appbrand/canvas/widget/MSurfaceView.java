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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, a
{
  private final b jUt;
  private final Set<View.OnAttachStateChangeListener> jUu;
  private SurfaceHolder jUw;
  private ap jUx;
  private Runnable jUy;
  private volatile boolean mDestroyed;
  
  public MSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145470);
    this.jUt = new b(this);
    this.jUu = new LinkedHashSet();
    this.jUy = new Runnable()
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
        MSurfaceView.this.h(localCanvas);
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
    this.jUt = new b(this);
    this.jUu = new LinkedHashSet();
    this.jUy = new Runnable()
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
        MSurfaceView.this.h(localCanvas);
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
    this.jUt = new b(this);
    this.jUu = new LinkedHashSet();
    this.jUy = new Runnable()
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
        MSurfaceView.this.h(localCanvas);
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
    this.jUw = getHolder();
    this.jUw.addCallback(this);
    this.jUw.setFormat(-3);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.jUt.getDrawContext().jTd = localPaint;
    AppMethodBeat.o(145473);
  }
  
  public final void R(Runnable paramRunnable)
  {
    AppMethodBeat.i(145481);
    if (this.jUx == null)
    {
      AppMethodBeat.o(145481);
      return;
    }
    this.jUx.post(paramRunnable);
    AppMethodBeat.o(145481);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145487);
    this.jUt.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145487);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145485);
    this.jUt.a(paramJSONArray, parama);
    AppMethodBeat.o(145485);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145490);
    if (this.jUu.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145490);
      return;
    }
    this.jUu.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145490);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145488);
    this.jUt.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145488);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145486);
    this.jUt.b(paramJSONArray, parama);
    AppMethodBeat.o(145486);
  }
  
  public final void bdk()
  {
    AppMethodBeat.i(145480);
    R(new Runnable()
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
        MSurfaceView.this.h(localCanvas);
        MSurfaceView.b(MSurfaceView.this).unlockCanvasAndPost(localCanvas);
        AppMethodBeat.o(145469);
      }
    });
    AppMethodBeat.o(145480);
  }
  
  public final void bdl()
  {
    AppMethodBeat.i(145489);
    this.jUt.bdl();
    AppMethodBeat.o(145489);
  }
  
  public final void bdm()
  {
    AppMethodBeat.i(145496);
    this.jUt.bdm();
    AppMethodBeat.o(145496);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145479);
    ad.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[] { Integer.valueOf(hashCode()) });
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.draw(paramCanvas);
    AppMethodBeat.o(145479);
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(145482);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.jUt.getDrawContext();
    AppMethodBeat.o(145482);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145493);
    String str = this.jUt.getSessionId();
    AppMethodBeat.o(145493);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145478);
    String str = this.jUt.getTraceId();
    AppMethodBeat.o(145478);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(145484);
    boolean bool = this.jUt.h(paramCanvas);
    AppMethodBeat.o(145484);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.jUt.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145492);
    this.jUt.onResume();
    AppMethodBeat.o(145492);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145491);
    this.jUu.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145491);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145483);
    this.jUt.setDrawActionReportable(parama);
    AppMethodBeat.o(145483);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145494);
    this.jUt.setSessionId(paramString);
    AppMethodBeat.o(145494);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145495);
    this.jUt.setStartTime(paramLong);
    AppMethodBeat.o(145495);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145477);
    this.jUt.setTraceId(paramString);
    AppMethodBeat.o(145477);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(145475);
    ad.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(145475);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(145474);
    ad.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = false;
    if (this.jUx == null)
    {
      paramSurfaceHolder = com.tencent.e.c.d.gW("MSurfaceView#Rending-Thread", -19);
      paramSurfaceHolder.start();
      this.jUx = new ap(paramSurfaceHolder.getLooper());
    }
    AppMethodBeat.o(145474);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(145476);
    ad.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = true;
    this.jUx.getLooper().quit();
    this.jUx = null;
    AppMethodBeat.o(145476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView
 * JD-Core Version:    0.7.0.1
 */