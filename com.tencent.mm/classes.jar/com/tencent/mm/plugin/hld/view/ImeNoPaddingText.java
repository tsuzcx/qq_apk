package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.l;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeNoPaddingText;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeNoPaddingText
  extends AppCompatTextView
{
  public static final ImeNoPaddingText.a JzQ;
  
  static
  {
    AppMethodBeat.i(312641);
    JzQ = new ImeNoPaddingText.a((byte)0);
    AppMethodBeat.o(312641);
  }
  
  public ImeNoPaddingText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(312626);
    AppMethodBeat.o(312626);
  }
  
  public ImeNoPaddingText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312637);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.l.NoPaddingTextView, 0, 0);
    s.s(paramContext, "context.theme.obtainStyl….NoPaddingTextView, 0, 0)");
    float f = paramContext.getDimension(a.l.NoPaddingTextView_textSize, 0.0F);
    paramAttributeSet = new Paint();
    paramAttributeSet.setTextSize(f);
    paramAttributeSet = paramAttributeSet.getFontMetricsInt();
    s.s(paramAttributeSet, "paint.fontMetricsInt");
    setTextSize(0, paramContext.getDimension(a.l.NoPaddingTextView_textSize, 0.0F));
    setPadding(0, -((int)Math.ceil(Math.abs((paramAttributeSet.top - paramAttributeSet.ascent) / 2.0D)) + Math.abs(paramAttributeSet.top - paramAttributeSet.ascent)), 0, paramAttributeSet.top - paramAttributeSet.ascent);
    paramContext.recycle();
    AppMethodBeat.o(312637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeNoPaddingText
 * JD-Core Version:    0.7.0.1
 */