package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private List<String> gzY;
  private Button zov;
  private List<String> zow;
  private boolean zox;
  private MultiSelectContactView zoy;
  
  private void Ql(int paramInt)
  {
    AppMethodBeat.i(26503);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(2131762969) + "(" + this.zow.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(26503);
      return;
    }
    updateOptionMenuText(1, getString(2131762969));
    enableOptionMenu(1, false);
    AppMethodBeat.o(26503);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(231765);
    paramView = gUP();
    Object localObject = paramView.anH(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(231765);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(231765);
      return;
    }
    Log.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username });
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    gUW();
    if (this.zow.contains(localObject))
    {
      this.zow.remove(localObject);
      this.zoy.bev((String)localObject);
    }
    for (;;)
    {
      Ql(this.zow.size());
      paramView.notifyDataSetChanged();
      gUW();
      gUX();
      AppMethodBeat.o(231765);
      return;
      this.zow.add(localObject);
      this.zoy.bev((String)localObject);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(26510);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.zow.contains(parama.contact.field_username);
      AppMethodBeat.o(26510);
      return bool;
    }
    AppMethodBeat.o(26510);
    return false;
  }
  
  public final void aDT(String paramString)
  {
    AppMethodBeat.i(26504);
    h.CyF.a(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(this.zow), ","));
    localIntent.putExtra("list_attr", u.Q(new int[] { 16384, 64 }));
    com.tencent.mm.br.c.c(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(26504);
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(26501);
    super.amZ();
    this.gzY = new ArrayList();
    this.gzY.addAll(u.gVb());
    this.gzY.addAll(u.gVc());
    this.gzY.add(z.aTY());
    this.zow = new LinkedList();
    AppMethodBeat.o(26501);
  }
  
  public final boolean bmA()
  {
    return true;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(26507);
    String str = getString(2131762971);
    AppMethodBeat.o(26507);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(26508);
    Object localObject = new c.a();
    ((c.a)localObject).PTM = true;
    ((c.a)localObject).PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new com.tencent.mm.ui.contact.c(this, this.gzY, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(26508);
    return localObject;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(26509);
    com.tencent.mm.ui.contact.s locals = new com.tencent.mm.ui.contact.s(this, this.gzY, true, this.scene);
    AppMethodBeat.o(26509);
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
  
  public final boolean eim()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131495470;
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
        if (this.zow.add(localObject)) {
          this.zoy.bev(localObject);
        }
        paramInt1 += 1;
      }
      Ql(this.zow.size());
      gUP().notifyDataSetChanged();
      if (this.gzP != null)
      {
        this.gzP.clearFocus();
        this.gzP.gXP();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26502);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.zoy = this.zoy;
    if (this.zoy == null)
    {
      finish();
      AppMethodBeat.o(26502);
      return;
    }
    this.zoy.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(2131762969), new MassSendSelectContactUI.1(this), null, t.b.OGU);
    this.zov = ((Button)findViewById(2131307496));
    this.zov.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26499);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendSelectContactUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        Log.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
        paramAnonymousView = (p)((HeaderViewListAdapter)MassSendSelectContactUI.this.getContentLV().getAdapter()).getWrappedAdapter();
        if (!MassSendSelectContactUI.b(MassSendSelectContactUI.this))
        {
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131762958);
          int j = paramAnonymousView.getCount();
          int i = 0;
          while (i < j)
          {
            localObject = paramAnonymousView.anH(i);
            if ((localObject != null) && (((com.tencent.mm.ui.contact.a.a)localObject).contact != null)) {
              MassSendSelectContactUI.a(MassSendSelectContactUI.this).add(((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username);
            }
            i += 1;
          }
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).it(MassSendSelectContactUI.a(MassSendSelectContactUI.this));
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
          MassSendSelectContactUI.c(MassSendSelectContactUI.this).setText(2131762970);
          MassSendSelectContactUI.d(MassSendSelectContactUI.this).it(new LinkedList());
          MassSendSelectContactUI.a(MassSendSelectContactUI.this).clear();
          break;
        }
      }
    });
    this.zoy.setOnContactDeselectListener(new MassSendSelectContactUI.3(this));
    Ql(this.zow.size());
    AppMethodBeat.o(26502);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */