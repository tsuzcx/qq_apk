package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.app.a.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI
  extends MMFragmentActivity
  implements a.a, f
{
  private String foE;
  private boolean gRx = false;
  private boolean gnd = false;
  private String mAppId;
  private a qAA = null;
  private FaceTutorial qAB = null;
  private boolean qAC;
  private byte[] qAD;
  private boolean qAE = false;
  private boolean qAF = false;
  private b qAG;
  private boolean qAH = false;
  private boolean qAI = false;
  private String qAJ = null;
  private long qAK = -1L;
  private Messenger qAL = null;
  private a qAM = null;
  private int qAN = -1;
  private boolean qAO = false;
  private com.tencent.mm.plugin.facedetectlight.Utils.a qAP;
  private RelativeLayout qAQ;
  private boolean qAR = false;
  private int qAS = -1;
  private boolean qAT = false;
  private float qAU = 0.0F;
  private com.tencent.mm.plugin.facedetect.c.a qAz = null;
  private int qvP;
  private com.tencent.mm.plugin.facedetect.b.d qvQ = null;
  private int qwa;
  private String qwu = null;
  private float qww;
  private long qxq;
  private int qzZ;
  
  private void a(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(103955);
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[] { paramString2 });
    Object localObject;
    if (this.qAT)
    {
      localObject = findViewById(2131299729);
      if (localObject != null)
      {
        ac.i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
        ((View)localObject).setVisibility(8);
      }
      this.qAQ.setVisibility(0);
    }
    if (paramBoolean)
    {
      localObject = getResources().getString(2131758762);
      if (!paramBoolean) {
        break label202;
      }
    }
    label202:
    for (String str = getResources().getString(2131755691);; str = null)
    {
      paramString2 = a.a(2131232130, paramString2, (String)localObject, str, new View.OnClickListener()new View.OnClickListener
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103920);
          if (paramBoolean)
          {
            if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null)
            {
              FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).cnd();
              AppMethodBeat.o(103920);
            }
          }
          else
          {
            if (paramc != null) {
              paramc.v(paramInt1, paramInt2, paramString1);
            }
            FaceDetectPrepareUI.this.a(paramInt1, paramInt2, paramString1, null);
          }
          AppMethodBeat.o(103920);
        }
      }, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103921);
          FaceDetectPrepareUI.this.a(paramInt1, paramInt2, paramString1, null);
          AppMethodBeat.o(103921);
        }
      });
      paramString2.status = 3;
      paramString1 = getString(2131758717);
      if (this.qwu == null) {
        paramString1 = null;
      }
      a.a(paramString2, paramString1, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103922);
          if (bs.isNullOrNil(FaceDetectPrepareUI.e(FaceDetectPrepareUI.this)))
          {
            ac.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
            AppMethodBeat.o(103922);
            return;
          }
          FaceDetectPrepareUI.f(FaceDetectPrepareUI.this);
          try
          {
            if (FaceDetectPrepareUI.g(FaceDetectPrepareUI.this) != null) {}
            for (paramAnonymousView = FaceDetectPrepareUI.g(FaceDetectPrepareUI.this);; paramAnonymousView = "")
            {
              paramAnonymousView = com.tencent.mm.compatible.util.p.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { paramAnonymousView, Integer.valueOf(paramInt2), "" }), "UTF-8");
              paramAnonymousView = FaceDetectPrepareUI.e(FaceDetectPrepareUI.this) + "?customInfo=" + paramAnonymousView;
              ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[] { paramAnonymousView });
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", paramAnonymousView);
              com.tencent.mm.br.d.b(FaceDetectPrepareUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(103922);
              return;
            }
            return;
          }
          catch (Exception paramAnonymousView)
          {
            ac.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", paramAnonymousView, "alvinluo start feedback webview exception", new Object[0]);
            AppMethodBeat.o(103922);
          }
        }
      });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103923);
          FaceDetectPrepareUI.this.a(true, this.qAY, paramString2);
          AppMethodBeat.o(103923);
        }
      });
      AppMethodBeat.o(103955);
      return;
      localObject = getString(2131758760);
      break;
    }
  }
  
  private void aS(int paramInt, String paramString)
  {
    AppMethodBeat.i(103968);
    if (hasError()) {
      if (this.qAz != null) {
        this.qAz.c(this.qAG.errType, this.qAG.errCode, this.qAG.errMsg, this.qAG.extras);
      }
    }
    for (;;)
    {
      this.gRx = true;
      finish();
      AppMethodBeat.o(103968);
      return;
      if (this.qAz != null) {
        this.qAz.aQ(paramInt, paramString);
      }
    }
  }
  
  private void bgn()
  {
    AppMethodBeat.i(103963);
    c(4, 90013, "init lib failed", getString(2131758723));
    AppMethodBeat.o(103963);
  }
  
  private void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103964);
    ac.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    d(paramInt1, paramInt2, paramString1, null);
    this.qAF = true;
    a(paramInt1, paramInt2, paramString1, paramString2, false, new c()
    {
      public final void v(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(103932);
        if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
          FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, FaceDetectPrepareUI.i(FaceDetectPrepareUI.this).extras);
        }
        AppMethodBeat.o(103932);
      }
    });
    AppMethodBeat.o(103964);
  }
  
  private void cod()
  {
    AppMethodBeat.i(103947);
    if (this.qAz != null) {
      this.qAz.cnd();
    }
    AppMethodBeat.o(103947);
  }
  
  private void coe()
  {
    AppMethodBeat.i(103949);
    switch (this.qzZ)
    {
    default: 
      this.qAS = 0;
      AppMethodBeat.o(103949);
      return;
    case 0: 
      this.qAS = 0;
      FaceDetectReporter.cnC().qye = 4;
      AppMethodBeat.o(103949);
      return;
    case 1: 
      this.qAS = 1;
      FaceDetectReporter.cnC().qye = 6;
      AppMethodBeat.o(103949);
      return;
    }
    float f = this.qAP.getLux();
    FaceDetectReporter.cnC().qyf = Math.round(f);
    ac.i("MicroMsg.FaceDetectPrepareUI", "curLux is : ".concat(String.valueOf(f)));
    ac.i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.qww);
    if (f < this.qww)
    {
      this.qAP.stop();
      this.qAS = 1;
      FaceDetectReporter.cnC().qye = 6;
      AppMethodBeat.o(103949);
      return;
    }
    this.qAS = 0;
    FaceDetectReporter.cnC().qye = 4;
    AppMethodBeat.o(103949);
  }
  
  private void cof()
  {
    AppMethodBeat.i(103950);
    this.qAN = 2;
    if (this.qAz != null) {
      this.qAz.CO(0);
    }
    Intent localIntent = new Intent(this, FaceDetectUI.class);
    localIntent.putExtra("k_user_name", this.foE);
    localIntent.putExtra("k_server_scene", this.qvP);
    localIntent.putExtra("k_need_signature", this.qAC);
    localIntent.putExtra("k_bio_id", String.valueOf(this.qxq));
    localIntent.putExtra("k_bio_config", this.qAD);
    localIntent.putExtra("business_tips", this.qAJ);
    ac.i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
    ac.i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.qAD);
    ac.i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.qxq + "  string：" + String.valueOf(this.qxq));
    ac.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[] { Long.valueOf(FaceDetectReporter.cnC().sessionId) });
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cnC());
    localIntent.putExtra("key_reporter_bundle", localBundle);
    if (this.qAA != null) {
      this.qAA.cob();
    }
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(103950);
  }
  
  private void cog()
  {
    AppMethodBeat.i(103952);
    if (this.qAA != null) {
      this.qAA.dismiss();
    }
    ac.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.qAR) });
    if (!this.qAR)
    {
      this.qAA = new a(this);
      this.qAA.create();
      AppMethodBeat.o(103952);
      return;
    }
    this.qAA = new b(this);
    this.qAA.create();
    AppMethodBeat.o(103952);
  }
  
  private void coh()
  {
    AppMethodBeat.i(103954);
    String str = getString(2131758727);
    c localc = a.b(2131232119, str, null, getString(2131755691), null, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103942);
        FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, 90005, "user cancel in uploading");
        AppMethodBeat.o(103942);
      }
    });
    localc.qCf = true;
    localc.qCh = (str.length() - 3);
    localc.status = 1;
    a(false, true, localc);
    AppMethodBeat.o(103954);
  }
  
  private void coi()
  {
    AppMethodBeat.i(103962);
    c(4, 90011, "get image failed", getString(2131758718));
    AppMethodBeat.o(103962);
  }
  
  private boolean hasError()
  {
    AppMethodBeat.i(103965);
    boolean bool2 = this.qAE;
    if (this.qAG == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(hashCode()) });
      if ((!this.qAE) || (this.qAG == null)) {
        break;
      }
      AppMethodBeat.o(103965);
      return true;
    }
    AppMethodBeat.o(103965);
    return false;
  }
  
  private void q(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(103946);
    if (paramBundle != null) {}
    for (Object localObject = paramBundle.toString();; localObject = "null")
    {
      ac.i("MicroMsg.FaceDetectPrepareUI", "hy: sending msg: cmd: %d, data: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putInt("k_cmd", paramInt);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtras((Bundle)localObject);
      com.tencent.mm.br.d.l(paramBundle, "tools");
      AppMethodBeat.o(103946);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(103956);
    ac.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramBundle != null) {
      paramBundle.putString("k_bio_id", String.valueOf(this.qxq));
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", l.CU(paramInt2));
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(-1, paramString);
    if (this.qAH)
    {
      this.qAI = true;
      q(5, this.qAz.cnh());
      paramString = FaceDetectReporter.cnC();
      if (!this.qAH) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      paramString.qyg = paramInt1;
      finish();
      AppMethodBeat.o(103956);
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c paramc)
  {
    AppMethodBeat.i(103953);
    if (paramBoolean2)
    {
      ac.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103941);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103940);
              FaceDetectPrepareUI.d(FaceDetectPrepareUI.this).V(this.qBd);
              AppMethodBeat.o(103940);
            }
          });
          AppMethodBeat.o(103941);
        }
      }, "face_refresh_background");
    }
    this.qAA.a(paramc);
    AppMethodBeat.o(103953);
  }
  
  public final void cnd()
  {
    AppMethodBeat.i(103948);
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
    if (this.qAz != null)
    {
      String str = getIntent().getExtras().getString("k_ticket");
      if (!bs.isNullOrNil(str))
      {
        ac.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
        com.tencent.mm.plugin.facedetect.b.p.ace(str);
      }
    }
    ac.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.qAR) });
    if (!this.qAR)
    {
      ac.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[] { Boolean.TRUE });
      this.qAK = bs.Gn();
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103939);
          final Bitmap localBitmap = com.tencent.mm.plugin.facedetect.model.p.acg(FaceDetectPrepareUI.c(FaceDetectPrepareUI.this));
          ap.f(new Runnable()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(103937);
              FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, 90003, "user cancel in init");
              AppMethodBeat.o(103937);
            }
          }
          {
            public final void run()
            {
              AppMethodBeat.i(103938);
              c localc = a.a(FaceDetectPrepareUI.this, this.qBb);
              localc.qCi = localBitmap;
              FaceDetectPrepareUI.this.a(false, false, localc);
              AppMethodBeat.o(103938);
            }
          });
          AppMethodBeat.o(103939);
        }
      }, "face_prepareInit");
    }
    coe();
    int i;
    switch (this.qAS)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      if ((this.qvP == 0) || (this.qvP == 1) || (this.qvP == 3) || (this.qvP == 4)) {
        i = 1;
      }
      this.qwa = i;
      if (this.qAz != null)
      {
        this.qAz.qwO = this.qwa;
        this.qAz.cnc();
      }
      this.qAO = true;
      AppMethodBeat.o(103948);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public final void cnf() {}
  
  public final void cni()
  {
    this.qAO = false;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103966);
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(hashCode()) });
    if (this.qAG == null) {
      this.qAG = new b((byte)0);
    }
    this.qAE = true;
    this.qAG.e(paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(103966);
  }
  
  public void finish()
  {
    AppMethodBeat.i(103961);
    ac.i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
    if ((this.qAA != null) && (this.qAA.bjw())) {
      this.qAA.dismiss();
    }
    if (this.qAB != null) {
      this.qAB.dismiss();
    }
    ac.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
    if (this.qAz != null) {
      this.qAz.cnf();
    }
    super.finish();
    this.gnd = true;
    AppMethodBeat.o(103961);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(103951);
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      this.qAN = 1;
      this.qAQ.setVisibility(0);
      if (paramIntent == null)
      {
        ac.e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
        a(4, 90018, "system error", getString(2131758738), false, new c()
        {
          public final void v(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(103933);
            if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
              FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
            }
            AppMethodBeat.o(103933);
          }
        });
        AppMethodBeat.o(103951);
        return;
      }
      localObject = (FaceDetectReporter)paramIntent.getParcelableExtra("key_parcelable_reporter");
      if (localObject != null) {
        FaceDetectReporter.cnC().a((FaceDetectReporter)localObject);
      }
      localObject = FaceDetectReporter.cnC();
      if (this.qAH) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        ((FaceDetectReporter)localObject).qyg = paramInt1;
        FaceDetectReporter.cnC().qyf = Math.round(this.qAU);
        paramInt1 = paramIntent.getIntExtra("err_type", -1);
        paramInt2 = paramIntent.getIntExtra("err_code", -1);
        str = paramIntent.getStringExtra("err_msg");
        if (this.qAz != null)
        {
          localObject = this.qAz;
          paramIntent.getExtras();
          ((com.tencent.mm.plugin.facedetect.c.a)localObject).t(paramInt1, paramInt2, str);
        }
        ac.i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        coh();
        q(6, paramIntent.getExtras());
        AppMethodBeat.o(103951);
        return;
      }
      if (paramInt1 == 1)
      {
        if ((paramInt2 == 90004) || (paramInt2 == 90025))
        {
          aS(paramInt2, str);
          AppMethodBeat.o(103951);
        }
      }
      else
      {
        localObject = paramIntent.getStringExtra("show_err_msg");
        if (paramInt2 != 90013) {
          break label381;
        }
        paramIntent = getString(2131758723);
      }
      for (;;)
      {
        d(paramInt1, paramInt2, str, null);
        if (paramInt2 == 90023) {
          bool1 = true;
        }
        a(paramInt1, paramInt2, str, paramIntent, bool1, new c()
        {
          public final void v(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
          {
            AppMethodBeat.i(103934);
            if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
              FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
            }
            AppMethodBeat.o(103934);
          }
        });
        AppMethodBeat.o(103951);
        return;
        label381:
        if ((paramInt2 == 90008) || (paramInt2 == 90010))
        {
          paramIntent = getString(2131761860);
        }
        else if (paramInt2 == 90009)
        {
          paramIntent = getString(2131761871);
        }
        else
        {
          paramIntent = (Intent)localObject;
          if (bs.isNullOrNil((String)localObject)) {
            paramIntent = getString(2131764085);
          }
        }
      }
    }
    this.qAN = 1;
    if (paramIntent == null)
    {
      ac.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
      a(4, 90018, "system error", getString(2131758738), false, new c()
      {
        public final void v(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
        {
          AppMethodBeat.i(103935);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          AppMethodBeat.o(103935);
        }
      });
      AppMethodBeat.o(103951);
      return;
    }
    Object localObject = (FaceDetectReporter)paramIntent.getParcelableExtra("key_parcelable_reporter");
    if (localObject != null) {
      FaceDetectReporter.cnC().a((FaceDetectReporter)localObject);
    }
    paramInt1 = paramIntent.getIntExtra("err_type", -1);
    paramInt2 = paramIntent.getIntExtra("err_code", -1);
    String str = paramIntent.getStringExtra("err_msg");
    if (this.qAz != null)
    {
      localObject = this.qAz;
      paramIntent.getExtras();
      ((com.tencent.mm.plugin.facedetect.c.a)localObject).t(paramInt1, paramInt2, str);
    }
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      coh();
      q(1, null);
      AppMethodBeat.o(103951);
      return;
    }
    if (paramInt1 == 1)
    {
      if ((paramInt2 == 90004) || (paramInt2 == 90025))
      {
        aS(paramInt2, str);
        AppMethodBeat.o(103951);
      }
    }
    else
    {
      localObject = paramIntent.getStringExtra("show_err_msg");
      if (paramInt2 != 90013) {
        break label738;
      }
      paramIntent = getString(2131758723);
    }
    for (;;)
    {
      d(paramInt1, paramInt2, str, null);
      bool1 = bool2;
      if (paramInt2 == 90023) {
        bool1 = true;
      }
      a(paramInt1, paramInt2, str, paramIntent, bool1, new c()
      {
        public final void v(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
        {
          AppMethodBeat.i(103936);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          AppMethodBeat.o(103936);
        }
      });
      AppMethodBeat.o(103951);
      return;
      label738:
      if ((paramInt2 == 90008) || (paramInt2 == 90010))
      {
        paramIntent = getString(2131761860);
      }
      else if (paramInt2 == 90009)
      {
        paramIntent = getString(2131761871);
      }
      else
      {
        paramIntent = (Intent)localObject;
        if (bs.isNullOrNil((String)localObject)) {
          paramIntent = getString(2131764085);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103967);
    if (hasError())
    {
      if (this.qAz != null)
      {
        this.qAz.c(this.qAG.errType, this.qAG.errCode, this.qAG.errMsg, this.qAG.extras);
        AppMethodBeat.o(103967);
      }
    }
    else
    {
      if (this.qAN == 1)
      {
        aS(90003, "user cancel in init");
        AppMethodBeat.o(103967);
        return;
      }
      if (this.qAN == 3)
      {
        aS(90005, "user cancel in uploading");
        AppMethodBeat.o(103967);
        return;
      }
      if (this.qAN == 0)
      {
        aS(90002, "user cancel in tutorial");
        AppMethodBeat.o(103967);
        return;
      }
      aS(90050, "user cancel unknown");
    }
    AppMethodBeat.o(103967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103945);
    super.onCreate(paramBundle);
    setContentView(2131493917);
    this.qAQ = ((RelativeLayout)findViewById(2131299696));
    this.qAQ.setVisibility(4);
    getWindow().addFlags(2097280);
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.foE = getIntent().getStringExtra("k_user_name");
    this.qvP = getIntent().getIntExtra("k_server_scene", -1);
    this.qAC = getIntent().getBooleanExtra("k_need_signature", false);
    boolean bool;
    if ((e.cnn()) || (getIntent().getBooleanExtra("key_is_need_video", false)))
    {
      bool = true;
      this.qAH = bool;
      this.qwu = getIntent().getStringExtra("key_feedback_url");
      this.qAJ = getIntent().getStringExtra("business_tips");
      this.qzZ = getIntent().getIntExtra("check_alive_type_response", -1);
      if (this.qzZ == -1) {
        this.qzZ = getIntent().getIntExtra("check_alive_type", 0);
      }
      this.qww = getIntent().getFloatExtra("mLight_threshold", -1.0F);
      this.qAP = a.b.coM();
      this.qAP.coL();
      ac.i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.qAH);
      ac.i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.qzZ);
      ac.i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.qww);
      ac.i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.qwa);
      this.qAM = new a(this, (byte)0);
      this.qAL = new Messenger(this.qAM);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtra("k_messenger", this.qAL);
      com.tencent.mm.br.d.l(paramBundle, "tools");
      FaceContextData.a(new FaceContextData());
      com.tencent.mm.plugin.facedetect.model.p.am(this);
      paramBundle = getIntent().getExtras();
      float f = this.qAP.getLux();
      this.qAU = f;
      if (paramBundle != null)
      {
        paramBundle.putFloat("key_current_light", f);
        paramBundle.putBoolean("key_upload_video", this.qAH);
      }
      com.tencent.mm.plugin.facedetect.c.b localb = com.tencent.mm.plugin.facedetect.c.b.qwS;
      this.qAz = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.qvP, this.qwa, paramBundle);
      if (this.qAz != null) {
        break label603;
      }
      bgn();
      label483:
      if (this.qAG != null)
      {
        paramBundle = this.qAG;
        paramBundle.errType = -1;
        paramBundle.errCode = -1;
        paramBundle.errMsg = "";
        if (paramBundle.extras != null) {
          paramBundle.extras.clear();
        }
      }
      this.qAE = false;
      this.qAN = 1;
      cog();
      if (!com.tencent.mm.plugin.facedetect.model.p.al(this)) {
        break label644;
      }
      ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
      cod();
    }
    for (;;)
    {
      if (this.qAH)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("key_is_need_video", this.qAH);
        q(4, paramBundle);
      }
      AppMethodBeat.o(103945);
      return;
      bool = false;
      break;
      label603:
      this.qAz.a(new com.tencent.mm.plugin.facedetect.b.c()
      {
        public final void aP(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(103925);
          ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(90015), paramAnonymousString });
          paramAnonymousInt = FaceDetectPrepareUI.CZ(paramAnonymousInt);
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt, 90015, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131758723));
          AppMethodBeat.o(103925);
        }
        
        public final void e(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(103924);
          ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[] { Long.valueOf(paramAnonymousLong), Boolean.valueOf(FaceDetectPrepareUI.h(FaceDetectPrepareUI.this)) });
          if (FaceDetectPrepareUI.h(FaceDetectPrepareUI.this))
          {
            AppMethodBeat.o(103924);
            return;
          }
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousLong);
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousArrayOfByte);
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(103924);
        }
      });
      this.qvQ = new com.tencent.mm.plugin.facedetect.b.d()
      {
        private double qAZ = 0.0D;
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
        {
          AppMethodBeat.i(103927);
          ac.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131764085));
          AppMethodBeat.o(103927);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(103929);
          ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousn.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousInt1 = FaceDetectPrepareUI.CZ(paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            FaceDetectPrepareUI.this.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousn);
          }
          AppMethodBeat.o(103929);
        }
        
        public final void n(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(103928);
          ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
          int i = FaceDetectPrepareUI.CZ(0);
          if (i != 0) {
            FaceDetectPrepareUI.this.d(i, 0, paramAnonymousString, paramAnonymousBundle);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).b(i, paramAnonymousString, paramAnonymousBundle);
          }
          AppMethodBeat.o(103928);
        }
        
        public final void t(double paramAnonymousDouble)
        {
          AppMethodBeat.i(103926);
          ac.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          this.qAZ = (100.0D * paramAnonymousDouble);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this);
          }
          AppMethodBeat.o(103926);
        }
      };
      this.qAz.a(this.qvQ);
      break label483;
      label644:
      ac.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103957);
    ac.i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
    super.onDestroy();
    if (!this.qAI) {
      com.tencent.mm.br.d.n(new Intent(this, FaceDetectProcessService.class), "tools");
    }
    if (this.qAP != null) {
      this.qAP.stop();
    }
    AppMethodBeat.o(103957);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 90008;
    AppMethodBeat.i(103969);
    ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(103969);
      return;
    }
    switch (paramInt)
    {
    default: 
      ac.i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
      AppMethodBeat.o(103969);
      return;
    }
    Object localObject1 = "";
    String str = "";
    if (paramArrayOfInt.length == 1)
    {
      if (paramArrayOfInt[0] == 0)
      {
        paramInt = 1;
        label95:
        if (paramInt == 0) {
          break label255;
        }
        cod();
        AppMethodBeat.o(103969);
        return;
      }
      if (paramArrayOfString[0].equals("android.permission.CAMERA"))
      {
        localObject1 = "camera permission not granted";
        paramArrayOfString = getString(2131761860);
        paramInt = i;
      }
    }
    for (;;)
    {
      this.qAQ.setVisibility(0);
      ac.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", new Object[] { Integer.valueOf(this.qAQ.getVisibility()) });
      paramArrayOfInt = findViewById(2131299729);
      if (paramArrayOfInt != null) {
        paramArrayOfInt.setVisibility(8);
      }
      c(1, paramInt, (String)localObject1, paramArrayOfString);
      paramInt = 0;
      break label95;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        paramInt = 90009;
        localObject1 = "audio permission not granted";
        paramArrayOfString = getString(2131761871);
        continue;
        if (paramArrayOfInt.length == 2)
        {
          if ((paramArrayOfInt[0] == 0) && (paramArrayOfInt[1] == 0))
          {
            paramInt = 1;
            break label95;
            label255:
            break;
          }
          Object localObject2;
          if (paramArrayOfInt[0] != 0)
          {
            localObject2 = "camera permission not granted";
            str = getString(2131761860);
          }
          for (;;)
          {
            if (paramArrayOfInt[1] != 0)
            {
              i = 90009;
              localObject2 = "audio permission not granted";
              str = getString(2131761871);
            }
            paramArrayOfString = str;
            localObject1 = localObject2;
            paramInt = i;
            if (paramArrayOfInt[0] == 0) {
              break;
            }
            paramArrayOfString = str;
            localObject1 = localObject2;
            paramInt = i;
            if (paramArrayOfInt[1] == 0) {
              break;
            }
            paramInt = 90010;
            localObject1 = "both camera and audio permission not granted";
            paramArrayOfString = getString(2131761860);
            break;
            i = -1;
            localObject2 = localObject1;
          }
        }
      }
      paramInt = -1;
      paramArrayOfString = str;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(103959);
    ac.i("MicroMsg.FaceDetectPrepareUI", "onResume");
    super.onResume();
    this.qAO = true;
    AppMethodBeat.o(103959);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(103958);
    super.onStart();
    AppMethodBeat.o(103958);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(103960);
    super.onStop();
    if (this.qAO)
    {
      if ((!this.gnd) && (hasError()))
      {
        a(this.qAG.errType, this.qAG.errCode, this.qAG.errMsg, this.qAG.extras);
        AppMethodBeat.o(103960);
        return;
      }
      finish();
    }
    AppMethodBeat.o(103960);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends Handler
  {
    private WeakReference<FaceDetectPrepareUI> qAq;
    
    private a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
    {
      AppMethodBeat.i(103943);
      this.qAq = null;
      this.qAq = new WeakReference(paramFaceDetectPrepareUI);
      AppMethodBeat.o(103943);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(103944);
      ac.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      if ((this.qAq != null) && (this.qAq.get() != null)) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.a((FaceDetectPrepareUI)this.qAq.get(), paramMessage);
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.b((FaceDetectPrepareUI)this.qAq.get(), paramMessage);
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.c((FaceDetectPrepareUI)this.qAq.get(), paramMessage);
      }
    }
  }
  
  final class b
  {
    int errCode;
    String errMsg;
    int errType;
    Bundle extras;
    
    private b() {}
    
    final void e(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
    {
      this.errType = paramInt1;
      this.errCode = paramInt2;
      this.errMsg = paramString;
      this.extras = paramBundle;
    }
  }
  
  static abstract interface c
  {
    public abstract void v(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI
 * JD-Core Version:    0.7.0.1
 */