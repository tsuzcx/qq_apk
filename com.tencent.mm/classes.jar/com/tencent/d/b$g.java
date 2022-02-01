package com.tencent.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

public final class b$g
{
  private ArrayList Gzn;
  private HashMap RIA;
  private HashMap RIB;
  private Long RIC;
  private ArrayList RID;
  private HashMap RIu;
  private Boolean RIv;
  private Boolean RIw;
  private Boolean RIx;
  private Long RIy;
  private Long RIz;
  private String editId;
  private String iiv;
  private String thumbPath;
  
  static g x(HashMap paramHashMap)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196104);
    g localg = new g();
    localg.editId = ((String)paramHashMap.get("editId"));
    localg.RIu = ((HashMap)paramHashMap.get("editData"));
    localg.thumbPath = ((String)paramHashMap.get("thumbPath"));
    localg.RIv = ((Boolean)paramHashMap.get("enableOriginAudio"));
    localg.RIw = ((Boolean)paramHashMap.get("enableVideoEnhanceMent"));
    localg.iiv = ((String)paramHashMap.get("musicPath"));
    localg.RIx = ((Boolean)paramHashMap.get("needPlay"));
    Object localObject1 = paramHashMap.get("playEndMs");
    if (localObject1 == null)
    {
      localObject1 = null;
      localg.RIy = ((Long)localObject1);
      localObject1 = paramHashMap.get("playStartMs");
      if (localObject1 == null)
      {
        localObject1 = null;
        localg.RIz = ((Long)localObject1);
        localg.Gzn = ((ArrayList)paramHashMap.get("trackList"));
        localg.RIA = ((HashMap)paramHashMap.get("videoTemplateInfoProto"));
        localg.RIB = ((HashMap)paramHashMap.get("outputConfig"));
        localObject1 = paramHashMap.get("exportStartTime");
        if (localObject1 != null) {
          break label307;
        }
        localObject1 = localObject2;
        localg.RIC = ((Long)localObject1);
        localg.RID = ((ArrayList)paramHashMap.get("labelList"));
        AppMethodBeat.o(196104);
        return localg;
      }
    }
    else
    {
      if ((localObject1 instanceof Integer)) {}
      for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
      {
        localObject1 = Long.valueOf(l);
        break;
      }
    }
    if ((localObject1 instanceof Integer)) {}
    for (long l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
    {
      localObject1 = Long.valueOf(l);
      break;
    }
    label307:
    if ((localObject1 instanceof Integer)) {}
    for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
    {
      localObject1 = Long.valueOf(l);
      break;
    }
  }
  
  public final String aQn()
  {
    return this.thumbPath;
  }
  
  public final String hjD()
  {
    return this.editId;
  }
  
  public final HashMap hjE()
  {
    return this.RIu;
  }
  
  public final Boolean hjF()
  {
    return this.RIv;
  }
  
  public final Boolean hjG()
  {
    return this.RIw;
  }
  
  public final String hjH()
  {
    return this.iiv;
  }
  
  public final Boolean hjI()
  {
    return this.RIx;
  }
  
  public final Long hjJ()
  {
    return this.RIy;
  }
  
  public final Long hjK()
  {
    return this.RIz;
  }
  
  public final ArrayList hjL()
  {
    return this.Gzn;
  }
  
  public final HashMap hjM()
  {
    return this.RIB;
  }
  
  public final Long hjN()
  {
    return this.RIC;
  }
  
  public final ArrayList hjO()
  {
    return this.RID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.b.g
 * JD-Core Version:    0.7.0.1
 */