package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private List<String> dru;
  private HashSet<String> eXT;
  private Button mbP;
  private boolean mbQ;
  private MultiSelectContactView mbR;
  
  private void tC(int paramInt)
  {
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(R.l.mass_send_next) + "(" + this.eXT.size() + ")");
      enableOptionMenu(1, true);
      return;
    }
    updateOptionMenuText(1, getString(R.l.mass_send_next));
    enableOptionMenu(1, false);
  }
  
  protected final void Ha(String paramString)
  {
    h.nFQ.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", bk.c(new ArrayList(this.eXT), ","));
    localIntent.putExtra("list_attr", s.v(new int[] { 16384, 64 }));
    d.c(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return true;
  }
  
  protected final String VE()
  {
    return getString(R.l.mass_send_select_contact_title);
  }
  
  protected final o VF()
  {
    c.a locala = new c.a();
    locala.vJK = true;
    locala.vIs = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    return new c(this, this.dru, true, locala);
  }
  
  protected final m VG()
  {
    return new com.tencent.mm.ui.contact.q(this, this.dru, true, this.scene);
  }
  
  public final boolean a(a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final int[] bgw()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean bhB()
  {
    return true;
  }
  
  protected final int getLayoutId()
  {
    return R.i.mass_send_select_contact;
  }
  
  public final void jP(int paramInt)
  {
    com.tencent.mm.ui.contact.n localn = cHE();
    Object localObject = localn.HK(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null) {}
    while (((a)localObject).dnp == null) {
      return;
    }
    y.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { ((a)localObject).dnp.field_username });
    localObject = ((a)localObject).dnp.field_username;
    cHK();
    if (this.eXT.contains(localObject))
    {
      this.eXT.remove(localObject);
      this.mbR.Wv((String)localObject);
    }
    for (;;)
    {
      tC(this.eXT.size());
      localn.notifyDataSetChanged();
      cHK();
      cHL();
      return;
      this.eXT.add(localObject);
      this.mbR.Wv((String)localObject);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bk.bl(paramIntent))
      {
        y.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        return;
      }
      y.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.eXT.add(localObject)) {
          this.mbR.Wv(localObject);
        }
        paramInt1 += 1;
      }
      tC(this.eXT.size());
      cHE().notifyDataSetChanged();
    } while (this.drn == null);
    this.drn.clearFocus();
    this.drn.cJg();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.mbR = this.mbR;
    if (this.mbR == null)
    {
      finish();
      return;
    }
    this.mbR.setBackgroundDrawable(null);
    a(1, getString(R.l.mass_send_next), new MassSendSelectContactUI.1(this), s.b.uNx);
    this.mbP = ((Button)findViewById(R.h.select_all));
    this.mbP.setOnClickListener(new MassSendSelectContactUI.2(this));
    this.mbR.setOnContactDeselectListener(new MassSendSelectContactUI.3(this));
    tC(this.eXT.size());
  }
  
  protected final void xK()
  {
    super.xK();
    this.dru = new ArrayList();
    this.dru.addAll(s.cHO());
    this.dru.addAll(s.cHP());
    this.dru.add(com.tencent.mm.model.q.Gj());
    this.eXT = new HashSet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */