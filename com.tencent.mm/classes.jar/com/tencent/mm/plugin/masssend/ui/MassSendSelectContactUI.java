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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.tools.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private List<String> fvP;
  private Button twT;
  private List<String> twU;
  private boolean twV;
  private MultiSelectContactView twW;
  
  private void Gs(int paramInt)
  {
    AppMethodBeat.i(26503);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(2131761182) + "(" + this.twU.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(26503);
      return;
    }
    updateOptionMenuText(1, getString(2131761182));
    enableOptionMenu(1, false);
    AppMethodBeat.o(26503);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(26501);
    super.VL();
    this.fvP = new ArrayList();
    this.fvP.addAll(com.tencent.mm.ui.contact.u.fbL());
    this.fvP.addAll(com.tencent.mm.ui.contact.u.fbM());
    this.fvP.add(com.tencent.mm.model.u.aqG());
    this.twU = new LinkedList();
    AppMethodBeat.o(26501);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(26510);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.twU.contains(parama.contact.field_username);
      AppMethodBeat.o(26510);
      return bool;
    }
    AppMethodBeat.o(26510);
    return false;
  }
  
  public final boolean aHt()
  {
    return false;
  }
  
  public final boolean aHu()
  {
    return true;
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(26507);
    String str = getString(2131761184);
    AppMethodBeat.o(26507);
    return str;
  }
  
  public final q aHw()
  {
    AppMethodBeat.i(26508);
    Object localObject = new c.a();
    ((c.a)localObject).GTE = true;
    ((c.a)localObject).GRX = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.fvP, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(26508);
    return localObject;
  }
  
  public final o aHx()
  {
    AppMethodBeat.i(26509);
    s locals = new s(this, this.fvP, true, this.scene);
    AppMethodBeat.o(26509);
    return locals;
  }
  
  public final void afM(String paramString)
  {
    AppMethodBeat.i(26504);
    h.vKh.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", bt.n(new ArrayList(this.twU), ","));
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { 16384, 64 }));
    d.c(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(26504);
  }
  
  public final int[] cMQ()
  {
    return new int[] { 131072 };
  }
  
  public final boolean cOv()
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
    ad.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if (bt.isNullOrNil(paramIntent))
      {
        ad.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(26505);
        return;
      }
      ad.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.twU.add(localObject)) {
          this.twW.aBC(localObject);
        }
        paramInt1 += 1;
      }
      Gs(this.twU.size());
      fbz().notifyDataSetChanged();
      if (this.fvI != null)
      {
        this.fvI.clearFocus();
        this.fvI.fdW();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26502);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.twW = this.twW;
    if (this.twW == null)
    {
      finish();
      AppMethodBeat.o(26502);
      return;
    }
    this.twW.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(2131761182), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26498);
        ad.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
        paramAnonymousMenuItem = bt.S((String[])MassSendSelectContactUI.a(MassSendSelectContactUI.this).toArray(new String[0]));
        if (paramAnonymousMenuItem == null)
        {
          ad.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
          AppMethodBeat.o(26498);
          return false;
        }
        paramAnonymousMenuItem.remove(com.tencent.mm.model.u.aqG());
        Object localObject = bt.n(paramAnonymousMenuItem, ";");
        paramAnonymousMenuItem = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
        paramAnonymousMenuItem.putExtra("mass_send_contact_list", (String)localObject);
        localObject = MassSendSelectContactUI.this;
        paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.adn(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MassSendSelectContactUI)localObject).startActivity((Intent)paramAnonymousMenuItem.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26498);
        return true;
      }
    }, null, r.b.FOB);
    this.twT = ((Button)findViewById(2131304491));
    this.twT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(26499);
        ad.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        paramAnonymousView = (p)((HeaderViewListAdapter)MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
        Object localObject;
        if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this))
        {
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131761171);
          int j = paramAnonymousView.getCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramAnonymousView.ZC(i);
            if ((localObject != null) && (((com.tencent.mm.ui.contact.a.a)localObject).contact != null)) {
              MassSendSelectContactUI.a(MassSendSelectContactUI.this).add(((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username);
            }
            i += 1;
          }
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).gG(MassSendSelectContactUI.a(MassSendSelectContactUI.this));
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
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).gG(new LinkedList());
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).clear();
        }
      }
    });
    this.twW.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void N(int paramAnonymousInt, String paramAnonymousString)
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
    Gs(this.twU.size());
    AppMethodBeat.o(26502);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(26506);
    p localp = fbz();
    Object localObject = localp.ZC(paramInt - getContentLV().getHeaderViewsCount());
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
    ad.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    fbG();
    if (this.twU.contains(localObject))
    {
      this.twU.remove(localObject);
      this.twW.aBC((String)localObject);
    }
    for (;;)
    {
      Gs(this.twU.size());
      localp.notifyDataSetChanged();
      fbG();
      fbH();
      AppMethodBeat.o(26506);
      return;
      this.twU.add(localObject);
      this.twW.aBC((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */