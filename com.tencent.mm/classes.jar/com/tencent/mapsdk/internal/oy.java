package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngDeserializer;
import java.util.List;

public final class oy
  extends JsonComposer
{
  @Json(name="detail")
  public d a;
  
  public final String toString()
  {
    AppMethodBeat.i(221831);
    Object localObject = new StringBuffer("AoiInfo{");
    ((StringBuffer)localObject).append("poiDetail=").append(this.a);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221831);
    return localObject;
  }
  
  public static final class d
    extends JsonComposer
  {
    @Json(ignore=true)
    public int a = -1;
    @Json(name="uid")
    String b;
    @Json(name="name")
    String c;
    @Json(name="alias")
    String d;
    @Json(name="type")
    String e;
    @Json(name="styles")
    List<oy.e> f;
    @Json(name="shinei_id")
    String g;
    @Json(deserializer=LatLngDeserializer.class, name="location")
    LatLng h;
    @Json(name="aoi_info")
    oy.a i;
    @Json(name="sub_pois")
    public List<d> j;
    
    public final String a()
    {
      AppMethodBeat.i(222990);
      if (!TextUtils.isEmpty(this.d))
      {
        str = this.d;
        AppMethodBeat.o(222990);
        return str;
      }
      String str = this.c;
      AppMethodBeat.o(222990);
      return str;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(222999);
      Object localObject = new StringBuffer("PoiDetail{");
      ((StringBuffer)localObject).append("displayId=").append(this.a);
      ((StringBuffer)localObject).append(", poiId='").append(this.b).append('\'');
      ((StringBuffer)localObject).append(", name='").append(this.c).append('\'');
      ((StringBuffer)localObject).append(", alias='").append(this.d).append('\'');
      ((StringBuffer)localObject).append(", type='").append(this.e).append('\'');
      ((StringBuffer)localObject).append(", poiStyles=").append(this.f);
      ((StringBuffer)localObject).append(", indoorId='").append(this.g).append('\'');
      ((StringBuffer)localObject).append(", point=").append(this.h);
      ((StringBuffer)localObject).append(", poiArea=").append(this.i);
      ((StringBuffer)localObject).append(", subPois=").append(this.j);
      ((StringBuffer)localObject).append('}');
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(222999);
      return localObject;
    }
  }
  
  public static final class e
    extends JsonComposer
  {
    @Json(ignore=true)
    BitmapDescriptor a;
    @Json(ignore=true)
    BitmapDescriptor b;
    @Json(name="style_class")
    int c;
    @Json(name="icon_url")
    String d;
    @Json(name="icon_type")
    int e;
    @Json(name="font_color")
    String f;
    @Json(name="font_size")
    int g;
    @Json(name="font_stroke_color")
    String h;
    @Json(name="font_stroke_width")
    int i;
    @Json(name="level")
    int j;
    @Json(name="zindex")
    int k;
    @Json(name="aoi")
    oy.c l;
    
    public final String toString()
    {
      AppMethodBeat.i(222974);
      Object localObject = new StringBuffer("PoiStyle{");
      ((StringBuffer)localObject).append("icon=").append(this.a);
      ((StringBuffer)localObject).append(", type=").append(this.c);
      ((StringBuffer)localObject).append(", iconUrl='").append(this.d).append('\'');
      ((StringBuffer)localObject).append(", iconDisplayType=").append(this.e);
      ((StringBuffer)localObject).append(", fontColor='").append(this.f).append('\'');
      ((StringBuffer)localObject).append(", fontSize=").append(this.g);
      ((StringBuffer)localObject).append(", fontStrokeColor='").append(this.h).append('\'');
      ((StringBuffer)localObject).append(", fontStrokeWidth=").append(this.i);
      ((StringBuffer)localObject).append(", level=").append(this.j);
      ((StringBuffer)localObject).append(", zindex=").append(this.k);
      ((StringBuffer)localObject).append(", aoiStyle=").append(this.l);
      ((StringBuffer)localObject).append('}');
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(222974);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oy
 * JD-Core Version:    0.7.0.1
 */