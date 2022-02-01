package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class m
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, bxm parambxm, e parame)
  {
    AppMethodBeat.i(148821);
    String str = paramString;
    Object localObject = parambxm;
    for (;;)
    {
      int j;
      float f2;
      float f1;
      try
      {
        boolean bool1 = bt.isNullOrNil(paramString);
        if ((bool1) || (paramVideoTransPara == null))
        {
          AppMethodBeat.o(148821);
          return false;
        }
        bxm localbxm = parambxm;
        if (parambxm == null)
        {
          str = paramString;
          localObject = parambxm;
          localbxm = new bxm();
        }
        str = paramString;
        localObject = localbxm;
        ad.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localbxm.GRA), paramString, paramVideoTransPara, Boolean.valueOf(localbxm.GRD) });
        str = paramString;
        localObject = localbxm;
        if (localbxm.GRD)
        {
          str = paramString;
          localObject = localbxm;
          ad.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localbxm;
        if (localbxm.GRA)
        {
          str = paramString;
          localObject = localbxm;
          if (!bt.isNullOrNil(paramString))
          {
            str = paramString;
            localObject = localbxm;
            SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.aGQ().getWeixinMeta());
            str = paramString;
            localObject = localbxm;
            if (!bt.isNullOrNil(localbxm.GRC))
            {
              str = paramString;
              localObject = localbxm;
              SightVideoJNI.tagMp4RecordInfo(paramString, localbxm.GRC);
            }
            str = paramString;
            localObject = localbxm;
            long l = bt.HI();
            str = paramString;
            localObject = localbxm;
            SightVideoJNI.optimizeMP4VFS(paramString);
            str = paramString;
            localObject = localbxm;
            ad.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
            str = paramString;
            localObject = localbxm;
            parame.dlg();
            str = paramString;
            localObject = localbxm;
            paramString = i.k(paramString, false);
            str = paramString;
            localObject = localbxm;
            parambxm = new com.tencent.mm.compatible.h.d();
            str = paramString;
            localObject = localbxm;
            parambxm.setDataSource(paramString);
            str = paramString;
            localObject = localbxm;
            i = bt.getInt(parambxm.extractMetadata(18), 0);
            str = paramString;
            localObject = localbxm;
            int k = bt.getInt(parambxm.extractMetadata(19), 0);
            str = paramString;
            localObject = localbxm;
            j = bt.getInt(parambxm.extractMetadata(20), 0);
            str = paramString;
            localObject = localbxm;
            parambxm.release();
            str = paramString;
            localObject = localbxm;
            ad.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            str = paramString;
            localObject = localbxm;
            ad.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(paramVideoTransPara.hVr) });
            str = paramString;
            localObject = localbxm;
            k = Math.min(i, k);
            str = paramString;
            localObject = localbxm;
            if (ae.gcL.gbt != 1) {
              continue;
            }
            bool1 = true;
            str = paramString;
            localObject = localbxm;
            if (bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
              continue;
            }
            bool2 = true;
            str = paramString;
            localObject = localbxm;
            f2 = bt.getFloat(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
            str = paramString;
            localObject = localbxm;
            parambxm = SightVideoJNI.getMP4CprtH(paramString);
            f1 = f2;
            if (parambxm != null)
            {
              f1 = f2;
              str = paramString;
              localObject = localbxm;
              if (parambxm.length() >= 17)
              {
                f1 = f2;
                str = paramString;
                localObject = localbxm;
                if (parambxm.substring(0, 17).equals("AdaptiveBitrateUP"))
                {
                  str = paramString;
                  localObject = localbxm;
                  ad.i("MicroMsg.SightSendVideoLogic", "ABA: checkShouldRemuxing use aba: %s ", new Object[] { parambxm });
                  f1 = 2.0F;
                }
              }
            }
            str = paramString;
            localObject = localbxm;
            if ((paramVideoTransPara.hVr & 0x2) == 0) {
              break label1115;
            }
            f1 = 2.0F;
            str = paramString;
            localObject = localbxm;
            f2 = paramVideoTransPara.videoBitrate;
            str = paramString;
            localObject = localbxm;
            if (!localbxm.GRE) {
              break label1105;
            }
            str = paramString;
            localObject = localbxm;
            ad.i("MicroMsg.SightSendVideoLogic", "from skip compress, set to bitrate upper bound to 2400000");
            str = paramString;
            localObject = localbxm;
            f2 = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
            str = paramString;
            localObject = localbxm;
            ad.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(f1) });
            if (bool1) {
              break label1118;
            }
            if (!bool2) {
              continue;
            }
            break label1118;
            str = paramString;
            localObject = localbxm;
            if (k > paramVideoTransPara.width)
            {
              str = paramString;
              localObject = localbxm;
              if ((k <= paramVideoTransPara.width) || (k % 16 != 0)) {
                break label1124;
              }
              str = paramString;
              localObject = localbxm;
              if (Math.abs(k - paramVideoTransPara.width) >= 16) {
                break label1124;
              }
            }
            str = paramString;
            localObject = localbxm;
            bool1 = localbxm.GRz;
            if (!bool1) {
              continue;
            }
            AppMethodBeat.o(148821);
            return true;
          }
        }
        AppMethodBeat.o(148821);
        return false;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        i = 0;
        continue;
        if (i != 0)
        {
          f2 = j;
          str = paramString;
          localObject = localbxm;
          if (f2 >= paramVideoTransPara.videoBitrate * f1)
          {
            str = paramString;
            localObject = localbxm;
            ad.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
            str = paramString;
            localObject = localbxm;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 205L, 1L, false);
            AppMethodBeat.o(148821);
            return true;
          }
        }
        str = paramString;
        localObject = localbxm;
        localbxm.GRD = true;
        AppMethodBeat.o(148821);
        return false;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramString.getMessage(), str });
        if (localObject == null) {
          continue;
        }
        ((bxm)localObject).GRD = true;
        AppMethodBeat.o(148821);
        return false;
      }
      AppMethodBeat.o(148821);
      return true;
      label1105:
      f2 *= f1;
      continue;
      label1115:
      continue;
      label1118:
      int i = 1;
      continue;
      label1124:
      if ((i == 0) || (j < f2)) {}
    }
  }
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, bxm parambxm, e parame)
  {
    AppMethodBeat.i(148822);
    if ((parambxm == null) || (!parambxm.GRA) || (!i.fv(paramString)))
    {
      AppMethodBeat.o(148822);
      return -1;
    }
    if (parambxm.GRD) {
      ad.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
    }
    for (;;)
    {
      Object localObject;
      label132:
      int n;
      int i1;
      label385:
      label615:
      int k;
      try
      {
        localObject = i.aYr(paramString);
        if (!((String)localObject).endsWith("/"))
        {
          localObject = (String)localObject + "/";
          String str1 = new com.tencent.mm.vfs.e(paramString).getName();
          i = str1.lastIndexOf('.');
          if (i > 0)
          {
            str1 = str1.substring(0, i);
            String str3 = (String)localObject + str1 + "_hd";
            String str2 = str3;
            if (paramString.endsWith(".mp4")) {
              str2 = str3 + ".mp4";
            }
            str3 = (String)localObject + str1 + "tempRemuxing.mp4";
            i.mz(paramString, str2);
            ad.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str1, str2, str3, Integer.valueOf(parambxm.sJZ) });
            str1 = i.k(str2, true);
            str2 = i.k(str3, true);
            localObject = new com.tencent.mm.compatible.h.d();
            ((MediaMetadataRetriever)localObject).setDataSource(str1);
            n = bt.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
            i1 = bt.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
            i = Math.min(n, i1);
            if (i <= paramVideoTransPara.width) {
              break label1017;
            }
            if ((i > paramVideoTransPara.width) && (i % 16 == 0) && (Math.abs(i - paramVideoTransPara.width) < 16))
            {
              break label1017;
              ad.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), paramVideoTransPara });
              long l = bt.HI();
              if (parambxm.GRE)
              {
                ad.i("MicroMsg.SightSendVideoLogic", "from skip compress, set remux target bitrate to 2400000");
                paramVideoTransPara.videoBitrate = bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
              }
              localObject = new int[29];
              if ((paramVideoTransPara.hVq != 1) && (paramVideoTransPara.hVq != 2)) {
                break label1008;
              }
              localObject = AdaptiveAdjustBitrate.a(str1, j, i, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 0.0F, 0.0F, 2, paramVideoTransPara.hVs, paramVideoTransPara.hVt, paramVideoTransPara.hVu, paramVideoTransPara.hVv, paramVideoTransPara.hVw, paramVideoTransPara.hVx, paramVideoTransPara.hVy);
              if (localObject == null) {
                break label1028;
              }
              paramVideoTransPara.videoBitrate = (localObject[0] * 1000);
              break label1028;
              ad.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(i), Integer.valueOf(j) });
              if (paramVideoTransPara.hVr != 1) {
                break label1095;
              }
              ad.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.hhV), Integer.valueOf(paramVideoTransPara.hhW) });
              k = paramVideoTransPara.hhV;
              m = paramVideoTransPara.hhW;
              k = SightVideoJNI.remuxingVFS(str1, str2, i, j, paramVideoTransPara.videoBitrate, paramVideoTransPara.hVf, 8, paramVideoTransPara.hVe, 25.0F, 30.0F, null, 0, false, k, m);
              ad.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(bt.aO(l)) });
              i.mA(str2, paramString);
              paramString = i.k(paramString, true);
              l = bt.HI();
              if (paramVideoTransPara.hVq > 0)
              {
                SightVideoJNI.addReportMetadata(paramString, (int[])localObject, paramVideoTransPara.hVq, 0);
                if (parambxm.GRA)
                {
                  SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.aGQ().getWeixinMeta());
                  if (!bt.isNullOrNil(parambxm.GRC)) {
                    SightVideoJNI.tagMp4RecordInfo(paramString, parambxm.GRC);
                  }
                  SightVideoJNI.optimizeMP4VFS(paramString);
                }
                parame.dlg();
                ad.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
                AppMethodBeat.o(148822);
                return k;
              }
            }
            else
            {
              if (n < i1)
              {
                k = paramVideoTransPara.width;
                d = 1.0D * n / k;
                i = (int)(i1 / d);
                break label1050;
              }
              i = paramVideoTransPara.width;
              double d = 1.0D * i1 / i;
              k = (int)(n / d);
              break label1050;
            }
            if (paramVideoTransPara.hVr != 1) {
              continue;
            }
            SightVideoJNI.addReportMetadata(paramString, (int[])localObject, 0, paramVideoTransPara.hVr);
            continue;
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(148822);
        return -1;
      }
      label1008:
      label1017:
      do
      {
        break label615;
        break label132;
        break;
        j = i1;
        i = n;
        break label385;
      } while (localObject[5] <= 0);
      label1028:
      int i = localObject[1];
      int j = localObject[2];
      continue;
      label1050:
      int m = i;
      if (i % 2 != 0) {
        m = i + 1;
      }
      j = m;
      i = k;
      if (k % 2 != 0)
      {
        i = k + 1;
        j = m;
        continue;
        label1095:
        k = 0;
        m = 51;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.m
 * JD-Core Version:    0.7.0.1
 */