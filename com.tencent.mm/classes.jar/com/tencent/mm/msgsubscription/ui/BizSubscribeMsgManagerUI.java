package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b.a;
import com.tencent.mm.msgsubscription.presenter.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@i
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "()V", "bizUsername", "", "mAdapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "nickname", "presenter", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "applyData", "", "switch", "", "items", "", "exampleTitle", "finish", "getLayoutId", "", "getUserName", "initAdapter", "initData", "initPresenter", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "updateResult", "result", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Companion", "plugin-comm_release"})
public final class BizSubscribeMsgManagerUI
  extends MMActivity
  implements c
{
  public static final a iCD;
  private HashMap _$_findViewCache;
  private String dCB;
  private a iCA;
  private MMSwitchBtn iCB;
  private com.tencent.mm.msgsubscription.presenter.a iCC;
  private ArrayList<SubscribeMsgTmpItem> mDataList;
  private String nickname;
  
  static
  {
    AppMethodBeat.i(149721);
    iCD = new a((byte)0);
    AppMethodBeat.o(149721);
  }
  
  public BizSubscribeMsgManagerUI()
  {
    AppMethodBeat.i(149720);
    this.dCB = "";
    this.nickname = "";
    this.mDataList = new ArrayList();
    AppMethodBeat.o(149720);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(149724);
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
    AppMethodBeat.o(149724);
    return localView1;
  }
  
  private final void fh(boolean paramBoolean)
  {
    AppMethodBeat.i(149717);
    Object localObject = (MaxRecyclerView)_$_findCachedViewById(2131305522);
    p.g(localObject, "subscribe_msg_list");
    int i;
    if (!((Collection)this.mDataList).isEmpty())
    {
      i = 1;
      if ((i == 0) || (!paramBoolean)) {
        break label318;
      }
      i = 0;
      label50:
      ((MaxRecyclerView)localObject).setVisibility(i);
      if (((Collection)this.mDataList).isEmpty()) {
        break label324;
      }
      i = 1;
      label73:
      if (i == 0) {
        break label355;
      }
      localObject = (TextView)_$_findCachedViewById(2131305525);
      p.g(localObject, "subscribe_msg_title_with_nickname");
      ((TextView)localObject).setVisibility(0);
      if (!paramBoolean) {
        break label329;
      }
      localObject = getString(2131756600);
      label113:
      TextView localTextView = (TextView)_$_findCachedViewById(2131305525);
      p.g(localTextView, "subscribe_msg_title_with_nickname");
      d.g.b.ad localad = d.g.b.ad.MLZ;
      p.g(localObject, "showTips");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { this.nickname }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
      localObject = (TextView)_$_findCachedViewById(2131305525);
      localTextView = (TextView)_$_findCachedViewById(2131305525);
      p.g(localTextView, "subscribe_msg_title_with_nickname");
      int j = localTextView.getPaddingLeft();
      if (!paramBoolean) {
        break label341;
      }
      i = getResources().getDimensionPixelSize(2131165483);
      label234:
      localTextView = (TextView)_$_findCachedViewById(2131305525);
      p.g(localTextView, "subscribe_msg_title_with_nickname");
      int k = localTextView.getPaddingRight();
      localTextView = (TextView)_$_findCachedViewById(2131305525);
      p.g(localTextView, "subscribe_msg_title_with_nickname");
      ((TextView)localObject).setPadding(j, i, k, localTextView.getPaddingBottom());
    }
    for (;;)
    {
      localObject = this.iCA;
      if (localObject == null) {
        break label383;
      }
      ((a)localObject).notifyDataSetChanged();
      AppMethodBeat.o(149717);
      return;
      i = 0;
      break;
      label318:
      i = 8;
      break label50;
      label324:
      i = 0;
      break label73;
      label329:
      localObject = getString(2131756598);
      break label113;
      label341:
      i = getResources().getDimensionPixelSize(2131165568);
      break label234;
      label355:
      localObject = (TextView)_$_findCachedViewById(2131305525);
      p.g(localObject, "subscribe_msg_title_with_nickname");
      ((TextView)localObject).setVisibility(8);
    }
    label383:
    AppMethodBeat.o(149717);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(149719);
    com.tencent.mm.msgsubscription.presenter.a locala = this.iCC;
    if (locala != null) {
      locala.y((Activity)this);
    }
    super.finish();
    AppMethodBeat.o(149719);
  }
  
  public final int getLayoutId()
  {
    return 2131493201;
  }
  
  public final String getUserName()
  {
    return this.dCB;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149712);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("key_biz_presenter_class");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    if (((CharSequence)paramBundle).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramBundle = (Throwable)new Exception("Presenter ClassName is empty");
      AppMethodBeat.o(149712);
      throw paramBundle;
    }
    try
    {
      this.iCC = ((com.tencent.mm.msgsubscription.presenter.a)Class.forName(paramBundle).newInstance());
      paramBundle = this.iCC;
      if (paramBundle != null)
      {
        localObject = (c)this;
        p.h(localObject, "<set-?>");
        paramBundle.iAX = ((c)localObject);
      }
      paramBundle = this.iCC;
      if (paramBundle != null) {
        paramBundle.onActivityCreated((Activity)this);
      }
      setMMTitle(2131756599);
      this.iCA = new a((Context)this, (a.a)new b(this));
      paramBundle = (MaxRecyclerView)_$_findCachedViewById(2131305522);
      p.g(paramBundle, "subscribe_msg_list");
      paramBundle.setAdapter((RecyclerView.a)this.iCA);
      paramBundle = (MaxRecyclerView)_$_findCachedViewById(2131305522);
      p.g(paramBundle, "subscribe_msg_list");
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
      paramBundle = _$_findCachedViewById(2131305523);
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
        AppMethodBeat.o(149712);
        throw paramBundle;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle = (Throwable)new Exception("create presenter instance fail!", (Throwable)paramBundle);
      AppMethodBeat.o(149712);
      throw paramBundle;
    }
    this.iCB = ((MMSwitchBtn)paramBundle);
    paramBundle = this.iCB;
    if (paramBundle != null) {
      paramBundle.setSwitchListener((MMSwitchBtn.a)new c(this));
    }
    localObject = getIntent().getStringExtra("key_biz_username");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.dCB = paramBundle;
    localObject = getIntent().getStringExtra("key_biz_nickname");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.nickname = paramBundle;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", new Object[] { this.dCB, this.nickname });
    paramBundle = this.iCC;
    if (paramBundle != null) {
      paramBundle.a(this.dCB, (b.a)new d(this));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(149712);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149716);
    if (this.iCC != null) {
      p.h((Activity)this, "activity");
    }
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
    AppMethodBeat.o(149716);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149715);
    com.tencent.mm.msgsubscription.presenter.a locala = this.iCC;
    if (locala != null) {
      locala.onActivityPaused((Activity)this);
    }
    super.onPause();
    AppMethodBeat.o(149715);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149714);
    super.onResume();
    com.tencent.mm.msgsubscription.presenter.a locala = this.iCC;
    if (locala != null)
    {
      locala.onActivityResumed((Activity)this);
      AppMethodBeat.o(149714);
      return;
    }
    AppMethodBeat.o(149714);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(149713);
    super.onStart();
    if (this.iCC != null) {
      p.h((Activity)this, "activity");
    }
    AppMethodBeat.o(149713);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149718);
    super.onStop();
    if (this.iCC != null) {
      p.h((Activity)this, "activity");
    }
    AppMethodBeat.o(149718);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$Companion;", "", "()V", "REQUEST_CODE_SUBSCRIBEMSG_FOR_APPBRAND_SETTING_UI", "", "REQUEST_CODE_SUBSCRIBEMSG_FOR_SERVICE_BRAND_SETTING_UI", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$initAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$CheckBoxStateChangedListener;", "getState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onChanged", "", "check", "plugin-comm_release"})
  public static final class b
    implements a.a
  {
    public final void b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
    {
      AppMethodBeat.i(149702);
      p.h(paramSubscribeMsgTmpItem, "item");
      com.tencent.mm.msgsubscription.presenter.a locala = BizSubscribeMsgManagerUI.a(this.iCE);
      if (locala != null)
      {
        locala.a(paramSubscribeMsgTmpItem, paramBoolean);
        AppMethodBeat.o(149702);
        return;
      }
      AppMethodBeat.o(149702);
    }
    
    public final boolean c(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
    {
      AppMethodBeat.i(149703);
      p.h(paramSubscribeMsgTmpItem, "item");
      com.tencent.mm.msgsubscription.presenter.a locala = BizSubscribeMsgManagerUI.a(this.iCE);
      if (locala != null)
      {
        boolean bool = locala.a(paramSubscribeMsgTmpItem);
        AppMethodBeat.o(149703);
        return bool;
      }
      AppMethodBeat.o(149703);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(149704);
      Object localObject = BizSubscribeMsgManagerUI.b(this.iCE);
      MMSwitchBtn localMMSwitchBtn;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((MMSwitchBtn)localObject).fLv());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", new Object[] { localObject });
        localObject = BizSubscribeMsgManagerUI.a(this.iCE);
        if (localObject != null)
        {
          localMMSwitchBtn = BizSubscribeMsgManagerUI.b(this.iCE);
          if (localMMSwitchBtn == null) {
            break label113;
          }
        }
      }
      label113:
      for (paramBoolean = localMMSwitchBtn.fLv();; paramBoolean = false)
      {
        ((com.tencent.mm.msgsubscription.presenter.a)localObject).eJ(paramBoolean);
        localObject = BizSubscribeMsgManagerUI.b(this.iCE);
        if ((localObject == null) || (((MMSwitchBtn)localObject).fLv() != true)) {
          break label118;
        }
        BizSubscribeMsgManagerUI.a(this.iCE, true);
        AppMethodBeat.o(149704);
        return;
        localObject = null;
        break;
      }
      label118:
      BizSubscribeMsgManagerUI.a(this.iCE, false);
      AppMethodBeat.o(149704);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
  public static final class d
    implements b.a
  {
    public final void a(final SubscribeMsgSettingData paramSubscribeMsgSettingData)
    {
      AppMethodBeat.i(177285);
      p.h(paramSubscribeMsgSettingData, "data");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
      this.iCE.runOnUiThread((Runnable)new a(this, paramSubscribeMsgSettingData));
      AppMethodBeat.o(177285);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(177284);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
      AppMethodBeat.o(177284);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizSubscribeMsgManagerUI.d paramd, SubscribeMsgSettingData paramSubscribeMsgSettingData) {}
      
      public final void run()
      {
        AppMethodBeat.i(177283);
        if (this.iCF.iCE.isFinishing())
        {
          AppMethodBeat.o(177283);
          return;
        }
        BizSubscribeMsgManagerUI.a(this.iCF.iCE, paramSubscribeMsgSettingData);
        AppMethodBeat.o(177283);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149711);
      this.iCE.finish();
      AppMethodBeat.o(149711);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI
 * JD-Core Version:    0.7.0.1
 */