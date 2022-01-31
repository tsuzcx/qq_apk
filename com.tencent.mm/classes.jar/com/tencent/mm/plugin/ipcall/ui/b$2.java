package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

final class b$2
  implements TextWatcher
{
  b$2(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(21971);
    paramEditable = this.nQQ.nQx.getText().toString().replace("+", "");
    if ((paramEditable.startsWith("0")) || (paramEditable.startsWith("*")) || (paramEditable.startsWith("#")))
    {
      this.nQQ.nQx.setText("+");
      this.nQQ.nQF = "+";
    }
    AppMethodBeat.o(21971);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21970);
    if (this.nQQ.nQB.getLayoutParams() != null)
    {
      paramCharSequence = this.nQQ.nQx.getPaint();
      if ("+".equals(this.nQQ.nQx.getText().toString()))
      {
        paramInt1 = (int)paramCharSequence.measureText(this.nQQ.nQx.getText().toString());
        this.nQQ.nQz.setVisibility(8);
        this.nQQ.nQC.setVisibility(8);
        paramCharSequence = (RelativeLayout.LayoutParams)this.nQQ.nQB.getLayoutParams();
        paramCharSequence.width = paramInt1;
        this.nQQ.nQB.setLayoutParams(paramCharSequence);
      }
    }
    else
    {
      paramCharSequence = this.nQQ.nQx.getText().toString().replace("+", "");
      if (!a.RD(paramCharSequence)) {
        break label364;
      }
      this.nQQ.nQC.setText(a.RA(paramCharSequence));
      if ((this.nQQ.nQI == null) || (this.nQQ.nQI.size() <= 0)) {
        break label386;
      }
      String str = a.RB(paramCharSequence);
      Iterator localIterator = this.nQQ.nQI.iterator();
      while (localIterator.hasNext())
      {
        cuz localcuz = (cuz)localIterator.next();
        if ((localcuz != null) && (localcuz.gwY.equals(str)))
        {
          paramInt1 = 1;
          label255:
          if (paramInt1 == 0) {
            break label391;
          }
          this.nQQ.nQD.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.nQQ.nQv != null) {
        this.nQQ.nQv.Rk(paramCharSequence);
      }
      AppMethodBeat.o(21970);
      return;
      paramInt1 = (int)paramCharSequence.measureText(this.nQQ.nQx.getText() + "+");
      this.nQQ.nQz.setVisibility(0);
      this.nQQ.nQC.setVisibility(0);
      break;
      paramInt1 = 0;
      break label255;
      label364:
      this.nQQ.nQC.setText(this.nQQ.cmc.getString(2131300838));
      label386:
      paramInt1 = 0;
      break label255;
      label391:
      this.nQQ.nQD.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.2
 * JD-Core Version:    0.7.0.1
 */