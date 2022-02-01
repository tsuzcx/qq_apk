package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.core.g.f;
import androidx.core.g.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends Dialog
  implements c
{
  private final f.a ia;
  private d mDelegate;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    AppMethodBeat.i(200509);
    this.ia = new f.a()
    {
      public final boolean superDispatchKeyEvent(KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(200605);
        boolean bool = e.this.superDispatchKeyEvent(paramAnonymousKeyEvent);
        AppMethodBeat.o(200605);
        return bool;
      }
    };
    getDelegate().onCreate(null);
    getDelegate().bD();
    AppMethodBeat.o(200509);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200613);
    getDelegate().addContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(200613);
  }
  
  public final boolean bU()
  {
    AppMethodBeat.i(200636);
    boolean bool = getDelegate().N(1);
    AppMethodBeat.o(200636);
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200727);
    View localView = getWindow().getDecorView();
    boolean bool = f.a(this.ia, localView, this, paramKeyEvent);
    AppMethodBeat.o(200727);
    return bool;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(200574);
    View localView = getDelegate().findViewById(paramInt);
    AppMethodBeat.o(200574);
    return localView;
  }
  
  public final d getDelegate()
  {
    AppMethodBeat.i(200659);
    if (this.mDelegate == null) {
      this.mDelegate = d.a(this, this);
    }
    d locald = this.mDelegate;
    AppMethodBeat.o(200659);
    return locald;
  }
  
  public void invalidateOptionsMenu()
  {
    AppMethodBeat.i(200646);
    getDelegate().invalidateOptionsMenu();
    AppMethodBeat.o(200646);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200524);
    getDelegate().bC();
    super.onCreate(paramBundle);
    getDelegate().onCreate(paramBundle);
    AppMethodBeat.o(200524);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(200624);
    super.onStop();
    getDelegate().onStop();
    AppMethodBeat.o(200624);
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(200537);
    getDelegate().setContentView(paramInt);
    AppMethodBeat.o(200537);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(200548);
    getDelegate().setContentView(paramView);
    AppMethodBeat.o(200548);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200560);
    getDelegate().setContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(200560);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(200600);
    super.setTitle(paramInt);
    getDelegate().setTitle(getContext().getString(paramInt));
    AppMethodBeat.o(200600);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200588);
    super.setTitle(paramCharSequence);
    getDelegate().setTitle(paramCharSequence);
    AppMethodBeat.o(200588);
  }
  
  final boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200716);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(200716);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.e
 * JD-Core Version:    0.7.0.1
 */