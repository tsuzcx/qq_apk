package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public final class g
  implements f
{
  private Context context;
  private ProgressDialog fsw;
  g.a gAj;
  private boolean gAk = true;
  String gAl = "";
  
  public g(Context paramContext, g.a parama)
  {
    this.context = paramContext;
    this.gAj = parama;
    this.gAk = true;
  }
  
  public g(Context paramContext, g.a parama, byte paramByte)
  {
    this.context = paramContext;
    this.gAj = parama;
    this.gAk = false;
  }
  
  public final void o(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(108650);
    com.tencent.mm.kernel.g.Rc().a(116, this);
    paramArrayOfInt = new ah(paramArrayOfInt);
    com.tencent.mm.kernel.g.Rc().a(paramArrayOfInt, 0);
    if (this.gAk)
    {
      Context localContext = this.context;
      this.context.getString(2131300777);
      this.fsw = h.b(localContext, this.context.getString(2131300775), true, new g.1(this, paramArrayOfInt));
    }
    AppMethodBeat.o(108650);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(108651);
    if (paramm.getType() != 116)
    {
      AppMethodBeat.o(108651);
      return;
    }
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    com.tencent.mm.kernel.g.Rc().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.gAk)
      {
        h.a(this.context, 2131300774, 2131297087, new g.2(this));
        AppMethodBeat.o(108651);
        return;
      }
      this.gAj.f(true, this.gAl);
      AppMethodBeat.o(108651);
      return;
    }
    ab.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.gAj.f(false, this.gAl);
    AppMethodBeat.o(108651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */