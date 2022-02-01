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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"})
public final class FontTextView
  extends View
{
  private final int hbe;
  private final Layout.Alignment huw;
  private TextPaint iW;
  private StaticLayout layout;
  private float maxWidth;
  private String rvd;
  private final float rve;
  private final float rvf;
  private final boolean rvg;
  private TextPaint rvh;
  private float rvi;
  private float rvj;
  private float rvk;
  private boolean rvl;
  private c rvm;
  private boolean rvn;
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
    this.huw = Layout.Alignment.ALIGN_CENTER;
    this.rve = 1.0F;
    this.iW = new TextPaint();
    this.rvh = new TextPaint();
    this.text = ((CharSequence)"");
    if (paramContext == null) {
      p.hyc();
    }
    float f = paramContext.getResources().getDimension(2131166235);
    this.rvj = paramContext.getResources().getDimension(2131166237);
    this.rvk = paramContext.getResources().getDimension(2131166238);
    paramAttributeSet = paramContext.getResources().getString(2131756947);
    p.g(paramAttributeSet, "context.resources.getStr…pture_emoji_text_default)");
    this.rvd = paramAttributeSet;
    this.hbe = com.tencent.mm.cb.a.fromDPToPix(paramContext, 2);
    this.iW.setAntiAlias(true);
    this.iW.setTextSize(f);
    this.iW.setColor(2147483647);
    f = com.tencent.mm.cb.a.fromDPToPix(paramContext, 1);
    this.iW.setShadowLayer(f, 0.0F, f, -16777216);
    this.rvh.setStrokeWidth(paramContext.getResources().getDimension(2131166239));
    this.rvh.setAntiAlias(true);
    this.rvh.setTextSize(this.iW.getTextSize());
    this.rvh.setStyle(Paint.Style.STROKE);
    this.layout = new StaticLayout(this.text, this.iW, getWidth(), this.huw, this.rve, this.rvf, this.rvg);
    this.rvm = ((c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    this.text = ((CharSequence)this.rvd);
    paramContext = this.rvm;
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
      if (this.rvn)
      {
        localc = this.rvm;
        if (localc != null) {
          localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.rvh, bool);
        }
      }
      c localc = this.rvm;
      if (localc == null) {
        break label215;
      }
      localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.iW, bool);
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
      this.rvn = false;
      this.text = ((CharSequence)this.rvd);
      this.iW.setColor(2147483647);
      float f = com.tencent.mm.cb.a.fromDPToPix(getContext(), 1);
      this.iW.setShadowLayer(f, 0.0F, f, -16777216);
    }
    for (;;)
    {
      this.rvh.setColor(paramInt2);
      paramCharSequence = this.rvm;
      if (paramCharSequence != null) {
        paramCharSequence.setText(this.text);
      }
      paramCharSequence = this.rvm;
      if (paramCharSequence == null) {
        break label167;
      }
      paramCharSequence.refresh();
      AppMethodBeat.o(778);
      return;
      i = 0;
      break;
      label132:
      this.rvn = true;
      if (paramCharSequence == null) {
        p.hyc();
      }
      this.text = paramCharSequence;
      this.iW.setColor(paramInt1);
      this.iW.clearShadowLayer();
    }
    label167:
    AppMethodBeat.o(778);
  }
  
  public final boolean getDrawStroke()
  {
    return this.rvn;
  }
  
  public final c getTextDrawer()
  {
    return this.rvm;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(780);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(-this.rvi, 0.0F);
    a(paramCanvas, 0, 0.0F);
    a(paramCanvas, 1, this.rvk);
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
    this.rvl = true;
    paramInt1 -= this.hbe * 2;
    StaticLayout localStaticLayout = this.layout;
    Object localObject = localStaticLayout;
    if (this.rvl)
    {
      if (paramInt1 < 0) {
        localObject = localStaticLayout;
      }
    }
    else
    {
      this.layout = ((StaticLayout)localObject);
      paramInt1 = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
      if (paramInt1 > this.rvj) {
        this.rvj = paramInt1;
      }
      if (this.layout.getLineCount() > 1) {
        break label425;
      }
    }
    label425:
    for (paramInt1 = (int)this.rvj;; paramInt1 = (int)(2.0F * this.rvj + this.rvk))
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
      this.rvi = (f3 - this.hbe);
      setMeasuredDimension((int)(f4 - f3 + this.hbe * 2), paramInt1 + (paramInt2 + i));
      AppMethodBeat.o(782);
      return;
      localObject = this.rvm;
      if (localObject != null) {
        ((c)localObject).refresh();
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = StaticLayout.Builder.obtain(this.text, 0, this.text.length(), this.iW, paramInt1).setAlignment(this.huw).setIncludePad(this.rvg).setMaxLines(2).setLineSpacing(this.rvf, this.rve).setEllipsize(TextUtils.TruncateAt.END).build();
        p.g(localObject, "StaticLayout.Builder.obt…                 .build()");
      }
      for (;;)
      {
        this.rvl = false;
        break;
        localObject = new StaticLayout(this.text, this.iW, paramInt1, this.huw, this.rve, this.rvf, this.rvg);
      }
    }
  }
  
  public final void setDrawStroke(boolean paramBoolean)
  {
    this.rvn = paramBoolean;
  }
  
  public final void setMaxWidth(float paramFloat)
  {
    this.maxWidth = paramFloat;
  }
  
  public final void setTextDrawer(c paramc)
  {
    this.rvm = paramc;
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(779);
    this.iW.setTypeface(paramTypeface);
    this.rvh.setTypeface(paramTypeface);
    AppMethodBeat.o(779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView
 * JD-Core Version:    0.7.0.1
 */