package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/luckymoney/ui/FixedAlignRightLabelEditText;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alwaysShowLabel", "", "getAlwaysShowLabel", "()Z", "setAlwaysShowLabel", "(Z)V", "labelPaint", "Landroid/graphics/Paint;", "labelText", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setFixedLabelText", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FixedAlignRightLabelEditText
  extends EditText
{
  private String KyT;
  private Paint KyU;
  private boolean KyV;
  
  public FixedAlignRightLabelEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(284097);
    this.KyU = new Paint();
    AppMethodBeat.o(284097);
  }
  
  public FixedAlignRightLabelEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(284102);
    this.KyU = new Paint();
    AppMethodBeat.o(284102);
  }
  
  public final boolean getAlwaysShowLabel()
  {
    return this.KyV;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(284115);
    String str = this.KyT;
    if (str != null) {
      if (((CharSequence)getText().toString()).length() != 0) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (getAlwaysShowLabel()))
      {
        float f1 = getWidth();
        TextPaint localTextPaint = getPaint();
        Editable localEditable = getText();
        s.s(localEditable, "text");
        float f2 = localTextPaint.measureText(s.X(str, localEditable));
        this.KyU.setAntiAlias(true);
        this.KyU.setTextSize(getPaint().getTextSize());
        this.KyU.setColor(getCurrentTextColor());
        s.checkNotNull(paramCanvas);
        paramCanvas.drawText(str, f1 - f2, getBaseline(), this.KyU);
      }
      super.onDraw(paramCanvas);
      AppMethodBeat.o(284115);
      return;
    }
  }
  
  public final void setAlwaysShowLabel(boolean paramBoolean)
  {
    this.KyV = paramBoolean;
  }
  
  public final void setFixedLabelText(String paramString)
  {
    AppMethodBeat.i(284112);
    s.u(paramString, "labelText");
    this.KyT = paramString;
    invalidate();
    AppMethodBeat.o(284112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.FixedAlignRightLabelEditText
 * JD-Core Version:    0.7.0.1
 */