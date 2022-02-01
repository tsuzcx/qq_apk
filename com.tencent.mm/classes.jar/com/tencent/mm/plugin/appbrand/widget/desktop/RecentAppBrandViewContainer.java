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
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.aa;
import java.util.List;

public class RecentAppBrandViewContainer
  extends LinearLayout
{
  public Runnable aco;
  private Context mContext;
  RecentAppBrandView onn;
  private View opu;
  boolean opv;
  private View.OnClickListener opw;
  
  public RecentAppBrandViewContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49704);
    this.aco = null;
    this.opv = true;
    this.opw = null;
    init(paramContext);
    AppMethodBeat.o(49704);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49705);
    this.aco = null;
    this.opv = true;
    this.opw = null;
    init(paramContext);
    AppMethodBeat.o(49705);
  }
  
  public RecentAppBrandViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49706);
    this.aco = null;
    this.opv = true;
    this.opw = null;
    init(paramContext);
    AppMethodBeat.o(49706);
  }
  
  private void caJ()
  {
    AppMethodBeat.i(49710);
    if (this.onn.getDataCount() > this.onn.getMaxShowItemCountIncludeMore())
    {
      this.opu.setVisibility(0);
      AppMethodBeat.o(49710);
      return;
    }
    this.opu.setVisibility(4);
    AppMethodBeat.o(49710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49712);
    this.mContext = paramContext;
    Object localObject = aa.jQ(paramContext).inflate(2131493024, this);
    this.onn = ((RecentAppBrandView)((View)localObject).findViewById(2131306610));
    this.opu = ((View)localObject).findViewById(2131304888);
    this.opu.getLayoutParams().width = (a.jn(getContext()) / 4);
    localObject = new d(this.opu);
    int i = (int)b.ey(getContext());
    ((d)localObject).ooC.getLayoutParams().width = ((int)(a.aH(getContext(), 2131165586) * 2 * b.ez(getContext())) + i);
    ((d)localObject).nnL.getLayoutParams().width = i;
    ((d)localObject).nnL.getLayoutParams().height = i;
    ((d)localObject).ooB.getLayoutParams().width = i;
    ((d)localObject).ooB.getLayoutParams().height = i;
    ((d)localObject).nnL.setImageResource(2131691193);
    ((d)localObject).ooD.setVisibility(8);
    ((d)localObject).titleTv.setText("");
    ((d)localObject).aus.setOnClickListener(new RecentAppBrandViewContainer.2(this));
    ((d)localObject).aus.setOnLongClickListener(new RecentAppBrandViewContainer.3(this, paramContext));
    AppMethodBeat.o(49712);
  }
  
  public final void eH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227781);
    if (this.onn != null) {
      this.onn.setItemPadding(paramInt1);
    }
    if (this.opu != null)
    {
      if (paramInt2 > 0) {
        this.opu.getLayoutParams().width = (paramInt2 / 4);
      }
      this.opu.setPadding(paramInt1, a.fromDPToPix(getContext(), 8), paramInt1, a.fromDPToPix(getContext(), 16));
    }
    AppMethodBeat.o(227781);
  }
  
  public RecentAppBrandView getRecentView()
  {
    return this.onn;
  }
  
  public int getShowLines()
  {
    AppMethodBeat.i(49709);
    if (this.onn != null)
    {
      int i = this.onn.getShowLines();
      AppMethodBeat.o(49709);
      return i;
    }
    AppMethodBeat.o(49709);
    return 0;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(49707);
    if (this.onn != null)
    {
      caJ();
      this.onn.cax();
    }
    AppMethodBeat.o(49707);
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49708);
    if (this.onn != null)
    {
      this.onn.setDataList(paramList);
      caJ();
    }
    AppMethodBeat.o(49708);
  }
  
  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.opw = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer
 * JD-Core Version:    0.7.0.1
 */