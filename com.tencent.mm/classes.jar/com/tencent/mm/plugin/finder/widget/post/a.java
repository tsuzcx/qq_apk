package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.e.f.h;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "checkFileExist", "", "delMedia", "", "refresh", "setMediaData", "Companion", "plugin-finder_release"})
public abstract class a
  implements b
{
  private static final String wCc = "post_location";
  private static final String wCd = "post_extend_reading";
  private static final String wCe = "post_ref_feed_info";
  private static final String wCf = "post_ref_feed_content";
  private static final String wCg = "post_from_camera";
  private static final String wCh = "POST_ORIGINAL_FLAG";
  static final String wCi = "post_long_video";
  static String wCj = "";
  public static final a wCk = new a((byte)0);
  public final Context context;
  Bundle dQL;
  azy vTz;
  cjk wCb;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void ak(Bundle paramBundle)
  {
    p.h(paramBundle, "data");
    this.dQL = paramBundle;
    Object localObject2 = paramBundle.getByteArray(wCe);
    Object localObject1 = paramBundle.getByteArray(wCf);
    if ((localObject2 != null) && (localObject1 != null))
    {
      paramBundle = (com.tencent.mm.bw.a)new azy();
      try
      {
        paramBundle.parseFrom((byte[])localObject2);
        this.vTz = ((azy)paramBundle);
        this.wCb = new cjk();
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
                localObject2 = this.wCb;
                if (localObject2 != null)
                {
                  localObject2 = ((cjk)localObject2).mediaList;
                  if (localObject2 != null)
                  {
                    c.a locala = c.vGN;
                    p.g(localObject1, "svrMedia");
                    ((LinkedList)localObject2).add(c.a.b((FinderMedia)localObject1));
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
  
  public boolean cyn()
  {
    return true;
  }
  
  public void dIX() {}
  
  public void refresh()
  {
    h.hkS();
    wCj = "";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget$Companion;", "", "()V", "POST_EXTEND_READING", "", "getPOST_EXTEND_READING", "()Ljava/lang/String;", "POST_FROM_CAMERA", "getPOST_FROM_CAMERA", "POST_LOCATION", "getPOST_LOCATION", "POST_LONG_VIDEO", "getPOST_LONG_VIDEO", "POST_ORIGINAL_FLAG", "getPOST_ORIGINAL_FLAG", "POST_REF_FEED_CONTENT", "getPOST_REF_FEED_CONTENT", "POST_REF_FEED_INFO", "getPOST_REF_FEED_INFO", "TAG", "thumbLocalUrl", "getThumbLocalUrl", "setThumbLocalUrl", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */