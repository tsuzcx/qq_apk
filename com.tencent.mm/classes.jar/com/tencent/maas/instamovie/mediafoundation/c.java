package com.tencent.maas.instamovie.mediafoundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static final Map<Integer, c> intToTypeMap;
  public int type;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(216897);
    eGg = new c("MP4", 0, 0);
    eGh = new c("MOV", 1, 1);
    eGi = new c("MP3", 2, 2);
    eGj = new c("M4A", 3, 3);
    eGk = new c[] { eGg, eGh, eGi, eGj };
    intToTypeMap = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      intToTypeMap.put(Integer.valueOf(localc.type), localc);
      i += 1;
    }
    AppMethodBeat.o(216897);
  }
  
  private c(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.mediafoundation.c
 * JD-Core Version:    0.7.0.1
 */