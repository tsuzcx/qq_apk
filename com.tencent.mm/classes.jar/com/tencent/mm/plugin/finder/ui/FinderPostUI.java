package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.c;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.pluginsdk.location.LocationView;
import com.tencent.mm.pluginsdk.location.LocationView.a;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.a.j;
import d.n.n;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(17)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "()V", "CHECK_POST_INTERVAL", "", "MAX_CHECK_POST_COUNT", "", "MENU_ID_POST", "REQUEST_CODE_PICK_LOCATION", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "actionBarHeight", "avatarIv", "Landroid/widget/ImageView;", "bottomSpace", "Landroid/view/View;", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "deleteAtStringByInter", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendReadingWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "footerContainer", "hasStartKeyBoardProvider", "", "isFromtOfAtOneEnd", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "nickTv", "Landroid/widget/TextView;", "oldFooterHeight", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "scrollView", "Landroid/widget/ScrollView;", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "textCountTv", "textOk", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "checkNeedScroll", "", "checkNextEnable", "checkPermission", "checkPostData", "deleteAtMemberFromEnd", "deleteAtMemberFromInter", "atStringInfo", "deleteInAtSomeoneInter", "exitAndSave", "getCharAtCursor", "", "getLayoutId", "initDescText", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetLbsLifes", "city", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onTopicClick", "onWindowFocusChanged", "hasFocus", "requestLocation", "restore", "routeBack", "routeForward", "saveDescData", "desc", "selectMedia", "plugin-finder_release"})
public final class FinderPostUI
  extends MMFinderUI
  implements FinderPostFooter.b, a.a, com.tencent.mm.ui.tools.g
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private com.tencent.mm.plugin.finder.api.f contact;
  private p fua;
  private ScrollView fwW;
  private com.tencent.mm.ui.tools.h fxG;
  private ImageView fxQ;
  private TextView iNX;
  private String rJO;
  private FinderPostEditText rJP;
  private TextView rJQ;
  private ViewGroup rJR;
  private View rJS;
  private com.tencent.mm.plugin.finder.widget.post.a rJT;
  private com.tencent.mm.plugin.finder.upload.postui.b rJU;
  private com.tencent.mm.plugin.finder.upload.postui.a rJV;
  private com.tencent.mm.plugin.finder.upload.postui.c rJW;
  private boolean rJX;
  private boolean rJY;
  private com.tencent.mm.plugin.finder.utils.b.a rJZ;
  private View rJj;
  private com.tencent.mm.plugin.finder.widget.post.c rKa;
  private int rKb;
  private int rKc;
  private final int rKd;
  private final long rKe;
  private final int rKf;
  private final int rKg;
  private FinderPostFooter rKh;
  private View rKi;
  private FinderTopicSuggestView rKj;
  private com.tencent.mm.plugin.finder.view.manager.c rKk;
  private boolean rKl;
  private int rKm;
  private final View.OnLayoutChangeListener rKn;
  private final int rrs;
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    this.TAG = "Finder.FinderPostUI";
    this.rJO = "";
    this.rJX = true;
    this.rKd = 10;
    this.rKe = 500L;
    this.rrs = 10000;
    this.rKf = 20000;
    this.rKg = 20001;
    this.rKn = ((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(167543);
  }
  
  private final boolean Ib()
  {
    AppMethodBeat.i(167529);
    if ((Build.VERSION.SDK_INT < 23) && ((d.g.b.k.g("MNC", Build.VERSION.CODENAME) ^ true)))
    {
      AppMethodBeat.o(167529);
      return true;
    }
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission((Context)this, "android.permission.ACCESS_COARSE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(167529);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.e(this.TAG, "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(167529);
      return true;
    }
    AppMethodBeat.o(167529);
    return false;
  }
  
  private final void cCe()
  {
    AppMethodBeat.i(167534);
    Object localObject = this.rJV;
    if (localObject == null) {
      d.g.b.k.aVY("extendReadingWidget");
    }
    if (((com.tencent.mm.plugin.finder.upload.postui.a)localObject).rOk.cFt())
    {
      localObject = this.rKa;
      if (localObject == null) {
        d.g.b.k.aVY("postDataManager");
      }
      localObject = ((com.tencent.mm.plugin.finder.widget.post.c)localObject).sie;
      if (localObject != null) {
        break label78;
      }
    }
    while (!this.rJX) {
      label78:
      do
      {
        enableOptionMenu(this.rrs, false);
        AppMethodBeat.o(167534);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = this.rJP;
        if (localObject == null) {
          d.g.b.k.aVY("descTv");
        }
      } while (bs.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    localObject = this.rJT;
    if (localObject != null)
    {
      if ((localObject instanceof com.tencent.mm.plugin.finder.widget.post.f))
      {
        localObject = this.rJP;
        if (localObject == null) {
          d.g.b.k.aVY("descTv");
        }
        localObject = ((FinderPostEditText)localObject).getText().toString();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(167534);
          throw ((Throwable)localObject);
        }
        if (bs.isNullOrNil(n.trim((CharSequence)localObject).toString()))
        {
          enableOptionMenu(this.rrs, false);
          AppMethodBeat.o(167534);
          return;
        }
      }
      enableOptionMenu(this.rrs, true);
      AppMethodBeat.o(167534);
      return;
    }
    enableOptionMenu(this.rrs, false);
    AppMethodBeat.o(167534);
  }
  
  private final void cCf()
  {
    AppMethodBeat.i(167538);
    Object localObject = com.tencent.mm.plugin.finder.report.c.rxi;
    localObject = this.rKk;
    if (localObject == null) {
      d.g.b.k.aVY("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.c)localObject).cFD().saJ;
    com.tencent.mm.plugin.finder.view.manager.c localc = this.rKk;
    if (localc == null) {
      d.g.b.k.aVY("styleManager");
    }
    int i = localc.cFD().saL;
    localc = this.rKk;
    if (localc == null) {
      d.g.b.k.aVY("styleManager");
    }
    com.tencent.mm.plugin.finder.report.c.c((ArrayList)localObject, i, localc.cFD().saM);
    localObject = this.rKa;
    if (localObject == null) {
      d.g.b.k.aVY("postDataManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.widget.post.c)localObject).sie;
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.rKa;
      if (localObject == null) {
        d.g.b.k.aVY("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject).shV == null)
      {
        localObject = this.rKa;
        if (localObject == null) {
          d.g.b.k.aVY("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject).sij == null) {
          break;
        }
      }
      do
      {
        finish();
        AppMethodBeat.o(167538);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = this.rJP;
        if (localObject == null) {
          d.g.b.k.aVY("descTv");
        }
      } while (bs.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    com.tencent.mm.ui.base.h.a((Context)this, 2131759390, 0, 2131759392, 2131759391, true, (DialogInterface.OnClickListener)new d(this), (DialogInterface.OnClickListener)new e(this), 2131099903);
    AppMethodBeat.o(167538);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203301);
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
    AppMethodBeat.o(203301);
    return localView1;
  }
  
  public final void cCg()
  {
    AppMethodBeat.i(203294);
    Object localObject1 = this.rJP;
    if (localObject1 == null) {
      d.g.b.k.aVY("descTv");
    }
    int i = ((FinderPostEditText)localObject1).getSelectionStart();
    localObject1 = this.rJP;
    if (localObject1 == null) {
      d.g.b.k.aVY("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.finder.utils.m.rPH;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.utils.m.cDg());
    localObject3 = com.tencent.mm.plugin.finder.utils.m.rPH;
    localObject2 = com.tencent.mm.plugin.finder.utils.m.cDg();
    if (i == 0) {
      localObject1 = (String)localObject2 + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = this.rJP;
      if (localObject2 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
      localObject1 = this.rJP;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject1).requestFocus();
      localObject1 = this.rJP;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject1).setSelection(i + 1);
      AppMethodBeat.o(203294);
      return;
      if (i == ((String)localObject1).length())
      {
        localObject1 = (String)localObject1 + (String)localObject2;
      }
      else
      {
        localObject3 = new StringBuilder();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(203294);
          throw ((Throwable)localObject1);
        }
        String str = ((String)localObject1).substring(0, i);
        d.g.b.k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject3).append(str).append((String)localObject2);
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(203294);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).substring(i, j);
        d.g.b.k.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject1;
      }
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494090;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167530);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131099666));
    Object localObject1 = findViewById(2131303367);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_media_widget_container)");
    this.rJR = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131303359);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_avatar)");
    this.fxQ = ((ImageView)localObject1);
    localObject1 = findViewById(2131303369);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_nickname)");
    this.iNX = ((TextView)localObject1);
    localObject1 = findViewById(2131303361);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_desc_edt)");
    this.rJP = ((FinderPostEditText)localObject1);
    localObject1 = findViewById(2131304376);
    d.g.b.k.g(localObject1, "findViewById(R.id.scroll_view)");
    this.fwW = ((ScrollView)localObject1);
    localObject1 = findViewById(2131297467);
    d.g.b.k.g(localObject1, "findViewById(R.id.bottom_space)");
    this.rJS = ((View)localObject1);
    localObject1 = findViewById(2131299309);
    d.g.b.k.g(localObject1, "findViewById(R.id.edt_container)");
    this.rJj = ((View)localObject1);
    localObject1 = findViewById(2131306036);
    d.g.b.k.g(localObject1, "findViewById(R.id.topic_suggest_view)");
    this.rKj = ((FinderTopicSuggestView)localObject1);
    localObject1 = this.rKj;
    if (localObject1 == null) {
      d.g.b.k.aVY("topicSuggestView");
    }
    Object localObject2 = this.rJP;
    if (localObject2 == null) {
      d.g.b.k.aVY("descTv");
    }
    this.rKk = new com.tencent.mm.plugin.finder.view.manager.c((FinderTopicSuggestView)localObject1, (FinderPostEditText)localObject2, (MMActivity)this);
    localObject1 = (MMActivity)this;
    localObject2 = findViewById(2131307297);
    d.g.b.k.g(localObject2, "findViewById(R.id.choose_original_view)");
    this.rJW = new com.tencent.mm.plugin.finder.upload.postui.c((MMActivity)localObject1, (FinderChooseOriginalView)localObject2);
    localObject1 = findViewById(2131300198);
    d.g.b.k.g(localObject1, "findViewById(R.id.footer_container)");
    this.rKi = ((View)localObject1);
    localObject1 = this.rKi;
    if (localObject1 == null) {
      d.g.b.k.aVY("footerContainer");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = findViewById(2131299983);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_comment_footer)");
    this.rKh = ((FinderPostFooter)localObject1);
    localObject1 = this.rKh;
    if (localObject1 == null) {
      d.g.b.k.aVY("footer");
    }
    localObject2 = (MMActivity)this;
    Object localObject3 = this.rKi;
    if (localObject3 == null) {
      d.g.b.k.aVY("footerContainer");
    }
    Object localObject4 = this.rJP;
    if (localObject4 == null) {
      d.g.b.k.aVY("descTv");
    }
    localObject4 = (MMEditText)localObject4;
    final int i = this.rKg;
    Object localObject6 = (FinderPostFooter.b)this;
    d.g.b.k.h(localObject2, "activity");
    d.g.b.k.h(localObject3, "container");
    d.g.b.k.h(localObject4, "editText");
    d.g.b.k.h(localObject6, "iTopicCallback");
    ((FinderPostFooter)localObject1).activity = ((MMActivity)localObject2);
    ((FinderPostFooter)localObject1).ifK = ((View)localObject3);
    ((FinderPostFooter)localObject1).rWm = ((MMEditText)localObject4);
    ((FinderPostFooter)localObject1).jWt = i;
    ((FinderPostFooter)localObject1).rYn = ((FinderPostFooter.b)localObject6);
    ((FinderPostFooter)localObject1).setOnClickListener((View.OnClickListener)FinderPostFooter.c.rYp);
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czo())
    {
      findViewById(2131306037).setOnTouchListener((View.OnTouchListener)new j(this));
      localObject1 = this.fwW;
      if (localObject1 == null) {
        d.g.b.k.aVY("scrollView");
      }
      ((ScrollView)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)new k(this));
      localObject1 = this.rKh;
      if (localObject1 == null) {
        d.g.b.k.aVY("footer");
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((FinderPostFooter)localObject1).lY(com.tencent.mm.plugin.finder.storage.b.czp());
      this.fxG = new com.tencent.mm.ui.tools.h((Activity)this);
      localObject1 = this.fxG;
      if (localObject1 == null) {
        d.g.b.k.aVY("keyboardHeightProvider");
      }
      ((com.tencent.mm.ui.tools.h)localObject1).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)this);
      localObject1 = findViewById(2131305750);
      d.g.b.k.g(localObject1, "findViewById(R.id.textcount_hint)");
      this.rJQ = ((TextView)localObject1);
      localObject1 = this.rJQ;
      if (localObject1 == null) {
        d.g.b.k.aVY("textCountTv");
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = this.rJQ;
      if (localObject1 == null) {
        d.g.b.k.aVY("textCountTv");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (MMActivity)this;
      localObject2 = findViewById(2131303366);
      d.g.b.k.g(localObject2, "findViewById(R.id.post_location_view)");
      localObject2 = (LocationView)localObject2;
      localObject3 = findViewById(2131303337);
      d.g.b.k.g(localObject3, "findViewById(R.id.poi_tip_layout)");
      localObject4 = findViewById(2131303338);
      d.g.b.k.g(localObject4, "findViewById(R.id.poi_tip_tv)");
      this.rJU = new com.tencent.mm.plugin.finder.upload.postui.b((MMActivity)localObject1, (LocationView)localObject2, (View)localObject3, (TextView)localObject4, this.rKf);
      localObject1 = this.contact;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
        localObject2 = com.tencent.mm.plugin.finder.loader.h.cwo();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject1).field_avatarUrl);
        localObject4 = this.fxQ;
        if (localObject4 == null) {
          d.g.b.k.aVY("avatarIv");
        }
        localObject6 = com.tencent.mm.plugin.finder.loader.h.rtK;
        ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
        localObject2 = this.iNX;
        if (localObject2 == null) {
          d.g.b.k.aVY("nickTv");
        }
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject1).Tn()));
      }
      if (getIntent().getBooleanExtra("hideDescEdit", false))
      {
        localObject1 = this.rJP;
        if (localObject1 == null) {
          d.g.b.k.aVY("descTv");
        }
        ((FinderPostEditText)localObject1).setVisibility(8);
      }
      setBackBtn((MenuItem.OnMenuItemClickListener)new l(this));
      addTextOptionMenu(this.rrs, getString(2131759300), (MenuItem.OnMenuItemClickListener)new m(this), null, s.b.Hox);
      enableOptionMenu(this.rrs, false);
      localObject1 = this.rKa;
      if (localObject1 == null) {
        d.g.b.k.aVY("postDataManager");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sie;
      if (localObject1 != null) {
        break label1443;
      }
      label986:
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    }
    for (i = com.tencent.mm.plugin.finder.storage.b.cyK();; i = com.tencent.mm.plugin.finder.storage.b.cyL())
    {
      localObject1 = (TextWatcher)new i(this, i);
      localObject2 = this.rJP;
      if (localObject2 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject2).addTextChangedListener((TextWatcher)localObject1);
      localObject1 = this.rJP;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject1).setOnSelectionChangedListener((d.g.a.m)new f(this));
      localObject1 = this.rJP;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject1).setOnTouchListener((View.OnTouchListener)new g(this));
      localObject1 = this.rJP;
      if (localObject1 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject1).setOnKeyListener((View.OnKeyListener)new h(this));
      localObject1 = (MMActivity)this;
      localObject2 = findViewById(2131299633);
      d.g.b.k.g(localObject2, "findViewById(R.id.extend_reading_view)");
      this.rJV = new com.tencent.mm.plugin.finder.upload.postui.a((MMActivity)localObject1, (FinderExtendReadingView)localObject2, (d.g.a.b)new n(this));
      localObject1 = this.rKa;
      if (localObject1 == null) {
        d.g.b.k.aVY("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sij != null)
      {
        localObject1 = this.rKa;
        if (localObject1 == null) {
          d.g.b.k.aVY("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).shV != null)
        {
          localObject1 = findViewById(2131299633);
          d.g.b.k.g(localObject1, "findViewById<View>(R.id.extend_reading_view)");
          ((View)localObject1).setVisibility(8);
          localObject1 = findViewById(2131303366);
          d.g.b.k.g(localObject1, "findViewById<View>(R.id.post_location_view)");
          ((View)localObject1).setVisibility(8);
        }
      }
      localObject1 = getIntent().getStringExtra("saveDesc");
      localObject3 = getIntent().getParcelableArrayListExtra("saveDescAt");
      if (localObject3 == null) {
        break label1462;
      }
      localObject2 = this.rKk;
      if (localObject2 == null) {
        d.g.b.k.aVY("styleManager");
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject2).cFD();
      d.g.b.k.h(localObject3, "atContactParcelList");
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (LocalFinderAtContactParcel)((Iterator)localObject3).next();
        try
        {
          localObject6 = com.tencent.mm.plugin.finder.utils.b.rOw;
          d.g.b.k.g(localObject4, "atContactParcel");
          localObject4 = com.tencent.mm.plugin.finder.utils.b.a((LocalFinderAtContactParcel)localObject4);
          ((com.tencent.mm.plugin.finder.view.manager.a)localObject2).saI.put(((bqq)localObject4).nickname, localObject4);
        }
        catch (Exception localException)
        {
          ac.e(com.tencent.mm.plugin.finder.view.manager.a.TAG, "restoreAtContactMap transformToLocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
        }
      }
      localObject1 = this.rKh;
      if (localObject1 == null) {
        d.g.b.k.aVY("footer");
      }
      ((FinderPostFooter)localObject1).lX(false);
      localObject1 = this.rKj;
      if (localObject1 == null) {
        d.g.b.k.aVY("topicSuggestView");
      }
      ((FinderTopicSuggestView)localObject1).setVisibility(8);
      break;
      label1443:
      if (((Integer)localObject1).intValue() != 1) {
        break label986;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    }
    label1462:
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject2 = this.rJP;
      if (localObject2 == null) {
        d.g.b.k.aVY("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.rJU;
    if (localObject1 == null) {
      d.g.b.k.aVY("locationWidget");
    }
    localObject2 = getIntent();
    d.g.b.k.g(localObject2, "intent");
    localObject3 = this.rKa;
    if (localObject3 == null) {
      d.g.b.k.aVY("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).rOl;
    d.g.b.k.h(localObject2, "intent");
    d.g.b.k.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent = ((Intent)localObject2);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOl = ((Bundle)localObject3);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOr.setVisibility(8);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOq.setLocationName(((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).activity.getString(2131759251));
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOq.setOnClickLocationListener((LocationView.a)new com.tencent.mm.plugin.finder.upload.postui.b.a((com.tencent.mm.plugin.finder.upload.postui.b)localObject1));
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).cCI();
    localObject1 = this.rJV;
    if (localObject1 == null) {
      d.g.b.k.aVY("extendReadingWidget");
    }
    localObject2 = getIntent();
    d.g.b.k.g(localObject2, "intent");
    localObject3 = this.rKa;
    if (localObject3 == null) {
      d.g.b.k.aVY("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).rOl;
    d.g.b.k.h(localObject2, "intent");
    d.g.b.k.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).intent = ((Intent)localObject2);
    ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).rOl = ((Bundle)localObject3);
    localObject3 = ((Intent)localObject2).getStringExtra("saveExtendReadingLink");
    localObject2 = ((Intent)localObject2).getStringExtra("saveExtendReadingTitle");
    if ((localObject3 != null) && (localObject2 != null)) {
      ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).rOk.gs((String)localObject3, (String)localObject2);
    }
    localObject1 = this.rJW;
    if (localObject1 == null) {
      d.g.b.k.aVY("originalWidget");
    }
    localObject2 = getIntent();
    d.g.b.k.g(localObject2, "intent");
    localObject3 = this.rKa;
    if (localObject3 == null) {
      d.g.b.k.aVY("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).rOl;
    d.g.b.k.h(localObject2, "intent");
    d.g.b.k.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.c)localObject1).rOu.setVisibility(8);
    localObject1 = this.rKa;
    if (localObject1 == null) {
      d.g.b.k.aVY("postDataManager");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sie;
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label2125;
      }
      if (localObject1 != null) {
        break label2137;
      }
      label1837:
      if (localObject1 != null) {
        break label2166;
      }
      label1841:
      if (localObject1 != null) {
        break label2196;
      }
      label1845:
      localObject1 = this.rJT;
      if (localObject1 == null) {
        break label2248;
      }
      localObject2 = this.rJR;
      if (localObject2 == null) {
        d.g.b.k.aVY("mediaViewContainer");
      }
      ((ViewGroup)localObject2).removeAllViews();
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).cGA();
      if (localObject1 != null) {
        break label2225;
      }
      localObject1 = this.rJR;
      if (localObject1 == null) {
        d.g.b.k.aVY("mediaViewContainer");
      }
      ((ViewGroup)localObject1).setVisibility(8);
      label1903:
      localObject1 = this.rKa;
      if (localObject1 == null) {
        d.g.b.k.aVY("postDataManager");
      }
      if ((((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sij == null) || (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).shV == null)) {
        break label2255;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.sid;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.cGx();
      Object localObject5 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sij;
      if (localObject5 == null) {
        d.g.b.k.fOy();
      }
      ((Bundle)localObject2).putByteArray((String)localObject3, ((FinderObjectDesc)localObject5).toByteArray());
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.sid;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.cGw();
      localObject5 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).shV;
      if (localObject5 == null) {
        d.g.b.k.fOy();
      }
      ((Bundle)localObject2).putByteArray((String)localObject3, ((amq)localObject5).toByteArray());
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.sid;
      ((Bundle)localObject2).putBoolean(com.tencent.mm.plugin.finder.widget.post.a.cGy(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).kxi);
      localObject1 = this.rJT;
      if (localObject1 != null)
      {
        localObject2 = this.rKa;
        if (localObject2 == null) {
          d.g.b.k.aVY("postDataManager");
        }
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).ab(((com.tencent.mm.plugin.finder.widget.post.c)localObject2).rOl);
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).refresh();
      }
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new p(this));
      cCe();
      AppMethodBeat.o(167530);
      return;
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
      for (;;)
      {
        this.rJT = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.d((Context)this, (byte)0));
        break label1845;
        label2125:
        if (((Integer)localObject1).intValue() != 7) {
          break;
        }
      }
      label2137:
      if (((Integer)localObject1).intValue() != 4) {
        break label1837;
      }
      this.rJT = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.g((Context)this));
      break label1845;
      label2166:
      if (((Integer)localObject1).intValue() != 8) {
        break label1841;
      }
      this.rJT = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.e((Context)this));
      break label1845;
      label2196:
      if (((Integer)localObject1).intValue() != 1) {
        break label1845;
      }
      this.rJT = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.f((Context)this));
      break label1845;
      label2225:
      localObject2 = this.rJR;
      if (localObject2 == null) {
        d.g.b.k.aVY("mediaViewContainer");
      }
      ((ViewGroup)localObject2).addView((View)localObject1);
      break label1903;
      label2248:
      finish();
      break label1903;
      label2255:
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sie;
      if (localObject2 == null)
      {
        label2264:
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sie;
        if (localObject2 != null) {
          break label2429;
        }
        label2273:
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sie;
        if (localObject2 != null) {
          break label2441;
        }
      }
      label2429:
      while (((Integer)localObject2).intValue() != 4)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sie;
        if ((localObject2 == null) || (((Integer)localObject2).intValue() != 8)) {
          break;
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putStringArrayList("MEDIA_FILE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sgY);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putIntegerArrayList("MEDIA_TYPE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sii);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sig);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putStringArrayList("MEDIA_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sih);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putParcelable("vlog_crop_rect", (Parcelable)((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sik);
        break;
        if (((Integer)localObject2).intValue() != 2) {
          break label2264;
        }
        for (;;)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl;
          localObject3 = com.tencent.mm.plugin.finder.widget.post.d.siu;
          ((Bundle)localObject2).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.cGC(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sgY);
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl;
          localObject3 = com.tencent.mm.plugin.finder.widget.post.d.siu;
          ((Bundle)localObject2).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.cGD(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sih);
          break;
          if (((Integer)localObject2).intValue() != 7) {
            break label2273;
          }
        }
      }
      label2441:
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putStringArrayList("video_file_list", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sgY);
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sif != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putByteArray("video_composition", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sif);
      }
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sig);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putStringArrayList("VIDEO_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sih);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putString("video_before_cut_path", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.getStringExtra("select_video_path"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putString("VIDEO_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.getStringExtra("VIDEO_COVER_URL"));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(167539);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject3;
    if (paramInt1 == this.rKf)
    {
      if (paramIntent != null)
      {
        localObject1 = this.rJU;
        if (localObject1 == null) {
          d.g.b.k.aVY("locationWidget");
        }
        d.g.b.k.h(paramIntent, "i");
        localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject3).putExtra("saveLocation", true);
        localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject3).putExtra("get_poi_name", bs.bG(paramIntent.getStringExtra("get_poi_name"), ""));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject3).putExtra("get_city", bs.bG(paramIntent.getStringExtra("get_city"), ""));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject3).putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject3).putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject3).putExtra("get_poi_address", bs.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
        localObject1 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject1 == null) {
          d.g.b.k.aVY("intent");
        }
        ((Intent)localObject1).putExtra("get_poi_classify_id", bs.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
        paramIntent = this.rJU;
        if (paramIntent == null) {
          d.g.b.k.aVY("locationWidget");
        }
        paramIntent.cCI();
        paramIntent = this.rJU;
        if (paramIntent == null) {
          d.g.b.k.aVY("locationWidget");
        }
        paramIntent = paramIntent.rOp;
        if (paramIntent != null)
        {
          if ((!bs.isNullOrNil(paramIntent.gPy)) || (!bs.isNullOrNil(paramIntent.exW)))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
            com.tencent.mm.plugin.finder.report.c.a(2, paramIntent);
          }
          for (;;)
          {
            paramIntent = d.y.KTp;
            AppMethodBeat.o(167539);
            return;
            localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
            com.tencent.mm.plugin.finder.report.c.a(3, paramIntent);
          }
        }
        AppMethodBeat.o(167539);
        return;
      }
      AppMethodBeat.o(167539);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.widget.post.g.siT;
    if (paramInt1 == com.tencent.mm.plugin.finder.widget.post.g.cGI())
    {
      if (paramIntent != null) {
        localObject1 = com.tencent.mm.plugin.finder.widget.post.g.siT;
      }
      for (paramIntent = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.g.cGJ());; paramIntent = null)
      {
        if (bs.isNullOrNil(paramIntent)) {
          break label1287;
        }
        localObject1 = this.rKa;
        if (localObject1 == null) {
          d.g.b.k.aVY("postDataManager");
        }
        if (paramIntent == null) {
          d.g.b.k.fOy();
        }
        d.g.b.k.h(paramIntent, "coverUrl");
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl.putString("VIDEO_COVER_URL", paramIntent);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).intent.putExtra("VIDEO_COVER_URL", paramIntent);
        paramIntent = this.rJT;
        if (paramIntent == null) {
          break;
        }
        localObject1 = this.rKa;
        if (localObject1 == null) {
          d.g.b.k.aVY("postDataManager");
        }
        paramIntent.ab(((com.tencent.mm.plugin.finder.widget.post.c)localObject1).rOl);
        paramIntent.refresh();
        paramIntent = d.y.KTp;
        AppMethodBeat.o(167539);
        return;
      }
      AppMethodBeat.o(167539);
      return;
    }
    int j;
    label927:
    Object localObject2;
    String str;
    if (paramInt1 == this.rKg)
    {
      showVKB();
      if (paramIntent != null)
      {
        j = paramIntent.getIntExtra("key_scene", 1);
        if (paramInt2 != -1) {
          break label1294;
        }
        paramInt1 = paramIntent.getIntExtra("key_source", 2);
        localObject1 = paramIntent.getByteArrayExtra("key_select_contact");
        if (localObject1 != null) {}
        for (;;)
        {
          try
          {
            paramIntent = new bqq();
            paramIntent.parseFrom((byte[])localObject1);
            localObject1 = d.y.KTp;
            if (paramIntent == null) {
              break label1283;
            }
            if (bs.isNullOrNil(paramIntent.nickname)) {
              break label1279;
            }
            localObject1 = this.rKk;
            if (localObject1 == null) {
              d.g.b.k.aVY("styleManager");
            }
            localObject1 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cFD();
            localObject3 = paramIntent.username;
            d.g.b.k.g(localObject3, "atContact.username");
            ((com.tencent.mm.plugin.finder.view.manager.a)localObject1).aY(paramInt1, (String)localObject3);
            localObject1 = this.rKk;
            if (localObject1 == null) {
              d.g.b.k.aVY("styleManager");
            }
            ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cFD().saI.put(paramIntent.nickname, paramIntent);
            localObject1 = this.rJP;
            if (localObject1 == null) {
              d.g.b.k.aVY("descTv");
            }
            paramInt2 = ((FinderPostEditText)localObject1).getSelectionEnd();
            localObject1 = this.rJP;
            if (localObject1 == null) {
              d.g.b.k.aVY("descTv");
            }
            localObject3 = ((FinderPostEditText)localObject1).getText().toString();
            paramInt1 = paramInt2;
            localObject1 = localObject3;
            if (j != 2) {
              break label1072;
            }
            localObject1 = this.rJP;
            if (localObject1 == null) {
              d.g.b.k.aVY("descTv");
            }
            j = ((FinderPostEditText)localObject1).getSelectionEnd();
            paramInt1 = paramInt2;
            localObject1 = localObject3;
            if (j <= 0) {
              break label1072;
            }
            paramInt2 = j - 1;
            paramInt1 = i;
            if ((paramInt2 < 0) || (paramInt1 == 0)) {
              break;
            }
            localObject1 = this.rJP;
            if (localObject1 == null) {
              d.g.b.k.aVY("descTv");
            }
            if (((FinderPostEditText)localObject1).getText().toString().charAt(paramInt2) != '@') {
              break label927;
            }
            paramInt2 -= 1;
            continue;
          }
          catch (Exception localException)
          {
            paramIntent = null;
            ac.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
            continue;
          }
          paramIntent = null;
          continue;
          paramInt1 = 0;
        }
        paramInt2 += 1;
        paramInt1 = paramInt2;
        if (paramInt2 > ((String)localObject3).length()) {
          paramInt1 = ((String)localObject3).length();
        }
        localObject2 = new StringBuilder();
        if (localObject3 == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        str = ((String)localObject3).substring(0, paramInt1);
        d.g.b.k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject2).append(str);
        paramInt2 = ((String)localObject3).length();
        if (localObject3 == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject3 = ((String)localObject3).substring(j, paramInt2);
        d.g.b.k.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = (String)localObject3;
        label1072:
        if (paramInt1 <= ((String)localObject2).length()) {
          break label1614;
        }
        paramInt1 = ((String)localObject2).length();
      }
    }
    label1283:
    label1287:
    label1294:
    label1614:
    for (;;)
    {
      localObject3 = new StringBuilder();
      if (localObject2 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167539);
        throw paramIntent;
      }
      str = ((String)localObject2).substring(0, paramInt1);
      d.g.b.k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject3 = ((StringBuilder)localObject3).append(str).append('@').append(paramIntent.nickname).append(' ');
      paramInt2 = ((String)localObject2).length();
      if (localObject2 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167539);
        throw paramIntent;
      }
      localObject2 = ((String)localObject2).substring(paramInt1, paramInt2);
      d.g.b.k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = (String)localObject2;
      paramInt2 = paramIntent.nickname.length();
      paramIntent = this.rJP;
      if (paramIntent == null) {
        d.g.b.k.aVY("descTv");
      }
      paramIntent.setText((CharSequence)localObject2);
      paramIntent = this.rJP;
      if (paramIntent == null) {
        d.g.b.k.aVY("descTv");
      }
      paramIntent.setSelection(paramInt2 + paramInt1 + 2);
      label1279:
      paramIntent = d.y.KTp;
      do
      {
        do
        {
          paramIntent = d.y.KTp;
          AppMethodBeat.o(167539);
          return;
          paramIntent = this.rKk;
          if (paramIntent == null) {
            d.g.b.k.aVY("styleManager");
          }
          com.tencent.mm.plugin.finder.view.manager.a.a(paramIntent.cFD());
        } while (j != 2);
        paramIntent = this.rJP;
        if (paramIntent == null) {
          d.g.b.k.aVY("descTv");
        }
        paramIntent = paramIntent.getText().toString();
        localObject2 = this.rJP;
        if (localObject2 == null) {
          d.g.b.k.aVY("descTv");
        }
        i = ((FinderPostEditText)localObject2).getSelectionEnd();
      } while (i <= 0);
      paramInt2 = i - 1;
      paramInt1 = 1;
      while ((paramInt2 >= 0) && (paramInt1 != 0))
      {
        localObject2 = this.rJP;
        if (localObject2 == null) {
          d.g.b.k.aVY("descTv");
        }
        if (((FinderPostEditText)localObject2).getText().toString().charAt(paramInt2) == '@') {
          paramInt2 -= 1;
        } else {
          paramInt1 = 0;
        }
      }
      paramInt1 = paramInt2 + 1;
      if (paramInt1 > paramIntent.length()) {
        paramInt1 = paramIntent.length();
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        if (paramIntent == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject3 = paramIntent.substring(0, paramInt1);
        d.g.b.k.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        paramInt2 = paramIntent.length();
        if (paramIntent == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        paramIntent = paramIntent.substring(i, paramInt2);
        d.g.b.k.g(paramIntent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramIntent = paramIntent;
        localObject2 = this.rJP;
        if (localObject2 == null) {
          d.g.b.k.aVY("descTv");
        }
        ((FinderPostEditText)localObject2).setText((CharSequence)paramIntent);
        paramIntent = this.rJP;
        if (paramIntent == null) {
          d.g.b.k.aVY("descTv");
        }
        paramIntent.setSelection(paramInt1);
        break;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167533);
    com.tencent.mm.plugin.finder.upload.postui.a locala = this.rJV;
    if (locala == null) {
      d.g.b.k.aVY("extendReadingWidget");
    }
    if (locala.rOk.saS) {
      locala.rOk.cFs();
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        cCf();
      }
      AppMethodBeat.o(167533);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167528);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    d.g.b.k.g(paramBundle, "intent");
    this.rKa = new com.tencent.mm.plugin.finder.widget.post.c(paramBundle);
    paramBundle = u.axE();
    d.g.b.k.g(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    this.rJO = paramBundle;
    if (bs.isNullOrNil(this.rJO)) {
      finish();
    }
    paramBundle = com.tencent.mm.plugin.finder.api.b.qWt;
    this.contact = com.tencent.mm.plugin.finder.api.b.a.adh(this.rJO);
    initView();
    if (Ib())
    {
      paramBundle = com.tencent.mm.ui.component.a.IrY;
      ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class)).bTx();
    }
    AppMethodBeat.o(167528);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167542);
    super.onDestroy();
    Object localObject = this.rKk;
    if (localObject == null) {
      d.g.b.k.aVY("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.c)localObject).sbo;
    if (localObject == null) {
      d.g.b.k.aVY("topicSuggestManager");
    }
    ((com.tencent.mm.plugin.finder.view.manager.d)localObject).sbs = null;
    ((com.tencent.mm.plugin.finder.view.manager.d)localObject).sbt = null;
    com.tencent.mm.kernel.g.agi().b(3875, (com.tencent.mm.ak.g)localObject);
    AppMethodBeat.o(167542);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(203293);
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 1))
    {
      int i;
      Object localObject;
      String str;
      if (this.rJY)
      {
        paramKeyEvent = this.rJP;
        if (paramKeyEvent == null) {
          d.g.b.k.aVY("descTv");
        }
        paramInt = paramKeyEvent.getSelectionStart();
        paramKeyEvent = this.rJP;
        if (paramKeyEvent == null) {
          d.g.b.k.aVY("descTv");
        }
        paramKeyEvent = paramKeyEvent.getText();
        d.g.b.k.g(paramKeyEvent, "descTv.text");
        paramKeyEvent = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
        i = n.b((CharSequence)paramKeyEvent, '@');
        if ((i >= paramKeyEvent.length()) || (i < 0)) {}
        for (;;)
        {
          this.rJY = false;
          AppMethodBeat.o(203293);
          return true;
          if (paramKeyEvent == null)
          {
            paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(203293);
            throw paramKeyEvent;
          }
          paramKeyEvent = paramKeyEvent.substring(0, i);
          d.g.b.k.g(paramKeyEvent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject = this.rJP;
          if (localObject == null) {
            d.g.b.k.aVY("descTv");
          }
          localObject = ((FinderPostEditText)localObject).getText();
          d.g.b.k.g(localObject, "descTv.text");
          localObject = (CharSequence)localObject;
          str = ((CharSequence)localObject).subSequence(paramInt, ((CharSequence)localObject).length()).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramKeyEvent).append(str);
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramKeyEvent.setText((CharSequence)((StringBuilder)localObject).toString());
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramKeyEvent.setSelection(i);
        }
      }
      if (this.rJZ != null)
      {
        com.tencent.mm.plugin.finder.utils.b.a locala = this.rJZ;
        StringBuilder localStringBuilder;
        if (locala != null)
        {
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramInt = paramKeyEvent.getSelectionStart();
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.k.g(paramKeyEvent, "descTv.text");
          localObject = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.k.g(paramKeyEvent, "descTv.text");
          paramKeyEvent = (CharSequence)paramKeyEvent;
          str = paramKeyEvent.subSequence(paramInt, paramKeyEvent.length()).toString();
          localStringBuilder = new StringBuilder();
          i = n.a((CharSequence)str, ' ', 0, 6);
          paramKeyEvent = str;
          if (i < str.length())
          {
            if (i >= 0) {
              break label511;
            }
            paramKeyEvent = str;
          }
          for (;;)
          {
            if (locala.start > paramInt) {
              break label649;
            }
            paramInt = locala.start;
            if (localObject != null) {
              break;
            }
            paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(203293);
            throw paramKeyEvent;
            label511:
            if (str == null)
            {
              paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(203293);
              throw paramKeyEvent;
            }
            paramKeyEvent = str.substring(i + 1);
            d.g.b.k.g(paramKeyEvent, "(this as java.lang.String).substring(startIndex)");
          }
          localObject = ((String)localObject).substring(0, paramInt);
          d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localStringBuilder.append((String)localObject).append(paramKeyEvent);
          paramInt = locala.start;
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramKeyEvent.setText((CharSequence)localStringBuilder.toString());
          paramKeyEvent = this.rJP;
          if (paramKeyEvent == null) {
            d.g.b.k.aVY("descTv");
          }
          paramKeyEvent.setSelection(paramInt);
        }
        this.rJZ = null;
        AppMethodBeat.o(203293);
        return true;
        label649:
        i = n.b((CharSequence)localObject, '@');
        if ((i >= ((String)localObject).length()) || (i < 0)) {}
        for (;;)
        {
          localStringBuilder.append((String)localObject).append(paramKeyEvent);
          break;
          int j = n.b((CharSequence)localObject, ' ');
          if ((j <= i) || (j >= ((String)localObject).length()))
          {
            if (localObject == null)
            {
              paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(203293);
              throw paramKeyEvent;
            }
            localObject = ((String)localObject).substring(0, i);
            d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            paramInt = i;
          }
        }
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(203293);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167532);
    super.onResume();
    this.rKm = ap.dT((Context)getContext());
    com.tencent.mm.plugin.finder.upload.postui.a locala = this.rJV;
    if (locala == null) {
      d.g.b.k.aVY("extendReadingWidget");
    }
    locala.rOk.cFu();
    AppMethodBeat.o(167532);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167531);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.rKl))
    {
      com.tencent.mm.ui.tools.h localh = this.fxG;
      if (localh == null) {
        d.g.b.k.aVY("keyboardHeightProvider");
      }
      localh.start();
      this.rKl = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(167531);
  }
  
  public final void p(String paramString, List<boy> paramList)
  {
    AppMethodBeat.i(167536);
    Object localObject1 = (Collection)paramList;
    int i;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ac.i(this.TAG, "get lbsLife success");
      localObject1 = this.rJU;
      if (localObject1 == null) {
        d.g.b.k.aVY("locationWidget");
      }
      paramList = (boy)j.iO(paramList);
      if (this.rKa == null) {
        d.g.b.k.aVY("postDataManager");
      }
      d.g.b.k.h(paramList, "lbsLife");
      if (((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).isLoading)
      {
        if (bs.isNullOrNil(paramString))
        {
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOq.eKq();
          paramString = com.tencent.mm.plugin.finder.report.c.rxi;
          com.tencent.mm.plugin.finder.report.c.a(0, ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOp);
          AppMethodBeat.o(167536);
          return;
          i = 0;
        }
        else
        {
          Object localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.k.aVY("intent");
          }
          ((Intent)localObject2).putExtra("saveLocation", true);
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.k.aVY("intent");
          }
          ((Intent)localObject2).putExtra("get_poi_name", "");
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.k.aVY("intent");
          }
          ((Intent)localObject2).putExtra("get_city", bs.nullAsNil(paramString));
          localObject2 = com.tencent.mm.ui.component.a.IrY;
          com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject2 = FinderGlobalLocationVM.cFH();
          Object localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject3 == null) {
            d.g.b.k.aVY("intent");
          }
          ((Intent)localObject3).putExtra("get_lat", ((Number)((o)localObject2).second).floatValue());
          localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject3 == null) {
            d.g.b.k.aVY("intent");
          }
          ((Intent)localObject3).putExtra("get_lng", ((Number)((o)localObject2).first).floatValue());
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.k.aVY("intent");
          }
          ((Intent)localObject2).putExtra("get_poi_classify_type", paramList.ndI);
          paramList = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (paramList == null) {
            d.g.b.k.aVY("intent");
          }
          paramList.putExtra("get_poi_classify_id", "");
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).cCI();
          paramList = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOp;
          if (paramList != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOl;
            if (localObject2 == null) {
              d.g.b.k.aVY("postData");
            }
            localObject3 = com.tencent.mm.plugin.finder.widget.post.a.sid;
            ((Bundle)localObject2).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.cGu(), paramList.toByteArray());
          }
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOq.setSuggestView(paramString);
          paramString = com.tencent.mm.plugin.finder.report.c.rxi;
          com.tencent.mm.plugin.finder.report.c.a(1, ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).rOp);
        }
      }
      else
      {
        AppMethodBeat.o(167536);
        return;
      }
    }
    paramString = this.rJU;
    if (paramString == null) {
      d.g.b.k.aVY("locationWidget");
    }
    paramString.isLoading = false;
    paramString.rOq.eKq();
    AppMethodBeat.o(167536);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(167535);
    Object localObject1 = this.rKh;
    if (localObject1 == null) {
      d.g.b.k.aVY("footer");
    }
    if (paramInt > 0) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      if ((paramInt > 0) && (paramInt != (int)((FinderPostFooter)localObject1).rWr))
      {
        com.tencent.mm.sdk.platformtools.y.aC(((FinderPostFooter)localObject1).getContext(), paramInt);
        ((FinderPostFooter)localObject1).rWr = paramInt;
        localObject2 = new LinearLayout.LayoutParams(-1, (int)((FinderPostFooter)localObject1).rWr);
        SmileyPanel localSmileyPanel = ((FinderPostFooter)localObject1).gBD;
        if (localSmileyPanel == null) {
          d.g.b.k.aVY("smileyPanel");
        }
        localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((FinderPostFooter)localObject1).rWl;
      if (localObject2 == null) {
        d.g.b.k.aVY("smileyBtn");
      }
      localObject2 = ((ImageView)localObject2).getTag();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(167535);
      throw ((Throwable)localObject1);
    }
    paramBoolean = ((Boolean)localObject2).booleanValue();
    if ((i == 0) && (!paramBoolean))
    {
      localObject2 = ((FinderPostFooter)localObject1).ifK;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean)) {
        ((FinderPostFooter)localObject1).N(false, false);
      }
      localObject1 = this.rKh;
      if (localObject1 == null) {
        d.g.b.k.aVY("footer");
      }
      ((FinderPostFooter)localObject1).post((Runnable)new o(this));
      AppMethodBeat.o(167535);
      return;
      localObject2 = ((FinderPostFooter)localObject1).ifK;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderPostUI paramFinderPostUI, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(167507);
      FinderPostUI.p(this.rKo).scrollBy(0, this.rKp - this.rKq);
      AppMethodBeat.o(167507);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderPostUI$checkPostData$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(167508);
      FinderPostUI.h(this.rKo);
      AppMethodBeat.o(167508);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class c
    implements View.OnLayoutChangeListener
  {
    c(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167509);
      ac.i(FinderPostUI.b(this.rKo), "oldBottom " + paramInt8 + ", bottom " + paramInt4);
      if (paramInt8 != paramInt4) {
        FinderPostUI.v(this.rKo);
      }
      AppMethodBeat.o(167509);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167510);
      paramDialogInterface = Parcel.obtain();
      FinderPostUI.a(this.rKo, FinderPostUI.a(this.rKo).getText().toString());
      this.rKo.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      Object localObject = FinderPostUI.z(this.rKo).sie;
      if (localObject == null)
      {
        localObject = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVk, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
      for (;;)
      {
        FinderPostUI.A(this.rKo);
        paramDialogInterface = com.tencent.mm.plugin.finder.report.c.rxi;
        com.tencent.mm.plugin.finder.report.c.af(4, true);
        AppMethodBeat.o(167510);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVl, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167511);
      paramDialogInterface = FinderPostUI.z(this.rKo).sie;
      if (paramDialogInterface == null)
      {
        paramDialogInterface = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.agA().set(ah.a.GVk, "");
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.c.rxi;
        com.tencent.mm.plugin.finder.report.c.af(4, false);
        FinderPostUI.A(this.rKo);
        AppMethodBeat.o(167511);
        return;
        if (paramDialogInterface.intValue() != 1) {
          break;
        }
        paramDialogInterface = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.agA().set(ah.a.GVl, "");
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cur", "", "last", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.m<Integer, Integer, d.y>
  {
    f(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class g
    implements View.OnTouchListener
  {
    g(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167513);
      if (d.g.b.k.g(paramView, FinderPostUI.a(this.rKo)))
      {
        d.g.b.k.g(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(167513);
        return false;
        FinderPostUI.p(this.rKo).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderPostUI.p(this.rKo).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"})
  static final class h
    implements View.OnKeyListener
  {
    h(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(203287);
      if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
      {
        paramView = this.rKo;
        if (FinderPostUI.m(this.rKo) != ' ') {
          break label83;
        }
      }
      label83:
      for (boolean bool = true;; bool = false)
      {
        FinderPostUI.b(paramView, bool);
        if (!FinderPostUI.q(this.rKo)) {
          FinderPostUI.a(this.rKo, FinderPostUI.r(this.rKo));
        }
        AppMethodBeat.o(203287);
        return false;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class i
    implements TextWatcher
  {
    i(int paramInt) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167514);
      int i = com.tencent.mm.ui.tools.f.cM(i * 2, String.valueOf(paramEditable)) / 2;
      i = i - i;
      FinderPostUI.a(this.rKo, true);
      label140:
      Object localObject;
      if (i / i >= 0.95D)
      {
        FinderPostUI.j(this.rKo).setText((CharSequence)(i + '/' + i));
        if (i > i)
        {
          FinderPostUI.j(this.rKo).setTextColor(this.rKo.getResources().getColor(2131099804));
          FinderPostUI.a(this.rKo, false);
          FinderPostUI.j(this.rKo).setVisibility(0);
          FinderPostUI.k(this.rKo);
          localObject = FinderPostUI.d(this.rKo);
          String str = String.valueOf(paramEditable);
          if (paramEditable == null) {
            d.g.b.k.fOy();
          }
          ((com.tencent.mm.plugin.finder.view.manager.c)localObject).a(str, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (com.tencent.mm.plugin.finder.storage.b.czo())
          {
            i = FinderPostUI.d(this.rKo).cFC().sbr.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.b.rCU;
            if (i <= com.tencent.mm.plugin.finder.storage.b.czl()) {
              break label349;
            }
            FinderPostUI.l(this.rKo).lX(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.czp()) {
          break label446;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czr() == 1000) {
          break label363;
        }
        i = FinderPostUI.d(this.rKo).cFD().saJ.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (i < com.tencent.mm.plugin.finder.storage.b.czr()) {
          break label363;
        }
        FinderPostUI.l(this.rKo).lY(false);
        AppMethodBeat.o(167514);
        return;
        FinderPostUI.j(this.rKo).setTextColor(this.rKo.getResources().getColor(2131099734));
        break;
        FinderPostUI.j(this.rKo).setText((CharSequence)"");
        FinderPostUI.j(this.rKo).setVisibility(8);
        break label140;
        label349:
        FinderPostUI.l(this.rKo).lX(true);
      }
      label363:
      FinderPostUI.l(this.rKo).lY(true);
      if ((FinderPostUI.m(this.rKo) == '@') && (FinderPostUI.n(this.rKo) == null))
      {
        ac.i(FinderPostUI.b(this.rKo), "at auto goto");
        paramEditable = new Intent();
        paramEditable.putExtra("key_scene", 2);
        localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.c((MMActivity)this.rKo, paramEditable, FinderPostUI.o(this.rKo));
      }
      label446:
      AppMethodBeat.o(167514);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class j
    implements View.OnTouchListener
  {
    j(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167515);
      d.g.b.k.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = new Rect();
        FinderPostUI.a(this.rKo).getGlobalVisibleRect(paramView);
        ac.i(FinderPostUI.b(this.rKo), "rawY:" + paramMotionEvent.getRawY() + ", rect:" + paramView.toShortString());
        if ((paramMotionEvent.getRawY() < paramView.top) || (paramMotionEvent.getRawY() > paramView.bottom)) {
          FinderPostUI.c(this.rKo).setVisibility(8);
        }
      }
      AppMethodBeat.o(167515);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class k
    implements View.OnLayoutChangeListener
  {
    k(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(203289);
      paramView.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203288);
          ac.i(FinderPostUI.b(this.rKs.rKo), "descTv OnLayoutChangeListener");
          Object localObject1 = FinderPostUI.d(this.rKs.rKo).cFC();
          int i = FinderPostUI.e(this.rKs.rKo);
          if (((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rKj.getVisibility() == 0)
          {
            int j = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rJP.getSelectionStart();
            Object localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rJP.getLayout();
            int m = ((Layout)localObject2).getLineForOffset(j);
            int k = ((Layout)localObject2).getLineBaseline(m);
            m = ((Layout)localObject2).getLineAscent(m);
            int[] arrayOfInt = new int[2];
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rJP.getLocationOnScreen(arrayOfInt);
            Point localPoint = new Point();
            localPoint.x = ((int)((Layout)localObject2).getPrimaryHorizontal(j));
            localPoint.y = (k + m + arrayOfInt[1] - ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rJP.getScrollY());
            ac.i(com.tencent.mm.plugin.finder.view.manager.d.TAG, "onSelectionChangedListener point " + localPoint + ", actionbarHeight " + i);
            localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rKj.getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
              AppMethodBeat.o(203288);
              throw ((Throwable)localObject1);
            }
            localObject2 = (FrameLayout.LayoutParams)localObject2;
            ((FrameLayout.LayoutParams)localObject2).topMargin = (localPoint.y - i);
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).rKj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          AppMethodBeat.o(203288);
        }
      });
      AppMethodBeat.o(203289);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203290);
      FinderPostUI.f(this.rKo);
      AppMethodBeat.o(203290);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203291);
      if (FinderPostUI.g(this.rKo) == 0) {
        FinderPostUI.h(this.rKo);
      }
      AppMethodBeat.o(203291);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "open", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.b<Boolean, d.y>
  {
    n(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(FinderPostUI paramFinderPostUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167524);
      ac.i(FinderPostUI.b(this.rKo), "footer.height " + FinderPostUI.t(this.rKo).getHeight() + ", footer.oldHeight " + FinderPostUI.u(this.rKo));
      if (FinderPostUI.t(this.rKo).getVisibility() == 0)
      {
        if ((FinderPostUI.a(this.rKo).hasFocus()) && (FinderPostUI.t(this.rKo).getHeight() != FinderPostUI.u(this.rKo)))
        {
          FinderPostUI.a(this.rKo, FinderPostUI.t(this.rKo).getHeight());
          FinderPostUI.v(this.rKo);
        }
        FinderPostUI.w(this.rKo).addOnLayoutChangeListener(FinderPostUI.x(this.rKo));
        AppMethodBeat.o(167524);
        return;
      }
      if ((FinderPostUI.t(this.rKo).getVisibility() == 8) || (FinderPostUI.t(this.rKo).getHeight() == 0))
      {
        FinderPostUI.a(this.rKo, 0);
        FinderPostUI.p(this.rKo).scrollTo(0, 0);
        Object localObject = FinderPostUI.y(this.rKo).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(167524);
          throw ((Throwable)localObject);
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).height = 0;
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        FinderPostUI.y(this.rKo).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderPostUI.y(this.rKo).requestLayout();
        FinderPostUI.w(this.rKo).removeOnLayoutChangeListener(FinderPostUI.x(this.rKo));
      }
      AppMethodBeat.o(167524);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    p(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */