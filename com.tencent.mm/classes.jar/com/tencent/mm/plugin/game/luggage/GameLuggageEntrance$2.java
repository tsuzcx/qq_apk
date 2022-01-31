package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLuggageEntrance$2
  implements View.OnClickListener
{
  GameLuggageEntrance$2(GameLuggageEntrance paramGameLuggageEntrance) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135799);
    new Bundle().putString("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
    paramView = new Intent(this.njf, LuggageGameWebViewUI.class);
    paramView.putExtra("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
    this.njf.startActivity(paramView);
    AppMethodBeat.o(135799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameLuggageEntrance.2
 * JD-Core Version:    0.7.0.1
 */