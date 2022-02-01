package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;

public class IPCallAddressCountView
  extends FrameLayout
{
  private TextView JLz;
  private View hDw;
  
  private IPCallAddressCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(25661);
    init();
    AppMethodBeat.o(25661);
  }
  
  public IPCallAddressCountView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(25662);
    setAddressCount(paramInt);
    AppMethodBeat.o(25662);
  }
  
  public IPCallAddressCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25660);
    init();
    AppMethodBeat.o(25660);
  }
  
  private void init()
  {
    AppMethodBeat.i(25663);
    inflate(getContext(), R.i.gkE, this);
    this.hDw = findViewById(R.h.fBH);
    this.JLz = ((TextView)findViewById(R.h.fBG));
    AppMethodBeat.o(25663);
  }
  
  public void setAddressCount(int paramInt)
  {
    AppMethodBeat.i(25664);
    this.JLz.setText(getContext().getResources().getQuantityString(R.j.gpl, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(25664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressCountView
 * JD-Core Version:    0.7.0.1
 */