package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.q.b;
import com.tencent.mm.plugin.appbrand.appusage.r.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

final class i
  extends a
  implements View.OnClickListener, q.b
{
  View aku;
  private Activity cup;
  private b.f elm;
  private final int eln;
  private final int elo;
  private final int elp;
  private final int elq;
  private ImageView iSv;
  private ThreeDotsLoadingView iTR;
  private TextView iUA;
  private AppBrandNearbyShowcaseView iUB;
  private View iUC;
  private ImageView iUD;
  private boolean iUE;
  private View iUt;
  private i.a iUy;
  private final int iUz;
  
  i(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(133454);
    this.iUy = i.a.iUJ;
    this.elq = -1;
    this.iUE = false;
    this.cup = paramActivity;
    this.eln = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 25);
    this.elo = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 19);
    this.elp = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 2);
    this.aku = LayoutInflater.from(paramActivity).inflate(2130968719, paramViewGroup, false);
    paramViewGroup = this.aku.findViewById(2131821354);
    this.iUC = paramViewGroup;
    paramViewGroup.setOnClickListener(this);
    this.iUt = this.aku.findViewById(2131821350);
    this.iUA = ((TextView)this.aku.findViewById(2131821352));
    this.iUB = ((AppBrandNearbyShowcaseView)this.aku.findViewById(2131821351));
    this.iUB.setIconLayerCount(4);
    this.iUB.setIconSize(this.eln + this.elp * 2);
    this.iUB.setIconGap(this.elo);
    this.iSv = ((ImageView)this.aku.findViewById(2131821353));
    this.iTR = ((ThreeDotsLoadingView)this.aku.findViewById(2131821355));
    this.iUD = ((ImageView)this.aku.findViewById(2131821356));
    this.iUz = com.tencent.mm.cb.a.m(paramActivity, 2131690156);
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramActivity, "android.permission.ACCESS_COARSE_LOCATION")) {
      this.iUy = i.a.iUL;
    }
    AppMethodBeat.o(133454);
  }
  
  private void aNq()
  {
    int i = 1;
    int k = 0;
    AppMethodBeat.i(133461);
    if (this.aku == null)
    {
      AppMethodBeat.o(133461);
      return;
    }
    if (q.axf())
    {
      eR(true);
      localObject = ((AppBrandLauncherUI)this.cup).iMK;
      if (localObject != null) {
        ((r.d)localObject).axs();
      }
    }
    for (;;)
    {
      this.iTR.dOW();
      cx(this.iTR);
      if (i.a.iUL != this.iUy) {
        break;
      }
      cx(this.iUt);
      cx(this.iUD);
      AppMethodBeat.o(133461);
      return;
      eR(false);
    }
    Object localObject = q.axj();
    if (localObject == null)
    {
      this.iUy = i.a.iUH;
      cx(this.iUt);
      cB(this.iUD);
      AppMethodBeat.o(133461);
      return;
    }
    if ((((asv)localObject).jAI <= 0) || (bo.es(((asv)localObject).xhS)))
    {
      this.iUy = i.a.iUJ;
      cx(this.iUt);
      AppMethodBeat.o(133461);
      return;
    }
    this.iUy = i.a.iUI;
    r.d locald = ((AppBrandLauncherUI)this.cup).iMK;
    if (locald != null) {
      locald.axr();
    }
    if (this.iUA != null)
    {
      this.iUA.setText(((asv)localObject).wBL);
      this.iUA.setTextColor(by(((asv)localObject).xhY, this.iUz));
    }
    this.iUB.setIconLayerCount(Math.min(((asv)localObject).xhS.size(), 4));
    if (this.iUt.getVisibility() != 0) {}
    for (;;)
    {
      if (i != 0) {
        this.iUB.fa(false);
      }
      int j = k;
      if (this.elm == null)
      {
        this.elm = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.eln, this.elp);
        j = k;
      }
      while (j < this.iUB.getChildCount())
      {
        com.tencent.mm.modelappbrand.a.b.acD().a(this.iUB.pU(j), ((bfs)((asv)localObject).xhS.get(j)).xuE, com.tencent.mm.modelappbrand.a.a.acC(), this.elm);
        j += 1;
      }
      i = 0;
    }
    cB(this.iUt);
    cx(this.iTR);
    cx(this.iUD);
    if (i != 0)
    {
      if (this.iUB != null) {
        this.iUB.aOx();
      }
      if (this.iUA != null)
      {
        this.iUA.setAlpha(0.0F);
        this.iUA.animate().alpha(1.0F).setDuration(500L).start();
      }
    }
    AppMethodBeat.o(133461);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(133467);
    if (this.cup == null)
    {
      AppMethodBeat.o(133467);
      return;
    }
    r.d locald = ((AppBrandLauncherUI)this.cup).iMK;
    if (locald != null) {
      locald.axt();
    }
    AppMethodBeat.o(133467);
  }
  
  private static int by(String paramString, int paramInt)
  {
    AppMethodBeat.i(133462);
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(133462);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(133462);
    }
    return paramInt;
  }
  
  private static void cB(View paramView)
  {
    AppMethodBeat.i(133464);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(null).start();
    AppMethodBeat.o(133464);
  }
  
  private void cx(View paramView)
  {
    AppMethodBeat.i(133463);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new i.3(this, paramView)).start();
    }
    AppMethodBeat.o(133463);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(133460);
    this.iUy = i.a.iUK;
    cx(this.iUt);
    cx(this.iUD);
    cB(this.iTR);
    this.iTR.dOV();
    AppMethodBeat.o(133460);
  }
  
  public final void aNd()
  {
    AppMethodBeat.i(133456);
    eR(q.axf());
    if (i.a.iUL == this.iUy)
    {
      aNq();
      AppMethodBeat.o(133456);
      return;
    }
    q.a(this);
    if (!q.axk())
    {
      this.aku.post(new i.2(this));
      AppMethodBeat.o(133456);
      return;
    }
    if (q.refresh())
    {
      showLoading();
      AppMethodBeat.o(133456);
      return;
    }
    eR(false);
    AppMethodBeat.o(133456);
  }
  
  public final View aNe()
  {
    return this.aku;
  }
  
  public final void axl()
  {
    AppMethodBeat.i(133465);
    if (this.aku != null) {
      this.aku.post(new i.4(this));
    }
    AppMethodBeat.o(133465);
  }
  
  public final void eS(boolean paramBoolean)
  {
    AppMethodBeat.i(133453);
    this.iUt.post(new i.1(this, paramBoolean));
    AppMethodBeat.o(133453);
  }
  
  public final void onClick(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(133466);
    if (paramView.getId() == 2131821354)
    {
      if (this.cup == null)
      {
        AppMethodBeat.o(133466);
        return;
      }
      if (i.a.iUK == this.iUy)
      {
        AppMethodBeat.o(133466);
        return;
      }
      if (i.a.iUJ == this.iUy)
      {
        aNr();
        this.cup.startActivityForResult(new Intent(this.cup, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
        AppMethodBeat.o(133466);
        return;
      }
      if (i.a.iUL == this.iUy)
      {
        aNr();
        this.cup.startActivityForResult(new Intent(this.cup, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
        AppMethodBeat.o(133466);
        return;
      }
      if ((q.axj() != null) && (q.axk())) {}
      for (boolean bool = true;; bool = false)
      {
        this.iUE = bool;
        if ((i.a.iUH == this.iUy) || (this.iUE)) {
          i = 1;
        }
        paramView = new i.5(this);
        if (i == 0) {
          break;
        }
        showLoading();
        q.refresh();
        AppMethodBeat.o(133466);
        return;
      }
      paramView.run();
      if ((q.axj() != null) && (q.axj().xhZ == 1) && (this.iUA != null)) {
        this.iUA.animate().alpha(0.0F).setDuration(200L);
      }
    }
    AppMethodBeat.o(133466);
  }
  
  public final void onDetached()
  {
    AppMethodBeat.i(133457);
    q.b(this);
    this.cup = null;
    this.aku = null;
    this.iUB = null;
    this.iUt = null;
    AppMethodBeat.o(133457);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133455);
    if ((i.a.iUL == this.iUy) && (com.tencent.mm.pluginsdk.permission.b.o(this.cup, "android.permission.ACCESS_COARSE_LOCATION")))
    {
      this.iUy = i.a.iUJ;
      aNd();
    }
    AppMethodBeat.o(133455);
  }
  
  public final void pF(int paramInt)
  {
    AppMethodBeat.i(133458);
    if (this.iSv != null)
    {
      this.iSv.setVisibility(paramInt);
      localObject = this.iUt.getParent();
      if ((localObject instanceof FrameLayout))
      {
        localObject = (FrameLayout)localObject;
        localLayoutParams = (LinearLayout.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        localLayoutParams.rightMargin = this.cup.getResources().getDimensionPixelOffset(2131428078);
        ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
      }
    }
    Object localObject = (TextView)this.aku.findViewById(2131820680);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.leftMargin = this.cup.getResources().getDimensionPixelOffset(2131428015);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133458);
  }
  
  public final void pG(int paramInt)
  {
    AppMethodBeat.i(133459);
    this.iUC.setBackgroundResource(paramInt);
    AppMethodBeat.o(133459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.i
 * JD-Core Version:    0.7.0.1
 */