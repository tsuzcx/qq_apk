package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private List<d> EJC;
  boolean EJD;
  private boolean EJE;
  private TextView EJF;
  
  public c()
  {
    AppMethodBeat.i(65609);
    this.EJC = new LinkedList();
    this.EJD = false;
    this.EJE = false;
    AppMethodBeat.o(65609);
  }
  
  private void aNN(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.EJF != null) && (!Util.isNullOrNil(paramString)))
    {
      if (!this.EJD) {
        this.EJF.setText(paramString);
      }
      this.EJF.setVisibility(0);
      this.EJD = true;
    }
    AppMethodBeat.o(65614);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(65610);
    if (paramd == null)
    {
      AppMethodBeat.o(65610);
      return;
    }
    if (!this.EJC.contains(paramd)) {
      this.EJC.add(paramd);
    }
    AppMethodBeat.o(65610);
  }
  
  public final void amo(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.EJF != null) && (!Util.isNullOrNil(paramString)))
    {
      this.EJF.setText(paramString);
      this.EJF.setVisibility(0);
      this.EJD = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.EJF != null)
    {
      this.EJF.setVisibility(8);
      this.EJD = false;
    }
    AppMethodBeat.o(65615);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(278029);
    if (paramd == null)
    {
      AppMethodBeat.o(278029);
      return;
    }
    int i = 0;
    while (i < this.EJC.size())
    {
      if (((d)this.EJC.get(i)).getInputViewId() == paramd.getInputViewId()) {
        this.EJC.remove(i);
      }
      i += 1;
    }
    AppMethodBeat.o(278029);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.EJC.clear();
    this.EJF = null;
    AppMethodBeat.o(65611);
  }
  
  public final boolean ePM()
  {
    AppMethodBeat.i(65612);
    this.EJE = false;
    this.EJD = false;
    int i = 0;
    if (i < this.EJC.size())
    {
      d locald = (d)this.EJC.get(i);
      int j = locald.eOc();
      if (j != 0)
      {
        locald.onError();
        aNN(locald.VJ(j));
        this.EJE = true;
      }
      for (;;)
      {
        i += 1;
        break;
        locald.restore();
      }
    }
    if ((!this.EJE) && (this.EJF != null))
    {
      this.EJF.setVisibility(8);
      this.EJD = false;
    }
    boolean bool = this.EJE;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean ePN()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.EJC.size())
    {
      if (((d)this.EJC.get(i)).eOc() != 0)
      {
        AppMethodBeat.o(65613);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(65613);
    return false;
  }
  
  public final void z(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.EJF = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.c
 * JD-Core Version:    0.7.0.1
 */