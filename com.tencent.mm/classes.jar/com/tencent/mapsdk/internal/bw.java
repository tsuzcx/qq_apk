package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineCity;
import com.tencent.map.sdk.comps.offlinemap.OfflineNation;
import com.tencent.map.sdk.comps.offlinemap.OfflineProvince;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class bw
  extends JsonComposer
{
  @Json(name="name")
  public String a;
  @Json(name="pinyin")
  public String b;
  @Json(name="cityList")
  public List<bw> c;
  
  private OfflineNation a()
  {
    AppMethodBeat.i(222412);
    OfflineNation localOfflineNation = new OfflineNation();
    localOfflineNation.setName(this.a);
    localOfflineNation.setPinyin(this.b);
    AppMethodBeat.o(222412);
    return localOfflineNation;
  }
  
  private OfflineProvince a(List<OfflineCity> paramList)
  {
    AppMethodBeat.i(222404);
    OfflineProvince localOfflineProvince = new OfflineProvince();
    localOfflineProvince.setName(this.a);
    localOfflineProvince.setPinyin(this.b);
    localOfflineProvince.setCities(paramList);
    AppMethodBeat.o(222404);
    return localOfflineProvince;
  }
  
  final OfflineCity a(OfflineProvince paramOfflineProvince)
  {
    AppMethodBeat.i(222420);
    OfflineCity localOfflineCity = new OfflineCity();
    localOfflineCity.setName(this.a);
    localOfflineCity.setPinyin(this.b);
    localOfflineCity.setProvince(paramOfflineProvince);
    AppMethodBeat.o(222420);
    return localOfflineCity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bw
 * JD-Core Version:    0.7.0.1
 */