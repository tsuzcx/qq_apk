package com.tencent.mm.compatible.b;

import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class g
{
  private static volatile g fXN;
  private static boolean fXP;
  private static boolean fXQ;
  private static boolean fXR;
  private static boolean fXS;
  private static int fXU;
  private static int fXV;
  private static HashMap<Integer, String> fXW;
  private static int fXX;
  private static int fXY;
  private static HashMap<Integer, String> fXZ;
  private static int fYa;
  private static int fYb;
  private static HashMap<Integer, String> fYc;
  private int fXO = -1;
  private int fXT = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    fXN = null;
    fXP = false;
    fXQ = false;
    fXR = false;
    fXS = false;
    fXU = 0;
    fXV = 0;
    fXW = new HashMap();
    fXX = 0;
    fXY = 0;
    fXZ = new HashMap();
    fYa = 0;
    fYb = 0;
    fYc = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g ZS()
  {
    AppMethodBeat.i(155571);
    if (fXN == null) {}
    try
    {
      if (fXN == null)
      {
        ak.getContext();
        fXN = new g();
      }
      g localg = fXN;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean ZT()
  {
    return false;
  }
  
  private static void ZU()
  {
    AppMethodBeat.i(155608);
    lv locallv = new lv();
    if (fXU - fXV > 1)
    {
      locallv.dAh.dAi = true;
      locallv.dAh.dAj = fXW.size();
    }
    if (fYa - fYb > 1)
    {
      locallv.dAh.dAk = true;
      locallv.dAh.dAl = fYc.size();
    }
    if (fXX - fXY > 1)
    {
      locallv.dAh.dAm = true;
      locallv.dAh.dAn = fXZ.size();
    }
    if ((locallv.dAh.dAk) || (locallv.dAh.dAi) || (locallv.dAh.dAm))
    {
      ae.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(locallv.dAh.dAi), Integer.valueOf(locallv.dAh.dAj), Boolean.valueOf(locallv.dAh.dAk), Integer.valueOf(locallv.dAh.dAl), Boolean.valueOf(locallv.dAh.dAm), Integer.valueOf(locallv.dAh.dAn) });
      a.IvT.l(locallv);
    }
    AppMethodBeat.o(155608);
  }
  
  public static String ZV()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fXW.size()).append("init: ").append(fXU).append("release: ").append(fXV).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!fXW.isEmpty())
    {
      localIterator = fXW.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fYc.size()).append("init: ").append(fYa).append("release: ").append(fYb).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fYc.isEmpty())
    {
      localIterator = fYc.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fXZ.size()).append("init: ").append(fXX).append("release: ").append(fXX).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fXZ.isEmpty())
    {
      localIterator = fXZ.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    ae.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void lm(int paramInt)
  {
    AppMethodBeat.i(155602);
    fXU += 1;
    ae.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fXU), Integer.valueOf(fXV) });
    fXW.put(Integer.valueOf(paramInt), bu.fpN().toString());
    ZU();
    AppMethodBeat.o(155602);
  }
  
  public static void ln(int paramInt)
  {
    AppMethodBeat.i(155603);
    fXV += 1;
    ae.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fXU), Integer.valueOf(fXV) });
    fXW.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void lo(int paramInt)
  {
    AppMethodBeat.i(155604);
    fXX += 1;
    ae.m("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fXX), Integer.valueOf(fXY) });
    fXZ.put(Integer.valueOf(paramInt), bu.fpN().toString());
    ZU();
    AppMethodBeat.o(155604);
  }
  
  public static void lp(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (fXZ.containsKey(Integer.valueOf(paramInt)))
    {
      fXY += 1;
      ae.m("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fXX), Integer.valueOf(fXY) });
      fXZ.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void lq(int paramInt)
  {
    AppMethodBeat.i(155606);
    fYa += 1;
    ae.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fYa), Integer.valueOf(fYb) });
    fYc.put(Integer.valueOf(paramInt), bu.fpN().toString());
    ZU();
    AppMethodBeat.o(155606);
  }
  
  public static void lr(int paramInt)
  {
    AppMethodBeat.i(155607);
    fYb += 1;
    ae.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fYa), Integer.valueOf(fYb) });
    fYc.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */