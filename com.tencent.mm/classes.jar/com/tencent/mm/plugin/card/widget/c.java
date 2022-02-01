package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.tu;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView oWH;
  protected TextView oWI;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void bZX()
  {
    AppMethodBeat.i(113902);
    this.oWI = ((TextView)bZW().findViewById(2131297733));
    this.oWH = ((TextView)bZW().findViewById(2131297902));
    AppMethodBeat.o(113902);
  }
  
  protected final void bZY()
  {
    AppMethodBeat.i(113903);
    if ((this.oDm.bVc().GjY != null) && (this.oDm.bVc().GjY.size() > 0))
    {
      aai localaai = (aai)this.oDm.bVc().GjY.get(0);
      if (this.mRG != null) {
        this.mRG.setText(localaai.title);
      }
      if (this.oWH != null)
      {
        if (TextUtils.isEmpty(localaai.oEp)) {
          break label138;
        }
        this.oWH.setText(localaai.oEp);
      }
      while (this.oWI != null) {
        if (!TextUtils.isEmpty(localaai.oEq))
        {
          this.oWI.setText(localaai.oEq);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.oWH.setVisibility(8);
        }
        else
        {
          this.oWI.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */