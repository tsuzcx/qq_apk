package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class GameCenterActivity
  extends GameBaseActivity
{
  protected int sfB = 0;
  protected String sfC = null;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterActivity
 * JD-Core Version:    0.7.0.1
 */