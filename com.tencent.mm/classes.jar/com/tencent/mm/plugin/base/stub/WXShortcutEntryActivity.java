package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.an.b;
import com.tencent.mm.plugin.an.c;
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
    Object localObject = c.PET;
    int i = IntentUtil.getIntExtra(paramIntent, "type", 0);
    if ((c.ajm(i)) && (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(this, new a() {})))
    {
      AppMethodBeat.o(22327);
      return;
    }
    parama = getContext();
    if (paramIntent != null)
    {
      localObject = (b)((c)localObject).PEU.get(i);
      if (localObject != null) {
        ((b)localObject).C(parama, paramIntent);
      }
    }
    finish();
    AppMethodBeat.o(22327);
  }
  
  public final boolean ad(Intent paramIntent)
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