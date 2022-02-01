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
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.b;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.d;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.ProfileViewCallback.e;
import com.tencent.mm.plugin.finder.feed.FinderProfileUIContract.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.g.b.v.f;
import d.v;
import d.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(32)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_POST", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_SET_HEADIMG_ALBUM", "MENU_ID_SET_HEADIMG_TAKEPHOTO", "MENU_ID_UNFOLLOW", "REQUEST_CODE_DISTRICT", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM", "REQUEST_CODE_SELECT_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "REQUEST_CODE_TEXT_CARD", "TAG", "", "actionBarAvatarIv", "Landroid/widget/ImageView;", "actionBarBackBtn", "Landroid/view/View;", "actionBarBackIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "actionBarFollowBtn", "Landroid/widget/Button;", "actionBarMoreBtn", "actionBarMoreIv", "actionBarNicknameTv", "Landroid/widget/TextView;", "actionBarPhotoBtn", "actionBarPhotoIv", "actionBarRightIconLayout", "Landroid/view/ViewGroup;", "authArrowIv", "authByTv", "authGeneratorTv", "authIcon", "authLayout", "authTv", "avatarIv", "countListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1;", "defaultHeaderBg", "descTv", "editBtn", "editLl", "fansArrowIv", "fansChangeTv", "fansLayout", "fansTv", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "finderSpamActionBarBackBtn", "finderSpamContactTipView", "followBtn", "followBtnTv", "friendFollowLayout", "friendFollowTv", "fromUser", "header", "headerBg", "headerBgLayout", "headerTip", "isFirstResume", "", "isPauseBecauseByClickAvatar", "isReportFanRedDotExpose", "isReportMsgRedDotExpose", "isSelf", "lastActionBarProgress", "", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "myActionBar", "nickNameTv", "onScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfilePresenter;", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "rlContainer", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "userInfoLayout", "userOriginalTag", "userTagLayout", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;", "checkActionBarIconColor", "", "continuePost", "fillHeaderImgLocal", "path", "fixActionBarStuff", "getCommentScene", "getHeaderBgSize", "getLayoutId", "getReportType", "goBack", "hasSetCoverImg", "hideActionBar", "initActionBarView", "initData", "initHeader", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshProfile", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "updateAvatar", "refreshUserExtInfo", "setFollowed", "contact", "setSelectFromAlbum", "setUnfollow", "showActionBarPost", "startCropImgForResult", "context", "Landroid/app/Activity;", "intent", "resultFileName", "Companion", "UserExtInfo", "plugin-finder_release"})
public final class FinderProfileUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g
{
  private static final HashMap<String, FinderProfileUI.b> rrH;
  public static final FinderProfileUI.a rrI;
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean dfZ;
  private String dng;
  private String filePath;
  private ImageView fxQ;
  private TextView gAI;
  private TextView iIU;
  private final int nPp;
  private final int raj;
  private RefreshLoadMoreLayout rfT;
  private FinderProfileUIContract.a riT;
  private boolean riv;
  private View rjd;
  private final int rqC;
  private final int rqD;
  private final int rqE;
  private View rqJ;
  private View rqK;
  private ImageView rqL;
  private ImageView rqM;
  private TextView rqN;
  private ViewGroup rqO;
  private ViewGroup rqP;
  private TextView rqQ;
  private TextView rqR;
  private View rqS;
  private View rqT;
  private View rqU;
  private TextView rqV;
  private ViewGroup rqW;
  private TextView rqX;
  private TextView rqY;
  private ImageView rqZ;
  private com.tencent.mm.plugin.finder.api.f rrA;
  private c.a rrB;
  private boolean rrC;
  private float rrD;
  private final s rrE;
  private boolean rrF;
  private final f rrG;
  private TextView rra;
  private TextView rrb;
  private ImageView rrc;
  private ImageView rrd;
  private View rre;
  private View rrf;
  private WeImageView rrg;
  private View rrh;
  private ViewGroup rri;
  private ImageView rrj;
  private TextView rrk;
  private View rrl;
  private WeImageView rrm;
  private View rrn;
  private WeImageView rro;
  private Button rrp;
  private View rrq;
  private View rrr;
  private final int rrs;
  private final int rrt;
  private final int rru;
  private final int rrv;
  private final int rrw;
  private final int rrx;
  private final int rry;
  private final int rrz;
  private String username;
  private FinderProfileUIContract.ProfileViewCallback viewCallback;
  
  static
  {
    AppMethodBeat.i(166213);
    rrI = new FinderProfileUI.a((byte)0);
    rrH = new HashMap();
    AppMethodBeat.o(166213);
  }
  
  public FinderProfileUI()
  {
    AppMethodBeat.i(166212);
    this.TAG = "Finder.FinderProfileUI";
    this.dng = "";
    this.rqC = 10000;
    this.raj = 10001;
    this.rqD = 10002;
    this.rqE = 10003;
    this.nPp = 10004;
    this.rrs = 10005;
    this.rrt = 10006;
    this.rru = 10007;
    this.rrv = 10008;
    this.rrw = 10009;
    this.rrx = 1;
    this.rry = 2;
    this.rrz = 3;
    this.rrE = new s(this);
    this.rrF = true;
    this.rrG = new f(this);
    AppMethodBeat.o(166212);
  }
  
  private final void a(final boolean paramBoolean, final aw paramaw)
  {
    AppMethodBeat.i(166199);
    Object localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.aVY("username");
    }
    this.rrA = b.a.adh((String)localObject1);
    Object localObject3 = this.TAG;
    localObject1 = new StringBuilder("refreshProfile, contact null? ");
    boolean bool;
    Object localObject4;
    Object localObject2;
    int i;
    if (this.rrA == null)
    {
      bool = true;
      localObject4 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.rrA;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.api.f)localObject1).Tn();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ac.i((String)localObject3, (String)localObject1);
      localObject2 = this.rrA;
      if (localObject2 == null) {
        break label1989;
      }
      if (((com.tencent.mm.plugin.finder.api.f)localObject2).isBlock()) {
        break label1907;
      }
      localObject1 = this.rrq;
      if (localObject1 == null) {
        d.g.b.k.aVY("finderSpamContactTipView");
      }
      ((View)localObject1).setVisibility(8);
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.loader.h.rtK;
        localObject1 = com.tencent.mm.plugin.finder.loader.h.cwo();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject2).crZ());
        localObject4 = this.rrj;
        if (localObject4 == null) {
          d.g.b.k.aVY("actionBarAvatarIv");
        }
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
        localObject1 = com.tencent.mm.plugin.finder.loader.h.rtK;
        localObject1 = com.tencent.mm.plugin.finder.loader.h.cwo();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject2).crZ());
        localObject4 = this.fxQ;
        if (localObject4 == null) {
          d.g.b.k.aVY("avatarIv");
        }
        localh = com.tencent.mm.plugin.finder.loader.h.rtK;
        ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
      }
      localObject1 = this.fxQ;
      if (localObject1 == null) {
        d.g.b.k.aVY("avatarIv");
      }
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new t((com.tencent.mm.plugin.finder.api.f)localObject2, this, paramBoolean, paramaw));
      localObject1 = this.iIU;
      if (localObject1 == null) {
        d.g.b.k.aVY("nickNameTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject2).Tn()));
      localObject1 = this.iIU;
      if (localObject1 == null) {
        d.g.b.k.aVY("nickNameTv");
      }
      aj.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      localObject1 = this.rrk;
      if (localObject1 == null) {
        d.g.b.k.aVY("actionBarNicknameTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)this, (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject2).Tn()));
      localObject1 = (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject2).field_signature;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label640;
      }
      i = 1;
      label470:
      if (i == 0) {
        break label645;
      }
      localObject1 = this.gAI;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((TextView)localObject1).setVisibility(8);
      label498:
      localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
      if (!b.a.adk(((com.tencent.mm.plugin.finder.api.f)localObject2).getUsername())) {
        break label782;
      }
      cwd();
    }
    for (;;)
    {
      a(this.dfZ, ((com.tencent.mm.plugin.finder.api.f)localObject2).getUsername(), paramaw);
      localObject1 = this.rqL;
      if (localObject1 == null) {
        d.g.b.k.aVY("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject3 = new v.f();
      ((v.f)localObject3).KUQ = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_coverImg;
      if (!this.dfZ) {
        break label1177;
      }
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GTW, "");
      if (localObject1 != null) {
        break label789;
      }
      paramaw = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166199);
      throw paramaw;
      bool = false;
      break;
      label640:
      i = 0;
      break label470;
      label645:
      localObject1 = this.gAI;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      localObject3 = (Context)this;
      localObject4 = getContext();
      d.g.b.k.g(localObject4, "context");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)((AppCompatActivity)localObject4).getResources().getString(2131759171, new Object[] { ((com.tencent.mm.plugin.finder.api.f)localObject2).field_signature })));
      localObject1 = this.gAI;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((TextView)localObject1).setVisibility(0);
      localObject1 = this.gAI;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((TextView)localObject1).setOnLongClickListener((View.OnLongClickListener)new u(this, paramBoolean, paramaw));
      break label498;
      label782:
      cwc();
    }
    label789:
    localObject1 = (String)localObject1;
    if (!bs.isNullOrNil((String)localObject1))
    {
      ((v.f)localObject3).KUQ = localObject1;
      ac.i(this.TAG, "use localCoverImg " + (String)((v.f)localObject3).KUQ);
    }
    if (!bs.isNullOrNil((String)((v.f)localObject3).KUQ))
    {
      localObject1 = (String)((v.f)localObject3).KUQ;
      d.g.b.k.g(localObject1, "path");
      localObject4 = p.rQw;
      if (d.n.n.nb((String)localObject1, p.cDo()))
      {
        localObject1 = this.rqL;
        if (localObject1 == null) {
          d.g.b.k.aVY("defaultHeaderBg");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = (String)((v.f)localObject3).KUQ;
        d.g.b.k.g(localObject1, "path");
        adD((String)localObject1);
      }
    }
    else
    {
      label938:
      localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo;
      localObject3 = this.rrb;
      if (localObject3 == null) {
        d.g.b.k.aVY("authGeneratorTv");
      }
      ((TextView)localObject3).setVisibility(8);
      if (localObject1 == null) {
        break label1883;
      }
      if (((FinderAuthInfo)localObject1).authIconType <= 0) {
        break label1859;
      }
      localObject3 = this.rrb;
      if (localObject3 == null) {
        d.g.b.k.aVY("authGeneratorTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new w((com.tencent.mm.plugin.finder.api.f)localObject2, this, paramBoolean, paramaw));
      localObject3 = this.rra;
      if (localObject3 == null) {
        d.g.b.k.aVY("authByTv");
      }
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)new x((com.tencent.mm.plugin.finder.api.f)localObject2, this, paramBoolean, paramaw));
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        label1096:
        if ((((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo == null) || ((bs.isNullOrNil(((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo.appName)) && (bs.isNullOrNil(((com.tencent.mm.plugin.finder.api.f)localObject2).field_authInfo.detailLink))) || (1 == ((FinderAuthInfo)localObject1).authIconType))
        {
          paramaw = this.rrc;
          if (paramaw == null) {
            d.g.b.k.aVY("authArrowIv");
          }
          paramaw.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      cwe();
      paramaw = y.KTp;
      AppMethodBeat.o(166199);
      return;
      label1177:
      localObject1 = "";
      break;
      localObject1 = this.rqL;
      if (localObject1 == null) {
        d.g.b.k.aVY("defaultHeaderBg");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = (String)((v.f)localObject3).KUQ;
      d.g.b.k.g(localObject1, "path");
      localObject1 = new com.tencent.mm.plugin.finder.loader.d((String)localObject1);
      if (com.tencent.mm.vfs.i.eA(((com.tencent.mm.plugin.finder.loader.d)localObject1).getPath()))
      {
        adD(((com.tencent.mm.plugin.finder.loader.d)localObject1).getPath());
        break label938;
      }
      localObject4 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject1 = com.tencent.mm.plugin.finder.loader.h.cwn().bG(localObject1);
      localObject4 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject1 = ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.h.a(h.a.rtT)).a((com.tencent.mm.loader.f.d)new v((v.f)localObject3, this, paramBoolean, paramaw));
      localObject3 = this.rqM;
      if (localObject3 == null) {
        d.g.b.k.aVY("headerBg");
      }
      ((com.tencent.mm.loader.b)localObject1).c((ImageView)localObject3);
      break label938;
      paramaw = this.rqZ;
      if (paramaw == null) {
        d.g.b.k.aVY("authIcon");
      }
      paramaw.setVisibility(0);
      paramaw = this.rqZ;
      if (paramaw == null) {
        d.g.b.k.aVY("authIcon");
      }
      paramaw.setImageDrawable(am.k((Context)this, 2131690481, getResources().getColor(2131099777)));
      paramaw = ((FinderAuthInfo)localObject1).authProfession;
      if (paramaw != null)
      {
        localObject3 = this.rra;
        if (localObject3 == null) {
          d.g.b.k.aVY("authByTv");
        }
        ((TextView)localObject3).setVisibility(0);
        localObject3 = this.rra;
        if (localObject3 == null) {
          d.g.b.k.aVY("authByTv");
        }
        ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { paramaw }));
        paramaw = this.rra;
        if (paramaw == null) {
          d.g.b.k.aVY("authByTv");
        }
        paramaw.setOnClickListener(null);
        paramaw = y.KTp;
      }
      paramaw = this.rqW;
      if (paramaw == null) {
        d.g.b.k.aVY("authLayout");
      }
      paramaw.setVisibility(0);
      break label1096;
      paramaw = this.rqZ;
      if (paramaw == null) {
        d.g.b.k.aVY("authIcon");
      }
      paramaw.setVisibility(0);
      paramaw = this.rrb;
      if (paramaw == null) {
        d.g.b.k.aVY("authGeneratorTv");
      }
      paramaw.setVisibility(8);
      paramaw = this.rqW;
      if (paramaw == null) {
        d.g.b.k.aVY("authLayout");
      }
      paramaw.setVisibility(0);
      paramaw = this.rqZ;
      if (paramaw == null) {
        d.g.b.k.aVY("authIcon");
      }
      paramaw.setImageDrawable(am.k((Context)this, 2131690481, getResources().getColor(2131099748)));
      paramaw = ((FinderAuthInfo)localObject1).authProfession;
      if (paramaw == null) {
        break label1096;
      }
      localObject3 = this.rra;
      if (localObject3 == null) {
        d.g.b.k.aVY("authByTv");
      }
      ((TextView)localObject3).setVisibility(0);
      localObject3 = this.rra;
      if (localObject3 == null) {
        d.g.b.k.aVY("authByTv");
      }
      ((TextView)localObject3).setText((CharSequence)getResources().getString(2131759170, new Object[] { paramaw }));
      paramaw = y.KTp;
      break label1096;
      paramaw = this.rqW;
      if (paramaw == null) {
        d.g.b.k.aVY("authLayout");
      }
      paramaw.setVisibility(0);
      paramaw = this.rrb;
      if (paramaw == null) {
        d.g.b.k.aVY("authGeneratorTv");
      }
      paramaw.setVisibility(8);
      paramaw = this.rrc;
      if (paramaw == null) {
        d.g.b.k.aVY("authArrowIv");
      }
      paramaw.setVisibility(8);
      paramaw = this.rqZ;
      if (paramaw == null) {
        d.g.b.k.aVY("authIcon");
      }
      paramaw.setVisibility(8);
      paramaw = this.rra;
      if (paramaw == null) {
        d.g.b.k.aVY("authByTv");
      }
      paramaw.setOnClickListener(null);
      paramaw = this.rra;
      if (paramaw == null) {
        d.g.b.k.aVY("authByTv");
      }
      paramaw.setText(2131759236);
      break label1096;
      paramaw = this.rrc;
      if (paramaw == null) {
        d.g.b.k.aVY("authArrowIv");
      }
      paramaw.setVisibility(0);
      continue;
      label1859:
      paramaw = this.rqW;
      if (paramaw == null) {
        d.g.b.k.aVY("authLayout");
      }
      paramaw.setVisibility(8);
      continue;
      label1883:
      paramaw = this.rqW;
      if (paramaw == null) {
        d.g.b.k.aVY("authLayout");
      }
      paramaw.setVisibility(8);
      continue;
      label1907:
      paramaw = findViewById(2131305143);
      d.g.b.k.g(paramaw, "findViewById<TextView>(R.id.spam_tip_tv)");
      ((TextView)paramaw).setText((CharSequence)getString(2131759358));
      if (aj.aG((Context)this)) {
        getContentView().setPadding(0, aj.aF((Context)this), 0, 0);
      }
      paramaw = this.rrq;
      if (paramaw == null) {
        d.g.b.k.aVY("finderSpamContactTipView");
      }
      paramaw.setVisibility(0);
    }
    label1989:
    AppMethodBeat.o(166199);
  }
  
  private final void a(boolean paramBoolean, String paramString, aw paramaw)
  {
    AppMethodBeat.i(166197);
    FinderProfileUI.b localb = (FinderProfileUI.b)rrH.get(paramString);
    if (localb == null) {
      localb = new FinderProfileUI.b(new LinkedList());
    }
    for (;;)
    {
      d.g.b.k.g(localb, "userExtInfoLocalMap[user…nfo(-1, -1, LinkedList())");
      if (paramaw != null)
      {
        localb.fansCount = paramaw.fansCount;
        localb.friendFollowCount = paramaw.friendFollowCount;
        paramaw = paramaw.userTags;
        d.g.b.k.h(paramaw, "<set-?>");
        localb.userTags = paramaw;
        ((Map)rrH).put(paramString, localb);
      }
      paramString = new LinkedList((Collection)localb.userTags);
      paramaw = this.rrA;
      if ((paramaw == null) || (paramaw.field_originalFlag != 2))
      {
        paramaw = this.rqX;
        if (paramaw == null) {
          d.g.b.k.aVY("userOriginalTag");
        }
        paramaw.setVisibility(8);
      }
      if (paramString.isEmpty())
      {
        paramString = this.rqY;
        if (paramString == null) {
          d.g.b.k.aVY("userTagLayout");
        }
        paramString.setVisibility(4);
        if ((localb.friendFollowCount <= 0) || (paramBoolean)) {
          break label484;
        }
        paramString = this.rqP;
        if (paramString == null) {
          d.g.b.k.aVY("friendFollowLayout");
        }
        paramString.setVisibility(0);
        paramString = this.rqR;
        if (paramString == null) {
          d.g.b.k.aVY("friendFollowTv");
        }
        paramaw = getContext();
        d.g.b.k.g(paramaw, "context");
        paramString.setText((CharSequence)paramaw.getResources().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.g.Ew(localb.friendFollowCount) }));
      }
      for (;;)
      {
        if ((localb.fansCount <= 0) || (!paramBoolean)) {
          break label508;
        }
        paramString = this.rqO;
        if (paramString == null) {
          d.g.b.k.aVY("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.rqQ;
        if (paramString == null) {
          d.g.b.k.aVY("fansTv");
        }
        paramaw = getContext();
        d.g.b.k.g(paramaw, "context");
        paramString.setText((CharSequence)paramaw.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.g.Ew(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
        paramaw = this.rqY;
        if (paramaw == null) {
          d.g.b.k.aVY("userTagLayout");
        }
        paramaw.setVisibility(0);
        paramaw = new StringBuilder();
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext()) {
          paramaw.append((String)paramString.next()).append(" ");
        }
        paramString = this.rqY;
        if (paramString == null) {
          d.g.b.k.aVY("userTagLayout");
        }
        paramString.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)paramaw.toString()));
        break;
        label484:
        paramString = this.rqP;
        if (paramString == null) {
          d.g.b.k.aVY("friendFollowLayout");
        }
        paramString.setVisibility(8);
      }
      label508:
      paramString = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czx())
      {
        paramString = this.rqO;
        if (paramString == null) {
          d.g.b.k.aVY("fansLayout");
        }
        paramString.setVisibility(0);
        paramString = this.rqQ;
        if (paramString == null) {
          d.g.b.k.aVY("fansTv");
        }
        paramaw = getContext();
        d.g.b.k.g(paramaw, "context");
        paramString.setText((CharSequence)paramaw.getResources().getString(2131759206, new Object[] { com.tencent.mm.plugin.finder.utils.g.Ew(localb.fansCount) }));
        AppMethodBeat.o(166197);
        return;
      }
      paramString = this.rqO;
      if (paramString == null) {
        d.g.b.k.aVY("fansLayout");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(166197);
      return;
    }
  }
  
  private void adD(String paramString)
  {
    AppMethodBeat.i(166210);
    d.g.b.k.h(paramString, "path");
    Object localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
    localObject = this.rqM;
    if (localObject == null) {
      d.g.b.k.aVY("headerBg");
    }
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    int i = com.tencent.mm.plugin.finder.storage.b.cym();
    localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    com.tencent.mm.plugin.finder.utils.n.a((ImageView)localObject, paramString, i, com.tencent.mm.plugin.finder.storage.b.cym());
    AppMethodBeat.o(166210);
  }
  
  private final int cvZ()
  {
    AppMethodBeat.i(166194);
    int i = aj.fH((Context)getContext()).x;
    AppMethodBeat.o(166194);
    return i;
  }
  
  private final boolean cwa()
  {
    AppMethodBeat.i(166195);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GTW, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(166195);
      throw ((Throwable)localObject);
    }
    if (bs.isNullOrNil((String)localObject))
    {
      localObject = this.rrA;
      if (localObject == null) {
        break label112;
      }
      localObject = ((com.tencent.mm.plugin.finder.api.f)localObject).field_coverImg;
      if (bs.isNullOrNil((String)localObject)) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool = true;; bool = false)
    {
      ac.i(this.TAG, "hasSetCoverImg ".concat(String.valueOf(bool)));
      AppMethodBeat.o(166195);
      return bool;
      localObject = null;
      break;
    }
  }
  
  private final void cwb()
  {
    AppMethodBeat.i(166196);
    if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())
    {
      View localView = this.rrn;
      if (localView == null) {
        d.g.b.k.aVY("actionBarPhotoBtn");
      }
      localView.setVisibility(0);
    }
    AppMethodBeat.o(166196);
  }
  
  private final void cwc()
  {
    AppMethodBeat.i(166201);
    Object localObject1 = this.rrp;
    if (localObject1 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject1).setText(2131759228);
    localObject1 = this.rrp;
    if (localObject1 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject1).setBackgroundResource(2131232363);
    localObject1 = this.rrp;
    if (localObject1 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject1).setTextColor(getResources().getColor(2131099828));
    localObject1 = this.rqV;
    if (localObject1 == null) {
      d.g.b.k.aVY("followBtnTv");
    }
    ((TextView)localObject1).setText(2131759228);
    localObject1 = this.rqV;
    if (localObject1 == null) {
      d.g.b.k.aVY("followBtnTv");
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(2131099828));
    localObject1 = this.rqU;
    if (localObject1 == null) {
      d.g.b.k.aVY("followBtn");
    }
    ((View)localObject1).setBackgroundResource(2131232363);
    localObject1 = (d.g.a.b)new z(this);
    Object localObject2 = this.rqU;
    if (localObject2 == null) {
      d.g.b.k.aVY("followBtn");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new a((d.g.a.b)localObject1));
    localObject2 = this.rrp;
    if (localObject2 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject2).setOnClickListener((View.OnClickListener)new a((d.g.a.b)localObject1));
    AppMethodBeat.o(166201);
  }
  
  private final void cwd()
  {
    AppMethodBeat.i(166202);
    Object localObject1 = this.rqV;
    if (localObject1 == null) {
      d.g.b.k.aVY("followBtnTv");
    }
    ((TextView)localObject1).setText(2131759384);
    localObject1 = this.rrp;
    if (localObject1 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject1).setText(2131759384);
    localObject1 = this.rrp;
    if (localObject1 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject1).setTextColor(getResources().getColor(2131100711));
    localObject1 = this.rrp;
    if (localObject1 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject1).setBackgroundResource(2131232364);
    localObject1 = this.rqV;
    if (localObject1 == null) {
      d.g.b.k.aVY("followBtnTv");
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(2131100711));
    localObject1 = this.rqU;
    if (localObject1 == null) {
      d.g.b.k.aVY("followBtn");
    }
    ((View)localObject1).setBackgroundResource(2131232364);
    localObject1 = (d.g.a.b)new y(this);
    Object localObject2 = this.rqU;
    if (localObject2 == null) {
      d.g.b.k.aVY("followBtn");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new a((d.g.a.b)localObject1));
    localObject2 = this.rrp;
    if (localObject2 == null) {
      d.g.b.k.aVY("actionBarFollowBtn");
    }
    ((Button)localObject2).setOnClickListener((View.OnClickListener)new a((d.g.a.b)localObject1));
    AppMethodBeat.o(166202);
  }
  
  private final void cwe()
  {
    AppMethodBeat.i(166209);
    if ((cwa()) && (this.rrD < 0.5F))
    {
      ac.d(this.TAG, "checkActionBarIconColor White, " + this.rrD);
      localWeImageView = this.rrg;
      if (localWeImageView == null) {
        d.g.b.k.aVY("actionBarBackIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.rro;
      if (localWeImageView == null) {
        d.g.b.k.aVY("actionBarPhotoIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      localWeImageView = this.rrm;
      if (localWeImageView == null) {
        d.g.b.k.aVY("actionBarMoreIv");
      }
      localWeImageView.setIconColor(getResources().getColor(2131099828));
      AppMethodBeat.o(166209);
      return;
    }
    ac.d(this.TAG, "checkActionBarIconColor black_color, " + this.rrD);
    WeImageView localWeImageView = this.rrg;
    if (localWeImageView == null) {
      d.g.b.k.aVY("actionBarBackIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.rro;
    if (localWeImageView == null) {
      d.g.b.k.aVY("actionBarPhotoIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    localWeImageView = this.rrm;
    if (localWeImageView == null) {
      d.g.b.k.aVY("actionBarMoreIv");
    }
    localWeImageView.setIconColor(getResources().getColor(2131100018));
    AppMethodBeat.o(166209);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202460);
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
    AppMethodBeat.o(202460);
    return localView1;
  }
  
  public final int cuI()
  {
    int j = 0;
    AppMethodBeat.i(202457);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (d.g.b.k.g(str, u.axE()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(202457);
      return 33;
    }
    AppMethodBeat.o(202457);
    return 32;
  }
  
  public final int cvJ()
  {
    return 3;
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
    if (paramInt1 == this.rru)
    {
      ac.d(this.TAG, "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
      localObject1 = getApplicationContext();
      localObject2 = p.rQw;
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.q.h((Context)localObject1, paramIntent, p.cDo());
      if (this.filePath == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      localObject1 = d.g.b.k.E(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject2 = d.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(166208);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      d.g.b.k.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject2 = new StringBuilder();
      localObject3 = p.rQw;
      localObject2 = ((StringBuilder)localObject2).append(p.cDo());
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      paramIntent.putExtra("CropImage_OutputPath", (String)localObject1);
      paramIntent.setClassName((Context)this, "com.tencent.mm.ui.tools.CropImageNewUI");
      getContext().startActivityForResult(paramIntent, this.rrv);
      AppMethodBeat.o(166208);
      return;
    }
    Object localObject4;
    if (paramInt1 == this.rrt)
    {
      ac.d(this.TAG, "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = paramIntent.getData();
      d.g.b.k.g(localObject1, "data.data");
      this.filePath = ((Uri)localObject1).getPath();
      ac.i(this.TAG, "filePath[" + this.filePath + "] " + paramIntent);
      if (this.filePath == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      localObject1 = (Activity)this;
      paramInt1 = this.rrv;
      localObject2 = this.filePath;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      localObject3 = d.g.b.k.E(this.filePath, Long.valueOf(System.currentTimeMillis()));
      localObject4 = d.n.d.UTF_8;
      if (localObject3 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
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
    if (paramInt1 == this.rrv)
    {
      ac.d(this.TAG, "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
      if (paramIntent == null)
      {
        AppMethodBeat.o(166208);
        return;
      }
      this.filePath = paramIntent.getStringExtra("key_result_img_path");
      if ((this.filePath == null) || (!com.tencent.mm.vfs.i.eA(this.filePath)))
      {
        ac.e(this.TAG, "ERROR! filePath=" + this.filePath);
        AppMethodBeat.o(166208);
        return;
      }
      ac.d(this.TAG, "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
      paramIntent = this.rrA;
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GTW, this.filePath);
        localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
        b.a.b(paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.upload.f.rNg;
        paramIntent = com.tencent.mm.plugin.finder.upload.f.cCv();
        localObject1 = this.filePath;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject2 = this.username;
        if (localObject2 == null) {
          d.g.b.k.aVY("username");
        }
        localObject3 = (com.tencent.mm.loader.g.f)new p(this);
        d.g.b.k.h(localObject1, "path");
        d.g.b.k.h(localObject2, "userName");
        d.g.b.k.h(localObject3, "callback");
        paramIntent.rNa.a((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.i((String)localObject1, (String)localObject2), (com.tencent.mm.loader.g.f)localObject3);
      }
      paramIntent = this.filePath;
      if (paramIntent == null) {
        d.g.b.k.fOy();
      }
      adD(paramIntent);
      cwe();
      AppMethodBeat.o(166208);
      return;
    }
    if ((paramInt1 == this.rrw) && (paramIntent != null))
    {
      localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
      localObject1 = u.axE();
      d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject4 = b.a.adh((String)localObject1);
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
      ac.i(this.TAG, "countryCode " + (String)localObject1 + " provinceCode" + (String)localObject2 + " cityCode" + paramIntent);
      if (!d.g.b.k.g(localObject1, "unshow")) {
        break label1161;
      }
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      paramInt1 = ((com.tencent.mm.kernel.e)localObject1).agA().getInt(ah.a.GUq, 0);
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GUq, Integer.valueOf(paramInt1 & 0xFFFFFFFB));
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
        ((aje)localObject3).country = ((String)localObject1);
        ((aje)localObject3).exV = ((String)localObject2);
      }
      for (((aje)localObject3).exW = paramIntent;; ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo.exW = paramIntent)
      {
        localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
        b.a.b((com.tencent.mm.plugin.finder.api.f)localObject4);
        ((com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class)).a((String)localObject1, (String)localObject2, paramIntent, paramInt1, null);
        AppMethodBeat.o(166208);
        return;
        label1117:
        ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo = new aje();
        ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo.country = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.api.f)localObject4).field_extInfo.exV = ((String)localObject2);
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
      d.g.b.k.aVY("username");
    }
    ac.i(paramBundle, "username %s", new Object[] { localObject1 });
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.k.aVY("username");
    }
    if (bs.isNullOrNil(paramBundle)) {
      finish();
    }
    this.riv = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.k.aVY("username");
    }
    if ((paramBundle.equals(u.axE())) && (this.riv)) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      this.dfZ = bool;
      paramBundle = com.tencent.mm.plugin.finder.api.b.qWt;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.k.aVY("username");
      }
      this.rrA = b.a.adh(paramBundle);
      this.dng = getIntent().getStringExtra("from_user");
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
          d.g.b.k.fOy();
        }
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle = getSupportActionBar();
        if (paramBundle == null) {
          d.g.b.k.fOy();
        }
        paramBundle.hide();
      }
      paramBundle = getLayoutInflater().inflate(2131494100, null);
      d.g.b.k.g(paramBundle, "layoutInflater.inflate(R…_profile_ui_header, null)");
      this.rjd = paramBundle;
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300045);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…profile_header_bg_layout)");
      this.rqK = paramBundle;
      paramBundle = this.rqK;
      if (paramBundle == null) {
        d.g.b.k.aVY("headerBgLayout");
      }
      paramBundle = paramBundle.getLayoutParams();
      i = cvZ();
      paramBundle.height = i;
      paramBundle.width = i;
      localObject1 = this.rqK;
      if (localObject1 == null) {
        d.g.b.k.aVY("headerBgLayout");
      }
      ((View)localObject1).setLayoutParams(paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300046);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_header_iv)");
      this.rqM = ((ImageView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300033);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…rofile_default_header_iv)");
      this.rqL = ((ImageView)paramBundle);
      if (aj.DT())
      {
        paramBundle = this.rqL;
        if (paramBundle == null) {
          d.g.b.k.aVY("defaultHeaderBg");
        }
        paramBundle.setImageResource(2131232366);
      }
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300047);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…er_profile_header_tip_tv)");
      this.rqN = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300032);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_avatar_btn)");
      this.fxQ = ((ImageView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300039);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…nder_profile_fans_layout)");
      this.rqO = ((ViewGroup)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300043);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…ile_friend_follow_layout)");
      this.rqP = ((ViewGroup)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300040);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_fans_tv)");
      this.rqQ = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300044);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…profile_friend_follow_tv)");
      this.rqR = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300035);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_btn)");
      this.rqS = paramBundle;
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300036);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_edit_ll)");
      this.rqT = paramBundle;
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300041);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_follow_btn)");
      this.rqU = paramBundle;
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300042);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…er_profile_follow_btn_tv)");
      this.rqV = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300056);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_name_tv)");
      this.iIU = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300031);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…nder_profile_auth_layout)");
      this.rqW = ((ViewGroup)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131307898);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.original_tag_tv)");
      this.rqX = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131306249);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.user_tag_layout)");
      this.rqY = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300030);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_icon)");
      this.rqZ = ((ImageView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300028);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_auth_by)");
      this.rra = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300029);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…r_profile_auth_generator)");
      this.rrb = ((TextView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300027);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_auth_arrow)");
      this.rrc = ((ImageView)paramBundle);
      paramBundle = getContext();
      d.g.b.k.g(paramBundle, "context");
      i = paramBundle.getResources().getColor(2131099735);
      paramBundle = this.rrc;
      if (paramBundle == null) {
        d.g.b.k.aVY("authArrowIv");
      }
      paramBundle.setImageDrawable(am.k((Context)getContext(), 2131690517, i));
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300037);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id…inder_profile_fans_arrow)");
      this.rrd = ((ImageView)paramBundle);
      paramBundle = this.rjd;
      if (paramBundle == null) {
        d.g.b.k.aVY("header");
      }
      paramBundle = paramBundle.findViewById(2131300034);
      d.g.b.k.g(paramBundle, "header.findViewById(R.id.finder_profile_desc_tv)");
      this.gAI = ((TextView)paramBundle);
      paramBundle = this.iIU;
      if (paramBundle == null) {
        d.g.b.k.aVY("nickNameTv");
      }
      paramBundle.setTextSize(1, 17.0F);
      paramBundle = this.rqV;
      if (paramBundle == null) {
        d.g.b.k.aVY("followBtnTv");
      }
      aj.a((Paint)paramBundle.getPaint(), 0.8F);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctP(), (LifecycleOwner)this, (Observer)new l(this));
      paramBundle = this.rqT;
      if (paramBundle == null) {
        d.g.b.k.aVY("editLl");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new m(this));
      if (!this.dfZ) {
        break;
      }
      paramBundle = this.rqT;
      if (paramBundle == null) {
        d.g.b.k.aVY("editLl");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.rqU;
      if (paramBundle == null) {
        d.g.b.k.aVY("followBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.rqO;
      if (paramBundle == null) {
        d.g.b.k.aVY("fansLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.rqP;
      if (paramBundle == null) {
        d.g.b.k.aVY("friendFollowLayout");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.rrd;
      if (paramBundle == null) {
        d.g.b.k.aVY("fansArrowIv");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.rqN;
      if (paramBundle == null) {
        d.g.b.k.aVY("headerTip");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.rqM;
      if (paramBundle == null) {
        d.g.b.k.aVY("headerBg");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new n(this));
      paramBundle = this.rqO;
      if (paramBundle == null) {
        d.g.b.k.aVY("fansLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new o(this));
      bool = this.dfZ;
      paramBundle = this.username;
      if (paramBundle == null) {
        d.g.b.k.aVY("username");
      }
      a(bool, paramBundle, null);
      paramBundle = findViewById(2131305141);
      d.g.b.k.g(paramBundle, "findViewById(R.id.spam_actionbar_back_btn)");
      this.rrr = paramBundle;
      paramBundle = findViewById(2131300072);
      d.g.b.k.g(paramBundle, "findViewById(R.id.finder_spam_contact_tip_view)");
      this.rrq = paramBundle;
      paramBundle = findViewById(2131303475);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_main_rv)");
      this.rqJ = paramBundle;
      paramBundle = this.rqJ;
      if (paramBundle == null) {
        d.g.b.k.aVY("rlContainer");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle != null) {
        break label2063;
      }
      paramBundle = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(166193);
      throw paramBundle;
    }
    paramBundle = this.rqT;
    if (paramBundle == null) {
      d.g.b.k.aVY("editLl");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.rrd;
    if (paramBundle == null) {
      d.g.b.k.aVY("fansArrowIv");
    }
    paramBundle.setVisibility(8);
    paramBundle = this.username;
    if (paramBundle == null) {
      d.g.b.k.aVY("username");
    }
    if (paramBundle.equals(u.axE()))
    {
      paramBundle = this.rqU;
      if (paramBundle == null) {
        d.g.b.k.aVY("followBtn");
      }
      paramBundle.setVisibility(8);
      label1832:
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czx()) {
        break label2039;
      }
      paramBundle = rrH;
      localObject1 = this.username;
      if (localObject1 == null) {
        d.g.b.k.aVY("username");
      }
      paramBundle = (FinderProfileUI.b)paramBundle.get(localObject1);
      if (paramBundle == null) {
        break label2034;
      }
      i = paramBundle.fansCount;
      label1882:
      if (i <= 0) {
        break label2039;
      }
      paramBundle = this.rqO;
      if (paramBundle == null) {
        d.g.b.k.aVY("fansLayout");
      }
      paramBundle.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = this.rqO;
      if (paramBundle == null) {
        d.g.b.k.aVY("fansLayout");
      }
      paramBundle.setBackground(null);
      paramBundle = this.rqP;
      if (paramBundle == null) {
        d.g.b.k.aVY("friendFollowLayout");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.rqN;
      if (paramBundle == null) {
        d.g.b.k.aVY("headerTip");
      }
      paramBundle.setVisibility(8);
      break;
      if (((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).showFinderEntry())
      {
        paramBundle = this.rqU;
        if (paramBundle == null) {
          d.g.b.k.aVY("followBtn");
        }
        paramBundle.setVisibility(0);
        break label1832;
      }
      paramBundle = this.rqU;
      if (paramBundle == null) {
        d.g.b.k.aVY("followBtn");
      }
      paramBundle.setVisibility(8);
      break label1832;
      label2034:
      i = 0;
      break label1882;
      label2039:
      paramBundle = this.rqO;
      if (paramBundle == null) {
        d.g.b.k.aVY("fansLayout");
      }
      paramBundle.setVisibility(8);
    }
    label2063:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    paramBundle.topMargin = (0 - cvZ() / 2);
    localObject1 = this.rqJ;
    if (localObject1 == null) {
      d.g.b.k.aVY("rlContainer");
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)paramBundle);
    paramBundle = findViewById(2131304203);
    d.g.b.k.g(paramBundle, "findViewById(R.id.rl_layout)");
    this.rfT = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    localObject1 = z.jD((Context)getContext()).inflate(2131494590, null);
    d.g.b.k.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    paramBundle.getRecyclerView().setVisibility(0);
    paramBundle = this.rfT;
    if (paramBundle == null) {
      d.g.b.k.aVY("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(true);
    paramBundle = (MMActivity)this;
    localObject1 = this.username;
    if (localObject1 == null) {
      d.g.b.k.aVY("username");
    }
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    this.riT = new FinderProfileUIContract.a(paramBundle, (String)localObject1);
    paramBundle = (MMActivity)this;
    localObject1 = this.riT;
    if (localObject1 == null) {
      d.g.b.k.aVY("presenter");
    }
    Object localObject2 = this.rjd;
    if (localObject2 == null) {
      d.g.b.k.aVY("header");
    }
    this.viewCallback = new FinderProfileUIContract.ProfileViewCallback(paramBundle, (FinderProfileUIContract.a)localObject1, (View)localObject2, this.riv);
    paramBundle = this.viewCallback;
    if (paramBundle == null) {
      d.g.b.k.aVY("viewCallback");
    }
    localObject1 = (RecyclerView.m)this.rrE;
    d.g.b.k.h(localObject1, "listener");
    paramBundle.fuK = ((RecyclerView.m)localObject1);
    paramBundle = this.riT;
    if (paramBundle == null) {
      d.g.b.k.aVY("presenter");
    }
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    paramBundle.a((FinderProfileUIContract.ProfileViewCallback)localObject1);
    localObject1 = this.viewCallback;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    ac.i(((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG, "initView");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rgm.eL((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).iMV);
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fTr;
    if (paramBundle == null) {
      d.g.b.k.aVY("layoutManager");
    }
    ((RecyclerView)localObject2).setLayoutManager(paramBundle);
    paramBundle = new FinderProfileUIContract.ProfileViewCallback.b((FinderProfileUIContract.ProfileViewCallback)localObject1);
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).fTr.setAdapter((RecyclerView.a)paramBundle);
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).rfT.setActionCallback((RefreshLoadMoreLayout.a)new FinderProfileUIContract.ProfileViewCallback.d((FinderProfileUIContract.ProfileViewCallback)localObject1));
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rgm.getItemDecoration();
    ((FinderProfileUIContract.ProfileViewCallback)localObject1).fTr.b(paramBundle);
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fuK;
    if (paramBundle != null) {
      ((FinderProfileUIContract.ProfileViewCallback)localObject1).fTr.a(paramBundle);
    }
    paramBundle = FinderReporterUIC.seQ;
    paramBundle = FinderReporterUIC.a.eV((Context)((FinderProfileUIContract.ProfileViewCallback)localObject1).iMV);
    if (paramBundle != null)
    {
      paramBundle = FinderReporterUIC.d(paramBundle);
      if (paramBundle != null) {
        paramBundle.s(((FinderProfileUIContract.ProfileViewCallback)localObject1).fTr);
      }
    }
    localObject2 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).TAG;
    Object localObject3 = new StringBuilder("start rxPipeLine, rlLayout.actionCallback hashCode:");
    paramBundle = ((FinderProfileUIContract.ProfileViewCallback)localObject1).rfT.getActionCallback();
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.hashCode());
      ac.i((String)localObject2, paramBundle);
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new FinderProfileUIContract.ProfileViewCallback.e((FinderProfileUIContract.ProfileViewCallback)localObject1));
      paramBundle = this.viewCallback;
      if (paramBundle == null) {
        d.g.b.k.aVY("viewCallback");
      }
      ((BaseFinderFeedLoader)paramBundle.riT.cuV()).register(paramBundle.rgg, paramBundle.iMV);
      paramBundle = findViewById(2131303443);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_actionbar_container)");
      this.rre = paramBundle;
      paramBundle = findViewById(2131296397);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_back_btn)");
      this.rrf = paramBundle;
      paramBundle = findViewById(2131296398);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_back_iv)");
      this.rrg = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303508);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_user_info_layout)");
      this.rrh = paramBundle;
      paramBundle = findViewById(2131303491);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_right_icons_layout)");
      this.rri = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131296395);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_avatar_iv)");
      this.rrj = ((ImageView)paramBundle);
      paramBundle = findViewById(2131296407);
      d.g.b.k.g(paramBundle, "findViewById(R.id.actionbar_nickname_tv)");
      this.rrk = ((TextView)paramBundle);
      paramBundle = findViewById(2131302457);
      d.g.b.k.g(paramBundle, "findViewById(R.id.more_btn)");
      this.rrl = paramBundle;
      paramBundle = findViewById(2131302474);
      d.g.b.k.g(paramBundle, "findViewById(R.id.more_iv)");
      this.rrm = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131305644);
      d.g.b.k.g(paramBundle, "findViewById(R.id.takephoto_btn)");
      this.rrn = paramBundle;
      paramBundle = findViewById(2131305645);
      d.g.b.k.g(paramBundle, "findViewById(R.id.takephoto_iv)");
      this.rro = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131303444);
      d.g.b.k.g(paramBundle, "findViewById(R.id.profile_actionbar_follow_btn)");
      this.rrp = ((Button)paramBundle);
      if (com.tencent.mm.ui.statusbar.c.ILV)
      {
        this.rrB = ((c.a)new g(this));
        com.tencent.mm.ui.statusbar.c.bm((Activity)this).a(this.rrB);
        com.tencent.mm.ui.statusbar.d.b(getWindow());
      }
      paramBundle = this.rrf;
      if (paramBundle == null) {
        d.g.b.k.aVY("actionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
      paramBundle = this.rrr;
      if (paramBundle == null) {
        d.g.b.k.aVY("finderSpamActionBarBackBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new i(this));
      setActionbarColor(getResources().getColor(2131101053));
      paramBundle = this.rrh;
      if (paramBundle == null) {
        d.g.b.k.aVY("userInfoLayout");
      }
      paramBundle.setAlpha(0.0F);
      paramBundle = this.rrp;
      if (paramBundle == null) {
        d.g.b.k.aVY("actionBarFollowBtn");
      }
      paramBundle.setVisibility(8);
      cwe();
      if (!cwa()) {
        break label3711;
      }
      paramBundle = this.rre;
      if (paramBundle == null) {
        d.g.b.k.aVY("myActionBar");
      }
      paramBundle.setBackgroundColor(getResources().getColor(2131101053));
      paramBundle = this.rre;
      if (paramBundle == null) {
        d.g.b.k.aVY("myActionBar");
      }
      paramBundle.setBackgroundResource(2131233659);
      label3174:
      if (!this.dfZ) {
        break label3757;
      }
      cwb();
      paramBundle = this.rrl;
      if (paramBundle == null) {
        d.g.b.k.aVY("actionBarMoreBtn");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.rrn;
      if (paramBundle == null) {
        d.g.b.k.aVY("actionBarPhotoBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new j(this));
      label3236:
      if (this.dfZ)
      {
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(106, (com.tencent.mm.plugin.finder.api.e)this.rrG);
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.e)this.rrG);
      }
      paramBundle = com.tencent.mm.ui.component.a.IrY;
      i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).ser;
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (this.dfZ)
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czE() != 1)
        {
          paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (com.tencent.mm.plugin.finder.storage.b.czF())
          {
            paramBundle = com.tencent.mm.ui.component.a.IrY;
            paramBundle = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class)).sbI;
            if (paramBundle != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
              localObject1 = u.axE();
              d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
              localObject1 = b.a.adh((String)localObject1);
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_extInfo;
                if (localObject1 != null)
                {
                  if (((d.g.b.k.g(paramBundle.iKc, ((aje)localObject1).country) ^ true)) || ((d.g.b.k.g(paramBundle.iJU, ((aje)localObject1).exV) ^ true)) || ((d.g.b.k.g(paramBundle.iJV, ((aje)localObject1).exW) ^ true)))
                  {
                    localObject1 = com.tencent.mm.kernel.g.agR();
                    d.g.b.k.g(localObject1, "MMKernel.storage()");
                    ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GVC, Long.valueOf(1L));
                    localObject1 = com.tencent.mm.ui.component.a.IrY;
                    localObject1 = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class)).sbI;
                    if (localObject1 != null)
                    {
                      localObject2 = (Context)this;
                      localObject3 = com.tencent.mm.plugin.finder.utils.n.rPN;
                      localObject3 = ((awb)localObject1).iKc;
                      d.g.b.k.g(localObject3, "it.Country");
                      String str1 = ((awb)localObject1).iJU;
                      d.g.b.k.g(str1, "it.Province");
                      String str2 = ((awb)localObject1).iJV;
                      d.g.b.k.g(str2, "it.City");
                      com.tencent.mm.ui.base.h.a((Context)localObject2, getString(2131759248, new Object[] { com.tencent.mm.plugin.finder.utils.n.ab((String)localObject3, str1, str2) }), "", getString(2131759347), getString(2131755691), true, (DialogInterface.OnClickListener)new q((awb)localObject1, paramBundle, this), (DialogInterface.OnClickListener)new r(paramBundle, this));
                      AppMethodBeat.o(166193);
                      return;
                      paramBundle = null;
                      break;
                      label3711:
                      if (aj.DT())
                      {
                        this.mController.setStatusBarColor(getResources().getColor(2131099816));
                        break label3174;
                      }
                      this.mController.setStatusBarColor(getResources().getColor(2131099668));
                      break label3174;
                      label3757:
                      paramBundle = this.rrn;
                      if (paramBundle == null) {
                        d.g.b.k.aVY("actionBarPhotoBtn");
                      }
                      paramBundle.setVisibility(8);
                      paramBundle = this.rrl;
                      if (paramBundle == null) {
                        d.g.b.k.aVY("actionBarMoreBtn");
                      }
                      paramBundle.setVisibility(0);
                      paramBundle = this.rrl;
                      if (paramBundle == null) {
                        d.g.b.k.aVY("actionBarMoreBtn");
                      }
                      paramBundle.setOnClickListener((View.OnClickListener)new k(this));
                      break label3236;
                      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1278L, 15L, 1L, false);
                      paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
                      localObject1 = this.dng;
                      paramBundle = (Bundle)localObject1;
                      if (localObject1 == null) {
                        paramBundle = "";
                      }
                      localObject1 = this.username;
                      if (localObject1 == null) {
                        d.g.b.k.aVY("username");
                      }
                      com.tencent.mm.plugin.finder.report.d.y(i, paramBundle, (String)localObject1);
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
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(106, (com.tencent.mm.plugin.finder.api.e)this.rrG);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.e)this.rrG);
    FinderProfileUIContract.ProfileViewCallback localProfileViewCallback = this.viewCallback;
    if (localProfileViewCallback == null) {
      d.g.b.k.aVY("viewCallback");
    }
    ((BaseFinderFeedLoader)localProfileViewCallback.riT.cuV()).unregister(localProfileViewCallback.rgg, localProfileViewCallback.iMV);
    localProfileViewCallback.riT.onDetach();
    AppMethodBeat.o(166206);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(166204);
    super.onPause();
    if (this.viewCallback == null) {
      d.g.b.k.aVY("viewCallback");
    }
    AppMethodBeat.o(166204);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(166203);
    super.onResume();
    this.rrC = false;
    Object localObject1;
    if (this.dfZ)
    {
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.FinderSyncExtension");
        AppMethodBeat.o(166203);
        throw ((Throwable)localObject1);
      }
      ((com.tencent.mm.plugin.finder.extension.a)localObject1).fx(12329, 1);
    }
    com.tencent.mm.kernel.g.agi().a(3736, (com.tencent.mm.ak.g)this);
    Object localObject2;
    if (this.rrF)
    {
      a(true, null);
      this.rrF = false;
      if (this.viewCallback == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.f.rNg;
      if (com.tencent.mm.plugin.finder.upload.f.cCw())
      {
        localObject1 = this.viewCallback;
        if (localObject1 == null) {
          d.g.b.k.aVY("viewCallback");
        }
        localObject1 = ((FinderProfileUIContract.ProfileViewCallback)localObject1).fTr;
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localObject1 = com.tencent.mm.plugin.finder.upload.f.rNg;
        com.tencent.mm.plugin.finder.upload.f.lO(false);
      }
      AppMethodBeat.o(166203);
      return;
    }
    if (this.dfZ)
    {
      localObject1 = this.rrA;
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
      localObject2 = com.tencent.mm.ui.component.a.IrY;
      localObject1 = new aw((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
      ((aw)localObject1).qYP = true;
      com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)localObject1);
      break;
      a(true, null);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(166207);
    ac.i(this.TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2);
    if (paramn != null)
    {
      if ((paramn.getType() != 3736) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break label275;
      }
      paramString = ((aw)paramn).rr.aBD();
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
      String str1 = ((aw)paramn).qYQ;
      Object localObject = this.username;
      if (localObject == null) {
        d.g.b.k.aVY("username");
      }
      if (d.g.b.k.g(str1, localObject))
      {
        str1 = this.username;
        if (str1 == null) {
          d.g.b.k.aVY("username");
        }
        if ((d.g.b.k.g(str1, paramString.username) ^ true))
        {
          str1 = this.TAG;
          localObject = new StringBuilder("update username ");
          String str2 = this.username;
          if (str2 == null) {
            d.g.b.k.aVY("username");
          }
          ac.i(str1, str2 + ' ' + paramString.username);
        }
        paramString = paramString.username;
        d.g.b.k.g(paramString, "contact.username");
        this.username = paramString;
        a(true, (aw)paramn);
      }
    }
    label275:
    AppMethodBeat.o(166207);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(166205);
    super.onStop();
    com.tencent.mm.kernel.g.agi().b(3736, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(166205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements n.c
  {
    c(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(202452);
      d.g.b.k.g(paraml, "it");
      if (paraml.fiA())
      {
        paraml.jw(FinderProfileUI.m(this.rrJ), 2131755747);
        paraml.jw(FinderProfileUI.n(this.rrJ), 2131755754);
      }
      AppMethodBeat.o(202452);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class d
    implements n.d
  {
    d(FinderProfileUI paramFinderProfileUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202453);
      Intent localIntent = new Intent();
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderProfileUI.m(this.rrJ)) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 1);
        localIntent.putExtra("key_finder_post_id", this.rrK);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
        paramMenuItem = this.rrJ.getContext();
        d.g.b.k.g(paramMenuItem, "context");
        com.tencent.mm.plugin.finder.utils.a.v((Context)paramMenuItem, localIntent);
        AppMethodBeat.o(202453);
        return;
        if (paramMenuItem.getItemId() == FinderProfileUI.n(this.rrJ)) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e rrL;
    
    static
    {
      AppMethodBeat.i(202455);
      rrL = new e();
      AppMethodBeat.o(202455);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(202454);
      com.tencent.mm.plugin.finder.report.c localc = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.DS(6);
      AppMethodBeat.o(202454);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$countListener$1", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "plugin-finder_release"})
  public static final class f
    implements com.tencent.mm.plugin.finder.api.e
  {
    public final void a(aiy paramaiy)
    {
      AppMethodBeat.i(166158);
      d.g.b.k.h(paramaiy, "cmdItem");
      if (!FinderProfileUI.g(this.rrJ))
      {
        AppMethodBeat.o(166158);
        return;
      }
      switch (paramaiy.cmdId)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(166158);
        return;
        FinderProfileUI.a(this.rrJ);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "newHeight", "", "onStatusBarHeightChange"})
  static final class g
    implements c.a
  {
    g(FinderProfileUI paramFinderProfileUI) {}
    
    public final void tx(int paramInt)
    {
      AppMethodBeat.i(166159);
      ac.i(FinderProfileUI.q(this.rrJ), "newHeight ".concat(String.valueOf(paramInt)));
      if (paramInt > 0)
      {
        Object localObject = FinderProfileUI.r(this.rrJ).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(166159);
          throw ((Throwable)localObject);
        }
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localObject;
        localLayoutParams.height += paramInt;
        FinderProfileUI.r(this.rrJ).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderProfileUI.r(this.rrJ).setPadding(0, paramInt, 0, 0);
        FinderProfileUI.s(this.rrJ).setPadding(0, paramInt, 0, 0);
      }
      com.tencent.mm.ui.statusbar.c.bm((Activity)this.rrJ).b(FinderProfileUI.t(this.rrJ));
      AppMethodBeat.o(166159);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166160);
      FinderProfileUI.h(this.rrJ);
      AppMethodBeat.o(166160);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166161);
      FinderProfileUI.h(this.rrJ);
      AppMethodBeat.o(166161);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166166);
      paramView = com.tencent.mm.plugin.finder.spam.a.rBD;
      if (com.tencent.mm.plugin.finder.spam.a.aed("post"))
      {
        AppMethodBeat.o(166166);
        return;
      }
      FinderProfileUI.i(this.rrJ);
      AppMethodBeat.o(166166);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166169);
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.rrJ, 1, false);
      paramView.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166167);
          d.g.b.k.g(paramAnonymousl, "it");
          if (paramAnonymousl.fiA())
          {
            paramAnonymousl.jw(FinderProfileUI.j(this.rrM.rrJ), 2131759322);
            paramAnonymousl.jw(FinderProfileUI.k(this.rrM.rrJ), 2131759313);
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
          if (paramAnonymousInt == FinderProfileUI.j(this.rrM.rrJ))
          {
            paramAnonymousMenuItem = FinderProfileUI.l(this.rrM.rrJ);
            if (paramAnonymousMenuItem != null)
            {
              k.a.a(com.tencent.mm.plugin.finder.utils.k.rPa, (MMActivity)this.rrM.rrJ, paramAnonymousMenuItem);
              AppMethodBeat.o(166168);
              return;
            }
            AppMethodBeat.o(166168);
            return;
          }
          if (paramAnonymousInt == FinderProfileUI.k(this.rrM.rrJ))
          {
            paramAnonymousMenuItem = this.rrM.rrJ.getString(2131759199, new Object[] { ab.eUO(), FinderProfileUI.c(this.rrM.rrJ) });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousMenuItem);
            com.tencent.mm.br.d.b((Context)this.rrM.rrJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          }
          AppMethodBeat.o(166168);
        }
      });
      paramView.cED();
      AppMethodBeat.o(166169);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class l<T>
    implements Observer<f.a>
  {
    l(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166171);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.eP((Context)this.rrJ);
      paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramView).getRedDotManager().adv("FinderSetting");
      AppMethodBeat.o(166171);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166174);
      paramView = com.tencent.mm.plugin.finder.spam.a.rBD;
      if (com.tencent.mm.plugin.finder.spam.a.aed("personalInfo"))
      {
        AppMethodBeat.o(166174);
        return;
      }
      paramView = new com.tencent.mm.ui.widget.a.e((Context)this.rrJ, 1, false);
      paramView.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(166172);
          d.g.b.k.g(paramAnonymousl, "it");
          if (paramAnonymousl.fiA()) {
            paramAnonymousl.jw(FinderProfileUI.e(this.rrN.rrJ), 2131759314);
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
          if (paramAnonymousMenuItem.getItemId() == FinderProfileUI.e(this.rrN.rrJ)) {
            FinderProfileUI.f(this.rrN.rrJ);
          }
          AppMethodBeat.o(166173);
        }
      });
      paramView.cED();
      AppMethodBeat.o(166174);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166175);
      int i;
      if (FinderProfileUI.g(this.rrJ))
      {
        paramView = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramView, "MMKernel.storage()");
        i = paramView.agA().getInt(ah.a.GVo, 0);
        if (i > 0)
        {
          paramView = com.tencent.mm.plugin.finder.report.d.rxr;
          paramView = FinderReporterUIC.seQ;
          paramView = FinderReporterUIC.a.eV((Context)this.rrJ);
          if (paramView == null) {
            break label127;
          }
        }
      }
      label127:
      for (paramView = paramView.cGb();; paramView = null)
      {
        com.tencent.mm.plugin.finder.report.d.a("3", 1, 2, 5, 3, i, null, null, 0L, paramView, 0, 0, 3520);
        paramView = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramView, "MMKernel.storage()");
        paramView.agA().set(ah.a.GVo, Integer.valueOf(0));
        FinderProfileUI.a(this.rrJ, FinderFansListUI.class);
        AppMethodBeat.o(166175);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onActivityResult$1$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.loader.g.f<com.tencent.mm.plugin.finder.upload.i>
  {
    p(FinderProfileUI paramFinderProfileUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$1$1$1$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$3"})
  static final class q
    implements DialogInterface.OnClickListener
  {
    q(awb paramawb1, awb paramawb2, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178300);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.db(FinderProfileUI.c(jdField_this), 1);
      paramDialogInterface = (com.tencent.mm.plugin.i.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.i.class);
      String str1 = this.rrO.iKc;
      d.g.b.k.g(str1, "it.Country");
      String str2 = this.rrO.iJU;
      d.g.b.k.g(str2, "it.Province");
      String str3 = this.rrO.iJV;
      d.g.b.k.g(str3, "it.City");
      paramDialogInterface.a(str1, str2, str3, 0, (com.tencent.mm.plugin.i.a.k)new com.tencent.mm.plugin.i.a.k() {});
      AppMethodBeat.o(178300);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onCreate$1$1$1$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$$special$$inlined$let$lambda$4"})
  static final class r
    implements DialogInterface.OnClickListener
  {
    r(awb paramawb, FinderProfileUI paramFinderProfileUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178301);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.db(FinderProfileUI.c(jdField_this), 2);
      AppMethodBeat.o(178301);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class s
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166178);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      float f1 = FinderProfileUI.u(this.rrJ).getHeight() * 1.0F;
      if (f1 == 0.0F)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
      }
      paramRecyclerView = new int[2];
      FinderProfileUI.u(this.rrJ).getLocationInWindow(paramRecyclerView);
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
        ac.d(FinderProfileUI.q(this.rrJ), "onScrollListener ".concat(String.valueOf(f2)));
        if (f2 != FinderProfileUI.v(this.rrJ)) {
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
      FinderProfileUI.a(this.rrJ, f2);
      FinderProfileUI.w(this.rrJ);
      if (f2 < 0.5F)
      {
        f1 = (0.5F - f2) / 0.5F;
        this.rrJ.setActionbarColor(this.rrJ.getResources().getColor(2131101053));
        if (FinderProfileUI.x(this.rrJ))
        {
          FinderProfileUI.r(this.rrJ).setBackgroundColor(this.rrJ.getResources().getColor(2131101053));
          FinderProfileUI.r(this.rrJ).setBackgroundResource(2131233659);
          FinderProfileUI.z(this.rrJ).setAlpha(0.0F);
          FinderProfileUI.A(this.rrJ).setAlpha(f1);
          FinderProfileUI.B(this.rrJ).setAlpha(f1);
          if (!FinderProfileUI.g(this.rrJ)) {
            break label496;
          }
          FinderProfileUI.C(this.rrJ).setVisibility(8);
          FinderProfileUI.D(this.rrJ);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(166178);
        return;
        FinderProfileUI.r(this.rrJ).setBackgroundResource(0);
        FinderProfileUI.r(this.rrJ).setBackgroundColor(this.rrJ.getResources().getColor(2131101053));
        if (aj.DT())
        {
          FinderProfileUI.y(this.rrJ).setStatusBarColor(this.rrJ.getResources().getColor(2131099816));
          break;
        }
        FinderProfileUI.y(this.rrJ).setStatusBarColor(this.rrJ.getResources().getColor(2131099668));
        break;
        label496:
        FinderProfileUI.E(this.rrJ).setVisibility(8);
        FinderProfileUI.F(this.rrJ).setVisibility(8);
        FinderProfileUI.C(this.rrJ).setVisibility(0);
        continue;
        f1 = (f2 - 0.5F) / 0.5F;
        FinderProfileUI.r(this.rrJ).setBackgroundResource(0);
        FinderProfileUI.r(this.rrJ).setBackgroundColor(am.eR(this.rrJ.getResources().getColor(2131100705), (int)(255.0F * f1)));
        this.rrJ.setActionbarColor(am.eR(this.rrJ.getResources().getColor(2131100705), (int)(255.0F * f1)));
        FinderProfileUI.z(this.rrJ).setAlpha(f1);
        FinderProfileUI.A(this.rrJ).setAlpha(f1);
        FinderProfileUI.B(this.rrJ).setAlpha(f1);
        FinderProfileUI.C(this.rrJ).setVisibility(8);
        if (FinderProfileUI.g(this.rrJ))
        {
          FinderProfileUI.D(this.rrJ);
        }
        else
        {
          FinderProfileUI.E(this.rrJ).setVisibility(8);
          if ((!d.g.b.k.g(FinderProfileUI.c(this.rrJ), u.axE())) && (((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).showFinderEntry())) {
            FinderProfileUI.F(this.rrJ).setVisibility(0);
          } else {
            FinderProfileUI.F(this.rrJ).setVisibility(8);
          }
        }
      }
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(166177);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$onScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(166177);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$1"})
  static final class t
    implements View.OnClickListener
  {
    t(com.tencent.mm.plugin.finder.api.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, aw paramaw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166179);
      FinderProfileUI.o(jdField_this);
      paramView = new Intent();
      paramView.putStringArrayListExtra("key_url_list", new ArrayList((Collection)d.a.j.listOf(this.rrR.crZ())));
      paramView.putExtra("key_preview_avatar", true);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.G((Context)jdField_this, paramView);
      AppMethodBeat.o(166179);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$2"})
  static final class u
    implements View.OnLongClickListener
  {
    u(FinderProfileUI paramFinderProfileUI, boolean paramBoolean, aw paramaw) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(166182);
      paramView = new com.tencent.mm.ui.widget.b.a((Context)this.rrJ.getContext(), paramView);
      paramView.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(166180);
          paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.rrU.rrJ.getContext().getString(2131755701));
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
            paramAnonymousMenuItem = ai.getContext().getSystemService("clipboard");
            if (paramAnonymousMenuItem == null)
            {
              paramAnonymousMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(166181);
              throw paramAnonymousMenuItem;
            }
            ((ClipboardManager)paramAnonymousMenuItem).setText(FinderProfileUI.p(this.rrU.rrJ).getText());
          }
          AppMethodBeat.o(166181);
        }
      });
      TouchableLayout.a locala = TouchableLayout.JyS;
      int i = TouchableLayout.fyY();
      locala = TouchableLayout.JyS;
      boolean bool = paramView.ej(i, TouchableLayout.fyZ());
      AppMethodBeat.o(166182);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$3"})
  static final class v<T, R>
    implements com.tencent.mm.loader.f.d<com.tencent.mm.plugin.finder.loader.j, Bitmap>
  {
    v(v.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, aw paramaw) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$4"})
  static final class w
    implements View.OnClickListener
  {
    w(com.tencent.mm.plugin.finder.api.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, aw paramaw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166184);
      paramView = this.rrR.field_authInfo;
      if (paramView != null)
      {
        paramView = paramView.authGenerator;
        if (paramView != null)
        {
          paramView = paramView.authInfo;
          if (paramView != null)
          {
            Object localObject;
            if ((!bs.isNullOrNil(paramView.appName)) && (!bs.isNullOrNil(paramView.detailLink)))
            {
              localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
              Context localContext = (Context)jdField_this;
              String str = paramView.appName;
              d.g.b.k.g(str, "authInfo.appName");
              localObject = paramView.detailLink;
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = "";
              }
              com.tencent.mm.plugin.finder.utils.a.y(localContext, str, paramView);
              AppMethodBeat.o(166184);
              return;
            }
            if (!bs.isNullOrNil(paramView.detailLink))
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", paramView.detailLink);
              com.tencent.mm.br.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            }
            AppMethodBeat.o(166184);
            return;
          }
        }
      }
      AppMethodBeat.o(166184);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$refreshProfile$1$5"})
  static final class x
    implements View.OnClickListener
  {
    x(com.tencent.mm.plugin.finder.api.f paramf, FinderProfileUI paramFinderProfileUI, boolean paramBoolean, aw paramaw) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(166185);
      paramView = this.rrR.field_authInfo;
      if (paramView != null)
      {
        Object localObject;
        if ((!bs.isNullOrNil(paramView.appName)) && (!bs.isNullOrNil(paramView.detailLink)))
        {
          localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
          Context localContext = (Context)jdField_this;
          String str = paramView.appName;
          d.g.b.k.g(str, "authInfo.appName");
          localObject = paramView.detailLink;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          com.tencent.mm.plugin.finder.utils.a.y(localContext, str, paramView);
          AppMethodBeat.o(166185);
          return;
        }
        if (!bs.isNullOrNil(paramView.detailLink))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.detailLink);
          com.tencent.mm.br.d.b((Context)jdField_this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
        AppMethodBeat.o(166185);
        return;
      }
      AppMethodBeat.o(166185);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.b<View, y>
  {
    y(FinderProfileUI paramFinderProfileUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"})
  static final class z
    extends d.g.b.l
    implements d.g.a.b<View, y>
  {
    z(FinderProfileUI paramFinderProfileUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI
 * JD-Core Version:    0.7.0.1
 */