package com.tencent.mm.media.proxy;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getAccPath", "", "getAccPathRemote", "Companion", "plugin-mediaeditor_release"})
public final class MediaEditorProxy
  extends a
{
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  public static MediaEditorProxy eVO;
  public static final MediaEditorProxy.a eVP;
  
  static
  {
    AppMethodBeat.i(13004);
    eVP = new MediaEditorProxy.a((byte)0);
    TAG = "MicroMsg.StoryCaptureProxy";
    RESULT_KEY = "result_key";
    AppMethodBeat.o(13004);
  }
  
  public MediaEditorProxy(d paramd)
  {
    super(paramd);
  }
  
  public static final void createInstance(d paramd)
  {
    AppMethodBeat.i(13006);
    MediaEditorProxy.a.createInstance(paramd);
    AppMethodBeat.o(13006);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(13002);
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).getAccPath();
    j.p(localObject, "MMKernel.storage().accPath");
    AppMethodBeat.o(13002);
    return localObject;
  }
  
  @f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(13003);
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).getAccPath();
    j.p(localObject, "MMKernel.storage().accPath");
    AppMethodBeat.o(13003);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.proxy.MediaEditorProxy
 * JD-Core Version:    0.7.0.1
 */