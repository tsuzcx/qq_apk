package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;

public class LiveConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LiveConfig> CREATOR;
  public static int hvQ;
  public static int hvR;
  public static int hvS;
  public static int hvT;
  public static int hvU;
  public static int hvV;
  public static int hvW;
  public static int hvX;
  public static int hvY;
  private static boolean hwf;
  private String desc;
  private int fromScene;
  private int hvZ;
  private String hwa;
  private String hwb;
  public HashMap hwc;
  private String hwd;
  private long hwe;
  private String hwg;
  private String hwh;
  private String hwi;
  private String hwj;
  private long hwk;
  private long hwl;
  private long liveId;
  private int scene;
  private String sessionBuffer;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(224100);
    hvQ = 0;
    hvR = 1;
    hvS = 2;
    hvT = 0;
    hvU = 1;
    hvV = 2;
    hvW = 1;
    hvX = 2;
    hvY = 0;
    hwf = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(224100);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(224093);
    this.hvZ = hvT;
    this.liveId = 0L;
    this.hwa = "";
    this.hwb = "";
    this.hwc = new HashMap();
    this.thumbUrl = "";
    this.hwd = "";
    this.scene = hvQ;
    this.fromScene = hvY;
    this.hwe = 0L;
    this.desc = "";
    this.hwg = "";
    this.hwh = "";
    this.hwi = "";
    this.hwj = "";
    this.hwk = 0L;
    this.hwl = 0L;
    this.sessionBuffer = "";
    AppMethodBeat.o(224093);
  }
  
  protected LiveConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(224098);
    this.hvZ = hvT;
    this.liveId = 0L;
    this.hwa = "";
    this.hwb = "";
    this.hwc = new HashMap();
    this.thumbUrl = "";
    this.hwd = "";
    this.scene = hvQ;
    this.fromScene = hvY;
    this.hwe = 0L;
    this.desc = "";
    this.hwg = "";
    this.hwh = "";
    this.hwi = "";
    this.hwj = "";
    this.hwk = 0L;
    this.hwl = 0L;
    this.sessionBuffer = "";
    this.hvZ = paramParcel.readInt();
    this.hwc = ((HashMap)paramParcel.readSerializable());
    this.hwa = paramParcel.readString();
    this.liveId = paramParcel.readLong();
    this.hwb = paramParcel.readString();
    this.hwd = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    this.hwe = paramParcel.readLong();
    this.hwg = paramParcel.readString();
    this.hwh = paramParcel.readString();
    this.hwi = paramParcel.readString();
    this.hwj = paramParcel.readString();
    this.hwk = paramParcel.readLong();
    this.hwl = paramParcel.readLong();
    this.desc = paramParcel.readString();
    this.sessionBuffer = paramParcel.readString();
    AppMethodBeat.o(224098);
  }
  
  public static LiveConfig V(String paramString, int paramInt)
  {
    AppMethodBeat.i(224094);
    a locala = new a();
    locala.hvZ = hvT;
    locala.hwa = paramString;
    locala.hwd = z.aTY();
    locala.scene = paramInt;
    paramString = locala.aBR();
    AppMethodBeat.o(224094);
    return paramString;
  }
  
  public static boolean aBO()
  {
    if (BuildInfo.DEBUG) {
      return false;
    }
    return hwf;
  }
  
  public static LiveConfig b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(224095);
    a locala = new a();
    locala.hvZ = hvU;
    locala.thumbUrl = paramString2;
    locala.hwa = paramString3;
    locala.liveId = 0L;
    locala.hwb = paramString1;
    locala.hwd = paramString4;
    paramString1 = locala.aBR();
    AppMethodBeat.o(224095);
    return paramString1;
  }
  
  public static void eu(boolean paramBoolean)
  {
    hwf = paramBoolean;
  }
  
  public final void F(int paramInt, String paramString)
  {
    AppMethodBeat.i(224096);
    this.hwc.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(224096);
  }
  
  public final int aBC()
  {
    return this.hvZ;
  }
  
  public final String aBD()
  {
    return this.hwa;
  }
  
  public final String aBE()
  {
    return this.thumbUrl;
  }
  
  public final String aBF()
  {
    return this.hwb;
  }
  
  public final String aBG()
  {
    return this.hwd;
  }
  
  public final long aBH()
  {
    return this.hwe;
  }
  
  public final String aBI()
  {
    return this.hwg;
  }
  
  public final String aBJ()
  {
    return this.hwh;
  }
  
  public final String aBK()
  {
    return this.hwi;
  }
  
  public final String aBL()
  {
    return this.hwj;
  }
  
  public final long aBM()
  {
    return this.hwk;
  }
  
  public final long aBN()
  {
    return this.hwl;
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
    AppMethodBeat.i(224099);
    String str = String.format("toWhere:%s,hostRoomId:%s,liveId:%s,liveName:%s,anchorUsername:%s,scene:%s,fromScene:%s, finderObjectId:%s, linkAnchorUsername:%s, linkAnchorNickname:%s,linkFinderObjectId:%s, linkFinderLiveId:%s, desc:%s, sessionBuffer:%s", new Object[] { Integer.valueOf(this.hvZ), this.hwa, Long.valueOf(this.liveId), this.hwb, this.hwd, Integer.valueOf(this.scene), Integer.valueOf(this.fromScene), Long.valueOf(this.hwe), this.hwh, this.hwi, Long.valueOf(this.hwk), Long.valueOf(this.hwl), this.desc, this.sessionBuffer });
    AppMethodBeat.o(224099);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(224097);
    paramParcel.writeInt(this.hvZ);
    paramParcel.writeSerializable(this.hwc);
    paramParcel.writeString(this.hwa);
    paramParcel.writeLong(this.liveId);
    paramParcel.writeString(this.hwb);
    paramParcel.writeString(this.hwd);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    paramParcel.writeLong(this.hwe);
    paramParcel.writeString(this.hwg);
    paramParcel.writeString(this.hwh);
    paramParcel.writeString(this.hwi);
    paramParcel.writeString(this.hwj);
    paramParcel.writeLong(this.hwk);
    paramParcel.writeLong(this.hwl);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.sessionBuffer);
    AppMethodBeat.o(224097);
  }
  
  public static final class a
  {
    private String desc = "";
    public int fromScene = LiveConfig.hvY;
    public int hvZ = LiveConfig.hvT;
    public String hwa = "";
    public String hwb = "";
    public String hwd = "";
    private long hwe = 0L;
    private String hwg = "";
    private String hwh = "";
    private String hwi = "";
    private String hwj = "";
    private long hwk = 0L;
    private long hwl = 0L;
    public long liveId = 0L;
    public int scene = LiveConfig.hvQ;
    private String sessionBuffer = "";
    public String thumbUrl = "";
    
    public final a Gc(String paramString)
    {
      this.hwa = paramString;
      return this;
    }
    
    public final a Gd(String paramString)
    {
      this.hwg = paramString;
      return this;
    }
    
    public final a Ge(String paramString)
    {
      this.hwb = paramString;
      return this;
    }
    
    public final a Gf(String paramString)
    {
      this.thumbUrl = paramString;
      return this;
    }
    
    public final a Gg(String paramString)
    {
      this.hwd = paramString;
      return this;
    }
    
    public final a Gh(String paramString)
    {
      this.desc = paramString;
      return this;
    }
    
    public final a Gi(String paramString)
    {
      this.hwh = paramString;
      return this;
    }
    
    public final a Gj(String paramString)
    {
      this.hwi = paramString;
      return this;
    }
    
    public final a Gk(String paramString)
    {
      this.hwj = paramString;
      return this;
    }
    
    public final a Gl(String paramString)
    {
      this.sessionBuffer = paramString;
      return this;
    }
    
    public final a aBP()
    {
      this.hwk = 0L;
      return this;
    }
    
    public final a aBQ()
    {
      this.hwl = 0L;
      return this;
    }
    
    public final LiveConfig aBR()
    {
      AppMethodBeat.i(224092);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.hvZ);
      LiveConfig.a(localLiveConfig, this.hwa);
      LiveConfig.a(localLiveConfig, this.liveId);
      LiveConfig.b(localLiveConfig, this.hwb);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.hwd);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      LiveConfig.b(localLiveConfig, this.hwe);
      LiveConfig.e(localLiveConfig, this.desc);
      LiveConfig.f(localLiveConfig, this.hwg);
      LiveConfig.g(localLiveConfig, this.hwh);
      LiveConfig.c(localLiveConfig, this.hwk);
      LiveConfig.d(localLiveConfig, this.hwl);
      LiveConfig.h(localLiveConfig, this.hwi);
      LiveConfig.i(localLiveConfig, this.hwj);
      LiveConfig.j(localLiveConfig, this.sessionBuffer);
      AppMethodBeat.o(224092);
      return localLiveConfig;
    }
    
    public final a qo(int paramInt)
    {
      this.hvZ = paramInt;
      return this;
    }
    
    public final a zt(long paramLong)
    {
      this.liveId = paramLong;
      return this;
    }
    
    public final a zu(long paramLong)
    {
      this.hwe = paramLong;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */