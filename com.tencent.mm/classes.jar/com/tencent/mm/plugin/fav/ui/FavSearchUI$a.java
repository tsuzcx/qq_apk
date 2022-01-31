package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class FavSearchUI$a
{
  int actionType;
  int kbN;
  long msZ;
  int mxG;
  int mxH;
  boolean mxI = false;
  int position;
  String query;
  int scene;
  
  public final void IE()
  {
    AppMethodBeat.i(74084);
    h.qsU.e(15488, new Object[] { Integer.valueOf(this.actionType), Integer.valueOf(this.kbN), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.mxG), this.query, Long.valueOf(this.msZ), Integer.valueOf(this.mxH) });
    AppMethodBeat.o(74084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.a
 * JD-Core Version:    0.7.0.1
 */