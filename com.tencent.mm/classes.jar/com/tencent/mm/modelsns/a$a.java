package com.tencent.mm.modelsns;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class a$a
{
  public String maQ;
  public String maR;
  public String maS;
  public int maT = -1;
  public int videoBitRate = -1;
  public int videoFrameRate = -1;
  public int videoHeight = -1;
  public int videoIFrameInterval = -1;
  public int videoWidth = -1;
  
  public static a Xe(String paramString)
  {
    AppMethodBeat.i(20650);
    c localc = new c();
    a locala = new a();
    locala.maQ = paramString;
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject5;
      Object localObject6;
      try
      {
        localc.setDataSource(u.n(paramString, false));
        int j = localc.jvU.getTrackCount();
        i = 0;
        localObject2 = null;
        str1 = null;
        localObject3 = localObject2;
        localObject4 = str1;
        if (i < j)
        {
          localMediaFormat = localc.getTrackFormat(i);
          if (!localMediaFormat.containsKey("mime"))
          {
            Log.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
            localObject5 = localObject2;
            localObject6 = str1;
            break label528;
          }
          str2 = localMediaFormat.getString("mime");
          Log.i("MicroMsg.ShareSnsImpl", "find video mime : %s", new Object[] { str2 });
          localObject5 = localObject2;
          localObject6 = str1;
          if (str2 == null) {
            break label528;
          }
          if (!str2.startsWith("video/")) {
            continue;
          }
          localObject3 = localObject2;
          localObject4 = str1;
          if (str1 != null) {
            break label542;
          }
          localObject4 = localMediaFormat;
          localObject3 = localObject2;
          break label542;
        }
        if (localObject4 != null)
        {
          if (((MediaFormat)localObject4).containsKey("durationUs")) {
            continue;
          }
          i = 0;
          locala.maT = i;
          if (((MediaFormat)localObject4).containsKey("height")) {
            continue;
          }
          i = 0;
          locala.videoHeight = i;
          if (((MediaFormat)localObject4).containsKey("width")) {
            continue;
          }
          i = 0;
          locala.videoWidth = i;
          if (((MediaFormat)localObject4).containsKey("mime")) {
            continue;
          }
          str1 = "";
          locala.maR = str1;
          if (((MediaFormat)localObject4).containsKey("bitrate")) {
            continue;
          }
          i = 0;
          locala.videoBitRate = i;
          if (((MediaFormat)localObject4).containsKey("i-frame-interval")) {
            continue;
          }
          i = 0;
          locala.videoIFrameInterval = i;
          if (((MediaFormat)localObject4).containsKey("frame-rate")) {
            continue;
          }
          i = 0;
          locala.videoFrameRate = i;
        }
        if (localObject3 != null)
        {
          if (localObject3.containsKey("mime")) {
            continue;
          }
          str1 = "";
          locala.maS = str1;
        }
        localc.jvU.release();
      }
      catch (Exception localException)
      {
        String str1;
        MediaFormat localMediaFormat;
        String str2;
        Log.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
        localc.jvU.release();
        continue;
      }
      finally
      {
        localc.jvU.release();
        AppMethodBeat.o(20650);
      }
      AppMethodBeat.o(20650);
      return locala;
      Object localObject3 = localObject2;
      Object localObject4 = str1;
      if (str2.startsWith("audio/"))
      {
        localObject3 = localObject2;
        localObject4 = str1;
        if (localObject2 == null)
        {
          localObject3 = localMediaFormat;
          localObject4 = str1;
          break label542;
          i = (int)(((MediaFormat)localObject4).getLong("durationUs") / 1000L);
          continue;
          i = ((MediaFormat)localObject4).getInteger("height");
          continue;
          i = ((MediaFormat)localObject4).getInteger("width");
          continue;
          str1 = ((MediaFormat)localObject4).getString("mime");
          continue;
          i = ((MediaFormat)localObject4).getInteger("bitrate");
          continue;
          i = ((MediaFormat)localObject4).getInteger("i-frame-interval");
          continue;
          i = ((MediaFormat)localObject4).getInteger("frame-rate");
          continue;
          str1 = localObject3.getString("mime");
          continue;
        }
      }
      label528:
      label542:
      do
      {
        do
        {
          i += 1;
          localObject2 = localObject5;
          Object localObject1 = localObject6;
          break;
          localObject5 = localObject3;
          localObject6 = localObject4;
        } while (localObject3 == null);
        localObject5 = localObject3;
        localObject6 = localObject4;
      } while (localObject4 == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.a.a
 * JD-Core Version:    0.7.0.1
 */