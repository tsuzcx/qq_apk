package com.tencent.mm.plugin.game.luggage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class GameLuggageEntrance
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2130970060;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(135801);
    super.onCreate(paramBundle);
    paramBundle = (EditText)findViewById(2131825860);
    ((Button)findViewById(2131825861)).setOnClickListener(new GameLuggageEntrance.1(this, paramBundle));
    ((Button)findViewById(2131825862)).setOnClickListener(new GameLuggageEntrance.2(this));
    setBackBtn(new GameLuggageEntrance.3(this));
    AppMethodBeat.o(135801);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameLuggageEntrance
 * JD-Core Version:    0.7.0.1
 */