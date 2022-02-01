package com.tencent.mm.an.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.api.b;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b.a;
import com.tencent.mm.msgsubscription.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "bizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "bizUsername", "", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSettingReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "subscribeSwitch", "canShow", "it", "createAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/ui/MMActivity;", "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "initReportInfo", "result", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "reportSubscribeSettingOp", "opType", "", "updateOriginTmpMap", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.msgsubscription.presenter.a
{
  public static final a.a oyA;
  private Activity activity;
  private String hUQ;
  private boolean needUpdate;
  private boolean oyB;
  private com.tencent.mm.msgsubscription.b.a oyC;
  SubscribeMsgRequestResult oyD;
  private HashMap<String, SubscribeMsgTmpItem> oyE;
  private com.tencent.mm.msgsubscription.c.a.c oyF;
  private d oyG;
  
  static
  {
    AppMethodBeat.i(124726);
    oyA = new a.a((byte)0);
    AppMethodBeat.o(124726);
  }
  
  public a()
  {
    AppMethodBeat.i(124725);
    b localb = b.piw;
    this.oyC = b.QW("name_biz");
    this.oyE = new HashMap();
    this.needUpdate = true;
    this.hUQ = "";
    this.oyF = new com.tencent.mm.msgsubscription.c.a.c();
    this.oyG = new d(this);
    AppMethodBeat.o(124725);
  }
  
  private static List<SubscribeMsgTmpItem> a(HashMap<String, SubscribeMsgTmpItem> paramHashMap, List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124724);
    List localList = (List)new ArrayList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)paramList.next();
        SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramHashMap.get(localSubscribeMsgTmpItem1.nSg);
        if (localSubscribeMsgTmpItem2 != null)
        {
          String str = localSubscribeMsgTmpItem2.nSg;
          if ((str == null) || (str.equals(localSubscribeMsgTmpItem1.nSg) != true)) {}
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label131;
          }
          if (localSubscribeMsgTmpItem2.phT == localSubscribeMsgTmpItem1.phT) {
            break;
          }
          localList.add(localSubscribeMsgTmpItem1);
          break;
        }
        label131:
        localList.add(localSubscribeMsgTmpItem1);
      }
    }
    AppMethodBeat.o(124724);
    return localList;
  }
  
  private final void a(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(239426);
    if (paramSubscribeMsgRequestResult == null)
    {
      AppMethodBeat.o(239426);
      return;
    }
    this.oyF.QZ(this.hUQ);
    this.oyF.pjQ = paramSubscribeMsgRequestResult.phG;
    this.oyF.pjR = paramSubscribeMsgRequestResult.phC.size();
    paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.phC).iterator();
    while (paramSubscribeMsgRequestResult.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
      this.oyF.pjo.add(localSubscribeMsgTmpItem.nSg);
      this.oyF.pjS.add(Integer.valueOf(localSubscribeMsgTmpItem.phR));
      this.oyF.pjT.add(localSubscribeMsgTmpItem.title);
      this.oyF.pjM.add(Integer.valueOf(localSubscribeMsgTmpItem.phT));
    }
    AppMethodBeat.o(239426);
  }
  
  public static boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(124720);
    s.u(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.phT == 1)
    {
      AppMethodBeat.o(124720);
      return true;
    }
    AppMethodBeat.o(124720);
    return false;
  }
  
  private final void bZ(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124717);
    this.oyE.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
        ((Map)this.oyE).put(localSubscribeMsgTmpItem.nSg, new SubscribeMsgTmpItem(localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.nSg, localSubscribeMsgTmpItem.phR, localSubscribeMsgTmpItem.pht, localSubscribeMsgTmpItem.phS, localSubscribeMsgTmpItem.phT, localSubscribeMsgTmpItem.hU, localSubscribeMsgTmpItem.phQ));
      }
    }
    AppMethodBeat.o(124717);
  }
  
  private final void vU(int paramInt)
  {
    AppMethodBeat.i(239430);
    com.tencent.mm.msgsubscription.c.a.a(paramInt, this.oyF);
    AppMethodBeat.o(239430);
  }
  
  public final void A(Activity paramActivity)
  {
    AppMethodBeat.i(124723);
    s.u(paramActivity, "activity");
    super.A(paramActivity);
    Intent localIntent;
    Object localObject1;
    if (!this.needUpdate)
    {
      Log.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
      localIntent = new Intent();
      Object localObject2 = this.oyE;
      localObject1 = this.oyD;
      if (localObject1 != null) {
        break label252;
      }
      localObject1 = null;
      localObject1 = a((HashMap)localObject2, (List)localObject1);
      if (((Collection)localObject1).isEmpty()) {
        break label262;
      }
      i = 1;
      label90:
      if (i == 0)
      {
        localObject2 = this.oyD;
        if ((localObject2 == null) || (((SubscribeMsgRequestResult)localObject2).phG != this.oyB)) {
          break label267;
        }
        i = 1;
        label119:
        if (i != 0) {
          break label272;
        }
      }
    }
    label262:
    label267:
    label272:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        localIntent.putExtra("key_biz_data", (Parcelable)new ISubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject1, this.oyB));
      }
      localIntent.putExtra("key_need_update", bool);
      paramActivity.setResult(-1, localIntent);
      this.oyF.pjQ = this.oyB;
      paramActivity = this.oyD;
      if (paramActivity == null) {
        break label277;
      }
      paramActivity = paramActivity.phC;
      if (paramActivity == null) {
        break label277;
      }
      paramActivity = ((Iterable)paramActivity).iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (SubscribeMsgTmpItem)paramActivity.next();
        this.oyF.pjU.add(Integer.valueOf(((SubscribeMsgTmpItem)localObject1).phT));
      }
      label252:
      localObject1 = ((SubscribeMsgRequestResult)localObject1).phC;
      break;
      i = 0;
      break label90;
      i = 0;
      break label119;
    }
    label277:
    vU(2);
    if (((CharSequence)this.hUQ).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.oyD != null))
      {
        paramActivity = com.tencent.mm.msgsubscription.c.a.pjH;
        paramActivity = this.hUQ;
        localObject1 = this.oyD;
        s.checkNotNull(localObject1);
        bool = ((SubscribeMsgRequestResult)localObject1).phG;
        localObject1 = this.oyD;
        s.checkNotNull(localObject1);
        com.tencent.mm.msgsubscription.c.a.b(paramActivity, bool, (List)((SubscribeMsgRequestResult)localObject1).phC);
      }
      AppMethodBeat.o(124723);
      return;
    }
  }
  
  public final void a(String paramString, final b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(124716);
    s.u(paramString, "bizUsername");
    s.u(parama, "l");
    Activity localActivity = this.activity;
    Object localObject1 = localActivity;
    if (localActivity == null)
    {
      s.bIx("activity");
      localObject1 = null;
    }
    this.oyD = ((SubscribeMsgRequestResult)((Activity)localObject1).getIntent().getParcelableExtra("key_biz_data"));
    this.hUQ = paramString;
    if (this.oyD != null)
    {
      paramString = this.oyD;
      s.checkNotNull(paramString);
      this.oyB = paramString.phG;
      paramString = this.oyD;
      s.checkNotNull(paramString);
      bZ((List)paramString.phC);
      paramString = this.oyD;
      s.checkNotNull(paramString);
      parama.a(new SubscribeMsgSettingData(paramString));
      a(this.oyD);
      vU(1);
      AppMethodBeat.o(124716);
      return;
    }
    localObject1 = this.activity;
    if (localObject1 == null)
    {
      s.bIx("activity");
      localObject1 = localObject2;
    }
    for (;;)
    {
      boolean bool = ((Activity)localObject1).getIntent().getBooleanExtra("key_need_load_from_remote", false);
      Log.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
      if (!bool) {
        break;
      }
      localObject1 = this.oyC;
      if (localObject1 != null) {
        ((com.tencent.mm.msgsubscription.b.a)localObject1).a(paramString, (com.tencent.mm.msgsubscription.api.a)new c(this, parama));
      }
      AppMethodBeat.o(124716);
      return;
    }
    parama.atR();
    AppMethodBeat.o(124716);
  }
  
  public final com.tencent.mm.msgsubscription.ui.a<?> b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(239453);
    s.u(paramMMActivity, "activity");
    paramMMActivity = (com.tencent.mm.msgsubscription.ui.a)new e((Context)paramMMActivity, (com.tencent.mm.msgsubscription.ui.a.a)new b(this));
    AppMethodBeat.o(239453);
    return paramMMActivity;
  }
  
  public final void he(boolean paramBoolean)
  {
    this.oyB = paramBoolean;
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(124722);
    s.u(paramActivity, "activity");
    boolean bool = this.oyB;
    paramActivity = this.oyD;
    label74:
    label102:
    int i;
    if (paramActivity == null)
    {
      paramActivity = null;
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", new Object[] { Boolean.valueOf(bool), paramActivity, Boolean.valueOf(this.needUpdate) });
      paramActivity = this.oyD;
      if (paramActivity != null) {
        break label276;
      }
      paramActivity = null;
      if ((paramActivity != null) && (this.needUpdate))
      {
        Object localObject = this.oyE;
        paramActivity = this.oyD;
        if (paramActivity != null) {
          break label284;
        }
        paramActivity = null;
        paramActivity = a((HashMap)localObject, (List)paramActivity);
        if (((Collection)paramActivity).isEmpty()) {
          break label292;
        }
        i = 1;
        label126:
        if (i == 0)
        {
          localObject = this.oyD;
          if ((localObject == null) || (((SubscribeMsgRequestResult)localObject).phG != this.oyB)) {
            break label297;
          }
          i = 1;
          if (i != 0) {
            break label302;
          }
        }
        label155:
        i = 1;
        label161:
        if (i == 0) {
          break label307;
        }
        localObject = new com.tencent.mm.msgsubscription.api.c();
        ((com.tencent.mm.msgsubscription.api.c)localObject).setUsername(bQc().getUserName());
        ((com.tencent.mm.msgsubscription.api.c)localObject).pis.addAll((Collection)paramActivity);
        ((com.tencent.mm.msgsubscription.api.c)localObject).piy = this.oyB;
        ((com.tencent.mm.msgsubscription.api.c)localObject).piB = ((com.tencent.mm.msgsubscription.api.a)this.oyG);
        ((com.tencent.mm.msgsubscription.api.c)localObject).piC = true;
        ((com.tencent.mm.msgsubscription.api.c)localObject).piD = true;
        paramActivity = this.oyC;
        if (paramActivity != null) {
          paramActivity.a((com.tencent.mm.msgsubscription.api.c)localObject);
        }
      }
    }
    for (;;)
    {
      this.oyE.clear();
      AppMethodBeat.o(124722);
      return;
      paramActivity = Boolean.valueOf(paramActivity.phG);
      break;
      label276:
      paramActivity = paramActivity.phC;
      break label74;
      label284:
      paramActivity = paramActivity.phC;
      break label102;
      label292:
      i = 0;
      break label126;
      label297:
      i = 0;
      break label155;
      label302:
      i = 0;
      break label161;
      label307:
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(124721);
    s.u(paramActivity, "activity");
    super.onActivityResumed(paramActivity);
    this.needUpdate = paramActivity.getIntent().getBooleanExtra("key_need_update", true);
    AppMethodBeat.o(124721);
  }
  
  public final void z(Activity paramActivity)
  {
    int i = 0;
    AppMethodBeat.i(124715);
    s.u(paramActivity, "activity");
    super.z(paramActivity);
    this.activity = paramActivity;
    this.oyF.sessionId = System.currentTimeMillis();
    com.tencent.mm.msgsubscription.c.a.c localc = this.oyF;
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    for (;;)
    {
      localc.enterScene = i;
      AppMethodBeat.o(124715);
      return;
      i = paramActivity.getIntExtra("key_enter_scene", 0);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$createAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.msgsubscription.ui.a.a
  {
    b(a parama) {}
    
    public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
    {
      AppMethodBeat.i(239418);
      s.u(paramSubscribeMsgTmpItem, "item");
      Object localObject = this.oyH;
      s.u(paramSubscribeMsgTmpItem, "itemChanged");
      localObject = ((a)localObject).oyD;
      s.checkNotNull(localObject);
      localObject = ((SubscribeMsgRequestResult)localObject).phC.iterator();
      SubscribeMsgTmpItem localSubscribeMsgTmpItem;
      while (((Iterator)localObject).hasNext())
      {
        localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
        if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.nSg, (CharSequence)localSubscribeMsgTmpItem.nSg)) {
          if (!paramBoolean) {
            break label115;
          }
        }
      }
      label115:
      for (int i = 1;; i = 0)
      {
        localSubscribeMsgTmpItem.phT = i;
        paramSubscribeMsgTmpItem.phT = localSubscribeMsgTmpItem.phT;
        AppMethodBeat.o(239418);
        return;
      }
    }
    
    public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
    {
      AppMethodBeat.i(239420);
      s.u(paramSubscribeMsgTmpItem, "item");
      boolean bool = a.a(paramSubscribeMsgTmpItem);
      AppMethodBeat.o(239420);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.msgsubscription.api.a
  {
    c(a parama, b.a parama1) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124711);
      s.u(paramString, "bizUsername");
      s.u(paramSubscribeMsgRequestResult, "result");
      a.a(this.oyH, paramSubscribeMsgRequestResult);
      paramString = this.oyH;
      paramSubscribeMsgRequestResult = a.a(this.oyH);
      s.checkNotNull(paramSubscribeMsgRequestResult);
      a.a(paramString, paramSubscribeMsgRequestResult.phG);
      paramString = this.oyH;
      paramSubscribeMsgRequestResult = a.a(this.oyH);
      s.checkNotNull(paramSubscribeMsgRequestResult);
      a.a(paramString, (List)paramSubscribeMsgRequestResult.phC);
      paramString = parama;
      paramSubscribeMsgRequestResult = a.a(this.oyH);
      s.checkNotNull(paramSubscribeMsgRequestResult);
      paramString.a(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult));
      a.b(this.oyH, a.a(this.oyH));
      a.b(this.oyH);
      AppMethodBeat.o(124711);
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124712);
      s.u(paramString, "errMsg");
      parama.atR();
      AppMethodBeat.o(124712);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.msgsubscription.api.a
  {
    d(a parama) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124713);
      s.u(paramString, "bizUsername");
      s.u(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
      a.b(this.oyH, (List)paramSubscribeMsgRequestResult.phC);
      AppMethodBeat.o(124713);
    }
    
    public final void j(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124714);
      s.u(paramString, "errMsg");
      Log.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(124714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.b.a
 * JD-Core Version:    0.7.0.1
 */