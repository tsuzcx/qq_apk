package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class JsApiChooseWeChatContact$1
  implements MMActivity.a
{
  JsApiChooseWeChatContact$1(JsApiChooseWeChatContact paramJsApiChooseWeChatContact, r paramr, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130991);
    if (100 != paramInt1)
    {
      ab.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      this.bAW.h(this.bAX, this.hKs.j("fail", null));
      AppMethodBeat.o(130991);
      return;
    }
    if ((paramInt2 == 0) || (paramInt2 == 1))
    {
      ab.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      this.bAW.h(this.bAX, this.hKs.j("cancel", null));
      AppMethodBeat.o(130991);
      return;
    }
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {}
      for (paramIntent = null; (paramIntent == null) || (paramIntent.length() == 0); paramIntent = paramIntent.getStringExtra("Select_Conv_User"))
      {
        ab.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
        this.bAW.h(this.bAX, this.hKs.j("fail", null));
        AppMethodBeat.o(130991);
        return;
      }
      Object localObject = new JsApiChooseWeChatContact.GetUserDataTask(paramIntent);
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      String str1 = ((JsApiChooseWeChatContact.GetUserDataTask)localObject).blZ;
      String str2 = ((JsApiChooseWeChatContact.GetUserDataTask)localObject).bma;
      localObject = ((JsApiChooseWeChatContact.GetUserDataTask)localObject).gGm;
      HashMap localHashMap = new HashMap();
      localHashMap.put("avatarUrl", localObject);
      localHashMap.put("userName", paramIntent);
      localHashMap.put("nickName", str1);
      localHashMap.put("remarkName", str2);
      ab.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", new Object[] { str1, str2 });
      this.bAW.h(this.bAX, this.hKs.j("ok", localHashMap));
    }
    AppMethodBeat.o(130991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.1
 * JD-Core Version:    0.7.0.1
 */