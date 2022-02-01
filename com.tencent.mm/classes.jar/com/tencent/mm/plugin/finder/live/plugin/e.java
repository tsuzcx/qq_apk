package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.e;
import com.tencent.mm.plugin.finder.report.live.s.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "infoGroup", "Landroid/widget/LinearLayout;", "likeCountTv", "Landroid/widget/TextView;", "likeTv", "liveDurationTv", "livingToFinish", "", "newFollowCountContainer", "Landroid/view/View;", "newFollowCountTv", "newFollowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "newFollowTv", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "split1", "titleTv", "visitorCountTv", "visitorTv", "wecoinHotCountTv", "wecoinHotGroup", "wecoinHotTv", "onBackPress", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "afterAction", "Lkotlin/Function0;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateBg", "bgUrl", "updateBgByUsername", "updateFinishInfo", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/AnchorFinishInfo;", "updateLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
public final class e
  extends d
  implements i
{
  private final String TAG;
  public final ImageView hNZ;
  private final TextView hOc;
  public final TextView hOd;
  public final TextView hOf;
  public final TextView hOg;
  private final RelativeLayout hOm;
  public final com.tencent.mm.live.c.b hOy;
  private final TextView hPG;
  public final Button hPX;
  private final TextView titleTv;
  private final View ume;
  public final TextView umf;
  private final TextView umg;
  public final WeImageView umh;
  public final View umi;
  private final TextView umj;
  public final TextView umk;
  public final View uml;
  public final LinearLayout umm;
  public boolean umn;
  
  public e(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246410);
    this.hOy = paramb;
    this.TAG = "Finder.LiveAnchorAfterPlugin";
    paramb = paramViewGroup.findViewById(2131303275);
    p.g(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.titleTv = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303250);
    p.g(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.hOg = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303310);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor_count)");
    this.hOd = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303309);
    p.g(paramb, "root.findViewById(R.id.live_after_visitor)");
    this.hOc = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303259);
    p.g(paramb, "root.findViewById(R.id.live_after_like_count)");
    this.hOf = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303258);
    p.g(paramb, "root.findViewById(R.id.live_after_like)");
    this.hPG = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303255);
    p.g(paramb, "root.findViewById(R.id.l…er_info_new_follow_group)");
    this.ume = paramb;
    paramb = paramViewGroup.findViewById(2131303273);
    p.g(paramb, "root.findViewById(R.id.l…e_after_new_follow_count)");
    this.umf = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303272);
    p.g(paramb, "root.findViewById(R.id.live_after_new_follow)");
    this.umg = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303274);
    p.g(paramb, "root.findViewById(R.id.live_after_new_follow_icon)");
    this.umh = ((WeImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303257);
    p.g(paramb, "root.findViewById(R.id.l…er_info_wecoin_hot_group)");
    this.umi = paramb;
    paramb = paramViewGroup.findViewById(2131303311);
    p.g(paramb, "root.findViewById(R.id.live_after_wecoin_hot)");
    this.umj = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303312);
    p.g(paramb, "root.findViewById(R.id.l…e_after_wecoin_hot_count)");
    this.umk = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303297);
    p.g(paramb, "root.findViewById(R.id.live_after_split_1)");
    this.uml = paramb;
    paramb = paramViewGroup.findViewById(2131303251);
    p.g(paramb, "root.findViewById(R.id.live_after_finish_btn)");
    this.hPX = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131303308);
    p.g(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.hOm = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131303253);
    p.g(paramb, "root.findViewById(R.id.live_after_info_group)");
    this.umm = ((LinearLayout)paramb);
    paramb = paramViewGroup.findViewById(2131297167);
    p.g(paramb, "root.findViewById(R.id.back_icon)");
    this.hNZ = ((ImageView)paramb);
    this.hPX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246398);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.umo.hOy.statusChange(b.c.hLD, null);
        if (this.umo.hOy.getLiveRole() == 1)
        {
          paramAnonymousView = k.vkd;
          k.a(s.e.vnn, "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246398);
      }
    });
    this.ume.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246399);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (Util.safeParseInt(this.umo.umf.getText().toString()) > 0)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("PARAM_FINDER_LIVE_ID", this.umo.getLiveData().liveInfo.liveId);
          localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
          localObject = paramViewGroup.getContext();
          p.g(localObject, "root.context");
          com.tencent.mm.plugin.finder.utils.a.ae((Context)localObject, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246399);
      }
    });
    this.umi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246400);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        this.umo.getLiveData().uDS = false;
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("KEY_LIVE_ID", this.umo.getLiveData().liveInfo.liveId);
        paramAnonymousView.putExtra("KEY_OBJECT_ID", this.umo.getLiveData().hFK);
        paramAnonymousView.putExtra("KEY_OBJECT_NONCE_ID", this.umo.getLiveData().hwg);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject = paramViewGroup.getContext();
        p.g(localObject, "root.context");
        com.tencent.mm.plugin.finder.utils.a.af((Context)localObject, paramAnonymousView);
        if (this.umo.hOy.getLiveRole() == 1)
        {
          paramAnonymousView = k.vkd;
          k.a(s.e.vnm, String.valueOf(s.i.vnJ.action));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246400);
      }
    });
    paramb = this.titleTv;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(246410);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.topMargin += au.getStatusBarHeight(MMApplicationContext.getContext());
    paramb = this.hPX;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(246410);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += au.aD(MMApplicationContext.getContext());
    ao.a((Paint)this.titleTv.getPaint(), 0.8F);
    ao.a((Paint)this.hPX.getPaint(), 0.8F);
    this.hNZ.setImageDrawable(ar.m(paramViewGroup.getContext(), 2131690485, -1));
    this.hNZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246401);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.umo.hOy.statusChange(b.c.hLD, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246401);
      }
    });
    AppMethodBeat.o(246410);
  }
  
  private final void dgM()
  {
    AppMethodBeat.i(246406);
    com.tencent.mm.plugin.finder.live.util.g localg = com.tencent.mm.plugin.finder.live.util.g.uwd;
    com.tencent.mm.plugin.finder.live.util.g.a(getLiveData().hwd, getLiveData().uEu, (View)this.hOm);
    AppMethodBeat.o(246406);
  }
  
  public final void dgL()
  {
    String str = null;
    AppMethodBeat.i(246404);
    Object localObject = this.hOm;
    Context localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    ((RelativeLayout)localObject).setBackgroundColor(localContext.getResources().getColor(2131100429));
    if (getLiveData().hwd != null) {
      localObject = c.tsp;
    }
    for (localObject = c.a.asG(getLiveData().hwd);; localObject = null)
    {
      if (localObject != null) {
        str = ((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl;
      }
      if (Util.isNullOrNil(str)) {
        break;
      }
      dgM();
      AppMethodBeat.o(246404);
      return;
    }
    Log.i(this.TAG, "update bg fail,contact is null!");
    localObject = com.tencent.mm.kernel.g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().a(3736, (i)this);
    localObject = o.ujN;
    localObject = o.getFinderLiveAssistant();
    if (localObject != null)
    {
      ((s)localObject).aty(getLiveData().hwd);
      AppMethodBeat.o(246404);
      return;
    }
    AppMethodBeat.o(246404);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246409);
    if (this.hOy.getLiveRole() == 1)
    {
      k localk = k.vkd;
      k.a(s.e.vnn, "");
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(246409);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(246405);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    if ((paramq instanceof cn))
    {
      FinderContact localFinderContact = ((cn)paramq).cZk();
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("update bg,user page isOnlyFetchUserInfo:").append(((cn)paramq).twC).append(", local username:").append(getLiveData().hwd).append(",req username:").append(((cn)paramq).tuH).append("，contact username:");
      if (localFinderContact != null) {}
      for (paramString = localFinderContact.username;; paramString = null)
      {
        Log.i(str, paramString);
        if ((!((cn)paramq).twC) || (!p.j(((cn)paramq).tuH, getLiveData().hwd))) {
          break;
        }
        paramString = com.tencent.mm.kernel.g.aAg();
        p.g(paramString, "MMKernel.network()");
        paramString.azz().b(3736, (i)this);
        if (localFinderContact == null) {
          break;
        }
        paramString = localFinderContact.headUrl;
        if (paramString == null) {
          break;
        }
        p.g(paramString, "it");
        dgM();
        AppMethodBeat.o(246405);
        return;
      }
    }
    AppMethodBeat.o(246405);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246407);
    p.h(paramc, "status");
    switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(246407);
      return;
    }
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL");; bool = false)
    {
      this.umn = bool;
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246408);
    super.unMount();
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3736, (i)this);
    AppMethodBeat.o(246408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.e
 * JD-Core Version:    0.7.0.1
 */