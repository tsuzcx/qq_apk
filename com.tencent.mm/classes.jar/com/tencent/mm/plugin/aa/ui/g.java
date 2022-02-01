package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.u;
import java.util.LinkedList;

public final class g
  extends u
{
  private String chatroomName;
  private Cursor mNt;
  private String[] mNu;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((b)h.ae(b.class)).bbV().RA(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.mNu = Util.listToStrings(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.mNu != null))
    {
      h.aHH();
      this.mNt = ((n)h.ae(n.class)).bbL().a(this.mNu, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    dE(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.mNt == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.mNt.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a ye(int paramInt)
  {
    AppMethodBeat.i(63564);
    Object localObject = null;
    if (this.mNt.moveToPosition(paramInt))
    {
      as localas = new as();
      localas.convertFrom(this.mNt);
      f localf = new f(paramInt);
      localf.contact = localas;
      localf.XsX = true;
      localf.Xxu = true;
      localObject = localf;
      if (as.bvK(localas.field_username))
      {
        localf.Xxt = true;
        localObject = localf;
      }
    }
    AppMethodBeat.o(63564);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.g
 * JD-Core Version:    0.7.0.1
 */