package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d rsi = null;
  private long endTime;
  private boolean llo;
  ap mHandler;
  public ArrayList<a> rsh;
  private Object rsj;
  private Runnable rsk;
  private long startTime;
  
  private d()
  {
    AppMethodBeat.i(103365);
    this.llo = false;
    this.rsh = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.rsj = new Object();
    this.rsk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103363);
        ((af)g.ad(af.class)).getFavItemInfoStorage().cvt();
        d.a(d.this, System.currentTimeMillis());
        ad.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[] { Long.valueOf(d.a(d.this) - d.b(d.this)) });
        d.a(d.this, -1L);
        d.c(d.this);
        synchronized (d.d(d.this))
        {
          g.ajC().ajl().set(al.a.Itc, Boolean.TRUE);
          d.e(d.this);
          d.this.mHandler.sendEmptyMessage(0);
          AppMethodBeat.o(103363);
          return;
        }
      }
    };
    this.mHandler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(103364);
        paramAnonymousMessage = d.this.rsh.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.rsh.clear();
        AppMethodBeat.o(103364);
      }
    };
    AppMethodBeat.o(103365);
  }
  
  public static d cuO()
  {
    try
    {
      AppMethodBeat.i(103366);
      if (rsi == null) {
        rsi = new d();
      }
      d locald = rsi;
      AppMethodBeat.o(103366);
      return locald;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103367);
    synchronized (this.rsj)
    {
      if (((Boolean)g.ajC().ajl().get(al.a.Itc, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(103367);
        return;
      }
      if (parama != null) {
        this.rsh.add(parama);
      }
      if (this.llo)
      {
        ad.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(103367);
        return;
      }
      this.llo = true;
      this.startTime = System.currentTimeMillis();
      b.c(this.rsk, "FavCleanFirstLoader_CalFavDataLength");
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