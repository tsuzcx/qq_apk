package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d wGd = null;
  private long endTime;
  MMHandler mHandler;
  private boolean puR;
  private long startTime;
  public ArrayList<a> wGc;
  private Object wGe;
  private Runnable wGf;
  
  private d()
  {
    AppMethodBeat.i(103365);
    this.puR = false;
    this.wGc = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.wGe = new Object();
    this.wGf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103363);
        ((ag)h.ag(ag.class)).getFavItemInfoStorage().dke();
        d.a(d.this, System.currentTimeMillis());
        Log.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(d.this) - d.b(d.this)) });
        d.a(d.this, -1L);
        d.c(d.this);
        synchronized (d.d(d.this))
        {
          h.aHG().aHp().set(ar.a.VjB, Boolean.TRUE);
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
        paramAnonymousMessage = d.this.wGc.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.wGc.clear();
        AppMethodBeat.o(103364);
      }
    };
    AppMethodBeat.o(103365);
  }
  
  public static d djy()
  {
    try
    {
      AppMethodBeat.i(103366);
      if (wGd == null) {
        wGd = new d();
      }
      d locald = wGd;
      AppMethodBeat.o(103366);
      return locald;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103367);
    synchronized (this.wGe)
    {
      if (((Boolean)h.aHG().aHp().get(ar.a.VjB, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(103367);
        return;
      }
      if (parama != null) {
        this.wGc.add(parama);
      }
      if (this.puR)
      {
        Log.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(103367);
        return;
      }
      this.puR = true;
      this.startTime = System.currentTimeMillis();
      ThreadPool.post(this.wGf, "FavCleanFirstLoader_CalFavDataLength");
      AppMethodBeat.o(103367);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d
 * JD-Core Version:    0.7.0.1
 */