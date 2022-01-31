package com.tencent.mm.modelstat;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class c$a
{
  Map<String, Boolean> fRZ;
  long fSa;
  long fSb;
  List<c.c> fSj;
  
  private c$a()
  {
    AppMethodBeat.i(78663);
    this.fSj = new ArrayList();
    this.fRZ = new HashMap();
    AppMethodBeat.o(78663);
  }
  
  static a uF(String paramString)
  {
    AppMethodBeat.i(78665);
    a locala = new a();
    Map localMap;
    try
    {
      localMap = br.F(paramString, "eventSampleConf");
      if (localMap == null)
      {
        ab.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", new Object[] { paramString });
        paramString = new a("reportConfigMap is null");
        AppMethodBeat.o(78665);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString = new a(paramString);
      AppMethodBeat.o(78665);
      throw paramString;
    }
    locala.fSa = bo.getLong((String)localMap.get(".eventSampleConf.nextUpdateInterval"), 0L);
    if ((locala.fSa <= 0L) || (locala.fSa > 432000L)) {
      locala.fSa = 432000L;
    }
    locala.fSb = bo.getLong((String)localMap.get(".eventSampleConf.samplePeriod"), 0L);
    int i = 0;
    c.c localc = new c.c((byte)0);
    Object localObject1 = new StringBuilder(".eventSampleConf.events.event");
    label180:
    ArrayList localArrayList;
    int j;
    Object localObject2;
    if (i > 0)
    {
      paramString = Integer.valueOf(i);
      localObject1 = paramString + ".";
      localc.id = bo.getInt((String)localMap.get((String)localObject1 + "id"), 0);
      if (localc.id > 0)
      {
        localc.fSm = bo.getLong((String)localMap.get((String)localObject1 + "expireTime"), 0L);
        localc.name = ((String)localMap.get((String)localObject1 + "name"));
        localc.fSn = bo.getFloat((String)localMap.get((String)localObject1 + "rate"), 0.0F);
        localc.ezN = bo.getInt((String)localMap.get((String)localObject1 + "logId"), 0);
        localc.fSo = ((String)localMap.get((String)localObject1 + "pages.$type"));
        localArrayList = new ArrayList();
        j = 0;
        for (;;)
        {
          localObject2 = new StringBuilder().append((String)localObject1).append("pages.page");
          if (j <= 0) {
            break label819;
          }
          paramString = Integer.valueOf(j);
          label469:
          paramString = paramString + ".";
          localObject2 = (String)localMap.get(paramString + "$id");
          if (localObject2 == null) {
            break;
          }
          boolean bool = ((String)localMap.get(paramString + "$action")).equals("true");
          localArrayList.add(new Pair(localObject2, Boolean.valueOf(bool)));
          locala.fRZ.put(localObject2, Boolean.valueOf(bool));
          j += 1;
        }
        localc.fSp = localArrayList;
        localArrayList = new ArrayList();
        j = 0;
        label616:
        localObject2 = new StringBuilder().append((String)localObject1).append("specialPVPages.pageItem");
        if (j <= 0) {
          break label825;
        }
      }
    }
    label819:
    label825:
    for (paramString = Integer.valueOf(j);; paramString = "")
    {
      paramString = paramString + ".";
      localObject2 = (String)localMap.get(paramString + "$prePage");
      if (localObject2 != null)
      {
        localArrayList.add(new Pair(localObject2, (String)localMap.get(paramString + "$page")));
        j += 1;
        break label616;
      }
      localc.fSq = localArrayList;
      locala.fSj.add(localc);
      ab.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", new Object[] { localc });
      i += 1;
      break;
      ab.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", new Object[] { locala });
      AppMethodBeat.o(78665);
      return locala;
      paramString = "";
      break label180;
      paramString = "";
      break label469;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78664);
    String str = "Config{nextUpdateInterval=" + this.fSa + ", samplePeriod=" + this.fSb + ", eventList=" + this.fSj + '}';
    AppMethodBeat.o(78664);
    return str;
  }
  
  static final class a
    extends Exception
  {
    a(String paramString)
    {
      super();
    }
    
    a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.a
 * JD-Core Version:    0.7.0.1
 */