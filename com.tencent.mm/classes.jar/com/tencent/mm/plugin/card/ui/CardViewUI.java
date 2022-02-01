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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int azj;
  private int fRv;
  private String hDH;
  private String mAppId;
  private LinkedList<tv> oKT;
  private int oMm;
  private String oQD;
  private View oQE;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.azj = 1;
    this.oKT = new LinkedList();
    this.hDH = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final BaseAdapter Zy()
  {
    AppMethodBeat.i(113603);
    if (this.azj == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.Zy();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.azj == 0)
    {
      am.bWh().oCP = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.oMm);
      paramb = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramb.ahE(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.mt(0));
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
      this.oCP = paramCardInfo;
      k(this.oQD, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.oCP != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.oCP.bVc().mwj), this.oCP.field_card_tp_id, this.oCP.field_card_id, this.oQD });
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
  
  public final void bUv()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.azj == 0)
    {
      setMMTitle(2131757026);
      com.tencent.mm.kernel.g.ajQ().gDv.a(1099, this);
      if (this.azj != 0) {
        break label157;
      }
      js(true);
      Object localObject = new diy();
      ((diy)localObject).HQD = this.hDH;
      ae.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.hDH });
      localObject = new t(this.oKT, (diy)localObject, this.fRv);
      com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject, 0);
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
        this.oQE = View.inflate(this, 2131493316, null);
        if (this.oCK != null) {
          this.oCK.addView(this.oQE);
        }
        i = 2131757000;
      }
      else
      {
        i = 2131756786;
      }
    }
  }
  
  public final n.a bUw()
  {
    return n.a.oGm;
  }
  
  public final boolean bUy()
  {
    AppMethodBeat.i(113604);
    if (this.azj == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.bUy();
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
      ae.e("MicroMsg.CardViewUI", "onCreate intent is null");
      finish();
      AppMethodBeat.o(113599);
      return;
    }
    this.fRv = paramBundle.getIntExtra("key_previous_scene", 7);
    this.oMm = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.azj = paramBundle.getIntExtra("view_type", 0);
    this.oQD = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.hDH = getIntent().getStringExtra("key_template_id");
    if (this.azj == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        ae.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.z(paramBundle, this.fRv, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.oKT.clear();
        this.oKT.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramn instanceof t))
    {
      js(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramn).oGy;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.oCI instanceof g))
          {
            paramn = (g)this.oCI;
            if (paramString != null)
            {
              paramn.oJL.clear();
              paramn.oJL.addAll(paramString);
              paramn.oOI.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramn.oOI.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.oCI.notifyDataSetChanged();
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
    if (this.fRv == 26) {
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