package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.w;
import java.util.List;

public class RecentAppBrandViewContainer
  extends LinearLayout
{
  Runnable Sn;
  RecentAppBrandView jes;
  private View jgh;
  boolean jgi;
  private View.OnClickListener jgj;
  private Context mContext;
  
  public RecentAppBrandViewContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133953);
    this.Sn = null;
    this.jgi = true;
    this.jgj = null;
    init(paramContext);
    AppMethodBeat.o(133953);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133954);
    this.Sn = null;
    this.jgi = true;
    this.jgj = null;
    init(paramContext);
    AppMethodBeat.o(133954);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133955);
    this.Sn = null;
    this.jgi = true;
    this.jgj = null;
    init(paramContext);
    AppMethodBeat.o(133955);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(133959);
    this.mContext = paramContext;
    paramContext = w.hM(paramContext).inflate(2130968678, this);
    this.jes = ((RecentAppBrandView)paramContext.findViewById(2131821195));
    this.jgh = paramContext.findViewById(2131821196);
    paramContext = new e(this.jgh);
    int i = (int)d.dq(getContext());
    paramContext.jft.getLayoutParams().width = ((int)(a.ap(getContext(), 2131427854) * 2 * d.dr(getContext())) + i);
    paramContext.jft.getLayoutParams().height = ((int)(a.ap(getContext(), 2131427854) * 2 * d.dr(getContext())) + i);
    paramContext.ivs.getLayoutParams().width = i;
    paramContext.ivs.getLayoutParams().height = i;
    paramContext.jfs.getLayoutParams().width = i;
    paramContext.jfs.getLayoutParams().height = i;
    paramContext.ivs.setImageResource(2131231739);
    paramContext.jfu.setVisibility(8);
    paramContext.titleTv.setText("");
    paramContext.aku.setOnClickListener(new RecentAppBrandViewContainer.2(this));
    AppMethodBeat.o(133959);
  }
  
  public RecentAppBrandView getRecentView()
  {
    return this.jes;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(133956);
    if (this.jes != null)
    {
      if (this.jes.getDataCount() <= 4) {
        break label44;
      }
      this.jgh.setVisibility(0);
    }
    for (;;)
    {
      this.jes.aPD();
      AppMethodBeat.o(133956);
      return;
      label44:
      this.jgh.setVisibility(4);
    }
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(133957);
    if (this.jes != null) {
      this.jes.setDataList(paramList);
    }
    if (paramList.size() <= 4)
    {
      this.jgh.setVisibility(8);
      AppMethodBeat.o(133957);
      return;
    }
    this.jgh.setVisibility(0);
    AppMethodBeat.o(133957);
  }
  
  public void setItemPadding(int paramInt)
  {
    AppMethodBeat.i(133958);
    if (this.jes != null) {
      this.jes.setItemPadding(paramInt);
    }
    if (this.jgh != null)
    {
      View localView = this.jgh;
      localView.setPadding(paramInt, localView.getPaddingTop(), paramInt, this.jgh.getPaddingBottom());
    }
    AppMethodBeat.o(133958);
  }
  
  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jgj = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer
 * JD-Core Version:    0.7.0.1
 */