package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.h;

public class FreeWifiTestActivity
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25170);
    super.onCreate(paramBundle);
    setContentView(2131494179);
    findViewById(2131300286).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25168);
        Toast.makeText(ai.getContext(), "test message", 0).show();
        AppMethodBeat.o(25168);
      }
    });
    findViewById(2131300287).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25169);
        h.a(FreeWifiTestActivity.this, "t12345", "t54331", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }, null);
        AppMethodBeat.o(25169);
      }
    });
    AppMethodBeat.o(25170);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity
 * JD-Core Version:    0.7.0.1
 */