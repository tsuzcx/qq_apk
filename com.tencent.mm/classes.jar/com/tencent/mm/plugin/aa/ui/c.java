package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern gpG;
  public CharSequence gpH;
  public CharSequence gpI;
  private c.b gpJ;
  c.a gpK;
  public String username;
  
  static
  {
    AppMethodBeat.i(40747);
    gpG = Pattern.compile(",");
    AppMethodBeat.o(40747);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(40745);
    this.gpJ = new c.b(this);
    this.gpK = new c.a(this);
    AppMethodBeat.o(40745);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(40746);
    if (this.contact == null)
    {
      ab.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(40746);
      return;
    }
    this.username = this.contact.field_username;
    if (bo.isNullOrNil(this.cpf)) {}
    for (parama = ((b)g.E(b.class)).c(this.contact);; parama = ((b)g.E(b.class)).getDisplayName(this.contact.field_username, this.cpf))
    {
      Object localObject = parama;
      if (r.Zn().equals(this.username)) {
        localObject = parama + paramContext.getString(2131296375);
      }
      this.gpH = j.b(paramContext, (CharSequence)localObject, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
      AppMethodBeat.o(40746);
      return;
    }
  }
  
  public final a.b aoY()
  {
    return this.gpJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */