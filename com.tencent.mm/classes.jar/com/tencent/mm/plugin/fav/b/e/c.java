package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  implements i, v
{
  public Map<String, a> wIt;
  
  public c()
  {
    AppMethodBeat.i(101626);
    this.wIt = new HashMap();
    com.tencent.mm.kernel.h.aGY().a(426, this);
    com.tencent.mm.kernel.h.aGY().a(401, this);
    AppMethodBeat.o(101626);
  }
  
  public static String F(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101629);
    String str = paramLong + "&&" + paramInt;
    AppMethodBeat.o(101629);
    return str;
  }
  
  public final void a(long paramLong, LinkedList<cyi> paramLinkedList, LinkedList<cyl> paramLinkedList1, int paramInt)
  {
    AppMethodBeat.i(101630);
    Log.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    f localf = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavEditInfoStorage().Kl(paramLong);
    if (localf == null) {
      localf = new f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      anq localanq = new anq();
      localanq.wHJ = paramLinkedList;
      localanq.SAl = paramLinkedList1;
      localf.field_modItem = localanq;
      localf.field_time = Util.nowMilliSecond();
      localf.field_type = 0;
      localf.field_scene = paramInt;
      if (i != 0) {
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavEditInfoStorage().a(localf);
      }
      for (;;)
      {
        run();
        AppMethodBeat.o(101630);
        return;
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavEditInfoStorage().a(localf, new String[] { "localId" });
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(101627);
    if (paramq == null)
    {
      AppMethodBeat.o(101627);
      return;
    }
    Log.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 401)
    {
      Log.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
      run();
      AppMethodBeat.o(101627);
      return;
    }
    paramString = (an)paramq;
    if (paramString.type != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = F(paramString.dkk(), paramString.dkl());
        Log.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramq });
        this.wIt.remove(paramq);
        ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavEditInfoStorage().A(paramString.dkk(), paramString.dkl());
        paramq = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramString.dkk());
        if (paramq != null)
        {
          l = paramq.field_id;
          paramInt2 = paramq.field_tagProto.SAP.size();
          if (paramString.wHH != null) {
            break label245;
          }
        }
        label245:
        for (paramInt1 = 1;; paramInt1 = paramString.wHH.field_scene)
        {
          com.tencent.mm.plugin.fav.a.h.i(l, paramInt2, paramInt1);
          AppMethodBeat.o(101627);
          return;
        }
      }
      long l = paramString.dkk();
      paramInt1 = paramString.dkl();
      paramString = F(l, paramInt1);
      Log.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
      paramString = (a)this.wIt.get(paramString);
      if (paramString == null)
      {
        Log.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(101627);
        return;
      }
      com.tencent.mm.kernel.h.aHJ().postToWorkerDelayed(new Runnable()
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
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101622);
        Object localObject = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavEditInfoStorage().djU();
        if (localObject == null)
        {
          AppMethodBeat.o(101622);
          return;
        }
        Log.i("MicroMsg.Fav.FavEditService", "infos size %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          String str = c.F(localf.field_localId, localf.field_type);
          c.a locala = (c.a)c.a(c.this).get(str);
          if (locala == null)
          {
            Log.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
            locala = new c.a((byte)0);
            locala.wHH = localf;
            locala.retryCount = 3;
            locala.time = SystemClock.elapsedRealtime();
            c.a(c.this).put(str, locala);
            c.a(locala, true);
          }
          else
          {
            Log.i("MicroMsg.Fav.FavEditService", "match key %s, check start", new Object[] { str });
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
    int retryCount;
    long time;
    int wHG;
    f wHH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c
 * JD-Core Version:    0.7.0.1
 */