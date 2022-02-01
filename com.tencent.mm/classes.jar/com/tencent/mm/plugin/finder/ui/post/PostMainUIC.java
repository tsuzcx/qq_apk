package com.tencent.mm.plugin.finder.ui.post;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.activity.a.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.finder.view.FinderChooseNewsView;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.c;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.d;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.a.j;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/post/PostMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "FLUTTER_TAG", "", "TAG", "actionBarHeight", "", "activityPostView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "activityWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "addMediaBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAddMediaBtn", "()Landroid/view/View;", "addMediaBtn$delegate", "Lkotlin/Lazy;", "avatarIv", "Landroid/widget/ImageView;", "backBtn", "getBackBtn", "backBtn$delegate", "bottomSpace", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "delMediaBtn", "getDelMediaBtn", "delMediaBtn$delegate", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendReadingWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "hasStartKeyBoardProvider", "", "header", "getHeader", "header$delegate", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "longVideoLinkView", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "newsWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderSetNewsFeedWidget;", "nickTv", "Landroid/widget/TextView;", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "setPostDataManager", "(Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "reportFlag", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "sendBtn", "getSendBtn", "sendBtn$delegate", "checkNeedScroll", "", "checkNextEnable", "checkPostData", "delMediaInternal", "enterFinderMediaPreviewAtTimelineUI", "exitAndSave", "getLayoutId", "initDelMediaBtn", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onUserVisibleFocused", "postEditUIC", "Lcom/tencent/mm/plugin/finder/ui/post/PostEditUIC;", "postLocationUIC", "Lcom/tencent/mm/plugin/finder/ui/post/PostLocationUIC;", "reportMediaDelOp", "action", "restore", "routeBack", "routeForward", "localId", "", "save", "selectMedia", "setWindowStyle", "showDelBottomSheet", "Companion", "plugin-finder_release"})
public final class PostMainUIC
  extends UIComponent
  implements com.tencent.mm.ui.tools.g
{
  public static final a vRu;
  private final String TAG;
  private com.tencent.mm.plugin.finder.api.g contact;
  private com.tencent.mm.ui.base.q gut;
  public ScrollView gxx;
  private com.tencent.mm.ui.tools.h gyh;
  private ImageView gyr;
  private TextView kib;
  private final kotlin.f uZN;
  private int udM;
  private View vMo;
  private String vOl;
  private final String vRb;
  private ViewGroup vRc;
  private View vRd;
  private boolean vRe;
  private com.tencent.mm.plugin.finder.widget.post.a vRf;
  private com.tencent.mm.plugin.finder.upload.postui.b vRg;
  private com.tencent.mm.plugin.finder.upload.postui.d vRh;
  private com.tencent.mm.plugin.finder.upload.postui.e vRi;
  private View vRj;
  private com.tencent.mm.plugin.finder.upload.postui.a vRk;
  private FinderExtendActivityView vRl;
  private final kotlin.f vRm;
  private final kotlin.f vRn;
  private final kotlin.f vRo;
  private final kotlin.f vRp;
  public com.tencent.mm.plugin.finder.widget.post.c vRq;
  private int vRr;
  private boolean vRs;
  private final View.OnLayoutChangeListener vRt;
  
  static
  {
    AppMethodBeat.i(253001);
    vRu = new a((byte)0);
    AppMethodBeat.o(253001);
  }
  
  public PostMainUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253000);
    this.TAG = "Finder.FinderPostUI";
    this.vRb = "Finder.FinderRecordPluginLayout.FlutterVideoEditor_DataReport";
    this.vOl = "";
    this.vRm = kotlin.g.ah((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.vRn = kotlin.g.ah((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.uZN = kotlin.g.ah((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.vRo = kotlin.g.ah((kotlin.g.a.a)new t(paramAppCompatActivity));
    this.vRp = kotlin.g.ah((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.vRt = ((View.OnLayoutChangeListener)new g(this));
    AppMethodBeat.o(253000);
  }
  
  private final View dAF()
  {
    AppMethodBeat.i(252984);
    View localView = (View)this.vRm.getValue();
    AppMethodBeat.o(252984);
    return localView;
  }
  
  private final View dAG()
  {
    AppMethodBeat.i(252985);
    View localView = (View)this.vRn.getValue();
    AppMethodBeat.o(252985);
    return localView;
  }
  
  private final View dAH()
  {
    AppMethodBeat.i(252986);
    View localView = (View)this.vRo.getValue();
    AppMethodBeat.o(252986);
    return localView;
  }
  
  private final void dAI()
  {
    AppMethodBeat.i(252992);
    View localView = dAF();
    kotlin.g.b.p.g(localView, "delMediaBtn");
    ViewGroup localViewGroup = this.vRc;
    if (localViewGroup == null) {
      kotlin.g.b.p.btv("mediaViewContainer");
    }
    if (localViewGroup.getChildCount() != 0) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      dAF().setOnClickListener((View.OnClickListener)new k(this));
      dAG().setOnClickListener((View.OnClickListener)new l(this));
      AppMethodBeat.o(252992);
      return;
    }
  }
  
  private final PostLocationUIC dAK()
  {
    AppMethodBeat.i(252994);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = com.tencent.mm.ui.component.a.b(getActivity()).get(PostLocationUIC.class);
    kotlin.g.b.p.g(localObject, "UICProvider.of(activity)…tLocationUIC::class.java)");
    localObject = (PostLocationUIC)localObject;
    AppMethodBeat.o(252994);
    return localObject;
  }
  
  private final PostEditUIC dAL()
  {
    AppMethodBeat.i(252996);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = com.tencent.mm.ui.component.a.b(getActivity()).get(PostEditUIC.class);
    kotlin.g.b.p.g(localObject, "UICProvider.of(activity)…(PostEditUIC::class.java)");
    localObject = (PostEditUIC)localObject;
    AppMethodBeat.o(252996);
    return localObject;
  }
  
  private final void dAM()
  {
    AppMethodBeat.i(252997);
    Object localObject1 = this.vRf;
    label74:
    label125:
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).dJh();
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
        if (localObject1 != null)
        {
          localObject3 = ((cjk)localObject1).vMX;
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
          if (localObject1 == null) {
            break label284;
          }
          localObject1 = ((cjk)localObject1).MoJ;
          if (localObject1 == null) {
            break label284;
          }
          localObject1 = ((azk)localObject1).wWb;
        }
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        com.tencent.mm.plugin.finder.report.i.auF((String)localObject3);
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
        if ((localObject1 == null) || (((cjk)localObject1).wCu) || (((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD.wCv)) {
          break label289;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Kp(3);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
      if (localObject2 == null) {
        break label354;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
      if (localObject1 == null) {
        break label354;
      }
      i = ((cjk)localObject1).soundTrackType;
      label147:
      com.tencent.mm.plugin.finder.report.i.Ko(i);
      localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.c(dAL().dAA().dHI().vTC, dAL().dAA().dHI().wsI, dAL().dAA().dHI().wsJ);
      localObject1 = this.vRq;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).wCl;
      if (localObject1 != null) {
        break label359;
      }
    }
    for (;;)
    {
      label221:
      localObject1 = this.vRq;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).vTz == null)
      {
        localObject1 = this.vRq;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).wCr == null) {
          break label389;
        }
      }
      label284:
      label289:
      label354:
      label359:
      do
      {
        getActivity().finish();
        AppMethodBeat.o(252997);
        return;
        localObject2 = null;
        break;
        localObject1 = null;
        break label74;
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
        if ((localObject1 != null) && (!((cjk)localObject1).wCu))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.Kp(2);
          break label125;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
        if ((localObject1 != null) && (!((cjk)localObject1).wCv))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.Kp(1);
          break label125;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Kp(0);
        break label125;
        i = 0;
        break label147;
        if (((Integer)localObject1).intValue() != 1) {
          break label221;
        }
      } while (Util.isNullOrNil(dAL().dAx().getText().toString()));
    }
    label389:
    localObject1 = getString(2131760662);
    Object localObject2 = this.vRq;
    if (localObject2 == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    if (((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCw > 0L) {
      localObject1 = getString(2131760663);
    }
    com.tencent.mm.ui.base.h.a((Context)getActivity(), (String)localObject1, "", getString(2131760665), getString(2131760664), true, (DialogInterface.OnClickListener)new h(this), (DialogInterface.OnClickListener)new i(this), 2131099921);
    AppMethodBeat.o(252997);
  }
  
  public final com.tencent.mm.plugin.finder.widget.post.c dAD()
  {
    AppMethodBeat.i(252987);
    com.tencent.mm.plugin.finder.widget.post.c localc = this.vRq;
    if (localc == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    AppMethodBeat.o(252987);
    return localc;
  }
  
  public final ScrollView dAE()
  {
    AppMethodBeat.i(252983);
    ScrollView localScrollView = this.gxx;
    if (localScrollView == null) {
      kotlin.g.b.p.btv("scrollView");
    }
    AppMethodBeat.o(252983);
    return localScrollView;
  }
  
  public final void dAJ()
  {
    AppMethodBeat.i(252993);
    if (getActivity() == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(252993);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vRg;
    if (localObject == null) {
      kotlin.g.b.p.btv("extendReadingWidget");
    }
    if ((!((com.tencent.mm.plugin.finder.upload.postui.b)localObject).vUH.dHB()) || (!dAL().vQT))
    {
      localObject = dAH();
      kotlin.g.b.p.g(localObject, "sendBtn");
      ((View)localObject).setEnabled(false);
      AppMethodBeat.o(252993);
      return;
    }
    if (this.vRf != null)
    {
      localObject = dAH();
      kotlin.g.b.p.g(localObject, "sendBtn");
      ((View)localObject).setEnabled(true);
      AppMethodBeat.o(252993);
      return;
    }
    localObject = dAH();
    kotlin.g.b.p.g(localObject, "sendBtn");
    ((View)localObject).setEnabled(false);
    AppMethodBeat.o(252993);
  }
  
  public final void dAN()
  {
    AppMethodBeat.i(252999);
    Object localObject1 = this.vRf;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).dJh();
      if (localObject2 == null) {
        break label503;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
      if (localObject1 != null)
      {
        localObject3 = ((cjk)localObject1).vMX;
        localObject1 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
        if (localObject1 == null) {
          break label277;
        }
        localObject1 = ((cjk)localObject1).MoJ;
        if (localObject1 == null) {
          break label277;
        }
        localObject1 = ((azk)localObject1).wWb;
      }
      label74:
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "";
      }
      com.tencent.mm.plugin.finder.report.i.auF((String)localObject3);
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
      if ((localObject1 == null) || (((cjk)localObject1).wCu) || (((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD.wCv)) {
        break label282;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Kp(3);
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
      if (localObject1 != null)
      {
        localObject1 = ((cjk)localObject1).mediaList;
        if (localObject1 != null)
        {
          localObject1 = (cjl)j.L((List)localObject1, 0);
          if (localObject1 != null) {
            ((cjl)localObject1).mediaId = UUID.randomUUID().toString();
          }
        }
      }
      localObject1 = this.vRq;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).vUI;
      localObject3 = this.vRi;
      if (localObject3 == null) {
        kotlin.g.b.p.btv("newsWidget");
      }
      ((Bundle)localObject1).putBoolean("isNews", ((com.tencent.mm.plugin.finder.upload.postui.e)localObject3).isChecked());
      localObject1 = this.vRq;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      localObject3 = dAL().dAx().getText().toString();
      if (localObject3 != null) {
        break label347;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(252999);
      throw ((Throwable)localObject1);
      localObject2 = null;
      break;
      label277:
      localObject1 = null;
      break label74;
      label282:
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
      if ((localObject1 != null) && (!((cjk)localObject1).wCu))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Kp(2);
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject2).wDD;
        if ((localObject1 != null) && (!((cjk)localObject1).wCv))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.Kp(1);
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.Kp(0);
        }
      }
    }
    label347:
    localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).a(n.aM((CharSequence)localObject3).toString(), (com.tencent.mm.plugin.finder.widget.post.g)localObject2, dAL().dAA().dHI().dHz());
    ((FinderItem)localObject1).setPreview(true);
    Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject1);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("KEY_FROM_SCENE", 1);
    ((Intent)localObject1).putExtra("KEY_USERNAME", z.aUg());
    ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", true);
    Object localObject3 = OccupyFinderUI10.udX;
    ((Intent)localObject1).putExtra(OccupyFinderUI10.dez(), true);
    localObject3 = OccupyFinderUI10.udX;
    localObject3 = OccupyFinderUI10.deA();
    y localy = y.vXH;
    if (!y.isDisablePostHalfScreen()) {}
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject1).putExtra((String)localObject3, bool);
      localObject3 = y.vXH;
      y.a(0, j.listOf(localObject2), null, (Intent)localObject1);
      localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.ac((Context)getContext(), (Intent)localObject1);
      label503:
      AppMethodBeat.o(252999);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494578;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    PostEditUIC localPostEditUIC = null;
    int j = 1;
    int k = 1;
    int i = 0;
    AppMethodBeat.i(252998);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 20000)
    {
      localObject1 = dAK();
      if (paramIntent != null)
      {
        localObject2 = ((PostLocationUIC)localObject1).uHb;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("locationWidget");
        }
        ((com.tencent.mm.plugin.finder.upload.postui.c)localObject2).ar(paramIntent);
        paramIntent = ((PostLocationUIC)localObject1).uHb;
        if (paramIntent == null) {
          kotlin.g.b.p.btv("locationWidget");
        }
        paramIntent.dBu();
        paramIntent = ((PostLocationUIC)localObject1).uHb;
        if (paramIntent == null) {
          kotlin.g.b.p.btv("locationWidget");
        }
        paramIntent = paramIntent.vUM;
        if (paramIntent != null)
        {
          if ((!Util.isNullOrNil(paramIntent.kHV)) || (!Util.isNullOrNil(paramIntent.fuK)))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.a(2, paramIntent);
            AppMethodBeat.o(252998);
            return;
          }
          localObject1 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.a(3, paramIntent);
          AppMethodBeat.o(252998);
          return;
        }
        AppMethodBeat.o(252998);
        return;
      }
      AppMethodBeat.o(252998);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.finder.widget.post.f.wDt;
    label234:
    Object localObject3;
    if (paramInt1 == com.tencent.mm.plugin.finder.widget.post.f.dJq())
    {
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.widget.post.f.wDt;
        localObject1 = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.f.dJr());
        if (paramIntent == null) {
          break label477;
        }
        localObject2 = com.tencent.mm.plugin.finder.widget.post.f.wDt;
        localObject2 = Integer.valueOf(paramIntent.getIntExtra(com.tencent.mm.plugin.finder.widget.post.f.dJs(), 0));
        if (paramIntent != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.widget.post.f.wDt;
          localObject3 = (LocalVideoCropInfoParcelable)paramIntent.getParcelableExtra(com.tencent.mm.plugin.finder.widget.post.f.dJt());
          paramIntent = (Intent)localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          paramIntent = new LocalVideoCropInfoParcelable();
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label1858;
        }
        localObject3 = this.vRq;
        if (localObject3 == null) {
          kotlin.g.b.p.btv("postDataManager");
        }
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        if (localObject2 == null) {
          break label483;
        }
        paramInt1 = ((Integer)localObject2).intValue();
        label315:
        kotlin.g.b.p.h(localObject1, "coverUrl");
        kotlin.g.b.p.h(paramIntent, "cropInfo");
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).vUI.putString("VIDEO_COVER_URL", (String)localObject1);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.putExtra("VIDEO_COVER_URL", (String)localObject1);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).vUI.putInt("VIDEO_COVER_QUALITY", paramInt1);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.putExtra("VIDEO_COVER_QUALITY", paramInt1);
        localObject2 = paramIntent.uOR;
        if (localObject2 == null) {
          break label565;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).wCo;
        if (localObject1 == null) {
          break label565;
        }
        if ((((ArrayList)localObject1).size() <= 0) || (!(((ArrayList)localObject1).get(0) instanceof LocalVideoCropInfoParcelable))) {
          break label488;
        }
      }
      label477:
      label483:
      label488:
      for (paramInt1 = k;; paramInt1 = 0)
      {
        paramIntent = localPostEditUIC;
        if (paramInt1 != 0) {
          paramIntent = (Intent)localObject1;
        }
        if (paramIntent == null) {
          break label565;
        }
        paramIntent = paramIntent.get(0);
        if (paramIntent != null) {
          break label493;
        }
        paramIntent = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable");
        AppMethodBeat.o(252998);
        throw paramIntent;
        localObject1 = null;
        break;
        localObject2 = null;
        break label234;
        paramInt1 = 0;
        break label315;
      }
      label493:
      paramIntent = ((LocalVideoCropInfoParcelable)paramIntent).uOR;
      if (paramIntent != null)
      {
        paramIntent.Mpq = ((cjx)localObject2).Mpq;
        paramIntent.Mps = ((cjx)localObject2).Mps;
        paramIntent.Mpr = ((cjx)localObject2).Mpr;
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.putParcelableArrayListExtra("postVideoCropList", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).wCo);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).vUI.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).wCo);
      }
      label565:
      paramIntent = this.vRf;
      if (paramIntent != null)
      {
        localObject1 = this.vRq;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("postDataManager");
        }
        paramIntent.ak(((com.tencent.mm.plugin.finder.widget.post.c)localObject1).vUI);
        paramIntent.refresh();
        AppMethodBeat.o(252998);
        return;
      }
      AppMethodBeat.o(252998);
    }
    else if (paramInt1 == 20002)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          localObject1 = this.vRk;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("activityWidget");
          }
          ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).aq(paramIntent);
          AppMethodBeat.o(252998);
          return;
        }
        AppMethodBeat.o(252998);
      }
    }
    else if (paramInt1 == 20003)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          localObject1 = this.vRk;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("activityWidget");
          }
          ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).aq(paramIntent);
          AppMethodBeat.o(252998);
          return;
        }
        AppMethodBeat.o(252998);
      }
    }
    else if (paramInt1 == 20001)
    {
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(252998);
        throw paramIntent;
      }
      ((MMActivity)localObject2).showVKB();
      localPostEditUIC = dAL();
      if (paramIntent != null)
      {
        k = paramIntent.getIntExtra("key_scene", 1);
        if (paramInt2 == -1)
        {
          paramInt1 = paramIntent.getIntExtra("key_source", 2);
          localObject2 = paramIntent.getByteArrayExtra("key_select_contact");
          paramIntent = (Intent)localObject1;
          if (localObject2 != null) {}
          try
          {
            paramIntent = new cjj();
            paramIntent.parseFrom((byte[])localObject2);
            if (paramIntent != null) {
              if (!Util.isNullOrNil(paramIntent.nickname))
              {
                localObject1 = localPostEditUIC.vQV;
                if (localObject1 == null) {
                  kotlin.g.b.p.btv("styleManager");
                }
                localObject3 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).dHI();
                localObject2 = paramIntent.nickname;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                ((com.tencent.mm.plugin.finder.view.manager.b)localObject3).be(paramInt1, (String)localObject1);
                localObject1 = localPostEditUIC.vQV;
                if (localObject1 == null) {
                  kotlin.g.b.p.btv("styleManager");
                }
                localObject3 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).dHI().wsG;
                localObject2 = paramIntent.nickname;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                ((HashMap)localObject3).put(localObject1, paramIntent);
                localObject1 = localPostEditUIC.vQR;
                if (localObject1 == null) {
                  kotlin.g.b.p.btv("descTv");
                }
                paramInt2 = ((FinderPostEditText)localObject1).getSelectionEnd();
                localObject1 = localPostEditUIC.vQR;
                if (localObject1 == null) {
                  kotlin.g.b.p.btv("descTv");
                }
                localObject2 = ((FinderPostEditText)localObject1).getText().toString();
                paramInt1 = paramInt2;
                localObject1 = localObject2;
                if (k == 2)
                {
                  localObject1 = localPostEditUIC.vQR;
                  if (localObject1 == null) {
                    kotlin.g.b.p.btv("descTv");
                  }
                  k = ((FinderPostEditText)localObject1).getSelectionEnd();
                  paramInt1 = paramInt2;
                  localObject1 = localObject2;
                  if (k > 0)
                  {
                    paramInt2 = k - 1;
                    paramInt1 = j;
                    for (;;)
                    {
                      if ((paramInt2 < 0) || (paramInt1 == 0)) {
                        break label1151;
                      }
                      localObject1 = localPostEditUIC.vQR;
                      if (localObject1 == null) {
                        kotlin.g.b.p.btv("descTv");
                      }
                      if (((FinderPostEditText)localObject1).getText().toString().charAt(paramInt2) != '@') {
                        break;
                      }
                      paramInt2 -= 1;
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              Log.e(localPostEditUIC.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { paramIntent.getMessage() });
              paramIntent = (Intent)localObject1;
              continue;
              paramInt1 = 0;
            }
            label1151:
            paramInt2 += 1;
            paramInt1 = paramInt2;
            if (paramInt2 > ((String)localObject2).length()) {
              paramInt1 = ((String)localObject2).length();
            }
            localObject1 = new StringBuilder();
            if (localObject2 == null)
            {
              paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(252998);
              throw paramIntent;
            }
            localObject3 = ((String)localObject2).substring(0, paramInt1);
            kotlin.g.b.p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
            paramInt2 = ((String)localObject2).length();
            if (localObject2 == null)
            {
              paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(252998);
              throw paramIntent;
            }
            localObject2 = ((String)localObject2).substring(k, paramInt2);
            kotlin.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject1 = (String)localObject2;
            paramInt2 = paramInt1;
            if (paramInt1 > ((String)localObject1).length()) {
              paramInt2 = ((String)localObject1).length();
            }
            localObject2 = new StringBuilder();
            if (localObject1 == null)
            {
              paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(252998);
              throw paramIntent;
            }
            localObject3 = ((String)localObject1).substring(0, paramInt2);
            kotlin.g.b.p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append('@').append(paramIntent.nickname).append(' ');
            paramInt1 = ((String)localObject1).length();
            if (localObject1 == null)
            {
              paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(252998);
              throw paramIntent;
            }
            localObject1 = ((String)localObject1).substring(paramInt2, paramInt1);
            kotlin.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject1 = (String)localObject1;
            paramIntent = paramIntent.nickname;
            paramInt1 = i;
            if (paramIntent != null) {
              paramInt1 = paramIntent.length();
            }
            paramIntent = localPostEditUIC.vQR;
            if (paramIntent == null) {
              kotlin.g.b.p.btv("descTv");
            }
            paramIntent.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localPostEditUIC.getContext(), (CharSequence)localObject1));
            paramIntent = localPostEditUIC.vQR;
            if (paramIntent == null) {
              kotlin.g.b.p.btv("descTv");
            }
            paramIntent.setSelection(paramInt2 + paramInt1 + 2);
            AppMethodBeat.o(252998);
            return;
          }
          AppMethodBeat.o(252998);
          return;
        }
        paramIntent = localPostEditUIC.vQV;
        if (paramIntent == null) {
          kotlin.g.b.p.btv("styleManager");
        }
        com.tencent.mm.plugin.finder.view.manager.b.a(paramIntent.dHI());
        if (k == 2)
        {
          paramIntent = localPostEditUIC.vQR;
          if (paramIntent == null) {
            kotlin.g.b.p.btv("descTv");
          }
          paramIntent = paramIntent.getText().toString();
          localObject1 = localPostEditUIC.vQR;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("descTv");
          }
          i = ((FinderPostEditText)localObject1).getSelectionEnd();
          if (i > 0)
          {
            paramInt1 = i - 1;
            paramInt2 = 1;
            while ((paramInt1 >= 0) && (paramInt2 != 0))
            {
              localObject1 = localPostEditUIC.vQR;
              if (localObject1 == null) {
                kotlin.g.b.p.btv("descTv");
              }
              if (((FinderPostEditText)localObject1).getText().toString().charAt(paramInt1) == '@') {
                paramInt1 -= 1;
              } else {
                paramInt2 = 0;
              }
            }
            paramInt1 += 1;
            if (paramInt1 <= paramIntent.length()) {
              break label1865;
            }
            paramInt1 = paramIntent.length();
          }
        }
      }
    }
    label1858:
    label1865:
    for (;;)
    {
      localObject1 = new StringBuilder();
      if (paramIntent == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(252998);
        throw paramIntent;
      }
      localObject2 = paramIntent.substring(0, paramInt1);
      kotlin.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      paramInt2 = paramIntent.length();
      if (paramIntent == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(252998);
        throw paramIntent;
      }
      paramIntent = paramIntent.substring(i, paramInt2);
      kotlin.g.b.p.g(paramIntent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramIntent = paramIntent;
      localObject1 = localPostEditUIC.vQR;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("descTv");
      }
      ((FinderPostEditText)localObject1).setText((CharSequence)paramIntent);
      paramIntent = localPostEditUIC.vQR;
      if (paramIntent == null) {
        kotlin.g.b.p.btv("descTv");
      }
      paramIntent.setSelection(paramInt1);
      AppMethodBeat.o(252998);
      return;
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(252991);
    com.tencent.mm.plugin.finder.upload.postui.b localb = this.vRg;
    if (localb == null) {
      kotlin.g.b.p.btv("extendReadingWidget");
    }
    if (localb.vUH.wsQ) {
      localb.vUH.dHA();
    }
    for (int i = 1; i == 0; i = 0)
    {
      dAM();
      AppMethodBeat.o(252991);
      return true;
    }
    AppMethodBeat.o(252991);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252988);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity))
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(252988);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).setSelfNavigationBarVisible(8);
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(252988);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).getController().updataStatusBarIcon(ao.isDarkMode());
    }
    getContext().getWindow().addFlags(2097280);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getContext().getWindow();
      kotlin.g.b.p.g(paramBundle, "context.window");
      paramBundle = paramBundle.getDecorView();
      kotlin.g.b.p.g(paramBundle, "context.window.decorView");
      localObject1 = getContext().getWindow();
      kotlin.g.b.p.g(localObject1, "context.window");
      localObject1 = ((Window)localObject1).getDecorView();
      kotlin.g.b.p.g(localObject1, "context.window.decorView");
      paramBundle.setSystemUiVisibility(((View)localObject1).getSystemUiVisibility() | 0x400 | 0x100);
    }
    this.vRq = new com.tencent.mm.plugin.finder.widget.post.c(getIntent());
    paramBundle = z.aUg();
    kotlin.g.b.p.g(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    this.vOl = paramBundle;
    if (!Util.isNullOrNil(this.vOl))
    {
      paramBundle = com.tencent.mm.plugin.finder.api.c.tsp;
      this.contact = com.tencent.mm.plugin.finder.api.c.a.asG(this.vOl);
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(252988);
      throw paramBundle;
    }
    Object localObject2 = (MMActivity)paramBundle;
    ((MMActivity)localObject2).setMMTitle("");
    ((MMActivity)localObject2).setActionbarColor(getResources().getColor(2131099672));
    paramBundle = ((MMActivity)localObject2).findViewById(2131306073);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.…t_media_widget_container)");
    this.vRc = ((ViewGroup)paramBundle);
    paramBundle = ((MMActivity)localObject2).findViewById(2131306056);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.post_avatar)");
    this.gyr = ((ImageView)paramBundle);
    paramBundle = ((MMActivity)localObject2).findViewById(2131306075);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.post_nickname)");
    this.kib = ((TextView)paramBundle);
    paramBundle = ((MMActivity)localObject2).findViewById(2131307339);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.scroll_view)");
    this.gxx = ((ScrollView)paramBundle);
    paramBundle = ((MMActivity)localObject2).findViewById(2131297702);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.bottom_space)");
    this.vRd = paramBundle;
    paramBundle = ((MMActivity)localObject2).findViewById(2131299913);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.edt_container)");
    this.vMo = paramBundle;
    paramBundle = ((MMActivity)localObject2).findViewById(2131298660);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.choose_original_view)");
    this.vRh = new com.tencent.mm.plugin.finder.upload.postui.d((MMActivity)localObject2, (FinderChooseOriginalView)paramBundle);
    paramBundle = ((MMActivity)localObject2).findViewById(2131298658);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.choose_news_view)");
    this.vRi = new com.tencent.mm.plugin.finder.upload.postui.e((MMActivity)localObject2, (FinderChooseNewsView)paramBundle);
    paramBundle = ((MMActivity)localObject2).findViewById(2131298653);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.choose_activity_view)");
    this.vRl = ((FinderExtendActivityView)paramBundle);
    paramBundle = this.vRl;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("activityPostView");
    }
    this.vRk = new com.tencent.mm.plugin.finder.upload.postui.a(paramBundle);
    if (localObject2 == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(252988);
      throw paramBundle;
    }
    this.gyh = new com.tencent.mm.ui.tools.h((Activity)localObject2);
    paramBundle = this.gyh;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("keyboardHeightProvider");
    }
    paramBundle.setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)this);
    paramBundle = (View)this.vRp.getValue();
    kotlin.g.b.p.g(paramBundle, "header");
    Object localObject1 = paramBundle.getLayoutParams();
    paramBundle = (Bundle)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramBundle = null;
    }
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    if (paramBundle != null)
    {
      i = paramBundle.topMargin;
      paramBundle.topMargin = (au.getStatusBarHeight((Context)localObject2) + i);
    }
    paramBundle = this.contact;
    if (paramBundle != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.dka();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(paramBundle.field_avatarUrl);
      localObject4 = this.gyr;
      if (localObject4 == null) {
        kotlin.g.b.p.btv("avatarIv");
      }
      localObject5 = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject1).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      localObject1 = this.kib;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)paramBundle.getNickname()));
      localObject1 = this.vRl;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("activityPostView");
      }
      ((FinderExtendActivityView)localObject1).setContact(paramBundle);
    }
    for (;;)
    {
      ((View)this.uZN.getValue()).setOnClickListener((View.OnClickListener)new m(this));
      paramBundle = dAH();
      kotlin.g.b.p.g(paramBundle, "sendBtn");
      paramBundle.setEnabled(false);
      dAH().setOnClickListener((View.OnClickListener)new n(this, (MMActivity)localObject2));
      paramBundle = dAL();
      localObject1 = paramBundle.getActivity().findViewById(2131306060);
      kotlin.g.b.p.g(localObject1, "activity.findViewById(R.id.post_desc_edt)");
      paramBundle.vQR = ((FinderPostEditText)localObject1);
      localObject1 = paramBundle.vQR;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("descTv");
      }
      localObject3 = paramBundle.getActivity();
      if (localObject3 != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(252988);
      throw paramBundle;
      paramBundle = (PostMainUIC)this;
      localObject1 = paramBundle.gyr;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("avatarIv");
      }
      ((ImageView)localObject1).setVisibility(8);
      paramBundle = paramBundle.kib;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("nickTv");
      }
      paramBundle.setVisibility(8);
    }
    paramBundle.vQV = new com.tencent.mm.plugin.finder.view.manager.d((FinderPostEditText)localObject1, (MMActivity)localObject3);
    localObject1 = paramBundle.getActivity().findViewById(2131301664);
    kotlin.g.b.p.g(localObject1, "activity.findViewById(R.id.footer_container)");
    paramBundle.uGQ = ((View)localObject1);
    localObject1 = paramBundle.uGQ;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("footerContainer");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = paramBundle.getActivity().findViewById(2131300795);
    kotlin.g.b.p.g(localObject1, "activity.findViewById(R.id.finder_comment_footer)");
    paramBundle.vQS = ((FinderPostFooter)localObject1);
    Object localObject4 = paramBundle.getActivity().findViewById(2131306055);
    localObject1 = paramBundle.getActivity().findViewById(2131306078);
    Object localObject3 = paramBundle.vQS;
    if (localObject3 == null) {
      kotlin.g.b.p.btv("footer");
    }
    Object localObject5 = paramBundle.getActivity();
    if (localObject5 == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(252988);
      throw paramBundle;
    }
    localObject5 = (MMActivity)localObject5;
    Object localObject6 = paramBundle.uGQ;
    if (localObject6 == null) {
      kotlin.g.b.p.btv("footerContainer");
    }
    Object localObject7 = paramBundle.vQR;
    if (localObject7 == null) {
      kotlin.g.b.p.btv("descTv");
    }
    localObject7 = (MMEditText)localObject7;
    FinderPostFooter.b localb = (FinderPostFooter.b)paramBundle;
    kotlin.g.b.p.g(localObject4, "atBtn");
    kotlin.g.b.p.g(localObject1, "topicBtn");
    kotlin.g.b.p.h(localObject5, "activity");
    kotlin.g.b.p.h(localObject6, "container");
    kotlin.g.b.p.h(localObject7, "editText");
    kotlin.g.b.p.h(localb, "iTopicCallback");
    kotlin.g.b.p.h(localObject4, "atBtn");
    kotlin.g.b.p.h(localObject1, "topicBtn");
    ((FinderPostFooter)localObject3).activity = ((MMActivity)localObject5);
    ((FinderPostFooter)localObject3).jxm = ((View)localObject6);
    ((FinderPostFooter)localObject3).wkS = ((MMEditText)localObject7);
    ((FinderPostFooter)localObject3).woq = 20001;
    ((FinderPostFooter)localObject3).wor = ((FinderPostFooter)localObject3).wor;
    ((FinderPostFooter)localObject3).wos = localb;
    ((FinderPostFooter)localObject3).wop = ((View)localObject4);
    ((FinderPostFooter)localObject3).woo = ((View)localObject1);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new FinderPostFooter.c(localb));
    ((View)localObject4).setOnClickListener((View.OnClickListener)new FinderPostFooter.d((MMActivity)localObject5));
    localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.drN()) {
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      ((FinderPostFooter)localObject3).setOnClickListener((View.OnClickListener)FinderPostFooter.e.wow);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drN())
      {
        localObject1 = paramBundle.vQS;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("footer");
        }
        ((FinderPostFooter)localObject1).oX(false);
      }
      localObject1 = paramBundle.vQS;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("footer");
      }
      localObject3 = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((FinderPostFooter)localObject1).oY(com.tencent.mm.plugin.finder.storage.c.drO());
      localObject1 = paramBundle.getActivity().findViewById(2131309020);
      kotlin.g.b.p.g(localObject1, "activity.findViewById(R.id.textcount_hint)");
      paramBundle.uGS = ((TextView)localObject1);
      localObject1 = paramBundle.uGS;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("textCountTv");
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = paramBundle.uGS;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("textCountTv");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject1 = (TextWatcher)new PostEditUIC.c(paramBundle, ((Number)com.tencent.mm.plugin.finder.storage.c.dsA().value()).intValue());
      localObject3 = paramBundle.vQR;
      if (localObject3 == null) {
        kotlin.g.b.p.btv("descTv");
      }
      ((FinderPostEditText)localObject3).addTextChangedListener((TextWatcher)localObject1);
      if (((com.tencent.mm.plugin.finder.widget.post.c)paramBundle.vQW.getValue()).isLongVideo)
      {
        localObject1 = paramBundle.vQR;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("descTv");
        }
        ((FinderPostEditText)localObject1).setFilters((InputFilter[])new PostEditUIC.a[] { new PostEditUIC.a() });
      }
      localObject1 = paramBundle.vQR;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("descTv");
      }
      ((FinderPostEditText)localObject1).setOnTouchListener((View.OnTouchListener)new PostEditUIC.b(paramBundle));
      paramBundle = dAK();
      localObject1 = paramBundle.getActivity();
      if (localObject1 != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(252988);
      throw paramBundle;
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = (MMActivity)localObject1;
    localObject3 = paramBundle.getActivity().findViewById(2131306070);
    kotlin.g.b.p.g(localObject3, "activity.findViewById<Lo…(R.id.post_location_view)");
    paramBundle.uHb = new com.tencent.mm.plugin.finder.upload.postui.c((MMActivity)localObject1, (com.tencent.mm.pluginsdk.location.b)localObject3, paramBundle.getActivity().findViewById(2131306020), (TextView)paramBundle.getActivity().findViewById(2131306021), 20000);
    if (paramBundle.TW())
    {
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).cxh();
    }
    paramBundle = ((MMActivity)localObject2).findViewById(2131300267);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.id.extend_reading_view)");
    this.vRg = new com.tencent.mm.plugin.finder.upload.postui.b((MMActivity)localObject2, (FinderExtendReadingView)paramBundle, (kotlin.g.a.b)new o(this));
    paramBundle = this.vRq;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    if (paramBundle.wCr != null)
    {
      paramBundle = this.vRq;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      if (paramBundle.vTz != null)
      {
        paramBundle = ((MMActivity)localObject2).findViewById(2131300267);
        kotlin.g.b.p.g(paramBundle, "activity.findViewById<Vi…R.id.extend_reading_view)");
        paramBundle.setVisibility(8);
        paramBundle = ((MMActivity)localObject2).findViewById(2131306070);
        kotlin.g.b.p.g(paramBundle, "activity.findViewById<Vi…(R.id.post_location_view)");
        paramBundle.setVisibility(8);
      }
    }
    paramBundle = ((MMActivity)localObject2).findViewById(2131306071);
    kotlin.g.b.p.g(paramBundle, "activity.findViewById(R.…ost_long_video_link_view)");
    this.vRj = paramBundle;
    paramBundle = this.vRq;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    if (paramBundle.isLongVideo)
    {
      paramBundle = this.vRj;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("longVideoLinkView");
      }
      paramBundle.setVisibility(0);
      paramBundle = this.vRj;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("longVideoLinkView");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new p(this));
    }
    localObject2 = getIntent().getStringExtra("saveDesc");
    paramBundle = getIntent().getParcelableArrayListExtra("saveDescAt");
    if (paramBundle != null)
    {
      localObject3 = dAL().dAA().dHI();
      kotlin.g.b.p.h(paramBundle, "atContactParcelList");
      localObject4 = paramBundle.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        paramBundle = (LocalFinderAtContactParcel)((Iterator)localObject4).next();
        try
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.d.vVg;
          kotlin.g.b.p.g(paramBundle, "atContactParcel");
          localObject5 = com.tencent.mm.plugin.finder.utils.d.a(paramBundle);
          localObject6 = ((com.tencent.mm.plugin.finder.view.manager.b)localObject3).wsG;
          localObject1 = ((cjj)localObject5).nickname;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          ((HashMap)localObject6).put(paramBundle, localObject5);
        }
        catch (Exception paramBundle)
        {
          Log.e(com.tencent.mm.plugin.finder.view.manager.b.TAG, "restoreAtContactMap transformToLocalFinderAtContact parseFrom:%s", new Object[] { paramBundle.getMessage() });
        }
      }
    }
    if (!Util.isNullOrNil((String)localObject2)) {
      dAL().dAx().setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)localObject2));
    }
    paramBundle = dAK();
    localObject1 = paramBundle.uHb;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("locationWidget");
    }
    ((com.tencent.mm.plugin.finder.upload.postui.c)localObject1).c(paramBundle.getIntent(), paramBundle.dAD().vUI);
    paramBundle = this.vRg;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("extendReadingWidget");
    }
    localObject1 = getIntent();
    localObject2 = this.vRq;
    if (localObject2 == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
    kotlin.g.b.p.h(localObject1, "intent");
    kotlin.g.b.p.h(localObject2, "postData");
    paramBundle.intent = ((Intent)localObject1);
    paramBundle.vUI = ((Bundle)localObject2);
    localObject2 = ((Intent)localObject1).getStringExtra("saveExtendReadingLink");
    localObject1 = ((Intent)localObject1).getStringExtra("saveExtendReadingTitle");
    if ((localObject2 != null) && (localObject1 != null)) {
      paramBundle.vUH.hn((String)localObject2, (String)localObject1);
    }
    paramBundle = this.vRh;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("originalWidget");
    }
    localObject1 = getIntent();
    localObject2 = this.vRq;
    if (localObject2 == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
    kotlin.g.b.p.h(localObject1, "intent");
    kotlin.g.b.p.h(localObject2, "postData");
    localObject1 = (TextView)paramBundle.activity.findViewById(2131298659);
    paramBundle.vUS.setVisibility(8);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    paramBundle = this.vRi;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("newsWidget");
    }
    localObject2 = getIntent();
    localObject1 = this.vRq;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("postDataManager");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).vUI;
    kotlin.g.b.p.h(localObject2, "intent");
    kotlin.g.b.p.h(localObject1, "postData");
    localObject2 = (TextView)paramBundle.activity.findViewById(2131298657);
    localObject3 = y.vXH;
    boolean bool = y.dCH();
    localObject3 = paramBundle.vUT;
    if (bool)
    {
      i = 0;
      ((FinderChooseNewsView)localObject3).setVisibility(i);
      kotlin.g.b.p.g(localObject2, "divider");
      if (!bool) {
        break label3514;
      }
      i = 0;
      label2654:
      ((TextView)localObject2).setVisibility(i);
      ((Bundle)localObject1).putBoolean("isNews", paramBundle.isChecked());
      paramBundle = this.vRk;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("activityWidget");
      }
      localObject1 = getIntent();
      localObject2 = this.vRq;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
      kotlin.g.b.p.h(localObject1, "intent");
      kotlin.g.b.p.h(localObject2, "postData");
      paramBundle.intent = ((Intent)localObject1);
      kotlin.g.b.p.h(localObject1, "intent");
      localObject2 = com.tencent.mm.plugin.finder.activity.a.tqf;
      kotlin.g.b.p.h(localObject1, "intent");
      localObject2 = com.tencent.mm.plugin.finder.activity.a.cXn();
      if (localObject2 != null)
      {
        com.tencent.e.f.h.hkS();
        localObject3 = com.tencent.mm.plugin.finder.activity.a.tqf;
        a.a.a((Intent)localObject2, (Intent)localObject1);
      }
      i = ((Intent)localObject1).getIntExtra("key_activity_type", 100);
      paramBundle.vUF.setVisibility(8);
      if (((Intent)localObject1).getBooleanExtra("saveActivity", false)) {
        break label3521;
      }
      Log.i("Finder.FinderActivityWidget", "restore no save location data, return");
      label2828:
      paramBundle = this.vRq;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      paramBundle = paramBundle.wCl;
      if (paramBundle != null) {
        break label3583;
      }
      label2852:
      if (paramBundle != null) {
        break label3616;
      }
      if (paramBundle != null) {
        break label3628;
      }
      label2860:
      if (paramBundle != null) {
        break label3660;
      }
      label2864:
      paramBundle = this.vRf;
      if (paramBundle == null) {
        break label3743;
      }
      localObject1 = this.vRc;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("mediaViewContainer");
      }
      ((ViewGroup)localObject1).removeAllViews();
      paramBundle = paramBundle.dJg();
      if (paramBundle != null) {
        break label3693;
      }
      paramBundle = this.vRc;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("mediaViewContainer");
      }
      paramBundle.setVisibility(8);
    }
    long l;
    for (;;)
    {
      localObject2 = this.vRq;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("postDataManager");
      }
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCt;
      if (paramBundle != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putByteArray("MEDIA_EXTRA_MUSIC", paramBundle);
      }
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vMY;
      if (paramBundle != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putByteArray("ORIGIN_MUSIC_INFO", paramBundle);
      }
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putString("ORIGIN_MUSIC_ID", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vMX);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putString("ORIGIN_MUSIC_PATH", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vMV);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putString("ORIGIN_BGM_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vMZ);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putBoolean("MEDIA_IS_MUTE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCu);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putBoolean("MUSIC_IS_MUTE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCv);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putInt("SOUND_TRACK_TYPE", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).soundTrackType);
      if ((((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCr == null) || (((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vTz == null)) {
        break label3750;
      }
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.a.dJb();
      localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCr;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      paramBundle.putByteArray((String)localObject1, ((FinderObjectDesc)localObject3).toByteArray());
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.a.dJa();
      localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vTz;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      paramBundle.putByteArray((String)localObject1, ((azy)localObject3).toByteArray());
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
      paramBundle.putBoolean(com.tencent.mm.plugin.finder.widget.post.a.dJc(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).mch);
      paramBundle = this.vRf;
      if (paramBundle != null)
      {
        localObject1 = this.vRq;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("postDataManager");
        }
        paramBundle.ak(((com.tencent.mm.plugin.finder.widget.post.c)localObject1).vUI);
        paramBundle.refresh();
        localObject1 = this.vRl;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("activityPostView");
        }
        ((FinderExtendActivityView)localObject1).setMediaWidget(paramBundle);
      }
      com.tencent.mm.ac.d.i((kotlin.g.a.a)new s(this));
      dAJ();
      paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
      i = com.tencent.mm.plugin.finder.storage.c.duE();
      paramBundle = com.tencent.mm.plugin.finder.utils.p.vVY;
      if ((com.tencent.mm.plugin.finder.utils.p.dBZ()) && (i > 0))
      {
        paramBundle = new com.tencent.mm.plugin.finder.view.d((Context)getContext());
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c.KV(i - 1);
        paramBundle.Ml(2131494553);
        localObject1 = (TextView)paramBundle.lJI.findViewById(2131305713);
        kotlin.g.b.p.g(localObject1, "titleTv");
        com.tencent.mm.plugin.finder.utils.e.n((TextView)localObject1);
        paramBundle.lJI.findViewById(2131305699).setOnClickListener((View.OnClickListener)new q(paramBundle));
        paramBundle.dGm();
      }
      if (getIntent().getBooleanExtra("KEY_FINDER_POST_FORM_FLUTTER", false))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1565, 3);
        Log.i(this.vRb, "enter export activity");
        l = getIntent().getLongExtra("KEY_FINDER_POST_EXPORT_START_TIME", 0L);
        l = System.currentTimeMillis() - l;
        com.tencent.mm.plugin.report.service.h.CyF.n(1565L, 5L, l);
        Log.i(this.vRb, "enter export activity cost " + l + "ms");
      }
      AppMethodBeat.o(252988);
      return;
      i = 8;
      break;
      label3514:
      i = 8;
      break label2654;
      label3521:
      if (i != 102)
      {
        Log.i("Finder.FinderActivityWidget", "activityType no correct: " + i + ", return");
        break label2828;
      }
      paramBundle.vUF.setVisibility(0);
      paramBundle.vUF.b((Intent)localObject1, i);
      break label2828;
      label3583:
      if (paramBundle.intValue() != 2) {
        break label2852;
      }
      for (;;)
      {
        this.vRf = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.d((Context)getActivity(), (byte)0));
        break label2864;
        label3616:
        if (paramBundle.intValue() != 7) {
          break;
        }
      }
      label3628:
      if (paramBundle.intValue() != 4) {
        break label2860;
      }
      this.vRf = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.f((Context)getActivity()));
      break label2864;
      label3660:
      if (paramBundle.intValue() != 8) {
        break label2864;
      }
      this.vRf = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.e((Context)getActivity()));
      break label2864;
      label3693:
      localObject1 = this.vRc;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("mediaViewContainer");
      }
      ((ViewGroup)localObject1).addView(paramBundle);
      paramBundle = this.vRc;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("mediaViewContainer");
      }
      paramBundle.setOnClickListener(null);
      dAI();
      continue;
      label3743:
      dAI();
    }
    label3750:
    paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCl;
    if (paramBundle == null)
    {
      label3760:
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCl;
      if (paramBundle != null) {
        break label4061;
      }
      label3770:
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCl;
      if (paramBundle != null) {
        break label4084;
      }
    }
    label3893:
    label3942:
    label4073:
    label4078:
    label4084:
    while (paramBundle.intValue() != 4)
    {
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCl;
      if ((paramBundle == null) || (paramBundle.intValue() != 8)) {
        break;
      }
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putStringArrayList("MEDIA_FILE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).tGk);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putIntegerArrayList("MEDIA_TYPE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCq);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putStringArrayList("MEDIA_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCp);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putParcelable("vlog_crop_rect", (Parcelable)((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCs);
      break;
      if (paramBundle.intValue() != 2) {
        break label3760;
      }
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.d.wCM;
      paramBundle.putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.dJi(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).tGk);
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCm != null)
      {
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCm;
        if (paramBundle == null) {
          break label4073;
        }
        paramBundle = Integer.valueOf(paramBundle.size());
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).tGk;
        if (localObject1 == null) {
          break label4078;
        }
      }
      for (localObject1 = Integer.valueOf(((ArrayList)localObject1).size());; localObject1 = null)
      {
        if (kotlin.g.b.p.j(paramBundle, localObject1))
        {
          paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
          localObject1 = com.tencent.mm.plugin.finder.widget.post.d.wCM;
          paramBundle.putIntegerArrayList(com.tencent.mm.plugin.finder.widget.post.d.dJj(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCm);
        }
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
        localObject1 = com.tencent.mm.plugin.finder.widget.post.d.wCM;
        paramBundle.putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.dJk(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCp);
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
        localObject1 = com.tencent.mm.plugin.finder.widget.post.d.wCM;
        paramBundle.putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.dJl(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCx);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putParcelableArrayList("HALF_RECT_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCy);
        break;
        if (paramBundle.intValue() != 7) {
          break label3770;
        }
        break label3893;
        paramBundle = null;
        break label3942;
      }
    }
    label4061:
    ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putStringArrayList("video_file_list", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).tGk);
    if (((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCn != null) {
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putByteArray("video_composition", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCn);
    }
    if (((com.tencent.mm.plugin.finder.widget.post.c)localObject2).isLongVideo)
    {
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo;
      if (paramBundle == null) {
        break label4317;
      }
      if (paramBundle.size() <= 0) {
        break label4306;
      }
      i = 1;
      label4160:
      if (i == 0) {
        break label4312;
      }
      label4165:
      if (paramBundle == null) {
        break label4317;
      }
    }
    label4409:
    label4412:
    for (;;)
    {
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI;
      localObject1 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
      paramBundle.putBoolean(com.tencent.mm.plugin.finder.widget.post.a.dJe(), true);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putStringArrayList("VIDEO_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCp);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putString("video_before_cut_path", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).intent.getStringExtra("select_video_path"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putString("VIDEO_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).intent.getStringExtra("VIDEO_COVER_URL"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putInt("VIDEO_COVER_QUALITY", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).intent.getIntExtra("VIDEO_COVER_QUALITY", 0));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).vUI.putParcelableArrayList("HALF_RECT_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCy);
      break;
      label4306:
      i = 0;
      break label4160;
      label4312:
      paramBundle = null;
      break label4165;
      label4317:
      localObject1 = new LocalVideoCropInfoParcelable();
      paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).tGk;
      if (paramBundle != null)
      {
        if (paramBundle.size() > 0)
        {
          i = 1;
          label4346:
          if (i == 0) {
            break label4409;
          }
        }
        for (;;)
        {
          if (paramBundle == null) {
            break label4412;
          }
          paramBundle = (String)paramBundle.get(0);
          if (paramBundle == null) {
            break;
          }
          kotlin.g.b.p.g(paramBundle, "mediaList?.takeIf { it.s…urn@initLongVideoCropInfo");
          localObject4 = MultiMediaVideoChecker.GyY.aTV(paramBundle);
          if (localObject4 != null) {
            break label4414;
          }
          Log.e(((com.tencent.mm.plugin.finder.widget.post.c)localObject2).TAG, "initLongVideoCropInfo: video info is null");
          break;
          i = 0;
          break label4346;
          paramBundle = null;
        }
      }
    }
    label4414:
    float f1 = ((MultiMediaVideoChecker.a)localObject4).height;
    float f2 = ((MultiMediaVideoChecker.a)localObject4).width;
    int i = SightVideoJNI.getMp4RotateVFS(paramBundle);
    if ((i == 90) || (i == 270))
    {
      f1 = ((MultiMediaVideoChecker.a)localObject4).width;
      f2 = ((MultiMediaVideoChecker.a)localObject4).height;
    }
    for (;;)
    {
      paramBundle = new Matrix();
      float f5 = au.az(MMApplicationContext.getContext()).x;
      float f3 = f2 / f1;
      float f4;
      if (f3 < 0.8571429F)
      {
        f2 = f5 / f2;
        paramBundle.postScale(f2, f2);
        f4 = f5 / 0.8571429F;
        f3 = (f1 * f2 - f4) / 2.0F;
        f1 = 0.0F;
        f4 += f3;
        label4536:
        localObject3 = new cjx();
        localObject5 = com.tencent.mm.plugin.finder.storage.c.vCb;
        l = com.tencent.mm.plugin.finder.storage.c.drG() * 1000L;
        if (((MultiMediaVideoChecker.a)localObject4).duration <= l) {
          break label4931;
        }
      }
      label4931:
      for (i = (int)l;; i = (int)((MultiMediaVideoChecker.a)localObject4).duration)
      {
        ((cjx)localObject3).iqg = i;
        localObject4 = new erf();
        ((erf)localObject4).left = ((int)f1);
        ((erf)localObject4).top = ((int)f4);
        ((erf)localObject4).bottom = ((int)f3);
        ((erf)localObject4).right = ((int)f5);
        ((cjx)localObject3).Mpq = ((erf)localObject4);
        localObject4 = new erf();
        ((erf)localObject4).left = ((int)(f1 / f2));
        ((erf)localObject4).top = ((int)(f4 / f2));
        ((erf)localObject4).bottom = ((int)(f3 / f2));
        ((erf)localObject4).right = ((int)(f5 / f2));
        ((cjx)localObject3).Mps = ((erf)localObject4);
        ((cjx)localObject3).height = ((int)(f4 - f3));
        ((cjx)localObject3).width = ((int)(f5 - f1));
        paramBundle.postTranslate(-f1, -f3);
        localObject4 = new bej();
        localObject5 = new float[9];
        paramBundle.getValues((float[])localObject5);
        ((bej)localObject4).LOe.addAll((Collection)kotlin.a.e.s((float[])localObject5));
        ((cjx)localObject3).Mpr = ((bej)localObject4);
        ((LocalVideoCropInfoParcelable)localObject1).uOR = ((cjx)localObject3);
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo == null)
        {
          ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo = new ArrayList();
          paramBundle = x.SXb;
        }
        paramBundle = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo;
        if (paramBundle != null) {
          paramBundle.add(localObject1);
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).intent.putParcelableArrayListExtra("postVideoCropList", ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).wCo);
        break;
        if (f3 > 1.777778F)
        {
          f6 = f1 * 1.777778F;
          f3 = f5 / f6;
          paramBundle.postScale(f3, f3);
          f4 = f1 * f3;
          f1 = (f2 - f6) * f3 / 2.0F;
          f5 = f1 + f6 * f3;
          f6 = 0.0F;
          f2 = f3;
          f3 = f6;
          break label4536;
        }
        f2 = f5 / f2;
        paramBundle.postScale(f2, f2);
        f3 = 0.0F;
        float f6 = 0.0F;
        f4 = f1 * f2;
        f1 = f6;
        break label4536;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252990);
    super.onResume();
    this.udM = au.eu((Context)getContext());
    Object localObject = this.vRg;
    if (localObject == null) {
      kotlin.g.b.p.btv("extendReadingWidget");
    }
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject).vUH.dHC();
    localObject = com.tencent.mm.plugin.vlog.model.m.Gyi;
    com.tencent.mm.plugin.vlog.model.m.fBd();
    AppMethodBeat.o(252990);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(252989);
    if (!this.vRs)
    {
      com.tencent.mm.ui.tools.h localh = this.gyh;
      if (localh == null) {
        kotlin.g.b.p.btv("keyboardHeightProvider");
      }
      localh.start();
      this.vRs = true;
    }
    AppMethodBeat.o(252989);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(252995);
    Object localObject1 = dAL().dAy();
    final View localView = dAL().dAz();
    if (paramInt > 0) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      if ((paramInt > 0) && (paramInt != (int)((FinderPostFooter)localObject1).wkX))
      {
        KeyBoardUtil.saveKeyBordHeightPx(((FinderPostFooter)localObject1).getContext(), paramInt);
        ((FinderPostFooter)localObject1).wkX = paramInt;
        localObject2 = new LinearLayout.LayoutParams(-1, (int)((FinderPostFooter)localObject1).wkX);
        SmileyPanel localSmileyPanel = ((FinderPostFooter)localObject1).hQS;
        if (localSmileyPanel == null) {
          kotlin.g.b.p.btv("smileyPanel");
        }
        localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((FinderPostFooter)localObject1).wkR;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("smileyBtn");
      }
      localObject2 = ((ImageView)localObject2).getTag();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(252995);
      throw ((Throwable)localObject1);
    }
    paramBoolean = ((Boolean)localObject2).booleanValue();
    if ((i == 0) && (!paramBoolean))
    {
      localObject2 = ((FinderPostFooter)localObject1).jxm;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean)) {
        ((FinderPostFooter)localObject1).R(false, false);
      }
      ((FinderPostFooter)localObject1).post((Runnable)new r(this, localView));
      AppMethodBeat.o(252995);
      return;
      localObject2 = ((FinderPostFooter)localObject1).jxm;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/post/PostMainUIC$Companion;", "", "()V", "CHECK_POST_INTERVAL", "", "CONFIME_DEL_MEDIA", "", "MAX_CHECK_POST_COUNT", "REQUEST_CODE_PICK_LOCATION", "REQUEST_CODE_SELECTE_MEDIA", "REQUEST_CODE_SELECT_AT_CONTACT", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(PostMainUIC paramPostMainUIC, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(252963);
      this.vRv.dAE().scrollBy(0, this.vRw - this.vRx);
      AppMethodBeat.o(252963);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(PostMainUIC paramPostMainUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(252964);
      PostMainUIC.c(this.vRv);
      AppMethodBeat.o(252964);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class g
    implements View.OnLayoutChangeListener
  {
    g(PostMainUIC paramPostMainUIC) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(252966);
      Log.i(PostMainUIC.k(this.vRv), "oldBottom " + paramInt8 + ", bottom " + paramInt4);
      if (paramInt8 != paramInt4) {
        PostMainUIC.l(this.vRv);
      }
      AppMethodBeat.o(252966);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(PostMainUIC paramPostMainUIC) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(252967);
      PostMainUIC.p(this.vRv);
      PostMainUIC.q(this.vRv);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.at(4, true);
      AppMethodBeat.o(252967);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class i
    implements DialogInterface.OnClickListener
  {
    i(PostMainUIC paramPostMainUIC) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(252968);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.at(4, false);
      PostMainUIC.q(this.vRv);
      AppMethodBeat.o(252968);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(PostMainUIC paramPostMainUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252970);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      PostMainUIC.f(this.vRv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252970);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(PostMainUIC paramPostMainUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252971);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      PostMainUIC.g(this.vRv).dAC();
      paramView = new Intent();
      paramView.putExtras(this.vRv.getIntent());
      paramView.putExtra("album_from_finder_add_media", true);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.b(paramView, this.vRv.getIntent());
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.J((Context)this.vRv.getActivity(), paramView);
      paramView = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Kr(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initDelMediaBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252971);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(PostMainUIC paramPostMainUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252972);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      PostMainUIC.a(this.vRv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252972);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(PostMainUIC paramPostMainUIC, MMActivity paramMMActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252973);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (Util.isNullOrNil(z.aUg()))
      {
        paramView = y.vXH;
        if (y.an((Activity)this.nbB))
        {
          paramView = new Intent();
          localObject = com.tencent.mm.ui.component.a.PRN;
          if (!Util.isNullOrNil(((SdkShareUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.nbB).get(SdkShareUIC.class)).dAO())) {
            break label176;
          }
          paramView.putExtra("key_create_scene", 4);
        }
        for (;;)
        {
          paramView.putExtra("scene", 2);
          paramView.putExtra("key_router_to_profile", false);
          localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.w((Context)this.nbB, paramView);
          com.tencent.mm.plugin.report.service.h.CyF.a(20694, new Object[] { Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252973);
          return;
          label176:
          paramView.putExtra("key_create_scene", 5);
        }
      }
      if (PostMainUIC.b(this.vRv) == 0)
      {
        if (this.vRv.getIntent().getIntExtra("key_finder_post_from", -1) == 5)
        {
          paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1)
          {
            paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
            int i = com.tencent.mm.plugin.finder.storage.c.dsS();
            if (i < 6)
            {
              paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
              com.tencent.mm.plugin.finder.storage.c.KS(i + 1);
            }
          }
        }
        paramView = com.tencent.mm.plugin.vlog.model.m.Gyi;
        com.tencent.mm.plugin.vlog.model.m.fBe();
        PostMainUIC.c(this.vRv);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252973);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "open", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    o(PostMainUIC paramPostMainUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(PostMainUIC paramPostMainUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252975);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = PostMainUIC.e(this.vRv);
      paramView = (View)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.plugin.finder.widget.post.f)) {
        paramView = null;
      }
      localObject1 = (com.tencent.mm.plugin.finder.widget.post.f)paramView;
      if (localObject1 != null)
      {
        paramView = new cjk();
        Object localObject4;
        if (((com.tencent.mm.plugin.finder.widget.post.f)localObject1).wDo == null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.f)localObject1).wDi;
          if (localObject2 != null)
          {
            localObject4 = (String)j.ks((List)localObject2);
            if (localObject4 != null) {
              break label219;
            }
          }
        }
        Object localObject3;
        Object localObject5;
        label219:
        do
        {
          localObject2 = x.SXb;
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.f)localObject1).wDi;
          if (localObject2 == null) {
            kotlin.g.b.p.hyc();
          }
          localObject2 = ((Iterable)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (i < 0) {
              j.hxH();
            }
            localObject3 = (String)localObject3;
            localObject4 = paramView.mediaList;
            localObject5 = com.tencent.mm.plugin.finder.upload.i.vSX;
            ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.a((String)localObject3, "", ((com.tencent.mm.plugin.finder.widget.post.f)localObject1).wDo));
            i += 1;
          }
          localObject2 = new cjx();
          localObject3 = MultiMediaVideoChecker.GyY.aTV((String)localObject4);
        } while (localObject3 == null);
        int j = ((MultiMediaVideoChecker.a)localObject3).width;
        int i = ((MultiMediaVideoChecker.a)localObject3).height;
        int k = SightVideoJNI.getMp4RotateVFS((String)localObject4);
        if ((k == 90) || (k == 270))
        {
          j = ((MultiMediaVideoChecker.a)localObject3).height;
          i = ((MultiMediaVideoChecker.a)localObject3).width;
        }
        k = au.az(((com.tencent.mm.plugin.finder.widget.post.a)localObject1).context).x;
        float f = j / i;
        if ((f >= 0.5625F) && (f <= 1.777778F))
        {
          localObject4 = new erf();
          ((erf)localObject4).left = 0;
          ((erf)localObject4).top = i;
          ((erf)localObject4).right = j;
          ((erf)localObject4).bottom = 0;
          ((cjx)localObject2).Mpq = ((erf)localObject4);
          ((cjx)localObject2).Mps = ((erf)localObject4);
          localObject4 = j.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
          localObject5 = new bej();
          ((bej)localObject5).LOe.addAll((Collection)j.p((Iterable)localObject4));
          ((cjx)localObject2).Mpr = ((bej)localObject5);
        }
        for (;;)
        {
          ((cjx)localObject2).dvv = 0;
          ((cjx)localObject2).iqg = ((int)((MultiMediaVideoChecker.a)localObject3).duration);
          ((cjx)localObject2).width = j;
          ((cjx)localObject2).height = i;
          ((cjx)localObject2).retryCount = 0;
          ((com.tencent.mm.plugin.finder.widget.post.f)localObject1).wDo = ((cjx)localObject2);
          break;
          float[] arrayOfFloat;
          if (f > 1.777778F)
          {
            k = (int)(i * 16.0F / 9.0F);
            localObject5 = new erf();
            ((erf)localObject5).left = ((j - k) / 2);
            ((erf)localObject5).top = i;
            ((erf)localObject5).right = (j - ((erf)localObject5).left);
            ((erf)localObject5).bottom = 0;
            ((cjx)localObject2).Mpq = ((erf)localObject5);
            ((cjx)localObject2).Mps = ((erf)localObject5);
            localObject4 = new Matrix();
            ((Matrix)localObject4).postTranslate(-((erf)localObject5).left, 0.0F);
            localObject5 = new bej();
            arrayOfFloat = new float[9];
            ((Matrix)localObject4).getValues(arrayOfFloat);
            ((bej)localObject5).LOe.addAll((Collection)kotlin.a.e.s(arrayOfFloat));
            ((cjx)localObject2).Mpr = ((bej)localObject5);
            j = k;
          }
          else
          {
            k = (int)(j * 16.0F / 9.0F);
            localObject5 = new erf();
            ((erf)localObject5).left = 0;
            ((erf)localObject5).bottom = ((i - k) / 2);
            ((erf)localObject5).right = j;
            ((erf)localObject5).top = (i - ((erf)localObject5).bottom);
            ((cjx)localObject2).Mpq = ((erf)localObject5);
            ((cjx)localObject2).Mps = ((erf)localObject5);
            localObject4 = new Matrix();
            ((Matrix)localObject4).postTranslate(0.0F, -((erf)localObject5).bottom);
            localObject5 = new bej();
            arrayOfFloat = new float[9];
            ((Matrix)localObject4).getValues(arrayOfFloat);
            ((bej)localObject5).LOe.addAll((Collection)kotlin.a.e.s(arrayOfFloat));
            ((cjx)localObject2).Mpr = ((bej)localObject5);
            i = k;
          }
        }
        Object localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).context;
        if (localObject1 == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(252975);
          throw paramView;
        }
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, null, paramView, null, true, 8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252975);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252976);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tru.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/post/PostMainUIC$initView$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252976);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(PostMainUIC paramPostMainUIC, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(252977);
      Log.i(PostMainUIC.k(this.vRv), "footer.height " + localView.getHeight() + ", footer.oldHeight " + PostMainUIC.g(this.vRv).vQU);
      if (localView.getVisibility() == 0)
      {
        if ((PostMainUIC.g(this.vRv).dAx().hasFocus()) && (localView.getHeight() != PostMainUIC.g(this.vRv).vQU))
        {
          PostMainUIC.g(this.vRv).vQU = localView.getHeight();
          PostMainUIC.l(this.vRv);
        }
        PostMainUIC.m(this.vRv).addOnLayoutChangeListener(PostMainUIC.n(this.vRv));
        AppMethodBeat.o(252977);
        return;
      }
      if ((localView.getVisibility() == 8) || (localView.getHeight() == 0))
      {
        PostMainUIC.g(this.vRv).vQU = 0;
        this.vRv.dAE().scrollTo(0, 0);
        Object localObject = PostMainUIC.o(this.vRv).getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(252977);
          throw ((Throwable)localObject);
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).height = 0;
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        PostMainUIC.o(this.vRv).setLayoutParams((ViewGroup.LayoutParams)localObject);
        PostMainUIC.o(this.vRv).requestLayout();
        PostMainUIC.m(this.vRv).removeOnLayoutChangeListener(PostMainUIC.n(this.vRv));
      }
      AppMethodBeat.o(252977);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    s(PostMainUIC paramPostMainUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    t(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class u
    implements o.f
  {
    u(PostMainUIC paramPostMainUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(252980);
      kotlin.g.b.p.g(paramm, "it");
      if (paramm.gKQ()) {
        paramm.a(20003, this.vRv.getContext().getResources().getColor(2131099818), (CharSequence)this.vRv.getContext().getResources().getString(2131760411));
      }
      AppMethodBeat.o(252980);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class v
    implements o.g
  {
    v(PostMainUIC paramPostMainUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(252981);
      kotlin.g.b.p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(252981);
        return;
        PostMainUIC.h(this.vRv);
        PostMainUIC.i(this.vRv);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class w
    implements e.b
  {
    w(PostMainUIC paramPostMainUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(252982);
      PostMainUIC.i(this.vRv);
      AppMethodBeat.o(252982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.post.PostMainUIC
 * JD-Core Version:    0.7.0.1
 */