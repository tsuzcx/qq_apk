package com.tencent.mm.media.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getAccPath", "", "getAccPathRemote", "Companion", "plugin-mediaeditor_release"})
public final class MediaEditorProxy
  extends a
{
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  public static MediaEditorProxy hnE;
  public static final a hnF;
  
  static
  {
    AppMethodBeat.i(93729);
    hnF = new a((byte)0);
    TAG = "MicroMsg.StoryCaptureProxy";
    RESULT_KEY = "result_key";
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
    p.h(paramd, "<set-?>");
    access$setInstance$cp(paramd);
    AppMethodBeat.o(93730);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(93727);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).getAccPath();
    p.g(localObject, "MMKernel.storage().accPath");
    AppMethodBeat.o(93727);
    return localObject;
  }
  
  @f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(93728);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).getAccPath();
    p.g(localObject, "MMKernel.storage().accPath");
    AppMethodBeat.o(93728);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/proxy/MediaEditorProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "getInstance", "()Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "setInstance", "(Lcom/tencent/mm/media/proxy/MediaEditorProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.proxy.MediaEditorProxy
 * JD-Core Version:    0.7.0.1
 */