package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public final class q
  extends a<s>
{
  public static final int CTRL_INDEX = 902;
  public static final String NAME = "openMapApp";
  final r lXi;
  Map<String, String> lXj;
  protected LocationInfo lXk;
  protected LocationInfo lXl;
  protected d lXm;
  double latitude;
  double longitude;
  
  public q()
  {
    AppMethodBeat.i(226853);
    this.latitude = 0.0D;
    this.longitude = 0.0D;
    this.lXi = new r();
    this.lXk = new LocationInfo((byte)0);
    this.lXl = new LocationInfo((byte)0);
    AppMethodBeat.o(226853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.q
 * JD-Core Version:    0.7.0.1
 */