package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d sZZ = null;
  private long endTime;
  MMHandler mHandler;
  private boolean mwr;
  public ArrayList<a> sZY;
  private long startTime;
  private Object taa;
  private Runnable tab;
  
  private d()
  {
    AppMethodBeat.i(103365);
    this.mwr = false;
    this.sZY = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.taa = new Object();
    this.tab = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103363);
        ((af)g.ah(af.class)).getFavItemInfoStorage().cUY();
        d.a(d.this, System.currentTimeMillis());
        Log.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(d.this) - d.b(d.this)) });
        d.a(d.this, -1L);
        d.c(d.this);
        synchronized (d.d(d.this))
        {
          g.aAh().azQ().set(ar.a.NVB, Boolean.TRUE);
          d.e(d.this);
          d.this.mHandler.sendEmptyMessage(0);
          AppMethodBeat.o(103363);
          return;
        }
      }
    };
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(103364);
        paramAnonymousMessage = d.this.sZY.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.sZY.clear();
        AppMethodBeat.o(103364);
      }
    };
    AppMethodBeat.o(103365);
  }
  
  public static d cUs()
  {
    try
    {
      AppMethodBeat.i(103366);
      if (sZZ == null) {
        sZZ = new d();
      }
      d locald = sZZ;
      AppMethodBeat.o(103366);
      return locald;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103367);
    synchronized (this.taa)
    {
      if (((Boolean)g.aAh().azQ().get(ar.a.NVB, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(103367);
        return;
      }
      if (parama != null) {
        this.sZY.add(parama);
      }
      if (this.mwr)
      {
        Log.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(103367);
        return;
      }
      this.mwr = true;
      this.startTime = System.currentTimeMillis();
      ThreadPool.post(this.tab, "FavCleanFirstLoader_CalFavDataLength");
      AppMethodBeat.o(103367);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d
 * JD-Core Version:    0.7.0.1
 */