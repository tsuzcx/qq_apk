package com.tencent.mm.compatible.b;

import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.a;
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
  private static volatile g fVH;
  private static boolean fVJ;
  private static boolean fVK;
  private static boolean fVL;
  private static boolean fVM;
  private static int fVO;
  private static int fVP;
  private static HashMap<Integer, String> fVQ;
  private static int fVR;
  private static int fVS;
  private static HashMap<Integer, String> fVT;
  private static int fVU;
  private static int fVV;
  private static HashMap<Integer, String> fVW;
  private int fVI = -1;
  private int fVN = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    fVH = null;
    fVJ = false;
    fVK = false;
    fVL = false;
    fVM = false;
    fVO = 0;
    fVP = 0;
    fVQ = new HashMap();
    fVR = 0;
    fVS = 0;
    fVT = new HashMap();
    fVU = 0;
    fVV = 0;
    fVW = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g ZJ()
  {
    AppMethodBeat.i(155571);
    if (fVH == null) {}
    try
    {
      if (fVH == null)
      {
        aj.getContext();
        fVH = new g();
      }
      g localg = fVH;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean ZK()
  {
    return false;
  }
  
  private static void ZL()
  {
    AppMethodBeat.i(155608);
    lu locallu = new lu();
    if (fVO - fVP > 1)
    {
      locallu.dzc.dzd = true;
      locallu.dzc.dze = fVQ.size();
    }
    if (fVU - fVV > 1)
    {
      locallu.dzc.dzf = true;
      locallu.dzc.dzg = fVW.size();
    }
    if (fVR - fVS > 1)
    {
      locallu.dzc.dzh = true;
      locallu.dzc.dzi = fVT.size();
    }
    if ((locallu.dzc.dzf) || (locallu.dzc.dzd) || (locallu.dzc.dzh))
    {
      ad.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(locallu.dzc.dzd), Integer.valueOf(locallu.dzc.dze), Boolean.valueOf(locallu.dzc.dzf), Integer.valueOf(locallu.dzc.dzg), Boolean.valueOf(locallu.dzc.dzh), Integer.valueOf(locallu.dzc.dzi) });
      a.IbL.l(locallu);
    }
    AppMethodBeat.o(155608);
  }
  
  public static String ZM()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fVQ.size()).append("init: ").append(fVO).append("release: ").append(fVP).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!fVQ.isEmpty())
    {
      localIterator = fVQ.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fVW.size()).append("init: ").append(fVU).append("release: ").append(fVV).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fVW.isEmpty())
    {
      localIterator = fVW.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fVT.size()).append("init: ").append(fVR).append("release: ").append(fVR).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fVT.isEmpty())
    {
      localIterator = fVT.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    ad.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void lk(int paramInt)
  {
    AppMethodBeat.i(155602);
    fVO += 1;
    ad.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fVO), Integer.valueOf(fVP) });
    fVQ.put(Integer.valueOf(paramInt), bt.flS().toString());
    ZL();
    AppMethodBeat.o(155602);
  }
  
  public static void ll(int paramInt)
  {
    AppMethodBeat.i(155603);
    fVP += 1;
    ad.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fVO), Integer.valueOf(fVP) });
    fVQ.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void lm(int paramInt)
  {
    AppMethodBeat.i(155604);
    fVR += 1;
    ad.m("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fVR), Integer.valueOf(fVS) });
    fVT.put(Integer.valueOf(paramInt), bt.flS().toString());
    ZL();
    AppMethodBeat.o(155604);
  }
  
  public static void ln(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (fVT.containsKey(Integer.valueOf(paramInt)))
    {
      fVS += 1;
      ad.m("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fVR), Integer.valueOf(fVS) });
      fVT.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void lo(int paramInt)
  {
    AppMethodBeat.i(155606);
    fVU += 1;
    ad.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fVU), Integer.valueOf(fVV) });
    fVW.put(Integer.valueOf(paramInt), bt.flS().toString());
    ZL();
    AppMethodBeat.o(155606);
  }
  
  public static void lp(int paramInt)
  {
    AppMethodBeat.i(155607);
    fVV += 1;
    ad.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fVU), Integer.valueOf(fVV) });
    fVW.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */