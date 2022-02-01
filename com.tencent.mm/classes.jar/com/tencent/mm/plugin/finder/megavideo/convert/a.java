package com.tencent.mm.plugin.finder.megavideo.convert;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.a.ig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.megavideo.bullet.MegaVideoBulletView;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoInputLayout;
import com.tencent.mm.plugin.finder.megavideo.ui.f.d;
import com.tencent.mm.plugin.finder.megavideo.ui.f.h;
import com.tencent.mm.plugin.finder.megavideo.ui.f.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.m.d;
import com.tencent.mm.plugin.finder.viewmodel.component.m.e;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.h;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "blockBgClick", "", "getBlockBgClick", "()Z", "setBlockBgClick", "(Z)V", "miniViewEnable", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "convertMedia", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "deleteBullet", "info", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "deleteFinish", "Lkotlin/Function0;", "doFav", "doLike", "isPrivate", "likeAction", "e", "Landroid/view/MotionEvent;", "doPostBullet", "content", "", "doShare", "getLayoutId", "getLikeIcon", "filled", "private", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "hideBulletInputLayout", "hideBulletOpLayout", "initBulletLayout", "initFoldButtons", "initFooterLayout", "initHeaderLayout", "initPlayCtrlLayout", "initToggleHeaderAndFooter", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onHideSmileyPanel", "onMediaDoubleClick", "view", "Landroid/view/View;", "onShowSmileyPanel", "onSmileyBtnClick", "isShowSmiley", "openCommentDrawer", "refreshBulletLayout", "hasPayload", "refreshCommentLayout", "totalCommentCount", "refreshDescContent", "refreshFavLayout", "isFav", "favCount", "refreshLikeLayout", "isLike", "likeCount", "setGroupLikeIcon", "imageView", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "showBulletOpLayout", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.view.recyclerview.e<bs>
{
  private static final int xhL = 10003;
  private static final kotlin.f zvW;
  public static final a zvX;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  private final boolean zvT;
  boolean zvU;
  private final com.tencent.mm.plugin.finder.megavideo.ui.f zvV;
  
  static
  {
    AppMethodBeat.i(275540);
    zvX = new a((byte)0);
    xhL = 10003;
    zvW = kotlin.g.ar((kotlin.g.a.a)b.zvY);
    AppMethodBeat.o(275540);
  }
  
  public a(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.megavideo.ui.f paramf)
  {
    AppMethodBeat.i(275539);
    this.xkW = paraml;
    this.zvV = paramf;
    paraml = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXu().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.zvT = bool;
      AppMethodBeat.o(275539);
      return;
    }
  }
  
  private final int a(boolean paramBoolean1, boolean paramBoolean2, FinderObject paramFinderObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(275538);
    if (this.zvV.zxL)
    {
      i = b.i.finder_filled_like_private;
      AppMethodBeat.o(275538);
      return i;
    }
    Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localObject2 = paramFinderObject.contact;
    paramFinderObject = localObject1;
    if (localObject2 != null) {
      paramFinderObject = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject2, null);
    }
    if (com.tencent.mm.plugin.finder.utils.aj.j(paramFinderObject))
    {
      if (paramBoolean1)
      {
        i = b.i.finder_filled_like_lock;
        AppMethodBeat.o(275538);
        return i;
      }
      i = b.i.finder_outlined_like_lock;
      AppMethodBeat.o(275538);
      return i;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        i = b.i.finder_filled_like_lock;
        AppMethodBeat.o(275538);
        return i;
      }
      i = b.i.finder_full_like;
      AppMethodBeat.o(275538);
      return i;
    }
    int i = b.i.finder_full_like;
    AppMethodBeat.o(275538);
    return i;
  }
  
  private static void a(WeImageView paramWeImageView, bfz parambfz)
  {
    AppMethodBeat.i(275537);
    if (parambfz != null)
    {
      parambfz = parambfz.SQP;
      localObject = (CharSequence)parambfz;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label89;
      }
      paramWeImageView.setImageResource(b.i.icons_filled_like_group);
      parambfz = paramWeImageView.getContext();
      p.j(parambfz, "imageView.context");
      paramWeImageView.setIconColor(parambfz.getResources().getColor(b.c.Red_90));
      AppMethodBeat.o(275537);
      return;
      parambfz = null;
      break;
    }
    label89:
    Object localObject = paramWeImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).clearColorFilter();
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.setIconColor(0);
    localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
    parambfz = new com.tencent.mm.plugin.finder.loader.x(parambfz, u.Aly);
    paramWeImageView = (ImageView)paramWeImageView;
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(parambfz, paramWeImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
    AppMethodBeat.o(275537);
  }
  
  private final void a(final com.tencent.mm.view.recyclerview.i parami, final bs parambs)
  {
    AppMethodBeat.i(275527);
    Object localObject1 = (View.OnClickListener)new q(this, parami);
    Object localObject2 = parami.RD(b.f.close_btn);
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    }
    localObject1 = parambs.contact;
    label73:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((FinderContact)localObject1).username;
      if (localObject2 != null)
      {
        localObject1 = parambs.contact;
        if (localObject1 == null) {
          break label365;
        }
        localObject1 = ((FinderContact)localObject1).headUrl;
        localObject1 = Util.nullAsNil((String)localObject1);
        localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject3 = d.a.aAK((String)localObject2);
        if (localObject3 == null) {
          break label370;
        }
        if (Util.isNullOrNil(((com.tencent.mm.plugin.finder.api.i)localObject3).Mm())) {
          break label422;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.api.i)localObject3).Mm();
      }
    }
    label147:
    label422:
    for (;;)
    {
      Object localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject4 = parami.RD(b.f.auth_icon);
      p.j(localObject4, "holder.getView<ImageView>(R.id.auth_icon)");
      com.tencent.mm.plugin.finder.utils.aj.a((ImageView)localObject4, ((com.tencent.mm.plugin.finder.api.i)localObject3).field_authInfo);
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject3 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
      localObject4 = parami.RD(b.f.avatar_iv);
      p.j(localObject4, "holder.getView(R.id.avatar_iv)");
      localObject4 = (ImageView)localObject4;
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject3 = (TextView)parami.RD(b.f.nickname_tv);
      if (localObject3 != null)
      {
        localObject4 = parami.getContext();
        localObject1 = parambs.contact;
        if (localObject1 == null) {
          break label373;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        if (localObject1 == null) {
          break label373;
        }
      }
      label365:
      label370:
      label373:
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, (CharSequence)localObject1));
        if (this.zvV.zxL)
        {
          localObject1 = parami.RD(b.f.avatar_layout);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
        localObject1 = parami.RD(b.f.avatar_layout);
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener((View.OnClickListener)new p(this, parami, parambs, (String)localObject2));
        }
        if (!parambs.isPrivate()) {
          break label390;
        }
        parami = parami.RD(b.f.lock_icon);
        if (parami == null) {
          break label383;
        }
        parami.setVisibility(0);
        AppMethodBeat.o(275527);
        return;
        localObject2 = null;
        break;
        localObject1 = null;
        break label73;
        break label147;
      }
      label383:
      AppMethodBeat.o(275527);
      return;
      parami = parami.RD(b.f.lock_icon);
      if (parami != null)
      {
        parami.setVisibility(8);
        AppMethodBeat.o(275527);
        return;
      }
      AppMethodBeat.o(275527);
      return;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.i parami, boolean paramBoolean, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(275531);
    bs localbs = (bs)parami.ihX();
    Object localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (!com.tencent.mm.plugin.finder.utils.aj.b(localbs.xcy))
    {
      paramMotionEvent = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramMotionEvent = parami.getContext();
      p.j(paramMotionEvent, "holder.context");
      parami = parami.getContext().getString(b.j.finder_private_ban_like);
      p.j(parami, "holder.context.getString….finder_private_ban_like)");
      com.tencent.mm.plugin.finder.utils.aj.aL(paramMotionEvent, parami);
      AppMethodBeat.o(275531);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    boolean bool1 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(localbs.getFeedObject()).Mx).booleanValue();
    WeImageView localWeImageView;
    Object localObject2;
    if (!bool1)
    {
      localWeImageView = g(parami);
      localWeImageView.setLayerPaint(null);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(localbs.getFeedObject().objectType);
      if (localObject2 == null)
      {
        localObject1 = "";
        if (!paramBoolean) {
          break label415;
        }
        a(localWeImageView, (bfz)localObject2);
        label164:
        localObject1 = com.tencent.mm.plugin.finder.view.animation.c.BdF;
        com.tencent.mm.plugin.finder.view.animation.c.a((View)localWeImageView, 1.4F, paramMotionEvent, true, 16);
        parami.amk.performHapticFeedback(0, 3);
      }
    }
    else
    {
      parami = this.zvV;
      p.j(localbs, "item");
      if (bool1) {
        break label646;
      }
      bool1 = true;
      label216:
      p.k(localbs, "feed");
      paramMotionEvent = com.tencent.mm.ui.component.g.Xox;
      paramMotionEvent = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(parami.ycV).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
      parami = al.zAN;
      parami = FinderItem.Companion;
      localObject1 = FinderItem.a.b(localbs.getFeedObject(), 32768);
      parami = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(localbs.getFeedObject()).My).booleanValue();
      parami = com.tencent.mm.plugin.finder.utils.aj.AGc;
      parami = localbs.contact;
      if (parami == null) {
        break label652;
      }
      parami = com.tencent.mm.plugin.finder.api.c.a(parami, null);
      label317:
      al.a(paramMotionEvent, paramInt, (FinderItem)localObject1, bool1, paramBoolean, 2, false, bool2, com.tencent.mm.plugin.finder.utils.aj.j(parami));
      parami = new hu();
      parami.fEL.id = localbs.dKW();
      parami.fEL.type = 4;
      paramMotionEvent = parami.fEL;
      if (!bool1) {
        break label662;
      }
      if (!paramBoolean) {
        break label657;
      }
      paramInt = 2;
    }
    for (;;)
    {
      paramMotionEvent.fEO = paramInt;
      EventCenter.instance.publish((IEvent)parami);
      AppMethodBeat.o(275531);
      return;
      localObject1 = ((bfz)localObject2).SQK;
      break;
      label415:
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject2 = localbs.contact;
      if (localObject2 != null) {}
      for (localObject2 = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject2, null);; localObject2 = null)
      {
        if (!com.tencent.mm.plugin.finder.utils.aj.j((com.tencent.mm.plugin.finder.api.i)localObject2)) {
          break label505;
        }
        localObject1 = parami.getContext();
        i = b.i.finder_filled_like_lock;
        localObject2 = parami.getContext();
        p.j(localObject2, "holder.context");
        localWeImageView.setImageDrawable(au.o((Context)localObject1, i, ((Context)localObject2).getResources().getColor(b.c.Red_90)));
        break;
      }
      label505:
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label595;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
        localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
        ImageView localImageView = (ImageView)localWeImageView;
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        break;
      }
      label595:
      localObject1 = parami.getContext();
      i = b.i.finder_full_like;
      localObject2 = parami.getContext();
      p.j(localObject2, "holder.context");
      localWeImageView.setImageDrawable(au.o((Context)localObject1, i, ((Context)localObject2).getResources().getColor(b.c.Red_90)));
      break label164;
      label646:
      bool1 = false;
      break label216;
      label652:
      parami = null;
      break label317;
      label657:
      paramInt = 1;
      continue;
      label662:
      paramInt = 0;
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.i parami, bs parambs)
  {
    int j = 1;
    AppMethodBeat.i(275536);
    Object localObject2 = (WeImageView)parami.RD(b.f.mega_video_like);
    int i;
    Object localObject1;
    label103:
    int k;
    Object localObject3;
    label172:
    boolean bool;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        p.j(localObject2, "likeIv");
        ((WeImageView)localObject2).setTag(Integer.valueOf(2));
        i = a(true, paramBoolean2, parambs.getFeedObject());
        localObject1 = parami.getContext();
        p.j(localObject1, "holder.context");
        localObject1 = new kotlin.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(b.c.Red_90)));
        i = ((Number)((kotlin.o)localObject1).Mx).intValue();
        k = ((Number)((kotlin.o)localObject1).My).intValue();
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.Qt(parambs.getFeedObject().objectType);
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = parambs.contact;
        if (localObject1 == null) {
          break label366;
        }
        localObject1 = com.tencent.mm.plugin.finder.api.c.a((FinderContact)localObject1, null);
        bool = com.tencent.mm.plugin.finder.utils.aj.j((com.tencent.mm.plugin.finder.api.i)localObject1);
        if ((!paramBoolean2) || (!paramBoolean1) || (bool)) {
          break label372;
        }
        a((WeImageView)localObject2, (bfz)localObject3);
        label199:
        if (!this.zvV.zxL) {
          break label507;
        }
        i = 1;
        label212:
        localObject1 = (TextView)parami.RD(b.f.mega_video_like_count_tv);
        if (paramInt <= 0) {
          break label513;
        }
        parami = com.tencent.mm.plugin.finder.utils.m.gY(i, paramInt);
        p.j(parami, "FinderFormatUtil.formatNumber(scene, likeCount)");
      }
    }
    for (;;)
    {
      p.j(localObject1, "likeTv");
      ((TextView)localObject1).setText((CharSequence)parami);
      AppMethodBeat.o(275536);
      return;
      p.j(localObject2, "likeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(1));
      break;
      p.j(localObject2, "likeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(0));
      i = a(false, paramBoolean2, parambs.getFeedObject());
      localObject1 = parami.getContext();
      p.j(localObject1, "holder.context");
      localObject1 = new kotlin.o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8)));
      break label103;
      label366:
      localObject1 = null;
      break label172;
      label372:
      if ((localObject3 != null) && (!bool) && (!paramBoolean2))
      {
        if (paramBoolean1) {}
        for (localObject1 = ((bfz)localObject3).SQK;; localObject1 = ((bfz)localObject3).SQR)
        {
          localObject3 = ((WeImageView)localObject2).getDrawable();
          if (localObject3 != null) {
            ((Drawable)localObject3).clearColorFilter();
          }
          ((WeImageView)localObject2).setClearColorFilter(true);
          ((WeImageView)localObject2).setIconColor(0);
          localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject3 = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject1 = new com.tencent.mm.plugin.finder.loader.x((String)localObject1, u.Aly);
          localObject2 = (ImageView)localObject2;
          com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
          break;
        }
      }
      ((WeImageView)localObject2).setImageResource(i);
      ((WeImageView)localObject2).setIconColor(k);
      break label199;
      label507:
      i = 2;
      break label212;
      label513:
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.AnT;
      parambs = com.tencent.mm.plugin.finder.storage.logic.g.Qt(parambs.getFeedObject().objectType);
      if (parambs != null)
      {
        localObject2 = (CharSequence)parambs.SQO;
        paramInt = j;
        if (localObject2 != null) {
          if (((CharSequence)localObject2).length() != 0) {
            break label595;
          }
        }
      }
      label595:
      for (paramInt = j;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label600;
        }
        parami = parami.getContext().getString(b.j.finder_like_count_text);
        p.j(parami, "holder.context.getString…g.finder_like_count_text)");
        break;
      }
      label600:
      parambs = parambs.SQO;
      parami = parambs;
      if (parambs == null) {
        parami = "";
      }
    }
  }
  
  private final void b(final com.tencent.mm.view.recyclerview.i parami, final bs parambs)
  {
    AppMethodBeat.i(275528);
    Object localObject1 = parami.RD(b.f.warn_layout);
    Object localObject2 = parambs.xcy;
    int i;
    label104:
    label111:
    int j;
    if (localObject2 != null)
    {
      i = ((cvy)localObject2).TER;
      if (i == 0) {
        break label489;
      }
      p.j(localObject1, "warnContainer");
      ((View)localObject1).setVisibility(0);
      localObject1 = parami.RD(b.f.warn_word_tv);
      p.j(localObject1, "holder.getView<TextView>(R.id.warn_word_tv)");
      localObject2 = (TextView)localObject1;
      localObject1 = parambs.xcy;
      if (localObject1 == null) {
        break label478;
      }
      localObject1 = ((cvy)localObject1).TES;
      if (localObject1 == null) {
        break label478;
      }
      localObject1 = (CharSequence)localObject1;
      ((TextView)localObject2).setText((CharSequence)localObject1);
      c(parami, parambs);
      localObject1 = parami.RD(b.f.mega_video_share_layout);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new l(this, parambs, parami));
        i = parambs.getFeedObject().forwardCount;
        localObject2 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
        j = i + com.tencent.mm.plugin.finder.upload.action.c.ecy().q(parambs.getFeedObject()) + parambs.getFeedObject().wx_status_ref_count;
        if (j <= 0) {
          break label512;
        }
        if (!this.zvV.zxL) {
          break label507;
        }
        i = 1;
      }
    }
    label201:
    for (localObject1 = com.tencent.mm.plugin.finder.utils.m.gY(i, j);; localObject1 = ((View)localObject1).getContext().getString(b.j.finder_share_icon_text))
    {
      localObject2 = parami.RD(b.f.mega_video_share_count_tv);
      p.j(localObject2, "holder.getView<TextView>…ega_video_share_count_tv)");
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = parami.RD(b.f.mega_video_like_layout);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new m(this, parami));
      }
      localObject1 = parami.RD(b.f.mega_video_like_layout);
      if (localObject1 != null) {
        ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new n(this, parambs, parami));
      }
      localObject1 = parami.RD(b.f.mega_video_like_layout);
      if (localObject1 != null) {
        ((View)localObject1).setHapticFeedbackEnabled(false);
      }
      parami.RD(b.f.mega_video_comment_layout).setOnClickListener((View.OnClickListener)new o(this, parami, parambs));
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
      com.tencent.mm.plugin.finder.upload.action.c.ecy().p(parambs.getFeedObject());
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
      com.tencent.mm.plugin.finder.upload.action.c.ecy().q(parambs.getFeedObject());
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      boolean bool1 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(parambs.getFeedObject()).Mx).booleanValue();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(parambs.getFeedObject()).My).booleanValue();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      a(bool1, bool2, com.tencent.mm.plugin.finder.upload.action.l.ecG().s(parambs.getFeedObject()), parami, parambs);
      c(parami, parambs.getFeedObject().commentCount);
      AppMethodBeat.o(275528);
      return;
      i = 0;
      break;
      label478:
      localObject1 = (CharSequence)"";
      break label104;
      label489:
      p.j(localObject1, "warnContainer");
      ((View)localObject1).setVisibility(8);
      break label111;
      label507:
      i = 2;
      break label201;
    }
  }
  
  private final void c(com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(275533);
    int i;
    if (this.zvV.zxL)
    {
      i = 1;
      if (paramInt <= 0) {
        break label68;
      }
    }
    label68:
    for (String str = com.tencent.mm.plugin.finder.utils.m.gY(i, paramInt);; str = parami.getContext().getString(b.j.finder_comment_count_text))
    {
      parami = parami.RD(b.f.mega_video_comment_count_tv);
      p.j(parami, "holder.getView<TextView>…a_video_comment_count_tv)");
      ((TextView)parami).setText((CharSequence)str);
      AppMethodBeat.o(275533);
      return;
      i = 2;
      break;
    }
  }
  
  private final void c(final com.tencent.mm.view.recyclerview.i parami, final bs parambs)
  {
    AppMethodBeat.i(275530);
    NeatTextView localNeatTextView = (NeatTextView)parami.RD(b.f.description_tv);
    Object localObject = parambs.xcy;
    Context localContext;
    if (localObject != null)
    {
      localObject = ((cvy)localObject).TEM;
      if (localObject != null)
      {
        localObject = ((cwc)localObject).description;
        if (localObject != null)
        {
          localObject = (CharSequence)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label168;
          }
          p.j(localNeatTextView, "descriptionTv");
          localNeatTextView.setVisibility(0);
          localContext = parami.getContext();
          localObject = parambs.xcy;
          if (localObject == null) {
            break label158;
          }
          localObject = ((cvy)localObject).TEM;
          if (localObject == null) {
            break label158;
          }
          localObject = ((cwc)localObject).description;
          if (localObject == null) {
            break label158;
          }
        }
      }
    }
    label158:
    for (localObject = (CharSequence)localObject;; localObject = (CharSequence)"")
    {
      localNeatTextView.aL((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)localObject));
      localNeatTextView.setOnClickListener((View.OnClickListener)new aa(this, parami, parambs));
      AppMethodBeat.o(275530);
      return;
      localObject = (CharSequence)"";
      break;
    }
    label168:
    p.j(localNeatTextView, "descriptionTv");
    localNeatTextView.setVisibility(8);
    AppMethodBeat.o(275530);
  }
  
  private static WeImageView g(com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(275534);
    WeImageView localWeImageView = new WeImageView(parami.getContext());
    localWeImageView.setVisibility(4);
    Object localObject = parami.getContext();
    p.j(localObject, "holder.context");
    int i = (int)((Context)localObject).getResources().getDimension(b.d.Edge_6_5_A);
    localObject = new FrameLayout.LayoutParams(i, i);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localWeImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localWeImageView.setImageResource(b.i.finder_full_like);
    localObject = parami.getContext();
    p.j(localObject, "holder.context");
    localWeImageView.setIconColor(((Context)localObject).getResources().getColor(b.c.Red_90));
    localObject = parami.RD(b.f.media_container);
    parami = (com.tencent.mm.view.recyclerview.i)localObject;
    if (!(localObject instanceof ViewGroup)) {
      parami = null;
    }
    parami = (ViewGroup)parami;
    if (parami != null) {
      parami.addView((View)localWeImageView);
    }
    AppMethodBeat.o(275534);
    return localWeImageView;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(275525);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    parami = (FinderMediaBanner)parami.RD(b.f.media_banner);
    FinderMediaBannerAdapter localFinderMediaBannerAdapter = new FinderMediaBannerAdapter(this.xkW);
    localFinderMediaBannerAdapter.isLongVideo = true;
    parami.setAdapter((RecyclerView.a)localFinderMediaBannerAdapter);
    parami.setParentRecyclerView(paramRecyclerView);
    parami.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(275525);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_long_video_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion;", "", "()V", "ANIM_DURATION", "", "BULLET_TEXT_LIMIT", "", "getBULLET_TEXT_LIMIT", "()I", "BULLET_TEXT_LIMIT$delegate", "Lkotlin/Lazy;", "FULLSCREEN_FLAG", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "payloadsProgressType", "payloadsRefreshBullet", "payloadsRefreshFav", "payloadsRefreshLike", "payloadsRefreshNormalData", "hidePlaySpeedCtrlLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "playTimesTag", "onConfigurationChange", "", "isLandscape", "resetAnimViews", "showPlaySpeedCtrlLayout", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "toggleHeaderFooter", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "activity", "Landroid/app/Activity;", "forceShow", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;Landroid/app/Activity;Ljava/lang/Boolean;)V", "plugin-finder_release"})
  public static final class a
  {
    public static void a(com.tencent.mm.view.recyclerview.i parami, com.tencent.mm.plugin.finder.megavideo.ui.f paramf)
    {
      AppMethodBeat.i(279866);
      p.k(parami, "holder");
      p.k(paramf, "presenter");
      Object localObject = parami.RD(b.f.footer_layout);
      if (localObject != null) {
        ((View)localObject).animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new b((View)localObject));
      }
      localObject = parami.getContext();
      p.j(localObject, "holder.context");
      localObject = ((Context)localObject).getResources();
      p.j(localObject, "holder.context.resources");
      int i;
      LinearLayout localLinearLayout;
      Iterator localIterator;
      label189:
      int j;
      if (((Resources)localObject).getConfiguration().orientation == 2)
      {
        i = 1;
        localLinearLayout = (LinearLayout)parami.RD(b.f.play_speed_control_container);
        if (localLinearLayout != null) {
          localIterator = ((Iterable)j.listOf(new TextView[] { (TextView)parami.RD(b.f.speed_0_5), (TextView)parami.RD(b.f.speed_1), (TextView)parami.RD(b.f.speed_1_5), (TextView)parami.RD(b.f.speed_2) })).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label300;
          }
          TextView localTextView = (TextView)localIterator.next();
          if (localTextView != null) {}
          for (localObject = localTextView.getTag();; localObject = null)
          {
            if (!p.h(localObject, Integer.valueOf(paramf.zxP))) {
              break label286;
            }
            if (localTextView == null) {
              break label189;
            }
            localObject = parami.getContext();
            p.j(localObject, "holder.context");
            localTextView.setTextColor(((Context)localObject).getResources().getColor(b.c.hot_tab_Orange_100));
            break label189;
            i = 0;
            break;
          }
          label286:
          if (localTextView != null) {
            localTextView.setTextColor(-1);
          }
        }
        label300:
        paramf = parami.getContext();
        p.j(paramf, "holder.context");
        j = paramf.getResources().getDimensionPixelOffset(b.d.finder_mega_video_play_ctrl_layout_width);
        if (i == 0) {
          break label524;
        }
        paramf = localLinearLayout.getLayoutParams();
        if (paramf == null)
        {
          parami = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(279866);
          throw parami;
        }
        paramf = (FrameLayout.LayoutParams)paramf;
        paramf.gravity = 5;
        paramf.height = -1;
        paramf.width = j;
        paramf = parami.getContext();
        p.j(paramf, "holder.context");
        localLinearLayout.setPadding(0, 0, paramf.getResources().getDimensionPixelOffset(b.d.finder_mega_video_play_ctrl_layout_padding_end), 0);
        localLinearLayout.setBackgroundResource(b.e.mega_video_play_ctrl_layout_bg_land);
        localLinearLayout.setOrientation(1);
        localLinearLayout.requestLayout();
        localLinearLayout.setTranslationX(j);
        localLinearLayout.animate().translationY(0.0F).translationX(0.0F).setDuration(300L).setListener(null).start();
        localLinearLayout.setVisibility(0);
      }
      paramf = (bs)parami.ihX();
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      parami = parami.getContext();
      p.j(parami, "holder.context");
      parami = aj.a.fZ(parami);
      if (parami != null) {}
      for (parami = parami.ekY();; parami = null)
      {
        localObject = ai.zZt;
        ai.a(parami, "speedplay", paramf.dKW(), paramf.mf());
        AppMethodBeat.o(279866);
        return;
        label524:
        paramf = localLinearLayout.getLayoutParams();
        if (paramf == null)
        {
          parami = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(279866);
          throw parami;
        }
        paramf = (FrameLayout.LayoutParams)paramf;
        paramf.gravity = 80;
        paramf.height = j;
        paramf.width = -1;
        paramf = parami.getContext();
        p.j(paramf, "holder.context");
        localLinearLayout.setPadding(0, 0, 0, paramf.getResources().getDimensionPixelOffset(b.d.Edge_7A));
        localLinearLayout.setBackgroundResource(b.e.mega_video_play_ctrl_layout_bg);
        localLinearLayout.setOrientation(0);
        localLinearLayout.requestLayout();
        localLinearLayout.setTranslationY(j);
        break;
      }
    }
    
    public static void a(com.tencent.mm.view.recyclerview.i parami, bs parambs, Activity paramActivity, Boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(279865);
      p.k(parami, "holder");
      p.k(parambs, "item");
      p.k(paramActivity, "activity");
      View localView2 = parami.RD(b.f.menu_layout);
      View localView1 = parami.RD(b.f.footer_layout);
      p.j(localView1, "footer");
      if (localView1.getVisibility() == 0) {}
      for (int i = 8; p.h(paramBoolean, Boolean.TRUE); i = 0)
      {
        i = j;
        if (localView1.getVisibility() != 0) {
          break label133;
        }
        AppMethodBeat.o(279865);
        return;
      }
      if (p.h(paramBoolean, Boolean.FALSE))
      {
        if (localView1.getVisibility() == 8)
        {
          AppMethodBeat.o(279865);
          return;
        }
        i = 8;
      }
      for (;;)
      {
        label133:
        paramBoolean = parami.getContext();
        p.j(paramBoolean, "holder.context");
        paramBoolean = paramBoolean.getResources();
        p.j(paramBoolean, "holder.context.resources");
        if (paramBoolean.getConfiguration().orientation == 1)
        {
          p.j(localView2, "header");
          localView2.setVisibility(i);
          localView1.setVisibility(i);
          if (parambs.dGR())
          {
            parami = parami.RD(b.f.unfold_video_button);
            p.j(parami, "holder.getView<View>(R.id.unfold_video_button)");
            parami.setVisibility(i);
            AppMethodBeat.o(279865);
          }
        }
        else
        {
          if (i != 8) {
            break label304;
          }
          parami = paramActivity.getWindow();
          p.j(parami, "activity.window");
          parami = parami.getDecorView();
          p.j(parami, "activity.window.decorView");
          parambs = paramActivity.getWindow();
          p.j(parambs, "activity.window");
          parambs = parambs.getDecorView();
          p.j(parambs, "activity.window.decorView");
          parami.setSystemUiVisibility(parambs.getSystemUiVisibility() | 0x806);
        }
        for (;;)
        {
          localView1.setVisibility(i);
          AppMethodBeat.o(279865);
          return;
          label304:
          parami = paramActivity.getWindow();
          p.j(parami, "activity.window");
          parami = parami.getDecorView();
          p.j(parami, "activity.window.decorView");
          parambs = paramActivity.getWindow();
          p.j(parambs, "activity.window");
          parambs = parambs.getDecorView();
          p.j(parambs, "activity.window.decorView");
          parami.setSystemUiVisibility(parambs.getSystemUiVisibility() & 0xFFFFF7F9);
        }
      }
    }
    
    public static boolean d(com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(279867);
      p.k(parami, "holder");
      Object localObject1 = parami.RD(b.f.play_speed_control_container);
      if (localObject1 != null)
      {
        int i;
        label37:
        Object localObject2;
        if (((View)localObject1).getVisibility() == 0)
        {
          i = 1;
          if (i == 0) {
            break label240;
          }
          if (localObject1 == null) {
            break label278;
          }
          localObject2 = parami.getContext();
          p.j(localObject2, "holder.context");
          localObject2 = ((Context)localObject2).getResources();
          p.j(localObject2, "holder.context.resources");
          if (((Resources)localObject2).getConfiguration().orientation != 2) {
            break label245;
          }
          i = 1;
          label82:
          if (i == 0) {
            break label250;
          }
          localObject2 = ((View)localObject1).animate().translationX(((View)localObject1).getWidth()).setDuration(300L);
          label106:
          ((ViewPropertyAnimator)localObject2).setListener((Animator.AnimatorListener)new a((View)localObject1)).start();
          localObject1 = parami.RD(b.f.footer_layout);
          if (localObject1 != null)
          {
            ((View)localObject1).setAlpha(0.0F);
            ((View)localObject1).setVisibility(0);
            ((View)localObject1).animate().alpha(1.0F).setDuration(300L).setListener(null).start();
          }
          localObject1 = (bs)parami.ihX();
          localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          parami = parami.getContext();
          p.j(parami, "holder.context");
          parami = aj.a.fZ(parami);
          if (parami == null) {
            break label273;
          }
        }
        label273:
        for (parami = parami.ekY();; parami = null)
        {
          localObject2 = ai.zZt;
          ai.a(parami, "speedplayresult", ((bs)localObject1).dKW(), ((bs)localObject1).mf(), paramInt);
          AppMethodBeat.o(279867);
          return true;
          i = 0;
          break;
          label240:
          localObject1 = null;
          break label37;
          label245:
          i = 0;
          break label82;
          label250:
          localObject2 = ((View)localObject1).animate().translationY(((View)localObject1).getHeight()).setDuration(300L);
          break label106;
        }
      }
      label278:
      AppMethodBeat.o(279867);
      return false;
    }
    
    public static void s(com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(279864);
      Object localObject = (MegaVideoInputLayout)parami.RD(b.f.mega_video_bullet_input_layout);
      if (localObject != null)
      {
        ((MegaVideoInputLayout)localObject).setListenKeyBoardChange(false);
        ((MegaVideoInputLayout)localObject).setShowKeyboard(false);
        ((MegaVideoInputLayout)localObject).setTranslationY(0.0F);
      }
      localObject = (FinderMediaBanner)parami.RD(b.f.media_banner);
      if (localObject != null)
      {
        localObject = ((FinderMediaBanner)localObject).getPagerViewContainer();
        if (localObject != null)
        {
          ((FrameLayout)localObject).setTranslationY(0.0F);
          ((FrameLayout)localObject).setScaleX(1.0F);
          ((FrameLayout)localObject).setScaleY(1.0F);
        }
      }
      localObject = parami.RD(b.f.unfold_video_button);
      if (localObject != null) {
        ((View)localObject).setTranslationY(0.0F);
      }
      parami = (MegaVideoInputLayout)parami.RD(b.f.mega_video_bullet_input_layout);
      if (parami != null)
      {
        parami.dKj();
        parami.zyw = null;
        parami.zyx = null;
        parami.zyv = false;
        parami.zyy = null;
        AppMethodBeat.o(279864);
        return;
      }
      AppMethodBeat.o(279864);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion$hidePlaySpeedCtrlLayout$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(View paramView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(287255);
        this.kJS.setVisibility(8);
        AppMethodBeat.o(287255);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion$showPlaySpeedCtrlLayout$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class b
      extends AnimatorListenerAdapter
    {
      b(View paramView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(282389);
        this.kJS.setVisibility(8);
        this.kJS.setAlpha(1.0F);
        AppMethodBeat.o(282389);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class aa
    implements View.OnClickListener
  {
    aa(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291189);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.b(this.zvZ, parami, parambs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291189);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final b zvY;
    
    static
    {
      AppMethodBeat.i(270632);
      zvY = new b();
      AppMethodBeat.o(270632);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$1", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$1"})
  static final class c
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(FinderMediaBanner paramFinderMediaBanner, a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$2", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$2"})
  static final class d
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    d(FinderMediaBanner paramFinderMediaBanner, a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isLoading", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$3", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$3"})
  static final class e
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    e(FinderMediaBanner paramFinderMediaBanner, a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class f
    implements w.b
  {
    public static final f zwb;
    
    static
    {
      AppMethodBeat.i(288667);
      zwb = new f();
      AppMethodBeat.o(288667);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(288666);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(288666);
          return;
        }
      }
      AppMethodBeat.o(288666);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements q.f
  {
    public static final g zwc;
    
    static
    {
      AppMethodBeat.i(221612);
      zwc = new g();
      AppMethodBeat.o(221612);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(221608);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(10001, b.j.finder_share_to_friend);
        paramo.mn(10002, b.j.finder_share_to_sns);
      }
      AppMethodBeat.o(221608);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class h
    implements q.g
  {
    h(a parama, bs parambs) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(290537);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(290537);
        return;
        Object localObject = a.a(this.zvZ);
        paramMenuItem = this.zwd;
        p.k(paramMenuItem, "megaVideo");
        ac.a locala = ac.AEJ;
        localObject = ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject).ycV;
        FinderItem.a locala1 = FinderItem.Companion;
        ac.a.a(locala, (AppCompatActivity)localObject, FinderItem.a.b(paramMenuItem.getFeedObject(), 32768), null, 0, null, 28);
        AppMethodBeat.o(290537);
        return;
        localObject = a.a(this.zvZ);
        paramMenuItem = this.zwd;
        p.k(paramMenuItem, "megaVideo");
        locala = ac.AEJ;
        localObject = ((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject).ycV;
        locala1 = FinderItem.Companion;
        ac.a.a(locala, (AppCompatActivity)localObject, (BaseFinderFeed)new af(FinderItem.a.b(paramMenuItem.getFeedObject(), 32768)), 4, 0, 20);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(272592);
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      localObject = aj.a.fZ((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
      {
        bs localbs = (bs)this.tDl.ihX();
        com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
        p.j(localbs, "feed");
        com.tencent.mm.plugin.finder.report.n.a(localn, localbs, 1, 3L, "", (bid)localObject);
        AppMethodBeat.o(272592);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257260);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      a.a(this.zvZ).dsB().setRequestedOrientation(12);
      paramView.postDelayed((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(270623);
          Object localObject = this.zwe.tDl.getContext();
          p.j(localObject, "holder.context");
          localObject = ((Context)localObject).getResources();
          p.j(localObject, "holder.context.resources");
          if (((Resources)localObject).getConfiguration().orientation == 2)
          {
            AppMethodBeat.o(270623);
            return;
          }
          a.a(this.zwe.zvZ).dsB().setRequestedOrientation(-1);
          AppMethodBeat.o(270623);
        }
      }, 2000L);
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        paramView = paramView.ekY();
        localObject1 = ai.zZt;
        localObject1 = this.zwd.xcy;
        if (localObject1 == null) {
          break label262;
        }
        localObject1 = ((cvy)localObject1).TEO;
        if (localObject1 == null) {
          break label262;
        }
      }
      label262:
      for (long l = ((cwj)localObject1).xbk;; l = 0L)
      {
        String str2 = com.tencent.mm.ae.d.Fw(l);
        String str3 = com.tencent.mm.ae.d.Fw(this.zwd.mf());
        Object localObject2;
        if (paramView != null)
        {
          localObject2 = paramView.sessionId;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        String str1;
        if (paramView != null)
        {
          str1 = paramView.wmL;
          localObject2 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        if (paramView != null)
        {
          str1 = paramView.wmz;
          paramView = str1;
          if (str1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ai.a(str2, str3, 1, 2, (String)localObject1, (String)localObject2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257260);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291905);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = this.tDl.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(291905);
        throw paramView;
      }
      ((MMActivity)paramView).hideVKB();
      a.a(this.zvZ).dsB().setRequestedOrientation(11);
      paramView = a.zvX;
      a.a.s(this.tDl);
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        paramView = paramView.ekY();
        localObject1 = ai.zZt;
        localObject1 = this.zwd.xcy;
        if (localObject1 == null) {
          break label290;
        }
        localObject1 = ((cvy)localObject1).TEO;
        if (localObject1 == null) {
          break label290;
        }
      }
      label290:
      for (long l = ((cwj)localObject1).xbk;; l = 0L)
      {
        String str2 = com.tencent.mm.ae.d.Fw(l);
        String str3 = com.tencent.mm.ae.d.Fw(this.zwd.mf());
        Object localObject2;
        if (paramView != null)
        {
          localObject2 = paramView.sessionId;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        String str1;
        if (paramView != null)
        {
          str1 = paramView.wmL;
          localObject2 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        if (paramView != null)
        {
          str1 = paramView.wmz;
          paramView = str1;
          if (str1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ai.a(str2, str3, 1, 1, (String)localObject1, (String)localObject2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291905);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a parama, bs parambs, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282756);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.zvZ, parambs, parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282756);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(a parama, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284840);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (a.a(this.zvZ).zxL)
      {
        bs localbs = (bs)parami.ihX();
        localObject = parami.getContext();
        paramView = (View)localObject;
        if (!(localObject instanceof Activity)) {
          paramView = null;
        }
        paramView = (Activity)paramView;
        if (paramView != null)
        {
          paramView = (FinderLikeDrawer)paramView.findViewById(b.f.finder_feed_all_like_drawer);
          if (paramView != null)
          {
            localObject = FinderItem.Companion;
            paramView.a(FinderItem.a.b(localbs.getFeedObject(), 32768), null);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284840);
        return;
        a.a(this.zvZ, parami, false);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class n
    implements View.OnLongClickListener
  {
    n(a parama, bs parambs, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(280432);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUZ().aSr()).intValue() == 1)
      {
        paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
        paramView = parambs.contact;
        if (paramView == null) {
          break label198;
        }
      }
      label198:
      for (paramView = com.tencent.mm.plugin.finder.api.c.a(paramView, null);; paramView = null)
      {
        if (!com.tencent.mm.plugin.finder.utils.aj.j(paramView))
        {
          paramView = (WeImageView)parami.RD(b.f.mega_video_like);
          p.j(paramView, "view");
          if (((paramView.getTag() instanceof Integer)) && (p.h(paramView.getTag(), Integer.valueOf(0))))
          {
            paramView = new com.tencent.mm.ui.widget.a.e(parami.getContext(), 1, true);
            paramView.a((q.f)new q.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
              {
                AppMethodBeat.i(269073);
                p.j(paramAnonymouso, "it");
                if (paramAnonymouso.hJO())
                {
                  int i = a.dJC();
                  Context localContext = this.zwf.tDl.getContext();
                  p.j(localContext, "holder.context");
                  paramAnonymouso.d(i, (CharSequence)localContext.getResources().getString(b.j.finder_awesome_ground_title));
                }
                AppMethodBeat.o(269073);
              }
            });
            paramView.a((q.g)new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(277336);
                p.j(paramAnonymousMenuItem, "menuItem");
                if (paramAnonymousMenuItem.getItemId() == a.dJC()) {
                  a.a(this.zwf.zvZ, this.zwf.tDl, true);
                }
                AppMethodBeat.o(277336);
              }
            });
            paramView.eik();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(280432);
        return true;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280474);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.zvZ).dsB().setRequestedOrientation(12);
      a.b(this.zvZ, parami, parambs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280474);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253544);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = parami.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        paramView = paramView.ekY();
        if ((paramView != null) && (paramView.xkX == 48))
        {
          a.a(this.zvZ).dsB().finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(253544);
          return;
        }
      }
      a.a(this.zvZ, parami, parambs);
      paramView = new Intent();
      paramView.putExtra("finder_username", this.kyF);
      paramView.putExtra("KEY_FINDER_SELF_FLAG", p.h(this.kyF, z.bdh()));
      paramView.putExtra("key_enter_profile_tab", 2);
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = parami.getContext();
      p.j(localObject, "holder.context");
      aj.a.a((Context)localObject, paramView, parambs.dKW(), 1, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject = parami.getContext();
      p.j(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253544);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(a parama, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290766);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$closeBtnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!a.a(this.zvZ).pQ(true))
      {
        paramView = parami.getContext();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(290766);
          throw paramView;
        }
        ((Activity)paramView).finish();
        a.a(this.zvZ).dsB().overridePendingTransition(b.a.anim_not_change, b.a.sight_slide_bottom_out);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$closeBtnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290766);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(a parama, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279844);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initPlayCtrlLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = a.zvX;
      a.a.a(this.tDl, a.a(this.zvZ));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initPlayCtrlLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279844);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(a parama, List paramList, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277795);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initPlayCtrlLayout$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.j(paramView, "it");
      localObject = paramView.getTag();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(277795);
        throw paramView;
      }
      int j = ((Integer)localObject).intValue();
      a.a(this.zvZ).zxP = j;
      localObject = ((Iterable)this.zwg).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextView localTextView = (TextView)((Iterator)localObject).next();
        if (p.h(localTextView, paramView))
        {
          if (localTextView != null)
          {
            Context localContext = this.tDl.getContext();
            p.j(localContext, "holder.context");
            localTextView.setTextColor(localContext.getResources().getColor(b.c.hot_tab_Orange_100));
          }
        }
        else if (localTextView != null) {
          localTextView.setTextColor(-1);
        }
      }
      float f = 0.5F * j;
      paramView = (FinderVideoLayout)this.tDl.RD(b.f.finder_banner_video_layout);
      int i;
      if (paramView != null)
      {
        paramView = paramView.getVideoView();
        localObject = paramView;
        if (!(paramView instanceof FinderThumbPlayerProxy)) {
          localObject = null;
        }
        paramView = (FinderThumbPlayerProxy)localObject;
        if (paramView != null) {
          paramView.setPlaySpeed(f);
        }
        paramView = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
        com.tencent.mm.plugin.finder.megavideo.floatball.a.a.dJH().setPlaySpeed(f);
        paramView = (MegaVideoBulletView)this.tDl.RD(b.f.bullet_layout);
        if (paramView != null)
        {
          paramView = paramView.getBulletManager();
          if (paramView != null)
          {
            localObject = this.tDl.getContext();
            p.j(localObject, "holder.context");
            localObject = ((Context)localObject).getResources();
            p.j(localObject, "holder.context.resources");
            if (((Resources)localObject).getConfiguration().orientation != 2) {
              break label553;
            }
            i = 1;
            label332:
            if (i == 0) {
              break label558;
            }
            i = 12000;
            label340:
            localObject = com.tencent.mm.danmaku.c.a.azC();
            p.j(localObject, "DanmakuContext.getWindowConfig()");
            ((com.tencent.mm.danmaku.c.m)localObject).setDuration((int)(i / f));
            paramView = paramView.zvw;
            if (paramView == null) {
              p.bGy("danmakuManager");
            }
            paramView.ayH();
          }
        }
        paramView = a.zvX;
        a.a.d(this.tDl, j);
        switch (a.a(this.zvZ).zxP)
        {
        default: 
          i = b.j.mega_video_play_speed_text_land;
          label440:
          ((TextView)this.tDl.RD(b.f.play_speed_ctrl_btn)).setText(i);
          if (a.a(this.zvZ).zxP != 2) {
            break;
          }
        }
      }
      for (paramView = this.tDl.getContext().getString(b.j.mega_video_play_speed_normal_times);; paramView = this.tDl.getContext().getString(b.j.mega_video_play_speed_times, new Object[] { Float.valueOf(f) }))
      {
        p.j(paramView, "if (presenter.currentPla…_play_speed_times, ratio)");
        w.makeText(this.tDl.getContext(), (CharSequence)this.tDl.getContext().getString(b.j.mega_video_play_speed_change_toast, new Object[] { paramView }), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initPlayCtrlLayout$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277795);
        return;
        paramView = null;
        break;
        label553:
        i = 0;
        break label332;
        label558:
        i = 6000;
        break label340;
        i = b.j.mega_video_play_speed_0_5;
        break label440;
        i = b.j.mega_video_play_speed_text_land;
        break label440;
        i = b.j.mega_video_play_speed_1_5;
        break label440;
        i = b.j.mega_video_play_speed_2;
        break label440;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class t
    implements HardTouchableLayout.g
  {
    t(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void et(View paramView)
    {
      AppMethodBeat.i(267338);
      p.k(paramView, "view");
      if (this.zvZ.zvU)
      {
        Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: has been blocked");
        this.zvZ.zvU = false;
        AppMethodBeat.o(267338);
        return;
      }
      if (a.r(this.xhb))
      {
        Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: hide bullet op layout");
        AppMethodBeat.o(267338);
        return;
      }
      if (a.a(this.zvZ, this.xhb, this.zwa))
      {
        Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: hide bullet input layout");
        AppMethodBeat.o(267338);
        return;
      }
      paramView = a.zvX;
      if (a.a.d(this.xhb, 0))
      {
        Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: hide play speed ctrl layout");
        AppMethodBeat.o(267338);
        return;
      }
      paramView = a.zvX;
      a.a.a(this.xhb, this.zwa, (Activity)a.a(this.zvZ).dsB(), null);
      AppMethodBeat.o(267338);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class u
    implements HardTouchableLayout.b
  {
    u(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(291812);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      Log.i("Finder.FinderLongVideoConvert", "onDoubleClick " + (bs)this.xhb.ihX());
      a.a(this.zvZ, this.xhb, paramMotionEvent);
      AppMethodBeat.o(291812);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class v
    implements View.OnLongClickListener
  {
    v(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(292159);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      bs localbs = (bs)this.tDl.ihX();
      paramView = (FinderVideoLayout)this.tDl.RD(b.f.finder_banner_video_layout);
      if (paramView != null)
      {
        paramView = paramView.getPlayInfo();
        if (paramView == null) {}
      }
      for (paramView = paramView.zBB;; paramView = null)
      {
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = this.tDl.getContext();
        if (localObject1 != null) {
          break;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(292159);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.viewmodel.component.m localm = (com.tencent.mm.plugin.finder.viewmodel.component.m)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject1).i(com.tencent.mm.plugin.finder.viewmodel.component.m.class);
      Context localContext = this.tDl.getContext();
      p.j(localContext, "holder.context");
      p.j(localbs, "item");
      com.tencent.mm.view.recyclerview.i locali = this.tDl;
      p.k(localContext, "context");
      p.k(localbs, "item");
      p.k(locali, "holder");
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(localContext, 0, false);
      long l = localbs.mf();
      JSONObject localJSONObject = new JSONObject();
      localObject1 = localJSONObject.put("tag", "ClickMoreDebug").put("feedId", com.tencent.mm.ae.d.Fw(l)).put("signedFeedId", l);
      Object localObject2 = localbs.xcy;
      int i;
      if (localObject2 != null)
      {
        i = ((cvy)localObject2).createTime;
        localObject2 = ((JSONObject)localObject1).put("feedTime", Util.formatUnixTime(i * 1L));
        localObject1 = (csg)j.lp((List)localbs.dKV());
        if (localObject1 == null) {
          break label860;
        }
        localObject1 = Integer.valueOf(((csg)localObject1).videoDuration);
        label312:
        localObject1 = ((JSONObject)localObject2).put("videoDuration", localObject1).put("isMegaVideo", true);
        if (paramView == null) {
          break label866;
        }
        paramView = paramView.ztP;
        label338:
        localObject2 = ((JSONObject)localObject1).put("file_format", paramView);
        paramView = localbs.contact;
        if (paramView != null)
        {
          localObject1 = paramView.username;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        localObject1 = ((JSONObject)localObject2).put("username", paramView);
        paramView = com.tencent.mm.plugin.finder.api.d.wZQ;
        paramView = localbs.contact;
        if (paramView == null) {
          break label871;
        }
        paramView = paramView.username;
        label404:
        paramView = ((JSONObject)localObject1).put("isFollow", d.a.aAN(paramView));
        localObject1 = (csg)j.lp((List)localbs.dKV());
        if (localObject1 == null) {
          break label876;
        }
        i = ((csg)localObject1).mediaType;
        label443:
        localObject2 = paramView.put("mediaType", i);
        paramView = (csg)j.lp((List)localbs.dKV());
        if (paramView != null)
        {
          localObject1 = paramView.url;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        localObject1 = ((JSONObject)localObject2).put("mediaId", MD5Util.getMD5String(paramView));
        paramView = (csg)j.lp((List)localbs.dKV());
        if (paramView == null) {
          break label881;
        }
        paramView = p.I(paramView.url, Util.nullAsNil(paramView.url_token));
        label537:
        localObject1 = ((JSONObject)localObject1).put("url", paramView);
        paramView = (csg)j.lp((List)localbs.dKV());
        if (paramView == null) {
          break label886;
        }
        paramView = p.I(paramView.thumbUrl, Util.nullAsNil(paramView.thumb_url_token));
        label582:
        localObject1 = ((JSONObject)localObject1).put("thumbUrl", paramView);
        paramView = (csg)j.lp((List)localbs.dKV());
        if (paramView == null) {
          break label891;
        }
      }
      label860:
      label866:
      label871:
      label876:
      label881:
      label886:
      label891:
      for (paramView = p.I(paramView.coverUrl, Util.nullAsNil(paramView.cover_url_token));; paramView = null)
      {
        localObject2 = ((JSONObject)localObject1).put("coverUrl", paramView).put("description", localbs.dKV());
        paramView = localbs.xcy;
        if (paramView != null)
        {
          localObject1 = paramView.debugMessage;
          paramView = (View)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramView = "";
        }
        ((JSONObject)localObject2).put("debugMessage", paramView);
        localObject2 = new StringBuilder("content=");
        localObject1 = localbs.xcy;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = new cvy();
        }
        paramView = kotlin.n.n.bHx(com.tencent.mm.ae.g.bN(paramView));
        Log.e(com.tencent.mm.plugin.finder.viewmodel.component.m.TAG, "long click more button! ".concat(String.valueOf(localJSONObject)));
        Log.e(com.tencent.mm.plugin.finder.viewmodel.component.m.TAG, "long click more button allInfo! ".concat(String.valueOf(paramView)));
        if (com.tencent.mm.plugin.finder.viewmodel.component.m.eks())
        {
          locale.a((q.f)new m.d(localm));
          locale.a((q.g)new m.e(localm, localContext, localJSONObject, localbs, l, paramView, locali));
          locale.eik();
        }
        this.tDl.amk.requestLayout();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(292159);
        return true;
        i = 0;
        break;
        localObject1 = null;
        break label312;
        paramView = null;
        break label338;
        paramView = null;
        break label404;
        i = 0;
        break label443;
        paramView = null;
        break label537;
        paramView = null;
        break label582;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(a parama, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269136);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = (bs)this.tDl.ihX();
      localObject1 = new com.tencent.mm.ui.widget.a.e(this.tDl.getContext(), 0, false);
      Object localObject2 = this.zvZ;
      com.tencent.mm.view.recyclerview.i locali = this.tDl;
      p.j(paramView, "item");
      a.a((a)localObject2, locali, paramView);
      localObject2 = a.zvX;
      a.a.d(this.tDl, 0);
      localObject2 = a.a(this.zvZ);
      p.k(paramView, "feed");
      p.k(localObject1, "sheet");
      ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.f)new f.h((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject2, paramView));
      localObject2 = a.a(this.zvZ);
      p.k(paramView, "feed");
      ((com.tencent.mm.ui.widget.a.e)localObject1).b((q.f)new f.i((com.tencent.mm.plugin.finder.megavideo.ui.f)localObject2, paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject1).a(a.a(this.zvZ).a(paramView, this.tDl));
      ((com.tencent.mm.ui.widget.a.e)localObject1).b(a.a(this.zvZ).a(paramView, this.tDl));
      ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(287199);
          Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject = this.zwh.tDl.getContext();
          p.j(localObject, "holder.context");
          localObject = aj.a.fZ((Context)localObject);
          if (localObject != null) {}
          for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
          {
            bs localbs = (bs)this.zwh.tDl.ihX();
            com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
            p.j(localbs, "feed");
            com.tencent.mm.plugin.finder.report.n.a(localn, localbs, 2, 3L, "", (bid)localObject);
            AppMethodBeat.o(287199);
            return;
          }
        }
      });
      ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269136);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class x
    implements View.OnClickListener
  {
    x(a parama, com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277208);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = (FinderVideoLayout)this.tDl.RD(b.f.finder_banner_video_layout);
      int i;
      com.tencent.mm.plugin.finder.megavideo.ui.f localf;
      bs localbs;
      com.tencent.mm.view.recyclerview.i locali;
      if (paramView != null)
      {
        i = paramView.getCurrentPosSec();
        localf = a.a(this.zvZ);
        localbs = this.zwd;
        locali = this.tDl;
        p.k(localbs, "item");
        p.k(locali, "holder");
        Log.i("FinderLongVideoTLPresenter", "addVideoFloatBall: id = " + localbs.mf() + ", videoCurrPlayTimes = " + i);
        if ((!com.tencent.mm.q.a.p((Context)localf.ycV, true)) && (!com.tencent.mm.q.a.r((Context)localf.ycV, true)) && (!com.tencent.mm.q.a.cB((Context)localf.ycV)) && (!com.tencent.mm.q.a.cA((Context)localf.ycV))) {
          break label235;
        }
        Log.w("FinderLongVideoTLPresenter", "addVideoFloatBall: failed to add video float ball, id = " + localbs.mf());
      }
      label235:
      boolean bool;
      label316:
      com.tencent.mm.plugin.finder.megavideo.floatball.a locala;
      cwl localcwl;
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277208);
          return;
          i = 0;
          break;
          bool = false;
          if (com.tencent.mm.q.a.q(null, false))
          {
            paramView = ah.yhC;
            ah.dzx();
            bool = true;
          }
          if (com.tencent.mm.compatible.e.b.ct((Context)localf.ycV)) {
            break label316;
          }
          Log.w("FinderLongVideoTLPresenter", "showVideoTalking, permission denied");
          RequestFloatWindowPermissionDialog.a((Context)localf.ycV, localf.ycV.getString(b.j.mega_video_float_permission_alert_content), (RequestFloatWindowPermissionDialog.a)new f.d(), false, com.tencent.mm.bx.a.awc());
        }
        if (localf.zxK == null)
        {
          ((com.tencent.mm.plugin.finder.megavideo.ui.f)localf).zxK = new cwl();
          paramView = kotlin.x.aazN;
        }
        paramView = com.tencent.mm.plugin.finder.megavideo.floatball.a.zwo;
        locala = com.tencent.mm.plugin.finder.megavideo.floatball.a.a.dJH();
        localcwl = localf.zxK;
      } while (localcwl == null);
      paramView = localbs.contact;
      if (paramView != null)
      {
        localObject = paramView.headUrl;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      locala.aox(paramView);
      paramView = localbs.xcy;
      label421:
      int j;
      if (paramView != null)
      {
        paramView = paramView.TEM;
        if (paramView != null)
        {
          paramView = paramView.description;
          if (!Util.isNullOrNil(paramView)) {
            break label711;
          }
          localObject = localf.ycV.getResources();
          j = b.j.mega_video_post_ui_desc_tv_hint;
          Context localContext = (Context)localf.ycV;
          paramView = localbs.contact;
          if (paramView == null) {
            break label706;
          }
          paramView = paramView.nickname;
          label467:
          paramView = ((Resources)localObject).getString(j, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)paramView) });
          label490:
          locala.aoy(paramView);
          localObject = localf.ycV;
          paramView = (View)localObject;
          if (!(localObject instanceof FinderLongVideoTimelineUI)) {
            paramView = null;
          }
          paramView = (FinderLongVideoTimelineUI)paramView;
          if (paramView == null) {
            break label743;
          }
          j = paramView.xQJ;
          label530:
          localcwl.TFj = j;
          localcwl.TFi = i;
          paramView = localf.zxg;
          if (paramView == null) {
            p.bGy("feedLoader");
          }
          localcwl.lastBuffer = paramView.getLastBuffer();
          localcwl.TFg.clear();
          localcwl.TFk.clear();
          localcwl.TFk.add(localbs.getFeedObject());
          locala.n("KEY_VIDEO_FLOAT_BALL_INFO", localcwl.toByteArray());
          locala.a(locali, bool, localbs.mf(), localbs.dKW());
          paramView = new Intent();
          paramView.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", i * 1000L);
          localObject = localbs.xcy;
          if (localObject == null) {
            break label748;
          }
        }
      }
      label706:
      label711:
      label743:
      label748:
      for (long l = ((cvy)localObject).id;; l = 0L)
      {
        paramView.putExtra("KEY_CACHE_OBJECT_ID", l);
        localf.ycV.setResult(-1, paramView);
        localf.ycV.finish();
        break;
        paramView = null;
        break label421;
        paramView = null;
        break label467;
        paramView = localbs.xcy;
        if (paramView != null)
        {
          paramView = paramView.TEM;
          if (paramView != null)
          {
            paramView = paramView.description;
            break label490;
          }
        }
        paramView = null;
        break label490;
        j = 0;
        break label530;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onHideSmileyPanel$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class y
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(224499);
      a.a(this.zvZ).dJX().setAlpha(1.0F);
      a.a(this.zvZ).dJX().setVisibility(4);
      AppMethodBeat.o(224499);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class z
    implements CommentDrawerContract.CloseDrawerCallback
  {
    z(com.tencent.mm.view.recyclerview.i parami, bs parambs) {}
    
    public final void i(int paramInt, List<? extends s> paramList)
    {
      AppMethodBeat.i(292263);
      p.k(paramList, "data");
      a.a(this.zvZ, this.tDl, this.zwd.getFeedObject().commentCount);
      paramList = new ig();
      paramList.fFp.feedId = this.zwd.getFeedObject().id;
      paramList.fFp.fFr = this.zwd.getFeedObject().commentCount;
      EventCenter.instance.publish((IEvent)paramList);
      a.a(this.zvZ).dsB().setRequestedOrientation(-1);
      AppMethodBeat.o(292263);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.a
 * JD-Core Version:    0.7.0.1
 */