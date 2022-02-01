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
  public float gdV;
  public float gdW;
  public float gdX;
  public float gdY;
  public Map<String, Boolean> gdZ;
  public int gea;
  public int geb;
  public int gec;
  public String ged;
  public int gee;
  public float gef;
  public int geg;
  public float geh;
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
    this.gdV = 0.0F;
    this.gdW = 0.0F;
    this.gdX = 0.0F;
    this.gdY = 0.0F;
    this.gea = 0;
    this.geb = 0;
    this.gec = 0;
    this.text = "";
    this.ged = "";
    this.gee = 0;
    this.gef = 0.0F;
    this.geg = 0;
    this.aXs = -1;
    this.aXt = -1;
    this.geh = -1.0F;
    this.gdZ = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.gdV = 0.0F;
    this.gdW = 0.0F;
    this.gdX = 0.0F;
    this.gdY = 0.0F;
    this.gea = 0;
    this.geb = 0;
    this.gec = 0;
    this.text = "";
    this.ged = "";
    this.gee = 0;
    this.gef = 0.0F;
    this.geg = 0;
    this.aXs = -1;
    this.aXt = -1;
    this.geh = -1.0F;
    this.gdV = paramParcel.readFloat();
    this.gdW = paramParcel.readFloat();
    this.gdX = paramParcel.readFloat();
    this.gdY = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.gdZ = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.gdZ.put(str, localBoolean);
      i += 1;
    }
    this.gea = paramParcel.readInt();
    this.geb = paramParcel.readInt();
    this.gec = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.ged = paramParcel.readString();
    this.gee = paramParcel.readInt();
    this.gef = paramParcel.readFloat();
    this.geg = paramParcel.readInt();
    this.aXs = paramParcel.readInt();
    this.aXt = paramParcel.readInt();
    this.geh = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.gdV);
    paramParcel.writeFloat(this.gdW);
    paramParcel.writeFloat(this.gdX);
    paramParcel.writeFloat(this.gdY);
    paramParcel.writeInt(this.gdZ.size());
    Iterator localIterator = this.gdZ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.gea);
    paramParcel.writeInt(this.geb);
    paramParcel.writeInt(this.gec);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.ged);
    paramParcel.writeInt(this.gee);
    paramParcel.writeFloat(this.gef);
    paramParcel.writeInt(this.geg);
    paramParcel.writeInt(this.aXs);
    paramParcel.writeInt(this.aXt);
    paramParcel.writeFloat(this.geh);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam gei;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.gei = new UICustomParam((byte)0);
      this.gei.gdZ.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a abt()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.aby();
      locala.abx();
      locala.cP(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a J(String paramString, int paramInt)
    {
      this.gei.ged = paramString;
      this.gei.gee = paramInt;
      this.gei.gef = 17.0F;
      return this;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.gei.gea = paramInt1;
      this.gei.geb = paramInt2;
      this.gei.text = paramString;
      this.gei.gec = paramInt3;
      return this;
    }
    
    public final UICustomParam abA()
    {
      return this.gei;
    }
    
    public final a abu()
    {
      this.gei.gdV = 0.6F;
      this.gei.gdW = 0.6F;
      return this;
    }
    
    public final a abv()
    {
      this.gei.gdX = 0.5F;
      this.gei.gdY = 0.5F;
      return this;
    }
    
    public final a abw()
    {
      AppMethodBeat.i(168709);
      this.gei.gdZ.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a abx()
    {
      AppMethodBeat.i(101478);
      this.gei.gdZ.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a aby()
    {
      AppMethodBeat.i(101479);
      this.gei.gdZ.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a abz()
    {
      AppMethodBeat.i(168711);
      this.gei.gdZ.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final a ah(float paramFloat)
    {
      this.gei.geh = paramFloat;
      return this;
    }
    
    public final a cL(boolean paramBoolean)
    {
      AppMethodBeat.i(209003);
      this.gei.gdZ.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(209003);
      return this;
    }
    
    public final a cM(boolean paramBoolean)
    {
      AppMethodBeat.i(209004);
      this.gei.gdZ.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(209004);
      return this;
    }
    
    public final a cN(boolean paramBoolean)
    {
      AppMethodBeat.i(209005);
      this.gei.gdZ.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(209005);
      return this;
    }
    
    public final a cO(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.gei.gdZ.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a cP(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.gei.gdZ.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a lB(int paramInt)
    {
      this.gei.geg = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */