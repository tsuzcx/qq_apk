package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.ui.base.i;

public final class b
  extends i
{
  TextView flb;
  private Button hZu;
  private View view;
  
  public b(Context paramContext)
  {
    super(paramContext, R.m.noBgDialog);
    this.view = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.i.bottle_dialog, null);
    setContentView(this.view, new ViewGroup.LayoutParams(-2, -2));
    this.flb = ((TextView)this.view.findViewById(R.h.bottle_dialog_text));
    this.hZu = ((Button)this.view.findViewById(R.h.bottle_dialog_button));
    this.hZu.setOnClickListener(new b.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.b
 * JD-Core Version:    0.7.0.1
 */