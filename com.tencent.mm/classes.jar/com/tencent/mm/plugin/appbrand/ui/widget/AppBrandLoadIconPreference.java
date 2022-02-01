package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.ac.c.a;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String gAn;
  private b.h gCj;
  private int gCk;
  private int gCl;
  private int gCm;
  private int gCn;
  private int gCo;
  private Context mContext;
  private View mView;
  private ThreeDotsLoadingView nNl;
  private AppBrandNearbyShowcaseView ogf;
  private View ogg;
  private boolean ogh;
  private LinkedList<e> ogi;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.ogh = false;
    this.gCn = -1;
    this.gCo = -1;
    this.ogi = new LinkedList();
    cs(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.ogh = false;
    this.gCn = -1;
    this.gCo = -1;
    this.ogi = new LinkedList();
    cs(paramContext);
    AppMethodBeat.o(121075);
  }
  
  private void cH(final View paramView)
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
  
  private void cs(Context paramContext)
  {
    AppMethodBeat.i(121076);
    setLayoutResource(2131495538);
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
    this.gCk = a.fromDPToPix(this.mContext, 21);
    this.gCl = a.fromDPToPix(this.mContext, 11);
    this.gCm = a.fromDPToPix(this.mContext, 2);
    this.gCn = this.mContext.getResources().getColor(2131100633);
    this.ogg = paramView.findViewById(2131296850);
    this.nNl = ((ThreeDotsLoadingView)paramView.findViewById(2131296855));
    this.ogf = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131296851));
    this.ogf.setIconSize(this.gCk + this.gCm * 2);
    this.ogf.setIconGap(this.gCl);
    if ((this.gAn == null) || (this.nNl == null))
    {
      Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.ogh)
    {
      Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.ogh = true;
    cH(this.ogg);
    g(this.nNl, null);
    this.nNl.gZh();
    g.aAk().postToWorker(new Runnable()
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
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2131493139, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(121077);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */