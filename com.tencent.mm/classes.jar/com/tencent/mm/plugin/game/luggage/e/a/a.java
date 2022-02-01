package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.ui.base.o;

public abstract class a
{
  int id;
  
  public a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public abstract void a(Context paramContext, g paramg, cxc paramcxc);
  
  public void a(g paramg, o paramo, cxc paramcxc)
  {
    paramg = paramcxc.fwr + "__" + paramcxc.ThumbUrl;
    paramo.d(paramcxc.RXp, paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.a
 * JD-Core Version:    0.7.0.1
 */