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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
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
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private List<String> fSL;
  private Button vIl;
  private List<String> vIm;
  private boolean vIn;
  private MultiSelectContactView vIo;
  
  private void JK(int paramInt)
  {
    AppMethodBeat.i(26503);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(2131761182) + "(" + this.vIm.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(26503);
      return;
    }
    updateOptionMenuText(1, getString(2131761182));
    enableOptionMenu(1, false);
    AppMethodBeat.o(26503);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(26501);
    super.Zd();
    this.fSL = new ArrayList();
    this.fSL.addAll(com.tencent.mm.ui.contact.u.fIp());
    this.fSL.addAll(com.tencent.mm.ui.contact.u.fIq());
    this.fSL.add(com.tencent.mm.model.u.aAm());
    this.vIm = new LinkedList();
    AppMethodBeat.o(26501);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(26510);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.vIm.contains(parama.contact.field_username);
      AppMethodBeat.o(26510);
      return bool;
    }
    AppMethodBeat.o(26510);
    return false;
  }
  
  public final boolean aRu()
  {
    return false;
  }
  
  public final boolean aRv()
  {
    return true;
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(26507);
    String str = getString(2131761184);
    AppMethodBeat.o(26507);
    return str;
  }
  
  public final q aRx()
  {
    AppMethodBeat.i(26508);
    Object localObject = new c.a();
    ((c.a)localObject).Kkv = true;
    ((c.a)localObject).KiP = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.fSL, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(26508);
    return localObject;
  }
  
  public final o aRy()
  {
    AppMethodBeat.i(26509);
    s locals = new s(this, this.fSL, true, this.scene);
    AppMethodBeat.o(26509);
    return locals;
  }
  
  public final void apt(String paramString)
  {
    AppMethodBeat.i(26504);
    g.yhR.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", bt.m(new ArrayList(this.vIm), ","));
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { 16384, 64 }));
    d.c(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(26504);
  }
  
  public final int[] djJ()
  {
    return new int[] { 131072 };
  }
  
  public final boolean dlz()
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
        if (this.vIm.add(localObject)) {
          this.vIo.aMx(localObject);
        }
        paramInt1 += 1;
      }
      JK(this.vIm.size());
      fId().notifyDataSetChanged();
      if (this.fSC != null)
      {
        this.fSC.clearFocus();
        this.fSC.fKE();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26502);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.vIo = this.vIo;
    if (this.vIo == null)
    {
      finish();
      AppMethodBeat.o(26502);
      return;
    }
    this.vIo.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(2131761182), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26498);
        ad.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
        paramAnonymousMenuItem = bt.U((String[])MassSendSelectContactUI.a(MassSendSelectContactUI.this).toArray(new String[0]));
        if (paramAnonymousMenuItem == null)
        {
          ad.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
          AppMethodBeat.o(26498);
          return false;
        }
        paramAnonymousMenuItem.remove(com.tencent.mm.model.u.aAm());
        Object localObject = bt.m(paramAnonymousMenuItem, ";");
        paramAnonymousMenuItem = new Intent(MassSendSelectContactUI.this, MassSendMsgUI.class);
        paramAnonymousMenuItem.putExtra("mass_send_contact_list", (String)localObject);
        localObject = MassSendSelectContactUI.this;
        paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.ahp(), "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MassSendSelectContactUI)localObject).startActivity((Intent)paramAnonymousMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26498);
        return true;
      }
    }, null, s.b.JbS);
    this.vIl = ((Button)findViewById(2131304491));
    this.vIl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26499);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        ad.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        paramAnonymousView = (p)((HeaderViewListAdapter)MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
        if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this))
        {
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131761171);
          int j = paramAnonymousView.getCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramAnonymousView.aen(i);
            if ((localObject != null) && (((com.tencent.mm.ui.contact.a.a)localObject).contact != null)) {
              MassSendSelectContactUI.a(MassSendSelectContactUI.this).add(((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username);
            }
            i += 1;
          }
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).hd(MassSendSelectContactUI.a(MassSendSelectContactUI.this));
          localObject = MassSendSelectContactUI.this;
          if (MassSendSelectContactUI.b(MassSendSelectContactUI.this)) {
            break label277;
          }
        }
        label277:
        for (boolean bool = true;; bool = false)
        {
          MassSendSelectContactUI.a((MassSendSelectContactUI)localObject, bool);
          MassSendSelectContactUI.a(MassSendSelectContactUI.this, MassSendSelectContactUI.a(MassSendSelectContactUI.this).size());
          paramAnonymousView.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26499);
          return;
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131761183);
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).hd(new LinkedList());
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).clear();
          break;
        }
      }
    });
    this.vIo.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void Q(int paramAnonymousInt, String paramAnonymousString)
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
    JK(this.vIm.size());
    AppMethodBeat.o(26502);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(26506);
    p localp = fId();
    Object localObject = localp.aen(paramInt - getContentLV().getHeaderViewsCount());
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
    fIk();
    if (this.vIm.contains(localObject))
    {
      this.vIm.remove(localObject);
      this.vIo.aMx((String)localObject);
    }
    for (;;)
    {
      JK(this.vIm.size());
      localp.notifyDataSetChanged();
      fIk();
      fIl();
      AppMethodBeat.o(26506);
      return;
      this.vIm.add(localObject);
      this.vIo.aMx((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */