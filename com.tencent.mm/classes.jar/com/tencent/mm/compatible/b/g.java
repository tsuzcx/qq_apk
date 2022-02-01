package com.tencent.mm.compatible.b;

import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nc;
import com.tencent.mm.f.a.nc.a;
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
  private static volatile g jmZ;
  private static boolean jnb;
  private static boolean jnc;
  private static boolean jnd;
  private static boolean jne;
  private static int jng;
  private static int jnh;
  private static HashMap<Integer, String> jnj;
  private static int jnk;
  private static int jnl;
  private static HashMap<Integer, String> jnm;
  private static int jnn;
  private static int jno;
  private static HashMap<Integer, String> jnp;
  private int jna = -1;
  private int jnf = 0;
  
  static
  {
    AppMethodBeat.i(155610);
    jmZ = null;
    jnb = false;
    jnc = false;
    jnd = false;
    jne = false;
    jng = 0;
    jnh = 0;
    jnj = new HashMap();
    jnk = 0;
    jnl = 0;
    jnm = new HashMap();
    jnn = 0;
    jno = 0;
    jnp = new HashMap();
    AppMethodBeat.o(155610);
  }
  
  public static g atH()
  {
    AppMethodBeat.i(155571);
    if (jmZ == null) {}
    try
    {
      if (jmZ == null)
      {
        MMApplicationContext.getContext();
        jmZ = new g();
      }
      g localg = jmZ;
      AppMethodBeat.o(155571);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(155571);
    }
  }
  
  public static boolean atI()
  {
    return false;
  }
  
  private static void atJ()
  {
    AppMethodBeat.i(155608);
    nc localnc = new nc();
    if (jng - jnh > 1)
    {
      localnc.fLq.fLr = true;
      localnc.fLq.fLs = jnj.size();
    }
    if (jnn - jno > 1)
    {
      localnc.fLq.fLt = true;
      localnc.fLq.fLu = jnp.size();
    }
    if (jnk - jnl > 1)
    {
      localnc.fLq.fLv = true;
      localnc.fLq.fLw = jnm.size();
    }
    if ((localnc.fLq.fLt) || (localnc.fLq.fLr) || (localnc.fLq.fLv))
    {
      Log.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", new Object[] { Boolean.valueOf(localnc.fLq.fLr), Integer.valueOf(localnc.fLq.fLs), Boolean.valueOf(localnc.fLq.fLt), Integer.valueOf(localnc.fLq.fLu), Boolean.valueOf(localnc.fLq.fLv), Integer.valueOf(localnc.fLq.fLw) });
      EventCenter.instance.publish(localnc);
    }
    AppMethodBeat.o(155608);
  }
  
  public static String atK()
  {
    AppMethodBeat.i(155609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(jnj.size()).append("init: ").append(jng).append("release: ").append(jnh).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!jnj.isEmpty())
    {
      localIterator = jnj.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(jnp.size()).append("init: ").append(jnn).append("release: ").append(jno).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!jnp.isEmpty())
    {
      localIterator = jnp.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("AudioRecord: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(jnm.size()).append("init: ").append(jnk).append("release: ").append(jnk).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!jnm.isEmpty())
    {
      localIterator = jnm.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    Log.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    AppMethodBeat.o(155609);
    return localObject;
  }
  
  public static void qD(int paramInt)
  {
    AppMethodBeat.i(155602);
    jng += 1;
    Log.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(jng), Integer.valueOf(jnh) });
    jnj.put(Integer.valueOf(paramInt), Util.getStack().toString());
    atJ();
    AppMethodBeat.o(155602);
  }
  
  public static void qE(int paramInt)
  {
    AppMethodBeat.i(155603);
    jnh += 1;
    Log.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(jng), Integer.valueOf(jnh) });
    jnj.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155603);
  }
  
  public static void qF(int paramInt)
  {
    AppMethodBeat.i(155604);
    jnk += 1;
    Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(jnk), Integer.valueOf(jnl) });
    jnm.put(Integer.valueOf(paramInt), Util.getStack().toString());
    atJ();
    AppMethodBeat.o(155604);
  }
  
  public static void qG(int paramInt)
  {
    AppMethodBeat.i(155605);
    if (jnm.containsKey(Integer.valueOf(paramInt)))
    {
      jnl += 1;
      Log.printInfoStack("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(jnk), Integer.valueOf(jnl) });
      jnm.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(155605);
  }
  
  public static void qH(int paramInt)
  {
    AppMethodBeat.i(155606);
    jnn += 1;
    Log.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(jnn), Integer.valueOf(jno) });
    jnp.put(Integer.valueOf(paramInt), Util.getStack().toString());
    atJ();
    AppMethodBeat.o(155606);
  }
  
  public static void qI(int paramInt)
  {
    AppMethodBeat.i(155607);
    jno += 1;
    Log.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(jnn), Integer.valueOf(jno) });
    jnp.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(155607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.g
 * JD-Core Version:    0.7.0.1
 */