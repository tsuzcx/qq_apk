package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.c;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.b;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;

final class l$c
  extends a
{
  public String appId = "";
  public String dtT = "";
  public String dtX = "";
  public int dvv = 0;
  public boolean error = false;
  public boolean iJE = false;
  public double iJG;
  public double iJH;
  public long iJJ;
  public long iJK;
  public String iJP = null;
  public String iJQ = null;
  public String jFn;
  private p lAw;
  public com.tencent.mm.plugin.appbrand.jsapi.f lAx;
  public WxaPkg.Info lDZ;
  public boolean loop = false;
  public int lqe;
  public String processName = "";
  
  public l$c(p paramp, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    this.lAw = paramp;
    this.lAx = paramf;
    this.lqe = paramInt;
  }
  
  public final void YC()
  {
    AppMethodBeat.i(145747);
    Log.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
    this.error = false;
    this.jFn = "";
    Object localObject1 = c.LU(this.dtX);
    b localb = new b();
    localb.dtX = this.dtX;
    localb.dvn = this.dtT;
    localb.dvv = this.dvv;
    localb.iJD = this.dvv;
    localb.iJE = this.iJE;
    localb.loop = this.loop;
    localb.processName = this.processName;
    localb.iJG = this.iJG;
    localb.appId = this.appId;
    localb.fromScene = 0;
    localb.iJH = this.iJH;
    localb.iJL = this.iJJ;
    localb.iJM = this.iJK;
    localb.iJP = this.iJP;
    localb.iJQ = this.iJQ;
    if ((localObject1 != null) && (this.dtT.equalsIgnoreCase(((b)localObject1).dvn)) && (c.LT(this.dtX)))
    {
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
      Log.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[] { localb.dtX, localb.dvn });
      localObject1 = new x();
      ((x)localObject1).dCQ.action = 18;
      ((x)localObject1).dCQ.dtX = localb.dtX;
      ((x)localObject1).dCQ.dCT = localb;
      com.tencent.mm.plugin.music.b.a.a((x)localObject1);
      if (!((x)localObject1).dCR.result)
      {
        this.error = true;
        this.jFn = "not to set audio param, the audioId is err";
        Log.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
      }
      callback();
      AppMethodBeat.o(145747);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[] { this.appId, this.dtX, this.dtT, Integer.valueOf(this.dvv) });
    if (this.dtT.startsWith("file://"))
    {
      localb.filePath = this.dtT.substring(7);
      Log.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[] { localb.filePath });
    }
    do
    {
      for (;;)
      {
        if (!this.error)
        {
          Log.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", new Object[] { localb.dtX });
          localObject1 = new x();
          ((x)localObject1).dCQ.action = 0;
          ((x)localObject1).dCQ.dtX = localb.dtX;
          ((x)localObject1).dCQ.dCT = localb;
          com.tencent.mm.plugin.music.b.a.a((x)localObject1);
        }
        callback();
        AppMethodBeat.o(145747);
        return;
        if ((this.dtT.contains("base64")) && (this.dtT.startsWith("data:audio")))
        {
          localb.filePath = g.abx(this.dtT.substring(this.dtT.indexOf("base64,") + 7).trim());
          Log.i("MicroMsg.Audio.JsApiSetAudioState", "base64 decode filePath:%s", new Object[] { localb.filePath });
        }
        else
        {
          if (!this.dtT.startsWith("wxblob://")) {
            break;
          }
          localObject1 = new i();
          if (this.lAx.getFileSystem().b(this.dtT, (i)localObject1) == m.kSu)
          {
            localb.iJU = ((ByteBuffer)((i)localObject1).value);
            localb.filePath = this.dtT;
            Log.i("MicroMsg.Audio.JsApiSetAudioState", "wxblob read ok");
          }
          else
          {
            Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob read fail");
            localObject1 = this.lAx.getFileSystem().VV(this.dtT);
            if ((localObject1 == null) || (!((o)localObject1).exists()))
            {
              Log.e("MicroMsg.Audio.JsApiSetAudioState", "wxblob localFile is null");
              this.error = true;
              this.jFn = "wxblob localFile is null";
            }
            else
            {
              localb.filePath = aa.z(((o)localObject1).her());
            }
          }
        }
      }
    } while ((this.dtT.startsWith("http://")) || (this.dtT.startsWith("https://")));
    com.tencent.mm.ai.e locale = com.tencent.mm.plugin.appbrand.media.a.f.c(this.lDZ);
    if ((locale == null) || (!locale.isOpen()))
    {
      org.apache.commons.a.e.closeQuietly(locale);
      this.error = true;
      this.jFn = "the file not exist for src";
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[] { this.dtT });
      callback();
      AppMethodBeat.o(145747);
      return;
    }
    if ((localObject1 != null) && (this.dtT.equalsIgnoreCase(((b)localObject1).dvn)) && (!TextUtils.isEmpty(((b)localObject1).filePath))) {
      localObject1 = ((b)localObject1).filePath;
    }
    for (;;)
    {
      localb.filePath = ((String)localObject1);
      localb.iJR = locale;
      break;
      Object localObject2 = this.lAx;
      localObject1 = this.dtT;
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.e("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
      }
      else if (((com.tencent.mm.plugin.appbrand.jsapi.f)localObject2).getFileSystem() == null)
      {
        Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
      }
      else
      {
        localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject2).getFileSystem().VY((String)localObject1);
        if ((localObject2 == null) || (!((o)localObject2).exists()))
        {
          Log.e("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
        }
        else
        {
          localObject1 = aa.z(((o)localObject2).her());
          Log.i("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { localObject1 });
        }
      }
    }
  }
  
  public final void callback()
  {
    AppMethodBeat.i(145748);
    super.callback();
    if (this.lAx == null)
    {
      Log.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
      AppMethodBeat.o(145748);
      return;
    }
    if (this.error)
    {
      this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
      AppMethodBeat.o(145748);
      return;
    }
    this.lAx.i(this.lqe, this.lAw.h("ok", null));
    AppMethodBeat.o(145748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l.c
 * JD-Core Version:    0.7.0.1
 */