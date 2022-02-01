package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class t
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c
{
  private TextPaint gZ;
  private boolean jSj;
  protected ao jdu;
  private Bitmap mBitmap;
  private boolean mInited;
  private Timer mTimer;
  private int mVideoHeight;
  private int mVideoWidth;
  private int mViewId;
  private String otp;
  private int otq;
  private int owc;
  private Paint owg;
  private int owh;
  private boolean owi;
  private boolean owj;
  private String text;
  
  public t(Context paramContext, b paramb, JSONObject paramJSONObject)
  {
    super(paramContext);
    AppMethodBeat.i(90948);
    this.mViewId = 0;
    this.owc = 0;
    this.owg = null;
    this.otp = "";
    this.otq = -1;
    this.mBitmap = null;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.jSj = false;
    this.mInited = false;
    this.gZ = null;
    this.text = "";
    this.owi = false;
    this.owj = false;
    this.otq = paramb.osF;
    this.otp = paramb.openId;
    this.owg = new Paint();
    this.owg.setColor(-16777216);
    this.owg.setFilterBitmap(false);
    setSurfaceTextureListener(this);
    this.owi = paramJSONObject.optBoolean("debug", false);
    if ((this.owi) || (h.IS_FLAVOR_RED) || (bt.eWo())) {}
    for (boolean bool = true;; bool = false)
    {
      this.owi = bool;
      if (!this.owi) {
        break label315;
      }
      this.owh = 0;
      this.gZ = new TextPaint();
      this.gZ.setColor(-65536);
      this.gZ.setTextSize(25.0F);
      this.gZ.setAntiAlias(true);
      this.owj = false;
      this.mTimer = new Timer("CloudVoIP_video_info");
      this.text = "debug...";
      this.jdu = new ao();
      if ((this.mTimer != null) && (!this.owj) && (this.jdu != null)) {
        break;
      }
      AppMethodBeat.o(90948);
      return;
    }
    this.owj = true;
    paramContext = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(90947);
        t.this.jdu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90946);
            t.a(t.this);
            AppMethodBeat.o(90946);
          }
        });
        AppMethodBeat.o(90947);
      }
    };
    this.mTimer.schedule(paramContext, 1000L, 1000L);
    label315:
    AppMethodBeat.o(90948);
  }
  
  private static int b(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void Ap(int paramInt)
  {
    AppMethodBeat.i(90952);
    if (paramInt == this.otq)
    {
      AppMethodBeat.o(90952);
      return;
    }
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:[" + this.otq + "->" + paramInt + "]");
    this.otq = paramInt;
    AppMethodBeat.o(90952);
  }
  
  public final void a(a parama)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(90953);
    int j;
    int k;
    try
    {
      if ((!this.jSj) || (!this.mInited)) {
        return;
      }
      if ((this.mVideoWidth != parama.width) || (this.mVideoHeight != parama.height) || (this.mBitmap == null))
      {
        this.mVideoWidth = parama.width;
        this.mVideoHeight = parama.height;
        this.mBitmap = Bitmap.createBitmap(parama.width, parama.height, Bitmap.Config.ARGB_8888);
      }
      localObject2 = parama.osD;
      j = parama.cGX;
      if (j == 0)
      {
        parama = (a)localObject1;
        this.mBitmap.setPixels(parama, 0, this.mVideoWidth, 0, 0, this.mVideoWidth, this.mVideoHeight);
        parama = this.mBitmap;
        i = OpenGlRender.FLAG_Angle90;
        if (parama == null) {}
      }
      for (;;)
      {
        try
        {
          if (!parama.isRecycled()) {
            continue;
          }
          ac.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "DrawBitmap, bitmap is null or recycled");
        }
        catch (Exception parama)
        {
          ac.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", parama, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
          continue;
        }
        return;
        j /= 4;
        localObject1 = new int[j];
        parama = (a)localObject1;
        if (i >= j) {
          break;
        }
        localObject1[i] = (b(localObject2[(i * 4)]) | b(localObject2[(i * 4 + 1)]) << 8 | b(localObject2[(i * 4 + 2)]) << 16 | b(localObject2[(i * 4 + 3)]) << 24);
        i += 1;
        continue;
        j = parama.getWidth();
        k = parama.getHeight();
        localObject1 = lockCanvas(null);
        if (localObject1 != null) {
          break label376;
        }
        ac.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.mViewId + ", openId:" + this.otp + ", mId:" + this.otq);
      }
      this.owc += 1;
    }
    finally
    {
      AppMethodBeat.o(90953);
    }
    label376:
    Object localObject2 = new Matrix();
    label421:
    float f1;
    float f2;
    if (i == OpenGlRender.FLAG_Angle270)
    {
      ((Matrix)localObject2).setRotate(270.0F, j / 2, k / 2);
      if (OpenGlRender.FLAG_Mirror == 0)
      {
        ((Matrix)localObject2).postScale(-1.0F, 1.0F);
        ((Matrix)localObject2).postTranslate(j, 0.0F);
      }
      if (this.owc % 50 == 0)
      {
        this.owc = 0;
        ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, canvas:[width:" + ((Canvas)localObject1).getWidth() + ", height:" + ((Canvas)localObject1).getHeight() + "], bitmap:[width:" + j + ", height:" + k + "]");
      }
      f1 = ((Canvas)localObject1).getWidth() / k;
      f2 = ((Canvas)localObject1).getHeight() / j;
      if (f1 <= f2) {
        break label699;
      }
    }
    for (;;)
    {
      ((Matrix)localObject2).postTranslate((k - j) / 2, (j - k) / 2);
      ((Matrix)localObject2).postScale(f1, f1);
      ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
      if (!parama.isRecycled()) {
        ((Canvas)localObject1).drawBitmap(parama, (Matrix)localObject2, this.owg);
      }
      if (this.owi)
      {
        this.owh += 1;
        new StaticLayout(this.text, this.gZ, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw((Canvas)localObject1);
      }
      unlockCanvasAndPost((Canvas)localObject1);
      break;
      if (i != OpenGlRender.FLAG_Angle90) {
        break label421;
      }
      ((Matrix)localObject2).setRotate(90.0F, j / 2, k / 2);
      break label421;
      label699:
      f1 = f2;
    }
  }
  
  public final void al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90949);
    this.mViewId = paramJSONObject.optInt("viewId");
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq + ", data:" + paramJSONObject.toString());
    try
    {
      this.mInited = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(90949);
    }
  }
  
  public final void am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90950);
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq + ", data:" + paramJSONObject.toString());
    uint();
    al(paramJSONObject);
    AppMethodBeat.o(90950);
  }
  
  public final boolean bVo()
  {
    return false;
  }
  
  public final int getMemberId()
  {
    return this.otq;
  }
  
  public final String getOpenId()
  {
    return this.otp;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90954);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {
      paramSurfaceTexture = "isNull";
    }
    for (;;)
    {
      ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture + ", viewId:" + this.mViewId + ", openId:" + this.otp + ", mId:" + this.otq + ", width:" + paramInt1 + ", height:" + paramInt2);
      fiQ();
      try
      {
        paramSurfaceTexture = lockCanvas();
        paramSurfaceTexture.drawColor(-16777216);
        unlockCanvasAndPost(paramSurfaceTexture);
        try
        {
          this.jSj = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(90954);
        }
        paramSurfaceTexture = "nonNull";
      }
      catch (Exception paramSurfaceTexture)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(90956);
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.otp + ", mId:" + this.otq);
    try
    {
      this.jSj = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.jdu != null) {
        this.jdu.removeCallbacksAndMessages(null);
      }
      AppMethodBeat.o(90956);
      return false;
    }
    finally
    {
      AppMethodBeat.o(90956);
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90955);
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.otp + ", mId:" + this.otq + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(90955);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void uint()
  {
    AppMethodBeat.i(90951);
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq);
    try
    {
      this.mInited = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(90951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t
 * JD-Core Version:    0.7.0.1
 */