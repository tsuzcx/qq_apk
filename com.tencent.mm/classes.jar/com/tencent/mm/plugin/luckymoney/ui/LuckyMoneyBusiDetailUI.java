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
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.jb.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.au;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private View agn;
  private int fq;
  private TextView lHT;
  private boolean lpM;
  private TextView mpP;
  private View pPh;
  private TextView uSM;
  private String vHa;
  private LuckyMoneyWishFooter vHf;
  private ImageView vHg;
  private View vHh;
  private ImageView vHi;
  private boolean vHj;
  private int vHk;
  private String vHl;
  private String vHm;
  private String vHn;
  private int vHo;
  private Map<String, Integer> vHp;
  private i vHq;
  private String vHr;
  private boolean vHs;
  private List<y> vvQ;
  private TextView vvW;
  private ListView vwe;
  private ImageView vwf;
  private TextView vwg;
  private View vwi;
  private View vwj;
  AbsListView.OnScrollListener vwl;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.fq = 0;
    this.vHj = true;
    this.lpM = false;
    this.vHo = 0;
    this.vvQ = new LinkedList();
    this.vHp = new HashMap();
    this.vHr = "";
    this.vHs = false;
    this.vwl = new AbsListView.OnScrollListener()
    {
      private boolean vwm = false;
      private boolean vwn;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.vwm))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label101:
        for (;;)
        {
          if (this.vwn != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.vwn = bool;
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
            if (!LuckyMoneyBusiDetailUI.this.vGY.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.vwm = false;
          AppMethodBeat.o(65449);
          return;
          this.vwm = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int JN(int paramInt)
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
    if (paraml.vAt == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.vHj = bool;
      if (this.fq == 0)
      {
        this.vHl = paraml.vAq;
        this.vHq.vvR = this.vHl;
        this.vHq.vvT = paraml.vAB;
        b(paraml);
        d(paraml);
        g.yxI.f(11701, new Object[] { Integer.valueOf(JN(paraml.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paraml);
      localLinkedList = paraml.vAC;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        y localy = (y)localLinkedList.get(i);
        if (!this.vHp.containsKey(localy.vAq))
        {
          this.vvQ.add(localLinkedList.get(i));
          this.vHp.put(localy.vAq, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.fq += localLinkedList.size();
    this.lpM = false;
    this.vHq.ew(this.vvQ);
    label271:
    hT(paraml.vAA, paraml.vAD);
    g.yxI.f(13051, new Object[] { Integer.valueOf(this.vHo), Integer.valueOf(1), paraml.vAA, z.ex(paraml.vAx), "", "", "", "", paraml.vAj, Integer.valueOf(paraml.resourceId) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final l paraml)
  {
    AppMethodBeat.i(65473);
    if (paraml != null)
    {
      final AppCompatActivity localAppCompatActivity = getContext();
      if (paraml.vAB == 2)
      {
        this.vwf.setImageResource(2131232967);
        if (paraml.resourceId != 0)
        {
          ae.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
          final jb localjb = new jb();
          localjb.dwP.dwR = paraml.resourceId;
          localjb.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (localjb.dwQ.dwS)
              {
                ae.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + localjb.dwQ.dwT);
                LuckyMoneyBusiDetailUI.this.getContext();
                z.p(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), localjb.dwQ.dwT);
                AppMethodBeat.o(65452);
                return;
              }
              ae.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!bu.isNullOrNil(paraml.vAk)) {
                z.b(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paraml.vAk, paraml.vAE);
              }
              AppMethodBeat.o(65452);
            }
          };
          com.tencent.mm.sdk.b.a.IvT.a(localjb, Looper.myLooper());
          z.a(localAppCompatActivity, this.vwg, paraml.vAj);
          z.a(localAppCompatActivity, this.uSM, paraml.vvw);
          if ((paraml.dPe != 2) || (this.vHk == 3)) {
            break label339;
          }
          this.vvW.setText(com.tencent.mm.wallet_core.ui.f.C(paraml.dPq / 100.0D));
          if (paraml.vAr == 1) {
            break label328;
          }
          this.vHq.vvS = true;
          label180:
          this.vwi.setVisibility(0);
          label188:
          if (bu.isNullOrNil(paraml.vxB)) {
            break label391;
          }
          this.vwj.setVisibility(0);
          this.mpP.setText(paraml.vxB);
          if (paraml.vxz != 1) {
            break label363;
          }
          if ((TextUtils.isEmpty(paraml.vxA)) || (paraml.vxA.startsWith("weixin://wxpay"))) {
            break label351;
          }
          this.vHg.setVisibility(0);
          label256:
          this.mpP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65453);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (!TextUtils.isEmpty(paraml.vxA))
              {
                ae.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + paraml.vxA);
                if (paraml.vxA.startsWith("weixin://wxpay"))
                {
                  com.tencent.mm.wallet_core.ui.f.aha(12);
                  com.tencent.mm.pluginsdk.wallet.f.aw(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65453);
                return;
                com.tencent.mm.wallet_core.ui.f.aha(7);
                com.tencent.mm.wallet_core.ui.f.aY(localAppCompatActivity, paraml.vxA);
                continue;
                com.tencent.mm.wallet_core.ui.f.aha(12);
                com.tencent.mm.pluginsdk.wallet.f.aw(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                ae.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
              }
            }
          });
        }
      }
      for (;;)
      {
        if (bu.isNullOrNil(paraml.vAu)) {
          break label411;
        }
        this.lHT.setText(paraml.vAu);
        AppMethodBeat.o(65473);
        return;
        if (bu.isNullOrNil(paraml.vAk)) {
          break;
        }
        z.b(this.vwf, paraml.vAk, paraml.vAE);
        break;
        label328:
        this.vHq.vvS = false;
        break label180;
        label339:
        this.vwi.setVisibility(8);
        break label188;
        label351:
        this.vHg.setVisibility(8);
        break label256;
        label363:
        ae.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.mpP.setTextColor(getResources().getColor(2131100598));
        continue;
        label391:
        ae.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.vwj.setVisibility(8);
      }
      label411:
      this.lHT.setText(null);
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
    if (((paraml.dPd == 3) || (paraml.dPd == 2)) && (paraml.vAs == 1) && (!this.vHj) && (paraml.vAv == 1))
    {
      i = 1;
      if ((paraml.vAw == null) || (paraml.vAw.gaV != 1) || (bu.isNullOrNil(paraml.vAw.vzR))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.pPh.findViewById(2131297623);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paraml));
      if (j != 0)
      {
        this.vHn = paraml.vAw.vzR;
        localTextView1.setText(paraml.vAw.vzS);
      }
      g.yxI.f(11701, new Object[] { Integer.valueOf(JN(paraml.vAB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.pPh.findViewById(2131297620);
      if ((this.vHk == 1) || (this.vHk == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paraml));
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.vHs)
      {
        this.vwe.addFooterView(this.pPh);
        this.vHs = true;
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
  
  private void d(l paraml)
  {
    AppMethodBeat.i(65477);
    if (paraml != null)
    {
      Object localObject1 = paraml.vAx;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.agn.findViewById(2131297616);
        View localView1 = this.agn.findViewById(2131297617);
        View localView2 = this.agn.findViewById(2131297618);
        ViewGroup localViewGroup1 = (ViewGroup)this.agn.findViewById(2131297613);
        ViewGroup localViewGroup2 = (ViewGroup)this.agn.findViewById(2131297614);
        ViewGroup localViewGroup3 = (ViewGroup)this.agn.findViewById(2131297615);
        View localView3 = this.agn.findViewById(2131297608);
        View localView4 = this.agn.findViewById(2131297609);
        h.c localc = new h.c();
        localc.textColor = getResources().getColor(2131100574);
        localc.vLt = true;
        localc.resourceId = paraml.resourceId;
        localc.vLu = this.vHo;
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
          this.vHh.requestLayout();
          this.vHh.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.pPh.findViewById(2131297610);
      Object localObject2 = new h.c();
      ((h.c)localObject2).textColor = getResources().getColor(2131100574);
      ((h.c)localObject2).textSize = getResources().getDimensionPixelSize(2131165574);
      h.a(this, (ViewGroup)localObject1, paraml.vAy, (h.c)localObject2);
    }
    AppMethodBeat.o(65477);
  }
  
  private void dmh()
  {
    AppMethodBeat.i(65471);
    this.lpM = true;
    if ((this.fq > 0) && (this.vvQ.size() > 0) && (this.vvQ.get(this.vvQ.size() - 1) != null))
    {
      doSceneProgress(new ah(this.vHa, this.fq, this.vHm, bu.getLong(((y)this.vvQ.get(this.vvQ.size() - 1)).vBt, 0L), "v1.0", this.vHr));
      AppMethodBeat.o(65471);
      return;
    }
    this.vHr = "";
    doSceneProgress(new ah(this.vHa, 11, this.fq, this.vHm, "v1.0", this.vHr));
    AppMethodBeat.o(65471);
  }
  
  private void dmi()
  {
    AppMethodBeat.i(65475);
    new DisplayMetrics();
    Object localObject = ak.getContext().getResources().getDisplayMetrics();
    if (localObject == null)
    {
      AppMethodBeat.o(65475);
      return;
    }
    int i = (int)((((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(2131166496) * 2 - getResources().getDimensionPixelSize(2131166495) * 2) * 0.75F);
    localObject = this.vHi.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.vHi.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void dmj()
  {
    AppMethodBeat.i(65478);
    if ((this.vHf != null) && (this.vHf.getVisibility() != 8)) {
      this.vHf.setVisibility(8);
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
  
  private void hT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.vHi.setImageResource(2131232966);
    if (bu.isNullOrNil(paramString1))
    {
      ae.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.vHi.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    dmi();
    z.a(this.vHi, paramString1, paramString2);
    this.vHi.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.vHf.getVisibility() == 0))
    {
      this.vHf.setVisibility(8);
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
        if (!bu.isNullOrNil(str)) {
          if ((this.vHn != null) && (this.vHn.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            ae.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.vHa, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    this.vwe = ((ListView)findViewById(2131297621));
    this.vHq = new i(getContext());
    this.agn = LayoutInflater.from(this).inflate(2131494629, null);
    this.vwe.addHeaderView(this.agn);
    this.vwe.setAdapter(this.vHq);
    this.agn.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.vwe.setOnScrollListener(this.vwl);
    this.vwe.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.pPh = LayoutInflater.from(this).inflate(2131494628, null);
    this.vwf = ((ImageView)this.agn.findViewById(2131297604));
    this.vwg = ((TextView)this.agn.findViewById(2131297625));
    this.uSM = ((TextView)this.agn.findViewById(2131297627));
    this.vwi = this.agn.findViewById(2131297603);
    this.vvW = ((TextView)this.agn.findViewById(2131297602));
    this.vwj = this.agn.findViewById(2131297611);
    this.mpP = ((TextView)this.agn.findViewById(2131297624));
    this.vHg = ((ImageView)this.agn.findViewById(2131297612));
    this.lHT = ((TextView)this.agn.findViewById(2131297607));
    this.vHh = this.agn.findViewById(2131297619);
    this.vHi = ((ImageView)this.agn.findViewById(2131297601));
    paramBundle = (ImageView)findViewById(2131297606);
    this.vHf = ((LuckyMoneyWishFooter)findViewById(2131297626));
    Object localObject = this.vHf;
    LuckyMoneyBusiDetailUI.9 local9 = new LuckyMoneyBusiDetailUI.9(this);
    if (((LuckyMoneyWishFooter)localObject).vNt != null) {
      ((LuckyMoneyWishFooter)localObject).vNt.setBackListener(local9);
    }
    this.vHf.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void aqg(String paramAnonymousString)
      {
        AppMethodBeat.i(65459);
        if ((!bu.isNullOrNil(paramAnonymousString)) && (!bu.isNullOrNil(LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this))))
        {
          paramAnonymousString = new ao(LuckyMoneyBusiDetailUI.h(LuckyMoneyBusiDetailUI.this), paramAnonymousString, LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this), "v1.0");
          LuckyMoneyBusiDetailUI.this.doSceneProgress(paramAnonymousString);
          LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        }
        AppMethodBeat.o(65459);
      }
    });
    this.vHf.post(new LuckyMoneyBusiDetailUI.11(this));
    this.vHf.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.vHq.vNf = new LuckyMoneyBusiDetailUI.13(this);
    localObject = this.vHq;
    ((i)localObject).vNg = new i.a((i)localObject);
    this.vHf.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(2131297605));
    this.vHa = getIntent().getStringExtra("key_sendid");
    this.vHm = getIntent().getStringExtra("key_native_url");
    this.vHk = getIntent().getIntExtra("key_jump_from", 2);
    this.vHo = getIntent().getIntExtra("key_static_from_scene", 0);
    ae.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.vHa, this.vHm, Integer.valueOf(this.vHk) });
    if (this.vHk == 2) {}
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
              k.a(this, k.a.vND);
            }
            AppMethodBeat.o(65465);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        ae.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((bu.isNullOrNil(this.vHa)) && (!bu.isNullOrNil(this.vHm))) {
        paramBundle = Uri.parse(this.vHm);
      }
      try
      {
        this.vHa = paramBundle.getQueryParameter("sendid");
        if (!bu.isNullOrNil(this.vHa)) {
          dmh();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ae.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + paramBundle.getLocalizedMessage());
        }
        ae.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65479);
    super.onDestroy();
    if (this.vHf != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.vHf;
      if (localLuckyMoneyWishFooter.qdo != null)
      {
        ae.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.qdo.ffs();
        localLuckyMoneyWishFooter.qdo.destroy();
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
        paramn = paramString.vBT;
        this.vHr = paramString.vCf;
        a(paramn);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cm(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cm(this, getString(2131760233));
        this.vHq.vvS = false;
        dmj();
        paramString = (ao)paramn;
        if (this.vvQ != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.vvQ.size())
          {
            paramn = (y)this.vvQ.get(paramInt1);
            if (paramn.vAq.equalsIgnoreCase(paramString.vAq))
            {
              paramn.vBH = paramString.vvw;
              this.vHq.notifyDataSetChanged();
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
      com.tencent.mm.ui.base.h.cm(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cm(this, getString(2131760233));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cm(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */