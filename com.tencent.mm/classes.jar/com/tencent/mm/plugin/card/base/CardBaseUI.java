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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
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
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements i, MMActivity.a
{
  private float iQD = -85.0F;
  private float iQE = -1000.0F;
  private b.a iQJ = new b.a()
  {
    public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
    {
      AppMethodBeat.i(112568);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.cFS();
        AppMethodBeat.o(112568);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.cHy().T(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.cFR();
      }
      if (!CardBaseUI.c(CardBaseUI.this))
      {
        CardBaseUI.d(CardBaseUI.this);
        n.a(2010, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      }
      AppMethodBeat.o(112568);
      return false;
    }
  };
  private s jhZ = null;
  private com.tencent.mm.modelgeo.d lEL;
  private boolean lEO = false;
  protected ListView tmq = null;
  public BaseAdapter tmr = null;
  protected RelativeLayout tms = null;
  protected LinearLayout tmt;
  protected LinearLayout tmu;
  public boolean tmv = false;
  protected boolean tmw = true;
  public a tmx = null;
  protected CardInfo tmy;
  
  public final void N(LinkedList<String> paramLinkedList)
  {
    lG(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramLinkedList, 0);
  }
  
  protected void a(final b paramb)
  {
    if (!cFM())
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
    if (paramb.cGe())
    {
      if (Util.isNullOrNil(paramb.cGs().Sgz)) {
        break label155;
      }
      localArrayList.add(paramb.cGs().Sgz);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(a.g.app_delete));
      final String str = paramb.cGw();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.cGs().tpo);
      com.tencent.mm.ui.base.h.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new h.d()
      {
        public final void qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.cGe())
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
      label155:
      if (paramb.cGc()) {
        localArrayList.add(getResources().getString(a.g.tld));
      } else {
        localArrayList.add(getResources().getString(a.g.tlc));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.cGw());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramb.aFh(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (cFK() == n.a.tpW)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vio, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.IzE.a(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (cFK() != n.a.tpV)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.tmy = paramCardInfo;
    com.tencent.mm.plugin.card.d.b.a(this, 0, this);
  }
  
  protected BaseAdapter atn()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, cFK());
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!cFL()) {
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
      } while ((paramb.cGw().equals("PRIVATE_TICKET_TITLE")) || (paramb.cGw().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.cGd())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.cGs().SfU));
    com.tencent.mm.plugin.card.d.b.a(this, paramb.cGs().SfU, 0);
  }
  
  protected abstract void cFJ();
  
  protected n.a cFK()
  {
    return n.a.tpR;
  }
  
  protected boolean cFL()
  {
    return true;
  }
  
  protected boolean cFM()
  {
    return true;
  }
  
  public final void cFN()
  {
    if (this.lEL == null) {
      this.lEL = com.tencent.mm.modelgeo.d.blq();
    }
    if (this.lEL != null) {
      this.lEL.a(this.iQJ, true);
    }
  }
  
  public final void cFO()
  {
    this.lEL = com.tencent.mm.modelgeo.d.blq();
  }
  
  protected final void cFP()
  {
    if (this.lEL != null) {
      this.lEL.a(this.iQJ, true);
    }
  }
  
  protected final void cFQ()
  {
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
  }
  
  protected void cFR() {}
  
  protected void cFS() {}
  
  protected void cFT() {}
  
  protected void cFU() {}
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      p(paramIntent.getStringExtra("Select_Conv_User"), 0, false);
    }
  }
  
  public int getLayoutId()
  {
    return a.e.tiH;
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
    this.tmq = ((ListView)findViewById(16908298));
    this.tms = ((RelativeLayout)findViewById(a.d.tfq));
    if (this.tms != null) {
      this.tmq.setEmptyView(this.tms);
    }
    this.tmt = ((LinearLayout)View.inflate(getBaseContext(), a.e.tiQ, null));
    this.tmu = ((LinearLayout)View.inflate(getBaseContext(), a.e.tiN, null));
    this.tmq.addHeaderView(this.tmt);
    this.tmq.addFooterView(this.tmu);
    this.tmr = atn();
    this.tmq.setAdapter(this.tmr);
    this.tmq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
        if (i >= CardBaseUI.this.tmr.getCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.tmx.HE(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(112563);
      }
    });
    this.tmq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if (i >= CardBaseUI.this.tmr.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.tmx.HE(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.h.aHF().kcd.a(1077, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1046, this);
    Object localObject = this.tmr;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.tmx = ((a)localObject);
      this.tmx.onCreate();
      cFJ();
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
  
  protected final void lG(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jhZ = s.a(this, getString(a.g.app_waiting), true, 0, null);
    }
    while ((this.jhZ == null) || (!this.jhZ.isShowing())) {
      return;
    }
    this.jhZ.dismiss();
    this.jhZ = null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    Log.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.h.aHF().kcd.b(1077, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1046, this);
    if (this.tmx != null) {
      this.tmx.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.tmw = false;
    com.tencent.mm.kernel.h.aHF().kcd.b(1045, this);
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
      cFT();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.tmw = true;
    com.tencent.mm.kernel.h.aHF().kcd.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof r))
      {
        lG(false);
        com.tencent.mm.ui.base.h.cO(this, getResources().getString(a.g.tjZ));
        am.cHr();
        com.tencent.mm.plugin.card.b.b.HG(4);
        this.tmx.onNotify();
        cFU();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramq instanceof af));
      lG(false);
      paramInt1 = ((af)paramq).tqa;
      paramq = ((af)paramq).tqb;
      if (paramInt1 == 10000)
      {
        paramString = paramq;
        if (TextUtils.isEmpty(paramq)) {
          paramString = getString(a.g.tkk);
        }
        com.tencent.mm.plugin.card.d.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.tmy != null)
      {
        paramString = this.tmy.cGt();
        paramString.status = 3;
        this.tmy.a(paramString);
        if (!am.cHs().update(this.tmy, new String[0])) {
          Log.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.tmy.field_card_id });
        }
      }
      this.tmx.onNotify();
      cFU();
      return;
      lG(false);
      str1 = paramString;
      if ((paramq instanceof af))
      {
        paramInt1 = ((af)paramq).tqa;
        String str2 = ((af)paramq).tqb;
        str1 = paramString;
        if (paramInt1 == 10000)
        {
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = getString(a.g.tkk);
          }
          str1 = paramString;
        }
      }
    } while (((paramq instanceof x)) || ((paramq instanceof ad)) || ((paramq instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.tmw));
    com.tencent.mm.plugin.card.d.d.b(this, str1, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void p(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.tmy == null)
    {
      Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.tmy.cGs() == null)
    {
      Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.tmy.cGu().UjL)) && (!this.tmy.cGc()))
      {
        localStringBuilder.append(this.tmy.cGu().UjL);
        com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.tmy.cGs().qJt), this.tmy.field_card_tp_id, this.tmy.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.tmy.cGs().title + "\n" + this.tmy.cGs().jEi;
      ab.a.RgY.a(getController(), localStringBuilder.toString(), this.tmy.cGs().llI, str, false, getResources().getString(a.g.app_send), new y.a()
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.h.cO(CardBaseUI.this, CardBaseUI.this.getResources().getString(a.g.tkp));
            if (paramBoolean) {
              CardBaseUI.this.finish();
            }
          }
          AppMethodBeat.o(112567);
        }
      });
      return;
      localStringBuilder.append(getString(a.g.sns_post_to));
      break;
      if (paramInt == 1)
      {
        localStringBuilder.append(getString(a.g.tkj, new Object[] { this.tmy.cGs().tpo }));
        com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.tmy.cGs().qJt), this.tmy.field_card_tp_id, this.tmy.field_card_id, paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */