package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  implements com.tencent.mm.al.g, u
{
  public Map<String, a> qbP;
  
  public c()
  {
    AppMethodBeat.i(101626);
    this.qbP = new HashMap();
    com.tencent.mm.kernel.g.aeS().a(426, this);
    com.tencent.mm.kernel.g.aeS().a(401, this);
    AppMethodBeat.o(101626);
  }
  
  public static String D(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101629);
    String str = paramLong + "&&" + paramInt;
    AppMethodBeat.o(101629);
    return str;
  }
  
  public final void a(long paramLong, LinkedList<bqq> paramLinkedList, LinkedList<bqt> paramLinkedList1, int paramInt)
  {
    AppMethodBeat.i(101630);
    ad.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    f localf = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().pR(paramLong);
    if (localf == null) {
      localf = new f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      agc localagc = new agc();
      localagc.qbf = paramLinkedList;
      localagc.Din = paramLinkedList1;
      localf.field_modItem = localagc;
      localf.field_time = bt.eGO();
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
    ad.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 401)
    {
      ad.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
      run();
      AppMethodBeat.o(101627);
      return;
    }
    paramString = (am)paramn;
    if (paramString.type != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = D(paramString.cin(), paramString.cio());
        ad.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramn });
        this.qbP.remove(paramn);
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().y(paramString.cin(), paramString.cio());
        paramn = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramString.cin());
        if (paramn != null)
        {
          l = paramn.field_id;
          paramInt2 = paramn.field_tagProto.DiR.size();
          if (paramString.qbd != null) {
            break label245;
          }
        }
        label245:
        for (paramInt1 = 1;; paramInt1 = paramString.qbd.field_scene)
        {
          h.j(l, paramInt2, paramInt1);
          AppMethodBeat.o(101627);
          return;
        }
      }
      long l = paramString.cin();
      paramInt1 = paramString.cio();
      paramString = D(l, paramInt1);
      ad.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
      paramString = (a)this.qbP.get(paramString);
      if (paramString == null)
      {
        ad.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(101627);
        return;
      }
      com.tencent.mm.kernel.g.afE().m(new Runnable()
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
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101622);
        Object localObject = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavEditInfoStorage().chX();
        if (localObject == null)
        {
          AppMethodBeat.o(101622);
          return;
        }
        ad.i("MicroMsg.Fav.FavEditService", "infos size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          String str = c.D(localf.field_localId, localf.field_type);
          c.a locala = (c.a)c.this.qbP.get(str);
          if (locala == null)
          {
            ad.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
            locala = new c.a((byte)0);
            locala.qbd = localf;
            locala.retryCount = 3;
            locala.time = SystemClock.elapsedRealtime();
            c.this.qbP.put(str, locala);
            c.a(locala, true);
          }
          else
          {
            ad.i("MicroMsg.Fav.FavEditService", "match key %s, check start", new Object[] { str });
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
    int qbc;
    f qbd;
    int retryCount;
    long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c
 * JD-Core Version:    0.7.0.1
 */