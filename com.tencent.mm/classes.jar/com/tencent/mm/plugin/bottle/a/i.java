package com.tencent.mm.plugin.bottle.a;

import android.database.Cursor;
import com.tencent.mm.ay.e;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.bi;
import java.util.HashMap;

public final class i
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private be.a dVR = new i.2(this);
  private b hYu;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new i.1());
  }
  
  private static i awM()
  {
    au.Hq();
    i locali2 = (i)bu.iR("plugin.bottle");
    i locali1 = locali2;
    if (locali2 == null)
    {
      locali1 = new i();
      au.Hq().a("plugin.bottle", locali1);
    }
    return locali1;
  }
  
  public static b awN()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (awM().hYu == null)
    {
      i locali = awM();
      au.Hx();
      locali.hYu = new b(com.tencent.mm.model.c.Dv());
    }
    return awM().hYu;
  }
  
  public static void awO()
  {
    au.Hx();
    Cursor localCursor = com.tencent.mm.model.c.FB().cuJ();
    int i = 0;
    while (i < localCursor.getCount())
    {
      localCursor.moveToPosition(i);
      ak localak = new ak();
      localak.d(localCursor);
      au.Hx();
      bi localbi = com.tencent.mm.model.c.Fy().Hz(localak.field_username);
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.c(localak.field_username, localbi.field_msgSvrId));
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new e(localak.field_username, 0));
      au.Hx();
      com.tencent.mm.model.c.Fw().abr(localak.field_username);
      i += 1;
    }
    localCursor.close();
    au.Hx();
    com.tencent.mm.model.c.Fy().HH("@bottle");
    au.Hx();
    com.tencent.mm.model.c.FB().cuD();
    au.Hx();
    com.tencent.mm.model.c.FB().HH("floatbottle");
    com.tencent.mm.model.bd.HN();
    awN().dXo.delete("bottleinfo1", null, null);
  }
  
  public final void bh(boolean paramBoolean)
  {
    c.awI();
    au.Hx();
    com.tencent.mm.model.c.FB().c(this.dVR);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    au.Hx();
    com.tencent.mm.model.c.FB().d(this.dVR);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.i
 * JD-Core Version:    0.7.0.1
 */