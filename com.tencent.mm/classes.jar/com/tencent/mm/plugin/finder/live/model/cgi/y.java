package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLotteryParams;", "", "liveId", "", "objectId", "nonceId", "", "durationMin", "", "desc", "attendType", "attendWording", "opType", "winnerCnt", "setting_flag", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;IIJLcom/tencent/mm/protobuf/ByteString;)V", "getAttendType", "()I", "getAttendWording", "()Ljava/lang/String;", "getDesc", "getDurationMin", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "()J", "getNonceId", "getObjectId", "getOpType", "getSetting_flag", "getWinnerCnt", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  final b Ayh;
  final int CJH;
  final int CJI;
  final String CJJ;
  final long CJK;
  final int Czn;
  final String desc;
  final long hKN;
  final long liveId;
  final String nonceId;
  final int opType;
  
  public y(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, long paramLong3, b paramb)
  {
    AppMethodBeat.i(360281);
    this.liveId = paramLong1;
    this.hKN = paramLong2;
    this.nonceId = paramString1;
    this.CJH = paramInt1;
    this.desc = paramString2;
    this.CJI = paramInt2;
    this.CJJ = paramString3;
    this.opType = paramInt3;
    this.Czn = paramInt4;
    this.CJK = paramLong3;
    this.Ayh = paramb;
    AppMethodBeat.o(360281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.y
 * JD-Core Version:    0.7.0.1
 */