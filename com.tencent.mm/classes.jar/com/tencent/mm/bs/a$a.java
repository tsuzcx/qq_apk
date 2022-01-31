package com.tencent.mm.bs;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.aj;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.y.e;

public final class a$a
  implements com.tencent.mm.ae.a
{
  View whq;
  TextView whr;
  ImageView whs;
  
  public a$a(a parama)
  {
    AppMethodBeat.i(116313);
    this.whq = this.whn.whc.getRubbishView();
    this.whr = ((TextView)this.whq.findViewById(2131827396));
    this.whs = ((ImageView)this.whq.findViewById(2131827395));
    AppMethodBeat.o(116313);
  }
  
  public final void SW()
  {
    AppMethodBeat.i(116315);
    ab.i("MicroMsg.DrawingPresenter", "[onUnReach]");
    this.whq.setActivated(false);
    this.whs.setImageDrawable(aj.g(this.whn.whc.getContext(), 2131231451, -1));
    this.whr.setText(this.whn.whc.getContext().getString(2131302831));
    AppMethodBeat.o(116315);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(116318);
    EditText localEditText = (EditText)this.whn.whc.getTextEditView().findViewById(2131823497);
    localEditText.setTag(parame);
    if (this.whn.whi != null)
    {
      this.whn.whi.b(parame);
      AppMethodBeat.o(116318);
      return;
    }
    localEditText.setText(parame.eFO);
    Switch localSwitch = (Switch)this.whn.whc.findViewById(2131823498);
    SelectColorBar localSelectColorBar = (SelectColorBar)this.whn.whc.findViewById(2131823499);
    boolean bool;
    if (parame.mBgColor != 0)
    {
      bool = true;
      localSwitch.setChecked(bool);
      if (!localSwitch.isChecked()) {
        break label165;
      }
      localSelectColorBar.setSelectColor(parame.mBgColor);
    }
    for (;;)
    {
      localEditText.setTextColor(parame.mColor);
      localEditText.setTag(parame);
      this.whn.px(true);
      AppMethodBeat.o(116318);
      return;
      bool = false;
      break;
      label165:
      localSelectColorBar.setSelectColor(parame.mColor);
    }
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(116314);
    ab.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
    this.whq.setActivated(true);
    this.whr.setText(this.whn.whc.getContext().getString(2131302830));
    this.whs.setImageDrawable(aj.g(this.whn.whc.getContext(), 2131231452, -1));
    AppMethodBeat.o(116314);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(116317);
    a.a(this.whn, false);
    AppMethodBeat.o(116317);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(116316);
    a.a(this.whn, true);
    if (this.whn.whi != null) {
      this.whn.whi.h(Boolean.TRUE);
    }
    AppMethodBeat.o(116316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bs.a.a
 * JD-Core Version:    0.7.0.1
 */