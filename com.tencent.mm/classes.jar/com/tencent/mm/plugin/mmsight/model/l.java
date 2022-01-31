package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;

public final class l
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, avn paramavn, d paramd)
  {
    Object localObject = paramavn;
    for (;;)
    {
      try
      {
        if ((bk.bl(paramString)) || (paramVideoTransPara == null)) {
          break label734;
        }
        localavn = paramavn;
        if (paramavn == null)
        {
          localObject = paramavn;
          localavn = new avn();
        }
        localObject = localavn;
        y.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localavn.tra), paramString, paramVideoTransPara, Boolean.valueOf(localavn.tre) });
        localObject = localavn;
        if (localavn.tre)
        {
          localObject = localavn;
          y.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          return false;
        }
        localObject = localavn;
        if (!localavn.tra) {
          break label742;
        }
        localObject = localavn;
        if (bk.bl(paramString)) {
          break label742;
        }
        localObject = localavn;
        SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.Nl().getWeixinMeta());
        localObject = localavn;
        if (!bk.bl(localavn.trd))
        {
          localObject = localavn;
          SightVideoJNI.tagMp4RecordInfo(paramString, localavn.trd);
        }
        localObject = localavn;
        long l = bk.UZ();
        localObject = localavn;
        SightVideoJNI.optimizeMP4(paramString);
        localObject = localavn;
        y.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
        localObject = localavn;
        paramd.bhA();
        localObject = localavn;
        paramavn = new MediaMetadataRetriever();
        localObject = localavn;
        paramavn.setDataSource(paramString);
        localObject = localavn;
        i = bk.getInt(paramavn.extractMetadata(18), 0);
        localObject = localavn;
        k = bk.getInt(paramavn.extractMetadata(19), 0);
        localObject = localavn;
        j = bk.getInt(paramavn.extractMetadata(20), 0);
        localObject = localavn;
        paramavn.release();
        localObject = localavn;
        y.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
        localObject = localavn;
        y.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate) });
        localObject = localavn;
        k = Math.min(i, k);
        localObject = localavn;
        if (q.dyk.dyC != 1) {
          break label744;
        }
        bool1 = true;
        localObject = localavn;
        if (bk.getInt(((a)g.r(a.class)).AA().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
          break label750;
        }
        bool2 = true;
        localObject = localavn;
        f = bk.getFloat(((a)g.r(a.class)).AA().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
        localObject = localavn;
        y.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(f) });
        if (bool1) {
          break label736;
        }
        if (!bool2) {
          break label756;
        }
      }
      catch (Exception paramVideoTransPara)
      {
        avn localavn;
        int k;
        int j;
        float f;
        y.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramVideoTransPara.getMessage(), paramString });
        if (localObject == null) {
          continue;
        }
        ((avn)localObject).tre = true;
        return false;
      }
      localObject = localavn;
      if (k > paramVideoTransPara.width)
      {
        localObject = localavn;
        if ((k > paramVideoTransPara.width) && (k % 16 == 0))
        {
          localObject = localavn;
          if (Math.abs(k - paramVideoTransPara.width) < 16) {}
        }
        else
        {
          if (i == 0) {
            continue;
          }
          localObject = localavn;
          if (j < paramVideoTransPara.videoBitrate * f) {
            continue;
          }
        }
      }
      localObject = localavn;
      if (localavn.tqZ) {
        return true;
      }
      if (i != 0)
      {
        localObject = localavn;
        if (j >= paramVideoTransPara.videoBitrate * f)
        {
          localObject = localavn;
          y.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
          localObject = localavn;
          h.nFQ.a(440L, 205L, 1L, false);
          return true;
        }
      }
      localObject = localavn;
      localavn.tre = true;
      return false;
      return true;
      label734:
      return false;
      label736:
      int i = 1;
      continue;
      label742:
      return false;
      label744:
      boolean bool1 = false;
      continue;
      label750:
      boolean bool2 = false;
      continue;
      label756:
      i = 0;
    }
  }
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, avn paramavn, d paramd)
  {
    if ((paramavn == null) || (!paramavn.tra) || (!com.tencent.mm.vfs.e.bK(paramString))) {
      return -1;
    }
    if (paramavn.tre) {
      y.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
    }
    for (;;)
    {
      int n;
      int i1;
      try
      {
        Object localObject = com.tencent.mm.vfs.e.aeS(paramString);
        if (((String)localObject).endsWith("/")) {
          break label691;
        }
        localObject = (String)localObject + "/";
        String str1 = new b(paramString).getName();
        i = str1.lastIndexOf('.');
        if (i <= 0) {
          break label688;
        }
        str1 = str1.substring(0, i);
        str3 = (String)localObject + str1 + "_hd";
        str2 = str3;
        if (paramString.endsWith(".mp4")) {
          str2 = str3 + ".mp4";
        }
        str3 = (String)localObject + str1 + "tempRemuxing.mp4";
        com.tencent.mm.vfs.e.r(paramString, str2);
        y.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str1, str2, str3, Integer.valueOf(paramavn.trb) });
        localObject = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject).setDataSource(str2);
        n = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
        i1 = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
        i = Math.min(n, i1);
        if (i <= paramVideoTransPara.width) {
          break label694;
        }
        if ((i <= paramVideoTransPara.width) || (i % 16 != 0) || (Math.abs(i - paramVideoTransPara.width) >= 16)) {
          break label623;
        }
      }
      catch (Exception paramString)
      {
        String str3;
        String str2;
        long l;
        y.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[] { paramString.getMessage() });
        return -1;
      }
      y.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(m), paramVideoTransPara });
      l = bk.UZ();
      int i = SightVideoJNI.remuxing(str2, str3, j, m, paramVideoTransPara.videoBitrate, paramVideoTransPara.ejP, 8, paramVideoTransPara.ejO, 25.0F, 30.0F, null, 0, false);
      y.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
      com.tencent.mm.vfs.e.aA(str3, paramString);
      l = bk.UZ();
      if (paramavn.tra)
      {
        SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.Nl().getWeixinMeta());
        if (!bk.bl(paramavn.trd)) {
          SightVideoJNI.tagMp4RecordInfo(paramString, paramavn.trd);
        }
        SightVideoJNI.optimizeMP4(paramString);
      }
      paramd.bhA();
      y.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      return i;
      label623:
      double d;
      if (n < i1)
      {
        i = paramVideoTransPara.width;
        d = 1.0D * n / i;
        j = (int)(i1 / d);
      }
      else
      {
        j = paramVideoTransPara.width;
        d = 1.0D * i1 / j;
        i = (int)(n / d);
        break label705;
        label688:
        continue;
        label691:
        continue;
        label694:
        m = i1;
        j = n;
        continue;
      }
      label705:
      int k = j;
      if (j % 2 != 0) {
        k = j + 1;
      }
      int j = i;
      int m = k;
      if (i % 2 != 0)
      {
        j = i + 1;
        m = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */