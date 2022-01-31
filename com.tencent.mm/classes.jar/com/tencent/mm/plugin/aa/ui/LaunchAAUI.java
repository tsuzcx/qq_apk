package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LaunchAAUI
  extends BaseAAPresenterActivity
{
  private String chatroomName = null;
  private Dialog eXA;
  private TextView eXt;
  private boolean eYD = false;
  private com.tencent.mm.plugin.aa.a.c.e eYT = (com.tencent.mm.plugin.aa.a.c.e)z(com.tencent.mm.plugin.aa.a.c.e.class);
  private boolean eYU = false;
  private MMEditText eYV;
  private TextView eYW;
  private TextView eYX;
  private TextView eYY;
  private TextView eYZ;
  private WalletFormView eZa;
  private TextView eZb;
  private TextView eZc;
  private ViewGroup eZd;
  private ViewGroup eZe;
  private List<String> eZf = new ArrayList();
  private ViewGroup eZg;
  private ViewGroup eZh;
  private TextView eZi;
  private ViewGroup eZj;
  private Map<String, Double> eZk = new HashMap();
  private Map<String, LaunchAAByPersonNameAmountRow> eZl = new HashMap();
  private Button eZm;
  private TextView eZn;
  private TextView eZo;
  private d eZp = new d();
  private int eZq = 0;
  private int eZr = 0;
  private boolean eZs = false;
  private int mode = com.tencent.mm.plugin.aa.a.a.eVh;
  private long timestamp = 0L;
  
  private void VL()
  {
    if (this.mode == com.tencent.mm.plugin.aa.a.a.eVh)
    {
      str1 = getString(a.i.launch_aa_by_money_title_1);
      str2 = getString(a.i.launch_aa_by_money_title_2);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new LaunchAAUI.2(this)), str1.length(), localSpannableStringBuilder.length(), 18);
      this.eYY.setText(localSpannableStringBuilder);
    }
    while (this.mode != com.tencent.mm.plugin.aa.a.a.eVi) {
      return;
    }
    String str1 = getString(a.i.launch_aa_by_person_title_1);
    String str2 = getString(a.i.launch_aa_by_person_title_2);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
    localSpannableStringBuilder.append(str1);
    localSpannableStringBuilder.append(str2);
    localSpannableStringBuilder.setSpan(new a(new LaunchAAUI.3(this)), str1.length(), localSpannableStringBuilder.length(), 18);
    this.eYY.setText(localSpannableStringBuilder);
  }
  
  private void VM()
  {
    this.eZs = false;
    if (this.eZn.getVisibility() != 8)
    {
      this.eZn.startAnimation(AnimationUtils.loadAnimation(this, a.a.out_to_up));
      this.eZn.setVisibility(8);
    }
  }
  
  private void VN()
  {
    if (this.mode == com.tencent.mm.plugin.aa.a.a.eVh)
    {
      if (bk.bl(this.eZa.getText()))
      {
        cp(false);
        return;
      }
      if (this.eYD)
      {
        cp(false);
        return;
      }
      if ((this.eZf == null) || (this.eZf.size() == 0))
      {
        cp(false);
        return;
      }
      if ((this.eZf.size() > d.Vo()) || (this.eYU))
      {
        cp(false);
        return;
      }
      double d = com.tencent.mm.plugin.aa.a.h.a(this.eZa.getText(), this.eZf.size(), 5, 4);
      y.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.eZa.getText(), Integer.valueOf(this.eZf.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        y.i("MicroMsg.LaunchAAUI", "less than 0.01");
        cp(false);
      }
    }
    else
    {
      if ((this.eZk == null) || (this.eZk.size() == 0))
      {
        cp(false);
        return;
      }
      if ((this.eZk.size() > d.Vo()) || (this.eYU))
      {
        cp(false);
        return;
      }
    }
    cp(true);
  }
  
  private void VO()
  {
    if (this.mode == com.tencent.mm.plugin.aa.a.a.eVh)
    {
      if ((this.eZf != null) && (this.eZf.size() > 0))
      {
        d = com.tencent.mm.plugin.aa.a.h.a(this.eZa.getText(), this.eZf.size(), 2, 2);
        this.eXt.setText(getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.eYW.setText(a.i.launch_aa_by_money_total_amount_hint);
        return;
        this.eXt.setText(getString(a.i.aa_amount_zero));
      }
    }
    if ((this.eZk == null) || (this.eZk.size() == 0))
    {
      this.eYW.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(0) }));
      this.eXt.setText(getString(a.i.aa_amount_zero));
      return;
    }
    Iterator localIterator = this.eZk.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.eXt.setText(getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
    this.eYW.setText(getString(a.i.launch_aa_by_person_total_amount_hint, new Object[] { Integer.valueOf(this.eZk.size()) }));
  }
  
  private void VP()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.eYV.getText().toString();
        if (bk.bl(str1))
        {
          str1 = getString(a.i.launch_aa_default_title);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject = this.eZk.keySet().iterator();
          long l1 = 0L;
          if (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            double d = ((Double)this.eZk.get(str2)).doubleValue();
            com.tencent.mm.protocal.c.j localj = new com.tencent.mm.protocal.c.j();
            localj.ceq = com.tencent.mm.wallet_core.ui.e.gJ(String.valueOf(d), "100");
            localj.username = str2;
            localArrayList1.add(localj);
            long l2 = localj.ceq;
            localArrayList2.add(localj.ceq);
            l1 = l2 + l1;
          }
          else
          {
            localObject = new com.tencent.mm.protocal.c.j();
            ((com.tencent.mm.protocal.c.j)localObject).username = q.Gj();
            ((com.tencent.mm.protocal.c.j)localObject).ceq = l1;
            localHashMap.put(k.eWc, str1);
            localHashMap.put(k.eWd, Long.valueOf(l1));
            localHashMap.put(k.eWi, localArrayList1);
            localHashMap.put(k.eWg, this.chatroomName);
            localHashMap.put(k.eWj, Long.valueOf(this.timestamp));
            if (this.eXA != null) {
              this.eXA.dismiss();
            }
            this.eXA = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
            localObject = this.eYT.eWX;
            f.ci(localHashMap).c((com.tencent.mm.vending.c.a)localObject).f(new LaunchAAUI.13(this)).a(new LaunchAAUI.11(this));
            com.tencent.mm.plugin.report.service.h.nFQ.f(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.a.h.pr(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, bk.c(localArrayList2, ",") });
            return;
          }
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", new Object[] { localException.getMessage() });
        return;
      }
    }
  }
  
  private void VQ()
  {
    if ((this.eYU) && (!this.eZs)) {
      if (this.mode == com.tencent.mm.plugin.aa.a.a.eVh) {
        px(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(d.Vo()) }));
      }
    }
    do
    {
      return;
      px(getString(a.i.launch_aa_by_person_number_exceed_limit_alert, new Object[] { Integer.valueOf(d.Vn()) }));
      return;
      if ((this.eYD) && (!this.eZs))
      {
        px(getString(a.i.launch_aa_money_exceed_avg_amount_alert, new Object[] { Float.valueOf((float)d.Vp() / 100.0F) }));
        return;
      }
    } while ((this.eYU) || (this.eYD));
    VM();
  }
  
  private void cp(boolean paramBoolean)
  {
    this.eZm.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.eYW.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      this.eXt.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      this.eYX.setTextColor(getResources().getColor(a.c.aa_launch_amount_disable_color));
      return;
    }
    this.eYW.setTextColor(getResources().getColor(a.c.black));
    this.eXt.setTextColor(getResources().getColor(a.c.black));
    this.eYX.setTextColor(getResources().getColor(a.c.black));
  }
  
  private void px(String paramString)
  {
    this.eZs = true;
    this.eZn.setVisibility(0);
    this.eZn.startAnimation(AnimationUtils.loadAnimation(this, a.a.in_from_up));
    this.eZn.setText(paramString);
  }
  
  protected final boolean VK()
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.launch_aa_ui_new;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    double d;
    if (paramInt1 == 233) {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.a.a.eVh)
        {
          if (!bk.bl(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.eZf.clear();
            this.eZf.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = com.tencent.mm.plugin.aa.a.h.pr(this.chatroomName);
          if ((paramIntent == null) || (this.eZf == null) || (this.eZf.size() != paramIntent.size()) || (!s.fn(this.chatroomName))) {
            break label287;
          }
          paramIntent = this.eZc;
          paramInt2 = a.i.launch_aa_by_money_all_group_member;
          if (this.eZf == null) {
            break label282;
          }
          paramInt1 = this.eZf.size();
          paramIntent.setText(getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
        }
        VM();
        if ((this.eZf == null) || (this.eZf.size() <= d.Vo())) {
          break label341;
        }
        this.eYU = true;
        d = bk.getDouble(this.eZa.getText(), 0.0D);
        if ((this.eZf == null) || (d * 100.0D / this.eZf.size() <= d.Vp())) {
          break label349;
        }
        this.eYD = true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(13722, new Object[] { Integer.valueOf(2) });
        VN();
        VO();
        VQ();
      }
    }
    label282:
    label287:
    label341:
    label349:
    while ((paramInt1 != 236) || (paramInt2 != -1)) {
      for (;;)
      {
        return;
        paramInt1 = 0;
        continue;
        paramIntent = this.eZc;
        paramInt2 = a.i.launch_aa_by_money_usernumber_wording;
        if (this.eZf != null) {}
        for (paramInt1 = this.eZf.size();; paramInt1 = 0)
        {
          paramIntent.setText(getString(paramInt2, new Object[] { Integer.valueOf(paramInt1) }));
          break;
        }
        this.eYU = false;
        continue;
        this.eYD = false;
      }
    }
    paramIntent = paramIntent.getStringArrayListExtra("selectUI");
    this.eZk.clear();
    Object localObject;
    if (paramIntent != null)
    {
      try
      {
        if (paramIntent.size() > 0)
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject = ((String)paramIntent.next()).split(",");
            d = bk.getDouble(localObject[1], 0.0D);
            this.eZk.put(localObject[0], Double.valueOf(d));
          }
        }
        if (this.eZk == null) {
          break label848;
        }
      }
      catch (Exception paramIntent)
      {
        y.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[] { paramIntent.getMessage() });
        return;
      }
    }
    else if (this.eZk.size() > 0)
    {
      this.eZi.setText(getString(a.i.launch_aa_by_person_usernumber_wording, new Object[] { Integer.valueOf(this.eZk.size()) }));
      this.eZi.setTextColor(getResources().getColor(a.c.black));
      paramInt1 = (int)getResources().getDimension(a.d.aa_launch_content_left_right_margin);
      paramInt2 = (int)getResources().getDimension(a.d.aa_launch_by_person_header_margin_large);
      int i = (int)getResources().getDimension(a.d.aa_launch_by_person_header_margin_large_bottom);
      this.eZj.setPadding(paramInt1, paramInt2, paramInt1, i);
      this.eZj.setBackgroundResource(a.e.launch_aa_dark_round_corner_bg);
      this.eZh.setVisibility(0);
    }
    for (;;)
    {
      this.eZh.removeAllViews();
      this.eZl.clear();
      if ((this.eZk == null) || (this.eZk.size() <= 0)) {
        break;
      }
      paramIntent = this.eZk.keySet().iterator();
      paramInt1 = 0;
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        d = ((Double)this.eZk.get(localObject)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (paramInt1 >= this.eZk.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        String str = this.chatroomName;
        localLaunchAAByPersonNameAmountRow.eYn.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localLaunchAAByPersonNameAmountRow.getContext(), ((b)com.tencent.mm.kernel.g.r(b.class)).getDisplayName((String)localObject, str), localLaunchAAByPersonNameAmountRow.eYn.getTextSize()));
        localLaunchAAByPersonNameAmountRow.eXt.setText(localLaunchAAByPersonNameAmountRow.getContext().getString(a.i.aa_amount_format, new Object[] { Double.valueOf(d) }));
        this.eZh.addView(localLaunchAAByPersonNameAmountRow);
        this.eZl.put(localObject, localLaunchAAByPersonNameAmountRow);
        paramInt1 += 1;
      }
      label848:
      this.eZi.setText(a.i.launch_aa_by_person_usernumber_default_wording);
      this.eZi.setTextColor(getResources().getColor(a.c.aa_comm_hint_color));
      paramInt1 = (int)getResources().getDimension(a.d.aa_launch_content_left_right_margin);
      this.eZj.setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
      this.eZj.setBackgroundResource(a.e.launch_aa_white_round_corner_bg);
      this.eZh.setVisibility(8);
    }
    if (this.eYe != null) {
      this.eYe.requestLayout();
    }
    this.eZr = 0;
    this.eYZ.post(new LaunchAAUI.14(this));
    VO();
    VN();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
    setBackBtn(new LaunchAAUI.1(this));
    this.timestamp = (System.currentTimeMillis() / 1000L);
    setMMTitle(a.i.launch_aa_title);
    paramBundle = this.eYT.eWY;
    f.cLb().c(paramBundle).f(new LaunchAAUI.20(this)).a(new LaunchAAUI.19(this));
    this.chatroomName = getIntent().getStringExtra("chatroom_name");
    if (bk.bl(this.chatroomName))
    {
      y.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
      this.chatroomName = "";
    }
    paramBundle = this.chatroomName;
    if (!bk.bl(paramBundle)) {
      if (s.fn(paramBundle))
      {
        this.chatroomName = paramBundle;
        this.eYe = findViewById(a.f.root_container);
        this.eYe.setOnTouchListener(new LaunchAAUI.12(this));
        this.eYY = ((TextView)findViewById(a.f.launch_aa_switch_mode));
        this.eYY.setClickable(true);
        this.eYY.setOnTouchListener(new m(this));
        VL();
        this.eZm = ((Button)findViewById(a.f.launch_aa_button));
        this.eZm.setOnClickListener(new LaunchAAUI.15(this));
        this.eZn = ((TextView)findViewById(a.f.launch_aa_alert_tip_tv));
        this.eZo = ((TextView)findViewById(a.f.launch_aa_warn_tip_tv));
        this.eYV = ((MMEditText)findViewById(a.f.launch_aa_title_edit));
        this.eYW = ((TextView)findViewById(a.f.launch_aa_total_amount_hint));
        this.eXt = ((TextView)findViewById(a.f.launch_aa_amount));
        this.eYX = ((TextView)findViewById(a.f.launch_aa_amount_unit));
        this.eYW.setText(a.i.launch_aa_by_money_total_amount_hint);
        this.mode = com.tencent.mm.plugin.aa.a.a.eVh;
        this.eYZ = ((TextView)findViewById(a.f.aa_check_record));
        this.eYZ.setClickable(true);
        this.eYZ.setOnTouchListener(new m());
        paramBundle = new SpannableString(getString(a.i.check_aa_record));
        paramBundle.setSpan(new a(new LaunchAAUI.16(this)), 0, paramBundle.length(), 18);
        this.eYZ.setText(paramBundle);
        this.eYZ.setVisibility(8);
        this.eYV.addTextChangedListener(new LaunchAAUI.17(this));
        this.eZa = ((WalletFormView)findViewById(a.f.launch_aa_total_amount_edit_form));
        this.eZa.a(new LaunchAAUI.5(this));
        a(this.eZa, 2, false, false);
        this.eZc = ((TextView)findViewById(a.f.launch_aa_by_money_user_select));
        this.eZb = ((TextView)findViewById(a.f.launch_aa_by_money_user_select_hint));
        if (!s.fn(this.chatroomName)) {
          break label846;
        }
        paramBundle = com.tencent.mm.plugin.aa.a.h.pr(this.chatroomName);
        label541:
        this.eZf = paramBundle;
        if (this.eZf.size() <= d.Vo()) {
          break label897;
        }
        this.eZf.clear();
        this.eZc.setText(getString(a.i.paylist_aa_by_money_select_group_memeber));
        VN();
      }
    }
    for (;;)
    {
      this.eZc.setOnClickListener(new LaunchAAUI.6(this, paramBundle));
      this.eZd = ((ViewGroup)findViewById(a.f.launch_by_money_total_usernumber_content_layout));
      this.eZe = ((ViewGroup)findViewById(a.f.launch_by_money_total_amount_layout));
      this.eZa.requestFocus();
      this.eYU = false;
      this.eZi = ((TextView)findViewById(a.f.launch_aa_by_person_user_select));
      this.eZi.setText(a.i.launch_aa_by_person_usernumber_default_wording);
      this.eZi.setTextColor(getResources().getColor(a.c.aa_comm_hint_color));
      this.eZg = ((ViewGroup)findViewById(a.f.launch_by_person_user_layout));
      this.eZh = ((ViewGroup)findViewById(a.f.launch_by_person_user_list_layout));
      this.eZj = ((ViewGroup)findViewById(a.f.launch_aa_by_person_select_header_layout));
      this.eZj.setOnClickListener(new LaunchAAUI.7(this));
      cp(false);
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      this.eYZ.post(new LaunchAAUI.18(this));
      return;
      paramBundle = bk.G(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(q.Gj());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break;
        }
      }
      paramBundle = "";
      break;
      label846:
      y.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
      paramBundle = new ArrayList();
      paramBundle.add(q.Gj());
      paramBundle.add(this.chatroomName);
      break label541;
      label897:
      if (s.fn(this.chatroomName)) {
        this.eZc.setText(getString(a.i.launch_aa_by_money_all_group_member, new Object[] { Integer.valueOf(paramBundle.size()) }));
      } else {
        this.eZc.setText(getString(a.i.launch_aa_by_money_usernumber_wording, new Object[] { Integer.valueOf(paramBundle.size()) }));
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.eZl != null) {
      this.eZl.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */