package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.sdk.event.IListener;

public class PostSyncTaskDeprecatedListener
  extends IListener<se>
{
  public PostSyncTaskDeprecatedListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161308);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PostSyncTaskDeprecatedListener
 * JD-Core Version:    0.7.0.1
 */