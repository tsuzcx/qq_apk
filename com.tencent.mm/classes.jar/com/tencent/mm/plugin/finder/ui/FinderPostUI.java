package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
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
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel;
import com.tencent.mm.plugin.finder.utils.n.a;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.plugin.finder.view.FinderExtendReadingView;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderPostFooter;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.b;
import com.tencent.mm.plugin.finder.view.FinderPostFooter.g;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.pluginsdk.location.LocationView;
import com.tencent.mm.pluginsdk.location.LocationView.a;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.a.m;
import d.v;
import d.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(17)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter$ITopicCallback;", "()V", "CHECK_POST_INTERVAL", "", "MAX_CHECK_POST_COUNT", "", "MENU_ID_POST", "REQUEST_CODE_PICK_LOCATION", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "actionBarHeight", "avatarIv", "Landroid/widget/ImageView;", "bottomSpace", "Landroid/view/View;", "checkPostTime", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "deleteAtStringByInter", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "edtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "extendReadingWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderExtendReadingWidget;", "footer", "Lcom/tencent/mm/plugin/finder/view/FinderPostFooter;", "footerContainer", "hasStartKeyBoardProvider", "", "isFromtOfAtOneEnd", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "mediaViewContainer", "Landroid/view/ViewGroup;", "mediaWidget", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "myFinderUser", "nickTv", "Landroid/widget/TextView;", "oldFooterHeight", "originalWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "scrollView", "Landroid/widget/ScrollView;", "styleManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "textCountTv", "textOk", "topicSuggestView", "Lcom/tencent/mm/plugin/finder/view/FinderTopicSuggestView;", "checkNeedScroll", "", "checkNextEnable", "checkPermission", "checkPostData", "deleteAtMemberFromEnd", "deleteAtMemberFromInter", "atStringInfo", "deleteInAtSomeoneInter", "exitAndSave", "getCharAtCursor", "", "getLayoutId", "initDescText", "initPostMediaWidget", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetLbsLifes", "city", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardHeightChanged", "height", "isResized", "onResume", "onTopicClick", "onWindowFocusChanged", "hasFocus", "requestLocation", "restore", "routeBack", "routeForward", "saveDescData", "desc", "selectMedia", "plugin-finder_release"})
public final class FinderPostUI
  extends MMFinderUI
  implements FinderPostFooter.g, a.a, com.tencent.mm.ui.tools.g
{
  private com.tencent.mm.plugin.finder.upload.a.b KYQ;
  private com.tencent.mm.plugin.finder.upload.a.a KYR;
  private com.tencent.mm.plugin.finder.upload.a.c KYS;
  private boolean KYT;
  private n.a KYU;
  private com.tencent.mm.plugin.finder.widget.post.g KYV;
  private final int KYW;
  private com.tencent.mm.plugin.finder.view.manager.d KYX;
  private final String TAG;
  private HashMap _$_findViewCache;
  private com.tencent.mm.plugin.finder.api.f contact;
  private p fqw;
  private com.tencent.mm.ui.tools.h ftZ;
  private ScrollView ftp;
  private ImageView fuj;
  private TextView inR;
  private final int qAD;
  private View qNL;
  private TextView qOA;
  private com.tencent.mm.plugin.finder.widget.post.a qOB;
  private ViewGroup qOC;
  private boolean qOP;
  private View qOS;
  private int qOT;
  private int qOU;
  private final int qOV;
  private final long qOW;
  private final int qOX;
  private FinderPostFooter qOY;
  private View qOZ;
  private String qOy;
  private FinderPostEditText qOz;
  private FinderTopicSuggestView qPa;
  private boolean qPd;
  private int qPe;
  private final View.OnLayoutChangeListener qPf;
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    this.TAG = "Finder.FinderPostUI";
    this.qOy = "";
    this.qOP = true;
    this.qOV = 10;
    this.qOW = 500L;
    this.qAD = 10000;
    this.qOX = 20000;
    this.KYW = 20001;
    this.qPf = ((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(167543);
  }
  
  private final boolean Is()
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
      ad.e(this.TAG, "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(167529);
      return true;
    }
    AppMethodBeat.o(167529);
    return false;
  }
  
  private final void cqT()
  {
    AppMethodBeat.i(167534);
    Object localObject = this.KYR;
    if (localObject == null) {
      d.g.b.k.aPZ("extendReadingWidget");
    }
    if (((com.tencent.mm.plugin.finder.upload.a.a)localObject).Lat.ctb())
    {
      localObject = this.KYV;
      if (localObject == null) {
        d.g.b.k.aPZ("postDataManager");
      }
      localObject = ((com.tencent.mm.plugin.finder.widget.post.g)localObject).LlN;
      if (localObject != null) {
        break label78;
      }
    }
    while (!this.qOP) {
      label78:
      do
      {
        enableOptionMenu(this.qAD, false);
        AppMethodBeat.o(167534);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = this.qOz;
        if (localObject == null) {
          d.g.b.k.aPZ("descTv");
        }
      } while (bt.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    localObject = this.qOB;
    if (localObject != null)
    {
      if ((localObject instanceof com.tencent.mm.plugin.finder.widget.post.e))
      {
        localObject = this.qOz;
        if (localObject == null) {
          d.g.b.k.aPZ("descTv");
        }
        localObject = ((FinderPostEditText)localObject).getText().toString();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(167534);
          throw ((Throwable)localObject);
        }
        if (bt.isNullOrNil(d.n.n.trim((CharSequence)localObject).toString()))
        {
          enableOptionMenu(this.qAD, false);
          AppMethodBeat.o(167534);
          return;
        }
      }
      enableOptionMenu(this.qAD, true);
      AppMethodBeat.o(167534);
      return;
    }
    enableOptionMenu(this.qAD, false);
    AppMethodBeat.o(167534);
  }
  
  private final void crq()
  {
    AppMethodBeat.i(167538);
    Object localObject = com.tencent.mm.plugin.finder.report.a.qFo;
    localObject = this.KYX;
    if (localObject == null) {
      d.g.b.k.aPZ("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.d)localObject).fXd().LgI;
    com.tencent.mm.plugin.finder.view.manager.d locald = this.KYX;
    if (locald == null) {
      d.g.b.k.aPZ("styleManager");
    }
    int i = locald.fXd().LgK;
    locald = this.KYX;
    if (locald == null) {
      d.g.b.k.aPZ("styleManager");
    }
    com.tencent.mm.plugin.finder.report.a.d((ArrayList)localObject, i, locald.fXd().LgL);
    localObject = this.KYV;
    if (localObject == null) {
      d.g.b.k.aPZ("postDataManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.widget.post.g)localObject).LlN;
    if (localObject == null) {}
    for (;;)
    {
      localObject = this.KYV;
      if (localObject == null) {
        d.g.b.k.aPZ("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.g)localObject).qOO == null)
      {
        localObject = this.KYV;
        if (localObject == null) {
          d.g.b.k.aPZ("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.g)localObject).LlT == null) {
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
        localObject = this.qOz;
        if (localObject == null) {
          d.g.b.k.aPZ("descTv");
        }
      } while (bt.isNullOrNil(((FinderPostEditText)localObject).getText().toString()));
    }
    com.tencent.mm.ui.base.h.a((Context)this, 2131759390, 0, 2131759392, 2131759391, true, (DialogInterface.OnClickListener)new d(this), (DialogInterface.OnClickListener)new e(this), 2131099903);
    AppMethodBeat.o(167538);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199330);
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
    AppMethodBeat.o(199330);
    return localView1;
  }
  
  public final void fVB()
  {
    AppMethodBeat.i(199323);
    Object localObject1 = this.qOz;
    if (localObject1 == null) {
      d.g.b.k.aPZ("descTv");
    }
    int i = ((FinderPostEditText)localObject1).getSelectionStart();
    localObject1 = this.qOz;
    if (localObject1 == null) {
      d.g.b.k.aPZ("descTv");
    }
    localObject1 = ((FinderPostEditText)localObject1).getText().toString();
    Object localObject2 = new StringBuilder();
    Object localObject3 = com.tencent.mm.plugin.finder.utils.h.qSR;
    localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.utils.h.crR());
    localObject3 = com.tencent.mm.plugin.finder.utils.h.qSR;
    localObject2 = com.tencent.mm.plugin.finder.utils.h.crR();
    if (i == 0) {
      localObject1 = (String)localObject2 + (String)localObject1;
    }
    for (;;)
    {
      localObject2 = this.qOz;
      if (localObject2 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
      localObject1 = this.qOz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject1).requestFocus();
      localObject1 = this.qOz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject1).setSelection(i + 1);
      AppMethodBeat.o(199323);
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
          AppMethodBeat.o(199323);
          throw ((Throwable)localObject1);
        }
        String str = ((String)localObject1).substring(0, i);
        d.g.b.k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = ((StringBuilder)localObject3).append(str).append((String)localObject2);
        int j = ((String)localObject1).length();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199323);
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
    this.qOC = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131303359);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_avatar)");
    this.fuj = ((ImageView)localObject1);
    localObject1 = findViewById(2131303369);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_nickname)");
    this.inR = ((TextView)localObject1);
    localObject1 = findViewById(2131303361);
    d.g.b.k.g(localObject1, "findViewById(R.id.post_desc_edt)");
    this.qOz = ((FinderPostEditText)localObject1);
    localObject1 = findViewById(2131304376);
    d.g.b.k.g(localObject1, "findViewById(R.id.scroll_view)");
    this.ftp = ((ScrollView)localObject1);
    localObject1 = findViewById(2131297467);
    d.g.b.k.g(localObject1, "findViewById(R.id.bottom_space)");
    this.qOS = ((View)localObject1);
    localObject1 = findViewById(2131299309);
    d.g.b.k.g(localObject1, "findViewById(R.id.edt_container)");
    this.qNL = ((View)localObject1);
    localObject1 = findViewById(2131306036);
    d.g.b.k.g(localObject1, "findViewById(R.id.topic_suggest_view)");
    this.qPa = ((FinderTopicSuggestView)localObject1);
    localObject1 = this.qPa;
    if (localObject1 == null) {
      d.g.b.k.aPZ("topicSuggestView");
    }
    Object localObject2 = this.qOz;
    if (localObject2 == null) {
      d.g.b.k.aPZ("descTv");
    }
    this.KYX = new com.tencent.mm.plugin.finder.view.manager.d((FinderTopicSuggestView)localObject1, (FinderPostEditText)localObject2, (MMActivity)this);
    localObject1 = (MMActivity)this;
    localObject2 = findViewById(2131307275);
    d.g.b.k.g(localObject2, "findViewById(R.id.choose_original_view)");
    this.KYS = new com.tencent.mm.plugin.finder.upload.a.c((MMActivity)localObject1, (FinderChooseOriginalView)localObject2);
    localObject1 = findViewById(2131300198);
    d.g.b.k.g(localObject1, "findViewById(R.id.footer_container)");
    this.qOZ = ((View)localObject1);
    localObject1 = this.qOZ;
    if (localObject1 == null) {
      d.g.b.k.aPZ("footerContainer");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = findViewById(2131299983);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_comment_footer)");
    this.qOY = ((FinderPostFooter)localObject1);
    localObject1 = this.qOY;
    if (localObject1 == null) {
      d.g.b.k.aPZ("footer");
    }
    localObject2 = (MMActivity)this;
    Object localObject3 = this.qOZ;
    if (localObject3 == null) {
      d.g.b.k.aPZ("footerContainer");
    }
    Object localObject4 = this.qOz;
    if (localObject4 == null) {
      d.g.b.k.aPZ("descTv");
    }
    localObject4 = (MMEditText)localObject4;
    final int i = this.KYW;
    Object localObject6 = (FinderPostFooter.g)this;
    d.g.b.k.h(localObject2, "activity");
    d.g.b.k.h(localObject3, "container");
    d.g.b.k.h(localObject4, "editText");
    d.g.b.k.h(localObject6, "iTopicCallback");
    ((FinderPostFooter)localObject1).activity = ((MMActivity)localObject2);
    ((FinderPostFooter)localObject1).hFi = ((View)localObject3);
    ((FinderPostFooter)localObject1).qVV = ((MMEditText)localObject4);
    ((FinderPostFooter)localObject1).jvX = i;
    ((FinderPostFooter)localObject1).Lfi = ((FinderPostFooter.g)localObject6);
    ((FinderPostFooter)localObject1).setOnClickListener((View.OnClickListener)FinderPostFooter.b.qXF);
    localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpO())
    {
      findViewById(2131306037).setOnTouchListener((View.OnTouchListener)new i(this));
      localObject1 = this.ftp;
      if (localObject1 == null) {
        d.g.b.k.aPZ("scrollView");
      }
      ((ScrollView)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)new j(this));
      localObject1 = this.qOY;
      if (localObject1 == null) {
        d.g.b.k.aPZ("footer");
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((FinderPostFooter)localObject1).qo(com.tencent.mm.plugin.finder.storage.b.fUh());
      this.ftZ = new com.tencent.mm.ui.tools.h((Activity)this);
      localObject1 = this.ftZ;
      if (localObject1 == null) {
        d.g.b.k.aPZ("keyboardHeightProvider");
      }
      ((com.tencent.mm.ui.tools.h)localObject1).setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)this);
      localObject1 = findViewById(2131305750);
      d.g.b.k.g(localObject1, "findViewById(R.id.textcount_hint)");
      this.qOA = ((TextView)localObject1);
      localObject1 = this.qOA;
      if (localObject1 == null) {
        d.g.b.k.aPZ("textCountTv");
      }
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = this.qOA;
      if (localObject1 == null) {
        d.g.b.k.aPZ("textCountTv");
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
      this.KYQ = new com.tencent.mm.plugin.finder.upload.a.b((MMActivity)localObject1, (LocationView)localObject2, (View)localObject3, (TextView)localObject4, this.qOX);
      localObject1 = this.contact;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject2 = com.tencent.mm.plugin.finder.loader.h.cmV();
        localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject1).field_avatarUrl);
        localObject4 = this.fuj;
        if (localObject4 == null) {
          d.g.b.k.aPZ("avatarIv");
        }
        localObject6 = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
        localObject2 = this.inR;
        if (localObject2 == null) {
          d.g.b.k.aPZ("nickTv");
        }
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getContext(), (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject1).Su()));
      }
      if (getIntent().getBooleanExtra("hideDescEdit", false))
      {
        localObject1 = this.qOz;
        if (localObject1 == null) {
          d.g.b.k.aPZ("descTv");
        }
        ((FinderPostEditText)localObject1).setVisibility(8);
      }
      setBackBtn((MenuItem.OnMenuItemClickListener)new l(this));
      addTextOptionMenu(this.qAD, getString(2131759300), (MenuItem.OnMenuItemClickListener)new n(this), null, r.b.FOM);
      enableOptionMenu(this.qAD, false);
      localObject1 = this.KYV;
      if (localObject1 == null) {
        d.g.b.k.aPZ("postDataManager");
      }
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlN;
      if (localObject1 != null) {
        break label1443;
      }
      label986:
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    }
    for (i = com.tencent.mm.plugin.finder.storage.b.cpn();; i = com.tencent.mm.plugin.finder.storage.b.cpo())
    {
      localObject1 = (TextWatcher)new h(this, i);
      localObject2 = this.qOz;
      if (localObject2 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject2).addTextChangedListener((TextWatcher)localObject1);
      localObject1 = this.qOz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject1).setOnSelectionChangedListener((m)new f(this));
      localObject1 = this.qOz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject1).setOnTouchListener((View.OnTouchListener)new g(this));
      localObject1 = this.qOz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject1).setOnKeyListener((View.OnKeyListener)new k(this));
      localObject1 = (MMActivity)this;
      localObject2 = findViewById(2131299633);
      d.g.b.k.g(localObject2, "findViewById(R.id.extend_reading_view)");
      this.KYR = new com.tencent.mm.plugin.finder.upload.a.a((MMActivity)localObject1, (FinderExtendReadingView)localObject2, (d.g.a.b)new m(this));
      localObject1 = this.KYV;
      if (localObject1 == null) {
        d.g.b.k.aPZ("postDataManager");
      }
      if (((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlT != null)
      {
        localObject1 = this.KYV;
        if (localObject1 == null) {
          d.g.b.k.aPZ("postDataManager");
        }
        if (((com.tencent.mm.plugin.finder.widget.post.g)localObject1).qOO != null)
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
      localObject2 = this.KYX;
      if (localObject2 == null) {
        d.g.b.k.aPZ("styleManager");
      }
      localObject2 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject2).fXd();
      d.g.b.k.h(localObject3, "atContactParcelList");
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (LocalFinderAtContactParcel)((Iterator)localObject3).next();
        try
        {
          localObject6 = com.tencent.mm.plugin.finder.utils.n.LaC;
          d.g.b.k.g(localObject4, "atContactParcel");
          localObject4 = com.tencent.mm.plugin.finder.utils.n.a((LocalFinderAtContactParcel)localObject4);
          ((com.tencent.mm.plugin.finder.view.manager.c)localObject2).LgH.put(((ebc)localObject4).nickname, localObject4);
        }
        catch (Exception localException)
        {
          ad.e(com.tencent.mm.plugin.finder.view.manager.c.TAG, "restoreAtContactMap transformToLocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
        }
      }
      localObject1 = this.qOY;
      if (localObject1 == null) {
        d.g.b.k.aPZ("footer");
      }
      ((FinderPostFooter)localObject1).yP(false);
      localObject1 = this.qPa;
      if (localObject1 == null) {
        d.g.b.k.aPZ("topicSuggestView");
      }
      ((FinderTopicSuggestView)localObject1).setVisibility(8);
      break;
      label1443:
      if (((Integer)localObject1).intValue() != 1) {
        break label986;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    }
    label1462:
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = this.qOz;
      if (localObject2 == null) {
        d.g.b.k.aPZ("descTv");
      }
      ((FinderPostEditText)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.KYQ;
    if (localObject1 == null) {
      d.g.b.k.aPZ("locationWidget");
    }
    localObject2 = getIntent();
    d.g.b.k.g(localObject2, "intent");
    localObject3 = this.KYV;
    if (localObject3 == null) {
      d.g.b.k.aPZ("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject3).Lau;
    d.g.b.k.h(localObject2, "intent");
    d.g.b.k.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent = ((Intent)localObject2);
    ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lau = ((Bundle)localObject3);
    ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lay.setVisibility(8);
    ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lax.setLocationName(((com.tencent.mm.plugin.finder.upload.a.b)localObject1).activity.getString(2131759251));
    ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lax.setOnClickLocationListener((LocationView.a)new com.tencent.mm.plugin.finder.upload.a.b.a((com.tencent.mm.plugin.finder.upload.a.b)localObject1));
    ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).fVM();
    localObject1 = this.KYR;
    if (localObject1 == null) {
      d.g.b.k.aPZ("extendReadingWidget");
    }
    localObject2 = getIntent();
    d.g.b.k.g(localObject2, "intent");
    localObject3 = this.KYV;
    if (localObject3 == null) {
      d.g.b.k.aPZ("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject3).Lau;
    d.g.b.k.h(localObject2, "intent");
    d.g.b.k.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.a.a)localObject1).intent = ((Intent)localObject2);
    ((com.tencent.mm.plugin.finder.upload.a.a)localObject1).Lau = ((Bundle)localObject3);
    localObject3 = ((Intent)localObject2).getStringExtra("saveExtendReadingLink");
    localObject2 = ((Intent)localObject2).getStringExtra("saveExtendReadingTitle");
    if ((localObject3 != null) && (localObject2 != null)) {
      ((com.tencent.mm.plugin.finder.upload.a.a)localObject1).Lat.gc((String)localObject3, (String)localObject2);
    }
    localObject1 = this.KYS;
    if (localObject1 == null) {
      d.g.b.k.aPZ("originalWidget");
    }
    localObject2 = getIntent();
    d.g.b.k.g(localObject2, "intent");
    localObject3 = this.KYV;
    if (localObject3 == null) {
      d.g.b.k.aPZ("postDataManager");
    }
    localObject3 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject3).Lau;
    d.g.b.k.h(localObject2, "intent");
    d.g.b.k.h(localObject3, "postData");
    ((com.tencent.mm.plugin.finder.upload.a.c)localObject1).LaB.setVisibility(8);
    localObject1 = this.KYV;
    if (localObject1 == null) {
      d.g.b.k.aPZ("postDataManager");
    }
    localObject1 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlN;
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
      localObject1 = this.qOB;
      if (localObject1 == null) {
        break label2248;
      }
      localObject2 = this.qOC;
      if (localObject2 == null) {
        d.g.b.k.aPZ("mediaViewContainer");
      }
      ((ViewGroup)localObject2).removeAllViews();
      localObject1 = ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).ctv();
      if (localObject1 != null) {
        break label2225;
      }
      localObject1 = this.qOC;
      if (localObject1 == null) {
        d.g.b.k.aPZ("mediaViewContainer");
      }
      ((ViewGroup)localObject1).setVisibility(8);
      label1903:
      localObject1 = this.KYV;
      if (localObject1 == null) {
        d.g.b.k.aPZ("postDataManager");
      }
      if ((((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlT == null) || (((com.tencent.mm.plugin.finder.widget.post.g)localObject1).qOO == null)) {
        break label2255;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.qZZ;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.ctt();
      Object localObject5 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlT;
      if (localObject5 == null) {
        d.g.b.k.fvU();
      }
      ((Bundle)localObject2).putByteArray((String)localObject3, ((FinderObjectDesc)localObject5).toByteArray());
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.qZZ;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.cts();
      localObject5 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).qOO;
      if (localObject5 == null) {
        d.g.b.k.fvU();
      }
      ((Bundle)localObject2).putByteArray((String)localObject3, ((akf)localObject5).toByteArray());
    }
    for (;;)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau;
      localObject3 = com.tencent.mm.plugin.finder.widget.post.a.qZZ;
      ((Bundle)localObject2).putBoolean(com.tencent.mm.plugin.finder.widget.post.a.ctu(), ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).jWw);
      localObject1 = this.qOB;
      if (localObject1 != null)
      {
        localObject2 = this.KYV;
        if (localObject2 == null) {
          d.g.b.k.aPZ("postDataManager");
        }
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).Y(((com.tencent.mm.plugin.finder.widget.post.g)localObject2).Lau);
        ((com.tencent.mm.plugin.finder.widget.post.a)localObject1).refresh();
      }
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new s(this));
      cqT();
      AppMethodBeat.o(167530);
      return;
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
      for (;;)
      {
        this.qOB = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.c((Context)this, (byte)0));
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
      this.qOB = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.f((Context)this));
      break label1845;
      label2166:
      if (((Integer)localObject1).intValue() != 8) {
        break label1841;
      }
      this.qOB = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.d((Context)this));
      break label1845;
      label2196:
      if (((Integer)localObject1).intValue() != 1) {
        break label1845;
      }
      this.qOB = ((com.tencent.mm.plugin.finder.widget.post.a)new com.tencent.mm.plugin.finder.widget.post.e((Context)this));
      break label1845;
      label2225:
      localObject2 = this.qOC;
      if (localObject2 == null) {
        d.g.b.k.aPZ("mediaViewContainer");
      }
      ((ViewGroup)localObject2).addView((View)localObject1);
      break label1903;
      label2248:
      finish();
      break label1903;
      label2255:
      localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlN;
      if (localObject2 == null)
      {
        label2264:
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlN;
        if (localObject2 != null) {
          break label2429;
        }
        label2273:
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlN;
        if (localObject2 != null) {
          break label2441;
        }
      }
      label2429:
      while (((Integer)localObject2).intValue() != 4)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlN;
        if ((localObject2 == null) || (((Integer)localObject2).intValue() != 8)) {
          break;
        }
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putStringArrayList("MEDIA_FILE_LIST", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Llb);
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putIntegerArrayList("MEDIA_TYPE_LIST", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlR);
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlP);
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putStringArrayList("MEDIA_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlQ);
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putParcelable("vlog_crop_rect", (Parcelable)((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlU);
        break;
        if (((Integer)localObject2).intValue() != 2) {
          break label2264;
        }
        for (;;)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau;
          localObject3 = com.tencent.mm.plugin.finder.widget.post.c.rai;
          ((Bundle)localObject2).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.c.ctw(), ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Llb);
          localObject2 = ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau;
          localObject3 = com.tencent.mm.plugin.finder.widget.post.c.rai;
          ((Bundle)localObject2).putStringArrayList(com.tencent.mm.plugin.finder.widget.post.c.ctx(), ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlQ);
          break;
          if (((Integer)localObject2).intValue() != 7) {
            break label2273;
          }
        }
      }
      label2441:
      ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putStringArrayList("video_file_list", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Llb);
      if (((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlO != null) {
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putByteArray("video_composition", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlO);
      }
      ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putParcelableArrayList("VIDEO_CROP_LIST", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlP);
      ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putStringArrayList("VIDEO_THUMB_LIST", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).LlQ);
      ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putString("video_before_cut_path", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).intent.getStringExtra("select_video_path"));
      ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putString("VIDEO_COVER_URL", ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).intent.getStringExtra("VIDEO_COVER_URL"));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(167539);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject3;
    if (paramInt1 == this.qOX)
    {
      if (paramIntent != null)
      {
        localObject1 = this.KYQ;
        if (localObject1 == null) {
          d.g.b.k.aPZ("locationWidget");
        }
        d.g.b.k.h(paramIntent, "i");
        localObject3 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject3).putExtra("saveLocation", true);
        localObject3 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject3).putExtra("get_poi_name", bt.by(paramIntent.getStringExtra("get_poi_name"), ""));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject3).putExtra("get_city", bt.by(paramIntent.getStringExtra("get_city"), ""));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject3).putExtra("get_lat", paramIntent.getFloatExtra("get_lat", -85.0F));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject3).putExtra("get_lng", paramIntent.getFloatExtra("get_lng", -1000.0F));
        localObject3 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject3).putExtra("get_poi_address", bt.nullAsNil(paramIntent.getStringExtra("get_poi_address")));
        localObject1 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localObject1 == null) {
          d.g.b.k.aPZ("intent");
        }
        ((Intent)localObject1).putExtra("get_poi_classify_id", bt.nullAsNil(paramIntent.getStringExtra("get_poi_classify_id")));
        paramIntent = this.KYQ;
        if (paramIntent == null) {
          d.g.b.k.aPZ("locationWidget");
        }
        paramIntent.fVM();
        paramIntent = this.KYQ;
        if (paramIntent == null) {
          d.g.b.k.aPZ("locationWidget");
        }
        paramIntent = paramIntent.Law;
        if (paramIntent != null)
        {
          if ((!bt.isNullOrNil(paramIntent.goQ)) || (!bt.isNullOrNil(paramIntent.evA)))
          {
            localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
            com.tencent.mm.plugin.finder.report.a.a(2, paramIntent);
          }
          for (;;)
          {
            paramIntent = y.JfV;
            AppMethodBeat.o(167539);
            return;
            localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
            com.tencent.mm.plugin.finder.report.a.a(3, paramIntent);
          }
        }
        AppMethodBeat.o(167539);
        return;
      }
      AppMethodBeat.o(167539);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.widget.post.f.raH;
    if (paramInt1 == com.tencent.mm.plugin.finder.widget.post.f.fXN())
    {
      if (paramIntent != null) {
        localObject1 = com.tencent.mm.plugin.finder.widget.post.f.raH;
      }
      for (paramIntent = paramIntent.getStringExtra(com.tencent.mm.plugin.finder.widget.post.f.fXO());; paramIntent = null)
      {
        if (bt.isNullOrNil(paramIntent)) {
          break label1287;
        }
        localObject1 = this.KYV;
        if (localObject1 == null) {
          d.g.b.k.aPZ("postDataManager");
        }
        if (paramIntent == null) {
          d.g.b.k.fvU();
        }
        d.g.b.k.h(paramIntent, "coverUrl");
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau.putString("VIDEO_COVER_URL", paramIntent);
        ((com.tencent.mm.plugin.finder.widget.post.g)localObject1).intent.putExtra("VIDEO_COVER_URL", paramIntent);
        paramIntent = this.qOB;
        if (paramIntent == null) {
          break;
        }
        localObject1 = this.KYV;
        if (localObject1 == null) {
          d.g.b.k.aPZ("postDataManager");
        }
        paramIntent.Y(((com.tencent.mm.plugin.finder.widget.post.g)localObject1).Lau);
        paramIntent.refresh();
        paramIntent = y.JfV;
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
    if (paramInt1 == this.KYW)
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
            paramIntent = new ebc();
            paramIntent.parseFrom((byte[])localObject1);
            localObject1 = y.JfV;
            if (paramIntent == null) {
              break label1283;
            }
            if (bt.isNullOrNil(paramIntent.nickname)) {
              break label1279;
            }
            localObject1 = this.KYX;
            if (localObject1 == null) {
              d.g.b.k.aPZ("styleManager");
            }
            localObject1 = ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).fXd();
            localObject3 = paramIntent.username;
            d.g.b.k.g(localObject3, "atContact.username");
            ((com.tencent.mm.plugin.finder.view.manager.c)localObject1).cV(paramInt1, (String)localObject3);
            localObject1 = this.KYX;
            if (localObject1 == null) {
              d.g.b.k.aPZ("styleManager");
            }
            ((com.tencent.mm.plugin.finder.view.manager.d)localObject1).fXd().LgH.put(paramIntent.nickname, paramIntent);
            localObject1 = this.qOz;
            if (localObject1 == null) {
              d.g.b.k.aPZ("descTv");
            }
            paramInt2 = ((FinderPostEditText)localObject1).getSelectionEnd();
            localObject1 = this.qOz;
            if (localObject1 == null) {
              d.g.b.k.aPZ("descTv");
            }
            localObject3 = ((FinderPostEditText)localObject1).getText().toString();
            paramInt1 = paramInt2;
            localObject1 = localObject3;
            if (j != 2) {
              break label1072;
            }
            localObject1 = this.qOz;
            if (localObject1 == null) {
              d.g.b.k.aPZ("descTv");
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
            localObject1 = this.qOz;
            if (localObject1 == null) {
              d.g.b.k.aPZ("descTv");
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
            ad.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { localException.getMessage() });
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
      paramIntent = this.qOz;
      if (paramIntent == null) {
        d.g.b.k.aPZ("descTv");
      }
      paramIntent.setText((CharSequence)localObject2);
      paramIntent = this.qOz;
      if (paramIntent == null) {
        d.g.b.k.aPZ("descTv");
      }
      paramIntent.setSelection(paramInt2 + paramInt1 + 2);
      label1279:
      paramIntent = y.JfV;
      do
      {
        do
        {
          paramIntent = y.JfV;
          AppMethodBeat.o(167539);
          return;
          paramIntent = this.KYX;
          if (paramIntent == null) {
            d.g.b.k.aPZ("styleManager");
          }
          com.tencent.mm.plugin.finder.view.manager.c.a(paramIntent.fXd());
        } while (j != 2);
        paramIntent = this.qOz;
        if (paramIntent == null) {
          d.g.b.k.aPZ("descTv");
        }
        paramIntent = paramIntent.getText().toString();
        localObject2 = this.qOz;
        if (localObject2 == null) {
          d.g.b.k.aPZ("descTv");
        }
        i = ((FinderPostEditText)localObject2).getSelectionEnd();
      } while (i <= 0);
      paramInt2 = i - 1;
      paramInt1 = 1;
      while ((paramInt2 >= 0) && (paramInt1 != 0))
      {
        localObject2 = this.qOz;
        if (localObject2 == null) {
          d.g.b.k.aPZ("descTv");
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
        localObject2 = this.qOz;
        if (localObject2 == null) {
          d.g.b.k.aPZ("descTv");
        }
        ((FinderPostEditText)localObject2).setText((CharSequence)paramIntent);
        paramIntent = this.qOz;
        if (paramIntent == null) {
          d.g.b.k.aPZ("descTv");
        }
        paramIntent.setSelection(paramInt1);
        break;
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167533);
    com.tencent.mm.plugin.finder.upload.a.a locala = this.KYR;
    if (locala == null) {
      d.g.b.k.aPZ("extendReadingWidget");
    }
    if (locala.Lat.qYQ) {
      locala.Lat.csZ();
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        crq();
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
    this.KYV = new com.tencent.mm.plugin.finder.widget.post.g(paramBundle);
    paramBundle = u.aqO();
    d.g.b.k.g(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    this.qOy = paramBundle;
    if (bt.isNullOrNil(this.qOy)) {
      finish();
    }
    paramBundle = com.tencent.mm.plugin.finder.api.b.qnX;
    this.contact = com.tencent.mm.plugin.finder.api.b.a.YL(this.qOy);
    initView();
    if (Is())
    {
      paramBundle = com.tencent.mm.ui.component.a.LCX;
      ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class)).bMk();
    }
    AppMethodBeat.o(167528);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167542);
    super.onDestroy();
    Object localObject = this.KYX;
    if (localObject == null) {
      d.g.b.k.aPZ("styleManager");
    }
    localObject = ((com.tencent.mm.plugin.finder.view.manager.d)localObject).LgP;
    if (localObject == null) {
      d.g.b.k.aPZ("topicSuggestManager");
    }
    ((com.tencent.mm.plugin.finder.view.manager.b)localObject).qZp = null;
    ((com.tencent.mm.plugin.finder.view.manager.b)localObject).qZq = null;
    com.tencent.mm.kernel.g.aeS().b(3875, (com.tencent.mm.al.g)localObject);
    AppMethodBeat.o(167542);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(199322);
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 1))
    {
      int i;
      Object localObject;
      String str;
      if (this.KYT)
      {
        paramKeyEvent = this.qOz;
        if (paramKeyEvent == null) {
          d.g.b.k.aPZ("descTv");
        }
        paramInt = paramKeyEvent.getSelectionStart();
        paramKeyEvent = this.qOz;
        if (paramKeyEvent == null) {
          d.g.b.k.aPZ("descTv");
        }
        paramKeyEvent = paramKeyEvent.getText();
        d.g.b.k.g(paramKeyEvent, "descTv.text");
        paramKeyEvent = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
        i = d.n.n.b((CharSequence)paramKeyEvent, '@');
        if ((i >= paramKeyEvent.length()) || (i < 0)) {}
        for (;;)
        {
          this.KYT = false;
          AppMethodBeat.o(199322);
          return true;
          if (paramKeyEvent == null)
          {
            paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(199322);
            throw paramKeyEvent;
          }
          paramKeyEvent = paramKeyEvent.substring(0, i);
          d.g.b.k.g(paramKeyEvent, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localObject = this.qOz;
          if (localObject == null) {
            d.g.b.k.aPZ("descTv");
          }
          localObject = ((FinderPostEditText)localObject).getText();
          d.g.b.k.g(localObject, "descTv.text");
          localObject = (CharSequence)localObject;
          str = ((CharSequence)localObject).subSequence(paramInt, ((CharSequence)localObject).length()).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramKeyEvent).append(str);
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramKeyEvent.setText((CharSequence)((StringBuilder)localObject).toString());
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramKeyEvent.setSelection(i);
        }
      }
      if (this.KYU != null)
      {
        n.a locala = this.KYU;
        StringBuilder localStringBuilder;
        if (locala != null)
        {
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramInt = paramKeyEvent.getSelectionStart();
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.k.g(paramKeyEvent, "descTv.text");
          localObject = ((CharSequence)paramKeyEvent).subSequence(0, paramInt).toString();
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramKeyEvent = paramKeyEvent.getText();
          d.g.b.k.g(paramKeyEvent, "descTv.text");
          paramKeyEvent = (CharSequence)paramKeyEvent;
          str = paramKeyEvent.subSequence(paramInt, paramKeyEvent.length()).toString();
          localStringBuilder = new StringBuilder();
          i = d.n.n.a((CharSequence)str, ' ', 0, 6);
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
            AppMethodBeat.o(199322);
            throw paramKeyEvent;
            label511:
            if (str == null)
            {
              paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(199322);
              throw paramKeyEvent;
            }
            paramKeyEvent = str.substring(i + 1);
            d.g.b.k.g(paramKeyEvent, "(this as java.lang.String).substring(startIndex)");
          }
          localObject = ((String)localObject).substring(0, paramInt);
          d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localStringBuilder.append((String)localObject).append(paramKeyEvent);
          paramInt = locala.start;
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramKeyEvent.setText((CharSequence)localStringBuilder.toString());
          paramKeyEvent = this.qOz;
          if (paramKeyEvent == null) {
            d.g.b.k.aPZ("descTv");
          }
          paramKeyEvent.setSelection(paramInt);
        }
        this.KYU = null;
        AppMethodBeat.o(199322);
        return true;
        label649:
        i = d.n.n.b((CharSequence)localObject, '@');
        if ((i >= ((String)localObject).length()) || (i < 0)) {}
        for (;;)
        {
          localStringBuilder.append((String)localObject).append(paramKeyEvent);
          break;
          int j = d.n.n.b((CharSequence)localObject, ' ');
          if ((j <= i) || (j >= ((String)localObject).length()))
          {
            if (localObject == null)
            {
              paramKeyEvent = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(199322);
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
    AppMethodBeat.o(199322);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167532);
    super.onResume();
    this.qPe = ap.dL((Context)getContext());
    com.tencent.mm.plugin.finder.upload.a.a locala = this.KYR;
    if (locala == null) {
      d.g.b.k.aPZ("extendReadingWidget");
    }
    locala.Lat.ctc();
    AppMethodBeat.o(167532);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(167531);
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.qPd))
    {
      com.tencent.mm.ui.tools.h localh = this.ftZ;
      if (localh == null) {
        d.g.b.k.aPZ("keyboardHeightProvider");
      }
      localh.start();
      this.qPd = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(167531);
  }
  
  public final void r(String paramString, List<blc> paramList)
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
      localObject1 = this.KYQ;
      if (localObject1 == null) {
        d.g.b.k.aPZ("locationWidget");
      }
      Object localObject2 = (blc)d.a.j.iy(paramList);
      paramList = this.KYV;
      if (paramList == null) {
        d.g.b.k.aPZ("postDataManager");
      }
      Object localObject3 = paramList.LlS;
      d.g.b.k.h(localObject2, "lbsLife");
      Intent localIntent;
      if (((com.tencent.mm.plugin.finder.upload.a.b)localObject1).isLoading)
      {
        if (bt.isNullOrNil(paramString))
        {
          ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lax.fZF();
          paramString = com.tencent.mm.plugin.finder.report.a.qFo;
          com.tencent.mm.plugin.finder.report.a.a(0, ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Law);
          AppMethodBeat.o(167536);
          return;
          i = 0;
          continue;
        }
        paramList = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (paramList == null) {
          d.g.b.k.aPZ("intent");
        }
        paramList.putExtra("saveLocation", true);
        paramList = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (paramList == null) {
          d.g.b.k.aPZ("intent");
        }
        paramList.putExtra("get_poi_name", "");
        paramList = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (paramList == null) {
          d.g.b.k.aPZ("intent");
        }
        paramList.putExtra("get_city", bt.nullAsNil(paramString));
        localIntent = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localIntent == null) {
          d.g.b.k.aPZ("intent");
        }
        if (localObject3 == null) {
          break label417;
        }
        paramList = ((com.tencent.mm.plugin.finder.utils.j)localObject3).qTd;
        localIntent.putExtra("get_lat", (Serializable)paramList);
        localIntent = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (localIntent == null) {
          d.g.b.k.aPZ("intent");
        }
        if (localObject3 == null) {
          break label422;
        }
      }
      label417:
      label422:
      for (paramList = ((com.tencent.mm.plugin.finder.utils.j)localObject3).qTe;; paramList = null)
      {
        localIntent.putExtra("get_lng", (Serializable)paramList);
        paramList = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).intent;
        if (paramList == null) {
          d.g.b.k.aPZ("intent");
        }
        paramList.putExtra("get_poi_classify_id", ((blc)localObject2).ubw);
        ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).fVM();
        paramList = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Law;
        if (paramList != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lau;
          if (localObject2 == null) {
            d.g.b.k.aPZ("postData");
          }
          localObject3 = com.tencent.mm.plugin.finder.widget.post.a.qZZ;
          ((Bundle)localObject2).putByteArray(com.tencent.mm.plugin.finder.widget.post.a.ctq(), paramList.toByteArray());
        }
        ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Lax.setSuggestView(paramString);
        paramString = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.a(1, ((com.tencent.mm.plugin.finder.upload.a.b)localObject1).Law);
        AppMethodBeat.o(167536);
        return;
        paramList = null;
        break;
      }
    }
    paramString = this.KYQ;
    if (paramString == null) {
      d.g.b.k.aPZ("locationWidget");
    }
    paramString.isLoading = false;
    paramString.Lax.fZF();
    AppMethodBeat.o(167536);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(167535);
    Object localObject1 = this.qOY;
    if (localObject1 == null) {
      d.g.b.k.aPZ("footer");
    }
    if (paramInt > 0) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      if ((paramInt > 0) && (paramInt != (int)((FinderPostFooter)localObject1).qWa))
      {
        z.aw(((FinderPostFooter)localObject1).getContext(), paramInt);
        ((FinderPostFooter)localObject1).qWa = paramInt;
        localObject2 = new LinearLayout.LayoutParams(-1, (int)((FinderPostFooter)localObject1).qWa);
        SmileyPanel localSmileyPanel = ((FinderPostFooter)localObject1).qVT;
        if (localSmileyPanel == null) {
          d.g.b.k.aPZ("smileyPanel");
        }
        localSmileyPanel.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      localObject2 = ((FinderPostFooter)localObject1).qVU;
      if (localObject2 == null) {
        d.g.b.k.aPZ("smileyBtn");
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
      localObject2 = ((FinderPostFooter)localObject1).hFi;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean)) {
        ((FinderPostFooter)localObject1).K(false, false);
      }
      localObject1 = this.qOY;
      if (localObject1 == null) {
        d.g.b.k.aPZ("footer");
      }
      ((FinderPostFooter)localObject1).post((Runnable)new q(this));
      AppMethodBeat.o(167535);
      return;
      localObject2 = ((FinderPostFooter)localObject1).hFi;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderPostUI paramFinderPostUI, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(167507);
      FinderPostUI.r(this.qPg).scrollBy(0, this.qPh - this.qPi);
      AppMethodBeat.o(167507);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderPostUI$checkPostData$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(167508);
      FinderPostUI.k(this.qPg);
      AppMethodBeat.o(167508);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class c
    implements View.OnLayoutChangeListener
  {
    c(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167509);
      ad.i(FinderPostUI.b(this.qPg), "oldBottom " + paramInt8 + ", bottom " + paramInt4);
      if (paramInt8 != paramInt4) {
        FinderPostUI.v(this.qPg);
      }
      AppMethodBeat.o(167509);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167510);
      paramDialogInterface = Parcel.obtain();
      FinderPostUI.a(this.qPg, FinderPostUI.a(this.qPg).getText().toString());
      this.qPg.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      Object localObject = FinderPostUI.z(this.qPg).LlN;
      if (localObject == null)
      {
        localObject = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwU, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
      for (;;)
      {
        FinderPostUI.B(this.qPg);
        AppMethodBeat.o(167510);
        return;
        if (((Integer)localObject).intValue() != 1) {
          break;
        }
        localObject = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwV, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(FinderPostUI paramFinderPostUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167511);
      paramDialogInterface = FinderPostUI.z(this.qPg).LlN;
      if (paramDialogInterface == null)
      {
        paramDialogInterface = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.afk().set(ae.a.FwU, "");
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.CL(4);
        FinderPostUI.B(this.qPg);
        AppMethodBeat.o(167511);
        return;
        if (paramDialogInterface.intValue() != 1) {
          break;
        }
        paramDialogInterface = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramDialogInterface, "MMKernel.storage()");
        paramDialogInterface.afk().set(ae.a.FwV, "");
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cur", "", "last", "invoke"})
  static final class f
    extends d.g.b.l
    implements m<Integer, Integer, y>
  {
    f(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class g
    implements View.OnTouchListener
  {
    g(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167513);
      if (d.g.b.k.g(paramView, FinderPostUI.a(this.qPg)))
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
        FinderPostUI.r(this.qPg).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderPostUI.r(this.qPg).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderPostUI$initDescText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class h
    implements TextWatcher
  {
    h(int paramInt) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167514);
      int i = com.tencent.mm.ui.tools.f.cJ(i * 2, String.valueOf(paramEditable)) / 2;
      i = i - i;
      FinderPostUI.a(this.qPg, true);
      label140:
      Object localObject;
      if (i / i >= 0.95D)
      {
        FinderPostUI.o(this.qPg).setText((CharSequence)(i + '/' + i));
        if (i > i)
        {
          FinderPostUI.o(this.qPg).setTextColor(this.qPg.getResources().getColor(2131099804));
          FinderPostUI.a(this.qPg, false);
          FinderPostUI.o(this.qPg).setVisibility(0);
          FinderPostUI.p(this.qPg);
          localObject = FinderPostUI.d(this.qPg);
          String str = String.valueOf(paramEditable);
          if (paramEditable == null) {
            d.g.b.k.fvU();
          }
          ((com.tencent.mm.plugin.finder.view.manager.d)localObject).a(str, paramEditable);
          paramEditable = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (com.tencent.mm.plugin.finder.storage.b.cpO())
          {
            i = FinderPostUI.d(this.qPg).fXc().qZo.size();
            paramEditable = com.tencent.mm.plugin.finder.storage.b.qJA;
            if (i <= com.tencent.mm.plugin.finder.storage.b.cpL()) {
              break label349;
            }
            FinderPostUI.g(this.qPg).yP(false);
          }
        }
      }
      for (;;)
      {
        paramEditable = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (!com.tencent.mm.plugin.finder.storage.b.fUh()) {
          break label446;
        }
        paramEditable = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUj() == 1000) {
          break label363;
        }
        i = FinderPostUI.d(this.qPg).fXd().LgI.size();
        paramEditable = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (i < com.tencent.mm.plugin.finder.storage.b.fUj()) {
          break label363;
        }
        FinderPostUI.g(this.qPg).qo(false);
        AppMethodBeat.o(167514);
        return;
        FinderPostUI.o(this.qPg).setTextColor(this.qPg.getResources().getColor(2131099734));
        break;
        FinderPostUI.o(this.qPg).setText((CharSequence)"");
        FinderPostUI.o(this.qPg).setVisibility(8);
        break label140;
        label349:
        FinderPostUI.g(this.qPg).yP(true);
      }
      label363:
      FinderPostUI.g(this.qPg).qo(true);
      if ((FinderPostUI.h(this.qPg) == '@') && (FinderPostUI.l(this.qPg) == null))
      {
        ad.i(FinderPostUI.b(this.qPg), "at auto goto");
        paramEditable = new Intent();
        paramEditable.putExtra("key_scene", 2);
        localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.c((MMActivity)this.qPg, paramEditable, FinderPostUI.m(this.qPg));
      }
      label446:
      AppMethodBeat.o(167514);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class i
    implements View.OnTouchListener
  {
    i(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167515);
      d.g.b.k.g(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        paramView = new Rect();
        FinderPostUI.a(this.qPg).getGlobalVisibleRect(paramView);
        ad.i(FinderPostUI.b(this.qPg), "rawY:" + paramMotionEvent.getRawY() + ", rect:" + paramView.toShortString());
        if ((paramMotionEvent.getRawY() < paramView.top) || (paramMotionEvent.getRawY() > paramView.bottom)) {
          FinderPostUI.c(this.qPg).setVisibility(8);
        }
      }
      AppMethodBeat.o(167515);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class j
    implements View.OnLayoutChangeListener
  {
    j(FinderPostUI paramFinderPostUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(199318);
      paramView.post((Runnable)new FinderPostUI.j.1(this));
      AppMethodBeat.o(199318);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey"})
  static final class k
    implements View.OnKeyListener
  {
    k(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(199316);
      if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
      {
        paramView = this.qPg;
        if (FinderPostUI.h(this.qPg) != ' ') {
          break label83;
        }
      }
      label83:
      for (boolean bool = true;; bool = false)
      {
        FinderPostUI.b(paramView, bool);
        if (!FinderPostUI.q(this.qPg)) {
          FinderPostUI.a(this.qPg, FinderPostUI.s(this.qPg));
        }
        AppMethodBeat.o(199316);
        return false;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199319);
      FinderPostUI.i(this.qPg);
      AppMethodBeat.o(199319);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "open", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    m(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(FinderPostUI paramFinderPostUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199320);
      if (FinderPostUI.j(this.qPg) == 0) {
        FinderPostUI.k(this.qPg);
      }
      AppMethodBeat.o(199320);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(FinderPostUI paramFinderPostUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167524);
      ad.i(FinderPostUI.b(this.qPg), "footer.height " + FinderPostUI.e(this.qPg).getHeight() + ", footer.oldHeight " + FinderPostUI.u(this.qPg));
      if (FinderPostUI.e(this.qPg).getVisibility() == 0)
      {
        if ((FinderPostUI.a(this.qPg).hasFocus()) && (FinderPostUI.e(this.qPg).getHeight() != FinderPostUI.u(this.qPg)))
        {
          FinderPostUI.a(this.qPg, FinderPostUI.e(this.qPg).getHeight());
          FinderPostUI.v(this.qPg);
        }
        FinderPostUI.w(this.qPg).addOnLayoutChangeListener(FinderPostUI.x(this.qPg));
        AppMethodBeat.o(167524);
        return;
      }
      if ((FinderPostUI.e(this.qPg).getVisibility() == 8) || (FinderPostUI.e(this.qPg).getHeight() == 0))
      {
        FinderPostUI.a(this.qPg, 0);
        FinderPostUI.r(this.qPg).scrollTo(0, 0);
        Object localObject = FinderPostUI.y(this.qPg).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(167524);
          throw ((Throwable)localObject);
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).height = 0;
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        FinderPostUI.y(this.qPg).setLayoutParams((ViewGroup.LayoutParams)localObject);
        FinderPostUI.y(this.qPg).requestLayout();
        FinderPostUI.w(this.qPg).removeOnLayoutChangeListener(FinderPostUI.x(this.qPg));
      }
      AppMethodBeat.o(167524);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    s(FinderPostUI paramFinderPostUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */