package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.appbrand.z.c.a;
import com.tencent.mm.plugin.appbrand.z.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private b.h fBK;
  private int fBL;
  private int fBM;
  private int fBN;
  private int fBO;
  private int fBP;
  private String fzK;
  private ThreeDotsLoadingView lWT;
  private Context mContext;
  private View mView;
  private AppBrandNearbyShowcaseView mnw;
  private View mnx;
  private boolean mny;
  private LinkedList<e> mnz;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.mny = false;
    this.fBO = -1;
    this.fBP = -1;
    this.mnz = new LinkedList();
    bX(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.mny = false;
    this.fBO = -1;
    this.fBP = -1;
    this.mnz = new LinkedList();
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
  
  private void cL(final View paramView)
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
  
  private static void e(View paramView, Runnable paramRunnable)
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
    this.fBL = a.fromDPToPix(this.mContext, 21);
    this.fBM = a.fromDPToPix(this.mContext, 11);
    this.fBN = a.fromDPToPix(this.mContext, 2);
    this.fBO = this.mContext.getResources().getColor(2131100498);
    this.mnx = paramView.findViewById(2131296768);
    this.lWT = ((ThreeDotsLoadingView)paramView.findViewById(2131296773));
    this.mnw = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131296769));
    this.mnw.setIconSize(this.fBL + this.fBN * 2);
    this.mnw.setIconGap(this.fBM);
    if ((this.fzK == null) || (this.lWT == null))
    {
      ac.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.mny)
    {
      ac.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.mny = true;
    cL(this.mnx);
    e(this.lWT, null);
    this.lWT.fuW();
    g.agU().az(new Runnable()
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