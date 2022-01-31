package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.api.b.a;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class a
{
  private static volatile a mng;
  private static final String mnv;
  public static final String mnw;
  private static final String mnx;
  public com.tencent.mm.remoteservice.d evl;
  private com.tencent.mm.plugin.mmsight.model.a.d gNw;
  private String mFilePath;
  private final Object mLock;
  public al mnh;
  private final int mni;
  private final int mnj;
  private final int mnk;
  private a.a mnl;
  private int mnm;
  private boolean mnn;
  private int mno;
  public boolean mnp;
  private a.b mnq;
  private int mnr;
  private int mns;
  private String mnt;
  public b mnu;
  private d.b mny;
  private d.a mnz;
  
  static
  {
    AppMethodBeat.i(571);
    mng = null;
    mnv = p.buG() + '/' + "fdv_";
    mnw = p.buG() + '/' + "video_temp_test.mp4";
    mnx = p.buG() + '/' + "fdv_t_";
    AppMethodBeat.o(571);
  }
  
  private a()
  {
    AppMethodBeat.i(559);
    this.mLock = new Object();
    this.mnh = null;
    this.mni = 960;
    this.mnj = 540;
    this.mnk = 15;
    this.mnl = a.a.mnS;
    this.mnm = 0;
    this.mnn = false;
    this.mno = 0;
    this.mnp = false;
    this.mnq = null;
    this.mnr = -1;
    this.mns = -1;
    this.mFilePath = "";
    this.mnt = "";
    this.evl = new com.tencent.mm.remoteservice.d(ah.getContext());
    this.mnu = b.oGi.asF();
    this.mny = new a.9(this);
    this.mnz = new a.2(this);
    this.mnh = new al("face_video_handler");
    AppMethodBeat.o(559);
  }
  
  private VideoTransPara aAX()
  {
    AppMethodBeat.i(567);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = this.mnr;
    localVideoTransPara.height = this.mns;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 1200000;
    localVideoTransPara.fzU = 10;
    localVideoTransPara.fzT = 64000;
    localVideoTransPara.fzV = 2;
    localVideoTransPara.fzW = 1;
    localVideoTransPara.audioSampleRate = 16000;
    localVideoTransPara.duration = 15;
    AppMethodBeat.o(567);
    return localVideoTransPara;
  }
  
  public static a bvo()
  {
    AppMethodBeat.i(560);
    if (mng == null) {
      try
      {
        if (mng == null) {
          mng = new a();
        }
        a locala1 = mng;
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(560);
      }
    }
    a locala2 = mng;
    AppMethodBeat.o(560);
    return locala2;
  }
  
  public final boolean EC()
  {
    AppMethodBeat.i(563);
    ab.e("MicroMsg.FaceVideoRecorder", "carson: start Record Video");
    this.mnh.ac(new a.6(this));
    AppMethodBeat.o(563);
    return true;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(565);
    ab.e("MicroMsg.FaceVideoRecorder", "carson: stop Record Video");
    this.mnh.ac(new a.8(this, paramb));
    AppMethodBeat.o(565);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    AppMethodBeat.i(561);
    ab.i("MicroMsg.FaceVideoRecorder", "hy: init record");
    ab.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, acceptVoiceFromOutside: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.FALSE, Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    VideoTransPara localVideoTransPara = aAX();
    this.mnu.a(this.evl, localVideoTransPara);
    this.mnh.ac(new a.1(this, paramInt1, paramInt3, paramInt2, paramBoolean, paramInt4, paramInt5));
    AppMethodBeat.o(561);
    return true;
  }
  
  public final void aV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(566);
    this.mnh.ac(new a.10(this, paramArrayOfByte));
    AppMethodBeat.o(566);
  }
  
  public final c.a bvp()
  {
    AppMethodBeat.i(562);
    if (this.gNw != null)
    {
      c.a locala = this.gNw.XB();
      AppMethodBeat.o(562);
      return locala;
    }
    ab.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
    AppMethodBeat.o(562);
    return null;
  }
  
  public final void bvq()
  {
    AppMethodBeat.i(564);
    ab.e("MicroMsg.FaceVideoRecorder", "carson: cancel Record Video");
    this.mnh.ac(new a.7(this));
    AppMethodBeat.o(564);
  }
  
  public final a.a bvr()
  {
    synchronized (this.mLock)
    {
      a.a locala = this.mnl;
      return locala;
    }
  }
  
  public final boolean isStarted()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mnl == a.a.mnU)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a
 * JD-Core Version:    0.7.0.1
 */