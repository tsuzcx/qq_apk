package com.tencent.mm.compatible.b;

import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.lc.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class g
{
  private static volatile g fyM;
  private static boolean fyO;
  private static boolean fyP;
  private static boolean fyQ;
  private static boolean fyR;
  private static int fyT;
  private static int fyU;
  private static HashMap<Integer, String> fyV;
  private static int fyW;
  private static int fyX;
  private static HashMap<Integer, String> fyY;
  private static int fyZ;
  private static int fza;
  private static HashMap<Integer, String> fzb;
  private int fyN = -1;
  private int fyS = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    fyM = null;
    fyO = false;
    fyP = false;
    fyQ = false;
    fyR = false;
    fyT = 0;
    fyU = 0;
    fyV = new HashMap();
    fyW = 0;
    fyX = 0;
    fyY = new HashMap();
    fyZ = 0;
    fza = 0;
    fzb = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g Wk()
  {
    AppMethodBeat.i(155571);
    if (fyM == null) {}
    try
    {
      if (fyM == null)
      {
        aj.getContext();
        fyM = new g();
      }
      g localg = fyM;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean Wl()
  {
    return false;
  }
  
  private static void Wm()
  {
    AppMethodBeat.i(155608);
    lc locallc = new lc();
    if (fyT - fyU > 1)
    {
      locallc.dpD.dpE = true;
      locallc.dpD.dpF = fyV.size();
    }
    if (fyZ - fza > 1)
    {
      locallc.dpD.dpG = true;
      locallc.dpD.dpH = fzb.size();
    }
    if (fyW - fyX > 1)
    {
      locallc.dpD.dpI = true;
      locallc.dpD.dpJ = fyY.size();
    }
    if ((locallc.dpD.dpG) || (locallc.dpD.dpE) || (locallc.dpD.dpI))
    {
      ad.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(locallc.dpD.dpE), Integer.valueOf(locallc.dpD.dpF), Boolean.valueOf(locallc.dpD.dpG), Integer.valueOf(locallc.dpD.dpH), Boolean.valueOf(locallc.dpD.dpI), Integer.valueOf(locallc.dpD.dpJ) });
      a.ESL.l(locallc);
    }
    AppMethodBeat.o(155608);
  }
  
  public static String Wn()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fyV.size()).append("init: ").append(fyT).append("release: ").append(fyU).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!fyV.isEmpty())
    {
      localIterator = fyV.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fzb.size()).append("init: ").append(fyZ).append("release: ").append(fza).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fzb.isEmpty())
    {
      localIterator = fzb.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fyY.size()).append("init: ").append(fyW).append("release: ").append(fyW).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fyY.isEmpty())
    {
      localIterator = fyY.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    ad.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void kR(int paramInt)
  {
    AppMethodBeat.i(155602);
    fyT += 1;
    ad.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fyT), Integer.valueOf(fyU) });
    fyV.put(Integer.valueOf(paramInt), bt.eGN().toString());
    Wm();
    AppMethodBeat.o(155602);
  }
  
  public static void kS(int paramInt)
  {
    AppMethodBeat.i(155603);
    fyU += 1;
    ad.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fyT), Integer.valueOf(fyU) });
    fyV.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void kT(int paramInt)
  {
    AppMethodBeat.i(155604);
    fyW += 1;
    ad.m("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fyW), Integer.valueOf(fyX) });
    fyY.put(Integer.valueOf(paramInt), bt.eGN().toString());
    Wm();
    AppMethodBeat.o(155604);
  }
  
  public static void kU(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (fyY.containsKey(Integer.valueOf(paramInt)))
    {
      fyX += 1;
      ad.m("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fyW), Integer.valueOf(fyX) });
      fyY.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void kV(int paramInt)
  {
    AppMethodBeat.i(155606);
    fyZ += 1;
    ad.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fyZ), Integer.valueOf(fza) });
    fzb.put(Integer.valueOf(paramInt), bt.eGN().toString());
    Wm();
    AppMethodBeat.o(155606);
  }
  
  public static void kW(int paramInt)
  {
    AppMethodBeat.i(155607);
    fza += 1;
    ad.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fyZ), Integer.valueOf(fza) });
    fzb.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */