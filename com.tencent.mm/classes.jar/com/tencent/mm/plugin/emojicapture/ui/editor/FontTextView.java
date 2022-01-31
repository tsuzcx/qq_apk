package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.plugin.emojicapture.ui.editor.a.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"})
public final class FontTextView
  extends View
{
  private final Layout.Alignment eLF;
  private TextPaint eLQ;
  private StaticLayout layout;
  private String lzO;
  private final float lzP;
  private final float lzQ;
  private final boolean lzR;
  private TextPaint lzS;
  private final int lzT;
  private float lzU;
  private float lzV;
  private float lzW;
  private boolean lzX;
  private c lzY;
  private boolean lzZ;
  private float maxWidth;
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
    AppMethodBeat.i(3109);
    this.eLF = Layout.Alignment.ALIGN_CENTER;
    this.lzP = 1.0F;
    this.eLQ = new TextPaint();
    this.lzS = new TextPaint();
    this.text = ((CharSequence)"");
    if (paramContext == null) {
      j.ebi();
    }
    float f = paramContext.getResources().getDimension(2131428341);
    this.lzV = paramContext.getResources().getDimension(2131428343);
    this.lzW = paramContext.getResources().getDimension(2131428344);
    paramAttributeSet = paramContext.getResources().getString(2131297850);
    j.p(paramAttributeSet, "context.resources.getStr…pture_emoji_text_default)");
    this.lzO = paramAttributeSet;
    this.lzT = com.tencent.mm.cb.a.fromDPToPix(paramContext, 2);
    this.eLQ.setAntiAlias(true);
    this.eLQ.setTextSize(f);
    this.eLQ.setColor(2147483647);
    f = com.tencent.mm.cb.a.fromDPToPix(paramContext, 1);
    this.eLQ.setShadowLayer(f, 0.0F, f, -16777216);
    this.lzS.setStrokeWidth(paramContext.getResources().getDimension(2131428345));
    this.lzS.setAntiAlias(true);
    this.lzS.setTextSize(this.eLQ.getTextSize());
    this.lzS.setStyle(Paint.Style.STROKE);
    this.layout = new StaticLayout(this.text, this.eLQ, getWidth(), this.eLF, this.lzP, this.lzQ, this.lzR);
    setLayerType(1, null);
    this.lzY = ((c)new com.tencent.mm.plugin.emojicapture.ui.editor.a.a());
    this.text = ((CharSequence)this.lzO);
    paramContext = this.lzY;
    if (paramContext != null)
    {
      paramContext.setText(this.text);
      AppMethodBeat.o(3109);
      return;
    }
    AppMethodBeat.o(3109);
  }
  
  private final void a(Canvas paramCanvas, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(3107);
    if ((paramInt < 0) || (paramInt >= this.layout.getLineCount()))
    {
      AppMethodBeat.o(3107);
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
      if (this.lzZ)
      {
        localc = this.lzY;
        if (localc != null) {
          localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.lzS, bool);
        }
      }
      c localc = this.lzY;
      if (localc == null) {
        break label215;
      }
      localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.eLQ, bool);
      AppMethodBeat.o(3107);
      return;
      bool = false;
      break;
    }
    label215:
    AppMethodBeat.o(3107);
  }
  
  public final void d(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3104);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label132;
      }
      this.lzZ = false;
      this.text = ((CharSequence)this.lzO);
      this.eLQ.setColor(2147483647);
      float f = com.tencent.mm.cb.a.fromDPToPix(getContext(), 1);
      this.eLQ.setShadowLayer(f, 0.0F, f, -16777216);
    }
    for (;;)
    {
      this.lzS.setColor(paramInt2);
      paramCharSequence = this.lzY;
      if (paramCharSequence != null) {
        paramCharSequence.setText(this.text);
      }
      paramCharSequence = this.lzY;
      if (paramCharSequence == null) {
        break label167;
      }
      paramCharSequence.refresh();
      AppMethodBeat.o(3104);
      return;
      i = 0;
      break;
      label132:
      this.lzZ = true;
      if (paramCharSequence == null) {
        j.ebi();
      }
      this.text = paramCharSequence;
      this.eLQ.setColor(paramInt1);
      this.eLQ.clearShadowLayer();
    }
    label167:
    AppMethodBeat.o(3104);
  }
  
  public final boolean getDrawStroke()
  {
    return this.lzZ;
  }
  
  public final c getTextDrawer()
  {
    return this.lzY;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(3106);
    j.q(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(-this.lzU, 0.0F);
    a(paramCanvas, 0, 0.0F);
    a(paramCanvas, 1, this.lzW);
    paramCanvas.restore();
    AppMethodBeat.o(3106);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3108);
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 > this.maxWidth) {
      paramInt1 = (int)this.maxWidth;
    }
    this.lzX = true;
    paramInt1 -= this.lzT * 2;
    StaticLayout localStaticLayout = this.layout;
    Object localObject = localStaticLayout;
    if (this.lzX)
    {
      if (paramInt1 < 0) {
        localObject = localStaticLayout;
      }
    }
    else
    {
      this.layout = ((StaticLayout)localObject);
      paramInt1 = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
      if (paramInt1 > this.lzV) {
        this.lzV = paramInt1;
      }
      if (this.layout.getLineCount() > 1) {
        break label425;
      }
    }
    label425:
    for (paramInt1 = (int)this.lzV;; paramInt1 = (int)(2.0F * this.lzV + this.lzW))
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
      this.lzU = (f3 - this.lzT);
      setMeasuredDimension((int)(f4 - f3 + this.lzT * 2), paramInt1 + (paramInt2 + i));
      AppMethodBeat.o(3108);
      return;
      localObject = this.lzY;
      if (localObject != null) {
        ((c)localObject).refresh();
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = StaticLayout.Builder.obtain(this.text, 0, this.text.length(), this.eLQ, paramInt1).setAlignment(this.eLF).setIncludePad(this.lzR).setMaxLines(2).setLineSpacing(this.lzQ, this.lzP).setEllipsize(TextUtils.TruncateAt.END).build();
        j.p(localObject, "StaticLayout.Builder.obt…                 .build()");
      }
      for (;;)
      {
        this.lzX = false;
        break;
        localObject = new StaticLayout(this.text, this.eLQ, paramInt1, this.eLF, this.lzP, this.lzQ, this.lzR);
      }
    }
  }
  
  public final void setDrawStroke(boolean paramBoolean)
  {
    this.lzZ = paramBoolean;
  }
  
  public final void setMaxWidth(float paramFloat)
  {
    this.maxWidth = paramFloat;
  }
  
  public final void setTextDrawer(c paramc)
  {
    this.lzY = paramc;
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(3105);
    this.eLQ.setTypeface(paramTypeface);
    this.lzS.setTypeface(paramTypeface);
    AppMethodBeat.o(3105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView
 * JD-Core Version:    0.7.0.1
 */