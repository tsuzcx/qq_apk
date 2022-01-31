package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.InvokeEvent.IERemux;
import com.hilive.mediasdk.MediaSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class b$10
  implements Runnable
{
  public b$10(b paramb, String paramString1, Map paramMap, String paramString2, String paramString3, d paramd, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(143235);
    if ((bo.isNullOrNil(this.hvi)) && (this.hvj == null))
    {
      ab.i("MicroMsg.GameRecorderMgr", "hy: not need remux because no audio and cut required");
      e.C(this.hvk, this.hvl);
      this.huQ.a(0, 0, "ok", new b.e(this.hvb));
      AppMethodBeat.o(143235);
      return;
    }
    InvokeEvent.IERemux localIERemux = new InvokeEvent.IERemux();
    localIERemux.videoName = this.hvk;
    localIERemux.audioName = this.hvi;
    localIERemux.fileName = this.hvl;
    localIERemux.videoCutStamps = this.hvj;
    if (this.hvm != null)
    {
      localIERemux.audioSuggestTransBitRates = this.hvm.audioSuggestTransBitRates;
      localIERemux.audioSuggestTransCodecId = 86018;
      localIERemux.audioSuggestTransChannels = this.hvm.audioSuggestTransChannels;
      localIERemux.audioSuggestTransSampleRates = this.hvm.audioSuggestTransSampleRates;
    }
    MediaSdk.getInstance().remuxFile(localIERemux, new b.10.1(this));
    AppMethodBeat.o(143235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.10
 * JD-Core Version:    0.7.0.1
 */