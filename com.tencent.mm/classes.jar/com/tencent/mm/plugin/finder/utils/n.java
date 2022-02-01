package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderFavUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "doFav", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "context", "Landroid/app/Activity;", "getFeedThumbInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "thumbPath", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n Ggy;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167881);
    Ggy = new n();
    TAG = "Finder.FinderFavUtil";
    AppMethodBeat.o(167881);
  }
  
  public static void a(final BaseFinderFeed paramBaseFinderFeed, final Activity paramActivity)
  {
    AppMethodBeat.i(333709);
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramActivity, "context");
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("share"))
    {
      AppMethodBeat.o(333709);
      return;
    }
    paramBaseFinderFeed.feedObject.getMediaType();
    f.Ozc.idkeyStat(1278L, 10L, 1L, false);
    localObject1 = z.FrZ;
    z.j(paramBaseFinderFeed.feedObject);
    localObject1 = paramBaseFinderFeed.feedObject.getFeedObject();
    paramBaseFinderFeed = (kotlin.g.a.b)new n.a(paramBaseFinderFeed, paramActivity);
    s.u(localObject1, "feed");
    s.u(paramBaseFinderFeed, "callback");
    paramActivity = new ah.f();
    paramActivity.aqH = "";
    Object localObject2 = ((FinderObject)localObject1).objectDesc;
    if (localObject2 != null)
    {
      if ((((FinderObjectDesc)localObject2).media.size() >= 0) && (((FinderObjectDesc)localObject2).media.size() == 0))
      {
        if (((FinderObjectDesc)localObject2).mediaType == 1) {
          com.tencent.mm.ae.d.B((kotlin.g.a.a)new b((FinderObject)localObject1, paramBaseFinderFeed));
        }
        AppMethodBeat.o(333709);
        return;
      }
      localObject1 = (FinderMedia)((FinderObjectDesc)localObject2).media.getFirst();
      switch (((FinderMedia)localObject1).mediaType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(333709);
      return;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      s.s(localObject1, "firstMedia");
      localObject1 = new com.tencent.mm.plugin.finder.loader.n(d.a.d((FinderMedia)localObject1), v.FKZ, null, null, 12);
      paramActivity.aqH = ((com.tencent.mm.plugin.finder.loader.n)localObject1).getPath();
      localObject2 = ((com.tencent.mm.plugin.finder.loader.n)localObject1).eCi();
      if (y.ZC((String)paramActivity.aqH))
      {
        Log.i(TAG, "image thumbPath exist, callback");
        paramBaseFinderFeed.invoke(paramActivity.aqH);
        AppMethodBeat.o(333709);
        return;
      }
      Log.i(TAG, s.X("image thumbPath not exist, download: ", localObject2));
      localObject2 = p.ExI;
      localObject1 = p.eCl().dk(localObject1);
      ((com.tencent.mm.loader.a.b)localObject1).noI = ((com.tencent.mm.loader.e.a)new c(paramBaseFinderFeed, paramActivity));
      ((com.tencent.mm.loader.a.b)localObject1).blg();
      AppMethodBeat.o(333709);
      return;
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      s.s(localObject1, "firstMedia");
      localObject1 = new com.tencent.mm.plugin.finder.loader.n(d.a.d((FinderMedia)localObject1), v.FKZ, null, null, 12);
      paramActivity.aqH = ((com.tencent.mm.plugin.finder.loader.n)localObject1).getPath();
      localObject2 = ((com.tencent.mm.plugin.finder.loader.n)localObject1).eCi();
      if (y.ZC((String)paramActivity.aqH))
      {
        Log.i(TAG, "video thumbPath exist, callback");
        paramBaseFinderFeed.invoke(paramActivity.aqH);
        AppMethodBeat.o(333709);
        return;
      }
      Log.i(TAG, s.X("video thumbPath not exist, download: ", localObject2));
      localObject2 = p.ExI;
      localObject1 = p.eCl().dk(localObject1);
      ((com.tencent.mm.loader.a.b)localObject1).noI = ((com.tencent.mm.loader.e.a)new d(paramBaseFinderFeed, paramActivity));
      ((com.tencent.mm.loader.a.b)localObject1).blg();
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderObject paramFinderObject, kotlin.g.a.b<? super String, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderFavUtil$getFeedThumbInfo$1$2", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "onImageDownload", "", "success", "", "extraObj", "", "", "(Z[Ljava/lang/Object;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.e.a
  {
    c(kotlin.g.a.b<? super String, ah> paramb, ah.f<String> paramf) {}
    
    public final void onImageDownload(boolean paramBoolean, Object... paramVarArgs)
    {
      AppMethodBeat.i(333358);
      s.u(paramVarArgs, "extraObj");
      paramVarArgs = n.Ggy;
      Log.i(n.getTAG(), s.X("image thumbPath download succ:", Boolean.valueOf(paramBoolean)));
      if (paramBoolean) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.$callback, paramActivity));
      }
      AppMethodBeat.o(333358);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(kotlin.g.a.b<? super String, ah> paramb, ah.f<String> paramf)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderFavUtil$getFeedThumbInfo$1$3", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "onImageDownload", "", "success", "", "extraObj", "", "", "(Z[Ljava/lang/Object;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.loader.e.a
  {
    d(kotlin.g.a.b<? super String, ah> paramb, ah.f<String> paramf) {}
    
    public final void onImageDownload(boolean paramBoolean, Object... paramVarArgs)
    {
      AppMethodBeat.i(333351);
      s.u(paramVarArgs, "extraObj");
      paramVarArgs = n.Ggy;
      Log.i(n.getTAG(), s.X("video thumbPath download succ:", Boolean.valueOf(paramBoolean)));
      if (paramBoolean) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.$callback, paramActivity));
      }
      AppMethodBeat.o(333351);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(kotlin.g.a.b<? super String, ah> paramb, ah.f<String> paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n
 * JD-Core Version:    0.7.0.1
 */