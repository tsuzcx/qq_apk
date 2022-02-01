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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public final class b
{
  static b uJR;
  public int duc;
  public int fHK;
  public long fileSize;
  public int gXd;
  int hby;
  int ibB;
  JSONObject jWw;
  String model;
  String uJS;
  String uJT;
  int uJU;
  int uJV;
  public String uJW;
  public String uJX;
  public String uJY;
  public String uJZ;
  public int uKa;
  public int uKb;
  public int uKc;
  public int uKd;
  public int uKe;
  public int uKf;
  public int uKg;
  public int uKh;
  public int uKi;
  public int uKj;
  public int uKk;
  public int uKl;
  int uKm;
  public int uKn;
  public int uKo;
  public int uKp;
  public long uKq;
  public int uKr;
  public int videoBitrate;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = Build.MODEL;
    this.uJS = Build.VERSION.SDK_INT;
    this.duc = 0;
    this.jWw = null;
    AppMethodBeat.o(89348);
  }
  
  public static b ddk()
  {
    AppMethodBeat.i(89349);
    if (uJR == null) {
      reset();
    }
    b localb = uJR;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    uJR = (b)localObject;
    ((b)localObject).ibB = ((ActivityManager)ai.getContext().getSystemService("activity")).getLargeMemoryClass();
    uJR.hby = d.fI(ai.getContext());
    uJR.uJT = m.XF();
    localObject = d.fH(ai.getContext());
    uJR.uJU = ((Point)localObject).x;
    uJR.uJV = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String ddl()
  {
    AppMethodBeat.i(89351);
    if (this.jWw == null) {}
    for (;;)
    {
      try
      {
        this.jWw = new JSONObject();
        localObject = new JSONObject();
        this.jWw.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.uJS);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.uJU), Integer.valueOf(this.uJV) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.uKa), Integer.valueOf(this.uKb) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.uKc), Integer.valueOf(this.uKd) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.uKe), Integer.valueOf(this.uKf) }));
        ((JSONObject)localObject).put("rotate", this.duc);
        ((JSONObject)localObject).put("deviceoutfps", this.uKg);
        ((JSONObject)localObject).put("recordfps", this.uKh);
        ((JSONObject)localObject).put("recordertype", this.uKi);
        ((JSONObject)localObject).put("needRotateEachFrame", this.fHK);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.uKj);
        ((JSONObject)localObject).put("resolutionLimit", this.gXd);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.uKq);
        ((JSONObject)localObject).put("useback", this.uKr);
        if (k.uLk == null) {
          continue;
        }
        i = k.uLk.uLw;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", ae.fJk.fHQ);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        ac.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.jWw.toString();
      AppMethodBeat.o(89351);
      return localObject;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b
 * JD-Core Version:    0.7.0.1
 */