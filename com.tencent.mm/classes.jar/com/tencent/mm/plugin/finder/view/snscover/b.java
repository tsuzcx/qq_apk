package com.tencent.mm.plugin.finder.view.snscover;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.no;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.cover.a.e;
import com.tencent.mm.plugin.sns.cover.preview.SnsCoverFadeImageView;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/snscover/SnsFinderImageBackView;", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "audioHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelperImpl;", "authorNameView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAuthorNameView", "()Landroid/widget/TextView;", "authorNameView$delegate", "Lkotlin/Lazy;", "avatarFl", "Landroid/widget/LinearLayout;", "getAvatarFl", "()Landroid/widget/LinearLayout;", "avatarFl$delegate", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "avatarView$delegate", "banner", "Lcom/tencent/mm/plugin/finder/view/snscover/SnsFinderImageBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/snscover/SnsFinderImageBanner;", "banner$delegate", "finderDesc", "getFinderDesc", "finderDesc$delegate", "finderDetailLoader", "Lcom/tencent/mm/plugin/finder/view/snscover/FinderDetailLoader;", "jumpFinderView", "Landroid/widget/FrameLayout;", "getJumpFinderView", "()Landroid/widget/FrameLayout;", "jumpFinderView$delegate", "musicPlayer", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "snsCoverStatusProvider", "Lcom/tencent/mm/plugin/sns/cover/api/SnsCoverStatusProvider;", "thumbView", "Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "getThumbView", "()Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "thumbView$delegate", "coverInfoValid", "", "coverInfo", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverInfo;", "enablePlay", "getLayoutId", "", "getMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getType", "initBanner", "", "initDetailAndPlay", "isNeedMute", "isTimelineUI", "loadCover", "loadFinderObject", "loadLocalThumb", "onChange", "focusChange", "onDestroy", "onPause", "onPostClose", "onPostOpen", "onPreClose", "onPreOpen", "onResume", "pause", "play", "recreateMusicPlayer", "resetBanner", "setCoverFoldStatusProvider", "setupBannerInfo", "updateFinderObject", "needPlay", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.sns.cover.a.a
  implements com.tencent.mm.compatible.util.b.a
{
  private com.tencent.mm.plugin.finder.music.a BtN;
  private final kotlin.j GIK;
  private e GIL;
  private final kotlin.j GIM;
  private final kotlin.j GIN;
  private final kotlin.j GIO;
  private final kotlin.j GIP;
  private final kotlin.j GIQ;
  private final com.tencent.mm.compatible.util.c GIR;
  private final a GIS;
  private final kotlin.j Gqu;
  private final String TAG;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(345742);
    this.TAG = "SnsFinder.ImageView";
    this.GIK = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Gqu = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.GIM = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.GIN = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.GIO = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.GIP = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.GIQ = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.GIR = new com.tencent.mm.compatible.util.c(paramContext);
    paramContext = getAvatarView();
    s.s(paramContext, "avatarView");
    TextView localTextView1 = getAuthorNameView();
    s.s(localTextView1, "authorNameView");
    TextView localTextView2 = getFinderDesc();
    s.s(localTextView2, "finderDesc");
    LinearLayout localLinearLayout = getAvatarFl();
    s.s(localLinearLayout, "avatarFl");
    FrameLayout localFrameLayout = getJumpFinderView();
    s.s(localFrameLayout, "jumpFinderView");
    this.GIS = new a(paramContext, localTextView1, localTextView2, localLinearLayout, localFrameLayout);
    this.GIR.lYP = ((com.tencent.mm.compatible.util.b.a)this);
    AppMethodBeat.o(345742);
  }
  
  private final void I(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(345844);
    Object localObject = getBanner().getAdapter();
    if ((localObject instanceof com.tencent.mm.ui.base.a.a)) {}
    for (localObject = (com.tencent.mm.ui.base.a.a)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        FinderItem.a locala = FinderItem.Companion;
        ((com.tencent.mm.ui.base.a.a)localObject).setItems((List)FinderItem.a.e(paramFinderObject, paramFinderObject.objectType).getMediaList());
      }
      AppMethodBeat.o(345844);
      return;
    }
  }
  
  private final void K(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(345816);
    com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda1(this, paramFinderObject));
    AppMethodBeat.o(345816);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.sns.cover.a.b paramb1, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(345907);
    s.u(paramb, "this$0");
    s.u(paramb1, "$coverInfo");
    Log.i(paramb.TAG, "updateFinderObject errType" + paramInt1 + " errCode:" + paramInt2);
    if ((paramObject instanceof FinderObject))
    {
      r localr = al.hgG();
      String str = paramb1.getUserName();
      s.s(str, "coverInfo.userName");
      paramb1 = paramb1.heo();
      s.s(paramb1, "coverInfo.snsObjId");
      localr.a(str, ((Number)paramb1).longValue(), (FinderObject)paramObject);
      if (paramBoolean)
      {
        paramb.K((FinderObject)paramObject);
        AppMethodBeat.o(345907);
      }
    }
    else
    {
      paramObject = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      if ((!com.tencent.mm.plugin.sns.cover.b.a.het()) || (paramInt1 != 4))
      {
        paramObject = com.tencent.mm.plugin.sns.cover.b.a.QkS;
        if (com.tencent.mm.plugin.sns.cover.b.a.het()) {}
      }
      else
      {
        Log.i(paramb.TAG, "updateFinderObject to block");
        paramb = al.hgG();
        paramb1 = paramb1.getUserName();
        s.s(paramb1, "coverInfo.userName");
        paramb.aZN(paramb1);
      }
    }
    AppMethodBeat.o(345907);
  }
  
  private static final void a(b paramb, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(345895);
    s.u(paramb, "this$0");
    s.u(paramFinderObject, "$finderObject");
    paramb.GIS.J(paramFinderObject);
    paramb.setupBannerInfo(paramFinderObject);
    if (paramb.fmo()) {
      paramb.play();
    }
    AppMethodBeat.o(345895);
  }
  
  private final boolean fmm()
  {
    AppMethodBeat.i(345854);
    Object localObject = this.GIL;
    int i;
    if (localObject != null)
    {
      localObject = ((e)localObject).getStatus();
      if ((localObject != null) && (((com.tencent.mm.plugin.sns.cover.a.d)localObject).evb == true))
      {
        i = 1;
        if ((i == 0) && (!com.tencent.mm.n.a.aTj()))
        {
          localObject = this.BtN;
          if (localObject != null) {
            break label78;
          }
        }
      }
    }
    label78:
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.music.a)localObject).context)
    {
      if (!com.tencent.mm.n.a.s((Context)localObject, false)) {
        break label86;
      }
      AppMethodBeat.o(345854);
      return true;
      i = 0;
      break;
    }
    label86:
    AppMethodBeat.o(345854);
    return false;
  }
  
  private final boolean fmn()
  {
    AppMethodBeat.i(345877);
    Object localObject = this.GIL;
    if (localObject != null)
    {
      localObject = ((e)localObject).getStatus();
      if ((localObject != null) && (!((com.tencent.mm.plugin.sns.cover.a.d)localObject).isPreview))
      {
        AppMethodBeat.o(345877);
        return true;
      }
    }
    AppMethodBeat.o(345877);
    return false;
  }
  
  private final boolean fmo()
  {
    AppMethodBeat.i(345886);
    e locale = this.GIL;
    if ((locale != null) && (locale.getStatus().evb) && (fmn()))
    {
      AppMethodBeat.o(345886);
      return false;
    }
    AppMethodBeat.o(345886);
    return true;
  }
  
  private final TextView getAuthorNameView()
  {
    AppMethodBeat.i(345778);
    TextView localTextView = (TextView)this.GIN.getValue();
    AppMethodBeat.o(345778);
    return localTextView;
  }
  
  private final LinearLayout getAvatarFl()
  {
    AppMethodBeat.i(345805);
    LinearLayout localLinearLayout = (LinearLayout)this.GIQ.getValue();
    AppMethodBeat.o(345805);
    return localLinearLayout;
  }
  
  private final ImageView getAvatarView()
  {
    AppMethodBeat.i(345767);
    ImageView localImageView = (ImageView)this.GIM.getValue();
    AppMethodBeat.o(345767);
    return localImageView;
  }
  
  private final SnsFinderImageBanner getBanner()
  {
    AppMethodBeat.i(345751);
    SnsFinderImageBanner localSnsFinderImageBanner = (SnsFinderImageBanner)this.GIK.getValue();
    AppMethodBeat.o(345751);
    return localSnsFinderImageBanner;
  }
  
  private final TextView getFinderDesc()
  {
    AppMethodBeat.i(345785);
    TextView localTextView = (TextView)this.GIO.getValue();
    AppMethodBeat.o(345785);
    return localTextView;
  }
  
  private final FrameLayout getJumpFinderView()
  {
    AppMethodBeat.i(345796);
    FrameLayout localFrameLayout = (FrameLayout)this.GIP.getValue();
    AppMethodBeat.o(345796);
    return localFrameLayout;
  }
  
  private final SnsCoverFadeImageView getThumbView()
  {
    AppMethodBeat.i(345759);
    SnsCoverFadeImageView localSnsCoverFadeImageView = (SnsCoverFadeImageView)this.Gqu.getValue();
    AppMethodBeat.o(345759);
    return localSnsCoverFadeImageView;
  }
  
  private final void pause()
  {
    AppMethodBeat.i(345867);
    Log.i(this.TAG, "pause");
    com.tencent.mm.plugin.finder.music.a locala = this.BtN;
    if (locala != null) {
      locala.pause();
    }
    getBanner().setAutoPlay(false);
    this.GIR.aPS();
    AppMethodBeat.o(345867);
  }
  
  private final void play()
  {
    AppMethodBeat.i(345860);
    Log.i(this.TAG, "play");
    this.GIR.aPT();
    getBanner().setAutoPlay(true);
    if (!fmm())
    {
      com.tencent.mm.plugin.finder.music.a locala = this.BtN;
      if (locala != null) {
        locala.play();
      }
    }
    AppMethodBeat.o(345860);
  }
  
  private final void setupBannerInfo(final FinderObject paramFinderObject)
  {
    AppMethodBeat.i(345832);
    if (this.BtN != null)
    {
      localObject1 = this.BtN;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.music.a)localObject1).release();
      }
      I(paramFinderObject);
    }
    Object localObject1 = FinderItem.Companion;
    localObject1 = FinderItem.a.e(paramFinderObject, paramFinderObject.objectType).getFeedObject().objectDesc;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label152;
      }
      localObject1 = null;
    }
    for (;;)
    {
      this.BtN = ((com.tencent.mm.plugin.finder.music.a)localObject1);
      getBanner().getRecyclerView().setHasFixedSize(false);
      getBanner().setAdapter((RecyclerView.a)new f(this));
      getBanner().setAutoPlay(false);
      com.tencent.mm.ae.d.a((View)this, (kotlin.g.a.a)new h(this, paramFinderObject));
      AppMethodBeat.o(345832);
      return;
      localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bqz)localObject1).musicInfo;
      break;
      label152:
      Object localObject2 = (CharSequence)((bqj)localObject1).ZYp;
      int i;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        label178:
        if (i != 0) {
          break label202;
        }
        i = 1;
        label184:
        if (i == 0) {
          break label207;
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label212;
        }
        localObject1 = null;
        break;
        i = 0;
        break label178;
        label202:
        i = 0;
        break label184;
        label207:
        localObject1 = null;
      }
      label212:
      localObject2 = getContext();
      s.s(localObject2, "context");
      localObject1 = new com.tencent.mm.plugin.finder.music.a((Context)localObject2, (bqj)localObject1);
    }
  }
  
  public final void L(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(346024);
    super.L(paramFinderObject);
    if (paramFinderObject != null)
    {
      setupBannerInfo(paramFinderObject);
      play();
    }
    AppMethodBeat.o(346024);
  }
  
  public final void a(com.tencent.mm.plugin.sns.cover.a.b paramb)
  {
    long l2 = 0L;
    Object localObject1 = null;
    AppMethodBeat.i(345962);
    Object localObject2 = this.TAG;
    Object localObject3;
    int i;
    label136:
    label142:
    boolean bool;
    if (paramb == null)
    {
      Log.i((String)localObject2, s.X("finder obj id:", localObject1));
      if (paramb != null)
      {
        localObject1 = getThumbView();
        s.s(localObject1, "thumbView");
        localObject2 = paramb.getUserName();
        s.s(localObject2, "coverInfo.userName");
        localObject3 = paramb.heo();
        s.s(localObject3, "coverInfo.snsObjId");
        SnsCoverFadeImageView.a((SnsCoverFadeImageView)localObject1, (String)localObject2, ((Number)localObject3).longValue(), paramb.bud());
        getThumbView().setVisibility(0);
        if (paramb == null) {
          break label561;
        }
        localObject1 = paramb.getFinderObject().objectDesc;
        if (localObject1 != null) {
          break label530;
        }
        i = 0;
        if (i <= 0) {
          break label556;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = paramb.getFinderObject();
          s.s(localObject1, "it.finderObject");
          K((FinderObject)localObject1);
        }
        if (i != 0) {
          break label566;
        }
        bool = true;
        label175:
        if (!bool)
        {
          localObject1 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
          localObject1 = paramb.hen();
          s.s(localObject1, "coverInfo.lastFinderCheckTimeMs");
          if (!com.tencent.mm.plugin.sns.cover.b.a.uz(((Number)localObject1).longValue())) {}
        }
        else
        {
          localObject1 = paramb.getFinderObject();
          if (localObject1 != null)
          {
            localObject1 = (FinderObject)((cn)com.tencent.mm.kernel.h.az(cn.class)).tryGetFinderObject(((FinderObject)localObject1).id, ((FinderObject)localObject1).objectNonceId, 123, true, false, new b..ExternalSyntheticLambda0(this, paramb, bool));
            if (localObject1 != null)
            {
              localObject2 = al.hgG();
              localObject3 = paramb.getUserName();
              s.s(localObject3, "coverInfo.userName");
              Long localLong = paramb.heo();
              s.s(localLong, "coverInfo.snsObjId");
              ((r)localObject2).a((String)localObject3, ((Number)localLong).longValue(), (FinderObject)localObject1);
              if (bool) {
                K((FinderObject)localObject1);
              }
            }
          }
        }
        localObject1 = new JSONObject();
        localObject2 = paramb.heo();
        s.s(localObject2, "coverInfo.snsObjId");
        ((JSONObject)localObject1).put("snsid", ((Number)localObject2).longValue());
        ((JSONObject)localObject1).put("url", paramb.gUr());
        localObject2 = paramb.getFinderObject();
        if (localObject2 != null) {
          break label572;
        }
        l1 = 0L;
        label415:
        ((JSONObject)localObject1).put("finderid", t.uA(l1));
        localObject2 = this.GIL;
        if (localObject2 != null)
        {
          localObject2 = ((e)localObject2).getSnsCoverReporter();
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.sns.cover.a.c)localObject2).aXa(((JSONObject)localObject1).toString());
          }
        }
        localObject1 = com.tencent.mm.plugin.sns.statistics.j.QFS.QGN;
        paramb = paramb.getFinderObject();
        if (paramb != null) {
          break label581;
        }
      }
    }
    label530:
    label556:
    label561:
    label566:
    label572:
    label581:
    for (long l1 = l2;; l1 = paramb.id)
    {
      ((no)localObject1).vJ(com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1));
      AppMethodBeat.o(345962);
      return;
      localObject3 = paramb.getFinderObject();
      if (localObject3 == null) {
        break;
      }
      localObject1 = Long.valueOf(((FinderObject)localObject3).id);
      break;
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        i = 0;
        break label136;
      }
      i = ((LinkedList)localObject1).size();
      break label136;
      i = 0;
      break label142;
      i = 0;
      break label142;
      bool = false;
      break label175;
      l1 = ((FinderObject)localObject2).id;
      break label415;
    }
  }
  
  public final void etL()
  {
    AppMethodBeat.i(345978);
    Log.i(this.TAG, "[onPreOpen]");
    this.GIS.show();
    AppMethodBeat.o(345978);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(345972);
    Log.i(this.TAG, "[onPreClose]");
    this.GIS.hide();
    AppMethodBeat.o(345972);
  }
  
  public final void etO()
  {
    AppMethodBeat.i(345984);
    Log.i(this.TAG, "[onPostOpen]");
    play();
    AppMethodBeat.o(345984);
  }
  
  public final int getLayoutId()
  {
    return e.f.sns_cover_finder_image_layout;
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final void onChange(int paramInt)
  {
    AppMethodBeat.i(345942);
    Log.i(this.TAG, s.X("focusChange ", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(345942);
      return;
      AppMethodBeat.o(345942);
      return;
      pause();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346007);
    Log.i(this.TAG, "[onDestroy]");
    com.tencent.mm.plugin.finder.music.a locala = this.BtN;
    if (locala != null) {
      locala.release();
    }
    this.GIR.aPS();
    this.GIR.b((com.tencent.mm.compatible.util.b.a)this);
    AppMethodBeat.o(346007);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(346001);
    pause();
    AppMethodBeat.o(346001);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(345988);
    Log.i(this.TAG, "[onPreClose]");
    Object localObject = this.BtN;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.music.a)localObject).pause();
    }
    localObject = this.GIL;
    if (localObject != null)
    {
      localObject = ((e)localObject).getStatus();
      if ((localObject == null) || (((com.tencent.mm.plugin.sns.cover.a.d)localObject).isPreview)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        getBanner().setAutoPlay(false);
      }
      AppMethodBeat.o(345988);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(345996);
    if ((!fmn()) || ((fmn()) && (fmo()))) {
      play();
    }
    AppMethodBeat.o(345996);
  }
  
  public final void setCoverFoldStatusProvider(e parame)
  {
    AppMethodBeat.i(346017);
    s.u(parame, "snsCoverStatusProvider");
    super.setCoverFoldStatusProvider(parame);
    this.GIL = parame;
    getThumbView().setSnsCoverReporter(parame.getSnsCoverReporter());
    AppMethodBeat.o(346017);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<TextView>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/snscover/SnsFinderImageBanner;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<SnsFinderImageBanner>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/snscover/SnsFinderImageBackView$initBanner$1", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "position", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends com.tencent.mm.ui.base.a.a<dji, View>
  {
    f(b paramb) {}
    
    private static final void a(dji paramdji, ImageView paramImageView)
    {
      AppMethodBeat.i(345779);
      Object localObject = p.ExI;
      localObject = p.eCl();
      s.s(paramdji, "item");
      paramdji = new com.tencent.mm.plugin.finder.loader.k(paramdji, v.FKY);
      p localp = p.ExI;
      paramdji = ((com.tencent.mm.loader.d)localObject).a(paramdji, p.a(p.a.ExJ));
      s.s(paramImageView, "imageView");
      paramdji.d(paramImageView);
      AppMethodBeat.o(345779);
    }
    
    private static final void a(dji paramdji, ImageView paramImageView, b paramb)
    {
      AppMethodBeat.i(345790);
      s.u(paramb, "this$0");
      Object localObject = p.ExI;
      localObject = p.eCu();
      s.s(paramdji, "item");
      paramdji = new com.tencent.mm.plugin.finder.loader.k(paramdji, v.FKZ);
      p localp = p.ExI;
      paramdji = ((com.tencent.mm.loader.d)localObject).a(paramdji, p.a(p.a.ExJ));
      s.s(paramImageView, "bgView");
      paramdji.d(paramImageView);
      b.a(paramb).setVisibility(8);
      AppMethodBeat.o(345790);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      AppMethodBeat.i(345835);
      s.u(paramb, "holder");
      super.a(paramb, paramInt);
      dji localdji = (dji)aBc(paramInt);
      ImageView localImageView1 = (ImageView)paramb.caK.findViewById(e.e.raw_img);
      ImageView localImageView2 = (ImageView)paramb.caK.findViewById(e.e.bg_img);
      paramb = new FrameLayout.LayoutParams(paramb.context.getResources().getDisplayMetrics().widthPixels, -2);
      paramb.gravity = 17;
      ah localah = ah.aiuX;
      localImageView1.setLayoutParams((ViewGroup.LayoutParams)paramb);
      localImageView2.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      localImageView1.post(new b.f..ExternalSyntheticLambda0(localdji, localImageView1));
      localImageView2.post(new b.f..ExternalSyntheticLambda1(localdji, localImageView2, this.GIT));
      AppMethodBeat.o(345835);
    }
    
    public final View m(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(345818);
      s.u(paramViewGroup, "parent");
      paramViewGroup = af.mU(paramViewGroup.getContext()).inflate(e.f.sns_cover_finder_image_item, paramViewGroup, false);
      s.s(paramViewGroup, "getInflater(parent.conte…mage_item, parent, false)");
      AppMethodBeat.o(345818);
      return paramViewGroup;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(b paramb, FinderObject paramFinderObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverFadeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<SnsCoverFadeImageView>
  {
    i(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.snscover.b
 * JD-Core Version:    0.7.0.1
 */