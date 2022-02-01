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
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.be;
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
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.TouchableLayout;
import d.g.b.y.f;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(32)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_POST", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_SET_HEADIMG_ALBUM", "MENU_ID_SET_HEADIMG_TAKEPHOTO", "MENU_ID_UNFOLLOW", "REQUEST_CODE_DISTRICT", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "TAG", "", "actionBarAvatarIv", "Landroid/widget/ImageView;", "actionBarBackBtn", "Landroid/view/View;", "actionBarBackIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowBtn", "Landroid/widget/Button;", "actionBarMoreBtn", "actionBarMoreIv", "actionBarNicknameTv", "Landroid/widget/TextView;", "actionBarPhotoBtn", "actionBarPhotoIv", "actionBarRightIconLayout", "Landroid/view/ViewGroup;", "authArrowIv", "authByTv", "authGeneratorTv", "authIcon", "authLayout", "authTv", "avatarIv", "canReportFollow", "", "getCanReportFollow", "()Z", "setCanReportFollow", "(Z)V", "chatSelfFlag", "chatText", "countListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1;", "defaultHeaderBg", "descTv", "editBtn", "editLl", "fansArrowIv", "fansChangeTv", "fansLayout", "fansTv", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "finderSpamActionBarBackBtn", "finderSpamContactTipView", "followBtn", "followBtnTv", "friendFollowLayout", "friendFollowTv", "fromUser", "header", "headerBg", "headerBgLayout", "headerTip", "isFirstResume", "isPauseBecauseByClickAvatar", "isReportFanRedDotExpose", "isReportMsgRedDotExpose", "isSelf", "lastActionBarProgress", "", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "myActionBar", "nickNameContainer", "nickNameTv", "onScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "readFeedId", "", "rlContainer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "userInfoLayout", "userOriginalTag", "userTagLayout", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "changeChatVisibileState", "", "visible", "checkActionBarIconColor", "continuePost", "fillHeaderImgLocal", "path", "fixActionBarStuff", "getCommentScene", "getHeaderBgSize", "getLayoutId", "getReportType", "goBack", "hasSetCoverImg", "hideActionBar", "initActionBarView", "initData", "initHeader", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshProfile", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "updateAvatar", "refreshUserExtInfo", "setFollowed", "contact", "setSelectFromAlbum", "setUnfollow", "firstCgi", "setWaiting", "showActionBarPost", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "resultFileName", "Companion", "UserExtInfo", "plugin-finder_release"})
public final class FinderProfileUI
  extends MMFinderUI
  implements com.tencent.mm.al.f
{
  private static final HashMap<String, b> sgO;
  public static final a sgP;
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean drv;
  private String dyU;
  private ImageView fRd;
  private String filePath;
  private TextView gUs;
  private TextView jcd;
  private final int orV;
  private final int rMA;
  private RefreshLoadMoreLayout rTF;
  private boolean rWI;
  private FinderProfileUIContract.a rXj;
  private long rXu;
  private View rXv;
  private final int sfF;
  private final int sfG;
  private final int sfH;
  private boolean sfM;
  private View sfN;
  private View sfO;
  private ImageView sfP;
  private ImageView sfQ;
  private TextView sfR;
  private ViewGroup sfS;
  private ViewGroup sfT;
  private TextView sfU;
  private TextView sfV;
  private View sfW;
  private View sfX;
  private View sfY;
  private TextView sfZ;
  private final int sgA;
  private final int sgB;
  private final int sgC;
  private final int sgD;
  private final int sgE;
  private final int sgF;
  private com.tencent.mm.plugin.finder.api.g sgG;
  private com.tencent.mm.ui.statusbar.c.a sgH;
  private boolean sgI;
  private float sgJ;
  private final t sgK;
  public boolean sgL;
  private boolean sgM;
  private final g sgN;
  private TextView sga;
  private View sgb;
  private ViewGroup sgc;
  private TextView sgd;
  private TextView sge;
  private ImageView sgf;
  private TextView sgg;
  private TextView sgh;
  private ImageView sgi;
  private ImageView sgj;
  private View sgk;
  private View sgl;
  private WeImageView sgm;
  private View sgn;
  private ViewGroup sgo;
  private ImageView sgp;
  private TextView sgq;
  private View sgr;
  private WeImageView sgs;
  private View sgt;
  private WeImageView sgu;
  private Button sgv;
  private View sgw;
  private View sgx;
  private final int sgy;
  private final int sgz;
  private String username;
  private FinderProfileUIContract.ProfileViewCallback viewCallback;
  
  static
  {
    AppMethodBeat.i(166213);
    sgP = new a((byte)0);
    sgO = new HashMap();
    AppMethodBeat.o(166213);
  }
  
  public FinderProfileUI()
  {
    AppMethodBeat.i(166212);
    this.TAG = "Finder.FinderProfileUI";
    this.rXu = -1L;
    this.dyU = "";
    this.sfF = 10000;
    this.rMA = 10001;
    this.sfG = 10002;
    this.sfH = 10003;
    this.orV = 10004;
    this.sgy = 10005;
    this.sgz = 10006;
    this.sgA = 10007;
    this.sgB = 10008;
    this.sgC = 10009;
    this.sgD = 1;
    this.sgE = 2;
    this.sgF = 3;
    this.sgK = new t(this);
    this.sgM = true;
    this.sgN = new g(this);
    AppMethodBeat.o(166212);
  }
  
  private final void a(final com.tencent.mm.plugin.finder.api.g paramg, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(202827);
    Object localObject1;
    final boolean bool;
    int i;
    if (paramg != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      bool = com.tencent.mm.plugin.finder.utils.p.j(paramg);
      if ((paramg != null) && (this.sgL) && (paramBoolean))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
        localObject1 = paramg.getUsername();
        int k = cf.aCN();
        if (!bool) {
          break label408;
        }
        i = 1;
        label62:
        Object localObject2 = this.viewCallback;
        if (localObject2 == null) {
          d.g.b.p.bcb("viewCallback");
        }
        int m = ((FinderProfileUIContract.ProfileViewCallback)localObject2).rXk;
        localObject2 = FinderProfileUIContract.ProfileViewCallback.rXD;
        if (m != FinderProfileUIContract.ProfileViewCallback.cBt()) {
          break label413;
        }
        label99:
        com.tencent.mm.plugin.finder.report.h.c((String)localObject1, 4, k, i, j);
      }
      if (!bool) {
        break label419;
      }
      localObject1 = this.sgv;
      if (localObject1 == null) {
        d.g.b.p.bcb("actionBarFollowBtn");
      }
      ((Button)localObject1).setText(2131766986);
      localObject1 = this.sfZ;
      if (localObject1 == null) {
        d.g.b.p.bcb("followBtnTv");
      }
      ((TextView)localObject1).setText(2131766986);
    }
    for (;;)
    {
      localObject1 = this.sgv;
      if (localObject1 == null) {
        d.g.b.p.bcb("actionBarFollowBtn");
      }
      ((Button)localObject1).setBackgroundResource(2131232363);
      localObject1 = this.sgv;
      if (localObject1 == null) {
        d.g.b.p.bcb("actionBarFollowBtn");
      }
      ((Button)localObject1).setTextColor(getResources().getColor(2131099828));
      localObject1 = this.sfZ;
      if (localObject1 == null) {
        d.g.b.p.bcb("followBtnTv");
      }
      ((TextView)localObject1).setTextColor(getResources().getColor(2131099828));
      localObject1 = this.sgb;
      if (localObject1 == null) {
        d.g.b.p.bcb("nickNameContainer");
      }
      ((View)localObject1).post((Runnable)new ab(this, paramg));
      localObject1 = this.sfY;
      if (localObject1 == null) {
        d.g.b.p.bcb("followBtn");
      }
      ((View)localObject1).setBackgroundResource(2131232363);
      paramg = (d.g.a.b)new ac(this, paramg, bool);
      localObject1 = this.sfY;
      if (localObject1 == null) {
        d.g.b.p.bcb("followBtn");
      }
      ((View)localObject1).setOnClickListener((View.OnClickListener)new a(paramg));
      localObject1 = this.sgv;
      if (localObject1 == null) {
        d.g.b.p.bcb("actionBarFollowBtn");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new a(paramg));
      AppMethodBeat.o(202827);
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
      localObject1 = this.sgv;
      if (localObject1 == null) {
        d.g.b.p.bcb("actionBarFollowBtn");
      }
      ((Button)localObject1).setText(2131759228);
      localObject1 = this.sfZ;
      if (localObject1 == null) {
        d.g.b.p.bcb("followBtnTv");
      }
      ((TextView)localObject1).setText(2131759228);
    }
  }
  
  private final void a(final boolean paramBoolean, final be parambe)
  {
    AppMethodBeat.i(166199);
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.p.bcb("username");
    }
    this.sgG = com.tencent.mm.plugin.finder.api.c.a.agW((String)localObject1);
    Object localObject3 = this.TAG;
    localObject1 = new StringBuilder("refreshProfile, contact null? ");
    boolean bool;
    Object localObject4;
    Object localObject2;
    int i;
    if (this.sgG == null)
    {
      bool = true;
      localObject4 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.sgG;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.g)localObject1).VC();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ad.i((String)localObject3, (String)localObject1);
      localObject2 = this.sgG;
      if (localObject2 == null) {
        break label1894;
      }
      if (((com.tencent.mm.plugin.finder.api.g)localObject2).isBlock()) {
        break label1812;
      }
      localObject1 = this.sgw;
      if (localObject1 == null) {
        d.g.b.p.bcb("finderSpamContactTipView");
      }
      ((View)localObject1).setVisibility(8);
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.loader.i.sja;
        localObject1 = com.tencent.mm.plugin.finder.loader.i.cCC();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).cxL());
        localObject4 = this.sgp;
        if (localObject4 == null) {
          d.g.b.p.bcb("actionBarAvatarIv");
        }
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
        localObject1 = com.tencent.mm.plugin.finder.loader.i.sja;
        localObject1 = com.tencent.mm.plugin.finder.loader.i.cCC();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject2).cxL());
        localObject4 = this.fRd;
        if (localObject4 == null) {
          d.g.b.p.bcb("avatarIv");
        }
        locali = com.tencent.mm.plugin.finder.loader.i.sja;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
      }
      localObject1 = this.fRd;
      if (localObject1 == null) {
        d.g.b.p.bcb("avatarIv");
      }
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new u((com.tencent.mm.plugin.finder.api.g)localObject2, this, paramBoolean, parambe));
      localObject1 = this.jcd;
      if (localObject1 == null) {
        d.g.b.p.bcb("nickNameTv");
      }
      al.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = this.sgq;
      if (localObject1 == null) {
        d.g.b.p.bcb("actionBarNicknameTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).VC()));
      localObject1 = (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject2).field_signature;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label619;
      }
      i = 1;
      label430:
      if (i == 0) {
        break label624;
      }
      localObject1 = this.gUs;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((TextView)localObject1).setVisibility(8);
      label458:
      if (parambe == null) {
        break label761;
      }
      i = parambe.pullType;
      label467:
      if (i == 2) {
        break label766;
      }
      bool = true;
      label475:
      localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
      if (!com.tencent.mm.plugin.finder.api.c.a.agZ(((com.tencent.mm.plugin.finder.api.g)localObject2).getUsername())) {
        break label772;
      }
      g((com.tencent.mm.plugin.finder.api.g)localObject2);
    }
    for (;;)
    {
      a(this.drv, ((com.tencent.mm.plugin.finder.api.g)localObject2).getUsername(), parambe);
      localObject1 = this.sfP;
      if (localObject1 == null) {
        d.g.b.p.bcb("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject3 = new y.f();
      ((y.f)localObject3).MLV = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_coverImg;
      if (!this.drv) {
        break label1221;
      }
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(al.a.IGC, "");
      if (localObject1 != null) {
        break label808;
      }
      parambe = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166199);
      throw parambe;
      bool = false;
      break;
      label619:
      i = 0;
      break label430;
      label624:
      localObject1 = this.gUs;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      localObject3 = (Context)this;
      localObject4 = getContext();
      d.g.b.p.g(localObject4, "context");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)((AppCompatActivity)localObject4).getResources().getString(2131759171, new Object[] { ((com.tencent.mm.plugin.finder.api.g)localObject2).field_signature })));
      localObject1 = this.gUs;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((TextView)localObject1).setVisibility(0);
      localObject1 = this.gUs;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((TextView)localObject1).setOnLongClickListener((View.OnLongClickListener)new v(this, paramBoolean, parambe));
      break label458;
      label761:
      i = 0;
      break label467;
      label766:
      bool = false;
      break label475;
      label772:
      localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
      if (com.tencent.mm.plugin.finder.api.c.a.aha(((com.tencent.mm.plugin.finder.api.g)localObject2).getUsername())) {
        f((com.tencent.mm.plugin.finder.api.g)localObject2);
      } else {
        a((com.tencent.mm.plugin.finder.api.g)localObject2, bool);
      }
    }
    label808:
    localObject1 = (String)localObject1;
    if (!bt.isNullOrNil((String)localObject1))
    {
      ((y.f)localObject3).MLV = localObject1;
      ad.i(this.TAG, "use localCoverImg " + (String)((y.f)localObject3).MLV);
    }
    if (!bt.isNullOrNil((String)((y.f)localObject3).MLV))
    {
      localObject1 = (String)((y.f)localObject3).MLV;
      d.g.b.p.g(localObject1, "path");
      localObject4 = r.sNc;
      if (d.n.n.nz((String)localObject1, r.cLI()))
      {
        localObject1 = this.sfP;
        if (localObject1 == null) {
          d.g.b.p.bcb("defaultHeaderBg");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = (String)((y.f)localObject3).MLV;
        d.g.b.p.g(localObject1, "path");
        aht((String)localObject1);
      }
    }
    else
    {
      label957:
      localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo;
      localObject3 = this.sgh;
      if (localObject3 == null) {
        d.g.b.p.bcb("authGeneratorTv");
      }
      ((TextView)localObject3).setVisibility(8);
      if (localObject1 == null) {
        break label1788;
      }
      if (((FinderAuthInfo)localObject1).authIconType <= 0) {
        break label1764;
      }
      localObject3 = this.sgh;
      if (localObject3 == null) {
        d.g.b.p.bcb("authGeneratorTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new x((com.tencent.mm.plugin.finder.api.g)localObject2, this, paramBoolean, parambe));
      localObject3 = this.sgg;
      if (localObject3 == null) {
        d.g.b.p.bcb("authByTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new y((com.tencent.mm.plugin.finder.api.g)localObject2, this, paramBoolean, parambe));
      parambe = com.tencent.mm.plugin.finder.utils.p.sMo;
      parambe = this.sgf;
      if (parambe == null) {
        d.g.b.p.bcb("authIcon");
      }
      com.tencent.mm.plugin.finder.utils.p.a(parambe, (FinderAuthInfo)localObject1);
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        label1140:
        if ((((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo == null) || ((bt.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo.appName)) && (bt.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo.detailLink))) || (1 == ((FinderAuthInfo)localObject1).authIconType))
        {
          parambe = this.sgi;
          if (parambe == null) {
            d.g.b.p.bcb("authArrowIv");
          }
          parambe.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      cCr();
      parambe = d.z.MKo;
      AppMethodBeat.o(166199);
      return;
      label1221:
      localObject1 = "";
      break;
      localObject1 = this.sfP;
      if (localObject1 == null) {
        d.g.b.p.bcb("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = (String)((y.f)localObject3).MLV;
      d.g.b.p.g(localObject1, "path");
      localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
      if (com.tencent.mm.vfs.i.fv(((com.tencent.mm.plugin.finder.loader.e)localObject1).getPath()))
      {
        aht(((com.tencent.mm.plugin.finder.loader.e)localObject1).getPath());
        break label957;
      }
      localObject4 = com.tencent.mm.plugin.finder.loader.i.sja;
      localObject1 = com.tencent.mm.plugin.finder.loader.i.cCB().bI(localObject1);
      localObject4 = com.tencent.mm.plugin.finder.loader.i.sja;
      localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.i.a(i.a.sjj)).a((com.tencent.mm.loader.f.e)new w((y.f)localObject3, this, paramBoolean, parambe));
      localObject3 = this.sfQ;
      if (localObject3 == null) {
        d.g.b.p.bcb("headerBg");
      }
      ((com.tencent.mm.loader.b)localObject1).c((ImageView)localObject3);
      break label957;
      parambe = ((FinderAuthInfo)localObject1).authProfession;
      if (parambe != null)
      {
        localObject3 = this.sgg;
        if (localObject3 == null) {
          d.g.b.p.bcb("authByTv");
        }
        ((TextView)localObject3).setVisibility(0);
        localObject3 = this.sgg;
        if (localObject3 == null) {
          d.g.b.p.bcb("authByTv");
        }
        ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { parambe }));
        parambe = this.sgg;
        if (parambe == null) {
          d.g.b.p.bcb("authByTv");
        }
        parambe.setOnClickListener(null);
        parambe = d.z.MKo;
      }
      parambe = this.sgc;
      if (parambe == null) {
        d.g.b.p.bcb("authLayout");
      }
      parambe.setVisibility(0);
      break label1140;
      parambe = this.sgh;
      if (parambe == null) {
        d.g.b.p.bcb("authGeneratorTv");
      }
      parambe.setVisibility(8);
      parambe = this.sgc;
      if (parambe == null) {
        d.g.b.p.bcb("authLayout");
      }
      parambe.setVisibility(0);
      parambe = ((FinderAuthInfo)localObject1).authProfession;
      if (parambe == null) {
        break label1140;
      }
      localObject3 = this.sgg;
      if (localObject3 == null) {
        d.g.b.p.bcb("authByTv");
      }
      ((TextView)localObject3).setVisibility(0);
      localObject3 = this.sgg;
      if (localObject3 == null) {
        d.g.b.p.bcb("authByTv");
      }
      ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { parambe }));
      parambe = d.z.MKo;
      break label1140;
      parambe = this.sgc;
      if (parambe == null) {
        d.g.b.p.bcb("authLayout");
      }
      parambe.setVisibility(0);
      parambe = this.sgh;
      if (parambe == null) {
        d.g.b.p.bcb("authGeneratorTv");
      }
      parambe.setVisibility(8);
      parambe = this.sgi;
      if (parambe == null) {
        d.g.b.p.bcb("authArrowIv");
      }
      parambe.setVisibility(8);
      parambe = this.sgg;
      if (parambe == null) {
        d.g.b.p.bcb("authByTv");
      }
      parambe.setOnClickListener(null);
      parambe = this.sgg;
      if (parambe == null) {
        d.g.b.p.bcb("authByTv");
      }
      parambe.setText(2131759236);
      break label1140;
      parambe = this.sgi;
      if (parambe == null) {
        d.g.b.p.bcb("authArrowIv");
      }
      parambe.setVisibility(0);
      continue;
      label1764:
      parambe = this.sgc;
      if (parambe == null) {
        d.g.b.p.bcb("authLayout");
      }
      parambe.setVisibility(8);
      continue;
      label1788:
      parambe = this.sgc;
      if (parambe == null) {
        d.g.b.p.bcb("authLayout");
      }
      parambe.setVisibility(8);
      continue;
      label1812:
      parambe = findViewById(2131305143);
      d.g.b.p.g(parambe, "findViewById<TextView>(R.id.spam_tip_tv)");
      ((TextView)parambe).setText((CharSequence)getString(2131759358));
      if (al.aG((Context)this)) {
        getContentView().setPadding(0, al.aF((Context)this), 0, 0);
      }
      parambe = this.sgw;
      if (parambe == null) {
        d.g.b.p.bcb("finderSpamContactTipView");
      }
      parambe.setVisibility(0);
    }
    label1894:
    AppMethodBeat.o(166199);
  }
  
  private final void a(boolean paramBoolean, String paramString, be parambe)
  {
    AppMethodBeat.i(166197);
    b localb = (b)sgO.get(paramString);
    if (localb == null) {
      localb = new b(new LinkedList());
    }
    for (;;)
    {
      d.g.b.p.g(localb, "userExtInfoLocalMap[user…nfo(-1, -1, LinkedList())");
      if (parambe != null)
      {
        localb.fansCount = parambe.fansCount;
        localb.friendFollowCount = parambe.friendFollowCount;
        parambe = parambe.userTags;
        d.g.b.p.h(parambe, "<set-?>");
        localb.userTags = parambe;
        ((Map)sgO).put(paramString, localb);
      }
      paramString = new LinkedList((Collection)localb.userTags);
      parambe = this.sgG;
      if ((parambe == null) || (parambe.field_originalFlag != 2))
      {
        parambe = this.sgd;
        if (parambe == null) {
          d.g.b.p.bcb("userOriginalTag");
        }
        parambe.setVisibility(8);
      }
      if (paramString.isEmpty())
      {
        paramString = this.sge;
        if (paramString == null) {
          d.g.b.p.bcb("userTagLayout");
        }
        paramString.setVisibility(4);
        if ((localb.friendFollowCount <= 0) || (paramBoolean)) {
          break label484;
        }
        paramString = this.sfT;
        if (paramString == null) {
          d.g.b.p.bcb("friendFollowLayout");
        }
        paramString.setVisibility(0);
        paramString = this.sfV;
        if (paramString == null) {
          d.g.b.p.bcb("friendFollowTv");
        }
        parambe = getContext();
        d.g.b.p.g(parambe, "context");
        paramString.setText((CharSequence)parambe.getResources().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.h.FG(localb.friendFollowCount) }));
      }
      for (;;)
      {
        if ((localb.fansCount <= 0) || (!paramBoolean)) {
          break label508;
        }
        paramString = this.sfS;
        if (paramString == null) {
          d.g.b.p.bcb("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.sfU;
        if (paramString == null) {
          d.g.b.p.bcb("fansTv");
        }
        parambe = getContext();
        d.g.b.p.g(parambe, "context");
        paramString.setText((CharSequence)parambe.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.h.FG(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
        parambe = this.sge;
        if (parambe == null) {
          d.g.b.p.bcb("userTagLayout");
        }
        parambe.setVisibility(0);
        parambe = new StringBuilder();
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext()) {
          parambe.append((String)paramString.next()).append(" ");
        }
        paramString = this.sge;
        if (paramString == null) {
          d.g.b.p.bcb("userTagLayout");
        }
        paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)parambe.toString()));
        break;
        label484:
        paramString = this.sfT;
        if (paramString == null) {
          d.g.b.p.bcb("friendFollowLayout");
        }
        paramString.setVisibility(8);
      }
      label508:
      paramString = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cGk())
      {
        paramString = this.sfS;
        if (paramString == null) {
          d.g.b.p.bcb("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.sfU;
        if (paramString == null) {
          d.g.b.p.bcb("fansTv");
        }
        parambe = getContext();
        d.g.b.p.g(parambe, "context");
        paramString.setText((CharSequence)parambe.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.h.FG(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
      }
      paramString = this.sfS;
      if (paramString == null) {
        d.g.b.p.bcb("fansLayout");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(166197);
      return;
    }
  }
  
  private void aht(String paramString)
  {
    AppMethodBeat.i(166210);
    d.g.b.p.h(paramString, "path");
    Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
    localObject = this.sfQ;
    if (localObject == null) {
      d.g.b.p.bcb("headerBg");
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i = com.tencent.mm.plugin.finder.storage.b.cFo();
    localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject, paramString, i, com.tencent.mm.plugin.finder.storage.b.cFo());
    AppMethodBeat.o(166210);
  }
  
  private final int cCo()
  {
    AppMethodBeat.i(166194);
    int i = al.fM((Context)getContext()).x;
    AppMethodBeat.o(166194);
    return i;
  }
  
  private final boolean cCp()
  {
    AppMethodBeat.i(166195);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IGC, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166195);
      throw ((Throwable)localObject);
    }
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = this.sgG;
      if (localObject == null) {
        break label112;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).field_coverImg;
      if (bt.isNullOrNil((String)localObject)) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool = true;; bool = false)
    {
      ad.i(this.TAG, "hasSetCoverImg ".concat(String.valueOf(bool)));
      AppMethodBeat.o(166195);
      return bool;
      localObject = null;
      break;
    }
  }
  
  private final void cCq()
  {
    AppMethodBeat.i(166196);
    if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())
    {
      View localView = this.sgt;
      if (localView == null) {
        d.g.b.p.bcb("actionBarPhotoBtn");
      }
      localView.setVisibility(0);
    }
    AppMethodBeat.o(166196);
  }
  
  private final void cCr()
  {
    AppMethodBeat.i(166209);
    if ((cCp()) && (this.sgJ < 0.5F))
    {
      ad.d(this.TAG, "checkActionBarIconColor White, " + this.sgJ);
      localWeImageView = this.sgm;
      if (localWeImageView == null) {
        d.g.b.p.bcb("actionBarBackIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.sgu;
      if (localWeImageView == null) {
        d.g.b.p.bcb("actionBarPhotoIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.sgs;
      if (localWeImageView == null) {
        d.g.b.p.bcb("actionBarMoreIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      AppMethodBeat.o(166209);
      return;
    }
    ad.d(this.TAG, "checkActionBarIconColor black_color, " + this.sgJ);
    WeImageView localWeImageView = this.sgm;
    if (localWeImageView == null) {
      d.g.b.p.bcb("actionBarBackIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.sgu;
    if (localWeImageView == null) {
      d.g.b.p.bcb("actionBarPhotoIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.sgs;
    if (localWeImageView == null) {
      d.g.b.p.bcb("actionBarMoreIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    AppMethodBeat.o(166209);
  }
  
  private final void f(final com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(202826);
    Object localObject1 = this.sgv;
    if (localObject1 == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject1).setText(2131766987);
    localObject1 = this.sgv;
    if (localObject1 == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject1).setBackgroundResource(2131232364);
    localObject1 = this.sgv;
    if (localObject1 == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject1).setTextColor(getResources().getColor(2131099732));
    localObject1 = this.sfZ;
    if (localObject1 == null) {
      d.g.b.p.bcb("followBtnTv");
    }
    ((TextView)localObject1).setText(2131766987);
    localObject1 = this.sfZ;
    if (localObject1 == null) {
      d.g.b.p.bcb("followBtnTv");
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(2131099732));
    localObject1 = this.sfY;
    if (localObject1 == null) {
      d.g.b.p.bcb("followBtn");
    }
    ((View)localObject1).setBackgroundResource(2131232364);
    localObject1 = (d.g.a.b)new ad(this, paramg);
    Object localObject2 = this.sfY;
    if (localObject2 == null) {
      d.g.b.p.bcb("followBtn");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new a((d.g.a.b)localObject1));
    localObject1 = this.sgv;
    if (localObject1 == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject1).setOnClickListener(null);
    localObject1 = this.jcd;
    if (localObject1 == null) {
      d.g.b.p.bcb("nickNameTv");
    }
    localObject2 = (Context)this;
    if (paramg != null) {}
    for (paramg = paramg.VC();; paramg = null)
    {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject2, (CharSequence)paramg));
      AppMethodBeat.o(202826);
      return;
    }
  }
  
  private final void g(final com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(202828);
    Object localObject = this.sfZ;
    if (localObject == null) {
      d.g.b.p.bcb("followBtnTv");
    }
    ((TextView)localObject).setText(2131759384);
    localObject = this.sgv;
    if (localObject == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject).setText(2131759384);
    localObject = this.sgv;
    if (localObject == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject).setTextColor(getResources().getColor(2131100711));
    localObject = this.sgv;
    if (localObject == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject).setBackgroundResource(2131232364);
    localObject = this.sfZ;
    if (localObject == null) {
      d.g.b.p.bcb("followBtnTv");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131101239));
    localObject = this.sfY;
    if (localObject == null) {
      d.g.b.p.bcb("followBtn");
    }
    ((View)localObject).setBackgroundResource(2131232364);
    localObject = this.sgb;
    if (localObject == null) {
      d.g.b.p.bcb("nickNameContainer");
    }
    ((View)localObject).post((Runnable)new z(this, paramg));
    paramg = (d.g.a.b)new aa(this, paramg);
    localObject = this.sfY;
    if (localObject == null) {
      d.g.b.p.bcb("followBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new a(paramg));
    localObject = this.sgv;
    if (localObject == null) {
      d.g.b.p.bcb("actionBarFollowBtn");
    }
    ((Button)localObject).setOnClickListener((View.OnClickListener)new a(paramg));
    AppMethodBeat.o(202828);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202836);
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
    AppMethodBeat.o(202836);
    return localView1;
  }
  
  public final int cAZ()
  {
    int j = 0;
    AppMethodBeat.i(202829);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (d.g.b.p.i(str, u.aAu()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(202829);
      return 33;
    }
    AppMethodBeat.o(202829);
    return 32;
  }
  
  public final int cBZ()
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
    if (paramInt1 == this.sgA)
    {
      ad.d(this.TAG, "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
      localObject1 = getApplicationContext();
      localObject2 = r.sNc;
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.i((Context)localObject1, paramIntent, r.cLI());
      if (this.filePath == null)
      {
        ad.e(this.TAG, "filePath is null.");
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
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166208);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      d.g.b.p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject2 = new StringBuilder();
      localObject3 = r.sNc;
      localObject2 = ((StringBuilder)localObject2).append(r.cLI());
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      paramIntent.putExtra("CropImage_OutputPath", (String)localObject1);
      paramIntent.setClassName((Context)this, "com.tencent.mm.ui.tools.CropImageNewUI");
      getContext().startActivityForResult(paramIntent, this.sgB);
      AppMethodBeat.o(166208);
      return;
    }
    Object localObject4;
    if (paramInt1 == this.sgz)
    {
      ad.d(this.TAG, "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
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
          ad.w(this.TAG, "filePath is null.try to getResultPhotoPath.");
          localObject1 = getApplicationContext();
          localObject2 = r.sNc;
          this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.i((Context)localObject1, paramIntent, r.cLI());
        }
        ad.i(this.TAG, "filePath[" + this.filePath + "] " + paramIntent);
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
        ad.e(this.TAG, "filePath is null.");
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = (Activity)this;
      paramInt1 = this.sgB;
      localObject2 = this.filePath;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      localObject3 = d.g.b.p.C(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject4 = d.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
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
    if (paramInt1 == this.sgB)
    {
      ad.d(this.TAG, "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      this.filePath = paramIntent.getStringExtra("key_result_img_path");
      if ((this.filePath == null) || (!com.tencent.mm.vfs.i.fv(this.filePath)))
      {
        ad.e(this.TAG, "ERROR! filePath=" + this.filePath);
        AppMethodBeat.o(166208);
        return;
      }
      ad.d(this.TAG, "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
      paramIntent = this.sgG;
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGC, this.filePath);
        localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
        com.tencent.mm.plugin.finder.api.c.a.b(paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.upload.g.sJk;
        paramIntent = com.tencent.mm.plugin.finder.upload.g.cKK();
        localObject1 = this.filePath;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        localObject2 = this.username;
        if (localObject2 == null) {
          d.g.b.p.bcb("username");
        }
        localObject3 = (com.tencent.mm.loader.g.f)new q(this);
        d.g.b.p.h(localObject1, "path");
        d.g.b.p.h(localObject2, "userName");
        d.g.b.p.h(localObject3, "callback");
        paramIntent.sJe.a((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.j((String)localObject1, (String)localObject2), (com.tencent.mm.loader.g.f)localObject3);
      }
      paramIntent = this.filePath;
      if (paramIntent == null) {
        d.g.b.p.gfZ();
      }
      aht(paramIntent);
      cCr();
      AppMethodBeat.o(166208);
      return;
    }
    if ((paramInt1 == this.sgC) && (paramIntent != null))
    {
      localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
      localObject1 = u.aAu();
      d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject4 = com.tencent.mm.plugin.finder.api.c.a.agW((String)localObject1);
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
      ad.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
      if (!d.g.b.p.i(localObject1, "unshow")) {
        break label1279;
      }
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((com.tencent.mm.kernel.e)localObject1).ajl().getInt(al.a.IGW, 0);
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGW, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label1235:
    label1279:
    for (paramInt1 = j;; paramInt1 = 0)
    {
      if (localObject4 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo;
        if (localObject3 == null) {
          break label1235;
        }
        ((alx)localObject3).country = ((String)localObject1);
        ((alx)localObject3).ePu = ((String)localObject2);
      }
      for (((alx)localObject3).ePv = paramIntent;; ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.ePv = paramIntent)
      {
        localObject3 = com.tencent.mm.plugin.finder.api.c.rHn;
        com.tencent.mm.plugin.finder.api.c.a.b((com.tencent.mm.plugin.finder.api.g)localObject4);
        ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, null);
        AppMethodBeat.o(166208);
        return;
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo = new alx();
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.g)localObject4).field_extInfo.ePu = ((String)localObject2);
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
    this.rXu = getIntent().getLongExtra("finder_read_feed_id", -1L);
    paramBundle = this.TAG;
    Object localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.p.bcb("username");
    }
    ad.i(paramBundle, "username %s", new Object[] { localObject1 });
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.p.bcb("username");
    }
    if (bt.isNullOrNil(paramBundle)) {
      finish();
    }
    this.rWI = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.p.bcb("username");
    }
    boolean bool;
    label213:
    int i;
    if ((paramBundle.equals(u.aAu())) && (this.rWI))
    {
      bool = true;
      this.drv = bool;
      if (((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry())
      {
        paramBundle = this.username;
        if (paramBundle == null) {
          d.g.b.p.bcb("username");
        }
        if (!paramBundle.equals(u.aAu())) {
          break label2020;
        }
      }
      bool = true;
      this.sfM = bool;
      paramBundle = com.tencent.mm.plugin.finder.api.c.rHn;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.p.bcb("username");
      }
      this.sgG = com.tencent.mm.plugin.finder.api.c.a.agW(paramBundle);
      this.dyU = getIntent().getStringExtra("from_user");
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
          d.g.b.p.gfZ();
        }
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle = getSupportActionBar();
        if (paramBundle == null) {
          d.g.b.p.gfZ();
        }
        paramBundle.hide();
      }
      paramBundle = getLayoutInflater().inflate(2131494100, null);
      d.g.b.p.g(paramBundle, "layoutInflater.inflate(R…_profile_ui_header, null)");
      this.rXv = paramBundle;
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300045);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…profile_header_bg_layout)");
      this.sfO = paramBundle;
      paramBundle = this.sfO;
      if (paramBundle == null) {
        d.g.b.p.bcb("headerBgLayout");
      }
      paramBundle = paramBundle.getLayoutParams();
      i = cCo();
      paramBundle.height = i;
      paramBundle.width = i;
      localObject1 = this.sfO;
      if (localObject1 == null) {
        d.g.b.p.bcb("headerBgLayout");
      }
      ((View)localObject1).setLayoutParams(paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300046);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_header_iv)");
      this.sfQ = ((ImageView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300033);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…rofile_default_header_iv)");
      this.sfP = ((ImageView)paramBundle);
      if (al.isDarkMode())
      {
        paramBundle = this.sfP;
        if (paramBundle == null) {
          d.g.b.p.bcb("defaultHeaderBg");
        }
        paramBundle.setImageResource(2131232366);
      }
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300047);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…er_profile_header_tip_tv)");
      this.sfR = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300032);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_avatar_btn)");
      this.fRd = ((ImageView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300039);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…nder_profile_fans_layout)");
      this.sfS = ((ViewGroup)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300043);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…ile_friend_follow_layout)");
      this.sfT = ((ViewGroup)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300040);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_fans_tv)");
      this.sfU = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300044);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…profile_friend_follow_tv)");
      this.sfV = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300035);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_btn)");
      this.sfW = paramBundle;
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300036);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_ll)");
      this.sfX = paramBundle;
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300041);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_follow_btn)");
      this.sfY = paramBundle;
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300042);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…er_profile_follow_btn_tv)");
      this.sfZ = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300056);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_name_tv)");
      this.jcd = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131308313);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…r_profile_name_container)");
      this.sgb = paramBundle;
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300031);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…nder_profile_auth_layout)");
      this.sgc = ((ViewGroup)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131308108);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…_profile_send_msg_btn_tv)");
      this.sga = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131307898);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.original_tag_tv)");
      this.sgd = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131306249);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.user_tag_layout)");
      this.sge = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300030);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_icon)");
      this.sgf = ((ImageView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300028);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_by)");
      this.sgg = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300029);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…r_profile_auth_generator)");
      this.sgh = ((TextView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300027);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_auth_arrow)");
      this.sgi = ((ImageView)paramBundle);
      paramBundle = getContext();
      d.g.b.p.g(paramBundle, "context");
      i = paramBundle.getResources().getColor(2131099735);
      paramBundle = this.sgi;
      if (paramBundle == null) {
        d.g.b.p.bcb("authArrowIv");
      }
      paramBundle.setImageDrawable(ao.k((Context)getContext(), 2131690517, i));
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300037);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id…inder_profile_fans_arrow)");
      this.sgj = ((ImageView)paramBundle);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = paramBundle.findViewById(2131300034);
      d.g.b.p.g(paramBundle, "header.findViewById(R.id.finder_profile_desc_tv)");
      this.gUs = ((TextView)paramBundle);
      paramBundle = this.jcd;
      if (paramBundle == null) {
        d.g.b.p.bcb("nickNameTv");
      }
      paramBundle.setTextSize(1, 17.0F);
      paramBundle = this.sfZ;
      if (paramBundle == null) {
        d.g.b.p.bcb("followBtnTv");
      }
      al.a((Paint)paramBundle.getPaint(), 0.8F);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czX(), (LifecycleOwner)this, (Observer)new m(this));
      paramBundle = this.sfX;
      if (paramBundle == null) {
        d.g.b.p.bcb("editLl");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new n(this));
      if (this.sfM) {
        break label2025;
      }
      i = 1;
      label1568:
      if (i == 0) {
        break label2030;
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHS().value()).intValue() <= 0) {
        break label2030;
      }
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131308194);
      d.g.b.p.g(paramBundle, "header.sendMsgBtn");
      paramBundle.setVisibility(0);
      paramBundle = this.sga;
      if (paramBundle == null) {
        d.g.b.p.bcb("chatText");
      }
      al.a((Paint)paramBundle.getPaint(), 0.8F);
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      ((FrameLayout)paramBundle.findViewById(2131308194)).setOnClickListener((View.OnClickListener)new c(this));
    }
    for (;;)
    {
      if (!this.drv) {
        break label2072;
      }
      paramBundle = this.sfX;
      if (paramBundle == null) {
        d.g.b.p.bcb("editLl");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.sfY;
      if (paramBundle == null) {
        d.g.b.p.bcb("followBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.sfS;
      if (paramBundle == null) {
        d.g.b.p.bcb("fansLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.sfT;
      if (paramBundle == null) {
        d.g.b.p.bcb("friendFollowLayout");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.sgj;
      if (paramBundle == null) {
        d.g.b.p.bcb("fansArrowIv");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.sfR;
      if (paramBundle == null) {
        d.g.b.p.bcb("headerTip");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.sfQ;
      if (paramBundle == null) {
        d.g.b.p.bcb("headerBg");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new o(this));
      paramBundle = this.sfS;
      if (paramBundle == null) {
        d.g.b.p.bcb("fansLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new p(this));
      bool = this.drv;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.p.bcb("username");
      }
      a(bool, paramBundle, null);
      paramBundle = findViewById(2131305141);
      d.g.b.p.g(paramBundle, "findViewById(R.id.spam_actionbar_back_btn)");
      this.sgx = paramBundle;
      paramBundle = findViewById(2131300072);
      d.g.b.p.g(paramBundle, "findViewById(R.id.finder_spam_contact_tip_view)");
      this.sgw = paramBundle;
      paramBundle = findViewById(2131303475);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_main_rv)");
      this.sfN = paramBundle;
      paramBundle = this.sfN;
      if (paramBundle == null) {
        d.g.b.p.bcb("rlContainer");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle != null) {
        break label2391;
      }
      paramBundle = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
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
      paramBundle = this.rXv;
      if (paramBundle == null) {
        d.g.b.p.bcb("header");
      }
      paramBundle = (FrameLayout)paramBundle.findViewById(2131308194);
      d.g.b.p.g(paramBundle, "header.sendMsgBtn");
      paramBundle.setVisibility(8);
    }
    label2072:
    paramBundle = this.sfX;
    if (paramBundle == null) {
      d.g.b.p.bcb("editLl");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.sgj;
    if (paramBundle == null) {
      d.g.b.p.bcb("fansArrowIv");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.p.bcb("username");
    }
    if (paramBundle.equals(u.aAu()))
    {
      paramBundle = this.sfY;
      if (paramBundle == null) {
        d.g.b.p.bcb("followBtn");
      }
      paramBundle.setVisibility(8);
      label2160:
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cGk()) {
        break label2367;
      }
      paramBundle = sgO;
      localObject1 = this.username;
      if (localObject1 == null) {
        d.g.b.p.bcb("username");
      }
      paramBundle = (b)paramBundle.get(localObject1);
      if (paramBundle == null) {
        break label2362;
      }
      i = paramBundle.fansCount;
      label2210:
      if (i <= 0) {
        break label2367;
      }
      paramBundle = this.sfS;
      if (paramBundle == null) {
        d.g.b.p.bcb("fansLayout");
      }
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = this.sfS;
      if (paramBundle == null) {
        d.g.b.p.bcb("fansLayout");
      }
      paramBundle.setBackground(null);
      paramBundle = this.sfT;
      if (paramBundle == null) {
        d.g.b.p.bcb("friendFollowLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.sfR;
      if (paramBundle == null) {
        d.g.b.p.bcb("headerTip");
      }
      paramBundle.setVisibility(8);
      break;
      if (((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry())
      {
        paramBundle = this.sfY;
        if (paramBundle == null) {
          d.g.b.p.bcb("followBtn");
        }
        paramBundle.setVisibility(0);
        break label2160;
      }
      paramBundle = this.sfY;
      if (paramBundle == null) {
        d.g.b.p.bcb("followBtn");
      }
      paramBundle.setVisibility(8);
      break label2160;
      label2362:
      i = 0;
      break label2210;
      label2367:
      paramBundle = this.sfS;
      if (paramBundle == null) {
        d.g.b.p.bcb("fansLayout");
      }
      paramBundle.setVisibility(8);
    }
    label2391:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = (0 - cCo() / 2);
    localObject1 = this.sfN;
    if (localObject1 == null) {
      d.g.b.p.bcb("rlContainer");
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    paramBundle = findViewById(2131304203);
    d.g.b.p.g(paramBundle, "findViewById(R.id.rl_layout)");
    this.rTF = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    localObject1 = com.tencent.mm.ui.z.jO((Context)getContext()).inflate(2131494590, null);
    d.g.b.p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    paramBundle.getRecyclerView().setVisibility(0);
    paramBundle = this.rTF;
    if (paramBundle == null) {
      d.g.b.p.bcb("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(true);
    paramBundle = (MMActivity)this;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.p.bcb("username");
    }
    if (localObject1 == null) {
      d.g.b.p.gfZ();
    }
    this.rXj = new FinderProfileUIContract.a(paramBundle, (String)localObject1);
    paramBundle = (MMActivity)this;
    localObject1 = this.rXj;
    if (localObject1 == null) {
      d.g.b.p.bcb("presenter");
    }
    Object localObject2 = this.rXv;
    if (localObject2 == null) {
      d.g.b.p.bcb("header");
    }
    paramBundle = new FinderProfileUIContract.ProfileViewCallback(paramBundle, (FinderProfileUIContract.a)localObject1, (View)localObject2, this.rWI);
    paramBundle.rXu = this.rXu;
    this.viewCallback = paramBundle;
    paramBundle = this.viewCallback;
    if (paramBundle == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject1 = (RecyclerView.m)this.sgK;
    d.g.b.p.h(localObject1, "listener");
    paramBundle.fNG = ((RecyclerView.m)localObject1);
    paramBundle = this.rXj;
    if (paramBundle == null) {
      d.g.b.p.bcb("presenter");
    }
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    paramBundle.a((FinderProfileUIContract.ProfileViewCallback)localObject1);
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    ad.i(((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG, "initView");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rTX.eL((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).fLP);
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).gmV;
    if (paramBundle == null) {
      d.g.b.p.bcb("layoutManager");
    }
    ((RecyclerView)localObject2).setLayoutManager(paramBundle);
    paramBundle = new FinderProfileUIContract.ProfileViewCallback.b((FinderProfileUIContract.ProfileViewCallback)localObject1);
    paramBundle.rXI = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rXu;
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).gmV.setAdapter((RecyclerView.a)paramBundle);
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).rTF.setActionCallback((RefreshLoadMoreLayout.a)new FinderProfileUIContract.ProfileViewCallback.d((FinderProfileUIContract.ProfileViewCallback)localObject1));
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rTX.getItemDecoration();
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).gmV.b(paramBundle);
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fNG;
    if (paramBundle != null) {
      ((FinderProfileUIContract.ProfileViewCallback)localObject1).gmV.a(paramBundle);
    }
    paramBundle = FinderReporterUIC.tcM;
    paramBundle = FinderReporterUIC.a.eY((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).fLP);
    if (paramBundle != null)
    {
      paramBundle = FinderReporterUIC.d(paramBundle);
      if (paramBundle != null) {
        paramBundle.s(((FinderProfileUIContract.ProfileViewCallback)localObject1).gmV);
      }
    }
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG;
    Object localObject3 = new StringBuilder("start rxPipeLine, rlLayout.actionCallback hashCode:");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rTF.getActionCallback();
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.hashCode());
      ad.i((String)localObject2, paramBundle);
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new FinderProfileUIContract.ProfileViewCallback.e((FinderProfileUIContract.ProfileViewCallback)localObject1));
      paramBundle = this.viewCallback;
      if (paramBundle == null) {
        d.g.b.p.bcb("viewCallback");
      }
      ((BaseFinderFeedLoader)paramBundle.rXj.cBm()).register(paramBundle.rTR);
      paramBundle = findViewById(2131303443);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_actionbar_container)");
      this.sgk = paramBundle;
      paramBundle = findViewById(2131296397);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_back_btn)");
      this.sgl = paramBundle;
      paramBundle = findViewById(2131296398);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_back_iv)");
      this.sgm = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303508);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_user_info_layout)");
      this.sgn = paramBundle;
      paramBundle = findViewById(2131303491);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_right_icons_layout)");
      this.sgo = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131296395);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_avatar_iv)");
      this.sgp = ((ImageView)paramBundle);
      paramBundle = findViewById(2131296407);
      d.g.b.p.g(paramBundle, "findViewById(R.id.actionbar_nickname_tv)");
      this.sgq = ((TextView)paramBundle);
      paramBundle = findViewById(2131302457);
      d.g.b.p.g(paramBundle, "findViewById(R.id.more_btn)");
      this.sgr = paramBundle;
      paramBundle = findViewById(2131302474);
      d.g.b.p.g(paramBundle, "findViewById(R.id.more_iv)");
      this.sgs = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131305644);
      d.g.b.p.g(paramBundle, "findViewById(R.id.takephoto_btn)");
      this.sgt = paramBundle;
      paramBundle = findViewById(2131305645);
      d.g.b.p.g(paramBundle, "findViewById(R.id.takephoto_iv)");
      this.sgu = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303444);
      d.g.b.p.g(paramBundle, "findViewById(R.id.profile_actionbar_follow_btn)");
      this.sgv = ((Button)paramBundle);
      if (com.tencent.mm.ui.statusbar.c.KDc)
      {
        this.sgH = ((com.tencent.mm.ui.statusbar.c.a)new h(this));
        com.tencent.mm.ui.statusbar.c.bm((Activity)this).a(this.sgH);
        com.tencent.mm.ui.statusbar.d.b(getWindow());
      }
      paramBundle = this.sgl;
      if (paramBundle == null) {
        d.g.b.p.bcb("actionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      paramBundle = this.sgx;
      if (paramBundle == null) {
        d.g.b.p.bcb("finderSpamActionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      setActionbarColor(getResources().getColor(2131101053));
      paramBundle = this.sgn;
      if (paramBundle == null) {
        d.g.b.p.bcb("userInfoLayout");
      }
      paramBundle.setAlpha(0.0F);
      paramBundle = this.sgv;
      if (paramBundle == null) {
        d.g.b.p.bcb("actionBarFollowBtn");
      }
      paramBundle.setVisibility(8);
      cCr();
      if (!cCp()) {
        break label4051;
      }
      paramBundle = this.sgk;
      if (paramBundle == null) {
        d.g.b.p.bcb("myActionBar");
      }
      paramBundle.setBackgroundColor(getResources().getColor(2131101053));
      paramBundle = this.sgk;
      if (paramBundle == null) {
        d.g.b.p.bcb("myActionBar");
      }
      paramBundle.setBackgroundResource(2131233659);
      label3517:
      if (!this.drv) {
        break label4097;
      }
      cCq();
      paramBundle = this.sgr;
      if (paramBundle == null) {
        d.g.b.p.bcb("actionBarMoreBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.sgt;
      if (paramBundle == null) {
        d.g.b.p.bcb("actionBarPhotoBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new k(this));
      label3579:
      if (this.drv)
      {
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(106, (com.tencent.mm.plugin.finder.api.f)this.sgN);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.f)this.sgN);
      }
      paramBundle = com.tencent.mm.ui.component.a.KiD;
      i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).tcn;
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (this.drv)
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cGo() != 1)
        {
          paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (com.tencent.mm.plugin.finder.storage.b.cGp())
          {
            paramBundle = com.tencent.mm.ui.component.a.KiD;
            paramBundle = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).sYY;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
              localObject1 = u.aAu();
              d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
              localObject1 = com.tencent.mm.plugin.finder.api.c.a.agW((String)localObject1);
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extInfo;
                if (localObject1 != null)
                {
                  if (((d.g.b.p.i(paramBundle.jdl, ((alx)localObject1).country) ^ true)) || ((d.g.b.p.i(paramBundle.jdd, ((alx)localObject1).ePu) ^ true)) || ((d.g.b.p.i(paramBundle.jde, ((alx)localObject1).ePv) ^ true)))
                  {
                    localObject1 = com.tencent.mm.kernel.g.ajC();
                    d.g.b.p.g(localObject1, "MMKernel.storage()");
                    ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IIq, Long.valueOf(1L));
                    localObject1 = com.tencent.mm.ui.component.a.KiD;
                    localObject1 = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).sYY;
                    if (localObject1 != null)
                    {
                      localObject2 = (Context)this;
                      localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
                      localObject3 = ((azz)localObject1).jdl;
                      d.g.b.p.g(localObject3, "it.Country");
                      String str1 = ((azz)localObject1).jdd;
                      d.g.b.p.g(str1, "it.Province");
                      String str2 = ((azz)localObject1).jde;
                      d.g.b.p.g(str2, "it.City");
                      com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131759248, new Object[] { com.tencent.mm.plugin.finder.utils.p.ae((String)localObject3, str1, str2) }), "", getString(2131759347), getString(2131755691), true, (DialogInterface.OnClickListener)new r((azz)localObject1, paramBundle, this), (DialogInterface.OnClickListener)new s(paramBundle, this));
                      AppMethodBeat.o(166193);
                      return;
                      paramBundle = null;
                      break;
                      label4051:
                      if (al.isDarkMode())
                      {
                        this.mController.setStatusBarColor(getResources().getColor(2131099816));
                        break label3517;
                      }
                      this.mController.setStatusBarColor(getResources().getColor(2131099668));
                      break label3517;
                      label4097:
                      paramBundle = this.sgt;
                      if (paramBundle == null) {
                        d.g.b.p.bcb("actionBarPhotoBtn");
                      }
                      paramBundle.setVisibility(8);
                      paramBundle = this.sgr;
                      if (paramBundle == null) {
                        d.g.b.p.bcb("actionBarMoreBtn");
                      }
                      paramBundle.setVisibility(0);
                      paramBundle = this.sgr;
                      if (paramBundle == null) {
                        d.g.b.p.bcb("actionBarMoreBtn");
                      }
                      paramBundle.setOnClickListener((View.OnClickListener)new l(this));
                      break label3579;
                      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1278L, 15L, 1L, false);
                      paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
                      localObject1 = this.dyU;
                      paramBundle = (Bundle)localObject1;
                      if (localObject1 == null) {
                        paramBundle = "";
                      }
                      localObject1 = this.username;
                      if (localObject1 == null) {
                        d.g.b.p.bcb("username");
                      }
                      com.tencent.mm.plugin.finder.report.h.x(i, paramBundle, (String)localObject1);
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
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(106, (com.tencent.mm.plugin.finder.api.f)this.sgN);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.f)this.sgN);
    FinderProfileUIContract.ProfileViewCallback localProfileViewCallback = this.viewCallback;
    if (localProfileViewCallback == null) {
      d.g.b.p.bcb("viewCallback");
    }
    ((BaseFinderFeedLoader)localProfileViewCallback.rXj.cBm()).unregister(localProfileViewCallback.rTR);
    localProfileViewCallback.rXj.onDetach();
    AppMethodBeat.o(166206);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166204);
    super.onPause();
    if (this.viewCallback == null) {
      d.g.b.p.bcb("viewCallback");
    }
    AppMethodBeat.o(166204);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166203);
    super.onResume();
    this.sgI = false;
    Object localObject1;
    if (this.drv)
    {
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
        AppMethodBeat.o(166203);
        throw ((Throwable)localObject1);
      }
      ((com.tencent.mm.plugin.finder.extension.a)localObject1).fI(12329, 1);
    }
    com.tencent.mm.kernel.g.aiU().a(3736, (com.tencent.mm.al.f)this);
    Object localObject2;
    if (this.sgM)
    {
      a(true, null);
      this.sgM = false;
      if (this.viewCallback == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.g.sJk;
      if (com.tencent.mm.plugin.finder.upload.g.cKL())
      {
        localObject1 = this.viewCallback;
        if (localObject1 == null) {
          d.g.b.p.bcb("viewCallback");
        }
        localObject1 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).gmV;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localObject1 = com.tencent.mm.plugin.finder.upload.g.sJk;
        com.tencent.mm.plugin.finder.upload.g.me(false);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.b.snk;
      b.b localb = com.tencent.mm.plugin.finder.report.b.cDo();
      localObject2 = u.aAu();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = this.username;
      if (localObject2 == null) {
        d.g.b.p.bcb("username");
      }
      localb.aa((String)localObject1, "", (String)localObject2);
      if (!this.sfM)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.b.snk;
        localObject2 = com.tencent.mm.plugin.finder.report.b.cDo();
        localObject1 = com.tencent.mm.ui.component.a.KiD;
        localObject1 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class);
        if (localObject1 != null)
        {
          localObject1 = ((FinderReporterUIC)localObject1).cOu();
          label317:
          ((b.b)localObject2).a((aqy)localObject1, 3L);
        }
      }
      else
      {
        AppMethodBeat.o(166203);
      }
    }
    else if (this.drv)
    {
      localObject1 = this.sgG;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_username;
        if (localObject1 != null) {
          break label426;
        }
      }
      localObject1 = "";
    }
    label426:
    for (;;)
    {
      localObject2 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = new be((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
      ((be)localObject1).rKg = true;
      com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)localObject1);
      break;
      a(true, null);
      break;
      localObject1 = null;
      break label317;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(166207);
    ad.i(this.TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2);
    if (paramn != null)
    {
      if ((paramn.getType() != 3736) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break label275;
      }
      paramString = ((be)paramn).rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
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
      String str1 = ((be)paramn).rKh;
      Object localObject = this.username;
      if (localObject == null) {
        d.g.b.p.bcb("username");
      }
      if (d.g.b.p.i(str1, localObject))
      {
        str1 = this.username;
        if (str1 == null) {
          d.g.b.p.bcb("username");
        }
        if ((d.g.b.p.i(str1, paramString.username) ^ true))
        {
          str1 = this.TAG;
          localObject = new StringBuilder("update username ");
          String str2 = this.username;
          if (str2 == null) {
            d.g.b.p.bcb("username");
          }
          ad.i(str1, str2 + ' ' + paramString.username);
        }
        paramString = paramString.username;
        d.g.b.p.g(paramString, "contact.username");
        this.username = paramString;
        a(true, (be)paramn);
      }
    }
    label275:
    AppMethodBeat.o(166207);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(166205);
    super.onStop();
    com.tencent.mm.kernel.g.aiU().b(3736, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(166205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$Companion;", "", "()V", "userExtInfoLocalMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$UserExtInfo;", "Lkotlin/collections/HashMap;", "getUserExtInfoLocalMap", "()Ljava/util/HashMap;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class aa
    extends d.g.b.q
    implements d.g.a.b<View, d.z>
  {
    aa(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(202824);
      int i = FinderProfileUI.t(this.sgQ).getWidth();
      Object localObject = this.sgQ.getContext();
      d.g.b.p.g(localObject, "context");
      i -= ((AppCompatActivity)localObject).getResources().getDimensionPixelOffset(2131165294);
      TextView localTextView = FinderProfileUI.u(this.sgQ);
      Context localContext = (Context)this.sgQ.getContext();
      localObject = com.tencent.mm.plugin.finder.convert.a.rLR;
      TextPaint localTextPaint = FinderProfileUI.u(this.sgQ).getPaint();
      d.g.b.p.g(localTextPaint, "nickNameTv.paint");
      localObject = paramg;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).VC();; localObject = null)
      {
        AppCompatActivity localAppCompatActivity = this.sgQ.getContext();
        d.g.b.p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)com.tencent.mm.plugin.finder.convert.a.a(localTextPaint, (String)localObject, i, i - localAppCompatActivity.getResources().getDimensionPixelOffset(2131165289))));
        AppMethodBeat.o(202824);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class ac
    extends d.g.b.q
    implements d.g.a.b<View, d.z>
  {
    ac(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class ad
    extends d.g.b.q
    implements d.g.a.b<View, d.z>
  {
    ad(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$UserExtInfo;", "", "friendFollowCount", "", "fansCount", "userTags", "Ljava/util/LinkedList;", "", "(IILjava/util/LinkedList;)V", "getFansCount", "()I", "setFansCount", "(I)V", "getFriendFollowCount", "setFriendFollowCount", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    int fansCount;
    int friendFollowCount;
    LinkedList<String> userTags;
    
    public b(LinkedList<String> paramLinkedList)
    {
      AppMethodBeat.i(166154);
      this.friendFollowCount = -1;
      this.fansCount = -1;
      this.userTags = paramLinkedList;
      AppMethodBeat.o(166154);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(166157);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.friendFollowCount != paramObject.friendFollowCount) || (this.fansCount != paramObject.fansCount) || (!d.g.b.p.i(this.userTags, paramObject.userTags))) {}
        }
      }
      else
      {
        AppMethodBeat.o(166157);
        return true;
      }
      AppMethodBeat.o(166157);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(166156);
      int j = this.friendFollowCount;
      int k = this.fansCount;
      LinkedList localLinkedList = this.userTags;
      if (localLinkedList != null) {}
      for (int i = localLinkedList.hashCode();; i = 0)
      {
        AppMethodBeat.o(166156);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166155);
      String str = "UserExtInfo(friendFollowCount=" + this.friendFollowCount + ", fansCount=" + this.fansCount + ", userTags=" + this.userTags + ")";
      AppMethodBeat.o(166155);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202817);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$changeChatVisibileState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      paramView = this.sgQ.getContext();
      d.g.b.p.g(paramView, "context");
      paramView = (Context)paramView;
      localObject = FinderProfileUI.h(this.sgQ);
      if (localObject != null) {}
      for (int i = ((com.tencent.mm.plugin.finder.api.g)localObject).field_extFlag;; i = 0)
      {
        if (!com.tencent.mm.plugin.finder.utils.p.Y(paramView, i))
        {
          paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
          paramView = FinderProfileUI.i(this.sgQ);
          d.g.b.p.g(paramView, "contentView");
          paramView = paramView.getContext();
          d.g.b.p.g(paramView, "contentView.context");
          com.tencent.mm.plugin.finder.utils.a.aq(paramView, FinderProfileUI.c(this.sgQ));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$changeChatVisibileState$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202817);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.d
  {
    d(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(202818);
      d.g.b.p.g(paraml, "it");
      if (paraml.fyP())
      {
        paraml.jI(FinderProfileUI.n(this.sgQ), 2131755747);
        paraml.jI(FinderProfileUI.o(this.sgQ), 2131755754);
      }
      AppMethodBeat.o(202818);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.e
  {
    e(FinderProfileUI paramFinderProfileUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202819);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderProfileUI.n(this.sgQ)) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 1);
        localIntent.putExtra("key_finder_post_id", this.sgR);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
        paramMenuItem = this.sgQ.getContext();
        d.g.b.p.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(202819);
        return;
        if (paramMenuItem.getItemId() == FinderProfileUI.o(this.sgQ)) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class f
    implements e.b
  {
    public static final f sgS;
    
    static
    {
      AppMethodBeat.i(202821);
      sgS = new f();
      AppMethodBeat.o(202821);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(202820);
      com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.EW(6);
      AppMethodBeat.o(202820);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.plugin.finder.api.f
  {
    public final void a(alo paramalo)
    {
      AppMethodBeat.i(166158);
      d.g.b.p.h(paramalo, "cmdItem");
      if (!FinderProfileUI.g(this.sgQ))
      {
        AppMethodBeat.o(166158);
        return;
      }
      switch (paramalo.cmdId)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(166158);
        return;
        FinderProfileUI.a(this.sgQ);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "newHeight", "", "onStatusBarHeightChange"})
  static final class h
    implements com.tencent.mm.ui.statusbar.c.a
  {
    h(FinderProfileUI paramFinderProfileUI) {}
    
    public final void ua(int paramInt)
    {
      AppMethodBeat.i(166159);
      ad.i(FinderProfileUI.r(this.sgQ), "newHeight ".concat(String.valueOf(paramInt)));
      if (paramInt > 0)
      {
        Object localObject = FinderProfileUI.v(this.sgQ).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(166159);
          throw ((Throwable)localObject);
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localObject;
        localLayoutParams.height += paramInt;
        FinderProfileUI.v(this.sgQ).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderProfileUI.v(this.sgQ).setPadding(0, paramInt, 0, 0);
        FinderProfileUI.w(this.sgQ).setPadding(0, paramInt, 0, 0);
      }
      com.tencent.mm.ui.statusbar.c.bm((Activity)this.sgQ).b(FinderProfileUI.x(this.sgQ));
      AppMethodBeat.o(166159);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderProfileUI.j(this.sgQ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166160);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166161);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderProfileUI.j(this.sgQ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166161);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166166);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.spam.a.suA;
      if (com.tencent.mm.plugin.finder.spam.a.aip("post"))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166166);
        return;
      }
      FinderProfileUI.k(this.sgQ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166166);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166169);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.sgQ, 1, false);
      paramView.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166167);
          d.g.b.p.g(paramAnonymousl, "it");
          if (paramAnonymousl.fyP())
          {
            paramAnonymousl.jI(FinderProfileUI.l(this.sgT.sgQ), 2131759322);
            paramAnonymousl.jI(FinderProfileUI.m(this.sgT.sgQ), 2131759313);
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
          if (paramAnonymousInt == FinderProfileUI.l(this.sgT.sgQ))
          {
            paramAnonymousMenuItem = FinderProfileUI.h(this.sgT.sgQ);
            if (paramAnonymousMenuItem != null)
            {
              m.a.a(m.sLy, (MMActivity)this.sgT.sgQ, paramAnonymousMenuItem);
              AppMethodBeat.o(166168);
              return;
            }
            AppMethodBeat.o(166168);
            return;
          }
          if (paramAnonymousInt == FinderProfileUI.m(this.sgT.sgQ))
          {
            paramAnonymousMenuItem = this.sgT.sgQ.getString(2131759199, new Object[] { ac.fks(), FinderProfileUI.c(this.sgT.sgQ) });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousMenuItem);
            com.tencent.mm.bs.d.b((Context)this.sgT.sgQ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(166168);
        }
      });
      paramView.cMW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initActionBarView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166169);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<g.a>
  {
    m(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166171);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.eP((Context)this.sgQ);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramView).getRedDotManager().ahl("FinderSetting");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166171);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166174);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.spam.a.suA;
      if (com.tencent.mm.plugin.finder.spam.a.aip("personalInfo"))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166174);
        return;
      }
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.sgQ, 1, false);
      paramView.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166172);
          d.g.b.p.g(paramAnonymousl, "it");
          if (paramAnonymousl.fyP()) {
            paramAnonymousl.jI(FinderProfileUI.e(this.sgU.sgQ), 2131759314);
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
          if (paramAnonymousMenuItem.getItemId() == FinderProfileUI.e(this.sgU.sgQ)) {
            FinderProfileUI.f(this.sgU.sgQ);
          }
          AppMethodBeat.o(166173);
        }
      });
      paramView.cMW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166174);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166175);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      com.tencent.mm.plugin.finder.extension.reddot.i locali;
      if (FinderProfileUI.g(this.sgQ))
      {
        paramView = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(paramView, "MMKernel.storage()");
        int i = paramView.ajl().getInt(al.a.IHW, 0);
        if (i > 0)
        {
          paramView = com.tencent.mm.plugin.finder.report.h.soM;
          paramView = FinderReporterUIC.tcM;
          paramView = FinderReporterUIC.a.eY((Context)this.sgQ);
          if (paramView == null) {
            break label293;
          }
          paramView = paramView.cOu();
          com.tencent.mm.plugin.finder.report.h.a("3", 1, 2, 5, 3, i, null, null, 0L, paramView, 0, 0, 3520);
        }
        paramView = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(paramView, "MMKernel.storage()");
        paramView.ajl().set(al.a.IHW, Integer.valueOf(0));
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)paramView).getRedDotManager().ahm("AuthorProfileFans");
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        locali = ((PluginFinder)paramView).getRedDotManager().ahn("AuthorProfileFans");
        if ((locali != null) && (localObject != null))
        {
          paramView = com.tencent.mm.plugin.finder.report.g.soH;
          paramView = FinderReporterUIC.tcM;
          paramView = FinderReporterUIC.a.eY((Context)this.sgQ);
          if (paramView == null) {
            break label298;
          }
        }
      }
      label293:
      label298:
      for (paramView = paramView.cOu();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.g.b("3", locali, (ase)localObject, 2, paramView, 0, 96);
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramView).getRedDotManager().ahl("AuthorProfileFans");
        FinderProfileUI.a(this.sgQ, FinderFansListUI.class);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$initHeader$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166175);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onActivityResult$1$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class q
    implements com.tencent.mm.loader.g.f<com.tencent.mm.plugin.finder.upload.j>
  {
    q(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$2$1$1$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$3"})
  static final class r
    implements DialogInterface.OnClickListener
  {
    r(azz paramazz1, azz paramazz2, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178300);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.dm(FinderProfileUI.c(jdField_this), 1);
      paramDialogInterface = (com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class);
      String str1 = this.sgV.jdl;
      d.g.b.p.g(str1, "it.Country");
      String str2 = this.sgV.jdd;
      d.g.b.p.g(str2, "it.Province");
      String str3 = this.sgV.jde;
      d.g.b.p.g(str3, "it.City");
      paramDialogInterface.a(str1, str2, str3, 0, (com.tencent.mm.plugin.i.a.s)new com.tencent.mm.plugin.i.a.s() {});
      AppMethodBeat.o(178300);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$2$1$1$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$4"})
  static final class s
    implements DialogInterface.OnClickListener
  {
    s(azz paramazz, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178301);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.dm(FinderProfileUI.c(jdField_this), 2);
      AppMethodBeat.o(178301);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class t
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166178);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      d.g.b.p.h(paramRecyclerView, "recyclerView");
      float f1 = FinderProfileUI.y(this.sgQ).getHeight() * 1.0F;
      if (f1 == 0.0F)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
      }
      paramRecyclerView = new int[2];
      FinderProfileUI.y(this.sgQ).getLocationInWindow(paramRecyclerView);
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
        ad.d(FinderProfileUI.r(this.sgQ), "onScrollListener ".concat(String.valueOf(f2)));
        if (f2 != FinderProfileUI.z(this.sgQ)) {
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
      FinderProfileUI.a(this.sgQ, f2);
      FinderProfileUI.A(this.sgQ);
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        this.sgQ.setActionbarColor(this.sgQ.getResources().getColor(2131101053));
        if (FinderProfileUI.B(this.sgQ))
        {
          FinderProfileUI.v(this.sgQ).setBackgroundColor(this.sgQ.getResources().getColor(2131101053));
          FinderProfileUI.v(this.sgQ).setBackgroundResource(2131233659);
          FinderProfileUI.D(this.sgQ).setAlpha(0.0F);
          FinderProfileUI.E(this.sgQ).setAlpha(f1);
          FinderProfileUI.F(this.sgQ).setAlpha(f1);
          if (!FinderProfileUI.g(this.sgQ)) {
            break label496;
          }
          FinderProfileUI.G(this.sgQ).setVisibility(8);
          FinderProfileUI.H(this.sgQ);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
        FinderProfileUI.v(this.sgQ).setBackgroundResource(0);
        FinderProfileUI.v(this.sgQ).setBackgroundColor(this.sgQ.getResources().getColor(2131101053));
        if (al.isDarkMode())
        {
          FinderProfileUI.C(this.sgQ).setStatusBarColor(this.sgQ.getResources().getColor(2131099816));
          break;
        }
        FinderProfileUI.C(this.sgQ).setStatusBarColor(this.sgQ.getResources().getColor(2131099668));
        break;
        label496:
        FinderProfileUI.I(this.sgQ).setVisibility(8);
        FinderProfileUI.J(this.sgQ).setVisibility(8);
        FinderProfileUI.G(this.sgQ).setVisibility(0);
        continue;
        f1 = (f2 - 0.5F) / 0.5F;
        FinderProfileUI.v(this.sgQ).setBackgroundResource(0);
        FinderProfileUI.v(this.sgQ).setBackgroundColor(ao.eV(this.sgQ.getResources().getColor(2131100705), (int)(255.0F * f1)));
        this.sgQ.setActionbarColor(ao.eV(this.sgQ.getResources().getColor(2131100705), (int)(255.0F * f1)));
        FinderProfileUI.D(this.sgQ).setAlpha(f1);
        FinderProfileUI.E(this.sgQ).setAlpha(f1);
        FinderProfileUI.F(this.sgQ).setAlpha(f1);
        FinderProfileUI.G(this.sgQ).setVisibility(8);
        if (FinderProfileUI.g(this.sgQ))
        {
          FinderProfileUI.H(this.sgQ);
        }
        else
        {
          FinderProfileUI.I(this.sgQ).setVisibility(8);
          if ((!d.g.b.p.i(FinderProfileUI.c(this.sgQ), u.aAu())) && (((t)com.tencent.mm.kernel.g.ad(t.class)).showFinderEntry())) {
            FinderProfileUI.J(this.sgQ).setVisibility(0);
          } else {
            FinderProfileUI.J(this.sgQ).setVisibility(8);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(166177);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(166177);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$1"})
  static final class u
    implements View.OnClickListener
  {
    u(com.tencent.mm.plugin.finder.api.g paramg, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, be parambe) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166179);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      FinderProfileUI.p(jdField_this);
      paramView = new Intent();
      paramView.putStringArrayListExtra("key_url_list", new ArrayList((Collection)d.a.j.listOf(this.sgY.cxL())));
      paramView.putExtra("key_preview_avatar", true);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.H((Context)jdField_this, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(166179);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$2"})
  static final class v
    implements View.OnLongClickListener
  {
    v(FinderProfileUI paramFinderProfileUI, boolean paramBoolean, be parambe) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(166182);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = new com.tencent.mm.ui.widget.b.a((Context)this.sgQ.getContext(), paramView);
      paramView.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(166180);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.shb.sgQ.getContext().getString(2131755701));
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
            paramAnonymousMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(166181);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(FinderProfileUI.q(this.shb.sgQ).getText());
          }
          AppMethodBeat.o(166181);
        }
      });
      localObject = TouchableLayout.LrZ;
      int i = TouchableLayout.fQh();
      localObject = TouchableLayout.LrZ;
      boolean bool = paramView.el(i, TouchableLayout.fQi());
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(166182);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$3"})
  static final class w<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.k, Bitmap>
  {
    w(y.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, be parambe) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$4"})
  static final class x
    implements View.OnClickListener
  {
    x(com.tencent.mm.plugin.finder.api.g paramg, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, be parambe) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166184);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.sgY.field_authInfo;
      if (paramView != null)
      {
        paramView = paramView.authGenerator;
        if (paramView != null)
        {
          paramView = paramView.authInfo;
          if (paramView != null)
          {
            if ((bt.isNullOrNil(paramView.appName)) || (bt.isNullOrNil(paramView.detailLink))) {
              break label148;
            }
            localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
            Context localContext = (Context)jdField_this;
            String str = paramView.appName;
            d.g.b.p.g(str, "authInfo.appName");
            localObject = paramView.detailLink;
            paramView = (View)localObject;
            if (localObject == null) {
              paramView = "";
            }
            com.tencent.mm.plugin.finder.utils.a.z(localContext, str, paramView);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166184);
        return;
        label148:
        if (!bt.isNullOrNil(paramView.detailLink))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.detailLink);
          com.tencent.mm.bs.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$5"})
  static final class y
    implements View.OnClickListener
  {
    y(com.tencent.mm.plugin.finder.api.g paramg, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, be parambe) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166185);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.sgY.field_authInfo;
      if (paramView != null)
      {
        if ((bt.isNullOrNil(paramView.appName)) || (bt.isNullOrNil(paramView.detailLink))) {
          break label130;
        }
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        Context localContext = (Context)jdField_this;
        String str = paramView.appName;
        d.g.b.p.g(str, "authInfo.appName");
        localObject = paramView.detailLink;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        com.tencent.mm.plugin.finder.utils.a.z(localContext, str, paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$$inlined$let$lambda$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(166185);
        return;
        label130:
        if (!bt.isNullOrNil(paramView.detailLink))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.detailLink);
          com.tencent.mm.bs.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(FinderProfileUI paramFinderProfileUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(202823);
      int i = FinderProfileUI.t(this.sgQ).getWidth();
      Object localObject = this.sgQ.getContext();
      d.g.b.p.g(localObject, "context");
      i -= ((AppCompatActivity)localObject).getResources().getDimensionPixelOffset(2131165293);
      TextView localTextView = FinderProfileUI.u(this.sgQ);
      Context localContext = (Context)this.sgQ.getContext();
      localObject = com.tencent.mm.plugin.finder.convert.a.rLR;
      TextPaint localTextPaint = FinderProfileUI.u(this.sgQ).getPaint();
      d.g.b.p.g(localTextPaint, "nickNameTv.paint");
      localObject = paramg;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).VC();; localObject = null)
      {
        AppCompatActivity localAppCompatActivity = this.sgQ.getContext();
        d.g.b.p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(localContext, (CharSequence)com.tencent.mm.plugin.finder.convert.a.a(localTextPaint, (String)localObject, i, i - localAppCompatActivity.getResources().getDimensionPixelOffset(2131165289))));
        AppMethodBeat.o(202823);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI
 * JD-Core Version:    0.7.0.1
 */