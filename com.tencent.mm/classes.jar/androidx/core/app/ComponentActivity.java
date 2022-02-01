package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.b.g;
import androidx.core.g.f;
import androidx.core.g.f.a;
import androidx.lifecycle.ab;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class ComponentActivity
  extends HellActivity
  implements f.a, q
{
  private g<Class<? extends ComponentActivity.a>, ComponentActivity.a> mExtraDataMap;
  private s mLifecycleRegistry;
  
  public ComponentActivity()
  {
    AppMethodBeat.i(196380);
    this.mExtraDataMap = new g();
    this.mLifecycleRegistry = new s(this);
    AppMethodBeat.o(196380);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196476);
    View localView = getWindow().getDecorView();
    if ((localView != null) && (f.a(localView, paramKeyEvent)))
    {
      AppMethodBeat.o(196476);
      return true;
    }
    boolean bool = f.a(this, localView, this, paramKeyEvent);
    AppMethodBeat.o(196476);
    return bool;
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196462);
    View localView = getWindow().getDecorView();
    if ((localView != null) && (f.a(localView, paramKeyEvent)))
    {
      AppMethodBeat.o(196462);
      return true;
    }
    boolean bool = super.dispatchKeyShortcutEvent(paramKeyEvent);
    AppMethodBeat.o(196462);
    return bool;
  }
  
  @Deprecated
  public <T extends ComponentActivity.a> T getExtraData(Class<T> paramClass)
  {
    AppMethodBeat.i(196434);
    paramClass = (ComponentActivity.a)this.mExtraDataMap.get(paramClass);
    AppMethodBeat.o(196434);
    return paramClass;
  }
  
  public j getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196418);
    super.onCreate(paramBundle);
    ab.j(this);
    AppMethodBeat.o(196418);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(196425);
    this.mLifecycleRegistry.e(j.b.bHi);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(196425);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Deprecated
  public void putExtraData(ComponentActivity.a parama)
  {
    AppMethodBeat.i(196402);
    this.mExtraDataMap.put(parama.getClass(), parama);
    AppMethodBeat.o(196402);
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196450);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(196450);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.app.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */