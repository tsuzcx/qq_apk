package com.tencent.mm.plugin.game.ui.chat_tab;

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
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;
import com.tencent.mm.ui.MMFragmentActivity.a;

@com.tencent.mm.ui.widget.pulldown.c(0)
public class GameChatTabUI
  extends GameLifeConversationUI
{
  private a IVp;
  private String IVq;
  
  public GameChatTabUI()
  {
    AppMethodBeat.i(276605);
    this.IVp = new a(this);
    AppMethodBeat.o(276605);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(276666);
    super.onBackPressed();
    this.IVp.onBackPressed();
    AppMethodBeat.o(276666);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(276688);
    super.onConfigurationChanged(paramConfiguration);
    this.IVp.dG();
    AppMethodBeat.o(276688);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276641);
    super.onCreate(paramBundle);
    if (getIntent().getBooleanExtra("game_from_detail_back", false)) {
      overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
    }
    com.tencent.mm.plugin.game.commlib.e.b.fM(this);
    this.IVp.a(getContentView(), new c.a()
    {
      public final void XQ(int paramAnonymousInt)
      {
        AppMethodBeat.i(276628);
        GameChatTabUI.a(GameChatTabUI.this, paramAnonymousInt);
        AppMethodBeat.o(276628);
      }
      
      public final void aHg(String paramAnonymousString)
      {
        AppMethodBeat.i(276636);
        GameChatTabUI.a(GameChatTabUI.this, paramAnonymousString);
        AppMethodBeat.o(276636);
      }
    });
    paramBundle = getSupportActionBar().getCustomView();
    if ((paramBundle != null) && ((paramBundle instanceof LinearLayout)))
    {
      Object localObject = paramBundle.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = LayoutInflater.from(this).inflate(h.f.HZO, (LinearLayout)paramBundle, false);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.gravity = 16;
      ((LinearLayout)paramBundle).addView((View)localObject, localLayoutParams);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276634);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = com.tencent.mm.game.report.c.mtx;
          com.tencent.mm.game.report.c.a.hx(GameChatTabUI.this.getIntent().getIntExtra("game_report_from_scene", 0));
          com.tencent.mm.plugin.game.d.c.ba(GameChatTabUI.this, GameChatTabUI.b(GameChatTabUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276634);
        }
      });
    }
    AppMethodBeat.o(276641);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(276675);
    super.onDestroy();
    this.IVp.onDestroy();
    com.tencent.mm.plugin.game.commlib.e.b.fN(this);
    AppMethodBeat.o(276675);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(276683);
    this.IVp.fHD();
    AppMethodBeat.o(276683);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(276658);
    super.onNewIntent(paramIntent);
    this.IVp.onNewIntent(paramIntent);
    AppMethodBeat.o(276658);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(276653);
    super.onPause();
    a.onPause();
    AppMethodBeat.o(276653);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(276647);
    super.onResume();
    this.IVp.onResume();
    if (getIntent().getBooleanExtra("disable_game_page_swipe", false)) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(276627);
          if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
          {
            AppMethodBeat.o(276627);
            return false;
          }
          GameChatTabUI.a(GameChatTabUI.this);
          AppMethodBeat.o(276627);
          return false;
        }
      });
    }
    AppMethodBeat.o(276647);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI
 * JD-Core Version:    0.7.0.1
 */