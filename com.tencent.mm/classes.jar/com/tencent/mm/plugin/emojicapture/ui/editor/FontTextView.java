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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/FontTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alignment", "Landroid/text/Layout$Alignment;", "contentLeft", "", "contentPadding", "defaultText", "", "drawStroke", "", "getDrawStroke", "()Z", "setDrawStroke", "(Z)V", "includePadding", "layout", "Landroid/text/StaticLayout;", "lineHeight", "lineSpacing", "maxWidth", "newLayout", "spacingAddition", "spacingMultiplier", "strokePaint", "Landroid/text/TextPaint;", "text", "", "textDrawer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "getTextDrawer", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "setTextDrawer", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;)V", "textPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "line", "lineSpace", "makeNewLayout", "width", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "setTypeface", "typeface", "Landroid/graphics/Typeface;", "updateText", "color", "strokeColor", "change", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FontTextView
  extends View
{
  private CharSequence bba;
  private final Layout.Alignment bbd;
  private final boolean bbj;
  private final int contentPadding;
  private TextPaint dso;
  private StaticLayout layout;
  private float maxWidth;
  private String ymE;
  private final float ymF;
  private final float ymG;
  private TextPaint ymH;
  private float ymI;
  private float ymJ;
  private float ymK;
  private boolean ymL;
  private c ymM;
  private boolean ymN;
  
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
    this.bbd = Layout.Alignment.ALIGN_CENTER;
    this.ymF = 1.0F;
    this.dso = new TextPaint();
    this.ymH = new TextPaint();
    this.bba = ((CharSequence)"");
    s.checkNotNull(paramContext);
    float f = paramContext.getResources().getDimension(a.d.ydW);
    this.ymJ = paramContext.getResources().getDimension(a.d.ydX);
    this.ymK = paramContext.getResources().getDimension(a.d.ydY);
    paramAttributeSet = paramContext.getResources().getString(a.i.yfC);
    s.s(paramAttributeSet, "context.resources.getStr…pture_emoji_text_default)");
    this.ymE = paramAttributeSet;
    this.contentPadding = com.tencent.mm.cd.a.fromDPToPix(paramContext, 2);
    this.dso.setAntiAlias(true);
    this.dso.setTextSize(f);
    this.dso.setColor(2147483647);
    f = com.tencent.mm.cd.a.fromDPToPix(paramContext, 1);
    this.dso.setShadowLayer(f, 0.0F, f, -16777216);
    this.ymH.setStrokeWidth(paramContext.getResources().getDimension(a.d.ydZ));
    this.ymH.setAntiAlias(true);
    this.ymH.setTextSize(this.dso.getTextSize());
    this.ymH.setStyle(Paint.Style.STROKE);
    this.layout = new StaticLayout(this.bba, this.dso, getWidth(), this.bbd, this.ymF, this.ymG, this.bbj);
    this.ymM = ((c)new com.tencent.mm.plugin.emojicapture.ui.editor.text.a());
    this.bba = ((CharSequence)this.ymE);
    paramContext = this.ymM;
    if (paramContext != null) {
      paramContext.setText(this.bba);
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
      if (this.ymN)
      {
        localc = this.ymM;
        if (localc != null) {
          localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.ymH, bool);
        }
      }
      c localc = this.ymM;
      if (localc != null) {
        localc.a(paramCanvas, this.layout.getLineStart(paramInt), i, f, paramFloat, (Paint)this.dso, bool);
      }
      AppMethodBeat.o(781);
      return;
      bool = false;
      break;
    }
  }
  
  public final void b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(778);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label132;
      }
      this.ymN = false;
      this.bba = ((CharSequence)this.ymE);
      this.dso.setColor(2147483647);
      float f = com.tencent.mm.cd.a.fromDPToPix(getContext(), 1);
      this.dso.setShadowLayer(f, 0.0F, f, -16777216);
    }
    for (;;)
    {
      this.ymH.setColor(paramInt2);
      paramCharSequence = this.ymM;
      if (paramCharSequence != null) {
        paramCharSequence.setText(this.bba);
      }
      paramCharSequence = this.ymM;
      if (paramCharSequence != null) {
        paramCharSequence.bDL();
      }
      AppMethodBeat.o(778);
      return;
      i = 0;
      break;
      label132:
      this.ymN = true;
      s.checkNotNull(paramCharSequence);
      this.bba = paramCharSequence;
      this.dso.setColor(paramInt1);
      this.dso.clearShadowLayer();
    }
  }
  
  public final boolean getDrawStroke()
  {
    return this.ymN;
  }
  
  public final c getTextDrawer()
  {
    return this.ymM;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(780);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(-this.ymI, 0.0F);
    a(paramCanvas, 0, 0.0F);
    a(paramCanvas, 1, this.ymK);
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
    this.ymL = true;
    paramInt1 -= this.contentPadding * 2;
    StaticLayout localStaticLayout = this.layout;
    Object localObject = localStaticLayout;
    if (this.ymL)
    {
      if (paramInt1 < 0) {
        localObject = localStaticLayout;
      }
    }
    else
    {
      this.layout = ((StaticLayout)localObject);
      paramInt1 = this.layout.getLineBottom(0) - this.layout.getLineTop(0);
      if (paramInt1 > this.ymJ) {
        this.ymJ = paramInt1;
      }
      if (this.layout.getLineCount() > 1) {
        break label425;
      }
    }
    label425:
    for (paramInt1 = (int)this.ymJ;; paramInt1 = (int)(2.0F * this.ymJ + this.ymK))
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
      this.ymI = (f3 - this.contentPadding);
      setMeasuredDimension((int)(f4 - f3 + this.contentPadding * 2), paramInt1 + (paramInt2 + i));
      AppMethodBeat.o(782);
      return;
      localObject = this.ymM;
      if (localObject != null) {
        ((c)localObject).bDL();
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = StaticLayout.Builder.obtain(this.bba, 0, this.bba.length(), this.dso, paramInt1).setAlignment(this.bbd).setIncludePad(this.bbj).setMaxLines(2).setLineSpacing(this.ymG, this.ymF).setEllipsize(TextUtils.TruncateAt.END).build();
        s.s(localObject, "obtain(text, 0, text.len…                 .build()");
      }
      for (;;)
      {
        this.ymL = false;
        break;
        localObject = new StaticLayout(this.bba, this.dso, paramInt1, this.bbd, this.ymF, this.ymG, this.bbj);
      }
    }
  }
  
  public final void setDrawStroke(boolean paramBoolean)
  {
    this.ymN = paramBoolean;
  }
  
  public final void setMaxWidth(float paramFloat)
  {
    this.maxWidth = paramFloat;
  }
  
  public final void setTextDrawer(c paramc)
  {
    this.ymM = paramc;
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(779);
    this.dso.setTypeface(paramTypeface);
    this.ymH.setTypeface(paramTypeface);
    AppMethodBeat.o(779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.FontTextView
 * JD-Core Version:    0.7.0.1
 */