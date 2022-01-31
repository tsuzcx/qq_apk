package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class b$4
  implements View.OnClickListener
{
  b$4(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21974);
    paramView = this.nQQ.nQy.getText().toString();
    if (bo.isNullOrNil(paramView))
    {
      paramView = this.nQQ.nQx.getText().toString();
      if (!bo.isNullOrNil(paramView))
      {
        paramView = paramView.substring(0, paramView.length() - 1);
        if ((!bo.isNullOrNil(paramView)) && (!paramView.equals("+")))
        {
          this.nQQ.nQx.setText(paramView);
          this.nQQ.nQF = paramView;
          AppMethodBeat.o(21974);
          return;
        }
        this.nQQ.nQx.setText("+");
        this.nQQ.nQF = "+";
        this.nQQ.nQK = true;
      }
      AppMethodBeat.o(21974);
      return;
    }
    int i = this.nQQ.nQy.getSelectionStart();
    String str;
    if ((this.nQQ.nQN) && (i - 1 >= 0))
    {
      paramView = this.nQQ.nQy.getText();
      paramView.delete(i - 1, i);
      paramView = paramView.toString();
      if (bo.isNullOrNil(paramView)) {
        break label368;
      }
      str = this.nQQ.nQx.getText().toString().replace("+", "");
      if (!this.nQQ.nQN) {
        break label337;
      }
      this.nQQ.nQG = b.eT(str, paramView);
      int j = this.nQQ.nQG.length();
      int k = paramView.length();
      this.nQQ.cy(this.nQQ.nQG, j - k + (i - 1));
      label287:
      this.nQQ.bJZ();
    }
    for (;;)
    {
      this.nQQ.nQH = "";
      this.nQQ.gqe.setText("");
      AppMethodBeat.o(21974);
      return;
      paramView = paramView.substring(0, paramView.length() - 1);
      break;
      label337:
      this.nQQ.nQG = b.eT(str, paramView);
      this.nQQ.cy(this.nQQ.nQG, -1);
      break label287;
      label368:
      this.nQQ.nQG = "";
      this.nQQ.cy("", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.4
 * JD-Core Version:    0.7.0.1
 */