package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "", "live_id", "", "role", "", "mode", "timestamps", "netType", "width", "height", "video_fps", "video_gop", "video_bitrate", "audio_bitrate", "net_speed", "video_cache", "audio_cache", "video_sum_cache_size", "audio_video_play_interval", "audio_video_recv_interval", "audio_cache_threshold", "net_jitter", "quality_level", "total_play_time_ms", "total_wait_time_ms", "live_start_play_time_sec", "first_frame_time_ms", "connect_ms", "rtt_ms", "network_id", "cdn_svr_ip", "", "cdn_svr_port", "cpu_usage_process", "", "cpu_usage_device", "upLoss", "downLoss", "sendBytes", "receiveBytes", "(JIIJIIIIIIIIIIIIIIIIJJIIIIILjava/lang/String;IFFIIJJ)V", "getAudio_bitrate", "()I", "setAudio_bitrate", "(I)V", "getAudio_cache", "setAudio_cache", "getAudio_cache_threshold", "setAudio_cache_threshold", "getAudio_video_play_interval", "setAudio_video_play_interval", "getAudio_video_recv_interval", "setAudio_video_recv_interval", "getCdn_svr_ip", "()Ljava/lang/String;", "setCdn_svr_ip", "(Ljava/lang/String;)V", "getCdn_svr_port", "setCdn_svr_port", "getConnect_ms", "setConnect_ms", "getCpu_usage_device", "()F", "setCpu_usage_device", "(F)V", "getCpu_usage_process", "setCpu_usage_process", "getDownLoss", "setDownLoss", "getFirst_frame_time_ms", "setFirst_frame_time_ms", "getHeight", "setHeight", "getLive_id", "()J", "setLive_id", "(J)V", "getLive_start_play_time_sec", "setLive_start_play_time_sec", "getMode", "setMode", "getNetType", "setNetType", "getNet_jitter", "setNet_jitter", "getNet_speed", "setNet_speed", "getNetwork_id", "setNetwork_id", "getQuality_level", "setQuality_level", "getReceiveBytes", "setReceiveBytes", "getRole", "setRole", "getRtt_ms", "setRtt_ms", "getSendBytes", "setSendBytes", "getTimestamps", "setTimestamps", "getTotal_play_time_ms", "setTotal_play_time_ms", "getTotal_wait_time_ms", "setTotal_wait_time_ms", "getUpLoss", "setUpLoss", "getVideo_bitrate", "setVideo_bitrate", "getVideo_cache", "setVideo_cache", "getVideo_fps", "setVideo_fps", "getVideo_gop", "setVideo_gop", "getVideo_sum_cache_size", "setVideo_sum_cache_size", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
public final class c
{
  public int downLoss = 0;
  public int height = 0;
  public long hyH = 0L;
  public int hyI = 0;
  public int hyJ = 0;
  public int hyK = 0;
  public int hyL = 0;
  public int hyM = 0;
  public int hyN = 0;
  public int hyO = 0;
  public int hyP = 0;
  public int hyQ = 0;
  public int hyR = 0;
  public int hyS = 0;
  public int hyT = 0;
  public int hyU = 0;
  public long hyV = 0L;
  public long hyW = 0L;
  public int hyX = 0;
  public int hyY = 0;
  public int hyZ = 0;
  public int hza = 0;
  public int hzb = 0;
  public String hzc = null;
  public int hzd = 0;
  public float hze = 0.0F;
  public float hzf = 0.0F;
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
    AppMethodBeat.i(196453);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.hyH != paramObject.hyH) || (this.role != paramObject.role) || (this.mode != paramObject.mode) || (this.timestamps != paramObject.timestamps) || (this.netType != paramObject.netType) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.hyI != paramObject.hyI) || (this.hyJ != paramObject.hyJ) || (this.hyK != paramObject.hyK) || (this.hyL != paramObject.hyL) || (this.hyM != paramObject.hyM) || (this.hyN != paramObject.hyN) || (this.hyO != paramObject.hyO) || (this.hyP != paramObject.hyP) || (this.hyQ != paramObject.hyQ) || (this.hyR != paramObject.hyR) || (this.hyS != paramObject.hyS) || (this.hyT != paramObject.hyT) || (this.hyU != paramObject.hyU) || (this.hyV != paramObject.hyV) || (this.hyW != paramObject.hyW) || (this.hyX != paramObject.hyX) || (this.hyY != paramObject.hyY) || (this.hyZ != paramObject.hyZ) || (this.hza != paramObject.hza) || (this.hzb != paramObject.hzb) || (!p.j(this.hzc, paramObject.hzc)) || (this.hzd != paramObject.hzd) || (Float.compare(this.hze, paramObject.hze) != 0) || (Float.compare(this.hzf, paramObject.hzf) != 0) || (this.upLoss != paramObject.upLoss) || (this.downLoss != paramObject.downLoss) || (this.sendBytes != paramObject.sendBytes) || (this.receiveBytes != paramObject.receiveBytes)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196453);
      return true;
    }
    AppMethodBeat.o(196453);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196452);
    long l = this.hyH;
    int j = (int)(l ^ l >>> 32);
    int k = this.role;
    int m = this.mode;
    l = this.timestamps;
    int n = (int)(l ^ l >>> 32);
    int i1 = this.netType;
    int i2 = this.width;
    int i3 = this.height;
    int i4 = this.hyI;
    int i5 = this.hyJ;
    int i6 = this.hyK;
    int i7 = this.hyL;
    int i8 = this.hyM;
    int i9 = this.hyN;
    int i10 = this.hyO;
    int i11 = this.hyP;
    int i12 = this.hyQ;
    int i13 = this.hyR;
    int i14 = this.hyS;
    int i15 = this.hyT;
    int i16 = this.hyU;
    l = this.hyV;
    int i17 = (int)(l ^ l >>> 32);
    l = this.hyW;
    int i18 = (int)(l ^ l >>> 32);
    int i19 = this.hyX;
    int i20 = this.hyY;
    int i21 = this.hyZ;
    int i22 = this.hza;
    int i23 = this.hzb;
    String str = this.hzc;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int i24 = this.hzd;
      int i25 = Float.floatToIntBits(this.hze);
      int i26 = Float.floatToIntBits(this.hzf);
      int i27 = this.upLoss;
      int i28 = this.downLoss;
      l = this.sendBytes;
      int i29 = (int)(l ^ l >>> 32);
      l = this.receiveBytes;
      int i30 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(196452);
      return (((((((i + ((((((((((((((((((((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196451);
    String str = "LiveQosInfo(live_id=" + this.hyH + ", role=" + this.role + ", mode=" + this.mode + ", timestamps=" + this.timestamps + ", netType=" + this.netType + ", width=" + this.width + ", height=" + this.height + ", video_fps=" + this.hyI + ", video_gop=" + this.hyJ + ", video_bitrate=" + this.hyK + ", audio_bitrate=" + this.hyL + ", net_speed=" + this.hyM + ", video_cache=" + this.hyN + ", audio_cache=" + this.hyO + ", video_sum_cache_size=" + this.hyP + ", audio_video_play_interval=" + this.hyQ + ", audio_video_recv_interval=" + this.hyR + ", audio_cache_threshold=" + this.hyS + ", net_jitter=" + this.hyT + ", quality_level=" + this.hyU + ", total_play_time_ms=" + this.hyV + ", total_wait_time_ms=" + this.hyW + ", live_start_play_time_sec=" + this.hyX + ", first_frame_time_ms=" + this.hyY + ", connect_ms=" + this.hyZ + ", rtt_ms=" + this.hza + ", network_id=" + this.hzb + ", cdn_svr_ip=" + this.hzc + ", cdn_svr_port=" + this.hzd + ", cpu_usage_process=" + this.hze + ", cpu_usage_device=" + this.hzf + ", upLoss=" + this.upLoss + ", downLoss=" + this.downLoss + ", sendBytes=" + this.sendBytes + ", receiveBytes=" + this.receiveBytes + ")";
    AppMethodBeat.o(196451);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.c
 * JD-Core Version:    0.7.0.1
 */