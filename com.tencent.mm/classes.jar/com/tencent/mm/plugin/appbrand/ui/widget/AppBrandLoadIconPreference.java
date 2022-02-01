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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  private String fTa;
  private b.h fUX;
  private int fUY;
  private int fUZ;
  private int fVa;
  private int fVb;
  private int fVc;
  private Context mContext;
  private AppBrandNearbyShowcaseView mNY;
  private View mNZ;
  private boolean mOa;
  private LinkedList<e> mOb;
  private View mView;
  private ThreeDotsLoadingView mwI;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121074);
    this.mView = null;
    this.mOa = false;
    this.fVb = -1;
    this.fVc = -1;
    this.mOb = new LinkedList();
    bV(paramContext);
    AppMethodBeat.o(121074);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121075);
    this.mView = null;
    this.mOa = false;
    this.fVb = -1;
    this.fVc = -1;
    this.mOb = new LinkedList();
    bV(paramContext);
    AppMethodBeat.o(121075);
  }
  
  private void bV(Context paramContext)
  {
    AppMethodBeat.i(121076);
    setLayoutResource(2131494804);
    this.mContext = paramContext;
    AppMethodBeat.o(121076);
  }
  
  private void cN(final View paramView)
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
    this.fUY = a.fromDPToPix(this.mContext, 21);
    this.fUZ = a.fromDPToPix(this.mContext, 11);
    this.fVa = a.fromDPToPix(this.mContext, 2);
    this.fVb = this.mContext.getResources().getColor(2131100498);
    this.mNZ = paramView.findViewById(2131296768);
    this.mwI = ((ThreeDotsLoadingView)paramView.findViewById(2131296773));
    this.mNY = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131296769));
    this.mNY.setIconSize(this.fUY + this.fVa * 2);
    this.mNY.setIconGap(this.fUZ);
    if ((this.fTa == null) || (this.mwI == null))
    {
      ad.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      AppMethodBeat.o(121078);
      return;
    }
    if (this.mOa)
    {
      ad.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      AppMethodBeat.o(121078);
      return;
    }
    this.mOa = true;
    cN(this.mNZ);
    f(this.mwI, null);
    this.mwI.fLJ();
    g.ajF().ay(new Runnable()
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