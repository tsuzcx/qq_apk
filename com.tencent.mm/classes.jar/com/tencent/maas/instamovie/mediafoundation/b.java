package com.tencent.maas.instamovie.mediafoundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum b
{
  private static Map<Integer, b> eGd;
  private static final int[][] eGe;
  public int id;
  private String name;
  
  static
  {
    AppMethodBeat.i(216901);
    eFU = new b("DIMENSION_LEVEL_144", 0, 0, "144p");
    eFV = new b("DIMENSION_LEVEL_224", 1, 1, "224p");
    eFW = new b("DIMENSION_LEVEL_360", 2, 2, "360p");
    eFX = new b("DIMENSION_LEVEL_480", 3, 3, "480p");
    eFY = new b("DIMENSION_LEVEL_540", 4, 4, "540p");
    eFZ = new b("DIMENSION_LEVEL_720", 5, 5, "720p");
    eGa = new b("DIMENSION_LEVEL_1080", 6, 6, "1080p");
    eGb = new b("DIMENSION_LEVEL_1440", 7, 7, "1440p");
    eGc = new b("DIMENSION_LEVEL_2160", 8, 8, "2160p");
    eGf = new b[] { eFU, eFV, eFW, eFX, eFY, eFZ, eGa, eGb, eGc };
    eGd = new HashMap();
    Object localObject1 = values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      eGd.put(Integer.valueOf(((b)localObject2).id), localObject2);
      i += 1;
    }
    localObject1 = new int[] { 1280, 720 };
    Object localObject2 = { 3840, 2160 };
    eGe = new int[][] { { 0, 0 }, { 256, 144 }, { 400, 224 }, { 640, 360 }, { 848, 480 }, { 960, 540 }, localObject1, { 1920, 1080 }, { 2560, 1440 }, localObject2 };
    AppMethodBeat.o(216901);
  }
  
  private b(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.name = paramString;
  }
  
  public static b mM(int paramInt)
  {
    AppMethodBeat.i(216890);
    b localb = (b)eGd.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(216890);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.mediafoundation.b
 * JD-Core Version:    0.7.0.1
 */