package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "setMediaData", "", "Companion", "plugin-finder_release"})
public abstract class a
  implements b
{
  private static final String tpm = "post_location";
  private static final String tpn = "post_extend_reading";
  private static final String tpo = "post_ref_feed_info";
  private static final String tpp = "post_ref_feed_content";
  private static final String tpq = "post_from_camera";
  private static final String tpr = "POST_ORIGINAL_FLAG";
  public static final a tps = new a((byte)0);
  final Context context;
  Bundle dyY;
  aqq tpk;
  bvy tpl;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void af(Bundle paramBundle)
  {
    p.h(paramBundle, "data");
    this.dyY = paramBundle;
    Object localObject2 = paramBundle.getByteArray(tpo);
    Object localObject1 = paramBundle.getByteArray(tpp);
    if ((localObject2 != null) && (localObject1 != null))
    {
      paramBundle = (com.tencent.mm.bw.a)new aqq();
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.tpk = ((aqq)paramBundle);
        this.tpl = new bvy();
        paramBundle = (com.tencent.mm.bw.a)new FinderObjectDesc();
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
                localObject2 = this.tpl;
                if (localObject2 != null)
                {
                  localObject2 = ((bvy)localObject2).mediaList;
                  if (localObject2 != null)
                  {
                    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
                    int i = ((FinderMedia)localObject1).mediaType;
                    p.g(localObject1, "svrMedia");
                    ((LinkedList)localObject2).add(b.a.a(i, (FinderMedia)localObject1));
                    continue;
                    paramBundle = paramBundle;
                    ae.l("safeParser", "", new Object[] { paramBundle });
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
            ae.l("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget$Companion;", "", "()V", "POST_EXTEND_READING", "", "getPOST_EXTEND_READING", "()Ljava/lang/String;", "POST_FROM_CAMERA", "getPOST_FROM_CAMERA", "POST_LOCATION", "getPOST_LOCATION", "POST_ORIGINAL_FLAG", "getPOST_ORIGINAL_FLAG", "POST_REF_FEED_CONTENT", "getPOST_REF_FEED_CONTENT", "POST_REF_FEED_INFO", "getPOST_REF_FEED_INFO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */