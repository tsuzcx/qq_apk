package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends s
{
  private String[] iYB;
  private Cursor iYC;
  private ArrayList<String> iYo;
  private String query;
  
  public f(MMBaseSelectContactUI paramMMBaseSelectContactUI, ArrayList<String> paramArrayList)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63557);
    this.iYo = paramArrayList;
    if (this.iYo != null) {
      this.iYB = bu.hs(this.iYo);
    }
    AppMethodBeat.o(63557);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63558);
    ae.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    if ((!bu.isNullOrNil(this.query)) && (this.iYB != null))
    {
      g.ajS();
      this.iYC = ((l)g.ab(l.class)).azF().a(this.iYB, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cX(paramString, true);
    AppMethodBeat.o(63558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63560);
    super.finish();
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    AppMethodBeat.o(63560);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63561);
    if (this.iYC == null)
    {
      AppMethodBeat.o(63561);
      return 0;
    }
    int i = this.iYC.getCount();
    AppMethodBeat.o(63561);
    return i;
  }
  
  public final a rk(int paramInt)
  {
    AppMethodBeat.i(63559);
    e locale = null;
    if (this.iYC.moveToPosition(paramInt))
    {
      an localan = new an();
      localan.convertFrom(this.iYC);
      locale = new e(paramInt);
      locale.contact = localan;
      locale.KJj = true;
    }
    AppMethodBeat.o(63559);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.f
 * JD-Core Version:    0.7.0.1
 */