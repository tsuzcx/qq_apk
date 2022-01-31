package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public final class i
  extends CaptureView
  implements c, f
{
  private int kJK;
  private String kKj;
  private int kKk;
  private h kKl;
  private int mViewId;
  
  public i(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(145851);
    this.mViewId = 0;
    this.kKj = "";
    this.kKk = -1;
    this.kJK = 0;
    this.kKl = new h();
    this.kKk = paramb.kJx;
    this.kKj = paramb.openId;
    AppMethodBeat.o(145851);
  }
  
  public final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145852);
    this.mViewId = paramJSONObject.optInt("viewId");
    boolean bool2 = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ab.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(localObject)));
      bool1 = bool2;
      if (((String)localObject).equals("back")) {
        bool1 = false;
      }
    }
    this.kKl.a(this, bool1);
    this.kKl.a(this);
    this.kKl.cPz();
    ab.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:" + this.kKk + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(145852);
  }
  
  public final void W(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145853);
    ab.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:" + this.kKk + ", data:" + paramJSONObject.toString());
    uint();
    V(paramJSONObject);
    AppMethodBeat.o(145853);
  }
  
  public final void a(com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(145856);
    int i = this.kJK;
    this.kJK = (i + 1);
    if (i % 50 == 0) {
      ab.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!o.kKN.kKR.isStarted())
    {
      AppMethodBeat.o(145856);
      return;
    }
    paramInt4 = paramInt3 + paramInt4;
    o localo = o.kKN;
    paramInt3 = 0;
    Object localObject1;
    Object localObject2;
    if (localo.kLn)
    {
      if (l.e(o.EMethodGetQosPara, localo.kKi.s2p, localo.kKi.s2p.length) >= 0)
      {
        localObject1 = localo.kKi;
        localObject2 = ByteBuffer.wrap(((a)localObject1).s2p);
        ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject1).iKbps = ((ByteBuffer)localObject2).getShort();
        ((a)localObject1).cFps = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIPeriod = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cResolution = ((ByteBuffer)localObject2).get();
        ((a)localObject1).kJy = ((ByteBuffer)localObject2).get();
        ((a)localObject1).kJz = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cSkipFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIReqFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cRsvd1 = ((ByteBuffer)localObject2).get();
        localObject1 = localo.kKi;
        ab.d("OpenVoice[HWEnc]", "raw S2P:" + ((a)localObject1).s2p);
        ab.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + ((a)localObject1).iKbps + ", fps:" + ((a)localObject1).cFps + ", IP:" + ((a)localObject1).cIPeriod + ", Reso:" + ((a)localObject1).cResolution + ", Codec:" + ((a)localObject1).kJy + ", HWEnable:" + ((a)localObject1).kJz + ", Skip:" + ((a)localObject1).cSkipFlag + ", IReq:" + ((a)localObject1).cIReqFlag + ", Rsvd1:" + ((a)localObject1).cRsvd1);
      }
      if (!localo.kLn) {
        break label629;
      }
      if (8 != localo.kKi.kJy) {
        break label620;
      }
      localo.kLo = true;
      if (localo.kKi.kJz != 0) {
        break label638;
      }
      localo.kLn = false;
      localo.kLo = false;
      label509:
      if ((1 != localo.kKi.cSkipFlag) && (localo.kLn) && (localo.kLo)) {
        break label708;
      }
      paramInt3 = -1;
      if (paramInt3 >= 0) {
        break label1099;
      }
    }
    label708:
    label1099:
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      if (!localo.kLo) {
        break label1105;
      }
      if ((localo.kLm == null) || (paramInt3 != 0)) {
        break label1116;
      }
      paramInt1 = localo.kLm.b(paramArrayOfByte, paramInt1, paramInt2, paramInt4);
      if (paramInt1 < 0)
      {
        ab.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
        localo.kLo = false;
      }
      AppMethodBeat.o(145856);
      return;
      label620:
      localo.kLo = false;
      break;
      label629:
      localo.kLo = false;
      break;
      label638:
      if ((localo.kKi.iKbps != 0) && (localo.kKi.cFps != 0)) {
        break label509;
      }
      localo.kLo = true;
      localo.kKi.cSkipFlag = 0;
      localo.kKi.cResolution = 4;
      localo.kKi.iKbps = 300;
      localo.kKi.cFps = 15;
      break label509;
      if ((localo.kLn) && (localo.kLm == null)) {
        localo.kLm = new g(localo.kKi.cFps, localo.kKi.iKbps, "video/avc");
      }
      for (;;)
      {
        paramInt3 = 0;
        break;
        localObject1 = localo.kLm;
        localObject2 = localo.kKi;
        if ((((g)localObject1).kKi != null) && (((g)localObject1).mediaCodec != null))
        {
          a locala = ((g)localObject1).kKi;
          locala.iKbps = ((a)localObject2).iKbps;
          locala.cFps = ((a)localObject2).cFps;
          locala.cIPeriod = ((a)localObject2).cIPeriod;
          locala.cResolution = ((a)localObject2).cResolution;
          locala.kJy = ((a)localObject2).kJy;
          locala.kJz = ((a)localObject2).kJz;
          locala.cSkipFlag = ((a)localObject2).cSkipFlag;
          locala.cIReqFlag = ((a)localObject2).cIReqFlag;
          locala.cRsvd1 = ((a)localObject2).cRsvd1;
          paramInt3 = (int)(((g)localObject1).kKi.iKbps * 1.1D);
          if (((g)localObject1).m_br_kbps != paramInt3)
          {
            ((g)localObject1).SetBitRate(paramInt3);
            ab.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + g.frameID + ", new_br: " + ((g)localObject1).m_br_kbps + ", tuneBR:" + paramInt3);
            ((g)localObject1).m_br_kbps = paramInt3;
          }
          if ((1 == ((g)localObject1).kKi.cIReqFlag) && (g.frameID > 0))
          {
            if (((g)localObject1).mediaCodec != null)
            {
              ab.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("request-sync", 0);
              ((g)localObject1).mediaCodec.setParameters((Bundle)localObject2);
            }
            ab.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + g.frameID);
          }
          if (((g)localObject1).kKi.cFps != ((g)localObject1).m_framerate) {
            ((g)localObject1).m_framerate = ((g)localObject1).kKi.cFps;
          }
        }
      }
    }
    label1105:
    l.c(paramArrayOfByte, paramInt1, paramInt2, paramInt4);
    label1116:
    AppMethodBeat.o(145856);
  }
  
  public final boolean bhl()
  {
    return true;
  }
  
  public final void bho() {}
  
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
  
  public final void tG(int paramInt)
  {
    AppMethodBeat.i(145855);
    if (paramInt == this.kKk)
    {
      AppMethodBeat.o(145855);
      return;
    }
    ab.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:[" + this.kKk + "->" + paramInt + "]");
    this.kKk = paramInt;
    AppMethodBeat.o(145855);
  }
  
  public final void uint()
  {
    AppMethodBeat.i(145854);
    ab.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.kKj + ", memberId:" + this.kKk);
    this.kKl.cPA();
    AppMethodBeat.o(145854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.i
 * JD-Core Version:    0.7.0.1
 */