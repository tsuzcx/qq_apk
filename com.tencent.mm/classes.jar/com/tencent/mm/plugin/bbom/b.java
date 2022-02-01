package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.c
{
  static void a(dl paramdl, br.b paramb, au paramau)
  {
    AppMethodBeat.i(22334);
    String str1 = w.a(paramdl.YFE);
    bh.bCz();
    com.tencent.mm.model.c.ban().B(73729, Integer.valueOf(1));
    String str2 = paramau.field_nickname;
    bz localbz = new bz();
    localbz.field_content = w.a(paramdl.YFG);
    localbz.field_createtime = Util.nowSecond();
    localbz.field_imgpath = "";
    if (paramdl.IIs == 3)
    {
      paramau = MMApplicationContext.getContext().getString(R.l.gOv);
      localbz.field_sayhicontent = paramau;
      localbz.field_sayhiuser = str1;
      localbz.field_scene = 18;
      if (paramdl.vhk <= 3) {
        break label226;
      }
    }
    label226:
    for (int i = paramdl.vhk;; i = 3)
    {
      localbz.field_status = i;
      localbz.field_svrid = paramdl.Njv;
      localbz.field_talker = str2;
      localbz.field_type = paramdl.IIs;
      localbz.field_isSend = 0;
      localbz.field_sayhiencryptuser = str1;
      localbz.field_ticket = paramb.olW;
      com.tencent.mm.modelverify.d.bNJ().a(localbz);
      paramdl = new np();
      paramdl.hPZ.hQa = str1;
      paramdl.publish();
      AppMethodBeat.o(22334);
      return;
      paramau = w.a(paramdl.YFG);
      break;
    }
  }
  
  public final void a(final g.a parama, cc paramcc, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(22333);
    parama = parama.mpN;
    paramString2 = br.JP(parama.YFJ);
    if (paramString2 != null)
    {
      paramcc.Cb(paramString2.olS);
      paramcc.qb(paramString2.olT);
      paramcc.BW(paramString2.olR);
      Log.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.olR });
      if ((paramString2.olW != null) && (paramString2.scene == 1) && (parama.IIs != 10000))
      {
        bh.bCz();
        paramcc = com.tencent.mm.model.c.bzA().JE(paramString1);
        if ((paramcc == null) || ((int)paramcc.maN <= 0))
        {
          az.a.okP.a(paramString1, null, new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(22332);
              bh.bCz();
              paramAnonymousString = com.tencent.mm.model.c.bzA().JE(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(22332);
            }
          });
          AppMethodBeat.o(22333);
          return;
        }
        a(parama, paramString2, paramcc);
      }
    }
    AppMethodBeat.o(22333);
  }
  
  public final void b(g.a parama, cc paramcc, String paramString1, String paramString2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */