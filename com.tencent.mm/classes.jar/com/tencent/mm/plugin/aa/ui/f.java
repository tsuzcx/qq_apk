package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends s
{
  private String[] iVI;
  private Cursor iVJ;
  private ArrayList<String> iVv;
  private String query;
  
  public f(MMBaseSelectContactUI paramMMBaseSelectContactUI, ArrayList<String> paramArrayList)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63557);
    this.iVv = paramArrayList;
    if (this.iVv != null) {
      this.iVI = bt.hi(this.iVv);
    }
    AppMethodBeat.o(63557);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63558);
    ad.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    if ((!bt.isNullOrNil(this.query)) && (this.iVI != null))
    {
      g.ajD();
      this.iVJ = ((l)g.ab(l.class)).azp().a(this.iVI, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cT(paramString, true);
    AppMethodBeat.o(63558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63560);
    super.finish();
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    AppMethodBeat.o(63560);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63561);
    if (this.iVJ == null)
    {
      AppMethodBeat.o(63561);
      return 0;
    }
    int i = this.iVJ.getCount();
    AppMethodBeat.o(63561);
    return i;
  }
  
  public final a rh(int paramInt)
  {
    AppMethodBeat.i(63559);
    e locale = null;
    if (this.iVJ.moveToPosition(paramInt))
    {
      am localam = new am();
      localam.convertFrom(this.iVJ);
      locale = new e(paramInt);
      locale.contact = localam;
      locale.KmP = true;
    }
    AppMethodBeat.o(63559);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.f
 * JD-Core Version:    0.7.0.1
 */