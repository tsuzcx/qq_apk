package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.l;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/EllipsizedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ELLIPSIS_NORMAL", "", "extraEllipsizeWidth", "originalText", "", "originalTextType", "Landroid/widget/TextView$BufferType;", "getText", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setExtraEllipsizeWidth", "maxPixels", "setMaxWidth", "setText", "text", "type", "tryInitAttrs", "plugin-finder_release"})
public final class EllipsizedTextView
  extends AppCompatTextView
{
  private final String AUn;
  private CharSequence AUo;
  private TextView.BufferType AUp;
  private int extraEllipsizeWidth;
  
  public EllipsizedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(283760);
    this.AUn = "…";
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(283760);
  }
  
  public EllipsizedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(283761);
    this.AUn = "…";
    b(paramContext, paramAttributeSet);
    AppMethodBeat.o(283761);
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(283752);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.EllipsizedTextView);
    try
    {
      this.extraEllipsizeWidth = paramContext.getDimensionPixelSize(b.l.EllipsizedTextView_extraEllipsizeWidth, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(283752);
    }
  }
  
  public final CharSequence getText()
  {
    return this.AUo;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = null;
    Object localObject1 = null;
    AppMethodBeat.i(283757);
    super.onMeasure(paramInt1, paramInt2);
    float f = getPaint().measureText(this.AUn);
    Object localObject2;
    int j;
    int i;
    if ((getEllipsize() == TextUtils.TruncateAt.END) && (this.extraEllipsizeWidth > 0) && (this.extraEllipsizeWidth <= getMeasuredWidth()))
    {
      localObject2 = getLayout();
      Layout localLayout = getLayout();
      p.j(localLayout, "layout");
      if (((Layout)localObject2).getEllipsisCount(localLayout.getLineCount() - 1) > 0)
      {
        localObject2 = getLayout();
        localLayout = getLayout();
        p.j(localLayout, "layout");
        j = ((Layout)localObject2).getOffsetForHorizontal(localLayout.getLineCount() - 1, getMeasuredWidth() - f * 1.1F - this.extraEllipsizeWidth);
        localObject2 = this.AUo;
        if (localObject2 == null) {
          break label259;
        }
        i = ((CharSequence)localObject2).length();
        if ((j < i) && (super.getText().length() == i))
        {
          if (this.AUp != TextView.BufferType.NORMAL) {
            break label265;
          }
          localStringBuilder = new StringBuilder();
          localObject2 = this.AUo;
          if (localObject2 != null) {
            localObject1 = ((CharSequence)localObject2).subSequence(0, j);
          }
          super.setText((CharSequence)((CharSequence)localObject1 + this.AUn));
        }
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(283757);
      return;
      label259:
      i = 0;
      break;
      label265:
      localObject2 = this.AUo;
      localObject1 = localStringBuilder;
      if (localObject2 != null) {
        localObject1 = ((CharSequence)localObject2).subSequence(0, j);
      }
      super.setText((CharSequence)localObject1, this.AUp);
    }
  }
  
  public final void setExtraEllipsizeWidth(int paramInt)
  {
    AppMethodBeat.i(283754);
    this.extraEllipsizeWidth = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(283754);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(283753);
    super.setMaxWidth(paramInt);
    AppMethodBeat.o(283753);
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(283758);
    super.setText(paramCharSequence, paramBufferType);
    this.AUo = paramCharSequence;
    this.AUp = paramBufferType;
    AppMethodBeat.o(283758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.EllipsizedTextView
 * JD-Core Version:    0.7.0.1
 */