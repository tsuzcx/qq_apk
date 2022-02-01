package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  static void a(cv paramcv, bj.b paramb, am paramam)
  {
    AppMethodBeat.i(22334);
    String str1 = z.a(paramcv.Fvi);
    ba.aBQ();
    c.ajl().set(73729, Integer.valueOf(1));
    String str2 = paramam.field_nickname;
    br localbr = new br();
    localbr.field_content = z.a(paramcv.Fvk);
    localbr.field_createtime = bt.aQJ();
    localbr.field_imgpath = "";
    if (paramcv.ugm == 3)
    {
      paramam = aj.getContext().getString(2131761528);
      localbr.field_sayhicontent = paramam;
      localbr.field_sayhiuser = str1;
      localbr.field_scene = 18;
      if (paramcv.nDG <= 3) {
        break label228;
      }
    }
    label228:
    for (int i = paramcv.nDG;; i = 3)
    {
      localbr.field_status = i;
      localbr.field_svrid = paramcv.xbt;
      localbr.field_talker = str2;
      localbr.field_type = paramcv.ugm;
      localbr.field_isSend = 0;
      localbr.field_sayhiencryptuser = str1;
      localbr.field_ticket = paramb.hGU;
      d.aMp().a(localbr);
      paramcv = new lb();
      paramcv.dyl.dym = str1;
      com.tencent.mm.sdk.b.a.IbL.l(paramcv);
      AppMethodBeat.o(22334);
      return;
      paramam = z.a(paramcv.Fvk);
      break;
    }
  }
  
  public final void a(final e.a parama, bu parambu, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.gqE;
    paramString2 = bj.Bq(parama.Fvn);
    if (paramString2 != null)
    {
      parambu.tW(paramString2.hGQ);
      parambu.kH(paramString2.hGR);
      parambu.tR(paramString2.hGP);
      ad.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.hGP });
      if ((paramString2.hGU != null) && (paramString2.scene == 1) && (parama.ugm != 10000))
      {
        ba.aBQ();
        parambu = c.azp().Bf(paramString1);
        if ((parambu == null) || ((int)parambu.gfj <= 0))
        {
          as.a.hFO.a(paramString1, null, new as.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              ba.aBQ();
              paramAnonymousString = c.azp().Bf(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, parambu);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(e.a parama, bu parambu, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */