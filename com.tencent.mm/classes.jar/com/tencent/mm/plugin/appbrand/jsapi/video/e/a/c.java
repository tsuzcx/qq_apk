package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "Lcom/google/android/exoplayer2/trackselection/BaseTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/source/TrackGroup;[ILcom/google/android/exoplayer2/upstream/BandwidthMeter;IJJJF)V", "maxDurationForQualityDecreaseUs", "minDurationForQualityIncreaseUs", "minDurationToRetainAfterDiscardUs", "reason", "selectedIndex", "determineIdealSelectedIndex", "nowMs", "evaluateQueueSize", "playbackPositionUs", "queue", "", "Lcom/google/android/exoplayer2/source/chunk/MediaChunk;", "getSelectFormat", "Lcom/google/android/exoplayer2/Format;", "getSelectedIndex", "getSelectionData", "", "getSelectionReason", "updateSelectedTrack", "", "bufferedDurationUs", "Companion", "Factory", "luggage-commons-jsapi-video-ext_release"})
public final class c
  extends b
{
  private static final int mBM = 800000;
  private static final int mBN = 10000;
  private static final int mBO = 25000;
  private static final int mBP = 25000;
  private static final float mBQ = 0.75F;
  public static final c.a mBR;
  private final d bDT;
  private final int bDU;
  private final long bDV;
  private final long bDW;
  private final long bDX;
  private final float bDY;
  private int bDZ;
  private int bxP;
  
  static
  {
    AppMethodBeat.i(235239);
    mBR = new c.a((byte)0);
    mBM = 800000;
    mBN = 10000;
    mBO = 25000;
    mBP = 25000;
    mBQ = 0.75F;
    AppMethodBeat.o(235239);
  }
  
  public c(q paramq, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramq, Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(235238);
    this.bDT = paramd;
    this.bDU = paramInt;
    this.bDY = paramFloat;
    this.bDV = (1000L * paramLong1);
    this.bDW = (1000L * paramLong2);
    this.bDX = (1000L * paramLong3);
    paramArrayOfInt = this.bDT;
    paramq = paramArrayOfInt;
    if (!(paramArrayOfInt instanceof a)) {
      paramq = null;
    }
    paramq = (a)paramq;
    if (paramq != null) {
      paramq.bFf = -1L;
    }
    this.bxP = ak(-1L);
    this.bDZ = 1;
    AppMethodBeat.o(235238);
  }
  
  private final int ak(long paramLong)
  {
    AppMethodBeat.i(235237);
    long l2 = this.bDT.wE();
    long l1;
    int k;
    int i;
    int j;
    if (l2 == -1L)
    {
      l1 = this.bDU;
      Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] determineIdealSelectedIndex bitrateEstimate = ".concat(String.valueOf(l2)));
      k = this.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i >= k) {
        break label127;
      }
      if ((paramLong == -1L) || (!l(i, paramLong)))
      {
        if (eU(i).bitrate <= l1)
        {
          AppMethodBeat.o(235237);
          return i;
          l1 = ((float)l2 * this.bDY);
          break;
        }
        j = i;
      }
      i += 1;
    }
    label127:
    AppMethodBeat.o(235237);
    return j;
  }
  
  public final void af(long paramLong)
  {
    AppMethodBeat.i(235236);
    long l = SystemClock.elapsedRealtime();
    int i = this.bxP;
    this.bxP = ak(l);
    Format localFormat1;
    Format localFormat2;
    if (this.bxP != i) {
      if (!l(i, l))
      {
        localFormat1 = eU(i);
        localFormat2 = eU(this.bxP);
        if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bDV)) {
          break label175;
        }
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = " + this.bxP + ", bufferedDurationUs = " + paramLong + ", min = " + this.bDV);
      }
    }
    for (this.bxP = i;; this.bxP = i)
    {
      label175:
      do
      {
        if (this.bxP != i) {
          this.bDZ = 3;
        }
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = " + this.bxP);
        AppMethodBeat.o(235236);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bDW));
      Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = " + this.bxP + ", bufferedDurationUs = " + paramLong);
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bxP;
  }
  
  public final int vP()
  {
    return this.bDZ;
  }
  
  public final Object vQ()
  {
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Factory;", "Lcom/google/android/exoplayer2/trackselection/TrackSelection$Factory;", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/upstream/BandwidthMeter;IIIIF)V", "createTrackSelection", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "luggage-commons-jsapi-video-ext_release"})
  public static final class b
    implements f.a
  {
    private final d bDT;
    private final int bDU;
    private final float bDY;
    private final int bEa;
    private final int bEb;
    private final int bEc;
    
    public b(d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(235235);
      this.bDT = paramd;
      this.bDU = paramInt1;
      this.bEa = paramInt2;
      this.bEb = paramInt3;
      this.bEc = 25000;
      this.bDY = paramFloat;
      AppMethodBeat.o(235235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c
 * JD-Core Version:    0.7.0.1
 */