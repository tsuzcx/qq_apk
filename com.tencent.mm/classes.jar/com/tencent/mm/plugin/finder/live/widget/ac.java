package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.cgi.i;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.cb;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.b;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.fmc;
import com.tencent.mm.protocal.protobuf.fmd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansTaskWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_PANEL_HEIGHT", "", "backBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "setBottomSheet", "(Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;)V", "clickArea", "closeValue", "Landroid/widget/TextView;", "contentArea", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "dailyTaskProgress", "dailyTaskString", "fansGroupClickListener", "Lkotlin/Function0;", "", "getFansGroupClickListener", "()Lkotlin/jvm/functions/Function0;", "setFansGroupClickListener", "(Lkotlin/jvm/functions/Function0;)V", "fansTaskRv", "Landroidx/recyclerview/widget/RecyclerView;", "helpIcon", "Landroid/widget/ImageView;", "helpIconClickListener", "getHelpIconClickListener", "setHelpIconClickListener", "infoAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansInfoAdapter;", "isLand", "", "loading", "Landroid/widget/ProgressBar;", "mainContent", "myLevel", "root", "titleGroup", "titleIcon", "titleTv", "upgradeTips", "buildBaseSpanString", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "text", "", "nextLevel", "getIntimacy", "autoShowAfterJoin", "hide", "initLayout", "initListener", "onClick", "v", "setContent", "intimacyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubGetIntimacyResp;", "setTitle", "business", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "show", "showLoading", "showMainContent", "showPanel", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends p
  implements View.OnClickListener
{
  public static final a Eqb;
  private int CwP;
  private final View CxW;
  private final TextView DQL;
  private final LiveBottomSheetPanel EoS;
  private final boolean EpG;
  private com.tencent.mm.ui.widget.a.h Epc;
  private kotlin.g.a.a<ah> Eqc;
  private kotlin.g.a.a<ah> Eqd;
  private final ImageView Eqe;
  private final ImageView Eqf;
  private final View Eqg;
  private final TextView Eqh;
  private final TextView Eqi;
  private final TextView Eqj;
  private final TextView Eqk;
  private final RecyclerView Eql;
  private com.tencent.mm.plugin.finder.live.view.adapter.m Eqm;
  private final View clickArea;
  private final View lBX;
  private final View njm;
  private final ProgressBar sIX;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(361807);
    Eqb = new a((byte)0);
    AppMethodBeat.o(361807);
  }
  
  public ac(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(361707);
    boolean bool;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.EpG = bool;
      if (!this.EpG) {
        break label503;
      }
    }
    label503:
    float f;
    for (int i = (int)(kotlin.k.k.bu(getHEIGHT(), getWIDTH()) - MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_3A));; i = (int)(f * (com.tencent.d.a.a.a.a.a.jTt() / 100.0F)))
    {
      this.CwP = i;
      paramContext = LayoutInflater.from(paramContext).inflate(p.f.CdK, (ViewGroup)this, true);
      s.s(paramContext, "from(context).inflate(R.…sk_widget_ui, this, true)");
      this.lBX = paramContext;
      this.clickArea = this.lBX.findViewById(p.e.BDj);
      this.EoS = ((LiveBottomSheetPanel)this.lBX.findViewById(p.e.BDk));
      this.CxW = this.EoS.findViewById(p.e.BDm);
      this.njm = this.EoS.findViewById(p.e.BDg);
      this.titleTv = ((TextView)this.EoS.findViewById(p.e.BDi));
      this.Eqe = ((ImageView)this.EoS.findViewById(p.e.BDh));
      this.Eqf = ((ImageView)this.EoS.findViewById(p.e.BDl));
      this.Eqg = this.EoS.findViewById(p.e.BDo);
      this.sIX = ((ProgressBar)this.EoS.findViewById(p.e.BDn));
      this.DQL = ((TextView)this.EoS.findViewById(p.e.BDO));
      this.Eqh = ((TextView)this.EoS.findViewById(p.e.BDu));
      this.Eqi = ((TextView)this.EoS.findViewById(p.e.BDS));
      this.Eqj = ((TextView)this.EoS.findViewById(p.e.BDd));
      this.Eqk = ((TextView)this.EoS.findViewById(p.e.BDe));
      this.Eql = ((RecyclerView)this.EoS.findViewById(p.e.BDp));
      this.Eqm = new com.tencent.mm.plugin.finder.live.view.adapter.m();
      this.clickArea.setOnClickListener((View.OnClickListener)this);
      this.CxW.setOnClickListener((View.OnClickListener)this);
      this.njm.setOnClickListener((View.OnClickListener)this);
      this.Eqf.setOnClickListener((View.OnClickListener)this);
      paramContext = this.Eql;
      this.lBX.getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramContext.setAdapter((RecyclerView.a)this.Eqm);
      paramContext = this.EoS;
      paramContext.getLayoutParams().height = this.CwP;
      paramContext.setOnVisibilityListener((kotlin.g.a.b)new b(this));
      Log.i("FinderLiveFansTaskWidget", s.X("init isLand:", Boolean.valueOf(this.EpG)));
      AppMethodBeat.o(361707);
      return;
      bool = false;
      break;
      f = getHEIGHT();
      com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    }
  }
  
  private static final ah a(ac paramac, boolean paramBoolean, b.a parama)
  {
    AppMethodBeat.i(361801);
    s.u(paramac, "this$0");
    paramac.Eqg.setVisibility(0);
    paramac.sIX.setVisibility(8);
    bgv localbgv;
    int i;
    label103:
    int j;
    label117:
    Object localObject;
    label179:
    label345:
    label351:
    label482:
    q localq;
    label278:
    label413:
    label457:
    ForegroundColorSpan localForegroundColorSpan;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = parama.ott;
      s.s(parama, "it.resp");
      localbgv = (bgv)parama;
      if (paramBoolean)
      {
        parama = paramac.getBasePlugin();
        if (parama != null) {
          break label667;
        }
        i = 0;
        if (localbgv.ZQi <= 0) {
          localbgv.ZQi = i;
        }
        parama = localbgv.ZQl;
        if (parama != null) {
          break label709;
        }
        parama = null;
        if ((parama == null) || (parama.abMv != 0)) {
          break label790;
        }
        j = 1;
        if (j != 0)
        {
          parama.abMv = 1;
          parama.abMu = i;
        }
      }
      localObject = new StringBuilder("setContent autoShowAfterJoin:").append(paramBoolean).append(",resp intimacy:").append(localbgv.ZQi).append(",default intimacy:");
      parama = paramac.getBasePlugin();
      if (parama == null)
      {
        parama = null;
        Log.i("FinderLiveFansTaskWidget", parama);
        paramac.DQL.setText((CharSequence)String.valueOf(localbgv.ZQi));
        localObject = new q(" :");
        ((q)localObject).setSpan(new ForegroundColorSpan(paramac.lBX.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_1)), 1, 2, 33);
        parama = com.tencent.mm.plugin.finder.live.view.span.h.DWP;
        parama = com.tencent.mm.plugin.finder.live.view.span.h.gS((List)localbgv.ZKa);
        if (parama != null) {
          break label841;
        }
        parama = null;
        if (parama == null)
        {
          parama = e.Eck;
          e.b.n((List)localbgv.ZKa, "");
        }
        paramac.Eqh.setText((CharSequence)localObject);
        parama = localbgv.ZQk;
        if (parama == null) {
          break label863;
        }
        parama = parama.nUC;
        if (parama == null) {
          break label863;
        }
        if (!((Collection)parama).isEmpty()) {
          break label858;
        }
        i = 1;
        if (i != 0) {
          break label863;
        }
        i = 1;
        if (i == 0) {
          break label868;
        }
        parama = paramac.lBX.getContext().getString(p.h.Ckj, new Object[] { Integer.valueOf(localbgv.ZQj) });
        s.s(parama, "root.context.getString(R…next_level_need_intimacy)");
        parama = paramac.eB(parama, localbgv.ZQj);
        paramac.Eqi.setText((CharSequence)parama);
        paramac.Eqj.setText((CharSequence)paramac.lBX.getContext().getString(p.h.CjW));
        localObject = new StringBuilder();
        parama = localbgv.ZQl;
        if (parama != null) {
          break label932;
        }
        parama = null;
        localObject = ((StringBuilder)localObject).append(parama).append('/');
        parama = localbgv.ZQl;
        if (parama != null) {
          break label943;
        }
        parama = null;
        localq = new q(parama);
        localForegroundColorSpan = new ForegroundColorSpan(paramac.lBX.getContext().getResources().getColor(p.b.Yellow));
        parama = localbgv.ZQl;
        if (parama != null) {
          break label954;
        }
        parama = null;
        label537:
        localObject = localbgv.ZQl;
        if (localObject != null) {
          break label965;
        }
        localObject = null;
        label552:
        if (s.p(parama, localObject)) {
          break label989;
        }
        parama = localbgv.ZQl;
        if (parama != null) {
          break label978;
        }
        parama = null;
        label573:
        localq.setSpan(localForegroundColorSpan, 0, String.valueOf(parama).length(), 17);
        label590:
        paramac.Eqk.setText((CharSequence)localq);
        localObject = paramac.Eqm;
        parama = localbgv.ZQl;
        if (parama != null) {
          break label1007;
        }
        parama = null;
        label620:
        if (parama != null)
        {
          ((com.tencent.mm.plugin.finder.live.view.adapter.m)localObject).vEn.clear();
          ((com.tencent.mm.plugin.finder.live.view.adapter.m)localObject).vEn.addAll((Collection)parama);
        }
        paramac.Eqm.bZE.notifyChanged();
      }
    }
    for (;;)
    {
      paramac = ah.aiuX;
      AppMethodBeat.o(361801);
      return paramac;
      label667:
      parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (parama == null)
      {
        i = 0;
        break;
      }
      parama = parama.Efg;
      if (parama == null)
      {
        i = 0;
        break;
      }
      i = parama.ZQr;
      break;
      label709:
      parama = parama.nUC;
      if (parama == null)
      {
        parama = null;
        break label103;
      }
      localObject = ((Iterable)parama).iterator();
      label734:
      if (((Iterator)localObject).hasNext())
      {
        parama = ((Iterator)localObject).next();
        if (((fmd)parama).abMx == 4)
        {
          j = 1;
          label766:
          if (j == 0) {
            break label783;
          }
        }
      }
      for (;;)
      {
        parama = (fmd)parama;
        break;
        j = 0;
        break label766;
        label783:
        break label734;
        parama = null;
      }
      label790:
      j = 0;
      break label117;
      parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (parama == null)
      {
        parama = null;
        break label179;
      }
      parama = parama.Efg;
      if (parama == null)
      {
        parama = null;
        break label179;
      }
      parama = Integer.valueOf(parama.ZQr);
      break label179;
      label841:
      ((q)localObject).setSpan(parama, 0, 1, 33);
      parama = ah.aiuX;
      break label278;
      label858:
      i = 0;
      break label345;
      label863:
      i = 0;
      break label351;
      label868:
      parama = paramac.Eqi;
      localObject = paramac.lBX.getContext().getString(p.h.Ckk, new Object[] { Integer.valueOf(localbgv.ZQj) });
      s.s(localObject, "root.context.getString(R…next_level_need_intimacy)");
      parama.setText((CharSequence)paramac.eB((String)localObject, localbgv.ZQj));
      break label413;
      label932:
      parama = Integer.valueOf(parama.abMs);
      break label457;
      label943:
      parama = Integer.valueOf(parama.abMt);
      break label482;
      label954:
      parama = Integer.valueOf(parama.abMs);
      break label537;
      label965:
      localObject = Integer.valueOf(((fmc)localObject).abMt);
      break label552;
      label978:
      parama = Integer.valueOf(parama.abMs);
      break label573;
      label989:
      localq.setSpan(localForegroundColorSpan, 0, localq.length(), 17);
      break label590;
      label1007:
      parama = parama.nUC;
      break label620;
      aa.dc(paramac.getContext(), paramac.getContext().getString(p.h.CkH));
    }
  }
  
  private final q eB(String paramString, int paramInt)
  {
    AppMethodBeat.i(361750);
    q localq = new q(paramString);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(p.b.Yellow));
    int i = n.a((CharSequence)paramString, String.valueOf(paramInt), 0, false, 6);
    localq.setSpan(localForegroundColorSpan, i, String.valueOf(paramInt).length() + i, 33);
    AppMethodBeat.o(361750);
    return localq;
  }
  
  private final void ehV()
  {
    AppMethodBeat.i(361719);
    com.tencent.mm.ui.widget.a.h localh = new com.tencent.mm.ui.widget.a.h(this.lBX.getContext());
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.gg(this.lBX);
    if (this.EpG) {
      this.clickArea.getLayoutParams().height = 0;
    }
    localh.d(this.lBX, new FrameLayout.LayoutParams(-1, -1));
    localh.fkh();
    localh.dDn();
    localObject = ah.aiuX;
    this.Epc = localh;
    AppMethodBeat.o(361719);
  }
  
  private final void sB(boolean paramBoolean)
  {
    AppMethodBeat.i(361771);
    showLoading();
    Object localObject1 = getBasePlugin();
    long l1;
    long l2;
    label37:
    label51:
    com.tencent.mm.bx.b localb;
    if (localObject1 == null)
    {
      l1 = 0L;
      localObject1 = getBasePlugin();
      if (localObject1 != null) {
        break label206;
      }
      l2 = 0L;
      localObject1 = getBasePlugin();
      if (localObject1 != null) {
        break label240;
      }
      localObject1 = null;
      localb = com.tencent.mm.bx.b.cX((byte[])localObject1);
      localObject1 = getBasePlugin();
      if (localObject1 != null) {
        break label274;
      }
      localObject1 = "";
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new i((String)localObject1, localb, l1, l2, z.bAW()).bFJ().b(new ac..ExternalSyntheticLambda0(this, paramBoolean));
      if ((getContext() == null) || (!(getContext() instanceof MMActivity))) {
        break label358;
      }
      localObject2 = getContext();
      if (localObject2 != null) {
        break label344;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(361771);
      throw ((Throwable)localObject1);
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        l1 = 0L;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        l1 = 0L;
        break;
      }
      l1 = ((bip)localObject1).liveId;
      break;
      label206:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        l2 = 0L;
        break label37;
      }
      l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
      break label37;
      label240:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label51;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZp;
      break label51;
      label274:
      localObject1 = ((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).getBuContext();
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
        if (localObject1 == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject2 = ((e)localObject1).mIC;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
    }
    label344:
    ((com.tencent.mm.cp.f)localObject1).a((com.tencent.mm.vending.e.b)localObject2);
    label358:
    AppMethodBeat.o(361771);
  }
  
  private final void setTitle(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(361740);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    com.tencent.mm.plugin.finder.api.m localm;
    Object localObject2;
    if (parama == null)
    {
      parama = "";
      localm = d.a.auT(parama);
      parama = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
      if (localm != null) {
        break label172;
      }
      parama = "";
    }
    Object localObject3;
    for (;;)
    {
      parama = new com.tencent.mm.plugin.finder.loader.b(parama);
      localObject1 = this.Eqe;
      s.s(localObject1, "titleIcon");
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(parama, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      this.titleTv.setText((CharSequence)"");
      parama = this.titleTv.getParent();
      if (parama != null) {
        break label194;
      }
      parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(361740);
      throw parama;
      parama = (e)parama.business(e.class);
      if (parama == null)
      {
        parama = "";
        break;
      }
      localObject1 = parama.mIC;
      parama = (com.tencent.mm.plugin.finder.live.model.context.a)localObject1;
      if (localObject1 != null) {
        break;
      }
      parama = "";
      break;
      label172:
      localObject1 = localm.amx();
      parama = (com.tencent.mm.plugin.finder.live.model.context.a)localObject1;
      if (localObject1 == null) {
        parama = "";
      }
    }
    label194:
    parama = (ViewGroup)parama;
    int n = parama.getMeasuredWidth();
    int i1 = parama.getChildCount();
    int k;
    int j;
    int m;
    int i;
    if (i1 > 0)
    {
      k = 0;
      j = 0;
      m = k + 1;
      localObject1 = parama.getChildAt(k);
      i = j;
      if (!s.p(localObject1, this.titleTv))
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(361740);
          throw parama;
        }
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        k = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
        i = j + i + (((ViewGroup.MarginLayoutParams)localObject1).rightMargin + k);
      }
      if (m < i1) {}
    }
    for (;;)
    {
      j = n - i;
      Context localContext;
      if (j > 0)
      {
        this.titleTv.setMaxWidth(j);
        Log.i("FinderLiveFansTaskWidget", "setTitle parentWidth:" + n + ",sibleWidth:" + i + ",titleTvMaxWidth:" + j + ",set maxWidth:" + this.titleTv.getMaxWidth());
        localObject2 = this.titleTv;
        localObject3 = this.lBX.getContext();
        localContext = this.lBX.getContext();
        i = p.h.CjX;
        if (localm != null) {
          break label510;
        }
        parama = "";
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)localContext.getString(i, new Object[] { parama }), this.titleTv.getTextSize()));
        AppMethodBeat.o(361740);
        return;
        this.titleTv.setMaxWidth((int)(bf.bf(MMApplicationContext.getContext()).x - MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_18A)));
        break;
        label510:
        localObject1 = localm.getNickname();
        parama = (com.tencent.mm.plugin.finder.live.model.context.a)localObject1;
        if (localObject1 == null) {
          parama = "";
        }
      }
      k = m;
      j = i;
      break;
      i = 0;
    }
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(361760);
    this.Eqg.setVisibility(8);
    this.sIX.setVisibility(0);
    AppMethodBeat.o(361760);
  }
  
  public final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(361869);
    Object localObject = getBasePlugin();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.plugin.b)localObject).getBuContext())
    {
      setTitle((com.tencent.mm.plugin.finder.live.model.context.a)localObject);
      sB(paramBoolean);
      ehV();
      AppMethodBeat.o(361869);
      return;
    }
  }
  
  public final com.tencent.mm.ui.widget.a.h getBottomSheet()
  {
    return this.Epc;
  }
  
  public final kotlin.g.a.a<ah> getFansGroupClickListener()
  {
    return this.Eqd;
  }
  
  public final kotlin.g.a.a<ah> getHelpIconClickListener()
  {
    return this.Eqc;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(361873);
    com.tencent.mm.ui.widget.a.h localh = this.Epc;
    if (localh != null) {
      localh.cyW();
    }
    this.Epc = null;
    this.EoS.setTranslationY(0.0F);
    AppMethodBeat.o(361873);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361864);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansTaskWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BDj;
      if (paramView != null) {
        break label105;
      }
      label53:
      i = p.e.BDm;
      if (paramView != null) {
        break label118;
      }
      label61:
      i = 0;
      label63:
      if (i == 0) {
        break label131;
      }
      hide();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansTaskWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361864);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label105:
      if (paramView.intValue() != i) {
        break label53;
      }
      i = 1;
      break label63;
      label118:
      if (paramView.intValue() != i) {
        break label61;
      }
      i = 1;
      break label63;
      label131:
      i = p.e.BDg;
      if (paramView == null) {}
      while (paramView.intValue() != i)
      {
        i = p.e.BDl;
        if ((paramView == null) || (paramView.intValue() != i)) {
          break;
        }
        paramView = this.Eqc;
        if (paramView == null) {
          break;
        }
        paramView.invoke();
        break;
      }
      paramView = aw.Gjk;
      if (aw.isFastClick())
      {
        Log.i("FinderLiveFansTaskWidget", "fast click fans_group!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansTaskWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(361864);
        return;
      }
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cb.DEp, null, null, 6);
      paramView = this.Eqd;
      if (paramView != null) {
        paramView.invoke();
      }
    }
  }
  
  public final void setBottomSheet(com.tencent.mm.ui.widget.a.h paramh)
  {
    this.Epc = paramh;
  }
  
  public final void setFansGroupClickListener(kotlin.g.a.a<ah> parama)
  {
    this.Eqd = parama;
  }
  
  public final void setHelpIconClickListener(kotlin.g.a.a<ah> parama)
  {
    this.Eqc = parama;
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(361879);
    super.unMount();
    hide();
    this.EoS.setOnVisibilityListener(null);
    AppMethodBeat.o(361879);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansTaskWidget$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "show", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ac
 * JD-Core Version:    0.7.0.1
 */