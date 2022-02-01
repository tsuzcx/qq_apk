package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class b
{
  static b EYD;
  String EYE;
  String EYF;
  int EYG;
  int EYH;
  public String EYI;
  public String EYJ;
  public String EYK;
  public String EYL;
  public int EYM;
  public int EYN;
  public int EYO;
  public int EYP;
  public int EYQ;
  public int EYR;
  public int EYS;
  public int EYT;
  public int EYU;
  public int EYV;
  public int EYW;
  public int EYX;
  int EYY;
  public int EYZ;
  public int EZa;
  public int EZb;
  public long EZc;
  public int EZd;
  public int fSM;
  public long fileSize;
  public int jti;
  public int laT;
  int lfc;
  int miK;
  String model;
  JSONObject osF;
  public int videoBitrate;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = Build.MODEL;
    this.EYE = Build.VERSION.SDK_INT;
    this.fSM = 0;
    this.osF = null;
    AppMethodBeat.o(89348);
  }
  
  public static b eTa()
  {
    AppMethodBeat.i(89349);
    if (EYD == null) {
      reset();
    }
    b localb = EYD;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    EYD = (b)localObject;
    ((b)localObject).miK = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    EYD.lfc = d.hw(MMApplicationContext.getContext());
    EYD.EYF = m.aut();
    localObject = d.hv(MMApplicationContext.getContext());
    EYD.EYG = ((Point)localObject).x;
    EYD.EYH = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String eTb()
  {
    AppMethodBeat.i(89351);
    if (this.osF == null) {}
    for (;;)
    {
      try
      {
        this.osF = new JSONObject();
        localObject = new JSONObject();
        this.osF.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.EYE);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.EYG), Integer.valueOf(this.EYH) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.EYM), Integer.valueOf(this.EYN) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.EYO), Integer.valueOf(this.EYP) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.EYQ), Integer.valueOf(this.EYR) }));
        ((JSONObject)localObject).put("rotate", this.fSM);
        ((JSONObject)localObject).put("deviceoutfps", this.EYS);
        ((JSONObject)localObject).put("recordfps", this.EYT);
        ((JSONObject)localObject).put("recordertype", this.EYU);
        ((JSONObject)localObject).put("needRotateEachFrame", this.jti);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.EYV);
        ((JSONObject)localObject).put("resolutionLimit", this.laT);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.EZc);
        ((JSONObject)localObject).put("useback", this.EZd);
        if (j.EZX == null) {
          continue;
        }
        i = j.EZX.Faj;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", af.juO.jto);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.osF.toString();
      AppMethodBeat.o(89351);
      return localObject;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b
 * JD-Core Version:    0.7.0.1
 */