package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  implements com.tencent.mm.ai.f, u
{
  public Map<String, c.a> mvh;
  
  public c()
  {
    AppMethodBeat.i(5366);
    this.mvh = new HashMap();
    com.tencent.mm.kernel.g.Rc().a(426, this);
    com.tencent.mm.kernel.g.Rc().a(401, this);
    AppMethodBeat.o(5366);
  }
  
  public static String z(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5369);
    String str = paramLong + "&&" + paramInt;
    AppMethodBeat.o(5369);
    return str;
  }
  
  public final void a(long paramLong, LinkedList<bdy> paramLinkedList, LinkedList<beb> paramLinkedList1, int paramInt)
  {
    AppMethodBeat.i(5370);
    ab.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.plugin.fav.a.f localf = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavEditInfoStorage().ka(paramLong);
    if (localf == null) {
      localf = new com.tencent.mm.plugin.fav.a.f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      ace localace = new ace();
      localace.mux = paramLinkedList;
      localace.wUK = paramLinkedList1;
      localf.field_modItem = localace;
      localf.field_time = bo.aoy();
      localf.field_type = 0;
      localf.field_scene = paramInt;
      if (i != 0) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavEditInfoStorage().a(localf);
      }
      for (;;)
      {
        run();
        AppMethodBeat.o(5370);
        return;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavEditInfoStorage().a(localf, new String[] { "localId" });
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5367);
    if (paramm == null)
    {
      AppMethodBeat.o(5367);
      return;
    }
    ab.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    if (paramm.getType() == 401)
    {
      ab.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
      run();
      AppMethodBeat.o(5367);
      return;
    }
    paramString = (com.tencent.mm.plugin.fav.a.al)paramm;
    if (paramString.type != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = z(paramString.bwX(), paramString.bwY());
        ab.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramm });
        this.mvh.remove(paramm);
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavEditInfoStorage().u(paramString.bwX(), paramString.bwY());
        paramm = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramString.bwX());
        if (paramm != null)
        {
          l = paramm.field_id;
          paramInt2 = paramm.field_tagProto.wVq.size();
          if (paramString.muv != null) {
            break label249;
          }
        }
        label249:
        for (paramInt1 = 1;; paramInt1 = paramString.muv.field_scene)
        {
          h.j(l, paramInt2, paramInt1);
          AppMethodBeat.o(5367);
          return;
        }
      }
      long l = paramString.bwX();
      paramInt1 = paramString.bwY();
      paramString = z(l, paramInt1);
      ab.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
      paramString = (c.a)this.mvh.get(paramString);
      if (paramString == null)
      {
        ab.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(5367);
        return;
      }
      com.tencent.mm.kernel.g.RO().o(new c.2(this, paramString), 3000L);
    }
    AppMethodBeat.o(5367);
  }
  
  public final void run()
  {
    AppMethodBeat.i(5368);
    com.tencent.mm.kernel.g.RO().ac(new c.1(this));
    AppMethodBeat.o(5368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c
 * JD-Core Version:    0.7.0.1
 */