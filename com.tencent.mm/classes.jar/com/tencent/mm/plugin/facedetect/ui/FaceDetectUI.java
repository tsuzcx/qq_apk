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
import android.view.View.OnClickListener;
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
  private String iSn = null;
  private ServiceConnection mConnection = null;
  boolean vfA = false;
  private PowerManager.WakeLock wakeLock = null;
  private int wvi = -1;
  private boolean wzA = false;
  private boolean wzB = false;
  private View wzC = null;
  private RelativeLayout wzD;
  FaceDetectView wzE = null;
  FaceScanRect wzF = null;
  private TextView wzG = null;
  private Button wzH = null;
  private a wzI = null;
  private FaceTutorial wzJ = null;
  private com.tencent.mm.plugin.facedetect.c.a wzK = null;
  private FaceDetectProcessService wzL = null;
  private boolean wzM = false;
  private boolean wzN = false;
  private com.tencent.mm.plugin.facedetect.views.c wzO = null;
  private String wzP;
  h wzy = null;
  private b wzz = null;
  
  private void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(104008);
    setResult(-1, c(paramInt1, paramInt2, paramString, paramBundle));
    AppMethodBeat.o(104008);
  }
  
  private void bQm()
  {
    AppMethodBeat.i(104007);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
    b.b localb = this.wzE.getCurrentMotionCancelInfo();
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
  
  private void cZe()
  {
    AppMethodBeat.i(103993);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[] { Boolean.valueOf(this.wzM) });
    if (this.wzM)
    {
      Log.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
      com.tencent.mm.by.c.a(this.mConnection, "tools");
      this.wzM = false;
    }
    AppMethodBeat.o(103993);
  }
  
  private void diH()
  {
    AppMethodBeat.i(104002);
    this.vfA = false;
    this.wzE.nI(false);
    Log.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
    this.wzA = false;
    this.wzE.wBN.wBt.TL();
    Log.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    AppMethodBeat.o(104002);
  }
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104004);
    Log.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt), paramString1 });
    Bundle localBundle = new Bundle();
    localBundle.putString("show_err_msg", paramString2);
    diH();
    a(4, paramInt, paramString1, localBundle);
    AppMethodBeat.o(104004);
  }
  
  public final void B(int paramInt, final String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(104005);
    Log.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[] { Integer.valueOf(paramInt) });
    if (FaceCharacteristicsResult.Lr(paramInt))
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
        w(90009, "audio permission not granted", MMApplicationContext.getContext().getString(a.i.permission_microphone_request_again_msg));
        AppMethodBeat.o(104005);
        return;
      }
      w(90018, "system error", paramString);
      AppMethodBeat.o(104005);
      return;
    }
    paramString = this.wzy;
    if (paramString.uPV >= paramString.wwO - 1)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label247;
      }
      Log.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
      this.wzE.nI(true);
      paramString = this.wzE.getPreviewBm();
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
              if (FaceDetectUI.7.this.wzR != null) {
                FaceDetectUI.7.this.wzR.onFinish();
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
    paramString = this.wzy;
    g localg = com.tencent.mm.plugin.facedetect.model.f.wwI.wwJ.wyK;
    if (localg.wwM == null) {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
    }
    for (;;)
    {
      paramString.uPV += 1;
      paramInt = h.dii().type;
      Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
      if (!h.dii().wwV) {
        break;
      }
      this.wzF.b(new Animation.AnimationListener()
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
      localg.wwM.engineNextMotion();
    }
    Log.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[] { Integer.valueOf(paramInt) });
    diG();
    AppMethodBeat.o(104005);
  }
  
  public final void LA(int paramInt)
  {
    AppMethodBeat.i(104006);
    if (paramInt == 1) {
      this.wzF.b(null);
    }
    AppMethodBeat.o(104006);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103998);
    Log.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0) && (com.tencent.mm.plugin.facedetect.e.a.diK().isStarted()) && (com.tencent.mm.plugin.facedetect.e.a.diK().wAu)) {
      com.tencent.mm.plugin.facedetect.e.a.diK().diM();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.dij());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    b(paramInt1, paramInt2, paramString, localBundle);
    finish();
    AppMethodBeat.o(103998);
  }
  
  final void diG()
  {
    AppMethodBeat.i(103999);
    if (this.vfA)
    {
      Log.i("MicroMsg.FaceDetectUI", "hy: start capture face");
      FaceDetectView localFaceDetectView = this.wzE;
      Rect localRect = new Rect(this.wzF.getLeft(), this.wzF.getTop(), this.wzF.getRight(), this.wzF.getBottom());
      h.a locala = h.dii();
      if (locala.type == 100)
      {
        AppMethodBeat.o(103999);
        return;
      }
      if (localFaceDetectView.wBS != null) {
        localFaceDetectView.wBS.dix();
      }
      localFaceDetectView.kSa = false;
      localFaceDetectView.isPaused = false;
      localFaceDetectView.wBY = Util.currentTicks();
      localFaceDetectView.wBW = locala.wwS;
      localFaceDetectView.wBV = locala.nlB;
      Log.i("MicroMsg.FaceDetectView", "carson logic");
      Log.i("MicroMsg.FaceDetectView", "item.hintStr" + locala.nlB);
      localFaceDetectView.wwT = locala.wwT;
      localFaceDetectView.wBT = true;
      localFaceDetectView.wBX = locala.wwW;
      localFaceDetectView.wBS = b.c.a(locala);
      if (localFaceDetectView.wBS != null)
      {
        if (localFaceDetectView.wBP != null) {
          localFaceDetectView.wBP.removeAllViews();
        }
        if (localFaceDetectView.wBQ != null) {
          localFaceDetectView.wBQ.removeAllViews();
        }
        localFaceDetectView.wBS.a(localFaceDetectView.getContext(), localFaceDetectView.wBP, localFaceDetectView.wBQ);
        Log.d("MicroMsg.FaceDetectView", "mBusinessTip : " + localFaceDetectView.wzP);
        localFaceDetectView.wBS.setBusinessTip(localFaceDetectView.wzP);
      }
      if (localFaceDetectView.wBN != null) {
        localFaceDetectView.wBN.a(localRect, locala.wwQ);
      }
      localFaceDetectView.wBU = false;
    }
    AppMethodBeat.o(103999);
  }
  
  public void finish()
  {
    AppMethodBeat.i(104011);
    Log.i("MicroMsg.FaceDetectUI", "alvinluo finish");
    if (this.wzI != null)
    {
      AppMethodBeat.o(104011);
      throw null;
    }
    if (this.wzJ != null) {
      this.wzJ.dismiss();
    }
    Log.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
    Log.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
    if (!this.wzB)
    {
      this.wzO = null;
      this.wzB = true;
      if (this.wzz.wzU)
      {
        diH();
        this.wzE.wBN.wBt.diU();
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
    cZe();
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
    bQm();
    AppMethodBeat.o(104012);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103992);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.iSn = getIntent().getStringExtra("k_user_name");
    this.wvi = getIntent().getIntExtra("scene", -1);
    this.wzP = getIntent().getStringExtra("business_tips");
    paramBundle = (FaceDetectReporter)getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
    Object localObject;
    long l;
    if (paramBundle != null)
    {
      localObject = FaceDetectReporter.dij();
      Log.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { Util.getStack().toString() });
      ((FaceDetectReporter)localObject).wxq = paramBundle.wxq;
      ((FaceDetectReporter)localObject).wxp = paramBundle.wxp;
      ((FaceDetectReporter)localObject).sessionId = paramBundle.sessionId;
      ((FaceDetectReporter)localObject).wxs = paramBundle.wxs;
      ((FaceDetectReporter)localObject).wxt = paramBundle.wxt;
      l = ((FaceDetectReporter)localObject).sessionId;
      if (((FaceDetectReporter)localObject).wxq == null) {
        break label466;
      }
    }
    label466:
    for (paramBundle = ((FaceDetectReporter)localObject).wxq.toString();; paramBundle = "null")
    {
      Log.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramBundle });
      paramBundle = com.tencent.mm.plugin.facedetect.c.b.wwo;
      this.wzK = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.wvi, getIntent().getExtras());
      getWindow().setFlags(1024, 1024);
      this.wzH = ((Button)findViewById(a.e.left_btn));
      this.wzH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103977);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
          FaceDetectUI.a(FaceDetectUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103977);
        }
      });
      this.wzC = findViewById(a.e.face_detect_cover);
      this.wzC.setVisibility(8);
      this.wzD = ((RelativeLayout)findViewById(a.e.face_hold_area));
      this.wzF = ((FaceScanRect)findViewById(a.e.face_fixed_rect));
      this.wzE = ((FaceDetectView)findViewById(a.e.face_detect_view));
      this.wzG = ((TextView)findViewById(a.e.err_msg_tv));
      this.wzE.setCallback(this);
      this.wzE.setBusinessTip(this.wzP);
      paramBundle = this.wzE;
      localObject = this.wzD;
      ViewGroup localViewGroup = this.wzF.getCenterHintHolder();
      paramBundle.wBP = ((ViewGroup)localObject);
      paramBundle.wBQ = localViewGroup;
      this.wzE.setErrTextView(this.wzG);
      this.wzE.y(true, this.iSn);
      this.wzF.setOnRefreshRectListener(new FaceScanRect.b()
      {
        public final void onRefresh()
        {
          AppMethodBeat.i(103979);
          Object localObject = FaceDetectUI.c(FaceDetectUI.this);
          RectF localRectF = new RectF(FaceDetectUI.b(FaceDetectUI.this).getLeft(), FaceDetectUI.b(FaceDetectUI.this).getTop(), FaceDetectUI.b(FaceDetectUI.this).getRight(), FaceDetectUI.b(FaceDetectUI.this).getBottom());
          localObject = ((FaceDetectView)localObject).wBO;
          ((FaceDetectDecorView)localObject).wBJ = true;
          ((FaceDetectDecorView)localObject).wBK = true;
          ((FaceDetectDecorView)localObject).wBL = localRectF;
          ((FaceDetectDecorView)localObject).invalidate();
          AppMethodBeat.o(103979);
        }
      });
      this.wzF.setVisibility(4);
      this.wzz = new b((byte)0);
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
        FaceDetectUI.a(FaceDetectUI.this, paramAnonymousComponentName.wyN);
        paramAnonymousComponentName = com.tencent.mm.plugin.facedetect.model.f.wwI;
        paramAnonymousIBinder = FaceDetectUI.d(FaceDetectUI.this);
        Log.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()), Integer.valueOf(paramAnonymousComponentName.hashCode()) });
        paramAnonymousComponentName.wwJ = paramAnonymousIBinder;
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
    com.tencent.mm.by.c.a((Intent)localObject, this.mConnection, "tools");
    AppMethodBeat.o(103994);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103995);
    super.onStop();
    Log.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
    cZe();
    if (!this.wzN)
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
    private boolean wzT = true;
    boolean wzU = false;
    private boolean wzV = true;
    private final boolean wzW = true;
    
    private b() {}
    
    public final void diI()
    {
      try
      {
        this.wzU = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void diJ()
    {
      try
      {
        AppMethodBeat.i(103990);
        Log.i("MicroMsg.FaceDetectUI", "toString: %s", new Object[] { toString() });
        if ((this.wzT) && (this.wzU) && (this.wzV)) {
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
        this.wzU = false;
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
      String str = "InitHandler{isCgiInitDone=" + this.wzT + ", isCameraInitDone=" + this.wzU + ", isLightInitDone=true, isLibraryInitDone=" + this.wzV + '}';
      AppMethodBeat.o(103991);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI
 * JD-Core Version:    0.7.0.1
 */