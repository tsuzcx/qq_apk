package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI
  extends MMBaseSelectContactUI
{
  private List<String> gzY;
  private View zjf;
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(213536);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramInt = getIntent().getIntExtra("key_friends_num", 0);
      paramView = new Intent();
      int i = u.Q(new int[] { 16, 1, 2, 4, 16384, 64, 65536, 131072 });
      paramView.putExtra("list_type", 0);
      paramView.putExtra("list_attr", i);
      paramView.putExtra("max_limit_num", paramInt);
      paramView.putExtra("titile", getString(2131762724, new Object[] { Integer.valueOf(paramInt) }));
      paramView.putExtra("sub_title", getString(2131768672));
      c.c(this, ".ui.contact.SelectContactUI", paramView, 1);
      overridePendingTransition(2130772132, 2130772060);
      AppMethodBeat.o(213536);
      return;
    }
    paramView = (a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(213536);
      return;
    }
    paramView = paramView.contact;
    if (paramView == null)
    {
      AppMethodBeat.o(213536);
      return;
    }
    String str = paramView.field_username;
    Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { str });
    final Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_User", str);
    paramView = null;
    if (com.tencent.mm.model.ab.Eq(str)) {
      paramView = getString(2131768303, new Object[] { Integer.valueOf(v.Ie(str)) });
    }
    ((j)g.af(j.class)).a(this.mController, str, getString(2131764634), str, paramView, getString(2131755976), new y.a()
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
    AppMethodBeat.o(213536);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(65978);
    super.a(paramListView, paramInt);
    if (this.zjf == null)
    {
      View localView = View.inflate(this, 2131496202, null);
      this.zjf = localView.findViewById(2131299180);
      ((TextView)localView.findViewById(2131309163)).setText(2131762647);
      paramListView.addHeaderView(localView);
    }
    this.zjf.setVisibility(paramInt);
    AppMethodBeat.o(65978);
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(65973);
    super.amZ();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(u.gVb());
    localHashSet.addAll(u.gVc());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!Util.isNullOrNil(str)) {
      localHashSet.addAll(Util.stringsToList(str.split(",")));
    }
    this.gzY = new ArrayList();
    this.gzY.addAll(localHashSet);
    AppMethodBeat.o(65973);
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(65975);
    String str = getString(2131762725);
    AppMethodBeat.o(65975);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(65976);
    com.tencent.mm.ui.contact.ab localab = new com.tencent.mm.ui.contact.ab(this, this.gzY);
    AppMethodBeat.o(65976);
    return localab;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(65977);
    s locals = new s(this, this.gzY, false, this.scene);
    AppMethodBeat.o(65977);
    return locals;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public final int[] egI()
  {
    return new int[] { 131072 };
  }
  
  public final void egJ()
  {
    AppMethodBeat.i(65979);
    super.egJ();
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
      egJ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI
 * JD-Core Version:    0.7.0.1
 */