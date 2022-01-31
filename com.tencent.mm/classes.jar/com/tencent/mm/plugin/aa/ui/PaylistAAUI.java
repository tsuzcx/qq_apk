package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.aa.a.c.g.d;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

public class PaylistAAUI
  extends BaseAAPresenterActivity
{
  private String bHZ;
  private String bWv;
  private Dialog eXA = null;
  private View eYe;
  private WalletTextView eZA;
  private Button eZB;
  private TextView eZC;
  private TextView eZD;
  private TextView eZE;
  private TextView eZF;
  private String eZG;
  private String eZH;
  private String eZI;
  private int eZJ;
  private String eZK;
  private long eZL;
  private com.tencent.mm.plugin.aa.a.c.g eZv = (com.tencent.mm.plugin.aa.a.c.g)z(com.tencent.mm.plugin.aa.a.c.g.class);
  private com.tencent.mm.plugin.aa.a.c.f eZw = (com.tencent.mm.plugin.aa.a.c.f)C(com.tencent.mm.plugin.aa.a.c.f.class);
  private LinearLayout eZx;
  private LinearLayout eZy;
  private LinearLayout eZz;
  private String title;
  
  private void VR()
  {
    this.eXA = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
    this.eYe.setVisibility(4);
    g.d locald = this.eZv.eXf;
    com.tencent.mm.vending.g.f.cLb().c(locald).f(new PaylistAAUI.10(this)).a(new PaylistAAUI.9(this));
  }
  
  private void a(LinearLayout paramLinearLayout, t paramt, boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(a.g.paylist_aa_memeber_item, paramLinearLayout, false);
    Object localObject1 = (ImageView)localLinearLayout.findViewById(a.f.paylist_aa_member_avatar_iv);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.f.paylist_aa_member_name_tv);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.f.paylist_aa_member_pay_state_tv);
    Object localObject2 = localLinearLayout.findViewById(a.f.divider);
    if (paramBoolean) {
      ((View)localObject2).setVisibility(8);
    }
    for (;;)
    {
      a.b.a((ImageView)localObject1, paramt.srM);
      localObject1 = this.mController.uMN;
      Object localObject3 = this.eZw;
      localObject2 = paramt.srM;
      localObject3 = ((com.tencent.mm.vending.app.a)localObject3).wsQ.getStringExtra("chatroom");
      localTextView1.setText(j.a((Context)localObject1, ((b)com.tencent.mm.kernel.g.r(b.class)).getDisplayName((String)localObject2, (String)localObject3), localTextView1.getTextSize()));
      if (paramt.srO != com.tencent.mm.plugin.aa.a.a.eVx) {
        break;
      }
      localTextView2.setText(getString(a.i.paylist_aa_paid_money_title, new Object[] { Double.valueOf(paramt.srz / 100.0D) }));
      localTextView2.setTextColor(getResources().getColor(a.c.paylist_done_receipt_text_color));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      return;
      ((View)localObject2).setVisibility(0);
    }
    if (paramt.srO == com.tencent.mm.plugin.aa.a.a.eVw)
    {
      localTextView2.setText(getString(a.i.paylist_aa_by_person_member_unpaid_title, new Object[] { Double.valueOf(paramt.srz / 100.0D) }));
      localTextView2.setTextColor(getResources().getColor(a.c.paylist_unreceipt_text_color));
      localTextView2.setVisibility(0);
      paramLinearLayout.addView(localLinearLayout);
      return;
    }
    localTextView2.setVisibility(8);
    paramLinearLayout.addView(localLinearLayout);
  }
  
  private void a(List<t> paramList, String paramString, boolean paramBoolean)
  {
    ((TextView)findViewById(a.f.paylist_aa_top_member_hint_tv)).setText(paramString);
    paramString = this.eZE;
    int i;
    label50:
    t localt;
    if (paramBoolean)
    {
      i = 0;
      paramString.setVisibility(i);
      paramString = (LinearLayout)findViewById(a.f.paylist_aa_top_member_layout);
      paramString.removeAllViews();
      i = 0;
      if (i >= paramList.size()) {
        return;
      }
      localt = (t)paramList.get(i);
      if (i < paramList.size() - 1) {
        break label113;
      }
    }
    label113:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramString, localt, paramBoolean);
      i += 1;
      break label50;
      i = 8;
      break;
    }
  }
  
  private void d(List<t> paramList, String paramString)
  {
    ((TextView)findViewById(a.f.paylist_aa_bottom_member_hint_tv)).setText(paramString);
    paramString = (LinearLayout)findViewById(a.f.paylist_aa_bottom_member_layout);
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
  }
  
  private static boolean y(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == com.tencent.mm.plugin.aa.a.a.eVq) && (paramInt2 != com.tencent.mm.plugin.aa.a.a.eVu) && (paramInt3 == com.tencent.mm.plugin.aa.a.a.eVm);
  }
  
  protected final int getLayoutId()
  {
    return a.g.paylist_aa_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 233) {
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", new Object[] { this.bWv });
        localObject = (RealnameGuideHelper)paramIntent.getParcelableExtra("key_realname_guide_helper");
        if (localObject != null)
        {
          y.i("MicroMsg.PaylistAAUI", "do realname guide");
          Intent localIntent = new Intent();
          localIntent.putExtra("key_realname_guide_helper", (Parcelable)localObject);
          d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", localIntent);
        }
        com.tencent.mm.plugin.aa.a.h.pt(this.eZH);
        finish();
        localObject = this.eZv.eXh;
        com.tencent.mm.vending.g.f.c(this.bWv, this.eZI, this.eZK).c((com.tencent.mm.vending.c.a)localObject).f(new PaylistAAUI.7(this));
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 12L, 1L, false);
        paramIntent = paramIntent.getStringExtra("key_trans_id");
        localObject = this.eZv.eXi;
      }
    }
    do
    {
      com.tencent.mm.vending.g.f.c(Long.valueOf(this.eZL), this.bHZ, paramIntent).c((com.tencent.mm.vending.c.a)localObject);
      do
      {
        return;
      } while ((paramInt1 != 222) || (paramInt2 != -1));
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      y.i("MicroMsg.PaylistAAUI", "select chatroom：%s", new Object[] { paramIntent });
    } while (bk.bl(paramIntent));
    Object localObject = new Intent(this.mController.uMN, LaunchAAUI.class);
    ((Intent)localObject).putExtra("enter_scene", 3);
    ((Intent)localObject).putExtra("chatroom_name", paramIntent);
    startActivity((Intent)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        PaylistAAUI.this.finish();
        return false;
      }
    });
    setMMTitle(a.i.launch_aa_title);
    this.eZH = getIntent().getStringExtra("chatroom");
    this.eZx = ((LinearLayout)findViewById(a.f.paylist_aa_pay_info_layout));
    this.eZy = ((LinearLayout)findViewById(a.f.paylist_aa_instant_pay_layout));
    this.eZz = ((LinearLayout)findViewById(a.f.paylist_aa_bottom_layout));
    this.eZC = ((TextView)findViewById(a.f.paylist_aa_pay_info_msg_tv));
    this.eZD = ((TextView)findViewById(a.f.paylist_aa_close_info_msg_tv));
    this.eYe = findViewById(a.f.root_container);
    this.eZE = ((TextView)findViewById(a.f.paylist_aa_send_tip_tv));
    this.eZE.setClickable(true);
    this.eZE.setOnTouchListener(new m(this));
    paramBundle = new SpannableStringBuilder(getString(a.i.paylist_aa_recevier_send_tip_title));
    paramBundle.setSpan(new a(new PaylistAAUI.8(this)), 0, paramBundle.length(), 18);
    this.eZE.setText(paramBundle);
    this.eZF = ((TextView)findViewById(a.f.paylist_aa_bottom_tip_tv));
    VR();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI
 * JD-Core Version:    0.7.0.1
 */