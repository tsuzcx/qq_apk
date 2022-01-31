package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;

public final class l
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, bby parambby, d paramd)
  {
    AppMethodBeat.i(60311);
    Object localObject = parambby;
    for (;;)
    {
      try
      {
        boolean bool1 = bo.isNullOrNil(paramString);
        if ((bool1) || (paramVideoTransPara == null))
        {
          AppMethodBeat.o(60311);
          return false;
        }
        bby localbby = parambby;
        if (parambby == null)
        {
          localObject = parambby;
          localbby = new bby();
        }
        localObject = localbby;
        ab.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localbby.xra), paramString, paramVideoTransPara, Boolean.valueOf(localbby.xre) });
        localObject = localbby;
        if (localbby.xre)
        {
          localObject = localbby;
          ab.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          AppMethodBeat.o(60311);
          return false;
        }
        localObject = localbby;
        int j;
        float f1;
        if (localbby.xra)
        {
          localObject = localbby;
          if (!bo.isNullOrNil(paramString))
          {
            localObject = localbby;
            SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.afW().getWeixinMeta());
            localObject = localbby;
            if (!bo.isNullOrNil(localbby.xrd))
            {
              localObject = localbby;
              SightVideoJNI.tagMp4RecordInfo(paramString, localbby.xrd);
            }
            localObject = localbby;
            long l = bo.yB();
            localObject = localbby;
            SightVideoJNI.optimizeMP4(paramString);
            localObject = localbby;
            ab.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(bo.av(l)) });
            localObject = localbby;
            paramd.bPn();
            localObject = localbby;
            parambby = new MediaMetadataRetriever();
            localObject = localbby;
            parambby.setDataSource(paramString);
            localObject = localbby;
            i = bo.getInt(parambby.extractMetadata(18), 0);
            localObject = localbby;
            int k = bo.getInt(parambby.extractMetadata(19), 0);
            localObject = localbby;
            j = bo.getInt(parambby.extractMetadata(20), 0);
            localObject = localbby;
            parambby.release();
            localObject = localbby;
            ab.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            localObject = localbby;
            ab.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate) });
            localObject = localbby;
            k = Math.min(i, k);
            localObject = localbby;
            if (ac.erB.eqU != 1) {
              continue;
            }
            bool1 = true;
            localObject = localbby;
            if (bo.getInt(((a)g.E(a.class)).Nq().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
              continue;
            }
            bool2 = true;
            localObject = localbby;
            f1 = bo.getFloat(((a)g.E(a.class)).Nq().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
            localObject = localbby;
            ab.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(f1) });
            if (bool1) {
              break label810;
            }
            if (!bool2) {
              continue;
            }
            break label810;
            localObject = localbby;
            if (k > paramVideoTransPara.width)
            {
              localObject = localbby;
              if ((k > paramVideoTransPara.width) && (k % 16 == 0))
              {
                localObject = localbby;
                if (Math.abs(k - paramVideoTransPara.width) < 16) {}
              }
              else
              {
                if (i == 0) {
                  continue;
                }
                localObject = localbby;
                if (j < paramVideoTransPara.videoBitrate * f1) {
                  continue;
                }
              }
            }
            localObject = localbby;
            bool1 = localbby.xqZ;
            if (!bool1) {
              continue;
            }
            AppMethodBeat.o(60311);
            return true;
          }
        }
        AppMethodBeat.o(60311);
        return false;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        i = 0;
        continue;
        if (i != 0)
        {
          float f2 = j;
          localObject = localbby;
          if (f2 >= paramVideoTransPara.videoBitrate * f1)
          {
            localObject = localbby;
            ab.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
            localObject = localbby;
            h.qsU.idkeyStat(440L, 205L, 1L, false);
            AppMethodBeat.o(60311);
            return true;
          }
        }
        localObject = localbby;
        localbby.xre = true;
        AppMethodBeat.o(60311);
        return false;
        AppMethodBeat.o(60311);
        return true;
      }
      catch (Exception paramVideoTransPara)
      {
        ab.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramVideoTransPara.getMessage(), paramString });
        if (localObject != null) {
          ((bby)localObject).xre = true;
        }
        AppMethodBeat.o(60311);
        return false;
      }
      label810:
      int i = 1;
    }
  }
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, bby parambby, d paramd)
  {
    AppMethodBeat.i(60312);
    if ((parambby == null) || (!parambby.xra) || (!com.tencent.mm.vfs.e.cN(paramString)))
    {
      AppMethodBeat.o(60312);
      return -1;
    }
    if (parambby.xre) {
      ab.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
    }
    for (;;)
    {
      int n;
      int i1;
      int j;
      try
      {
        Object localObject = com.tencent.mm.vfs.e.avK(paramString);
        if (!((String)localObject).endsWith("/"))
        {
          localObject = (String)localObject + "/";
          String str2 = new b(paramString).getName();
          i = str2.lastIndexOf('.');
          if (i > 0)
          {
            str2 = str2.substring(0, i);
            String str3 = (String)localObject + str2 + "_hd";
            String str1 = str3;
            if (paramString.endsWith(".mp4")) {
              str1 = str3 + ".mp4";
            }
            str3 = (String)localObject + str2 + "tempRemuxing.mp4";
            com.tencent.mm.vfs.e.C(paramString, str1);
            ab.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str2, str1, str3, Integer.valueOf(parambby.xrb) });
            localObject = new MediaMetadataRetriever();
            ((MediaMetadataRetriever)localObject).setDataSource(str1);
            n = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
            i1 = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
            i = Math.min(n, i1);
            if (i <= paramVideoTransPara.width) {
              break label940;
            }
            if ((i > paramVideoTransPara.width) && (i % 16 == 0) && (Math.abs(i - paramVideoTransPara.width) < 16))
            {
              break label940;
              ab.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(m), paramVideoTransPara });
              long l = bo.yB();
              localObject = new int[1];
              localObject[0] = -1;
              if ((paramVideoTransPara.fAh == 1) || (paramVideoTransPara.fAh == 2))
              {
                localObject = AdaptiveAdjustBitrate.GetBitrate(str1, paramVideoTransPara.height, paramVideoTransPara.width, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 0.0F, 0.0F, 2, paramVideoTransPara.fAj, paramVideoTransPara.fAk, paramVideoTransPara.fAl, paramVideoTransPara.fAm);
                paramVideoTransPara.videoBitrate = (localObject[0] * 1000);
                i = localObject[1];
                m = localObject[2];
                ab.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(i), Integer.valueOf(m) });
              }
              if (paramVideoTransPara.fAi != 2) {
                break label996;
              }
              ab.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.fAn), Integer.valueOf(paramVideoTransPara.fAo) });
              j = paramVideoTransPara.fAn;
              k = paramVideoTransPara.fAo;
              j = SightVideoJNI.remuxing(str1, str3, i, m, paramVideoTransPara.videoBitrate, paramVideoTransPara.fzW, 8, paramVideoTransPara.fzV, 25.0F, 30.0F, null, 0, false, j, k);
              ab.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(j), Long.valueOf(bo.av(l)) });
              com.tencent.mm.vfs.e.aT(str3, paramString);
              l = bo.yB();
              if (paramVideoTransPara.fAh > 0)
              {
                SightVideoJNI.addReportMetadata(paramString, (int[])localObject, paramVideoTransPara.fAh, 0);
                if (parambby.xra)
                {
                  SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.afW().getWeixinMeta());
                  if (!bo.isNullOrNil(parambby.xrd)) {
                    SightVideoJNI.tagMp4RecordInfo(paramString, parambby.xrd);
                  }
                  SightVideoJNI.optimizeMP4(paramString);
                }
                paramd.bPn();
                ab.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(bo.av(l)) });
                AppMethodBeat.o(60312);
                return j;
              }
            }
            else
            {
              if (n < i1)
              {
                j = paramVideoTransPara.width;
                d = 1.0D * n / j;
                i = (int)(i1 / d);
                break label951;
              }
              i = paramVideoTransPara.width;
              double d = 1.0D * i1 / i;
              j = (int)(n / d);
              break label951;
            }
            if (paramVideoTransPara.fAi != 2) {
              continue;
            }
            SightVideoJNI.addReportMetadata(paramString, (int[])localObject, 0, paramVideoTransPara.fAi);
            continue;
          }
          continue;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(60312);
        return -1;
      }
      continue;
      label940:
      int m = i1;
      int i = n;
      continue;
      label951:
      int k = i;
      if (i % 2 != 0) {
        k = i + 1;
      }
      i = j;
      m = k;
      if (j % 2 != 0)
      {
        i = j + 1;
        m = k;
        continue;
        label996:
        j = 0;
        k = 51;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */