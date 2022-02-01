package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  private boolean zeA;
  private boolean zeB;
  private TextView zeC;
  private List<d> zez;
  
  public c()
  {
    AppMethodBeat.i(65609);
    this.zez = new LinkedList();
    this.zeA = false;
    this.zeB = false;
    AppMethodBeat.o(65609);
  }
  
  private void aDD(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.zeC != null) && (!Util.isNullOrNil(paramString)))
    {
      if (!this.zeA) {
        this.zeC.setText(paramString);
      }
      this.zeC.setVisibility(0);
      this.zeA = true;
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
    if (!this.zez.contains(paramd)) {
      this.zez.add(paramd);
    }
    AppMethodBeat.o(65610);
  }
  
  public final void aeu(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.zeC != null) && (!Util.isNullOrNil(paramString)))
    {
      this.zeC.setText(paramString);
      this.zeC.setVisibility(0);
      this.zeA = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.zeC != null)
    {
      this.zeC.setVisibility(8);
      this.zeA = false;
    }
    AppMethodBeat.o(65615);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(213410);
    if (paramd == null)
    {
      AppMethodBeat.o(213410);
      return;
    }
    int i = 0;
    while (i < this.zez.size())
    {
      if (((d)this.zez.get(i)).getInputViewId() == paramd.getInputViewId()) {
        this.zez.remove(i);
      }
      i += 1;
    }
    AppMethodBeat.o(213410);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.zez.clear();
    this.zeC = null;
    AppMethodBeat.o(65611);
  }
  
  public final boolean egj()
  {
    AppMethodBeat.i(65612);
    this.zeB = false;
    this.zeA = false;
    int i = 0;
    if (i < this.zez.size())
    {
      d locald = (d)this.zez.get(i);
      int j = locald.eeH();
      if (j != 0)
      {
        locald.onError();
        aDD(locald.PA(j));
        this.zeB = true;
      }
      for (;;)
      {
        i += 1;
        break;
        locald.restore();
      }
    }
    if ((!this.zeB) && (this.zeC != null))
    {
      this.zeC.setVisibility(8);
      this.zeA = false;
    }
    boolean bool = this.zeB;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean egk()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.zez.size())
    {
      if (((d)this.zez.get(i)).eeH() != 0)
      {
        AppMethodBeat.o(65613);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(65613);
    return false;
  }
  
  public final void t(TextView paramTextView)
  {
    if (paramTextView != null) {
      this.zeC = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.c
 * JD-Core Version:    0.7.0.1
 */