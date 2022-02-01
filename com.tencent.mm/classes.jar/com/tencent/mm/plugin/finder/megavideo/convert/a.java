package com.tencent.mm.plugin.finder.megavideo.convert;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoTLFooterLayout;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.f.g;
import com.tencent.mm.plugin.finder.megavideo.ui.f.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.List;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "closeDetailDesc", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "convertMedia", "item", "position", "", "type", "doFav", "doLike", "isPrivate", "", "doShare", "getLayoutId", "getLikeIcon", "filled", "private", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "initFoldButtons", "initFooterLayout", "initHeaderLayout", "initToggleHeaderAndFooter", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "openCommentDrawer", "refreshCommentLayout", "totalCommentCount", "refreshFavLayout", "isFav", "favCount", "refreshLikeLayout", "isLike", "likeCount", "setGroupLikeIcon", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.view.recyclerview.e<bm>
{
  private static final int tzZ = 10003;
  public static final a uKl;
  private final com.tencent.mm.plugin.finder.video.k tCD;
  private final f uKk;
  
  static
  {
    AppMethodBeat.i(248334);
    uKl = new a((byte)0);
    tzZ = 10003;
    AppMethodBeat.o(248334);
  }
  
  public a(com.tencent.mm.plugin.finder.video.k paramk, f paramf)
  {
    AppMethodBeat.i(248333);
    this.tCD = paramk;
    this.uKk = paramf;
    AppMethodBeat.o(248333);
  }
  
  private static int a(boolean paramBoolean1, boolean paramBoolean2, FinderObject paramFinderObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(248331);
    Object localObject2 = y.vXH;
    localObject2 = paramFinderObject.contact;
    paramFinderObject = localObject1;
    if (localObject2 != null) {
      paramFinderObject = com.tencent.mm.plugin.finder.api.b.a((FinderContact)localObject2, null);
    }
    if (y.i(paramFinderObject))
    {
      if (paramBoolean1)
      {
        AppMethodBeat.o(248331);
        return 2131690239;
      }
      AppMethodBeat.o(248331);
      return 2131690283;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        AppMethodBeat.o(248331);
        return 2131690239;
      }
      AppMethodBeat.o(248331);
      return 2131690436;
    }
    AppMethodBeat.o(248331);
    return 2131690453;
  }
  
  private static void a(WeImageView paramWeImageView, azu paramazu)
  {
    AppMethodBeat.i(248330);
    if (paramazu != null)
    {
      paramazu = paramazu.LJJ;
      localObject = (CharSequence)paramazu;
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
      paramWeImageView.setImageResource(2131690578);
      paramazu = paramWeImageView.getContext();
      kotlin.g.b.p.g(paramazu, "imageView.context");
      paramWeImageView.setIconColor(paramazu.getResources().getColor(2131099824));
      AppMethodBeat.o(248330);
      return;
      paramazu = null;
      break;
    }
    label89:
    Object localObject = paramWeImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).clearColorFilter();
    }
    paramWeImageView.setClearColorFilter(true);
    paramWeImageView.setIconColor(0);
    localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
    localObject = com.tencent.mm.plugin.finder.loader.m.djY();
    paramazu = new com.tencent.mm.plugin.finder.loader.p(paramazu, com.tencent.mm.plugin.finder.storage.x.vEn);
    paramWeImageView = (ImageView)paramWeImageView;
    com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
    ((com.tencent.mm.loader.d)localObject).a(paramazu, paramWeImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
    AppMethodBeat.o(248330);
  }
  
  private final void a(final com.tencent.mm.view.recyclerview.h paramh, final bm parambm)
  {
    AppMethodBeat.i(248326);
    paramh.Mn(2131298770).setOnClickListener((View.OnClickListener)new q(this, paramh));
    Object localObject1 = parambm.contact;
    final String str;
    label62:
    Object localObject2;
    if (localObject1 != null)
    {
      str = ((FinderContact)localObject1).username;
      if (str != null)
      {
        localObject1 = parambm.contact;
        if (localObject1 == null) {
          break label324;
        }
        localObject1 = ((FinderContact)localObject1).headUrl;
        localObject1 = Util.nullAsNil((String)localObject1);
        localObject2 = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject2 = c.a.asG(str);
        if (localObject2 == null) {
          break label329;
        }
        if (Util.isNullOrNil(((com.tencent.mm.plugin.finder.api.g)localObject2).cXH())) {
          break label381;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject2).cXH();
      }
    }
    label136:
    label324:
    label329:
    label342:
    label349:
    label381:
    for (;;)
    {
      Object localObject3 = y.vXH;
      localObject3 = paramh.Mn(2131297096);
      kotlin.g.b.p.g(localObject3, "holder.getView<ImageView>(R.id.auth_icon)");
      y.a((ImageView)localObject3, ((com.tencent.mm.plugin.finder.api.g)localObject2).field_authInfo);
      localObject2 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject2 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = paramh.Mn(2131297134);
      kotlin.g.b.p.g(localObject3, "holder.getView(R.id.avatar_iv)");
      localObject3 = (ImageView)localObject3;
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      localObject1 = paramh.Mn(2131305440);
      kotlin.g.b.p.g(localObject1, "holder.getView<TextView>(R.id.nickname_tv)");
      localObject2 = (TextView)localObject1;
      localObject3 = paramh.getContext();
      localObject1 = parambm.contact;
      if (localObject1 != null)
      {
        localObject1 = ((FinderContact)localObject1).nickname;
        if (localObject1 == null) {}
      }
      for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
      {
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
        paramh.Mn(2131297137).setOnClickListener((View.OnClickListener)new r(this, paramh, str, parambm));
        if (!parambm.isPrivate()) {
          break label349;
        }
        paramh = paramh.Mn(2131303761);
        if (paramh == null) {
          break label342;
        }
        paramh.setVisibility(0);
        AppMethodBeat.o(248326);
        return;
        str = null;
        break;
        localObject1 = null;
        break label62;
        break label136;
      }
      AppMethodBeat.o(248326);
      return;
      paramh = paramh.Mn(2131303761);
      if (paramh != null)
      {
        paramh.setVisibility(8);
        AppMethodBeat.o(248326);
        return;
      }
      AppMethodBeat.o(248326);
      return;
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, com.tencent.mm.view.recyclerview.h paramh, bm parambm)
  {
    int j = 1;
    AppMethodBeat.i(248329);
    Object localObject2 = (WeImageView)paramh.Mn(2131304583);
    int i;
    Object localObject1;
    label101:
    int k;
    Object localObject3;
    label170:
    boolean bool;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        kotlin.g.b.p.g(localObject2, "likeIv");
        ((WeImageView)localObject2).setTag(Integer.valueOf(2));
        i = a(true, paramBoolean2, parambm.getFeedObject());
        localObject1 = paramh.getContext();
        kotlin.g.b.p.g(localObject1, "holder.context");
        localObject1 = new o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(2131099824)));
        i = ((Number)((o)localObject1).first).intValue();
        k = ((Number)((o)localObject1).second).intValue();
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        localObject3 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(parambm.getFeedObject().objectType);
        localObject1 = y.vXH;
        localObject1 = parambm.contact;
        if (localObject1 == null) {
          break label362;
        }
        localObject1 = com.tencent.mm.plugin.finder.api.b.a((FinderContact)localObject1, null);
        bool = y.i((com.tencent.mm.plugin.finder.api.g)localObject1);
        if ((!paramBoolean2) || (!paramBoolean1) || (bool)) {
          break label368;
        }
        a((WeImageView)localObject2, (azu)localObject3);
        label197:
        if (!this.uKk.uLZ) {
          break label503;
        }
        i = 1;
        label210:
        localObject1 = (TextView)paramh.Mn(2131304584);
        if (paramInt <= 0) {
          break label509;
        }
        paramh = com.tencent.mm.plugin.finder.utils.k.gm(i, paramInt);
        kotlin.g.b.p.g(paramh, "FinderFormatUtil.formatNumber(scene, likeCount)");
      }
    }
    for (;;)
    {
      kotlin.g.b.p.g(localObject1, "likeTv");
      ((TextView)localObject1).setText((CharSequence)paramh);
      AppMethodBeat.o(248329);
      return;
      kotlin.g.b.p.g(localObject2, "likeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(1));
      break;
      kotlin.g.b.p.g(localObject2, "likeIv");
      ((WeImageView)localObject2).setTag(Integer.valueOf(0));
      i = a(false, paramBoolean2, parambm.getFeedObject());
      localObject1 = paramh.getContext();
      kotlin.g.b.p.g(localObject1, "holder.context");
      localObject1 = new o(Integer.valueOf(i), Integer.valueOf(((Context)localObject1).getResources().getColor(2131099844)));
      break label101;
      label362:
      localObject1 = null;
      break label170;
      label368:
      if ((localObject3 != null) && (!bool) && (!paramBoolean2))
      {
        if (paramBoolean1) {}
        for (localObject1 = ((azu)localObject3).LJE;; localObject1 = ((azu)localObject3).LJG)
        {
          localObject3 = ((WeImageView)localObject2).getDrawable();
          if (localObject3 != null) {
            ((Drawable)localObject3).clearColorFilter();
          }
          ((WeImageView)localObject2).setClearColorFilter(true);
          ((WeImageView)localObject2).setIconColor(0);
          localObject3 = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject3 = com.tencent.mm.plugin.finder.loader.m.djY();
          localObject1 = new com.tencent.mm.plugin.finder.loader.p((String)localObject1, com.tencent.mm.plugin.finder.storage.x.vEn);
          localObject2 = (ImageView)localObject2;
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
          break;
        }
      }
      ((WeImageView)localObject2).setImageResource(i);
      ((WeImageView)localObject2).setIconColor(k);
      break label197;
      label503:
      i = 2;
      break label210;
      label509:
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
      parambm = com.tencent.mm.plugin.finder.storage.logic.g.Lj(parambm.getFeedObject().objectType);
      if (parambm != null)
      {
        localObject2 = (CharSequence)parambm.LJI;
        paramInt = j;
        if (localObject2 != null) {
          if (((CharSequence)localObject2).length() != 0) {
            break label591;
          }
        }
      }
      label591:
      for (paramInt = j;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label596;
        }
        paramh = paramh.getContext().getString(2131759831);
        kotlin.g.b.p.g(paramh, "holder.context.getString…g.finder_like_count_text)");
        break;
      }
      label596:
      parambm = parambm.LJI;
      paramh = parambm;
      if (parambm == null) {
        paramh = "";
      }
    }
  }
  
  private final void b(com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(248328);
    int i;
    if (this.uKk.uLZ)
    {
      i = 1;
      if (paramInt <= 0) {
        break label68;
      }
    }
    label68:
    for (String str = com.tencent.mm.plugin.finder.utils.k.gm(i, paramInt);; str = paramh.getContext().getString(2131759594))
    {
      paramh = paramh.Mn(2131304578);
      kotlin.g.b.p.g(paramh, "holder.getView<TextView>…a_video_comment_count_tv)");
      ((TextView)paramh).setText((CharSequence)str);
      AppMethodBeat.o(248328);
      return;
      i = 2;
      break;
    }
  }
  
  private final void b(final com.tencent.mm.view.recyclerview.h paramh, final bm parambm)
  {
    AppMethodBeat.i(248327);
    Object localObject1 = paramh.Mn(2131310329);
    Object localObject2 = parambm.tuP;
    int i;
    if (localObject2 != null)
    {
      i = ((cng)localObject2).MtL;
      if (i == 0) {
        break label660;
      }
      kotlin.g.b.p.g(localObject1, "warnContainer");
      ((View)localObject1).setVisibility(0);
      localObject1 = paramh.Mn(2131310332);
      kotlin.g.b.p.g(localObject1, "holder.getView<TextView>(R.id.warn_word_tv)");
      localObject2 = (TextView)localObject1;
      localObject1 = parambm.tuP;
      if (localObject1 == null) {
        break label649;
      }
      localObject1 = ((cng)localObject1).MtM;
      if (localObject1 == null) {
        break label649;
      }
      localObject1 = (CharSequence)localObject1;
      label104:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      label111:
      localObject2 = (FinderCollapsibleTextView)paramh.Mn(2131299513);
      localObject1 = parambm.tuP;
      if (localObject1 == null) {
        break label678;
      }
      localObject1 = ((cng)localObject1).MtG;
      if (localObject1 == null) {
        break label678;
      }
      localObject1 = ((cnl)localObject1).description;
      if (localObject1 == null) {
        break label678;
      }
      localObject1 = (CharSequence)localObject1;
      label165:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label700;
      }
      kotlin.g.b.p.g(localObject2, "descriptionTv");
      ((FinderCollapsibleTextView)localObject2).setVisibility(0);
      Context localContext = paramh.getContext();
      localObject1 = parambm.tuP;
      if (localObject1 == null) {
        break label689;
      }
      localObject1 = ((cng)localObject1).MtG;
      if (localObject1 == null) {
        break label689;
      }
      localObject1 = ((cnl)localObject1).description;
      if (localObject1 == null) {
        break label689;
      }
      localObject1 = (CharSequence)localObject1;
      label235:
      ((FinderCollapsibleTextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)localObject1));
      label250:
      ((FinderCollapsibleTextView)localObject2).post((Runnable)new l(this, (FinderCollapsibleTextView)localObject2, paramh));
      localObject1 = paramh.Mn(2131304582);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new m(this, parambm, paramh));
      }
      localObject1 = paramh.Mn(2131304590);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new k(this, parambm, paramh));
        localObject2 = parambm.tuP;
        if (localObject2 == null) {
          break label718;
        }
        i = ((cng)localObject2).forwardCount;
        label351:
        if ((!this.uKk.uLZ) || (i <= 0)) {
          break label723;
        }
      }
    }
    label649:
    label660:
    label678:
    label689:
    label700:
    label718:
    label723:
    for (localObject1 = com.tencent.mm.plugin.finder.utils.k.gm(1, i);; localObject1 = ((View)localObject1).getContext().getString(2131760567))
    {
      localObject2 = paramh.Mn(2131304589);
      kotlin.g.b.p.g(localObject2, "holder.getView<TextView>…ega_video_share_count_tv)");
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = paramh.Mn(2131304585);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new n(this, parambm, paramh));
      }
      localObject1 = paramh.Mn(2131304585);
      if (localObject1 != null) {
        ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new o(this, parambm, paramh));
      }
      localObject1 = paramh.Mn(2131304585);
      if (localObject1 != null) {
        ((View)localObject1).setHapticFeedbackEnabled(false);
      }
      paramh.Mn(2131304579).setOnClickListener((View.OnClickListener)new p(this, paramh, parambm));
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
      boolean bool1 = com.tencent.mm.plugin.finder.upload.action.c.dBq().k(parambm.getFeedObject());
      localObject1 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
      b(bool1, com.tencent.mm.plugin.finder.upload.action.c.dBq().l(parambm.getFeedObject()), paramh);
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      bool1 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.j.dBt().m(parambm.getFeedObject()).first).booleanValue();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.upload.action.j.dBt().m(parambm.getFeedObject()).second).booleanValue();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
      a(bool1, bool2, com.tencent.mm.plugin.finder.upload.action.j.dBt().n(parambm.getFeedObject()), paramh, parambm);
      b(paramh, parambm.getFeedObject().commentCount);
      AppMethodBeat.o(248327);
      return;
      i = 0;
      break;
      localObject1 = (CharSequence)"";
      break label104;
      kotlin.g.b.p.g(localObject1, "warnContainer");
      ((View)localObject1).setVisibility(8);
      break label111;
      localObject1 = (CharSequence)"";
      break label165;
      localObject1 = (CharSequence)"";
      break label235;
      kotlin.g.b.p.g(localObject2, "descriptionTv");
      ((FinderCollapsibleTextView)localObject2).setVisibility(8);
      break label250;
      i = 0;
      break label351;
    }
  }
  
  private final void b(boolean paramBoolean, int paramInt, com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(248332);
    WeImageView localWeImageView = (WeImageView)paramh.Mn(2131304580);
    if (localWeImageView != null)
    {
      if (paramBoolean)
      {
        localObject = paramh.getContext();
        kotlin.g.b.p.g(localObject, "holder.context");
        localObject = new o(Integer.valueOf(2131690253), Integer.valueOf(((Context)localObject).getResources().getColor(2131099793)));
        int i = ((Number)((o)localObject).first).intValue();
        int j = ((Number)((o)localObject).second).intValue();
        localWeImageView.setImageResource(i);
        localWeImageView.setIconColor(j);
      }
    }
    else {
      if ((!this.uKk.uLZ) || (paramInt <= 0)) {
        break label186;
      }
    }
    label186:
    for (Object localObject = com.tencent.mm.plugin.finder.utils.k.gm(1, paramInt);; localObject = paramh.getContext().getString(2131759707))
    {
      paramh = paramh.Mn(2131304581);
      kotlin.g.b.p.g(paramh, "holder.getView<TextView>….mega_video_fav_count_tv)");
      ((TextView)paramh).setText((CharSequence)localObject);
      AppMethodBeat.o(248332);
      return;
      localObject = new o(Integer.valueOf(2131690258), Integer.valueOf(-1));
      break;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(248324);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramh, "holder");
    FinderMediaBanner localFinderMediaBanner = (FinderMediaBanner)paramh.Mn(2131304549);
    FinderMediaBannerAdapter localFinderMediaBannerAdapter = new FinderMediaBannerAdapter(this.tCD);
    localFinderMediaBannerAdapter.isLongVideo = true;
    localFinderMediaBanner.setAdapter((RecyclerView.a)localFinderMediaBannerAdapter);
    localFinderMediaBanner.setParentRecyclerView(paramRecyclerView);
    localFinderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
    paramRecyclerView = (FinderCollapsibleTextView)paramh.Mn(2131299513);
    if (paramRecyclerView != null)
    {
      paramRecyclerView.setLimitLine(2);
      paramRecyclerView.setCollapse(true);
      paramRecyclerView.setTextColor(Color.parseColor("#CCFFFFFF"));
      paramRecyclerView.getCollapseTextView().setTextColor(Color.parseColor("#7D90A9"));
    }
    paramRecyclerView = paramh.Mn(2131298981);
    kotlin.g.b.p.g(paramRecyclerView, "holder.getView<TextView>…ompletely_description_tv)");
    ((TextView)paramRecyclerView).setMovementMethod(ScrollingMovementMethod.getInstance());
    AppMethodBeat.o(248324);
  }
  
  public final int getLayoutId()
  {
    return 2131494493;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion;", "", "()V", "FULLSCREEN_FLAG", "", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "payloadsProgressType", "payloadsRefreshBullet", "payloadsRefreshFav", "payloadsRefreshLike", "payloadsRefreshNormalData", "onConfigurationChange", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isLandscape", "", "resetAnimViews", "toggleHeaderFooter", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "activity", "Landroid/app/Activity;", "forceShow", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;Landroid/app/Activity;Ljava/lang/Boolean;)V", "plugin-finder_release"})
  public static final class a
  {
    public static void a(com.tencent.mm.view.recyclerview.h paramh, bm parambm, Activity paramActivity, Boolean paramBoolean)
    {
      int j = 0;
      AppMethodBeat.i(248283);
      kotlin.g.b.p.h(paramh, "holder");
      kotlin.g.b.p.h(parambm, "item");
      kotlin.g.b.p.h(paramActivity, "activity");
      View localView2 = paramh.Mn(2131304619);
      View localView1 = paramh.Mn(2131301669);
      kotlin.g.b.p.g(localView1, "footer");
      if (localView1.getVisibility() == 0) {}
      for (int i = 8; kotlin.g.b.p.j(paramBoolean, Boolean.TRUE); i = 0)
      {
        i = j;
        if (localView1.getVisibility() != 0) {
          break label125;
        }
        AppMethodBeat.o(248283);
        return;
      }
      if (kotlin.g.b.p.j(paramBoolean, Boolean.FALSE))
      {
        if (localView1.getVisibility() == 8)
        {
          AppMethodBeat.o(248283);
          return;
        }
        i = 8;
      }
      for (;;)
      {
        label125:
        paramBoolean = paramh.getContext();
        kotlin.g.b.p.g(paramBoolean, "holder.context");
        paramBoolean = paramBoolean.getResources();
        kotlin.g.b.p.g(paramBoolean, "holder.context.resources");
        if (paramBoolean.getConfiguration().orientation == 1)
        {
          kotlin.g.b.p.g(localView2, "header");
          localView2.setVisibility(i);
          localView1.setVisibility(i);
          if (parambm.djo())
          {
            paramh = paramh.Mn(2131309575);
            kotlin.g.b.p.g(paramh, "holder.getView<View>(R.id.unfold_video_button)");
            paramh.setVisibility(i);
            AppMethodBeat.o(248283);
          }
        }
        else
        {
          if (i != 8) {
            break label287;
          }
          paramh = paramActivity.getWindow();
          kotlin.g.b.p.g(paramh, "activity.window");
          paramh = paramh.getDecorView();
          kotlin.g.b.p.g(paramh, "activity.window.decorView");
          parambm = paramActivity.getWindow();
          kotlin.g.b.p.g(parambm, "activity.window");
          parambm = parambm.getDecorView();
          kotlin.g.b.p.g(parambm, "activity.window.decorView");
          paramh.setSystemUiVisibility(parambm.getSystemUiVisibility() | 0x806);
        }
        for (;;)
        {
          localView1.setVisibility(i);
          AppMethodBeat.o(248283);
          return;
          label287:
          paramh = paramActivity.getWindow();
          kotlin.g.b.p.g(paramh, "activity.window");
          paramh = paramh.getDecorView();
          kotlin.g.b.p.g(paramh, "activity.window.decorView");
          parambm = paramActivity.getWindow();
          kotlin.g.b.p.g(parambm, "activity.window");
          parambm = parambm.getDecorView();
          kotlin.g.b.p.g(parambm, "activity.window.decorView");
          paramh.setSystemUiVisibility(parambm.getSystemUiVisibility() & 0xFFFFF7F9);
        }
      }
    }
    
    public static void p(com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(248282);
      Object localObject = (MegaVideoTLFooterLayout)paramh.Mn(2131301669);
      ((MegaVideoTLFooterLayout)localObject).setListenKeyBoardChange(false);
      ((MegaVideoTLFooterLayout)localObject).setShowKeyboard(false);
      kotlin.g.b.p.g(localObject, "it");
      ((MegaVideoTLFooterLayout)localObject).setTranslationY(0.0F);
      localObject = ((FinderMediaBanner)paramh.Mn(2131304549)).getPagerViewContainer();
      ((FrameLayout)localObject).setTranslationY(0.0F);
      ((FrameLayout)localObject).setScaleX(1.0F);
      ((FrameLayout)localObject).setScaleY(1.0F);
      localObject = paramh.Mn(2131309575);
      kotlin.g.b.p.g(localObject, "holder.getView<View>(R.id.unfold_video_button)");
      ((View)localObject).setTranslationY(0.0F);
      paramh = (MegaVideoTLFooterLayout)paramh.Mn(2131301669);
      paramh.uMH = null;
      paramh.uMI = null;
      paramh.uMG = false;
      AppMethodBeat.o(248282);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$1", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(FinderMediaBanner paramFinderMediaBanner, a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$2", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$2"})
  static final class c
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    c(FinderMediaBanner paramFinderMediaBanner, a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isLoading", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$3", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$3"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    d(FinderMediaBanner paramFinderMediaBanner, a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class e
    implements u.b
  {
    public static final e uKo;
    
    static
    {
      AppMethodBeat.i(248288);
      uKo = new e();
      AppMethodBeat.o(248288);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(248287);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(2131309260);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(248287);
          return;
        }
      }
      AppMethodBeat.o(248287);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    public static final f uKp;
    
    static
    {
      AppMethodBeat.i(248290);
      uKp = new f();
      AppMethodBeat.o(248290);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(248289);
      kotlin.g.b.p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(10001, 2131760573);
        paramm.kV(10002, 2131760574);
      }
      AppMethodBeat.o(248289);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(a parama, bm parambm) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(248291);
      kotlin.g.b.p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(248291);
        return;
        Object localObject2 = a.a(this.uKm);
        paramMenuItem = this.uKq;
        kotlin.g.b.p.h(paramMenuItem, "megaVideo");
        Object localObject1 = com.tencent.mm.plugin.finder.utils.s.vWt;
        localObject2 = ((f)localObject2).uMk;
        FinderItem.a locala = FinderItem.Companion;
        s.a.a((s.a)localObject1, (AppCompatActivity)localObject2, FinderItem.a.a(paramMenuItem.getFeedObject(), 32768), 0, 12);
        AppMethodBeat.o(248291);
        return;
        localObject1 = a.a(this.uKm);
        paramMenuItem = this.uKq;
        kotlin.g.b.p.h(paramMenuItem, "megaVideo");
        localObject2 = com.tencent.mm.plugin.finder.utils.s.vWt;
        localObject1 = ((f)localObject1).uMk;
        localObject2 = FinderItem.Companion;
        s.a.a((AppCompatActivity)localObject1, (BaseFinderFeed)new ad(FinderItem.a.a(paramMenuItem.getFeedObject(), 32768)), 4, 0, 20);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    h(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(248292);
      Object localObject = FinderReporterUIC.wzC;
      localObject = this.qhp.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      localObject = FinderReporterUIC.a.fH((Context)localObject);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
      {
        bm localbm = (bm)this.qhp.hgv();
        com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
        kotlin.g.b.p.g(localbm, "feed");
        com.tencent.mm.plugin.finder.report.k.a(localbm, 1, 3L, "", (bbn)localObject);
        AppMethodBeat.o(248292);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248294);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      a.a(this.uKm).dcl().setRequestedOrientation(12);
      paramView.postDelayed((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248293);
          Object localObject = this.uKr.qhp.getContext();
          kotlin.g.b.p.g(localObject, "holder.context");
          localObject = ((Context)localObject).getResources();
          kotlin.g.b.p.g(localObject, "holder.context.resources");
          if (((Resources)localObject).getConfiguration().orientation == 2)
          {
            AppMethodBeat.o(248293);
            return;
          }
          a.a(this.uKr.uKm).dcl().setRequestedOrientation(-1);
          AppMethodBeat.o(248293);
        }
      }, 2000L);
      paramView = FinderReporterUIC.wzC;
      paramView = this.qhp.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        localObject1 = af.viA;
        localObject1 = this.uKq.tuP;
        if (localObject1 == null) {
          break label262;
        }
        localObject1 = ((cng)localObject1).MtI;
        if (localObject1 == null) {
          break label262;
        }
      }
      label262:
      for (long l = ((cns)localObject1).hFK;; l = 0L)
      {
        String str2 = com.tencent.mm.ac.d.zs(l);
        String str3 = com.tencent.mm.ac.d.zs(this.uKq.lT());
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
          str1 = paramView.sGQ;
          localObject2 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        if (paramView != null)
        {
          str1 = paramView.sGE;
          paramView = str1;
          if (str1 != null) {}
        }
        else
        {
          paramView = "";
        }
        af.a(str2, str3, 1, 2, (String)localObject1, (String)localObject2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248294);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248295);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      a.a(this.uKm).dcl().setRequestedOrientation(11);
      paramView = a.uKl;
      a.a.p(this.qhp);
      paramView = FinderReporterUIC.wzC;
      paramView = this.qhp.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        localObject1 = af.viA;
        localObject1 = this.uKq.tuP;
        if (localObject1 == null) {
          break label254;
        }
        localObject1 = ((cng)localObject1).MtI;
        if (localObject1 == null) {
          break label254;
        }
      }
      label254:
      for (long l = ((cns)localObject1).hFK;; l = 0L)
      {
        String str2 = com.tencent.mm.ac.d.zs(l);
        String str3 = com.tencent.mm.ac.d.zs(this.uKq.lT());
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
          str1 = paramView.sGQ;
          localObject2 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        if (paramView != null)
        {
          str1 = paramView.sGE;
          paramView = str1;
          if (str1 != null) {}
        }
        else
        {
          paramView = "";
        }
        af.a(str2, str3, 1, 1, (String)localObject1, (String)localObject2, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248295);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$3$1"})
  static final class k
    implements View.OnClickListener
  {
    k(a parama, bm parambm, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248296);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.b(this.uKm, parambm, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248296);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(a parama, FinderCollapsibleTextView paramFinderCollapsibleTextView, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(248308);
      Object localObject1 = this.uKs.getCollapseTextView();
      kotlin.g.b.p.g(localObject1, "descriptionTv.collapseTextView");
      if (((TextView)localObject1).getVisibility() == 0)
      {
        localObject1 = (TextView)paramh.Mn(2131298981);
        if (localObject1 != null)
        {
          localObject2 = paramh.getContext();
          kotlin.g.b.p.g(localObject2, "holder.context");
          Object localObject3 = ((Context)localObject2).getResources().getString(2131757650);
          kotlin.g.b.p.g(localObject3, "holder.context.resources…String(R.string.collapse)");
          localObject2 = this.uKs.getText() + '\n' + (String)localObject3;
          int i = n.a((CharSequence)localObject2, (String)localObject3, 0, false, 6);
          localObject3 = com.tencent.mm.pluginsdk.ui.span.l.c(paramh.getContext(), (CharSequence)localObject2);
          ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#7D90A9")), i, ((String)localObject2).length(), 33);
          ((TextView)localObject1).setText((CharSequence)localObject3);
        }
        localObject1 = new e(this);
        Object localObject2 = (View.OnClickListener)new d(this, (e)localObject1);
        this.uKs.getContentTextView().setOnClickListener((View.OnClickListener)localObject2);
        this.uKs.getCollapseTextView().setOnClickListener((View.OnClickListener)localObject2);
        paramh.Mn(2131298980).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(248304);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            a.o(this.uKt.qhp);
            this.uKt.qhp.getRecyclerView().b((RecyclerView.l)this.uKw);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248304);
          }
        });
        localObject2 = (TextView)paramh.Mn(2131298981);
        if (localObject2 != null)
        {
          ((TextView)localObject2).setOnClickListener((View.OnClickListener)new a(this, (e)localObject1));
          ((TextView)localObject2).setOnTouchListener((View.OnTouchListener)new b(this, (e)localObject1));
          ((TextView)localObject2).setOnLongClickListener((View.OnLongClickListener)new c(this, (e)localObject1));
          AppMethodBeat.o(248308);
          return;
        }
        AppMethodBeat.o(248308);
        return;
      }
      this.uKs.oV(true);
      AppMethodBeat.o(248308);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$3$1"})
    static final class a
      implements View.OnClickListener
    {
      a(a.l paraml, a.l.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(248297);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        a.o(this.uKt.qhp);
        this.uKt.qhp.getRecyclerView().b((RecyclerView.l)this.uKu);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248297);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$3$2"})
    static final class b
      implements View.OnTouchListener
    {
      b(a.l paraml, a.l.e parame) {}
      
      public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
      {
        AppMethodBeat.i(248298);
        kotlin.g.b.p.g(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
          this.uKt.qhp.getRecyclerView().requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          AppMethodBeat.o(248298);
          return false;
          this.uKt.qhp.getRecyclerView().requestDisallowInterceptTouchEvent(true);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$3$3"})
    static final class c
      implements View.OnLongClickListener
    {
      c(a.l paraml, a.l.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(248303);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$$special$$inlined$let$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        try
        {
          localObject = new com.tencent.mm.ui.widget.b.a(this.uKt.qhp.getContext());
          ((com.tencent.mm.ui.widget.b.a)localObject).a((o.g)new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(248299);
              if (paramAnonymousInt == 0)
              {
                paramAnonymousMenuItem = MMApplicationContext.getContext().getSystemService("clipboard");
                if (paramAnonymousMenuItem == null)
                {
                  paramAnonymousMenuItem = new t("null cannot be cast to non-null type android.content.ClipboardManager");
                  AppMethodBeat.o(248299);
                  throw paramAnonymousMenuItem;
                }
                ((ClipboardManager)paramAnonymousMenuItem).setText(this.uKv.uKt.uKs.getText());
              }
              AppMethodBeat.o(248299);
            }
          });
          ((com.tencent.mm.ui.widget.b.a)localObject).setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(248300);
              this.tzy.setBackgroundResource(2131101287);
              AppMethodBeat.o(248300);
            }
          });
          paramView.setBackgroundResource(2131100690);
          View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
            {
              AppMethodBeat.i(248301);
              paramAnonymousContextMenu.add(0, 0, 0, (CharSequence)this.uKv.uKt.qhp.getContext().getString(2131755772));
              AppMethodBeat.o(248301);
            }
          };
          o.g localg = (o.g)new o.g()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(248302);
              if (paramAnonymousInt == 0)
              {
                paramAnonymousMenuItem = MMApplicationContext.getContext().getSystemService("clipboard");
                if (paramAnonymousMenuItem == null)
                {
                  paramAnonymousMenuItem = new t("null cannot be cast to non-null type android.content.ClipboardManager");
                  AppMethodBeat.o(248302);
                  throw paramAnonymousMenuItem;
                }
                ((ClipboardManager)paramAnonymousMenuItem).setText(this.uKv.uKt.uKs.getText());
              }
              AppMethodBeat.o(248302);
            }
          };
          TouchableLayout.a locala = TouchableLayout.Rni;
          int i = TouchableLayout.hfC();
          locala = TouchableLayout.Rni;
          ((com.tencent.mm.ui.widget.b.a)localObject).a(paramView, localOnCreateContextMenuListener, localg, i, TouchableLayout.hfD());
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$$special$$inlined$let$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(248303);
          return true;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            Log.i("Finder.CollapsibleTextView", "[enableContentTextViewClick] errMsg:" + paramView.getMessage());
          }
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(a.l paraml, a.l.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(248305);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$listener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = this.uKt.qhp.Mn(2131298980);
        if (paramView != null)
        {
          paramView.setVisibility(0);
          localObject = this.uKt.qhp.Mn(2131304552);
          kotlin.g.b.p.g(localObject, "holder.getView<View>(R.id.media_container)");
          int i = ((View)localObject).getHeight();
          localObject = this.uKt.uKs;
          kotlin.g.b.p.g(localObject, "descriptionTv");
          int j = com.tencent.mm.ac.d.cm((View)localObject)[1];
          localObject = this.uKt.uKs;
          kotlin.g.b.p.g(localObject, "descriptionTv");
          paramView.setPadding(0, 0, 0, i - j - ((FinderCollapsibleTextView)localObject).getHeight());
        }
        paramView = this.uKt.uKs;
        kotlin.g.b.p.g(paramView, "descriptionTv");
        paramView.setVisibility(8);
        this.uKt.qhp.getRecyclerView().a((RecyclerView.l)this.uKw);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$listener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248305);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class e
      extends RecyclerView.l
    {
      public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
      {
        AppMethodBeat.i(248307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramRecyclerView);
        localb.pH(paramInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramRecyclerView, paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(248307);
      }
      
      public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(248306);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramRecyclerView);
        localb.pH(paramInt1);
        localb.pH(paramInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
        a.o(this.uKt.qhp);
        this.uKt.qhp.getRecyclerView().b((RecyclerView.l)this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(248306);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(a parama, bm parambm, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248309);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.a(this.uKm, parambm, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248309);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(a parama, bm parambm, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248310);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.a(this.uKm, parambm, paramh, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248310);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class o
    implements View.OnLongClickListener
  {
    o(a parama, bm parambm, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(248313);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtQ().value()).intValue() == 1)
      {
        paramView = y.vXH;
        paramView = parambm.contact;
        if (paramView == null) {
          break label217;
        }
      }
      label217:
      for (paramView = com.tencent.mm.plugin.finder.api.b.a(paramView, null);; paramView = null)
      {
        if (!y.i(paramView))
        {
          paramView = (WeImageView)paramh.Mn(2131304583);
          kotlin.g.b.p.g(paramView, "view");
          if (((paramView.getTag() instanceof Integer)) && (kotlin.g.b.p.j(paramView.getTag(), Integer.valueOf(0))))
          {
            paramView = new com.tencent.mm.ui.widget.a.e(paramh.getContext(), 1, true);
            paramView.setTitleView(aa.jQ(paramh.getContext()).inflate(2131494583, null));
            paramView.a((o.f)new o.f()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
              {
                AppMethodBeat.i(248311);
                kotlin.g.b.p.g(paramAnonymousm, "it");
                if (paramAnonymousm.gKQ())
                {
                  int i = a.dkg();
                  Context localContext = this.uKx.qhp.getContext();
                  kotlin.g.b.p.g(localContext, "holder.context");
                  paramAnonymousm.d(i, (CharSequence)localContext.getResources().getString(2131760445));
                }
                AppMethodBeat.o(248311);
              }
            });
            paramView.a((o.g)new o.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
              {
                AppMethodBeat.i(248312);
                kotlin.g.b.p.g(paramAnonymousMenuItem, "menuItem");
                if (paramAnonymousMenuItem.getItemId() == a.dkg()) {
                  a.a(this.uKx.uKm, this.uKx.uKq, this.uKx.qhp, true);
                }
                AppMethodBeat.o(248312);
              }
            });
            paramView.dGm();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(248313);
        return true;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248314);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      a.a(this.uKm).dcl().setRequestedOrientation(12);
      a.a(this.uKm, paramh, parambm);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248314);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(a parama, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248315);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!a.a(this.uKm).nJ(true))
      {
        paramView = paramh.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(248315);
          throw paramView;
        }
        ((Activity)paramView).finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248315);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(a parama, com.tencent.mm.view.recyclerview.h paramh, String paramString, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248316);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = FinderReporterUIC.wzC;
      paramView = paramh.getContext();
      kotlin.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        if ((paramView != null) && (paramView.tCE == 48))
        {
          a.a(this.uKm).dcl().finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248316);
          return;
        }
      }
      paramView = new Intent();
      paramView.putExtra("finder_username", str);
      paramView.putExtra("KEY_FINDER_SELF_FLAG", kotlin.g.b.p.j(str, z.aUg()));
      paramView.putExtra("key_enter_profile_tab", 2);
      localObject = FinderReporterUIC.wzC;
      localObject = paramh.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, parambm.dkW(), 1, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject = paramh.getContext();
      kotlin.g.b.p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248316);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$1"})
  static final class s
    implements Runnable
  {
    s(View.OnClickListener paramOnClickListener, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(248317);
      FinderVideoLayout localFinderVideoLayout = (FinderVideoLayout)this.tzq.Mn(2131300776);
      if (localFinderVideoLayout != null)
      {
        localFinderVideoLayout.setOnClickListener(this.uKy);
        AppMethodBeat.o(248317);
        return;
      }
      AppMethodBeat.o(248317);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class t
    implements View.OnClickListener
  {
    t(a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248318);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = a.uKl;
      a.a.a(this.qhp, this.uKq, (Activity)a.a(this.uKm).dcl(), null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$onClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248318);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class u
    implements View.OnLongClickListener
  {
    u(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(248319);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      bm localbm = (bm)this.qhp.hgv();
      paramView = (FinderVideoLayout)this.qhp.Mn(2131300776);
      if (paramView != null)
      {
        paramView = paramView.getPlayInfo();
        if (paramView == null) {}
      }
      for (paramView = paramView.uPf;; paramView = null)
      {
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        localObject1 = this.qhp.getContext();
        if (localObject1 != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(248319);
        throw paramView;
      }
      FinderDebugUIC localFinderDebugUIC = (FinderDebugUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject1).get(FinderDebugUIC.class);
      Context localContext = this.qhp.getContext();
      kotlin.g.b.p.g(localContext, "holder.context");
      kotlin.g.b.p.g(localbm, "item");
      com.tencent.mm.view.recyclerview.h localh = this.qhp;
      kotlin.g.b.p.h(localContext, "context");
      kotlin.g.b.p.h(localbm, "item");
      kotlin.g.b.p.h(localh, "holder");
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(localContext, 0, false);
      long l = localbm.lT();
      JSONObject localJSONObject = new JSONObject();
      localObject1 = localJSONObject.put("tag", "ClickMoreDebug").put("feedId", com.tencent.mm.ac.d.zs(l)).put("signedFeedId", l);
      Object localObject2 = localbm.tuP;
      int i;
      if (localObject2 != null)
      {
        i = ((cng)localObject2).iXu;
        localObject2 = ((JSONObject)localObject1).put("feedTime", Util.formatUnixTime(i * 1L));
        localObject1 = (cjl)kotlin.a.j.kt((List)localbm.dkV());
        if (localObject1 == null) {
          break label858;
        }
        localObject1 = Integer.valueOf(((cjl)localObject1).videoDuration);
        label311:
        localObject1 = ((JSONObject)localObject2).put("videoDuration", localObject1).put("isMegaVideo", true);
        if (paramView == null) {
          break label864;
        }
        paramView = paramView.uIx;
        label337:
        localObject2 = ((JSONObject)localObject1).put("file_format", paramView);
        paramView = localbm.contact;
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
        paramView = com.tencent.mm.plugin.finder.api.c.tsp;
        paramView = localbm.contact;
        if (paramView == null) {
          break label869;
        }
        paramView = paramView.username;
        label403:
        paramView = ((JSONObject)localObject1).put("isFollow", c.a.asJ(paramView));
        localObject1 = (cjl)kotlin.a.j.kt((List)localbm.dkV());
        if (localObject1 == null) {
          break label874;
        }
        i = ((cjl)localObject1).mediaType;
        label442:
        localObject2 = paramView.put("mediaType", i);
        paramView = (cjl)kotlin.a.j.kt((List)localbm.dkV());
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
        paramView = (cjl)kotlin.a.j.kt((List)localbm.dkV());
        if (paramView == null) {
          break label879;
        }
        paramView = kotlin.g.b.p.I(paramView.url, Util.nullAsNil(paramView.url_token));
        label535:
        localObject1 = ((JSONObject)localObject1).put("url", paramView);
        paramView = (cjl)kotlin.a.j.kt((List)localbm.dkV());
        if (paramView == null) {
          break label884;
        }
        paramView = kotlin.g.b.p.I(paramView.thumbUrl, Util.nullAsNil(paramView.thumb_url_token));
        label580:
        localObject1 = ((JSONObject)localObject1).put("thumbUrl", paramView);
        paramView = (cjl)kotlin.a.j.kt((List)localbm.dkV());
        if (paramView == null) {
          break label889;
        }
      }
      label858:
      label864:
      label869:
      label874:
      label879:
      label884:
      label889:
      for (paramView = kotlin.g.b.p.I(paramView.coverUrl, Util.nullAsNil(paramView.cover_url_token));; paramView = null)
      {
        localObject2 = ((JSONObject)localObject1).put("coverUrl", paramView).put("description", localbm.dkV());
        paramView = localbm.tuP;
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
        localObject1 = localbm.tuP;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = new cng();
        }
        paramView = n.buv(com.tencent.mm.ac.g.bN(paramView));
        Log.e(FinderDebugUIC.TAG, "long click more button! ".concat(String.valueOf(localJSONObject)));
        Log.e(FinderDebugUIC.TAG, "long click more button allInfo! ".concat(String.valueOf(paramView)));
        if (FinderDebugUIC.dHZ())
        {
          locale.a((o.f)new FinderDebugUIC.f(localFinderDebugUIC));
          locale.a((o.g)new FinderDebugUIC.g(localFinderDebugUIC, localContext, localJSONObject, l, localbm, paramView, localh));
          locale.dGm();
        }
        this.qhp.aus.requestLayout();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(248319);
        return true;
        i = 0;
        break;
        localObject1 = null;
        break label311;
        paramView = null;
        break label337;
        paramView = null;
        break label403;
        i = 0;
        break label442;
        paramView = null;
        break label535;
        paramView = null;
        break label580;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class v
    implements View.OnClickListener
  {
    v(a parama, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248321);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = (bm)this.qhp.hgv();
      localObject = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 0, false);
      f localf = a.a(this.uKm);
      kotlin.g.b.p.g(paramView, "item");
      kotlin.g.b.p.h(paramView, "feed");
      kotlin.g.b.p.h(localObject, "sheet");
      ((com.tencent.mm.ui.widget.a.e)localObject).a((o.f)new f.g(localf, paramView));
      localf = a.a(this.uKm);
      kotlin.g.b.p.h(paramView, "feed");
      ((com.tencent.mm.ui.widget.a.e)localObject).b((o.f)new f.h(localf, paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).a(a.a(this.uKm).a(paramView, this.qhp));
      ((com.tencent.mm.ui.widget.a.e)localObject).b(a.a(this.uKm).a(paramView, this.qhp));
      ((com.tencent.mm.ui.widget.a.e)localObject).b((e.b)new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(248320);
          Object localObject = FinderReporterUIC.wzC;
          localObject = this.uKz.qhp.getContext();
          kotlin.g.b.p.g(localObject, "holder.context");
          localObject = FinderReporterUIC.a.fH((Context)localObject);
          if (localObject != null) {}
          for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
          {
            bm localbm = (bm)this.uKz.qhp.hgv();
            com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.vfA;
            kotlin.g.b.p.g(localbm, "feed");
            com.tencent.mm.plugin.finder.report.k.a(localbm, 2, 3L, "", (bbn)localObject);
            AppMethodBeat.o(248320);
            return;
          }
        }
      });
      ((com.tencent.mm.ui.widget.a.e)localObject).dGm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248321);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class w
    implements View.OnClickListener
  {
    w(a parama, com.tencent.mm.view.recyclerview.h paramh, bm parambm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(248322);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = (FinderVideoLayout)this.qhp.Mn(2131300776);
      if (paramView != null) {}
      for (int i = paramView.getCurrentPosSec();; i = 0)
      {
        f.a(a.a(this.uKm), this.uKq, this.qhp, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(248322);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
  public static final class x
    implements CommentDrawerContract.CloseDrawerCallback
  {
    x(com.tencent.mm.view.recyclerview.h paramh, bm parambm) {}
    
    public final void g(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.s> paramList)
    {
      AppMethodBeat.i(248323);
      kotlin.g.b.p.h(paramList, "data");
      a.a(this.uKm, this.qhp, this.uKq.getFeedObject().commentCount);
      paramList = new hv();
      paramList.dMr.feedId = this.uKq.getFeedObject().id;
      paramList.dMr.dMt = this.uKq.getFeedObject().commentCount;
      EventCenter.instance.publish((IEvent)paramList);
      a.a(this.uKm).dcl().setRequestedOrientation(-1);
      AppMethodBeat.o(248323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.a
 * JD-Core Version:    0.7.0.1
 */