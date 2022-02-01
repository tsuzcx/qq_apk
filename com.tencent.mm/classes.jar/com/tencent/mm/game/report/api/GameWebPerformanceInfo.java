package com.tencent.mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR;
  private static Map<String, GameWebPerformanceInfo> fZp;
  public String fYI;
  public int fYJ;
  public int fYK;
  public int fYL;
  public int fYM;
  public int fYN;
  public int fYO;
  public int fYP;
  public int fYQ;
  public String fYR;
  public long fYS;
  public long fYT;
  public long fYU;
  public long fYV;
  public long fYW;
  public long fYX;
  public long fYY;
  public long fYZ;
  public long fZa;
  public long fZb;
  public long fZc;
  public long fZd;
  public long fZe;
  public long fZf;
  public long fZg;
  public long fZh;
  public long fZi;
  public long fZj;
  public long fZk;
  public long fZl;
  public String fZm;
  public String fZn;
  public String fZo;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    fZp = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.fYI = paramParcel.readString();
    this.fYJ = paramParcel.readInt();
    this.fYK = paramParcel.readInt();
    this.fYL = paramParcel.readInt();
    this.fYM = paramParcel.readInt();
    this.fYN = paramParcel.readInt();
    this.fYO = paramParcel.readInt();
    this.fYP = paramParcel.readInt();
    this.fYQ = paramParcel.readInt();
    this.fYR = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.fYS = paramParcel.readLong();
    this.fYT = paramParcel.readLong();
    this.fYU = paramParcel.readLong();
    this.fYV = paramParcel.readLong();
    this.fYW = paramParcel.readLong();
    this.fYX = paramParcel.readLong();
    this.fYY = paramParcel.readLong();
    this.fYZ = paramParcel.readLong();
    this.fZa = paramParcel.readLong();
    this.fZb = paramParcel.readLong();
    this.fZc = paramParcel.readLong();
    this.fZd = paramParcel.readLong();
    this.fZe = paramParcel.readLong();
    this.fZf = paramParcel.readLong();
    this.fZg = paramParcel.readLong();
    this.fZh = paramParcel.readLong();
    this.fZi = paramParcel.readLong();
    this.fZj = paramParcel.readLong();
    this.fZk = paramParcel.readLong();
    this.fZl = paramParcel.readLong();
    this.fZm = paramParcel.readString();
    this.fZn = paramParcel.readString();
    this.fZo = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo tq(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(117609);
        if (bs.isNullOrNil(paramString))
        {
          paramString = new GameWebPerformanceInfo();
          AppMethodBeat.o(117609);
          return paramString;
        }
        if (fZp.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)fZp.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      fZp.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo tr(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (fZp.containsKey(paramString)) {
        fZp.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      fZp.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo ts(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)fZp.remove(paramString);
    AppMethodBeat.o(117611);
    return paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117608);
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.fYJ), Integer.valueOf(this.fYK), Integer.valueOf(this.fYL), Integer.valueOf(this.fYM), Integer.valueOf(this.fYN), Integer.valueOf(this.fYP), Integer.valueOf(this.fYQ), this.fYR, Long.valueOf(this.startTime), Long.valueOf(this.fYS), Long.valueOf(this.fYT), Long.valueOf(this.fYW), Long.valueOf(this.fYV), Long.valueOf(this.fYW), Long.valueOf(this.fYX), Long.valueOf(this.fYY), Long.valueOf(this.fYZ), Long.valueOf(this.fZa), Long.valueOf(this.fZb), Long.valueOf(this.fZc), Long.valueOf(this.fZd), Long.valueOf(this.fZe), Long.valueOf(this.fZf), Long.valueOf(this.fZg), Long.valueOf(this.fZh), Long.valueOf(this.fZi), Long.valueOf(this.fZj), this.fZm, this.fZn, this.fZo });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.fYI);
    paramParcel.writeInt(this.fYJ);
    paramParcel.writeInt(this.fYK);
    paramParcel.writeInt(this.fYL);
    paramParcel.writeInt(this.fYM);
    paramParcel.writeInt(this.fYN);
    paramParcel.writeInt(this.fYO);
    paramParcel.writeInt(this.fYP);
    paramParcel.writeInt(this.fYQ);
    paramParcel.writeString(this.fYR);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.fYS);
    paramParcel.writeLong(this.fYT);
    paramParcel.writeLong(this.fYU);
    paramParcel.writeLong(this.fYV);
    paramParcel.writeLong(this.fYW);
    paramParcel.writeLong(this.fYX);
    paramParcel.writeLong(this.fYY);
    paramParcel.writeLong(this.fYZ);
    paramParcel.writeLong(this.fZa);
    paramParcel.writeLong(this.fZb);
    paramParcel.writeLong(this.fZc);
    paramParcel.writeLong(this.fZd);
    paramParcel.writeLong(this.fZe);
    paramParcel.writeLong(this.fZf);
    paramParcel.writeLong(this.fZg);
    paramParcel.writeLong(this.fZh);
    paramParcel.writeLong(this.fZi);
    paramParcel.writeLong(this.fZj);
    paramParcel.writeLong(this.fZk);
    paramParcel.writeLong(this.fZl);
    paramParcel.writeString(this.fZm);
    paramParcel.writeString(this.fZn);
    paramParcel.writeString(this.fZo);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */