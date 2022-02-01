package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.c.c.b;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.report.service.h;
import kotlin.a.e;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "originPivot", "", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final TextEditorItemView.a rvD;
  private final String TAG;
  private float aXt;
  private float aXu;
  private final float bottomMargin;
  private boolean daZ;
  private boolean gZU;
  private float gZX;
  private float gZY;
  private final float ovb;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
  private final Path rqV;
  private boolean rqX;
  private boolean rqY;
  private final float rrb;
  private final float[] rrd;
  private RectF ruR;
  private boolean rvA;
  private final PointF rvB;
  private final PointF rvC;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c rvm;
  private String[] rvo;
  private Typeface[] rvp;
  private int rvq;
  private final Runnable rvr;
  private final Paint rvs;
  private final float rvt;
  private final Path rvu;
  private final RectF rvv;
  private final int rvw;
  private int rvx;
  private final Bitmap[] rvy;
  private final float rvz;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(804);
    rvD = new TextEditorItemView.a((byte)0);
    AppMethodBeat.o(804);
  }
  
  public TextEditorItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextEditorItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextEditorItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(803);
    this.TAG = "MicroMsg.TextEditorItemView";
    this.rvr = ((Runnable)new d(this));
    this.rvs = new Paint(1);
    this.rvu = new Path();
    this.rvv = new RectF();
    this.ruR = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.rvB = new PointF();
    this.rvC = new PointF();
    this.rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.rqV = new Path();
    this.aXt = 2.0F;
    this.aXu = 0.25F;
    this.rrd = new float[2];
    if (paramContext == null) {
      p.hyc();
    }
    float f = paramContext.getResources().getDimension(2131166235);
    int i;
    if (com.tencent.mm.aq.b.bby().bbB())
    {
      paramAttributeSet = d.roA;
      if (d.a.cIM())
      {
        p.g(com.tencent.mm.aq.b.bby(), "FontResLogic.getInstance()");
        paramAttributeSet = com.tencent.mm.aq.b.bbC();
        p.g(paramAttributeSet, "FontResLogic.getInstance().fontPath");
        this.rvo = paramAttributeSet;
        paramAttributeSet = d.roA;
        this.rvm = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.rvo, (int)f));
        i = this.rvo.length;
        paramAttributeSet = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.rvo[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.rvp = paramAttributeSet;; this.rvp = new Typeface[] { null })
    {
      this.rvw = this.rvp.length;
      i = this.rvw;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.rvo = new String[] { "" };
      h.CyF.F(933L, 3L);
      this.rvm = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.rvy = paramAttributeSet;
    cJQ();
    this.rrb = getResources().getDimension(2131166232);
    this.rvt = getResources().getDimension(2131166233);
    this.rvs.setColor(-1);
    this.rvs.setStyle(Paint.Style.STROKE);
    this.rvs.setStrokeWidth(this.rvt);
    this.rvC.set(this.rrb, this.rrb);
    this.bottomMargin = getResources().getDimension(2131166231);
    this.rvz = getResources().getDimension(2131166234);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.ovb = paramContext.getScaledTouchSlop();
    this.rqT.aXt = this.aXt;
    this.rqT.aXu = this.aXu;
    AppMethodBeat.o(803);
  }
  
  private final void cJQ()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.daZ)
    {
      this.rvx += 1;
      this.rvx %= this.rvw;
      localObject = this.rvp[this.rvq];
      this.rvm.anr(this.rvo[this.rvq]);
      this.rvq += 1;
      this.rvq %= this.rvp.length;
      if (this.rvy[this.rvx] == null)
      {
        localObject = d((Typeface)localObject);
        this.rvy[this.rvx] = localObject;
        fL(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.rvr);
      postDelayed(this.rvr, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.rvy[this.rvx] == null)
      {
        localObject = this.rvp[0];
        this.rvm.anr(this.rvo[this.rvq]);
        localObject = d((Typeface)localObject);
        this.rvy[this.rvx] = localObject;
        fL(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void cJR()
  {
    AppMethodBeat.i(799);
    this.rqT.gT.setTranslate(this.rvB.x, this.rvB.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.ruR.width());
    localFontTextView.setTextDrawer(this.rvm);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.ruR.width() - 2.0F * this.rvz), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    p.g(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void fL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.rrb * 2.0F;
    float f2 = paramInt2 + this.rrb * 2.0F;
    float f3 = this.rvv.width();
    float f4 = this.rvv.height();
    if (this.rvv.isEmpty()) {
      this.rvB.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.rvv.set(0.0F, 0.0F, f1, f2);
      this.rvu.reset();
      this.rvu.addRoundRect(this.rvv, this.rrb, this.rrb, Path.Direction.CW);
      this.rqT.gT.preTranslate((this.rqT.width - f1) / 2.0F, this.rqT.height - f2);
      if (!this.daZ) {
        cJR();
      }
      this.rqT.width = ((int)f1);
      this.rqT.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.rvB.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  private final void refresh()
  {
    AppMethodBeat.i(796);
    e.P(this.rvy);
    this.rvx = 0;
    this.rvq = 0;
    cJQ();
    AppMethodBeat.o(796);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    p.h(paramRectF, "bounds");
    this.ruR.set(paramRectF);
    this.rqV.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.rvB.set(paramRectF.left + paramRectF.width() / 2.0F - this.rvv.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.rvv.height());
    cJR();
    AppMethodBeat.o(790);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(793);
    if (paramBoolean)
    {
      this.text = paramCharSequence;
      this.textColor = paramInt;
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.Gp(this.textColor);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
        break label72;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label77;
      }
    }
    label72:
    label77:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.daZ = paramBoolean;
      refresh();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(256450);
    if (!this.daZ)
    {
      AppMethodBeat.o(256450);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.rqT.gT);
    localMatrix.postTranslate(this.rvC.x, this.rvC.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b(this.rvy, localMatrix);
    AppMethodBeat.o(256450);
    return paramMatrix;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO()
  {
    return null;
  }
  
  public final boolean cJP()
  {
    AppMethodBeat.i(792);
    a((CharSequence)"", 0, true);
    post((Runnable)new b(this));
    AppMethodBeat.o(792);
    return true;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(801);
    Object localObject = getParent();
    p.g(localObject, "parent");
    if ((((ViewParent)localObject).getParent() instanceof EditorItemContainer))
    {
      localObject = getParent();
      p.g(localObject, "parent");
      localObject = ((ViewParent)localObject).getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
        AppMethodBeat.o(801);
        throw ((Throwable)localObject);
      }
      localObject = (EditorItemContainer)localObject;
      AppMethodBeat.o(801);
      return localObject;
    }
    AppMethodBeat.o(801);
    return null;
  }
  
  public final CharSequence getText()
  {
    if (this.daZ) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.daZ) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    p.h(paramCanvas, "canvas");
    if (this.rqY) {
      paramCanvas.clipPath(this.rqV);
    }
    paramCanvas.save();
    paramCanvas.concat(this.rqT.gT);
    if (this.rqX) {
      paramCanvas.drawPath(this.rvu, this.rvs);
    }
    Bitmap localBitmap = this.rvy[this.rvx];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.rvC.x, this.rvC.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    p.h(paramMotionEvent, "event");
    boolean bool = this.rqT.Y(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.daZ) {
          cJR();
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(794);
      return bool;
      AppMethodBeat.o(794);
      return false;
      this.rvA = this.rqX;
      this.gZU = false;
      this.gZX = paramMotionEvent.getX();
      this.gZY = paramMotionEvent.getY();
      this.rqY = true;
      this.rrd[0] = (this.rqT.width / 2.0F);
      this.rrd[1] = (this.rqT.height / 2.0F);
      this.rqT.gT.mapPoints(this.rrd);
      break;
      this.rqY = false;
      if ((Math.abs(paramMotionEvent.getX() - this.gZX) <= this.ovb) && (Math.abs(paramMotionEvent.getY() - this.gZY) <= this.ovb)) {
        break;
      }
      this.gZU = true;
      break;
      this.rqY = true;
      if (((!this.daZ) || (this.rvA)) && (!this.gZU)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aXu = this.aXu;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aXt = this.aXt;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).n(new float[] { this.rvv.width() / 2.0F, this.rvv.height() / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.ruR.left, this.ruR.top, this.ruR.right, this.ruR.bottom));
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (this.rqT.width / 2.0F);
      arrayOfFloat[1] = (this.rqT.height / 2.0F);
      this.rqT.gT.mapPoints(arrayOfFloat);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).CgM.contains(arrayOfFloat[0], arrayOfFloat[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).a(this.rqT.gT, (m)new c(this));
      break;
      if (this.daZ) {
        break;
      }
      AppMethodBeat.o(794);
      return false;
      localObject = getItemContainer();
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((a)this, paramMotionEvent);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(789);
    removeCallbacks(this.rvr);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    cJQ();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.rqX = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(785);
      EditorItemContainer localEditorItemContainer = this.rvE.getItemContainer();
      if (localEditorItemContainer != null)
      {
        localEditorItemContainer.setEditing((a)this.rvE);
        AppMethodBeat.o(785);
        return;
      }
      AppMethodBeat.o(785);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends q
    implements m<Matrix, Boolean, x>
  {
    c(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(787);
      TextEditorItemView.c(this.rvE);
      AppMethodBeat.o(787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */