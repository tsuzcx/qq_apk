package com.tencent.d.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.dle;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "", "onLiveFinished", "", "onLiveInfoChanged", "msg", "", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "info", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomInfo;", "onLiveNetStatus", "netQuality", "", "threshold", "onLiveVoiceVolume", "volume", "onMiniWindowStatusChange", "isShown", "", "gameAppId", "", "gameVersionType", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "onPostResult", "result", "errType", "onShareLiveToConversation", "shareUserCount", "shareRoomCount", "FinderLiveExternalMsgType", "GameLivingStatus", "PostErrType", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void X(boolean paramBoolean, int paramInt);
  
  public abstract void XY(int paramInt);
  
  public abstract void a(List<? extends dle> paramList, dld paramdld);
  
  public abstract void c(String paramString, Integer paramInteger);
  
  public abstract void ekG();
  
  public abstract void jk(int paramInt1, int paramInt2);
  
  public abstract void m(boolean paramBoolean, int paramInt1, int paramInt2);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback$FinderLiveExternalMsgType;", "", "(Ljava/lang/String;I)V", "MMLiveRoomMsgOpenType_Unknown", "MMLiveRoomMsgOpenType_Anchor_Notice", "MMLiveRoomMsgOpenType_Audience_Comment", "MMLiveRoomMsgOpenType_Audience_Join", "MMLiveRoomMsgOpenType_Top", "MMLiveRoomMsgOpenType_Official", "MMLiveRoomMsgOpenType_Official_BanComment", "MMLiveRoomMsgOpenType_Official_OpenComment", "MMLiveRoomMsgOpenType_Official_ConnectMic", "MMLiveRoomMsgOpenType_Official_LiveRewardEnable", "MMLiveRoomMsgOpenType_ComboLiveReward", "MMLiveRoomMsgOpenType_RewardRankingNotice", "MMLiveRoomMsgOpenType_Official_Location", "MMLiveRoomMsgOpenType_RedPacket_Sent", "MMLiveRoomMsgOpenType_RedPacket_Received", "MMLiveRoomMsgOpenType_Official_PureAudioMode", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(216687);
      ahiA = new a("MMLiveRoomMsgOpenType_Unknown", 0);
      ahiB = new a("MMLiveRoomMsgOpenType_Anchor_Notice", 1);
      ahiC = new a("MMLiveRoomMsgOpenType_Audience_Comment", 2);
      ahiD = new a("MMLiveRoomMsgOpenType_Audience_Join", 3);
      ahiE = new a("MMLiveRoomMsgOpenType_Top", 4);
      ahiF = new a("MMLiveRoomMsgOpenType_Official", 5);
      ahiG = new a("MMLiveRoomMsgOpenType_Official_BanComment", 6);
      ahiH = new a("MMLiveRoomMsgOpenType_Official_OpenComment", 7);
      ahiI = new a("MMLiveRoomMsgOpenType_Official_ConnectMic", 8);
      ahiJ = new a("MMLiveRoomMsgOpenType_Official_LiveRewardEnable", 9);
      ahiK = new a("MMLiveRoomMsgOpenType_ComboLiveReward", 10);
      ahiL = new a("MMLiveRoomMsgOpenType_RewardRankingNotice", 11);
      ahiM = new a("MMLiveRoomMsgOpenType_Official_Location", 12);
      ahiN = new a("MMLiveRoomMsgOpenType_RedPacket_Sent", 13);
      ahiO = new a("MMLiveRoomMsgOpenType_RedPacket_Received", 14);
      ahiP = new a("MMLiveRoomMsgOpenType_Official_PureAudioMode", 15);
      ahiQ = new a[] { ahiA, ahiB, ahiC, ahiD, ahiE, ahiF, ahiG, ahiH, ahiI, ahiJ, ahiK, ahiL, ahiM, ahiN, ahiO, ahiP };
      AppMethodBeat.o(216687);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */