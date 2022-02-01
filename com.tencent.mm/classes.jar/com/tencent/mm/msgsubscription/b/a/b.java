package com.tencent.mm.msgsubscription.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.msgsubscription.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgServiceProxy;", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "()V", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "templateId", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSwitchOpened", "Companion", "plugin-comm_release"})
public final class b
  extends a
{
  public static final b.a jAg;
  
  static
  {
    AppMethodBeat.i(223328);
    jAg = new b.a((byte)0);
    AppMethodBeat.o(223328);
  }
  
  public b()
  {
    super(null);
  }
  
  public final void Z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223324);
    p.h(paramString, "bizUsername");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "updateLocalSwitchOpened not implemented in non-mm process");
    AppMethodBeat.o(223324);
  }
  
  public final void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(223326);
    p.h(paramContext, "context");
    p.h(paramString, "bizAppId");
    super.a(paramContext, paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(223326);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(223327);
    p.h(paramContext, "context");
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "nickname");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "goToSettingManagerUI not implemented in non-mm process");
    AppMethodBeat.o(223327);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(223325);
    p.h(paramContext, "context");
    p.h(paramBundle, "extra");
    super.a(paramContext, paramString1, paramString2, paramBundle);
    AppMethodBeat.o(223325);
  }
  
  public final void a(String paramString, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(223322);
    p.h(paramString, "bizUsername");
    p.h(paramSubscribeMsgTmpItem, "tmpItem");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "switchSubscribeStatus not implemented in non-mm process");
    AppMethodBeat.o(223322);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(223323);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgList");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "saveSubscribeMsgUiStatus not implemented in non-mm process");
    AppMethodBeat.o(223323);
  }
  
  public final void bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223321);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "isTemplateMsgSubscribed not implemented in non-mm process");
    AppMethodBeat.o(223321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.b
 * JD-Core Version:    0.7.0.1
 */