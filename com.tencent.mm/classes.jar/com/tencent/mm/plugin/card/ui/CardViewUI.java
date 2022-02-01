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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int awy;
  private int fsv;
  private String gIj;
  private String mAppId;
  private String nDH;
  private View nDI;
  private LinkedList<rp> nxX;
  private int nzq;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.awy = 1;
    this.nxX = new LinkedList();
    this.gIj = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final BaseAdapter VY()
  {
    AppMethodBeat.i(113603);
    if (this.awy == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.VY();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.awy == 0)
    {
      am.bJa().npS = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.nzq);
      paramb = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramb.adn(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.lS(0));
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
    if (this.awy == 1)
    {
      this.npS = paramCardInfo;
      k(this.nDH, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.npS != null) {
      h.vKh.f(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.npS.bHV().lpz), this.npS.field_card_tp_id, this.npS.field_card_id, this.nDH });
    }
    AppMethodBeat.o(113606);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113605);
    if (this.awy == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(113605);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113605);
  }
  
  public final void bHo()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.awy == 0)
    {
      setMMTitle(2131757026);
      com.tencent.mm.kernel.g.afA().gcy.a(1099, this);
      if (this.awy != 0) {
        break label157;
      }
      iF(true);
      Object localObject = new cxe();
      ((cxe)localObject).Epn = this.gIj;
      ad.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.gIj });
      localObject = new t(this.nxX, (cxe)localObject, this.fsv);
      com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
      i = 2131756786;
    }
    for (;;)
    {
      findViewById(2131302870).setVisibility(8);
      ((TextView)findViewById(2131302872)).setText(i);
      AppMethodBeat.o(113602);
      return;
      if (this.awy != 1) {
        break;
      }
      setMMTitle(2131756871);
      break;
      label157:
      if (this.awy == 1)
      {
        this.nDI = View.inflate(this, 2131493316, null);
        if (this.npN != null) {
          this.npN.addView(this.nDI);
        }
        i = 2131757000;
      }
      else
      {
        i = 2131756786;
      }
    }
  }
  
  public final n.a bHp()
  {
    return n.a.ntq;
  }
  
  public final boolean bHr()
  {
    AppMethodBeat.i(113604);
    if (this.awy == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.bHr();
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
    this.fsv = paramBundle.getIntExtra("key_previous_scene", 7);
    this.nzq = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.awy = paramBundle.getIntExtra("view_type", 0);
    this.nDH = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.gIj = getIntent().getStringExtra("key_template_id");
    if (this.awy == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        ad.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.v(paramBundle, this.fsv, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.nxX.clear();
        this.nxX.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.g.afA().gcy.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramn instanceof t))
    {
      iF(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramn).ntC;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.npL instanceof g))
          {
            paramn = (g)this.npL;
            if (paramString != null)
            {
              paramn.nwP.clear();
              paramn.nwP.addAll(paramString);
              paramn.nBM.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramn.nBM.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.npL.notifyDataSetChanged();
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
    if (this.fsv == 26) {
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