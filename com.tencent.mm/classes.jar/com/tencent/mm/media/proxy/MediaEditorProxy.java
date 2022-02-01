package com.tencent.mm.media.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getAccPath", "", "getAccPathRemote", "Companion", "plugin-mediaeditor_release"})
public final class MediaEditorProxy
  extends a
{
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  public static MediaEditorProxy gSP;
  public static final MediaEditorProxy.a gSQ;
  
  static
  {
    AppMethodBeat.i(93729);
    gSQ = new MediaEditorProxy.a((byte)0);
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
    k.h(paramd, "<set-?>");
    access$setInstance$cp(paramd);
    AppMethodBeat.o(93730);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(93727);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).getAccPath();
    k.g(localObject, "MMKernel.storage().accPath");
    AppMethodBeat.o(93727);
    return localObject;
  }
  
  @f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(93728);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).getAccPath();
    k.g(localObject, "MMKernel.storage().accPath");
    AppMethodBeat.o(93728);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.proxy.MediaEditorProxy
 * JD-Core Version:    0.7.0.1
 */