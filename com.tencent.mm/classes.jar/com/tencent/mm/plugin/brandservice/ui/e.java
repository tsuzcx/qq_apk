package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class e
{
  final Activity djj;
  com.tencent.mm.ui.tools.m mUW;
  String mUt;
  
  public e(Activity paramActivity, String paramString)
  {
    this.djj = paramActivity;
    this.mUt = paramString;
  }
  
  public final boolean d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192940);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(192940);
      return false;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      j.cOB().q(str1, str2, bool);
      j.cOB().hm(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.n(this.djj, this.djj.getString(2131760233));
    }
    AppMethodBeat.o(192940);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e
 * JD-Core Version:    0.7.0.1
 */