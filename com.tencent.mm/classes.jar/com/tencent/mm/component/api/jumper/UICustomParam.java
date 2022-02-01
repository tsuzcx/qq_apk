package com.tencent.mm.component.api.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UICustomParam
  implements Parcelable
{
  public static final Parcelable.Creator<UICustomParam> CREATOR;
  public int aNa;
  public int aNb;
  public int fKA;
  public int fKB;
  public String fKC;
  public int fKD;
  public float fKE;
  public int fKF;
  public float fKG;
  public float fKu;
  public float fKv;
  public float fKw;
  public float fKx;
  public Map<String, Boolean> fKy;
  public int fKz;
  public String text;
  
  static
  {
    AppMethodBeat.i(101484);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101484);
  }
  
  private UICustomParam()
  {
    AppMethodBeat.i(101481);
    this.fKu = 0.0F;
    this.fKv = 0.0F;
    this.fKw = 0.0F;
    this.fKx = 0.0F;
    this.fKz = 0;
    this.fKA = 0;
    this.fKB = 0;
    this.text = "";
    this.fKC = "";
    this.fKD = 0;
    this.fKE = 0.0F;
    this.fKF = 0;
    this.aNa = -1;
    this.aNb = -1;
    this.fKG = -1.0F;
    this.fKy = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.fKu = 0.0F;
    this.fKv = 0.0F;
    this.fKw = 0.0F;
    this.fKx = 0.0F;
    this.fKz = 0;
    this.fKA = 0;
    this.fKB = 0;
    this.text = "";
    this.fKC = "";
    this.fKD = 0;
    this.fKE = 0.0F;
    this.fKF = 0;
    this.aNa = -1;
    this.aNb = -1;
    this.fKG = -1.0F;
    this.fKu = paramParcel.readFloat();
    this.fKv = paramParcel.readFloat();
    this.fKw = paramParcel.readFloat();
    this.fKx = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.fKy = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.fKy.put(str, localBoolean);
      i += 1;
    }
    this.fKz = paramParcel.readInt();
    this.fKA = paramParcel.readInt();
    this.fKB = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.fKC = paramParcel.readString();
    this.fKD = paramParcel.readInt();
    this.fKE = paramParcel.readFloat();
    this.fKF = paramParcel.readInt();
    this.aNa = paramParcel.readInt();
    this.aNb = paramParcel.readInt();
    this.fKG = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.fKu);
    paramParcel.writeFloat(this.fKv);
    paramParcel.writeFloat(this.fKw);
    paramParcel.writeFloat(this.fKx);
    paramParcel.writeInt(this.fKy.size());
    Iterator localIterator = this.fKy.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.fKz);
    paramParcel.writeInt(this.fKA);
    paramParcel.writeInt(this.fKB);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.fKC);
    paramParcel.writeInt(this.fKD);
    paramParcel.writeFloat(this.fKE);
    paramParcel.writeInt(this.fKF);
    paramParcel.writeInt(this.aNa);
    paramParcel.writeInt(this.aNb);
    paramParcel.writeFloat(this.fKG);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam fKH;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.fKH = new UICustomParam((byte)0);
      this.fKH.fKy.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a YS()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.YX();
      locala.YW();
      locala.cN(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a G(String paramString, int paramInt)
    {
      this.fKH.fKC = paramString;
      this.fKH.fKD = paramInt;
      this.fKH.fKE = 17.0F;
      return this;
    }
    
    public final a YT()
    {
      this.fKH.fKu = 0.6F;
      this.fKH.fKv = 0.6F;
      return this;
    }
    
    public final a YU()
    {
      this.fKH.fKw = 0.5F;
      this.fKH.fKx = 0.5F;
      return this;
    }
    
    public final a YV()
    {
      AppMethodBeat.i(168709);
      this.fKH.fKy.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a YW()
    {
      AppMethodBeat.i(101478);
      this.fKH.fKy.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a YX()
    {
      AppMethodBeat.i(101479);
      this.fKH.fKy.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a YY()
    {
      AppMethodBeat.i(168711);
      this.fKH.fKy.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final a YZ()
    {
      this.fKH.fKG = 0.8571429F;
      return this;
    }
    
    public final UICustomParam Za()
    {
      return this.fKH;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.fKH.fKz = paramInt1;
      this.fKH.fKA = paramInt2;
      this.fKH.text = paramString;
      this.fKH.fKB = paramInt3;
      return this;
    }
    
    public final a cJ(boolean paramBoolean)
    {
      AppMethodBeat.i(199481);
      this.fKH.fKy.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(199481);
      return this;
    }
    
    public final a cK(boolean paramBoolean)
    {
      AppMethodBeat.i(199482);
      this.fKH.fKy.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(199482);
      return this;
    }
    
    public final a cL(boolean paramBoolean)
    {
      AppMethodBeat.i(199483);
      this.fKH.fKy.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(199483);
      return this;
    }
    
    public final a cM(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.fKH.fKy.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a cN(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.fKH.fKy.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a lc(int paramInt)
    {
      this.fKH.fKF = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */