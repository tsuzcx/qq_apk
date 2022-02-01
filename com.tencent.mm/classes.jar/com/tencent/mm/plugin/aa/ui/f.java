package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends s
{
  private ArrayList<String> jVT;
  private String[] jWg;
  private Cursor jWh;
  private String query;
  
  public f(MMBaseSelectContactUI paramMMBaseSelectContactUI, ArrayList<String> paramArrayList)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63557);
    this.jVT = paramArrayList;
    if (this.jVT != null) {
      this.jWg = Util.listToStrings(this.jVT);
    }
    AppMethodBeat.o(63557);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63558);
    Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.jWg != null))
    {
      g.aAi();
      this.jWh = ((l)g.af(l.class)).aSN().a(this.jWg, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    ds(paramString, true);
    AppMethodBeat.o(63558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63560);
    super.finish();
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(63560);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63561);
    if (this.jWh == null)
    {
      AppMethodBeat.o(63561);
      return 0;
    }
    int i = this.jWh.getCount();
    AppMethodBeat.o(63561);
    return i;
  }
  
  public final a va(int paramInt)
  {
    AppMethodBeat.i(63559);
    e locale = null;
    if (this.jWh.moveToPosition(paramInt))
    {
      as localas = new as();
      localas.convertFrom(this.jWh);
      locale = new e(paramInt);
      locale.contact = localas;
      locale.PWh = true;
    }
    AppMethodBeat.o(63559);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.f
 * JD-Core Version:    0.7.0.1
 */