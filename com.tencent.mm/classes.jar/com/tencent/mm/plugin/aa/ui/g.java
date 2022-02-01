package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class g
  extends s
{
  private String chatroomName;
  private Cursor jWh;
  private String[] jWi;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().Kh(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.jWi = Util.listToStrings(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.jWi != null))
    {
      com.tencent.mm.kernel.g.aAi();
      this.jWh = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().a(this.jWi, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    ds(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.jWh == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.jWh.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a va(int paramInt)
  {
    AppMethodBeat.i(63564);
    Object localObject = null;
    if (this.jWh.moveToPosition(paramInt))
    {
      as localas = new as();
      localas.convertFrom(this.jWh);
      e locale = new e(paramInt);
      locale.contact = localas;
      locale.PWh = true;
      locale.Qac = true;
      localObject = locale;
      if (as.bjp(localas.field_username))
      {
        locale.Qab = true;
        localObject = locale;
      }
    }
    AppMethodBeat.o(63564);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.g
 * JD-Core Version:    0.7.0.1
 */