package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements f
{
  private String appId;
  private int businessType;
  private String iHa;
  private String mgW = null;
  private String mgX = null;
  private String mgY = null;
  private float mgZ;
  private String mhb;
  private CheckBox mkA;
  private TextView mkB;
  private TextView mkC;
  private bnw mkD = null;
  private String mkE;
  private int mkF;
  private int mkG;
  private ImageView mkH;
  private TextView mkI;
  private String mkJ;
  private String mkK;
  private TextView mky;
  private Button mkz;
  private com.tencent.mm.ui.base.p tipDialog;
  
  private void buZ()
  {
    AppMethodBeat.i(374);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.vH(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.buB().b(this.businessType, false, 3, 1, 90024);
    FaceDetectReporter.buB().miP = System.currentTimeMillis();
    FaceDetectReporter.buB().ci(this.iHa, this.businessType);
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(374);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(377);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(377);
  }
  
  public void finish()
  {
    AppMethodBeat.i(376);
    dismissDialog();
    super.finish();
    AppMethodBeat.o(376);
  }
  
  public int getLayoutId()
  {
    return 2130969491;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(373);
    ab.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.buB().miP = System.currentTimeMillis();
    FaceDetectReporter.buB().ci(this.iHa, this.businessType);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(373);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(375);
    buZ();
    super.onBackPressed();
    AppMethodBeat.o(375);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(371);
    super.onCreate(paramBundle);
    this.appId = getIntent().getStringExtra("k_app_id");
    this.mkE = getIntent().getStringExtra("request_verify_pre_info");
    this.iHa = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.mkF = getIntent().getIntExtra("check_alive_type", 0);
    ab.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", new Object[] { Integer.valueOf(this.mkF) });
    ab.i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", new Object[] { Integer.valueOf(this.businessType) });
    setMMTitle(getString(2131299539));
    setBackBtn(new FaceDetectConfirmUI.1(this));
    this.mky = ((TextView)findViewById(2131823881));
    this.mkz = ((Button)findViewById(2131823884));
    this.mkH = ((ImageView)findViewById(2131823879));
    this.mkI = ((TextView)findViewById(2131823880));
    this.mkA = ((CheckBox)findViewById(2131823882));
    this.mkA.setOnCheckedChangeListener(new FaceDetectConfirmUI.2(this));
    this.mkA.setVisibility(8);
    this.mkB = ((TextView)findViewById(2131823883));
    this.mkB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(365);
        paramAnonymousView = FaceDetectConfirmUI.c(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(365);
          return;
        }
      }
    });
    this.mkC = ((TextView)findViewById(2131823885));
    this.mkz.setOnClickListener(new FaceDetectConfirmUI.4(this));
    ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(2131297087);
    this.tipDialog = h.b(paramBundle, getString(2131297112), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramBundle = new com.tencent.mm.plugin.facedetect.b.l(this.appId, this.mkE, this.mkF);
    g.Rc().a(1147, this);
    g.Rc().a(paramBundle, 0);
    a.b.bvL().bvJ();
    AppMethodBeat.o(371);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(378);
    super.onDestroy();
    a.b.bvL().stop();
    AppMethodBeat.o(378);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(372);
    ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bnw localbnw;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mkD = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgT;
      this.mgW = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgW;
      this.mgX = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgX;
      this.mgY = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgY;
      this.mgZ = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgZ;
      this.mkG = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mha;
      this.mhb = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mhb;
      this.mkJ = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgU;
      this.mkK = ((com.tencent.mm.plugin.facedetect.b.l)paramm).mgV;
      ab.d("MicroMsg.FaceDetectConfirmUI", paramm.toString());
      if (bo.isNullOrNil(this.mgW)) {
        this.mgW = getString(2131299537);
      }
      dismissDialog();
      this.mkz.setEnabled(true);
      this.mky.setText(this.mgW);
      paramString = String.format(getString(2131299538), new Object[] { this.mkK });
      paramm = new SpannableString(paramString);
      paramInt1 = paramString.lastIndexOf(" ");
      paramm.setSpan(new StyleSpan(1), 0, paramInt1, 17);
      this.mkI.setText(paramm);
      o.ahG().a(this.mkJ, this.mkH);
      if (this.mkD != null)
      {
        ab.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.mkD.cyA, this.mkD.xCf, this.mkD.url });
        localbnw = this.mkD;
        ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { localbnw.cyA });
        if (!bo.isNullOrNil(localbnw.cyA)) {
          break label584;
        }
        paramString = getString(2131299535);
        if (!bo.isNullOrNil(localbnw.xCf)) {
          break label593;
        }
        paramm = getString(2131299534);
        label411:
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramString + paramm);
        localSpannable.setSpan(new FaceDetectConfirmUI.7(this, localbnw), paramString.length(), paramString.length() + paramm.length(), 33);
        this.mkA.setVisibility(0);
        this.mkB.setVisibility(0);
        this.mkB.setText(localSpannable);
        this.mkB.setMovementMethod(LinkMovementMethod.getInstance());
        if (localbnw.xCg != 0) {
          break label603;
        }
        this.mkA.setChecked(false);
        this.mkz.setEnabled(false);
        label530:
        this.mkC.setText(getString(2131299532));
        this.mkC.setOnClickListener(new FaceDetectConfirmUI.8(this));
        this.mkC.setVisibility(0);
      }
    }
    for (;;)
    {
      g.Rc().b(1147, this);
      AppMethodBeat.o(372);
      return;
      label584:
      paramString = localbnw.cyA;
      break;
      label593:
      paramm = localbnw.xCf;
      break label411;
      label603:
      if (localbnw.xCg != 1) {
        break label530;
      }
      this.mkA.setChecked(true);
      this.mkz.setEnabled(true);
      break label530;
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = getString(2131299581);
      }
      dismissDialog();
      h.a(this, paramm, getString(2131297087), false, new FaceDetectConfirmUI.6(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */