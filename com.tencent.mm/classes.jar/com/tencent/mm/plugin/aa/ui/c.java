package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern eXJ = Pattern.compile(",");
  public CharSequence eXK;
  public CharSequence eXL;
  private c.b eXM = new c.b(this);
  c.a eXN = new c.a(this);
  public String username;
  
  public c(int paramInt)
  {
    super(2, paramInt);
  }
  
  protected final a.a VA()
  {
    return this.eXN;
  }
  
  public final a.b Vz()
  {
    return this.eXM;
  }
  
  public final void bW(Context paramContext)
  {
    if (this.dnp == null)
    {
      y.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      return;
    }
    this.username = this.dnp.field_username;
    if (bk.bl(this.bHQ)) {}
    for (String str1 = ((b)g.r(b.class)).c(this.dnp);; str1 = ((b)g.r(b.class)).getDisplayName(this.dnp.field_username, this.bHQ))
    {
      String str2 = str1;
      if (q.Gj().equals(this.username)) {
        str2 = str1 + paramContext.getString(a.i.aa_myself_note);
      }
      this.eXK = j.b(paramContext, str2, com.tencent.mm.cb.a.aa(paramContext, a.d.NormalTextSize));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */