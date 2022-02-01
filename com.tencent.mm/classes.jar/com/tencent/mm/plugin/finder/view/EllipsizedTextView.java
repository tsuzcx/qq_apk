package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/EllipsizedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ELLIPSIS_NORMAL", "", "extraEllipsizeWidth", "isCustomEllipsized", "", "originalText", "", "originalTextType", "Landroid/widget/TextView$BufferType;", "getExtraEllipsizeWidth", "getText", "isEllipsized", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setExtraEllipsizeWidth", "maxPixels", "setMaxWidth", "setSubText", "startIndex", "endIndex", "isWithEllipse", "setText", "text", "type", "tryInitAttrs", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EllipsizedTextView
  extends AppCompatTextView
{
  private final String GwF;
  private CharSequence GwG;
  private TextView.BufferType GwH;
  boolean GwI;
  private int extraEllipsizeWidth;
  
  public EllipsizedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344806);
    this.GwF = "…";
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(344806);
  }
  
  public EllipsizedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344816);
    this.GwF = "…";
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(344816);
  }
  
  private final void aR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344832);
    if ((this.GwG instanceof SpannableString))
    {
      localObject = this.GwG;
      if ((localObject instanceof SpannableString)) {}
      for (localObject = (SpannableString)localObject; localObject != null; localObject = null)
      {
        localObject = ((SpannableString)localObject).subSequence(0, paramInt);
        if (localObject == null) {
          break;
        }
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        if (paramBoolean) {
          ((SpannableStringBuilder)localObject).append((CharSequence)this.GwF);
        }
        super.setText((CharSequence)localObject, this.GwH);
        AppMethodBeat.o(344832);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.GwG;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((CharSequence)localObject).subSequence(0, paramInt))
    {
      super.setText((CharSequence)(localObject + this.GwF), this.GwH);
      AppMethodBeat.o(344832);
      return;
    }
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(344825);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e.j.EllipsizedTextView);
    s.s(paramContext, "context.obtainStyledAttr…eable.EllipsizedTextView)");
    try
    {
      this.extraEllipsizeWidth = paramContext.getDimensionPixelSize(e.j.EllipsizedTextView_extraEllipsizeWidth, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(344825);
    }
  }
  
  public final int getExtraEllipsizeWidth()
  {
    return this.extraEllipsizeWidth;
  }
  
  public final CharSequence getText()
  {
    return this.GwG;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(344861);
    super.onMeasure(paramInt1, paramInt2);
    float f = getPaint().measureText(this.GwF);
    if ((getEllipsize() == TextUtils.TruncateAt.END) && (this.extraEllipsizeWidth > 0) && (this.extraEllipsizeWidth <= getMeasuredWidth()) && ((getLayout().getEllipsisCount(getLayout().getLineCount() - 1) > 0) || (this.GwI)))
    {
      this.GwI = false;
      int j = getLayout().getOffsetForHorizontal(getLayout().getLineCount() - 1, getMeasuredWidth() - f * 1.2F - this.extraEllipsizeWidth);
      CharSequence localCharSequence = this.GwG;
      int i;
      if (localCharSequence == null)
      {
        i = 0;
        if ((j >= i) || (super.getText().length() != i)) {
          break label207;
        }
        if (this.GwH != TextView.BufferType.NORMAL) {
          break label197;
        }
        aR(j, true);
        this.GwI = true;
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(344861);
        return;
        i = localCharSequence.length();
        break;
        label197:
        aR(j, false);
      }
      label207:
      if ((j < i) || (super.getText().length() == i)) {}
    }
    else
    {
      super.setText(this.GwG, this.GwH);
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(344861);
  }
  
  public final void setExtraEllipsizeWidth(int paramInt)
  {
    AppMethodBeat.i(344848);
    this.extraEllipsizeWidth = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(344848);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(344840);
    super.setMaxWidth(paramInt);
    AppMethodBeat.o(344840);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(344865);
    super.setText(paramCharSequence, paramBufferType);
    this.GwG = paramCharSequence;
    this.GwH = paramBufferType;
    AppMethodBeat.o(344865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.EllipsizedTextView
 * JD-Core Version:    0.7.0.1
 */