package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.yf;
import java.util.LinkedList;

final class l$1
  implements View.OnClickListener
{
  l$1(l paraml, yf paramyf, LinkedList paramLinkedList, LayoutInflater paramLayoutInflater) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88754);
    this.kBp.kBl = true;
    this.kBp.kBj.findViewById(2131822069).setVisibility(8);
    int i = this.kBm.wPm;
    while (i < this.kBn.size())
    {
      paramView = (TextView)this.kBo.inflate(2130969006, null, false);
      paramView.setText(((uo)this.kBn.get(i)).title);
      this.kBp.kBk.addView(paramView);
      i += 1;
    }
    this.kBp.kBk.invalidate();
    AppMethodBeat.o(88754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l.1
 * JD-Core Version:    0.7.0.1
 */