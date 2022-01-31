package com.tencent.mm.plugin.appbrand.j;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  a$1(a parama, com.tencent.mm.af.a.a parama1, String paramString1, int paramInt, long paramLong, String paramString2) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(132265);
    ab.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { this.irq.content, this.irq.username, this.irq.path, this.irs });
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", this.fwD);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(this.fEP));
    ((Bundle)localObject).putString("stat_chat_talker_username", this.irs);
    ((Bundle)localObject).putString("stat_send_msg_user", this.irt);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1088;
    localAppBrandStatObject.cmF = "";
    localAppBrandStatObject.cJb = com.tencent.mm.plugin.appbrand.report.i.j(localAppBrandStatObject.scene, (Bundle)localObject);
    localAppBrandStatObject.cJc = com.tencent.mm.plugin.appbrand.report.i.k(localAppBrandStatObject.scene, (Bundle)localObject);
    String str = "";
    localObject = str;
    if (this.irq.path != null)
    {
      localObject = str;
      if (this.irq.path.length() > 0)
      {
        byte[] arrayOfByte = Base64.decode(this.irq.path, 2);
        localObject = str;
        if (arrayOfByte != null) {
          localObject = new String(arrayOfByte);
        }
      }
    }
    ((j)g.E(j.class)).a(paramView.getContext(), this.irq.username, null, this.irq.type, 0, (String)localObject, localAppBrandStatObject);
    ((com.tencent.mm.plugin.appbrand.service.i)g.E(com.tencent.mm.plugin.appbrand.service.i.class)).a(this.irq.username, new a.1.1(this));
    AppMethodBeat.o(132265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a.1
 * JD-Core Version:    0.7.0.1
 */