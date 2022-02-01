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
  private final b jal;
  private final Set<View.OnAttachStateChangeListener> jam;
  private SurfaceHolder jao;
  private ap jap;
  private Runnable jaq;
  private volatile boolean mDestroyed;
  
  public MSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145470);
    this.jal = new b(this);
    this.jam = new LinkedHashSet();
    this.jaq = new Runnable()
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
    this.jal = new b(this);
    this.jam = new LinkedHashSet();
    this.jaq = new Runnable()
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
    this.jal = new b(this);
    this.jam = new LinkedHashSet();
    this.jaq = new Runnable()
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
    this.jao = getHolder();
    this.jao.addCallback(this);
    this.jao.setFormat(-3);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.jal.getDrawContext().iYQ = localPaint;
    AppMethodBeat.o(145473);
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(145481);
    if (this.jap == null)
    {
      AppMethodBeat.o(145481);
      return;
    }
    this.jap.post(paramRunnable);
    AppMethodBeat.o(145481);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145487);
    this.jal.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145487);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145485);
    this.jal.a(paramJSONArray, parama);
    AppMethodBeat.o(145485);
  }
  
  public final void aSM()
  {
    AppMethodBeat.i(145480);
    Q(new Runnable()
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
  
  public final void aSN()
  {
    AppMethodBeat.i(145489);
    this.jal.aSN();
    AppMethodBeat.o(145489);
  }
  
  public final void aSO()
  {
    AppMethodBeat.i(145496);
    this.jal.aSO();
    AppMethodBeat.o(145496);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145490);
    if (this.jam.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145490);
      return;
    }
    this.jam.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145490);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145488);
    this.jal.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145488);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145486);
    this.jal.b(paramJSONArray, parama);
    AppMethodBeat.o(145486);
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
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.jal.getDrawContext();
    AppMethodBeat.o(145482);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145493);
    String str = this.jal.getSessionId();
    AppMethodBeat.o(145493);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145478);
    String str = this.jal.getTraceId();
    AppMethodBeat.o(145478);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(145484);
    boolean bool = this.jal.h(paramCanvas);
    AppMethodBeat.o(145484);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.jal.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145492);
    this.jal.onResume();
    AppMethodBeat.o(145492);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145491);
    this.jam.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145491);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145483);
    this.jal.setDrawActionReportable(parama);
    AppMethodBeat.o(145483);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145494);
    this.jal.setSessionId(paramString);
    AppMethodBeat.o(145494);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145495);
    this.jal.setStartTime(paramLong);
    AppMethodBeat.o(145495);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145477);
    this.jal.setTraceId(paramString);
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
    if (this.jap == null)
    {
      paramSurfaceHolder = com.tencent.e.c.d.gu("MSurfaceView#Rending-Thread", -19);
      paramSurfaceHolder.start();
      this.jap = new ap(paramSurfaceHolder.getLooper());
    }
    AppMethodBeat.o(145474);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(145476);
    ad.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = true;
    this.jap.getLooper().quit();
    this.jap = null;
    AppMethodBeat.o(145476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView
 * JD-Core Version:    0.7.0.1
 */