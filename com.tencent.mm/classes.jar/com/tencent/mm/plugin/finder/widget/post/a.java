package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "setMediaData", "", "Companion", "plugin-finder_release"})
public abstract class a
  implements b
{
  private static final String tet = "post_location";
  private static final String teu = "post_extend_reading";
  private static final String tev = "post_ref_feed_info";
  private static final String tew = "post_ref_feed_content";
  private static final String tex = "post_from_camera";
  private static final String tey = "POST_ORIGINAL_FLAG";
  public static final a tez = new a((byte)0);
  final Context context;
  Bundle dxT;
  aqb ter;
  bve tes;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void ae(Bundle paramBundle)
  {
    p.h(paramBundle, "data");
    this.dxT = paramBundle;
    Object localObject2 = paramBundle.getByteArray(tev);
    Object localObject1 = paramBundle.getByteArray(tew);
    if ((localObject2 != null) && (localObject1 != null))
    {
      paramBundle = (com.tencent.mm.bx.a)new aqb();
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.ter = ((aqb)paramBundle);
        this.tes = new bve();
        paramBundle = (com.tencent.mm.bx.a)new FinderObjectDesc();
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle.parseFrom((byte[])localObject1);
          paramBundle = (FinderObjectDesc)paramBundle;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.media;
            if (paramBundle != null)
            {
              paramBundle = ((Iterable)paramBundle).iterator();
              while (paramBundle.hasNext())
              {
                localObject1 = (FinderMedia)paramBundle.next();
                localObject2 = this.tes;
                if (localObject2 != null)
                {
                  localObject2 = ((bve)localObject2).mediaList;
                  if (localObject2 != null)
                  {
                    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
                    int i = ((FinderMedia)localObject1).mediaType;
                    p.g(localObject1, "svrMedia");
                    ((LinkedList)localObject2).add(b.a.a(i, (FinderMedia)localObject1));
                    continue;
                    paramBundle = paramBundle;
                    ad.l("safeParser", "", new Object[] { paramBundle });
                    paramBundle = null;
                  }
                }
              }
            }
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget$Companion;", "", "()V", "POST_EXTEND_READING", "", "getPOST_EXTEND_READING", "()Ljava/lang/String;", "POST_FROM_CAMERA", "getPOST_FROM_CAMERA", "POST_LOCATION", "getPOST_LOCATION", "POST_ORIGINAL_FLAG", "getPOST_ORIGINAL_FLAG", "POST_REF_FEED_CONTENT", "getPOST_REF_FEED_CONTENT", "POST_REF_FEED_INFO", "getPOST_REF_FEED_INFO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */