package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan.Standard;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.ae;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.cgi.aw;
import com.tencent.mm.plugin.finder.live.model.l.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.aw;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.d;
import com.tencent.mm.plugin.finder.live.report.q.e;
import com.tencent.mm.plugin.finder.live.report.q.o;
import com.tencent.mm.plugin.finder.live.view.FinderLiveCommentRecyclerView;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.live.view.span.f.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/gala/viewpager/ICommentViewSelect;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomMarginByShopBubble", "", "bubbleContainer", "Landroid/widget/LinearLayout;", "bulletComment", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBulletCommentWidget;", "canClear", "", "chosenCommentView", "Landroid/view/View;", "chosenCommentViewBg", "Landroid/graphics/drawable/Drawable;", "commentAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter;", "commentListBound", "Lcom/tencent/mm/plugin/finder/live/view/FinderMaxSizeLayout;", "commentListH", "getCommentListH", "()I", "setCommentListH", "(I)V", "commentListView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentRecyclerView;", "commentListW", "getCommentListW", "setCommentListW", "enterLiveTimeStamp", "", "getEnterLiveTimeStamp", "()J", "setEnterLiveTimeStamp", "(J)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "ifComementEnable", "isMsgListViewVisible", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "positionChange", "readCount", "showShopBubble", "stickyContentTextSize", "getStickyContentTextSize", "stickyContentTextSize$delegate", "adjustCommentLayout", "", "distance", "attachBoxId", "boxId", "", "param", "Landroid/os/Bundle;", "bindBubbleContainer", "view", "calLandscapeListWidth", "canClearScreen", "changeMaxSize", "maxHeight", "checkBottomOptionLayout", "checkComment", "checkIsAssistantOrAnchorRole", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "commentScrollToEnd", "isSmooth", "(Ljava/lang/Boolean;)V", "complaintMsg", "doCommentAction", "enableComment", "username", "forceUpdateMessage", "msgList", "", "getBulletComment", "getCommentAreaHeight", "getCommentRootView", "getPluginAreaTopOnScreen", "goToFinderProfile", "finderUsername", "hideNewCommentTip", "ifReachLast", "isCommentPluginInInputPlugin", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLandscapeAction", "extraMsg", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onMsgPosted", "onPortraitDelayAction", "extraData", "", "delayMs", "onSelected", "isSelected", "putInBlack", "recordCommmentStatus", "reportCommentTopOp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "reset", "resetFlowOpWindow", "safeNotifyItemChange", "pos", "setCommentChoseBg", "setVisible", "visible", "showNewCommentTip", "count", "showOrHideBanComment", "content", "visibility", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "tickleSomeone", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "unMount", "updateCommentListInternal", "updateComments", "newDatas", "updateMessageInrtetnal", "withCheck", "updateMessages", "updateMessagesOnViewAttach", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends b
  implements com.tencent.mm.plugin.finder.live.gala.viewpager.a
{
  public static final ah.a CXJ;
  private static final float CXY;
  private static final int CXZ;
  private static final int CYa;
  public static final int CYb;
  public final FinderMaxSizeLayout CXK;
  private final FinderLiveCommentRecyclerView CXL;
  private final com.tencent.mm.plugin.finder.live.view.adapter.k CXM;
  public com.tencent.mm.plugin.finder.live.widget.t CXN;
  private boolean CXO;
  private boolean CXP;
  private int CXQ;
  private View CXR;
  private int CXS;
  private Drawable CXT;
  private boolean CXU;
  private final kotlin.j CXV;
  private volatile boolean CXW;
  private volatile long CXX;
  public LinearLayout EjI;
  private boolean aKS;
  private long hqR;
  final com.tencent.mm.live.b.b nfT;
  private final ViewGroup nhc;
  private final TextView nhd;
  private final kotlin.j rdm;
  
  static
  {
    AppMethodBeat.i(356127);
    CXJ = new ah.a((byte)0);
    CXY = MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_2A);
    CXZ = 1;
    CYa = 2;
    CYb = 3;
    AppMethodBeat.o(356127);
  }
  
  public ah(final ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355739);
    this.nfT = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_comment_list_tip_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(com.te…e_comment_list_tip_group)");
    this.nhc = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_comment_list_tip_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(com.te…live_comment_list_tip_tv)");
    this.nhd = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BJR);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.finder_live_comment_bound)");
    this.CXK = ((FinderMaxSizeLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.BJS);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.finder_live_comment_list)");
    this.CXL = ((FinderLiveCommentRecyclerView)paramb);
    this.CXM = new com.tencent.mm.plugin.finder.live.view.adapter.k(getBuContext());
    paramb = paramViewGroup.findViewById(p.e.BId);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.finder_live_bullet_comment)");
    this.CXN = new com.tencent.mm.plugin.finder.live.widget.t((ViewGroup)paramb, (RecyclerView)this.CXL);
    this.CXO = true;
    this.CXU = true;
    this.CXV = kotlin.k.cm((kotlin.g.a.a)i.CYe);
    this.CXW = true;
    this.rdm = kotlin.k.cm((kotlin.g.a.a)new e(this));
    paramb = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egt) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW()))
    {
      i = (int)(bf.bf(MMApplicationContext.getContext()).y * 0.29D);
      this.CXS = i;
      if (!isLandscape()) {
        break label571;
      }
      i = epS();
      paramViewGroup.getLayoutParams().width = i;
      this.CXL.getLayoutParams().width = i;
      this.CXK.setMaxHeight((int)(bf.bf(MMApplicationContext.getContext()).y * 0.22D));
      ((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)getBuContext().business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).CBG = i;
    }
    for (;;)
    {
      Log.i("Finder.LiveCommentPlugin", kotlin.g.b.s.X("commentListWidth : ", Integer.valueOf(((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)getBuContext().business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).CBG)));
      paramb = this.CXL;
      paramViewGroup.getContext();
      paramb.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.CXL.setAdapter((RecyclerView.a)this.CXM);
      com.tencent.mm.view.f.a((View)this.CXL, (e.b)new e.b()
      {
        public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(355286);
          kotlin.g.b.s.u(paramAnonymousView, "view");
          paramAnonymousBoolean = ah.g(this.CYc).isShown();
          if ((paramAnonymousBoolean) && (!ah.h(this.CYc))) {
            ah.f(this.CYc).bZE.notifyChanged();
          }
          ah.a(this.CYc, paramAnonymousBoolean);
          AppMethodBeat.o(355286);
        }
      });
      this.CXL.setFadeLength(paramViewGroup.getContext().getResources().getDimensionPixelSize(p.c.Edge_1_5_A));
      this.CXM.CyZ = ((kotlin.g.a.m)new u(paramViewGroup)
      {
        private static final void a(View paramAnonymousView1, aq paramAnonymousaq, com.tencent.mm.ui.base.s paramAnonymouss, View paramAnonymousView2, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(355343);
          kotlin.g.b.s.u(paramAnonymousView1, "$view");
          kotlin.g.b.s.u(paramAnonymousaq, "$msg");
          if (paramAnonymouss.findItem(154) == null) {
            paramAnonymouss.a(154, (CharSequence)paramAnonymousView1.getContext().getString(p.h.Ciy), p.g.icons_filled_reply);
          }
          if (paramAnonymouss.findItem(155) == null) {
            paramAnonymouss.a(155, (CharSequence)paramAnonymousView1.getContext().getString(p.h.Coa), p.g.icons_filled_copy);
          }
          if ((paramAnonymouss.findItem(156) == null) && (!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAM())) && (!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAW())) && (!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAX()))) {
            paramAnonymouss.a(156, (CharSequence)paramAnonymousView1.getContext().getString(p.h.finder_live_more_action_report), p.g.icons_filled_report_problem);
          }
          AppMethodBeat.o(355343);
        }
        
        private static final void a(View paramAnonymousView, ah paramAnonymousah)
        {
          AppMethodBeat.i(355332);
          kotlin.g.b.s.u(paramAnonymousView, "$view");
          kotlin.g.b.s.u(paramAnonymousah, "this$0");
          paramAnonymousView.setBackground(ah.j(paramAnonymousah));
          AppMethodBeat.o(355332);
        }
        
        private static final void a(View paramAnonymousView1, boolean paramAnonymousBoolean1, ah paramAnonymousah, aq paramAnonymousaq, boolean paramAnonymousBoolean2, String paramAnonymousString, com.tencent.mm.ui.base.s paramAnonymouss, View paramAnonymousView2, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(355281);
          kotlin.g.b.s.u(paramAnonymousView1, "$view");
          kotlin.g.b.s.u(paramAnonymousah, "this$0");
          kotlin.g.b.s.u(paramAnonymousaq, "$msg");
          if (paramAnonymouss.findItem(152) == null) {
            paramAnonymouss.a(152, (CharSequence)paramAnonymousView1.getContext().getString(p.h.Cjx), p.g.icons_filled_top);
          }
          if (paramAnonymousBoolean1)
          {
            paramAnonymousView1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
            paramAnonymousah = q.c.DrR;
            paramAnonymousString = new JSONObject();
            paramAnonymousString.put(q.d.Dsa.key, q.e.Dsh.Dsd);
            paramAnonymousString.put(q.d.Dsb.key, com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramAnonymousaq.getContent()), "utf-8"));
            paramAnonymousaq = kotlin.ah.aiuX;
            paramAnonymousView1.a(paramAnonymousah, paramAnonymousString.toString());
            AppMethodBeat.o(355281);
            return;
          }
          if (paramAnonymouss.findItem(154) == null)
          {
            paramAnonymousView2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if ((com.tencent.mm.plugin.finder.live.utils.a.n(paramAnonymousah.getBuContext())) || (((e)paramAnonymousah.business(e.class)).DUe)) {
              paramAnonymouss.a(154, (CharSequence)paramAnonymousView1.getContext().getString(p.h.Ciy), p.g.icons_filled_reply);
            }
          }
          if ((!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAW())) && (paramAnonymouss.findItem(157) == null))
          {
            paramAnonymousView2 = com.tencent.d.a.a.a.a.a.ahiX;
            if (((Number)com.tencent.d.a.a.a.a.a.jSk().bmg()).intValue() == 1) {
              paramAnonymouss.a(157, (CharSequence)paramAnonymousView1.getContext().getString(p.h.Cth), p.g.icons_filled_tickle);
            }
          }
          if ((!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAW())) && (!paramAnonymousBoolean2)) {
            paramAnonymouss.a(164, (CharSequence)paramAnonymousView1.getContext().getString(p.h.Cua), p.g.icons_filled_me);
          }
          if ((!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAW())) && (!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAM())) && (paramAnonymouss.findItem(158) == null))
          {
            paramAnonymousView2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || ((((e)paramAnonymousah.business(e.class)).DUe) && (!ah.b(paramAnonymousaq))))
            {
              if (!kotlin.g.b.s.p(((Map)((e)paramAnonymousah.business(e.class)).EcN).get(paramAnonymousString), Boolean.TRUE)) {
                break label589;
              }
              paramAnonymousString = paramAnonymousView1.getContext().getString(p.h.Cjv);
              kotlin.g.b.s.s(paramAnonymousString, "view.context.getString(R…r_live_comment_op_ban_on)");
              a(paramAnonymousBoolean2, paramAnonymouss, 158, (CharSequence)paramAnonymousString, p.g.icons_filled_comment);
            }
          }
          for (;;)
          {
            if ((!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAW())) && (!kotlin.g.b.s.p(paramAnonymousaq.djQ(), z.bAM())) && (paramAnonymouss.findItem(161) == null))
            {
              paramAnonymousString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || ((((e)paramAnonymousah.business(e.class)).DUe) && (!ah.b(paramAnonymousaq))))
              {
                paramAnonymousView1 = paramAnonymousView1.getContext().getString(p.h.Cjw);
                kotlin.g.b.s.s(paramAnonymousView1, "view.context.getString(R…er_live_comment_op_black)");
                a(paramAnonymousBoolean2, paramAnonymouss, 161, (CharSequence)paramAnonymousView1, p.g.icons_filled_black);
              }
            }
            AppMethodBeat.o(355281);
            return;
            label589:
            paramAnonymousString = paramAnonymousView1.getContext().getString(p.h.Cju);
            kotlin.g.b.s.s(paramAnonymousString, "view.context.getString(R…_live_comment_op_ban_off)");
            a(paramAnonymousBoolean2, paramAnonymouss, 158, (CharSequence)paramAnonymousString, p.g.icons_filled_comment_off);
          }
        }
        
        private static final void a(aq paramAnonymousaq, ah paramAnonymousah, String paramAnonymousString, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(355323);
          kotlin.g.b.s.u(paramAnonymousaq, "$msg");
          kotlin.g.b.s.u(paramAnonymousah, "this$0");
          kotlin.g.b.s.u(paramAnonymousView, "$view");
          kotlin.g.b.s.u(paramAnonymousViewGroup, "$root");
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            paramAnonymousView.setBackground(ah.j(paramAnonymousah));
            paramAnonymousaq = com.tencent.mm.plugin.finder.view.i.GzZ;
            com.tencent.mm.plugin.finder.view.i.fkK();
            AppMethodBeat.o(355323);
            return;
            paramAnonymousaq = paramAnonymousaq.eku();
            if (paramAnonymousaq != null)
            {
              ah.a(paramAnonymousah, paramAnonymousaq);
              continue;
              if (paramAnonymousaq.getType() == 1) {
                paramAnonymousString = ((com.tencent.mm.plugin.finder.live.model.am)paramAnonymousaq).CIc;
              }
              for (;;)
              {
                if (paramAnonymousString != null)
                {
                  paramAnonymousViewGroup = com.tencent.mm.plugin.finder.live.model.l.CFt;
                  if ((l.a.OP(paramAnonymousaq.getType())) || (paramAnonymousString.seq != 0L)) {
                    break label763;
                  }
                  paramAnonymousMenuItem = (e)paramAnonymousah.business(e.class);
                  paramAnonymousViewGroup = paramAnonymousString.kLn;
                  paramAnonymousaq = paramAnonymousViewGroup;
                  if (paramAnonymousViewGroup == null) {
                    paramAnonymousaq = "";
                  }
                  paramAnonymousMenuItem.aym(paramAnonymousaq);
                  Log.i("Finder.LiveCommentPlugin", kotlin.g.b.s.X("selfcomment click top, clientMsgId:", paramAnonymousString.kLn));
                  paramAnonymousaq = new Bundle();
                  paramAnonymousaq.putByteArray("PARAM_FINDER_LIVE_TOP_COMMENT", paramAnonymousString.toByteArray());
                  ah.i(paramAnonymousah).statusChange(b.c.nee, paramAnonymousaq);
                }
                if (!((e)paramAnonymousah.business(e.class)).DUe) {
                  break label923;
                }
                com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(13);
                break;
                paramAnonymousString = com.tencent.mm.plugin.finder.live.model.l.CFt;
                if (l.a.OP(paramAnonymousaq.getType()))
                {
                  paramAnonymousString = com.tencent.mm.plugin.finder.live.report.j.Dob;
                  paramAnonymousMenuItem = q.c.DrR;
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put(q.d.Dsa.key, q.e.Dsi.Dsd);
                  localJSONObject.put(q.d.Dsb.key, com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramAnonymousaq.getContent()), "utf-8"));
                  kotlin.ah localah = kotlin.ah.aiuX;
                  paramAnonymousString.a(paramAnonymousMenuItem, localJSONObject.toString());
                  if ((paramAnonymousaq instanceof com.tencent.mm.plugin.finder.live.model.am))
                  {
                    paramAnonymousString = ((com.tencent.mm.plugin.finder.live.model.am)paramAnonymousaq).CIc;
                    paramAnonymousString.nickname = paramAnonymousViewGroup.getContext().getString(p.h.Cia);
                  }
                  else if ((paramAnonymousaq instanceof com.tencent.mm.plugin.finder.live.model.m))
                  {
                    paramAnonymousString = new bke();
                    paramAnonymousString.nickname = paramAnonymousViewGroup.getContext().getString(p.h.Cia);
                    paramAnonymousString.content = paramAnonymousaq.getContent();
                    paramAnonymousString.type = paramAnonymousaq.getType();
                    paramAnonymousString.seq = paramAnonymousaq.dFp();
                    paramAnonymousString.kLn = ((com.tencent.mm.plugin.finder.live.model.m)paramAnonymousaq).CER.Tro;
                    paramAnonymousString.ZTp = ((com.tencent.mm.plugin.finder.live.model.m)paramAnonymousaq).CER.ZOc;
                  }
                  else
                  {
                    paramAnonymousString = null;
                  }
                }
                else if (paramAnonymousaq.getType() == 20002)
                {
                  paramAnonymousViewGroup = (com.tencent.mm.plugin.finder.live.model.t)paramAnonymousaq;
                  paramAnonymousString = new bke();
                  paramAnonymousString.nickname = paramAnonymousViewGroup.ekt();
                  paramAnonymousString.content = paramAnonymousViewGroup.getContent();
                  paramAnonymousString.type = 1;
                  paramAnonymousString.username = paramAnonymousViewGroup.djQ();
                  paramAnonymousString.seq = paramAnonymousViewGroup.CER.seq;
                  paramAnonymousString.kLn = paramAnonymousViewGroup.CER.Tro;
                  paramAnonymousString.EbJ = paramAnonymousViewGroup.CER.ZOb;
                  paramAnonymousString.ZTq = paramAnonymousViewGroup.CER.ZNW;
                  paramAnonymousString.ZTp = paramAnonymousViewGroup.CER.ZOc;
                }
                else if (paramAnonymousaq.getType() == 20035)
                {
                  paramAnonymousViewGroup = (ae)paramAnonymousaq;
                  paramAnonymousString = new bke();
                  paramAnonymousString.nickname = paramAnonymousViewGroup.ekt();
                  paramAnonymousString.content = paramAnonymousViewGroup.getContent();
                  paramAnonymousString.type = 1;
                  paramAnonymousString.username = paramAnonymousViewGroup.djQ();
                  paramAnonymousString.seq = paramAnonymousViewGroup.CER.seq;
                  paramAnonymousString.kLn = paramAnonymousViewGroup.CER.Tro;
                  paramAnonymousString.EbJ = paramAnonymousViewGroup.CER.ZOb;
                  paramAnonymousString.ZTp = paramAnonymousViewGroup.CER.ZOc;
                }
                else
                {
                  paramAnonymousString = null;
                }
              }
              label763:
              ((e)paramAnonymousah.business(e.class)).aym("");
              paramAnonymousViewGroup = com.tencent.mm.plugin.finder.live.model.l.CFt;
              if (l.a.OP(paramAnonymousaq.getType())) {}
              for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
              {
                paramAnonymousaq = new Bundle();
                paramAnonymousaq.putByteArray("PARAM_FINDER_LIVE_TOP_COMMENT", paramAnonymousString.toByteArray());
                ah.i(paramAnonymousah).statusChange(b.c.nee, paramAnonymousaq);
                new aw(paramAnonymousah.getBuContext(), paramAnonymousString, paramAnonymousInt).bFJ();
                kotlin.g.b.s.u(paramAnonymousString, "msg");
                if (paramAnonymousah.nfT.getLiveRole() != 1) {
                  break;
                }
                paramAnonymousaq = new com.tencent.mm.ad.i();
                paramAnonymousaq.m("content", paramAnonymousString.content);
                paramAnonymousaq.au("msgtype", paramAnonymousString.type);
                com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drp, paramAnonymousaq.toString());
                break;
              }
              label923:
              com.tencent.mm.plugin.finder.live.report.j.Dob.Pg(4);
              continue;
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("PARAM_MEMBERS_PROFILE_USERNAME", paramAnonymousaq.djQ());
              paramAnonymousString.putInt("PARAM_MEMBERS_PROFILE_SOURCE_TYPE", 2);
              ah.i(paramAnonymousah).statusChange(b.c.ncV, paramAnonymousString);
              if (((e)paramAnonymousah.business(e.class)).DUe)
              {
                com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(9);
                continue;
                paramAnonymousaq = (Boolean)((Map)((e)paramAnonymousah.business(e.class)).EcN).get(paramAnonymousString);
                boolean bool;
                if (paramAnonymousaq == null)
                {
                  bool = false;
                  label1035:
                  Log.i("Finder.LiveCommentPlugin", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BAN username:" + paramAnonymousString + " disableComment:" + bool);
                  if (paramAnonymousString != null)
                  {
                    ah.a(paramAnonymousah, bool, paramAnonymousString);
                    if (ah.i(paramAnonymousah).getLiveRole() == 1)
                    {
                      paramAnonymousaq = com.tencent.mm.plugin.finder.live.report.j.Dob;
                      paramAnonymousaq = com.tencent.mm.plugin.finder.live.report.j.Doc.Dqq;
                      paramAnonymousaq.DGf += 1L;
                      paramAnonymousViewGroup = new JSONObject();
                      paramAnonymousViewGroup.put(String.valueOf(q.aw.DzZ.action), paramAnonymousString);
                      paramAnonymousaq = q.c.Drk;
                      paramAnonymousString = com.tencent.mm.plugin.finder.live.report.j.Dob;
                      if (com.tencent.mm.plugin.finder.live.report.j.Doc.Dqt) {
                        paramAnonymousaq = q.c.Drm;
                      }
                      com.tencent.mm.plugin.finder.live.report.j.Dob.a(paramAnonymousaq, paramAnonymousViewGroup.toString());
                    }
                  }
                  if (!((e)paramAnonymousah.business(e.class)).DUe) {
                    break label1226;
                  }
                  paramAnonymousaq = com.tencent.mm.plugin.finder.live.report.k.Doi;
                  if (!bool) {
                    break label1219;
                  }
                }
                label1219:
                for (paramAnonymousInt = 11;; paramAnonymousInt = 10)
                {
                  paramAnonymousaq.Pn(paramAnonymousInt);
                  break;
                  bool = paramAnonymousaq.booleanValue();
                  break label1035;
                }
                label1226:
                paramAnonymousaq = com.tencent.mm.plugin.finder.live.report.j.Dob;
                if (bool) {}
                for (paramAnonymousInt = 6;; paramAnonymousInt = 5)
                {
                  paramAnonymousaq.Pg(paramAnonymousInt);
                  break;
                }
                ah.a(paramAnonymousah, paramAnonymousString);
                if (((e)paramAnonymousah.business(e.class)).DUe)
                {
                  com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(12);
                }
                else
                {
                  com.tencent.mm.plugin.finder.live.report.j.Dob.Pg(7);
                  continue;
                  Log.i("Finder.LiveCommentPlugin", "[LONGCLICK_MENU_FINDER_LIVE_REPLY], anchor or assistant, " + ((e)paramAnonymousah.business(e.class)).DUe + ", riskControlEnableComment:" + ((e)paramAnonymousah.business(e.class)).Ecr + ",enableLiveRoomComment:" + ((e)paramAnonymousah.business(e.class)).Ect + ", enableCustomerComment:" + ((e)paramAnonymousah.business(e.class)).Ecs);
                  paramAnonymousString = new Bundle();
                  paramAnonymousString.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
                  paramAnonymousaq = paramAnonymousaq.eku();
                  if (paramAnonymousaq == null) {}
                  for (paramAnonymousaq = null;; paramAnonymousaq = paramAnonymousaq.toByteArray())
                  {
                    paramAnonymousString.putByteArray("PARAM_ENTER_COMMENT_AT_NAME", paramAnonymousaq);
                    ah.i(paramAnonymousah).statusChange(b.c.ncO, paramAnonymousString);
                    if (!((e)paramAnonymousah.business(e.class)).DUe) {
                      break label1483;
                    }
                    com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(8);
                    break;
                  }
                  label1483:
                  paramAnonymousaq = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                  if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
                    com.tencent.mm.plugin.finder.live.report.j.Dob.Pg(8);
                  } else {
                    com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(4);
                  }
                }
              }
            }
          }
        }
        
        private static final void a(ah paramAnonymousah, aq paramAnonymousaq, ViewGroup paramAnonymousViewGroup, View paramAnonymousView, MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(355372);
          kotlin.g.b.s.u(paramAnonymousah, "this$0");
          kotlin.g.b.s.u(paramAnonymousaq, "$msg");
          kotlin.g.b.s.u(paramAnonymousViewGroup, "$root");
          kotlin.g.b.s.u(paramAnonymousView, "$view");
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            paramAnonymousView.setBackground(ah.j(paramAnonymousah));
            paramAnonymousah = com.tencent.mm.plugin.finder.view.i.GzZ;
            com.tencent.mm.plugin.finder.view.i.fkK();
            AppMethodBeat.o(355372);
            return;
            Log.i("Finder.LiveCommentPlugin", "[LONGCLICK_MENU_FINDER_LIVE_REPLY],riskControlEnableComment:" + ((e)paramAnonymousah.business(e.class)).Ecr + ",enableLiveRoomComment:" + ((e)paramAnonymousah.business(e.class)).Ect + ", enableCustomerComment:" + ((e)paramAnonymousah.business(e.class)).Ecs);
            if ((((e)paramAnonymousah.business(e.class)).Ecr) && (((e)paramAnonymousah.business(e.class)).Ect) && (((e)paramAnonymousah.business(e.class)).Ecs))
            {
              paramAnonymousViewGroup = new Bundle();
              paramAnonymousViewGroup.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
              paramAnonymousaq = paramAnonymousaq.eku();
              if (paramAnonymousaq == null)
              {
                paramAnonymousaq = null;
                label259:
                paramAnonymousViewGroup.putByteArray("PARAM_ENTER_COMMENT_AT_NAME", paramAnonymousaq);
                ah.i(paramAnonymousah).statusChange(b.c.ncO, paramAnonymousViewGroup);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(4);
              break;
              paramAnonymousaq = paramAnonymousaq.toByteArray();
              break label259;
              aa.a(paramAnonymousViewGroup.getContext(), MMApplicationContext.getContext().getResources().getString(p.h.Csg), ah.2..ExternalSyntheticLambda2.INSTANCE);
            }
            paramAnonymousViewGroup = MMApplicationContext.getContext().getSystemService("clipboard");
            if (paramAnonymousViewGroup == null)
            {
              paramAnonymousah = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(355372);
              throw paramAnonymousah;
            }
            ((ClipboardManager)paramAnonymousViewGroup).setText((CharSequence)paramAnonymousaq.getContent());
            if (ah.i(paramAnonymousah).getLiveRole() == 0)
            {
              paramAnonymousaq = com.tencent.mm.plugin.finder.live.report.k.Doi;
              com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCq, null, 0L, null, null, null, 60);
            }
            com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(5);
            continue;
            ah.b(paramAnonymousah, paramAnonymousaq.djQ());
            continue;
            ah.a(paramAnonymousah, paramAnonymousaq);
            if (ah.i(paramAnonymousah).getLiveRole() == 0)
            {
              paramAnonymousViewGroup = com.tencent.mm.plugin.finder.live.report.k.Doi;
              paramAnonymousViewGroup = paramAnonymousaq.djQ();
              paramAnonymousMenuItem = q.o.DtS;
              kotlin.g.b.s.u(paramAnonymousMenuItem, "source");
              JSONObject localJSONObject = new JSONObject();
              paramAnonymousaq = paramAnonymousViewGroup;
              if (paramAnonymousViewGroup == null) {
                paramAnonymousaq = "";
              }
              localJSONObject.put("username", paramAnonymousaq);
              localJSONObject.put("source", paramAnonymousMenuItem.source);
              com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCk, localJSONObject.toString(), 0L, null, null, null, 60);
              com.tencent.mm.plugin.finder.live.report.k.DoA += 1;
            }
            com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(6);
          }
        }
        
        private static final void a(boolean paramAnonymousBoolean, com.tencent.mm.ui.base.s paramAnonymouss, int paramAnonymousInt1, CharSequence paramAnonymousCharSequence, int paramAnonymousInt2)
        {
          AppMethodBeat.i(355261);
          Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
          if ((((Number)com.tencent.d.a.a.a.a.a.jSk().bmg()).intValue() == 1) && (paramAnonymousBoolean))
          {
            localObject = new com.tencent.mm.ui.base.t(paramAnonymouss.mContext, paramAnonymousInt1, 0);
            ((com.tencent.mm.ui.base.t)localObject).setTitle(paramAnonymousCharSequence);
            ((com.tencent.mm.ui.base.t)localObject).setIcon(paramAnonymousInt2);
            ((com.tencent.mm.ui.base.t)localObject).adSc = true;
            paramAnonymouss.adRW.add(localObject);
            AppMethodBeat.o(355261);
            return;
          }
          paramAnonymouss.a(paramAnonymousInt1, paramAnonymousCharSequence, paramAnonymousInt2);
          AppMethodBeat.o(355261);
        }
        
        private static final void b(View paramAnonymousView, ah paramAnonymousah)
        {
          AppMethodBeat.i(355383);
          kotlin.g.b.s.u(paramAnonymousView, "$view");
          kotlin.g.b.s.u(paramAnonymousah, "this$0");
          paramAnonymousView.setBackground(ah.j(paramAnonymousah));
          AppMethodBeat.o(355383);
        }
        
        private static final void fW(View paramAnonymousView)
        {
          AppMethodBeat.i(355352);
          if (paramAnonymousView != null)
          {
            TextView localTextView = (TextView)paramAnonymousView.findViewById(p.e.toast_text);
            if (localTextView != null) {
              localTextView.setTextSize(1, 14.0F);
            }
          }
          if (paramAnonymousView != null)
          {
            paramAnonymousView = (WeImageView)paramAnonymousView.findViewById(p.e.toast_img);
            if (paramAnonymousView != null) {
              paramAnonymousView.setImageResource(p.g.icon_outlined_close_comment);
            }
          }
          AppMethodBeat.o(355352);
        }
        
        private static final void y(ViewGroup paramAnonymousViewGroup)
        {
          AppMethodBeat.i(355393);
          kotlin.g.b.s.u(paramAnonymousViewGroup, "$root");
          paramAnonymousViewGroup = paramAnonymousViewGroup.getContext();
          if (paramAnonymousViewGroup == null)
          {
            paramAnonymousViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(355393);
            throw paramAnonymousViewGroup;
          }
          ((Activity)paramAnonymousViewGroup).finish();
          AppMethodBeat.o(355393);
        }
      });
      this.CXL.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(353620);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(353620);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(353616);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousRecyclerView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt1);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          kotlin.g.b.s.u(paramAnonymousRecyclerView, "recyclerView");
          paramAnonymousRecyclerView = ah.g(this.CYc).getLayoutManager();
          if (paramAnonymousRecyclerView == null)
          {
            paramAnonymousRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(353616);
            throw paramAnonymousRecyclerView;
          }
          paramAnonymousInt1 = ((LinearLayoutManager)paramAnonymousRecyclerView).Jw();
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)this.CYc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgI = paramAnonymousInt1;
          paramAnonymousRecyclerView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)this.CYc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class);
          localObject = ah.g(this.CYc).getLayoutManager();
          if (localObject == null)
          {
            paramAnonymousRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(353616);
            throw paramAnonymousRecyclerView;
          }
          paramAnonymousRecyclerView.EgJ = ((LinearLayoutManager)localObject).Ju();
          paramAnonymousRecyclerView = aj.CGT;
          if (paramAnonymousInt1 < aj.els() - 1)
          {
            ah.a(this.CYc, kotlin.k.k.bR(paramAnonymousInt1 + 1, ah.k(this.CYc)));
            if (paramAnonymousInt1 != ah.f(this.CYc).getItemCount() - 1) {
              break label276;
            }
          }
          label276:
          for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 != 0) {
              ah.l(this.CYc);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(353616);
            return;
            ah.a(this.CYc, ((e)this.CYc.business(e.class)).EcM);
            break;
          }
        }
      });
      this.nhc.setOnClickListener(new ah..ExternalSyntheticLambda0(this));
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
      AppMethodBeat.o(355739);
      return;
      i = (int)(bf.bf(MMApplicationContext.getContext()).y * 0.25D);
      break;
      label571:
      this.CXK.setMaxHeight((int)(this.CXS + CXY));
      paramb = bf.bf(paramViewGroup.getContext());
      ViewGroup.LayoutParams localLayoutParams;
      if (paramb.x >= paramb.y / 3 * 2)
      {
        localLayoutParams = paramViewGroup.getLayoutParams();
        localLayoutParams.width = (paramb.x / 2);
        paramViewGroup.setLayoutParams(localLayoutParams);
      }
      else
      {
        paramb = (com.tencent.mm.plugin.finder.live.component.msginterceptor.c)getBuContext().business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class);
        i = bf.bf(MMApplicationContext.getContext()).x;
        localLayoutParams = paramViewGroup.getLayoutParams();
        if (localLayoutParams == null)
        {
          paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(355739);
          throw paramViewGroup;
        }
        int j = ((ViewGroup.MarginLayoutParams)localLayoutParams).getMarginStart();
        localLayoutParams = paramViewGroup.getLayoutParams();
        if (localLayoutParams == null)
        {
          paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(355739);
          throw paramViewGroup;
        }
        paramb.CBG = (i - j - ((ViewGroup.MarginLayoutParams)localLayoutParams).getMarginEnd());
      }
    }
  }
  
  private static final void a(ah paramah, Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(355986);
    kotlin.g.b.s.u(paramah, "this$0");
    if (!paramah.isFinished())
    {
      paramah = aj.CGT;
      paramah = aj.getFinderLiveAssistant();
      if (paramah != null)
      {
        paramah.m(paramObject, "PORTRAIT_ACTION_KEY_FINDER_USERNAME");
        AppMethodBeat.o(355986);
      }
    }
    else
    {
      Log.i("Finder.LiveCommentPlugin", "goToFinderProfileImpl delayMs:" + paramLong + ",isFinished!");
    }
    AppMethodBeat.o(355986);
  }
  
  private static final void a(ah paramah, View paramView)
  {
    AppMethodBeat.i(355895);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramah);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramah, "this$0");
    paramah.bjj();
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgM)
    {
      int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgI;
      int j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE.size();
      paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
      kotlin.g.b.s.s(paramView, "business(LiveMsgSlice::class.java).msgList");
      localObject1 = ((Iterable)p.a(paramView, new kotlin.k.g(i, j - 1))).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramView = ((Iterator)localObject1).next();
        localObject2 = (aq)paramView;
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        kotlin.g.b.s.s(localObject2, "it");
        if (com.tencent.mm.plugin.finder.live.utils.a.d((aq)localObject2))
        {
          paramView = (aq)paramView;
          if (paramView != null)
          {
            i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE.indexOf(paramView);
            if (i == -1) {
              break label421;
            }
            localObject2 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            localObject1 = paramView.djQ();
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            com.tencent.mm.plugin.finder.live.report.k.a((com.tencent.mm.plugin.finder.live.report.k)localObject2, paramView);
            paramView = paramah.CXL;
            localObject1 = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.k.qv(kotlin.k.k.qu(i, 0), paramah.CXM.getItemCount() - 1), new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "_init_$lambda-3", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
            paramView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "_init_$lambda-3", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
          }
          label373:
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgM = false;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355895);
      return;
      paramView = null;
      break;
      label421:
      a(paramah);
      break label373;
      a(paramah);
    }
  }
  
  private static final void a(ah paramah, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355916);
    kotlin.g.b.s.u(paramah, "this$0");
    if (params.jmw()) {
      params.a(162, paramah.mJe.getContext().getResources().getColor(p.b.Red), (CharSequence)paramah.mJe.getContext().getResources().getString(p.h.Cud));
    }
    AppMethodBeat.o(355916);
  }
  
  private static final void a(ah paramah, final String paramString, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(355927);
    kotlin.g.b.s.u(paramah, "this$0");
    if (paramMenuItem.getItemId() == 162)
    {
      paramMenuItem = aj.CGT;
      paramMenuItem = aj.getFinderLiveAssistant();
      if (paramMenuItem != null) {
        paramMenuItem.d(paramString, (kotlin.g.a.m)new f(paramah, paramString));
      }
    }
    AppMethodBeat.o(355927);
  }
  
  private static final void a(kotlin.g.b.ah.f paramf1, kotlin.g.b.ah.f paramf2, com.tencent.mm.pluginsdk.ui.span.q paramq)
  {
    AppMethodBeat.i(355971);
    kotlin.g.b.s.u(paramf1, "$banComment");
    kotlin.g.b.s.u(paramf2, "$parent");
    kotlin.g.b.s.u(paramq, "$userMessage");
    paramf1 = (MMNeat7extView)((View)paramf1.aqH).findViewById(p.e.live_comment_item_content_tv);
    if (paramf1.getLineCount() > 1)
    {
      ViewParent localViewParent = paramf1.getParent();
      if (localViewParent == null)
      {
        paramf1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(355971);
        throw paramf1;
      }
      ((RelativeLayout)localViewParent).setPadding(0, ((RelativeLayout)paramf2.aqH).getPaddingTop(), ((RelativeLayout)paramf2.aqH).getPaddingRight(), ((RelativeLayout)paramf2.aqH).getPaddingBottom());
      paramf1.setSpacingAdd(5);
      paramf2 = SpannableStringBuilder.valueOf((CharSequence)paramq);
      paramf2.setSpan(new LeadingMarginSpan.Standard(0, bd.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, paramq.length(), 33);
      paramf1.aZ((CharSequence)paramf2);
    }
    AppMethodBeat.o(355971);
  }
  
  private static final void b(ah paramah)
  {
    AppMethodBeat.i(355936);
    kotlin.g.b.s.u(paramah, "this$0");
    paramah.t(Boolean.TRUE);
    com.tencent.mm.plugin.finder.view.i locali = com.tencent.mm.plugin.finder.view.i.GzZ;
    com.tencent.mm.plugin.finder.view.i.fkK();
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgM = false;
    AppMethodBeat.o(355936);
  }
  
  public static boolean b(aq paramaq)
  {
    AppMethodBeat.i(355747);
    kotlin.g.b.s.u(paramaq, "msg");
    paramaq = paramaq.eku();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.a(paramaq);
    AppMethodBeat.o(355747);
    return bool;
  }
  
  private final void bI(final List<aq> paramList)
  {
    AppMethodBeat.i(355831);
    if (!this.CXL.isShown())
    {
      this.CXW = false;
      Log.i("Finder.LiveCommentPlugin", "[updateComments] RecyclerView is invisible, return");
      AppMethodBeat.o(355831);
      return;
    }
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      int i = paramList.size();
      com.tencent.mm.ae.d.a(paramList, (kotlin.g.a.b)k.CYf);
      int j = paramList.size();
      Log.i("Finder.LiveCommentPlugin", "updateComments  before size:" + i + " afterSize:" + j);
    }
    g.b localb = androidx.recyclerview.widget.g.a((androidx.recyclerview.widget.g.a)new m(this, paramList), false);
    kotlin.g.b.s.s(localb, "private fun updateCommen…      }\n\n        })\n    }");
    localb.a((androidx.recyclerview.widget.q)new l(this, paramList));
    AppMethodBeat.o(355831);
  }
  
  private final void bjj()
  {
    AppMethodBeat.i(355823);
    this.nhc.setVisibility(8);
    AppMethodBeat.o(355823);
  }
  
  private static final void c(ah paramah)
  {
    AppMethodBeat.i(355946);
    kotlin.g.b.s.u(paramah, "this$0");
    a(paramah);
    AppMethodBeat.o(355946);
  }
  
  private static final void c(ah paramah, List paramList)
  {
    AppMethodBeat.i(355958);
    kotlin.g.b.s.u(paramah, "this$0");
    kotlin.g.b.s.u(paramList, "$msgList");
    paramah.bI(paramList);
    paramah.hqR = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgL;
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgK;
    int j = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)paramah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgJ;
    long l = ((e)paramah.business(e.class)).EcM - paramah.hqR;
    Log.i("Finder.LiveCommentPlugin", "[updateMessagesOnViewAttach] readCount:" + paramah.hqR + ", unreadCount" + l + ",reachLast" + bool + ", position" + j);
    int i;
    if (paramah.CXM.getItemCount() > 0)
    {
      if (bool)
      {
        paramah.CXL.post(new ah..ExternalSyntheticLambda5(paramah));
        AppMethodBeat.o(355958);
        return;
      }
      if (j >= 0) {
        break label289;
      }
      i = 0;
    }
    for (;;)
    {
      paramList = paramah.CXL;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramList, locala.aYi(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "updateMessagesOnViewAttach$lambda-17", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
      paramList.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "updateMessagesOnViewAttach$lambda-17", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
      paramah.op(l);
      AppMethodBeat.o(355958);
      return;
      label289:
      i = j;
      if (j >= paramah.CXM.getItemCount()) {
        i = paramah.CXM.getItemCount() - 1;
      }
    }
  }
  
  private static final void d(ah paramah)
  {
    AppMethodBeat.i(355977);
    kotlin.g.b.s.u(paramah, "this$0");
    paramah.rm(false);
    AppMethodBeat.o(355977);
  }
  
  private static final void e(ah paramah)
  {
    AppMethodBeat.i(356003);
    kotlin.g.b.s.u(paramah, "this$0");
    ((com.tencent.mm.plugin.finder.live.component.msginterceptor.c)paramah.getBuContext().business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class)).CBG = epS();
    AppMethodBeat.o(356003);
  }
  
  private final boolean epP()
  {
    AppMethodBeat.i(355782);
    if (this.CXM.getItemCount() != 0)
    {
      Object localObject = this.CXL.getLayoutManager();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(355782);
        throw ((Throwable)localObject);
      }
      if (((LinearLayoutManager)localObject).Jw() == this.CXM.getItemCount() - 1)
      {
        localObject = com.tencent.mm.plugin.finder.view.i.GzZ;
        if (!com.tencent.mm.plugin.finder.view.i.isShowing())
        {
          AppMethodBeat.o(355782);
          return true;
        }
      }
    }
    AppMethodBeat.o(355782);
    return false;
  }
  
  private final void epQ()
  {
    AppMethodBeat.i(355841);
    if (this.hqR > 0L)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgK = epP();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgL = kotlin.k.k.bR(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgL, this.hqR);
    }
    AppMethodBeat.o(355841);
  }
  
  private final void epR()
  {
    AppMethodBeat.i(355852);
    Boolean localBoolean = ((e)business(e.class)).EdB;
    boolean bool;
    int i;
    if (localBoolean != null)
    {
      bool = localBoolean.booleanValue();
      if (this.CXO != bool) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(355852);
        return;
      }
      if (System.currentTimeMillis() - this.CXX >= 3000L) {
        break label127;
      }
      i = 1;
      this.CXO = bool;
      if (!this.CXO) {
        break label132;
      }
      rm(false);
      t(Boolean.TRUE);
      this.CXL.setVisibility(0);
    }
    for (;;)
    {
      Log.i("Finder.LiveCommentPlugin", kotlin.g.b.s.X("enableLiveRoomComment:", Boolean.valueOf(bool)));
      AppMethodBeat.o(355852);
      return;
      label127:
      i = 0;
      break;
      label132:
      if (i != 0)
      {
        com.tencent.mm.ae.d.a(3000L, (kotlin.g.a.a)new c(this));
      }
      else
      {
        this.CXL.setVisibility(8);
        kotlin.g.b.s.s(MMApplicationContext.getContext().getResources().getString(p.h.finder_live_comment_anchor_disable), "context.resources.getStr…e_comment_anchor_disable)");
        rm(true);
      }
    }
  }
  
  private static int epS()
  {
    AppMethodBeat.i(355878);
    int i = (int)(bf.bf(MMApplicationContext.getContext()).x * 0.4D);
    AppMethodBeat.o(355878);
    return i;
  }
  
  private static final void fV(View paramView)
  {
    AppMethodBeat.i(355905);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_done);
      }
    }
    AppMethodBeat.o(355905);
  }
  
  private final void gx(List<aq> paramList)
  {
    AppMethodBeat.i(355761);
    Log.i("Finder.LiveCommentPlugin", "updateCommentListInternal liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ",msgListCount:" + paramList.size());
    boolean bool = epP();
    long l = ((e)business(e.class)).EcM - this.hqR;
    bI(paramList);
    if (this.CXM.getItemCount() > 0)
    {
      if (bool)
      {
        this.CXL.post(new ah..ExternalSyntheticLambda4(this));
        AppMethodBeat.o(355761);
        return;
      }
      if (l > 0L) {
        op(l);
      }
    }
    AppMethodBeat.o(355761);
  }
  
  private final void gy(List<aq> paramList)
  {
    AppMethodBeat.i(355789);
    Collection localCollection = (Collection)paramList;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; (i == 0) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgI != -1); i = 0)
    {
      this.CXL.post(new ah..ExternalSyntheticLambda9(this, paramList));
      AppMethodBeat.o(355789);
      return;
    }
    Log.i("Finder.LiveCommentPlugin", kotlin.g.b.s.X("[updateMessagesOnViewAttach] curVisiableFirstPosition:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgJ)));
    AppMethodBeat.o(355789);
  }
  
  private final void j(List<aq> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(355770);
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty()))
    {
      i = 1;
      if ((i == 0) && ((kotlin.g.b.s.p(((e)business(e.class)).EdB, Boolean.TRUE)) || (!paramBoolean))) {
        gx(paramList);
      }
      if (kotlin.g.b.s.p(((e)business(e.class)).EdB, Boolean.TRUE))
      {
        localObject = this.CXN;
        List localList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgF;
        kotlin.g.b.s.s(localList, "business(LiveMsgSlice::c…ss.java).bulletCommetList");
        ((com.tencent.mm.plugin.finder.live.widget.t)localObject).ha(localList);
      }
      if (paramBoolean) {
        if (((Collection)paramList).isEmpty()) {
          break label160;
        }
      }
    }
    label160:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        epR();
      }
      AppMethodBeat.o(355770);
      return;
      i = 0;
      break;
    }
  }
  
  private final void op(long paramLong)
  {
    AppMethodBeat.i(355816);
    if ((paramLong > 0L) && (((e)business(e.class)).Ect))
    {
      this.nhc.setVisibility(0);
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgM)
      {
        if (paramLong <= 99L) {}
        for (localObject1 = String.valueOf(paramLong);; localObject1 = "99+")
        {
          localObject2 = this.nhd;
          Object localObject3 = kotlin.g.b.am.aixg;
          localObject3 = this.mJe.getContext().getResources().getString(p.h.CoM);
          kotlin.g.b.s.s(localObject3, "root.context.resources.g…der_live_new_comment_tip)");
          localObject1 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject1 }, 1));
          kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
          ((TextView)localObject2).setText((CharSequence)localObject1);
          AppMethodBeat.o(355816);
          return;
        }
      }
      Object localObject1 = this.nhd;
      Object localObject2 = kotlin.g.b.am.aixg;
      localObject2 = this.mJe.getContext().getResources().getString(p.h.Cjq);
      kotlin.g.b.s.s(localObject2, "root.context.resources.g…_live_comment_at_me_tips)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[0], 0));
      kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)localObject2);
      AppMethodBeat.o(355816);
      return;
    }
    bjj();
    AppMethodBeat.o(355816);
  }
  
  private final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(355871);
    Object localObject1 = new kotlin.g.b.ah.f();
    ((kotlin.g.b.ah.f)localObject1).aqH = this.mJe.findViewById(p.e.BGO);
    if (paramBoolean)
    {
      this.CXN.EnI.clear();
      this.CXN.eAm();
      bjj();
      localObject3 = MMApplicationContext.getContext();
      localObject2 = new com.tencent.mm.pluginsdk.ui.span.q(((Context)localObject3).getResources().getString(p.h.Civ, new Object[] { ((Context)localObject3).getResources().getString(p.h.finder_live_comment_anchor_disable) }));
      localObject3 = ((Context)localObject3).getResources().getString(p.h.Ciw);
      kotlin.g.b.s.s(localObject3, "context.resources.getStr…_annoucement_replacement)");
      Object localObject4 = com.tencent.mm.plugin.finder.live.view.span.f.DWG;
      localObject4 = f.a.ayg((String)localObject3);
      CharSequence localCharSequence = (CharSequence)localObject3;
      com.tencent.mm.plugin.finder.live.view.span.g.a locala = com.tencent.mm.plugin.finder.live.view.span.g.DWI;
      float f1 = com.tencent.mm.plugin.finder.live.view.span.g.ewv();
      locala = com.tencent.mm.plugin.finder.live.view.span.g.DWI;
      float f2 = com.tencent.mm.plugin.finder.live.view.span.g.ewv();
      int i = MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_8);
      locala = com.tencent.mm.plugin.finder.live.view.span.g.DWI;
      int j = com.tencent.mm.plugin.finder.live.view.span.g.ewt();
      int k = MMApplicationContext.getContext().getResources().getColor(p.b.BW_0_Alpha_0_8);
      locala = com.tencent.mm.plugin.finder.live.view.span.g.DWI;
      ((com.tencent.mm.pluginsdk.ui.span.q)localObject2).a(new com.tencent.mm.plugin.finder.live.view.span.f((Drawable)localObject4, new com.tencent.mm.plugin.finder.live.view.span.g(localCharSequence, f1, f2, i, j, k, com.tencent.mm.plugin.finder.live.view.span.g.ewu())), (CharSequence)localObject3, 0);
      localObject3 = new kotlin.g.b.ah.f();
      localObject4 = ((MMNeat7extView)((View)((kotlin.g.b.ah.f)localObject1).aqH).findViewById(p.e.live_comment_item_content_tv)).getParent();
      if (localObject4 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(355871);
        throw ((Throwable)localObject1);
      }
      ((kotlin.g.b.ah.f)localObject3).aqH = ((RelativeLayout)localObject4);
      localObject4 = ((MMNeat7extView)((View)((kotlin.g.b.ah.f)localObject1).aqH).findViewById(p.e.live_comment_item_content_tv)).getParent();
      if (localObject4 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(355871);
        throw ((Throwable)localObject1);
      }
      ((RelativeLayout)localObject4).setPadding(0, ((RelativeLayout)((kotlin.g.b.ah.f)localObject3).aqH).getPaddingTop(), ((RelativeLayout)((kotlin.g.b.ah.f)localObject3).aqH).getPaddingRight(), ((RelativeLayout)((kotlin.g.b.ah.f)localObject3).aqH).getPaddingBottom());
      ((MMNeat7extView)((View)((kotlin.g.b.ah.f)localObject1).aqH).findViewById(p.e.live_comment_item_content_tv)).aZ((CharSequence)localObject2);
      ((View)((kotlin.g.b.ah.f)localObject1).aqH).setVisibility(0);
      ((View)((kotlin.g.b.ah.f)localObject1).aqH).post(new ah..ExternalSyntheticLambda10((kotlin.g.b.ah.f)localObject1, (kotlin.g.b.ah.f)localObject3, (com.tencent.mm.pluginsdk.ui.span.q)localObject2));
      ((View)((kotlin.g.b.ah.f)localObject1).aqH).postDelayed(new ah..ExternalSyntheticLambda7(this), 3000L);
      AppMethodBeat.o(355871);
      return;
    }
    op(0L);
    Object localObject2 = this.CXN;
    Object localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgF;
    kotlin.g.b.s.s(localObject3, "business(LiveMsgSlice::c…ss.java).bulletCommetList");
    ((com.tencent.mm.plugin.finder.live.widget.t)localObject2).ha((List)localObject3);
    ((View)((kotlin.g.b.ah.f)localObject1).aqH).setVisibility(4);
    AppMethodBeat.o(355871);
  }
  
  private final void t(Boolean paramBoolean)
  {
    AppMethodBeat.i(355799);
    com.tencent.mm.hellhoundlib.b.a locala;
    if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE))
    {
      paramBoolean = this.CXL;
      locala = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.k.qu(this.CXM.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBoolean, locala.aYi(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramBoolean.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBoolean, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    for (;;)
    {
      this.hqR = ((e)business(e.class)).EcM;
      AppMethodBeat.o(355799);
      return;
      paramBoolean = this.CXL;
      locala = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.k.qu(this.CXM.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBoolean, locala.aYi(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "scrollToPosition", "(I)V");
      paramBoolean.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBoolean, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "scrollToPosition", "(I)V");
    }
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(356284);
    Object localObject;
    if (paramBundle == null) {
      localObject = "";
    }
    for (;;)
    {
      if (kotlin.g.b.s.p(localObject, "PORTRAIT_ACTION_GOTO_PROFILE_COMMENT")) {
        com.tencent.mm.ae.d.a(paramLong, new ah..ExternalSyntheticLambda8(this, paramBundle, paramObject, paramLong));
      }
      AppMethodBeat.o(356284);
      return;
      String str = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(356197);
    kotlin.g.b.s.u(paramLinkedHashMap, "micUserMap");
    Log.i("Finder.LiveCommentPlugin", "onAudienceMicUserChanged commentAdapter micEnable true");
    paramLinkedHashMap = com.tencent.mm.plugin.finder.live.model.commentitem.h.CLk;
    com.tencent.mm.plugin.finder.live.model.commentitem.h.emS();
    AppMethodBeat.o(356197);
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(356290);
    super.aq(paramBundle);
    this.CXL.post(new ah..ExternalSyntheticLambda6(this));
    AppMethodBeat.o(356290);
  }
  
  public final void aql(int paramInt)
  {
    AppMethodBeat.i(371513);
    this.CXK.setMaxHeight(0);
    AppMethodBeat.o(371513);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(356211);
    if ((isLandscape()) || (this.CXU))
    {
      AppMethodBeat.o(356211);
      return true;
    }
    AppMethodBeat.o(356211);
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final MMHandler getHandler()
  {
    AppMethodBeat.i(356185);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(356185);
    return localMMHandler;
  }
  
  public final void i(List<aq> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(356230);
    kotlin.g.b.s.u(paramList, "msgList");
    if (paramBoolean)
    {
      int i;
      if (!((Collection)paramList).isEmpty())
      {
        i = 1;
        if (i != 0) {
          epR();
        }
        if (this.CXW) {
          break label156;
        }
        if (!this.CXL.isShown()) {
          break label140;
        }
        this.CXW = true;
      }
      label140:
      label156:
      while (this.CXL.isShown())
      {
        localMessage = getHandler().obtainMessage();
        localArrayList = new ArrayList();
        localArrayList.addAll((Collection)paramList);
        paramList = kotlin.ah.aiuX;
        localMessage.obj = localArrayList;
        localMessage.what = CXZ;
        getHandler().removeMessages(CXZ);
        getHandler().sendMessage(localMessage);
        AppMethodBeat.o(356230);
        return;
        i = 0;
        break;
        Log.i("Finder.LiveCommentPlugin", "updateMessages return ,RecyclerView is invisible");
        AppMethodBeat.o(356230);
        return;
      }
      this.CXW = false;
      Log.i("Finder.LiveCommentPlugin", "updateMessages return ,isMsgListViewVisible is not real.correct it");
      AppMethodBeat.o(356230);
      return;
    }
    Message localMessage = getHandler().obtainMessage();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = kotlin.ah.aiuX;
    localMessage.obj = localArrayList;
    localMessage.what = CYa;
    getHandler().removeMessages(CYa);
    getHandler().sendMessage(localMessage);
    AppMethodBeat.o(356230);
  }
  
  public final View ivt()
  {
    Object localObject2 = null;
    AppMethodBeat.i(371512);
    Object localObject3 = this.EjI;
    if (localObject3 != null)
    {
      localObject1 = ((LinearLayout)localObject3).getParent();
      Object localObject4;
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView((View)localObject3);
        }
        localObject4 = this.mJe.getParent();
        localObject1 = localObject2;
        if ((localObject4 instanceof ViewGroup)) {
          localObject1 = (ViewGroup)localObject4;
        }
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView((View)this.mJe);
        }
        localObject1 = new RelativeLayout(this.mJe.getContext());
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (-com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8));
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
        ((RelativeLayout.LayoutParams)localObject2).setMarginStart(-com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16));
        localObject4 = kotlin.ah.aiuX;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout)localObject1).addView((View)localObject3);
        localObject2 = this.mJe;
        localObject3 = new RelativeLayout.LayoutParams(this.mJe.getWidth(), -2);
        ((RelativeLayout.LayoutParams)localObject3).removeRule(2);
        localObject4 = this.EjI;
        if (localObject4 != null) {
          break label280;
        }
      }
      label280:
      for (int i = 0;; i = ((LinearLayout)localObject4).getId())
      {
        ((RelativeLayout.LayoutParams)localObject3).addRule(2, i);
        localObject4 = kotlin.ah.aiuX;
        ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RelativeLayout)localObject1).addView((View)this.mJe);
        localObject1 = (View)localObject1;
        AppMethodBeat.o(371512);
        return localObject1;
        localObject1 = null;
        break;
      }
    }
    Object localObject1 = (View)this.mJe;
    AppMethodBeat.o(371512);
    return localObject1;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(356303);
    if (!isLandscape())
    {
      paramConfiguration = bf.bf(this.mJe.getContext());
      if (paramConfiguration.x >= paramConfiguration.y / 3 * 2)
      {
        localLayoutParams = this.mJe.getLayoutParams();
        localLayoutParams.width = (paramConfiguration.x / 2);
        this.mJe.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(356303);
        return;
      }
      paramConfiguration = (com.tencent.mm.plugin.finder.live.component.msginterceptor.c)getBuContext().business(com.tencent.mm.plugin.finder.live.component.msginterceptor.c.class);
      int i = bf.bf(MMApplicationContext.getContext()).x;
      ViewGroup.LayoutParams localLayoutParams = this.mJe.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramConfiguration = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(356303);
        throw paramConfiguration;
      }
      int j = ((ViewGroup.MarginLayoutParams)localLayoutParams).getMarginStart();
      localLayoutParams = this.mJe.getLayoutParams();
      if (localLayoutParams == null)
      {
        paramConfiguration = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(356303);
        throw paramConfiguration;
      }
      paramConfiguration.CBG = (i - j - ((ViewGroup.MarginLayoutParams)localLayoutParams).getMarginEnd());
    }
    AppMethodBeat.o(356303);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(356278);
    this.CXM.nnY.clear();
    this.CXM.bZE.notifyChanged();
    AppMethodBeat.o(356278);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    int i = 1;
    boolean bool1 = false;
    AppMethodBeat.i(356258);
    kotlin.g.b.s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        AppMethodBeat.o(356258);
        return;
        if (((e)business(e.class)).Ect) {
          if ((paramBundle == null) || (paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW") != true)) {
            break label177;
          }
        }
        for (;;)
        {
          if ((i != 0) || (isLandscape()))
          {
            paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
            kotlin.g.b.s.s(paramc, "business(LiveMsgSlice::class.java).msgList");
            gy(paramc);
          }
          this.CXX = System.currentTimeMillis();
          AppMethodBeat.o(356258);
          return;
          i = 0;
        }
        if (paramBundle == null)
        {
          i = 0;
          if (i <= 0) {
            break label323;
          }
          bool1 = true;
          this.CXP = bool1;
          this.CXQ = i;
          Log.i("Finder.LiveCommentPlugin", "comment move distance:" + i + ",has change:" + this.aKS);
          if (((this.aKS) || (i <= 0)) && ((!this.aKS) || (i >= 0))) {
            break label357;
          }
          if (this.aKS) {
            break label329;
          }
        }
        for (bool1 = bool2;; bool1 = false)
        {
          this.aKS = bool1;
          paramc = this.mJe.getLayoutParams();
          if (paramc != null) {
            break label335;
          }
          paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(356258);
          throw paramc;
          i = paramBundle.getInt("PARAM_FINDER_LIVE_COMMENT_MOVE_DISTANCE");
          break;
          bool1 = false;
          break label195;
        }
        paramc = (ViewGroup.MarginLayoutParams)paramc;
        paramc.bottomMargin += i;
        this.mJe.requestLayout();
        AppMethodBeat.o(356258);
        return;
      } while (paramBundle == null);
      paramc = paramBundle.getString("PARAM_FINDER_LIVE_COMMENT");
      if (paramc == null) {
        paramc = "";
      }
      for (;;)
      {
        paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
        kotlin.g.b.s.s(paramBundle, "business(LiveMsgSlice::class.java).msgList");
        p.e(paramBundle, (kotlin.g.a.b)new g(paramc));
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this));
        AppMethodBeat.o(356258);
        return;
      }
    case 5: 
      bjj();
      t(Boolean.TRUE);
      AppMethodBeat.o(356258);
      return;
    case 6: 
      AppMethodBeat.o(356258);
      return;
    case 7: 
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
      AppMethodBeat.o(356258);
      return;
    case 8: 
      if (paramBundle == null) {}
      while (bool1)
      {
        epQ();
        AppMethodBeat.o(356258);
        return;
        bool1 = paramBundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR");
      }
      paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE;
      kotlin.g.b.s.s(paramc, "business(LiveMsgSlice::class.java).msgList");
      gy(paramc);
      AppMethodBeat.o(356258);
      return;
    case 9: 
      label177:
      label195:
      label329:
      label335:
      label357:
      epQ();
      label323:
      AppMethodBeat.o(356258);
      return;
    }
    if (paramBundle == null)
    {
      bool1 = false;
      label572:
      if (bool1) {
        break label602;
      }
    }
    label602:
    for (bool1 = bool3;; bool1 = false)
    {
      this.CXU = bool1;
      break;
      bool1 = paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
      break label572;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(356269);
    super.tO(paramInt);
    AppMethodBeat.o(356269);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(356204);
    super.unMount();
    com.tencent.mm.plugin.finder.view.i locali = com.tencent.mm.plugin.finder.view.i.GzZ;
    com.tencent.mm.plugin.finder.view.i.fkK();
    epQ();
    this.CXU = true;
    this.CXW = true;
    AppMethodBeat.o(356204);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "enable"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<Boolean, Boolean, kotlin.ah>
  {
    d(ah paramah)
    {
      super();
    }
    
    private static final void fX(View paramView)
    {
      AppMethodBeat.i(353894);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(p.g.icons_filled_error);
        }
      }
      AppMethodBeat.o(353894);
    }
    
    private static final void invoke$lambda-0(View paramView)
    {
      AppMethodBeat.i(353883);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(p.g.icons_filled_done);
        }
      }
      AppMethodBeat.o(353883);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    e(ah paramah)
    {
      super();
    }
    
    private static final boolean a(ah paramah, Message paramMessage)
    {
      AppMethodBeat.i(353872);
      kotlin.g.b.s.u(paramah, "this$0");
      kotlin.g.b.s.u(paramMessage, "it");
      int i = paramMessage.what;
      ah.a locala = ah.CXJ;
      if (i == ah.epU())
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramah = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> }");
          AppMethodBeat.o(353872);
          throw paramah;
        }
        ah.b(paramah, (List)paramMessage);
      }
      for (;;)
      {
        AppMethodBeat.o(353872);
        return true;
        locala = ah.CXJ;
        if (i == ah.epV())
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramah = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> }");
            AppMethodBeat.o(353872);
            throw paramah;
          }
          ah.d(paramah, (List)paramMessage);
        }
        else
        {
          locala = ah.CXJ;
          if (i == ah.epW())
          {
            paramMessage = paramMessage.obj;
            if (paramMessage == null)
            {
              paramah = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> }");
              AppMethodBeat.o(353872);
              throw paramah;
            }
            ah.e(paramah, (List)paramMessage);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.m<bpp, aux, kotlin.ah>
  {
    f(ah paramah, String paramString)
    {
      super();
    }
    
    private static final void fX(View paramView)
    {
      AppMethodBeat.i(354042);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(p.g.icons_filled_error);
        }
      }
      AppMethodBeat.o(354042);
    }
    
    private static final void invoke$lambda-0(View paramView)
    {
      AppMethodBeat.i(354033);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(p.g.icons_filled_done);
        }
      }
      AppMethodBeat.o(354033);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<aq, Boolean>
  {
    g(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    h(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final i CYe;
    
    static
    {
      AppMethodBeat.i(354035);
      CYe = new i();
      AppMethodBeat.o(354035);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.r<Integer, Integer, String, bsq, kotlin.ah>
  {
    j(ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<aq, Boolean>
  {
    public static final k CYf;
    
    static
    {
      AppMethodBeat.i(353970);
      CYf = new k();
      AppMethodBeat.o(353970);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$updateComments$2", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements androidx.recyclerview.widget.q
  {
    l(ah paramah, List<aq> paramList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(354039);
      ah.f(this.CYc).nnY.clear();
      ah.f(this.CYc).nnY.addAll((Collection)paramList);
      ah.f(this.CYc).bA(paramInt1, paramInt2);
      AppMethodBeat.o(354039);
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(354045);
      ah.f(this.CYc).nnY.clear();
      ah.f(this.CYc).nnY.addAll((Collection)paramList);
      ah.f(this.CYc).bB(paramInt1, paramInt2);
      AppMethodBeat.o(354045);
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(354028);
      ah.f(this.CYc).bz(paramInt1, paramInt2);
      AppMethodBeat.o(354028);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(354018);
      ah.f(this.CYc).nnY.clear();
      ah.f(this.CYc).nnY.addAll((Collection)paramList);
      ah.f(this.CYc).by(paramInt1, paramInt2);
      AppMethodBeat.o(354018);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$updateComments$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends androidx.recyclerview.widget.g.a
  {
    m(ah paramah, List<aq> paramList) {}
    
    public final int If()
    {
      AppMethodBeat.i(354006);
      int i = ah.f(this.CYc).nnY.size();
      AppMethodBeat.o(354006);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(354013);
      int i = paramList.size();
      AppMethodBeat.o(354013);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(354017);
      boolean bool = kotlin.g.b.s.p(p.ae((List)ah.f(this.CYc).nnY, paramInt1), p.ae(paramList, paramInt2));
      AppMethodBeat.o(354017);
      return bool;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(354023);
      boolean bool = kotlin.g.b.s.p(p.ae((List)ah.f(this.CYc).nnY, paramInt1), p.ae(paramList, paramInt2));
      AppMethodBeat.o(354023);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ah
 * JD-Core Version:    0.7.0.1
 */