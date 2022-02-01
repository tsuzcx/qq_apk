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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final a oRj;
  private final String TAG;
  private float aMu;
  private float aMv;
  private final float bottomMargin;
  private boolean cBN;
  private boolean fPg;
  private float fPj;
  private float fPk;
  private final float gpZ;
  private final float mdP;
  private boolean oMA;
  private boolean oMB;
  private final com.tencent.mm.media.editor.c.c oMw;
  private final Path oMy;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c oQR;
  private String[] oQT;
  private Typeface[] oQU;
  private int oQV;
  private final Runnable oQW;
  private final Paint oQX;
  private final float oQY;
  private final Path oQZ;
  private RectF oQx;
  private final RectF oRa;
  private final int oRb;
  private int oRc;
  private final Bitmap[] oRd;
  private final float oRe;
  private boolean oRf;
  private final PointF oRh;
  private final PointF oRi;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(804);
    oRj = new a((byte)0);
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
    this.oQW = ((Runnable)new d(this));
    this.oQX = new Paint(1);
    this.oQZ = new Path();
    this.oRa = new RectF();
    this.oQx = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.oRh = new PointF();
    this.oRi = new PointF();
    this.oMw = new com.tencent.mm.media.editor.c.c();
    this.oMy = new Path();
    this.aMu = 2.0F;
    this.aMv = 0.25F;
    if (paramContext == null) {
      k.fvU();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    int i;
    if (com.tencent.mm.ar.b.axr().axu())
    {
      paramAttributeSet = d.oJY;
      if (d.a.bXE())
      {
        k.g(com.tencent.mm.ar.b.axr(), "FontResLogic.getInstance()");
        paramAttributeSet = com.tencent.mm.ar.b.axv();
        k.g(paramAttributeSet, "FontResLogic.getInstance().fontPath");
        this.oQT = paramAttributeSet;
        paramAttributeSet = d.oJY;
        this.oQR = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.oQT, (int)f));
        i = this.oQT.length;
        paramAttributeSet = new Typeface[i];
        paramInt = 0;
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.oQT[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.oQU = paramAttributeSet;; this.oQU = new Typeface[] { null })
    {
      this.oRb = this.oQU.length;
      i = this.oRb;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.oQT = new String[] { "" };
      h.vKh.D(933L, 3L);
      this.oQR = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.oRd = paramAttributeSet;
    bYJ();
    this.gpZ = getResources().getDimension(2131166191);
    this.oQY = getResources().getDimension(2131166192);
    this.oQX.setColor(-1);
    this.oQX.setStyle(Paint.Style.STROKE);
    this.oQX.setStrokeWidth(this.oQY);
    this.oRi.set(this.gpZ, this.gpZ);
    this.bottomMargin = getResources().getDimension(2131166190);
    this.oRe = getResources().getDimension(2131166193);
    paramContext = ViewConfiguration.get(paramContext);
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.mdP = paramContext.getScaledTouchSlop();
    this.oMw.aMu = this.aMu;
    this.oMw.aMv = this.aMv;
    AppMethodBeat.o(803);
  }
  
  private final void bYJ()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.cBN)
    {
      this.oRc += 1;
      this.oRc %= this.oRb;
      localObject = this.oQU[this.oQV];
      this.oQR.Uz(this.oQT[this.oQV]);
      this.oQV += 1;
      this.oQV %= this.oQU.length;
      if (this.oRd[this.oRc] == null)
      {
        localObject = d((Typeface)localObject);
        this.oRd[this.oRc] = localObject;
        fn(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.oQW);
      postDelayed(this.oQW, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.oRd[this.oRc] == null)
      {
        localObject = this.oQU[0];
        this.oQR.Uz(this.oQT[this.oQV]);
        localObject = d((Typeface)localObject);
        this.oRd[this.oRc] = localObject;
        fn(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void bYK()
  {
    AppMethodBeat.i(799);
    this.oMw.dY.setTranslate(this.oRh.x, this.oRh.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.oQx.width());
    localFontTextView.setTextDrawer(this.oQR);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.oQx.width() - 2.0F * this.oRe), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    k.g(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.gpZ * 2.0F;
    float f2 = paramInt2 + this.gpZ * 2.0F;
    float f3 = this.oRa.width();
    float f4 = this.oRa.height();
    if (this.oRa.isEmpty()) {
      this.oRh.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.oRa.set(0.0F, 0.0F, f1, f2);
      this.oQZ.reset();
      this.oQZ.addRoundRect(this.oRa, this.gpZ, this.gpZ, Path.Direction.CW);
      this.oMw.dY.preTranslate((this.oMw.width - f1) / 2.0F, this.oMw.height - f2);
      if (!this.cBN) {
        bYK();
      }
      this.oMw.width = ((int)f1);
      this.oMw.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.oRh.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  private final void refresh()
  {
    AppMethodBeat.i(796);
    e.M(this.oRd);
    this.oRc = 0;
    this.oQV = 0;
    bYJ();
    AppMethodBeat.o(796);
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    k.h(paramRectF, "bounds");
    this.oQx.set(paramRectF);
    this.oMy.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.oRh.set(paramRectF.left + paramRectF.width() / 2.0F - this.oRa.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.oRa.height());
    bYK();
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
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.c.AS(this.textColor);
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
      this.cBN = paramBoolean;
      refresh();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.media.editor.a.a ajz()
  {
    return null;
  }
  
  public final boolean bYI()
  {
    AppMethodBeat.i(792);
    a((CharSequence)"", 0, true);
    post((Runnable)new b(this));
    AppMethodBeat.o(792);
    return true;
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163484);
    if (!this.cBN)
    {
      AppMethodBeat.o(163484);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.oMw.dY);
    localMatrix.postTranslate(this.oRi.x, this.oRi.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.c(this.oRd, localMatrix);
    AppMethodBeat.o(163484);
    return paramMatrix;
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
    if (this.cBN) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.cBN) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    k.h(paramCanvas, "canvas");
    if (this.oMB) {
      paramCanvas.clipPath(this.oMy);
    }
    paramCanvas.save();
    paramCanvas.concat(this.oMw.dY);
    if (this.oMA) {
      paramCanvas.drawPath(this.oQZ, this.oQX);
    }
    Bitmap localBitmap = this.oRd[this.oRc];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.oRi.x, this.oRi.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    k.h(paramMotionEvent, "event");
    boolean bool = this.oMw.v(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.cBN) {
          bYK();
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
      this.oRf = this.oMA;
      this.fPg = false;
      this.fPj = paramMotionEvent.getX();
      this.fPk = paramMotionEvent.getY();
      this.oMB = true;
      break;
      this.oMB = false;
      if ((Math.abs(paramMotionEvent.getX() - this.fPj) <= this.mdP) && (Math.abs(paramMotionEvent.getY() - this.fPk) <= this.mdP)) {
        break;
      }
      this.fPg = true;
      break;
      this.oMB = true;
      if (((!this.cBN) || (this.oRf)) && (!this.fPg)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.media.editor.c.a();
      ((com.tencent.mm.media.editor.c.a)localObject).aMv = this.aMv;
      ((com.tencent.mm.media.editor.c.a)localObject).aMu = this.aMu;
      ((com.tencent.mm.media.editor.c.a)localObject).k(new float[] { this.oRa.width() / 2.0F, this.oRa.height() / 2.0F });
      ((com.tencent.mm.media.editor.c.a)localObject).e(new RectF(this.oQx.left, this.oQx.top, this.oQx.right, this.oQx.bottom));
      ((com.tencent.mm.media.editor.c.a)localObject).a(this.oMw.dY, (d.g.a.b)new c(this));
      break;
      if (this.cBN) {
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
    removeCallbacks(this.oQW);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    bYJ();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.oMA = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView$Companion;", "", "()V", "ANIM_INTERVAL", "", "TEXT_COLOR_INVALID", "", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(785);
      EditorItemContainer localEditorItemContainer = this.oRk.getItemContainer();
      if (localEditorItemContainer != null)
      {
        localEditorItemContainer.setEditing((a)this.oRk);
        AppMethodBeat.o(785);
        return;
      }
      AppMethodBeat.o(785);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Matrix, y>
  {
    c(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(TextEditorItemView paramTextEditorItemView) {}
    
    public final void run()
    {
      AppMethodBeat.i(787);
      TextEditorItemView.c(this.oRk);
      AppMethodBeat.o(787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */