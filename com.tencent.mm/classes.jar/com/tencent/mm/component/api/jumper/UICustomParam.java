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
  public float lZA;
  public float lZo;
  public float lZp;
  public float lZq;
  public float lZr;
  public Map<String, Boolean> lZs;
  public int lZt;
  public int lZu;
  public int lZv;
  public String lZw;
  public int lZx;
  public float lZy;
  public int lZz;
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
    this.lZo = 0.0F;
    this.lZp = 0.0F;
    this.lZq = 0.0F;
    this.lZr = 0.0F;
    this.lZt = 0;
    this.lZu = 0;
    this.lZv = 0;
    this.text = "";
    this.lZw = "";
    this.lZx = 0;
    this.lZy = 0.0F;
    this.lZz = 0;
    this.previewWidth = -1;
    this.previewHeight = -1;
    this.lZA = -1.0F;
    this.lZs = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.lZo = 0.0F;
    this.lZp = 0.0F;
    this.lZq = 0.0F;
    this.lZr = 0.0F;
    this.lZt = 0;
    this.lZu = 0;
    this.lZv = 0;
    this.text = "";
    this.lZw = "";
    this.lZx = 0;
    this.lZy = 0.0F;
    this.lZz = 0;
    this.previewWidth = -1;
    this.previewHeight = -1;
    this.lZA = -1.0F;
    this.lZo = paramParcel.readFloat();
    this.lZp = paramParcel.readFloat();
    this.lZq = paramParcel.readFloat();
    this.lZr = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.lZs = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.lZs.put(str, localBoolean);
      i += 1;
    }
    this.lZt = paramParcel.readInt();
    this.lZu = paramParcel.readInt();
    this.lZv = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.lZw = paramParcel.readString();
    this.lZx = paramParcel.readInt();
    this.lZy = paramParcel.readFloat();
    this.lZz = paramParcel.readInt();
    this.previewWidth = paramParcel.readInt();
    this.previewHeight = paramParcel.readInt();
    this.lZA = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.lZo);
    paramParcel.writeFloat(this.lZp);
    paramParcel.writeFloat(this.lZq);
    paramParcel.writeFloat(this.lZr);
    paramParcel.writeInt(this.lZs.size());
    Iterator localIterator = this.lZs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.lZt);
    paramParcel.writeInt(this.lZu);
    paramParcel.writeInt(this.lZv);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.lZw);
    paramParcel.writeInt(this.lZx);
    paramParcel.writeFloat(this.lZy);
    paramParcel.writeInt(this.lZz);
    paramParcel.writeInt(this.previewWidth);
    paramParcel.writeInt(this.previewHeight);
    paramParcel.writeFloat(this.lZA);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam lZB;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.lZB = new UICustomParam((byte)0);
      this.lZB.lZs.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a aQr()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.aQw();
      locala.aQv();
      locala.eL(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.lZB.lZt = paramInt1;
      this.lZB.lZu = paramInt2;
      this.lZB.text = paramString;
      this.lZB.lZv = paramInt3;
      return this;
    }
    
    public final a aQs()
    {
      this.lZB.lZo = 0.6F;
      this.lZB.lZp = 0.6F;
      return this;
    }
    
    public final a aQt()
    {
      this.lZB.lZq = 0.5F;
      this.lZB.lZr = 0.5F;
      return this;
    }
    
    public final a aQu()
    {
      AppMethodBeat.i(168709);
      this.lZB.lZs.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a aQv()
    {
      AppMethodBeat.i(101478);
      this.lZB.lZs.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a aQw()
    {
      AppMethodBeat.i(101479);
      this.lZB.lZs.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a aQx()
    {
      AppMethodBeat.i(168711);
      this.lZB.lZs.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final a am(String paramString, int paramInt)
    {
      this.lZB.lZw = paramString;
      this.lZB.lZx = paramInt;
      this.lZB.lZy = 17.0F;
      return this;
    }
    
    public final a bj(float paramFloat)
    {
      this.lZB.lZA = paramFloat;
      return this;
    }
    
    public final a eH(boolean paramBoolean)
    {
      AppMethodBeat.i(231085);
      this.lZB.lZs.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(231085);
      return this;
    }
    
    public final a eI(boolean paramBoolean)
    {
      AppMethodBeat.i(231087);
      this.lZB.lZs.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(231087);
      return this;
    }
    
    public final a eJ(boolean paramBoolean)
    {
      AppMethodBeat.i(231090);
      this.lZB.lZs.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(231090);
      return this;
    }
    
    public final a eK(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.lZB.lZs.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a eL(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.lZB.lZs.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a re(int paramInt)
    {
      this.lZB.lZz = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */