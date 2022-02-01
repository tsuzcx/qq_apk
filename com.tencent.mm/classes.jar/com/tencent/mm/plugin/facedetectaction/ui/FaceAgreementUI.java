package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetectaction.a.c;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.List;

public class FaceAgreementUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private Dialog mProgressDialog = null;
  private com.tencent.mm.ui.widget.a.g qAx;
  private TextView sYH;
  private Button sYI;
  private LinearLayout sYJ;
  private TextView sYK;
  private TextView sYL;
  private TextView sYM;
  private ImageView sYN;
  private String sYO = "";
  private boolean sYP = false;
  private boolean sYQ = false;
  
  private void a(Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, TextView paramTextView)
  {
    AppMethodBeat.i(186410);
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = 0;
    while (i < paramList2.size())
    {
      String str = (String)paramList2.get(i);
      int j = paramString.indexOf(str);
      int k = j + str.length();
      if ((j >= 0) && (k <= paramString.length())) {
        localSpannableString.setSpan(new a((String)paramList1.get(i), MMApplicationContext.getContext().getResources().getColor(2131100685), MMApplicationContext.getContext().getResources().getColor(2131099660), new FaceAgreementUI.5(this, paramContext)), j, k, 17);
      }
      i += 1;
    }
    if (paramTextView != null)
    {
      paramTextView.setText(localSpannableString);
      paramTextView.setOnTouchListener(new FaceAgreementUI.6(this, localSpannableString, paramTextView));
    }
    AppMethodBeat.o(186410);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494063;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(186409);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(186409);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(186408);
    Log.i("MicroMsg.FaceAgreementUI", "onBackPressed()");
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.flash.c.b.MX(l.HL(90024));
    localIntent.putExtra("err_code", l.HL(90024));
    localIntent.putExtra("err_msg", "cancel");
    setResult(0, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(186408);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186406);
    super.onCreate(paramBundle);
    this.sYH = ((TextView)findViewById(2131300300));
    this.sYI = ((Button)findViewById(2131300307));
    this.sYJ = ((LinearLayout)findViewById(2131300304));
    this.sYK = ((TextView)findViewById(2131300305));
    this.sYL = ((TextView)findViewById(2131300306));
    ao.a(this.sYL.getPaint(), 0.8F);
    this.sYI.setEnabled(true);
    this.sYI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186398);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.FaceAgreementUI", "needShowProtocal : %s", new Object[] { Boolean.valueOf(FaceAgreementUI.a(FaceAgreementUI.this)) });
        if (FaceAgreementUI.a(FaceAgreementUI.this)) {
          FaceAgreementUI.b(FaceAgreementUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186398);
          return;
          paramAnonymousView = new Intent(FaceAgreementUI.this, FaceFlashPermissionUI.class);
          localObject = FaceAgreementUI.this.getIntent().getExtras();
          if (localObject != null) {
            paramAnonymousView.putExtras((Bundle)localObject);
          }
          FaceAgreementUI.this.startActivityForResult(paramAnonymousView, 1);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(917L, 67L, 1L, false);
        }
      }
    });
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    getSupportActionBar().hide();
    this.sYN = ((ImageView)findViewById(2131300299));
    this.sYN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186399);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FaceAgreementUI.c(FaceAgreementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186399);
      }
    });
    this.mProgressDialog = com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(2131762447), false, null);
    com.tencent.mm.kernel.g.azz().a(1108, this);
    int i = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("package");
    String str = getIntent().getStringExtra("packageSign");
    com.tencent.mm.kernel.g.azz().a(new c(i, paramBundle, str), 0);
    AppMethodBeat.o(186406);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186411);
    super.onDestroy();
    if (this.sYQ) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(917L, 63L, 1L, false);
    }
    AppMethodBeat.o(186411);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(186407);
    com.tencent.mm.kernel.g.azz().b(1108, this);
    com.tencent.mm.plugin.flash.c.b.dLj().eqS = paramInt2;
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186400);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FaceAgreementUI.d(FaceAgreementUI.this);
          int i = ((c)paramq).sXj.LVW;
          localObject = ((c)paramq).sXj.LVX;
          FaceAgreementUI.a(FaceAgreementUI.this, ((c)paramq).sXj.HZQ);
          Log.i("MicroMsg.FaceAgreementUI", "[cgi-ret]contractRet:%s  tip:%s url:%s", new Object[] { Integer.valueOf(i), localObject, FaceAgreementUI.e(FaceAgreementUI.this) });
          if (i == 1)
          {
            FaceAgreementUI.a(FaceAgreementUI.this, false);
            FaceAgreementUI.f(FaceAgreementUI.this).setEnabled(true);
            if (!FaceAgreementUI.a(FaceAgreementUI.this)) {
              break label239;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(917L, 62L, 1L, false);
          }
          for (;;)
          {
            FaceAgreementUI.h(FaceAgreementUI.this).setText((CharSequence)localObject);
            AppMethodBeat.o(186400);
            return;
            if (TextUtils.isEmpty(FaceAgreementUI.e(FaceAgreementUI.this)))
            {
              FaceAgreementUI.a(FaceAgreementUI.this, false);
              FaceAgreementUI.g(FaceAgreementUI.this).setVisibility(4);
              FaceAgreementUI.f(FaceAgreementUI.this).setEnabled(true);
              break;
            }
            FaceAgreementUI.a(FaceAgreementUI.this, true);
            d.sXz.sXI = true;
            break;
            label239:
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(917L, 61L, 1L, false);
          }
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(917L, 72L, 1L, false);
        FaceAgreementUI.a(FaceAgreementUI.this, false);
        Log.e("MicroMsg.FaceAgreementUIError", "[cgi-ret]net ret error, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        FaceAgreementUI.d(FaceAgreementUI.this);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("err_msg", "fail");
        ((Intent)localObject).putExtra("err_code", 90110);
        com.tencent.mm.plugin.flash.c.b.MX(90110);
        FaceAgreementUI.this.setResult(1, (Intent)localObject);
        FaceAgreementUI.this.finish();
        AppMethodBeat.o(186400);
      }
    });
    AppMethodBeat.o(186407);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI
 * JD-Core Version:    0.7.0.1
 */