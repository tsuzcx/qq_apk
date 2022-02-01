package com.tencent.c.a.a.a;

import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "", "onLiveFinished", "", "onLiveInfoChanged", "msg", "", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "info", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomInfo;", "onLiveNetStatus", "netQuality", "", "threshold", "onLiveVoiceVolume", "volume", "onMiniWindowStatusChange", "isShown", "", "gameAppId", "", "gameVersionType", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "onPostResult", "result", "errType", "onShareLiveToConversation", "shareUserCount", "shareRoomCount", "FinderLiveExternalMsgType", "GameLivingStatus", "PostErrType", "plugin-finder-live-api_release"})
public abstract interface a
{
  public abstract void Ud(int paramInt);
  
  public abstract void V(boolean paramBoolean, int paramInt);
  
  public abstract void a(List<? extends cuc> paramList, cub paramcub);
  
  public abstract void d(String paramString, Integer paramInteger);
  
  public abstract void dyo();
  
  public abstract void hH(int paramInt1, int paramInt2);
  
  public abstract void j(boolean paramBoolean, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */