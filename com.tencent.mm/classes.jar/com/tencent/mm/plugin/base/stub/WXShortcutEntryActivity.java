package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.x.b;
import com.tencent.mm.plugin.x.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;

public class WXShortcutEntryActivity
  extends AutoLoginActivity
{
  public final boolean Z(Intent paramIntent)
  {
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(22327);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
      finish();
      AppMethodBeat.o(22327);
      return;
    }
    Object localObject = c.wqQ;
    int i = y.getIntExtra(paramIntent, "type", 0);
    parama = getContext();
    if (paramIntent != null)
    {
      localObject = (b)((c)localObject).wqR.get(i);
      if (localObject != null) {
        ((b)localObject).k(parama, paramIntent);
      }
    }
    finish();
    AppMethodBeat.o(22327);
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