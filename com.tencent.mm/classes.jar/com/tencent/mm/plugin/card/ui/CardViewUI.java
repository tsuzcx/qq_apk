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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int jaR;
  private String lnb;
  private String mAppId;
  private String tAo;
  private View tAp;
  private LinkedList<vc> tuD;
  private int tvW;
  private int xk;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.xk = 1;
    this.tuD = new LinkedList();
    this.lnb = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.xk == 0)
    {
      am.cHx().tmy = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.tvW);
      paramb = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramb.aFh(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(113607);
      return;
    }
    super.a(paramb, paramInt);
    AppMethodBeat.o(113607);
  }
  
  public final void a(CardInfo paramCardInfo)
  {
    AppMethodBeat.i(113606);
    if (this.xk == 1)
    {
      this.tmy = paramCardInfo;
      p(this.tAo, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.tmy != null) {
      com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.tmy.cGs().qJt), this.tmy.field_card_tp_id, this.tmy.field_card_id, this.tAo });
    }
    AppMethodBeat.o(113606);
  }
  
  public final BaseAdapter atn()
  {
    AppMethodBeat.i(113603);
    if (this.xk == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.atn();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void b(b paramb, int paramInt)
  {
    AppMethodBeat.i(113605);
    if (this.xk == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(113605);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113605);
  }
  
  public final void cFJ()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.xk == 0)
    {
      setMMTitle(a.g.tmi);
      com.tencent.mm.kernel.h.aHF().kcd.a(1099, this);
      i = a.g.tjv;
      if (this.xk != 0) {
        break label165;
      }
      lG(true);
      Object localObject = new eml();
      ((eml)localObject).UoY = this.lnb;
      Log.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.lnb });
      localObject = new com.tencent.mm.plugin.card.model.t(this.tuD, (eml)localObject, this.jaR);
      com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
      i = a.g.tjv;
    }
    for (;;)
    {
      findViewById(a.d.tgi).setVisibility(8);
      ((TextView)findViewById(a.d.tgk)).setText(i);
      AppMethodBeat.o(113602);
      return;
      if (this.xk != 1) {
        break;
      }
      setMMTitle(a.g.tkn);
      break;
      label165:
      if (this.xk == 1)
      {
        this.tAp = View.inflate(this, a.e.tiP, null);
        if (this.tmt != null) {
          this.tmt.addView(this.tAp);
        }
        i = a.g.tlO;
      }
    }
  }
  
  public final n.a cFK()
  {
    return n.a.tpT;
  }
  
  public final boolean cFM()
  {
    AppMethodBeat.i(113604);
    if (this.xk == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.cFM();
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
      Log.e("MicroMsg.CardViewUI", "onCreate intent is null");
      finish();
      AppMethodBeat.o(113599);
      return;
    }
    this.jaR = paramBundle.getIntExtra("key_previous_scene", 7);
    this.tvW = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.xk = paramBundle.getIntExtra("view_type", 0);
    this.tAo = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.lnb = getIntent().getStringExtra("key_template_id");
    if (this.xk == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        Log.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.H(paramBundle, this.jaR, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.tuD.clear();
        this.tuD.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.h.aHF().kcd.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
    {
      lG(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.card.model.t)paramq).tqf;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.tmr instanceof g))
          {
            paramq = (g)this.tmr;
            if (paramString != null)
            {
              paramq.tup.clear();
              paramq.tup.addAll(paramString);
              paramq.tyt.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramq.tyt.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.tmr.notifyDataSetChanged();
        }
        AppMethodBeat.o(113608);
        return;
      }
      d.b(this, paramString, paramInt2);
      AppMethodBeat.o(113608);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(113608);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(113601);
    super.onSwipeBack();
    if (this.jaR == 26) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewUI
 * JD-Core Version:    0.7.0.1
 */