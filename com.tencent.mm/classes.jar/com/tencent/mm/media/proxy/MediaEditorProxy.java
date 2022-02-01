package com.tencent.mm.media.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getAccPath", "", "getAccPathRemote", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaEditorProxy
  extends a
{
  private static final String TAG;
  public static final a nBf;
  private static final String nBg;
  public static MediaEditorProxy nBh;
  
  static
  {
    AppMethodBeat.i(93729);
    nBf = new a((byte)0);
    TAG = "MicroMsg.StoryCaptureProxy";
    nBg = "result_key";
    AppMethodBeat.o(93729);
  }
  
  public MediaEditorProxy(d paramd)
  {
    super(paramd);
  }
  
  public static final void createInstance(d paramd)
  {
    AppMethodBeat.i(93730);
    paramd = new MediaEditorProxy(paramd);
    s.u(paramd, "<set-?>");
    nBh = paramd;
    AppMethodBeat.o(93730);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(93727);
    String str = h.baE().mCJ;
    s.s(str, "storage().accPath");
    AppMethodBeat.o(93727);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(93728);
    String str = h.baE().mCJ;
    s.s(str, "storage().accPath");
    AppMethodBeat.o(93728);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/proxy/MediaEditorProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "getInstance", "()Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "setInstance", "(Lcom/tencent/mm/media/proxy/MediaEditorProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.proxy.MediaEditorProxy
 * JD-Core Version:    0.7.0.1
 */