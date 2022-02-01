package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.ui.ar;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentTimeTv", "Landroid/widget/TextView;", "hintTextColor", "sumTimeTv", "textColor", "textSize", "formatSecToMin", "", "second", "initAttribute", "", "defStyle", "setCurrentTime", "sec", "setHintTextColor", "color", "setSumTime", "setTextColor", "setTextSize", "unit", "size", "", "plugin-finder_release"})
public final class FinderVideoSeekTimeView
  extends LinearLayout
{
  private final TextView AOQ;
  private final TextView AOR;
  private int hintTextColor;
  private int textColor;
  private int textSize;
  
  public FinderVideoSeekTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264448);
    this.textColor = -2147483648;
    this.hintTextColor = -2147483648;
    this.textSize = -1;
    paramContext = new TextView(getContext());
    ar.a((Paint)paramContext.getPaint(), 0.8F);
    this.AOQ = paramContext;
    paramContext = new TextView(getContext());
    ar.a((Paint)paramContext.getPaint(), 0.8F);
    this.AOR = paramContext;
    setOrientation(0);
    setGravity(17);
    addView((View)this.AOQ);
    addView((View)this.AOR);
    paramContext = this.AOQ;
    Context localContext = getContext();
    p.j(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(b.c.BW_0_Alpha_0_3));
    paramContext = this.AOR;
    localContext = getContext();
    p.j(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(b.c.BW_0_Alpha_0_3));
    b(paramAttributeSet, 0);
    AppMethodBeat.o(264448);
  }
  
  public FinderVideoSeekTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(264449);
    this.textColor = -2147483648;
    this.hintTextColor = -2147483648;
    this.textSize = -1;
    paramContext = new TextView(getContext());
    ar.a((Paint)paramContext.getPaint(), 0.8F);
    this.AOQ = paramContext;
    paramContext = new TextView(getContext());
    ar.a((Paint)paramContext.getPaint(), 0.8F);
    this.AOR = paramContext;
    setOrientation(0);
    setGravity(17);
    addView((View)this.AOQ);
    addView((View)this.AOR);
    paramContext = this.AOQ;
    Context localContext = getContext();
    p.j(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(b.c.BW_0_Alpha_0_3));
    paramContext = this.AOR;
    localContext = getContext();
    p.j(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(b.c.BW_0_Alpha_0_3));
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(264449);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(264442);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.l.FinderVideoSeekTimeView, paramInt, 0);
    this.textColor = paramAttributeSet.getColor(b.l.FinderVideoSeekTimeView_textColor, -2147483648);
    this.hintTextColor = paramAttributeSet.getColor(b.l.FinderVideoSeekTimeView_hintTextColor, -2147483648);
    this.textSize = paramAttributeSet.getDimensionPixelSize(b.l.FinderVideoSeekTimeView_textSize, -1);
    if (this.textSize != -1)
    {
      float f = this.textSize;
      this.AOQ.setTextSize(0, f);
      this.AOR.setTextSize(0, f);
    }
    if (this.textColor != -2147483648) {
      setTextColor(this.textColor);
    }
    if (this.hintTextColor != -2147483648) {
      setHintTextColor(this.hintTextColor);
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(264442);
  }
  
  private static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(264447);
    Object localObject = af.aaBG;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) }, 2));
    p.j(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(264447);
    return localObject;
  }
  
  public final void setCurrentTime(int paramInt)
  {
    AppMethodBeat.i(264446);
    this.AOQ.setText((CharSequence)formatSecToMin(paramInt));
    AppMethodBeat.o(264446);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(264444);
    this.AOR.setTextColor(paramInt);
    AppMethodBeat.o(264444);
  }
  
  public final void setSumTime(int paramInt)
  {
    AppMethodBeat.i(264445);
    this.AOR.setText((CharSequence)(" / " + formatSecToMin(paramInt)));
    AppMethodBeat.o(264445);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(264443);
    this.AOQ.setTextColor(paramInt);
    AppMethodBeat.o(264443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekTimeView
 * JD-Core Version:    0.7.0.1
 */