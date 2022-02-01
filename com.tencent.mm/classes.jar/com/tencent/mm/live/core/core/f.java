package com.tencent.mm.live.core.core;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/LiveWatchDog;", "", "()V", "TAG", "", "qosInfoQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "cleanQosQueue", "", "dumpLastQosInfo", "dumpQosInfoQueue", "fillQosInfo", "qosInfo", "params", "Landroid/os/Bundle;", "genQosInfo", "bundle", "markQosInfo", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  public static final f mMm;
  private static final LinkedList<e> mMn;
  
  static
  {
    AppMethodBeat.i(247856);
    mMm = new f();
    TAG = "MicroMsg.LiveWatchDog";
    mMn = new LinkedList();
    AppMethodBeat.o(247856);
  }
  
  public final void K(Bundle paramBundle)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(247874);
        Log.i(TAG, "markQosInfo qosInfoQueue.size:" + mMn.size() + ' ' + paramBundle);
        LinkedList localLinkedList = mMn;
        e locale = new e((byte)0);
        if (paramBundle == null)
        {
          l1 = 0L;
          break label891;
          Object localObject1;
          locale.mMJ = localObject1;
          if (paramBundle == null)
          {
            i = 0;
            locale.role = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mode = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.netType = i;
            if (paramBundle != null) {
              continue;
            }
            l2 = 0L;
            locale.timestamps = l2;
            locale.mMZ = ((int)(l1 / 1000L));
            locale.mMX = (System.currentTimeMillis() - l1);
            if (paramBundle != null) {
              continue;
            }
            localObject2 = null;
            if (localObject2 == null) {
              break label901;
            }
            locale.mNg = Util.safeParseInt((String)p.oK(n.b((CharSequence)localObject2, new String[] { "/" })));
            locale.mNh = Util.safeParseInt((String)p.oM(n.b((CharSequence)localObject2, new String[] { "/" })));
            break label901;
            locale.width = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.height = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMK = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mML = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMM = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMN = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMO = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMP = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMQ = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMR = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMS = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMT = i;
            if (paramBundle != null) {
              continue;
            }
            f = 0.0F;
            locale.mMU = ((int)f);
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMV = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mMW = i;
            if (paramBundle != null) {
              continue;
            }
            localObject2 = "";
            locale.mNe = ((String)localObject2);
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.mNc = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.upLoss = i;
            if (paramBundle != null) {
              continue;
            }
            i = 0;
            locale.downLoss = i;
            if (paramBundle != null) {
              continue;
            }
            l1 = 0L;
            locale.sendBytes = l1;
            if (paramBundle != null) {
              continue;
            }
            l1 = 0L;
            locale.receiveBytes = l1;
            localLinkedList.add(locale);
            AppMethodBeat.o(247874);
          }
        }
        else
        {
          localObject2 = e.s.mLT;
          l1 = paramBundle.getLong(e.s.bdQ(), 0L);
          break label891;
          localObject2 = e.s.mLT;
          l2 = paramBundle.getLong(e.s.bdM(), 0L);
          continue;
        }
        Object localObject2 = e.s.mLT;
        i = paramBundle.getInt(e.s.bdN(), 0);
        continue;
        localObject2 = e.s.mLT;
        i = paramBundle.getInt(e.s.bdO(), 0);
        continue;
        localObject2 = e.s.mLT;
        i = paramBundle.getInt(e.s.bdW(), 0);
        continue;
        localObject2 = e.s.mLT;
        l2 = paramBundle.getLong(e.s.bdP(), 0L);
        continue;
        localObject2 = paramBundle.getString("CPU_USAGE");
        continue;
        i = paramBundle.getInt("VIDEO_WIDTH");
        continue;
        i = paramBundle.getInt("VIDEO_HEIGHT");
        continue;
        i = paramBundle.getInt("VIDEO_FPS");
        continue;
        i = paramBundle.getInt("VIDEO_GOP");
        continue;
        i = paramBundle.getInt("VIDEO_BITRATE");
        continue;
        i = paramBundle.getInt("AUDIO_BITRATE");
        continue;
        i = paramBundle.getInt("NET_SPEED");
        continue;
        i = paramBundle.getInt("VIDEO_CACHE");
        continue;
        i = paramBundle.getInt("AUDIO_CACHE");
        continue;
        i = paramBundle.getInt("V_SUM_CACHE_SIZE");
        continue;
        i = paramBundle.getInt("AV_PLAY_INTERVAL");
        continue;
        i = paramBundle.getInt("AV_RECV_INTERVAL");
        continue;
        float f = paramBundle.getFloat("AUDIO_CACHE_THRESHOLD");
        continue;
        i = paramBundle.getInt("NET_JITTER");
        continue;
        i = paramBundle.getInt("NET_QUALITY_LEVEL");
        continue;
        String str = paramBundle.getString("SERVER_IP");
        localObject2 = str;
        if (str != null) {
          continue;
        }
        localObject2 = "";
        continue;
        localObject2 = e.s.mLT;
        i = paramBundle.getInt(e.s.bdR());
        continue;
        localObject2 = e.s.mLT;
        i = paramBundle.getInt(e.s.bdS());
        continue;
        localObject2 = e.s.mLT;
        i = paramBundle.getInt(e.s.bdT());
        continue;
        localObject2 = e.s.mLT;
        long l1 = paramBundle.getLong(e.s.bdU());
        continue;
        localObject2 = e.s.mLT;
        l1 = paramBundle.getLong(e.s.bdV());
        continue;
        if (paramBundle != null) {
          continue;
        }
      }
      finally {}
      label891:
      long l2 = 0L;
      continue;
      label901:
      if (paramBundle == null) {
        i = 0;
      }
    }
  }
  
  public final LinkedList<e> bed()
  {
    try
    {
      AppMethodBeat.i(247880);
      LinkedList localLinkedList = new LinkedList((Collection)mMn);
      AppMethodBeat.o(247880);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final e bee()
  {
    try
    {
      AppMethodBeat.i(247885);
      e locale = (e)p.oN((List)mMn);
      AppMethodBeat.o(247885);
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bef()
  {
    try
    {
      AppMethodBeat.i(247886);
      mMn.clear();
      AppMethodBeat.o(247886);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f
 * JD-Core Version:    0.7.0.1
 */