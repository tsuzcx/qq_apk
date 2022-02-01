package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private List<c> tmu;
  private boolean tmv;
  private boolean tmw;
  private TextView tmx;
  
  public b()
  {
    AppMethodBeat.i(65609);
    this.tmu = new LinkedList();
    this.tmv = false;
    this.tmw = false;
    AppMethodBeat.o(65609);
  }
  
  private void afv(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.tmx != null) && (!bt.isNullOrNil(paramString)))
    {
      if (!this.tmv) {
        this.tmx.setText(paramString);
      }
      this.tmx.setVisibility(0);
      this.tmv = true;
    }
    AppMethodBeat.o(65614);
  }
  
  public final void Mp(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.tmx != null) && (!bt.isNullOrNil(paramString)))
    {
      this.tmx.setText(paramString);
      this.tmx.setVisibility(0);
      this.tmv = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.tmx != null)
    {
      this.tmx.setVisibility(8);
      this.tmv = false;
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
    this.tmu.add(paramc);
    AppMethodBeat.o(65610);
  }
  
  public final boolean cMw()
  {
    AppMethodBeat.i(65612);
    this.tmw = false;
    this.tmv = false;
    int i = 0;
    if (i < this.tmu.size())
    {
      c localc = (c)this.tmu.get(i);
      int j = localc.cKY();
      if (j != 0)
      {
        localc.onError();
        afv(localc.FI(j));
        this.tmw = true;
      }
      for (;;)
      {
        i += 1;
        break;
        localc.restore();
      }
    }
    if ((!this.tmw) && (this.tmx != null))
    {
      this.tmx.setVisibility(8);
      this.tmv = false;
    }
    boolean bool = this.tmw;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean cMx()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.tmu.size())
    {
      if (((c)this.tmu.get(i)).cKY() != 0)
      {
        AppMethodBeat.o(65613);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(65613);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.tmu.clear();
    this.tmx = null;
    AppMethodBeat.o(65611);
  }
  
  public final void n(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.tmx = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */