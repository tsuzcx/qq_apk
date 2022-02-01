package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.List;

public class FaceAgreementUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private Dialog mProgressDialog = null;
  private g tZx;
  private TextView wEH;
  private Button wEI;
  private LinearLayout wEJ;
  private TextView wEK;
  private TextView wEL;
  private TextView wEM;
  private ImageView wEN;
  private String wEO = "";
  private String wEP = "";
  private String wEQ = "";
  private boolean wER = false;
  private boolean wES = false;
  
  private void a(final Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, TextView paramTextView)
  {
    AppMethodBeat.i(190255);
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = 0;
    while (i < paramList2.size())
    {
      String str = (String)paramList2.get(i);
      int j = paramString.indexOf(str);
      int k = j + str.length();
      if ((j >= 0) && (k <= paramString.length())) {
        localSpannableString.setSpan(new a((String)paramList1.get(i), MMApplicationContext.getContext().getResources().getColor(a.b.link_color), MMApplicationContext.getContext().getResources().getColor(a.b.BW_0_Alpha_0_2), new a.a()
        {
          public final void azH(String paramAnonymousString)
          {
            AppMethodBeat.i(197382);
            Log.i("MicroMsg.FaceAgreementUI", "click %s", new Object[] { paramAnonymousString });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(197382);
          }
        }), j, k, 17);
      }
      i += 1;
    }
    if (paramTextView != null)
    {
      paramTextView.setText(localSpannableString);
      paramTextView.setOnTouchListener(new FaceAgreementUI.6(this, localSpannableString, paramTextView));
    }
    AppMethodBeat.o(190255);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.face_agreement_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190249);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.FaceAgreementUI", "onActivityResult() ");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(190249);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190248);
    Log.i("MicroMsg.FaceAgreementUI", "onBackPressed()");
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.flash.c.b.St(l.Lv(90024));
    localIntent.putExtra("err_code", l.Lv(90024));
    localIntent.putExtra("err_msg", "cancel");
    setResult(0, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(190248);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190242);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FaceAgreementUI", "onCreate()");
    this.wEH = ((TextView)findViewById(a.e.face_agreement_change_user_info));
    this.wEI = ((Button)findViewById(a.e.face_agreement_verify));
    this.wEJ = ((LinearLayout)findViewById(a.e.face_agreement_protocol));
    this.wEK = ((TextView)findViewById(a.e.face_agreement_tip));
    this.wEL = ((TextView)findViewById(a.e.face_agreement_title));
    ar.a(this.wEL.getPaint(), 0.8F);
    this.wEI.setEnabled(true);
    this.wEI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197821);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.FaceAgreementUI", "needShowProtocal : %s", new Object[] { Boolean.valueOf(FaceAgreementUI.a(FaceAgreementUI.this)) });
        if (FaceAgreementUI.a(FaceAgreementUI.this)) {
          FaceAgreementUI.b(FaceAgreementUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(197821);
          return;
          paramAnonymousView = new Intent(FaceAgreementUI.this, FaceFlashPermissionUI.class);
          localObject = FaceAgreementUI.this.getIntent().getExtras();
          if (localObject != null) {
            paramAnonymousView.putExtras((Bundle)localObject);
          }
          paramAnonymousView.putExtra("needContract", FaceAgreementUI.a(FaceAgreementUI.this));
          paramAnonymousView.putExtra("face_permission_location_check", true);
          FaceAgreementUI.this.startActivityForResult(paramAnonymousView, 1);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 67L, 1L, false);
        }
      }
    });
    setMMTitle("");
    setActionbarColor(getResources().getColor(a.b.white));
    getSupportActionBar().hide();
    this.wEN = ((ImageView)findViewById(a.e.face_agreement_cancel_btn));
    this.wEN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198294);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FaceAgreementUI.c(FaceAgreementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198294);
      }
    });
    this.mProgressDialog = com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(a.i.loading_tips_1), false, null);
    com.tencent.mm.kernel.h.aGY().a(1108, this);
    int i = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("package");
    String str = getIntent().getStringExtra("packageSign");
    com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.plugin.facedetectaction.a.d(i, paramBundle, str), 0);
    ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.b.class)).ij(11, 6);
    AppMethodBeat.o(190242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190260);
    Log.i("MicroMsg.FaceAgreementUI", "onDestroy() ");
    super.onDestroy();
    if (this.wES) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 63L, 1L, false);
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKM, false);
    Log.i("MicroMsg.FaceAgreementUI", "use new face action  %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      com.tencent.mm.plugin.flash.c.b.epN().gmj = 2L;
      AppMethodBeat.o(190260);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.epN().gmj = 1L;
    AppMethodBeat.o(190260);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190261);
    super.onResume();
    Log.i("MicroMsg.FaceAgreementUI", "onResume()");
    AppMethodBeat.o(190261);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(190245);
    Log.i("MicroMsg.FaceAgreementUI", "onSceneEnd()");
    com.tencent.mm.kernel.h.aGY().b(1108, this);
    com.tencent.mm.plugin.flash.c.b.epN().gml = paramInt2;
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189866);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FaceAgreementUI.d(FaceAgreementUI.this);
          int i = ((com.tencent.mm.plugin.facedetectaction.a.d)paramq).wDj.Tfc;
          localObject = ((com.tencent.mm.plugin.facedetectaction.a.d)paramq).wDj.Tfd;
          FaceAgreementUI.a(FaceAgreementUI.this, ((com.tencent.mm.plugin.facedetectaction.a.d)paramq).wDj.ORR);
          FaceAgreementUI.b(FaceAgreementUI.this, ((com.tencent.mm.plugin.facedetectaction.a.d)paramq).wDj.Tfe);
          FaceAgreementUI.c(FaceAgreementUI.this, ((com.tencent.mm.plugin.facedetectaction.a.d)paramq).wDj.Tff);
          Log.i("MicroMsg.FaceAgreementUI", "[cgi-ret]contractRet:%s  tip:%s url:%s contractTitle:%s contractDesc:%s", new Object[] { Integer.valueOf(i), localObject, FaceAgreementUI.e(FaceAgreementUI.this), FaceAgreementUI.f(FaceAgreementUI.this), FaceAgreementUI.g(FaceAgreementUI.this) });
          if (i == 1)
          {
            FaceAgreementUI.a(FaceAgreementUI.this, false);
            FaceAgreementUI.h(FaceAgreementUI.this).setEnabled(true);
            if (!FaceAgreementUI.a(FaceAgreementUI.this)) {
              break label301;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 62L, 1L, false);
          }
          for (;;)
          {
            FaceAgreementUI.j(FaceAgreementUI.this).setText((CharSequence)localObject);
            AppMethodBeat.o(189866);
            return;
            if (TextUtils.isEmpty(FaceAgreementUI.e(FaceAgreementUI.this)))
            {
              FaceAgreementUI.a(FaceAgreementUI.this, false);
              FaceAgreementUI.i(FaceAgreementUI.this).setVisibility(4);
              FaceAgreementUI.h(FaceAgreementUI.this).setEnabled(true);
              break;
            }
            FaceAgreementUI.a(FaceAgreementUI.this, true);
            com.tencent.mm.plugin.facedetectaction.b.d.wDy.wDH = true;
            break;
            label301:
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 61L, 1L, false);
          }
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 72L, 1L, false);
        FaceAgreementUI.a(FaceAgreementUI.this, false);
        Log.e("MicroMsg.FaceAgreementUIError", "[cgi-ret]net ret error, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        FaceAgreementUI.d(FaceAgreementUI.this);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("err_msg", "fail");
        ((Intent)localObject).putExtra("err_code", 90110);
        com.tencent.mm.plugin.flash.c.b.St(90110);
        FaceAgreementUI.this.setResult(1, (Intent)localObject);
        FaceAgreementUI.this.finish();
        AppMethodBeat.o(189866);
      }
    });
    AppMethodBeat.o(190245);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI
 * JD-Core Version:    0.7.0.1
 */