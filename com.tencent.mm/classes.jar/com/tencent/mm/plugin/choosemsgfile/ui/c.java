package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.a.f.b;
import java.util.Objects;

public final class c
  extends e
{
  public c(Activity paramActivity)
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
  
  public final boolean aOg()
  {
    AppMethodBeat.i(123460);
    boolean bool = super.aOg();
    AppMethodBeat.o(123460);
    return bool;
  }
  
  public final ViewGroup cuR()
  {
    AppMethodBeat.i(123458);
    ViewGroup localViewGroup = super.cuR();
    AppMethodBeat.o(123458);
    return localViewGroup;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(123456);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
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
  
  public final void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(123462);
    super.hS(paramBoolean);
    AppMethodBeat.o(123462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.c
 * JD-Core Version:    0.7.0.1
 */