package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;

final class RoomInfoDetailUI$2
  implements h.c
{
  RoomInfoDetailUI$2(RoomInfoDetailUI paramRoomInfoDetailUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(104189);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(104189);
      return;
    }
    RoomInfoDetailUI.a(this.ehD, false);
    Object localObject = this.ehD;
    this.ehD.getString(2131297087);
    p localp = h.b((Context)localObject, this.ehD.getString(2131297112), true, new RoomInfoDetailUI.2.1(this));
    if (!RoomInfoDetailUI.a(this.ehD)) {}
    for (localObject = f.amZ(RoomInfoDetailUI.b(this.ehD).field_username);; localObject = null)
    {
      if (!bo.isNullOrNil((String)localObject))
      {
        localp.dismiss();
        h.a(this.ehD, false, this.ehD.getString(2131305019, new Object[] { localObject }), null, this.ehD.getString(2131300537), this.ehD.getString(2131298413), new RoomInfoDetailUI.2.2(this), new RoomInfoDetailUI.2.3(this, localp), -1, 2131689667);
        AppMethodBeat.o(104189);
        return;
      }
      RoomInfoDetailUI.a(this.ehD, localp);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2
 * JD-Core Version:    0.7.0.1
 */