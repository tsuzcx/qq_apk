package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

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
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Timer;
import org.json.JSONObject;

public final class s
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c
{
  private TextPaint eLQ;
  private boolean htQ;
  protected ak iMP;
  private String kKj;
  private int kKk;
  private Paint kMA;
  private int kMB;
  private boolean kMC;
  private boolean kMD;
  private int kMx;
  private Bitmap mBitmap;
  private boolean mInited;
  private Timer mTimer;
  private int mVideoHeight;
  private int mVideoWidth;
  private int mViewId;
  private String text;
  
  public s(Context paramContext, b paramb, JSONObject paramJSONObject)
  {
    super(paramContext);
    AppMethodBeat.i(145875);
    this.mViewId = 0;
    this.kMx = 0;
    this.kMA = null;
    this.kKj = "";
    this.kKk = -1;
    this.mBitmap = null;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.htQ = false;
    this.mInited = false;
    this.eLQ = null;
    this.text = "";
    this.kMC = false;
    this.kMD = false;
    this.kKk = paramb.kJx;
    this.kKj = paramb.openId;
    this.kMA = new Paint();
    this.kMA.setColor(-16777216);
    this.kMA.setFilterBitmap(false);
    setSurfaceTextureListener(this);
    this.kMC = paramJSONObject.optBoolean("debug", false);
    if (this.kMC)
    {
      this.kMB = 0;
      this.eLQ = new TextPaint();
      this.eLQ.setColor(-65536);
      this.eLQ.setTextSize(25.0F);
      this.eLQ.setAntiAlias(true);
      this.kMD = false;
      this.mTimer = new Timer("CloudVoIP_video_info");
      this.text = "debug...";
      this.iMP = new ak();
      if ((this.mTimer == null) || (this.kMD) || (this.iMP == null))
      {
        AppMethodBeat.o(145875);
        return;
      }
      this.kMD = true;
      paramContext = new s.1(this);
      this.mTimer.schedule(paramContext, 1000L, 1000L);
    }
    AppMethodBeat.o(145875);
  }
  
  private static int c(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145876);
    this.mViewId = paramJSONObject.optInt("viewId");
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:" + this.kKk + ", data:" + paramJSONObject.toString());
    try
    {
      this.mInited = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(145876);
    }
  }
  
  public final void W(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145877);
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:" + this.kKk + ", data:" + paramJSONObject.toString());
    uint();
    V(paramJSONObject);
    AppMethodBeat.o(145877);
  }
  
  public final void a(a parama)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(145880);
    int j;
    int k;
    try
    {
      if ((!this.htQ) || (!this.mInited)) {
        return;
      }
      if ((this.mVideoWidth != parama.width) || (this.mVideoHeight != parama.height) || (this.mBitmap == null))
      {
        this.mVideoWidth = parama.width;
        this.mVideoHeight = parama.height;
        this.mBitmap = Bitmap.createBitmap(parama.width, parama.height, Bitmap.Config.ARGB_8888);
      }
      localObject2 = parama.kJv;
      j = parama.bWt;
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
          ab.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "DrawBitmap, bitmap is null or recycled");
        }
        catch (Exception parama)
        {
          ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", parama, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
          continue;
        }
        return;
        j /= 4;
        localObject1 = new int[j];
        parama = (a)localObject1;
        if (i >= j) {
          break;
        }
        localObject1[i] = (c(localObject2[(i * 4)]) | c(localObject2[(i * 4 + 1)]) << 8 | c(localObject2[(i * 4 + 2)]) << 16 | c(localObject2[(i * 4 + 3)]) << 24);
        i += 1;
        continue;
        j = parama.getWidth();
        k = parama.getHeight();
        localObject1 = lockCanvas(null);
        if (localObject1 != null) {
          break label376;
        }
        ab.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.mViewId + ", openId:" + this.kKj + ", mId:" + this.kKk);
      }
      this.kMx += 1;
    }
    finally
    {
      AppMethodBeat.o(145880);
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
      if (this.kMx % 50 == 0)
      {
        this.kMx = 0;
        ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, canvas:[width:" + ((Canvas)localObject1).getWidth() + ", height:" + ((Canvas)localObject1).getHeight() + "], bitmap:[width:" + j + ", height:" + k + "]");
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
        ((Canvas)localObject1).drawBitmap(parama, (Matrix)localObject2, this.kMA);
      }
      if (this.kMC)
      {
        this.kMB += 1;
        new StaticLayout(this.text, this.eLQ, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw((Canvas)localObject1);
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
  
  public final boolean bhl()
  {
    return false;
  }
  
  public final int getMemberId()
  {
    return this.kKk;
  }
  
  public final String getOpenId()
  {
    return this.kKj;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145881);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {
      paramSurfaceTexture = "isNull";
    }
    for (;;)
    {
      ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture + ", viewId:" + this.mViewId + ", openId:" + this.kKj + ", mId:" + this.kKk + ", width:" + paramInt1 + ", height:" + paramInt2);
      dEs();
      try
      {
        paramSurfaceTexture = lockCanvas();
        paramSurfaceTexture.drawColor(-16777216);
        unlockCanvasAndPost(paramSurfaceTexture);
        try
        {
          this.htQ = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(145881);
        }
        paramSurfaceTexture = "nonNull";
      }
      catch (Exception paramSurfaceTexture)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(145883);
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.kKj + ", mId:" + this.kKk);
    try
    {
      this.htQ = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.iMP != null) {
        this.iMP.removeCallbacksAndMessages(null);
      }
      AppMethodBeat.o(145883);
      return false;
    }
    finally
    {
      AppMethodBeat.o(145883);
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145882);
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.kKj + ", mId:" + this.kKk + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(145882);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void tG(int paramInt)
  {
    AppMethodBeat.i(145879);
    if (paramInt == this.kKk)
    {
      AppMethodBeat.o(145879);
      return;
    }
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:[" + this.kKk + "->" + paramInt + "]");
    this.kKk = paramInt;
    AppMethodBeat.o(145879);
  }
  
  public final void uint()
  {
    AppMethodBeat.i(145878);
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:" + this.kKk);
    try
    {
      this.mInited = false;
      return;
    }
    finally
    {
      AppMethodBeat.o(145878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.s
 * JD-Core Version:    0.7.0.1
 */