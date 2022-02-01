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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.a.b;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements f
{
  private String appId;
  private int businessType;
  private String mxL;
  private String rom = null;
  private String ron = null;
  private String roo = null;
  private float rop;
  private String ror;
  private TextView rrK;
  private Button rrL;
  private CheckBox rrM;
  private TextView rrN;
  private TextView rrO;
  private cnh rrP = null;
  private String rrQ;
  private int rrR;
  private int rrS;
  private ImageView rrT;
  private TextView rrU;
  private String rrV;
  private String rrW;
  private p tipDialog;
  
  private void cvg()
  {
    AppMethodBeat.i(103893);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.DZ(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.cuI().a(this.businessType, false, 3, 1, 90024);
    FaceDetectReporter.cuI().rqe = System.currentTimeMillis();
    FaceDetectReporter.cuI().dl(this.mxL, this.businessType);
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
    ae.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.cuI().rqe = System.currentTimeMillis();
    FaceDetectReporter.cuI().dl(this.mxL, this.businessType);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(103892);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103894);
    cvg();
    super.onBackPressed();
    AppMethodBeat.o(103894);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103890);
    super.onCreate(paramBundle);
    this.appId = getIntent().getStringExtra("k_app_id");
    this.rrQ = getIntent().getStringExtra("request_verify_pre_info");
    this.mxL = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.rrR = getIntent().getIntExtra("check_alive_type", 0);
    ae.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type : %s", new Object[] { Integer.valueOf(this.rrR) });
    ae.i("MicroMsg.FaceDetectConfirmUI", "carson businessType : %s", new Object[] { Integer.valueOf(this.businessType) });
    setMMTitle(getString(2131758696));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(103882);
        ae.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
        FaceDetectConfirmUI.a(FaceDetectConfirmUI.this);
        AppMethodBeat.o(103882);
        return false;
      }
    });
    this.rrK = ((TextView)findViewById(2131299664));
    this.rrL = ((Button)findViewById(2131305176));
    this.rrT = ((ImageView)findViewById(2131296908));
    this.rrU = ((TextView)findViewById(2131296909));
    this.rrM = ((CheckBox)findViewById(2131299665));
    this.rrM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
    this.rrM.setVisibility(8);
    this.rrN = ((TextView)findViewById(2131299666));
    this.rrN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103884);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = FaceDetectConfirmUI.c(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103884);
          return;
        }
      }
    });
    this.rrO = ((TextView)findViewById(2131299663));
    this.rrL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103885);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        ae.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.d(FaceDetectConfirmUI.this)) });
        paramAnonymousView = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
        localObject = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (localObject != null)
        {
          ((Bundle)localObject).putInt("check_alive_type_response", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          ((Bundle)localObject).putString("key_feedback_url", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          ((Bundle)localObject).putString("business_tips", FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          ((Bundle)localObject).putFloat("mLight_threshold", FaceDetectConfirmUI.g(FaceDetectConfirmUI.this));
          ae.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          paramAnonymousView.putExtras((Bundle)localObject);
          FaceDetectConfirmUI.this.startActivityForResult(paramAnonymousView, 1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103885);
          return;
          ae.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
        }
      }
    });
    ae.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(2131755906);
    this.tipDialog = h.b(paramBundle, getString(2131755936), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramBundle = new com.tencent.mm.plugin.facedetect.b.l(this.appId, this.rrQ, this.rrR);
    g.ajj().a(1147, this);
    g.ajj().a(paramBundle, 0);
    a.b.cvS().cvR();
    AppMethodBeat.o(103890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103897);
    super.onDestroy();
    a.b.cvS().stop();
    AppMethodBeat.o(103897);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(103891);
    ae.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    final cnh localcnh;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rrP = ((com.tencent.mm.plugin.facedetect.b.l)paramn).roj;
      this.rom = ((com.tencent.mm.plugin.facedetect.b.l)paramn).rom;
      this.ron = ((com.tencent.mm.plugin.facedetect.b.l)paramn).ron;
      this.roo = ((com.tencent.mm.plugin.facedetect.b.l)paramn).roo;
      this.rop = ((com.tencent.mm.plugin.facedetect.b.l)paramn).rop;
      this.rrS = ((com.tencent.mm.plugin.facedetect.b.l)paramn).roq;
      this.ror = ((com.tencent.mm.plugin.facedetect.b.l)paramn).ror;
      this.rrV = ((com.tencent.mm.plugin.facedetect.b.l)paramn).rok;
      this.rrW = ((com.tencent.mm.plugin.facedetect.b.l)paramn).rol;
      ae.d("MicroMsg.FaceDetectConfirmUI", paramn.toString());
      if (bu.isNullOrNil(this.rom)) {
        this.rom = getString(2131758694);
      }
      dismissDialog();
      this.rrL.setEnabled(true);
      this.rrK.setText(this.rom);
      paramString = String.format(getString(2131758695), new Object[] { this.rrW });
      paramn = new SpannableString(paramString);
      paramInt1 = paramString.lastIndexOf(" ");
      if (paramInt1 != -1) {
        paramn.setSpan(new StyleSpan(1), 0, paramInt1, 17);
      }
      this.rrU.setText(paramn);
      com.tencent.mm.av.q.aJb().loadImage(this.rrV, this.rrT);
      if (this.rrP != null)
      {
        ae.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.rrP.dyI, this.rrP.Hzq, this.rrP.url });
        localcnh = this.rrP;
        ae.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { localcnh.dyI });
        if (!bu.isNullOrNil(localcnh.dyI)) {
          break label589;
        }
        paramString = getString(2131758692);
        if (!bu.isNullOrNil(localcnh.Hzq)) {
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
            if (!bu.isNullOrNil(localcnh.url))
            {
              FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, localcnh.url);
              AppMethodBeat.o(103887);
              return;
            }
            ae.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
            AppMethodBeat.o(103887);
          }
          
          public final void updateDrawState(TextPaint paramAnonymousTextPaint)
          {
            AppMethodBeat.i(103888);
            paramAnonymousTextPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(2131100547));
            AppMethodBeat.o(103888);
          }
        }, paramString.length(), paramString.length() + paramn.length(), 33);
        this.rrM.setVisibility(0);
        this.rrN.setVisibility(0);
        this.rrN.setText(localSpannable);
        this.rrN.setMovementMethod(LinkMovementMethod.getInstance());
        if (localcnh.Hzr != 0) {
          break label608;
        }
        this.rrM.setChecked(false);
        this.rrL.setEnabled(false);
        label535:
        this.rrO.setText(getString(2131758689));
        this.rrO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103889);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            for (;;)
            {
              try
              {
                if (FaceDetectConfirmUI.j(FaceDetectConfirmUI.this) == null) {
                  continue;
                }
                paramAnonymousView = FaceDetectConfirmUI.j(FaceDetectConfirmUI.this);
                paramAnonymousView = com.tencent.mm.compatible.util.q.encode(String.format("appid=%s", new Object[] { paramAnonymousView }), "UTF-8");
                paramAnonymousView = FaceDetectConfirmUI.k(FaceDetectConfirmUI.this) + "?customInfo=" + paramAnonymousView;
                ae.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramAnonymousView });
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousView);
              }
              catch (Exception paramAnonymousView)
              {
                ae.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramAnonymousView, "alvinluo jumpToWebView exception", new Object[0]);
                continue;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(103889);
              return;
              paramAnonymousView = "";
            }
          }
        });
        this.rrO.setVisibility(0);
      }
    }
    for (;;)
    {
      g.ajj().b(1147, this);
      AppMethodBeat.o(103891);
      return;
      label589:
      paramString = localcnh.dyI;
      break;
      label598:
      paramn = localcnh.Hzq;
      break label416;
      label608:
      if (localcnh.Hzr != 1) {
        break label535;
      }
      this.rrM.setChecked(true);
      this.rrL.setEnabled(true);
      break label535;
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = getString(2131758738);
      }
      dismissDialog();
      h.a(this, paramn, getString(2131755906), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(103886);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.DZ(90022));
          paramAnonymousDialogInterface.putExtra("err_msg", "get confirm info error");
          FaceDetectReporter.cuI().a(FaceDetectConfirmUI.h(FaceDetectConfirmUI.this), false, 3, 2, 90022);
          FaceDetectReporter.cuI().rqe = System.currentTimeMillis();
          FaceDetectReporter.cuI().dl(FaceDetectConfirmUI.i(FaceDetectConfirmUI.this), FaceDetectConfirmUI.h(FaceDetectConfirmUI.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI
 * JD-Core Version:    0.7.0.1
 */