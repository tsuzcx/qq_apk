package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.game.model.GameFloatLayerInfo;

final class LuggageGameWebViewUI$2
  implements Runnable
{
  LuggageGameWebViewUI$2(LuggageGameWebViewUI paramLuggageGameWebViewUI, GameFloatLayerInfo paramGameFloatLayerInfo) {}
  
  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rawUrl", this.kML.url);
    localBundle.putBoolean("show_full_screen", this.kML.kOO);
    localBundle.putInt("screen_orientation", this.kML.orientation);
    if (this.kML.kOO) {
      localBundle.putBoolean("transparent_page", false);
    }
    for (;;)
    {
      localBundle.putBoolean("needAnimation", false);
      localBundle.putInt("customize_status_bar_color", this.kMK.getIntent().getIntExtra("customize_status_bar_color", 0));
      localBundle.putString("customize_status_bar_color", this.kMK.getIntent().getStringExtra("status_bar_style"));
      LuggageGameWebViewUI.a(this.kMK).a(this.kML.url, localBundle, false);
      return;
      localBundle.putBoolean("transparent_page", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */