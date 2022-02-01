package com.tencent.mm.plugin.finder.widget.post;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/IPostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "context", "getContext", "()Landroid/content/Context;", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;)V", "checkFileExist", "", "delMedia", "", "refresh", "setMediaData", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements b
{
  public static final a GZB = new a((byte)0);
  private static String GZE = "";
  private final j ETb;
  private brq GZC;
  private djh GZD;
  private final Context context;
  private Bundle hPH;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.ETb = k.cm((kotlin.g.a.a)new b(paramContext));
  }
  
  public final void av(Bundle paramBundle)
  {
    s.u(paramBundle, "data");
    this.hPH = paramBundle;
  }
  
  public void bDL()
  {
    Log.i("PostMediaWidget", "refresh thumbLocalUrl");
    GZE = "";
  }
  
  public boolean dqm()
  {
    return true;
  }
  
  protected final c eHl()
  {
    return (c)this.ETb.getValue();
  }
  
  public void fqA() {}
  
  protected final Bundle fqx()
  {
    return this.hPH;
  }
  
  protected final brq fqy()
  {
    return this.GZC;
  }
  
  protected final djh fqz()
  {
    return this.GZD;
  }
  
  protected final Context getContext()
  {
    return this.context;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget$Companion;", "", "()V", "TAG", "", "thumbLocalUrl", "getThumbLocalUrl", "()Ljava/lang/String;", "setThumbLocalUrl", "(Ljava/lang/String;)V", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<c>
  {
    b(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.a
 * JD-Core Version:    0.7.0.1
 */