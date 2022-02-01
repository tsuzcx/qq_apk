package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.x.b;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

public class WXShortcutEntryActivity
  extends AutoLoginActivity
{
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(22327);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
      finish();
      AppMethodBeat.o(22327);
      return;
    }
    Object localObject = com.tencent.mm.plugin.x.c.DlS;
    int i = IntentUtil.getIntExtra(paramIntent, "type", 0);
    if ((com.tencent.mm.plugin.x.c.XE(i)) && (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(this, new android.support.v4.e.c() {})))
    {
      AppMethodBeat.o(22327);
      return;
    }
    parama = getContext();
    if (paramIntent != null)
    {
      localObject = (b)((com.tencent.mm.plugin.x.c)localObject).DlT.get(i);
      if (localObject != null) {
        ((b)localObject).k(parama, paramIntent);
      }
    }
    finish();
    AppMethodBeat.o(22327);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22326);
    super.onCreate(paramBundle);
    AppMethodBeat.o(22326);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity
 * JD-Core Version:    0.7.0.1
 */