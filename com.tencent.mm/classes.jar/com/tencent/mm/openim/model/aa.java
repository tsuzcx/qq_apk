package com.tencent.mm.openim.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.d;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenIMKefuStartConversationService;", "Lcom/tencent/mm/openim/api/IOpenIMKefuStartConversationService;", "()V", "buildBaseStartIntent", "", "intent", "Landroid/content/Intent;", "request", "Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;", "fillConfirmIntent", "fillRequest", "fillStartChattingIntent", "startConversation", "startConversationForResult", "requestCode", "", "activityResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "startConversationWithoutConfirm", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements d
{
  public static final aa.a ptc;
  
  static
  {
    AppMethodBeat.i(235841);
    ptc = new aa.a((byte)0);
    AppMethodBeat.o(235841);
  }
  
  private static void a(Intent paramIntent, OpenIMKefuStartConversationRequest paramOpenIMKefuStartConversationRequest)
  {
    AppMethodBeat.i(235838);
    paramIntent.putExtra("key_start_conversation_request", (Parcelable)paramOpenIMKefuStartConversationRequest);
    paramIntent.putExtras(paramOpenIMKefuStartConversationRequest.prG);
    AppMethodBeat.o(235838);
  }
  
  private static void d(OpenIMKefuStartConversationRequest paramOpenIMKefuStartConversationRequest)
  {
    AppMethodBeat.i(235834);
    Object localObject = paramOpenIMKefuStartConversationRequest.pry;
    if (localObject != null)
    {
      if (((du)localObject).YFX == null) {
        ((du)localObject).YFX = new dxm();
      }
      localObject = ((du)localObject).YFX;
      if (localObject != null)
      {
        ((dxm)localObject).scene = paramOpenIMKefuStartConversationRequest.prw;
        paramOpenIMKefuStartConversationRequest = paramOpenIMKefuStartConversationRequest.pry;
        s.checkNotNull(paramOpenIMKefuStartConversationRequest);
        ((dxm)localObject).url = paramOpenIMKefuStartConversationRequest.url;
      }
    }
    AppMethodBeat.o(235834);
  }
  
  public final void a(OpenIMKefuStartConversationRequest paramOpenIMKefuStartConversationRequest)
  {
    AppMethodBeat.i(235846);
    s.u(paramOpenIMKefuStartConversationRequest, "request");
    d(paramOpenIMKefuStartConversationRequest);
    Log.i("MicroMsg.OpenIMKefuStartConversationService", "alvinluo startConversation %s", new Object[] { paramOpenIMKefuStartConversationRequest });
    if (paramOpenIMKefuStartConversationRequest.hBk == 0L) {
      paramOpenIMKefuStartConversationRequest.hBk = System.currentTimeMillis();
    }
    Object localObject = paramOpenIMKefuStartConversationRequest.prF;
    if (localObject == null) {
      localObject = new Intent();
    }
    for (;;)
    {
      a((Intent)localObject, paramOpenIMKefuStartConversationRequest);
      ((Intent)localObject).setClassName(paramOpenIMKefuStartConversationRequest.context, "com.tencent.mm.openim.ui.OpenIMKefuConfirmUI");
      if (!(paramOpenIMKefuStartConversationRequest.context instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramOpenIMKefuStartConversationRequest = paramOpenIMKefuStartConversationRequest.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramOpenIMKefuStartConversationRequest, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/openim/model/OpenIMKefuStartConversationService", "startConversation", "(Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramOpenIMKefuStartConversationRequest.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramOpenIMKefuStartConversationRequest, "com/tencent/mm/openim/model/OpenIMKefuStartConversationService", "startConversation", "(Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(235846);
      return;
    }
  }
  
  public final void b(OpenIMKefuStartConversationRequest paramOpenIMKefuStartConversationRequest)
  {
    AppMethodBeat.i(235853);
    s.u(paramOpenIMKefuStartConversationRequest, "request");
    Object localObject = paramOpenIMKefuStartConversationRequest.pry;
    if (localObject == null)
    {
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label67;
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label72;
      }
      Log.e("MicroMsg.OpenIMKefuStartConversationService", "startConversationDirectly username invalid");
      AppMethodBeat.o(235853);
      return;
      localObject = ((du)localObject).username;
      break;
    }
    label72:
    d(paramOpenIMKefuStartConversationRequest);
    Intent localIntent = paramOpenIMKefuStartConversationRequest.prF;
    if (localIntent == null) {
      localIntent = new Intent();
    }
    for (;;)
    {
      a(localIntent, paramOpenIMKefuStartConversationRequest);
      if (!paramOpenIMKefuStartConversationRequest.prB) {
        break;
      }
      localIntent.setClassName(paramOpenIMKefuStartConversationRequest.context, "com.tencent.mm.ui.conversation.OpenImKefuServiceConversationUI");
      localIntent.putExtra("Contact_User", "opencustomerservicemsg");
      if (paramOpenIMKefuStartConversationRequest.prD) {
        localIntent.putExtra("key_back_to_launcher_ui_when_finish", true);
      }
      if (!(paramOpenIMKefuStartConversationRequest.context instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramOpenIMKefuStartConversationRequest = paramOpenIMKefuStartConversationRequest.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramOpenIMKefuStartConversationRequest, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/openim/model/OpenIMKefuStartConversationService", "startConversationWithoutConfirm", "(Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramOpenIMKefuStartConversationRequest.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramOpenIMKefuStartConversationRequest, "com/tencent/mm/openim/model/OpenIMKefuStartConversationService", "startConversationWithoutConfirm", "(Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(235853);
      return;
    }
    localIntent.putExtra("finish_direct", true);
    localObject = paramOpenIMKefuStartConversationRequest.pry;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localIntent.putExtra("Chat_User", (String)localObject);
      localIntent.setClassName(paramOpenIMKefuStartConversationRequest.context, "com.tencent.mm.ui.conversation.OpenImKefuServiceChattingUI");
      break;
      String str = ((du)localObject).username;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.aa
 * JD-Core Version:    0.7.0.1
 */