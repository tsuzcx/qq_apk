package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class FreeWifiOwnerUI
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25118);
    super.onCreate(paramBundle);
    AppMethodBeat.o(25118);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25119);
    super.onResume();
    String str = getIntent().getStringExtra("wifi_owner_name");
    int i = getIntent().getIntExtra("wifi_owner_type", 0);
    com.tencent.mm.plugin.freewifi.j.userName = str;
    com.tencent.mm.plugin.freewifi.j.type = i;
    finish();
    AppMethodBeat.o(25119);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiOwnerUI
 * JD-Core Version:    0.7.0.1
 */