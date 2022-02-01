package com.tencent.mm.al.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b.a;
import com.tencent.mm.msgsubscription.presenter.c;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper;
import com.tencent.mm.msgsubscription.storage.d;
import com.tencent.mm.msgsubscription.storage.e;
import com.tencent.mm.msgsubscription.storage.e.b;
import com.tencent.mm.msgsubscription.storage.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "bizUsername", "", "mSubscribeMsgDataHelper", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSwitch", "canShow", "it", "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "updateOriginTmpMap", "Companion", "plugin-biz_release"})
public final class a
  extends com.tencent.mm.msgsubscription.presenter.a
{
  public static final a hVv;
  private Activity activity;
  private String dDG;
  private boolean gnV;
  private boolean hVq;
  private e hVr;
  private SubscribeMsgRequestResult hVs;
  private HashMap<String, SubscribeMsgTmpItem> hVt;
  private c hVu;
  
  static
  {
    AppMethodBeat.i(124726);
    hVv = new a((byte)0);
    AppMethodBeat.o(124726);
  }
  
  public a()
  {
    AppMethodBeat.i(124725);
    this.hVr = new e((d)b.hVA);
    this.hVt = new HashMap();
    this.gnV = true;
    this.dDG = "";
    this.hVu = new c(this);
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
        SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramHashMap.get(localSubscribeMsgTmpItem1.hDH);
        if (localSubscribeMsgTmpItem2 != null)
        {
          String str = localSubscribeMsgTmpItem2.hDH;
          if ((str != null) && (str.equals(localSubscribeMsgTmpItem1.hDH) == true))
          {
            if (localSubscribeMsgTmpItem2.iDl == localSubscribeMsgTmpItem1.iDl) {
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
  
  private final void an(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124717);
    this.hVt.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
        ((Map)this.hVt).put(localSubscribeMsgTmpItem.hDH, new SubscribeMsgTmpItem(localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.hDH, localSubscribeMsgTmpItem.iDj, localSubscribeMsgTmpItem.iCO, localSubscribeMsgTmpItem.iDk, localSubscribeMsgTmpItem.iDl, localSubscribeMsgTmpItem.Vp, localSubscribeMsgTmpItem.iDi));
      }
      AppMethodBeat.o(124717);
      return;
    }
    AppMethodBeat.o(124717);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
  {
    AppMethodBeat.i(124719);
    p.h(paramSubscribeMsgTmpItem, "itemChanged");
    Object localObject = this.hVs;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((SubscribeMsgRequestResult)localObject).iCV.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
      if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.hDH, (CharSequence)localSubscribeMsgTmpItem.hDH))
      {
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localSubscribeMsgTmpItem.iDl = i;
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
      p.bdF("activity");
    }
    this.hVs = ((SubscribeMsgRequestResult)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    this.dDG = paramString;
    if (this.hVs != null)
    {
      paramString = this.hVs;
      if (paramString == null) {
        p.gkB();
      }
      this.hVq = paramString.iCY;
      paramString = this.hVs;
      if (paramString == null) {
        p.gkB();
      }
      an((List)paramString.iCV);
      paramString = this.hVs;
      if (paramString == null) {
        p.gkB();
      }
      parama.a(new SubscribeMsgSettingData(paramString));
      AppMethodBeat.o(124716);
      return;
    }
    localObject = this.activity;
    if (localObject == null) {
      p.bdF("activity");
    }
    boolean bool = ((Activity)localObject).getIntent().getBooleanExtra("key_need_load_from_remote", false);
    ae.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
    if (bool)
    {
      localObject = this.hVr;
      parama = (e.b)new b(this, parama);
      p.h(paramString, "username");
      ae.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", new Object[] { paramString });
      g localg = g.iEM;
      g.a(((e)localObject).iEH, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.b(paramString, ((e)localObject).iEH, parama));
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
    if (paramSubscribeMsgTmpItem.iDl == 1)
    {
      AppMethodBeat.o(124720);
      return true;
    }
    AppMethodBeat.o(124720);
    return false;
  }
  
  public final void eL(boolean paramBoolean)
  {
    this.hVq = paramBoolean;
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(124715);
    p.h(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    AppMethodBeat.o(124715);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(124722);
    p.h(paramActivity, "activity");
    boolean bool = this.hVq;
    paramActivity = this.hVs;
    label83:
    label114:
    int i;
    if (paramActivity != null)
    {
      paramActivity = Boolean.valueOf(paramActivity.iCY);
      ae.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", new Object[] { Boolean.valueOf(bool), paramActivity, Boolean.valueOf(this.gnV) });
      paramActivity = this.hVs;
      if (paramActivity == null) {
        break label238;
      }
      paramActivity = paramActivity.iCV;
      if ((paramActivity != null) && (this.gnV))
      {
        Object localObject = this.hVt;
        paramActivity = this.hVs;
        if (paramActivity == null) {
          break label243;
        }
        paramActivity = paramActivity.iCV;
        paramActivity = a((HashMap)localObject, (List)paramActivity);
        if (((Collection)paramActivity).isEmpty()) {
          break label248;
        }
        i = 1;
        label138:
        if (i == 0)
        {
          localObject = this.hVs;
          if ((localObject != null) && (((SubscribeMsgRequestResult)localObject).iCY == this.hVq)) {
            break label253;
          }
        }
        i = 1;
        label167:
        if (i == 0) {
          break label258;
        }
        localObject = this.hVr;
        c localc = this.iDQ;
        if (localc == null) {
          p.bdF("view");
        }
        ((e)localObject).a(localc.getUserName(), this.hVq, paramActivity, true, (e.b)this.hVu);
      }
    }
    for (;;)
    {
      this.hVt.clear();
      AppMethodBeat.o(124722);
      return;
      paramActivity = null;
      break;
      label238:
      paramActivity = null;
      break label83;
      label243:
      paramActivity = null;
      break label114;
      label248:
      i = 0;
      break label138;
      label253:
      i = 0;
      break label167;
      label258:
      ae.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(124721);
    p.h(paramActivity, "activity");
    super.onActivityResumed(paramActivity);
    this.gnV = paramActivity.getIntent().getBooleanExtra("key_need_update", true);
    AppMethodBeat.o(124721);
  }
  
  public final void y(Activity paramActivity)
  {
    AppMethodBeat.i(124723);
    p.h(paramActivity, "activity");
    super.y(paramActivity);
    Object localObject1;
    label94:
    boolean bool;
    if (!this.gnV)
    {
      ae.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
      Intent localIntent = new Intent();
      Object localObject2 = this.hVt;
      localObject1 = this.hVs;
      if (localObject1 != null)
      {
        localObject1 = ((SubscribeMsgRequestResult)localObject1).iCV;
        localObject1 = a((HashMap)localObject2, (List)localObject1);
        if (((Collection)localObject1).isEmpty()) {
          break label266;
        }
        i = 1;
        if (i == 0)
        {
          localObject2 = this.hVs;
          if ((localObject2 != null) && (((SubscribeMsgRequestResult)localObject2).iCY == this.hVq)) {
            break label271;
          }
        }
        bool = true;
        label123:
        if (bool) {
          localIntent.putExtra("key_biz_data", (Parcelable)new IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject1, this.hVq));
        }
        localIntent.putExtra("key_need_update", bool);
        paramActivity.setResult(-1, localIntent);
      }
    }
    else
    {
      if (((CharSequence)this.dDG).length() <= 0) {
        break label276;
      }
    }
    label266:
    label271:
    label276:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.hVs != null))
      {
        paramActivity = com.tencent.mm.msgsubscription.b.a.iDZ;
        paramActivity = this.dDG;
        localObject1 = this.hVs;
        if (localObject1 == null) {
          p.gkB();
        }
        bool = ((SubscribeMsgRequestResult)localObject1).iCY;
        localObject1 = this.hVs;
        if (localObject1 == null) {
          p.gkB();
        }
        com.tencent.mm.msgsubscription.b.a.b(paramActivity, bool, (List)((SubscribeMsgRequestResult)localObject1).iCV);
      }
      AppMethodBeat.o(124723);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label94;
      bool = false;
      break label123;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class b
    implements e.b
  {
    b(b.a parama) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124711);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.hVw, paramSubscribeMsgRequestResult);
      paramString = this.hVw;
      paramSubscribeMsgRequestResult = a.a(this.hVw);
      if (paramSubscribeMsgRequestResult == null) {
        p.gkB();
      }
      a.a(paramString, paramSubscribeMsgRequestResult.iCY);
      paramString = this.hVw;
      paramSubscribeMsgRequestResult = a.a(this.hVw);
      if (paramSubscribeMsgRequestResult == null) {
        p.gkB();
      }
      a.a(paramString, (List)paramSubscribeMsgRequestResult.iCV);
      paramString = parama;
      paramSubscribeMsgRequestResult = a.a(this.hVw);
      if (paramSubscribeMsgRequestResult == null) {
        p.gkB();
      }
      paramString.a(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult));
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class c
    implements e.b
  {
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124713);
      p.h(paramString, "bizUsername");
      p.h(paramSubscribeMsgRequestResult, "result");
      ae.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
      a.b(this.hVw, (List)paramSubscribeMsgRequestResult.iCV);
      AppMethodBeat.o(124713);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124714);
      p.h(paramString, "errMsg");
      ae.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(124714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.b.a
 * JD-Core Version:    0.7.0.1
 */