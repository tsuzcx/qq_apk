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
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.jq.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private View agA;
  private int fs;
  private TextView jVn;
  private boolean mwr;
  private TextView nAB;
  private View rfF;
  private List<ad> yQe;
  private TextView yQk;
  private ListView yQs;
  private ImageView yQt;
  private TextView yQu;
  private View yQw;
  private View yQx;
  AbsListView.OnScrollListener yQz;
  private String yUc;
  private String yUq;
  private TextView yln;
  private LuckyMoneyWishFooter zce;
  private ImageView zcf;
  private View zcg;
  private ImageView zch;
  private boolean zci;
  private int zcj;
  private String zck;
  private String zcl;
  private int zcm;
  private Map<String, Integer> zcn;
  private j zco;
  private String zcp;
  private boolean zcq;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.fs = 0;
    this.zci = true;
    this.mwr = false;
    this.zcm = 0;
    this.yQe = new LinkedList();
    this.zcn = new HashMap();
    this.zcp = "";
    this.zcq = false;
    this.yQz = new AbsListView.OnScrollListener()
    {
      private boolean yQA = false;
      private boolean yQB;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.yQA))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label101:
        for (;;)
        {
          if (this.yQB != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(2131233600);
            }
            this.yQB = bool;
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
            if (!LuckyMoneyBusiDetailUI.this.zbX.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.yQA = false;
          AppMethodBeat.o(65449);
          return;
          this.yQA = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int PP(int paramInt)
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
    if (paramq.yVn == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.zci = bool;
      if (this.fs == 0)
      {
        this.zck = paramq.yVk;
        this.zco.yQf = this.zck;
        this.zco.yQh = paramq.yVv;
        b(paramq);
        d(paramq);
        com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(PP(paramq.yVv)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paramq);
      localLinkedList = paramq.yVw;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        ad localad = (ad)localLinkedList.get(i);
        if (!this.zcn.containsKey(localad.yVk))
        {
          this.yQe.add(localLinkedList.get(i));
          this.zcn.put(localad.yVk, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.fs += localLinkedList.size();
    this.mwr = false;
    this.zco.fq(this.yQe);
    label271:
    iD(paramq.yVu, paramq.yVx);
    com.tencent.mm.plugin.report.service.h.CyF.a(13051, new Object[] { Integer.valueOf(this.zcm), Integer.valueOf(1), paramq.yVu, af.fr(paramq.yVr), "", "", "", "", paramq.yVd, Integer.valueOf(paramq.resourceId) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final com.tencent.mm.plugin.luckymoney.model.q paramq)
  {
    AppMethodBeat.i(65473);
    if (paramq != null)
    {
      final AppCompatActivity localAppCompatActivity = getContext();
      if (paramq.yVv == 2)
      {
        this.yQt.setImageResource(2131233617);
        if (paramq.resourceId != 0)
        {
          Log.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramq.resourceId);
          final jq localjq = new jq();
          localjq.dOw.dOy = paramq.resourceId;
          localjq.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (localjq.dOx.dOz)
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + localjq.dOx.dOA);
                LuckyMoneyBusiDetailUI.this.getContext();
                af.s(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), localjq.dOx.dOA);
                AppMethodBeat.o(65452);
                return;
              }
              Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!Util.isNullOrNil(paramq.yVe)) {
                af.a(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paramq.yVe, paramq.yVy);
              }
              AppMethodBeat.o(65452);
            }
          };
          EventCenter.instance.asyncPublish(localjq, Looper.myLooper());
          af.a(localAppCompatActivity, this.yQu, paramq.yVd);
          af.a(localAppCompatActivity, this.yln, paramq.yPK);
          if ((paramq.eha != 2) || (this.zcj == 3)) {
            break label339;
          }
          this.yQk.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(paramq.eht / 100.0D));
          if (paramq.yVl == 1) {
            break label328;
          }
          this.zco.yQg = true;
          label180:
          this.yQw.setVisibility(0);
          label188:
          if (Util.isNullOrNil(paramq.yRP)) {
            break label391;
          }
          this.yQx.setVisibility(0);
          this.nAB.setText(paramq.yRP);
          if (paramq.yRN != 1) {
            break label363;
          }
          if ((TextUtils.isEmpty(paramq.yRO)) || (paramq.yRO.startsWith("weixin://wxpay"))) {
            break label351;
          }
          this.zcf.setVisibility(0);
          label256:
          this.nAB.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65453);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (!TextUtils.isEmpty(paramq.yRO))
              {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + paramq.yRO);
                if (paramq.yRO.startsWith("weixin://wxpay"))
                {
                  com.tencent.mm.wallet_core.ui.f.aqm(12);
                  com.tencent.mm.pluginsdk.wallet.f.aF(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65453);
                return;
                com.tencent.mm.wallet_core.ui.f.aqm(7);
                com.tencent.mm.wallet_core.ui.f.bn(localAppCompatActivity, paramq.yRO);
                continue;
                com.tencent.mm.wallet_core.ui.f.aqm(12);
                com.tencent.mm.pluginsdk.wallet.f.aF(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
              }
            }
          });
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramq.yVo)) {
          break label411;
        }
        this.jVn.setText(paramq.yVo);
        AppMethodBeat.o(65473);
        return;
        if (Util.isNullOrNil(paramq.yVe)) {
          break;
        }
        af.a(this.yQt, paramq.yVe, paramq.yVy);
        break;
        label328:
        this.zco.yQg = false;
        break label180;
        label339:
        this.yQw.setVisibility(8);
        break label188;
        label351:
        this.zcf.setVisibility(8);
        break label256;
        label363:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.nAB.setTextColor(getResources().getColor(2131100766));
        continue;
        label391:
        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.yQx.setVisibility(8);
      }
      label411:
      this.jVn.setText(null);
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
    if (((paramq.egZ == 3) || (paramq.egZ == 2)) && (paramq.yVm == 1) && (!this.zci) && (paramq.yVp == 1))
    {
      i = 1;
      if ((paramq.yVq == null) || (paramq.yVq.gGn != 1) || (Util.isNullOrNil(paramq.yVq.yUG))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.rfF.findViewById(2131297885);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paramq));
      if (j != 0)
      {
        this.zcl = paramq.yVq.yUG;
        localTextView1.setText(paramq.yVq.yUH);
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11701, new Object[] { Integer.valueOf(PP(paramq.yVv)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.rfF.findViewById(2131297882);
      if ((this.zcj == 1) || (this.zcj == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paramq));
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.zcq)
      {
        this.yQs.addFooterView(this.rfF);
        this.zcq = true;
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
      Object localObject1 = paramq.yVr;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.agA.findViewById(2131297878);
        View localView1 = this.agA.findViewById(2131297879);
        View localView2 = this.agA.findViewById(2131297880);
        ViewGroup localViewGroup1 = (ViewGroup)this.agA.findViewById(2131297875);
        ViewGroup localViewGroup2 = (ViewGroup)this.agA.findViewById(2131297876);
        ViewGroup localViewGroup3 = (ViewGroup)this.agA.findViewById(2131297877);
        View localView3 = this.agA.findViewById(2131297870);
        View localView4 = this.agA.findViewById(2131297871);
        i.c localc = new i.c();
        localc.textColor = getResources().getColor(2131100742);
        localc.zgx = true;
        localc.resourceId = paramq.resourceId;
        localc.zgy = this.zcm;
        if (((List)localObject1).size() > 0)
        {
          i.a(this, localViewGroup1, (bg)((List)localObject1).get(0), localc);
          ((View)localObject2).setVisibility(0);
        }
        if (((List)localObject1).size() > 1)
        {
          i.a(this, localViewGroup2, (bg)((List)localObject1).get(1), localc);
          localView1.setVisibility(0);
        }
        if (((List)localObject1).size() > 2)
        {
          i.a(this, localViewGroup3, (bg)((List)localObject1).get(2), localc);
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
          this.zcg.requestLayout();
          this.zcg.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.rfF.findViewById(2131297872);
      Object localObject2 = new i.c();
      ((i.c)localObject2).textColor = getResources().getColor(2131100742);
      ((i.c)localObject2).textSize = getResources().getDimensionPixelSize(2131165592);
      i.a(this, (ViewGroup)localObject1, paramq.yVs, (i.c)localObject2);
    }
    AppMethodBeat.o(65477);
  }
  
  private void egc()
  {
    AppMethodBeat.i(65471);
    this.mwr = true;
    if ((this.fs > 0) && (this.yQe.size() > 0) && (this.yQe.get(this.yQe.size() - 1) != null))
    {
      doSceneProgress(new ao(this.yUc, this.fs, this.yUq, Util.getLong(((ad)this.yQe.get(this.yQe.size() - 1)).yWp, 0L), "v1.0", this.zcp));
      AppMethodBeat.o(65471);
      return;
    }
    this.zcp = "";
    doSceneProgress(new ao(this.yUc, 11, this.fs, this.yUq, "v1.0", this.zcp));
    AppMethodBeat.o(65471);
  }
  
  private void egd()
  {
    AppMethodBeat.i(65475);
    new DisplayMetrics();
    Object localObject = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    if (localObject == null)
    {
      AppMethodBeat.o(65475);
      return;
    }
    int i = (int)((((DisplayMetrics)localObject).widthPixels - getResources().getDimensionPixelSize(2131166611) * 2 - getResources().getDimensionPixelSize(2131166610) * 2) * 0.75F);
    localObject = this.zch.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.zch.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void ege()
  {
    AppMethodBeat.i(65478);
    if ((this.zce != null) && (this.zce.getVisibility() != 8)) {
      this.zce.setVisibility(8);
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
  
  private void iD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.zch.setImageResource(2131233616);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.zch.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    egd();
    af.b(this.zch, paramString1, paramString2, false);
    this.zch.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.zce.getVisibility() == 0))
    {
      this.zce.setVisibility(8);
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
    return 2131495352;
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
          if ((this.zcl != null) && (this.zcl.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new bf(str.replaceAll(",", "|"), this.yUc, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    this.yQs = ((ListView)findViewById(2131297883));
    this.zco = new j(getContext());
    this.agA = LayoutInflater.from(this).inflate(2131495351, null);
    this.yQs.addHeaderView(this.agA);
    this.yQs.setAdapter(this.zco);
    this.agA.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.yQs.setOnScrollListener(this.yQz);
    this.yQs.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.rfF = LayoutInflater.from(this).inflate(2131495350, null);
    this.yQt = ((ImageView)this.agA.findViewById(2131297866));
    this.yQu = ((TextView)this.agA.findViewById(2131297887));
    this.yln = ((TextView)this.agA.findViewById(2131297889));
    this.yQw = this.agA.findViewById(2131297865);
    this.yQk = ((TextView)this.agA.findViewById(2131297864));
    this.yQx = this.agA.findViewById(2131297873);
    this.nAB = ((TextView)this.agA.findViewById(2131297886));
    this.zcf = ((ImageView)this.agA.findViewById(2131297874));
    this.jVn = ((TextView)this.agA.findViewById(2131297869));
    this.zcg = this.agA.findViewById(2131297881);
    this.zch = ((ImageView)this.agA.findViewById(2131297863));
    paramBundle = (ImageView)findViewById(2131297868);
    this.zce = ((LuckyMoneyWishFooter)findViewById(2131297888));
    Object localObject = this.zce;
    LuckyMoneyBusiDetailUI.9 local9 = new LuckyMoneyBusiDetailUI.9(this);
    if (((LuckyMoneyWishFooter)localObject).ziR != null) {
      ((LuckyMoneyWishFooter)localObject).ziR.setBackListener(local9);
    }
    this.zce.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void aDC(String paramAnonymousString)
      {
        AppMethodBeat.i(65459);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this))))
        {
          paramAnonymousString = new ax(LuckyMoneyBusiDetailUI.h(LuckyMoneyBusiDetailUI.this), paramAnonymousString, LuckyMoneyBusiDetailUI.g(LuckyMoneyBusiDetailUI.this), "v1.0");
          LuckyMoneyBusiDetailUI.this.doSceneProgress(paramAnonymousString);
          LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        }
        AppMethodBeat.o(65459);
      }
    });
    this.zce.post(new LuckyMoneyBusiDetailUI.11(this));
    this.zce.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.zco.ziC = new LuckyMoneyBusiDetailUI.13(this);
    localObject = this.zco;
    ((j)localObject).ziD = new j.a((j)localObject);
    this.zce.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(2131297867));
    this.yUc = getIntent().getStringExtra("key_sendid");
    this.yUq = getIntent().getStringExtra("key_native_url");
    this.zcj = getIntent().getIntExtra("key_jump_from", 2);
    this.zcm = getIntent().getIntExtra("key_static_from_scene", 0);
    Log.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.yUc, this.yUq, Integer.valueOf(this.zcj) });
    if (this.zcj == 2) {}
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
              l.a(this, l.a.zjb);
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
      if ((Util.isNullOrNil(this.yUc)) && (!Util.isNullOrNil(this.yUq))) {
        paramBundle = Uri.parse(this.yUq);
      }
      try
      {
        this.yUc = paramBundle.getQueryParameter("sendid");
        if (!Util.isNullOrNil(this.yUc)) {
          egc();
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
    if (this.zce != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.zce;
      if (localLuckyMoneyWishFooter.rum != null)
      {
        Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.rum.goC();
        localLuckyMoneyWishFooter.rum.destroy();
      }
    }
    AppMethodBeat.o(65479);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65468);
    if ((paramq instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ao)paramq;
        paramq = paramString.yWT;
        this.zcp = paramString.yXg;
        a(paramq);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cD(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramq instanceof ax))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cD(this, getString(2131761619));
        this.zco.yQg = false;
        ege();
        paramString = (ax)paramq;
        if (this.yQe != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.yQe.size())
          {
            paramq = (ad)this.yQe.get(paramInt1);
            if (paramq.yVk.equalsIgnoreCase(paramString.yVk))
            {
              paramq.yWF = paramString.yPK;
              this.zco.notifyDataSetChanged();
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
      com.tencent.mm.ui.base.h.cD(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramq instanceof bf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cD(this, getString(2131761619));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cD(this, paramString);
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