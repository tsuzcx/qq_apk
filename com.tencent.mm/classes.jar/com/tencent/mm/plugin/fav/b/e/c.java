package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  implements com.tencent.mm.ah.f, u
{
  public Map<String, c.a> kaL = new HashMap();
  
  public c()
  {
    com.tencent.mm.kernel.g.Dk().a(426, this);
    com.tencent.mm.kernel.g.Dk().a(401, this);
  }
  
  public static String u(long paramLong, int paramInt)
  {
    return paramLong + "&&" + paramInt;
  }
  
  public final void a(long paramLong, LinkedList<axi> paramLinkedList, LinkedList<axl> paramLinkedList1, int paramInt)
  {
    y.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.plugin.fav.a.f localf = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavEditInfoStorage().eD(paramLong);
    if (localf == null) {
      localf = new com.tencent.mm.plugin.fav.a.f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      xz localxz = new xz();
      localxz.kab = paramLinkedList;
      localxz.sWL = paramLinkedList1;
      localf.field_modItem = localxz;
      localf.field_time = bk.UY();
      localf.field_type = 0;
      localf.field_scene = paramInt;
      if (i != 0) {
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavEditInfoStorage().a(localf);
      }
      for (;;)
      {
        run();
        return;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavEditInfoStorage().a(localf, new String[] { "localId" });
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm == null) {}
    do
    {
      do
      {
        return;
        y.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
        if (paramm.getType() == 401)
        {
          y.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
          run();
          return;
        }
        paramString = (al)paramm;
      } while (paramString.type == 0);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      paramm = u(paramString.aQI(), paramString.aQJ());
      y.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramm });
      this.kaL.remove(paramm);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavEditInfoStorage().p(paramString.aQI(), paramString.aQJ());
      paramm = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramString.aQI());
    } while (paramm == null);
    long l = paramm.field_id;
    paramInt2 = paramm.field_tagProto.sXq.size();
    if (paramString.jZZ == null) {}
    for (paramInt1 = 1;; paramInt1 = paramString.jZZ.field_scene)
    {
      h.g(l, paramInt2, paramInt1);
      return;
    }
    l = paramString.aQI();
    paramInt1 = paramString.aQJ();
    paramString = u(l, paramInt1);
    y.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
    paramString = (c.a)this.kaL.get(paramString);
    if (paramString == null)
    {
      y.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
      return;
    }
    com.tencent.mm.kernel.g.DS().k(new c.2(this, paramString), 3000L);
  }
  
  public final void run()
  {
    com.tencent.mm.kernel.g.DS().O(new c.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c
 * JD-Core Version:    0.7.0.1
 */