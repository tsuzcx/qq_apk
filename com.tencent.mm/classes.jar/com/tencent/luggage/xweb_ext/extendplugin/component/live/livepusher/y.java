package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/VideoProcessListenerOwner;", "", "()V", "wrap", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IVideoProcessListenerOwner;", "livePusherJsAdapter", "Lcom/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter;", "livePusher", "Lcom/tencent/rtmp/TXLivePusher;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final y eCW;
  
  static
  {
    AppMethodBeat.i(220835);
    eCW = new y();
    AppMethodBeat.o(220835);
  }
  
  public static final n a(V2TXLivePusherJSAdapter paramV2TXLivePusherJSAdapter)
  {
    AppMethodBeat.i(220825);
    s.u(paramV2TXLivePusherJSAdapter, "livePusherJsAdapter");
    paramV2TXLivePusherJSAdapter = (n)new b(paramV2TXLivePusherJSAdapter);
    AppMethodBeat.o(220825);
    return paramV2TXLivePusherJSAdapter;
  }
  
  public static final n b(TXLivePusher paramTXLivePusher)
  {
    AppMethodBeat.i(220817);
    s.u(paramTXLivePusher, "livePusher");
    paramTXLivePusher = (n)new a(paramTXLivePusher);
    AppMethodBeat.o(220817);
    return paramTXLivePusher;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/VideoProcessListenerOwner$wrap$1", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IVideoProcessListenerOwner;", "setVideoProcessListener", "", "videoProcessListener", "Lcom/tencent/rtmp/TXLivePusher$VideoCustomProcessListener;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements n
  {
    a(TXLivePusher paramTXLivePusher) {}
    
    public final void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
    {
      AppMethodBeat.i(220739);
      s.u(paramVideoCustomProcessListener, "videoProcessListener");
      this.eCX.setVideoProcessListener(paramVideoCustomProcessListener);
      AppMethodBeat.o(220739);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/VideoProcessListenerOwner$wrap$2", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IVideoProcessListenerOwner;", "setVideoProcessListener", "", "videoProcessListener", "Lcom/tencent/rtmp/TXLivePusher$VideoCustomProcessListener;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements n
  {
    b(V2TXLivePusherJSAdapter paramV2TXLivePusherJSAdapter) {}
    
    public final void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
    {
      AppMethodBeat.i(220740);
      s.u(paramVideoCustomProcessListener, "videoProcessListener");
      this.eCY.setVideoProcessListener(paramVideoCustomProcessListener);
      AppMethodBeat.o(220740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.y
 * JD-Core Version:    0.7.0.1
 */