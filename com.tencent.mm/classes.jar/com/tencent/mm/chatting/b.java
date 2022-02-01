package com.tencent.mm.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatting/ReadyChattingUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingFragmentFinish;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "chattingCompat", "Lcom/tencent/mm/chatting/IChattingCompat;", "getChattingCompat", "()Lcom/tencent/mm/chatting/IChattingCompat;", "setChattingCompat", "(Lcom/tencent/mm/chatting/IChattingCompat;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChattingFinishBegin", "onChattingFinishEnd", "onChattingUIEnter", "onChattingUIExit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "Companion", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
  implements a.b, a.d
{
  public static final b.a lPH;
  public a lPI;
  
  static
  {
    AppMethodBeat.i(231980);
    lPH = new b.a((byte)0);
    AppMethodBeat.o(231980);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(231977);
    AppMethodBeat.o(231977);
  }
  
  public final void aNV()
  {
    AppMethodBeat.i(232023);
    Log.i("MicroMsg.ReadyChattingCompatUI", "[onChattingUIEnter] ...");
    AppMethodBeat.o(232023);
  }
  
  public final boolean aNW()
  {
    AppMethodBeat.i(232024);
    Log.i("MicroMsg.ReadyChattingCompatUI", "[onChattingUIExit] ...");
    AppMethodBeat.o(232024);
    return true;
  }
  
  public final void aNX() {}
  
  public final void aNY()
  {
    AppMethodBeat.i(232016);
    a locala = this.lPI;
    if (locala != null) {
      locala.aNR();
    }
    AppMethodBeat.o(232016);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(231998);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a locala = this.lPI;
    if (locala != null) {
      locala.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(231998);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(231987);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getWindow();
      if (paramBundle != null) {
        paramBundle.setSoftInputMode(50);
      }
    }
    paramBundle = this.lPI;
    if (paramBundle != null) {
      paramBundle.aNT();
    }
    AppMethodBeat.o(231987);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(231985);
    super.onCreateBefore(paramBundle);
    paramBundle = a.a.lPG;
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.a((MMActivity)getActivity()))
    {
      this.lPI = paramBundle;
      paramBundle = this.lPI;
      if (paramBundle != null) {
        paramBundle.a((a.b)this);
      }
      paramBundle = this.lPI;
      if (paramBundle != null) {
        paramBundle.aNS();
      }
      paramBundle = this.lPI;
      if (paramBundle != null) {
        paramBundle.i(Boolean.TRUE);
      }
      AppMethodBeat.o(231985);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232007);
    super.onDestroy();
    a locala = this.lPI;
    if (locala != null) {
      locala.b((a.b)this);
    }
    locala = this.lPI;
    if (locala != null) {
      locala.onDestroy();
    }
    AppMethodBeat.o(232007);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(232020);
    s.u(paramKeyEvent, "event");
    a locala = this.lPI;
    if ((locala != null) && (locala.dispatchKeyEvent(paramKeyEvent) == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(232020);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(232020);
    return bool;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(232022);
    s.u(paramKeyEvent, "event");
    a locala = this.lPI;
    if ((locala != null) && (locala.dispatchKeyEvent(paramKeyEvent) == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(232022);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(232022);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(231995);
    super.onPause();
    a locala = this.lPI;
    if (locala != null) {
      locala.onPause();
    }
    AppMethodBeat.o(231995);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(232002);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    a locala = this.lPI;
    if (locala != null) {
      locala.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(232002);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(231989);
    super.onResume();
    a locala = this.lPI;
    if (locala != null) {
      locala.onResume();
    }
    AppMethodBeat.o(231989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.chatting.b
 * JD-Core Version:    0.7.0.1
 */