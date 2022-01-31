package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b$a
{
  public static int kzX = 0;
  
  static
  {
    Context localContext = ae.getContext();
    kzX = a.fj(localContext) - a.aa(localContext, n.b.SearchLargePadding) * 2 - a.aa(localContext, n.b.NormalAvatarSize) - a.aa(localContext, n.b.SearchLargePadding);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */