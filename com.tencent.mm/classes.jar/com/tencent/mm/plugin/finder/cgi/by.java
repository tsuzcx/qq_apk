package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "track", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getTrack", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFinderObject", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onGYNetEnd", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class by
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final by.a ABT;
  public final FinderItem ABU;
  public final boq ABV;
  private com.tencent.mm.am.h callback;
  private FinderObject feedObject;
  private c oDw;
  
  static
  {
    AppMethodBeat.i(336383);
    ABT = new by.a((byte)0);
    AppMethodBeat.o(336383);
  }
  
  private by(FinderItem paramFinderItem, boq paramboq)
  {
    super(null);
    AppMethodBeat.i(336362);
    this.ABU = paramFinderItem;
    this.ABV = paramboq;
    this.feedObject = this.ABU.getFeedObject();
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/finderpostdraft";
    bsm localbsm = new bsm();
    paramFinderItem = this.ABU.getPostInfo().clientId;
    paramboq = (CharSequence)paramFinderItem;
    int i;
    if ((paramboq == null) || (paramboq.length() == 0))
    {
      i = 1;
      if (i != 0) {
        paramFinderItem = kotlin.g.b.s.X("FinderLocal_clip_", Long.valueOf(System.nanoTime()));
      }
      localbsm.username = z.bAW();
      localbsm.aaap = paramFinderItem;
      paramboq = (a)new FinderObjectDesc();
      paramFinderItem = this.feedObject.objectDesc;
      if (paramFinderItem != null) {
        break label434;
      }
    }
    for (paramFinderItem = null;; paramFinderItem = paramFinderItem.toByteArray())
    {
      try
      {
        paramboq.parseFrom(paramFinderItem);
        paramFinderItem = paramboq;
      }
      catch (Exception paramFinderItem)
      {
        FinderObjectDesc localFinderObjectDesc;
        for (;;)
        {
          Iterator localIterator;
          dji localdji;
          label434:
          Log.printDebugStack("safeParser", "", new Object[] { paramFinderItem });
          paramFinderItem = null;
          continue;
          i = (int)paramFinderItem.duration;
        }
        if (localFinderObjectDesc.mediaType != 8) {
          break label490;
        }
        localFinderObjectDesc.mediaType = 0;
        localbsm.aaan = localFinderObjectDesc;
        localbsm.aaao = 3;
        paramFinderItem = bi.ABn;
        localbsm.CJv = bi.dVu();
        localbsm.scene = 1;
        locala.otE = ((a)localbsm);
        locala.otF = ((a)new bsn());
        paramFinderItem = locala.bEF();
        kotlin.g.b.s.s(paramFinderItem, "builder.buildInstance()");
        this.oDw = paramFinderItem;
        Log.i("Finder.NetSceneFinderDraftPost", kotlin.g.b.s.X("NetSceneFinderDraftPost init  localClipNonceId:", this.ABU.getObjectNonceId()));
        AppMethodBeat.o(336362);
      }
      kotlin.g.b.s.checkNotNull(paramFinderItem);
      localFinderObjectDesc = (FinderObjectDesc)paramFinderItem;
      paramFinderItem = localFinderObjectDesc.media;
      kotlin.g.b.s.s(paramFinderItem, "objectDesc.media");
      localIterator = ((Iterable)paramFinderItem).iterator();
      do
      {
        FinderMedia localFinderMedia;
        do
        {
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localFinderMedia = (FinderMedia)localIterator.next();
              paramFinderItem = this.ABU;
              paramboq = MD5Util.getMD5String(localFinderMedia.url);
              kotlin.g.b.s.s(paramboq, "getMD5String(media.url)");
              localdji = paramFinderItem.mediaExt(paramboq);
            } while (localdji == null);
            paramFinderItem = o.Gco;
            kotlin.g.b.s.s(localFinderMedia, "media");
            o.a(localFinderMedia, localdji, this.ABU.getHalfVideoMediaExtList());
          } while ((localFinderMedia.mediaType != 4) || ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)));
          MultiMediaVideoChecker localMultiMediaVideoChecker = MultiMediaVideoChecker.ObB;
          paramboq = localdji.url;
          paramFinderItem = paramboq;
          if (paramboq == null) {
            paramFinderItem = "";
          }
          paramFinderItem = localMultiMediaVideoChecker.aTG(paramFinderItem);
          if (paramFinderItem != null) {
            break;
          }
          i = 0;
          localFinderMedia.videoDuration = (i / 1000);
        } while ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000));
        Log.e("Finder.NetSceneFinderDraftPost", kotlin.g.b.s.X("NetSceneFinderPost videoDuration invalid:", Integer.valueOf(localdji.videoDuration)));
      } while (!BuildInfo.DEBUG);
      paramFinderItem = new RuntimeException(kotlin.g.b.s.X("NetSceneFinderPost videoDuration invalid:", Integer.valueOf(localdji.videoDuration)));
      AppMethodBeat.o(336362);
      throw paramFinderItem;
      i = 0;
      break;
    }
    label490:
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params) {}
  
  public final FinderObject dVH()
  {
    AppMethodBeat.i(336438);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostDraftResponse");
      AppMethodBeat.o(336438);
      throw ((Throwable)localObject);
    }
    localObject = ((bsn)localObject).ZIo;
    AppMethodBeat.o(336438);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336409);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336409);
    return i;
  }
  
  public final int getType()
  {
    return 6649;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(336417);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("Finder.NetSceneFinderDraftPost", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.by
 * JD-Core Version:    0.7.0.1
 */