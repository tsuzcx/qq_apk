package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ux;
import com.tencent.mm.sdk.event.IListener;

public class FaceDetectStartListener
  extends IListener<ux>
{
  public FaceDetectStartListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161644);
    this.__eventId = ux.class.getName().hashCode();
    AppMethodBeat.o(161644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectStartListener
 * JD-Core Version:    0.7.0.1
 */