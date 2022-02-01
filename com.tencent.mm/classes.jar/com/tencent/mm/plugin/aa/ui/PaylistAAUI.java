package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p.a;
import com.tencent.mm.plugin.aa.model.b.f;
import com.tencent.mm.plugin.aa.model.b.g.c;
import com.tencent.mm.plugin.aa.model.b.g.d;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.z;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private static int iEG = 1;
  private static int iEH = 2;
  private static int iEI = 3;
  private static int iEJ = 4;
  private String dbJ;
  private String dsw;
  private Dialog iBB;
  private Dialog iBT;
  private View iCB;
  private String iEA;
  private String iEB;
  private String iEC;
  private int iED;
  private String iEE;
  private long iEF;
  private com.tencent.mm.plugin.aa.model.b.g iEp;
  private f iEq;
  private LinearLayout iEr;
  private LinearLayout iEs;
  private LinearLayout iEt;
  private WalletTextView iEu;
  private Button iEv;
  private TextView iEw;
  private TextView iEx;
  private TextView iEy;
  private TextView iEz;
  private String title;
  
  public PaylistAAUI()
  {
    AppMethodBeat.i(63734);
    this.iEp = ((com.tencent.mm.plugin.aa.model.b.g)am(com.tencent.mm.plugin.aa.model.b.g.class));
    this.iEq = ((f)aq(f.class));
    this.iBT = null;
    this.iBB = null;
    AppMethodBeat.o(63734);
  }
  
  private static boolean M(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == com.tencent.mm.plugin.aa.model.a.iyW) && (paramInt2 != com.tencent.mm.plugin.aa.model.a.iza) && (paramInt3 == com.tencent.mm.plugin.aa.model.a.iyS);
  }
  
  private void a(LinearLayout paramLinearLayout, com.tencent.mm.protocal.protobuf.u paramu)
  {
    AppMethodBeat.i(63740);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131495064, paramLinearLayout, false);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131303176);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131303177);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131303178);
    a.b.c(localImageView, paramu.DKT);
    localTextView1.setText(k.b(getContext(), this.iEq.wk(paramu.DKT), localTextView1.getTextSize()));
    if (paramu.DKV == com.tencent.mm.plugin.aa.model.a.izd)
    {
      localTextView2.setText(getString(2131761855, new Object[] { Double.valueOf(i.n(paramu.DKN)) }));
      localTextView2.setTextColor(getResources().getColor(2131100730));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(63740);
      return;
    }
    if (paramu.DKV == com.tencent.mm.plugin.aa.model.a.izc)
    {
      localTextView2.setText(getString(2131761844, new Object[] { Double.valueOf(i.n(paramu.DKN)) }));
      localTextView2.setTextColor(getResources().getColor(2131100732));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(63740);
      return;
    }
    localTextView2.setVisibility(8);
    paramLinearLayout.addView(localLinearLayout);
    AppMethodBeat.o(63740);
  }
  
  private void a(List<com.tencent.mm.protocal.protobuf.u> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63738);
    ((TextView)findViewById(2131303183)).setText(paramString);
    paramString = this.iEy;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      paramString = (LinearLayout)findViewById(2131303184);
      paramString.removeAllViews();
      i = 0;
      while (i < paramList.size())
      {
        com.tencent.mm.protocal.protobuf.u localu = (com.tencent.mm.protocal.protobuf.u)paramList.get(i);
        paramList.size();
        a(paramString, localu);
        i += 1;
      }
    }
    AppMethodBeat.o(63738);
  }
  
  private void aOA()
  {
    AppMethodBeat.i(63736);
    this.iBT = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    this.iCB.setVisibility(4);
    this.iEp.iBk.aOa().f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void cc(Object paramAnonymousObject)
      {
        AppMethodBeat.i(63719);
        ac.i("MicroMsg.Aa.PaylistAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
        PaylistAAUI localPaylistAAUI = PaylistAAUI.this;
        if (paramAnonymousObject == null) {}
        for (paramAnonymousObject = "";; paramAnonymousObject = paramAnonymousObject.toString())
        {
          PaylistAAUI.a(localPaylistAAUI, paramAnonymousObject);
          AppMethodBeat.o(63719);
          return;
        }
      }
    });
    AppMethodBeat.o(63736);
  }
  
  private void e(List<com.tencent.mm.protocal.protobuf.u> paramList, String paramString)
  {
    AppMethodBeat.i(63739);
    ((TextView)findViewById(2131303166)).setText(paramString);
    paramString = (LinearLayout)findViewById(2131303167);
    paramString.removeAllViews();
    int i = 0;
    while (i < paramList.size())
    {
      com.tencent.mm.protocal.protobuf.u localu = (com.tencent.mm.protocal.protobuf.u)paramList.get(i);
      paramList.size();
      a(paramString, localu);
      i += 1;
    }
    AppMethodBeat.o(63739);
  }
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(63742);
    if (paramInt == -1)
    {
      ac.i("MicroMsg.Aa.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.dsw });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        ac.i("MicroMsg.Aa.PaylistAAUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.br.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      i.FP(this.iEB);
      finish();
      this.iEp.iBm.x(this.dsw, this.iEC, this.iEE).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.iEp.iBn.b(this.iEF, this.dbJ, paramIntent);
    }
    AppMethodBeat.o(63742);
  }
  
  public int getLayoutId()
  {
    return 2131495065;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(63743);
    if ((this.iBT != null) && (this.iBT.isShowing()))
    {
      this.iBT.dismiss();
      this.iBT = null;
    }
    AppMethodBeat.o(63743);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63741);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      b(paramInt2, paramIntent);
      AppMethodBeat.o(63741);
      return;
    }
    if ((paramInt1 == 222) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      ac.i("MicroMsg.Aa.PaylistAAUI", "select chatroom：%s", new Object[] { paramIntent });
      if (!bs.isNullOrNil(paramIntent))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 3);
        localIntent.putExtra("chatroom_name", paramIntent);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(63741);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63735);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63709);
        PaylistAAUI.this.finish();
        AppMethodBeat.o(63709);
        return false;
      }
    });
    setMMTitle(2131760665);
    hideActionbarLine();
    this.iEB = getIntent().getStringExtra("chatroom");
    this.iEr = ((LinearLayout)findViewById(2131303179));
    this.iEs = ((LinearLayout)findViewById(2131303172));
    this.iEt = ((LinearLayout)findViewById(2131303165));
    this.iEw = ((TextView)findViewById(2131303180));
    this.iEx = ((TextView)findViewById(2131303169));
    this.iCB = findViewById(2131304241);
    this.iEy = ((TextView)findViewById(2131303182));
    this.iEy.setClickable(true);
    this.iEy.setOnTouchListener(new n(this));
    paramBundle = new SpannableStringBuilder(getString(2131761858));
    paramBundle.setSpan(new a(new a.a()
    {
      public final void aOb()
      {
        AppMethodBeat.i(63718);
        if (!com.tencent.mm.model.w.sQ(PaylistAAUI.a(PaylistAAUI.this))) {}
        for (int i = 2131764596;; i = 2131764595)
        {
          f.a locala = new f.a(PaylistAAUI.this);
          locala.av(PaylistAAUI.this.getString(2131764597));
          View localView = z.jD(PaylistAAUI.this).inflate(2131495820, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131300914);
          TextView localTextView = (TextView)localView.findViewById(2131305710);
          localImageView.setImageResource(2131233574);
          localTextView.setText(i);
          locala.gK(localView);
          locala.acQ(2131755884);
          locala.aRV(PaylistAAUI.this.getString(2131755691));
          locala.JfY = false;
          locala.a(new f.c()new f.c
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
          }, new f.c()
          {
            public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(63717);
              PaylistAAUI.b(PaylistAAUI.this);
              AppMethodBeat.o(63717);
            }
          });
          locala.show();
          com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7) });
          AppMethodBeat.o(63718);
          return;
        }
      }
    }), 0, paramBundle.length(), 18);
    this.iEy.setText(paramBundle);
    this.iEz = ((TextView)findViewById(2131303168));
    aOA();
    AppMethodBeat.o(63735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63737);
    super.onDestroy();
    AppMethodBeat.o(63737);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */