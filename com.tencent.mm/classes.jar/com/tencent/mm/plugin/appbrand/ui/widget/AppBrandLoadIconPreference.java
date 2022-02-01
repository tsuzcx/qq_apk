package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.c.c.b;
import com.tencent.mm.plugin.appbrand.c.c.c;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String jkq;
  private b.h jmp;
  private int jmq;
  private int jmr;
  private int jms;
  private int jmt;
  private int jmu;
  private Context mContext;
  private View mView;
  private ThreeDotsLoadingView qPG;
  private AppBrandNearbyShowcaseView rhQ;
  private View rhR;
  private boolean rhS;
  private LinkedList<e> rhT;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.rhS = false;
    this.jmt = -1;
    this.jmu = -1;
    this.rhT = new LinkedList();
    co(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.rhS = false;
    this.jmt = -1;
    this.jmu = -1;
    this.rhT = new LinkedList();
    co(paramContext);
    AppMethodBeat.o(121075);
  }
  
  private void co(Context paramContext)
  {
    AppMethodBeat.i(121076);
    setLayoutResource(c.c.mm_preference);
    this.mContext = paramContext;
    AppMethodBeat.o(121076);
  }
  
  private void db(final View paramView)
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
    this.jmq = a.fromDPToPix(this.mContext, 21);
    this.jmr = a.fromDPToPix(this.mContext, 11);
    this.jms = a.fromDPToPix(this.mContext, 2);
    this.jmt = this.mContext.getResources().getColor(com.tencent.mm.plugin.appbrand.c.c.a.icon_border_color);
    this.rhR = paramView.findViewById(c.b.app_brand_loading_icon_layout);
    this.qPG = ((ThreeDotsLoadingView)paramView.findViewById(c.b.app_brand_loading_view));
    this.rhQ = ((AppBrandNearbyShowcaseView)paramView.findViewById(c.b.app_brand_loading_icon_view));
    this.rhQ.setIconSize(this.jmq + this.jms * 2);
    this.rhQ.setIconGap(this.jmr);
    if ((this.jkq == null) || (this.qPG == null))
    {
      Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.rhS)
    {
      Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.rhS = true;
    db(this.rhR);
    g(this.qPG, null);
    this.qPG.hZX();
    h.aHJ().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */