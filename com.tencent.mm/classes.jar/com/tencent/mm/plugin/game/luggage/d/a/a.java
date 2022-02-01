package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.ui.base.l;

public abstract class a
{
  int id;
  
  public a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public abstract void a(Context paramContext, g paramg, byv parambyv);
  
  public void a(g paramg, l paraml, byv parambyv)
  {
    paramg = parambyv.Title + "__" + parambyv.ThumbUrl;
    paraml.c(parambyv.FJz, paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.a
 * JD-Core Version:    0.7.0.1
 */