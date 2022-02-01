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
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.flash.d.b.b;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectConfirmUI
  extends MMActivity
  implements i
{
  private String appId;
  private int businessType;
  private String nlH;
  private String sPR = null;
  private String sPS = null;
  private String sPT = null;
  private float sPU;
  private String sPW;
  private TextView sTb;
  private Button sTc;
  private CheckBox sTd;
  private TextView sTe;
  private TextView sTf;
  private dfb sTg = null;
  private String sTh;
  private int sTi;
  private int sTj;
  private ImageView sTk;
  private TextView sTl;
  private String sTm;
  private String sTn;
  private ViewGroup sTo;
  private long sTp = 0L;
  private com.tencent.mm.ui.base.q tipDialog;
  
  private void cTA()
  {
    AppMethodBeat.i(103893);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.HL(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    FaceDetectReporter.cTe().ad(this.businessType, 1, 90024);
    com.tencent.mm.plugin.flash.c.b.s("msgVerify", "user cancel in confirm ui");
    com.tencent.mm.plugin.flash.c.b.MW(90024);
    FaceDetectReporter.cTe().sRB = System.currentTimeMillis();
    FaceDetectReporter.cTe().dr(this.nlH, this.businessType);
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
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494064;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(103892);
    Log.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    FaceDetectReporter.cTe().sRB = System.currentTimeMillis();
    if (paramIntent.hasExtra("err_code")) {
      paramIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.HL(paramIntent.getIntExtra("err_code", -1)));
    }
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(103892);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(103894);
    cTA();
    super.onBackPressed();
    AppMethodBeat.o(103894);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(103890);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.flash.c.b.dLi().erc = System.currentTimeMillis();
    this.appId = getIntent().getStringExtra("appId");
    this.sTh = getIntent().getStringExtra("request_verify_pre_info");
    this.nlH = getIntent().getStringExtra("key_function_name");
    this.businessType = getIntent().getIntExtra("key_business_type", -1);
    this.sTi = getIntent().getIntExtra("check_alive_type", 0);
    this.sTp = System.currentTimeMillis();
    Log.i("MicroMsg.FaceDetectConfirmUI", "appId:%s jsonData:%s functionName:%s businessType:%s check_alive_type_request:%s", new Object[] { this.appId, this.sTh, this.nlH, Integer.valueOf(this.businessType), Integer.valueOf(this.sTi) });
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(103882);
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
        FaceDetectConfirmUI.a(FaceDetectConfirmUI.this);
        AppMethodBeat.o(103882);
        return false;
      }
    });
    this.sTb = ((TextView)findViewById(2131300315));
    this.sTc = ((Button)findViewById(2131308365));
    this.sTk = ((ImageView)findViewById(2131297010));
    this.sTl = ((TextView)findViewById(2131297011));
    this.sTo = ((ViewGroup)findViewById(2131300317));
    this.sTo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FaceDetectConfirmUI.b(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.b(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186379);
          return;
        }
      }
    });
    this.sTd = ((CheckBox)findViewById(2131300316));
    this.sTd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186380);
        if (paramAnonymousBoolean)
        {
          FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).setEnabled(true);
          AppMethodBeat.o(186380);
          return;
        }
        FaceDetectConfirmUI.c(FaceDetectConfirmUI.this).setEnabled(false);
        AppMethodBeat.o(186380);
      }
    });
    this.sTd.setVisibility(8);
    this.sTe = ((TextView)findViewById(2131300318));
    this.sTe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(103885);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = FaceDetectConfirmUI.b(FaceDetectConfirmUI.this);
        if (!FaceDetectConfirmUI.b(FaceDetectConfirmUI.this).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(103885);
          return;
        }
      }
    });
    this.sTf = ((TextView)findViewById(2131300314));
    this.sTc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.d(FaceDetectConfirmUI.this)) });
        if (!p.ai(FaceDetectConfirmUI.this))
        {
          Log.e("MicroMsg.FaceDetectConfirmUI", "carson: no camera permission. request permission");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186381);
          return;
        }
        paramAnonymousView = FaceDetectConfirmUI.this.getIntent().getExtras();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.putInt("check_alive_type", FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("appId", FaceDetectConfirmUI.e(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("feedbackUrl", FaceDetectConfirmUI.f(FaceDetectConfirmUI.this));
          paramAnonymousView.putString("business_tips", FaceDetectConfirmUI.g(FaceDetectConfirmUI.this));
          paramAnonymousView.putFloat("mLight_threshold", FaceDetectConfirmUI.h(FaceDetectConfirmUI.this));
          paramAnonymousView.putLong("confirm_page_timestamp", FaceDetectConfirmUI.i(FaceDetectConfirmUI.this));
          Log.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.d(FaceDetectConfirmUI.this));
          FaceFlashUI.a(FaceDetectConfirmUI.this, paramAnonymousView, 1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186381);
          return;
          Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
        }
      }
    });
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
    paramBundle = getContext();
    getString(2131755998);
    this.tipDialog = h.a(paramBundle, getString(2131756029), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    paramBundle = new com.tencent.mm.plugin.facedetect.b.l(this.appId, this.sTh, this.sTi);
    g.azz().a(1147, this);
    g.azz().a(paramBundle, 0);
    b.b.dLm().dLl();
    com.tencent.mm.plugin.flash.c.b.MY(1);
    AppMethodBeat.o(103890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(103897);
    super.onDestroy();
    b.b.dLm().stop();
    AppMethodBeat.o(103897);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186385);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(186385);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(186385);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.sTc.performClick();
        AppMethodBeat.o(186385);
        return;
      }
      h.a(this, getString(2131759068), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186375);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceDetectConfirmUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$10", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(186375);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186376);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(186376);
        }
      });
      AppMethodBeat.o(186385);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        this.sTc.performClick();
        AppMethodBeat.o(186385);
        return;
      }
      h.a(this, getString(2131759069), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186377);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = FaceDetectConfirmUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(186377);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186378);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(186378);
        }
      });
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(103891);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.flash.c.b.s("confirmCode", Integer.valueOf(paramInt1));
    com.tencent.mm.plugin.flash.c.b.s("confirmMsg", paramString);
    final dfb localdfb;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.sTg = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPO;
      this.sPR = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPR;
      this.sPS = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPS;
      this.sPT = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPT;
      this.sPU = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPU;
      this.sTj = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPV;
      this.sPW = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPW;
      this.sTm = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPP;
      this.sTn = ((com.tencent.mm.plugin.facedetect.b.l)paramq).sPQ;
      Log.d("MicroMsg.FaceDetectConfirmUI", paramq.toString());
      if (Util.isNullOrNil(this.sPR)) {
        this.sPR = getString(2131759009);
      }
      dismissDialog();
      this.sTc.setEnabled(true);
      this.sTb.setText(this.sPR);
      paramString = String.format(getString(2131759010), new Object[] { this.sTn });
      this.sTl.setText(paramString);
      com.tencent.mm.av.q.bcV().loadImage(this.sTm, this.sTk);
      if (this.sTg != null)
      {
        Log.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[] { this.sTg.dQx, this.sTg.LGp, this.sTg.url });
        localdfb = this.sTg;
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[] { localdfb.dQx });
        if (!Util.isNullOrNil(localdfb.dQx)) {
          break label565;
        }
        paramString = getString(2131759007);
        if (!Util.isNullOrNil(localdfb.LGp)) {
          break label574;
        }
        paramq = getString(2131759006);
        label392:
        Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramString + paramq);
        localSpannable.setSpan(new ClickableSpan()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103889);
            if (!Util.isNullOrNil(localdfb.url))
            {
              FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, localdfb.url);
              AppMethodBeat.o(103889);
              return;
            }
            Log.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
            AppMethodBeat.o(103889);
          }
          
          public final void updateDrawState(TextPaint paramAnonymousTextPaint)
          {
            AppMethodBeat.i(186383);
            paramAnonymousTextPaint.setColor(FaceDetectConfirmUI.this.getResources().getColor(2131100685));
            AppMethodBeat.o(186383);
          }
        }, paramString.length(), paramString.length() + paramq.length(), 33);
        this.sTd.setVisibility(0);
        this.sTe.setVisibility(0);
        this.sTe.setText(localSpannable);
        this.sTe.setMovementMethod(LinkMovementMethod.getInstance());
        if (localdfb.MKc != 0) {
          break label584;
        }
        this.sTd.setChecked(false);
        this.sTc.setEnabled(false);
        label511:
        this.sTf.setText(getString(2131759004));
        this.sTf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186384);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            for (;;)
            {
              try
              {
                if (FaceDetectConfirmUI.e(FaceDetectConfirmUI.this) == null) {
                  continue;
                }
                paramAnonymousView = FaceDetectConfirmUI.e(FaceDetectConfirmUI.this);
                paramAnonymousView = com.tencent.mm.compatible.util.q.encode(String.format("appid=%s", new Object[] { paramAnonymousView }), "UTF-8");
                paramAnonymousView = FaceDetectConfirmUI.l(FaceDetectConfirmUI.this) + "?customInfo=" + paramAnonymousView;
                Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramAnonymousView });
                FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousView);
              }
              catch (Exception paramAnonymousView)
              {
                Log.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramAnonymousView, "alvinluo jumpToWebView exception", new Object[0]);
                continue;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186384);
              return;
              paramAnonymousView = "";
            }
          }
        });
        this.sTf.setVisibility(0);
      }
    }
    for (;;)
    {
      g.azz().b(1147, this);
      AppMethodBeat.o(103891);
      return;
      label565:
      paramString = localdfb.dQx;
      break;
      label574:
      paramq = localdfb.LGp;
      break label392;
      label584:
      if (localdfb.MKc != 1) {
        break label511;
      }
      this.sTd.setChecked(true);
      this.sTc.setEnabled(true);
      break label511;
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(2131759056);
      }
      dismissDialog();
      h.a(this, paramq, getString(2131755998), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(186382);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.l.HL(90022));
          paramAnonymousDialogInterface.putExtra("err_msg", "get confirm info error");
          FaceDetectReporter.cTe().ad(FaceDetectConfirmUI.j(FaceDetectConfirmUI.this), 2, 90022);
          com.tencent.mm.plugin.flash.c.b.MW(90022);
          FaceDetectReporter.cTe().sRB = System.currentTimeMillis();
          FaceDetectReporter.cTe().dr(FaceDetectConfirmUI.k(FaceDetectConfirmUI.this), FaceDetectConfirmUI.j(FaceDetectConfirmUI.this));
          FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, paramAnonymousDialogInterface);
          FaceDetectConfirmUI.this.finish();
          AppMethodBeat.o(186382);
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