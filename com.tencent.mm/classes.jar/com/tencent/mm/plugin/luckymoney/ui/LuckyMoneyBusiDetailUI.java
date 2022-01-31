package com.tencent.mm.plugin.luckymoney.ui;

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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.hn;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class LuckyMoneyBusiDetailUI
  extends LuckyMoneyBaseUI
{
  private int El = 0;
  private View VH;
  private boolean gDQ = false;
  private TextView iIV;
  private TextView iKV;
  private View jcy;
  private List<n> lLG = new LinkedList();
  private TextView lLM;
  private ListView lLU;
  private ImageView lLV;
  private TextView lLW;
  private View lLY;
  private View lLZ;
  AbsListView.OnScrollListener lMb = new LuckyMoneyBusiDetailUI.1(this);
  private String lUA;
  private String lUB;
  private int lUC = 0;
  private Map<String, Integer> lUD = new HashMap();
  private i lUE;
  private String lUF = "";
  private boolean lUG = false;
  private LuckyMoneyWishFooter lUs;
  private ImageView lUt;
  private View lUu;
  private ImageView lUv;
  private boolean lUw = true;
  private int lUx;
  private String lUy;
  private String lUz;
  private TextView lly;
  
  private void a(f paramf)
  {
    if (paramf == null) {
      return;
    }
    boolean bool;
    label169:
    label246:
    label254:
    Object localObject3;
    label322:
    label338:
    label359:
    int i;
    label900:
    int j;
    if (paramf.lQe == 1)
    {
      bool = true;
      this.lUw = bool;
      if (this.El == 0)
      {
        this.lUz = paramf.lQb;
        this.lUE.lLH = this.lUz;
        this.lUE.lLJ = paramf.lQm;
        if (paramf != null)
        {
          localObject1 = this.mController.uMN;
          if (paramf.lQm != 2) {
            break label1253;
          }
          this.lLV.setImageResource(a.e.lucky_money_busi_default_avatar);
          if (paramf.resourceId == 0) {
            break label1243;
          }
          y.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + paramf.resourceId);
          localObject2 = new hn();
          ((hn)localObject2).bPv.bPx = paramf.resourceId;
          ((hn)localObject2).bFJ = new LuckyMoneyBusiDetailUI.3(this, (hn)localObject2, paramf);
          com.tencent.mm.sdk.b.a.udP.a((b)localObject2, Looper.myLooper());
          o.a((Context)localObject1, this.lLW, paramf.lPU);
          o.a((Context)localObject1, this.lly, paramf.lLm);
          if ((paramf.ced != 2) || (this.lUx == 3)) {
            break label1282;
          }
          this.lLM.setText(e.A(paramf.ceq / 100.0D));
          if (paramf.lQc == 1) {
            break label1271;
          }
          this.lUE.lLI = true;
          this.lLY.setVisibility(0);
          if (bk.bl(paramf.lNr)) {
            break label1334;
          }
          this.lLZ.setVisibility(0);
          this.iKV.setText(paramf.lNr);
          if (paramf.lNp != 1) {
            break label1306;
          }
          if ((TextUtils.isEmpty(paramf.lNq)) || (paramf.lNq.startsWith("weixin://wxpay"))) {
            break label1294;
          }
          this.lUt.setVisibility(0);
          this.iKV.setOnClickListener(new LuckyMoneyBusiDetailUI.4(this, paramf));
          if (bk.bl(paramf.lQf)) {
            break label1354;
          }
          this.iIV.setText(paramf.lQf);
        }
        if (paramf != null)
        {
          localObject1 = paramf.lQi;
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject2 = this.VH.findViewById(a.f.busi_detail_operation_container_1);
            localObject3 = this.VH.findViewById(a.f.busi_detail_operation_container_2);
            View localView1 = this.VH.findViewById(a.f.busi_detail_operation_container_3);
            ViewGroup localViewGroup1 = (ViewGroup)this.VH.findViewById(a.f.busi_detail_operation_1);
            ViewGroup localViewGroup2 = (ViewGroup)this.VH.findViewById(a.f.busi_detail_operation_2);
            ViewGroup localViewGroup3 = (ViewGroup)this.VH.findViewById(a.f.busi_detail_operation_3);
            View localView2 = this.VH.findViewById(a.f.busi_detail_divider_operation_1);
            View localView3 = this.VH.findViewById(a.f.busi_detail_divider_operation_2);
            g.c localc = new g.c();
            localc.textColor = getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color);
            localc.lWV = true;
            localc.resourceId = paramf.resourceId;
            localc.lWW = this.lUC;
            if (((List)localObject1).size() > 0)
            {
              g.a(this, localViewGroup1, (ai)((List)localObject1).get(0), localc);
              ((View)localObject2).setVisibility(0);
            }
            if (((List)localObject1).size() > 1)
            {
              g.a(this, localViewGroup2, (ai)((List)localObject1).get(1), localc);
              ((View)localObject3).setVisibility(0);
            }
            if (((List)localObject1).size() > 2)
            {
              g.a(this, localViewGroup3, (ai)((List)localObject1).get(2), localc);
              localView1.setVisibility(0);
            }
            if ((((View)localObject2).getVisibility() == 0) && ((((View)localObject3).getVisibility() == 0) || (localView1.getVisibility() == 0))) {
              localView2.setVisibility(0);
            }
            if ((((View)localObject3).getVisibility() == 0) && (localView1.getVisibility() == 0)) {
              localView3.setVisibility(0);
            }
            if ((((View)localObject2).getVisibility() == 0) || (((View)localObject3).getVisibility() == 0) || (localView1.getVisibility() == 0))
            {
              this.lUu.requestLayout();
              this.lUu.setVisibility(0);
            }
          }
          localObject1 = (ViewGroup)this.jcy.findViewById(a.f.busi_detail_footer_operation);
          localObject2 = new g.c();
          ((g.c)localObject2).textColor = getResources().getColor(a.c.lucky_money_goldstyle_detail_primary_text_color);
          ((g.c)localObject2).textSize = getResources().getDimensionPixelSize(a.d.SmallerTextSize);
          g.a(this, (ViewGroup)localObject1, paramf.lQj, (g.c)localObject2);
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(tq(paramf.lQm)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
      }
      if (paramf != null)
      {
        if (((paramf.cec != 3) && (paramf.cec != 2)) || (paramf.lQd != 1) || (this.lUw) || (paramf.lQg != 1)) {
          break label1365;
        }
        i = 1;
        if ((paramf.lQh == null) || (paramf.lQh.dwF != 1) || (bk.bl(paramf.lQh.lPE))) {
          break label1370;
        }
        j = 1;
        label933:
        localObject1 = (TextView)this.jcy.findViewById(a.f.busi_detail_send_btn);
        if ((i == 0) && (j == 0)) {
          break label1375;
        }
        ((TextView)localObject1).setOnClickListener(new LuckyMoneyBusiDetailUI.5(this, paramf));
        if (j != 0)
        {
          this.lUB = paramf.lQh.lPE;
          ((TextView)localObject1).setText(paramf.lQh.lPF);
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(tq(paramf.lQm)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
        ((TextView)localObject1).setVisibility(0);
        label1057:
        localObject2 = (TextView)this.jcy.findViewById(a.f.busi_detail_record_link);
        if ((this.lUx == 1) || (this.lUx == 3) || (((TextView)localObject1).getVisibility() == 0)) {
          break label1385;
        }
        ((TextView)localObject2).setOnClickListener(new LuckyMoneyBusiDetailUI.6(this, paramf));
        ((TextView)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      if (!this.lUG)
      {
        this.lLU.addFooterView(this.jcy);
        this.lUG = true;
      }
      localObject1 = paramf.lQn;
      if (localObject1 == null) {
        break label1427;
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
      label1243:
      if (bk.bl(paramf.lPV)) {
        break label169;
      }
      label1253:
      o.a(this.lLV, paramf.lPV, paramf.lQp);
      break label169;
      label1271:
      this.lUE.lLI = false;
      break label246;
      label1282:
      this.lLY.setVisibility(8);
      break label254;
      label1294:
      this.lUt.setVisibility(8);
      break label322;
      label1306:
      y.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
      this.iKV.setTextColor(getResources().getColor(a.c.lucky_money_operation_text_normal_color));
      break label338;
      label1334:
      y.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
      this.lLZ.setVisibility(8);
      break label338;
      label1354:
      this.iIV.setText(null);
      break label359;
      label1365:
      i = 0;
      break label900;
      label1370:
      j = 0;
      break label933;
      label1375:
      ((TextView)localObject1).setVisibility(8);
      break label1057;
      label1385:
      ((TextView)localObject2).setVisibility(8);
    }
    this.El += ((List)localObject1).size();
    this.gDQ = false;
    this.lUE.bM(this.lLG);
    label1427:
    Object localObject1 = paramf.lQl;
    Object localObject2 = paramf.lQo;
    this.lUv.setImageResource(a.e.lucky_money_busi_ad_img_default);
    if (bk.bl((String)localObject1))
    {
      y.i("MicroMsg.LuckyMoneyDetailUI", "renderAdImage: no adImage");
      this.lUv.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13051, new Object[] { Integer.valueOf(this.lUC), Integer.valueOf(1), paramf.lQl, o.bL(paramf.lQi), "", "", "", "", paramf.lPU, Integer.valueOf(paramf.resourceId) });
      return;
      new DisplayMetrics();
      localObject3 = ae.getContext().getResources().getDisplayMetrics();
      if (localObject3 != null)
      {
        i = (int)((((DisplayMetrics)localObject3).widthPixels - getResources().getDimensionPixelSize(a.d.lucky_money_busi_detail_list_padding) * 2 - getResources().getDimensionPixelSize(a.d.lucky_money_busi_detail_list_margin) * 2) * 0.75F);
        localObject3 = this.lUv.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).height = i;
        this.lUv.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      o.a(this.lUv, (String)localObject1, (String)localObject2, false);
      this.lUv.setVisibility(0);
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
  
  public static void fixBackgroundRepeat(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.getBackground();
    } while ((paramView == null) || (!(paramView instanceof BitmapDrawable)));
    paramView = (BitmapDrawable)paramView;
    paramView.mutate();
    paramView.setTileModeX(Shader.TileMode.REPEAT);
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
      com.tencent.mm.ui.base.h.bC(this, getString(a.i.has_send));
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
      localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
      localBundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
      boolean bool = localRealnameGuideHelper.b(this, localBundle, new LuckyMoneyBusiDetailUI.2(this));
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
    return a.g.lucky_money_busi_detail_ui;
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
            y.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
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
    this.lLU = ((ListView)findViewById(a.f.busi_detail_record_list));
    this.lUE = new i(this.mController.uMN);
    this.VH = LayoutInflater.from(this).inflate(a.g.lucky_money_busi_detail_header, null);
    this.lLU.addHeaderView(this.VH);
    this.lLU.setAdapter(this.lUE);
    this.VH.setOnClickListener(new LuckyMoneyBusiDetailUI.7(this));
    this.lLU.setOnScrollListener(this.lMb);
    this.lLU.setOnItemClickListener(new LuckyMoneyBusiDetailUI.8(this));
    this.jcy = LayoutInflater.from(this).inflate(a.g.lucky_money_busi_detail_footer, null);
    this.lLV = ((ImageView)this.VH.findViewById(a.f.busi_detail_avatar));
    this.lLW = ((TextView)this.VH.findViewById(a.f.busi_detail_whose));
    this.lly = ((TextView)this.VH.findViewById(a.f.busi_detail_wishing));
    this.lLY = this.VH.findViewById(a.f.busi_detail_amount_area);
    this.lLM = ((TextView)this.VH.findViewById(a.f.busi_detail_amount));
    this.lLZ = this.VH.findViewById(a.f.busi_detail_hint_layout);
    this.iKV = ((TextView)this.VH.findViewById(a.f.busi_detail_tips));
    this.lUt = ((ImageView)this.VH.findViewById(a.f.busi_detail_icon));
    this.iIV = ((TextView)this.VH.findViewById(a.f.busi_detail_desc));
    this.lUu = this.VH.findViewById(a.f.busi_detail_opertiaon_ll);
    this.lUv = ((ImageView)this.VH.findViewById(a.f.busi_detail_adimage));
    paramBundle = (ImageView)findViewById(a.f.busi_detail_close_btn);
    this.lUs = ((LuckyMoneyWishFooter)findViewById(a.f.busi_detail_wish_footer));
    this.lUs.a(new LuckyMoneyBusiDetailUI.9(this));
    this.lUs.setOnWishSendImp(new LuckyMoneyBusiDetailUI.10(this));
    this.lUs.post(new LuckyMoneyBusiDetailUI.11(this));
    this.lUs.setOnkbdStateListener(new LuckyMoneyBusiDetailUI.12(this));
    this.lUE.lXC = new LuckyMoneyBusiDetailUI.13(this);
    i locali = this.lUE;
    locali.lXD = new i.a(locali);
    this.lUs.setMaxLength(25);
    paramBundle.setOnClickListener(new LuckyMoneyBusiDetailUI.14(this));
    fixBackgroundRepeat(findViewById(a.f.busi_detail_bottom_decoration));
    this.lUy = getIntent().getStringExtra("key_sendid");
    this.lUA = getIntent().getStringExtra("key_native_url");
    this.lUx = getIntent().getIntExtra("key_jump_from", 2);
    this.lUC = getIntent().getIntExtra("key_static_from_scene", 0);
    y.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[] { this.lUy, this.lUA, Integer.valueOf(this.lUx) });
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
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        y.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + paramBundle.getLocalizedMessage());
      }
      if ((bk.bl(this.lUy)) && (!bk.bl(this.lUA))) {
        paramBundle = Uri.parse(this.lUA);
      }
      try
      {
        this.lUy = paramBundle.getQueryParameter("sendid");
        if (!bk.bl(this.lUy)) {
          bge();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          y.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + paramBundle.getLocalizedMessage());
        }
        y.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.lUs != null) {
      this.lUs.bgu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI
 * JD-Core Version:    0.7.0.1
 */