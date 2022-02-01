package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetectaction.a.d;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.j;
import java.util.HashSet;
import java.util.List;

public class FaceAgreementUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private TextView AaS;
  private Button AaT;
  private LinearLayout AaU;
  private TextView AaV;
  private TextView AaW;
  private TextView AaX;
  private ImageView AaY;
  private String AaZ = "";
  private String Aba = "";
  private String Abb = "";
  private TextView Abc;
  private boolean Abd = false;
  private boolean Abe = false;
  private String hYB = "";
  private Dialog mProgressDialog = null;
  private j xcO;
  
  private void a(Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, TextView paramTextView)
  {
    AppMethodBeat.i(262627);
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = 0;
    while (i < paramList2.size())
    {
      String str = (String)paramList2.get(i);
      int j = paramString.indexOf(str);
      int k = j + str.length();
      if ((j >= 0) && (k <= paramString.length())) {
        localSpannableString.setSpan(new a((String)paramList1.get(i), MMApplicationContext.getContext().getResources().getColor(a.b.link_color), MMApplicationContext.getContext().getResources().getColor(a.b.BW_0_Alpha_0_2), new FaceAgreementUI.6(this, paramContext)), j, k, 17);
      }
      i += 1;
    }
    if (paramTextView != null)
    {
      paramTextView.setText(localSpannableString);
      a(paramTextView, localSpannableString);
    }
    AppMethodBeat.o(262627);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(262630);
    paramTextView.setOnTouchListener(new FaceAgreementUI.7(this, paramSpannable, paramTextView));
    AppMethodBeat.o(262630);
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
    AppMethodBeat.i(262659);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.FaceAgreementUI", "onActivityResult() ");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(262659);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(262656);
    Log.i("MicroMsg.FaceAgreementUI", "onBackPressed()");
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.flash.c.b.VM(com.tencent.mm.plugin.facedetect.model.i.Ms(90024));
    localIntent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.i.Ms(90024));
    localIntent.putExtra("err_msg", "cancel");
    setResult(0, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(262656);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262653);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FaceAgreementUI", "onCreate()");
    this.AaS = ((TextView)findViewById(a.e.face_agreement_change_user_info));
    this.AaT = ((Button)findViewById(a.e.face_agreement_verify));
    this.AaU = ((LinearLayout)findViewById(a.e.face_agreement_protocol));
    this.AaV = ((TextView)findViewById(a.e.face_agreement_tip));
    this.AaW = ((TextView)findViewById(a.e.face_agreement_title));
    aw.a(this.AaW.getPaint(), 0.8F);
    this.AaT.setEnabled(true);
    this.AaT.setOnClickListener(new FaceAgreementUI.1(this));
    this.Abc = ((TextView)findViewById(a.e.face_agreement_other_verify_title));
    this.hYB = getIntent().getStringExtra("otherVerifyTitleFront");
    if (!Util.isNullOrNil(this.hYB))
    {
      this.Abc.setVisibility(0);
      this.Abc.setClickable(true);
      this.Abc.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s(getContext()));
      paramBundle = new SpannableStringBuilder(this.hYB);
      paramBundle.setSpan(new a(this.hYB, getContext().getResources().getColor(a.b.link_color), getContext().getResources().getColor(a.b.BW_0_Alpha_0_2), new a.a()
      {
        public final void onClick(String paramAnonymousString)
        {
          AppMethodBeat.i(262619);
          Log.i("MicroMsg.FaceAgreementUI", "click faceAgreementOtherVerifyTitle");
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("err_msg", "fail");
          paramAnonymousString.putExtra("err_code", 90114);
          paramAnonymousString.putExtra("click_other_verify_btn_front", "yes");
          com.tencent.mm.plugin.flash.c.b.VM(90114);
          FaceAgreementUI.this.setResult(1, paramAnonymousString);
          FaceAgreementUI.this.finish();
          AppMethodBeat.o(262619);
        }
      }), 0, paramBundle.length(), 17);
      this.Abc.setText(paramBundle);
      a(this.Abc, paramBundle);
    }
    for (;;)
    {
      setMMTitle("");
      setActionbarColor(getResources().getColor(a.b.white));
      getSupportActionBar().hide();
      this.AaY = ((ImageView)findViewById(a.e.face_agreement_cancel_btn));
      this.AaY.setOnClickListener(new FaceAgreementUI.3(this));
      this.mProgressDialog = k.a(getContext(), getContext().getString(a.i.loading_tips_1), false, null);
      com.tencent.mm.kernel.h.aZW().a(1108, this);
      int i = getIntent().getIntExtra("scene", 0);
      paramBundle = getIntent().getStringExtra("package");
      String str = getIntent().getStringExtra("packageSign");
      com.tencent.mm.kernel.h.aZW().a(new d(i, paramBundle, str), 0);
      ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.b.class)).jO(11, 6);
      AppMethodBeat.o(262653);
      return;
      this.Abc.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(262664);
    Log.i("MicroMsg.FaceAgreementUI", "onDestroy() ");
    super.onDestroy();
    if (this.Abe) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 63L, 1L, false);
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbm, false);
    Log.i("MicroMsg.FaceAgreementUI", "use new face action  %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      com.tencent.mm.plugin.flash.c.b.fuP().ivn = 2L;
      AppMethodBeat.o(262664);
      return;
    }
    com.tencent.mm.plugin.flash.c.b.fuP().ivn = 1L;
    AppMethodBeat.o(262664);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(262665);
    super.onResume();
    Log.i("MicroMsg.FaceAgreementUI", "onResume()");
    AppMethodBeat.o(262665);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(262655);
    Log.i("MicroMsg.FaceAgreementUI", "onSceneEnd()");
    com.tencent.mm.kernel.h.aZW().b(1108, this);
    com.tencent.mm.plugin.flash.c.b.fuP().ivp = paramInt2;
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262624);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FaceAgreementUI.d(FaceAgreementUI.this);
          int i = ((d)paramp).zZu.aasw;
          localObject = ((d)paramp).zZu.aasx;
          FaceAgreementUI.a(FaceAgreementUI.this, ((d)paramp).zZu.VHM);
          FaceAgreementUI.b(FaceAgreementUI.this, ((d)paramp).zZu.aasy);
          FaceAgreementUI.c(FaceAgreementUI.this, ((d)paramp).zZu.aasz);
          Log.i("MicroMsg.FaceAgreementUI", "[cgi-ret]contractRet:%s  tip:%s url:%s contractTitle:%s contractDesc:%s", new Object[] { Integer.valueOf(i), localObject, FaceAgreementUI.e(FaceAgreementUI.this), FaceAgreementUI.f(FaceAgreementUI.this), FaceAgreementUI.g(FaceAgreementUI.this) });
          if (i == 1)
          {
            FaceAgreementUI.a(FaceAgreementUI.this, false);
            FaceAgreementUI.h(FaceAgreementUI.this).setEnabled(true);
            if (!FaceAgreementUI.a(FaceAgreementUI.this)) {
              break label301;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 62L, 1L, false);
          }
          for (;;)
          {
            FaceAgreementUI.j(FaceAgreementUI.this).setText((CharSequence)localObject);
            AppMethodBeat.o(262624);
            return;
            if (TextUtils.isEmpty(FaceAgreementUI.e(FaceAgreementUI.this)))
            {
              FaceAgreementUI.a(FaceAgreementUI.this, false);
              FaceAgreementUI.i(FaceAgreementUI.this).setVisibility(4);
              FaceAgreementUI.h(FaceAgreementUI.this).setEnabled(true);
              break;
            }
            FaceAgreementUI.a(FaceAgreementUI.this, true);
            com.tencent.mm.plugin.facedetectaction.model.c.zZJ.zZS = true;
            break;
            label301:
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 61L, 1L, false);
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 72L, 1L, false);
        FaceAgreementUI.a(FaceAgreementUI.this, false);
        Log.e("MicroMsg.FaceAgreementUIError", "[cgi-ret]net ret error, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        FaceAgreementUI.d(FaceAgreementUI.this);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("err_msg", "fail");
        ((Intent)localObject).putExtra("err_code", 90110);
        com.tencent.mm.plugin.flash.c.b.VM(90110);
        FaceAgreementUI.this.setResult(1, (Intent)localObject);
        FaceAgreementUI.this.finish();
        AppMethodBeat.o(262624);
      }
    });
    AppMethodBeat.o(262655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(262652);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.flash.a.a.class);
    AppMethodBeat.o(262652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI
 * JD-Core Version:    0.7.0.1
 */