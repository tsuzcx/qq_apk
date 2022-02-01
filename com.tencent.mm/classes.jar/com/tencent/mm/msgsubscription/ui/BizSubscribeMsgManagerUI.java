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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@i
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "()V", "bizUsername", "", "mAdapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "nickname", "presenter", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "applyData", "", "switch", "", "items", "", "exampleTitle", "finish", "getLayoutId", "", "getUserName", "initAdapter", "initData", "initPresenter", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "updateResult", "result", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Companion", "plugin-comm_release"})
public final class BizSubscribeMsgManagerUI
  extends MMActivity
  implements c
{
  public static final a ijm;
  private HashMap _$_findViewCache;
  private String dqK;
  private a iji;
  private ArrayList<SubscribeMsgTmpItem> ijj;
  private MMSwitchBtn ijk;
  private com.tencent.mm.msgsubscription.presenter.a ijl;
  private String nickname;
  
  static
  {
    AppMethodBeat.i(149721);
    ijm = new a((byte)0);
    AppMethodBeat.o(149721);
  }
  
  public BizSubscribeMsgManagerUI()
  {
    AppMethodBeat.i(149720);
    this.dqK = "";
    this.nickname = "";
    this.ijj = new ArrayList();
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
  
  private final void fd(boolean paramBoolean)
  {
    AppMethodBeat.i(149717);
    Object localObject = (MaxRecyclerView)_$_findCachedViewById(2131305522);
    k.g(localObject, "subscribe_msg_list");
    int i;
    if (!((Collection)this.ijj).isEmpty())
    {
      i = 1;
      if ((i == 0) || (!paramBoolean)) {
        break label318;
      }
      i = 0;
      label50:
      ((MaxRecyclerView)localObject).setVisibility(i);
      if (((Collection)this.ijj).isEmpty()) {
        break label324;
      }
      i = 1;
      label73:
      if (i == 0) {
        break label355;
      }
      localObject = (TextView)_$_findCachedViewById(2131305525);
      k.g(localObject, "subscribe_msg_title_with_nickname");
      ((TextView)localObject).setVisibility(0);
      if (!paramBoolean) {
        break label329;
      }
      localObject = getString(2131756600);
      label113:
      TextView localTextView = (TextView)_$_findCachedViewById(2131305525);
      k.g(localTextView, "subscribe_msg_title_with_nickname");
      z localz = z.KUT;
      k.g(localObject, "showTips");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { this.nickname }, 1));
      k.g(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
      localObject = (TextView)_$_findCachedViewById(2131305525);
      localTextView = (TextView)_$_findCachedViewById(2131305525);
      k.g(localTextView, "subscribe_msg_title_with_nickname");
      int j = localTextView.getPaddingLeft();
      if (!paramBoolean) {
        break label341;
      }
      i = getResources().getDimensionPixelSize(2131165483);
      label234:
      localTextView = (TextView)_$_findCachedViewById(2131305525);
      k.g(localTextView, "subscribe_msg_title_with_nickname");
      int k = localTextView.getPaddingRight();
      localTextView = (TextView)_$_findCachedViewById(2131305525);
      k.g(localTextView, "subscribe_msg_title_with_nickname");
      ((TextView)localObject).setPadding(j, i, k, localTextView.getPaddingBottom());
    }
    for (;;)
    {
      localObject = this.iji;
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
      k.g(localObject, "subscribe_msg_title_with_nickname");
      ((TextView)localObject).setVisibility(8);
    }
    label383:
    AppMethodBeat.o(149717);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(149719);
    com.tencent.mm.msgsubscription.presenter.a locala = this.ijl;
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
    return this.dqK;
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
      this.ijl = ((com.tencent.mm.msgsubscription.presenter.a)Class.forName(paramBundle).newInstance());
      paramBundle = this.ijl;
      if (paramBundle != null)
      {
        localObject = (c)this;
        k.h(localObject, "<set-?>");
        paramBundle.ihD = ((c)localObject);
      }
      paramBundle = this.ijl;
      if (paramBundle != null) {
        paramBundle.onActivityCreated((Activity)this);
      }
      setMMTitle(2131756599);
      this.iji = new a((Context)this, (a.a)new b(this));
      paramBundle = (MaxRecyclerView)_$_findCachedViewById(2131305522);
      k.g(paramBundle, "subscribe_msg_list");
      paramBundle.setAdapter((RecyclerView.a)this.iji);
      paramBundle = (MaxRecyclerView)_$_findCachedViewById(2131305522);
      k.g(paramBundle, "subscribe_msg_list");
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
    this.ijk = ((MMSwitchBtn)paramBundle);
    paramBundle = this.ijk;
    if (paramBundle != null) {
      paramBundle.setSwitchListener((MMSwitchBtn.a)new c(this));
    }
    localObject = getIntent().getStringExtra("key_biz_username");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.dqK = paramBundle;
    localObject = getIntent().getStringExtra("key_biz_nickname");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.nickname = paramBundle;
    ac.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", new Object[] { this.dqK, this.nickname });
    paramBundle = this.ijl;
    if (paramBundle != null) {
      paramBundle.a(this.dqK, (b.a)new d(this));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(149712);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149716);
    if (this.ijl != null) {
      k.h((Activity)this, "activity");
    }
    super.onDestroy();
    ac.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
    AppMethodBeat.o(149716);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149715);
    com.tencent.mm.msgsubscription.presenter.a locala = this.ijl;
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
    com.tencent.mm.msgsubscription.presenter.a locala = this.ijl;
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
    if (this.ijl != null) {
      k.h((Activity)this, "activity");
    }
    AppMethodBeat.o(149713);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149718);
    super.onStop();
    if (this.ijl != null) {
      k.h((Activity)this, "activity");
    }
    AppMethodBeat.o(149718);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$Companion;", "", "()V", "REQUEST_CODE_SUBSCRIBEMSG_FOR_APPBRAND_SETTING_UI", "", "REQUEST_CODE_SUBSCRIBEMSG_FOR_SERVICE_BRAND_SETTING_UI", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$initAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$CheckBoxStateChangedListener;", "getState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onChanged", "", "check", "plugin-comm_release"})
  public static final class b
    implements a.a
  {
    public final void b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
    {
      AppMethodBeat.i(149702);
      k.h(paramSubscribeMsgTmpItem, "item");
      com.tencent.mm.msgsubscription.presenter.a locala = BizSubscribeMsgManagerUI.a(this.ijn);
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
      k.h(paramSubscribeMsgTmpItem, "item");
      com.tencent.mm.msgsubscription.presenter.a locala = BizSubscribeMsgManagerUI.a(this.ijn);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(149704);
      Object localObject = BizSubscribeMsgManagerUI.b(this.ijn);
      MMSwitchBtn localMMSwitchBtn;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((MMSwitchBtn)localObject).fuI());
        ac.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", new Object[] { localObject });
        localObject = BizSubscribeMsgManagerUI.a(this.ijn);
        if (localObject != null)
        {
          localMMSwitchBtn = BizSubscribeMsgManagerUI.b(this.ijn);
          if (localMMSwitchBtn == null) {
            break label113;
          }
        }
      }
      label113:
      for (paramBoolean = localMMSwitchBtn.fuI();; paramBoolean = false)
      {
        ((com.tencent.mm.msgsubscription.presenter.a)localObject).eH(paramBoolean);
        localObject = BizSubscribeMsgManagerUI.b(this.ijn);
        if ((localObject == null) || (((MMSwitchBtn)localObject).fuI() != true)) {
          break label118;
        }
        BizSubscribeMsgManagerUI.a(this.ijn, true);
        AppMethodBeat.o(149704);
        return;
        localObject = null;
        break;
      }
      label118:
      BizSubscribeMsgManagerUI.a(this.ijn, false);
      AppMethodBeat.o(149704);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
  public static final class d
    implements b.a
  {
    public final void a(final SubscribeMsgSettingData paramSubscribeMsgSettingData)
    {
      AppMethodBeat.i(177285);
      k.h(paramSubscribeMsgSettingData, "data");
      ac.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
      this.ijn.runOnUiThread((Runnable)new a(this, paramSubscribeMsgSettingData));
      AppMethodBeat.o(177285);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(177284);
      ac.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
      AppMethodBeat.o(177284);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizSubscribeMsgManagerUI.d paramd, SubscribeMsgSettingData paramSubscribeMsgSettingData) {}
      
      public final void run()
      {
        AppMethodBeat.i(177283);
        if (this.ijo.ijn.isFinishing())
        {
          AppMethodBeat.o(177283);
          return;
        }
        BizSubscribeMsgManagerUI.a(this.ijo.ijn, paramSubscribeMsgSettingData);
        AppMethodBeat.o(177283);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149711);
      this.ijn.finish();
      AppMethodBeat.o(149711);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI
 * JD-Core Version:    0.7.0.1
 */