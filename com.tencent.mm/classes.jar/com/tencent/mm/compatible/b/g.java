package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oj;
import com.tencent.mm.autogen.a.oj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class g
{
  private static volatile g lQk;
  private static boolean lQm;
  private static boolean lQn;
  private static boolean lQo;
  private static boolean lQp;
  private static int lQr;
  private static int lQs;
  private static HashMap<Integer, String> lQt;
  private static int lQu;
  private static int lQv;
  private static HashMap<Integer, String> lQw;
  private static int lQx;
  private static int lQy;
  private static HashMap<Integer, String> lQz;
  private int lQl = -1;
  private int lQq = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    lQk = null;
    lQm = false;
    lQn = false;
    lQo = false;
    lQp = false;
    lQr = 0;
    lQs = 0;
    lQt = new HashMap();
    lQu = 0;
    lQv = 0;
    lQw = new HashMap();
    lQx = 0;
    lQy = 0;
    lQz = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g aOf()
  {
    AppMethodBeat.i(155571);
    if (lQk == null) {}
    try
    {
      if (lQk == null)
      {
        MMApplicationContext.getContext();
        lQk = new g();
      }
      g localg = lQk;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean aOg()
  {
    return false;
  }
  
  private static void aOh()
  {
    AppMethodBeat.i(155608);
    oj localoj = new oj();
    if (lQr - lQs > 1)
    {
      localoj.hQY.hQZ = true;
      localoj.hQY.hRa = lQt.size();
    }
    if (lQx - lQy > 1)
    {
      localoj.hQY.hRb = true;
      localoj.hQY.hRc = lQz.size();
    }
    if (lQu - lQv > 1)
    {
      localoj.hQY.hRd = true;
      localoj.hQY.hRe = lQw.size();
    }
    if ((localoj.hQY.hRb) || (localoj.hQY.hQZ) || (localoj.hQY.hRd))
    {
      Log.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(localoj.hQY.hQZ), Integer.valueOf(localoj.hQY.hRa), Boolean.valueOf(localoj.hQY.hRb), Integer.valueOf(localoj.hQY.hRc), Boolean.valueOf(localoj.hQY.hRd), Integer.valueOf(localoj.hQY.hRe) });
      localoj.publish();
    }
    AppMethodBeat.o(155608);
  }
  
  public static String aOi()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(lQt.size()).append("init: ").append(lQr).append("release: ").append(lQs).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!lQt.isEmpty())
    {
      localIterator = lQt.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(lQz.size()).append("init: ").append(lQx).append("release: ").append(lQy).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!lQz.isEmpty())
    {
      localIterator = lQz.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(lQw.size()).append("init: ").append(lQu).append("release: ").append(lQu).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!lQw.isEmpty())
    {
      localIterator = lQw.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    Log.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void qJ(int paramInt)
  {
    AppMethodBeat.i(155602);
    lQr += 1;
    Log.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(lQr), Integer.valueOf(lQs) });
    lQt.put(Integer.valueOf(paramInt), Util.getStack().toString());
    aOh();
    AppMethodBeat.o(155602);
  }
  
  public static void qK(int paramInt)
  {
    AppMethodBeat.i(155603);
    lQs += 1;
    Log.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(lQr), Integer.valueOf(lQs) });
    lQt.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void qL(int paramInt)
  {
    AppMethodBeat.i(155604);
    lQu += 1;
    Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(lQu), Integer.valueOf(lQv) });
    lQw.put(Integer.valueOf(paramInt), Util.getStack().toString());
    aOh();
    AppMethodBeat.o(155604);
  }
  
  public static void qM(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (lQw.containsKey(Integer.valueOf(paramInt)))
    {
      lQv += 1;
      Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(lQu), Integer.valueOf(lQv) });
      lQw.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void qN(int paramInt)
  {
    AppMethodBeat.i(155606);
    lQx += 1;
    Log.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(lQx), Integer.valueOf(lQy) });
    lQz.put(Integer.valueOf(paramInt), Util.getStack().toString());
    aOh();
    AppMethodBeat.o(155606);
  }
  
  public static void qO(int paramInt)
  {
    AppMethodBeat.i(155607);
    lQy += 1;
    Log.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(lQx), Integer.valueOf(lQy) });
    lQz.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */