package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.uz;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView qlB;
  protected TextView qlC;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void cxM()
  {
    AppMethodBeat.i(113902);
    this.qlC = ((TextView)cxL().findViewById(2131298037));
    this.qlB = ((TextView)cxL().findViewById(2131298220));
    AppMethodBeat.o(113902);
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(113903);
    if ((this.pQV.csQ().LeC != null) && (this.pQV.csQ().LeC.size() > 0))
    {
      abz localabz = (abz)this.pQV.csQ().LeC.get(0);
      if (this.oeJ != null) {
        this.oeJ.setText(localabz.title);
      }
      if (this.qlB != null)
      {
        if (TextUtils.isEmpty(localabz.pRY)) {
          break label138;
        }
        this.qlB.setText(localabz.pRY);
      }
      while (this.qlC != null) {
        if (!TextUtils.isEmpty(localabz.pRZ))
        {
          this.qlC.setText(localabz.pRZ);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.qlB.setVisibility(8);
        }
        else
        {
          this.qlC.setVisibility(8);
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