package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.w.b;
import com.tencent.mm.plugin.w.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class WXShortcutEntryActivity
  extends AutoLoginActivity
{
  public final boolean O(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(18226);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
      finish();
      AppMethodBeat.o(18226);
      return;
    }
    Object localObject = c.qSb;
    int i = w.a(paramIntent, "type", 0);
    parama = getContext();
    if (paramIntent != null)
    {
      localObject = (b)((c)localObject).qSc.get(i);
      if (localObject != null) {
        ((b)localObject).l(parama, paramIntent);
      }
    }
    finish();
    AppMethodBeat.o(18226);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18225);
    super.onCreate(paramBundle);
    AppMethodBeat.o(18225);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity
 * JD-Core Version:    0.7.0.1
 */