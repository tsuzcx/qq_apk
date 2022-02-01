package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.ab;
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
  private List<String> fUR;
  private View vNH;
  
  public final void Zm()
  {
    AppMethodBeat.i(65973);
    super.Zm();
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(u.fMH());
    localHashSet.addAll(u.fMI());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!bu.isNullOrNil(str)) {
      localHashSet.addAll(bu.U(str.split(",")));
    }
    this.fUR = new ArrayList();
    this.fUR.addAll(localHashSet);
    AppMethodBeat.o(65973);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(65978);
    super.a(paramListView, paramInt);
    if (this.vNH == null)
    {
      View localView = View.inflate(this, 2131495341, null);
      this.vNH = localView.findViewById(2131298739);
      ((TextView)localView.findViewById(2131305880)).setText(2131760878);
      paramListView.addHeaderView(localView);
    }
    this.vNH.setVisibility(paramInt);
    AppMethodBeat.o(65978);
  }
  
  public final boolean aRT()
  {
    return false;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(65975);
    String str = getString(2131760951);
    AppMethodBeat.o(65975);
    return str;
  }
  
  public final q aRW()
  {
    AppMethodBeat.i(65976);
    ab localab = new ab(this, this.fUR);
    AppMethodBeat.o(65976);
    return localab;
  }
  
  public final o aRX()
  {
    AppMethodBeat.i(65977);
    s locals = new s(this, this.fUR, false, this.scene);
    AppMethodBeat.o(65977);
    return locals;
  }
  
  public final int[] dmI()
  {
    return new int[] { 131072 };
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(65979);
    super.dmJ();
    hideVKB();
    AppMethodBeat.o(65979);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(65981);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ae.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        setResult(-1, paramIntent);
        finish();
      }
      AppMethodBeat.o(65981);
      return;
      ae.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
    }
    ae.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(65981);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(65980);
    if (paramInt == 4) {
      dmJ();
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
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(65974);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ae.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      ae.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramInt = getIntent().getIntExtra("key_friends_num", 0);
      localObject = new Intent();
      int i = u.J(new int[] { 16, 1, 2, 4, 16384, 64, 65536, 131072 });
      ((Intent)localObject).putExtra("list_type", 0);
      ((Intent)localObject).putExtra("list_attr", i);
      ((Intent)localObject).putExtra("max_limit_num", paramInt);
      ((Intent)localObject).putExtra("titile", getString(2131760950, new Object[] { Integer.valueOf(paramInt) }));
      ((Intent)localObject).putExtra("sub_title", getString(2131766196));
      d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      overridePendingTransition(2130772108, 2130772048);
      AppMethodBeat.o(65974);
      return;
    }
    Object localObject = (a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(65974);
      return;
    }
    localObject = ((a)localObject).contact;
    if (localObject == null)
    {
      AppMethodBeat.o(65974);
      return;
    }
    String str = ((aw)localObject).field_username;
    ae.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { str });
    final Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_User", str);
    localObject = null;
    if (x.wb(str)) {
      localObject = getString(2131765850, new Object[] { Integer.valueOf(r.zC(str)) });
    }
    ((j)g.ab(j.class)).a(this.mController, str, getString(2131762565), str, (String)localObject, getString(2131755884), new y.a()
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
    AppMethodBeat.o(65974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI
 * JD-Core Version:    0.7.0.1
 */