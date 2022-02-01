package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class KeyStepBaseActivity
  extends HellActivity
{
  private TextView mPa;
  
  static
  {
    if (!KeyStepBaseActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  protected abstract int getLayoutId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492959);
    paramBundle = (FrameLayout)findViewById(2131299180);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    int i = getLayoutId();
    assert (i != 0);
    localLayoutInflater.inflate(i, paramBundle);
    this.mPa = ((TextView)findViewById(2131296447));
    findViewById(2131296449).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221271);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepBaseActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        KeyStepBaseActivity.this.finish();
        a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepBaseActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221271);
      }
    });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void setTitle(String paramString)
  {
    this.mPa.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity
 * JD-Core Version:    0.7.0.1
 */