package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.a.e;
import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aa;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "animCount", "animIndex", "bitmapArray", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "bitmapOffset", "Landroid/graphics/PointF;", "bottomMargin", "", "clipPath", "Landroid/graphics/Path;", "contentPadding", "drawingOffset", "fontPaths", "[Ljava/lang/String;", "framePadding", "framePaint", "Landroid/graphics/Paint;", "framePath", "framePathRect", "Landroid/graphics/RectF;", "frameStrokeWidth", "isClipping", "", "isEditing", "isEditingBeforeTouch", "isValid", "maxScale", "minScale", "strokeColor", "switchRunnable", "Ljava/lang/Runnable;", "text", "", "textColor", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "touchDownX", "touchDownY", "touchMoved", "touchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "typefaceIndex", "validRect", "wxTypeFaces", "Landroid/graphics/Typeface;", "[Landroid/graphics/Typeface;", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "createTextBitmap", "typeface", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getText", "getTextColor", "handleRemove", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "preSetMatrix", "refresh", "resetFrame", "contentWidth", "contentHeight", "resume", "setEditing", "editing", "setValidArea", "bounds", "radius", "switchFont", "updateText", "color", "change", "Companion", "plugin-emojicapture_release"})
public final class TextEditorItemView
  extends View
  implements c.b
{
  public static final TextEditorItemView.a lAt;
  private final String TAG;
  private float arJ;
  private float arK;
  private boolean bRg;
  private final float eTV;
  private final float joa;
  private String[] lAa;
  private Typeface[] lAb;
  private int lAc;
  private final Runnable lAd;
  private final Paint lAe;
  private final float lAf;
  private final Path lAg;
  private final RectF lAh;
  private final int lAi;
  private int lAj;
  private final Bitmap[] lAk;
  private final float lAl;
  private boolean lAm;
  private float lAn;
  private float lAo;
  private boolean lAp;
  private final float lAq;
  private final PointF lAr;
  private final PointF lAs;
  private final com.tencent.mm.media.editor.c.c lwb;
  private final Path lwd;
  private boolean lwf;
  private boolean lwg;
  private RectF lzG;
  private com.tencent.mm.plugin.emojicapture.ui.editor.a.c lzY;
  private int strokeColor;
  private CharSequence text;
  private int textColor;
  
  static
  {
    AppMethodBeat.i(3129);
    lAt = new TextEditorItemView.a((byte)0);
    AppMethodBeat.o(3129);
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
    AppMethodBeat.i(3128);
    this.TAG = "MicroMsg.TextEditorItemView";
    this.lAd = ((Runnable)new TextEditorItemView.d(this));
    this.lAe = new Paint(1);
    this.lAg = new Path();
    this.lAh = new RectF();
    this.lzG = new RectF();
    this.textColor = -1;
    this.strokeColor = -1;
    this.lAr = new PointF();
    this.lAs = new PointF();
    this.lwb = new com.tencent.mm.media.editor.c.c();
    this.lwd = new Path();
    this.arJ = 2.0F;
    this.arK = 0.25F;
    if (paramContext == null) {
      j.ebi();
    }
    float f = paramContext.getResources().getDimension(2131428341);
    label185:
    int i;
    if (com.tencent.mm.ao.b.agp().ags())
    {
      paramAttributeSet = com.tencent.mm.plugin.emojicapture.model.c.ltu;
      paramAttributeSet = aa.dsG();
      if (paramAttributeSet == null) {}
      do
      {
        for (;;)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label384;
          }
          j.p(com.tencent.mm.ao.b.agp(), "FontResLogic.getInstance()");
          paramAttributeSet = com.tencent.mm.ao.b.agt();
          j.p(paramAttributeSet, "FontResLogic.getInstance().fontPath");
          this.lAa = paramAttributeSet;
          paramAttributeSet = com.tencent.mm.plugin.emojicapture.model.c.ltu;
          this.lzY = ((com.tencent.mm.plugin.emojicapture.ui.editor.a.c)new com.tencent.mm.plugin.emojicapture.ui.editor.a.b(this.lAa, (int)f));
          i = this.lAa.length;
          paramAttributeSet = new Typeface[i];
          paramInt = 0;
          while (paramInt < i)
          {
            paramAttributeSet[paramInt] = Typeface.createFromFile(this.lAa[paramInt]);
            paramInt += 1;
          }
          switch (paramAttributeSet.hashCode())
          {
          }
        }
      } while (!paramAttributeSet.equals("zh_HK"));
      for (;;)
      {
        paramInt = 0;
        break label185;
        if (!paramAttributeSet.equals("zh_TW")) {
          break;
        }
      }
    }
    for (this.lAb = paramAttributeSet;; this.lAb = new Typeface[] { null })
    {
      this.lAi = this.lAb.length;
      i = this.lAi;
      paramAttributeSet = new Bitmap[i];
      paramInt = 0;
      while (paramInt < i)
      {
        paramAttributeSet[paramInt] = null;
        paramInt += 1;
      }
      label384:
      this.lAa = new String[] { "" };
      h.qsU.B(933L, 3L);
      this.lzY = ((com.tencent.mm.plugin.emojicapture.ui.editor.a.c)new com.tencent.mm.plugin.emojicapture.ui.editor.a.a());
    }
    this.lAk = paramAttributeSet;
    bpf();
    this.eTV = getResources().getDimension(2131428338);
    this.lAf = getResources().getDimension(2131428339);
    this.lAe.setColor(-1);
    this.lAe.setStyle(Paint.Style.STROKE);
    this.lAe.setStrokeWidth(this.lAf);
    this.lAs.set(this.eTV, this.eTV);
    this.lAq = getResources().getDimension(2131428337);
    this.lAl = getResources().getDimension(2131428340);
    paramContext = ViewConfiguration.get(paramContext);
    j.p(paramContext, "ViewConfiguration.get(context)");
    this.joa = paramContext.getScaledTouchSlop();
    this.lwb.arJ = this.arJ;
    this.lwb.arK = this.arK;
    AppMethodBeat.o(3128);
  }
  
  private final void bpg()
  {
    AppMethodBeat.i(3124);
    this.lwb.asO.setTranslate(this.lAr.x, this.lAr.y);
    AppMethodBeat.o(3124);
  }
  
  private final Bitmap d(Typeface paramTypeface)
  {
    AppMethodBeat.i(3125);
    FontTextView localFontTextView = new FontTextView(getContext());
    localFontTextView.setMaxWidth(this.lzG.width());
    localFontTextView.setTextDrawer(this.lzY);
    localFontTextView.setTypeface(paramTypeface);
    localFontTextView.d(this.text, this.textColor, this.strokeColor);
    localFontTextView.measure(View.MeasureSpec.makeMeasureSpec((int)(this.lzG.width() - 2.0F * this.lAl), -2147483648), 0);
    paramTypeface = Bitmap.createBitmap(localFontTextView.getMeasuredWidth(), localFontTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramTypeface);
    localCanvas.save();
    localFontTextView.draw(localCanvas);
    localCanvas.restore();
    j.p(paramTypeface, "bitmap");
    AppMethodBeat.o(3125);
    return paramTypeface;
  }
  
  private final void eg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3123);
    float f1 = paramInt1 + this.eTV * 2.0F;
    float f2 = paramInt2 + this.eTV * 2.0F;
    float f3 = this.lAh.width();
    float f4 = this.lAh.height();
    if (this.lAh.isEmpty()) {
      this.lAr.offset(f1 / 2.0F, -f2);
    }
    for (;;)
    {
      this.lAh.set(0.0F, 0.0F, f1, f2);
      this.lAg.reset();
      this.lAg.addRoundRect(this.lAh, this.eTV, this.eTV, Path.Direction.CW);
      this.lwb.asO.preTranslate((this.lwb.width - f1) / 2.0F, this.lwb.height - f2);
      if (!this.bRg) {
        bpg();
      }
      this.lwb.width = ((int)f1);
      this.lwb.height = ((int)f2);
      AppMethodBeat.o(3123);
      return;
      this.lAr.offset((f3 - f1) / 2.0F, (f4 - f2) / 2.0F);
    }
  }
  
  private final void refresh()
  {
    AppMethodBeat.i(3121);
    e.L(this.lAk);
    this.lAj = 0;
    this.lAc = 0;
    bpf();
    AppMethodBeat.o(3121);
  }
  
  public final com.tencent.mm.media.editor.a.b UH()
  {
    AppMethodBeat.i(3127);
    if (!this.bRg)
    {
      AppMethodBeat.o(3127);
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postConcat(this.lwb.asO);
    ((Matrix)localObject).postTranslate(this.lAs.x, this.lAs.y);
    localObject = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.c(this.lAk, (Matrix)localObject);
    AppMethodBeat.o(3127);
    return localObject;
  }
  
  public final com.tencent.mm.media.editor.a.a UI()
  {
    return null;
  }
  
  public final void a(RectF paramRectF, float paramFloat)
  {
    AppMethodBeat.i(3115);
    j.q(paramRectF, "bounds");
    this.lzG.set(paramRectF);
    this.lwd.addRoundRect(new RectF(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom), paramFloat, paramFloat, Path.Direction.CW);
    this.lAr.set(paramRectF.left + paramRectF.width() / 2.0F - this.lAh.width() / 2.0F, paramRectF.bottom - this.lAq - this.lAh.height());
    bpg();
    AppMethodBeat.o(3115);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(3118);
    if (paramBoolean)
    {
      this.text = paramCharSequence;
      this.textColor = paramInt;
      this.strokeColor = com.tencent.mm.plugin.emojicapture.ui.a.uN(this.textColor);
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
      this.bRg = paramBoolean;
      refresh();
      AppMethodBeat.o(3118);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final boolean bpe()
  {
    AppMethodBeat.i(3117);
    a((CharSequence)"", 0, true);
    post((Runnable)new TextEditorItemView.b(this));
    AppMethodBeat.o(3117);
    return true;
  }
  
  public final void bpf()
  {
    AppMethodBeat.i(3122);
    Object localObject;
    if (this.bRg)
    {
      this.lAj += 1;
      this.lAj %= this.lAi;
      localObject = this.lAb[this.lAc];
      this.lzY.Lq(this.lAa[this.lAc]);
      this.lAc += 1;
      this.lAc %= this.lAb.length;
      if (this.lAk[this.lAj] == null)
      {
        localObject = d((Typeface)localObject);
        this.lAk[this.lAj] = localObject;
        eg(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      removeCallbacks(this.lAd);
      postDelayed(this.lAd, 100L);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(3122);
      return;
      if (this.lAk[this.lAj] == null)
      {
        localObject = this.lAb[0];
        this.lzY.Lq(this.lAa[this.lAc]);
        localObject = d((Typeface)localObject);
        this.lAk[this.lAj] = localObject;
        eg(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
  
  public final EditorItemContainer getItemContainer()
  {
    AppMethodBeat.i(3126);
    Object localObject = getParent();
    j.p(localObject, "parent");
    if ((((ViewParent)localObject).getParent() instanceof EditorItemContainer))
    {
      localObject = getParent();
      j.p(localObject, "parent");
      localObject = ((ViewParent)localObject).getParent();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
        AppMethodBeat.o(3126);
        throw ((Throwable)localObject);
      }
      localObject = (EditorItemContainer)localObject;
      AppMethodBeat.o(3126);
      return localObject;
    }
    AppMethodBeat.o(3126);
    return null;
  }
  
  public final CharSequence getText()
  {
    if (this.bRg) {
      return this.text;
    }
    return null;
  }
  
  public final int getTextColor()
  {
    if (this.bRg) {
      return this.textColor;
    }
    return 0;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(3120);
    j.q(paramCanvas, "canvas");
    if (this.lwg) {
      paramCanvas.clipPath(this.lwd);
    }
    paramCanvas.save();
    paramCanvas.concat(this.lwb.asO);
    if (this.lwf) {
      paramCanvas.drawPath(this.lAg, this.lAe);
    }
    Bitmap localBitmap = this.lAk[this.lAj];
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.lAs.x, this.lAs.y, null);
    }
    paramCanvas.restore();
    AppMethodBeat.o(3120);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3119);
    j.q(paramMotionEvent, "event");
    boolean bool = this.lwb.u(paramMotionEvent);
    if (bool)
    {
      postInvalidate();
      switch (paramMotionEvent.getActionMasked())
      {
      case 4: 
      default: 
        if (!this.bRg) {
          bpg();
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(3119);
      return bool;
      AppMethodBeat.o(3119);
      return false;
      this.lAm = this.lwf;
      this.lAp = false;
      this.lAn = paramMotionEvent.getX();
      this.lAo = paramMotionEvent.getY();
      this.lwg = true;
      break;
      this.lwg = false;
      if ((Math.abs(paramMotionEvent.getX() - this.lAn) <= this.joa) && (Math.abs(paramMotionEvent.getY() - this.lAo) <= this.joa)) {
        break;
      }
      this.lAp = true;
      break;
      this.lwg = true;
      if (((!this.bRg) || (this.lAm)) && (!this.lAp)) {
        performClick();
      }
      Object localObject = new com.tencent.mm.media.editor.c.a();
      ((com.tencent.mm.media.editor.c.a)localObject).arK = this.arK;
      ((com.tencent.mm.media.editor.c.a)localObject).arJ = this.arJ;
      ((com.tencent.mm.media.editor.c.a)localObject).g(new float[] { this.lAh.width() / 2.0F, this.lAh.height() / 2.0F });
      ((com.tencent.mm.media.editor.c.a)localObject).b(new RectF(this.lzG.left, this.lzG.top, this.lzG.right, this.lzG.bottom));
      ((com.tencent.mm.media.editor.c.a)localObject).a(this.lwb.asO, (a.f.a.b)new TextEditorItemView.c(this));
      break;
      if (this.bRg) {
        break;
      }
      AppMethodBeat.o(3119);
      return false;
      localObject = getItemContainer();
      if (localObject != null) {
        ((EditorItemContainer)localObject).a((a)this, paramMotionEvent);
      }
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(3114);
    removeCallbacks(this.lAd);
    AppMethodBeat.o(3114);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(3113);
    bpf();
    AppMethodBeat.o(3113);
  }
  
  public final void setEditing(boolean paramBoolean)
  {
    AppMethodBeat.i(3116);
    this.lwf = paramBoolean;
    postInvalidate();
    AppMethodBeat.o(3116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView
 * JD-Core Version:    0.7.0.1
 */