package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private int Fb;
  private View Ww;
  private boolean icT;
  private TextView kPB;
  private TextView kRB;
  private View llk;
  private TextView nIU;
  private List<w> oja;
  private TextView ojg;
  private ListView ojo;
  private ImageView ojp;
  private TextView ojq;
  private View ojs;
  private View ojt;
  AbsListView.OnScrollListener ojv;
  private LuckyMoneyWishFooter orB;
  private ImageView orC;
  private View orD;
  private ImageView orE;
  private boolean orF;
  private int orG;
  private String orH;
  private String orI;
  private String orJ;
  private String orK;
  private int orL;
  private Map<String, Integer> orM;
  private i orN;
  private String orO;
  private boolean orP;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(42597);
    this.Fb = 0;
    this.orF = true;
    this.icT = false;
    this.orL = 0;
    this.oja = new LinkedList();
    this.orM = new HashMap();
    this.orO = "";
    this.orP = false;
    this.ojv = new LuckyMoneyBusiDetailUI.1(this);
    AppMethodBeat.o(42597);
  }
  
  private void a(com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    AppMethodBeat.i(42605);
    if (paramk == null)
    {
      AppMethodBeat.o(42605);
      return;
    }
    if (paramk.onC == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.orF = bool;
      if (this.Fb == 0)
      {
        this.orI = paramk.onz;
        this.orN.ojb = this.orI;
        this.orN.ojd = paramk.onK;
        b(paramk);
        d(paramk);
        com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(yu(paramk.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paramk);
      localLinkedList = paramk.onL;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        w localw = (w)localLinkedList.get(i);
        if (!this.orM.containsKey(localw.onz))
        {
          this.oja.add(localLinkedList.get(i));
          this.orM.put(localw.onz, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.Fb += localLinkedList.size();
    this.icT = false;
    this.orN.ci(this.oja);
    label271:
    fe(paramk.onJ, paramk.onM);
    com.tencent.mm.plugin.report.service.h.qsU.e(13051, new Object[] { Integer.valueOf(this.orL), Integer.valueOf(1), paramk.onJ, x.cj(paramk.onG), "", "", "", "", paramk.ons, Integer.valueOf(paramk.resourceId) });
    AppMethodBeat.o(42605);
  }
  
  private void b(com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    AppMethodBeat.i(42606);
    if (paramk != null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      if (paramk.onK == 2)
      {
        this.ojp.setImageResource(2130839357);
        if (paramk.resourceId != 0)
        {
          ab.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramk.resourceId);
          hr localhr = new hr();
          localhr.cwO.cwQ = paramk.resourceId;
          localhr.callback = new LuckyMoneyBusiDetailUI.3(this, localhr, paramk);
          com.tencent.mm.sdk.b.a.ymk.a(localhr, Looper.myLooper());
          x.a(localAppCompatActivity, this.ojq, paramk.ons);
          x.a(localAppCompatActivity, this.nIU, paramk.oiG);
          if ((paramk.cMR != 2) || (this.orG == 3)) {
            break label338;
          }
          this.ojg.setText(com.tencent.mm.wallet_core.ui.e.E(paramk.cNd / 100.0D));
          if (paramk.onA == 1) {
            break label327;
          }
          this.orN.ojc = true;
          label180:
          this.ojs.setVisibility(0);
          label188:
          if (bo.isNullOrNil(paramk.okL)) {
            break label390;
          }
          this.ojt.setVisibility(0);
          this.kRB.setText(paramk.okL);
          if (paramk.okJ != 1) {
            break label362;
          }
          if ((TextUtils.isEmpty(paramk.okK)) || (paramk.okK.startsWith("weixin://wxpay"))) {
            break label350;
          }
          this.orC.setVisibility(0);
          label256:
          this.kRB.setOnClickListener(new LuckyMoneyBusiDetailUI.4(this, paramk));
        }
      }
      for (;;)
      {
        if (bo.isNullOrNil(paramk.onD)) {
          break label410;
        }
        this.kPB.setText(paramk.onD);
        AppMethodBeat.o(42606);
        return;
        if (bo.isNullOrNil(paramk.ont)) {
          break;
        }
        x.b(this.ojp, paramk.ont, paramk.onN);
        break;
        label327:
        this.orN.ojc = false;
        break label180;
        label338:
        this.ojs.setVisibility(8);
        break label188;
        label350:
        this.orC.setVisibility(8);
        break label256;
        label362:
        ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.kRB.setTextColor(getResources().getColor(2131690258));
        continue;
        label390:
        ab.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.ojt.setVisibility(8);
      }
      label410:
      this.kPB.setText(null);
    }
    AppMethodBeat.o(42606);
  }
  
  private void bNR()
  {
    AppMethodBeat.i(42604);
    this.icT = true;
    if ((this.Fb > 0) && (this.oja.size() > 0) && (this.oja.get(this.oja.size() - 1) != null))
    {
      doSceneProgress(new af(this.orH, this.Fb, this.orJ, bo.getLong(((w)this.oja.get(this.oja.size() - 1)).oop, 0L), "v1.0", this.orO));
      AppMethodBeat.o(42604);
      return;
    }
    this.orO = "";
    doSceneProgress(new af(this.orH, 11, this.Fb, this.orJ, "v1.0", this.orO));
    AppMethodBeat.o(42604);
  }
  
  private void bNS()
  {
    AppMethodBeat.i(42608);
    new DisplayMetrics();
    Object localObject = ah.getContext().getResources().getDisplayMetrics();
    if (localObject == null)
    {
      AppMethodBeat.o(42608);
      return;
    }
    int i = (int)((((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(2131428508) * 2 - getResources().getDimensionPixelSize(2131428507) * 2) * 0.75F);
    localObject = this.orE.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.orE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(42608);
  }
  
  private void bNT()
  {
    AppMethodBeat.i(42611);
    if ((this.orB != null) && (this.orB.getVisibility() != 8)) {
      this.orB.setVisibility(8);
    }
    AppMethodBeat.o(42611);
  }
  
  private void c(com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    AppMethodBeat.i(42609);
    if (paramk == null)
    {
      AppMethodBeat.o(42609);
      return;
    }
    int i;
    int j;
    label91:
    TextView localTextView1;
    label215:
    TextView localTextView2;
    if (((paramk.cMQ == 3) || (paramk.cMQ == 2)) && (paramk.onB == 1) && (!this.orF) && (paramk.onE == 1))
    {
      i = 1;
      if ((paramk.onF == null) || (paramk.onF.eoD != 1) || (bo.isNullOrNil(paramk.onF.ona))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.llk.findViewById(2131825556);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paramk));
      if (j != 0)
      {
        this.orK = paramk.onF.ona;
        localTextView1.setText(paramk.onF.onb);
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(yu(paramk.onK)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.llk.findViewById(2131825557);
      if ((this.orG == 1) || (this.orG == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paramk));
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.orP)
      {
        this.ojo.addFooterView(this.llk);
        this.orP = true;
      }
      AppMethodBeat.o(42609);
      return;
      i = 0;
      break;
      label309:
      j = 0;
      break label91;
      label314:
      localTextView1.setVisibility(8);
      break label215;
      label324:
      localTextView2.setVisibility(8);
    }
  }
  
  private void d(com.tencent.mm.plugin.luckymoney.model.k paramk)
  {
    AppMethodBeat.i(42610);
    if (paramk != null)
    {
      Object localObject1 = paramk.onG;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.Ww.findViewById(2131825570);
        View localView1 = this.Ww.findViewById(2131825573);
        View localView2 = this.Ww.findViewById(2131825576);
        ViewGroup localViewGroup1 = (ViewGroup)this.Ww.findViewById(2131825571);
        ViewGroup localViewGroup2 = (ViewGroup)this.Ww.findViewById(2131825574);
        ViewGroup localViewGroup3 = (ViewGroup)this.Ww.findViewById(2131825577);
        View localView3 = this.Ww.findViewById(2131825572);
        View localView4 = this.Ww.findViewById(2131825575);
        h.c localc = new h.c();
        localc.textColor = getResources().getColor(2131690235);
        localc.ovJ = true;
        localc.resourceId = paramk.resourceId;
        localc.ovK = this.orL;
        if (((List)localObject1).size() > 0)
        {
          h.a(this, localViewGroup1, (as)((List)localObject1).get(0), localc);
          ((View)localObject2).setVisibility(0);
        }
        if (((List)localObject1).size() > 1)
        {
          h.a(this, localViewGroup2, (as)((List)localObject1).get(1), localc);
          localView1.setVisibility(0);
        }
        if (((List)localObject1).size() > 2)
        {
          h.a(this, localViewGroup3, (as)((List)localObject1).get(2), localc);
          localView2.setVisibility(0);
        }
        if ((((View)localObject2).getVisibility() == 0) && ((localView1.getVisibility() == 0) || (localView2.getVisibility() == 0))) {
          localView3.setVisibility(0);
        }
        if ((localView1.getVisibility() == 0) && (localView2.getVisibility() == 0)) {
          localView4.setVisibility(0);
        }
        if ((((View)localObject2).getVisibility() == 0) || (localView1.getVisibility() == 0) || (localView2.getVisibility() == 0))
        {
          this.orD.requestLayout();
          this.orD.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.llk.findViewById(2131825558);
      Object localObject2 = new h.c();
      ((h.c)localObject2).textColor = getResources().getColor(2131690235);
      ((h.c)localObject2).textSize = getResources().getDimensionPixelSize(2131427860);
      h.a(this, (ViewGroup)localObject1, paramk.onH, (h.c)localObject2);
    }
    AppMethodBeat.o(42610);
  }
  
  private void fe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(42607);
    this.orE.setImageResource(2130839356);
    if (bo.isNullOrNil(paramString1))
    {
      ab.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.orE.setVisibility(8);
      AppMethodBeat.o(42607);
      return;
    }
    bNS();
    x.a(this.orE, paramString1, paramString2);
    this.orE.setVisibility(0);
    AppMethodBeat.o(42607);
  }
  
  public static void fixBackgroundRepeat(View paramView)
  {
    AppMethodBeat.i(42599);
    if (paramView == null)
    {
      AppMethodBeat.o(42599);
      return;
    }
    paramView = paramView.getBackground();
    if (paramView == null)
    {
      AppMethodBeat.o(42599);
      return;
    }
    if (!(paramView instanceof BitmapDrawable))
    {
      AppMethodBeat.o(42599);
      return;
    }
    paramView = (BitmapDrawable)paramView;
    paramView.mutate();
    paramView.setTileModeX(Shader.TileMode.REPEAT);
    AppMethodBeat.o(42599);
  }
  
  private static int yu(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42600);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.orB.getVisibility() == 0))
    {
      this.orB.setVisibility(8);
      AppMethodBeat.o(42600);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(42600);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(42603);
    if (getIntent().hasExtra("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getIntent().getParcelableExtra("key_realname_guide_helper");
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
      localBundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new LuckyMoneyBusiDetailUI.2(this));
      getIntent().removeExtra("key_realname_guide_helper");
      if (!bool) {
        super.finish();
      }
      AppMethodBeat.o(42603);
      return;
    }
    super.finish();
    AppMethodBeat.o(42603);
  }
  
  public int getLayoutId()
  {
    return 2130970018;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42602);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(42602);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!bo.isNullOrNil(str)) {
          if ((this.orK != null) && (this.orK.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            ab.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new ar(str.replaceAll(",", "|"), this.orH, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42598);
    super.onCreate(paramBundle);
    this.ojo = ((ListView)findViewById(2131825580));
    this.orN = new i(getContext());
    this.Ww = LayoutInflater.from(this).inflate(2130970017, null);
    this.ojo.addHeaderView(this.Ww);
    this.ojo.setAdapter(this.orN);
    this.Ww.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.ojo.setOnScrollListener(this.ojv);
    this.ojo.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.llk = LayoutInflater.from(this).inflate(2130970016, null);
    this.ojp = ((ImageView)this.Ww.findViewById(2131825561));
    this.ojq = ((TextView)this.Ww.findViewById(2131825562));
    this.nIU = ((TextView)this.Ww.findViewById(2131825563));
    this.ojs = this.Ww.findViewById(2131825564);
    this.ojg = ((TextView)this.Ww.findViewById(2131825565));
    this.ojt = this.Ww.findViewById(2131825566);
    this.kRB = ((TextView)this.Ww.findViewById(2131825568));
    this.orC = ((ImageView)this.Ww.findViewById(2131825567));
    this.kPB = ((TextView)this.Ww.findViewById(2131825578));
    this.orD = this.Ww.findViewById(2131825569);
    this.orE = ((ImageView)this.Ww.findViewById(2131825560));
    paramBundle = (ImageView)findViewById(2131825579);
    this.orB = ((LuckyMoneyWishFooter)findViewById(2131825582));
    this.orB.a(new LuckyMoneyBusiDetailUI.9(this));
    this.orB.setOnWishSendImp(new LuckyMoneyBusiDetailUI.10(this));
    this.orB.post(new LuckyMoneyBusiDetailUI.11(this));
    this.orB.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.orN.owY = new LuckyMoneyBusiDetailUI.13(this);
    i locali = this.orN;
    locali.owZ = new i.a(locali);
    this.orB.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(2131825581));
    this.orH = getIntent().getStringExtra("key_sendid");
    this.orJ = getIntent().getStringExtra("key_native_url");
    this.orG = getIntent().getIntExtra("key_jump_from", 2);
    this.orL = getIntent().getIntExtra("key_static_from_scene", 0);
    ab.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.orH, this.orJ, Integer.valueOf(this.orG) });
    if (this.orG == 2) {}
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getByteArrayExtra("key_detail_info");
        if (paramBundle != null)
        {
          paramBundle = (com.tencent.mm.plugin.luckymoney.model.k)new com.tencent.mm.plugin.luckymoney.model.k().parseFrom(paramBundle);
          if (paramBundle != null)
          {
            a(paramBundle);
            if (getIntent().getBooleanExtra("play_sound", false)) {
              k.a(this, k.a.oxx);
            }
            AppMethodBeat.o(42598);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        ab.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((bo.isNullOrNil(this.orH)) && (!bo.isNullOrNil(this.orJ))) {
        paramBundle = Uri.parse(this.orJ);
      }
      try
      {
        this.orH = paramBundle.getQueryParameter("sendid");
        if (!bo.isNullOrNil(this.orH)) {
          bNR();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ab.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + paramBundle.getLocalizedMessage());
        }
        ab.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42612);
    super.onDestroy();
    if (this.orB != null) {
      this.orB.bOo();
    }
    AppMethodBeat.o(42612);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42601);
    if ((paramm instanceof af))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (af)paramm;
        paramm = paramString.ooO;
        this.orO = paramString.opa;
        a(paramm);
        AppMethodBeat.o(42601);
        return true;
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42601);
      return true;
    }
    if ((paramm instanceof am))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
        this.orN.ojc = false;
        bNT();
        paramString = (am)paramm;
        if (this.oja != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.oja.size())
          {
            paramm = (w)this.oja.get(paramInt1);
            if (paramm.onz.equalsIgnoreCase(paramString.onz))
            {
              paramm.ooD = paramString.oiG;
              this.orN.notifyDataSetChanged();
            }
          }
          else
          {
            AppMethodBeat.o(42601);
            return true;
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42601);
      return true;
    }
    if ((paramm instanceof ar))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.bO(this, getString(2131300637));
        AppMethodBeat.o(42601);
        return true;
      }
      com.tencent.mm.ui.base.h.bO(this, paramString);
      AppMethodBeat.o(42601);
      return true;
    }
    AppMethodBeat.o(42601);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */