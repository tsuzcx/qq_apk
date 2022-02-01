package com.tencent.mm.live.core.core;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/LiveWatchDog;", "", "()V", "TAG", "", "qosInfoQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "cleanQosQueue", "", "dumpLastQosInfo", "dumpQosInfoQueue", "fillQosInfo", "qosInfo", "params", "Landroid/os/Bundle;", "genQosInfo", "bundle", "markQosInfo", "plugin-core_release"})
public final class f
{
  private static final String TAG = "MicroMsg.LiveWatchDog";
  private static final LinkedList<d> klk;
  public static final f kll;
  
  static
  {
    AppMethodBeat.i(199001);
    kll = new f();
    TAG = "MicroMsg.LiveWatchDog";
    klk = new LinkedList();
    AppMethodBeat.o(199001);
  }
  
  public final void D(Bundle paramBundle)
  {
    label879:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198995);
        Log.i(TAG, "markQosInfo qosInfoQueue.size:" + klk.size() + ' ' + paramBundle);
        LinkedList localLinkedList = klk;
        d locald = new d((byte)0);
        if (paramBundle != null)
        {
          localObject = e.q.klj;
          l1 = paramBundle.getLong(e.q.aKT(), 0L);
          if (paramBundle != null)
          {
            localObject = e.q.klj;
            l2 = paramBundle.getLong(e.q.aKP(), 0L);
            locald.klE = l2;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            i = paramBundle.getInt(e.q.aKQ(), 0);
            locald.role = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            i = paramBundle.getInt(e.q.aKR(), 0);
            locald.mode = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            i = paramBundle.getInt(e.q.aKZ(), 0);
            locald.netType = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            l2 = paramBundle.getLong(e.q.aKS(), 0L);
            locald.timestamps = l2;
            locald.klU = ((int)(l1 / 1000L));
            locald.klS = (System.currentTimeMillis() - l1);
            if (paramBundle == null) {
              continue;
            }
            localObject = paramBundle.getString("CPU_USAGE");
            if (localObject != null)
            {
              locald.kmb = Util.safeParseInt((String)j.lo(n.b((CharSequence)localObject, new String[] { "/" })));
              locald.kmc = Util.safeParseInt((String)j.lq(n.b((CharSequence)localObject, new String[] { "/" })));
            }
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_WIDTH");
            locald.width = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_HEIGHT");
            locald.height = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_FPS");
            locald.klF = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_GOP");
            locald.klG = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_BITRATE");
            locald.klH = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AUDIO_BITRATE");
            locald.klI = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("NET_SPEED");
            locald.klJ = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_CACHE");
            locald.klK = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AUDIO_CACHE");
            locald.klL = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("V_SUM_CACHE_SIZE");
            locald.klM = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AV_PLAY_INTERVAL");
            locald.klN = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AV_RECV_INTERVAL");
            locald.klO = i;
            if (paramBundle == null) {
              continue;
            }
            f = paramBundle.getFloat("AUDIO_CACHE_THRESHOLD");
            locald.klP = ((int)f);
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("NET_JITTER");
            locald.klQ = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("NET_QUALITY_LEVEL");
            locald.klR = i;
            if (paramBundle == null) {
              break label879;
            }
            String str = paramBundle.getString("SERVER_IP");
            localObject = str;
            if (str == null) {
              break label879;
            }
            locald.klZ = ((String)localObject);
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            i = paramBundle.getInt(e.q.aKU());
            locald.klX = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            i = paramBundle.getInt(e.q.aKV());
            locald.upLoss = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            i = paramBundle.getInt(e.q.aKW());
            locald.downLoss = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            l1 = paramBundle.getLong(e.q.aKX());
            locald.sendBytes = l1;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.q.klj;
            l1 = paramBundle.getLong(e.q.aKY());
            locald.receiveBytes = l1;
            localLinkedList.add(locald);
            AppMethodBeat.o(198995);
          }
        }
        else
        {
          l1 = 0L;
          continue;
        }
        long l2 = 0L;
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        l2 = 0L;
        continue;
        Object localObject = null;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        float f = 0.0F;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        long l1 = 0L;
        continue;
        l1 = 0L;
        continue;
        localObject = "";
      }
      finally {}
    }
  }
  
  public final LinkedList<d> aLb()
  {
    try
    {
      AppMethodBeat.i(198996);
      LinkedList localLinkedList = new LinkedList((Collection)klk);
      AppMethodBeat.o(198996);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final d aLc()
  {
    try
    {
      AppMethodBeat.i(198997);
      d locald = (d)j.lr((List)klk);
      AppMethodBeat.o(198997);
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void aLd()
  {
    try
    {
      AppMethodBeat.i(198998);
      klk.clear();
      AppMethodBeat.o(198998);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f
 * JD-Core Version:    0.7.0.1
 */