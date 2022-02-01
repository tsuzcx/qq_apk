package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost2;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "clientId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostDraftRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderPostDraftRequest;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderPostDraftRequest;)V", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFinderObject", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onGYNetEnd", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bz
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ABW;
  private final FinderItem ABU;
  private final i ABX;
  private bsm ABY;
  private com.tencent.mm.am.h callback;
  public final String clientId;
  private final FinderObject feedObject;
  private c oDw;
  
  static
  {
    AppMethodBeat.i(336360);
    ABW = new a((byte)0);
    AppMethodBeat.o(336360);
  }
  
  private bz(i parami, String paramString)
  {
    super(null);
    AppMethodBeat.i(336347);
    this.ABX = parami;
    this.clientId = paramString;
    this.feedObject = this.ABX.eYK().getFeedObject();
    this.ABU = this.ABX.eYK();
    c.a locala = new c.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/finderpostdraft";
    this.ABY = new bsm();
    parami = this.ABU.getPostInfo().clientId;
    paramString = (CharSequence)parami;
    bsm localbsm;
    if ((paramString == null) || (paramString.length() == 0))
    {
      i = 1;
      if (i != 0) {
        parami = kotlin.g.b.s.X("FinderLocal_feed_", Long.valueOf(System.nanoTime()));
      }
      this.ABY.username = z.bAW();
      this.ABY.aaap = parami;
      localbsm = this.ABY;
      paramString = (com.tencent.mm.bx.a)new FinderObjectDesc();
      parami = this.feedObject.objectDesc;
      if (parami != null) {
        break label467;
      }
    }
    for (parami = null;; parami = parami.toByteArray())
    {
      try
      {
        paramString.parseFrom(parami);
        parami = paramString;
      }
      catch (Exception parami)
      {
        FinderObjectDesc localFinderObjectDesc;
        for (;;)
        {
          Iterator localIterator;
          dji localdji;
          label467:
          Log.printDebugStack("safeParser", "", new Object[] { parami });
          parami = null;
          continue;
          i = (int)parami.duration;
        }
        if (localFinderObjectDesc.mediaType != 8) {
          break label523;
        }
        localFinderObjectDesc.mediaType = 0;
        localbsm.aaan = localFinderObjectDesc;
        parami = this.ABY;
        i = k;
        if (!this.ABX.isMvFeed()) {
          break label550;
        }
        i = 2;
        parami.aaao = i;
        parami = this.ABY;
        paramString = bi.ABn;
        parami.CJv = bi.dVu();
        parami = this.ABY;
        if (!this.ABX.isMvFeed()) {
          break label740;
        }
      }
      kotlin.g.b.s.checkNotNull(parami);
      localFinderObjectDesc = (FinderObjectDesc)parami;
      parami = localFinderObjectDesc.media;
      kotlin.g.b.s.s(parami, "objectDesc.media");
      localIterator = ((Iterable)parami).iterator();
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
              parami = this.ABU;
              paramString = MD5Util.getMD5String(localFinderMedia.url);
              kotlin.g.b.s.s(paramString, "getMD5String(media.url)");
              localdji = parami.mediaExt(paramString);
            } while (localdji == null);
            parami = o.Gco;
            kotlin.g.b.s.s(localFinderMedia, "media");
            o.a(localFinderMedia, localdji, this.ABU.getHalfVideoMediaExtList());
          } while ((localFinderMedia.mediaType != 4) || ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)));
          MultiMediaVideoChecker localMultiMediaVideoChecker = MultiMediaVideoChecker.ObB;
          paramString = localdji.url;
          parami = paramString;
          if (paramString == null) {
            parami = "";
          }
          parami = localMultiMediaVideoChecker.aTG(parami);
          if (parami != null) {
            break;
          }
          i = 0;
          localFinderMedia.videoDuration = (i / 1000);
        } while ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000));
        Log.e("Finder.NetSceneFinderDraftPost2", kotlin.g.b.s.X("NetSceneFinderDraftPost2 videoDuration invalid:", Integer.valueOf(localdji.videoDuration)));
      } while (!BuildInfo.DEBUG);
      parami = new RuntimeException(kotlin.g.b.s.X("NetSceneFinderDraftPost2 videoDuration invalid:", Integer.valueOf(localdji.videoDuration)));
      AppMethodBeat.o(336347);
      throw parami;
      i = 0;
      break;
    }
    label523:
    label550:
    label740:
    for (int i = j;; i = 3)
    {
      parami.scene = i;
      this.ABY.object_id = this.ABX.field_objectId;
      this.ABY.aaaq = this.ABX.eYK().getFeedObject().attachmentList;
      locala.otE = ((com.tencent.mm.bx.a)this.ABY);
      locala.otF = ((com.tencent.mm.bx.a)new bsn());
      parami = locala.bEF();
      kotlin.g.b.s.s(parami, "builder.buildInstance()");
      this.oDw = parami;
      Log.i("Finder.NetSceneFinderDraftPost2", "NetSceneFinderDraftPost2 init " + this.ABX.field_localId + ", " + this.ABX.field_objectId + " localClipNonceId:" + this.ABU.getObjectNonceId());
      AppMethodBeat.o(336347);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336385);
    Log.i("Finder.NetSceneFinderDraftPost2", kotlin.g.b.s.X("errType %d, errCode %d, errMsg %s, localId:", Long.valueOf(this.ABX.field_localId)), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    com.tencent.mm.plugin.findersdk.d.a.B(paramInt2, paramInt3, paramString);
    AppMethodBeat.o(336385);
  }
  
  public final FinderObject dVH()
  {
    AppMethodBeat.i(336395);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostDraftResponse");
      AppMethodBeat.o(336395);
      throw ((Throwable)localObject);
    }
    localObject = ((bsn)localObject).ZIo;
    AppMethodBeat.o(336395);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336372);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336372);
    return i;
  }
  
  public final int getType()
  {
    return 6649;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(336378);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("Finder.NetSceneFinderDraftPost2", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336378);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost2$Companion;", "", "()V", "TAG", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bz
 * JD-Core Version:    0.7.0.1
 */