package com.tencent.mm.plugin.card.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends DrawStatusBarActivity
  implements f, MMActivity.a
{
  private float dia = -85.0F;
  private float dib = -1000.0F;
  private a.a dig = new CardBaseUI.7(this);
  private com.tencent.mm.ui.base.p dpF = null;
  public com.tencent.mm.modelgeo.c egs;
  private boolean egv = false;
  public ListView ijF = null;
  public BaseAdapter ijG = null;
  public RelativeLayout ijH = null;
  public LinearLayout ijI;
  public LinearLayout ijJ;
  public boolean ijK = false;
  public boolean ijL = true;
  public a ijM = null;
  public CardInfo ijN;
  
  public final void H(LinkedList<String> paramLinkedList)
  {
    ew(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.DO().dJT.a(paramLinkedList, 0);
  }
  
  public void a(b paramb)
  {
    if (!ayT())
    {
      y.e("MicroMsg.CardBaseUI", "isItemClickable return false");
      return;
    }
    if (paramb == null)
    {
      y.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramb.azl())
    {
      if (bk.bl(paramb.azx().sJc)) {
        break label155;
      }
      localArrayList.add(paramb.azx().sJc);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(a.g.app_delete));
      String str = paramb.azB();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.azx().imz);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new CardBaseUI.5(this, paramb, str));
      return;
      label155:
      if (paramb.azj()) {
        localArrayList.add(getResources().getString(a.g.card_menu_invoice_gift_card));
      } else {
        localArrayList.add(getResources().getString(a.g.card_menu_gift_card));
      }
    }
  }
  
  public void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.azB());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    startActivity(localIntent);
    if (ayR() == n.a.ink)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.ups, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.nFQ.f(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (ayR() != n.a.inj)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  public void a(CardInfo paramCardInfo)
  {
    this.ijN = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  public abstract void ayQ();
  
  public n.a ayR()
  {
    return n.a.inf;
  }
  
  public boolean ayS()
  {
    return true;
  }
  
  public boolean ayT()
  {
    return true;
  }
  
  public void ayU() {}
  
  public final void ayV()
  {
    if (this.egs == null) {
      this.egs = com.tencent.mm.modelgeo.c.Ob();
    }
    if (this.egs != null) {
      this.egs.a(this.dig, true);
    }
  }
  
  public final void ayW()
  {
    if (this.egs != null) {
      this.egs.a(this.dig, true);
    }
  }
  
  public final void ayX()
  {
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
  }
  
  public void ayY() {}
  
  public void ayZ() {}
  
  public void aza() {}
  
  public void azb() {}
  
  public void b(b paramb, int paramInt)
  {
    if (!ayS()) {
      y.e("MicroMsg.CardBaseUI", "isItemClickable return false");
    }
    do
    {
      do
      {
        return;
        if (paramb == null)
        {
          y.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
          return;
        }
      } while ((paramb.azB().equals("PRIVATE_TICKET_TITLE")) || (paramb.azB().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.azk())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.azx().sIw));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.azx().sIw, 0);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      l(paramIntent.getStringExtra("Select_Conv_User"), 0, false);
    }
  }
  
  public final void ew(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(a.g.app_waiting), true, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  public int getLayoutId()
  {
    return a.e.card_index_ui;
  }
  
  public void initView()
  {
    setBackBtn(new CardBaseUI.1(this));
    this.ijF = ((ListView)findViewById(16908298));
    this.ijH = ((RelativeLayout)findViewById(a.d.content_no_data));
    if (this.ijH != null) {
      this.ijF.setEmptyView(this.ijH);
    }
    this.ijI = ((LinearLayout)View.inflate(getBaseContext(), a.e.card_list_header_view, null));
    this.ijJ = ((LinearLayout)View.inflate(getBaseContext(), a.e.card_list_footer_view, null));
    this.ijF.addHeaderView(this.ijI);
    this.ijF.addFooterView(this.ijJ);
    this.ijG = xX();
    this.ijF.setAdapter(this.ijG);
    this.ijF.setOnItemClickListener(new CardBaseUI.2(this));
    this.ijF.setOnItemLongClickListener(new CardBaseUI.3(this));
    com.tencent.mm.kernel.g.DO().dJT.a(560, this);
    com.tencent.mm.kernel.g.DO().dJT.a(692, this);
    Object localObject = this.ijG;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.ijM = ((a)localObject);
      this.ijM.onCreate();
      ayQ();
      return;
      if ((localObject instanceof com.tencent.mm.plugin.card.sharecard.ui.c)) {
        localObject = new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c)localObject);
      } else if ((localObject instanceof com.tencent.mm.plugin.card.sharecard.ui.g)) {
        localObject = new com.tencent.mm.plugin.card.sharecard.ui.h((com.tencent.mm.plugin.card.sharecard.ui.g)localObject);
      } else {
        localObject = new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g)localObject);
      }
    }
  }
  
  public final void l(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.ijN == null)
    {
      y.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.ijN.azx() == null)
    {
      y.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.ijN.azz().tIn)) && (!this.ijN.azj()))
      {
        localStringBuilder.append(this.ijN.azz().tIn);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.ijN.azx().ilo), this.ijN.field_card_tp_id, this.ijN.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.ijN.azx().title + "\n" + this.ijN.azx().imA;
      t.a.sdu.a(this.mController, localStringBuilder.toString(), this.ijN.azx().ilp, str, false, getResources().getString(a.g.app_send), new CardBaseUI.6(this, paramString, paramBoolean));
      return;
      localStringBuilder.append(getString(a.g.sns_post_to));
      break;
      if (paramInt == 1)
      {
        localStringBuilder.append(getString(a.g.card_gift_card_dialog_title, new Object[] { this.ijN.azx().imz }));
        com.tencent.mm.plugin.report.service.h.nFQ.f(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.ijN.azx().ilo), this.ijN.field_card_tp_id, this.ijN.field_card_id, paramString });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.g.DO().dJT.b(560, this);
    com.tencent.mm.kernel.g.DO().dJT.b(692, this);
    if (this.ijM != null) {
      this.ijM.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.ijL = false;
    com.tencent.mm.kernel.g.DO().dJT.b(652, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.CardBaseUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      aza();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.ijL = true;
    com.tencent.mm.kernel.g.DO().dJT.a(652, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof r))
      {
        ew(false);
        com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_delete_success_tips));
        am.aAr();
        com.tencent.mm.plugin.card.b.b.oM(4);
        this.ijM.HL();
        azb();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramm instanceof af));
      ew(false);
      paramInt1 = ((af)paramm).ino;
      paramm = ((af)paramm).inp;
      if (paramInt1 == 10000)
      {
        paramString = paramm;
        if (TextUtils.isEmpty(paramm)) {
          paramString = getString(a.g.card_gift_failed_tips);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.ijN != null)
      {
        paramString = this.ijN.azy();
        paramString.status = 3;
        this.ijN.a(paramString);
        if (!am.aAs().c(this.ijN, new String[0])) {
          y.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.ijN.field_card_id });
        }
      }
      this.ijM.HL();
      azb();
      return;
      ew(false);
      str1 = paramString;
      if ((paramm instanceof af))
      {
        paramInt1 = ((af)paramm).ino;
        String str2 = ((af)paramm).inp;
        str1 = paramString;
        if (paramInt1 == 10000)
        {
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = getString(a.g.card_gift_failed_tips);
          }
          str1 = paramString;
        }
      }
    } while (((paramm instanceof x)) || ((paramm instanceof ad)) || ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.ijL));
    com.tencent.mm.plugin.card.d.d.b(this, str1, paramInt2);
  }
  
  public BaseAdapter xX()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, ayR());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */