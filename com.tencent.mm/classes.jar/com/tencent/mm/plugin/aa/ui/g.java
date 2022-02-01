package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class g
  extends s
{
  private String chatroomName;
  private String[] iCA;
  private Cursor iCz;
  private String query;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(63562);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xR(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.iCA = bs.gX(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(63562);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63563);
    ac.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    if ((!bs.isNullOrNil(this.query)) && (this.iCA != null))
    {
      com.tencent.mm.kernel.g.agS();
      this.iCz = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(this.iCA, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cO(paramString, true);
    AppMethodBeat.o(63563);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(63565);
    super.finish();
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    AppMethodBeat.o(63565);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(63566);
    if (this.iCz == null)
    {
      AppMethodBeat.o(63566);
      return 0;
    }
    int i = this.iCz.getCount();
    AppMethodBeat.o(63566);
    return i;
  }
  
  public final a qH(int paramInt)
  {
    AppMethodBeat.i(63564);
    Object localObject = null;
    if (this.iCz.moveToPosition(paramInt))
    {
      ai localai = new ai();
      localai.convertFrom(this.iCz);
      e locale = new e(paramInt);
      locale.contact = localai;
      locale.Iwh = true;
      locale.IzC = true;
      localObject = locale;
      if (ai.aNc(localai.field_username))
      {
        locale.IzB = true;
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