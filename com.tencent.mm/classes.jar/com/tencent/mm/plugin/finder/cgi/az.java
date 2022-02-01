package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "track", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getTrack", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFinderObject", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onGYNetEnd", "Companion", "plugin-finder_release"})
public final class az
  extends ax
{
  public static final a tuZ;
  private i callback;
  private FinderObject feedObject;
  public d iUB;
  public final FinderItem tuX;
  public final axz tuY;
  
  static
  {
    AppMethodBeat.i(242368);
    tuZ = new a((byte)0);
    AppMethodBeat.o(242368);
  }
  
  private az(FinderItem paramFinderItem, axz paramaxz)
  {
    super(null);
    AppMethodBeat.i(242367);
    this.tuX = paramFinderItem;
    this.tuY = paramaxz;
    this.feedObject = this.tuX.getFeedObject();
    d.a locala = new d.a();
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/finderpostdraft");
    baj localbaj = new baj();
    paramFinderItem = this.tuX.getPostInfo().clientId;
    paramaxz = (CharSequence)paramFinderItem;
    int i;
    if ((paramaxz == null) || (paramaxz.length() == 0))
    {
      i = 1;
      if (i != 0) {
        paramFinderItem = "FinderLocal_clip_" + System.nanoTime();
      }
      localbaj.username = z.aUg();
      localbaj.LKb = paramFinderItem;
      paramaxz = (a)new FinderObjectDesc();
      paramFinderItem = this.feedObject.objectDesc;
      if (paramFinderItem == null) {
        break label321;
      }
    }
    for (paramFinderItem = paramFinderItem.toByteArray();; paramFinderItem = null)
    {
      try
      {
        paramaxz.parseFrom(paramFinderItem);
        paramFinderItem = paramaxz;
      }
      catch (Exception paramFinderItem)
      {
        for (;;)
        {
          label321:
          Log.printDebugStack("safeParser", "", new Object[] { paramFinderItem });
          paramFinderItem = null;
        }
      }
      if (paramFinderItem == null) {
        p.hyc();
      }
      paramFinderItem = a((FinderObjectDesc)paramFinderItem);
      if (paramFinderItem.mediaType == 8) {
        paramFinderItem.mediaType = 0;
      }
      localbaj.LJZ = paramFinderItem;
      localbaj.LKa = 3;
      paramFinderItem = am.tuw;
      localbaj.uli = am.cXY();
      localbaj.scene = 1;
      locala.c((a)localbaj);
      locala.d((a)new bak());
      paramFinderItem = locala.aXF();
      p.g(paramFinderItem, "builder.buildInstance()");
      this.iUB = paramFinderItem;
      Log.i("Finder.NetSceneFinderDraftPost", "NetSceneFinderDraftPost init  localClipNonceId:" + this.tuX.getObjectNonceId());
      AppMethodBeat.o(242367);
      return;
      i = 0;
      break;
    }
  }
  
  private final FinderObjectDesc a(FinderObjectDesc paramFinderObjectDesc)
  {
    AppMethodBeat.i(242366);
    Object localObject = paramFinderObjectDesc.media;
    p.g(localObject, "objectDesc.media");
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      FinderMedia localFinderMedia = (FinderMedia)localIterator.next();
      localObject = this.tuX;
      String str = MD5Util.getMD5String(localFinderMedia.url);
      p.g(str, "MD5Util.getMD5String(media.url)");
      cjl localcjl = ((FinderItem)localObject).mediaExt(str);
      if (localcjl != null)
      {
        localObject = o.vTw;
        p.g(localFinderMedia, "media");
        o.a(localFinderMedia, localcjl, this.tuX.getHalfVideoMediaExtList());
        if ((localFinderMedia.mediaType == 4) && ((localFinderMedia.videoDuration <= 0) || (localFinderMedia.videoDuration > 2000)))
        {
          MultiMediaVideoChecker localMultiMediaVideoChecker = MultiMediaVideoChecker.GyY;
          str = localcjl.url;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = localMultiMediaVideoChecker.aTV((String)localObject);
          if (localObject != null) {}
          for (int i = (int)((MultiMediaVideoChecker.a)localObject).duration;; i = 0)
          {
            localFinderMedia.videoDuration = (i / 1000);
            if ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)) {
              break;
            }
            Log.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + localcjl.videoDuration);
            if (!BuildInfo.DEBUG) {
              break;
            }
            paramFinderObjectDesc = (Throwable)new RuntimeException("NetSceneFinderPost videoDuration invalid:" + localcjl.videoDuration);
            AppMethodBeat.o(242366);
            throw paramFinderObjectDesc;
          }
        }
      }
    }
    AppMethodBeat.o(242366);
    return paramFinderObjectDesc;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params) {}
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242364);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(242364);
    return i;
  }
  
  public final int getType()
  {
    return 6649;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(242365);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("Finder.NetSceneFinderDraftPost", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242365);
      return;
    }
    AppMethodBeat.o(242365);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.az
 * JD-Core Version:    0.7.0.1
 */