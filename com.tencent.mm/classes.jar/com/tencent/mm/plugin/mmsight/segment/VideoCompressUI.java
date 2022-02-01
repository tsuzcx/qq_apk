package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.e;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.k;

public class VideoCompressUI
  extends MMBaseActivity
{
  private static int lyw;
  private ProgressDialog Laj;
  private ABAPrams Lak;
  private a Lal;
  private boolean Lam;
  private Runnable Lan;
  private VideoTransPara pcW;
  private d pfZ;
  private String thumbPath;
  private String videoPath;
  
  public VideoCompressUI()
  {
    AppMethodBeat.i(107701);
    this.pfZ = new d(this);
    this.Lak = null;
    this.Lal = new a((byte)0);
    this.Lan = new Runnable()
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
            localPoint = VideoCompressUI.P(VideoCompressUI.d(VideoCompressUI.this).videoWidth, VideoCompressUI.d(VideoCompressUI.this).videoHeight, VideoCompressUI.a(VideoCompressUI.this).width, VideoCompressUI.a(VideoCompressUI.this).height);
            j = 0;
            str = SightVideoJNI.getMP4CprtH(VideoCompressUI.c(VideoCompressUI.this));
            i = j;
            if (str != null)
            {
              Log.i("MicroMsg.VideoCompressUI", "ABA: the metadata flag of video is : %s", new Object[] { str });
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
              break label1183;
            }
            if (localPoint != null) {
              break label1240;
            }
            localPoint = new Point(VideoCompressUI.d(VideoCompressUI.this).videoWidth, VideoCompressUI.d(VideoCompressUI.this).videoHeight);
            VideoCompressUI.c(VideoCompressUI.this);
            str = VideoCompressUI.gcZ();
            if (VideoCompressUI.a(VideoCompressUI.this).oCb == 2)
            {
              VideoCompressUI.a(VideoCompressUI.this, AdaptiveAdjustBitrate.a(VideoCompressUI.c(VideoCompressUI.this), localPoint.y, localPoint.x, VideoCompressUI.a(VideoCompressUI.this).fps, VideoCompressUI.a(VideoCompressUI.this).videoBitrate, 0.0F, 0.0F, 2, VideoCompressUI.a(VideoCompressUI.this).oCd, VideoCompressUI.a(VideoCompressUI.this).oCf, VideoCompressUI.a(VideoCompressUI.this).oCg, VideoCompressUI.a(VideoCompressUI.this).oCh, VideoCompressUI.a(VideoCompressUI.this).oCi, VideoCompressUI.a(VideoCompressUI.this).oCj, false));
              if (VideoCompressUI.f(VideoCompressUI.this) != null)
              {
                VideoCompressUI.a(VideoCompressUI.this).videoBitrate = (VideoCompressUI.f(VideoCompressUI.this).outputKbps * 1000);
                localPoint.x = VideoCompressUI.f(VideoCompressUI.this).outputWidth;
                localPoint.y = VideoCompressUI.f(VideoCompressUI.this).outputHeight;
              }
              Log.i("MicroMsg.VideoCompressUI", "ABA: VideoCompressUI Send directly: [%d], [%d], [%d] ", new Object[] { Integer.valueOf(VideoCompressUI.a(VideoCompressUI.this).videoBitrate), Integer.valueOf(localPoint.x), Integer.valueOf(localPoint.y) });
            }
            if ((VideoCompressUI.a(VideoCompressUI.this).oCc != 1) && (VideoCompressUI.a(VideoCompressUI.this).oCc != 2)) {
              continue;
            }
            Log.i("MicroMsg.VideoCompressUI", "ABA: Using Min Max QP Limitation: [%d], [%d] ", new Object[] { Integer.valueOf(VideoCompressUI.a(VideoCompressUI.this).nxU), Integer.valueOf(VideoCompressUI.a(VideoCompressUI.this).nxV) });
            i = VideoCompressUI.a(VideoCompressUI.this).nxU;
            j = VideoCompressUI.a(VideoCompressUI.this).nxV;
            if (VideoCompressUI.d(VideoCompressUI.this).videoWidth >= 2000) {
              break label1243;
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
            Log.printErrStackTrace("MicroMsg.VideoCompressUI", localException, "video compress failed e [%s]", new Object[] { localException.getMessage() });
            return;
            if (VideoCompressUI.a(VideoCompressUI.this).oCb != 2) {
              continue;
            }
            SightVideoJNI.addReportMetadata(str, VideoCompressUI.f(VideoCompressUI.this), VideoCompressUI.a(VideoCompressUI.this).oCb, 0);
            continue;
          }
          finally
          {
            VideoCompressUI.this.finish();
            MMHandlerThread.postToMainThread(new Runnable()
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
          Log.i("MicroMsg.VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s, videoSizeTooLarge:%s", new Object[] { Integer.valueOf(VideoCompressUI.d(VideoCompressUI.this).videoWidth), Integer.valueOf(VideoCompressUI.d(VideoCompressUI.this).videoHeight), localPoint, VideoCompressUI.c(VideoCompressUI.this), str, Boolean.valueOf(VideoCompressUI.e(VideoCompressUI.this)), Boolean.valueOf(bool1) });
          bool2 = WXHardCoderJNI.hcEncodeVideoEnable;
          m = WXHardCoderJNI.hcEncodeVideoDelay;
          n = WXHardCoderJNI.hcEncodeVideoCPU;
          i1 = WXHardCoderJNI.hcEncodeVideoIO;
          if (WXHardCoderJNI.hcEncodeVideoThr)
          {
            k = Process.myTid();
            VideoCompressUI.vB(WXHardCoderJNI.startPerformance(bool2, m, n, i1, k, 30000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.VideoCompressUI"));
            Log.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(VideoCompressUI.cjJ()) });
            if ((!VideoCompressUI.e(VideoCompressUI.this)) && (!bool1))
            {
              SightVideoJNI.remuxingVFS(VideoCompressUI.c(VideoCompressUI.this), str, localPoint.x, localPoint.y, VideoCompressUI.a(VideoCompressUI.this).videoBitrate, VideoCompressUI.a(VideoCompressUI.this).oBP, 8, VideoCompressUI.a(VideoCompressUI.this).oBO, 25.0F, VideoCompressUI.a(VideoCompressUI.this).fps, null, 0, false, i, j);
              if (VideoCompressUI.cjJ() != 0)
              {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, VideoCompressUI.cjJ());
                Log.i("MicroMsg.VideoCompressUI", "hardcoder summerPerformance stopPerformace %s", new Object[] { Integer.valueOf(VideoCompressUI.cjJ()) });
                VideoCompressUI.vB(0);
              }
              if (VideoCompressUI.a(VideoCompressUI.this).oCc <= 0) {
                continue;
              }
              SightVideoJNI.addReportMetadata(str, VideoCompressUI.f(VideoCompressUI.this), 0, VideoCompressUI.a(VideoCompressUI.this).oCc);
              localIntent.putExtra("K_SEGMENTVIDEOPATH", str);
              localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, str, null));
              VideoCompressUI.this.setResult(-1, localIntent);
              VideoCompressUI.this.finish();
              MMHandlerThread.postToMainThread(new Runnable()
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
          Log.i("MicroMsg.VideoCompressUI", "ish265, transfer to h264");
          VideoCompressUI.a(VideoCompressUI.this).width = localPoint.x;
          VideoCompressUI.a(VideoCompressUI.this).height = localPoint.y;
          e.a(VideoCompressUI.c(VideoCompressUI.this), str, VideoCompressUI.a(VideoCompressUI.this));
          continue;
          label1183:
          Log.i("MicroMsg.VideoCompressUI", "no need remux, directly set result");
          localIntent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.c(VideoCompressUI.this));
          localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.c(VideoCompressUI.this), VideoCompressUI.g(VideoCompressUI.this)));
          continue;
          label1240:
          continue;
          label1243:
          boolean bool1 = true;
        }
      }
    };
    AppMethodBeat.o(107701);
  }
  
  /* Error */
  private String kj(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 370
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 244	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 370
    //   16: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_2
    //   20: areturn
    //   21: new 372	android/content/Intent
    //   24: dup
    //   25: invokespecial 373	android/content/Intent:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc_w 375
    //   33: aload_1
    //   34: invokestatic 378	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 381	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 387	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: invokevirtual 391	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   46: pop
    //   47: aload_0
    //   48: aload_3
    //   49: invokestatic 397	com/tencent/mm/compatible/i/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/i/a$a;
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull +120 -> 176
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: getfield 403	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   65: ifnull +111 -> 176
    //   68: new 82	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   75: invokestatic 333	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   78: invokevirtual 336	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getAccVideoPath	()Ljava/lang/String;
    //   81: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 405
    //   87: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 343	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   98: ifeq +9 -> 107
    //   101: aload_1
    //   102: iconst_1
    //   103: invokestatic 347	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   106: pop
    //   107: aload_1
    //   108: invokestatic 350	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   111: pop
    //   112: new 82	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   119: aload_1
    //   120: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 407
    //   126: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokestatic 358	java/lang/System:currentTimeMillis	()J
    //   132: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: ldc_w 409
    //   138: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: ldc 80
    //   147: ldc_w 411
    //   150: iconst_1
    //   151: anewarray 131	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: aastore
    //   158: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_3
    //   162: getfield 403	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   165: bipush 80
    //   167: getstatic 417	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   170: aload_1
    //   171: iconst_1
    //   172: invokestatic 423	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   175: pop
    //   176: ldc_w 370
    //   179: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: areturn
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: ldc 80
    //   189: aload_3
    //   190: ldc_w 425
    //   193: iconst_1
    //   194: anewarray 131	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_3
    //   200: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    setContentView(l.a.background_transparent);
    paramBundle = getIntent();
    if ((paramBundle == null) || (Util.isNullOrNil(paramBundle.getStringExtra("K_SEGMENTVIDEOPATH"))))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(107702);
      return;
    }
    this.Laj = k.a(this, getString(l.b.app_waiting), false, null);
    this.videoPath = paramBundle.getStringExtra("K_SEGMENTVIDEOPATH");
    this.thumbPath = paramBundle.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.pfZ));
    this.pfZ.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107697);
        VideoCompressUI.a(VideoCompressUI.this, CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara());
        if (VideoCompressUI.a(VideoCompressUI.this) == null)
        {
          Log.e("MicroMsg.VideoCompressUI", "VideoSendPreprocessTask para is null");
          VideoCompressUI.this.setResult(0);
          VideoCompressUI.this.finish();
          AppMethodBeat.o(107697);
          return;
        }
        af.Ds(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        ThreadPool.post(VideoCompressUI.b(VideoCompressUI.this), "video_remuxing_if_needed");
        AppMethodBeat.o(107697);
      }
    });
    AppMethodBeat.o(107702);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107704);
    super.onDestroy();
    if (this.pfZ != null) {
      this.pfZ.release();
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
    public String oTL;
    public String oTM;
    public int oTN = -1;
    public int videoBitRate = -1;
    public int videoFrameRate = -1;
    public int videoHeight = -1;
    public int videoIFrameInterval = -1;
    public int videoWidth = -1;
    
    private a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(107700);
      String str = "VideoAnalysisStruct{videoTrackMime='" + this.oTL + '\'' + ", audioTrackMime='" + this.oTM + '\'' + ", durationMs=" + this.oTN + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.videoIFrameInterval + ", videoFrameRate=" + this.videoFrameRate + ", audioBitRate=" + this.audioBitRate + '}';
      AppMethodBeat.o(107700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI
 * JD-Core Version:    0.7.0.1
 */