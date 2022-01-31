package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.ui.base.l;

public abstract class a
{
  int id;
  
  public a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public abstract void a(Context paramContext, e parame, awk paramawk);
  
  public void a(e parame, l paraml, awk paramawk)
  {
    parame = paramawk.bGw + "__" + paramawk.mQp;
    paraml.e(paramawk.sYX, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.a
 * JD-Core Version:    0.7.0.1
 */