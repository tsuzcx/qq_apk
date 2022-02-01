package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.b.g;
import androidx.core.g.f;
import androidx.core.g.f.a;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class ComponentActivity
  extends HellActivity
  implements f.a, l
{
  private g<Class<? extends ComponentActivity.a>, ComponentActivity.a> mExtraDataMap;
  private m mLifecycleRegistry;
  
  public ComponentActivity()
  {
    AppMethodBeat.i(250233);
    this.mExtraDataMap = new g();
    this.mLifecycleRegistry = new m(this);
    AppMethodBeat.o(250233);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250242);
    View localView = getWindow().getDecorView();
    if ((localView != null) && (f.a(localView, paramKeyEvent)))
    {
      AppMethodBeat.o(250242);
      return true;
    }
    boolean bool = f.a(this, localView, this, paramKeyEvent);
    AppMethodBeat.o(250242);
    return bool;
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250240);
    View localView = getWindow().getDecorView();
    if ((localView != null) && (f.a(localView, paramKeyEvent)))
    {
      AppMethodBeat.o(250240);
      return true;
    }
    boolean bool = super.dispatchKeyShortcutEvent(paramKeyEvent);
    AppMethodBeat.o(250240);
    return bool;
  }
  
  @Deprecated
  public <T extends ComponentActivity.a> T getExtraData(Class<T> paramClass)
  {
    AppMethodBeat.i(250237);
    paramClass = (ComponentActivity.a)this.mExtraDataMap.get(paramClass);
    AppMethodBeat.o(250237);
    return paramClass;
  }
  
  public h getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @SuppressLint({"RestrictedApi"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250235);
    super.onCreate(paramBundle);
    v.h(this);
    AppMethodBeat.o(250235);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(250236);
    this.mLifecycleRegistry.c(h.b.ZQ);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(250236);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Deprecated
  public void putExtraData(ComponentActivity.a parama)
  {
    AppMethodBeat.i(250234);
    this.mExtraDataMap.put(parama.getClass(), parama);
    AppMethodBeat.o(250234);
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250238);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(250238);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.app.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */