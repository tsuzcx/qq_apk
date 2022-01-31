package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

@TargetApi(16)
public class VideoCompressUI
  extends MMBaseActivity
{
  private static int eez;
  private d evl;
  private VideoTransPara fZe;
  private ProgressDialog oMl;
  private int[] oMm;
  private VideoCompressUI.a oMn;
  private boolean oMo;
  private Runnable oMp;
  private String thumbPath;
  private String videoPath;
  
  public VideoCompressUI()
  {
    AppMethodBeat.i(3699);
    this.evl = new d(this);
    this.oMm = new int[] { 0, 0, 0, 0, 0, 0 };
    this.oMn = new VideoCompressUI.a(this, (byte)0);
    this.oMp = new VideoCompressUI.2(this);
    AppMethodBeat.o(3699);
  }
  
  /* Error */
  private String fm(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 3701
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 233	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifne +11 -> 21
    //   13: sipush 3701
    //   16: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_2
    //   20: areturn
    //   21: new 354	android/content/Intent
    //   24: dup
    //   25: invokespecial 355	android/content/Intent:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc_w 357
    //   33: aload_1
    //   34: invokestatic 360	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: invokevirtual 363	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokestatic 369	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: invokevirtual 373	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   46: pop
    //   47: aload_0
    //   48: aload_3
    //   49: invokestatic 379	com/tencent/mm/compatible/j/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/j/a$a;
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload_3
    //   56: ifnull +119 -> 175
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: getfield 385	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   65: ifnull +110 -> 175
    //   68: new 78	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   75: invokestatic 311	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getInstance	()Lcom/tencent/mm/plugin/mmsight/model/CaptureMMProxy;
    //   78: invokevirtual 314	com/tencent/mm/plugin/mmsight/model/CaptureMMProxy:getAccVideoPath	()Ljava/lang/String;
    //   81: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 387
    //   87: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 321	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   98: ifeq +9 -> 107
    //   101: aload_1
    //   102: iconst_1
    //   103: invokestatic 325	com/tencent/mm/vfs/e:O	(Ljava/lang/String;Z)Z
    //   106: pop
    //   107: aload_1
    //   108: invokestatic 328	com/tencent/mm/vfs/e:um	(Ljava/lang/String;)Z
    //   111: pop
    //   112: new 78	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   119: aload_1
    //   120: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 389
    //   126: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokestatic 336	java/lang/System:currentTimeMillis	()J
    //   132: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: ldc_w 391
    //   138: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: ldc 76
    //   147: ldc_w 393
    //   150: iconst_1
    //   151: anewarray 127	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: aastore
    //   158: invokestatic 136	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_3
    //   162: getfield 385	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   165: bipush 80
    //   167: getstatic 399	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   170: aload_1
    //   171: iconst_1
    //   172: invokestatic 404	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   175: sipush 3701
    //   178: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: areturn
    //   183: astore_3
    //   184: aload_2
    //   185: astore_1
    //   186: ldc 76
    //   188: aload_3
    //   189: ldc_w 406
    //   192: iconst_1
    //   193: anewarray 127	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_3
    //   199: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 410	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -31 -> 175
    //   209: astore_3
    //   210: goto -24 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	VideoCompressUI
    //   0	213	1	paramString1	String
    //   0	213	2	paramString2	String
    //   28	134	3	localObject	java.lang.Object
    //   183	16	3	localException1	java.lang.Exception
    //   209	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	53	183	java/lang/Exception
    //   61	107	183	java/lang/Exception
    //   107	161	183	java/lang/Exception
    //   161	175	209	java/lang/Exception
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(3700);
    super.onCreate(paramBundle);
    setContentView(2130968799);
    paramBundle = getIntent();
    if ((paramBundle == null) || (bo.isNullOrNil(paramBundle.getStringExtra("K_SEGMENTVIDEOPATH"))))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(3700);
      return;
    }
    this.oMl = h.b(this, getString(2131297112), false, null);
    this.videoPath = paramBundle.getStringExtra("K_SEGMENTVIDEOPATH");
    this.thumbPath = paramBundle.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    this.evl.connect(new VideoCompressUI.1(this));
    AppMethodBeat.o(3700);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(3702);
    super.onDestroy();
    if (this.evl != null) {
      this.evl.release();
    }
    AppMethodBeat.o(3702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoCompressUI
 * JD-Core Version:    0.7.0.1
 */