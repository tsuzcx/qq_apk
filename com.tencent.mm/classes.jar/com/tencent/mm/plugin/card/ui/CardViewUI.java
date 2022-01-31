package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public class CardViewUI
  extends CardBaseUI
{
  private int amH = 1;
  private String dRD = "";
  private int drX;
  private LinkedList<mh> irx = new LinkedList();
  private int isT;
  private String ixl;
  private View ixm;
  
  protected final void a(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    if (this.amH == 0)
    {
      am.aAx().ijN = ((CardInfo)paramb);
      Intent localIntent = new Intent(this, CardDetailUI.class);
      localIntent.putExtra("key_card_id", ((CardInfo)paramb).field_card_id);
      localIntent.putExtra("key_from_scene", 51);
      localIntent.putExtra("key_from_appbrand_type", this.isT);
      startActivity(localIntent);
      return;
    }
    super.a(paramb, paramInt);
  }
  
  protected final void a(CardInfo paramCardInfo)
  {
    if (this.amH == 1)
    {
      this.ijN = paramCardInfo;
      l(this.ixl, 1, true);
    }
    do
    {
      return;
      super.a(paramCardInfo);
    } while (this.ijN == null);
    h.nFQ.f(11582, new Object[] { "OperGift", Integer.valueOf(4), Integer.valueOf(this.ijN.azx().ilo), this.ijN.field_card_tp_id, this.ijN.field_card_id, this.ixl });
  }
  
  protected final void ayQ()
  {
    int i;
    if (this.amH == 0)
    {
      setMMTitle(a.g.card_view_ui_title);
      com.tencent.mm.kernel.g.DO().dJT.a(699, this);
      i = a.g.card_accept_card_list_no_card_tips;
      if (this.amH != 0) {
        break label155;
      }
      ew(true);
      Object localObject = new bvk();
      ((bvk)localObject).tMg = this.dRD;
      y.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.dRD });
      localObject = new t(this.irx, (bvk)localObject, this.drX);
      com.tencent.mm.kernel.g.DO().dJT.a((m)localObject, 0);
      i = a.g.card_accept_card_list_no_card_tips;
    }
    for (;;)
    {
      findViewById(a.d.no_card_tip_img).setVisibility(8);
      ((TextView)findViewById(a.d.no_card_tip_text)).setText(i);
      return;
      if (this.amH != 1) {
        break;
      }
      setMMTitle(a.g.card_gift_ui_title);
      break;
      label155:
      if (this.amH == 1)
      {
        this.ixm = View.inflate(this, a.e.card_list_header_tip_layout, null);
        if (this.ijI != null) {
          this.ijI.addView(this.ixm);
        }
        i = a.g.card_show_none_gift_card;
      }
    }
  }
  
  protected final n.a ayR()
  {
    return n.a.inh;
  }
  
  protected final boolean ayT()
  {
    if (this.amH == 1) {
      return false;
    }
    return super.ayT();
  }
  
  protected final void ayU() {}
  
  protected final void b(com.tencent.mm.plugin.card.base.b paramb, int paramInt)
  {
    if (this.amH == 1)
    {
      a((CardInfo)paramb);
      return;
    }
    super.b(paramb, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      y.e("MicroMsg.CardViewUI", "onCreate intent is null");
      finish();
      return;
    }
    this.drX = paramBundle.getIntExtra("key_previous_scene", 7);
    this.isT = paramBundle.getIntExtra("key_from_appbrand_type", 0);
    this.amH = paramBundle.getIntExtra("view_type", 0);
    this.ixl = paramBundle.getStringExtra("user_name");
    paramBundle = paramBundle.getStringExtra("card_list");
    this.dRD = getIntent().getStringExtra("key_template_id");
    if (this.amH == 0)
    {
      if (TextUtils.isEmpty(paramBundle))
      {
        y.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
        finish();
        return;
      }
      paramBundle = k.bp(paramBundle, this.drX);
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        this.irx.clear();
        this.irx.addAll(paramBundle);
      }
    }
    initView();
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(699, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    if ((paramm instanceof t))
    {
      ew(false);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((t)paramm).inv;
        if ((paramString != null) && (paramString.size() > 0))
        {
          if ((this.ijG instanceof g))
          {
            paramm = (g)this.ijG;
            if (paramString != null)
            {
              paramm.iqo.clear();
              paramm.iqo.addAll(paramString);
              paramm.ivp.clear();
              paramInt1 = i;
              while (paramInt1 < paramString.size())
              {
                paramm.ivp.add(new Boolean(true));
                paramInt1 += 1;
              }
            }
          }
          this.ijG.notifyDataSetChanged();
        }
        return;
      }
      d.b(this, paramString, paramInt2);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    if (this.drX == 26) {
      overridePendingTransition(0, 0);
    }
  }
  
  protected final BaseAdapter xX()
  {
    if (this.amH == 0) {
      return new g(getApplicationContext());
    }
    return super.xX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardViewUI
 * JD-Core Version:    0.7.0.1
 */