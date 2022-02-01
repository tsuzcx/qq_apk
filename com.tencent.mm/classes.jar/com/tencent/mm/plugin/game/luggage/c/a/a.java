package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.ui.base.l;

public abstract class a
{
  int id;
  
  public a(int paramInt)
  {
    this.id = paramInt;
  }
  
  public abstract void a(Context paramContext, f paramf, bug parambug);
  
  public void a(f paramf, l paraml, bug parambug)
  {
    paramf = parambug.Title + "__" + parambug.ThumbUrl;
    paraml.c(parambug.Edq, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.a
 * JD-Core Version:    0.7.0.1
 */