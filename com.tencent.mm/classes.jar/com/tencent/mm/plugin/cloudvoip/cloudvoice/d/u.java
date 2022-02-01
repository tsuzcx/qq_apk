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
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c, d
{
  private int Go;
  private TextPaint bzo;
  private Bitmap mBitmap;
  private boolean mInited;
  private Timer mTimer;
  private int mVideoHeight;
  private int mVideoWidth;
  protected MMHandler ntw;
  private boolean oou;
  private String tQX;
  private int tQY;
  private int tRA;
  private int tRB;
  private int tUd;
  private Paint tUe;
  private int tUf;
  private int tUg;
  private int tUh;
  private boolean tUi;
  private boolean tUj;
  private boolean tUk;
  private boolean tUl;
  private boolean tUm;
  private boolean tUn;
  private String text;
  
  public u(Context paramContext, b paramb, JSONObject paramJSONObject)
  {
    super(paramContext);
    AppMethodBeat.i(90948);
    this.Go = 0;
    this.tUd = 0;
    this.tUe = null;
    this.tQX = "";
    this.tQY = -1;
    this.mBitmap = null;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.oou = false;
    this.mInited = false;
    this.tRA = 0;
    this.tRB = 0;
    this.bzo = null;
    this.text = "";
    this.tUi = false;
    this.tUj = false;
    this.tUk = true;
    this.tUl = false;
    this.tUm = false;
    this.tUn = true;
    this.tQY = paramb.tQm;
    this.tQX = paramb.openId;
    this.tUe = new Paint();
    this.tUe.setColor(-16777216);
    this.tUe.setFilterBitmap(false);
    setSurfaceTextureListener(this);
    aL(paramJSONObject);
    this.tUi = paramJSONObject.optBoolean("debug", false);
    if ((this.tUi) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      this.tUi = bool;
      if (!this.tUi) {
        break label350;
      }
      this.tUh = 0;
      this.bzo = new TextPaint();
      this.bzo.setColor(-65536);
      this.bzo.setTextSize(25.0F);
      this.bzo.setAntiAlias(true);
      this.tUj = false;
      this.mTimer = new Timer("CloudVoIP_video_info");
      this.text = "debug...";
      this.ntw = new MMHandler();
      if ((this.mTimer != null) && (!this.tUj) && (this.ntw != null)) {
        break;
      }
      AppMethodBeat.o(90948);
      return;
    }
    this.tUj = true;
    paramContext = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(90947);
        u.this.ntw.post(new Runnable()
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
    label350:
    AppMethodBeat.o(90948);
  }
  
  private void cNN()
  {
    AppMethodBeat.i(203837);
    cNO();
    try
    {
      this.oou = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(203837);
    }
  }
  
  private void cNO()
  {
    AppMethodBeat.i(203840);
    try
    {
      Canvas localCanvas = lockCanvas();
      localCanvas.drawColor(-16777216);
      unlockCanvasAndPost(localCanvas);
      AppMethodBeat.o(203840);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", localException, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
      AppMethodBeat.o(203840);
    }
  }
  
  private static int k(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void Iz(int paramInt)
  {
    AppMethodBeat.i(90952);
    if (paramInt == this.tQY)
    {
      AppMethodBeat.o(90952);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:[" + this.tQY + "->" + paramInt + "]");
    this.tQY = paramInt;
    AppMethodBeat.o(90952);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(90953);
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((!this.oou) || (!this.mInited)) {
          return;
        }
        if ((this.mVideoWidth != parama.width) || (this.mVideoHeight != parama.height) || (this.mBitmap == null))
        {
          this.mVideoWidth = parama.width;
          this.mVideoHeight = parama.height;
          this.mBitmap = Bitmap.createBitmap(parama.width, parama.height, Bitmap.Config.ARGB_8888);
        }
        localObject2 = parama.tQj;
        i = parama.faO;
        if (i == 0)
        {
          parama = null;
          this.mBitmap.setPixels(parama, 0, this.mVideoWidth, 0, 0, this.mVideoWidth, this.mVideoHeight);
          parama = this.mBitmap;
          i = OpenGlRender.FLAG_Angle90;
          if (parama == null) {}
        }
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
        if (this.tUn)
        {
          this.tUn = false;
          parama = new HashMap();
        }
      }
      finally
      {
        AppMethodBeat.o(90953);
      }
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("openId", this.tQX);
        if (!this.tUl) {
          break label912;
        }
        ((JSONObject)localObject1).put("type", "video");
        parama.put("code", Integer.valueOf(1001));
        parama.put("data", localObject1);
      }
      catch (JSONException localJSONException)
      {
        float f1;
        float f2;
        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", localJSONException, "", new Object[0]);
        continue;
      }
      Object localObject1 = q.tRM;
      ((q)localObject1).am(new q.16((q)localObject1, parama));
      AppMethodBeat.o(90953);
      return;
      int j = i / 4;
      localObject1 = new int[j];
      int i = 0;
      parama = (a)localObject1;
      if (i < j)
      {
        localObject1[i] = (k(localObject2[(i * 4)]) | k(localObject2[(i * 4 + 1)]) << 8 | k(localObject2[(i * 4 + 2)]) << 16 | k(localObject2[(i * 4 + 3)]) << 24);
        i += 1;
        continue;
        j = parama.getWidth();
        int k = parama.getHeight();
        localObject1 = lockCanvas(null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.Go + ", openId:" + this.tQX + ", mId:" + this.tQY);
        }
        else
        {
          this.tUd += 1;
          localObject2 = new Matrix();
          if (i == OpenGlRender.FLAG_Angle270)
          {
            ((Matrix)localObject2).setRotate(270.0F, j / 2, k / 2);
            label531:
            if (OpenGlRender.FLAG_Mirror == 0)
            {
              ((Matrix)localObject2).postScale(-1.0F, 1.0F);
              ((Matrix)localObject2).postTranslate(j, 0.0F);
            }
            if (this.tUd % 50 == 0)
            {
              this.tUd = 0;
              Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, canvas:[width:" + ((Canvas)localObject1).getWidth() + ", height:" + ((Canvas)localObject1).getHeight() + "], bitmap:[width:" + j + ", height:" + k + "]");
            }
            f1 = ((Canvas)localObject1).getWidth() / k;
            f2 = ((Canvas)localObject1).getHeight() / j;
            if (f1 <= f2) {
              break label904;
            }
            label668:
            ((Matrix)localObject2).postTranslate((k - j) / 2, (j - k) / 2);
            f2 = j * ((Canvas)localObject1).getWidth() / ((Canvas)localObject1).getHeight();
            f2 = -(k - f2) / 2.0F;
            if (f2 <= 0.0001D) {
              break label909;
            }
            f2 = 0.0F;
          }
          label904:
          label909:
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
              ((Canvas)localObject1).drawBitmap(parama, (Matrix)localObject2, this.tUe);
            }
            if (this.tUi)
            {
              this.tUh += 1;
              new StaticLayout(this.text, this.bzo, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw((Canvas)localObject1);
            }
            unlockCanvasAndPost((Canvas)localObject1);
            break;
            if (i != OpenGlRender.FLAG_Angle90) {
              break label531;
            }
            ((Matrix)localObject2).setRotate(90.0F, j / 2, k / 2);
            break label531;
            f1 = f2;
            break label668;
          }
          label912:
          if (this.tUm) {
            ((JSONObject)localObject1).put("type", "screen");
          }
        }
      }
    }
  }
  
  public final void aK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90949);
    this.Go = paramJSONObject.optInt("viewId");
    String str;
    if (paramJSONObject.optString("objectFit", "fill").equals("fill"))
    {
      this.tUk = true;
      str = paramJSONObject.optString("type", "camera");
      if (!str.equals("video")) {
        break label155;
      }
      this.tUl = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY + ", data:" + paramJSONObject.toString());
      try
      {
        this.mInited = true;
        return;
      }
      finally
      {
        AppMethodBeat.o(90949);
      }
      this.tUk = false;
      break;
      label155:
      if (str.equals("screen")) {
        this.tUm = true;
      }
    }
  }
  
  public final void aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90950);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY + ", data:" + paramJSONObject.toString());
    uint();
    aK(paramJSONObject);
    AppMethodBeat.o(90950);
  }
  
  public final boolean cNt()
  {
    return false;
  }
  
  public final boolean cNu()
  {
    return this.tUl;
  }
  
  public final boolean cNv()
  {
    return this.tUm;
  }
  
  public final void fN(int paramInt1, int paramInt2)
  {
    this.tUf = paramInt1;
    this.tUg = paramInt2;
  }
  
  public final void fO(int paramInt1, int paramInt2)
  {
    this.tRA = paramInt1;
    this.tRB = paramInt2;
  }
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(203850);
    if (this.tRB > 0)
    {
      i = this.tRB;
      AppMethodBeat.o(203850);
      return i;
    }
    int i = g.Dh(getHeight());
    AppMethodBeat.o(203850);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(203847);
    if (this.tRA > 0)
    {
      i = this.tRA;
      AppMethodBeat.o(203847);
      return i;
    }
    int i = g.Dh(getWidth());
    AppMethodBeat.o(203847);
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
  
  public final int getSameLayerSurfaceHeight()
  {
    return this.tUg;
  }
  
  public final int getSameLayerSurfaceWidth()
  {
    return this.tUf;
  }
  
  public final int getViewId()
  {
    return this.Go;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90954);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {}
    for (paramSurfaceTexture = "isNull";; paramSurfaceTexture = "nonNull")
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture + ", viewId:" + this.Go + ", openId:" + this.tQX + ", mId:" + this.tQY + ", width:" + paramInt1 + ", height:" + paramInt2 + ", size: [" + getWidth() + "," + getHeight() + "]");
      hKg();
      cNN();
      AppMethodBeat.o(90954);
      return;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(90956);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.Go + ", openId:" + this.tQX + ", mId:" + this.tQY);
    try
    {
      this.oou = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.ntw != null) {
        this.ntw.removeCallbacksAndMessages(null);
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
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.Go + ", openId:" + this.tQX + ", mId:" + this.tQY + ", width:" + paramInt1 + ", height:" + paramInt2 + ", size: [" + getWidth() + "," + getHeight() + "]");
    AppMethodBeat.o(90955);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(203828);
    super.setSurfaceTexture(paramSurfaceTexture);
    cNN();
    AppMethodBeat.o(203828);
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90951);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY);
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