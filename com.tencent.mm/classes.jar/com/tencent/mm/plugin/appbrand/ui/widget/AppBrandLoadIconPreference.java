package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String ejr;
  private b.f elm;
  private int eln;
  private int elo;
  private int elp;
  private final int elq;
  private int elr;
  private ThreeDotsLoadingView iJJ;
  private AppBrandNearbyShowcaseView iSt;
  private View iXf;
  private boolean iXg;
  private LinkedList<e> iXh;
  private Context mContext;
  private View mView;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(93760);
    this.mView = null;
    this.iXg = false;
    this.elq = -1;
    this.elr = -1;
    this.iXh = new LinkedList();
    bF(paramContext);
    AppMethodBeat.o(93760);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(93761);
    this.mView = null;
    this.iXg = false;
    this.elq = -1;
    this.elr = -1;
    this.iXh = new LinkedList();
    bF(paramContext);
    AppMethodBeat.o(93761);
  }
  
  private void bF(Context paramContext)
  {
    AppMethodBeat.i(93762);
    setLayoutResource(2130970179);
    this.mContext = paramContext;
    AppMethodBeat.o(93762);
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(93765);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
    AppMethodBeat.o(93765);
  }
  
  private void cx(View paramView)
  {
    AppMethodBeat.i(93766);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new AppBrandLoadIconPreference.4(this, paramView)).start();
    }
    AppMethodBeat.o(93766);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(93764);
    super.onBindView(paramView);
    this.eln = a.fromDPToPix(this.mContext, 21);
    this.elo = a.fromDPToPix(this.mContext, 11);
    this.elp = a.fromDPToPix(this.mContext, 2);
    this.iXf = paramView.findViewById(2131821519);
    this.iJJ = ((ThreeDotsLoadingView)paramView.findViewById(2131821425));
    this.iSt = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131821520));
    this.iSt.setIconSize(this.eln + this.elp * 2);
    this.iSt.setIconGap(this.elo);
    if ((this.ejr == null) || (this.iJJ == null))
    {
      ab.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(93764);
      return;
    }
    if (this.iXg)
    {
      ab.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(93764);
      return;
    }
    this.iXg = true;
    cx(this.iXf);
    c(this.iJJ, null);
    this.iJJ.dOV();
    g.RO().ac(new AppBrandLoadIconPreference.1(this));
    AppMethodBeat.o(93764);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(93763);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2130968770, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(93763);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */