package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

@TargetApi(16)
public class VideoCompressUI
  extends MMBaseActivity
{
  private static int fsu;
  private d fPa;
  private VideoTransPara ics;
  private String thumbPath;
  private ProgressDialog uPS;
  private int[] uPT;
  private a uPU;
  private boolean uPV;
  private Runnable uPW;
  private String videoPath;
  
  public VideoCompressUI()
  {
    AppMethodBeat.i(107701);
    this.fPa = new d(this);
    this.uPT = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.uPU = new a((byte)0);
    this.uPW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107699);
        for (;;)
        {
          Intent localIntent;
          try
          {
            VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.c(VideoCompressUI.this));
            localIntent = new Intent();
            localPoint = VideoCompressUI.F(VideoCompressUI.d(VideoCompressUI.this).videoWidth, VideoCompressUI.d(VideoCompressUI.this).videoHeight, VideoCompressUI.a(VideoCompressUI.this).width, VideoCompressUI.a(VideoCompressUI.this).height);
            j = 0;
            str = SightVideoJNI.getMP4CprtH(VideoCompressUI.c(VideoCompressUI.this));
            i = j;
            if (str != null)
            {
              ac.i("MicroMsg.VideoCompressUI", "ABA: the metadata flag of video is : %s", new Object[] { str });
              i = j;
              if (str.length() >= 17)
              {
                i = j;
                if (str.substring(0, 17).equals("AdaptiveBitrateUP"))
                {
                  i = j;
                  if (!VideoCompressUI.e(VideoCompressUI.this)) {
                    i = 1;
                  }
                }
              }
            }
            if (((!VideoCompressUI.b(VideoCompressUI.this, VideoCompressUI.a(VideoCompressUI.this))) && (localPoint == null)) || (i != 0)) {
              break label1177;
            }
            if (localPoint != null) {
              break label1233;
            }
            localPoint = new Point(VideoCompressUI.d(VideoCompressUI.this).videoWidth, VideoCompressUI.d(VideoCompressUI.this).videoHeight);
            VideoCompressUI.c(VideoCompressUI.this);
            str = VideoCompressUI.dep();
            if (VideoCompressUI.a(VideoCompressUI.this).hCL == 2)
            {
              VideoCompressUI.a(VideoCompressUI.this, AdaptiveAdjustBitrate.a(VideoCompressUI.c(VideoCompressUI.this), localPoint.y, localPoint.x, VideoCompressUI.a(VideoCompressUI.this).fps, VideoCompressUI.a(VideoCompressUI.this).videoBitrate, 0.0F, 0.0F, 2, VideoCompressUI.a(VideoCompressUI.this).hCN, VideoCompressUI.a(VideoCompressUI.this).hCO, VideoCompressUI.a(VideoCompressUI.this).hCP, VideoCompressUI.a(VideoCompressUI.this).hCQ, VideoCompressUI.a(VideoCompressUI.this).hCR, VideoCompressUI.a(VideoCompressUI.this).hCS, VideoCompressUI.a(VideoCompressUI.this).hCT));
              VideoCompressUI.a(VideoCompressUI.this).videoBitrate = (VideoCompressUI.f(VideoCompressUI.this)[0] * 1000);
              localPoint.x = VideoCompressUI.f(VideoCompressUI.this)[1];
              localPoint.y = VideoCompressUI.f(VideoCompressUI.this)[2];
              ac.i("MicroMsg.VideoCompressUI", "ABA: VideoCompressUI Send directly: [%d], [%d], [%d] ", new Object[] { Integer.valueOf(VideoCompressUI.a(VideoCompressUI.this).videoBitrate), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y) });
            }
            if ((VideoCompressUI.a(VideoCompressUI.this).hCM != 1) && (VideoCompressUI.a(VideoCompressUI.this).hCM != 2)) {
              continue;
            }
            ac.i("MicroMsg.VideoCompressUI", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(VideoCompressUI.a(VideoCompressUI.this).gOb), Integer.valueOf(VideoCompressUI.a(VideoCompressUI.this).gOc) });
            i = VideoCompressUI.a(VideoCompressUI.this).gOb;
            j = VideoCompressUI.a(VideoCompressUI.this).gOc;
            if (VideoCompressUI.d(VideoCompressUI.this).videoWidth >= 2000) {
              break label1236;
            }
            if (VideoCompressUI.d(VideoCompressUI.this).videoHeight < 2000) {
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
            ac.printErrStackTrace("MicroMsg.VideoCompressUI", localException, "video compress failed e [%s]", new Object[] { localException.getMessage() });
            return;
            if (VideoCompressUI.a(VideoCompressUI.this).hCL != 2) {
              continue;
            }
            SightVideoJNI.addReportMetadata(str, VideoCompressUI.f(VideoCompressUI.this), VideoCompressUI.a(VideoCompressUI.this).hCL, 0);
            continue;
          }
          finally
          {
            VideoCompressUI.this.finish();
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(107698);
                if (VideoCompressUI.h(VideoCompressUI.this) != null) {
                  VideoCompressUI.h(VideoCompressUI.this).dismiss();
                }
                AppMethodBeat.o(107698);
              }
            });
            AppMethodBeat.o(107699);
          }
          ac.i("MicroMsg.VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s, videoSizeTooLarge:%s", new Object[] { Integer.valueOf(VideoCompressUI.d(VideoCompressUI.this).videoWidth), Integer.valueOf(VideoCompressUI.d(VideoCompressUI.this).videoHeight), localPoint, VideoCompressUI.c(VideoCompressUI.this), str, Boolean.valueOf(VideoCompressUI.e(VideoCompressUI.this)), Boolean.valueOf(bool1) });
          bool2 = WXHardCoderJNI.hcEncodeVideoEnable;
          m = WXHardCoderJNI.hcEncodeVideoDelay;
          n = WXHardCoderJNI.hcEncodeVideoCPU;
          i1 = WXHardCoderJNI.hcEncodeVideoIO;
          if (WXHardCoderJNI.hcEncodeVideoThr)
          {
            k = Process.myTid();
            VideoCompressUI.IT(WXHardCoderJNI.startPerformance(bool2, m, n, i1, k, 30000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.VideoCompressUI"));
            ac.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(VideoCompressUI.aZA()) });
            if ((!VideoCompressUI.e(VideoCompressUI.this)) && (!bool1))
            {
              SightVideoJNI.remuxingVFS(VideoCompressUI.c(VideoCompressUI.this), str, localPoint.x, localPoint.y, VideoCompressUI.a(VideoCompressUI.this).videoBitrate, VideoCompressUI.a(VideoCompressUI.this).hCA, 8, VideoCompressUI.a(VideoCompressUI.this).hCz, 25.0F, VideoCompressUI.a(VideoCompressUI.this).fps, null, 0, false, i, j);
              if (VideoCompressUI.aZA() != 0)
              {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, VideoCompressUI.aZA());
                ac.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance stopPerformace %s", new Object[] { Integer.valueOf(VideoCompressUI.aZA()) });
                VideoCompressUI.IT(0);
              }
              if (VideoCompressUI.a(VideoCompressUI.this).hCM <= 0) {
                continue;
              }
              SightVideoJNI.addReportMetadata(str, VideoCompressUI.f(VideoCompressUI.this), 0, VideoCompressUI.a(VideoCompressUI.this).hCM);
              localIntent.putExtra("K_SEGMENTVIDEOPATH", str);
              localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, str, null));
              VideoCompressUI.this.setResult(-1, localIntent);
              VideoCompressUI.this.finish();
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(107698);
                  if (VideoCompressUI.h(VideoCompressUI.this) != null) {
                    VideoCompressUI.h(VideoCompressUI.this).dismiss();
                  }
                  AppMethodBeat.o(107698);
                }
              });
              AppMethodBeat.o(107699);
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
          ac.i("MicroMsg.VideoCompressUI", "ish265, transfer to h264");
          VideoCompressUI.a(VideoCompressUI.this).width = localPoint.x;
          VideoCompressUI.a(VideoCompressUI.this).height = localPoint.y;
          e.a(VideoCompressUI.c(VideoCompressUI.this), str, VideoCompressUI.a(VideoCompressUI.this));
          continue;
          label1177:
          ac.i("MicroMsg.VideoCompressUI", "no need remux, directly set result");
          localIntent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.c(VideoCompressUI.this));
          localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.c(VideoCompressUI.this), VideoCompressUI.g(VideoCompressUI.this)));
          continue;
          label1233:
          continue;
          label1236:
          boolean bool1 = true;
        }
      }
    };
    AppMethodBeat.o(107701);
  }
  
  /* Error */
  private String hK(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 374
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 249	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 374
    //   16: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_2
    //   20: areturn
    //   21: new 376	android/content/Intent
    //   24: dup
    //   25: invokespecial 377	android/content/Intent:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc_w 379
    //   33: aload_1
    //   34: invokestatic 382	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 385	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 391	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: invokevirtual 395	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   46: pop
    //   47: aload_0
    //   48: aload_3
    //   49: invokestatic 401	com/tencent/mm/compatible/h/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/h/a$a;
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull +120 -> 176
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: getfield 407	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   65: ifnull +111 -> 176
    //   68: new 85	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   75: invokestatic 331	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   78: invokevirtual 334	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getAccVideoPath	()Ljava/lang/String;
    //   81: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 409
    //   87: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 341	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   98: ifeq +9 -> 107
    //   101: aload_1
    //   102: iconst_1
    //   103: invokestatic 345	com/tencent/mm/vfs/i:cU	(Ljava/lang/String;Z)Z
    //   106: pop
    //   107: aload_1
    //   108: invokestatic 348	com/tencent/mm/vfs/i:aSh	(Ljava/lang/String;)Z
    //   111: pop
    //   112: new 85	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   119: aload_1
    //   120: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 411
    //   126: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokestatic 356	java/lang/System:currentTimeMillis	()J
    //   132: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: ldc_w 413
    //   138: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: ldc 83
    //   147: ldc_w 415
    //   150: iconst_1
    //   151: anewarray 134	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: aastore
    //   158: invokestatic 143	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_3
    //   162: getfield 407	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   165: bipush 80
    //   167: getstatic 421	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   170: aload_1
    //   171: iconst_1
    //   172: invokestatic 426	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   175: pop
    //   176: ldc_w 374
    //   179: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: areturn
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: ldc 83
    //   189: aload_3
    //   190: ldc_w 428
    //   193: iconst_1
    //   194: anewarray 134	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_3
    //   200: invokevirtual 300	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 432	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -31 -> 176
    //   210: astore_3
    //   211: goto -24 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	VideoCompressUI
    //   0	214	1	paramString1	String
    //   0	214	2	paramString2	String
    //   28	134	3	localObject	Object
    //   184	16	3	localException1	Exception
    //   210	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   21	53	184	java/lang/Exception
    //   61	107	184	java/lang/Exception
    //   107	161	184	java/lang/Exception
    //   161	176	210	java/lang/Exception
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107702);
    super.onCreate(paramBundle);
    setContentView(2131493128);
    paramBundle = getIntent();
    if ((paramBundle == null) || (bs.isNullOrNil(paramBundle.getStringExtra("K_SEGMENTVIDEOPATH"))))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(107702);
      return;
    }
    this.uPS = h.b(this, getString(2131755936), false, null);
    this.videoPath = paramBundle.getStringExtra("K_SEGMENTVIDEOPATH");
    this.thumbPath = paramBundle.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.fPa));
    this.fPa.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107697);
        VideoCompressUI.a(VideoCompressUI.this, CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara());
        if (VideoCompressUI.a(VideoCompressUI.this) == null)
        {
          ac.e("MicroMsg.VideoCompressUI", "VideoSendPreprocessTask para is null");
          VideoCompressUI.this.setResult(0);
          VideoCompressUI.this.finish();
          AppMethodBeat.o(107697);
          return;
        }
        ae.st(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        b.c(VideoCompressUI.b(VideoCompressUI.this), "video_remuxing_if_needed");
        AppMethodBeat.o(107697);
      }
    });
    AppMethodBeat.o(107702);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107704);
    super.onDestroy();
    if (this.fPa != null) {
      this.fPa.release();
    }
    AppMethodBeat.o(107704);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    public int audioBitRate = -1;
    public String hTu;
    public String hTv;
    public int hTw = -1;
    public int hTx = -1;
    public int videoBitRate = -1;
    public int videoFrameRate = -1;
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    private a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(107700);
      String str = "VideoAnalysisStruct{videoTrackMime='" + this.hTu + '\'' + ", audioTrackMime='" + this.hTv + '\'' + ", durationMs=" + this.hTw + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.hTx + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
      AppMethodBeat.o(107700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI
 * JD-Core Version:    0.7.0.1
 */