package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.f.a;
import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.dus;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$3$1$1$provider$1", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "luggage-wechat-full-sdk_release"})
public final class m$c$1$a
  implements a
{
  m$c$1$a(m.c.1 param1) {}
  
  public final String Fr()
  {
    AppMethodBeat.i(169609);
    Object localObject = this.kCW.kCV.Hfj;
    if (localObject != null)
    {
      localObject = ((dur)localObject).HqQ;
      if (localObject != null)
      {
        localObject = (dus)((LinkedList)localObject).peekFirst();
        if (localObject != null)
        {
          localObject = ((dus)localObject).nickname;
          AppMethodBeat.o(169609);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(169609);
    return null;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(169608);
    p.h(paramb, "callback");
    Object localObject = this.kCW.kCV.Hfj;
    if (localObject != null)
    {
      localObject = ((dur)localObject).HqQ;
      if (localObject != null)
      {
        localObject = (dus)((LinkedList)localObject).peekFirst();
        if (localObject != null)
        {
          localObject = ((dus)localObject).kDl;
          CharSequence localCharSequence = (CharSequence)localObject;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label110;
          }
        }
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label115;
      }
      b.aEl().a((b.k)new b.k()
      {
        public final String BN()
        {
          return "JsApiOperateWXData";
        }
        
        public final void F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(169607);
          a.b localb = this.jGJ;
          if (localb != null)
          {
            localb.o(paramAnonymousBitmap);
            AppMethodBeat.o(169607);
            return;
          }
          AppMethodBeat.o(169607);
        }
        
        public final void aEt() {}
        
        public final void ox() {}
      }, (String)localObject, null);
      AppMethodBeat.o(169608);
      return;
      localObject = null;
      break;
    }
    label115:
    paramb.o(null);
    AppMethodBeat.o(169608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.m.c.1.a
 * JD-Core Version:    0.7.0.1
 */