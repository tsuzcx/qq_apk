package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KSwitchView;
import com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class KindaSwitchViewImpl
  extends MMKView<MMSwitchBtn>
  implements KSwitchView
{
  private MMSwitchBtn mmSwitchBtn;
  private KSwitchViewOnChangeSwitchCallback onChangeSwitchCallback;
  
  public MMSwitchBtn createView(Context paramContext)
  {
    AppMethodBeat.i(144818);
    this.mmSwitchBtn = new MMSwitchBtn(paramContext);
    paramContext = this.mmSwitchBtn;
    AppMethodBeat.o(144818);
    return paramContext;
  }
  
  public boolean getEnabled()
  {
    AppMethodBeat.i(144821);
    boolean bool = this.mmSwitchBtn.isEnabled();
    AppMethodBeat.o(144821);
    return bool;
  }
  
  public KImage getOffImage()
  {
    return null;
  }
  
  public boolean getOn()
  {
    return this.mmSwitchBtn.ADA;
  }
  
  public KImage getOnImage()
  {
    return null;
  }
  
  public long getOnTintColor()
  {
    return 0L;
  }
  
  public long getThumbTintColor()
  {
    return 0L;
  }
  
  public long getTintColor()
  {
    return 0L;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(144820);
    this.mmSwitchBtn.setEnabled(paramBoolean);
    AppMethodBeat.o(144820);
  }
  
  public void setOffImage(KImage paramKImage) {}
  
  public void setOn(boolean paramBoolean)
  {
    AppMethodBeat.i(144819);
    this.mmSwitchBtn.setCheck(paramBoolean);
    AppMethodBeat.o(144819);
  }
  
  public void setOnChangeSwitchCallback(KSwitchViewOnChangeSwitchCallback paramKSwitchViewOnChangeSwitchCallback)
  {
    AppMethodBeat.i(144822);
    this.mmSwitchBtn.setSwitchListener(new KindaSwitchViewImpl.1(this, paramKSwitchViewOnChangeSwitchCallback));
    AppMethodBeat.o(144822);
  }
  
  public void setOnImage(KImage paramKImage) {}
  
  public void setOnTintColor(long paramLong) {}
  
  public void setThumbTintColor(long paramLong) {}
  
  public void setTintColor(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSwitchViewImpl
 * JD-Core Version:    0.7.0.1
 */