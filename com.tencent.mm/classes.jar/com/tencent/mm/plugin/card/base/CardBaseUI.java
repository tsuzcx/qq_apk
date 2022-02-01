package com.tencent.mm.plugin.card.base;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.d.a;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.ui.applet.ac;
import com.tencent.mm.pluginsdk.ui.applet.ac.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI
  extends MMActivity
  implements com.tencent.mm.am.h, MMActivity.a
{
  private w lKp = null;
  private float lsA = -1000.0F;
  private b.a lsF = new b.a()
  {
    public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
    {
      AppMethodBeat.i(293727);
      if (!paramAnonymousBoolean)
      {
        CardBaseUI.this.djk();
        AppMethodBeat.o(293727);
        return true;
      }
      if ((paramAnonymousFloat2 != -85.0F) && (paramAnonymousFloat1 != -1000.0F))
      {
        CardBaseUI.a(CardBaseUI.this, paramAnonymousFloat2);
        CardBaseUI.b(CardBaseUI.this, paramAnonymousFloat1);
        am.dkP().aB(CardBaseUI.a(CardBaseUI.this), CardBaseUI.b(CardBaseUI.this));
        CardBaseUI.this.djj();
      }
      if (!CardBaseUI.c(CardBaseUI.this))
      {
        CardBaseUI.d(CardBaseUI.this);
        n.a(2010, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
      }
      AppMethodBeat.o(293727);
      return false;
    }
  };
  private float lsz = -85.0F;
  private com.tencent.mm.modelgeo.d owr;
  private boolean owu = false;
  protected ListView wqQ = null;
  public BaseAdapter wqR = null;
  protected RelativeLayout wqS = null;
  protected LinearLayout wqT;
  protected LinearLayout wqU;
  public boolean wqV = false;
  protected boolean wqW = true;
  public a wqX = null;
  protected CardInfo wqY;
  
  public final void P(LinkedList<String> paramLinkedList)
  {
    na(true);
    paramLinkedList = new r(paramLinkedList);
    com.tencent.mm.kernel.h.baD().mCm.a(paramLinkedList, 0);
  }
  
  protected void a(final b paramb)
  {
    if (!dje())
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
    if (paramb.djw())
    {
      if (Util.isNullOrNil(paramb.djK().Zeu)) {
        break label155;
      }
      localArrayList.add(paramb.djK().Zeu);
    }
    for (;;)
    {
      localArrayList.add(getResources().getString(a.g.app_delete));
      final String str = paramb.djO();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramb.djK().wtN);
      com.tencent.mm.ui.base.k.a(this, localStringBuilder.toString(), (String[])localArrayList.toArray(new String[localArrayList.size()]), null, new k.d()
      {
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(112566);
          if (paramb.djw())
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
      if (paramb.dju()) {
        localArrayList.add(getResources().getString(a.g.wpC));
      } else {
        localArrayList.add(getResources().getString(a.g.wpB));
      }
    }
  }
  
  protected void a(b paramb, int paramInt)
  {
    Intent localIntent = new Intent(this, CardDetailUI.class);
    localIntent.putExtra("key_card_id", paramb.djO());
    localIntent.addFlags(131072);
    localIntent.putExtra("key_from_scene", 3);
    paramb = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramb.aYi(), "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramb.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/base/CardBaseUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (djc() == n.a.wuv)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) });
      i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJI, Integer.valueOf(3))).intValue();
      com.tencent.mm.plugin.report.service.h.OAn.b(15767, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt + 1) });
    }
    while (djc() != n.a.wuu)
    {
      int i;
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(11324, new Object[] { "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected void a(CardInfo paramCardInfo)
  {
    this.wqY = paramCardInfo;
    com.tencent.mm.plugin.card.c.b.a(this, 0, this);
  }
  
  protected BaseAdapter aNu()
  {
    return new com.tencent.mm.plugin.card.ui.c(this, djc());
  }
  
  protected void b(b paramb, int paramInt)
  {
    if (!djd()) {
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
      } while ((paramb.djO().equals("PRIVATE_TICKET_TITLE")) || (paramb.djO().equals("PRIVATE_INVOICE_TITLE")));
      if (paramb.djv())
      {
        a(paramb, paramInt);
        return;
      }
    } while (TextUtils.isEmpty(paramb.djK().ZdP));
    com.tencent.mm.plugin.card.c.b.a(this, paramb.djK().ZdP, 0);
  }
  
  protected abstract void djb();
  
  protected n.a djc()
  {
    return n.a.wuq;
  }
  
  protected boolean djd()
  {
    return true;
  }
  
  protected boolean dje()
  {
    return true;
  }
  
  public final void djf()
  {
    if (this.owr == null) {
      this.owr = com.tencent.mm.modelgeo.d.bJl();
    }
    if (this.owr != null)
    {
      this.owr.a(this.lsF, true, true);
      l.kK(22, 10);
    }
  }
  
  public final void djg()
  {
    this.owr = com.tencent.mm.modelgeo.d.bJl();
  }
  
  protected final void djh()
  {
    if (this.owr != null)
    {
      this.owr.a(this.lsF, true, true);
      l.kK(22, 10);
    }
  }
  
  protected final void dji()
  {
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
  }
  
  protected void djj() {}
  
  protected void djk() {}
  
  protected void djl() {}
  
  protected void djm() {}
  
  public int getLayoutId()
  {
    return a.e.wne;
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
    this.wqQ = ((ListView)findViewById(16908298));
    this.wqS = ((RelativeLayout)findViewById(a.d.wjH));
    if (this.wqS != null) {
      this.wqQ.setEmptyView(this.wqS);
    }
    this.wqT = ((LinearLayout)View.inflate(getBaseContext(), a.e.wnn, null));
    this.wqU = ((LinearLayout)View.inflate(getBaseContext(), a.e.wnk, null));
    this.wqQ.addHeaderView(this.wqT);
    this.wqQ.addFooterView(this.wqU);
    this.wqR = aNu();
    this.wqQ.setAdapter(this.wqR);
    this.wqQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(112563);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
        if (i >= CardBaseUI.this.wqR.getCount())
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(112563);
          return;
        }
        paramAnonymousAdapterView = CardBaseUI.this.wqX.If(i);
        CardBaseUI.this.b(paramAnonymousAdapterView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/base/CardBaseUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(112563);
      }
    });
    this.wqQ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if (i >= CardBaseUI.this.wqR.getCount())
        {
          AppMethodBeat.o(112564);
          return true;
        }
        paramAnonymousAdapterView = CardBaseUI.this.wqX.If(i);
        CardBaseUI.this.a(paramAnonymousAdapterView);
        AppMethodBeat.o(112564);
        return true;
      }
    });
    com.tencent.mm.kernel.h.baD().mCm.a(1077, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1046, this);
    Object localObject = this.wqR;
    if ((localObject instanceof com.tencent.mm.plugin.card.ui.c)) {
      localObject = new com.tencent.mm.plugin.card.ui.d((com.tencent.mm.plugin.card.ui.c)localObject);
    }
    for (;;)
    {
      this.wqX = ((a)localObject);
      this.wqX.onCreate();
      djb();
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
  
  public void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1)) {
      q(paramIntent.getStringExtra("Select_Conv_User"), 0, false);
    }
  }
  
  protected final void na(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.lKp = w.a(this, getString(a.g.app_waiting), true, 0, null);
    }
    while ((this.lKp == null) || (!this.lKp.isShowing())) {
      return;
    }
    this.lKp.dismiss();
    this.lKp = null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    Log.d("MicroMsg.CardBaseUI", "destroy card");
    com.tencent.mm.kernel.h.baD().mCm.b(1077, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1046, this);
    if (this.wqX != null) {
      this.wqX.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.wqW = false;
    com.tencent.mm.kernel.h.baD().mCm.b(1045, this);
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
      djl();
      return;
    }
    com.tencent.mm.ui.base.k.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new CardBaseUI.8(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.wqW = true;
    com.tencent.mm.kernel.h.baD().mCm.a(1045, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof r))
      {
        na(false);
        com.tencent.mm.ui.base.k.cZ(this, getResources().getString(a.g.wox));
        am.dkI();
        com.tencent.mm.plugin.card.mgr.a.Ih(4);
        this.wqX.onNotify();
        djm();
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (!(paramp instanceof af));
      na(false);
      paramInt1 = ((af)paramp).wuz;
      paramp = ((af)paramp).wuA;
      if (paramInt1 == 10000)
      {
        paramString = paramp;
        if (TextUtils.isEmpty(paramp)) {
          paramString = getString(a.g.woI);
        }
        com.tencent.mm.plugin.card.c.d.b(this, paramString, paramInt1);
        return;
      }
      if (this.wqY != null)
      {
        paramString = this.wqY.djL();
        paramString.status = 3;
        this.wqY.a(paramString);
        if (!am.dkJ().update(this.wqY, new String[0])) {
          Log.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[] { this.wqY.field_card_id });
        }
      }
      this.wqX.onNotify();
      djm();
      return;
      na(false);
      str1 = paramString;
      if ((paramp instanceof af))
      {
        paramInt1 = ((af)paramp).wuz;
        String str2 = ((af)paramp).wuA;
        str1 = paramString;
        if (paramInt1 == 10000)
        {
          paramString = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString = getString(a.g.woI);
          }
          str1 = paramString;
        }
      }
    } while (((paramp instanceof x)) || ((paramp instanceof ad)) || ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.b)) || (!this.wqW));
    com.tencent.mm.plugin.card.c.d.b(this, str1, paramInt2);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void q(final String paramString, int paramInt, final boolean paramBoolean)
  {
    if (this.wqY == null)
    {
      Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
      return;
    }
    if (this.wqY.djK() == null)
    {
      Log.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      if ((!TextUtils.isEmpty(this.wqY.djM().abBp)) && (!this.wqY.dju()))
      {
        localStringBuilder.append(this.wqY.djM().abBp);
        com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OperGift", Integer.valueOf(2), Integer.valueOf(this.wqY.djK().tNW), this.wqY.field_card_tp_id, this.wqY.field_card_id, paramString });
      }
    }
    for (;;)
    {
      String str = this.wqY.djK().title + "\n" + this.wqY.djK().mee;
      ac.a.Yde.a(getController(), localStringBuilder.toString(), this.wqY.djK().nQG, str, false, getResources().getString(a.g.app_send), new y.a()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(112567);
          if (paramAnonymousBoolean)
          {
            CardBaseUI.c(CardBaseUI.this, paramString);
            com.tencent.mm.ui.base.k.cZ(CardBaseUI.this, CardBaseUI.this.getResources().getString(a.g.woN));
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
        localStringBuilder.append(getString(a.g.woH, new Object[] { this.wqY.djK().wtN }));
        com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OperGift", Integer.valueOf(3), Integer.valueOf(this.wqY.djK().tNW), this.wqY.field_card_tp_id, this.wqY.field_card_id, paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI
 * JD-Core Version:    0.7.0.1
 */