package com.tencent.mm.plugin.emoji.ui.v3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.autogen.a.ee.a;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.k.a;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.emoji.ui.v3.a.aa;
import com.tencent.mm.plugin.emoji.ui.v3.a.ac;
import com.tencent.mm.plugin.emoji.ui.v3.a.f.a;
import com.tencent.mm.plugin.emoji.ui.v3.a.f.b;
import com.tencent.mm.plugin.emoji.ui.v3.a.g;
import com.tencent.mm.plugin.emoji.ui.v3.a.i;
import com.tencent.mm.plugin.emoji.ui.v3.a.n;
import com.tencent.mm.plugin.emoji.ui.v3.a.n.a;
import com.tencent.mm.plugin.emoji.ui.v3.a.t;
import com.tencent.mm.plugin.emoji.ui.v3.a.v;
import com.tencent.mm.plugin.emoji.ui.v3.a.w;
import com.tencent.mm.plugin.emoji.ui.v3.b.d;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent$PayOrDownloadIm;", "()V", "MSG_KEY_PRODUCT_ID", "", "MSG_KEY_PROGRESS", "MSG_KEY_STATUS", "TAG", "UI_MSG_UPDATE_HEADER", "", "UI_MSG_UPDATE_PROGRESS", "UI_MSG_UPDATE_STATUS", "adapter", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "currentEmotionPayOrDownloadComponent", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent;", "dataRepo", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseDataRepo;", "getDataRepo", "()Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseDataRepo;", "dataRepo$delegate", "emotionStateChangeListener", "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$emotionStateChangeListener$1", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$emotionStateChangeListener$1;", "emptyView", "Landroid/view/View;", "emptyViewContent", "Landroid/widget/TextView;", "firstItemExposeReport", "", "hasInitView", "hasVisibleToUser", "itemClickListener", "com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$itemClickListener$1", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$itemClickListener$1;", "loading", "loadingDialog", "Landroid/app/ProgressDialog;", "loadingView", "mUIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onStorageChangeListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "talker", "dismissLoadingDialog", "", "getForceOrientation", "getNetSceneGetStoreRecListType", "handleUIMessage", "msg", "Landroid/os/Message;", "initContentView", "initEmptyView", "initLoadingView", "initStatusHandle", "initeData", "initeView", "isMainTab", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onDetach", "onExchange", "productId", "status", "progress", "cdnClientID", "onPause", "onResume", "onStop", "reStartLoadRemoteEmoji", "requestExchangeEmotion", "produtId", "seriesId", "productName", "iconUrl", "panelIcon", "sendUIMessage", "setUserVisibleHint", "isVisibleToUser", "showContentUIState", "showEmptyUIState", "showErrorUIState", "showLoadingDialog", "showLoadingUIState", "startLoadRemoteEmoji", "byCache", "supportNavigationSwipeBack", "updateItemProgressByProductId", "updateItemStatusByProductId", "updateLoadingDialog", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class EmojiStoreV3HomeBaseFragment
  extends MMFragment
  implements n.a
{
  final String TAG = "MicroMsg.EmojiStoreV3HomeBaseFragment";
  private final MMHandler eqE = (MMHandler)new g(this);
  private RecyclerView mkw;
  private View njN;
  private String talker = "";
  private View vDA;
  final int xPW = 131075;
  final int xPX = 131076;
  final String xPY = "product_id";
  final String xPZ = "progress";
  final String xQa = "status";
  final int xVB = 131077;
  ProgressDialog xZJ;
  private n xZK;
  private TextView xZL;
  private boolean xZM;
  private boolean xZN;
  private boolean xZO = true;
  private final kotlin.j xZP = kotlin.k.cm((kotlin.g.a.a)a.xZU);
  private final kotlin.j xZQ = kotlin.k.cm((kotlin.g.a.a)new b(this));
  private final MStorage.IOnStorageChange xZR = new EmojiStoreV3HomeBaseFragment..ExternalSyntheticLambda1(this);
  private final emotionStateChangeListener.1 xZS = new IListener(com.tencent.mm.app.f.hfK)
  {
    private boolean a(ee paramAnonymousee)
    {
      AppMethodBeat.i(270476);
      kotlin.g.b.s.u(paramAnonymousee, "event");
      try
      {
        EmojiStoreV3HomeBaseFragment.a(this.xZV, paramAnonymousee.hDW.productId, paramAnonymousee.hDW.status, paramAnonymousee.hDW.progress, paramAnonymousee.hDW.hDX);
        AppMethodBeat.o(270476);
        return false;
      }
      catch (NullPointerException paramAnonymousee)
      {
        Log.i(EmojiStoreV3HomeBaseFragment.b(this.xZV), "emotionStateChange callback failed, event null");
        AppMethodBeat.o(270476);
      }
      return false;
    }
  };
  private final f xZT = new f(this);
  
  private static final void a(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment)
  {
    kotlin.g.b.s.u(paramEmojiStoreV3HomeBaseFragment, "this$0");
    paramEmojiStoreV3HomeBaseFragment.dCK().dCE();
  }
  
  private static final void a(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment, String paramString, MStorageEventData paramMStorageEventData)
  {
    kotlin.g.b.s.u(paramEmojiStoreV3HomeBaseFragment, "this$0");
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (kotlin.g.b.s.p(paramString, "delete_group_v3")))
    {
      Log.i(paramEmojiStoreV3HomeBaseFragment.TAG, "IOnStorageChange event:" + paramString + ", refreshUI");
      paramString = paramMStorageEventData.obj;
      if (!(paramString instanceof String)) {
        break label92;
      }
    }
    label92:
    for (paramString = (String)paramString;; paramString = null)
    {
      paramMStorageEventData = com.tencent.mm.plugin.emoji.model.k.xML;
      k.a.dzR();
      if (paramString != null) {
        paramEmojiStoreV3HomeBaseFragment.ed(paramString, -1);
      }
      return;
    }
  }
  
  private final b dCK()
  {
    return (b)this.xZQ.getValue();
  }
  
  private final void dCL()
  {
    Object localObject = this.vDA;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.njN;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
  }
  
  private void dCM()
  {
    if (dCK().szX)
    {
      Log.i(this.TAG, "startLoadRemoteEmoji isLoading");
      return;
    }
    dCK().dCF();
    dCK().dCG();
    Log.i(this.TAG, "[startLoadRemoteEmoji] doScene NetSceneGetEmotionStoreRecList");
  }
  
  private final void dCf()
  {
    dCK().dCf();
    int i = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
    String str2 = thisActivity().getIntent().getStringExtra("to_talker_name");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.talker = str1;
    dCK().xQc = i;
    if (b.a(dCK()))
    {
      this.eqE.postDelayed(new EmojiStoreV3HomeBaseFragment..ExternalSyntheticLambda2(this), 3000L);
      return;
    }
    dCK().dCE();
  }
  
  private static final void e(DialogInterface paramDialogInterface) {}
  
  private final void ed(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.getData().putString(this.xPY, paramString);
    localMessage.getData().putInt(this.xQa, paramInt);
    localMessage.what = this.xPX;
    m(localMessage);
  }
  
  private void m(Message paramMessage)
  {
    this.eqE.sendMessage(paramMessage);
  }
  
  protected final void aoR(String paramString)
  {
    if (isFinishing())
    {
      Log.i(this.TAG, "[showLoadingDialog] activity is finished.");
      return;
    }
    Context localContext = (Context)thisActivity();
    getString(h.h.app_tip);
    this.xZJ = ((ProgressDialog)com.tencent.mm.ui.base.k.a(localContext, paramString, true, EmojiStoreV3HomeBaseFragment..ExternalSyntheticLambda0.INSTANCE));
  }
  
  final i dCJ()
  {
    return (i)this.xZP.getValue();
  }
  
  public final void dCN()
  {
    dCM();
  }
  
  public abstract int dCO();
  
  public abstract boolean dCl();
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    Log.d(this.TAG, "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.xZN = true;
    this.vDA = findViewById(h.e.empty);
    paramBundle = this.vDA;
    if (paramBundle == null)
    {
      paramBundle = null;
      if (!(paramBundle instanceof TextView)) {
        break label240;
      }
      label49:
      this.xZL = paramBundle;
      this.njN = findViewById(h.e.loading);
      paramBundle = findViewById(h.e.emoji_store_v3_recyclerview);
      if (!(paramBundle instanceof RecyclerView)) {
        break label245;
      }
    }
    label240:
    label245:
    for (paramBundle = (RecyclerView)paramBundle;; paramBundle = null)
    {
      this.mkw = paramBundle;
      paramBundle = this.mkw;
      if (paramBundle != null)
      {
        getContext();
        paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      }
      paramBundle = dCJ();
      v localv = (v)this.xZT;
      kotlin.g.b.s.u(localv, "clickListener");
      paramBundle.ybO = localv;
      dCJ().ybS = ((kotlin.g.a.b)c.xZW);
      dCJ().ybT = ((kotlin.g.a.b)d.xZX);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        paramBundle.setAdapter((RecyclerView.a)dCJ());
      }
      dCK().xZA.a((androidx.lifecycle.q)this, (y)new e(this));
      if (this.xZM) {
        dCf();
      }
      return;
      paramBundle = (TextView)paramBundle.findViewById(h.e.empty_content);
      break;
      paramBundle = null;
      break label49;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d(this.TAG, "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (paramInt2 == -1) {
        com.tencent.mm.ui.widget.snackbar.b.u((Activity)thisActivity(), com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), h.h.app_sent));
      }
    }
    n localn;
    do
    {
      return;
      if (this.xZK == null) {
        break;
      }
      localn = this.xZK;
    } while (localn == null);
    localn.onActivityResult(paramInt1, paramInt2, paramIntent);
    return;
    Log.i(this.TAG, "payOrDownloadComponent have no init.");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    setRequestedOrientation(1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    this.xZS.alive();
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.add(this.xZR);
    paramBundle = getBounceView();
    if (paramBundle != null) {
      paramBundle.setStart2EndBgColor(getResources().getColor(h.b.BW_93));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    kotlin.g.b.s.u(paramLayoutInflater, "inflater");
    Log.d(this.TAG, "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setHasOptionsMenu(false);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.d(this.TAG, "onDestroy");
    this.xZS.dead();
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjv.remove(this.xZR);
    b localb = dCK();
    localb.KA(6910);
    localb.KA(423);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Log.d(this.TAG, "onDestroyView");
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    Log.d(this.TAG, "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    Log.d(this.TAG, "onResume");
    dCK().Kz(6910);
    dCK().Kz(423);
    Object localObject2;
    if (this.xZM)
    {
      localObject1 = dCJ();
      if (!((i)localObject1).mfy.isEmpty())
      {
        localObject2 = com.tencent.mm.plugin.emoji.model.s.dAq().xMS;
        if ((localObject2 != null) && (!((Map)localObject2).isEmpty())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.kernel.h.baE().ban().d(208900, Boolean.FALSE);
        if (localObject1 != null) {
          break label230;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      }
      localObject2 = ((i)localObject1).mfy.iterator();
      label222:
      label228:
      for (;;)
      {
        label115:
        t localt;
        if (((Iterator)localObject2).hasNext())
        {
          localt = (t)((Iterator)localObject2).next();
          if (!(localt instanceof com.tencent.mm.plugin.emoji.ui.v3.a.s)) {
            continue;
          }
          localObject1 = ((com.tencent.mm.plugin.emoji.ui.v3.a.s)localt).ycP;
          if (localObject1 != null) {
            break label222;
          }
        }
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).xHE)
        {
          if (localObject1 == null) {
            break label228;
          }
          int i = com.tencent.mm.plugin.emoji.model.s.dAq().aoI(((cjb)localObject1).ProductID);
          localObject1 = ((com.tencent.mm.plugin.emoji.ui.v3.a.s)localt).ycP;
          if (localObject1 == null) {
            break label115;
          }
          if (i >= 0)
          {
            ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).setStatus(6);
            ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).boE = i;
          }
          if ((i >= 0) || (((com.tencent.mm.plugin.emoji.a.a.f)localObject1).mStatus != 6)) {
            break label115;
          }
          ((com.tencent.mm.plugin.emoji.a.a.f)localObject1).setStatus(3);
          break label115;
          break;
        }
      }
      label230:
      if (((Boolean)localObject1).booleanValue())
      {
        Log.i(this.TAG, "onResume needRefreshList");
        dCM();
        com.tencent.mm.kernel.h.baE().ban().B(208900, Boolean.FALSE);
      }
      localObject2 = dCJ();
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label291;
      }
    }
    label291:
    for (Object localObject1 = null;; localObject1 = ((RecyclerView)localObject1).getLayoutManager())
    {
      ((i)localObject2).i((RecyclerView.LayoutManager)localObject1);
      return;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Log.d(this.TAG, "onStop");
  }
  
  public final void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    dCK().xQj = new com.tencent.mm.plugin.emoji.e.h(paramString1, paramString2, paramString3, null, paramString4);
    paramString1 = dCK();
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)paramString1.xQj, 0);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    Log.d(this.TAG, kotlin.g.b.s.X("setUserVisibleHint :", Boolean.valueOf(paramBoolean)));
    super.setUserVisibleHint(paramBoolean);
    this.xZM = paramBoolean;
    if ((!dCK().xVJ) && (this.xZN)) {
      dCf();
    }
    if (this.xZM)
    {
      this.eqE.sendEmptyMessageDelayed(this.xVB, 0L);
      Log.d(this.TAG, "setUserVisibleHint try report 18662, 12875");
      i locali = dCJ();
      Object localObject = this.mkw;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((RecyclerView)localObject).getLayoutManager())
      {
        locali.i((RecyclerView.LayoutManager)localObject);
        return;
      }
    }
    this.eqE.removeMessages(this.xVB);
    dCJ().om(false);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeAdapter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<i>
  {
    public static final a xZU;
    
    static
    {
      AppMethodBeat.i(270546);
      xZU = new a();
      AppMethodBeat.o(270546);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseDataRepo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<b>
  {
    b(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/EmotionListExpose18662Data;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.emoji.ui.v3.b.c, ah>
  {
    public static final c xZW;
    
    static
    {
      AppMethodBeat.i(270536);
      xZW = new c();
      AppMethodBeat.o(270536);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/SingleProductExpose12875Data;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<d, ah>
  {
    public static final d xZX;
    
    static
    {
      AppMethodBeat.i(270527);
      xZX = new d();
      AppMethodBeat.o(270527);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$initStatusHandle$1", "Landroidx/lifecycle/Observer;", "", "onChanged", "", "status", "(Ljava/lang/Integer;)V", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements y<Integer>
  {
    e(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment) {}
    
    private static final void m(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment)
    {
      AppMethodBeat.i(270528);
      kotlin.g.b.s.u(paramEmojiStoreV3HomeBaseFragment, "this$0");
      Log.d(EmojiStoreV3HomeBaseFragment.b(paramEmojiStoreV3HomeBaseFragment), "page first reportExposeData 18662, 12875");
      i locali = EmojiStoreV3HomeBaseFragment.d(paramEmojiStoreV3HomeBaseFragment);
      paramEmojiStoreV3HomeBaseFragment = EmojiStoreV3HomeBaseFragment.k(paramEmojiStoreV3HomeBaseFragment);
      if (paramEmojiStoreV3HomeBaseFragment == null) {}
      for (paramEmojiStoreV3HomeBaseFragment = null;; paramEmojiStoreV3HomeBaseFragment = paramEmojiStoreV3HomeBaseFragment.getLayoutManager())
      {
        locali.i(paramEmojiStoreV3HomeBaseFragment);
        AppMethodBeat.o(270528);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$itemClickListener$1", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "onClick", "", "holder", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "position", "", "item", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "onRightViewClick", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements v
  {
    f(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment) {}
    
    public final void a(com.tencent.mm.plugin.emoji.ui.v3.a.e<?> parame, int paramInt, t paramt)
    {
      AppMethodBeat.i(270540);
      kotlin.g.b.s.u(parame, "holder");
      if (paramt == null)
      {
        AppMethodBeat.o(270540);
        return;
      }
      switch (paramt.getType())
      {
      }
      label647:
      for (;;)
      {
        AppMethodBeat.o(270540);
        return;
        if ((paramt instanceof com.tencent.mm.plugin.emoji.ui.v3.a.s))
        {
          parame = (com.tencent.mm.plugin.emoji.ui.v3.a.s)paramt;
          if (parame != null) {
            break label115;
          }
        }
        label115:
        for (parame = null;; parame = parame.ycP)
        {
          if (parame != null) {
            break label123;
          }
          Log.i(EmojiStoreV3HomeBaseFragment.b(this.xZV), "click Failed, type:1");
          AppMethodBeat.o(270540);
          return;
          parame = null;
          break;
        }
        label123:
        paramt = new bw();
        Object localObject = EmojiStoreV3HomeBaseFragment.d(this.xZV).KF(paramInt);
        if (localObject != null)
        {
          paramt.li(String.valueOf(paramInt - ((g)localObject).dIY));
          paramt.iqv = ((g)localObject).ybL;
        }
        localObject = com.tencent.mm.plugin.emoji.ui.v3.b.a.ycU;
        paramt.iuE = com.tencent.mm.plugin.emoji.ui.v3.b.a.dDm();
        paramt.iuF = 1;
        paramt.ipB = 3;
        paramt.lg(parame.xHE.ProductID);
        paramt.lh(parame.xHE.Zul);
        paramt.bMH();
        com.tencent.mm.plugin.emoji.mgr.k.a((Context)this.xZV.getContext(), parame.xHE, 1, parame.mStatus, parame.boE, EmojiStoreV3HomeBaseFragment.l(this.xZV), 5, paramt);
        AppMethodBeat.o(270540);
        return;
        AppMethodBeat.o(270540);
        return;
        if ((paramt instanceof aa))
        {
          parame = (aa)paramt;
          label284:
          if (parame != null) {
            break label345;
          }
        }
        label345:
        for (paramt = null; paramt != null; paramt = parame.ycR)
        {
          com.tencent.mm.plugin.emoji.mgr.k.a((Context)this.xZV.getContext(), paramt.hjP, paramt.hAP, paramt.IGG, paramt.IHo, paramt.akjV, com.tencent.mm.plugin.emoji.ui.v3.b.a.KJ(parame.id));
          AppMethodBeat.o(270540);
          return;
          parame = null;
          break label284;
        }
        if ((paramt instanceof ac))
        {
          parame = (ac)paramt;
          label365:
          if (parame != null) {
            break label463;
          }
        }
        label463:
        for (paramt = null; paramt != null; paramt = parame.ycT)
        {
          localObject = com.tencent.mm.plugin.emoji.g.a.ydF;
          localObject = this.xZV.thisActivity();
          kotlin.g.b.s.s(localObject, "thisActivity()");
          localObject = com.tencent.mm.plugin.emoji.g.a.a((Context)localObject, paramt, "", com.tencent.mm.plugin.emoji.ui.v3.b.a.KJ(parame.id), 24);
          this.xZV.startActivityForResult((Intent)localObject, 1);
          this.xZV.overridePendingTransition(h.a.pop_in, h.a.pop_out);
          com.tencent.mm.plugin.emoji.ui.v3.b.a.a(paramt, com.tencent.mm.plugin.emoji.ui.v3.b.a.KJ(parame.id));
          AppMethodBeat.o(270540);
          return;
          parame = null;
          break label365;
        }
        if ((paramt instanceof com.tencent.mm.plugin.emoji.ui.v3.a.q)) {}
        for (parame = (com.tencent.mm.plugin.emoji.ui.v3.a.q)paramt;; parame = null)
        {
          if (parame == null) {
            break label647;
          }
          localObject = parame.yaS;
          if (localObject == null) {
            break;
          }
          paramt = (Context)this.xZV.getContext();
          String str = parame.xUk;
          paramInt = com.tencent.mm.plugin.emoji.ui.v3.b.a.KJ(parame.id);
          parame = new Intent();
          parame.setClass(paramt, EmojiStoreV3TopicUI.class);
          parame.putExtra("topic_name", str);
          parame.putExtra("emotion_list_buf", (byte[])localObject);
          parame.putExtra("entrance_scene", paramInt);
          parame = new com.tencent.mm.hellhoundlib.b.a().cG(parame);
          com.tencent.mm.hellhoundlib.a.a.b(paramt, parame.aYi(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startV3TopicEmotionList", "(Landroid/content/Context;Ljava/lang/String;[BI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramt.startActivity((Intent)parame.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramt, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startV3TopicEmotionList", "(Landroid/content/Context;Ljava/lang/String;[BI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
      }
    }
    
    public final void b(com.tencent.mm.plugin.emoji.ui.v3.a.e<?> parame, int paramInt, t paramt)
    {
      AppMethodBeat.i(270553);
      kotlin.g.b.s.u(parame, "holder");
      if (paramt == null)
      {
        AppMethodBeat.o(270553);
        return;
      }
      Object localObject1;
      label73:
      label81:
      int i;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      boolean bool1;
      label389:
      label399:
      label405:
      int j;
      boolean bool2;
      if (paramt.getType() == 1)
      {
        localObject1 = (com.tencent.mm.plugin.emoji.ui.v3.a.j)parame;
        if ((paramt instanceof com.tencent.mm.plugin.emoji.ui.v3.a.s))
        {
          parame = (com.tencent.mm.plugin.emoji.ui.v3.a.s)paramt;
          if (parame != null) {
            break label73;
          }
        }
        for (parame = null;; parame = parame.ycP)
        {
          if (parame != null) {
            break label81;
          }
          AppMethodBeat.o(270553);
          return;
          parame = null;
          break;
        }
        i = parame.mStatus;
        localObject3 = EmojiStoreV3HomeBaseFragment.d(this.xZV).KF(paramInt);
        if (i == 9) {
          this.xZV.aoR(this.xZV.getString(h.h.app_uninstalling));
        }
        if (((com.tencent.mm.plugin.emoji.ui.v3.a.j)localObject1).ybU == null) {
          ((com.tencent.mm.plugin.emoji.ui.v3.a.j)localObject1).ybU = ((com.tencent.mm.plugin.emoji.model.p)EmojiStoreV3HomeBaseFragment.c(this.xZV).xZy);
        }
        if (((com.tencent.mm.plugin.emoji.ui.v3.a.j)localObject1).ycr == null)
        {
          parame = new n();
          paramt = this.xZV;
          parame.xNl = ((Context)paramt.thisActivity());
          parame.xNm = ((Fragment)paramt);
          parame.yct = ((w)localObject1);
          parame.ybU = ((com.tencent.mm.plugin.emoji.model.p)EmojiStoreV3HomeBaseFragment.c(paramt).xZy);
          if (localObject3 != null) {
            break label389;
          }
          i = 0;
          parame.xNn = i;
          localObject2 = new bw();
          ((bw)localObject2).iuF = 1;
          localObject4 = com.tencent.mm.plugin.emoji.ui.v3.b.a.ycU;
          ((bw)localObject2).iuE = com.tencent.mm.plugin.emoji.ui.v3.b.a.dDm();
          if (localObject3 != null)
          {
            ((bw)localObject2).li(String.valueOf(paramInt - ((g)localObject3).dIY));
            ((bw)localObject2).iqv = ((g)localObject3).ybL;
          }
          localObject3 = ah.aiuX;
          parame.xNu = ((bw)localObject2);
          parame.ycu = ((n.a)paramt);
          if ((!paramt.dCl()) || (!com.tencent.mm.plugin.emoji.model.j.dzN().xMI)) {
            break label399;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          parame.xNv = bool1;
          ((com.tencent.mm.plugin.emoji.ui.v3.a.j)localObject1).ycr = parame;
          EmojiStoreV3HomeBaseFragment.a(this.xZV, ((com.tencent.mm.plugin.emoji.ui.v3.a.j)localObject1).ycr);
          localObject1 = ((com.tencent.mm.plugin.emoji.ui.v3.a.j)localObject1).ycr;
          if (localObject1 == null) {
            break label669;
          }
          if ((((n)localObject1).yct != null) && (((n)localObject1).yct.dDd() != null)) {
            break label405;
          }
          AppMethodBeat.o(270553);
          return;
          i = ((g)localObject3).ybL;
          break;
        }
        parame = ((n)localObject1).yct.dDd();
        if (parame != null) {
          ((n)localObject1).xHE = parame.xHE;
        }
        if (((n)localObject1).xHE != null)
        {
          localObject2 = ((n)localObject1).xHE.ProductID;
          localObject4 = ((n)localObject1).xHE.Zul;
          paramt = ((n)localObject1).xHE.akkj;
          localObject3 = ((n)localObject1).xHE.Zuw;
          paramInt = ((n)localObject1).xHE.akke;
          i = ((n)localObject1).xHE.akkw;
          j = ((n)localObject1).yct.dDd().mStatus;
          ((n)localObject1).yct.dDd();
          bool1 = com.tencent.mm.plugin.emoji.ui.v3.a.h.dDc();
          bool2 = ((n)localObject1).yct.dDd().xHJ;
          if (!TextUtils.isEmpty(paramt)) {
            break label676;
          }
          parame = "";
          Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "[onProductClick] productId:%s, productPrice:%s, productStatus:%d", new Object[] { localObject2, parame, Integer.valueOf(j) });
          ((n)localObject1).xNr = ((String)localObject2);
        }
      }
      switch (j)
      {
      case 1: 
      case 2: 
      case 6: 
      case 8: 
      default: 
        Log.w("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "[onProductClick] unkonw product status");
      case 9: 
      case 0: 
      case 7: 
      case 4: 
      case 12: 
      case 3: 
      case 5: 
      case -1: 
      case 10: 
        label669:
        label676:
        label806:
        do
        {
          do
          {
            do
            {
              do
              {
                AppMethodBeat.o(270553);
                return;
                parame = paramt;
                break;
                parame = new com.tencent.mm.plugin.emoji.e.s((String)localObject2, 2);
                com.tencent.mm.kernel.h.baD().mCm.a(parame, 0);
                AppMethodBeat.o(270553);
                return;
                ((n)localObject1).yct.bg(3, (String)localObject2);
                AppMethodBeat.o(270553);
                return;
                if (bool2)
                {
                  if (((n)localObject1).xNm != null)
                  {
                    paramInt = 1;
                    if (paramInt == 0) {
                      break label806;
                    }
                    n.xNs.u(((n)localObject1).xNm);
                  }
                  for (;;)
                  {
                    n.xNs.ydM = ((String)localObject2);
                    com.tencent.mm.plugin.report.service.h.OAn.b(12069, new Object[] { Integer.valueOf(1), localObject2 });
                    AppMethodBeat.o(270553);
                    return;
                    paramInt = 0;
                    break;
                    n.xNs.X((Activity)((n)localObject1).xNl);
                  }
                }
              } while (!((n)localObject1).yct.dDd().xHL);
              parame = ((n)localObject1).yct.dDd().xHE.ProductID;
              localObject2 = ((n)localObject1).yct.dDd().xHE.Zul;
              localObject3 = ((n)localObject1).xNt;
              if (((n)localObject1).xNl != null)
              {
                if (((n)localObject1).xNn == 9) {}
                for (paramInt = 3;; paramInt = 4)
                {
                  paramt = new Intent();
                  paramt.setClass(((n)localObject1).xNl, EmojiStoreV2RewardUI.class);
                  paramt.putExtra("extra_id", parame);
                  paramt.putExtra("extra_name", (String)localObject2);
                  paramt.putExtra("name", (String)localObject3);
                  paramt.putExtra("scene", ((n)localObject1).xNn);
                  paramt.putExtra("pageType", paramInt);
                  paramt.putExtra("searchID", ((n)localObject1).xNo);
                  localObject2 = ((n)localObject1).xNl;
                  paramt = new com.tencent.mm.hellhoundlib.b.a().cG(paramt);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramt.aYi(), "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject2).startActivity((Intent)paramt.sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent", "startRewardUI", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.plugin.report.service.h.OAn.b(12738, new Object[] { parame, Integer.valueOf(paramInt), Integer.valueOf(((n)localObject1).xNn), Integer.valueOf(0) });
                  AppMethodBeat.o(270553);
                  return;
                }
              }
              Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "start reward ui faild. context is null");
              AppMethodBeat.o(270553);
              return;
            } while (((n)localObject1).xNk);
            if (com.tencent.mm.plugin.emoji.g.b.KK(paramInt))
            {
              if (com.tencent.mm.plugin.emoji.g.b.dDq())
              {
                com.tencent.mm.plugin.emoji.g.b.dDr();
                com.tencent.mm.plugin.emoji.g.b.ga(((n)localObject1).xNl).dDn();
                AppMethodBeat.o(270553);
                return;
              }
              com.tencent.mm.plugin.emoji.g.b.c(((n)localObject1).xNl, (String)localObject2, (String)localObject3, i, (String)localObject4);
              com.tencent.mm.plugin.emoji.g.b.dDr();
              ((n)localObject1).xNk = true;
              com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(((n)localObject1).xNn), "", localObject2, Long.valueOf(((n)localObject1).xNo), ((n)localObject1).xNp });
              AppMethodBeat.o(270553);
              return;
            }
            parame = new Intent();
            parame.putExtra("key_product_id", (String)localObject2);
            Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "onProductClick: price %s, currency %s", new Object[] { paramt, localObject3 });
            if (bool1)
            {
              parame.putExtra("key_currency_type", (String)localObject3);
              parame.putExtra("key_price", (String)localObject3 + paramt);
            }
            for (;;)
            {
              com.tencent.mm.br.c.b(((n)localObject1).xNl, "wallet_index", ".ui.WalletIapUI", parame, 2001);
              ((n)localObject1).xNk = true;
              com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(((n)localObject1).xNn), "", localObject2, Long.valueOf(((n)localObject1).xNo), ((n)localObject1).xNp });
              AppMethodBeat.o(270553);
              return;
              parame.putExtra("key_currency_type", (String)localObject3);
              parame.putExtra("key_price", paramt);
            }
            if (com.tencent.mm.plugin.emoji.g.c.i(((n)localObject1).xHE))
            {
              com.tencent.mm.plugin.emoji.e.a.dAs();
              com.tencent.mm.plugin.emoji.e.a.dAt();
              AppMethodBeat.o(270553);
              return;
            }
            ((n)localObject1).r((String)localObject2, null, (String)localObject4, ((n)localObject1).xHE.akkk);
            ((n)localObject1).yct.aoY((String)localObject2);
            Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { localObject2 });
            com.tencent.mm.plugin.report.service.h.OAn.b(12066, new Object[] { Integer.valueOf(0), Integer.valueOf(((n)localObject1).xNn), "", localObject2, Long.valueOf(((n)localObject1).xNo), ((n)localObject1).xNp });
          } while (((n)localObject1).xNu == null);
          ((n)localObject1).xNu.ipB = 2;
          ((n)localObject1).xNu.lg(((n)localObject1).xHE.ProductID);
          ((n)localObject1).xNu.lh(((n)localObject1).xHE.Zul);
          ((n)localObject1).xNu.bMH();
          AppMethodBeat.o(270553);
          return;
          if (com.tencent.mm.plugin.emoji.a.a.e.a(((n)localObject1).xHE)) {
            paramInt = 3;
          }
          for (;;)
          {
            ((n)localObject1).yct.bg(paramInt, (String)localObject2);
            AppMethodBeat.o(270553);
            return;
            if ((com.tencent.mm.plugin.emoji.a.a.e.b(((n)localObject1).xHE)) || ((!bool1) && (TextUtils.isEmpty(((n)localObject1).xHE.akkc))))
            {
              paramInt = 3;
            }
            else
            {
              if (bool1)
              {
                if (((n)localObject1).ybU == null) {
                  break;
                }
                parame = ((n)localObject1).ybU.anQ((String)localObject2);
                if (parame == null) {
                  break;
                }
                if (TextUtils.isEmpty(parame.adjh))
                {
                  paramInt = parame.adjd;
                  continue;
                }
              }
              paramInt = 4;
            }
          }
        } while (((n)localObject1).ybU == null);
        parame = ((n)localObject1).ybU.anQ((String)localObject2);
        if (parame != null) {
          switch (parame.adje)
          {
          default: 
            parame = ((n)localObject1).getString(h.h.emoji_unknow);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.k.c(((n)localObject1).xNl, parame, null, true);
          AppMethodBeat.o(270553);
          return;
          parame = ((n)localObject1).getString(h.h.emoji_google_no_install);
          continue;
          parame = ((n)localObject1).getString(h.h.emoji_no_on_sale);
          continue;
          parame = ((n)localObject1).getString(h.h.emoji_timeout);
        }
      }
      Log.w("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
      AppMethodBeat.o(270553);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomeBaseFragment$mUIHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends MMHandler
  {
    g(EmojiStoreV3HomeBaseFragment paramEmojiStoreV3HomeBaseFragment) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(270519);
      kotlin.g.b.s.u(paramMessage, "msg");
      EmojiStoreV3HomeBaseFragment localEmojiStoreV3HomeBaseFragment = this.xZV;
      kotlin.g.b.s.u(paramMessage, "msg");
      int i = paramMessage.what;
      String str;
      if (i == localEmojiStoreV3HomeBaseFragment.xPW)
      {
        if (paramMessage.getData() != null)
        {
          str = paramMessage.getData().getString(localEmojiStoreV3HomeBaseFragment.xPY);
          if (str != null)
          {
            i = paramMessage.getData().getInt(localEmojiStoreV3HomeBaseFragment.xPZ);
            Log.d(localEmojiStoreV3HomeBaseFragment.TAG, "Update Progress " + i + ", productId:" + str);
            localEmojiStoreV3HomeBaseFragment.dCJ().a((com.tencent.mm.plugin.emoji.ui.v3.a.f)new f.a(str, i));
            AppMethodBeat.o(270519);
          }
        }
      }
      else if (i == localEmojiStoreV3HomeBaseFragment.xPX)
      {
        if (paramMessage.getData() != null)
        {
          str = paramMessage.getData().getString(localEmojiStoreV3HomeBaseFragment.xPY);
          if (str != null)
          {
            i = paramMessage.getData().getInt(localEmojiStoreV3HomeBaseFragment.xQa);
            localEmojiStoreV3HomeBaseFragment.dCJ().a((com.tencent.mm.plugin.emoji.ui.v3.a.f)new f.b(str, i));
            AppMethodBeat.o(270519);
          }
        }
      }
      else if (i == localEmojiStoreV3HomeBaseFragment.xVB) {
        localEmojiStoreV3HomeBaseFragment.dCJ().om(true);
      }
      AppMethodBeat.o(270519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3HomeBaseFragment
 * JD-Core Version:    0.7.0.1
 */