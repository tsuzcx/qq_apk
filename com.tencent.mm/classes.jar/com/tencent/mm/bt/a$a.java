package com.tencent.mm.bt;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.bo.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.z.e;

final class a$a
  implements com.tencent.mm.ad.a
{
  View soK = this.soH.soy.getRubbishView();
  TextView soL = (TextView)this.soK.findViewById(a.e.rubbish_tip);
  ImageView soM = (ImageView)this.soK.findViewById(a.e.rubbish_icon);
  
  a$a(a parama) {}
  
  public final void EN()
  {
    y.i("MicroMsg.DrawingPresenter", "[onUnReach]");
    this.soM.setImageResource(a.d.rubbish_normal);
    this.soL.setText(this.soH.soy.getContext().getString(a.h.rubbish_unreached_tip));
  }
  
  public final void a(e parame)
  {
    EditText localEditText = (EditText)this.soH.soy.getTextEditView().findViewById(a.e.text_edit);
    localEditText.setText(parame.dIl);
    Switch localSwitch = (Switch)this.soH.soy.findViewById(a.e.bg_switch);
    SelectColorBar localSelectColorBar = (SelectColorBar)this.soH.soy.findViewById(a.e.select_color_bar);
    boolean bool;
    if (parame.dIk != 0)
    {
      bool = true;
      localSwitch.setChecked(bool);
      if (!localSwitch.isChecked()) {
        break label123;
      }
      localSelectColorBar.setSelectColor(parame.dIk);
    }
    for (;;)
    {
      localEditText.setTextColor(parame.mColor);
      localEditText.setTag(parame);
      this.soH.mi(true);
      return;
      bool = false;
      break;
      label123:
      localSelectColorBar.setSelectColor(parame.mColor);
    }
  }
  
  public final void ac(float paramFloat)
  {
    y.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
    this.soL.setText(this.soH.soy.getContext().getString(a.h.rubbish_reached_tip));
    this.soM.setImageResource(a.d.rubbish_red);
  }
  
  public final void onHide()
  {
    a.a(this.soH, false);
  }
  
  public final void onShow()
  {
    a.a(this.soH, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bt.a.a
 * JD-Core Version:    0.7.0.1
 */