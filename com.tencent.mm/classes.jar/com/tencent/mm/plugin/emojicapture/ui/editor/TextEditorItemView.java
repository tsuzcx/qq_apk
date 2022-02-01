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
import com.tencent.mm.plugin.emojicapture.a.d;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "originPivot", "", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final a vbh;
  private CharSequence LV;
  private final String TAG;
  private float aGN;
  private float aGO;
  private final float bottomMargin;
  private boolean cSY;
  private boolean jKV;
  private float jKY;
  private float jKZ;
  private final float rxD;
  private int strokeColor;
  private int textColor;
  private final Path uWB;
  private boolean uWD;
  private boolean uWE;
  private final float uWH;
  private final float[] uWJ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c uWz;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c vaQ;
  private String[] vaS;
  private Typeface[] vaT;
  private int vaU;
  private final Runnable vaV;
  private final Paint vaW;
  private final float vaX;
  private final Path vaY;
  private final RectF vaZ;
  private RectF vav;
  private final int vba;
  private int vbb;
  private final Bitmap[] vbc;
  private final float vbd;
  private boolean vbe;
  private final PointF vbf;
  private final PointF vbg;
  
  static
  {
    AppMethodBeat.i(804);
    vbh = new a((byte)0);
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
    this.vaV = ((Runnable)new d(this));
    this.vaW = new Paint(1);
    this.vaY = new Path();
    this.vaZ = new RectF();
    this.vav = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.vbf = new PointF();
    this.vbg = new PointF();
    this.uWz = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.uWB = new Path();
    this.aGN = 2.0F;
    this.aGO = 0.25F;
    this.uWJ = new float[2];
    if (paramContext == null) {
      p.iCn();
    }
    float f = paramContext.getResources().getDimension(a.d.uRi);
    int i;
    if (com.tencent.mm.at.b.bkO().bkR())
    {
      paramAttributeSet = d.uUg;
      if (d.a.cXv())
      {
        p.j(com.tencent.mm.at.b.bkO(), "FontResLogic.getInstance()");
        paramAttributeSet = com.tencent.mm.at.b.bkS();
        p.j(paramAttributeSet, "FontResLogic.getInstance().fontPath");
        this.vaS = paramAttributeSet;
        paramAttributeSet = d.uUg;
        this.vaQ = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.vaS, (int)f));
        i = this.vaS.length;
        paramAttributeSet = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.vaS[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.vaT = paramAttributeSet;; this.vaT = new Typeface[] { null })
    {
      this.vba = this.vaT.length;
      i = this.vba;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.vaS = new String[] { "" };
      h.IzE.F(933L, 3L);
      this.vaQ = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.vbc = paramAttributeSet;
    cYA();
    this.uWH = getResources().getDimension(a.d.uRf);
    this.vaX = getResources().getDimension(a.d.uRg);
    this.vaW.setColor(-1);
    this.vaW.setStyle(Paint.Style.STROKE);
    this.vaW.setStrokeWidth(this.vaX);
    this.vbg.set(this.uWH, this.uWH);
    this.bottomMargin = getResources().getDimension(a.d.uRe);
    this.vbd = getResources().getDimension(a.d.uRh);
    paramContext = ViewConfiguration.get(paramContext);
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.rxD = paramContext.getScaledTouchSlop();
    this.uWz.aGN = this.aGN;
    this.uWz.aGO = this.aGO;
    AppMethodBeat.o(803);
  }
  
  private final void bfU()
  {
    AppMethodBeat.i(796);
    e.R(this.vbc);
    this.vbb = 0;
    this.vaU = 0;
    cYA();
    AppMethodBeat.o(796);
  }
  
  private final void cYA()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.cSY)
    {
      this.vbb += 1;
      this.vbb %= this.vba;
      localObject = this.vaT[this.vaU];
      this.vaQ.avq(this.vaS[this.vaU]);
      this.vaU += 1;
      this.vaU %= this.vaT.length;
      if (this.vbc[this.vbb] == null)
      {
        localObject = e((Typeface)localObject);
        this.vbc[this.vbb] = localObject;
        gi(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.vaV);
      postDelayed(this.vaV, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.vbc[this.vbb] == null)
      {
        localObject = this.vaT[0];
        this.vaQ.avq(this.vaS[this.vaU]);
        localObject = e((Typeface)localObject);
        this.vbc[this.vbb] = localObject;
        gi(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void cYB()
  {
    AppMethodBeat.i(799);
    this.uWz.aHZ.setTranslate(this.vbf.x, this.vbf.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap e(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.vav.width());
    localFontTextView.setTextDrawer(this.vaQ);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.LV, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.vav.width() - 2.0F * this.vbd), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    p.j(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.uWH * 2.0F;
    float f2 = paramInt2 + this.uWH * 2.0F;
    float f3 = this.vaZ.width();
    float f4 = this.vaZ.height();
    if (this.vaZ.isEmpty()) {
      this.vbf.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.vaZ.set(0.0F, 0.0F, f1, f2);
      this.vaY.reset();
      this.vaY.addRoundRect(this.vaZ, this.uWH, this.uWH, Path.Direction.CW);
      this.uWz.aHZ.preTranslate((this.uWz.width - f1) / 2.0F, this.uWz.height - f2);
      if (!this.cSY) {
        cYB();
      }
      this.uWz.width = ((int)f1);
      this.uWz.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.vbf.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    p.k(paramRectF, "bounds");
    this.vav.set(paramRectF);
    this.uWB.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.vbf.set(paramRectF.left + paramRectF.width() / 2.0F - this.vaZ.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.vaZ.height());
    cYB();
    AppMethodBeat.o(790);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(793);
    setContentDescription(paramCharSequence);
    if (paramBoolean)
    {
      this.LV = paramCharSequence;
      this.textColor = paramInt;
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.JW(this.textColor);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
        break label77;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label82;
      }
    }
    label77:
    label82:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.cSY = paramBoolean;
      bfU();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(204218);
    if (!this.cSY)
    {
      AppMethodBeat.o(204218);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.uWz.aHZ);
    localMatrix.postTranslate(this.vbg.x, this.vbg.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b(this.vbc, localMatrix);
    AppMethodBeat.o(204218);
    return paramMatrix;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a cYy()
  {
    return null;
  }
  
  public final boolean cYz()
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
    p.j(localObject, "parent");
    if ((((ViewParent)localObject).getParent() instanceof EditorItemContainer))
    {
      localObject = getParent();
      p.j(localObject, "parent");
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
    if (this.cSY) {
      return this.LV;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.cSY) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    p.k(paramCanvas, "canvas");
    if (this.uWE) {
      paramCanvas.clipPath(this.uWB);
    }
    paramCanvas.save();
    paramCanvas.concat(this.uWz.aHZ);
    if (this.uWD) {
      paramCanvas.drawPath(this.vaY, this.vaW);
    }
    Bitmap localBitmap = this.vbc[this.vbb];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.vbg.x, this.vbg.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    p.k(paramMotionEvent, "event");
    boolean bool = this.uWz.ah(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.cSY) {
          cYB();
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
      this.vbe = this.uWD;
      this.jKV = false;
      this.jKY = paramMotionEvent.getX();
      this.jKZ = paramMotionEvent.getY();
      this.uWE = true;
      this.uWJ[0] = (this.uWz.width / 2.0F);
      this.uWJ[1] = (this.uWz.height / 2.0F);
      this.uWz.aHZ.mapPoints(this.uWJ);
      break;
      this.uWE = false;
      if ((Math.abs(paramMotionEvent.getX() - this.jKY) <= this.rxD) && (Math.abs(paramMotionEvent.getY() - this.jKZ) <= this.rxD)) {
        break;
      }
      this.jKV = true;
      break;
      this.uWE = true;
      if (((!this.cSY) || (this.vbe)) && (!this.jKV)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aGO = this.aGO;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aGN = this.aGN;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).o(new float[] { this.vaZ.width() / 2.0F, this.vaZ.height() / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.vav.left, this.vav.top, this.vav.right, this.vav.bottom));
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (this.uWz.width / 2.0F);
      arrayOfFloat[1] = (this.uWz.height / 2.0F);
      this.uWz.aHZ.mapPoints(arrayOfFloat);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).IdC.contains(arrayOfFloat[0], arrayOfFloat[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.uWJ[0], this.uWJ[1], this.uWJ[0], this.uWJ[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).a(this.uWz.aHZ, (m)new c(this));
      break;
      if (this.cSY) {
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
    removeCallbacks(this.vaV);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    cYA();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.uWD = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView$Companion;", "", "()V", "ANIM_INTERVAL", "", "TEXT_COLOR_INVALID", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(785);
      EditorItemContainer localEditorItemContainer = this.vbi.getItemContainer();
      if (localEditorItemContainer != null)
      {
        localEditorItemContainer.setEditing((a)this.vbi);
        AppMethodBeat.o(785);
        return;
      }
      AppMethodBeat.o(785);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends q
    implements m<Matrix, Boolean, x>
  {
    c(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(787);
      TextEditorItemView.c(this.vbi);
      AppMethodBeat.o(787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */