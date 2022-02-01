package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d Acm = null;
  public ArrayList<a> Acl;
  private Object Acn;
  private Runnable Aco;
  private long endTime;
  MMHandler mHandler;
  private long startTime;
  private boolean szX;
  
  private d()
  {
    AppMethodBeat.i(103365);
    this.szX = false;
    this.Acl = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.Acn = new Object();
    this.Aco = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103363);
        ((ah)h.az(ah.class)).getFavItemInfoStorage().dQO();
        d.a(d.this, System.currentTimeMillis());
        Log.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(d.this) - d.b(d.this)) });
        d.a(d.this, -1L);
        d.c(d.this);
        synchronized (d.d(d.this))
        {
          h.baE().ban().set(at.a.acKV, Boolean.TRUE);
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
        paramAnonymousMessage = d.this.Acl.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.Acl.clear();
        AppMethodBeat.o(103364);
      }
    };
    AppMethodBeat.o(103365);
  }
  
  public static d dQj()
  {
    try
    {
      AppMethodBeat.i(103366);
      if (Acm == null) {
        Acm = new d();
      }
      d locald = Acm;
      AppMethodBeat.o(103366);
      return locald;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103367);
    synchronized (this.Acn)
    {
      if (((Boolean)h.baE().ban().get(at.a.acKV, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(103367);
        return;
      }
      if (parama != null) {
        this.Acl.add(parama);
      }
      if (this.szX)
      {
        Log.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(103367);
        return;
      }
      this.szX = true;
      this.startTime = System.currentTimeMillis();
      ThreadPool.post(this.Aco, "FavCleanFirstLoader_CalFavDataLength");
      AppMethodBeat.o(103367);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d
 * JD-Core Version:    0.7.0.1
 */