package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public final class r
  extends a<v>
{
  public static final int CTRL_INDEX = 902;
  public static final String NAME = "openMapApp";
  double latitude;
  double longitude;
  final s oUT;
  Map<String, String> oUU;
  protected LocationInfo oUV;
  protected LocationInfo oUW;
  protected d oUX;
  
  public r()
  {
    AppMethodBeat.i(276149);
    this.latitude = 0.0D;
    this.longitude = 0.0D;
    this.oUT = new s();
    this.oUV = new LocationInfo((byte)0);
    this.oUW = new LocationInfo((byte)0);
    AppMethodBeat.o(276149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.r
 * JD-Core Version:    0.7.0.1
 */