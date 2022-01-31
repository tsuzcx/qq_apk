package com.tencent.mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR;
  private static Map<String, GameWebPerformanceInfo> eAw;
  public long eAa;
  public long eAb;
  public long eAc;
  public long eAd;
  public long eAe;
  public long eAf;
  public long eAg;
  public long eAh;
  public long eAi;
  public long eAj;
  public long eAk;
  public long eAl;
  public long eAm;
  public long eAn;
  public long eAo;
  public long eAp;
  public long eAq;
  public long eAr;
  public long eAs;
  public String eAt;
  public String eAu;
  public String eAv;
  public String ezP;
  public int ezQ;
  public int ezR;
  public int ezS;
  public int ezT;
  public int ezU;
  public int ezV;
  public int ezW;
  public int ezX;
  public String ezY;
  public long ezZ;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(128618);
    CREATOR = new GameWebPerformanceInfo.1();
    eAw = new HashMap();
    AppMethodBeat.o(128618);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(128613);
    this.url = paramParcel.readString();
    this.ezP = paramParcel.readString();
    this.ezQ = paramParcel.readInt();
    this.ezR = paramParcel.readInt();
    this.ezS = paramParcel.readInt();
    this.ezT = paramParcel.readInt();
    this.ezU = paramParcel.readInt();
    this.ezV = paramParcel.readInt();
    this.ezW = paramParcel.readInt();
    this.ezX = paramParcel.readInt();
    this.ezY = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.ezZ = paramParcel.readLong();
    this.eAa = paramParcel.readLong();
    this.eAb = paramParcel.readLong();
    this.eAc = paramParcel.readLong();
    this.eAd = paramParcel.readLong();
    this.eAe = paramParcel.readLong();
    this.eAf = paramParcel.readLong();
    this.eAg = paramParcel.readLong();
    this.eAh = paramParcel.readLong();
    this.eAi = paramParcel.readLong();
    this.eAj = paramParcel.readLong();
    this.eAk = paramParcel.readLong();
    this.eAl = paramParcel.readLong();
    this.eAm = paramParcel.readLong();
    this.eAn = paramParcel.readLong();
    this.eAo = paramParcel.readLong();
    this.eAp = paramParcel.readLong();
    this.eAq = paramParcel.readLong();
    this.eAr = paramParcel.readLong();
    this.eAs = paramParcel.readLong();
    this.eAt = paramParcel.readString();
    this.eAu = paramParcel.readString();
    this.eAv = paramParcel.readString();
    AppMethodBeat.o(128613);
  }
  
  public static GameWebPerformanceInfo lN(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(128615);
        if (bo.isNullOrNil(paramString))
        {
          paramString = new GameWebPerformanceInfo();
          AppMethodBeat.o(128615);
          return paramString;
        }
        if (eAw.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)eAw.get(paramString);
          AppMethodBeat.o(128615);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      eAw.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(128615);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo lO(String paramString)
  {
    try
    {
      AppMethodBeat.i(128616);
      if (eAw.containsKey(paramString)) {
        eAw.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      eAw.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(128616);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo lP(String paramString)
  {
    AppMethodBeat.i(128617);
    paramString = (GameWebPerformanceInfo)eAw.remove(paramString);
    AppMethodBeat.o(128617);
    return paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(128614);
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.ezQ), Integer.valueOf(this.ezR), Integer.valueOf(this.ezS), Integer.valueOf(this.ezT), Integer.valueOf(this.ezU), Integer.valueOf(this.ezW), Integer.valueOf(this.ezX), this.ezY, Long.valueOf(this.startTime), Long.valueOf(this.ezZ), Long.valueOf(this.eAa), Long.valueOf(this.eAd), Long.valueOf(this.eAc), Long.valueOf(this.eAd), Long.valueOf(this.eAe), Long.valueOf(this.eAf), Long.valueOf(this.eAg), Long.valueOf(this.eAh), Long.valueOf(this.eAi), Long.valueOf(this.eAj), Long.valueOf(this.eAk), Long.valueOf(this.eAl), Long.valueOf(this.eAm), Long.valueOf(this.eAn), Long.valueOf(this.eAo), Long.valueOf(this.eAp), Long.valueOf(this.eAq), this.eAt, this.eAu, this.eAv });
    AppMethodBeat.o(128614);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(128612);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.ezP);
    paramParcel.writeInt(this.ezQ);
    paramParcel.writeInt(this.ezR);
    paramParcel.writeInt(this.ezS);
    paramParcel.writeInt(this.ezT);
    paramParcel.writeInt(this.ezU);
    paramParcel.writeInt(this.ezV);
    paramParcel.writeInt(this.ezW);
    paramParcel.writeInt(this.ezX);
    paramParcel.writeString(this.ezY);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.ezZ);
    paramParcel.writeLong(this.eAa);
    paramParcel.writeLong(this.eAb);
    paramParcel.writeLong(this.eAc);
    paramParcel.writeLong(this.eAd);
    paramParcel.writeLong(this.eAe);
    paramParcel.writeLong(this.eAf);
    paramParcel.writeLong(this.eAg);
    paramParcel.writeLong(this.eAh);
    paramParcel.writeLong(this.eAi);
    paramParcel.writeLong(this.eAj);
    paramParcel.writeLong(this.eAk);
    paramParcel.writeLong(this.eAl);
    paramParcel.writeLong(this.eAm);
    paramParcel.writeLong(this.eAn);
    paramParcel.writeLong(this.eAo);
    paramParcel.writeLong(this.eAp);
    paramParcel.writeLong(this.eAq);
    paramParcel.writeLong(this.eAr);
    paramParcel.writeLong(this.eAs);
    paramParcel.writeString(this.eAt);
    paramParcel.writeString(this.eAu);
    paramParcel.writeString(this.eAv);
    AppMethodBeat.o(128612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */