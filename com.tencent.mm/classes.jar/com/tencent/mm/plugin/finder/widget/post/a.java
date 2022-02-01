package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.d.f.h;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "checkFileExist", "", "delMedia", "", "refresh", "setMediaData", "Companion", "plugin-finder_release"})
public abstract class a
  implements b
{
  private static final String BsK = "post_location";
  private static final String BsL = "post_extend_reading";
  private static final String BsM = "post_ref_feed_info";
  private static final String BsN = "post_ref_feed_content";
  private static final String BsO = "post_from_camera";
  private static final String BsP = "POST_ORIGINAL_FLAG";
  private static final String BsQ = "post_long_video";
  private static String BsR = "";
  public static final a BsS = new a((byte)0);
  bge ABc;
  private csf BsJ;
  final Context context;
  private Bundle fKb;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void ad(Bundle paramBundle)
  {
    p.k(paramBundle, "data");
    this.fKb = paramBundle;
    Object localObject2 = paramBundle.getByteArray(BsM);
    Object localObject1 = paramBundle.getByteArray(BsN);
    if ((localObject2 != null) && (localObject1 != null))
    {
      paramBundle = (com.tencent.mm.cd.a)new bge();
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.ABc = ((bge)paramBundle);
        this.BsJ = new csf();
        paramBundle = (com.tencent.mm.cd.a)new FinderObjectDesc();
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
                localObject2 = this.BsJ;
                if (localObject2 != null)
                {
                  localObject2 = ((csf)localObject2).mediaList;
                  if (localObject2 != null)
                  {
                    c.a locala = c.AnK;
                    p.j(localObject1, "svrMedia");
                    ((LinkedList)localObject2).add(c.a.d((FinderMedia)localObject1));
                    continue;
                    paramBundle = paramBundle;
                    Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
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
            Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
          }
        }
      }
    }
  }
  
  public void bfU()
  {
    h.ioq();
    BsR = "";
  }
  
  public boolean cMI()
  {
    return true;
  }
  
  protected final csf emo()
  {
    return this.BsJ;
  }
  
  public void emp() {}
  
  protected final Bundle getData()
  {
    return this.fKb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget$Companion;", "", "()V", "POST_EXTEND_READING", "", "getPOST_EXTEND_READING", "()Ljava/lang/String;", "POST_FROM_CAMERA", "getPOST_FROM_CAMERA", "POST_LOCATION", "getPOST_LOCATION", "POST_LONG_VIDEO", "getPOST_LONG_VIDEO", "POST_ORIGINAL_FLAG", "getPOST_ORIGINAL_FLAG", "POST_REF_FEED_CONTENT", "getPOST_REF_FEED_CONTENT", "POST_REF_FEED_INFO", "getPOST_REF_FEED_INFO", "TAG", "thumbLocalUrl", "getThumbLocalUrl", "setThumbLocalUrl", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */