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
import com.tencent.mm.plugin.report.service.g;
import d.a.e;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "originPivot", "", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final TextEditorItemView.a qeF;
  private final String TAG;
  private float aXE;
  private float aXF;
  private final float bottomMargin;
  private boolean cKB;
  private boolean gpb;
  private float gpe;
  private float gpf;
  private final float nlu;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pZW;
  private final Path pZY;
  private boolean qaa;
  private boolean qab;
  private final float qae;
  private final float[] qag;
  private RectF qdT;
  private final Bitmap[] qeA;
  private final float qeB;
  private boolean qeC;
  private final PointF qeD;
  private final PointF qeE;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c qeo;
  private String[] qeq;
  private Typeface[] qer;
  private int qes;
  private final Runnable qet;
  private final Paint qeu;
  private final float qev;
  private final Path qew;
  private final RectF qex;
  private final int qey;
  private int qez;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(804);
    qeF = new TextEditorItemView.a((byte)0);
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
    this.qet = ((Runnable)new d(this));
    this.qeu = new Paint(1);
    this.qew = new Path();
    this.qex = new RectF();
    this.qdT = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.qeD = new PointF();
    this.qeE = new PointF();
    this.pZW = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.pZY = new Path();
    this.aXE = 2.0F;
    this.aXF = 0.25F;
    this.qag = new float[2];
    if (paramContext == null) {
      p.gkB();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    int i;
    if (com.tencent.mm.aq.b.aHF().aHI())
    {
      paramAttributeSet = d.pXB;
      if (d.a.ckK())
      {
        p.g(com.tencent.mm.aq.b.aHF(), "FontResLogic.getInstance()");
        paramAttributeSet = com.tencent.mm.aq.b.aHJ();
        p.g(paramAttributeSet, "FontResLogic.getInstance().fontPath");
        this.qeq = paramAttributeSet;
        paramAttributeSet = d.pXB;
        this.qeo = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.qeq, (int)f));
        i = this.qeq.length;
        paramAttributeSet = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.qeq[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.qer = paramAttributeSet;; this.qer = new Typeface[] { null })
    {
      this.qey = this.qer.length;
      i = this.qey;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.qeq = new String[] { "" };
      g.yxI.A(933L, 3L);
      this.qeo = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.qeA = paramAttributeSet;
    clO();
    this.qae = getResources().getDimension(2131166191);
    this.qev = getResources().getDimension(2131166192);
    this.qeu.setColor(-1);
    this.qeu.setStyle(Paint.Style.STROKE);
    this.qeu.setStrokeWidth(this.qev);
    this.qeE.set(this.qae, this.qae);
    this.bottomMargin = getResources().getDimension(2131166190);
    this.qeB = getResources().getDimension(2131166193);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.nlu = paramContext.getScaledTouchSlop();
    this.pZW.aXE = this.aXE;
    this.pZW.aXF = this.aXF;
    AppMethodBeat.o(803);
  }
  
  private final void clO()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.cKB)
    {
      this.qez += 1;
      this.qez %= this.qey;
      localObject = this.qer[this.qes];
      this.qeo.adi(this.qeq[this.qes]);
      this.qes += 1;
      this.qes %= this.qer.length;
      if (this.qeA[this.qez] == null)
      {
        localObject = d((Typeface)localObject);
        this.qeA[this.qez] = localObject;
        fv(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.qet);
      postDelayed(this.qet, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.qeA[this.qez] == null)
      {
        localObject = this.qer[0];
        this.qeo.adi(this.qeq[this.qes]);
        localObject = d((Typeface)localObject);
        this.qeA[this.qez] = localObject;
        fv(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void clP()
  {
    AppMethodBeat.i(799);
    this.pZW.gR.setTranslate(this.qeD.x, this.qeD.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.qdT.width());
    localFontTextView.setTextDrawer(this.qeo);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.qdT.width() - 2.0F * this.qeB), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    p.g(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void fv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.qae * 2.0F;
    float f2 = paramInt2 + this.qae * 2.0F;
    float f3 = this.qex.width();
    float f4 = this.qex.height();
    if (this.qex.isEmpty()) {
      this.qeD.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.qex.set(0.0F, 0.0F, f1, f2);
      this.qew.reset();
      this.qew.addRoundRect(this.qex, this.qae, this.qae, Path.Direction.CW);
      this.pZW.gR.preTranslate((this.pZW.width - f1) / 2.0F, this.pZW.height - f2);
      if (!this.cKB) {
        clP();
      }
      this.pZW.width = ((int)f1);
      this.pZW.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.qeD.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  private final void refresh()
  {
    AppMethodBeat.i(796);
    e.O(this.qeA);
    this.qez = 0;
    this.qes = 0;
    clO();
    AppMethodBeat.o(796);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    p.h(paramRectF, "bounds");
    this.qdT.set(paramRectF);
    this.pZY.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.qeD.set(paramRectF.left + paramRectF.width() / 2.0F - this.qex.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.qex.height());
    clP();
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
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.CE(this.textColor);
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
      this.cKB = paramBoolean;
      refresh();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(221778);
    if (!this.cKB)
    {
      AppMethodBeat.o(221778);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pZW.gR);
    localMatrix.postTranslate(this.qeE.x, this.qeE.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b(this.qeA, localMatrix);
    AppMethodBeat.o(221778);
    return paramMatrix;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a clM()
  {
    return null;
  }
  
  public final boolean clN()
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
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
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
    if (this.cKB) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.cKB) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    p.h(paramCanvas, "canvas");
    if (this.qab) {
      paramCanvas.clipPath(this.pZY);
    }
    paramCanvas.save();
    paramCanvas.concat(this.pZW.gR);
    if (this.qaa) {
      paramCanvas.drawPath(this.qew, this.qeu);
    }
    Bitmap localBitmap = this.qeA[this.qez];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.qeE.x, this.qeE.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    p.h(paramMotionEvent, "event");
    boolean bool = this.pZW.U(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.cKB) {
          clP();
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
      this.qeC = this.qaa;
      this.gpb = false;
      this.gpe = paramMotionEvent.getX();
      this.gpf = paramMotionEvent.getY();
      this.qab = true;
      this.qag[0] = (this.pZW.width / 2.0F);
      this.qag[1] = (this.pZW.height / 2.0F);
      this.pZW.gR.mapPoints(this.qag);
      break;
      this.qab = false;
      if ((Math.abs(paramMotionEvent.getX() - this.gpe) <= this.nlu) && (Math.abs(paramMotionEvent.getY() - this.gpf) <= this.nlu)) {
        break;
      }
      this.gpb = true;
      break;
      this.qab = true;
      if (((!this.cKB) || (this.qeC)) && (!this.gpb)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aXF = this.aXF;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aXE = this.aXE;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).n(new float[] { this.qex.width() / 2.0F, this.qex.height() / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.qdT.left, this.qdT.top, this.qdT.right, this.qdT.bottom));
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (this.pZW.width / 2.0F);
      arrayOfFloat[1] = (this.pZW.height / 2.0F);
      this.pZW.gR.mapPoints(arrayOfFloat);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).yfO.contains(arrayOfFloat[0], arrayOfFloat[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.qag[0], this.qag[1], this.qag[0], this.qag[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).a(this.pZW.gR, (m)new c(this));
      break;
      if (this.cKB) {
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
    removeCallbacks(this.qet);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    clO();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.qaa = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(785);
      EditorItemContainer localEditorItemContainer = this.qeG.getItemContainer();
      if (localEditorItemContainer != null)
      {
        localEditorItemContainer.setEditing((a)this.qeG);
        AppMethodBeat.o(785);
        return;
      }
      AppMethodBeat.o(785);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends q
    implements m<Matrix, Boolean, z>
  {
    c(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(787);
      TextEditorItemView.c(this.qeG);
      AppMethodBeat.o(787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */