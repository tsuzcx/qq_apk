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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private Button ETM;
  private List<String> ETN;
  private boolean ETO;
  private MultiSelectContactView ETP;
  private List<String> jkb;
  
  private void Wx(int paramInt)
  {
    AppMethodBeat.i(26503);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(R.l.dMl) + "(" + this.ETN.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(26503);
      return;
    }
    updateOptionMenuText(1, getString(R.l.dMl));
    enableOptionMenu(1, false);
    AppMethodBeat.o(26503);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(274346);
    paramView = hUP();
    Object localObject = paramView.awM(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(274346);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(274346);
      return;
    }
    Log.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    hUZ();
    if (this.ETN.contains(localObject))
    {
      this.ETN.remove(localObject);
      this.ETP.bqR((String)localObject);
    }
    for (;;)
    {
      Wx(this.ETN.size());
      paramView.notifyDataSetChanged();
      hUZ();
      hVa();
      AppMethodBeat.o(274346);
      return;
      this.ETN.add(localObject);
      this.ETP.bqR((String)localObject);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(26510);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.ETN.contains(parama.contact.field_username);
      AppMethodBeat.o(26510);
      return bool;
    }
    AppMethodBeat.o(26510);
    return false;
  }
  
  public final void aOd(String paramString)
  {
    AppMethodBeat.i(26504);
    h.IzE.a(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(this.ETN), ","));
    localIntent.putExtra("list_attr", w.P(new int[] { 16384, 64 }));
    com.tencent.mm.by.c.d(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(26504);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(26501);
    super.ata();
    this.jkb = new ArrayList();
    this.jkb.addAll(w.hVh());
    this.jkb.addAll(w.hVi());
    this.jkb.add(z.bcZ());
    this.ETN = new LinkedList();
    AppMethodBeat.o(26501);
  }
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return true;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(26507);
    String str = getString(R.l.eLF);
    AppMethodBeat.o(26507);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(26508);
    Object localObject = new c.a();
    ((c.a)localObject).Xqx = true;
    ((c.a)localObject).XoS = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new com.tencent.mm.ui.contact.c(this, this.jkb, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(26508);
    return localObject;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(26509);
    u localu = new u(this, this.jkb, true, this.scene);
    AppMethodBeat.o(26509);
    return localu;
  }
  
  public final int[] dvA()
  {
    return new int[] { 131072 };
  }
  
  public final boolean eRT()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return R.i.eiB;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(26505);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      if (Util.isNullOrNil(paramIntent))
      {
        Log.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(26505);
        return;
      }
      Log.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.ETN.add(localObject)) {
          this.ETP.bqR(localObject);
        }
        paramInt1 += 1;
      }
      Wx(this.ETN.size());
      hUP().notifyDataSetChanged();
      hVb();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26502);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.ETP = this.ETP;
    if (this.ETP == null)
    {
      finish();
      AppMethodBeat.o(26502);
      return;
    }
    this.ETP.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(R.l.dMl), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26498);
        Log.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
        paramAnonymousMenuItem = Util.stringsToList((String[])MassSendSelectContactUI.a(MassSendSelectContactUI.this).toArray(new String[0]));
        if (paramAnonymousMenuItem == null)
        {
          Log.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
          AppMethodBeat.o(26498);
          return false;
        }
        paramAnonymousMenuItem.remove(z.bcZ());
        Object localObject = Util.listToString(paramAnonymousMenuItem, ";");
        paramAnonymousMenuItem = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
        paramAnonymousMenuItem.putExtra("mass_send_contact_list", (String)localObject);
        localObject = MassSendSelectContactUI.this;
        paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousMenuItem.aFh(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MassSendSelectContactUI)localObject).startActivity((Intent)paramAnonymousMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26498);
        return true;
      }
    }, null, w.b.Wao);
    this.ETM = ((Button)findViewById(R.h.dTy));
    this.ETM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26499);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        Log.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        paramAnonymousView = (q)((HeaderViewListAdapter)MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
        if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this))
        {
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(R.l.eLx);
          int j = paramAnonymousView.getCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramAnonymousView.awM(i);
            if ((localObject != null) && (((com.tencent.mm.ui.contact.a.a)localObject).contact != null)) {
              MassSendSelectContactUI.a(MassSendSelectContactUI.this).add(((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username);
            }
            i += 1;
          }
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).jk(MassSendSelectContactUI.a(MassSendSelectContactUI.this));
          localObject = MassSendSelectContactUI.this;
          if (MassSendSelectContactUI.b(MassSendSelectContactUI.this)) {
            break label279;
          }
        }
        label279:
        for (boolean bool = true;; bool = false)
        {
          MassSendSelectContactUI.a((MassSendSelectContactUI)localObject, bool);
          MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.a(MassSendSelectContactUI.this).size());
          paramAnonymousView.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26499);
          return;
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(R.l.eLE);
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).jk(new LinkedList());
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).clear();
          break;
        }
      }
    });
    this.ETP.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void V(int paramAnonymousInt, String paramAnonymousString)
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
    Wx(this.ETN.size());
    AppMethodBeat.o(26502);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */