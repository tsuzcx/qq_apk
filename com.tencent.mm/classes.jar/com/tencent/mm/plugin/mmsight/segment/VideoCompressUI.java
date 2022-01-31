package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mm.bi.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

@TargetApi(16)
public class VideoCompressUI
  extends MMBaseActivity
{
  private VideoTransPara eJA;
  private d eMh = new d(this);
  private ProgressDialog mne;
  private VideoCompressUI.a mnf = new VideoCompressUI.a(this, (byte)0);
  private boolean mng;
  private Runnable mnh = new Runnable()
  {
    public final void run()
    {
      label469:
      for (;;)
      {
        try
        {
          VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.c(VideoCompressUI.this));
          localIntent = new Intent();
          Point localPoint = VideoCompressUI.v(VideoCompressUI.d(VideoCompressUI.this).videoWidth, VideoCompressUI.d(VideoCompressUI.this).videoHeight, VideoCompressUI.a(VideoCompressUI.this).width, VideoCompressUI.a(VideoCompressUI.this).height);
          if ((!VideoCompressUI.b(VideoCompressUI.this, VideoCompressUI.a(VideoCompressUI.this))) && (localPoint == null)) {
            continue;
          }
          if (localPoint != null) {
            break label469;
          }
          localPoint = new Point(VideoCompressUI.d(VideoCompressUI.this).videoWidth, VideoCompressUI.d(VideoCompressUI.this).videoHeight);
          str = VideoCompressUI.bjY();
          y.i("VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s, ish265: %s", new Object[] { Integer.valueOf(VideoCompressUI.d(VideoCompressUI.this).videoWidth), Integer.valueOf(VideoCompressUI.d(VideoCompressUI.this).videoHeight), localPoint, VideoCompressUI.c(VideoCompressUI.this), str, Boolean.valueOf(VideoCompressUI.e(VideoCompressUI.this)) });
          if (VideoCompressUI.e(VideoCompressUI.this)) {
            continue;
          }
          SightVideoJNI.remuxing(VideoCompressUI.c(VideoCompressUI.this), str, localPoint.x, localPoint.y, VideoCompressUI.a(VideoCompressUI.this).videoBitrate, VideoCompressUI.a(VideoCompressUI.this).ejP, 8, VideoCompressUI.a(VideoCompressUI.this).ejO, 25.0F, VideoCompressUI.a(VideoCompressUI.this).fps, null, 0, false);
          localIntent.putExtra("K_SEGMENTVIDEOPATH", str);
          localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, str, null));
        }
        catch (Exception localException)
        {
          Intent localIntent;
          String str;
          y.printErrStackTrace("VideoCompressUI", localException, "video compress failed e [%s]", new Object[] { localException.getMessage() });
          return;
          y.i("VideoCompressUI", "no need remux, directly set result");
          localIntent.putExtra("K_SEGMENTVIDEOPATH", VideoCompressUI.c(VideoCompressUI.this));
          localIntent.putExtra("KSEGMENTVIDEOTHUMBPATH", VideoCompressUI.a(VideoCompressUI.this, VideoCompressUI.c(VideoCompressUI.this), VideoCompressUI.f(VideoCompressUI.this)));
          continue;
        }
        finally
        {
          VideoCompressUI.this.finish();
          ai.d(new Runnable()
          {
            public final void run()
            {
              if (VideoCompressUI.g(VideoCompressUI.this) != null) {
                VideoCompressUI.g(VideoCompressUI.this).dismiss();
              }
            }
          });
        }
        VideoCompressUI.this.setResult(-1, localIntent);
        VideoCompressUI.this.finish();
        ai.d(new Runnable()
        {
          public final void run()
          {
            if (VideoCompressUI.g(VideoCompressUI.this) != null) {
              VideoCompressUI.g(VideoCompressUI.this).dismiss();
            }
          }
        });
        return;
        y.i("VideoCompressUI", "ish265, transfer to h264");
        e.a(VideoCompressUI.c(VideoCompressUI.this), str, VideoCompressUI.a(VideoCompressUI.this));
      }
    }
  };
  private String thumbPath;
  private String videoPath;
  
  /* Error */
  private String dT(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 152	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifne +5 -> 9
    //   7: aload_2
    //   8: areturn
    //   9: new 275	android/content/Intent
    //   12: dup
    //   13: invokespecial 276	android/content/Intent:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: new 221	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 278
    //   25: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 286	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   38: invokevirtual 290	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   41: pop
    //   42: aload_0
    //   43: aload_3
    //   44: invokestatic 296	com/tencent/mm/compatible/j/a:h	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/j/a$a;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -42 -> 7
    //   52: aload_3
    //   53: getfield 302	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   56: ifnull -49 -> 7
    //   59: new 221	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   66: invokestatic 228	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   69: invokevirtual 231	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getAccVideoPath	()Ljava/lang/String;
    //   72: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 304
    //   78: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic 245	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   89: ifeq +9 -> 98
    //   92: aload_1
    //   93: iconst_1
    //   94: invokestatic 249	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   97: pop
    //   98: aload_1
    //   99: invokestatic 252	com/tencent/mm/vfs/e:nb	(Ljava/lang/String;)Z
    //   102: pop
    //   103: new 221	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   110: aload_1
    //   111: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 306
    //   117: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokestatic 260	java/lang/System:currentTimeMillis	()J
    //   123: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   126: ldc_w 308
    //   129: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: ldc 92
    //   138: ldc_w 310
    //   141: iconst_1
    //   142: anewarray 96	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: invokestatic 102	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_3
    //   153: getfield 302	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   156: bipush 80
    //   158: getstatic 316	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   161: aload_1
    //   162: iconst_1
    //   163: invokestatic 321	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   166: aload_1
    //   167: areturn
    //   168: astore_1
    //   169: ldc 92
    //   171: aload_1
    //   172: ldc_w 323
    //   175: iconst_1
    //   176: anewarray 96	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_1
    //   182: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic 327	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_2
    //   190: areturn
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: aload_3
    //   195: astore_1
    //   196: goto -27 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	VideoCompressUI
    //   0	199	1	paramString1	String
    //   0	199	2	paramString2	String
    //   16	137	3	localObject	Object
    //   191	4	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	48	168	java/lang/Exception
    //   52	98	168	java/lang/Exception
    //   98	152	168	java/lang/Exception
    //   152	166	191	java/lang/Exception
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(l.a.background_transparent);
    paramBundle = getIntent();
    if ((paramBundle == null) || (bk.bl(paramBundle.getStringExtra("K_SEGMENTVIDEOPATH"))))
    {
      setResult(0);
      finish();
      return;
    }
    this.mne = h.b(this, getString(l.b.app_waiting), false, null);
    this.videoPath = paramBundle.getStringExtra("K_SEGMENTVIDEOPATH");
    this.thumbPath = paramBundle.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.eMh));
    this.eMh.connect(new VideoCompressUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.eMh != null) {
      this.eMh.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI
 * JD-Core Version:    0.7.0.1
 */