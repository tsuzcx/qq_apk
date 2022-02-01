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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI
  extends MMFragmentActivity
  implements a.a, f
{
  private String fIQ;
  private boolean gJv = false;
  private boolean hmD = false;
  private String mAppId;
  private int rnI;
  private com.tencent.mm.plugin.facedetect.b.d rnJ = null;
  private int rnT;
  private String ron = null;
  private float rop;
  private long rpk;
  private int rrS;
  private b rsA;
  private boolean rsB = false;
  private boolean rsC = false;
  private String rsD = null;
  private long rsE = -1L;
  private Messenger rsF = null;
  private a rsG = null;
  private int rsH = -1;
  private boolean rsI = false;
  private com.tencent.mm.plugin.facedetectlight.Utils.a rsJ;
  private RelativeLayout rsK;
  private boolean rsL = false;
  private int rsM = -1;
  private boolean rsN = false;
  private float rsO = 0.0F;
  private com.tencent.mm.plugin.facedetect.c.a rst = null;
  private a rsu = null;
  private FaceTutorial rsv = null;
  private boolean rsw;
  private byte[] rsx;
  private boolean rsy = false;
  private boolean rsz = false;
  
  private void a(final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(103955);
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[] { paramString2 });
    Object localObject;
    if (this.rsN)
    {
      localObject = findViewById(2131299729);
      if (localObject != null)
      {
        ae.i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
        ((View)localObject).setVisibility(8);
      }
      this.rsK.setVisibility(0);
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
      paramString2 = a.a(2131232130, paramString2, (String)localObject, str, new View.OnClickListener()new FaceDetectPrepareUI.3
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(103920);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (paramBoolean) {
            if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
              FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).cuj();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(103920);
            return;
            if (paramc != null) {
              paramc.v(paramInt1, paramInt2, paramString1);
            }
            FaceDetectPrepareUI.this.a(paramInt1, paramInt2, paramString1, null);
          }
        }
      }, new FaceDetectPrepareUI.3(this, paramInt1, paramInt2, paramString1));
      paramString2.status = 3;
      paramString1 = getString(2131758717);
      if (this.ron == null) {
        paramString1 = null;
      }
      a.a(paramString2, paramString1, new FaceDetectPrepareUI.4(this, paramInt2));
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103923);
          FaceDetectPrepareUI.this.a(true, this.rsS, paramString2);
          AppMethodBeat.o(103923);
        }
      });
      AppMethodBeat.o(103955);
      return;
      localObject = getString(2131758760);
      break;
    }
  }
  
  private void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(103968);
    if (hasError()) {
      if (this.rst != null) {
        this.rst.c(this.rsA.errType, this.rsA.errCode, this.rsA.errMsg, this.rsA.extras);
      }
    }
    for (;;)
    {
      this.hmD = true;
      finish();
      AppMethodBeat.o(103968);
      return;
      if (this.rst != null) {
        this.rst.aS(paramInt, paramString);
      }
    }
  }
  
  private void bkA()
  {
    AppMethodBeat.i(103963);
    c(4, 90013, "init lib failed", getString(2131758723));
    AppMethodBeat.o(103963);
  }
  
  private void c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103964);
    ae.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    d(paramInt1, paramInt2, paramString1, null);
    this.rsz = true;
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
  
  private void cvj()
  {
    AppMethodBeat.i(103947);
    if (this.rst != null) {
      this.rst.cuj();
    }
    AppMethodBeat.o(103947);
  }
  
  private void cvk()
  {
    AppMethodBeat.i(103949);
    switch (this.rrS)
    {
    default: 
      this.rsM = 0;
      AppMethodBeat.o(103949);
      return;
    case 0: 
      this.rsM = 0;
      FaceDetectReporter.cuI().rpY = 4;
      AppMethodBeat.o(103949);
      return;
    case 1: 
      this.rsM = 1;
      FaceDetectReporter.cuI().rpY = 6;
      AppMethodBeat.o(103949);
      return;
    }
    float f = this.rsJ.getLux();
    FaceDetectReporter.cuI().rpZ = Math.round(f);
    ae.i("MicroMsg.FaceDetectPrepareUI", "curLux is : ".concat(String.valueOf(f)));
    ae.i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.rop);
    if (f < this.rop)
    {
      this.rsJ.stop();
      this.rsM = 1;
      FaceDetectReporter.cuI().rpY = 6;
      AppMethodBeat.o(103949);
      return;
    }
    this.rsM = 0;
    FaceDetectReporter.cuI().rpY = 4;
    AppMethodBeat.o(103949);
  }
  
  private void cvl()
  {
    AppMethodBeat.i(103950);
    this.rsH = 2;
    if (this.rst != null) {
      this.rst.DT(0);
    }
    Intent localIntent = new Intent(this, FaceDetectUI.class);
    localIntent.putExtra("k_user_name", this.fIQ);
    localIntent.putExtra("k_server_scene", this.rnI);
    localIntent.putExtra("k_need_signature", this.rsw);
    localIntent.putExtra("k_bio_id", String.valueOf(this.rpk));
    localIntent.putExtra("k_bio_config", this.rsx);
    localIntent.putExtra("business_tips", this.rsD);
    ae.i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
    ae.i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.rsx);
    ae.i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.rpk + "  string：" + String.valueOf(this.rpk));
    ae.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[] { Long.valueOf(FaceDetectReporter.cuI().sessionId) });
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.cuI());
    localIntent.putExtra("key_reporter_bundle", localBundle);
    if (this.rsu != null) {
      this.rsu.cvh();
    }
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(103950);
  }
  
  private void cvm()
  {
    AppMethodBeat.i(103952);
    if (this.rsu != null) {
      this.rsu.dismiss();
    }
    ae.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.rsL) });
    if (!this.rsL)
    {
      this.rsu = new a(this);
      this.rsu.create();
      AppMethodBeat.o(103952);
      return;
    }
    this.rsu = new b(this);
    this.rsu.create();
    AppMethodBeat.o(103952);
  }
  
  private void cvn()
  {
    AppMethodBeat.i(103954);
    String str = getString(2131758727);
    c localc = a.b(2131232119, str, null, getString(2131755691), null, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103942);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, 90005, "user cancel in uploading");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(103942);
      }
    });
    localc.rua = true;
    localc.ruc = (str.length() - 3);
    localc.status = 1;
    a(false, true, localc);
    AppMethodBeat.o(103954);
  }
  
  private void cvo()
  {
    AppMethodBeat.i(103962);
    c(4, 90011, "get image failed", getString(2131758718));
    AppMethodBeat.o(103962);
  }
  
  private boolean hasError()
  {
    AppMethodBeat.i(103965);
    boolean bool2 = this.rsy;
    if (this.rsA == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(hashCode()) });
      if ((!this.rsy) || (this.rsA == null)) {
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
      ae.i("MicroMsg.FaceDetectPrepareUI", "hy: sending msg: cmd: %d, data: %s", new Object[] { Integer.valueOf(paramInt), localObject });
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
    ae.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramBundle != null) {
      paramBundle.putString("k_bio_id", String.valueOf(this.rpk));
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", l.DZ(paramInt2));
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(-1, paramString);
    if (this.rsB)
    {
      this.rsC = true;
      q(5, this.rst.cun());
      paramString = FaceDetectReporter.cuI();
      if (!this.rsB) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      paramString.rqa = paramInt1;
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
      ae.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103941);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103940);
              FaceDetectPrepareUI.d(FaceDetectPrepareUI.this).W(this.rsX);
              AppMethodBeat.o(103940);
            }
          });
          AppMethodBeat.o(103941);
        }
      }, "face_refresh_background");
    }
    this.rsu.a(paramc);
    AppMethodBeat.o(103953);
  }
  
  public final void cuj()
  {
    AppMethodBeat.i(103948);
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
    if (this.rst != null)
    {
      String str = getIntent().getExtras().getString("k_ticket");
      if (!bu.isNullOrNil(str))
      {
        ae.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
        com.tencent.mm.plugin.facedetect.b.p.agP(str);
      }
    }
    ae.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.rsL) });
    if (!this.rsL)
    {
      ae.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[] { Boolean.TRUE });
      this.rsE = bu.HQ();
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103939);
          final Bitmap localBitmap = com.tencent.mm.plugin.facedetect.model.p.agR(FaceDetectPrepareUI.c(FaceDetectPrepareUI.this));
          ar.f(new Runnable()
          {
            public final void onClick(View paramAnonymous2View)
            {
              AppMethodBeat.i(103937);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, 90003, "user cancel in init");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(103937);
            }
          }
          {
            public final void run()
            {
              AppMethodBeat.i(103938);
              c localc = a.a(FaceDetectPrepareUI.this, this.rsV);
              localc.rud = localBitmap;
              FaceDetectPrepareUI.this.a(false, false, localc);
              AppMethodBeat.o(103938);
            }
          });
          AppMethodBeat.o(103939);
        }
      }, "face_prepareInit");
    }
    cvk();
    int i;
    switch (this.rsM)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      if ((this.rnI == 0) || (this.rnI == 1) || (this.rnI == 3) || (this.rnI == 4)) {
        i = 1;
      }
      this.rnT = i;
      if (this.rst != null)
      {
        this.rst.roI = this.rnT;
        this.rst.cui();
      }
      this.rsI = true;
      AppMethodBeat.o(103948);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public final void cul() {}
  
  public final void cuo()
  {
    this.rsI = false;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(103966);
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(hashCode()) });
    if (this.rsA == null) {
      this.rsA = new b((byte)0);
    }
    this.rsy = true;
    this.rsA.e(paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(103966);
  }
  
  public void finish()
  {
    AppMethodBeat.i(103961);
    ae.i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
    if ((this.rsu != null) && (this.rsu.bnS())) {
      this.rsu.dismiss();
    }
    if (this.rsv != null) {
      this.rsv.dismiss();
    }
    ae.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
    if (this.rst != null) {
      this.rst.cul();
    }
    super.finish();
    this.gJv = true;
    AppMethodBeat.o(103961);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(103951);
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      this.rsH = 1;
      this.rsK.setVisibility(0);
      if (paramIntent == null)
      {
        ae.e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
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
        FaceDetectReporter.cuI().a((FaceDetectReporter)localObject);
      }
      localObject = FaceDetectReporter.cuI();
      if (this.rsB) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        ((FaceDetectReporter)localObject).rqa = paramInt1;
        FaceDetectReporter.cuI().rpZ = Math.round(this.rsO);
        paramInt1 = paramIntent.getIntExtra("err_type", -1);
        paramInt2 = paramIntent.getIntExtra("err_code", -1);
        str = paramIntent.getStringExtra("err_msg");
        if (this.rst != null)
        {
          localObject = this.rst;
          paramIntent.getExtras();
          ((com.tencent.mm.plugin.facedetect.c.a)localObject).t(paramInt1, paramInt2, str);
        }
        ae.i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        cvn();
        q(6, paramIntent.getExtras());
        AppMethodBeat.o(103951);
        return;
      }
      if (paramInt1 == 1)
      {
        if ((paramInt2 == 90004) || (paramInt2 == 90025))
        {
          aU(paramInt2, str);
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
          if (bu.isNullOrNil((String)localObject)) {
            paramIntent = getString(2131764085);
          }
        }
      }
    }
    this.rsH = 1;
    if (paramIntent == null)
    {
      ae.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
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
      FaceDetectReporter.cuI().a((FaceDetectReporter)localObject);
    }
    paramInt1 = paramIntent.getIntExtra("err_type", -1);
    paramInt2 = paramIntent.getIntExtra("err_code", -1);
    String str = paramIntent.getStringExtra("err_msg");
    if (this.rst != null)
    {
      localObject = this.rst;
      paramIntent.getExtras();
      ((com.tencent.mm.plugin.facedetect.c.a)localObject).t(paramInt1, paramInt2, str);
    }
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cvn();
      q(1, null);
      AppMethodBeat.o(103951);
      return;
    }
    if (paramInt1 == 1)
    {
      if ((paramInt2 == 90004) || (paramInt2 == 90025))
      {
        aU(paramInt2, str);
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
        if (bu.isNullOrNil((String)localObject)) {
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
      if (this.rst != null)
      {
        this.rst.c(this.rsA.errType, this.rsA.errCode, this.rsA.errMsg, this.rsA.extras);
        AppMethodBeat.o(103967);
      }
    }
    else
    {
      if (this.rsH == 1)
      {
        aU(90003, "user cancel in init");
        AppMethodBeat.o(103967);
        return;
      }
      if (this.rsH == 3)
      {
        aU(90005, "user cancel in uploading");
        AppMethodBeat.o(103967);
        return;
      }
      if (this.rsH == 0)
      {
        aU(90002, "user cancel in tutorial");
        AppMethodBeat.o(103967);
        return;
      }
      aU(90050, "user cancel unknown");
    }
    AppMethodBeat.o(103967);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103945);
    super.onCreate(paramBundle);
    setContentView(2131493917);
    this.rsK = ((RelativeLayout)findViewById(2131299696));
    this.rsK.setVisibility(4);
    getWindow().addFlags(2097280);
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.fIQ = getIntent().getStringExtra("k_user_name");
    this.rnI = getIntent().getIntExtra("k_server_scene", -1);
    this.rsw = getIntent().getBooleanExtra("k_need_signature", false);
    boolean bool;
    if ((e.cut()) || (getIntent().getBooleanExtra("key_is_need_video", false)))
    {
      bool = true;
      this.rsB = bool;
      this.ron = getIntent().getStringExtra("key_feedback_url");
      this.rsD = getIntent().getStringExtra("business_tips");
      this.rrS = getIntent().getIntExtra("check_alive_type_response", -1);
      if (this.rrS == -1) {
        this.rrS = getIntent().getIntExtra("check_alive_type", 0);
      }
      this.rop = getIntent().getFloatExtra("mLight_threshold", -1.0F);
      this.rsJ = a.b.cvS();
      this.rsJ.cvR();
      ae.i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.rsB);
      ae.i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.rrS);
      ae.i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.rop);
      ae.i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.rnT);
      this.rsG = new a(this, (byte)0);
      this.rsF = new Messenger(this.rsG);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtra("k_messenger", this.rsF);
      com.tencent.mm.br.d.l(paramBundle, "tools");
      FaceContextData.a(new FaceContextData());
      com.tencent.mm.plugin.facedetect.model.p.an(this);
      paramBundle = getIntent().getExtras();
      float f = this.rsJ.getLux();
      this.rsO = f;
      if (paramBundle != null)
      {
        paramBundle.putFloat("key_current_light", f);
        paramBundle.putBoolean("key_upload_video", this.rsB);
      }
      com.tencent.mm.plugin.facedetect.c.b localb = com.tencent.mm.plugin.facedetect.c.b.roM;
      this.rst = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.rnI, this.rnT, paramBundle);
      if (this.rst != null) {
        break label603;
      }
      bkA();
      label483:
      if (this.rsA != null)
      {
        paramBundle = this.rsA;
        paramBundle.errType = -1;
        paramBundle.errCode = -1;
        paramBundle.errMsg = "";
        if (paramBundle.extras != null) {
          paramBundle.extras.clear();
        }
      }
      this.rsy = false;
      this.rsH = 1;
      cvm();
      if (!com.tencent.mm.plugin.facedetect.model.p.am(this)) {
        break label644;
      }
      ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
      cvj();
    }
    for (;;)
    {
      if (this.rsB)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("key_is_need_video", this.rsB);
        q(4, paramBundle);
      }
      AppMethodBeat.o(103945);
      return;
      bool = false;
      break;
      label603:
      this.rst.a(new com.tencent.mm.plugin.facedetect.b.c()
      {
        public final void aR(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(103925);
          ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(90015), paramAnonymousString });
          paramAnonymousInt = FaceDetectPrepareUI.Ee(paramAnonymousInt);
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt, 90015, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131758723));
          AppMethodBeat.o(103925);
        }
        
        public final void e(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(103924);
          ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[] { Long.valueOf(paramAnonymousLong), Boolean.valueOf(FaceDetectPrepareUI.h(FaceDetectPrepareUI.this)) });
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
      this.rnJ = new com.tencent.mm.plugin.facedetect.b.d()
      {
        private double rsT = 0.0D;
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
        {
          AppMethodBeat.i(103927);
          ae.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131764085));
          AppMethodBeat.o(103927);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(103929);
          ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousn.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousInt1 = FaceDetectPrepareUI.Ee(paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            FaceDetectPrepareUI.this.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousn);
          }
          AppMethodBeat.o(103929);
        }
        
        public final void o(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(103928);
          ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
          int i = FaceDetectPrepareUI.Ee(0);
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
          ae.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          this.rsT = (100.0D * paramAnonymousDouble);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this);
          }
          AppMethodBeat.o(103926);
        }
      };
      this.rst.a(this.rnJ);
      break label483;
      label644:
      ae.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103957);
    ae.i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
    super.onDestroy();
    if (!this.rsC) {
      com.tencent.mm.br.d.n(new Intent(this, FaceDetectProcessService.class), "tools");
    }
    if (this.rsJ != null) {
      this.rsJ.stop();
    }
    AppMethodBeat.o(103957);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 90008;
    AppMethodBeat.i(103969);
    ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(103969);
      return;
    }
    switch (paramInt)
    {
    default: 
      ae.i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
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
        cvj();
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
      this.rsK.setVisibility(0);
      ae.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", new Object[] { Integer.valueOf(this.rsK.getVisibility()) });
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
    ae.i("MicroMsg.FaceDetectPrepareUI", "onResume");
    super.onResume();
    this.rsI = true;
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
    if (this.rsI)
    {
      if ((!this.gJv) && (hasError()))
      {
        a(this.rsA.errType, this.rsA.errCode, this.rsA.errMsg, this.rsA.extras);
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
    private WeakReference<FaceDetectPrepareUI> rsj;
    
    private a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
    {
      AppMethodBeat.i(103943);
      this.rsj = null;
      this.rsj = new WeakReference(paramFaceDetectPrepareUI);
      AppMethodBeat.o(103943);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(103944);
      ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[] { Integer.valueOf(paramMessage.what) });
      if ((this.rsj != null) && (this.rsj.get() != null)) {
        switch (paramMessage.what)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.a((FaceDetectPrepareUI)this.rsj.get(), paramMessage);
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.b((FaceDetectPrepareUI)this.rsj.get(), paramMessage);
        AppMethodBeat.o(103944);
        return;
        FaceDetectPrepareUI.c((FaceDetectPrepareUI)this.rsj.get(), paramMessage);
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