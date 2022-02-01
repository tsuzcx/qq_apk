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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements com.tencent.mm.al.g, MMActivity.a
{
  private float fjD = -85.0F;
  private float fjE = -1000.0F;
  private b.a fjJ = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(112568);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.bHw();
        AppMethodBeat.o(112568);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.bJb().I(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.bHv();
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
  private p ftP = null;
  public com.tencent.mm.modelgeo.d gXu;
  private boolean gXx = false;
  protected ListView npK = null;
  public BaseAdapter npL = null;
  protected RelativeLayout npM = null;
  protected LinearLayout npN;
  protected LinearLayout npO;
  public boolean npP = false;
  protected boolean npQ = true;
  public a npR = null;
  protected CardInfo npS;
  
  public final void M(LinkedList<String> paramLinkedList)
  {
    iF(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.afA().gcy.a(paramLinkedList, 0);
  }
  
  protected BaseAdapter VY()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, bHp());
  }
  
  protected void a(final b paramb)
  {
    if (!bHr())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "isItemClickable return false");
      return;
    }
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramb.bHI())
    {
      if (bt.isNullOrNil(paramb.bHV().CSq)) {
        break label154;
      }
      localArrayList.add(paramb.bHV().CSq);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(2131755707));
      final String str = paramb.bHZ();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.bHV().nsJ);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
      {
        public final void kM(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.bHI())
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
      if (paramb.bHG()) {
        localArrayList.add(getResources().getString(2131756937));
      } else {
        localArrayList.add(getResources().getString(2131756936));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.bHZ());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramb.adn(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (bHp() == n.a.ntt)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FhJ, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.vKh.f(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (bHp() != n.a.nts)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.npS = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!bHq()) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "isItemClickable return false");
    }
    do
    {
      do
      {
        return;
        if (paramb == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
          return;
        }
      } while ((paramb.bHZ().equals("PRIVATE_TICKET_TITLE")) || (paramb.bHZ().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.bHH())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.bHV().CRK));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.bHV().CRK, 0);
  }
  
  protected abstract void bHo();
  
  protected n.a bHp()
  {
    return n.a.nto;
  }
  
  protected boolean bHq()
  {
    return true;
  }
  
  protected boolean bHr()
  {
    return true;
  }
  
  public final void bHs()
  {
    if (this.gXu == null) {
      this.gXu = com.tencent.mm.modelgeo.d.axT();
    }
    if (this.gXu != null) {
      this.gXu.a(this.fjJ, true);
    }
  }
  
  protected final void bHt()
  {
    if (this.gXu != null) {
      this.gXu.a(this.fjJ, true);
    }
  }
  
  protected final void bHu()
  {
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
  }
  
  protected void bHv() {}
  
  protected void bHw() {}
  
  protected void bHx() {}
  
  protected void bHy() {}
  
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
  
  protected final void iF(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.ftP = p.a(this, getString(2131755936), true, 0, null);
    }
    while ((this.ftP == null) || (!this.ftP.isShowing())) {
      return;
    }
    this.ftP.dismiss();
    this.ftP = null;
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
    this.npK = ((ListView)findViewById(16908298));
    this.npM = ((RelativeLayout)findViewById(2131298768));
    if (this.npM != null) {
      this.npK.setEmptyView(this.npM);
    }
    this.npN = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
    this.npO = ((LinearLayout)View.inflate(getBaseContext(), 2131493314, null));
    this.npK.addHeaderView(this.npN);
    this.npK.addFooterView(this.npO);
    this.npL = VY();
    this.npK.setAdapter(this.npL);
    this.npK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        if (paramAnonymousInt == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
          AppMethodBeat.o(112563);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.npL.getCount())
        {
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.npR.yN(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        AppMethodBeat.o(112563);
      }
    });
    this.npK.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112564);
        if (paramAnonymousInt == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
          AppMethodBeat.o(112564);
          return true;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.npL.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.npR.yN(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.g.afA().gcy.a(1077, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1046, this);
    Object localObject = this.npL;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.npR = ((a)localObject);
      this.npR.onCreate();
      bHo();
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
  
  protected final void k(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.npS == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.npS.bHV() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.npS.bHX().Ekz)) && (!this.npS.bHG()))
      {
        localStringBuilder.append(this.npS.bHX().Ekz);
        com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.npS.bHV().lpz), this.npS.field_card_tp_id, this.npS.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.npS.bHV().title + "\n" + this.npS.bHV().nsK;
      ab.a.BZI.a(getController(), localStringBuilder.toString(), this.npS.bHV().gGR, str, false, getResources().getString(2131755884), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.h.cf(CardBaseUI.this, CardBaseUI.this.getResources().getString(2131756873));
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
        localStringBuilder.append(getString(2131756851, new Object[] { this.npS.bHV().nsJ }));
        com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.npS.bHV().lpz), this.npS.field_card_tp_id, this.npS.field_card_id, paramString });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.g.afA().gcy.b(1077, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1046, this);
    if (this.npR != null) {
      this.npR.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.npQ = false;
    com.tencent.mm.kernel.g.afA().gcy.b(1045, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      bHx();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.npQ = true;
    com.tencent.mm.kernel.g.afA().gcy.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof r))
      {
        iF(false);
        com.tencent.mm.ui.base.h.cf(this, getResources().getString(2131756828));
        am.bIU();
        com.tencent.mm.plugin.card.b.b.yP(4);
        this.npR.onNotify();
        bHy();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramn instanceof af));
      iF(false);
      paramInt1 = ((af)paramn).ntx;
      paramn = ((af)paramn).nty;
      if (paramInt1 == 10000)
      {
        paramString = paramn;
        if (TextUtils.isEmpty(paramn)) {
          paramString = getString(2131756852);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.npS != null)
      {
        paramString = this.npS.bHW();
        paramString.status = 3;
        this.npS.a(paramString);
        if (!am.bIV().update(this.npS, new String[0])) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.npS.field_card_id });
        }
      }
      this.npR.onNotify();
      bHy();
      return;
      iF(false);
      str1 = paramString;
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).ntx;
        String str2 = ((af)paramn).nty;
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
    } while (((paramn instanceof x)) || ((paramn instanceof com.tencent.mm.plugin.card.model.ad)) || ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.npQ));
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