package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.g.f.a;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "Lcom/google/android/exoplayer2/trackselection/BaseTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/source/TrackGroup;[ILcom/google/android/exoplayer2/upstream/BandwidthMeter;IJJJF)V", "maxDurationForQualityDecreaseUs", "minDurationForQualityIncreaseUs", "minDurationToRetainAfterDiscardUs", "reason", "selectedIndex", "determineIdealSelectedIndex", "nowMs", "evaluateQueueSize", "playbackPositionUs", "queue", "", "Lcom/google/android/exoplayer2/source/chunk/MediaChunk;", "getSelectFormat", "Lcom/google/android/exoplayer2/Format;", "getSelectedIndex", "getSelectionData", "", "getSelectionReason", "updateSelectedTrack", "", "bufferedDurationUs", "Companion", "Factory", "luggage-commons-jsapi-video-ext_release"})
public final class c
  extends b
{
  private static final int lvb = 800000;
  private static final int lvc = 10000;
  private static final int lvd = 25000;
  private static final int lve = 25000;
  private static final float lvf = 0.75F;
  public static final c.a lvg;
  private final d bDS;
  private final int bDT;
  private final long bDU;
  private final long bDV;
  private final long bDW;
  private final float bDX;
  private int bxN;
  private int reason;
  
  static
  {
    AppMethodBeat.i(211556);
    lvg = new c.a((byte)0);
    lvb = 800000;
    lvc = 10000;
    lvd = 25000;
    lve = 25000;
    lvf = 0.75F;
    AppMethodBeat.o(211556);
  }
  
  public c(o paramo, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramo, Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(211555);
    this.bDS = paramd;
    this.bDT = paramInt;
    this.bDX = paramFloat;
    this.bDU = (1000L * paramLong1);
    this.bDV = (1000L * paramLong2);
    this.bDW = (1000L * paramLong3);
    paramArrayOfInt = this.bDS;
    paramo = paramArrayOfInt;
    if (!(paramArrayOfInt instanceof a)) {
      paramo = null;
    }
    paramo = (a)paramo;
    if (paramo != null) {
      paramo.bFa = -1L;
    }
    this.bxN = ak(-1L);
    this.reason = 1;
    AppMethodBeat.o(211555);
  }
  
  private final int ak(long paramLong)
  {
    AppMethodBeat.i(211554);
    long l2 = this.bDS.wz();
    long l1;
    int k;
    int i;
    int j;
    if (l2 == -1L)
    {
      l1 = this.bDT;
      ae.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] determineIdealSelectedIndex bitrateEstimate = ".concat(String.valueOf(l2)));
      k = this.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i >= k) {
        break label127;
      }
      if ((paramLong == -1L) || (!k(i, paramLong)))
      {
        if (eV(i).bitrate <= l1)
        {
          AppMethodBeat.o(211554);
          return i;
          l1 = ((float)l2 * this.bDX);
          break;
        }
        j = i;
      }
      i += 1;
    }
    label127:
    AppMethodBeat.o(211554);
    return j;
  }
  
  public final void af(long paramLong)
  {
    AppMethodBeat.i(211553);
    long l = SystemClock.elapsedRealtime();
    int i = this.bxN;
    this.bxN = ak(l);
    Format localFormat1;
    Format localFormat2;
    if (this.bxN != i) {
      if (!k(i, l))
      {
        localFormat1 = eV(i);
        localFormat2 = eV(this.bxN);
        if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bDU)) {
          break label175;
        }
        ae.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = " + this.bxN + ", bufferedDurationUs = " + paramLong + ", min = " + this.bDU);
      }
    }
    for (this.bxN = i;; this.bxN = i)
    {
      label175:
      do
      {
        if (this.bxN != i) {
          this.reason = 3;
        }
        ae.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = " + this.bxN);
        AppMethodBeat.o(211553);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bDV));
      ae.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = " + this.bxN + ", bufferedDurationUs = " + paramLong);
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bxN;
  }
  
  public final int vK()
  {
    return this.reason;
  }
  
  public final Object vL()
  {
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Factory;", "Lcom/google/android/exoplayer2/trackselection/TrackSelection$Factory;", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/upstream/BandwidthMeter;IIIIF)V", "createTrackSelection", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "luggage-commons-jsapi-video-ext_release"})
  public static final class b
    implements f.a
  {
    private final d bDS;
    private final int bDT;
    private final float bDX;
    private final int bDY;
    private final int bDZ;
    private final int bEa;
    
    public b(d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(211552);
      this.bDS = paramd;
      this.bDT = paramInt1;
      this.bDY = paramInt2;
      this.bDZ = paramInt3;
      this.bEa = 25000;
      this.bDX = paramFloat;
      AppMethodBeat.o(211552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c
 * JD-Core Version:    0.7.0.1
 */