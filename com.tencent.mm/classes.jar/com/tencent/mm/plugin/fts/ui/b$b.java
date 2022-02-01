package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$b
{
  public static final int BLP;
  public static final int BLQ;
  public static final int BLR;
  
  static
  {
    AppMethodBeat.i(111811);
    BLP = MMApplicationContext.getContext().getResources().getColor(o.a.Brand_90);
    BLQ = Color.parseColor("#661AAD19");
    BLR = Color.parseColor("#801AAD19");
    AppMethodBeat.o(111811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.b
 * JD-Core Version:    0.7.0.1
 */