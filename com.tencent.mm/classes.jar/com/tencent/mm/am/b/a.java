package com.tencent.mm.am.b;

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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "bizUsername", "", "mSubscribeMsgDataHelper", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSwitch", "canShow", "it", "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "updateOriginTmpMap", "Companion", "plugin-biz_release"})
public final class a
  extends com.tencent.mm.msgsubscription.presenter.a
{
  public static final a.a gZJ;
  private Activity activity;
  private String dta;
  private boolean fOl;
  private boolean gZE;
  private e gZF;
  private SubscribeMsgRequestResult gZG;
  private HashMap<String, SubscribeMsgTmpItem> gZH;
  private c gZI;
  
  static
  {
    AppMethodBeat.i(124726);
    gZJ = new a.a((byte)0);
    AppMethodBeat.o(124726);
  }
  
  public a()
  {
    AppMethodBeat.i(124725);
    this.gZF = new e((d)b.gZO);
    this.gZH = new HashMap();
    this.fOl = true;
    this.dta = "";
    this.gZI = new c(this);
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
        SubscribeMsgTmpItem localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramHashMap.get(localSubscribeMsgTmpItem1.gIj);
        if (localSubscribeMsgTmpItem2 != null)
        {
          String str = localSubscribeMsgTmpItem2.gIj;
          if ((str != null) && (str.equals(localSubscribeMsgTmpItem1.gIj) == true))
          {
            if (localSubscribeMsgTmpItem2.hGw == localSubscribeMsgTmpItem1.hGw) {
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
  
  private final void ap(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(124717);
    this.gZH.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
        ((Map)this.gZH).put(localSubscribeMsgTmpItem.gIj, new SubscribeMsgTmpItem(localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.gIj, localSubscribeMsgTmpItem.hGu, localSubscribeMsgTmpItem.hFZ, localSubscribeMsgTmpItem.hGv, localSubscribeMsgTmpItem.hGw, localSubscribeMsgTmpItem.SE, localSubscribeMsgTmpItem.hGt));
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
    Object localObject = this.gZG;
    if (localObject == null) {
      k.fvU();
    }
    localObject = ((SubscribeMsgRequestResult)localObject).hGg.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
      if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.gIj, (CharSequence)localSubscribeMsgTmpItem.gIj))
      {
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localSubscribeMsgTmpItem.hGw = i;
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
      k.aPZ("activity");
    }
    this.gZG = ((SubscribeMsgRequestResult)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    this.dta = paramString;
    if (this.gZG != null)
    {
      paramString = this.gZG;
      if (paramString == null) {
        k.fvU();
      }
      this.gZE = paramString.hGj;
      paramString = this.gZG;
      if (paramString == null) {
        k.fvU();
      }
      ap((List)paramString.hGg);
      paramString = this.gZG;
      if (paramString == null) {
        k.fvU();
      }
      parama.a(new SubscribeMsgSettingData(paramString));
      AppMethodBeat.o(124716);
      return;
    }
    localObject = this.activity;
    if (localObject == null) {
      k.aPZ("activity");
    }
    boolean bool = ((Activity)localObject).getIntent().getBooleanExtra("key_need_load_from_remote", false);
    ad.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
    if (bool)
    {
      localObject = this.gZF;
      parama = (e.b)new b(this, parama);
      k.h(paramString, "username");
      ad.i("Mp.SubscribeMsgDataLoader", "alvinluo getSubscribeMsgListByUsername %s", new Object[] { paramString });
      g localg = g.hHX;
      g.a(((e)localObject).hHS, (com.tencent.mm.msgsubscription.c.a)new com.tencent.mm.msgsubscription.c.b(paramString, ((e)localObject).hHS, parama));
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
    if (paramSubscribeMsgTmpItem.hGw == 1)
    {
      AppMethodBeat.o(124720);
      return true;
    }
    AppMethodBeat.o(124720);
    return false;
  }
  
  public final void em(boolean paramBoolean)
  {
    this.gZE = paramBoolean;
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
    boolean bool = this.gZE;
    paramActivity = this.gZG;
    label83:
    label114:
    int i;
    if (paramActivity != null)
    {
      paramActivity = Boolean.valueOf(paramActivity.hGj);
      ad.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", new Object[] { Boolean.valueOf(bool), paramActivity, Boolean.valueOf(this.fOl) });
      paramActivity = this.gZG;
      if (paramActivity == null) {
        break label238;
      }
      paramActivity = paramActivity.hGg;
      if ((paramActivity != null) && (this.fOl))
      {
        Object localObject = this.gZH;
        paramActivity = this.gZG;
        if (paramActivity == null) {
          break label243;
        }
        paramActivity = paramActivity.hGg;
        paramActivity = a((HashMap)localObject, (List)paramActivity);
        if (((Collection)paramActivity).isEmpty()) {
          break label248;
        }
        i = 1;
        label138:
        if (i == 0)
        {
          localObject = this.gZG;
          if ((localObject != null) && (((SubscribeMsgRequestResult)localObject).hGj == this.gZE)) {
            break label253;
          }
        }
        i = 1;
        label167:
        if (i == 0) {
          break label258;
        }
        localObject = this.gZF;
        c localc = this.hHb;
        if (localc == null) {
          k.aPZ("view");
        }
        ((e)localObject).a(localc.getUserName(), this.gZE, paramActivity, true, (e.b)this.gZI);
      }
    }
    for (;;)
    {
      this.gZH.clear();
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
      ad.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(124721);
    k.h(paramActivity, "activity");
    super.onActivityResumed(paramActivity);
    this.fOl = paramActivity.getIntent().getBooleanExtra("key_need_update", true);
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
    if (!this.fOl)
    {
      ad.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
      Intent localIntent = new Intent();
      Object localObject2 = this.gZH;
      localObject1 = this.gZG;
      if (localObject1 != null)
      {
        localObject1 = ((SubscribeMsgRequestResult)localObject1).hGg;
        localObject1 = a((HashMap)localObject2, (List)localObject1);
        if (((Collection)localObject1).isEmpty()) {
          break label266;
        }
        i = 1;
        if (i == 0)
        {
          localObject2 = this.gZG;
          if ((localObject2 != null) && (((SubscribeMsgRequestResult)localObject2).hGj == this.gZE)) {
            break label271;
          }
        }
        bool = true;
        label123:
        if (bool) {
          localIntent.putExtra("key_biz_data", (Parcelable)new IBrandSubscribeMsgService.Companion.SubscribeMsgListWrapper((List)localObject1, this.gZE));
        }
        localIntent.putExtra("key_need_update", bool);
        paramActivity.setResult(-1, localIntent);
      }
    }
    else
    {
      if (((CharSequence)this.dta).length() <= 0) {
        break label276;
      }
    }
    label266:
    label271:
    label276:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.gZG != null))
      {
        paramActivity = com.tencent.mm.msgsubscription.b.a.hHk;
        paramActivity = this.dta;
        localObject1 = this.gZG;
        if (localObject1 == null) {
          k.fvU();
        }
        bool = ((SubscribeMsgRequestResult)localObject1).hGj;
        localObject1 = this.gZG;
        if (localObject1 == null) {
          k.fvU();
        }
        com.tencent.mm.msgsubscription.b.a.b(paramActivity, bool, (List)((SubscribeMsgRequestResult)localObject1).hGg);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class b
    implements e.b
  {
    b(b.a parama) {}
    
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124711);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      a.a(this.gZK, paramSubscribeMsgRequestResult);
      paramString = this.gZK;
      paramSubscribeMsgRequestResult = a.a(this.gZK);
      if (paramSubscribeMsgRequestResult == null) {
        k.fvU();
      }
      a.a(paramString, paramSubscribeMsgRequestResult.hGj);
      paramString = this.gZK;
      paramSubscribeMsgRequestResult = a.a(this.gZK);
      if (paramSubscribeMsgRequestResult == null) {
        k.fvU();
      }
      a.a(paramString, (List)paramSubscribeMsgRequestResult.hGg);
      paramString = parama;
      paramSubscribeMsgRequestResult = a.a(this.gZK);
      if (paramSubscribeMsgRequestResult == null) {
        k.fvU();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader$SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
  public static final class c
    implements e.b
  {
    public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(124713);
      k.h(paramString, "bizUsername");
      k.h(paramSubscribeMsgRequestResult, "result");
      ad.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
      a.b(this.gZK, (List)paramSubscribeMsgRequestResult.hGg);
      AppMethodBeat.o(124713);
    }
    
    public final void i(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(124714);
      k.h(paramString, "errMsg");
      ad.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(124714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.b.a
 * JD-Core Version:    0.7.0.1
 */