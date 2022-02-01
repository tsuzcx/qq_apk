package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  static void a(cu paramcu, bi.b paramb, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(22334);
    String str1 = z.a(paramcu.DPT);
    az.ayM();
    c.agA().set(73729, Integer.valueOf(1));
    String str2 = paramai.field_nickname;
    bl localbl = new bl();
    localbl.field_content = z.a(paramcu.DPV);
    localbl.field_createtime = bs.aNx();
    localbl.field_imgpath = "";
    if (paramcu.tit == 3)
    {
      paramai = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761528);
      localbl.field_sayhicontent = paramai;
      localbl.field_sayhiuser = str1;
      localbl.field_scene = 18;
      if (paramcu.ndj <= 3) {
        break label228;
      }
    }
    label228:
    for (int i = paramcu.ndj;; i = 3)
    {
      localbl.field_status = i;
      localbl.field_svrid = paramcu.vTQ;
      localbl.field_talker = str2;
      localbl.field_type = paramcu.tit;
      localbl.field_isSend = 0;
      localbl.field_sayhiencryptuser = str1;
      localbl.field_ticket = paramb.hoC;
      d.aJf().a(localbl);
      paramcu = new ks();
      paramcu.dmx.dmy = str1;
      com.tencent.mm.sdk.b.a.GpY.l(paramcu);
      AppMethodBeat.o(22334);
      return;
      paramai = z.a(paramcu.DPV);
      break;
    }
  }
  
  public final void a(final f.a parama, bo parambo, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.fXi;
    paramString2 = bi.yr(parama.DPY);
    if (paramString2 != null)
    {
      parambo.rk(paramString2.hoy);
      parambo.kk(paramString2.hoz);
      parambo.ri(paramString2.hox);
      ac.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.hox });
      if ((paramString2.hoC != null) && (paramString2.scene == 1) && (parama.tit != 10000))
      {
        az.ayM();
        parambo = c.awB().aNt(paramString1);
        if ((parambo == null) || ((int)parambo.fLJ <= 0))
        {
          ar.a.hnw.a(paramString1, null, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              az.ayM();
              paramAnonymousString = c.awB().aNt(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, parambo);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(f.a parama, bo parambo, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */