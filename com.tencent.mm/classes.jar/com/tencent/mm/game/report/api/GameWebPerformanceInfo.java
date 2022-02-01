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
  private static Map<String, GameWebPerformanceInfo> gsL;
  public long gsA;
  public long gsB;
  public long gsC;
  public long gsD;
  public long gsE;
  public long gsF;
  public long gsG;
  public long gsH;
  public String gsI;
  public String gsJ;
  public String gsK;
  public String gse;
  public int gsf;
  public int gsg;
  public int gsh;
  public int gsi;
  public int gsj;
  public int gsk;
  public int gsl;
  public int gsm;
  public String gsn;
  public long gso;
  public long gsp;
  public long gsq;
  public long gsr;
  public long gss;
  public long gst;
  public long gsu;
  public long gsv;
  public long gsw;
  public long gsx;
  public long gsy;
  public long gsz;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    gsL = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.gse = paramParcel.readString();
    this.gsf = paramParcel.readInt();
    this.gsg = paramParcel.readInt();
    this.gsh = paramParcel.readInt();
    this.gsi = paramParcel.readInt();
    this.gsj = paramParcel.readInt();
    this.gsk = paramParcel.readInt();
    this.gsl = paramParcel.readInt();
    this.gsm = paramParcel.readInt();
    this.gsn = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.gso = paramParcel.readLong();
    this.gsp = paramParcel.readLong();
    this.gsq = paramParcel.readLong();
    this.gsr = paramParcel.readLong();
    this.gss = paramParcel.readLong();
    this.gst = paramParcel.readLong();
    this.gsu = paramParcel.readLong();
    this.gsv = paramParcel.readLong();
    this.gsw = paramParcel.readLong();
    this.gsx = paramParcel.readLong();
    this.gsy = paramParcel.readLong();
    this.gsz = paramParcel.readLong();
    this.gsA = paramParcel.readLong();
    this.gsB = paramParcel.readLong();
    this.gsC = paramParcel.readLong();
    this.gsD = paramParcel.readLong();
    this.gsE = paramParcel.readLong();
    this.gsF = paramParcel.readLong();
    this.gsG = paramParcel.readLong();
    this.gsH = paramParcel.readLong();
    this.gsI = paramParcel.readString();
    this.gsJ = paramParcel.readString();
    this.gsK = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo wg(String paramString)
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
        if (gsL.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)gsL.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      gsL.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo wh(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (gsL.containsKey(paramString)) {
        gsL.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      gsL.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo wi(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)gsL.remove(paramString);
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
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.gsf), Integer.valueOf(this.gsg), Integer.valueOf(this.gsh), Integer.valueOf(this.gsi), Integer.valueOf(this.gsj), Integer.valueOf(this.gsl), Integer.valueOf(this.gsm), this.gsn, Long.valueOf(this.startTime), Long.valueOf(this.gso), Long.valueOf(this.gsp), Long.valueOf(this.gss), Long.valueOf(this.gsr), Long.valueOf(this.gss), Long.valueOf(this.gst), Long.valueOf(this.gsu), Long.valueOf(this.gsv), Long.valueOf(this.gsw), Long.valueOf(this.gsx), Long.valueOf(this.gsy), Long.valueOf(this.gsz), Long.valueOf(this.gsA), Long.valueOf(this.gsB), Long.valueOf(this.gsC), Long.valueOf(this.gsD), Long.valueOf(this.gsE), Long.valueOf(this.gsF), this.gsI, this.gsJ, this.gsK });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.gse);
    paramParcel.writeInt(this.gsf);
    paramParcel.writeInt(this.gsg);
    paramParcel.writeInt(this.gsh);
    paramParcel.writeInt(this.gsi);
    paramParcel.writeInt(this.gsj);
    paramParcel.writeInt(this.gsk);
    paramParcel.writeInt(this.gsl);
    paramParcel.writeInt(this.gsm);
    paramParcel.writeString(this.gsn);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.gso);
    paramParcel.writeLong(this.gsp);
    paramParcel.writeLong(this.gsq);
    paramParcel.writeLong(this.gsr);
    paramParcel.writeLong(this.gss);
    paramParcel.writeLong(this.gst);
    paramParcel.writeLong(this.gsu);
    paramParcel.writeLong(this.gsv);
    paramParcel.writeLong(this.gsw);
    paramParcel.writeLong(this.gsx);
    paramParcel.writeLong(this.gsy);
    paramParcel.writeLong(this.gsz);
    paramParcel.writeLong(this.gsA);
    paramParcel.writeLong(this.gsB);
    paramParcel.writeLong(this.gsC);
    paramParcel.writeLong(this.gsD);
    paramParcel.writeLong(this.gsE);
    paramParcel.writeLong(this.gsF);
    paramParcel.writeLong(this.gsG);
    paramParcel.writeLong(this.gsH);
    paramParcel.writeString(this.gsI);
    paramParcel.writeString(this.gsJ);
    paramParcel.writeString(this.gsK);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */