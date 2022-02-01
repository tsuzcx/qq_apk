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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class s
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c
{
  private TextPaint ga;
  protected ap iDu;
  private boolean jrR;
  private Bitmap mBitmap;
  private boolean mInited;
  private Timer mTimer;
  private int mVideoHeight;
  private int mVideoWidth;
  private int mViewId;
  private String nQk;
  private int nQl;
  private int nSI;
  private Paint nSL;
  private int nSM;
  private boolean nSN;
  private boolean nSO;
  private String text;
  
  public s(Context paramContext, b paramb, JSONObject paramJSONObject)
  {
    super(paramContext);
    AppMethodBeat.i(90948);
    this.mViewId = 0;
    this.nSI = 0;
    this.nSL = null;
    this.nQk = "";
    this.nQl = -1;
    this.mBitmap = null;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.jrR = false;
    this.mInited = false;
    this.ga = null;
    this.text = "";
    this.nSN = false;
    this.nSO = false;
    this.nQl = paramb.nPB;
    this.nQk = paramb.openId;
    this.nSL = new Paint();
    this.nSL.setColor(-16777216);
    this.nSL.setFilterBitmap(false);
    setSurfaceTextureListener(this);
    this.nSN = paramJSONObject.optBoolean("debug", false);
    if ((this.nSN) || (h.IS_FLAVOR_RED) || (bu.eGT())) {}
    for (boolean bool = true;; bool = false)
    {
      this.nSN = bool;
      if (!this.nSN) {
        break label315;
      }
      this.nSM = 0;
      this.ga = new TextPaint();
      this.ga.setColor(-65536);
      this.ga.setTextSize(25.0F);
      this.ga.setAntiAlias(true);
      this.nSO = false;
      this.mTimer = new Timer("CloudVoIP_video_info");
      this.text = "debug...";
      this.iDu = new ap();
      if ((this.mTimer != null) && (!this.nSO) && (this.iDu != null)) {
        break;
      }
      AppMethodBeat.o(90948);
      return;
    }
    this.nSO = true;
    paramContext = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(90947);
        s.this.iDu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(90946);
            s.a(s.this);
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
  
  public final void a(a parama)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(90953);
    int j;
    int k;
    try
    {
      if ((!this.jrR) || (!this.mInited)) {
        return;
      }
      if ((this.mVideoWidth != parama.width) || (this.mVideoHeight != parama.height) || (this.mBitmap == null))
      {
        this.mVideoWidth = parama.width;
        this.mVideoHeight = parama.height;
        this.mBitmap = Bitmap.createBitmap(parama.width, parama.height, Bitmap.Config.ARGB_8888);
      }
      localObject2 = parama.nPz;
      j = parama.cJQ;
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
          ad.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "DrawBitmap, bitmap is null or recycled");
        }
        catch (Exception parama)
        {
          ad.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", parama, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
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
        ad.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.mViewId + ", openId:" + this.nQk + ", mId:" + this.nQl);
      }
      this.nSI += 1;
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
      if (this.nSI % 50 == 0)
      {
        this.nSI = 0;
        ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, canvas:[width:" + ((Canvas)localObject1).getWidth() + ", height:" + ((Canvas)localObject1).getHeight() + "], bitmap:[width:" + j + ", height:" + k + "]");
      }
      f1 = ((Canvas)localObject1).getWidth() / k;
      f2 = ((Canvas)localObject1).getHeight() / j;
      if (f1 <= f2) {
        break label700;
      }
    }
    for (;;)
    {
      ((Matrix)localObject2).postTranslate((k - j) / 2, (j - k) / 2);
      ((Matrix)localObject2).postScale(f1, f1);
      ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
      if (!parama.isRecycled()) {
        ((Canvas)localObject1).drawBitmap(parama, (Matrix)localObject2, this.nSL);
      }
      if (this.nSN)
      {
        this.nSM += 1;
        new StaticLayout(this.text, this.ga, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw((Canvas)localObject1);
      }
      unlockCanvasAndPost((Canvas)localObject1);
      break;
      if (i != OpenGlRender.FLAG_Angle90) {
        break label421;
      }
      ((Matrix)localObject2).setRotate(90.0F, j / 2, k / 2);
      break label421;
      label700:
      f1 = f2;
    }
  }
  
  public final void al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90949);
    this.mViewId = paramJSONObject.optInt("viewId");
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:" + this.nQl + ", data:" + paramJSONObject.toString());
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
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:" + this.nQl + ", data:" + paramJSONObject.toString());
    uint();
    al(paramJSONObject);
    AppMethodBeat.o(90950);
  }
  
  public final boolean bOc()
  {
    return false;
  }
  
  public final int getMemberId()
  {
    return this.nQl;
  }
  
  public final String getOpenId()
  {
    return this.nQk;
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
      ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture + ", viewId:" + this.mViewId + ", openId:" + this.nQk + ", mId:" + this.nQl + ", width:" + paramInt1 + ", height:" + paramInt2);
      eTg();
      try
      {
        paramSurfaceTexture = lockCanvas();
        paramSurfaceTexture.drawColor(-16777216);
        unlockCanvasAndPost(paramSurfaceTexture);
        try
        {
          this.jrR = true;
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
          ad.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(90956);
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.nQk + ", mId:" + this.nQl);
    try
    {
      this.jrR = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.iDu != null) {
        this.iDu.removeCallbacksAndMessages(null);
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
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.nQk + ", mId:" + this.nQl + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(90955);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void uint()
  {
    AppMethodBeat.i(90951);
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:" + this.nQl);
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
  
  public final void zy(int paramInt)
  {
    AppMethodBeat.i(90952);
    if (paramInt == this.nQl)
    {
      AppMethodBeat.o(90952);
      return;
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:[" + this.nQl + "->" + paramInt + "]");
    this.nQl = paramInt;
    AppMethodBeat.o(90952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s
 * JD-Core Version:    0.7.0.1
 */