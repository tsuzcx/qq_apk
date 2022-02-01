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
import com.tencent.mm.al.f;
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
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private float fFf = -85.0F;
  private float fFg = -1000.0F;
  private b.a fFl = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(112568);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.bTo();
        AppMethodBeat.o(112568);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.bUT().N(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.bTn();
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
  private p fQJ = null;
  public com.tencent.mm.modelgeo.d hQo;
  private boolean hQr = false;
  protected ListView owf = null;
  public BaseAdapter owg = null;
  protected RelativeLayout owh = null;
  protected LinearLayout owi;
  protected LinearLayout owj;
  public boolean owk = false;
  protected boolean owl = true;
  public a owm = null;
  protected CardInfo own;
  
  public final void N(LinkedList<String> paramLinkedList)
  {
    jt(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.g.ajB().gAO.a(paramLinkedList, 0);
  }
  
  protected BaseAdapter Zp()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, bTh());
  }
  
  protected void a(final b paramb)
  {
    if (!bTj())
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
    if (paramb.bTA())
    {
      if (bt.isNullOrNil(paramb.bTN().FSk)) {
        break label154;
      }
      localArrayList.add(paramb.bTN().FSk);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(2131755707));
      final String str = paramb.bTR();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.bTN().ozd);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.c()
      {
        public final void lf(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.bTA())
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
      if (paramb.bTy()) {
        localArrayList.add(getResources().getString(2131756937));
      } else {
        localArrayList.add(getResources().getString(2131756936));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.bTR());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramb.ahp(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (bTh() == n.a.ozN)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrQ, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.g.yhR.f(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (bTh() != n.a.ozM)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.own = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!bTi()) {
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
      } while ((paramb.bTR().equals("PRIVATE_TICKET_TITLE")) || (paramb.bTR().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.bTz())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.bTN().FRE));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.bTN().FRE, 0);
  }
  
  protected abstract void bTg();
  
  protected n.a bTh()
  {
    return n.a.ozI;
  }
  
  protected boolean bTi()
  {
    return true;
  }
  
  protected boolean bTj()
  {
    return true;
  }
  
  public final void bTk()
  {
    if (this.hQo == null) {
      this.hQo = com.tencent.mm.modelgeo.d.aHQ();
    }
    if (this.hQo != null) {
      this.hQo.a(this.fFl, true);
    }
  }
  
  protected final void bTl()
  {
    if (this.hQo != null) {
      this.hQo.a(this.fFl, true);
    }
  }
  
  protected final void bTm()
  {
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
  }
  
  protected void bTn() {}
  
  protected void bTo() {}
  
  protected void bTp() {}
  
  protected void bTq() {}
  
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
    this.owf = ((ListView)findViewById(16908298));
    this.owh = ((RelativeLayout)findViewById(2131298768));
    if (this.owh != null) {
      this.owf.setEmptyView(this.owh);
    }
    this.owi = ((LinearLayout)View.inflate(getBaseContext(), 2131493317, null));
    this.owj = ((LinearLayout)View.inflate(getBaseContext(), 2131493314, null));
    this.owf.addHeaderView(this.owi);
    this.owf.addFooterView(this.owj);
    this.owg = Zp();
    this.owf.setAdapter(this.owg);
    this.owf.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (paramAnonymousInt == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= CardBaseUI.this.owg.getCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.owm.Am(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(112563);
      }
    });
    this.owf.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if (i >= CardBaseUI.this.owg.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.owm.Am(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.g.ajB().gAO.a(1077, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1046, this);
    Object localObject = this.owg;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.owm = ((a)localObject);
      this.owm.onCreate();
      bTg();
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
  
  protected final void jt(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.fQJ = p.a(this, getString(2131755936), true, 0, null);
    }
    while ((this.fQJ == null) || (!this.fQJ.isShowing())) {
      return;
    }
    this.fQJ.dismiss();
    this.fQJ = null;
  }
  
  protected final void k(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.own == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.own.bTN() == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.own.bTP().Hsf)) && (!this.own.bTy()))
      {
        localStringBuilder.append(this.own.bTP().Hsf);
        com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.own.bTN().mrl), this.own.field_card_tp_id, this.own.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.own.bTN().title + "\n" + this.own.bTN().oze;
      ab.a.EXc.a(getController(), localStringBuilder.toString(), this.own.bTN().hzB, str, false, getResources().getString(2131755884), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.h.cl(CardBaseUI.this, CardBaseUI.this.getResources().getString(2131756873));
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
        localStringBuilder.append(getString(2131756851, new Object[] { this.own.bTN().ozd }));
        com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.own.bTN().mrl), this.own.field_card_tp_id, this.own.field_card_id, paramString });
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
    com.tencent.mm.kernel.g.ajB().gAO.b(1077, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1046, this);
    if (this.owm != null) {
      this.owm.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.owl = false;
    com.tencent.mm.kernel.g.ajB().gAO.b(1045, this);
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
      bTp();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.owl = true;
    com.tencent.mm.kernel.g.ajB().gAO.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof r))
      {
        jt(false);
        com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131756828));
        am.bUM();
        com.tencent.mm.plugin.card.b.b.Ao(4);
        this.owm.onNotify();
        bTq();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramn instanceof af));
      jt(false);
      paramInt1 = ((af)paramn).ozR;
      paramn = ((af)paramn).ozS;
      if (paramInt1 == 10000)
      {
        paramString = paramn;
        if (TextUtils.isEmpty(paramn)) {
          paramString = getString(2131756852);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.own != null)
      {
        paramString = this.own.bTO();
        paramString.status = 3;
        this.own.a(paramString);
        if (!am.bUN().update(this.own, new String[0])) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.own.field_card_id });
        }
      }
      this.owm.onNotify();
      bTq();
      return;
      jt(false);
      str1 = paramString;
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).ozR;
        String str2 = ((af)paramn).ozS;
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
    } while (((paramn instanceof x)) || ((paramn instanceof com.tencent.mm.plugin.card.model.ad)) || ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.owl));
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