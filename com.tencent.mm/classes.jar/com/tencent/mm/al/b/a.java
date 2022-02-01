package com.tencent.mm.al.b;

import android.app.Activity;
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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "bizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "bizUsername", "", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSettingReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "subscribeSwitch", "canShow", "it", "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "initReportInfo", "result", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "reportSubscribeSettingOp", "opType", "", "updateOriginTmpMap", "Companion", "plugin-biz_release"})
public final class a
  extends com.tencent.mm.msgsubscription.presenter.a
{
  public static final a.a iQJ;
  private Activity activity;
  private String dVu;
  private boolean iQD;
  private com.tencent.mm.msgsubscription.b.a iQE;
  private SubscribeMsgRequestResult iQF;
  private HashMap<String, SubscribeMsgTmpItem> iQG;
  private com.tencent.mm.msgsubscription.c.a.c iQH;
  private c iQI;
  private boolean needUpdate;
  
  static
  {
    AppMethodBeat.i(124726);
    iQJ = new a.a((byte)0);
    AppMethodBeat.o(124726);
  }
  
  public a()
  {
    AppMethodBeat.i(124725);
    b localb = b.jza;
    this.iQE = b.Ru("name_biz");
    this.iQG = new HashMap();
    this.needUpdate = true;
    this.dVu = "";
    this.iQH = new com.tencent.mm.msgsubscription.c.a.c();
    this.iQI = new c(this);
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
        SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramHashMap.get(localSubscribeMsgTmpItem1.ixM);
        if (localSubscribeMsgTmpItem2 != null)
        {
          String str = localSubscribeMsgTmpItem2.ixM;
          if ((str != null) && (str.equals(localSubscribeMsgTmpItem1.ixM) == true))
          {
            if (localSubscribeMsgTmpItem2.jyB == localSubscribeMsgTmpItem1.jyB) {
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
    AppMethodBeat.i(212434);
    if (paramSubscribeMsgRequestResult == null)
    {
      AppMethodBeat.o(212434);
      return;
    }
    this.iQH.Rx(this.dVu);
    this.iQH.jAw = paramSubscribeMsgRequestResult.jyo;
    this.iQH.jAx = paramSubscribeMsgRequestResult.jyk.size();
    paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.jyk).iterator();
    while (paramSubscribeMsgRequestResult.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
      this.iQH.jzS.add(localSubscribeMsgTmpItem.ixM);
      this.iQH.jAy.add(Integer.valueOf(localSubscribeMsgTmpItem.jyz));
      this.iQH.jAz.add(localSubscribeMsgTmpItem.title);
      this.iQH.jAs.add(Integer.valueOf(localSubscribeMsgTmpItem.jyB));
    }
    AppMethodBeat.o(212434);
  }
  
  private final void aw(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124717);
    this.iQG.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
        ((Map)this.iQG).put(localSubscribeMsgTmpItem.ixM, new SubscribeMsgTmpItem(localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.ixM, localSubscribeMsgTmpItem.jyz, localSubscribeMsgTmpItem.jyd, localSubscribeMsgTmpItem.jyA, localSubscribeMsgTmpItem.jyB, localSubscribeMsgTmpItem.VC, localSubscribeMsgTmpItem.jyy));
      }
      AppMethodBeat.o(124717);
      return;
    }
    AppMethodBeat.o(124717);
  }
  
  private final void sR(int paramInt)
  {
    AppMethodBeat.i(212435);
    com.tencent.mm.msgsubscription.c.a.a(paramInt, this.iQH);
    AppMethodBeat.o(212435);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
  {
    AppMethodBeat.i(124719);
    p.h(paramSubscribeMsgTmpItem, "itemChanged");
    Object localObject = this.iQF;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((SubscribeMsgRequestResult)localObject).jyk.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
      if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.ixM, (CharSequence)localSubscribeMsgTmpItem.ixM))
      {
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localSubscribeMsgTmpItem.jyB = i;
          paramSubscribeMsgTmpItem.jyB = localSubscribeMsgTmpItem.jyB;
          AppMethodBeat.o(124719);
          return;
        }
      }
    }
    AppMethodBeat.o(124719);
  }
  
  public final void a(String paramString, final b.a parama)
  {
    AppMethodBeat.i(124716);
    p.h(paramString, "bizUsername");
    p.h(parama, "l");
    Object localObject = this.activity;
    if (localObject == null) {
      p.btv("activity");
    }
    this.iQF = ((SubscribeMsgRequestResult)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    this.dVu = paramString;
    if (this.iQF != null)
    {
      paramString = this.iQF;
      if (paramString == null) {
        p.hyc();
      }
      this.iQD = paramString.jyo;
      paramString = this.iQF;
      if (paramString == null) {
        p.hyc();
      }
      aw((List)paramString.jyk);
      paramString = this.iQF;
      if (paramString == null) {
        p.hyc();
      }
      parama.a(new SubscribeMsgSettingData(paramString));
      a(this.iQF);
      sR(1);
      AppMethodBeat.o(124716);
      return;
    }
    localObject = this.activity;
    if (localObject == null) {
      p.btv("activity");
    }
    boolean bool = ((Activity)localObject).getIntent().getBooleanExtra("key_need_load_from_remote", false);
    Log.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
    if (bool)
    {
      localObject = this.iQE;
      if (localObject != null)
      {
        ((com.tencent.mm.msgsubscription.b.a)localObject).a(paramString, (com.tencent.mm.msgsubscription.api.a)new b(this, parama));
        AppMethodBeat.o(124716);
        return;
      }
      AppMethodBeat.o(124716);
      return;
    }
    parama.onError();
    AppMethodBeat.o(124716);
  }
  
  public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(124720);
    p.h(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.jyB == 1)
    {
      AppMethodBeat.o(124720);
      return true;
    }
    AppMethodBeat.o(124720);
    return false;
  }
  
  public final void fC(boolean paramBoolean)
  {
    this.iQD = paramBoolean;
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    int i = 0;
    AppMethodBeat.i(124715);
    p.h(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    this.iQH.sessionId = System.currentTimeMillis();
    com.tencent.mm.msgsubscription.c.a.c localc = this.iQH;
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
    p.h(paramActivity, "activity");
    boolean bool = this.iQD;
    paramActivity = this.iQF;
    label83:
    label114:
    int i;
    if (paramActivity != null)
    {
      paramActivity = Boolean.valueOf(paramActivity.jyo);
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", new Object[] { Boolean.valueOf(bool), paramActivity, Boolean.valueOf(this.needUpdate) });
      paramActivity = this.iQF;
      if (paramActivity == null) {
        break label291;
      }
      paramActivity = paramActivity.jyk;
      if ((paramActivity != null) && (this.needUpdate))
      {
        Object localObject = this.iQG;
        paramActivity = this.iQF;
        if (paramActivity == null) {
          break label296;
        }
        paramActivity = paramActivity.jyk;
        paramActivity = a((HashMap)localObject, (List)paramActivity);
        if (((Collection)paramActivity).isEmpty()) {
          break label301;
        }
        i = 1;
        label138:
        if (i == 0)
        {
          localObject = this.iQF;
          if ((localObject != null) && (((SubscribeMsgRequestResult)localObject).jyo == this.iQD)) {
            break label306;
          }
        }
        i = 1;
        label167:
        if (i == 0) {
          break label311;
        }
        localObject = new com.tencent.mm.msgsubscription.api.c();
        com.tencent.mm.msgsubscription.presenter.c localc = this.jAh;
        if (localc == null) {
          p.btv("view");
        }
        ((com.tencent.mm.msgsubscription.api.c)localObject).setUsername(localc.getUserName());
        ((com.tencent.mm.msgsubscription.api.c)localObject).jyV.addAll((Collection)paramActivity);
        ((com.tencent.mm.msgsubscription.api.c)localObject).jzb = this.iQD;
        ((com.tencent.mm.msgsubscription.api.c)localObject).jze = ((com.tencent.mm.msgsubscription.api.a)this.iQI);
        ((com.tencent.mm.msgsubscription.api.c)localObject).jzf = true;
        ((com.tencent.mm.msgsubscription.api.c)localObject).jzg = true;
        paramActivity = this.iQE;
        if (paramActivity != null) {
          paramActivity.a((com.tencent.mm.msgsubscription.api.c)localObject);
        }
      }
    }
    for (;;)
    {
      this.iQG.clear();
      AppMethodBeat.o(124722);
      return;
      paramActivity = null;
      break;
      label291:
      paramActivity = null;
      break label83;
      label296:
      paramActivity = null;
      break label114;
      label301:
      i = 0;
      break label138;
      label306:
      i = 0;
      break label167;
      label311:
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(124721);
    p.h(paramActivity, "activity");
    super.onActivityResumed(paramActivity);
    this.needUpdate = paramActivity.getIntent().getBooleanExtra("key_need_update", true);
    AppMethodBeat.o(124721);
  }
  
  public final void y(Activity paramActivity)
  {
    AppMethodBeat.i(124723);
    p.h(paramActivity, "activity");
    super.y(paramActivity);
    Intent localIntent;
    Object localObject1;
    if (!this.needUpdate)
    {
      Log.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
      localIntent = new Intent();
      Object localObject2 = this.iQG;
      localObject1 = this.iQF;
      if (localObject1 == null) {
        break label250;
      }
      localObject1 = ((SubscribeMsgRequestResult)localObject1).jyk;
      localObject1 = a((HashMap)localObject2, (List)localObject1);
      if (((Collection)localObject1).isEmpty()) {
        break label256;
      }
      i = 1;
      label94:
      if (i == 0)
      {
        localObject2 = this.iQF;
        if ((localObject2 != null) && (((SubscribeMsgRequestResult)localObject2).jyo == this.iQD)) {
          break label261;
        }
      }
    }
    label256:
    label261:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        localIntent.putExtra("key_biz_data", (Parcelable)new ISubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject1, this.iQD));
      }
      localIntent.putExtra("key_need_update", bool);
      paramActivity.setResult(-1, localIntent);
      this.iQH.jAw = this.iQD;
      paramActivity = this.iQF;
      if (paramActivity == null) {
        break label266;
      }
      paramActivity = paramActivity.jyk;
      if (paramActivity == null) {
        break label266;
      }
      paramActivity = ((Iterable)paramActivity).iterator();
      while (paramActivity.hasNext())
      {
        localObject1 = (SubscribeMsgTmpItem)paramActivity.next();
        this.iQH.jAA.add(Integer.valueOf(((SubscribeMsgTmpItem)localObject1).jyB));
      }
      label250:
      localObject1 = null;
      break;
      i = 0;
      break label94;
    }
    label266:
    sR(2);
    if (((CharSequence)this.dVu).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.iQF != null))
      {
        paramActivity = com.tencent.mm.msgsubscription.c.a.jAr;
        paramActivity = this.dVu;
        localObject1 = this.iQF;
        if (localObject1 == null) {
          p.hyc();
        }
        bool = ((SubscribeMsgRequestResult)localObject1).jyo;
        localObject1 = this.iQF;
        if (localObject1 == null) {
          p.hyc();
        }
        com.tencent.mm.msgsubscription.c.a.b(paramActivity, bool, (List)((SubscribeMsgRequestResult)localObject1).jyk);
      }
      AppMethodBeat.o(124723);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class b
    implements com.tencent.mm.msgsubscription.api.a
  {
    b(b.a parama) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124711);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.iQK, paramSubscribeMsgRequestResult);
      paramString = this.iQK;
      paramSubscribeMsgRequestResult = a.a(this.iQK);
      if (paramSubscribeMsgRequestResult == null) {
        p.hyc();
      }
      a.a(paramString, paramSubscribeMsgRequestResult.jyo);
      paramString = this.iQK;
      paramSubscribeMsgRequestResult = a.a(this.iQK);
      if (paramSubscribeMsgRequestResult == null) {
        p.hyc();
      }
      a.a(paramString, (List)paramSubscribeMsgRequestResult.jyk);
      paramString = parama;
      paramSubscribeMsgRequestResult = a.a(this.iQK);
      if (paramSubscribeMsgRequestResult == null) {
        p.hyc();
      }
      paramString.a(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult));
      a.b(this.iQK, a.a(this.iQK));
      a.b(this.iQK);
      AppMethodBeat.o(124711);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124712);
      p.h(paramString, "errMsg");
      parama.onError();
      AppMethodBeat.o(124712);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class c
    implements com.tencent.mm.msgsubscription.api.a
  {
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124713);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
      a.b(this.iQK, (List)paramSubscribeMsgRequestResult.jyk);
      AppMethodBeat.o(124713);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124714);
      p.h(paramString, "errMsg");
      Log.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(124714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.b.a
 * JD-Core Version:    0.7.0.1
 */