package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class g
  extends s
{
  private String chatroomName;
  private Cursor iYC;
  private String[] iYD;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)com.tencent.mm.kernel.g.ab(c.class)).azP().BB(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.iYD = bu.hs(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    ae.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    if ((!bu.isNullOrNil(this.query)) && (this.iYD != null))
    {
      com.tencent.mm.kernel.g.ajS();
      this.iYC = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this.iYD, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cX(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.iYC == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.iYC.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a rk(int paramInt)
  {
    AppMethodBeat.i(63564);
    Object localObject = null;
    if (this.iYC.moveToPosition(paramInt))
    {
      an localan = new an();
      localan.convertFrom(this.iYC);
      e locale = new e(paramInt);
      locale.contact = localan;
      locale.KJj = true;
      locale.KNc = true;
      localObject = locale;
      if (an.aUq(localan.field_username))
      {
        locale.KNb = true;
        localObject = locale;
      }
    }
    AppMethodBeat.o(63564);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.g
 * JD-Core Version:    0.7.0.1
 */