package com.tencent.mm.msgsubscription.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.a;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.c;
import com.tencent.mm.msgsubscription.e.e;
import com.tencent.mm.msgsubscription.e.i;
import com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "mSubscribeStatusManager", "Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "callbackWrapper", "", "templateId", "", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", "username", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getStorage", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdatedWrapper", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements ISubscribeMsgService
{
  public static final a.a piP;
  private static final HashMap<String, HashMap<String, ISubscribeMsgService.b>> piT;
  public final com.tencent.mm.msgsubscription.d.a piQ;
  private final com.tencent.mm.msgsubscription.d.b piR;
  private final c piS;
  
  static
  {
    AppMethodBeat.i(236408);
    piP = new a.a((byte)0);
    piT = new HashMap();
    AppMethodBeat.o(236408);
  }
  
  public a(com.tencent.mm.msgsubscription.d.a parama)
  {
    AppMethodBeat.i(236357);
    this.piQ = parama;
    this.piR = new com.tencent.mm.msgsubscription.d.b(parama);
    this.piS = new c((ISubscribeMsgService)this);
    AppMethodBeat.o(236357);
  }
  
  private static void b(String paramString, kotlin.g.a.b<? super ISubscribeMsgService.b, ah> paramb)
  {
    Integer localInteger = null;
    AppMethodBeat.i(236374);
    HashMap localHashMap = (HashMap)piT.get(paramString);
    Set localSet;
    if (localHashMap == null)
    {
      localSet = null;
      if (localSet != null) {
        break label105;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo callbackWrapper templateId: %s, callback size: %s", new Object[] { paramString, localInteger });
      if (localSet == null) {
        break label118;
      }
      paramString = ((Iterable)localSet).iterator();
      while (paramString.hasNext()) {
        paramb.invoke(localHashMap.get((String)paramString.next()));
      }
      localSet = localHashMap.keySet();
      break;
      label105:
      localInteger = Integer.valueOf(localSet.size());
    }
    label118:
    AppMethodBeat.o(236374);
  }
  
  public final boolean QV(String paramString)
  {
    AppMethodBeat.i(236468);
    s.u(paramString, "bizUsername");
    Object localObject = this.piR;
    s.u(paramString, "bizUsername");
    localObject = ((com.tencent.mm.msgsubscription.d.b)localObject).pjW;
    if (localObject == null)
    {
      AppMethodBeat.o(236468);
      return false;
    }
    boolean bool = ((com.tencent.mm.msgsubscription.d.a)localObject).Rd(paramString);
    AppMethodBeat.o(236468);
    return bool;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(236573);
    s.u(paramContext, "context");
    s.u(paramString, "bizAppId");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo requestSubscribeMsgForResult scene: %d, bizAppId: %s, requestCode: %s", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    Intent localIntent = new Intent(paramContext, SubscribeMsgRequestProxyUI.class);
    localIntent.putExtra("key_need_result", true);
    localIntent.putExtra("key_biz_app_id", paramString);
    localIntent.putExtra("key_scene", paramInt1);
    localIntent.putExtra("key_action", 3);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, com.tencent.mm.hellhoundlib.b.c.a(paramInt2, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "requestSubscribeMsgForResult", "(Landroid/content/Context;IILjava/lang/String;Landroid/os/Bundle;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(236573);
      return;
    }
    Log.e("MicroMsg.BaseSubscribeMsgService", "alvinluo requestSubscribeMsgForResult context is not activity");
    AppMethodBeat.o(236573);
  }
  
  public void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(236547);
    s.u(paramContext, "context");
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "nickname");
    AppMethodBeat.o(236547);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(236565);
    s.u(paramContext, "context");
    s.u(paramBundle, "extra");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clickSubscribeMsgSpan bizUsername: %s, url: %s", new Object[] { paramString1, paramString2 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(236565);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(236565);
      return;
    }
    Intent localIntent = new Intent(paramContext, SubscribeMsgRequestProxyUI.class);
    localIntent.putExtra("key_biz_username", paramString1);
    localIntent.putExtra("key_scene", 1);
    localIntent.putExtra("key_subscribe_url", paramString2);
    localIntent.putExtra("key_action", 3);
    paramString1 = new JSONObject();
    paramString1.put("scene", 4);
    localIntent.putExtra("key_extra_info", paramString1.toString());
    localIntent.putExtras(paramBundle);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(236565);
  }
  
  public final void a(com.tencent.mm.msgsubscription.api.c paramc)
  {
    AppMethodBeat.i(236541);
    s.u(paramc, "updateRequest");
    this.piR.a(paramc);
    AppMethodBeat.o(236541);
  }
  
  public void a(String paramString, final SubscribeMsgTmpItem paramSubscribeMsgTmpItem, final ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(236444);
    s.u(paramString, "bizUsername");
    s.u(paramSubscribeMsgTmpItem, "tmpItem");
    c localc = this.piS;
    paramb = (ISubscribeMsgService.b)new f(this, paramSubscribeMsgTmpItem, paramb);
    s.u(paramString, "bizUsername");
    s.u(paramSubscribeMsgTmpItem, "tmpItem");
    s.u(paramb, "callback");
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus templateId: %s, settingStatus: %d, switchOpened: %b", new Object[] { paramSubscribeMsgTmpItem.nSg, Integer.valueOf(paramSubscribeMsgTmpItem.phT), Boolean.valueOf(paramSubscribeMsgTmpItem.hU) });
    ArrayList localArrayList = p.al(new SubscribeMsgTmpItem[] { paramSubscribeMsgTmpItem });
    Object localObject = localc.pjd;
    if (localObject != null) {
      ISubscribeMsgService.a.a((ISubscribeMsgService)localObject, paramString, (List)localArrayList);
    }
    localObject = new com.tencent.mm.msgsubscription.api.c();
    ((com.tencent.mm.msgsubscription.api.c)localObject).setUsername(paramString);
    ((com.tencent.mm.msgsubscription.api.c)localObject).pis.addAll((Collection)localArrayList);
    ((com.tencent.mm.msgsubscription.api.c)localObject).piy = paramSubscribeMsgTmpItem.hU;
    ((com.tencent.mm.msgsubscription.api.c)localObject).piB = ((com.tencent.mm.msgsubscription.api.a)new c.d(paramSubscribeMsgTmpItem, paramb, localc, paramString));
    paramString = localc.pjd;
    if (paramString != null) {
      paramString.a((com.tencent.mm.msgsubscription.api.c)localObject);
    }
    AppMethodBeat.o(236444);
  }
  
  public final void a(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(236512);
    s.u(paramString, "username");
    this.piR.a(paramString, parama);
    AppMethodBeat.o(236512);
  }
  
  public final void a(String paramString1, String paramString2, List<String> paramList, String paramString3, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(236524);
    s.u(paramString1, "username");
    s.u(paramString2, "subscribeUrl");
    s.u(paramList, "templateIdList");
    s.u(paramString3, "extInfo");
    com.tencent.mm.msgsubscription.d.b localb = this.piR;
    s.u(paramString1, "username");
    s.u(paramString2, "subscribeUrl");
    s.u(paramList, "templateIdList");
    s.u(paramString3, "extInfo");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByUsername username: %s, url: %s, templateIdList size: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramList.size()) });
    if (localb.pjW != null)
    {
      com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.pkg;
      com.tencent.mm.msgsubscription.d.d.a(localb.pjW, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.d(paramString1, "", paramString2, paramList, paramString3, localb.pjW, parama));
    }
    AppMethodBeat.o(236524);
  }
  
  public final void a(String paramString, List<String> paramList, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(236509);
    s.u(paramString, "username");
    s.u(paramList, "templateIdList");
    com.tencent.mm.msgsubscription.d.b localb = this.piR;
    s.u(paramString, "username");
    s.u(paramList, "templateIdList");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeStatus username: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    if (localb.pjW != null)
    {
      com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.pkg;
      com.tencent.mm.msgsubscription.d.d.a(localb.pjW, (com.tencent.mm.msgsubscription.e.a)new e(paramString, paramList, localb.pjW, parama));
    }
    AppMethodBeat.o(236509);
  }
  
  public void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(236488);
    s.u(paramString, "bizUsername");
    s.u(paramList, "subscribeMsgList");
    this.piR.a(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(236488);
  }
  
  public void ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(236500);
    s.u(paramString, "bizUsername");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.msgsubscription.d.b localb = this.piR;
    s.u(paramString, "username");
    localb.a(paramString, (List)new ArrayList(), paramBoolean, true, false);
    AppMethodBeat.o(236500);
  }
  
  public final void b(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(236480);
    s.u(paramString, "username");
    com.tencent.mm.msgsubscription.d.b localb = this.piR;
    s.u(paramString, "username");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getLocalSubscribeList username: %s", new Object[] { paramString });
    if (localb.pjW != null)
    {
      com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.pkg;
      com.tencent.mm.msgsubscription.d.d.a(localb.pjW, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.c(paramString, localb.pjW, parama));
    }
    AppMethodBeat.o(236480);
  }
  
  public final void b(String paramString1, String paramString2, List<String> paramList, String paramString3, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(236533);
    s.u(paramString1, "appId");
    s.u(paramString2, "subscribeUrl");
    s.u(paramList, "templateIdList");
    s.u(paramString3, "extInfo");
    com.tencent.mm.msgsubscription.d.b localb = this.piR;
    s.u(paramString1, "appId");
    s.u(paramString2, "subscribeUrl");
    s.u(paramList, "templateIdList");
    s.u(paramString3, "extInfo");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByAppId appId: %s, url: %s, templateIdList size: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramList.size()) });
    if (localb.pjW != null)
    {
      com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.pkg;
      com.tencent.mm.msgsubscription.d.d.a(localb.pjW, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.d("", paramString1, paramString2, paramList, paramString3, localb.pjW, parama));
    }
    AppMethodBeat.o(236533);
  }
  
  public final SubscribeMsgTmpItem bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236455);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    Object localObject = this.piR;
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    localObject = ((com.tencent.mm.msgsubscription.d.b)localObject).pjW;
    if (localObject == null)
    {
      AppMethodBeat.o(236455);
      return null;
    }
    paramString1 = ((com.tencent.mm.msgsubscription.d.a)localObject).bX(paramString1, paramString2);
    AppMethodBeat.o(236455);
    return paramString1;
  }
  
  public void bV(String paramString1, final String paramString2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(236430);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    c localc = this.piS;
    ISubscribeMsgService.b localb = (ISubscribeMsgService.b)new c(this, paramString2);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    Object localObject1 = localc.pjd;
    Object localObject2;
    Object localObject3;
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = new ah.f();
      ((ah.f)localObject2).aqH = localObject1;
      localObject3 = localc.pjd;
      if (localObject3 != null) {
        break label259;
      }
      bool1 = false;
      label101:
      if (localObject1 == null) {
        break label287;
      }
      Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject1).phT) });
      if (((SubscribeMsgTmpItem)localObject1).phT != 1) {
        break label272;
      }
      label139:
      localObject3 = new ISubscribeMsgService.c(bool2, bool1);
      ((ISubscribeMsgService.c)localObject3).phY = ((SubscribeMsgTmpItem)localObject1).phY;
      ((ISubscribeMsgService.c)localObject3).phu = ((SubscribeMsgTmpItem)localObject1).phu;
      localb.a(paramString2, (ISubscribeMsgService.c)localObject3);
      localObject1 = (SubscribeMsgTmpItem)((ah.f)localObject2).aqH;
      localObject2 = (SubscribeMsgTmpItem)((ah.f)localObject2).aqH;
      if (localObject2 != null) {
        break label278;
      }
    }
    label259:
    label272:
    label278:
    for (int i = -1;; i = ((SubscribeMsgTmpItem)localObject2).phT)
    {
      paramString1 = new b(paramString1, paramString2, i);
      paramString1.piU = localb;
      paramString2 = ah.aiuX;
      localc.a((SubscribeMsgTmpItem)localObject1, paramString1);
      AppMethodBeat.o(236430);
      return;
      localObject1 = ((ISubscribeMsgService)localObject1).bU(paramString1, paramString2);
      break;
      bool1 = ((ISubscribeMsgService)localObject3).QV(paramString1);
      break label101;
      bool2 = false;
      break label139;
    }
    label287:
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from local");
    localObject1 = localc.pjd;
    if (localObject1 != null) {
      ((ISubscribeMsgService)localObject1).b(paramString1, (com.tencent.mm.msgsubscription.api.a)new c.c(localc, (ah.f)localObject2, paramString2, localb));
    }
    AppMethodBeat.o(236430);
  }
  
  public final void g(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(236495);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    com.tencent.mm.msgsubscription.d.b localb = this.piR;
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    if (localb.pjW != null)
    {
      Object localObject = com.tencent.mm.msgsubscription.d.d.pkg;
      localObject = localb.pjW;
      ArrayList localArrayList = new ArrayList();
      Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateGetSubscribeMsgUiStatusTimestamp timestamp: %s", new Object[] { Long.valueOf(paramLong) });
      localArrayList.add(new SubscribeMsgTmpItem(paramString2, paramLong));
      paramString2 = ah.aiuX;
      com.tencent.mm.msgsubscription.d.d.a((com.tencent.mm.msgsubscription.d.a)localObject, (com.tencent.mm.msgsubscription.e.a)new i(paramString1, (List)localArrayList, localb.pjW, (byte)0));
    }
    AppMethodBeat.o(236495);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService$UpdateSubscribeStatusTask;", "", "bizUsername", "", "templateId", "uiStatus", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBizUsername", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;)V", "getTemplateId", "getUiStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private final int hSI;
    final String hUQ;
    final String nSg;
    ISubscribeMsgService.b piU;
    
    public b(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(236335);
      this.hUQ = paramString1;
      this.nSg = paramString2;
      this.hSI = paramInt;
      AppMethodBeat.o(236335);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(236350);
      if (this == paramObject)
      {
        AppMethodBeat.o(236350);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(236350);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.hUQ, paramObject.hUQ))
      {
        AppMethodBeat.o(236350);
        return false;
      }
      if (!s.p(this.nSg, paramObject.nSg))
      {
        AppMethodBeat.o(236350);
        return false;
      }
      if (this.hSI != paramObject.hSI)
      {
        AppMethodBeat.o(236350);
        return false;
      }
      AppMethodBeat.o(236350);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(236345);
      int i = this.hUQ.hashCode();
      int j = this.nSg.hashCode();
      int k = this.hSI;
      AppMethodBeat.o(236345);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(236342);
      String str = "UpdateSubscribeStatusTask(bizUsername=" + this.hUQ + ", templateId=" + this.nSg + ", uiStatus=" + this.hSI + ')';
      AppMethodBeat.o(236342);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/SubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ISubscribeMsgService.b
  {
    c(a parama, String paramString) {}
    
    public final void a(String paramString, ISubscribeMsgService.c paramc)
    {
      AppMethodBeat.i(236338);
      s.u(paramString, "templateId");
      s.u(paramc, "result");
      a.b(paramString, paramc);
      AppMethodBeat.o(236338);
    }
    
    public final void atR()
    {
      AppMethodBeat.i(236341);
      a.QY(paramString2);
      AppMethodBeat.o(236341);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<ISubscribeMsgService.b, ah>
  {
    e(String paramString, ISubscribeMsgService.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/SubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ISubscribeMsgService.b
  {
    f(a parama, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb) {}
    
    public final void a(String paramString, ISubscribeMsgService.c paramc)
    {
      AppMethodBeat.i(236331);
      s.u(paramString, "templateId");
      s.u(paramc, "result");
      a.b(paramSubscribeMsgTmpItem.nSg, paramc);
      paramString = paramb;
      if (paramString != null) {
        paramString.a(paramSubscribeMsgTmpItem.nSg, paramc);
      }
      AppMethodBeat.o(236331);
    }
    
    public final void atR()
    {
      AppMethodBeat.i(236336);
      a.QY(paramSubscribeMsgTmpItem.nSg);
      ISubscribeMsgService.b localb = paramb;
      if (localb != null) {
        localb.atR();
      }
      AppMethodBeat.o(236336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a
 * JD-Core Version:    0.7.0.1
 */