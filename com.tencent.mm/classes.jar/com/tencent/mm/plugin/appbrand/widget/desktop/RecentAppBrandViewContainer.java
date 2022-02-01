package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.y;
import java.util.List;

public class RecentAppBrandViewContainer
  extends LinearLayout
{
  Runnable Zq;
  RecentAppBrandView lUs;
  private View lWp;
  boolean lWq;
  private View.OnClickListener lWr;
  private Context mContext;
  
  public RecentAppBrandViewContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49704);
    this.Zq = null;
    this.lWq = true;
    this.lWr = null;
    init(paramContext);
    AppMethodBeat.o(49704);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49705);
    this.Zq = null;
    this.lWq = true;
    this.lWr = null;
    init(paramContext);
    AppMethodBeat.o(49705);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49706);
    this.Zq = null;
    this.lWq = true;
    this.lWr = null;
    init(paramContext);
    AppMethodBeat.o(49706);
  }
  
  private void bse()
  {
    AppMethodBeat.i(49710);
    if (this.lUs.getDataCount() > this.lUs.getMaxShowItemCountIncludeMore())
    {
      this.lWp.setVisibility(0);
      AppMethodBeat.o(49710);
      return;
    }
    this.lWp.setVisibility(4);
    AppMethodBeat.o(49710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49712);
    this.mContext = paramContext;
    paramContext = y.js(paramContext).inflate(2131492988, this);
    this.lUs = ((RecentAppBrandView)paramContext.findViewById(2131303807));
    this.lWp = paramContext.findViewById(2131302475);
    paramContext = new e(this.lWp);
    int i = (int)d.dS(getContext());
    paramContext.lVz.getLayoutParams().width = ((int)(a.ap(getContext(), 2131165568) * 2 * d.dT(getContext())) + i);
    paramContext.lVz.getLayoutParams().height = ((int)(a.ap(getContext(), 2131165568) * 2 * d.dT(getContext())) + i);
    paramContext.kXS.getLayoutParams().width = i;
    paramContext.kXS.getLayoutParams().height = i;
    paramContext.lVy.getLayoutParams().width = i;
    paramContext.lVy.getLayoutParams().height = i;
    paramContext.kXS.setImageResource(2131690904);
    paramContext.lVA.setVisibility(8);
    paramContext.titleTv.setText("");
    paramContext.arI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49702);
        if (RecentAppBrandViewContainer.b(RecentAppBrandViewContainer.this) != null) {
          RecentAppBrandViewContainer.b(RecentAppBrandViewContainer.this).onClick(paramAnonymousView);
        }
        AppMethodBeat.o(49702);
      }
    });
    AppMethodBeat.o(49712);
  }
  
  public RecentAppBrandView getRecentView()
  {
    return this.lUs;
  }
  
  public int getShowLines()
  {
    AppMethodBeat.i(49709);
    if (this.lUs != null)
    {
      int i = this.lUs.getShowLines();
      AppMethodBeat.o(49709);
      return i;
    }
    AppMethodBeat.o(49709);
    return 0;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(49707);
    if (this.lUs != null)
    {
      bse();
      this.lUs.bsd();
    }
    AppMethodBeat.o(49707);
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49708);
    if (this.lUs != null)
    {
      this.lUs.setDataList(paramList);
      bse();
    }
    AppMethodBeat.o(49708);
  }
  
  public void setItemPadding(int paramInt)
  {
    AppMethodBeat.i(49711);
    if (this.lUs != null) {
      this.lUs.setItemPadding(paramInt);
    }
    if (this.lWp != null)
    {
      View localView = this.lWp;
      localView.setPadding(paramInt, localView.getPaddingTop(), paramInt, this.lWp.getPaddingBottom());
    }
    AppMethodBeat.o(49711);
  }
  
  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lWr = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer
 * JD-Core Version:    0.7.0.1
 */