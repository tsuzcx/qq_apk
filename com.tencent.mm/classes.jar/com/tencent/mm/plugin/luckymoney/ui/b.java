package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private List<c> otK;
  private boolean otL;
  private boolean otM;
  private TextView otN;
  
  public b()
  {
    AppMethodBeat.i(42732);
    this.otK = new LinkedList();
    this.otL = false;
    this.otM = false;
    AppMethodBeat.o(42732);
  }
  
  private void Sx(String paramString)
  {
    AppMethodBeat.i(42737);
    if ((this.otN != null) && (!bo.isNullOrNil(paramString)))
    {
      if (!this.otL) {
        this.otN.setText(paramString);
      }
      this.otN.setVisibility(0);
      this.otL = true;
    }
    AppMethodBeat.o(42737);
  }
  
  public final void EC(String paramString)
  {
    AppMethodBeat.i(42738);
    if ((this.otN != null) && (!bo.isNullOrNil(paramString)))
    {
      this.otN.setText(paramString);
      this.otN.setVisibility(0);
      this.otL = true;
      AppMethodBeat.o(42738);
      return;
    }
    if (this.otN != null)
    {
      this.otN.setVisibility(8);
      this.otL = false;
    }
    AppMethodBeat.o(42738);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(42733);
    if (paramc == null)
    {
      AppMethodBeat.o(42733);
      return;
    }
    this.otK.add(paramc);
    AppMethodBeat.o(42733);
  }
  
  public final boolean bNY()
  {
    AppMethodBeat.i(42735);
    this.otM = false;
    this.otL = false;
    int i = 0;
    if (i < this.otK.size())
    {
      c localc = (c)this.otK.get(i);
      int j = localc.bMP();
      if (j != 0)
      {
        localc.onError();
        Sx(localc.yf(j));
        this.otM = true;
      }
      for (;;)
      {
        i += 1;
        break;
        localc.restore();
      }
    }
    if ((!this.otM) && (this.otN != null))
    {
      this.otN.setVisibility(8);
      this.otL = false;
    }
    boolean bool = this.otM;
    AppMethodBeat.o(42735);
    return bool;
  }
  
  public final boolean bNZ()
  {
    AppMethodBeat.i(42736);
    int i = 0;
    while (i < this.otK.size())
    {
      if (((c)this.otK.get(i)).bMP() != 0)
      {
        AppMethodBeat.o(42736);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(42736);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(42734);
    this.otK.clear();
    this.otN = null;
    AppMethodBeat.o(42734);
  }
  
  public final void i(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.otN = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */