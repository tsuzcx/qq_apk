package com.tencent.h.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.h.a.b.b.a
{
  com.tencent.h.a.e.a ZSg;
  private final com.tencent.g.a.a ZSh;
  
  public l(Context paramContext, m paramm)
  {
    super(paramContext, paramm);
    AppMethodBeat.i(207427);
    this.ZSh = new com.tencent.g.a.a()
    {
      public final void byO()
      {
        AppMethodBeat.i(207677);
        com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: mTimeOutRunnable ] ");
        l locall = l.this;
        i.a locala = i.itE();
        locala.ZSa = false;
        locall.b(locala);
        AppMethodBeat.o(207677);
      }
    };
    this.ZSg = new com.tencent.h.a.e.a(itK().mAppContext);
    AppMethodBeat.o(207427);
  }
  
  public final boolean a(final h.a parama, final e parame)
  {
    AppMethodBeat.i(207428);
    parame = new com.tencent.h.a.c.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.h.a.c.b.a paramAnonymousa)
      {
        AppMethodBeat.i(207809);
        if (parame == null)
        {
          AppMethodBeat.o(207809);
          return;
        }
        com.tencent.h.a.e.a locala;
        String str1;
        if ((paramAnonymousInt != 0) || (paramAnonymousa == null))
        {
          paramAnonymousa = l.a(l.this, null);
          locala = l.this.ZSg;
          if (parama.ZRU != c.ZRQ) {
            break label116;
          }
          str1 = "TeenyProto";
          label60:
          if (parama.ZRU != c.ZRQ) {
            break label122;
          }
        }
        label116:
        label122:
        for (String str2 = "teenyProtoCheckWup";; str2 = "ownerRecoV2Wup")
        {
          paramAnonymousa = locala.a(str1, str2, paramAnonymousa);
          parame.cm(paramAnonymousa);
          AppMethodBeat.o(207809);
          return;
          paramAnonymousa = l.a(l.this, paramAnonymousa);
          break;
          str1 = "masterRecoV2New";
          break label60;
        }
      }
    };
    itK().ZSt.a(this.ZSh);
    boolean bool = a(parama, parame);
    if (bool)
    {
      com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: start ] post mTimeOutRunnable");
      parama = itK().ZSt;
      parame = this.ZSh;
      if (parame != null) {
        parama.ZQg.postDelayed(parame, 1200000L);
      }
    }
    AppMethodBeat.o(207428);
    return bool;
  }
  
  public final boolean a(i.a parama)
  {
    AppMethodBeat.i(207430);
    bool1 = false;
    try
    {
      bool2 = b(parama);
      bool1 = bool2;
      itK().ZSt.a(this.ZSh);
      bool1 = bool2;
      com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: stop ] remove mTimeOutRunnable");
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        boolean bool2 = bool1;
        if (itK() != null)
        {
          bool2 = bool1;
          if (itK().ZSs != null)
          {
            itK().ZSs.b(parama, "stop");
            bool2 = bool1;
          }
        }
      }
    }
    AppMethodBeat.o(207430);
    return bool2;
  }
  
  final boolean b(i.a parama)
  {
    AppMethodBeat.i(207431);
    bool1 = false;
    try
    {
      bool2 = itV().a(parama);
      bool1 = bool2;
      com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: stopMasterEngine ] ");
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        boolean bool2 = bool1;
        if (itK() != null)
        {
          bool2 = bool1;
          if (itK().ZSs != null)
          {
            itK().ZSs.b(parama, "stop");
            bool2 = bool1;
          }
        }
      }
    }
    AppMethodBeat.o(207431);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.l
 * JD-Core Version:    0.7.0.1
 */