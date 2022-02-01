package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class g
  extends s
{
  private String chatroomName;
  private Cursor icq;
  private String[] icr;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tL(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.icr = bt.gK(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    ad.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    if ((!bt.isNullOrNil(this.query)) && (this.icr != null))
    {
      com.tencent.mm.kernel.g.afC();
      this.icq = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(this.icr, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cI(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.icq == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.icq.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a pU(int paramInt)
  {
    AppMethodBeat.i(63564);
    e locale = null;
    if (this.icq.moveToPosition(paramInt))
    {
      af localaf = new af();
      localaf.convertFrom(this.icq);
      locale = new e(paramInt);
      locale.contact = localaf;
      locale.GVT = true;
    }
    AppMethodBeat.o(63564);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.g
 * JD-Core Version:    0.7.0.1
 */