package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KSwitchView;
import com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class KindaSwitchViewImpl
  extends MMKView<MMSwitchBtn>
  implements KSwitchView
{
  private MMSwitchBtn mmSwitchBtn;
  private KSwitchViewOnChangeSwitchCallback onChangeSwitchCallback;
  
  public MMSwitchBtn createView(Context paramContext)
  {
    AppMethodBeat.i(18966);
    this.mmSwitchBtn = new MMSwitchBtn(paramContext);
    paramContext = this.mmSwitchBtn;
    AppMethodBeat.o(18966);
    return paramContext;
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(18969);
    boolean bool = this.mmSwitchBtn.isEnabled();
    AppMethodBeat.o(18969);
    return bool;
  }
  
  public KImage getOffImage()
  {
    return null;
  }
  
  public boolean getOn()
  {
    return this.mmSwitchBtn.HAh;
  }
  
  public KImage getOnImage()
  {
    return null;
  }
  
  public DynamicColor getOnTintColor()
  {
    return null;
  }
  
  public DynamicColor getThumbTintColor()
  {
    return null;
  }
  
  public DynamicColor getTintColor()
  {
    return null;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(18968);
    this.mmSwitchBtn.setEnabled(paramBoolean);
    AppMethodBeat.o(18968);
  }
  
  public void setOffImage(KImage paramKImage) {}
  
  public void setOn(boolean paramBoolean)
  {
    AppMethodBeat.i(18967);
    this.mmSwitchBtn.setCheck(paramBoolean);
    AppMethodBeat.o(18967);
  }
  
  public void setOnChangeSwitchCallback(final KSwitchViewOnChangeSwitchCallback paramKSwitchViewOnChangeSwitchCallback)
  {
    AppMethodBeat.i(18970);
    this.mmSwitchBtn.setSwitchListener(new MMSwitchBtn.a()
    {
      public void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(18965);
        paramKSwitchViewOnChangeSwitchCallback.onChangeSwitch();
        AppMethodBeat.o(18965);
      }
    });
    AppMethodBeat.o(18970);
  }
  
  public void setOnImage(KImage paramKImage) {}
  
  public void setOnTintColor(DynamicColor paramDynamicColor) {}
  
  public void setThumbTintColor(DynamicColor paramDynamicColor) {}
  
  public void setTintColor(DynamicColor paramDynamicColor) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSwitchViewImpl
 * JD-Core Version:    0.7.0.1
 */