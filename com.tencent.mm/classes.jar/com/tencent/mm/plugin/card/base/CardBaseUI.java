package com.tencent.mm.plugin.card.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
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
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements f, MMActivity.a
{
  private b.a dZA = new CardBaseUI.7(this);
  private float dZu = -85.0F;
  private float dZv = -1000.0F;
  private com.tencent.mm.ui.base.p ehb = null;
  public com.tencent.mm.modelgeo.d fwu;
  private boolean fwx = false;
  protected ListView kkF = null;
  public BaseAdapter kkG = null;
  protected RelativeLayout kkH = null;
  protected LinearLayout kkI;
  protected LinearLayout kkJ;
  public boolean kkK = false;
  protected boolean kkL = true;
  public a kkM = null;
  protected CardInfo kkN;
  
  public final void H(LinkedList<String> paramLinkedList)
  {
    fV(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.RK().eHt.a(paramLinkedList, 0);
  }
  
  protected BaseAdapter Kp()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, bay());
  }
  
  protected void a(b paramb)
  {
    if (!baA())
    {
      ab.e("MicroMsg.CardBaseUI", "isItemClickable return false");
      return;
    }
    if (paramb == null)
    {
      ab.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramb.baR())
    {
      if (bo.isNullOrNil(paramb.bbd().wGL)) {
        break label154;
      }
      localArrayList.add(paramb.bbd().wGL);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(2131296901));
      String str = paramb.bbh();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.bbd().knv);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new CardBaseUI.5(this, paramb, str));
      return;
      label154:
      if (paramb.baP()) {
        localArrayList.add(getResources().getString(2131297995));
      } else {
        localArrayList.add(getResources().getString(2131297994));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.bbh());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    startActivity(localIntent);
    if (bay() == n.a.kof)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzo, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.qsU.e(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (bay() != n.a.koe)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.kkN = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!baz()) {
      ab.e("MicroMsg.CardBaseUI", "isItemClickable return false");
    }
    do
    {
      do
      {
        return;
        if (paramb == null)
        {
          ab.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
          return;
        }
      } while ((paramb.bbh().equals("PRIVATE_TICKET_TITLE")) || (paramb.bbh().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.baQ())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.bbd().wGf));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.bbd().wGf, 0);
  }
  
  protected boolean baA()
  {
    return true;
  }
  
  public final void baB()
  {
    if (this.fwu == null) {
      this.fwu = com.tencent.mm.modelgeo.d.agQ();
    }
    if (this.fwu != null) {
      this.fwu.a(this.dZA, true);
    }
  }
  
  protected final void baC()
  {
    if (this.fwu != null) {
      this.fwu.a(this.dZA, true);
    }
  }
  
  protected final void baD()
  {
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
  }
  
  protected void baE() {}
  
  protected void baF() {}
  
  protected void baG() {}
  
  protected void baH() {}
  
  protected abstract void bax();
  
  protected n.a bay()
  {
    return n.a.koa;
  }
  
  protected boolean baz()
  {
    return true;
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      l(paramIntent.getStringExtra("Select_Conv_User"), 0, false);
    }
  }
  
  protected final void fV(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131297112), true, null);
    }
    while ((this.ehb == null) || (!this.ehb.isShowing())) {
      return;
    }
    this.ehb.dismiss();
    this.ehb = null;
  }
  
  public int getLayoutId()
  {
    return 2130968958;
  }
  
  public void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(87617);
        CardBaseUI.this.finish();
        AppMethodBeat.o(87617);
        return true;
      }
    });
    this.kkF = ((ListView)findViewById(16908298));
    this.kkH = ((RelativeLayout)findViewById(2131821981));
    if (this.kkH != null) {
      this.kkF.setEmptyView(this.kkH);
    }
    this.kkI = ((LinearLayout)View.inflate(getBaseContext(), 2130968966, null));
    this.kkJ = ((LinearLayout)View.inflate(getBaseContext(), 2130968963, null));
    this.kkF.addHeaderView(this.kkI);
    this.kkF.addFooterView(this.kkJ);
    this.kkG = Kp();
    this.kkF.setAdapter(this.kkG);
    this.kkF.setOnItemClickListener(new CardBaseUI.2(this));
    this.kkF.setOnItemLongClickListener(new CardBaseUI.3(this));
    com.tencent.mm.kernel.g.RK().eHt.a(560, this);
    com.tencent.mm.kernel.g.RK().eHt.a(692, this);
    Object localObject = this.kkG;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.kkM = ((a)localObject);
      this.kkM.onCreate();
      bax();
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
  
  protected final void l(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.kkN == null)
    {
      ab.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.kkN.bbd() == null)
    {
      ab.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.kkN.bbf().xMB)) && (!this.kkN.baP()))
      {
        localStringBuilder.append(this.kkN.bbf().xMB);
        com.tencent.mm.plugin.report.service.h.qsU.e(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.kkN.bbd().iFL), this.kkN.field_card_tp_id, this.kkN.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.kkN.bbd().title + "\n" + this.kkN.bbd().knw;
      t.a.vUz.a(getController(), localStringBuilder.toString(), this.kkN.bbd().kmm, str, false, getResources().getString(2131297067), new CardBaseUI.6(this, paramString, paramBoolean));
      return;
      localStringBuilder.append(getString(2131303934));
      break;
      if (paramInt == 1)
      {
        localStringBuilder.append(getString(2131297919, new Object[] { this.kkN.bbd().knv }));
        com.tencent.mm.plugin.report.service.h.qsU.e(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.kkN.bbd().iFL), this.kkN.field_card_tp_id, this.kkN.field_card_id, paramString });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    ab.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.g.RK().eHt.b(560, this);
    com.tencent.mm.kernel.g.RK().eHt.b(692, this);
    if (this.kkM != null) {
      this.kkM.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.kkL = false;
    com.tencent.mm.kernel.g.RK().eHt.b(652, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      return;
    }
    ab.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      baG();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131298499), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.kkL = true;
    com.tencent.mm.kernel.g.RK().eHt.a(652, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof r))
      {
        fV(false);
        com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297896));
        am.bcc();
        com.tencent.mm.plugin.card.b.b.sW(4);
        this.kkM.aaK();
        baH();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramm instanceof af));
      fV(false);
      paramInt1 = ((af)paramm).koj;
      paramm = ((af)paramm).kok;
      if (paramInt1 == 10000)
      {
        paramString = paramm;
        if (TextUtils.isEmpty(paramm)) {
          paramString = getString(2131297920);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.kkN != null)
      {
        paramString = this.kkN.bbe();
        paramString.status = 3;
        this.kkN.a(paramString);
        if (!am.bcd().update(this.kkN, new String[0])) {
          ab.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.kkN.field_card_id });
        }
      }
      this.kkM.aaK();
      baH();
      return;
      fV(false);
      str1 = paramString;
      if ((paramm instanceof af))
      {
        paramInt1 = ((af)paramm).koj;
        String str2 = ((af)paramm).kok;
        str1 = paramString;
        if (paramInt1 == 10000)
        {
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = getString(2131297920);
          }
          str1 = paramString;
        }
      }
    } while (((paramm instanceof x)) || ((paramm instanceof ad)) || ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.kkL));
    com.tencent.mm.plugin.card.d.d.b(this, str1, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */