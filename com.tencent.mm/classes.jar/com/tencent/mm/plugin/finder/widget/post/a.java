package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "setMediaData", "", "Companion", "plugin-finder_release"})
public abstract class a
  implements b
{
  private static final String shX = "post_location";
  private static final String shY = "post_extend_reading";
  private static final String shZ = "post_ref_feed_info";
  private static final String sia = "post_ref_feed_content";
  private static final String sib = "post_from_camera";
  private static final String sic = "POST_ORIGINAL_FLAG";
  public static final a.a sid = new a.a((byte)0);
  final Context context;
  Bundle dmf;
  amq shV;
  bqr shW;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void ab(Bundle paramBundle)
  {
    k.h(paramBundle, "data");
    this.dmf = paramBundle;
    Object localObject2 = paramBundle.getByteArray(shZ);
    Object localObject1 = paramBundle.getByteArray(sia);
    if ((localObject2 != null) && (localObject1 != null))
    {
      paramBundle = (com.tencent.mm.bw.a)new amq();
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.shV = ((amq)paramBundle);
        this.shW = new bqr();
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
                localObject2 = this.shW;
                if (localObject2 != null)
                {
                  localObject2 = ((bqr)localObject2).mediaList;
                  if (localObject2 != null)
                  {
                    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
                    int i = ((FinderMedia)localObject1).mediaType;
                    k.g(localObject1, "svrMedia");
                    ((LinkedList)localObject2).add(b.a.a(i, (FinderMedia)localObject1));
                    continue;
                    paramBundle = paramBundle;
                    ac.l("safeParser", "", new Object[] { paramBundle });
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
            ac.l("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */