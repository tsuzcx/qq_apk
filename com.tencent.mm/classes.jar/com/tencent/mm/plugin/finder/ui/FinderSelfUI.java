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
import android.view.MenuItem;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.extension.reddot.c.a;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.v;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "USER_STATE_ACCOUNT_FORBID", "", "getUSER_STATE_ACCOUNT_FORBID", "()I", "USER_STATE_ACCOUNT_REVIEW_ING", "getUSER_STATE_ACCOUNT_REVIEW_ING", "USER_STATE_ACCOUNT_SILIENT", "getUSER_STATE_ACCOUNT_SILIENT", "USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT", "getUSER_STATE_HAS_POST_QUALITY_NO_ACCOUNT", "USER_STATE_NORMAL", "getUSER_STATE_NORMAL", "USER_STATE_NO_POST_QUALITY", "getUSER_STATE_NO_POST_QUALITY", "isReportRedDotExpose", "", "lastFavTipsId", "myFinderUsername", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "accountAbnormal", "", "hasContactContainer", "Landroid/view/View;", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getLayoutId", "getWXMsgCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshSelf", "plugin-finder_release"})
public final class FinderSelfUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.finder.api.e
{
  private final String TAG = "Finder.FinderSelfUI";
  private HashMap _$_findViewCache;
  private ProgressBar progressBar;
  private String rLk;
  private boolean rLl;
  private final int rLm = 1;
  private final int rLn = 2;
  private final int rLo = 3;
  private final int rLp = 4;
  private final int rLq = 5;
  private final int rLr = 6;
  private String rLs = "";
  private aoy rsp;
  
  private final void cCk()
  {
    AppMethodBeat.i(167591);
    this.rLk = u.axE();
    ac.i(this.TAG, "myFinderUser " + this.rLk);
    Object localObject1 = findViewById(2131300680);
    Object localObject2 = findViewById(2131302875);
    Object localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject3).agA().getInt(ah.a.GVV, -1);
    if (i != -1)
    {
      ac.d(this.TAG, "harcode user state = ".concat(String.valueOf(i)));
      if (i != this.rLm) {
        break label659;
      }
      d.g.b.k.g(localObject1, "hasContactContainer");
      d.g.b.k.g(localObject2, "noContactContainer");
      d.g.b.k.h(localObject1, "hasContactContainer");
      d.g.b.k.h(localObject2, "noContactContainer");
      ac.d(this.TAG, "账户无发表权限");
      ((View)localObject2).setVisibility(0);
      ((View)localObject1).setVisibility(8);
    }
    label1548:
    for (;;)
    {
      localObject1 = (TextView)_$_findCachedViewById(2131307415);
      d.g.b.k.g(localObject1, "finder_post_new_feed");
      aj.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = (LinearLayout)_$_findCachedViewById(2131307432);
      d.g.b.k.g(localObject1, "finder_self_account_state");
      ((LinearLayout)localObject1).setVisibility(0);
      AppMethodBeat.o(167591);
      return;
      localObject3 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject3, "MMKernel.storage()");
      boolean bool1;
      label269:
      boolean bool2;
      if ((((com.tencent.mm.kernel.e)localObject3).agA().getInt(ah.a.GUi, 0) & 0x2) != 0)
      {
        bool1 = true;
        localObject3 = com.tencent.mm.plugin.finder.storage.b.rCU;
        if ((!com.tencent.mm.plugin.finder.storage.b.cyP()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
          break label407;
        }
        bool2 = true;
        label298:
        localObject3 = (CharSequence)this.rLk;
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
        ac.i(this.TAG, "[checkUserState] hasCreatedIdentity=" + bool3 + ", showPostEntry=" + bool2 + ", isReviewing=" + bool1);
        if (bool2) {
          break label424;
        }
        ac.i(this.TAG, "resultState = USER_STATE_NO_POST_QUALITY");
        i = this.rLm;
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
        localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
        localObject3 = u.axE();
        d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
        localObject3 = b.a.adh((String)localObject3);
        if (localObject3 == null) {
          d.g.b.k.fOy();
        }
        bool2 = ((com.tencent.mm.plugin.finder.api.f)localObject3).isBlock();
        localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
        localObject3 = u.axE();
        d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
        localObject3 = b.a.adh((String)localObject3);
        if (localObject3 == null) {
          d.g.b.k.fOy();
        }
        if (((com.tencent.mm.plugin.finder.api.f)localObject3).field_spamStatus == 2) {}
        for (bool1 = true;; bool1 = false)
        {
          ac.i(this.TAG, "[checkUserState] isAccountBlocked=" + bool2 + ", isAccountSilent=" + bool1);
          if (!bool2) {
            break label577;
          }
          ac.i(this.TAG, "resultState = USER_STATE_ACCOUNT_FORBID");
          i = this.rLp;
          break;
        }
        label577:
        if (bool1)
        {
          ac.i(this.TAG, "resultState = USER_STATE_ACCOUNT_SILIENT");
          i = this.rLr;
          break;
        }
        ac.i(this.TAG, "resultState = USER_STATE_NORMAL");
        i = this.rLo;
        break;
      }
      if (bool1)
      {
        ac.i(this.TAG, "resultState = USER_STATE_ACCOUNT_REVIEW_ING");
        i = this.rLq;
        break;
      }
      ac.i(this.TAG, "resultState = USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
      i = this.rLn;
      break;
      label659:
      if (i == this.rLn)
      {
        d.g.b.k.g(localObject1, "hasContactContainer");
        d.g.b.k.g(localObject2, "noContactContainer");
        d.g.b.k.h(localObject1, "hasContactContainer");
        d.g.b.k.h(localObject2, "noContactContainer");
        ac.d(this.TAG, "有发表权限但未创建账号");
        ((View)localObject2).setVisibility(8);
        ((View)localObject1).setVisibility(0);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
        d.g.b.k.g(localObject1, "msg_ll");
        ((FrameLayout)localObject1).setVisibility(8);
        localObject1 = (FrameLayout)_$_findCachedViewById(2131307388);
        d.g.b.k.g(localObject1, "finder_account_area");
        ((FrameLayout)localObject1).setVisibility(8);
        findViewById(2131307912).setOnClickListener((View.OnClickListener)new b(this));
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
        com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctN(), (LifecycleOwner)this, (Observer)new c(this));
      }
      else
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        if ((i == this.rLo) || (i == this.rLr))
        {
          d.g.b.k.g(localObject1, "hasContactContainer");
          d.g.b.k.g(localObject2, "noContactContainer");
          d.g.b.k.h(localObject1, "hasContactContainer");
          d.g.b.k.h(localObject2, "noContactContainer");
          ac.d(this.TAG, "账户正常");
          localObject3 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
          d.g.b.k.g(localObject3, "MMKernel.plugin(IPluginFinder::class.java)");
          ((com.tencent.mm.plugin.i.a.l)localObject3).getRedDotManager().adv("TLCamera");
          ((View)localObject2).setVisibility(8);
          ((View)localObject1).setVisibility(0);
          localObject1 = findViewById(2131307388);
          localObject3 = findViewById(2131307876);
          localObject4 = (ImageView)findViewById(2131299973);
          localObject5 = (TextView)findViewById(2131300016);
          localObject2 = (TextView)findViewById(2131307414);
          localObject6 = com.tencent.mm.plugin.finder.api.b.qWt;
          localObject6 = this.rLk;
          if (localObject6 == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.finder.api.f localf = b.a.adh((String)localObject6);
          localObject6 = (ImageView)findViewById(2131296977);
          label1148:
          final int k;
          label1203:
          final int m;
          if (localf != null)
          {
            Object localObject7 = h.rtK;
            localObject7 = h.cwo();
            com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(localf.crZ());
            d.g.b.k.g(localObject4, "finderAvatar");
            h localh = h.rtK;
            ((com.tencent.mm.loader.d)localObject7).a(locala, (ImageView)localObject4, h.a(h.a.rtN));
            d.g.b.k.g(localObject5, "finderNickname");
            ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)localf.Tn()));
            aj.a((Paint)((TextView)localObject5).getPaint(), 0.8F);
            localObject4 = localf.field_authInfo;
            if (localObject4 != null)
            {
              i = ((FinderAuthInfo)localObject4).authIconType;
              if (i <= 0) {
                break label1718;
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
              localObject4 = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(localObject4, "MMKernel.storage()");
              i = ((com.tencent.mm.kernel.e)localObject4).agA().getInt(ah.a.GVn, 0);
              if (i > 0)
              {
                localObject4 = (TextView)_$_findCachedViewById(2131307400);
                d.g.b.k.g(localObject4, "finder_follow_count");
                ((TextView)localObject4).setVisibility(0);
                localObject4 = (TextView)_$_findCachedViewById(2131307400);
                d.g.b.k.g(localObject4, "finder_follow_count");
                localObject5 = getContext();
                d.g.b.k.g(localObject5, "context");
                ((TextView)localObject4).setText((CharSequence)((AppCompatActivity)localObject5).getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.g.Ew(i) }));
                label1323:
                d.g.b.k.g(localObject1, "finderAccountArea");
                ((View)localObject1).setVisibility(0);
                d.g.b.k.g(localObject3, "finderMsgArea");
                ((View)localObject3).setVisibility(0);
                localObject4 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
                localObject4 = c.a.ctD();
                final int j = localObject4[0];
                k = localObject4[1];
                m = j + k;
                ac.i(this.TAG, "redDot check normalCount :" + j + " systemCount " + k);
                ((View)localObject1).setOnClickListener((View.OnClickListener)new n(this));
                ((View)localObject3).setOnClickListener((View.OnClickListener)new o(this, m, j, k));
                if (m <= 0) {
                  break label1855;
                }
                d.g.b.k.g(localObject2, "finderMsg");
                ((TextView)localObject2).setVisibility(0);
                if (m <= 999) {
                  break label1766;
                }
                localObject1 = (CharSequence)"999+";
                label1481:
                ((TextView)localObject2).setText((CharSequence)localObject1);
                if (!this.rLl)
                {
                  this.rLl = true;
                  localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
                  if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
                    break label1779;
                  }
                  i = 0;
                  label1513:
                  if (j <= 0) {
                    break label1790;
                  }
                  localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
                  localObject1 = FinderReporterUIC.seQ;
                  localObject1 = FinderReporterUIC.a.eV((Context)this);
                  if (localObject1 == null) {
                    break label1784;
                  }
                  localObject1 = ((FinderReporterUIC)localObject1).cGb();
                  com.tencent.mm.plugin.finder.report.d.a("4", 1, 1, 5, i, j, null, null, 0L, (anm)localObject1, 0, 0, 3520);
                }
              }
              break;
            }
          }
          label1718:
          label1855:
          for (;;)
          {
            findViewById(2131307912).setOnClickListener((View.OnClickListener)new FinderSelfUI.q(this));
            ac.i(this.TAG, "show finder msg red, totalCount:".concat(String.valueOf(m)));
            break;
            i = 0;
            break label1148;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageDrawable(am.k((Context)this, 2131690481, com.tencent.mm.cc.a.n((Context)this, 2131100725)));
            break label1203;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageDrawable(am.k((Context)this, 2131690481, com.tencent.mm.cc.a.n((Context)this, 2131099748)));
            break label1203;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(8);
            break label1203;
            d.g.b.k.g(localObject6, "authIcon");
            ((ImageView)localObject6).setVisibility(8);
            break label1203;
            localObject4 = (TextView)_$_findCachedViewById(2131307400);
            d.g.b.k.g(localObject4, "finder_follow_count");
            ((TextView)localObject4).setVisibility(8);
            break label1323;
            label1766:
            localObject1 = (CharSequence)String.valueOf(m);
            break label1481;
            label1779:
            i = 2;
            break label1513;
            label1784:
            localObject1 = null;
            break label1548;
            label1790:
            if (k > 0)
            {
              localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
              localObject1 = FinderReporterUIC.seQ;
              localObject1 = FinderReporterUIC.a.eV((Context)this);
              if (localObject1 != null) {}
              for (localObject1 = ((FinderReporterUIC)localObject1).cGb();; localObject1 = null)
              {
                com.tencent.mm.plugin.finder.report.d.a("4", 4, 1, 5, i, k, null, null, 0L, (anm)localObject1, 0, 0, 3520);
                break;
              }
              d.g.b.k.g(localObject2, "finderMsg");
              ((TextView)localObject2).setVisibility(8);
            }
          }
        }
        if (i == this.rLp)
        {
          d.g.b.k.g(localObject1, "hasContactContainer");
          d.g.b.k.g(localObject2, "noContactContainer");
          d.g.b.k.h(localObject1, "hasContactContainer");
          d.g.b.k.h(localObject2, "noContactContainer");
          ac.d(this.TAG, "账户封禁");
          ((View)localObject2).setVisibility(8);
          ((View)localObject1).setVisibility(0);
          localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
          d.g.b.k.g(localObject1, "msg_ll");
          ((FrameLayout)localObject1).setVisibility(8);
          localObject1 = (FrameLayout)_$_findCachedViewById(2131307912);
          d.g.b.k.g(localObject1, "postBtn");
          ((FrameLayout)localObject1).setVisibility(8);
          localObject1 = h.rtK;
          localObject1 = h.cwo();
          localObject2 = new com.tencent.mm.plugin.finder.loader.a("");
          localObject3 = (ImageView)_$_findCachedViewById(2131299973);
          d.g.b.k.g(localObject3, "finder_avatar_iv");
          localObject4 = h.rtK;
          ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, h.a(h.a.rtN));
          localObject1 = (TextView)_$_findCachedViewById(2131300016);
          d.g.b.k.g(localObject1, "finder_nick_tv");
          ((TextView)localObject1).setText((CharSequence)getResources().getString(2131764440));
          localObject1 = (TextView)_$_findCachedViewById(2131300067);
          d.g.b.k.g(localObject1, "finder_self_msg_tv");
          ((TextView)localObject1).setVisibility(0);
          ((FrameLayout)_$_findCachedViewById(2131307388)).setOnClickListener((View.OnClickListener)new a(this));
        }
        else
        {
          if (i == this.rLq)
          {
            d.g.b.k.g(localObject1, "hasContactContainer");
            d.g.b.k.g(localObject2, "noContactContainer");
            d.g.b.k.h(localObject1, "hasContactContainer");
            d.g.b.k.h(localObject2, "noContactContainer");
            ac.d(this.TAG, "账户审核中");
            ((View)localObject2).setVisibility(8);
            ((View)localObject1).setVisibility(0);
            localObject5 = (ImageView)findViewById(2131299973);
            localObject3 = (TextView)findViewById(2131300016);
            localObject4 = (TextView)findViewById(2131300073);
            localObject1 = (FrameLayout)_$_findCachedViewById(2131307876);
            d.g.b.k.g(localObject1, "msg_ll");
            ((FrameLayout)localObject1).setVisibility(8);
            localObject1 = (FrameLayout)_$_findCachedViewById(2131307912);
            d.g.b.k.g(localObject1, "postBtn");
            ((FrameLayout)localObject1).setVisibility(8);
            localObject1 = h.rtK;
            localObject6 = h.cwo();
            localObject1 = this.rsp;
            if (localObject1 != null)
            {
              localObject1 = ((aoy)localObject1).verifyInfo;
              if (localObject1 != null)
              {
                localObject2 = ((amm)localObject1).iTS;
                localObject1 = localObject2;
                if (localObject2 != null) {
                  break label2348;
                }
              }
            }
            localObject1 = "";
            label2348:
            localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
            d.g.b.k.g(localObject5, "finderAvatar");
            localObject2 = h.rtK;
            ((com.tencent.mm.loader.d)localObject6).a(localObject1, (ImageView)localObject5, h.a(h.a.rtN));
            d.g.b.k.g(localObject3, "finderNickname");
            localObject2 = (Context)this;
            localObject1 = this.rsp;
            if (localObject1 != null)
            {
              localObject1 = ((aoy)localObject1).verifyInfo;
              if (localObject1 == null) {}
            }
            for (localObject1 = ((amm)localObject1).EFK;; localObject1 = null)
            {
              ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)localObject1));
              aj.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
              d.g.b.k.g(localObject4, "finderState");
              ((TextView)localObject4).setVisibility(0);
              ((TextView)localObject4).setText((CharSequence)getResources().getString(2131759342));
              localObject1 = findViewById(2131307876);
              d.g.b.k.g(localObject1, "findViewById<View>(R.id.msg_ll)");
              ((View)localObject1).setVisibility(8);
              ((FrameLayout)_$_findCachedViewById(2131307388)).setOnClickListener((View.OnClickListener)new d(this));
              break;
            }
          }
          ac.d(this.TAG, "not one of six state");
        }
      }
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203360);
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
    AppMethodBeat.o(203360);
    return localView1;
  }
  
  public final void a(aiy paramaiy)
  {
    AppMethodBeat.i(167593);
    d.g.b.k.h(paramaiy, "cmdItem");
    ac.i(this.TAG, "cmdId " + paramaiy.cmdId);
    switch (paramaiy.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(167593);
      return;
      cCk();
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494106;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167590);
    findViewById(2131301238).setOnClickListener((View.OnClickListener)new h(this));
    findViewById(2131301239).setOnClickListener((View.OnClickListener)new i(this));
    findViewById(2131307484).setOnClickListener((View.OnClickListener)new j(this));
    Object localObject = findViewById(2131301509);
    d.g.b.k.g(localObject, "findViewById(R.id.loading_progress_bar)");
    this.progressBar = ((ProgressBar)localObject);
    findViewById(2131307912).setOnClickListener((View.OnClickListener)new k(this));
    findViewById(2131307485).setOnClickListener((View.OnClickListener)new l(this));
    localObject = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
    localObject = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
    com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctS(), (LifecycleOwner)this, (Observer)new m(this));
    AppMethodBeat.o(167590);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167589);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new p(this));
    initView();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.kernel.g.agi().a(3761, (com.tencent.mm.ak.g)this);
    paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
    paramBundle = ((PluginFinder)paramBundle).getRedDotManager().adw("TLCamera");
    Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().adx("TLCamera");
    com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
    int i;
    if ((paramBundle != null) && (localObject != null))
    {
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
        break label205;
      }
      i = 0;
      paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
      paramBundle = FinderReporterUIC.seQ;
      paramBundle = FinderReporterUIC.a.eV((Context)this);
      if (paramBundle == null) {
        break label210;
      }
    }
    label205:
    label210:
    for (paramBundle = paramBundle.cGb();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.d.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 0, 3520);
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
    com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.e)this);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GVL, 0);
    localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    if (i + ((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GVM, 0) <= 0)
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().Dy(2);
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
    ((com.tencent.mm.plugin.finder.extension.a)localObject).fx(12329, 1);
    this.rLk = u.axE();
    if (this.rsp != null)
    {
      cCk();
      AppMethodBeat.o(167592);
      return;
    }
    if (bs.isNullOrNil(this.rLk))
    {
      localObject = this.progressBar;
      if (localObject == null) {
        d.g.b.k.aVY("progressBar");
      }
      ((ProgressBar)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = new aq(1);
      com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)localObject);
      AppMethodBeat.o(167592);
      return;
      cCk();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(167594);
    ac.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.progressBar;
    if (paramString == null) {
      d.g.b.k.aVY("progressBar");
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
      this.rsp = ((aq)paramn).csO();
      cCk();
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203343);
      this.rLt.getIntent().putExtra("finder_username", FinderSelfUI.e(this.rLt));
      this.rLt.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
      paramView = FinderReporterUIC.seQ;
      paramView = (Context)this.rLt;
      Intent localIntent = this.rLt.getIntent();
      d.g.b.k.g(localIntent, "intent");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.rLt, this.rLt.getIntent());
      AppMethodBeat.o(203343);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203344);
      paramView = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.ae(3, false);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      paramView = ((PluginFinder)paramView).getRedDotManager().adw("TLCamera");
      Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().adx("TLCamera");
      com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      int i;
      if ((paramView != null) && (localObject != null))
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
          break label241;
        }
        i = 0;
        paramView = com.tencent.mm.plugin.finder.report.d.rxr;
        paramView = FinderReporterUIC.seQ;
        paramView = FinderReporterUIC.a.eV((Context)this.rLt);
        if (paramView == null) {
          break label246;
        }
      }
      label241:
      label246:
      for (paramView = paramView.cGb();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.d.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 0, 3520);
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        d.g.b.k.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.l)paramView).getRedDotManager().adv("TLCamera");
        paramView = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (com.tencent.mm.plugin.finder.utils.n.ap((Activity)this.rLt))
        {
          paramView = new Intent();
          paramView.putExtra("scene", 2);
          localObject = FinderSelfUI.d(this.rLt);
          if (localObject != null) {
            paramView.putExtra("key_prepare_resp", ((aoy)localObject).toByteArray());
          }
          localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.u((Context)this.rLt, paramView);
        }
        AppMethodBeat.o(203344);
        return;
        i = 1;
        break;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class c<T>
    implements Observer<f.a>
  {
    c(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203346);
      paramView = FinderSelfUI.d(this.rLt);
      if (paramView != null)
      {
        com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (com.tencent.mm.plugin.finder.utils.n.ap((Activity)this.rLt)) {
          FinderSelfUI.a(this.rLt, paramView);
        }
        AppMethodBeat.o(203346);
        return;
      }
      AppMethodBeat.o(203346);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.d
  {
    f(FinderSelfUI paramFinderSelfUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(203349);
      Intent localIntent = new Intent();
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", this.rrK);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.v((Context)this.rLt, localIntent);
        AppMethodBeat.o(203349);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g rLv;
    
    static
    {
      AppMethodBeat.i(203351);
      rLv = new g();
      AppMethodBeat.o(203351);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(203350);
      com.tencent.mm.plugin.finder.report.c localc = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.DS(6);
      AppMethodBeat.o(203350);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167583);
      paramView = new Intent();
      FinderReporterUIC.a locala = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.rLt, paramView, 0L, 0, false, 124);
      FinderSelfUI.a(this.rLt, FinderFollowListUI.class, paramView);
      AppMethodBeat.o(167583);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167584);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.rLt, paramView, 0L, 0, false, 124);
      paramView.setClass((Context)this.rLt, FinderLikedFeedUI.class);
      paramView.putExtra("finder_username", u.axE());
      localObject = this.rLt;
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((FinderSelfUI)localObject).startActivity((Intent)paramView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$initView$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167584);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203352);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      paramView = ((PluginFinder)paramView).getRedDotManager().adw("FinderFirstFav");
      Object localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)localObject).getRedDotManager().adx("FinderFirstFav");
      com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      if ((paramView != null) && (localObject != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.d.rxr;
        paramView = FinderReporterUIC.seQ;
        paramView = FinderReporterUIC.a.eV((Context)this.rLt);
        if (paramView == null) {
          break label203;
        }
      }
      label203:
      for (paramView = paramView.cGb();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.d.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 0, 3520);
        paramView = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        d.g.b.k.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.l)paramView).getRedDotManager().adv("FinderFirstFav");
        paramView = new Intent();
        localObject = FinderReporterUIC.seQ;
        FinderReporterUIC.a.a((Context)this.rLt, paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject = this.rLt.getContext();
        d.g.b.k.g(localObject, "context");
        com.tencent.mm.plugin.finder.utils.a.K((Context)localObject, paramView);
        AppMethodBeat.o(203352);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203353);
      FinderSelfUI.a(this.rLt);
      AppMethodBeat.o(203353);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203354);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.eQ((Context)this.rLt);
      AppMethodBeat.o(203354);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<f.a>
  {
    m(FinderSelfUI paramFinderSelfUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderSelfUI paramFinderSelfUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203356);
      paramView = new Intent();
      Object localObject = com.tencent.mm.plugin.finder.api.b.qWt;
      localObject = u.axE();
      d.g.b.k.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      localObject = b.a.adh((String)localObject);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (((com.tencent.mm.plugin.finder.api.f)localObject).isBlock())
      {
        paramView.setClass((Context)this.rLt.getContext(), FinderExposeUI.class);
        localObject = this.rLt;
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((FinderSelfUI)localObject).startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(203356);
        return;
      }
      paramView.putExtra("finder_username", FinderSelfUI.e(this.rLt));
      paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
      localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.rLt, paramView, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.rLt, paramView);
      AppMethodBeat.o(203356);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderSelfUI paramFinderSelfUI, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203357);
      int i;
      if (m > 0)
      {
        paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.czT()) {
          break label247;
        }
        i = 0;
        if (j <= 0) {
          break label257;
        }
        paramView = com.tencent.mm.plugin.finder.report.d.rxr;
        j = j;
        paramView = FinderReporterUIC.seQ;
        paramView = FinderReporterUIC.a.eV((Context)this.rLt);
        if (paramView == null) {
          break label252;
        }
        paramView = paramView.cGb();
        com.tencent.mm.plugin.finder.report.d.a("4", 1, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
      }
      label247:
      label252:
      while (k <= 0) {
        for (;;)
        {
          paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
          d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)paramView).getRedDotManager().adv("ProfileEntrance");
          paramView = new Intent();
          localObject = com.tencent.mm.plugin.finder.api.b.qWt;
          localObject = u.axE();
          d.g.b.k.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
          localObject = b.a.adh((String)localObject);
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          if (!((com.tencent.mm.plugin.finder.api.f)localObject).isBlock()) {
            break label324;
          }
          paramView.setClass((Context)this.rLt.getContext(), FinderExposeUI.class);
          localObject = this.rLt;
          paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((FinderSelfUI)localObject).startActivity((Intent)paramView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/ui/FinderSelfUI$normalOrAbNomalUi$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(203357);
          return;
          i = 2;
          break;
          paramView = null;
        }
      }
      label257:
      paramView = com.tencent.mm.plugin.finder.report.d.rxr;
      int j = k;
      paramView = FinderReporterUIC.seQ;
      paramView = FinderReporterUIC.a.eV((Context)this.rLt);
      if (paramView != null) {}
      for (paramView = paramView.cGb();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.d.a("4", 4, 2, 5, i, j, null, null, 0L, paramView, 0, 0, 3520);
        break;
      }
      label324:
      Object localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.rLt, paramView, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.T((Context)this.rLt, paramView);
      AppMethodBeat.o(203357);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(FinderSelfUI paramFinderSelfUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167585);
      this.rLt.onBackPressed();
      AppMethodBeat.o(167585);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */