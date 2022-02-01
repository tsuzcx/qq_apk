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
  private static Map<String, GameWebPerformanceInfo> mur;
  public String mtK;
  public int mtL;
  public int mtM;
  public int mtN;
  public int mtO;
  public int mtP;
  public int mtQ;
  public int mtR;
  public int mtS;
  public String mtT;
  public long mtU;
  public long mtV;
  public long mtW;
  public long mtX;
  public long mtY;
  public long mtZ;
  public long mua;
  public long mub;
  public long muc;
  public long mud;
  public long mue;
  public long muf;
  public long mug;
  public long muh;
  public long mui;
  public long muj;
  public long muk;
  public long mul;
  public long mum;
  public long mun;
  public String muo;
  public String mup;
  public String muq;
  public long startTime;
  public String url;
  
  static
  {
    AppMethodBeat.i(117612);
    CREATOR = new Parcelable.Creator() {};
    mur = new HashMap();
    AppMethodBeat.o(117612);
  }
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117607);
    this.url = paramParcel.readString();
    this.mtK = paramParcel.readString();
    this.mtL = paramParcel.readInt();
    this.mtM = paramParcel.readInt();
    this.mtN = paramParcel.readInt();
    this.mtO = paramParcel.readInt();
    this.mtP = paramParcel.readInt();
    this.mtQ = paramParcel.readInt();
    this.mtR = paramParcel.readInt();
    this.mtS = paramParcel.readInt();
    this.mtT = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.mtU = paramParcel.readLong();
    this.mtV = paramParcel.readLong();
    this.mtW = paramParcel.readLong();
    this.mtX = paramParcel.readLong();
    this.mtY = paramParcel.readLong();
    this.mtZ = paramParcel.readLong();
    this.mua = paramParcel.readLong();
    this.mub = paramParcel.readLong();
    this.muc = paramParcel.readLong();
    this.mud = paramParcel.readLong();
    this.mue = paramParcel.readLong();
    this.muf = paramParcel.readLong();
    this.mug = paramParcel.readLong();
    this.muh = paramParcel.readLong();
    this.mui = paramParcel.readLong();
    this.muj = paramParcel.readLong();
    this.muk = paramParcel.readLong();
    this.mul = paramParcel.readLong();
    this.mum = paramParcel.readLong();
    this.mun = paramParcel.readLong();
    this.muo = paramParcel.readString();
    this.mup = paramParcel.readString();
    this.muq = paramParcel.readString();
    AppMethodBeat.o(117607);
  }
  
  public static GameWebPerformanceInfo EI(String paramString)
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
        if (mur.containsKey(paramString))
        {
          paramString = (GameWebPerformanceInfo)mur.get(paramString);
          AppMethodBeat.o(117609);
          continue;
        }
        localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      }
      finally {}
      GameWebPerformanceInfo localGameWebPerformanceInfo;
      mur.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117609);
      paramString = localGameWebPerformanceInfo;
    }
  }
  
  public static GameWebPerformanceInfo EJ(String paramString)
  {
    try
    {
      AppMethodBeat.i(117610);
      if (mur.containsKey(paramString)) {
        mur.remove(paramString);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = new GameWebPerformanceInfo();
      mur.put(paramString, localGameWebPerformanceInfo);
      AppMethodBeat.o(117610);
      return localGameWebPerformanceInfo;
    }
    finally {}
  }
  
  public static GameWebPerformanceInfo EK(String paramString)
  {
    AppMethodBeat.i(117611);
    paramString = (GameWebPerformanceInfo)mur.remove(paramString);
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
    String str = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", new Object[] { this.url, Integer.valueOf(this.mtL), Integer.valueOf(this.mtM), Integer.valueOf(this.mtN), Integer.valueOf(this.mtO), Integer.valueOf(this.mtP), Integer.valueOf(this.mtR), Integer.valueOf(this.mtS), this.mtT, Long.valueOf(this.startTime), Long.valueOf(this.mtU), Long.valueOf(this.mtV), Long.valueOf(this.mtY), Long.valueOf(this.mtX), Long.valueOf(this.mtY), Long.valueOf(this.mtZ), Long.valueOf(this.mua), Long.valueOf(this.mub), Long.valueOf(this.muc), Long.valueOf(this.mud), Long.valueOf(this.mue), Long.valueOf(this.muf), Long.valueOf(this.mug), Long.valueOf(this.muh), Long.valueOf(this.mui), Long.valueOf(this.muj), Long.valueOf(this.muk), Long.valueOf(this.mul), this.muo, this.mup, this.muq });
    AppMethodBeat.o(117608);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117606);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.mtK);
    paramParcel.writeInt(this.mtL);
    paramParcel.writeInt(this.mtM);
    paramParcel.writeInt(this.mtN);
    paramParcel.writeInt(this.mtO);
    paramParcel.writeInt(this.mtP);
    paramParcel.writeInt(this.mtQ);
    paramParcel.writeInt(this.mtR);
    paramParcel.writeInt(this.mtS);
    paramParcel.writeString(this.mtT);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.mtU);
    paramParcel.writeLong(this.mtV);
    paramParcel.writeLong(this.mtW);
    paramParcel.writeLong(this.mtX);
    paramParcel.writeLong(this.mtY);
    paramParcel.writeLong(this.mtZ);
    paramParcel.writeLong(this.mua);
    paramParcel.writeLong(this.mub);
    paramParcel.writeLong(this.muc);
    paramParcel.writeLong(this.mud);
    paramParcel.writeLong(this.mue);
    paramParcel.writeLong(this.muf);
    paramParcel.writeLong(this.mug);
    paramParcel.writeLong(this.muh);
    paramParcel.writeLong(this.mui);
    paramParcel.writeLong(this.muj);
    paramParcel.writeLong(this.muk);
    paramParcel.writeLong(this.mul);
    paramParcel.writeLong(this.mum);
    paramParcel.writeLong(this.mun);
    paramParcel.writeString(this.muo);
    paramParcel.writeString(this.mup);
    paramParcel.writeString(this.muq);
    AppMethodBeat.o(117606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */