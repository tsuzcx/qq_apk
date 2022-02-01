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
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "storageManager", "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "(Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;)V", "dataLoader", "Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgDataLoader;", "mSubscribeStatusManager", "Lcom/tencent/mm/msgsubscription/model/SubscribeStatusUpdateManager;", "callbackWrapper", "", "templateId", "", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "Lkotlin/ParameterName;", "name", "callback", "clickSubscribeMsgSpan", "context", "Landroid/content/Context;", "bizUsername", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", "username", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getStorage", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", "extInfo", "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "onErrorWrapper", "onUpdatedWrapper", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", "timestamp", "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "UpdateSubscribeStatusTask", "plugin-comm_release"})
public class a
  implements ISubscribeMsgService
{
  private static final HashMap<String, HashMap<String, ISubscribeMsgService.b>> mpe;
  public static final a.a mpf;
  public final com.tencent.mm.msgsubscription.d.a mpb;
  private final com.tencent.mm.msgsubscription.d.b mpc;
  private final c mpd;
  
  static
  {
    AppMethodBeat.i(193791);
    mpf = new a.a((byte)0);
    mpe = new HashMap();
    AppMethodBeat.o(193791);
  }
  
  public a(com.tencent.mm.msgsubscription.d.a parama)
  {
    AppMethodBeat.i(193790);
    this.mpb = parama;
    this.mpc = new com.tencent.mm.msgsubscription.d.b(parama);
    this.mpd = new c((ISubscribeMsgService)this);
    AppMethodBeat.o(193790);
  }
  
  private static void b(String paramString, kotlin.g.a.b<? super ISubscribeMsgService.b, x> paramb)
  {
    Integer localInteger = null;
    AppMethodBeat.i(193789);
    HashMap localHashMap = (HashMap)mpe.get(paramString);
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
    AppMethodBeat.o(193789);
    return;
    label121:
    AppMethodBeat.o(193789);
  }
  
  public final boolean YQ(String paramString)
  {
    AppMethodBeat.i(193774);
    p.k(paramString, "bizUsername");
    Object localObject = this.mpc;
    p.k(paramString, "bizUsername");
    localObject = ((com.tencent.mm.msgsubscription.d.b)localObject).mqj;
    if (localObject != null)
    {
      boolean bool = ((com.tencent.mm.msgsubscription.d.a)localObject).YY(paramString);
      AppMethodBeat.o(193774);
      return bool;
    }
    AppMethodBeat.o(193774);
    return false;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(193787);
    p.k(paramContext, "context");
    p.k(paramString, "bizAppId");
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
      AppMethodBeat.o(193787);
      return;
    }
    Log.e("MicroMsg.BaseSubscribeMsgService", "alvinluo requestSubscribeMsgForResult context is not activity");
    AppMethodBeat.o(193787);
  }
  
  public void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193784);
    p.k(paramContext, "context");
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "nickname");
    AppMethodBeat.o(193784);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(193785);
    p.k(paramContext, "context");
    p.k(paramBundle, "extra");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clickSubscribeMsgSpan bizUsername: %s, url: %s", new Object[] { paramString1, paramString2 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(193785);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(193785);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aFh(), "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/msgsubscription/model/SubscribeMsgService", "clickSubscribeMsgSpan", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(193785);
  }
  
  public final void a(com.tencent.mm.msgsubscription.api.c paramc)
  {
    AppMethodBeat.i(193783);
    p.k(paramc, "updateRequest");
    this.mpc.a(paramc);
    AppMethodBeat.o(193783);
  }
  
  public void a(String paramString, final SubscribeMsgTmpItem paramSubscribeMsgTmpItem, final ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(193772);
    p.k(paramString, "bizUsername");
    p.k(paramSubscribeMsgTmpItem, "tmpItem");
    c localc = this.mpd;
    paramb = (ISubscribeMsgService.b)new f(this, paramSubscribeMsgTmpItem, paramb);
    p.k(paramString, "bizUsername");
    p.k(paramSubscribeMsgTmpItem, "tmpItem");
    p.k(paramb, "callback");
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo switchSubscribeStatus templateId: %s, settingStatus: %d, switchOpened: %b", new Object[] { paramSubscribeMsgTmpItem.lnb, Integer.valueOf(paramSubscribeMsgTmpItem.mof), Boolean.valueOf(paramSubscribeMsgTmpItem.gZ) });
    ArrayList localArrayList = j.ag(new SubscribeMsgTmpItem[] { paramSubscribeMsgTmpItem });
    Object localObject = localc.mpp;
    if (localObject != null) {
      ISubscribeMsgService.a.a((ISubscribeMsgService)localObject, paramString, (List)localArrayList);
    }
    localObject = new com.tencent.mm.msgsubscription.api.c();
    ((com.tencent.mm.msgsubscription.api.c)localObject).setUsername(paramString);
    ((com.tencent.mm.msgsubscription.api.c)localObject).moB.addAll((Collection)localArrayList);
    ((com.tencent.mm.msgsubscription.api.c)localObject).moH = paramSubscribeMsgTmpItem.gZ;
    ((com.tencent.mm.msgsubscription.api.c)localObject).moK = ((com.tencent.mm.msgsubscription.api.a)new c.d(localc, paramSubscribeMsgTmpItem, paramb, paramString));
    paramString = localc.mpp;
    if (paramString != null)
    {
      paramString.a((com.tencent.mm.msgsubscription.api.c)localObject);
      AppMethodBeat.o(193772);
      return;
    }
    AppMethodBeat.o(193772);
  }
  
  public final void a(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(193780);
    p.k(paramString, "username");
    this.mpc.a(paramString, parama);
    AppMethodBeat.o(193780);
  }
  
  public final void a(String paramString1, String paramString2, List<String> paramList, String paramString3, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(193781);
    p.k(paramString1, "username");
    p.k(paramString2, "subscribeUrl");
    p.k(paramList, "templateIdList");
    p.k(paramString3, "extInfo");
    com.tencent.mm.msgsubscription.d.b localb = this.mpc;
    p.k(paramString1, "username");
    p.k(paramString2, "subscribeUrl");
    p.k(paramList, "templateIdList");
    p.k(paramString3, "extInfo");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByUsername username: %s, url: %s, templateIdList size: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramList.size()) });
    if (localb.mqj == null)
    {
      AppMethodBeat.o(193781);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.mqz;
    com.tencent.mm.msgsubscription.d.d.a(localb.mqj, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.d(paramString1, "", paramString2, paramList, paramString3, localb.mqj, parama));
    AppMethodBeat.o(193781);
  }
  
  public final void a(String paramString, List<String> paramList, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(193779);
    p.k(paramString, "username");
    p.k(paramList, "templateIdList");
    com.tencent.mm.msgsubscription.d.b localb = this.mpc;
    p.k(paramString, "username");
    p.k(paramList, "templateIdList");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeStatus username: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    if (localb.mqj == null)
    {
      AppMethodBeat.o(193779);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.mqz;
    com.tencent.mm.msgsubscription.d.d.a(localb.mqj, (com.tencent.mm.msgsubscription.e.a)new e(paramString, paramList, localb.mqj, parama));
    AppMethodBeat.o(193779);
  }
  
  public void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(193776);
    p.k(paramString, "bizUsername");
    p.k(paramList, "subscribeMsgList");
    this.mpc.a(paramString, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(193776);
  }
  
  public void ab(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(193778);
    p.k(paramString, "bizUsername");
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo updateLocalSwitchOpened bizUsername: %s, switchOpened: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    com.tencent.mm.msgsubscription.d.b localb = this.mpc;
    p.k(paramString, "username");
    localb.a(paramString, (List)new ArrayList(), paramBoolean, true, false);
    AppMethodBeat.o(193778);
  }
  
  public final void b(String paramString, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(193775);
    p.k(paramString, "username");
    com.tencent.mm.msgsubscription.d.b localb = this.mpc;
    p.k(paramString, "username");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getLocalSubscribeList username: %s", new Object[] { paramString });
    if (localb.mqj == null)
    {
      AppMethodBeat.o(193775);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.mqz;
    com.tencent.mm.msgsubscription.d.d.a(localb.mqj, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.c(paramString, localb.mqj, parama));
    AppMethodBeat.o(193775);
  }
  
  public final void b(String paramString1, String paramString2, List<String> paramList, String paramString3, com.tencent.mm.msgsubscription.api.a parama)
  {
    AppMethodBeat.i(193782);
    p.k(paramString1, "appId");
    p.k(paramString2, "subscribeUrl");
    p.k(paramList, "templateIdList");
    p.k(paramString3, "extInfo");
    com.tencent.mm.msgsubscription.d.b localb = this.mpc;
    p.k(paramString1, "appId");
    p.k(paramString2, "subscribeUrl");
    p.k(paramList, "templateIdList");
    p.k(paramString3, "extInfo");
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo getSubscribeListByAppId appId: %s, url: %s, templateIdList size: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramList.size()) });
    if (localb.mqj == null)
    {
      AppMethodBeat.o(193782);
      return;
    }
    com.tencent.mm.msgsubscription.d.d locald = com.tencent.mm.msgsubscription.d.d.mqz;
    com.tencent.mm.msgsubscription.d.d.a(localb.mqj, (com.tencent.mm.msgsubscription.e.a)new com.tencent.mm.msgsubscription.e.d("", paramString1, paramString2, paramList, paramString3, localb.mqj, parama));
    AppMethodBeat.o(193782);
  }
  
  public final SubscribeMsgTmpItem bI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193773);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    Object localObject = this.mpc;
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    localObject = ((com.tencent.mm.msgsubscription.d.b)localObject).mqj;
    if (localObject != null)
    {
      paramString1 = ((com.tencent.mm.msgsubscription.d.a)localObject).bL(paramString1, paramString2);
      AppMethodBeat.o(193773);
      return paramString1;
    }
    AppMethodBeat.o(193773);
    return null;
  }
  
  public void bJ(String paramString1, final String paramString2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(193771);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    c localc = this.mpd;
    ISubscribeMsgService.b localb = (ISubscribeMsgService.b)new c(this, paramString2);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    Object localObject1 = localc.mpp;
    Object localObject2;
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((ISubscribeMsgService)localObject1).bI(paramString1, paramString2);
      localObject2 = new aa.f();
      ((aa.f)localObject2).aaBC = localObject1;
      Object localObject3 = localc.mpp;
      if (localObject3 == null) {
        break label266;
      }
      bool1 = ((ISubscribeMsgService)localObject3).YQ(paramString1);
      label116:
      if (localObject1 == null) {
        break label283;
      }
      Log.v("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from cache: %d", new Object[] { Integer.valueOf(((SubscribeMsgTmpItem)localObject1).mof) });
      if (((SubscribeMsgTmpItem)localObject1).mof != 1) {
        break label272;
      }
      label154:
      localObject3 = new ISubscribeMsgService.c(bool2, bool1);
      ((ISubscribeMsgService.c)localObject3).mok = ((SubscribeMsgTmpItem)localObject1).mok;
      ((ISubscribeMsgService.c)localObject3).mnH = ((SubscribeMsgTmpItem)localObject1).mnH;
      localb.a(paramString2, (ISubscribeMsgService.c)localObject3);
      localObject1 = (SubscribeMsgTmpItem)((aa.f)localObject2).aaBC;
      localObject2 = (SubscribeMsgTmpItem)((aa.f)localObject2).aaBC;
      if (localObject2 == null) {
        break label278;
      }
    }
    label266:
    label272:
    label278:
    for (int i = ((SubscribeMsgTmpItem)localObject2).mof;; i = -1)
    {
      paramString1 = new a.b(paramString1, paramString2, i);
      paramString1.mpg = localb;
      localc.a((SubscribeMsgTmpItem)localObject1, paramString1);
      AppMethodBeat.o(193771);
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label116;
      bool2 = false;
      break label154;
    }
    label283:
    Log.i("MicroMsg.SubscribeStatusUpdateManager", "alvinluo isTemplateMsgSubscribed read from local");
    localObject1 = localc.mpp;
    if (localObject1 != null)
    {
      ((ISubscribeMsgService)localObject1).b(paramString1, (com.tencent.mm.msgsubscription.api.a)new c.c(localc, paramString2, localb, (aa.f)localObject2));
      AppMethodBeat.o(193771);
      return;
    }
    AppMethodBeat.o(193771);
  }
  
  public final void g(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(193777);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    com.tencent.mm.msgsubscription.d.b localb = this.mpc;
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    if (localb.mqj == null)
    {
      AppMethodBeat.o(193777);
      return;
    }
    Object localObject = com.tencent.mm.msgsubscription.d.d.mqz;
    localObject = localb.mqj;
    ArrayList localArrayList = new ArrayList();
    Log.i("MicroMsg.SubscribeMsgDataLoader", "alvinluo updateGetSubscribeMsgUiStatusTimestamp timestamp: %s", new Object[] { Long.valueOf(paramLong) });
    localArrayList.add(new SubscribeMsgTmpItem(paramString2, paramLong));
    com.tencent.mm.msgsubscription.d.d.a((com.tencent.mm.msgsubscription.d.a)localObject, (com.tencent.mm.msgsubscription.e.a)new i(paramString1, (List)localArrayList, localb.mqj, (byte)0));
    AppMethodBeat.o(193777);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/SubscribeMsgService$isTemplateMsgSubscribed$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static final class c
    implements ISubscribeMsgService.b
  {
    c(String paramString) {}
    
    public final void a(String paramString, ISubscribeMsgService.c paramc)
    {
      AppMethodBeat.i(226474);
      p.k(paramString, "templateId");
      p.k(paramc, "result");
      a.b(paramString, paramc);
      AppMethodBeat.o(226474);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(226477);
      a.YT(paramString2);
      AppMethodBeat.o(226477);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<ISubscribeMsgService.b, x>
  {
    e(String paramString, ISubscribeMsgService.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/SubscribeMsgService$switchSubscribeStatus$1", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
  public static final class f
    implements ISubscribeMsgService.b
  {
    f(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb) {}
    
    public final void a(String paramString, ISubscribeMsgService.c paramc)
    {
      AppMethodBeat.i(187520);
      p.k(paramString, "templateId");
      p.k(paramc, "result");
      a.b(paramSubscribeMsgTmpItem.lnb, paramc);
      paramString = paramb;
      if (paramString != null)
      {
        paramString.a(paramSubscribeMsgTmpItem.lnb, paramc);
        AppMethodBeat.o(187520);
        return;
      }
      AppMethodBeat.o(187520);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(187521);
      a.YT(paramSubscribeMsgTmpItem.lnb);
      ISubscribeMsgService.b localb = paramb;
      if (localb != null)
      {
        localb.onError();
        AppMethodBeat.o(187521);
        return;
      }
      AppMethodBeat.o(187521);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a
 * JD-Core Version:    0.7.0.1
 */