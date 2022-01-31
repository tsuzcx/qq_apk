package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static d msS = null;
  private long endTime;
  private boolean icT;
  private Object iiG;
  ak mHandler;
  public ArrayList<d.a> msR;
  private Runnable msT;
  private long startTime;
  
  private d()
  {
    AppMethodBeat.i(102625);
    this.icT = false;
    this.msR = new ArrayList();
    this.startTime = -1L;
    this.endTime = -1L;
    this.iiG = new Object();
    this.msT = new d.1(this);
    this.mHandler = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(102624);
        paramAnonymousMessage = d.this.msR.iterator();
        while (paramAnonymousMessage.hasNext())
        {
          d.a locala = (d.a)paramAnonymousMessage.next();
          if (locala != null) {
            locala.onFinish();
          }
        }
        d.this.msR.clear();
        AppMethodBeat.o(102624);
      }
    };
    AppMethodBeat.o(102625);
  }
  
  public static d bwj()
  {
    try
    {
      AppMethodBeat.i(102626);
      if (msS == null) {
        msS = new d();
      }
      d locald = msS;
      AppMethodBeat.o(102626);
      return locald;
    }
    finally {}
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(102627);
    synchronized (this.iiG)
    {
      if (((Boolean)g.RL().Ru().get(ac.a.yAz, Boolean.FALSE)).booleanValue())
      {
        if (parama != null) {
          parama.onFinish();
        }
        AppMethodBeat.o(102627);
        return;
      }
      if (parama != null) {
        this.msR.add(parama);
      }
      if (this.icT)
      {
        ab.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
        AppMethodBeat.o(102627);
        return;
      }
      this.icT = true;
      this.startTime = System.currentTimeMillis();
      com.tencent.mm.sdk.g.d.post(this.msT, "FavCleanFirstLoader_CalFavDataLength");
      AppMethodBeat.o(102627);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.d
 * JD-Core Version:    0.7.0.1
 */