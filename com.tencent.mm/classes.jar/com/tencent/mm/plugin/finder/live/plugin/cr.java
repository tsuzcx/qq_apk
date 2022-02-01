package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bf;
import com.tencent.mm.plugin.finder.live.report.s.p;
import com.tencent.mm.plugin.finder.live.report.s.q;
import com.tencent.mm.plugin.finder.live.report.s.w;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.g.a;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "BIG_ANIMATION_FILE", "", "DIMISS_FOLLOWED_BTN", "", "PORTRAIT_ACTION_GOTO_PROFILE", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", "PORTRAIT_ACTION_KEY_FINDER_USERNAME", "getPORTRAIT_ACTION_KEY_FINDER_USERNAME", "SHOW_FOLLOW_BTN", "SHOW_FOLLOW_BTN_DELAY", "", "TAG", "getTAG", "anchorAvatarUrl", "anchorNickname", "authIv", "Landroid/widget/ImageView;", "avatarIcon", "bigAnim", "Lorg/libpag/PAGView;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "followBtn", "Landroid/widget/TextView;", "followBtnIcon", "followBtnLayout", "Landroid/widget/FrameLayout;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "value", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "adjustMarginEnd", "", "canClearScreen", "", "doBlockOpLog", "username", "goToAnchorFinderProfile", "initFollowBtn", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "reset", "resume", "setFollowBtnState", "isFollow", "source", "needAnim", "(ZLjava/lang/String;Ljava/lang/Boolean;)V", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "updateLiveTitle", "anchorUsername", "showContent", "plugin-finder_release"})
public final class cr
  extends d
{
  final String TAG;
  private Context context;
  private final TextView jbF;
  private final com.tencent.mm.live.c.b kCL;
  private int kCS;
  private final ImageView kLZ;
  private final f ocu;
  private com.tencent.mm.plugin.findersdk.a.aj<bep> ypR;
  private final String ytZ;
  private PAGView yub;
  private final String yup;
  private final String yuq;
  private final ImageView yxN;
  private final TextView yxO;
  private final ImageView yxP;
  private final FrameLayout yxQ;
  private String yxR;
  private String yxS;
  private final int yxT;
  private final int yxU;
  private final long yxV;
  
  public cr(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, bid parambid)
  {
    super(paramViewGroup, paramb, parambid);
    AppMethodBeat.i(225840);
    this.kCL = paramb;
    this.TAG = "Finder.LiveTitlePlugin";
    this.yup = "PORTRAIT_ACTION_GOTO_PROFILE_TITLE";
    this.yuq = "PORTRAIT_ACTION_KEY_FINDER_USERNAME";
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.f.live_title_info_avatar_icon);
    p.j(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.kLZ = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_title_info_name_tv);
    p.j(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.jbF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_title_info_tag_iv);
    p.j(paramb, "root.findViewById(R.id.live_title_info_tag_iv)");
    this.yxN = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_follow_btn);
    p.j(paramb, "root.findViewById(R.id.live_follow_btn)");
    this.yxO = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_follow_btn_icon);
    p.j(paramb, "root.findViewById(R.id.live_follow_btn_icon)");
    this.yxP = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_follow_btn_layout);
    p.j(paramb, "root.findViewById(R.id.live_follow_btn_layout)");
    this.yxQ = ((FrameLayout)paramb);
    this.kCS = ax.aB(paramViewGroup.getContext());
    this.yxT = 1;
    this.yxU = 2;
    this.yxV = 60000L;
    this.ytZ = "finder_live_follow_anim.pag";
    this.ocu = kotlin.g.ar((kotlin.g.a.a)new c(this));
    paramViewGroup = (View.OnClickListener)new a(this);
    this.kLZ.setOnClickListener(paramViewGroup);
    paramb = this.kLZ;
    parambid = this.context;
    p.j(parambid, "context");
    paramb.setImageDrawable(parambid.getResources().getDrawable(b.e.default_round_avatar));
    this.jbF.setOnClickListener(paramViewGroup);
    this.jbF.setTextSize(1, 15.0F);
    this.yxO.setTextSize(1, 10.0F);
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a((d)this, true);
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
    a(this, null, false, 1);
    this.jbF.postDelayed((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287205);
        cr.k(this.yxW);
        AppMethodBeat.o(287205);
      }
    }, 1000L);
    AppMethodBeat.o(225840);
  }
  
  private final void a(final boolean paramBoolean, String paramString, Boolean paramBoolean1)
  {
    AppMethodBeat.i(225802);
    Log.i(this.TAG, "[setFollowBtnState] source:" + paramString + ", isFollow:" + paramBoolean);
    if (this.yxQ.getVisibility() == 8) {}
    for (final int i = aw.fromDPToPix(this.kiF.getContext(), 30);; i = 0)
    {
      this.jbF.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new f(this, i));
      this.yxQ.setVisibility(0);
      this.yxO.setVisibility(0);
      if (this.kCL.getLiveRole() == 0) {
        m.yCt.a(s.w.yHu);
      }
      this.yxO.post((Runnable)new g(this));
      paramString = new h(this, paramBoolean);
      paramString.invoke(false);
      if (paramBoolean) {
        break;
      }
      paramString = m.yCt;
      m.a(s.q.yGx);
      this.yxP.setVisibility(0);
      this.yxQ.setBackground(this.kiF.getContext().getDrawable(b.e.finder_live_follow_btn_shape));
      paramString = this.yxO;
      paramBoolean1 = this.kiF.getContext();
      p.j(paramBoolean1, "root.context");
      paramString.setPadding(0, 0, paramBoolean1.getResources().getDimensionPixelSize(b.d.OneDPPadding), 0);
      this.yxO.setText((CharSequence)this.context.getString(b.j.finder_live_follow));
      paramString = this.yxO;
      paramBoolean1 = this.kiF.getContext();
      p.j(paramBoolean1, "root.context");
      paramString.setTextColor(paramBoolean1.getResources().getColor(com.tencent.mm.plugin.finder.b.c.White));
      this.yxO.setOnClickListener((View.OnClickListener)new i(this));
      paramString = this.yxQ;
      paramBoolean1 = new AlphaAnimation(0.0F, 1.0F);
      paramBoolean1.setDuration(200L);
      paramString.startAnimation((Animation)paramBoolean1);
      AppMethodBeat.o(225802);
      return;
    }
    this.yxP.setVisibility(4);
    this.yxO.setOnClickListener(null);
    if (p.h(paramBoolean1, Boolean.TRUE))
    {
      this.yxQ.setVisibility(0);
      this.yxO.post((Runnable)new j(paramString));
      AppMethodBeat.o(225802);
      return;
    }
    paramString = this.yub;
    if ((paramString != null) && (this.yxQ.indexOfChild((View)paramString) != -1))
    {
      if (paramString != null) {
        paramString.stop();
      }
      this.yxQ.removeView((View)paramString);
    }
    if (this.yxQ.getWidth() > 0) {
      this.yxQ.getLayoutParams().width = this.yxQ.getWidth();
    }
    this.yxP.setVisibility(8);
    this.yxQ.setBackground(this.kiF.getContext().getDrawable(b.e.finder_live_follow_btn_unable_shape));
    this.yxO.setText((CharSequence)this.context.getString(b.j.has_follow_tip));
    paramString = this.yxO;
    paramBoolean1 = this.context;
    p.j(paramBoolean1, "context");
    paramString.setTextColor(paramBoolean1.getResources().getColor(com.tencent.mm.plugin.finder.b.c.White));
    this.yxO.setPadding(0, 0, 0, 0);
    this.yxO.setOnClickListener((View.OnClickListener)new k(this));
    AppMethodBeat.o(225802);
  }
  
  private final MMHandler btS()
  {
    AppMethodBeat.i(225792);
    MMHandler localMMHandler = (MMHandler)this.ocu.getValue();
    AppMethodBeat.o(225792);
    return localMMHandler;
  }
  
  public final void a(Bundle paramBundle, Object paramObject, final long paramLong)
  {
    AppMethodBeat.i(225808);
    if (paramBundle != null)
    {
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.h(paramBundle, this.yup)) {
      com.tencent.mm.ae.d.a(paramLong, (Runnable)new d(this, paramLong));
    }
    AppMethodBeat.o(225808);
  }
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(225818);
    p.k(paramString, "anchorUsername");
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    com.tencent.mm.plugin.finder.api.i locali = d.a.aAK(paramString);
    Object localObject2 = this.TAG;
    Object localObject3 = new StringBuilder("updateLiveTitle contact avatarUrl is null:");
    boolean bool;
    if (locali != null)
    {
      localObject1 = locali.Mm();
      if (localObject1 != null) {
        break label463;
      }
      bool = true;
      label61:
      Log.i((String)localObject2, bool + ' ' + paramString + ",liveData username:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + ",showContent:" + paramBoolean);
      if (locali != null)
      {
        if (!isLandscape())
        {
          paramString = this.kiF.getLayoutParams();
          if (paramString != null)
          {
            if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGP()) {
              break label468;
            }
            ((ViewGroup.MarginLayoutParams)paramString).setMarginEnd(aw.fromDPToPix(this.kiF.getContext(), 160));
          }
        }
        label176:
        this.yxR = locali.getNickname();
        this.yxS = locali.Mm();
        paramString = com.tencent.mm.plugin.finder.loader.t.ztT;
        paramString = com.tencent.mm.plugin.finder.loader.t.dJh();
        localObject1 = new e(this.yxS);
        localObject2 = this.kLZ;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        paramString.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        paramString = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.ha(this.TAG, "updateLiveTitle load avatar " + this.yxR + ' ' + this.yxS + " uniqueId:" + MD5Util.getMD5String(this.yxS));
        this.jbF.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.context, (CharSequence)this.yxR, this.jbF.getTextSize()));
        if (locali.field_authInfo == null) {
          break label531;
        }
        if (locali.field_authInfo.authIconType <= 0) {
          break label490;
        }
        this.jbF.setPadding(this.jbF.getPaddingLeft(), this.jbF.getPaddingTop(), aw.fromDPToPix(this.kiF.getContext(), 20), this.jbF.getPaddingBottom());
        this.yxN.setVisibility(0);
        paramString = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.a(this.yxN, locali.field_authInfo, 0);
      }
    }
    for (;;)
    {
      paramString = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) && (paramBoolean) && (this.kiF.getVisibility() != 0)) {
        tU(0);
      }
      this.jbF.requestLayout();
      AppMethodBeat.o(225818);
      return;
      localObject1 = null;
      break;
      label463:
      bool = false;
      break label61;
      label468:
      ((ViewGroup.MarginLayoutParams)paramString).setMarginEnd(aw.fromDPToPix(this.kiF.getContext(), 112));
      break label176;
      label490:
      this.jbF.setPadding(this.jbF.getPaddingLeft(), this.jbF.getPaddingTop(), 0, this.jbF.getPaddingBottom());
      this.yxN.setVisibility(8);
      continue;
      label531:
      this.jbF.setPadding(this.jbF.getPaddingLeft(), this.jbF.getPaddingTop(), 0, this.jbF.getPaddingBottom());
      this.yxN.setVisibility(8);
    }
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(225828);
    super.reset();
    btS().removeMessages(this.yxT);
    AppMethodBeat.o(225828);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(225806);
    super.resume();
    int j = ax.aB(this.kiF.getContext());
    int i = j;
    if (j == 0) {
      i = aw.fromDPToPix(this.kiF.getContext(), 16);
    }
    this.kCS = i;
    this.yxO.post((Runnable)new e(this));
    AppMethodBeat.o(225806);
  }
  
  public final void statusChange(com.tencent.mm.live.c.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(225824);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (cs.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225824);
      return;
      tU(4);
      AppMethodBeat.o(225824);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, true);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
      AppMethodBeat.o(225824);
      return;
      btS().removeMessages(this.yxT);
      AppMethodBeat.o(225824);
      return;
      btS().removeMessages(this.yxT);
      btS().sendEmptyMessageDelayed(this.yxT, 0L);
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(225826);
    super.unMount();
    btS().removeMessages(this.yxT);
    AppMethodBeat.o(225826);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(cr paramcr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(287618);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        cr.j(this.yxW);
        if (cr.g(this.yxW).getLiveRole() == 0)
        {
          paramView = m.yCt;
          m.yBS = true;
          m.a(s.bf.yLg, null);
          m.yBC += 1;
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287618);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$doBlockOpLog$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.findersdk.a.aj<bep>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    c(cr paramcr)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a
      implements MMHandler.Callback
    {
      a(cr.c paramc) {}
      
      public final boolean handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(220816);
        int i = paramMessage.what;
        if (i == cr.i(this.yxX.yxW)) {
          cr.d(this.yxX.yxW).setVisibility(8);
        }
        label163:
        label207:
        label210:
        for (;;)
        {
          AppMethodBeat.o(220816);
          return true;
          if (i == cr.m(this.yxX.yxW))
          {
            paramMessage = com.tencent.mm.plugin.finder.upload.action.i.ACa;
            boolean bool = com.tencent.mm.plugin.finder.upload.action.i.ecE().aAN(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yxX.yxW.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
            Log.i(this.yxX.yxW.TAG, "has been look for one min ,isFollow".concat(String.valueOf(bool)));
            cr.a(this.yxX.yxW, bool, "#3");
            paramMessage = Long.valueOf(((c)this.yxX.yxW.business(c.class)).liveInfo.liveId);
            if (((Number)paramMessage).longValue() != 0L)
            {
              i = 1;
              if (i == 0) {
                break label207;
              }
            }
            for (;;)
            {
              if (paramMessage == null) {
                break label210;
              }
              long l = ((Number)paramMessage).longValue();
              paramMessage = com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.zgQ;
              com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.dGZ().put(Long.valueOf(l), Boolean.TRUE);
              break;
              i = 0;
              break label163;
              paramMessage = null;
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(cr paramcr, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(285421);
      if (!this.yxW.isFinished())
      {
        com.tencent.mm.plugin.finder.live.model.an localan = cr.getFinderLiveAssistant();
        if (localan != null)
        {
          Object localObject = com.tencent.mm.ui.component.g.Xox;
          localObject = cr.l(this.yxW);
          p.j(localObject, "context");
          localan.a(true, "", ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.lm((Context)localObject).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
          AppMethodBeat.o(285421);
          return;
        }
        AppMethodBeat.o(285421);
        return;
      }
      Log.i(this.yxW.TAG, "goToFinderProfileImpl delayMs:" + paramLong + ",isFinished!");
      AppMethodBeat.o(285421);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(cr paramcr) {}
    
    public final void run()
    {
      AppMethodBeat.i(247354);
      cr.k(this.yxW);
      AppMethodBeat.o(247354);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class f
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    f(int paramInt) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(270480);
      cr.a(this.yxW).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if ((cr.a(this.yxW).getWidth() > 0) && (cr.a(this.yxW).getWidth() > i * 4))
      {
        TextView localTextView = cr.a(this.yxW);
        localTextView.setWidth(localTextView.getWidth() - i);
      }
      AppMethodBeat.o(270480);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(cr paramcr) {}
    
    public final void run()
    {
      AppMethodBeat.i(290548);
      Object localObject = new Rect();
      cr.b(this.yxW).getHitRect((Rect)localObject);
      ((Rect)localObject).inset(((Rect)localObject).width() * -2, -((Rect)localObject).width());
      ViewParent localViewParent = cr.b(this.yxW).getParent();
      if (localViewParent == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(290548);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)cr.b(this.yxW)));
      AppMethodBeat.o(290548);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"showOrDismissAnimView", "", "isShow", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    h(cr paramcr, boolean paramBoolean)
    {
      super();
    }
    
    public final void invoke(final boolean paramBoolean)
    {
      AppMethodBeat.i(280357);
      if (cr.c(this.yxW) == null) {
        cr.a(this.yxW, new PAGView(this.yxW.kiF.getContext()));
      }
      Object localObject1 = cr.c(this.yxW);
      if (localObject1 != null)
      {
        if (paramBoolean)
        {
          Object localObject2;
          if (cr.d(this.yxW).indexOfChild((View)cr.c(this.yxW)) == -1)
          {
            localObject1 = new FrameLayout.LayoutParams(cr.d(this.yxW).getWidth(), cr.d(this.yxW).getHeight());
            localObject2 = cr.c(this.yxW);
            if (localObject2 != null) {
              ((PAGView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            cr.d(this.yxW).addView((View)cr.c(this.yxW));
          }
          localObject1 = cr.c(this.yxW);
          if (localObject1 != null)
          {
            localObject2 = MMApplicationContext.getContext();
            p.j(localObject2, "MMApplicationContext.getContext()");
            localObject2 = ((Context)localObject2).getResources();
            p.j(localObject2, "MMApplicationContext.getContext().resources");
            ((PAGView)localObject1).setFile(PAGFile.Load(((Resources)localObject2).getAssets(), cr.e(this.yxW)));
          }
          localObject1 = cr.c(this.yxW);
          if (localObject1 != null) {
            ((PAGView)localObject1).addListener((PAGView.PAGViewListener)new a(this, paramBoolean));
          }
          localObject1 = cr.c(this.yxW);
          if (localObject1 != null) {
            ((PAGView)localObject1).setProgress(0.0D);
          }
          localObject1 = cr.c(this.yxW);
          if (localObject1 != null) {
            ((PAGView)localObject1).flush();
          }
          localObject1 = cr.c(this.yxW);
          if (localObject1 != null)
          {
            ((PAGView)localObject1).play();
            AppMethodBeat.o(280357);
            return;
          }
          AppMethodBeat.o(280357);
          return;
        }
        if (cr.d(this.yxW).indexOfChild((View)localObject1) != -1)
        {
          ((PAGView)localObject1).stop();
          cr.d(this.yxW).removeView((View)localObject1);
        }
        AppMethodBeat.o(280357);
        return;
      }
      AppMethodBeat.o(280357);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$3$1$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements PAGView.PAGViewListener
    {
      a(cr.h paramh, boolean paramBoolean) {}
      
      public final void onAnimationCancel(PAGView paramPAGView)
      {
        AppMethodBeat.i(271982);
        cr.a(this.yya.yxW, this.yya.yxZ, "#5");
        AppMethodBeat.o(271982);
      }
      
      public final void onAnimationEnd(PAGView paramPAGView)
      {
        AppMethodBeat.i(271981);
        cr.a(this.yya.yxW, this.yya.yxZ, "#5");
        AppMethodBeat.o(271981);
      }
      
      public final void onAnimationRepeat(PAGView paramPAGView) {}
      
      public final void onAnimationStart(PAGView paramPAGView)
      {
        AppMethodBeat.i(271983);
        cr.b(this.yya.yxW).setVisibility(4);
        cr.f(this.yya.yxW).setVisibility(4);
        AppMethodBeat.o(271983);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(cr paramcr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280449);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.api.d.wZQ;
      paramView = d.a.aAK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yxW.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        boolean bool1 = com.tencent.mm.plugin.finder.utils.aj.j(paramView);
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        boolean bool2 = com.tencent.mm.plugin.finder.utils.aj.k(paramView);
        Log.i(this.yxW.TAG, "followBtn click, nickName:" + paramView.getNickname() + ", isPrivate:" + bool1 + " , isBlock" + bool2);
        localObject = ai.zAJ;
        localObject = com.tencent.mm.ui.component.g.Xox;
        localObject = this.yxW.kiF.getContext();
        p.j(localObject, "root.context");
        localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.lm((Context)localObject).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
        String str = paramView.getUsername();
        com.tencent.mm.plugin.finder.cgi.an localan = com.tencent.mm.plugin.finder.cgi.an.xci;
        ai.a((bid)localObject, str, com.tencent.mm.plugin.finder.cgi.an.dnL(), ((c)this.yxW.business(c.class)).xbk, bool1);
        if (bool2) {
          cr.a(this.yxW, paramView.getUsername());
        }
        paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        com.tencent.mm.plugin.finder.live.utils.a.eA((View)cr.b(this.yxW));
        cr.a(this.yxW, "#4", Boolean.TRUE);
        b.b.a(cr.g(this.yxW), com.tencent.mm.live.c.b.c.kzu);
        cr.h(this.yxW).sendEmptyMessageDelayed(cr.i(this.yxW), 5000L);
        m.yCt.a(s.w.yHv);
      }
      for (;;)
      {
        paramView = m.yCt;
        m.a(s.p.yGt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(280449);
        return;
        paramView = this.yxW;
        cr.b(paramView).setVisibility(8);
        Log.i(paramView.TAG, "no anchor finder contact ");
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(cr.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(286632);
      this.yyb.invoke(true);
      AppMethodBeat.o(286632);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(cr paramcr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229381);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      m.yCt.a(s.w.yHw);
      cr.j(this.yxW);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cr
 * JD-Core Version:    0.7.0.1
 */