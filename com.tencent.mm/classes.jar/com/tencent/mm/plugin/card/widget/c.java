package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView kCM;
  protected TextView kCN;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bfH()
  {
    AppMethodBeat.i(88974);
    this.kCN = ((TextView)bfG().findViewById(2131822397));
    this.kCM = ((TextView)bfG().findViewById(2131822396));
    AppMethodBeat.o(88974);
  }
  
  protected final void bfI()
  {
    AppMethodBeat.i(88975);
    if ((this.klk.bbd().wFZ != null) && (this.klk.bbd().wFZ.size() > 0))
    {
      uo localuo = (uo)this.klk.bbd().wFZ.get(0);
      if (this.iVS != null) {
        this.iVS.setText(localuo.title);
      }
      if (this.kCM != null)
      {
        if (TextUtils.isEmpty(localuo.kmn)) {
          break label138;
        }
        this.kCM.setText(localuo.kmn);
      }
      while (this.kCN != null) {
        if (!TextUtils.isEmpty(localuo.kmo))
        {
          this.kCN.setText(localuo.kmo);
          AppMethodBeat.o(88975);
          return;
          label138:
          this.kCM.setVisibility(8);
        }
        else
        {
          this.kCN.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(88975);
  }
  
  public final void x(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */