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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "mSubscribeStatusManager", "Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "callbackWrapper", "", "templateId", "", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", "username", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getStorage", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdatedWrapper", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"})
public class a
  implements ISubscribeMsgService
{
  private static final HashMap<String, HashMap<String, ISubscribeMsgService.b>> jzy;
  public static final a.a jzz;
  public final com.tencent.mm.msgsubscription.d.a jzv;
  private final com.tencent.mm.msgsubscription.d.b jzw;
  private final c jzx;
  
  static
  {
    AppMethodBeat.i(223268);
    jzz = new a.a((byte)0);
    jzy = new HashMap();
    AppMethodBeat.o(223268);
  }
  
  public a(com.tencent.mm.msgsubscription.d.a parama)
  {
    AppMethodBeat.i(223267);
    this.jzv = parama;
    this.jzw = new com.tencent.mm.msgsubscription.d.b(parama);
    this.jzx = new c((ISubscribeMsgService)this);
    AppMethodBeat.o(223267);
  }
  
  private static void b(String paramString, kotlin.g.a.b<? super ISubscribeMsgService.b, x> paramb)
  {
    Integer localInteger = null;
    AppMethodBeat.i(223266);
    HashMap localHashMap = (HashMap)jzy.get(paramString);
    if (localHashMap != null) {}
    for (Set localSet = localHashMap.keySet();; localSet = null)
    {
      if (localSet != null) {
        localInteger = Integer.valueOf(localSet.size());
      }
      Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo callbackWrapper templateId: %s, callback size: %s", new Object[] { paramString, localInteger });
      if (localSet == null) {
        break label121;
      }
      paramString = ((Iterable)localSet).iterator();
      while (paramString.hasNext()) {
        paramb.invoke(localHashMap.get((String)paramString.next()));
      }
    }
    AppMethodBeat.o(223266);
    return;
    label121:
    AppMethodBeat.o(223266);
  }
  
  public final boolean Rt(String paramString)
  {
    AppMethodBeat.i(223253);
    p.h(paramString, "bizUsername");
    Object localObject = this.jzw;
    p.h(paramString, "bizUsername");
    localObject = ((com.tencent.mm.msgsubscription.d.b)localObject).jAB;
    if (localObject != null)
    {
      boolean bool = ((com.tencent.mm.msgsubscription.d.a)localObject).Rz(paramString);
      AppMethodBeat.o(223253);
      return bool;
    }
    AppMethodBeat.o(223253);
    return false;
  }
  
  public void Z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223257);
    p.h(paramString, "bizUsername");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.msgsubscription.d.b localb = this.jzw;
    p.h(paramString, "username");
    localb.a(paramString, (List)new ArrayList(), paramBoolean, true, false);
    AppMethodBeat.o(223257);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(223265);
    p.h(paramContext, "context");
    p.h(paramString, "bizAppId");
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
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
      AppMethodBeat.o(223265);
      return;
    }
    Log.e("MicroMsg.BaseSubscribeMsgService", "alvinluo requestSubscribeMsgForResult context is not activity");
    AppMethodBeat.o(223265);
  }
  
  public void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(223263);
    p.h(paramContext, "context");
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "nickname");
    AppMethodBeat.o(223263);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(223264);
    p.h(paramContext, "context");
    p.h(paramBundle, "extra");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clickSubscribeMsgSpan bizUsername: %s, url: %s", new Object[] { paramString1, paramString2 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(223264);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(223264);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(223264);
  }
  
  public final void a(com.tencent.mm.msgsubscription.api.c paramc)
  {
    AppMethodBeat.i(223262);
    p.h(paramc, "updateRequest");
    this.jzw.a(paramc);
    AppMethodBeat.o(223262);
  }
  
  public void a(String paramString, final SubscribeMsgTmpItem paramSubscribeMsgTmpItem, final ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(223251);
    p.h(paramString, "bizUsername");
    p.h(paramSubscribeMsgTmpItem, "tmpItem");
    c localc = this.jzx;
    paramb = (ISubscribeMsgService.b)new f(this, paramSubscribeMsgTmpItem, paramb);
    p.h(paramString, "bizUsername");
    p.h(paramSubscribeMsgTmpItem, "tmpItem");
    p.h(paramb, "callback");
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus templateId: %s, settingStatus: %d, switchOpened: %b", new Object[] { paramSubscribeMsgTmpItem.ixM, Integer.valueOf(paramSubscribeMsgTmpItem.jyB), Boolean.valueOf(paramSubscribeMsgTmpItem.VC) });
    ArrayList localArrayList = j.ac(new SubscribeMsgTmpItem[] { paramSubscribeMsgTmpItem });
    Object localObject = localc.jzJ;
    if (localObject != null) {
      ISubscribeMsgService.a.a((ISubscribeMsgService)localObject, paramString, (List)localArrayList);
    }
    localObject = new com.tencent.mm.msgsubscription.api.c();
    ((com.tencent.mm.msgsubscription.api.c)localObject).setUsername(paramString);
    ((com.tencent.mm.msgsubscription.api.c)localObject).jyV.addAll((Collection)localArrayList);
    ((com.tencent.mm.msgsubscription.api.c)localObject).jzb = paramSubscribeMsgTmpItem.VC;
    ((com.tencent.mm.msgsubscription.api.c)localObject).jze = ((com.tencent.mm.msgsubscription.api.a)new c.d(localc, paramSubscribeMsgTmpItem, paramb, paramString));
    paramString = localc.jzJ;
    if (paramString != null)
    {
      paramString.a((com.tencent.mm.msgsubscription.api.c)localObject);
      AppMethodBeat.o(223251);
      return;
    }
    AppMethodBeat.o(223251);
  }
  
  public final void a(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(223259);
    p.h(paramString, "username");
    this.jzw.a(paramString, parama);
    AppMethodBeat.o(223259);
  }
  
  public final void a(String paramString1, String paramString2, List<String> paramList, String paramString3, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(223260);
    p.h(paramString1, "username");
    p.h(paramString2, "subscribeUrl");
    p.h(paramList, "templateIdList");
    p.h(paramString3, "extInfo");
    com.tencent.mm.msgsubscription.d.b localb = this.jzw;
    p.h(paramString1, "username");
    p.h(paramString2, "subscribeUrl");
    p.h(paramList, "templateIdList");
    p.h(paramString3, "extInfo");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByUsername username: %s, url: %s, templateIdList size: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramList.size()) });
    if (localb.jAB == null)
    {
      AppMethodBeat.o(223260);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.jAR;
    com.tencent.mm.msgsubscription.d.d.a(localb.jAB, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.d(paramString1, "", paramString2, paramList, paramString3, localb.jAB, parama));
    AppMethodBeat.o(223260);
  }
  
  public final void a(String paramString, List<String> paramList, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(223258);
    p.h(paramString, "username");
    p.h(paramList, "templateIdList");
    com.tencent.mm.msgsubscription.d.b localb = this.jzw;
    p.h(paramString, "username");
    p.h(paramList, "templateIdList");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeStatus username: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    if (localb.jAB == null)
    {
      AppMethodBeat.o(223258);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.jAR;
    com.tencent.mm.msgsubscription.d.d.a(localb.jAB, (com.tencent.mm.msgsubscription.e.a)new e(paramString, paramList, localb.jAB, parama));
    AppMethodBeat.o(223258);
  }
  
  public void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(223255);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgList");
    this.jzw.a(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(223255);
  }
  
  public final void b(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(223254);
    p.h(paramString, "username");
    com.tencent.mm.msgsubscription.d.b localb = this.jzw;
    p.h(paramString, "username");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getLocalSubscribeList username: %s", new Object[] { paramString });
    if (localb.jAB == null)
    {
      AppMethodBeat.o(223254);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.jAR;
    com.tencent.mm.msgsubscription.d.d.a(localb.jAB, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.c(paramString, localb.jAB, parama));
    AppMethodBeat.o(223254);
  }
  
  public final void b(String paramString1, String paramString2, List<String> paramList, String paramString3, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(223261);
    p.h(paramString1, "appId");
    p.h(paramString2, "subscribeUrl");
    p.h(paramList, "templateIdList");
    p.h(paramString3, "extInfo");
    com.tencent.mm.msgsubscription.d.b localb = this.jzw;
    p.h(paramString1, "appId");
    p.h(paramString2, "subscribeUrl");
    p.h(paramList, "templateIdList");
    p.h(paramString3, "extInfo");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByAppId appId: %s, url: %s, templateIdList size: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramList.size()) });
    if (localb.jAB == null)
    {
      AppMethodBeat.o(223261);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.jAR;
    com.tencent.mm.msgsubscription.d.d.a(localb.jAB, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.d("", paramString1, paramString2, paramList, paramString3, localb.jAB, parama));
    AppMethodBeat.o(223261);
  }
  
  public final SubscribeMsgTmpItem bF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223252);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    Object localObject = this.jzw;
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    localObject = ((com.tencent.mm.msgsubscription.d.b)localObject).jAB;
    if (localObject != null)
    {
      paramString1 = ((com.tencent.mm.msgsubscription.d.a)localObject).bI(paramString1, paramString2);
      AppMethodBeat.o(223252);
      return paramString1;
    }
    AppMethodBeat.o(223252);
    return null;
  }
  
  public void bG(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(223250);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    c localc = this.jzx;
    ISubscribeMsgService.b localb = (ISubscribeMsgService.b)new c(this, paramString2);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    Object localObject1 = localc.jzJ;
    Object localObject2;
    boolean bool1;
    label113:
    boolean bool2;
    if (localObject1 != null)
    {
      localObject1 = ((ISubscribeMsgService)localObject1).bF(paramString1, paramString2);
      localObject2 = new z.f();
      ((z.f)localObject2).SYG = localObject1;
      ISubscribeMsgService localISubscribeMsgService = localc.jzJ;
      if (localISubscribeMsgService == null) {
        break label242;
      }
      bool1 = localISubscribeMsgService.Rt(paramString1);
      if (localObject1 == null) {
        break label259;
      }
      Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject1).jyB) });
      if (((SubscribeMsgTmpItem)localObject1).jyB != 1) {
        break label248;
      }
      bool2 = true;
      label154:
      localb.a(paramString2, new ISubscribeMsgService.c(bool2, bool1));
      localObject1 = (SubscribeMsgTmpItem)((z.f)localObject2).SYG;
      localObject2 = (SubscribeMsgTmpItem)((z.f)localObject2).SYG;
      if (localObject2 == null) {
        break label254;
      }
    }
    label242:
    label248:
    label254:
    for (int i = ((SubscribeMsgTmpItem)localObject2).jyB;; i = -1)
    {
      paramString1 = new a.b(paramString1, paramString2, i);
      paramString1.jzA = localb;
      localc.a((SubscribeMsgTmpItem)localObject1, paramString1);
      AppMethodBeat.o(223250);
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label113;
      bool2 = false;
      break label154;
    }
    label259:
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from local");
    localObject1 = localc.jzJ;
    if (localObject1 != null)
    {
      ((ISubscribeMsgService)localObject1).b(paramString1, (com.tencent.mm.msgsubscription.api.a)new c.c(localc, paramString2, localb, (z.f)localObject2));
      AppMethodBeat.o(223250);
      return;
    }
    AppMethodBeat.o(223250);
  }
  
  public final void g(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(223256);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    com.tencent.mm.msgsubscription.d.b localb = this.jzw;
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    if (localb.jAB == null)
    {
      AppMethodBeat.o(223256);
      return;
    }
    Object localObject = com.tencent.mm.msgsubscription.d.d.jAR;
    localObject = localb.jAB;
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateGetSubscribeMsgUiStatusTimestamp timestamp: %s", new Object[] { Long.valueOf(paramLong) });
    localArrayList.add(new SubscribeMsgTmpItem(paramString2, paramLong));
    com.tencent.mm.msgsubscription.d.d.a((com.tencent.mm.msgsubscription.d.a)localObject, (com.tencent.mm.msgsubscription.e.a)new i(paramString1, (List)localArrayList, localb.jAB, (byte)0));
    AppMethodBeat.o(223256);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/SubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static final class c
    implements ISubscribeMsgService.b
  {
    c(String paramString) {}
    
    public final void a(String paramString, ISubscribeMsgService.c paramc)
    {
      AppMethodBeat.i(223243);
      p.h(paramString, "templateId");
      p.h(paramc, "result");
      a.b(paramString, paramc);
      AppMethodBeat.o(223243);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(223244);
      a.Rw(paramString2);
      AppMethodBeat.o(223244);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/SubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static final class f
    implements ISubscribeMsgService.b
  {
    f(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb) {}
    
    public final void a(String paramString, ISubscribeMsgService.c paramc)
    {
      AppMethodBeat.i(223248);
      p.h(paramString, "templateId");
      p.h(paramc, "result");
      a.b(paramSubscribeMsgTmpItem.ixM, paramc);
      paramString = paramb;
      if (paramString != null)
      {
        paramString.a(paramSubscribeMsgTmpItem.ixM, paramc);
        AppMethodBeat.o(223248);
        return;
      }
      AppMethodBeat.o(223248);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(223249);
      a.Rw(paramSubscribeMsgTmpItem.ixM);
      ISubscribeMsgService.b localb = paramb;
      if (localb != null)
      {
        localb.onError();
        AppMethodBeat.o(223249);
        return;
      }
      AppMethodBeat.o(223249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a
 * JD-Core Version:    0.7.0.1
 */