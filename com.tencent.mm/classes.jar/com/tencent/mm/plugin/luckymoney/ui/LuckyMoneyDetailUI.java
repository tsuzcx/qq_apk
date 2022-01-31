package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.hn;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private int El = 0;
  private View VH;
  private boolean gDQ = false;
  private TextView iIV;
  private TextView iKV;
  private long iaq = 0L;
  private ImageView jEm;
  private View jcy;
  private List<n> lLG = new LinkedList();
  private TextView lLM;
  private ListView lLU;
  private ImageView lLV;
  private TextView lLW;
  private ImageView lLX;
  private View lLY;
  private View lLZ;
  AbsListView.OnScrollListener lMb = new LuckyMoneyDetailUI.1(this);
  private SoundPool lNa;
  private com.tencent.mm.plugin.luckymoney.particles.b lOB = new LuckyMoneyDetailUI.12(this);
  private int lQm = -1;
  private String lUA;
  private String lUB;
  private Map<String, Integer> lUD = new HashMap();
  private i lUE;
  private String lUF = "";
  private boolean lUG = false;
  private LuckyMoneyWishFooter lUs;
  private View lUu;
  private boolean lUw = true;
  private int lUx;
  private String lUy;
  private String lUz;
  private CdnImageView lVg;
  private ImageView lVh;
  private View lVi;
  private ImageView lVj;
  private TextView lVk;
  private View lVl;
  private RelativeLayout lVm;
  private int[] lVn;
  private ViewGroup lVo;
  private Bitmap lVp;
  private Bitmap lVq;
  private Bitmap lVr;
  private Bitmap lVs;
  private Bitmap lVt;
  private Bitmap lVu;
  private Bitmap lVv;
  private Bitmap lVw;
  private final int lVx = 750;
  private final int lVy = 240;
  private TextView lly;
  
  private void a(f paramf)
  {
    if (paramf == null) {}
    for (;;)
    {
      return;
      boolean bool;
      Object localObject1;
      int i;
      label103:
      Object localObject2;
      label140:
      label313:
      label460:
      label468:
      int j;
      if (paramf.lQe == 1)
      {
        bool = true;
        this.lUw = bool;
        if (this.El == 0)
        {
          this.lUz = paramf.lQb;
          localObject1 = this.lUz;
          if ((paramf == null) || (paramf.lPR != 0) || (paramf.lQn == null) || (paramf.lQn.size() <= 0) || (!((n)paramf.lQn.get(0)).lQb.equals(localObject1)) || (paramf.lQc == 1)) {
            break label1417;
          }
          i = 1;
          if (i == 0) {
            break label1422;
          }
          this.lUE.lLI = false;
          this.lVk.setVisibility(0);
          this.lVl.setVisibility(0);
          this.iIV.setVisibility(8);
          this.lUE.lLJ = paramf.lQm;
          if (paramf != null)
          {
            localObject1 = this.mController.uMN;
            if (paramf.lQm != 2) {
              break label1462;
            }
            this.lLV.setImageResource(a.e.lucky_money_busi_default_avatar);
            if (paramf.resourceId == 0) {
              break label1444;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramf.resourceId);
            localObject2 = new hn();
            ((hn)localObject2).bPv.bPx = paramf.resourceId;
            ((hn)localObject2).bFJ = new LuckyMoneyDetailUI.8(this, (hn)localObject2, paramf);
            com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject2, Looper.myLooper());
            label261:
            com.tencent.mm.plugin.luckymoney.b.o.a((Context)localObject1, this.lLW, paramf.lPU);
            com.tencent.mm.plugin.luckymoney.b.o.a((Context)localObject1, this.lly, paramf.lLm);
            if (paramf.lPR != 1) {
              break label1480;
            }
            this.lLX.setVisibility(0);
            this.lLX.setImageResource(a.e.lucky_money_group_icon);
            if (!bk.bl(paramf.lQk))
            {
              com.tencent.mm.plugin.luckymoney.b.o.d(this.lVh, paramf.lQk, a.e.lucky_money_index_top_bg);
              this.lVh.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            if (bk.bl(paramf.lQl)) {
              break label1558;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[] { paramf.lQl });
            this.lVm.setVisibility(4);
            com.tencent.mm.plugin.luckymoney.b.o.g(this.jEm, paramf.lQl);
            com.tencent.mm.sdk.platformtools.ai.l(new LuckyMoneyDetailUI.9(this), 500L);
            label409:
            if ((paramf.ced != 2) || (this.lUx == 3)) {
              break label1589;
            }
            this.lLM.setText(e.A(paramf.ceq / 100.0D));
            if (paramf.lQc == 1) {
              break label1578;
            }
            this.lUE.lLI = true;
            this.lLY.setVisibility(0);
            if (bk.bl(paramf.lNr)) {
              break label1641;
            }
            this.lLZ.setVisibility(0);
            this.iKV.setText(paramf.lNr);
            if (paramf.lNp != 1) {
              break label1613;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", new Object[] { paramf.lQr });
            if (bk.bl(paramf.lQr)) {
              break label1601;
            }
            this.lVg.setUrl(paramf.lQr);
            this.lVg.setVisibility(0);
            label553:
            this.iKV.setOnClickListener(new LuckyMoneyDetailUI.10(this, paramf));
            label569:
            if (bk.bl(paramf.lQf)) {
              break label1661;
            }
            this.iIV.setText(paramf.lQf);
          }
          label590:
          if (paramf != null)
          {
            localObject1 = paramf.lQi;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject2 = this.VH.findViewById(a.f.lucky_money_detail_operation_container_1);
              View localView1 = this.VH.findViewById(a.f.lucky_money_detail_operation_container_2);
              View localView2 = this.VH.findViewById(a.f.lucky_money_detail_operation_container_3);
              ViewGroup localViewGroup1 = (ViewGroup)this.VH.findViewById(a.f.lucky_money_detail_operation_1);
              ViewGroup localViewGroup2 = (ViewGroup)this.VH.findViewById(a.f.lucky_money_detail_operation_2);
              ViewGroup localViewGroup3 = (ViewGroup)this.VH.findViewById(a.f.lucky_money_detail_operation_3);
              View localView3 = this.VH.findViewById(a.f.lucky_money_detail_divider_operation_1);
              View localView4 = this.VH.findViewById(a.f.lucky_money_detail_divider_operation_2);
              g.c localc = new g.c();
              localc.textColor = getResources().getColor(a.c.lucky_money_goldstyle_grey_text_color);
              if (((List)localObject1).size() > 0)
              {
                g.a(this, localViewGroup1, (com.tencent.mm.plugin.luckymoney.b.ai)((List)localObject1).get(0), localc);
                ((View)localObject2).setVisibility(0);
              }
              if (((List)localObject1).size() > 1)
              {
                g.a(this, localViewGroup2, (com.tencent.mm.plugin.luckymoney.b.ai)((List)localObject1).get(1), localc);
                localView1.setVisibility(0);
              }
              if (((List)localObject1).size() > 2)
              {
                g.a(this, localViewGroup3, (com.tencent.mm.plugin.luckymoney.b.ai)((List)localObject1).get(2), localc);
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
                this.lUu.requestLayout();
                this.lUu.setVisibility(0);
              }
            }
            localObject1 = (ViewGroup)this.jcy.findViewById(a.f.lucky_money_detail_footer_operation);
            localObject2 = new g.c();
            ((g.c)localObject2).textColor = getResources().getColor(a.c.lucky_money_goldstyle_grey_text_color);
            ((g.c)localObject2).textSize = getResources().getDimensionPixelSize(a.d.SmallerTextSize);
            g.a(this, (ViewGroup)localObject1, paramf.lQj, (g.c)localObject2);
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(tq(paramf.lQm)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        }
        if (paramf != null)
        {
          if (((paramf.cec != 3) && (paramf.cec != 2)) || (paramf.lQd != 1) || (this.lUw) || (paramf.lQg != 1)) {
            break label1672;
          }
          i = 1;
          label1107:
          if ((paramf.lQh == null) || (paramf.lQh.dwF != 1) || (bk.bl(paramf.lQh.lPE))) {
            break label1677;
          }
          j = 1;
          label1140:
          localObject1 = (TextView)this.jcy.findViewById(a.f.lucky_money_detail_send_btn);
          if ((i == 0) && (j == 0)) {
            break label1682;
          }
          ((TextView)localObject1).setOnClickListener(new LuckyMoneyDetailUI.11(this, paramf));
          if (j != 0)
          {
            this.lUB = paramf.lQh.lPE;
            ((TextView)localObject1).setText(paramf.lQh.lPF);
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(tq(paramf.lQm)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
          ((TextView)localObject1).setVisibility(0);
        }
      }
      for (;;)
      {
        this.lQm = paramf.lQm;
        ((TextView)this.jcy.findViewById(a.f.lucky_money_detail_record_link)).setVisibility(8);
        if (!this.lUG)
        {
          this.lLU.addFooterView(this.jcy);
          this.lUG = true;
        }
        localObject1 = paramf.lQn;
        if (localObject1 == null) {
          break label1742;
        }
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (n)((List)localObject1).get(i);
          if (!this.lUD.containsKey(((n)localObject2).lQb))
          {
            this.lLG.add(((List)localObject1).get(i));
            this.lUD.put(((n)localObject2).lQb, Integer.valueOf(1));
          }
          i += 1;
        }
        bool = false;
        break;
        label1417:
        i = 0;
        break label103;
        label1422:
        this.iIV.setVisibility(0);
        this.lUE.lLH = this.lUz;
        break label140;
        label1444:
        com.tencent.mm.plugin.luckymoney.b.o.a(this.lLV, paramf.lPV, paramf.lQp);
        break label261;
        label1462:
        com.tencent.mm.plugin.luckymoney.b.o.a(this.lLV, paramf.lPV, paramf.lQp);
        break label261;
        label1480:
        if (paramf.lPR == 2)
        {
          if (!com.tencent.mm.model.s.hk(paramf.lQp))
          {
            localObject1 = new com.tencent.mm.ag.h();
            ((com.tencent.mm.ag.h)localObject1).username = paramf.lQp;
            com.tencent.mm.ag.o.Kh().a((com.tencent.mm.ag.h)localObject1);
          }
          this.lLX.setVisibility(0);
          this.lLX.setImageResource(a.e.lucky_money_f2f_record_icon);
          break label313;
        }
        this.lLX.setVisibility(8);
        break label313;
        label1558:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
        this.lVm.setVisibility(8);
        break label409;
        label1578:
        this.lUE.lLI = false;
        break label460;
        label1589:
        this.lLY.setVisibility(8);
        break label468;
        label1601:
        this.lVg.setVisibility(8);
        break label553;
        label1613:
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
        this.iKV.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
        break label569;
        label1641:
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
        this.lLZ.setVisibility(8);
        break label569;
        label1661:
        this.iIV.setText(null);
        break label590;
        label1672:
        i = 0;
        break label1107;
        label1677:
        j = 0;
        break label1140;
        label1682:
        ((TextView)localObject1).setVisibility(8);
      }
      this.El += ((List)localObject1).size();
      this.gDQ = false;
      if (this.lVk.getVisibility() != 0)
      {
        this.iIV.setVisibility(0);
        this.lUE.bM(this.lLG);
      }
      label1742:
      if ((paramf.lPR == 2) && (!bk.bl(paramf.lPT)))
      {
        this.lNa = new SoundPool(2, 3, 0);
        this.lVn = new int[2];
      }
      try
      {
        this.lVn[0] = this.lNa.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
        this.lVn[1] = this.lNa.load(getResources().getAssets().openFd("whistle.m4a"), 0);
        this.lNa.setOnLoadCompleteListener(new LuckyMoneyDetailUI.6(this, paramf));
        this.VH.postDelayed(new LuckyMoneyDetailUI.7(this), 300L);
        localObject1 = new com.tencent.mm.plugin.wallet_core.model.y();
        ((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_mNativeUrl = this.lUA;
        ((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_hbType = paramf.lPR;
        ((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_receiveAmount = paramf.ceq;
        ((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_receiveTime = System.currentTimeMillis();
        ((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_hbStatus = paramf.cec;
        ((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_receiveStatus = paramf.ced;
        if (((com.tencent.mm.plugin.wallet_core.model.y)localObject1).field_receiveAmount <= 0L) {
          continue;
        }
        com.tencent.mm.plugin.wallet_core.model.o.bVp().a((com.tencent.mm.plugin.wallet_core.model.y)localObject1);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + localIOException.getMessage());
        }
      }
    }
  }
  
  private void bge()
  {
    this.gDQ = true;
    if ((this.El > 0) && (this.lLG.size() > 0) && (this.lLG.get(this.lLG.size() - 1) != null))
    {
      l(new w(this.lUy, this.El, this.lUA, bk.getLong(((n)this.lLG.get(this.lLG.size() - 1)).lQz, 0L), "v1.0", this.lUF));
      return;
    }
    this.lUF = "";
    l(new w(this.lUy, 11, this.El, this.lUA, "v1.0", this.lUF));
  }
  
  private void bgf()
  {
    if ((this.lUs != null) && (this.lUs.getVisibility() != 8)) {
      this.lUs.setVisibility(8);
    }
  }
  
  private static int tq(int paramInt)
  {
    if (paramInt == 2) {
      return 13;
    }
    return 7;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    if ((paramm instanceof w)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (w)paramm;
        paramm = paramString.lQZ;
        this.lUF = paramString.lRl;
        a(paramm);
        bool = true;
      }
    }
    do
    {
      return bool;
      com.tencent.mm.ui.base.h.bC(this, paramString);
      return true;
      if ((paramm instanceof ac))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.has_send));
          this.lUE.lLI = false;
          bgf();
          paramString = (ac)paramm;
          if (this.lLG != null) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 < this.lLG.size())
            {
              paramm = (n)this.lLG.get(paramInt1);
              if (paramm.lQb.equalsIgnoreCase(paramString.lQb))
              {
                paramm.lQN = paramString.lLm;
                this.lUE.notifyDataSetChanged();
              }
            }
            else
            {
              if (this.lVk.getVisibility() == 0)
              {
                this.lVk.setVisibility(8);
                this.iIV.setVisibility(0);
                this.lVl.setVisibility(8);
                this.lUE.bM(this.lLG);
              }
              return true;
            }
            paramInt1 += 1;
          }
        }
        com.tencent.mm.ui.base.h.bC(this, paramString);
        return true;
      }
    } while (!(paramm instanceof ah));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.widget.snackbar.b.h(this, getString(a.i.has_send));
      return true;
    }
    com.tencent.mm.ui.base.h.bC(this, paramString);
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (this.lUs.getVisibility() == 0))
    {
      this.lUs.setVisibility(8);
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void finish()
  {
    if (getIntent().hasExtra("key_realname_guide_helper"))
    {
      RealnameGuideHelper localRealnameGuideHelper = (RealnameGuideHelper)getIntent().getParcelableExtra("key_realname_guide_helper");
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
      localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new LuckyMoneyDetailUI.5(this));
      getIntent().removeExtra("key_realname_guide_helper");
      if (!bool) {
        super.finish();
      }
      return;
    }
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_detail_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.lucky_money_detail);
    setBackBtn(new LuckyMoneyDetailUI.14(this));
    czo();
    this.lLU = ((ListView)findViewById(a.f.lucky_money_detail_record_list));
    this.lUE = new i(this.mController.uMN);
    this.VH = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_header, null);
    this.lLU.addHeaderView(this.VH);
    this.lLU.setAdapter(this.lUE);
    this.VH.setOnClickListener(new LuckyMoneyDetailUI.15(this));
    this.lLU.setOnScrollListener(this.lMb);
    this.lLU.setOnItemClickListener(new LuckyMoneyDetailUI.16(this));
    this.jcy = LayoutInflater.from(this).inflate(a.g.lucky_money_detail_footer, null);
    this.lLV = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_sender_avatar));
    this.lLW = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_whose));
    this.lLX = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_group_icon));
    this.lly = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_wishing));
    this.lLY = this.VH.findViewById(a.f.lucky_money_detail_amount_area);
    this.lLM = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_amount));
    this.lLZ = this.VH.findViewById(a.f.lucky_money_detail_layout);
    this.iKV = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_tips));
    this.lVg = ((CdnImageView)this.VH.findViewById(a.f.lucky_money_detail_icon));
    this.iIV = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_desc));
    this.lVh = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_top_bg));
    this.lUu = this.VH.findViewById(a.f.lucky_money_detail_opertiaon_ll);
    this.lVi = this.VH.findViewById(a.f.lucky_money_detail_background_area);
    this.lVj = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_background));
    this.lVk = ((TextView)this.VH.findViewById(a.f.lucky_money_detail_normal_wish));
    this.lVl = findViewById(a.f.lucky_money_detail_normal_wish_divider);
    this.lVm = ((RelativeLayout)this.VH.findViewById(a.f.lucky_money_detail_background_area));
    this.jEm = ((ImageView)this.VH.findViewById(a.f.lucky_money_detail_background));
    this.lUs = ((LuckyMoneyWishFooter)findViewById(a.f.lucky_money_detail_wish_footer));
    this.lVo = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_recv_container));
    this.lVg.setUseSdcardCache(true);
    this.lUs.a(new MMEditText.a()
    {
      public final void bgg()
      {
        if (LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).getVisibility() == 0)
        {
          LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(8);
          return;
        }
        LuckyMoneyDetailUI.this.mController.uMN.finish();
      }
    });
    this.lUs.setOnWishSendImp(new LuckyMoneyDetailUI.18(this));
    this.lUs.post(new LuckyMoneyDetailUI.19(this));
    this.lUs.setOnkbdStateListener(new LuckyMoneyDetailUI.2(this));
    this.lUE.lXC = new LuckyMoneyDetailUI.3(this);
    this.lUs.setMaxLength(25);
    this.lVk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        LuckyMoneyDetailUI.o(LuckyMoneyDetailUI.this).setVisibility(0);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!bk.bl(str)) {
          if ((this.lUB != null) && (this.lUB.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao"))) {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
          } else {
            l(new ah(str.replaceAll(",", "|"), this.lUy, "v1.0"));
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    this.lUy = getIntent().getStringExtra("key_sendid");
    this.lUA = getIntent().getStringExtra("key_native_url");
    this.lUx = getIntent().getIntExtra("key_jump_from", 2);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bk.pm(this.lUy) + ", nativeurl=" + bk.pm(this.lUA) + ", jumpFrom=" + this.lUx);
    if (this.lUx == 2) {}
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getByteArrayExtra("key_detail_info");
        if (paramBundle != null)
        {
          paramBundle = (f)new f().aH(paramBundle);
          if (paramBundle != null)
          {
            a(paramBundle);
            if (getIntent().getBooleanExtra("play_sound", false)) {
              k.G(this, a.i.lucky_cashrecivedrevised);
            }
            addTextOptionMenu(0, getString(a.i.lucky_money_check_mine_title_opt), new LuckyMoneyDetailUI.13(this));
            FR(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((bk.bl(this.lUy)) && (!bk.bl(this.lUA))) {
        paramBundle = Uri.parse(this.lUA);
      }
      try
      {
        this.lUy = paramBundle.getQueryParameter("sendid");
        label277:
        if (!bk.bl(this.lUy))
        {
          bge();
          continue;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
      catch (Exception paramBundle)
      {
        break label277;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
    paramMenu = (TextView)findViewById(a.f.action_option_text);
    if (paramMenu != null) {
      paramMenu.setTextColor(getResources().getColor(a.c.lucky_money_goldstyle_envelop_primary_text_color));
    }
    return bool;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.lUs != null) {
      this.lUs.bgu();
    }
    if (this.lNa != null)
    {
      this.lNa.release();
      int i = 0;
      while (i < this.lVn.length)
      {
        this.lNa.unload(this.lVn[i]);
        i += 1;
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    d.h("LuckyMoneyDetailUI", this.iaq, bk.UX());
  }
  
  protected void onResume()
  {
    super.onResume();
    this.iaq = bk.UX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */