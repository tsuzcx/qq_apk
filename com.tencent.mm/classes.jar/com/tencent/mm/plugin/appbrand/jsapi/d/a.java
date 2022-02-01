package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  static a kON;
  float aTL;
  float aTM;
  e kOO;
  FaceTracker kOP;
  ExecutorService kOQ;
  HashMap<String, Float> kOR;
  
  public a()
  {
    AppMethodBeat.i(222456);
    this.kOQ = Executors.newSingleThreadExecutor();
    this.aTL = -1.0F;
    this.aTM = -1.0F;
    this.kOR = new HashMap(1);
    AppMethodBeat.o(222456);
  }
  
  public static int a(a parama)
  {
    AppMethodBeat.i(222458);
    switch (1.kOS[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(222458);
      return -1;
    case 1: 
      AppMethodBeat.o(222458);
      return 0;
    case 2: 
      AppMethodBeat.o(222458);
      return 1;
    case 3: 
      AppMethodBeat.o(222458);
      return 2;
    case 4: 
      AppMethodBeat.o(222458);
      return 3;
    case 5: 
      AppMethodBeat.o(222458);
      return 4;
    case 6: 
      AppMethodBeat.o(222458);
      return 5;
    case 7: 
      AppMethodBeat.o(222458);
      return 6;
    }
    AppMethodBeat.o(222458);
    return 7;
  }
  
  public static a bkO()
  {
    try
    {
      AppMethodBeat.i(222457);
      if (kON == null) {
        kON = new a();
      }
      a locala = kON;
      AppMethodBeat.o(222457);
      return locala;
    }
    finally {}
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(222455);
      kOT = new a("ResultOK", 0);
      kOU = new a("ResultNotInit", 1);
      kOV = new a("ResultInited", 2);
      kOW = new a("ResultInitFail", 3);
      kOX = new a("ResultNoLicense", 4);
      kOY = new a("ResultFaceDetectedFail", 5);
      kOZ = new a("ResultStopFail", 6);
      kPa = new a("ResultUndefinedError", 7);
      kPb = new a[] { kOT, kOU, kOV, kOW, kOX, kOY, kOZ, kPa };
      AppMethodBeat.o(222455);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */