package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.y.j;

final class f$1
  implements Runnable
{
  f$1(Context paramContext, boolean paramBoolean) {}
  
  public final void run()
  {
    Context localContext = this.val$context;
    if (this.hgA) {}
    for (String str = this.val$context.getString(y.j.app_brand_collection_remove_failed);; str = this.val$context.getString(y.j.app_brand_collection_add_failed))
    {
      Toast.makeText(localContext, str, 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.f.1
 * JD-Core Version:    0.7.0.1
 */