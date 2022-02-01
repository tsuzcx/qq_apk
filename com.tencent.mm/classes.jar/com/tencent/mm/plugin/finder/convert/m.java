package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.Size;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hm;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.a.hu.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.upload.action.l.a;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.view.v;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.c;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.csg;>;
import java.util.List<Ljava.lang.Object;>;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.r;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "FINDER_FOLLOW_PAT_ENTRANCE_VALUE", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "MENU_ID_UNFOLLOW", "avatarRectControl", "feedHeadBarStyle", "getFeedHeadBarStyle", "()I", "setFeedHeadBarStyle", "(I)V", "hideSelfTipsRunnable", "Ljava/lang/Runnable;", "isRealNameLike", "onAvatarClickListener", "Landroid/view/View$OnClickListener;", "getOnAvatarClickListener", "()Landroid/view/View$OnClickListener;", "setOnAvatarClickListener", "(Landroid/view/View$OnClickListener;)V", "rect", "Landroid/graphics/Rect;", "getSafeMode", "()Z", "setSafeMode", "(Z)V", "stateListeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "getTabType", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "uiLifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1;", "adjustActivityDesc", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "textView", "Landroid/widget/TextView;", "maxWidth", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "calculateBannerLayoutParam", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "calculateOpArea", "item", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "canFetchSimilarFeeds", "context", "Landroid/content/Context;", "checkHideLikeTips", "tipsView", "Landroid/view/View;", "checkPostOk", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Z", "checkShowShareSnsLayout", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "convertMedia", "position", "type", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;II)V", "deleteComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "objectNonceId", "", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "deleteItem", "feed", "posting", "favAnimator", "favFeed", "fetchSimilarFeeds", "enable", "enableOnClick", "fromFav", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;ZZZ)V", "formatDesc", "incCount", "suffix", "descTv", "preCount", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)Lcom/tencent/mm/protobuf/ByteString;", "getLikeIcon", "filled", "private", "handleLinkTvOnClick", "link", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Ljava/lang/String;)V", "handlePoiOnClick", "poiText", "hideOrDimissMoreBtn", "ifShow", "hideSelfFeedLikeTips", "jumpFoldedUI", "feedList", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "pos", "(Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;I)V", "jumpRelatedUI", "title", "lastBuffer", "needRefresh", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "likeAvatorAnimator", "likeCount", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "likeFeed", "likeAction", "likeLocalFeed", "isPrivate", "onBindFinish", "onBindViewHolder", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onMediaClick", "view", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "onPostFinished", "onViewRecycled", "openCommentDrawer", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ZJLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;II)V", "protectMediaType", "refreshAwesomeIv", "isLike", "refreshBgmTag", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "refreshCommentEdu", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;I)V", "refreshExposeLayout", "refreshFavIv", "isFav", "favCount", "refreshFeedHeaderBar", "refreshFinderLiveNoticeView", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshFoldedLayout", "refreshFollowState", "refreshHeaderFooterWording", "refreshImgBgmTag", "refreshLiveIcon", "refreshLocalAwesomeIv", "refreshOpLayout", "refreshPrivateIcon", "refreshProgress", "refreshText", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Z)V", "refreshRealNameRecommendLayout", "refeshByClick", "refreshRecommendLayout", "refreshSimilarEntrance", "refreshUpdateTime", "report21464", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setFooterOpLayoutVisibility", "visibility", "setGroupLikeIcon", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "setNewsTitle", "topicName", "setNicknameCalculateWidth", "shareFeed", "showActivityInfo", "nickName", "showNewsIndicator", "userName", "showOrDimissSelfFeedLikeTips", "isBind", "(ZLcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "showPrivateFeedLikeTips", "isPrivateClick", "showSelfFeedLikeTips", "(Landroid/view/View;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "vibrate", "Companion", "StateListener", "plugin-finder_release"})
public abstract class m<T extends BaseFinderFeed>
  extends com.tencent.mm.view.recyclerview.e<T>
{
  public static final a xhV = new a((byte)0);
  private Rect byG;
  final int fEH;
  private boolean safeMode;
  Dialog tipDialog;
  private final int xhI;
  private final int xhJ;
  private final int xhK;
  private final int xhL;
  private int xhM;
  private final HashSet<b<T>> xhN;
  public View.OnClickListener xhO;
  private Runnable xhP;
  private final FinderFeedConvert.uiLifecycleObserver.1 xhQ;
  private final boolean xhR;
  private final boolean xhS;
  private final int xhT;
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  
  public m(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    this.xhU = parami;
    this.safeMode = paramBoolean;
    this.fEH = paramInt;
    this.xhI = 10000;
    this.xhJ = 10001;
    this.xhK = 10002;
    this.xhL = 10003;
    parami = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.xhM = ((Number)com.tencent.mm.plugin.finder.storage.d.dVe().aSr()).intValue();
    this.xhN = new HashSet();
    this.xhQ = new FinderFeedConvert.uiLifecycleObserver.1(this);
    parami = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dTE().aSr()).intValue() == 1)
    {
      paramBoolean = true;
      this.xhR = paramBoolean;
      parami = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dTF().aSr()).intValue() != 1) {
        break label192;
      }
    }
    label192:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.xhS = paramBoolean;
      parami = com.tencent.mm.plugin.finder.storage.d.AjH;
      this.xhT = ((Number)com.tencent.mm.plugin.finder.storage.d.dVX().aSr()).intValue();
      this.byG = new Rect();
      return;
      paramBoolean = false;
      break;
    }
  }
  
  private static int a(boolean paramBoolean1, boolean paramBoolean2, BaseFinderFeed paramBaseFinderFeed)
  {
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed.contact))
    {
      if (paramBoolean1) {
        return b.i.finder_filled_like_lock;
      }
      return b.i.finder_outlined_like_lock;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return b.i.finder_filled_like_lock;
      }
      return b.i.icon_filled_awesome;
    }
    return b.i.icon_outlined_awesome;
  }
  
  public static com.tencent.mm.cd.b a(T paramT)
  {
    p.k(paramT, "item");
    return paramT.likeBuffer;
  }
  
  private static void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt2 + ')';
    paramString = new StringBuilder(paramString);
    paramInt1 = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    parami = parami.getContext();
    p.j(parami, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parami.getResources().getColor(b.c.Red)), paramInt1, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private static void a(int paramInt, com.tencent.mm.view.recyclerview.i parami, String paramString, TextView paramTextView)
  {
    Object localObject = "(+" + paramInt + ')';
    if (paramString == null) {
      p.iCn();
    }
    paramString = new StringBuilder(paramString);
    paramInt = paramString.length();
    paramString.append((String)localObject);
    localObject = new SpannableStringBuilder((CharSequence)paramString);
    parami = parami.getContext();
    p.j(parami, "holder.context");
    ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parami.getResources().getColor(b.c.Red)), paramInt, paramString.length(), 17);
    paramTextView.setText((CharSequence)localObject);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.i parami)
  {
    if (this.xhU.dsp())
    {
      parami.nx(b.f.footer_op_layout, 8);
      parami.nx(b.f.self_footer_op_layout, 0);
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Boolean)com.tencent.mm.plugin.finder.storage.d.dUV().aSr()).booleanValue()) && (paramT.feedObject.field_id % 2L == 0L))
      {
        if ((!p.h(com.tencent.mm.plugin.finder.utils.m.ADy, "zh_CN")) && (!p.h(com.tencent.mm.plugin.finder.utils.m.ADy, "zh_HK")) && (!p.h(com.tencent.mm.plugin.finder.utils.m.ADy, "zh_TW"))) {
          break label558;
        }
        paramT.feedObject.setReadCount(9998);
        paramT.feedObject.setForwardCount(99980000);
        paramT.feedObject.setLikeCount(120000000);
        paramT.feedObject.setCommentCount(120000000);
        paramT.feedObject.setFavCount(120000000);
      }
      for (;;)
      {
        localObject = parami.RD(b.f.self_read_count_tv);
        p.j(localObject, "holder.getView<TextView>(R.id.self_read_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getReadCount()));
        localObject = parami.RD(b.f.self_forward_count_tv);
        p.j(localObject, "holder.getView<TextView>…id.self_forward_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getForwardCount()));
        localObject = parami.RD(b.f.self_like_count_tv);
        p.j(localObject, "holder.getView<TextView>(R.id.self_like_count_tv)");
        localObject = (TextView)localObject;
        l.a locala = com.tencent.mm.plugin.finder.upload.action.l.ACj;
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.QH(com.tencent.mm.plugin.finder.upload.action.l.ecG().s(paramT.feedObject.getFeedObject())));
        localObject = parami.RD(b.f.self_comment_count_tv);
        p.j(localObject, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getCommentCount()));
        localObject = parami.RD(b.f.self_fav_count_tv);
        p.j(localObject, "holder.getView<TextView>(R.id.self_fav_count_tv)");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getFavCount()));
        parami.RD(b.f.self_like_container).setOnClickListener((View.OnClickListener)new al(parami, paramT));
        parami.RD(b.f.self_share_container).setOnClickListener((View.OnClickListener)new am(this, parami));
        parami.nx(b.f.comment_layout, 0);
        parami.nx(b.f.update_time, 0);
        parami.e(b.f.update_time, (CharSequence)com.tencent.mm.plugin.finder.utils.m.f(parami.getContext(), paramT.feedObject.getCreateTime() * 1000L));
        localObject = parami.getContext();
        p.j(localObject, "holder.context");
        float f = ((Context)localObject).getResources().getDimensionPixelSize(b.d.DescTextSize);
        ((TextView)parami.RD(b.f.self_read_count_tv)).setTextSize(0, f);
        ((TextView)parami.RD(b.f.self_forward_count_tv)).setTextSize(0, f);
        ((TextView)parami.RD(b.f.self_like_count_tv)).setTextSize(0, f);
        ((TextView)parami.RD(b.f.self_comment_count_tv)).setTextSize(0, f);
        ((TextView)parami.RD(b.f.self_fav_count_tv)).setTextSize(0, f);
        b(paramT, parami);
        return;
        label558:
        paramT.feedObject.setReadCount(999);
        paramT.feedObject.setForwardCount(1000);
        paramT.feedObject.setLikeCount(1000000);
        paramT.feedObject.setCommentCount(990000000);
        paramT.feedObject.setFavCount(1200000000);
      }
    }
    parami.nx(b.f.footer_op_layout, 0);
    parami.nx(b.f.self_footer_op_layout, 8);
    Object localObject = com.tencent.mm.plugin.finder.upload.action.c.ABD;
    boolean bool1 = com.tencent.mm.plugin.finder.upload.action.c.ecy().p(paramT.feedObject.getFeedObject());
    localObject = com.tencent.mm.plugin.finder.upload.action.c.ABD;
    a(bool1, com.tencent.mm.plugin.finder.upload.action.c.ecy().q(paramT.feedObject.getFeedObject()), parami);
    localObject = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    localObject = com.tencent.mm.plugin.finder.upload.action.l.ecG().r(paramT.feedObject.getFeedObject());
    bool1 = ((Boolean)((kotlin.o)localObject).Mx).booleanValue();
    boolean bool2 = ((Boolean)((kotlin.o)localObject).My).booleanValue();
    localObject = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    a(paramT, bool1, bool2, com.tencent.mm.plugin.finder.upload.action.l.ecG().s(paramT.feedObject.getFeedObject()), parami);
  }
  
  private final void a(final T paramT, final com.tencent.mm.view.recyclerview.i parami, final boolean paramBoolean)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    final LinkedList localLinkedList = com.tencent.mm.plugin.finder.upload.action.l.ecG().u(paramT.feedObject.getFeedObject());
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    final int j = com.tencent.mm.plugin.finder.upload.action.l.ecG().t(paramT.feedObject.getFeedObject());
    if ((this.xhR) && (!Util.isNullOrNil((List)localLinkedList)) && (j > 0) && (!this.xhU.dsp()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.j(paramT.contact)) {}
    }
    else
    {
      Log.i("Finder.FeedConvert", "refreshRealNameRecommendLayout tabType:" + this.fEH + ", " + Util.isNullOrNil((List)localLinkedList) + ", " + j + ' ' + this.xhR);
      paramT = parami.RD(b.f.real_name_recommend_layout);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    final boolean bool1 = com.tencent.mm.plugin.finder.utils.aj.v(paramT);
    if (this.xhS) {}
    final boolean bool2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    FrameLayout localFrameLayout;
    for (final float f = 0.2F;; f = 0.5F)
    {
      bool2 = this.xhS;
      localObject1 = parami.RD(b.f.real_name_recommend_layout);
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      localObject2 = (List)new ArrayList();
      ((List)localObject2).add(parami.RD(b.f.friend_avatar_1));
      ((List)localObject2).add(parami.RD(b.f.friend_avatar_2));
      ((List)localObject2).add(parami.RD(b.f.friend_avatar_3));
      localObject3 = (List)new ArrayList();
      localObject4 = (FrameLayout)parami.RD(b.f.friend_avatar_1_layout);
      localObject5 = (FrameLayout)parami.RD(b.f.friend_avatar_2_layout);
      localFrameLayout = (FrameLayout)parami.RD(b.f.friend_avatar_3_layout);
      localObject1 = (FrameLayout)parami.RD(b.f.friend_avatar_layout_extra);
      if (!this.xhS) {
        break label1099;
      }
      p.j(localObject4, "layout1");
      localObject6 = ((FrameLayout)localObject4).getLayoutParams();
      if (localObject6 != null) {
        break label387;
      }
      throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    label387:
    Object localObject6 = (FrameLayout.LayoutParams)localObject6;
    Object localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    p.j(localObject5, "layout2");
    localObject6 = ((FrameLayout)localObject5).getLayoutParams();
    if (localObject6 == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    ((FrameLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    p.j(localFrameLayout, "layout3");
    localObject6 = localFrameLayout.getLayoutParams();
    if (localObject6 == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).leftMargin = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_7A));
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject6);
    p.j(localObject1, "layoutExtra");
    localObject6 = ((FrameLayout)localObject1).getLayoutParams();
    if (localObject6 == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
    localObject6 = (FrameLayout.LayoutParams)localObject6;
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).width = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    localObject7 = parami.getContext();
    p.j(localObject7, "holder.context");
    ((FrameLayout.LayoutParams)localObject6).height = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3_5_A));
    ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject6 = ((List)localObject2).iterator();
    if (((Iterator)localObject6).hasNext())
    {
      localObject7 = (ImageView)((Iterator)localObject6).next();
      if (localObject7 != null) {}
      for (localObject1 = ((ImageView)localObject7).getLayoutParams();; localObject1 = null)
      {
        Context localContext;
        if (localObject1 != null)
        {
          localContext = parami.getContext();
          p.j(localContext, "holder.context");
          ((ViewGroup.LayoutParams)localObject1).width = ((int)localContext.getResources().getDimension(b.d.Edge_3A));
        }
        if (localObject1 != null)
        {
          localContext = parami.getContext();
          p.j(localContext, "holder.context");
          ((ViewGroup.LayoutParams)localObject1).height = ((int)localContext.getResources().getDimension(b.d.Edge_3A));
        }
        if (localObject7 == null) {
          break;
        }
        ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
    localObject6 = parami.RD(b.f.friend_avatar_extra);
    if (localObject6 != null)
    {
      localObject1 = ((View)localObject6).getLayoutParams();
      label1015:
      if (localObject1 != null)
      {
        localObject7 = parami.getContext();
        p.j(localObject7, "holder.context");
        ((ViewGroup.LayoutParams)localObject1).width = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3A));
      }
      if (localObject1 != null)
      {
        localObject7 = parami.getContext();
        p.j(localObject7, "holder.context");
        ((ViewGroup.LayoutParams)localObject1).height = ((int)((Context)localObject7).getResources().getDimension(b.d.Edge_3A));
      }
      if (localObject6 != null) {
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      label1099:
      ((List)localObject3).add(localObject4);
      ((List)localObject3).add(localObject5);
      ((List)localObject3).add(localFrameLayout);
      localObject1 = (RoundLinearLayout)parami.RD(b.f.bg_color_layout1);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.aazN;
      }
      localObject1 = (RoundLinearLayout)parami.RD(b.f.bg_color_layout2);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.aazN;
      }
      localObject1 = (RoundLinearLayout)parami.RD(b.f.bg_color_layout3);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.aazN;
      }
      localObject1 = (RoundLinearLayout)parami.RD(b.f.friend_avatar_extra_layout);
      if (localObject1 != null)
      {
        ((RoundLinearLayout)localObject1).setRadius(f);
        localObject1 = kotlin.x.aazN;
      }
      localObject1 = new aa.a();
      localObject4 = new aa.a();
      localObject5 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      localObject5 = com.tencent.mm.plugin.finder.upload.action.l.ecG().r(paramT.feedObject.getFeedObject());
      ((aa.a)localObject1).aaBx = ((Boolean)((kotlin.o)localObject5).Mx).booleanValue();
      ((aa.a)localObject4).aaBx = ((Boolean)((kotlin.o)localObject5).My).booleanValue();
      localObject5 = new aa.f();
      ((aa.f)localObject5).aaBC = ((kotlin.g.a.a)new ax((aa.a)localObject1, (aa.a)localObject4, this, parami, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1));
      ((kotlin.g.a.a)new ay((List)localObject2, (List)localObject3, (aa.f)localObject5, this, parami, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1)).invoke();
      localObject4 = (TextView)parami.RD(b.f.real_name_recommend_nickname);
      if (localObject4 != null)
      {
        if (!bool2) {
          break label1802;
        }
        if (localLinkedList.size() > 3) {
          break label1719;
        }
        localObject5 = parami.getContext();
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = (FinderCommentInfo)j.lr((List)localLinkedList);
        if (localObject1 != null)
        {
          localObject1 = ((FinderCommentInfo)localObject1).username;
          if (localObject1 != null) {
            break label2122;
          }
        }
        localObject1 = "";
      }
    }
    label1665:
    label1719:
    label2119:
    label2122:
    for (;;)
    {
      localObject2 = (FinderCommentInfo)j.lr((List)localLinkedList);
      if (localObject2 != null)
      {
        localObject3 = ((FinderCommentInfo)localObject2).nickname;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.aj.ht((String)localObject1, (String)localObject2));
      localObject1 = (CharSequence)localObject1;
      ((TextView)localObject4).setText((CharSequence)localObject1);
      localObject1 = kotlin.x.aazN;
      localObject3 = (TextView)parami.RD(b.f.real_name_recommend_desc);
      int k = paramT.feedObject.getFeedObject().incFriendLikeCount;
      int m = j - k;
      if (j == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
        if (com.tencent.mm.plugin.finder.storage.logic.g.Qt(paramT.feedObject.getFeedObject().objectType) == null)
        {
          localObject1 = parami.getContext().getString(b.j.finder_real_name_recommend_desc2);
          label1615:
          p.j(localObject1, "if (wordingConfig == nul…里不需要文案了\n                }");
          if ((k <= 0) || (!bool1)) {
            break label1896;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          p.j(localObject3, "descTv");
          a(k, parami, (String)localObject2, (TextView)localObject3);
          localObject1 = parami.RD(b.f.real_name_recommend_list);
          if (localObject1 == null) {
            break;
          }
          ((View)localObject1).setOnClickListener((View.OnClickListener)new az(this, parami, f, paramT, paramBoolean, localLinkedList, bool2, j, bool1));
          paramT = kotlin.x.aazN;
          return;
          localObject1 = null;
          break label1015;
          localObject5 = parami.getContext();
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject1 = ((FinderCommentInfo)localLinkedList.get(2)).username;
          if (localObject1 != null) {
            break label2119;
          }
          localObject1 = "";
        }
      }
      for (;;)
      {
        localObject3 = ((FinderCommentInfo)localLinkedList.get(2)).nickname;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.aj.ht((String)localObject1, (String)localObject2));
        break;
        localObject5 = parami.getContext();
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = ((FinderCommentInfo)localLinkedList.get(0)).username;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localObject3 = ((FinderCommentInfo)localLinkedList.get(0)).nickname;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject1 = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)com.tencent.mm.plugin.finder.utils.aj.ht((String)localObject1, (String)localObject2));
          break;
          localObject1 = "";
          break label1615;
          label1896:
          p.j(localObject3, "descTv");
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1665;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(paramT.feedObject.getFeedObject().objectType);
          int i;
          if (localObject1 != null)
          {
            localObject2 = (CharSequence)((bfz)localObject1).SQF;
            if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
            {
              i = 1;
              if (i == 0) {
                break label2055;
              }
            }
          }
          else
          {
            localObject1 = parami.getContext().getString(b.j.finder_real_name_recommend_desc1, new Object[] { String.valueOf(m + k) });
          }
          for (;;)
          {
            if ((k <= 0) || (!bool1)) {
              break label2095;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            p.j(localObject3, "descTv");
            a(m, k, parami, (String)localObject2, (TextView)localObject3);
            break;
            i = 0;
            break label1970;
            localObject1 = ((bfz)localObject1).SQF;
            if (localObject1 != null) {
              localObject1 = kotlin.n.n.l((String)localObject1, "$$", String.valueOf(m + k), true);
            } else {
              localObject1 = null;
            }
          }
          p.j(localObject3, "descTv");
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1665;
        }
      }
    }
  }
  
  private static void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.i parami)
  {
    LinearLayout localLinearLayout = (LinearLayout)parami.RD(b.f.awesome_icon_container);
    Object localObject2 = (WeImageView)parami.RD(b.f.icon_feed_like);
    int i;
    label102:
    int j;
    boolean bool;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        p.j(localObject2, "awesomeIv");
        ((WeImageView)localObject2).setTag(Integer.valueOf(2));
        i = a(true, paramBoolean2, paramBaseFinderFeed);
        localObject1 = parami.getContext();
        p.j(localObject1, "holder.context");
        localObject1 = new kotlin.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(b.c.Red_90)));
        i = ((Number)((kotlin.o)localObject1).Mx).intValue();
        j = ((Number)((kotlin.o)localObject1).My).intValue();
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        bool = com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed.contact);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
        if ((!paramBoolean2) || (!paramBoolean1) || (bool)) {
          break label430;
        }
        a((WeImageView)localObject2, (bfz)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = (TextView)parami.RD(b.f.feed_like_count_tv);
      if (paramInt <= 0) {
        break label591;
      }
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.m.gY(2, paramInt);
      p.j(paramBaseFinderFeed, "FinderFormatUtil.formatN…cene.SCENE_WX, likeCount)");
      p.j(localObject2, "likeTv");
      ar.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
      localObject1 = parami.getContext();
      if (localObject1 == null) {
        break label706;
      }
      localObject1 = ((Context)localObject1).getString(b.j.finder_like_count_text);
      label256:
      if (!paramBoolean1) {
        break label718;
      }
      parami = parami.getContext();
      if (parami == null) {
        break label712;
      }
      parami = parami.getString(b.j.finder_like_lick_confirm);
      label282:
      parami = (String)localObject1 + paramBaseFinderFeed + ", " + parami;
      label314:
      if (localLinearLayout != null) {
        localLinearLayout.setContentDescription((CharSequence)parami);
      }
      ((TextView)localObject2).setText((CharSequence)paramBaseFinderFeed);
      return;
      p.j(localObject2, "awesomeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(1));
      break;
      p.j(localObject2, "awesomeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(0));
      i = a(false, paramBoolean2, paramBaseFinderFeed);
      localObject1 = parami.getContext();
      p.j(localObject1, "holder.context");
      localObject1 = new kotlin.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(b.c.black_color)));
      break label102;
      label430:
      if ((localObject1 != null) && (!bool) && (!paramBoolean2))
      {
        if (paramBoolean1) {
          if (ar.isDarkMode()) {
            localObject1 = ((bfz)localObject1).SQK;
          }
        }
        for (;;)
        {
          Object localObject3 = ((WeImageView)localObject2).getDrawable();
          if (localObject3 != null) {
            ((Drawable)localObject3).clearColorFilter();
          }
          ((WeImageView)localObject2).setClearColorFilter(true);
          localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
          localObject2 = (ImageView)localObject2;
          com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
          break;
          localObject1 = ((bfz)localObject1).SQL;
          continue;
          if (ar.isDarkMode()) {
            localObject1 = ((bfz)localObject1).SQM;
          } else {
            localObject1 = ((bfz)localObject1).SQN;
          }
        }
      }
      ((WeImageView)localObject2).setImageResource(i);
      ((WeImageView)localObject2).setIconColor(j);
    }
    label591:
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
    paramBaseFinderFeed = com.tencent.mm.plugin.finder.storage.logic.g.Qt(paramBaseFinderFeed.feedObject.getFeedObject().objectType);
    if (paramBaseFinderFeed != null)
    {
      localObject1 = (CharSequence)paramBaseFinderFeed.SQO;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        paramInt = 1;
        label640:
        if (paramInt == 0) {
          break label690;
        }
      }
    }
    else
    {
      paramBaseFinderFeed = parami.getContext().getString(b.j.finder_like_count_text);
      p.j(paramBaseFinderFeed, "holder.context.getString…g.finder_like_count_text)");
    }
    for (;;)
    {
      p.j(localObject2, "likeTv");
      ar.b((Paint)((TextView)localObject2).getPaint());
      break;
      paramInt = 0;
      break label640;
      label690:
      paramBaseFinderFeed = paramBaseFinderFeed.SQO;
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = "";
        continue;
        label706:
        localObject1 = null;
        break label256;
        label712:
        parami = null;
        break label282;
        label718:
        parami = (String)localObject1 + paramBaseFinderFeed;
        break label314;
      }
    }
  }
  
  protected static void a(FinderMediaBanner paramFinderMediaBanner, List<? extends csg> paramList, long paramLong)
  {
    int j = 1;
    p.k(paramFinderMediaBanner, "banner");
    p.k(paramList, "mediaList");
    if (j.lp(paramList) == null)
    {
      Log.e("Finder.FeedConvert", "feedId=" + paramLong + " mediaList first null");
      return;
    }
    Object localObject = (csg)j.lo(paramList);
    float f1 = 0.0F;
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = (List<? extends csg>)localObject;
    label80:
    if (localIterator.hasNext())
    {
      localObject = (csg)localIterator.next();
      Size localSize = com.tencent.mm.plugin.finder.storage.data.i.a((csg)localObject, false);
      float f2 = 1.0F * localSize.getHeight() / localSize.getWidth();
      if (f1 >= f2) {
        break label285;
      }
      f1 = f2;
      paramList = (List<? extends csg>)localObject;
    }
    label285:
    for (;;)
    {
      break label80;
      paramList = com.tencent.mm.plugin.finder.storage.data.i.a(paramList, false);
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject = paramFinderMediaBanner.getContext();
      p.j(localObject, "banner.context");
      paramList = com.tencent.mm.plugin.finder.utils.aj.g((Context)localObject, paramList.getWidth(), paramList.getHeight());
      localObject = paramFinderMediaBanner.getPagerView().getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject).width != ((Number)paramList.My).intValue()) {
        ((ViewGroup.LayoutParams)localObject).width = ((Number)paramList.My).intValue();
      }
      for (int i = 1;; i = 0)
      {
        if (((ViewGroup.LayoutParams)localObject).height != ((Number)paramList.aazK).intValue())
        {
          ((ViewGroup.LayoutParams)localObject).height = ((Number)paramList.aazK).intValue();
          i = j;
        }
        while (i != 0)
        {
          paramFinderMediaBanner.requestLayout();
          return;
        }
        break;
      }
    }
  }
  
  private static void a(WeImageView paramWeImageView, bfz parambfz)
  {
    if (parambfz != null)
    {
      parambfz = parambfz.SQP;
      localObject = (CharSequence)parambfz;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label79;
      }
    }
    label79:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label84;
      }
      parambfz = paramWeImageView.getContext();
      i = b.i.icons_filled_like_group;
      localObject = paramWeImageView.getContext();
      p.j(localObject, "imageView.context");
      paramWeImageView.setImageDrawable(au.o(parambfz, i, ((Context)localObject).getResources().getColor(b.c.Red_90)));
      return;
      parambfz = null;
      break;
    }
    label84:
    Object localObject = paramWeImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).clearColorFilter();
    }
    paramWeImageView.setClearColorFilter(true);
    localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
    parambfz = new com.tencent.mm.plugin.finder.loader.x(parambfz, u.Aly);
    paramWeImageView = (ImageView)paramWeImageView;
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(parambfz, paramWeImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
  }
  
  private static void a(com.tencent.mm.view.recyclerview.i parami)
  {
    parami.amk.performHapticFeedback(0, 3);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.i parami, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parami.ihX();
    Object localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ecG().r(localBaseFinderFeed.feedObject.getFeedObject());
    boolean bool1 = ((Boolean)((kotlin.o)localObject1).Mx).booleanValue();
    boolean bool3 = ((Boolean)((kotlin.o)localObject1).My).booleanValue();
    Object localObject2;
    WeImageView localWeImageView;
    Object localObject3;
    label129:
    label140:
    label226:
    boolean bool2;
    if (!bool1)
    {
      bool1 = true;
      if (!bool1) {
        break label802;
      }
      localObject2 = parami.RD(b.f.icon_feed_like);
      localWeImageView = (WeImageView)parami.RD(b.f.like_icon);
      if (localWeImageView != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(localBaseFinderFeed.feedObject.getFeedObject().objectType);
        if (localObject3 != null) {
          break label474;
        }
        localObject1 = "";
        if (!paramBoolean) {
          break label500;
        }
        a(localWeImageView, (bfz)localObject3);
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.BdF;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 0.0F, null, false, 30);
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.BdF;
        p.j(localObject2, "likeIcon");
        com.tencent.mm.plugin.finder.view.animation.c.eT((View)localObject2);
      }
      if ((paramInt == 1) || (paramInt == 2) || (paramBoolean)) {
        a(parami);
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.j(localBaseFinderFeed.contact)) {
        break label731;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dUX() > 0) {
        a(parami, false);
      }
      if (!bool1) {
        break label848;
      }
      bool2 = false;
      label234:
      localObject1 = this.xhU;
      p.j(localBaseFinderFeed, "item");
      ((com.tencent.mm.plugin.finder.feed.i)localObject1).a(localBaseFinderFeed, bool1, paramBoolean, paramInt, bool2);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      a(localBaseFinderFeed, bool1, paramBoolean, com.tencent.mm.plugin.finder.upload.action.l.ecG().s(localBaseFinderFeed.feedObject.getFeedObject()), parami);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if ((com.tencent.mm.plugin.finder.utils.aj.v(localBaseFinderFeed)) && (!paramBoolean))
      {
        if (!bool1) {
          break label855;
        }
        localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
        ((FinderObject)localObject1).incFriendLikeCount += 1;
      }
      label335:
      a(this, bool1, parami, localBaseFinderFeed);
      localObject1 = new hu();
      ((hu)localObject1).fEL.id = localBaseFinderFeed.mf();
      ((hu)localObject1).fEL.type = 4;
      localObject2 = ((hu)localObject1).fEL;
      if ((!bool1) || (!paramBoolean)) {
        break label885;
      }
      paramInt = 2;
    }
    for (;;)
    {
      ((hu.a)localObject2).fEO = paramInt;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      parami = parami.getContext();
      p.j(parami, "holder.context");
      parami = aj.a.fZ(parami);
      if (parami != null)
      {
        parami = com.tencent.mm.plugin.finder.viewmodel.component.aj.b(parami);
        if (parami != null)
        {
          parami = parami.dpO();
          if (!bool1) {
            break label898;
          }
          parami.KD(localBaseFinderFeed.mf());
        }
      }
      return;
      bool1 = false;
      break;
      label474:
      if (ar.isDarkMode())
      {
        localObject1 = ((bfz)localObject3).SQK;
        break label129;
      }
      localObject1 = ((bfz)localObject3).SQL;
      break label129;
      label500:
      localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.j(localBaseFinderFeed.contact))
      {
        localObject1 = parami.getContext();
        i = b.i.finder_filled_like_lock;
        localObject3 = parami.getContext();
        p.j(localObject3, "holder.context");
        localWeImageView.setImageDrawable(au.o((Context)localObject1, i, ((Context)localObject3).getResources().getColor(b.c.Red_90)));
        break label140;
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label680;
        }
        localObject3 = localWeImageView.getDrawable();
        if (localObject3 != null) {
          ((Drawable)localObject3).clearColorFilter();
        }
        localWeImageView.setClearColorFilter(true);
        localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject3).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        break;
      }
      label680:
      localObject1 = parami.getContext();
      i = b.i.icon_filled_awesome;
      localObject3 = parami.getContext();
      p.j(localObject3, "holder.context");
      localWeImageView.setImageDrawable(au.o((Context)localObject1, i, ((Context)localObject3).getResources().getColor(b.c.Red_90)));
      break label140;
      label731:
      if (paramBoolean) {
        break label226;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dVF().aSr()).intValue() != 1) {
        break label226;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dVF().aSr()).intValue() != 1) {
        break label226;
      }
      localBaseFinderFeed.showCommentEdu = true;
      p.j(localBaseFinderFeed, "item");
      b(parami, localBaseFinderFeed, 1);
      break label226;
      label802:
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dVF().aSr()).intValue() != 1) {
        break label226;
      }
      localBaseFinderFeed.showCommentEdu = false;
      p.j(localBaseFinderFeed, "item");
      b(parami, localBaseFinderFeed, 1);
      break label226;
      label848:
      bool2 = bool3;
      break label234;
      label855:
      if (bool3) {
        break label335;
      }
      localObject1 = localBaseFinderFeed.feedObject.getFeedObject();
      ((FinderObject)localObject1).incFriendLikeCount -= 1;
      break label335;
      label885:
      paramInt = j;
      if (bool1) {
        paramInt = 1;
      }
    }
    label898:
    parami.KE(localBaseFinderFeed.mf());
  }
  
  @SuppressLint({"ResourceType"})
  private final void a(com.tencent.mm.view.recyclerview.i parami, T paramT)
  {
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = parami.getContext();
    p.j(localObject, "holder.context");
    localObject = aj.a.fZ((Context)localObject);
    int i;
    boolean bool;
    if (localObject != null)
    {
      i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).xkX;
      localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
      bool = com.tencent.mm.plugin.finder.api.d.a.aAN(paramT.feedObject.field_username);
      if (!this.safeMode) {
        break label115;
      }
      parami.nx(b.f.follow_tv, 8);
    }
    for (;;)
    {
      if ((i != 1) || (paramT.feedObject.getCreateTime() * 1000L < cm.bfC() - 86400000L)) {
        break label293;
      }
      parami.nx(b.f.recommend_reason_layout, 8);
      return;
      i = 0;
      break;
      label115:
      if ((this.fEH != 3) && (bool) && (i != 1))
      {
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.j(paramT))
        {
          parami.nx(b.f.follow_tv, 0);
          localObject = (TextView)parami.RD(b.f.follow_tv);
          p.j(localObject, "followIv");
          Context localContext = ((TextView)localObject).getContext();
          p.j(localContext, "followIv.context");
          ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.has_follow_tip));
          ((TextView)localObject).setTextSize(0, com.tencent.mm.ci.a.aZ(((TextView)localObject).getContext(), b.d.Edge_1_5_A));
          localContext = parami.getContext();
          p.j(localContext, "holder.context");
          ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.FG_1));
          ((TextView)localObject).setBackgroundResource(b.e.finder_follow_btn_shape);
          continue;
        }
      }
      if ((!bool) || (this.fEH == 3)) {
        parami.nx(b.f.follow_tv, 8);
      }
    }
    label293:
    parami.nx(b.f.recommend_reason_layout, 0);
  }
  
  private static void a(com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem, Boolean paramBoolean)
  {
    FinderFeedLiveNoticeView localFinderFeedLiveNoticeView = (FinderFeedLiveNoticeView)parami.RD(b.f.finder_feed_live_notice_view);
    String str;
    if (paramFinderItem != null)
    {
      str = paramFinderItem.getUserName();
      if (str != null) {}
    }
    else
    {
      str = "";
    }
    for (;;)
    {
      if (localFinderFeedLiveNoticeView != null)
      {
        if (p.h(paramBoolean, Boolean.FALSE)) {
          localFinderFeedLiveNoticeView.setVisibility(8);
        }
        paramBoolean = com.tencent.mm.plugin.finder.utils.aj.AGc;
        paramBoolean = parami.getContext();
        p.j(paramBoolean, "holder.context");
        if (!com.tencent.mm.plugin.finder.utils.aj.a(paramBoolean, paramFinderItem)) {
          break label298;
        }
        if (!(parami.getContext() instanceof MMActivity)) {
          break label165;
        }
        paramBoolean = com.tencent.mm.ui.component.g.Xox;
        paramBoolean = parami.getContext();
        if (paramBoolean == null) {
          throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        com.tencent.mm.ui.component.g.b((AppCompatActivity)paramBoolean).i(com.tencent.mm.plugin.finder.live.component.y.class);
      }
      label165:
      for (paramBoolean = com.tencent.mm.plugin.finder.feed.model.k.aBH(str); paramBoolean != null; paramBoolean = null)
      {
        Log.i("Finder.FeedConvert", "update live notice from cache");
        parami = parami.getContext();
        p.j(parami, "holder.context");
        FinderFeedLiveNoticeView.a(localFinderFeedLiveNoticeView, parami, paramBoolean, str);
        return;
      }
      if (localFinderFeedLiveNoticeView.getVisibility() == 0)
      {
        Log.i("Finder.FeedConvert", "notice info no cache ,request again");
        paramBoolean = com.tencent.mm.ui.component.g.Xox;
        parami = parami.getContext();
        if (parami == null) {
          throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        }
        paramBoolean = ((com.tencent.mm.plugin.finder.live.component.y)com.tencent.mm.ui.component.g.b((AppCompatActivity)parami).i(com.tencent.mm.plugin.finder.live.component.y.class)).yci;
        if (paramFinderItem != null)
        {
          parami = paramFinderItem.getFeedObject();
          if (parami != null)
          {
            parami = Long.valueOf(parami.id);
            if (paramFinderItem == null) {
              break label285;
            }
            paramFinderItem = paramFinderItem.getFeedObject();
            if (paramFinderItem == null) {
              break label285;
            }
          }
        }
        label285:
        for (paramFinderItem = paramFinderItem.objectNonceId;; paramFinderItem = null)
        {
          paramBoolean.a(parami, paramFinderItem);
          return;
          parami = null;
          break;
        }
      }
      localFinderFeedLiveNoticeView.setVisibility(8);
      return;
      label298:
      localFinderFeedLiveNoticeView.setVisibility(8);
      return;
    }
  }
  
  private static void a(com.tencent.mm.view.recyclerview.i parami, boolean paramBoolean)
  {
    p.k(parami, "holder");
    aa.f localf = new aa.f();
    localf.aaBC = parami.RD(b.f.finder_private_feed_like_tips_layout);
    if ((View)localf.aaBC == null) {
      localf.aaBC = ((ViewStub)parami.RD(b.f.finder_private_feed_like_tips_layout_view_stub)).inflate();
    }
    Object localObject = (View)localf.aaBC;
    p.j(localObject, "tips");
    if (((View)localObject).getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (TextView)((View)localf.aaBC).findViewById(b.f.finder_private_feed_like_bubble_tips_tv);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parami.getContext().getString(b.j.finder_private_feed_like_tips2));
      }
      parami = com.tencent.mm.plugin.finder.storage.d.AjH;
      com.tencent.mm.plugin.finder.storage.d.Qf(com.tencent.mm.plugin.finder.storage.d.dUY() - 1);
    }
    for (;;)
    {
      parami = (View)localf.aaBC;
      p.j(parami, "tips");
      parami.setVisibility(0);
      parami = (View)localf.aaBC;
      p.j(parami, "tips");
      parami.setAlpha(1.0F);
      ((View)localf.aaBC).animate().cancel();
      ((View)localf.aaBC).animate().alpha(0.0F).setDuration(300L).setStartDelay(2000L).setListener((Animator.AnimatorListener)new m.bj(localf)).start();
      return;
      localObject = (TextView)((View)localf.aaBC).findViewById(b.f.finder_private_feed_like_bubble_tips_tv);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parami.getContext().getString(b.j.finder_private_feed_like_tips));
      }
      parami = com.tencent.mm.plugin.finder.storage.d.AjH;
      com.tencent.mm.plugin.finder.storage.d.Qe(com.tencent.mm.plugin.finder.storage.d.dUX() - 1);
    }
  }
  
  private final void a(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.i parami)
  {
    WeImageView localWeImageView = (WeImageView)parami.RD(b.f.fav_count_iv);
    TextView localTextView = (TextView)parami.RD(b.f.fav_count_tv);
    int i;
    if (localWeImageView != null)
    {
      if (paramBoolean)
      {
        i = b.i.finder_icons_filled_star;
        parami = parami.getContext();
        p.j(parami, "holder.context");
        parami = new kotlin.o(Integer.valueOf(i), Integer.valueOf(parami.getResources().getColor(b.c.Orange_100)));
        i = ((Number)parami.Mx).intValue();
        int j = ((Number)parami.My).intValue();
        localWeImageView.setImageResource(i);
        localWeImageView.setIconColor(j);
      }
    }
    else if (localTextView != null)
    {
      if (!this.xhU.dsp()) {
        break label218;
      }
      ar.a((Paint)localTextView.getPaint(), 0.8F);
      if (paramInt <= 0) {
        break label211;
      }
    }
    label211:
    for (parami = com.tencent.mm.plugin.finder.utils.m.gY(2, paramInt);; parami = "")
    {
      localTextView.setText((CharSequence)parami);
      return;
      i = b.i.finder_icons_outlined_star;
      parami = parami.getContext();
      p.j(parami, "holder.context");
      parami = new kotlin.o(Integer.valueOf(i), Integer.valueOf(parami.getResources().getColor(b.c.FG_0)));
      break;
    }
    label218:
    localTextView.setText(b.j.finder_fav_icon_text);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(parami, "holder");
    parami = parami.RD(b.f.more_btn);
    if (paramBoolean)
    {
      p.j(parami, "moreBtn");
      parami.setVisibility(0);
      return;
    }
    p.j(parami, "moreBtn");
    parami.setVisibility(8);
  }
  
  private void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.i parami, final T paramT, boolean paramBoolean2)
  {
    p.k(parami, "holder");
    p.k(paramT, "item");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.eec())
    {
      paramT = parami.RD(b.f.like_when_posting_container);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      parami = parami.RD(b.f.finder_self_feed_like_tips_layout);
      if (parami != null) {
        parami.setVisibility(8);
      }
    }
    do
    {
      return;
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.j(paramT.contact)) {
        break;
      }
      paramT = parami.RD(b.f.like_when_posting_container);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      parami = parami.RD(b.f.finder_self_feed_like_tips_layout);
    } while (parami == null);
    parami.setVisibility(8);
    return;
    localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if ((com.tencent.mm.plugin.finder.utils.aj.j(paramT)) && (paramT.showLikeTips) && (!paramT.feedObject.isPostFailed()))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dUl() < 3)
      {
        localObject1 = parami.RD(b.f.finder_self_feed_like_tips_layout);
        if (localObject1 != null) {
          break label568;
        }
        localObject1 = ((ViewStub)parami.RD(b.f.finder_self_feed_like_tips_layout_view_stub)).inflate();
      }
    }
    label568:
    for (;;)
    {
      if (!paramT.feedObject.isPostFinish())
      {
        if (paramBoolean1)
        {
          paramT.showLikeTips = false;
          p.j(localObject1, "tips");
          es((View)localObject1);
        }
        for (;;)
        {
          parami = parami.RD(b.f.like_when_posting_container);
          if (parami == null) {
            break;
          }
          parami.setVisibility(0);
          return;
          localObject2 = parami.RD(b.f.finder_self_feed_like_bubble_tips_tv);
          p.j(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.ci.a.ba(parami.getContext(), b.j.finder_feed_self_like_tips));
          if (paramBoolean2)
          {
            p.j(localObject1, "tips");
            if (a((View)localObject1, parami))
            {
              paramT.showLikeTips = false;
              continue;
            }
          }
          p.j(localObject1, "tips");
          if (((View)localObject1).getVisibility() != 0)
          {
            localObject2 = parami.RD(b.f.like_when_posting_container);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
            {
              ((View)localObject1).setVisibility(0);
              localObject2 = this.xhP;
              if (localObject2 != null) {
                ((View)localObject1).removeCallbacks((Runnable)localObject2);
              }
              this.xhP = ((Runnable)new bk(this, paramT, (View)localObject1));
              ((View)localObject1).postDelayed(this.xhP, 5000L);
            }
          }
        }
      }
      Object localObject2 = parami.RD(b.f.like_when_posting_container);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      if (paramBoolean1)
      {
        paramT.showLikeTips = false;
        p.j(localObject1, "tips");
        es((View)localObject1);
        return;
      }
      localObject2 = parami.RD(b.f.finder_self_feed_like_bubble_tips_tv);
      p.j(localObject2, "holder.getView<TextView>…feed_like_bubble_tips_tv)");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.ci.a.ba(parami.getContext(), b.j.finder_feed_self_like_tips));
      p.j(localObject1, "tips");
      if ((!a((View)localObject1, parami)) || (!paramBoolean2)) {
        break;
      }
      paramT.showLikeTips = false;
      return;
      paramT = parami.RD(b.f.finder_self_feed_like_tips_layout);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      paramT = parami.RD(b.f.profile_upload_area);
      if ((paramT == null) || (paramT.getVisibility() != 0)) {
        break;
      }
      parami = parami.RD(b.f.like_when_posting_container);
      if (parami == null) {
        break;
      }
      parami.setVisibility(0);
      return;
    }
  }
  
  private static void a(boolean paramBoolean1, com.tencent.mm.view.recyclerview.i parami, boolean paramBoolean2)
  {
    Object localObject2 = (BaseFinderFeed)parami.ihX();
    Object localObject1 = (WeImageView)parami.RD(b.f.profile_timeline_like_posting);
    Object localObject3;
    label105:
    int j;
    int k;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        if (localObject1 != null) {
          ((WeImageView)localObject1).setTag(Integer.valueOf(2));
        }
        localObject3 = parami.ihX();
        p.j(localObject3, "holder.getAssociatedObject()");
        i = a(true, paramBoolean2, (BaseFinderFeed)localObject3);
        parami = parami.getContext();
        p.j(parami, "holder.context");
        parami = new kotlin.o(Integer.valueOf(i), Integer.valueOf(parami.getResources().getColor(b.c.Red_90)));
        j = ((Number)parami.Mx).intValue();
        k = ((Number)parami.My).intValue();
        if (localObject1 != null)
        {
          parami = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectType);
          if (localObject2 != null) {
            break label275;
          }
          parami = "";
        }
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) || (!paramBoolean1)) {
        break label299;
      }
      a((WeImageView)localObject1, (bfz)localObject2);
      return;
      if (localObject1 == null) {
        break;
      }
      ((WeImageView)localObject1).setTag(Integer.valueOf(1));
      break;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setTag(Integer.valueOf(0));
      }
      localObject3 = parami.ihX();
      p.j(localObject3, "holder.getAssociatedObject()");
      i = a(false, paramBoolean2, (BaseFinderFeed)localObject3);
      parami = parami.getContext();
      p.j(parami, "holder.context");
      parami = new kotlin.o(Integer.valueOf(i), Integer.valueOf(parami.getResources().getColor(b.c.black_color)));
      break label105;
      label275:
      if (ar.isDarkMode()) {
        parami = ((bfz)localObject2).SQM;
      } else {
        parami = ((bfz)localObject2).SQN;
      }
    }
    label299:
    localObject2 = (CharSequence)parami;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.dOO()) {
        break;
      }
      localObject2 = ((WeImageView)localObject1).getDrawable();
      if (localObject2 != null) {
        ((Drawable)localObject2).clearColorFilter();
      }
      ((WeImageView)localObject1).setClearColorFilter(true);
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
      parami = new com.tencent.mm.plugin.finder.loader.x(parami, u.Aly);
      localObject1 = (ImageView)localObject1;
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(parami, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      return;
    }
    ((WeImageView)localObject1).setImageResource(j);
    ((WeImageView)localObject1).setIconColor(k);
  }
  
  private final boolean a(View paramView, com.tencent.mm.view.recyclerview.i parami)
  {
    Object localObject = parami.getRecyclerView();
    p.j(localObject, "holder.recyclerView");
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject != null)
    {
      if ((localObject instanceof LinearLayoutManager)) {}
      while (localObject != null) {
        if (localObject == null)
        {
          throw new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          localObject = null;
        }
        else
        {
          int j = ((LinearLayoutManager)localObject).kJ();
          int k = ((LinearLayoutManager)localObject).kL();
          localObject = parami.getRecyclerView();
          p.j(localObject, "holder.recyclerView");
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null)
          {
            if (localObject == null) {
              throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
            }
            localObject = (com.tencent.mm.view.recyclerview.h)localObject;
          }
          for (int i = parami.mc() - ((com.tencent.mm.view.recyclerview.h)localObject).YSk.size(); (j < k) && (i >= 0) && ((i < j) || (i > k)); i = -1)
          {
            es(paramView);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static void b(BaseFinderFeed paramBaseFinderFeed)
  {
    Iterator localIterator = ((Iterable)paramBaseFinderFeed.feedObject.getMediaList()).iterator();
    while (localIterator.hasNext())
    {
      csg localcsg = (csg)localIterator.next();
      if (localcsg.mediaType <= 0) {
        localcsg.mediaType = paramBaseFinderFeed.feedObject.getMediaType();
      }
    }
  }
  
  private static void b(T paramT, com.tencent.mm.view.recyclerview.i parami)
  {
    View localView = parami.RD(b.f.self_read_count_tv);
    p.j(localView, "holder.getView<TextView>(R.id.self_read_count_tv)");
    float f1 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getReadCount()));
    localView = parami.RD(b.f.self_forward_count_tv);
    p.j(localView, "holder.getView<TextView>…id.self_forward_count_tv)");
    float f2 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getForwardCount()));
    localView = parami.RD(b.f.self_like_count_tv);
    p.j(localView, "holder.getView<TextView>(R.id.self_like_count_tv)");
    float f3 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getLikeCount()));
    localView = parami.RD(b.f.self_comment_count_tv);
    p.j(localView, "holder.getView<TextView>…id.self_comment_count_tv)");
    float f4 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getCommentCount()));
    localView = parami.RD(b.f.self_fav_count_tv);
    p.j(localView, "holder.getView<TextView>(R.id.self_fav_count_tv)");
    float f5 = ((TextView)localView).getPaint().measureText(com.tencent.mm.plugin.finder.utils.m.QH(paramT.feedObject.getFavCount()));
    paramT = parami.getContext();
    p.j(paramT, "holder.context");
    float f6 = paramT.getResources().getDimensionPixelSize(b.d.Edge_3A);
    paramT = parami.getContext();
    p.j(paramT, "holder.context");
    int i = paramT.getResources().getDimensionPixelSize(b.d.Edge_13A);
    int j = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
    f1 = f5 + 1.0F + (f1 + 1.0F + (f2 + 1.0F) + (f3 + 1.0F) + (f4 + 1.0F)) + f6 * 5.0F + i;
    Log.d("Finder.FeedConvert", "contentWidthSum : " + f1 + " ,screenWidth : " + j);
    localView = parami.RD(b.f.self_footer_op_layout_right_part);
    paramT = parami.RD(b.f.self_footer_op_layout_first_line);
    p.j(paramT, "holder.getView<LinearLay…ter_op_layout_first_line)");
    paramT = (LinearLayout)paramT;
    parami = parami.RD(b.f.self_footer_op_layout_second_line);
    p.j(parami, "holder.getView<LinearLay…er_op_layout_second_line)");
    parami = (LinearLayout)parami;
    if (f1 < j) {
      parami.setVisibility(8);
    }
    for (;;)
    {
      p.j(localView, "rightPart");
      parami = localView.getParent();
      if (parami != null) {
        break;
      }
      throw new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout");
      parami.setVisibility(0);
      paramT = parami;
    }
    ((LinearLayout)parami).removeView(localView);
    paramT.addView(localView);
  }
  
  private void b(final T paramT, final com.tencent.mm.view.recyclerview.i parami, boolean paramBoolean)
  {
    boolean bool2 = true;
    p.k(paramT, "item");
    p.k(parami, "holder");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (!com.tencent.mm.plugin.finder.utils.aj.j(paramT))
    {
      a(0, parami);
      paramT = parami.RD(b.f.profile_upload_tip_container);
      if (paramT != null) {
        paramT.setVisibility(8);
      }
      a(true, parami);
      return;
    }
    boolean bool1;
    Object localObject2;
    if (paramT.feedObject.isPostFinish())
    {
      localObject1 = parami.RD(b.f.profile_upload_tip_container);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      a(0, parami);
      d(paramT, parami);
      localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)localObject1).dYT()) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = ag.AFH;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        ag.a((SpannableString)localObject1, bool1);
        if (paramBoolean)
        {
          localObject1 = (FinderCollapsibleTextView)parami.RD(b.f.text_content);
          localObject2 = parami.RD(b.f.right_btn_layout);
          ((FinderCollapsibleTextView)localObject1).a((CharSequence)paramT.feedObject.getDescriptionFullSpan(), (View)localObject2, (kotlin.g.a.b)new ar((FinderCollapsibleTextView)localObject1));
        }
        a(true, parami);
        e(paramT, parami);
        a(parami, paramT.feedObject);
        return;
      }
    }
    localObject1 = parami.RD(b.f.profile_upload_tip_container);
    Object localObject3;
    View localView1;
    if (localObject1 == null)
    {
      localObject3 = (m)this;
      localObject2 = ((ViewStub)parami.RD(b.f.profile_upload_tip_container_view_stub)).inflate();
      localView1 = ((View)localObject2).findViewById(b.f.awesome_icon_container_posting);
      localObject1 = localObject2;
      if (localView1 != null)
      {
        localView1.setOnTouchListener((View.OnTouchListener)new an((m)localObject3, parami));
        localView1.setOnClickListener((View.OnClickListener)new ao((m)localObject3, parami));
        localView1.setOnLongClickListener((View.OnLongClickListener)new ap((m)localObject3, parami));
        localView1.setHapticFeedbackEnabled(false);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = (FinderPostProgressView)((View)localObject1).findViewById(b.f.profile_upload_progress);
      localView1 = ((View)localObject1).findViewById(b.f.profile_upload_area);
      View localView2 = ((View)localObject1).findViewById(b.f.profile_item_failed_area);
      localObject3 = (TextView)((View)localObject1).findViewById(b.f.profile_item_failed_desc_tv);
      if (paramT.isPreview)
      {
        p.j(localObject1, "container");
        ((View)localObject1).setVisibility(8);
        a(8, parami);
        parami.nx(b.f.profile_timeline_retry, 0);
        a(false, parami);
        if (!paramT.feedObject.isPostFailed()) {
          break label1036;
        }
        p.j(localView2, "failedArea");
        localView2.setVisibility(0);
        p.j(localView1, "progressArea");
        localView1.setVisibility(8);
        if (paramT.feedObject.isPostFailedCanRetry()) {
          break label920;
        }
        parami.nx(b.f.profile_timeline_retry, 8);
        label525:
        if (!paramT.feedObject.isPostNoAuth()) {
          break label932;
        }
        p.j(localObject3, "failedTv");
        localObject1 = parami.getContext();
        p.j(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)Html.fromHtml(((Context)localObject1).getResources().getString(b.j.finder_post_tip_failed_no_auth)));
        ((TextView)localObject3).setOnClickListener((View.OnClickListener)new as(this));
        label595:
        localObject1 = parami.RD(b.f.finder_self_feed_like_tips_layout);
        if (localObject1 == null) {
          break label1030;
        }
        ((View)localObject1).setVisibility(8);
        bool1 = false;
        label619:
        parami.RD(b.f.delete_icon_container_posting).setOnClickListener((View.OnClickListener)new au(this, paramT));
        localObject1 = parami.RD(b.f.delete_tv_posting);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        parami.RD(b.f.profile_timeline_del2).setOnClickListener((View.OnClickListener)new av(this, paramT));
        parami.RD(b.f.profile_timeline_retry).setOnClickListener((View.OnClickListener)new aw(paramT));
        if (!bool1) {
          break label1306;
        }
        localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
        p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ae)localObject1).dYT()) {
          break label1306;
        }
      }
      for (;;)
      {
        localObject1 = ag.AFH;
        localObject2 = paramT.feedObject.getDescriptionFullSpan();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new SpannableString((CharSequence)"");
        }
        ag.a((SpannableString)localObject1, bool2);
        if (paramBoolean)
        {
          localObject1 = (FinderCollapsibleTextView)parami.RD(b.f.text_content);
          localObject2 = parami.RD(b.f.right_btn_layout);
          ((FinderCollapsibleTextView)localObject1).a((CharSequence)paramT.feedObject.getDescriptionFullSpan(), (View)localObject2, (kotlin.g.a.b)new aq((FinderCollapsibleTextView)localObject1));
        }
        Log.d("Finder.FeedConvert", "feedId:" + paramT.feedObject.getId() + ", localId:" + paramT.feedObject.getLocalId() + ", isPostOk:" + bool1);
        a(parami, paramT.feedObject);
        return;
        p.j(localObject1, "container");
        ((View)localObject1).setVisibility(0);
        break;
        label920:
        parami.nx(b.f.profile_timeline_retry, 0);
        break label525;
        label932:
        if (paramT.feedObject.isEventClosed())
        {
          p.j(localObject3, "failedTv");
          localObject1 = parami.getContext();
          p.j(localObject1, "holder.context");
          ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(b.j.finder_post_tip_failed_event_closed));
          break label595;
        }
        p.j(localObject3, "failedTv");
        localObject1 = parami.getContext();
        p.j(localObject1, "holder.context");
        ((TextView)localObject3).setText((CharSequence)((Context)localObject1).getResources().getString(b.j.finder_post_tip_failed));
        break label595;
        label1030:
        bool1 = false;
        break label619;
        label1036:
        if ((paramT.feedObject.isPostFinish()) || (paramT.feedObject.getPostInfo().TAi >= 100))
        {
          p.j(localView2, "failedArea");
          localView2.setVisibility(8);
          p.j(localView1, "progressArea");
          localView1.setVisibility(8);
          ((View)localObject1).setVisibility(8);
          a(0, parami);
          a(true, parami);
          e(paramT, parami);
          bool1 = true;
          break label619;
        }
        localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
        a(this, ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().Na(paramT.feedObject.getLocalId()).Mx).booleanValue(), parami, paramT);
        p.j(localView2, "failedArea");
        localView2.setVisibility(8);
        p.j(localView1, "progressArea");
        localView1.setVisibility(0);
        localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)localObject2).getProgress(), paramT.feedObject.getPostInfo().TAi });
        ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new at((FinderPostProgressView)localObject2));
        localObject3 = ((ValueAnimator)localObject1).setDuration(400L);
        if (localObject3 != null) {
          ((ValueAnimator)localObject3).start();
        }
        parami.setTag(localObject1);
        Log.i("Finder.FeedConvert", "progress animate: " + ((FinderPostProgressView)localObject2).getProgress() + ", " + paramT.feedObject.getPostInfo().TAi);
        bool1 = false;
        break label619;
        label1306:
        bool2 = false;
      }
    }
  }
  
  private static void b(com.tencent.mm.view.recyclerview.i parami, final T paramT)
  {
    Object localObject = paramT.contact;
    int i;
    View localView;
    label56:
    boolean bool;
    if (localObject != null)
    {
      i = ((com.tencent.mm.plugin.finder.api.i)localObject).field_liveStatus;
      localView = parami.RD(b.f.finder_live_onlive_widget);
      StringBuilder localStringBuilder = new StringBuilder("refreshLiveIcon username:");
      localObject = paramT.contact;
      if (localObject == null) {
        break label202;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.i)localObject).getNickname();
      localObject = localStringBuilder.append((String)localObject).append(",liveStatus:").append(i).append(",onliveView is null:");
      if (localView != null) {
        break label208;
      }
      bool = true;
      label88:
      Log.i("Finder.FeedConvert", bool);
      if (i != 1) {
        break label213;
      }
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView.post((Runnable)new aj(localView));
      if (localView != null) {
        localView.setOnClickListener((View.OnClickListener)new ak(parami, paramT));
      }
      parami = (TextView)parami.RD(b.f.follow_tv);
      p.j(parami, "followTv");
      if (Util.isNullOrNil(parami.getText().toString())) {
        parami.setVisibility(8);
      }
    }
    label202:
    label208:
    label213:
    while (localView == null)
    {
      return;
      i = 2;
      break;
      localObject = null;
      break label56;
      bool = false;
      break label88;
    }
    localView.setVisibility(8);
  }
  
  private final void b(final com.tencent.mm.view.recyclerview.i parami, final T paramT, final int paramInt)
  {
    View localView = parami.RD(b.f.feed_like_comment_edu_layout);
    if (paramT.showCommentEdu)
    {
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(locala, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)locala).dYT())
      {
        p.j(localView, "layout");
        localView.setVisibility(0);
        localView.setOnClickListener((View.OnClickListener)new ad(this, parami, paramT, paramInt));
        return;
      }
    }
    p.j(localView, "layout");
    localView.setVisibility(8);
  }
  
  private final void c(T paramT, com.tencent.mm.view.recyclerview.i parami)
  {
    if (this.xhR)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      if (!Util.isNullOrNil((List)com.tencent.mm.plugin.finder.upload.action.l.ecG().u(paramT.feedObject.getFeedObject())))
      {
        parami.nx(b.f.recommend_reason_layout, 8);
        return;
      }
    }
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = parami.getContext();
    p.j(localObject, "holder.context");
    localObject = aj.a.fZ((Context)localObject);
    label82:
    int j;
    if (localObject != null)
    {
      i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).xkX;
      if ((i != 3) && (i != 16) && (i != 27) && (i != 9) && (i != 18) && (i != 31) && (i != 29) && ((i != 20) || ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE)))) {
        break label412;
      }
      parami.nx(b.f.recommend_reason_layout, 8);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label329;
      }
      i = 1;
      label183:
      if (i != 0) {
        break label332;
      }
      j = paramT.feedObject.getFeedObject().recommendType;
      parami.nx(b.f.recommend_icon, 8);
      parami.nx(b.f.recommend_reason_layout, 0);
      localObject = (CharSequence)paramT.feedObject.getFeedObject().recommendReason;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label334;
      }
    }
    label329:
    label332:
    label334:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label339;
      }
      localObject = (TextView)parami.RD(b.f.recommend_reason_tv);
      p.j(localObject, "reasonTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.h(parami.getContext(), (CharSequence)paramT.feedObject.getFeedObject().recommendReason, (int)((TextView)localObject).getTextSize()));
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o());
      return;
      i = 0;
      break label82;
      i = 0;
      break label183;
      break;
    }
    label339:
    Log.w("Finder.FeedConvert", "hide recommend layout type=" + j + " recommendReason=" + paramT.feedObject.getFeedObject().recommendReason + " feedId=" + paramT.feedObject.getFeedObject().id);
    parami.nx(b.f.recommend_reason_layout, 8);
    return;
    label412:
    parami.nx(b.f.recommend_reason_layout, 8);
  }
  
  private final void c(final com.tencent.mm.view.recyclerview.i parami, final T paramT)
  {
    final com.tencent.mm.plugin.finder.storage.l locall = paramT.attachFavInfo;
    Object localObject1;
    label99:
    final boolean bool;
    if (locall != null)
    {
      localObject1 = parami.getContext();
      p.j(localObject1, "holder.context");
      if (fq((Context)localObject1))
      {
        final ViewGroup localViewGroup = (ViewGroup)parami.RD(b.f.feed_similar_wording_layout);
        if (localViewGroup != null)
        {
          localObject1 = localViewGroup.getLayoutParams();
          Object localObject2 = localObject1;
          if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
            localObject2 = null;
          }
          localObject1 = (LinearLayout.LayoutParams)localObject2;
          if (!locall.Alc) {
            break label222;
          }
          if (localObject1 != null) {
            ((LinearLayout.LayoutParams)localObject1).gravity = 3;
          }
          localObject2 = (TextView)parami.RD(b.f.feed_similar_wording_tv);
          final List localList = locall.dYB();
          if (locall.Ale != null) {
            break label236;
          }
          bool = true;
          label128:
          if (!Util.isNullOrNil(locall.getWording())) {
            break label241;
          }
          localObject1 = parami.getContext().getString(b.j.finder_fav_similar_wording);
          label151:
          p.j(localObject1, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
          if (localViewGroup != null) {
            localViewGroup.setVisibility(0);
          }
          if (localViewGroup != null) {
            localViewGroup.setOnClickListener((View.OnClickListener)new ba(this, locall, parami, localList, paramT, bool, localViewGroup));
          }
        }
      }
    }
    label222:
    label236:
    label241:
    do
    {
      return;
      localObject1 = null;
      break;
      if (localObject1 == null) {
        break label99;
      }
      ((LinearLayout.LayoutParams)localObject1).gravity = 5;
      break label99;
      bool = false;
      break label128;
      localObject1 = locall.getWording();
      break label151;
      parami = parami.RD(b.f.feed_similar_wording_layout);
      if (parami != null) {
        parami.setOnClickListener(null);
      }
    } while (parami == null);
    parami.setVisibility(8);
  }
  
  private final void c(final com.tencent.mm.view.recyclerview.i parami, final FinderItem paramFinderItem, final String paramString)
  {
    Object localObject3 = null;
    StringBuilder localStringBuilder;
    if (paramFinderItem != null)
    {
      localObject1 = paramFinderItem.getFeedObject();
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).hotTopics;
        if (localObject1 != null)
        {
          localObject1 = ((bgc)localObject1).topics;
          localStringBuilder = new StringBuilder("showNewsIndicator objectType: ");
          if (paramFinderItem == null) {
            break label296;
          }
          localObject2 = paramFinderItem.getFeedObject();
          if (localObject2 == null) {
            break label296;
          }
          localObject2 = Integer.valueOf(((FinderObject)localObject2).objectType);
          label74:
          localStringBuilder = localStringBuilder.append(localObject2).append(" size:");
          if (localObject1 == null) {
            break label302;
          }
        }
      }
    }
    label296:
    label302:
    for (Object localObject2 = Integer.valueOf(((LinkedList)localObject1).size());; localObject2 = null)
    {
      Log.i("Finder.FeedConvert", localObject2);
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        do
        {
          localObject2 = localObject3;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (bgb)((Iterator)localObject1).next();
        } while ((localObject2 == null) || (((bgb)localObject2).SQX != 5));
      }
      if (localObject2 == null) {
        break label497;
      }
      Log.i("Finder.FeedConvert", "showNewsIndicator topic " + ((bgb)localObject2).xee + ' ' + ((bgb)localObject2).uLJ + ' ' + ((bgb)localObject2).SQY);
      if (!(parami.getContext() instanceof FinderShareFeedRelUI)) {
        break label308;
      }
      Log.i("Finder.FeedConvert", "showNewsIndicator topic ui is FinderShareFeedRelUI block");
      paramFinderItem = parami.RD(b.f.finder_feed_item_of_news);
      if (paramFinderItem != null) {
        paramFinderItem.setVisibility(8);
      }
      parami = parami.RD(b.f.finder_feed_item_of_news_title);
      if (parami != null) {
        parami.setVisibility(8);
      }
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label74;
    }
    label308:
    Object localObject1 = (TextView)parami.RD(b.f.feed_item_news_title);
    if (localObject1 != null)
    {
      if (((bgb)localObject2).SQY <= 0) {
        break label547;
      }
      ((TextView)localObject1).setTextColor(((TextView)localObject1).getResources().getColor(b.c.Link_80));
    }
    for (;;)
    {
      localObject1 = parami.RD(b.f.finder_feed_item_of_news);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener((View.OnClickListener)new bi((bgb)localObject2, this, parami, paramFinderItem, paramString));
      }
      paramFinderItem = (TextView)parami.RD(b.f.feed_item_news_title);
      if (paramFinderItem != null)
      {
        paramString = new StringBuilder();
        localObject1 = paramFinderItem.getContext();
        p.j(localObject1, "context");
        paramString = ((Context)localObject1).getResources().getString(b.j.finder_news_feed_title_prefix) + ((bgb)localObject2).uLJ;
        paramFinderItem.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString));
      }
      paramFinderItem = (TextView)parami.RD(b.f.feed_item_news_tag_text);
      if (paramFinderItem != null) {
        paramFinderItem.setVisibility(8);
      }
      if (localObject2 != null) {
        break;
      }
      label497:
      Log.i("Finder.FeedConvert", "showNewsIndicator topic null let");
      paramFinderItem = parami.RD(b.f.finder_feed_item_of_news);
      if (paramFinderItem != null) {
        paramFinderItem.setVisibility(8);
      }
      parami = parami.RD(b.f.finder_feed_item_of_news_title);
      if (parami != null) {
        parami.setVisibility(8);
      }
      parami = kotlin.x.aazN;
      return;
      label547:
      ((TextView)localObject1).setTextColor(((TextView)localObject1).getResources().getColor(b.c.FG_1));
    }
  }
  
  private final void d(final T paramT, final com.tencent.mm.view.recyclerview.i parami)
  {
    Log.i("Finder.FeedConvert", "refreshExposeLayout feedId:" + paramT.feedObject.field_id + ", localId:" + paramT.feedObject.getLocalId() + ", " + paramT.feedObject.getFeedObject().commentClose + " pos:" + parami.md());
    paramT.feedObject.getFeedObject();
    if (paramT.feedObject.getCommentCount() <= 0) {
      paramT.feedObject.getCommentList().size();
    }
    if (paramT.feedObject.getLikeCount() <= 0) {
      paramT.feedObject.getLikeList().size();
    }
    FinderFeedExposeLayout localFinderFeedExposeLayout = (FinderFeedExposeLayout)parami.RD(b.f.comment_layout);
    p.j(localFinderFeedExposeLayout, "exposeLayout");
    localFinderFeedExposeLayout.setVisibility(0);
    localFinderFeedExposeLayout.setOnCommentLongClickListener((kotlin.g.a.m)new ae(this, parami, paramT));
    localFinderFeedExposeLayout.setOnCommentClickListener((kotlin.g.a.m)new af(this, parami, paramT));
    Object localObject = parami.amk;
    p.j(localObject, "holder.itemView");
    localFinderFeedExposeLayout.a((View)localObject, paramT.feedObject, paramT.feedObject.getCommentList(), paramT.feedObject.getCommentCount(), paramT.feedObject.getLikeCount(), paramT.feedObject.getFriendLikeCount(), (kotlin.g.a.m)new ag(this, paramT));
    if (Util.isNullOrNil((List)paramT.feedObject.getCommentList()))
    {
      localFinderFeedExposeLayout.setVisibility(8);
      localObject = (ImageView)parami.RD(b.f.self_comment_count_iv);
      if (!paramT.feedObject.isCommentClose()) {
        break label378;
      }
      com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.PE(paramT.feedObject.field_username)) {
        break label378;
      }
      p.j(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(au.o(((ImageView)localObject).getContext(), b.i.icon_outlined_close_comment, com.tencent.mm.ci.a.w(((ImageView)localObject).getContext(), b.c.black_color)));
    }
    for (;;)
    {
      paramT = parami.RD(b.f.self_comment_container);
      paramT.setOnClickListener((View.OnClickListener)new ah(localFinderFeedExposeLayout, paramT));
      return;
      localFinderFeedExposeLayout.setVisibility(0);
      break;
      label378:
      p.j(localObject, "commentIcon");
      ((ImageView)localObject).setImageDrawable(au.o(((ImageView)localObject).getContext(), b.i.icons_outlined_comment, com.tencent.mm.ci.a.w(((ImageView)localObject).getContext(), b.c.black_color)));
    }
  }
  
  private static void e(T paramT, com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(paramT, "item");
    p.k(parami, "holder");
  }
  
  private final void es(View paramView)
  {
    paramView.setVisibility(8);
    Runnable localRunnable = this.xhP;
    if (localRunnable != null)
    {
      paramView.removeCallbacks(localRunnable);
      this.xhP = null;
    }
  }
  
  private final boolean fq(Context paramContext)
  {
    boolean bool = false;
    aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    if (paramContext != null) {}
    for (int i = paramContext.xkX;; i = 0)
    {
      if ((this.fEH == 3) || (this.fEH == 1) || (this.fEH == 4) || (i == 16)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void a(int paramInt, com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(parami, "holder");
    parami.nx(b.f.footer_real_op_layout, paramInt);
  }
  
  public void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    this.xhO = ((View.OnClickListener)new o(parami));
    Object localObject1 = parami.RD(b.f.footer_op_layout);
    paramRecyclerView = new aa.f();
    paramRecyclerView.aaBC = new an((View)localObject1);
    p.j(localObject1, "footerTouchDelegateView");
    ((View)localObject1).setTouchDelegate((TouchDelegate)paramRecyclerView.aaBC);
    localObject1 = (ImageView)parami.RD(b.f.avatar_iv);
    Object localObject2 = this.xhO;
    if (localObject2 == null) {
      p.bGy("onAvatarClickListener");
    }
    ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    ((ImageView)localObject1).post((Runnable)new t((ImageView)localObject1));
    localObject1 = (TextView)parami.RD(b.f.nickname);
    localObject2 = this.xhO;
    if (localObject2 == null) {
      p.bGy("onAvatarClickListener");
    }
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
    p.j(localObject1, "nickTv");
    ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject2 = parami.getContext();
    p.j(localObject2, "holder.context");
    ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.black_text_color));
    localObject1 = (WeImageView)parami.RD(b.f.more_btn);
    localObject2 = parami.getContext();
    p.j(localObject2, "holder.context");
    ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(b.c.black_color));
    localObject1 = (HardTouchableLayout)parami.RD(b.f.media_container);
    if (localObject1 != null)
    {
      ((HardTouchableLayout)localObject1).setEnableScale(false);
      ((HardTouchableLayout)localObject1).setOnInterceptTouchEventCallback((HardTouchableLayout.c)new u());
      ((HardTouchableLayout)localObject1).setOnDoubleClickListener((HardTouchableLayout.b)new m((HardTouchableLayout)localObject1, this, parami));
      ((HardTouchableLayout)localObject1).setOnSingleClickListener((HardTouchableLayout.g)new n((HardTouchableLayout)localObject1, this, parami));
      localObject2 = ((HardTouchableLayout)localObject1).getContext();
      p.j(localObject2, "mediaContainer.context");
      paramInt = (int)((Context)localObject2).getResources().getDimension(b.d.Edge_7_5_A);
      if (this.xhM != 0) {
        break label932;
      }
      localObject1 = ((HardTouchableLayout)localObject1).getLayoutParams();
      if (localObject1 == null) {
        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      }
      ((FrameLayout.LayoutParams)localObject1).topMargin = paramInt;
      localObject1 = parami.RD(b.f.feedHeaderBar);
      p.j(localObject1, "it");
      ((View)localObject1).setBackground(null);
      ((View)localObject1).setTag(Boolean.FALSE);
    }
    for (;;)
    {
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = null;
      localObject2 = new aa.f();
      ((aa.f)localObject2).aaBC = parami.RD(b.f.awesome_icon_container);
      ((View)((aa.f)localObject2).aaBC).setOnTouchListener((View.OnTouchListener)new v((aa.f)localObject1));
      ((View)((aa.f)localObject2).aaBC).setOnClickListener((View.OnClickListener)new w(this, parami));
      ((View)((aa.f)localObject2).aaBC).setOnLongClickListener((View.OnLongClickListener)new x(this, parami));
      ((View)((aa.f)localObject2).aaBC).setHapticFeedbackEnabled(false);
      ((View)((aa.f)localObject2).aaBC).post((Runnable)new y((aa.f)localObject2, parami, paramRecyclerView));
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = parami.RD(b.f.comment_icon_container);
      ((View)((aa.f)localObject1).aaBC).post((Runnable)new z((aa.f)localObject1, parami, paramRecyclerView));
      localObject1 = (FinderCollapsibleTextView)parami.RD(b.f.text_content);
      ((FinderCollapsibleTextView)localObject1).getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h(((FinderCollapsibleTextView)localObject1).getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o(parami.getContext())));
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = parami.RD(b.f.fav_op_layout);
      localObject2 = (View)((aa.f)localObject1).aaBC;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new aa(this, parami));
      }
      localObject2 = (View)((aa.f)localObject1).aaBC;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new p(parami, (aa.f)localObject1, paramRecyclerView));
      }
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = parami.RD(b.f.share_icon_container);
      localObject2 = (View)((aa.f)localObject1).aaBC;
      if (localObject2 != null) {
        ((View)localObject2).setOnClickListener((View.OnClickListener)new q(this, parami));
      }
      localObject2 = (View)((aa.f)localObject1).aaBC;
      if (localObject2 != null) {
        ((View)localObject2).post((Runnable)new r(parami, (aa.f)localObject1, paramRecyclerView));
      }
      parami.RD(b.f.more_btn).setOnLongClickListener((View.OnLongClickListener)new s(parami));
      paramRecyclerView = parami.RD(b.f.comment_layout);
      p.j(paramRecyclerView, "holder.getView<View>(R.id.comment_layout)");
      paramRecyclerView.setClickable(false);
      paramRecyclerView = new b(this, parami);
      parami.amk.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramRecyclerView);
      paramRecyclerView.alive();
      this.xhN.add(paramRecyclerView);
      return;
      label932:
      if (this.xhM == 1)
      {
        localObject2 = ((HardTouchableLayout)localObject1).getLayoutParams();
        if (localObject2 == null) {
          throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        ((FrameLayout.LayoutParams)localObject2).topMargin = 0;
        localObject2 = parami.RD(b.f.feedHeaderBar);
        p.j(localObject2, "it");
        ((View)localObject2).setBackground(((HardTouchableLayout)localObject1).getResources().getDrawable(b.e.feed_header_gradient_background));
        ((View)localObject2).setTag(Boolean.TRUE);
      }
    }
  }
  
  public void a(com.tencent.mm.view.recyclerview.i parami, View paramView)
  {
    p.k(parami, "holder");
    p.k(paramView, "view");
    Object localObject1 = (BaseFinderFeed)parami.ihX();
    if (!((BaseFinderFeed)localObject1).feedObject.isPostFinish()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((this.xhU.dsp()) || (((BaseFinderFeed)localObject1).isPreview));
      paramView = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      paramView = com.tencent.mm.plugin.finder.upload.action.l.ecG().r(((BaseFinderFeed)localObject1).feedObject.getFeedObject());
      bool1 = ((Boolean)paramView.Mx).booleanValue();
      bool2 = ((Boolean)paramView.My).booleanValue();
    } while ((bool1) && (bool2));
    if (bool1)
    {
      WeImageView localWeImageView = (WeImageView)parami.RD(b.f.like_icon);
      paramView = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
      paramView = com.tencent.mm.plugin.finder.storage.logic.g.Qt(((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectType);
      int i;
      if (paramView == null)
      {
        paramView = "";
        Object localObject2 = (CharSequence)paramView;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label300;
        }
        i = 1;
        label175:
        if (i != 0) {
          break label305;
        }
        p.j(localWeImageView, "likeIconBanner");
        parami = localWeImageView.getDrawable();
        if (parami != null) {
          parami.clearColorFilter();
        }
        localWeImageView.setClearColorFilter(true);
        parami = com.tencent.mm.plugin.finder.loader.t.ztT;
        parami = com.tencent.mm.plugin.finder.loader.t.dJe();
        paramView = new com.tencent.mm.plugin.finder.loader.x(paramView, u.Aly);
        localObject1 = (ImageView)localWeImageView;
        localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
        parami.a(paramView, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      }
      for (;;)
      {
        parami = com.tencent.mm.plugin.finder.view.animation.c.BdF;
        p.j(localWeImageView, "likeIconBanner");
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 0.0F, null, false, 30);
        return;
        if (ar.isDarkMode())
        {
          paramView = paramView.SQK;
          break;
        }
        paramView = paramView.SQL;
        break;
        label300:
        i = 0;
        break label175;
        label305:
        paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.j(((BaseFinderFeed)localObject1).contact))
        {
          paramView = parami.getContext();
          i = b.i.finder_filled_like_lock;
          parami = parami.getContext();
          p.j(parami, "holder.context");
          localWeImageView.setImageDrawable(au.o(paramView, i, parami.getResources().getColor(b.c.Red_90)));
        }
        else
        {
          paramView = parami.getContext();
          i = b.i.icon_filled_awesome;
          parami = parami.getContext();
          p.j(parami, "holder.context");
          localWeImageView.setImageDrawable(au.o(paramView, i, parami.getResources().getColor(b.c.Red_90)));
        }
      }
    }
    a(parami, 2, false);
  }
  
  public void a(com.tencent.mm.view.recyclerview.i parami, View paramView, FinderObject paramFinderObject)
  {
    p.k(parami, "holder");
    p.k(paramView, "view");
    p.k(paramFinderObject, "finderObj");
  }
  
  public abstract void a(com.tencent.mm.view.recyclerview.i parami, T paramT, int paramInt);
  
  public void a(final com.tencent.mm.view.recyclerview.i parami, final T paramT, int paramInt1, int paramInt2, boolean paramBoolean, final List<Object> paramList)
  {
    p.k(parami, "holder");
    p.k(paramT, "item");
    paramT.feedObject.setReplaceLongVideoToNormal(false);
    Object localObject1 = (Collection)paramList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      paramInt2 = 1;
      if (paramInt2 == 0)
      {
        paramList = ((Iterable)paramList).iterator();
        paramInt2 = 1;
      }
    }
    else
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label439;
        }
        localObject1 = paramList.next();
        if ((localObject1 instanceof kotlin.o))
        {
          localObject1 = (kotlin.o)localObject1;
          boolean bool;
          switch (((Number)((kotlin.o)localObject1).Mx).intValue())
          {
          default: 
            paramInt2 = 0;
            continue;
            paramInt2 = 0;
            break;
          case 1: 
            d(paramT, parami);
            break;
          case 2: 
            b(paramT, parami, false);
            break;
          case 3: 
            localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
            localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ecG().r(paramT.feedObject.getFeedObject());
            bool = ((Boolean)((kotlin.o)localObject1).Mx).booleanValue();
            ((Boolean)((kotlin.o)localObject1).My).booleanValue();
            if (!bool) {
              a(this, false, parami, paramT);
            }
            a(paramT, parami);
            c(paramT, parami);
            a(paramT, parami, true);
            break;
          case 4: 
            localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
            bool = com.tencent.mm.plugin.finder.upload.action.c.ecy().p(paramT.feedObject.getFeedObject());
            localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
            a(bool, com.tencent.mm.plugin.finder.upload.action.c.ecy().q(paramT.feedObject.getFeedObject()), parami);
            break;
          case 5: 
            c(parami, paramT);
            break;
          case 6: 
            localObject1 = ((kotlin.o)localObject1).My;
            if (localObject1 == null) {
              throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.autogen.events.FeedUpdateEvent");
            }
            localObject1 = (hu)localObject1;
            if (((hu)localObject1).fEL.fEN == 1) {}
            for (bool = true;; bool = false)
            {
              paramT.showCommentEdu = bool;
              if (paramT.feedObject.isCommentClose()) {
                break;
              }
              b(parami, paramT, ((hu)localObject1).fEL.fEM);
              break;
            }
          case 7: 
            b(parami, paramT);
            break;
          case 8: 
            a(parami, paramT.feedObject, Boolean.TRUE);
            break;
          }
        }
        paramInt2 = 0;
      }
      label439:
      if (paramInt2 != 0) {
        return;
      }
    }
    paramList = parami.RD(b.f.like_icon);
    p.j(paramList, "holder.getView<View>(R.id.like_icon)");
    paramList.setVisibility(8);
    parami.RD(b.f.more_btn).setOnClickListener((View.OnClickListener)new k(this, parami));
    paramT.feedObject.getTopicClickExtra().aFX = new WeakReference(parami.getContext());
    label625:
    Object localObject2;
    label689:
    label725:
    label752:
    Object localObject3;
    if (!this.xhU.dsp())
    {
      paramList = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.B(paramT.feedObject.getFeedObject())) {}
    }
    else
    {
      parami.nx(b.f.update_time, 0);
      parami.e(b.f.update_time, (CharSequence)com.tencent.mm.plugin.finder.utils.m.o(parami.getContext(), paramT.feedObject.getCreateTime() * 1000L));
      b(paramT);
      parami.nx(b.f.auth_desc, 8);
      paramList = paramT.contact;
      if (paramList != null)
      {
        localObject1 = paramList.field_authInfo;
        if (localObject1 == null) {
          break label2287;
        }
        paramInt2 = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = parami.RD(b.f.auth_icon);
        p.j(localObject1, "holder.getView<ImageView>(R.id.auth_icon)");
        com.tencent.mm.plugin.finder.utils.aj.a((ImageView)localObject1, paramList.field_authInfo);
      }
      switch (paramInt2)
      {
      default: 
        paramList = kotlin.x.aazN;
        if (!paramBoolean) {
          a(parami, paramT, paramInt1);
        }
        localObject1 = paramT.feedObject;
        paramList = paramT.contact;
        if (paramList != null)
        {
          paramList = paramList.getUsername();
          c(parami, (FinderItem)localObject1, paramList);
          paramList = paramT.contact;
          if (paramList == null) {
            break label2403;
          }
          paramList = paramList.getUsername();
          if (paramList != null)
          {
            localObject1 = paramT.contact;
            if (localObject1 == null) {
              break label2409;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.api.i)localObject1).Mm();
            label775:
            localObject1 = Util.nullAsNil((String)localObject1);
            localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
            localObject2 = com.tencent.mm.plugin.finder.api.d.a.aAK(paramList);
            paramList = (List<Object>)localObject1;
            if (localObject2 != null)
            {
              paramList = (List<Object>)localObject1;
              if (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.api.i)localObject2).Mm())) {
                paramList = ((com.tencent.mm.plugin.finder.api.i)localObject2).Mm();
              }
              localObject1 = kotlin.x.aazN;
            }
            localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
            localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
            paramList = new com.tencent.mm.plugin.finder.loader.e(paramList);
            localObject2 = parami.RD(b.f.avatar_iv);
            p.j(localObject2, "holder.getView(R.id.avatar_iv)");
            localObject2 = (ImageView)localObject2;
            localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
            ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
            paramList = kotlin.x.aazN;
          }
          localObject2 = paramT.feedObject;
          paramList = paramT.contact;
          if (paramList == null) {
            break label2415;
          }
          paramList = paramList.getNickname();
          label924:
          if (localObject2 == null) {
            break label2421;
          }
          localObject1 = ((FinderItem)localObject2).getFeedObject();
          if (localObject1 == null) {
            break label2421;
          }
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null) {
            break label2421;
          }
          localObject1 = ((FinderObjectDesc)localObject1).event;
          label960:
          if (localObject1 != null)
          {
            if (!Util.isNullOrNil(((bfv)localObject1).eventName)) {
              break label2427;
            }
            paramList = parami.RD(b.f.finder_feed_item_of_activity);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
            if (localObject1 != null) {}
          }
          else
          {
            paramList = parami.RD(b.f.finder_feed_item_of_activity);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
            paramList = kotlin.x.aazN;
          }
          if (paramBoolean) {
            break label4070;
          }
          paramList = parami.RD(b.f.content_text_container);
          if (((CharSequence)paramT.feedObject.getDescription()).length() != 0) {
            break label2615;
          }
          paramInt1 = 1;
          label1062:
          if (paramInt1 == 0) {
            break label2625;
          }
          parami.nx(b.f.text_content, 8);
          if (paramList == null) {
            break label2620;
          }
          localObject1 = paramList.getContext();
          p.j(localObject1, "context");
          paramInt1 = (int)((Context)localObject1).getResources().getDimension(b.d.Edge_0_5_A);
          paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
          paramList = kotlin.x.aazN;
          paramInt1 = 0;
          label1137:
          paramList = parami.RD(b.f.folded_layout_view);
          if (paramList != null) {
            paramList.setVisibility(8);
          }
          paramList = parami.RD(b.f.folded_layout_view);
          if (paramList != null) {
            paramList.setAlpha(1.0F);
          }
          localObject1 = paramT.feedObject.getFoldedLayout();
          if (localObject1 != null)
          {
            if ((((asz)localObject1).xBI != 1) || (this.xhR)) {
              break label2862;
            }
            paramList = parami.RD(b.f.folded_layout_view);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
          }
          label1229:
          c(parami, paramT);
          paramList = parami.RD(b.f.finder_private_feed_like_tips_layout);
          paramInt2 = paramInt1;
          if (paramList != null) {
            paramList.setVisibility(8);
          }
        }
        break;
      }
    }
    label1318:
    label1352:
    label2137:
    label2403:
    label4067:
    label4070:
    for (paramInt2 = paramInt1;; paramInt2 = 0)
    {
      d(paramT, parami);
      label1276:
      Object localObject4;
      label1916:
      float f;
      label2287:
      label2415:
      label2421:
      label2427:
      label2559:
      Object localObject5;
      if (paramInt2 == 0)
      {
        paramBoolean = true;
        b(paramT, parami, paramBoolean);
        if (Util.isNullOrNil(paramT.headerWording)) {
          break label3379;
        }
        parami.nx(b.f.header_tips_layout, 0);
        parami.e(b.f.header_tip_tv, (CharSequence)paramT.headerWording);
        if (Util.isNullOrNil(paramT.footerWording)) {
          break label3392;
        }
        parami.nx(b.f.footer_tips_layout, 0);
        parami.e(b.f.footer_tip_tv, (CharSequence)paramT.footerWording);
        a(parami, paramT);
        p.k(parami, "holder");
        ((TextView)parami.RD(b.f.nickname)).post((Runnable)new bb(parami));
        c(paramT, parami);
        b(parami, paramT, 1);
        a(paramT, parami, false);
        paramList = com.tencent.mm.plugin.finder.upload.action.l.ACj;
        paramList = com.tencent.mm.plugin.finder.upload.action.l.ecG().Na(paramT.feedObject.getLocalId());
        a(((Boolean)paramList.Mx).booleanValue(), parami, ((Boolean)paramList.My).booleanValue());
        paramList = com.tencent.mm.plugin.finder.upload.action.l.ACj;
        a(((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(paramT.feedObject.getFeedObject()).Mx).booleanValue(), parami, paramT, true);
        paramList = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if ((com.tencent.mm.plugin.finder.utils.aj.j(paramT)) && (paramT.showShareSns))
        {
          paramT.showShareSns = false;
          paramList = new com.tencent.mm.ui.widget.a.d.a(parami.getContext());
          paramList.ayg(b.j.finder_feed_shahre_to_sns_dialog_msg);
          paramList.HG(false);
          paramList.HH(true);
          paramList.ayk(b.j.finder_feed_shahre_to_sns_dialog_negative_btn);
          paramList.ayj(b.j.finder_feed_shahre_to_sns_dialog_positive_btn).c((DialogInterface.OnClickListener)new c(this, parami));
          paramList.f((DialogInterface.OnCancelListener)new d(parami));
          paramList.icu().show();
        }
        paramList = parami.RD(b.f.share_to_sns);
        if (paramList != null) {
          paramList.setVisibility(8);
        }
        localObject2 = paramT.feedObject.getLocation();
        localObject1 = parami.RD(b.f.position_layout);
        paramList = (TextView)parami.RD(b.f.poi_name);
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.hu(((bdm)localObject2).city, ((bdm)localObject2).poiName);
        if (!Util.isNullOrNil((String)localObject2)) {
          break label3405;
        }
        p.j(localObject1, "positionLayout");
        ((View)localObject1).setVisibility(8);
        paramList = kotlin.x.aazN;
        localObject1 = parami.RD(b.f.link_layout);
        p.j(localObject1, "linkLayout");
        ((View)localObject1).setVisibility(8);
        localObject3 = paramT.feedObject.getExtReading();
        if ((!Util.isNullOrNil(((asl)localObject3).link)) && (!Util.isNullOrNil(((asl)localObject3).title)))
        {
          localObject2 = ((asl)localObject3).link;
          localObject4 = ((asl)localObject3).title;
          paramList = (TextView)parami.RD(b.f.link_title);
          parami.e(b.f.link_title, (CharSequence)localObject4);
          Log.i("Finder.FeedConvert", "link " + (String)localObject2 + ", title " + ((asl)localObject3).title);
          ((View)localObject1).post((Runnable)new h(paramList, (String)localObject4, this, parami, (View)localObject1, paramT));
          ((View)localObject1).setVisibility(0);
          paramT.feedObject.setShowExtendLink(true);
          localObject4 = (WeImageView)parami.RD(b.f.link_icon);
        }
        switch (((asl)localObject3).style)
        {
        default: 
          localObject3 = com.tencent.mm.kernel.h.ae(ae.class);
          p.j(localObject3, "MMKernel.service(IFinder…enModeConfig::class.java)");
          if (((ae)localObject3).dYT())
          {
            p.j(paramList, "linkTv");
            localObject1 = paramList.getContext();
            p.j(localObject1, "linkTv.context");
            paramList.setTextColor(((Context)localObject1).getResources().getColor(b.c.FG_0));
            paramList = kotlin.x.aazN;
            localObject1 = parami.RD(b.f.recommend_reason_tv);
            paramList = parami.RD(b.f.comment_layout);
            if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0) && (paramList != null) && (paramList.getVisibility() == 0))
            {
              localObject1 = paramList.getContext();
              p.j(localObject1, "context");
              paramInt1 = (int)((Context)localObject1).getResources().getDimension(b.d.Edge_0_5_A);
              paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
              paramList = kotlin.x.aazN;
            }
            a(parami, paramT.feedObject, Boolean.FALSE);
            a(paramT, parami);
            paramList = com.tencent.mm.plugin.finder.utils.aj.AGc;
            if (com.tencent.mm.plugin.finder.utils.aj.j(paramT)) {
              break label3595;
            }
            paramList = parami.RD(b.f.private_feed_layout);
            if (paramList != null) {
              paramList.setVisibility(8);
            }
            localObject3 = (FinderMediaBanner)parami.RD(b.f.media_banner);
            f = 1.0F * ((FinderMediaBanner)localObject3).getPagerView().getLayoutParams().height / ((FinderMediaBanner)localObject3).getPagerView().getLayoutParams().width;
            paramList = (TextView)parami.RD(b.f.nickname);
            localObject1 = (WeImageView)parami.RD(b.f.more_btn);
            localObject2 = (TextView)parami.RD(b.f.auth_desc);
            localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            if (!com.tencent.mm.plugin.finder.utils.aj.e(f, this.xhM)) {
              break label3835;
            }
            localObject3 = (HardTouchableLayout)parami.RD(b.f.media_container);
            p.j(localObject3, "mediaContainer");
            localObject4 = ((HardTouchableLayout)localObject3).getLayoutParams();
            if (localObject4 != null) {
              break label3652;
            }
            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            parami.nx(b.f.update_time, 8);
            break;
            paramInt2 = 0;
            break label625;
            parami.nx(b.f.auth_icon, 0);
            parami.nx(b.f.auth_desc, 0);
            localObject1 = (TextView)parami.RD(b.f.auth_desc);
            p.j(localObject1, "descTv");
            ((TextView)localObject1).setText((CharSequence)paramList.field_authInfo.authProfession);
            paramList = parami.getContext();
            p.j(paramList, "holder.context");
            ((TextView)localObject1).setTextColor(paramList.getResources().getColor(b.c.FG_1));
            paramList = kotlin.x.aazN;
            break label689;
            parami.nx(b.f.auth_icon, 0);
            break label689;
            paramList = null;
            break label725;
            paramList = null;
            break label752;
            label2409:
            localObject1 = null;
            break label775;
            paramList = null;
            break label924;
            localObject1 = null;
            break label960;
            localObject3 = parami.RD(b.f.finder_feed_item_of_activity);
            if (localObject3 != null) {
              ((View)localObject3).setVisibility(0);
            }
            localObject3 = parami.RD(b.f.feed_item_activity_container);
            if (localObject3 != null)
            {
              localObject4 = com.tencent.mm.kernel.h.ae(ae.class);
              p.j(localObject4, "MMKernel.service(IFinder…enModeConfig::class.java)");
              if (((ae)localObject4).dYT()) {
                break label2559;
              }
              ((View)localObject3).setOnClickListener((View.OnClickListener)new bg((bfv)localObject1, this, parami, (FinderItem)localObject2, paramList, (bfv)localObject1));
            }
            for (;;)
            {
              localObject3 = (FrameLayout)parami.RD(b.f.finder_feed_item_of_activity);
              if (localObject3 == null) {
                break;
              }
              ((FrameLayout)localObject3).post((Runnable)new bh(this, parami, (FinderItem)localObject2, paramList, (bfv)localObject1));
              break;
              localObject4 = (TextView)parami.RD(b.f.feed_item_activity_title);
              if (localObject4 != null)
              {
                localObject5 = parami.getContext();
                p.j(localObject5, "holder.context");
                ((TextView)localObject4).setTextColor(((Context)localObject5).getResources().getColor(b.c.FG_0));
              }
              ((View)localObject3).setOnClickListener(null);
            }
            paramInt1 = 0;
            break label1062;
            paramInt1 = 0;
            break label1137;
            if (paramList != null)
            {
              paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
              paramList = kotlin.x.aazN;
            }
            paramList = parami.RD(b.f.text_content);
            if (paramT.feedObject.getMediaList().size() <= 1) {
              if (paramList != null)
              {
                localObject1 = paramList.getContext();
                p.j(localObject1, "context");
                paramInt1 = (int)((Context)localObject1).getResources().getDimension(b.d.Edge_A);
                paramList.setPadding(paramList.getPaddingLeft(), paramInt1, paramList.getPaddingRight(), paramList.getPaddingBottom());
                paramList = kotlin.x.aazN;
              }
            }
            for (;;)
            {
              parami.nx(b.f.text_content, 0);
              paramList = (FinderCollapsibleTextView)parami.RD(b.f.text_content);
              localObject1 = parami.RD(b.f.right_btn_layout);
              paramList.setCollapse(paramT.isContentCollapsed);
              paramList.a((CharSequence)paramT.feedObject.getDescriptionFullSpan(), (View)localObject1, (kotlin.g.a.b)new l(paramList));
              paramList.setOnCollapse((kotlin.g.a.b)new j(paramT, parami));
              paramInt1 = 1;
              break;
              if (paramList != null)
              {
                paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
                paramList = kotlin.x.aazN;
              }
            }
            if ((((asz)localObject1).xBI != 1) && (((asz)localObject1).xBI != 2)) {
              break label1229;
            }
            paramList = parami.RD(b.f.folded_layout_view);
            if (paramList != null) {
              paramList.setVisibility(0);
            }
            paramList = parami.RD(b.f.folded_layout_view);
            if (paramList != null) {
              break label4067;
            }
            paramList = ((ViewStub)parami.RD(b.f.folded_layout_view_stub)).inflate();
          }
          break;
        }
      }
      for (;;)
      {
        localObject2 = paramList.findViewById(b.f.follow_line);
        localObject3 = paramList.findViewById(b.f.like_line);
        if (((asz)localObject1).xBI == 1)
        {
          p.j(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(0);
          p.j(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(8);
          localObject2 = (TextView)paramList.findViewById(b.f.feed_layout_title_tv);
          if (((asz)localObject1).xBI != 1) {
            break label3250;
          }
          localObject3 = parami.getContext();
          localObject4 = parami.getContext();
          paramInt2 = b.j.finder_folded_tip_like;
          localObject5 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)((Context)localObject4).getString(paramInt2, new Object[] { com.tencent.mm.plugin.finder.utils.aj.ht(((asz)localObject1).username, ""), String.valueOf(((asz)localObject1).jlf) }));
          p.j(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(parami.getContext(), (CharSequence)localObject3));
          localObject2 = paramT.feedObject.getFoldedFeedList();
          localObject3 = (FinderFoldedScrollLayout)parami.RD(b.f.feed_folded_scroll_layout);
          p.j(localObject3, "foldedScrollLayout");
          localObject4 = ((FinderFoldedScrollLayout)localObject3).getLayoutParams();
          if (((asz)localObject1).xBI != 2) {
            break label3328;
          }
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.ci.a.fromDPToPix(parami.getContext(), 208);
          ((FinderFoldedScrollLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          if (!Util.isNullOrNil((List)localObject2)) {
            break label3346;
          }
          ((FinderFoldedScrollLayout)localObject3).setVisibility(8);
        }
        for (;;)
        {
          paramList.findViewById(b.f.feed_layout_folded_header).setOnClickListener((View.OnClickListener)new ai(this, (List)localObject2, paramT, (asz)localObject1, parami));
          break;
          p.j(localObject3, "likeSplitLine");
          ((View)localObject3).setVisibility(8);
          p.j(localObject2, "followSplitLine");
          ((View)localObject2).setVisibility(0);
          break label2987;
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(parami.getContext(), (CharSequence)parami.getContext().getString(b.j.finder_folded_tip_follow, new Object[] { paramT.feedObject.getNickName(), String.valueOf(((asz)localObject1).jlf) }));
          p.j(localObject2, "titleTv");
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(parami.getContext(), (CharSequence)localObject3));
          break label3105;
          ((ViewGroup.LayoutParams)localObject4).height = com.tencent.mm.ci.a.fromDPToPix(parami.getContext(), 240);
          break label3165;
          ((FinderFoldedScrollLayout)localObject3).setVisibility(0);
          ((FinderFoldedScrollLayout)localObject3).setup((v)new com.tencent.mm.plugin.finder.view.h((asz)localObject1, paramT));
        }
        paramBoolean = false;
        break label1276;
        parami.nx(b.f.header_tips_layout, 8);
        break label1318;
        parami.nx(b.f.footer_tips_layout, 8);
        break label1352;
        p.j(paramList, "poiTv");
        paramList.setText((CharSequence)localObject2);
        paramList.post((Runnable)new f((View)localObject1, paramList, (String)localObject2, this, parami, paramT));
        p.j(localObject1, "positionLayout");
        ((View)localObject1).setVisibility(0);
        localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
        p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ae)localObject1).dYT())
        {
          localObject1 = paramList.getContext();
          p.j(localObject1, "poiTv.context");
          paramList.setTextColor(((Context)localObject1).getResources().getColor(b.c.FG_0));
          break label1702;
        }
        paramList.setOnClickListener((View.OnClickListener)new g((String)localObject2, this, parami, paramT));
        break label1702;
        ((WeImageView)localObject4).setImageResource(b.i.icons_outlined_link);
        break label1916;
        ((WeImageView)localObject4).setImageResource(b.i.icons_filled_red_envelope);
        break label1916;
        paramList.setOnClickListener((View.OnClickListener)new i((String)localObject2, this, parami, (View)localObject1, paramT));
        break label1984;
        if (paramT.feedObject.isPrivate())
        {
          paramList = parami.RD(b.f.private_feed_layout);
          if (paramList == null) {
            break label2137;
          }
          paramList.setVisibility(0);
          break label2137;
        }
        paramList = parami.RD(b.f.private_feed_layout);
        if (paramList == null) {
          break label2137;
        }
        paramList.setVisibility(8);
        break label2137;
        ((FrameLayout.LayoutParams)localObject4).topMargin = 0;
        localObject4 = parami.RD(b.f.feedHeaderBar);
        p.j(localObject4, "it");
        ((View)localObject4).setBackground(((HardTouchableLayout)localObject3).getResources().getDrawable(b.e.feed_header_gradient_background));
        ((View)localObject4).setTag(Boolean.TRUE);
        localObject3 = parami.RD(b.f.feedHeaderBar);
        p.j(localObject3, "holder.getView<View>(R.id.feedHeaderBar)");
        if (p.h(((View)localObject3).getTag(), Boolean.TRUE))
        {
          localObject3 = parami.getContext();
          p.j(localObject3, "holder.context");
          paramList.setTextColor(((Context)localObject3).getResources().getColor(b.c.white_text_color));
          paramList = parami.getContext();
          p.j(paramList, "holder.context");
          ((TextView)localObject2).setTextColor(paramList.getResources().getColor(b.c.white_text_color));
          paramList = parami.getContext();
          p.j(paramList, "holder.context");
          ((WeImageView)localObject1).setIconColor(paramList.getResources().getColor(b.c.white_text_color));
        }
        for (;;)
        {
          b(parami, paramT);
          d(parami, paramT);
          return;
          label3835:
          if ((this.xhM != 2) || (f >= 1.316667F)) {
            break;
          }
          p.j(localObject3, "banner");
          localObject3 = ((FinderMediaBanner)localObject3).getContext();
          p.j(localObject3, "banner.context");
          paramInt1 = (int)((Context)localObject3).getResources().getDimension(b.d.Edge_7_5_A);
          localObject3 = (HardTouchableLayout)parami.RD(b.f.media_container);
          p.j(localObject3, "mediaContainer");
          localObject3 = ((HardTouchableLayout)localObject3).getLayoutParams();
          if (localObject3 == null) {
            throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          }
          ((FrameLayout.LayoutParams)localObject3).topMargin = paramInt1;
          localObject3 = parami.RD(b.f.feedHeaderBar);
          p.j(localObject3, "it");
          ((View)localObject3).setBackground(null);
          ((View)localObject3).setTag(Boolean.FALSE);
          break;
          localObject3 = parami.getContext();
          p.j(localObject3, "holder.context");
          ((WeImageView)localObject1).setIconColor(((Context)localObject3).getResources().getColor(b.c.black_text_color));
          localObject1 = parami.getContext();
          p.j(localObject1, "holder.context");
          ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(b.c.FG_1));
          localObject1 = parami.getContext();
          p.j(localObject1, "holder.context");
          paramList.setTextColor(((Context)localObject1).getResources().getColor(b.c.black_text_color));
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem)
  {
    Object localObject2 = null;
    p.k(parami, "holder");
    p.k(paramFinderItem, "finderItem");
    Object localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)localObject1).dYT()) {
      Log.i("Finder.FeedConvert", "refreshBgmTag return for 青少年模式");
    }
    label262:
    label315:
    label321:
    label451:
    for (;;)
    {
      return;
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.E(paramFinderItem))
      {
        Log.i("Finder.FeedConvert", "refreshBgmTag: this feed has long video attachment, do not need to refresh bgm");
        return;
      }
      localObject1 = (FinderImgFeedMusicTag)parami.amk.findViewById(b.f.bgm_iv);
      p.j(localObject1, "tag");
      ((FinderImgFeedMusicTag)localObject1).setVisibility(8);
      ((FinderImgFeedMusicTag)localObject1).setTag(b.f.finder_music_visible_tag, Boolean.FALSE);
      if (this.xhT == 1)
      {
        Object localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.E(paramFinderItem.getFeedObject())) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label451;
          }
          ((FinderImgFeedMusicTag)localObject1).setTag(b.f.finder_music_visible_tag, Boolean.TRUE);
          if (paramFinderItem.getMediaType() == 2)
          {
            localObject2 = paramFinderItem.getFeedObject().objectDesc;
            if (localObject2 != null)
            {
              localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
              if (localObject2 != null)
              {
                localObject2 = paramFinderItem.getFeedObject().objectDesc;
                if (localObject2 != null)
                {
                  localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
                  if ((localObject2 != null) && (((bfs)localObject2).SQv == 0)) {}
                }
                else
                {
                  localObject2 = paramFinderItem.getFeedObject().objectDesc;
                  if (localObject2 == null) {
                    break label315;
                  }
                  localObject2 = ((FinderObjectDesc)localObject2).feedBgmInfo;
                  if (localObject2 == null) {
                    break label315;
                  }
                  localObject2 = ((bfs)localObject2).groupId;
                  localObject2 = (CharSequence)localObject2;
                  if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
                    break label321;
                  }
                }
              }
            }
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label326;
              }
              ((FinderImgFeedMusicTag)localObject1).setVisibility(8);
              ((FinderImgFeedMusicTag)localObject1).dLe();
              ((FinderImgFeedMusicTag)localObject1).setViewPager(null);
              return;
              localObject2 = null;
              break;
              localObject2 = null;
              break label262;
            }
            label326:
            paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
            if (paramFinderItem == null) {
              break;
            }
            paramFinderItem = paramFinderItem.feedBgmInfo;
            if (paramFinderItem == null) {
              break;
            }
            paramFinderItem = paramFinderItem.musicInfo;
            if (paramFinderItem == null) {
              break;
            }
            ((FinderImgFeedMusicTag)localObject1).a(paramFinderItem);
            ((FinderImgFeedMusicTag)localObject1).setViewPager((FinderMediaBanner)parami.RD(b.f.media_banner));
            return;
          }
          if (paramFinderItem.getMediaType() != 4) {
            break;
          }
          localObject3 = paramFinderItem.getFeedObject().objectDesc;
          parami = (com.tencent.mm.view.recyclerview.i)localObject2;
          if (localObject3 != null) {
            parami = ((FinderObjectDesc)localObject3).feedBgmInfo;
          }
          if (parami == null) {
            break;
          }
          parami = paramFinderItem.getFeedObject().objectDesc;
          if (parami != null)
          {
            parami = parami.feedBgmInfo;
            if ((parami != null) && (parami.SQv == 1)) {
              break;
            }
          }
          ((FinderImgFeedMusicTag)localObject1).setVisibility(8);
          return;
        }
      }
    }
  }
  
  public void b(com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(parami, "holder");
    super.b(parami);
  }
  
  public final void c(com.tencent.mm.view.recyclerview.i parami)
  {
    p.k(parami, "holder");
    Object localObject1 = (BaseFinderFeed)parami.ihX();
    Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (!com.tencent.mm.plugin.finder.utils.aj.y(((BaseFinderFeed)localObject1).feedObject.getFeedObject()))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject1 = parami.getContext();
      p.j(localObject1, "holder.context");
      parami = parami.getContext().getString(b.j.finder_private_ban_share);
      p.j(parami, "holder.context.getString…finder_private_ban_share)");
      com.tencent.mm.plugin.finder.utils.aj.aL((Context)localObject1, parami);
      return;
    }
    if (((BaseFinderFeed)localObject1).feedObject.isPrivate())
    {
      w.a(parami.getContext(), parami.getContext().getString(b.j.finder_private_feed_share_click_toast), (w.b)bc.xiX);
      return;
    }
    localObject2 = new com.tencent.mm.ui.widget.a.e(parami.getContext(), 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject2).a((q.f)new bd(this));
    ((com.tencent.mm.ui.widget.a.e)localObject2).a((q.g)new be(this, (BaseFinderFeed)localObject1));
    ((com.tencent.mm.ui.widget.a.e)localObject2).b((e.b)new bf(parami));
    ((com.tencent.mm.ui.widget.a.e)localObject2).eik();
  }
  
  public void d(com.tencent.mm.view.recyclerview.i parami, T paramT)
  {
    p.k(parami, "holder");
    p.k(paramT, "item");
  }
  
  public final boolean dps()
  {
    return this.safeMode;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$Companion;", "", "()V", "TAG", "", "payloadsAdFinishPlay", "", "payloadsAdFlagChanged", "payloadsAdFollowChanged", "payloadsAdMutualChanged", "payloadsAdSnsNotify", "payloadsAttachInfo", "payloadsCommentEdu", "payloadsExposeInfoType", "payloadsFavInfoType", "payloadsLiveNotice", "payloadsLiveStatus", "payloadsPlayMusic", "payloadsPostEnd", "payloadsProgressType", "payloadsRefreshAddForward", "payloadsRefreshComment", "payloadsRefreshForward", "payloadsRefreshLike", "payloadsRefreshOpCount", "payloadsShowAtTip", "payloadsStopMusic", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aa
    implements View.OnClickListener
  {
    aa(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(267403);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("Finder.FeedConvert", "onClickFav:" + parami.md());
      m.a(this.xia, parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267403);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class ab
    implements Runnable
  {
    ab(m paramm, View paramView, com.tencent.mm.view.recyclerview.i parami, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(278556);
      int i = this.xiv.getHeight();
      int j = KeyBoardUtil.getKeyBordHeightPx(this.tDl.getContext()) - this.xiw + i;
      Log.i("Finder.FeedConvert", "[openCommentDrawer] offset=" + j + " itemBottom=" + this.xix + " recyclerViewBottom=" + m.h(this.xia).bottom + " editLayoutHeight=" + i);
      if (j > 0)
      {
        FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = m.e(this.xia).getVideoCore().ANA;
        if (localFinderVideoAutoPlayManager != null) {
          FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, "openCommentDrawer", true);
        }
        this.tDl.getRecyclerView().ax(0, j);
      }
      AppMethodBeat.o(278556);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class ac
    implements CommentDrawerContract.CloseDrawerCallback
  {
    ac(com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed, aa.d paramd) {}
    
    public final void i(int paramInt, List<? extends s> paramList)
    {
      AppMethodBeat.i(282020);
      p.k(paramList, "data");
      ((FinderFeedExposeLayout)this.tDl.RD(b.f.comment_layout)).RE(this.xic.feedObject.getCommentCount());
      paramList = m.e(this.xia).getVideoCore().ANA;
      if (paramList != null) {
        FinderVideoAutoPlayManager.a(paramList, "openCommentDrawer", false);
      }
      if (m.e(this.xia).dsp())
      {
        paramList = this.tDl.RD(b.f.self_comment_count_tv);
        p.j(paramList, "holder.getView<TextView>…id.self_comment_count_tv)");
        ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.m.gY(1, this.xic.feedObject.getCommentCount()));
      }
      paramList = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUH().aSr()).intValue() == 1) {
        this.tDl.getRecyclerView().ax(0, -this.xiy.aaBA);
      }
      AppMethodBeat.o(282020);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ad
    implements View.OnClickListener
  {
    ad(m paramm, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288216);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = new Rect();
      paramView.getGlobalVisibleRect((Rect)localObject);
      paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
      com.tencent.mm.plugin.finder.storage.d.Qb(2);
      m.a(this.xia, parami, paramT, true, 0L, null, ((Rect)localObject).top - com.tencent.mm.view.d.e(parami.getContext(), 16.0F), paramInt, 24);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288216);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.m<View, FinderCommentInfo, kotlin.x>
  {
    ae(m paramm, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.m<View, FinderCommentInfo, kotlin.x>
  {
    af(m paramm, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "", "invoke"})
  static final class ag
    extends q
    implements kotlin.g.a.m<FinderCommentInfo, Boolean, kotlin.x>
  {
    ag(m paramm, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(FinderFeedExposeLayout paramFinderFeedExposeLayout, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234404);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.xiC.getOnCommentClickListener();
      if (paramView != null)
      {
        localObject = paramT;
        p.j(localObject, "selfCommentContainer");
        paramView.invoke(localObject, null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshExposeLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234404);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ai
    implements View.OnClickListener
  {
    ai(m paramm, List paramList, BaseFinderFeed paramBaseFinderFeed, asz paramasz, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237304);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      m.a(this.xiE, paramT, this.xiF, parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshFoldedLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237304);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class aj
    implements Runnable
  {
    aj(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(266078);
      Object localObject1 = new Rect();
      this.xiG.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_0_5_A);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.xiG;
      p.j(localObject2, "onliveView");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(266078);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.xiG));
      AppMethodBeat.o(266078);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ak
    implements View.OnClickListener
  {
    ak(com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230004);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshLiveIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      paramView = paramT.contact;
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        new com.tencent.mm.plugin.finder.view.y((Context)localObject, paramView, this.tDl.md(), paramT.feedObject.isLiveFeed()).dvx();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshLiveIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230004);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class al
    implements View.OnClickListener
  {
    al(com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234000);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.tDl.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(b.f.finder_feed_all_like_drawer);; paramView = null)
      {
        if (paramView == null) {
          p.iCn();
        }
        paramView.a(paramT.feedObject, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(234000);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class am
    implements View.OnClickListener
  {
    am(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228474);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xia.c(parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshOpLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228474);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$3"})
  static final class an
    implements View.OnTouchListener
  {
    an(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(228424);
      p.j(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramMotionEvent = (WeImageView)parami.RD(b.f.profile_timeline_like_posting);
        if (paramMotionEvent == null) {
          break label76;
        }
      }
      label76:
      for (paramView = paramMotionEvent.getTag();; paramView = null)
      {
        if (((paramView instanceof Integer)) && (p.h(paramMotionEvent.getTag(), Integer.valueOf(0)))) {
          m.d(parami);
        }
        AppMethodBeat.o(228424);
        return false;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$2", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$4"})
  static final class ao
    implements View.OnClickListener
  {
    ao(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290576);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("Finder.FeedConvert", "onClickLikeLocal:" + parami.md());
      m.b(this.xiH, parami, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290576);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$3", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$5"})
  static final class ap
    implements View.OnLongClickListener
  {
    ap(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(266047);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUZ().aSr()).intValue() == 1)
      {
        Log.i("Finder.FeedConvert", "onLongClickLikeLocal:" + parami.md());
        localObject = (WeImageView)parami.RD(b.f.profile_timeline_like_posting);
        if (localObject == null) {
          break label157;
        }
      }
      label157:
      for (paramView = ((WeImageView)localObject).getTag();; paramView = null)
      {
        if (((paramView instanceof Integer)) && (p.h(((WeImageView)localObject).getTag(), Integer.valueOf(0)))) {
          m.b(this.xiH, parami, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(266047);
        return true;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "", "invoke"})
  static final class aq
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    aq(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "", "invoke"})
  static final class ar
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    ar(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class as
    implements View.OnClickListener
  {
    as(m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275130);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = m.e(this.xia).getActivity();
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.h((Activity)paramView, ".ui.FinderHomeUI");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275130);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class at
    implements ValueAnimator.AnimatorUpdateListener
  {
    at(FinderPostProgressView paramFinderPostProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(291511);
      FinderPostProgressView localFinderPostProgressView = this.xiI;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(291511);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      this.xiI.invalidate();
      AppMethodBeat.o(291511);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class au
    implements View.OnClickListener
  {
    au(m paramm, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165378);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      m.a(paramT, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165378);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class av
    implements View.OnClickListener
  {
    av(m paramm, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264054);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      m.a(paramT, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264054);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aw
    implements View.OnClickListener
  {
    aw(BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291284);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.upload.g.AAk;
      com.tencent.mm.plugin.finder.upload.g.ecj().v(this.xic.feedObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291284);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$ifNeedAnim$1"})
  static final class ax
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    ax(aa.a parama1, aa.a parama2, m paramm, com.tencent.mm.view.recyclerview.i parami, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$initLikeAvatar$1"})
  static final class ay
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    ay(List paramList1, List paramList2, aa.f paramf, m paramm, com.tencent.mm.view.recyclerview.i parami, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$1$2"})
  static final class az
    implements View.OnClickListener
  {
    az(m paramm, com.tencent.mm.view.recyclerview.i parami, float paramFloat, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, LinkedList paramLinkedList, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285055);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = new bmq();
      ((bmq)localObject).feedId = paramT.mf();
      ((bmq)localObject).objectNonceId = paramT.feedObject.getObjectNonceId();
      ((bmq)localObject).scene = 2;
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = parami.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        paramView = paramView.ekY();
        ((bmq)localObject).xbu = paramView;
        localObject = parami.getContext();
        paramView = (View)localObject;
        if (!(localObject instanceof Activity)) {
          paramView = null;
        }
        paramView = (Activity)paramView;
        if (paramView == null) {
          break label196;
        }
      }
      label196:
      for (paramView = (FinderLikeDrawer)paramView.findViewById(b.f.finder_feed_friend_like_drawer);; paramView = null)
      {
        if (paramView == null) {
          p.iCn();
        }
        paramView.a(paramT.feedObject, m.a(paramT));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshRealNameRecommendLayout$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285055);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert$StateListener;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "parent", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getParent", "()Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "callback", "", "event", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-finder_release"})
  public static final class b<T extends BaseFinderFeed>
    extends IListener<hm>
    implements View.OnAttachStateChangeListener
  {
    final m<T> xhW;
    final com.tencent.mm.view.recyclerview.i xhX;
    
    public b(m<T> paramm, com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(165341);
      this.xhW = paramm;
      this.xhX = parami;
      if ((this.xhX.getContext() instanceof MMActivity))
      {
        paramm = this.xhX.getContext();
        if (paramm == null)
        {
          paramm = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165341);
          throw paramm;
        }
        ((MMActivity)paramm).getLifecycle().a((androidx.lifecycle.k)m.a(this.xhW));
      }
      AppMethodBeat.o(165341);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(165340);
      p.k(paramView, "v");
      AppMethodBeat.o(165340);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(165339);
      p.k(paramView, "v");
      AppMethodBeat.o(165339);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(m.b paramb, hm paramhm)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ba
    implements View.OnClickListener
  {
    ba(m paramm, com.tencent.mm.plugin.finder.storage.l paraml, com.tencent.mm.view.recyclerview.i parami, List paramList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, ViewGroup paramViewGroup) {}
    
    public final void onClick(View paramView)
    {
      int k = 1;
      String str = null;
      AppMethodBeat.i(267060);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshSimilarEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(paramView, "MMKernel.service(IFinder…enModeConfig::class.java)");
      Object localObject2;
      label167:
      long l1;
      int i;
      if (!((ae)paramView).dYT()) {
        if (Util.isNullOrNil(locall.getWording()))
        {
          paramView = parami.getContext().getString(b.j.finder_fav_similar_wording);
          p.j(paramView, "if (Util.isNullOrNil(att…lse attachFavInfo.wording");
          Object localObject3 = localList;
          BaseFinderFeed localBaseFinderFeed = paramT;
          com.tencent.mm.view.recyclerview.i locali = parami;
          localObject1 = locall.Ale;
          if (localObject1 != null)
          {
            localObject2 = ((asr)localObject1).lastBuffer;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = null;
          }
          m.a(paramView, (List)localObject3, localBaseFinderFeed, locali, (com.tencent.mm.cd.b)localObject1, bool);
          paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramView = parami.getContext();
          p.j(paramView, "holder.context");
          localObject2 = aj.a.fZ(paramView);
          paramView = com.tencent.mm.plugin.finder.report.n.zWF;
          l1 = paramT.mf();
          if (localObject2 == null) {
            break label416;
          }
          i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).xkX;
          label215:
          if (localObject2 == null) {
            break label421;
          }
          paramView = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).wmz;
          label226:
          if (localObject2 == null) {
            break label426;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).wmL;
          label238:
          if (localObject2 != null) {
            str = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).sessionId;
          }
          localObject3 = com.tencent.mm.plugin.finder.report.n.zWF;
          long l2 = paramT.mf();
          if (localObject2 == null) {
            break label432;
          }
          j = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2).xkX;
          label275:
          localObject2 = com.tencent.mm.plugin.finder.report.n.N(l2, j);
          if (!locall.Alc) {
            break label437;
          }
        }
      }
      label416:
      label421:
      label426:
      label432:
      label437:
      for (int j = k;; j = 2)
      {
        com.tencent.mm.plugin.finder.report.n.a(l1, 3, i, paramView, (String)localObject1, str, (String)localObject2, j);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshSimilarEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267060);
        return;
        paramView = locall.getWording();
        break;
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(localViewGroup.getContext());
        com.tencent.mm.plugin.report.service.h.IzE.a(20912, new Object[] { Integer.valueOf(3), Integer.valueOf(5), paramT.feedObject.getUserName(), paramT.feedObject.getNickName() });
        break label167;
        i = 0;
        break label215;
        paramView = null;
        break label226;
        localObject1 = null;
        break label238;
        j = 0;
        break label275;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class bb
    implements Runnable
  {
    bb(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(165379);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.tDl.ihX();
      if (localBaseFinderFeed == null)
      {
        Log.w("Finder.FeedConvert", "item is null??");
        AppMethodBeat.o(165379);
        return;
      }
      LinearLayout localLinearLayout = (LinearLayout)this.tDl.RD(b.f.center_ll);
      p.j(localLinearLayout, "centerLl");
      Object localObject2;
      Object localObject1;
      if (localLinearLayout.getWidth() > 0)
      {
        localObject2 = (ImageView)this.tDl.RD(b.f.auth_icon);
        localObject1 = (TextView)this.tDl.RD(b.f.follow_tv);
        p.j(localObject2, "authIconIv");
        if (((ImageView)localObject2).getVisibility() != 0) {
          break label386;
        }
      }
      label386:
      for (int j = ((ImageView)localObject2).getWidth();; j = 0)
      {
        p.j(localObject1, "followTv");
        CharSequence localCharSequence;
        int i;
        if (((TextView)localObject1).getVisibility() == 0) {
          if (((TextView)localObject1).getText() != null)
          {
            float f = com.tencent.mm.ci.a.aY(this.tDl.getContext(), b.d.Edge_4A);
            localObject2 = ((TextView)localObject1).getPaint();
            localCharSequence = ((TextView)localObject1).getText();
            localObject1 = ((TextView)localObject1).getText();
            if (localObject1 != null)
            {
              i = ((CharSequence)localObject1).length();
              i = (int)(((TextPaint)localObject2).measureText(localCharSequence, 0, i) + f);
            }
          }
        }
        for (;;)
        {
          label201:
          localObject1 = (TextView)this.tDl.RD(b.f.nickname);
          p.j(localObject1, "nicknameTv");
          localObject2 = ((TextView)localObject1).getPaint();
          localCharSequence = (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan();
          SpannableString localSpannableString = localBaseFinderFeed.feedObject.getNickNameSpan();
          if (localSpannableString != null) {}
          for (int k = localSpannableString.length();; k = 0)
          {
            if (((TextPaint)localObject2).measureText(localCharSequence, 0, k) + (j + i) <= localLinearLayout.getWidth()) {
              break label353;
            }
            ((TextView)localObject1).setText(TextUtils.ellipsize((CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan(), ((TextView)localObject1).getPaint(), localLinearLayout.getWidth() - j - i, TextUtils.TruncateAt.END));
            AppMethodBeat.o(165379);
            return;
            i = 0;
            break;
            i = ((TextView)localObject1).getWidth();
            break label201;
          }
          label353:
          this.tDl.e(b.f.nickname, (CharSequence)localBaseFinderFeed.feedObject.getNickNameSpan());
          AppMethodBeat.o(165379);
          return;
          i = 0;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class bc
    implements w.b
  {
    public static final bc xiX;
    
    static
    {
      AppMethodBeat.i(249350);
      xiX = new bc();
      AppMethodBeat.o(249350);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(249349);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(249349);
          return;
        }
      }
      AppMethodBeat.o(249349);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class bd
    implements q.f
  {
    bd(m paramm) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(288371);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(m.c(this.xia), b.j.finder_share_to_friend);
        paramo.mn(m.d(this.xia), b.j.finder_share_to_sns);
      }
      AppMethodBeat.o(288371);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class be
    implements q.g
  {
    be(m paramm, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(288764);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == m.c(this.xia))
      {
        m.e(this.xia).b(this.xic.feedObject);
        AppMethodBeat.o(288764);
        return;
      }
      if (paramInt == m.d(this.xia))
      {
        paramMenuItem = m.e(this.xia);
        BaseFinderFeed localBaseFinderFeed = this.xic;
        p.j(localBaseFinderFeed, "item");
        paramMenuItem.k(localBaseFinderFeed);
      }
      AppMethodBeat.o(288764);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onDismiss"})
  static final class bf
    implements e.b
  {
    bf(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(283680);
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      localObject = aj.a.fZ((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.tDl.ihX();
        com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.a(localBaseFinderFeed.feedObject.getId(), 1, 3L, "", (bid)localObject, 0L, null, 96);
        AppMethodBeat.o(283680);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$1"})
  static final class bg
    implements View.OnClickListener
  {
    bg(bfv parambfv1, m paramm, com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem, String paramString, bfv parambfv2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285502);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new Intent();
      paramView.putExtra("key_activity_id", this.xhs.xdR);
      paramView.putExtra("key_activity_name", this.xhs.eventName);
      paramView.putExtra("key_nick_name", this.xhs.SQA);
      paramView.putExtra("key_feed_ref_id", this.$item$inlined.getFeedObject().id);
      Log.i("Finder.FeedConvert", "eventTopicId :" + this.xhs.xdR + " eventName:" + this.xhs.eventName + " nickName:" + paramList + " refId: " + this.$item$inlined.getFeedObject().id);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = parami.getContext();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(285502);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.aa((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285502);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showActivityInfo$1$2"})
  static final class bh
    implements Runnable
  {
    bh(m paramm, com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem, String paramString, bfv parambfv) {}
    
    public final void run()
    {
      AppMethodBeat.i(278356);
      TextView localTextView = (TextView)parami.RD(b.f.feed_item_activity_title);
      Object localObject = parami.RD(b.f.finder_feed_item_of_activity);
      p.j(localObject, "holder.getView<FrameLayo…er_feed_item_of_activity)");
      int i = ((FrameLayout)localObject).getWidth();
      localObject = parami;
      p.j(localTextView, "textView");
      m.a((com.tencent.mm.view.recyclerview.i)localObject, localTextView, i, this.xhu);
      AppMethodBeat.o(278356);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$2$2$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$2"})
  static final class bi
    implements View.OnClickListener
  {
    bi(bgb parambgb, m paramm, com.tencent.mm.view.recyclerview.i parami, FinderItem paramFinderItem, String paramString) {}
    
    public final void onClick(View paramView)
    {
      int i = 0;
      AppMethodBeat.i(274184);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      long l1;
      if (this.xiZ.SQY > 0)
      {
        l1 = 1L;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_topic_type", this.xiZ.SQX);
        localIntent.putExtra("key_topic_title", this.xiZ.uLJ);
        localIntent.putExtra("KEY_TOPIC_ID", this.xiZ.xee);
        paramView = this.xiZ.SQZ;
        if (paramView != null) {
          localIntent.putExtra("KEY_HOT_TOPIC_BUFFER", paramView.UH);
        }
        localIntent.putExtra("key_hot_topic_type", this.xiZ.SQX);
        paramView = paramFinderItem;
        if (paramView != null)
        {
          paramView = Long.valueOf(paramView.getId());
          localIntent.putExtra("KEY_CLICK_FEED_ID", (Serializable)paramView);
          paramView = paramFinderItem;
          if (paramView == null) {
            break label428;
          }
          paramView = Long.valueOf(paramView.getId());
          label190:
          localIntent.putExtra("key_ref_object_id", (Serializable)paramView);
          localIntent.putExtra("KEY_TAB_TYPE", jdField_this.fEH);
          localObject = paramString;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localIntent.putExtra("key_from_user", paramView);
          paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramView = parami.getContext();
          p.j(paramView, "holder.context");
          aj.a.a(paramView, localIntent, 0L, 0, false, 124);
          paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
          paramView = parami.getContext();
          p.j(paramView, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.P(paramView, localIntent);
          label296:
          paramView = com.tencent.mm.plugin.finder.report.n.zWF;
          paramView = paramFinderItem;
          if (paramView == null) {
            break label445;
          }
          paramView = paramView.getFeedObject();
          if (paramView == null) {
            break label445;
          }
        }
      }
      label428:
      label445:
      for (long l2 = paramView.id;; l2 = 0L)
      {
        long l3 = this.xiZ.xee;
        localObject = this.xiZ.uLJ;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject = parami.getContext();
        p.j(localObject, "holder.context");
        localObject = aj.a.fZ((Context)localObject);
        if (localObject != null) {
          i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).xkX;
        }
        com.tencent.mm.plugin.finder.report.n.a(l2, 2L, l3, paramView, l1, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$showNewsIndicator$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274184);
        return;
        paramView = null;
        break;
        paramView = null;
        break label190;
        Log.i("Finder.FeedConvert", "hot news not support jump!");
        l1 = 0L;
        break label296;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class bk
    implements Runnable
  {
    bk(m paramm, BaseFinderFeed paramBaseFinderFeed, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(230480);
      paramT.showLikeTips = false;
      this.xjc.setVisibility(8);
      m.f(this.xia);
      AppMethodBeat.o(230480);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramInt = 1;
      AppMethodBeat.i(286549);
      BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parami.ihX();
      long l;
      Object localObject;
      if (!localBaseFinderFeed.feedObject.isPostFinish())
      {
        l = 0L;
        localObject = com.tencent.mm.ae.d.Fw(l);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
        paramDialogInterface = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramDialogInterface = parami.getContext();
        p.j(paramDialogInterface, "holder.context");
        paramDialogInterface = aj.a.fZ(paramDialogInterface);
        if (paramDialogInterface == null) {
          break label215;
        }
        paramDialogInterface = paramDialogInterface.wmL;
        label75:
        localh.a(21180, new Object[] { paramDialogInterface, localObject, Integer.valueOf(1), com.tencent.mm.plugin.sns.data.t.fNp() });
        paramDialogInterface = m.e(this.xia).getActivity();
        if (paramDialogInterface == null) {
          break label220;
        }
        paramDialogInterface = paramDialogInterface.getIntent();
        if ((paramDialogInterface == null) || (paramDialogInterface.getBooleanExtra("key_form_sns", false) != true)) {
          break label220;
        }
      }
      for (;;)
      {
        paramDialogInterface = ac.AEJ;
        localObject = m.e(this.xia).getActivity();
        if (localObject == null) {
          p.iCn();
        }
        localObject = (AppCompatActivity)localObject;
        p.j(localBaseFinderFeed, "currItem");
        ac.a.a(paramDialogInterface, (AppCompatActivity)localObject, localBaseFinderFeed, 5, paramInt, 4);
        AppMethodBeat.o(286549);
        return;
        l = localBaseFinderFeed.feedObject.getId();
        break;
        label215:
        paramDialogInterface = null;
        break label75;
        label220:
        paramDialogInterface = m.e(this.xia).getActivity();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getIntent();
          if (paramDialogInterface != null)
          {
            if (paramDialogInterface.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false) != true) {
              break label267;
            }
            paramInt = 2;
            continue;
          }
        }
        paramInt = 0;
        continue;
        label267:
        paramInt = 0;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(292232);
      paramDialogInterface = (BaseFinderFeed)this.tDl.ihX();
      long l;
      String str;
      com.tencent.mm.plugin.report.service.h localh;
      if (!paramDialogInterface.feedObject.isPostFinish())
      {
        l = 0L;
        str = com.tencent.mm.ae.d.Fw(l);
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        paramDialogInterface = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramDialogInterface = this.tDl.getContext();
        p.j(paramDialogInterface, "holder.context");
        paramDialogInterface = aj.a.fZ(paramDialogInterface);
        if (paramDialogInterface == null) {
          break label122;
        }
      }
      label122:
      for (paramDialogInterface = paramDialogInterface.wmL;; paramDialogInterface = null)
      {
        localh.a(21180, new Object[] { paramDialogInterface, str, Integer.valueOf(0), com.tencent.mm.plugin.sns.data.t.fNp() });
        AppMethodBeat.o(292232);
        return;
        l = paramDialogInterface.feedObject.getId();
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(m paramm, Context paramContext, FinderCommentInfo paramFinderCommentInfo, BaseFinderFeed paramBaseFinderFeed, long paramLong, String paramString) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(165347);
      paramDialogInterface = this.xia.tipDialog;
      if (paramDialogInterface != null) {
        paramDialogInterface.show();
      }
      for (;;)
      {
        paramDialogInterface = (kotlin.g.a.a)new b(this, (kotlin.g.a.a)new d(this), (kotlin.g.a.a)new c(this));
        if (this.xib.commentId == 0L) {
          break;
        }
        paramDialogInterface.invoke();
        AppMethodBeat.o(165347);
        return;
        paramDialogInterface = this.xia;
        localObject = this.$context;
        this.$context.getString(b.j.app_tip);
        paramDialogInterface.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a((Context)localObject, this.$context.getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.xie));
      }
      paramDialogInterface = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderActionStorage();
      Object localObject = this.xib.client_id;
      if (localObject != null) {}
      for (long l = Long.parseLong((String)localObject);; l = 0L)
      {
        paramDialogInterface.ME(l);
        AppMethodBeat.o(165347);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xie;
      
      static
      {
        AppMethodBeat.i(165342);
        xie = new a();
        AppMethodBeat.o(165342);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(m.e parame, kotlin.g.a.a parama1, kotlin.g.a.a parama2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      c(m.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      d(m.e parame)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$1"})
  static final class f
    implements Runnable
  {
    f(View paramView, TextView paramTextView, String paramString, m paramm, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165348);
      Object localObject = this.xhB;
      p.j(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.ci.a.fromDPToPix(parami.getContext(), 20);
        localObject = paramList;
        p.j(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.xhD) + j > i)
        {
          localObject = paramList;
          p.j(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.xhD;
          TextView localTextView = paramList;
          p.j(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165348);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$11$2"})
  static final class g
    implements View.OnClickListener
  {
    g(String paramString, m paramm, com.tencent.mm.view.recyclerview.i parami, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165349);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      m.a(jdField_this, parami, paramT, this.xhD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165349);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$1"})
  static final class h
    implements Runnable
  {
    h(TextView paramTextView, String paramString, m paramm, com.tencent.mm.view.recyclerview.i parami, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void run()
    {
      AppMethodBeat.i(165350);
      Object localObject = this.xhA;
      p.j(localObject, "linkLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.ci.a.fromDPToPix(parami.getContext(), 20);
        localObject = this.xhy;
        p.j(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.xhz) + j > i)
        {
          localObject = this.xhy;
          p.j(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.xhz;
          TextView localTextView = this.xhy;
          p.j(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(165350);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$12$2"})
  static final class i
    implements View.OnClickListener
  {
    i(String paramString, m paramm, com.tencent.mm.view.recyclerview.i parami, View paramView, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165351);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      m.a(parami, paramT, this.qQa);
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = parami.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null) {}
      for (paramView = paramView.ekY();; paramView = null)
      {
        m.a(paramView, paramT.feedObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(165351);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isCollapse", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    j(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(267996);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = (BaseFinderFeed)parami.ihX();
      localObject1 = new com.tencent.mm.ui.widget.a.e(parami.getContext(), 0, false);
      Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      p.j(paramView, "item");
      if (com.tencent.mm.plugin.finder.utils.aj.w(paramView))
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject2 = parami.getContext();
        p.j(localObject2, "holder.context");
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject2, paramView, (com.tencent.mm.ui.widget.a.e)localObject1));
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        int i = this.xia.fEH;
        localObject2 = parami.getContext();
        p.j(localObject2, "holder.context");
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(com.tencent.mm.plugin.finder.live.utils.a.a(i, (Context)localObject2, paramView));
      }
      for (;;)
      {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(m.e(this.xia).a(paramView, 2, parami));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(m.e(this.xia).a(paramView, 2, parami));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(276792);
            Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
            localObject = this.xik.tDl.getContext();
            p.j(localObject, "holder.context");
            localObject = aj.a.fZ((Context)localObject);
            if (localObject != null) {}
            for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
            {
              BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)this.xik.tDl.ihX();
              com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
              com.tencent.mm.plugin.finder.report.n.a(localBaseFinderFeed.feedObject.getId(), 2, 3L, "", (bid)localObject, 0L, null, 96);
              AppMethodBeat.o(276792);
              return;
            }
          }
        });
        ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.D(paramView.feedObject))
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject1 = parami.getContext();
          p.j(localObject1, "holder.context");
          localObject1 = aj.a.fZ((Context)localObject1);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
              com.tencent.mm.plugin.finder.report.n.a((bid)localObject1, paramView.feedObject.field_id, Integer.valueOf(paramView.feedObject.getFeedObject().follow_feed_count));
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267996);
        return;
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(m.e(this.xia).a(paramView, (com.tencent.mm.ui.widget.a.e)localObject1, 2));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(m.e(this.xia).a(paramView, (com.tencent.mm.ui.widget.a.e)localObject1));
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    l(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class m
    implements HardTouchableLayout.b
  {
    m(HardTouchableLayout paramHardTouchableLayout, m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(277044);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      Log.i("Finder.FeedConvert", "onDoubleClickListener onMediaClick " + (BaseFinderFeed)parami.ihX());
      jdField_this.a(parami, (View)this.xim);
      AppMethodBeat.o(277044);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.g
  {
    n(HardTouchableLayout paramHardTouchableLayout, m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void et(View paramView)
    {
      AppMethodBeat.i(285048);
      p.k(paramView, "view");
      Log.i("Finder.FeedConvert", "onSingleClickListener onMediaClick  " + (BaseFinderFeed)parami.ihX());
      jdField_this.a(parami, (View)this.xim, ((BaseFinderFeed)parami.ihX()).feedObject.getFeedObject());
      AppMethodBeat.o(285048);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223353);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = (BaseFinderFeed)this.tDl.ihX();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = this.tDl.getContext();
      p.j(localObject1, "holder.context");
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 != null) {}
      for (int i = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).xkX;; i = 0)
      {
        localObject1 = this.tDl.getContext().getClass().getName();
        p.j(localObject1, "holder.context.javaClass.name");
        if (((p.h(localObject1, "com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI")) || (p.h(localObject1, "FinderProfileTimeLineUI"))) && ((paramView instanceof BaseFinderFeed))) {
          com.tencent.mm.plugin.finder.live.report.k.yBj.a(paramView, this.tDl.md(), s.t.yGS, "1");
        }
        if ((i != 1) && (i != 8)) {
          break label240;
        }
        Log.i("Finder.FeedConvert", "hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.a(3, paramView.mf(), i, 1, paramView.feedObject.getUserName());
        paramView = this.tDl.getContext();
        if (paramView != null) {
          break;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(223353);
        throw paramView;
      }
      ((Activity)paramView).finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223353);
      return;
      label240:
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramView.feedObject.getUserName());
      ((Intent)localObject1).putExtra("finder_read_feed_id", paramView.feedObject.getId());
      Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject2 = this.tDl.getContext();
      p.j(localObject2, "holder.context");
      aj.a.a((Context)localObject2, (Intent)localObject1, paramView.mf(), 1, false, 64);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject2 = this.tDl.getContext();
      p.j(localObject2, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject2, (Intent)localObject1);
      if ((this.tDl.getContext() instanceof MMActivity))
      {
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = this.tDl.getContext();
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(223353);
          throw paramView;
        }
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.b((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject1).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.a)localObject1).dpO().KF(paramView.mf());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a(3, paramView.mf(), i, 1, paramView.feedObject.getUserName());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223353);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class p
    implements Runnable
  {
    p(com.tencent.mm.view.recyclerview.i parami, aa.f paramf1, aa.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(275188);
      int i = com.tencent.mm.ci.a.aZ(this.tDl.getContext(), b.d.Edge_A);
      Rect localRect = new Rect();
      ((View)this.xin.aaBC).getHitRect(localRect);
      localRect.inset(-i, -i);
      ((an)paramRecyclerView.aaBC).a(new ao(localRect, (View)this.xin.aaBC));
      AppMethodBeat.o(275188);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(268825);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("Finder.FeedConvert", "onClickShare:" + parami.md());
      this.xia.c(parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(268825);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class r
    implements Runnable
  {
    r(com.tencent.mm.view.recyclerview.i parami, aa.f paramf1, aa.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(291245);
      int i = com.tencent.mm.ci.a.aZ(this.tDl.getContext(), b.d.Edge_A);
      Rect localRect = new Rect();
      ((View)this.xip.aaBC).getHitRect(localRect);
      localRect.inset(-i, -i);
      ((an)paramRecyclerView.aaBC).a(new ao(localRect, (View)this.xip.aaBC));
      AppMethodBeat.o(291245);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class s
    implements View.OnLongClickListener
  {
    s(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(286005);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = (BaseFinderFeed)this.tDl.ihX();
      paramView = (FinderVideoLayout)this.tDl.RD(b.f.finder_banner_video_layout);
      if (paramView != null)
      {
        paramView = paramView.getPlayInfo();
        if (paramView == null) {}
      }
      for (paramView = paramView.zBB;; paramView = null)
      {
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        localObject2 = this.tDl.getContext();
        if (localObject2 != null) {
          break;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(286005);
        throw paramView;
      }
      Object localObject2 = (com.tencent.mm.plugin.finder.viewmodel.component.m)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject2).i(com.tencent.mm.plugin.finder.viewmodel.component.m.class);
      Context localContext = this.tDl.getContext();
      p.j(localContext, "holder.context");
      p.j(localObject1, "item");
      ((com.tencent.mm.plugin.finder.viewmodel.component.m)localObject2).a(localContext, (BaseFinderFeed)localObject1, paramView, this.tDl);
      this.tDl.amk.requestLayout();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(286005);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class t
    implements Runnable
  {
    t(ImageView paramImageView) {}
    
    public final void run()
    {
      AppMethodBeat.i(275587);
      Object localObject1 = new Rect();
      this.xiq.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.xiq;
      p.j(localObject2, "avatarView");
      localObject2 = ((ImageView)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(275587);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.xiq));
      AppMethodBeat.o(275587);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$3$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class u
    implements HardTouchableLayout.c
  {
    public final boolean Y(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(285114);
      p.k(paramMotionEvent, "event");
      AppMethodBeat.o(285114);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class v
    implements View.OnTouchListener
  {
    v(aa.f paramf) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(291487);
      p.j(paramMotionEvent, "event");
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.removeCallbacks((Runnable)this.xir.aaBC);
      }
      AppMethodBeat.o(291487);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165361);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("Finder.FeedConvert", "onClickLike:" + parami.md());
      m.a(this.xia, parami, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165361);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class x
    implements View.OnLongClickListener
  {
    x(m paramm, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(279034);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = (BaseFinderFeed)parami.ihX();
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUZ().aSr()).intValue() == 1)
      {
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.j(paramView.contact))
        {
          Log.i("Finder.FeedConvert", "onLongClick Private Like:" + parami.md());
          paramView = (WeImageView)parami.RD(b.f.icon_feed_like);
          p.j(paramView, "awesomeIv");
          if (((paramView.getTag() instanceof Integer)) && (p.h(paramView.getTag(), Integer.valueOf(0))))
          {
            paramView = new com.tencent.mm.ui.widget.a.e(parami.getContext(), 1, true);
            paramView.a((q.f)new q.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
              {
                AppMethodBeat.i(281949);
                p.j(paramAnonymouso, "it");
                if (paramAnonymouso.hJO())
                {
                  int i = m.b(this.xis.xia);
                  Context localContext = this.xis.tDl.getContext();
                  p.j(localContext, "holder.context");
                  paramAnonymouso.d(i, (CharSequence)localContext.getResources().getString(b.j.finder_awesome_ground_title));
                }
                AppMethodBeat.o(281949);
              }
            });
            paramView.a((q.g)new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(288501);
                p.j(paramAnonymousMenuItem, "menuItem");
                if (paramAnonymousMenuItem.getItemId() == m.b(this.xis.xia)) {
                  m.a(this.xis.xia, this.xis.tDl, true);
                }
                AppMethodBeat.o(288501);
              }
            });
            paramView.eik();
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(279034);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class y
    implements Runnable
  {
    y(aa.f paramf1, com.tencent.mm.view.recyclerview.i parami, aa.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(286182);
      Rect localRect = new Rect();
      ((View)this.xit.aaBC).getHitRect(localRect);
      int i = com.tencent.mm.ci.a.aZ(parami.getContext(), b.d.Edge_A);
      localRect.inset(-i, -i);
      an localan = (an)paramRecyclerView.aaBC;
      View localView = (View)this.xit.aaBC;
      p.j(localView, "awesomeView");
      localan.a(new ao(localRect, localView));
      AppMethodBeat.o(286182);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
  static final class z
    implements Runnable
  {
    z(aa.f paramf1, com.tencent.mm.view.recyclerview.i parami, aa.f paramf2) {}
    
    public final void run()
    {
      AppMethodBeat.i(291291);
      Rect localRect = new Rect();
      ((View)this.xiu.aaBC).getHitRect(localRect);
      int i = com.tencent.mm.ci.a.aZ(parami.getContext(), b.d.Edge_A);
      localRect.inset(-i, -i);
      an localan = (an)paramRecyclerView.aaBC;
      View localView = (View)this.xiu.aaBC;
      p.j(localView, "commentView");
      localan.a(new ao(localRect, localView));
      AppMethodBeat.o(291291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.m
 * JD-Core Version:    0.7.0.1
 */