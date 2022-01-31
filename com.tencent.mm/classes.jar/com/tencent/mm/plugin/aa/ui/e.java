package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.q;

public final class e
  extends q
{
  private String bVk;
  private String chatroomName;
  private String[] eYc;
  private Cursor eYd;
  
  public e(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.r(c.class)).FF().ir(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.eYc = bk.dj(paramMMBaseSelectContactUI);
    }
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    y.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.bVk = paramString;
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    if ((!bk.bl(this.bVk)) && (this.eYc != null))
    {
      g.DQ();
      this.eYd = ((j)g.r(j.class)).Fw().a(this.eYc, "@all.chatroom", this.bVk, null, null);
    }
    notifyDataSetChanged();
    bN(paramString, true);
  }
  
  public final void finish()
  {
    super.finish();
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
  }
  
  public final int getCount()
  {
    if (this.eYd == null) {
      return 0;
    }
    return this.eYd.getCount();
  }
  
  protected final a jQ(int paramInt)
  {
    d locald = null;
    if (this.eYd.moveToPosition(paramInt))
    {
      ad localad = new ad();
      localad.d(this.eYd);
      locald = new d(paramInt);
      locald.dnp = localad;
      locald.vLJ = true;
    }
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.e
 * JD-Core Version:    0.7.0.1
 */