package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.model.a.a.a.b;
import com.tencent.mm.plugin.card.model.a.a.a.d;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mViewWidth", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b wHs;
  private int Sc;
  private final String TAG;
  private int mScene;
  private int mViewHeight;
  private int mViewWidth;
  private boolean sLf;
  private boolean szX;
  private ViewGroup wGH;
  private RefreshLoadMoreLayout wGX;
  private ViewGroup wGY;
  private long wHA;
  private wg wHB;
  private String wHC;
  private wp wHD;
  private String wHE;
  private int wHF;
  private int wHG;
  private boolean wHe;
  private boolean wHf;
  private int wHj;
  private WxRecyclerView wHt;
  private TextView wHu;
  private WxRecyclerAdapter<c> wHv;
  private final ArrayList<c> wHw;
  private int wHx;
  private boolean wHy;
  private String wHz;
  
  static
  {
    AppMethodBeat.i(294185);
    wHs = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(294185);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(293923);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.wHw = new ArrayList();
    this.wHx = 10;
    this.wHz = "";
    this.wHE = "";
    this.sLf = true;
    AppMethodBeat.o(293923);
  }
  
  private static final ah a(CouponCardListUI paramCouponCardListUI, b.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 1;
    AppMethodBeat.i(294026);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    Log.i(paramCouponCardListUI.TAG, "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (cgq)parama.ott;
      Log.i(paramCouponCardListUI.TAG, "retCode: %s, refresh: %s", new Object[] { Integer.valueOf(parama.wuz), Integer.valueOf(parama.aapA) });
      if (parama.wuz == 0) {
        if (parama.aapA == 1) {
          paramCouponCardListUI.nh(true);
        }
      }
    }
    label171:
    label473:
    label480:
    for (;;)
    {
      paramCouponCardListUI.wHy = false;
      paramCouponCardListUI = ah.aiuX;
      AppMethodBeat.o(294026);
      return paramCouponCardListUI;
      if (parama.aapz.ZcB.size() == 0) {
        if (!((Collection)paramCouponCardListUI.wHw).isEmpty())
        {
          if (i == 0) {
            break label263;
          }
          localObject1 = paramCouponCardListUI.wHw.iterator();
          i = 0;
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label480;
        }
        if (kotlin.g.b.s.p(((c)((Iterator)localObject1).next()).doz().Zcw, parama.aapz.Zcw))
        {
          paramCouponCardListUI.wHw.remove(i);
          localObject1 = paramCouponCardListUI.wHv;
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("mCouponCardListAdapter");
            parama = null;
          }
          parama.bZE.notifyChanged();
          break;
          i = 0;
          break label171;
          break;
          Iterator localIterator;
          if (!((Collection)paramCouponCardListUI.wHw).isEmpty())
          {
            i = 1;
            if (i == 0) {
              break label402;
            }
            localIterator = paramCouponCardListUI.wHw.iterator();
            i = 0;
          }
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label473;
            }
            c localc = (c)localIterator.next();
            if (kotlin.g.b.s.p(localc.doz().Zcw, parama.aapz.Zcw))
            {
              parama = parama.aapz;
              kotlin.g.b.s.s(parama, "card_pkg_mch_info");
              localc.a(parama);
              if ((paramCouponCardListUI.wHF > 0) && (paramCouponCardListUI.wHD != null))
              {
                parama = paramCouponCardListUI.wHv;
                if (parama == null)
                {
                  kotlin.g.b.s.bIx("mCouponCardListAdapter");
                  parama = (b.a)localObject1;
                }
                for (;;)
                {
                  parama.fV(i + 1);
                  break;
                  i = 0;
                  break label282;
                  break;
                }
              }
              parama = paramCouponCardListUI.wHv;
              if (parama == null)
              {
                kotlin.g.b.s.bIx("mCouponCardListAdapter");
                parama = localObject2;
              }
              for (;;)
              {
                parama.fV(i);
                break;
              }
              l.ar((Context)paramCouponCardListUI.getContext(), parama.wuA);
              break;
              l.as((Context)paramCouponCardListUI.getContext(), "");
              break;
            }
            i += 1;
          }
          break;
        }
        i += 1;
      }
    }
  }
  
  private static final void a(CouponCardListUI paramCouponCardListUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(294005);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    com.tencent.mm.pluginsdk.permission.b.bG((Activity)paramCouponCardListUI.getContext());
    AppMethodBeat.o(294005);
  }
  
  private static final void a(CouponCardListUI paramCouponCardListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294013);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    paramInt = paramMenuItem.getItemId();
    Log.i(paramCouponCardListUI.TAG, "click item: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      if (!paramCouponCardListUI.dom())
      {
        k.a((Context)paramCouponCardListUI.getContext(), paramCouponCardListUI.getString(a.g.woY), paramCouponCardListUI.getString(a.g.permission_tips_title), paramCouponCardListUI.getString(a.g.jump_to_settings), paramCouponCardListUI.getString(a.g.confirm_dialog_cancel), false, new CouponCardListUI..ExternalSyntheticLambda0(paramCouponCardListUI), null);
        AppMethodBeat.o(294013);
        return;
      }
      paramCouponCardListUI.wHG = paramCouponCardListUI.wHF;
      paramCouponCardListUI.wHF = 1;
      paramCouponCardListUI.wHE = paramMenuItem.getTitle().toString();
      paramCouponCardListUI.doy();
      paramCouponCardListUI.nh(true);
      h.OAn.b(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      AppMethodBeat.o(294013);
      return;
    }
    paramCouponCardListUI.wHG = paramCouponCardListUI.wHF;
    paramCouponCardListUI.wHF = paramInt;
    paramCouponCardListUI.wHE = paramMenuItem.getTitle().toString();
    paramCouponCardListUI.doy();
    paramCouponCardListUI.nh(true);
    h.OAn.b(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
    AppMethodBeat.o(294013);
  }
  
  private static final void a(CouponCardListUI paramCouponCardListUI, View paramView)
  {
    AppMethodBeat.i(293979);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCouponCardListUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    Log.d(paramCouponCardListUI.TAG, "click header view");
    paramCouponCardListUI.dox();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(293979);
  }
  
  private static final void a(CouponCardListUI paramCouponCardListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(293985);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    params.add(0, 0, 1, (CharSequence)paramCouponCardListUI.wHC);
    AppMethodBeat.o(293985);
  }
  
  private final void a(cic paramcic)
  {
    Object localObject1 = null;
    AppMethodBeat.i(293969);
    if ((paramcic.aaqM == null) || (paramcic.aaqM.ZcQ.isEmpty()))
    {
      AppMethodBeat.o(293969);
      return;
    }
    paramcic = paramcic.aaqM.ZcQ.iterator();
    Object localObject2;
    while (paramcic.hasNext())
    {
      localObject2 = (vw)paramcic.next();
      c localc = new c();
      kotlin.g.b.s.s(localObject2, "cardInfo");
      localc.a((vw)localObject2);
      this.wHw.add(localc);
    }
    if (this.wHw.isEmpty())
    {
      localObject2 = this.wGH;
      paramcic = (cic)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        paramcic = null;
      }
      paramcic.setVisibility(0);
      paramcic = this.wHv;
      if (paramcic != null) {
        break label194;
      }
      kotlin.g.b.s.bIx("mCouponCardListAdapter");
      paramcic = localObject1;
    }
    label194:
    for (;;)
    {
      paramcic.bZE.notifyChanged();
      AppMethodBeat.o(293969);
      return;
      localObject2 = this.wGH;
      paramcic = (cic)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        paramcic = null;
      }
      paramcic.setVisibility(8);
      break;
    }
  }
  
  private static final void a(wg paramwg, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(293989);
    kotlin.g.b.s.u(paramwg, "$this_apply");
    if (paramMenuItem.getItemId() == 0)
    {
      com.tencent.mm.plugin.card.c.b.S(paramwg.VcU, paramwg.VcV, paramwg.VQU);
      h.OAn.b(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
    }
    AppMethodBeat.o(293989);
  }
  
  private static final boolean a(CouponCardListUI paramCouponCardListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(293976);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    paramCouponCardListUI.finish();
    AppMethodBeat.o(293976);
    return false;
  }
  
  private static final boolean a(CouponCardListUI paramCouponCardListUI, wg paramwg, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(293995);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    kotlin.g.b.s.u(paramwg, "$this_apply");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramCouponCardListUI.getContext(), 1, false);
    paramMenuItem.Vtg = new CouponCardListUI..ExternalSyntheticLambda4(paramCouponCardListUI);
    paramMenuItem.GAC = new CouponCardListUI..ExternalSyntheticLambda7(paramwg);
    paramMenuItem.dDn();
    h.OAn.b(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    AppMethodBeat.o(293995);
    return false;
  }
  
  private static final void b(CouponCardListUI paramCouponCardListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294001);
    kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
    paramCouponCardListUI = paramCouponCardListUI.wHD;
    kotlin.g.b.s.checkNotNull(paramCouponCardListUI);
    paramCouponCardListUI = paramCouponCardListUI.ZdB.iterator();
    while (paramCouponCardListUI.hasNext())
    {
      wo localwo = (wo)paramCouponCardListUI.next();
      params.add(0, localwo.Zdy, 1, (CharSequence)localwo.ZdA);
    }
    AppMethodBeat.o(294001);
  }
  
  private final void dow()
  {
    AppMethodBeat.i(293930);
    wg localwg = this.wHB;
    if (localwg != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, a.f.icons_outlined_more, new CouponCardListUI..ExternalSyntheticLambda2(this, localwg));
    }
    AppMethodBeat.o(293930);
  }
  
  private final void dox()
  {
    AppMethodBeat.i(293938);
    Log.i(this.TAG, "show sort dialog");
    if (this.wHD == null)
    {
      AppMethodBeat.o(293938);
      return;
    }
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, false);
    localf.Vtg = new CouponCardListUI..ExternalSyntheticLambda5(this);
    localf.GAC = new CouponCardListUI..ExternalSyntheticLambda6(this);
    localf.dDn();
    AppMethodBeat.o(293938);
  }
  
  private final void doy()
  {
    Object localObject3 = null;
    AppMethodBeat.i(293950);
    int i;
    Object localObject1;
    label54:
    label82:
    ViewGroup localViewGroup;
    Object localObject2;
    if (this.wHF > 0) {
      if (!((Collection)this.wHw).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label158;
        }
        localObject1 = this.wHu;
        if (localObject1 != null) {
          break label152;
        }
        kotlin.g.b.s.bIx("mSortTv");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)this.wHE);
        localObject1 = this.wHv;
        if (localObject1 != null) {
          break label155;
        }
        kotlin.g.b.s.bIx("mCouponCardListAdapter");
        localObject1 = null;
        localViewGroup = this.wGY;
        localObject2 = localViewGroup;
        if (localViewGroup == null)
        {
          kotlin.g.b.s.bIx("mHeaderView");
          localObject2 = null;
        }
        ((WxRecyclerAdapter)localObject1).i((View)localObject2, 2, false);
        label115:
        localObject1 = this.wHv;
        if (localObject1 != null) {
          break label212;
        }
        kotlin.g.b.s.bIx("mCouponCardListAdapter");
        localObject1 = localObject3;
      }
    }
    label152:
    label155:
    label158:
    label212:
    for (;;)
    {
      ((RecyclerView.a)localObject1).bZE.notifyChanged();
      AppMethodBeat.o(293950);
      return;
      i = 0;
      break;
      break label54;
      break label82;
      localObject2 = this.wHv;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mCouponCardListAdapter");
        localObject1 = null;
      }
      localViewGroup = this.wGY;
      localObject2 = localViewGroup;
      if (localViewGroup == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject2 = null;
      }
      ((WxRecyclerAdapter)localObject1).ae(((ViewGroup)localObject2).hashCode(), false);
      break label115;
    }
  }
  
  private final void nh(final boolean paramBoolean)
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(293960);
    Log.i(this.TAG, "do load vip card list: " + this.szX + ", " + this.Sc + ", " + this.wHF);
    if ((this.wHe) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localRefreshLoadMoreLayout = this.wGX;
      if (localRefreshLoadMoreLayout == null) {
        kotlin.g.b.s.bIx("mRefreshLayout");
      }
      for (;;)
      {
        ((RefreshLoadMoreLayout)localObject).aFW(0);
        AppMethodBeat.o(293960);
        return;
        localObject = localRefreshLoadMoreLayout;
      }
    }
    if (this.szX)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(293960);
      return;
    }
    this.szX = true;
    int j = this.Sc;
    if (paramBoolean)
    {
      localObject = this.wGX;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject = localRefreshLoadMoreLayout;
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.wHx, getLatitude(), getLongitude(), this.wHF);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      kotlin.g.b.s.s(localObject, "CgiGetCouponHomePage(off…ntCancelAfterDead().run()");
      d.b((c)localObject, (kotlin.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(293960);
      return;
      break;
      i = j;
    }
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(294265);
    if ((this.sLf) && (this.wHF == 1))
    {
      nh(true);
      AppMethodBeat.o(294265);
      return;
    }
    if (!paramBoolean) {
      doo();
    }
    AppMethodBeat.o(294265);
  }
  
  public final int getLayoutId()
  {
    return a.e.wmV;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(294244);
    Object localObject1 = findViewById(a.d.wiZ);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.wHt = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(a.d.wiX);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.wGX = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(a.d.wiV);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.wGH = ((ViewGroup)localObject1);
    localObject1 = this.wHt;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mCouponCardListRv");
      localObject1 = null;
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      this.wHv = new WxRecyclerAdapter((g)new f(this), this.wHw);
      localObject1 = this.wHt;
      if (localObject1 != null) {
        break label256;
      }
      kotlin.g.b.s.bIx("mCouponCardListRv");
      localObject1 = null;
    }
    Object localObject4;
    Object localObject2;
    label256:
    for (;;)
    {
      localObject4 = this.wHv;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mCouponCardListAdapter");
        localObject2 = null;
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject4 = getLayoutInflater();
      int i = a.e.wna;
      localObject2 = this.wHt;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mCouponCardListRv");
        localObject1 = null;
      }
      localObject1 = ((LayoutInflater)localObject4).inflate(i, (ViewGroup)localObject1, false);
      if (localObject1 != null) {
        break label259;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(294244);
      throw ((Throwable)localObject1);
      break;
    }
    label259:
    this.wGY = ((ViewGroup)localObject1);
    localObject1 = this.wGY;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
      localObject4 = this.wGY;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject2 = null;
      }
      ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 12));
      localObject2 = this.wGY;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject1 = null;
      }
      localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wjb);
      kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
      this.wHu = ((TextView)localObject1);
      localObject2 = this.wGY;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setOnClickListener(new CouponCardListUI..ExternalSyntheticLambda3(this));
      localObject1 = this.wHv;
      if (localObject1 != null) {
        break label518;
      }
      kotlin.g.b.s.bIx("mCouponCardListAdapter");
      localObject1 = null;
      label418:
      localObject4 = this.wGY;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject2 = null;
      }
      ((WxRecyclerAdapter)localObject1).i((View)localObject2, 2, false);
      localObject2 = this.wGX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject1 = null;
      }
      ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
      localObject1 = this.wGX;
      if (localObject1 != null) {
        break label521;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      localObject1 = localObject3;
    }
    label518:
    label521:
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new g(this));
      AppMethodBeat.o(294244);
      return;
      break;
      break label418;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(294237);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("title");
    Object localObject = (CharSequence)paramBundle;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label295;
      }
      setMMTitle(paramBundle);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.BG_0));
      hideActionbarLine();
      setBackBtn(new CouponCardListUI..ExternalSyntheticLambda1(this));
      this.mScene = getIntent().getIntExtra("scene", 0);
      paramBundle = com.tencent.mm.plugin.card.model.a.a.wvG;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.dld();
      if (paramBundle != null)
      {
        this.Sc = paramBundle.xlj;
        this.wHD = paramBundle.aaqR;
        this.wHB = paramBundle.aaqN;
        this.wHC = paramBundle.aaqO;
        dow();
        a(paramBundle);
      }
      paramBundle = com.tencent.mm.plugin.card.model.a.a.wvG;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.dlh();
      if (paramBundle != null)
      {
        this.wHF = paramBundle.Zdy;
        localObject = paramBundle.ZdA;
        kotlin.g.b.s.s(localObject, "cardSortInfo.sort_wording");
        this.wHE = ((String)localObject);
        this.wHx = paramBundle.Zdz;
        this.wHG = this.wHF;
      }
      if ((this.wHD == null) || (this.mScene != 1)) {
        break label305;
      }
      paramBundle = this.wHD;
      kotlin.g.b.s.checkNotNull(paramBundle);
      paramBundle = paramBundle.ZdB.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (wo)paramBundle.next();
        if (((wo)localObject).Zdy == 2)
        {
          this.wHF = 2;
          localObject = ((wo)localObject).ZdA;
          kotlin.g.b.s.s(localObject, "sortInfo.sort_wording");
          this.wHE = ((String)localObject);
        }
      }
      i = 0;
      break;
      label295:
      setMMTitle(a.g.wou);
    }
    label305:
    doy();
    doy();
    if (this.wHF != 1) {
      nh(true);
    }
    AppMethodBeat.o(294237);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(294255);
    super.onDestroy();
    if (!this.wHf)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(294255);
      return;
    }
    Object localObject1 = new cic();
    ((cic)localObject1).BaseResponse = new kd();
    ((cic)localObject1).BaseResponse.akjO = new etl();
    ((cic)localObject1).aaqM = new wa();
    Object localObject2 = this.wHw.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      vw localvw = ((c)((Iterator)localObject2).next()).doz();
      if (localvw != null) {
        ((cic)localObject1).aaqM.ZcQ.add(localvw);
      }
    }
    ((cic)localObject1).aaqR = this.wHD;
    ((cic)localObject1).xlj = this.Sc;
    ((cic)localObject1).aaqO = this.wHC;
    ((cic)localObject1).aaqN = this.wHB;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localObject1, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.B((kotlin.g.a.a)new a.a.b((cic)localObject1));
    localObject1 = new wo();
    ((wo)localObject1).Zdy = this.wHF;
    ((wo)localObject1).ZdA = this.wHE;
    ((wo)localObject1).Zdz = this.wHx;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localObject1, "sortInfo");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.B((kotlin.g.a.a)new a.a.d((wo)localObject1));
    AppMethodBeat.o(294255);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(294248);
    super.onResume();
    Log.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.wHy) });
    if (this.wHy)
    {
      com.tencent.mm.plugin.card.model.a.f localf = new com.tencent.mm.plugin.card.model.a.f(this.wHz, this.wHA, getLatitude(), getLongitude(), this.wHF, 1);
      localf.otr = true;
      localf.bFJ().b(new CouponCardListUI..ExternalSyntheticLambda8(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(294248);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean wFM;
    boolean wFN;
    public vw wHI;
    
    public c()
    {
      AppMethodBeat.i(293891);
      AppMethodBeat.o(293891);
    }
    
    public final void a(vw paramvw)
    {
      AppMethodBeat.i(293908);
      kotlin.g.b.s.u(paramvw, "<set-?>");
      this.wHI = paramvw;
      AppMethodBeat.o(293908);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(293917);
      long l = doz().Zcw.hashCode();
      AppMethodBeat.o(293917);
      return l;
    }
    
    public final int bZB()
    {
      return 1;
    }
    
    public final vw doz()
    {
      AppMethodBeat.i(293899);
      vw localvw = this.wHI;
      if (localvw != null)
      {
        AppMethodBeat.o(293899);
        return localvw;
      }
      kotlin.g.b.s.bIx("couponCardInfo");
      AppMethodBeat.o(293899);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends com.tencent.mm.view.recyclerview.f<CouponCardListUI.c>
  {
    public d()
    {
      AppMethodBeat.i(293913);
      AppMethodBeat.o(293913);
    }
    
    private final void a(int paramInt1, int paramInt2, j paramj, CouponCardListUI.c paramc, int paramInt3)
    {
      AppMethodBeat.i(294021);
      paramc = paramc.doz();
      ViewGroup localViewGroup = (ViewGroup)paramj.UH(a.d.wiu);
      Iterator localIterator = paramc.ZcB.iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        int k;
        Object localObject1;
        ah.f localf;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        TextView localTextView;
        if (localIterator.hasNext())
        {
          k = i + 1;
          localObject1 = (vt)localIterator.next();
          if (i < paramInt1) {
            break label1028;
          }
          localf = new ah.f();
          if (((vt)localObject1).Zcd != 1) {
            break label450;
          }
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(a.e.wmM, localViewGroup, false);
          if (localObject2 == null)
          {
            paramj = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(294021);
            throw paramj;
          }
          localf.aqH = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)localf.aqH).findViewById(a.d.wif);
          localObject4 = (CdnImageView)((ViewGroup)localf.aqH).findViewById(a.d.wic);
          localTextView = (TextView)((ViewGroup)localf.aqH).findViewById(a.d.wid);
          localObject2 = (LinearLayout)((ViewGroup)localf.aqH).findViewById(a.d.wie);
          if (!Util.isNullOrNil(((vt)localObject1).Zcg)) {
            ((TextView)localObject3).setTextColor(l.dO(((vt)localObject1).Zcg, ((vt)localObject1).Zch));
          }
          ((TextView)localObject3).setText((CharSequence)((vt)localObject1).ZbX);
          ((CdnImageView)localObject4).setUrl(((vt)localObject1).Zce);
          if (!Util.isNullOrNil(((vt)localObject1).Zci)) {
            localTextView.setTextColor(l.dO(((vt)localObject1).Zci, ((vt)localObject1).Zcj));
          }
          localTextView.setText((CharSequence)((vt)localObject1).ZbY);
          localObject3 = ((vt)localObject1).Zcc;
          kotlin.g.b.s.s(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          kotlin.g.b.s.s(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.aqH).setOnClickListener(new CouponCardListUI.d..ExternalSyntheticLambda3(this.wHH, paramc, (vt)localObject1, i, paramInt3));
          ((ViewGroup)localf.aqH).setTag(((vt)localObject1).YBH);
          localObject1 = (View)localf.aqH;
          kotlin.g.b.s.s(localViewGroup, "chpiCouponLayout");
          c((View)localObject1, localViewGroup);
        }
        for (;;)
        {
          if (paramInt2 > 0)
          {
            j += 1;
            if (j >= paramInt2)
            {
              AppMethodBeat.o(294021);
              return;
              label450:
              if (((vt)localObject1).Zcd == 2)
              {
                localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(a.e.wmL, localViewGroup, false);
                if (localObject2 == null)
                {
                  paramj = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                  AppMethodBeat.o(294021);
                  throw paramj;
                }
                localf.aqH = ((ViewGroup)localObject2);
                localObject4 = (TextView)((ViewGroup)localf.aqH).findViewById(a.d.wif);
                localTextView = (TextView)((ViewGroup)localf.aqH).findViewById(a.d.wid);
                localObject2 = (LinearLayout)((ViewGroup)localf.aqH).findViewById(a.d.wie);
                MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)localf.aqH).findViewById(a.d.wia);
                localObject3 = (ImageView)((ViewGroup)localf.aqH).findViewById(a.d.wib);
                if (!Util.isNullOrNil(((vt)localObject1).Zcg)) {
                  ((TextView)localObject4).setTextColor(l.dO(((vt)localObject1).Zcg, ((vt)localObject1).Zch));
                }
                ((TextView)localObject4).setText((CharSequence)((vt)localObject1).ZbX);
                localTextView.setText((CharSequence)((vt)localObject1).ZbY);
                localMemberCardTopCropImageView.setRadius(com.tencent.mm.cd.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
                if (!Util.isNullOrNil(((vt)localObject1).Zcb))
                {
                  localObject4 = ((ViewGroup)localf.aqH).findViewById(a.d.wia);
                  kotlin.g.b.s.s(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
                  localObject4 = (MemberCardTopCropImageView)localObject4;
                  localObject4 = (kotlin.g.a.a)new a(this.wHH, (MemberCardTopCropImageView)localObject4, (vt)localObject1);
                  if ((CouponCardListUI.p(this.wHH) <= 0) || (CouponCardListUI.q(this.wHH) <= 0))
                  {
                    CouponCardListUI.d(this.wHH, ((ViewGroup)localf.aqH).getHeight());
                    CouponCardListUI.e(this.wHH, ((ViewGroup)localf.aqH).getWidth());
                    if ((CouponCardListUI.p(this.wHH) <= 0) || (CouponCardListUI.q(this.wHH) <= 0))
                    {
                      paramj.caK.post(new CouponCardListUI.d..ExternalSyntheticLambda6(this.wHH, localf, (kotlin.g.a.a)localObject4));
                      label836:
                      ((ImageView)localObject3).setVisibility(0);
                    }
                  }
                }
                for (;;)
                {
                  localObject3 = ((vt)localObject1).Zcc;
                  kotlin.g.b.s.s(localObject3, "coupon.coupon_label");
                  localObject3 = (List)localObject3;
                  kotlin.g.b.s.s(localObject2, "labelLayout");
                  a((List)localObject3, (LinearLayout)localObject2);
                  localViewGroup.getChildCount();
                  ((ViewGroup)localf.aqH).setOnClickListener(new CouponCardListUI.d..ExternalSyntheticLambda2(this.wHH, paramc, (vt)localObject1));
                  ((ViewGroup)localf.aqH).setTag(((vt)localObject1).YBH);
                  localObject1 = (View)localf.aqH;
                  kotlin.g.b.s.s(localViewGroup, "chpiCouponLayout");
                  c((View)localObject1, localViewGroup);
                  break;
                  ((kotlin.g.a.a)localObject4).invoke();
                  break label836;
                  ((kotlin.g.a.a)localObject4).invoke();
                  break label836;
                  if (!Util.isNullOrNil(((vt)localObject1).Zca))
                  {
                    localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(((vt)localObject1).Zca)));
                    ((ImageView)localObject3).setVisibility(0);
                  }
                }
              }
            }
            else
            {
              i = k;
              break;
            }
          }
        }
        label1028:
        i = k;
      }
    }
    
    private static final void a(d paramd, j paramj, CouponCardListUI.c paramc, int paramInt, View paramView)
    {
      AppMethodBeat.i(294083);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramd);
      localb.cH(paramj);
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramd, "this$0");
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(paramc, "$item");
      Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
      paramd.d(paramj, paramc, paramInt);
      paramc.wFN = false;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294083);
    }
    
    private static final void a(CouponCardListUI paramCouponCardListUI, d paramd, j paramj, CouponCardListUI.c paramc, int paramInt, View paramView)
    {
      AppMethodBeat.i(294073);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCouponCardListUI);
      localb.cH(paramd);
      localb.cH(paramj);
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
      kotlin.g.b.s.u(paramd, "this$1");
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(paramc, "$item");
      Log.d(CouponCardListUI.a(paramCouponCardListUI), "do expand coupon layout");
      paramd.c(paramj, paramc, paramInt);
      paramc.wFN = true;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294073);
    }
    
    private static final void a(CouponCardListUI paramCouponCardListUI, vw paramvw, vt paramvt, int paramInt1, int paramInt2, View paramView)
    {
      AppMethodBeat.i(294099);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCouponCardListUI);
      localb.cH(paramvw);
      localb.cH(paramvt);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
      kotlin.g.b.s.u(paramvw, "$el");
      CouponCardListUI.r(paramCouponCardListUI);
      paramView = paramvw.Zcw;
      kotlin.g.b.s.s(paramView, "el.card_pack_merchant_id");
      CouponCardListUI.c(paramCouponCardListUI, paramView);
      CouponCardListUI.a(paramCouponCardListUI, paramvw.ZcJ);
      paramvw = paramvt.YBH;
      kotlin.g.b.s.s(paramvw, "coupon.user_card_id");
      CouponCardListUI.d(paramCouponCardListUI, paramvw);
      h.OAn.b(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), paramvt.YBH, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294099);
    }
    
    private static final void a(CouponCardListUI paramCouponCardListUI, vw paramvw, vt paramvt, View paramView)
    {
      AppMethodBeat.i(294123);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCouponCardListUI);
      localb.cH(paramvw);
      localb.cH(paramvt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
      kotlin.g.b.s.u(paramvw, "$el");
      CouponCardListUI.r(paramCouponCardListUI);
      paramView = paramvw.Zcw;
      kotlin.g.b.s.s(paramView, "el.card_pack_merchant_id");
      CouponCardListUI.c(paramCouponCardListUI, paramView);
      CouponCardListUI.a(paramCouponCardListUI, paramvw.ZcJ);
      paramvw = paramvt.YBH;
      kotlin.g.b.s.s(paramvw, "coupon.user_card_id");
      CouponCardListUI.d(paramCouponCardListUI, paramvw);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(294123);
    }
    
    private static final void a(CouponCardListUI paramCouponCardListUI, j paramj, View paramView)
    {
      AppMethodBeat.i(294056);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramCouponCardListUI);
      localb.cH(paramj);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
      kotlin.g.b.s.u(paramj, "$holder");
      Log.i(CouponCardListUI.a(paramCouponCardListUI), kotlin.g.b.s.X("click header view: ", Integer.valueOf(paramj.KJ())));
      paramj = ((CouponCardListUI.c)paramj.CSA).doz();
      if (paramj != null) {
        switch (paramj.Zcl)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(294056);
        return;
        CouponCardListUI.r(paramCouponCardListUI);
        paramView = paramj.Zcw;
        kotlin.g.b.s.s(paramView, "card_pack_merchant_id");
        CouponCardListUI.c(paramCouponCardListUI, paramView);
        CouponCardListUI.a(paramCouponCardListUI, paramj.ZcJ);
        paramCouponCardListUI = paramCouponCardListUI.getContext();
        if (paramCouponCardListUI == null)
        {
          paramCouponCardListUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(294056);
          throw paramCouponCardListUI;
        }
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCouponCardListUI, paramj.Zcm, 0);
        continue;
        CouponCardListUI.r(paramCouponCardListUI);
        paramView = paramj.Zcw;
        kotlin.g.b.s.s(paramView, "card_pack_merchant_id");
        CouponCardListUI.c(paramCouponCardListUI, paramView);
        CouponCardListUI.a(paramCouponCardListUI, paramj.ZcJ);
        paramCouponCardListUI = paramj.Zcn;
        com.tencent.mm.plugin.card.c.b.S(paramCouponCardListUI.VcU, paramCouponCardListUI.VcV, paramCouponCardListUI.VQU);
      }
    }
    
    private static final void a(CouponCardListUI paramCouponCardListUI, ah.f paramf, kotlin.g.a.a parama)
    {
      AppMethodBeat.i(294111);
      kotlin.g.b.s.u(paramCouponCardListUI, "this$0");
      kotlin.g.b.s.u(paramf, "$view");
      kotlin.g.b.s.u(parama, "$func");
      CouponCardListUI.d(paramCouponCardListUI, ((ViewGroup)paramf.aqH).getHeight());
      CouponCardListUI.e(paramCouponCardListUI, ((ViewGroup)paramf.aqH).getWidth());
      parama.invoke();
      AppMethodBeat.o(294111);
    }
    
    private static final void a(vw paramvw, View paramView)
    {
      AppMethodBeat.i(294064);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramvw);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramvw, "$this_apply");
      if (paramvw.ZcE != null) {
        if (paramvw.ZcE == null) {
          break label152;
        }
      }
      label152:
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.card.c.b.S(paramvw.ZcE.VcU, paramvw.ZcE.VcV, paramvw.ZcE.VQU);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(294064);
        return;
      }
    }
    
    private static void a(j paramj, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(293928);
      paramc = paramc.doz();
      TextView localTextView = (TextView)paramj.UH(a.d.wiy);
      ImageView localImageView = (ImageView)paramj.UH(a.d.wiw);
      paramj = (ViewGroup)paramj.UH(a.d.wix);
      if (!Util.isNullOrNil(paramc.ZcC))
      {
        if (!Util.isNullOrNil(paramc.ZcD)) {
          localTextView.setTextColor(Color.parseColor(paramc.ZcD));
        }
        localTextView.setText((CharSequence)paramc.ZcC);
        localImageView.setImageResource(a.c.wel);
        paramj.setOnClickListener(new CouponCardListUI.d..ExternalSyntheticLambda5(paramc));
      }
      AppMethodBeat.o(293928);
    }
    
    private final void a(j paramj, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(293944);
      vw localvw = paramc.doz();
      TextView localTextView = (TextView)paramj.UH(a.d.wiy);
      ImageView localImageView = (ImageView)paramj.UH(a.d.wiw);
      ViewGroup localViewGroup = (ViewGroup)paramj.UH(a.d.wix);
      Resources localResources = MMApplicationContext.getResources();
      int i = a.g.woQ;
      kotlin.g.b.s.checkNotNull(localvw);
      localTextView.setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(localvw.ZcH - localvw.ZcI) }));
      localViewGroup.setOnClickListener(new CouponCardListUI.d..ExternalSyntheticLambda1(this.wHH, this, paramj, paramc, paramInt));
      localImageView.setImageResource(a.c.wet);
      localImageView.setVisibility(0);
      AppMethodBeat.o(293944);
    }
    
    private final void a(List<? extends vs> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(294036);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        vs localvs = (vs)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.wHH.getContext());
        AppCompatActivity localAppCompatActivity = this.wHH.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localvs.ZbR);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localvs.ZbS))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localvs.ZbS));
          label170:
          if (Util.isNullOrNil(localvs.ZbT)) {
            break label220;
          }
          localCardTagTextView.setFillColor(l.dO(localvs.ZbT, localvs.ZbW));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label170;
          label220:
          localCardTagTextView.setFillColor(l.gy(-16777216, 26));
        }
      }
      AppMethodBeat.o(294036);
    }
    
    private final void a(boolean paramBoolean, j paramj, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(293973);
      vw localvw = paramc.doz();
      if (paramBoolean)
      {
        if (!Util.isNullOrNil(localvw.ZcC))
        {
          a(paramj, paramc);
          AppMethodBeat.o(293973);
          return;
        }
        b(paramj, paramc, paramInt);
        AppMethodBeat.o(293973);
        return;
      }
      a(paramj, paramc, paramInt);
      AppMethodBeat.o(293973);
    }
    
    private final void b(j paramj, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(293965);
      paramc.doz();
      TextView localTextView = (TextView)paramj.UH(a.d.wiy);
      ImageView localImageView = (ImageView)paramj.UH(a.d.wiw);
      ViewGroup localViewGroup = (ViewGroup)paramj.UH(a.d.wix);
      localTextView.setText((CharSequence)MMApplicationContext.getResources().getString(a.g.woO));
      localViewGroup.setOnClickListener(new CouponCardListUI.d..ExternalSyntheticLambda0(this, paramj, paramc, paramInt));
      localImageView.setImageResource(a.c.weu);
      localImageView.setVisibility(0);
      AppMethodBeat.o(293965);
    }
    
    private static void c(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(294045);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(294045);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(294045);
    }
    
    private final void c(j paramj, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(293983);
      vw localvw = paramc.doz();
      paramj.UH(a.d.wiy);
      paramj.UH(a.d.wiw);
      ViewGroup localViewGroup = (ViewGroup)paramj.UH(a.d.wix);
      int i = ((ViewGroup)paramj.UH(a.d.wiu)).getChildCount();
      kotlin.g.b.s.checkNotNull(localvw);
      if (i >= localvw.ZcH)
      {
        AppMethodBeat.o(293983);
        return;
      }
      a(localvw.ZcI, -1, paramj, paramc, paramInt);
      if (localvw.ZcI >= localvw.ZcH)
      {
        localViewGroup.setVisibility(8);
        AppMethodBeat.o(293983);
        return;
      }
      a(true, paramj, paramc, paramInt);
      AppMethodBeat.o(293983);
    }
    
    private final void d(j paramj, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(293993);
      vw localvw = paramc.doz();
      ViewGroup localViewGroup = (ViewGroup)paramj.UH(a.d.wiu);
      int i;
      int j;
      if (localViewGroup.getChildCount() > localvw.ZcI)
      {
        String str = CouponCardListUI.a(this.wHH);
        i = localViewGroup.getChildCount();
        kotlin.g.b.s.checkNotNull(localvw);
        Log.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localvw.ZcI) });
        i = localViewGroup.getChildCount() - 1;
        j = localvw.ZcI;
        if (j > i) {}
      }
      for (;;)
      {
        localViewGroup.removeViewAt(i);
        if (i == j)
        {
          a(false, paramj, paramc, paramInt);
          AppMethodBeat.o(293993);
          return;
        }
        i -= 1;
      }
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(294216);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramj, "holder");
      AppMethodBeat.o(294216);
    }
    
    public final int getLayoutId()
    {
      return a.e.wmU;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(CouponCardListUI paramCouponCardListUI, MemberCardTopCropImageView paramMemberCardTopCropImageView, vt paramvt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<b.a<cic>, ah>
  {
    e(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements g
  {
    f(CouponCardListUI paramCouponCardListUI) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(293904);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new CouponCardListUI.d(this.wHH);
      AppMethodBeat.o(293904);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RefreshLoadMoreLayout.b
  {
    g(CouponCardListUI paramCouponCardListUI) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(293902);
      kotlin.g.b.s.u(paramd, "reason");
      Log.d(CouponCardListUI.a(this.wHH), kotlin.g.b.s.X("on load more end: ", Integer.valueOf(CouponCardListUI.c(this.wHH))));
      if (CouponCardListUI.d(this.wHH))
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = CouponCardListUI.e(this.wHH);
        paramd = localRefreshLoadMoreLayout;
        if (localRefreshLoadMoreLayout == null)
        {
          kotlin.g.b.s.bIx("mRefreshLayout");
          paramd = null;
        }
        paramd.m(null);
      }
      AppMethodBeat.o(293902);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(293895);
      Log.d(CouponCardListUI.a(this.wHH), "on load more");
      d.uiThread((kotlin.g.a.a)new a(this.wHH));
      AppMethodBeat.o(293895);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(CouponCardListUI paramCouponCardListUI)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */