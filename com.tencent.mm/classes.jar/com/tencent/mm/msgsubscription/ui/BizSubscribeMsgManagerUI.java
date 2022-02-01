package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@i
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "()V", "bizUsername", "", "mAdapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "nickname", "presenter", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "subscribeMsgList", "Lcom/tencent/mm/msgsubscription/ui/MaxRecyclerView;", "applyData", "", "switch", "", "items", "", "exampleTitle", "finish", "getLayoutId", "", "getUserName", "initAdapter", "initData", "initPresenter", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "updateResult", "result", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Companion", "plugin-comm_release"})
public final class BizSubscribeMsgManagerUI
  extends MMActivity
  implements c
{
  public static final BizSubscribeMsgManagerUI.a jBA;
  private HashMap _$_findViewCache;
  private String dVu;
  private a jBw;
  private MMSwitchBtn jBx;
  private com.tencent.mm.msgsubscription.presenter.a jBy;
  private MaxRecyclerView jBz;
  private ArrayList<SubscribeMsgTmpItem> mDataList;
  private String nickname;
  
  static
  {
    AppMethodBeat.i(149721);
    jBA = new BizSubscribeMsgManagerUI.a((byte)0);
    AppMethodBeat.o(149721);
  }
  
  public BizSubscribeMsgManagerUI()
  {
    AppMethodBeat.i(149720);
    this.dVu = "";
    this.nickname = "";
    this.mDataList = new ArrayList();
    AppMethodBeat.o(149720);
  }
  
  private final void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(149717);
    Object localObject = this.jBz;
    if (localObject == null) {
      p.btv("subscribeMsgList");
    }
    int i;
    label48:
    TextView localTextView;
    if (!((Collection)this.mDataList).isEmpty())
    {
      i = 1;
      if ((i == 0) || (!paramBoolean)) {
        break label228;
      }
      i = 0;
      ((MaxRecyclerView)localObject).setVisibility(i);
      localTextView = (TextView)findViewById(2131308742);
      if (((Collection)this.mDataList).isEmpty()) {
        break label234;
      }
      i = 1;
      label82:
      if (i == 0) {
        break label265;
      }
      p.g(localTextView, "subscribeMsgTitleWithNickname");
      localTextView.setVisibility(0);
      if (!paramBoolean) {
        break label239;
      }
      localObject = getString(2131756741);
      label111:
      p.g(localObject, "if (show) getString(R.st…_msg_close_with_nickname)");
      ae localae = ae.SYK;
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { this.nickname }, 1));
      p.g(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
      int j = localTextView.getPaddingLeft();
      if (!paramBoolean) {
        break label251;
      }
      i = getResources().getDimensionPixelSize(2131165501);
      label184:
      localTextView.setPadding(j, i, localTextView.getPaddingRight(), localTextView.getPaddingBottom());
    }
    for (;;)
    {
      localObject = this.jBw;
      if (localObject == null) {
        break label282;
      }
      ((a)localObject).notifyDataSetChanged();
      AppMethodBeat.o(149717);
      return;
      i = 0;
      break;
      label228:
      i = 8;
      break label48;
      label234:
      i = 0;
      break label82;
      label239:
      localObject = getString(2131756739);
      break label111;
      label251:
      i = getResources().getDimensionPixelSize(2131165586);
      break label184;
      label265:
      p.g(localTextView, "subscribeMsgTitleWithNickname");
      localTextView.setVisibility(8);
    }
    label282:
    AppMethodBeat.o(149717);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(223416);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(223416);
  }
  
  public final View _$_findCachedViewById(int paramInt)
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
  
  public final void finish()
  {
    AppMethodBeat.i(149719);
    com.tencent.mm.msgsubscription.presenter.a locala = this.jBy;
    if (locala != null) {
      locala.y((Activity)this);
    }
    super.finish();
    AppMethodBeat.o(149719);
  }
  
  public final int getLayoutId()
  {
    return 2131493247;
  }
  
  public final String getUserName()
  {
    return this.dVu;
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
      this.jBy = ((com.tencent.mm.msgsubscription.presenter.a)Class.forName(paramBundle).newInstance());
      paramBundle = this.jBy;
      if (paramBundle != null)
      {
        localObject = (c)this;
        p.h(localObject, "<set-?>");
        paramBundle.jAh = ((c)localObject);
      }
      paramBundle = this.jBy;
      if (paramBundle != null) {
        paramBundle.onActivityCreated((Activity)this);
      }
      setMMTitle(2131756740);
      this.jBw = new a((Context)this, (a.b)new b(this));
      paramBundle = findViewById(2131308739);
      p.g(paramBundle, "this.findViewById(R.id.subscribe_msg_list)");
      this.jBz = ((MaxRecyclerView)paramBundle);
      paramBundle = this.jBz;
      if (paramBundle == null) {
        p.btv("subscribeMsgList");
      }
      paramBundle.setAdapter((RecyclerView.a)this.jBw);
      paramBundle = this.jBz;
      if (paramBundle == null) {
        p.btv("subscribeMsgList");
      }
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      paramBundle = findViewById(2131308740);
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
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
    this.jBx = ((MMSwitchBtn)paramBundle);
    paramBundle = this.jBx;
    if (paramBundle != null) {
      paramBundle.setSwitchListener((MMSwitchBtn.a)new c(this));
    }
    localObject = getIntent().getStringExtra("key_biz_username");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.dVu = paramBundle;
    localObject = getIntent().getStringExtra("key_biz_nickname");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.nickname = paramBundle;
    Log.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", new Object[] { this.dVu, this.nickname });
    paramBundle = this.jBy;
    if (paramBundle != null) {
      paramBundle.a(this.dVu, (b.a)new d(this));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(149712);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149716);
    if (this.jBy != null) {
      p.h((Activity)this, "activity");
    }
    super.onDestroy();
    Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
    AppMethodBeat.o(149716);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149715);
    com.tencent.mm.msgsubscription.presenter.a locala = this.jBy;
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
    com.tencent.mm.msgsubscription.presenter.a locala = this.jBy;
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
    if (this.jBy != null) {
      p.h((Activity)this, "activity");
    }
    AppMethodBeat.o(149713);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149718);
    super.onStop();
    if (this.jBy != null) {
      p.h((Activity)this, "activity");
    }
    AppMethodBeat.o(149718);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$initAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-comm_release"})
  public static final class b
    implements a.b
  {
    public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
    {
      AppMethodBeat.i(223415);
      p.h(paramSubscribeMsgTmpItem, "item");
      com.tencent.mm.msgsubscription.presenter.a locala = BizSubscribeMsgManagerUI.a(this.jBB);
      if (locala != null)
      {
        boolean bool = locala.a(paramSubscribeMsgTmpItem);
        AppMethodBeat.o(223415);
        return bool;
      }
      AppMethodBeat.o(223415);
      return false;
    }
    
    public final void b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
    {
      AppMethodBeat.i(223414);
      p.h(paramSubscribeMsgTmpItem, "item");
      com.tencent.mm.msgsubscription.presenter.a locala = BizSubscribeMsgManagerUI.a(this.jBB);
      if (locala != null)
      {
        locala.a(paramSubscribeMsgTmpItem, paramBoolean);
        AppMethodBeat.o(223414);
        return;
      }
      AppMethodBeat.o(223414);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onStatusChange"})
  static final class c
    implements MMSwitchBtn.a
  {
    c(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(149704);
      Object localObject = BizSubscribeMsgManagerUI.b(this.jBB);
      MMSwitchBtn localMMSwitchBtn;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((MMSwitchBtn)localObject).isCheck());
        Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", new Object[] { localObject });
        localObject = BizSubscribeMsgManagerUI.a(this.jBB);
        if (localObject != null)
        {
          localMMSwitchBtn = BizSubscribeMsgManagerUI.b(this.jBB);
          if (localMMSwitchBtn == null) {
            break label113;
          }
        }
      }
      label113:
      for (paramBoolean = localMMSwitchBtn.isCheck();; paramBoolean = false)
      {
        ((com.tencent.mm.msgsubscription.presenter.a)localObject).fC(paramBoolean);
        localObject = BizSubscribeMsgManagerUI.b(this.jBB);
        if ((localObject == null) || (((MMSwitchBtn)localObject).isCheck() != true)) {
          break label118;
        }
        BizSubscribeMsgManagerUI.a(this.jBB, true);
        AppMethodBeat.o(149704);
        return;
        localObject = null;
        break;
      }
      label118:
      BizSubscribeMsgManagerUI.a(this.jBB, false);
      AppMethodBeat.o(149704);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
  public static final class d
    implements b.a
  {
    public final void a(final SubscribeMsgSettingData paramSubscribeMsgSettingData)
    {
      AppMethodBeat.i(177285);
      p.h(paramSubscribeMsgSettingData, "data");
      Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
      this.jBB.runOnUiThread((Runnable)new a(this, paramSubscribeMsgSettingData));
      AppMethodBeat.o(177285);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(177284);
      Log.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
      AppMethodBeat.o(177284);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizSubscribeMsgManagerUI.d paramd, SubscribeMsgSettingData paramSubscribeMsgSettingData) {}
      
      public final void run()
      {
        AppMethodBeat.i(177283);
        if (this.jBC.jBB.isFinishing())
        {
          AppMethodBeat.o(177283);
          return;
        }
        BizSubscribeMsgManagerUI.a(this.jBC.jBB, paramSubscribeMsgSettingData);
        AppMethodBeat.o(177283);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149711);
      this.jBB.finish();
      AppMethodBeat.o(149711);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI
 * JD-Core Version:    0.7.0.1
 */