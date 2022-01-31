package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class JsApiChooseWeChatContact$1
  implements MMActivity.a
{
  JsApiChooseWeChatContact$1(JsApiChooseWeChatContact paramJsApiChooseWeChatContact, o paramo, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (100 != paramInt1)
    {
      y.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      this.gcp.C(this.dIS, this.gpJ.h("fail", null));
    }
    do
    {
      return;
      if ((paramInt2 == 0) || (paramInt2 == 1))
      {
        y.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        this.gcp.C(this.dIS, this.gpJ.h("cancel", null));
        return;
      }
    } while (paramInt2 != -1);
    if (paramIntent == null) {}
    for (paramIntent = null; (paramIntent == null) || (paramIntent.length() == 0); paramIntent = paramIntent.getStringExtra("Select_Conv_User"))
    {
      y.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
      this.gcp.C(this.dIS, this.gpJ.h("fail", null));
      return;
    }
    Object localObject = new JsApiChooseWeChatContact.GetUserDataTask(paramIntent);
    AppBrandMainProcessService.b((MainProcessTask)localObject);
    String str1 = ((JsApiChooseWeChatContact.GetUserDataTask)localObject).aVr;
    String str2 = ((JsApiChooseWeChatContact.GetUserDataTask)localObject).aVs;
    localObject = ((JsApiChooseWeChatContact.GetUserDataTask)localObject).foS;
    HashMap localHashMap = new HashMap();
    localHashMap.put("avatarUrl", localObject);
    localHashMap.put("userName", paramIntent);
    localHashMap.put("nickName", str1);
    localHashMap.put("remarkName", str2);
    y.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", new Object[] { str1, str2 });
    this.gcp.C(this.dIS, this.gpJ.h("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.1
 * JD-Core Version:    0.7.0.1
 */