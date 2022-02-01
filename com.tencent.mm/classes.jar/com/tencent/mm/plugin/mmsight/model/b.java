package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public final class b
{
  static b vZa;
  public int dHi;
  public long fileSize;
  public int gds;
  public int hrX;
  int hwu;
  int ixR;
  JSONObject kuc;
  String model;
  public int vZA;
  String vZb;
  String vZc;
  int vZd;
  int vZe;
  public String vZf;
  public String vZg;
  public String vZh;
  public String vZi;
  public int vZj;
  public int vZk;
  public int vZl;
  public int vZm;
  public int vZn;
  public int vZo;
  public int vZp;
  public int vZq;
  public int vZr;
  public int vZs;
  public int vZt;
  public int vZu;
  int vZv;
  public int vZw;
  public int vZx;
  public int vZy;
  public long vZz;
  public int videoBitrate;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = Build.MODEL;
    this.vZb = Build.VERSION.SDK_INT;
    this.dHi = 0;
    this.kuc = null;
    AppMethodBeat.o(89348);
  }
  
  public static b dpE()
  {
    AppMethodBeat.i(89349);
    if (vZa == null) {
      reset();
    }
    b localb = vZa;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    vZa = (b)localObject;
    ((b)localObject).ixR = ((ActivityManager)ak.getContext().getSystemService("activity")).getLargeMemoryClass();
    vZa.hwu = d.fT(ak.getContext());
    vZa.vZc = m.aap();
    localObject = d.fS(ak.getContext());
    vZa.vZd = ((Point)localObject).x;
    vZa.vZe = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String dpF()
  {
    AppMethodBeat.i(89351);
    if (this.kuc == null) {}
    for (;;)
    {
      try
      {
        this.kuc = new JSONObject();
        localObject = new JSONObject();
        this.kuc.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.vZb);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.vZd), Integer.valueOf(this.vZe) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.vZj), Integer.valueOf(this.vZk) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.vZl), Integer.valueOf(this.vZm) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.vZn), Integer.valueOf(this.vZo) }));
        ((JSONObject)localObject).put("rotate", this.dHi);
        ((JSONObject)localObject).put("deviceoutfps", this.vZp);
        ((JSONObject)localObject).put("recordfps", this.vZq);
        ((JSONObject)localObject).put("recordertype", this.vZr);
        ((JSONObject)localObject).put("needRotateEachFrame", this.gds);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.vZs);
        ((JSONObject)localObject).put("resolutionLimit", this.hrX);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.vZz);
        ((JSONObject)localObject).put("useback", this.vZA);
        if (k.wat == null) {
          continue;
        }
        i = k.wat.waF;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", com.tencent.mm.compatible.deviceinfo.ae.geT.gdy);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.kuc.toString();
      AppMethodBeat.o(89351);
      return localObject;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b
 * JD-Core Version:    0.7.0.1
 */