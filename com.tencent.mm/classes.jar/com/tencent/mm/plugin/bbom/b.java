package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bv;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  static void a(cv paramcv, bl.b paramb, an paraman)
  {
    AppMethodBeat.i(22334);
    String str1 = z.a(paramcv.FNG);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(73729, Integer.valueOf(1));
    String str2 = paraman.field_nickname;
    bs localbs = new bs();
    localbs.field_content = z.a(paramcv.FNI);
    localbs.field_createtime = bu.aRi();
    localbs.field_imgpath = "";
    if (paramcv.urJ == 3)
    {
      paraman = ak.getContext().getString(2131761528);
      localbs.field_sayhicontent = paraman;
      localbs.field_sayhiuser = str1;
      localbs.field_scene = 18;
      if (paramcv.nJb <= 3) {
        break label228;
      }
    }
    label228:
    for (int i = paramcv.nJb;; i = 3)
    {
      localbs.field_status = i;
      localbs.field_svrid = paramcv.xrk;
      localbs.field_talker = str2;
      localbs.field_type = paramcv.urJ;
      localbs.field_isSend = 0;
      localbs.field_sayhiencryptuser = str1;
      localbs.field_ticket = paramb.hJM;
      d.aMN().a(localbs);
      paramcv = new lc();
      paramcv.dzq.dzr = str1;
      com.tencent.mm.sdk.b.a.IvT.l(paramcv);
      AppMethodBeat.o(22334);
      return;
      paraman = z.a(paramcv.FNI);
      break;
    }
  }
  
  public final void a(final e.a parama, bv parambv, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.gte;
    paramString2 = bl.BS(parama.FNL);
    if (paramString2 != null)
    {
      parambv.ur(paramString2.hJI);
      parambv.kJ(paramString2.hJJ);
      parambv.um(paramString2.hJH);
      ae.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.hJH });
      if ((paramString2.hJM != null) && (paramString2.scene == 1) && (parama.urJ != 10000))
      {
        bc.aCg();
        parambv = com.tencent.mm.model.c.azF().BH(paramString1);
        if ((parambv == null) || ((int)parambv.ght <= 0))
        {
          au.a.hIG.a(paramString1, null, new au.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              bc.aCg();
              paramAnonymousString = com.tencent.mm.model.c.azF().BH(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, parambv);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(e.a parama, bv parambv, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */