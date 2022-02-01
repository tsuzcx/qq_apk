package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class b
{
  static b vMX;
  public int dGc;
  public long fileSize;
  public int gbk;
  public int hpj;
  int htG;
  int iuX;
  JSONObject kqN;
  String model;
  String vMY;
  String vMZ;
  int vNa;
  int vNb;
  public String vNc;
  public String vNd;
  public String vNe;
  public String vNf;
  public int vNg;
  public int vNh;
  public int vNi;
  public int vNj;
  public int vNk;
  public int vNl;
  public int vNm;
  public int vNn;
  public int vNo;
  public int vNp;
  public int vNq;
  public int vNr;
  int vNs;
  public int vNt;
  public int vNu;
  public int vNv;
  public long vNw;
  public int vNx;
  public int videoBitrate;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = Build.MODEL;
    this.vMY = Build.VERSION.SDK_INT;
    this.dGc = 0;
    this.kqN = null;
    AppMethodBeat.o(89348);
  }
  
  public static b dmG()
  {
    AppMethodBeat.i(89349);
    if (vMX == null) {
      reset();
    }
    b localb = vMX;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    vMX = (b)localObject;
    ((b)localObject).iuX = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    vMX.htG = d.fN(aj.getContext());
    vMX.vMZ = m.aag();
    localObject = d.fM(aj.getContext());
    vMX.vNa = ((Point)localObject).x;
    vMX.vNb = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String dmH()
  {
    AppMethodBeat.i(89351);
    if (this.kqN == null) {}
    for (;;)
    {
      try
      {
        this.kqN = new JSONObject();
        localObject = new JSONObject();
        this.kqN.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.vMY);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.vNa), Integer.valueOf(this.vNb) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.vNg), Integer.valueOf(this.vNh) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.vNi), Integer.valueOf(this.vNj) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.vNk), Integer.valueOf(this.vNl) }));
        ((JSONObject)localObject).put("rotate", this.dGc);
        ((JSONObject)localObject).put("deviceoutfps", this.vNm);
        ((JSONObject)localObject).put("recordfps", this.vNn);
        ((JSONObject)localObject).put("recordertype", this.vNo);
        ((JSONObject)localObject).put("needRotateEachFrame", this.gbk);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.vNp);
        ((JSONObject)localObject).put("resolutionLimit", this.hpj);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.vNw);
        ((JSONObject)localObject).put("useback", this.vNx);
        if (k.vOq == null) {
          continue;
        }
        i = k.vOq.vOC;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", ae.gcL.gbq);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        ad.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.kqN.toString();
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