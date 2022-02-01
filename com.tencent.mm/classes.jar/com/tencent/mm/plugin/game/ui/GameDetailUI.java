package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;

@com.tencent.mm.ui.base.a(19)
public class GameDetailUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42009);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("game_app_id");
    Object localObject = com.tencent.mm.plugin.game.model.a.ei(paramBundle, getIntent().getIntExtra("game_report_from_scene", 0));
    if ((((a.a)localObject).cSx == 2) && (!Util.isNullOrNil(((a.a)localObject).url))) {
      c.D(getBaseContext(), ((a.a)localObject).url, "game_center_detail");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(42009);
      return;
      int i = e.dVb();
      if (i == 2)
      {
        c.l(this, paramBundle, 0);
      }
      else if (i == 1)
      {
        c.f(this, getIntent().getExtras());
      }
      else
      {
        localObject = Util.getSimCountryCode(this);
        if ((Util.isNullOrNil((String)localObject)) || (((String)localObject).toLowerCase().equals("cn"))) {
          c.l(this, paramBundle, 0);
        } else {
          c.f(this, getIntent().getExtras());
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI
 * JD-Core Version:    0.7.0.1
 */