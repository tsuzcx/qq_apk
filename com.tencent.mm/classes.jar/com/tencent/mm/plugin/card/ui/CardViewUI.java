package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int azj;
  private int fPp;
  private String hAT;
  private String mAppId;
  private LinkedList<tt> oEr;
  private int oFK;
  private String oKb;
  private View oKc;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.azj = 1;
    this.oEr = new LinkedList();
    this.hAT = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final BaseAdapter Zp()
  {
    AppMethodBeat.i(113603);
    if (this.azj == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.Zp();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.azj == 0)
    {
      am.bUS().own = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.oFK);
      paramb = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramb.ahp(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(113607);
      return;
    }
    super.a(paramb, paramInt);
    AppMethodBeat.o(113607);
  }
  
  public final void a(CardInfo paramCardInfo)
  {
    AppMethodBeat.i(113606);
    if (this.azj == 1)
    {
      this.own = paramCardInfo;
      k(this.oKb, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.own != null) {
      com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.own.bTN().mrl), this.own.field_card_tp_id, this.own.field_card_id, this.oKb });
    }
    AppMethodBeat.o(113606);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113605);
    if (this.azj == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(113605);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113605);
  }
  
  public final void bTg()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.azj == 0)
    {
      setMMTitle(2131757026);
      com.tencent.mm.kernel.g.ajB().gAO.a(1099, this);
      if (this.azj != 0) {
        break label157;
      }
      jt(true);
      Object localObject = new did();
      ((did)localObject).HwU = this.hAT;
      ad.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.hAT });
      localObject = new t(this.oEr, (did)localObject, this.fPp);
      com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
      i = 2131756786;
    }
    for (;;)
    {
      findViewById(2131302870).setVisibility(8);
      ((TextView)findViewById(2131302872)).setText(i);
      AppMethodBeat.o(113602);
      return;
      if (this.azj != 1) {
        break;
      }
      setMMTitle(2131756871);
      break;
      label157:
      if (this.azj == 1)
      {
        this.oKc = View.inflate(this, 2131493316, null);
        if (this.owi != null) {
          this.owi.addView(this.oKc);
        }
        i = 2131757000;
      }
      else
      {
        i = 2131756786;
      }
    }
  }
  
  public final n.a bTh()
  {
    return n.a.ozK;
  }
  
  public final boolean bTj()
  {
    AppMethodBeat.i(113604);
    if (this.azj == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.bTj();
    AppMethodBeat.o(113604);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113599);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      ad.e("MicroMsg.CardViewUI", "onCreate intent is null");
      finish();
      AppMethodBeat.o(113599);
      return;
    }
    this.fPp = paramBundle.getIntExtra("key_previous_scene", 7);
    this.oFK = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.azj = paramBundle.getIntExtra("view_type", 0);
    this.oKb = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.hAT = getIntent().getStringExtra("key_template_id");
    if (this.azj == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        ad.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.x(paramBundle, this.fPp, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.oEr.clear();
        this.oEr.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.g.ajB().gAO.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramn instanceof t))
    {
      jt(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramn).ozW;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.owg instanceof g))
          {
            paramn = (g)this.owg;
            if (paramString != null)
            {
              paramn.oDj.clear();
              paramn.oDj.addAll(paramString);
              paramn.oIg.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramn.oIg.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.owg.notifyDataSetChanged();
        }
        AppMethodBeat.o(113608);
        return;
      }
      d.b(this, paramString, paramInt2);
      AppMethodBeat.o(113608);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    AppMethodBeat.o(113608);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(113601);
    super.onSwipeBack();
    if (this.fPp == 26) {
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(113601);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewUI
 * JD-Core Version:    0.7.0.1
 */