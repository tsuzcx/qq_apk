package com.tencent.mm.game.report.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR = new GameWebPerformanceInfo.1();
  private static Map<String, GameWebPerformanceInfo> dCW = new HashMap();
  public int dCA;
  public int dCB;
  public int dCC;
  public String dCD;
  public long dCE;
  public long dCF;
  public long dCG;
  public long dCH;
  public long dCI;
  public long dCJ;
  public long dCK;
  public long dCL;
  public long dCM;
  public long dCN;
  public long dCO;
  public long dCP;
  public long dCQ;
  public long dCR;
  public long dCS;
  public long dCT;
  public long dCU;
  public long dCV;
  public long startTime;
  public String url;
  
  public GameWebPerformanceInfo() {}
  
  private GameWebPerformanceInfo(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.dCA = paramParcel.readInt();
    this.dCB = paramParcel.readInt();
    this.dCC = paramParcel.readInt();
    this.dCD = paramParcel.readString();
    this.startTime = paramParcel.readLong();
    this.dCE = paramParcel.readLong();
    this.dCF = paramParcel.readLong();
    this.dCG = paramParcel.readLong();
    this.dCH = paramParcel.readLong();
    this.dCI = paramParcel.readLong();
    this.dCJ = paramParcel.readLong();
    this.dCK = paramParcel.readLong();
    this.dCL = paramParcel.readLong();
    this.dCM = paramParcel.readLong();
    this.dCN = paramParcel.readLong();
    this.dCO = paramParcel.readLong();
    this.dCP = paramParcel.readLong();
    this.dCQ = paramParcel.readLong();
    this.dCR = paramParcel.readLong();
    this.dCS = paramParcel.readLong();
    this.dCT = paramParcel.readLong();
    this.dCU = paramParcel.readLong();
    this.dCV = paramParcel.readLong();
  }
  
  /* Error */
  public static GameWebPerformanceInfo fv(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 127	com/tencent/mm/game/report/api/GameWebPerformanceInfo:fx	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 133	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   12: ifeq +16 -> 28
    //   15: new 2	com/tencent/mm/game/report/api/GameWebPerformanceInfo
    //   18: dup
    //   19: invokespecial 134	com/tencent/mm/game/report/api/GameWebPerformanceInfo:<init>	()V
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 53	com/tencent/mm/game/report/api/GameWebPerformanceInfo:dCW	Ljava/util/Map;
    //   31: aload_1
    //   32: invokeinterface 140 2 0
    //   37: ifeq +19 -> 56
    //   40: getstatic 53	com/tencent/mm/game/report/api/GameWebPerformanceInfo:dCW	Ljava/util/Map;
    //   43: aload_1
    //   44: invokeinterface 144 2 0
    //   49: checkcast 2	com/tencent/mm/game/report/api/GameWebPerformanceInfo
    //   52: astore_0
    //   53: goto -30 -> 23
    //   56: new 2	com/tencent/mm/game/report/api/GameWebPerformanceInfo
    //   59: dup
    //   60: invokespecial 134	com/tencent/mm/game/report/api/GameWebPerformanceInfo:<init>	()V
    //   63: astore_0
    //   64: getstatic 53	com/tencent/mm/game/report/api/GameWebPerformanceInfo:dCW	Ljava/util/Map;
    //   67: aload_1
    //   68: aload_0
    //   69: invokeinterface 148 3 0
    //   74: pop
    //   75: goto -52 -> 23
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   7	61	1	str	String
    // Exception table:
    //   from	to	target	type
    //   3	23	78	finally
    //   28	53	78	finally
    //   56	75	78	finally
  }
  
  public static GameWebPerformanceInfo fw(String paramString)
  {
    return (GameWebPerformanceInfo)dCW.remove(fx(paramString));
  }
  
  private static String fx(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    paramString = paramString.getScheme() + "://" + paramString.getHost() + paramString.getPath();
    y.i("MicroMsg.GameWebPerformanceInfo", "getDomainAndPath, newUrl: %s", new Object[] { paramString });
    return paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.dCA);
    paramParcel.writeInt(this.dCB);
    paramParcel.writeInt(this.dCC);
    paramParcel.writeString(this.dCD);
    paramParcel.writeLong(this.startTime);
    paramParcel.writeLong(this.dCE);
    paramParcel.writeLong(this.dCF);
    paramParcel.writeLong(this.dCG);
    paramParcel.writeLong(this.dCH);
    paramParcel.writeLong(this.dCI);
    paramParcel.writeLong(this.dCJ);
    paramParcel.writeLong(this.dCK);
    paramParcel.writeLong(this.dCL);
    paramParcel.writeLong(this.dCM);
    paramParcel.writeLong(this.dCN);
    paramParcel.writeLong(this.dCO);
    paramParcel.writeLong(this.dCP);
    paramParcel.writeLong(this.dCQ);
    paramParcel.writeLong(this.dCR);
    paramParcel.writeLong(this.dCS);
    paramParcel.writeLong(this.dCT);
    paramParcel.writeLong(this.dCU);
    paramParcel.writeLong(this.dCV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.game.report.api.GameWebPerformanceInfo
 * JD-Core Version:    0.7.0.1
 */