package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.o;
import com.tencent.mm.broadcast.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import java.io.IOException;
import java.util.LinkedList;

final class FTSAddFriendUI$5
  implements com.tencent.mm.am.h
{
  FTSAddFriendUI$5(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(111822);
    com.tencent.mm.kernel.h.aZW().b(106, this);
    FTSAddFriendUI.d(this.Hxv);
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      switch (paramInt2)
      {
      default: 
        FTSAddFriendUI.e(this.Hxv).setText(p.g.no_contact_result);
        label69:
        FTSAddFriendUI.a(this.Hxv, -1);
        FTSAddFriendUI.b(this.Hxv, 1);
      }
    }
    for (;;)
    {
      FTSAddFriendUI.h(this.Hxv);
      AppMethodBeat.o(111822);
      return;
      if (paramInt1 == 4) {
        break;
      }
      FTSAddFriendUI.e(this.Hxv).setText(this.Hxv.getString(p.g.search_contact_err_no_code));
      break label69;
      paramString = a.CH(paramString);
      if (paramString != null)
      {
        FTSAddFriendUI.e(this.Hxv).setText(paramString.desc);
        break label69;
      }
      FTSAddFriendUI.e(this.Hxv).setText(p.g.no_contact_result);
      break label69;
      FTSAddFriendUI.a(this.Hxv, ((f)paramp).gaH());
      FTSAddFriendUI localFTSAddFriendUI = this.Hxv;
      paramString = (evf)c.b.b(((f)paramp).rr.otB);
      if (paramString != null) {}
      for (paramString = w.a(paramString.ZqL);; paramString = "")
      {
        FTSAddFriendUI.a(localFTSAddFriendUI, paramString);
        if (FTSAddFriendUI.f(this.Hxv).aaqy <= 0) {
          break label411;
        }
        if (!FTSAddFriendUI.f(this.Hxv).aaqz.isEmpty()) {
          break;
        }
        k.a(this.Hxv, p.g.search_contact_not_found, 0, true, null);
        AppMethodBeat.o(111822);
        return;
      }
      paramString = new Intent();
      paramString.putExtra("add_more_friend_search_scene", 3);
      if (FTSAddFriendUI.f(this.Hxv).aaqz.size() > 1) {
        try
        {
          paramString.putExtra("result", FTSAddFriendUI.f(this.Hxv).toByteArray());
          com.tencent.mm.br.c.b(this.Hxv.getContext(), "subapp", ".ui.pluginapp.ContactSearchResultUI", paramString);
          AppMethodBeat.o(111822);
          return;
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", paramString, "", new Object[0]);
          AppMethodBeat.o(111822);
          return;
        }
      }
      ((o)com.tencent.mm.kernel.h.ax(o.class)).a(paramString, (eve)FTSAddFriendUI.f(this.Hxv).aaqz.getFirst(), this.Hxv.Hxu);
      label411:
      FTSAddFriendUI.a(this.Hxv, 1);
      FTSAddFriendUI.g(this.Hxv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.5
 * JD-Core Version:    0.7.0.1
 */