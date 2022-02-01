package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class l
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, cuv paramcuv, e parame)
  {
    AppMethodBeat.i(148821);
    String str = paramString;
    Object localObject = paramcuv;
    for (;;)
    {
      int i;
      int j;
      float f2;
      float f1;
      try
      {
        boolean bool1 = Util.isNullOrNil(paramString);
        if ((bool1) || (paramVideoTransPara == null))
        {
          AppMethodBeat.o(148821);
          return false;
        }
        cuv localcuv = paramcuv;
        if (paramcuv == null)
        {
          str = paramString;
          localObject = paramcuv;
          localcuv = new cuv();
        }
        str = paramString;
        localObject = localcuv;
        Log.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localcuv.TCA), paramString, paramVideoTransPara, Boolean.valueOf(localcuv.TCD) });
        str = paramString;
        localObject = localcuv;
        if (localcuv.TCD)
        {
          str = paramString;
          localObject = localcuv;
          Log.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localcuv;
        int k;
        if (localcuv.TCA)
        {
          str = paramString;
          localObject = localcuv;
          if (!Util.isNullOrNil(paramString))
          {
            str = paramString;
            localObject = localcuv;
            SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.e.bkp().getWeixinMeta());
            str = paramString;
            localObject = localcuv;
            if (!Util.isNullOrNil(localcuv.TCC))
            {
              str = paramString;
              localObject = localcuv;
              SightVideoJNI.tagMp4RecordInfo(paramString, localcuv.TCC);
            }
            str = paramString;
            localObject = localcuv;
            long l = Util.currentTicks();
            str = paramString;
            localObject = localcuv;
            SightVideoJNI.optimizeMP4VFS(paramString);
            str = paramString;
            localObject = localcuv;
            Log.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
            str = paramString;
            localObject = localcuv;
            parame.eRA();
            str = paramString;
            localObject = localcuv;
            paramString = u.n(paramString, false);
            str = paramString;
            localObject = localcuv;
            paramcuv = new d();
            str = paramString;
            localObject = localcuv;
            paramcuv.setDataSource(paramString);
            str = paramString;
            localObject = localcuv;
            i = Util.getInt(paramcuv.extractMetadata(18), 0);
            str = paramString;
            localObject = localcuv;
            k = Util.getInt(paramcuv.extractMetadata(19), 0);
            str = paramString;
            localObject = localcuv;
            j = Util.getInt(paramcuv.extractMetadata(20), 0);
            str = paramString;
            localObject = localcuv;
            paramcuv.release();
            str = paramString;
            localObject = localcuv;
            Log.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            str = paramString;
            localObject = localcuv;
            Log.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(paramVideoTransPara.lJA) });
            str = paramString;
            localObject = localcuv;
            k = Math.min(i, k);
            str = paramString;
            localObject = localcuv;
            if (af.juO.jtr != 1) {
              continue;
            }
            bool1 = true;
            str = paramString;
            localObject = localcuv;
            if (Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
              continue;
            }
            bool2 = true;
            str = paramString;
            localObject = localcuv;
            f2 = Util.getFloat(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
            str = paramString;
            localObject = localcuv;
            paramcuv = SightVideoJNI.getMP4CprtH(paramString);
            f1 = f2;
            if (paramcuv != null)
            {
              f1 = f2;
              str = paramString;
              localObject = localcuv;
              if (paramcuv.length() >= 17)
              {
                f1 = f2;
                str = paramString;
                localObject = localcuv;
                if (paramcuv.substring(0, 17).equals("AdaptiveBitrateUP"))
                {
                  str = paramString;
                  localObject = localcuv;
                  Log.i("MicroMsg.SightSendVideoLogic", "ABA: checkShouldRemuxing use aba: %s ", new Object[] { paramcuv });
                  f1 = 2.0F;
                }
              }
            }
            str = paramString;
            localObject = localcuv;
            if ((paramVideoTransPara.lJA & 0x2) == 0) {
              break label1163;
            }
            f1 = 2.0F;
            str = paramString;
            localObject = localcuv;
            f2 = paramVideoTransPara.videoBitrate;
            str = paramString;
            localObject = localcuv;
            if (!localcuv.TCE) {
              break label1153;
            }
            str = paramString;
            localObject = localcuv;
            Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set to bitrate upper bound to 12000000");
            str = paramString;
            localObject = localcuv;
            f2 = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 12000000);
            str = paramString;
            localObject = localcuv;
            Log.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(f1) });
            if ((!bool1) && (!bool2)) {
              continue;
            }
            i = 1;
            if ((i == 0) || (j < f2)) {
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
        str = paramString;
        localObject = localcuv;
        bool1 = localcuv.TCE;
        if (bool1)
        {
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localcuv;
        if (k > paramVideoTransPara.width)
        {
          str = paramString;
          localObject = localcuv;
          if ((k <= paramVideoTransPara.width) || (k % 16 != 0)) {
            break label1166;
          }
          str = paramString;
          localObject = localcuv;
          if (Math.abs(k - paramVideoTransPara.width) >= 16) {
            break label1166;
          }
        }
        str = paramString;
        localObject = localcuv;
        bool1 = localcuv.TCz;
        if (bool1)
        {
          AppMethodBeat.o(148821);
          return true;
        }
        if (i != 0)
        {
          f2 = j;
          str = paramString;
          localObject = localcuv;
          if (f2 >= paramVideoTransPara.videoBitrate * f1)
          {
            str = paramString;
            localObject = localcuv;
            Log.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
            str = paramString;
            localObject = localcuv;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 205L, 1L, false);
            AppMethodBeat.o(148821);
            return true;
          }
        }
        str = paramString;
        localObject = localcuv;
        localcuv.TCD = true;
        AppMethodBeat.o(148821);
        return false;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramString.getMessage(), str });
        if (localObject == null) {
          continue;
        }
        ((cuv)localObject).TCD = true;
        AppMethodBeat.o(148821);
        return false;
      }
      AppMethodBeat.o(148821);
      return true;
      label1153:
      f2 *= f1;
      continue;
      label1163:
      continue;
      label1166:
      if ((i == 0) || (j < f2)) {}
    }
  }
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, cuv paramcuv, e parame)
  {
    AppMethodBeat.i(148822);
    if ((paramcuv == null) || (!paramcuv.TCA) || (!u.agG(paramString)))
    {
      AppMethodBeat.o(148822);
      return -1;
    }
    if (paramcuv.TCD) {
      Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
    }
    for (;;)
    {
      Object localObject;
      label132:
      int n;
      int i1;
      label385:
      label616:
      int k;
      try
      {
        localObject = u.bBT(paramString);
        if (!((String)localObject).endsWith("/"))
        {
          localObject = (String)localObject + "/";
          String str1 = new q(paramString).getName();
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
            u.on(paramString, str2);
            Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str1, str2, str3, Integer.valueOf(paramcuv.ABK) });
            str1 = u.n(str2, true);
            str2 = u.n(str3, true);
            localObject = new d();
            ((MediaMetadataRetriever)localObject).setDataSource(str1);
            n = Util.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
            i1 = Util.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
            i = Math.min(n, i1);
            if (i <= paramVideoTransPara.width) {
              break label1019;
            }
            if ((i > paramVideoTransPara.width) && (i % 16 == 0) && (Math.abs(i - paramVideoTransPara.width) < 16))
            {
              break label1019;
              Log.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), paramVideoTransPara });
              long l = Util.currentTicks();
              if (paramcuv.TCE)
              {
                Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set remux target bitrate to 12000000");
                paramVideoTransPara.videoBitrate = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 12000000);
              }
              localObject = new int[34];
              if ((paramVideoTransPara.lJz != 1) && (paramVideoTransPara.lJz != 2)) {
                break label1010;
              }
              localObject = AdaptiveAdjustBitrate.a(str1, j, i, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 0.0F, 0.0F, 2, paramVideoTransPara.lJB, paramVideoTransPara.lJC, paramVideoTransPara.lJD, paramVideoTransPara.lJE, paramVideoTransPara.lJF, paramVideoTransPara.lJG, paramVideoTransPara.lJH, false);
              if (localObject == null) {
                break label1030;
              }
              paramVideoTransPara.videoBitrate = (localObject[0] * 1000);
              break label1030;
              Log.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(i), Integer.valueOf(j) });
              if (paramVideoTransPara.lJA != 1) {
                break label1097;
              }
              Log.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.kSl), Integer.valueOf(paramVideoTransPara.kSm) });
              k = paramVideoTransPara.kSl;
              m = paramVideoTransPara.kSm;
              k = SightVideoJNI.remuxingVFS(str1, str2, i, j, paramVideoTransPara.videoBitrate, paramVideoTransPara.lJn, 8, paramVideoTransPara.lJm, 25.0F, 30.0F, null, 0, false, k, m);
              Log.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
              u.oo(str2, paramString);
              paramString = u.n(paramString, true);
              l = Util.currentTicks();
              if (paramVideoTransPara.lJz > 0)
              {
                SightVideoJNI.addReportMetadata(paramString, (int[])localObject, paramVideoTransPara.lJz, 0);
                if (paramcuv.TCA)
                {
                  SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.e.bkp().getWeixinMeta());
                  if (!Util.isNullOrNil(paramcuv.TCC)) {
                    SightVideoJNI.tagMp4RecordInfo(paramString, paramcuv.TCC);
                  }
                  SightVideoJNI.optimizeMP4VFS(paramString);
                }
                parame.eRA();
                Log.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
                break label1052;
              }
              i = paramVideoTransPara.width;
              double d = 1.0D * i1 / i;
              k = (int)(n / d);
              break label1052;
            }
            if (paramVideoTransPara.lJA != 1) {
              continue;
            }
            SightVideoJNI.addReportMetadata(paramString, (int[])localObject, 0, paramVideoTransPara.lJA);
            continue;
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(148822);
        return -1;
      }
      label1010:
      label1019:
      do
      {
        break label616;
        break label132;
        break;
        j = i1;
        i = n;
        break label385;
      } while (localObject[5] <= 0);
      label1030:
      int i = localObject[1];
      int j = localObject[2];
      continue;
      label1052:
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
        label1097:
        k = 0;
        m = 51;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */