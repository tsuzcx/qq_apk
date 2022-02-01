package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.e.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class m
  extends d
  implements e.b
{
  private l Hzh;
  private MMHandler tiG;
  
  public m(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(265617);
    this.tiG = new MMHandler();
    this.Hzh = new l(parame.getContext(), this, paramInt);
    this.Hzh.Htv = paramString;
    AppMethodBeat.o(265617);
  }
  
  protected final a Wj(int paramInt)
  {
    AppMethodBeat.i(265620);
    a locala = this.Hzh.Wj(paramInt);
    if (locala != null) {
      locala.pageType = 7;
    }
    AppMethodBeat.o(265620);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265631);
    if (paramBoolean) {
      setCount(parame.Wi(0));
    }
    for (;;)
    {
      notifyDataSetChanged();
      aZ(getCount(), true);
      AppMethodBeat.o(265631);
      return;
      setCount(0);
    }
  }
  
  protected final boolean a(View paramView, a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(265627);
    this.Hzh.a(getQuery(), this.tiG, new HashSet());
    Log.i("MicroMSsg.FTS.FTSServiceNotifyAdapter", "do search %s", new Object[] { getQuery() });
    AppMethodBeat.o(265627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */