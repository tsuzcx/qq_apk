package com.tencent.mm.plugin.kitchen.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.kitchen.ui.KvInfoUI;

public final class a
  implements com.tencent.mm.plugin.kitchen.a.a
{
  public final void r(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramContext.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.b.a
 * JD-Core Version:    0.7.0.1
 */