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
  private final f.a hf;
  private d mDelegate;
  
  public e(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    AppMethodBeat.i(238342);
    this.hf = new f.a()
    {
      public final boolean superDispatchKeyEvent(KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(238341);
        boolean bool = e.this.superDispatchKeyEvent(paramAnonymousKeyEvent);
        AppMethodBeat.o(238341);
        return bool;
      }
    };
    getDelegate().onCreate(null);
    getDelegate().aK();
    AppMethodBeat.o(238342);
  }
  
  private d getDelegate()
  {
    AppMethodBeat.i(238356);
    if (this.mDelegate == null) {
      this.mDelegate = d.a(this, this);
    }
    d locald = this.mDelegate;
    AppMethodBeat.o(238356);
    return locald;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238351);
    getDelegate().addContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(238351);
  }
  
  public final boolean bb()
  {
    AppMethodBeat.i(238353);
    boolean bool = getDelegate().P(1);
    AppMethodBeat.o(238353);
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238362);
    View localView = getWindow().getDecorView();
    boolean bool = f.a(this.hf, localView, this, paramKeyEvent);
    AppMethodBeat.o(238362);
    return bool;
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    AppMethodBeat.i(238347);
    View localView = getDelegate().findViewById(paramInt);
    AppMethodBeat.o(238347);
    return localView;
  }
  
  public void invalidateOptionsMenu()
  {
    AppMethodBeat.i(238355);
    getDelegate().invalidateOptionsMenu();
    AppMethodBeat.o(238355);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238343);
    getDelegate().aJ();
    super.onCreate(paramBundle);
    getDelegate().onCreate(paramBundle);
    AppMethodBeat.o(238343);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(238352);
    super.onStop();
    getDelegate().onStop();
    AppMethodBeat.o(238352);
  }
  
  public void onSupportActionModeFinished(b paramb) {}
  
  public void onSupportActionModeStarted(b paramb) {}
  
  public b onWindowStartingSupportActionMode(b.a parama)
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(238344);
    getDelegate().setContentView(paramInt);
    AppMethodBeat.o(238344);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(238345);
    getDelegate().setContentView(paramView);
    AppMethodBeat.o(238345);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238346);
    getDelegate().setContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(238346);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(238349);
    super.setTitle(paramInt);
    getDelegate().setTitle(getContext().getString(paramInt));
    AppMethodBeat.o(238349);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238348);
    super.setTitle(paramCharSequence);
    getDelegate().setTitle(paramCharSequence);
    AppMethodBeat.o(238348);
  }
  
  final boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238361);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(238361);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.e
 * JD-Core Version:    0.7.0.1
 */