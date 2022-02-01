package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.k.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class l
{
  public static boolean a(String paramString, VideoTransPara paramVideoTransPara, dmb paramdmb, e parame)
  {
    AppMethodBeat.i(148821);
    String str = paramString;
    Object localObject = paramdmb;
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
        dmb localdmb = paramdmb;
        if (paramdmb == null)
        {
          str = paramString;
          localObject = paramdmb;
          localdmb = new dmb();
        }
        str = paramString;
        localObject = localdmb;
        Log.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[] { Boolean.valueOf(localdmb.aaSg), paramString, paramVideoTransPara, Boolean.valueOf(localdmb.aaSj) });
        str = paramString;
        localObject = localdmb;
        if (localdmb.aaSj)
        {
          str = paramString;
          localObject = localdmb;
          Log.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localdmb;
        int k;
        if (localdmb.aaSg)
        {
          str = paramString;
          localObject = localdmb;
          if (!Util.isNullOrNil(paramString))
          {
            str = paramString;
            localObject = localdmb;
            SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.e.bIg().getWeixinMeta());
            str = paramString;
            localObject = localdmb;
            if (!Util.isNullOrNil(localdmb.aaSi))
            {
              str = paramString;
              localObject = localdmb;
              SightVideoJNI.tagMp4RecordInfo(paramString, localdmb.aaSi);
            }
            str = paramString;
            localObject = localdmb;
            long l = Util.currentTicks();
            str = paramString;
            localObject = localdmb;
            SightVideoJNI.optimizeMP4VFS(paramString);
            str = paramString;
            localObject = localdmb;
            Log.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
            str = paramString;
            localObject = localdmb;
            parame.gaj();
            str = paramString;
            localObject = localdmb;
            paramString = com.tencent.mm.vfs.y.n(paramString, false);
            str = paramString;
            localObject = localdmb;
            paramdmb = new d();
            str = paramString;
            localObject = localdmb;
            paramdmb.setDataSource(paramString);
            str = paramString;
            localObject = localdmb;
            i = Util.getInt(paramdmb.extractMetadata(18), 0);
            str = paramString;
            localObject = localdmb;
            k = Util.getInt(paramdmb.extractMetadata(19), 0);
            str = paramString;
            localObject = localdmb;
            j = Util.getInt(paramdmb.extractMetadata(20), 0);
            str = paramString;
            localObject = localdmb;
            paramdmb.release();
            str = paramString;
            localObject = localdmb;
            Log.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            str = paramString;
            localObject = localdmb;
            Log.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s %s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height), Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(paramVideoTransPara.oCc) });
            str = paramString;
            localObject = localdmb;
            k = Math.min(i, k);
            str = paramString;
            localObject = localdmb;
            if (af.lYf.lWI != 1) {
              continue;
            }
            bool1 = true;
            str = paramString;
            localObject = localdmb;
            if (Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("MMSightCheckSendVideoBitrate"), 0) != 1) {
              continue;
            }
            bool2 = true;
            str = paramString;
            localObject = localdmb;
            f2 = Util.getFloat(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
            str = paramString;
            localObject = localdmb;
            paramdmb = SightVideoJNI.getMP4CprtH(paramString);
            f1 = f2;
            if (paramdmb != null)
            {
              f1 = f2;
              str = paramString;
              localObject = localdmb;
              if (paramdmb.length() >= 17)
              {
                f1 = f2;
                str = paramString;
                localObject = localdmb;
                if (paramdmb.substring(0, 17).equals("AdaptiveBitrateUP"))
                {
                  str = paramString;
                  localObject = localdmb;
                  Log.i("MicroMsg.SightSendVideoLogic", "ABA: checkShouldRemuxing use aba: %s ", new Object[] { paramdmb });
                  f1 = 2.0F;
                }
              }
            }
            str = paramString;
            localObject = localdmb;
            if ((paramVideoTransPara.oCc & 0x2) == 0) {
              break label1163;
            }
            f1 = 2.0F;
            str = paramString;
            localObject = localdmb;
            f2 = paramVideoTransPara.videoBitrate;
            str = paramString;
            localObject = localdmb;
            if (!localdmb.aaSk) {
              break label1153;
            }
            str = paramString;
            localObject = localdmb;
            Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set to bitrate upper bound to 12000000");
            str = paramString;
            localObject = localdmb;
            f2 = Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 12000000);
            str = paramString;
            localObject = localdmb;
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
        localObject = localdmb;
        bool1 = localdmb.aaSk;
        if (bool1)
        {
          AppMethodBeat.o(148821);
          return false;
        }
        str = paramString;
        localObject = localdmb;
        if (k > paramVideoTransPara.width)
        {
          str = paramString;
          localObject = localdmb;
          if ((k <= paramVideoTransPara.width) || (k % 16 != 0)) {
            break label1166;
          }
          str = paramString;
          localObject = localdmb;
          if (Math.abs(k - paramVideoTransPara.width) >= 16) {
            break label1166;
          }
        }
        str = paramString;
        localObject = localdmb;
        bool1 = localdmb.aaSf;
        if (bool1)
        {
          AppMethodBeat.o(148821);
          return true;
        }
        if (i != 0)
        {
          f2 = j;
          str = paramString;
          localObject = localdmb;
          if (f2 >= paramVideoTransPara.videoBitrate * f1)
          {
            str = paramString;
            localObject = localdmb;
            Log.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
            str = paramString;
            localObject = localdmb;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 205L, 1L, false);
            AppMethodBeat.o(148821);
            return true;
          }
        }
        str = paramString;
        localObject = localdmb;
        localdmb.aaSj = true;
        AppMethodBeat.o(148821);
        return false;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[] { paramString.getMessage(), str });
        if (localObject == null) {
          continue;
        }
        ((dmb)localObject).aaSj = true;
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
  
  public static int b(String paramString, VideoTransPara paramVideoTransPara, dmb paramdmb, e parame)
  {
    AppMethodBeat.i(148822);
    if ((paramdmb == null) || (!paramdmb.aaSg) || (!com.tencent.mm.vfs.y.ZC(paramString)))
    {
      AppMethodBeat.o(148822);
      return -1;
    }
    if (paramdmb.aaSj) {
      Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[] { paramString });
    }
    for (;;)
    {
      int n;
      int i1;
      int k;
      try
      {
        localObject = com.tencent.mm.vfs.y.bEo(paramString);
        if (((String)localObject).endsWith("/")) {
          break label1035;
        }
        localObject = (String)localObject + "/";
        String str1 = new u(paramString).getName();
        i = str1.lastIndexOf('.');
        if (i <= 0) {
          break label1032;
        }
        str1 = str1.substring(0, i);
        String str3 = (String)localObject + str1 + "_hd";
        String str2 = str3;
        if (paramString.endsWith(".mp4")) {
          str2 = str3 + ".mp4";
        }
        str3 = (String)localObject + str1 + "tempRemuxing.mp4";
        com.tencent.mm.vfs.y.O(paramString, str2, false);
        Log.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[] { localObject, str1, str2, str3, Integer.valueOf(paramdmb.Gad) });
        str1 = com.tencent.mm.vfs.y.n(str2, true);
        str2 = com.tencent.mm.vfs.y.n(str3, true);
        localObject = new d();
        ((MediaMetadataRetriever)localObject).setDataSource(str1);
        n = Util.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
        i1 = Util.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
        i = Math.min(n, i1);
        if (i <= paramVideoTransPara.width) {
          break label1038;
        }
        if ((i > paramVideoTransPara.width) && (i % 16 == 0) && (Math.abs(i - paramVideoTransPara.width) < 16))
        {
          break label1038;
          Log.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), paramVideoTransPara });
          long l = Util.currentTicks();
          if (paramdmb.aaSk)
          {
            Log.i("MicroMsg.SightSendVideoLogic", "from skip compress, set remux target bitrate to 12000000");
            paramVideoTransPara.videoBitrate = Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("MMSightCheckSendVideoBitrateLimitFromSkipCompress"), 12000000);
          }
          if ((paramVideoTransPara.oCb != 1) && (paramVideoTransPara.oCb != 2)) {
            break label1026;
          }
          localObject = AdaptiveAdjustBitrate.a(str1, j, i, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, 0.0F, 0.0F, 2, paramVideoTransPara.oCd, paramVideoTransPara.oCf, paramVideoTransPara.oCg, paramVideoTransPara.oCh, paramVideoTransPara.oCi, paramVideoTransPara.oCj, false);
          if (localObject != null) {
            paramVideoTransPara.videoBitrate = (((ABAPrams)localObject).outputKbps * 1000);
          }
          if ((localObject == null) || (((ABAPrams)localObject).resolutionAdjust <= 0)) {
            break label1023;
          }
          i = ((ABAPrams)localObject).outputWidth;
          j = ((ABAPrams)localObject).outputHeight;
          Log.i("MicroMsg.SightSendVideoLogic", "ABA: MMsightSendVideoLogic Videobitrate: [%d] , Width: [%d], Height: [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.videoBitrate), Integer.valueOf(i), Integer.valueOf(j) });
          if (paramVideoTransPara.oCc != 1) {
            break label1094;
          }
          Log.i("MicroMsg.SightSendVideoLogic", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(paramVideoTransPara.nxU), Integer.valueOf(paramVideoTransPara.nxV) });
          k = paramVideoTransPara.nxU;
          m = paramVideoTransPara.nxV;
          k = SightVideoJNI.remuxingVFS(str1, str2, i, j, paramVideoTransPara.videoBitrate, paramVideoTransPara.oBP, 8, paramVideoTransPara.oBO, 25.0F, 30.0F, null, 0, false, k, m);
          Log.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[] { paramString, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
          com.tencent.mm.vfs.y.qn(str2, paramString);
          paramString = com.tencent.mm.vfs.y.n(paramString, true);
          l = Util.currentTicks();
          if (paramVideoTransPara.oCb > 0)
          {
            SightVideoJNI.addReportMetadata(paramString, (ABAPrams)localObject, paramVideoTransPara.oCb, 0);
            if (paramdmb.aaSg)
            {
              SightVideoJNI.tagMP4Dscp(paramString, com.tencent.mm.modelcontrol.e.bIg().getWeixinMeta());
              if (!Util.isNullOrNil(paramdmb.aaSi)) {
                SightVideoJNI.tagMp4RecordInfo(paramString, paramdmb.aaSi);
              }
              SightVideoJNI.optimizeMP4VFS(paramString);
            }
            parame.gaj();
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
            break label1049;
          }
          i = paramVideoTransPara.width;
          double d = 1.0D * i1 / i;
          k = (int)(n / d);
          break label1049;
        }
        if (paramVideoTransPara.oCc != 1) {
          continue;
        }
        SightVideoJNI.addReportMetadata(paramString, (ABAPrams)localObject, 0, paramVideoTransPara.oCc);
        continue;
        continue;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(148822);
        return -1;
      }
      label1023:
      Object localObject = null;
      label1026:
      continue;
      label1032:
      continue;
      label1035:
      continue;
      label1038:
      int j = i1;
      int i = n;
      continue;
      label1049:
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
        label1094:
        k = 0;
        m = 51;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */