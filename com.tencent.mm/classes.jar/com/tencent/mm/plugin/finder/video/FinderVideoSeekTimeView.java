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
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.ui.ao;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentTimeTv", "Landroid/widget/TextView;", "hintTextColor", "sumTimeTv", "textColor", "textSize", "formatSecToMin", "", "second", "initAttribute", "", "defStyle", "setCurrentTime", "sec", "setHintTextColor", "color", "setSumTime", "setTextColor", "setTextSize", "unit", "size", "", "plugin-finder_release"})
public final class FinderVideoSeekTimeView
  extends LinearLayout
{
  private int textColor;
  private int textSize;
  private int wfU;
  private final TextView wfV;
  private final TextView wfW;
  
  public FinderVideoSeekTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254377);
    this.textColor = -2147483648;
    this.wfU = -2147483648;
    this.textSize = -1;
    paramContext = new TextView(getContext());
    ao.a((Paint)paramContext.getPaint(), 0.8F);
    this.wfV = paramContext;
    paramContext = new TextView(getContext());
    ao.a((Paint)paramContext.getPaint(), 0.8F);
    this.wfW = paramContext;
    setOrientation(0);
    setGravity(17);
    addView((View)this.wfV);
    addView((View)this.wfW);
    paramContext = this.wfV;
    Context localContext = getContext();
    p.g(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(2131099662));
    paramContext = this.wfW;
    localContext = getContext();
    p.g(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(2131099662));
    b(paramAttributeSet, 0);
    AppMethodBeat.o(254377);
  }
  
  public FinderVideoSeekTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254378);
    this.textColor = -2147483648;
    this.wfU = -2147483648;
    this.textSize = -1;
    paramContext = new TextView(getContext());
    ao.a((Paint)paramContext.getPaint(), 0.8F);
    this.wfV = paramContext;
    paramContext = new TextView(getContext());
    ao.a((Paint)paramContext.getPaint(), 0.8F);
    this.wfW = paramContext;
    setOrientation(0);
    setGravity(17);
    addView((View)this.wfV);
    addView((View)this.wfW);
    paramContext = this.wfV;
    Context localContext = getContext();
    p.g(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(2131099662));
    paramContext = this.wfW;
    localContext = getContext();
    p.g(localContext, "context");
    paramContext.setShadowLayer(6.0F, 0.0F, 0.0F, localContext.getResources().getColor(2131099662));
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(254378);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(254371);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.a.FinderVideoSeekTimeView, paramInt, 0);
    this.textColor = paramAttributeSet.getColor(1, -2147483648);
    this.wfU = paramAttributeSet.getColor(0, -2147483648);
    this.textSize = paramAttributeSet.getDimensionPixelSize(2, -1);
    if (this.textSize != -1)
    {
      float f = this.textSize;
      this.wfV.setTextSize(0, f);
      this.wfW.setTextSize(0, f);
    }
    if (this.textColor != -2147483648) {
      setTextColor(this.textColor);
    }
    if (this.wfU != -2147483648) {
      setHintTextColor(this.wfU);
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(254371);
  }
  
  private static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(254376);
    Object localObject = ae.SYK;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) }, 2));
    p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(254376);
    return localObject;
  }
  
  public final void setCurrentTime(int paramInt)
  {
    AppMethodBeat.i(254375);
    this.wfV.setText((CharSequence)formatSecToMin(paramInt));
    AppMethodBeat.o(254375);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(254373);
    this.wfW.setTextColor(paramInt);
    AppMethodBeat.o(254373);
  }
  
  public final void setSumTime(int paramInt)
  {
    AppMethodBeat.i(254374);
    this.wfW.setText((CharSequence)(" / " + formatSecToMin(paramInt)));
    AppMethodBeat.o(254374);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(254372);
    this.wfV.setTextColor(paramInt);
    AppMethodBeat.o(254372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekTimeView
 * JD-Core Version:    0.7.0.1
 */