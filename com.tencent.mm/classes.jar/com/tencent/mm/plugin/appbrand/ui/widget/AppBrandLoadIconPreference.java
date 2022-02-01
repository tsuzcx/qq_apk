package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.af.e;
import com.tencent.mm.plugin.appbrand.d.c.b;
import com.tencent.mm.plugin.appbrand.d.c.c;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String lMU;
  private b.h lPn;
  private int lPo;
  private int lPp;
  private int lPq;
  private int lPr;
  private int lPs;
  private Context mContext;
  private View mView;
  private ThreeDotsLoadingView tUw;
  private AppBrandNearbyShowcaseView upK;
  private View upL;
  private boolean upM;
  private LinkedList<e> upN;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.upM = false;
    this.lPr = -1;
    this.lPs = -1;
    this.upN = new LinkedList();
    dc(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.upM = false;
    this.lPr = -1;
    this.lPs = -1;
    this.upN = new LinkedList();
    dc(paramContext);
    AppMethodBeat.o(121075);
  }
  
  private void dK(final View paramView)
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
  
  private void dc(Context paramContext)
  {
    AppMethodBeat.i(121076);
    setLayoutResource(c.c.mm_preference);
    this.mContext = paramContext;
    AppMethodBeat.o(121076);
  }
  
  private static void g(View paramView, Runnable paramRunnable)
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
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(121078);
    super.onBindView(paramView);
    this.lPo = a.fromDPToPix(this.mContext, 21);
    this.lPp = a.fromDPToPix(this.mContext, 11);
    this.lPq = a.fromDPToPix(this.mContext, 2);
    this.lPr = this.mContext.getResources().getColor(com.tencent.mm.plugin.appbrand.d.c.a.icon_border_color);
    this.upL = paramView.findViewById(c.b.app_brand_loading_icon_layout);
    this.tUw = ((ThreeDotsLoadingView)paramView.findViewById(c.b.app_brand_loading_view));
    this.upK = ((AppBrandNearbyShowcaseView)paramView.findViewById(c.b.app_brand_loading_icon_view));
    this.upK.setIconSize(this.lPo + this.lPq * 2);
    this.upK.setIconGap(this.lPp);
    if ((this.lMU == null) || (this.tUw == null))
    {
      Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.upM)
    {
      Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.upM = true;
    dK(this.upL);
    g(this.tUw, null);
    this.tUw.jFe();
    h.baH().postToWorker(new Runnable()
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
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(c.b.content);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, c.c.appbrand_load_icon_preference, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(121077);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */