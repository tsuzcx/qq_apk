package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.ui.base.s;

public abstract class a
{
  int id;
  
  public a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public abstract void a(Context paramContext, g paramg, doh paramdoh);
  
  public void a(g paramg, s params, doh paramdoh)
  {
    paramg = paramdoh.hAP + "__" + paramdoh.ThumbUrl;
    params.c(paramdoh.YVh, paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.a
 * JD-Core Version:    0.7.0.1
 */