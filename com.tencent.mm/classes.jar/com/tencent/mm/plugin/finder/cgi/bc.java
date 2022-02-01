package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "track", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getTrack", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFinderObject", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onGYNetEnd", "Companion", "plugin-finder_release"})
public final class bc
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcI;
  private i callback;
  private FinderObject feedObject;
  public d lKU;
  public final FinderItem xcG;
  public final bdt xcH;
  
  static
  {
    AppMethodBeat.i(285706);
    xcI = new a((byte)0);
    AppMethodBeat.o(285706);
  }
  
  private bc(FinderItem paramFinderItem, bdt parambdt)
  {
    super(null);
    AppMethodBeat.i(285705);
    this.xcG = paramFinderItem;
    this.xcH = parambdt;
    this.feedObject = this.xcG.getFeedObject();
    d.a locala = new d.a();
    locala.vD(getType());
    locala.TW("/cgi-bin/micromsg-bin/finderpostdraft");
    bgu localbgu = new bgu();
    paramFinderItem = this.xcG.getPostInfo().clientId;
    parambdt = (CharSequence)paramFinderItem;
    int i;
    if ((parambdt == null) || (parambdt.length() == 0))
    {
      i = 1;
      if (i != 0) {
        paramFinderItem = "FinderLocal_clip_" + System.nanoTime();
      }
      localbgu.username = z.bdh();
      localbgu.SRw = paramFinderItem;
      parambdt = (a)new FinderObjectDesc();
      paramFinderItem = this.feedObject.objectDesc;
      if (paramFinderItem == null) {
        break label321;
      }
    }
    for (paramFinderItem = paramFinderItem.toByteArray();; paramFinderItem = null)
    {
      try
      {
        parambdt.parseFrom(paramFinderItem);
        paramFinderItem = parambdt;
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
        p.iCn();
      }
      paramFinderItem = a((FinderObjectDesc)paramFinderItem);
      if (paramFinderItem.mediaType == 8) {
        paramFinderItem.mediaType = 0;
      }
      localbgu.SRu = paramFinderItem;
      localbgu.SRv = 3;
      paramFinderItem = ao.xcj;
      localbgu.yjp = ao.dnO();
      localbgu.scene = 1;
      locala.c((a)localbgu);
      locala.d((a)new bgv());
      paramFinderItem = locala.bgN();
      p.j(paramFinderItem, "builder.buildInstance()");
      this.lKU = paramFinderItem;
      Log.i("Finder.NetSceneFinderDraftPost", "NetSceneFinderDraftPost init  localClipNonceId:" + this.xcG.getObjectNonceId());
      AppMethodBeat.o(285705);
      return;
      i = 0;
      break;
    }
  }
  
  private final FinderObjectDesc a(FinderObjectDesc paramFinderObjectDesc)
  {
    AppMethodBeat.i(285704);
    Object localObject = paramFinderObjectDesc.media;
    p.j(localObject, "objectDesc.media");
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      FinderMedia localFinderMedia = (FinderMedia)localIterator.next();
      localObject = this.xcG;
      String str = MD5Util.getMD5String(localFinderMedia.url);
      p.j(str, "MD5Util.getMD5String(media.url)");
      csg localcsg = ((FinderItem)localObject).mediaExt(str);
      if (localcsg != null)
      {
        localObject = o.AAZ;
        p.j(localFinderMedia, "media");
        o.a(localFinderMedia, localcsg, this.xcG.getHalfVideoMediaExtList());
        if ((localFinderMedia.mediaType == 4) && ((localFinderMedia.videoDuration <= 0) || (localFinderMedia.videoDuration > 2000)))
        {
          MultiMediaVideoChecker localMultiMediaVideoChecker = MultiMediaVideoChecker.NmA;
          str = localcsg.url;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = localMultiMediaVideoChecker.bfs((String)localObject);
          if (localObject != null) {}
          for (int i = (int)((MultiMediaVideoChecker.a)localObject).duration;; i = 0)
          {
            localFinderMedia.videoDuration = (i / 1000);
            if ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)) {
              break;
            }
            Log.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + localcsg.videoDuration);
            if (!BuildInfo.DEBUG) {
              break;
            }
            paramFinderObjectDesc = (Throwable)new RuntimeException("NetSceneFinderPost videoDuration invalid:" + localcsg.videoDuration);
            AppMethodBeat.o(285704);
            throw paramFinderObjectDesc;
          }
        }
      }
    }
    AppMethodBeat.o(285704);
    return paramFinderObjectDesc;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params) {}
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(285702);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(285702);
    return i;
  }
  
  public final int getType()
  {
    return 6649;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(285703);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("Finder.NetSceneFinderDraftPost", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(285703);
      return;
    }
    AppMethodBeat.o(285703);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bc
 * JD-Core Version:    0.7.0.1
 */