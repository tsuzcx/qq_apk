package com.tencent.mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR;
  private static Map<String, GameWebPerformanceInfo> fVu;
  public String fUN;
  public int fUO;
  public int fUP;
  public int fUQ;
  public int fUR;
  public int fUS;
  public int fUT;
  public int fUU;
  public int fUV;
  public String fUW;
  public long fUX;
  public long fUY;
  public long fUZ;
  public long fVa;
  public long fVb;
  public long fVc;
  public long fVd;
  public long fVe;
  public long fVf;
  public long fVg;
  public long fVh;
  public long fVi;
  public long fVj;
  public long fVk;
  public long fVl;
  public long fVm;
  public long fVn;
  public long fVo;
  public long fVp;
  public long fVq;
  public String fVr;
  public String fVs;
  public String fVt;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    fVu = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.fUN = paramParcel.readString();
    this.fUO = paramParcel.readInt();
    this.fUP = paramParcel.readInt();
    this.fUQ = paramParcel.readInt();
    this.fUR = paramParcel.readInt();
    this.fUS = paramParcel.readInt();
    this.fUT = paramParcel.readInt();
    this.fUU = paramParcel.readInt();
    this.fUV = paramParcel.readInt();
    this.fUW = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.fUX = paramParcel.readLong();
    this.fUY = paramParcel.readLong();
    this.fUZ = paramParcel.readLong();
    this.fVa = paramParcel.readLong();
    this.fVb = paramParcel.readLong();
    this.fVc = paramParcel.readLong();
    this.fVd = paramParcel.readLong();
    this.fVe = paramParcel.readLong();
    this.fVf = paramParcel.readLong();
    this.fVg = paramParcel.readLong();
    this.fVh = paramParcel.readLong();
    this.fVi = paramParcel.readLong();
    this.fVj = paramParcel.readLong();
    this.fVk = paramParcel.readLong();
    this.fVl = paramParcel.readLong();
    this.fVm = paramParcel.readLong();
    this.fVn = paramParcel.readLong();
    this.fVo = paramParcel.readLong();
    this.fVp = paramParcel.readLong();
    this.fVq = paramParcel.readLong();
    this.fVr = paramParcel.readString();
    this.fVs = paramParcel.readString();
    this.fVt = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo qd(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(117609);
        if (bt.isNullOrNil(paramString))
        {
          paramString = new GameWebPerformanceInfo();
          AppMethodBeat.o(117609);
          return paramString;
        }
        if (fVu.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)fVu.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      fVu.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo qe(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (fVu.containsKey(paramString)) {
        fVu.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      fVu.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo qf(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)fVu.remove(paramString);
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
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.fUO), Integer.valueOf(this.fUP), Integer.valueOf(this.fUQ), Integer.valueOf(this.fUR), Integer.valueOf(this.fUS), Integer.valueOf(this.fUU), Integer.valueOf(this.fUV), this.fUW, Long.valueOf(this.startTime), Long.valueOf(this.fUX), Long.valueOf(this.fUY), Long.valueOf(this.fVb), Long.valueOf(this.fVa), Long.valueOf(this.fVb), Long.valueOf(this.fVc), Long.valueOf(this.fVd), Long.valueOf(this.fVe), Long.valueOf(this.fVf), Long.valueOf(this.fVg), Long.valueOf(this.fVh), Long.valueOf(this.fVi), Long.valueOf(this.fVj), Long.valueOf(this.fVk), Long.valueOf(this.fVl), Long.valueOf(this.fVm), Long.valueOf(this.fVn), Long.valueOf(this.fVo), this.fVr, this.fVs, this.fVt });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.fUN);
    paramParcel.writeInt(this.fUO);
    paramParcel.writeInt(this.fUP);
    paramParcel.writeInt(this.fUQ);
    paramParcel.writeInt(this.fUR);
    paramParcel.writeInt(this.fUS);
    paramParcel.writeInt(this.fUT);
    paramParcel.writeInt(this.fUU);
    paramParcel.writeInt(this.fUV);
    paramParcel.writeString(this.fUW);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.fUX);
    paramParcel.writeLong(this.fUY);
    paramParcel.writeLong(this.fUZ);
    paramParcel.writeLong(this.fVa);
    paramParcel.writeLong(this.fVb);
    paramParcel.writeLong(this.fVc);
    paramParcel.writeLong(this.fVd);
    paramParcel.writeLong(this.fVe);
    paramParcel.writeLong(this.fVf);
    paramParcel.writeLong(this.fVg);
    paramParcel.writeLong(this.fVh);
    paramParcel.writeLong(this.fVi);
    paramParcel.writeLong(this.fVj);
    paramParcel.writeLong(this.fVk);
    paramParcel.writeLong(this.fVl);
    paramParcel.writeLong(this.fVm);
    paramParcel.writeLong(this.fVn);
    paramParcel.writeLong(this.fVo);
    paramParcel.writeLong(this.fVp);
    paramParcel.writeLong(this.fVq);
    paramParcel.writeString(this.fVr);
    paramParcel.writeString(this.fVs);
    paramParcel.writeString(this.fVt);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */