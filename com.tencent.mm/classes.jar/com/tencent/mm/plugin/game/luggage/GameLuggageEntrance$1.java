package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class GameLuggageEntrance$1
  implements View.OnClickListener
{
  GameLuggageEntrance$1(GameLuggageEntrance paramGameLuggageEntrance, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135798);
    paramView = this.nje.getText().toString();
    if (!bo.isNullOrNil(paramView))
    {
      new Bundle().putString("rawUrl", paramView);
      Intent localIntent = new Intent(this.njf, LuggageGameWebViewUI.class);
      localIntent.putExtra("rawUrl", paramView);
      this.njf.startActivity(localIntent);
    }
    AppMethodBeat.o(135798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameLuggageEntrance.1
 * JD-Core Version:    0.7.0.1
 */