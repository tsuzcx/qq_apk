package com.tencent.mm.plugin.gamelife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.j.a.b;
import com.tencent.mm.j.a.c;
import com.tencent.mm.j.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingFragmentFinish;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActivityController;", "()V", "chattingCompat", "Lcom/tencent/mm/chatting/IChattingCompat;", "getChattingCompat", "()Lcom/tencent/mm/chatting/IChattingCompat;", "setChattingCompat", "(Lcom/tencent/mm/chatting/IChattingCompat;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onChattingFinishBegin", "", "onChattingFinishEnd", "onChattingUIEnter", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-gamelife_release"})
public abstract class GameLifeChattingCompatUI
  extends MMActivity
  implements a.b, a.c, a.d
{
  public static final a uyC = new a((byte)0);
  private HashMap _$_findViewCache;
  a sIk;
  
  public final void ZB()
  {
    ad.i("GameLife.ChattingCompatUI", "[onChattingUIEnter] ...");
  }
  
  public boolean ZC()
  {
    ad.i("GameLife.ChattingCompatUI", "[onChattingUIExit] ...");
    return true;
  }
  
  public final void ZD()
  {
    ad.i("GameLife.ChattingCompatUI", "[onChattingFinishBegin] ...");
  }
  
  public final void ZE()
  {
    ad.i("GameLife.ChattingCompatUI", "[onChattingFinishEnd] ...");
    a locala = this.sIk;
    if (locala != null) {
      locala.Zx();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    a locala = this.sIk;
    if ((locala != null) && (locala.dispatchKeyEvent(paramKeyEvent) == true)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = a.a.fVe;
    if (localObject != null) {}
    for (localObject = ((a.a.a)localObject).a((MMActivity)this);; localObject = null)
    {
      this.sIk = ((a)localObject);
      localObject = this.sIk;
      if (localObject != null) {
        ((a)localObject).a((a.b)this);
      }
      localObject = this.sIk;
      if (localObject != null) {
        ((a)localObject).a((a.c)this);
      }
      localObject = this.sIk;
      if (localObject != null) {
        ((a)localObject).Zy();
      }
      super.onCreate(paramBundle);
      paramBundle = this.sIk;
      if (paramBundle != null) {
        paramBundle.Zz();
      }
      getWindow().setSoftInputMode(50);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a locala = this.sIk;
    if (locala != null) {
      locala.b((a.b)this);
    }
    locala = this.sIk;
    if (locala != null) {
      locala.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    a locala = this.sIk;
    if (locala != null) {
      locala.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a locala = this.sIk;
    if (locala != null) {
      locala.onResume();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
 * JD-Core Version:    0.7.0.1
 */