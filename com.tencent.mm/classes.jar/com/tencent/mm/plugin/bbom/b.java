package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.as.o;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.a.iy;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Stack;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  static void a(cd paramcd, bd.b paramb, ad paramad)
  {
    String str1 = aa.a(paramcd.svF);
    au.Hx();
    com.tencent.mm.model.c.Dz().o(73729, Integer.valueOf(1));
    String str2 = paramad.field_nickname;
    bf localbf = new bf();
    localbf.field_content = aa.a(paramcd.svH);
    localbf.field_createtime = bk.UX();
    localbf.field_imgpath = "";
    if (paramcd.kSW == 3)
    {
      paramad = ae.getContext().getString(R.l.nearby_say_hi_type_image);
      localbf.field_sayhicontent = paramad;
      localbf.field_sayhiuser = str1;
      localbf.field_scene = 18;
      if (paramcd.hQq <= 3) {
        break label217;
      }
    }
    label217:
    for (int i = paramcd.hQq;; i = 3)
    {
      localbf.field_status = i;
      localbf.field_svrid = paramcd.ndp;
      localbf.field_talker = str2;
      localbf.field_type = paramcd.kSW;
      localbf.field_isSend = 0;
      localbf.field_sayhiencryptuser = str1;
      localbf.field_ticket = paramb.dWD;
      d.RZ().a(localbf);
      paramcd = new iy();
      paramcd.bRi.bRj = str1;
      com.tencent.mm.sdk.b.a.udP.m(paramcd);
      return;
      paramad = aa.a(paramcd.svH);
      break;
    }
  }
  
  public final void a(final e.a parama, bi parambi, final String paramString1, final String paramString2, boolean paramBoolean)
  {
    parama = parama.dBs;
    paramString2 = com.tencent.mm.model.bd.iM(parama.svK);
    if (paramString2 != null)
    {
      parambi.ei(paramString2.dWA);
      parambi.eg(paramString2.dWz);
      y.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", new Object[] { paramString2.dWz });
      if ((paramString2.dWD != null) && (paramString2.scene == 1) && (parama.kSW != 10000))
      {
        au.Hx();
        parambi = com.tencent.mm.model.c.Fw().abl(paramString1);
        if ((parambi != null) && ((int)parambi.dBe > 0)) {
          break label132;
        }
        am.a.dVy.a(paramString1, null, new am.b.a()
        {
          public final void m(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            au.Hx();
            paramAnonymousString = com.tencent.mm.model.c.Fw().abl(paramString1);
            b.a(parama, paramString2, paramAnonymousString);
          }
        });
      }
    }
    return;
    label132:
    a(parama, paramString2, parambi);
  }
  
  public final void b(e.a parama, bi arg2, String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if ((s.hk(paramString1)) && (s.hZ(paramString1))) {
      i = 1;
    }
    for (;;)
    {
      long l;
      if ((s.fn(paramString1)) && (!s.hY(paramString1))) {
        if ((!paramBoolean) && (???.ctB()) && (i == 0) && (j == 0))
        {
          com.tencent.mm.modelcontrol.c.Ni();
          if (com.tencent.mm.modelcontrol.c.o(???))
          {
            parama = o.OL();
            l = ???.field_msgId;
            com.tencent.mm.modelcontrol.c.Ni();
            if (!com.tencent.mm.modelcontrol.c.Nj()) {}
          }
        }
      }
      synchronized (parama.emL)
      {
        if (parama.emL.size() >= 100) {
          parama.emL.remove(0);
        }
        parama.emL.push(Long.valueOf(l));
        parama.emP = System.currentTimeMillis();
        parama.start();
        return;
        i = 0;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.b
 * JD-Core Version:    0.7.0.1
 */