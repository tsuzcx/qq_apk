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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.il.b;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int LZ;
  private View adC;
  private TextView kFd;
  private boolean knt;
  private TextView lln;
  private View oBA;
  private List<y> sYN;
  private TextView sYT;
  private ListView sZb;
  private ImageView sZc;
  private TextView sZd;
  private View sZf;
  private View sZg;
  AbsListView.OnScrollListener sZi;
  private TextView swB;
  private String tka;
  private LuckyMoneyWishFooter tkf;
  private ImageView tkg;
  private View tkh;
  private ImageView tki;
  private boolean tkj;
  private int tkk;
  private String tkl;
  private String tkm;
  private String tkn;
  private int tko;
  private Map<String, Integer> tkp;
  private i tkq;
  private String tkr;
  private boolean tks;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.LZ = 0;
    this.tkj = true;
    this.knt = false;
    this.tko = 0;
    this.sYN = new LinkedList();
    this.tkp = new HashMap();
    this.tkr = "";
    this.tks = false;
    this.sZi = new AbsListView.OnScrollListener()
    {
      private boolean sZj = false;
      private boolean sZk;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.sZj))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label101:
        for (;;)
        {
          if (this.sZk != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.sZk = bool;
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
            if (!LuckyMoneyBusiDetailUI.this.tjY.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.sZj = false;
          AppMethodBeat.o(65449);
          return;
          this.sZj = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int FX(int paramInt)
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
    if (paraml.tdt == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.tkj = bool;
      if (this.LZ == 0)
      {
        this.tkl = paraml.tdq;
        this.tkq.sYO = this.tkl;
        this.tkq.sYQ = paraml.tdB;
        b(paraml);
        d(paraml);
        com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(FX(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paraml);
      localLinkedList = paraml.tdC;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        y localy = (y)localLinkedList.get(i);
        if (!this.tkp.containsKey(localy.tdq))
        {
          this.sYN.add(localLinkedList.get(i));
          this.tkp.put(localy.tdq, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.LZ += localLinkedList.size();
    this.knt = false;
    this.tkq.eb(this.sYN);
    label271:
    hh(paraml.tdA, paraml.tdD);
    com.tencent.mm.plugin.report.service.h.vKh.f(13051, new Object[] { Integer.valueOf(this.tko), Integer.valueOf(1), paraml.tdA, z.ec(paraml.tdx), "", "", "", "", paraml.tdj, Integer.valueOf(paraml.resourceId) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final l paraml)
  {
    AppMethodBeat.i(65473);
    if (paraml != null)
    {
      final AppCompatActivity localAppCompatActivity = getContext();
      if (paraml.tdB == 2)
      {
        this.sZc.setImageResource(2131232967);
        if (paraml.resourceId != 0)
        {
          ad.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
          final il localil = new il();
          localil.dmp.dmr = paraml.resourceId;
          localil.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (localil.dmq.dms)
              {
                ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + localil.dmq.dmt);
                LuckyMoneyBusiDetailUI.this.getContext();
                z.p(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), localil.dmq.dmt);
                AppMethodBeat.o(65452);
                return;
              }
              ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!bt.isNullOrNil(paraml.tdk)) {
                z.b(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paraml.tdk, paraml.tdE);
              }
              AppMethodBeat.o(65452);
            }
          };
          com.tencent.mm.sdk.b.a.ESL.a(localil, Looper.myLooper());
          z.a(localAppCompatActivity, this.sZd, paraml.tdj);
          z.a(localAppCompatActivity, this.swB, paraml.sYt);
          if ((paraml.dDP != 2) || (this.tkk == 3)) {
            break label339;
          }
          this.sYT.setText(e.D(paraml.dEb / 100.0D));
          if (paraml.tdr == 1) {
            break label328;
          }
          this.tkq.sYP = true;
          label180:
          this.sZf.setVisibility(0);
          label188:
          if (bt.isNullOrNil(paraml.taz)) {
            break label391;
          }
          this.sZg.setVisibility(0);
          this.lln.setText(paraml.taz);
          if (paraml.tax != 1) {
            break label363;
          }
          if ((TextUtils.isEmpty(paraml.tay)) || (paraml.tay.startsWith("weixin://wxpay"))) {
            break label351;
          }
          this.tkg.setVisibility(0);
          label256:
          this.lln.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65453);
              if (!TextUtils.isEmpty(paraml.tay))
              {
                ad.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + paraml.tay);
                if (paraml.tay.startsWith("weixin://wxpay"))
                {
                  e.aby(12);
                  com.tencent.mm.pluginsdk.wallet.f.an(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                  AppMethodBeat.o(65453);
                  return;
                }
                e.aby(7);
                e.aS(localAppCompatActivity, paraml.tay);
                AppMethodBeat.o(65453);
                return;
              }
              e.aby(12);
              com.tencent.mm.pluginsdk.wallet.f.an(LuckyMoneyBusiDetailUI.this.getContext(), 1);
              ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
              AppMethodBeat.o(65453);
            }
          });
        }
      }
      for (;;)
      {
        if (bt.isNullOrNil(paraml.tdu)) {
          break label411;
        }
        this.kFd.setText(paraml.tdu);
        AppMethodBeat.o(65473);
        return;
        if (bt.isNullOrNil(paraml.tdk)) {
          break;
        }
        z.b(this.sZc, paraml.tdk, paraml.tdE);
        break;
        label328:
        this.tkq.sYP = false;
        break label180;
        label339:
        this.sZf.setVisibility(8);
        break label188;
        label351:
        this.tkg.setVisibility(8);
        break label256;
        label363:
        ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.lln.setTextColor(getResources().getColor(2131100598));
        continue;
        label391:
        ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.sZg.setVisibility(8);
      }
      label411:
      this.kFd.setText(null);
    }
    AppMethodBeat.o(65473);
  }
  
  private void c(final l paraml)
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
    if (((paraml.dDO == 3) || (paraml.dDO == 2)) && (paraml.tds == 1) && (!this.tkj) && (paraml.tdv == 1))
    {
      i = 1;
      if ((paraml.tdw == null) || (paraml.tdw.fBI != 1) || (bt.isNullOrNil(paraml.tdw.tcR))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.oBA.findViewById(2131297623);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65454);
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.FY(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          z.a(LuckyMoneyBusiDetailUI.this, 1, false);
          AppMethodBeat.o(65454);
        }
      });
      if (j != 0)
      {
        this.tkn = paraml.tdw.tcR;
        localTextView1.setText(paraml.tdw.tcS);
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(FX(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.oBA.findViewById(2131297620);
      if ((this.tkk == 1) || (this.tkk == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65455);
          com.tencent.mm.plugin.report.service.h.vKh.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.FY(paraml.tdB)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          Object localObject = new Intent();
          ((Intent)localObject).setClass(LuckyMoneyBusiDetailUI.this.getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject).putExtra("key_type", 2);
          paramAnonymousView = LuckyMoneyBusiDetailUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(65455);
        }
      });
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.tks)
      {
        this.sZb.addFooterView(this.oBA);
        this.tks = true;
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
  
  private void cMp()
  {
    AppMethodBeat.i(65471);
    this.knt = true;
    if ((this.LZ > 0) && (this.sYN.size() > 0) && (this.sYN.get(this.sYN.size() - 1) != null))
    {
      doSceneProgress(new ah(this.tka, this.LZ, this.tkm, bt.getLong(((y)this.sYN.get(this.sYN.size() - 1)).tet, 0L), "v1.0", this.tkr));
      AppMethodBeat.o(65471);
      return;
    }
    this.tkr = "";
    doSceneProgress(new ah(this.tka, 11, this.LZ, this.tkm, "v1.0", this.tkr));
    AppMethodBeat.o(65471);
  }
  
  private void cMq()
  {
    AppMethodBeat.i(65475);
    new DisplayMetrics();
    Object localObject = aj.getContext().getResources().getDisplayMetrics();
    if (localObject == null)
    {
      AppMethodBeat.o(65475);
      return;
    }
    int i = (int)((((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(2131166496) * 2 - getResources().getDimensionPixelSize(2131166495) * 2) * 0.75F);
    localObject = this.tki.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.tki.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void cMr()
  {
    AppMethodBeat.i(65478);
    if ((this.tkf != null) && (this.tkf.getVisibility() != 8)) {
      this.tkf.setVisibility(8);
    }
    AppMethodBeat.o(65478);
  }
  
  private void d(l paraml)
  {
    AppMethodBeat.i(65477);
    if (paraml != null)
    {
      Object localObject1 = paraml.tdx;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.adC.findViewById(2131297616);
        View localView1 = this.adC.findViewById(2131297617);
        View localView2 = this.adC.findViewById(2131297618);
        ViewGroup localViewGroup1 = (ViewGroup)this.adC.findViewById(2131297613);
        ViewGroup localViewGroup2 = (ViewGroup)this.adC.findViewById(2131297614);
        ViewGroup localViewGroup3 = (ViewGroup)this.adC.findViewById(2131297615);
        View localView3 = this.adC.findViewById(2131297608);
        View localView4 = this.adC.findViewById(2131297609);
        h.c localc = new h.c();
        localc.textColor = getResources().getColor(2131100574);
        localc.tou = true;
        localc.resourceId = paraml.resourceId;
        localc.tov = this.tko;
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
          this.tkh.requestLayout();
          this.tkh.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.oBA.findViewById(2131297610);
      Object localObject2 = new h.c();
      ((h.c)localObject2).textColor = getResources().getColor(2131100574);
      ((h.c)localObject2).textSize = getResources().getDimensionPixelSize(2131165574);
      h.a(this, (ViewGroup)localObject1, paraml.tdy, (h.c)localObject2);
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
  
  private void hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.tki.setImageResource(2131232966);
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.tki.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    cMq();
    z.a(this.tki, paramString1, paramString2);
    this.tki.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.tkf.getVisibility() == 0))
    {
      this.tkf.setVisibility(8);
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
        if (!bt.isNullOrNil(str)) {
          if ((this.tkn != null) && (this.tkn.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            ad.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.tka, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    this.sZb = ((ListView)findViewById(2131297621));
    this.tkq = new i(getContext());
    this.adC = LayoutInflater.from(this).inflate(2131494629, null);
    this.sZb.addHeaderView(this.adC);
    this.sZb.setAdapter(this.tkq);
    this.adC.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.sZb.setOnScrollListener(this.sZi);
    this.sZb.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.oBA = LayoutInflater.from(this).inflate(2131494628, null);
    this.sZc = ((ImageView)this.adC.findViewById(2131297604));
    this.sZd = ((TextView)this.adC.findViewById(2131297625));
    this.swB = ((TextView)this.adC.findViewById(2131297627));
    this.sZf = this.adC.findViewById(2131297603);
    this.sYT = ((TextView)this.adC.findViewById(2131297602));
    this.sZg = this.adC.findViewById(2131297611);
    this.lln = ((TextView)this.adC.findViewById(2131297624));
    this.tkg = ((ImageView)this.adC.findViewById(2131297612));
    this.kFd = ((TextView)this.adC.findViewById(2131297607));
    this.tkh = this.adC.findViewById(2131297619);
    this.tki = ((ImageView)this.adC.findViewById(2131297601));
    paramBundle = (ImageView)findViewById(2131297606);
    this.tkf = ((LuckyMoneyWishFooter)findViewById(2131297626));
    Object localObject = this.tkf;
    LuckyMoneyBusiDetailUI.9 local9 = new LuckyMoneyBusiDetailUI.9(this);
    if (((LuckyMoneyWishFooter)localObject).tqv != null) {
      ((LuckyMoneyWishFooter)localObject).tqv.setBackListener(local9);
    }
    this.tkf.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void afu(String paramAnonymousString)
      {
        AppMethodBeat.i(65459);
        if ((!bt.isNullOrNil(paramAnonymousString)) && (!bt.isNullOrNil(LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this))))
        {
          paramAnonymousString = new ao(LuckyMoneyBusiDetailUI.h(LuckyMoneyBusiDetailUI.this), paramAnonymousString, LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this), "v1.0");
          LuckyMoneyBusiDetailUI.this.doSceneProgress(paramAnonymousString);
          LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        }
        AppMethodBeat.o(65459);
      }
    });
    this.tkf.post(new LuckyMoneyBusiDetailUI.11(this));
    this.tkf.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.tkq.tqg = new LuckyMoneyBusiDetailUI.13(this);
    localObject = this.tkq;
    ((i)localObject).tqh = new i.a((i)localObject);
    this.tkf.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(2131297605));
    this.tka = getIntent().getStringExtra("key_sendid");
    this.tkm = getIntent().getStringExtra("key_native_url");
    this.tkk = getIntent().getIntExtra("key_jump_from", 2);
    this.tko = getIntent().getIntExtra("key_static_from_scene", 0);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.tka, this.tkm, Integer.valueOf(this.tkk) });
    if (this.tkk == 2) {}
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
              k.a(this, k.a.tqF);
            }
            AppMethodBeat.o(65465);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        ad.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((bt.isNullOrNil(this.tka)) && (!bt.isNullOrNil(this.tkm))) {
        paramBundle = Uri.parse(this.tkm);
      }
      try
      {
        this.tka = paramBundle.getQueryParameter("sendid");
        if (!bt.isNullOrNil(this.tka)) {
          cMp();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ad.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + paramBundle.getLocalizedMessage());
        }
        ad.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65479);
    super.onDestroy();
    if (this.tkf != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.tkf;
      if (localLuckyMoneyWishFooter.fSY != null)
      {
        ad.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.fSY.exm();
        localLuckyMoneyWishFooter.fSY.destroy();
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
        paramn = paramString.teT;
        this.tkr = paramString.tff;
        a(paramn);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cf(this, getString(2131760233));
        this.tkq.sYP = false;
        cMr();
        paramString = (ao)paramn;
        if (this.sYN != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.sYN.size())
          {
            paramn = (y)this.sYN.get(paramInt1);
            if (paramn.tdq.equalsIgnoreCase(paramString.tdq))
            {
              paramn.teH = paramString.sYt;
              this.tkq.notifyDataSetChanged();
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
      com.tencent.mm.ui.base.h.cf(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cf(this, getString(2131760233));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cf(this, paramString);
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