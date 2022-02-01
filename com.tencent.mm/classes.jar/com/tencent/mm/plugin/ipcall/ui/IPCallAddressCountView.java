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
  private TextView DUp;
  private View fyN;
  
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
    inflate(getContext(), R.i.ehJ, this);
    this.fyN = findViewById(R.h.dAF);
    this.DUp = ((TextView)findViewById(R.h.dAE));
    AppMethodBeat.o(25663);
  }
  
  public void setAddressCount(int paramInt)
  {
    AppMethodBeat.i(25664);
    this.DUp.setText(getContext().getResources().getQuantityString(R.j.emi, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(25664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressCountView
 * JD-Core Version:    0.7.0.1
 */