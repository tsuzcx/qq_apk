package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"})
public final class FontTextView
  extends View
{
  private final int fQs;
  private TextPaint ga;
  private final Layout.Alignment ggL;
  private StaticLayout layout;
  private float maxWidth;
  private String oQI;
  private final float oQJ;
  private final float oQK;
  private final boolean oQL;
  private TextPaint oQM;
  private float oQN;
  private float oQO;
  private float oQP;
  private boolean oQQ;
  private c oQR;
  private boolean oQS;
  private CharSequence text;
  
  public FontTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FontTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FontTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(783);
    this.ggL = Layout.Alignment.ALIGN_CENTER;
    this.oQJ = 1.0F;
    this.ga = new TextPaint();
    this.oQM = new TextPaint();
    this.text = ((CharSequence)"");
    if (paramContext == null) {
      k.fvU();
    }
    float f = paramContext.getResources().getDimension(2131166194);
    this.oQO = paramContext.getResources().getDimension(2131166196);
    this.oQP = paramContext.getResources().getDimension(2131166197);
    paramAttributeSet = paramContext.getResources().getString(2131756782);
    k.g(paramAttributeSet, "context.resources.getStr…pture_emoji_text_default)");
    this.oQI = paramAttributeSet;
    this.fQs = com.tencent.mm.cd.a.fromDPToPix(paramContext, 2);
    this.ga.setAntiAlias(true);
    this.ga.setTextSize(f);
    this.ga.setColor(2147483647);
    f = com.tencent.mm.cd.a.fromDPToPix(paramContext, 1);
    this.ga.setShadowLayer(f, 0.0F, f, -16777216);
    this.oQM.setStrokeWidth(paramContext.getResources().getDimension(2131166198));
    this.oQM.setAntiAlias(true);
    this.oQM.setTextSize(this.ga.getTextSize());
    this.oQM.setStyle(Paint.Style.STROKE);
    this.layout = new StaticLayout(this.text, this.ga, getWidth(), this.ggL, this.oQJ, this.oQK, this.oQL);
    this.oQR = ((c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    this.text = ((CharSequence)this.oQI);
    paramContext = this.oQR;
    if (paramContext != null)
    {
      paramContext.setText(this.text);
      AppMethodBeat.o(783);
      return;
    }
    AppMethodBeat.o(783);
  }
  
  private final void a(Canvas paramCanvas, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(781);
    if ((paramInt < 0) || (paramInt >= this.layout.getLineCount()))
    {
      AppMethodBeat.o(781);
      return;
    }
    float f = this.layout.getLineLeft(paramInt) + getPaddingLeft();
    paramFloat = this.layout.getLineBaseline(paramInt) + paramFloat + getPaddingTop();
    boolean bool;
    if (this.layout.getEllipsisCount(paramInt) > 0)
    {
      bool = true;
      if (!bool) {
        break label202;
      }
    }
    label202:
    for (int i = this.layout.getLineStart(paramInt) + this.layout.getEllipsisStart(paramInt);; i = this.layout.getLineEnd(paramInt))
    {
      if (this.oQS)
      {
        localc = this.oQR;
        if (localc != null) {
          localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.oQM, bool);
        }
      }
      c localc = this.oQR;
      if (localc == null) {
        break label215;
      }
      localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.ga, bool);
      AppMethodBeat.o(781);
      return;
      bool = false;
      break;
    }
    label215:
    AppMethodBeat.o(781);
  }
  
  public final void d(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(778);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label132;
      }
      this.oQS = false;
      this.text = ((CharSequence)this.oQI);
      this.ga.setColor(2147483647);
      float f = com.tencent.mm.cd.a.fromDPToPix(getContext(), 1);
      this.ga.setShadowLayer(f, 0.0F, f, -16777216);
    }
    for (;;)
    {
      this.oQM.setColor(paramInt2);
      paramCharSequence = this.oQR;
      if (paramCharSequence != null) {
        paramCharSequence.setText(this.text);
      }
      paramCharSequence = this.oQR;
      if (paramCharSequence == null) {
        break label167;
      }
      paramCharSequence.refresh();
      AppMethodBeat.o(778);
      return;
      i = 0;
      break;
      label132:
      this.oQS = true;
      if (paramCharSequence == null) {
        k.fvU();
      }
      this.text = paramCharSequence;
      this.ga.setColor(paramInt1);
      this.ga.clearShadowLayer();
    }
    label167:
    AppMethodBeat.o(778);
  }
  
  public final boolean getDrawStroke()
  {
    return this.oQS;
  }
  
  public final c getTextDrawer()
  {
    return this.oQR;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(780);
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(-this.oQN, 0.0F);
    a(paramCanvas, 0, 0.0F);
    a(paramCanvas, 1, this.oQP);
    paramCanvas.restore();
    AppMethodBeat.o(780);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(782);
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 > this.maxWidth) {
      paramInt1 = (int)this.maxWidth;
    }
    this.oQQ = true;
    paramInt1 -= this.fQs * 2;
    StaticLayout localStaticLayout = this.layout;
    Object localObject = localStaticLayout;
    if (this.oQQ)
    {
      if (paramInt1 < 0) {
        localObject = localStaticLayout;
      }
    }
    else
    {
      this.layout = ((StaticLayout)localObject);
      paramInt1 = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
      if (paramInt1 > this.oQO) {
        this.oQO = paramInt1;
      }
      if (this.layout.getLineCount() > 1) {
        break label425;
      }
    }
    label425:
    for (paramInt1 = (int)this.oQO;; paramInt1 = (int)(2.0F * this.oQO + this.oQP))
    {
      paramInt2 = getPaddingBottom();
      int i = getPaddingTop();
      float f2 = this.layout.getLineLeft(0);
      float f5 = this.layout.getLineRight(0);
      float f3 = f2;
      float f4 = f5;
      if (this.layout.getLineCount() > 1)
      {
        float f1 = f2;
        if (f2 > this.layout.getLineLeft(1)) {
          f1 = this.layout.getLineLeft(1);
        }
        f3 = f1;
        f4 = f5;
        if (f5 < this.layout.getLineRight(1))
        {
          f4 = this.layout.getLineRight(1);
          f3 = f1;
        }
      }
      this.oQN = (f3 - this.fQs);
      setMeasuredDimension((int)(f4 - f3 + this.fQs * 2), paramInt1 + (paramInt2 + i));
      AppMethodBeat.o(782);
      return;
      localObject = this.oQR;
      if (localObject != null) {
        ((c)localObject).refresh();
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = StaticLayout.Builder.obtain(this.text, 0, this.text.length(), this.ga, paramInt1).setAlignment(this.ggL).setIncludePad(this.oQL).setMaxLines(2).setLineSpacing(this.oQK, this.oQJ).setEllipsize(TextUtils.TruncateAt.END).build();
        k.g(localObject, "StaticLayout.Builder.obt…                 .build()");
      }
      for (;;)
      {
        this.oQQ = false;
        break;
        localObject = new StaticLayout(this.text, this.ga, paramInt1, this.ggL, this.oQJ, this.oQK, this.oQL);
      }
    }
  }
  
  public final void setDrawStroke(boolean paramBoolean)
  {
    this.oQS = paramBoolean;
  }
  
  public final void setMaxWidth(float paramFloat)
  {
    this.maxWidth = paramFloat;
  }
  
  public final void setTextDrawer(c paramc)
  {
    this.oQR = paramc;
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(779);
    this.ga.setTypeface(paramTypeface);
    this.oQM.setTypeface(paramTypeface);
    AppMethodBeat.o(779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView
 * JD-Core Version:    0.7.0.1
 */