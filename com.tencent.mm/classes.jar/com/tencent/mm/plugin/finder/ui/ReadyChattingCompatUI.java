package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
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
import com.tencent.mm.j.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingFragmentFinish;", "()V", "chattingCompat", "Lcom/tencent/mm/chatting/IChattingCompat;", "getChattingCompat", "()Lcom/tencent/mm/chatting/IChattingCompat;", "setChattingCompat", "(Lcom/tencent/mm/chatting/IChattingCompat;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChattingFinishBegin", "onChattingFinishEnd", "onChattingUIEnter", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "Companion", "plugin-finder_release"})
public abstract class ReadyChattingCompatUI
  extends MMFinderUI
  implements a.b, a.d
{
  public static final a vQc = new a((byte)0);
  private HashMap _$_findViewCache;
  public a vQb;
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
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
  
  public void a(Bundle paramBundle, int paramInt)
  {
    getWindow().setSoftInputMode(50);
  }
  
  public final void anA()
  {
    a locala = this.vQb;
    if (locala != null) {
      locala.ant();
    }
  }
  
  public void anv() {}
  
  public void anx()
  {
    Log.i("MicroMsg.ReadyChattingCompatUI", "[onChattingUIEnter] ...");
  }
  
  public boolean any()
  {
    Log.i("MicroMsg.ReadyChattingCompatUI", "[onChattingUIExit] ...");
    return true;
  }
  
  public final void anz() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    a locala = this.vQb;
    if ((locala != null) && (locala.dispatchKeyEvent(paramKeyEvent) == true)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a locala = this.vQb;
    if (locala != null) {
      locala.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = a.a.gCq;
    if (localObject != null) {}
    for (localObject = ((a.a.a)localObject).a((MMActivity)this);; localObject = null)
    {
      this.vQb = ((a)localObject);
      localObject = this.vQb;
      if (localObject != null) {
        ((a)localObject).a((a.b)this);
      }
      localObject = this.vQb;
      if (localObject != null) {
        ((a)localObject).anu();
      }
      super.onCreate(paramBundle);
      a(paramBundle, 0);
      paramBundle = this.vQb;
      if (paramBundle != null) {
        paramBundle.anv();
      }
      anv();
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a locala = this.vQb;
    if (locala != null) {
      locala.b((a.b)this);
    }
    locala = this.vQb;
    if (locala != null) {
      locala.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    a locala = this.vQb;
    if (locala != null) {
      locala.onPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    a locala = this.vQb;
    if (locala != null) {
      locala.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a locala = this.vQb;
    if (locala != null) {
      locala.onResume();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
 * JD-Core Version:    0.7.0.1
 */