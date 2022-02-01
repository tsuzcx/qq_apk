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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "originPivot", "", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final TextEditorItemView.a pYa;
  private final String TAG;
  private float aXE;
  private float aXF;
  private final float bottomMargin;
  private boolean cJS;
  private boolean gmF;
  private float gmI;
  private float gmJ;
  private final float ngm;
  private final float[] pTB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pTr;
  private final Path pTt;
  private boolean pTv;
  private boolean pTw;
  private final float pTz;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c pXJ;
  private String[] pXL;
  private Typeface[] pXM;
  private int pXN;
  private final Runnable pXO;
  private final Paint pXP;
  private final float pXQ;
  private final Path pXR;
  private final RectF pXS;
  private final int pXT;
  private int pXU;
  private final Bitmap[] pXV;
  private final float pXW;
  private boolean pXX;
  private final PointF pXY;
  private final PointF pXZ;
  private RectF pXo;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(804);
    pYa = new TextEditorItemView.a((byte)0);
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
    this.pXO = ((Runnable)new d(this));
    this.pXP = new Paint(1);
    this.pXR = new Path();
    this.pXS = new RectF();
    this.pXo = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.pXY = new PointF();
    this.pXZ = new PointF();
    this.pTr = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.pTt = new Path();
    this.aXE = 2.0F;
    this.aXF = 0.25F;
    this.pTB = new float[2];
    if (paramContext == null) {
      p.gfZ();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    int i;
    if (com.tencent.mm.ar.b.aHo().aHr())
    {
      paramAttributeSet = d.pQW;
      if (d.a.cju())
      {
        p.g(com.tencent.mm.ar.b.aHo(), "FontResLogic.getInstance()");
        paramAttributeSet = com.tencent.mm.ar.b.aHs();
        p.g(paramAttributeSet, "FontResLogic.getInstance().fontPath");
        this.pXL = paramAttributeSet;
        paramAttributeSet = d.pQW;
        this.pXJ = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.pXL, (int)f));
        i = this.pXL.length;
        paramAttributeSet = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.pXL[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.pXM = paramAttributeSet;; this.pXM = new Typeface[] { null })
    {
      this.pXT = this.pXM.length;
      i = this.pXT;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.pXL = new String[] { "" };
      g.yhR.A(933L, 3L);
      this.pXJ = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.pXV = paramAttributeSet;
    cky();
    this.pTz = getResources().getDimension(2131166191);
    this.pXQ = getResources().getDimension(2131166192);
    this.pXP.setColor(-1);
    this.pXP.setStyle(Paint.Style.STROKE);
    this.pXP.setStrokeWidth(this.pXQ);
    this.pXZ.set(this.pTz, this.pTz);
    this.bottomMargin = getResources().getDimension(2131166190);
    this.pXW = getResources().getDimension(2131166193);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.ngm = paramContext.getScaledTouchSlop();
    this.pTr.aXE = this.aXE;
    this.pTr.aXF = this.aXF;
    AppMethodBeat.o(803);
  }
  
  private final void cky()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.cJS)
    {
      this.pXU += 1;
      this.pXU %= this.pXT;
      localObject = this.pXM[this.pXN];
      this.pXJ.acr(this.pXL[this.pXN]);
      this.pXN += 1;
      this.pXN %= this.pXM.length;
      if (this.pXV[this.pXU] == null)
      {
        localObject = d((Typeface)localObject);
        this.pXV[this.pXU] = localObject;
        fu(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.pXO);
      postDelayed(this.pXO, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.pXV[this.pXU] == null)
      {
        localObject = this.pXM[0];
        this.pXJ.acr(this.pXL[this.pXN]);
        localObject = d((Typeface)localObject);
        this.pXV[this.pXU] = localObject;
        fu(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void ckz()
  {
    AppMethodBeat.i(799);
    this.pTr.gR.setTranslate(this.pXY.x, this.pXY.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.pXo.width());
    localFontTextView.setTextDrawer(this.pXJ);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.pXo.width() - 2.0F * this.pXW), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    p.g(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void fu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.pTz * 2.0F;
    float f2 = paramInt2 + this.pTz * 2.0F;
    float f3 = this.pXS.width();
    float f4 = this.pXS.height();
    if (this.pXS.isEmpty()) {
      this.pXY.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.pXS.set(0.0F, 0.0F, f1, f2);
      this.pXR.reset();
      this.pXR.addRoundRect(this.pXS, this.pTz, this.pTz, Path.Direction.CW);
      this.pTr.gR.preTranslate((this.pTr.width - f1) / 2.0F, this.pTr.height - f2);
      if (!this.cJS) {
        ckz();
      }
      this.pTr.width = ((int)f1);
      this.pTr.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.pXY.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  private final void refresh()
  {
    AppMethodBeat.i(796);
    e.P(this.pXV);
    this.pXU = 0;
    this.pXN = 0;
    cky();
    AppMethodBeat.o(796);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    p.h(paramRectF, "bounds");
    this.pXo.set(paramRectF);
    this.pTt.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.pXY.set(paramRectF.left + paramRectF.width() / 2.0F - this.pXS.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.pXS.height());
    ckz();
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
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.Cs(this.textColor);
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
      this.cJS = paramBoolean;
      refresh();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(195144);
    if (!this.cJS)
    {
      AppMethodBeat.o(195144);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pTr.gR);
    localMatrix.postTranslate(this.pXZ.x, this.pXZ.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b(this.pXV, localMatrix);
    AppMethodBeat.o(195144);
    return paramMatrix;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a ckw()
  {
    return null;
  }
  
  public final boolean ckx()
  {
    AppMethodBeat.i(792);
    a((CharSequence)"", 0, true);
    post((Runnable)new TextEditorItemView.b(this));
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
    if (this.cJS) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.cJS) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    p.h(paramCanvas, "canvas");
    if (this.pTw) {
      paramCanvas.clipPath(this.pTt);
    }
    paramCanvas.save();
    paramCanvas.concat(this.pTr.gR);
    if (this.pTv) {
      paramCanvas.drawPath(this.pXR, this.pXP);
    }
    Bitmap localBitmap = this.pXV[this.pXU];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.pXZ.x, this.pXZ.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    p.h(paramMotionEvent, "event");
    boolean bool = this.pTr.W(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.cJS) {
          ckz();
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
      this.pXX = this.pTv;
      this.gmF = false;
      this.gmI = paramMotionEvent.getX();
      this.gmJ = paramMotionEvent.getY();
      this.pTw = true;
      this.pTB[0] = (this.pTr.width / 2.0F);
      this.pTB[1] = (this.pTr.height / 2.0F);
      this.pTr.gR.mapPoints(this.pTB);
      break;
      this.pTw = false;
      if ((Math.abs(paramMotionEvent.getX() - this.gmI) <= this.ngm) && (Math.abs(paramMotionEvent.getY() - this.gmJ) <= this.ngm)) {
        break;
      }
      this.gmF = true;
      break;
      this.pTw = true;
      if (((!this.cJS) || (this.pXX)) && (!this.gmF)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aXF = this.aXF;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).aXE = this.aXE;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).n(new float[] { this.pXS.width() / 2.0F, this.pXS.height() / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.pXo.left, this.pXo.top, this.pXo.right, this.pXo.bottom));
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (this.pTr.width / 2.0F);
      arrayOfFloat[1] = (this.pTr.height / 2.0F);
      this.pTr.gR.mapPoints(arrayOfFloat);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).xPV.contains(arrayOfFloat[0], arrayOfFloat[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).f(new RectF(this.pTB[0], this.pTB[1], this.pTB[0], this.pTB[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).a(this.pTr.gR, (m)new c(this));
      break;
      if (this.cJS) {
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
    removeCallbacks(this.pXO);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    cky();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.pTv = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", "", "invoke"})
  static final class c
    extends q
    implements m<Matrix, Boolean, z>
  {
    c(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(787);
      TextEditorItemView.c(this.pYb);
      AppMethodBeat.o(787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */