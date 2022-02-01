package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class m
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, cly paramcly, e parame)
  {
    AppMethodBeat.i(148821);
    String str = paramString;
    Object localObject = paramcly;
    for (;;)
    {
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
        cly localcly = paramcly;
        if (paramcly == null)
        {
          str = paramString;
          localObject = paramcly;
          localcly = new cly();
        }
        str = paramString;
        localObject = localcly;
        Log.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localcly.Mrn), paramString, paramVideoTransPara, Boolean.valueOf(localcly.Mrq) });
        str = paramString;
        localObject = localcly;
        if (localcly.Mrq)
        {
          str = paramString;
          localObject = localcly;
          Log.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localcly;
        if (localcly.Mrn)
        {
          str = paramString;
          localObject = localcly;
          if (!Util.isNullOrNil(paramString))
          {
            str = paramString;
            localObject = localcly;
            SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.e.baZ().getWeixinMeta());
            str = paramString;
            localObject = localcly;
            if (!Util.isNullOrNil(localcly.Mrp))
            {
              str = paramString;
              localObject = localcly;
              SightVideoJNI.tagMp4RecordInfo(paramString, localcly.Mrp);
            }
            str = paramString;
            localObject = localcly;
            long l = Util.currentTicks();
            str = paramString;
            localObject = localcly;
            SightVideoJNI.optimizeMP4VFS(paramString);
            str = paramString;
            localObject = localcly;
            Log.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
            str = paramString;
            localObject = localcly;
            parame.ehT();
            str = paramString;
            localObject = localcly;
            paramString = s.k(paramString, false);
            str = paramString;
            localObject = localcly;
            paramcly = new d();
            str = paramString;
            localObject = localcly;
            paramcly.setDataSource(paramString);
            str = paramString;
            localObject = localcly;
            i = Util.getInt(paramcly.extractMetadata(18), 0);
            str = paramString;
            localObject = localcly;
            int k = Util.getInt(paramcly.extractMetadata(19), 0);
            str = paramString;
            localObject = localcly;
            j = Util.getInt(paramcly.extractMetadata(20), 0);
            str = paramString;
            localObject = localcly;
            paramcly.release();
            str = paramString;
            localObject = localcly;
            Log.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            str = paramString;
            localObject = localcly;
            Log.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(paramVideoTransPara.iTh) });
            str = paramString;
            localObject = localcly;
            k = Math.min(i, k);
            str = paramString;
            localObject = localcly;
            if (ae.gKA.gIZ != 1) {
              continue;
            }
            bool1 = true;
            str = paramString;
            localObject = localcly;
            if (Util.getInt(((a)g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
              continue;
            }
            bool2 = true;
            str = paramString;
            localObject = localcly;
            f2 = Util.getFloat(((a)g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
            str = paramString;
            localObject = localcly;
            paramcly = SightVideoJNI.getMP4CprtH(paramString);
            f1 = f2;
            if (paramcly != null)
            {
              f1 = f2;
              str = paramString;
              localObject = localcly;
              if (paramcly.length() >= 17)
              {
                f1 = f2;
                str = paramString;
                localObject = localcly;
                if (paramcly.substring(0, 17).equals("AdaptiveBitrateUP"))
                {
                  str = paramString;
                  localObject = localcly;
                  Log.i("MicroMsg.SightSendVideoLogic", "ABA: checkShouldRemuxing use aba: %s ", new Object[] { paramcly });
                  f1 = 2.0F;
                }
              }
            }
            str = paramString;
            localObject = localcly;
            if ((paramVideoTransPara.iTh & 0x2) == 0) {
              break label1116;
            }
            f1 = 2.0F;
            str = paramString;
            localObject = localcly;
            f2 = paramVideoTransPara.videoBitrate;
            str = paramString;
            localObject = localcly;
            if (!localcly.Mrr) {
              break label1106;
            }
            str = paramString;
            localObject = localcly;
            Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set to bitrate upper bound to 2400000");
            str = paramString;
            localObject = localcly;
            f2 = Util.getInt(((a)g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
            str = paramString;
            localObject = localcly;
            Log.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Float.valueOf(f1) });
            if (bool1) {
              break label1119;
            }
            if (!bool2) {
              continue;
            }
            break label1119;
            str = paramString;
            localObject = localcly;
            if (k > paramVideoTransPara.width)
            {
              str = paramString;
              localObject = localcly;
              if ((k <= paramVideoTransPara.width) || (k % 16 != 0)) {
                break label1125;
              }
              str = paramString;
              localObject = localcly;
              if (Math.abs(k - paramVideoTransPara.width) >= 16) {
                break label1125;
              }
            }
            str = paramString;
            localObject = localcly;
            bool1 = localcly.Mrm;
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
          localObject = localcly;
          if (f2 >= paramVideoTransPara.videoBitrate * f1)
          {
            str = paramString;
            localObject = localcly;
            Log.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
            str = paramString;
            localObject = localcly;
            h.CyF.idkeyStat(440L, 205L, 1L, false);
            AppMethodBeat.o(148821);
            return true;
          }
        }
        str = paramString;
        localObject = localcly;
        localcly.Mrq = true;
        AppMethodBeat.o(148821);
        return false;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramString.getMessage(), str });
        if (localObject == null) {
          continue;
        }
        ((cly)localObject).Mrq = true;
        AppMethodBeat.o(148821);
        return false;
      }
      AppMethodBeat.o(148821);
      return true;
      label1106:
      f2 *= f1;
      continue;
      label1116:
      continue;
      label1119:
      int i = 1;
      continue;
      label1125:
      if ((i == 0) || (j < f2)) {}
    }
  }
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, cly paramcly, e parame)
  {
    AppMethodBeat.i(148822);
    if ((paramcly == null) || (!paramcly.Mrn) || (!s.YS(paramString)))
    {
      AppMethodBeat.o(148822);
      return -1;
    }
    if (paramcly.Mrq) {
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
        localObject = s.boZ(paramString);
        if (!((String)localObject).endsWith("/"))
        {
          localObject = (String)localObject + "/";
          String str1 = new o(paramString).getName();
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
            s.nw(paramString, str2);
            Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str1, str2, str3, Integer.valueOf(paramcly.vUh) });
            str1 = s.k(str2, true);
            str2 = s.k(str3, true);
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
              if (paramcly.Mrr)
              {
                Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set remux target bitrate to 2400000");
                paramVideoTransPara.videoBitrate = Util.getInt(((a)g.af(a.class)).aqJ().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 2400000);
              }
              localObject = new int[34];
              if ((paramVideoTransPara.iTg != 1) && (paramVideoTransPara.iTg != 2)) {
                break label1010;
              }
              localObject = AdaptiveAdjustBitrate.a(str1, j, i, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 0.0F, 0.0F, 2, paramVideoTransPara.iTi, paramVideoTransPara.iTj, paramVideoTransPara.iTk, paramVideoTransPara.iTl, paramVideoTransPara.iTm, paramVideoTransPara.iTn, paramVideoTransPara.iTo, false);
              if (localObject == null) {
                break label1030;
              }
              paramVideoTransPara.videoBitrate = (localObject[0] * 1000);
              break label1030;
              Log.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(i), Integer.valueOf(j) });
              if (paramVideoTransPara.iTh != 1) {
                break label1097;
              }
              Log.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.idF), Integer.valueOf(paramVideoTransPara.idG) });
              k = paramVideoTransPara.idF;
              m = paramVideoTransPara.idG;
              k = SightVideoJNI.remuxingVFS(str1, str2, i, j, paramVideoTransPara.videoBitrate, paramVideoTransPara.iSV, 8, paramVideoTransPara.iSU, 25.0F, 30.0F, null, 0, false, k, m);
              Log.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
              s.nx(str2, paramString);
              paramString = s.k(paramString, true);
              l = Util.currentTicks();
              if (paramVideoTransPara.iTg > 0)
              {
                SightVideoJNI.addReportMetadata(paramString, (int[])localObject, paramVideoTransPara.iTg, 0);
                if (paramcly.Mrn)
                {
                  SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.e.baZ().getWeixinMeta());
                  if (!Util.isNullOrNil(paramcly.Mrp)) {
                    SightVideoJNI.tagMp4RecordInfo(paramString, paramcly.Mrp);
                  }
                  SightVideoJNI.optimizeMP4VFS(paramString);
                }
                parame.ehT();
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
            if (paramVideoTransPara.iTh != 1) {
              continue;
            }
            SightVideoJNI.addReportMetadata(paramString, (int[])localObject, 0, paramVideoTransPara.iTh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.m
 * JD-Core Version:    0.7.0.1
 */