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
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.c;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.d;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.e;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.pluginsdk.location.LocationView;
import com.tencent.mm.pluginsdk.location.LocationView.a;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.a.j;
import d.g.a.m;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(17)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "()V", "CHECK_POST_INTERVAL", "", "MAX_CHECK_POST_COUNT", "", "MENU_ID_POST", "REQUEST_CODE_PICK_LOCATION", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "actionBarHeight", "avatarIv", "Landroid/widget/ImageView;", "bottomSpace", "Landroid/view/View;", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "deleteAtStringByInter", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendReadingWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "footerContainer", "hasStartKeyBoardProvider", "", "isFromtOfAtOneEnd", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "nickTv", "Landroid/widget/TextView;", "oldFooterHeight", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "scrollView", "Landroid/widget/ScrollView;", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "textCountTv", "textOk", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "checkNeedScroll", "", "checkNextEnable", "checkPermission", "checkPostData", "deleteAtMemberFromEnd", "deleteAtMemberFromInter", "atStringInfo", "deleteInAtSomeoneInter", "exitAndSave", "getCharAtCursor", "", "getLayoutId", "initDescText", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetLbsLifes", "city", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onTopicClick", "onWindowFocusChanged", "hasFocus", "requestLocation", "restore", "routeBack", "routeForward", "localId", "saveDescData", "desc", "selectMedia", "plugin-finder_release"})
public final class FinderPostUI
  extends MMFinderUI
  implements FinderPostFooter.b, a.a, com.tencent.mm.ui.tools.g
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private com.tencent.mm.plugin.finder.api.g contact;
  private com.tencent.mm.ui.base.p fNb;
  private com.tencent.mm.ui.tools.h fQT;
  private ScrollView fQj;
  private ImageView fRd;
  private TextView jhg;
  private String sEO;
  private FinderPostEditText sEP;
  private TextView sEQ;
  private ViewGroup sER;
  private View sES;
  private com.tencent.mm.plugin.finder.widget.post.a sET;
  private com.tencent.mm.plugin.finder.upload.postui.b sEU;
  private com.tencent.mm.plugin.finder.upload.postui.a sEV;
  private com.tencent.mm.plugin.finder.upload.postui.c sEW;
  private boolean sEX;
  private boolean sEY;
  private com.tencent.mm.plugin.finder.utils.b.a sEZ;
  private View sEh;
  private com.tencent.mm.plugin.finder.widget.post.c sFa;
  private int sFb;
  private int sFc;
  private final int sFd;
  private final long sFe;
  private final int sFf;
  private final int sFg;
  private FinderPostFooter sFh;
  private View sFi;
  private FinderTopicSuggestView sFj;
  private com.tencent.mm.plugin.finder.view.manager.c sFk;
  private boolean sFl;
  private int sFm;
  private final View.OnLayoutChangeListener sFn;
  private final int sgy;
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    this.TAG = "Finder.FinderPostUI";
    this.sEO = "";
    this.sEX = true;
    this.sFd = 10;
    this.sFe = 500L;
    this.sgy = 10000;
    this.sFf = 20000;
    this.sFg = 20001;
    this.sFn = ((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(167543);
  }
  
  private final boolean JB()
  {
    AppMethodBeat.i(167529);
    if ((Build.VERSION.SDK_INT < 23) && ((d.g.b.p.i("MNC", Build.VERSION.CODENAME) ^ true)))
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
      ad.e(this.TAG, "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(167529);
      return true;
    }
    AppMethodBeat.o(167529);
    return false;
  }
  
  private final void cKd()
  {
    AppMethodBeat.i(167534);
    Object localObject = this.sEV;
    if (localObject == null) {
      d.g.b.p.bcb("extendReadingWidget");
    }
    if (((com.tencent.mm.plugin.finder.upload.postui.a)localObject).sKr.cNQ())
    {
      localObject = this.sFa;
      if (localObject == null) {
        d.g.b.p.bcb("postDataManager");
      }
      localObject = ((com.tencent.mm.plugin.finder.widget.post.c)localObject).teA;
      if (localObject != null) {
        break label78;
      }
    }
    while (!this.sEX) {
      label78:
      do
      {
        enableOptionMenu(this.sgy, false);
        AppMethodBeat.o(167534);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = this.sEP;
        if (localObject == null) {
          d.g.b.p.bcb("descTv");
        }
      } while (bt.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    localObject = this.sET;
    if (localObject != null)
    {
      if ((localObject instanceof com.tencent.mm.plugin.finder.widget.post.f))
      {
        localObject = this.sEP;
        if (localObject == null) {
          d.g.b.p.bcb("descTv");
        }
        localObject = ((FinderPostEditText)localObject).getText().toString();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(167534);
          throw ((Throwable)localObject);
        }
        if (bt.isNullOrNil(n.trim((CharSequence)localObject).toString()))
        {
          enableOptionMenu(this.sgy, false);
          AppMethodBeat.o(167534);
          return;
        }
      }
      enableOptionMenu(this.sgy, true);
      AppMethodBeat.o(167534);
      return;
    }
    enableOptionMenu(this.sgy, false);
    AppMethodBeat.o(167534);
  }
  
  private final void cKe()
  {
    AppMethodBeat.i(167538);
    Object localObject = com.tencent.mm.plugin.finder.report.f.soC;
    localObject = this.sFk;
    if (localObject == null) {
      d.g.b.p.bcb("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.c)localObject).cNY().sXY;
    com.tencent.mm.plugin.finder.view.manager.c localc = this.sFk;
    if (localc == null) {
      d.g.b.p.bcb("styleManager");
    }
    int i = localc.cNY().sYa;
    localc = this.sFk;
    if (localc == null) {
      d.g.b.p.bcb("styleManager");
    }
    com.tencent.mm.plugin.finder.report.f.c((ArrayList)localObject, i, localc.cNY().sYb);
    localObject = this.sFa;
    if (localObject == null) {
      d.g.b.p.bcb("postDataManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.widget.post.c)localObject).teA;
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.sFa;
      if (localObject == null) {
        d.g.b.p.bcb("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject).ter == null)
      {
        localObject = this.sFa;
        if (localObject == null) {
          d.g.b.p.bcb("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject).teH == null) {
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
        localObject = this.sEP;
        if (localObject == null) {
          d.g.b.p.bcb("descTv");
        }
      } while (bt.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    com.tencent.mm.ui.base.h.a((Context)this, 2131759390, 0, 2131759392, 2131759391, true, (DialogInterface.OnClickListener)new d(this), (DialogInterface.OnClickListener)new e(this), 2131099903);
    AppMethodBeat.o(167538);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204103);
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
    AppMethodBeat.o(204103);
    return localView1;
  }
  
  public final void cKf()
  {
    AppMethodBeat.i(204096);
    Object localObject1 = this.sEP;
    if (localObject1 == null) {
      d.g.b.p.bcb("descTv");
    }
    int i = ((FinderPostEditText)localObject1).getSelectionStart();
    localObject1 = this.sEP;
    if (localObject1 == null) {
      d.g.b.p.bcb("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.finder.utils.o.sMi;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.utils.o.cLx());
    localObject3 = com.tencent.mm.plugin.finder.utils.o.sMi;
    localObject2 = com.tencent.mm.plugin.finder.utils.o.cLx();
    if (i == 0) {
      localObject1 = (String)localObject2 + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = this.sEP;
      if (localObject2 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
      localObject1 = this.sEP;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject1).requestFocus();
      localObject1 = this.sEP;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject1).setSelection(i + 1);
      localObject1 = this.sFi;
      if (localObject1 == null) {
        d.g.b.p.bcb("footerContainer");
      }
      if (((View)localObject1).getVisibility() == 8) {
        showVKB();
      }
      AppMethodBeat.o(204096);
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
          AppMethodBeat.o(204096);
          throw ((Throwable)localObject1);
        }
        String str = ((String)localObject1).substring(0, i);
        d.g.b.p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject3).append(str).append((String)localObject2);
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204096);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).substring(i, j);
        d.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
    d.g.b.p.g(localObject1, "findViewById(R.id.post_media_widget_container)");
    this.sER = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131303359);
    d.g.b.p.g(localObject1, "findViewById(R.id.post_avatar)");
    this.fRd = ((ImageView)localObject1);
    localObject1 = findViewById(2131303369);
    d.g.b.p.g(localObject1, "findViewById(R.id.post_nickname)");
    this.jhg = ((TextView)localObject1);
    localObject1 = findViewById(2131303361);
    d.g.b.p.g(localObject1, "findViewById(R.id.post_desc_edt)");
    this.sEP = ((FinderPostEditText)localObject1);
    localObject1 = findViewById(2131304376);
    d.g.b.p.g(localObject1, "findViewById(R.id.scroll_view)");
    this.fQj = ((ScrollView)localObject1);
    localObject1 = findViewById(2131297467);
    d.g.b.p.g(localObject1, "findViewById(R.id.bottom_space)");
    this.sES = ((View)localObject1);
    localObject1 = findViewById(2131299309);
    d.g.b.p.g(localObject1, "findViewById(R.id.edt_container)");
    this.sEh = ((View)localObject1);
    localObject1 = findViewById(2131306036);
    d.g.b.p.g(localObject1, "findViewById(R.id.topic_suggest_view)");
    this.sFj = ((FinderTopicSuggestView)localObject1);
    localObject1 = this.sFj;
    if (localObject1 == null) {
      d.g.b.p.bcb("topicSuggestView");
    }
    Object localObject2 = this.sEP;
    if (localObject2 == null) {
      d.g.b.p.bcb("descTv");
    }
    this.sFk = new com.tencent.mm.plugin.finder.view.manager.c((FinderTopicSuggestView)localObject1, (FinderPostEditText)localObject2, (MMActivity)this);
    localObject1 = (MMActivity)this;
    localObject2 = findViewById(2131307297);
    d.g.b.p.g(localObject2, "findViewById(R.id.choose_original_view)");
    this.sEW = new com.tencent.mm.plugin.finder.upload.postui.c((MMActivity)localObject1, (FinderChooseOriginalView)localObject2);
    localObject1 = findViewById(2131300198);
    d.g.b.p.g(localObject1, "findViewById(R.id.footer_container)");
    this.sFi = ((View)localObject1);
    localObject1 = this.sFi;
    if (localObject1 == null) {
      d.g.b.p.bcb("footerContainer");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = findViewById(2131299983);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_comment_footer)");
    this.sFh = ((FinderPostFooter)localObject1);
    Object localObject3 = findViewById(2131308179);
    localObject1 = findViewById(2131308180);
    localObject2 = this.sFh;
    if (localObject2 == null) {
      d.g.b.p.bcb("footer");
    }
    Object localObject4 = (MMActivity)this;
    Object localObject6 = this.sFi;
    if (localObject6 == null) {
      d.g.b.p.bcb("footerContainer");
    }
    Object localObject7 = this.sEP;
    if (localObject7 == null) {
      d.g.b.p.bcb("descTv");
    }
    localObject7 = (MMEditText)localObject7;
    final int i = this.sFg;
    FinderPostFooter.b localb = (FinderPostFooter.b)this;
    d.g.b.p.g(localObject3, "atBtn");
    d.g.b.p.g(localObject1, "topicBtn");
    d.g.b.p.h(localObject4, "activity");
    d.g.b.p.h(localObject6, "container");
    d.g.b.p.h(localObject7, "editText");
    d.g.b.p.h(localb, "iTopicCallback");
    d.g.b.p.h(localObject3, "atBtn");
    d.g.b.p.h(localObject1, "topicBtn");
    ((FinderPostFooter)localObject2).activity = ((MMActivity)localObject4);
    ((FinderPostFooter)localObject2).ize = ((View)localObject6);
    ((FinderPostFooter)localObject2).sSW = ((MMEditText)localObject7);
    ((FinderPostFooter)localObject2).kqK = i;
    ((FinderPostFooter)localObject2).sVi = localb;
    ((FinderPostFooter)localObject2).sVh = ((View)localObject3);
    ((FinderPostFooter)localObject2).sVg = ((View)localObject1);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new FinderPostFooter.c(localb));
    ((View)localObject3).setOnClickListener((View.OnClickListener)new FinderPostFooter.d((MMActivity)localObject4, i));
    localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGf())
    {
      ((View)localObject1).setVisibility(0);
      ((FinderPostFooter)localObject2).setOnClickListener((View.OnClickListener)FinderPostFooter.e.sVm);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cGf()) {
        break label1528;
      }
      findViewById(2131306037).setOnTouchListener((View.OnTouchListener)new j(this));
      localObject1 = this.fQj;
      if (localObject1 == null) {
        d.g.b.p.bcb("scrollView");
      }
      ((ScrollView)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)new k(this));
      label664:
      localObject1 = this.sFh;
      if (localObject1 == null) {
        d.g.b.p.bcb("footer");
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      ((FinderPostFooter)localObject1).mq(com.tencent.mm.plugin.finder.storage.b.cGg());
      this.fQT = new com.tencent.mm.ui.tools.h((Activity)this);
      localObject1 = this.fQT;
      if (localObject1 == null) {
        d.g.b.p.bcb("keyboardHeightProvider");
      }
      ((com.tencent.mm.ui.tools.h)localObject1).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)this);
      localObject1 = findViewById(2131305750);
      d.g.b.p.g(localObject1, "findViewById(R.id.textcount_hint)");
      this.sEQ = ((TextView)localObject1);
      localObject1 = this.sEQ;
      if (localObject1 == null) {
        d.g.b.p.bcb("textCountTv");
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = this.sEQ;
      if (localObject1 == null) {
        d.g.b.p.bcb("textCountTv");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (MMActivity)this;
      localObject2 = findViewById(2131303366);
      d.g.b.p.g(localObject2, "findViewById(R.id.post_location_view)");
      localObject2 = (LocationView)localObject2;
      localObject3 = findViewById(2131303337);
      d.g.b.p.g(localObject3, "findViewById(R.id.poi_tip_layout)");
      localObject4 = findViewById(2131303338);
      d.g.b.p.g(localObject4, "findViewById(R.id.poi_tip_tv)");
      this.sEU = new com.tencent.mm.plugin.finder.upload.postui.b((MMActivity)localObject1, (LocationView)localObject2, (View)localObject3, (TextView)localObject4, this.sFf);
      localObject1 = this.contact;
      if (localObject1 != null)
      {
        localObject2 = i.sja;
        localObject2 = i.cCC();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject1).field_avatarUrl);
        localObject4 = this.fRd;
        if (localObject4 == null) {
          d.g.b.p.bcb("avatarIv");
        }
        localObject6 = i.sja;
        ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject4, i.a(i.a.sjd));
        localObject2 = this.jhg;
        if (localObject2 == null) {
          d.g.b.p.bcb("nickTv");
        }
        ((TextView)localObject2).setText((CharSequence)k.c((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject1).VC()));
      }
      if (getIntent().getBooleanExtra("hideDescEdit", false))
      {
        localObject1 = this.sEP;
        if (localObject1 == null) {
          d.g.b.p.bcb("descTv");
        }
        ((FinderPostEditText)localObject1).setVisibility(8);
      }
      setBackBtn((MenuItem.OnMenuItemClickListener)new l(this));
      addTextOptionMenu(this.sgy, getString(2131759300), (MenuItem.OnMenuItemClickListener)new m(this), null, s.b.Jcd);
      enableOptionMenu(this.sgy, false);
      localObject1 = this.sFa;
      if (localObject1 == null) {
        d.g.b.p.bcb("postDataManager");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).teA;
      if (localObject1 != null) {
        break label1572;
      }
      label1097:
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    }
    for (i = ((Number)com.tencent.mm.plugin.finder.storage.b.cGV().value()).intValue();; i = ((Number)com.tencent.mm.plugin.finder.storage.b.cGW().value()).intValue())
    {
      localObject1 = (TextWatcher)new i(this, i);
      localObject2 = this.sEP;
      if (localObject2 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject2).addTextChangedListener((TextWatcher)localObject1);
      localObject1 = this.sEP;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject1).setOnSelectionChangedListener((m)new f(this));
      localObject1 = this.sEP;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject1).setOnTouchListener((View.OnTouchListener)new g(this));
      localObject1 = this.sEP;
      if (localObject1 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject1).setOnKeyListener((View.OnKeyListener)new h(this));
      localObject1 = (MMActivity)this;
      localObject2 = findViewById(2131299633);
      d.g.b.p.g(localObject2, "findViewById(R.id.extend_reading_view)");
      this.sEV = new com.tencent.mm.plugin.finder.upload.postui.a((MMActivity)localObject1, (FinderExtendReadingView)localObject2, (d.g.a.b)new n(this));
      localObject1 = this.sFa;
      if (localObject1 == null) {
        d.g.b.p.bcb("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).teH != null)
      {
        localObject1 = this.sFa;
        if (localObject1 == null) {
          d.g.b.p.bcb("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).ter != null)
        {
          localObject1 = findViewById(2131299633);
          d.g.b.p.g(localObject1, "findViewById<View>(R.id.extend_reading_view)");
          ((View)localObject1).setVisibility(8);
          localObject1 = findViewById(2131303366);
          d.g.b.p.g(localObject1, "findViewById<View>(R.id.post_location_view)");
          ((View)localObject1).setVisibility(8);
        }
      }
      localObject1 = getIntent().getStringExtra("saveDesc");
      localObject3 = getIntent().getParcelableArrayListExtra("saveDescAt");
      if (localObject3 == null) {
        break label1600;
      }
      localObject2 = this.sFk;
      if (localObject2 == null) {
        d.g.b.p.bcb("styleManager");
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject2).cNY();
      d.g.b.p.h(localObject3, "atContactParcelList");
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (LocalFinderAtContactParcel)((Iterator)localObject3).next();
        try
        {
          localObject6 = com.tencent.mm.plugin.finder.utils.b.sKO;
          d.g.b.p.g(localObject4, "atContactParcel");
          localObject4 = com.tencent.mm.plugin.finder.utils.b.a((LocalFinderAtContactParcel)localObject4);
          ((com.tencent.mm.plugin.finder.view.manager.a)localObject2).sXX.put(((bvd)localObject4).nickname, localObject4);
        }
        catch (Exception localException)
        {
          ad.e(com.tencent.mm.plugin.finder.view.manager.a.TAG, "restoreAtContactMap transformToLocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
        }
      }
      ((View)localObject1).setVisibility(8);
      break;
      label1528:
      localObject1 = this.sFh;
      if (localObject1 == null) {
        d.g.b.p.bcb("footer");
      }
      ((FinderPostFooter)localObject1).mp(false);
      localObject1 = this.sFj;
      if (localObject1 == null) {
        d.g.b.p.bcb("topicSuggestView");
      }
      ((FinderTopicSuggestView)localObject1).setVisibility(8);
      break label664;
      label1572:
      if (((Integer)localObject1).intValue() != 1) {
        break label1097;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    }
    label1600:
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = this.sEP;
      if (localObject2 == null) {
        d.g.b.p.bcb("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.sEU;
    if (localObject1 == null) {
      d.g.b.p.bcb("locationWidget");
    }
    localObject2 = getIntent();
    d.g.b.p.g(localObject2, "intent");
    localObject3 = this.sFa;
    if (localObject3 == null) {
      d.g.b.p.bcb("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
    d.g.b.p.h(localObject2, "intent");
    d.g.b.p.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent = ((Intent)localObject2);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKs = ((Bundle)localObject3);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKz.setVisibility(8);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKy.setLocationName(((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).activity.getString(2131759251));
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKy.setOnClickLocationListener((LocationView.a)new com.tencent.mm.plugin.finder.upload.postui.b.a((com.tencent.mm.plugin.finder.upload.postui.b)localObject1));
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).cKW();
    localObject1 = this.sEV;
    if (localObject1 == null) {
      d.g.b.p.bcb("extendReadingWidget");
    }
    localObject2 = getIntent();
    d.g.b.p.g(localObject2, "intent");
    localObject3 = this.sFa;
    if (localObject3 == null) {
      d.g.b.p.bcb("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
    d.g.b.p.h(localObject2, "intent");
    d.g.b.p.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).intent = ((Intent)localObject2);
    ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).sKs = ((Bundle)localObject3);
    localObject3 = ((Intent)localObject2).getStringExtra("saveExtendReadingLink");
    localObject2 = ((Intent)localObject2).getStringExtra("saveExtendReadingTitle");
    if ((localObject3 != null) && (localObject2 != null)) {
      ((com.tencent.mm.plugin.finder.upload.postui.a)localObject1).sKr.gD((String)localObject3, (String)localObject2);
    }
    localObject1 = this.sEW;
    if (localObject1 == null) {
      d.g.b.p.bcb("originalWidget");
    }
    localObject2 = getIntent();
    d.g.b.p.g(localObject2, "intent");
    localObject3 = this.sFa;
    if (localObject3 == null) {
      d.g.b.p.bcb("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
    d.g.b.p.h(localObject2, "intent");
    d.g.b.p.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.c)localObject1).sKC.setVisibility(8);
    localObject1 = this.sFa;
    if (localObject1 == null) {
      d.g.b.p.bcb("postDataManager");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).teA;
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label2266;
      }
      if (localObject1 != null) {
        break label2278;
      }
      label1975:
      if (localObject1 != null) {
        break label2307;
      }
      label1979:
      if (localObject1 != null) {
        break label2337;
      }
      label1983:
      localObject1 = this.sET;
      if (localObject1 == null) {
        break label2389;
      }
      localObject2 = this.sER;
      if (localObject2 == null) {
        d.g.b.p.bcb("mediaViewContainer");
      }
      ((ViewGroup)localObject2).removeAllViews();
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).cON();
      if (localObject1 != null) {
        break label2366;
      }
      localObject1 = this.sER;
      if (localObject1 == null) {
        d.g.b.p.bcb("mediaViewContainer");
      }
      ((ViewGroup)localObject1).setVisibility(8);
      label2041:
      localObject3 = this.sFa;
      if (localObject3 == null) {
        d.g.b.p.bcb("postDataManager");
      }
      if ((((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teH == null) || (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ter == null)) {
        break label2396;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.tez;
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.cOK();
      Object localObject5 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teH;
      if (localObject5 == null) {
        d.g.b.p.gfZ();
      }
      ((Bundle)localObject1).putByteArray((String)localObject2, ((FinderObjectDesc)localObject5).toByteArray());
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.tez;
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.cOJ();
      localObject5 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).ter;
      if (localObject5 == null) {
        d.g.b.p.gfZ();
      }
      ((Bundle)localObject1).putByteArray((String)localObject2, ((aqb)localObject5).toByteArray());
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
      localObject2 = com.tencent.mm.plugin.finder.widget.post.a.tez;
      ((Bundle)localObject1).putBoolean(com.tencent.mm.plugin.finder.widget.post.a.cOL(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).kTo);
      localObject1 = this.sET;
      if (localObject1 != null)
      {
        localObject2 = this.sFa;
        if (localObject2 == null) {
          d.g.b.p.bcb("postDataManager");
        }
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).ae(((com.tencent.mm.plugin.finder.widget.post.c)localObject2).sKs);
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).refresh();
      }
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new p(this));
      cKd();
      AppMethodBeat.o(167530);
      return;
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
      for (;;)
      {
        this.sET = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.d((Context)this, (byte)0));
        break label1983;
        label2266:
        if (((Integer)localObject1).intValue() != 7) {
          break;
        }
      }
      label2278:
      if (((Integer)localObject1).intValue() != 4) {
        break label1975;
      }
      this.sET = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.g((Context)this));
      break label1983;
      label2307:
      if (((Integer)localObject1).intValue() != 8) {
        break label1979;
      }
      this.sET = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.e((Context)this));
      break label1983;
      label2337:
      if (((Integer)localObject1).intValue() != 1) {
        break label1983;
      }
      this.sET = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.f((Context)this));
      break label1983;
      label2366:
      localObject2 = this.sER;
      if (localObject2 == null) {
        d.g.b.p.bcb("mediaViewContainer");
      }
      ((ViewGroup)localObject2).addView((View)localObject1);
      break label2041;
      label2389:
      finish();
      break label2041;
      label2396:
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teA;
      if (localObject1 == null)
      {
        label2406:
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teA;
        if (localObject1 != null) {
          break label2660;
        }
        label2416:
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teA;
        if (localObject1 != null) {
          break label2682;
        }
      }
      label2539:
      label2672:
      label2677:
      label2682:
      while (((Integer)localObject1).intValue() != 4)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teA;
        if ((localObject1 == null) || (((Integer)localObject1).intValue() != 8)) {
          break;
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putStringArrayList("MEDIA_FILE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teB);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putIntegerArrayList("MEDIA_TYPE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teG);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teE);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putStringArrayList("MEDIA_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teF);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putParcelable("vlog_crop_rect", (Parcelable)((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teI);
        break;
        if (((Integer)localObject1).intValue() != 2) {
          break label2406;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
        localObject2 = com.tencent.mm.plugin.finder.widget.post.d.teS;
        ((Bundle)localObject1).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.cOP(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teB);
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teC != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teC;
          if (localObject1 == null) {
            break label2672;
          }
          localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teB;
          if (localObject2 == null) {
            break label2677;
          }
        }
        for (localObject2 = Integer.valueOf(((ArrayList)localObject2).size());; localObject2 = null)
        {
          if (d.g.b.p.i(localObject1, localObject2))
          {
            localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
            localObject2 = com.tencent.mm.plugin.finder.widget.post.d.teS;
            ((Bundle)localObject1).putIntegerArrayList(com.tencent.mm.plugin.finder.widget.post.d.cOQ(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teC);
          }
          localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs;
          localObject2 = com.tencent.mm.plugin.finder.widget.post.d.teS;
          ((Bundle)localObject1).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.cOR(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teF);
          break;
          if (((Integer)localObject1).intValue() != 7) {
            break label2416;
          }
          break label2539;
          localObject1 = null;
          break label2587;
        }
      }
      label2587:
      label2660:
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putStringArrayList("video_file_list", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teB);
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teD != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putByteArray("video_composition", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teD);
      }
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teE);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putStringArrayList("VIDEO_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).teF);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putString("video_before_cut_path", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getStringExtra("select_video_path"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putString("VIDEO_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getStringExtra("VIDEO_COVER_URL"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sKs.putInt("VIDEO_COVER_QUALITY", ((com.tencent.mm.plugin.finder.widget.post.c)localObject3).intent.getIntExtra("VIDEO_COVER_QUALITY", 0));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(167539);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.sFf)
    {
      if (paramIntent != null)
      {
        localObject1 = this.sEU;
        if (localObject1 == null) {
          d.g.b.p.bcb("locationWidget");
        }
        d.g.b.p.h(paramIntent, "i");
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject2).putExtra("saveLocation", true);
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject2).putExtra("get_poi_name", bt.bI(paramIntent.getStringExtra("get_poi_name"), ""));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject2).putExtra("get_city", bt.bI(paramIntent.getStringExtra("get_city"), ""));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject2).putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject2).putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject2).putExtra("get_poi_address", bt.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
        localObject1 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject1 == null) {
          d.g.b.p.bcb("intent");
        }
        ((Intent)localObject1).putExtra("get_poi_classify_id", bt.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
        paramIntent = this.sEU;
        if (paramIntent == null) {
          d.g.b.p.bcb("locationWidget");
        }
        paramIntent.cKW();
        paramIntent = this.sEU;
        if (paramIntent == null) {
          d.g.b.p.bcb("locationWidget");
        }
        paramIntent = paramIntent.sKw;
        if (paramIntent != null)
        {
          if ((!bt.isNullOrNil(paramIntent.jDf)) || (!bt.isNullOrNil(paramIntent.ePv)))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
            com.tencent.mm.plugin.finder.report.f.a(2, paramIntent);
          }
          for (;;)
          {
            paramIntent = d.z.MKo;
            AppMethodBeat.o(167539);
            return;
            localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
            com.tencent.mm.plugin.finder.report.f.a(3, paramIntent);
          }
        }
        AppMethodBeat.o(167539);
        return;
      }
      AppMethodBeat.o(167539);
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.finder.widget.post.g.tfu;
    label629:
    label634:
    int j;
    if (paramInt1 == com.tencent.mm.plugin.finder.widget.post.g.cOW())
    {
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.widget.post.g.tfu;
        localObject1 = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.g.cOX());
        if (paramIntent != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.g.tfu;
          localObject2 = Integer.valueOf(paramIntent.getIntExtra(com.tencent.mm.plugin.finder.widget.post.g.cOY(), 0));
        }
        if (bt.isNullOrNil((String)localObject1)) {
          break label1356;
        }
        paramIntent = this.sFa;
        if (paramIntent == null) {
          d.g.b.p.bcb("postDataManager");
        }
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        if (localObject2 == null) {
          break label629;
        }
      }
      for (paramInt1 = ((Integer)localObject2).intValue();; paramInt1 = 0)
      {
        d.g.b.p.h(localObject1, "coverUrl");
        paramIntent.sKs.putString("VIDEO_COVER_URL", (String)localObject1);
        paramIntent.intent.putExtra("VIDEO_COVER_URL", (String)localObject1);
        paramIntent.sKs.putInt("VIDEO_COVER_QUALITY", paramInt1);
        paramIntent.intent.putExtra("VIDEO_COVER_QUALITY", paramInt1);
        paramIntent = this.sET;
        if (paramIntent == null) {
          break label634;
        }
        localObject1 = this.sFa;
        if (localObject1 == null) {
          d.g.b.p.bcb("postDataManager");
        }
        paramIntent.ae(((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sKs);
        paramIntent.refresh();
        paramIntent = d.z.MKo;
        AppMethodBeat.o(167539);
        return;
        localObject1 = null;
        break;
      }
      AppMethodBeat.o(167539);
    }
    else if (paramInt1 == this.sFg)
    {
      showVKB();
      if (paramIntent != null)
      {
        j = paramIntent.getIntExtra("key_scene", 1);
        if (paramInt2 != -1) {
          break label1363;
        }
        paramInt1 = paramIntent.getIntExtra("key_source", 2);
        localObject2 = paramIntent.getByteArrayExtra("key_select_contact");
        if (localObject2 != null) {}
        for (;;)
        {
          try
          {
            paramIntent = new bvd();
            paramIntent.parseFrom((byte[])localObject2);
            localObject1 = d.z.MKo;
            if (paramIntent == null) {
              break label1352;
            }
            if (bt.isNullOrNil(paramIntent.nickname)) {
              break label1348;
            }
            localObject1 = this.sFk;
            if (localObject1 == null) {
              d.g.b.p.bcb("styleManager");
            }
            localObject1 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cNY();
            localObject2 = paramIntent.username;
            d.g.b.p.g(localObject2, "atContact.username");
            ((com.tencent.mm.plugin.finder.view.manager.a)localObject1).bb(paramInt1, (String)localObject2);
            localObject1 = this.sFk;
            if (localObject1 == null) {
              d.g.b.p.bcb("styleManager");
            }
            ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cNY().sXX.put(paramIntent.nickname, paramIntent);
            localObject1 = this.sEP;
            if (localObject1 == null) {
              d.g.b.p.bcb("descTv");
            }
            paramInt2 = ((FinderPostEditText)localObject1).getSelectionEnd();
            localObject1 = this.sEP;
            if (localObject1 == null) {
              d.g.b.p.bcb("descTv");
            }
            localObject2 = ((FinderPostEditText)localObject1).getText().toString();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (j != 2) {
              break label1141;
            }
            localObject1 = this.sEP;
            if (localObject1 == null) {
              d.g.b.p.bcb("descTv");
            }
            j = ((FinderPostEditText)localObject1).getSelectionEnd();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (j <= 0) {
              break label1141;
            }
            paramInt2 = j - 1;
            paramInt1 = i;
            if ((paramInt2 < 0) || (paramInt1 == 0)) {
              break;
            }
            localObject1 = this.sEP;
            if (localObject1 == null) {
              d.g.b.p.bcb("descTv");
            }
            if (((FinderPostEditText)localObject1).getText().toString().charAt(paramInt2) != '@') {
              break label996;
            }
            paramInt2 -= 1;
            continue;
          }
          catch (Exception paramIntent)
          {
            ad.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { paramIntent.getMessage() });
            paramIntent = (Intent)localObject1;
            continue;
          }
          paramIntent = null;
          continue;
          label996:
          paramInt1 = 0;
        }
        paramInt2 += 1;
        paramInt1 = paramInt2;
        if (paramInt2 > ((String)localObject2).length()) {
          paramInt1 = ((String)localObject2).length();
        }
        localObject1 = new StringBuilder();
        if (localObject2 == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject3 = ((String)localObject2).substring(0, paramInt1);
        d.g.b.p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
        paramInt2 = ((String)localObject2).length();
        if (localObject2 == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject2 = ((String)localObject2).substring(j, paramInt2);
        d.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject2;
        label1141:
        if (paramInt1 <= ((String)localObject1).length()) {
          break label1683;
        }
        paramInt1 = ((String)localObject1).length();
      }
    }
    label1683:
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (localObject1 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167539);
        throw paramIntent;
      }
      localObject3 = ((String)localObject1).substring(0, paramInt1);
      d.g.b.p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append('@').append(paramIntent.nickname).append(' ');
      paramInt2 = ((String)localObject1).length();
      if (localObject1 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167539);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
      d.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = (String)localObject1;
      paramInt2 = paramIntent.nickname.length();
      paramIntent = this.sEP;
      if (paramIntent == null) {
        d.g.b.p.bcb("descTv");
      }
      paramIntent.setText((CharSequence)localObject1);
      paramIntent = this.sEP;
      if (paramIntent == null) {
        d.g.b.p.bcb("descTv");
      }
      paramIntent.setSelection(paramInt2 + paramInt1 + 2);
      label1348:
      paramIntent = d.z.MKo;
      label1352:
      label1356:
      label1363:
      do
      {
        do
        {
          paramIntent = d.z.MKo;
          AppMethodBeat.o(167539);
          return;
          paramIntent = this.sFk;
          if (paramIntent == null) {
            d.g.b.p.bcb("styleManager");
          }
          com.tencent.mm.plugin.finder.view.manager.a.a(paramIntent.cNY());
        } while (j != 2);
        paramIntent = this.sEP;
        if (paramIntent == null) {
          d.g.b.p.bcb("descTv");
        }
        paramIntent = paramIntent.getText().toString();
        localObject1 = this.sEP;
        if (localObject1 == null) {
          d.g.b.p.bcb("descTv");
        }
        i = ((FinderPostEditText)localObject1).getSelectionEnd();
      } while (i <= 0);
      paramInt2 = i - 1;
      paramInt1 = 1;
      while ((paramInt2 >= 0) && (paramInt1 != 0))
      {
        localObject1 = this.sEP;
        if (localObject1 == null) {
          d.g.b.p.bcb("descTv");
        }
        if (((FinderPostEditText)localObject1).getText().toString().charAt(paramInt2) == '@') {
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
        localObject1 = new StringBuilder();
        if (paramIntent == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject2 = paramIntent.substring(0, paramInt1);
        d.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        paramInt2 = paramIntent.length();
        if (paramIntent == null)
        {
          paramIntent = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        paramIntent = paramIntent.substring(i, paramInt2);
        d.g.b.p.g(paramIntent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramIntent = paramIntent;
        localObject1 = this.sEP;
        if (localObject1 == null) {
          d.g.b.p.bcb("descTv");
        }
        ((FinderPostEditText)localObject1).setText((CharSequence)paramIntent);
        paramIntent = this.sEP;
        if (paramIntent == null) {
          d.g.b.p.bcb("descTv");
        }
        paramIntent.setSelection(paramInt1);
        break;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167533);
    com.tencent.mm.plugin.finder.upload.postui.a locala = this.sEV;
    if (locala == null) {
      d.g.b.p.bcb("extendReadingWidget");
    }
    if (locala.sKr.sYi) {
      locala.sKr.cNP();
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        cKe();
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
    d.g.b.p.g(paramBundle, "intent");
    this.sFa = new com.tencent.mm.plugin.finder.widget.post.c(paramBundle);
    paramBundle = u.aAu();
    d.g.b.p.g(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    this.sEO = paramBundle;
    if (bt.isNullOrNil(this.sEO)) {
      finish();
    }
    paramBundle = com.tencent.mm.plugin.finder.api.c.rHn;
    this.contact = c.a.agW(this.sEO);
    initView();
    if (JB())
    {
      paramBundle = com.tencent.mm.ui.component.a.KiD;
      ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).bYc();
    }
    AppMethodBeat.o(167528);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167542);
    super.onDestroy();
    Object localObject = this.sFk;
    if (localObject == null) {
      d.g.b.p.bcb("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.c)localObject).sYF;
    if (localObject == null) {
      d.g.b.p.bcb("topicSuggestManager");
    }
    ((com.tencent.mm.plugin.finder.view.manager.d)localObject).sYJ = null;
    ((com.tencent.mm.plugin.finder.view.manager.d)localObject).sYK = null;
    com.tencent.mm.kernel.g.aiU().b(3875, (com.tencent.mm.al.f)localObject);
    AppMethodBeat.o(167542);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(204095);
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 1))
    {
      int i;
      Object localObject;
      String str;
      if (this.sEY)
      {
        paramKeyEvent = this.sEP;
        if (paramKeyEvent == null) {
          d.g.b.p.bcb("descTv");
        }
        paramInt = paramKeyEvent.getSelectionStart();
        paramKeyEvent = this.sEP;
        if (paramKeyEvent == null) {
          d.g.b.p.bcb("descTv");
        }
        paramKeyEvent = paramKeyEvent.getText();
        d.g.b.p.g(paramKeyEvent, "descTv.text");
        paramKeyEvent = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
        i = n.b((CharSequence)paramKeyEvent, '@');
        if ((i >= paramKeyEvent.length()) || (i < 0)) {}
        for (;;)
        {
          this.sEY = false;
          AppMethodBeat.o(204095);
          return true;
          if (paramKeyEvent == null)
          {
            paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(204095);
            throw paramKeyEvent;
          }
          paramKeyEvent = paramKeyEvent.substring(0, i);
          d.g.b.p.g(paramKeyEvent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject = this.sEP;
          if (localObject == null) {
            d.g.b.p.bcb("descTv");
          }
          localObject = ((FinderPostEditText)localObject).getText();
          d.g.b.p.g(localObject, "descTv.text");
          localObject = (CharSequence)localObject;
          str = ((CharSequence)localObject).subSequence(paramInt, ((CharSequence)localObject).length()).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramKeyEvent).append(str);
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramKeyEvent.setText((CharSequence)((StringBuilder)localObject).toString());
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramKeyEvent.setSelection(i);
        }
      }
      if (this.sEZ != null)
      {
        com.tencent.mm.plugin.finder.utils.b.a locala = this.sEZ;
        StringBuilder localStringBuilder;
        if (locala != null)
        {
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramInt = paramKeyEvent.getSelectionStart();
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.p.g(paramKeyEvent, "descTv.text");
          localObject = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.p.g(paramKeyEvent, "descTv.text");
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
            AppMethodBeat.o(204095);
            throw paramKeyEvent;
            label511:
            if (str == null)
            {
              paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(204095);
              throw paramKeyEvent;
            }
            paramKeyEvent = str.substring(i + 1);
            d.g.b.p.g(paramKeyEvent, "(this as java.lang.String).substring(startIndex)");
          }
          localObject = ((String)localObject).substring(0, paramInt);
          d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localStringBuilder.append((String)localObject).append(paramKeyEvent);
          paramInt = locala.start;
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramKeyEvent.setText((CharSequence)localStringBuilder.toString());
          paramKeyEvent = this.sEP;
          if (paramKeyEvent == null) {
            d.g.b.p.bcb("descTv");
          }
          paramKeyEvent.setSelection(paramInt);
        }
        this.sEZ = null;
        AppMethodBeat.o(204095);
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
              AppMethodBeat.o(204095);
              throw paramKeyEvent;
            }
            localObject = ((String)localObject).substring(0, i);
            d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            paramInt = i;
          }
        }
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(204095);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167532);
    super.onResume();
    this.sFm = ar.dT((Context)getContext());
    com.tencent.mm.plugin.finder.upload.postui.a locala = this.sEV;
    if (locala == null) {
      d.g.b.p.bcb("extendReadingWidget");
    }
    locala.sKr.cNR();
    AppMethodBeat.o(167532);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167531);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.sFl))
    {
      com.tencent.mm.ui.tools.h localh = this.fQT;
      if (localh == null) {
        d.g.b.p.bcb("keyboardHeightProvider");
      }
      localh.start();
      this.sFl = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(167531);
  }
  
  public final void r(String paramString, List<btl> paramList)
  {
    AppMethodBeat.i(167536);
    Object localObject1 = (Collection)paramList;
    int i;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ad.i(this.TAG, "get lbsLife success");
      localObject1 = this.sEU;
      if (localObject1 == null) {
        d.g.b.p.bcb("locationWidget");
      }
      paramList = (btl)j.jc(paramList);
      if (this.sFa == null) {
        d.g.b.p.bcb("postDataManager");
      }
      d.g.b.p.h(paramList, "lbsLife");
      if (((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).isLoading)
      {
        ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKx = true;
        if (bt.isNullOrNil(paramString))
        {
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKy.eZe();
          paramString = com.tencent.mm.plugin.finder.report.f.soC;
          com.tencent.mm.plugin.finder.report.f.a(0, ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKw);
          AppMethodBeat.o(167536);
          return;
          i = 0;
        }
        else
        {
          Object localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bcb("intent");
          }
          ((Intent)localObject2).putExtra("saveLocation", true);
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bcb("intent");
          }
          ((Intent)localObject2).putExtra("get_poi_name", "");
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bcb("intent");
          }
          ((Intent)localObject2).putExtra("get_city", bt.nullAsNil(paramString));
          localObject2 = com.tencent.mm.ui.component.a.KiD;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject2 = FinderGlobalLocationVM.cOb();
          Object localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject3 == null) {
            d.g.b.p.bcb("intent");
          }
          ((Intent)localObject3).putExtra("get_lat", ((Number)((d.o)localObject2).second).floatValue());
          localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject3 == null) {
            d.g.b.p.bcb("intent");
          }
          ((Intent)localObject3).putExtra("get_lng", ((Number)((d.o)localObject2).first).floatValue());
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bcb("intent");
          }
          ((Intent)localObject2).putExtra("get_poi_classify_type", paramList.nEf);
          paramList = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (paramList == null) {
            d.g.b.p.bcb("intent");
          }
          paramList.putExtra("get_poi_classify_id", "");
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).cKW();
          paramList = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKw;
          if (paramList != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKs;
            if (localObject2 == null) {
              d.g.b.p.bcb("postData");
            }
            localObject3 = com.tencent.mm.plugin.finder.widget.post.a.tez;
            ((Bundle)localObject2).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.cOH(), paramList.toByteArray());
          }
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKy.setSuggestView(paramString);
          paramString = com.tencent.mm.plugin.finder.report.f.soC;
          com.tencent.mm.plugin.finder.report.f.a(1, ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sKw);
        }
      }
      else
      {
        AppMethodBeat.o(167536);
        return;
      }
    }
    paramString = this.sEU;
    if (paramString == null) {
      d.g.b.p.bcb("locationWidget");
    }
    paramString.isLoading = false;
    paramString.sKx = true;
    paramString.sKy.eZe();
    AppMethodBeat.o(167536);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(167535);
    Object localObject1 = this.sFh;
    if (localObject1 == null) {
      d.g.b.p.bcb("footer");
    }
    if (paramInt > 0) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      if ((paramInt > 0) && (paramInt != (int)((FinderPostFooter)localObject1).sTb))
      {
        com.tencent.mm.sdk.platformtools.z.aF(((FinderPostFooter)localObject1).getContext(), paramInt);
        ((FinderPostFooter)localObject1).sTb = paramInt;
        localObject2 = new LinearLayout.LayoutParams(-1, (int)((FinderPostFooter)localObject1).sTb);
        SmileyPanel localSmileyPanel = ((FinderPostFooter)localObject1).gVn;
        if (localSmileyPanel == null) {
          d.g.b.p.bcb("smileyPanel");
        }
        localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((FinderPostFooter)localObject1).sSV;
      if (localObject2 == null) {
        d.g.b.p.bcb("smileyBtn");
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
      localObject2 = ((FinderPostFooter)localObject1).ize;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean)) {
        ((FinderPostFooter)localObject1).P(false, false);
      }
      localObject1 = this.sFh;
      if (localObject1 == null) {
        d.g.b.p.bcb("footer");
      }
      ((FinderPostFooter)localObject1).post((Runnable)new o(this));
      AppMethodBeat.o(167535);
      return;
      localObject2 = ((FinderPostFooter)localObject1).ize;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderPostUI paramFinderPostUI, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(167507);
      FinderPostUI.p(this.sFo).scrollBy(0, this.sFp - this.sFq);
      AppMethodBeat.o(167507);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderPostUI$checkPostData$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(167508);
      FinderPostUI.h(this.sFo);
      AppMethodBeat.o(167508);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class c
    implements View.OnLayoutChangeListener
  {
    c(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167509);
      ad.i(FinderPostUI.b(this.sFo), "oldBottom " + paramInt8 + ", bottom " + paramInt4);
      if (paramInt8 != paramInt4) {
        FinderPostUI.v(this.sFo);
      }
      AppMethodBeat.o(167509);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167510);
      paramDialogInterface = Parcel.obtain();
      FinderPostUI.a(this.sFo, FinderPostUI.a(this.sFo).getText().toString());
      this.sFo.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      Object localObject = FinderPostUI.z(this.sFo).teA;
      if (localObject == null)
      {
        localObject = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHS, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
      for (;;)
      {
        FinderPostUI.A(this.sFo);
        paramDialogInterface = com.tencent.mm.plugin.finder.report.f.soC;
        com.tencent.mm.plugin.finder.report.f.aj(4, true);
        AppMethodBeat.o(167510);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHT, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167511);
      paramDialogInterface = FinderPostUI.z(this.sFo).teA;
      if (paramDialogInterface == null)
      {
        paramDialogInterface = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.ajl().set(al.a.IHS, "");
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.f.soC;
        com.tencent.mm.plugin.finder.report.f.aj(4, false);
        FinderPostUI.A(this.sFo);
        AppMethodBeat.o(167511);
        return;
        if (paramDialogInterface.intValue() != 1) {
          break;
        }
        paramDialogInterface = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.ajl().set(al.a.IHT, "");
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cur", "", "last", "invoke"})
  static final class f
    extends d.g.b.q
    implements m<Integer, Integer, d.z>
  {
    f(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class g
    implements View.OnTouchListener
  {
    g(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167513);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      if (d.g.b.p.i(paramView, FinderPostUI.a(this.sFo)))
      {
        d.g.b.p.g(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(167513);
        return false;
        FinderPostUI.p(this.sFo).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderPostUI.p(this.sFo).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"})
  static final class h
    implements View.OnKeyListener
  {
    h(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(204088);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.mr(paramInt);
      localb.bd(paramKeyEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
      if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
      {
        paramView = this.sFo;
        if (FinderPostUI.m(this.sFo) != ' ') {
          break label140;
        }
      }
      label140:
      for (boolean bool = true;; bool = false)
      {
        FinderPostUI.b(paramView, bool);
        if (!FinderPostUI.q(this.sFo)) {
          FinderPostUI.a(this.sFo, FinderPostUI.r(this.sFo));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(204088);
        return false;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class i
    implements TextWatcher
  {
    i(int paramInt) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167514);
      int i = com.tencent.mm.ui.tools.f.cU(i * 2, String.valueOf(paramEditable)) / 2;
      i = i - i;
      FinderPostUI.a(this.sFo, true);
      label140:
      Object localObject;
      if (i / i >= 0.95D)
      {
        FinderPostUI.j(this.sFo).setText((CharSequence)(i + '/' + i));
        if (i > i)
        {
          FinderPostUI.j(this.sFo).setTextColor(this.sFo.getResources().getColor(2131099804));
          FinderPostUI.a(this.sFo, false);
          FinderPostUI.j(this.sFo).setVisibility(0);
          FinderPostUI.k(this.sFo);
          localObject = FinderPostUI.d(this.sFo);
          String str = String.valueOf(paramEditable);
          if (paramEditable == null) {
            d.g.b.p.gfZ();
          }
          ((com.tencent.mm.plugin.finder.view.manager.c)localObject).a(str, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (com.tencent.mm.plugin.finder.storage.b.cGf())
          {
            i = FinderPostUI.d(this.sFo).cNX().sYI.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (i <= ((Number)com.tencent.mm.plugin.finder.storage.b.cGX().value()).intValue()) {
              break label376;
            }
            FinderPostUI.l(this.sFo).mp(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (!com.tencent.mm.plugin.finder.storage.b.cGg()) {
          break label473;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cHf().value()).intValue() == 1000) {
          break label390;
        }
        i = FinderPostUI.d(this.sFo).cNY().sXY.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (i < ((Number)com.tencent.mm.plugin.finder.storage.b.cHf().value()).intValue()) {
          break label390;
        }
        FinderPostUI.l(this.sFo).mq(false);
        AppMethodBeat.o(167514);
        return;
        FinderPostUI.j(this.sFo).setTextColor(this.sFo.getResources().getColor(2131099734));
        break;
        FinderPostUI.j(this.sFo).setText((CharSequence)"");
        FinderPostUI.j(this.sFo).setVisibility(8);
        break label140;
        label376:
        FinderPostUI.l(this.sFo).mp(true);
      }
      label390:
      FinderPostUI.l(this.sFo).mq(true);
      if ((FinderPostUI.m(this.sFo) == '@') && (FinderPostUI.n(this.sFo) == null))
      {
        ad.i(FinderPostUI.b(this.sFo), "at auto goto");
        paramEditable = new Intent();
        paramEditable.putExtra("key_scene", 2);
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.d((MMActivity)this.sFo, paramEditable, FinderPostUI.o(this.sFo));
      }
      label473:
      AppMethodBeat.o(167514);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class j
    implements View.OnTouchListener
  {
    j(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167515);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      d.g.b.p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = new Rect();
        FinderPostUI.a(this.sFo).getGlobalVisibleRect(paramView);
        ad.i(FinderPostUI.b(this.sFo), "rawY:" + paramMotionEvent.getRawY() + ", rect:" + paramView.toShortString());
        if ((paramMotionEvent.getRawY() < paramView.top) || (paramMotionEvent.getRawY() > paramView.bottom)) {
          FinderPostUI.c(this.sFo).setVisibility(8);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/ui/FinderPostUI$initView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(167515);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class k
    implements View.OnLayoutChangeListener
  {
    k(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(204090);
      paramView.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204089);
          ad.i(FinderPostUI.b(this.sFs.sFo), "descTv OnLayoutChangeListener");
          Object localObject1 = FinderPostUI.d(this.sFs.sFo).cNX();
          int i = FinderPostUI.e(this.sFs.sFo);
          if (((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sFj.getVisibility() == 0)
          {
            int j = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sEP.getSelectionStart();
            Object localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sEP.getLayout();
            int m = ((Layout)localObject2).getLineForOffset(j);
            int k = ((Layout)localObject2).getLineBaseline(m);
            m = ((Layout)localObject2).getLineAscent(m);
            int[] arrayOfInt = new int[2];
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sEP.getLocationOnScreen(arrayOfInt);
            Point localPoint = new Point();
            localPoint.x = ((int)((Layout)localObject2).getPrimaryHorizontal(j));
            localPoint.y = (k + m + arrayOfInt[1] - ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sEP.getScrollY());
            ad.i(com.tencent.mm.plugin.finder.view.manager.d.TAG, "onSelectionChangedListener point " + localPoint + ", actionbarHeight " + i);
            localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sFj.getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
              AppMethodBeat.o(204089);
              throw ((Throwable)localObject1);
            }
            localObject2 = (FrameLayout.LayoutParams)localObject2;
            ((FrameLayout.LayoutParams)localObject2).topMargin = (localPoint.y - i);
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sFj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          AppMethodBeat.o(204089);
        }
      });
      AppMethodBeat.o(204090);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204091);
      FinderPostUI.f(this.sFo);
      AppMethodBeat.o(204091);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204092);
      if (FinderPostUI.g(this.sFo) == 0)
      {
        if (this.sFo.getIntent().getIntExtra("key_finder_post_from", -1) == 5)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.storage.b.sxa;
            int i = com.tencent.mm.plugin.finder.storage.b.cHe();
            if (i < 6)
            {
              paramMenuItem = com.tencent.mm.plugin.finder.storage.b.sxa;
              com.tencent.mm.plugin.finder.storage.b.Fj(i + 1);
            }
          }
        }
        FinderPostUI.h(this.sFo);
      }
      AppMethodBeat.o(204092);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "open", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.b<Boolean, d.z>
  {
    n(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(FinderPostUI paramFinderPostUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167524);
      ad.i(FinderPostUI.b(this.sFo), "footer.height " + FinderPostUI.t(this.sFo).getHeight() + ", footer.oldHeight " + FinderPostUI.u(this.sFo));
      if (FinderPostUI.t(this.sFo).getVisibility() == 0)
      {
        if ((FinderPostUI.a(this.sFo).hasFocus()) && (FinderPostUI.t(this.sFo).getHeight() != FinderPostUI.u(this.sFo)))
        {
          FinderPostUI.a(this.sFo, FinderPostUI.t(this.sFo).getHeight());
          FinderPostUI.v(this.sFo);
        }
        FinderPostUI.w(this.sFo).addOnLayoutChangeListener(FinderPostUI.x(this.sFo));
        AppMethodBeat.o(167524);
        return;
      }
      if ((FinderPostUI.t(this.sFo).getVisibility() == 8) || (FinderPostUI.t(this.sFo).getHeight() == 0))
      {
        FinderPostUI.a(this.sFo, 0);
        FinderPostUI.p(this.sFo).scrollTo(0, 0);
        Object localObject = FinderPostUI.y(this.sFo).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(167524);
          throw ((Throwable)localObject);
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).height = 0;
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        FinderPostUI.y(this.sFo).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderPostUI.y(this.sFo).requestLayout();
        FinderPostUI.w(this.sFo).removeOnLayoutChangeListener(FinderPostUI.x(this.sFo));
      }
      AppMethodBeat.o(167524);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    p(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */