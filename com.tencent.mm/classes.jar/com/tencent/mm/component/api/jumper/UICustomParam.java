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
  public float gLH;
  public float gLI;
  public float gLJ;
  public float gLK;
  public Map<String, Boolean> gLL;
  public int gLM;
  public int gLN;
  public int gLO;
  public String gLP;
  public int gLQ;
  public float gLR;
  public int gLS;
  public float gLT;
  public int previewHeight;
  public int previewWidth;
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
    this.gLH = 0.0F;
    this.gLI = 0.0F;
    this.gLJ = 0.0F;
    this.gLK = 0.0F;
    this.gLM = 0;
    this.gLN = 0;
    this.gLO = 0;
    this.text = "";
    this.gLP = "";
    this.gLQ = 0;
    this.gLR = 0.0F;
    this.gLS = 0;
    this.previewWidth = -1;
    this.previewHeight = -1;
    this.gLT = -1.0F;
    this.gLL = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.gLH = 0.0F;
    this.gLI = 0.0F;
    this.gLJ = 0.0F;
    this.gLK = 0.0F;
    this.gLM = 0;
    this.gLN = 0;
    this.gLO = 0;
    this.text = "";
    this.gLP = "";
    this.gLQ = 0;
    this.gLR = 0.0F;
    this.gLS = 0;
    this.previewWidth = -1;
    this.previewHeight = -1;
    this.gLT = -1.0F;
    this.gLH = paramParcel.readFloat();
    this.gLI = paramParcel.readFloat();
    this.gLJ = paramParcel.readFloat();
    this.gLK = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.gLL = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.gLL.put(str, localBoolean);
      i += 1;
    }
    this.gLM = paramParcel.readInt();
    this.gLN = paramParcel.readInt();
    this.gLO = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.gLP = paramParcel.readString();
    this.gLQ = paramParcel.readInt();
    this.gLR = paramParcel.readFloat();
    this.gLS = paramParcel.readInt();
    this.previewWidth = paramParcel.readInt();
    this.previewHeight = paramParcel.readInt();
    this.gLT = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.gLH);
    paramParcel.writeFloat(this.gLI);
    paramParcel.writeFloat(this.gLJ);
    paramParcel.writeFloat(this.gLK);
    paramParcel.writeInt(this.gLL.size());
    Iterator localIterator = this.gLL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.gLM);
    paramParcel.writeInt(this.gLN);
    paramParcel.writeInt(this.gLO);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.gLP);
    paramParcel.writeInt(this.gLQ);
    paramParcel.writeFloat(this.gLR);
    paramParcel.writeInt(this.gLS);
    paramParcel.writeInt(this.previewWidth);
    paramParcel.writeInt(this.previewHeight);
    paramParcel.writeFloat(this.gLT);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam gLU;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.gLU = new UICustomParam((byte)0);
      this.gLU.gLL.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a apz()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.apE();
      locala.apD();
      locala.dz(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a L(String paramString, int paramInt)
    {
      this.gLU.gLP = paramString;
      this.gLU.gLQ = paramInt;
      this.gLU.gLR = 17.0F;
      return this;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.gLU.gLM = paramInt1;
      this.gLU.gLN = paramInt2;
      this.gLU.text = paramString;
      this.gLU.gLO = paramInt3;
      return this;
    }
    
    public final a ai(float paramFloat)
    {
      this.gLU.gLT = paramFloat;
      return this;
    }
    
    public final a apA()
    {
      this.gLU.gLH = 0.6F;
      this.gLU.gLI = 0.6F;
      return this;
    }
    
    public final a apB()
    {
      this.gLU.gLJ = 0.5F;
      this.gLU.gLK = 0.5F;
      return this;
    }
    
    public final a apC()
    {
      AppMethodBeat.i(168709);
      this.gLU.gLL.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a apD()
    {
      AppMethodBeat.i(101478);
      this.gLU.gLL.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a apE()
    {
      AppMethodBeat.i(101479);
      this.gLU.gLL.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a apF()
    {
      AppMethodBeat.i(168711);
      this.gLU.gLL.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final UICustomParam apG()
    {
      return this.gLU;
    }
    
    public final a dv(boolean paramBoolean)
    {
      AppMethodBeat.i(207033);
      this.gLU.gLL.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(207033);
      return this;
    }
    
    public final a dw(boolean paramBoolean)
    {
      AppMethodBeat.i(207034);
      this.gLU.gLL.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(207034);
      return this;
    }
    
    public final a dx(boolean paramBoolean)
    {
      AppMethodBeat.i(207035);
      this.gLU.gLL.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(207035);
      return this;
    }
    
    public final a dy(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.gLU.gLL.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a dz(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.gLU.gLL.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a oG(int paramInt)
    {
      this.gLU.gLS = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */