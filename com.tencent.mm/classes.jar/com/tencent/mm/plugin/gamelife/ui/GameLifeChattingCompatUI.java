package com.tencent.mm.plugin.gamelife.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.a;
import com.tencent.mm.chatting.a.a;
import com.tencent.mm.chatting.a.a.a;
import com.tencent.mm.chatting.a.b;
import com.tencent.mm.chatting.a.c;
import com.tencent.mm.chatting.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingFragmentFinish;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActivityController;", "()V", "chattingCompat", "Lcom/tencent/mm/chatting/IChattingCompat;", "getChattingCompat", "()Lcom/tencent/mm/chatting/IChattingCompat;", "setChattingCompat", "(Lcom/tencent/mm/chatting/IChattingCompat;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onChattingFinishBegin", "", "onChattingFinishEnd", "onChattingUIEnter", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class GameLifeChattingCompatUI
  extends MMActivity
  implements a.b, a.c, a.d
{
  public static final GameLifeChattingCompatUI.a JbV = new GameLifeChattingCompatUI.a((byte)0);
  private a lPI;
  
  public void _$_clearFindViewByIdCache() {}
  
  public final void aNV()
  {
    Log.i("GameLife.ChattingCompatUI", "[onChattingUIEnter] ...");
  }
  
  public final boolean aNW()
  {
    Log.i("GameLife.ChattingCompatUI", "[onChattingUIExit] ...");
    return true;
  }
  
  public final void aNX()
  {
    Log.i("GameLife.ChattingCompatUI", "[onChattingFinishBegin] ...");
  }
  
  public final void aNY()
  {
    Log.i("GameLife.ChattingCompatUI", "[onChattingFinishEnd] ...");
    a locala = this.lPI;
    if (locala != null) {
      locala.aNR();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    a locala = this.lPI;
    if ((locala != null) && (locala.dispatchKeyEvent(paramKeyEvent) == true)) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final a fIx()
  {
    return this.lPI;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = a.a.lPG;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((a.a.a)localObject).a((MMActivity)this))
    {
      this.lPI = ((a)localObject);
      localObject = this.lPI;
      if (localObject != null) {
        ((a)localObject).a((a.b)this);
      }
      localObject = this.lPI;
      if (localObject != null) {
        ((a)localObject).a((a.c)this);
      }
      localObject = this.lPI;
      if (localObject != null) {
        ((a)localObject).aNS();
      }
      super.onCreate(paramBundle);
      paramBundle = this.lPI;
      if (paramBundle != null) {
        paramBundle.aNT();
      }
      getWindow().setSoftInputMode(50);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a locala = this.lPI;
    if (locala != null) {
      locala.b((a.b)this);
    }
    locala = this.lPI;
    if (locala != null) {
      locala.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    a locala = this.lPI;
    if (locala != null) {
      locala.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a locala = this.lPI;
    if (locala != null) {
      locala.onResume();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
 * JD-Core Version:    0.7.0.1
 */