package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
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
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.a.j;
import d.g.a.m;
import d.l;
import d.n.n;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(17)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "()V", "CHECK_POST_INTERVAL", "", "MAX_CHECK_POST_COUNT", "", "MENU_ID_POST", "REQUEST_CODE_PICK_LOCATION", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "actionBarHeight", "avatarIv", "Landroid/widget/ImageView;", "bottomSpace", "Landroid/view/View;", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "deleteAtStringByInter", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendReadingWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "footerContainer", "hasStartKeyBoardProvider", "", "isFromtOfAtOneEnd", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "nickTv", "Landroid/widget/TextView;", "oldFooterHeight", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "scrollView", "Landroid/widget/ScrollView;", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "textCountTv", "textOk", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "checkNeedScroll", "", "checkNextEnable", "checkPermission", "checkPostData", "deleteAtMemberFromEnd", "deleteAtMemberFromInter", "atStringInfo", "deleteInAtSomeoneInter", "exitAndSave", "getCharAtCursor", "", "getLayoutId", "initDescText", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetLbsLifes", "city", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onTopicClick", "onWindowFocusChanged", "hasFocus", "requestLocation", "restore", "routeBack", "routeForward", "localId", "saveDescData", "desc", "selectMedia", "plugin-finder_release"})
public final class FinderPostUI
  extends MMFinderUI
  implements FinderPostFooter.b, a.a, com.tencent.mm.ui.tools.g
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private com.tencent.mm.plugin.finder.api.g contact;
  private com.tencent.mm.ui.base.p fPj;
  private com.tencent.mm.ui.tools.h fSZ;
  private ScrollView fSp;
  private ImageView fTj;
  private TextView jjZ;
  private String sPN;
  private FinderPostEditText sPO;
  private TextView sPP;
  private ViewGroup sPQ;
  private View sPR;
  private com.tencent.mm.plugin.finder.widget.post.a sPS;
  private com.tencent.mm.plugin.finder.upload.postui.b sPT;
  private com.tencent.mm.plugin.finder.upload.postui.a sPU;
  private com.tencent.mm.plugin.finder.upload.postui.c sPV;
  private boolean sPW;
  private boolean sPX;
  private com.tencent.mm.plugin.finder.utils.b.a sPY;
  private com.tencent.mm.plugin.finder.widget.post.c sPZ;
  private View sPg;
  private int sQa;
  private int sQb;
  private final int sQc;
  private final long sQd;
  private final int sQe;
  private final int sQf;
  private FinderPostFooter sQg;
  private View sQh;
  private FinderTopicSuggestView sQi;
  private com.tencent.mm.plugin.finder.view.manager.c sQj;
  private boolean sQk;
  private int sQl;
  private final View.OnLayoutChangeListener sQm;
  private final int spr;
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    this.TAG = "Finder.FinderPostUI";
    this.sPN = "";
    this.sPW = true;
    this.sQc = 10;
    this.sQd = 500L;
    this.spr = 10000;
    this.sQe = 20000;
    this.sQf = 20001;
    this.sQm = ((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(167543);
  }
  
  private final boolean JJ()
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
      ae.e(this.TAG, "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(167529);
      return true;
    }
    AppMethodBeat.o(167529);
    return false;
  }
  
  private final void cMG()
  {
    AppMethodBeat.i(167534);
    Object localObject = this.sPU;
    if (localObject == null) {
      d.g.b.p.bdF("extendReadingWidget");
    }
    if (((com.tencent.mm.plugin.finder.upload.postui.a)localObject).sVE.cQA())
    {
      localObject = this.sPZ;
      if (localObject == null) {
        d.g.b.p.bdF("postDataManager");
      }
      localObject = ((com.tencent.mm.plugin.finder.widget.post.c)localObject).tpt;
      if (localObject != null) {
        break label78;
      }
    }
    while (!this.sPW) {
      label78:
      do
      {
        enableOptionMenu(this.spr, false);
        AppMethodBeat.o(167534);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = this.sPO;
        if (localObject == null) {
          d.g.b.p.bdF("descTv");
        }
      } while (bu.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    localObject = this.sPS;
    if (localObject != null)
    {
      if ((localObject instanceof com.tencent.mm.plugin.finder.widget.post.f))
      {
        localObject = this.sPO;
        if (localObject == null) {
          d.g.b.p.bdF("descTv");
        }
        localObject = ((FinderPostEditText)localObject).getText().toString();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(167534);
          throw ((Throwable)localObject);
        }
        if (bu.isNullOrNil(n.trim((CharSequence)localObject).toString()))
        {
          enableOptionMenu(this.spr, false);
          AppMethodBeat.o(167534);
          return;
        }
      }
      enableOptionMenu(this.spr, true);
      AppMethodBeat.o(167534);
      return;
    }
    enableOptionMenu(this.spr, false);
    AppMethodBeat.o(167534);
  }
  
  private final void cMH()
  {
    AppMethodBeat.i(167538);
    Object localObject = com.tencent.mm.plugin.finder.report.g.syJ;
    localObject = this.sQj;
    if (localObject == null) {
      d.g.b.p.bdF("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.c)localObject).cQI().tjm;
    com.tencent.mm.plugin.finder.view.manager.c localc = this.sQj;
    if (localc == null) {
      d.g.b.p.bdF("styleManager");
    }
    int i = localc.cQI().tjo;
    localc = this.sQj;
    if (localc == null) {
      d.g.b.p.bdF("styleManager");
    }
    com.tencent.mm.plugin.finder.report.g.c((ArrayList)localObject, i, localc.cQI().tjp);
    localObject = this.sPZ;
    if (localObject == null) {
      d.g.b.p.bdF("postDataManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.widget.post.c)localObject).tpt;
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.sPZ;
      if (localObject == null) {
        d.g.b.p.bdF("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject).tpk == null)
      {
        localObject = this.sPZ;
        if (localObject == null) {
          d.g.b.p.bdF("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject).tpA == null) {
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
        localObject = this.sPO;
        if (localObject == null) {
          d.g.b.p.bdF("descTv");
        }
      } while (bu.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    com.tencent.mm.ui.base.h.a((Context)this, 2131759390, 0, 2131759392, 2131759391, true, (DialogInterface.OnClickListener)new d(this), (DialogInterface.OnClickListener)new e(this), 2131099903);
    AppMethodBeat.o(167538);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204700);
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
    AppMethodBeat.o(204700);
    return localView1;
  }
  
  public final void cMI()
  {
    AppMethodBeat.i(204693);
    Object localObject1 = this.sPO;
    if (localObject1 == null) {
      d.g.b.p.bdF("descTv");
    }
    int i = ((FinderPostEditText)localObject1).getSelectionStart();
    localObject1 = this.sPO;
    if (localObject1 == null) {
      d.g.b.p.bdF("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.finder.utils.o.sXt;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.utils.o.cOd());
    localObject3 = com.tencent.mm.plugin.finder.utils.o.sXt;
    localObject2 = com.tencent.mm.plugin.finder.utils.o.cOd();
    if (i == 0) {
      localObject1 = (String)localObject2 + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = this.sPO;
      if (localObject2 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
      localObject1 = this.sPO;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject1).requestFocus();
      localObject1 = this.sPO;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject1).setSelection(i + 1);
      localObject1 = this.sQh;
      if (localObject1 == null) {
        d.g.b.p.bdF("footerContainer");
      }
      if (((View)localObject1).getVisibility() == 8) {
        showVKB();
      }
      AppMethodBeat.o(204693);
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
          localObject1 = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204693);
          throw ((Throwable)localObject1);
        }
        String str = ((String)localObject1).substring(0, i);
        d.g.b.p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject3).append(str).append((String)localObject2);
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204693);
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
    this.sPQ = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131303359);
    d.g.b.p.g(localObject1, "findViewById(R.id.post_avatar)");
    this.fTj = ((ImageView)localObject1);
    localObject1 = findViewById(2131303369);
    d.g.b.p.g(localObject1, "findViewById(R.id.post_nickname)");
    this.jjZ = ((TextView)localObject1);
    localObject1 = findViewById(2131303361);
    d.g.b.p.g(localObject1, "findViewById(R.id.post_desc_edt)");
    this.sPO = ((FinderPostEditText)localObject1);
    localObject1 = findViewById(2131304376);
    d.g.b.p.g(localObject1, "findViewById(R.id.scroll_view)");
    this.fSp = ((ScrollView)localObject1);
    localObject1 = findViewById(2131297467);
    d.g.b.p.g(localObject1, "findViewById(R.id.bottom_space)");
    this.sPR = ((View)localObject1);
    localObject1 = findViewById(2131299309);
    d.g.b.p.g(localObject1, "findViewById(R.id.edt_container)");
    this.sPg = ((View)localObject1);
    localObject1 = findViewById(2131306036);
    d.g.b.p.g(localObject1, "findViewById(R.id.topic_suggest_view)");
    this.sQi = ((FinderTopicSuggestView)localObject1);
    localObject1 = this.sQi;
    if (localObject1 == null) {
      d.g.b.p.bdF("topicSuggestView");
    }
    Object localObject3 = this.sPO;
    if (localObject3 == null) {
      d.g.b.p.bdF("descTv");
    }
    this.sQj = new com.tencent.mm.plugin.finder.view.manager.c((FinderTopicSuggestView)localObject1, (FinderPostEditText)localObject3, (MMActivity)this);
    localObject1 = (MMActivity)this;
    localObject3 = findViewById(2131307297);
    d.g.b.p.g(localObject3, "findViewById(R.id.choose_original_view)");
    this.sPV = new com.tencent.mm.plugin.finder.upload.postui.c((MMActivity)localObject1, (FinderChooseOriginalView)localObject3);
    localObject1 = findViewById(2131300198);
    d.g.b.p.g(localObject1, "findViewById(R.id.footer_container)");
    this.sQh = ((View)localObject1);
    localObject1 = this.sQh;
    if (localObject1 == null) {
      d.g.b.p.bdF("footerContainer");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = findViewById(2131299983);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_comment_footer)");
    this.sQg = ((FinderPostFooter)localObject1);
    Object localObject4 = findViewById(2131308179);
    localObject1 = findViewById(2131308180);
    localObject3 = this.sQg;
    if (localObject3 == null) {
      d.g.b.p.bdF("footer");
    }
    Object localObject5 = (MMActivity)this;
    Object localObject6 = this.sQh;
    if (localObject6 == null) {
      d.g.b.p.bdF("footerContainer");
    }
    Object localObject7 = this.sPO;
    if (localObject7 == null) {
      d.g.b.p.bdF("descTv");
    }
    localObject7 = (MMEditText)localObject7;
    final int i = this.sQf;
    Object localObject8 = (FinderPostFooter.b)this;
    d.g.b.p.g(localObject4, "atBtn");
    d.g.b.p.g(localObject1, "topicBtn");
    d.g.b.p.h(localObject5, "activity");
    d.g.b.p.h(localObject6, "container");
    d.g.b.p.h(localObject7, "editText");
    d.g.b.p.h(localObject8, "iTopicCallback");
    d.g.b.p.h(localObject4, "atBtn");
    d.g.b.p.h(localObject1, "topicBtn");
    ((FinderPostFooter)localObject3).activity = ((MMActivity)localObject5);
    ((FinderPostFooter)localObject3).iBX = ((View)localObject6);
    ((FinderPostFooter)localObject3).tei = ((MMEditText)localObject7);
    ((FinderPostFooter)localObject3).ktZ = i;
    ((FinderPostFooter)localObject3).tgy = ((FinderPostFooter.b)localObject8);
    ((FinderPostFooter)localObject3).tgx = ((View)localObject4);
    ((FinderPostFooter)localObject3).tgw = ((View)localObject1);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new FinderPostFooter.c((FinderPostFooter.b)localObject8));
    ((View)localObject4).setOnClickListener((View.OnClickListener)new FinderPostFooter.d((MMActivity)localObject5, i));
    localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIc())
    {
      ((View)localObject1).setVisibility(0);
      ((FinderPostFooter)localObject3).setOnClickListener((View.OnClickListener)FinderPostFooter.e.tgC);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cIc()) {
        break label1536;
      }
      findViewById(2131306037).setOnTouchListener((View.OnTouchListener)new j(this));
      localObject1 = this.fSp;
      if (localObject1 == null) {
        d.g.b.p.bdF("scrollView");
      }
      ((ScrollView)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)new k(this));
      label664:
      localObject1 = this.sQg;
      if (localObject1 == null) {
        d.g.b.p.bdF("footer");
      }
      localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
      ((FinderPostFooter)localObject1).mv(com.tencent.mm.plugin.finder.storage.b.cId());
      this.fSZ = new com.tencent.mm.ui.tools.h((Activity)this);
      localObject1 = this.fSZ;
      if (localObject1 == null) {
        d.g.b.p.bdF("keyboardHeightProvider");
      }
      ((com.tencent.mm.ui.tools.h)localObject1).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)this);
      localObject1 = findViewById(2131305750);
      d.g.b.p.g(localObject1, "findViewById(R.id.textcount_hint)");
      this.sPP = ((TextView)localObject1);
      localObject1 = this.sPP;
      if (localObject1 == null) {
        d.g.b.p.bdF("textCountTv");
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = this.sPP;
      if (localObject1 == null) {
        d.g.b.p.bdF("textCountTv");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = (MMActivity)this;
      localObject3 = findViewById(2131303366);
      d.g.b.p.g(localObject3, "findViewById(R.id.post_location_view)");
      localObject3 = (LocationView)localObject3;
      localObject4 = findViewById(2131303337);
      d.g.b.p.g(localObject4, "findViewById(R.id.poi_tip_layout)");
      localObject5 = findViewById(2131303338);
      d.g.b.p.g(localObject5, "findViewById(R.id.poi_tip_tv)");
      this.sPT = new com.tencent.mm.plugin.finder.upload.postui.b((MMActivity)localObject1, (LocationView)localObject3, (View)localObject4, (TextView)localObject5, this.sQe);
      localObject1 = this.contact;
      if (localObject1 != null)
      {
        localObject3 = i.srW;
        localObject3 = i.cEo();
        localObject4 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject1).field_avatarUrl);
        localObject5 = this.fTj;
        if (localObject5 == null) {
          d.g.b.p.bdF("avatarIv");
        }
        localObject6 = i.srW;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, (ImageView)localObject5, i.a(i.a.srZ));
        localObject3 = this.jjZ;
        if (localObject3 == null) {
          d.g.b.p.bdF("nickTv");
        }
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject1).VK()));
      }
      if (getIntent().getBooleanExtra("hideDescEdit", false))
      {
        localObject1 = this.sPO;
        if (localObject1 == null) {
          d.g.b.p.bdF("descTv");
        }
        ((FinderPostEditText)localObject1).setVisibility(8);
      }
      setBackBtn((MenuItem.OnMenuItemClickListener)new l(this));
      addTextOptionMenu(this.spr, getString(2131759300), (MenuItem.OnMenuItemClickListener)new m(this), null, s.b.JwL);
      enableOptionMenu(this.spr, false);
      localObject1 = this.sPZ;
      if (localObject1 == null) {
        d.g.b.p.bdF("postDataManager");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject1).tpt;
      if (localObject1 != null) {
        break label1580;
      }
      label1097:
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    }
    for (i = ((Number)com.tencent.mm.plugin.finder.storage.b.cIU().value()).intValue();; i = ((Number)com.tencent.mm.plugin.finder.storage.b.cIV().value()).intValue())
    {
      localObject1 = (TextWatcher)new i(this, i);
      localObject3 = this.sPO;
      if (localObject3 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject3).addTextChangedListener((TextWatcher)localObject1);
      localObject1 = this.sPO;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject1).setOnSelectionChangedListener((m)new f(this));
      localObject1 = this.sPO;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject1).setOnTouchListener((View.OnTouchListener)new g(this));
      localObject1 = this.sPO;
      if (localObject1 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject1).setOnKeyListener((View.OnKeyListener)new h(this));
      localObject1 = (MMActivity)this;
      localObject3 = findViewById(2131299633);
      d.g.b.p.g(localObject3, "findViewById(R.id.extend_reading_view)");
      this.sPU = new com.tencent.mm.plugin.finder.upload.postui.a((MMActivity)localObject1, (FinderExtendReadingView)localObject3, (d.g.a.b)new n(this));
      localObject1 = this.sPZ;
      if (localObject1 == null) {
        d.g.b.p.bdF("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).tpA != null)
      {
        localObject1 = this.sPZ;
        if (localObject1 == null) {
          d.g.b.p.bdF("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject1).tpk != null)
        {
          localObject1 = findViewById(2131299633);
          d.g.b.p.g(localObject1, "findViewById<View>(R.id.extend_reading_view)");
          ((View)localObject1).setVisibility(8);
          localObject1 = findViewById(2131303366);
          d.g.b.p.g(localObject1, "findViewById<View>(R.id.post_location_view)");
          ((View)localObject1).setVisibility(8);
        }
      }
      localObject4 = getIntent().getStringExtra("saveDesc");
      localObject1 = getIntent().getParcelableArrayListExtra("saveDescAt");
      if (localObject1 == null) {
        break label1608;
      }
      localObject3 = this.sQj;
      if (localObject3 == null) {
        d.g.b.p.bdF("styleManager");
      }
      localObject5 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject3).cQI();
      d.g.b.p.h(localObject1, "atContactParcelList");
      localObject6 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject1 = (LocalFinderAtContactParcel)((Iterator)localObject6).next();
        try
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.b.sWa;
          d.g.b.p.g(localObject1, "atContactParcel");
          localObject7 = com.tencent.mm.plugin.finder.utils.b.a((LocalFinderAtContactParcel)localObject1);
          localObject8 = ((com.tencent.mm.plugin.finder.view.manager.a)localObject5).tjl;
          localObject3 = ((bvx)localObject7).nickname;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((HashMap)localObject8).put(localObject1, localObject7);
        }
        catch (Exception localException)
        {
          ae.e(com.tencent.mm.plugin.finder.view.manager.a.TAG, "restoreAtContactMap transformToLocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
        }
      }
      localException.setVisibility(8);
      break;
      label1536:
      localObject2 = this.sQg;
      if (localObject2 == null) {
        d.g.b.p.bdF("footer");
      }
      ((FinderPostFooter)localObject2).mu(false);
      localObject2 = this.sQi;
      if (localObject2 == null) {
        d.g.b.p.bdF("topicSuggestView");
      }
      ((FinderTopicSuggestView)localObject2).setVisibility(8);
      break label664;
      label1580:
      if (((Integer)localObject2).intValue() != 1) {
        break label1097;
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    }
    label1608:
    if (!bu.isNullOrNil((String)localObject4))
    {
      localObject2 = this.sPO;
      if (localObject2 == null) {
        d.g.b.p.bdF("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject4);
    }
    Object localObject2 = this.sPT;
    if (localObject2 == null) {
      d.g.b.p.bdF("locationWidget");
    }
    localObject3 = getIntent();
    d.g.b.p.g(localObject3, "intent");
    localObject4 = this.sPZ;
    if (localObject4 == null) {
      d.g.b.p.bdF("postDataManager");
    }
    localObject4 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
    d.g.b.p.h(localObject3, "intent");
    d.g.b.p.h(localObject4, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).intent = ((Intent)localObject3);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).sVF = ((Bundle)localObject4);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).sVM.setVisibility(8);
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).sVL.setLocationName(((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).activity.getString(2131759251));
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).sVL.setOnClickLocationListener((LocationView.a)new com.tencent.mm.plugin.finder.upload.postui.b.a((com.tencent.mm.plugin.finder.upload.postui.b)localObject2));
    ((com.tencent.mm.plugin.finder.upload.postui.b)localObject2).cNA();
    localObject2 = this.sPU;
    if (localObject2 == null) {
      d.g.b.p.bdF("extendReadingWidget");
    }
    localObject3 = getIntent();
    d.g.b.p.g(localObject3, "intent");
    localObject4 = this.sPZ;
    if (localObject4 == null) {
      d.g.b.p.bdF("postDataManager");
    }
    localObject4 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
    d.g.b.p.h(localObject3, "intent");
    d.g.b.p.h(localObject4, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.a)localObject2).intent = ((Intent)localObject3);
    ((com.tencent.mm.plugin.finder.upload.postui.a)localObject2).sVF = ((Bundle)localObject4);
    localObject4 = ((Intent)localObject3).getStringExtra("saveExtendReadingLink");
    localObject3 = ((Intent)localObject3).getStringExtra("saveExtendReadingTitle");
    if ((localObject4 != null) && (localObject3 != null)) {
      ((com.tencent.mm.plugin.finder.upload.postui.a)localObject2).sVE.gI((String)localObject4, (String)localObject3);
    }
    localObject2 = this.sPV;
    if (localObject2 == null) {
      d.g.b.p.bdF("originalWidget");
    }
    localObject3 = getIntent();
    d.g.b.p.g(localObject3, "intent");
    localObject4 = this.sPZ;
    if (localObject4 == null) {
      d.g.b.p.bdF("postDataManager");
    }
    localObject4 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
    d.g.b.p.h(localObject3, "intent");
    d.g.b.p.h(localObject4, "postData");
    ((com.tencent.mm.plugin.finder.upload.postui.c)localObject2).sVP.setVisibility(8);
    localObject2 = this.sPZ;
    if (localObject2 == null) {
      d.g.b.p.bdF("postDataManager");
    }
    localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject2).tpt;
    if (localObject2 == null)
    {
      if (localObject2 != null) {
        break label2400;
      }
      if (localObject2 != null) {
        break label2412;
      }
      label1985:
      if (localObject2 != null) {
        break label2441;
      }
      label1989:
      if (localObject2 != null) {
        break label2471;
      }
      label1993:
      localObject2 = this.sPS;
      if (localObject2 == null) {
        break label2523;
      }
      localObject3 = this.sPQ;
      if (localObject3 == null) {
        d.g.b.p.bdF("mediaViewContainer");
      }
      ((ViewGroup)localObject3).removeAllViews();
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject2).cRs();
      if (localObject2 != null) {
        break label2500;
      }
      localObject2 = this.sPQ;
      if (localObject2 == null) {
        d.g.b.p.bdF("mediaViewContainer");
      }
      ((ViewGroup)localObject2).setVisibility(8);
      label2051:
      localObject4 = this.sPZ;
      if (localObject4 == null) {
        d.g.b.p.bdF("postDataManager");
      }
      if ((((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpA == null) || (((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpk == null)) {
        break label2530;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.tps;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.cRp();
      localObject5 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpA;
      if (localObject5 == null) {
        d.g.b.p.gkB();
      }
      ((Bundle)localObject2).putByteArray((String)localObject3, ((FinderObjectDesc)localObject5).toByteArray());
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.tps;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.cRo();
      localObject5 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpk;
      if (localObject5 == null) {
        d.g.b.p.gkB();
      }
      ((Bundle)localObject2).putByteArray((String)localObject3, ((aqq)localObject5).toByteArray());
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.tps;
      ((Bundle)localObject2).putBoolean(com.tencent.mm.plugin.finder.widget.post.a.cRq(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).kWX);
      localObject2 = this.sPS;
      if (localObject2 != null)
      {
        localObject3 = this.sPZ;
        if (localObject3 == null) {
          d.g.b.p.bdF("postDataManager");
        }
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject2).af(((com.tencent.mm.plugin.finder.widget.post.c)localObject3).sVF);
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject2).refresh();
      }
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new q(this));
      cMG();
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
      i = com.tencent.mm.plugin.finder.storage.b.cKJ();
      localObject2 = com.tencent.mm.plugin.finder.utils.k.sWF;
      if ((com.tencent.mm.plugin.finder.utils.k.cNW()) && (i > 0))
      {
        localObject2 = new com.tencent.mm.plugin.finder.view.d((Context)getContext());
        localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
        com.tencent.mm.plugin.finder.storage.b.FI(i - 1);
        ((com.tencent.mm.plugin.finder.view.d)localObject2).GC(2131496520);
        localObject3 = (TextView)((com.tencent.mm.plugin.finder.view.d)localObject2).kFh.findViewById(2131308506);
        d.g.b.p.g(localObject3, "titleTv");
        d.g.b.p.h(localObject3, "$this$setTextBold");
        al.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
        ((com.tencent.mm.plugin.finder.view.d)localObject2).kFh.findViewById(2131307888).setOnClickListener((View.OnClickListener)new FinderPostUI.o((com.tencent.mm.plugin.finder.view.d)localObject2));
        ((com.tencent.mm.plugin.finder.view.d)localObject2).cPF();
      }
      AppMethodBeat.o(167530);
      return;
      if (((Integer)localObject2).intValue() != 2) {
        break;
      }
      for (;;)
      {
        this.sPS = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.d((Context)this, (byte)0));
        break label1993;
        label2400:
        if (((Integer)localObject2).intValue() != 7) {
          break;
        }
      }
      label2412:
      if (((Integer)localObject2).intValue() != 4) {
        break label1985;
      }
      this.sPS = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.g((Context)this));
      break label1993;
      label2441:
      if (((Integer)localObject2).intValue() != 8) {
        break label1989;
      }
      this.sPS = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.e((Context)this));
      break label1993;
      label2471:
      if (((Integer)localObject2).intValue() != 1) {
        break label1993;
      }
      this.sPS = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.f((Context)this));
      break label1993;
      label2500:
      localObject3 = this.sPQ;
      if (localObject3 == null) {
        d.g.b.p.bdF("mediaViewContainer");
      }
      ((ViewGroup)localObject3).addView((View)localObject2);
      break label2051;
      label2523:
      finish();
      break label2051;
      label2530:
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpt;
      if (localObject2 == null)
      {
        label2540:
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpt;
        if (localObject2 != null) {
          break label2794;
        }
        label2550:
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpt;
        if (localObject2 != null) {
          break label2816;
        }
      }
      label2673:
      label2806:
      label2811:
      while (((Integer)localObject2).intValue() != 4)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpt;
        if ((localObject2 == null) || (((Integer)localObject2).intValue() != 8)) {
          break;
        }
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putStringArrayList("MEDIA_FILE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpu);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putIntegerArrayList("MEDIA_TYPE_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpz);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpx);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putStringArrayList("MEDIA_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpy);
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putParcelable("vlog_crop_rect", (Parcelable)((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpB);
        break;
        if (((Integer)localObject2).intValue() != 2) {
          break label2540;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
        localObject3 = com.tencent.mm.plugin.finder.widget.post.d.tpL;
        ((Bundle)localObject2).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.cRu(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpu);
        if (((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpv != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpv;
          if (localObject2 == null) {
            break label2806;
          }
          localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
          localObject3 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpu;
          if (localObject3 == null) {
            break label2811;
          }
        }
        for (localObject3 = Integer.valueOf(((ArrayList)localObject3).size());; localObject3 = null)
        {
          if (d.g.b.p.i(localObject2, localObject3))
          {
            localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
            localObject3 = com.tencent.mm.plugin.finder.widget.post.d.tpL;
            ((Bundle)localObject2).putIntegerArrayList(com.tencent.mm.plugin.finder.widget.post.d.cRv(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpv);
          }
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF;
          localObject3 = com.tencent.mm.plugin.finder.widget.post.d.tpL;
          ((Bundle)localObject2).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.d.cRw(), ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpy);
          break;
          if (((Integer)localObject2).intValue() != 7) {
            break label2550;
          }
          break label2673;
          localObject2 = null;
          break label2721;
        }
      }
      label2721:
      label2794:
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putStringArrayList("video_file_list", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpu);
      label2816:
      if (((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpw != null) {
        ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putByteArray("video_composition", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpw);
      }
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpx);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putStringArrayList("VIDEO_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).tpy);
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putString("video_before_cut_path", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).intent.getStringExtra("select_video_path"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putString("VIDEO_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).intent.getStringExtra("VIDEO_COVER_URL"));
      ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).sVF.putInt("VIDEO_COVER_QUALITY", ((com.tencent.mm.plugin.finder.widget.post.c)localObject4).intent.getIntExtra("VIDEO_COVER_QUALITY", 0));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(167539);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.sQe)
    {
      if (paramIntent != null)
      {
        localObject1 = this.sPT;
        if (localObject1 == null) {
          d.g.b.p.bdF("locationWidget");
        }
        d.g.b.p.h(paramIntent, "i");
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject2).putExtra("saveLocation", true);
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject2).putExtra("get_poi_name", bu.bI(paramIntent.getStringExtra("get_poi_name"), ""));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject2).putExtra("get_city", bu.bI(paramIntent.getStringExtra("get_city"), ""));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject2).putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject2).putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
        localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject2).putExtra("get_poi_address", bu.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
        localObject1 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
        if (localObject1 == null) {
          d.g.b.p.bdF("intent");
        }
        ((Intent)localObject1).putExtra("get_poi_classify_id", bu.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
        paramIntent = this.sPT;
        if (paramIntent == null) {
          d.g.b.p.bdF("locationWidget");
        }
        paramIntent.cNA();
        paramIntent = this.sPT;
        if (paramIntent == null) {
          d.g.b.p.bdF("locationWidget");
        }
        paramIntent = paramIntent.sVJ;
        if (paramIntent != null)
        {
          if ((!bu.isNullOrNil(paramIntent.jGd)) || (!bu.isNullOrNil(paramIntent.eRg)))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
            com.tencent.mm.plugin.finder.report.g.a(2, paramIntent);
          }
          for (;;)
          {
            paramIntent = z.Nhr;
            AppMethodBeat.o(167539);
            return;
            localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
            com.tencent.mm.plugin.finder.report.g.a(3, paramIntent);
          }
        }
        AppMethodBeat.o(167539);
        return;
      }
      AppMethodBeat.o(167539);
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.finder.widget.post.g.tqn;
    label632:
    label637:
    int k;
    if (paramInt1 == com.tencent.mm.plugin.finder.widget.post.g.cRB())
    {
      if (paramIntent != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.widget.post.g.tqn;
        localObject1 = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.g.cRC());
        if (paramIntent != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.widget.post.g.tqn;
          localObject2 = Integer.valueOf(paramIntent.getIntExtra(com.tencent.mm.plugin.finder.widget.post.g.cRD(), 0));
        }
        if (bu.isNullOrNil((String)localObject1)) {
          break label1394;
        }
        paramIntent = this.sPZ;
        if (paramIntent == null) {
          d.g.b.p.bdF("postDataManager");
        }
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        if (localObject2 == null) {
          break label632;
        }
      }
      for (paramInt1 = ((Integer)localObject2).intValue();; paramInt1 = 0)
      {
        d.g.b.p.h(localObject1, "coverUrl");
        paramIntent.sVF.putString("VIDEO_COVER_URL", (String)localObject1);
        paramIntent.intent.putExtra("VIDEO_COVER_URL", (String)localObject1);
        paramIntent.sVF.putInt("VIDEO_COVER_QUALITY", paramInt1);
        paramIntent.intent.putExtra("VIDEO_COVER_QUALITY", paramInt1);
        paramIntent = this.sPS;
        if (paramIntent == null) {
          break label637;
        }
        localObject1 = this.sPZ;
        if (localObject1 == null) {
          d.g.b.p.bdF("postDataManager");
        }
        paramIntent.af(((com.tencent.mm.plugin.finder.widget.post.c)localObject1).sVF);
        paramIntent.refresh();
        paramIntent = z.Nhr;
        AppMethodBeat.o(167539);
        return;
        localObject1 = null;
        break;
      }
      AppMethodBeat.o(167539);
    }
    else if (paramInt1 == this.sQf)
    {
      showVKB();
      if (paramIntent != null)
      {
        k = paramIntent.getIntExtra("key_scene", 1);
        if (paramInt2 != -1) {
          break label1401;
        }
        paramInt1 = paramIntent.getIntExtra("key_source", 2);
        localObject2 = paramIntent.getByteArrayExtra("key_select_contact");
        if (localObject2 != null) {}
        for (;;)
        {
          try
          {
            paramIntent = new bvx();
            paramIntent.parseFrom((byte[])localObject2);
            localObject1 = z.Nhr;
            if (paramIntent == null) {
              break label1390;
            }
            if (bu.isNullOrNil(paramIntent.nickname)) {
              break label1386;
            }
            localObject1 = this.sQj;
            if (localObject1 == null) {
              d.g.b.p.bdF("styleManager");
            }
            localObject3 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cQI();
            localObject2 = paramIntent.username;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.finder.view.manager.a)localObject3).ba(paramInt1, (String)localObject1);
            localObject1 = this.sQj;
            if (localObject1 == null) {
              d.g.b.p.bdF("styleManager");
            }
            localObject3 = ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cQI().tjl;
            localObject2 = paramIntent.nickname;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((HashMap)localObject3).put(localObject1, paramIntent);
            localObject1 = this.sPO;
            if (localObject1 == null) {
              d.g.b.p.bdF("descTv");
            }
            paramInt2 = ((FinderPostEditText)localObject1).getSelectionEnd();
            localObject1 = this.sPO;
            if (localObject1 == null) {
              d.g.b.p.bdF("descTv");
            }
            localObject2 = ((FinderPostEditText)localObject1).getText().toString();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (k != 2) {
              break label1170;
            }
            localObject1 = this.sPO;
            if (localObject1 == null) {
              d.g.b.p.bdF("descTv");
            }
            k = ((FinderPostEditText)localObject1).getSelectionEnd();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (k <= 0) {
              break label1170;
            }
            paramInt2 = k - 1;
            paramInt1 = j;
            if ((paramInt2 < 0) || (paramInt1 == 0)) {
              break;
            }
            localObject1 = this.sPO;
            if (localObject1 == null) {
              d.g.b.p.bdF("descTv");
            }
            if (((FinderPostEditText)localObject1).getText().toString().charAt(paramInt2) != '@') {
              break label1025;
            }
            paramInt2 -= 1;
            continue;
          }
          catch (Exception paramIntent)
          {
            ae.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { paramIntent.getMessage() });
            paramIntent = (Intent)localObject1;
            continue;
          }
          paramIntent = null;
          continue;
          label1025:
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
          paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject3 = ((String)localObject2).substring(0, paramInt1);
        d.g.b.p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
        paramInt2 = ((String)localObject2).length();
        if (localObject2 == null)
        {
          paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject2 = ((String)localObject2).substring(k, paramInt2);
        d.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject2;
        label1170:
        if (paramInt1 <= ((String)localObject1).length()) {
          break label1721;
        }
        paramInt1 = ((String)localObject1).length();
      }
    }
    label1721:
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (localObject1 == null)
      {
        paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167539);
        throw paramIntent;
      }
      localObject3 = ((String)localObject1).substring(0, paramInt1);
      d.g.b.p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append('@').append(paramIntent.nickname).append(' ');
      paramInt2 = ((String)localObject1).length();
      if (localObject1 == null)
      {
        paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167539);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
      d.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = (String)localObject1;
      paramIntent = paramIntent.nickname;
      paramInt2 = i;
      if (paramIntent != null) {
        paramInt2 = paramIntent.length();
      }
      paramIntent = this.sPO;
      if (paramIntent == null) {
        d.g.b.p.bdF("descTv");
      }
      paramIntent.setText((CharSequence)localObject1);
      paramIntent = this.sPO;
      if (paramIntent == null) {
        d.g.b.p.bdF("descTv");
      }
      paramIntent.setSelection(paramInt2 + paramInt1 + 2);
      label1386:
      paramIntent = z.Nhr;
      label1390:
      label1394:
      label1401:
      do
      {
        do
        {
          paramIntent = z.Nhr;
          AppMethodBeat.o(167539);
          return;
          paramIntent = this.sQj;
          if (paramIntent == null) {
            d.g.b.p.bdF("styleManager");
          }
          com.tencent.mm.plugin.finder.view.manager.a.a(paramIntent.cQI());
        } while (k != 2);
        paramIntent = this.sPO;
        if (paramIntent == null) {
          d.g.b.p.bdF("descTv");
        }
        paramIntent = paramIntent.getText().toString();
        localObject1 = this.sPO;
        if (localObject1 == null) {
          d.g.b.p.bdF("descTv");
        }
        i = ((FinderPostEditText)localObject1).getSelectionEnd();
      } while (i <= 0);
      paramInt2 = i - 1;
      paramInt1 = 1;
      while ((paramInt2 >= 0) && (paramInt1 != 0))
      {
        localObject1 = this.sPO;
        if (localObject1 == null) {
          d.g.b.p.bdF("descTv");
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
          paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        localObject2 = paramIntent.substring(0, paramInt1);
        d.g.b.p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
        paramInt2 = paramIntent.length();
        if (paramIntent == null)
        {
          paramIntent = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167539);
          throw paramIntent;
        }
        paramIntent = paramIntent.substring(i, paramInt2);
        d.g.b.p.g(paramIntent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramIntent = paramIntent;
        localObject1 = this.sPO;
        if (localObject1 == null) {
          d.g.b.p.bdF("descTv");
        }
        ((FinderPostEditText)localObject1).setText((CharSequence)paramIntent);
        paramIntent = this.sPO;
        if (paramIntent == null) {
          d.g.b.p.bdF("descTv");
        }
        paramIntent.setSelection(paramInt1);
        break;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167533);
    com.tencent.mm.plugin.finder.upload.postui.a locala = this.sPU;
    if (locala == null) {
      d.g.b.p.bdF("extendReadingWidget");
    }
    if (locala.sVE.tjw) {
      locala.sVE.cQz();
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        cMH();
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
    this.sPZ = new com.tencent.mm.plugin.finder.widget.post.c(paramBundle);
    paramBundle = com.tencent.mm.model.v.aAK();
    d.g.b.p.g(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    this.sPN = paramBundle;
    if (bu.isNullOrNil(this.sPN)) {
      finish();
    }
    paramBundle = com.tencent.mm.plugin.finder.api.c.rPy;
    this.contact = c.a.ahT(this.sPN);
    initView();
    if (JJ())
    {
      paramBundle = com.tencent.mm.ui.component.a.KEX;
      ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).bZr();
    }
    AppMethodBeat.o(167528);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167542);
    super.onDestroy();
    Object localObject = this.sQj;
    if (localObject == null) {
      d.g.b.p.bdF("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.c)localObject).tjT;
    if (localObject == null) {
      d.g.b.p.bdF("topicSuggestManager");
    }
    ((com.tencent.mm.plugin.finder.view.manager.d)localObject).tjX = null;
    ((com.tencent.mm.plugin.finder.view.manager.d)localObject).tjY = null;
    com.tencent.mm.kernel.g.ajj().b(3875, (com.tencent.mm.ak.f)localObject);
    AppMethodBeat.o(167542);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(204692);
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 1))
    {
      int i;
      Object localObject;
      String str;
      if (this.sPX)
      {
        paramKeyEvent = this.sPO;
        if (paramKeyEvent == null) {
          d.g.b.p.bdF("descTv");
        }
        paramInt = paramKeyEvent.getSelectionStart();
        paramKeyEvent = this.sPO;
        if (paramKeyEvent == null) {
          d.g.b.p.bdF("descTv");
        }
        paramKeyEvent = paramKeyEvent.getText();
        d.g.b.p.g(paramKeyEvent, "descTv.text");
        paramKeyEvent = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
        i = n.b((CharSequence)paramKeyEvent, '@');
        if ((i >= paramKeyEvent.length()) || (i < 0)) {}
        for (;;)
        {
          this.sPX = false;
          AppMethodBeat.o(204692);
          return true;
          if (paramKeyEvent == null)
          {
            paramKeyEvent = new d.v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(204692);
            throw paramKeyEvent;
          }
          paramKeyEvent = paramKeyEvent.substring(0, i);
          d.g.b.p.g(paramKeyEvent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject = this.sPO;
          if (localObject == null) {
            d.g.b.p.bdF("descTv");
          }
          localObject = ((FinderPostEditText)localObject).getText();
          d.g.b.p.g(localObject, "descTv.text");
          localObject = (CharSequence)localObject;
          str = ((CharSequence)localObject).subSequence(paramInt, ((CharSequence)localObject).length()).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramKeyEvent).append(str);
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
          }
          paramKeyEvent.setText((CharSequence)((StringBuilder)localObject).toString());
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
          }
          paramKeyEvent.setSelection(i);
        }
      }
      if (this.sPY != null)
      {
        com.tencent.mm.plugin.finder.utils.b.a locala = this.sPY;
        StringBuilder localStringBuilder;
        if (locala != null)
        {
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
          }
          paramInt = paramKeyEvent.getSelectionStart();
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.p.g(paramKeyEvent, "descTv.text");
          localObject = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
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
            paramKeyEvent = new d.v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(204692);
            throw paramKeyEvent;
            label511:
            if (str == null)
            {
              paramKeyEvent = new d.v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(204692);
              throw paramKeyEvent;
            }
            paramKeyEvent = str.substring(i + 1);
            d.g.b.p.g(paramKeyEvent, "(this as java.lang.String).substring(startIndex)");
          }
          localObject = ((String)localObject).substring(0, paramInt);
          d.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localStringBuilder.append((String)localObject).append(paramKeyEvent);
          paramInt = locala.start;
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
          }
          paramKeyEvent.setText((CharSequence)localStringBuilder.toString());
          paramKeyEvent = this.sPO;
          if (paramKeyEvent == null) {
            d.g.b.p.bdF("descTv");
          }
          paramKeyEvent.setSelection(paramInt);
        }
        this.sPY = null;
        AppMethodBeat.o(204692);
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
              paramKeyEvent = new d.v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(204692);
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
    AppMethodBeat.o(204692);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167532);
    super.onResume();
    this.sQl = ar.dX((Context)getContext());
    com.tencent.mm.plugin.finder.upload.postui.a locala = this.sPU;
    if (locala == null) {
      d.g.b.p.bdF("extendReadingWidget");
    }
    locala.sVE.cQB();
    AppMethodBeat.o(167532);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167531);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.sQk))
    {
      com.tencent.mm.ui.tools.h localh = this.fSZ;
      if (localh == null) {
        d.g.b.p.bdF("keyboardHeightProvider");
      }
      localh.start();
      this.sQk = true;
    }
    AppMethodBeat.o(167531);
  }
  
  public final void s(String paramString, List<buf> paramList)
  {
    AppMethodBeat.i(167536);
    Object localObject1 = (Collection)paramList;
    int i;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
      i = 1;
    }
    while (i == 0)
    {
      ae.i(this.TAG, "get lbsLife success");
      localObject1 = this.sPT;
      if (localObject1 == null) {
        d.g.b.p.bdF("locationWidget");
      }
      paramList = (buf)j.jl(paramList);
      if (this.sPZ == null) {
        d.g.b.p.bdF("postDataManager");
      }
      d.g.b.p.h(paramList, "lbsLife");
      if (((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).isLoading)
      {
        ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVK = true;
        if (bu.isNullOrNil(paramString))
        {
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVL.fcS();
          paramString = com.tencent.mm.plugin.finder.report.g.syJ;
          com.tencent.mm.plugin.finder.report.g.a(0, ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVJ);
          AppMethodBeat.o(167536);
          return;
          i = 0;
        }
        else
        {
          Object localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bdF("intent");
          }
          ((Intent)localObject2).putExtra("saveLocation", true);
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bdF("intent");
          }
          ((Intent)localObject2).putExtra("get_poi_name", "");
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bdF("intent");
          }
          ((Intent)localObject2).putExtra("get_city", bu.nullAsNil(paramString));
          localObject2 = com.tencent.mm.ui.component.a.KEX;
          com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
          localObject2 = FinderGlobalLocationVM.cQL();
          Object localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject3 == null) {
            d.g.b.p.bdF("intent");
          }
          ((Intent)localObject3).putExtra("get_lat", ((Number)((d.o)localObject2).second).floatValue());
          localObject3 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject3 == null) {
            d.g.b.p.bdF("intent");
          }
          ((Intent)localObject3).putExtra("get_lng", ((Number)((d.o)localObject2).first).floatValue());
          localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (localObject2 == null) {
            d.g.b.p.bdF("intent");
          }
          ((Intent)localObject2).putExtra("get_poi_classify_type", paramList.nJA);
          paramList = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).intent;
          if (paramList == null) {
            d.g.b.p.bdF("intent");
          }
          paramList.putExtra("get_poi_classify_id", "");
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).cNA();
          paramList = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVJ;
          if (paramList != null)
          {
            localObject2 = ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVF;
            if (localObject2 == null) {
              d.g.b.p.bdF("postData");
            }
            localObject3 = com.tencent.mm.plugin.finder.widget.post.a.tps;
            ((Bundle)localObject2).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.cRm(), paramList.toByteArray());
          }
          ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVL.setSuggestView(paramString);
          paramString = com.tencent.mm.plugin.finder.report.g.syJ;
          com.tencent.mm.plugin.finder.report.g.a(1, ((com.tencent.mm.plugin.finder.upload.postui.b)localObject1).sVJ);
        }
      }
      else
      {
        AppMethodBeat.o(167536);
        return;
      }
    }
    paramString = this.sPT;
    if (paramString == null) {
      d.g.b.p.bdF("locationWidget");
    }
    paramString.isLoading = false;
    paramString.sVK = true;
    paramString.sVL.fcS();
    AppMethodBeat.o(167536);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(167535);
    Object localObject1 = this.sQg;
    if (localObject1 == null) {
      d.g.b.p.bdF("footer");
    }
    if (paramInt > 0) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      if ((paramInt > 0) && (paramInt != (int)((FinderPostFooter)localObject1).ten))
      {
        aa.aF(((FinderPostFooter)localObject1).getContext(), paramInt);
        ((FinderPostFooter)localObject1).ten = paramInt;
        localObject2 = new LinearLayout.LayoutParams(-1, (int)((FinderPostFooter)localObject1).ten);
        SmileyPanel localSmileyPanel = ((FinderPostFooter)localObject1).gXW;
        if (localSmileyPanel == null) {
          d.g.b.p.bdF("smileyPanel");
        }
        localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((FinderPostFooter)localObject1).teh;
      if (localObject2 == null) {
        d.g.b.p.bdF("smileyBtn");
      }
      localObject2 = ((ImageView)localObject2).getTag();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(167535);
      throw ((Throwable)localObject1);
    }
    paramBoolean = ((Boolean)localObject2).booleanValue();
    if ((i == 0) && (!paramBoolean))
    {
      localObject2 = ((FinderPostFooter)localObject1).iBX;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean)) {
        ((FinderPostFooter)localObject1).O(false, false);
      }
      localObject1 = this.sQg;
      if (localObject1 == null) {
        d.g.b.p.bdF("footer");
      }
      ((FinderPostFooter)localObject1).post((Runnable)new p(this));
      AppMethodBeat.o(167535);
      return;
      localObject2 = ((FinderPostFooter)localObject1).iBX;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderPostUI paramFinderPostUI, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(167507);
      FinderPostUI.p(this.sQn).scrollBy(0, this.sQo - this.sQp);
      AppMethodBeat.o(167507);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderPostUI$checkPostData$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(167508);
      FinderPostUI.h(this.sQn);
      AppMethodBeat.o(167508);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class c
    implements View.OnLayoutChangeListener
  {
    c(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167509);
      ae.i(FinderPostUI.b(this.sQn), "oldBottom " + paramInt8 + ", bottom " + paramInt4);
      if (paramInt8 != paramInt4) {
        FinderPostUI.v(this.sQn);
      }
      AppMethodBeat.o(167509);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167510);
      paramDialogInterface = Parcel.obtain();
      FinderPostUI.a(this.sQn, FinderPostUI.a(this.sQn).getText().toString());
      this.sQn.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      Object localObject = FinderPostUI.z(this.sQn).tpt;
      if (localObject == null)
      {
        localObject = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcv, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
      for (;;)
      {
        FinderPostUI.A(this.sQn);
        paramDialogInterface = com.tencent.mm.plugin.finder.report.g.syJ;
        com.tencent.mm.plugin.finder.report.g.an(4, true);
        AppMethodBeat.o(167510);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcw, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167511);
      paramDialogInterface = FinderPostUI.z(this.sQn).tpt;
      if (paramDialogInterface == null)
      {
        paramDialogInterface = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.ajA().set(am.a.Jcv, "");
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.g.syJ;
        com.tencent.mm.plugin.finder.report.g.an(4, false);
        FinderPostUI.A(this.sQn);
        AppMethodBeat.o(167511);
        return;
        if (paramDialogInterface.intValue() != 1) {
          break;
        }
        paramDialogInterface = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.ajA().set(am.a.Jcw, "");
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cur", "", "last", "invoke"})
  static final class f
    extends d.g.b.q
    implements m<Integer, Integer, z>
  {
    f(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      if (d.g.b.p.i(paramView, FinderPostUI.a(this.sQn)))
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
        FinderPostUI.p(this.sQn).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderPostUI.p(this.sQn).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"})
  static final class h
    implements View.OnKeyListener
  {
    h(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(204684);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.mu(paramInt);
      localb.bd(paramKeyEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
      if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
      {
        paramView = this.sQn;
        if (FinderPostUI.m(this.sQn) != ' ') {
          break label140;
        }
      }
      label140:
      for (boolean bool = true;; bool = false)
      {
        FinderPostUI.b(paramView, bool);
        if (!FinderPostUI.q(this.sQn)) {
          FinderPostUI.a(this.sQn, FinderPostUI.r(this.sQn));
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(204684);
        return false;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class i
    implements TextWatcher
  {
    i(int paramInt) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167514);
      int i = com.tencent.mm.ui.tools.f.cU(i * 2, String.valueOf(paramEditable)) / 2;
      i = i - i;
      FinderPostUI.a(this.sQn, true);
      label140:
      Object localObject;
      if (i / i >= 0.95D)
      {
        FinderPostUI.j(this.sQn).setText((CharSequence)(i + '/' + i));
        if (i > i)
        {
          FinderPostUI.j(this.sQn).setTextColor(this.sQn.getResources().getColor(2131099804));
          FinderPostUI.a(this.sQn, false);
          FinderPostUI.j(this.sQn).setVisibility(0);
          FinderPostUI.k(this.sQn);
          localObject = FinderPostUI.d(this.sQn);
          String str = String.valueOf(paramEditable);
          if (paramEditable == null) {
            d.g.b.p.gkB();
          }
          ((com.tencent.mm.plugin.finder.view.manager.c)localObject).a(str, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (com.tencent.mm.plugin.finder.storage.b.cIc())
          {
            i = FinderPostUI.d(this.sQn).cQH().tjW.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (i <= ((Number)com.tencent.mm.plugin.finder.storage.b.cIW().value()).intValue()) {
              break label376;
            }
            FinderPostUI.l(this.sQn).mu(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cId()) {
          break label473;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (((Number)com.tencent.mm.plugin.finder.storage.b.cJe().value()).intValue() == 1000) {
          break label390;
        }
        i = FinderPostUI.d(this.sQn).cQI().tjm.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (i < ((Number)com.tencent.mm.plugin.finder.storage.b.cJe().value()).intValue()) {
          break label390;
        }
        FinderPostUI.l(this.sQn).mv(false);
        AppMethodBeat.o(167514);
        return;
        FinderPostUI.j(this.sQn).setTextColor(this.sQn.getResources().getColor(2131099734));
        break;
        FinderPostUI.j(this.sQn).setText((CharSequence)"");
        FinderPostUI.j(this.sQn).setVisibility(8);
        break label140;
        label376:
        FinderPostUI.l(this.sQn).mu(true);
      }
      label390:
      FinderPostUI.l(this.sQn).mv(true);
      if ((FinderPostUI.m(this.sQn) == '@') && (FinderPostUI.n(this.sQn) == null))
      {
        ae.i(FinderPostUI.b(this.sQn), "at auto goto");
        paramEditable = new Intent();
        paramEditable.putExtra("key_scene", 2);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.d((MMActivity)this.sQn, paramEditable, FinderPostUI.o(this.sQn));
      }
      label473:
      AppMethodBeat.o(167514);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostUI$initView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      d.g.b.p.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = new Rect();
        FinderPostUI.a(this.sQn).getGlobalVisibleRect(paramView);
        ae.i(FinderPostUI.b(this.sQn), "rawY:" + paramMotionEvent.getRawY() + ", rect:" + paramView.toShortString());
        if ((paramMotionEvent.getRawY() < paramView.top) || (paramMotionEvent.getRawY() > paramView.bottom)) {
          FinderPostUI.c(this.sQn).setVisibility(8);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/ui/FinderPostUI$initView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(167515);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class k
    implements View.OnLayoutChangeListener
  {
    k(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(204686);
      paramView.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204685);
          ae.i(FinderPostUI.b(this.sQr.sQn), "descTv OnLayoutChangeListener");
          Object localObject1 = FinderPostUI.d(this.sQr.sQn).cQH();
          int i = FinderPostUI.e(this.sQr.sQn);
          if (((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sQi.getVisibility() == 0)
          {
            int j = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sPO.getSelectionStart();
            Object localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sPO.getLayout();
            int m = ((Layout)localObject2).getLineForOffset(j);
            int k = ((Layout)localObject2).getLineBaseline(m);
            m = ((Layout)localObject2).getLineAscent(m);
            int[] arrayOfInt = new int[2];
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sPO.getLocationOnScreen(arrayOfInt);
            Point localPoint = new Point();
            localPoint.x = ((int)((Layout)localObject2).getPrimaryHorizontal(j));
            localPoint.y = (k + m + arrayOfInt[1] - ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sPO.getScrollY());
            ae.i(com.tencent.mm.plugin.finder.view.manager.d.TAG, "onSelectionChangedListener point " + localPoint + ", actionbarHeight " + i);
            localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sQi.getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
              AppMethodBeat.o(204685);
              throw ((Throwable)localObject1);
            }
            localObject2 = (FrameLayout.LayoutParams)localObject2;
            ((FrameLayout.LayoutParams)localObject2).topMargin = (localPoint.y - i);
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).sQi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          AppMethodBeat.o(204685);
        }
      });
      AppMethodBeat.o(204686);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204687);
      FinderPostUI.f(this.sQn);
      AppMethodBeat.o(204687);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204688);
      if (FinderPostUI.g(this.sQn) == 0)
      {
        if (this.sQn.getIntent().getIntExtra("key_finder_post_from", -1) == 5)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.storage.b.sHP;
            int i = com.tencent.mm.plugin.finder.storage.b.cJd();
            if (i < 6)
            {
              paramMenuItem = com.tencent.mm.plugin.finder.storage.b.sHP;
              com.tencent.mm.plugin.finder.storage.b.FF(i + 1);
            }
          }
        }
        FinderPostUI.h(this.sQn);
      }
      AppMethodBeat.o(204688);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "open", "", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.b<Boolean, z>
  {
    n(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(FinderPostUI paramFinderPostUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167524);
      ae.i(FinderPostUI.b(this.sQn), "footer.height " + FinderPostUI.t(this.sQn).getHeight() + ", footer.oldHeight " + FinderPostUI.u(this.sQn));
      if (FinderPostUI.t(this.sQn).getVisibility() == 0)
      {
        if ((FinderPostUI.a(this.sQn).hasFocus()) && (FinderPostUI.t(this.sQn).getHeight() != FinderPostUI.u(this.sQn)))
        {
          FinderPostUI.a(this.sQn, FinderPostUI.t(this.sQn).getHeight());
          FinderPostUI.v(this.sQn);
        }
        FinderPostUI.w(this.sQn).addOnLayoutChangeListener(FinderPostUI.x(this.sQn));
        AppMethodBeat.o(167524);
        return;
      }
      if ((FinderPostUI.t(this.sQn).getVisibility() == 8) || (FinderPostUI.t(this.sQn).getHeight() == 0))
      {
        FinderPostUI.a(this.sQn, 0);
        FinderPostUI.p(this.sQn).scrollTo(0, 0);
        Object localObject = FinderPostUI.y(this.sQn).getLayoutParams();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(167524);
          throw ((Throwable)localObject);
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).height = 0;
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        FinderPostUI.y(this.sQn).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderPostUI.y(this.sQn).requestLayout();
        FinderPostUI.w(this.sQn).removeOnLayoutChangeListener(FinderPostUI.x(this.sQn));
      }
      AppMethodBeat.o(167524);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    q(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */