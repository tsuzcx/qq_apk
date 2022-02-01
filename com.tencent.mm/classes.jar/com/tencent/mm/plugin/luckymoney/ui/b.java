package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private List<c> uuN;
  private boolean uuO;
  private boolean uuP;
  private TextView uuQ;
  
  public b()
  {
    AppMethodBeat.i(65609);
    this.uuN = new LinkedList();
    this.uuO = false;
    this.uuP = false;
    AppMethodBeat.o(65609);
  }
  
  private void akp(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.uuQ != null) && (!bs.isNullOrNil(paramString)))
    {
      if (!this.uuO) {
        this.uuQ.setText(paramString);
      }
      this.uuQ.setVisibility(0);
      this.uuO = true;
    }
    AppMethodBeat.o(65614);
  }
  
  public final void Qr(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.uuQ != null) && (!bs.isNullOrNil(paramString)))
    {
      this.uuQ.setText(paramString);
      this.uuQ.setVisibility(0);
      this.uuO = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.uuQ != null)
    {
      this.uuQ.setVisibility(8);
      this.uuO = false;
    }
    AppMethodBeat.o(65615);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(65610);
    if (paramc == null)
    {
      AppMethodBeat.o(65610);
      return;
    }
    this.uuN.add(paramc);
    AppMethodBeat.o(65610);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.uuN.clear();
    this.uuQ = null;
    AppMethodBeat.o(65611);
  }
  
  public final boolean dac()
  {
    AppMethodBeat.i(65612);
    this.uuP = false;
    this.uuO = false;
    int i = 0;
    if (i < this.uuN.size())
    {
      c localc = (c)this.uuN.get(i);
      int j = localc.cYE();
      if (j != 0)
      {
        localc.onError();
        akp(localc.HD(j));
        this.uuP = true;
      }
      for (;;)
      {
        i += 1;
        break;
        localc.restore();
      }
    }
    if ((!this.uuP) && (this.uuQ != null))
    {
      this.uuQ.setVisibility(8);
      this.uuO = false;
    }
    boolean bool = this.uuP;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean dad()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.uuN.size())
    {
      if (((c)this.uuN.get(i)).cYE() != 0)
      {
        AppMethodBeat.o(65613);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(65613);
    return false;
  }
  
  public final void n(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.uuQ = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */