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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.kg;
import com.tencent.mm.f.a.kg.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private TextView DLp;
  private LuckyMoneyWishFooter EGE;
  private ImageView EGF;
  private View EGG;
  private ImageView EGH;
  private boolean EGI;
  private int EGJ;
  private String EGK;
  private String EGL;
  private int EGM;
  private Map<String, Integer> EGN;
  private j EGO;
  private String EGP;
  private boolean EGQ;
  private List<ae> Eud;
  private TextView Euj;
  private ListView Eur;
  private ImageView Eus;
  private TextView Eut;
  private View Euv;
  private View Euw;
  AbsListView.OnScrollListener Euy;
  private String ExZ;
  private String Eyn;
  private View mL;
  private TextView mMA;
  private boolean puR;
  private TextView qCM;
  private View uIP;
  private int zP;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.zP = 0;
    this.EGI = true;
    this.puR = false;
    this.EGM = 0;
    this.Eud = new LinkedList();
    this.EGN = new HashMap();
    this.EGP = "";
    this.EGQ = false;
    this.Euy = new AbsListView.OnScrollListener()
    {
      private boolean EuA;
      private boolean Euz = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.Euz))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label102:
        for (;;)
        {
          if (this.EuA != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(a.e.lucky_money_actionbar_bg);
            }
            this.EuA = bool;
          }
          AppMethodBeat.o(65450);
          return;
          paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt1);
          if (paramAnonymousAbsListView != null) {}
          for (paramAnonymousInt1 = 0 - paramAnonymousAbsListView.getTop();; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 > 100) {
              break label102;
            }
            bool = false;
            break;
          }
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(65449);
        if (paramAnonymousAbsListView.getCount() == 0)
        {
          AppMethodBeat.o(65449);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(65449);
          return;
          if (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1)
          {
            if (!LuckyMoneyBusiDetailUI.this.EGu.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.Euz = false;
          AppMethodBeat.o(65449);
          return;
          this.Euz = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int Wb(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void a(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(65472);
    if (paramq == null)
    {
      AppMethodBeat.o(65472);
      return;
    }
    if (paramq.Ezk == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.EGI = bool;
      if (this.zP == 0)
      {
        this.EGK = paramq.Ezh;
        this.EGO.Eue = this.EGK;
        this.EGO.Eug = paramq.Ezs;
        b(paramq);
        d(paramq);
        com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(Wb(paramq.Ezs)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paramq);
      localLinkedList = paramq.Ezu;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        ae localae = (ae)localLinkedList.get(i);
        if (!this.EGN.containsKey(localae.Ezh))
        {
          this.Eud.add(localLinkedList.get(i));
          this.EGN.put(localae.Ezh, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.zP += localLinkedList.size();
    this.puR = false;
    this.EGO.fS(this.Eud);
    label271:
    iO(paramq.Ezr, paramq.Ezv);
    com.tencent.mm.plugin.report.service.h.IzE.a(13051, new Object[] { Integer.valueOf(this.EGM), Integer.valueOf(1), paramq.Ezr, ag.fT(paramq.Ezo), "", "", "", "", paramq.Eza, Integer.valueOf(paramq.Ezt) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(65473);
    if (paramq != null)
    {
      final AppCompatActivity localAppCompatActivity = getContext();
      if (paramq.Ezs == 2)
      {
        this.Eus.setImageResource(a.e.lucky_money_busi_default_avatar);
        if (paramq.Ezt != 0)
        {
          Log.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramq.Ezt);
          final kg localkg = new kg();
          localkg.fHH.fHJ = paramq.Ezt;
          localkg.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (localkg.fHI.fHK)
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + localkg.fHI.fHL);
                LuckyMoneyBusiDetailUI.this.getContext();
                ag.e(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), localkg.fHI.fHL, a.e.lucky_money_busi_default_avatar);
                AppMethodBeat.o(65452);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!Util.isNullOrNil(paramq.Ezb)) {
                ag.a(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paramq.Ezb, paramq.Ezw);
              }
              AppMethodBeat.o(65452);
            }
          };
          EventCenter.instance.asyncPublish(localkg, Looper.myLooper());
          ag.a(localAppCompatActivity, this.Eut, paramq.Eza);
          ag.a(localAppCompatActivity, this.DLp, paramq.EtJ);
          if ((paramq.gbq != 2) || (this.EGJ == 3)) {
            break label340;
          }
          this.Euj.setText(g.formatMoney2f(paramq.gbJ / 100.0D));
          if (paramq.Ezi == 1) {
            break label329;
          }
          this.EGO.Euf = true;
          label181:
          this.Euv.setVisibility(0);
          label189:
          if (Util.isNullOrNil(paramq.EvM)) {
            break label392;
          }
          this.Euw.setVisibility(0);
          this.qCM.setText(paramq.EvM);
          if (paramq.EvK != 1) {
            break label364;
          }
          if ((TextUtils.isEmpty(paramq.EvL)) || (paramq.EvL.startsWith("weixin://wxpay"))) {
            break label352;
          }
          this.EGF.setVisibility(0);
          label257:
          this.qCM.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65453);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (!TextUtils.isEmpty(paramq.EvL))
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + paramq.EvL);
                if (paramq.EvL.startsWith("weixin://wxpay"))
                {
                  g.azK(12);
                  f.aX(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65453);
                return;
                g.azK(7);
                g.bA(localAppCompatActivity, paramq.EvL);
                continue;
                g.azK(12);
                f.aX(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
              }
            }
          });
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramq.Ezl)) {
          break label412;
        }
        this.mMA.setText(paramq.Ezl);
        AppMethodBeat.o(65473);
        return;
        if (Util.isNullOrNil(paramq.Ezb)) {
          break;
        }
        ag.a(this.Eus, paramq.Ezb, paramq.Ezw);
        break;
        label329:
        this.EGO.Euf = false;
        break label181;
        label340:
        this.Euv.setVisibility(8);
        break label189;
        label352:
        this.EGF.setVisibility(8);
        break label257;
        label364:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.qCM.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
        continue;
        label392:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.Euw.setVisibility(8);
      }
      label412:
      this.mMA.setText(null);
    }
    AppMethodBeat.o(65473);
  }
  
  private void c(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(65476);
    if (paramq == null)
    {
      AppMethodBeat.o(65476);
      return;
    }
    int i;
    int j;
    label91:
    TextView localTextView1;
    label215:
    TextView localTextView2;
    if (((paramq.gbp == 3) || (paramq.gbp == 2)) && (paramq.Ezj == 1) && (!this.EGI) && (paramq.Ezm == 1))
    {
      i = 1;
      if ((paramq.Ezn == null) || (paramq.Ezn.jqz != 1) || (Util.isNullOrNil(paramq.Ezn.EyD))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.uIP.findViewById(a.f.busi_detail_send_btn);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paramq));
      if (j != 0)
      {
        this.EGL = paramq.Ezn.EyD;
        localTextView1.setText(paramq.Ezn.EyE);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11701, new Object[] { Integer.valueOf(Wb(paramq.Ezs)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.uIP.findViewById(a.f.busi_detail_record_link);
      if ((this.EGJ == 1) || (this.EGJ == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paramq));
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.EGQ)
      {
        this.Eur.addFooterView(this.uIP);
        this.EGQ = true;
      }
      AppMethodBeat.o(65476);
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
  
  private void d(com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(65477);
    if (paramq != null)
    {
      Object localObject1 = paramq.Ezo;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.mL.findViewById(a.f.busi_detail_operation_container_1);
        View localView1 = this.mL.findViewById(a.f.busi_detail_operation_container_2);
        View localView2 = this.mL.findViewById(a.f.busi_detail_operation_container_3);
        ViewGroup localViewGroup1 = (ViewGroup)this.mL.findViewById(a.f.busi_detail_operation_1);
        ViewGroup localViewGroup2 = (ViewGroup)this.mL.findViewById(a.f.busi_detail_operation_2);
        ViewGroup localViewGroup3 = (ViewGroup)this.mL.findViewById(a.f.busi_detail_operation_3);
        View localView3 = this.mL.findViewById(a.f.busi_detail_divider_operation_1);
        View localView4 = this.mL.findViewById(a.f.busi_detail_divider_operation_2);
        i.c localc = new i.c();
        localc.textColor = getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color);
        localc.ELE = true;
        localc.Ezt = paramq.Ezt;
        localc.ELF = this.EGM;
        if (((List)localObject1).size() > 0)
        {
          i.a(this, localViewGroup1, (bh)((List)localObject1).get(0), localc);
          ((View)localObject2).setVisibility(0);
        }
        if (((List)localObject1).size() > 1)
        {
          i.a(this, localViewGroup2, (bh)((List)localObject1).get(1), localc);
          localView1.setVisibility(0);
        }
        if (((List)localObject1).size() > 2)
        {
          i.a(this, localViewGroup3, (bh)((List)localObject1).get(2), localc);
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
          this.EGG.requestLayout();
          this.EGG.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.uIP.findViewById(a.f.busi_detail_footer_operation);
      Object localObject2 = new i.c();
      ((i.c)localObject2).textColor = getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color);
      ((i.c)localObject2).textSize = getResources().getDimensionPixelSize(a.d.SmallerTextSize);
      i.a(this, (ViewGroup)localObject1, paramq.Ezp, (i.c)localObject2);
    }
    AppMethodBeat.o(65477);
  }
  
  private void ePD()
  {
    AppMethodBeat.i(65471);
    this.puR = true;
    if ((this.zP > 0) && (this.Eud.size() > 0) && (this.Eud.get(this.Eud.size() - 1) != null))
    {
      doSceneProgress(new ap(this.ExZ, this.zP, this.Eyn, Util.getLong(((ae)this.Eud.get(this.Eud.size() - 1)).EAs, 0L), "v1.0", this.EGP));
      AppMethodBeat.o(65471);
      return;
    }
    this.EGP = "";
    doSceneProgress(new ap(this.ExZ, 11, this.zP, this.Eyn, "v1.0", this.EGP));
    AppMethodBeat.o(65471);
  }
  
  private void ePE()
  {
    AppMethodBeat.i(65475);
    new DisplayMetrics();
    Object localObject = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    if (localObject == null)
    {
      AppMethodBeat.o(65475);
      return;
    }
    int i = (int)((((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(a.d.lucky_money_busi_detail_list_padding) * 2 - getResources().getDimensionPixelSize(a.d.lucky_money_busi_detail_list_margin) * 2) * 0.75F);
    localObject = this.EGH.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.EGH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void ePF()
  {
    AppMethodBeat.i(65478);
    if ((this.EGE != null) && (this.EGE.getVisibility() != 8)) {
      this.EGE.setVisibility(8);
    }
    AppMethodBeat.o(65478);
  }
  
  public static void fixBackgroundRepeat(View paramView)
  {
    AppMethodBeat.i(65466);
    if (paramView == null)
    {
      AppMethodBeat.o(65466);
      return;
    }
    paramView = paramView.getBackground();
    if (paramView == null)
    {
      AppMethodBeat.o(65466);
      return;
    }
    if (!(paramView instanceof BitmapDrawable))
    {
      AppMethodBeat.o(65466);
      return;
    }
    paramView = (BitmapDrawable)paramView;
    paramView.mutate();
    paramView.setTileModeX(Shader.TileMode.REPEAT);
    AppMethodBeat.o(65466);
  }
  
  private void iO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.EGH.setImageResource(a.e.lucky_money_busi_ad_img_default);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.EGH.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    ePE();
    ag.b(this.EGH, paramString1, paramString2, false);
    this.EGH.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.EGE.getVisibility() == 0))
    {
      this.EGE.setVisibility(8);
      AppMethodBeat.o(65467);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(65467);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(65470);
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
      AppMethodBeat.o(65470);
      return;
    }
    super.finish();
    AppMethodBeat.o(65470);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_busi_detail_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65469);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(65469);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(str)) {
          if ((this.EGL != null) && (this.EGL.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new bg(str.replaceAll(",", "|"), this.ExZ, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    this.Eur = ((ListView)findViewById(a.f.busi_detail_record_list));
    this.EGO = new j(getContext());
    this.mL = LayoutInflater.from(this).inflate(a.g.lucky_money_busi_detail_header, null);
    this.Eur.addHeaderView(this.mL);
    this.Eur.setAdapter(this.EGO);
    this.mL.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.Eur.setOnScrollListener(this.Euy);
    this.Eur.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.uIP = LayoutInflater.from(this).inflate(a.g.lucky_money_busi_detail_footer, null);
    this.Eus = ((ImageView)this.mL.findViewById(a.f.busi_detail_avatar));
    this.Eut = ((TextView)this.mL.findViewById(a.f.busi_detail_whose));
    this.DLp = ((TextView)this.mL.findViewById(a.f.busi_detail_wishing));
    this.Euv = this.mL.findViewById(a.f.busi_detail_amount_area);
    this.Euj = ((TextView)this.mL.findViewById(a.f.busi_detail_amount));
    this.Euw = this.mL.findViewById(a.f.busi_detail_hint_layout);
    this.qCM = ((TextView)this.mL.findViewById(a.f.busi_detail_tips));
    this.EGF = ((ImageView)this.mL.findViewById(a.f.busi_detail_icon));
    this.mMA = ((TextView)this.mL.findViewById(a.f.busi_detail_desc));
    this.EGG = this.mL.findViewById(a.f.busi_detail_opertiaon_ll);
    this.EGH = ((ImageView)this.mL.findViewById(a.f.busi_detail_adimage));
    paramBundle = (ImageView)findViewById(a.f.busi_detail_close_btn);
    this.EGE = ((LuckyMoneyWishFooter)findViewById(a.f.busi_detail_wish_footer));
    Object localObject = this.EGE;
    LuckyMoneyBusiDetailUI.9 local9 = new LuckyMoneyBusiDetailUI.9(this);
    if (((LuckyMoneyWishFooter)localObject).EOh != null) {
      ((LuckyMoneyWishFooter)localObject).EOh.setBackListener(local9);
    }
    this.EGE.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void aNL(String paramAnonymousString)
      {
        AppMethodBeat.i(65459);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this))))
        {
          paramAnonymousString = new ay(LuckyMoneyBusiDetailUI.h(LuckyMoneyBusiDetailUI.this), paramAnonymousString, LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this), "v1.0");
          LuckyMoneyBusiDetailUI.this.doSceneProgress(paramAnonymousString);
          LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        }
        AppMethodBeat.o(65459);
      }
    });
    this.EGE.post(new LuckyMoneyBusiDetailUI.11(this));
    this.EGE.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.EGO.ENS = new LuckyMoneyBusiDetailUI.13(this);
    localObject = this.EGO;
    ((j)localObject).ENT = new j.a((j)localObject);
    this.EGE.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(a.f.busi_detail_bottom_decoration));
    this.ExZ = getIntent().getStringExtra("key_sendid");
    this.Eyn = getIntent().getStringExtra("key_native_url");
    this.EGJ = getIntent().getIntExtra("key_jump_from", 2);
    this.EGM = getIntent().getIntExtra("key_static_from_scene", 0);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.ExZ, this.Eyn, Integer.valueOf(this.EGJ) });
    if (this.EGJ == 2) {}
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getByteArrayExtra("key_detail_info");
        if (paramBundle != null)
        {
          paramBundle = (com.tencent.mm.plugin.luckymoney.model.q)new com.tencent.mm.plugin.luckymoney.model.q().parseFrom(paramBundle);
          if (paramBundle != null)
          {
            a(paramBundle);
            if (getIntent().getBooleanExtra("play_sound", false)) {
              l.play(this, a.i.lucky_cashrecivedrevised);
            }
            AppMethodBeat.o(65465);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        Log.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((Util.isNullOrNil(this.ExZ)) && (!Util.isNullOrNil(this.Eyn))) {
        paramBundle = Uri.parse(this.Eyn);
      }
      try
      {
        this.ExZ = paramBundle.getQueryParameter("sendid");
        if (!Util.isNullOrNil(this.ExZ)) {
          ePD();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + paramBundle.getLocalizedMessage());
        }
        Log.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65479);
    super.onDestroy();
    if (this.EGE != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.EGE;
      if (localLuckyMoneyWishFooter.jPN != null)
      {
        Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.jPN.hjm();
        localLuckyMoneyWishFooter.jPN.destroy();
      }
    }
    AppMethodBeat.o(65479);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(65468);
    if ((paramq instanceof ap))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ap)paramq;
        paramq = paramString.EAX;
        this.EGP = paramString.EBl;
        a(paramq);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramq instanceof ay))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cO(this, getString(a.i.has_send));
        this.EGO.Euf = false;
        ePF();
        paramString = (ay)paramq;
        if (this.Eud != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.Eud.size())
          {
            paramq = (ae)this.Eud.get(paramInt1);
            if (paramq.Ezh.equalsIgnoreCase(paramString.Ezh))
            {
              paramq.EAI = paramString.EtJ;
              this.EGO.notifyDataSetChanged();
            }
          }
          else
          {
            AppMethodBeat.o(65468);
            return true;
          }
          paramInt1 += 1;
        }
      }
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramq instanceof bg))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cO(this, getString(a.i.has_send));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cO(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    AppMethodBeat.o(65468);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */