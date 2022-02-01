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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgServiceProxy;", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "()V", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "templateId", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSwitchOpened", "Companion", "plugin-comm_release"})
public final class b
  extends a
{
  public static final b.a mpM;
  
  static
  {
    AppMethodBeat.i(193541);
    mpM = new b.a((byte)0);
    AppMethodBeat.o(193541);
  }
  
  public b()
  {
    super(null);
  }
  
  public final void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(193537);
    p.k(paramContext, "context");
    p.k(paramString, "bizAppId");
    super.a(paramContext, paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(193537);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193539);
    p.k(paramContext, "context");
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "nickname");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "goToSettingManagerUI not implemented in non-mm process");
    AppMethodBeat.o(193539);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(193536);
    p.k(paramContext, "context");
    p.k(paramBundle, "extra");
    super.a(paramContext, paramString1, paramString2, paramBundle);
    AppMethodBeat.o(193536);
  }
  
  public final void a(String paramString, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(193532);
    p.k(paramString, "bizUsername");
    p.k(paramSubscribeMsgTmpItem, "tmpItem");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "switchSubscribeStatus not implemented in non-mm process");
    AppMethodBeat.o(193532);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(193533);
    p.k(paramString, "bizUsername");
    p.k(paramList, "subscribeMsgList");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "saveSubscribeMsgUiStatus not implemented in non-mm process");
    AppMethodBeat.o(193533);
  }
  
  public final void ab(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(193535);
    p.k(paramString, "bizUsername");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "updateLocalSwitchOpened not implemented in non-mm process");
    AppMethodBeat.o(193535);
  }
  
  public final void bJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193531);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "isTemplateMsgSubscribed not implemented in non-mm process");
    AppMethodBeat.o(193531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.b
 * JD-Core Version:    0.7.0.1
 */