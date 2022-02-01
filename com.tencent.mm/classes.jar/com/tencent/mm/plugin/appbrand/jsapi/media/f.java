package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 532;
  public static final String NAME = "chooseMessageFile";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f
 * JD-Core Version:    0.7.0.1
 */