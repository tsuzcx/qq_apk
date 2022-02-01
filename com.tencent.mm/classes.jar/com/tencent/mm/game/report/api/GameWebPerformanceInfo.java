package com.tencent.mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR;
  private static Map<String, GameWebPerformanceInfo> gvm;
  public String guF;
  public int guG;
  public int guH;
  public int guI;
  public int guJ;
  public int guK;
  public int guL;
  public int guM;
  public int guN;
  public String guO;
  public long guP;
  public long guQ;
  public long guR;
  public long guS;
  public long guT;
  public long guU;
  public long guV;
  public long guW;
  public long guX;
  public long guY;
  public long guZ;
  public long gva;
  public long gvb;
  public long gvc;
  public long gvd;
  public long gve;
  public long gvf;
  public long gvg;
  public long gvh;
  public long gvi;
  public String gvj;
  public String gvk;
  public String gvl;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    gvm = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.guF = paramParcel.readString();
    this.guG = paramParcel.readInt();
    this.guH = paramParcel.readInt();
    this.guI = paramParcel.readInt();
    this.guJ = paramParcel.readInt();
    this.guK = paramParcel.readInt();
    this.guL = paramParcel.readInt();
    this.guM = paramParcel.readInt();
    this.guN = paramParcel.readInt();
    this.guO = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.guP = paramParcel.readLong();
    this.guQ = paramParcel.readLong();
    this.guR = paramParcel.readLong();
    this.guS = paramParcel.readLong();
    this.guT = paramParcel.readLong();
    this.guU = paramParcel.readLong();
    this.guV = paramParcel.readLong();
    this.guW = paramParcel.readLong();
    this.guX = paramParcel.readLong();
    this.guY = paramParcel.readLong();
    this.guZ = paramParcel.readLong();
    this.gva = paramParcel.readLong();
    this.gvb = paramParcel.readLong();
    this.gvc = paramParcel.readLong();
    this.gvd = paramParcel.readLong();
    this.gve = paramParcel.readLong();
    this.gvf = paramParcel.readLong();
    this.gvg = paramParcel.readLong();
    this.gvh = paramParcel.readLong();
    this.gvi = paramParcel.readLong();
    this.gvj = paramParcel.readString();
    this.gvk = paramParcel.readString();
    this.gvl = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo wP(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(117609);
        if (bu.isNullOrNil(paramString))
        {
          paramString = new GameWebPerformanceInfo();
          AppMethodBeat.o(117609);
          return paramString;
        }
        if (gvm.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)gvm.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      gvm.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo wQ(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (gvm.containsKey(paramString)) {
        gvm.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      gvm.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo wR(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)gvm.remove(paramString);
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
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.guG), Integer.valueOf(this.guH), Integer.valueOf(this.guI), Integer.valueOf(this.guJ), Integer.valueOf(this.guK), Integer.valueOf(this.guM), Integer.valueOf(this.guN), this.guO, Long.valueOf(this.startTime), Long.valueOf(this.guP), Long.valueOf(this.guQ), Long.valueOf(this.guT), Long.valueOf(this.guS), Long.valueOf(this.guT), Long.valueOf(this.guU), Long.valueOf(this.guV), Long.valueOf(this.guW), Long.valueOf(this.guX), Long.valueOf(this.guY), Long.valueOf(this.guZ), Long.valueOf(this.gva), Long.valueOf(this.gvb), Long.valueOf(this.gvc), Long.valueOf(this.gvd), Long.valueOf(this.gve), Long.valueOf(this.gvf), Long.valueOf(this.gvg), this.gvj, this.gvk, this.gvl });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.guF);
    paramParcel.writeInt(this.guG);
    paramParcel.writeInt(this.guH);
    paramParcel.writeInt(this.guI);
    paramParcel.writeInt(this.guJ);
    paramParcel.writeInt(this.guK);
    paramParcel.writeInt(this.guL);
    paramParcel.writeInt(this.guM);
    paramParcel.writeInt(this.guN);
    paramParcel.writeString(this.guO);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.guP);
    paramParcel.writeLong(this.guQ);
    paramParcel.writeLong(this.guR);
    paramParcel.writeLong(this.guS);
    paramParcel.writeLong(this.guT);
    paramParcel.writeLong(this.guU);
    paramParcel.writeLong(this.guV);
    paramParcel.writeLong(this.guW);
    paramParcel.writeLong(this.guX);
    paramParcel.writeLong(this.guY);
    paramParcel.writeLong(this.guZ);
    paramParcel.writeLong(this.gva);
    paramParcel.writeLong(this.gvb);
    paramParcel.writeLong(this.gvc);
    paramParcel.writeLong(this.gvd);
    paramParcel.writeLong(this.gve);
    paramParcel.writeLong(this.gvf);
    paramParcel.writeLong(this.gvg);
    paramParcel.writeLong(this.gvh);
    paramParcel.writeLong(this.gvi);
    paramParcel.writeString(this.gvj);
    paramParcel.writeString(this.gvk);
    paramParcel.writeString(this.gvl);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */