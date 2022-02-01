package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.vb;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView tHw;
  protected TextView tHx;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void cLo()
  {
    AppMethodBeat.i(113902);
    this.tHx = ((TextView)cLn().findViewById(a.d.tbh));
    this.tHw = ((TextView)cLn().findViewById(a.d.dve));
    AppMethodBeat.o(113902);
  }
  
  protected final void cLp()
  {
    AppMethodBeat.i(113903);
    if ((this.tmU.cGs().SfP != null) && (this.tmU.cGs().SfP.size() > 0))
    {
      acg localacg = (acg)this.tmU.cGs().SfP.get(0);
      if (this.rgv != null) {
        this.rgv.setText(localacg.title);
      }
      if (this.tHw != null)
      {
        if (TextUtils.isEmpty(localacg.tnY)) {
          break label138;
        }
        this.tHw.setText(localacg.tnY);
      }
      while (this.tHx != null) {
        if (!TextUtils.isEmpty(localacg.tnZ))
        {
          this.tHx.setText(localacg.tnZ);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.tHw.setVisibility(8);
        }
        else
        {
          this.tHx.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */