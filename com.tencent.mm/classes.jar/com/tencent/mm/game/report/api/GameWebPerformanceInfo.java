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
  private static Map<String, GameWebPerformanceInfo> jTZ;
  public int jTA;
  public String jTB;
  public long jTC;
  public long jTD;
  public long jTE;
  public long jTF;
  public long jTG;
  public long jTH;
  public long jTI;
  public long jTJ;
  public long jTK;
  public long jTL;
  public long jTM;
  public long jTN;
  public long jTO;
  public long jTP;
  public long jTQ;
  public long jTR;
  public long jTS;
  public long jTT;
  public long jTU;
  public long jTV;
  public String jTW;
  public String jTX;
  public String jTY;
  public String jTs;
  public int jTt;
  public int jTu;
  public int jTv;
  public int jTw;
  public int jTx;
  public int jTy;
  public int jTz;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    jTZ = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.jTs = paramParcel.readString();
    this.jTt = paramParcel.readInt();
    this.jTu = paramParcel.readInt();
    this.jTv = paramParcel.readInt();
    this.jTw = paramParcel.readInt();
    this.jTx = paramParcel.readInt();
    this.jTy = paramParcel.readInt();
    this.jTz = paramParcel.readInt();
    this.jTA = paramParcel.readInt();
    this.jTB = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.jTC = paramParcel.readLong();
    this.jTD = paramParcel.readLong();
    this.jTE = paramParcel.readLong();
    this.jTF = paramParcel.readLong();
    this.jTG = paramParcel.readLong();
    this.jTH = paramParcel.readLong();
    this.jTI = paramParcel.readLong();
    this.jTJ = paramParcel.readLong();
    this.jTK = paramParcel.readLong();
    this.jTL = paramParcel.readLong();
    this.jTM = paramParcel.readLong();
    this.jTN = paramParcel.readLong();
    this.jTO = paramParcel.readLong();
    this.jTP = paramParcel.readLong();
    this.jTQ = paramParcel.readLong();
    this.jTR = paramParcel.readLong();
    this.jTS = paramParcel.readLong();
    this.jTT = paramParcel.readLong();
    this.jTU = paramParcel.readLong();
    this.jTV = paramParcel.readLong();
    this.jTW = paramParcel.readString();
    this.jTX = paramParcel.readString();
    this.jTY = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo LZ(String paramString)
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
        if (jTZ.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)jTZ.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      jTZ.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo Ma(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (jTZ.containsKey(paramString)) {
        jTZ.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      jTZ.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo Mb(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)jTZ.remove(paramString);
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
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.jTt), Integer.valueOf(this.jTu), Integer.valueOf(this.jTv), Integer.valueOf(this.jTw), Integer.valueOf(this.jTx), Integer.valueOf(this.jTz), Integer.valueOf(this.jTA), this.jTB, Long.valueOf(this.startTime), Long.valueOf(this.jTC), Long.valueOf(this.jTD), Long.valueOf(this.jTG), Long.valueOf(this.jTF), Long.valueOf(this.jTG), Long.valueOf(this.jTH), Long.valueOf(this.jTI), Long.valueOf(this.jTJ), Long.valueOf(this.jTK), Long.valueOf(this.jTL), Long.valueOf(this.jTM), Long.valueOf(this.jTN), Long.valueOf(this.jTO), Long.valueOf(this.jTP), Long.valueOf(this.jTQ), Long.valueOf(this.jTR), Long.valueOf(this.jTS), Long.valueOf(this.jTT), this.jTW, this.jTX, this.jTY });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.jTs);
    paramParcel.writeInt(this.jTt);
    paramParcel.writeInt(this.jTu);
    paramParcel.writeInt(this.jTv);
    paramParcel.writeInt(this.jTw);
    paramParcel.writeInt(this.jTx);
    paramParcel.writeInt(this.jTy);
    paramParcel.writeInt(this.jTz);
    paramParcel.writeInt(this.jTA);
    paramParcel.writeString(this.jTB);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.jTC);
    paramParcel.writeLong(this.jTD);
    paramParcel.writeLong(this.jTE);
    paramParcel.writeLong(this.jTF);
    paramParcel.writeLong(this.jTG);
    paramParcel.writeLong(this.jTH);
    paramParcel.writeLong(this.jTI);
    paramParcel.writeLong(this.jTJ);
    paramParcel.writeLong(this.jTK);
    paramParcel.writeLong(this.jTL);
    paramParcel.writeLong(this.jTM);
    paramParcel.writeLong(this.jTN);
    paramParcel.writeLong(this.jTO);
    paramParcel.writeLong(this.jTP);
    paramParcel.writeLong(this.jTQ);
    paramParcel.writeLong(this.jTR);
    paramParcel.writeLong(this.jTS);
    paramParcel.writeLong(this.jTT);
    paramParcel.writeLong(this.jTU);
    paramParcel.writeLong(this.jTV);
    paramParcel.writeString(this.jTW);
    paramParcel.writeString(this.jTX);
    paramParcel.writeString(this.jTY);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */