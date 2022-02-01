package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private List<String> fzw;
  private Button uFl;
  private List<String> uFm;
  private boolean uFn;
  private MultiSelectContactView uFo;
  
  private void Io(int paramInt)
  {
    AppMethodBeat.i(26503);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(2131761182) + "(" + this.uFm.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(26503);
      return;
    }
    updateOptionMenuText(1, getString(2131761182));
    enableOptionMenu(1, false);
    AppMethodBeat.o(26503);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(26501);
    super.WJ();
    this.fzw = new ArrayList();
    this.fzw.addAll(com.tencent.mm.ui.contact.u.frC());
    this.fzw.addAll(com.tencent.mm.ui.contact.u.frD());
    this.fzw.add(com.tencent.mm.model.u.axw());
    this.uFm = new LinkedList();
    AppMethodBeat.o(26501);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(26510);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.uFm.contains(parama.contact.field_username);
      AppMethodBeat.o(26510);
      return bool;
    }
    AppMethodBeat.o(26510);
    return false;
  }
  
  public final boolean aOi()
  {
    return false;
  }
  
  public final boolean aOj()
  {
    return true;
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(26507);
    String str = getString(2131761184);
    AppMethodBeat.o(26507);
    return str;
  }
  
  public final q aOl()
  {
    AppMethodBeat.i(26508);
    Object localObject = new c.a();
    ((c.a)localObject).ItP = true;
    ((c.a)localObject).Isk = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.fzw, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(26508);
    return localObject;
  }
  
  public final o aOm()
  {
    AppMethodBeat.i(26509);
    s locals = new s(this, this.fzw, true, this.scene);
    AppMethodBeat.o(26509);
    return locals;
  }
  
  public final void akG(String paramString)
  {
    AppMethodBeat.i(26504);
    h.wUl.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", bs.n(new ArrayList(this.uFm), ","));
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { 16384, 64 }));
    d.c(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(26504);
  }
  
  public final int[] daw()
  {
    return new int[] { 131072 };
  }
  
  public final boolean dce()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131494741;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(26505);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(26505);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26505);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bs.isNullOrNil(paramIntent))
      {
        ac.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(26505);
        return;
      }
      ac.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.uFm.add(localObject)) {
          this.uFo.aGU(localObject);
        }
        paramInt1 += 1;
      }
      Io(this.uFm.size());
      frq().notifyDataSetChanged();
      if (this.fzp != null)
      {
        this.fzp.clearFocus();
        this.fzp.ftR();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26502);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.uFo = this.uFo;
    if (this.uFo == null)
    {
      finish();
      AppMethodBeat.o(26502);
      return;
    }
    this.uFo.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(2131761182), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26498);
        ac.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
        paramAnonymousMenuItem = bs.S((String[])MassSendSelectContactUI.a(MassSendSelectContactUI.this).toArray(new String[0]));
        if (paramAnonymousMenuItem == null)
        {
          ac.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
          AppMethodBeat.o(26498);
          return false;
        }
        paramAnonymousMenuItem.remove(com.tencent.mm.model.u.axw());
        Object localObject = bs.n(paramAnonymousMenuItem, ";");
        paramAnonymousMenuItem = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
        paramAnonymousMenuItem.putExtra("mass_send_contact_list", (String)localObject);
        localObject = MassSendSelectContactUI.this;
        paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.aeD(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MassSendSelectContactUI)localObject).startActivity((Intent)paramAnonymousMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26498);
        return true;
      }
    }, null, s.b.Hom);
    this.uFl = ((Button)findViewById(2131304491));
    this.uFl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(26499);
        ac.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        paramAnonymousView = (p)((HeaderViewListAdapter)MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
        Object localObject;
        if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this))
        {
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131761171);
          int j = paramAnonymousView.getCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramAnonymousView.abQ(i);
            if ((localObject != null) && (((com.tencent.mm.ui.contact.a.a)localObject).contact != null)) {
              MassSendSelectContactUI.a(MassSendSelectContactUI.this).add(((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username);
            }
            i += 1;
          }
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).gR(MassSendSelectContactUI.a(MassSendSelectContactUI.this));
        }
        for (;;)
        {
          localObject = MassSendSelectContactUI.this;
          if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this)) {
            bool = true;
          }
          MassSendSelectContactUI.a((MassSendSelectContactUI)localObject, bool);
          MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.a(MassSendSelectContactUI.this).size());
          paramAnonymousView.notifyDataSetChanged();
          AppMethodBeat.o(26499);
          return;
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131761183);
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).gR(new LinkedList());
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).clear();
        }
      }
    });
    this.uFo.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(26500);
        if ((paramAnonymousInt == 1) && (paramAnonymousString != null))
        {
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).remove(paramAnonymousString);
          MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.a(MassSendSelectContactUI.this).size());
        }
        AppMethodBeat.o(26500);
      }
    });
    Io(this.uFm.size());
    AppMethodBeat.o(26502);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(26506);
    p localp = frq();
    Object localObject = localp.abQ(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(26506);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(26506);
      return;
    }
    ac.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    frx();
    if (this.uFm.contains(localObject))
    {
      this.uFm.remove(localObject);
      this.uFo.aGU((String)localObject);
    }
    for (;;)
    {
      Io(this.uFm.size());
      localp.notifyDataSetChanged();
      frx();
      fry();
      AppMethodBeat.o(26506);
      return;
      this.uFm.add(localObject);
      this.uFo.aGU((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */