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
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.z;
import java.util.List;

public class RecentAppBrandViewContainer
  extends LinearLayout
{
  Runnable aal;
  private Context mContext;
  RecentAppBrandView mwu;
  private View myr;
  boolean mys;
  private View.OnClickListener myt;
  
  public RecentAppBrandViewContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49704);
    this.aal = null;
    this.mys = true;
    this.myt = null;
    init(paramContext);
    AppMethodBeat.o(49704);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49705);
    this.aal = null;
    this.mys = true;
    this.myt = null;
    init(paramContext);
    AppMethodBeat.o(49705);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49706);
    this.aal = null;
    this.mys = true;
    this.myt = null;
    init(paramContext);
    AppMethodBeat.o(49706);
  }
  
  private void bze()
  {
    AppMethodBeat.i(49710);
    if (this.mwu.getDataCount() > this.mwu.getMaxShowItemCountIncludeMore())
    {
      this.myr.setVisibility(0);
      AppMethodBeat.o(49710);
      return;
    }
    this.myr.setVisibility(4);
    AppMethodBeat.o(49710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49712);
    this.mContext = paramContext;
    paramContext = z.jD(paramContext).inflate(2131492988, this);
    this.mwu = ((RecentAppBrandView)paramContext.findViewById(2131303807));
    this.myr = paramContext.findViewById(2131302475);
    paramContext = new e(this.myr);
    int i = (int)d.ea(getContext());
    paramContext.mxB.getLayoutParams().width = ((int)(a.av(getContext(), 2131165568) * 2 * d.eb(getContext())) + i);
    paramContext.mxB.getLayoutParams().height = ((int)(a.av(getContext(), 2131165568) * 2 * d.eb(getContext())) + i);
    paramContext.lzC.getLayoutParams().width = i;
    paramContext.lzC.getLayoutParams().height = i;
    paramContext.mxA.getLayoutParams().width = i;
    paramContext.mxA.getLayoutParams().height = i;
    paramContext.lzC.setImageResource(2131690904);
    paramContext.mxC.setVisibility(8);
    paramContext.titleTv.setText("");
    paramContext.asD.setOnClickListener(new View.OnClickListener()
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
    return this.mwu;
  }
  
  public int getShowLines()
  {
    AppMethodBeat.i(49709);
    if (this.mwu != null)
    {
      int i = this.mwu.getShowLines();
      AppMethodBeat.o(49709);
      return i;
    }
    AppMethodBeat.o(49709);
    return 0;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(49707);
    if (this.mwu != null)
    {
      bze();
      this.mwu.bzd();
    }
    AppMethodBeat.o(49707);
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49708);
    if (this.mwu != null)
    {
      this.mwu.setDataList(paramList);
      bze();
    }
    AppMethodBeat.o(49708);
  }
  
  public void setItemPadding(int paramInt)
  {
    AppMethodBeat.i(49711);
    if (this.mwu != null) {
      this.mwu.setItemPadding(paramInt);
    }
    if (this.myr != null)
    {
      View localView = this.myr;
      localView.setPadding(paramInt, localView.getPaddingTop(), paramInt, this.myr.getPaddingBottom());
    }
    AppMethodBeat.o(49711);
  }
  
  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.myt = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer
 * JD-Core Version:    0.7.0.1
 */