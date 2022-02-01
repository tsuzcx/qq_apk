package com.tencent.mm.plugin.fav.b.e;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  implements i, u
{
  public Map<String, a> tco;
  
  public c()
  {
    AppMethodBeat.i(101626);
    this.tco = new HashMap();
    com.tencent.mm.kernel.g.azz().a(426, this);
    com.tencent.mm.kernel.g.azz().a(401, this);
    AppMethodBeat.o(101626);
  }
  
  public static String D(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101629);
    String str = paramLong + "&&" + paramInt;
    AppMethodBeat.o(101629);
    return str;
  }
  
  public final void a(long paramLong, LinkedList<cps> paramLinkedList, LinkedList<cpv> paramLinkedList1, int paramInt)
  {
    AppMethodBeat.i(101630);
    Log.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    f localf = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavEditInfoStorage().DX(paramLong);
    if (localf == null) {
      localf = new f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      amp localamp = new amp();
      localamp.tbE = paramLinkedList;
      localamp.LxK = paramLinkedList1;
      localf.field_modItem = localamp;
      localf.field_time = Util.nowMilliSecond();
      localf.field_type = 0;
      localf.field_scene = paramInt;
      if (i != 0) {
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavEditInfoStorage().a(localf);
      }
      for (;;)
      {
        run();
        AppMethodBeat.o(101630);
        return;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavEditInfoStorage().a(localf, new String[] { "localId" });
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
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
    paramString = (am)paramq;
    if (paramString.type != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = D(paramString.cVe(), paramString.cVf());
        Log.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramq });
        this.tco.remove(paramq);
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavEditInfoStorage().y(paramString.cVe(), paramString.cVf());
        paramq = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramString.cVe());
        if (paramq != null)
        {
          l = paramq.field_id;
          paramInt2 = paramq.field_tagProto.Lyo.size();
          if (paramString.tbC != null) {
            break label245;
          }
        }
        label245:
        for (paramInt1 = 1;; paramInt1 = paramString.tbC.field_scene)
        {
          h.i(l, paramInt2, paramInt1);
          AppMethodBeat.o(101627);
          return;
        }
      }
      long l = paramString.cVe();
      paramInt1 = paramString.cVf();
      paramString = D(l, paramInt1);
      Log.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
      paramString = (a)this.tco.get(paramString);
      if (paramString == null)
      {
        Log.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(101627);
        return;
      }
      com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
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
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101622);
        Object localObject = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavEditInfoStorage().cUO();
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
          String str = c.D(localf.field_localId, localf.field_type);
          c.a locala = (c.a)c.this.tco.get(str);
          if (locala == null)
          {
            Log.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
            locala = new c.a((byte)0);
            locala.tbC = localf;
            locala.retryCount = 3;
            locala.time = SystemClock.elapsedRealtime();
            c.this.tco.put(str, locala);
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
    int tbB;
    f tbC;
    long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.c
 * JD-Core Version:    0.7.0.1
 */