package com.tencent.h.a;

import android.content.Context;
import com.tencent.h.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class l
  extends com.tencent.h.a.b.b.a
{
  com.tencent.h.a.e.a ahWD;
  private final com.tencent.g.a.a ahWE;
  
  public l(Context paramContext, m paramm)
  {
    super(paramContext, paramm);
    AppMethodBeat.i(212077);
    this.ahWE = new com.tencent.g.a.a()
    {
      public final void bXC()
      {
        AppMethodBeat.i(212109);
        com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: mTimeOutRunnable ] ");
        l locall = l.this;
        i.a locala = i.kcZ();
        locala.ahWx = false;
        locall.b(locala);
        AppMethodBeat.o(212109);
      }
    };
    this.ahWD = new com.tencent.h.a.e.a(kdg().mAppContext);
    AppMethodBeat.o(212077);
  }
  
  public final boolean a(final h.a parama, final e parame)
  {
    AppMethodBeat.i(212094);
    parame = new com.tencent.h.a.c.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.h.a.c.b.a paramAnonymousa)
      {
        AppMethodBeat.i(212105);
        if (parame == null)
        {
          AppMethodBeat.o(212105);
          return;
        }
        com.tencent.h.a.e.a locala;
        String str1;
        if ((paramAnonymousInt != 0) || (paramAnonymousa == null))
        {
          paramAnonymousa = l.a(l.this, null);
          locala = l.this.ahWD;
          if (parama.ahWr != c.ahWn) {
            break label116;
          }
          str1 = "TeenyProto";
          label60:
          if (parama.ahWr != c.ahWn) {
            break label122;
          }
        }
        label116:
        label122:
        for (String str2 = "teenyProtoCheckWup";; str2 = "ownerRecoV2Wup")
        {
          paramAnonymousa = locala.a(str1, str2, paramAnonymousa);
          parame.cn(paramAnonymousa);
          AppMethodBeat.o(212105);
          return;
          paramAnonymousa = l.a(l.this, paramAnonymousa);
          break;
          str1 = "masterRecoV2New";
          break label60;
        }
      }
    };
    kdg().ahWR.a(this.ahWE);
    boolean bool = a(parama, parame);
    if (bool)
    {
      com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: start ] post mTimeOutRunnable");
      parama = kdg().ahWR;
      parame = this.ahWE;
      if (parame != null) {
        parama.ahWW.postDelayed(parame, 1200000L);
      }
    }
    AppMethodBeat.o(212094);
    return bool;
  }
  
  public final boolean a(i.a parama)
  {
    AppMethodBeat.i(212100);
    bool1 = false;
    try
    {
      bool2 = b(parama);
      bool1 = bool2;
      if (kdg().ahWR != null)
      {
        bool1 = bool2;
        kdg().ahWR.a(this.ahWE);
      }
      bool1 = bool2;
      com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: stop ] remove mTimeOutRunnable");
    }
    finally
    {
      for (;;)
      {
        boolean bool2 = bool1;
        if (kdg() != null)
        {
          bool2 = bool1;
          if (kdg().ahWQ != null)
          {
            kdg().ahWQ.b(parama, "stop");
            bool2 = bool1;
          }
        }
      }
    }
    AppMethodBeat.o(212100);
    return bool2;
  }
  
  final boolean b(i.a parama)
  {
    AppMethodBeat.i(212107);
    bool1 = false;
    try
    {
      bool2 = kdr().a(parama);
      bool1 = bool2;
      com.tencent.g.c.i.i("sensor_TuringSMIImpl", "[method: stopMasterEngine ] ");
    }
    finally
    {
      for (;;)
      {
        boolean bool2 = bool1;
        if (kdg() != null)
        {
          bool2 = bool1;
          if (kdg().ahWQ != null)
          {
            kdg().ahWQ.b(parama, "stop");
            bool2 = bool1;
          }
        }
      }
    }
    AppMethodBeat.o(212107);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.l
 * JD-Core Version:    0.7.0.1
 */