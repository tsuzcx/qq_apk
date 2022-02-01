package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  implements com.tencent.mm.ak.g, u
{
  public Map<String, a> qKv;
  
  public c()
  {
    AppMethodBeat.i(101626);
    this.qKv = new HashMap();
    com.tencent.mm.kernel.g.agi().a(426, this);
    com.tencent.mm.kernel.g.agi().a(401, this);
    AppMethodBeat.o(101626);
  }
  
  public static String E(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101629);
    String str = paramLong + "&&" + paramInt;
    AppMethodBeat.o(101629);
    return str;
  }
  
  public final void a(long paramLong, LinkedList<bvh> paramLinkedList, LinkedList<bvk> paramLinkedList1, int paramInt)
  {
    AppMethodBeat.i(101630);
    ac.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    f localf = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().tG(paramLong);
    if (localf == null) {
      localf = new f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      ahb localahb = new ahb();
      localahb.qJL = paramLinkedList;
      localahb.EBt = paramLinkedList1;
      localf.field_modItem = localahb;
      localf.field_time = bs.eWj();
      localf.field_type = 0;
      localf.field_scene = paramInt;
      if (i != 0) {
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().a(localf);
      }
      for (;;)
      {
        run();
        AppMethodBeat.o(101630);
        return;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().a(localf, new String[] { "localId" });
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(101627);
    if (paramn == null)
    {
      AppMethodBeat.o(101627);
      return;
    }
    ac.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 401)
    {
      ac.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
      run();
      AppMethodBeat.o(101627);
      return;
    }
    paramString = (am)paramn;
    if (paramString.type != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = E(paramString.cpU(), paramString.cpV());
        ac.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramn });
        this.qKv.remove(paramn);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().z(paramString.cpU(), paramString.cpV());
        paramn = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramString.cpU());
        if (paramn != null)
        {
          l = paramn.field_id;
          paramInt2 = paramn.field_tagProto.EBX.size();
          if (paramString.qJJ != null) {
            break label245;
          }
        }
        label245:
        for (paramInt1 = 1;; paramInt1 = paramString.qJJ.field_scene)
        {
          h.j(l, paramInt2, paramInt1);
          AppMethodBeat.o(101627);
          return;
        }
      }
      long l = paramString.cpU();
      paramInt1 = paramString.cpV();
      paramString = E(l, paramInt1);
      ac.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
      paramString = (a)this.qKv.get(paramString);
      if (paramString == null)
      {
        ac.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(101627);
        return;
      }
      com.tencent.mm.kernel.g.agU().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(101624);
          c.a(paramString, false);
          AppMethodBeat.o(101624);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(101625);
          String str = super.toString() + "|retryJob";
          AppMethodBeat.o(101625);
          return str;
        }
      }, 3000L);
    }
    AppMethodBeat.o(101627);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101628);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101622);
        Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().cpE();
        if (localObject == null)
        {
          AppMethodBeat.o(101622);
          return;
        }
        ac.i("MicroMsg.Fav.FavEditService", "infos size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          String str = c.E(localf.field_localId, localf.field_type);
          c.a locala = (c.a)c.this.qKv.get(str);
          if (locala == null)
          {
            ac.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
            locala = new c.a((byte)0);
            locala.qJJ = localf;
            locala.retryCount = 3;
            locala.time = SystemClock.elapsedRealtime();
            c.this.qKv.put(str, locala);
            c.a(locala, true);
          }
          else
          {
            ac.i("MicroMsg.Fav.FavEditService", "match key %s, check start", new Object[] { str });
            c.a(locala, false);
          }
        }
        AppMethodBeat.o(101622);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(101623);
        String str = super.toString() + "|run";
        AppMethodBeat.o(101623);
        return str;
      }
    });
    AppMethodBeat.o(101628);
  }
  
  static final class a
  {
    int qJI;
    f qJJ;
    int retryCount;
    long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c
 * JD-Core Version:    0.7.0.1
 */