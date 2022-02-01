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
  public int aMk;
  public int aMl;
  public float fGN;
  public float fGO;
  public float fGP;
  public float fGQ;
  public Map<String, Boolean> fGR;
  public int fGS;
  public int fGT;
  public int fGU;
  public String fGV;
  public int fGW;
  public float fGX;
  public int fGY;
  public float fGZ;
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
    this.fGN = 0.0F;
    this.fGO = 0.0F;
    this.fGP = 0.0F;
    this.fGQ = 0.0F;
    this.fGS = 0;
    this.fGT = 0;
    this.fGU = 0;
    this.text = "";
    this.fGV = "";
    this.fGW = 0;
    this.fGX = 0.0F;
    this.fGY = 0;
    this.aMk = -1;
    this.aMl = -1;
    this.fGZ = -1.0F;
    this.fGR = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.fGN = 0.0F;
    this.fGO = 0.0F;
    this.fGP = 0.0F;
    this.fGQ = 0.0F;
    this.fGS = 0;
    this.fGT = 0;
    this.fGU = 0;
    this.text = "";
    this.fGV = "";
    this.fGW = 0;
    this.fGX = 0.0F;
    this.fGY = 0;
    this.aMk = -1;
    this.aMl = -1;
    this.fGZ = -1.0F;
    this.fGN = paramParcel.readFloat();
    this.fGO = paramParcel.readFloat();
    this.fGP = paramParcel.readFloat();
    this.fGQ = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.fGR = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.fGR.put(str, localBoolean);
      i += 1;
    }
    this.fGS = paramParcel.readInt();
    this.fGT = paramParcel.readInt();
    this.fGU = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.fGV = paramParcel.readString();
    this.fGW = paramParcel.readInt();
    this.fGX = paramParcel.readFloat();
    this.fGY = paramParcel.readInt();
    this.aMk = paramParcel.readInt();
    this.aMl = paramParcel.readInt();
    this.fGZ = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.fGN);
    paramParcel.writeFloat(this.fGO);
    paramParcel.writeFloat(this.fGP);
    paramParcel.writeFloat(this.fGQ);
    paramParcel.writeInt(this.fGR.size());
    Iterator localIterator = this.fGR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.fGS);
    paramParcel.writeInt(this.fGT);
    paramParcel.writeInt(this.fGU);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.fGV);
    paramParcel.writeInt(this.fGW);
    paramParcel.writeFloat(this.fGX);
    paramParcel.writeInt(this.fGY);
    paramParcel.writeInt(this.aMk);
    paramParcel.writeInt(this.aMl);
    paramParcel.writeFloat(this.fGZ);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam fHa;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.fHa = new UICustomParam((byte)0);
      this.fHa.fGR.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a XV()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.Ya();
      locala.XZ();
      locala.cO(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a G(String paramString, int paramInt)
    {
      this.fHa.fGV = paramString;
      this.fHa.fGW = paramInt;
      this.fHa.fGX = 17.0F;
      return this;
    }
    
    public final a XW()
    {
      this.fHa.fGN = 0.6F;
      this.fHa.fGO = 0.6F;
      return this;
    }
    
    public final a XX()
    {
      this.fHa.fGP = 0.5F;
      this.fHa.fGQ = 0.5F;
      return this;
    }
    
    public final a XY()
    {
      AppMethodBeat.i(168709);
      this.fHa.fGR.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a XZ()
    {
      AppMethodBeat.i(101478);
      this.fHa.fGR.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a Ya()
    {
      AppMethodBeat.i(101479);
      this.fHa.fGR.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a Yb()
    {
      AppMethodBeat.i(168711);
      this.fHa.fGR.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final a Yc()
    {
      this.fHa.fGZ = 0.8571429F;
      return this;
    }
    
    public final UICustomParam Yd()
    {
      return this.fHa;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.fHa.fGS = paramInt1;
      this.fHa.fGT = paramInt2;
      this.fHa.text = paramString;
      this.fHa.fGU = paramInt3;
      return this;
    }
    
    public final a cK(boolean paramBoolean)
    {
      AppMethodBeat.i(186945);
      this.fHa.fGR.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(186945);
      return this;
    }
    
    public final a cL(boolean paramBoolean)
    {
      AppMethodBeat.i(186946);
      this.fHa.fGR.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(186946);
      return this;
    }
    
    public final a cM(boolean paramBoolean)
    {
      AppMethodBeat.i(186947);
      this.fHa.fGR.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(186947);
      return this;
    }
    
    public final a cN(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.fHa.fGR.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a cO(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.fHa.fGR.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a li(int paramInt)
    {
      this.fHa.fGY = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */