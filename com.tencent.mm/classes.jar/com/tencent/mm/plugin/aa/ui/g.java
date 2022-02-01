package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class g
  extends s
{
  private String chatroomName;
  private Cursor iVJ;
  private String[] iVK;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz().AR(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.iVK = bt.hi(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    ad.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    if ((!bt.isNullOrNil(this.query)) && (this.iVK != null))
    {
      com.tencent.mm.kernel.g.ajD();
      this.iVJ = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this.iVK, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cT(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.iVJ == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.iVJ.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a rh(int paramInt)
  {
    AppMethodBeat.i(63564);
    Object localObject = null;
    if (this.iVJ.moveToPosition(paramInt))
    {
      am localam = new am();
      localam.convertFrom(this.iVJ);
      e locale = new e(paramInt);
      locale.contact = localam;
      locale.KmP = true;
      locale.KqI = true;
      localObject = locale;
      if (am.aSQ(localam.field_username))
      {
        locale.KqH = true;
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