package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  static void a(cs paramcs, bi.b paramb, af paramaf)
  {
    AppMethodBeat.i(22334);
    String str1 = z.a(paramcs.Cxx);
    az.arV();
    c.afk().set(73729, Integer.valueOf(1));
    String str2 = paramaf.field_nickname;
    com.tencent.mm.storage.bi localbi = new com.tencent.mm.storage.bi();
    localbi.field_content = z.a(paramcs.Cxz);
    localbi.field_createtime = bt.aGK();
    localbi.field_imgpath = "";
    if (paramcs.saz == 3)
    {
      paramaf = aj.getContext().getString(2131761528);
      localbi.field_sayhicontent = paramaf;
      localbi.field_sayhiuser = str1;
      localbi.field_scene = 18;
      if (paramcs.mBi <= 3) {
        break label228;
      }
    }
    label228:
    for (int i = paramcs.mBi;; i = 3)
    {
      localbi.field_status = i;
      localbi.field_svrid = paramcs.uKZ;
      localbi.field_talker = str2;
      localbi.field_type = paramcs.saz;
      localbi.field_isSend = 0;
      localbi.field_sayhiencryptuser = str1;
      localbi.field_ticket = paramb.gOc;
      d.aCp().a(localbi);
      paramcs = new kk();
      paramcs.doP.doQ = str1;
      com.tencent.mm.sdk.b.a.ESL.l(paramcs);
      AppMethodBeat.o(22334);
      return;
      paramaf = z.a(paramcs.Cxz);
      break;
    }
  }
  
  public final void a(final f.a parama, bl parambl, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.fTo;
    paramString2 = com.tencent.mm.model.bi.ul(parama.CxC);
    if (paramString2 != null)
    {
      parambl.oe(paramString2.gNY);
      parambl.kn(paramString2.gNZ);
      parambl.oc(paramString2.gNX);
      ad.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.gNX });
      if ((paramString2.gOc != null) && (paramString2.scene == 1) && (parama.saz != 10000))
      {
        az.arV();
        parambl = c.apM().aHY(paramString1);
        if ((parambl == null) || ((int)parambl.fId <= 0))
        {
          ar.a.gMW.a(paramString1, null, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              az.arV();
              paramAnonymousString = c.apM().aHY(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, parambl);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(f.a parama, bl parambl, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */