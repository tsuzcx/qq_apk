package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a
{
  static a mfL;
  public int dyt;
  int eIy;
  public long fileSize;
  JSONObject gff = null;
  String mfM = Build.VERSION.SDK_INT;
  int mfN;
  String mfO;
  int mfP;
  int mfQ;
  public String mfR;
  public String mfS;
  public String mfT;
  public String mfU;
  public int mfV;
  public int mfW;
  public int mfX;
  public int mfY;
  public int mfZ;
  public int mga;
  public int mgb;
  public int mgc;
  public int mgd;
  public int mge;
  public int mgf;
  public int mgg;
  public int mgh;
  int mgi;
  public int mgj;
  public int mgk;
  public int mgl;
  public long mgm;
  public int mgn;
  String model = Build.MODEL;
  public int rotate = 0;
  public int videoBitrate;
  
  public static a biE()
  {
    if (mfL == null) {
      reset();
    }
    return mfL;
  }
  
  public static void reset()
  {
    Object localObject = new a();
    mfL = (a)localObject;
    ((a)localObject).eIy = ((ActivityManager)ae.getContext().getSystemService("activity")).getLargeMemoryClass();
    mfL.mfN = d.dM(ae.getContext());
    mfL.mfO = m.yS();
    localObject = d.dL(ae.getContext());
    mfL.mfP = ((Point)localObject).x;
    mfL.mfQ = ((Point)localObject).y;
  }
  
  public final String biF()
  {
    if (this.gff == null) {}
    for (;;)
    {
      try
      {
        this.gff = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        this.gff.put("wxcamera", localJSONObject);
        localJSONObject.put("model", this.model);
        localJSONObject.put("apiLevel", this.mfM);
        localJSONObject.put("screen", String.format("%dx%d", new Object[] { Integer.valueOf(this.mfP), Integer.valueOf(this.mfQ) }));
        localJSONObject.put("crop", String.format("%dx%d", new Object[] { Integer.valueOf(this.mfV), Integer.valueOf(this.mfW) }));
        localJSONObject.put("preview", String.format("%dx%d", new Object[] { Integer.valueOf(this.mfX), Integer.valueOf(this.mfY) }));
        localJSONObject.put("encoder", String.format("%dx%d", new Object[] { Integer.valueOf(this.mfZ), Integer.valueOf(this.mga) }));
        localJSONObject.put("rotate", this.rotate);
        localJSONObject.put("deviceoutfps", this.mgb);
        localJSONObject.put("recordfps", this.mgc);
        localJSONObject.put("recordertype", this.mgd);
        localJSONObject.put("needRotateEachFrame", this.dyt);
        localJSONObject.put("isNeedRealtimeScale", this.mge);
        localJSONObject.put("resolutionLimit", this.mgf);
        localJSONObject.put("videoBitrate", this.videoBitrate);
        localJSONObject.put("wait2playtime", this.mgm);
        localJSONObject.put("useback", this.mgn);
        if (j.mhB == null) {
          continue;
        }
        i = j.mhB.mhK;
        localJSONObject.put("presetIndex", i);
        localJSONObject.put("recorderOption", q.dyk.dyz);
      }
      catch (Exception localException)
      {
        int i;
        y.printErrStackTrace("MicroMsg.CaptureStatistics", localException, "buildJson error", new Object[0]);
        continue;
      }
      return this.gff.toString();
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a
 * JD-Core Version:    0.7.0.1
 */