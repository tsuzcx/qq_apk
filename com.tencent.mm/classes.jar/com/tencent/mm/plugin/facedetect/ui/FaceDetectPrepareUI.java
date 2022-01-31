package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.app.a.a;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.facedetect.c.f;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI
  extends MMFragmentActivity
  implements a.a, f
{
  private boolean eRZ = false;
  private boolean eUJ = false;
  private String eaX;
  private String mAppId;
  private int mgD;
  private String mgX = null;
  private float mgZ;
  private int mgs;
  private com.tencent.mm.plugin.facedetect.b.d mgt = null;
  private long mhU;
  private int mkG;
  private boolean mlA = false;
  private float mlB = 0.0F;
  private com.tencent.mm.plugin.facedetect.c.a mlg = null;
  private a mlh = null;
  private FaceTutorial mli = null;
  private boolean mlj;
  private byte[] mlk;
  private boolean mll = false;
  private boolean mlm = false;
  private FaceDetectPrepareUI.b mln;
  private boolean mlo = false;
  private boolean mlp = false;
  private String mlq = null;
  private long mlr = -1L;
  private Messenger mls = null;
  private FaceDetectPrepareUI.a mlt = null;
  private int mlu = -1;
  private boolean mlv = false;
  private com.tencent.mm.plugin.facedetectlight.Utils.a mlw;
  private RelativeLayout mlx;
  private boolean mly = false;
  private int mlz = -1;
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, c paramc)
  {
    AppMethodBeat.i(436);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[] { paramString2 });
    Object localObject;
    if (this.mlA)
    {
      localObject = findViewById(2131823944);
      if (localObject != null)
      {
        ab.i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
        ((View)localObject).setVisibility(8);
      }
      this.mlx.setVisibility(0);
    }
    if (paramBoolean)
    {
      localObject = getResources().getString(2131299605);
      if (!paramBoolean) {
        break label204;
      }
    }
    label204:
    for (String str = getResources().getString(2131296888);; str = null)
    {
      paramString2 = a.a(2130838689, paramString2, (String)localObject, str, new FaceDetectPrepareUI.2(this, paramBoolean, paramc, paramInt1, paramInt2, paramString1), new FaceDetectPrepareUI.3(this, paramInt1, paramInt2, paramString1));
      paramString2.status = 3;
      paramString1 = getString(2131299560);
      if (this.mgX == null) {
        paramString1 = null;
      }
      a.a(paramString2, paramString1, new FaceDetectPrepareUI.4(this, paramInt2));
      al.d(new FaceDetectPrepareUI.5(this, paramString2));
      AppMethodBeat.o(436);
      return;
      localObject = getString(2131299603);
      break;
    }
  }
  
  private void aCL()
  {
    AppMethodBeat.i(444);
    d(4, 90013, "init lib failed", getString(2131299566));
    AppMethodBeat.o(444);
  }
  
  private void az(int paramInt, String paramString)
  {
    AppMethodBeat.i(449);
    if (hasError()) {
      if (this.mlg != null) {
        this.mlg.c(this.mln.errType, this.mln.errCode, this.mln.errMsg, this.mln.extras);
      }
    }
    for (;;)
    {
      this.eUJ = true;
      finish();
      AppMethodBeat.o(449);
      return;
      if (this.mlg != null) {
        this.mlg.ax(paramInt, paramString);
      }
    }
  }
  
  private void bvb()
  {
    AppMethodBeat.i(428);
    if (this.mlg != null) {
      this.mlg.buc();
    }
    AppMethodBeat.o(428);
  }
  
  private void bvc()
  {
    AppMethodBeat.i(430);
    switch (this.mkG)
    {
    default: 
      this.mlz = 0;
      AppMethodBeat.o(430);
      return;
    case 0: 
      this.mlz = 0;
      FaceDetectReporter.buB().miJ = 4;
      AppMethodBeat.o(430);
      return;
    case 1: 
      this.mlz = 1;
      FaceDetectReporter.buB().miJ = 6;
      AppMethodBeat.o(430);
      return;
    }
    float f = this.mlw.bvK();
    FaceDetectReporter.buB().miK = Math.round(f);
    ab.i("MicroMsg.FaceDetectPrepareUI", "curLux is : ".concat(String.valueOf(f)));
    ab.i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.mgZ);
    if (f < this.mgZ)
    {
      this.mlw.stop();
      this.mlz = 1;
      FaceDetectReporter.buB().miJ = 6;
      AppMethodBeat.o(430);
      return;
    }
    this.mlz = 0;
    FaceDetectReporter.buB().miJ = 4;
    AppMethodBeat.o(430);
  }
  
  private void bvd()
  {
    AppMethodBeat.i(431);
    this.mlu = 2;
    if (this.mlg != null) {
      this.mlg.vB(0);
    }
    Intent localIntent = new Intent(this, FaceDetectUI.class);
    localIntent.putExtra("k_user_name", this.eaX);
    localIntent.putExtra("k_server_scene", this.mgs);
    localIntent.putExtra("k_need_signature", this.mlj);
    localIntent.putExtra("k_bio_id", String.valueOf(this.mhU));
    localIntent.putExtra("k_bio_config", this.mlk);
    localIntent.putExtra("business_tips", this.mlq);
    ab.i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
    ab.i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.mlk);
    ab.i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.mhU + "  string：" + String.valueOf(this.mhU));
    ab.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[] { Long.valueOf(FaceDetectReporter.buB().sessionId) });
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.buB());
    localIntent.putExtra("key_reporter_bundle", localBundle);
    if (this.mlh != null) {
      this.mlh.resetAll();
    }
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(431);
  }
  
  private void bve()
  {
    AppMethodBeat.i(433);
    if (this.mlh != null) {
      this.mlh.dismiss();
    }
    ab.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.mly) });
    if (!this.mly)
    {
      this.mlh = new a(this);
      this.mlh.create();
      AppMethodBeat.o(433);
      return;
    }
    this.mlh = new b(this);
    this.mlh.create();
    AppMethodBeat.o(433);
  }
  
  private void bvf()
  {
    AppMethodBeat.i(435);
    String str = getString(2131299570);
    c localc = a.b(2130838678, str, null, getString(2131296888), null, new FaceDetectPrepareUI.17(this));
    localc.mmO = true;
    localc.mmQ = (str.length() - 3);
    localc.status = 1;
    a(false, true, localc);
    AppMethodBeat.o(435);
  }
  
  private void bvg()
  {
    AppMethodBeat.i(443);
    d(4, 90011, "get image failed", getString(2131299561));
    AppMethodBeat.o(443);
  }
  
  private void d(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(445);
    ab.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
    d(paramInt1, paramInt2, paramString1, null);
    this.mlm = true;
    a(paramInt1, paramInt2, paramString1, paramString2, false, new c()
    {
      public final void s(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(413);
        if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
          FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, FaceDetectPrepareUI.i(FaceDetectPrepareUI.this).extras);
        }
        AppMethodBeat.o(413);
      }
    });
    AppMethodBeat.o(445);
  }
  
  private boolean hasError()
  {
    AppMethodBeat.i(446);
    boolean bool2 = this.mll;
    if (this.mln == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(hashCode()) });
      if ((!this.mll) || (this.mln == null)) {
        break;
      }
      AppMethodBeat.o(446);
      return true;
    }
    AppMethodBeat.o(446);
    return false;
  }
  
  private void o(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(427);
    if (paramBundle != null) {}
    for (Object localObject = paramBundle.toString();; localObject = "null")
    {
      ab.i("MicroMsg.FaceDetectPrepareUI", "hy: sending msg: cmd: %d, data: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putInt("k_cmd", paramInt);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtras((Bundle)localObject);
      com.tencent.mm.bq.d.j(paramBundle, "tools");
      AppMethodBeat.o(427);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(437);
    ab.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramBundle != null) {
      paramBundle.putString("k_bio_id", String.valueOf(this.mhU));
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("err_code", l.vH(paramInt2));
    localBundle.putString("err_msg", paramString);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(-1, paramString);
    if (this.mlo)
    {
      this.mlp = true;
      o(5, this.mlg.bug());
      paramString = FaceDetectReporter.buB();
      if (!this.mlo) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      paramString.miL = paramInt1;
      finish();
      AppMethodBeat.o(437);
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, c paramc)
  {
    AppMethodBeat.i(434);
    if (paramBoolean2)
    {
      ab.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
      com.tencent.mm.sdk.g.d.post(new FaceDetectPrepareUI.16(this), "face_refresh_background");
    }
    this.mlh.a(paramc);
    AppMethodBeat.o(434);
  }
  
  public final void buc()
  {
    AppMethodBeat.i(429);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
    if (this.mlg != null)
    {
      String str = getIntent().getExtras().getString("k_ticket");
      if (!bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
        com.tencent.mm.plugin.facedetect.b.p.Nn(str);
      }
    }
    ab.i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", new Object[] { Boolean.valueOf(this.mly) });
    if (!this.mly)
    {
      ab.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[] { Boolean.TRUE });
      this.mlr = bo.yB();
      com.tencent.mm.sdk.g.d.post(new FaceDetectPrepareUI.15(this), "face_prepareInit");
    }
    bvc();
    int i;
    switch (this.mlz)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      if ((this.mgs == 0) || (this.mgs == 1) || (this.mgs == 3) || (this.mgs == 4)) {
        i = 1;
      }
      this.mgD = i;
      if (this.mlg != null)
      {
        this.mlg.mhs = this.mgD;
        this.mlg.bub();
      }
      this.mlv = true;
      AppMethodBeat.o(429);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public final void bue() {}
  
  public final void buh()
  {
    this.mlv = false;
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(447);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(hashCode()) });
    if (this.mln == null) {
      this.mln = new FaceDetectPrepareUI.b(this, (byte)0);
    }
    this.mll = true;
    this.mln.e(paramInt1, paramInt2, paramString, paramBundle);
    AppMethodBeat.o(447);
  }
  
  public void finish()
  {
    AppMethodBeat.i(442);
    ab.i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
    if ((this.mlh != null) && (this.mlh.Pk())) {
      this.mlh.dismiss();
    }
    if (this.mli != null) {
      this.mli.dismiss();
    }
    ab.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
    if (this.mlg != null) {
      this.mlg.bue();
    }
    super.finish();
    this.eRZ = true;
    AppMethodBeat.o(442);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(432);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      this.mlu = 1;
      this.mlx.setVisibility(0);
      if (paramIntent == null)
      {
        ab.e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
        a(4, 90018, "system error", getString(2131299581), false, new FaceDetectPrepareUI.11(this));
        AppMethodBeat.o(432);
        return;
      }
      localObject = (FaceDetectReporter)paramIntent.getParcelableExtra("key_parcelable_reporter");
      if (localObject != null) {
        FaceDetectReporter.buB().a((FaceDetectReporter)localObject);
      }
      localObject = FaceDetectReporter.buB();
      if (this.mlo) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        ((FaceDetectReporter)localObject).miL = paramInt1;
        FaceDetectReporter.buB().miK = Math.round(this.mlB);
        paramInt1 = paramIntent.getIntExtra("err_type", -1);
        paramInt2 = paramIntent.getIntExtra("err_code", -1);
        str = paramIntent.getStringExtra("err_msg");
        if (this.mlg != null)
        {
          localObject = this.mlg;
          paramIntent.getExtras();
          ((com.tencent.mm.plugin.facedetect.c.a)localObject).q(paramInt1, paramInt2, str);
        }
        ab.i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        bvf();
        o(6, paramIntent.getExtras());
        AppMethodBeat.o(432);
        return;
      }
      if (paramInt1 == 1)
      {
        if ((paramInt2 == 90004) || (paramInt2 == 90025))
        {
          az(paramInt2, str);
          AppMethodBeat.o(432);
        }
      }
      else
      {
        localObject = paramIntent.getStringExtra("show_err_msg");
        if (paramInt2 != 90013) {
          break label381;
        }
        paramIntent = getString(2131299566);
      }
      for (;;)
      {
        d(paramInt1, paramInt2, str, null);
        if (paramInt2 == 90023) {
          bool1 = true;
        }
        a(paramInt1, paramInt2, str, paramIntent, bool1, new FaceDetectPrepareUI.12(this));
        AppMethodBeat.o(432);
        return;
        label381:
        if ((paramInt2 == 90008) || (paramInt2 == 90010))
        {
          paramIntent = getString(2131302067);
        }
        else if (paramInt2 == 90009)
        {
          paramIntent = getString(2131302075);
        }
        else
        {
          paramIntent = (Intent)localObject;
          if (bo.isNullOrNil((String)localObject)) {
            paramIntent = getString(2131304062);
          }
        }
      }
    }
    this.mlu = 1;
    if (paramIntent == null)
    {
      ab.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
      a(4, 90018, "system error", getString(2131299581), false, new c()
      {
        public final void s(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
        {
          AppMethodBeat.i(416);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          AppMethodBeat.o(416);
        }
      });
      AppMethodBeat.o(432);
      return;
    }
    Object localObject = (FaceDetectReporter)paramIntent.getParcelableExtra("key_parcelable_reporter");
    if (localObject != null) {
      FaceDetectReporter.buB().a((FaceDetectReporter)localObject);
    }
    paramInt1 = paramIntent.getIntExtra("err_type", -1);
    paramInt2 = paramIntent.getIntExtra("err_code", -1);
    String str = paramIntent.getStringExtra("err_msg");
    if (this.mlg != null)
    {
      localObject = this.mlg;
      paramIntent.getExtras();
      ((com.tencent.mm.plugin.facedetect.c.a)localObject).q(paramInt1, paramInt2, str);
    }
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      bvf();
      o(1, null);
      AppMethodBeat.o(432);
      return;
    }
    if (paramInt1 == 1)
    {
      if ((paramInt2 == 90004) || (paramInt2 == 90025))
      {
        az(paramInt2, str);
        AppMethodBeat.o(432);
      }
    }
    else
    {
      localObject = paramIntent.getStringExtra("show_err_msg");
      if (paramInt2 != 90013) {
        break label738;
      }
      paramIntent = getString(2131299566);
    }
    for (;;)
    {
      d(paramInt1, paramInt2, str, null);
      bool1 = bool2;
      if (paramInt2 == 90023) {
        bool1 = true;
      }
      a(paramInt1, paramInt2, str, paramIntent, bool1, new FaceDetectPrepareUI.14(this));
      AppMethodBeat.o(432);
      return;
      label738:
      if ((paramInt2 == 90008) || (paramInt2 == 90010))
      {
        paramIntent = getString(2131302067);
      }
      else if (paramInt2 == 90009)
      {
        paramIntent = getString(2131302075);
      }
      else
      {
        paramIntent = (Intent)localObject;
        if (bo.isNullOrNil((String)localObject)) {
          paramIntent = getString(2131304062);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(448);
    if (hasError())
    {
      if (this.mlg != null)
      {
        this.mlg.c(this.mln.errType, this.mln.errCode, this.mln.errMsg, this.mln.extras);
        AppMethodBeat.o(448);
      }
    }
    else
    {
      if (this.mlu == 1)
      {
        az(90003, "user cancel in init");
        AppMethodBeat.o(448);
        return;
      }
      if (this.mlu == 3)
      {
        az(90005, "user cancel in uploading");
        AppMethodBeat.o(448);
        return;
      }
      if (this.mlu == 0)
      {
        az(90002, "user cancel in tutorial");
        AppMethodBeat.o(448);
        return;
      }
      az(90050, "user cancel unknown");
    }
    AppMethodBeat.o(448);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(426);
    super.onCreate(paramBundle);
    setContentView(2130969504);
    this.mlx = ((RelativeLayout)findViewById(2131823905));
    this.mlx.setVisibility(4);
    getWindow().addFlags(2097280);
    this.mAppId = getIntent().getStringExtra("k_app_id");
    this.eaX = getIntent().getStringExtra("k_user_name");
    this.mgs = getIntent().getIntExtra("k_server_scene", -1);
    this.mlj = getIntent().getBooleanExtra("k_need_signature", false);
    boolean bool;
    if ((e.bum()) || (getIntent().getBooleanExtra("key_is_need_video", false)))
    {
      bool = true;
      this.mlo = bool;
      this.mgX = getIntent().getStringExtra("key_feedback_url");
      this.mlq = getIntent().getStringExtra("business_tips");
      this.mkG = getIntent().getIntExtra("check_alive_type_response", -1);
      if (this.mkG == -1) {
        this.mkG = getIntent().getIntExtra("check_alive_type", 0);
      }
      this.mgZ = getIntent().getFloatExtra("mLight_threshold", -1.0F);
      this.mlw = a.b.bvL();
      this.mlw.bvJ();
      ab.i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.mlo);
      ab.i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.mkG);
      ab.i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.mgZ);
      ab.i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.mgD);
      this.mlt = new FaceDetectPrepareUI.a(this, (byte)0);
      this.mls = new Messenger(this.mlt);
      paramBundle = new Intent(this, FaceDetectProcessService.class);
      paramBundle.putExtra("k_messenger", this.mls);
      com.tencent.mm.bq.d.j(paramBundle, "tools");
      FaceContextData.a(new FaceContextData());
      com.tencent.mm.plugin.facedetect.model.p.T(this);
      paramBundle = getIntent().getExtras();
      float f = this.mlw.bvK();
      this.mlB = f;
      if (paramBundle != null)
      {
        paramBundle.putFloat("key_current_light", f);
        paramBundle.putBoolean("key_upload_video", this.mlo);
      }
      com.tencent.mm.plugin.facedetect.c.b localb = com.tencent.mm.plugin.facedetect.c.b.mhw;
      this.mlg = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.mgs, this.mgD, paramBundle);
      if (this.mlg != null) {
        break label603;
      }
      aCL();
      label483:
      if (this.mln != null)
      {
        paramBundle = this.mln;
        paramBundle.errType = -1;
        paramBundle.errCode = -1;
        paramBundle.errMsg = "";
        if (paramBundle.extras != null) {
          paramBundle.extras.clear();
        }
      }
      this.mll = false;
      this.mlu = 1;
      bve();
      if (!com.tencent.mm.plugin.facedetect.model.p.S(this)) {
        break label644;
      }
      ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
      bvb();
    }
    for (;;)
    {
      if (this.mlo)
      {
        paramBundle = new Bundle();
        paramBundle.putBoolean("key_is_need_video", this.mlo);
        o(4, paramBundle);
      }
      AppMethodBeat.o(426);
      return;
      bool = false;
      break;
      label603:
      this.mlg.a(new FaceDetectPrepareUI.6(this));
      this.mgt = new com.tencent.mm.plugin.facedetect.b.d()
      {
        private double mlG = 0.0D;
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
        {
          AppMethodBeat.i(408);
          ab.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), paramAnonymousString });
          FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousString, FaceDetectPrepareUI.this.getString(2131304062));
          AppMethodBeat.o(408);
        }
        
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(410);
          ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousm.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousInt1 = FaceDetectPrepareUI.vM(paramAnonymousInt1);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
            FaceDetectPrepareUI.this.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousm);
          }
          AppMethodBeat.o(410);
        }
        
        public final void n(String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(409);
          ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
          int i = FaceDetectPrepareUI.vM(0);
          if (i != 0) {
            FaceDetectPrepareUI.this.d(i, 0, paramAnonymousString, paramAnonymousBundle);
          }
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this).b(i, paramAnonymousString, paramAnonymousBundle);
          }
          AppMethodBeat.o(409);
        }
        
        public final void v(double paramAnonymousDouble)
        {
          AppMethodBeat.i(407);
          ab.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[] { Double.valueOf(paramAnonymousDouble) });
          this.mlG = (100.0D * paramAnonymousDouble);
          if (FaceDetectPrepareUI.b(FaceDetectPrepareUI.this) != null) {
            FaceDetectPrepareUI.b(FaceDetectPrepareUI.this);
          }
          AppMethodBeat.o(407);
        }
      };
      this.mlg.a(this.mgt);
      break label483;
      label644:
      ab.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(438);
    ab.i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
    super.onDestroy();
    if (!this.mlp) {
      com.tencent.mm.bq.d.l(new Intent(this, FaceDetectProcessService.class), "tools");
    }
    if (this.mlw != null) {
      this.mlw.stop();
    }
    AppMethodBeat.o(438);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = 90008;
    AppMethodBeat.i(450);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(450);
      return;
    }
    switch (paramInt)
    {
    default: 
      ab.i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
      AppMethodBeat.o(450);
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
        bvb();
        AppMethodBeat.o(450);
        return;
      }
      if (paramArrayOfString[0].equals("android.permission.CAMERA"))
      {
        localObject1 = "camera permission not granted";
        paramArrayOfString = getString(2131302067);
        paramInt = i;
      }
    }
    for (;;)
    {
      this.mlx.setVisibility(0);
      ab.i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", new Object[] { Integer.valueOf(this.mlx.getVisibility()) });
      paramArrayOfInt = findViewById(2131823944);
      if (paramArrayOfInt != null) {
        paramArrayOfInt.setVisibility(8);
      }
      d(1, paramInt, (String)localObject1, paramArrayOfString);
      paramInt = 0;
      break label95;
      if (paramArrayOfString[0].equals("android.permission.RECORD_AUDIO"))
      {
        paramInt = 90009;
        localObject1 = "audio permission not granted";
        paramArrayOfString = getString(2131302075);
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
            str = getString(2131302067);
          }
          for (;;)
          {
            if (paramArrayOfInt[1] != 0)
            {
              i = 90009;
              localObject2 = "audio permission not granted";
              str = getString(2131302075);
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
            paramArrayOfString = getString(2131302067);
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
    AppMethodBeat.i(440);
    ab.i("MicroMsg.FaceDetectPrepareUI", "onResume");
    super.onResume();
    this.mlv = true;
    AppMethodBeat.o(440);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(439);
    super.onStart();
    AppMethodBeat.o(439);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(441);
    super.onStop();
    if (this.mlv)
    {
      if ((!this.eRZ) && (hasError()))
      {
        a(this.mln.errType, this.mln.errCode, this.mln.errMsg, this.mln.extras);
        AppMethodBeat.o(441);
        return;
      }
      finish();
    }
    AppMethodBeat.o(441);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static abstract interface c
  {
    public abstract void s(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI
 * JD-Core Version:    0.7.0.1
 */