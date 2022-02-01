package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hw;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.convert.i;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.data.f.b;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "downContinue", "", "Ljava/lang/Boolean;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadCallbackListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "notLoadAnyMore", "scene", "", "getScene", "()I", "setScene", "(I)V", "tabType", "viewCallback", "bindData", "", "getCommentFromCache", "", "loadData", "onAttach", "callback", "onDetach", "releaseListener", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements a<e>
{
  public static final a ATN;
  public final WxRecyclerAdapter<t> ALE;
  private e ATO;
  public IListener<hw> ATP;
  private Boolean ATQ;
  public boolean ATR;
  final Context context;
  public ArrayList<t> data;
  public FeedData feed;
  public int hJx;
  public boolean isLoading;
  private b lastBuffer;
  private int scene;
  
  static
  {
    AppMethodBeat.i(362794);
    ATN = new a((byte)0);
    AppMethodBeat.o(362794);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(362765);
    this.context = paramContext;
    this.scene = 2;
    this.data = new ArrayList();
    this.ALE = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new b(this), this.data);
    this.ATQ = Boolean.TRUE;
    AppMethodBeat.o(362765);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(362816);
    s.u(parame, "callback");
    this.ATO = parame;
    e locale = this.ATO;
    parame = locale;
    if (locale == null)
    {
      s.bIx("viewCallback");
      parame = null;
    }
    parame.initView();
    AppMethodBeat.o(362816);
  }
  
  public final List<t> ebP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(362800);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.f.FMT;
    Object localObject3 = this.feed;
    s.checkNotNull(localObject3);
    localObject3 = ((com.tencent.mm.plugin.finder.storage.data.f)localObject1).qj(((FeedData)localObject3).getId());
    if (localObject3 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.data.f.FMT;
      Object localObject4 = this.feed;
      s.checkNotNull(localObject4);
      localObject4 = ((com.tencent.mm.plugin.finder.storage.data.f)localObject1).ax(((FeedData)localObject4).getId(), 0L);
      if (localObject4 == null)
      {
        localObject1 = null;
        this.lastBuffer = ((b)localObject1);
        if (localObject4 != null) {
          break label171;
        }
      }
      label171:
      for (localObject1 = localObject2;; localObject1 = Boolean.valueOf(((f.b)localObject4).AUp))
      {
        this.ATQ = ((Boolean)localObject1);
        localObject2 = (Iterable)localObject3;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new t((au)((Iterator)localObject2).next()));
        }
        localObject1 = ((f.b)localObject4).lastBuffer;
        break;
      }
      localArrayList.addAll((Collection)localObject1);
      this.isLoading = false;
      this.ALE.bZE.notifyChanged();
    }
    localObject1 = (List)localArrayList;
    AppMethodBeat.o(362800);
    return localObject1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362824);
    releaseListener();
    AppMethodBeat.o(362824);
  }
  
  public final void releaseListener()
  {
    AppMethodBeat.i(362808);
    IListener localIListener = this.ATP;
    if (localIListener != null) {
      localIListener.dead();
    }
    this.ATP = null;
    this.isLoading = false;
    AppMethodBeat.o(362808);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$Companion;", "", "()V", "TAG", "", "initSwitch", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(d paramd) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(363512);
      Object localObject = t.ECt;
      if (paramInt == t.eDj())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new i(this.ATS.context);
        AppMethodBeat.o(363512);
        return localObject;
      }
      localObject = t.ECt;
      if (paramInt == t.eDk())
      {
        localObject = (com.tencent.mm.view.recyclerview.f)new i(this.ATS.context);
        AppMethodBeat.o(363512);
        return localObject;
      }
      localObject = av.GiL;
      av.eY("Finder.FinderBulletSubtitlePresenter", paramInt);
      localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
      AppMethodBeat.o(363512);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d
 * JD-Core Version:    0.7.0.1
 */