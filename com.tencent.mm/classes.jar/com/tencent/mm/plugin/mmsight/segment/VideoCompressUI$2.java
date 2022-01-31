package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class VideoCompressUI$2
  implements Runnable
{
  VideoCompressUI$2(VideoCompressUI paramVideoCompressUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(3697);
    for (;;)
    {
      Intent localIntent;
      try
      {
        VideoCompressUI.a(this.oMq, VideoCompressUI.c(this.oMq));
        localIntent = new Intent();
        localPoint = VideoCompressUI.A(VideoCompressUI.d(this.oMq).videoWidth, VideoCompressUI.d(this.oMq).videoHeight, VideoCompressUI.a(this.oMq).width, VideoCompressUI.a(this.oMq).height);
        j = 0;
        str = SightVideoJNI.getMP4CprtH(VideoCompressUI.c(this.oMq));
        i = j;
        if (str != null)
        {
          ab.i("MicroMsg.VideoCompressUI", "ABA: the metadata flag of video is : %s", new Object[] { str });
          i = j;
          if (str.equals("AdaptiveBitrateUP"))
          {
            i = j;
            if (!VideoCompressUI.e(this.oMq)) {
              i = 1;
            }
          }
        }
        if (((!VideoCompressUI.b(this.oMq, VideoCompressUI.a(this.oMq))) && (localPoint == null)) || (i != 0)) {
          break label1132;
        }
        if (localPoint != null) {
          break label1187;
        }
        localPoint = new Point(VideoCompressUI.d(this.oMq).videoWidth, VideoCompressUI.d(this.oMq).videoHeight);
        VideoCompressUI.c(this.oMq);
        str = VideoCompressUI.bRL();
        if (VideoCompressUI.a(this.oMq).fAh == 2)
        {
          VideoCompressUI.a(this.oMq, AdaptiveAdjustBitrate.GetBitrate(VideoCompressUI.c(this.oMq), localPoint.y, localPoint.x, VideoCompressUI.a(this.oMq).fps, VideoCompressUI.a(this.oMq).videoBitrate, 0.0F, 0.0F, 2, VideoCompressUI.a(this.oMq).fAj, VideoCompressUI.a(this.oMq).fAk, VideoCompressUI.a(this.oMq).fAl, VideoCompressUI.a(this.oMq).fAm));
          VideoCompressUI.a(this.oMq).videoBitrate = (VideoCompressUI.f(this.oMq)[0] * 1000);
          localPoint.x = VideoCompressUI.f(this.oMq)[1];
          localPoint.y = VideoCompressUI.f(this.oMq)[2];
          ab.i("MicroMsg.VideoCompressUI", "ABA: VideoCompressUI Send directly: [%d], [%d], [%d] ", new Object[] { Integer.valueOf(VideoCompressUI.a(this.oMq).videoBitrate), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y) });
        }
        if ((VideoCompressUI.a(this.oMq).fAi != 1) && (VideoCompressUI.a(this.oMq).fAi != 2)) {
          continue;
        }
        ab.i("MicroMsg.VideoCompressUI", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(VideoCompressUI.a(this.oMq).fAn), Integer.valueOf(VideoCompressUI.a(this.oMq).fAo) });
        i = VideoCompressUI.a(this.oMq).fAn;
        j = VideoCompressUI.a(this.oMq).fAo;
        if (VideoCompressUI.d(this.oMq).videoWidth >= 2000) {
          break label1190;
        }
        if (VideoCompressUI.d(this.oMq).videoHeight < 2000) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Point localPoint;
        int j;
        String str;
        int i;
        boolean bool2;
        int m;
        int n;
        int i1;
        int k;
        ab.printErrStackTrace("MicroMsg.VideoCompressUI", localException, "video compress failed e [%s]", new Object[] { localException.getMessage() });
        return;
        if (VideoCompressUI.a(this.oMq).fAh != 2) {
          continue;
        }
        SightVideoJNI.addReportMetadata(str, VideoCompressUI.f(this.oMq), VideoCompressUI.a(this.oMq).fAh, 0);
        continue;
      }
      finally
      {
        this.oMq.finish();
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3696);
            if (VideoCompressUI.h(VideoCompressUI.2.this.oMq) != null) {
              VideoCompressUI.h(VideoCompressUI.2.this.oMq).dismiss();
            }
            AppMethodBeat.o(3696);
          }
        });
        AppMethodBeat.o(3697);
      }
      ab.i("MicroMsg.VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s, videoSizeTooLarge:%s", new Object[] { Integer.valueOf(VideoCompressUI.d(this.oMq).videoWidth), Integer.valueOf(VideoCompressUI.d(this.oMq).videoHeight), localPoint, VideoCompressUI.c(this.oMq), str, Boolean.valueOf(VideoCompressUI.e(this.oMq)), Boolean.valueOf(bool1) });
      bool2 = WXHardCoderJNI.hcEncodeVideoEnable;
      m = WXHardCoderJNI.hcEncodeVideoDelay;
      n = WXHardCoderJNI.hcEncodeVideoCPU;
      i1 = WXHardCoderJNI.hcEncodeVideoIO;
      if (WXHardCoderJNI.hcEncodeVideoThr)
      {
        k = Process.myTid();
        VideoCompressUI.zw(WXHardCoderJNI.startPerformance(bool2, m, n, i1, k, 30000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.VideoCompressUI"));
        ab.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(VideoCompressUI.access$1100()) });
        if ((!VideoCompressUI.e(this.oMq)) && (!bool1))
        {
          SightVideoJNI.remuxing(VideoCompressUI.c(this.oMq), str, localPoint.x, localPoint.y, VideoCompressUI.a(this.oMq).videoBitrate, VideoCompressUI.a(this.oMq).fzW, 8, VideoCompressUI.a(this.oMq).fzV, 25.0F, VideoCompressUI.a(this.oMq).fps, null, 0, false, i, j);
          if (VideoCompressUI.access$1100() != 0)
          {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, VideoCompressUI.access$1100());
            ab.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance stopPerformace %s", new Object[] { Integer.valueOf(VideoCompressUI.access$1100()) });
            VideoCompressUI.zw(0);
          }
          if (VideoCompressUI.a(this.oMq).fAi <= 0) {
            continue;
          }
          SightVideoJNI.addReportMetadata(str, VideoCompressUI.f(this.oMq), 0, VideoCompressUI.a(this.oMq).fAi);
          localIntent.putExtra("K_SEGMENTVIDEOPATH", str);
          localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(this.oMq, str, null));
          this.oMq.setResult(-1, localIntent);
          this.oMq.finish();
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3696);
              if (VideoCompressUI.h(VideoCompressUI.2.this.oMq) != null) {
                VideoCompressUI.h(VideoCompressUI.2.this.oMq).dismiss();
              }
              AppMethodBeat.o(3696);
            }
          });
          AppMethodBeat.o(3697);
          return;
          i = 0;
          j = 51;
          continue;
          bool1 = false;
          continue;
        }
      }
      else
      {
        k = 0;
        continue;
      }
      ab.i("MicroMsg.VideoCompressUI", "ish265, transfer to h264");
      VideoCompressUI.a(this.oMq).width = localPoint.x;
      VideoCompressUI.a(this.oMq).height = localPoint.y;
      e.a(VideoCompressUI.c(this.oMq), str, VideoCompressUI.a(this.oMq));
      continue;
      label1132:
      ab.i("MicroMsg.VideoCompressUI", "no need remux, directly set result");
      localIntent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.c(this.oMq));
      localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(this.oMq, VideoCompressUI.c(this.oMq), VideoCompressUI.g(this.oMq)));
      continue;
      label1187:
      continue;
      label1190:
      boolean bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.2
 * JD-Core Version:    0.7.0.1
 */