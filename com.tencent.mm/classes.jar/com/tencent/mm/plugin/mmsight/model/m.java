package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class m
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, bsz parambsz, e parame)
  {
    AppMethodBeat.i(148821);
    String str = paramString;
    Object localObject = parambsz;
    for (;;)
    {
      int j;
      float f2;
      float f1;
      try
      {
        boolean bool1 = bs.isNullOrNil(paramString);
        if ((bool1) || (paramVideoTransPara == null))
        {
          AppMethodBeat.o(148821);
          return false;
        }
        bsz localbsz = parambsz;
        if (parambsz == null)
        {
          str = paramString;
          localObject = parambsz;
          localbsz = new bsz();
        }
        str = paramString;
        localObject = localbsz;
        ac.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localbsz.FhZ), paramString, paramVideoTransPara, Boolean.valueOf(localbsz.Fic) });
        str = paramString;
        localObject = localbsz;
        if (localbsz.Fic)
        {
          str = paramString;
          localObject = localbsz;
          ac.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localbsz;
        if (localbsz.FhZ)
        {
          str = paramString;
          localObject = localbsz;
          if (!bs.isNullOrNil(paramString))
          {
            str = paramString;
            localObject = localbsz;
            SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.aDL().getWeixinMeta());
            str = paramString;
            localObject = localbsz;
            if (!bs.isNullOrNil(localbsz.Fib))
            {
              str = paramString;
              localObject = localbsz;
              SightVideoJNI.tagMp4RecordInfo(paramString, localbsz.Fib);
            }
            str = paramString;
            localObject = localbsz;
            long l = bs.Gn();
            str = paramString;
            localObject = localbsz;
            SightVideoJNI.optimizeMP4VFS(paramString);
            str = paramString;
            localObject = localbsz;
            ac.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
            str = paramString;
            localObject = localbsz;
            parame.dbM();
            str = paramString;
            localObject = localbsz;
            paramString = i.k(paramString, false);
            str = paramString;
            localObject = localbsz;
            parambsz = new com.tencent.mm.compatible.h.d();
            str = paramString;
            localObject = localbsz;
            parambsz.setDataSource(paramString);
            str = paramString;
            localObject = localbsz;
            i = bs.getInt(parambsz.extractMetadata(18), 0);
            str = paramString;
            localObject = localbsz;
            int k = bs.getInt(parambsz.extractMetadata(19), 0);
            str = paramString;
            localObject = localbsz;
            j = bs.getInt(parambsz.extractMetadata(20), 0);
            str = paramString;
            localObject = localbsz;
            parambsz.release();
            str = paramString;
            localObject = localbsz;
            ac.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            str = paramString;
            localObject = localbsz;
            ac.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(paramVideoTransPara.hCM) });
            str = paramString;
            localObject = localbsz;
            k = Math.min(i, k);
            str = paramString;
            localObject = localbsz;
            if (ae.fJk.fHT != 1) {
              continue;
            }
            bool1 = true;
            str = paramString;
            localObject = localbsz;
            if (bs.getInt(((a)g.ab(a.class)).ZY().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
              continue;
            }
            bool2 = true;
            str = paramString;
            localObject = localbsz;
            f2 = bs.getFloat(((a)g.ab(a.class)).ZY().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
            str = paramString;
            localObject = localbsz;
            parambsz = SightVideoJNI.getMP4CprtH(paramString);
            f1 = f2;
            if (parambsz != null)
            {
              f1 = f2;
              str = paramString;
              localObject = localbsz;
              if (parambsz.length() >= 17)
              {
                f1 = f2;
                str = paramString;
                localObject = localbsz;
                if (parambsz.substring(0, 17).equals("AdaptiveBitrateUP"))
                {
                  str = paramString;
                  localObject = localbsz;
                  ac.i("MicroMsg.SightSendVideoLogic", "ABA: checkShouldRemuxing use aba: %s ", new Object[] { parambsz });
                  f1 = 2.0F;
                }
              }
            }
            str = paramString;
            localObject = localbsz;
            if ((paramVideoTransPara.hCM & 0x2) == 0) {
              break label1115;
            }
            f1 = 2.0F;
            str = paramString;
            localObject = localbsz;
            f2 = paramVideoTransPara.videoBitrate;
            str = paramString;
            localObject = localbsz;
            if (!localbsz.Fid) {
              break label1105;
            }
            str = paramString;
            localObject = localbsz;
            ac.i("MicroMsg.SightSendVideoLogic", "from skip compress, set to bitrate upper bound to 2400000");
            str = paramString;
            localObject = localbsz;
            f2 = bs.getInt(((a)g.ab(a.class)).ZY().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
            str = paramString;
            localObject = localbsz;
            ac.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(f1) });
            if (bool1) {
              break label1118;
            }
            if (!bool2) {
              continue;
            }
            break label1118;
            str = paramString;
            localObject = localbsz;
            if (k > paramVideoTransPara.width)
            {
              str = paramString;
              localObject = localbsz;
              if ((k <= paramVideoTransPara.width) || (k % 16 != 0)) {
                break label1124;
              }
              str = paramString;
              localObject = localbsz;
              if (Math.abs(k - paramVideoTransPara.width) >= 16) {
                break label1124;
              }
            }
            str = paramString;
            localObject = localbsz;
            bool1 = localbsz.FhY;
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
          localObject = localbsz;
          if (f2 >= paramVideoTransPara.videoBitrate * f1)
          {
            str = paramString;
            localObject = localbsz;
            ac.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
            str = paramString;
            localObject = localbsz;
            h.wUl.idkeyStat(440L, 205L, 1L, false);
            AppMethodBeat.o(148821);
            return true;
          }
        }
        str = paramString;
        localObject = localbsz;
        localbsz.Fic = true;
        AppMethodBeat.o(148821);
        return false;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramString.getMessage(), str });
        if (localObject == null) {
          continue;
        }
        ((bsz)localObject).Fic = true;
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
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, bsz parambsz, e parame)
  {
    AppMethodBeat.i(148822);
    if ((parambsz == null) || (!parambsz.FhZ) || (!i.eA(paramString)))
    {
      AppMethodBeat.o(148822);
      return -1;
    }
    if (parambsz.Fic) {
      ac.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
    }
    for (;;)
    {
      Object localObject;
      label132:
      int n;
      int i1;
      label385:
      label618:
      int k;
      try
      {
        localObject = i.aSs(paramString);
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
            i.lZ(paramString, str2);
            ac.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str1, str2, str3, Integer.valueOf(parambsz.rNU) });
            str1 = i.k(str2, true);
            str2 = i.k(str3, true);
            localObject = new com.tencent.mm.compatible.h.d();
            ((MediaMetadataRetriever)localObject).setDataSource(str1);
            n = bs.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
            i1 = bs.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
            i = Math.min(n, i1);
            if (i <= paramVideoTransPara.width) {
              break label1130;
            }
            if ((i > paramVideoTransPara.width) && (i % 16 == 0) && (Math.abs(i - paramVideoTransPara.width) < 16))
            {
              break label1130;
              ac.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), paramVideoTransPara });
              long l = bs.Gn();
              if (parambsz.Fid)
              {
                ac.i("MicroMsg.SightSendVideoLogic", "from skip compress, set remux target bitrate to 2400000");
                paramVideoTransPara.videoBitrate = bs.getInt(((a)g.ab(a.class)).ZY().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
              }
              if ((paramVideoTransPara.hCL != 1) && (paramVideoTransPara.hCL != 2)) {
                break label1011;
              }
              localObject = AdaptiveAdjustBitrate.a(str1, j, i, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 0.0F, 0.0F, 2, paramVideoTransPara.hCN, paramVideoTransPara.hCO, paramVideoTransPara.hCP, paramVideoTransPara.hCQ, paramVideoTransPara.hCR, paramVideoTransPara.hCS, paramVideoTransPara.hCT);
              if ((localObject[3] <= 0) && (localObject[4] <= 0)) {
                break label1141;
              }
              paramVideoTransPara.videoBitrate = (localObject[0] * 1000);
              break label1141;
              ac.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(i), Integer.valueOf(j) });
              if (paramVideoTransPara.hCM != 1) {
                break label1208;
              }
              ac.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.gOb), Integer.valueOf(paramVideoTransPara.gOc) });
              k = paramVideoTransPara.gOb;
              m = paramVideoTransPara.gOc;
              k = SightVideoJNI.remuxingVFS(str1, str2, i, j, paramVideoTransPara.videoBitrate, paramVideoTransPara.hCA, 8, paramVideoTransPara.hCz, 25.0F, 30.0F, null, 0, false, k, m);
              ac.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(bs.aO(l)) });
              i.ma(str2, paramString);
              paramString = i.k(paramString, true);
              l = bs.Gn();
              if (paramVideoTransPara.hCL > 0)
              {
                SightVideoJNI.addReportMetadata(paramString, (int[])localObject, paramVideoTransPara.hCL, 0);
                if (parambsz.FhZ)
                {
                  SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.d.aDL().getWeixinMeta());
                  if (!bs.isNullOrNil(parambsz.Fib)) {
                    SightVideoJNI.tagMp4RecordInfo(paramString, parambsz.Fib);
                  }
                  SightVideoJNI.optimizeMP4VFS(paramString);
                }
                parame.dbM();
                ac.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
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
                break label1163;
              }
              i = paramVideoTransPara.width;
              double d = 1.0D * i1 / i;
              k = (int)(n / d);
              break label1163;
            }
            if (paramVideoTransPara.hCM != 1) {
              continue;
            }
            SightVideoJNI.addReportMetadata(paramString, (int[])localObject, 0, paramVideoTransPara.hCM);
            continue;
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(148822);
        return -1;
      }
      label1011:
      label1141:
      do
      {
        localObject = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        break label618;
        break label132;
        break;
        j = i1;
        i = n;
        break label385;
      } while (localObject[5] <= 0);
      label1130:
      int i = localObject[1];
      int j = localObject[2];
      continue;
      label1163:
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
        label1208:
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