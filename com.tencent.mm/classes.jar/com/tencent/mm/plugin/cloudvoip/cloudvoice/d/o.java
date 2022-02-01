package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.2;
import com.tencent.mm.plugin.voip.video.OpenGlRender.3;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  extends RelativeLayout
  implements c, com.tencent.mm.plugin.voip.video.camera.a.c
{
  private int Go;
  private int mHeight;
  private int mWidth;
  private String tQX;
  private int tQY;
  private i tQZ;
  private int tQz;
  private int tRA;
  private int tRB;
  private CaptureView tRv;
  OpenGlRender tRw;
  private OpenGlView tRx;
  boolean tRy;
  private boolean tRz;
  
  public o(Context paramContext, b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(203305);
    this.Go = 0;
    this.tQX = "";
    this.tQY = -1;
    this.tQz = 0;
    this.tQZ = null;
    this.tRz = false;
    this.tRA = 0;
    this.tRB = 0;
    this.mWidth = 640;
    this.mHeight = 480;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "anlin OpenVoiceOpenGlView: mWidth: " + this.mWidth + ", height: " + this.mHeight);
    this.tQZ = new i(this.mWidth, this.mHeight);
    this.tQY = paramb.tQm;
    this.tQX = paramb.openId;
    this.tRx = new OpenGlView(paramContext);
    this.tRw = new OpenGlRender(this.tRx, OpenGlRender.RenderLocal);
    this.tRy = true;
    this.tRx.setRenderer(this.tRw);
    this.tRx.setRenderMode(0);
    addView(this.tRx);
    this.tRv = new CaptureView(paramContext);
    addView(this.tRv, new RelativeLayout.LayoutParams(1, 1));
    this.tRv.setVisibility(0);
    this.tRv.setAlpha(0.0F);
    AppMethodBeat.o(203305);
  }
  
  /* Error */
  private float[] P(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 160
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 162	org/json/JSONObject
    //   8: dup
    //   9: aload_1
    //   10: ldc 164
    //   12: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore 8
    //   20: aload 8
    //   22: ldc 171
    //   24: fconst_0
    //   25: invokestatic 177	com/tencent/mm/plugin/appbrand/ac/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   28: fstore_2
    //   29: aload 8
    //   31: ldc 179
    //   33: fconst_0
    //   34: invokestatic 177	com/tencent/mm/plugin/appbrand/ac/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   37: fstore_3
    //   38: aload 8
    //   40: ldc 181
    //   42: fconst_0
    //   43: invokestatic 177	com/tencent/mm/plugin/appbrand/ac/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   46: fstore 4
    //   48: aload 8
    //   50: ldc 183
    //   52: fconst_0
    //   53: invokestatic 177	com/tencent/mm/plugin/appbrand/ac/g:a	(Lorg/json/JSONObject;Ljava/lang/String;F)F
    //   56: fstore 5
    //   58: aload_1
    //   59: ldc 185
    //   61: iconst_0
    //   62: invokevirtual 189	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: istore 7
    //   67: aload_0
    //   68: aload 8
    //   70: ldc 181
    //   72: dconst_0
    //   73: invokevirtual 193	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   76: d2i
    //   77: putfield 59	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:tRA	I
    //   80: aload_0
    //   81: aload 8
    //   83: ldc 183
    //   85: dconst_0
    //   86: invokevirtual 193	org/json/JSONObject:optDouble	(Ljava/lang/String;D)D
    //   89: d2i
    //   90: putfield 61	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:tRB	I
    //   93: ldc 67
    //   95: ldc 195
    //   97: iconst_4
    //   98: anewarray 197	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: fload 4
    //   105: invokestatic 203	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: fload 5
    //   113: invokestatic 203	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload_0
    //   120: getfield 59	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:tRA	I
    //   123: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: aastore
    //   127: dup
    //   128: iconst_3
    //   129: aload_0
    //   130: getfield 61	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:tRB	I
    //   133: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: iload 7
    //   142: i2f
    //   143: fstore 6
    //   145: ldc 160
    //   147: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_5
    //   151: newarray float
    //   153: dup
    //   154: iconst_0
    //   155: fload_2
    //   156: fastore
    //   157: dup
    //   158: iconst_1
    //   159: fload_3
    //   160: fastore
    //   161: dup
    //   162: iconst_2
    //   163: fload 4
    //   165: fastore
    //   166: dup
    //   167: iconst_3
    //   168: fload 5
    //   170: fastore
    //   171: dup
    //   172: iconst_4
    //   173: fload 6
    //   175: fastore
    //   176: areturn
    //   177: astore_1
    //   178: ldc 160
    //   180: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_1
    //   186: goto -93 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	o
    //   0	189	1	paramJSONObject	JSONObject
    //   28	128	2	f1	float
    //   37	123	3	f2	float
    //   46	118	4	f3	float
    //   56	113	5	f4	float
    //   143	31	6	f5	float
    //   65	76	7	i	int
    //   18	64	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   5	20	177	java/lang/Exception
    //   67	93	185	java/lang/Exception
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(203354);
    com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c.ad(paramInt, this.tQZ.gDP());
    AppMethodBeat.o(203354);
  }
  
  public final void Iz(int paramInt)
  {
    AppMethodBeat.i(203345);
    if (paramInt == this.tQY)
    {
      AppMethodBeat.o(203345);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:[" + this.tQY + "->" + paramInt + "]");
    this.tQY = paramInt;
    AppMethodBeat.o(203345);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203352);
    int i = this.tQz;
    this.tQz = (i + 1);
    if (i % 50 == 0) {
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!q.tRM.tRR.isStarted())
    {
      AppMethodBeat.o(203352);
      return;
    }
    OpenGlRender localOpenGlRender = this.tRw;
    i = OpenGlRender.FLAG_NV21;
    CountDownLatch localCountDownLatch;
    if ((localOpenGlRender.NZo) && (localOpenGlRender.NZk != null) && (paramArrayOfByte.length >= paramInt1 * paramInt2) && (i == OpenGlRender.FLAG_NV21))
    {
      localCountDownLatch = new CountDownLatch(1);
      localOpenGlRender.NZl = paramArrayOfByte;
      if (localOpenGlRender.NYW != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.NYW.get();
        if (localOpenGlView != null) {
          localOpenGlView.aa(new OpenGlRender.3(localOpenGlRender, paramInt1, paramInt2, localCountDownLatch));
        }
      }
    }
    try
    {
      localCountDownLatch.await(2L, TimeUnit.SECONDS);
      label241:
      q.tRM.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
      if (this.tQZ.gDP())
      {
        paramInt3 = OpenGlRender.FLAG_Mirror;
        if (!this.tQZ.gDz()) {
          break label322;
        }
      }
      label322:
      for (paramInt4 = OpenGlRender.FLAG_Angle270;; paramInt4 = OpenGlRender.FLAG_Angle90)
      {
        this.tRw.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + OpenGlRender.FLAG_NV21 + paramInt4, true, 3);
        AppMethodBeat.o(203352);
        return;
        paramInt3 = 0;
        break;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label241;
    }
  }
  
  public final void aK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(203316);
    this.Go = paramJSONObject.optInt("viewId");
    this.tRz = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(localObject)));
      if (((String)localObject).equals("back")) {
        this.tRz = false;
      }
    }
    this.tQZ.a(this, this.tRz);
    this.tQZ.a(this.tRv);
    this.tQZ.gDB();
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY + ", data:" + paramJSONObject.toString());
    e.gEk().OcN = new e.a()
    {
      public final void Pu()
      {
        AppMethodBeat.i(202751);
        o localo = o.this;
        SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
        d locald = v2protocal.NSP;
        if ((localSurfaceTexture == null) || (locald == null))
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { localSurfaceTexture, locald });
          AppMethodBeat.o(202751);
          return;
        }
        if ((!localo.tRy) || (localo.tRw == null))
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(locald.kVj), Boolean.valueOf(localo.tRy) });
          AppMethodBeat.o(202751);
          return;
        }
        localo.tRw.a(localSurfaceTexture, locald);
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(locald.kVj) });
        AppMethodBeat.o(202751);
      }
    };
    try
    {
      paramJSONObject = P(paramJSONObject);
      if (paramJSONObject != null) {
        this.tRx.kV((int)paramJSONObject[2], (int)paramJSONObject[3]);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
      }
    }
    this.tRw.qS();
    AppMethodBeat.o(203316);
  }
  
  public final void aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(203333);
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY + ", data:" + paramJSONObject.toString());
    for (;;)
    {
      try
      {
        localObject = P(paramJSONObject);
        if (localObject != null) {
          this.tRx.onSurfaceTextureSizeChanged(v2protocal.mSurfaceTexture, (int)localObject[2], (int)localObject[3]);
        }
        paramJSONObject = paramJSONObject.optJSONObject("config");
        if (paramJSONObject == null) {
          break label311;
        }
        paramJSONObject = paramJSONObject.optString("camera", "back");
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(paramJSONObject)));
        if (!paramJSONObject.equals("back")) {
          break label311;
        }
        bool = false;
        if (bool == this.tRz) {
          break label304;
        }
        this.tRz = bool;
        this.tQZ.gDD();
        paramJSONObject = this.tRw;
        if ((!paramJSONObject.NZo) || (paramJSONObject.NZk == null))
        {
          AppMethodBeat.o(203333);
          return;
        }
        if ((paramJSONObject.NZm == 0) || (paramJSONObject.NZn == 0))
        {
          AppMethodBeat.o(203333);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
        AppMethodBeat.o(203333);
        return;
      }
      Object localObject = new CountDownLatch(1);
      if (paramJSONObject.NYW != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)paramJSONObject.NYW.get();
        if (localOpenGlView != null) {
          localOpenGlView.aa(new OpenGlRender.2(paramJSONObject, (CountDownLatch)localObject));
        }
      }
      try
      {
        ((CountDownLatch)localObject).await(2L, TimeUnit.SECONDS);
        AppMethodBeat.o(203333);
        return;
      }
      catch (InterruptedException paramJSONObject) {}
      label304:
      AppMethodBeat.o(203333);
      return;
      label311:
      boolean bool = true;
    }
  }
  
  public final boolean cNt()
  {
    return true;
  }
  
  public final boolean cNu()
  {
    return false;
  }
  
  public final boolean cNv()
  {
    return false;
  }
  
  public final void cNy() {}
  
  public final void fP(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(203361);
    if (this.tRB > 0)
    {
      i = this.tRB;
      AppMethodBeat.o(203361);
      return i;
    }
    int i = g.Dh(getHeight());
    AppMethodBeat.o(203361);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(203360);
    if (this.tRA > 0)
    {
      i = this.tRA;
      AppMethodBeat.o(203360);
      return i;
    }
    int i = g.Dh(getWidth());
    AppMethodBeat.o(203360);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.tQY;
  }
  
  public final String getOpenId()
  {
    return this.tQX;
  }
  
  public final int getViewId()
  {
    return this.Go;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(203340);
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY);
    this.tQZ.eXS();
    this.tRw.releaseSurfaceTexture();
    this.tRw.gDm();
    AppMethodBeat.o(203340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o
 * JD-Core Version:    0.7.0.1
 */