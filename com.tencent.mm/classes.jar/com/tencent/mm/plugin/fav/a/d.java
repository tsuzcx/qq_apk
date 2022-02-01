package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d qIh = null;
  private long endTime;
  private boolean kOL;
  ao mHandler;
  public ArrayList<a> qIg;
  private Object qIi;
  private Runnable qIj;
  private long startTime;
  
  private d()
  {
    AppMethodBeat.i(103365);
    this.kOL = false;
    this.qIg = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.qIi = new Object();
    this.qIj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103363);
        ((af)g.ad(af.class)).getFavItemInfoStorage().cpO();
        d.a(d.this, System.currentTimeMillis());
        ac.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(d.this) - d.b(d.this)) });
        d.a(d.this, -1L);
        d.c(d.this);
        synchronized (d.d(d.this))
        {
          g.agR().agA().set(ah.a.GGK, Boolean.TRUE);
          d.e(d.this);
          d.this.mHandler.sendEmptyMessage(0);
          AppMethodBeat.o(103363);
          return;
        }
      }
    };
    this.mHandler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(103364);
        paramAnonymousMessage = d.this.qIg.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.qIg.clear();
        AppMethodBeat.o(103364);
      }
    };
    AppMethodBeat.o(103365);
  }
  
  public static d cpj()
  {
    try
    {
      AppMethodBeat.i(103366);
      if (qIh == null) {
        qIh = new d();
      }
      d locald = qIh;
      AppMethodBeat.o(103366);
      return locald;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103367);
    synchronized (this.qIi)
    {
      if (((Boolean)g.agR().agA().get(ah.a.GGK, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(103367);
        return;
      }
      if (parama != null) {
        this.qIg.add(parama);
      }
      if (this.kOL)
      {
        ac.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(103367);
        return;
      }
      this.kOL = true;
      this.startTime = System.currentTimeMillis();
      b.c(this.qIj, "FavCleanFirstLoader_CalFavDataLength");
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