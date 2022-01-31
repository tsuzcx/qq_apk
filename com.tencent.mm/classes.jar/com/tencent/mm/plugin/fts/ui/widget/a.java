package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends LinearLayout
{
  private View nbr;
  private FTSEditTextView nbs;
  public View nbt;
  private boolean nbu;
  private a.b nbv;
  private a.a nbw;
  
  public a(Context paramContext)
  {
    this(paramContext, false);
    AppMethodBeat.i(62158);
    AppMethodBeat.o(62158);
  }
  
  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(152189);
    this.nbu = paramBoolean;
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130969641, this, true);
    this.nbr = findViewById(2131820992);
    this.nbr.setOnClickListener(new a.1(this));
    this.nbs = ((FTSEditTextView)findViewById(2131824308));
    if (this.nbu)
    {
      this.nbt = findViewById(2131824309);
      this.nbt.setVisibility(0);
      this.nbt.setOnClickListener(new a.2(this));
    }
    AppMethodBeat.o(152189);
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.nbs;
  }
  
  public final void setImageSearchListener(a.a parama)
  {
    this.nbw = parama;
  }
  
  public final void setSearchViewListener(a.b paramb)
  {
    this.nbv = paramb;
  }
  
  public static abstract interface c
    extends Comparable
  {
    public abstract String getTagName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */