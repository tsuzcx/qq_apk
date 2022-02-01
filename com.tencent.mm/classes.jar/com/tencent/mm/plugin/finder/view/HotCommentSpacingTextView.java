package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/HotCommentSpacingTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ELLIPSIS_NORMAL", "", "extraEllipsizeWidth", "isCustomEllipsized", "", "originalText", "", "originalTextType", "Landroid/widget/TextView$BufferType;", "getExtraEllipsizeWidth", "getText", "isEllipsized", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setExtraEllipsizeWidth", "maxPixels", "setMaxWidth", "setSubText", "startIndex", "endIndex", "isWithEllipse", "setText", "text", "type", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HotCommentSpacingTextView
  extends AppCompatTextView
{
  private final String GwF;
  private CharSequence GwG;
  private TextView.BufferType GwH;
  private boolean GwI;
  private int extraEllipsizeWidth;
  
  public HotCommentSpacingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344354);
    this.GwF = "…";
    AppMethodBeat.o(344354);
  }
  
  public HotCommentSpacingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344361);
    this.GwF = "…";
    AppMethodBeat.o(344361);
  }
  
  private final void aR(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344368);
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
        AppMethodBeat.o(344368);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.GwG;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((CharSequence)localObject).subSequence(0, paramInt))
    {
      super.setText((CharSequence)(localObject + this.GwF), this.GwH);
      AppMethodBeat.o(344368);
      return;
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
    AppMethodBeat.i(344385);
    super.onMeasure(paramInt1, paramInt2);
    float f = getPaint().measureText(this.GwF);
    if ((getEllipsize() == TextUtils.TruncateAt.END) && (this.extraEllipsizeWidth > 0) && (this.extraEllipsizeWidth <= getMeasuredWidth()) && ((getLayout().getEllipsisCount(getLayout().getLineCount() - 1) > 0) || (this.GwI)))
    {
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
          break label192;
        }
        aR(j, true);
      }
      for (this.GwI = true;; this.GwI = true)
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(344385);
        return;
        i = localCharSequence.length();
        break;
        label192:
        aR(j, false);
      }
      label207:
      if ((j >= i) && (super.getText().length() != i))
      {
        super.setText(this.GwG, this.GwH);
        super.onMeasure(paramInt1, paramInt2);
        this.GwI = false;
        AppMethodBeat.o(344385);
      }
    }
    else
    {
      super.setText(this.GwG, this.GwH);
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(344385);
  }
  
  public final void setExtraEllipsizeWidth(int paramInt)
  {
    AppMethodBeat.i(344375);
    this.extraEllipsizeWidth = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(344375);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(344372);
    super.setMaxWidth(paramInt);
    AppMethodBeat.o(344372);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(344390);
    super.setText(paramCharSequence, paramBufferType);
    this.GwG = paramCharSequence;
    this.GwH = paramBufferType;
    AppMethodBeat.o(344390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.HotCommentSpacingTextView
 * JD-Core Version:    0.7.0.1
 */