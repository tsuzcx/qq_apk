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
  public static int qsE;
  public static int qsG;
  public static int qsH;
  public static int qsJ;
  public static int qsK;
  public static int qsL;
  public static int qsM;
  public static int qsN;
  public static int qsw;
  private static boolean qvm;
  private long DlB;
  private int fromScene;
  private int qsO;
  private String qsP;
  private String qud;
  private String quk;
  private int scene;
  private String thumbUrl;
  public HashMap vie;
  
  static
  {
    AppMethodBeat.i(203914);
    qsw = 0;
    qsE = 1;
    qsG = 2;
    qsH = 0;
    qsJ = 1;
    qsK = 2;
    qsL = 1;
    qsM = 2;
    qsN = 0;
    qvm = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(203914);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(203908);
    this.qsO = qsH;
    this.DlB = 0L;
    this.qsP = "";
    this.qud = "";
    this.vie = new HashMap();
    this.thumbUrl = "";
    this.quk = "";
    this.scene = qsw;
    this.fromScene = qsN;
    AppMethodBeat.o(203908);
  }
  
  protected LiveConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(203913);
    this.qsO = qsH;
    this.DlB = 0L;
    this.qsP = "";
    this.qud = "";
    this.vie = new HashMap();
    this.thumbUrl = "";
    this.quk = "";
    this.scene = qsw;
    this.fromScene = qsN;
    this.qsO = paramParcel.readInt();
    this.vie = ((HashMap)paramParcel.readSerializable());
    this.qsP = paramParcel.readString();
    this.DlB = paramParcel.readLong();
    this.qud = paramParcel.readString();
    this.quk = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    AppMethodBeat.o(203913);
  }
  
  public static boolean ckK()
  {
    if (h.DEBUG) {
      return false;
    }
    return qvm;
  }
  
  public static LiveConfig db(String paramString, int paramInt)
  {
    AppMethodBeat.i(203909);
    a locala = new a();
    locala.qsO = qsH;
    locala.qsP = paramString;
    locala.quk = u.aqG();
    locala.scene = paramInt;
    paramString = locala.cld();
    AppMethodBeat.o(203909);
    return paramString;
  }
  
  public static void hy(boolean paramBoolean)
  {
    qvm = paramBoolean;
  }
  
  public static LiveConfig z(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(203910);
    a locala = new a();
    locala.qsO = qsJ;
    locala.thumbUrl = paramString2;
    locala.qsP = paramString3;
    locala.DlB = 0L;
    locala.qud = paramString1;
    locala.quk = paramString4;
    paramString1 = locala.cld();
    AppMethodBeat.o(203910);
    return paramString1;
  }
  
  public final void bx(int paramInt, String paramString)
  {
    AppMethodBeat.i(203911);
    this.vie.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(203911);
  }
  
  public final String ckA()
  {
    return this.qsP;
  }
  
  public final long ckB()
  {
    return this.DlB;
  }
  
  public final String ckC()
  {
    return this.qud;
  }
  
  public final String ckD()
  {
    return this.quk;
  }
  
  public final int ckz()
  {
    return this.qsO;
  }
  
  public final String cmT()
  {
    return this.thumbUrl;
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
    AppMethodBeat.i(203912);
    paramParcel.writeInt(this.qsO);
    paramParcel.writeSerializable(this.vie);
    paramParcel.writeString(this.qsP);
    paramParcel.writeLong(this.DlB);
    paramParcel.writeString(this.qud);
    paramParcel.writeString(this.quk);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    AppMethodBeat.o(203912);
  }
  
  public static final class a
  {
    public long DlB = 0L;
    public int fromScene = LiveConfig.qsN;
    public int qsO = LiveConfig.qsH;
    public String qsP = "";
    public String qud = "";
    public String quk = "";
    public int scene = LiveConfig.qsw;
    public String thumbUrl = "";
    
    public final LiveConfig cld()
    {
      AppMethodBeat.i(203907);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.qsO);
      LiveConfig.a(localLiveConfig, this.qsP);
      LiveConfig.a(localLiveConfig, this.DlB);
      LiveConfig.b(localLiveConfig, this.qud);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.quk);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      AppMethodBeat.o(203907);
      return localLiveConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */