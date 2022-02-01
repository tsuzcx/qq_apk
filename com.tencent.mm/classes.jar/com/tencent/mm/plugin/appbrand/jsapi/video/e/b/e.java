package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.g;
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

final class e
  implements com.google.android.exoplayer2.a.e, com.google.android.exoplayer2.metadata.e.a, q.a, com.google.android.exoplayer2.source.b, h.a, com.google.android.exoplayer2.video.e
{
  private static final NumberFormat pAX;
  private final w.b aLG;
  private final w.a aLH;
  private final com.google.android.exoplayer2.g.e pAY;
  private final long startTimeMs;
  
  static
  {
    AppMethodBeat.i(229556);
    NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
    pAX = localNumberFormat;
    localNumberFormat.setMinimumFractionDigits(2);
    pAX.setMaximumFractionDigits(2);
    pAX.setGroupingUsed(false);
    AppMethodBeat.o(229556);
  }
  
  public e(com.google.android.exoplayer2.g.e parame)
  {
    AppMethodBeat.i(229489);
    this.pAY = parame;
    this.aLG = new w.b();
    this.aLH = new w.a();
    this.startTimeMs = SystemClock.elapsedRealtime();
    AppMethodBeat.o(229489);
  }
  
  private static String Be(int paramInt)
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
  
  private static String Hw(long paramLong)
  {
    AppMethodBeat.i(229553);
    if (paramLong == -9223372036854775807L)
    {
      AppMethodBeat.o(229553);
      return "?";
    }
    String str = pAX.format((float)paramLong / 1000.0F);
    AppMethodBeat.o(229553);
    return str;
  }
  
  private static void a(Metadata paramMetadata, String paramString)
  {
    AppMethodBeat.i(229548);
    int i = 0;
    if (i < paramMetadata.bdA.length)
    {
      Object localObject = paramMetadata.bdA[i];
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
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("%s: owner=%s", new Object[] { ((PrivFrame)localObject).id, ((PrivFrame)localObject).bec }));
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
          Log.d("MicroMsg.Video.Exo.EventLogger", paramString + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((EventMessage)localObject).bdL, Long.valueOf(((EventMessage)localObject).id), ((EventMessage)localObject).value }));
        }
      }
    }
    AppMethodBeat.o(229548);
  }
  
  private void b(String paramString, Exception paramException)
  {
    AppMethodBeat.i(229540);
    Log.printErrStackTrace("MicroMsg.Video.Exo.EventLogger", paramException, "internalError [" + bWw() + ", " + paramString + "]", new Object[0]);
    AppMethodBeat.o(229540);
  }
  
  private String bWw()
  {
    AppMethodBeat.i(229551);
    String str = Hw(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(229551);
    return str;
  }
  
  private static String iL(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "[X]";
    }
    return "[ ]";
  }
  
  public final void I(int paramInt)
  {
    AppMethodBeat.i(229493);
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
      AppMethodBeat.o(229493);
      return;
      str = "OFF";
      continue;
      str = "ONE";
      continue;
      str = "ALL";
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(229528);
    Log.i("MicroMsg.Video.Exo.EventLogger", "videoSizeChanged [" + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramFloat + "]");
    AppMethodBeat.o(229528);
  }
  
  public final void a(int paramInt, Format paramFormat, long paramLong) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(229520);
    Log.d("MicroMsg.Video.Exo.EventLogger", "videoEnabled [" + bWw() + "]");
    AppMethodBeat.o(229520);
  }
  
  public final void a(com.google.android.exoplayer2.e parame)
  {
    AppMethodBeat.i(229498);
    Log.printErrStackTrace("MicroMsg.Video.Exo.EventLogger", parame, "playerFailed [" + bWw() + "]", new Object[0]);
    AppMethodBeat.o(229498);
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    AppMethodBeat.i(229532);
    b("loadError", paramIOException);
    AppMethodBeat.o(229532);
  }
  
  public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void a(r paramr, g paramg)
  {
    AppMethodBeat.i(229502);
    Object localObject1 = this.pAY.bnZ;
    if (localObject1 == null)
    {
      Log.d("MicroMsg.Video.Exo.EventLogger", "Tracks []");
      AppMethodBeat.o(229502);
      return;
    }
    Log.d("MicroMsg.Video.Exo.EventLogger", "Tracks [");
    int i = 0;
    Object localObject2;
    int j;
    if (i < ((com.google.android.exoplayer2.g.e.a)localObject1).length)
    {
      r localr = localObject1.bob[i];
      localObject2 = paramg.bof[i];
      if (localr.length > 0)
      {
        Log.d("MicroMsg.Video.Exo.EventLogger", "  Renderer:" + i + " [");
        j = 0;
        while (j < localr.length)
        {
          q localq = localr.bgK[j];
          int k = localq.length;
          int m = ((com.google.android.exoplayer2.g.e.a)localObject1).bo(i, j);
          if (k < 2)
          {
            paramr = "N/A";
            Log.d("MicroMsg.Video.Exo.EventLogger", "    Group:" + j + ", adaptive_supported=" + paramr + " [");
            k = 0;
            label199:
            if (k >= localq.length) {
              break label403;
            }
            if ((localObject2 == null) || (((f)localObject2).uz() != localq) || (((f)localObject2).fo(k) == -1)) {
              break label397;
            }
          }
          label397:
          for (boolean bool = true;; bool = false)
          {
            paramr = iL(bool);
            String str = Be(((com.google.android.exoplayer2.g.e.a)localObject1).o(i, j, k));
            Log.d("MicroMsg.Video.Exo.EventLogger", "      " + paramr + " Track:" + k + ", " + Format.a(localq.bgf[k]) + ", supported=" + str);
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
          paramr = ((f)localObject2).fm(j).aMO;
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
    paramr = ((com.google.android.exoplayer2.g.e.a)localObject1).boe;
    if (paramr.length > 0)
    {
      Log.d("MicroMsg.Video.Exo.EventLogger", "  Renderer:None [");
      i = 0;
      while (i < paramr.length)
      {
        Log.d("MicroMsg.Video.Exo.EventLogger", "    Group:" + i + " [");
        paramg = paramr.bgK[i];
        j = 0;
        while (j < paramg.length)
        {
          localObject1 = iL(false);
          localObject2 = Be(0);
          Log.d("MicroMsg.Video.Exo.EventLogger", "      " + (String)localObject1 + " Track:" + j + ", " + Format.a(paramg.bgf[j]) + ", supported=" + (String)localObject2);
          j += 1;
        }
        Log.d("MicroMsg.Video.Exo.EventLogger", "    ]");
        i += 1;
      }
      Log.d("MicroMsg.Video.Exo.EventLogger", "  ]");
    }
    Log.d("MicroMsg.Video.Exo.EventLogger", "]");
    AppMethodBeat.o(229502);
  }
  
  public final void aP(boolean paramBoolean)
  {
    AppMethodBeat.i(229490);
    Log.d("MicroMsg.Video.Exo.EventLogger", "loading [" + paramBoolean + "]");
    AppMethodBeat.o(229490);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(229525);
    Log.d("MicroMsg.Video.Exo.EventLogger", "videoDisabled [" + bWw() + ", " + h.f(paramd) + "]");
    AppMethodBeat.o(229525);
  }
  
  public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(229503);
    Log.d("MicroMsg.Video.Exo.EventLogger", "onMetadata [");
    a(paramMetadata, "  ");
    Log.d("MicroMsg.Video.Exo.EventLogger", "]");
    AppMethodBeat.o(229503);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(229496);
    Log.d("MicroMsg.Video.Exo.EventLogger", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.aNo), Float.valueOf(paramp.pitch) }));
    AppMethodBeat.o(229496);
  }
  
  public final void b(w paramw, Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(229497);
    int m = paramw.rw();
    int k = paramw.rv();
    Log.d("MicroMsg.Video.Exo.EventLogger", "sourceInfo [periodCount=" + m + ", windowCount=" + k);
    int i = 0;
    while (i < Math.min(m, 3))
    {
      paramw.a(i, this.aLH, false);
      Log.d("MicroMsg.Video.Exo.EventLogger", "  period [" + Hw(com.google.android.exoplayer2.b.y(this.aLH.aNk)) + "]");
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
      paramw.a(i, this.aLG);
      Log.d("MicroMsg.Video.Exo.EventLogger", "  window [" + Hw(com.google.android.exoplayer2.b.y(this.aLG.aNk)) + ", " + this.aLG.aNX + ", " + this.aLG.aNY + "]");
      i += 1;
    }
    if (k > 3) {
      Log.d("MicroMsg.Video.Exo.EventLogger", "  ...");
    }
    Log.d("MicroMsg.Video.Exo.EventLogger", "]");
    AppMethodBeat.o(229497);
  }
  
  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(229522);
    Log.d("MicroMsg.Video.Exo.EventLogger", "videoDecoderInitialized [" + bWw() + ", " + paramString + ", " + paramLong2 + "]");
    AppMethodBeat.o(229522);
  }
  
  public final void c(Surface paramSurface)
  {
    AppMethodBeat.i(229529);
    Log.i("MicroMsg.Video.Exo.EventLogger", "renderedFirstFrame [" + paramSurface + "]");
    AppMethodBeat.o(229529);
  }
  
  public final void c(Format paramFormat)
  {
    AppMethodBeat.i(229523);
    Log.i("MicroMsg.Video.Exo.EventLogger", "videoFormatChanged [" + bWw() + ", " + Format.a(paramFormat) + "]");
    AppMethodBeat.o(229523);
  }
  
  public final void c(d paramd)
  {
    AppMethodBeat.i(229506);
    Log.d("MicroMsg.Video.Exo.EventLogger", "audioEnabled [" + bWw() + "]");
    AppMethodBeat.o(229506);
  }
  
  public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
  
  public final void c(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(229510);
    Log.i("MicroMsg.Video.Exo.EventLogger", "audioDecoderInitialized [" + bWw() + ", " + paramString + ", " + paramLong2 + "]");
    AppMethodBeat.o(229510);
  }
  
  public final void d(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(229518);
    b("audioTrackUnderrun [" + paramInt + ", " + paramLong1 + ", " + paramLong2 + "]", null);
    AppMethodBeat.o(229518);
  }
  
  public final void d(Format paramFormat)
  {
    AppMethodBeat.i(229512);
    Log.i("MicroMsg.Video.Exo.EventLogger", "audioFormatChanged [" + bWw() + ", " + Format.a(paramFormat) + "]");
    AppMethodBeat.o(229512);
  }
  
  public final void d(d paramd)
  {
    AppMethodBeat.i(229515);
    Log.i("MicroMsg.Video.Exo.EventLogger", "audioDisabled [" + bWw() + ", " + h.f(paramd) + "]");
    AppMethodBeat.o(229515);
  }
  
  public final void dU(int paramInt)
  {
    AppMethodBeat.i(229508);
    Log.d("MicroMsg.Video.Exo.EventLogger", "audioSessionId [" + paramInt + "]");
    AppMethodBeat.o(229508);
  }
  
  public final void e(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(229492);
    StringBuilder localStringBuilder = new StringBuilder("state [").append(bWw()).append(", ").append(paramBoolean).append(", ");
    String str;
    switch (paramInt)
    {
    default: 
      str = "?";
    }
    for (;;)
    {
      Log.i("MicroMsg.Video.Exo.EventLogger", str + "]");
      AppMethodBeat.o(229492);
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
  
  public final void h(int paramInt, long paramLong)
  {
    AppMethodBeat.i(229526);
    Log.d("MicroMsg.Video.Exo.EventLogger", "droppedFrames [" + bWw() + ", " + paramInt + "]");
    AppMethodBeat.o(229526);
  }
  
  public final void onLoadError(IOException paramIOException)
  {
    AppMethodBeat.i(229530);
    b("loadError", paramIOException);
    AppMethodBeat.o(229530);
  }
  
  public final void rs()
  {
    AppMethodBeat.i(229495);
    Log.d("MicroMsg.Video.Exo.EventLogger", "positionDiscontinuity");
    AppMethodBeat.o(229495);
  }
  
  public final void tj()
  {
    AppMethodBeat.i(229538);
    Log.d("MicroMsg.Video.Exo.EventLogger", "onHasEndTag");
    AppMethodBeat.o(229538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e
 * JD-Core Version:    0.7.0.1
 */