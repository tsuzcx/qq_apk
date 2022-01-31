package com.tencent.mm.plugin.appbrand.j;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class d$1
  extends a
{
  d$1(d paramd, String paramString1, String paramString2, String paramString3, String paramString4, WeakReference paramWeakReference, int paramInt1, long paramLong, String paramString5, int paramInt2) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(132275);
    ab.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { this.cbK, this.efI, this.val$path, this.irs });
    this.irx.get();
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", this.fwD);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(this.fEP));
    ((Bundle)localObject).putString("stat_chat_talker_username", this.irs);
    ((Bundle)localObject).putString("stat_send_msg_user", this.irt);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1088;
    localAppBrandStatObject.cmF = "";
    localAppBrandStatObject.cJb = i.j(localAppBrandStatObject.scene, (Bundle)localObject);
    localAppBrandStatObject.cJc = i.k(localAppBrandStatObject.scene, (Bundle)localObject);
    String str = "";
    localObject = str;
    if (this.val$path != null)
    {
      localObject = str;
      if (this.val$path.length() > 0)
      {
        byte[] arrayOfByte = Base64.decode(this.val$path, 2);
        localObject = str;
        if (arrayOfByte != null) {
          localObject = new String(arrayOfByte);
        }
      }
    }
    ((j)g.E(j.class)).a(paramView.getContext(), this.efI, null, this.bHS, 0, (String)localObject, localAppBrandStatObject);
    AppMethodBeat.o(132275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d.1
 * JD-Core Version:    0.7.0.1
 */