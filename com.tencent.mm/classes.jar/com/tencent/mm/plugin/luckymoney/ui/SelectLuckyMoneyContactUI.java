package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI
  extends MMBaseSelectContactUI
{
  private List<String> dru;
  private View lYc;
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    return getString(a.i.lucky_money_select_friends);
  }
  
  protected final o VF()
  {
    return new x(this, this.dru);
  }
  
  protected final com.tencent.mm.ui.contact.m VG()
  {
    return new q(this, this.dru, false, this.scene);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    super.a(paramListView, paramInt);
    if (this.lYc == null)
    {
      View localView = View.inflate(this, a.g.select_conversation_header, null);
      this.lYc = localView.findViewById(a.f.content);
      ((TextView)localView.findViewById(a.f.tip_tv)).setText(a.i.lucky_money_go_select_multi_contact_title);
      paramListView.addHeaderView(localView);
    }
    this.lYc.setVisibility(paramInt);
  }
  
  public final int[] bgw()
  {
    return new int[] { 131072 };
  }
  
  protected final void bgx()
  {
    super.bgx();
    XM();
  }
  
  public final void jP(int paramInt)
  {
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      y.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      y.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramInt = getIntent().getIntExtra("key_friends_num", 0);
      localObject = new Intent();
      int i = com.tencent.mm.ui.contact.s.v(new int[] { 16, 1, 2, 4, 16384, 64, 65536, 131072 });
      ((Intent)localObject).putExtra("list_type", 0);
      ((Intent)localObject).putExtra("list_attr", i);
      ((Intent)localObject).putExtra("max_limit_num", paramInt);
      ((Intent)localObject).putExtra("titile", getString(a.i.lucky_money_select_contact_title, new Object[] { Integer.valueOf(paramInt) }));
      ((Intent)localObject).putExtra("sub_title", getString(a.i.wechat_wxpay_authenticate));
      d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      overridePendingTransition(a.a.push_up_in, a.a.fast_faded_out);
    }
    do
    {
      do
      {
        return;
        localObject = (a)getContentLV().getAdapter().getItem(paramInt);
      } while (localObject == null);
      localObject = ((a)localObject).dnp;
    } while (localObject == null);
    String str = ((ao)localObject).field_username;
    y.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { str });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_User", str);
    Object localObject = null;
    if (com.tencent.mm.model.s.fn(str)) {
      localObject = getString(a.i.wallet_select_contact_num, new Object[] { Integer.valueOf(com.tencent.mm.model.m.gM(str)) });
    }
    ((h)g.r(h.class)).a(this.mController, str, getString(a.i.retransmit_to_conv_comfirm2), str, (String)localObject, getString(a.i.app_send), new SelectLuckyMoneyContactUI.1(this, localIntent));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      y.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        setResult(-1, paramIntent);
        finish();
      }
      return;
      y.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
    }
    y.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + paramInt1);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      bgx();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void xK()
  {
    super.xK();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(com.tencent.mm.ui.contact.s.cHO());
    localHashSet.addAll(com.tencent.mm.ui.contact.s.cHP());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!bk.bl(str)) {
      localHashSet.addAll(bk.G(str.split(",")));
    }
    this.dru = new ArrayList();
    this.dru.addAll(localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI
 * JD-Core Version:    0.7.0.1
 */