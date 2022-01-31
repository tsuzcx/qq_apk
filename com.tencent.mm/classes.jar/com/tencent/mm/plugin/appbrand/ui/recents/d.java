package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public abstract class d<_DataSource extends k>
  extends a
  implements View.OnClickListener
{
  private final int eln;
  private final int elo;
  private final int elp;
  private final int elq = -1;
  private final Class iSp;
  private final com.tencent.mm.plugin.appbrand.ui.widget.a iSq;
  protected final int iSr = 4;
  private ViewGroup iSs;
  protected AppBrandNearbyShowcaseView iSt;
  private volatile List<LocalUsageInfo> iSu;
  private ImageView iSv;
  private final ViewTreeObserver.OnPreDrawListener iSw = new d.1(this);
  private final k.a iSx = new d.4(this);
  private Activity mActivity;
  private boolean wM;
  
  d(Class<_DataSource> paramClass, Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramActivity;
    this.iSp = paramClass;
    this.eln = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 25);
    this.elo = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 19);
    this.elp = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 2);
    this.iSq = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.eln, this.elp);
    this.iSs = ((ViewGroup)LayoutInflater.from(paramActivity).inflate(2130968717, paramViewGroup, false));
    this.iSs.setOnClickListener(this);
    ((TextView)this.iSs.findViewById(2131820680)).setText(getTitle());
    this.iSv = ((ImageView)this.iSs.findViewById(2131821353));
    this.iSt = ((AppBrandNearbyShowcaseView)this.iSs.findViewById(2131821351));
    this.iSt.setIconLayerCount(4);
    this.iSt.setIconSize(this.eln + this.elp * 2);
    this.iSt.setIconGap(this.elo);
  }
  
  public final void aNd()
  {
    this.wM = true;
    eR(true);
    this.iSs.getViewTreeObserver().addOnPreDrawListener(this.iSw);
  }
  
  public final View aNe()
  {
    return this.iSs;
  }
  
  protected abstract List<LocalUsageInfo> aNg();
  
  protected final Activity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public void onClick(View paramView) {}
  
  public final void onDetached()
  {
    this.wM = false;
    this.iSs.getViewTreeObserver().removeOnPreDrawListener(this.iSw);
    g.auF().remove(this.iSx);
    ((k)g.w(this.iSp)).remove(this.iSx);
  }
  
  public final void onResume() {}
  
  public final void pF(int paramInt)
  {
    if (this.iSv != null) {
      this.iSv.setVisibility(paramInt);
    }
    TextView localTextView = (TextView)this.iSs.findViewById(2131820680);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.iSs.getResources().getDimensionPixelOffset(2131428015);
    localTextView.setLayoutParams(localLayoutParams);
  }
  
  public final void pG(int paramInt)
  {
    this.iSs.setBackgroundResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */