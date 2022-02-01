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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.a;
import com.tencent.mm.plugin.finder.feed.g.b.b;
import com.tencent.mm.plugin.finder.feed.g.b.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.g.b.v.e;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(32)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_POST", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_SET_HEADIMG_ALBUM", "MENU_ID_SET_HEADIMG_TAKEPHOTO", "MENU_ID_UNFOLLOW", "REQUEST_CODE_DISTRICT", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "TAG", "", "actionBarAvatarIv", "Landroid/widget/ImageView;", "actionBarBackBtn", "Landroid/view/View;", "actionBarBackIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowBtn", "Landroid/widget/Button;", "actionBarMoreBtn", "actionBarMoreIv", "actionBarNicknameTv", "Landroid/widget/TextView;", "actionBarPhotoBtn", "actionBarPhotoIv", "actionBarRightIconLayout", "Landroid/view/ViewGroup;", "authArrowIv", "authByTv", "authGeneratorTv", "authIcon", "authLayout", "authTv", "avatarIv", "countListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1;", "defaultHeaderBg", "descTv", "editBtn", "editLl", "fansArrowIv", "fansChangeTv", "fansLayout", "fansTv", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "finderSpamActionBarBackBtn", "finderSpamContactTipView", "followBtn", "followBtnTv", "friendFollowLayout", "friendFollowTv", "fromUser", "header", "headerBg", "headerBgLayout", "headerTip", "isFirstResume", "", "isPauseBecauseByClickAvatar", "isReportFanRedDotExpose", "isReportMsgRedDotExpose", "isSelf", "lastActionBarProgress", "", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "myActionBar", "nickNameTv", "onScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "rlContainer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "userInfoLayout", "userOriginalTag", "userTagLayout", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "checkActionBarIconColor", "", "continuePost", "fillHeaderImgLocal", "path", "fixActionBarStuff", "getCommentScene", "getHeaderBgSize", "getLayoutId", "getReportType", "goBack", "hasSetCoverImg", "hideActionBar", "initActionBarView", "initData", "initHeader", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshProfile", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "updateAvatar", "refreshUserExtInfo", "setFollowed", "contact", "setSelectFromAlbum", "setUnfollow", "showActionBarPost", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "resultFileName", "Companion", "UserExtInfo", "plugin-finder_release"})
public final class FinderProfileUI
  extends MMFinderUI
  implements com.tencent.mm.al.g
{
  private static final HashMap<String, b> qAU;
  public static final a qAV;
  private TextView KSI;
  private TextView KSJ;
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean diE;
  private String dpv;
  private String filePath;
  private ImageView fuj;
  private TextView iiN;
  private TextView lEA;
  private final int nmp;
  private Button qAA;
  private View qAB;
  private View qAC;
  private final int qAD;
  private final int qAE;
  private final int qAF;
  private final int qAG;
  private final int qAH;
  private final int qAI;
  private final int qAJ;
  private final int qAK;
  private com.tencent.mm.plugin.finder.api.f qAL;
  private c.a qAM;
  private boolean qAN;
  private float qAP;
  private final p qAQ;
  private boolean qAS;
  private final c qAT;
  private TextView qAa;
  private View qAb;
  private View qAc;
  private View qAe;
  private TextView qAf;
  private ViewGroup qAg;
  private ImageView qAi;
  private TextView qAj;
  private TextView qAk;
  private ImageView qAl;
  private ImageView qAm;
  private View qAp;
  private View qAq;
  private WeImageView qAr;
  private View qAs;
  private ViewGroup qAt;
  private ImageView qAu;
  private TextView qAv;
  private View qAw;
  private WeImageView qAx;
  private View qAy;
  private WeImageView qAz;
  private final int qqA;
  private RefreshLoadMoreLayout quj;
  private boolean qvC;
  private com.tencent.mm.plugin.finder.feed.g.a qwe;
  private View qwn;
  private final int qzI;
  private final int qzJ;
  private final int qzK;
  private View qzS;
  private View qzT;
  private ImageView qzU;
  private ImageView qzV;
  private TextView qzW;
  private ViewGroup qzX;
  private ViewGroup qzY;
  private TextView qzZ;
  private String username;
  private FinderProfileUIContract.ProfileViewCallback viewCallback;
  
  static
  {
    AppMethodBeat.i(166213);
    qAV = new a((byte)0);
    qAU = new HashMap();
    AppMethodBeat.o(166213);
  }
  
  public FinderProfileUI()
  {
    AppMethodBeat.i(166212);
    this.TAG = "Finder.FinderProfileUI";
    this.dpv = "";
    this.qzI = 10000;
    this.qqA = 10001;
    this.qzJ = 10002;
    this.qzK = 10003;
    this.nmp = 10004;
    this.qAD = 10005;
    this.qAE = 10006;
    this.qAF = 10007;
    this.qAG = 10008;
    this.qAH = 10009;
    this.qAI = 1;
    this.qAJ = 2;
    this.qAK = 3;
    this.qAQ = new p(this);
    this.qAS = true;
    this.qAT = new c(this);
    AppMethodBeat.o(166212);
  }
  
  private void Zb(String paramString)
  {
    AppMethodBeat.i(166210);
    d.g.b.k.h(paramString, "path");
    Object localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
    localObject = this.qzV;
    if (localObject == null) {
      d.g.b.k.aPZ("headerBg");
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    int i = com.tencent.mm.plugin.finder.storage.b.coO();
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    com.tencent.mm.plugin.finder.utils.i.a((ImageView)localObject, paramString, i, com.tencent.mm.plugin.finder.storage.b.coO());
    AppMethodBeat.o(166210);
  }
  
  private final void a(final boolean paramBoolean, final ae paramae)
  {
    AppMethodBeat.i(166199);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.aPZ("username");
    }
    this.qAL = b.a.YL((String)localObject1);
    Object localObject3 = this.TAG;
    localObject1 = new StringBuilder("refreshProfile, contact null? ");
    boolean bool;
    Object localObject4;
    Object localObject2;
    int i;
    if (this.qAL == null)
    {
      bool = true;
      localObject4 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.qAL;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject1).Su();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ad.i((String)localObject3, (String)localObject1);
      localObject2 = this.qAL;
      if (localObject2 == null) {
        break label1989;
      }
      if (((com.tencent.mm.plugin.finder.api.f)localObject2).isBlock()) {
        break label1907;
      }
      localObject1 = this.qAB;
      if (localObject1 == null) {
        d.g.b.k.aPZ("finderSpamContactTipView");
      }
      ((View)localObject1).setVisibility(8);
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject1 = com.tencent.mm.plugin.finder.loader.h.cmV();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject2).cks());
        localObject4 = this.qAu;
        if (localObject4 == null) {
          d.g.b.k.aPZ("actionBarAvatarIv");
        }
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
        localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject1 = com.tencent.mm.plugin.finder.loader.h.cmV();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject2).cks());
        localObject4 = this.fuj;
        if (localObject4 == null) {
          d.g.b.k.aPZ("avatarIv");
        }
        localh = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
      }
      localObject1 = this.fuj;
      if (localObject1 == null) {
        d.g.b.k.aPZ("avatarIv");
      }
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new q((com.tencent.mm.plugin.finder.api.f)localObject2, this, paramBoolean, paramae));
      localObject1 = this.iiN;
      if (localObject1 == null) {
        d.g.b.k.aPZ("nickNameTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject2).Su()));
      localObject1 = this.iiN;
      if (localObject1 == null) {
        d.g.b.k.aPZ("nickNameTv");
      }
      ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = this.qAv;
      if (localObject1 == null) {
        d.g.b.k.aPZ("actionBarNicknameTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject2).Su()));
      localObject1 = (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject2).field_signature;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label640;
      }
      i = 1;
      label470:
      if (i == 0) {
        break label645;
      }
      localObject1 = this.lEA;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((TextView)localObject1).setVisibility(8);
      label498:
      localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
      if (!b.a.YO(((com.tencent.mm.plugin.finder.api.f)localObject2).getUsername())) {
        break label782;
      }
      cmL();
    }
    for (;;)
    {
      a(this.diE, ((com.tencent.mm.plugin.finder.api.f)localObject2).getUsername(), paramae);
      localObject1 = this.qzU;
      if (localObject1 == null) {
        d.g.b.k.aPZ("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject3 = new v.e();
      ((v.e)localObject3).Jhw = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_coverImg;
      if (!this.diE) {
        break label1177;
      }
      localObject1 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).afk().get(ae.a.Fwc, "");
      if (localObject1 != null) {
        break label789;
      }
      paramae = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166199);
      throw paramae;
      bool = false;
      break;
      label640:
      i = 0;
      break label470;
      label645:
      localObject1 = this.lEA;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      localObject3 = (Context)this;
      localObject4 = getContext();
      d.g.b.k.g(localObject4, "context");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)((AppCompatActivity)localObject4).getResources().getString(2131759171, new Object[] { ((com.tencent.mm.plugin.finder.api.f)localObject2).field_signature })));
      localObject1 = this.lEA;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((TextView)localObject1).setVisibility(0);
      localObject1 = this.lEA;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((TextView)localObject1).setOnLongClickListener((View.OnLongClickListener)new r(this, paramBoolean, paramae));
      break label498;
      label782:
      cmK();
    }
    label789:
    localObject1 = (String)localObject1;
    if (!bt.isNullOrNil((String)localObject1))
    {
      ((v.e)localObject3).Jhw = localObject1;
      ad.i(this.TAG, "use localCoverImg " + (String)((v.e)localObject3).Jhw);
    }
    if (!bt.isNullOrNil((String)((v.e)localObject3).Jhw))
    {
      localObject1 = (String)((v.e)localObject3).Jhw;
      d.g.b.k.g(localObject1, "path");
      localObject4 = com.tencent.mm.plugin.finder.utils.k.qTp;
      if (d.n.n.mA((String)localObject1, com.tencent.mm.plugin.finder.utils.k.crX()))
      {
        localObject1 = this.qzU;
        if (localObject1 == null) {
          d.g.b.k.aPZ("defaultHeaderBg");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = (String)((v.e)localObject3).Jhw;
        d.g.b.k.g(localObject1, "path");
        Zb((String)localObject1);
      }
    }
    else
    {
      label938:
      localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo;
      localObject3 = this.qAk;
      if (localObject3 == null) {
        d.g.b.k.aPZ("authGeneratorTv");
      }
      ((TextView)localObject3).setVisibility(8);
      if (localObject1 == null) {
        break label1883;
      }
      if (((FinderAuthInfo)localObject1).authIconType <= 0) {
        break label1859;
      }
      localObject3 = this.qAk;
      if (localObject3 == null) {
        d.g.b.k.aPZ("authGeneratorTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new t((com.tencent.mm.plugin.finder.api.f)localObject2, this, paramBoolean, paramae));
      localObject3 = this.qAj;
      if (localObject3 == null) {
        d.g.b.k.aPZ("authByTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new u((com.tencent.mm.plugin.finder.api.f)localObject2, this, paramBoolean, paramae));
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        label1096:
        if ((((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo == null) || ((bt.isNullOrNil(((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo.appName)) && (bt.isNullOrNil(((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo.detailLink))) || (1 == ((FinderAuthInfo)localObject1).authIconType))
        {
          paramae = this.qAl;
          if (paramae == null) {
            d.g.b.k.aPZ("authArrowIv");
          }
          paramae.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      cmM();
      paramae = d.y.JfV;
      AppMethodBeat.o(166199);
      return;
      label1177:
      localObject1 = "";
      break;
      localObject1 = this.qzU;
      if (localObject1 == null) {
        d.g.b.k.aPZ("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = (String)((v.e)localObject3).Jhw;
      d.g.b.k.g(localObject1, "path");
      localObject1 = new com.tencent.mm.plugin.finder.loader.d((String)localObject1);
      if (com.tencent.mm.vfs.i.eK(((com.tencent.mm.plugin.finder.loader.d)localObject1).getPath()))
      {
        Zb(((com.tencent.mm.plugin.finder.loader.d)localObject1).getPath());
        break label938;
      }
      localObject4 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject1 = com.tencent.mm.plugin.finder.loader.h.cmU().bI(localObject1);
      localObject4 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.h.a(h.a.qCO)).a((com.tencent.mm.loader.f.d)new s((v.e)localObject3, this, paramBoolean, paramae));
      localObject3 = this.qzV;
      if (localObject3 == null) {
        d.g.b.k.aPZ("headerBg");
      }
      ((com.tencent.mm.loader.b)localObject1).c((ImageView)localObject3);
      break label938;
      paramae = this.qAi;
      if (paramae == null) {
        d.g.b.k.aPZ("authIcon");
      }
      paramae.setVisibility(0);
      paramae = this.qAi;
      if (paramae == null) {
        d.g.b.k.aPZ("authIcon");
      }
      paramae.setImageDrawable(am.i((Context)this, 2131690481, getResources().getColor(2131099777)));
      paramae = ((FinderAuthInfo)localObject1).authProfession;
      if (paramae != null)
      {
        localObject3 = this.qAj;
        if (localObject3 == null) {
          d.g.b.k.aPZ("authByTv");
        }
        ((TextView)localObject3).setVisibility(0);
        localObject3 = this.qAj;
        if (localObject3 == null) {
          d.g.b.k.aPZ("authByTv");
        }
        ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { paramae }));
        paramae = this.qAj;
        if (paramae == null) {
          d.g.b.k.aPZ("authByTv");
        }
        paramae.setOnClickListener(null);
        paramae = d.y.JfV;
      }
      paramae = this.qAg;
      if (paramae == null) {
        d.g.b.k.aPZ("authLayout");
      }
      paramae.setVisibility(0);
      break label1096;
      paramae = this.qAi;
      if (paramae == null) {
        d.g.b.k.aPZ("authIcon");
      }
      paramae.setVisibility(0);
      paramae = this.qAk;
      if (paramae == null) {
        d.g.b.k.aPZ("authGeneratorTv");
      }
      paramae.setVisibility(8);
      paramae = this.qAg;
      if (paramae == null) {
        d.g.b.k.aPZ("authLayout");
      }
      paramae.setVisibility(0);
      paramae = this.qAi;
      if (paramae == null) {
        d.g.b.k.aPZ("authIcon");
      }
      paramae.setImageDrawable(am.i((Context)this, 2131690481, getResources().getColor(2131099748)));
      paramae = ((FinderAuthInfo)localObject1).authProfession;
      if (paramae == null) {
        break label1096;
      }
      localObject3 = this.qAj;
      if (localObject3 == null) {
        d.g.b.k.aPZ("authByTv");
      }
      ((TextView)localObject3).setVisibility(0);
      localObject3 = this.qAj;
      if (localObject3 == null) {
        d.g.b.k.aPZ("authByTv");
      }
      ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { paramae }));
      paramae = d.y.JfV;
      break label1096;
      paramae = this.qAg;
      if (paramae == null) {
        d.g.b.k.aPZ("authLayout");
      }
      paramae.setVisibility(0);
      paramae = this.qAk;
      if (paramae == null) {
        d.g.b.k.aPZ("authGeneratorTv");
      }
      paramae.setVisibility(8);
      paramae = this.qAl;
      if (paramae == null) {
        d.g.b.k.aPZ("authArrowIv");
      }
      paramae.setVisibility(8);
      paramae = this.qAi;
      if (paramae == null) {
        d.g.b.k.aPZ("authIcon");
      }
      paramae.setVisibility(8);
      paramae = this.qAj;
      if (paramae == null) {
        d.g.b.k.aPZ("authByTv");
      }
      paramae.setOnClickListener(null);
      paramae = this.qAj;
      if (paramae == null) {
        d.g.b.k.aPZ("authByTv");
      }
      paramae.setText(2131759236);
      break label1096;
      paramae = this.qAl;
      if (paramae == null) {
        d.g.b.k.aPZ("authArrowIv");
      }
      paramae.setVisibility(0);
      continue;
      label1859:
      paramae = this.qAg;
      if (paramae == null) {
        d.g.b.k.aPZ("authLayout");
      }
      paramae.setVisibility(8);
      continue;
      label1883:
      paramae = this.qAg;
      if (paramae == null) {
        d.g.b.k.aPZ("authLayout");
      }
      paramae.setVisibility(8);
      continue;
      label1907:
      paramae = findViewById(2131305143);
      d.g.b.k.g(paramae, "findViewById<TextView>(R.id.spam_tip_tv)");
      ((TextView)paramae).setText((CharSequence)getString(2131759358));
      if (ai.aF((Context)this)) {
        getContentView().setPadding(0, ai.aE((Context)this), 0, 0);
      }
      paramae = this.qAB;
      if (paramae == null) {
        d.g.b.k.aPZ("finderSpamContactTipView");
      }
      paramae.setVisibility(0);
    }
    label1989:
    AppMethodBeat.o(166199);
  }
  
  private final void a(boolean paramBoolean, String paramString, ae paramae)
  {
    AppMethodBeat.i(166197);
    b localb = (b)qAU.get(paramString);
    if (localb == null) {
      localb = new b(new LinkedList());
    }
    for (;;)
    {
      d.g.b.k.g(localb, "userExtInfoLocalMap[user…nfo(-1, -1, LinkedList())");
      if (paramae != null)
      {
        localb.fansCount = paramae.fansCount;
        localb.friendFollowCount = paramae.friendFollowCount;
        paramae = paramae.userTags;
        d.g.b.k.h(paramae, "<set-?>");
        localb.userTags = paramae;
        ((Map)qAU).put(paramString, localb);
      }
      paramString = new LinkedList((Collection)localb.userTags);
      paramae = this.qAL;
      if ((paramae == null) || (paramae.field_originalFlag != 2))
      {
        paramae = this.KSI;
        if (paramae == null) {
          d.g.b.k.aPZ("userOriginalTag");
        }
        paramae.setVisibility(8);
      }
      if (paramString.isEmpty())
      {
        paramString = this.KSJ;
        if (paramString == null) {
          d.g.b.k.aPZ("userTagLayout");
        }
        paramString.setVisibility(4);
        if ((localb.friendFollowCount <= 0) || (paramBoolean)) {
          break label484;
        }
        paramString = this.qzY;
        if (paramString == null) {
          d.g.b.k.aPZ("friendFollowLayout");
        }
        paramString.setVisibility(0);
        paramString = this.qAa;
        if (paramString == null) {
          d.g.b.k.aPZ("friendFollowTv");
        }
        paramae = getContext();
        d.g.b.k.g(paramae, "context");
        paramString.setText((CharSequence)paramae.getResources().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.e.De(localb.friendFollowCount) }));
      }
      for (;;)
      {
        if ((localb.fansCount <= 0) || (!paramBoolean)) {
          break label508;
        }
        paramString = this.qzX;
        if (paramString == null) {
          d.g.b.k.aPZ("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.qzZ;
        if (paramString == null) {
          d.g.b.k.aPZ("fansTv");
        }
        paramae = getContext();
        d.g.b.k.g(paramae, "context");
        paramString.setText((CharSequence)paramae.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.e.De(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
        paramae = this.KSJ;
        if (paramae == null) {
          d.g.b.k.aPZ("userTagLayout");
        }
        paramae.setVisibility(0);
        paramae = new StringBuilder();
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext()) {
          paramae.append((String)paramString.next()).append(" ");
        }
        paramString = this.KSJ;
        if (paramString == null) {
          d.g.b.k.aPZ("userTagLayout");
        }
        paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)paramae.toString()));
        break;
        label484:
        paramString = this.qzY;
        if (paramString == null) {
          d.g.b.k.aPZ("friendFollowLayout");
        }
        paramString.setVisibility(8);
      }
      label508:
      paramString = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cpX())
      {
        paramString = this.qzX;
        if (paramString == null) {
          d.g.b.k.aPZ("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.qzZ;
        if (paramString == null) {
          d.g.b.k.aPZ("fansTv");
        }
        paramae = getContext();
        d.g.b.k.g(paramae, "context");
        paramString.setText((CharSequence)paramae.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.e.De(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
      }
      paramString = this.qzX;
      if (paramString == null) {
        d.g.b.k.aPZ("fansLayout");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(166197);
      return;
    }
  }
  
  private final int cmH()
  {
    AppMethodBeat.i(166194);
    int i = ai.fv((Context)getContext()).x;
    AppMethodBeat.o(166194);
    return i;
  }
  
  private final boolean cmI()
  {
    AppMethodBeat.i(166195);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fwc, "");
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166195);
      throw ((Throwable)localObject);
    }
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = this.qAL;
      if (localObject == null) {
        break label112;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.f)localObject).field_coverImg;
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
  
  private final void cmJ()
  {
    AppMethodBeat.i(166196);
    if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())
    {
      View localView = this.qAy;
      if (localView == null) {
        d.g.b.k.aPZ("actionBarPhotoBtn");
      }
      localView.setVisibility(0);
    }
    AppMethodBeat.o(166196);
  }
  
  private final void cmK()
  {
    AppMethodBeat.i(166201);
    Object localObject1 = this.qAA;
    if (localObject1 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject1).setText(2131759228);
    localObject1 = this.qAA;
    if (localObject1 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject1).setBackgroundResource(2131232363);
    localObject1 = this.qAA;
    if (localObject1 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject1).setTextColor(getResources().getColor(2131099828));
    localObject1 = this.qAf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("followBtnTv");
    }
    ((TextView)localObject1).setText(2131759228);
    localObject1 = this.qAf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("followBtnTv");
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(2131099828));
    localObject1 = this.qAe;
    if (localObject1 == null) {
      d.g.b.k.aPZ("followBtn");
    }
    ((View)localObject1).setBackgroundResource(2131232363);
    localObject1 = (d.g.a.b)new w(this);
    Object localObject2 = this.qAe;
    if (localObject2 == null) {
      d.g.b.k.aPZ("followBtn");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new b((d.g.a.b)localObject1));
    localObject2 = this.qAA;
    if (localObject2 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject2).setOnClickListener((View.OnClickListener)new b((d.g.a.b)localObject1));
    AppMethodBeat.o(166201);
  }
  
  private final void cmL()
  {
    AppMethodBeat.i(166202);
    Object localObject1 = this.qAf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("followBtnTv");
    }
    ((TextView)localObject1).setText(2131759384);
    localObject1 = this.qAA;
    if (localObject1 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject1).setText(2131759384);
    localObject1 = this.qAA;
    if (localObject1 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject1).setTextColor(getResources().getColor(2131100711));
    localObject1 = this.qAA;
    if (localObject1 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject1).setBackgroundResource(2131232364);
    localObject1 = this.qAf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("followBtnTv");
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(2131100711));
    localObject1 = this.qAe;
    if (localObject1 == null) {
      d.g.b.k.aPZ("followBtn");
    }
    ((View)localObject1).setBackgroundResource(2131232364);
    localObject1 = (d.g.a.b)new v(this);
    Object localObject2 = this.qAe;
    if (localObject2 == null) {
      d.g.b.k.aPZ("followBtn");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new b((d.g.a.b)localObject1));
    localObject2 = this.qAA;
    if (localObject2 == null) {
      d.g.b.k.aPZ("actionBarFollowBtn");
    }
    ((Button)localObject2).setOnClickListener((View.OnClickListener)new b((d.g.a.b)localObject1));
    AppMethodBeat.o(166202);
  }
  
  private final void cmM()
  {
    AppMethodBeat.i(166209);
    if ((cmI()) && (this.qAP < 0.5F))
    {
      ad.d(this.TAG, "checkActionBarIconColor White, " + this.qAP);
      localWeImageView = this.qAr;
      if (localWeImageView == null) {
        d.g.b.k.aPZ("actionBarBackIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.qAz;
      if (localWeImageView == null) {
        d.g.b.k.aPZ("actionBarPhotoIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.qAx;
      if (localWeImageView == null) {
        d.g.b.k.aPZ("actionBarMoreIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      AppMethodBeat.o(166209);
      return;
    }
    ad.d(this.TAG, "checkActionBarIconColor black_color, " + this.qAP);
    WeImageView localWeImageView = this.qAr;
    if (localWeImageView == null) {
      d.g.b.k.aPZ("actionBarBackIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.qAz;
    if (localWeImageView == null) {
      d.g.b.k.aPZ("actionBarPhotoIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.qAx;
    if (localWeImageView == null) {
      d.g.b.k.aPZ("actionBarMoreIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    AppMethodBeat.o(166209);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198542);
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
    AppMethodBeat.o(198542);
    return localView1;
  }
  
  public final int fTB()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(198539);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (d.g.b.k.g(str, u.aqO()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(198539);
      return 33;
    }
    AppMethodBeat.o(198539);
    return 32;
  }
  
  public final int getLayoutId()
  {
    return 2131494095;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(166208);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramInt1 == this.qAF)
    {
      ad.d(this.TAG, "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
      localObject1 = getApplicationContext();
      localObject2 = com.tencent.mm.plugin.finder.utils.k.qTp;
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.h((Context)localObject1, paramIntent, com.tencent.mm.plugin.finder.utils.k.crX());
      if (this.filePath == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      localObject1 = d.g.b.k.C(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject2 = d.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166208);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      d.g.b.k.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject2 = new StringBuilder();
      localObject3 = com.tencent.mm.plugin.finder.utils.k.qTp;
      localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.utils.k.crX());
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      paramIntent.putExtra("CropImage_OutputPath", (String)localObject1);
      paramIntent.setClassName((Context)this, "com.tencent.mm.ui.tools.CropImageNewUI");
      getContext().startActivityForResult(paramIntent, this.qAG);
      AppMethodBeat.o(166208);
      return;
    }
    Object localObject4;
    if (paramInt1 == this.qAE)
    {
      ad.d(this.TAG, "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = paramIntent.getData();
      d.g.b.k.g(localObject1, "data.data");
      this.filePath = ((Uri)localObject1).getPath();
      ad.i(this.TAG, "filePath[" + this.filePath + "] " + paramIntent);
      if (this.filePath == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = (Activity)this;
      paramInt1 = this.qAG;
      localObject2 = this.filePath;
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      localObject3 = d.g.b.k.C(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject4 = d.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166208);
        throw paramIntent;
      }
      localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
      d.g.b.k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject3);
      d.g.b.k.g(localObject3, "MD5.getMessageDigest((fi…eMillis()).toByteArray())");
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
    if (paramInt1 == this.qAG)
    {
      ad.d(this.TAG, "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      this.filePath = paramIntent.getStringExtra("key_result_img_path");
      if ((this.filePath == null) || (!com.tencent.mm.vfs.i.eK(this.filePath)))
      {
        ad.e(this.TAG, "ERROR! filePath=" + this.filePath);
        AppMethodBeat.o(166208);
        return;
      }
      ad.d(this.TAG, "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
      paramIntent = this.qAL;
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.Fwc, this.filePath);
        localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
        b.a.b(paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.upload.f.qRf;
        paramIntent = com.tencent.mm.plugin.finder.upload.f.crB();
        localObject1 = this.filePath;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject2 = this.username;
        if (localObject2 == null) {
          d.g.b.k.aPZ("username");
        }
        localObject3 = (com.tencent.mm.loader.g.f)new m(this);
        d.g.b.k.h(localObject1, "path");
        d.g.b.k.h(localObject2, "userName");
        d.g.b.k.h(localObject3, "callback");
        paramIntent.qQZ.a((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.i((String)localObject1, (String)localObject2), (com.tencent.mm.loader.g.f)localObject3);
      }
      paramIntent = this.filePath;
      if (paramIntent == null) {
        d.g.b.k.fvU();
      }
      Zb(paramIntent);
      cmM();
      AppMethodBeat.o(166208);
      return;
    }
    if ((paramInt1 == this.qAH) && (paramIntent != null))
    {
      localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
      localObject1 = u.aqO();
      d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject4 = b.a.YL((String)localObject1);
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
      if (!d.g.b.k.g(localObject1, "unshow")) {
        break label1161;
      }
      localObject1 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.Fwo, 0);
      localObject1 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.Fwo, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
      localObject1 = "";
    }
    label1161:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (localObject4 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo;
        if (localObject3 == null) {
          break label1117;
        }
        ((ahz)localObject3).country = ((String)localObject1);
        ((ahz)localObject3).evz = ((String)localObject2);
      }
      for (((ahz)localObject3).evA = paramIntent;; ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo.evA = paramIntent)
      {
        localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
        b.a.b((com.tencent.mm.plugin.finder.api.f)localObject4);
        ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, null);
        AppMethodBeat.o(166208);
        return;
        label1117:
        ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo = new ahz();
        ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo.evz = ((String)localObject2);
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
    d.g.b.k.g(paramBundle, "intent.getStringExtra(Co…leUI.KEY_FINDER_USERNAME)");
    this.username = paramBundle;
    paramBundle = this.TAG;
    Object localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.aPZ("username");
    }
    ad.i(paramBundle, "username %s", new Object[] { localObject1 });
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.k.aPZ("username");
    }
    if (bt.isNullOrNil(paramBundle)) {
      finish();
    }
    this.qvC = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.k.aPZ("username");
    }
    if ((paramBundle.equals(u.aqO())) && (this.qvC)) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      this.diE = bool;
      paramBundle = com.tencent.mm.plugin.finder.api.b.qnX;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.k.aPZ("username");
      }
      this.qAL = b.a.YL(paramBundle);
      this.dpv = getIntent().getStringExtra("from_user");
      paramBundle = getWindow();
      d.g.b.k.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      d.g.b.k.g(paramBundle, "decorView");
      paramBundle.setSystemUiVisibility(1280);
      com.tencent.mm.ui.b.c((Activity)this, false);
      if (getSupportActionBar() != null)
      {
        paramBundle = getSupportActionBar();
        if (paramBundle == null) {
          d.g.b.k.fvU();
        }
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle = getSupportActionBar();
        if (paramBundle == null) {
          d.g.b.k.fvU();
        }
        paramBundle.hide();
      }
      paramBundle = getLayoutInflater().inflate(2131494100, null);
      d.g.b.k.g(paramBundle, "layoutInflater.inflate(R…_profile_ui_header, null)");
      this.qwn = paramBundle;
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300045);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…profile_header_bg_layout)");
      this.qzT = paramBundle;
      paramBundle = this.qzT;
      if (paramBundle == null) {
        d.g.b.k.aPZ("headerBgLayout");
      }
      paramBundle = paramBundle.getLayoutParams();
      i = cmH();
      paramBundle.height = i;
      paramBundle.width = i;
      localObject1 = this.qzT;
      if (localObject1 == null) {
        d.g.b.k.aPZ("headerBgLayout");
      }
      ((View)localObject1).setLayoutParams(paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300046);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_header_iv)");
      this.qzV = ((ImageView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300033);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…rofile_default_header_iv)");
      this.qzU = ((ImageView)paramBundle);
      if (ai.Eq())
      {
        paramBundle = this.qzU;
        if (paramBundle == null) {
          d.g.b.k.aPZ("defaultHeaderBg");
        }
        paramBundle.setImageResource(2131232366);
      }
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300047);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…er_profile_header_tip_tv)");
      this.qzW = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300032);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_avatar_btn)");
      this.fuj = ((ImageView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300039);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…nder_profile_fans_layout)");
      this.qzX = ((ViewGroup)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300043);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…ile_friend_follow_layout)");
      this.qzY = ((ViewGroup)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300040);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_fans_tv)");
      this.qzZ = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300044);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…profile_friend_follow_tv)");
      this.qAa = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300035);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_btn)");
      this.qAb = paramBundle;
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300036);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_ll)");
      this.qAc = paramBundle;
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300041);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_follow_btn)");
      this.qAe = paramBundle;
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300042);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…er_profile_follow_btn_tv)");
      this.qAf = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300056);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_name_tv)");
      this.iiN = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300031);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…nder_profile_auth_layout)");
      this.qAg = ((ViewGroup)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131307806);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.original_tag_tv)");
      this.KSI = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131306249);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.user_tag_layout)");
      this.KSJ = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300030);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_icon)");
      this.qAi = ((ImageView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300028);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_by)");
      this.qAj = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300029);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…r_profile_auth_generator)");
      this.qAk = ((TextView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300027);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_auth_arrow)");
      this.qAl = ((ImageView)paramBundle);
      paramBundle = getContext();
      d.g.b.k.g(paramBundle, "context");
      i = paramBundle.getResources().getColor(2131099735);
      paramBundle = this.qAl;
      if (paramBundle == null) {
        d.g.b.k.aPZ("authArrowIv");
      }
      paramBundle.setImageDrawable(am.i((Context)getContext(), 2131690517, i));
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300037);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_fans_arrow)");
      this.qAm = ((ImageView)paramBundle);
      paramBundle = this.qwn;
      if (paramBundle == null) {
        d.g.b.k.aPZ("header");
      }
      paramBundle = paramBundle.findViewById(2131300034);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_desc_tv)");
      this.lEA = ((TextView)paramBundle);
      paramBundle = this.iiN;
      if (paramBundle == null) {
        d.g.b.k.aPZ("nickNameTv");
      }
      paramBundle.setTextSize(1, 17.0F);
      paramBundle = this.qAf;
      if (paramBundle == null) {
        d.g.b.k.aPZ("followBtnTv");
      }
      ai.a((Paint)paramBundle.getPaint(), 0.8F);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      com.tencent.mm.plugin.finder.extension.reddot.d.a(com.tencent.mm.plugin.finder.extension.reddot.d.fSL(), (LifecycleOwner)this, (Observer)new i(this));
      paramBundle = this.qAc;
      if (paramBundle == null) {
        d.g.b.k.aPZ("editLl");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      if (!this.diE) {
        break;
      }
      paramBundle = this.qAc;
      if (paramBundle == null) {
        d.g.b.k.aPZ("editLl");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.qAe;
      if (paramBundle == null) {
        d.g.b.k.aPZ("followBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.qzX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("fansLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.qzY;
      if (paramBundle == null) {
        d.g.b.k.aPZ("friendFollowLayout");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.qAm;
      if (paramBundle == null) {
        d.g.b.k.aPZ("fansArrowIv");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.qzW;
      if (paramBundle == null) {
        d.g.b.k.aPZ("headerTip");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.qzV;
      if (paramBundle == null) {
        d.g.b.k.aPZ("headerBg");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new k(this));
      paramBundle = this.qzX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("fansLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new l(this));
      bool = this.diE;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.k.aPZ("username");
      }
      a(bool, paramBundle, null);
      paramBundle = findViewById(2131305141);
      d.g.b.k.g(paramBundle, "findViewById(R.id.spam_actionbar_back_btn)");
      this.qAC = paramBundle;
      paramBundle = findViewById(2131300072);
      d.g.b.k.g(paramBundle, "findViewById(R.id.finder_spam_contact_tip_view)");
      this.qAB = paramBundle;
      paramBundle = findViewById(2131303475);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_main_rv)");
      this.qzS = paramBundle;
      paramBundle = this.qzS;
      if (paramBundle == null) {
        d.g.b.k.aPZ("rlContainer");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle != null) {
        break label2022;
      }
      paramBundle = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(166193);
      throw paramBundle;
    }
    paramBundle = this.qAc;
    if (paramBundle == null) {
      d.g.b.k.aPZ("editLl");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.qAm;
    if (paramBundle == null) {
      d.g.b.k.aPZ("fansArrowIv");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.k.aPZ("username");
    }
    if (paramBundle.equals(u.aqO()))
    {
      paramBundle = this.qAe;
      if (paramBundle == null) {
        d.g.b.k.aPZ("followBtn");
      }
      paramBundle.setVisibility(8);
      label1832:
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpX()) {
        break label1998;
      }
      paramBundle = qAU;
      localObject1 = this.username;
      if (localObject1 == null) {
        d.g.b.k.aPZ("username");
      }
      paramBundle = (b)paramBundle.get(localObject1);
      if (paramBundle == null) {
        break label1993;
      }
      i = paramBundle.fansCount;
      label1882:
      if (i <= 0) {
        break label1998;
      }
      paramBundle = this.qzX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("fansLayout");
      }
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = this.qzX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("fansLayout");
      }
      paramBundle.setBackground(null);
      paramBundle = this.qzY;
      if (paramBundle == null) {
        d.g.b.k.aPZ("friendFollowLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.qzW;
      if (paramBundle == null) {
        d.g.b.k.aPZ("headerTip");
      }
      paramBundle.setVisibility(8);
      break;
      paramBundle = this.qAe;
      if (paramBundle == null) {
        d.g.b.k.aPZ("followBtn");
      }
      paramBundle.setVisibility(0);
      break label1832;
      label1993:
      i = 0;
      break label1882;
      label1998:
      paramBundle = this.qzX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("fansLayout");
      }
      paramBundle.setVisibility(8);
    }
    label2022:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = (0 - cmH() / 2);
    localObject1 = this.qzS;
    if (localObject1 == null) {
      d.g.b.k.aPZ("rlContainer");
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    paramBundle = findViewById(2131304203);
    d.g.b.k.g(paramBundle, "findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    localObject1 = com.tencent.mm.ui.y.js((Context)getContext()).inflate(2131494590, null);
    d.g.b.k.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    paramBundle.getRecyclerView().setVisibility(0);
    paramBundle = this.quj;
    if (paramBundle == null) {
      d.g.b.k.aPZ("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(true);
    paramBundle = (MMActivity)this;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.aPZ("username");
    }
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    this.qwe = new com.tencent.mm.plugin.finder.feed.g.a(paramBundle, (String)localObject1);
    paramBundle = (MMActivity)this;
    localObject1 = this.qwe;
    if (localObject1 == null) {
      d.g.b.k.aPZ("presenter");
    }
    Object localObject2 = this.qwn;
    if (localObject2 == null) {
      d.g.b.k.aPZ("header");
    }
    this.viewCallback = new FinderProfileUIContract.ProfileViewCallback(paramBundle, (com.tencent.mm.plugin.finder.feed.g.a)localObject1, (View)localObject2, this.qvC);
    paramBundle = this.viewCallback;
    if (paramBundle == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    localObject1 = (RecyclerView.m)this.qAQ;
    d.g.b.k.h(localObject1, "listener");
    paramBundle.frd = ((RecyclerView.m)localObject1);
    paramBundle = this.qwe;
    if (paramBundle == null) {
      d.g.b.k.aPZ("presenter");
    }
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    paramBundle.a((FinderProfileUIContract.ProfileViewCallback)localObject1);
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    ad.i(((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG, "initView");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).KMT.lw((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).imP);
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fPw;
    if (paramBundle == null) {
      d.g.b.k.aPZ("layoutManager");
    }
    ((RecyclerView)localObject2).setLayoutManager(paramBundle);
    paramBundle = new g.b.b((FinderProfileUIContract.ProfileViewCallback)localObject1);
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).fPw.setAdapter((RecyclerView.a)paramBundle);
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).quj.setActionCallback((RefreshLoadMoreLayout.a)new g.b.e((FinderProfileUIContract.ProfileViewCallback)localObject1));
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).KMT.getItemDecoration();
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).fPw.b(paramBundle);
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).frd;
    if (paramBundle != null) {
      ((FinderProfileUIContract.ProfileViewCallback)localObject1).fPw.a(paramBundle);
    }
    paramBundle = FinderReporterUIC.Ljl;
    paramBundle = FinderReporterUIC.a.lB((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).imP);
    if (paramBundle != null)
    {
      paramBundle = FinderReporterUIC.d(paramBundle);
      if (paramBundle != null) {
        paramBundle.v(((FinderProfileUIContract.ProfileViewCallback)localObject1).fPw);
      }
    }
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG;
    Object localObject3 = new StringBuilder("start rxPipeLine, rlLayout.actionCallback hashCode:");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).quj.getActionCallback();
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.hashCode());
      ad.i((String)localObject2, paramBundle);
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new FinderProfileUIContract.ProfileViewCallback.a((FinderProfileUIContract.ProfileViewCallback)localObject1));
      paramBundle = this.viewCallback;
      if (paramBundle == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      ((BaseFinderFeedLoader)paramBundle.qwe.fTm()).register(paramBundle.qvO, paramBundle.imP);
      paramBundle = findViewById(2131303443);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_actionbar_container)");
      this.qAp = paramBundle;
      paramBundle = findViewById(2131296397);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_back_btn)");
      this.qAq = paramBundle;
      paramBundle = findViewById(2131296398);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_back_iv)");
      this.qAr = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303508);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_user_info_layout)");
      this.qAs = paramBundle;
      paramBundle = findViewById(2131303491);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_right_icons_layout)");
      this.qAt = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131296395);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_avatar_iv)");
      this.qAu = ((ImageView)paramBundle);
      paramBundle = findViewById(2131296407);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_nickname_tv)");
      this.qAv = ((TextView)paramBundle);
      paramBundle = findViewById(2131302457);
      d.g.b.k.g(paramBundle, "findViewById(R.id.more_btn)");
      this.qAw = paramBundle;
      paramBundle = findViewById(2131302474);
      d.g.b.k.g(paramBundle, "findViewById(R.id.more_iv)");
      this.qAx = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131305644);
      d.g.b.k.g(paramBundle, "findViewById(R.id.takephoto_btn)");
      this.qAy = paramBundle;
      paramBundle = findViewById(2131305645);
      d.g.b.k.g(paramBundle, "findViewById(R.id.takephoto_iv)");
      this.qAz = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303444);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_actionbar_follow_btn)");
      this.qAA = ((Button)paramBundle);
      if (com.tencent.mm.ui.statusbar.c.HlA)
      {
        this.qAM = ((c.a)new d(this));
        com.tencent.mm.ui.statusbar.c.bj((Activity)this).a(this.qAM);
        com.tencent.mm.ui.statusbar.d.b(getWindow());
      }
      paramBundle = this.qAq;
      if (paramBundle == null) {
        d.g.b.k.aPZ("actionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      paramBundle = this.qAC;
      if (paramBundle == null) {
        d.g.b.k.aPZ("finderSpamActionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      setActionbarColor(getResources().getColor(2131101053));
      paramBundle = this.qAs;
      if (paramBundle == null) {
        d.g.b.k.aPZ("userInfoLayout");
      }
      paramBundle.setAlpha(0.0F);
      paramBundle = this.qAA;
      if (paramBundle == null) {
        d.g.b.k.aPZ("actionBarFollowBtn");
      }
      paramBundle.setVisibility(8);
      cmM();
      if (!cmI()) {
        break label3667;
      }
      paramBundle = this.qAp;
      if (paramBundle == null) {
        d.g.b.k.aPZ("myActionBar");
      }
      paramBundle.setBackgroundColor(getResources().getColor(2131101053));
      paramBundle = this.qAp;
      if (paramBundle == null) {
        d.g.b.k.aPZ("myActionBar");
      }
      paramBundle.setBackgroundResource(2131233659);
      label3133:
      if (!this.diE) {
        break label3713;
      }
      cmJ();
      paramBundle = this.qAw;
      if (paramBundle == null) {
        d.g.b.k.aPZ("actionBarMoreBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.qAy;
      if (paramBundle == null) {
        d.g.b.k.aPZ("actionBarPhotoBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
      label3195:
      if (this.diE)
      {
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(106, (com.tencent.mm.plugin.finder.api.e)this.qAT);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.e)this.qAT);
      }
      paramBundle = com.tencent.mm.ui.component.a.LCX;
      i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).LiN;
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (this.diE)
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.cqd() != 1)
        {
          paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (com.tencent.mm.plugin.finder.storage.b.cqe())
          {
            paramBundle = com.tencent.mm.ui.component.a.LCX;
            paramBundle = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class)).LgS;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
              localObject1 = u.aqO();
              d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
              localObject1 = b.a.YL((String)localObject1);
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo;
                if (localObject1 != null)
                {
                  if (((d.g.b.k.g(paramBundle.ijV, ((ahz)localObject1).country) ^ true)) || ((d.g.b.k.g(paramBundle.ijN, ((ahz)localObject1).evz) ^ true)) || ((d.g.b.k.g(paramBundle.ijO, ((ahz)localObject1).evA) ^ true)))
                  {
                    localObject1 = com.tencent.mm.kernel.g.afB();
                    d.g.b.k.g(localObject1, "MMKernel.storage()");
                    ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.Fxm, Long.valueOf(1L));
                    localObject1 = com.tencent.mm.ui.component.a.LCX;
                    localObject1 = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class)).LgS;
                    if (localObject1 != null)
                    {
                      localObject2 = (Context)this;
                      localObject3 = com.tencent.mm.plugin.finder.utils.i.qTa;
                      localObject3 = ((asx)localObject1).ijV;
                      d.g.b.k.g(localObject3, "it.Country");
                      String str1 = ((asx)localObject1).ijN;
                      d.g.b.k.g(str1, "it.Province");
                      String str2 = ((asx)localObject1).ijO;
                      d.g.b.k.g(str2, "it.City");
                      com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131759248, new Object[] { com.tencent.mm.plugin.finder.utils.i.aa((String)localObject3, str1, str2) }), "", getString(2131759347), getString(2131755691), true, (DialogInterface.OnClickListener)new n((asx)localObject1, paramBundle, this), (DialogInterface.OnClickListener)new o(paramBundle, this));
                      AppMethodBeat.o(166193);
                      return;
                      paramBundle = null;
                      break;
                      label3667:
                      if (ai.Eq())
                      {
                        this.mController.setStatusBarColor(getResources().getColor(2131099816));
                        break label3133;
                      }
                      this.mController.setStatusBarColor(getResources().getColor(2131099668));
                      break label3133;
                      label3713:
                      paramBundle = this.qAy;
                      if (paramBundle == null) {
                        d.g.b.k.aPZ("actionBarPhotoBtn");
                      }
                      paramBundle.setVisibility(8);
                      paramBundle = this.qAw;
                      if (paramBundle == null) {
                        d.g.b.k.aPZ("actionBarMoreBtn");
                      }
                      paramBundle.setVisibility(0);
                      paramBundle = this.qAw;
                      if (paramBundle == null) {
                        d.g.b.k.aPZ("actionBarMoreBtn");
                      }
                      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
                      break label3195;
                      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1278L, 15L, 1L, false);
                      paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
                      localObject1 = this.dpv;
                      paramBundle = (Bundle)localObject1;
                      if (localObject1 == null) {
                        paramBundle = "";
                      }
                      localObject1 = this.username;
                      if (localObject1 == null) {
                        d.g.b.k.aPZ("username");
                      }
                      com.tencent.mm.plugin.finder.report.b.y(i, paramBundle, (String)localObject1);
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
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(106, (com.tencent.mm.plugin.finder.api.e)this.qAT);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.e)this.qAT);
    FinderProfileUIContract.ProfileViewCallback localProfileViewCallback = this.viewCallback;
    if (localProfileViewCallback == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    ((BaseFinderFeedLoader)localProfileViewCallback.qwe.fTm()).unregister(localProfileViewCallback.qvO, localProfileViewCallback.imP);
    localProfileViewCallback.qwe.onDetach();
    AppMethodBeat.o(166206);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166204);
    super.onPause();
    if (this.viewCallback == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    AppMethodBeat.o(166204);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166203);
    super.onResume();
    this.qAN = false;
    Object localObject1;
    if (this.diE)
    {
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
        AppMethodBeat.o(166203);
        throw ((Throwable)localObject1);
      }
      ((com.tencent.mm.plugin.finder.extension.a)localObject1).fu(4137, 1);
    }
    com.tencent.mm.kernel.g.aeS().a(3736, (com.tencent.mm.al.g)this);
    Object localObject2;
    if (this.qAS)
    {
      a(true, null);
      this.qAS = false;
      if (this.viewCallback == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.f.qRf;
      if (com.tencent.mm.plugin.finder.upload.f.crC())
      {
        localObject1 = this.viewCallback;
        if (localObject1 == null) {
          d.g.b.k.aPZ("viewCallback");
        }
        localObject1 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fPw;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localObject1 = com.tencent.mm.plugin.finder.upload.f.qRf;
        com.tencent.mm.plugin.finder.upload.f.lg(false);
      }
      AppMethodBeat.o(166203);
      return;
    }
    if (this.diE)
    {
      localObject1 = this.qAL;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_username;
        if (localObject1 != null) {
          break label322;
        }
      }
      localObject1 = "";
    }
    label322:
    for (;;)
    {
      localObject2 = com.tencent.mm.ui.component.a.LCX;
      localObject1 = new ae((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
      ((ae)localObject1).qpJ = true;
      com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)localObject1);
      break;
      a(true, null);
      break;
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
      paramString = ((ae)paramn).rr.auM();
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
      String str1 = ((ae)paramn).qpK;
      Object localObject = this.username;
      if (localObject == null) {
        d.g.b.k.aPZ("username");
      }
      if (d.g.b.k.g(str1, localObject))
      {
        str1 = this.username;
        if (str1 == null) {
          d.g.b.k.aPZ("username");
        }
        if ((d.g.b.k.g(str1, paramString.username) ^ true))
        {
          str1 = this.TAG;
          localObject = new StringBuilder("update username ");
          String str2 = this.username;
          if (str2 == null) {
            d.g.b.k.aPZ("username");
          }
          ad.i(str1, str2 + ' ' + paramString.username);
        }
        paramString = paramString.username;
        d.g.b.k.g(paramString, "contact.username");
        this.username = paramString;
        a(true, (ae)paramn);
      }
    }
    label275:
    AppMethodBeat.o(166207);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(166205);
    super.onStop();
    com.tencent.mm.kernel.g.aeS().b(3736, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(166205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$Companion;", "", "()V", "userExtInfoLocalMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$UserExtInfo;", "Lkotlin/collections/HashMap;", "getUserExtInfoLocalMap", "()Ljava/util/HashMap;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$UserExtInfo;", "", "friendFollowCount", "", "fansCount", "userTags", "Ljava/util/LinkedList;", "", "(IILjava/util/LinkedList;)V", "getFansCount", "()I", "setFansCount", "(I)V", "getFriendFollowCount", "setFriendFollowCount", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
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
          if ((this.friendFollowCount != paramObject.friendFollowCount) || (this.fansCount != paramObject.fansCount) || (!d.g.b.k.g(this.userTags, paramObject.userTags))) {}
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "plugin-finder_release"})
  public static final class c
    implements com.tencent.mm.plugin.finder.api.e
  {
    public final void a(ahv paramahv)
    {
      AppMethodBeat.i(166158);
      d.g.b.k.h(paramahv, "cmdItem");
      if (!FinderProfileUI.g(this.qAW))
      {
        AppMethodBeat.o(166158);
        return;
      }
      switch (paramahv.cmdId)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(166158);
        return;
        FinderProfileUI.a(this.qAW);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "newHeight", "", "onStatusBarHeightChange"})
  static final class d
    implements c.a
  {
    d(FinderProfileUI paramFinderProfileUI) {}
    
    public final void sG(int paramInt)
    {
      AppMethodBeat.i(166159);
      ad.i(FinderProfileUI.p(this.qAW), "newHeight ".concat(String.valueOf(paramInt)));
      if (paramInt > 0)
      {
        Object localObject = FinderProfileUI.s(this.qAW).getLayoutParams();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(166159);
          throw ((Throwable)localObject);
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localObject;
        localLayoutParams.height += paramInt;
        FinderProfileUI.s(this.qAW).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderProfileUI.s(this.qAW).setPadding(0, paramInt, 0, 0);
        FinderProfileUI.t(this.qAW).setPadding(0, paramInt, 0, 0);
      }
      com.tencent.mm.ui.statusbar.c.bj((Activity)this.qAW).b(FinderProfileUI.u(this.qAW));
      AppMethodBeat.o(166159);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166160);
      FinderProfileUI.h(this.qAW);
      AppMethodBeat.o(166160);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166161);
      FinderProfileUI.h(this.qAW);
      AppMethodBeat.o(166161);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166166);
      paramView = com.tencent.mm.plugin.finder.spam.a.qIC;
      if (com.tencent.mm.plugin.finder.spam.a.Zv("post"))
      {
        AppMethodBeat.o(166166);
        return;
      }
      FinderProfileUI.q(this.qAW);
      AppMethodBeat.o(166166);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166169);
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.qAW, 1, false);
      paramView.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166167);
          d.g.b.k.g(paramAnonymousl, "it");
          if (paramAnonymousl.eSQ())
          {
            paramAnonymousl.jj(FinderProfileUI.k(this.qAZ.qAW), 2131759322);
            paramAnonymousl.jj(FinderProfileUI.l(this.qAZ.qAW), 2131759313);
          }
          AppMethodBeat.o(166167);
        }
      });
      paramView.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(166168);
          d.g.b.k.g(paramAnonymousMenuItem, "menuItem");
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          if (paramAnonymousInt == FinderProfileUI.k(this.qAZ.qAW))
          {
            paramAnonymousMenuItem = FinderProfileUI.m(this.qAZ.qAW);
            if (paramAnonymousMenuItem != null)
            {
              com.tencent.mm.plugin.finder.utils.g.a.a(com.tencent.mm.plugin.finder.utils.g.qSw, (MMActivity)this.qAZ.qAW, paramAnonymousMenuItem);
              AppMethodBeat.o(166168);
              return;
            }
            AppMethodBeat.o(166168);
            return;
          }
          if (paramAnonymousInt == FinderProfileUI.l(this.qAZ.qAW))
          {
            paramAnonymousMenuItem = this.qAZ.qAW.getString(2131759199, new Object[] { ac.eFu(), FinderProfileUI.c(this.qAZ.qAW) });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousMenuItem);
            com.tencent.mm.bs.d.b((Context)this.qAZ.qAW.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(166168);
        }
      });
      paramView.csG();
      AppMethodBeat.o(166169);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class i<T>
    implements Observer<d.a>
  {
    i(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166171);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.eF((Context)this.qAW);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramView).getRedDotManager().YU("FinderSetting");
      AppMethodBeat.o(166171);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166174);
      paramView = com.tencent.mm.plugin.finder.spam.a.qIC;
      if (com.tencent.mm.plugin.finder.spam.a.Zv("personalInfo"))
      {
        AppMethodBeat.o(166174);
        return;
      }
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.qAW, 1, false);
      paramView.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166172);
          d.g.b.k.g(paramAnonymousl, "it");
          if (paramAnonymousl.eSQ()) {
            paramAnonymousl.jj(FinderProfileUI.e(this.qBa.qAW), 2131759314);
          }
          AppMethodBeat.o(166172);
        }
      });
      paramView.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(166173);
          d.g.b.k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == FinderProfileUI.e(this.qBa.qAW)) {
            FinderProfileUI.f(this.qBa.qAW);
          }
          AppMethodBeat.o(166173);
        }
      });
      paramView.csG();
      AppMethodBeat.o(166174);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166175);
      int i;
      if (FinderProfileUI.g(this.qAW))
      {
        paramView = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramView, "MMKernel.storage()");
        i = paramView.afk().getInt(ae.a.FwY, 0);
        if (i > 0)
        {
          paramView = com.tencent.mm.plugin.finder.report.b.qFq;
          paramView = FinderReporterUIC.Ljl;
          paramView = FinderReporterUIC.a.lB((Context)this.qAW);
          if (paramView == null) {
            break label126;
          }
        }
      }
      label126:
      for (paramView = paramView.fXs();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.b.a("3", 1, 2, 5, 3, i, null, null, 0L, paramView, 0, 1472);
        paramView = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramView, "MMKernel.storage()");
        paramView.afk().set(ae.a.FwY, Integer.valueOf(0));
        FinderProfileUI.a(this.qAW, FinderFansListUI.class);
        AppMethodBeat.o(166175);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onActivityResult$1$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.loader.g.f<com.tencent.mm.plugin.finder.upload.i>
  {
    m(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$1$1$1$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$3"})
  static final class n
    implements DialogInterface.OnClickListener
  {
    n(asx paramasx1, asx paramasx2, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178300);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.cV(FinderProfileUI.c(jdField_this), 1);
      paramDialogInterface = (com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class);
      String str1 = this.qBb.ijV;
      d.g.b.k.g(str1, "it.Country");
      String str2 = this.qBb.ijN;
      d.g.b.k.g(str2, "it.Province");
      String str3 = this.qBb.ijO;
      d.g.b.k.g(str3, "it.City");
      paramDialogInterface.a(str1, str2, str3, 0, (com.tencent.mm.plugin.i.a.i)new com.tencent.mm.plugin.i.a.i() {});
      AppMethodBeat.o(178300);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$1$1$1$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$4"})
  static final class o
    implements DialogInterface.OnClickListener
  {
    o(asx paramasx, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178301);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.cV(FinderProfileUI.c(jdField_this), 2);
      AppMethodBeat.o(178301);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class p
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166178);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      float f1 = FinderProfileUI.v(this.qAW).getHeight() * 1.0F;
      if (f1 == 0.0F)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
      }
      paramRecyclerView = new int[2];
      FinderProfileUI.v(this.qAW).getLocationInWindow(paramRecyclerView);
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
        ad.d(FinderProfileUI.p(this.qAW), "onScrollListener ".concat(String.valueOf(f2)));
        if (f2 != FinderProfileUI.w(this.qAW)) {
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
      FinderProfileUI.a(this.qAW, f2);
      FinderProfileUI.x(this.qAW);
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        this.qAW.setActionbarColor(this.qAW.getResources().getColor(2131101053));
        if (FinderProfileUI.y(this.qAW))
        {
          FinderProfileUI.s(this.qAW).setBackgroundColor(this.qAW.getResources().getColor(2131101053));
          FinderProfileUI.s(this.qAW).setBackgroundResource(2131233659);
          FinderProfileUI.A(this.qAW).setAlpha(0.0F);
          FinderProfileUI.B(this.qAW).setAlpha(f1);
          FinderProfileUI.C(this.qAW).setAlpha(f1);
          if (!FinderProfileUI.g(this.qAW)) {
            break label496;
          }
          FinderProfileUI.D(this.qAW).setVisibility(8);
          FinderProfileUI.E(this.qAW);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
        FinderProfileUI.s(this.qAW).setBackgroundResource(0);
        FinderProfileUI.s(this.qAW).setBackgroundColor(this.qAW.getResources().getColor(2131101053));
        if (ai.Eq())
        {
          FinderProfileUI.z(this.qAW).setStatusBarColor(this.qAW.getResources().getColor(2131099816));
          break;
        }
        FinderProfileUI.z(this.qAW).setStatusBarColor(this.qAW.getResources().getColor(2131099668));
        break;
        label496:
        FinderProfileUI.F(this.qAW).setVisibility(8);
        FinderProfileUI.G(this.qAW).setVisibility(8);
        FinderProfileUI.D(this.qAW).setVisibility(0);
        continue;
        f1 = (f2 - 0.5F) / 0.5F;
        FinderProfileUI.s(this.qAW).setBackgroundResource(0);
        FinderProfileUI.s(this.qAW).setBackgroundColor(am.eO(this.qAW.getResources().getColor(2131100705), (int)(255.0F * f1)));
        this.qAW.setActionbarColor(am.eO(this.qAW.getResources().getColor(2131100705), (int)(255.0F * f1)));
        FinderProfileUI.A(this.qAW).setAlpha(f1);
        FinderProfileUI.B(this.qAW).setAlpha(f1);
        FinderProfileUI.C(this.qAW).setAlpha(f1);
        FinderProfileUI.D(this.qAW).setVisibility(8);
        if (FinderProfileUI.g(this.qAW))
        {
          FinderProfileUI.E(this.qAW);
        }
        else
        {
          FinderProfileUI.F(this.qAW).setVisibility(8);
          if (d.g.b.k.g(FinderProfileUI.c(this.qAW), u.aqO())) {
            FinderProfileUI.G(this.qAW).setVisibility(8);
          } else {
            FinderProfileUI.G(this.qAW).setVisibility(0);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(166177);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(166177);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$1"})
  static final class q
    implements View.OnClickListener
  {
    q(com.tencent.mm.plugin.finder.api.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166179);
      FinderProfileUI.n(jdField_this);
      paramView = new Intent();
      paramView.putStringArrayListExtra("key_url_list", new ArrayList((Collection)d.a.j.listOf(this.qBe.cks())));
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.D((Context)jdField_this, paramView);
      AppMethodBeat.o(166179);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$2"})
  static final class r
    implements View.OnLongClickListener
  {
    r(FinderProfileUI paramFinderProfileUI, boolean paramBoolean, ae paramae) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(166182);
      paramView = new com.tencent.mm.ui.widget.b.a((Context)this.qAW.getContext(), paramView);
      paramView.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(166180);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.qBh.qAW.getContext().getString(2131755701));
          AppMethodBeat.o(166180);
        }
      });
      paramView.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(166181);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new d.v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(166181);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(FinderProfileUI.o(this.qBh.qAW).getText());
          }
          AppMethodBeat.o(166181);
        }
      });
      TouchableLayout.a locala = TouchableLayout.HYe;
      int i = TouchableLayout.fiK();
      locala = TouchableLayout.HYe;
      boolean bool = paramView.eh(i, TouchableLayout.fiL());
      AppMethodBeat.o(166182);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$3"})
  static final class s<T, R>
    implements com.tencent.mm.loader.f.d<com.tencent.mm.plugin.finder.loader.j, Bitmap>
  {
    s(v.e parame, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, ae paramae) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$4"})
  static final class t
    implements View.OnClickListener
  {
    t(com.tencent.mm.plugin.finder.api.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166184);
      paramView = this.qBe.field_authInfo;
      if (paramView != null)
      {
        paramView = paramView.authGenerator;
        if (paramView != null)
        {
          paramView = paramView.authInfo;
          if (paramView != null)
          {
            Object localObject;
            if ((!bt.isNullOrNil(paramView.appName)) && (!bt.isNullOrNil(paramView.detailLink)))
            {
              localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
              Context localContext = (Context)jdField_this;
              String str = paramView.appName;
              d.g.b.k.g(str, "authInfo.appName");
              localObject = paramView.detailLink;
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = "";
              }
              com.tencent.mm.plugin.finder.utils.a.z(localContext, str, paramView);
              AppMethodBeat.o(166184);
              return;
            }
            if (!bt.isNullOrNil(paramView.detailLink))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", paramView.detailLink);
              com.tencent.mm.bs.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            }
            AppMethodBeat.o(166184);
            return;
          }
        }
      }
      AppMethodBeat.o(166184);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$5"})
  static final class u
    implements View.OnClickListener
  {
    u(com.tencent.mm.plugin.finder.api.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166185);
      paramView = this.qBe.field_authInfo;
      if (paramView != null)
      {
        Object localObject;
        if ((!bt.isNullOrNil(paramView.appName)) && (!bt.isNullOrNil(paramView.detailLink)))
        {
          localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
          Context localContext = (Context)jdField_this;
          String str = paramView.appName;
          d.g.b.k.g(str, "authInfo.appName");
          localObject = paramView.detailLink;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          com.tencent.mm.plugin.finder.utils.a.z(localContext, str, paramView);
          AppMethodBeat.o(166185);
          return;
        }
        if (!bt.isNullOrNil(paramView.detailLink))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.detailLink);
          com.tencent.mm.bs.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
        AppMethodBeat.o(166185);
        return;
      }
      AppMethodBeat.o(166185);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.b<View, d.y>
  {
    v(FinderProfileUI paramFinderProfileUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.b<View, d.y>
  {
    w(FinderProfileUI paramFinderProfileUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI
 * JD-Core Version:    0.7.0.1
 */