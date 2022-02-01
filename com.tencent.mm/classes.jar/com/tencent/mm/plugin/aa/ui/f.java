package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends s
{
  private ArrayList<String> ice;
  private String[] icp;
  private Cursor icq;
  private String query;
  
  public f(MMBaseSelectContactUI paramMMBaseSelectContactUI, ArrayList<String> paramArrayList)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63557);
    this.ice = paramArrayList;
    if (this.ice != null) {
      this.icp = bt.gK(this.ice);
    }
    AppMethodBeat.o(63557);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63558);
    ad.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    if ((!bt.isNullOrNil(this.query)) && (this.icp != null))
    {
      g.afC();
      this.icq = ((k)g.ab(k.class)).apM().a(this.icp, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cI(paramString, true);
    AppMethodBeat.o(63558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63560);
    super.finish();
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    AppMethodBeat.o(63560);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63561);
    if (this.icq == null)
    {
      AppMethodBeat.o(63561);
      return 0;
    }
    int i = this.icq.getCount();
    AppMethodBeat.o(63561);
    return i;
  }
  
  public final a pU(int paramInt)
  {
    AppMethodBeat.i(63559);
    e locale = null;
    if (this.icq.moveToPosition(paramInt))
    {
      af localaf = new af();
      localaf.convertFrom(this.icq);
      locale = new e(paramInt);
      locale.contact = localaf;
      locale.GVT = true;
    }
    AppMethodBeat.o(63559);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.f
 * JD-Core Version:    0.7.0.1
 */