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
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"})
public final class FontTextView
  extends View
{
  private CharSequence LV;
  private TextPaint bzo;
  private final int contentPadding;
  private final Layout.Alignment kgr;
  private StaticLayout layout;
  private float maxWidth;
  private String vaH;
  private final float vaI;
  private final float vaJ;
  private final boolean vaK;
  private TextPaint vaL;
  private float vaM;
  private float vaN;
  private float vaO;
  private boolean vaP;
  private c vaQ;
  private boolean vaR;
  
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
    this.kgr = Layout.Alignment.ALIGN_CENTER;
    this.vaI = 1.0F;
    this.bzo = new TextPaint();
    this.vaL = new TextPaint();
    this.LV = ((CharSequence)"");
    if (paramContext == null) {
      p.iCn();
    }
    float f = paramContext.getResources().getDimension(a.d.uRi);
    this.vaN = paramContext.getResources().getDimension(a.d.uRj);
    this.vaO = paramContext.getResources().getDimension(a.d.uRk);
    paramAttributeSet = paramContext.getResources().getString(a.i.uSO);
    p.j(paramAttributeSet, "context.resources.getStr…pture_emoji_text_default)");
    this.vaH = paramAttributeSet;
    this.contentPadding = com.tencent.mm.ci.a.fromDPToPix(paramContext, 2);
    this.bzo.setAntiAlias(true);
    this.bzo.setTextSize(f);
    this.bzo.setColor(2147483647);
    f = com.tencent.mm.ci.a.fromDPToPix(paramContext, 1);
    this.bzo.setShadowLayer(f, 0.0F, f, -16777216);
    this.vaL.setStrokeWidth(paramContext.getResources().getDimension(a.d.uRl));
    this.vaL.setAntiAlias(true);
    this.vaL.setTextSize(this.bzo.getTextSize());
    this.vaL.setStyle(Paint.Style.STROKE);
    this.layout = new StaticLayout(this.LV, this.bzo, getWidth(), this.kgr, this.vaI, this.vaJ, this.vaK);
    this.vaQ = ((c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    this.LV = ((CharSequence)this.vaH);
    paramContext = this.vaQ;
    if (paramContext != null)
    {
      paramContext.setText(this.LV);
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
      if (this.vaR)
      {
        localc = this.vaQ;
        if (localc != null) {
          localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.vaL, bool);
        }
      }
      c localc = this.vaQ;
      if (localc == null) {
        break label215;
      }
      localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.bzo, bool);
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
      this.vaR = false;
      this.LV = ((CharSequence)this.vaH);
      this.bzo.setColor(2147483647);
      float f = com.tencent.mm.ci.a.fromDPToPix(getContext(), 1);
      this.bzo.setShadowLayer(f, 0.0F, f, -16777216);
    }
    for (;;)
    {
      this.vaL.setColor(paramInt2);
      paramCharSequence = this.vaQ;
      if (paramCharSequence != null) {
        paramCharSequence.setText(this.LV);
      }
      paramCharSequence = this.vaQ;
      if (paramCharSequence == null) {
        break label167;
      }
      paramCharSequence.bfU();
      AppMethodBeat.o(778);
      return;
      i = 0;
      break;
      label132:
      this.vaR = true;
      if (paramCharSequence == null) {
        p.iCn();
      }
      this.LV = paramCharSequence;
      this.bzo.setColor(paramInt1);
      this.bzo.clearShadowLayer();
    }
    label167:
    AppMethodBeat.o(778);
  }
  
  public final boolean getDrawStroke()
  {
    return this.vaR;
  }
  
  public final c getTextDrawer()
  {
    return this.vaQ;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(780);
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(-this.vaM, 0.0F);
    a(paramCanvas, 0, 0.0F);
    a(paramCanvas, 1, this.vaO);
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
    this.vaP = true;
    paramInt1 -= this.contentPadding * 2;
    StaticLayout localStaticLayout = this.layout;
    Object localObject = localStaticLayout;
    if (this.vaP)
    {
      if (paramInt1 < 0) {
        localObject = localStaticLayout;
      }
    }
    else
    {
      this.layout = ((StaticLayout)localObject);
      paramInt1 = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
      if (paramInt1 > this.vaN) {
        this.vaN = paramInt1;
      }
      if (this.layout.getLineCount() > 1) {
        break label425;
      }
    }
    label425:
    for (paramInt1 = (int)this.vaN;; paramInt1 = (int)(2.0F * this.vaN + this.vaO))
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
      this.vaM = (f3 - this.contentPadding);
      setMeasuredDimension((int)(f4 - f3 + this.contentPadding * 2), paramInt1 + (paramInt2 + i));
      AppMethodBeat.o(782);
      return;
      localObject = this.vaQ;
      if (localObject != null) {
        ((c)localObject).bfU();
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = StaticLayout.Builder.obtain(this.LV, 0, this.LV.length(), this.bzo, paramInt1).setAlignment(this.kgr).setIncludePad(this.vaK).setMaxLines(2).setLineSpacing(this.vaJ, this.vaI).setEllipsize(TextUtils.TruncateAt.END).build();
        p.j(localObject, "StaticLayout.Builder.obt…                 .build()");
      }
      for (;;)
      {
        this.vaP = false;
        break;
        localObject = new StaticLayout(this.LV, this.bzo, paramInt1, this.kgr, this.vaI, this.vaJ, this.vaK);
      }
    }
  }
  
  public final void setDrawStroke(boolean paramBoolean)
  {
    this.vaR = paramBoolean;
  }
  
  public final void setMaxWidth(float paramFloat)
  {
    this.maxWidth = paramFloat;
  }
  
  public final void setTextDrawer(c paramc)
  {
    this.vaQ = paramc;
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(779);
    this.bzo.setTypeface(paramTypeface);
    this.vaL.setTypeface(paramTypeface);
    AppMethodBeat.o(779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView
 * JD-Core Version:    0.7.0.1
 */