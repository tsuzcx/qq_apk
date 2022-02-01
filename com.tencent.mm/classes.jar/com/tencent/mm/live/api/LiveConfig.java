package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;

public class LiveConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LiveConfig> CREATOR;
  public static int gIX;
  public static int gIY;
  public static int gIZ;
  public static int gJa;
  public static int gJb;
  public static int gJc;
  public static int gJd;
  public static int gJe;
  public static int gJf;
  private static boolean gJm;
  private int fromScene;
  private int gJg;
  private long gJh;
  private String gJi;
  private String gJj;
  public HashMap gJk;
  private String gJl;
  private int scene;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(220207);
    gIX = 0;
    gIY = 1;
    gIZ = 2;
    gJa = 0;
    gJb = 1;
    gJc = 2;
    gJd = 1;
    gJe = 2;
    gJf = 0;
    gJm = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(220207);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(220201);
    this.gJg = gJa;
    this.gJh = 0L;
    this.gJi = "";
    this.gJj = "";
    this.gJk = new HashMap();
    this.thumbUrl = "";
    this.gJl = "";
    this.scene = gIX;
    this.fromScene = gJf;
    AppMethodBeat.o(220201);
  }
  
  protected LiveConfig(Parcel paramParcel)
  {
    AppMethodBeat.i(220206);
    this.gJg = gJa;
    this.gJh = 0L;
    this.gJi = "";
    this.gJj = "";
    this.gJk = new HashMap();
    this.thumbUrl = "";
    this.gJl = "";
    this.scene = gIX;
    this.fromScene = gJf;
    this.gJg = paramParcel.readInt();
    this.gJk = ((HashMap)paramParcel.readSerializable());
    this.gJi = paramParcel.readString();
    this.gJh = paramParcel.readLong();
    this.gJj = paramParcel.readString();
    this.gJl = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fromScene = paramParcel.readInt();
    AppMethodBeat.o(220206);
  }
  
  public static LiveConfig T(String paramString, int paramInt)
  {
    AppMethodBeat.i(220202);
    a locala = new a();
    locala.gJg = gJa;
    locala.gJi = paramString;
    locala.gJl = v.aAC();
    locala.scene = paramInt;
    paramString = locala.alq();
    AppMethodBeat.o(220202);
    return paramString;
  }
  
  public static boolean alp()
  {
    if (j.DEBUG) {
      return false;
    }
    return gJm;
  }
  
  public static LiveConfig b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(220203);
    a locala = new a();
    locala.gJg = gJb;
    locala.thumbUrl = paramString2;
    locala.gJi = paramString3;
    locala.gJh = 0L;
    locala.gJj = paramString1;
    locala.gJl = paramString4;
    paramString1 = locala.alq();
    AppMethodBeat.o(220203);
    return paramString1;
  }
  
  public static void dE(boolean paramBoolean)
  {
    gJm = paramBoolean;
  }
  
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(220204);
    this.gJk.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(220204);
  }
  
  public final int alj()
  {
    return this.gJg;
  }
  
  public final String alk()
  {
    return this.gJi;
  }
  
  public final String all()
  {
    return this.thumbUrl;
  }
  
  public final long alm()
  {
    return this.gJh;
  }
  
  public final String aln()
  {
    return this.gJj;
  }
  
  public final String alo()
  {
    return this.gJl;
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
    AppMethodBeat.i(220205);
    paramParcel.writeInt(this.gJg);
    paramParcel.writeSerializable(this.gJk);
    paramParcel.writeString(this.gJi);
    paramParcel.writeLong(this.gJh);
    paramParcel.writeString(this.gJj);
    paramParcel.writeString(this.gJl);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    AppMethodBeat.o(220205);
  }
  
  public static final class a
  {
    public int fromScene = LiveConfig.gJf;
    public int gJg = LiveConfig.gJa;
    public long gJh = 0L;
    public String gJi = "";
    public String gJj = "";
    public String gJl = "";
    public int scene = LiveConfig.gIX;
    public String thumbUrl = "";
    
    public final LiveConfig alq()
    {
      AppMethodBeat.i(220200);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.gJg);
      LiveConfig.a(localLiveConfig, this.gJi);
      LiveConfig.a(localLiveConfig, this.gJh);
      LiveConfig.b(localLiveConfig, this.gJj);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.gJl);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      AppMethodBeat.o(220200);
      return localLiveConfig;
    }
    
    public final a na(int paramInt)
    {
      this.gJg = paramInt;
      return this;
    }
    
    public final a rq(long paramLong)
    {
      this.gJh = paramLong;
      return this;
    }
    
    public final a xR(String paramString)
    {
      this.gJi = paramString;
      return this;
    }
    
    public final a xS(String paramString)
    {
      this.gJj = paramString;
      return this;
    }
    
    public final a xT(String paramString)
    {
      this.gJl = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */