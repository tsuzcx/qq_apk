package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g.c;
import com.tencent.mm.plugin.aa.a.c.g.d;
import com.tencent.mm.plugin.aa.a.c.g.e;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private String cEi;
  private String cpq;
  private Dialog gpx;
  private View gqb;
  private String grA;
  private String grB;
  private int grC;
  private String grD;
  private long grE;
  private com.tencent.mm.plugin.aa.a.c.g gro;
  private f grp;
  private LinearLayout grq;
  private LinearLayout grr;
  private LinearLayout grs;
  private WalletTextView grt;
  private Button gru;
  private TextView grv;
  private TextView grw;
  private TextView grx;
  private TextView gry;
  private String grz;
  private String title;
  
  public PaylistAAUI()
  {
    AppMethodBeat.i(40885);
    this.gro = ((com.tencent.mm.plugin.aa.a.c.g)P(com.tencent.mm.plugin.aa.a.c.g.class));
    this.grp = ((f)T(f.class));
    this.gpx = null;
    AppMethodBeat.o(40885);
  }
  
  private static boolean K(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == com.tencent.mm.plugin.aa.a.a.gnn) && (paramInt2 != com.tencent.mm.plugin.aa.a.a.gnr) && (paramInt3 == com.tencent.mm.plugin.aa.a.a.gnj);
  }
  
  private void a(LinearLayout paramLinearLayout, t paramt, boolean paramBoolean)
  {
    AppMethodBeat.i(40891);
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2130970400, paramLinearLayout, false);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131826649);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131826650);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131826651);
    View localView = localLinearLayout.findViewById(2131821148);
    if (paramBoolean) {
      localView.setVisibility(8);
    }
    for (;;)
    {
      a.b.c(localImageView, paramt.wks);
      localTextView1.setText(j.b(getContext(), this.grp.nE(paramt.wks), localTextView1.getTextSize()));
      if (paramt.wku != com.tencent.mm.plugin.aa.a.a.gnu) {
        break;
      }
      localTextView2.setText(getString(2131302062, new Object[] { Double.valueOf(paramt.wkf / 100.0D) }));
      localTextView2.setTextColor(getResources().getColor(2131690338));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(40891);
      return;
      localView.setVisibility(0);
    }
    if (paramt.wku == com.tencent.mm.plugin.aa.a.a.gnt)
    {
      localTextView2.setText(getString(2131302052, new Object[] { Double.valueOf(paramt.wkf / 100.0D) }));
      localTextView2.setTextColor(getResources().getColor(2131690340));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      AppMethodBeat.o(40891);
      return;
    }
    localTextView2.setVisibility(8);
    paramLinearLayout.addView(localLinearLayout);
    AppMethodBeat.o(40891);
  }
  
  private void a(List<t> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(40889);
    ((TextView)findViewById(2131826663)).setText(paramString);
    paramString = this.grx;
    int i;
    label56:
    t localt;
    if (paramBoolean)
    {
      i = 0;
      paramString.setVisibility(i);
      paramString = (LinearLayout)findViewById(2131826665);
      paramString.removeAllViews();
      i = 0;
      if (i >= paramList.size()) {
        break label124;
      }
      localt = (t)paramList.get(i);
      if (i < paramList.size() - 1) {
        break label119;
      }
    }
    label119:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramString, localt, paramBoolean);
      i += 1;
      break label56;
      i = 8;
      break;
    }
    label124:
    AppMethodBeat.o(40889);
  }
  
  private void apn()
  {
    AppMethodBeat.i(40887);
    this.gpx = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    this.gqb.setVisibility(4);
    this.gro.gpd.aoV().f(new PaylistAAUI.10(this)).a(new PaylistAAUI.9(this));
    AppMethodBeat.o(40887);
  }
  
  private void e(List<t> paramList, String paramString)
  {
    AppMethodBeat.i(40890);
    ((TextView)findViewById(2131826667)).setText(paramString);
    paramString = (LinearLayout)findViewById(2131826668);
    paramString.removeAllViews();
    int i = 0;
    if (i < paramList.size())
    {
      t localt = (t)paramList.get(i);
      if (i >= paramList.size() - 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramString, localt, bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(40890);
  }
  
  public final void c(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(141976);
    if (paramInt == -1)
    {
      ab.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.cEi });
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
      if (localRealnameGuideHelper != null)
      {
        ab.i("MicroMsg.PaylistAAUI", "do realname guide");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_realname_guide_helper", localRealnameGuideHelper);
        d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
      }
      com.tencent.mm.plugin.aa.a.h.wH(this.grA);
      finish();
      this.gro.gpf.y(this.cEi, this.grB, this.grD).f(new PaylistAAUI.7(this));
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 12L, 1L, false);
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      this.gro.gpg.a(this.grE, this.cpq, paramIntent);
    }
    AppMethodBeat.o(141976);
  }
  
  public int getLayoutId()
  {
    return 2130970401;
  }
  
  public void hideLoading()
  {
    AppMethodBeat.i(141977);
    if ((this.gpx != null) && (this.gpx.isShowing()))
    {
      this.gpx.dismiss();
      this.gpx = null;
    }
    AppMethodBeat.o(141977);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40892);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233)
    {
      c(paramInt2, paramIntent);
      AppMethodBeat.o(40892);
      return;
    }
    if ((paramInt1 == 222) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      ab.i("MicroMsg.PaylistAAUI", "select chatroom：%s", new Object[] { paramIntent });
      if (!bo.isNullOrNil(paramIntent))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 3);
        localIntent.putExtra("chatroom_name", paramIntent);
        startActivity(localIntent);
      }
    }
    AppMethodBeat.o(40892);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40886);
    super.onCreate(paramBundle);
    setBackBtn(new PaylistAAUI.1(this));
    setMMTitle(2131301049);
    this.grA = getIntent().getStringExtra("chatroom");
    this.grq = ((LinearLayout)findViewById(2131826655));
    this.grr = ((LinearLayout)findViewById(2131826658));
    this.grs = ((LinearLayout)findViewById(2131826666));
    this.grv = ((TextView)findViewById(2131826656));
    this.grw = ((TextView)findViewById(2131826657));
    this.gqb = findViewById(2131823717);
    this.grx = ((TextView)findViewById(2131826664));
    this.grx.setClickable(true);
    this.grx.setOnTouchListener(new m(this));
    paramBundle = new SpannableStringBuilder(getString(2131302065));
    paramBundle.setSpan(new a(new PaylistAAUI.8(this)), 0, paramBundle.length(), 18);
    this.grx.setText(paramBundle);
    this.gry = ((TextView)findViewById(2131826670));
    apn();
    AppMethodBeat.o(40886);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(40888);
    super.onDestroy();
    AppMethodBeat.o(40888);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */