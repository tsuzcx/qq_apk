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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
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
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements i, MMActivity.a
{
  private b.a gmA = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(112568);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.csr();
        AppMethodBeat.o(112568);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.ctW().R(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.csq();
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
  private float gmu = -85.0F;
  private float gmv = -1000.0F;
  private com.tencent.mm.ui.base.q gxX = null;
  public com.tencent.mm.modelgeo.d iOv;
  private boolean iOy = false;
  protected ListView pQq = null;
  public BaseAdapter pQr = null;
  protected RelativeLayout pQs = null;
  protected LinearLayout pQt;
  protected LinearLayout pQu;
  public boolean pQv = false;
  protected boolean pQw = true;
  public a pQx = null;
  protected CardInfo pQy;
  
  public final void P(LinkedList<String> paramLinkedList)
  {
    ku(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramLinkedList, 0);
  }
  
  protected void a(final b paramb)
  {
    if (!csm())
    {
      Log.e("MicroMsg.CardBaseUI", "isItemClickable return false");
      return;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramb.csD())
    {
      if (Util.isNullOrNil(paramb.csQ().Lfl)) {
        break label154;
      }
      localArrayList.add(paramb.csQ().Lfl);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(2131755778));
      final String str = paramb.csU();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.csQ().pTn);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.d()
      {
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.csD())
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
      if (paramb.csB()) {
        localArrayList.add(getResources().getString(2131757107));
      } else {
        localArrayList.add(getResources().getString(2131757106));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.csU());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramb.axQ(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (csk() == n.a.pTV)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUo, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.CyF.a(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (csk() != n.a.pTU)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.pQy = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected BaseAdapter anl()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, csk());
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!csl()) {
      Log.e("MicroMsg.CardBaseUI", "isItemClickable return false");
    }
    do
    {
      do
      {
        return;
        if (paramb == null)
        {
          Log.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
          return;
        }
      } while ((paramb.csU().equals("PRIVATE_TICKET_TITLE")) || (paramb.csU().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.csC())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.csQ().LeG));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.csQ().LeG, 0);
  }
  
  protected abstract void csj();
  
  protected n.a csk()
  {
    return n.a.pTQ;
  }
  
  protected boolean csl()
  {
    return true;
  }
  
  protected boolean csm()
  {
    return true;
  }
  
  public final void csn()
  {
    if (this.iOv == null) {
      this.iOv = com.tencent.mm.modelgeo.d.bca();
    }
    if (this.iOv != null) {
      this.iOv.a(this.gmA, true);
    }
  }
  
  protected final void cso()
  {
    if (this.iOv != null) {
      this.iOv.a(this.gmA, true);
    }
  }
  
  protected final void csp()
  {
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
  }
  
  protected void csq() {}
  
  protected void csr() {}
  
  protected void css() {}
  
  protected void cst() {}
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      l(paramIntent.getStringExtra("Select_Conv_User"), 0, false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493399;
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
    this.pQq = ((ListView)findViewById(16908298));
    this.pQs = ((RelativeLayout)findViewById(2131299212));
    if (this.pQs != null) {
      this.pQq.setEmptyView(this.pQs);
    }
    this.pQt = ((LinearLayout)View.inflate(getBaseContext(), 2131493408, null));
    this.pQu = ((LinearLayout)View.inflate(getBaseContext(), 2131493405, null));
    this.pQq.addHeaderView(this.pQt);
    this.pQq.addFooterView(this.pQu);
    this.pQr = anl();
    this.pQq.setAdapter(this.pQr);
    this.pQq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt == 0)
        {
          Log.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.pQr.getCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.pQx.Ed(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(112563);
      }
    });
    this.pQq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112564);
        if (paramAnonymousInt == 0)
        {
          Log.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
          AppMethodBeat.o(112564);
          return true;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.pQr.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.pQx.Ed(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.g.aAg().hqi.a(1077, this);
    com.tencent.mm.kernel.g.aAg().hqi.a(1046, this);
    Object localObject = this.pQr;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.pQx = ((a)localObject);
      this.pQx.onCreate();
      csj();
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
  
  protected final void ku(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131756029), true, 0, null);
    }
    while ((this.gxX == null) || (!this.gxX.isShowing())) {
      return;
    }
    this.gxX.dismiss();
    this.gxX = null;
  }
  
  protected final void l(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.pQy == null)
    {
      Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.pQy.csQ() == null)
    {
      Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.pQy.csS().MXq)) && (!this.pQy.csB()))
      {
        localStringBuilder.append(this.pQy.csS().MXq);
        com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.pQy.csQ().nHh), this.pQy.field_card_tp_id, this.pQy.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.pQy.csQ().title + "\n" + this.pQy.csQ().gTG;
      ab.a.Kgn.a(getController(), localStringBuilder.toString(), this.pQy.csQ().iwv, str, false, getResources().getString(2131755976), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.h.cD(CardBaseUI.this, CardBaseUI.this.getResources().getString(2131757038));
            if (paramBoolean) {
              CardBaseUI.this.finish();
            }
          }
          AppMethodBeat.o(112567);
        }
      });
      return;
      localStringBuilder.append(getString(2131766179));
      break;
      if (paramInt == 1)
      {
        localStringBuilder.append(getString(2131757016, new Object[] { this.pQy.csQ().pTn }));
        com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.pQy.csQ().nHh), this.pQy.field_card_tp_id, this.pQy.field_card_id, paramString });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    Log.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.g.aAg().hqi.b(1077, this);
    com.tencent.mm.kernel.g.aAg().hqi.b(1046, this);
    if (this.pQx != null) {
      this.pQx.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.pQw = false;
    com.tencent.mm.kernel.g.aAg().hqi.b(1045, this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      return;
    }
    Log.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      css();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131757785), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.pQw = true;
    com.tencent.mm.kernel.g.aAg().hqi.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof r))
      {
        ku(false);
        com.tencent.mm.ui.base.h.cD(this, getResources().getString(2131756993));
        am.ctP();
        com.tencent.mm.plugin.card.b.b.Ef(4);
        this.pQx.onNotify();
        cst();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramq instanceof af));
      ku(false);
      paramInt1 = ((af)paramq).pTZ;
      paramq = ((af)paramq).pUa;
      if (paramInt1 == 10000)
      {
        paramString = paramq;
        if (TextUtils.isEmpty(paramq)) {
          paramString = getString(2131757017);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.pQy != null)
      {
        paramString = this.pQy.csR();
        paramString.status = 3;
        this.pQy.a(paramString);
        if (!am.ctQ().update(this.pQy, new String[0])) {
          Log.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.pQy.field_card_id });
        }
      }
      this.pQx.onNotify();
      cst();
      return;
      ku(false);
      str1 = paramString;
      if ((paramq instanceof af))
      {
        paramInt1 = ((af)paramq).pTZ;
        String str2 = ((af)paramq).pUa;
        str1 = paramString;
        if (paramInt1 == 10000)
        {
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = getString(2131757017);
          }
          str1 = paramString;
        }
      }
    } while (((paramq instanceof x)) || ((paramq instanceof ad)) || ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.pQw));
    com.tencent.mm.plugin.card.d.d.b(this, str1, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */