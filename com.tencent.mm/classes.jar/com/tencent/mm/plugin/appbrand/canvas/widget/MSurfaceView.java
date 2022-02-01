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
  private volatile boolean mDestroyed;
  private final b qUB;
  private final Set<View.OnAttachStateChangeListener> qUC;
  private SurfaceHolder qUE;
  private MMHandler qUF;
  private Runnable qUG;
  
  public MSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145470);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    this.qUG = new Runnable()
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
        MSurfaceView.this.l(localCanvas);
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
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    this.qUG = new Runnable()
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
        MSurfaceView.this.l(localCanvas);
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
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    this.qUG = new Runnable()
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
        MSurfaceView.this.l(localCanvas);
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
    this.qUE = getHolder();
    this.qUE.addCallback(this);
    this.qUE.setFormat(-3);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.qUB.getDrawContext().qTn = localPaint;
    AppMethodBeat.o(145473);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145487);
    this.qUB.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145487);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145485);
    this.qUB.a(paramJSONArray, parama);
    AppMethodBeat.o(145485);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(145481);
    if (this.qUF == null)
    {
      AppMethodBeat.o(145481);
      return;
    }
    this.qUF.post(paramRunnable);
    AppMethodBeat.o(145481);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145490);
    if (this.qUC.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145490);
      return;
    }
    this.qUC.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145490);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145488);
    this.qUB.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145488);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145486);
    this.qUB.b(paramJSONArray, parama);
    AppMethodBeat.o(145486);
  }
  
  public final void cjV()
  {
    AppMethodBeat.i(145480);
    ab(new Runnable()
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
        MSurfaceView.this.l(localCanvas);
        MSurfaceView.b(MSurfaceView.this).unlockCanvasAndPost(localCanvas);
        AppMethodBeat.o(145469);
      }
    });
    AppMethodBeat.o(145480);
  }
  
  public final void cjW()
  {
    AppMethodBeat.i(145489);
    this.qUB.cjW();
    AppMethodBeat.o(145489);
  }
  
  public final void cjX()
  {
    AppMethodBeat.i(145496);
    this.qUB.cjX();
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
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.qUB.getDrawContext();
    AppMethodBeat.o(145482);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145493);
    String str = this.qUB.getSessionId();
    AppMethodBeat.o(145493);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145478);
    String str = this.qUB.getTraceId();
    AppMethodBeat.o(145478);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.qUB.mPause;
  }
  
  public final boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(145484);
    boolean bool = this.qUB.l(paramCanvas);
    AppMethodBeat.o(145484);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145492);
    this.qUB.onResume();
    AppMethodBeat.o(145492);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145491);
    this.qUC.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145491);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145483);
    this.qUB.setDrawActionReportable(parama);
    AppMethodBeat.o(145483);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145494);
    this.qUB.setSessionId(paramString);
    AppMethodBeat.o(145494);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145495);
    this.qUB.setStartTime(paramLong);
    AppMethodBeat.o(145495);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145477);
    this.qUB.setTraceId(paramString);
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
    if (this.qUF == null)
    {
      paramSurfaceHolder = com.tencent.threadpool.c.d.jv("MSurfaceView#Rending-Thread", -19);
      paramSurfaceHolder.start();
      this.qUF = new MMHandler(paramSurfaceHolder.getLooper());
    }
    AppMethodBeat.o(145474);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(145476);
    Log.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = true;
    this.qUF.getLooper().quit();
    this.qUF = null;
    AppMethodBeat.o(145476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView
 * JD-Core Version:    0.7.0.1
 */