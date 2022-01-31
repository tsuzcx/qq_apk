package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.at.o;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Stack;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  static void a(cm paramcm, bf.b paramb, ad paramad)
  {
    AppMethodBeat.i(18234);
    String str1 = aa.a(paramcm.woP);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(73729, Integer.valueOf(1));
    String str2 = paramad.field_nickname;
    com.tencent.mm.storage.bf localbf = new com.tencent.mm.storage.bf();
    localbf.field_content = aa.a(paramcm.woR);
    localbf.field_createtime = bo.aox();
    localbf.field_imgpath = "";
    if (paramcm.nqW == 3)
    {
      paramad = ah.getContext().getString(2131301781);
      localbf.field_sayhicontent = paramad;
      localbf.field_sayhiuser = str1;
      localbf.field_scene = 18;
      if (paramcm.jJS <= 3) {
        break label228;
      }
    }
    label228:
    for (int i = paramcm.jJS;; i = 3)
    {
      localbf.field_status = i;
      localbf.field_svrid = paramcm.pIG;
      localbf.field_talker = str2;
      localbf.field_type = paramcm.nqW;
      localbf.field_isSend = 0;
      localbf.field_sayhiencryptuser = str1;
      localbf.field_ticket = paramb.fmL;
      d.alj().a(localbf);
      paramcm = new jh();
      paramcm.cyK.cyL = str1;
      com.tencent.mm.sdk.b.a.ymk.l(paramcm);
      AppMethodBeat.o(18234);
      return;
      paramad = aa.a(paramcm.woR);
      break;
    }
  }
  
  public final void a(final e.a parama, bi parambi, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(18232);
    parama = parama.eyJ;
    paramString2 = com.tencent.mm.model.bf.pA(parama.woU);
    if (paramString2 != null)
    {
      parambi.kp(paramString2.fmI);
      parambi.kn(paramString2.fmH);
      ab.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.fmH });
      if ((paramString2.fmL != null) && (paramString2.scene == 1) && (parama.nqW != 10000))
      {
        aw.aaz();
        parambi = com.tencent.mm.model.c.YA().arw(paramString1);
        if ((parambi == null) || ((int)parambi.euF <= 0))
        {
          ao.a.flI.a(paramString1, null, new ao.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(18231);
              aw.aaz();
              paramAnonymousString = com.tencent.mm.model.c.YA().arw(paramString1);
              b.a(parama, paramString2, paramAnonymousString);
              AppMethodBeat.o(18231);
            }
          });
          AppMethodBeat.o(18232);
          return;
        }
        a(parama, paramString2, parambi);
      }
    }
    AppMethodBeat.o(18232);
  }
  
  public final void b(e.a parama, bi arg2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(18233);
    int i;
    if (com.tencent.mm.plugin.priority.a.a.a.caL())
    {
      if ((!t.nT(paramString1)) || (!t.oI(paramString1))) {
        break label181;
      }
      i = 1;
    }
    for (;;)
    {
      int j;
      long l;
      if ((t.lA(paramString1)) && (!t.oH(paramString1)))
      {
        j = 1;
        if ((!paramBoolean) && (???.dvX()) && (i == 0) && (j == 0))
        {
          com.tencent.mm.modelcontrol.c.afT();
          if (com.tencent.mm.modelcontrol.c.u(???))
          {
            parama = o.ahE();
            l = ???.field_msgId;
            com.tencent.mm.modelcontrol.c.afT();
            if (!com.tencent.mm.modelcontrol.c.afU()) {}
          }
        }
      }
      synchronized (parama.fDi)
      {
        if (parama.fDi.size() >= 100) {
          parama.fDi.remove(0);
        }
        parama.fDi.push(Long.valueOf(l));
        parama.fDm = System.currentTimeMillis();
        ab.i("MicroMsg.AutoGetBigImgLogic", "add %d", new Object[] { Long.valueOf(l) });
        parama.start();
        AppMethodBeat.o(18233);
        return;
        label181:
        i = 0;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */