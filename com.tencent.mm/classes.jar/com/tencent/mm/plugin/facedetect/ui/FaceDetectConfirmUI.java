package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String appId;
  private int businessType;
  private String lSY;
  private ImageView qAa;
  private TextView qAb;
  private String qAc;
  private String qAd;
  private String qwt = null;
  private String qwu = null;
  private String qwv = null;
  private float qww;
  private String qwy;
  private TextView qzR;
  private Button qzS;
  private CheckBox qzT;
  private TextView qzU;
  private TextView qzV;
  private chn qzW = null;
  private String qzX;
  private int qzY;
  private int qzZ;
  private com.tencent.mm.ui.base.p tipDialog;
  
  private void coa()
  {
    AppMethodBeat.i(103893);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.CU(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.cnC().a(this.businessType, false, 3, 1, 90024);
    FaceDetectReporter.cnC().qyk = System.currentTimeMillis();
    FaceDetectReporter.cnC().cX(this.lSY, this.businessType);
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
    ac.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.cnC().qyk = System.currentTimeMillis();
    FaceDetectReporter.cnC().cX(this.lSY, this.businessType);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(103892);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103894);
    coa();
    super.onBackPressed();
    AppMethodBeat.o(103894);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103890);
    super.onCreate(paramBundle);
    this.appId = getIntent().getStringExtra("k_app_id");
    this.qzX = getIntent().getStringExtra("request_verify_pre_info");
    this.lSY = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.qzY = getIntent().getIntExtra("check_alive_type", 0);
    ac.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", new Object[] { Integer.valueOf(this.qzY) });
    ac.i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", new Object[] { Integer.valueOf(this.businessType) });
    setMMTitle(getString(2131758696));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(103882);
        ac.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
        FaceDetectConfirmUI.a(FaceDetectConfirmUI.this);
        AppMethodBeat.o(103882);
        return false;
      }
    });
    this.qzR = ((TextView)findViewById(2131299664));
    this.qzS = ((Button)findViewById(2131305176));
    this.qAa = ((ImageView)findViewById(2131296908));
    this.qAb = ((TextView)findViewById(2131296909));
    this.qzT = ((CheckBox)findViewById(2131299665));
    this.qzT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(103883);
        if (paramAnonymousBoolean)
        {
          FaceDetectConfirmUI.b(FaceDetectConfirmUI.this).setEnabled(true);
          AppMethodBeat.o(103883);
          return;
        }
        FaceDetectConfirmUI.b(FaceDetectConfirmUI.this).setEnabled(false);
        AppMethodBeat.o(103883);
      }
    });
    this.qzT.setVisibility(8);
    this.qzU = ((TextView)findViewById(2131299666));
    this.qzU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103884);
        paramAnonymousView = FaceDetectConfirmUI.c(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(103884);
          return;
        }
      }
    });
    this.qzV = ((TextView)findViewById(2131299663));
    this.qzS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103885);
        ac.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.d(FaceDetectConfirmUI.this)) });
        paramAnonymousView = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
        Bundle localBundle = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (localBundle != null)
        {
          localBundle.putInt("check_alive_type_response", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          localBundle.putString("key_feedback_url", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          localBundle.putString("business_tips", FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          localBundle.putFloat("mLight_threshold", FaceDetectConfirmUI.g(FaceDetectConfirmUI.this));
          ac.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          paramAnonymousView.putExtras(localBundle);
          FaceDetectConfirmUI.this.startActivityForResult(paramAnonymousView, 1);
          AppMethodBeat.o(103885);
          return;
        }
        ac.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
        AppMethodBeat.o(103885);
      }
    });
    ac.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(2131755906);
    this.tipDialog = h.b(paramBundle, getString(2131755936), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramBundle = new com.tencent.mm.plugin.facedetect.b.l(this.appId, this.qzX, this.qzY);
    com.tencent.mm.kernel.g.agi().a(1147, this);
    com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
    a.b.coM().coL();
    AppMethodBeat.o(103890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103897);
    super.onDestroy();
    a.b.coM().stop();
    AppMethodBeat.o(103897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(103891);
    ac.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    final chn localchn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qzW = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwq;
      this.qwt = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwt;
      this.qwu = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwu;
      this.qwv = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwv;
      this.qww = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qww;
      this.qzZ = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwx;
      this.qwy = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwy;
      this.qAc = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qwr;
      this.qAd = ((com.tencent.mm.plugin.facedetect.b.l)paramn).qws;
      ac.d("MicroMsg.FaceDetectConfirmUI", paramn.toString());
      if (bs.isNullOrNil(this.qwt)) {
        this.qwt = getString(2131758694);
      }
      dismissDialog();
      this.qzS.setEnabled(true);
      this.qzR.setText(this.qwt);
      paramString = String.format(getString(2131758695), new Object[] { this.qAd });
      paramn = new SpannableString(paramString);
      paramInt1 = paramString.lastIndexOf(" ");
      if (paramInt1 != -1) {
        paramn.setSpan(new StyleSpan(1), 0, paramInt1, 17);
      }
      this.qAb.setText(paramn);
      o.aFB().loadImage(this.qAc, this.qAa);
      if (this.qzW != null)
      {
        ac.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.qzW.dlQ, this.qzW.FvK, this.qzW.url });
        localchn = this.qzW;
        ac.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { localchn.dlQ });
        if (!bs.isNullOrNil(localchn.dlQ)) {
          break label589;
        }
        paramString = getString(2131758692);
        if (!bs.isNullOrNil(localchn.FvK)) {
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
            if (!bs.isNullOrNil(localchn.url))
            {
              FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, localchn.url);
              AppMethodBeat.o(103887);
              return;
            }
            ac.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
            AppMethodBeat.o(103887);
          }
          
          public final void updateDrawState(TextPaint paramAnonymousTextPaint)
          {
            AppMethodBeat.i(103888);
            paramAnonymousTextPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(2131100547));
            AppMethodBeat.o(103888);
          }
        }, paramString.length(), paramString.length() + paramn.length(), 33);
        this.qzT.setVisibility(0);
        this.qzU.setVisibility(0);
        this.qzU.setText(localSpannable);
        this.qzU.setMovementMethod(LinkMovementMethod.getInstance());
        if (localchn.FvL != 0) {
          break label608;
        }
        this.qzT.setChecked(false);
        this.qzS.setEnabled(false);
        label535:
        this.qzV.setText(getString(2131758689));
        this.qzV.setOnClickListener(new View.OnClickListener()
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
                ac.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramAnonymousView });
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousView);
                AppMethodBeat.o(103889);
                return;
              }
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ac.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramAnonymousView, "alvinluo jumpToWebView exception", new Object[0]);
              AppMethodBeat.o(103889);
            }
          }
        });
        this.qzV.setVisibility(0);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agi().b(1147, this);
      AppMethodBeat.o(103891);
      return;
      label589:
      paramString = localchn.dlQ;
      break;
      label598:
      paramn = localchn.FvK;
      break label416;
      label608:
      if (localchn.FvL != 1) {
        break label535;
      }
      this.qzT.setChecked(true);
      this.qzS.setEnabled(true);
      break label535;
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = getString(2131758738);
      }
      dismissDialog();
      h.a(this, paramn, getString(2131755906), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(103886);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.CU(90022));
          paramAnonymousDialogInterface.putExtra("err_msg", "get confirm info error");
          FaceDetectReporter.cnC().a(FaceDetectConfirmUI.h(FaceDetectConfirmUI.this), false, 3, 2, 90022);
          FaceDetectReporter.cnC().qyk = System.currentTimeMillis();
          FaceDetectReporter.cnC().cX(FaceDetectConfirmUI.i(FaceDetectConfirmUI.this), FaceDetectConfirmUI.h(FaceDetectConfirmUI.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */