package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;

public class LiveConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LiveConfig> CREATOR;
  public static int gmF;
  public static int gmG;
  public static int gmH;
  public static int gmI;
  public static int gmJ;
  public static int gmK;
  public static int gmL;
  public static int gmM;
  public static int gmN;
  private static boolean gmU;
  private int fromScene;
  private int gmO;
  private long gmP;
  private String gmQ;
  private String gmR;
  public HashMap gmS;
  private String gmT;
  private int scene;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(192910);
    gmF = 0;
    gmG = 1;
    gmH = 2;
    gmI = 0;
    gmJ = 1;
    gmK = 2;
    gmL = 1;
    gmM = 2;
    gmN = 0;
    gmU = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(192910);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(192904);
    this.gmO = gmI;
    this.gmP = 0L;
    this.gmQ = "";
    this.gmR = "";
    this.gmS = new HashMap();
    this.thumbUrl = "";
    this.gmT = "";
    this.scene = gmF;
    this.fromScene = gmN;
    AppMethodBeat.o(192904);
  }
  
  protected LiveConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(192909);
    this.gmO = gmI;
    this.gmP = 0L;
    this.gmQ = "";
    this.gmR = "";
    this.gmS = new HashMap();
    this.thumbUrl = "";
    this.gmT = "";
    this.scene = gmF;
    this.fromScene = gmN;
    this.gmO = paramParcel.readInt();
    this.gmS = ((HashMap)paramParcel.readSerializable());
    this.gmQ = paramParcel.readString();
    this.gmP = paramParcel.readLong();
    this.gmR = paramParcel.readString();
    this.gmT = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    AppMethodBeat.o(192909);
  }
  
  public static LiveConfig P(String paramString, int paramInt)
  {
    AppMethodBeat.i(192905);
    a locala = new a();
    locala.gmO = gmI;
    locala.gmQ = paramString;
    locala.gmT = u.axw();
    locala.scene = paramInt;
    paramString = locala.aip();
    AppMethodBeat.o(192905);
    return paramString;
  }
  
  public static boolean aio()
  {
    if (h.DEBUG) {
      return false;
    }
    return gmU;
  }
  
  public static LiveConfig c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(192906);
    a locala = new a();
    locala.gmO = gmJ;
    locala.thumbUrl = paramString2;
    locala.gmQ = paramString3;
    locala.gmP = 0L;
    locala.gmR = paramString1;
    locala.gmT = paramString4;
    paramString1 = locala.aip();
    AppMethodBeat.o(192906);
    return paramString1;
  }
  
  public static void dB(boolean paramBoolean)
  {
    gmU = paramBoolean;
  }
  
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(192907);
    this.gmS.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(192907);
  }
  
  public final int aii()
  {
    return this.gmO;
  }
  
  public final String aij()
  {
    return this.gmQ;
  }
  
  public final String aik()
  {
    return this.thumbUrl;
  }
  
  public final long ail()
  {
    return this.gmP;
  }
  
  public final String aim()
  {
    return this.gmR;
  }
  
  public final String ain()
  {
    return this.gmT;
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
    AppMethodBeat.i(192908);
    paramParcel.writeInt(this.gmO);
    paramParcel.writeSerializable(this.gmS);
    paramParcel.writeString(this.gmQ);
    paramParcel.writeLong(this.gmP);
    paramParcel.writeString(this.gmR);
    paramParcel.writeString(this.gmT);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    AppMethodBeat.o(192908);
  }
  
  public static final class a
  {
    public int fromScene = LiveConfig.gmN;
    public int gmO = LiveConfig.gmI;
    public long gmP = 0L;
    public String gmQ = "";
    public String gmR = "";
    public String gmT = "";
    public int scene = LiveConfig.gmF;
    public String thumbUrl = "";
    
    public final LiveConfig aip()
    {
      AppMethodBeat.i(192903);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.gmO);
      LiveConfig.a(localLiveConfig, this.gmQ);
      LiveConfig.a(localLiveConfig, this.gmP);
      LiveConfig.b(localLiveConfig, this.gmR);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.gmT);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      AppMethodBeat.o(192903);
      return localLiveConfig;
    }
    
    public final a my(int paramInt)
    {
      this.gmO = paramInt;
      return this;
    }
    
    public final a pc(long paramLong)
    {
      this.gmP = paramLong;
      return this;
    }
    
    public final a us(String paramString)
    {
      this.gmQ = paramString;
      return this;
    }
    
    public final a ut(String paramString)
    {
      this.gmR = paramString;
      return this;
    }
    
    public final a uu(String paramString)
    {
      this.gmT = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */