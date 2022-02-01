package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  static a kLy;
  float aTL;
  float aTM;
  FaceTracker kLA;
  ExecutorService kLB;
  HashMap<String, Float> kLC;
  d kLz;
  
  public a()
  {
    AppMethodBeat.i(188330);
    this.kLB = Executors.newSingleThreadExecutor();
    this.aTL = -1.0F;
    this.aTM = -1.0F;
    this.kLC = new HashMap(1);
    AppMethodBeat.o(188330);
  }
  
  public static int a(a parama)
  {
    AppMethodBeat.i(221280);
    switch (1.kLJ[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(221280);
      return -1;
    case 1: 
      AppMethodBeat.o(221280);
      return 0;
    case 2: 
      AppMethodBeat.o(221280);
      return 1;
    case 3: 
      AppMethodBeat.o(221280);
      return 2;
    case 4: 
      AppMethodBeat.o(221280);
      return 3;
    case 5: 
      AppMethodBeat.o(221280);
      return 4;
    case 6: 
      AppMethodBeat.o(221280);
      return 5;
    case 7: 
      AppMethodBeat.o(221280);
      return 6;
    }
    AppMethodBeat.o(221280);
    return 7;
  }
  
  public static a bkf()
  {
    try
    {
      AppMethodBeat.i(188331);
      if (kLy == null) {
        kLy = new a();
      }
      a locala = kLy;
      AppMethodBeat.o(188331);
      return locala;
    }
    finally {}
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(221279);
      kLK = new a("ResultOK", 0);
      kLL = new a("ResultNotInit", 1);
      kLM = new a("ResultInited", 2);
      kLO = new a("ResultInitFail", 3);
      mcI = new a("ResultNoLicense", 4);
      mcJ = new a("ResultFaceDetectedFail", 5);
      mcK = new a("ResultStopFail", 6);
      mnX = new a("ResultUndefinedError", 7);
      mnZ = new a[] { kLK, kLL, kLM, kLO, mcI, mcJ, mcK, mnX };
      AppMethodBeat.o(221279);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */