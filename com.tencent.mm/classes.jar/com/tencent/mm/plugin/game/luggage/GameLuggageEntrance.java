package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public class GameLuggageEntrance
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return R.i.luggage_test;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (EditText)findViewById(R.h.edit_url);
    ((Button)findViewById(R.h.jump_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = paramBundle.getText().toString();
        if (!bk.bl(paramAnonymousView))
        {
          new Bundle().putString("rawUrl", paramAnonymousView);
          Intent localIntent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
          localIntent.putExtra("rawUrl", paramAnonymousView);
          GameLuggageEntrance.this.startActivity(localIntent);
        }
      }
    });
    ((Button)findViewById(R.h.jump_game_center)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        new Bundle().putString("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
        paramAnonymousView = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
        paramAnonymousView.putExtra("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");
        GameLuggageEntrance.this.startActivity(paramAnonymousView);
      }
    });
    setBackBtn(new GameLuggageEntrance.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.GameLuggageEntrance
 * JD-Core Version:    0.7.0.1
 */