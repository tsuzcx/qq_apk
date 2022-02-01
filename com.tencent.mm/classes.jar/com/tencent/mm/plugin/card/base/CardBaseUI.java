package com.tencent.mm.plugin.card.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements com.tencent.mm.ak.g, MMActivity.a
{
  private float fmX = -85.0F;
  private float fmY = -1000.0F;
  private b.a fnd = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(112568);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.bOJ();
        AppMethodBeat.o(112568);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.bQo().L(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.bOI();
      }
      if (!CardBaseUI.c(CardBaseUI.this))
      {
        CardBaseUI.d(CardBaseUI.this);
        o.a(2010, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      }
      AppMethodBeat.o(112568);
      return false;
    }
  };
  private p fxw = null;
  public com.tencent.mm.modelgeo.d hxT;
  private boolean hxW = false;
  protected ListView nSK = null;
  public BaseAdapter nSL = null;
  protected RelativeLayout nSM = null;
  protected LinearLayout nSN;
  protected LinearLayout nSO;
  public boolean nSP = false;
  protected boolean nSQ = true;
  public a nSR = null;
  protected CardInfo nSS;
  
  public final void M(LinkedList<String> paramLinkedList)
  {
    ji(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramLinkedList, 0);
  }
  
  protected BaseAdapter WW()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, bOC());
  }
  
  protected void a(final b paramb)
  {
    if (!bOE())
    {
      ac.e("MicroMsg.CardBaseUI", "isItemClickable return false");
      return;
    }
    if (paramb == null)
    {
      ac.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramb.bOV())
    {
      if (bs.isNullOrNil(paramb.bPi().Elb)) {
        break label154;
      }
      localArrayList.add(paramb.bPi().Elb);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(2131755707));
      final String str = paramb.bPm();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.bPi().nVJ);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
      {
        public final void kG(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.bOV())
          {
            switch (paramAnonymousInt)
            {
            default: 
              AppMethodBeat.o(112566);
              return;
            case 0: 
              CardBaseUI.this.a((CardInfo)paramb);
              AppMethodBeat.o(112566);
              return;
            }
            CardBaseUI.b(CardBaseUI.this, str);
            AppMethodBeat.o(112566);
            return;
          }
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(112566);
            return;
            CardBaseUI.b(CardBaseUI.this, str);
          }
        }
      });
      return;
      label154:
      if (paramb.bOT()) {
        localArrayList.add(getResources().getString(2131756937));
      } else {
        localArrayList.add(getResources().getString(2131756936));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.bPm());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramb.aeD(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (bOC() == n.a.nWt)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFy, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.wUl.f(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (bOC() != n.a.nWs)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.nSS = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!bOD()) {
      ac.e("MicroMsg.CardBaseUI", "isItemClickable return false");
    }
    do
    {
      do
      {
        return;
        if (paramb == null)
        {
          ac.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
          return;
        }
      } while ((paramb.bPm().equals("PRIVATE_TICKET_TITLE")) || (paramb.bPm().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.bOU())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.bPi().Ekv));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.bPi().Ekv, 0);
  }
  
  protected abstract void bOB();
  
  protected n.a bOC()
  {
    return n.a.nWo;
  }
  
  protected boolean bOD()
  {
    return true;
  }
  
  protected boolean bOE()
  {
    return true;
  }
  
  public final void bOF()
  {
    if (this.hxT == null) {
      this.hxT = com.tencent.mm.modelgeo.d.aEL();
    }
    if (this.hxT != null) {
      this.hxT.a(this.fnd, true);
    }
  }
  
  protected final void bOG()
  {
    if (this.hxT != null) {
      this.hxT.a(this.fnd, true);
    }
  }
  
  protected final void bOH()
  {
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
  }
  
  protected void bOI() {}
  
  protected void bOJ() {}
  
  protected void bOK() {}
  
  protected void bOL() {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      k(paramIntent.getStringExtra("Select_Conv_User"), 0, false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493309;
  }
  
  public void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(112562);
        CardBaseUI.this.finish();
        AppMethodBeat.o(112562);
        return true;
      }
    });
    this.nSK = ((ListView)findViewById(16908298));
    this.nSM = ((RelativeLayout)findViewById(2131298768));
    if (this.nSM != null) {
      this.nSK.setEmptyView(this.nSM);
    }
    this.nSN = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
    this.nSO = ((LinearLayout)View.inflate(getBaseContext(), 2131493314, null));
    this.nSK.addHeaderView(this.nSN);
    this.nSK.addFooterView(this.nSO);
    this.nSL = WW();
    this.nSK.setAdapter(this.nSL);
    this.nSK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        if (paramAnonymousInt == 0)
        {
          ac.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
          AppMethodBeat.o(112563);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.nSL.getCount())
        {
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.nSR.zD(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        AppMethodBeat.o(112563);
      }
    });
    this.nSK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112564);
        if (paramAnonymousInt == 0)
        {
          ac.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
          AppMethodBeat.o(112564);
          return true;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.nSL.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.nSR.zD(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.g.agQ().ghe.a(1077, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1046, this);
    Object localObject = this.nSL;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.nSR = ((a)localObject);
      this.nSR.onCreate();
      bOB();
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
  
  protected final void ji(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.fxw = p.a(this, getString(2131755936), true, 0, null);
    }
    while ((this.fxw == null) || (!this.fxw.isShowing())) {
      return;
    }
    this.fxw.dismiss();
    this.fxw = null;
  }
  
  protected final void k(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.nSS == null)
    {
      ac.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.nSS.bPi() == null)
    {
      ac.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.nSS.bPk().FHx)) && (!this.nSS.bOT()))
      {
        localStringBuilder.append(this.nSS.bPk().FHx);
        com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.nSS.bPi().lRv), this.nSS.field_card_tp_id, this.nSS.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.nSS.bPi().title + "\n" + this.nSS.bPi().nVK;
      ab.a.DrY.a(getController(), localStringBuilder.toString(), this.nSS.bPi().hhs, str, false, getResources().getString(2131755884), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.h.cg(CardBaseUI.this, CardBaseUI.this.getResources().getString(2131756873));
            if (paramBoolean) {
              CardBaseUI.this.finish();
            }
          }
          AppMethodBeat.o(112567);
        }
      });
      return;
      localStringBuilder.append(getString(2131763948));
      break;
      if (paramInt == 1)
      {
        localStringBuilder.append(getString(2131756851, new Object[] { this.nSS.bPi().nVJ }));
        com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.nSS.bPi().lRv), this.nSS.field_card_tp_id, this.nSS.field_card_id, paramString });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    ac.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.g.agQ().ghe.b(1077, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1046, this);
    if (this.nSR != null) {
      this.nSR.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.nSQ = false;
    com.tencent.mm.kernel.g.agQ().ghe.b(1045, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      return;
    }
    ac.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      bOK();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.nSQ = true;
    com.tencent.mm.kernel.g.agQ().ghe.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof r))
      {
        ji(false);
        com.tencent.mm.ui.base.h.cg(this, getResources().getString(2131756828));
        am.bQh();
        com.tencent.mm.plugin.card.b.b.zF(4);
        this.nSR.onNotify();
        bOL();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramn instanceof af));
      ji(false);
      paramInt1 = ((af)paramn).nWx;
      paramn = ((af)paramn).nWy;
      if (paramInt1 == 10000)
      {
        paramString = paramn;
        if (TextUtils.isEmpty(paramn)) {
          paramString = getString(2131756852);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.nSS != null)
      {
        paramString = this.nSS.bPj();
        paramString.status = 3;
        this.nSS.a(paramString);
        if (!am.bQi().update(this.nSS, new String[0])) {
          ac.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.nSS.field_card_id });
        }
      }
      this.nSR.onNotify();
      bOL();
      return;
      ji(false);
      str1 = paramString;
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).nWx;
        String str2 = ((af)paramn).nWy;
        str1 = paramString;
        if (paramInt1 == 10000)
        {
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = getString(2131756852);
          }
          str1 = paramString;
        }
      }
    } while (((paramn instanceof x)) || ((paramn instanceof ad)) || ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.nSQ));
    com.tencent.mm.plugin.card.d.d.b(this, str1, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */