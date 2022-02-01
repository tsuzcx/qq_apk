package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.ak;
import com.tencent.mm.plugin.finder.report.live.s.aw;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "duration", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "frozenCommonInfoWhenMemberListShowing", "", "getFrozenCommonInfoWhenMemberListShowing", "()Z", "setFrozenCommonInfoWhenMemberListShowing", "(Z)V", "isAnchor", "likeGroup", "likeIcon", "likeTv", "memberIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "canClearScreen", "canVisitorGotoMemberList", "checkDuration", "", "createTime", "checkNetwork", "getNetStatusIcon", "resId", "isMemberListShowing", "refreshViews", "onlineCnt", "likeCnt", "totalCnt", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "Companion", "plugin-finder_release"})
public final class y
  extends d
{
  private static boolean DEBUG;
  private static int uoU;
  public static final a uoV;
  private final String TAG;
  public boolean dMz;
  public long duration;
  private final com.tencent.mm.live.c.b hOp;
  private final TextView hPE;
  private final TextView hPF;
  private final TextView hPG;
  private final View hPH;
  private final View hPI;
  private final View hPJ;
  private final ImageView hPK;
  private final ImageView hPL;
  private final Drawable hPM;
  private final Drawable hPN;
  private final Drawable hPO;
  public int hPP;
  public String hPQ;
  private final ImageView rNa;
  boolean uoS;
  private final WeImageView uoT;
  
  static
  {
    AppMethodBeat.i(246621);
    uoV = new a((byte)0);
    uoU = 10;
    AppMethodBeat.o(246621);
  }
  
  public y(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246620);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveCommonInfoPlugin";
    this.uoS = true;
    paramb = paramViewGroup.findViewById(2131303378);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.hPE = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303372);
    p.g(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.hPF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303375);
    p.g(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.hPG = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303376);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.hPH = paramb;
    paramb = paramViewGroup.findViewById(2131303370);
    p.g(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.hPI = paramb;
    paramb = paramViewGroup.findViewById(2131303373);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.hPJ = paramb;
    paramb = paramViewGroup.findViewById(2131303371);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.hPK = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303369);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.hPL = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303374);
    p.g(paramb, "root.findViewById(R.id.live_common_info_like_icon)");
    this.rNa = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303377);
    p.g(paramb, "root.findViewById(R.id.l…common_info_members_icon)");
    this.uoT = ((WeImageView)paramb);
    this.hPM = rh(2131691014);
    this.hPN = rh(2131691015);
    this.hPO = rh(2131691013);
    paramb = e.h.hya;
    this.hPP = e.h.aCS();
    this.hPQ = "00:00:00";
    paramb = c.vCb;
    if (((Number)c.dwf().value()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uoS = bool;
      this.rNa.setImageDrawable(ar.m(paramViewGroup.getContext(), 2131690759, -1));
      this.hPH.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(246609);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = com.tencent.mm.plugin.finder.utils.m.vVH;
          if (com.tencent.mm.plugin.finder.utils.m.dBP())
          {
            paramAnonymousView = k.vkd;
            k.a(s.c.vnh, String.valueOf(s.ak.vqI.action));
          }
          for (;;)
          {
            b.b.a(y.p(this.uoW), b.c.hMU);
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(246609);
              return;
            } while (!y.r(this.uoW));
            if (y.p(this.uoW).getLiveRole() == 0)
            {
              paramAnonymousView = com.tencent.mm.plugin.finder.report.live.m.vli;
              com.tencent.mm.plugin.finder.report.live.m.a(s.aw.vsp, "", 0);
            }
          }
        }
      });
      paramb = com.tencent.mm.plugin.finder.utils.y.vXH;
      if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
        this.hPH.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
        {
          public final boolean onLongClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(246612);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = y.uoV;
            paramAnonymousView = y.uoV;
            if (!y.access$getDEBUG$cp()) {}
            for (boolean bool = true;; bool = false)
            {
              y.nr(bool);
              paramAnonymousView = y.uoV;
              if (y.access$getDEBUG$cp())
              {
                paramAnonymousView = new EditText(this.hOA.getContext());
                paramAnonymousView.setGravity(51);
                paramAnonymousView.setTextSize(0, com.tencent.mm.view.d.e(this.hOA.getContext(), 15.0F));
                paramAnonymousView.setMaxEms(80);
                paramAnonymousView.setMaxLines(2);
                paramAnonymousView.setEllipsize(TextUtils.TruncateAt.END);
                localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a(paramAnonymousView, null, 80, 40, (kotlin.g.a.a)1.uoX);
                int i = paramAnonymousView.getPaddingLeft();
                localObject = this.hOA.getContext();
                p.g(localObject, "root.context");
                int j = ((Context)localObject).getResources().getDimensionPixelOffset(2131165277);
                int k = paramAnonymousView.getPaddingRight();
                localObject = this.hOA.getContext();
                p.g(localObject, "root.context");
                paramAnonymousView.setPadding(i, j, k, ((Context)localObject).getResources().getDimensionPixelOffset(2131165277));
                localObject = this.hOA.getContext();
                p.g(localObject, "root.context");
                paramAnonymousView.setBackgroundColor(((Context)localObject).getResources().getColor(2131099681));
                localObject = new ViewGroup.LayoutParams(-1, -1);
                paramAnonymousView.setHeight(com.tencent.mm.view.d.e(this.hOA.getContext(), 100.0F));
                paramAnonymousView.setLayoutParams((ViewGroup.LayoutParams)localObject);
                localObject = new f.a(this.hOA.getContext());
                ((f.a)localObject).aC((CharSequence)"测试").hu((View)paramAnonymousView);
                ((f.a)localObject).c((f.c)new f.c()
                {
                  public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
                  {
                    AppMethodBeat.i(246611);
                    paramAnonymous2String = this.uoY.hOA.getContext().getSystemService("input_method");
                    if (paramAnonymous2String == null)
                    {
                      paramAnonymous2String = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                      AppMethodBeat.o(246611);
                      throw paramAnonymous2String;
                    }
                    ((InputMethodManager)paramAnonymous2String).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                    paramAnonymous2String = y.uoV;
                    paramAnonymous2String = paramAnonymousView.getText();
                    if (paramAnonymous2String != null) {}
                    for (paramAnonymous2String = paramAnonymous2String.toString();; paramAnonymous2String = null)
                    {
                      y.Jl(Util.safeParseInt(paramAnonymous2String));
                      AppMethodBeat.o(246611);
                      return;
                    }
                  }
                }).show();
              }
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(246612);
              return true;
            }
          }
        });
      }
      this.uoT.setVisibility(8);
      Log.i(this.TAG, "frozenCommonInfoWhenMemberListShowing:" + this.uoS);
      AppMethodBeat.o(246620);
      return;
    }
  }
  
  private final Drawable rh(int paramInt)
  {
    AppMethodBeat.i(246616);
    Object localObject = this.hwr.getContext();
    p.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    p.g(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(246616);
    return localObject;
  }
  
  public final void aHy()
  {
    AppMethodBeat.i(246617);
    com.tencent.mm.plugin.finder.utils.m localm = com.tencent.mm.plugin.finder.utils.m.vVH;
    this.dMz = com.tencent.mm.plugin.finder.utils.m.dBP();
    AppMethodBeat.o(246617);
  }
  
  public final void ae(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(246615);
    this.hwr.post((Runnable)new b(this, paramInt3, paramInt1, paramInt2));
    AppMethodBeat.o(246615);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246619);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (z.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246619);
      return;
      rg(8);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246618);
    super.unMount();
    AppMethodBeat.o(246618);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEBUG_CNT", "", "getDEBUG_CNT", "()I", "setDEBUG_CNT", "(I)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(246614);
      int i = y.a(this.uoW);
      Object localObject1 = e.h.hya;
      if (i == e.h.aCS()) {
        y.b(this.uoW).setImageDrawable(y.c(this.uoW));
      }
      while ((this.uoW.uoS) && (y.f(this.uoW)))
      {
        Log.i(y.g(this.uoW), "refreshViews frozenRefresh!");
        AppMethodBeat.o(246614);
        return;
        localObject1 = e.h.hya;
        if (i == e.h.aCT())
        {
          y.b(this.uoW).setImageDrawable(y.d(this.uoW));
        }
        else
        {
          localObject1 = e.h.hya;
          if (i == e.h.aCU()) {
            y.b(this.uoW).setImageDrawable(y.e(this.uoW));
          }
        }
      }
      localObject1 = ae.SYK;
      localObject1 = this.uoW.hwr.getContext().getString(2131760081);
      p.g(localObject1, "root.context.getString(R…r_live_members_total_tip)");
      Object localObject2 = com.tencent.mm.plugin.finder.utils.y.vXH;
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.utils.y.LT(paramInt3) }, 1));
      p.g(localObject1, "java.lang.String.format(format, *args)");
      localObject1 = new StringBuilder(String.valueOf(localObject1));
      localObject2 = com.tencent.mm.plugin.finder.utils.m.vVH;
      Object localObject3;
      com.tencent.mm.plugin.finder.utils.y localy;
      if ((com.tencent.mm.plugin.finder.utils.m.dBP()) || (this.uoW.getLiveData().uFb))
      {
        localObject2 = new StringBuilder(" · ");
        localObject3 = ae.SYK;
        localObject3 = this.uoW.hwr.getContext().getString(2131760080);
        p.g(localObject3, "root.context.getString(R….finder_live_members_tip)");
        localy = com.tencent.mm.plugin.finder.utils.y.vXH;
        localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.utils.y.LT(paramInt1) }, 1));
        p.g(localObject3, "java.lang.String.format(format, *args)");
        ((StringBuilder)localObject1).append((String)localObject3);
      }
      if ((this.uoW.getLiveData().uEJ) && (this.uoW.getLiveData().dja()))
      {
        long l = this.uoW.getLiveData().liveInfo.LDN;
        localObject2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if ((com.tencent.mm.plugin.finder.utils.m.dBP()) || (this.uoW.getLiveData().uFb) || (l > 0L))
        {
          localObject2 = new StringBuilder(" · ");
          localObject3 = ae.SYK;
          localObject3 = this.uoW.hwr.getContext().getString(2131760221);
          p.g(localObject3, "root.context.getString(R…ive_wecoin_amount_in_hot)");
          localy = com.tencent.mm.plugin.finder.utils.y.vXH;
          localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.utils.y.LT((int)l) }, 1));
          p.g(localObject3, "java.lang.String.format(format, *args)");
          ((StringBuilder)localObject1).append((String)localObject3);
        }
      }
      for (i = 1;; i = 0)
      {
        y.h(this.uoW).setText((CharSequence)((StringBuilder)localObject1).toString());
        localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP())
        {
          y.i(this.uoW).setVisibility(8);
          y.j(this.uoW).setVisibility(0);
          y.k(this.uoW).setVisibility(0);
          y.l(this.uoW).setText((CharSequence)String.valueOf(y.m(this.uoW)));
          localObject1 = y.n(this.uoW);
          localObject2 = com.tencent.mm.plugin.finder.utils.y.vXH;
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.finder.utils.y.LT(paramInt2));
          y.o(this.uoW).setVisibility(0);
          if (y.p(this.uoW).getLiveRole() == 1)
          {
            localObject1 = k.vkd;
            k.dpl().vmh = paramInt1;
            localObject1 = k.vkd;
            k.dpl().vmi = (y.q(this.uoW) * 1000L);
            localObject1 = k.vkd;
            k.dpl().vmg = paramInt2;
            AppMethodBeat.o(246614);
          }
        }
        else
        {
          localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
          if (b.a.aDp())
          {
            y.i(this.uoW).setVisibility(8);
            y.j(this.uoW).setVisibility(8);
            y.k(this.uoW).setVisibility(0);
            if ((i != 0) || (this.uoW.getLiveData().uFb))
            {
              y.o(this.uoW).setVisibility(0);
              AppMethodBeat.o(246614);
              return;
            }
            y.o(this.uoW).setVisibility(8);
            AppMethodBeat.o(246614);
            return;
          }
          y.o(this.uoW).setVisibility(8);
        }
        AppMethodBeat.o(246614);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.y
 * JD-Core Version:    0.7.0.1
 */