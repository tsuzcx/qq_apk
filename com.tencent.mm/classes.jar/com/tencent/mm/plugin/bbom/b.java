package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;

public final class b
  implements a
{
  static void a(de paramde, bp.b paramb, as paramas)
  {
    AppMethodBeat.i(22334);
    String str1 = z.a(paramde.KHl);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(73729, Integer.valueOf(1));
    String str2 = paramas.field_nickname;
    bx localbx = new bx();
    localbx.field_content = z.a(paramde.KHn);
    localbx.field_createtime = Util.nowSecond();
    localbx.field_imgpath = "";
    if (paramde.xKb == 3)
    {
      paramas = MMApplicationContext.getContext().getString(2131763489);
      localbx.field_sayhicontent = paramas;
      localbx.field_sayhiuser = str1;
      localbx.field_scene = 18;
      if (paramde.oTW <= 3) {
        break label228;
      }
    }
    label228:
    for (int i = paramde.oTW;; i = 3)
    {
      localbx.field_status = i;
      localbx.field_svrid = paramde.Brn;
      localbx.field_talker = str2;
      localbx.field_type = paramde.xKb;
      localbx.field_isSend = 0;
      localbx.field_sayhiencryptuser = str1;
      localbx.field_ticket = paramb.iEw;
      d.bgO().a(localbx);
      paramde = new ls();
      paramde.dRd.dRe = str1;
      EventCenter.instance.publish(paramde);
      AppMethodBeat.o(22334);
      return;
      paramas = z.a(paramde.KHn);
      break;
    }
  }
  
  public final void a(final h.a parama, ca paramca, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.heO;
    paramString2 = bp.Ky(parama.KHq);
    if (paramString2 != null)
    {
      paramca.CH(paramString2.iEs);
      paramca.nM(paramString2.iEt);
      paramca.CC(paramString2.iEr);
      Log.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.iEr });
      if ((paramString2.iEw != null) && (paramString2.scene == 1) && (parama.xKb != 10000))
      {
        bg.aVF();
        paramca = com.tencent.mm.model.c.aSN().Kn(paramString1);
        if ((paramca == null) || ((int)paramca.gMZ <= 0))
        {
          ay.a.iDq.a(paramString1, null, new ay.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              bg.aVF();
              paramAnonymousString = com.tencent.mm.model.c.aSN().Kn(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, paramca);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(h.a parama, ca paramca, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */