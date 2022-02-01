package com.tencent.mm.msgsubscription.b.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b;
import com.tencent.mm.msgsubscription.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgServiceProxy;", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "()V", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "templateId", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "callback", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "", "switchOpened", "", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSwitchOpened", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a pjy;
  
  static
  {
    AppMethodBeat.i(236386);
    pjy = new b.a((byte)0);
    AppMethodBeat.o(236386);
  }
  
  public b()
  {
    super(null);
  }
  
  public final void a(Context paramContext, int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(236426);
    s.u(paramContext, "context");
    s.u(paramString, "bizAppId");
    super.a(paramContext, paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(236426);
  }
  
  public final void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(236431);
    s.u(paramContext, "context");
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "nickname");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "goToSettingManagerUI not implemented in non-mm process");
    AppMethodBeat.o(236431);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(236420);
    s.u(paramContext, "context");
    s.u(paramBundle, "extra");
    super.a(paramContext, paramString1, paramString2, paramBundle);
    AppMethodBeat.o(236420);
  }
  
  public final void a(String paramString, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, ISubscribeMsgService.b paramb)
  {
    AppMethodBeat.i(236400);
    s.u(paramString, "bizUsername");
    s.u(paramSubscribeMsgTmpItem, "tmpItem");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "switchSubscribeStatus not implemented in non-mm process");
    AppMethodBeat.o(236400);
  }
  
  public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(236405);
    s.u(paramString, "bizUsername");
    s.u(paramList, "subscribeMsgList");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "saveSubscribeMsgUiStatus not implemented in non-mm process");
    AppMethodBeat.o(236405);
  }
  
  public final void ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(236414);
    s.u(paramString, "bizUsername");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "updateLocalSwitchOpened not implemented in non-mm process");
    AppMethodBeat.o(236414);
  }
  
  public final void bV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236392);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    Log.w("MicroMsg.SubscribeMsgServiceProxy", "isTemplateMsgSubscribed not implemented in non-mm process");
    AppMethodBeat.o(236392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.b
 * JD-Core Version:    0.7.0.1
 */