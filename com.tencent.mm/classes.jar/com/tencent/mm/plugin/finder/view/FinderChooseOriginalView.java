package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.z;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "flag", "getFlag", "()I", "setFlag", "(I)V", "onFlagChangedListener", "Lkotlin/Function1;", "", "getOnFlagChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnFlagChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "tipTv", "Landroid/widget/TextView;", "getTipTv", "()Landroid/widget/TextView;", "setTipTv", "(Landroid/widget/TextView;)V", "refreshView", "setOriginalFlag", "original", "plugin-finder_release"})
public final class FinderChooseOriginalView
  extends LinearLayout
{
  private final String TAG;
  private int drx;
  private TextView ijF;
  private b<? super Integer, y> rVB;
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204099);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.drx = 1;
    setOrientation(1);
    z.jD(getContext()).inflate(2131496174, (ViewGroup)this, true);
    paramContext = findViewById(2131307899);
    k.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.ijF = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new FinderChooseOriginalView.1(this));
    AppMethodBeat.o(204099);
  }
  
  public FinderChooseOriginalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204100);
    this.TAG = "Finder.FinderChooseOriginalView";
    this.drx = 1;
    setOrientation(1);
    z.jD(getContext()).inflate(2131496174, (ViewGroup)this, true);
    paramContext = findViewById(2131307899);
    k.g(paramContext, "findViewById(R.id.original_tip_tv)");
    this.ijF = ((TextView)paramContext);
    setOnClickListener((View.OnClickListener)new FinderChooseOriginalView.1(this));
    AppMethodBeat.o(204100);
  }
  
  public final int getFlag()
  {
    return this.drx;
  }
  
  public final b<Integer, y> getOnFlagChangedListener()
  {
    return this.rVB;
  }
  
  public final TextView getTipTv()
  {
    return this.ijF;
  }
  
  public final void setFlag(int paramInt)
  {
    this.drx = paramInt;
  }
  
  public final void setOnFlagChangedListener(b<? super Integer, y> paramb)
  {
    this.rVB = paramb;
  }
  
  public final void setOriginalFlag(int paramInt)
  {
    AppMethodBeat.i(204098);
    this.drx = paramInt;
    if (this.drx == 1) {
      this.ijF.setText(2131766471);
    }
    for (;;)
    {
      b localb = this.rVB;
      if (localb == null) {
        break;
      }
      localb.ay(Integer.valueOf(paramInt));
      AppMethodBeat.o(204098);
      return;
      if (this.drx == 2) {
        this.ijF.setText(2131766452);
      } else {
        this.ijF.setText((CharSequence)"");
      }
    }
    AppMethodBeat.o(204098);
  }
  
  public final void setTipTv(TextView paramTextView)
  {
    AppMethodBeat.i(204097);
    k.h(paramTextView, "<set-?>");
    this.ijF = paramTextView;
    AppMethodBeat.o(204097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderChooseOriginalView
 * JD-Core Version:    0.7.0.1
 */