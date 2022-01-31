package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class ContactsSyncUI$a
  implements b.a
{
  private boolean gCB;
  private w.a gCC;
  
  public ContactsSyncUI$a(ContactsSyncUI paramContactsSyncUI, boolean paramBoolean)
  {
    AppMethodBeat.i(124747);
    this.gCC = new ContactsSyncUI.a.1(this);
    this.gCB = paramBoolean;
    AppMethodBeat.o(124747);
  }
  
  final int P(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124749);
    if (paramContext == null)
    {
      AppMethodBeat.o(124749);
      return 1;
    }
    int i = w.a(paramContext, paramString, this.gCC);
    if (i == 2)
    {
      Toast.makeText(paramContext, this.gCA.getString(2131298856), 1).show();
      AppMethodBeat.o(124749);
      return 1;
    }
    if (i == 3)
    {
      Toast.makeText(paramContext, this.gCA.getString(2131298855), 1).show();
      AppMethodBeat.o(124749);
      return 1;
    }
    AppMethodBeat.o(124749);
    return 0;
  }
  
  public final int cE(Context paramContext)
  {
    AppMethodBeat.i(124748);
    g.RJ();
    if ((!a.QT()) || (a.QP()))
    {
      AppMethodBeat.o(124748);
      return 4;
    }
    if (!this.gCB)
    {
      ab.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
      w.a(this.gCA, this.gCC);
      AppMethodBeat.o(124748);
      return 0;
    }
    String str = (String)g.RL().Ru().get(6, "");
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
      AppMethodBeat.o(124748);
      return 2;
    }
    if (l.aqp())
    {
      h.a(paramContext, 2131298854, 2131297087, 2131297018, 2131296888, new ContactsSyncUI.a.2(this, paramContext, str), new ContactsSyncUI.a.3(this, paramContext));
      AppMethodBeat.o(124748);
      return 5;
    }
    int i = P(paramContext, str);
    AppMethodBeat.o(124748);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.a
 * JD-Core Version:    0.7.0.1
 */