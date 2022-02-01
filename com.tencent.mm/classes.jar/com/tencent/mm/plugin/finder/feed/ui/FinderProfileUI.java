package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.b;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.d;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.e;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.report.b.b;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.TouchableLayout;
import d.g.b.y.f;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(32)
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_POST", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_SET_HEADIMG_ALBUM", "MENU_ID_SET_HEADIMG_TAKEPHOTO", "MENU_ID_UNFOLLOW", "REQUEST_CODE_DISTRICT", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "TAG", "", "actionBarAvatarIv", "Landroid/widget/ImageView;", "actionBarBackBtn", "Landroid/view/View;", "actionBarBackIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowBtn", "Landroid/widget/Button;", "actionBarMoreBtn", "actionBarMoreIv", "actionBarNicknameTv", "Landroid/widget/TextView;", "actionBarPhotoBtn", "actionBarPhotoIv", "actionBarRightIconLayout", "Landroid/view/ViewGroup;", "authArrowIv", "authByTv", "authGeneratorTv", "authIcon", "authLayout", "authTv", "avatarIv", "canReportFollow", "", "getCanReportFollow", "()Z", "setCanReportFollow", "(Z)V", "chatSelfFlag", "chatText", "countListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1;", "defaultHeaderBg", "descTv", "editBtn", "editLl", "fansArrowIv", "fansChangeTv", "fansLayout", "fansTv", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "finderSpamActionBarBackBtn", "finderSpamContactTipView", "followBtn", "followBtnTv", "friendFollowLayout", "friendFollowTv", "fromUser", "hasExposeSettingTips", "header", "headerBg", "headerBgLayout", "headerTip", "isFirstResume", "isPauseBecauseByClickAvatar", "isReportFanRedDotExpose", "isReportMsgRedDotExpose", "isSelf", "lastActionBarProgress", "", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "myActionBar", "nickNameContainer", "nickNameTv", "onScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "readFeedId", "", "rlContainer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "userInfoLayout", "userOriginalTag", "userTagLayout", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "changeChatVisibileState", "", "visible", "checkActionBarIconColor", "doClickPostAction", "fillHeaderImgLocal", "path", "fixActionBarStuff", "getCommentScene", "getHeaderBgSize", "getLayoutId", "getReportType", "goBack", "hasSetCoverImg", "hideActionBar", "initActionBarView", "initData", "initHeader", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshProfile", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "updateAvatar", "refreshUserExtInfo", "setFollowed", "contact", "setSelectFromAlbum", "setUnfollow", "firstCgi", "setWaiting", "showActionBarPost", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "resultFileName", "Companion", "UserExtInfo", "plugin-finder_release"})
public final class FinderProfileUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f
{
  private static final HashMap<String, FinderProfileUI.b> spI;
  public static final FinderProfileUI.a spJ;
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean dsB;
  private String dzZ;
  private ImageView fTj;
  private String filePath;
  private TextView gXb;
  private TextView jeW;
  private final int oyw;
  private final int rUN;
  private RefreshLoadMoreLayout scj;
  private FinderProfileUIContract.a sfU;
  private boolean sft;
  private long sgf;
  private View sgg;
  private final int soA;
  private boolean soF;
  private View soG;
  private View soH;
  private ImageView soI;
  private ImageView soJ;
  private TextView soK;
  private ViewGroup soL;
  private ViewGroup soM;
  private TextView soN;
  private TextView soO;
  private View soP;
  private View soQ;
  private View soR;
  private TextView soS;
  private TextView soT;
  private View soU;
  private ViewGroup soV;
  private TextView soW;
  private TextView soX;
  private ImageView soY;
  private TextView soZ;
  private final int soy;
  private final int soz;
  private com.tencent.mm.ui.statusbar.c.a spA;
  private boolean spB;
  private String spC;
  private float spD;
  private final t spE;
  public boolean spF;
  private boolean spG;
  private final d spH;
  private TextView spa;
  private ImageView spb;
  private ImageView spc;
  private View spd;
  private View spe;
  private WeImageView spf;
  private View spg;
  private ViewGroup sph;
  private ImageView spi;
  private TextView spj;
  private View spk;
  private WeImageView spl;
  private View spm;
  private WeImageView spn;
  private Button spo;
  private View spp;
  private View spq;
  private final int spr;
  private final int sps;
  private final int spt;
  private final int spu;
  private final int spv;
  private final int spw;
  private final int spx;
  private final int spy;
  private com.tencent.mm.plugin.finder.api.g spz;
  private String username;
  private FinderProfileUIContract.ProfileViewCallback viewCallback;
  
  static
  {
    AppMethodBeat.i(166213);
    spJ = new FinderProfileUI.a((byte)0);
    spI = new HashMap();
    AppMethodBeat.o(166213);
  }
  
  public FinderProfileUI()
  {
    AppMethodBeat.i(166212);
    this.TAG = "Finder.FinderProfileUI";
    this.sgf = -1L;
    this.dzZ = "";
    this.soy = 10000;
    this.rUN = 10001;
    this.soz = 10002;
    this.soA = 10003;
    this.oyw = 10004;
    this.spr = 10005;
    this.sps = 10006;
    this.spt = 10007;
    this.spu = 10008;
    this.spv = 10009;
    this.spw = 1;
    this.spx = 2;
    this.spy = 3;
    this.spC = "";
    this.spE = new t(this);
    this.spG = true;
    this.spH = new d(this);
    AppMethodBeat.o(166212);
  }
  
  private final void a(final com.tencent.mm.plugin.finder.api.g paramg, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(203306);
    Object localObject1;
    final boolean bool;
    int i;
    if (paramg != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      bool = com.tencent.mm.plugin.finder.utils.p.j(paramg);
      if ((paramg != null) && (this.spF) && (paramBoolean))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.i.syT;
        localObject1 = paramg.getUsername();
        int k = ch.aDd();
        if (!bool) {
          break label408;
        }
        i = 1;
        label62:
        Object localObject2 = this.viewCallback;
        if (localObject2 == null) {
          d.g.b.p.bdF("viewCallback");
        }
        int m = ((FinderProfileUIContract.ProfileViewCallback)localObject2).sfV;
        localObject2 = FinderProfileUIContract.ProfileViewCallback.sgo;
        if (m != FinderProfileUIContract.ProfileViewCallback.cDf()) {
          break label413;
        }
        label99:
        com.tencent.mm.plugin.finder.report.i.c((String)localObject1, 4, k, i, j);
      }
      if (!bool) {
        break label419;
      }
      localObject1 = this.spo;
      if (localObject1 == null) {
        d.g.b.p.bdF("actionBarFollowBtn");
      }
      ((Button)localObject1).setText(2131766986);
      localObject1 = this.soS;
      if (localObject1 == null) {
        d.g.b.p.bdF("followBtnTv");
      }
      ((TextView)localObject1).setText(2131766986);
    }
    for (;;)
    {
      localObject1 = this.spo;
      if (localObject1 == null) {
        d.g.b.p.bdF("actionBarFollowBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131232363);
      localObject1 = this.spo;
      if (localObject1 == null) {
        d.g.b.p.bdF("actionBarFollowBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131099828));
      localObject1 = this.soS;
      if (localObject1 == null) {
        d.g.b.p.bdF("followBtnTv");
      }
      ((TextView)localObject1).setTextColor(getResources().getColor(2131099828));
      localObject1 = this.soU;
      if (localObject1 == null) {
        d.g.b.p.bdF("nickNameContainer");
      }
      ((View)localObject1).post((Runnable)new ab(this, paramg));
      localObject1 = this.soR;
      if (localObject1 == null) {
        d.g.b.p.bdF("followBtn");
      }
      ((View)localObject1).setBackgroundResource(2131232363);
      paramg = (d.g.a.b)new ac(this, paramg, bool);
      localObject1 = this.soR;
      if (localObject1 == null) {
        d.g.b.p.bdF("followBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new a(paramg));
      localObject1 = this.spo;
      if (localObject1 == null) {
        d.g.b.p.bdF("actionBarFollowBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new a(paramg));
      AppMethodBeat.o(203306);
      return;
      bool = false;
      break;
      label408:
      i = 0;
      break label62;
      label413:
      j = 0;
      break label99;
      label419:
      localObject1 = this.spo;
      if (localObject1 == null) {
        d.g.b.p.bdF("actionBarFollowBtn");
      }
      ((Button)localObject1).setText(2131759228);
      localObject1 = this.soS;
      if (localObject1 == null) {
        d.g.b.p.bdF("followBtnTv");
      }
      ((TextView)localObject1).setText(2131759228);
    }
  }
  
  private final void a(final boolean paramBoolean, final bf parambf)
  {
    AppMethodBeat.i(166199);
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.p.bdF("username");
    }
    this.spz = com.tencent.mm.plugin.finder.api.c.a.ahT((String)localObject1);
    Object localObject3 = this.TAG;
    localObject1 = new StringBuilder("refreshProfile, contact null? ");
    boolean bool;
    Object localObject4;
    Object localObject2;
    int i;
    if (this.spz == null)
    {
      bool = true;
      localObject4 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.spz;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).VK();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ae.i((String)localObject3, (String)localObject1);
      localObject2 = this.spz;
      if (localObject2 == null) {
        break label1894;
      }
      if (((com.tencent.mm.plugin.finder.api.g)localObject2).isBlock()) {
        break label1812;
      }
      localObject1 = this.spp;
      if (localObject1 == null) {
        d.g.b.p.bdF("finderSpamContactTipView");
      }
      ((View)localObject1).setVisibility(8);
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject1 = com.tencent.mm.plugin.finder.loader.i.cEo();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).czm());
        localObject4 = this.spi;
        if (localObject4 == null) {
          d.g.b.p.bdF("actionBarAvatarIv");
        }
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
        localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject1 = com.tencent.mm.plugin.finder.loader.i.cEo();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).czm());
        localObject4 = this.fTj;
        if (localObject4 == null) {
          d.g.b.p.bdF("avatarIv");
        }
        locali = com.tencent.mm.plugin.finder.loader.i.srW;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
      }
      localObject1 = this.fTj;
      if (localObject1 == null) {
        d.g.b.p.bdF("avatarIv");
      }
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new u((com.tencent.mm.plugin.finder.api.g)localObject2, this, paramBoolean, parambf));
      localObject1 = this.jeW;
      if (localObject1 == null) {
        d.g.b.p.bdF("nickNameTv");
      }
      al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = this.spj;
      if (localObject1 == null) {
        d.g.b.p.bdF("actionBarNicknameTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).VK()));
      localObject1 = (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).field_signature;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label619;
      }
      i = 1;
      label430:
      if (i == 0) {
        break label624;
      }
      localObject1 = this.gXb;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((TextView)localObject1).setVisibility(8);
      label458:
      if (parambf == null) {
        break label761;
      }
      i = parambf.pullType;
      label467:
      if (i == 2) {
        break label766;
      }
      bool = true;
      label475:
      localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
      if (!com.tencent.mm.plugin.finder.api.c.a.ahW(((com.tencent.mm.plugin.finder.api.g)localObject2).getUsername())) {
        break label772;
      }
      g((com.tencent.mm.plugin.finder.api.g)localObject2);
    }
    for (;;)
    {
      a(this.dsB, ((com.tencent.mm.plugin.finder.api.g)localObject2).getUsername(), parambf);
      localObject1 = this.soI;
      if (localObject1 == null) {
        d.g.b.p.bdF("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject3 = new y.f();
      ((y.f)localObject3).NiY = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_coverImg;
      if (!this.dsB) {
        break label1221;
      }
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.Jbc, "");
      if (localObject1 != null) {
        break label808;
      }
      parambf = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166199);
      throw parambf;
      bool = false;
      break;
      label619:
      i = 0;
      break label430;
      label624:
      localObject1 = this.gXb;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      localObject3 = (Context)this;
      localObject4 = getContext();
      d.g.b.p.g(localObject4, "context");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)((AppCompatActivity)localObject4).getResources().getString(2131759171, new Object[] { ((com.tencent.mm.plugin.finder.api.g)localObject2).field_signature })));
      localObject1 = this.gXb;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((TextView)localObject1).setVisibility(0);
      localObject1 = this.gXb;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((TextView)localObject1).setOnLongClickListener((View.OnLongClickListener)new v(this, paramBoolean, parambf));
      break label458;
      label761:
      i = 0;
      break label467;
      label766:
      bool = false;
      break label475;
      label772:
      localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
      if (com.tencent.mm.plugin.finder.api.c.a.ahX(((com.tencent.mm.plugin.finder.api.g)localObject2).getUsername())) {
        f((com.tencent.mm.plugin.finder.api.g)localObject2);
      } else {
        a((com.tencent.mm.plugin.finder.api.g)localObject2, bool);
      }
    }
    label808:
    localObject1 = (String)localObject1;
    if (!bu.isNullOrNil((String)localObject1))
    {
      ((y.f)localObject3).NiY = localObject1;
      ae.i(this.TAG, "use localCoverImg " + (String)((y.f)localObject3).NiY);
    }
    if (!bu.isNullOrNil((String)((y.f)localObject3).NiY))
    {
      localObject1 = (String)((y.f)localObject3).NiY;
      d.g.b.p.g(localObject1, "path");
      localObject4 = r.sYn;
      if (d.n.n.nF((String)localObject1, r.cOq()))
      {
        localObject1 = this.soI;
        if (localObject1 == null) {
          d.g.b.p.bdF("defaultHeaderBg");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = (String)((y.f)localObject3).NiY;
        d.g.b.p.g(localObject1, "path");
        aiq((String)localObject1);
      }
    }
    else
    {
      label957:
      localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo;
      localObject3 = this.spa;
      if (localObject3 == null) {
        d.g.b.p.bdF("authGeneratorTv");
      }
      ((TextView)localObject3).setVisibility(8);
      if (localObject1 == null) {
        break label1788;
      }
      if (((FinderAuthInfo)localObject1).authIconType <= 0) {
        break label1764;
      }
      localObject3 = this.spa;
      if (localObject3 == null) {
        d.g.b.p.bdF("authGeneratorTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new x((com.tencent.mm.plugin.finder.api.g)localObject2, this, paramBoolean, parambf));
      localObject3 = this.soZ;
      if (localObject3 == null) {
        d.g.b.p.bdF("authByTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new y((com.tencent.mm.plugin.finder.api.g)localObject2, this, paramBoolean, parambf));
      parambf = com.tencent.mm.plugin.finder.utils.p.sXz;
      parambf = this.soY;
      if (parambf == null) {
        d.g.b.p.bdF("authIcon");
      }
      com.tencent.mm.plugin.finder.utils.p.a(parambf, (FinderAuthInfo)localObject1);
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        label1140:
        if ((((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo == null) || ((bu.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo.appName)) && (bu.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo.detailLink))) || (1 == ((FinderAuthInfo)localObject1).authIconType))
        {
          parambf = this.spb;
          if (parambf == null) {
            d.g.b.p.bdF("authArrowIv");
          }
          parambf.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      cEd();
      parambf = d.z.Nhr;
      AppMethodBeat.o(166199);
      return;
      label1221:
      localObject1 = "";
      break;
      localObject1 = this.soI;
      if (localObject1 == null) {
        d.g.b.p.bdF("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = (String)((y.f)localObject3).NiY;
      d.g.b.p.g(localObject1, "path");
      localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
      if (o.fB(((com.tencent.mm.plugin.finder.loader.e)localObject1).getPath()))
      {
        aiq(((com.tencent.mm.plugin.finder.loader.e)localObject1).getPath());
        break label957;
      }
      localObject4 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject1 = com.tencent.mm.plugin.finder.loader.i.cEn().bI(localObject1);
      localObject4 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.i.a(i.a.ssg)).a((com.tencent.mm.loader.f.e)new w((y.f)localObject3, this, paramBoolean, parambf));
      localObject3 = this.soJ;
      if (localObject3 == null) {
        d.g.b.p.bdF("headerBg");
      }
      ((com.tencent.mm.loader.b)localObject1).c((ImageView)localObject3);
      break label957;
      parambf = ((FinderAuthInfo)localObject1).authProfession;
      if (parambf != null)
      {
        localObject3 = this.soZ;
        if (localObject3 == null) {
          d.g.b.p.bdF("authByTv");
        }
        ((TextView)localObject3).setVisibility(0);
        localObject3 = this.soZ;
        if (localObject3 == null) {
          d.g.b.p.bdF("authByTv");
        }
        ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { parambf }));
        parambf = this.soZ;
        if (parambf == null) {
          d.g.b.p.bdF("authByTv");
        }
        parambf.setOnClickListener(null);
        parambf = d.z.Nhr;
      }
      parambf = this.soV;
      if (parambf == null) {
        d.g.b.p.bdF("authLayout");
      }
      parambf.setVisibility(0);
      break label1140;
      parambf = this.spa;
      if (parambf == null) {
        d.g.b.p.bdF("authGeneratorTv");
      }
      parambf.setVisibility(8);
      parambf = this.soV;
      if (parambf == null) {
        d.g.b.p.bdF("authLayout");
      }
      parambf.setVisibility(0);
      parambf = ((FinderAuthInfo)localObject1).authProfession;
      if (parambf == null) {
        break label1140;
      }
      localObject3 = this.soZ;
      if (localObject3 == null) {
        d.g.b.p.bdF("authByTv");
      }
      ((TextView)localObject3).setVisibility(0);
      localObject3 = this.soZ;
      if (localObject3 == null) {
        d.g.b.p.bdF("authByTv");
      }
      ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { parambf }));
      parambf = d.z.Nhr;
      break label1140;
      parambf = this.soV;
      if (parambf == null) {
        d.g.b.p.bdF("authLayout");
      }
      parambf.setVisibility(0);
      parambf = this.spa;
      if (parambf == null) {
        d.g.b.p.bdF("authGeneratorTv");
      }
      parambf.setVisibility(8);
      parambf = this.spb;
      if (parambf == null) {
        d.g.b.p.bdF("authArrowIv");
      }
      parambf.setVisibility(8);
      parambf = this.soZ;
      if (parambf == null) {
        d.g.b.p.bdF("authByTv");
      }
      parambf.setOnClickListener(null);
      parambf = this.soZ;
      if (parambf == null) {
        d.g.b.p.bdF("authByTv");
      }
      parambf.setText(2131759236);
      break label1140;
      parambf = this.spb;
      if (parambf == null) {
        d.g.b.p.bdF("authArrowIv");
      }
      parambf.setVisibility(0);
      continue;
      label1764:
      parambf = this.soV;
      if (parambf == null) {
        d.g.b.p.bdF("authLayout");
      }
      parambf.setVisibility(8);
      continue;
      label1788:
      parambf = this.soV;
      if (parambf == null) {
        d.g.b.p.bdF("authLayout");
      }
      parambf.setVisibility(8);
      continue;
      label1812:
      parambf = findViewById(2131305143);
      d.g.b.p.g(parambf, "findViewById<TextView>(R.id.spam_tip_tv)");
      ((TextView)parambf).setText((CharSequence)getString(2131759358));
      if (al.aH((Context)this)) {
        getContentView().setPadding(0, al.aG((Context)this), 0, 0);
      }
      parambf = this.spp;
      if (parambf == null) {
        d.g.b.p.bdF("finderSpamContactTipView");
      }
      parambf.setVisibility(0);
    }
    label1894:
    AppMethodBeat.o(166199);
  }
  
  private final void a(boolean paramBoolean, String paramString, bf parambf)
  {
    AppMethodBeat.i(166197);
    FinderProfileUI.b localb = (FinderProfileUI.b)spI.get(paramString);
    if (localb == null) {
      localb = new FinderProfileUI.b(new LinkedList());
    }
    for (;;)
    {
      d.g.b.p.g(localb, "userExtInfoLocalMap[user…nfo(-1, -1, LinkedList())");
      if (parambf != null)
      {
        localb.fansCount = parambf.fansCount;
        localb.friendFollowCount = parambf.friendFollowCount;
        parambf = parambf.userTags;
        d.g.b.p.h(parambf, "<set-?>");
        localb.userTags = parambf;
        ((Map)spI).put(paramString, localb);
      }
      paramString = new LinkedList((Collection)localb.userTags);
      parambf = this.spz;
      if ((parambf == null) || (parambf.field_originalFlag != 2))
      {
        parambf = this.soW;
        if (parambf == null) {
          d.g.b.p.bdF("userOriginalTag");
        }
        parambf.setVisibility(8);
      }
      if (paramString.isEmpty())
      {
        paramString = this.soX;
        if (paramString == null) {
          d.g.b.p.bdF("userTagLayout");
        }
        paramString.setVisibility(4);
        if ((localb.friendFollowCount <= 0) || (paramBoolean)) {
          break label484;
        }
        paramString = this.soM;
        if (paramString == null) {
          d.g.b.p.bdF("friendFollowLayout");
        }
        paramString.setVisibility(0);
        paramString = this.soO;
        if (paramString == null) {
          d.g.b.p.bdF("friendFollowTv");
        }
        parambf = getContext();
        d.g.b.p.g(parambf, "context");
        paramString.setText((CharSequence)parambf.getResources().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.h.Ge(localb.friendFollowCount) }));
      }
      for (;;)
      {
        if ((localb.fansCount <= 0) || (!paramBoolean)) {
          break label508;
        }
        paramString = this.soL;
        if (paramString == null) {
          d.g.b.p.bdF("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.soN;
        if (paramString == null) {
          d.g.b.p.bdF("fansTv");
        }
        parambf = getContext();
        d.g.b.p.g(parambf, "context");
        paramString.setText((CharSequence)parambf.getResources().getString(2131759206, new Object[] { String.valueOf(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
        parambf = this.soX;
        if (parambf == null) {
          d.g.b.p.bdF("userTagLayout");
        }
        parambf.setVisibility(0);
        parambf = new StringBuilder();
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext()) {
          parambf.append((String)paramString.next()).append(" ");
        }
        paramString = this.soX;
        if (paramString == null) {
          d.g.b.p.bdF("userTagLayout");
        }
        paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)parambf.toString()));
        break;
        label484:
        paramString = this.soM;
        if (paramString == null) {
          d.g.b.p.bdF("friendFollowLayout");
        }
        paramString.setVisibility(8);
      }
      label508:
      paramString = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cIh())
      {
        paramString = this.soL;
        if (paramString == null) {
          d.g.b.p.bdF("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.soN;
        if (paramString == null) {
          d.g.b.p.bdF("fansTv");
        }
        parambf = getContext();
        d.g.b.p.g(parambf, "context");
        paramString.setText((CharSequence)parambf.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.h.Ge(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
      }
      paramString = this.soL;
      if (paramString == null) {
        d.g.b.p.bdF("fansLayout");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(166197);
      return;
    }
  }
  
  private void aiq(String paramString)
  {
    AppMethodBeat.i(166210);
    d.g.b.p.h(paramString, "path");
    Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
    localObject = this.soJ;
    if (localObject == null) {
      d.g.b.p.bdF("headerBg");
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = com.tencent.mm.plugin.finder.storage.b.cHl();
    localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject, paramString, i, com.tencent.mm.plugin.finder.storage.b.cHl());
    AppMethodBeat.o(166210);
  }
  
  private final int cEa()
  {
    AppMethodBeat.i(166194);
    int i = al.fS((Context)getContext()).x;
    AppMethodBeat.o(166194);
    return i;
  }
  
  private final boolean cEb()
  {
    AppMethodBeat.i(166195);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.Jbc, "");
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166195);
      throw ((Throwable)localObject);
    }
    if (bu.isNullOrNil((String)localObject))
    {
      localObject = this.spz;
      if (localObject == null) {
        break label112;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).field_coverImg;
      if (bu.isNullOrNil((String)localObject)) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool = true;; bool = false)
    {
      ae.i(this.TAG, "hasSetCoverImg ".concat(String.valueOf(bool)));
      AppMethodBeat.o(166195);
      return bool;
      localObject = null;
      break;
    }
  }
  
  private final void cEc()
  {
    AppMethodBeat.i(166196);
    if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())
    {
      View localView = this.spm;
      if (localView == null) {
        d.g.b.p.bdF("actionBarPhotoBtn");
      }
      localView.setVisibility(0);
    }
    AppMethodBeat.o(166196);
  }
  
  private final void cEd()
  {
    AppMethodBeat.i(166209);
    if ((cEb()) && (this.spD < 0.5F))
    {
      ae.d(this.TAG, "checkActionBarIconColor White, " + this.spD);
      localWeImageView = this.spf;
      if (localWeImageView == null) {
        d.g.b.p.bdF("actionBarBackIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.spn;
      if (localWeImageView == null) {
        d.g.b.p.bdF("actionBarPhotoIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.spl;
      if (localWeImageView == null) {
        d.g.b.p.bdF("actionBarMoreIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      AppMethodBeat.o(166209);
      return;
    }
    ae.d(this.TAG, "checkActionBarIconColor black_color, " + this.spD);
    WeImageView localWeImageView = this.spf;
    if (localWeImageView == null) {
      d.g.b.p.bdF("actionBarBackIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.spn;
    if (localWeImageView == null) {
      d.g.b.p.bdF("actionBarPhotoIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.spl;
    if (localWeImageView == null) {
      d.g.b.p.bdF("actionBarMoreIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    AppMethodBeat.o(166209);
  }
  
  private final void f(final com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(203305);
    Object localObject1 = this.spo;
    if (localObject1 == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject1).setText(2131766987);
    localObject1 = this.spo;
    if (localObject1 == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject1).setBackgroundResource(2131232364);
    localObject1 = this.spo;
    if (localObject1 == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject1).setTextColor(getResources().getColor(2131099732));
    localObject1 = this.soS;
    if (localObject1 == null) {
      d.g.b.p.bdF("followBtnTv");
    }
    ((TextView)localObject1).setText(2131766987);
    localObject1 = this.soS;
    if (localObject1 == null) {
      d.g.b.p.bdF("followBtnTv");
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(2131099732));
    localObject1 = this.soR;
    if (localObject1 == null) {
      d.g.b.p.bdF("followBtn");
    }
    ((View)localObject1).setBackgroundResource(2131232364);
    localObject1 = (d.g.a.b)new ad(this, paramg);
    Object localObject2 = this.soR;
    if (localObject2 == null) {
      d.g.b.p.bdF("followBtn");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new a((d.g.a.b)localObject1));
    localObject1 = this.spo;
    if (localObject1 == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject1).setOnClickListener(null);
    localObject1 = this.jeW;
    if (localObject1 == null) {
      d.g.b.p.bdF("nickNameTv");
    }
    localObject2 = (Context)this;
    if (paramg != null) {}
    for (paramg = paramg.VK();; paramg = null)
    {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)paramg));
      AppMethodBeat.o(203305);
      return;
    }
  }
  
  private final void g(final com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(203307);
    Object localObject = this.soS;
    if (localObject == null) {
      d.g.b.p.bdF("followBtnTv");
    }
    ((TextView)localObject).setText(2131759384);
    localObject = this.spo;
    if (localObject == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject).setText(2131759384);
    localObject = this.spo;
    if (localObject == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject).setTextColor(getResources().getColor(2131100711));
    localObject = this.spo;
    if (localObject == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject).setBackgroundResource(2131232364);
    localObject = this.soS;
    if (localObject == null) {
      d.g.b.p.bdF("followBtnTv");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131101239));
    localObject = this.soR;
    if (localObject == null) {
      d.g.b.p.bdF("followBtn");
    }
    ((View)localObject).setBackgroundResource(2131232364);
    localObject = this.soU;
    if (localObject == null) {
      d.g.b.p.bdF("nickNameContainer");
    }
    ((View)localObject).post((Runnable)new z(this, paramg));
    paramg = (d.g.a.b)new aa(this, paramg);
    localObject = this.soR;
    if (localObject == null) {
      d.g.b.p.bdF("followBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(paramg));
    localObject = this.spo;
    if (localObject == null) {
      d.g.b.p.bdF("actionBarFollowBtn");
    }
    ((Button)localObject).setOnClickListener((View.OnClickListener)new a(paramg));
    AppMethodBeat.o(203307);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203315);
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
    AppMethodBeat.o(203315);
    return localView1;
  }
  
  public final int cCL()
  {
    int j = 0;
    AppMethodBeat.i(203308);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (d.g.b.p.i(str, com.tencent.mm.model.v.aAK()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(203308);
      return 33;
    }
    AppMethodBeat.o(203308);
    return 32;
  }
  
  public final int cDL()
  {
    return 3;
  }
  
  public final int getLayoutId()
  {
    return 2131494095;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    int j = 1;
    AppMethodBeat.i(166208);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt1 == this.spt)
    {
      ae.d(this.TAG, "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
      localObject1 = getApplicationContext();
      localObject2 = r.sYn;
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.i((Context)localObject1, paramIntent, r.cOq());
      if (this.filePath == null)
      {
        ae.e(this.TAG, "filePath is null.");
        AppMethodBeat.o(166208);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      localObject1 = d.g.b.p.C(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject2 = d.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166208);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      d.g.b.p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject2 = new StringBuilder();
      localObject3 = r.sYn;
      localObject2 = ((StringBuilder)localObject2).append(r.cOq());
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      paramIntent.putExtra("CropImage_OutputPath", (String)localObject1);
      paramIntent.setClassName((Context)this, "com.tencent.mm.ui.tools.CropImageNewUI");
      getContext().startActivityForResult(paramIntent, this.spu);
      AppMethodBeat.o(166208);
      return;
    }
    Object localObject4;
    if (paramInt1 == this.sps)
    {
      ae.d(this.TAG, "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = paramIntent.getData();
      d.g.b.p.g(localObject1, "data.data");
      this.filePath = ((Uri)localObject1).getPath();
      localObject1 = (CharSequence)this.filePath;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0)
        {
          ae.w(this.TAG, "filePath is null.try to getResultPhotoPath.");
          localObject1 = getApplicationContext();
          localObject2 = r.sYn;
          this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.i((Context)localObject1, paramIntent, r.cOq());
        }
        ae.i(this.TAG, "filePath[" + this.filePath + "] " + paramIntent);
        localObject1 = (CharSequence)this.filePath;
        if (localObject1 != null)
        {
          paramInt1 = i;
          if (((CharSequence)localObject1).length() != 0) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 == 0) {
          break;
        }
        ae.e(this.TAG, "filePath is null.");
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = (Activity)this;
      paramInt1 = this.spu;
      localObject2 = this.filePath;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      localObject3 = d.g.b.p.C(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject4 = d.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166208);
        throw paramIntent;
      }
      localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
      d.g.b.p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject3);
      d.g.b.p.g(localObject3, "MD5.getMessageDigest((fi…eMillis()).toByteArray())");
      if (paramIntent != null)
      {
        paramIntent.setClass((Context)localObject1, FinderCropAvatarUI.class);
        paramIntent.putExtra("key_crop_style", 1);
        paramIntent.putExtra("key_crop_source", 2);
        paramIntent.putExtra("key_source_img_path", (String)localObject2);
        paramIntent.putExtra("key_result_file_name", (String)localObject3);
        ((Activity)localObject1).startActivityForResult(paramIntent, paramInt1);
      }
      AppMethodBeat.o(166208);
      return;
    }
    if (paramInt1 == this.spu)
    {
      ae.d(this.TAG, "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      this.filePath = paramIntent.getStringExtra("key_result_img_path");
      if ((this.filePath == null) || (!o.fB(this.filePath)))
      {
        ae.e(this.TAG, "ERROR! filePath=" + this.filePath);
        AppMethodBeat.o(166208);
        return;
      }
      ae.d(this.TAG, "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
      paramIntent = this.spz;
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.Jbc, this.filePath);
        localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
        com.tencent.mm.plugin.finder.api.c.a.b(paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.upload.g.sUx;
        paramIntent = com.tencent.mm.plugin.finder.upload.g.cNo();
        localObject1 = this.filePath;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        localObject2 = this.username;
        if (localObject2 == null) {
          d.g.b.p.bdF("username");
        }
        localObject3 = (com.tencent.mm.loader.g.f)new q(this);
        d.g.b.p.h(localObject1, "path");
        d.g.b.p.h(localObject2, "userName");
        d.g.b.p.h(localObject3, "callback");
        paramIntent.sUr.a((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.j((String)localObject1, (String)localObject2), (com.tencent.mm.loader.g.f)localObject3);
      }
      paramIntent = this.filePath;
      if (paramIntent == null) {
        d.g.b.p.gkB();
      }
      aiq(paramIntent);
      cEd();
      AppMethodBeat.o(166208);
      return;
    }
    if ((paramInt1 == this.spv) && (paramIntent != null))
    {
      localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
      localObject4 = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
      localObject2 = paramIntent.getStringExtra("Country");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = paramIntent.getStringExtra("Contact_Province");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject3 = paramIntent.getStringExtra("Contact_City");
      paramIntent = (Intent)localObject3;
      if (localObject3 == null) {
        paramIntent = "";
      }
      ae.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
      if (!d.g.b.p.i(localObject1, "unshow")) {
        break label1267;
      }
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((com.tencent.mm.kernel.e)localObject1).ajA().getInt(am.a.Jbx, 0);
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.Jbx, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label1223:
    label1267:
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if (localObject4 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo;
        if (localObject3 == null) {
          break label1223;
        }
        ((amj)localObject3).country = ((String)localObject1);
        ((amj)localObject3).eRf = ((String)localObject2);
      }
      for (((amj)localObject3).eRg = paramIntent;; ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.eRg = paramIntent)
      {
        localObject3 = com.tencent.mm.plugin.finder.api.c.rPy;
        com.tencent.mm.plugin.finder.api.c.a.b((com.tencent.mm.plugin.finder.api.g)localObject4);
        ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, null);
        AppMethodBeat.o(166208);
        return;
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo = new amj();
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.eRf = ((String)localObject2);
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(166211);
    finish();
    AppMethodBeat.o(166211);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(166193);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("finder_username");
    d.g.b.p.g(paramBundle, "intent.getStringExtra(Co…leUI.KEY_FINDER_USERNAME)");
    this.username = paramBundle;
    this.sgf = getIntent().getLongExtra("finder_read_feed_id", -1L);
    paramBundle = this.TAG;
    Object localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.p.bdF("username");
    }
    ae.i(paramBundle, "username %s", new Object[] { localObject1 });
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.p.bdF("username");
    }
    if (bu.isNullOrNil(paramBundle)) {
      finish();
    }
    this.sft = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.p.bdF("username");
    }
    boolean bool;
    label213:
    int i;
    if ((paramBundle.equals(com.tencent.mm.model.v.aAK())) && (this.sft))
    {
      bool = true;
      this.dsB = bool;
      if (((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry())
      {
        paramBundle = this.username;
        if (paramBundle == null) {
          d.g.b.p.bdF("username");
        }
        if (!paramBundle.equals(com.tencent.mm.model.v.aAK())) {
          break label2020;
        }
      }
      bool = true;
      this.soF = bool;
      paramBundle = com.tencent.mm.plugin.finder.api.c.rPy;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.p.bdF("username");
      }
      this.spz = com.tencent.mm.plugin.finder.api.c.a.ahT(paramBundle);
      this.dzZ = getIntent().getStringExtra("from_user");
      paramBundle = getWindow();
      d.g.b.p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      d.g.b.p.g(paramBundle, "decorView");
      paramBundle.setSystemUiVisibility(1280);
      com.tencent.mm.ui.b.c((Activity)this, false);
      if (getSupportActionBar() != null)
      {
        paramBundle = getSupportActionBar();
        if (paramBundle == null) {
          d.g.b.p.gkB();
        }
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle = getSupportActionBar();
        if (paramBundle == null) {
          d.g.b.p.gkB();
        }
        paramBundle.hide();
      }
      paramBundle = getLayoutInflater().inflate(2131494100, null);
      d.g.b.p.g(paramBundle, "layoutInflater.inflate(R…_profile_ui_header, null)");
      this.sgg = paramBundle;
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300045);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…profile_header_bg_layout)");
      this.soH = paramBundle;
      paramBundle = this.soH;
      if (paramBundle == null) {
        d.g.b.p.bdF("headerBgLayout");
      }
      paramBundle = paramBundle.getLayoutParams();
      i = cEa();
      paramBundle.height = i;
      paramBundle.width = i;
      localObject1 = this.soH;
      if (localObject1 == null) {
        d.g.b.p.bdF("headerBgLayout");
      }
      ((View)localObject1).setLayoutParams(paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300046);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_header_iv)");
      this.soJ = ((ImageView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300033);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…rofile_default_header_iv)");
      this.soI = ((ImageView)paramBundle);
      if (al.isDarkMode())
      {
        paramBundle = this.soI;
        if (paramBundle == null) {
          d.g.b.p.bdF("defaultHeaderBg");
        }
        paramBundle.setImageResource(2131232366);
      }
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300047);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…er_profile_header_tip_tv)");
      this.soK = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300032);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_avatar_btn)");
      this.fTj = ((ImageView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300039);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…nder_profile_fans_layout)");
      this.soL = ((ViewGroup)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300043);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…ile_friend_follow_layout)");
      this.soM = ((ViewGroup)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300040);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_fans_tv)");
      this.soN = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300044);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…profile_friend_follow_tv)");
      this.soO = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300035);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_btn)");
      this.soP = paramBundle;
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300036);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_ll)");
      this.soQ = paramBundle;
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300041);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_follow_btn)");
      this.soR = paramBundle;
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300042);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…er_profile_follow_btn_tv)");
      this.soS = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300056);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_name_tv)");
      this.jeW = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131308313);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…r_profile_name_container)");
      this.soU = paramBundle;
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300031);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…nder_profile_auth_layout)");
      this.soV = ((ViewGroup)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131308108);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…_profile_send_msg_btn_tv)");
      this.soT = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131307898);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.original_tag_tv)");
      this.soW = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131306249);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.user_tag_layout)");
      this.soX = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300030);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_icon)");
      this.soY = ((ImageView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300028);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_by)");
      this.soZ = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300029);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…r_profile_auth_generator)");
      this.spa = ((TextView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300027);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_auth_arrow)");
      this.spb = ((ImageView)paramBundle);
      paramBundle = getContext();
      d.g.b.p.g(paramBundle, "context");
      i = paramBundle.getResources().getColor(2131099735);
      paramBundle = this.spb;
      if (paramBundle == null) {
        d.g.b.p.bdF("authArrowIv");
      }
      paramBundle.setImageDrawable(ao.k((Context)getContext(), 2131690517, i));
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300037);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_fans_arrow)");
      this.spc = ((ImageView)paramBundle);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = paramBundle.findViewById(2131300034);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_desc_tv)");
      this.gXb = ((TextView)paramBundle);
      paramBundle = this.jeW;
      if (paramBundle == null) {
        d.g.b.p.bdF("nickNameTv");
      }
      paramBundle.setTextSize(1, 17.0F);
      paramBundle = this.soS;
      if (paramBundle == null) {
        d.g.b.p.bdF("followBtnTv");
      }
      al.a((Paint)paramBundle.getPaint(), 0.8F);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBD(), (LifecycleOwner)this, (Observer)new m(this));
      paramBundle = this.soQ;
      if (paramBundle == null) {
        d.g.b.p.bdF("editLl");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new n(this));
      if (this.soF) {
        break label2025;
      }
      i = 1;
      label1568:
      if (i == 0) {
        break label2030;
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJP().value()).intValue() <= 0) {
        break label2030;
      }
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131308194);
      d.g.b.p.g(paramBundle, "header.sendMsgBtn");
      paramBundle.setVisibility(0);
      paramBundle = this.soT;
      if (paramBundle == null) {
        d.g.b.p.bdF("chatText");
      }
      al.a((Paint)paramBundle.getPaint(), 0.8F);
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      ((FrameLayout)paramBundle.findViewById(2131308194)).setOnClickListener((View.OnClickListener)new c(this));
    }
    for (;;)
    {
      if (!this.dsB) {
        break label2072;
      }
      paramBundle = this.soQ;
      if (paramBundle == null) {
        d.g.b.p.bdF("editLl");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.soR;
      if (paramBundle == null) {
        d.g.b.p.bdF("followBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.soL;
      if (paramBundle == null) {
        d.g.b.p.bdF("fansLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.soM;
      if (paramBundle == null) {
        d.g.b.p.bdF("friendFollowLayout");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.spc;
      if (paramBundle == null) {
        d.g.b.p.bdF("fansArrowIv");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.soK;
      if (paramBundle == null) {
        d.g.b.p.bdF("headerTip");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.soJ;
      if (paramBundle == null) {
        d.g.b.p.bdF("headerBg");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new o(this));
      paramBundle = this.soL;
      if (paramBundle == null) {
        d.g.b.p.bdF("fansLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new p(this));
      bool = this.dsB;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.p.bdF("username");
      }
      a(bool, paramBundle, null);
      paramBundle = findViewById(2131305141);
      d.g.b.p.g(paramBundle, "findViewById(R.id.spam_actionbar_back_btn)");
      this.spq = paramBundle;
      paramBundle = findViewById(2131300072);
      d.g.b.p.g(paramBundle, "findViewById(R.id.finder_spam_contact_tip_view)");
      this.spp = paramBundle;
      paramBundle = findViewById(2131303475);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_main_rv)");
      this.soG = paramBundle;
      paramBundle = this.soG;
      if (paramBundle == null) {
        d.g.b.p.bdF("rlContainer");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle != null) {
        break label2391;
      }
      paramBundle = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(166193);
      throw paramBundle;
      bool = false;
      break;
      label2020:
      bool = false;
      break label213;
      label2025:
      i = 0;
      break label1568;
      label2030:
      paramBundle = this.sgg;
      if (paramBundle == null) {
        d.g.b.p.bdF("header");
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131308194);
      d.g.b.p.g(paramBundle, "header.sendMsgBtn");
      paramBundle.setVisibility(8);
    }
    label2072:
    paramBundle = this.soQ;
    if (paramBundle == null) {
      d.g.b.p.bdF("editLl");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.spc;
    if (paramBundle == null) {
      d.g.b.p.bdF("fansArrowIv");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.p.bdF("username");
    }
    if (paramBundle.equals(com.tencent.mm.model.v.aAK()))
    {
      paramBundle = this.soR;
      if (paramBundle == null) {
        d.g.b.p.bdF("followBtn");
      }
      paramBundle.setVisibility(8);
      label2160:
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cIh()) {
        break label2367;
      }
      paramBundle = spI;
      localObject1 = this.username;
      if (localObject1 == null) {
        d.g.b.p.bdF("username");
      }
      paramBundle = (FinderProfileUI.b)paramBundle.get(localObject1);
      if (paramBundle == null) {
        break label2362;
      }
      i = paramBundle.fansCount;
      label2210:
      if (i <= 0) {
        break label2367;
      }
      paramBundle = this.soL;
      if (paramBundle == null) {
        d.g.b.p.bdF("fansLayout");
      }
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = this.soL;
      if (paramBundle == null) {
        d.g.b.p.bdF("fansLayout");
      }
      paramBundle.setBackground(null);
      paramBundle = this.soM;
      if (paramBundle == null) {
        d.g.b.p.bdF("friendFollowLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.soK;
      if (paramBundle == null) {
        d.g.b.p.bdF("headerTip");
      }
      paramBundle.setVisibility(8);
      break;
      if (((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry())
      {
        paramBundle = this.soR;
        if (paramBundle == null) {
          d.g.b.p.bdF("followBtn");
        }
        paramBundle.setVisibility(0);
        break label2160;
      }
      paramBundle = this.soR;
      if (paramBundle == null) {
        d.g.b.p.bdF("followBtn");
      }
      paramBundle.setVisibility(8);
      break label2160;
      label2362:
      i = 0;
      break label2210;
      label2367:
      paramBundle = this.soL;
      if (paramBundle == null) {
        d.g.b.p.bdF("fansLayout");
      }
      paramBundle.setVisibility(8);
    }
    label2391:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = (0 - cEa() / 2);
    localObject1 = this.soG;
    if (localObject1 == null) {
      d.g.b.p.bdF("rlContainer");
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    paramBundle = findViewById(2131304203);
    d.g.b.p.g(paramBundle, "findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    localObject1 = com.tencent.mm.ui.z.jV((Context)getContext()).inflate(2131494590, null);
    d.g.b.p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    paramBundle.getRecyclerView().setVisibility(0);
    paramBundle = this.scj;
    if (paramBundle == null) {
      d.g.b.p.bdF("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(true);
    paramBundle = (MMActivity)this;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.p.bdF("username");
    }
    if (localObject1 == null) {
      d.g.b.p.gkB();
    }
    this.sfU = new FinderProfileUIContract.a(paramBundle, (String)localObject1);
    paramBundle = (MMActivity)this;
    localObject1 = this.sfU;
    if (localObject1 == null) {
      d.g.b.p.bdF("presenter");
    }
    Object localObject2 = this.sgg;
    if (localObject2 == null) {
      d.g.b.p.bdF("header");
    }
    paramBundle = new FinderProfileUIContract.ProfileViewCallback(paramBundle, (FinderProfileUIContract.a)localObject1, (View)localObject2, this.sft);
    paramBundle.sgf = this.sgf;
    this.viewCallback = paramBundle;
    paramBundle = this.viewCallback;
    if (paramBundle == null) {
      d.g.b.p.bdF("viewCallback");
    }
    localObject1 = (RecyclerView.m)this.spE;
    d.g.b.p.h(localObject1, "listener");
    paramBundle.fPN = ((RecyclerView.m)localObject1);
    paramBundle = this.sfU;
    if (paramBundle == null) {
      d.g.b.p.bdF("presenter");
    }
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    paramBundle.a((FinderProfileUIContract.ProfileViewCallback)localObject1);
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    ae.i(((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG, "initView");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).scB.eP((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).fNT);
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).gpr;
    if (paramBundle == null) {
      d.g.b.p.bdF("layoutManager");
    }
    ((RecyclerView)localObject2).setLayoutManager(paramBundle);
    paramBundle = new FinderProfileUIContract.ProfileViewCallback.b((FinderProfileUIContract.ProfileViewCallback)localObject1);
    paramBundle.sgt = ((FinderProfileUIContract.ProfileViewCallback)localObject1).sgf;
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).gpr.setAdapter((RecyclerView.a)paramBundle);
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).scj.setActionCallback((RefreshLoadMoreLayout.a)new FinderProfileUIContract.ProfileViewCallback.d((FinderProfileUIContract.ProfileViewCallback)localObject1));
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).scB.getItemDecoration();
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).gpr.b(paramBundle);
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fPN;
    if (paramBundle != null) {
      ((FinderProfileUIContract.ProfileViewCallback)localObject1).gpr.a(paramBundle);
    }
    paramBundle = FinderReporterUIC.tnG;
    paramBundle = FinderReporterUIC.a.fc((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).fNT);
    if (paramBundle != null)
    {
      paramBundle = FinderReporterUIC.d(paramBundle);
      if (paramBundle != null) {
        paramBundle.s(((FinderProfileUIContract.ProfileViewCallback)localObject1).gpr);
      }
    }
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG;
    Object localObject3 = new StringBuilder("start rxPipeLine, rlLayout.actionCallback hashCode:");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).scj.getActionCallback();
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.hashCode());
      ae.i((String)localObject2, paramBundle);
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new FinderProfileUIContract.ProfileViewCallback.e((FinderProfileUIContract.ProfileViewCallback)localObject1));
      paramBundle = this.viewCallback;
      if (paramBundle == null) {
        d.g.b.p.bdF("viewCallback");
      }
      ((BaseFinderFeedLoader)paramBundle.sfU.cCY()).register(paramBundle.scv);
      paramBundle = findViewById(2131303443);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_actionbar_container)");
      this.spd = paramBundle;
      paramBundle = findViewById(2131296397);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_back_btn)");
      this.spe = paramBundle;
      paramBundle = findViewById(2131296398);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_back_iv)");
      this.spf = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303508);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_user_info_layout)");
      this.spg = paramBundle;
      paramBundle = findViewById(2131303491);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_right_icons_layout)");
      this.sph = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131296395);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_avatar_iv)");
      this.spi = ((ImageView)paramBundle);
      paramBundle = findViewById(2131296407);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_nickname_tv)");
      this.spj = ((TextView)paramBundle);
      paramBundle = findViewById(2131302457);
      d.g.b.p.g(paramBundle, "findViewById(R.id.more_btn)");
      this.spk = paramBundle;
      paramBundle = findViewById(2131302474);
      d.g.b.p.g(paramBundle, "findViewById(R.id.more_iv)");
      this.spl = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131305644);
      d.g.b.p.g(paramBundle, "findViewById(R.id.takephoto_btn)");
      this.spm = paramBundle;
      paramBundle = findViewById(2131305645);
      d.g.b.p.g(paramBundle, "findViewById(R.id.takephoto_iv)");
      this.spn = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303444);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_actionbar_follow_btn)");
      this.spo = ((Button)paramBundle);
      if (com.tencent.mm.ui.statusbar.c.KZw)
      {
        this.spA = ((com.tencent.mm.ui.statusbar.c.a)new h(this));
        com.tencent.mm.ui.statusbar.c.bn((Activity)this).a(this.spA);
        com.tencent.mm.ui.statusbar.d.b(getWindow());
      }
      paramBundle = this.spe;
      if (paramBundle == null) {
        d.g.b.p.bdF("actionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new FinderProfileUI.i(this));
      paramBundle = this.spq;
      if (paramBundle == null) {
        d.g.b.p.bdF("finderSpamActionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new FinderProfileUI.j(this));
      setActionbarColor(getResources().getColor(2131101053));
      paramBundle = this.spg;
      if (paramBundle == null) {
        d.g.b.p.bdF("userInfoLayout");
      }
      paramBundle.setAlpha(0.0F);
      paramBundle = this.spo;
      if (paramBundle == null) {
        d.g.b.p.bdF("actionBarFollowBtn");
      }
      paramBundle.setVisibility(8);
      cEd();
      if (!cEb()) {
        break label4039;
      }
      paramBundle = this.spd;
      if (paramBundle == null) {
        d.g.b.p.bdF("myActionBar");
      }
      paramBundle.setBackgroundColor(getResources().getColor(2131101053));
      paramBundle = this.spd;
      if (paramBundle == null) {
        d.g.b.p.bdF("myActionBar");
      }
      paramBundle.setBackgroundResource(2131233659);
      label3517:
      if (!this.dsB) {
        break label4085;
      }
      cEc();
      paramBundle = this.spk;
      if (paramBundle == null) {
        d.g.b.p.bdF("actionBarMoreBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.spm;
      if (paramBundle == null) {
        d.g.b.p.bdF("actionBarPhotoBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new FinderProfileUI.k(this));
      label3579:
      if (this.dsB)
      {
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(106, (com.tencent.mm.plugin.finder.api.f)this.spH);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.f)this.spH);
      }
      paramBundle = com.tencent.mm.ui.component.a.KEX;
      i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).tnh;
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (this.dsB)
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cIl() != 1)
        {
          paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (com.tencent.mm.plugin.finder.storage.b.cIm())
          {
            paramBundle = com.tencent.mm.ui.component.a.KEX;
            paramBundle = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).tkm;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
              localObject1 = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
                if (localObject1 != null)
                {
                  if (((d.g.b.p.i(paramBundle.jge, ((amj)localObject1).country) ^ true)) || ((d.g.b.p.i(paramBundle.jfW, ((amj)localObject1).eRf) ^ true)) || ((d.g.b.p.i(paramBundle.jfX, ((amj)localObject1).eRg) ^ true)))
                  {
                    localObject1 = com.tencent.mm.kernel.g.ajR();
                    d.g.b.p.g(localObject1, "MMKernel.storage()");
                    ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.JcT, Long.valueOf(1L));
                    localObject1 = com.tencent.mm.ui.component.a.KEX;
                    localObject1 = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).tkm;
                    if (localObject1 != null)
                    {
                      localObject2 = (Context)this;
                      localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
                      localObject3 = ((bap)localObject1).jge;
                      d.g.b.p.g(localObject3, "it.Country");
                      String str1 = ((bap)localObject1).jfW;
                      d.g.b.p.g(str1, "it.Province");
                      String str2 = ((bap)localObject1).jfX;
                      d.g.b.p.g(str2, "it.City");
                      com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131759248, new Object[] { com.tencent.mm.plugin.finder.utils.p.af((String)localObject3, str1, str2) }), "", getString(2131759347), getString(2131755691), true, (DialogInterface.OnClickListener)new r((bap)localObject1, paramBundle, this), (DialogInterface.OnClickListener)new s(paramBundle, this));
                      AppMethodBeat.o(166193);
                      return;
                      paramBundle = null;
                      break;
                      label4039:
                      if (al.isDarkMode())
                      {
                        this.mController.setStatusBarColor(getResources().getColor(2131099816));
                        break label3517;
                      }
                      this.mController.setStatusBarColor(getResources().getColor(2131099668));
                      break label3517;
                      label4085:
                      paramBundle = this.spm;
                      if (paramBundle == null) {
                        d.g.b.p.bdF("actionBarPhotoBtn");
                      }
                      paramBundle.setVisibility(8);
                      paramBundle = this.spk;
                      if (paramBundle == null) {
                        d.g.b.p.bdF("actionBarMoreBtn");
                      }
                      paramBundle.setVisibility(0);
                      paramBundle = this.spk;
                      if (paramBundle == null) {
                        d.g.b.p.bdF("actionBarMoreBtn");
                      }
                      paramBundle.setOnClickListener((View.OnClickListener)new l(this));
                      break label3579;
                      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1278L, 15L, 1L, false);
                      paramBundle = com.tencent.mm.plugin.finder.report.i.syT;
                      localObject1 = this.dzZ;
                      paramBundle = (Bundle)localObject1;
                      if (localObject1 == null) {
                        paramBundle = "";
                      }
                      localObject1 = this.username;
                      if (localObject1 == null) {
                        d.g.b.p.bdF("username");
                      }
                      com.tencent.mm.plugin.finder.report.i.x(i, paramBundle, (String)localObject1);
                      continue;
                    }
                  }
                  AppMethodBeat.o(166193);
                  return;
                }
              }
              AppMethodBeat.o(166193);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(166193);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166206);
    super.onDestroy();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(106, (com.tencent.mm.plugin.finder.api.f)this.spH);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.f)this.spH);
    FinderProfileUIContract.ProfileViewCallback localProfileViewCallback = this.viewCallback;
    if (localProfileViewCallback == null) {
      d.g.b.p.bdF("viewCallback");
    }
    ((BaseFinderFeedLoader)localProfileViewCallback.sfU.cCY()).unregister(localProfileViewCallback.scv);
    localProfileViewCallback.sfU.onDetach();
    AppMethodBeat.o(166206);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166204);
    super.onPause();
    if (this.viewCallback == null) {
      d.g.b.p.bdF("viewCallback");
    }
    AppMethodBeat.o(166204);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166203);
    super.onResume();
    this.spB = false;
    Object localObject1;
    if (this.dsB)
    {
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
        AppMethodBeat.o(166203);
        throw ((Throwable)localObject1);
      }
      ((com.tencent.mm.plugin.finder.extension.a)localObject1).fG(12329, 1);
    }
    com.tencent.mm.kernel.g.ajj().a(3736, (com.tencent.mm.ak.f)this);
    Object localObject2;
    if (this.spG)
    {
      a(true, null);
      this.spG = false;
      if (this.viewCallback == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.g.sUx;
      if (com.tencent.mm.plugin.finder.upload.g.cNp())
      {
        localObject1 = this.viewCallback;
        if (localObject1 == null) {
          d.g.b.p.bdF("viewCallback");
        }
        localObject1 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).gpr;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localObject1 = com.tencent.mm.plugin.finder.upload.g.sUx;
        com.tencent.mm.plugin.finder.upload.g.mj(false);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.b.sxb;
      b.b localb = com.tencent.mm.plugin.finder.report.b.cFg();
      localObject2 = com.tencent.mm.model.v.aAK();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = this.username;
      if (localObject2 == null) {
        d.g.b.p.bdF("username");
      }
      localb.ab((String)localObject1, "", (String)localObject2);
      if (!this.soF)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.b.sxb;
        localObject2 = com.tencent.mm.plugin.finder.report.b.cFg();
        localObject1 = com.tencent.mm.ui.component.a.KEX;
        localObject1 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class);
        if (localObject1 != null)
        {
          localObject1 = ((FinderReporterUIC)localObject1).cQZ();
          label317:
          ((b.b)localObject2).a((arn)localObject1, 3L);
        }
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
        com.tencent.mm.plugin.finder.report.g.G(true, 2);
        AppMethodBeat.o(166203);
      }
    }
    else if (this.dsB)
    {
      localObject1 = this.spz;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_username;
        if (localObject1 != null) {
          break label435;
        }
      }
      localObject1 = "";
    }
    label435:
    for (;;)
    {
      localObject2 = com.tencent.mm.ui.component.a.KEX;
      localObject1 = new bf((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ());
      ((bf)localObject1).rSt = true;
      com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)localObject1);
      break;
      a(true, null);
      break;
      localObject1 = null;
      break label317;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(166207);
    ae.i(this.TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2);
    if (paramn != null)
    {
      if ((paramn.getType() != 3736) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break label281;
      }
      paramString = ((bf)paramn).rr.aEV();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(166207);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(166207);
      return;
    }
    paramString = ((FinderUserPageResponse)paramString).contact;
    if (paramString != null)
    {
      String str1 = ((bf)paramn).rRh;
      Object localObject = this.username;
      if (localObject == null) {
        d.g.b.p.bdF("username");
      }
      if (d.g.b.p.i(str1, localObject))
      {
        str1 = this.username;
        if (str1 == null) {
          d.g.b.p.bdF("username");
        }
        if ((d.g.b.p.i(str1, paramString.username) ^ true))
        {
          str1 = this.TAG;
          localObject = new StringBuilder("update username ");
          String str2 = this.username;
          if (str2 == null) {
            d.g.b.p.bdF("username");
          }
          ae.i(str1, str2 + ' ' + paramString.username);
        }
        str1 = paramString.username;
        paramString = str1;
        if (str1 == null) {
          paramString = "";
        }
        this.username = paramString;
        a(true, (bf)paramn);
      }
    }
    label281:
    AppMethodBeat.o(166207);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(166205);
    super.onStop();
    com.tencent.mm.kernel.g.ajj().b(3736, (com.tencent.mm.ak.f)this);
    this.spC = "";
    AppMethodBeat.o(166205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class aa
    extends d.g.b.q
    implements d.g.a.b<View, d.z>
  {
    aa(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(203303);
      int i = FinderProfileUI.u(this.spK).getWidth();
      Object localObject = this.spK.getContext();
      d.g.b.p.g(localObject, "context");
      i -= ((AppCompatActivity)localObject).getResources().getDimensionPixelOffset(2131165294);
      TextView localTextView = FinderProfileUI.v(this.spK);
      Context localContext = (Context)this.spK.getContext();
      localObject = com.tencent.mm.plugin.finder.convert.a.rUe;
      TextPaint localTextPaint = FinderProfileUI.v(this.spK).getPaint();
      d.g.b.p.g(localTextPaint, "nickNameTv.paint");
      localObject = paramg;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).VK();; localObject = null)
      {
        AppCompatActivity localAppCompatActivity = this.spK.getContext();
        d.g.b.p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)com.tencent.mm.plugin.finder.convert.a.a(localTextPaint, (String)localObject, i, i - localAppCompatActivity.getResources().getDimensionPixelOffset(2131165289))));
        AppMethodBeat.o(203303);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class ac
    extends d.g.b.q
    implements d.g.a.b<View, d.z>
  {
    ac(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class ad
    extends d.g.b.q
    implements d.g.a.b<View, d.z>
  {
    ad(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203296);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$changeChatVisibileState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
      paramView = this.spK.getContext();
      d.g.b.p.g(paramView, "context");
      paramView = (Context)paramView;
      localObject = FinderProfileUI.i(this.spK);
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.plugin.finder.api.g)localObject).field_extFlag;; i = 0)
      {
        if (!com.tencent.mm.plugin.finder.utils.p.Y(paramView, i))
        {
          paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
          paramView = FinderProfileUI.j(this.spK);
          d.g.b.p.g(paramView, "contentView");
          paramView = paramView.getContext();
          d.g.b.p.g(paramView, "contentView.context");
          com.tencent.mm.plugin.finder.utils.a.as(paramView, FinderProfileUI.c(this.spK));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$changeChatVisibileState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203296);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.api.f
  {
    public final void a(ama paramama)
    {
      AppMethodBeat.i(166158);
      d.g.b.p.h(paramama, "cmdItem");
      if (!FinderProfileUI.h(this.spK))
      {
        AppMethodBeat.o(166158);
        return;
      }
      switch (paramama.cmdId)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(166158);
        return;
        FinderProfileUI.a(this.spK);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    e(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(203297);
      d.g.b.p.g(paraml, "it");
      if (paraml.fCR())
      {
        paraml.jM(FinderProfileUI.o(this.spK), 2131755747);
        paraml.jM(FinderProfileUI.p(this.spK), 2131755754);
      }
      AppMethodBeat.o(203297);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.e
  {
    f(FinderProfileUI paramFinderProfileUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(203298);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderProfileUI.o(this.spK)) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 1);
        localIntent.putExtra("key_finder_post_id", this.spL);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
        paramMenuItem = this.spK.getContext();
        d.g.b.p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(203298);
        return;
        if (paramMenuItem.getItemId() == FinderProfileUI.p(this.spK)) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g spM;
    
    static
    {
      AppMethodBeat.i(203300);
      spM = new g();
      AppMethodBeat.o(203300);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(203299);
      com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fs(6);
      AppMethodBeat.o(203299);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "newHeight", "", "onStatusBarHeightChange"})
  static final class h
    implements com.tencent.mm.ui.statusbar.c.a
  {
    h(FinderProfileUI paramFinderProfileUI) {}
    
    public final void ug(int paramInt)
    {
      AppMethodBeat.i(166159);
      ae.i(FinderProfileUI.s(this.spK), "newHeight ".concat(String.valueOf(paramInt)));
      if (paramInt > 0)
      {
        Object localObject = FinderProfileUI.w(this.spK).getLayoutParams();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(166159);
          throw ((Throwable)localObject);
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localObject;
        localLayoutParams.height += paramInt;
        FinderProfileUI.w(this.spK).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderProfileUI.w(this.spK).setPadding(0, paramInt, 0, 0);
        FinderProfileUI.x(this.spK).setPadding(0, paramInt, 0, 0);
      }
      com.tencent.mm.ui.statusbar.c.bn((Activity)this.spK).b(FinderProfileUI.y(this.spK));
      AppMethodBeat.o(166159);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166169);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.spK, 1, false);
      paramView.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166167);
          d.g.b.p.g(paramAnonymousl, "it");
          if (paramAnonymousl.fCR())
          {
            paramAnonymousl.jM(FinderProfileUI.m(this.spN.spK), 2131759322);
            paramAnonymousl.jM(FinderProfileUI.n(this.spN.spK), 2131759313);
          }
          AppMethodBeat.o(166167);
        }
      });
      paramView.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(166168);
          d.g.b.p.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          if (paramAnonymousInt == FinderProfileUI.m(this.spN.spK))
          {
            paramAnonymousMenuItem = FinderProfileUI.i(this.spN.spK);
            if (paramAnonymousMenuItem != null)
            {
              m.a.a(m.sWJ, (MMActivity)this.spN.spK, paramAnonymousMenuItem);
              AppMethodBeat.o(166168);
              return;
            }
            AppMethodBeat.o(166168);
            return;
          }
          if (paramAnonymousInt == FinderProfileUI.n(this.spN.spK))
          {
            paramAnonymousMenuItem = this.spN.spK.getString(2131759199, new Object[] { ad.fom(), FinderProfileUI.c(this.spN.spK) });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousMenuItem);
            com.tencent.mm.br.d.b((Context)this.spN.spK.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(166168);
        }
      });
      paramView.cPF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166169);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<g.a>
  {
    m(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166171);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.eT((Context)this.spK);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().aii("FinderSetting");
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().aij("FinderSetting");
      if ((locali != null) && (localObject != null))
      {
        paramView = com.tencent.mm.plugin.finder.report.h.syO;
        paramView = FinderReporterUIC.tnG;
        paramView = FinderReporterUIC.a.fc((Context)this.spK);
        if (paramView == null) {
          break label222;
        }
      }
      label222:
      for (paramView = paramView.cQZ();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.h.a("3", locali, (ast)localObject, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().aih("FinderSetting");
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().e("ProfileEntrance", new int[] { 1000 });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166171);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166174);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.spam.a.sEK;
      if (com.tencent.mm.plugin.finder.spam.a.ajm("personalInfo"))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166174);
        return;
      }
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.spK, 1, false);
      paramView.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166172);
          d.g.b.p.g(paramAnonymousl, "it");
          if (paramAnonymousl.fCR()) {
            paramAnonymousl.jM(FinderProfileUI.f(this.spO.spK), 2131759314);
          }
          AppMethodBeat.o(166172);
        }
      });
      paramView.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(166173);
          d.g.b.p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == FinderProfileUI.f(this.spO.spK)) {
            FinderProfileUI.g(this.spO.spK);
          }
          AppMethodBeat.o(166173);
        }
      });
      paramView.cPF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166174);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166175);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      com.tencent.mm.plugin.finder.extension.reddot.i locali;
      if (FinderProfileUI.h(this.spK))
      {
        paramView = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramView, "MMKernel.storage()");
        int i = paramView.ajA().getInt(am.a.Jcz, 0);
        if (i > 0)
        {
          paramView = com.tencent.mm.plugin.finder.report.i.syT;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.spK);
          if (paramView == null) {
            break label294;
          }
          paramView = paramView.cQZ();
          com.tencent.mm.plugin.finder.report.i.a("3", 1, 2, 5, 3, i, null, null, 0L, paramView, 0, 0, 3520);
        }
        paramView = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramView, "MMKernel.storage()");
        paramView.ajA().set(am.a.Jcz, Integer.valueOf(0));
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().aii("AuthorProfileFans");
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        locali = ((PluginFinder)paramView).getRedDotManager().aij("AuthorProfileFans");
        if ((locali != null) && (localObject != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.h.syO;
          paramView = FinderReporterUIC.tnG;
          paramView = FinderReporterUIC.a.fc((Context)this.spK);
          if (paramView == null) {
            break label299;
          }
        }
      }
      label294:
      label299:
      for (paramView = paramView.cQZ();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.h.a("3", locali, (ast)localObject, 2, paramView, 0, 0, 96);
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().aih("AuthorProfileFans");
        FinderProfileUI.a(this.spK, FinderFansListUI.class);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166175);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onActivityResult$1$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class q
    implements com.tencent.mm.loader.g.f<com.tencent.mm.plugin.finder.upload.j>
  {
    q(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$2$1$1$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$3"})
  static final class r
    implements DialogInterface.OnClickListener
  {
    r(bap parambap1, bap parambap2, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178300);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.dr(FinderProfileUI.c(jdField_this), 1);
      paramDialogInterface = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
      String str1 = this.spP.jge;
      d.g.b.p.g(str1, "it.Country");
      String str2 = this.spP.jfW;
      d.g.b.p.g(str2, "it.Province");
      String str3 = this.spP.jfX;
      d.g.b.p.g(str3, "it.City");
      paramDialogInterface.a(str1, str2, str3, 0, (com.tencent.mm.plugin.i.a.s)new com.tencent.mm.plugin.i.a.s() {});
      AppMethodBeat.o(178300);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$2$1$1$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$4"})
  static final class s
    implements DialogInterface.OnClickListener
  {
    s(bap parambap, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178301);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.dr(FinderProfileUI.c(jdField_this), 2);
      AppMethodBeat.o(178301);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class t
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166178);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      d.g.b.p.h(paramRecyclerView, "recyclerView");
      float f1 = FinderProfileUI.z(this.spK).getHeight() * 1.0F;
      if (f1 == 0.0F)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
      }
      paramRecyclerView = new int[2];
      FinderProfileUI.z(this.spK).getLocationInWindow(paramRecyclerView);
      float f2;
      if (paramRecyclerView[1] > f1)
      {
        f1 = 0.0F;
        if (f1 >= 0.0F) {
          break label211;
        }
        f2 = 0.0F;
      }
      for (;;)
      {
        ae.d(FinderProfileUI.s(this.spK), "onScrollListener ".concat(String.valueOf(f2)));
        if (f2 != FinderProfileUI.A(this.spK)) {
          break label228;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
        if (paramRecyclerView[1] < 0)
        {
          f1 = 1.0F;
          break;
        }
        f1 = (f1 - paramRecyclerView[1]) / f1;
        break;
        label211:
        f2 = f1;
        if (f1 > 1.0F) {
          f2 = 1.0F;
        }
      }
      label228:
      FinderProfileUI.a(this.spK, f2);
      FinderProfileUI.B(this.spK);
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        this.spK.setActionbarColor(this.spK.getResources().getColor(2131101053));
        if (FinderProfileUI.C(this.spK))
        {
          FinderProfileUI.w(this.spK).setBackgroundColor(this.spK.getResources().getColor(2131101053));
          FinderProfileUI.w(this.spK).setBackgroundResource(2131233659);
          FinderProfileUI.E(this.spK).setAlpha(0.0F);
          FinderProfileUI.F(this.spK).setAlpha(f1);
          FinderProfileUI.G(this.spK).setAlpha(f1);
          if (!FinderProfileUI.h(this.spK)) {
            break label496;
          }
          FinderProfileUI.H(this.spK).setVisibility(8);
          FinderProfileUI.I(this.spK);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
        FinderProfileUI.w(this.spK).setBackgroundResource(0);
        FinderProfileUI.w(this.spK).setBackgroundColor(this.spK.getResources().getColor(2131101053));
        if (al.isDarkMode())
        {
          FinderProfileUI.D(this.spK).setStatusBarColor(this.spK.getResources().getColor(2131099816));
          break;
        }
        FinderProfileUI.D(this.spK).setStatusBarColor(this.spK.getResources().getColor(2131099668));
        break;
        label496:
        FinderProfileUI.J(this.spK).setVisibility(8);
        FinderProfileUI.K(this.spK).setVisibility(8);
        FinderProfileUI.H(this.spK).setVisibility(0);
        continue;
        f1 = (f2 - 0.5F) / 0.5F;
        FinderProfileUI.w(this.spK).setBackgroundResource(0);
        FinderProfileUI.w(this.spK).setBackgroundColor(ao.eW(this.spK.getResources().getColor(2131100705), (int)(255.0F * f1)));
        this.spK.setActionbarColor(ao.eW(this.spK.getResources().getColor(2131100705), (int)(255.0F * f1)));
        FinderProfileUI.E(this.spK).setAlpha(f1);
        FinderProfileUI.F(this.spK).setAlpha(f1);
        FinderProfileUI.G(this.spK).setAlpha(f1);
        FinderProfileUI.H(this.spK).setVisibility(8);
        if (FinderProfileUI.h(this.spK))
        {
          FinderProfileUI.I(this.spK);
        }
        else
        {
          FinderProfileUI.J(this.spK).setVisibility(8);
          if ((!d.g.b.p.i(FinderProfileUI.c(this.spK), com.tencent.mm.model.v.aAK())) && (((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry())) {
            FinderProfileUI.K(this.spK).setVisibility(0);
          } else {
            FinderProfileUI.K(this.spK).setVisibility(8);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(166177);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(166177);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$1"})
  static final class u
    implements View.OnClickListener
  {
    u(com.tencent.mm.plugin.finder.api.g paramg, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, bf parambf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166179);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      FinderProfileUI.q(jdField_this);
      paramView = new Intent();
      paramView.putStringArrayListExtra("key_url_list", new ArrayList((Collection)d.a.j.listOf(this.spS.czm())));
      paramView.putExtra("key_preview_avatar", true);
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.H((Context)jdField_this, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166179);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$2"})
  static final class v
    implements View.OnLongClickListener
  {
    v(FinderProfileUI paramFinderProfileUI, boolean paramBoolean, bf parambf) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(166182);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = new com.tencent.mm.ui.widget.b.a((Context)this.spK.getContext(), paramView);
      paramView.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(166180);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.spV.spK.getContext().getString(2131755701));
          AppMethodBeat.o(166180);
        }
      });
      paramView.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(166181);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = ak.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new d.v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(166181);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(FinderProfileUI.r(this.spV.spK).getText());
          }
          AppMethodBeat.o(166181);
        }
      });
      localObject = TouchableLayout.LOL;
      int i = TouchableLayout.fUD();
      localObject = TouchableLayout.LOL;
      boolean bool = paramView.el(i, TouchableLayout.fUE());
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(166182);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$3"})
  static final class w<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.k, Bitmap>
  {
    w(y.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, bf parambf) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$4"})
  static final class x
    implements View.OnClickListener
  {
    x(com.tencent.mm.plugin.finder.api.g paramg, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, bf parambf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166184);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      paramView = this.spS.field_authInfo;
      Object localObject2;
      if (paramView != null)
      {
        paramView = paramView.authGenerator;
        if (paramView != null)
        {
          localObject2 = paramView.authInfo;
          if (localObject2 != null)
          {
            if ((bu.isNullOrNil(((FinderAuthInfo)localObject2).appName)) || (bu.isNullOrNil(((FinderAuthInfo)localObject2).detailLink))) {
              break label150;
            }
            paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
            Context localContext = (Context)jdField_this;
            localObject1 = ((FinderAuthInfo)localObject2).appName;
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            localObject2 = ((FinderAuthInfo)localObject2).detailLink;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            com.tencent.mm.plugin.finder.utils.a.z(localContext, paramView, (String)localObject1);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166184);
        return;
        label150:
        if (!bu.isNullOrNil(((FinderAuthInfo)localObject2).detailLink))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", ((FinderAuthInfo)localObject2).detailLink);
          com.tencent.mm.br.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$5"})
  static final class y
    implements View.OnClickListener
  {
    y(com.tencent.mm.plugin.finder.api.g paramg, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, bf parambf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166185);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      Object localObject2 = this.spS.field_authInfo;
      if (localObject2 != null)
      {
        if ((bu.isNullOrNil(((FinderAuthInfo)localObject2).appName)) || (bu.isNullOrNil(((FinderAuthInfo)localObject2).detailLink))) {
          break label132;
        }
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        Context localContext = (Context)jdField_this;
        localObject1 = ((FinderAuthInfo)localObject2).appName;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localObject2 = ((FinderAuthInfo)localObject2).detailLink;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.finder.utils.a.z(localContext, paramView, (String)localObject1);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166185);
        return;
        label132:
        if (!bu.isNullOrNil(((FinderAuthInfo)localObject2).detailLink))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", ((FinderAuthInfo)localObject2).detailLink);
          com.tencent.mm.br.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(203302);
      int i = FinderProfileUI.u(this.spK).getWidth();
      Object localObject = this.spK.getContext();
      d.g.b.p.g(localObject, "context");
      i -= ((AppCompatActivity)localObject).getResources().getDimensionPixelOffset(2131165293);
      TextView localTextView = FinderProfileUI.v(this.spK);
      Context localContext = (Context)this.spK.getContext();
      localObject = com.tencent.mm.plugin.finder.convert.a.rUe;
      TextPaint localTextPaint = FinderProfileUI.v(this.spK).getPaint();
      d.g.b.p.g(localTextPaint, "nickNameTv.paint");
      localObject = paramg;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).VK();; localObject = null)
      {
        AppCompatActivity localAppCompatActivity = this.spK.getContext();
        d.g.b.p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)com.tencent.mm.plugin.finder.convert.a.a(localTextPaint, (String)localObject, i, i - localAppCompatActivity.getResources().getDimensionPixelOffset(2131165289))));
        AppMethodBeat.o(203302);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI
 * JD-Core Version:    0.7.0.1
 */