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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI
  extends MMFragmentActivity
  implements a.a, f
{
  private String flk;
  private boolean goa = false;
  private boolean gqP = false;
  private String mAppId;
  private String pNM = null;
  private float pNO;
  private int pNh;
  private com.tencent.mm.plugin.facedetect.b.d pNi = null;
  private int pNs;
  private long pOI;
  private com.tencent.mm.plugin.facedetect.c.a pRR = null;
  private a pRS = null;
  private FaceTutorial pRT = null;
  private boolean pRU;
  private byte[] pRV;
  private boolean pRW = false;
  private boolean pRX = false;
  private b pRY;
  private boolean pRZ = false;
  private int pRr;
  private boolean pSa = false;
  private String pSb = null;
  private long pSc = -1L;
  private Messenger pSd = null;
  private a pSe = null;
  private int pSf = -1;
  private boolean pSg = false;
  private com.tencent.mm.plugin.facedetectlight.Utils.a pSh;
  private RelativeLayout pSi;
  private boolean pSj = false;
  private int pSk = -1;
  private boolean pSl = false;
  private float pSm = 0.0F;
  
  private void a(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(103955);
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[] { paramString2 });
    Object localObject;
    if (this.pSl)
    {
      localObject = findViewById(2131299729);
      if (localObject != null)
      {
        ad.i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
        ((View)localObject).setVisibility(8);
      }
      this.pSi.setVisibility(0);
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
              FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).cfw();
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
      if (this.pNM == null) {
        paramString1 = null;
      }
      a.a(paramString2, paramString1, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103922);
          if (bt.isNullOrNil(FaceDetectPrepareUI.e(FaceDetectPrepareUI.this)))
          {
            ad.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
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
              ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[] { paramAnonymousView });
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", paramAnonymousView);
              com.tencent.mm.bs.d.b(FaceDetectPrepareUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(103922);
              return;
            }
            return;
          }
          catch (Exception paramAnonymousView)
          {
            ad.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", paramAnonymousView, "alvinluo start feedback webview exception", new Object[0]);
            AppMethodBeat.o(103922);
          }
        }
      });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103923);
          FaceDetectPrepareUI.this.a(true, this.pSq, paramString2);
          AppMethodBeat.o(103923);
        }
      });
      AppMethodBeat.o(103955);
      return;
      localObject = getString(2131758760);
      break;
    }
  }
  
  private void aP(int paramInt, String paramString)
  {
    AppMethodBeat.i(103968);
    if (hasError()) {
      if (this.pRR != null) {
        this.pRR.c(this.pRY.errType, this.pRY.errCode, this.pRY.errMsg, this.pRY.extras);
      }
    }
    for (;;)
    {
      this.gqP = true;
      finish();
      AppMethodBeat.o(103968);
      return;
      if (this.pRR != null) {
        this.pRR.aN(paramInt, paramString);
      }
    }
  }
  
  private void aZv()
  {
    AppMethodBeat.i(103963);
    c(4, 90013, "init lib failed", getString(2131758723));
    AppMethodBeat.o(103963);
  }
  
  private void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103964);
    ad.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    d(paramInt1, paramInt2, paramString1, null);
    this.pRX = true;
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
  
  private void cgA()
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
    localc.pTA = true;
    localc.pTC = (str.length() - 3);
    localc.status = 1;
    a(false, true, localc);
    AppMethodBeat.o(103954);
  }
  
  private void cgB()
  {
    AppMethodBeat.i(103962);
    c(4, 90011, "get image failed", getString(2131758718));
    AppMethodBeat.o(103962);
  }
  
  private void cgw()
  {
    AppMethodBeat.i(103947);
    if (this.pRR != null) {
      this.pRR.cfw();
    }
    AppMethodBeat.o(103947);
  }
  
  private void cgx()
  {
    AppMethodBeat.i(103949);
    switch (this.pRr)
    {
    default: 
      this.pSk = 0;
      AppMethodBeat.o(103949);
      return;
    case 0: 
      this.pSk = 0;
      FaceDetectReporter.cfV().pPw = 4;
      AppMethodBeat.o(103949);
      return;
    case 1: 
      this.pSk = 1;
      FaceDetectReporter.cfV().pPw = 6;
      AppMethodBeat.o(103949);
      return;
    }
    float f = this.pSh.getLux();
    FaceDetectReporter.cfV().pPx = Math.round(f);
    ad.i("MicroMsg.FaceDetectPrepareUI", "curLux is : ".concat(String.valueOf(f)));
    ad.i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.pNO);
    if (f < this.pNO)
    {
      this.pSh.stop();
      this.pSk = 1;
      FaceDetectReporter.cfV().pPw = 6;
      AppMethodBeat.o(103949);
      return;
    }
    this.pSk = 0;
    FaceDetectReporter.cfV().pPw = 4;
    AppMethodBeat.o(103949);
  }
  
  private void cgy()
  {
    AppMethodBeat.i(103950);
    this.pSf = 2;
    if (this.pRR != null) {
      this.pRR.BT(0);
    }
    Intent localIntent = new Intent(this, FaceDetectUI.class);
    localIntent.putExtra("k_user_name", this.flk);
    localIntent.putExtra("k_server_scene", this.pNh);
    localIntent.putExtra("k_need_signature", this.pRU);
    localIntent.putExtra("k_bio_id", String.valueOf(this.pOI));
    localIntent.putExtra("k_bio_config", this.pRV);
    localIntent.putExtra("business_tips", this.pSb);
    ad.i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
    ad.i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.pRV);
    ad.i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.pOI + "  string：" + String.valueOf(this.pOI));
    ad.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[] { Long.valueOf(FaceDetectReporter.cfV().sessionId) });
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cfV());
    localIntent.putExtra("key_reporter_bundle", localBundle);
    if (this.pRS != null) {
      this.pRS.cgu();
    }
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(103950);
  }
  
  private void cgz()
  {
    AppMethodBeat.i(103952);
    if (this.pRS != null) {
      this.pRS.dismiss();
    }
    ad.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.pSj) });
    if (!this.pSj)
    {
      this.pRS = new a(this);
      this.pRS.create();
      AppMethodBeat.o(103952);
      return;
    }
    this.pRS = new b(this);
    this.pRS.create();
    AppMethodBeat.o(103952);
  }
  
  private boolean hasError()
  {
    AppMethodBeat.i(103965);
    boolean bool2 = this.pRW;
    if (this.pRY == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(hashCode()) });
      if ((!this.pRW) || (this.pRY == null)) {
        break;
      }
      AppMethodBeat.o(103965);
      return true;
    }
    AppMethodBeat.o(103965);
    return false;
  }
  
  private void p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(103946);
    if (paramBundle != null) {}
    for (Object localObject = paramBundle.toString();; localObject = "null")
    {
      ad.i("MicroMsg.FaceDetectPrepareUI", "hy: sending msg: cmd: %d, data: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putInt("k_cmd", paramInt);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtras((Bundle)localObject);
      com.tencent.mm.bs.d.l(paramBundle, "tools");
      AppMethodBeat.o(103946);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(103956);
    ad.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramBundle != null) {
      paramBundle.putString("k_bio_id", String.valueOf(this.pOI));
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", l.BZ(paramInt2));
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(-1, paramString);
    if (this.pRZ)
    {
      this.pSa = true;
      p(5, this.pRR.cfA());
      paramString = FaceDetectReporter.cfV();
      if (!this.pRZ) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      paramString.pPy = paramInt1;
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
      ad.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103941);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103940);
              FaceDetectPrepareUI.d(FaceDetectPrepareUI.this).V(this.pSv);
              AppMethodBeat.o(103940);
            }
          });
          AppMethodBeat.o(103941);
        }
      }, "face_refresh_background");
    }
    this.pRS.a(paramc);
    AppMethodBeat.o(103953);
  }
  
  public final void cfB()
  {
    this.pSg = false;
  }
  
  public final void cfw()
  {
    AppMethodBeat.i(103948);
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
    if (this.pRR != null)
    {
      String str = getIntent().getExtras().getString("k_ticket");
      if (!bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
        com.tencent.mm.plugin.facedetect.b.p.XH(str);
      }
    }
    ad.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.pSj) });
    if (!this.pSj)
    {
      ad.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[] { Boolean.TRUE });
      this.pSc = bt.GC();
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103939);
          final Bitmap localBitmap = com.tencent.mm.plugin.facedetect.model.p.XJ(FaceDetectPrepareUI.c(FaceDetectPrepareUI.this));
          aq.f(new Runnable()
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
              c localc = a.a(FaceDetectPrepareUI.this, this.pSt);
              localc.pTD = localBitmap;
              FaceDetectPrepareUI.this.a(false, false, localc);
              AppMethodBeat.o(103938);
            }
          });
          AppMethodBeat.o(103939);
        }
      }, "face_prepareInit");
    }
    cgx();
    int i;
    switch (this.pSk)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      if ((this.pNh == 0) || (this.pNh == 1) || (this.pNh == 3) || (this.pNh == 4)) {
        i = 1;
      }
      this.pNs = i;
      if (this.pRR != null)
      {
        this.pRR.pOg = this.pNs;
        this.pRR.cfv();
      }
      this.pSg = true;
      AppMethodBeat.o(103948);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public final void cfy() {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103966);
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(hashCode()) });
    if (this.pRY == null) {
      this.pRY = new b((byte)0);
    }
    this.pRW = true;
    this.pRY.e(paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(103966);
  }
  
  public void finish()
  {
    AppMethodBeat.i(103961);
    ad.i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
    if ((this.pRS != null) && (this.pRS.bcB())) {
      this.pRS.dismiss();
    }
    if (this.pRT != null) {
      this.pRT.dismiss();
    }
    ad.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
    if (this.pRR != null) {
      this.pRR.cfy();
    }
    super.finish();
    this.goa = true;
    AppMethodBeat.o(103961);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(103951);
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      this.pSf = 1;
      this.pSi.setVisibility(0);
      if (paramIntent == null)
      {
        ad.e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
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
        FaceDetectReporter.cfV().a((FaceDetectReporter)localObject);
      }
      localObject = FaceDetectReporter.cfV();
      if (this.pRZ) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        ((FaceDetectReporter)localObject).pPy = paramInt1;
        FaceDetectReporter.cfV().pPx = Math.round(this.pSm);
        paramInt1 = paramIntent.getIntExtra("err_type", -1);
        paramInt2 = paramIntent.getIntExtra("err_code", -1);
        str = paramIntent.getStringExtra("err_msg");
        if (this.pRR != null)
        {
          localObject = this.pRR;
          paramIntent.getExtras();
          ((com.tencent.mm.plugin.facedetect.c.a)localObject).t(paramInt1, paramInt2, str);
        }
        ad.i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        cgA();
        p(6, paramIntent.getExtras());
        AppMethodBeat.o(103951);
        return;
      }
      if (paramInt1 == 1)
      {
        if ((paramInt2 == 90004) || (paramInt2 == 90025))
        {
          aP(paramInt2, str);
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
          if (bt.isNullOrNil((String)localObject)) {
            paramIntent = getString(2131764085);
          }
        }
      }
    }
    this.pSf = 1;
    if (paramIntent == null)
    {
      ad.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
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
      FaceDetectReporter.cfV().a((FaceDetectReporter)localObject);
    }
    paramInt1 = paramIntent.getIntExtra("err_type", -1);
    paramInt2 = paramIntent.getIntExtra("err_code", -1);
    String str = paramIntent.getStringExtra("err_msg");
    if (this.pRR != null)
    {
      localObject = this.pRR;
      paramIntent.getExtras();
      ((com.tencent.mm.plugin.facedetect.c.a)localObject).t(paramInt1, paramInt2, str);
    }
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cgA();
      p(1, null);
      AppMethodBeat.o(103951);
      return;
    }
    if (paramInt1 == 1)
    {
      if ((paramInt2 == 90004) || (paramInt2 == 90025))
      {
        aP(paramInt2, str);
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
        if (bt.isNullOrNil((String)localObject)) {
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
      if (this.pRR != null)
      {
        this.pRR.c(this.pRY.errType, this.pRY.errCode, this.pRY.errMsg, this.pRY.extras);
        AppMethodBeat.o(103967);
      }
    }
    else
    {
      if (this.pSf == 1)
      {
        aP(90003, "user cancel in init");
        AppMethodBeat.o(103967);
        return;
      }
      if (this.pSf == 3)
      {
        aP(90005, "user cancel in uploading");
        AppMethodBeat.o(103967);
        return;
      }
      if (this.pSf == 0)
      {
        aP(90002, "user cancel in tutorial");
        AppMethodBeat.o(103967);
        return;
      }
      aP(90050, "user cancel unknown");
    }
    AppMethodBeat.o(103967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103945);
    super.onCreate(paramBundle);
    setContentView(2131493917);
    this.pSi = ((RelativeLayout)findViewById(2131299696));
    this.pSi.setVisibility(4);
    getWindow().addFlags(2097280);
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.flk = getIntent().getStringExtra("k_user_name");
    this.pNh = getIntent().getIntExtra("k_server_scene", -1);
    this.pRU = getIntent().getBooleanExtra("k_need_signature", false);
    boolean bool;
    if ((e.cfG()) || (getIntent().getBooleanExtra("key_is_need_video", false)))
    {
      bool = true;
      this.pRZ = bool;
      this.pNM = getIntent().getStringExtra("key_feedback_url");
      this.pSb = getIntent().getStringExtra("business_tips");
      this.pRr = getIntent().getIntExtra("check_alive_type_response", -1);
      if (this.pRr == -1) {
        this.pRr = getIntent().getIntExtra("check_alive_type", 0);
      }
      this.pNO = getIntent().getFloatExtra("mLight_threshold", -1.0F);
      this.pSh = a.b.chf();
      this.pSh.che();
      ad.i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.pRZ);
      ad.i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.pRr);
      ad.i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.pNO);
      ad.i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.pNs);
      this.pSe = new a(this, (byte)0);
      this.pSd = new Messenger(this.pSe);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtra("k_messenger", this.pSd);
      com.tencent.mm.bs.d.l(paramBundle, "tools");
      FaceContextData.a(new FaceContextData());
      com.tencent.mm.plugin.facedetect.model.p.ai(this);
      paramBundle = getIntent().getExtras();
      float f = this.pSh.getLux();
      this.pSm = f;
      if (paramBundle != null)
      {
        paramBundle.putFloat("key_current_light", f);
        paramBundle.putBoolean("key_upload_video", this.pRZ);
      }
      com.tencent.mm.plugin.facedetect.c.b localb = com.tencent.mm.plugin.facedetect.c.b.pOk;
      this.pRR = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.pNh, this.pNs, paramBundle);
      if (this.pRR != null) {
        break label603;
      }
      aZv();
      label483:
      if (this.pRY != null)
      {
        paramBundle = this.pRY;
        paramBundle.errType = -1;
        paramBundle.errCode = -1;
        paramBundle.errMsg = "";
        if (paramBundle.extras != null) {
          paramBundle.extras.clear();
        }
      }
      this.pRW = false;
      this.pSf = 1;
      cgz();
      if (!com.tencent.mm.plugin.facedetect.model.p.ah(this)) {
        break label644;
      }
      ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
      cgw();
    }
    for (;;)
    {
      if (this.pRZ)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("key_is_need_video", this.pRZ);
        p(4, paramBundle);
      }
      AppMethodBeat.o(103945);
      return;
      bool = false;
      break;
      label603:
      this.pRR.a(new com.tencent.mm.plugin.facedetect.b.c()
      {
        public final void aM(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(103925);
          ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(90015), paramAnonymousString });
          paramAnonymousInt = FaceDetectPrepareUI.Ce(paramAnonymousInt);
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt, 90015, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131758723));
          AppMethodBeat.o(103925);
        }
        
        public final void e(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(103924);
          ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[] { Long.valueOf(paramAnonymousLong), Boolean.valueOf(FaceDetectPrepareUI.h(FaceDetectPrepareUI.this)) });
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
      this.pNi = new com.tencent.mm.plugin.facedetect.b.d()
      {
        private double pSr = 0.0D;
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
        {
          AppMethodBeat.i(103927);
          ad.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131764085));
          AppMethodBeat.o(103927);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(103929);
          ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousn.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousInt1 = FaceDetectPrepareUI.Ce(paramAnonymousInt1);
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
          ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
          int i = FaceDetectPrepareUI.Ce(0);
          if (i != 0) {
            FaceDetectPrepareUI.this.d(i, 0, paramAnonymousString, paramAnonymousBundle);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).b(i, paramAnonymousString, paramAnonymousBundle);
          }
          AppMethodBeat.o(103928);
        }
        
        public final void u(double paramAnonymousDouble)
        {
          AppMethodBeat.i(103926);
          ad.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          this.pSr = (100.0D * paramAnonymousDouble);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this);
          }
          AppMethodBeat.o(103926);
        }
      };
      this.pRR.a(this.pNi);
      break label483;
      label644:
      ad.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103957);
    ad.i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
    super.onDestroy();
    if (!this.pSa) {
      com.tencent.mm.bs.d.n(new Intent(this, FaceDetectProcessService.class), "tools");
    }
    if (this.pSh != null) {
      this.pSh.stop();
    }
    AppMethodBeat.o(103957);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 90008;
    AppMethodBeat.i(103969);
    ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(103969);
      return;
    }
    switch (paramInt)
    {
    default: 
      ad.i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
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
        cgw();
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
      this.pSi.setVisibility(0);
      ad.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", new Object[] { Integer.valueOf(this.pSi.getVisibility()) });
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
    ad.i("MicroMsg.FaceDetectPrepareUI", "onResume");
    super.onResume();
    this.pSg = true;
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
    if (this.pSg)
    {
      if ((!this.goa) && (hasError()))
      {
        a(this.pRY.errType, this.pRY.errCode, this.pRY.errMsg, this.pRY.extras);
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
    private WeakReference<FaceDetectPrepareUI> pRI;
    
    private a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
    {
      AppMethodBeat.i(103943);
      this.pRI = null;
      this.pRI = new WeakReference(paramFaceDetectPrepareUI);
      AppMethodBeat.o(103943);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(103944);
      ad.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      if ((this.pRI != null) && (this.pRI.get() != null)) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.a((FaceDetectPrepareUI)this.pRI.get(), paramMessage);
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.b((FaceDetectPrepareUI)this.pRI.get(), paramMessage);
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.c((FaceDetectPrepareUI)this.pRI.get(), paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI
 * JD-Core Version:    0.7.0.1
 */