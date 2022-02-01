package com.tencent.mm.compatible.b;

import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.ll.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class g
{
  private static int fCA;
  private static int fCB;
  private static HashMap<Integer, String> fCC;
  private static int fCD;
  private static int fCE;
  private static HashMap<Integer, String> fCF;
  private static int fCG;
  private static int fCH;
  private static HashMap<Integer, String> fCI;
  private static volatile g fCt;
  private static boolean fCv;
  private static boolean fCw;
  private static boolean fCx;
  private static boolean fCy;
  private int fCu = -1;
  private int fCz = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    fCt = null;
    fCv = false;
    fCw = false;
    fCx = false;
    fCy = false;
    fCA = 0;
    fCB = 0;
    fCC = new HashMap();
    fCD = 0;
    fCE = 0;
    fCF = new HashMap();
    fCG = 0;
    fCH = 0;
    fCI = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g Xi()
  {
    AppMethodBeat.i(155571);
    if (fCt == null) {}
    try
    {
      if (fCt == null)
      {
        ai.getContext();
        fCt = new g();
      }
      g localg = fCt;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean Xj()
  {
    return false;
  }
  
  private static void Xk()
  {
    AppMethodBeat.i(155608);
    ll localll = new ll();
    if (fCA - fCB > 1)
    {
      localll.dno.dnp = true;
      localll.dno.dnq = fCC.size();
    }
    if (fCG - fCH > 1)
    {
      localll.dno.dnr = true;
      localll.dno.dns = fCI.size();
    }
    if (fCD - fCE > 1)
    {
      localll.dno.dnt = true;
      localll.dno.dnu = fCF.size();
    }
    if ((localll.dno.dnr) || (localll.dno.dnp) || (localll.dno.dnt))
    {
      ac.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(localll.dno.dnp), Integer.valueOf(localll.dno.dnq), Boolean.valueOf(localll.dno.dnr), Integer.valueOf(localll.dno.dns), Boolean.valueOf(localll.dno.dnt), Integer.valueOf(localll.dno.dnu) });
      a.GpY.l(localll);
    }
    AppMethodBeat.o(155608);
  }
  
  public static String Xl()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fCC.size()).append("init: ").append(fCA).append("release: ").append(fCB).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!fCC.isEmpty())
    {
      localIterator = fCC.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fCI.size()).append("init: ").append(fCG).append("release: ").append(fCH).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fCI.isEmpty())
    {
      localIterator = fCI.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(fCF.size()).append("init: ").append(fCD).append("release: ").append(fCD).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!fCF.isEmpty())
    {
      localIterator = fCF.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    ac.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void kL(int paramInt)
  {
    AppMethodBeat.i(155602);
    fCA += 1;
    ac.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fCA), Integer.valueOf(fCB) });
    fCC.put(Integer.valueOf(paramInt), bs.eWi().toString());
    Xk();
    AppMethodBeat.o(155602);
  }
  
  public static void kM(int paramInt)
  {
    AppMethodBeat.i(155603);
    fCB += 1;
    ac.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fCA), Integer.valueOf(fCB) });
    fCC.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void kN(int paramInt)
  {
    AppMethodBeat.i(155604);
    fCD += 1;
    ac.m("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fCD), Integer.valueOf(fCE) });
    fCF.put(Integer.valueOf(paramInt), bs.eWi().toString());
    Xk();
    AppMethodBeat.o(155604);
  }
  
  public static void kO(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (fCF.containsKey(Integer.valueOf(paramInt)))
    {
      fCE += 1;
      ac.m("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fCD), Integer.valueOf(fCE) });
      fCF.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void kP(int paramInt)
  {
    AppMethodBeat.i(155606);
    fCG += 1;
    ac.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fCG), Integer.valueOf(fCH) });
    fCI.put(Integer.valueOf(paramInt), bs.eWi().toString());
    Xk();
    AppMethodBeat.o(155606);
  }
  
  public static void kQ(int paramInt)
  {
    AppMethodBeat.i(155607);
    fCH += 1;
    ac.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(fCG), Integer.valueOf(fCH) });
    fCI.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */