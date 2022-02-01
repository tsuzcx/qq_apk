package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "", "live_id", "", "role", "", "mode", "timestamps", "netType", "width", "height", "video_fps", "video_gop", "video_bitrate", "audio_bitrate", "net_speed", "video_cache", "audio_cache", "video_sum_cache_size", "audio_video_play_interval", "audio_video_recv_interval", "audio_cache_threshold", "net_jitter", "quality_level", "total_play_time_ms", "total_wait_time_ms", "live_start_play_time_sec", "first_frame_time_ms", "connect_ms", "rtt_ms", "network_id", "cdn_svr_ip", "", "cdn_svr_port", "cpu_usage_process", "", "cpu_usage_device", "upLoss", "downLoss", "sendBytes", "receiveBytes", "(JIIJIIIIIIIIIIIIIIIIJJIIIIILjava/lang/String;IFFIIJJ)V", "getAudio_bitrate", "()I", "setAudio_bitrate", "(I)V", "getAudio_cache", "setAudio_cache", "getAudio_cache_threshold", "setAudio_cache_threshold", "getAudio_video_play_interval", "setAudio_video_play_interval", "getAudio_video_recv_interval", "setAudio_video_recv_interval", "getCdn_svr_ip", "()Ljava/lang/String;", "setCdn_svr_ip", "(Ljava/lang/String;)V", "getCdn_svr_port", "setCdn_svr_port", "getConnect_ms", "setConnect_ms", "getCpu_usage_device", "()F", "setCpu_usage_device", "(F)V", "getCpu_usage_process", "setCpu_usage_process", "getDownLoss", "setDownLoss", "getFirst_frame_time_ms", "setFirst_frame_time_ms", "getHeight", "setHeight", "getLive_id", "()J", "setLive_id", "(J)V", "getLive_start_play_time_sec", "setLive_start_play_time_sec", "getMode", "setMode", "getNetType", "setNetType", "getNet_jitter", "setNet_jitter", "getNet_speed", "setNet_speed", "getNetwork_id", "setNetwork_id", "getQuality_level", "setQuality_level", "getReceiveBytes", "setReceiveBytes", "getRole", "setRole", "getRtt_ms", "setRtt_ms", "getSendBytes", "setSendBytes", "getTimestamps", "setTimestamps", "getTotal_play_time_ms", "setTotal_play_time_ms", "getTotal_wait_time_ms", "setTotal_wait_time_ms", "getUpLoss", "setUpLoss", "getVideo_bitrate", "setVideo_bitrate", "getVideo_cache", "setVideo_cache", "getVideo_fps", "setVideo_fps", "getVideo_gop", "setVideo_gop", "getVideo_sum_cache_size", "setVideo_sum_cache_size", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
public final class d
{
  public int downLoss = 0;
  public int height = 0;
  public long klE = 0L;
  public int klF = 0;
  public int klG = 0;
  public int klH = 0;
  public int klI = 0;
  public int klJ = 0;
  public int klK = 0;
  public int klL = 0;
  public int klM = 0;
  public int klN = 0;
  public int klO = 0;
  public int klP = 0;
  public int klQ = 0;
  public int klR = 0;
  public long klS = 0L;
  public long klT = 0L;
  public int klU = 0;
  public int klV = 0;
  public int klW = 0;
  public int klX = 0;
  public int klY = 0;
  public String klZ = null;
  public int kma = 0;
  public float kmb = 0.0F;
  public float kmc = 0.0F;
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
    AppMethodBeat.i(198555);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.klE != paramObject.klE) || (this.role != paramObject.role) || (this.mode != paramObject.mode) || (this.timestamps != paramObject.timestamps) || (this.netType != paramObject.netType) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.klF != paramObject.klF) || (this.klG != paramObject.klG) || (this.klH != paramObject.klH) || (this.klI != paramObject.klI) || (this.klJ != paramObject.klJ) || (this.klK != paramObject.klK) || (this.klL != paramObject.klL) || (this.klM != paramObject.klM) || (this.klN != paramObject.klN) || (this.klO != paramObject.klO) || (this.klP != paramObject.klP) || (this.klQ != paramObject.klQ) || (this.klR != paramObject.klR) || (this.klS != paramObject.klS) || (this.klT != paramObject.klT) || (this.klU != paramObject.klU) || (this.klV != paramObject.klV) || (this.klW != paramObject.klW) || (this.klX != paramObject.klX) || (this.klY != paramObject.klY) || (!p.h(this.klZ, paramObject.klZ)) || (this.kma != paramObject.kma) || (Float.compare(this.kmb, paramObject.kmb) != 0) || (Float.compare(this.kmc, paramObject.kmc) != 0) || (this.upLoss != paramObject.upLoss) || (this.downLoss != paramObject.downLoss) || (this.sendBytes != paramObject.sendBytes) || (this.receiveBytes != paramObject.receiveBytes)) {}
      }
    }
    else
    {
      AppMethodBeat.o(198555);
      return true;
    }
    AppMethodBeat.o(198555);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198548);
    long l = this.klE;
    int j = (int)(l ^ l >>> 32);
    int k = this.role;
    int m = this.mode;
    l = this.timestamps;
    int n = (int)(l ^ l >>> 32);
    int i1 = this.netType;
    int i2 = this.width;
    int i3 = this.height;
    int i4 = this.klF;
    int i5 = this.klG;
    int i6 = this.klH;
    int i7 = this.klI;
    int i8 = this.klJ;
    int i9 = this.klK;
    int i10 = this.klL;
    int i11 = this.klM;
    int i12 = this.klN;
    int i13 = this.klO;
    int i14 = this.klP;
    int i15 = this.klQ;
    int i16 = this.klR;
    l = this.klS;
    int i17 = (int)(l ^ l >>> 32);
    l = this.klT;
    int i18 = (int)(l ^ l >>> 32);
    int i19 = this.klU;
    int i20 = this.klV;
    int i21 = this.klW;
    int i22 = this.klX;
    int i23 = this.klY;
    String str = this.klZ;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int i24 = this.kma;
      int i25 = Float.floatToIntBits(this.kmb);
      int i26 = Float.floatToIntBits(this.kmc);
      int i27 = this.upLoss;
      int i28 = this.downLoss;
      l = this.sendBytes;
      int i29 = (int)(l ^ l >>> 32);
      l = this.receiveBytes;
      int i30 = (int)(l ^ l >>> 32);
      AppMethodBeat.o(198548);
      return (((((((i + ((((((((((((((((((((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198540);
    String str = "LiveQosInfo(live_id=" + this.klE + ", role=" + this.role + ", mode=" + this.mode + ", timestamps=" + this.timestamps + ", netType=" + this.netType + ", width=" + this.width + ", height=" + this.height + ", video_fps=" + this.klF + ", video_gop=" + this.klG + ", video_bitrate=" + this.klH + ", audio_bitrate=" + this.klI + ", net_speed=" + this.klJ + ", video_cache=" + this.klK + ", audio_cache=" + this.klL + ", video_sum_cache_size=" + this.klM + ", audio_video_play_interval=" + this.klN + ", audio_video_recv_interval=" + this.klO + ", audio_cache_threshold=" + this.klP + ", net_jitter=" + this.klQ + ", quality_level=" + this.klR + ", total_play_time_ms=" + this.klS + ", total_wait_time_ms=" + this.klT + ", live_start_play_time_sec=" + this.klU + ", first_frame_time_ms=" + this.klV + ", connect_ms=" + this.klW + ", rtt_ms=" + this.klX + ", network_id=" + this.klY + ", cdn_svr_ip=" + this.klZ + ", cdn_svr_port=" + this.kma + ", cpu_usage_process=" + this.kmb + ", cpu_usage_device=" + this.kmc + ", upLoss=" + this.upLoss + ", downLoss=" + this.downLoss + ", sendBytes=" + this.sendBytes + ", receiveBytes=" + this.receiveBytes + ")";
    AppMethodBeat.o(198540);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.d
 * JD-Core Version:    0.7.0.1
 */