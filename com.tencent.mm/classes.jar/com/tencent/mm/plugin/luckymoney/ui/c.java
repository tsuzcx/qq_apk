package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  List<d> KDi;
  boolean KDj;
  boolean KDk;
  TextView KDl;
  
  public c()
  {
    AppMethodBeat.i(65609);
    this.KDi = new LinkedList();
    this.KDj = false;
    this.KDk = false;
    AppMethodBeat.o(65609);
  }
  
  public final void A(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.KDl = paramTextView;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(65610);
    if (paramd == null)
    {
      AppMethodBeat.o(65610);
      return;
    }
    if (!this.KDi.contains(paramd)) {
      this.KDi.add(paramd);
    }
    AppMethodBeat.o(65610);
  }
  
  public final void aKL(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.KDl != null) && (!Util.isNullOrNil(paramString)))
    {
      if (!this.KDj) {
        this.KDl.setText(paramString);
      }
      this.KDl.setVisibility(0);
      this.KDj = true;
    }
    AppMethodBeat.o(65614);
  }
  
  public final void afy(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.KDl != null) && (!Util.isNullOrNil(paramString)))
    {
      this.KDl.setText(paramString);
      this.KDl.setVisibility(0);
      this.KDj = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.KDl != null)
    {
      this.KDl.setVisibility(8);
      this.KDj = false;
    }
    AppMethodBeat.o(65615);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.KDi.clear();
    this.KDl = null;
    AppMethodBeat.o(65611);
  }
  
  public final void fYr()
  {
    AppMethodBeat.i(284241);
    this.KDi.clear();
    AppMethodBeat.o(284241);
  }
  
  public final boolean fYs()
  {
    AppMethodBeat.i(65612);
    this.KDk = false;
    this.KDj = false;
    int i = 0;
    if (i < this.KDi.size())
    {
      d locald = (d)this.KDi.get(i);
      int j = locald.fWv();
      if (j != 0)
      {
        locald.atR();
        aKL(locald.ZF(j));
        this.KDk = true;
      }
      for (;;)
      {
        i += 1;
        break;
        locald.restore();
      }
    }
    if ((!this.KDk) && (this.KDl != null))
    {
      this.KDl.setVisibility(8);
      this.KDj = false;
    }
    boolean bool = this.KDk;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean fYt()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.KDi.size())
    {
      if (((d)this.KDi.get(i)).fWv() != 0)
      {
        AppMethodBeat.o(65613);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(65613);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.c
 * JD-Core Version:    0.7.0.1
 */