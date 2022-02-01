package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.i;
import java.util.HashMap;

public class LiveConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LiveConfig> CREATOR;
  private static boolean gGD;
  public static int gGo;
  public static int gGp;
  public static int gGq;
  public static int gGr;
  public static int gGs;
  public static int gGt;
  public static int gGu;
  public static int gGv;
  public static int gGw;
  private int fromScene;
  private String gGA;
  public HashMap gGB;
  private String gGC;
  private int gGx;
  private long gGy;
  private String gGz;
  private int scene;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(195639);
    gGo = 0;
    gGp = 1;
    gGq = 2;
    gGr = 0;
    gGs = 1;
    gGt = 2;
    gGu = 1;
    gGv = 2;
    gGw = 0;
    gGD = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(195639);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(195633);
    this.gGx = gGr;
    this.gGy = 0L;
    this.gGz = "";
    this.gGA = "";
    this.gGB = new HashMap();
    this.thumbUrl = "";
    this.gGC = "";
    this.scene = gGo;
    this.fromScene = gGw;
    AppMethodBeat.o(195633);
  }
  
  protected LiveConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(195638);
    this.gGx = gGr;
    this.gGy = 0L;
    this.gGz = "";
    this.gGA = "";
    this.gGB = new HashMap();
    this.thumbUrl = "";
    this.gGC = "";
    this.scene = gGo;
    this.fromScene = gGw;
    this.gGx = paramParcel.readInt();
    this.gGB = ((HashMap)paramParcel.readSerializable());
    this.gGz = paramParcel.readString();
    this.gGy = paramParcel.readLong();
    this.gGA = paramParcel.readString();
    this.gGC = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    AppMethodBeat.o(195638);
  }
  
  public static LiveConfig S(String paramString, int paramInt)
  {
    AppMethodBeat.i(195634);
    a locala = new a();
    locala.gGx = gGr;
    locala.gGz = paramString;
    locala.gGC = u.aAm();
    locala.scene = paramInt;
    paramString = locala.alb();
    AppMethodBeat.o(195634);
    return paramString;
  }
  
  public static boolean ala()
  {
    if (i.DEBUG) {
      return false;
    }
    return gGD;
  }
  
  public static LiveConfig b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(195635);
    a locala = new a();
    locala.gGx = gGs;
    locala.thumbUrl = paramString2;
    locala.gGz = paramString3;
    locala.gGy = 0L;
    locala.gGA = paramString1;
    locala.gGC = paramString4;
    paramString1 = locala.alb();
    AppMethodBeat.o(195635);
    return paramString1;
  }
  
  public static void dD(boolean paramBoolean)
  {
    gGD = paramBoolean;
  }
  
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(195636);
    this.gGB.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(195636);
  }
  
  public final int akU()
  {
    return this.gGx;
  }
  
  public final String akV()
  {
    return this.gGz;
  }
  
  public final String akW()
  {
    return this.thumbUrl;
  }
  
  public final long akX()
  {
    return this.gGy;
  }
  
  public final String akY()
  {
    return this.gGA;
  }
  
  public final String akZ()
  {
    return this.gGC;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getFromScene()
  {
    return this.fromScene;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(195637);
    paramParcel.writeInt(this.gGx);
    paramParcel.writeSerializable(this.gGB);
    paramParcel.writeString(this.gGz);
    paramParcel.writeLong(this.gGy);
    paramParcel.writeString(this.gGA);
    paramParcel.writeString(this.gGC);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    AppMethodBeat.o(195637);
  }
  
  public static final class a
  {
    public int fromScene = LiveConfig.gGw;
    public String gGA = "";
    public String gGC = "";
    public int gGx = LiveConfig.gGr;
    public long gGy = 0L;
    public String gGz = "";
    public int scene = LiveConfig.gGo;
    public String thumbUrl = "";
    
    public final LiveConfig alb()
    {
      AppMethodBeat.i(195632);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.gGx);
      LiveConfig.a(localLiveConfig, this.gGz);
      LiveConfig.a(localLiveConfig, this.gGy);
      LiveConfig.b(localLiveConfig, this.gGA);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.gGC);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      AppMethodBeat.o(195632);
      return localLiveConfig;
    }
    
    public final a mX(int paramInt)
    {
      this.gGx = paramInt;
      return this;
    }
    
    public final a rd(long paramLong)
    {
      this.gGy = paramLong;
      return this;
    }
    
    public final a xi(String paramString)
    {
      this.gGz = paramString;
      return this;
    }
    
    public final a xj(String paramString)
    {
      this.gGA = paramString;
      return this;
    }
    
    public final a xk(String paramString)
    {
      this.gGC = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */