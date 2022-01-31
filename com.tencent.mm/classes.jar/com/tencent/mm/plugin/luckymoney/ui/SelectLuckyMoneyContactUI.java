package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI
  extends MMBaseSelectContactUI
{
  private List<String> ejc;
  private View oxB;
  
  public final void Kc()
  {
    AppMethodBeat.i(43077);
    super.Kc();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(com.tencent.mm.ui.contact.t.dMg());
    localHashSet.addAll(com.tencent.mm.ui.contact.t.dMh());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!bo.isNullOrNil(str)) {
      localHashSet.addAll(bo.P(str.split(",")));
    }
    this.ejc = new ArrayList();
    this.ejc.addAll(localHashSet);
    AppMethodBeat.o(43077);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(43082);
    super.a(paramListView, paramInt);
    if (this.oxB == null)
    {
      View localView = View.inflate(this, 2130970646, null);
      this.oxB = localView.findViewById(2131820946);
      ((TextView)localView.findViewById(2131821071)).setText(2131301236);
      paramListView.addHeaderView(localView);
    }
    this.oxB.setVisibility(paramInt);
    AppMethodBeat.o(43082);
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(43079);
    String str = getString(2131301306);
    AppMethodBeat.o(43079);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(43080);
    y localy = new y(this, this.ejc);
    AppMethodBeat.o(43080);
    return localy;
  }
  
  public final com.tencent.mm.ui.contact.n ape()
  {
    AppMethodBeat.i(43081);
    r localr = new r(this, this.ejc, false, this.scene);
    AppMethodBeat.o(43081);
    return localr;
  }
  
  public final int[] bOp()
  {
    return new int[] { 131072 };
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(43083);
    super.bOq();
    hideVKB();
    AppMethodBeat.o(43083);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(43078);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ab.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      ab.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramInt = getIntent().getIntExtra("key_friends_num", 0);
      localObject = new Intent();
      int i = com.tencent.mm.ui.contact.t.F(new int[] { 16, 1, 2, 4, 16384, 64, 65536, 131072 });
      ((Intent)localObject).putExtra("list_type", 0);
      ((Intent)localObject).putExtra("list_attr", i);
      ((Intent)localObject).putExtra("max_limit_num", paramInt);
      ((Intent)localObject).putExtra("titile", getString(2131301305, new Object[] { Integer.valueOf(paramInt) }));
      ((Intent)localObject).putExtra("sub_title", getString(2131305949));
      d.b(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      overridePendingTransition(2131034230, 2131034182);
      AppMethodBeat.o(43078);
      return;
    }
    Object localObject = (a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(43078);
      return;
    }
    localObject = ((a)localObject).contact;
    if (localObject == null)
    {
      AppMethodBeat.o(43078);
      return;
    }
    String str = ((aq)localObject).field_username;
    ab.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { str });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_User", str);
    localObject = null;
    if (com.tencent.mm.model.t.lA(str)) {
      localObject = getString(2131305634, new Object[] { Integer.valueOf(com.tencent.mm.model.n.nv(str)) });
    }
    ((i)g.E(i.class)).a(this.mController, str, getString(2131302656), str, (String)localObject, getString(2131297067), new SelectLuckyMoneyContactUI.1(this, localIntent));
    AppMethodBeat.o(43078);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43085);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ab.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        setResult(-1, paramIntent);
        finish();
      }
      AppMethodBeat.o(43085);
      return;
      ab.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
    }
    ab.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(43085);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(43084);
    if (paramInt == 4) {
      bOq();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(43084);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI
 * JD-Core Version:    0.7.0.1
 */