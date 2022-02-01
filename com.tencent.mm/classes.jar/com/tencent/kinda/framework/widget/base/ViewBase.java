package com.tencent.kinda.framework.widget.base;

import com.facebook.yoga.YogaNode;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr.IFlexBoxChange;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewBase
{
  protected FlexBoxAttr flexAttr;
  
  public ViewBase()
  {
    AppMethodBeat.i(19297);
    this.flexAttr = new FlexBoxAttr(new FlexBoxAttr.IFlexBoxChange()
    {
      public void onChange()
      {
        AppMethodBeat.i(19296);
        ViewBase.this.onFlexAttribute();
        AppMethodBeat.o(19296);
      }
    });
    AppMethodBeat.o(19297);
  }
  
  public YogaNode node()
  {
    AppMethodBeat.i(19298);
    YogaNode localYogaNode = this.flexAttr.node();
    AppMethodBeat.o(19298);
    return localYogaNode;
  }
  
  protected void onFlexAttribute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.ViewBase
 * JD-Core Version:    0.7.0.1
 */