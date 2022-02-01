package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends u
{
  private ArrayList<String> pJO;
  private String[] pKa;
  private Cursor pKb;
  private String query;
  
  public f(MMBaseSelectContactUI paramMMBaseSelectContactUI, ArrayList<String> paramArrayList)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63557);
    this.pJO = paramArrayList;
    if (this.pJO != null) {
      this.pKa = Util.listToStrings(this.pJO);
    }
    AppMethodBeat.o(63557);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63558);
    Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.pKa != null))
    {
      h.baF();
      this.pKb = ((n)h.ax(n.class)).bzA().a(this.pKa, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    eo(paramString, true);
    AppMethodBeat.o(63558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63560);
    super.finish();
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(63560);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63561);
    if (this.pKb == null)
    {
      AppMethodBeat.o(63561);
      return 0;
    }
    int i = this.pKb.getCount();
    AppMethodBeat.o(63561);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(63559);
    com.tencent.mm.ui.contact.a.f localf = null;
    if (this.pKb.moveToPosition(paramInt))
    {
      au localau = new au();
      localau.convertFrom(this.pKb);
      localf = new com.tencent.mm.ui.contact.a.f(paramInt);
      localf.contact = localau;
      localf.afey = true;
    }
    AppMethodBeat.o(63559);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.f
 * JD-Core Version:    0.7.0.1
 */