package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

final class a$5
  implements CdnLogic.DownloadCallback
{
  a$5(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(213153);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end , cost：%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - this.jtx) });
    if ((paramC2CDownloadResult != null) && (paramC2CDownloadResult.cronetTaskResult != null) && (paramC2CDownloadResult.cronetTaskResult.performance != null)) {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download end, url:%s, statusCode:%d, profile:%s", new Object[] { this.val$url, Integer.valueOf(paramC2CDownloadResult.cronetTaskResult.statusCode), paramC2CDownloadResult.cronetTaskResult.performance });
    }
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download result.errorCode ：%s， tempFilePath ：%s , md5：%s , file downaload md5:%s ", new Object[] { Integer.valueOf(paramC2CDownloadResult.errorCode), this.qxi, this.lhI, s.bhK(this.qxi) });
    if (paramC2CDownloadResult.errorCode != 0)
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voice resource download failed:%s", new Object[] { Integer.valueOf(paramC2CDownloadResult.errorCode) });
      AppMethodBeat.o(213153);
      return;
    }
    if (!s.YS(this.qxi))
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "  download File fail:%s", new Object[] { this.qxi });
      AppMethodBeat.o(213153);
      return;
    }
    if (!this.lhI.equalsIgnoreCase(s.bhK(this.qxi)))
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "download md5 check failed，md5 :%s    ,  download md5:%s", new Object[] { this.lhI, s.bhK(this.qxi) });
      AppMethodBeat.o(213153);
      return;
    }
    s.boN(a.mjC);
    paramString = a.mjC + this.qxj + ".pos";
    if (s.YS(paramString))
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", " has this voice resource before ，first delete exist file");
      s.deleteFile(paramString);
    }
    s.nw(this.qxi, paramString);
    s.deleteFile(this.qxi);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile form %s  to   %s", new Object[] { this.qxi, paramString });
    d.bIh().h(this.qxj, paramString, this.lhI, this.qxk);
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "save config  posID： %s，voicePath：%s ， md5 ：%s , version:%s", new Object[] { this.qxj, paramString, this.lhI, this.qxk });
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "currentResID %s、download ResID %s", new Object[] { a.bIg(), this.qxj });
    if (a.bIg().equals(this.qxj))
    {
      Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "set currentResID  for new resource");
      a.aaw(this.qxj);
    }
    AppMethodBeat.o(213153);
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.a.5
 * JD-Core Version:    0.7.0.1
 */