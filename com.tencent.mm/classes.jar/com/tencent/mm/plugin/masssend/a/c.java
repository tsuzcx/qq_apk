package com.tencent.mm.plugin.masssend.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  private LinkedList<d> maL;
  
  private static String bha()
  {
    if (au.DK())
    {
      au.Hx();
      String str = String.format("%s/masssend_%s.ini", new Object[] { com.tencent.mm.model.c.FT(), x.cqJ() });
      y.d("MicroMsg.MassSendService", "config file path is %s", new Object[] { str });
      return str;
    }
    return "";
  }
  
  private boolean bhb()
  {
    byte[] arrayOfByte;
    if (this.maL == null)
    {
      localObject = bha();
      arrayOfByte = com.tencent.mm.vfs.e.c((String)localObject, 0, -1);
      if (arrayOfByte == null) {
        return false;
      }
    }
    try
    {
      this.maL = ((e)new e().aH(arrayOfByte)).maM;
      if (this.maL == null)
      {
        y.w("MicroMsg.MassSendService", "info list is empty");
        return false;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.vfs.e.deleteFile((String)localObject);
      return false;
    }
    y.i("MicroMsg.MassSendService", "info list[%s]", new Object[] { this.maL.toString() });
    long l = bk.UX();
    Object localObject = this.maL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((locald.bud <= l) && (l <= locald.end)) {
        return true;
      }
    }
    return false;
  }
  
  public static void fc(long paramLong)
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().o(102409, Long.valueOf(paramLong));
  }
  
  public final void GT(String paramString)
  {
    if (bk.bl(paramString)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = bn.s(paramString, "Festivals");
    } while (localObject1 == null);
    e locale = new e();
    int i = 0;
    Object localObject2 = new StringBuilder(".Festivals.Festival");
    if (i == 0) {}
    for (paramString = "";; paramString = String.valueOf(i))
    {
      paramString = paramString;
      if (!((Map)localObject1).containsKey(paramString)) {
        break label181;
      }
      localObject2 = new d();
      ((d)localObject2).bud = bk.ZI((String)((Map)localObject1).get(paramString + ".StartTime"));
      ((d)localObject2).end = (bk.ZI((String)((Map)localObject1).get(paramString + ".EndTime")) + 86400000);
      locale.maM.add(localObject2);
      i += 1;
      break;
    }
    label181:
    locale.count = locale.maM.size();
    this.maL = locale.maM;
    try
    {
      paramString = locale.toByteArray();
      localObject1 = bha();
      if (bk.bl((String)localObject1))
      {
        y.w("MicroMsg.MassSendService", "mass send config file path is null, return");
        return;
      }
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.MassSendService", paramString, "", new Object[0]);
      return;
    }
    localObject2 = new com.tencent.mm.vfs.b((String)localObject1);
    if (!((com.tencent.mm.vfs.b)localObject2).exists())
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(102408, Boolean.valueOf(false));
    }
    label352:
    for (;;)
    {
      y.d("MicroMsg.MassSendService", "save to config file : %s", new Object[] { locale.toString() });
      com.tencent.mm.vfs.e.b((String)localObject1, paramString, paramString.length);
      return;
      if (!com.tencent.mm.vfs.e.aeY(j.n(((com.tencent.mm.vfs.b)localObject2).mUri)).equals(g.o(paramString))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label352;
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().o(102408, Boolean.valueOf(false));
        break;
      }
    }
  }
  
  public final void bgZ()
  {
    Object localObject1 = null;
    boolean bool1 = bhb();
    au.Hx();
    boolean bool2 = ((Boolean)com.tencent.mm.model.c.Dz().get(102408, Boolean.valueOf(false))).booleanValue();
    int i;
    if ((q.Gu() & 0x10000) == 0)
    {
      i = 1;
      y.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[] { Boolean.valueOf(bool2) });
      if ((i == 0) || (bool2) || (!bool1)) {
        break label401;
      }
      y.d("MicroMsg.MassSendService", "set top conversation");
      au.Hx();
      if (com.tencent.mm.model.c.FB().abv("masssendapp") != null) {
        break label242;
      }
      au.Hx();
      if (com.tencent.mm.model.c.FB().abv("masssendapp") == null)
      {
        localObject1 = new ak();
        ((ak)localObject1).setUsername("masssendapp");
        ((ak)localObject1).setContent(ae.getContext().getResources().getString(R.l.contact_info_masssend_tip));
        ((ak)localObject1).ba(bk.UY() + 2000L);
        ((ak)localObject1).fA(0);
        ((ak)localObject1).fy(0);
        au.Hx();
        com.tencent.mm.model.c.FB().d((ak)localObject1);
      }
    }
    label242:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10425, "");
      au.Hx();
      com.tencent.mm.model.c.Dz().o(102409, Long.valueOf(bk.UY()));
      au.Hx();
      com.tencent.mm.model.c.Dz().o(102408, Boolean.valueOf(true));
      return;
      i = 0;
      break;
      localObject2 = h.bhd().dXo.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
      if (localObject2 != null) {
        break label351;
      }
      label263:
      if (localObject1 != null) {
        break label387;
      }
      localObject1 = ae.getContext().getResources().getString(R.l.contact_info_masssend_tip);
      label282:
      localObject2 = new ak();
      ((ak)localObject2).setUsername("masssendapp");
      ((ak)localObject2).setContent((String)localObject1);
      ((ak)localObject2).ba(bk.UY() + 2000L);
      ((ak)localObject2).fA(0);
      ((ak)localObject2).fy(0);
      au.Hx();
      com.tencent.mm.model.c.FB().a((ak)localObject2, "masssendapp");
    }
    label351:
    if (((Cursor)localObject2).moveToFirst())
    {
      localObject1 = new a();
      ((a)localObject1).d((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      break label263;
      label387:
      h.bhd();
      localObject1 = b.a((a)localObject1);
      break label282;
      label401:
      if (bool1) {
        break;
      }
      au.Hx();
      com.tencent.mm.model.c.Dz().o(102408, Boolean.valueOf(false));
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.c
 * JD-Core Version:    0.7.0.1
 */