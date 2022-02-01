package com.tencent.maas.instamovie.mediafoundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum a
{
  private static final Map<Integer, a> intToTypeMap;
  public int id;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(216894);
    eFu = new a("LinearPCM", 0, 0);
    eFv = new a("AC3", 1, 1);
    eFw = new a("AC360958", 2, 2);
    eFx = new a("AppleIMA4", 3, 3);
    eFy = new a("MPEG4AAC", 4, 4);
    eFz = new a("MPEG4CELP", 5, 5);
    eFA = new a("MPEG4HVXC", 6, 6);
    eFB = new a("MPEG4TwinVQ", 7, 7);
    eFC = new a("MACE3", 8, 8);
    eFD = new a("MACE6", 9, 9);
    eFE = new a("ULaw", 10, 10);
    eFF = new a("ALaw", 11, 11);
    eFG = new a("QDesign", 12, 12);
    eFH = new a("QDesign2", 13, 13);
    eFI = new a("QUALCOMM", 14, 14);
    eFJ = new a("MPEGLayer1", 15, 15);
    eFK = new a("MPEGLayer2", 16, 16);
    eFL = new a("MPEGLayer3", 17, 17);
    eFM = new a("AppleLossless", 18, 18);
    eFN = new a("AMR", 19, 19);
    eFO = new a("Audible", 20, 20);
    eFP = new a("iLBC", 21, 21);
    eFQ = new a("DVIIntelIMA", 22, 22);
    eFR = new a("MicrosoftGSM", 23, 23);
    eFS = new a("AES3", 24, 24);
    eFT = new a[] { eFu, eFv, eFw, eFx, eFy, eFz, eFA, eFB, eFC, eFD, eFE, eFF, eFG, eFH, eFI, eFJ, eFK, eFL, eFM, eFN, eFO, eFP, eFQ, eFR, eFS };
    intToTypeMap = new HashMap();
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    while (i < j)
    {
      a locala = arrayOfa[i];
      intToTypeMap.put(Integer.valueOf(locala.id), locala);
      i += 1;
    }
    AppMethodBeat.o(216894);
  }
  
  private a(int paramInt)
  {
    this.id = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.instamovie.mediafoundation.a
 * JD-Core Version:    0.7.0.1
 */