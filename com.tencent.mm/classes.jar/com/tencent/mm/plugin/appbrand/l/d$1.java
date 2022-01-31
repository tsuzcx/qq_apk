package com.tencent.mm.plugin.appbrand.l;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class d$1
  extends a
{
  d$1(d paramd, String paramString1, String paramString2, String paramString3, String paramString4, WeakReference paramWeakReference, int paramInt1, long paramLong, String paramString5, int paramInt2) {}
  
  public final void onClickImp(View paramView)
  {
    y.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[] { this.dYK, this.dol, this.dlh, this.gPG });
    this.gPK.get();
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", this.egz);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(this.eos));
    ((Bundle)localObject).putString("stat_chat_talker_username", this.gPG);
    ((Bundle)localObject).putString("stat_send_msg_user", this.gPH);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1088;
    localAppBrandStatObject.bFv = "";
    localAppBrandStatObject.caB = f.g(localAppBrandStatObject.scene, (Bundle)localObject);
    localAppBrandStatObject.caC = f.h(localAppBrandStatObject.scene, (Bundle)localObject);
    String str = "";
    localObject = str;
    if (this.dlh != null)
    {
      localObject = str;
      if (this.dlh.length() > 0)
      {
        byte[] arrayOfByte = Base64.decode(this.dlh, 2);
        localObject = str;
        if (arrayOfByte != null) {
          localObject = new String(arrayOfByte);
        }
      }
    }
    ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(paramView.getContext(), this.dol, null, this.bns, 0, (String)localObject, localAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.d.1
 * JD-Core Version:    0.7.0.1
 */