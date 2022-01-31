package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.e.e
{
  g gHA;
  f gHB;
  h gHC;
  private e gHD;
  boolean gHE;
  boolean gHF;
  boolean gHG;
  boolean gHH;
  boolean gHI;
  private boolean gHJ;
  private boolean gHK;
  private int gHL;
  private int gHM;
  int gHN = 0;
  private String gHO;
  boolean gHP = false;
  com.tencent.mm.plugin.appbrand.jsapi.u.a.b.c gHr;
  private Surface mSurface;
  private String oep;
  
  public c()
  {
    cVm();
    this.gHr = new com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a();
    this.gHr.setOnInfoListener(new c.1(this));
    this.gHr.setOnErrorListener(new c.2(this));
    this.gHr.setOnPreparedListener(new c.3(this));
    this.gHr.setOnCompletionListener(new c.4(this));
    this.gHr.setOnSeekCompleteListener(new c.5(this));
    this.gHr.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.alu();
        if ((c.this.alv()) && (c.this.gHE)) {
          c.this.gHA.z(paramAnonymousInt1, paramAnonymousInt2, c.this.gHr.getDuration());
        }
      }
    });
    this.gHr.setOnBufferingUpdateListener(new c.7(this));
    this.gHD = new e();
    this.gHC = new d();
    this.gHB = new a(this.gHr, new c.8(this), this);
  }
  
  private void cVm()
  {
    this.gHG = false;
    this.gHH = false;
    this.gHI = false;
    this.gHJ = false;
  }
  
  private static String l(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    if ((!bk.bl(paramString)) && (paramc != null) && (paramc.Zl() != null) && (paramc.Zl().bs(paramString)))
    {
      paramc = paramc.Zl().rx(paramString);
      if (paramc != null) {}
    }
    else
    {
      return paramString;
    }
    return "file://" + paramc.getAbsolutePath();
  }
  
  private boolean pause()
  {
    if (this.gHr != null)
    {
      if (!this.gHr.isPlaying()) {
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "pause, video is not playing");
      }
      do
      {
        return true;
        this.gHr.pause();
      } while (!alv());
      this.gHA.onVideoPause();
      return true;
    }
    return false;
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, i parami)
  {
    boolean bool = true;
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler handleJsApi(%s), data:%s", new Object[] { parami.getName(), paramJSONObject.toString() });
    int i;
    Object localObject;
    if ((parami instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b))
    {
      this.gHF = paramJSONObject.optBoolean("autoplay", false);
      this.gHr.dv(this.gHF);
      i = paramJSONObject.optInt("initialTime", 0);
      this.gHr.lM(i * 1000);
      this.gHP = paramJSONObject.optBoolean("loop", false);
      this.gHr.setLooping(this.gHP);
      bool = paramJSONObject.optBoolean("muted", false);
      this.gHr.setMute(bool);
      this.gHK = paramJSONObject.optBoolean("needEvent", false);
      if (this.gHK)
      {
        this.gHA = new b(this.gHr, paramc);
        localObject = paramJSONObject.optString("data", "");
        this.gHA.uP((String)localObject);
      }
      for (;;)
      {
        if (paramJSONObject.has("position"))
        {
          localObject = paramJSONObject.optJSONObject("position");
          if (localObject != null)
          {
            this.gHL = ((JSONObject)localObject).optInt("width", 0);
            this.gHM = ((JSONObject)localObject).optInt("height", 0);
            y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, position:[%d, %d]", new Object[] { Integer.valueOf(this.gHL), Integer.valueOf(this.gHM) });
          }
        }
        this.gHO = paramJSONObject.optString("objectFit", "contain");
        if (bk.bl(this.gHO)) {
          this.gHO = "contain";
        }
        alu();
        this.oep = paramJSONObject.optString("filePath");
        this.oep = l(paramc, this.oep);
        if (!bk.bl(this.oep))
        {
          y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler insert, path:%s", new Object[] { this.oep });
          this.gHr.setDataSource(this.oep);
          this.gHr.prepareAsync();
          if (alv()) {
            this.gHA.onVideoWaiting();
          }
        }
        paramc = "ok";
        return parami.h(paramc, null);
        this.gHA = null;
      }
    }
    if ((parami instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.e))
    {
      if (paramJSONObject.has("autoplay"))
      {
        this.gHF = paramJSONObject.optBoolean("autoplay", false);
        this.gHr.dv(this.gHF);
      }
      if (paramJSONObject.has("initialTime"))
      {
        i = paramJSONObject.optInt("initialTime", 0);
        this.gHr.lM(i * 1000);
      }
      if (paramJSONObject.has("loop"))
      {
        this.gHP = paramJSONObject.optBoolean("loop", false);
        this.gHr.setLooping(this.gHP);
      }
      if (paramJSONObject.has("muted"))
      {
        bool = paramJSONObject.optBoolean("muted", false);
        this.gHr.setMute(bool);
      }
      if (paramJSONObject.has("needEvent"))
      {
        this.gHK = paramJSONObject.optBoolean("needEvent", false);
        if (!this.gHK) {
          break label859;
        }
        this.gHA = new b(this.gHr, paramc);
        if (paramJSONObject.has("data"))
        {
          localObject = paramJSONObject.optString("data", "");
          this.gHA.uP((String)localObject);
        }
      }
      for (;;)
      {
        if (paramJSONObject.has("position"))
        {
          localObject = paramJSONObject.optJSONObject("position");
          if (localObject != null)
          {
            this.gHL = ((JSONObject)localObject).optInt("width", 0);
            this.gHM = ((JSONObject)localObject).optInt("height", 0);
            y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, position:[%d, %d]", new Object[] { Integer.valueOf(this.gHL), Integer.valueOf(this.gHM) });
          }
          alu();
        }
        if (paramJSONObject.has("objectFit"))
        {
          this.gHO = paramJSONObject.optString("objectFit", "contain");
          if (bk.bl(this.gHO)) {
            this.gHO = "contain";
          }
          alu();
        }
        if (paramJSONObject.has("filePath"))
        {
          this.oep = paramJSONObject.optString("filePath");
          this.oep = l(paramc, this.oep);
          if (!bk.bl(this.oep))
          {
            y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler update, path:%s", new Object[] { this.oep });
            this.gHr.setDataSource(this.oep);
            this.gHr.prepareAsync();
            if (alv()) {
              this.gHA.onVideoWaiting();
            }
          }
        }
        paramc = "ok";
        break;
        label859:
        this.gHK = false;
        this.gHA = null;
      }
    }
    if ((parami instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.c))
    {
      paramc = paramJSONObject.optString("type");
      if (bk.bl(paramc)) {
        break label1357;
      }
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler operate, type:%s", new Object[] { paramc });
      if (paramc.equalsIgnoreCase("play")) {
        bool = play();
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramc = "ok";
        break;
        if (paramc.equalsIgnoreCase("pause"))
        {
          bool = pause();
          continue;
        }
        if (paramc.equalsIgnoreCase("stop"))
        {
          bool = un();
          continue;
        }
        if (paramc.equalsIgnoreCase("seek"))
        {
          if ((this.gHr != null) && (paramJSONObject != null) && (paramJSONObject.has("data")))
          {
            paramc = paramJSONObject.optJSONArray("data");
            if ((paramc != null) && (paramc.length() != 0)) {
              break label1040;
            }
            y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, data array is null");
          }
          for (;;)
          {
            bool = false;
            break;
            label1040:
            i = paramc.optInt(0, -1);
            if (i >= 0) {
              break label1076;
            }
            y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, invalid position:%d", new Object[] { Integer.valueOf(i) });
          }
          label1076:
          y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler seek, position:%d", new Object[] { Integer.valueOf(i) });
          this.gHH = this.gHr.isPlaying();
          seek(i * 1000);
          continue;
        }
        if (!paramc.equalsIgnoreCase("playbackRate")) {
          break label1357;
        }
        if ((this.gHr != null) && (paramJSONObject != null) && (paramJSONObject.has("data")))
        {
          paramc = paramJSONObject.optJSONArray("data");
          if ((paramc != null) && (paramc.length() != 0)) {
            break label1186;
          }
          y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, data array is null");
        }
        label1186:
        double d;
        for (;;)
        {
          bool = false;
          break;
          d = paramc.optDouble(0, -1.0D);
          if (d >= 0.0D) {
            break label1226;
          }
          y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, invalid rate:%s", new Object[] { Double.valueOf(d) });
        }
        label1226:
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler speed, speed:%s", new Object[] { Double.valueOf(d) });
        this.gHr.ak((float)d);
        continue;
      }
      paramc = "fail";
      break;
      if ((parami instanceof com.tencent.mm.plugin.appbrand.jsapi.u.a.a.d))
      {
        if (this.gHr != null)
        {
          this.gHr.release();
          if (alv()) {
            this.gHA.alt();
          }
        }
        if (this.gHB != null) {
          this.gHB.destroy();
        }
        if (this.mSurface != null)
        {
          this.mSurface.release();
          this.mSurface = null;
        }
        paramc = "ok";
        break;
      }
      paramc = "ok";
      break;
      label1357:
      bool = false;
    }
  }
  
  final void alu()
  {
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    int k;
    int m;
    if ((!bk.bl(this.gHO)) && (this.gHE) && (this.gHr != null) && (afI() != null))
    {
      localObject1 = this.gHD;
      localObject2 = this.gHO;
      i = this.gHL;
      j = this.gHM;
      k = this.gHr.getVideoWidth();
      m = this.gHr.getVideoHeight();
      if (!bk.bl((String)localObject2)) {
        break label247;
      }
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "adjust objectFit:%s, scale:[%s, %s]", new Object[] { this.gHO, Float.valueOf(this.gHD.gHW), Float.valueOf(this.gHD.gHX) });
        localObject1 = afI();
        localObject2 = getType();
        i = getId();
        f1 = this.gHD.gHW;
        f2 = this.gHD.gHX;
        if ((localObject1 != null) && (((com.tencent.luggage.m.a.a)localObject1).qz() != null))
        {
          y.i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { localObject2, Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
          ((com.tencent.luggage.m.a.a)localObject1).qz().setPluginTextureScale((String)localObject2, i, f1, f2);
        }
      }
      return;
      label247:
      if ((i == 0) || (j == 0) || (k == 0) || (m == 0))
      {
        y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
        i = 0;
      }
      else
      {
        if ((!((String)localObject2).equalsIgnoreCase(((e)localObject1).gHV)) || (((e)localObject1).gHR != i) || (((e)localObject1).gHS != j) || (((e)localObject1).videoWidth != k) || (((e)localObject1).videoHeight != m)) {
          break;
        }
        y.w("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
        i = 1;
      }
    }
    ((e)localObject1).gHV = ((String)localObject2);
    ((e)localObject1).gHR = i;
    ((e)localObject1).gHS = j;
    ((e)localObject1).videoWidth = k;
    ((e)localObject1).videoHeight = m;
    float f1 = ((e)localObject1).videoWidth * 1.0F / ((e)localObject1).videoHeight;
    float f2 = ((e)localObject1).gHR * 1.0F / ((e)localObject1).gHS;
    if (((e)localObject1).gHV.equalsIgnoreCase("contain")) {
      if (((e)localObject1).gHR < ((e)localObject1).gHS)
      {
        ((e)localObject1).gHU = ((int)(((e)localObject1).gHR / f1));
        ((e)localObject1).gHT = ((e)localObject1).gHR;
        if (((e)localObject1).gHU <= ((e)localObject1).gHS) {}
      }
    }
    label476:
    label1006:
    for (;;)
    {
      localObject2 = localObject1;
      ((e)localObject2).gHT = ((int)(f1 * ((e)localObject2).gHS));
      ((e)localObject2).gHU = ((e)localObject2).gHS;
      for (;;)
      {
        ((e)localObject1).gHW = (((e)localObject1).gHT * 1.0F / ((e)localObject1).gHR);
        ((e)localObject1).gHX = (((e)localObject1).gHU * 1.0F / ((e)localObject1).gHS);
        y.d("MicroMsg.AppBrand.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(((e)localObject1).gHR), Integer.valueOf(((e)localObject1).gHS), Integer.valueOf(((e)localObject1).videoWidth), Integer.valueOf(((e)localObject1).videoHeight), Integer.valueOf(((e)localObject1).gHT), Integer.valueOf(((e)localObject1).gHU), Float.valueOf(((e)localObject1).gHW), Float.valueOf(((e)localObject1).gHX) });
        i = 1;
        break;
        ((e)localObject1).gHT = ((int)(((e)localObject1).gHS * f1));
        ((e)localObject1).gHU = ((e)localObject1).gHS;
        if (((e)localObject1).gHT > ((e)localObject1).gHR)
        {
          ((e)localObject1).gHU = ((int)(((e)localObject1).gHR / f1));
          ((e)localObject1).gHT = ((e)localObject1).gHR;
          continue;
          if (((e)localObject1).gHV.equalsIgnoreCase("fill"))
          {
            ((e)localObject1).gHU = ((e)localObject1).gHS;
            ((e)localObject1).gHT = ((e)localObject1).gHR;
          }
          else
          {
            if (((e)localObject1).gHV.equalsIgnoreCase("cover"))
            {
              if (((e)localObject1).gHR > ((e)localObject1).gHS)
              {
                ((e)localObject1).gHU = ((int)(((e)localObject1).gHR / f1));
                ((e)localObject1).gHT = ((e)localObject1).gHR;
                if (((e)localObject1).gHU >= ((e)localObject1).gHS) {
                  continue;
                }
                break label476;
              }
              ((e)localObject1).gHT = ((int)(((e)localObject1).gHS * f1));
              ((e)localObject1).gHU = ((e)localObject1).gHS;
              if (((e)localObject1).gHT >= ((e)localObject1).gHR) {
                continue;
              }
              ((e)localObject1).gHU = ((int)(((e)localObject1).gHR / f1));
              ((e)localObject1).gHT = ((e)localObject1).gHR;
              continue;
            }
            if (Math.abs(f1 - f2) > 0.05D)
            {
              if (((e)localObject1).gHR < ((e)localObject1).gHS)
              {
                ((e)localObject1).gHU = ((int)(((e)localObject1).gHR / f1));
                ((e)localObject1).gHT = ((e)localObject1).gHR;
              }
              else
              {
                ((e)localObject1).gHT = ((int)(f1 * ((e)localObject1).gHS));
                ((e)localObject1).gHU = ((e)localObject1).gHS;
              }
            }
            else
            {
              if (((e)localObject1).gHR <= ((e)localObject1).gHS) {
                break label1006;
              }
              ((e)localObject1).gHU = ((int)(((e)localObject1).gHR / f1));
              ((e)localObject1).gHT = ((e)localObject1).gHR;
            }
          }
        }
      }
    }
  }
  
  final boolean alv()
  {
    return (this.gHK) && (this.gHA != null);
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture)
  {
    super.d(paramSurfaceTexture);
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler handlePluginReady");
    cVm();
    this.mSurface = new Surface(paramSurfaceTexture);
    if (this.gHr != null) {
      this.gHr.setSurface(this.mSurface);
    }
  }
  
  final boolean play()
  {
    if (this.gHr != null)
    {
      if (this.gHr.isPlaying()) {
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "play, video is playing");
      }
      do
      {
        return true;
        if (!this.gHE)
        {
          y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "play, video not prepared yet, start until prepared");
          this.gHF = true;
          this.gHr.dv(true);
          return true;
        }
        if (this.gHr.getState() == 5)
        {
          y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "play, video has stopped now, try prepare and start");
          this.gHr.prepare();
        }
        this.gHr.start();
      } while (!alv());
      this.gHA.onVideoPlay();
      return true;
    }
    return false;
  }
  
  public final void qB()
  {
    super.qB();
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler handlePluginDestroy");
    if (this.gHr != null) {
      this.gHr.pause();
    }
  }
  
  public final void qC()
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler handlePluginForeground");
    if ((this.gHr != null) && (this.gHJ))
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handlePluginForeground, video playing when enter background");
      this.gHJ = false;
      play();
    }
  }
  
  public final void qD()
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "*** handler handlePluginBackground");
    if (this.gHr != null)
    {
      this.gHJ = this.gHr.isPlaying();
      pause();
    }
  }
  
  public final void seek(int paramInt)
  {
    if (this.gHA != null) {
      this.gHA.onVideoWaiting();
    }
    this.gHr.seekTo(paramInt);
  }
  
  public final boolean un()
  {
    if (this.gHr != null)
    {
      this.gHr.stop();
      if (alv()) {
        this.gHA.onVideoPause();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c
 * JD-Core Version:    0.7.0.1
 */