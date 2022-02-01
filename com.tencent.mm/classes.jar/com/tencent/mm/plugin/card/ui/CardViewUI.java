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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int azh;
  private int gwE;
  private String ixM;
  private String mAppId;
  private LinkedList<va> pYH;
  private int qaa;
  private String qer;
  private View qes;
  
  public CardViewUI()
  {
    AppMethodBeat.i(113598);
    this.azh = 1;
    this.pYH = new LinkedList();
    this.ixM = "";
    this.mAppId = "";
    AppMethodBeat.o(113598);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113607);
    if (this.azh == 0)
    {
      am.ctV().pQy = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.qaa);
      paramb = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramb.axQ(), "com/tencent/mm/plugin/card/ui/CardViewUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramb.pG(0));
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
    if (this.azh == 1)
    {
      this.pQy = paramCardInfo;
      l(this.qer, 1, true);
      AppMethodBeat.o(113606);
      return;
    }
    super.a(paramCardInfo);
    if (this.pQy != null) {
      h.CyF.a(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.pQy.csQ().nHh), this.pQy.field_card_tp_id, this.pQy.field_card_id, this.qer });
    }
    AppMethodBeat.o(113606);
  }
  
  public final BaseAdapter anl()
  {
    AppMethodBeat.i(113603);
    if (this.azh == 0)
    {
      localObject = new g(getApplicationContext());
      AppMethodBeat.o(113603);
      return localObject;
    }
    Object localObject = super.anl();
    AppMethodBeat.o(113603);
    return localObject;
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    AppMethodBeat.i(113605);
    if (this.azh == 1)
    {
      a((CardInfo)paramb);
      AppMethodBeat.o(113605);
      return;
    }
    super.b(paramb, paramInt);
    AppMethodBeat.o(113605);
  }
  
  public final void csj()
  {
    AppMethodBeat.i(113602);
    int i;
    if (this.azh == 0)
    {
      setMMTitle(2131757196);
      com.tencent.mm.kernel.g.aAg().hqi.a(1099, this);
      if (this.azh != 0) {
        break label157;
      }
      ku(true);
      Object localObject = new eck();
      ((eck)localObject).NcB = this.ixM;
      Log.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.ixM });
      localObject = new com.tencent.mm.plugin.card.model.t(this.pYH, (eck)localObject, this.gwE);
      com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject, 0);
      i = 2131756951;
    }
    for (;;)
    {
      findViewById(2131305443).setVisibility(8);
      ((TextView)findViewById(2131305445)).setText(i);
      AppMethodBeat.o(113602);
      return;
      if (this.azh != 1) {
        break;
      }
      setMMTitle(2131757036);
      break;
      label157:
      if (this.azh == 1)
      {
        this.qes = View.inflate(this, 2131493407, null);
        if (this.pQt != null) {
          this.pQt.addView(this.qes);
        }
        i = 2131757170;
      }
      else
      {
        i = 2131756951;
      }
    }
  }
  
  public final n.a csk()
  {
    return n.a.pTS;
  }
  
  public final boolean csm()
  {
    AppMethodBeat.i(113604);
    if (this.azh == 1)
    {
      AppMethodBeat.o(113604);
      return false;
    }
    boolean bool = super.csm();
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
    this.gwE = paramBundle.getIntExtra("key_previous_scene", 7);
    this.qaa = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.azh = paramBundle.getIntExtra("view_type", 0);
    this.qer = paramBundle.getStringExtra("user_name");
    this.mAppId = paramBundle.getStringExtra("key_app_id");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.ixM = getIntent().getStringExtra("key_template_id");
    if (this.azh == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        Log.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        AppMethodBeat.o(113599);
        return;
      }
      paramBundle = k.G(paramBundle, this.gwE, this.mAppId);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.pYH.clear();
        this.pYH.addAll(paramBundle);
      }
    }
    initView();
    AppMethodBeat.o(113599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113600);
    com.tencent.mm.kernel.g.aAg().hqi.b(1099, this);
    super.onDestroy();
    AppMethodBeat.o(113600);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(113608);
    if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
    {
      ku(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.card.model.t)paramq).pUe;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.pQr instanceof g))
          {
            paramq = (g)this.pQr;
            if (paramString != null)
            {
              paramq.pXz.clear();
              paramq.pXz.addAll(paramString);
              paramq.qcw.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramq.qcw.add(Boolean.TRUE);
                paramInt1 += 1;
              }
            }
          }
          this.pQr.notifyDataSetChanged();
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
    if (this.gwE == 26) {
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