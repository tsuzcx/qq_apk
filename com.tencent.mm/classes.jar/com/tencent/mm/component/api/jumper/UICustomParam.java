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
  public int aXs;
  public int aXt;
  public float ggd;
  public float gge;
  public float ggf;
  public float ggg;
  public Map<String, Boolean> ggh;
  public int ggi;
  public int ggj;
  public int ggk;
  public String ggl;
  public int ggm;
  public float ggn;
  public int ggo;
  public float ggp;
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
    this.ggd = 0.0F;
    this.gge = 0.0F;
    this.ggf = 0.0F;
    this.ggg = 0.0F;
    this.ggi = 0;
    this.ggj = 0;
    this.ggk = 0;
    this.text = "";
    this.ggl = "";
    this.ggm = 0;
    this.ggn = 0.0F;
    this.ggo = 0;
    this.aXs = -1;
    this.aXt = -1;
    this.ggp = -1.0F;
    this.ggh = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.ggd = 0.0F;
    this.gge = 0.0F;
    this.ggf = 0.0F;
    this.ggg = 0.0F;
    this.ggi = 0;
    this.ggj = 0;
    this.ggk = 0;
    this.text = "";
    this.ggl = "";
    this.ggm = 0;
    this.ggn = 0.0F;
    this.ggo = 0;
    this.aXs = -1;
    this.aXt = -1;
    this.ggp = -1.0F;
    this.ggd = paramParcel.readFloat();
    this.gge = paramParcel.readFloat();
    this.ggf = paramParcel.readFloat();
    this.ggg = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.ggh = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.ggh.put(str, localBoolean);
      i += 1;
    }
    this.ggi = paramParcel.readInt();
    this.ggj = paramParcel.readInt();
    this.ggk = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.ggl = paramParcel.readString();
    this.ggm = paramParcel.readInt();
    this.ggn = paramParcel.readFloat();
    this.ggo = paramParcel.readInt();
    this.aXs = paramParcel.readInt();
    this.aXt = paramParcel.readInt();
    this.ggp = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.ggd);
    paramParcel.writeFloat(this.gge);
    paramParcel.writeFloat(this.ggf);
    paramParcel.writeFloat(this.ggg);
    paramParcel.writeInt(this.ggh.size());
    Iterator localIterator = this.ggh.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.ggi);
    paramParcel.writeInt(this.ggj);
    paramParcel.writeInt(this.ggk);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.ggl);
    paramParcel.writeInt(this.ggm);
    paramParcel.writeFloat(this.ggn);
    paramParcel.writeInt(this.ggo);
    paramParcel.writeInt(this.aXs);
    paramParcel.writeInt(this.aXt);
    paramParcel.writeFloat(this.ggp);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam ggq;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.ggq = new UICustomParam((byte)0);
      this.ggq.ggh.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a abC()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.abH();
      locala.abG();
      locala.cP(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a K(String paramString, int paramInt)
    {
      this.ggq.ggl = paramString;
      this.ggq.ggm = paramInt;
      this.ggq.ggn = 17.0F;
      return this;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.ggq.ggi = paramInt1;
      this.ggq.ggj = paramInt2;
      this.ggq.text = paramString;
      this.ggq.ggk = paramInt3;
      return this;
    }
    
    public final a abD()
    {
      this.ggq.ggd = 0.6F;
      this.ggq.gge = 0.6F;
      return this;
    }
    
    public final a abE()
    {
      this.ggq.ggf = 0.5F;
      this.ggq.ggg = 0.5F;
      return this;
    }
    
    public final a abF()
    {
      AppMethodBeat.i(168709);
      this.ggq.ggh.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a abG()
    {
      AppMethodBeat.i(101478);
      this.ggq.ggh.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a abH()
    {
      AppMethodBeat.i(101479);
      this.ggq.ggh.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a abI()
    {
      AppMethodBeat.i(168711);
      this.ggq.ggh.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final UICustomParam abJ()
    {
      return this.ggq;
    }
    
    public final a ah(float paramFloat)
    {
      this.ggq.ggp = paramFloat;
      return this;
    }
    
    public final a cL(boolean paramBoolean)
    {
      AppMethodBeat.i(218350);
      this.ggq.ggh.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(218350);
      return this;
    }
    
    public final a cM(boolean paramBoolean)
    {
      AppMethodBeat.i(218351);
      this.ggq.ggh.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(218351);
      return this;
    }
    
    public final a cN(boolean paramBoolean)
    {
      AppMethodBeat.i(218352);
      this.ggq.ggh.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(218352);
      return this;
    }
    
    public final a cO(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.ggq.ggh.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a cP(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.ggq.ggh.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a lD(int paramInt)
    {
      this.ggq.ggo = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */