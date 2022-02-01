package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.c.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int lCR;
  private String mAppId;
  private String nSg;
  private int wAu;
  private String wEK;
  private View wEL;
  private LinkedList<wt> wza;
  private int yf;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.yf = 1;
    this.wza = new LinkedList();
    this.nSg = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.yf == 0)
    {
      am.dkO().wqY = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.wAu);
      paramb = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramb.aYi(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.sb(0));
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
    if (this.yf == 1)
    {
      this.wqY = paramCardInfo;
      q(this.wEK, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.wqY != null) {
      com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.wqY.djK().tNW), this.wqY.field_card_tp_id, this.wqY.field_card_id, this.wEK });
    }
    AppMethodBeat.o(113606);
  }
  
  public final BaseAdapter aNu()
  {
    AppMethodBeat.i(113603);
    if (this.yf == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.aNu();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void b(b paramb, int paramInt)
  {
    AppMethodBeat.i(113605);
    if (this.yf == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(113605);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113605);
  }
  
  public final void djb()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.yf == 0)
    {
      setMMTitle(a.g.wqH);
      com.tencent.mm.kernel.h.baD().mCm.a(1099, this);
      i = a.g.wnS;
      if (this.yf != 0) {
        break label165;
      }
      na(true);
      Object localObject = new fhj();
      ((fhj)localObject).abHW = this.nSg;
      Log.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.nSg });
      localObject = new t(this.wza, (fhj)localObject, this.lCR);
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
      i = a.g.wnS;
    }
    for (;;)
    {
      findViewById(a.d.wkE).setVisibility(8);
      ((TextView)findViewById(a.d.wkG)).setText(i);
      AppMethodBeat.o(113602);
      return;
      if (this.yf != 1) {
        break;
      }
      setMMTitle(a.g.woL);
      break;
      label165:
      if (this.yf == 1)
      {
        this.wEL = View.inflate(this, a.e.wnm, null);
        if (this.wqT != null) {
          this.wqT.addView(this.wEL);
        }
        i = a.g.wqn;
      }
    }
  }
  
  public final n.a djc()
  {
    return n.a.wus;
  }
  
  public final boolean dje()
  {
    AppMethodBeat.i(113604);
    if (this.yf == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.dje();
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
    this.lCR = paramBundle.getIntExtra("key_previous_scene", 7);
    this.wAu = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.yf = paramBundle.getIntExtra("view_type", 0);
    this.wEK = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.nSg = getIntent().getStringExtra("key_template_id");
    if (this.yf == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        Log.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.J(paramBundle, this.lCR, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.wza.clear();
        this.wza.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.h.baD().mCm.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramp instanceof t))
    {
      na(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramp).wuE;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.wqR instanceof g))
          {
            paramp = (g)this.wqR;
            if (paramString != null)
            {
              paramp.wyM.clear();
              paramp.wyM.addAll(paramString);
              paramp.wCQ.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramp.wCQ.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.wqR.notifyDataSetChanged();
        }
        AppMethodBeat.o(113608);
        return;
      }
      d.b(this, paramString, paramInt2);
      AppMethodBeat.o(113608);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    AppMethodBeat.o(113608);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(113601);
    super.onSwipeBack();
    if (this.lCR == 26) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewUI
 * JD-Core Version:    0.7.0.1
 */