package com.tencent.i.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.h.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.i.a.b.b.a
{
  com.tencent.i.a.e.a SqD;
  private final com.tencent.h.a.a SqE;
  
  public l(Context paramContext, m paramm)
  {
    super(paramContext, paramm);
    AppMethodBeat.i(214673);
    this.SqE = new com.tencent.h.a.a()
    {
      public final void boF()
      {
        AppMethodBeat.i(214671);
        h.i("sensor_TuringSMIImpl", "[method: mTimeOutRunnable ] ");
        l locall = l.this;
        i.a locala = i.hpZ();
        locala.Sqx = false;
        locall.b(locala);
        AppMethodBeat.o(214671);
      }
    };
    this.SqD = new com.tencent.i.a.e.a(this.SqM.mAppContext);
    AppMethodBeat.o(214673);
  }
  
  public final boolean a(final h.a parama, final e parame)
  {
    AppMethodBeat.i(214674);
    parame = new com.tencent.i.a.c.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.i.a.c.b.a paramAnonymousa)
      {
        AppMethodBeat.i(214672);
        if (parame == null)
        {
          AppMethodBeat.o(214672);
          return;
        }
        com.tencent.i.a.e.a locala;
        String str1;
        if ((paramAnonymousInt != 0) || (paramAnonymousa == null))
        {
          paramAnonymousa = l.a(l.this, null);
          locala = l.this.SqD;
          if (parama.Sqr != c.Sqn) {
            break label116;
          }
          str1 = "TeenyProto";
          label60:
          if (parama.Sqr != c.Sqn) {
            break label122;
          }
        }
        label116:
        label122:
        for (String str2 = "teenyProtoCheckWup";; str2 = "ownerRecoV2Wup")
        {
          paramAnonymousa = locala.a(str1, str2, paramAnonymousa);
          parame.bW(paramAnonymousa);
          AppMethodBeat.o(214672);
          return;
          paramAnonymousa = l.a(l.this, paramAnonymousa);
          break;
          str1 = "masterRecoV2New";
          break label60;
        }
      }
    };
    this.SqM.SqQ.a(this.SqE);
    boolean bool = a(parama, parame);
    if (bool)
    {
      h.i("sensor_TuringSMIImpl", "[method: start ] post mTimeOutRunnable");
      parama = this.SqM.SqQ;
      parame = this.SqE;
      if (parame != null) {
        parama.Son.postDelayed(parame, 1200000L);
      }
    }
    AppMethodBeat.o(214674);
    return bool;
  }
  
  public final boolean a(i.a parama)
  {
    AppMethodBeat.i(214675);
    bool1 = false;
    try
    {
      bool2 = b(parama);
      bool1 = bool2;
      this.SqM.SqQ.a(this.SqE);
      bool1 = bool2;
      h.i("sensor_TuringSMIImpl", "[method: stop ] remove mTimeOutRunnable");
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        boolean bool2 = bool1;
        if (this.SqM != null)
        {
          bool2 = bool1;
          if (this.SqM.SqP != null)
          {
            this.SqM.SqP.b(parama, "stop");
            bool2 = bool1;
          }
        }
      }
    }
    AppMethodBeat.o(214675);
    return bool2;
  }
  
  final boolean b(i.a parama)
  {
    AppMethodBeat.i(214676);
    bool1 = false;
    try
    {
      bool2 = this.Srk.a(parama);
      bool1 = bool2;
      h.i("sensor_TuringSMIImpl", "[method: stopMasterEngine ] ");
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        boolean bool2 = bool1;
        if (this.SqM != null)
        {
          bool2 = bool1;
          if (this.SqM.SqP != null)
          {
            this.SqM.SqP.b(parama, "stop");
            bool2 = bool1;
          }
        }
      }
    }
    AppMethodBeat.o(214676);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.l
 * JD-Core Version:    0.7.0.1
 */