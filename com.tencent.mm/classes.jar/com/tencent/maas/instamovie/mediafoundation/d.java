package com.tencent.maas.instamovie.mediafoundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum d
{
  private static final Map<Integer, d> intToTypeMap;
  public int id;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(216896);
    eGl = new d("H263", 0, 0);
    eGm = new d("H264", 1, 1);
    eGn = new d("HEVC", 2, 2);
    eGo = new d("MPEG4", 3, 3);
    eGp = new d("MPEG2", 4, 4);
    eGq = new d("MPEG1", 5, 5);
    eGr = new d("MJPEG", 6, 6);
    eGs = new d[] { eGl, eGm, eGn, eGo, eGp, eGq, eGr };
    intToTypeMap = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      intToTypeMap.put(Integer.valueOf(locald.id), locald);
      i += 1;
    }
    AppMethodBeat.o(216896);
  }
  
  private d(int paramInt)
  {
    this.id = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.mediafoundation.d
 * JD-Core Version:    0.7.0.1
 */