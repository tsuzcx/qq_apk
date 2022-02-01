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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "Lcom/google/android/exoplayer2/trackselection/BaseTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/source/TrackGroup;[ILcom/google/android/exoplayer2/upstream/BandwidthMeter;IJJJF)V", "maxDurationForQualityDecreaseUs", "minDurationForQualityIncreaseUs", "minDurationToRetainAfterDiscardUs", "reason", "selectedIndex", "determineIdealSelectedIndex", "nowMs", "evaluateQueueSize", "playbackPositionUs", "queue", "", "Lcom/google/android/exoplayer2/source/chunk/MediaChunk;", "getSelectFormat", "Lcom/google/android/exoplayer2/Format;", "getSelectedIndex", "getSelectionData", "", "getSelectionReason", "updateSelectedTrack", "", "bufferedDurationUs", "Companion", "Factory", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  private static final float sFA;
  public static final c.a sFv;
  private static final int sFw;
  private static final int sFx;
  private static final int sFy;
  private static final int sFz;
  private int dbk;
  private final d dhp;
  private final int dhq;
  private final long dhr;
  private final long dhs;
  private final long dht;
  private final float dhu;
  private int reason;
  
  static
  {
    AppMethodBeat.i(328679);
    sFv = new c.a((byte)0);
    sFw = 800000;
    sFx = 10000;
    sFy = 25000;
    sFz = 25000;
    sFA = 0.75F;
    AppMethodBeat.o(328679);
  }
  
  public c(q paramq, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramq, Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    AppMethodBeat.i(328652);
    this.dhp = paramd;
    this.dhq = paramInt;
    this.dhu = paramFloat;
    this.dhr = (1000L * paramLong1);
    this.dhs = (1000L * paramLong2);
    this.dht = (1000L * paramLong3);
    paramq = this.dhp;
    if ((paramq instanceof a)) {}
    for (paramq = (a)paramq;; paramq = null)
    {
      if (paramq != null) {
        paramq.diy = -1L;
      }
      this.dbk = cB(-1L);
      this.reason = 1;
      AppMethodBeat.o(328652);
      return;
    }
  }
  
  private final int cB(long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(328668);
    long l2 = this.dhp.Ui();
    if (l2 == -1L) {}
    int m;
    int j;
    int k;
    for (long l1 = this.dhq;; l1 = ((float)l2 * this.dhu))
    {
      Log.i("MicroMsg.AdavanceTrackSelection", s.X("[TRACE_ADAPTIVE] determineIdealSelectedIndex bitrateEstimate = ", Long.valueOf(l2)));
      m = this.length;
      if (m <= 0) {
        break label130;
      }
      i = 0;
      j = 0;
      k = i + 1;
      if ((paramLong != -1L) && (l(i, paramLong))) {
        break label154;
      }
      if (iB(i).bitrate > l1) {
        break;
      }
      AppMethodBeat.o(328668);
      return i;
    }
    for (;;)
    {
      if (k >= m)
      {
        label130:
        AppMethodBeat.o(328668);
        return i;
      }
      j = k;
      k = i;
      i = j;
      j = k;
      break;
      label154:
      i = j;
    }
  }
  
  public final int Tq()
  {
    return this.reason;
  }
  
  public final Object Tr()
  {
    return null;
  }
  
  public final void cw(long paramLong)
  {
    AppMethodBeat.i(328693);
    long l = SystemClock.elapsedRealtime();
    int i = this.dbk;
    this.dbk = cB(l);
    Format localFormat1;
    Format localFormat2;
    if (this.dbk != i) {
      if (!l(i, l))
      {
        localFormat1 = iB(i);
        localFormat2 = iB(this.dbk);
        if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.dhr)) {
          break label168;
        }
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = " + this.dbk + ", bufferedDurationUs = " + paramLong + ", min = " + this.dhr);
      }
    }
    for (this.dbk = i;; this.dbk = i)
    {
      label168:
      do
      {
        if (this.dbk != i) {
          this.reason = 3;
        }
        Log.i("MicroMsg.AdavanceTrackSelection", s.X("[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = ", Integer.valueOf(this.dbk)));
        AppMethodBeat.o(328693);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.dhs));
      Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = " + this.dbk + ", bufferedDurationUs = " + paramLong);
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.dbk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Factory;", "Lcom/google/android/exoplayer2/trackselection/TrackSelection$Factory;", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/upstream/BandwidthMeter;IIIIF)V", "createTrackSelection", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f.a
  {
    private final d dhp;
    private final int dhq;
    private final float dhu;
    private final int dhv;
    private final int dhw;
    private final int dhx;
    
    public b(d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(328638);
      this.dhp = paramd;
      this.dhq = paramInt1;
      this.dhv = paramInt2;
      this.dhw = paramInt3;
      this.dhx = 25000;
      this.dhu = paramFloat;
      AppMethodBeat.o(328638);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c
 * JD-Core Version:    0.7.0.1
 */