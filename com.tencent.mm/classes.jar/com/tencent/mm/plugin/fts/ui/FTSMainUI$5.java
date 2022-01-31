package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.api.j;
import com.tencent.mm.bq.d;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class FTSMainUI$5
  implements com.tencent.mm.ai.f
{
  FTSMainUI$5(FTSMainUI paramFTSMainUI, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(61870);
    g.Rc().b(106, this);
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      FTSMainUI.o(this.mYi);
      h.a(this.mYi, 2131302983, 0, true, null);
      AppMethodBeat.o(61870);
      return;
    }
    FTSMainUI.o(this.mYi);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        ab.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(61870);
        return;
        Toast.makeText(this.mYi, this.mYi.getString(2131302978), 0).show();
        continue;
        paramString = a.kO(paramString);
        if (paramString != null) {
          h.a(this.mYi, paramString.desc, paramString.Title, true, null);
        }
      }
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI();
    if (paramString.xaS > 0)
    {
      if (paramString.xaT.isEmpty())
      {
        h.a(this.mYi, 2131302983, 0, true, null);
        AppMethodBeat.o(61870);
        return;
      }
      paramm = new Intent();
      ((j)g.E(j.class)).a(paramm, (bxf)paramString.xaT.getFirst(), this.mYi.mWz);
      d.b(this.mYi, "profile", ".ui.ContactInfoUI", paramm);
      AppMethodBeat.o(61870);
      return;
    }
    if (bo.nullAsNil(aa.a(paramString.wOT)).length() > 0)
    {
      if (2 != paramString.xKf) {
        break label419;
      }
      this.mYi.mWz = 15;
    }
    for (;;)
    {
      paramm = new Intent();
      ((j)g.E(j.class)).a(paramm, paramString, this.mYi.mWz);
      if (this.mYi.mWz == 15) {
        paramm.putExtra("Contact_Search_Mobile", this.Cr.trim());
      }
      paramm.putExtra("Contact_Scene", this.mYi.mWz);
      paramm.putExtra("add_more_friend_search_scene", 2);
      d.b(this.mYi, "profile", ".ui.ContactInfoUI", paramm);
      AppMethodBeat.o(61870);
      return;
      label419:
      if (1 == paramString.xKf) {
        this.mYi.mWz = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.5
 * JD-Core Version:    0.7.0.1
 */