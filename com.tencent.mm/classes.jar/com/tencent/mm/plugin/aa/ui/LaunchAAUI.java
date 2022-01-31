package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;
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
  private String chatroomName;
  private TextView gpq;
  private Dialog gpx;
  private com.tencent.mm.plugin.aa.a.c.e gqK;
  private boolean gqL;
  private MMEditText gqM;
  private TextView gqN;
  private TextView gqO;
  private TextView gqP;
  private TextView gqQ;
  private WalletFormView gqR;
  private TextView gqS;
  private TextView gqT;
  private ViewGroup gqU;
  private ViewGroup gqV;
  private List<String> gqW;
  private ViewGroup gqX;
  private ViewGroup gqY;
  private TextView gqZ;
  private boolean gqu;
  private ViewGroup gra;
  private Map<String, Double> grb;
  private Map<String, LaunchAAByPersonNameAmountRow> grc;
  private Button grd;
  private TextView gre;
  private TextView grf;
  private d grg;
  private int grh;
  private int gri;
  private boolean grj;
  private String grk;
  private String grl;
  private int mode;
  private long timestamp;
  
  public LaunchAAUI()
  {
    AppMethodBeat.i(40842);
    this.gqK = ((com.tencent.mm.plugin.aa.a.c.e)P(com.tencent.mm.plugin.aa.a.c.e.class));
    this.mode = com.tencent.mm.plugin.aa.a.a.gne;
    this.chatroomName = null;
    this.gqL = false;
    this.gqu = false;
    this.gqW = new ArrayList();
    this.grb = new HashMap();
    this.grc = new HashMap();
    this.grg = new d();
    this.grh = 0;
    this.gri = 0;
    this.grj = false;
    this.timestamp = 0L;
    AppMethodBeat.o(40842);
  }
  
  private void aph()
  {
    AppMethodBeat.i(40844);
    String str1;
    String str2;
    SpannableStringBuilder localSpannableStringBuilder;
    if (this.mode == com.tencent.mm.plugin.aa.a.a.gne)
    {
      str1 = getString(2131301027);
      str2 = getString(2131301028);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new LaunchAAUI.20(this)), str1.length(), localSpannableStringBuilder.length(), 18);
      this.gqP.setText(localSpannableStringBuilder);
      AppMethodBeat.o(40844);
      return;
    }
    if (this.mode == com.tencent.mm.plugin.aa.a.a.gnf)
    {
      str1 = getString(2131301038);
      str2 = getString(2131301039);
      localSpannableStringBuilder = new SpannableStringBuilder("");
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new a(new a.a()
      {
        public final void aoW()
        {
          AppMethodBeat.i(40825);
          LaunchAAUI.e(LaunchAAUI.this);
          AppMethodBeat.o(40825);
        }
      }), str1.length(), localSpannableStringBuilder.length(), 18);
      this.gqP.setText(localSpannableStringBuilder);
    }
    AppMethodBeat.o(40844);
  }
  
  private void api()
  {
    AppMethodBeat.i(40846);
    this.grj = false;
    if (this.gre.getVisibility() != 8)
    {
      this.gre.startAnimation(AnimationUtils.loadAnimation(this, 2131034214));
      this.gre.setVisibility(8);
    }
    AppMethodBeat.o(40846);
  }
  
  private void apj()
  {
    AppMethodBeat.i(40847);
    if (this.mode == com.tencent.mm.plugin.aa.a.a.gne)
    {
      if (bo.isNullOrNil(this.gqR.getText()))
      {
        ds(false);
        AppMethodBeat.o(40847);
        return;
      }
      if (this.gqu)
      {
        ds(false);
        AppMethodBeat.o(40847);
        return;
      }
      if ((this.gqW == null) || (this.gqW.size() == 0))
      {
        ds(false);
        AppMethodBeat.o(40847);
        return;
      }
      if ((this.gqW.size() > d.aoM()) || (this.gqL))
      {
        ds(false);
        AppMethodBeat.o(40847);
        return;
      }
      double d = com.tencent.mm.plugin.aa.a.h.a(this.gqR.getText(), this.gqW.size(), 5, 4);
      ab.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[] { this.gqR.getText(), Integer.valueOf(this.gqW.size()), Double.valueOf(d) });
      if (d < 0.01D)
      {
        ab.i("MicroMsg.LaunchAAUI", "less than 0.01");
        ds(false);
        AppMethodBeat.o(40847);
      }
    }
    else
    {
      if ((this.grb == null) || (this.grb.size() == 0))
      {
        ds(false);
        AppMethodBeat.o(40847);
        return;
      }
      if ((this.grb.size() > d.aoM()) || (this.gqL))
      {
        ds(false);
        AppMethodBeat.o(40847);
        return;
      }
    }
    ds(true);
    AppMethodBeat.o(40847);
  }
  
  private void apk()
  {
    AppMethodBeat.i(40849);
    if (this.mode == com.tencent.mm.plugin.aa.a.a.gne)
    {
      if ((this.gqW != null) && (this.gqW.size() > 0))
      {
        d = com.tencent.mm.plugin.aa.a.h.a(this.gqR.getText(), this.gqW.size(), 2, 2);
        this.gpq.setText(getString(2131296341, new Object[] { Double.valueOf(d) }));
      }
      for (;;)
      {
        this.gqN.setText(2131301029);
        AppMethodBeat.o(40849);
        return;
        this.gpq.setText(getString(2131296343));
      }
    }
    if ((this.grb == null) || (this.grb.size() == 0))
    {
      this.gqN.setText(getString(2131301040, new Object[] { Integer.valueOf(0) }));
      this.gpq.setText(getString(2131296343));
      AppMethodBeat.o(40849);
      return;
    }
    Iterator localIterator = this.grb.values().iterator();
    for (double d = 0.0D; localIterator.hasNext(); d = ((Double)localIterator.next()).doubleValue() + d) {}
    this.gpq.setText(getString(2131296341, new Object[] { Double.valueOf(d) }));
    this.gqN.setText(getString(2131301040, new Object[] { Integer.valueOf(this.grb.size()) }));
    AppMethodBeat.o(40849);
  }
  
  private void apl()
  {
    AppMethodBeat.i(40850);
    ((com.tencent.mm.pluginsdk.wallet.c)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.c.class)).eJ(7, 5);
    com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        String str1 = this.gqM.getText().toString();
        if (bo.isNullOrNil(str1))
        {
          str1 = getString(2131301043);
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject = this.grb.keySet().iterator();
          long l1 = 0L;
          if (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            double d = ((Double)this.grb.get(str2)).doubleValue();
            com.tencent.mm.protocal.protobuf.j localj = new com.tencent.mm.protocal.protobuf.j();
            localj.cNd = com.tencent.mm.wallet_core.ui.e.iM(String.valueOf(d), "100");
            localj.username = str2;
            localArrayList1.add(localj);
            long l2 = localj.cNd;
            localArrayList2.add(localj.cNd);
            l1 = l2 + l1;
          }
          else
          {
            localObject = new com.tencent.mm.protocal.protobuf.j();
            ((com.tencent.mm.protocal.protobuf.j)localObject).username = r.Zn();
            ((com.tencent.mm.protocal.protobuf.j)localObject).cNd = l1;
            localHashMap.put(k.gnZ, str1);
            localHashMap.put(k.goa, Long.valueOf(l1));
            localHashMap.put(k.gof, localArrayList1);
            localHashMap.put(k.god, this.chatroomName);
            localHashMap.put(k.gog, Long.valueOf(this.timestamp));
            if (this.gpx != null) {
              this.gpx.dismiss();
            }
            this.gpx = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
            localObject = this.gqK.goV;
            f.cN(localHashMap).c((com.tencent.mm.vending.c.a)localObject).f(new LaunchAAUI.11(this)).a(new LaunchAAUI.10(this));
            com.tencent.mm.plugin.report.service.h.qsU.e(13723, new Object[] { Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.a.h.wG(this.chatroomName).size()), Integer.valueOf(localArrayList1.size() + 1), Long.valueOf(l1), str1, bo.d(localArrayList2, ",") });
            AppMethodBeat.o(40850);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(40850);
        return;
      }
    }
  }
  
  private void apm()
  {
    AppMethodBeat.i(40852);
    if ((this.gqL) && (!this.grj))
    {
      if (this.mode == com.tencent.mm.plugin.aa.a.a.gne)
      {
        wL(getString(2131301037, new Object[] { Integer.valueOf(d.aoM()) }));
        AppMethodBeat.o(40852);
        return;
      }
      wL(getString(2131301037, new Object[] { Integer.valueOf(d.aoL()) }));
      AppMethodBeat.o(40852);
      return;
    }
    if ((this.gqu) && (!this.grj))
    {
      wL(getString(2131301045, new Object[] { Float.valueOf((float)d.aoN() / 100.0F) }));
      AppMethodBeat.o(40852);
      return;
    }
    if ((!this.gqL) && (!this.gqu)) {
      api();
    }
    AppMethodBeat.o(40852);
  }
  
  private void ds(boolean paramBoolean)
  {
    AppMethodBeat.i(40848);
    this.grd.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      this.gqN.setTextColor(getResources().getColor(2131689628));
      this.gpq.setTextColor(getResources().getColor(2131689628));
      this.gqO.setTextColor(getResources().getColor(2131689628));
      AppMethodBeat.o(40848);
      return;
    }
    this.gqN.setTextColor(getResources().getColor(2131689763));
    this.gpq.setTextColor(getResources().getColor(2131689763));
    this.gqO.setTextColor(getResources().getColor(2131689763));
    AppMethodBeat.o(40848);
  }
  
  private void wL(String paramString)
  {
    AppMethodBeat.i(40845);
    this.grj = true;
    this.gre.setVisibility(0);
    this.gre.startAnimation(AnimationUtils.loadAnimation(this, 2131034194));
    this.gre.setText(paramString);
    AppMethodBeat.o(40845);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969969;
  }
  
  public boolean needExecuteBackListener()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40853);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    label202:
    double d;
    label296:
    label348:
    label356:
    Object localObject;
    if (paramInt1 == 233)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (this.mode == com.tencent.mm.plugin.aa.a.a.gne)
        {
          if (!bo.isNullOrNil(paramIntent))
          {
            paramIntent = paramIntent.split(",");
            this.gqW.clear();
            this.gqW.addAll(Arrays.asList(paramIntent));
          }
          paramIntent = com.tencent.mm.plugin.aa.a.h.wG(this.chatroomName);
          if ((paramIntent == null) || (this.gqW == null) || (this.gqW.size() != paramIntent.size()) || (!t.lA(this.chatroomName))) {
            break label296;
          }
          paramIntent = this.gqT;
          if (this.gqW != null)
          {
            paramInt1 = this.gqW.size();
            paramIntent.setText(getString(2131301025, new Object[] { Integer.valueOf(paramInt1) }));
          }
        }
        else
        {
          api();
          if ((this.gqW == null) || (this.gqW.size() <= d.aoM())) {
            break label348;
          }
          this.gqL = true;
          d = bo.getDouble(this.gqR.getText(), 0.0D);
          if ((this.gqW == null) || (d * 100.0D / this.gqW.size() <= d.aoN())) {
            break label356;
          }
          this.gqu = true;
          com.tencent.mm.plugin.report.service.h.qsU.e(13722, new Object[] { Integer.valueOf(2) });
        }
        for (;;)
        {
          apj();
          apk();
          apm();
          AppMethodBeat.o(40853);
          return;
          paramInt1 = 0;
          break;
          paramIntent = this.gqT;
          if (this.gqW != null) {}
          for (paramInt1 = this.gqW.size();; paramInt1 = 0)
          {
            paramIntent.setText(getString(2131301030, new Object[] { Integer.valueOf(paramInt1) }));
            break;
          }
          this.gqL = false;
          break label202;
          this.gqu = false;
        }
      }
    }
    else if ((paramInt1 == 236) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selectUI");
      this.grb.clear();
      if (paramIntent == null) {
        break label494;
      }
      try
      {
        if (paramIntent.size() <= 0) {
          break label494;
        }
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          localObject = ((String)paramIntent.next()).split(",");
          d = bo.getDouble(localObject[1], 0.0D);
          this.grb.put(localObject[0], Double.valueOf(d));
        }
        AppMethodBeat.o(40853);
      }
      catch (Exception paramIntent)
      {
        ab.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[] { paramIntent.getMessage() });
      }
    }
    return;
    label494:
    if ((this.grb != null) && (this.grb.size() > 0))
    {
      this.gqZ.setText(getString(2131301042, new Object[] { Integer.valueOf(this.grb.size()) }));
      this.gqZ.setTextColor(getResources().getColor(2131689763));
      paramInt1 = (int)getResources().getDimension(2131427897);
      paramInt2 = (int)getResources().getDimension(2131427894);
      int i = (int)getResources().getDimension(2131427895);
      this.gra.setPadding(paramInt1, paramInt2, paramInt1, i);
      this.gra.setBackgroundResource(2130839260);
      this.gqY.setVisibility(0);
    }
    for (;;)
    {
      this.gqY.removeAllViews();
      this.grc.clear();
      if ((this.grb == null) || (this.grb.size() <= 0)) {
        break;
      }
      paramIntent = this.grb.keySet().iterator();
      paramInt1 = 0;
      while (paramIntent.hasNext())
      {
        localObject = (String)paramIntent.next();
        d = ((Double)this.grb.get(localObject)).doubleValue();
        LaunchAAByPersonNameAmountRow localLaunchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
        if (paramInt1 >= this.grb.size() - 1) {
          localLaunchAAByPersonNameAmountRow.setDividerVisible(false);
        }
        String str = this.chatroomName;
        localLaunchAAByPersonNameAmountRow.gqe.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localLaunchAAByPersonNameAmountRow.getContext(), ((b)com.tencent.mm.kernel.g.E(b.class)).getDisplayName((String)localObject, str), localLaunchAAByPersonNameAmountRow.gqe.getTextSize()));
        localLaunchAAByPersonNameAmountRow.gpq.setText(localLaunchAAByPersonNameAmountRow.getContext().getString(2131296341, new Object[] { Double.valueOf(d) }));
        this.gqY.addView(localLaunchAAByPersonNameAmountRow);
        this.grc.put(localObject, localLaunchAAByPersonNameAmountRow);
        paramInt1 += 1;
      }
      this.gqZ.setText(2131301041);
      this.gqZ.setTextColor(getResources().getColor(2131689627));
      paramInt1 = (int)getResources().getDimension(2131427897);
      this.gra.setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
      this.gra.setBackgroundResource(2130839262);
      this.gqY.setVisibility(8);
    }
    if (this.gqb != null) {
      this.gqb.requestLayout();
    }
    this.gri = 0;
    this.gqQ.post(new LaunchAAUI.13(this));
    apk();
    apj();
    AppMethodBeat.o(40853);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40843);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
    setBackBtn(new LaunchAAUI.1(this));
    this.timestamp = (System.currentTimeMillis() / 1000L);
    setMMTitle(2131301049);
    paramBundle = this.gqK.goW;
    f.dQr().c(paramBundle).f(new LaunchAAUI.18(this)).a(new LaunchAAUI.17(this));
    this.chatroomName = getIntent().getStringExtra("chatroom_name");
    this.grk = getIntent().getStringExtra("amount");
    this.grl = getIntent().getStringExtra("title");
    if (bo.isNullOrNil(this.chatroomName))
    {
      ab.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
      this.chatroomName = "";
    }
    paramBundle = this.chatroomName;
    if (!bo.isNullOrNil(paramBundle)) {
      if (t.lA(paramBundle))
      {
        this.chatroomName = paramBundle;
        this.gqb = findViewById(2131823717);
        this.gqb.setOnTouchListener(new LaunchAAUI.12(this));
        this.gqP = ((TextView)findViewById(2131825385));
        this.gqP.setClickable(true);
        this.gqP.setOnTouchListener(new m(this));
        aph();
        this.grd = ((Button)findViewById(2131825394));
        this.grd.setOnClickListener(new LaunchAAUI.14(this));
        this.gre = ((TextView)findViewById(2131825396));
        this.grf = ((TextView)findViewById(2131825395));
        this.gqM = ((MMEditText)findViewById(2131825390));
        this.gqN = ((TextView)findViewById(2131825391));
        this.gpq = ((TextView)findViewById(2131825393));
        this.gqO = ((TextView)findViewById(2131825392));
        this.gqN.setText(2131301029);
        this.mode = com.tencent.mm.plugin.aa.a.a.gne;
        this.gqQ = ((TextView)findViewById(2131825081));
        this.gqQ.setClickable(true);
        this.gqQ.setOnTouchListener(new m());
        paramBundle = new SpannableString(getString(2131298345));
        paramBundle.setSpan(new a(new LaunchAAUI.15(this)), 0, paramBundle.length(), 18);
        this.gqQ.setText(paramBundle);
        this.gqQ.setVisibility(8);
        this.gqM.addTextChangedListener(new LaunchAAUI.16(this));
        this.gqR = ((WalletFormView)findViewById(2131825380));
        this.gqR.a(new LaunchAAUI.4(this));
        setEditFocusListener(this.gqR, 2, false, false);
        this.gqT = ((TextView)findViewById(2131825388));
        this.gqS = ((TextView)findViewById(2131825387));
        if (!t.lA(this.chatroomName)) {
          break label1025;
        }
        paramBundle = com.tencent.mm.plugin.aa.a.h.wG(this.chatroomName);
        label578:
        this.gqW = paramBundle;
        if (this.gqW.size() <= d.aoM()) {
          break label1077;
        }
        this.gqW.clear();
        this.gqT.setText(getString(2131302051));
        apj();
        label625:
        this.gqT.setOnClickListener(new LaunchAAUI.5(this, paramBundle));
        this.gqU = ((ViewGroup)findViewById(2131825386));
        this.gqV = ((ViewGroup)findViewById(2131825379));
        this.gqR.requestFocus();
        this.gqL = false;
        this.gqZ = ((TextView)findViewById(2131825383));
        this.gqZ.setText(2131301041);
        this.gqZ.setTextColor(getResources().getColor(2131689627));
        this.gqX = ((ViewGroup)findViewById(2131825381));
        this.gqY = ((ViewGroup)findViewById(2131825384));
        this.gra = ((ViewGroup)findViewById(2131825382));
        this.gra.setOnClickListener(new LaunchAAUI.6(this));
        if (!bo.isNullOrNil(this.grl))
        {
          ab.i("MicroMsg.LaunchAAUI", "default title: %s", new Object[] { this.grl });
          this.gqM.setText(this.grl);
          if (this.grl.length() <= 20) {
            break label1153;
          }
        }
      }
    }
    label1025:
    label1153:
    for (int i = 20;; i = this.grl.length())
    {
      this.gqM.setSelection(i);
      if (!bo.isNullOrNil(this.grk))
      {
        ab.i("MicroMsg.LaunchAAUI", "default amount: %s", new Object[] { this.grk });
        paramBundle = com.tencent.mm.wallet_core.ui.e.b(new StringBuilder().append(this.grk).toString(), "100", RoundingMode.HALF_UP);
        this.gqR.setText(paramBundle);
        this.gqR.setSelection(paramBundle.length());
      }
      apj();
      com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(40843);
      return;
      paramBundle = bo.P(paramBundle.split(","));
      if (paramBundle != null)
      {
        paramBundle.remove(r.Zn());
        if (paramBundle.size() > 0)
        {
          paramBundle = (String)paramBundle.get(0);
          break;
        }
      }
      paramBundle = "";
      break;
      ab.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[] { this.chatroomName });
      paramBundle = new ArrayList();
      paramBundle.add(r.Zn());
      paramBundle.add(this.chatroomName);
      break label578;
      label1077:
      if (t.lA(this.chatroomName))
      {
        this.gqT.setText(getString(2131301025, new Object[] { Integer.valueOf(paramBundle.size()) }));
        break label625;
      }
      this.gqT.setText(getString(2131301030, new Object[] { Integer.valueOf(paramBundle.size()) }));
      break label625;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(40851);
    super.onStop();
    if (this.grc != null) {
      this.grc.clear();
    }
    AppMethodBeat.o(40851);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI
 * JD-Core Version:    0.7.0.1
 */