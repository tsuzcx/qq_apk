package com.tencent.mm.model;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import com.tencent.mm.storage.be;

final class au$4
  implements bd.a
{
  au$4(au paramau) {}
  
  public final void a(bd parambd, ad paramad)
  {
    String str = paramad.field_username;
    if (ad.hd(paramad.field_username)) {
      paramad.setUsername(ad.aaZ(paramad.field_username));
    }
    if (bk.bl(paramad.vn())) {
      paramad.dl(g.oZ(paramad.field_nickname));
    }
    if (bk.bl(paramad.vo())) {
      paramad.dm(g.oY(paramad.field_nickname));
    }
    if (bk.bl(paramad.field_conRemarkPYShort)) {
      paramad.dp(g.oZ(paramad.field_conRemark));
    }
    if (bk.bl(paramad.field_conRemarkPYFull)) {
      paramad.jdMethod_do(g.oY(paramad.field_conRemark));
    }
    if (s.e(paramad))
    {
      paramad.fg(43);
      paramad.dl(g.oZ(paramad.Bp()));
      paramad.dm(g.oY(paramad.Bp()));
      paramad.jdMethod_do(g.oY(paramad.Bq()));
      paramad.dp(paramad.Bq());
      return;
    }
    if (s.hU(str))
    {
      paramad.AH();
      paramad.fl(4);
      paramad.fg(33);
      if (paramad != null) {
        break label318;
      }
    }
    label318:
    for (parambd = new ad();; parambd = paramad)
    {
      parambd.setUsername(str);
      parambd.AH();
      aa.y(parambd);
      parambd.AQ();
      if (paramad.Bi()) {
        paramad.fg(paramad.AE());
      }
      if (s.hK(str))
      {
        y.i("MicroMsg.MMCore", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
        paramad.fg(31);
      }
      if (paramad.Bg())
      {
        au.Hx();
        c.FB().d(new String[] { str }, "@blacklist");
      }
      y.d("MicroMsg.MMCore", "onPreInsertContact2: %s, %s", new Object[] { paramad.field_username, paramad.vn() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.au.4
 * JD-Core Version:    0.7.0.1
 */