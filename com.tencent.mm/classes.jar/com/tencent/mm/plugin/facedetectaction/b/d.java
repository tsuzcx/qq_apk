package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.ytcommon.util.YTCommonInterface;

public final class d
  implements i
{
  public static d sXz;
  String dYK;
  public String dYL;
  String dYM;
  public MMActivity gte;
  public int irL;
  public int mStatus = 0;
  String packageName;
  private String personId;
  int requestCode;
  private String sQY;
  b sXA;
  private e sXB;
  private float sXC;
  private String sXD;
  public a sXE;
  public int sXF;
  public int sXG;
  public FaceActionUI sXH;
  public boolean sXI = false;
  int scene;
  MMHandler workerHandler;
  
  static
  {
    AppMethodBeat.i(104222);
    sXz = new d();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.flash.c.b.axn("reqCfg");
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dYK);
    g.azz().a(2696, this);
    g.azz().a(locala, 0);
    this.sXH = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(104217);
    if (this.workerHandler != null) {
      this.workerHandler.post(paramRunnable);
    }
    AppMethodBeat.o(104217);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104218);
    if (this.sXH != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.sXH.a("cancel", 90004, null, Boolean.valueOf(this.sXH.sYp));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.sXH.a("cancel", 0, null, Boolean.valueOf(this.sXH.sYp));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.sXH.a("cancel", 90006, null, Boolean.valueOf(this.sXH.sYp));
      }
    }
    AppMethodBeat.o(104218);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(104216);
    Log.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      g.azz().b(2696, this);
      paramq = (com.tencent.mm.plugin.facedetectaction.a.a)paramq;
      com.tencent.mm.plugin.flash.c.b.s("errorType", paramInt1 + "#" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramq.sXg;
        com.tencent.mm.plugin.flash.c.b.dLj().eqT = paramString.pTZ;
        com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramString.pTZ));
        com.tencent.mm.plugin.flash.c.b.s("msgCfg", paramString.pUa);
        Log.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.pTZ), paramString.pUa, paramString.action_data, Float.valueOf(paramString.LVN), paramString.LjH });
        if (paramString.pTZ == 0)
        {
          this.personId = paramString.person_id;
          this.sQY = paramString.action_data;
          this.sXC = paramString.LVN;
          this.sXD = paramString.LjH;
          switch (Util.getInt(this.sQY, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.sXE == null) {
              break label726;
            }
            this.sXE.a(1, -1, "", "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.LVO;
          Log.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramq = this.sXA;
          MMActivity localMMActivity = this.gte;
          b.tryLoadLibrary();
          if (!PluginFace.isEnabled()) {
            paramInt2 = 0;
          }
          while (paramInt2 == 0)
          {
            Log.i("MicroMsg.FaceCheckActionMgr", "init face actionsource failed");
            AppMethodBeat.o(104216);
            return;
            paramInt2 = YTCommonInterface.initAuth(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
            Log.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
            paramq.liveType = paramInt1;
            if (paramInt2 != 0)
            {
              h.CyF.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              h.CyF.idkeyStat(917L, 57L, 1L, false);
              Log.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.k(p.cTh(), false) + "/");
              }
              Log.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(paramInt2) });
              if (paramInt2 != 0)
              {
                paramInt2 = 0;
                label536:
                if (paramInt2 == 0) {
                  break label683;
                }
                YTCommonExInterface.setAppBrightness(localMMActivity, 255);
                paramq.status = 1;
              }
              label683:
              for (paramInt2 = 1;; paramInt2 = 0)
              {
                paramq.sXw = new b.1(paramq);
                a.b.cTX().sXs = paramq.sXw;
                break;
                Object localObject = YTFaceTrack.getInstance().GetFaceDetectParam();
                ((YTFaceDetectParam)localObject).bigger_face_mode = true;
                ((YTFaceDetectParam)localObject).min_face_size = 50;
                YTFaceTrack.getInstance().SetFaceDetectParam((YTFaceDetectParam)localObject);
                localObject = YTFaceTrack.getInstance().GetFaceTrackParam();
                ((YTFaceTrackParam)localObject).need_pose_estimate = true;
                ((YTFaceTrackParam)localObject).detect_interval = 20;
                YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
                paramInt2 = YTPoseDetectInterface.initModel();
                if (paramInt2 != 0)
                {
                  Log.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(paramInt2)));
                  paramInt2 = 0;
                  break label536;
                }
                paramInt2 = 1;
                YTPoseDetectInterface.setSafetyLevel(1);
                break label536;
              }
            }
          }
          this.mStatus = 0;
          this.sXA.sXx = new b.a()
          {
            public final void a(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(104211);
              Log.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              if (paramAnonymousArrayOfByte != null) {
                d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              }
              AppMethodBeat.o(104211);
            }
          };
          if (this.sXE != null) {
            this.sXE.aX(paramInt1, paramString);
          }
          label726:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.sXE != null) {
          this.sXE.a(1, paramString.pTZ, paramString.pUa, "", 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      Log.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.sXE != null) {
        this.sXE.a(1, paramInt2, paramString, "", 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.b))
    {
      paramq = (com.tencent.mm.plugin.facedetectaction.a.b)paramq;
      g.azz().b(2726, this);
      paramq = paramq.sXi;
      Log.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s serialId:%s", new Object[] { Integer.valueOf(paramq.pTZ), paramq.pUa, paramq.LVU });
      com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramq.pTZ));
      com.tencent.mm.plugin.flash.c.b.s("msgVerify", paramq.pUa);
      com.tencent.mm.plugin.flash.c.b.dLj().eqV = paramq.pTZ;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq.pTZ != 0)
        {
          if (this.sXE != null)
          {
            this.sXE.a(3, paramq.pTZ, paramq.pUa, paramq.LVU, paramq.LVT);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          Log.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.sXE != null)
          {
            this.sXE.a(paramq);
            this.mStatus = 2;
            AppMethodBeat.o(104216);
          }
        }
      }
      else
      {
        Log.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
        if (this.sXE != null) {
          this.sXE.a(3, paramInt2, paramString, paramq.LVU, 1);
        }
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    Log.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.sXA != null)
    {
      b.release();
      this.sXA = new b();
    }
    if (this.sXB != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.cTF().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.cTF().cTH();
      }
      this.sXB = null;
    }
    if (paramBoolean)
    {
      if (this.workerHandler != null)
      {
        this.workerHandler.getSerial().RUS.quit();
        this.workerHandler = null;
      }
      sXz = new d();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
    
    public abstract void a(bnh parambnh);
    
    public abstract void aX(int paramInt, String paramString);
    
    public abstract void cTY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */