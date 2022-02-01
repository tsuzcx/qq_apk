package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String appId;
  private int businessType;
  private String lrd;
  private String pNL = null;
  private String pNM = null;
  private String pNN = null;
  private float pNO;
  private String pNQ;
  private TextView pRj;
  private Button pRk;
  private CheckBox pRl;
  private TextView pRm;
  private TextView pRn;
  private ccl pRo = null;
  private String pRp;
  private int pRq;
  private int pRr;
  private ImageView pRs;
  private TextView pRt;
  private String pRu;
  private String pRv;
  private com.tencent.mm.ui.base.p tipDialog;
  
  private void cgt()
  {
    AppMethodBeat.i(103893);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.BZ(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.cfV().a(this.businessType, false, 3, 1, 90024);
    FaceDetectReporter.cfV().pPC = System.currentTimeMillis();
    FaceDetectReporter.cfV().cS(this.lrd, this.businessType);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(103893);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(103896);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(103896);
  }
  
  public void finish()
  {
    AppMethodBeat.i(103895);
    dismissDialog();
    super.finish();
    AppMethodBeat.o(103895);
  }
  
  public int getLayoutId()
  {
    return 2131493904;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(103892);
    ad.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.cfV().pPC = System.currentTimeMillis();
    FaceDetectReporter.cfV().cS(this.lrd, this.businessType);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(103892);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103894);
    cgt();
    super.onBackPressed();
    AppMethodBeat.o(103894);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103890);
    super.onCreate(paramBundle);
    this.appId = getIntent().getStringExtra("k_app_id");
    this.pRp = getIntent().getStringExtra("request_verify_pre_info");
    this.lrd = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.pRq = getIntent().getIntExtra("check_alive_type", 0);
    ad.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", new Object[] { Integer.valueOf(this.pRq) });
    ad.i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", new Object[] { Integer.valueOf(this.businessType) });
    setMMTitle(getString(2131758696));
    setBackBtn(new FaceDetectConfirmUI.1(this));
    this.pRj = ((TextView)findViewById(2131299664));
    this.pRk = ((Button)findViewById(2131305176));
    this.pRs = ((ImageView)findViewById(2131296908));
    this.pRt = ((TextView)findViewById(2131296909));
    this.pRl = ((CheckBox)findViewById(2131299665));
    this.pRl.setOnCheckedChangeListener(new FaceDetectConfirmUI.2(this));
    this.pRl.setVisibility(8);
    this.pRm = ((TextView)findViewById(2131299666));
    this.pRm.setOnClickListener(new FaceDetectConfirmUI.3(this));
    this.pRn = ((TextView)findViewById(2131299663));
    this.pRk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103885);
        ad.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.d(FaceDetectConfirmUI.this)) });
        paramAnonymousView = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
        Bundle localBundle = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (localBundle != null)
        {
          localBundle.putInt("check_alive_type_response", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          localBundle.putString("key_feedback_url", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          localBundle.putString("business_tips", FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          localBundle.putFloat("mLight_threshold", FaceDetectConfirmUI.g(FaceDetectConfirmUI.this));
          ad.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          paramAnonymousView.putExtras(localBundle);
          FaceDetectConfirmUI.this.startActivityForResult(paramAnonymousView, 1);
          AppMethodBeat.o(103885);
          return;
        }
        ad.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
        AppMethodBeat.o(103885);
      }
    });
    ad.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(2131755906);
    this.tipDialog = h.b(paramBundle, getString(2131755936), false, new FaceDetectConfirmUI.5(this));
    paramBundle = new com.tencent.mm.plugin.facedetect.b.l(this.appId, this.pRp, this.pRq);
    com.tencent.mm.kernel.g.aeS().a(1147, this);
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    a.b.chf().che();
    AppMethodBeat.o(103890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103897);
    super.onDestroy();
    a.b.chf().stop();
    AppMethodBeat.o(103897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(103891);
    ad.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    final ccl localccl;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.pRo = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNI;
      this.pNL = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNL;
      this.pNM = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNM;
      this.pNN = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNN;
      this.pNO = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNO;
      this.pRr = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNP;
      this.pNQ = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNQ;
      this.pRu = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNJ;
      this.pRv = ((com.tencent.mm.plugin.facedetect.b.l)paramn).pNK;
      ad.d("MicroMsg.FaceDetectConfirmUI", paramn.toString());
      if (bt.isNullOrNil(this.pNL)) {
        this.pNL = getString(2131758694);
      }
      dismissDialog();
      this.pRk.setEnabled(true);
      this.pRj.setText(this.pNL);
      paramString = String.format(getString(2131758695), new Object[] { this.pRv });
      paramn = new SpannableString(paramString);
      paramInt1 = paramString.lastIndexOf(" ");
      if (paramInt1 != -1) {
        paramn.setSpan(new StyleSpan(1), 0, paramInt1, 17);
      }
      this.pRt.setText(paramn);
      o.ayJ().loadImage(this.pRu, this.pRs);
      if (this.pRo != null)
      {
        ad.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.pRo.doh, this.pRo.DYQ, this.pRo.url });
        localccl = this.pRo;
        ad.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { localccl.doh });
        if (!bt.isNullOrNil(localccl.doh)) {
          break label589;
        }
        paramString = getString(2131758692);
        if (!bt.isNullOrNil(localccl.DYQ)) {
          break label598;
        }
        paramn = getString(2131758691);
        label416:
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramString + paramn);
        localSpannable.setSpan(new ClickableSpan()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103887);
            if (!bt.isNullOrNil(localccl.url))
            {
              FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, localccl.url);
              AppMethodBeat.o(103887);
              return;
            }
            ad.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
            AppMethodBeat.o(103887);
          }
          
          public final void updateDrawState(TextPaint paramAnonymousTextPaint)
          {
            AppMethodBeat.i(103888);
            paramAnonymousTextPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(2131100547));
            AppMethodBeat.o(103888);
          }
        }, paramString.length(), paramString.length() + paramn.length(), 33);
        this.pRl.setVisibility(0);
        this.pRm.setVisibility(0);
        this.pRm.setText(localSpannable);
        this.pRm.setMovementMethod(LinkMovementMethod.getInstance());
        if (localccl.DYR != 0) {
          break label608;
        }
        this.pRl.setChecked(false);
        this.pRk.setEnabled(false);
        label535:
        this.pRn.setText(getString(2131758689));
        this.pRn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103889);
            try
            {
              if (FaceDetectConfirmUI.j(FaceDetectConfirmUI.this) != null) {}
              for (paramAnonymousView = FaceDetectConfirmUI.j(FaceDetectConfirmUI.this);; paramAnonymousView = "")
              {
                paramAnonymousView = com.tencent.mm.compatible.util.p.encode(String.format("appid=%s", new Object[] { paramAnonymousView }), "UTF-8");
                paramAnonymousView = FaceDetectConfirmUI.k(FaceDetectConfirmUI.this) + "?customInfo=" + paramAnonymousView;
                ad.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramAnonymousView });
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousView);
                AppMethodBeat.o(103889);
                return;
              }
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ad.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramAnonymousView, "alvinluo jumpToWebView exception", new Object[0]);
              AppMethodBeat.o(103889);
            }
          }
        });
        this.pRn.setVisibility(0);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aeS().b(1147, this);
      AppMethodBeat.o(103891);
      return;
      label589:
      paramString = localccl.doh;
      break;
      label598:
      paramn = localccl.DYQ;
      break label416;
      label608:
      if (localccl.DYR != 1) {
        break label535;
      }
      this.pRl.setChecked(true);
      this.pRk.setEnabled(true);
      break label535;
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = getString(2131758738);
      }
      dismissDialog();
      h.a(this, paramn, getString(2131755906), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(103886);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.BZ(90022));
          paramAnonymousDialogInterface.putExtra("err_msg", "get confirm info error");
          FaceDetectReporter.cfV().a(FaceDetectConfirmUI.h(FaceDetectConfirmUI.this), false, 3, 2, 90022);
          FaceDetectReporter.cfV().pPC = System.currentTimeMillis();
          FaceDetectReporter.cfV().cS(FaceDetectConfirmUI.i(FaceDetectConfirmUI.this), FaceDetectConfirmUI.h(FaceDetectConfirmUI.this));
          FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousDialogInterface);
          FaceDetectConfirmUI.this.finish();
          AppMethodBeat.o(103886);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */