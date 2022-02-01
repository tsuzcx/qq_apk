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
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.d.b.c;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.h.a;
import com.tencent.mm.plugin.facedetect.model.k;
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
  private String luk = null;
  private ServiceConnection mConnection = null;
  private PowerManager.WakeLock wakeLock = null;
  boolean yrw = false;
  private int zRn = -1;
  h zVJ = null;
  private b zVK = null;
  private boolean zVL = false;
  private boolean zVM = false;
  private View zVN = null;
  private RelativeLayout zVO;
  FaceDetectView zVP = null;
  FaceScanRect zVQ = null;
  private TextView zVR = null;
  private Button zVS = null;
  private a zVT = null;
  private FaceTutorial zVU = null;
  private com.tencent.mm.plugin.facedetect.c.a zVV = null;
  private FaceDetectProcessService zVW = null;
  private boolean zVX = false;
  private boolean zVY = false;
  private com.tencent.mm.plugin.facedetect.views.c zVZ = null;
  private String zWa;
  
  private void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104008);
    setResult(-1, c(paramInt1, paramInt2, paramString, paramBundle));
    AppMethodBeat.o(104008);
  }
  
  private void bSt()
  {
    AppMethodBeat.i(104007);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.zVP.getCurrentMotionCancelInfo();
    a(1, localb.errCode, localb.errMsg, null);
    AppMethodBeat.o(104007);
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
  
  private void dFv()
  {
    AppMethodBeat.i(103993);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.zVX) });
    if (this.zVX)
    {
      Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      com.tencent.mm.br.c.a(this.mConnection, "tools");
      this.zVX = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void dPs()
  {
    AppMethodBeat.i(104002);
    this.yrw = false;
    this.zVP.pi(false);
    Log.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    this.zVL = false;
    this.zVP.zXY.zXE.auq();
    Log.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104002);
  }
  
  private void z(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    Log.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    dPs();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void Mx(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.zVQ.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    Log.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.dPv().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.dPv().zWF)) {
      com.tencent.mm.plugin.facedetect.e.a.dPv().dPx();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.dOU());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    b(paramInt1, paramInt2, paramString, localBundle);
    finish();
    AppMethodBeat.o(103998);
  }
  
  final void dPr()
  {
    AppMethodBeat.i(103999);
    if (this.yrw)
    {
      Log.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.zVP;
      Rect localRect = new Rect(this.zVQ.getLeft(), this.zVQ.getTop(), this.zVQ.getRight(), this.zVQ.getBottom());
      h.a locala = h.dOT();
      if ((locala == null) || (locala.type == 100))
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.zYd != null) {
        localFaceDetectView.zYd.dPi();
      }
      localFaceDetectView.nxG = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.zYj = Util.currentTicks();
      localFaceDetectView.zYh = locala.zSY;
      localFaceDetectView.zYg = locala.qiK;
      Log.i("MicroMsg.FaceDetectView", "carson logic");
      Log.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.qiK);
      localFaceDetectView.zSZ = locala.zSZ;
      localFaceDetectView.zYe = true;
      localFaceDetectView.zYi = locala.zTc;
      localFaceDetectView.zYd = b.c.a(locala);
      if (localFaceDetectView.zYd != null)
      {
        if (localFaceDetectView.zYa != null) {
          localFaceDetectView.zYa.removeAllViews();
        }
        if (localFaceDetectView.zYb != null) {
          localFaceDetectView.zYb.removeAllViews();
        }
        localFaceDetectView.zYd.a(localFaceDetectView.getContext(), localFaceDetectView.zYa, localFaceDetectView.zYb);
        Log.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.zWa);
        localFaceDetectView.zYd.setBusinessTip(localFaceDetectView.zWa);
      }
      if (localFaceDetectView.zXY != null) {
        localFaceDetectView.zXY.a(localRect, locala.zSW);
      }
      localFaceDetectView.zYf = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if (this.zVT != null)
    {
      AppMethodBeat.o(104011);
      throw null;
    }
    if (this.zVU != null) {
      this.zVU.dismiss();
    }
    Log.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    Log.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.zVM)
    {
      this.zVZ = null;
      this.zVM = true;
      if (this.zVK.zWf)
      {
        dPs();
        this.zVP.zXY.zXE.dPF();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        PowerManager.WakeLock localWakeLock = this.wakeLock;
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        this.wakeLock = null;
      }
      ThreadPool.post(new FaceDetectUI.2(this), "Face_active_gc");
    }
    dFv();
    super.finish();
    AppMethodBeat.o(104011);
  }
  
  public int getLayoutId()
  {
    return a.g.face_recognize_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(104012);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
    bSt();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.luk = getIntent().getStringExtra("k_user_name");
    this.zRn = getIntent().getIntExtra("scene", -1);
    this.zWa = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    Object localObject;
    long l;
    if (paramBundle != null)
    {
      localObject = FaceDetectReporter.dOU();
      Log.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { Util.getStack().toString() });
      ((FaceDetectReporter)localObject).zTw = paramBundle.zTw;
      ((FaceDetectReporter)localObject).zTv = paramBundle.zTv;
      ((FaceDetectReporter)localObject).sessionId = paramBundle.sessionId;
      ((FaceDetectReporter)localObject).zTy = paramBundle.zTy;
      ((FaceDetectReporter)localObject).zTz = paramBundle.zTz;
      l = ((FaceDetectReporter)localObject).sessionId;
      if (((FaceDetectReporter)localObject).zTw == null) {
        break label466;
      }
    }
    label466:
    for (paramBundle = ((FaceDetectReporter)localObject).zTw.toString();; paramBundle = "null")
    {
      Log.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramBundle });
      paramBundle = com.tencent.mm.plugin.facedetect.c.b.zSu;
      this.zVV = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.zRn, getIntent().getExtras());
      getWindow().setFlags(1024, 1024);
      this.zVS = ((Button)findViewById(a.e.left_btn));
      this.zVS.setOnClickListener(new FaceDetectUI.1(this));
      this.zVN = findViewById(a.e.face_detect_cover);
      this.zVN.setVisibility(8);
      this.zVO = ((RelativeLayout)findViewById(a.e.face_hold_area));
      this.zVQ = ((FaceScanRect)findViewById(a.e.face_fixed_rect));
      this.zVP = ((FaceDetectView)findViewById(a.e.face_detect_view));
      this.zVR = ((TextView)findViewById(a.e.err_msg_tv));
      this.zVP.setCallback(this);
      this.zVP.setBusinessTip(this.zWa);
      paramBundle = this.zVP;
      localObject = this.zVO;
      ViewGroup localViewGroup = this.zVQ.getCenterHintHolder();
      paramBundle.zYa = ((ViewGroup)localObject);
      paramBundle.zYb = localViewGroup;
      this.zVP.setErrTextView(this.zVR);
      this.zVP.M(true, this.luk);
      this.zVQ.setOnRefreshRectListener(new FaceScanRect.b()
      {
        public final void onRefresh()
        {
          AppMethodBeat.i(103979);
          Object localObject = FaceDetectUI.c(FaceDetectUI.this);
          RectF localRectF = new RectF(FaceDetectUI.b(FaceDetectUI.this).getLeft(), FaceDetectUI.b(FaceDetectUI.this).getTop(), FaceDetectUI.b(FaceDetectUI.this).getRight(), FaceDetectUI.b(FaceDetectUI.this).getBottom());
          localObject = ((FaceDetectView)localObject).zXZ;
          ((FaceDetectDecorView)localObject).zXU = true;
          ((FaceDetectDecorView)localObject).zXV = true;
          ((FaceDetectDecorView)localObject).zXW = localRectF;
          ((FaceDetectDecorView)localObject).invalidate();
          AppMethodBeat.o(103979);
        }
      });
      this.zVQ.setVisibility(4);
      this.zVK = new b((byte)0);
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
  
  public final void onResult(int paramInt, final String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(104005);
    Log.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.Mo(paramInt))
    {
      if (paramInt == 3)
      {
        z(90017, "face detect time out", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if ((paramInt == 6) || (paramInt == 5))
      {
        z(90023, "face track failed or not stable", paramString);
        AppMethodBeat.o(104005);
        return;
      }
      if (paramInt == 7)
      {
        z(90009, "audio permission not granted", MMApplicationContext.getContext().getString(a.i.permission_microphone_request_again_msg));
        AppMethodBeat.o(104005);
        return;
      }
      z(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.zVJ;
    if (paramString.xYG >= paramString.zSU - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      Log.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.zVP.pi(true);
      paramString = this.zVP.getPreviewBm();
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
          k.l(FaceDetectUI.i(FaceDetectUI.this), paramString);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103986);
              if (FaceDetectUI.7.this.zWc != null) {
                FaceDetectUI.7.this.zWc.onFinish();
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
    paramString = this.zVJ;
    g localg = com.tencent.mm.plugin.facedetect.model.f.zSO.zSP.zUR;
    if (localg.zSS == null) {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.xYG += 1;
      paramInt = h.dOT().type;
      Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.dOT().zTb) {
        break;
      }
      this.zVQ.b(new Animation.AnimationListener()
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
      localg.zSS.engineNextMotion();
    }
    Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    dPr();
    AppMethodBeat.o(104005);
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
      localObject = this.wakeLock;
      com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI", "acquireWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      ((PowerManager.WakeLock)localObject).acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI", "acquireWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    Object localObject = new Intent(this, FaceDetectProcessService.class);
    ((Intent)localObject).putExtra("key_face_service_connection_from", 2);
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(103980);
        Log.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[] { paramAnonymousComponentName });
        FaceDetectUI.a(FaceDetectUI.this, true);
        paramAnonymousComponentName = (FaceDetectProcessService.a)paramAnonymousIBinder;
        FaceDetectUI.a(FaceDetectUI.this, paramAnonymousComponentName.zUU);
        paramAnonymousComponentName = com.tencent.mm.plugin.facedetect.model.f.zSO;
        paramAnonymousIBinder = FaceDetectUI.d(FaceDetectUI.this);
        Log.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()), Integer.valueOf(paramAnonymousComponentName.hashCode()) });
        paramAnonymousComponentName.zSP = paramAnonymousIBinder;
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
    com.tencent.mm.br.c.a((Intent)localObject, this.mConnection, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    Log.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    dFv();
    if (!this.zVY)
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
    private boolean zWe = true;
    boolean zWf = false;
    private boolean zWg = true;
    private final boolean zWh = true;
    
    private b() {}
    
    public final void dPt()
    {
      try
      {
        this.zWf = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void dPu()
    {
      try
      {
        AppMethodBeat.i(103990);
        Log.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
        if ((this.zWe) && (this.zWf) && (this.zWg)) {
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
        this.zWf = false;
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
      String str = "InitHandler{isCgiInitDone=" + this.zWe + ", isCameraInitDone=" + this.zWf + ", isLightInitDone=true, isLibraryInitDone=" + this.zWg + '}';
      AppMethodBeat.o(103991);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */