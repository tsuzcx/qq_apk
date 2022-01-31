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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, a
{
  private final b hga;
  private final Set<View.OnAttachStateChangeListener> hgb;
  private SurfaceHolder hgd;
  private ak hge;
  private Runnable hgf;
  private volatile boolean mDestroyed;
  
  public MSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(103784);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    this.hgf = new MSurfaceView.1(this);
    init();
    AppMethodBeat.o(103784);
  }
  
  public MSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103785);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    this.hgf = new MSurfaceView.1(this);
    init();
    AppMethodBeat.o(103785);
  }
  
  public MSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103786);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    this.hgf = new MSurfaceView.1(this);
    init();
    AppMethodBeat.o(103786);
  }
  
  private void init()
  {
    AppMethodBeat.i(103787);
    this.hgd = getHolder();
    this.hgd.addCallback(this);
    this.hgd.setFormat(-3);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.hga.getDrawContext().heG = localPaint;
    AppMethodBeat.o(103787);
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(103795);
    if (this.hge == null)
    {
      AppMethodBeat.o(103795);
      return;
    }
    this.hge.post(paramRunnable);
    AppMethodBeat.o(103795);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103801);
    this.hga.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103801);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103799);
    this.hga.a(paramJSONArray, parama);
    AppMethodBeat.o(103799);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103804);
    if (this.hgb.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(103804);
      return;
    }
    this.hgb.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103804);
  }
  
  public final void axT()
  {
    AppMethodBeat.i(103794);
    B(new MSurfaceView.2(this));
    AppMethodBeat.o(103794);
  }
  
  public final void axU()
  {
    AppMethodBeat.i(103803);
    this.hga.axU();
    AppMethodBeat.o(103803);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(103810);
    this.hga.axV();
    AppMethodBeat.o(103810);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103802);
    this.hga.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103802);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103800);
    this.hga.b(paramJSONArray, parama);
    AppMethodBeat.o(103800);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103793);
    com.tencent.luggage.g.d.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[] { Integer.valueOf(hashCode()) });
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.draw(paramCanvas);
    AppMethodBeat.o(103793);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(103798);
    boolean bool = this.hga.f(paramCanvas);
    AppMethodBeat.o(103798);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(103796);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.hga.getDrawContext();
    AppMethodBeat.o(103796);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(103807);
    String str = this.hga.getSessionId();
    AppMethodBeat.o(103807);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(103792);
    String str = this.hga.getTraceId();
    AppMethodBeat.o(103792);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.hga.mPause;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103806);
    this.hga.onResume();
    AppMethodBeat.o(103806);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103805);
    this.hgb.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103805);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(103797);
    this.hga.setDrawActionReportable(parama);
    AppMethodBeat.o(103797);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(103808);
    this.hga.setSessionId(paramString);
    AppMethodBeat.o(103808);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(103809);
    this.hga.setStartTime(paramLong);
    AppMethodBeat.o(103809);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(103791);
    this.hga.setTraceId(paramString);
    AppMethodBeat.o(103791);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(103789);
    com.tencent.luggage.g.d.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(103789);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103788);
    com.tencent.luggage.g.d.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = false;
    if (this.hge == null)
    {
      paramSurfaceHolder = com.tencent.mm.sdk.g.d.ey("MSurfaceView#Rending-Thread", -19);
      paramSurfaceHolder.start();
      this.hge = new ak(paramSurfaceHolder.getLooper());
    }
    AppMethodBeat.o(103788);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103790);
    com.tencent.luggage.g.d.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.mDestroyed = true;
    this.hge.getLooper().quit();
    this.hge = null;
    AppMethodBeat.o(103790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView
 * JD-Core Version:    0.7.0.1
 */