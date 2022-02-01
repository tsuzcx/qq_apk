package com.tencent.mm.live.core.core;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/LiveWatchDog;", "", "()V", "TAG", "", "qosInfoQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "cleanQosQueue", "", "dumpLastQosInfo", "dumpQosInfoQueue", "fillQosInfo", "qosInfo", "params", "Landroid/os/Bundle;", "genQosInfo", "bundle", "markQosInfo", "plugin-core_release"})
public final class f
{
  private static final String TAG = "MicroMsg.LiveWatchDog";
  private static final LinkedList<c> hyr;
  public static final f hys;
  
  static
  {
    AppMethodBeat.i(196417);
    hys = new f();
    TAG = "MicroMsg.LiveWatchDog";
    hyr = new LinkedList();
    AppMethodBeat.o(196417);
  }
  
  public final LinkedList<c> aDk()
  {
    try
    {
      AppMethodBeat.i(196414);
      LinkedList localLinkedList = new LinkedList((Collection)hyr);
      AppMethodBeat.o(196414);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c aDl()
  {
    try
    {
      AppMethodBeat.i(196415);
      c localc = (c)j.kv((List)hyr);
      AppMethodBeat.o(196415);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void aDm()
  {
    try
    {
      AppMethodBeat.i(196416);
      hyr.clear();
      AppMethodBeat.o(196416);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void w(Bundle paramBundle)
  {
    long l3 = 0L;
    label703:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(196413);
        Log.i(TAG, "markQosInfo qosInfoQueue.size:" + hyr.size() + ' ' + paramBundle);
        LinkedList localLinkedList = hyr;
        c localc = new c((byte)0);
        long l1;
        if (paramBundle != null)
        {
          localObject = e.j.hyq;
          l1 = paramBundle.getLong(e.j.aDc(), 0L);
          if (paramBundle != null)
          {
            localObject = e.j.hyq;
            l2 = paramBundle.getLong(e.j.aCY(), 0L);
            localc.hyH = l2;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.j.hyq;
            i = paramBundle.getInt(e.j.aCZ(), 0);
            localc.role = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.j.hyq;
            i = paramBundle.getInt(e.j.aDa(), 0);
            localc.mode = i;
            if (paramBundle == null) {
              continue;
            }
            localObject = e.j.hyq;
            i = paramBundle.getInt(e.j.aDi(), 0);
            localc.netType = i;
            l2 = l3;
            if (paramBundle != null)
            {
              localObject = e.j.hyq;
              l2 = paramBundle.getLong(e.j.aDb(), 0L);
            }
            localc.timestamps = l2;
            localc.hyX = ((int)(l1 / 1000L));
            localc.hyV = (System.currentTimeMillis() - l1);
            if (paramBundle == null) {
              continue;
            }
            localObject = paramBundle.getString("CPU_USAGE");
            if (localObject != null) {
              localc.hze = Util.safeParseInt((String)j.ks(n.b((CharSequence)localObject, new String[] { "/" })));
            }
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_WIDTH");
            localc.width = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_HEIGHT");
            localc.height = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_FPS");
            localc.hyI = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_GOP");
            localc.hyJ = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_BITRATE");
            localc.hyK = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AUDIO_BITRATE");
            localc.hyL = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("NET_SPEED");
            localc.hyM = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("VIDEO_CACHE");
            localc.hyN = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AUDIO_CACHE");
            localc.hyO = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("V_SUM_CACHE_SIZE");
            localc.hyP = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AV_PLAY_INTERVAL");
            localc.hyQ = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("AV_RECV_INTERVAL");
            localc.hyR = i;
            if (paramBundle == null) {
              continue;
            }
            f = paramBundle.getFloat("AUDIO_CACHE_THRESHOLD");
            localc.hyS = ((int)f);
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("NET_JITTER");
            localc.hyT = i;
            if (paramBundle == null) {
              continue;
            }
            i = paramBundle.getInt("NET_QUALITY_LEVEL");
            localc.hyU = i;
            if (paramBundle == null) {
              break label703;
            }
            localObject = paramBundle.getString("SERVER_IP");
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              break label703;
            }
            localc.hzc = paramBundle;
            localLinkedList.add(localc);
            AppMethodBeat.o(196413);
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
        paramBundle = "";
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f
 * JD-Core Version:    0.7.0.1
 */