package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.b;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.KeyboardLinearLayout.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.wallet_core.ui.e;
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
  private TextView lDu;
  private boolean llo;
  private TextView mkS;
  private View pIC;
  private TextView uGZ;
  private List<y> vjL;
  private TextView vjR;
  private ListView vjZ;
  private ImageView vka;
  private TextView vkb;
  private View vkd;
  private View vke;
  AbsListView.OnScrollListener vkg;
  private String vuW;
  private LuckyMoneyWishFooter vvb;
  private ImageView vvc;
  private View vvd;
  private ImageView vve;
  private boolean vvf;
  private int vvg;
  private String vvh;
  private String vvi;
  private String vvj;
  private int vvk;
  private Map<String, Integer> vvl;
  private i vvm;
  private String vvn;
  private boolean vvo;
  
  public LuckyMoneyBusiDetailUI()
  {
    AppMethodBeat.i(65464);
    this.fq = 0;
    this.vvf = true;
    this.llo = false;
    this.vvk = 0;
    this.vjL = new LinkedList();
    this.vvl = new HashMap();
    this.vvn = "";
    this.vvo = false;
    this.vkg = new AbsListView.OnScrollListener()
    {
      private boolean vkh = false;
      private boolean vki;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(65450);
        if ((paramAnonymousInt3 == 0) || (!this.vkh))
        {
          AppMethodBeat.o(65450);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label101:
        for (;;)
        {
          if (this.vki != bool)
          {
            if (bool) {
              LuckyMoneyBusiDetailUI.this.getResources().getDrawable(2131232950);
            }
            this.vki = bool;
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
            if (!LuckyMoneyBusiDetailUI.this.vuU.isProcessing()) {
              LuckyMoneyBusiDetailUI.a(LuckyMoneyBusiDetailUI.this);
            }
            if ((LuckyMoneyBusiDetailUI.b(LuckyMoneyBusiDetailUI.this)) && (!LuckyMoneyBusiDetailUI.c(LuckyMoneyBusiDetailUI.this))) {
              LuckyMoneyBusiDetailUI.d(LuckyMoneyBusiDetailUI.this);
            }
          }
          this.vkh = false;
          AppMethodBeat.o(65449);
          return;
          this.vkh = true;
        }
      }
    };
    AppMethodBeat.o(65464);
  }
  
  private static int Jo(int paramInt)
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
    if (paraml.voo == 1) {}
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      this.vvf = bool;
      if (this.fq == 0)
      {
        this.vvh = paraml.vol;
        this.vvm.vjM = this.vvh;
        this.vvm.vjO = paraml.vow;
        b(paraml);
        d(paraml);
        g.yhR.f(11701, new Object[] { Integer.valueOf(Jo(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      c(paraml);
      localLinkedList = paraml.vox;
      if (localLinkedList == null) {
        break label271;
      }
      int i = 0;
      while (i < localLinkedList.size())
      {
        y localy = (y)localLinkedList.get(i);
        if (!this.vvl.containsKey(localy.vol))
        {
          this.vjL.add(localLinkedList.get(i));
          this.vvl.put(localy.vol, Integer.valueOf(1));
        }
        i += 1;
      }
    }
    this.fq += localLinkedList.size();
    this.llo = false;
    this.vvm.es(this.vjL);
    label271:
    hM(paraml.vov, paraml.voy);
    g.yhR.f(13051, new Object[] { Integer.valueOf(this.vvk), Integer.valueOf(1), paraml.vov, z.et(paraml.vos), "", "", "", "", paraml.voe, Integer.valueOf(paraml.resourceId) });
    AppMethodBeat.o(65472);
  }
  
  private void b(final l paraml)
  {
    AppMethodBeat.i(65473);
    if (paraml != null)
    {
      final AppCompatActivity localAppCompatActivity = getContext();
      if (paraml.vow == 2)
      {
        this.vka.setImageResource(2131232967);
        if (paraml.resourceId != 0)
        {
          ad.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paraml.resourceId);
          final ja localja = new ja();
          localja.dvK.dvM = paraml.resourceId;
          localja.callback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(65452);
              if (localja.dvL.dvN)
              {
                ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + localja.dvL.dvO);
                LuckyMoneyBusiDetailUI.this.getContext();
                z.p(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), localja.dvL.dvO);
                AppMethodBeat.o(65452);
                return;
              }
              ad.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
              if (!bt.isNullOrNil(paraml.vof)) {
                z.b(LuckyMoneyBusiDetailUI.i(LuckyMoneyBusiDetailUI.this), paraml.vof, paraml.voz);
              }
              AppMethodBeat.o(65452);
            }
          };
          com.tencent.mm.sdk.b.a.IbL.a(localja, Looper.myLooper());
          z.a(localAppCompatActivity, this.vkb, paraml.voe);
          z.a(localAppCompatActivity, this.uGZ, paraml.vjr);
          if ((paraml.dNO != 2) || (this.vvg == 3)) {
            break label341;
          }
          this.vjR.setText(e.C(paraml.dOa / 100.0D));
          if (paraml.vom == 1) {
            break label330;
          }
          this.vvm.vjN = true;
          label182:
          this.vkd.setVisibility(0);
          label190:
          if (bt.isNullOrNil(paraml.vlw)) {
            break label394;
          }
          this.vke.setVisibility(0);
          this.mkS.setText(paraml.vlw);
          if (paraml.vlu != 1) {
            break label365;
          }
          if ((TextUtils.isEmpty(paraml.vlv)) || (paraml.vlv.startsWith("weixin://wxpay"))) {
            break label353;
          }
          this.vvc.setVisibility(0);
          label258:
          this.mkS.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(65453);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (!TextUtils.isEmpty(paraml.vlv))
              {
                ad.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + paraml.vlv);
                if (paraml.vlv.startsWith("weixin://wxpay"))
                {
                  e.agr(12);
                  com.tencent.mm.pluginsdk.wallet.f.aw(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65453);
                return;
                e.agr(7);
                e.aW(localAppCompatActivity, paraml.vlv);
                continue;
                e.agr(12);
                com.tencent.mm.pluginsdk.wallet.f.aw(LuckyMoneyBusiDetailUI.this.getContext(), 1);
                ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
              }
            }
          });
        }
      }
      for (;;)
      {
        if (bt.isNullOrNil(paraml.vop)) {
          break label415;
        }
        this.lDu.setText(paraml.vop);
        AppMethodBeat.o(65473);
        return;
        if (bt.isNullOrNil(paraml.vof)) {
          break;
        }
        z.b(this.vka, paraml.vof, paraml.voz);
        break;
        label330:
        this.vvm.vjN = false;
        break label182;
        label341:
        this.vkd.setVisibility(8);
        break label190;
        label353:
        this.vvc.setVisibility(8);
        break label258;
        label365:
        ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.mkS.setTextColor(getResources().getColor(2131100598));
        continue;
        label394:
        ad.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.vke.setVisibility(8);
      }
      label415:
      this.lDu.setText(null);
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
    if (((paraml.dNN == 3) || (paraml.dNN == 2)) && (paraml.von == 1) && (!this.vvf) && (paraml.voq == 1))
    {
      i = 1;
      if ((paraml.vor == null) || (paraml.vor.fYO != 1) || (bt.isNullOrNil(paraml.vor.vnM))) {
        break label309;
      }
      j = 1;
      localTextView1 = (TextView)this.pIC.findViewById(2131297623);
      if ((i == 0) && (j == 0)) {
        break label314;
      }
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65454);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          g.yhR.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.Jp(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
          z.a(LuckyMoneyBusiDetailUI.this, 1, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65454);
        }
      });
      if (j != 0)
      {
        this.vvj = paraml.vor.vnM;
        localTextView1.setText(paraml.vor.vnN);
      }
      g.yhR.f(11701, new Object[] { Integer.valueOf(Jo(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
      localTextView1.setVisibility(0);
      localTextView2 = (TextView)this.pIC.findViewById(2131297620);
      if ((this.vvg == 1) || (this.vvg == 3) || (localTextView1.getVisibility() == 0)) {
        break label324;
      }
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(65455);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          g.yhR.f(11701, new Object[] { Integer.valueOf(LuckyMoneyBusiDetailUI.Jp(paraml.vow)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
          localObject = new Intent();
          ((Intent)localObject).setClass(LuckyMoneyBusiDetailUI.this.getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject).putExtra("key_type", 2);
          paramAnonymousView = LuckyMoneyBusiDetailUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(65455);
        }
      });
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      if (!this.vvo)
      {
        this.vjZ.addFooterView(this.pIC);
        this.vvo = true;
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
      Object localObject1 = paraml.vos;
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
        localc.vzp = true;
        localc.resourceId = paraml.resourceId;
        localc.vzq = this.vvk;
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
          this.vvd.requestLayout();
          this.vvd.setVisibility(0);
        }
      }
      localObject1 = (ViewGroup)this.pIC.findViewById(2131297610);
      Object localObject2 = new h.c();
      ((h.c)localObject2).textColor = getResources().getColor(2131100574);
      ((h.c)localObject2).textSize = getResources().getDimensionPixelSize(2131165574);
      h.a(this, (ViewGroup)localObject1, paraml.vot, (h.c)localObject2);
    }
    AppMethodBeat.o(65477);
  }
  
  private void dji()
  {
    AppMethodBeat.i(65471);
    this.llo = true;
    if ((this.fq > 0) && (this.vjL.size() > 0) && (this.vjL.get(this.vjL.size() - 1) != null))
    {
      doSceneProgress(new ah(this.vuW, this.fq, this.vvi, bt.getLong(((y)this.vjL.get(this.vjL.size() - 1)).vpo, 0L), "v1.0", this.vvn));
      AppMethodBeat.o(65471);
      return;
    }
    this.vvn = "";
    doSceneProgress(new ah(this.vuW, 11, this.fq, this.vvi, "v1.0", this.vvn));
    AppMethodBeat.o(65471);
  }
  
  private void djj()
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
    localObject = this.vve.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.vve.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(65475);
  }
  
  private void djk()
  {
    AppMethodBeat.i(65478);
    if ((this.vvb != null) && (this.vvb.getVisibility() != 8)) {
      this.vvb.setVisibility(8);
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
  
  private void hM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65474);
    this.vve.setImageResource(2131232966);
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.vve.setVisibility(8);
      AppMethodBeat.o(65474);
      return;
    }
    djj();
    z.a(this.vve, paramString1, paramString2);
    this.vve.setVisibility(0);
    AppMethodBeat.o(65474);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65467);
    if ((paramKeyEvent.getKeyCode() == 4) && (this.vvb.getVisibility() == 0))
    {
      this.vvb.setVisibility(8);
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
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(65451);
          ad.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
          AppMethodBeat.o(65451);
        }
      });
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
          if ((this.vvj != null) && (this.vvj.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            ad.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            doSceneProgress(new at(str.replaceAll(",", "|"), this.vuW, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65465);
    super.onCreate(paramBundle);
    this.vjZ = ((ListView)findViewById(2131297621));
    this.vvm = new i(getContext());
    this.agn = LayoutInflater.from(this).inflate(2131494629, null);
    this.vjZ.addHeaderView(this.agn);
    this.vjZ.setAdapter(this.vvm);
    this.agn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65456);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65456);
      }
    });
    this.vjZ.setOnScrollListener(this.vkg);
    this.vjZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(65457);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        LuckyMoneyBusiDetailUI.e(LuckyMoneyBusiDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(65457);
      }
    });
    this.pIC = LayoutInflater.from(this).inflate(2131494628, null);
    this.vka = ((ImageView)this.agn.findViewById(2131297604));
    this.vkb = ((TextView)this.agn.findViewById(2131297625));
    this.uGZ = ((TextView)this.agn.findViewById(2131297627));
    this.vkd = this.agn.findViewById(2131297603);
    this.vjR = ((TextView)this.agn.findViewById(2131297602));
    this.vke = this.agn.findViewById(2131297611);
    this.mkS = ((TextView)this.agn.findViewById(2131297624));
    this.vvc = ((ImageView)this.agn.findViewById(2131297612));
    this.lDu = ((TextView)this.agn.findViewById(2131297607));
    this.vvd = this.agn.findViewById(2131297619);
    this.vve = ((ImageView)this.agn.findViewById(2131297601));
    paramBundle = (ImageView)findViewById(2131297606);
    this.vvb = ((LuckyMoneyWishFooter)findViewById(2131297626));
    Object localObject = this.vvb;
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
    if (((LuckyMoneyWishFooter)localObject).vBp != null) {
      ((LuckyMoneyWishFooter)localObject).vBp.setBackListener(local9);
    }
    this.vvb.setOnWishSendImp(new LuckyMoneyWishFooter.b()
    {
      public final void apb(String paramAnonymousString)
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
    this.vvb.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(65460);
        com.tencent.mm.compatible.util.i.v(LuckyMoneyBusiDetailUI.this);
        AppMethodBeat.o(65460);
      }
    });
    this.vvb.setOnkbdStateListener(new KeyboardLinearLayout.a()
    {
      public final void GV(int paramAnonymousInt)
      {
        AppMethodBeat.i(65461);
        if ((paramAnonymousInt == -2) && (LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).vBq)) {
          LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).setModeClick(false);
        }
        AppMethodBeat.o(65461);
      }
    });
    this.vvm.vBb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65462);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyBusiDetailUI.f(LuckyMoneyBusiDetailUI.this).setVisibility(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65462);
      }
    };
    localObject = this.vvm;
    ((i)localObject).vBc = new i.a((i)localObject);
    this.vvb.setMaxLength(25);
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(65463);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LuckyMoneyBusiDetailUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(65463);
      }
    });
    fixBackgroundRepeat(findViewById(2131297605));
    this.vuW = getIntent().getStringExtra("key_sendid");
    this.vvi = getIntent().getStringExtra("key_native_url");
    this.vvg = getIntent().getIntExtra("key_jump_from", 2);
    this.vvk = getIntent().getIntExtra("key_static_from_scene", 0);
    ad.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.vuW, this.vvi, Integer.valueOf(this.vvg) });
    if (this.vvg == 2) {}
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
              k.a(this, k.a.vBz);
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
      if ((bt.isNullOrNil(this.vuW)) && (!bt.isNullOrNil(this.vvi))) {
        paramBundle = Uri.parse(this.vvi);
      }
      try
      {
        this.vuW = paramBundle.getQueryParameter("sendid");
        if (!bt.isNullOrNil(this.vuW)) {
          dji();
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
    if (this.vvb != null)
    {
      LuckyMoneyWishFooter localLuckyMoneyWishFooter = this.vvb;
      if (localLuckyMoneyWishFooter.pWJ != null)
      {
        ad.i("MicroMsg.SnsCommentFooter", "commentfooter release");
        localLuckyMoneyWishFooter.pWJ.fbE();
        localLuckyMoneyWishFooter.pWJ.destroy();
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
        paramn = paramString.vpO;
        this.vvn = paramString.vqa;
        a(paramn);
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cl(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cl(this, getString(2131760233));
        this.vvm.vjN = false;
        djk();
        paramString = (ao)paramn;
        if (this.vjL != null) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 < this.vjL.size())
          {
            paramn = (y)this.vjL.get(paramInt1);
            if (paramn.vol.equalsIgnoreCase(paramString.vol))
            {
              paramn.vpC = paramString.vjr;
              this.vvm.notifyDataSetChanged();
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
      com.tencent.mm.ui.base.h.cl(this, paramString);
      AppMethodBeat.o(65468);
      return true;
    }
    if ((paramn instanceof at))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.ui.base.h.cl(this, getString(2131760233));
        AppMethodBeat.o(65468);
        return true;
      }
      com.tencent.mm.ui.base.h.cl(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */