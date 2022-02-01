package com.tencent.mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR;
  private static Map<String, GameWebPerformanceInfo> hib;
  public int hhA;
  public int hhB;
  public int hhC;
  public String hhD;
  public long hhE;
  public long hhF;
  public long hhG;
  public long hhH;
  public long hhI;
  public long hhJ;
  public long hhK;
  public long hhL;
  public long hhM;
  public long hhN;
  public long hhO;
  public long hhP;
  public long hhQ;
  public long hhR;
  public long hhS;
  public long hhT;
  public long hhU;
  public long hhV;
  public long hhW;
  public long hhX;
  public String hhY;
  public String hhZ;
  public String hhu;
  public int hhv;
  public int hhw;
  public int hhx;
  public int hhy;
  public int hhz;
  public String hia;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    hib = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.hhu = paramParcel.readString();
    this.hhv = paramParcel.readInt();
    this.hhw = paramParcel.readInt();
    this.hhx = paramParcel.readInt();
    this.hhy = paramParcel.readInt();
    this.hhz = paramParcel.readInt();
    this.hhA = paramParcel.readInt();
    this.hhB = paramParcel.readInt();
    this.hhC = paramParcel.readInt();
    this.hhD = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.hhE = paramParcel.readLong();
    this.hhF = paramParcel.readLong();
    this.hhG = paramParcel.readLong();
    this.hhH = paramParcel.readLong();
    this.hhI = paramParcel.readLong();
    this.hhJ = paramParcel.readLong();
    this.hhK = paramParcel.readLong();
    this.hhL = paramParcel.readLong();
    this.hhM = paramParcel.readLong();
    this.hhN = paramParcel.readLong();
    this.hhO = paramParcel.readLong();
    this.hhP = paramParcel.readLong();
    this.hhQ = paramParcel.readLong();
    this.hhR = paramParcel.readLong();
    this.hhS = paramParcel.readLong();
    this.hhT = paramParcel.readLong();
    this.hhU = paramParcel.readLong();
    this.hhV = paramParcel.readLong();
    this.hhW = paramParcel.readLong();
    this.hhX = paramParcel.readLong();
    this.hhY = paramParcel.readString();
    this.hhZ = paramParcel.readString();
    this.hia = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo Fd(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(117609);
        if (Util.isNullOrNil(paramString))
        {
          paramString = new GameWebPerformanceInfo();
          AppMethodBeat.o(117609);
          return paramString;
        }
        if (hib.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)hib.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      hib.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo Fe(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (hib.containsKey(paramString)) {
        hib.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      hib.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo Ff(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)hib.remove(paramString);
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
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.hhv), Integer.valueOf(this.hhw), Integer.valueOf(this.hhx), Integer.valueOf(this.hhy), Integer.valueOf(this.hhz), Integer.valueOf(this.hhB), Integer.valueOf(this.hhC), this.hhD, Long.valueOf(this.startTime), Long.valueOf(this.hhE), Long.valueOf(this.hhF), Long.valueOf(this.hhI), Long.valueOf(this.hhH), Long.valueOf(this.hhI), Long.valueOf(this.hhJ), Long.valueOf(this.hhK), Long.valueOf(this.hhL), Long.valueOf(this.hhM), Long.valueOf(this.hhN), Long.valueOf(this.hhO), Long.valueOf(this.hhP), Long.valueOf(this.hhQ), Long.valueOf(this.hhR), Long.valueOf(this.hhS), Long.valueOf(this.hhT), Long.valueOf(this.hhU), Long.valueOf(this.hhV), this.hhY, this.hhZ, this.hia });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.hhu);
    paramParcel.writeInt(this.hhv);
    paramParcel.writeInt(this.hhw);
    paramParcel.writeInt(this.hhx);
    paramParcel.writeInt(this.hhy);
    paramParcel.writeInt(this.hhz);
    paramParcel.writeInt(this.hhA);
    paramParcel.writeInt(this.hhB);
    paramParcel.writeInt(this.hhC);
    paramParcel.writeString(this.hhD);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.hhE);
    paramParcel.writeLong(this.hhF);
    paramParcel.writeLong(this.hhG);
    paramParcel.writeLong(this.hhH);
    paramParcel.writeLong(this.hhI);
    paramParcel.writeLong(this.hhJ);
    paramParcel.writeLong(this.hhK);
    paramParcel.writeLong(this.hhL);
    paramParcel.writeLong(this.hhM);
    paramParcel.writeLong(this.hhN);
    paramParcel.writeLong(this.hhO);
    paramParcel.writeLong(this.hhP);
    paramParcel.writeLong(this.hhQ);
    paramParcel.writeLong(this.hhR);
    paramParcel.writeLong(this.hhS);
    paramParcel.writeLong(this.hhT);
    paramParcel.writeLong(this.hhU);
    paramParcel.writeLong(this.hhV);
    paramParcel.writeLong(this.hhW);
    paramParcel.writeLong(this.hhX);
    paramParcel.writeString(this.hhY);
    paramParcel.writeString(this.hhZ);
    paramParcel.writeString(this.hia);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */