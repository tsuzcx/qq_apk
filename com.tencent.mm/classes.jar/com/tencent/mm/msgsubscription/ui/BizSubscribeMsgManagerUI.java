package com.tencent.mm.msgsubscription.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@k
@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingView;", "()V", "bizUsername", "", "ll", "Landroid/widget/LinearLayout;", "mAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "nickname", "presenter", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "subscribeMsgList", "Lcom/tencent/mm/msgsubscription/ui/MaxRecyclerView;", "applyData", "", "switch", "", "items", "", "exampleTitle", "finish", "getLayoutId", "", "getUserName", "initAdapter", "initData", "initPresenter", "initViews", "loadData", "notifyItemChange", "item", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateResult", "result", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "BizSubscribeMsgManagerUIAccessibility", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizSubscribeMsgManagerUI
  extends MMSecDataActivity
  implements c
{
  public static final BizSubscribeMsgManagerUI.b pkS;
  private String hUQ;
  private ArrayList<SubscribeMsgTmpItem> mDataList;
  private String nickname;
  private a<?> pkT;
  private MMSwitchBtn pkU;
  private com.tencent.mm.msgsubscription.presenter.a pkV;
  private MaxRecyclerView pkW;
  private LinearLayout pkX;
  
  static
  {
    AppMethodBeat.i(149721);
    pkS = new BizSubscribeMsgManagerUI.b((byte)0);
    AppMethodBeat.o(149721);
  }
  
  public BizSubscribeMsgManagerUI()
  {
    AppMethodBeat.i(149720);
    this.hUQ = "";
    this.nickname = "";
    this.mDataList = new ArrayList();
    AppMethodBeat.o(149720);
  }
  
  private static final void a(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(236676);
    s.u(paramBizSubscribeMsgManagerUI, "this$0");
    Object localObject1 = paramBizSubscribeMsgManagerUI.pkU;
    MMSwitchBtn localMMSwitchBtn;
    label68:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsg onSwitchChanged %s", new Object[] { localObject1 });
      localObject1 = paramBizSubscribeMsgManagerUI.pkV;
      if (localObject1 != null)
      {
        localMMSwitchBtn = paramBizSubscribeMsgManagerUI.pkU;
        if (localMMSwitchBtn != null) {
          break label184;
        }
        paramBoolean = false;
        ((com.tencent.mm.msgsubscription.presenter.a)localObject1).he(paramBoolean);
      }
      localObject1 = paramBizSubscribeMsgManagerUI.pkU;
      if ((localObject1 == null) || (((MMSwitchBtn)localObject1).afTT != true)) {
        break label193;
      }
      i = 1;
      label92:
      if (i == 0) {
        break label201;
      }
      paramBizSubscribeMsgManagerUI.hy(true);
      localObject1 = paramBizSubscribeMsgManagerUI.pkX;
      if (localObject1 != null) {
        break label198;
      }
      s.bIx("ll");
      localObject1 = localObject2;
    }
    label184:
    label193:
    label198:
    for (;;)
    {
      ((LinearLayout)localObject1).setContentDescription((CharSequence)(paramBizSubscribeMsgManagerUI.getResources().getString(c.h.biz_subscribe_msg_recv) + ',' + paramBizSubscribeMsgManagerUI.getResources().getString(c.h.biz_subscribe_msg_open)));
      AppMethodBeat.o(236676);
      return;
      localObject1 = Boolean.valueOf(((MMSwitchBtn)localObject1).afTT);
      break;
      paramBoolean = localMMSwitchBtn.afTT;
      break label68;
      i = 0;
      break label92;
    }
    label201:
    paramBizSubscribeMsgManagerUI.hy(false);
    localObject1 = paramBizSubscribeMsgManagerUI.pkX;
    if (localObject1 == null)
    {
      s.bIx("ll");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setContentDescription((CharSequence)(paramBizSubscribeMsgManagerUI.getResources().getString(c.h.biz_subscribe_msg_recv) + ',' + paramBizSubscribeMsgManagerUI.getResources().getString(c.h.biz_subscribe_msg_close)));
      AppMethodBeat.o(236676);
      return;
    }
  }
  
  private static final boolean a(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(236657);
    s.u(paramBizSubscribeMsgManagerUI, "this$0");
    paramBizSubscribeMsgManagerUI.finish();
    AppMethodBeat.o(236657);
    return false;
  }
  
  private final void hy(boolean paramBoolean)
  {
    AppMethodBeat.i(149717);
    Object localObject = this.pkW;
    int i;
    label42:
    label52:
    TextView localTextView;
    if (localObject == null)
    {
      s.bIx("subscribeMsgList");
      localObject = null;
      if (((Collection)this.mDataList).isEmpty()) {
        break label230;
      }
      i = 1;
      if ((i == 0) || (!paramBoolean)) {
        break label235;
      }
      i = 0;
      ((MaxRecyclerView)localObject).setVisibility(i);
      localTextView = (TextView)findViewById(c.e.subscribe_msg_title_with_nickname);
      if (((Collection)this.mDataList).isEmpty()) {
        break label241;
      }
      i = 1;
      label87:
      if (i == 0) {
        break label272;
      }
      localTextView.setVisibility(0);
      if (!paramBoolean) {
        break label246;
      }
      localObject = getString(c.h.biz_subscribe_msg_open_with_nickname);
      label110:
      s.s(localObject, "if (show) getString(R.st…_msg_close_with_nickname)");
      am localam = am.aixg;
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { this.nickname }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
      int j = localTextView.getPaddingLeft();
      if (!paramBoolean) {
        break label258;
      }
      i = getResources().getDimensionPixelSize(c.c.LargerPadding);
      label184:
      localTextView.setPadding(j, i, localTextView.getPaddingRight(), localTextView.getPaddingBottom());
    }
    for (;;)
    {
      localObject = this.pkT;
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      AppMethodBeat.o(149717);
      return;
      break;
      label230:
      i = 0;
      break label42;
      label235:
      i = 8;
      break label52;
      label241:
      i = 0;
      break label87;
      label246:
      localObject = getString(c.h.biz_subscribe_msg_close_with_nickname);
      break label110;
      label258:
      i = getResources().getDimensionPixelSize(c.c.SmallPadding);
      break label184;
      label272:
      localTextView.setVisibility(8);
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(149719);
    com.tencent.mm.msgsubscription.presenter.a locala = this.pkV;
    if (locala != null) {
      locala.A((Activity)this);
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
    return this.hUQ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(149712);
    super.onCreate(paramBundle);
    Object localObject2 = getIntent().getStringExtra("key_biz_presenter_class");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    if (((CharSequence)paramBundle).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramBundle = new Exception("Presenter ClassName is empty");
      AppMethodBeat.o(149712);
      throw paramBundle;
    }
    for (;;)
    {
      MMSwitchBtn localMMSwitchBtn;
      try
      {
        this.pkV = ((com.tencent.mm.msgsubscription.presenter.a)Class.forName(paramBundle).newInstance());
        paramBundle = this.pkV;
        if (paramBundle != null)
        {
          localObject2 = (c)this;
          s.u(localObject2, "<set-?>");
          paramBundle.pjz = ((c)localObject2);
        }
        paramBundle = this.pkV;
        if (paramBundle != null) {
          paramBundle.z((Activity)this);
        }
        setMMTitle(c.h.biz_subscribe_msg_manager_ui_title);
        paramBundle = this.pkV;
        if (paramBundle == null)
        {
          paramBundle = null;
          this.pkT = paramBundle;
          this.pkX = ((LinearLayout)findViewById(c.e.ll_subscribe_msg));
          this.pkW = ((MaxRecyclerView)findViewById(c.e.subscribe_msg_list));
          paramBundle = this.pkW;
          if (paramBundle != null) {
            break label526;
          }
          s.bIx("subscribeMsgList");
          paramBundle = null;
          paramBundle.setAdapter((RecyclerView.a)this.pkT);
          paramBundle = this.pkW;
          if (paramBundle != null) {
            break label529;
          }
          s.bIx("subscribeMsgList");
          paramBundle = null;
          paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
          this.pkU = ((MMSwitchBtn)findViewById(c.e.subscribe_msg_switch));
          paramBundle = this.pkU;
          if (paramBundle != null) {
            paramBundle.setSwitchListener(new BizSubscribeMsgManagerUI..ExternalSyntheticLambda1(this));
          }
          paramBundle = this.pkX;
          if (paramBundle != null) {
            break label532;
          }
          s.bIx("ll");
          paramBundle = null;
          localObject2 = new StringBuilder().append(getResources().getString(c.h.biz_subscribe_msg_recv)).append(',');
          localMMSwitchBtn = this.pkU;
          if (localMMSwitchBtn != null) {
            break label535;
          }
          paramBundle.setContentDescription((CharSequence)localObject1);
          paramBundle = this.pkU;
          if (paramBundle != null) {
            paramBundle.setFocusable(false);
          }
          localObject1 = getIntent().getStringExtra("key_biz_username");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          this.hUQ = paramBundle;
          localObject1 = getIntent().getStringExtra("key_biz_nickname");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          this.nickname = paramBundle;
          Log.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", new Object[] { this.hUQ, this.nickname });
          paramBundle = this.pkV;
          if (paramBundle != null) {
            paramBundle.a(this.hUQ, (b.a)new c(this));
          }
          setBackBtn(new BizSubscribeMsgManagerUI..ExternalSyntheticLambda0(this));
          AppMethodBeat.o(149712);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = new Exception("create presenter instance fail!", (Throwable)paramBundle);
        AppMethodBeat.o(149712);
        throw paramBundle;
      }
      paramBundle = paramBundle.b((MMActivity)this);
      continue;
      label526:
      continue;
      label529:
      continue;
      label532:
      continue;
      label535:
      localObject1 = localMMSwitchBtn.getContentDescription();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149716);
    if (this.pkV != null) {
      s.u((Activity)this, "activity");
    }
    super.onDestroy();
    Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
    AppMethodBeat.o(149716);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149715);
    com.tencent.mm.msgsubscription.presenter.a locala = this.pkV;
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
    com.tencent.mm.msgsubscription.presenter.a locala = this.pkV;
    if (locala != null) {
      locala.onActivityResumed((Activity)this);
    }
    AppMethodBeat.o(149714);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(149713);
    super.onStart();
    if (this.pkV != null) {
      s.u((Activity)this, "activity");
    }
    AppMethodBeat.o(149713);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149718);
    super.onStop();
    if (this.pkV != null) {
      s.u((Activity)this, "activity");
    }
    AppMethodBeat.o(149718);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(236736);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(BizSubscribeMsgManagerUI.a.class);
    AppMethodBeat.o(236736);
  }
  
  public final void xq(int paramInt)
  {
    AppMethodBeat.i(236710);
    a locala = this.pkT;
    if (locala != null) {
      locala.fV(paramInt);
    }
    AppMethodBeat.o(236710);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/BizSubscribeMsgManagerUI$loadData$1", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onError", "", "onSuccess", "data", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b.a
  {
    c(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI) {}
    
    private static final void b(BizSubscribeMsgManagerUI paramBizSubscribeMsgManagerUI, SubscribeMsgSettingData paramSubscribeMsgSettingData)
    {
      AppMethodBeat.i(236634);
      s.u(paramBizSubscribeMsgManagerUI, "this$0");
      s.u(paramSubscribeMsgSettingData, "$data");
      if (paramBizSubscribeMsgManagerUI.isFinishing())
      {
        AppMethodBeat.o(236634);
        return;
      }
      BizSubscribeMsgManagerUI.a(paramBizSubscribeMsgManagerUI, paramSubscribeMsgSettingData);
      AppMethodBeat.o(236634);
    }
    
    public final void a(SubscribeMsgSettingData paramSubscribeMsgSettingData)
    {
      AppMethodBeat.i(177285);
      s.u(paramSubscribeMsgSettingData, "data");
      Log.i("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList onSuccess");
      this.pkY.runOnUiThread(new BizSubscribeMsgManagerUI.c..ExternalSyntheticLambda0(this.pkY, paramSubscribeMsgSettingData));
      AppMethodBeat.o(177285);
    }
    
    public final void atR()
    {
      AppMethodBeat.i(177284);
      Log.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo getSubscribeMsgList ERROR");
      AppMethodBeat.o(177284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI
 * JD-Core Version:    0.7.0.1
 */