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
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.j;
import com.tencent.mm.ui.aw;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentTimeTv", "Landroid/widget/TextView;", "hintTextColor", "sumTimeTv", "textColor", "textSize", "formatSecToMin", "", "second", "initAttribute", "", "defStyle", "setCurrentTime", "sec", "setHintTextColor", "color", "setSumTime", "setTextColor", "setTextSize", "unit", "size", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoSeekTimeView
  extends LinearLayout
{
  private final TextView Grj;
  private final TextView Grk;
  private int hintTextColor;
  private int textColor;
  private int textSize;
  
  public FinderVideoSeekTimeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335255);
    this.textColor = -2147483648;
    this.hintTextColor = -2147483648;
    this.textSize = -1;
    paramContext = new TextView(getContext());
    aw.a((Paint)paramContext.getPaint(), 0.8F);
    ah localah = ah.aiuX;
    this.Grj = paramContext;
    paramContext = new TextView(getContext());
    aw.a((Paint)paramContext.getPaint(), 0.8F);
    localah = ah.aiuX;
    this.Grk = paramContext;
    setOrientation(0);
    setGravity(17);
    addView((View)this.Grj);
    addView((View)this.Grk);
    this.Grj.setShadowLayer(6.0F, 0.0F, 0.0F, getContext().getResources().getColor(e.b.BW_0_Alpha_0_3));
    this.Grk.setShadowLayer(6.0F, 0.0F, 0.0F, getContext().getResources().getColor(e.b.BW_0_Alpha_0_3));
    b(paramAttributeSet, 0);
    AppMethodBeat.o(335255);
  }
  
  public FinderVideoSeekTimeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335259);
    this.textColor = -2147483648;
    this.hintTextColor = -2147483648;
    this.textSize = -1;
    paramContext = new TextView(getContext());
    aw.a((Paint)paramContext.getPaint(), 0.8F);
    ah localah = ah.aiuX;
    this.Grj = paramContext;
    paramContext = new TextView(getContext());
    aw.a((Paint)paramContext.getPaint(), 0.8F);
    localah = ah.aiuX;
    this.Grk = paramContext;
    setOrientation(0);
    setGravity(17);
    addView((View)this.Grj);
    addView((View)this.Grk);
    this.Grj.setShadowLayer(6.0F, 0.0F, 0.0F, getContext().getResources().getColor(e.b.BW_0_Alpha_0_3));
    this.Grk.setShadowLayer(6.0F, 0.0F, 0.0F, getContext().getResources().getColor(e.b.BW_0_Alpha_0_3));
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(335259);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(335268);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, e.j.FinderVideoSeekTimeView, paramInt, 0);
    s.s(paramAttributeSet, "context.obtainStyledAttr…eekTimeView, defStyle, 0)");
    this.textColor = paramAttributeSet.getColor(e.j.FinderVideoSeekTimeView_textColor, -2147483648);
    this.hintTextColor = paramAttributeSet.getColor(e.j.FinderVideoSeekTimeView_hintTextColor, -2147483648);
    this.textSize = paramAttributeSet.getDimensionPixelSize(e.j.FinderVideoSeekTimeView_textSize, -1);
    if (this.textSize != -1) {
      bm(this.textSize);
    }
    if (this.textColor != -2147483648) {
      setTextColor(this.textColor);
    }
    if (this.hintTextColor != -2147483648) {
      setHintTextColor(this.hintTextColor);
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(335268);
  }
  
  private void bm(float paramFloat)
  {
    AppMethodBeat.i(335272);
    this.Grj.setTextSize(0, paramFloat);
    this.Grk.setTextSize(0, paramFloat);
    AppMethodBeat.o(335272);
  }
  
  private static String formatSecToMin(int paramInt)
  {
    AppMethodBeat.i(335279);
    Object localObject = am.aixg;
    localObject = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Long.valueOf(paramInt / 60L), Long.valueOf(paramInt % 60L) }, 2));
    s.s(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(335279);
    return localObject;
  }
  
  public final void setCurrentTime(int paramInt)
  {
    AppMethodBeat.i(335299);
    this.Grj.setText((CharSequence)formatSecToMin(paramInt));
    AppMethodBeat.o(335299);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(335287);
    this.Grk.setTextColor(paramInt);
    AppMethodBeat.o(335287);
  }
  
  public final void setSumTime(int paramInt)
  {
    AppMethodBeat.i(335292);
    this.Grk.setText((CharSequence)s.X(" / ", formatSecToMin(paramInt)));
    AppMethodBeat.o(335292);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(335282);
    this.Grj.setTextColor(paramInt);
    AppMethodBeat.o(335282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekTimeView
 * JD-Core Version:    0.7.0.1
 */