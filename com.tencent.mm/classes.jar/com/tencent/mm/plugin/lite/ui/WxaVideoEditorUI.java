package com.tencent.mm.plugin.lite.ui;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import com.tencent.luggage.f.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class WxaVideoEditorUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return a.c.flutter_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(271422);
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    AppMethodBeat.o(271422);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaVideoEditorUI
 * JD-Core Version:    0.7.0.1
 */