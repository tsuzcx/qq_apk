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
import d.a.e;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final TextEditorItemView.a puv;
  private final String TAG;
  private float aNk;
  private float aNl;
  private final float bottomMargin;
  private boolean cyW;
  private boolean fTb;
  private float fTe;
  private float fTf;
  private final float gQH;
  private final float mFO;
  private final com.tencent.mm.media.editor.c.c ppQ;
  private final Path ppS;
  private boolean ppU;
  private boolean ppV;
  private RectF ptK;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c pue;
  private String[] pug;
  private Typeface[] puh;
  private int pui;
  private final Runnable puj;
  private final Paint puk;
  private final float pul;
  private final Path pum;
  private final RectF pun;
  private final int puo;
  private int pup;
  private final Bitmap[] puq;
  private final float pur;
  private boolean pus;
  private final PointF put;
  private final PointF puu;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(804);
    puv = new TextEditorItemView.a((byte)0);
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
    this.puj = ((Runnable)new d(this));
    this.puk = new Paint(1);
    this.pum = new Path();
    this.pun = new RectF();
    this.ptK = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.put = new PointF();
    this.puu = new PointF();
    this.ppQ = new com.tencent.mm.media.editor.c.c();
    this.ppS = new Path();
    this.aNk = 2.0F;
    this.aNl = 0.25F;
    if (paramContext == null) {
      k.fOy();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    int i;
    if (com.tencent.mm.aq.b.aEj().aEm())
    {
      paramAttributeSet = d.pnw;
      if (d.a.ceR())
      {
        k.g(com.tencent.mm.aq.b.aEj(), "FontResLogic.getInstance()");
        paramAttributeSet = com.tencent.mm.aq.b.aEn();
        k.g(paramAttributeSet, "FontResLogic.getInstance().fontPath");
        this.pug = paramAttributeSet;
        paramAttributeSet = d.pnw;
        this.pue = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.pug, (int)f));
        i = this.pug.length;
        paramAttributeSet = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.pug[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.puh = paramAttributeSet;; this.puh = new Typeface[] { null })
    {
      this.puo = this.puh.length;
      i = this.puo;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.pug = new String[] { "" };
      h.wUl.A(933L, 3L);
      this.pue = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.puq = paramAttributeSet;
    cfU();
    this.gQH = getResources().getDimension(2131166191);
    this.pul = getResources().getDimension(2131166192);
    this.puk.setColor(-1);
    this.puk.setStyle(Paint.Style.STROKE);
    this.puk.setStrokeWidth(this.pul);
    this.puu.set(this.gQH, this.gQH);
    this.bottomMargin = getResources().getDimension(2131166190);
    this.pur = getResources().getDimension(2131166193);
    paramContext = ViewConfiguration.get(paramContext);
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.mFO = paramContext.getScaledTouchSlop();
    this.ppQ.aNk = this.aNk;
    this.ppQ.aNl = this.aNl;
    AppMethodBeat.o(803);
  }
  
  private final void cfU()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.cyW)
    {
      this.pup += 1;
      this.pup %= this.puo;
      localObject = this.puh[this.pui];
      this.pue.YL(this.pug[this.pui]);
      this.pui += 1;
      this.pui %= this.puh.length;
      if (this.puq[this.pup] == null)
      {
        localObject = d((Typeface)localObject);
        this.puq[this.pup] = localObject;
        fq(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.puj);
      postDelayed(this.puj, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.puq[this.pup] == null)
      {
        localObject = this.puh[0];
        this.pue.YL(this.pug[this.pui]);
        localObject = d((Typeface)localObject);
        this.puq[this.pup] = localObject;
        fq(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void cfV()
  {
    AppMethodBeat.i(799);
    this.ppQ.eY.setTranslate(this.put.x, this.put.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.ptK.width());
    localFontTextView.setTextDrawer(this.pue);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.ptK.width() - 2.0F * this.pur), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    k.g(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.gQH * 2.0F;
    float f2 = paramInt2 + this.gQH * 2.0F;
    float f3 = this.pun.width();
    float f4 = this.pun.height();
    if (this.pun.isEmpty()) {
      this.put.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.pun.set(0.0F, 0.0F, f1, f2);
      this.pum.reset();
      this.pum.addRoundRect(this.pun, this.gQH, this.gQH, Path.Direction.CW);
      this.ppQ.eY.preTranslate((this.ppQ.width - f1) / 2.0F, this.ppQ.height - f2);
      if (!this.cyW) {
        cfV();
      }
      this.ppQ.width = ((int)f1);
      this.ppQ.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.put.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  private final void refresh()
  {
    AppMethodBeat.i(796);
    e.O(this.puq);
    this.pup = 0;
    this.pui = 0;
    cfU();
    AppMethodBeat.o(796);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    k.h(paramRectF, "bounds");
    this.ptK.set(paramRectF);
    this.ppS.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.put.set(paramRectF.left + paramRectF.width() / 2.0F - this.pun.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.pun.height());
    cfV();
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
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.BK(this.textColor);
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
      this.cyW = paramBoolean;
      refresh();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.media.editor.a.a aqy()
  {
    return null;
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163484);
    if (!this.cyW)
    {
      AppMethodBeat.o(163484);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.ppQ.eY);
    localMatrix.postTranslate(this.puu.x, this.puu.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.c(this.puq, localMatrix);
    AppMethodBeat.o(163484);
    return paramMatrix;
  }
  
  public final boolean cfT()
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
    k.g(localObject, "parent");
    if ((((ViewParent)localObject).getParent() instanceof EditorItemContainer))
    {
      localObject = getParent();
      k.g(localObject, "parent");
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
    if (this.cyW) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.cyW) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    k.h(paramCanvas, "canvas");
    if (this.ppV) {
      paramCanvas.clipPath(this.ppS);
    }
    paramCanvas.save();
    paramCanvas.concat(this.ppQ.eY);
    if (this.ppU) {
      paramCanvas.drawPath(this.pum, this.puk);
    }
    Bitmap localBitmap = this.puq[this.pup];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.puu.x, this.puu.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    k.h(paramMotionEvent, "event");
    boolean bool = this.ppQ.t(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.cyW) {
          cfV();
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
      this.pus = this.ppU;
      this.fTb = false;
      this.fTe = paramMotionEvent.getX();
      this.fTf = paramMotionEvent.getY();
      this.ppV = true;
      break;
      this.ppV = false;
      if ((Math.abs(paramMotionEvent.getX() - this.fTe) <= this.mFO) && (Math.abs(paramMotionEvent.getY() - this.fTf) <= this.mFO)) {
        break;
      }
      this.fTb = true;
      break;
      this.ppV = true;
      if (((!this.cyW) || (this.pus)) && (!this.fTb)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.media.editor.c.a();
      ((com.tencent.mm.media.editor.c.a)localObject).aNl = this.aNl;
      ((com.tencent.mm.media.editor.c.a)localObject).aNk = this.aNk;
      ((com.tencent.mm.media.editor.c.a)localObject).k(new float[] { this.pun.width() / 2.0F, this.pun.height() / 2.0F });
      ((com.tencent.mm.media.editor.c.a)localObject).e(new RectF(this.ptK.left, this.ptK.top, this.ptK.right, this.ptK.bottom));
      ((com.tencent.mm.media.editor.c.a)localObject).a(this.ppQ.eY, (d.g.a.b)new c(this));
      break;
      if (this.cyW) {
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
    removeCallbacks(this.puj);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    cfU();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.ppU = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(785);
      EditorItemContainer localEditorItemContainer = this.puw.getItemContainer();
      if (localEditorItemContainer != null)
      {
        localEditorItemContainer.setEditing((a)this.puw);
        AppMethodBeat.o(785);
        return;
      }
      AppMethodBeat.o(785);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Matrix, y>
  {
    c(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(787);
      TextEditorItemView.c(this.puw);
      AppMethodBeat.o(787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */