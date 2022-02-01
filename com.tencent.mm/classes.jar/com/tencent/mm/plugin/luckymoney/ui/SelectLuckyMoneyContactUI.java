package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.ae;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI
  extends MMBaseSelectContactUI
{
  private View KIU;
  private List<String> lMF;
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(284224);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramInt = getIntent().getIntExtra("key_friends_num", 0);
      paramAdapterView = new Intent();
      int i = w.R(new int[] { 16, 1, 2, 4, 16384, 64, 65536, 131072 });
      paramAdapterView.putExtra("list_type", 0);
      paramAdapterView.putExtra("list_attr", i);
      paramAdapterView.putExtra("max_limit_num", paramInt);
      paramAdapterView.putExtra("titile", getString(a.i.lucky_money_select_contact_title, new Object[] { Integer.valueOf(paramInt) }));
      paramAdapterView.putExtra("sub_title", getString(a.i.wechat_wxpay_authenticate));
      c.d(this, ".ui.contact.SelectContactUI", paramAdapterView, 1);
      overridePendingTransition(a.a.push_up_in, a.a.fast_faded_out);
      AppMethodBeat.o(284224);
      return;
    }
    paramAdapterView = (a)getContentLV().getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(284224);
      return;
    }
    paramAdapterView = paramAdapterView.contact;
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(284224);
      return;
    }
    paramView = paramAdapterView.field_username;
    Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { paramView });
    final Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_User", paramView);
    paramAdapterView = null;
    if (au.bwE(paramView)) {
      paramAdapterView = getString(a.i.wallet_select_contact_num, new Object[] { Integer.valueOf(v.getMembersCountByChatRoomName(paramView)) });
    }
    ((j)h.ax(j.class)).a(this.mController, paramView, getString(a.i.retransmit_to_conv_comfirm2), paramView, paramAdapterView, getString(a.i.app_send), new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(65972);
        if (paramAnonymousBoolean)
        {
          SelectLuckyMoneyContactUI.this.setResult(-1, localIntent);
          SelectLuckyMoneyContactUI.this.finish();
        }
        AppMethodBeat.o(65972);
      }
    });
    AppMethodBeat.o(284224);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(65978);
    super.a(paramListView, paramInt);
    if (this.KIU == null)
    {
      View localView = View.inflate(this, a.g.select_conversation_header, null);
      this.KIU = localView.findViewById(a.f.content);
      ((TextView)localView.findViewById(a.f.tip_tv)).setText(a.i.lucky_money_go_select_multi_contact_title);
      paramListView.addHeaderView(localView);
    }
    this.KIU.setVisibility(paramInt);
    AppMethodBeat.o(65978);
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(65973);
    super.aNi();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(w.jyV());
    localHashSet.addAll(w.jyW());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!Util.isNullOrNil(str)) {
      localHashSet.addAll(Util.stringsToList(str.split(",")));
    }
    this.lMF = new ArrayList();
    this.lMF.addAll(localHashSet);
    AppMethodBeat.o(65973);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(65976);
    ae localae = new ae(this, this.lMF);
    AppMethodBeat.o(65976);
    return localae;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(65977);
    u localu = new u(this, this.lMF, false, this.scene);
    AppMethodBeat.o(65977);
    return localu;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(65975);
    String str = getString(a.i.lucky_money_select_friends);
    AppMethodBeat.o(65975);
    return str;
  }
  
  public final int[] efu()
  {
    return new int[] { 131072 };
  }
  
  public final void fYZ()
  {
    AppMethodBeat.i(65979);
    super.fYZ();
    hideVKB();
    AppMethodBeat.o(65979);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65981);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        setResult(-1, paramIntent);
        finish();
      }
      AppMethodBeat.o(65981);
      return;
      Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
    }
    Log.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(65981);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65980);
    if (paramInt == 4) {
      fYZ();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(65980);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI
 * JD-Core Version:    0.7.0.1
 */