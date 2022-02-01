package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.sdk.event.IListener;

public class FaceModuleResUpdateListener
  extends IListener<cd>
{
  public FaceModuleResUpdateListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161647);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(161647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceModuleResUpdateListener
 * JD-Core Version:    0.7.0.1
 */