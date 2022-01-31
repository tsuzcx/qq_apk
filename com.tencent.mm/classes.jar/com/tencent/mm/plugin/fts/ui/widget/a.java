package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public final class a
  extends LinearLayout
{
  private View jpA;
  private FTSEditTextView kFh;
  private a.a kFi;
  
  public a(Context paramContext)
  {
    super(paramContext);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(n.e.fts_actionbar_searchview, this, true);
    this.jpA = findViewById(n.d.ab_back_container);
    this.jpA.setOnClickListener(new a.1(this));
    this.kFh = ((FTSEditTextView)findViewById(n.d.fts_edittext));
  }
  
  public final FTSEditTextView getFtsEditText()
  {
    return this.kFh;
  }
  
  public final void setSearchViewListener(a.a parama)
  {
    this.kFi = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */