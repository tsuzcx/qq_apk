package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.t;
import d.l;
import d.v;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "USER_STATE_ACCOUNT_FORBID", "", "getUSER_STATE_ACCOUNT_FORBID", "()I", "USER_STATE_ACCOUNT_REVIEW_ING", "getUSER_STATE_ACCOUNT_REVIEW_ING", "USER_STATE_ACCOUNT_SILIENT", "getUSER_STATE_ACCOUNT_SILIENT", "USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT", "getUSER_STATE_HAS_POST_QUALITY_NO_ACCOUNT", "USER_STATE_NORMAL", "getUSER_STATE_NORMAL", "USER_STATE_NO_POST_QUALITY", "getUSER_STATE_NO_POST_QUALITY", "isReportRedDotExpose", "", "lastFavTipsId", "myFinderUsername", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "accountAbnormal", "", "hasContactContainer", "Landroid/view/View;", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getLayoutId", "getWXMsgCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshSelf", "plugin-finder_release"})
public final class FinderSelfUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.finder.api.e
{
  private final int KZA = 5;
  private final int KZB = 6;
  private String KZC = "";
  private final int KZw = 1;
  private final int KZx = 2;
  private final int KZy = 3;
  private final int KZz = 4;
  private final String TAG = "Finder.FinderSelfUI";
  private HashMap _$_findViewCache;
  private ProgressBar progressBar;
  private alv qBp;
  private String qPG;
  private boolean qPH;
  
  private final void crv()
  {
    AppMethodBeat.i(167591);
    this.qPG = u.aqO();
    ad.i(this.TAG, "myFinderUser " + this.qPG);
    Object localObject1 = findViewById(2131300680);
    Object localObject2 = findViewById(2131302875);
    Object localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject3).afk().getInt(ae.a.LBx, -1);
    if (i != -1)
    {
      ad.d(this.TAG, "harcode user state = ".concat(String.valueOf(i)));
      if (i != this.KZw) {
        break label661;
      }
      d.g.b.k.g(localObject1, "hasContactContainer");
      d.g.b.k.g(localObject2, "noContactContainer");
      d.g.b.k.h(localObject1, "hasContactContainer");
      d.g.b.k.h(localObject2, "noContactContainer");
      ad.d(this.TAG, "账户无发表权限");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setVisibility(8);
    }
    label269:
    label1171:
    for (;;)
    {
      localObject1 = (TextView)_$_findCachedViewById(2131307346);
      d.g.b.k.g(localObject1, "finder_post_new_feed");
      ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = (LinearLayout)_$_findCachedViewById(2131307363);
      d.g.b.k.g(localObject1, "finder_self_account_state");
      ((LinearLayout)localObject1).setVisibility(0);
      AppMethodBeat.o(167591);
      return;
      localObject3 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject3, "MMKernel.storage()");
      boolean bool1;
      boolean bool2;
      if ((((com.tencent.mm.kernel.e)localObject3).afk().getInt(ae.a.Fwn, 0) & 0x2) != 0)
      {
        bool1 = true;
        localObject3 = com.tencent.mm.plugin.finder.storage.b.qJA;
        if ((!com.tencent.mm.plugin.finder.storage.b.cps()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
          break label407;
        }
        bool2 = true;
        label298:
        localObject3 = (CharSequence)this.qPG;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label413;
        }
        i = 1;
        label324:
        if (i != 0) {
          break label418;
        }
      }
      label407:
      label413:
      label418:
      for (boolean bool3 = true;; bool3 = false)
      {
        ad.i(this.TAG, "[checkUserState] hasCreatedIdentity=" + bool3 + ", showPostEntry=" + bool2 + ", isReviewing=" + bool1);
        if (bool2) {
          break label424;
        }
        ad.i(this.TAG, "resultState = USER_STATE_NO_POST_QUALITY");
        i = this.KZw;
        break;
        bool1 = false;
        break label269;
        bool2 = false;
        break label298;
        i = 0;
        break label324;
      }
      label424:
      if (bool3)
      {
        localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
        localObject3 = u.aqO();
        d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
        localObject3 = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject3);
        if (localObject3 == null) {
          d.g.b.k.fvU();
        }
        bool2 = ((f)localObject3).isBlock();
        localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
        localObject3 = u.aqO();
        d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
        localObject3 = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject3);
        if (localObject3 == null) {
          d.g.b.k.fvU();
        }
        if (((f)localObject3).field_spamStatus == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ad.i(this.TAG, "[checkUserState] isAccountBlocked=" + bool2 + ", isAccountSilent=" + bool1);
          if (!bool2) {
            break label579;
          }
          ad.i(this.TAG, "resultState = USER_STATE_ACCOUNT_FORBID");
          i = this.KZz;
          break;
        }
        label579:
        if (bool1)
        {
          ad.i(this.TAG, "resultState = USER_STATE_ACCOUNT_SILIENT");
          i = this.KZB;
          break;
        }
        ad.i(this.TAG, "resultState = USER_STATE_NORMAL");
        i = this.KZy;
        break;
      }
      if (bool1)
      {
        ad.i(this.TAG, "resultState = USER_STATE_ACCOUNT_REVIEW_ING");
        i = this.KZA;
        break;
      }
      ad.i(this.TAG, "resultState = USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
      i = this.KZx;
      break;
      label661:
      if (i == this.KZx)
      {
        d.g.b.k.g(localObject1, "hasContactContainer");
        d.g.b.k.g(localObject2, "noContactContainer");
        d.g.b.k.h(localObject1, "hasContactContainer");
        d.g.b.k.h(localObject2, "noContactContainer");
        ad.d(this.TAG, "有发表权限但未创建账号");
        ((View)localObject2).setVisibility(8);
        ((View)localObject1).setVisibility(0);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131307789);
        d.g.b.k.g(localObject1, "msg_ll");
        ((FrameLayout)localObject1).setVisibility(8);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131307319);
        d.g.b.k.g(localObject1, "finder_account_area");
        ((FrameLayout)localObject1).setVisibility(8);
        findViewById(2131307820).setOnClickListener((View.OnClickListener)new e(this));
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
        com.tencent.mm.plugin.finder.extension.reddot.d.a(com.tencent.mm.plugin.finder.extension.reddot.d.clr(), (LifecycleOwner)this, (Observer)new f(this));
      }
      else
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        if ((i == this.KZy) || (i == this.KZB))
        {
          d.g.b.k.g(localObject1, "hasContactContainer");
          d.g.b.k.g(localObject2, "noContactContainer");
          d.g.b.k.h(localObject1, "hasContactContainer");
          d.g.b.k.h(localObject2, "noContactContainer");
          ad.d(this.TAG, "账户正常");
          ((View)localObject2).setVisibility(8);
          ((View)localObject1).setVisibility(0);
          localObject1 = findViewById(2131307319);
          localObject3 = findViewById(2131307789);
          localObject4 = (ImageView)findViewById(2131299973);
          localObject5 = (TextView)findViewById(2131300016);
          localObject2 = (TextView)findViewById(2131307345);
          localObject6 = com.tencent.mm.plugin.finder.api.b.qnX;
          localObject6 = this.qPG;
          if (localObject6 == null) {
            d.g.b.k.fvU();
          }
          f localf = com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject6);
          localObject6 = (ImageView)findViewById(2131296977);
          label1116:
          int k;
          int m;
          if (localf != null)
          {
            Object localObject7 = com.tencent.mm.plugin.finder.loader.h.qCF;
            localObject7 = com.tencent.mm.plugin.finder.loader.h.cmV();
            com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(localf.cks());
            d.g.b.k.g(localObject4, "finderAvatar");
            com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
            ((com.tencent.mm.loader.d)localObject7).a(locala, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
            d.g.b.k.g(localObject5, "finderNickname");
            ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)localf.Su()));
            ai.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
            localObject4 = localf.field_authInfo;
            if (localObject4 != null)
            {
              i = ((FinderAuthInfo)localObject4).authIconType;
              if (i <= 0) {
                break label1650;
              }
            }
          }
          else
          {
            switch (i)
            {
            default: 
              d.g.b.k.g(localObject6, "authIcon");
              ((ImageView)localObject6).setVisibility(8);
              localObject4 = com.tencent.mm.kernel.g.afB();
              d.g.b.k.g(localObject4, "MMKernel.storage()");
              i = ((com.tencent.mm.kernel.e)localObject4).afk().getInt(ae.a.FwX, 0);
              if (i > 0)
              {
                localObject4 = (TextView)_$_findCachedViewById(2131307331);
                d.g.b.k.g(localObject4, "finder_follow_count");
                ((TextView)localObject4).setVisibility(0);
                localObject4 = (TextView)_$_findCachedViewById(2131307331);
                d.g.b.k.g(localObject4, "finder_follow_count");
                localObject5 = getContext();
                d.g.b.k.g(localObject5, "context");
                ((TextView)localObject4).setText((CharSequence)((AppCompatActivity)localObject5).getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.e.De(i) }));
                d.g.b.k.g(localObject3, "finderMsgArea");
                ((View)localObject3).setVisibility(0);
                localObject4 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
                localObject4 = com.tencent.mm.plugin.finder.extension.reddot.b.a.fSG();
                int j = localObject4[0];
                k = localObject4[1];
                m = j + k;
                ad.i(this.TAG, "redDot check normalCount :" + j + " systemCount " + k);
                ((View)localObject1).setOnClickListener((View.OnClickListener)new FinderSelfUI.o(this));
                ((View)localObject3).setOnClickListener((View.OnClickListener)new FinderSelfUI.p(this, m, j, k));
                if (m <= 0) {
                  break label1786;
                }
                d.g.b.k.g(localObject2, "finderMsg");
                ((TextView)localObject2).setVisibility(0);
                if (m <= 999) {
                  break label1698;
                }
                localObject1 = (CharSequence)"999+";
                label1435:
                ((TextView)localObject2).setText((CharSequence)localObject1);
                if (!this.qPH)
                {
                  this.qPH = true;
                  localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
                  if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
                    break label1711;
                  }
                  i = 0;
                  label1467:
                  if (j <= 0) {
                    break label1722;
                  }
                  localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
                  localObject1 = FinderReporterUIC.Ljl;
                  localObject1 = FinderReporterUIC.a.lB((Context)this);
                  if (localObject1 == null) {
                    break label1716;
                  }
                  localObject1 = ((FinderReporterUIC)localObject1).fXs();
                  label1502:
                  com.tencent.mm.plugin.finder.report.b.a("4", 1, 1, 5, i, j, null, null, 0L, (dzp)localObject1, 0, 1472);
                }
              }
              break;
            }
          }
          for (;;)
          {
            ad.i(this.TAG, "show finder msg red, totalCount:".concat(String.valueOf(m)));
            break;
            i = 0;
            break label1116;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageDrawable(am.i((Context)this, 2131690481, com.tencent.mm.cd.a.n((Context)this, 2131100725)));
            break label1171;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageDrawable(am.i((Context)this, 2131690481, com.tencent.mm.cd.a.n((Context)this, 2131099748)));
            break label1171;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(8);
            break label1171;
            label1650:
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(8);
            break label1171;
            localObject4 = (TextView)_$_findCachedViewById(2131307331);
            d.g.b.k.g(localObject4, "finder_follow_count");
            ((TextView)localObject4).setVisibility(8);
            break label1291;
            label1698:
            localObject1 = (CharSequence)String.valueOf(m);
            break label1435;
            label1711:
            i = 2;
            break label1467;
            label1716:
            localObject1 = null;
            break label1502;
            label1722:
            if (k > 0)
            {
              localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
              localObject1 = FinderReporterUIC.Ljl;
              localObject1 = FinderReporterUIC.a.lB((Context)this);
              if (localObject1 != null) {}
              for (localObject1 = ((FinderReporterUIC)localObject1).fXs();; localObject1 = null)
              {
                com.tencent.mm.plugin.finder.report.b.a("4", 4, 1, 5, i, k, null, null, 0L, (dzp)localObject1, 0, 1472);
                break;
              }
              label1786:
              d.g.b.k.g(localObject2, "finderMsg");
              ((TextView)localObject2).setVisibility(8);
            }
          }
        }
        if (i == this.KZz)
        {
          d.g.b.k.g(localObject1, "hasContactContainer");
          d.g.b.k.g(localObject2, "noContactContainer");
          d.g.b.k.h(localObject1, "hasContactContainer");
          d.g.b.k.h(localObject2, "noContactContainer");
          ad.d(this.TAG, "账户封禁");
          ((View)localObject2).setVisibility(8);
          ((View)localObject1).setVisibility(0);
          localObject1 = (FrameLayout)_$_findCachedViewById(2131307789);
          d.g.b.k.g(localObject1, "msg_ll");
          ((FrameLayout)localObject1).setVisibility(8);
          localObject1 = (FrameLayout)_$_findCachedViewById(2131307820);
          d.g.b.k.g(localObject1, "postBtn");
          ((FrameLayout)localObject1).setVisibility(8);
          localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject1 = com.tencent.mm.plugin.finder.loader.h.cmV();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a("");
          localObject3 = (ImageView)_$_findCachedViewById(2131299973);
          d.g.b.k.g(localObject3, "finder_avatar_iv");
          localObject4 = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
          localObject1 = (TextView)_$_findCachedViewById(2131300016);
          d.g.b.k.g(localObject1, "finder_nick_tv");
          ((TextView)localObject1).setText((CharSequence)getResources().getString(2131762538));
          localObject1 = (TextView)_$_findCachedViewById(2131300067);
          d.g.b.k.g(localObject1, "finder_self_msg_tv");
          ((TextView)localObject1).setVisibility(0);
          ((FrameLayout)_$_findCachedViewById(2131307319)).setOnClickListener((View.OnClickListener)new d(this));
        }
        else
        {
          if (i == this.KZA)
          {
            d.g.b.k.g(localObject1, "hasContactContainer");
            d.g.b.k.g(localObject2, "noContactContainer");
            d.g.b.k.h(localObject1, "hasContactContainer");
            d.g.b.k.h(localObject2, "noContactContainer");
            ad.d(this.TAG, "账户审核中");
            ((View)localObject2).setVisibility(8);
            ((View)localObject1).setVisibility(0);
            localObject5 = (ImageView)findViewById(2131299973);
            localObject3 = (TextView)findViewById(2131300016);
            localObject4 = (TextView)findViewById(2131300073);
            localObject1 = (FrameLayout)_$_findCachedViewById(2131307789);
            d.g.b.k.g(localObject1, "msg_ll");
            ((FrameLayout)localObject1).setVisibility(8);
            localObject1 = (FrameLayout)_$_findCachedViewById(2131307820);
            d.g.b.k.g(localObject1, "postBtn");
            ((FrameLayout)localObject1).setVisibility(8);
            localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
            localObject6 = com.tencent.mm.plugin.finder.loader.h.cmV();
            localObject1 = this.qBp;
            if (localObject1 != null)
            {
              localObject1 = ((alv)localObject1).verifyInfo;
              if (localObject1 != null)
              {
                localObject2 = ((akb)localObject1).itN;
                localObject1 = localObject2;
                if (localObject2 != null) {
                  break label2279;
                }
              }
            }
            localObject1 = "";
            label2279:
            localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
            d.g.b.k.g(localObject5, "finderAvatar");
            localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
            ((com.tencent.mm.loader.d)localObject6).a(localObject1, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
            d.g.b.k.g(localObject3, "finderNickname");
            localObject2 = (Context)this;
            localObject1 = this.qBp;
            if (localObject1 != null)
            {
              localObject1 = ((alv)localObject1).verifyInfo;
              if (localObject1 == null) {}
            }
            for (localObject1 = ((akb)localObject1).DlS;; localObject1 = null)
            {
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1));
              ai.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
              d.g.b.k.g(localObject4, "finderState");
              ((TextView)localObject4).setVisibility(0);
              ((TextView)localObject4).setText((CharSequence)getResources().getString(2131759342));
              localObject1 = findViewById(2131307789);
              d.g.b.k.g(localObject1, "findViewById<View>(R.id.msg_ll)");
              ((View)localObject1).setVisibility(8);
              ((FrameLayout)_$_findCachedViewById(2131307319)).setOnClickListener((View.OnClickListener)new FinderSelfUI.g(this));
              break;
            }
          }
          ad.d(this.TAG, "not one of six state");
        }
      }
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199387);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(199387);
    return localView1;
  }
  
  public final void a(ahv paramahv)
  {
    AppMethodBeat.i(167593);
    d.g.b.k.h(paramahv, "cmdItem");
    ad.i(this.TAG, "cmdId " + paramahv.cmdId);
    switch (paramahv.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(167593);
      return;
      crv();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494106;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167590);
    findViewById(2131301238).setOnClickListener((View.OnClickListener)new a(this));
    findViewById(2131301239).setOnClickListener((View.OnClickListener)new b(this));
    findViewById(2131307408).setOnClickListener((View.OnClickListener)new FinderSelfUI.k(this));
    Object localObject = findViewById(2131301509);
    d.g.b.k.g(localObject, "findViewById(R.id.loading_progress_bar)");
    this.progressBar = ((ProgressBar)localObject);
    findViewById(2131307820).setOnClickListener((View.OnClickListener)new FinderSelfUI.l(this));
    findViewById(2131307409).setOnClickListener((View.OnClickListener)new FinderSelfUI.m(this));
    localObject = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
    localObject = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
    com.tencent.mm.plugin.finder.extension.reddot.d.a(com.tencent.mm.plugin.finder.extension.reddot.d.fSO(), (LifecycleOwner)this, (Observer)new FinderSelfUI.n(this));
    AppMethodBeat.o(167590);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167589);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderSelfUI.c(this));
    initView();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.kernel.g.aeS().a(3761, (com.tencent.mm.al.g)this);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    paramBundle = ((PluginFinder)paramBundle).getRedDotManager().YV("TLCamera");
    Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().YW("TLCamera");
    i locali = i.qTa;
    int i;
    if ((paramBundle != null) && (localObject != null))
    {
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
        break label204;
      }
      i = 0;
      paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
      paramBundle = FinderReporterUIC.Ljl;
      paramBundle = FinderReporterUIC.a.lB((Context)this);
      if (paramBundle == null) {
        break label209;
      }
    }
    label204:
    label209:
    for (paramBundle = paramBundle.fXs();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.b.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 1472);
      AppMethodBeat.o(167589);
      return;
      i = 1;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167595);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.e)this);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.LBn, 0);
    localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    if (i + ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.LBo, 0) <= 0)
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().ahg(2);
    }
    AppMethodBeat.o(167595);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167592);
    super.onResume();
    Object localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
      AppMethodBeat.o(167592);
      throw ((Throwable)localObject);
    }
    ((com.tencent.mm.plugin.finder.extension.a)localObject).fu(4137, 1);
    this.qPG = u.aqO();
    if (this.qBp != null)
    {
      crv();
      AppMethodBeat.o(167592);
      return;
    }
    if (bt.isNullOrNil(this.qPG))
    {
      localObject = this.progressBar;
      if (localObject == null) {
        d.g.b.k.aPZ("progressBar");
      }
      ((ProgressBar)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = new y(1);
      com.tencent.mm.kernel.g.aeS().b((n)localObject);
      AppMethodBeat.o(167592);
      return;
      crv();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167594);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.progressBar;
    if (paramString == null) {
      d.g.b.k.aPZ("progressBar");
    }
    paramString.setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167594);
        throw paramString;
      }
      this.qBp = ((y)paramn).ckV();
      crv();
      AppMethodBeat.o(167594);
      return;
    }
    t.makeText((Context)this, 2131759307, 1).show();
    AppMethodBeat.o(167594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167583);
      paramView = new Intent();
      FinderReporterUIC.a locala = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this.qPI, paramView, 0L, 0, false, 124);
      FinderSelfUI.a(this.qPI, FinderFollowListUI.class, paramView);
      AppMethodBeat.o(167583);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167584);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this.qPI, paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.qPI, FinderLikedFeedUI.class);
      paramView.putExtra("finder_username", u.aqO());
      localObject = this.qPI;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((FinderSelfUI)localObject).startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167584);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199370);
      this.qPI.getIntent().putExtra("finder_username", FinderSelfUI.b(this.qPI));
      this.qPI.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
      paramView = FinderReporterUIC.Ljl;
      paramView = (Context)this.qPI;
      Intent localIntent = this.qPI.getIntent();
      d.g.b.k.g(localIntent, "intent");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.qPI, this.qPI.getIntent());
      AppMethodBeat.o(199370);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199371);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      paramView = ((PluginFinder)paramView).getRedDotManager().YV("TLCamera");
      Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().YW("TLCamera");
      i locali = i.qTa;
      int i;
      if ((paramView != null) && (localObject != null))
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
          break label231;
        }
        i = 0;
        paramView = com.tencent.mm.plugin.finder.report.b.qFq;
        paramView = FinderReporterUIC.Ljl;
        paramView = FinderReporterUIC.a.lB((Context)this.qPI);
        if (paramView == null) {
          break label236;
        }
      }
      label231:
      label236:
      for (paramView = paramView.fXs();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.b.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 1472);
        paramView = com.tencent.mm.kernel.g.ad(j.class);
        d.g.b.k.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((j)paramView).getRedDotManager().YU("TLCamera");
        paramView = i.qTa;
        if (i.al((Activity)this.qPI))
        {
          paramView = new Intent();
          paramView.putExtra("scene", 2);
          localObject = FinderSelfUI.a(this.qPI);
          if (localObject != null) {
            paramView.putExtra("key_prepare_resp", ((alv)localObject).toByteArray());
          }
          localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
          com.tencent.mm.plugin.finder.utils.a.u((Context)this.qPI, paramView);
        }
        AppMethodBeat.o(199371);
        return;
        i = 1;
        break;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class f<T>
    implements Observer<d.a>
  {
    f(FinderSelfUI paramFinderSelfUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */