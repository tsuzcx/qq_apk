package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;
import com.tencent.mm.ui.MMFragmentActivity.a;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class GameChatTabUI
  extends GameLifeConversationUI
{
  private a Dbb;
  private String Dbc;
  
  public GameChatTabUI()
  {
    AppMethodBeat.i(205862);
    this.Dbb = new a(this);
    AppMethodBeat.o(205862);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(205869);
    super.onBackPressed();
    this.Dbb.onBackPressed();
    AppMethodBeat.o(205869);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(205873);
    super.onConfigurationChanged(paramConfiguration);
    this.Dbb.cN();
    AppMethodBeat.o(205873);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205864);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("game_from_detail_back", false)) {
      overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
    }
    this.Dbb.a(getContentView(), new c.a()
    {
      public final void TW(int paramAnonymousInt)
      {
        AppMethodBeat.i(200017);
        GameChatTabUI.a(GameChatTabUI.this, paramAnonymousInt);
        AppMethodBeat.o(200017);
      }
      
      public final void aKq(String paramAnonymousString)
      {
        AppMethodBeat.i(200018);
        GameChatTabUI.a(GameChatTabUI.this, paramAnonymousString);
        AppMethodBeat.o(200018);
      }
    });
    paramBundle = getSupportActionBar().getCustomView();
    if ((paramBundle != null) && ((paramBundle instanceof LinearLayout)))
    {
      Object localObject = paramBundle.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = LayoutInflater.from(this).inflate(g.f.CnG, (LinearLayout)paramBundle, false);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.gravity = 16;
      ((LinearLayout)paramBundle).addView((View)localObject, localLayoutParams);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194262);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = com.tencent.mm.game.report.c.jTf;
          com.tencent.mm.game.report.c.a.Fp(GameChatTabUI.this.getIntent().getIntExtra("game_report_from_scene", 0));
          com.tencent.mm.plugin.game.d.c.aY(GameChatTabUI.this, GameChatTabUI.b(GameChatTabUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194262);
        }
      });
    }
    AppMethodBeat.o(205864);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(205870);
    super.onDestroy();
    this.Dbb.onDestroy();
    AppMethodBeat.o(205870);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(205872);
    this.Dbb.evQ();
    AppMethodBeat.o(205872);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(205867);
    super.onNewIntent(paramIntent);
    this.Dbb.onNewIntent(paramIntent);
    AppMethodBeat.o(205867);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(205866);
    super.onPause();
    a.onPause();
    AppMethodBeat.o(205866);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(205865);
    super.onResume();
    this.Dbb.onResume();
    if (getIntent().getBooleanExtra("disable_game_page_swipe", false)) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(201186);
          if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
          {
            AppMethodBeat.o(201186);
            return false;
          }
          GameChatTabUI.a(GameChatTabUI.this);
          AppMethodBeat.o(201186);
          return false;
        }
      });
    }
    AppMethodBeat.o(205865);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI
 * JD-Core Version:    0.7.0.1
 */