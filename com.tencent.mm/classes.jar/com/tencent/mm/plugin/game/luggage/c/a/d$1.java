package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.e.c;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, AddShortcutTask paramAddShortcutTask, e parame, Context paramContext) {}
  
  public final void run()
  {
    this.kNt.ahD();
    this.kNu.biT.a(new c()
    {
      public final String name()
      {
        return "onAddShortcutStatus";
      }
      
      public final JSONObject pV()
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("success", d.1.this.kNt.success);
          return localJSONObject;
        }
        catch (Exception localException) {}
        return localJSONObject;
      }
    });
    if (this.kNt.success)
    {
      h.a(this.val$context, R.l.wv_add_shortcut_success, R.l.app_tip, false, new d.1.2(this));
      return;
    }
    Toast.makeText(this.val$context, this.val$context.getString(R.l.wv_add_shortcut_fail), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d.1
 * JD-Core Version:    0.7.0.1
 */