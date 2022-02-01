package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.uy;
import com.tencent.mm.sdk.event.IListener;

public class FaceStartManageListener
  extends IListener<uy>
{
  public FaceStartManageListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161648);
    this.__eventId = uy.class.getName().hashCode();
    AppMethodBeat.o(161648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceStartManageListener
 * JD-Core Version:    0.7.0.1
 */