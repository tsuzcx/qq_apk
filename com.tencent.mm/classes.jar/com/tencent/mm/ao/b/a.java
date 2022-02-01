package com.tencent.mm.ao.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "bizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "bizUsername", "", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSettingReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "subscribeSwitch", "canShow", "it", "createAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/ui/MMActivity;", "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "initReportInfo", "result", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "reportSubscribeSettingOp", "opType", "", "updateOriginTmpMap", "Companion", "plugin-biz_release"})
public final class a
  extends com.tencent.mm.msgsubscription.presenter.a
{
  public static final a.a lGZ;
  private Activity activity;
  private String fOX;
  private boolean lGT;
  private com.tencent.mm.msgsubscription.b.a lGU;
  SubscribeMsgRequestResult lGV;
  private HashMap<String, SubscribeMsgTmpItem> lGW;
  private com.tencent.mm.msgsubscription.c.a.c lGX;
  private d lGY;
  private boolean needUpdate;
  
  static
  {
    AppMethodBeat.i(124726);
    lGZ = new a.a((byte)0);
    AppMethodBeat.o(124726);
  }
  
  public a()
  {
    AppMethodBeat.i(124725);
    com.tencent.mm.msgsubscription.api.b localb = com.tencent.mm.msgsubscription.api.b.moG;
    this.lGU = com.tencent.mm.msgsubscription.api.b.YR("name_biz");
    this.lGW = new HashMap();
    this.needUpdate = true;
    this.fOX = "";
    this.lGX = new com.tencent.mm.msgsubscription.c.a.c();
    this.lGY = new d(this);
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
        SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramHashMap.get(localSubscribeMsgTmpItem1.lnb);
        if (localSubscribeMsgTmpItem2 != null)
        {
          String str = localSubscribeMsgTmpItem2.lnb;
          if ((str != null) && (str.equals(localSubscribeMsgTmpItem1.lnb) == true))
          {
            if (localSubscribeMsgTmpItem2.mof == localSubscribeMsgTmpItem1.mof) {
              continue;
            }
            localList.add(localSubscribeMsgTmpItem1);
            continue;
          }
        }
        localList.add(localSubscribeMsgTmpItem1);
      }
    }
    AppMethodBeat.o(124724);
    return localList;
  }
  
  private final void a(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(208097);
    if (paramSubscribeMsgRequestResult == null)
    {
      AppMethodBeat.o(208097);
      return;
    }
    this.lGX.YU(this.fOX);
    this.lGX.mqe = paramSubscribeMsgRequestResult.mnS;
    this.lGX.mqf = paramSubscribeMsgRequestResult.mnO.size();
    paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.mnO).iterator();
    while (paramSubscribeMsgRequestResult.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
      this.lGX.mpy.add(localSubscribeMsgTmpItem.lnb);
      this.lGX.mqg.add(Integer.valueOf(localSubscribeMsgTmpItem.mod));
      this.lGX.mqh.add(localSubscribeMsgTmpItem.title);
      this.lGX.mqa.add(Integer.valueOf(localSubscribeMsgTmpItem.mof));
    }
    AppMethodBeat.o(208097);
  }
  
  public static boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(124720);
    p.k(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.mof == 1)
    {
      AppMethodBeat.o(124720);
      return true;
    }
    AppMethodBeat.o(124720);
    return false;
  }
  
  private final void au(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124717);
    this.lGW.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
        ((Map)this.lGW).put(localSubscribeMsgTmpItem.lnb, new SubscribeMsgTmpItem(localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.lnb, localSubscribeMsgTmpItem.mod, localSubscribeMsgTmpItem.mnG, localSubscribeMsgTmpItem.moe, localSubscribeMsgTmpItem.mof, localSubscribeMsgTmpItem.gZ, localSubscribeMsgTmpItem.moc));
      }
      AppMethodBeat.o(124717);
      return;
    }
    AppMethodBeat.o(124717);
  }
  
  private final void vP(int paramInt)
  {
    AppMethodBeat.i(208099);
    com.tencent.mm.msgsubscription.c.a.a(paramInt, this.lGX);
    AppMethodBeat.o(208099);
  }
  
  public final void a(String paramString, final b.a parama)
  {
    AppMethodBeat.i(124716);
    p.k(paramString, "bizUsername");
    p.k(parama, "l");
    Object localObject = this.activity;
    if (localObject == null) {
      p.bGy("activity");
    }
    this.lGV = ((SubscribeMsgRequestResult)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    this.fOX = paramString;
    if (this.lGV != null)
    {
      paramString = this.lGV;
      if (paramString == null) {
        p.iCn();
      }
      this.lGT = paramString.mnS;
      paramString = this.lGV;
      if (paramString == null) {
        p.iCn();
      }
      au((List)paramString.mnO);
      paramString = this.lGV;
      if (paramString == null) {
        p.iCn();
      }
      parama.a(new SubscribeMsgSettingData(paramString));
      a(this.lGV);
      vP(1);
      AppMethodBeat.o(124716);
      return;
    }
    localObject = this.activity;
    if (localObject == null) {
      p.bGy("activity");
    }
    boolean bool = ((Activity)localObject).getIntent().getBooleanExtra("key_need_load_from_remote", false);
    Log.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
    if (bool)
    {
      localObject = this.lGU;
      if (localObject != null)
      {
        ((com.tencent.mm.msgsubscription.b.a)localObject).a(paramString, (com.tencent.mm.msgsubscription.api.a)new c(this, parama));
        AppMethodBeat.o(124716);
        return;
      }
      AppMethodBeat.o(124716);
      return;
    }
    parama.onError();
    AppMethodBeat.o(124716);
  }
  
  public final com.tencent.mm.msgsubscription.ui.a<?> b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(208095);
    p.k(paramMMActivity, "activity");
    paramMMActivity = (com.tencent.mm.msgsubscription.ui.a)new com.tencent.mm.msgsubscription.ui.b((Context)paramMMActivity, (com.tencent.mm.msgsubscription.ui.a.a)new b(this));
    AppMethodBeat.o(208095);
    return paramMMActivity;
  }
  
  public final void gn(boolean paramBoolean)
  {
    this.lGT = paramBoolean;
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    int i = 0;
    AppMethodBeat.i(124715);
    p.k(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    this.lGX.sessionId = System.currentTimeMillis();
    com.tencent.mm.msgsubscription.c.a.c localc = this.lGX;
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null) {
      i = paramActivity.getIntExtra("key_enter_scene", 0);
    }
    localc.enterScene = i;
    AppMethodBeat.o(124715);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(124722);
    p.k(paramActivity, "activity");
    boolean bool = this.lGT;
    paramActivity = this.lGV;
    label83:
    label114:
    int i;
    if (paramActivity != null)
    {
      paramActivity = Boolean.valueOf(paramActivity.mnS);
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", new Object[] { Boolean.valueOf(bool), paramActivity, Boolean.valueOf(this.needUpdate) });
      paramActivity = this.lGV;
      if (paramActivity == null) {
        break label276;
      }
      paramActivity = paramActivity.mnO;
      if ((paramActivity != null) && (this.needUpdate))
      {
        Object localObject = this.lGW;
        paramActivity = this.lGV;
        if (paramActivity == null) {
          break label281;
        }
        paramActivity = paramActivity.mnO;
        paramActivity = a((HashMap)localObject, (List)paramActivity);
        if (((Collection)paramActivity).isEmpty()) {
          break label286;
        }
        i = 1;
        label138:
        if (i == 0)
        {
          localObject = this.lGV;
          if ((localObject != null) && (((SubscribeMsgRequestResult)localObject).mnS == this.lGT)) {
            break label291;
          }
        }
        i = 1;
        label167:
        if (i == 0) {
          break label296;
        }
        localObject = new com.tencent.mm.msgsubscription.api.c();
        ((com.tencent.mm.msgsubscription.api.c)localObject).setUsername(bsw().getUserName());
        ((com.tencent.mm.msgsubscription.api.c)localObject).moB.addAll((Collection)paramActivity);
        ((com.tencent.mm.msgsubscription.api.c)localObject).moH = this.lGT;
        ((com.tencent.mm.msgsubscription.api.c)localObject).moK = ((com.tencent.mm.msgsubscription.api.a)this.lGY);
        ((com.tencent.mm.msgsubscription.api.c)localObject).moL = true;
        ((com.tencent.mm.msgsubscription.api.c)localObject).moM = true;
        paramActivity = this.lGU;
        if (paramActivity != null) {
          paramActivity.a((com.tencent.mm.msgsubscription.api.c)localObject);
        }
      }
    }
    for (;;)
    {
      this.lGW.clear();
      AppMethodBeat.o(124722);
      return;
      paramActivity = null;
      break;
      label276:
      paramActivity = null;
      break label83;
      label281:
      paramActivity = null;
      break label114;
      label286:
      i = 0;
      break label138;
      label291:
      i = 0;
      break label167;
      label296:
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(124721);
    p.k(paramActivity, "activity");
    super.onActivityResumed(paramActivity);
    this.needUpdate = paramActivity.getIntent().getBooleanExtra("key_need_update", true);
    AppMethodBeat.o(124721);
  }
  
  public final void x(Activity paramActivity)
  {
    AppMethodBeat.i(124723);
    p.k(paramActivity, "activity");
    super.x(paramActivity);
    Intent localIntent;
    Object localObject1;
    if (!this.needUpdate)
    {
      Log.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
      localIntent = new Intent();
      Object localObject2 = this.lGW;
      localObject1 = this.lGV;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((SubscribeMsgRequestResult)localObject1).mnO;
      localObject1 = a((HashMap)localObject2, (List)localObject1);
      if (((Collection)localObject1).isEmpty()) {
        break label256;
      }
      i = 1;
      label94:
      if (i == 0)
      {
        localObject2 = this.lGV;
        if ((localObject2 != null) && (((SubscribeMsgRequestResult)localObject2).mnS == this.lGT)) {
          break label261;
        }
      }
    }
    label256:
    label261:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        localIntent.putExtra("key_biz_data", (Parcelable)new ISubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject1, this.lGT));
      }
      localIntent.putExtra("key_need_update", bool);
      paramActivity.setResult(-1, localIntent);
      this.lGX.mqe = this.lGT;
      paramActivity = this.lGV;
      if (paramActivity == null) {
        break label266;
      }
      paramActivity = paramActivity.mnO;
      if (paramActivity == null) {
        break label266;
      }
      paramActivity = ((Iterable)paramActivity).iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (SubscribeMsgTmpItem)paramActivity.next();
        this.lGX.mqi.add(Integer.valueOf(((SubscribeMsgTmpItem)localObject1).mof));
      }
      label250:
      localObject1 = null;
      break;
      i = 0;
      break label94;
    }
    label266:
    vP(2);
    if (((CharSequence)this.fOX).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.lGV != null))
      {
        paramActivity = com.tencent.mm.msgsubscription.c.a.mpZ;
        paramActivity = this.fOX;
        localObject1 = this.lGV;
        if (localObject1 == null) {
          p.iCn();
        }
        bool = ((SubscribeMsgRequestResult)localObject1).mnS;
        localObject1 = this.lGV;
        if (localObject1 == null) {
          p.iCn();
        }
        com.tencent.mm.msgsubscription.c.a.b(paramActivity, bool, (List)((SubscribeMsgRequestResult)localObject1).mnO);
      }
      AppMethodBeat.o(124723);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$createAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-biz_release"})
  public static final class b
    implements com.tencent.mm.msgsubscription.ui.a.a
  {
    public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
    {
      AppMethodBeat.i(206408);
      p.k(paramSubscribeMsgTmpItem, "item");
      Object localObject = this.lHa;
      p.k(paramSubscribeMsgTmpItem, "itemChanged");
      localObject = ((a)localObject).lGV;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((SubscribeMsgRequestResult)localObject).mnO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
        if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.lnb, (CharSequence)localSubscribeMsgTmpItem.lnb))
        {
          if (paramBoolean) {}
          for (int i = 1;; i = 0)
          {
            localSubscribeMsgTmpItem.mof = i;
            paramSubscribeMsgTmpItem.mof = localSubscribeMsgTmpItem.mof;
            AppMethodBeat.o(206408);
            return;
          }
        }
      }
      AppMethodBeat.o(206408);
    }
    
    public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
    {
      AppMethodBeat.i(206410);
      p.k(paramSubscribeMsgTmpItem, "item");
      boolean bool = a.a(paramSubscribeMsgTmpItem);
      AppMethodBeat.o(206410);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class c
    implements com.tencent.mm.msgsubscription.api.a
  {
    c(b.a parama) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124711);
      p.k(paramString, "bizUsername");
      p.k(paramSubscribeMsgRequestResult, "result");
      a.a(this.lHa, paramSubscribeMsgRequestResult);
      paramString = this.lHa;
      paramSubscribeMsgRequestResult = a.a(this.lHa);
      if (paramSubscribeMsgRequestResult == null) {
        p.iCn();
      }
      a.a(paramString, paramSubscribeMsgRequestResult.mnS);
      paramString = this.lHa;
      paramSubscribeMsgRequestResult = a.a(this.lHa);
      if (paramSubscribeMsgRequestResult == null) {
        p.iCn();
      }
      a.a(paramString, (List)paramSubscribeMsgRequestResult.mnO);
      paramString = parama;
      paramSubscribeMsgRequestResult = a.a(this.lHa);
      if (paramSubscribeMsgRequestResult == null) {
        p.iCn();
      }
      paramString.a(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult));
      a.b(this.lHa, a.a(this.lHa));
      a.b(this.lHa);
      AppMethodBeat.o(124711);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124712);
      p.k(paramString, "errMsg");
      parama.onError();
      AppMethodBeat.o(124712);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class d
    implements com.tencent.mm.msgsubscription.api.a
  {
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124713);
      p.k(paramString, "bizUsername");
      p.k(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
      a.b(this.lHa, (List)paramSubscribeMsgRequestResult.mnO);
      AppMethodBeat.o(124713);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124714);
      p.k(paramString, "errMsg");
      Log.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(124714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ao.b.a
 * JD-Core Version:    0.7.0.1
 */