package com.tencent.mm.plugin.luckymoney.story;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.a;

final class EnvelopeAppBarLayout$b
  implements a
{
  public int videoHeight = -1;
  public int videoWidth = -1;
  public djf vtl;
  
  EnvelopeAppBarLayout$b(EnvelopeAppBarLayout paramEnvelopeAppBarLayout) {}
  
  public final int bYk()
  {
    return 0;
  }
  
  public final void diP()
  {
    AppMethodBeat.i(163594);
    if ((this.videoHeight > 0) && (this.videoWidth > 0))
    {
      AppMethodBeat.o(163594);
      return;
    }
    float f = this.vtl.height / (this.vtl.width * 1.0F);
    if (f > 1.667F)
    {
      this.videoHeight = EnvelopeAppBarLayout.D(this.vsZ);
      this.videoWidth = ((int)(EnvelopeAppBarLayout.D(this.vsZ) / f));
    }
    for (;;)
    {
      ad.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
      AppMethodBeat.o(163594);
      return;
      if (f < 1.667F)
      {
        this.videoWidth = EnvelopeAppBarLayout.E(this.vsZ);
        this.videoHeight = ((int)(f * EnvelopeAppBarLayout.E(this.vsZ)));
      }
      else
      {
        this.videoHeight = EnvelopeAppBarLayout.D(this.vsZ);
        this.videoWidth = EnvelopeAppBarLayout.E(this.vsZ);
      }
    }
  }
  
  public final long lP()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.b
 * JD-Core Version:    0.7.0.1
 */