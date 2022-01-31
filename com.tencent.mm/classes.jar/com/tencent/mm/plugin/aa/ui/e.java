package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.r;

public final class e
  extends r
{
  private String chatroomName;
  private String[] gpZ;
  private Cursor gqa;
  private String query;
  
  public e(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(40770);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.E(c.class)).YJ().oY(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.gpZ = bo.er(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(40770);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(40771);
    ab.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    if ((!bo.isNullOrNil(this.query)) && (this.gpZ != null))
    {
      g.RM();
      this.gqa = ((j)g.E(j.class)).YA().a(this.gpZ, "@all.chatroom", this.query, null, null);
    }
    notifyDataSetChanged();
    cp(paramString, true);
    AppMethodBeat.o(40771);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(40773);
    super.finish();
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    AppMethodBeat.o(40773);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(40774);
    if (this.gqa == null)
    {
      AppMethodBeat.o(40774);
      return 0;
    }
    int i = this.gqa.getCount();
    AppMethodBeat.o(40774);
    return i;
  }
  
  public final a mM(int paramInt)
  {
    AppMethodBeat.i(40772);
    com.tencent.mm.ui.contact.a.e locale = null;
    if (this.gqa.moveToPosition(paramInt))
    {
      ad localad = new ad();
      localad.convertFrom(this.gqa);
      locale = new com.tencent.mm.ui.contact.a.e(paramInt);
      locale.contact = localad;
      locale.Adl = true;
    }
    AppMethodBeat.o(40772);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */