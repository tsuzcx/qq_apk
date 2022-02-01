package com.tencent.mm.live.core.core.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "", "live_id", "", "role", "", "mode", "timestamps", "netType", "width", "height", "video_fps", "video_gop", "video_bitrate", "audio_bitrate", "net_speed", "video_cache", "audio_cache", "video_sum_cache_size", "audio_video_play_interval", "audio_video_recv_interval", "audio_cache_threshold", "net_jitter", "quality_level", "total_play_time_ms", "total_wait_time_ms", "live_start_play_time_sec", "first_frame_time_ms", "connect_ms", "rtt_ms", "network_id", "cdn_svr_ip", "", "cdn_svr_port", "cpu_usage_process", "", "cpu_usage_device", "upLoss", "downLoss", "sendBytes", "receiveBytes", "(JIIJIIIIIIIIIIIIIIIIJJIIIIILjava/lang/String;IFFIIJJ)V", "getAudio_bitrate", "()I", "setAudio_bitrate", "(I)V", "getAudio_cache", "setAudio_cache", "getAudio_cache_threshold", "setAudio_cache_threshold", "getAudio_video_play_interval", "setAudio_video_play_interval", "getAudio_video_recv_interval", "setAudio_video_recv_interval", "getCdn_svr_ip", "()Ljava/lang/String;", "setCdn_svr_ip", "(Ljava/lang/String;)V", "getCdn_svr_port", "setCdn_svr_port", "getConnect_ms", "setConnect_ms", "getCpu_usage_device", "()F", "setCpu_usage_device", "(F)V", "getCpu_usage_process", "setCpu_usage_process", "getDownLoss", "setDownLoss", "getFirst_frame_time_ms", "setFirst_frame_time_ms", "getHeight", "setHeight", "getLive_id", "()J", "setLive_id", "(J)V", "getLive_start_play_time_sec", "setLive_start_play_time_sec", "getMode", "setMode", "getNetType", "setNetType", "getNet_jitter", "setNet_jitter", "getNet_speed", "setNet_speed", "getNetwork_id", "setNetwork_id", "getQuality_level", "setQuality_level", "getReceiveBytes", "setReceiveBytes", "getRole", "setRole", "getRtt_ms", "setRtt_ms", "getSendBytes", "setSendBytes", "getTimestamps", "setTimestamps", "getTotal_play_time_ms", "setTotal_play_time_ms", "getTotal_wait_time_ms", "setTotal_wait_time_ms", "getUpLoss", "setUpLoss", "getVideo_bitrate", "setVideo_bitrate", "getVideo_cache", "setVideo_cache", "getVideo_fps", "setVideo_fps", "getVideo_gop", "setVideo_gop", "getVideo_sum_cache_size", "setVideo_sum_cache_size", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public int downLoss = 0;
  public int height = 0;
  public long mMJ = 0L;
  public int mMK = 0;
  public int mML = 0;
  public int mMM = 0;
  public int mMN = 0;
  public int mMO = 0;
  public int mMP = 0;
  public int mMQ = 0;
  public int mMR = 0;
  public int mMS = 0;
  public int mMT = 0;
  public int mMU = 0;
  public int mMV = 0;
  public int mMW = 0;
  public long mMX = 0L;
  public long mMY = 0L;
  public int mMZ = 0;
  public int mNa = 0;
  public int mNb = 0;
  public int mNc = 0;
  public int mNd = 0;
  public String mNe = null;
  public int mNf = 0;
  public float mNg = 0.0F;
  public float mNh = 0.0F;
  public int mode = 0;
  public int netType = 0;
  public long receiveBytes = 0L;
  public int role = 0;
  public long sendBytes = 0L;
  public long timestamps = 0L;
  public int upLoss = 0;
  public int width = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247970);
    if (this == paramObject)
    {
      AppMethodBeat.o(247970);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(247970);
      return false;
    }
    paramObject = (e)paramObject;
    if (this.mMJ != paramObject.mMJ)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.role != paramObject.role)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mode != paramObject.mode)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.timestamps != paramObject.timestamps)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.netType != paramObject.netType)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.width != paramObject.width)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.height != paramObject.height)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMK != paramObject.mMK)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mML != paramObject.mML)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMM != paramObject.mMM)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMN != paramObject.mMN)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMO != paramObject.mMO)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMP != paramObject.mMP)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMQ != paramObject.mMQ)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMR != paramObject.mMR)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMS != paramObject.mMS)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMT != paramObject.mMT)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMU != paramObject.mMU)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMV != paramObject.mMV)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMW != paramObject.mMW)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMX != paramObject.mMX)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMY != paramObject.mMY)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mMZ != paramObject.mMZ)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mNa != paramObject.mNa)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mNb != paramObject.mNb)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mNc != paramObject.mNc)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mNd != paramObject.mNd)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (!s.p(this.mNe, paramObject.mNe))
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.mNf != paramObject.mNf)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (!s.p(Float.valueOf(this.mNg), Float.valueOf(paramObject.mNg)))
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (!s.p(Float.valueOf(this.mNh), Float.valueOf(paramObject.mNh)))
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.upLoss != paramObject.upLoss)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.downLoss != paramObject.downLoss)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.sendBytes != paramObject.sendBytes)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    if (this.receiveBytes != paramObject.receiveBytes)
    {
      AppMethodBeat.o(247970);
      return false;
    }
    AppMethodBeat.o(247970);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247962);
    int j = q.a..ExternalSyntheticBackport0.m(this.mMJ);
    int k = this.role;
    int m = this.mode;
    int n = q.a..ExternalSyntheticBackport0.m(this.timestamps);
    int i1 = this.netType;
    int i2 = this.width;
    int i3 = this.height;
    int i4 = this.mMK;
    int i5 = this.mML;
    int i6 = this.mMM;
    int i7 = this.mMN;
    int i8 = this.mMO;
    int i9 = this.mMP;
    int i10 = this.mMQ;
    int i11 = this.mMR;
    int i12 = this.mMS;
    int i13 = this.mMT;
    int i14 = this.mMU;
    int i15 = this.mMV;
    int i16 = this.mMW;
    int i17 = q.a..ExternalSyntheticBackport0.m(this.mMX);
    int i18 = q.a..ExternalSyntheticBackport0.m(this.mMY);
    int i19 = this.mMZ;
    int i20 = this.mNa;
    int i21 = this.mNb;
    int i22 = this.mNc;
    int i23 = this.mNd;
    if (this.mNe == null) {}
    for (int i = 0;; i = this.mNe.hashCode())
    {
      int i24 = this.mNf;
      int i25 = Float.floatToIntBits(this.mNg);
      int i26 = Float.floatToIntBits(this.mNh);
      int i27 = this.upLoss;
      int i28 = this.downLoss;
      int i29 = q.a..ExternalSyntheticBackport0.m(this.sendBytes);
      int i30 = q.a..ExternalSyntheticBackport0.m(this.receiveBytes);
      AppMethodBeat.o(247962);
      return (((((((i + ((((((((((((((((((((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247952);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LiveQosInfo(live_id=").append(this.mMJ).append(", role=").append(this.role).append(", mode=").append(this.mode).append(", timestamps=").append(this.timestamps).append(", netType=").append(this.netType).append(", width=").append(this.width).append(", height=").append(this.height).append(", video_fps=").append(this.mMK).append(", video_gop=").append(this.mML).append(", video_bitrate=").append(this.mMM).append(", audio_bitrate=").append(this.mMN).append(", net_speed=");
    ((StringBuilder)localObject).append(this.mMO).append(", video_cache=").append(this.mMP).append(", audio_cache=").append(this.mMQ).append(", video_sum_cache_size=").append(this.mMR).append(", audio_video_play_interval=").append(this.mMS).append(", audio_video_recv_interval=").append(this.mMT).append(", audio_cache_threshold=").append(this.mMU).append(", net_jitter=").append(this.mMV).append(", quality_level=").append(this.mMW).append(", total_play_time_ms=").append(this.mMX).append(", total_wait_time_ms=").append(this.mMY).append(", live_start_play_time_sec=").append(this.mMZ);
    ((StringBuilder)localObject).append(", first_frame_time_ms=").append(this.mNa).append(", connect_ms=").append(this.mNb).append(", rtt_ms=").append(this.mNc).append(", network_id=").append(this.mNd).append(", cdn_svr_ip=").append(this.mNe).append(", cdn_svr_port=").append(this.mNf).append(", cpu_usage_process=").append(this.mNg).append(", cpu_usage_device=").append(this.mNh).append(", upLoss=").append(this.upLoss).append(", downLoss=").append(this.downLoss).append(", sendBytes=").append(this.sendBytes).append(", receiveBytes=");
    ((StringBuilder)localObject).append(this.receiveBytes).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(247952);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.e
 * JD-Core Version:    0.7.0.1
 */