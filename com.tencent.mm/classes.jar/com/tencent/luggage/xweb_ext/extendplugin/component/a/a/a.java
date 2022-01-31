package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.luggage.g.g;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
{
  b bFV;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.c bFW;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b bFX;
  public com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.a bFY;
  private com.tencent.luggage.xweb_ext.extendplugin.a bFZ;
  private a.a bGa;
  private int bGb;
  private int bGc;
  private boolean bGd;
  boolean bGe;
  boolean bGf;
  private Surface mSurface;
  private SurfaceTexture mSurfaceTexture;
  
  public a()
  {
    AppMethodBeat.i(139761);
    com.tencent.luggage.xweb_ext.extendplugin.component.a.b.xn();
    this.bFV = new b(ah.getContext());
    this.bFV.bGl = new a.1(this);
    AppMethodBeat.o(139761);
  }
  
  private void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139765);
    if (paramJSONObject.has("needEvent"))
    {
      this.bGd = paramJSONObject.optBoolean("needEvent", false);
      if (xt()) {
        this.bFX.d(parama);
      }
    }
    AppMethodBeat.o(139765);
  }
  
  private void fy(int paramInt)
  {
    AppMethodBeat.i(154392);
    if (this.bFW != null) {
      this.bFW.at(paramInt);
    }
    AppMethodBeat.o(154392);
  }
  
  private void i(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139766);
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        this.bGb = paramJSONObject.optInt("width", 0);
        this.bGc = paramJSONObject.optInt("height", 0);
        ab.i(xo(), "parseHtmlPosition, size:[%d, %d]", new Object[] { Integer.valueOf(this.bGb), Integer.valueOf(this.bGc) });
        xr();
      }
    }
    AppMethodBeat.o(139766);
  }
  
  private void mw()
  {
    AppMethodBeat.i(154391);
    if (this.mSurface != null)
    {
      this.mSurface.release();
      this.mSurface = null;
    }
    AppMethodBeat.o(154391);
  }
  
  private void xr()
  {
    AppMethodBeat.i(139767);
    if ((this.bGb != 0) && (this.bGc != 0) && (this.mSurfaceTexture != null) && (this.bFV != null))
    {
      ab.i(xo(), "adjustHtmlSize, size:[%d, %d]", new Object[] { Integer.valueOf(this.bGb), Integer.valueOf(this.bGc) });
      this.mSurfaceTexture.setDefaultBufferSize(this.bGb, this.bGc);
      this.bFV.bE(this.bGb, this.bGc);
    }
    AppMethodBeat.o(139767);
  }
  
  private void xs()
  {
    AppMethodBeat.i(154390);
    if (this.bFZ != null)
    {
      this.bFZ.xm();
      this.bGa = null;
    }
    AppMethodBeat.o(154390);
  }
  
  public final String a(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139764);
    Object localObject1 = parama.xl();
    if (bo.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(139764);
      return null;
    }
    Object localObject2 = parama.xk();
    ab.i(xo(), "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { tX(), localObject1, ((JSONObject)localObject2).toString() });
    int i;
    Object localObject3;
    if (((String)localObject1).contains("insert"))
    {
      fy(1);
      localObject1 = parama.xk();
      if (((JSONObject)localObject1).optInt("mode", 0) == 2)
      {
        localObject2 = parama.getContext();
        if ((localObject2 instanceof Activity)) {
          break label756;
        }
        ab.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, pageContext not activity");
        parama.ck("fail:internal error invalid android context");
        i = 0;
        if (i == 0) {}
      }
      else
      {
        TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parama.getAppId() }));
        this.bFZ = parama;
        this.bGa = new a.2(this);
        parama.a(this.bGa);
        a(parama, (JSONObject)localObject1);
        i((JSONObject)localObject1);
        this.bGe = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
        this.bGf = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("playUrl", ((JSONObject)localObject1).optString("playUrl"));
        ((Bundle)localObject2).putInt("mode", ((JSONObject)localObject1).optInt("mode", 0));
        ((Bundle)localObject2).putBoolean("autoplay", ((JSONObject)localObject1).optBoolean("autoplay", false));
        ((Bundle)localObject2).putBoolean("muted", ((JSONObject)localObject1).optBoolean("muted", false));
        ((Bundle)localObject2).putString("orientation", ((JSONObject)localObject1).optString("orientation"));
        ((Bundle)localObject2).putString("objectFit", ((JSONObject)localObject1).optString("objectFit"));
        ((Bundle)localObject2).putBoolean("backgroundMute", ((JSONObject)localObject1).optBoolean("backgroundMute", true));
        ((Bundle)localObject2).putFloat("minCache", BigDecimal.valueOf(((JSONObject)localObject1).optDouble("minCache", 1.0D)).floatValue());
        ((Bundle)localObject2).putFloat("maxCache", BigDecimal.valueOf(((JSONObject)localObject1).optDouble("maxCache", 3.0D)).floatValue());
        ((Bundle)localObject2).putBoolean("needEvent", ((JSONObject)localObject1).optBoolean("needEvent", false));
        ((Bundle)localObject2).putBoolean("debug", ((JSONObject)localObject1).optBoolean("debug", false));
        ((Bundle)localObject2).putString("soundMode", ((JSONObject)localObject1).optString("soundMode", "speaker"));
        ((Bundle)localObject2).putBoolean("autoPauseIfNavigate", ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true));
        ((Bundle)localObject2).putBoolean("autoPauseIfOpenNative", ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true));
        localObject1 = this.bFV;
        if (((b)localObject1).bGl != null)
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
          ((Bundle)localObject3).putLong("EVT_TIME", System.currentTimeMillis());
          ((b)localObject1).bGl.onPlayEvent(-9999999, (Bundle)localObject3);
        }
        b.k("initLivePlayer", (Bundle)localObject2);
        ((b)localObject1).bGi = null;
        ((b)localObject1).bGn = ((Bundle)localObject2).getString("playUrl", ((b)localObject1).bGn);
        ((b)localObject1).bGo = ((b)localObject1).l((Bundle)localObject2);
        ((b)localObject1).m((Bundle)localObject2);
        ((b)localObject1).mAutoPlay = ((Bundle)localObject2).getBoolean("autoplay", ((b)localObject1).mAutoPlay);
        if ((((b)localObject1).mAutoPlay) && (((b)localObject1).bGn != null) && (!((b)localObject1).bGn.isEmpty()))
        {
          ab.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
          ((b)localObject1).cm(((b)localObject1).bGn);
          ((b)localObject1).bGk.startPlay(((b)localObject1).bGn, ((b)localObject1).bGo);
        }
        ((b)localObject1).mInited = true;
        localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
        ab.i(xo(), "insert, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).bFT });
        if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0) {
          break label826;
        }
        localObject1 = "ok";
        label740:
        parama.ck((String)localObject1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(139764);
      return null;
      label756:
      if (g.o((Activity)localObject2, "android.permission.RECORD_AUDIO"))
      {
        i = 1;
        break;
      }
      localObject2 = new HashMap();
      ((Map)localObject2).put("errCode", Integer.valueOf(10001));
      ab.w("MicroMsg.SameLayer.LivePlayerPluginHandler", "checkPermission, permission denied");
      parama.d("fail:system permission denied", (Map)localObject2);
      i = 0;
      break;
      label826:
      localObject1 = "fail";
      break label740;
      label954:
      boolean bool;
      if (((String)localObject1).contains("update"))
      {
        fy(2);
        localObject1 = parama.xk();
        if (((JSONObject)localObject1).has("autoPauseIfNavigate")) {
          this.bGe = ((JSONObject)localObject1).optBoolean("autoPauseIfNavigate", true);
        }
        if (((JSONObject)localObject1).has("autoPauseIfOpenNative")) {
          this.bGf = ((JSONObject)localObject1).optBoolean("autoPauseIfOpenNative", true);
        }
        a(parama, (JSONObject)localObject1);
        i((JSONObject)localObject1);
        localObject1 = com.tencent.luggage.xweb_ext.extendplugin.component.a.c.g((JSONObject)localObject1);
        localObject2 = this.bFV;
        if (!((b)localObject2).mInited)
        {
          localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a(-3, "uninited livePlayer");
          ab.i(xo(), "update, code:%d info:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode), ((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).bFT });
          if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0) {
            break label1342;
          }
        }
        label1342:
        for (localObject1 = "ok";; localObject1 = "fail")
        {
          parama.ck((String)localObject1);
          break;
          b.k("updateLivePlayer", (Bundle)localObject1);
          ((b)localObject2).m((Bundle)localObject1);
          bool = ((b)localObject2).bGk.isPlaying();
          localObject3 = ((Bundle)localObject1).getString("playUrl", ((b)localObject2).bGn);
          if ((localObject3 != null) && (!((String)localObject3).isEmpty()) && (((b)localObject2).bGn != null) && (!((b)localObject2).bGn.equalsIgnoreCase((String)localObject3)) && (((b)localObject2).bGk.isPlaying()))
          {
            ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + ((b)localObject2).bGn + " playUrl-new = " + (String)localObject3);
            ((b)localObject2).bGk.stopPlay(true);
          }
          ((b)localObject2).bGn = ((String)localObject3);
          i = ((b)localObject2).l((Bundle)localObject1);
          if ((i != ((b)localObject2).bGo) && (((b)localObject2).bGk.isPlaying()))
          {
            ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + ((b)localObject2).bGo + " playType-new = " + i);
            ((b)localObject2).bGk.stopPlay(true);
          }
          ((b)localObject2).bGo = i;
          ((b)localObject2).mAutoPlay = ((Bundle)localObject1).getBoolean("autoplay", ((b)localObject2).mAutoPlay);
          if (((((b)localObject2).mAutoPlay) || (bool)) && (((b)localObject2).bGn != null) && (!((b)localObject2).bGn.isEmpty()) && (!((b)localObject2).bGk.isPlaying()))
          {
            ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
            ((b)localObject2).cm(((b)localObject2).bGn);
            ((b)localObject2).bGk.startPlay(((b)localObject2).bGn, ((b)localObject2).bGo);
          }
          localObject1 = new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
          break label954;
        }
      }
      if (((String)localObject1).contains("operate"))
      {
        fy(3);
        localObject1 = parama.xk().optString("type");
        ab.i(xo(), "operate, type:%s", new Object[] { localObject1 });
        if ((!bo.isNullOrNil((String)localObject1)) && (this.bFV != null))
        {
          if (((String)localObject1).equals("snapshot"))
          {
            this.bFV.bGm = new a.3(this, parama);
            localObject1 = this.bFV.cl("snapshot");
            if (((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode != 0)
            {
              ab.i(xo(), "operateSnapshot, fail:%s", new Object[] { Integer.valueOf(((com.tencent.luggage.xweb_ext.extendplugin.component.a.a)localObject1).errorCode) });
              parama.ck("fail:snapshot error");
            }
            else
            {
              ab.i(xo(), "operateSnapshot, success");
            }
          }
          else
          {
            if (((String)localObject1).equalsIgnoreCase("requestFullScreen"))
            {
              if ((this.bFY != null) && (this.bFY.b(parama)))
              {
                bool = true;
                label1545:
                ab.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateRequestFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                if (!bool) {
                  break label1590;
                }
              }
              label1590:
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                parama.ck((String)localObject1);
                break;
                bool = false;
                break label1545;
              }
            }
            if (((String)localObject1).equalsIgnoreCase("exitFullScreen"))
            {
              if ((this.bFY != null) && (this.bFY.c(parama)))
              {
                bool = true;
                label1631:
                ab.i("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateExitFullscreen, result:%s", new Object[] { Boolean.valueOf(bool) });
                if (!bool) {
                  break label1676;
                }
              }
              label1676:
              for (localObject1 = "ok";; localObject1 = "fail")
              {
                parama.ck((String)localObject1);
                break;
                bool = false;
                break label1631;
              }
            }
            if (this.bFV.cl((String)localObject1).errorCode == 0) {}
            for (localObject1 = "ok";; localObject1 = "fail")
            {
              parama.ck((String)localObject1);
              break;
            }
          }
        }
        else {
          parama.ck("fail");
        }
      }
      else if (((String)localObject1).contains("remove"))
      {
        fy(4);
        release();
        parama.ck("ok");
      }
    }
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139762);
    super.d(paramSurfaceTexture);
    ab.i(xo(), "*** handler(%s) handlePluginReady", new Object[] { tX() });
    this.mSurfaceTexture = paramSurfaceTexture;
    this.mSurface = new Surface(paramSurfaceTexture);
    if (this.bFV != null)
    {
      paramSurfaceTexture = this.bFV;
      Surface localSurface = this.mSurface;
      paramSurfaceTexture.mSurface = localSurface;
      paramSurfaceTexture.bGk.setSurface(localSurface);
      new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
      xr();
    }
    AppMethodBeat.o(139762);
  }
  
  final void release()
  {
    AppMethodBeat.i(139768);
    if (this.bFV != null)
    {
      this.bFV.xu();
      this.bFV = null;
    }
    mw();
    xs();
    AppMethodBeat.o(139768);
  }
  
  final String xo()
  {
    AppMethodBeat.i(139760);
    String str = String.format("%s(%s)", new Object[] { "MicroMsg.SameLayer.LivePlayerPluginHandler", tX() });
    AppMethodBeat.o(139760);
    return str;
  }
  
  public final boolean xp()
  {
    return true;
  }
  
  public final void xq()
  {
    AppMethodBeat.i(139763);
    super.xq();
    ab.i(xo(), "*** handler(%s) handlePluginDestroy", new Object[] { tX() });
    AppMethodBeat.o(139763);
  }
  
  final boolean xt()
  {
    return this.bFX != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a
 * JD-Core Version:    0.7.0.1
 */