package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b.a;
import com.tencent.mm.msgsubscription.presenter.c;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@k
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "()V", "bizUsername", "", "mAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "nickname", "presenter", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "subscribeMsgList", "Lcom/tencent/mm/msgsubscription/ui/MaxRecyclerView;", "applyData", "", "switch", "", "items", "", "exampleTitle", "finish", "getLayoutId", "", "getUserName", "initAdapter", "initData", "initPresenter", "initViews", "loadData", "notifyItemChange", "item", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "updateResult", "result", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "Companion", "plugin-comm_release"})
public final class BizSubscribeMsgManagerUI
  extends MMActivity
  implements c
{
  public static final BizSubscribeMsgManagerUI.a mrx;
  private HashMap _$_findViewCache;
  private String fOX;
  private ArrayList<SubscribeMsgTmpItem> mDataList;
  private a<?> mrt;
  private MMSwitchBtn mru;
  private com.tencent.mm.msgsubscription.presenter.a mrv;
  private MaxRecyclerView mrw;
  private String nickname;
  
  static
  {
    AppMethodBeat.i(149721);
    mrx = new BizSubscribeMsgManagerUI.a((byte)0);
    AppMethodBeat.o(149721);
  }
  
  public BizSubscribeMsgManagerUI()
  {
    AppMethodBeat.i(149720);
    this.fOX = "";
    this.nickname = "";
    this.mDataList = new ArrayList();
    AppMethodBeat.o(149720);
  }
  
  private final void gK(boolean paramBoolean)
  {
    AppMethodBeat.i(149717);
    Object localObject = this.mrw;
    if (localObject == null) {
      p.bGy("subscribeMsgList");
    }
    int i;
    label48:
    TextView localTextView;
    if (!((Collection)this.mDataList).isEmpty())
    {
      i = 1;
      if ((i == 0) || (!paramBoolean)) {
        break label231;
      }
      i = 0;
      ((MaxRecyclerView)localObject).setVisibility(i);
      localTextView = (TextView)findViewById(c.e.subscribe_msg_title_with_nickname);
      if (((Collection)this.mDataList).isEmpty()) {
        break label237;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label268;
      }
      p.j(localTextView, "subscribeMsgTitleWithNickname");
      localTextView.setVisibility(0);
      if (!paramBoolean) {
        break label242;
      }
      localObject = getString(c.h.biz_subscribe_msg_open_with_nickname);
      label113:
      p.j(localObject, "if (show) getString(R.st…_msg_close_with_nickname)");
      af localaf = af.aaBG;
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { this.nickname }, 1));
      p.j(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
      int j = localTextView.getPaddingLeft();
      if (!paramBoolean) {
        break label254;
      }
      i = getResources().getDimensionPixelSize(c.c.LargerPadding);
      label187:
      localTextView.setPadding(j, i, localTextView.getPaddingRight(), localTextView.getPaddingBottom());
    }
    for (;;)
    {
      localObject = this.mrt;
      if (localObject == null) {
        break label285;
      }
      ((a)localObject).notifyDataSetChanged();
      AppMethodBeat.o(149717);
      return;
      i = 0;
      break;
      label231:
      i = 8;
      break label48;
      label237:
      i = 0;
      break label83;
      label242:
      localObject = getString(c.h.biz_subscribe_msg_close_with_nickname);
      break label113;
      label254:
      i = getResources().getDimensionPixelSize(c.c.SmallPadding);
      break label187;
      label268:
      p.j(localTextView, "subscribeMsgTitleWithNickname");
      localTextView.setVisibility(8);
    }
    label285:
    AppMethodBeat.o(149717);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(202270);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(202270);
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
    com.tencent.mm.msgsubscription.presenter.a locala = this.mrv;
    if (locala != null) {
      locala.x((Activity)this);
    }
    super.finish();
    AppMethodBeat.o(149719);
  }
  
  public final int getLayoutId()
  {
    return c.f.biz_subscribe_msg_manager_ui;
  }
  
  public final String getUserName()
  {
    return this.fOX;
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
    for (;;)
    {
      try
      {
        this.mrv = ((com.tencent.mm.msgsubscription.presenter.a)Class.forName(paramBundle).newInstance());
        paramBundle = this.mrv;
        if (paramBundle != null)
        {
          localObject = (c)this;
          p.k(localObject, "<set-?>");
          paramBundle.mpN = ((c)localObject);
        }
        paramBundle = this.mrv;
        if (paramBundle != null) {
          paramBundle.onActivityCreated((Activity)this);
        }
        setMMTitle(c.h.biz_subscribe_msg_manager_ui_title);
        paramBundle = this.mrv;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.b((MMActivity)this);
          this.mrt = paramBundle;
          paramBundle = findViewById(c.e.subscribe_msg_list);
          p.j(paramBundle, "this.findViewById(R.id.subscribe_msg_list)");
          this.mrw = ((MaxRecyclerView)paramBundle);
          paramBundle = this.mrw;
          if (paramBundle == null) {
            p.bGy("subscribeMsgList");
          }
          paramBundle.setAdapter((RecyclerView.a)this.mrt);
          paramBundle = this.mrw;
          if (paramBundle == null) {
            p.bGy("subscribeMsgList");
          }
          paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
          paramBundle = findViewById(c.e.subscribe_msg_switch);
          if (paramBundle != null) {
            break;
          }
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
      paramBundle = null;
    }
    this.mru = ((MMSwitchBtn)paramBundle);
    paramBundle = this.mru;
    if (paramBundle != null) {
      paramBundle.setSwitchListener((MMSwitchBtn.a)new b(this));
    }
    localObject = getIntent().getStringExtra("key_biz_username");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.fOX = paramBundle;
    localObject = getIntent().getStringExtra("key_biz_nickname");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.nickname = paramBundle;
    Log.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", new Object[] { this.fOX, this.nickname });
    paramBundle = this.mrv;
    if (paramBundle != null) {
      paramBundle.a(this.fOX, (b.a)new c(this));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    AppMethodBeat.o(149712);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149716);
    if (this.mrv != null) {
      p.k((Activity)this, "activity");
    }
    super.onDestroy();
    Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
    AppMethodBeat.o(149716);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149715);
    com.tencent.mm.msgsubscription.presenter.a locala = this.mrv;
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
    com.tencent.mm.msgsubscription.presenter.a locala = this.mrv;
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
    if (this.mrv != null) {
      p.k((Activity)this, "activity");
    }
    AppMethodBeat.o(149713);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149718);
    super.onStop();
    if (this.mrv != null) {
      p.k((Activity)this, "activity");
    }
    AppMethodBeat.o(149718);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void xq(int paramInt)
  {
    AppMethodBeat.i(202201);
    a locala = this.mrt;
    if (locala != null)
    {
      locala.cL(paramInt);
      AppMethodBeat.o(202201);
      return;
    }
    AppMethodBeat.o(202201);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onStatusChange"})
  static final class b
    implements MMSwitchBtn.a
  {
    b(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(149704);
      Object localObject = BizSubscribeMsgManagerUI.a(this.mry);
      MMSwitchBtn localMMSwitchBtn;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((MMSwitchBtn)localObject).isCheck());
        Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", new Object[] { localObject });
        localObject = BizSubscribeMsgManagerUI.b(this.mry);
        if (localObject != null)
        {
          localMMSwitchBtn = BizSubscribeMsgManagerUI.a(this.mry);
          if (localMMSwitchBtn == null) {
            break label113;
          }
        }
      }
      label113:
      for (paramBoolean = localMMSwitchBtn.isCheck();; paramBoolean = false)
      {
        ((com.tencent.mm.msgsubscription.presenter.a)localObject).gn(paramBoolean);
        localObject = BizSubscribeMsgManagerUI.a(this.mry);
        if ((localObject == null) || (((MMSwitchBtn)localObject).isCheck() != true)) {
          break label118;
        }
        BizSubscribeMsgManagerUI.a(this.mry, true);
        AppMethodBeat.o(149704);
        return;
        localObject = null;
        break;
      }
      label118:
      BizSubscribeMsgManagerUI.a(this.mry, false);
      AppMethodBeat.o(149704);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"})
  public static final class c
    implements b.a
  {
    public final void a(final SubscribeMsgSettingData paramSubscribeMsgSettingData)
    {
      AppMethodBeat.i(177285);
      p.k(paramSubscribeMsgSettingData, "data");
      Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
      this.mry.runOnUiThread((Runnable)new a(this, paramSubscribeMsgSettingData));
      AppMethodBeat.o(177285);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(177284);
      Log.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
      AppMethodBeat.o(177284);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizSubscribeMsgManagerUI.c paramc, SubscribeMsgSettingData paramSubscribeMsgSettingData) {}
      
      public final void run()
      {
        AppMethodBeat.i(177283);
        if (this.mrz.mry.isFinishing())
        {
          AppMethodBeat.o(177283);
          return;
        }
        BizSubscribeMsgManagerUI.a(this.mrz.mry, paramSubscribeMsgSettingData);
        AppMethodBeat.o(177283);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149711);
      this.mry.finish();
      AppMethodBeat.o(149711);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI
 * JD-Core Version:    0.7.0.1
 */