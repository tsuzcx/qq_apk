package com.tencent.mm.plugin.appbrand.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.n.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;
import org.json.JSONObject;

final class d$2
  implements n.d
{
  d$2(d paramd, z paramz, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(132204);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132204);
      return;
      paramMenuItem = new JsApiUpdateApp();
      Object localObject = this.hKE.atU();
      new JSONObject();
      paramMenuItem.a((c)localObject, 10000);
      AppMethodBeat.o(132204);
      return;
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramMenuItem = "wxfile://";
      }
      for (;;)
      {
        paramMenuItem = this.hKE.wX().aa(paramMenuItem, true).getAbsolutePath();
        Toast.makeText(this.val$context, this.val$context.getString(2131306119, new Object[] { paramMenuItem }), 0).show();
        paramMenuItem = ClipData.newPlainText("text", paramMenuItem);
        ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(paramMenuItem);
        AppMethodBeat.o(132204);
        return;
        paramMenuItem = "wxfile://usr";
        continue;
        paramMenuItem = "wxfile://opendata";
        continue;
        paramMenuItem = "wxfile://clientdata";
      }
      paramMenuItem = ClipData.newPlainText("text", this.hKE.getAppId());
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(paramMenuItem);
      Toast.makeText(this.val$context, this.val$context.getString(2131306114, new Object[] { this.hKE.getAppId() }), 1).show();
      AppMethodBeat.o(132204);
      return;
      paramMenuItem = this.hKE.getRuntime().atS().username;
      localObject = ClipData.newPlainText("text", paramMenuItem);
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip((ClipData)localObject);
      Toast.makeText(this.val$context, this.val$context.getString(2131306122, new Object[] { paramMenuItem }), 1).show();
      AppMethodBeat.o(132204);
      return;
      this.hKE.hmw.postDelayed(new d.2.1(this), 1000L);
      AppMethodBeat.o(132204);
      return;
      if (b.aLC()) {
        b.aLE();
      }
      for (;;)
      {
        paramMenuItem.setTitle(this.val$context.getString(2131306116) + String.format("(cur:%b)", new Object[] { Boolean.valueOf(b.aLC()) }));
        Toast.makeText(this.val$context, "Restart Wechat!!", 1).show();
        AppMethodBeat.o(132204);
        return;
        b.aLD();
      }
      Assert.assertTrue("test errlog " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
      AppMethodBeat.o(132204);
      return;
      MMProtocalJni.setClientPackVersion(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d.2
 * JD-Core Version:    0.7.0.1
 */