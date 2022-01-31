package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class a
{
  static a oGl;
  int eZQ;
  int eqL;
  int fYn;
  long fileSize;
  JSONObject hxd;
  String model;
  public int oGA;
  public int oGB;
  public int oGC;
  int oGD;
  int oGE;
  int oGF;
  int oGG;
  int oGH;
  int oGI;
  int oGJ;
  int oGK;
  public long oGL;
  public int oGM;
  String oGm;
  int oGn;
  String oGo;
  int oGp;
  int oGq;
  public String oGr;
  public String oGs;
  public String oGt;
  public String oGu;
  public int oGv;
  public int oGw;
  public int oGx;
  public int oGy;
  public int oGz;
  public int rotate;
  int videoBitrate;
  
  public a()
  {
    AppMethodBeat.i(76456);
    this.model = Build.MODEL;
    this.oGm = Build.VERSION.SDK_INT;
    this.rotate = 0;
    this.hxd = null;
    AppMethodBeat.o(76456);
  }
  
  public static a bQG()
  {
    AppMethodBeat.i(76457);
    if (oGl == null) {
      reset();
    }
    a locala = oGl;
    AppMethodBeat.o(76457);
    return locala;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(76458);
    Object localObject = new a();
    oGl = (a)localObject;
    ((a)localObject).fYn = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    oGl.oGn = d.ey(ah.getContext());
    oGl.oGo = m.Lp();
    localObject = d.ex(ah.getContext());
    oGl.oGp = ((Point)localObject).x;
    oGl.oGq = ((Point)localObject).y;
    AppMethodBeat.o(76458);
  }
  
  public final String bQH()
  {
    AppMethodBeat.i(76459);
    if (this.hxd == null) {}
    for (;;)
    {
      try
      {
        this.hxd = new JSONObject();
        localObject = new JSONObject();
        this.hxd.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.oGm);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.oGp), Integer.valueOf(this.oGq) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.oGv), Integer.valueOf(this.oGw) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.oGx), Integer.valueOf(this.oGy) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.oGz), Integer.valueOf(this.oGA) }));
        ((JSONObject)localObject).put("rotate", this.rotate);
        ((JSONObject)localObject).put("deviceoutfps", this.oGB);
        ((JSONObject)localObject).put("recordfps", this.oGC);
        ((JSONObject)localObject).put("recordertype", this.oGD);
        ((JSONObject)localObject).put("needRotateEachFrame", this.eqL);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.oGE);
        ((JSONObject)localObject).put("resolutionLimit", this.eZQ);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.oGL);
        ((JSONObject)localObject).put("useback", this.oGM);
        if (j.oHG == null) {
          continue;
        }
        i = j.oHG.oHR;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", ac.erB.eqR);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        ab.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.hxd.toString();
      AppMethodBeat.o(76459);
      return localObject;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a
 * JD-Core Version:    0.7.0.1
 */