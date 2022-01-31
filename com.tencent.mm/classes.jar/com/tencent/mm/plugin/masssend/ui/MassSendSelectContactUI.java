package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.contact.c.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.tools.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MassSendSelectContactUI
  extends MMBaseSelectContactUI
{
  private List<String> ejc;
  private HashSet<String> gpQ;
  private Button oCq;
  private boolean oCr;
  private MultiSelectContactView oCs;
  
  private void yS(int paramInt)
  {
    AppMethodBeat.i(22879);
    if (paramInt > 0)
    {
      updateOptionMenuText(1, getString(2131301534) + "(" + this.gpQ.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(22879);
      return;
    }
    updateOptionMenuText(1, getString(2131301534));
    enableOptionMenu(1, false);
    AppMethodBeat.o(22879);
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(22877);
    super.Kc();
    this.ejc = new ArrayList();
    this.ejc.addAll(t.dMg());
    this.ejc.addAll(t.dMh());
    this.ejc.add(com.tencent.mm.model.r.Zn());
    this.gpQ = new HashSet();
    AppMethodBeat.o(22877);
  }
  
  public final void SL(String paramString)
  {
    AppMethodBeat.i(22880);
    h.qsU.e(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("label", paramString);
    localIntent.putExtra("always_select_contact", bo.d(new ArrayList(this.gpQ), ","));
    localIntent.putExtra("list_attr", t.F(new int[] { 16384, 64 }));
    d.b(this, ".ui.contact.SelectLabelContactUI", localIntent, 0);
    AppMethodBeat.o(22880);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(22886);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(22886);
      return bool;
    }
    AppMethodBeat.o(22886);
    return false;
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return true;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(22883);
    String str = getString(2131301536);
    AppMethodBeat.o(22883);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(22884);
    Object localObject = new c.a();
    ((c.a)localObject).Abg = true;
    ((c.a)localObject).zZK = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.ejc, true, (c.a)localObject);
    AppMethodBeat.o(22884);
    return localObject;
  }
  
  public final n ape()
  {
    AppMethodBeat.i(22885);
    com.tencent.mm.ui.contact.r localr = new com.tencent.mm.ui.contact.r(this, this.ejc, true, this.scene);
    AppMethodBeat.o(22885);
    return localr;
  }
  
  public final int[] bOp()
  {
    return new int[] { 131072 };
  }
  
  public final boolean bPC()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130970126;
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(22882);
    o localo = dLW();
    Object localObject = localo.Qt(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(22882);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(22882);
      return;
    }
    ab.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    dMc();
    if (this.gpQ.contains(localObject))
    {
      this.gpQ.remove(localObject);
      this.oCs.ama((String)localObject);
    }
    for (;;)
    {
      yS(this.gpQ.size());
      localo.notifyDataSetChanged();
      dMc();
      dMd();
      AppMethodBeat.o(22882);
      return;
      this.gpQ.add(localObject);
      this.oCs.ama((String)localObject);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(22881);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(22881);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22881);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bo.isNullOrNil(paramIntent))
      {
        ab.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(22881);
        return;
      }
      ab.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.gpQ.add(localObject)) {
          this.oCs.ama(localObject);
        }
        paramInt1 += 1;
      }
      yS(this.gpQ.size());
      dLW().notifyDataSetChanged();
      if (this.eiV != null)
      {
        this.eiV.clearFocus();
        this.eiV.dNV();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22878);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.MassSendSelectContactUI", "create!");
    this.oCs = this.oCs;
    if (this.oCs == null)
    {
      finish();
      AppMethodBeat.o(22878);
      return;
    }
    this.oCs.setBackgroundDrawable(null);
    addTextOptionMenu(1, getString(2131301534), new MassSendSelectContactUI.1(this), null, q.b.zby);
    this.oCq = ((Button)findViewById(2131826110));
    this.oCq.setOnClickListener(new MassSendSelectContactUI.2(this));
    this.oCs.setOnContactDeselectListener(new MassSendSelectContactUI.3(this));
    yS(this.gpQ.size());
    AppMethodBeat.o(22878);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendSelectContactUI
 * JD-Core Version:    0.7.0.1
 */