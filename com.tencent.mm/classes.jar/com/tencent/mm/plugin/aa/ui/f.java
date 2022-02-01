package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends u
{
  private ArrayList<String> mNg;
  private String[] mNs;
  private Cursor mNt;
  private String query;
  
  public f(MMBaseSelectContactUI paramMMBaseSelectContactUI, ArrayList<String> paramArrayList)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63557);
    this.mNg = paramArrayList;
    if (this.mNg != null) {
      this.mNs = Util.listToStrings(this.mNg);
    }
    AppMethodBeat.o(63557);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63558);
    Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.mNs != null))
    {
      h.aHH();
      this.mNt = ((n)h.ae(n.class)).bbL().a(this.mNs, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    dE(paramString, true);
    AppMethodBeat.o(63558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63560);
    super.finish();
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    AppMethodBeat.o(63560);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63561);
    if (this.mNt == null)
    {
      AppMethodBeat.o(63561);
      return 0;
    }
    int i = this.mNt.getCount();
    AppMethodBeat.o(63561);
    return i;
  }
  
  public final a ye(int paramInt)
  {
    AppMethodBeat.i(63559);
    com.tencent.mm.ui.contact.a.f localf = null;
    if (this.mNt.moveToPosition(paramInt))
    {
      as localas = new as();
      localas.convertFrom(this.mNt);
      localf = new com.tencent.mm.ui.contact.a.f(paramInt);
      localf.contact = localas;
      localf.XsX = true;
    }
    AppMethodBeat.o(63559);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.f
 * JD-Core Version:    0.7.0.1
 */