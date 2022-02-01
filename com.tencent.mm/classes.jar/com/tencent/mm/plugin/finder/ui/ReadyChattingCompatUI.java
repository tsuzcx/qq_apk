package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.a;
import com.tencent.mm.chatting.a.a;
import com.tencent.mm.chatting.a.a.a;
import com.tencent.mm.chatting.a.b;
import com.tencent.mm.chatting.a.d;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingFragmentFinish;", "()V", "chattingCompat", "Lcom/tencent/mm/chatting/IChattingCompat;", "getChattingCompat", "()Lcom/tencent/mm/chatting/IChattingCompat;", "setChattingCompat", "(Lcom/tencent/mm/chatting/IChattingCompat;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChattingFinishBegin", "onChattingFinishEnd", "onChattingUIEnter", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ReadyChattingCompatUI
  extends MMFinderUI
  implements a.b, a.d
{
  public static final ReadyChattingCompatUI.a FVM = new ReadyChattingCompatUI.a((byte)0);
  private a lPI;
  
  public void _$_clearFindViewByIdCache() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    a locala = this.lPI;
    if ((locala != null) && (locala.dispatchKeyEvent(paramKeyEvent) == true)) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a locala = this.lPI;
    if (locala != null) {
      locala.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
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
        ((a)localObject).aNS();
      }
      super.onCreate(paramBundle);
      getWindow().setSoftInputMode(50);
      paramBundle = this.lPI;
      if (paramBundle != null) {
        paramBundle.aNT();
      }
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
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    a locala = this.lPI;
    if (locala != null) {
      locala.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
 * JD-Core Version:    0.7.0.1
 */