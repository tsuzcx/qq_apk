package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r
  extends a<y>
{
  public static final int CTRL_INDEX = 902;
  public static final String NAME = "openMapApp";
  double latitude;
  double longitude;
  final s sag;
  Map<String, String> sah;
  protected LocationInfo sai;
  protected LocationInfo saj;
  protected d sak;
  
  public r()
  {
    AppMethodBeat.i(329229);
    this.latitude = 0.0D;
    this.longitude = 0.0D;
    this.sag = new s();
    this.sai = new LocationInfo((byte)0);
    this.saj = new LocationInfo((byte)0);
    AppMethodBeat.o(329229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.r
 * JD-Core Version:    0.7.0.1
 */