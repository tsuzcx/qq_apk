package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class b
{
  static b KUp;
  public int KUA;
  public int KUB;
  public int KUC;
  public int KUD;
  public int KUE;
  public int KUF;
  public int KUG;
  public int KUH;
  public int KUI;
  public int KUJ;
  int KUK;
  public int KUL;
  public int KUM;
  public int KUN;
  public long KUO;
  public int KUP;
  String KUq;
  String KUr;
  int KUs;
  int KUt;
  public String KUu;
  public String KUv;
  public String KUw;
  public String KUx;
  public int KUy;
  public int KUz;
  public long fileSize;
  public int hYK;
  public int lWz;
  String model;
  public int nFY;
  int nJN;
  int pch;
  JSONObject rwB;
  public int videoBitrate;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = q.aPo();
    this.KUq = Build.VERSION.SDK_INT;
    this.hYK = 0;
    this.rwB = null;
    AppMethodBeat.o(89348);
  }
  
  public static b gbT()
  {
    AppMethodBeat.i(89349);
    if (KUp == null) {
      reset();
    }
    b localb = KUp;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    KUp = (b)localObject;
    ((b)localObject).pch = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    KUp.nJN = d.iR(MMApplicationContext.getContext());
    KUp.KUr = m.aOL();
    localObject = d.iQ(MMApplicationContext.getContext());
    KUp.KUs = ((Point)localObject).x;
    KUp.KUt = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String gbU()
  {
    AppMethodBeat.i(89351);
    if (this.rwB == null) {}
    for (;;)
    {
      try
      {
        this.rwB = new JSONObject();
        localObject = new JSONObject();
        this.rwB.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.KUq);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.KUs), Integer.valueOf(this.KUt) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.KUy), Integer.valueOf(this.KUz) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.KUA), Integer.valueOf(this.KUB) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.KUC), Integer.valueOf(this.KUD) }));
        ((JSONObject)localObject).put("rotate", this.hYK);
        ((JSONObject)localObject).put("deviceoutfps", this.KUE);
        ((JSONObject)localObject).put("recordfps", this.KUF);
        ((JSONObject)localObject).put("recordertype", this.KUG);
        ((JSONObject)localObject).put("needRotateEachFrame", this.lWz);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.KUH);
        ((JSONObject)localObject).put("resolutionLimit", this.nFY);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.KUO);
        ((JSONObject)localObject).put("useback", this.KUP);
        if (j.KVJ == null) {
          continue;
        }
        i = j.KVJ.Ddk;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", af.lYf.lWF);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.rwB.toString();
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