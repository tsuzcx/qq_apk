package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ak.i
{
  public LinkedList<a> pno;
  private boolean pnp;
  private List<qw> pnq;
  private List<qw> pnr;
  
  public f()
  {
    AppMethodBeat.i(5570);
    this.pno = new LinkedList();
    this.pnp = false;
    this.pnq = new LinkedList();
    this.pnr = new LinkedList();
    g.azz().a(387, this);
    g.azz().a(new i(), 0);
    AppMethodBeat.o(5570);
  }
  
  public final List<qw> CV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.pnr;
    }
    return this.pnq;
  }
  
  public final void init()
  {
    AppMethodBeat.i(5571);
    long l1 = System.currentTimeMillis();
    this.pnq.clear();
    this.pnr.clear();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.brandIconURL");
    ((StringBuilder)localObject1).append(", bizinfo.type");
    ((StringBuilder)localObject1).append(", bizinfo.status");
    ((StringBuilder)localObject1).append(", rcontact.username");
    ((StringBuilder)localObject1).append(", rcontact.conRemark");
    ((StringBuilder)localObject1).append(", rcontact.nickname");
    ((StringBuilder)localObject1).append(", rcontact.alias");
    ((StringBuilder)localObject1).append(", rcontact.conRemarkPYFull");
    ((StringBuilder)localObject1).append(", rcontact.conRemarkPYShort");
    ((StringBuilder)localObject1).append(", rcontact.showHead");
    ((StringBuilder)localObject1).append(", rcontact.pyInitial");
    ((StringBuilder)localObject1).append(", rcontact.quanPin");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(as.gBP()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    ((StringBuilder)localObject1).append(" order by showHead asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" upper(quanPin) asc, ");
    ((StringBuilder)localObject1).append(" upper(nickname) asc");
    localObject1 = ((StringBuilder)localObject1).toString();
    Log.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[] { localObject1 });
    g.aAi();
    Object localObject2 = g.aAh().hqK.rawQuery((String)localObject1, null, 2);
    localObject1 = new HashMap();
    int i;
    if (localObject2 != null) {
      i = 0;
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      if (((Cursor)localObject2).moveToNext())
      {
        i += 1;
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        localObject4 = new c();
        ((c)localObject4).convertFrom((Cursor)localObject2);
        if ((!((ax)localObject3).field_username.equals("gh_43f2581f6fd6")) && (!((ax)localObject3).field_username.equals("gh_3dfda90e39d6")) && (!((ax)localObject3).field_username.equals("gh_f0a92aa7146c")) && ((1 != ((b)g.af(b.class)).a(b.a.soA, 0)) || (!((ax)localObject3).field_username.equals("gh_579db1f2cf89"))))
        {
          qw localqw = new qw();
          localqw.userName = ((ax)localObject3).field_username;
          localqw.contact = ((as)localObject3);
          localqw.Bdk = ((c)localObject4);
          if (!ab.Jf(localqw.userName))
          {
            ((Map)localObject1).put(localqw.userName, localqw);
            if (localqw.Bdk.field_type != 3) {
              if (localqw.Bdk.field_type == 2) {
                this.pnq.add(localqw);
              } else if ((localqw.Bdk.field_type == 1) || (localqw.Bdk.field_type == 0)) {
                this.pnr.add(localqw);
              }
            }
          }
        }
      }
      else
      {
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[] { Integer.valueOf(i) });
        ((Cursor)localObject2).close();
        long l2 = System.currentTimeMillis();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("select username");
        ((StringBuilder)localObject2).append(" from rcontact");
        ((StringBuilder)localObject2).append(" where (verifyFlag & ").append(as.gBP()).append(") != 0 ");
        ((StringBuilder)localObject2).append(" and (type & 1) != 0 ");
        localObject2 = ((StringBuilder)localObject2).toString();
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[] { localObject2 });
        g.aAi();
        localObject2 = g.aAh().hqK.rawQuery((String)localObject2, null);
        if (localObject2 != null)
        {
          localObject3 = new ArrayList();
          while (((Cursor)localObject2).moveToNext())
          {
            localObject4 = ((Cursor)localObject2).getString(0);
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((ArrayList)localObject3).add(localObject4);
            }
          }
          ((Cursor)localObject2).close();
          Log.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), localObject3 });
          if (!((ArrayList)localObject3).isEmpty())
          {
            g.aAi();
            long l3 = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            localObject1 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              ay.a.iDq.aL((String)localObject2, "");
            }
            g.aAi();
            g.aAh().hqK.endTransaction(l3);
          }
        }
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[] { Integer.valueOf(this.pnr.size()), Integer.valueOf(this.pnq.size()) });
        Log.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(5571);
        return;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(5573);
    Log.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(5573);
      return;
    }
    if (paramq.getType() == 387)
    {
      paramString = ((i)paramq).pnD;
      if (paramString == null)
      {
        Log.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if ((this.pnq == null) || (this.pnr == null))
      {
        Log.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if (paramString.size() != this.pnq.size() + this.pnr.size()) {
        paramInt1 = 1;
      }
    }
    label309:
    for (;;)
    {
      if (paramInt1 != 0)
      {
        init();
        paramString = this.pno.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((a)paramString.next()).onChange();
            continue;
            paramq = this.pnq.iterator();
            qw localqw;
            do
            {
              paramInt1 = i;
              if (!paramq.hasNext()) {
                break;
              }
              localqw = (qw)paramq.next();
            } while ((localqw != null) && (paramString.contains(localqw.userName)));
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label309;
            }
            paramq = this.pnr.iterator();
            do
            {
              if (!paramq.hasNext()) {
                break;
              }
              localqw = (qw)paramq.next();
            } while ((localqw != null) && (paramString.contains(localqw.userName)));
            paramInt1 = 1;
            break;
          }
        }
      }
      AppMethodBeat.o(5573);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(5572);
    g.azz().b(387, this);
    if (this.pnp)
    {
      ArrayList localArrayList = new ArrayList(this.pnq.size() + this.pnr.size());
      Iterator localIterator = this.pnq.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((qw)localIterator.next());
      }
      localIterator = this.pnr.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((qw)localIterator.next());
      }
      g.azz().a(new n(localArrayList), 0);
    }
    AppMethodBeat.o(5572);
  }
  
  public static abstract interface a
  {
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f
 * JD-Core Version:    0.7.0.1
 */