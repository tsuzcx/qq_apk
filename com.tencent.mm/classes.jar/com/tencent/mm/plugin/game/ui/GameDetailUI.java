package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("game_app_id");
    Object localObject = b.bH(paramBundle, getIntent().getIntExtra("game_report_from_scene", 0));
    if ((((b.a)localObject).bcw == 2) && (!bk.bl(((b.a)localObject).url))) {
      c.o(getBaseContext(), ((b.a)localObject).url, "game_center_detail");
    }
    for (;;)
    {
      finish();
      return;
      int i = f.aZd();
      if (i == 2)
      {
        c.ap(this, paramBundle);
      }
      else if (i == 1)
      {
        c.f(this, getIntent().getExtras());
      }
      else
      {
        localObject = bk.fS(this);
        if ((bk.bl((String)localObject)) || (((String)localObject).toLowerCase().equals("cn"))) {
          c.ap(this, paramBundle);
        } else {
          c.f(this, getIntent().getExtras());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI
 * JD-Core Version:    0.7.0.1
 */