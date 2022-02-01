package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class LiveConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LiveConfig> CREATOR;
  public static int khT;
  public static int khU;
  public static int khV;
  public static int khW;
  public static int khX;
  public static int khY;
  public static int khZ;
  public static int kia;
  public static int kib;
  private static boolean kil;
  private String desc;
  private int fromScene;
  private int kic;
  private String kid;
  private String kie;
  public HashMap kif;
  private String kig;
  private String kih;
  private int kii;
  private String kij;
  private long kik;
  private String kim;
  private String kin;
  private String kio;
  private long kip;
  private long kiq;
  private String kir;
  private boolean kis;
  private String kit;
  private int kiu;
  private String kiv;
  private long kiw;
  private long liveId;
  private String nonceId;
  private int scene;
  private String sessionBuffer;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(254191);
    khT = 0;
    khU = 1;
    khV = 2;
    khW = 0;
    khX = 1;
    khY = 2;
    khZ = 1;
    kia = 2;
    kib = 0;
    kil = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(254191);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(254159);
    this.kic = khW;
    this.liveId = 0L;
    this.kid = "";
    this.kie = "";
    this.kif = new HashMap();
    this.thumbUrl = "";
    this.kig = "";
    this.scene = khT;
    this.fromScene = kib;
    this.kih = "";
    this.kii = 0;
    this.kij = "";
    this.kik = 0L;
    this.desc = "";
    this.nonceId = "";
    this.kim = "";
    this.kin = "";
    this.kio = "";
    this.kip = 0L;
    this.kiq = 0L;
    this.sessionBuffer = "";
    this.kir = "";
    this.kis = false;
    this.kit = "";
    this.kiu = 0;
    this.kiv = "";
    this.kiw = 0L;
    AppMethodBeat.o(254159);
  }
  
  protected LiveConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(254180);
    this.kic = khW;
    this.liveId = 0L;
    this.kid = "";
    this.kie = "";
    this.kif = new HashMap();
    this.thumbUrl = "";
    this.kig = "";
    this.scene = khT;
    this.fromScene = kib;
    this.kih = "";
    this.kii = 0;
    this.kij = "";
    this.kik = 0L;
    this.desc = "";
    this.nonceId = "";
    this.kim = "";
    this.kin = "";
    this.kio = "";
    this.kip = 0L;
    this.kiq = 0L;
    this.sessionBuffer = "";
    this.kir = "";
    this.kis = false;
    this.kit = "";
    this.kiu = 0;
    this.kiv = "";
    this.kiw = 0L;
    this.kic = paramParcel.readInt();
    this.kif = ((HashMap)paramParcel.readSerializable());
    this.kid = paramParcel.readString();
    this.liveId = paramParcel.readLong();
    this.kie = paramParcel.readString();
    this.thumbUrl = paramParcel.readString();
    this.kig = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    this.kih = paramParcel.readString();
    this.kii = paramParcel.readInt();
    this.kik = paramParcel.readLong();
    this.nonceId = paramParcel.readString();
    this.kim = paramParcel.readString();
    this.kin = paramParcel.readString();
    this.kio = paramParcel.readString();
    this.kip = paramParcel.readLong();
    this.kiq = paramParcel.readLong();
    this.desc = paramParcel.readString();
    this.sessionBuffer = paramParcel.readString();
    this.kir = paramParcel.readString();
    if (paramParcel.readByte() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.kis = bool;
      this.kit = paramParcel.readString();
      this.kiu = paramParcel.readInt();
      this.kij = paramParcel.readString();
      this.kiv = paramParcel.readString();
      this.kiw = paramParcel.readLong();
      AppMethodBeat.o(254180);
      return;
    }
  }
  
  public static boolean aJr()
  {
    if (BuildInfo.DEBUG) {
      return false;
    }
    return kil;
  }
  
  public static LiveConfig an(String paramString, int paramInt)
  {
    AppMethodBeat.i(254160);
    a locala = new a();
    locala.kic = khW;
    locala.kid = paramString;
    locala.kig = z.bcZ();
    locala.scene = paramInt;
    paramString = locala.aJw();
    AppMethodBeat.o(254160);
    return paramString;
  }
  
  public static LiveConfig c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(254161);
    a locala = new a();
    locala.kic = khX;
    locala.thumbUrl = paramString2;
    locala.kid = paramString3;
    locala.liveId = 0L;
    locala.kie = paramString1;
    locala.kig = paramString4;
    paramString1 = locala.aJw();
    AppMethodBeat.o(254161);
    return paramString1;
  }
  
  public static void eS(boolean paramBoolean)
  {
    kil = paramBoolean;
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(254168);
    this.kif.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(254168);
  }
  
  public final void Nc(String paramString)
  {
    this.kir = paramString;
  }
  
  public final void Nd(String paramString)
  {
    this.kit = paramString;
  }
  
  public final int aJf()
  {
    return this.kic;
  }
  
  public final String aJg()
  {
    return this.kid;
  }
  
  public final String aJh()
  {
    return this.kij;
  }
  
  public final String aJi()
  {
    return this.thumbUrl;
  }
  
  public final String aJj()
  {
    return this.kie;
  }
  
  public final String aJk()
  {
    return this.kig;
  }
  
  public final String aJl()
  {
    return this.kih;
  }
  
  public final int aJm()
  {
    return this.kii;
  }
  
  public final long aJn()
  {
    return this.kik;
  }
  
  public final String aJo()
  {
    return this.kir;
  }
  
  public final boolean aJp()
  {
    return this.kis;
  }
  
  public final int aJq()
  {
    return this.kiu;
  }
  
  public final String aJs()
  {
    return this.kiv;
  }
  
  public final long aJt()
  {
    return this.kiw;
  }
  
  public final String aiL()
  {
    return this.kit;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getDesc()
  {
    return this.desc;
  }
  
  public final int getFromScene()
  {
    return this.fromScene;
  }
  
  public final long getLiveId()
  {
    return this.liveId;
  }
  
  public final String getNonceId()
  {
    return this.nonceId;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public final String getSessionBuffer()
  {
    return this.sessionBuffer;
  }
  
  public final String info()
  {
    AppMethodBeat.i(254182);
    int i = this.kic;
    String str3 = this.kid;
    long l1 = this.liveId;
    String str4 = this.kie;
    String str5 = this.kig;
    int j = this.scene;
    int k = this.fromScene;
    long l2 = this.kik;
    String str6 = this.kim;
    String str7 = this.kin;
    long l3 = this.kip;
    long l4 = this.kiq;
    String str8 = this.desc;
    String str9 = this.kiv;
    String str2 = this.sessionBuffer;
    String str1;
    if (Util.isNullOrNil(str2)) {
      str1 = "";
    }
    for (;;)
    {
      str1 = String.format("toWhere:%s,hostRoomId:%s,liveId:%s,liveName:%s,anchorUsername:%s,scene:%s,fromScene:%s, finderObjectId:%s, linkAnchorUsername:%s, linkAnchorNickname:%s,linkFinderObjectId:%s, linkFinderLiveId:%s, desc:%s, nicknameOption:%s sessionBuffer:%s", new Object[] { Integer.valueOf(i), str3, Long.valueOf(l1), str4, str5, Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l2), str6, str7, Long.valueOf(l3), Long.valueOf(l4), str8, str9, str1 });
      AppMethodBeat.o(254182);
      return str1;
      str1 = str2;
      if (str2.length() > 0)
      {
        str1 = str2;
        if (8 < str2.length()) {
          str1 = str2.substring(0, 8);
        }
      }
    }
  }
  
  public final void sO(int paramInt)
  {
    this.kiu = paramInt;
  }
  
  public final void setLiveId(long paramLong)
  {
    this.liveId = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(254178);
    paramParcel.writeInt(this.kic);
    paramParcel.writeSerializable(this.kif);
    paramParcel.writeString(this.kid);
    paramParcel.writeLong(this.liveId);
    paramParcel.writeString(this.kie);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.kig);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    paramParcel.writeString(this.kih);
    paramParcel.writeInt(this.kii);
    paramParcel.writeLong(this.kik);
    paramParcel.writeString(this.nonceId);
    paramParcel.writeString(this.kim);
    paramParcel.writeString(this.kin);
    paramParcel.writeString(this.kio);
    paramParcel.writeLong(this.kip);
    paramParcel.writeLong(this.kiq);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.sessionBuffer);
    paramParcel.writeString(this.kir);
    if (this.kis) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.kit);
      paramParcel.writeInt(this.kiu);
      paramParcel.writeString(this.kij);
      paramParcel.writeString(Util.nullAs(this.kiv, ""));
      paramParcel.writeLong(this.kiw);
      AppMethodBeat.o(254178);
      return;
    }
  }
  
  public static final class a
  {
    private String desc = "";
    public int fromScene = LiveConfig.kib;
    public int kic = LiveConfig.khW;
    public String kid = "";
    public String kie = "";
    public String kig = "";
    private String kih = "";
    private int kii = 0;
    private String kij = "";
    private long kik = 0L;
    private String kim = "";
    private String kin = "";
    private String kio = "";
    private long kip = 0L;
    private long kiq = 0L;
    private boolean kis = false;
    private String kit = "";
    private int kiu = 0;
    private long kiw = 0L;
    private String kix = "";
    private String kiy = "";
    public long liveId = 0L;
    private String nonceId = "";
    public int scene = LiveConfig.khT;
    private String sessionBuffer = "";
    public String thumbUrl = "";
    
    public final a Fx(long paramLong)
    {
      this.liveId = paramLong;
      return this;
    }
    
    public final a Fy(long paramLong)
    {
      this.kik = paramLong;
      return this;
    }
    
    public final a Fz(long paramLong)
    {
      this.kiw = paramLong;
      return this;
    }
    
    public final a Ne(String paramString)
    {
      this.kid = paramString;
      return this;
    }
    
    public final a Nf(String paramString)
    {
      this.nonceId = paramString;
      return this;
    }
    
    public final a Ng(String paramString)
    {
      this.kie = paramString;
      return this;
    }
    
    public final a Nh(String paramString)
    {
      this.thumbUrl = paramString;
      return this;
    }
    
    public final a Ni(String paramString)
    {
      this.kig = paramString;
      return this;
    }
    
    public final a Nj(String paramString)
    {
      this.kih = paramString;
      return this;
    }
    
    public final a Nk(String paramString)
    {
      this.desc = paramString;
      return this;
    }
    
    public final a Nl(String paramString)
    {
      this.kim = paramString;
      return this;
    }
    
    public final a Nm(String paramString)
    {
      this.kin = paramString;
      return this;
    }
    
    public final a Nn(String paramString)
    {
      this.kio = paramString;
      return this;
    }
    
    public final a No(String paramString)
    {
      this.sessionBuffer = paramString;
      return this;
    }
    
    public final a Np(String paramString)
    {
      this.kix = paramString;
      return this;
    }
    
    public final a Nq(String paramString)
    {
      this.kij = paramString;
      return this;
    }
    
    public final a Nr(String paramString)
    {
      this.kiy = paramString;
      return this;
    }
    
    public final a aJu()
    {
      this.kip = 0L;
      return this;
    }
    
    public final a aJv()
    {
      this.kiq = 0L;
      return this;
    }
    
    public final LiveConfig aJw()
    {
      AppMethodBeat.i(254155);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.kic);
      LiveConfig.a(localLiveConfig, this.kid);
      LiveConfig.a(localLiveConfig, this.liveId);
      LiveConfig.b(localLiveConfig, this.kie);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.kig);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      LiveConfig.e(localLiveConfig, this.kih);
      LiveConfig.d(localLiveConfig, this.kii);
      LiveConfig.b(localLiveConfig, this.kik);
      LiveConfig.f(localLiveConfig, this.desc);
      LiveConfig.g(localLiveConfig, this.nonceId);
      LiveConfig.h(localLiveConfig, this.kim);
      LiveConfig.c(localLiveConfig, this.kip);
      LiveConfig.d(localLiveConfig, this.kiq);
      LiveConfig.i(localLiveConfig, this.kin);
      LiveConfig.j(localLiveConfig, this.kio);
      LiveConfig.k(localLiveConfig, this.sessionBuffer);
      LiveConfig.l(localLiveConfig, this.kix);
      LiveConfig.a(localLiveConfig, this.kis);
      LiveConfig.m(localLiveConfig, this.kit);
      LiveConfig.e(localLiveConfig, this.kiu);
      LiveConfig.n(localLiveConfig, this.kij);
      LiveConfig.o(localLiveConfig, this.kiy);
      LiveConfig.e(localLiveConfig, this.kiw);
      AppMethodBeat.o(254155);
      return localLiveConfig;
    }
    
    public final a f(Boolean paramBoolean)
    {
      AppMethodBeat.i(254151);
      this.kis = paramBoolean.booleanValue();
      AppMethodBeat.o(254151);
      return this;
    }
    
    public final a sP(int paramInt)
    {
      this.kic = paramInt;
      return this;
    }
    
    public final a sQ(int paramInt)
    {
      this.kii = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */