package com.tencent.d.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgr;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics;", "", "()V", "OLYMPICS_RES_SUBTYPE", "", "getOLYMPICS_RES_SUBTYPE", "()I", "isForbidOlympicsEnablePreload", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveEventInfo;", "BoardIndexScene", "BoardScene", "CommentRelation", "CommentType", "EntranceType", "FinderEventErr", "FinderEventId", "FinderEventInfoType", "FinderLiveOpenReqType", "RelayScene", "ResType", "TorchLiveSource", "emFinderLiveOpenRelatedEventType", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ahnU;
  private static final int ahnV;
  
  static
  {
    AppMethodBeat.i(216721);
    ahnU = new b();
    ahnV = 1;
    AppMethodBeat.o(216721);
  }
  
  public static boolean a(bgr parambgr)
  {
    AppMethodBeat.i(369535);
    s.u(parambgr, "<this>");
    int i = parambgr.mIY;
    b.g.a locala = g.ahoC;
    if ((i == b.g.a.jWh()) && (parambgr.mJb != 1))
    {
      AppMethodBeat.o(369535);
      return true;
    }
    AppMethodBeat.o(369535);
    return false;
  }
  
  public static int jVP()
  {
    return ahnV;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$BoardIndexScene;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public static final a ahnW = a.ahnX;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$BoardIndexScene$Companion;", "", "()V", "Default", "", "getDefault", "()I", "Location", "getLocation", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahnY;
      private static final int bcz = 0;
      
      static
      {
        AppMethodBeat.i(216720);
        ahnX = new a();
        ahnY = 1;
        AppMethodBeat.o(216720);
      }
      
      public static int jVQ()
      {
        return bcz;
      }
      
      public static int jVR()
      {
        return ahnY;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$BoardScene;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public static final a ahnZ = a.ahoa;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$BoardScene$Companion;", "", "()V", "Friend_Board", "", "getFriend_Board", "()I", "Global_Board", "getGlobal_Board", "Index_Board", "getIndex_Board", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahob;
      private static final int ahoc;
      private static final int ahod;
      
      static
      {
        AppMethodBeat.i(216705);
        ahoa = new a();
        ahob = 1;
        ahoc = 2;
        ahod = 3;
        AppMethodBeat.o(216705);
      }
      
      public static int jVS()
      {
        return ahob;
      }
      
      public static int jVT()
      {
        return ahoc;
      }
      
      public static int jVU()
      {
        return ahod;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$CommentRelation;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public static final a ahoe = a.ahof;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$CommentRelation$Companion;", "", "()V", "CommentRelation_Friend", "", "getCommentRelation_Friend", "()I", "CommentRelation_Self", "getCommentRelation_Self", "CommentRelation_Stranger", "getCommentRelation_Stranger", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahog = 0;
      private static final int ahoh;
      private static final int ahoi;
      
      static
      {
        AppMethodBeat.i(216700);
        ahof = new a();
        ahoh = 1;
        ahoi = 2;
        AppMethodBeat.o(216700);
      }
      
      public static int jVV()
      {
        return ahog;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$CommentType;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public static final a ahoj = a.ahok;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$CommentType$Companion;", "", "()V", "PostMsg", "", "getPostMsg", "()I", "Torchbearer", "getTorchbearer", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahol;
      private static final int ahom;
      
      static
      {
        AppMethodBeat.i(216683);
        ahok = new a();
        ahol = 1;
        ahom = 2;
        AppMethodBeat.o(216683);
      }
      
      public static int jVW()
      {
        return ahol;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$FinderEventErr;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface f
  {
    public static final a ahou = a.ahov;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$FinderEventErr$Companion;", "", "()V", "kFinderEventErrLogic", "", "getKFinderEventErrLogic", "()I", "kFinderEventErrOk", "getKFinderEventErrOk", "kFinderEventErrSys", "getKFinderEventErrSys", "kOlympicsErrAntiSpam", "getKOlympicsErrAntiSpam", "kOlympicsErrBanned", "getKOlympicsErrBanned", "kOlympicsErrForbidden", "getKOlympicsErrForbidden", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahoA;
      private static final int ahoB;
      private static final int ahow = 0;
      private static final int ahox;
      private static final int ahoy;
      private static final int ahoz;
      
      static
      {
        AppMethodBeat.i(216704);
        ahov = new a();
        ahox = 1000;
        ahoy = 1001;
        ahoz = 2000;
        ahoA = 2001;
        ahoB = 2002;
        AppMethodBeat.o(216704);
      }
      
      public static int jWd()
      {
        return ahow;
      }
      
      public static int jWe()
      {
        return ahoz;
      }
      
      public static int jWf()
      {
        return ahoA;
      }
      
      public static int jWg()
      {
        return ahoB;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$FinderEventId;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface g
  {
    public static final a ahoC = a.ahoD;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$FinderEventId$Companion;", "", "()V", "kFinderEventIdOlympics", "", "getKFinderEventIdOlympics", "()I", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahoE;
      
      static
      {
        AppMethodBeat.i(216706);
        ahoD = new a();
        ahoE = 1;
        AppMethodBeat.o(216706);
      }
      
      public static int jWh()
      {
        return ahoE;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$FinderEventInfoType;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface h
  {
    public static final a ahoF = a.ahoG;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$FinderEventInfoType$Companion;", "", "()V", "kFinderEventInfoTypeStartStatus", "", "getKFinderEventInfoTypeStartStatus", "()I", "kFinderEventInfoTypeTocherTotal", "getKFinderEventInfoTypeTocherTotal", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahoH;
      private static final int ahoI;
      
      static
      {
        AppMethodBeat.i(216689);
        ahoG = new a();
        ahoH = 1;
        ahoI = 2;
        AppMethodBeat.o(216689);
      }
      
      public static int jWi()
      {
        return ahoH;
      }
      
      public static int jWj()
      {
        return ahoI;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$TorchLiveSource;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface k
  {
    public static final a ahpq = a.ahpr;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$TorchLiveSource$Companion;", "", "()V", "kTorchLiveSourceChat", "", "getKTorchLiveSourceChat", "()I", "kTorchLiveSourceFeed", "getKTorchLiveSourceFeed", "kTorchLiveSourceHongbao", "getKTorchLiveSourceHongbao", "kTorchLiveSourceLbsLiveStream", "getKTorchLiveSourceLbsLiveStream", "kTorchLiveSourceSns", "getKTorchLiveSourceSns", "kTorchLiveSourceSport", "getKTorchLiveSourceSport", "kTorchLiveSourceStatus", "getKTorchLiveSourceStatus", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahps;
      private static final int ahpt;
      private static final int ahpu;
      private static final int ahpv;
      private static final int ahpw;
      private static final int ahpx;
      private static final int ahpy;
      
      static
      {
        AppMethodBeat.i(216710);
        ahpr = new a();
        ahps = 1;
        ahpt = 2;
        ahpu = 3;
        ahpv = 4;
        ahpw = 5;
        ahpx = 6;
        ahpy = 7;
        AppMethodBeat.o(216710);
      }
      
      public static int jWk()
      {
        return ahps;
      }
      
      public static int jWl()
      {
        return ahpt;
      }
      
      public static int jWm()
      {
        return ahpu;
      }
      
      public static int jWn()
      {
        return ahpv;
      }
      
      public static int jWo()
      {
        return ahpy;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$emFinderLiveOpenRelatedEventType;", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface l
  {
    public static final a ahpz = a.ahpA;
    
    @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$emFinderLiveOpenRelatedEventType$Companion;", "", "()V", "FinderLiveOpenRelatedEventType_Board", "", "getFinderLiveOpenRelatedEventType_Board", "()I", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      private static final int ahpB;
      
      static
      {
        AppMethodBeat.i(216684);
        ahpA = new a();
        ahpB = 1;
        AppMethodBeat.o(216684);
      }
      
      public static int jWp()
      {
        return ahpB;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */