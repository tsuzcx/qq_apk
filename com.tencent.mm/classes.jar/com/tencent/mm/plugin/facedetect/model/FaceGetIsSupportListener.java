package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lo;
import com.tencent.mm.sdk.event.IListener;

public class FaceGetIsSupportListener
  extends IListener<lo>
{
  public FaceGetIsSupportListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161645);
    this.__eventId = lo.class.getName().hashCode();
    AppMethodBeat.o(161645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceGetIsSupportListener
 * JD-Core Version:    0.7.0.1
 */