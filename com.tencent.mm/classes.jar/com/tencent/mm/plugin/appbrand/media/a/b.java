package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import org.apache.commons.b.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static com.tencent.mm.al.b a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2, String paramString3, String paramString4, WxaPkg.Info paramInfo, String paramString5)
  {
    AppMethodBeat.i(323282);
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3)))
    {
      Log.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", new Object[] { paramString4, paramString3 });
      AppMethodBeat.o(323282);
      return null;
    }
    Log.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", new Object[] { paramString2, paramString4 });
    com.tencent.mm.al.b localb = new com.tencent.mm.al.b();
    localb.appId = paramString1;
    localb.hqQ = paramString2;
    localb.processName = paramString5;
    localb.hsg = paramString3;
    localb.fromScene = 0;
    try
    {
      paramString1 = new JSONObject(paramString4);
      int i = paramString1.optInt("startTime", 0);
      boolean bool1 = paramString1.optBoolean("autoplay", false);
      boolean bool2 = paramString1.optBoolean("loop", false);
      double d1 = paramString1.optDouble("volume", 1.0D);
      double d2 = paramString1.optDouble("playbackRate", 1.0D);
      localb.startTime = i;
      localb.ori = i;
      localb.orj = bool1;
      localb.loop = bool2;
      localb.orl = d1;
      localb.orm = d2;
      if (paramString3.startsWith("file://"))
      {
        localb.filePath = paramString3.substring(7);
        Log.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", new Object[] { localb.filePath });
        AppMethodBeat.o(323282);
        return localb;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "parseAudioPlayParam", new Object[0]);
        continue;
        if ((paramString3.contains("base64")) && (paramString3.startsWith("data:audio")))
        {
          localb.filePath = g.acs(paramString3.substring(paramString3.indexOf("base64,") + 7).trim());
          Log.i("MicroMsg.Audio.AudioPlayerParamParser", "base64 decode filePath:%s", new Object[] { localb.filePath });
        }
        else if (paramString3.startsWith("wxblob://"))
        {
          paramString1 = new k();
          if (paramf.getFileSystem().b(paramString3, paramString1) == r.qML)
          {
            localb.orz = ((ByteBuffer)paramString1.value);
            localb.filePath = paramString3;
            Log.i("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read ok");
          }
          else
          {
            Log.e("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read fail");
            paramf = paramf.getFileSystem().Wj(paramString3);
            if ((paramf == null) || (!paramf.jKS())) {
              Log.e("MicroMsg.Audio.AudioPlayerParamParser", "wxblob localFile is null");
            } else {
              localb.filePath = ah.v(paramf.jKT());
            }
          }
        }
        else if ((!paramString3.startsWith("http://")) && (!paramString3.startsWith("https://")))
        {
          paramf = f.c(paramInfo);
          if ((paramf == null) || (!paramf.isOpen()))
          {
            Log.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", new Object[] { paramString3 });
            d.closeQuietly(paramf);
            AppMethodBeat.o(323282);
            return null;
          }
          localb.filePath = paramString3;
          localb.orw = paramf;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.b
 * JD-Core Version:    0.7.0.1
 */