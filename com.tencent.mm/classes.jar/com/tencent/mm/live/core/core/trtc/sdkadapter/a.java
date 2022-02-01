package com.tencent.mm.live.core.core.trtc.sdkadapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.b;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.c;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.d;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;

public final class a
{
  private d koA;
  private c koB;
  private com.tencent.mm.live.core.core.trtc.sdkadapter.a.a koC;
  private b koD;
  private e koy;
  private com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a koz;
  
  public static a aLI()
  {
    AppMethodBeat.i(199667);
    a locala = a.aLN();
    AppMethodBeat.o(199667);
    return locala;
  }
  
  public final e aLJ()
  {
    AppMethodBeat.i(199669);
    if (this.koy == null) {
      this.koy = new e();
    }
    e locale = this.koy;
    AppMethodBeat.o(199669);
    return locale;
  }
  
  public final com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a aLK()
  {
    AppMethodBeat.i(199671);
    if (this.koz == null) {
      this.koz = new com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a();
    }
    com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a locala = this.koz;
    AppMethodBeat.o(199671);
    return locala;
  }
  
  public final d aLL()
  {
    AppMethodBeat.i(199673);
    if (this.koA == null) {
      this.koA = new d();
    }
    d locald = this.koA;
    AppMethodBeat.o(199673);
    return locald;
  }
  
  public final b aLM()
  {
    AppMethodBeat.i(199675);
    if (this.koD == null) {
      this.koD = new b();
    }
    b localb = this.koD;
    AppMethodBeat.o(199675);
    return localb;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(199683);
    if (this.koC == null) {
      this.koC = new com.tencent.mm.live.core.core.trtc.sdkadapter.a.a();
    }
    Object localObject = this.koC;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject).koO = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject).koP = 1;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject).koQ = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.a.a)localObject).kjm = 3;
    localObject = aLJ();
    ((e)localObject).kpi = 108;
    ((e)localObject).kpj = 15;
    ((e)localObject).mVideoBitrate = 600;
    ((e)localObject).mMinVideoBitrate = 600;
    ((e)localObject).kpk = 110;
    ((e)localObject).kpl = 15;
    ((e)localObject).kpm = 1500;
    ((e)localObject).kpn = 600;
    ((e)localObject).mQosMode = 1;
    ((e)localObject).mQosPreference = 2;
    ((e)localObject).kpo = true;
    ((e)localObject).kpp = false;
    ((e)localObject).kpq = 0;
    ((e)localObject).kpr = true;
    ((e)localObject).cIZ = false;
    ((e)localObject).kps = false;
    ((e)localObject).kpt = false;
    ((e)localObject).kpu = false;
    ((e)localObject).kpv = false;
    ((e)localObject).kpw = true;
    ((e)localObject).kpx = 0;
    ((e)localObject).kpy = true;
    ((e)localObject).kpz = false;
    ((e)localObject).kpA = 5;
    ((e)localObject).kpB = 10;
    ((e)localObject).kpC = 0;
    ((e)localObject).kpD = 0;
    localObject = aLK();
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koR = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koS = 0;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koT = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koU = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koV = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koW = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koX = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koY = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).koZ = true;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).kpa = false;
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).kpb = 2;
    aLL().reset();
    if (this.koB == null) {
      this.koB = new c();
    }
    this.koB.kpd = false;
    aLM().kpc = -1;
    AppMethodBeat.o(199683);
  }
  
  public static final class a
  {
    private static a koE;
    
    static
    {
      AppMethodBeat.i(200895);
      koE = new a((byte)0);
      AppMethodBeat.o(200895);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.a
 * JD-Core Version:    0.7.0.1
 */