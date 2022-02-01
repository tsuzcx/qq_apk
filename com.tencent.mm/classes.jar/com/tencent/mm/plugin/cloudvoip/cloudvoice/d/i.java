package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONObject;

public final class i
  extends CaptureView
  implements c, f
{
  private int mViewId;
  private int nPO;
  private String nQk;
  private int nQl;
  private h nQm;
  
  public i(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(90808);
    this.mViewId = 0;
    this.nQk = "";
    this.nQl = -1;
    this.nPO = 0;
    this.nQm = new h();
    this.nQl = paramb.nPB;
    this.nQk = paramb.openId;
    AppMethodBeat.o(90808);
  }
  
  public final void a(com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.nPO;
    this.nPO = (i + 1);
    if (i % 50 == 0) {
      ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!o.nQO.nQS.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    paramInt4 = paramInt3 + paramInt4;
    o localo = o.nQO;
    paramInt3 = 0;
    Object localObject1;
    Object localObject2;
    if (localo.nRs)
    {
      if (l.e(o.EMethodGetQosPara, localo.nQj.s2p, localo.nQj.s2p.length) >= 0)
      {
        localObject1 = localo.nQj;
        localObject2 = ByteBuffer.wrap(((a)localObject1).s2p);
        ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN);
        ((a)localObject1).iKbps = ((ByteBuffer)localObject2).getShort();
        ((a)localObject1).cFps = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIPeriod = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cResolution = ((ByteBuffer)localObject2).get();
        ((a)localObject1).nPC = ((ByteBuffer)localObject2).get();
        ((a)localObject1).nPD = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cSkipFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cIReqFlag = ((ByteBuffer)localObject2).get();
        ((a)localObject1).cRsvd1 = ((ByteBuffer)localObject2).get();
        localObject1 = localo.nQj;
        ad.d("OpenVoice[HWEnc]", "raw S2P:" + ((a)localObject1).s2p);
        ad.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + ((a)localObject1).iKbps + ", fps:" + ((a)localObject1).cFps + ", IP:" + ((a)localObject1).cIPeriod + ", Reso:" + ((a)localObject1).cResolution + ", Codec:" + ((a)localObject1).nPC + ", HWEnable:" + ((a)localObject1).nPD + ", Skip:" + ((a)localObject1).cSkipFlag + ", IReq:" + ((a)localObject1).cIReqFlag + ", Rsvd1:" + ((a)localObject1).cRsvd1);
      }
      if (!localo.nRs) {
        break label615;
      }
      if (8 != localo.nQj.nPC) {
        break label606;
      }
      localo.nRt = true;
      if (localo.nQj.nPD == 0)
      {
        localo.nRs = false;
        localo.nRt = false;
      }
      if ((1 != localo.nQj.cSkipFlag) && (localo.nRs) && (localo.nRt)) {
        break label624;
      }
      paramInt3 = -1;
      if (paramInt3 >= 0) {
        break label1011;
      }
    }
    label606:
    label615:
    label624:
    label1011:
    for (paramInt3 = 1;; paramInt3 = 0)
    {
      if (!localo.nRt) {
        break label1017;
      }
      if ((localo.nRr == null) || (paramInt3 != 0)) {
        break label1028;
      }
      paramInt1 = localo.nRr.b(paramArrayOfByte, paramInt1, paramInt2, paramInt4);
      if (paramInt1 < 0)
      {
        ad.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
        localo.nRt = false;
      }
      AppMethodBeat.o(90813);
      return;
      localo.nRt = false;
      break;
      localo.nRt = false;
      break;
      if ((localo.nRs) && (localo.nRr == null)) {
        localo.nRr = new g(localo.nQj.cFps, localo.nQj.iKbps, "video/avc");
      }
      for (;;)
      {
        paramInt3 = 0;
        break;
        localObject1 = localo.nRr;
        localObject2 = localo.nQj;
        if ((((g)localObject1).nQj != null) && (((g)localObject1).nPY != null))
        {
          a locala = ((g)localObject1).nQj;
          locala.iKbps = ((a)localObject2).iKbps;
          locala.cFps = ((a)localObject2).cFps;
          locala.cIPeriod = ((a)localObject2).cIPeriod;
          locala.cResolution = ((a)localObject2).cResolution;
          locala.nPC = ((a)localObject2).nPC;
          locala.nPD = ((a)localObject2).nPD;
          locala.cSkipFlag = ((a)localObject2).cSkipFlag;
          locala.cIReqFlag = ((a)localObject2).cIReqFlag;
          locala.cRsvd1 = ((a)localObject2).cRsvd1;
          paramInt3 = (int)(((g)localObject1).nQj.iKbps * 1.1D);
          if (((g)localObject1).m_br_kbps != paramInt3)
          {
            ((g)localObject1).SetBitRate(paramInt3);
            ad.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + g.frameID + ", new_br: " + ((g)localObject1).m_br_kbps + ", tuneBR:" + paramInt3);
            ((g)localObject1).m_br_kbps = paramInt3;
          }
          if ((1 == ((g)localObject1).nQj.cIReqFlag) && (g.frameID > 0))
          {
            if (((g)localObject1).nPY != null)
            {
              ad.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("request-sync", 0);
              ((g)localObject1).nPY.setParameters((Bundle)localObject2);
            }
            ad.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + g.frameID);
          }
          if (((g)localObject1).nQj.cFps != ((g)localObject1).m_framerate) {
            ((g)localObject1).m_framerate = ((g)localObject1).nQj.cFps;
          }
        }
      }
    }
    label1017:
    l.c(paramArrayOfByte, paramInt1, paramInt2, paramInt4);
    label1028:
    AppMethodBeat.o(90813);
  }
  
  public final void al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90809);
    this.mViewId = paramJSONObject.optInt("viewId");
    boolean bool2 = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(localObject)));
      bool1 = bool2;
      if (((String)localObject).equals("back")) {
        bool1 = false;
      }
    }
    this.nQm.a(this, bool1);
    this.nQm.a(this);
    this.nQm.dWU();
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:" + this.nQl + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:" + this.nQl + ", data:" + paramJSONObject.toString());
    uint();
    al(paramJSONObject);
    AppMethodBeat.o(90810);
  }
  
  public final boolean bOc()
  {
    return true;
  }
  
  public final void bOf() {}
  
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
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:" + this.nQl);
    this.nQm.dWV();
    AppMethodBeat.o(90811);
  }
  
  public final void zy(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.nQl)
    {
      AppMethodBeat.o(90812);
      return;
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.nQk + ", memberId:[" + this.nQl + "->" + paramInt + "]");
    this.nQl = paramInt;
    AppMethodBeat.o(90812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.i
 * JD-Core Version:    0.7.0.1
 */