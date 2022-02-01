package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetectaction.a.c;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.j;
import java.util.List;

public class FaceAgreementUI
  extends MMActivity
  implements f
{
  private j kYr;
  private LinearLayout rqA;
  private TextView rqB;
  private String rqC = "";
  private TextView rqy;
  private Button rqz;
  
  private void a(final Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, TextView paramTextView)
  {
    AppMethodBeat.i(221168);
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = 0;
    while (i < paramList2.size())
    {
      String str = (String)paramList2.get(i);
      int j = paramString.indexOf(str);
      int k = j + str.length();
      if ((j >= 0) && (k <= paramString.length())) {
        localSpannableString.setSpan(new a((String)paramList1.get(i), aj.getContext().getResources().getColor(2131100547), aj.getContext().getResources().getColor(2131099658), new a.a()
        {
          public final void axC(String paramAnonymousString)
          {
            AppMethodBeat.i(221166);
            ad.i("MicroMsg.FaceAgreementUI", "click %s", new Object[] { paramAnonymousString });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(221166);
          }
        }), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText(localSpannableString);
    paramTextView.setOnTouchListener(new FaceAgreementUI.7(this, localSpannableString, paramTextView));
    AppMethodBeat.o(221168);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496387;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(213192);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(213192);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(213191);
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", l.DM(90024));
    localIntent.putExtra("err_msg", "user cancel in confirm ui");
    setResult(0, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(213191);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213189);
    super.onCreate(paramBundle);
    this.rqy = ((TextView)findViewById(2131308097));
    this.rqz = ((Button)findViewById(2131308102));
    this.rqA = ((LinearLayout)findViewById(2131308099));
    this.rqB = ((TextView)findViewById(2131308100));
    ((CheckBox)findViewById(2131308030)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213182);
        FaceAgreementUI.a(FaceAgreementUI.this).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(213182);
      }
    });
    this.rqz.setEnabled(false);
    this.rqz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213183);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = new Intent(FaceAgreementUI.this, FaceActionUI.class);
        localObject = FaceAgreementUI.this.getIntent().getExtras();
        if (localObject != null) {
          paramAnonymousView.putExtras((Bundle)localObject);
        }
        FaceAgreementUI.this.startActivityForResult(paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213183);
      }
    });
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(213184);
        FaceAgreementUI.b(FaceAgreementUI.this);
        AppMethodBeat.o(213184);
        return false;
      }
    });
    this.kYr = j.c(this, "", false);
    g.aiU().a(1108, this);
    int i = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("package");
    String str = getIntent().getStringExtra("packageSign");
    g.aiU().a(new c(i, paramBundle, str), 0);
    AppMethodBeat.o(213189);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(213190);
    g.aiU().b(1108, this);
    h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221165);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FaceAgreementUI.c(FaceAgreementUI.this);
          int i = ((c)paramn).rpi.Gyr;
          localObject = ((c)paramn).rpi.Gys;
          FaceAgreementUI.a(FaceAgreementUI.this, ((c)paramn).rpi.CYX);
          ad.i("MicroMsg.FaceAgreementUI", "[cgi-ret]contractRet:%s  tip:%s url:%s", new Object[] { Integer.valueOf(i), localObject, FaceAgreementUI.d(FaceAgreementUI.this) });
          if (i == 1) {
            FaceAgreementUI.a(FaceAgreementUI.this).setEnabled(true);
          }
          for (;;)
          {
            FaceAgreementUI.f(FaceAgreementUI.this).setText((CharSequence)localObject);
            AppMethodBeat.o(221165);
            return;
            if (TextUtils.isEmpty(FaceAgreementUI.d(FaceAgreementUI.this)))
            {
              FaceAgreementUI.e(FaceAgreementUI.this).setVisibility(4);
              FaceAgreementUI.a(FaceAgreementUI.this).setEnabled(true);
            }
            else
            {
              FaceAgreementUI.b(FaceAgreementUI.this, FaceAgreementUI.d(FaceAgreementUI.this));
              FaceAgreementUI.e(FaceAgreementUI.this).setVisibility(0);
              com.tencent.mm.plugin.facedetectaction.b.d.rpy.rpI = true;
            }
          }
        }
        ad.e("MicroMsg.FaceAgreementUIError", "[cgi-ret]net ret error, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        FaceAgreementUI.c(FaceAgreementUI.this);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("err_msg", "get contract error");
        ((Intent)localObject).putExtra("err_code", 90110);
        FaceAgreementUI.this.setResult(-1, (Intent)localObject);
        FaceAgreementUI.this.finish();
        AppMethodBeat.o(221165);
      }
    });
    AppMethodBeat.o(213190);
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