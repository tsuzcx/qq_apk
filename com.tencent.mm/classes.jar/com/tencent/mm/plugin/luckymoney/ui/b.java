package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private List<c> vJu;
  private boolean vJv;
  private boolean vJw;
  private TextView vJx;
  
  public b()
  {
    AppMethodBeat.i(65609);
    this.vJu = new LinkedList();
    this.vJv = false;
    this.vJw = false;
    AppMethodBeat.o(65609);
  }
  
  private void aqh(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.vJx != null) && (!bu.isNullOrNil(paramString)))
    {
      if (!this.vJv) {
        this.vJx.setText(paramString);
      }
      this.vJx.setVisibility(0);
      this.vJv = true;
    }
    AppMethodBeat.o(65614);
  }
  
  public final void UG(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.vJx != null) && (!bu.isNullOrNil(paramString)))
    {
      this.vJx.setText(paramString);
      this.vJx.setVisibility(0);
      this.vJv = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.vJx != null)
    {
      this.vJx.setVisibility(8);
      this.vJv = false;
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
    this.vJu.add(paramc);
    AppMethodBeat.o(65610);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.vJu.clear();
    this.vJx = null;
    AppMethodBeat.o(65611);
  }
  
  public final boolean dmo()
  {
    AppMethodBeat.i(65612);
    this.vJw = false;
    this.vJv = false;
    int i = 0;
    if (i < this.vJu.size())
    {
      c localc = (c)this.vJu.get(i);
      int j = localc.dkP();
      if (j != 0)
      {
        localc.onError();
        aqh(localc.Jy(j));
        this.vJw = true;
      }
      for (;;)
      {
        i += 1;
        break;
        localc.restore();
      }
    }
    if ((!this.vJw) && (this.vJx != null))
    {
      this.vJx.setVisibility(8);
      this.vJv = false;
    }
    boolean bool = this.vJw;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean dmp()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.vJu.size())
    {
      if (((c)this.vJu.get(i)).dkP() != 0)
      {
        AppMethodBeat.o(65613);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(65613);
    return false;
  }
  
  public final void m(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.vJx = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */