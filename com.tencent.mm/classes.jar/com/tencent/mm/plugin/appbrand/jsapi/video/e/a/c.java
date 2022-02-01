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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "Lcom/google/android/exoplayer2/trackselection/BaseTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/source/TrackGroup;[ILcom/google/android/exoplayer2/upstream/BandwidthMeter;IJJJF)V", "maxDurationForQualityDecreaseUs", "minDurationForQualityIncreaseUs", "minDurationToRetainAfterDiscardUs", "reason", "selectedIndex", "determineIdealSelectedIndex", "nowMs", "evaluateQueueSize", "playbackPositionUs", "queue", "", "Lcom/google/android/exoplayer2/source/chunk/MediaChunk;", "getSelectFormat", "Lcom/google/android/exoplayer2/Format;", "getSelectedIndex", "getSelectionData", "", "getSelectionReason", "updateSelectedTrack", "", "bufferedDurationUs", "Companion", "Factory", "luggage-commons-jsapi-video-ext_release"})
public final class c
  extends b
{
  private static final int pAu = 800000;
  private static final int pAv = 10000;
  private static final int pAw = 25000;
  private static final int pAx = 25000;
  private static final float pAy = 0.75F;
  public static final c.a pAz;
  private int bhr;
  private int bnA;
  private final d bnu;
  private final int bnv;
  private final long bnw;
  private final long bnx;
  private final long bny;
  private final float bnz;
  
  static
  {
    AppMethodBeat.i(227414);
    pAz = new c.a((byte)0);
    pAu = 800000;
    pAv = 10000;
    pAw = 25000;
    pAx = 25000;
    pAy = 0.75F;
    AppMethodBeat.o(227414);
  }
  
  public c(q paramq, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramq, Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(227412);
    this.bnu = paramd;
    this.bnv = paramInt;
    this.bnz = paramFloat;
    this.bnw = (1000L * paramLong1);
    this.bnx = (1000L * paramLong2);
    this.bny = (1000L * paramLong3);
    paramArrayOfInt = this.bnu;
    paramq = paramArrayOfInt;
    if (!(paramArrayOfInt instanceof a)) {
      paramq = null;
    }
    paramq = (a)paramq;
    if (paramq != null) {
      paramq.boI = -1L;
    }
    this.bhr = an(-1L);
    this.bnA = 1;
    AppMethodBeat.o(227412);
  }
  
  private final int an(long paramLong)
  {
    AppMethodBeat.i(227408);
    long l2 = this.bnu.uF();
    long l1;
    int k;
    int i;
    int j;
    if (l2 == -1L)
    {
      l1 = this.bnv;
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
        if (fm(i).bitrate <= l1)
        {
          AppMethodBeat.o(227408);
          return i;
          l1 = ((float)l2 * this.bnz);
          break;
        }
        j = i;
      }
      i += 1;
    }
    label127:
    AppMethodBeat.o(227408);
    return j;
  }
  
  public final void ai(long paramLong)
  {
    AppMethodBeat.i(227405);
    long l = SystemClock.elapsedRealtime();
    int i = this.bhr;
    this.bhr = an(l);
    Format localFormat1;
    Format localFormat2;
    if (this.bhr != i) {
      if (!l(i, l))
      {
        localFormat1 = fm(i);
        localFormat2 = fm(this.bhr);
        if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bnw)) {
          break label175;
        }
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = " + this.bhr + ", bufferedDurationUs = " + paramLong + ", min = " + this.bnw);
      }
    }
    for (this.bhr = i;; this.bhr = i)
    {
      label175:
      do
      {
        if (this.bhr != i) {
          this.bnA = 3;
        }
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = " + this.bhr);
        AppMethodBeat.o(227405);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bnx));
      Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = " + this.bhr + ", bufferedDurationUs = " + paramLong);
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bhr;
  }
  
  public final int tN()
  {
    return this.bnA;
  }
  
  public final Object tO()
  {
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Factory;", "Lcom/google/android/exoplayer2/trackselection/TrackSelection$Factory;", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/upstream/BandwidthMeter;IIIIF)V", "createTrackSelection", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "luggage-commons-jsapi-video-ext_release"})
  public static final class b
    implements f.a
  {
    private final int bnB;
    private final int bnC;
    private final int bnD;
    private final d bnu;
    private final int bnv;
    private final float bnz;
    
    public b(d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(228999);
      this.bnu = paramd;
      this.bnv = paramInt1;
      this.bnB = paramInt2;
      this.bnC = paramInt3;
      this.bnD = 25000;
      this.bnz = paramFloat;
      AppMethodBeat.o(228999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c
 * JD-Core Version:    0.7.0.1
 */