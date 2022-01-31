package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.api.b.a;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public class a
{
  private static volatile a jSK = null;
  private static final String jSZ = o.aOC() + '/' + "fdv_";
  public static final String jTa = o.aOC() + '/' + "video_temp_test.mp4";
  private static final String jTb = o.aOC() + '/' + "fdv_t_";
  public com.tencent.mm.remoteservice.d eMh = new com.tencent.mm.remoteservice.d(ae.getContext());
  private com.tencent.mm.plugin.mmsight.model.a.d fvQ;
  public ai jSL = null;
  private final int jSM = 960;
  private final int jSN = 540;
  private final int jSO = 15;
  private a.a jSP = a.a.jTy;
  private int jSQ = 0;
  private boolean jSR = false;
  private int jSS = 0;
  public boolean jST = false;
  private a.b jSU = null;
  private int jSV = -1;
  private int jSW = -1;
  private String jSX = "";
  public b jSY = b.mfI.YV();
  private d.b jTc = new a.9(this);
  private d.a jTd = new a.2(this);
  private String mFilePath = "";
  private final Object mLock = new Object();
  
  public static a aPj()
  {
    if (jSK == null) {
      try
      {
        if (jSK == null) {
          jSK = new a();
        }
        a locala = jSK;
        return locala;
      }
      finally {}
    }
    return jSK;
  }
  
  public final void a(a.b paramb)
  {
    y.e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
    this.jSL.O(new a.8(this, paramb));
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    y.i("MicroMsg.FaceVideoRecorder", "hy: init record");
    y.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = this.jSV;
    localVideoTransPara.height = this.jSW;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 1200000;
    localVideoTransPara.ejN = 10;
    localVideoTransPara.ejM = 64000;
    localVideoTransPara.ejO = 2;
    localVideoTransPara.ejP = 1;
    localVideoTransPara.audioSampleRate = 16000;
    localVideoTransPara.duration = 15;
    this.jSY.a(this.eMh, localVideoTransPara);
    this.jSL.O(new a.1(this, paramInt1, paramInt3, paramInt2, paramBoolean, paramInt4, paramInt5));
    return true;
  }
  
  public final c.a aPk()
  {
    if (this.fvQ != null) {
      return this.fvQ.bjv();
    }
    y.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
    return null;
  }
  
  public final void aPl()
  {
    y.e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
    this.jSL.O(new a.7(this));
  }
  
  public final a.a aPm()
  {
    synchronized (this.mLock)
    {
      a.a locala = this.jSP;
      return locala;
    }
  }
  
  public final void ax(byte[] paramArrayOfByte)
  {
    this.jSL.O(new a.10(this, paramArrayOfByte));
  }
  
  public final boolean isStarted()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.jSP == a.a.jTA)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean uq()
  {
    y.e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
    this.jSL.O(new a.6(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a
 * JD-Core Version:    0.7.0.1
 */