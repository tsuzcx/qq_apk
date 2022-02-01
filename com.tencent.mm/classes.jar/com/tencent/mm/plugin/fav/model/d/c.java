package com.tencent.mm.plugin.fav.model.d;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  implements com.tencent.mm.am.h, v
{
  public Map<String, a> AeH;
  
  public c()
  {
    AppMethodBeat.i(101626);
    this.AeH = new HashMap();
    com.tencent.mm.kernel.h.aZW().a(426, this);
    com.tencent.mm.kernel.h.aZW().a(401, this);
    AppMethodBeat.o(101626);
  }
  
  public static String P(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101629);
    String str = paramLong + "&&" + paramInt;
    AppMethodBeat.o(101629);
    return str;
  }
  
  public final void a(long paramLong, LinkedList<dpo> paramLinkedList, LinkedList<dpr> paramLinkedList1, int paramInt)
  {
    AppMethodBeat.i(101630);
    Log.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[] { Long.valueOf(paramLong) });
    f localf = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavEditInfoStorage().mJ(paramLong);
    if (localf == null) {
      localf = new f();
    }
    for (int i = 1;; i = 0)
    {
      localf.field_localId = paramLong;
      arj localarj = new arj();
      localarj.AdX = paramLinkedList;
      localarj.ZBd = paramLinkedList1;
      localf.field_modItem = localarj;
      localf.field_time = Util.nowMilliSecond();
      localf.field_type = 0;
      localf.field_scene = paramInt;
      if (i != 0) {
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavEditInfoStorage().a(localf);
      }
      for (;;)
      {
        run();
        AppMethodBeat.o(101630);
        return;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavEditInfoStorage().a(localf, new String[] { "localId" });
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(101627);
    if (paramp == null)
    {
      AppMethodBeat.o(101627);
      return;
    }
    Log.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 401)
    {
      Log.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
      run();
      AppMethodBeat.o(101627);
      return;
    }
    paramString = (ao)paramp;
    if (paramString.type != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = P(paramString.dQW(), paramString.dQX());
        Log.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[] { paramp });
        this.AeH.remove(paramp);
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavEditInfoStorage().K(paramString.dQW(), paramString.dQX());
        paramp = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramString.dQW());
        if (paramp != null)
        {
          l = paramp.field_id;
          paramInt2 = paramp.field_tagProto.ZBH.size();
          if (paramString.AdV != null) {
            break label245;
          }
        }
        label245:
        for (paramInt1 = 1;; paramInt1 = paramString.AdV.field_scene)
        {
          com.tencent.mm.plugin.fav.a.h.k(l, paramInt2, paramInt1);
          AppMethodBeat.o(101627);
          return;
        }
      }
      long l = paramString.dQW();
      paramInt1 = paramString.dQX();
      paramString = P(l, paramInt1);
      Log.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[] { paramString });
      paramString = (a)this.AeH.get(paramString);
      if (paramString == null)
      {
        Log.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(101627);
        return;
      }
      com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new c.2(this, paramString), 3000L);
    }
    AppMethodBeat.o(101627);
  }
  
  public final void run()
  {
    AppMethodBeat.i(101628);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101622);
        Object localObject = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavEditInfoStorage().dQE();
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
          String str = c.P(localf.field_localId, localf.field_type);
          c.a locala = (c.a)c.a(c.this).get(str);
          if (locala == null)
          {
            Log.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[] { str });
            locala = new c.a((byte)0);
            locala.AdV = localf;
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
    int AdU;
    f AdV;
    int retryCount;
    long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.d.c
 * JD-Core Version:    0.7.0.1
 */