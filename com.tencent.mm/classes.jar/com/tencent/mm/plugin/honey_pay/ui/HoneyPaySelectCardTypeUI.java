package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPaySelectCardTypeUI
  extends HoneyPayBaseUI
{
  private LinearLayout lmm;
  private List<aoi> lmn;
  private int lmo;
  private aoj lmp;
  
  private void aqU()
  {
    this.lmm.removeAllViews();
    if ((this.lmn == null) || (this.lmn.isEmpty())) {
      return;
    }
    Iterator localIterator = this.lmn.iterator();
    label37:
    aoi localaoi;
    HoneyPaySelectCardTypeUI.a locala;
    Object localObject1;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localaoi = (aoi)localIterator.next();
      locala = new HoneyPaySelectCardTypeUI.a(this, (byte)0);
      if (localaoi.teh != null) {
        break label120;
      }
      localObject1 = this.mController.uMN;
      localObject2 = this.lmm;
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(a.g.honey_pay_select_cardtype_item, (ViewGroup)localObject2, false);
      locala.a((View)localObject1, localaoi);
    }
    for (;;)
    {
      this.lmm.addView((View)localObject1);
      break label37;
      break;
      label120:
      localObject2 = this.mController.uMN;
      localObject1 = this.lmm;
      localObject1 = LayoutInflater.from((Context)localObject2).inflate(a.g.honey_pay_select_cardtype_item_with_operations, (ViewGroup)localObject1, false);
      locala.a((View)localObject1, localaoi);
      locala.lkt = ((CdnImageView)((View)localObject1).findViewById(a.f.hpsc_operations_icon_iv));
      locala.lmt = ((TextView)((View)localObject1).findViewById(a.f.hpsc_operations_tv));
      locala.lkt.setUrl(localaoi.teh.bVO);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(localaoi.teh.tjZ);
      localSpannableStringBuilder.append(localaoi.teh.tka);
      localSpannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.m(new HoneyPaySelectCardTypeUI.a.1(locala, localaoi, (Context)localObject2)), localaoi.teh.tjZ.length(), localSpannableStringBuilder.length(), 34);
      locala.lmt.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m((Context)localObject2));
      locala.lmt.setClickable(true);
      locala.lmt.setText(localSpannableStringBuilder);
    }
  }
  
  protected final boolean VK()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof b))
    {
      paramString = (b)paramm;
      paramString.a(new HoneyPaySelectCardTypeUI.3(this, paramString)).b(new HoneyPaySelectCardTypeUI.2(this)).c(new HoneyPaySelectCardTypeUI.1(this));
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.honey_pay_select_cardtype_ui;
  }
  
  protected final void initView()
  {
    this.lmm = ((LinearLayout)findViewById(a.f.hpsc_top_layout));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label90;
      }
      Object localObject = paramIntent.getStringExtra("Select_Conv_User");
      y.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", new Object[] { localObject });
      y.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", new Object[] { localObject });
      localObject = new b((String)localObject, this.lmo);
      ((b)localObject).m(this);
      a((com.tencent.mm.ah.m)localObject, true, false);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label90:
      y.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.lkb = a.c.honey_pay_grey_bg_1;
    super.onCreate(paramBundle);
    kh(2618);
    kh(2926);
    setMMTitle(a.i.honey_pay_select_card_type_title);
    paramBundle = getIntent().getParcelableArrayListExtra("key_card_type_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.lmn = new ArrayList();
      try
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          HoneyPayCardType localHoneyPayCardType = (HoneyPayCardType)paramBundle.next();
          aoi localaoi = new aoi();
          localaoi.aH(localHoneyPayCardType.oY);
          this.lmn.add(localaoi);
        }
        initView();
      }
      catch (IOException paramBundle)
      {
        y.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", paramBundle, "", new Object[0]);
      }
    }
    aqU();
  }
  
  public void onDestroy()
  {
    ki(2618);
    ki(2926);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI
 * JD-Core Version:    0.7.0.1
 */