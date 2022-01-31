package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.input.v.a;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;

public final class a$a
  extends FrameLayout
  implements v.a
{
  public View gdx;
  
  public a$a(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(y.h.app_brand_game_input_panel_edit_bar, this, true);
    ((Button)findViewById(y.g.game_edit_send)).setText(y.j.appbrand_game_input_confirm);
  }
  
  public final View getConfirmButton()
  {
    if (this.gdx == null) {
      this.gdx = findViewById(y.g.game_edit_send);
    }
    return this.gdx;
  }
  
  public final void setIsHide(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */