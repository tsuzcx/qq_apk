package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.ui.base.l;

public abstract class a
{
  int id;
  
  public a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public abstract void a(Context paramContext, g paramg, bzp parambzp);
  
  public void a(g paramg, l paraml, bzp parambzp)
  {
    paramg = parambzp.Title + "__" + parambzp.ThumbUrl;
    paraml.d(parambzp.GbY, paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.a
 * JD-Core Version:    0.7.0.1
 */