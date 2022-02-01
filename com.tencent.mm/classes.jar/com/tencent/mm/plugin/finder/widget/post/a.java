package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "setMediaData", "", "Companion", "plugin-finder_release"})
public abstract class a
  implements b
{
  private static final String LlM = "POST_ORIGINAL_FLAG";
  private static final String qZU = "post_location";
  private static final String qZV = "post_extend_reading";
  private static final String qZW = "post_ref_feed_info";
  private static final String qZX = "post_ref_feed_content";
  private static final String qZY = "post_from_camera";
  public static final a qZZ = new a((byte)0);
  final Context context;
  Bundle dow;
  akf qOO;
  bmc qZS;
  
  static
  {
    qZU = "post_location";
    qZV = "post_extend_reading";
    qZW = "post_ref_feed_info";
    qZX = "post_ref_feed_content";
    qZY = "post_from_camera";
  }
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void Y(Bundle paramBundle)
  {
    k.h(paramBundle, "data");
    this.dow = paramBundle;
    Object localObject2 = paramBundle.getByteArray(qZW);
    Object localObject1 = paramBundle.getByteArray(qZX);
    if ((localObject2 != null) && (localObject1 != null))
    {
      paramBundle = (com.tencent.mm.bx.a)new akf();
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.qOO = ((akf)paramBundle);
        this.qZS = new bmc();
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
                localObject2 = this.qZS;
                if (localObject2 != null)
                {
                  localObject2 = ((bmc)localObject2).mediaList;
                  if (localObject2 != null)
                  {
                    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
                    int i = ((FinderMedia)localObject1).mediaType;
                    k.g(localObject1, "svrMedia");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget$Companion;", "", "()V", "POST_EXTEND_READING", "", "getPOST_EXTEND_READING", "()Ljava/lang/String;", "POST_FROM_CAMERA", "getPOST_FROM_CAMERA", "POST_LOCATION", "getPOST_LOCATION", "POST_ORIGINAL_FLAG", "getPOST_ORIGINAL_FLAG", "POST_REF_FEED_CONTENT", "getPOST_REF_FEED_CONTENT", "POST_REF_FEED_INFO", "getPOST_REF_FEED_INFO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */