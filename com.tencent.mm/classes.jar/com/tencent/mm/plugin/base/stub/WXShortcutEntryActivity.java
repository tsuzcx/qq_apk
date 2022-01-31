package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.plugin.af.b;
import com.tencent.mm.plugin.af.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;

public class WXShortcutEntryActivity
  extends AutoLoginActivity
{
  protected final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      y.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
      finish();
      return;
    }
    parama = c.odU;
    int i = t.a(paramIntent, "type", 0);
    if (paramIntent != null)
    {
      parama = (b)parama.odV.get(i);
      if (parama != null) {
        parama.j(this, paramIntent);
      }
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected final boolean w(Intent paramIntent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity
 * JD-Core Version:    0.7.0.1
 */