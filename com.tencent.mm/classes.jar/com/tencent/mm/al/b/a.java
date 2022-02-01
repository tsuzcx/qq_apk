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
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "bizUsername", "", "mSubscribeMsgDataHelper", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSwitch", "canShow", "it", "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "updateOriginTmpMap", "Companion", "plugin-biz_release"})
public final class a
  extends com.tencent.mm.msgsubscription.presenter.a
{
  public static final a hAi;
  private Activity activity;
  private String dqK;
  private boolean fRW;
  private boolean hAd;
  private e hAe;
  private SubscribeMsgRequestResult hAf;
  private HashMap<String, SubscribeMsgTmpItem> hAg;
  private c hAh;
  
  static
  {
    AppMethodBeat.i(124726);
    hAi = new a((byte)0);
    AppMethodBeat.o(124726);
  }
  
  public a()
  {
    AppMethodBeat.i(124725);
    this.hAe = new e((d)b.hAn);
    this.hAg = new HashMap();
    this.fRW = true;
    this.dqK = "";
    this.hAh = new c(this);
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
        SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramHashMap.get(localSubscribeMsgTmpItem1.hiK);
        if (localSubscribeMsgTmpItem2 != null)
        {
          String str = localSubscribeMsgTmpItem2.hiK;
          if ((str != null) && (str.equals(localSubscribeMsgTmpItem1.hiK) == true))
          {
            if (localSubscribeMsgTmpItem2.igY == localSubscribeMsgTmpItem1.igY) {
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
  
  private final void am(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124717);
    this.hAg.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
        ((Map)this.hAg).put(localSubscribeMsgTmpItem.hiK, new SubscribeMsgTmpItem(localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.hiK, localSubscribeMsgTmpItem.igW, localSubscribeMsgTmpItem.igB, localSubscribeMsgTmpItem.igX, localSubscribeMsgTmpItem.igY, localSubscribeMsgTmpItem.Tz, localSubscribeMsgTmpItem.igV));
      }
      AppMethodBeat.o(124717);
      return;
    }
    AppMethodBeat.o(124717);
  }
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
  {
    AppMethodBeat.i(124719);
    k.h(paramSubscribeMsgTmpItem, "itemChanged");
    Object localObject = this.hAf;
    if (localObject == null) {
      k.fOy();
    }
    localObject = ((SubscribeMsgRequestResult)localObject).igI.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
      if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.hiK, (CharSequence)localSubscribeMsgTmpItem.hiK))
      {
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localSubscribeMsgTmpItem.igY = i;
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
    k.h(paramString, "bizUsername");
    k.h(parama, "l");
    Object localObject = this.activity;
    if (localObject == null) {
      k.aVY("activity");
    }
    this.hAf = ((SubscribeMsgRequestResult)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    this.dqK = paramString;
    if (this.hAf != null)
    {
      paramString = this.hAf;
      if (paramString == null) {
        k.fOy();
      }
      this.hAd = paramString.igL;
      paramString = this.hAf;
      if (paramString == null) {
        k.fOy();
      }
      am((List)paramString.igI);
      paramString = this.hAf;
      if (paramString == null) {
        k.fOy();
      }
      parama.a(new SubscribeMsgSettingData(paramString));
      AppMethodBeat.o(124716);
      return;
    }
    localObject = this.activity;
    if (localObject == null) {
      k.aVY("activity");
    }
    boolean bool = ((Activity)localObject).getIntent().getBooleanExtra("key_need_load_from_remote", false);
    ac.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
    if (bool)
    {
      localObject = this.hAe;
      parama = (e.b)new b(this, parama);
      k.h(paramString, "username");
      ac.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", new Object[] { paramString });
      g localg = g.iiz;
      g.a(((e)localObject).iiu, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.b(paramString, ((e)localObject).iiu, parama));
      AppMethodBeat.o(124716);
      return;
    }
    parama.onError();
    AppMethodBeat.o(124716);
  }
  
  public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(124720);
    k.h(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.igY == 1)
    {
      AppMethodBeat.o(124720);
      return true;
    }
    AppMethodBeat.o(124720);
    return false;
  }
  
  public final void eH(boolean paramBoolean)
  {
    this.hAd = paramBoolean;
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(124715);
    k.h(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    AppMethodBeat.o(124715);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(124722);
    k.h(paramActivity, "activity");
    boolean bool = this.hAd;
    paramActivity = this.hAf;
    label83:
    label114:
    int i;
    if (paramActivity != null)
    {
      paramActivity = Boolean.valueOf(paramActivity.igL);
      ac.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", new Object[] { Boolean.valueOf(bool), paramActivity, Boolean.valueOf(this.fRW) });
      paramActivity = this.hAf;
      if (paramActivity == null) {
        break label238;
      }
      paramActivity = paramActivity.igI;
      if ((paramActivity != null) && (this.fRW))
      {
        Object localObject = this.hAg;
        paramActivity = this.hAf;
        if (paramActivity == null) {
          break label243;
        }
        paramActivity = paramActivity.igI;
        paramActivity = a((HashMap)localObject, (List)paramActivity);
        if (((Collection)paramActivity).isEmpty()) {
          break label248;
        }
        i = 1;
        label138:
        if (i == 0)
        {
          localObject = this.hAf;
          if ((localObject != null) && (((SubscribeMsgRequestResult)localObject).igL == this.hAd)) {
            break label253;
          }
        }
        i = 1;
        label167:
        if (i == 0) {
          break label258;
        }
        localObject = this.hAe;
        c localc = this.ihD;
        if (localc == null) {
          k.aVY("view");
        }
        ((e)localObject).a(localc.getUserName(), this.hAd, paramActivity, true, (e.b)this.hAh);
      }
    }
    for (;;)
    {
      this.hAg.clear();
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
      ac.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(124721);
    k.h(paramActivity, "activity");
    super.onActivityResumed(paramActivity);
    this.fRW = paramActivity.getIntent().getBooleanExtra("key_need_update", true);
    AppMethodBeat.o(124721);
  }
  
  public final void y(Activity paramActivity)
  {
    AppMethodBeat.i(124723);
    k.h(paramActivity, "activity");
    super.y(paramActivity);
    Object localObject1;
    label94:
    boolean bool;
    if (!this.fRW)
    {
      ac.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
      Intent localIntent = new Intent();
      Object localObject2 = this.hAg;
      localObject1 = this.hAf;
      if (localObject1 != null)
      {
        localObject1 = ((SubscribeMsgRequestResult)localObject1).igI;
        localObject1 = a((HashMap)localObject2, (List)localObject1);
        if (((Collection)localObject1).isEmpty()) {
          break label266;
        }
        i = 1;
        if (i == 0)
        {
          localObject2 = this.hAf;
          if ((localObject2 != null) && (((SubscribeMsgRequestResult)localObject2).igL == this.hAd)) {
            break label271;
          }
        }
        bool = true;
        label123:
        if (bool) {
          localIntent.putExtra("key_biz_data", (Parcelable)new IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject1, this.hAd));
        }
        localIntent.putExtra("key_need_update", bool);
        paramActivity.setResult(-1, localIntent);
      }
    }
    else
    {
      if (((CharSequence)this.dqK).length() <= 0) {
        break label276;
      }
    }
    label266:
    label271:
    label276:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.hAf != null))
      {
        paramActivity = com.tencent.mm.msgsubscription.b.a.ihM;
        paramActivity = this.dqK;
        localObject1 = this.hAf;
        if (localObject1 == null) {
          k.fOy();
        }
        bool = ((SubscribeMsgRequestResult)localObject1).igL;
        localObject1 = this.hAf;
        if (localObject1 == null) {
          k.fOy();
        }
        com.tencent.mm.msgsubscription.b.a.b(paramActivity, bool, (List)((SubscribeMsgRequestResult)localObject1).igI);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class b
    implements e.b
  {
    b(b.a parama) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124711);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.hAj, paramSubscribeMsgRequestResult);
      paramString = this.hAj;
      paramSubscribeMsgRequestResult = a.a(this.hAj);
      if (paramSubscribeMsgRequestResult == null) {
        k.fOy();
      }
      a.a(paramString, paramSubscribeMsgRequestResult.igL);
      paramString = this.hAj;
      paramSubscribeMsgRequestResult = a.a(this.hAj);
      if (paramSubscribeMsgRequestResult == null) {
        k.fOy();
      }
      a.a(paramString, (List)paramSubscribeMsgRequestResult.igI);
      paramString = parama;
      paramSubscribeMsgRequestResult = a.a(this.hAj);
      if (paramSubscribeMsgRequestResult == null) {
        k.fOy();
      }
      paramString.a(new SubscribeMsgSettingData(paramSubscribeMsgRequestResult));
      AppMethodBeat.o(124711);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124712);
      k.h(paramString, "errMsg");
      parama.onError();
      AppMethodBeat.o(124712);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class c
    implements e.b
  {
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124713);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      ac.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
      a.b(this.hAj, (List)paramSubscribeMsgRequestResult.igI);
      AppMethodBeat.o(124713);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124714);
      k.h(paramString, "errMsg");
      ac.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(124714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.b.a
 * JD-Core Version:    0.7.0.1
 */