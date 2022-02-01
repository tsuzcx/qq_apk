package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.aa.c.a;
import com.tencent.mm.plugin.appbrand.aa.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String fwd;
  private b.h fyd;
  private int fye;
  private int fyf;
  private int fyg;
  private int fyh;
  private int fyi;
  private View lLA;
  private boolean lLB;
  private LinkedList<e> lLC;
  private AppBrandNearbyShowcaseView lLz;
  private ThreeDotsLoadingView luZ;
  private Context mContext;
  private View mView;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.lLB = false;
    this.fyh = -1;
    this.fyi = -1;
    this.lLC = new LinkedList();
    bU(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.lLB = false;
    this.fyh = -1;
    this.fyi = -1;
    this.lLC = new LinkedList();
    bU(paramContext);
    AppMethodBeat.o(121075);
  }
  
  private void bU(Context paramContext)
  {
    AppMethodBeat.i(121076);
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(121076);
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(121079);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
    AppMethodBeat.o(121079);
  }
  
  private void cJ(final View paramView)
  {
    AppMethodBeat.i(121080);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(121073);
          paramView.setVisibility(8);
          AppMethodBeat.o(121073);
        }
      }).start();
    }
    AppMethodBeat.o(121080);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(121078);
    super.onBindView(paramView);
    this.fye = a.fromDPToPix(this.mContext, 21);
    this.fyf = a.fromDPToPix(this.mContext, 11);
    this.fyg = a.fromDPToPix(this.mContext, 2);
    this.fyh = this.mContext.getResources().getColor(2131100498);
    this.lLA = paramView.findViewById(2131296768);
    this.luZ = ((ThreeDotsLoadingView)paramView.findViewById(2131296773));
    this.lLz = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131296769));
    this.lLz.setIconSize(this.fye + this.fyg * 2);
    this.lLz.setIconGap(this.fyf);
    if ((this.fwd == null) || (this.luZ == null))
    {
      ad.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.lLB)
    {
      ad.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.lLB = true;
    cJ(this.lLA);
    c(this.luZ, null);
    this.luZ.ffb();
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121070);
        AppBrandLoadIconPreference.a(AppBrandLoadIconPreference.this);
        AppMethodBeat.o(121070);
      }
    });
    AppMethodBeat.o(121078);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(121077);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2131493097, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(121077);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */