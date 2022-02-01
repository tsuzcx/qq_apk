package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.u;
import java.util.LinkedList;

public final class g
  extends u
{
  private String chatroomName;
  private Cursor pKb;
  private String[] pKc;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((b)h.ax(b.class)).bzK().Jy(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.pKc = Util.listToStrings(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.pKc != null))
    {
      h.baF();
      this.pKb = ((n)h.ax(n.class)).bzA().a(this.pKc, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    eo(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.pKb == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.pKb.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(63564);
    Object localObject = null;
    if (this.pKb.moveToPosition(paramInt))
    {
      au localau = new au();
      localau.convertFrom(this.pKb);
      f localf = new f(paramInt);
      localf.contact = localau;
      localf.afey = true;
      localf.afjB = true;
      localObject = localf;
      if (au.bwO(localau.field_username))
      {
        localf.JXr = true;
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