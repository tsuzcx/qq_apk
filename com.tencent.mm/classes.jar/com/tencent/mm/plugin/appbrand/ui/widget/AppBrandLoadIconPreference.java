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
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.appbrand.y.c.a;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String fVg;
  private b.h fXd;
  private int fXe;
  private int fXf;
  private int fXg;
  private int fXh;
  private int fXi;
  private ThreeDotsLoadingView mBF;
  private Context mContext;
  private AppBrandNearbyShowcaseView mTc;
  private View mTd;
  private boolean mTe;
  private LinkedList<e> mTf;
  private View mView;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.mTe = false;
    this.fXh = -1;
    this.fXi = -1;
    this.mTf = new LinkedList();
    bX(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.mTe = false;
    this.fXh = -1;
    this.fXi = -1;
    this.mTf = new LinkedList();
    bX(paramContext);
    AppMethodBeat.o(121075);
  }
  
  private void bX(Context paramContext)
  {
    AppMethodBeat.i(121076);
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(121076);
  }
  
  private void cO(final View paramView)
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
  
  private static void f(View paramView, Runnable paramRunnable)
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
    this.fXe = a.fromDPToPix(this.mContext, 21);
    this.fXf = a.fromDPToPix(this.mContext, 11);
    this.fXg = a.fromDPToPix(this.mContext, 2);
    this.fXh = this.mContext.getResources().getColor(2131100498);
    this.mTd = paramView.findViewById(2131296768);
    this.mBF = ((ThreeDotsLoadingView)paramView.findViewById(2131296773));
    this.mTc = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131296769));
    this.mTc.setIconSize(this.fXe + this.fXg * 2);
    this.mTc.setIconGap(this.fXf);
    if ((this.fVg == null) || (this.mBF == null))
    {
      ae.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.mTe)
    {
      ae.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.mTe = true;
    cO(this.mTd);
    f(this.mBF, null);
    this.mBF.fQd();
    g.ajU().aw(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */