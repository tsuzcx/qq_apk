package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.p.a;
import com.tencent.mm.model.p.f;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ai;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aj;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ak;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.av;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.t;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.x;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.eni;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/view/View$OnCreateContextMenuListener;", "mContext", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "list", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "keepPos", "", "keepData", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "bizTimeLineHotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;Ljava/util/List;ZZLcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;)V", "avatarClickListener", "Landroid/view/View$OnClickListener;", "bizTimeLineImgLoader", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizTimeLineImgLoader;", "bizTimeLineItemClickCallback", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/IBizTimeLineItemClickCallback;", "canGetRecommendFeed", "expandedReaderItem", "", "Lcom/tencent/mm/message/BizReaderItem;", "firstItem", "getFirstItem", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "isAllSameGroupData", "()Z", "isPause", "items", "getItems", "()Ljava/util/List;", "getKeepData", "lastItem", "getLastItem", "getList", "getMContext", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "mInfo", "mKeepPos", "mList", "", "getMList", "mMessageIndex", "", "mRecList", "menuItemSelectedListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineMMMenuItemListener;", "newMsgLineItem", "noMoreData", "getNoMoreData", "setNoMoreData", "(Z)V", "onBizInfoChange", "Lcom/tencent/mm/storage/BizTimeLineInfoStorage$IOnBizInfoChange;", "refreshRecFeedTimesOnBizBack", "smallestGroupId", "", "talkerSet", "", "checkNoMoreData", "", "checkList", "checkPreload", "startPos", "endPos", "checkRefreshFirstScreenData", "clickRecCardReport", "info", "messageIndex", "deleteRecFeed", "id", "deleteUnExposeRecFeed", "deleteInfo", "doUpdateListCellPosition", "enterSession", "taker", "feedToBizTimeLineInfo", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "fillingBizMsg", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "fillingCanvas", "fillingCommInfo", "topLayout", "newTipsLayout", "fillingNewMsgLine", "fillingRecCard", "fillingRecFeed", "fillingTextMsg", "fillingUnknownMsg", "filterAndAddList", "originList", "filterMsg", "getCount", "getFirstUnExposePos", "start", "getItem", "getItemId", "getItemViewType", "getMsgItemCount", "getView", "getViewInternal", "getViewTypeCount", "initHeader", "slot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineItem;", "initRecommendFeeds", "isEmpty", "isShowNewTips", "pos", "loadMoreData", "notifyDataSetChanged", "onAppMsgClick", "url", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDataChange", "stg", "", "notifyInfo", "Lcom/tencent/mm/storage/BizTimeLineInfoStorage$BizNotifyInfo;", "onDestroy", "onExpand", "onFeedBack", "onGetRecommendFeedFail", "onPause", "onRecFeedItemClick", "onResume", "refreshRecFeedData", "resetKeep", "resetList", "resetNewMsgStatus", "resetNoMoreData", "resetSmallestGroupId", "setCommonAction", "item", "reader", "Lcom/tencent/mm/message/BizMMReader;", "clickView", "multiMsg", "showMoreMenu", "switchToMsgMode", "updateGroupId", "updateList", "updateListCellPosition", "updateNewMsgLine", "Companion", "ItemViewType", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BaseAdapter
  implements View.OnCreateContextMenuListener
{
  public static final a vFE;
  static boolean vFY;
  static long vFZ;
  public static int vGa;
  public static int vGb;
  public static int vGc;
  public static int vGd;
  public static int vGe;
  public static int vGf;
  public static int vGg;
  private static int vGh;
  public static int vGi;
  public static int vGj;
  public static int vGk;
  public static int vGl;
  public static int vGm;
  public static int vGn;
  private static Long vGo;
  private static Long vGp;
  private static boolean vGq;
  private static boolean vGr;
  public final List<ab> eXW;
  boolean hJi;
  private final List<ab> list;
  final ac.c vAF;
  final BizTimeLineUI vFF;
  private final boolean vFG;
  public List<ab> vFH;
  private final ab vFI;
  public ab vFJ;
  public f vFK;
  public int vFL;
  public BizTimeLineHotView vFM;
  public com.tencent.mm.plugin.brandservice.ui.timeline.preload.d vFN;
  private final ak vFO;
  private long vFP;
  boolean vFQ;
  private final Set<String> vFR;
  public Set<com.tencent.mm.message.v> vFS;
  int vFT;
  private final View.OnClickListener vFU;
  private final i vFV;
  private boolean vFW;
  private boolean vFX;
  
  static
  {
    AppMethodBeat.i(302184);
    vFE = new a((byte)0);
    AppMethodBeat.o(302184);
  }
  
  public b(BizTimeLineUI paramBizTimeLineUI, List<? extends ab> paramList, boolean paramBoolean1, boolean paramBoolean2, f paramf, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(301889);
    this.vFF = paramBizTimeLineUI;
    this.list = paramList;
    this.vFG = paramBoolean2;
    this.eXW = ((List)new LinkedList());
    this.vFH = ((List)new LinkedList());
    paramBizTimeLineUI = new ab();
    paramBizTimeLineUI.hAN = 1;
    paramList = kotlin.ah.aiuX;
    this.vFI = paramBizTimeLineUI;
    this.vFK = paramf;
    this.vFP = -1L;
    this.vFR = ((Set)new HashSet());
    this.vFS = ((Set)new HashSet());
    this.vAF = new b..ExternalSyntheticLambda8(this);
    this.vFU = new b..ExternalSyntheticLambda2(this, paramf);
    this.vFV = new b..ExternalSyntheticLambda7(paramf, paramBizTimeLineHotView, this);
    this.vFX = true;
    vGq = false;
    vGr = false;
    dcU();
    er(this.list);
    this.vFM = paramBizTimeLineHotView;
    vGe = this.vFF.getResources().getDimensionPixelSize(d.c.biz_time_line_sub_item_pic_size);
    vGf = this.vFF.getResources().getDimensionPixelSize(d.c.biz_time_line_item_padding_bottom);
    vGg = this.vFF.getResources().getDimensionPixelSize(d.c.LargePadding);
    vGh = this.vFF.getResources().getDimensionPixelSize(d.c.MiddlePadding);
    vGj = this.vFF.getResources().getDimensionPixelSize(d.c.biz_time_line_top_line_big_padding);
    vGk = this.vFF.getResources().getDimensionPixelOffset(d.c.LargePadding);
    vGi = this.vFF.getResources().getDimensionPixelOffset(d.c.NormalPadding);
    vGl = com.tencent.mm.cd.a.fromDPToPix((Context)this.vFF, 2);
    vGn = com.tencent.mm.cd.a.fromDPToPix((Context)this.vFF, 40);
    vGm = com.tencent.mm.cd.a.fromDPToPix((Context)this.vFF, 8);
    paramBizTimeLineUI = ao.mX((Context)this.vFF);
    int j = paramBizTimeLineUI.width;
    int k = paramBizTimeLineUI.height;
    if (j < k) {}
    for (int i = j;; i = k)
    {
      int m = i - (int)(com.tencent.mm.cd.a.getDensity((Context)this.vFF) * 16.0F);
      i -= (int)(com.tencent.mm.cd.a.getDensity((Context)this.vFF) * 16.0F * 2.0F);
      Log.i("MicroMsg.BizTimeLineAdapter", "screen width = %d, screen height = %d, cover width = %d, cover width for feed = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
      vGa = (int)(m / 2.35F);
      vGb = (int)(i / 2.35F);
      vGc = (int)(m / 1.777778F);
      vGd = (int)(i / 1.777778F);
      com.tencent.mm.an.af.bHl().a(this.vAF, Looper.getMainLooper());
      ep(this.list);
      eq(this.list);
      this.vFQ = paramBoolean1;
      dcK();
      this.vFN = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.d(this.vFF, this.eXW, this.vFH);
      this.vFO = new ak(this, (Context)this.vFF);
      com.tencent.mm.plugin.brandservice.ui.timeline.item.k.ddt();
      AppMethodBeat.o(301889);
      return;
    }
  }
  
  private void Hl(int paramInt)
  {
    AppMethodBeat.i(301962);
    if ((paramInt == getCount() - 1) && (!this.vFW)) {
      com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda12(paramInt, this));
    }
    AppMethodBeat.o(301962);
  }
  
  private static final Boolean a(long paramLong, Long paramLong1)
  {
    AppMethodBeat.i(301991);
    boolean bool = com.tencent.mm.storage.ad.yV(paramLong);
    AppMethodBeat.o(301991);
    return Boolean.valueOf(bool);
  }
  
  private static final Void a(b paramb, Boolean paramBoolean)
  {
    AppMethodBeat.i(302001);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.s(paramBoolean, "aBoolean");
    if (paramBoolean.booleanValue()) {
      paramb.vFF.ddk();
    }
    AppMethodBeat.o(302001);
    return null;
  }
  
  private static final void a(int paramInt, com.tencent.mm.message.v paramv, b paramb, ab paramab, View paramView)
  {
    AppMethodBeat.i(302030);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramv);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramv, "$item");
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    if (paramInt == 0)
    {
      paramView = MPVideoPreviewMgr.vXs;
      MPVideoPreviewMgr.ajU(paramv.vid);
    }
    int j = (int)(System.currentTimeMillis() / 1000L);
    if (!Util.isNullOrNil(paramv.nVi))
    {
      paramView = SemiXml.decode(paramv.nVi);
      if (paramView == null) {
        break label289;
      }
      if (paramInt != 0) {
        break label280;
      }
    }
    label280:
    for (localObject1 = "";; localObject1 = String.valueOf(paramInt))
    {
      localObject1 = kotlin.g.b.s.X(".msg.appmsg.mmreader.category.item", localObject1);
      localObject2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(26, 2, 25, null);
      if (!((br)com.tencent.mm.kernel.h.ax(br.class)).a((Context)paramb.vFF, (String)localObject1, paramView, (String)localObject2)) {
        break label289;
      }
      Log.i("MicroMsg.BizTimeLineAdapter", "biz enter finder logic");
      paramb.vFV.onClick(paramab, paramv.url, paramInt, j);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302030);
      return;
      paramView = null;
      break;
    }
    label289:
    paramView = new Bundle();
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramab.field_talker);
    if ((localObject1 != null) && (!com.tencent.mm.contact.d.rs(((az)localObject1).field_type))) {}
    for (int i = 157;; i = 90)
    {
      paramView.putInt("biz_video_scene", i);
      i = paramb.vFF.getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      paramView.putInt(f.b.adwc, i);
      paramView.putInt("geta8key_scene", 56);
      localObject1 = MPVideoPreviewMgr.vXs;
      paramView.putString("biz_video_autoplay_id", MPVideoPreviewMgr.ajY(paramv.vid));
      paramView.putString("webpageTitle", paramv.title);
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
      com.tencent.mm.plugin.webview.ui.tools.video.a.bmO(paramv.vid);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b.a((Context)paramb.vFF, paramab.field_msgId, paramab.field_msgSvrId, paramInt, paramView);
      paramb.vFV.onClick(paramab, paramv.url, paramInt, j);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302030);
      return;
    }
  }
  
  private static final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(302084);
    kotlin.g.b.s.u(paramb, "this$0");
    if ((paramInt == paramb.getCount() - 1) && (!paramb.vFW))
    {
      Log.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramb.getCount()) });
      if (!paramb.dcT())
      {
        paramb.dcR();
        AppMethodBeat.o(302084);
        return;
      }
      if (!a.dcY()) {
        paramb.vFN.onLoadMore();
      }
    }
    AppMethodBeat.o(302084);
  }
  
  private static final void a(int paramInt, b paramb, View paramView)
  {
    AppMethodBeat.i(302011);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    Log.i("MicroMsg.BizTimeLineAdapter", "switchToMsgMode");
    paramView = com.tencent.mm.model.o.ojb;
    com.tencent.mm.model.o.ir(11L);
    paramView = com.tencent.mm.model.o.ojb;
    com.tencent.mm.model.o.ez(1, paramInt);
    paramb.dcL();
    paramb.notifyDataSetChanged();
    paramView = com.tencent.mm.plugin.brandservice.model.a.vBp;
    com.tencent.mm.plugin.brandservice.model.a.a(paramb.vFF.vHR, paramb);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302011);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(302094);
    kotlin.g.b.s.u(paramb, "this$0");
    eq(paramb.eXW);
    AppMethodBeat.o(302094);
  }
  
  private static final void a(b paramb, f paramf, View paramView)
  {
    int j = 0;
    AppMethodBeat.i(302070);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramf, "$report");
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.storage.BizTimeLineInfo");
      AppMethodBeat.o(302070);
      throw paramb;
    }
    localObject1 = (ab)paramView;
    paramView = ((ab)localObject1).field_talker;
    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((ab)localObject1).field_talker);
    int i;
    Object localObject3;
    if ((!((ab)localObject1).iYf()) && (localObject2 != null) && (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type)))
    {
      i = 1;
      localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b.vPq;
      boolean bool = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b.dex();
      if ((i != 0) || (bool)) {
        j = 1;
      }
      if (j == 0) {
        break label365;
      }
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Contact_User", paramView);
      if (i == 0) {
        break label350;
      }
      ((Intent)localObject3).putExtra("Contact_Scene", 174);
      label235:
      ((Intent)localObject3).putExtra("force_get_contact", true);
      ((Intent)localObject3).putExtra("key_use_new_contact_profile", true);
      if (!Util.isNullOrNil(((az)localObject2).field_username)) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxO(((az)localObject2).field_username);
      }
      com.tencent.mm.br.c.b((Context)paramb.vFF, "profile", ".ui.ContactInfoUI", (Intent)localObject3);
      paramf.d((ab)localObject1, 1);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302070);
      return;
      i = 0;
      break;
      label350:
      ((Intent)localObject3).putExtra("Contact_Scene", 227);
      break label235;
      label365:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Chat_User", paramView);
      ((Intent)localObject2).putExtra("finish_direct", true);
      ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 90);
      ((Intent)localObject2).putExtra("specific_chat_from_scene", 2);
      ((Intent)localObject2).putExtra("preChatTYPE", 11);
      com.tencent.mm.br.c.g((Context)paramb.vFF, ".ui.chatting.ChattingUI", (Intent)localObject2);
      paramf.d((ab)localObject1, 9);
      paramb = com.tencent.mm.plugin.brandservice.model.d.vBI;
      com.tencent.mm.plugin.brandservice.model.d.w(3, paramView, "");
    }
  }
  
  private static final void a(b paramb, al paramal, int paramInt, View paramView)
  {
    AppMethodBeat.i(302018);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramal);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramal, "$item");
    Log.i("MicroMsg.BizTimeLineAdapter", "refresh RecFeed click");
    a.a(paramb, p.f.ojw, false, null, 12);
    paramal.progressBar.setVisibility(0);
    paramb = com.tencent.mm.model.o.ojb;
    com.tencent.mm.model.o.eA(1, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302018);
  }
  
  private static final void a(b paramb, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(302054);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    ab localab = paramb.vFJ;
    kotlin.g.b.s.checkNotNull(localab);
    localObject = ((bx)localObject).JE(localab.field_talker);
    params.oh(10, d.i.biz_time_line_delete_msg);
    if ((localObject != null) && (com.tencent.mm.contact.d.rs(((az)localObject).field_type))) {
      params.a(2, paramb.vFF.getResources().getColor(d.b.Red), (CharSequence)paramb.vFF.getString(d.i.main_conversation_longclick_delete_biz_service));
    }
    AppMethodBeat.o(302054);
  }
  
  private static final void a(b paramb, final Object paramObject, final ac.a parama)
  {
    AppMethodBeat.i(301985);
    kotlin.g.b.s.u(paramb, "this$0");
    if ((parama != null) && (parama.acFY))
    {
      AppMethodBeat.o(301985);
      return;
    }
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new d(paramb, paramObject, parama));
    AppMethodBeat.o(301985);
  }
  
  private static final void a(f paramf, BizTimeLineHotView paramBizTimeLineHotView, b paramb, ab paramab, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302078);
    kotlin.g.b.s.u(paramf, "$report");
    kotlin.g.b.s.u(paramBizTimeLineHotView, "$bizTimeLineHotView");
    kotlin.g.b.s.u(paramb, "this$0");
    paramf.d(paramab, paramInt1, paramInt2);
    paramBizTimeLineHotView.o(paramab);
    kotlin.g.b.s.s(paramab, "info");
    kotlin.g.b.s.u(paramab, "info");
    paramf = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramab, paramString, a.a.vNS);
    AppMethodBeat.o(302078);
  }
  
  private static final void a(ab paramab, b paramb, View paramView)
  {
    AppMethodBeat.i(302036);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramab);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramab, "$info");
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = com.tencent.mm.pluginsdk.model.c.XPt;
    com.tencent.mm.pluginsdk.model.c.b(paramab.field_talker, paramab);
    paramab.acFB = true;
    paramView = com.tencent.mm.pluginsdk.model.c.XPt;
    int i = com.tencent.mm.pluginsdk.model.c.bpj(paramab.field_talker);
    com.tencent.mm.pluginsdk.model.c.a(com.tencent.mm.pluginsdk.model.c.XPt, (Context)paramb.vFF, paramab.field_talker, null, 3, i);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302036);
  }
  
  private static final boolean a(b paramb, ab paramab, View paramView)
  {
    AppMethodBeat.i(302042);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    paramb.vFJ = paramab;
    paramb.vFK.d(paramb.vFJ, 20);
    paramb.dcM();
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(302042);
    return false;
  }
  
  private final boolean a(ab paramab, int paramInt)
  {
    AppMethodBeat.i(5874);
    if (a.dcY())
    {
      AppMethodBeat.o(5874);
      return false;
    }
    if (vGo != null)
    {
      localObject = vGo;
      l1 = paramab.field_orderFlag;
      if (localObject == null) {}
      while (((Long)localObject).longValue() != l1)
      {
        AppMethodBeat.o(5874);
        return false;
      }
      AppMethodBeat.o(5874);
      return true;
    }
    long l2 = paramab.iYa();
    long l1 = 0L;
    Object localObject = Hk(paramInt - 1);
    if (localObject != null) {
      l1 = ((ab)localObject).iYa();
    }
    if ((l2 != l1) && (vGp != null))
    {
      localObject = vGp;
      if (localObject != null) {
        break label126;
      }
    }
    label126:
    while (l1 != ((Long)localObject).longValue())
    {
      AppMethodBeat.o(5874);
      return false;
    }
    vGo = Long.valueOf(paramab.field_orderFlag);
    AppMethodBeat.o(5874);
    return true;
  }
  
  private static final void b(b paramb, ab paramab, View paramView)
  {
    AppMethodBeat.i(302049);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    paramb.vFJ = paramab;
    paramb.vFK.d(paramb.vFJ, 19);
    paramb.dcM();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302049);
  }
  
  private final boolean c(ab paramab)
  {
    Object localObject2 = null;
    AppMethodBeat.i(301914);
    Object localObject1;
    ab localab;
    if (paramab == null)
    {
      localObject1 = null;
      localab = dcO();
      if (localab != null) {
        break label52;
      }
    }
    for (;;)
    {
      if (kotlin.g.b.s.p(localObject1, localObject2)) {
        break label64;
      }
      AppMethodBeat.o(301914);
      return false;
      localObject1 = Long.valueOf(paramab.iYa());
      break;
      label52:
      localObject2 = Long.valueOf(localab.iYa());
    }
    label64:
    if ((paramab == null) || (paramab.field_type == 34) || (paramab.field_type == 3))
    {
      AppMethodBeat.o(301914);
      return true;
    }
    AppMethodBeat.o(301914);
    return false;
  }
  
  private final void dcK()
  {
    AppMethodBeat.i(5866);
    dcP();
    if (a.dcY())
    {
      AppMethodBeat.o(5866);
      return;
    }
    if (this.vFQ)
    {
      Object localObject = dcO();
      if ((localObject != null) && (!((ab)localObject).iYm()))
      {
        localObject = this.eXW.iterator();
        ab localab;
        for (long l = -1L; ((Iterator)localObject).hasNext(); l = localab.iYa())
        {
          localab = (ab)((Iterator)localObject).next();
          if ((l != -1L) && (l != localab.iYa()))
          {
            vGo = Long.valueOf(localab.field_orderFlag);
            AppMethodBeat.o(5866);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(5866);
  }
  
  private final void dcL()
  {
    AppMethodBeat.i(301928);
    com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mT(false);
    int i = this.eXW.size();
    if (!dcT())
    {
      dcR();
      AppMethodBeat.o(301928);
      return;
    }
    if (this.eXW.size() > i)
    {
      if (i > 0) {
        vGo = Long.valueOf(((ab)this.eXW.get(i)).field_orderFlag);
      }
      dcS();
    }
    AppMethodBeat.o(301928);
  }
  
  private final void dcQ()
  {
    ab localab = null;
    AppMethodBeat.i(5886);
    Cursor localCursor = com.tencent.mm.an.af.bHl().omV.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null);
    if (localCursor.moveToFirst())
    {
      localab = new ab();
      localab.convertFrom(localCursor);
    }
    localCursor.close();
    if (localab != null) {
      this.vFP = localab.iYa();
    }
    AppMethodBeat.o(5886);
  }
  
  private final void dcR()
  {
    AppMethodBeat.i(301949);
    this.vFW = true;
    this.vFF.dcR();
    AppMethodBeat.o(301949);
  }
  
  private final void dcS()
  {
    AppMethodBeat.i(301954);
    this.vFW = false;
    this.vFF.dcS();
    AppMethodBeat.o(301954);
  }
  
  private boolean dcT()
  {
    int j = 0;
    AppMethodBeat.i(301967);
    if (a.dcY())
    {
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ddZ())
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
        AppMethodBeat.o(301967);
        return true;
      }
    }
    Object localObject1 = com.tencent.mm.an.af.bHl();
    Object localObject2 = dcN();
    long l;
    if (localObject2 == null)
    {
      l = 9223372036854775807L;
      localObject2 = ((com.tencent.mm.storage.ac)localObject1).bp(10, l);
      if (!com.tencent.mm.storage.ad.iYS()) {
        break label237;
      }
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ddY()) {
        break label237;
      }
      localObject1 = (Collection)localObject2;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label232;
      }
    }
    label232:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!this.vFX)) {
        break label237;
      }
      localObject1 = (Collection)this.vFH;
      if (localObject1 != null)
      {
        i = j;
        if (!((Collection)localObject1).isEmpty()) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
      }
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mT(true);
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mV(true);
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mU(true);
      notifyDataSetChanged();
      Log.i("MicroMsg.BizTimeLineAdapter", "loadMoreData allMsgEnd");
      AppMethodBeat.o(301967);
      return true;
      l = ((ab)localObject2).field_orderFlag;
      break;
    }
    label237:
    localObject1 = localObject2;
    if (a.dcY())
    {
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      localObject1 = localObject2;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ddZ())
      {
        localObject1 = (Collection)localObject2;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label402;
        }
        i = 1;
        if (i == 0)
        {
          l = ((ab)((List)localObject2).get(((List)localObject2).size() - 1)).iYa();
          localObject1 = dcO();
          if ((localObject1 == null) || (l != ((ab)localObject1).iYa())) {
            break label407;
          }
          i = 1;
          label336:
          if (i != 0) {
            break label412;
          }
        }
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mU(true);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      kotlin.g.b.s.s(localObject1, "list");
      ep((List)localObject1);
      com.tencent.mm.plugin.brandservice.ui.b.d.a((List)localObject1, new b..ExternalSyntheticLambda13(this));
      notifyDataSetChanged();
      if (((List)localObject1).size() <= 0) {
        break label491;
      }
      AppMethodBeat.o(301967);
      return true;
      label402:
      i = 0;
      break;
      label407:
      i = 0;
      break label336;
      label412:
      localObject1 = com.tencent.mm.model.p.ojc;
      i = p.a.bAr();
      localObject1 = localObject2;
      if (((List)localObject2).size() + this.eXW.size() >= i)
      {
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mU(true);
        kotlin.g.b.s.s(localObject2, "list");
        localObject1 = kotlin.a.p.c((Iterable)localObject2, kotlin.k.k.qu(i - this.eXW.size(), 1));
      }
    }
    label491:
    AppMethodBeat.o(301967);
    return false;
  }
  
  private final void dcU()
  {
    boolean bool2 = false;
    AppMethodBeat.i(301979);
    if (!com.tencent.mm.storage.ad.iYS())
    {
      AppMethodBeat.o(301979);
      return;
    }
    vFZ = 0L;
    Object localObject1;
    int i;
    label114:
    Object localObject2;
    if (!this.vFG)
    {
      vFY = false;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mT(true);
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      if (this.list.size() < 10)
      {
        bool1 = true;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mU(bool1);
        i = com.tencent.mm.an.af.bHl().dWF();
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        if (this.list.size() != i) {
          break label273;
        }
        localObject1 = com.tencent.mm.model.p.ojc;
        if (i > kotlin.k.k.qv(p.a.bAr(), 10)) {
          break label273;
        }
        bool1 = true;
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mV(bool1);
        localObject1 = new StringBuilder("initRecommendFeeds firstGroupEnd=");
        localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ddZ()).append(", allMsgEnd=");
        localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        Log.i("MicroMsg.BizTimeLineAdapter", com.tencent.mm.plugin.brandservice.ui.timeline.a.a.dea());
        label173:
        localObject1 = com.tencent.mm.model.p.ojc;
        localObject1 = p.a.bAz();
        bool1 = bool2;
        if (localObject1 != null)
        {
          localObject1 = ((cra)localObject1).aaxG;
          if (localObject1 != null) {
            break label334;
          }
          localObject1 = null;
          label205:
          localObject2 = (Collection)localObject1;
          if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
            break label427;
          }
          i = 1;
          label229:
          if (i != 0) {
            break label432;
          }
          es((List)localObject1);
          Log.i("MicroMsg.BizTimeLineAdapter", "initRecommendFeeds use save data");
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      a.a(this, p.f.oju, bool1, null, 8);
      AppMethodBeat.o(301979);
      return;
      bool1 = false;
      break;
      label273:
      bool1 = false;
      break label114;
      localObject1 = com.tencent.mm.model.p.ojc;
      localObject1 = com.tencent.mm.model.p.bAv();
      localObject2 = (Collection)localObject1;
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (i = 1; i == 0; i = 0)
      {
        this.vFH = ((List)localObject1);
        AppMethodBeat.o(301979);
        return;
      }
      break label173;
      label334:
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        ene localene = (ene)localObject3;
        kotlin.g.b.s.s(localene, "card");
        if (com.tencent.mm.storage.ah.c(localene)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      break label205;
      label427:
      i = 0;
      break label229;
      label432:
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.mT(false);
    }
  }
  
  private static void eo(List<? extends ab> paramList)
  {
    AppMethodBeat.i(5867);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(5867);
      return;
    }
    Log.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition list: %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = System.currentTimeMillis();
    Object localObject = (ab)paramList.get(0);
    ((ab)localObject).vMB = 1;
    int n = paramList.size();
    int i;
    int j;
    if (1 < n)
    {
      i = 1;
      j = 1;
    }
    for (;;)
    {
      int k = i + 1;
      ab localab = (ab)paramList.get(i);
      switch (((ab)localObject).field_type)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        j += i;
        localab.vMB = j;
        if (k < n) {
          break;
        }
        Log.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition cost: %d, startCellPosition: %d, size: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(1), Integer.valueOf(paramList.size()) });
        AppMethodBeat.o(5867);
        return;
        int m = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).d(((ab)localObject).field_msgId, ((ab)localObject).field_content);
        i = m;
        if (!((ab)localObject).field_isExpand)
        {
          i = Math.min(m, 2);
          continue;
          i = 1;
        }
      }
      i = k;
      localObject = localab;
    }
  }
  
  private final void ep(List<? extends ab> paramList)
  {
    AppMethodBeat.i(5882);
    List localList = (List)new LinkedList();
    int k = paramList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!c((ab)paramList.get(i))) {
        localList.add(paramList.get(i));
      }
      if (j > k)
      {
        this.eXW.addAll((Collection)localList);
        Log.i("MicroMsg.BizTimeLineAdapter", "alvinluo filterAndAddList size: %d/%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(localList.size()) });
        AppMethodBeat.o(5882);
        return;
      }
    }
  }
  
  public static void eq(List<? extends ab> paramList)
  {
    AppMethodBeat.i(5883);
    com.tencent.mm.pluginsdk.ui.applet.g localg = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
    if (com.tencent.mm.pluginsdk.ui.applet.g.awm(1)) {
      eo(paramList);
    }
    AppMethodBeat.o(5883);
  }
  
  private final void er(List<? extends ab> paramList)
  {
    AppMethodBeat.i(301945);
    paramList = (Collection)paramList;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      i = 1;
      if (i != 0) {
        if (a.dcY())
        {
          paramList = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.dea()) {
            break label89;
          }
          paramList = (Collection)this.vFH;
          if ((paramList != null) && (!paramList.isEmpty())) {
            break label101;
          }
        }
      }
    }
    label89:
    label101:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!vGq) && (!vGr)) {
        dcR();
      }
      AppMethodBeat.o(301945);
      return;
      i = 0;
      break;
    }
  }
  
  private final void es(List<? extends ene> paramList)
  {
    AppMethodBeat.i(301974);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ene)paramList.next();
      ab localab = new ab();
      localab.hAN = 2;
      localab.acFJ = ((ene)localObject);
      localObject = com.tencent.mm.model.p.ojc;
      localab.field_orderFlag = com.tencent.mm.model.p.bAw().incrementAndGet();
      this.vFH.add(localab);
      localObject = localab.acFJ;
      kotlin.g.b.s.s(localObject, "recFeed");
      if (com.tencent.mm.storage.ah.b((ene)localObject)) {
        com.tencent.mm.storage.r.acDM.C(localab);
      }
    }
    paramList = (Collection)this.vFH;
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.vFW)) {
        dcS();
      }
      notifyDataSetChanged();
      AppMethodBeat.o(301974);
      return;
    }
  }
  
  public final ab Hk(int paramInt)
  {
    AppMethodBeat.i(5869);
    ab localab;
    if ((paramInt < this.eXW.size()) && (paramInt >= 0))
    {
      localab = (ab)this.eXW.get(paramInt);
      AppMethodBeat.o(5869);
      return localab;
    }
    if (a.dcY())
    {
      if (paramInt == this.eXW.size())
      {
        localab = this.vFI;
        AppMethodBeat.o(5869);
        return localab;
      }
      if (this.vFH.size() > 0)
      {
        paramInt = paramInt - this.eXW.size() - 1;
        if ((paramInt < this.vFH.size()) && (paramInt >= 0))
        {
          localab = (ab)this.vFH.get(paramInt);
          AppMethodBeat.o(5869);
          return localab;
        }
      }
    }
    AppMethodBeat.o(5869);
    return null;
  }
  
  public final void a(int paramInt, ab paramab, View paramView1, View paramView2)
  {
    AppMethodBeat.i(5875);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramView1, "topLayout");
    kotlin.g.b.s.u(paramView2, "newTipsLayout");
    if (paramInt > 0)
    {
      paramView1.setVisibility(0);
      if (a(paramab, paramInt)) {
        paramView2.setVisibility(0);
      }
      for (;;)
      {
        f(paramab);
        AppMethodBeat.o(5875);
        return;
        paramView2.setVisibility(8);
        paramView1.setMinimumHeight(vGg);
      }
    }
    if (this.vFF.ddl()) {
      paramView1.setMinimumHeight(vGl * 2);
    }
    for (;;)
    {
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
      break;
      paramView1.setMinimumHeight(vGg);
    }
  }
  
  public final void a(com.tencent.mm.message.v paramv, ab paramab, int paramInt1, com.tencent.mm.message.u paramu, View paramView, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(5876);
    kotlin.g.b.s.u(paramv, "item");
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(paramView, "clickView");
    ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(paramv, paramab, paramInt1, paramu, paramView, paramBoolean, paramInt2, this.vFV);
    if (paramv.type == 5) {
      paramView.setOnClickListener(new b..ExternalSyntheticLambda0(paramInt2, paramv, this, paramab));
    }
    AppMethodBeat.o(5876);
  }
  
  public final void a(ai paramai, ab paramab)
  {
    AppMethodBeat.i(5877);
    kotlin.g.b.s.u(paramai, "slot");
    kotlin.g.b.s.u(paramab, "info");
    a.b.h(paramai.lBC, paramab.field_talker);
    Object localObject1 = com.tencent.mm.model.aa.getDisplayName(paramab.field_talker);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramab.field_talker);
    if ((localObject2 != null) && (((com.tencent.mm.storage.au)localObject2).aSQ()))
    {
      Object localObject3 = this.vFF.getResources().getDrawable(d.d.biz_timeline_star_icon);
      i = (int)paramai.vKE.getTextSize();
      ((Drawable)localObject3).setBounds(0, 0, i, i);
      localObject3 = new com.tencent.mm.ui.widget.a((Drawable)localObject3, 1);
      SpannableString localSpannableString = new SpannableString((CharSequence)"@");
      localSpannableString.setSpan(localObject3, 0, 1, 33);
      paramai.vKE.setText(TextUtils.concat(new CharSequence[] { (CharSequence)kotlin.g.b.s.X(com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.vFF, (CharSequence)localObject1, paramai.vKE.getTextSize()).toString(), " "), (CharSequence)localSpannableString }));
      if ((localObject2 == null) || (!((com.tencent.mm.storage.au)localObject2).aSQ())) {
        break label499;
      }
      localObject1 = localObject1 + 65292 + this.vFF.getString(d.i.talkback_biz_timeline_star);
      label257:
      paramai.vKE.setContentDescription((CharSequence)localObject1);
      localObject1 = e.vYK;
      e.l(paramai.vKE);
      localObject1 = paramai.vMF;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        if (!com.tencent.mm.pluginsdk.model.c.iGY()) {
          break label502;
        }
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        if (!com.tencent.mm.pluginsdk.model.c.bpf(paramab.field_talker)) {
          break label502;
        }
        com.tencent.mm.ui.tools.o.F(paramai.vMF, 0.5F);
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        com.tencent.mm.pluginsdk.model.c.z(paramab);
        localObject2 = paramai.vMF;
        if (localObject2 != null) {
          ((View)localObject2).setOnClickListener(new b..ExternalSyntheticLambda5(paramab, this));
        }
        localObject2 = kotlin.ah.aiuX;
      }
    }
    label499:
    label502:
    for (int i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      paramai.vMD.setTag(paramab);
      paramai.vMD.setOnClickListener(this.vFU);
      if (!com.tencent.mm.storage.ad.iYU()) {
        break label508;
      }
      paramai.timeTV.setVisibility(0);
      paramai.vME.setVisibility(8);
      paramai.timeTV.setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.c.f((Context)this.vFF, paramab.field_createTime));
      paramai.vMD.setOnLongClickListener(new b..ExternalSyntheticLambda6(this, paramab));
      AppMethodBeat.o(5877);
      return;
      paramai.vKE.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.vFF, (CharSequence)localObject1, paramai.vKE.getTextSize()));
      break;
      break label257;
    }
    label508:
    paramai.timeTV.setVisibility(8);
    paramai.vME.setVisibility(0);
    paramai.vMD.setOnLongClickListener(null);
    paramai.vME.setOnClickListener(new b..ExternalSyntheticLambda4(this, paramab));
    com.tencent.mm.ui.tools.o.F(paramai.vME, 0.7F);
    AppMethodBeat.o(5877);
  }
  
  public final void aiW(String paramString)
  {
    AppMethodBeat.i(5872);
    if (paramString == null)
    {
      AppMethodBeat.o(5872);
      return;
    }
    if (!this.vFR.contains(paramString))
    {
      com.tencent.mm.modelsimple.ac.aZ(paramString, 2);
      this.vFR.add(paramString);
    }
    AppMethodBeat.o(5872);
  }
  
  public final void b(ab paramab, int paramInt)
  {
    AppMethodBeat.i(302429);
    this.vFK.d(paramab, paramInt, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(302429);
  }
  
  public final void d(ab paramab)
  {
    int j = 0;
    AppMethodBeat.i(302265);
    kotlin.g.b.s.u(paramab, "info");
    Log.i("MicroMsg.BizTimeLineAdapter", "onFeedBack");
    e(paramab);
    kotlin.g.b.s.u(paramab, "deleteInfo");
    int k = this.vFH.indexOf(paramab);
    paramab = (List)new LinkedList();
    Iterator localIterator = ((Iterable)this.vFH).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (ab)localObject;
      if ((i > k) && (((ab)localObject).field_isRead == 0)) {
        paramab.add(localObject);
      }
      i += 1;
    }
    i = j;
    if (!((Collection)paramab).isEmpty()) {
      i = 1;
    }
    if (i != 0)
    {
      Log.i("MicroMsg.BizTimeLineAdapter", kotlin.g.b.s.X("deleteUnExposeRecFeed size ", Integer.valueOf(paramab.size())));
      this.vFH.removeAll((Collection)paramab);
      Hl(getCount() - 1);
    }
    AppMethodBeat.o(302265);
  }
  
  public final void dcM()
  {
    AppMethodBeat.i(302384);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)this.vFF, 1, false);
    localf.Vtg = new b..ExternalSyntheticLambda9(this);
    localf.GAC = ((u.i)this.vFO);
    localf.dDn();
    AppMethodBeat.o(302384);
  }
  
  public final ab dcN()
  {
    AppMethodBeat.i(5880);
    if (this.eXW.size() > 0)
    {
      ab localab = (ab)this.eXW.get(this.eXW.size() - 1);
      AppMethodBeat.o(5880);
      return localab;
    }
    AppMethodBeat.o(5880);
    return null;
  }
  
  public final ab dcO()
  {
    AppMethodBeat.i(5881);
    if (this.eXW.size() > 0)
    {
      ab localab = (ab)this.eXW.get(0);
      AppMethodBeat.o(5881);
      return localab;
    }
    AppMethodBeat.o(5881);
    return null;
  }
  
  public final void dcP()
  {
    AppMethodBeat.i(5884);
    ab localab = dcO();
    if (localab != null) {
      vGp = Long.valueOf(localab.iYa());
    }
    vGo = null;
    AppMethodBeat.o(5884);
  }
  
  public final void e(ab paramab)
  {
    AppMethodBeat.i(302268);
    kotlin.g.b.s.u(paramab, "info");
    this.vFH.remove(paramab);
    Object localObject = (Collection)this.vFH;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.w("MicroMsg.BizTimeLineAdapter", "onFeedBack mRecList is empty");
        dcL();
      }
      notifyDataSetChanged();
      localObject = com.tencent.mm.model.p.ojc;
      p.a.a(paramab);
      AppMethodBeat.o(302268);
      return;
    }
  }
  
  public final void f(ab paramab)
  {
    AppMethodBeat.i(5873);
    if (paramab == null)
    {
      Log.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
      AppMethodBeat.o(5873);
      return;
    }
    long l1 = paramab.iYa();
    long l2 = com.tencent.mm.an.af.bHl().iYD();
    Log.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.vFQ), Long.valueOf(l1), Long.valueOf(l2) });
    if ((!this.vFQ) && (l1 == l2))
    {
      l1 = paramab.field_orderFlag;
      com.tencent.mm.cp.g.ha(Long.valueOf(l1)).h(new b..ExternalSyntheticLambda10(l1)).b(new b..ExternalSyntheticLambda11(this));
    }
    AppMethodBeat.o(5873);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5868);
    if (a.dcY())
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ddZ())
      {
        i = this.eXW.size();
        int j = this.vFH.size();
        AppMethodBeat.o(5868);
        return i + j + 1;
      }
    }
    int i = this.eXW.size();
    AppMethodBeat.o(5868);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(5870);
    ab localab = Hk(paramInt);
    if (localab == null)
    {
      Log.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
      AppMethodBeat.o(5870);
      return 0;
    }
    switch (localab.field_type)
    {
    default: 
      if (localab.iYc())
      {
        AppMethodBeat.o(5870);
        return 5;
      }
      break;
    case 285212721: 
      AppMethodBeat.o(5870);
      return 1;
    case 1: 
      AppMethodBeat.o(5870);
      return 2;
    case 620757041: 
      AppMethodBeat.o(5870);
      return 3;
    case 637534257: 
      AppMethodBeat.o(5870);
      return 4;
    }
    if (localab.iYd())
    {
      AppMethodBeat.o(5870);
      return 6;
    }
    AppMethodBeat.o(5870);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5871);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    ab localab = Hk(paramInt);
    if (localab == null)
    {
      paramView = new View((Context)this.vFF);
      AppMethodBeat.o(5871);
      return paramView;
    }
    Hl(paramInt);
    label149:
    label163:
    Object localObject1;
    label201:
    Object localObject2;
    label578:
    label627:
    Object localObject3;
    label751:
    Object localObject4;
    switch (localab.field_type)
    {
    default: 
      if (localab.iYc())
      {
        vFY = true;
        if (paramView == null)
        {
          paramViewGroup = new al();
          paramView = (Context)this.vFF;
          if (paramViewGroup.vJU != null)
          {
            paramView = paramViewGroup.vJU;
            paramView.setTag(paramViewGroup);
            if (!vGr) {
              break label3261;
            }
            paramViewGroup.progressBar.setVisibility(0);
            localObject1 = com.tencent.mm.model.p.ojc;
            localObject1 = p.a.atj().decodeString("RecommendFeedsWording", "");
            if (localObject1 != null)
            {
              if (!kotlin.n.n.bp((CharSequence)localObject1)) {
                break label3273;
              }
              i = 1;
              if (i == 0)
              {
                localObject2 = paramViewGroup.vNc;
                if (localObject2 != null) {
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
              }
            }
            localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.a.dea()) {
              break label3530;
            }
            paramViewGroup.vNa.setVisibility(8);
            paramViewGroup.vNe.setVisibility(0);
            localObject1 = paramViewGroup.vNe;
            localObject2 = paramViewGroup.vNe.getLayoutParams();
            if (localObject2 != null) {
              break label3279;
            }
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(5871);
            throw paramView;
          }
        }
      }
      break;
    case 285212721: 
      if (!this.vFQ) {
        com.tencent.mm.plugin.brandservice.ui.b.d.v(localab);
      }
      if (paramView == null)
      {
        paramViewGroup = new aj();
        paramView = View.inflate((Context)this.vFF, d.f.biz_time_line_item, null);
        localObject1 = paramView.findViewById(d.e.biz_time_line_content_ll);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup.vMH = ((LinearLayout)localObject1);
        localObject1 = paramView.findViewById(d.e.show_more_article_layout);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup.vMI = ((LinearLayout)localObject1);
        localObject1 = paramView.findViewById(d.e.show_more_article_tv);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup.vMJ = ((TextView)localObject1);
        localObject1 = paramView.findViewById(d.e.biz_time_line_new_tips_layout);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup.vLw = ((LinearLayout)localObject1);
        localObject1 = paramView.findViewById(d.e.biz_time_line_item_top);
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup.vLx = ((LinearLayout)localObject1);
        paramViewGroup.vJU = paramView;
        paramViewGroup.ddU();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a((Context)this.vFF, this);
        paramViewGroup.a(localab, paramInt, paramView);
        if (paramView != null) {
          break;
        }
        paramView = null;
        if ((!this.vFQ) && (!this.hJi))
        {
          paramViewGroup = this.vFK.vHg;
          if (paramViewGroup != null) {
            paramViewGroup.g(localab, paramInt);
          }
          if (localab.hAN != 0) {
            break label3998;
          }
          paramInt = 1;
          if (paramInt != 0)
          {
            paramViewGroup = com.tencent.mm.storage.af.acGt;
            com.tencent.mm.storage.af.yY(localab.field_orderFlag);
            this.vFK.g(localab);
            if ((!localab.iYf()) && (!localab.iYg())) {
              aiW(localab.field_talker);
            }
          }
        }
        AppMethodBeat.o(5871);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineItemHolder");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup = (aj)paramViewGroup;
      }
    case 1: 
      if (paramView == null)
      {
        paramViewGroup = new am();
        paramView = paramViewGroup.b((Context)this.vFF, this);
        paramView.setTag(paramViewGroup);
        localObject2 = paramViewGroup.mContext;
        localObject3 = localab.field_content;
        i = (int)paramViewGroup.vIW.getTextSize();
        if (localab == null) {
          break label1132;
        }
        localObject1 = com.tencent.mm.model.ad.Jo(localab.field_msgSvrId);
        localObject4 = com.tencent.mm.model.ad.bCb().M((String)localObject1, true);
        ((ad.b)localObject4).q("prePublishId", "msg_" + localab.field_msgSvrId);
        ((ad.b)localObject4).q("preUsername", localab.field_talker);
        label857:
        localObject1 = com.tencent.mm.pluginsdk.ui.span.p.a((Context)localObject2, (CharSequence)localObject3, i, null, (String)localObject1);
        paramViewGroup.vIW.setMaxLines(2147483647);
        paramViewGroup.vIW.aZ((CharSequence)localObject1);
        if (!localab.field_isExpand) {
          break label1138;
        }
        paramViewGroup.vNg.setText(paramViewGroup.mContext.getString(d.i.biz_time_line_item_text_collapse));
        label915:
        i = com.tencent.mm.cd.a.ms(paramViewGroup.mContext);
        int j = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.mContext, 72);
        localObject1 = paramViewGroup.vIW.pE(i - j, 2147483647);
        if (localObject1 == null) {
          break label4003;
        }
      }
      break;
    }
    label1031:
    label2573:
    label2830:
    label2836:
    label3348:
    label3998:
    label4003:
    for (int i = ((com.tencent.neattextview.textview.layout.a)localObject1).jQH();; i = 0)
    {
      if (i > 4)
      {
        if (!localab.field_isExpand) {
          paramViewGroup.vIW.setMaxLines(4);
        }
        paramViewGroup.vNg.setVisibility(0);
        if (localab.field_isExpand)
        {
          paramViewGroup.vNg.setText(d.i.biz_time_line_item_text_collapse);
          label1014:
          paramViewGroup.vNg.setOnClickListener(new am.1(paramViewGroup, localab));
          localObject1 = (LinearLayout.LayoutParams)paramViewGroup.vIW.getLayoutParams();
          if (i > 4) {
            break label1193;
          }
        }
      }
      label1193:
      for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
      {
        paramViewGroup.vIW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.vMC.a(paramViewGroup, localab);
        paramViewGroup.vMC.a(paramInt, localab, paramViewGroup.vLx, paramViewGroup.vLw);
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineTextItem");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup = (am)paramViewGroup;
        break label751;
        label1132:
        localObject1 = null;
        break label857;
        label1138:
        paramViewGroup.vNg.setText(paramViewGroup.mContext.getString(d.i.biz_time_line_item_text_expand));
        break label915;
        paramViewGroup.vNg.setText(d.i.biz_time_line_item_text_expand);
        break label1014;
        paramViewGroup.vIW.setMaxLines(2147483647);
        paramViewGroup.vNg.setVisibility(8);
        break label1031;
      }
      if (!this.vFQ) {
        com.tencent.mm.plugin.brandservice.ui.b.d.x(localab);
      }
      if (paramView == null)
      {
        paramViewGroup = new x((Context)this.vFF, this);
        paramView = paramViewGroup.vLv;
        paramView.setTag(paramViewGroup);
        label1245:
        kotlin.g.b.s.u(localab, "info");
        kotlin.g.b.s.u(paramView, "convertView");
        if (localab.iYp() != null) {
          break label1320;
        }
        paramViewGroup.ddT();
        Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] info null");
      }
      for (;;)
      {
        break;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardNew");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup = (x)paramViewGroup;
        break label1245;
        label1320:
        if (!com.tencent.mm.plugin.brandservice.ui.timeline.item.k.GY(localab.acFD.style))
        {
          paramViewGroup.ddT();
          Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] style = " + localab.acFD.style + " not support");
        }
        else
        {
          localObject1 = localab.acFD;
          kotlin.g.b.s.s(localObject1, "info.wrapper");
          if (!com.tencent.mm.storage.ah.c((flj)localObject1, localab))
          {
            paramViewGroup.ddT();
            Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] wrapper illegal");
          }
          else
          {
            i = x.Ho(localab.acFD.style);
            Log.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] filling style = " + localab.acFD.style + ", msgId = " + localab.field_msgId);
            localObject1 = paramViewGroup.vHY;
            localObject2 = paramViewGroup.vLx;
            kotlin.g.b.s.s(localObject2, "topLayout");
            localObject2 = (View)localObject2;
            localObject3 = paramViewGroup.vLw;
            kotlin.g.b.s.s(localObject3, "newTipsLayout");
            ((b)localObject1).a(paramInt, localab, (View)localObject2, (View)localObject3);
            paramViewGroup.vLq.hide();
            paramViewGroup.vLp.hide();
            paramViewGroup.vLo.hide();
            paramViewGroup.vLr.hide();
            paramViewGroup.vLs.hide();
            paramViewGroup.vLt.hide();
            paramViewGroup.vLu.hide();
            switch (i)
            {
            default: 
              break;
            case 1: 
              localObject1 = paramViewGroup.vLq;
              paramViewGroup = paramViewGroup.vLv;
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 2L, 1L, false);
              localObject2 = ((y)localObject1).mContext;
              if (((y)localObject1).vJU == null)
              {
                ((y)localObject1).vJU = ((ViewStub)paramViewGroup.findViewById(d.e.viewstub_old)).inflate();
                ((y)localObject1).ddU();
                ((y)localObject1).vKF = ((TextView)((y)localObject1).vJU.findViewById(d.e.biz_rec_card_title));
                ((y)localObject1).vKG = ((y)localObject1).vJU.findViewById(d.e.close_layout);
                ((y)localObject1).vKH = ((y)localObject1).vJU.findViewById(d.e.close_iv);
                ((y)localObject1).vKI = ((y)localObject1).vJU.findViewById(d.e.biz_rec_card_profile_layout);
                ((y)localObject1).vKJ = ((TextView)((y)localObject1).vJU.findViewById(d.e.biz_rec_card_reason_tv));
                ((y)localObject1).vKK = ((MMNeat7extView)((y)localObject1).vJU.findViewById(d.e.biz_rec_card_desc_tv));
                ((y)localObject1).plj = ((y)localObject1).vJU.findViewById(d.e.biz_rec_card_line);
                ((y)localObject1).vLz = ((y)localObject1).vJU.findViewById(d.e.biz_rec_card_appmsg_layout);
                ((y)localObject1).vLA = ((TextView)((y)localObject1).vJU.findViewById(d.e.biz_rec_card_appmsg_reason_tv));
                ((y)localObject1).vLB = ((MMNeat7extView)((y)localObject1).vJU.findViewById(d.e.biz_rec_card_appmsg_title_tv));
                ((WeImageView)((y)localObject1).vJU.findViewById(d.e.nav_arrow)).setIconColor(((Context)localObject2).getResources().getColor(d.b.BW_0_Alpha_0_9));
              }
              ((y)localObject1).vJU.setVisibility(0);
              paramViewGroup = localab.iYo();
              if ((paramViewGroup == null) || (paramViewGroup.abLF == null))
              {
                paramView.setVisibility(8);
              }
              else
              {
                paramView.setVisibility(0);
                ((y)localObject1).vKF.setText(paramViewGroup.Zxn);
                ((y)localObject1).vKE.getPaint().setFakeBoldText(true);
                localObject2 = ((y)localObject1).lBC;
                localObject3 = paramViewGroup.abLF.YPo;
                localObject4 = new c.a();
                ((c.a)localObject4).oKE = d.d.brand_default_head;
                ((c.a)localObject4).oKo = true;
                ((c.a)localObject4).nrc = true;
                com.tencent.mm.modelimage.r.bKe().a((String)localObject3, (ImageView)localObject2, ((c.a)localObject4).bKx());
                ((y)localObject1).vKE.setText(paramViewGroup.abLF.vhX);
                ((y)localObject1).vKJ.setText(paramViewGroup.abLF.abLH);
                ((y)localObject1).vKK.aZ(paramViewGroup.abLF.pSi);
                localObject2 = paramViewGroup.abLF.UserName;
                localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject2);
                if ((localObject3 == null) || ((int)((com.tencent.mm.contact.d)localObject3).maN <= 0)) {
                  az.a.okP.a((String)localObject2, "", null);
                }
                ((y)localObject1).vKI.setOnClickListener(new y.1((y)localObject1, (String)localObject2, localab));
                if ((paramViewGroup.YVI != null) && (paramViewGroup.YVI.get(0) != null) && ((((flf)paramViewGroup.YVI.get(0)).YFu & 0x1) == 0))
                {
                  localObject2 = (flf)paramViewGroup.YVI.get(0);
                  ((y)localObject1).vLz.setVisibility(0);
                  ((y)localObject1).plj.setVisibility(0);
                  ((y)localObject1).vLA.setText(paramViewGroup.YVH);
                  ((y)localObject1).vLB.aZ(((flf)localObject2).hAP);
                  ((y)localObject1).vLz.setOnClickListener(new y.2((y)localObject1, localab, (flf)localObject2));
                  ((y)localObject1).vKI.setBackgroundResource(d.d.biz_time_line_item_middle_bg);
                  if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (!Util.isNullOrNil(((flf)localObject2).YQK)))
                  {
                    Log.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { ((flf)localObject2).YQK });
                    ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(((flf)localObject2).YQK, ((flf)localObject2).nUA, 90, new Object[0]);
                  }
                  com.tencent.mm.plugin.brandservice.ui.b.d.w(localab);
                  localObject2 = localab.iYp();
                  if (localObject2 == null) {
                    continue;
                  }
                  localObject3 = paramViewGroup.abLG;
                  if (localObject3 != null) {
                    break label2488;
                  }
                  Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
                  i = 0;
                }
                for (;;)
                {
                  if ((i != 0) || (!Util.isNullOrNil(((flj)localObject2).abLL))) {
                    break label2573;
                  }
                  Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { paramViewGroup.abLF.vhX });
                  ((y)localObject1).vKG.setVisibility(8);
                  break;
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 6L, 1L, false);
                  ((y)localObject1).plj.setVisibility(8);
                  ((y)localObject1).vLz.setVisibility(8);
                  ((y)localObject1).vKI.setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
                  break label2348;
                  if (((fli)localObject3).abLJ == null)
                  {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                    i = 0;
                  }
                  else if (((fli)localObject3).abLJ.YVB != 1)
                  {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                    i = 0;
                  }
                  else if (Util.isNullOrNil(((fli)localObject3).abLJ.YVA))
                  {
                    Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                    i = 0;
                  }
                  else
                  {
                    i = 1;
                  }
                }
                Log.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { paramViewGroup.abLF.vhX });
                ((y)localObject1).vKG.setVisibility(0);
                ((y)localObject1).vKG.setOnClickListener(new y.3((y)localObject1, localab, paramInt));
              }
              break;
            case 2: 
              paramViewGroup.vLo.a(localab, paramInt, paramView, paramViewGroup.vLv);
              break;
            case 3: 
              paramViewGroup.vLp.a(localab, paramInt, paramView, paramViewGroup.vLv);
              break;
            case 4: 
              paramViewGroup.vLr.a(localab, paramInt, paramView, paramViewGroup.vLv);
              break;
            case 5: 
              paramViewGroup.vLs.a(localab, paramInt, paramView, paramViewGroup.vLv);
              break;
            case 6: 
              paramViewGroup.vLt.a(localab, paramInt, paramView, paramViewGroup.vLv);
              break;
            case 7: 
              label2348:
              label2488:
              paramViewGroup.vLu.a(localab, paramInt, paramView, paramViewGroup.vLv);
            }
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
      com.tencent.mm.plugin.webcanvas.j.xC(66L);
      localObject1 = com.tencent.mm.storage.r.acDM;
      if (com.tencent.mm.storage.r.iXl())
      {
        localObject1 = (CharSequence)localab.getTraceId();
        if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
          break label2830;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label2836;
        }
        Log.i("MicroMsg.BizTimeLineAdapter", kotlin.g.b.s.X("hide ad ", localab.getTraceId()));
        paramView = new View((Context)this.vFF);
        paramView.setVisibility(8);
        break;
      }
      localObject2 = localab.field_msgId + '_' + localab.getTraceId();
      if (!localab.vKr)
      {
        localObject1 = com.tencent.mm.plugin.biz.b.c.vtp;
        if (!com.tencent.mm.plugin.biz.b.c.e((String)localObject2, paramView))
        {
          paramView = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(68L);
          paramView = new View((Context)this.vFF);
          paramView.setVisibility(8);
          break label578;
        }
      }
      localab.vKr = true;
      if ((paramView == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.r)))
      {
        localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.r((Context)this.vFF, this);
        paramView = (View)((com.tencent.mm.plugin.brandservice.ui.timeline.item.r)localObject1).ddA();
        ((ViewGroup)paramView).setTag(localObject1);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.r)localObject1).a(localab, paramInt, paramView, (View)paramViewGroup);
        paramViewGroup = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(67L);
        paramViewGroup = com.tencent.mm.plugin.biz.b.c.vtp;
        com.tencent.mm.plugin.biz.b.c.ail((String)localObject2);
        break;
        localObject1 = paramView.getTag();
        if (localObject1 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCanvas");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.r)localObject1;
      }
      paramViewGroup.vJU = View.inflate(paramView, d.f.biz_time_line_new_msg_line_layout, null);
      paramViewGroup.vNa = ((LinearLayout)paramViewGroup.vJU.findViewById(d.e.biz_time_line_expand_layout));
      paramViewGroup.vNb = ((LinearLayout)paramViewGroup.vJU.findViewById(d.e.biz_time_line_rec_header_refresh_layout));
      paramViewGroup.vNc = ((TextView)paramViewGroup.vJU.findViewById(d.e.biz_time_line_rec_header_title_tv));
      paramViewGroup.vNe = ((LinearLayout)paramViewGroup.vJU.findViewById(d.e.biz_time_line_no_msg_tips_layout));
      paramViewGroup.vNf = ((TextView)paramViewGroup.vJU.findViewById(d.e.biz_time_line_no_msg_tips_tv));
      paramViewGroup.progressBar = ((ProgressBar)paramViewGroup.vJU.findViewById(d.e.biz_time_line_rec_feed_loading_more_pb));
      paramViewGroup.vNd = ((TextView)paramViewGroup.vJU.findViewById(d.e.biz_time_line_rec_feed_show_old_msg_tv));
      paramView = e.vYK;
      e.l(paramViewGroup.vNc);
      com.tencent.mm.ui.tools.o.F(paramViewGroup.vNb, 0.5F);
      com.tencent.mm.ui.tools.o.F(paramViewGroup.vNa, 0.5F);
      paramView = paramViewGroup.vJU;
      break;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineNewMsgLineItem");
        AppMethodBeat.o(5871);
        throw paramView;
      }
      paramViewGroup = (al)paramViewGroup;
      break label149;
      label3261:
      paramViewGroup.progressBar.setVisibility(8);
      break label163;
      label3273:
      i = 0;
      break label201;
      label3279:
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout.LayoutParams)localObject2).topMargin = (vGm * 5);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = (vGm * 5);
      localObject3 = kotlin.ah.aiuX;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (Collection)this.eXW;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label3496;
        }
        paramViewGroup.vNf.setText((CharSequence)this.vFF.getString(d.i.biz_time_line_item_no_msg_tips));
        localObject1 = com.tencent.mm.model.o.ojb;
        com.tencent.mm.model.o.ir(12L);
        label3384:
        localObject1 = com.tencent.mm.model.o.ojb;
        com.tencent.mm.model.o.ir(10L);
        localObject1 = com.tencent.mm.model.o.ojb;
        com.tencent.mm.model.o.ez(0, paramInt);
        paramViewGroup.vNa.setOnClickListener(new b..ExternalSyntheticLambda1(paramInt, this));
        localObject1 = paramViewGroup.vNb;
        localObject2 = com.tencent.mm.model.o.ojb;
        com.tencent.mm.model.o.eA(0, paramInt);
        localObject2 = kotlin.ah.aiuX;
        ((LinearLayout)localObject1).setVisibility(0);
        localObject1 = paramViewGroup.vNb;
        if (vGr) {
          break label3684;
        }
      }
      label3496:
      label3530:
      label3684:
      for (boolean bool = true;; bool = false)
      {
        ((LinearLayout)localObject1).setEnabled(bool);
        paramViewGroup.vNb.setOnClickListener(new b..ExternalSyntheticLambda3(this, paramViewGroup, paramInt));
        break;
        i = 0;
        break label3348;
        paramViewGroup.vNf.setText((CharSequence)this.vFF.getString(d.i.biz_time_line_item_no_more_msg_tips));
        localObject1 = com.tencent.mm.model.o.ojb;
        com.tencent.mm.model.o.ir(13L);
        break label3384;
        paramViewGroup.vNa.setVisibility(0);
        if (this.eXW.size() == 0)
        {
          localObject1 = paramViewGroup.vNe;
          localObject2 = paramViewGroup.vNe.getLayoutParams();
          if (localObject2 == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            AppMethodBeat.o(5871);
            throw paramView;
          }
          localObject2 = (LinearLayout.LayoutParams)localObject2;
          ((LinearLayout.LayoutParams)localObject2).topMargin = (vGm * 8);
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = vGm;
          localObject3 = kotlin.ah.aiuX;
          ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramViewGroup.vNe.setVisibility(0);
          paramViewGroup.vNf.setText((CharSequence)this.vFF.getString(d.i.biz_time_line_item_no_more_new_msg_tips));
          localObject1 = com.tencent.mm.model.o.ojb;
          com.tencent.mm.model.o.ir(14L);
          break label3384;
        }
        paramViewGroup.vNe.setVisibility(8);
        break label3384;
      }
      if (localab.iYd())
      {
        vFY = true;
        if (paramView == null)
        {
          paramViewGroup = new av((Context)this.vFF, this);
          paramView = paramViewGroup.vLv;
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          paramViewGroup.a(localab, Hk(paramInt - 1), paramInt, paramView);
          localab.acFz = this.vFH.indexOf(localab);
          break;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTlRecFeedCard");
            AppMethodBeat.o(5871);
            throw paramView;
          }
          paramViewGroup = (av)paramViewGroup;
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.item.au();
        paramView = (Context)this.vFF;
        if (paramViewGroup.vJU != null)
        {
          paramView = paramViewGroup.vJU;
          label3834:
          paramView.setTag(paramViewGroup);
        }
      }
      for (;;)
      {
        a((ai)paramViewGroup, localab);
        localObject1 = paramViewGroup.vLx;
        kotlin.g.b.s.s(localObject1, "unknownItem.topLayout");
        localObject1 = (View)localObject1;
        paramViewGroup = paramViewGroup.vLw;
        kotlin.g.b.s.s(paramViewGroup, "unknownItem.newTipsLayout");
        a(paramInt, localab, (View)localObject1, (View)paramViewGroup);
        break;
        paramViewGroup.vJU = View.inflate(paramView, d.f.biz_time_line_unknown_item, null);
        paramViewGroup.ddU();
        paramView = paramViewGroup.vJU;
        break label3834;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTimeLineUnknownItem");
          AppMethodBeat.o(5871);
          throw paramView;
        }
        paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.item.au)paramViewGroup;
      }
      paramViewGroup = paramView.getTag();
      if ((paramViewGroup instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {}
      for (paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)paramViewGroup;; paramViewGroup = null)
      {
        if (paramViewGroup != null)
        {
          paramViewGroup.vGS = localab;
          paramViewGroup.position = paramInt;
        }
        break;
      }
      paramInt = 0;
      break label627;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5887);
    List localList = (List)new ArrayList();
    if (paramInt1 <= paramInt2) {}
    for (;;)
    {
      Object localObject = Hk(paramInt1);
      long l;
      String str;
      if ((localObject != null) && (((ab)localObject).field_type == 285212721))
      {
        Log.v("MicroMsg.BizTimeLineAdapter", kotlin.g.b.s.X("terry checkpreload:", Long.valueOf(((ab)localObject).field_msgId)));
        l = ((ab)localObject).field_msgId;
        str = ((ab)localObject).field_content;
        kotlin.g.b.s.s(str, "info.field_content");
        if (!((ab)localObject).field_isExpand) {
          break label169;
        }
      }
      label169:
      for (localObject = "-1";; localObject = "2")
      {
        localList.add(new String[] { String.valueOf(l), str, localObject });
        if (paramInt1 != paramInt2) {
          break;
        }
        if (localList.size() > 0) {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).t(localList, 90);
        }
        AppMethodBeat.o(5887);
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(5885);
    if (super.isEmpty())
    {
      if (com.tencent.mm.an.af.bHo().dkF() > 0)
      {
        AppMethodBeat.o(5885);
        return false;
      }
      fmz localfmz = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g.deD();
      if ((localfmz != null) && (!Util.isNullOrNil(localfmz.abNc))) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(5885);
        return false;
      }
    }
    boolean bool = super.isEmpty();
    AppMethodBeat.o(5885);
    return bool;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(5879);
    super.notifyDataSetChanged();
    Log.d("MicroMsg.BizTimeLineAdapter", "notifyDataSetChanged");
    AppMethodBeat.o(5879);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(5878);
    kotlin.g.b.s.u(paramContextMenu, "menu");
    kotlin.g.b.s.u(paramView, "v");
    kotlin.g.b.s.u(paramContextMenuInfo, "menuInfo");
    AppMethodBeat.o(5878);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$Companion;", "", "()V", "TAG", "", "coverHeight", "", "coverHeightForPicAndVideo", "coverHeightForRecFeed", "coverHeightForRecFeedPicAndVideo", "doingGetRecommendFeeds", "", "doingInitRecommendFeeds", "itemLineBigPadding", "itemLineNormalPadding", "lastRefreshRecFeedTime", "", "maxGroupId", "Ljava/lang/Long;", "newMsgOrderFlag", "padding2DP", "padding40", "padding8DP", "paddingBig", "paddingMiddle", "paddingNormal", "paddingSmall", "getPaddingSmall", "()I", "setPaddingSmall", "(I)V", "recFeedExposed", "getRecFeedExposed", "()Z", "setRecFeedExposed", "(Z)V", "showRecFeeds", "getShowRecFeeds", "subItemPicSize", "getFirstScreenData", "", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getRecFeedScene", "Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "firstScreenDataEmpty", "recommendFeedsContext", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsContext;", "getMoreRecommendFeeds", "getRecFeedsOnClickBack", "init", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static eni a(eni parameni)
    {
      AppMethodBeat.i(301963);
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      parameni.abrS = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.dec();
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ajc(null);
      localObject = com.tencent.mm.model.p.ojc;
      parameni.abrT = com.tencent.mm.model.p.bAy();
      localObject = com.tencent.mm.model.p.ojc;
      com.tencent.mm.model.p.HY(null);
      AppMethodBeat.o(301963);
      return parameni;
    }
    
    private static void a(final b paramb, p.f paramf, final boolean paramBoolean, final eni parameni)
    {
      AppMethodBeat.i(301951);
      final WeakReference localWeakReference = new WeakReference(paramb);
      paramb = new WeakReference(paramb.vFF);
      kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new a(paramf, parameni, paramb, localWeakReference, paramBoolean, null), 2);
      AppMethodBeat.o(301951);
    }
    
    public static boolean dcY()
    {
      AppMethodBeat.i(301942);
      if (com.tencent.mm.storage.ad.iYS())
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.ddY())
        {
          AppMethodBeat.o(301942);
          return true;
        }
      }
      AppMethodBeat.o(301942);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      a(p.f paramf, eni parameni, WeakReference<BizTimeLineUI> paramWeakReference, WeakReference<b> paramWeakReference1, boolean paramBoolean, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(302002);
        paramObject = (kotlin.d.d)new a(this.ojl, parameni, paramb, localWeakReference, paramBoolean, paramd);
        AppMethodBeat.o(302002);
        return paramObject;
      }
      
      public final Object invokeSuspend(final Object paramObject)
      {
        Object localObject1 = null;
        AppMethodBeat.i(301995);
        Object localObject3 = kotlin.d.a.a.aiwj;
        Object localObject4;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(301995);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          if (b.dcV())
          {
            paramObject = kotlin.ah.aiuX;
            AppMethodBeat.o(301995);
            return paramObject;
          }
          paramObject = b.vFE;
          b.mR(true);
          paramObject = com.tencent.mm.model.o.ojb;
          if (this.ojl == p.f.oju) {}
          for (long l = 0L;; l = 5L)
          {
            com.tencent.mm.model.o.ir(l);
            paramObject = com.tencent.mm.model.p.ojc;
            paramObject = this.ojl;
            localObject2 = parameni;
            localObject4 = (kotlin.d.d)this;
            this.label = 1;
            localObject2 = p.a.a(paramObject, (eni)localObject2, null, (kotlin.d.d)localObject4, 4);
            paramObject = localObject2;
            if (localObject2 != localObject3) {
              break;
            }
            AppMethodBeat.o(301995);
            return localObject3;
          }
        }
        ResultKt.throwOnFailure(paramObject);
        Object localObject2 = (cra)paramObject;
        paramObject = b.vFE;
        b.mR(false);
        int i;
        if (localObject2 == null)
        {
          paramObject = localObject1;
          localObject1 = (Collection)paramObject;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label368;
          }
          i = 1;
          label218:
          if (i == 0) {
            break label373;
          }
          Log.w("MicroMsg.BizTimeLineAdapter", "initRecommendFeeds list is empty");
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.u(paramb) {});
        }
        for (;;)
        {
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(301995);
          return paramObject;
          localObject3 = ((cra)localObject2).aaxG;
          paramObject = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = (Iterable)localObject3;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = ((Iterator)localObject1).next();
            localObject4 = (ene)localObject3;
            kotlin.g.b.s.s(localObject4, "it");
            if (com.tencent.mm.storage.ah.c((ene)localObject4)) {
              paramObject.add(localObject3);
            }
          }
          paramObject = (List)paramObject;
          break;
          label368:
          i = 0;
          break label218;
          label373:
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.u(paramb) {});
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(WeakReference<b> paramWeakReference)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      Object L$0;
      Object Uf;
      int label;
      
      c(WeakReference<b> paramWeakReference, WeakReference<BizTimeLineUI> paramWeakReference1, qa paramqa, kotlin.d.d<? super c> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(301986);
        paramObject = (kotlin.d.d)new c(this.vGu, this.vGt, this.vGx, paramd);
        AppMethodBeat.o(301986);
        return paramObject;
      }
      
      public final Object invokeSuspend(final Object paramObject)
      {
        AppMethodBeat.i(301982);
        Object localObject1 = kotlin.d.a.a.aiwj;
        final b localb;
        BizTimeLineUI localBizTimeLineUI;
        Object localObject2;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(301982);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.model.o.ojb;
          com.tencent.mm.model.o.ir(1L);
          localb = (b)this.vGu.get();
          if (localb == null)
          {
            paramObject = kotlin.ah.aiuX;
            AppMethodBeat.o(301982);
            return paramObject;
          }
          localBizTimeLineUI = (BizTimeLineUI)this.vGt.get();
          if (localBizTimeLineUI == null)
          {
            paramObject = kotlin.ah.aiuX;
            AppMethodBeat.o(301982);
            return paramObject;
          }
          paramObject = com.tencent.mm.model.p.ojc;
          paramObject = p.f.ojv;
          localObject2 = this.vGx;
          localObject3 = (kotlin.d.d)this;
          this.L$0 = localb;
          this.Uf = localBizTimeLineUI;
          this.label = 1;
          paramObject = p.a.a(paramObject, null, (qa)localObject2, (kotlin.d.d)localObject3, 2);
          if (paramObject == localObject1)
          {
            AppMethodBeat.o(301982);
            return localObject1;
          }
          break;
        case 1: 
          localBizTimeLineUI = (BizTimeLineUI)this.Uf;
          localb = (b)this.L$0;
          ResultKt.throwOnFailure(paramObject);
        }
        for (;;)
        {
          paramObject = (cra)paramObject;
          int i;
          if (paramObject == null)
          {
            paramObject = null;
            localObject1 = b.vFE;
            b.mS(false);
            localObject1 = (Collection)paramObject;
            if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
              break label393;
            }
            i = 1;
            label244:
            if (i == 0) {
              break label398;
            }
            Log.w("MicroMsg.BizTimeLineAdapter", "getMoreRecommendFeeds list is empty");
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.u(localBizTimeLineUI) {});
          }
          for (;;)
          {
            paramObject = kotlin.ah.aiuX;
            AppMethodBeat.o(301982);
            return paramObject;
            paramObject = paramObject.aaxG;
            if (paramObject == null)
            {
              paramObject = null;
              break;
            }
            localObject1 = (Iterable)paramObject;
            paramObject = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              localObject3 = (ene)localObject2;
              p.a locala = com.tencent.mm.model.p.ojc;
              kotlin.g.b.s.s(localObject3, "it");
              if (p.a.a((ene)localObject3, b.c(localb))) {
                paramObject.add(localObject2);
              }
            }
            paramObject = (List)paramObject;
            break;
            label393:
            i = 0;
            break label244;
            label398:
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.u(localBizTimeLineUI) {});
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      d(WeakReference<b> paramWeakReference, WeakReference<BizTimeLineUI> paramWeakReference1, kotlin.d.d<? super d> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(301984);
        paramObject = (kotlin.d.d)new d(this.vGu, this.vGt, paramd);
        AppMethodBeat.o(301984);
        return paramObject;
      }
      
      public final Object invokeSuspend(final Object paramObject)
      {
        AppMethodBeat.i(301981);
        Object localObject2 = kotlin.d.a.a.aiwj;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(301981);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.model.o.ojb;
          com.tencent.mm.model.o.ir(31L);
          paramObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
          if (com.tencent.mm.plugin.brandservice.ui.timeline.a.a.dee())
          {
            paramObject = com.tencent.mm.model.o.ojb;
            com.tencent.mm.model.o.ir(34L);
            paramObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.m(null);
            Log.w("MicroMsg.BizTimeLineAdapter", "getRecFeedsOnClickBack scroll before cgi");
            paramObject = kotlin.ah.aiuX;
            AppMethodBeat.o(301981);
            return paramObject;
          }
          paramObject = com.tencent.mm.model.p.ojc;
          i = p.a.a(p.f.ojx);
          if (Math.abs(System.currentTimeMillis() - b.dcX()) < i)
          {
            Log.i("MicroMsg.BizTimeLineAdapter", kotlin.g.b.s.X("getRecFeedsOnClickBack should not do refresh in ", Integer.valueOf(i)));
            paramObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.a.m(null);
            paramObject = kotlin.ah.aiuX;
            AppMethodBeat.o(301981);
            return paramObject;
          }
          paramObject = b.vFE;
          b.kk(System.currentTimeMillis());
          paramObject = com.tencent.mm.model.p.ojc;
          paramObject = p.f.ojx;
          localObject1 = b.vFE;
          localObject1 = b.a.a(new eni());
          localObject3 = (kotlin.d.d)this;
          this.label = 1;
          localObject1 = p.a.a(paramObject, (eni)localObject1, null, (kotlin.d.d)localObject3, 4);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(301981);
            return localObject2;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (cra)paramObject;
        if (paramObject == null)
        {
          paramObject = null;
          localObject1 = (Collection)paramObject;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label444;
          }
        }
        label433:
        label444:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label449;
          }
          paramObject = com.tencent.mm.model.o.ojb;
          com.tencent.mm.model.o.ir(33L);
          Log.w("MicroMsg.BizTimeLineAdapter", "getRecFeedsOnClickBack list is empty");
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(301981);
          return paramObject;
          paramObject = paramObject.aaxG;
          if (paramObject == null)
          {
            paramObject = null;
            break;
          }
          paramObject = (Iterable)paramObject;
          localObject1 = this.vGu;
          localObject2 = (Collection)new ArrayList();
          localObject3 = paramObject.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            ene localene = (ene)localObject4;
            paramObject = com.tencent.mm.model.p.ojc;
            kotlin.g.b.s.s(localene, "it");
            paramObject = (b)((WeakReference)localObject1).get();
            if (paramObject == null) {}
            for (paramObject = null;; paramObject = b.c(paramObject))
            {
              if (!p.a.a(localene, paramObject)) {
                break label433;
              }
              ((Collection)localObject2).add(localObject4);
              break;
            }
          }
          paramObject = (List)localObject2;
          break;
        }
        label449:
        Object localObject1 = com.tencent.mm.model.o.ojb;
        com.tencent.mm.model.o.ir(32L);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.u(this.vGt) {});
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(301981);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$onBizInfoChange$1$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements MessageQueue.IdleHandler
  {
    d(b paramb, Object paramObject, ac.a parama) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(301950);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      if ((this.vGA.vFF == null) || (this.vGA.vFF.isFinishing()))
      {
        AppMethodBeat.o(301950);
        return false;
      }
      b localb = this.vGA;
      kotlin.g.b.s.s(paramObject, "stg");
      b.a(localb, parama);
      AppMethodBeat.o(301950);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b
 * JD-Core Version:    0.7.0.1
 */