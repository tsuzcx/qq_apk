package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private List<c> vxq;
  private boolean vxr;
  private boolean vxs;
  private TextView vxt;
  
  public b()
  {
    AppMethodBeat.i(65609);
    this.vxq = new LinkedList();
    this.vxr = false;
    this.vxs = false;
    AppMethodBeat.o(65609);
  }
  
  private void apc(String paramString)
  {
    AppMethodBeat.i(65614);
    if ((this.vxt != null) && (!bt.isNullOrNil(paramString)))
    {
      if (!this.vxr) {
        this.vxt.setText(paramString);
      }
      this.vxt.setVisibility(0);
      this.vxr = true;
    }
    AppMethodBeat.o(65614);
  }
  
  public final void TW(String paramString)
  {
    AppMethodBeat.i(65615);
    if ((this.vxt != null) && (!bt.isNullOrNil(paramString)))
    {
      this.vxt.setText(paramString);
      this.vxt.setVisibility(0);
      this.vxr = true;
      AppMethodBeat.o(65615);
      return;
    }
    if (this.vxt != null)
    {
      this.vxt.setVisibility(8);
      this.vxr = false;
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
    this.vxq.add(paramc);
    AppMethodBeat.o(65610);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(65611);
    this.vxq.clear();
    this.vxt = null;
    AppMethodBeat.o(65611);
  }
  
  public final boolean djp()
  {
    AppMethodBeat.i(65612);
    this.vxs = false;
    this.vxr = false;
    int i = 0;
    if (i < this.vxq.size())
    {
      c localc = (c)this.vxq.get(i);
      int j = localc.dhQ();
      if (j != 0)
      {
        localc.onError();
        apc(localc.IZ(j));
        this.vxs = true;
      }
      for (;;)
      {
        i += 1;
        break;
        localc.restore();
      }
    }
    if ((!this.vxs) && (this.vxt != null))
    {
      this.vxt.setVisibility(8);
      this.vxr = false;
    }
    boolean bool = this.vxs;
    AppMethodBeat.o(65612);
    return bool;
  }
  
  public final boolean djq()
  {
    AppMethodBeat.i(65613);
    int i = 0;
    while (i < this.vxq.size())
    {
      if (((c)this.vxq.get(i)).dhQ() != 0)
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
      this.vxt = paramTextView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */