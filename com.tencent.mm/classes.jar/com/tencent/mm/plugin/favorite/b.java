package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;

public final class b
  implements n
{
  public static m pFn;
  public static l pFo;
  
  public static void a(Context paramContext, long paramLong, String paramString)
  {
    AppMethodBeat.i(261327);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_is_favorite_item", true);
    localIntent.putExtra("key_favorite_local_id", paramLong);
    localIntent.putExtra("key_Product_xml", paramString);
    localIntent.putExtra("key_can_delete_favorite_item", true);
    localIntent.putExtra("key_ProductUI_getProductInfoScene", 3);
    c.b(paramContext, "scanner", ".ui.ProductUI", localIntent);
    AppMethodBeat.o(261327);
  }
  
  public static void b(Context paramContext, long paramLong, String paramString)
  {
    AppMethodBeat.i(261332);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_TV_getProductInfoScene", 3);
    localIntent.putExtra("key_is_favorite_item", true);
    localIntent.putExtra("key_favorite_local_id", paramLong);
    localIntent.putExtra("key_TV_xml", paramString);
    localIntent.putExtra("key_can_delete_favorite_item", true);
    c.b(paramContext, "shake", ".ui.TVInfoUI", localIntent);
    AppMethodBeat.o(261332);
  }
  
  public final void a(l paraml)
  {
    pFo = paraml;
  }
  
  public final void a(m paramm)
  {
    pFn = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.b
 * JD-Core Version:    0.7.0.1
 */