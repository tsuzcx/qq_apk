package com.tencent.mm.compatible.b;

import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.ml.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class g
{
  private static volatile g gCT;
  private static boolean gCV;
  private static boolean gCW;
  private static boolean gCX;
  private static boolean gCY;
  private static int gDa;
  private static int gDb;
  private static HashMap<Integer, String> gDc;
  private static int gDd;
  private static int gDe;
  private static HashMap<Integer, String> gDf;
  private static int gDg;
  private static int gDh;
  private static HashMap<Integer, String> gDi;
  private int gCU = -1;
  private int gCZ = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    gCT = null;
    gCV = false;
    gCW = false;
    gCX = false;
    gCY = false;
    gDa = 0;
    gDb = 0;
    gDc = new HashMap();
    gDd = 0;
    gDe = 0;
    gDf = new HashMap();
    gDg = 0;
    gDh = 0;
    gDi = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g anF()
  {
    AppMethodBeat.i(155571);
    if (gCT == null) {}
    try
    {
      if (gCT == null)
      {
        MMApplicationContext.getContext();
        gCT = new g();
      }
      g localg = gCT;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean anG()
  {
    return false;
  }
  
  private static void anH()
  {
    AppMethodBeat.i(155608);
    ml localml = new ml();
    if (gDa - gDb > 1)
    {
      localml.dRT.dRU = true;
      localml.dRT.dRV = gDc.size();
    }
    if (gDg - gDh > 1)
    {
      localml.dRT.dRW = true;
      localml.dRT.dRX = gDi.size();
    }
    if (gDd - gDe > 1)
    {
      localml.dRT.dRY = true;
      localml.dRT.dRZ = gDf.size();
    }
    if ((localml.dRT.dRW) || (localml.dRT.dRU) || (localml.dRT.dRY))
    {
      Log.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(localml.dRT.dRU), Integer.valueOf(localml.dRT.dRV), Boolean.valueOf(localml.dRT.dRW), Integer.valueOf(localml.dRT.dRX), Boolean.valueOf(localml.dRT.dRY), Integer.valueOf(localml.dRT.dRZ) });
      EventCenter.instance.publish(localml);
    }
    AppMethodBeat.o(155608);
  }
  
  public static String anI()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(gDc.size()).append("init: ").append(gDa).append("release: ").append(gDb).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!gDc.isEmpty())
    {
      localIterator = gDc.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(gDi.size()).append("init: ").append(gDg).append("release: ").append(gDh).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!gDi.isEmpty())
    {
      localIterator = gDi.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(gDf.size()).append("init: ").append(gDd).append("release: ").append(gDd).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!gDf.isEmpty())
    {
      localIterator = gDf.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    Log.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void oo(int paramInt)
  {
    AppMethodBeat.i(155602);
    gDa += 1;
    Log.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gDa), Integer.valueOf(gDb) });
    gDc.put(Integer.valueOf(paramInt), Util.getStack().toString());
    anH();
    AppMethodBeat.o(155602);
  }
  
  public static void op(int paramInt)
  {
    AppMethodBeat.i(155603);
    gDb += 1;
    Log.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gDa), Integer.valueOf(gDb) });
    gDc.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void oq(int paramInt)
  {
    AppMethodBeat.i(155604);
    gDd += 1;
    Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gDd), Integer.valueOf(gDe) });
    gDf.put(Integer.valueOf(paramInt), Util.getStack().toString());
    anH();
    AppMethodBeat.o(155604);
  }
  
  public static void or(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (gDf.containsKey(Integer.valueOf(paramInt)))
    {
      gDe += 1;
      Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gDd), Integer.valueOf(gDe) });
      gDf.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void os(int paramInt)
  {
    AppMethodBeat.i(155606);
    gDg += 1;
    Log.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gDg), Integer.valueOf(gDh) });
    gDi.put(Integer.valueOf(paramInt), Util.getStack().toString());
    anH();
    AppMethodBeat.o(155606);
  }
  
  public static void ot(int paramInt)
  {
    AppMethodBeat.i(155607);
    gDh += 1;
    Log.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gDg), Integer.valueOf(gDh) });
    gDi.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */