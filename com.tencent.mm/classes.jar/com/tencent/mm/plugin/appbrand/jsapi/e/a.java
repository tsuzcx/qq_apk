package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.xeffect.FaceTracker;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  static a lTL;
  float aTD;
  float aTE;
  e lTM;
  FaceTracker lTN;
  ExecutorService lTO;
  HashMap<String, Float> lTP;
  
  public a()
  {
    AppMethodBeat.i(226760);
    this.lTO = Executors.newSingleThreadExecutor();
    this.aTD = -1.0F;
    this.aTE = -1.0F;
    this.lTP = new HashMap(1);
    AppMethodBeat.o(226760);
  }
  
  public static int a(a parama)
  {
    AppMethodBeat.i(226762);
    switch (1.lTQ[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(226762);
      return -1;
    case 1: 
      AppMethodBeat.o(226762);
      return 0;
    case 2: 
      AppMethodBeat.o(226762);
      return 1;
    case 3: 
      AppMethodBeat.o(226762);
      return 2;
    case 4: 
      AppMethodBeat.o(226762);
      return 3;
    case 5: 
      AppMethodBeat.o(226762);
      return 4;
    case 6: 
      AppMethodBeat.o(226762);
      return 5;
    case 7: 
      AppMethodBeat.o(226762);
      return 6;
    }
    AppMethodBeat.o(226762);
    return 7;
  }
  
  public static a bGl()
  {
    try
    {
      AppMethodBeat.i(226761);
      if (lTL == null) {
        lTL = new a();
      }
      a locala = lTL;
      AppMethodBeat.o(226761);
      return locala;
    }
    finally {}
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(226759);
      lTR = new a("ResultOK", 0);
      lTS = new a("ResultNotInit", 1);
      lTT = new a("ResultInited", 2);
      lTU = new a("ResultInitFail", 3);
      lTV = new a("ResultNoLicense", 4);
      lTW = new a("ResultFaceDetectedFail", 5);
      lTX = new a("ResultStopFail", 6);
      lTY = new a("ResultUndefinedError", 7);
      lTZ = new a[] { lTR, lTS, lTT, lTU, lTV, lTW, lTX, lTY };
      AppMethodBeat.o(226759);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a
 * JD-Core Version:    0.7.0.1
 */