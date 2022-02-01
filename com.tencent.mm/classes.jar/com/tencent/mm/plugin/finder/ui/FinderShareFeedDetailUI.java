package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.feed.k.b;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderBaseFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/Presenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "encryptedObjectId", "getEncryptedObjectId", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "firstResume", "", "getFirstResume", "()Z", "setFirstResume", "(Z)V", "fromUser", "getFromUser", "setFromUser", "isShareClickReport", "jumpBtn", "Landroid/view/View;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLikeBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLikeBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "presenter", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "showJumpEntry", "getShowJumpEntry", "setShowJumpEntry", "tipsLayout", "viewCallback", "getCommentScene", "getLayoutId", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initData", "initOnCreate", "initViews", "onDestroy", "onResume", "showErrorUi", "errCode", "errMsg", "(Ljava/lang/Integer;Ljava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderShareFeedDetailUI
  extends FinderBaseFeedUI<k.b, h>
{
  private String AUV;
  private BaseFinderFeed AUZ;
  private final j Bae;
  private final j Baf;
  private View EBQ;
  private k.b FSD;
  private boolean FUA;
  private View FUB;
  private boolean FUC;
  private h FUy;
  private boolean FUz;
  private final String TAG;
  private boolean firstResume;
  private long hKN;
  private String hQQ;
  private com.tencent.mm.bx.b likeBuffer;
  private String objectNonceId;
  private int scene;
  private int ybL;
  
  public FinderShareFeedDetailUI()
  {
    AppMethodBeat.i(167676);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    this.AUV = "";
    this.objectNonceId = "";
    this.scene = 2;
    this.hQQ = "";
    this.Bae = k.cm((kotlin.g.a.a)new a(this));
    this.Baf = k.cm((kotlin.g.a.a)new b(this));
    this.FUz = true;
    this.FUA = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
    this.firstResume = true;
    AppMethodBeat.o(167676);
  }
  
  private static final ah a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI, b.a parama)
  {
    AppMethodBeat.i(346441);
    kotlin.g.b.s.u(paramFinderShareFeedDetailUI, "this$0");
    Object localObject1;
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      localObject1 = aw.Gjk;
      if (!aw.iv(parama.errType, parama.errCode)) {}
    }
    else
    {
      FinderObject localFinderObject = ((ayl)parama.ott).feedObject;
      if (localFinderObject == null)
      {
        AppMethodBeat.o(346441);
        return null;
      }
      Log.i(paramFinderShareFeedDetailUI.TAG, "get feed detail success");
      localObject1 = new FinderContact();
      parama = localFinderObject.contact;
      label116:
      BaseFinderFeed localBaseFinderFeed;
      label134:
      label152:
      label170:
      long l;
      label340:
      Object localObject2;
      label554:
      String str;
      if (parama == null)
      {
        parama = null;
        ((FinderContact)localObject1).username = parama;
        parama = localFinderObject.contact;
        if (parama != null) {
          break label656;
        }
        parama = null;
        ((FinderContact)localObject1).nickname = parama;
        parama = localFinderObject.contact;
        if (parama != null) {
          break label664;
        }
        parama = null;
        ((FinderContact)localObject1).headUrl = parama;
        parama = localFinderObject.contact;
        if (parama != null) {
          break label672;
        }
        parama = null;
        ((FinderContact)localObject1).authInfo = parama;
        parama = localFinderObject.contact;
        if (parama != null) {
          break label680;
        }
        parama = null;
        ((FinderContact)localObject1).extInfo = parama;
        parama = com.tencent.mm.plugin.finder.api.d.AwY;
        com.tencent.mm.plugin.finder.api.d.a.e((FinderContact)localObject1);
        parama = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        parama = FinderItem.Companion;
        localBaseFinderFeed = com.tencent.mm.plugin.finder.storage.logic.d.a.a(FinderItem.a.e(localFinderObject, 1));
        parama = localBaseFinderFeed.feedObject;
        localObject1 = e.FMN;
        e.a.s(parama);
        paramFinderShareFeedDetailUI.AUZ = localBaseFinderFeed;
        localObject1 = paramFinderShareFeedDetailUI.FUy;
        parama = (b.a)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("presenter");
          parama = null;
        }
        localObject1 = paramFinderShareFeedDetailUI.AUZ;
        kotlin.g.b.s.checkNotNull(localObject1);
        parama.g((BaseFinderFeed)localObject1);
        int i;
        if ((paramFinderShareFeedDetailUI.ybL != 0) && (!paramFinderShareFeedDetailUI.FUC))
        {
          parama = z.FrZ;
          l = paramFinderShareFeedDetailUI.hKN;
          i = paramFinderShareFeedDetailUI.ybL;
          parama = paramFinderShareFeedDetailUI.hQQ;
          localObject1 = parama;
          if (parama == null) {
            localObject1 = "";
          }
          parama = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          parama = paramFinderShareFeedDetailUI.getContext();
          kotlin.g.b.s.s(parama, "context");
          parama = as.a.hu((Context)parama);
          if (parama != null) {
            break label688;
          }
          parama = null;
          z.a(l, i, (String)localObject1, 1, 0, parama);
          paramFinderShareFeedDetailUI.FUC = true;
        }
        if (!paramFinderShareFeedDetailUI.FUA) {
          break label710;
        }
        parama = com.tencent.mm.plugin.finder.storage.d.FAy;
        if ((!com.tencent.mm.plugin.finder.storage.d.eQW()) || (!paramFinderShareFeedDetailUI.FUz)) {
          break label710;
        }
        if (paramFinderShareFeedDetailUI.FUB == null)
        {
          localObject2 = LayoutInflater.from((Context)paramFinderShareFeedDetailUI);
          i = e.f.finder_feed_detail_footer;
          localObject1 = paramFinderShareFeedDetailUI.FSD;
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            parama = null;
          }
          paramFinderShareFeedDetailUI.FUB = ((LayoutInflater)localObject2).inflate(i, (ViewGroup)parama.ATx.getRecyclerView(), false);
          localObject1 = paramFinderShareFeedDetailUI.FSD;
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            parama = null;
          }
          parama = parama.getAdapter();
          localObject1 = paramFinderShareFeedDetailUI.FUB;
          kotlin.g.b.s.checkNotNull(localObject1);
          parama.j((View)localObject1, 0, false);
          localObject1 = paramFinderShareFeedDetailUI.FSD;
          parama = (b.a)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("viewCallback");
            parama = null;
          }
          parama.getAdapter().agOe = null;
          parama = paramFinderShareFeedDetailUI.FUB;
          kotlin.g.b.s.checkNotNull(parama);
          parama.setOnClickListener(new FinderShareFeedDetailUI..ExternalSyntheticLambda0(paramFinderShareFeedDetailUI));
        }
        parama = paramFinderShareFeedDetailUI.FUB;
        if (parama != null) {
          parama.setVisibility(0);
        }
        localObject2 = paramFinderShareFeedDetailUI.ecL();
        l = localFinderObject.id;
        str = localFinderObject.objectNonceId;
        if (localFinderObject.secondaryShowFlag == 1) {
          break label728;
        }
      }
      label656:
      label664:
      label672:
      label680:
      label688:
      label710:
      label728:
      for (boolean bool = true;; bool = false)
      {
        localObject1 = localFinderObject.username;
        parama = (b.a)localObject1;
        if (localObject1 == null) {
          parama = "";
        }
        i.a((i)localObject2, l, str, 25, bool, parama);
        if (paramFinderShareFeedDetailUI.hKN == 0L) {
          paramFinderShareFeedDetailUI.hKN = localBaseFinderFeed.feedObject.getId();
        }
        paramFinderShareFeedDetailUI = ah.aiuX;
        AppMethodBeat.o(346441);
        return paramFinderShareFeedDetailUI;
        parama = parama.username;
        break;
        parama = parama.nickname;
        break label116;
        parama = parama.headUrl;
        break label134;
        parama = parama.authInfo;
        break label152;
        parama = parama.extInfo;
        break label170;
        parama = parama.fou();
        if (parama == null)
        {
          parama = null;
          break label340;
        }
        parama = parama.zIO;
        break label340;
        parama = paramFinderShareFeedDetailUI.FUB;
        if (parama == null) {
          break label554;
        }
        parama.setVisibility(8);
        break label554;
      }
    }
    if ((parama.errCode == -4011) || (parama.errCode == -4033) || (parama.errCode == -4036)) {
      paramFinderShareFeedDetailUI.a(Integer.valueOf(parama.errCode), parama.errMsg);
    }
    paramFinderShareFeedDetailUI = ah.aiuX;
    AppMethodBeat.o(346441);
    return paramFinderShareFeedDetailUI;
  }
  
  private static final void a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI, View paramView)
  {
    AppMethodBeat.i(346425);
    kotlin.g.b.s.u(paramFinderShareFeedDetailUI, "this$0");
    paramView = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMN();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).resetLastTimelineExitTime();
    paramView = UUID.randomUUID().toString();
    kotlin.g.b.s.s(paramView, "randomUUID().toString()");
    Object localObject = z.FrZ;
    z.id(paramView, "Enter");
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_context_id", paramView);
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.a((Context)paramFinderShareFeedDetailUI, (Intent)localObject, 1, false, 8);
    AppMethodBeat.o(346425);
  }
  
  private final void a(Integer paramInteger, String paramString)
  {
    Object localObject2 = null;
    int j = 1;
    int i = 1;
    AppMethodBeat.i(346418);
    Object localObject3 = this.FSD;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = null;
    }
    ((b.b)localObject1).ATx.getRecyclerView().setVisibility(8);
    localObject3 = this.EBQ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("tipsLayout");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject1 = this.EBQ;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("tipsLayout");
      localObject1 = localObject2;
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.delete_tip_tv);
      if (paramInteger != null) {
        break label145;
      }
      label119:
      if (paramInteger != null) {
        break label211;
      }
      label123:
      if (paramInteger != null) {
        break label280;
      }
    }
    label145:
    label190:
    label211:
    while (paramInteger.intValue() != -4036)
    {
      ((TextView)localObject1).setText(e.h.finder_feed_deleted_tip);
      AppMethodBeat.o(346418);
      return;
      break;
      if (paramInteger.intValue() != -4011) {
        break label119;
      }
      if (paramString != null) {
        if (((CharSequence)paramString).length() != 0) {
          break label190;
        }
      }
      while (i != 0)
      {
        ((TextView)localObject1).setText(e.h.finder_feed_deleted_tip);
        AppMethodBeat.o(346418);
        return;
        i = 0;
      }
      ((TextView)localObject1).setText((CharSequence)paramString);
      AppMethodBeat.o(346418);
      return;
      if (paramInteger.intValue() != -4033) {
        break label123;
      }
      if (paramString != null) {
        if (((CharSequence)paramString).length() != 0) {
          break label259;
        }
      }
      for (i = j; i != 0; i = 0)
      {
        ((TextView)localObject1).setText(e.h.finder_feed_self_see_tip);
        AppMethodBeat.o(346418);
        return;
      }
      ((TextView)localObject1).setText((CharSequence)paramString);
      AppMethodBeat.o(346418);
      return;
    }
    label259:
    label280:
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label327;
      }
    }
    label327:
    for (i = 1; i != 0; i = 0)
    {
      ((TextView)localObject1).setText(e.h.finder_set_privacy_tips);
      AppMethodBeat.o(346418);
      return;
    }
    ((TextView)localObject1).setText((CharSequence)paramString);
    AppMethodBeat.o(346418);
  }
  
  private i ecL()
  {
    AppMethodBeat.i(346398);
    i locali = (i)this.Bae.getValue();
    AppMethodBeat.o(346398);
    return locali;
  }
  
  private com.tencent.mm.plugin.findersdk.a.as ecM()
  {
    AppMethodBeat.i(346404);
    com.tencent.mm.plugin.findersdk.a.as localas = (com.tencent.mm.plugin.findersdk.a.as)this.Baf.getValue();
    AppMethodBeat.o(346404);
    return localas;
  }
  
  private h fbR()
  {
    AppMethodBeat.i(346409);
    h localh = this.FUy;
    if (localh == null)
    {
      kotlin.g.b.s.bIx("presenter");
      AppMethodBeat.o(346409);
      return null;
    }
    AppMethodBeat.o(346409);
    return localh;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void eeB()
  {
    AppMethodBeat.i(167673);
    setMMTitle(e.h.finder_title);
    Object localObject = findViewById(e.e.share_feed_detail_tips_layout);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.EBQ = ((View)localObject);
    View localView = this.EBQ;
    localObject = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("tipsLayout");
      localObject = null;
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(167673);
  }
  
  public final int getCommentScene()
  {
    return 25;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_share_feed_detail_ui;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    boolean bool2 = true;
    AppMethodBeat.i(167672);
    this.hKN = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject3 = getIntent().getStringExtra("feed_encrypted_object_id");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.AUV = ((String)localObject1);
    localObject3 = getIntent().getStringExtra("feed_object_nonceId");
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "";
    }
    this.objectNonceId = ((String)localObject1);
    this.ybL = getIntent().getIntExtra("report_scene", 0);
    this.hQQ = getIntent().getStringExtra("from_user");
    this.FUz = getIntent().getBooleanExtra("key_show_jump_entry", true);
    localObject1 = getIntent().getStringExtra("key_like_buffer");
    if ((localObject1 != null) && (!Util.isNullOrNil((String)localObject1))) {
      this.likeBuffer = com.tencent.mm.bx.b.cX(Util.decodeHexString((String)localObject1));
    }
    if ((this.hKN == 0L) && (Util.isNullOrNil(this.AUV)))
    {
      Log.w(this.TAG, "objectId " + this.hKN + ", encryptedObjectId " + this.AUV + ", finish");
      finish();
    }
    int i = this.scene;
    localObject1 = (MMActivity)this;
    boolean bool1;
    Object localObject4;
    if (!this.FUA)
    {
      bool1 = true;
      this.FUy = new h(i, (MMActivity)localObject1, bool1);
      localObject4 = (MMActivity)this;
      localObject3 = this.FUy;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("presenter");
        localObject1 = null;
      }
      localObject1 = (k.a)localObject1;
      i = this.scene;
      int j = getCommentScene();
      if (this.FUA) {
        break label692;
      }
      bool1 = bool2;
      label331:
      this.FSD = new k.b((MMActivity)localObject4, (k.a)localObject1, i, j, bool1);
      if (this.hKN != 0L)
      {
        localObject1 = e.FMN;
        localObject1 = e.a.jn(this.hKN);
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          this.AUZ = com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject1);
          localObject3 = this.FUy;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("presenter");
            localObject1 = null;
          }
          localObject1 = ((k.a)localObject1).feedList;
          if (localObject1 != null)
          {
            localObject3 = this.AUZ;
            kotlin.g.b.s.checkNotNull(localObject3);
            ((ArrayList)localObject1).add(localObject3);
          }
        }
      }
      if (this.ybL != 0) {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1278L, 14L, 1L, false);
      }
      ecL().a(this.scene, getCommentScene(), (kotlin.g.a.b)new c(this));
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)ecL());
        }
      }
      localObject3 = ecM();
      localObject4 = (m)new d(this);
      localObject1 = this.FSD;
      if (localObject1 != null) {
        break label697;
      }
      kotlin.g.b.s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    label692:
    label697:
    for (;;)
    {
      ((com.tencent.mm.plugin.findersdk.a.as)localObject3).a((m)localObject4, ((b.b)localObject1).ATx.getRecyclerView());
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((c)localObject1).a(ecM().edV());
        }
      }
      AppMethodBeat.o(167672);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label331;
    }
  }
  
  public final void onDestroy()
  {
    String str = null;
    AppMethodBeat.i(178446);
    Object localObject1;
    long l;
    int i;
    Object localObject2;
    if ((this.ybL != 0) && (!this.FUC))
    {
      localObject1 = z.FrZ;
      l = this.hKN;
      i = this.ybL;
      localObject2 = this.hQQ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      localObject2 = as.a.hu((Context)localObject2);
      if (localObject2 != null) {
        break label271;
      }
    }
    for (;;)
    {
      z.a(l, i, (String)localObject1, 0, 0, str);
      this.FUC = true;
      ecL().onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)ecL());
        }
      }
      ecM().onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((c)localObject1).b(ecM().edV());
        }
      }
      fbR().onDetach();
      super.onDestroy();
      AppMethodBeat.o(178446);
      return;
      label271:
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject2).fou();
      if (localObject2 != null) {
        str = ((bui)localObject2).zIO;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167671);
    super.onResume();
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).eZF())
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXV().bmg()).intValue() == 1)
      {
        a(Integer.valueOf(-4036), getContext().getResources().getString(e.h.finder_teen_mode_tips));
        AppMethodBeat.o(167671);
        return;
      }
    }
    long l = this.hKN;
    String str1 = this.objectNonceId;
    int i = getCommentScene();
    String str2 = this.AUV;
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).fou())
    {
      new az(l, str1, i, 2, "", true, null, null, 0L, null, false, false, str2, (bui)localObject, 0, null, 53184).bFJ().b(new FinderShareFeedDetailUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(167671);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<i>
  {
    a(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.a.as>
  {
    b(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, cc>
  {
    c(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
  {
    d(FinderShareFeedDetailUI paramFinderShareFeedDetailUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI
 * JD-Core Version:    0.7.0.1
 */