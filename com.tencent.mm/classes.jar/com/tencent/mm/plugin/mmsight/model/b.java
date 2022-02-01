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
  static b tBu;
  public int dwp;
  public int fEd;
  public long fileSize;
  int gBc;
  public int gwG;
  int hBa;
  JSONObject jwa;
  String model;
  public String tBA;
  public String tBB;
  public String tBC;
  public int tBD;
  public int tBE;
  public int tBF;
  public int tBG;
  public int tBH;
  public int tBI;
  public int tBJ;
  public int tBK;
  public int tBL;
  public int tBM;
  public int tBN;
  public int tBO;
  int tBP;
  public int tBQ;
  public int tBR;
  public int tBS;
  public long tBT;
  public int tBU;
  String tBv;
  String tBw;
  int tBx;
  int tBy;
  public String tBz;
  public int videoBitrate;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = Build.MODEL;
    this.tBv = Build.VERSION.SDK_INT;
    this.dwp = 0;
    this.jwa = null;
    AppMethodBeat.o(89348);
  }
  
  public static b cPB()
  {
    AppMethodBeat.i(89349);
    if (tBu == null) {
      reset();
    }
    b localb = tBu;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    tBu = (b)localObject;
    ((b)localObject).hBa = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    tBu.gBc = d.fw(aj.getContext());
    tBu.tBw = m.WH();
    localObject = d.fv(aj.getContext());
    tBu.tBx = ((Point)localObject).x;
    tBu.tBy = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String cPC()
  {
    AppMethodBeat.i(89351);
    if (this.jwa == null) {}
    for (;;)
    {
      try
      {
        this.jwa = new JSONObject();
        localObject = new JSONObject();
        this.jwa.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.tBv);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.tBx), Integer.valueOf(this.tBy) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.tBD), Integer.valueOf(this.tBE) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.tBF), Integer.valueOf(this.tBG) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.tBH), Integer.valueOf(this.tBI) }));
        ((JSONObject)localObject).put("rotate", this.dwp);
        ((JSONObject)localObject).put("deviceoutfps", this.tBJ);
        ((JSONObject)localObject).put("recordfps", this.tBK);
        ((JSONObject)localObject).put("recordertype", this.tBL);
        ((JSONObject)localObject).put("needRotateEachFrame", this.fEd);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.tBM);
        ((JSONObject)localObject).put("resolutionLimit", this.gwG);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.tBT);
        ((JSONObject)localObject).put("useback", this.tBU);
        if (k.tCN == null) {
          continue;
        }
        i = k.tCN.tCZ;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", ae.fFD.fEj);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        ad.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.jwa.toString();
      AppMethodBeat.o(89351);
      return localObject;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b
 * JD-Core Version:    0.7.0.1
 */