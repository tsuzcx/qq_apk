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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int axs;
  private int fwc;
  private String hiK;
  private String mAppId;
  private LinkedList<rz> oaX;
  private int ocr;
  private String ogI;
  private View ogJ;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.axs = 1;
    this.oaX = new LinkedList();
    this.hiK = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final BaseAdapter WW()
  {
    AppMethodBeat.i(113603);
    if (this.axs == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.WW();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.axs == 0)
    {
      am.bQn().nSS = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.ocr);
      paramb = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramb.aeD(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.lR(0));
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
    if (this.axs == 1)
    {
      this.nSS = paramCardInfo;
      k(this.ogI, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.nSS != null) {
      h.wUl.f(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.nSS.bPi().lRv), this.nSS.field_card_tp_id, this.nSS.field_card_id, this.ogI });
    }
    AppMethodBeat.o(113606);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113605);
    if (this.axs == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(113605);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113605);
  }
  
  public final void bOB()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.axs == 0)
    {
      setMMTitle(2131757026);
      com.tencent.mm.kernel.g.agQ().ghe.a(1099, this);
      if (this.axs != 0) {
        break label157;
      }
      ji(true);
      Object localObject = new dcq();
      ((dcq)localObject).FMm = this.hiK;
      ac.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.hiK });
      localObject = new t(this.oaX, (dcq)localObject, this.fwc);
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
      i = 2131756786;
    }
    for (;;)
    {
      findViewById(2131302870).setVisibility(8);
      ((TextView)findViewById(2131302872)).setText(i);
      AppMethodBeat.o(113602);
      return;
      if (this.axs != 1) {
        break;
      }
      setMMTitle(2131756871);
      break;
      label157:
      if (this.axs == 1)
      {
        this.ogJ = View.inflate(this, 2131493316, null);
        if (this.nSN != null) {
          this.nSN.addView(this.ogJ);
        }
        i = 2131757000;
      }
      else
      {
        i = 2131756786;
      }
    }
  }
  
  public final n.a bOC()
  {
    return n.a.nWq;
  }
  
  public final boolean bOE()
  {
    AppMethodBeat.i(113604);
    if (this.axs == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.bOE();
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
      ac.e("MicroMsg.CardViewUI", "onCreate intent is null");
      finish();
      AppMethodBeat.o(113599);
      return;
    }
    this.fwc = paramBundle.getIntExtra("key_previous_scene", 7);
    this.ocr = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.axs = paramBundle.getIntExtra("view_type", 0);
    this.ogI = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.hiK = getIntent().getStringExtra("key_template_id");
    if (this.axs == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        ac.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.v(paramBundle, this.fwc, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.oaX.clear();
        this.oaX.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.g.agQ().ghe.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramn instanceof t))
    {
      ji(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramn).nWC;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.nSL instanceof g))
          {
            paramn = (g)this.nSL;
            if (paramString != null)
            {
              paramn.nZP.clear();
              paramn.nZP.addAll(paramString);
              paramn.oeM.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramn.oeM.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.nSL.notifyDataSetChanged();
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
    if (this.fwc == 26) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewUI
 * JD-Core Version:    0.7.0.1
 */