package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.d.b.c;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI
  extends MMActivity
  implements com.tencent.mm.plugin.facedetect.c.f, com.tencent.mm.plugin.facedetect.views.a
{
  private String goe = null;
  private ServiceConnection mConnection = null;
  boolean rzT = false;
  private int sPn = -1;
  h sTC = null;
  private b sTD = null;
  private boolean sTE = false;
  private boolean sTF = false;
  private View sTG = null;
  private RelativeLayout sTH;
  FaceDetectView sTI = null;
  FaceScanRect sTJ = null;
  private TextView sTK = null;
  private Button sTL = null;
  private a sTM = null;
  private FaceTutorial sTN = null;
  private com.tencent.mm.plugin.facedetect.c.a sTO = null;
  private FaceDetectProcessService sTP = null;
  private boolean sTQ = false;
  private boolean sTR = false;
  private com.tencent.mm.plugin.facedetect.views.c sTS = null;
  private String sTT;
  private PowerManager.WakeLock wakeLock = null;
  
  private void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104008);
    setResult(-1, c(paramInt1, paramInt2, paramString, paramBundle));
    AppMethodBeat.o(104008);
  }
  
  private static Intent c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104009);
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_type", paramInt1);
    localBundle.putInt("err_code", paramInt2);
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    AppMethodBeat.o(104009);
    return paramString;
  }
  
  private void cKu()
  {
    AppMethodBeat.i(103993);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.sTQ) });
    if (this.sTQ)
    {
      Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      com.tencent.mm.br.c.a(this.mConnection, "tools");
      this.sTQ = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void cTA()
  {
    AppMethodBeat.i(104007);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.sTI.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(104007);
  }
  
  private void cTC()
  {
    AppMethodBeat.i(104002);
    this.rzT = false;
    this.sTI.mv(false);
    Log.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    this.sTE = false;
    this.sTI.sVP.sVv.stopPreview();
    Log.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104002);
  }
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    Log.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    cTC();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void A(int paramInt, final String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(104005);
    Log.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.HH(paramInt))
    {
      if (paramInt == 3)
      {
        w(90017, "face detect time out", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if ((paramInt == 6) || (paramInt == 5))
      {
        w(90023, "face track failed or not stable", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if (paramInt == 7)
      {
        w(90009, "audio permission not granted", MMApplicationContext.getContext().getString(2131763876));
        AppMethodBeat.o(104005);
        return;
      }
      w(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.sTC;
    if (paramString.rmJ >= paramString.sQS - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      Log.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.sTI.mv(true);
      paramString = this.sTI.getPreviewBm();
      if (paramString != null) {
        break label242;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FaceDetectUI", "alvinluo bitmap == null: %b", new Object[] { Boolean.valueOf(bool) });
      ThreadPool.post(new Runnable()
      {
        public final void onFinish()
        {
          AppMethodBeat.i(103988);
          Log.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
          FaceDetectUI.j(FaceDetectUI.this);
          FaceDetectUI.this.a(0, 0, "collect data ok", null);
          AppMethodBeat.o(103988);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(103987);
          MMApplicationContext.getContext();
          p.l(FaceDetectUI.i(FaceDetectUI.this), paramString);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103986);
              if (FaceDetectUI.7.this.sTV != null) {
                FaceDetectUI.7.this.sTV.onFinish();
              }
              AppMethodBeat.o(103986);
            }
          });
          AppMethodBeat.o(103987);
        }
      }, "save_face_bitmap");
      AppMethodBeat.o(104005);
      return;
      paramInt = 0;
      break;
      label242:
      bool = false;
    }
    label247:
    paramString = this.sTC;
    g localg = com.tencent.mm.plugin.facedetect.model.f.sQM.sQN.sSO;
    if (localg.sQQ == null) {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.rmJ += 1;
      paramInt = h.cTd().type;
      Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.cTd().sQZ) {
        break;
      }
      this.sTJ.b(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(103989);
          FaceDetectUI.k(FaceDetectUI.this);
          AppMethodBeat.o(103989);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      AppMethodBeat.o(104005);
      return;
      Log.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
      localg.sQQ.engineNextMotion();
    }
    Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    cTB();
    AppMethodBeat.o(104005);
  }
  
  public final void HQ(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.sTJ.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    Log.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.cTF().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.cTF().sUx)) {
      com.tencent.mm.plugin.facedetect.e.a.cTF().cTH();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cTe());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    b(paramInt1, paramInt2, paramString, localBundle);
    finish();
    AppMethodBeat.o(103998);
  }
  
  final void cTB()
  {
    AppMethodBeat.i(103999);
    if (this.rzT)
    {
      Log.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.sTI;
      Rect localRect = new Rect(this.sTJ.getLeft(), this.sTJ.getTop(), this.sTJ.getRight(), this.sTJ.getBottom());
      h.a locala = h.cTd();
      if (locala.type == 100)
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.sVU != null) {
        localFaceDetectView.sVU.cTs();
      }
      localFaceDetectView.idt = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.sWa = Util.currentTicks();
      localFaceDetectView.sVY = locala.sQW;
      localFaceDetectView.sVX = locala.ktN;
      Log.i("MicroMsg.FaceDetectView", "carson logic");
      Log.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.ktN);
      localFaceDetectView.sQX = locala.sQX;
      localFaceDetectView.sVV = true;
      localFaceDetectView.sVZ = locala.sRa;
      localFaceDetectView.sVU = b.c.a(locala);
      if (localFaceDetectView.sVU != null)
      {
        if (localFaceDetectView.sVR != null) {
          localFaceDetectView.sVR.removeAllViews();
        }
        if (localFaceDetectView.sVS != null) {
          localFaceDetectView.sVS.removeAllViews();
        }
        localFaceDetectView.sVU.a(localFaceDetectView.getContext(), localFaceDetectView.sVR, localFaceDetectView.sVS);
        Log.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.sTT);
        localFaceDetectView.sVU.setBusinessTip(localFaceDetectView.sTT);
      }
      if (localFaceDetectView.sVP != null) {
        localFaceDetectView.sVP.a(localRect, locala.sQU);
      }
      localFaceDetectView.sVW = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if (this.sTM != null) {
      if (this.sTM.sTs.getVisibility() == 8) {
        break label221;
      }
    }
    label221:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        a locala = this.sTM;
        Log.printInfoStack("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
        a.sTu.cancel();
        if (locala.sTs.getVisibility() == 0) {
          MMHandlerThread.postToMainThread(new a.1(locala));
        }
      }
      if (this.sTN != null) {
        this.sTN.dismiss();
      }
      Log.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
      Log.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
      if (!this.sTF)
      {
        this.sTS = null;
        this.sTF = true;
        if (this.sTD.sTY)
        {
          cTC();
          this.sTI.sVP.sVv.cTO();
        }
        if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
        {
          this.wakeLock.release();
          this.wakeLock = null;
        }
        ThreadPool.post(new FaceDetectUI.2(this), "Face_active_gc");
      }
      cKu();
      super.finish();
      AppMethodBeat.o(104011);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494089;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104012);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    cTA();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.goe = getIntent().getStringExtra("k_user_name");
    this.sPn = getIntent().getIntExtra("scene", -1);
    this.sTT = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    Object localObject;
    long l;
    if (paramBundle != null)
    {
      localObject = FaceDetectReporter.cTe();
      Log.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { Util.getStack().toString() });
      ((FaceDetectReporter)localObject).sRu = paramBundle.sRu;
      ((FaceDetectReporter)localObject).sRt = paramBundle.sRt;
      ((FaceDetectReporter)localObject).sessionId = paramBundle.sessionId;
      ((FaceDetectReporter)localObject).sRw = paramBundle.sRw;
      ((FaceDetectReporter)localObject).sRx = paramBundle.sRx;
      l = ((FaceDetectReporter)localObject).sessionId;
      if (((FaceDetectReporter)localObject).sRu == null) {
        break label466;
      }
    }
    label466:
    for (paramBundle = ((FaceDetectReporter)localObject).sRu.toString();; paramBundle = "null")
    {
      Log.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramBundle });
      paramBundle = com.tencent.mm.plugin.facedetect.c.b.sQr;
      this.sTO = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.sPn, getIntent().getExtras());
      getWindow().setFlags(1024, 1024);
      this.sTL = ((Button)findViewById(2131303137));
      this.sTL.setOnClickListener(new FaceDetectUI.1(this));
      this.sTG = findViewById(2131300319);
      this.sTG.setVisibility(8);
      this.sTH = ((RelativeLayout)findViewById(2131300346));
      this.sTJ = ((FaceScanRect)findViewById(2131300335));
      this.sTI = ((FaceDetectView)findViewById(2131300334));
      this.sTK = ((TextView)findViewById(2131300151));
      this.sTI.setCallback(this);
      this.sTI.setBusinessTip(this.sTT);
      paramBundle = this.sTI;
      localObject = this.sTH;
      ViewGroup localViewGroup = this.sTJ.getCenterHintHolder();
      paramBundle.sVR = ((ViewGroup)localObject);
      paramBundle.sVS = localViewGroup;
      this.sTI.setErrTextView(this.sTK);
      this.sTI.u(true, this.goe);
      this.sTJ.setOnRefreshRectListener(new FaceScanRect.b()
      {
        public final void onRefresh()
        {
          AppMethodBeat.i(103979);
          Object localObject = FaceDetectUI.c(FaceDetectUI.this);
          RectF localRectF = new RectF(FaceDetectUI.b(FaceDetectUI.this).getLeft(), FaceDetectUI.b(FaceDetectUI.this).getTop(), FaceDetectUI.b(FaceDetectUI.this).getRight(), FaceDetectUI.b(FaceDetectUI.this).getBottom());
          localObject = ((FaceDetectView)localObject).sVQ;
          ((FaceDetectDecorView)localObject).sVL = true;
          ((FaceDetectDecorView)localObject).sVM = true;
          ((FaceDetectDecorView)localObject).sVN = localRectF;
          ((FaceDetectDecorView)localObject).invalidate();
          AppMethodBeat.o(103979);
        }
      });
      this.sTJ.setVisibility(4);
      this.sTD = new b((byte)0);
      AppMethodBeat.o(103992);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104010);
    Log.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[] { Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(104010);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(103994);
    super.onStart();
    Log.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
    if (this.wakeLock == null) {
      this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
    }
    if (!this.wakeLock.isHeld())
    {
      Log.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
      this.wakeLock.acquire();
    }
    Intent localIntent = new Intent(this, FaceDetectProcessService.class);
    localIntent.putExtra("key_face_service_connection_from", 2);
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(103980);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[] { paramAnonymousComponentName });
        FaceDetectUI.a(FaceDetectUI.this, true);
        paramAnonymousComponentName = (FaceDetectProcessService.a)paramAnonymousIBinder;
        FaceDetectUI.a(FaceDetectUI.this, paramAnonymousComponentName.sSR);
        paramAnonymousComponentName = com.tencent.mm.plugin.facedetect.model.f.sQM;
        paramAnonymousIBinder = FaceDetectUI.d(FaceDetectUI.this);
        Log.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()), Integer.valueOf(paramAnonymousComponentName.hashCode()) });
        paramAnonymousComponentName.sQN = paramAnonymousIBinder;
        Log.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[] { Integer.valueOf(FaceDetectUI.d(FaceDetectUI.this).hashCode()) });
        FaceDetectUI.e(FaceDetectUI.this);
        AppMethodBeat.o(103980);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(103981);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[] { paramAnonymousComponentName.toString() });
        FaceDetectUI.a(FaceDetectUI.this, false);
        AppMethodBeat.o(103981);
      }
    };
    Log.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
    com.tencent.mm.br.c.a(localIntent, this.mConnection, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    Log.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    cKu();
    if (!this.sTR)
    {
      a(1, 90006, "cancel with on stop", null);
      AppMethodBeat.o(103995);
      return;
    }
    finish();
    AppMethodBeat.o(103995);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static abstract interface a
  {
    public abstract void onFinish();
  }
  
  final class b
  {
    private boolean sTX = true;
    boolean sTY = false;
    private boolean sTZ = true;
    private final boolean sUa = true;
    
    private b() {}
    
    public final void cTD()
    {
      try
      {
        this.sTY = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void cTE()
    {
      try
      {
        AppMethodBeat.i(103990);
        Log.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
        if ((this.sTX) && (this.sTY) && (this.sTZ)) {
          FaceDetectUI.l(FaceDetectUI.this).setVisibility(0);
        }
        AppMethodBeat.o(103990);
        return;
      }
      finally {}
    }
    
    final void reset()
    {
      try
      {
        this.sTY = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(103991);
      String str = "InitHandler{isCgiInitDone=" + this.sTX + ", isCameraInitDone=" + this.sTY + ", isLightInitDone=true, isLibraryInitDone=" + this.sTZ + '}';
      AppMethodBeat.o(103991);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */