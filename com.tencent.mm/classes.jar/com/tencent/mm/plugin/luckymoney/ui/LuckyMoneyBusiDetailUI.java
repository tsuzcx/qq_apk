package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.lk;
import com.tencent.mm.autogen.a.lk.b;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.az;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.bi;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.KeyboardLinearLayout.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private TextView JCr;
  private boolean KAa;
  private List<af> KmK;
  private TextView KmQ;
  private ListView KmY;
  private ImageView KmZ;
  private TextView Kna;
  private View Knc;
  private View Knd;
  AbsListView.OnScrollListener Knf;
  private String KqM;
  private String Kra;
  private LuckyMoneyWishFooter KzN;
  private ImageView KzO;
  private View KzP;
  private ImageView KzQ;
  private boolean KzR;
  private int KzS;
  private String KzT;
  private String KzU;
  private int KzV;
  private Map<String, Integer> KzW;
  private j KzX;
  private String KzY;
  private boolean KzZ;
  private int Sc;
  private View nJ;
  private TextView pJi;
  private boolean szX;
  private TextView tHK;
  private View xRF;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.Sc = 0;
    this.KzR = true;
    this.szX = false;
    this.KzV = 0;
    this.KmK = new LinkedList();
    this.KzW = new HashMap();
    this.KzY = "";
    this.KzZ = false;
    this.KAa = false;
    this.Knf = new AbsListView.OnScrollListener()
    {
      private boolean Kng = false;
      private boolean Knh;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.Kng))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label102:
        for (;;)
        {
          if (this.Knh != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(a.e.lucky_money_actionbar_bg);
            }
            this.Knh = bool;
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
            if (!LuckyMoneyBusiDetailUI.this.KzD.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.Kng = false;
          AppMethodBeat.o(65449);
          return;
          this.Kng = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int ZX(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void a(q paramq)
  {
    AppMethodBeat.i(65472);
    if (paramq == null)
    {
      AppMethodBeat.o(65472);
      return;
    }
    if ((ah.fXk()) && (paramq.Ksa != null) && (paramq.Ksa.lTH != 1))
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "is not atomic luckymoney, go to LuckyMoneyDetailUI");
      b.a(this.KqM, paramq);
      paramq = new Intent(getContext(), LuckyMoneyDetailUI.class);
      paramq.putExtras(getIntent());
      paramq = new com.tencent.mm.hellhoundlib.b.a().cG(paramq);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramq.aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI", "updateByDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyDetail;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramq.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI", "updateByDetail", "(Lcom/tencent/mm/plugin/luckymoney/model/LuckyMoneyDetail;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.KAa = true;
      finish();
      AppMethodBeat.o(65472);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(-1186093);
    }
    this.KAa = false;
    Object localObject = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
    ((Animation)localObject).setDuration(250L);
    getContentView().startAnimation((Animation)localObject);
    setContentViewVisibility(0);
    if (paramq.KrX == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.KzR = bool;
      if (this.Sc == 0)
      {
        this.KzT = paramq.KrU;
        this.KzX.KmL = this.KzT;
        this.KzX.KmN = paramq.Ksf;
        b(paramq);
        d(paramq);
        h.OAn.b(11701, new Object[] { Integer.valueOf(ZX(paramq.Ksf)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paramq);
      localObject = paramq.Ksg;
      if (localObject == null) {
        break label467;
      }
      int i = 0;
      while (i < ((List)localObject).size())
      {
        af localaf = (af)((List)localObject).get(i);
        if (!this.KzW.containsKey(localaf.KrU))
        {
          this.KmK.add((af)((List)localObject).get(i));
          this.KzW.put(localaf.KrU, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.Sc += ((List)localObject).size();
    this.szX = false;
    this.KzX.iQ(this.KmK);
    label467:
    kc(paramq.Kse, paramq.Ksh);
    h.OAn.b(13051, new Object[] { Integer.valueOf(this.KzV), Integer.valueOf(1), paramq.Kse, ah.iR(paramq.Ksb), "", "", "", "", paramq.KrN, Integer.valueOf(paramq.resourceId) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final q paramq)
  {
    AppMethodBeat.i(65473);
    if (paramq != null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      if (paramq.Ksf == 2)
      {
        this.KmZ.setImageResource(a.e.lucky_money_busi_default_avatar);
        if (paramq.resourceId != 0)
        {
          Log.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramq.resourceId);
          final lk locallk = new lk();
          locallk.hNh.hNj = paramq.resourceId;
          locallk.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (locallk.hNi.hNk)
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + locallk.hNi.hNl);
                LuckyMoneyBusiDetailUI.this.getContext();
                ah.e(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), locallk.hNi.hNl, a.e.lucky_money_busi_default_avatar);
                AppMethodBeat.o(65452);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!Util.isNullOrNil(paramq.KrO)) {
                ah.a(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paramq.KrO, paramq.Ksi);
              }
              AppMethodBeat.o(65452);
            }
          };
          locallk.asyncPublish(Looper.myLooper());
          ah.a(localAppCompatActivity, this.Kna, paramq.KrN);
          ah.a(localAppCompatActivity, this.JCr, paramq.Kmq);
          if ((paramq.ihA != 2) || (this.KzS == 3)) {
            break label340;
          }
          this.KmQ.setText(com.tencent.mm.wallet_core.ui.i.formatMoney2f(paramq.ihV / 100.0D));
          if (paramq.KrV == 1) {
            break label329;
          }
          this.KzX.KmM = true;
          label180:
          this.Knc.setVisibility(0);
          label188:
          if (Util.isNullOrNil(paramq.Kou)) {
            break label392;
          }
          this.Knd.setVisibility(0);
          this.tHK.setText(paramq.Kou);
          if (paramq.Kos != 1) {
            break label364;
          }
          if ((TextUtils.isEmpty(paramq.Kot)) || (paramq.Kot.startsWith("weixin://wxpay"))) {
            break label352;
          }
          this.KzO.setVisibility(0);
          label256:
          this.tHK.setOnClickListener(new LuckyMoneyBusiDetailUI.4(this, paramq, localAppCompatActivity));
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramq.KrY)) {
          break label412;
        }
        this.pJi.setText(paramq.KrY);
        AppMethodBeat.o(65473);
        return;
        if (Util.isNullOrNil(paramq.KrO)) {
          break;
        }
        ah.a(this.KmZ, paramq.KrO, paramq.Ksi);
        break;
        label329:
        this.KzX.KmM = false;
        break label180;
        label340:
        this.Knc.setVisibility(8);
        break label188;
        label352:
        this.KzO.setVisibility(8);
        break label256;
        label364:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.tHK.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
        continue;
        label392:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.Knd.setVisibility(8);
      }
      label412:
      this.pJi.setText(null);
    }
    AppMethodBeat.o(65473);
  }
  
  private void c(q paramq)
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
    if (((paramq.ihz == 3) || (paramq.ihz == 2)) && (paramq.KrW == 1) && (!this.KzR) && (paramq.KrZ == 1))
    {
      i = 1;
      if ((paramq.Ksa == null) || (paramq.Ksa.lTH != 1) || (Util.isNullOrNil(paramq.Ksa.Krq))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.xRF.findViewById(a.f.busi_detail_send_btn);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paramq));
      if (j != 0)
      {
        this.KzU = paramq.Ksa.Krq;
        localTextView1.setText(paramq.Ksa.Krr);
      }
      h.OAn.b(11701, new Object[] { Integer.valueOf(ZX(paramq.Ksf)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.xRF.findViewById(a.f.busi_detail_record_link);
      if ((this.KzS == 1) || (this.KzS == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paramq));
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.KzZ)
      {
        this.KmY.addFooterView(this.xRF);
        this.KzZ = true;
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
  
  private void d(q paramq)
  {
    AppMethodBeat.i(65477);
    if (paramq != null)
    {
      Object localObject1 = paramq.Ksb;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.nJ.findViewById(a.f.busi_detail_operation_container_1);
        View localView1 = this.nJ.findViewById(a.f.busi_detail_operation_container_2);
        View localView2 = this.nJ.findViewById(a.f.busi_detail_operation_container_3);
        ViewGroup localViewGroup1 = (ViewGroup)this.nJ.findViewById(a.f.busi_detail_operation_1);
        ViewGroup localViewGroup2 = (ViewGroup)this.nJ.findViewById(a.f.busi_detail_operation_2);
        ViewGroup localViewGroup3 = (ViewGroup)this.nJ.findViewById(a.f.busi_detail_operation_3);
        View localView3 = this.nJ.findViewById(a.f.busi_detail_divider_operation_1);
        View localView4 = this.nJ.findViewById(a.f.busi_detail_divider_operation_2);
        i.c localc = new i.c();
        localc.textColor = getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color);
        localc.KFW = true;
        localc.resourceId = paramq.resourceId;
        localc.KFX = this.KzV;
        if (((List)localObject1).size() > 0)
        {
          i.a(this, localViewGroup1, (bi)((List)localObject1).get(0), localc);
          ((View)localObject2).setVisibility(0);
        }
        if (((List)localObject1).size() > 1)
        {
          i.a(this, localViewGroup2, (bi)((List)localObject1).get(1), localc);
          localView1.setVisibility(0);
        }
        if (((List)localObject1).size() > 2)
        {
          i.a(this, localViewGroup3, (bi)((List)localObject1).get(2), localc);
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
          this.KzP.requestLayout();
          this.KzP.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.xRF.findViewById(a.f.busi_detail_footer_operation);
      Object localObject2 = new i.c();
      ((i.c)localObject2).textColor = getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color);
      ((i.c)localObject2).textSize = getResources().getDimensionPixelSize(a.d.SmallerTextSize);
      i.a(this, (ViewGroup)localObject1, paramq.Ksc, (i.c)localObject2);
    }
    AppMethodBeat.o(65477);
  }
  
  private void fYg()
  {
    AppMethodBeat.i(65471);
    this.szX = true;
    if ((this.Sc > 0) && (this.KmK.size() > 0) && (this.KmK.get(this.KmK.size() - 1) != null))
    {
      doSceneProgress(new aq(this.KqM, this.Sc, this.Kra, Util.getLong(((af)this.KmK.get(this.KmK.size() - 1)).Kti, 0L), "v1.0", this.KzY));
      AppMethodBeat.o(65471);
      return;
    }
    this.KzY = "";
    doSceneProgress(new aq(this.KqM, 11, this.Sc, this.Kra, "v1.0", this.KzY));
    AppMethodBeat.o(65471);
  }
  
  private void fYh()
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
    localObject = this.KzQ.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.KzQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void fYi()
  {
    AppMethodBeat.i(65478);
    if ((this.KzN != null) && (this.KzN.getVisibility() != 8)) {
      this.KzN.setVisibility(8);
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
  
  private void kc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.KzQ.setImageResource(a.e.lucky_money_busi_ad_img_default);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.KzQ.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    fYh();
    ah.b(this.KzQ, paramString1, paramString2, false);
    this.KzQ.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.KzN.getVisibility() == 0))
    {
      this.KzN.setVisibility(8);
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
    if (this.KAa)
    {
      super.finish();
      AppMethodBeat.o(65470);
      return;
    }
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
          if ((this.KzU != null) && (this.KzU.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new bh(str.replaceAll(",", "|"), this.KqM, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(0);
    }
    this.KmY = ((ListView)findViewById(a.f.busi_detail_record_list));
    this.KzX = new j(getContext());
    this.nJ = LayoutInflater.from(this).inflate(a.g.lucky_money_busi_detail_header, null);
    this.KmY.addHeaderView(this.nJ);
    this.KmY.setAdapter(this.KzX);
    this.nJ.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.KmY.setOnScrollListener(this.Knf);
    this.KmY.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.xRF = LayoutInflater.from(this).inflate(a.g.lucky_money_busi_detail_footer, null);
    this.KmZ = ((ImageView)this.nJ.findViewById(a.f.busi_detail_avatar));
    this.Kna = ((TextView)this.nJ.findViewById(a.f.busi_detail_whose));
    this.JCr = ((TextView)this.nJ.findViewById(a.f.busi_detail_wishing));
    this.Knc = this.nJ.findViewById(a.f.busi_detail_amount_area);
    this.KmQ = ((TextView)this.nJ.findViewById(a.f.busi_detail_amount));
    this.Knd = this.nJ.findViewById(a.f.busi_detail_hint_layout);
    this.tHK = ((TextView)this.nJ.findViewById(a.f.busi_detail_tips));
    this.KzO = ((ImageView)this.nJ.findViewById(a.f.busi_detail_icon));
    this.pJi = ((TextView)this.nJ.findViewById(a.f.busi_detail_desc));
    this.KzP = this.nJ.findViewById(a.f.busi_detail_opertiaon_ll);
    this.KzQ = ((ImageView)this.nJ.findViewById(a.f.busi_detail_adimage));
    paramBundle = (ImageView)findViewById(a.f.busi_detail_close_btn);
    this.KzN = ((LuckyMoneyWishFooter)findViewById(a.f.busi_detail_wish_footer));
    Object localObject = this.KzN;
    MMEditText.a local9 = new MMEditText.a()
    {
      public final void onBack()
      {
        AppMethodBeat.i(65458);
        if (LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).getVisibility() == 0)
        {
          LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).setVisibility(8);
          AppMethodBeat.o(65458);
          return;
        }
        LuckyMoneyBusiDetailUI.this.getContext().finish();
        AppMethodBeat.o(65458);
      }
    };
    if (((LuckyMoneyWishFooter)localObject).KIG != null) {
      ((LuckyMoneyWishFooter)localObject).KIG.setBackListener(local9);
    }
    this.KzN.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void aKJ(String paramAnonymousString)
      {
        AppMethodBeat.i(65459);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this))))
        {
          paramAnonymousString = new az(LuckyMoneyBusiDetailUI.h(LuckyMoneyBusiDetailUI.this), paramAnonymousString, LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this), "v1.0");
          LuckyMoneyBusiDetailUI.this.doSceneProgress(paramAnonymousString);
          LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        }
        AppMethodBeat.o(65459);
      }
    });
    this.KzN.post(new LuckyMoneyBusiDetailUI.11(this));
    this.KzN.setOnkbdStateListener(new KeyboardLinearLayout.b()
    {
      public final void onKeyBoardStateChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(65461);
        if ((paramAnonymousInt == -2) && (LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).KIH)) {
          LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).setModeClick(false);
        }
        AppMethodBeat.o(65461);
      }
    });
    this.KzX.KIr = new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(284551);
        LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).setVisibility(0);
        AppMethodBeat.o(284551);
      }
    };
    localObject = this.KzX;
    ((j)localObject).KIs = new j.a((j)localObject);
    this.KzN.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(a.f.busi_detail_bottom_decoration));
    setContentViewVisibility(8);
    this.KqM = getIntent().getStringExtra("key_sendid");
    this.Kra = getIntent().getStringExtra("key_native_url");
    this.KzS = getIntent().getIntExtra("key_jump_from", 2);
    this.KzV = getIntent().getIntExtra("key_static_from_scene", 0);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.KqM, this.Kra, Integer.valueOf(this.KzS) });
    if (this.KzS == 2) {}
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getByteArrayExtra("key_detail_info");
        if (paramBundle != null)
        {
          paramBundle = (q)new q().parseFrom(paramBundle);
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
      if ((Util.isNullOrNil(this.KqM)) && (!Util.isNullOrNil(this.Kra))) {
        paramBundle = Uri.parse(this.Kra);
      }
      try
      {
        this.KqM = paramBundle.getQueryParameter("sendid");
        if (!Util.isNullOrNil(this.KqM)) {
          fYg();
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
    if (this.KzN != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.KzN;
      if (localLuckyMoneyWishFooter.moD != null)
      {
        Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.moD.iKg();
        localLuckyMoneyWishFooter.moD.destroy();
      }
    }
    AppMethodBeat.o(65479);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65468);
    if ((paramp instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramp;
        paramp = paramString.KtU;
        this.KzY = paramString.Kuj;
        a(paramp);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.k.cZ(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramp instanceof az))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.k.cZ(this, getString(a.i.has_send));
        this.KzX.KmM = false;
        fYi();
        paramString = (az)paramp;
        if (this.KmK != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.KmK.size())
          {
            paramp = (af)this.KmK.get(paramInt1);
            if (paramp.KrU.equalsIgnoreCase(paramString.KrU))
            {
              paramp.KtE = paramString.Kmq;
              this.KzX.notifyDataSetChanged();
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
      com.tencent.mm.ui.base.k.cZ(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramp instanceof bh))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.k.cZ(this, getString(a.i.has_send));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.k.cZ(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */