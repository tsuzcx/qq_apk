package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

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
import com.tencent.mm.plugin.appbrand.af.i;
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
  private int bms;
  private TextPaint dso;
  private Bitmap mBitmap;
  private boolean mInited;
  private Timer mTimer;
  private int mVideoHeight;
  private int mVideoWidth;
  protected MMHandler qse;
  private boolean rse;
  private String text;
  private int wUQ;
  private int wUR;
  private String wUn;
  private int wUo;
  private boolean wXA;
  private boolean wXB;
  private boolean wXC;
  private boolean wXD;
  private int wXt;
  private Paint wXu;
  private int wXv;
  private int wXw;
  private int wXx;
  private boolean wXy;
  private boolean wXz;
  
  public u(Context paramContext, b paramb, JSONObject paramJSONObject)
  {
    super(paramContext);
    AppMethodBeat.i(90948);
    this.bms = 0;
    this.wXt = 0;
    this.wXu = null;
    this.wUn = "";
    this.wUo = -1;
    this.mBitmap = null;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.rse = false;
    this.mInited = false;
    this.wUQ = 0;
    this.wUR = 0;
    this.dso = null;
    this.text = "";
    this.wXy = false;
    this.wXz = false;
    this.wXA = true;
    this.wXB = false;
    this.wXC = false;
    this.wXD = true;
    this.wUo = paramb.wTC;
    this.wUn = paramb.openId;
    this.wXu = new Paint();
    this.wXu.setColor(-16777216);
    this.wXu.setFilterBitmap(false);
    setSurfaceTextureListener(this);
    aW(paramJSONObject);
    this.wXy = paramJSONObject.optBoolean("debug", false);
    if ((this.wXy) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool = true;; bool = false)
    {
      this.wXy = bool;
      if (!this.wXy) {
        break label350;
      }
      this.wXx = 0;
      this.dso = new TextPaint();
      this.dso.setColor(-65536);
      this.dso.setTextSize(25.0F);
      this.dso.setAntiAlias(true);
      this.wXz = false;
      this.mTimer = new Timer("CloudVoIP_video_info");
      this.text = "debug...";
      this.qse = new MMHandler();
      if ((this.mTimer != null) && (!this.wXz) && (this.qse != null)) {
        break;
      }
      AppMethodBeat.o(90948);
      return;
    }
    this.wXz = true;
    paramContext = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(90947);
        u.this.qse.post(new Runnable()
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
  
  private void drr()
  {
    AppMethodBeat.i(268288);
    drs();
    try
    {
      this.rse = true;
      return;
    }
    finally
    {
      AppMethodBeat.o(268288);
    }
  }
  
  private void drs()
  {
    AppMethodBeat.i(268290);
    try
    {
      Canvas localCanvas = lockCanvas();
      localCanvas.drawColor(-16777216);
      unlockCanvasAndPost(localCanvas);
      AppMethodBeat.o(268290);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", localException, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
      AppMethodBeat.o(268290);
    }
  }
  
  private static int m(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void Jc(int paramInt)
  {
    AppMethodBeat.i(90952);
    if (paramInt == this.wUo)
    {
      AppMethodBeat.o(90952);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:[" + this.wUo + "->" + paramInt + "]");
    this.wUo = paramInt;
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
        if ((!this.rse) || (!this.mInited)) {
          return;
        }
        if ((this.mVideoWidth != parama.width) || (this.mVideoHeight != parama.height) || (this.mBitmap == null))
        {
          this.mVideoWidth = parama.width;
          this.mVideoHeight = parama.height;
          this.mBitmap = Bitmap.createBitmap(parama.width, parama.height, Bitmap.Config.ARGB_8888);
        }
        localObject2 = parama.wTz;
        i = parama.heo;
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
        if (this.wXD)
        {
          this.wXD = false;
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
        ((JSONObject)localObject1).put("openId", this.wUn);
        if (!this.wXB) {
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
      Object localObject1 = q.wVc;
      ((q)localObject1).au(new q.16((q)localObject1, parama));
      AppMethodBeat.o(90953);
      return;
      int j = i / 4;
      localObject1 = new int[j];
      int i = 0;
      parama = (a)localObject1;
      if (i < j)
      {
        localObject1[i] = (m(localObject2[(i * 4)]) | m(localObject2[(i * 4 + 1)]) << 8 | m(localObject2[(i * 4 + 2)]) << 16 | m(localObject2[(i * 4 + 3)]) << 24);
        i += 1;
        continue;
        j = parama.getWidth();
        int k = parama.getHeight();
        localObject1 = lockCanvas(null);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.bms + ", openId:" + this.wUn + ", mId:" + this.wUo);
        }
        else
        {
          this.wXt += 1;
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
            if (this.wXt % 50 == 0)
            {
              this.wXt = 0;
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
              ((Canvas)localObject1).drawBitmap(parama, (Matrix)localObject2, this.wXu);
            }
            if (this.wXy)
            {
              this.wXx += 1;
              new StaticLayout(this.text, this.dso, 300, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).draw((Canvas)localObject1);
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
          if (this.wXC) {
            ((JSONObject)localObject1).put("type", "screen");
          }
        }
      }
    }
  }
  
  public final void aV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90949);
    this.bms = paramJSONObject.optInt("viewId");
    String str;
    if (paramJSONObject.optString("objectFit", "fill").equals("fill"))
    {
      this.wXA = true;
      str = paramJSONObject.optString("type", "camera");
      if (!str.equals("video")) {
        break label155;
      }
      this.wXB = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:" + this.wUo + ", data:" + paramJSONObject.toString());
      try
      {
        this.mInited = true;
        return;
      }
      finally
      {
        AppMethodBeat.o(90949);
      }
      this.wXA = false;
      break;
      label155:
      if (str.equals("screen")) {
        this.wXC = true;
      }
    }
  }
  
  public final void aW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90950);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:" + this.wUo + ", data:" + paramJSONObject.toString());
    uint();
    aV(paramJSONObject);
    AppMethodBeat.o(90950);
  }
  
  public final boolean dqZ()
  {
    return false;
  }
  
  public final boolean dra()
  {
    return this.wXB;
  }
  
  public final boolean drb()
  {
    return this.wXC;
  }
  
  public final void gE(int paramInt1, int paramInt2)
  {
    this.wXv = paramInt1;
    this.wXw = paramInt2;
  }
  
  public final void gF(int paramInt1, int paramInt2)
  {
    this.wUQ = paramInt1;
    this.wUR = paramInt2;
  }
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(268367);
    if (this.wUR > 0)
    {
      i = this.wUR;
      AppMethodBeat.o(268367);
      return i;
    }
    int i = i.DB(getHeight());
    AppMethodBeat.o(268367);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(268363);
    if (this.wUQ > 0)
    {
      i = this.wUQ;
      AppMethodBeat.o(268363);
      return i;
    }
    int i = i.DB(getWidth());
    AppMethodBeat.o(268363);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.wUo;
  }
  
  public final String getOpenId()
  {
    return this.wUn;
  }
  
  public final int getSameLayerSurfaceHeight()
  {
    return this.wXw;
  }
  
  public final int getSameLayerSurfaceWidth()
  {
    return this.wXv;
  }
  
  public final int getViewId()
  {
    return this.bms;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90954);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {}
    for (paramSurfaceTexture = "isNull";; paramSurfaceTexture = "nonNull")
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", paramSurfaceTexture + ", viewId:" + this.bms + ", openId:" + this.wUn + ", mId:" + this.wUo + ", width:" + paramInt1 + ", height:" + paramInt2 + ", size: [" + getWidth() + "," + getHeight() + "]");
      jmM();
      drr();
      AppMethodBeat.o(90954);
      return;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(90956);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.bms + ", openId:" + this.wUn + ", mId:" + this.wUo);
    try
    {
      this.rse = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.qse != null) {
        this.qse.removeCallbacksAndMessages(null);
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
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.bms + ", openId:" + this.wUn + ", mId:" + this.wUo + ", width:" + paramInt1 + ", height:" + paramInt2 + ", size: [" + getWidth() + "," + getHeight() + "]");
    AppMethodBeat.o(90955);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(268340);
    super.setSurfaceTexture(paramSurfaceTexture);
    drr();
    AppMethodBeat.o(268340);
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90951);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:" + this.wUo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.u
 * JD-Core Version:    0.7.0.1
 */