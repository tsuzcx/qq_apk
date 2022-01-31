package com.tencent.kinda.framework.widget.base;

import com.facebook.yoga.YogaNode;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewBase
{
  protected FlexBoxAttr flexAttr;
  
  public ViewBase()
  {
    AppMethodBeat.i(145133);
    this.flexAttr = new FlexBoxAttr(new ViewBase.1(this));
    AppMethodBeat.o(145133);
  }
  
  public YogaNode node()
  {
    AppMethodBeat.i(145134);
    YogaNode localYogaNode = this.flexAttr.node();
    AppMethodBeat.o(145134);
    return localYogaNode;
  }
  
  protected void onFlexAttribute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.ViewBase
 * JD-Core Version:    0.7.0.1
 */