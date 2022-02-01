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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class b
{
  static b ztc;
  public int dYT;
  public long fileSize;
  public int gIQ;
  public int ilT;
  int ipW;
  int jtg;
  JSONObject lxS;
  String model;
  public int videoBitrate;
  public int ztA;
  public long ztB;
  public int ztC;
  String ztd;
  String zte;
  int ztf;
  int ztg;
  public String zth;
  public String zti;
  public String ztj;
  public String ztk;
  public int ztl;
  public int ztm;
  public int ztn;
  public int zto;
  public int ztp;
  public int ztq;
  public int ztr;
  public int zts;
  public int ztt;
  public int ztu;
  public int ztv;
  public int ztw;
  int ztx;
  public int zty;
  public int ztz;
  
  public b()
  {
    AppMethodBeat.i(89348);
    this.model = Build.MODEL;
    this.ztd = Build.VERSION.SDK_INT;
    this.dYT = 0;
    this.lxS = null;
    AppMethodBeat.o(89348);
  }
  
  public static b ejt()
  {
    AppMethodBeat.i(89349);
    if (ztc == null) {
      reset();
    }
    b localb = ztc;
    AppMethodBeat.o(89349);
    return localb;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(89350);
    Object localObject = new b();
    ztc = (b)localObject;
    ((b)localObject).jtg = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    ztc.ipW = d.gy(MMApplicationContext.getContext());
    ztc.zte = m.aoo();
    localObject = d.gx(MMApplicationContext.getContext());
    ztc.ztf = ((Point)localObject).x;
    ztc.ztg = ((Point)localObject).y;
    AppMethodBeat.o(89350);
  }
  
  public final String eju()
  {
    AppMethodBeat.i(89351);
    if (this.lxS == null) {}
    for (;;)
    {
      try
      {
        this.lxS = new JSONObject();
        localObject = new JSONObject();
        this.lxS.put("wxcamera", localObject);
        ((JSONObject)localObject).put("model", this.model);
        ((JSONObject)localObject).put("apiLevel", this.ztd);
        ((JSONObject)localObject).put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.ztf), Integer.valueOf(this.ztg) }));
        ((JSONObject)localObject).put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.ztl), Integer.valueOf(this.ztm) }));
        ((JSONObject)localObject).put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.ztn), Integer.valueOf(this.zto) }));
        ((JSONObject)localObject).put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.ztp), Integer.valueOf(this.ztq) }));
        ((JSONObject)localObject).put("rotate", this.dYT);
        ((JSONObject)localObject).put("deviceoutfps", this.ztr);
        ((JSONObject)localObject).put("recordfps", this.zts);
        ((JSONObject)localObject).put("recordertype", this.ztt);
        ((JSONObject)localObject).put("needRotateEachFrame", this.gIQ);
        ((JSONObject)localObject).put("isNeedRealtimeScale", this.ztu);
        ((JSONObject)localObject).put("resolutionLimit", this.ilT);
        ((JSONObject)localObject).put("videoBitrate", this.videoBitrate);
        ((JSONObject)localObject).put("wait2playtime", this.ztB);
        ((JSONObject)localObject).put("useback", this.ztC);
        if (k.zuy == null) {
          continue;
        }
        i = k.zuy.zuK;
        ((JSONObject)localObject).put("presetIndex", i);
        ((JSONObject)localObject).put("recorderOption", ae.gKA.gIW);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      localObject = this.lxS.toString();
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