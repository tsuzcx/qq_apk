package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

final class g
  implements com.google.android.exoplayer2.a.e, com.google.android.exoplayer2.metadata.e.a, q.a, com.google.android.exoplayer2.source.b, h.a, com.google.android.exoplayer2.video.e
{
  private static final NumberFormat sFV;
  private final w.b cFD;
  private final w.a cFE;
  private final com.google.android.exoplayer2.g.e sFW;
  private final long startTimeMs;
  
  static
  {
    AppMethodBeat.i(328803);
    NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
    sFV = localNumberFormat;
    localNumberFormat.setMinimumFractionDigits(2);
    sFV.setMaximumFractionDigits(2);
    sFV.setGroupingUsed(false);
    AppMethodBeat.o(328803);
  }
  
  public g(com.google.android.exoplayer2.g.e parame)
  {
    AppMethodBeat.i(328709);
    this.sFW = parame;
    this.cFD = new w.b();
    this.cFE = new w.a();
    this.startTimeMs = SystemClock.elapsedRealtime();
    AppMethodBeat.o(328709);
  }
  
  private static String Bs(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 4: 
      return "YES";
    case 3: 
      return "NO_EXCEEDS_CAPABILITIES";
    case 2: 
      return "NO_UNSUPPORTED_DRM";
    case 1: 
      return "NO_UNSUPPORTED_TYPE";
    }
    return "NO";
  }
  
  private static void a(Metadata paramMetadata, String paramString)
  {
    AppMethodBeat.i(328739);
    int i = 0;
    if (i < paramMetadata.cXu.length)
    {
      Object localObject = paramMetadata.cXu[i];
      if ((localObject instanceof TextInformationFrame))
      {
        localObject = (TextInformationFrame)localObject;
        Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: value=%s", new Object[] { ((TextInformationFrame)localObject).id, ((TextInformationFrame)localObject).value }));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof UrlLinkFrame))
        {
          localObject = (UrlLinkFrame)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: url=%s", new Object[] { ((UrlLinkFrame)localObject).id, ((UrlLinkFrame)localObject).url }));
        }
        else if ((localObject instanceof PrivFrame))
        {
          localObject = (PrivFrame)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: owner=%s", new Object[] { ((PrivFrame)localObject).id, ((PrivFrame)localObject).cXV }));
        }
        else if ((localObject instanceof GeobFrame))
        {
          localObject = (GeobFrame)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[] { ((GeobFrame)localObject).id, ((GeobFrame)localObject).mimeType, ((GeobFrame)localObject).filename, ((GeobFrame)localObject).description }));
        }
        else if ((localObject instanceof ApicFrame))
        {
          localObject = (ApicFrame)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: mimeType=%s, description=%s", new Object[] { ((ApicFrame)localObject).id, ((ApicFrame)localObject).mimeType, ((ApicFrame)localObject).description }));
        }
        else if ((localObject instanceof CommentFrame))
        {
          localObject = (CommentFrame)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: language=%s, description=%s", new Object[] { ((CommentFrame)localObject).id, ((CommentFrame)localObject).language, ((CommentFrame)localObject).description }));
        }
        else if ((localObject instanceof Id3Frame))
        {
          localObject = (Id3Frame)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s", new Object[] { ((Id3Frame)localObject).id }));
        }
        else if ((localObject instanceof EventMessage))
        {
          localObject = (EventMessage)localObject;
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((EventMessage)localObject).cXF, Long.valueOf(((EventMessage)localObject).id), ((EventMessage)localObject).value }));
        }
      }
    }
    AppMethodBeat.o(328739);
  }
  
  private void b(String paramString, Exception paramException)
  {
    AppMethodBeat.i(328720);
    Log.printErrStackTrace("MicroMsg.Video.Exo.EventLogger", paramException, "internalError [" + cwI() + ", " + paramString + "]", new Object[0]);
    AppMethodBeat.o(328720);
  }
  
  private String cwI()
  {
    AppMethodBeat.i(328749);
    String str = jM(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(328749);
    return str;
  }
  
  private static String jM(long paramLong)
  {
    AppMethodBeat.i(328761);
    if (paramLong == -9223372036854775807L)
    {
      AppMethodBeat.o(328761);
      return "?";
    }
    String str = sFV.format((float)paramLong / 1000.0F);
    AppMethodBeat.o(328761);
    return str;
  }
  
  private static String jP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "[X]";
    }
    return "[ ]";
  }
  
  public final void SM()
  {
    AppMethodBeat.i(329112);
    Log.d("MicroMsg.Video.Exo.EventLogger", "onHasEndTag");
    AppMethodBeat.o(329112);
  }
  
  public final void a(int paramInt, Format paramFormat, long paramLong) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(328989);
    Log.d("MicroMsg.Video.Exo.EventLogger", "videoEnabled [" + cwI() + "]");
    AppMethodBeat.o(328989);
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    AppMethodBeat.i(329084);
    b("loadError", paramIOException);
    AppMethodBeat.o(329084);
  }
  
  public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(329051);
    Log.i("MicroMsg.Video.Exo.EventLogger", "videoSizeChanged [" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramFloat + "]");
    AppMethodBeat.o(329051);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(329025);
    Log.d("MicroMsg.Video.Exo.EventLogger", "videoDisabled [" + cwI() + ", " + k.f(paramd) + "]");
    AppMethodBeat.o(329025);
  }
  
  public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(328914);
    Log.d("MicroMsg.Video.Exo.EventLogger", "onMetadata [");
    a(paramMetadata, "  ");
    Log.d("MicroMsg.Video.Exo.EventLogger", "]");
    AppMethodBeat.o(328914);
  }
  
  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328998);
    Log.d("MicroMsg.Video.Exo.EventLogger", "videoDecoderInitialized [" + cwI() + ", " + paramString + ", " + paramLong2 + "]");
    AppMethodBeat.o(328998);
  }
  
  public final void c(Format paramFormat)
  {
    AppMethodBeat.i(329011);
    Log.i("MicroMsg.Video.Exo.EventLogger", "videoFormatChanged [" + cwI() + ", " + Format.a(paramFormat) + "]");
    AppMethodBeat.o(329011);
  }
  
  public final void c(d paramd)
  {
    AppMethodBeat.i(328924);
    Log.d("MicroMsg.Video.Exo.EventLogger", "audioEnabled [" + cwI() + "]");
    AppMethodBeat.o(328924);
  }
  
  public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void c(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328944);
    Log.i("MicroMsg.Video.Exo.EventLogger", "audioDecoderInitialized [" + cwI() + ", " + paramString + ", " + paramLong2 + "]");
    AppMethodBeat.o(328944);
  }
  
  public final void d(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328970);
    b("audioTrackUnderrun [" + paramInt + ", " + paramLong1 + ", " + paramLong2 + "]", null);
    AppMethodBeat.o(328970);
  }
  
  public final void d(Format paramFormat)
  {
    AppMethodBeat.i(328953);
    Log.i("MicroMsg.Video.Exo.EventLogger", "audioFormatChanged [" + cwI() + ", " + Format.a(paramFormat) + "]");
    AppMethodBeat.o(328953);
  }
  
  public final void d(d paramd)
  {
    AppMethodBeat.i(328961);
    Log.i("MicroMsg.Video.Exo.EventLogger", "audioDisabled [" + cwI() + ", " + k.f(paramd) + "]");
    AppMethodBeat.o(328961);
  }
  
  public final void f(Surface paramSurface)
  {
    AppMethodBeat.i(329063);
    Log.i("MicroMsg.Video.Exo.EventLogger", "renderedFirstFrame [" + paramSurface + "]");
    AppMethodBeat.o(329063);
  }
  
  public final void h(int paramInt, long paramLong)
  {
    AppMethodBeat.i(329038);
    Log.d("MicroMsg.Video.Exo.EventLogger", "droppedFrames [" + cwI() + ", " + paramInt + "]");
    AppMethodBeat.o(329038);
  }
  
  public final void hl(int paramInt)
  {
    AppMethodBeat.i(328932);
    Log.d("MicroMsg.Video.Exo.EventLogger", "audioSessionId [" + paramInt + "]");
    AppMethodBeat.o(328932);
  }
  
  public final void onLoadError(IOException paramIOException)
  {
    AppMethodBeat.i(329072);
    b("loadError", paramIOException);
    AppMethodBeat.o(329072);
  }
  
  public final void onLoadingChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(328813);
    Log.d("MicroMsg.Video.Exo.EventLogger", "loading [" + paramBoolean + "]");
    AppMethodBeat.o(328813);
  }
  
  public final void onPlaybackParametersChanged(p paramp)
  {
    AppMethodBeat.i(328864);
    Log.d("MicroMsg.Video.Exo.EventLogger", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.cHk), Float.valueOf(paramp.pitch) }));
    AppMethodBeat.o(328864);
  }
  
  public final void onPlayerError(com.google.android.exoplayer2.e parame)
  {
    AppMethodBeat.i(328886);
    Log.printErrStackTrace("MicroMsg.Video.Exo.EventLogger", parame, "playerFailed [" + cwI() + "]", new Object[0]);
    AppMethodBeat.o(328886);
  }
  
  public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(328827);
    StringBuilder localStringBuilder = new StringBuilder("state [").append(cwI()).append(", ").append(paramBoolean).append(", ");
    String str;
    switch (paramInt)
    {
    default: 
      str = "?";
    }
    for (;;)
    {
      Log.i("MicroMsg.Video.Exo.EventLogger", str + "]");
      AppMethodBeat.o(328827);
      return;
      str = "B";
      continue;
      str = "E";
      continue;
      str = "I";
      continue;
      str = "R";
    }
  }
  
  public final void onPositionDiscontinuity()
  {
    AppMethodBeat.i(328852);
    Log.d("MicroMsg.Video.Exo.EventLogger", "positionDiscontinuity");
    AppMethodBeat.o(328852);
  }
  
  public final void onRepeatModeChanged(int paramInt)
  {
    AppMethodBeat.i(328842);
    StringBuilder localStringBuilder = new StringBuilder("repeatMode [");
    String str;
    switch (paramInt)
    {
    default: 
      str = "?";
    }
    for (;;)
    {
      Log.d("MicroMsg.Video.Exo.EventLogger", str + "]");
      AppMethodBeat.o(328842);
      return;
      str = "OFF";
      continue;
      str = "ONE";
      continue;
      str = "ALL";
    }
  }
  
  public final void onTimelineChanged(w paramw, Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(328878);
    int m = paramw.QX();
    int k = paramw.QW();
    Log.d("MicroMsg.Video.Exo.EventLogger", "sourceInfo [periodCount=" + m + ", windowCount=" + k);
    int i = 0;
    while (i < Math.min(m, 3))
    {
      paramw.a(i, this.cFE, false);
      Log.d("MicroMsg.Video.Exo.EventLogger", "  period [" + jM(com.google.android.exoplayer2.b.bM(this.cFE.cHg)) + "]");
      i += 1;
    }
    i = j;
    if (m > 3)
    {
      Log.d("MicroMsg.Video.Exo.EventLogger", "  ...");
      i = j;
    }
    while (i < Math.min(k, 3))
    {
      paramw.a(i, this.cFD);
      Log.d("MicroMsg.Video.Exo.EventLogger", "  window [" + jM(com.google.android.exoplayer2.b.bM(this.cFD.cHg)) + ", " + this.cFD.cHT + ", " + this.cFD.cHU + "]");
      i += 1;
    }
    if (k > 3) {
      Log.d("MicroMsg.Video.Exo.EventLogger", "  ...");
    }
    Log.d("MicroMsg.Video.Exo.EventLogger", "]");
    AppMethodBeat.o(328878);
  }
  
  public final void onTracksChanged(r paramr, com.google.android.exoplayer2.g.g paramg)
  {
    AppMethodBeat.i(328905);
    Object localObject1 = this.sFW.dhS;
    if (localObject1 == null)
    {
      Log.d("MicroMsg.Video.Exo.EventLogger", "Tracks []");
      AppMethodBeat.o(328905);
      return;
    }
    Log.d("MicroMsg.Video.Exo.EventLogger", "Tracks [");
    int i = 0;
    Object localObject2;
    int j;
    if (i < ((com.google.android.exoplayer2.g.e.a)localObject1).length)
    {
      r localr = localObject1.dhU[i];
      localObject2 = paramg.dhY[i];
      if (localr.length > 0)
      {
        Log.d("MicroMsg.Video.Exo.EventLogger", "  Renderer:" + i + " [");
        j = 0;
        while (j < localr.length)
        {
          q localq = localr.daE[j];
          int k = localq.length;
          int m = ((com.google.android.exoplayer2.g.e.a)localObject1).cj(i, j);
          if (k < 2)
          {
            paramr = "N/A";
            Log.d("MicroMsg.Video.Exo.EventLogger", "    Group:" + j + ", adaptive_supported=" + paramr + " [");
            k = 0;
            label199:
            if (k >= localq.length) {
              break label403;
            }
            if ((localObject2 == null) || (((f)localObject2).Uc() != localq) || (((f)localObject2).es(k) == -1)) {
              break label397;
            }
          }
          label397:
          for (boolean bool = true;; bool = false)
          {
            paramr = jP(bool);
            String str = Bs(((com.google.android.exoplayer2.g.e.a)localObject1).E(i, j, k));
            Log.d("MicroMsg.Video.Exo.EventLogger", "      " + paramr + " Track:" + k + ", " + Format.a(localq.cZY[k]) + ", supported=" + str);
            k += 1;
            break label199;
            switch (m)
            {
            default: 
              paramr = "?";
              break;
            case 16: 
              paramr = "YES";
              break;
            case 8: 
              paramr = "YES_NOT_SEAMLESS";
              break;
            case 0: 
              paramr = "NO";
              break;
            }
          }
          label403:
          Log.d("MicroMsg.Video.Exo.EventLogger", "    ]");
          j += 1;
        }
        if (localObject2 != null) {
          j = 0;
        }
      }
      for (;;)
      {
        if (j < ((f)localObject2).length())
        {
          paramr = ((f)localObject2).iB(j).cGL;
          if (paramr != null)
          {
            Log.d("MicroMsg.Video.Exo.EventLogger", "    Metadata [");
            a(paramr, "      ");
            Log.d("MicroMsg.Video.Exo.EventLogger", "    ]");
          }
        }
        else
        {
          Log.d("MicroMsg.Video.Exo.EventLogger", "  ]");
          i += 1;
          break;
        }
        j += 1;
      }
    }
    paramr = ((com.google.android.exoplayer2.g.e.a)localObject1).dhX;
    if (paramr.length > 0)
    {
      Log.d("MicroMsg.Video.Exo.EventLogger", "  Renderer:None [");
      i = 0;
      while (i < paramr.length)
      {
        Log.d("MicroMsg.Video.Exo.EventLogger", "    Group:" + i + " [");
        paramg = paramr.daE[i];
        j = 0;
        while (j < paramg.length)
        {
          localObject1 = jP(false);
          localObject2 = Bs(0);
          Log.d("MicroMsg.Video.Exo.EventLogger", "      " + (String)localObject1 + " Track:" + j + ", " + Format.a(paramg.cZY[j]) + ", supported=" + (String)localObject2);
          j += 1;
        }
        Log.d("MicroMsg.Video.Exo.EventLogger", "    ]");
        i += 1;
      }
      Log.d("MicroMsg.Video.Exo.EventLogger", "  ]");
    }
    Log.d("MicroMsg.Video.Exo.EventLogger", "]");
    AppMethodBeat.o(328905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g
 * JD-Core Version:    0.7.0.1
 */