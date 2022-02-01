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
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "originPivot", "", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final TextEditorItemView.a ymO;
  private final String TAG;
  private boolean aPk;
  private CharSequence bba;
  private final float bottomMargin;
  private boolean clZ;
  private float maxScale;
  private float minScale;
  private boolean mkh;
  private float mkk;
  private float mkl;
  private int strokeColor;
  private int textColor;
  private final float uIH;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c yiZ;
  private final Path yjb;
  private boolean yjd;
  private final float yjg;
  private final float[] yji;
  private com.tencent.mm.plugin.emojicapture.ui.editor.text.c ymM;
  private String[] ymP;
  private Typeface[] ymQ;
  private int ymR;
  private final Runnable ymS;
  private final Paint ymT;
  private final float ymU;
  private final Path ymV;
  private final RectF ymW;
  private final int ymX;
  private int ymY;
  private final Bitmap[] ymZ;
  private RectF ymw;
  private final float yna;
  private boolean ynb;
  private final PointF ync;
  private final PointF ynd;
  
  static
  {
    AppMethodBeat.i(804);
    ymO = new TextEditorItemView.a((byte)0);
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
    this.ymS = new TextEditorItemView..ExternalSyntheticLambda0(this);
    this.ymT = new Paint(1);
    this.ymV = new Path();
    this.ymW = new RectF();
    this.ymw = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.ync = new PointF();
    this.ynd = new PointF();
    this.yiZ = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.yjb = new Path();
    this.maxScale = 2.0F;
    this.minScale = 0.25F;
    this.yji = new float[2];
    s.checkNotNull(paramContext);
    float f = paramContext.getResources().getDimension(a.d.ydW);
    int i;
    if (com.tencent.mm.modelemoji.b.bII().bIK())
    {
      paramAttributeSet = d.ygM;
      if (d.a.dDL())
      {
        com.tencent.mm.modelemoji.b.bII();
        paramAttributeSet = com.tencent.mm.modelemoji.b.bIL();
        s.s(paramAttributeSet, "getInstance().fontPath");
        this.ymP = paramAttributeSet;
        paramAttributeSet = d.ygM;
        this.ymM = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.b(this.ymP, (int)f));
        paramInt = 0;
        i = this.ymP.length;
        paramAttributeSet = new Typeface[i];
        while (paramInt < i)
        {
          paramAttributeSet[paramInt] = Typeface.createFromFile(this.ymP[paramInt]);
          paramInt += 1;
        }
      }
    }
    for (this.ymQ = paramAttributeSet;; this.ymQ = new Typeface[] { null })
    {
      this.ymX = this.ymQ.length;
      paramInt = 0;
      i = this.ymX;
      paramAttributeSet = new Bitmap[i];
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      this.ymP = new String[] { "" };
      h.OAn.p(933L, 3L, 1L);
      this.ymM = ((com.tencent.mm.plugin.emojicapture.ui.editor.text.c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    }
    this.ymZ = paramAttributeSet;
    dER();
    this.yjg = getResources().getDimension(a.d.ydT);
    this.ymU = getResources().getDimension(a.d.ydU);
    this.ymT.setColor(-1);
    this.ymT.setStyle(Paint.Style.STROKE);
    this.ymT.setStrokeWidth(this.ymU);
    this.ynd.set(this.yjg, this.yjg);
    this.bottomMargin = getResources().getDimension(a.d.ydS);
    this.yna = getResources().getDimension(a.d.ydV);
    this.uIH = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.yiZ.maxScale = this.maxScale;
    this.yiZ.minScale = this.minScale;
    AppMethodBeat.o(803);
  }
  
  private static final void a(TextEditorItemView paramTextEditorItemView)
  {
    AppMethodBeat.i(269507);
    s.u(paramTextEditorItemView, "this$0");
    paramTextEditorItemView.dER();
    AppMethodBeat.o(269507);
  }
  
  private static final void b(TextEditorItemView paramTextEditorItemView)
  {
    AppMethodBeat.i(269511);
    s.u(paramTextEditorItemView, "this$0");
    EditorItemContainer localEditorItemContainer = paramTextEditorItemView.getItemContainer();
    if (localEditorItemContainer != null) {
      localEditorItemContainer.setEditing((a)paramTextEditorItemView);
    }
    AppMethodBeat.o(269511);
  }
  
  private final void bDL()
  {
    AppMethodBeat.i(796);
    k.b(this.ymZ, null);
    this.ymY = 0;
    this.ymR = 0;
    dER();
    AppMethodBeat.o(796);
  }
  
  private final void dER()
  {
    AppMethodBeat.i(797);
    Object localObject;
    if (this.clZ)
    {
      this.ymY += 1;
      this.ymY %= this.ymX;
      localObject = this.ymQ[this.ymR];
      this.ymM.apq(this.ymP[this.ymR]);
      this.ymR += 1;
      this.ymR %= this.ymQ.length;
      if (this.ymZ[this.ymY] == null)
      {
        localObject = h((Typeface)localObject);
        this.ymZ[this.ymY] = localObject;
        hb(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.ymS);
      postDelayed(this.ymS, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(797);
      return;
      if (this.ymZ[this.ymY] == null)
      {
        localObject = this.ymQ[0];
        this.ymM.apq(this.ymP[this.ymR]);
        localObject = h((Typeface)localObject);
        this.ymZ[this.ymY] = localObject;
        hb(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  private final void dES()
  {
    AppMethodBeat.i(799);
    this.yiZ.matrix.setTranslate(this.ync.x, this.ync.y);
    AppMethodBeat.o(799);
  }
  
  private final Bitmap h(Typeface paramTypeface)
  {
    AppMethodBeat.i(800);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.ymw.width());
    localFontTextView.setTextDrawer(this.ymM);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.b(this.bba, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.ymw.width() - 2.0F * this.yna), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    s.s(paramTypeface, "bitmap");
    AppMethodBeat.o(800);
    return paramTypeface;
  }
  
  private final void hb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(798);
    float f1 = paramInt1 + this.yjg * 2.0F;
    float f2 = paramInt2 + this.yjg * 2.0F;
    float f3 = this.ymW.width();
    float f4 = this.ymW.height();
    if (this.ymW.isEmpty()) {
      this.ync.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.ymW.set(0.0F, 0.0F, f1, f2);
      this.ymV.reset();
      this.ymV.addRoundRect(this.ymW, this.yjg, this.yjg, Path.Direction.CW);
      this.yiZ.matrix.preTranslate((this.yiZ.width - f1) / 2.0F, this.yiZ.height - f2);
      if (!this.clZ) {
        dES();
      }
      this.yiZ.width = ((int)f1);
      this.yiZ.height = ((int)f2);
      AppMethodBeat.o(798);
      return;
      this.ync.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(790);
    s.u(paramRectF, "bounds");
    this.ymw.set(paramRectF);
    this.yjb.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.ync.set(paramRectF.left + paramRectF.width() / 2.0F - this.ymW.width() / 2.0F, paramRectF.bottom - this.bottomMargin - this.ymW.height());
    dES();
    AppMethodBeat.o(790);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(793);
    setContentDescription(paramCharSequence);
    if (paramBoolean)
    {
      this.bba = paramCharSequence;
      this.textColor = paramInt;
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.b.KU(this.textColor);
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
      this.clZ = paramBoolean;
      bDL();
      AppMethodBeat.o(793);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a dEP()
  {
    return null;
  }
  
  public final boolean dEQ()
  {
    AppMethodBeat.i(792);
    a((CharSequence)"", 0, true);
    post(new TextEditorItemView..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(792);
    return true;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    AppMethodBeat.i(269574);
    if (!this.clZ)
    {
      AppMethodBeat.o(269574);
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.yiZ.matrix);
    localMatrix.postTranslate(this.ynd.x, this.ynd.y);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.b(this.ymZ, localMatrix);
    AppMethodBeat.o(269574);
    return paramMatrix;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(801);
    if ((getParent().getParent() instanceof EditorItemContainer))
    {
      Object localObject = getParent().getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
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
    if (this.clZ) {
      return this.bba;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.clZ) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(795);
    s.u(paramCanvas, "canvas");
    if (this.aPk) {
      paramCanvas.clipPath(this.yjb);
    }
    paramCanvas.save();
    paramCanvas.concat(this.yiZ.matrix);
    if (this.yjd) {
      paramCanvas.drawPath(this.ymV, this.ymT);
    }
    Bitmap localBitmap = this.ymZ[this.ymY];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.ynd.x, this.ynd.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(795);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(794);
    s.u(paramMotionEvent, "event");
    boolean bool = this.yiZ.ak(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.clZ) {
          dES();
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
      this.ynb = this.yjd;
      this.mkh = false;
      this.mkk = paramMotionEvent.getX();
      this.mkl = paramMotionEvent.getY();
      this.aPk = true;
      this.yji[0] = (this.yiZ.width / 2.0F);
      this.yji[1] = (this.yiZ.height / 2.0F);
      this.yiZ.matrix.mapPoints(this.yji);
      break;
      this.aPk = false;
      if ((Math.abs(paramMotionEvent.getX() - this.mkk) <= this.uIH) && (Math.abs(paramMotionEvent.getY() - this.mkl) <= this.uIH)) {
        break;
      }
      this.mkh = true;
      break;
      this.aPk = true;
      if (((!this.clZ) || (this.ynb)) && (!this.mkh)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).minScale = this.minScale;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).maxScale = this.maxScale;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).w(new float[] { this.ymW.width() / 2.0F, this.ymW.height() / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).g(new RectF(this.ymw.left, this.ymw.top, this.ymw.right, this.ymw.bottom));
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = (this.yiZ.width / 2.0F);
      arrayOfFloat[1] = (this.yiZ.height / 2.0F);
      this.yiZ.matrix.mapPoints(arrayOfFloat);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).NZY.contains(arrayOfFloat[0], arrayOfFloat[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).g(new RectF(this.yji[0], this.yji[1], this.yji[0], this.yji[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject).a(this.yiZ.matrix, (m)new b(this));
      break;
      if (this.clZ) {
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
    removeCallbacks(this.ymS);
    AppMethodBeat.o(789);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(788);
    dER();
    AppMethodBeat.o(788);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(791);
    this.yjd = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(791);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Matrix, Boolean, ah>
  {
    b(TextEditorItemView paramTextEditorItemView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */