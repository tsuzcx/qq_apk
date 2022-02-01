package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.ad;
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
  private View EOv;
  private List<String> jkb;
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(265498);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramInt = getIntent().getIntExtra("key_friends_num", 0);
      paramView = new Intent();
      int i = w.P(new int[] { 16, 1, 2, 4, 16384, 64, 65536, 131072 });
      paramView.putExtra("list_type", 0);
      paramView.putExtra("list_attr", i);
      paramView.putExtra("max_limit_num", paramInt);
      paramView.putExtra("titile", getString(a.i.lucky_money_select_contact_title, new Object[] { Integer.valueOf(paramInt) }));
      paramView.putExtra("sub_title", getString(a.i.wechat_wxpay_authenticate));
      c.d(this, ".ui.contact.SelectContactUI", paramView, 1);
      overridePendingTransition(a.a.push_up_in, a.a.fast_faded_out);
      AppMethodBeat.o(265498);
      return;
    }
    paramView = (a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(265498);
      return;
    }
    paramView = paramView.contact;
    if (paramView == null)
    {
      AppMethodBeat.o(265498);
      return;
    }
    String str = paramView.field_username;
    Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { str });
    final Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_User", str);
    paramView = null;
    if (ab.Lj(str)) {
      paramView = getString(a.i.wallet_select_contact_num, new Object[] { Integer.valueOf(v.Pu(str)) });
    }
    ((j)h.ae(j.class)).a(this.mController, str, getString(a.i.retransmit_to_conv_comfirm2), str, paramView, getString(a.i.app_send), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
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
    AppMethodBeat.o(265498);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(65978);
    super.a(paramListView, paramInt);
    if (this.EOv == null)
    {
      View localView = View.inflate(this, a.g.select_conversation_header, null);
      this.EOv = localView.findViewById(a.f.content);
      ((TextView)localView.findViewById(a.f.tip_tv)).setText(a.i.lucky_money_go_select_multi_contact_title);
      paramListView.addHeaderView(localView);
    }
    this.EOv.setVisibility(paramInt);
    AppMethodBeat.o(65978);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(65973);
    super.ata();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(w.hVh());
    localHashSet.addAll(w.hVi());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!Util.isNullOrNil(str)) {
      localHashSet.addAll(Util.stringsToList(str.split(",")));
    }
    this.jkb = new ArrayList();
    this.jkb.addAll(localHashSet);
    AppMethodBeat.o(65973);
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(65975);
    String str = getString(a.i.lucky_money_select_friends);
    AppMethodBeat.o(65975);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(65976);
    ad localad = new ad(this, this.jkb);
    AppMethodBeat.o(65976);
    return localad;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(65977);
    u localu = new u(this, this.jkb, false, this.scene);
    AppMethodBeat.o(65977);
    return localu;
  }
  
  public final int[] dvA()
  {
    return new int[] { 131072 };
  }
  
  public final void eQp()
  {
    AppMethodBeat.i(65979);
    super.eQp();
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
      eQp();
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