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
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class u
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c, d
{
  private TextPaint iW;
  protected MMHandler kAn;
  private boolean ltv;
  private Bitmap mBitmap;
  private boolean mInited;
  private Timer mTimer;
  private int mVideoHeight;
  private int mVideoWidth;
  private int mViewId;
  private int qsO;
  private int qsP;
  private String qso;
  private int qsp;
  private int qvf;
  private Paint qvj;
  private int qvk;
  private int qvl;
  private int qvm;
  private boolean qvn;
  private boolean qvo;
  private String text;
  
  public u(Context paramContext, b paramb, JSONObject paramJSONObject)
  {
    super(paramContext);
    AppMethodBeat.i(90948);
    this.mViewId = 0;
    this.qvf = 0;
    this.qvj = null;
    this.qso = "";
    this.qsp = -1;
    this.mBitmap = null;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.ltv = false;
    this.mInited = false;
    this.qsO = 0;
    this.qsP = 0;
    this.iW = null;
    this.text = "";
    this.qvn = false;
    this.qvo = false;
    this.qsp = paramb.qrD;
    this.qso = paramb.openId;
    this.qvj = new Paint();
    this.qvj.setColor(-16777216);
    this.qvj.setFilterBitmap(false);
    setSurfaceTextureListener(this);
    this.qvn = paramJSONObject.optBoolean("debug", false);
    if ((this.qvn) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      this.qvn = bool;
      if (!this.qvn) {
        break label325;
      }
      this.qvm = 0;
      this.iW = new TextPaint();
      this.iW.setColor(-65536);
      this.iW.setTextSize(25.0F);
      this.iW.setAntiAlias(true);
      this.qvo = false;
      this.mTimer = new Timer("CloudVoIP_video_info");
      this.text = "debug...";
      this.kAn = new MMHandler();
      if ((this.mTimer != null) && (!this.qvo) && (this.kAn != null)) {
        break;
      }
      AppMethodBeat.o(90948);
      return;
    }
    this.qvo = true;
    paramContext = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(90947);
        u.this.kAn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90946);
            u.a(u.this);
            AppMethodBeat.o(90946);
          }
        });
        AppMethodBeat.o(90947);
      }
    };
    this.mTimer.schedule(paramContext, 1000L, 1000L);
    label325:
    AppMethodBeat.o(90948);
  }
  
  private void czn()
  {
    AppMethodBeat.i(186790);
    czo();
    try
    {
      this.ltv = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(186790);
    }
  }
  
  private void czo()
  {
    AppMethodBeat.i(186791);
    try
    {
      Canvas localCanvas = lockCanvas();
      localCanvas.drawColor(-16777216);
      unlockCanvasAndPost(localCanvas);
      AppMethodBeat.o(186791);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", localException, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
      AppMethodBeat.o(186791);
    }
  }
  
  private static int k(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void ES(int paramInt)
  {
    AppMethodBeat.i(90952);
    if (paramInt == this.qsp)
    {
      AppMethodBeat.o(90952);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + paramInt + "]");
    this.qsp = paramInt;
    AppMethodBeat.o(90952);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(90953);
    int i;
    int j;
    Object localObject1;
    int k;
    try
    {
      if ((!this.ltv) || (!this.mInited)) {
        return;
      }
      if ((this.mVideoWidth != parama.width) || (this.mVideoHeight != parama.height) || (this.mBitmap == null))
      {
        this.mVideoWidth = parama.width;
        this.mVideoHeight = parama.height;
        this.mBitmap = Bitmap.createBitmap(parama.width, parama.height, Bitmap.Config.ARGB_8888);
      }
      localObject2 = parama.qrB;
      i = parama.djh;
      if (i == 0)
      {
        parama = null;
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
          Log.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "DrawBitmap, bitmap is null or recycled");
        }
        catch (Exception parama)
        {
          Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", parama, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
          continue;
        }
        return;
        j = i / 4;
        localObject1 = new int[j];
        i = 0;
        parama = (a)localObject1;
        if (i >= j) {
          break;
        }
        localObject1[i] = (k(localObject2[(i * 4)]) | k(localObject2[(i * 4 + 1)]) << 8 | k(localObject2[(i * 4 + 2)]) << 16 | k(localObject2[(i * 4 + 3)]) << 24);
        i += 1;
        continue;
        j = parama.getWidth();
        k = parama.getHeight();
        localObject1 = lockCanvas(null);
        if (localObject1 != null) {
          break label372;
        }
        Log.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp);
      }
      this.qvf += 1;
    }
    finally
    {
      AppMethodBeat.o(90953);
    }
    label372:
    Object localObject2 = new Matrix();
    label417:
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
      if (this.qvf % 50 == 0)
      {
        this.qvf = 0;
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, canvas:[width:" + ((Canvas)localObject1).getWidth() + ", height:" + ((Canvas)localObject1).getHeight() + "], bitmap:[width:" + j + ", height:" + k + "]");
      }
      f1 = ((Canvas)localObject1).getWidth() / k;
      f2 = ((Canvas)localObject1).getHeight() / j;
      if (f1 <= f2) {
        break label789;
      }
      label553:
      ((Matrix)localObject2).postTranslate((k - j) / 2, (j - k) / 2);
      f2 = j * ((Canvas)localObject1).getWidth() / ((Canvas)localObject1).getHeight();
      f2 = -(k - f2) / 2.0F;
      if (f2 <= 0.0001D) {
        break label794;
      }
      f2 = 0.0F;
    }
    label789:
    label794:
    for (;;)
    {
      float f3 = k * ((Canvas)localObject1).getHeight() / ((Canvas)localObject1).getWidth();
      float f4 = -(j - f3) / 2.0F;
      f3 = f4;
      if (f4 > 0.0001D) {
        f3 = 0.0F;
      }
      ((Matrix)localObject2).postTranslate(f2, f3);
      ((Matrix)localObject2).postScale(f1, f1);
      ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
      if (!parama.isRecycled()) {
        ((Canvas)localObject1).drawBitmap(parama, (Matrix)localObject2, this.qvj);
      }
      if (this.qvn)
      {
        this.qvm += 1;
        new StaticLayout(this.text, this.iW, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw((Canvas)localObject1);
      }
      unlockCanvasAndPost((Canvas)localObject1);
      break;
      if (i != OpenGlRender.FLAG_Angle90) {
        break label417;
      }
      ((Matrix)localObject2).setRotate(90.0F, j / 2, k / 2);
      break label417;
      f1 = f2;
      break label553;
    }
  }
  
  public final void aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90949);
    this.mViewId = paramJSONObject.optInt("viewId");
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + paramJSONObject.toString());
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
  
  public final void aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90950);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + paramJSONObject.toString());
    uint();
    aG(paramJSONObject);
    AppMethodBeat.o(90950);
  }
  
  public final boolean cyX()
  {
    return false;
  }
  
  public final void fq(int paramInt1, int paramInt2)
  {
    this.qvk = paramInt1;
    this.qvl = paramInt2;
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    this.qsO = paramInt1;
    this.qsP = paramInt2;
  }
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(186793);
    if (this.qsP > 0)
    {
      i = this.qsP;
      AppMethodBeat.o(186793);
      return i;
    }
    int i = g.zC(getHeight());
    AppMethodBeat.o(186793);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(186792);
    if (this.qsO > 0)
    {
      i = this.qsO;
      AppMethodBeat.o(186792);
      return i;
    }
    int i = g.zC(getWidth());
    AppMethodBeat.o(186792);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.qsp;
  }
  
  public final String getOpenId()
  {
    return this.qso;
  }
  
  public final int getSameLayerSurfaceHeight()
  {
    return this.qvl;
  }
  
  public final int getSameLayerSurfaceWidth()
  {
    return this.qvk;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90954);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {}
    for (paramSurfaceTexture = "isNull";; paramSurfaceTexture = "nonNull")
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture + ", viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + paramInt1 + ", height:" + paramInt2);
      gLi();
      czn();
      AppMethodBeat.o(90954);
      return;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(90956);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp);
    try
    {
      this.ltv = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.kAn != null) {
        this.kAn.removeCallbacksAndMessages(null);
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
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(90955);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(186789);
    super.setSurfaceTexture(paramSurfaceTexture);
    czn();
    AppMethodBeat.o(186789);
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90951);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp);
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
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.u
 * JD-Core Version:    0.7.0.1
 */