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
import com.tencent.mm.ak.f;
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
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements f, MMActivity.a
{
  private float fHj = -85.0F;
  private float fHk = -1000.0F;
  private b.a fHp = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(112568);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.bUD();
        AppMethodBeat.o(112568);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.bWi().N(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.bUC();
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
  private p fSP = null;
  public com.tencent.mm.modelgeo.d hTg;
  private boolean hTj = false;
  protected ListView oCH = null;
  public BaseAdapter oCI = null;
  protected RelativeLayout oCJ = null;
  protected LinearLayout oCK;
  protected LinearLayout oCL;
  public boolean oCM = false;
  protected boolean oCN = true;
  public a oCO = null;
  protected CardInfo oCP;
  
  public final void N(LinkedList<String> paramLinkedList)
  {
    js(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramLinkedList, 0);
  }
  
  protected BaseAdapter Zy()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, bUw());
  }
  
  protected void a(final b paramb)
  {
    if (!bUy())
    {
      ae.e("MicroMsg.CardBaseUI", "isItemClickable return false");
      return;
    }
    if (paramb == null)
    {
      ae.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramb.bUP())
    {
      if (bu.isNullOrNil(paramb.bVc().GkJ)) {
        break label154;
      }
      localArrayList.add(paramb.bVc().GkJ);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(2131755707));
      final String str = paramb.bVg();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.bVc().oFF);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
      {
        public final void lh(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.bUP())
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
      if (paramb.bUN()) {
        localArrayList.add(getResources().getString(2131756937));
      } else {
        localArrayList.add(getResources().getString(2131756936));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.bVg());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramb.ahE(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (bUw() == n.a.oGp)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMm, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.g.yxI.f(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (bUw() != n.a.oGo)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.oCP = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!bUx()) {
      ae.e("MicroMsg.CardBaseUI", "isItemClickable return false");
    }
    do
    {
      do
      {
        return;
        if (paramb == null)
        {
          ae.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
          return;
        }
      } while ((paramb.bVg().equals("PRIVATE_TICKET_TITLE")) || (paramb.bVg().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.bUO())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.bVc().Gkd));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.bVc().Gkd, 0);
  }
  
  protected final void bUA()
  {
    if (this.hTg != null) {
      this.hTg.a(this.fHp, true);
    }
  }
  
  protected final void bUB()
  {
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
  }
  
  protected void bUC() {}
  
  protected void bUD() {}
  
  protected void bUE() {}
  
  protected void bUF() {}
  
  protected abstract void bUv();
  
  protected n.a bUw()
  {
    return n.a.oGk;
  }
  
  protected boolean bUx()
  {
    return true;
  }
  
  protected boolean bUy()
  {
    return true;
  }
  
  public final void bUz()
  {
    if (this.hTg == null) {
      this.hTg = com.tencent.mm.modelgeo.d.aIh();
    }
    if (this.hTg != null) {
      this.hTg.a(this.fHp, true);
    }
  }
  
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
    this.oCH = ((ListView)findViewById(16908298));
    this.oCJ = ((RelativeLayout)findViewById(2131298768));
    if (this.oCJ != null) {
      this.oCH.setEmptyView(this.oCJ);
    }
    this.oCK = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
    this.oCL = ((LinearLayout)View.inflate(getBaseContext(), 2131493314, null));
    this.oCH.addHeaderView(this.oCK);
    this.oCH.addFooterView(this.oCL);
    this.oCI = Zy();
    this.oCH.setAdapter(this.oCI);
    this.oCH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (paramAnonymousInt == 0)
        {
          ae.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.oCI.getCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.oCO.Ay(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(112563);
      }
    });
    this.oCH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112564);
        if (paramAnonymousInt == 0)
        {
          ae.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
          AppMethodBeat.o(112564);
          return true;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.oCI.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.oCO.Ay(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.g.ajQ().gDv.a(1077, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1046, this);
    Object localObject = this.oCI;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.oCO = ((a)localObject);
      this.oCO.onCreate();
      bUv();
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
  
  protected final void js(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.fSP = p.a(this, getString(2131755936), true, 0, null);
    }
    while ((this.fSP == null) || (!this.fSP.isShowing())) {
      return;
    }
    this.fSP.dismiss();
    this.fSP = null;
  }
  
  protected final void k(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.oCP == null)
    {
      ae.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.oCP.bVc() == null)
    {
      ae.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.oCP.bVe().HLH)) && (!this.oCP.bUN()))
      {
        localStringBuilder.append(this.oCP.bVe().HLH);
        com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.oCP.bVc().mwj), this.oCP.field_card_tp_id, this.oCP.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.oCP.bVc().title + "\n" + this.oCP.bVc().oFG;
      ab.a.Fpw.a(getController(), localStringBuilder.toString(), this.oCP.bVc().hCp, str, false, getResources().getString(2131755884), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.h.cm(CardBaseUI.this, CardBaseUI.this.getResources().getString(2131756873));
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
        localStringBuilder.append(getString(2131756851, new Object[] { this.oCP.bVc().oFF }));
        com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.oCP.bVc().mwj), this.oCP.field_card_tp_id, this.oCP.field_card_id, paramString });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    ae.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.g.ajQ().gDv.b(1077, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1046, this);
    if (this.oCO != null) {
      this.oCO.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.oCN = false;
    com.tencent.mm.kernel.g.ajQ().gDv.b(1045, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      return;
    }
    ae.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      bUE();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.oCN = true;
    com.tencent.mm.kernel.g.ajQ().gDv.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof r))
      {
        js(false);
        com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756828));
        am.bWb();
        com.tencent.mm.plugin.card.b.b.AA(4);
        this.oCO.onNotify();
        bUF();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramn instanceof af));
      js(false);
      paramInt1 = ((af)paramn).oGt;
      paramn = ((af)paramn).oGu;
      if (paramInt1 == 10000)
      {
        paramString = paramn;
        if (TextUtils.isEmpty(paramn)) {
          paramString = getString(2131756852);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.oCP != null)
      {
        paramString = this.oCP.bVd();
        paramString.status = 3;
        this.oCP.a(paramString);
        if (!am.bWc().update(this.oCP, new String[0])) {
          ae.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.oCP.field_card_id });
        }
      }
      this.oCO.onNotify();
      bUF();
      return;
      js(false);
      str1 = paramString;
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).oGt;
        String str2 = ((af)paramn).oGu;
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
    } while (((paramn instanceof x)) || ((paramn instanceof ad)) || ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.oCN));
    com.tencent.mm.plugin.card.d.d.b(this, str1, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */