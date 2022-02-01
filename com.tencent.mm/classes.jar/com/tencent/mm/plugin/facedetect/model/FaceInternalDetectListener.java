package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.uv;
import com.tencent.mm.sdk.event.IListener;

public class FaceInternalDetectListener
  extends IListener<uv>
{
  public FaceInternalDetectListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161646);
    this.__eventId = uv.class.getName().hashCode();
    AppMethodBeat.o(161646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceInternalDetectListener
 * JD-Core Version:    0.7.0.1
 */