package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.z;
import java.util.List;

public class RecentAppBrandViewContainer
  extends LinearLayout
{
  Runnable acb;
  private Context mContext;
  RecentAppBrandView mWZ;
  private View mYZ;
  boolean mZa;
  private View.OnClickListener mZb;
  
  public RecentAppBrandViewContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49704);
    this.acb = null;
    this.mZa = true;
    this.mZb = null;
    init(paramContext);
    AppMethodBeat.o(49704);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49705);
    this.acb = null;
    this.mZa = true;
    this.mZb = null;
    init(paramContext);
    AppMethodBeat.o(49705);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49706);
    this.acb = null;
    this.mZa = true;
    this.mZb = null;
    init(paramContext);
    AppMethodBeat.o(49706);
  }
  
  private void bDi()
  {
    AppMethodBeat.i(49710);
    if (this.mWZ.getDataCount() > this.mWZ.getMaxShowItemCountIncludeMore())
    {
      this.mYZ.setVisibility(0);
      AppMethodBeat.o(49710);
      return;
    }
    this.mYZ.setVisibility(4);
    AppMethodBeat.o(49710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49712);
    this.mContext = paramContext;
    paramContext = z.jO(paramContext).inflate(2131492988, this);
    this.mWZ = ((RecentAppBrandView)paramContext.findViewById(2131303807));
    this.mYZ = paramContext.findViewById(2131302475);
    paramContext = new f(this.mYZ);
    int i = (int)d.ea(getContext());
    paramContext.mYi.getLayoutParams().width = ((int)(com.tencent.mm.cc.a.ay(getContext(), 2131165568) * 2 * d.eb(getContext())) + i);
    paramContext.mYi.getLayoutParams().height = ((int)(com.tencent.mm.cc.a.ay(getContext(), 2131165568) * 2 * d.eb(getContext())) + i);
    paramContext.lZa.getLayoutParams().width = i;
    paramContext.lZa.getLayoutParams().height = i;
    paramContext.mYh.getLayoutParams().width = i;
    paramContext.mYh.getLayoutParams().height = i;
    paramContext.lZa.setImageResource(2131690904);
    paramContext.mYj.setVisibility(8);
    paramContext.titleTv.setText("");
    paramContext.auu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49702);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (RecentAppBrandViewContainer.b(RecentAppBrandViewContainer.this) != null) {
          RecentAppBrandViewContainer.b(RecentAppBrandViewContainer.this).onClick(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49702);
      }
    });
    AppMethodBeat.o(49712);
  }
  
  public RecentAppBrandView getRecentView()
  {
    return this.mWZ;
  }
  
  public int getShowLines()
  {
    AppMethodBeat.i(49709);
    if (this.mWZ != null)
    {
      int i = this.mWZ.getShowLines();
      AppMethodBeat.o(49709);
      return i;
    }
    AppMethodBeat.o(49709);
    return 0;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(49707);
    if (this.mWZ != null)
    {
      bDi();
      this.mWZ.bDh();
    }
    AppMethodBeat.o(49707);
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49708);
    if (this.mWZ != null)
    {
      this.mWZ.setDataList(paramList);
      bDi();
    }
    AppMethodBeat.o(49708);
  }
  
  public void setItemPadding(int paramInt)
  {
    AppMethodBeat.i(49711);
    if (this.mWZ != null) {
      this.mWZ.setItemPadding(paramInt);
    }
    if (this.mYZ != null)
    {
      View localView = this.mYZ;
      localView.setPadding(paramInt, localView.getPaddingTop(), paramInt, this.mYZ.getPaddingBottom());
    }
    AppMethodBeat.o(49711);
  }
  
  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mZb = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer
 * JD-Core Version:    0.7.0.1
 */