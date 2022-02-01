package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.a.f.b;

public final class b
  extends e
{
  public b(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(123461);
    super.a(parama);
    AppMethodBeat.o(123461);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(123463);
    super.a(paramb);
    AppMethodBeat.o(123463);
  }
  
  public final boolean aVX()
  {
    AppMethodBeat.i(123460);
    boolean bool = super.aVX();
    AppMethodBeat.o(123460);
    return bool;
  }
  
  public final ViewGroup byJ()
  {
    AppMethodBeat.i(123458);
    ViewGroup localViewGroup = super.byJ();
    AppMethodBeat.o(123458);
    return localViewGroup;
  }
  
  public final void fF(boolean paramBoolean)
  {
    AppMethodBeat.i(123462);
    super.fF(paramBoolean);
    AppMethodBeat.o(123462);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(123456);
    Activity localActivity = super.getActivity();
    AppMethodBeat.o(123456);
    return localActivity;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(123459);
    View localView = super.getContentView();
    AppMethodBeat.o(123459);
    return localView;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(123457);
    Intent localIntent = super.getIntent();
    AppMethodBeat.o(123457);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.b
 * JD-Core Version:    0.7.0.1
 */