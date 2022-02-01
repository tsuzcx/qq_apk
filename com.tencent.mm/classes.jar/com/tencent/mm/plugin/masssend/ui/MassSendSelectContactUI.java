package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
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
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private Button KOq;
  private List<String> KOr;
  private boolean KOs;
  private MultiSelectContactView KOt;
  private List<String> lMF;
  
  private void aat(int paramInt)
  {
    AppMethodBeat.i(26503);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(R.l.fNU) + "(" + this.KOr.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(26503);
      return;
    }
    updateOptionMenuText(1, getString(R.l.fNU));
    enableOptionMenu(1, false);
    AppMethodBeat.o(26503);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(272795);
    paramAdapterView = jyE();
    paramView = paramAdapterView.aDt(paramInt - getContentLV().getHeaderViewsCount());
    if (paramView == null)
    {
      AppMethodBeat.o(272795);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(272795);
      return;
    }
    Log.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { paramView.contact.field_username });
    paramView = paramView.contact.field_username;
    iKA();
    if (this.KOr.contains(paramView))
    {
      this.KOr.remove(paramView);
      this.KOt.bqG(paramView);
    }
    for (;;)
    {
      aat(this.KOr.size());
      paramAdapterView.notifyDataSetChanged();
      iKA();
      jyN();
      AppMethodBeat.o(272795);
      return;
      this.KOr.add(paramView);
      this.KOt.bqG(paramView);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(26510);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.KOr.contains(parama.contact.field_username);
      AppMethodBeat.o(26510);
      return bool;
    }
    AppMethodBeat.o(26510);
    return false;
  }
  
  public final void aLa(String paramString)
  {
    AppMethodBeat.i(26504);
    h.OAn.b(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(this.KOr), ","));
    localIntent.putExtra("list_attr", w.R(new int[] { 16384, 64 }));
    com.tencent.mm.br.c.d(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(26504);
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(26501);
    super.aNi();
    this.lMF = new ArrayList();
    this.lMF.addAll(w.jyV());
    this.lMF.addAll(w.jyW());
    this.lMF.add(z.bAM());
    this.KOr = new LinkedList();
    AppMethodBeat.o(26501);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(26508);
    Object localObject = new c.a();
    ((c.a)localObject).afbY = true;
    ((c.a)localObject).afau = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new com.tencent.mm.ui.contact.c(this, this.lMF, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(26508);
    return localObject;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(26509);
    u localu = new u(this, this.lMF, true, this.scene);
    AppMethodBeat.o(26509);
    return localu;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return true;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(26507);
    String str = getString(R.l.gNz);
    AppMethodBeat.o(26507);
    return str;
  }
  
  public final int[] efu()
  {
    return new int[] { 131072 };
  }
  
  public final boolean gaC()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return R.i.glA;
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
        if (this.KOr.add(localObject)) {
          this.KOt.bqG(localObject);
        }
        paramInt1 += 1;
      }
      aat(this.KOr.size());
      jyE().notifyDataSetChanged();
      jyO();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26502);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.KOt = this.KOt;
    if (this.KOt == null)
    {
      finish();
      AppMethodBeat.o(26502);
      return;
    }
    this.KOt.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(R.l.fNU), new MenuItem.OnMenuItemClickListener()
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
        paramAnonymousMenuItem.remove(z.bAM());
        Object localObject = Util.listToString(paramAnonymousMenuItem, ";");
        paramAnonymousMenuItem = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
        paramAnonymousMenuItem.putExtra("mass_send_contact_list", (String)localObject);
        localObject = MassSendSelectContactUI.this;
        paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousMenuItem.aYi(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MassSendSelectContactUI)localObject).startActivity((Intent)paramAnonymousMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26498);
        return true;
      }
    }, null, y.b.adEJ);
    this.KOq = ((Button)findViewById(R.h.fVF));
    this.KOq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26499);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        Log.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        paramAnonymousView = (q)((HeaderViewListAdapter)MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
        if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this))
        {
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(R.l.gNr);
          int j = paramAnonymousView.getCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramAnonymousView.aDt(i);
            if ((localObject != null) && (((com.tencent.mm.ui.contact.a.a)localObject).contact != null)) {
              MassSendSelectContactUI.a(MassSendSelectContactUI.this).add(((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username);
            }
            i += 1;
          }
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).mv(MassSendSelectContactUI.a(MassSendSelectContactUI.this));
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
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(R.l.gNy);
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).mv(new LinkedList());
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).clear();
          break;
        }
      }
    });
    this.KOt.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void ad(int paramAnonymousInt, String paramAnonymousString)
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
    aat(this.KOr.size());
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