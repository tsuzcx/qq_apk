package com.tencent.mm.aq;

import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c
  implements am.b
{
  boolean ebb = false;
  private long ebl = 0L;
  com.tencent.mm.a.f<String, Integer> emo = new com.tencent.mm.a.f(200);
  Map<String, am.b.a> emp = new HashMap();
  Queue<ael> emq = new LinkedList();
  Queue<a> emr = new LinkedList();
  long ems = 0L;
  final int emt = 500;
  final int emu = 10000;
  am emv = new am(au.DS().mnU.getLooper(), new c.2(this), false);
  final am emw = new am(au.DS().mnU.getLooper(), new c.7(this), true);
  
  private void Ol()
  {
    Object localObject1 = d.Oo();
    long l = this.ems;
    Cursor localCursor = ((b)localObject1).dXo.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
    if (localCursor == null) {}
    for (;;)
    {
      return;
      int i = localCursor.getCount();
      y.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
      if (i <= 0)
      {
        localCursor.close();
        return;
      }
      Object localObject2 = new LinkedList();
      localObject1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      LinkedList localLinkedList1 = new LinkedList();
      Object localObject3;
      Object localObject4;
      if (localCursor.moveToNext())
      {
        Object localObject6 = new a();
        ((a)localObject6).username = localCursor.getString(0);
        ((a)localObject6).eml = localCursor.getLong(1);
        ((a)localObject6).type = localCursor.getInt(2);
        ((a)localObject6).emm = localCursor.getInt(3);
        ((a)localObject6).dXk = localCursor.getInt(4);
        ((a)localObject6).emn = localCursor.getInt(5);
        ((a)localObject6).dXm = localCursor.getString(6);
        ((a)localObject6).dXn = localCursor.getString(7);
        localObject3 = ((a)localObject6).getUsername();
        localObject4 = bk.pm(((a)localObject6).Oj());
        i = bk.g(Integer.valueOf(((a)localObject6).emn));
        Object localObject5 = bk.pm(((a)localObject6).Ok());
        this.ems = ((a)localObject6).eml;
        localObject6 = (String)localObject3 + "#" + (String)localObject4;
        int j = bk.a((Integer)this.emo.get(localObject6), 0);
        if (j < 3)
        {
          this.emo.f(localObject6, Integer.valueOf(j + 1));
          if (s.hb((String)localObject3))
          {
            localObject5 = new ael();
            ((LinkedList)localObject2).add(new bml().YI((String)localObject3));
            ((LinkedList)localObject1).add(new bml().YI((String)localObject4));
            ((ael)localObject5).svn = ((LinkedList)localObject2);
            ((ael)localObject5).tcx = ((LinkedList)localObject1);
            this.emq.add(localObject5);
            localObject2 = new LinkedList();
            localObject1 = new LinkedList();
            y.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.emq.size()), Integer.valueOf(((ael)localObject5).svn.size()), localObject3 });
          }
        }
        for (;;)
        {
          if (((LinkedList)localObject2).size() < 20)
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (!localCursor.isLast()) {}
          }
          else
          {
            localObject5 = new ael();
            ((ael)localObject5).svn = ((LinkedList)localObject2);
            ((ael)localObject5).tct = ((LinkedList)localObject2).size();
            ((ael)localObject5).tcx = ((LinkedList)localObject1);
            ((ael)localObject5).tcw = ((LinkedList)localObject1).size();
            this.emq.add(localObject5);
            localObject3 = new LinkedList();
            localObject4 = new LinkedList();
            y.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[] { Integer.valueOf(this.emq.size()), Integer.valueOf(((ael)localObject5).svn.size()) });
          }
          localObject1 = localObject4;
          localObject2 = localObject3;
          break;
          if (ad.aaU((String)localObject3))
          {
            localObject5 = new ael();
            ((LinkedList)localObject2).add(new bml().YI((String)localObject3));
            ((LinkedList)localObject1).add(new bml().YI((String)localObject4));
            ((ael)localObject5).svn = ((LinkedList)localObject2);
            ((ael)localObject5).tcx = ((LinkedList)localObject1);
            this.emq.add(localObject5);
            localObject2 = new LinkedList();
            localObject1 = new LinkedList();
            y.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.emq.size()), Integer.valueOf(((ael)localObject5).svn.size()), localObject3 });
          }
          else if (i == 1)
          {
            localLinkedList2.add(new Pair(new bml().YI((String)localObject3), new bml().YI((String)localObject5)));
            y.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject3, Integer.valueOf(i), localObject5 });
          }
          else
          {
            ((LinkedList)localObject2).add(new bml().YI((String)localObject3));
            ((LinkedList)localObject1).add(new bml().YI((String)localObject4));
            y.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[] { localObject3, localObject4 });
            continue;
            localLinkedList1.add(localObject3);
            E((String)localObject3, false);
          }
        }
      }
      localCursor.close();
      localObject1 = localLinkedList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        localObject3 = new ael();
        localObject4 = new LinkedList();
        ((LinkedList)localObject4).add(((Pair)localObject2).first);
        ((ael)localObject3).svn = ((LinkedList)localObject4);
        ((ael)localObject3).tct = ((LinkedList)localObject4).size();
        ((ael)localObject3).tcy = 1;
        ((ael)localObject3).tcz = ((bml)((Pair)localObject2).second);
        this.emq.add(localObject3);
      }
      localLinkedList2.clear();
      i = 0;
      while (i < localLinkedList1.size())
      {
        localObject1 = (String)localLinkedList1.get(i);
        boolean bool1 = s.fn((String)localObject1);
        y.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
        if (bool1) {
          d.Oo().lU((String)localObject1);
        }
        boolean bool2 = s.hc((String)localObject1);
        y.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
        if (bool2)
        {
          d.Oo().lU((String)localObject1);
          com.tencent.mm.plugin.report.f.nEG.a(832L, 3L, 1L, false);
        }
        i += 1;
      }
    }
  }
  
  private static boolean au(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return false;
    }
    Object localObject = q.Gj();
    String str = q.Gk();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      y.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).dXm = bk.pm(paramString2);
    ((a)localObject).eml = bk.UY();
    return d.Oo().a((a)localObject);
  }
  
  final void E(String paramString, boolean paramBoolean)
  {
    ai.d(new c.3(this, paramString, paramBoolean));
  }
  
  final void Om()
  {
    for (;;)
    {
      long l;
      try
      {
        if (com.tencent.mm.plugin.subapp.b.eUS.tr())
        {
          y.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
          return;
        }
        l = bk.UY();
        if ((this.ebb) && (l - this.ebl > 600000L))
        {
          y.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.ebl) });
          this.ebb = false;
        }
        if (this.ebb)
        {
          y.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.ebb + " ret");
          continue;
        }
        localObject3 = (ael)this.emq.poll();
      }
      finally {}
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        Ol();
        localObject3 = (ael)this.emq.poll();
        if ((localObject3 != null) && (((ael)localObject3).svn != null))
        {
          localObject2 = localObject3;
          if (((ael)localObject3).svn.size() != 0) {}
        }
        else
        {
          y.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
          continue;
        }
      }
      this.ebl = l;
      this.ebb = true;
      Object localObject3 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((ael)localObject2).svn.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = aa.a((bml)((Iterator)localObject5).next());
        if (s.hb((String)localObject6)) {
          ((LinkedList)localObject3).add(localObject6);
        }
        if (ad.aaU((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject3).get(0);
        if (s.hb((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.YK((String)localObject2).eM((String)localObject2).d(new c.4(this, (String)localObject2)).cpz();
        }
      }
      else if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new aia();
        ((aia)localObject6).ePQ = ((String)localObject5);
        localObject4 = "";
        localObject3 = localObject4;
        if (((ael)localObject2).tcx != null)
        {
          localObject3 = localObject4;
          if (((ael)localObject2).tcx.size() > 0) {
            localObject3 = aa.a((bml)((ael)localObject2).tcx.get(0));
          }
        }
        ((aia)localObject6).ePP = ((String)localObject3);
        localObject2 = new b.a();
        ((b.a)localObject2).ecH = ((com.tencent.mm.bv.a)localObject6);
        ((b.a)localObject2).ecI = new aib();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((b.a)localObject2).ecG = 881;
        y.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject3, localObject5 });
        w.a(((b.a)localObject2).Kt(), new c.5(this, (String)localObject5), true);
      }
      else
      {
        localObject3 = new b.a();
        ((b.a)localObject3).ecH = ((com.tencent.mm.bv.a)localObject2);
        ((b.a)localObject3).ecI = new aem();
        ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getcontact";
        ((b.a)localObject3).ecG = 182;
        w.a(((b.a)localObject3).Kt(), new w.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
          {
            if (paramAnonymousm.getType() != 182) {}
            do
            {
              return 0;
              c.this.ebb = false;
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                y.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " will retry");
                c.this.emv.S(10000L, 10000L);
                return 0;
              }
              if ((!c.this.emq.isEmpty()) && (c.this.emv.crl())) {
                c.this.emv.S(500L, 500L);
              }
              if (paramAnonymousb != null)
              {
                paramAnonymousm = new c.a(c.this);
                paramAnonymousm.errType = paramAnonymousInt1;
                paramAnonymousm.errCode = paramAnonymousInt2;
                paramAnonymousm.aox = paramAnonymousString;
                paramAnonymousm.emE = ((aem)paramAnonymousb.ecF.ecN);
                c.this.emr.add(paramAnonymousm);
              }
            } while ((c.this.emr.isEmpty()) || (!c.this.emw.crl()));
            c.this.emw.S(50L, 50L);
            return 0;
          }
        }, true);
      }
    }
  }
  
  public final void V(String paramString1, String paramString2)
  {
    y.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bk.csb());
    if (au(paramString1, paramString2)) {
      this.emv.S(500L, 500L);
    }
  }
  
  public final void X(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (bk.bl(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.emv.S(500L, 500L);
      }
      return;
      Object localObject = q.Gj();
      String str = q.Gk();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        y.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).dXn = bk.pm(paramString2);
        ((a)localObject).emn = bk.g(Integer.valueOf(1));
        ((a)localObject).eml = bk.UY();
        bool = d.Oo().a((a)localObject);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, am.b.a parama)
  {
    y.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bk.csb());
    if (au(paramString1, paramString2))
    {
      this.emp.put(paramString1, parama);
      this.emv.S(0L, 0L);
    }
  }
  
  public final void iC(String paramString)
  {
    this.emp.remove(paramString);
  }
  
  public final void iD(String paramString)
  {
    au.DS().O(new c.1(this, paramString));
  }
  
  final class a
  {
    String aox;
    aem emE;
    int emF = 0;
    int errCode;
    int errType;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */