package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class p
  extends a<r>
{
  public static final int CTRL_INDEX = 902;
  public static final String NAME = "openMapApp";
  final q kSc;
  Map<String, String> kSd;
  protected LocationInfo kSe;
  protected LocationInfo kSf;
  protected com.tencent.mm.plugin.location.ui.d kSg;
  double latitude;
  double longitude;
  
  public p()
  {
    AppMethodBeat.i(222554);
    this.latitude = 0.0D;
    this.longitude = 0.0D;
    this.kSc = new q();
    this.kSe = new LocationInfo((byte)0);
    this.kSf = new LocationInfo((byte)0);
    AppMethodBeat.o(222554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.p
 * JD-Core Version:    0.7.0.1
 */