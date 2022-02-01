package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.plugin.aa.model.b.f;
import com.tencent.mm.plugin.aa.model.b.g.c;
import com.tencent.mm.plugin.aa.model.b.g.d;
import com.tencent.mm.plugin.aa.model.b.g.e;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.y;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private static int ieA = 4;
  private static int iex = 1;
  private static int iey = 2;
  private static int iez = 3;
  private String den;
  private String duK;
  private Dialog ibM;
  private Dialog iby;
  private View ics;
  private com.tencent.mm.plugin.aa.model.b.g ieg;
  private f ieh;
  private LinearLayout iei;
  private LinearLayout iej;
  private LinearLayout iek;
  private WalletTextView iel;
  private Button iem;
  private TextView ien;
  private TextView ieo;
  private TextView iep;
  private TextView ieq;
  private String ier;
  private String ies;
  private String iet;
  private int ieu;
  private String iev;
  private long iew;
  private String title;
  
  public PaylistAAUI()
  {
    AppMethodBeat.i(63734);
    this.ieg = ((com.tencent.mm.plugin.aa.model.b.g)am(com.tencent.mm.plugin.aa.model.b.g.class));
    this.ieh = ((f)aq(f.class));
    this.ibM = null;
    this.iby = null;
    AppMethodBeat.o(63734);
  }
  
  private static boolean L(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == com.tencent.mm.plugin.aa.model.a.hYS) && (paramInt2 != com.tencent.mm.plugin.aa.model.a.hYW) && (paramInt3 == com.tencent.mm.plugin.aa.model.a.hYO);
  }
  
  private void a(LinearLayout paramLinearLayout, com.tencent.mm.protocal.protobuf.u paramu)
  {
    AppMethodBeat.i(63740);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131495064, paramLinearLayout, false);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131303176);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131303177);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131303178);
    a.b.c(localImageView, paramu.CsC);
    localTextView1.setText(k.b(getContext(), this.ieh.sh(paramu.CsC), localTextView1.getTextSize()));
    if (paramu.CsE == com.tencent.mm.plugin.aa.model.a.hYZ)
    {
      localTextView2.setText(getString(2131761855, new Object[] { Double.valueOf(i.o(paramu.Csv)) }));
      localTextView2.setTextColor(getResources().getColor(2131100730));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(63740);
      return;
    }
    if (paramu.CsE == com.tencent.mm.plugin.aa.model.a.hYY)
    {
      localTextView2.setText(getString(2131761844, new Object[] { Double.valueOf(i.o(paramu.Csv)) }));
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
    paramString = this.iep;
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
  
  private void aHJ()
  {
    AppMethodBeat.i(63736);
    this.ibM = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    this.ics.setVisibility(4);
    this.ieg.ibh.aHm().f(new com.tencent.mm.vending.c.a() {}).a(new com.tencent.mm.vending.g.d.a()
    {
      public final void ce(Object paramAnonymousObject)
      {
        AppMethodBeat.i(63719);
        ad.i("MicroMsg.Aa.PaylistAAUI", "onInterrupt: %s", new Object[] { paramAnonymousObject });
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
      ad.i("MicroMsg.Aa.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.duK });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        ad.i("MicroMsg.Aa.PaylistAAUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        com.tencent.mm.bs.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      i.BM(this.ies);
      finish();
      this.ieg.ibj.x(this.duK, this.iet, this.iev).f(new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.ieg.ibk.a(this.iew, this.den, paramIntent);
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
    if ((this.ibM != null) && (this.ibM.isShowing()))
    {
      this.ibM.dismiss();
      this.ibM = null;
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
      ad.i("MicroMsg.Aa.PaylistAAUI", "select chatroom：%s", new Object[] { paramIntent });
      if (!bt.isNullOrNil(paramIntent))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 3);
        localIntent.putExtra("chatroom_name", paramIntent);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/aa/ui/PaylistAAUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.lS(0));
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
    this.ies = getIntent().getStringExtra("chatroom");
    this.iei = ((LinearLayout)findViewById(2131303179));
    this.iej = ((LinearLayout)findViewById(2131303172));
    this.iek = ((LinearLayout)findViewById(2131303165));
    this.ien = ((TextView)findViewById(2131303180));
    this.ieo = ((TextView)findViewById(2131303169));
    this.ics = findViewById(2131304241);
    this.iep = ((TextView)findViewById(2131303182));
    this.iep.setClickable(true);
    this.iep.setOnTouchListener(new n(this));
    paramBundle = new SpannableStringBuilder(getString(2131761858));
    paramBundle.setSpan(new a(new a.a()
    {
      public final void aHn()
      {
        AppMethodBeat.i(63718);
        if (!com.tencent.mm.model.w.pF(PaylistAAUI.a(PaylistAAUI.this))) {}
        for (int i = 2131764596;; i = 2131764595)
        {
          f.a locala = new f.a(PaylistAAUI.this);
          locala.au(PaylistAAUI.this.getString(2131764597));
          View localView = y.js(PaylistAAUI.this).inflate(2131495820, null);
          ImageView localImageView = (ImageView)localView.findViewById(2131300914);
          TextView localTextView = (TextView)localView.findViewById(2131305710);
          localImageView.setImageResource(2131233574);
          localTextView.setText(i);
          locala.gu(localView);
          locala.aaF(2131755884);
          locala.aMt(PaylistAAUI.this.getString(2131755691));
          locala.HFB = false;
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
          com.tencent.mm.plugin.report.service.h.vKh.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7) });
          AppMethodBeat.o(63718);
          return;
        }
      }
    }), 0, paramBundle.length(), 18);
    this.iep.setText(paramBundle);
    this.ieq = ((TextView)findViewById(2131303168));
    aHJ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */