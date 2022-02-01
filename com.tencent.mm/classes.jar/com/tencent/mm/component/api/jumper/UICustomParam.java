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
  public float jvW;
  public float jvX;
  public float jvY;
  public float jvZ;
  public Map<String, Boolean> jwa;
  public int jwb;
  public int jwc;
  public int jwd;
  public String jwe;
  public int jwf;
  public float jwg;
  public int jwh;
  public float jwi;
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
    this.jvW = 0.0F;
    this.jvX = 0.0F;
    this.jvY = 0.0F;
    this.jvZ = 0.0F;
    this.jwb = 0;
    this.jwc = 0;
    this.jwd = 0;
    this.text = "";
    this.jwe = "";
    this.jwf = 0;
    this.jwg = 0.0F;
    this.jwh = 0;
    this.previewWidth = -1;
    this.previewHeight = -1;
    this.jwi = -1.0F;
    this.jwa = new HashMap();
    AppMethodBeat.o(101481);
  }
  
  protected UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(101482);
    this.jvW = 0.0F;
    this.jvX = 0.0F;
    this.jvY = 0.0F;
    this.jvZ = 0.0F;
    this.jwb = 0;
    this.jwc = 0;
    this.jwd = 0;
    this.text = "";
    this.jwe = "";
    this.jwf = 0;
    this.jwg = 0.0F;
    this.jwh = 0;
    this.previewWidth = -1;
    this.previewHeight = -1;
    this.jwi = -1.0F;
    this.jvW = paramParcel.readFloat();
    this.jvX = paramParcel.readFloat();
    this.jvY = paramParcel.readFloat();
    this.jvZ = paramParcel.readFloat();
    int j = paramParcel.readInt();
    this.jwa = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      String str = paramParcel.readString();
      Boolean localBoolean = (Boolean)paramParcel.readValue(Boolean.class.getClassLoader());
      this.jwa.put(str, localBoolean);
      i += 1;
    }
    this.jwb = paramParcel.readInt();
    this.jwc = paramParcel.readInt();
    this.jwd = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.jwe = paramParcel.readString();
    this.jwf = paramParcel.readInt();
    this.jwg = paramParcel.readFloat();
    this.jwh = paramParcel.readInt();
    this.previewWidth = paramParcel.readInt();
    this.previewHeight = paramParcel.readInt();
    this.jwi = paramParcel.readFloat();
    AppMethodBeat.o(101482);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101483);
    paramParcel.writeFloat(this.jvW);
    paramParcel.writeFloat(this.jvX);
    paramParcel.writeFloat(this.jvY);
    paramParcel.writeFloat(this.jvZ);
    paramParcel.writeInt(this.jwa.size());
    Iterator localIterator = this.jwa.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeValue(localEntry.getValue());
    }
    paramParcel.writeInt(this.jwb);
    paramParcel.writeInt(this.jwc);
    paramParcel.writeInt(this.jwd);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.jwe);
    paramParcel.writeInt(this.jwf);
    paramParcel.writeFloat(this.jwg);
    paramParcel.writeInt(this.jwh);
    paramParcel.writeInt(this.previewWidth);
    paramParcel.writeInt(this.previewHeight);
    paramParcel.writeFloat(this.jwi);
    AppMethodBeat.o(101483);
  }
  
  public static final class a
  {
    public UICustomParam jwj;
    
    public a()
    {
      AppMethodBeat.i(101475);
      this.jwj = new UICustomParam((byte)0);
      this.jwj.jwa.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(101475);
    }
    
    public static a avS()
    {
      AppMethodBeat.i(101476);
      a locala = new a();
      locala.avX();
      locala.avW();
      locala.dZ(true);
      AppMethodBeat.o(101476);
      return locala;
    }
    
    public final a a(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.jwj.jwb = paramInt1;
      this.jwj.jwc = paramInt2;
      this.jwj.text = paramString;
      this.jwj.jwd = paramInt3;
      return this;
    }
    
    public final a ad(String paramString, int paramInt)
    {
      this.jwj.jwe = paramString;
      this.jwj.jwf = paramInt;
      this.jwj.jwg = 17.0F;
      return this;
    }
    
    public final a ah(float paramFloat)
    {
      this.jwj.jwi = paramFloat;
      return this;
    }
    
    public final a avT()
    {
      this.jwj.jvW = 0.6F;
      this.jwj.jvX = 0.6F;
      return this;
    }
    
    public final a avU()
    {
      this.jwj.jvY = 0.5F;
      this.jwj.jvZ = 0.5F;
      return this;
    }
    
    public final a avV()
    {
      AppMethodBeat.i(168709);
      this.jwj.jwa.put("plugin_photo_crop", Boolean.TRUE);
      AppMethodBeat.o(168709);
      return this;
    }
    
    public final a avW()
    {
      AppMethodBeat.i(101478);
      this.jwj.jwa.put("plugin_tip", Boolean.TRUE);
      AppMethodBeat.o(101478);
      return this;
    }
    
    public final a avX()
    {
      AppMethodBeat.i(101479);
      this.jwj.jwa.put("plugin_poi", Boolean.TRUE);
      AppMethodBeat.o(101479);
      return this;
    }
    
    public final a avY()
    {
      AppMethodBeat.i(168711);
      this.jwj.jwa.put("plugin_filter", Boolean.TRUE);
      AppMethodBeat.o(168711);
      return this;
    }
    
    public final UICustomParam avZ()
    {
      return this.jwj;
    }
    
    public final a dV(boolean paramBoolean)
    {
      AppMethodBeat.i(191647);
      this.jwj.jwa.put("plugin_emoji", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(191647);
      return this;
    }
    
    public final a dW(boolean paramBoolean)
    {
      AppMethodBeat.i(191651);
      this.jwj.jwa.put("plugin_text", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(191651);
      return this;
    }
    
    public final a dX(boolean paramBoolean)
    {
      AppMethodBeat.i(191654);
      this.jwj.jwa.put("plugin_music", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(191654);
      return this;
    }
    
    public final a dY(boolean paramBoolean)
    {
      AppMethodBeat.i(168708);
      this.jwj.jwa.put("plugin_video_crop", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168708);
      return this;
    }
    
    public final a dZ(boolean paramBoolean)
    {
      AppMethodBeat.i(168710);
      this.jwj.jwa.put("plugin_menu", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(168710);
      return this;
    }
    
    public final a qY(int paramInt)
    {
      this.jwj.jwh = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */