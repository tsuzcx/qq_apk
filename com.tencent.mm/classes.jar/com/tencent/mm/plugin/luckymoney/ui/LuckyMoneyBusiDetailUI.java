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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.is.b;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private int MW;
  private View aew;
  private boolean kOL;
  private TextView lLe;
  private TextView lgw;
  private View pfa;
  private TextView tEq;
  private List<y> uhb;
  private TextView uhh;
  private ListView uhp;
  private ImageView uhq;
  private TextView uhr;
  private View uht;
  private View uhu;
  AbsListView.OnScrollListener uhw;
  private View usA;
  private ImageView usB;
  private boolean usC;
  private int usD;
  private String usE;
  private String usF;
  private String usG;
  private int usH;
  private Map<String, Integer> usI;
  private i usJ;
  private String usK;
  private boolean usL;
  private String ust;
  private LuckyMoneyWishFooter usy;
  private ImageView usz;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.MW = 0;
    this.usC = true;
    this.kOL = false;
    this.usH = 0;
    this.uhb = new LinkedList();
    this.usI = new HashMap();
    this.usK = "";
    this.usL = false;
    this.uhw = new AbsListView.OnScrollListener()
    {
      private boolean uhx = false;
      private boolean uhy;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.uhx))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label101:
        for (;;)
        {
          if (this.uhy != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.uhy = bool;
          }
          AppMethodBeat.o(65450);
          return;
          paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt1);
          if (paramAnonymousAbsListView != null) {}
          for (paramAnonymousInt1 = 0 - paramAnonymousAbsListView.getTop();; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 > 100) {
              break label101;
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
            if (!LuckyMoneyBusiDetailUI.this.usr.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.uhx = false;
          AppMethodBeat.o(65449);
          return;
          this.uhx = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int HS(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  private void a(l paraml)
  {
    AppMethodBeat.i(65472);
    if (paraml == null)
    {
      AppMethodBeat.o(65472);
      return;
    }
    if (paraml.ulI == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.usC = bool;
      if (this.MW == 0)
      {
        this.usE = paraml.ulF;
        this.usJ.uhc = this.usE;
        this.usJ.uhe = paraml.ulQ;
        b(paraml);
        d(paraml);
        com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(HS(paraml.ulQ)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paraml);
      localLinkedList = paraml.ulR;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        y localy = (y)localLinkedList.get(i);
        if (!this.usI.containsKey(localy.ulF))
        {
          this.uhb.add(localLinkedList.get(i));
          this.usI.put(localy.ulF, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.MW += localLinkedList.size();
    this.kOL = false;
    this.usJ.ef(this.uhb);
    label271:
    hA(paraml.ulP, paraml.ulS);
    com.tencent.mm.plugin.report.service.h.wUl.f(13051, new Object[] { Integer.valueOf(this.usH), Integer.valueOf(1), paraml.ulP, z.eg(paraml.ulM), "", "", "", "", paraml.uly, Integer.valueOf(paraml.resourceId) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final l paraml)
  {
    AppMethodBeat.i(65473);
    if (paraml != null)
    {
      final AppCompatActivity localAppCompatActivity = getContext();
      if (paraml.ulQ == 2)
      {
        this.uhq.setImageResource(2131232967);
        if (paraml.resourceId != 0)
        {
          ac.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
          final is localis = new is();
          localis.djX.djZ = paraml.resourceId;
          localis.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (localis.djY.dka)
              {
                ac.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + localis.djY.dkb);
                LuckyMoneyBusiDetailUI.this.getContext();
                z.p(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), localis.djY.dkb);
                AppMethodBeat.o(65452);
                return;
              }
              ac.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!bs.isNullOrNil(paraml.ulz)) {
                z.b(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paraml.ulz, paraml.ulT);
              }
              AppMethodBeat.o(65452);
            }
          };
          com.tencent.mm.sdk.b.a.GpY.a(localis, Looper.myLooper());
          z.a(localAppCompatActivity, this.uhr, paraml.uly);
          z.a(localAppCompatActivity, this.tEq, paraml.ugH);
          if ((paraml.dBB != 2) || (this.usD == 3)) {
            break label339;
          }
          this.uhh.setText(e.C(paraml.dBN / 100.0D));
          if (paraml.ulG == 1) {
            break label328;
          }
          this.usJ.uhd = true;
          label180:
          this.uht.setVisibility(0);
          label188:
          if (bs.isNullOrNil(paraml.uiO)) {
            break label391;
          }
          this.uhu.setVisibility(0);
          this.lLe.setText(paraml.uiO);
          if (paraml.uiM != 1) {
            break label363;
          }
          if ((TextUtils.isEmpty(paraml.uiN)) || (paraml.uiN.startsWith("weixin://wxpay"))) {
            break label351;
          }
          this.usz.setVisibility(0);
          label256:
          this.lLe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65453);
              if (!TextUtils.isEmpty(paraml.uiN))
              {
                ac.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + paraml.uiN);
                if (paraml.uiN.startsWith("weixin://wxpay"))
                {
                  e.adR(12);
                  com.tencent.mm.pluginsdk.wallet.f.at(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                  AppMethodBeat.o(65453);
                  return;
                }
                e.adR(7);
                e.aT(localAppCompatActivity, paraml.uiN);
                AppMethodBeat.o(65453);
                return;
              }
              e.adR(12);
              com.tencent.mm.pluginsdk.wallet.f.at(LuckyMoneyBusiDetailUI.this.getContext(), 1);
              ac.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
              AppMethodBeat.o(65453);
            }
          });
        }
      }
      for (;;)
      {
        if (bs.isNullOrNil(paraml.ulJ)) {
          break label411;
        }
        this.lgw.setText(paraml.ulJ);
        AppMethodBeat.o(65473);
        return;
        if (bs.isNullOrNil(paraml.ulz)) {
          break;
        }
        z.b(this.uhq, paraml.ulz, paraml.ulT);
        break;
        label328:
        this.usJ.uhd = false;
        break label180;
        label339:
        this.uht.setVisibility(8);
        break label188;
        label351:
        this.usz.setVisibility(8);
        break label256;
        label363:
        ac.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.lLe.setTextColor(getResources().getColor(2131100598));
        continue;
        label391:
        ac.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.uhu.setVisibility(8);
      }
      label411:
      this.lgw.setText(null);
    }
    AppMethodBeat.o(65473);
  }
  
  private void c(l paraml)
  {
    AppMethodBeat.i(65476);
    if (paraml == null)
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
    if (((paraml.dBA == 3) || (paraml.dBA == 2)) && (paraml.ulH == 1) && (!this.usC) && (paraml.ulK == 1))
    {
      i = 1;
      if ((paraml.ulL == null) || (paraml.ulL.fFp != 1) || (bs.isNullOrNil(paraml.ulL.ulg))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.pfa.findViewById(2131297623);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paraml));
      if (j != 0)
      {
        this.usG = paraml.ulL.ulg;
        localTextView1.setText(paraml.ulL.ulh);
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(HS(paraml.ulQ)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.pfa.findViewById(2131297620);
      if ((this.usD == 1) || (this.usD == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paraml));
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.usL)
      {
        this.uhp.addFooterView(this.pfa);
        this.usL = true;
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
  
  private void cZV()
  {
    AppMethodBeat.i(65471);
    this.kOL = true;
    if ((this.MW > 0) && (this.uhb.size() > 0) && (this.uhb.get(this.uhb.size() - 1) != null))
    {
      doSceneProgress(new ah(this.ust, this.MW, this.usF, bs.getLong(((y)this.uhb.get(this.uhb.size() - 1)).umI, 0L), "v1.0", this.usK));
      AppMethodBeat.o(65471);
      return;
    }
    this.usK = "";
    doSceneProgress(new ah(this.ust, 11, this.MW, this.usF, "v1.0", this.usK));
    AppMethodBeat.o(65471);
  }
  
  private void cZW()
  {
    AppMethodBeat.i(65475);
    new DisplayMetrics();
    Object localObject = ai.getContext().getResources().getDisplayMetrics();
    if (localObject == null)
    {
      AppMethodBeat.o(65475);
      return;
    }
    int i = (int)((((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(2131166496) * 2 - getResources().getDimensionPixelSize(2131166495) * 2) * 0.75F);
    localObject = this.usB.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.usB.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void cZX()
  {
    AppMethodBeat.i(65478);
    if ((this.usy != null) && (this.usy.getVisibility() != 8)) {
      this.usy.setVisibility(8);
    }
    AppMethodBeat.o(65478);
  }
  
  private void d(l paraml)
  {
    AppMethodBeat.i(65477);
    if (paraml != null)
    {
      Object localObject1 = paraml.ulM;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.aew.findViewById(2131297616);
        View localView1 = this.aew.findViewById(2131297617);
        View localView2 = this.aew.findViewById(2131297618);
        ViewGroup localViewGroup1 = (ViewGroup)this.aew.findViewById(2131297613);
        ViewGroup localViewGroup2 = (ViewGroup)this.aew.findViewById(2131297614);
        ViewGroup localViewGroup3 = (ViewGroup)this.aew.findViewById(2131297615);
        View localView3 = this.aew.findViewById(2131297608);
        View localView4 = this.aew.findViewById(2131297609);
        h.c localc = new h.c();
        localc.textColor = getResources().getColor(2131100574);
        localc.uwM = true;
        localc.resourceId = paraml.resourceId;
        localc.uwN = this.usH;
        if (((List)localObject1).size() > 0)
        {
          h.a(this, localViewGroup1, (au)((List)localObject1).get(0), localc);
          ((View)localObject2).setVisibility(0);
        }
        if (((List)localObject1).size() > 1)
        {
          h.a(this, localViewGroup2, (au)((List)localObject1).get(1), localc);
          localView1.setVisibility(0);
        }
        if (((List)localObject1).size() > 2)
        {
          h.a(this, localViewGroup3, (au)((List)localObject1).get(2), localc);
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
          this.usA.requestLayout();
          this.usA.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.pfa.findViewById(2131297610);
      Object localObject2 = new h.c();
      ((h.c)localObject2).textColor = getResources().getColor(2131100574);
      ((h.c)localObject2).textSize = getResources().getDimensionPixelSize(2131165574);
      h.a(this, (ViewGroup)localObject1, paraml.ulN, (h.c)localObject2);
    }
    AppMethodBeat.o(65477);
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
  
  private void hA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.usB.setImageResource(2131232966);
    if (bs.isNullOrNil(paramString1))
    {
      ac.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.usB.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    cZW();
    z.a(this.usB, paramString1, paramString2);
    this.usB.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.usy.getVisibility() == 0))
    {
      this.usy.setVisibility(8);
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
    return 2131494630;
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
        if (!bs.isNullOrNil(str)) {
          if ((this.usG != null) && (this.usG.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            ac.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.ust, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    this.uhp = ((ListView)findViewById(2131297621));
    this.usJ = new i(getContext());
    this.aew = LayoutInflater.from(this).inflate(2131494629, null);
    this.uhp.addHeaderView(this.aew);
    this.uhp.setAdapter(this.usJ);
    this.aew.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.uhp.setOnScrollListener(this.uhw);
    this.uhp.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.pfa = LayoutInflater.from(this).inflate(2131494628, null);
    this.uhq = ((ImageView)this.aew.findViewById(2131297604));
    this.uhr = ((TextView)this.aew.findViewById(2131297625));
    this.tEq = ((TextView)this.aew.findViewById(2131297627));
    this.uht = this.aew.findViewById(2131297603);
    this.uhh = ((TextView)this.aew.findViewById(2131297602));
    this.uhu = this.aew.findViewById(2131297611);
    this.lLe = ((TextView)this.aew.findViewById(2131297624));
    this.usz = ((ImageView)this.aew.findViewById(2131297612));
    this.lgw = ((TextView)this.aew.findViewById(2131297607));
    this.usA = this.aew.findViewById(2131297619);
    this.usB = ((ImageView)this.aew.findViewById(2131297601));
    paramBundle = (ImageView)findViewById(2131297606);
    this.usy = ((LuckyMoneyWishFooter)findViewById(2131297626));
    Object localObject = this.usy;
    LuckyMoneyBusiDetailUI.9 local9 = new LuckyMoneyBusiDetailUI.9(this);
    if (((LuckyMoneyWishFooter)localObject).uyM != null) {
      ((LuckyMoneyWishFooter)localObject).uyM.setBackListener(local9);
    }
    this.usy.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void ako(String paramAnonymousString)
      {
        AppMethodBeat.i(65459);
        if ((!bs.isNullOrNil(paramAnonymousString)) && (!bs.isNullOrNil(LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this))))
        {
          paramAnonymousString = new ao(LuckyMoneyBusiDetailUI.h(LuckyMoneyBusiDetailUI.this), paramAnonymousString, LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this), "v1.0");
          LuckyMoneyBusiDetailUI.this.doSceneProgress(paramAnonymousString);
          LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        }
        AppMethodBeat.o(65459);
      }
    });
    this.usy.post(new LuckyMoneyBusiDetailUI.11(this));
    this.usy.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.usJ.uyy = new LuckyMoneyBusiDetailUI.13(this);
    localObject = this.usJ;
    ((i)localObject).uyz = new i.a((i)localObject);
    this.usy.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(2131297605));
    this.ust = getIntent().getStringExtra("key_sendid");
    this.usF = getIntent().getStringExtra("key_native_url");
    this.usD = getIntent().getIntExtra("key_jump_from", 2);
    this.usH = getIntent().getIntExtra("key_static_from_scene", 0);
    ac.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.ust, this.usF, Integer.valueOf(this.usD) });
    if (this.usD == 2) {}
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getByteArrayExtra("key_detail_info");
        if (paramBundle != null)
        {
          paramBundle = (l)new l().parseFrom(paramBundle);
          if (paramBundle != null)
          {
            a(paramBundle);
            if (getIntent().getBooleanExtra("play_sound", false)) {
              k.a(this, k.a.uyW);
            }
            AppMethodBeat.o(65465);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        ac.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((bs.isNullOrNil(this.ust)) && (!bs.isNullOrNil(this.usF))) {
        paramBundle = Uri.parse(this.usF);
      }
      try
      {
        this.ust = paramBundle.getQueryParameter("sendid");
        if (!bs.isNullOrNil(this.ust)) {
          cZV();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ac.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + paramBundle.getLocalizedMessage());
        }
        ac.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65479);
    super.onDestroy();
    if (this.usy != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.usy;
      if (localLuckyMoneyWishFooter.fWT != null)
      {
        ac.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.fWT.eMG();
        localLuckyMoneyWishFooter.fWT.destroy();
      }
    }
    AppMethodBeat.o(65479);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65468);
    if ((paramn instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        paramn = paramString.uni;
        this.usK = paramString.unu;
        a(paramn);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cg(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cg(this, getString(2131760233));
        this.usJ.uhd = false;
        cZX();
        paramString = (ao)paramn;
        if (this.uhb != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.uhb.size())
          {
            paramn = (y)this.uhb.get(paramInt1);
            if (paramn.ulF.equalsIgnoreCase(paramString.ulF))
            {
              paramn.umW = paramString.ugH;
              this.usJ.notifyDataSetChanged();
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
      com.tencent.mm.ui.base.h.cg(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cg(this, getString(2131760233));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cg(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */