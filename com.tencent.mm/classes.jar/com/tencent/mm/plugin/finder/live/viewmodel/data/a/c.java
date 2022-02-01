package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.d.a.a.a.b.b.c;
import com.tencent.d.a.a.a.b.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.j;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxBulletStore;", "", "()V", "MAX_WAIT_SIZE", "", "TAG", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "listener", "Lkotlin/Function0;", "", "getListener", "()Lkotlin/jvm/functions/Function0;", "setListener", "(Lkotlin/jvm/functions/Function0;)V", "publicWaittingComments", "Lkotlin/collections/ArrayDeque;", "Lcom/tencent/mm/protocal/protobuf/BoxBulletComment;", "waittingComments", "Ljava/util/concurrent/ConcurrentHashMap;", "checkString", "", "str", "consume", "", "tag", "boxId", "maxSize", "maintainQueue", "deque", "newComments", "offerN", "n", "from", "to", "", "produce", "comments", "wxRemoveIf", "E", "filter", "Lkotlin/Function1;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private a<ah> EhB;
  private final int Ehv;
  private final String TAG;
  private final ConcurrentHashMap<String, j<anb>> akgb;
  private final j<anb> akgc;
  public com.tencent.mm.bx.b lastBuffer;
  
  public c()
  {
    AppMethodBeat.i(371666);
    this.TAG = "Finder.BoxBulletStore";
    this.Ehv = 200;
    this.akgb = new ConcurrentHashMap();
    this.akgc = new j();
    AppMethodBeat.o(371666);
  }
  
  private static void a(j<anb> paramj, List<? extends anb> paramList, int paramInt)
  {
    AppMethodBeat.i(371676);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      paramj.hr((anb)paramList.next());
    }
    int j = paramj.size() - paramInt;
    paramInt = 0;
    if (j > 0)
    {
      int i;
      do
      {
        i = paramInt + 1;
        paramj.kkV();
        paramInt = i;
      } while (i < j);
    }
    AppMethodBeat.o(371676);
  }
  
  private static <E> void a(j<E> paramj, kotlin.g.a.b<? super E, Boolean> paramb)
  {
    AppMethodBeat.i(371670);
    s.u(paramj, "<this>");
    s.u(paramb, "filter");
    Iterator localIterator = ((Iterable)paramj).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((Boolean)paramb.invoke(localObject)).booleanValue());
    for (paramb = localObject;; paramb = null)
    {
      if (paramb != null) {
        paramj.remove(paramb);
      }
      AppMethodBeat.o(371670);
      return;
    }
  }
  
  private static boolean ayw(String paramString)
  {
    AppMethodBeat.i(371682);
    if (paramString != null)
    {
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; (i == 0) && (!n.bp((CharSequence)paramString)); i = 0)
      {
        AppMethodBeat.o(371682);
        return true;
      }
    }
    AppMethodBeat.o(371682);
    return false;
  }
  
  public final void ac(String paramString, List<? extends anb> paramList)
  {
    AppMethodBeat.i(371699);
    s.u(paramList, "comments");
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label60;
      }
    }
    label60:
    for (localObject = this.akgc;; localObject = (j)this.akgb.get(paramString))
    {
      if (localObject != null) {
        break label76;
      }
      AppMethodBeat.o(371699);
      return;
      i = 0;
      break;
    }
    label76:
    boolean bool = ((j)localObject).isEmpty();
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      anb localanb = (anb)localIterator.next();
      if (localanb.ZmE == 1)
      {
        Log.i(this.TAG, "remove if id:" + localanb.id + ", username:" + localanb.username + "; before waitting:" + ((j)localObject).size());
        a((j)localObject, (kotlin.g.a.b)new a(localanb));
        Log.i(this.TAG, s.X("remove if afterwaitting:", Integer.valueOf(((j)localObject).size())));
      }
      else if ((ayw(localanb.nickname)) && (ayw(localanb.msg)))
      {
        i = localanb.ZmD;
        b.c.a locala = b.c.ahoe;
        if (i != b.c.a.jVV()) {
          localList1.add(localanb);
        } else {
          localList2.add(localanb);
        }
      }
    }
    a((j)localObject, localList2, this.Ehv);
    Log.i(this.TAG, "waittingBulletComments, add comments:" + paramList.size() + ", afterSize:" + ((j)localObject).size());
    Log.i(this.TAG, "box:" + paramString + ", produce, friends:" + p.a((Iterable)localList1, null, null, null, 0, null, (kotlin.g.a.b)b.akge, 31) + ",normal:" + p.a((Iterable)localList2, null, null, null, 0, null, (kotlin.g.a.b)c.akgf, 31));
    if ((bool) && (!((j)localObject).isEmpty()))
    {
      paramString = this.EhB;
      if (paramString != null) {
        paramString.invoke();
      }
    }
    AppMethodBeat.o(371699);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "local", "Lcom/tencent/mm/protocal/protobuf/BoxBulletComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<anb, Boolean>
  {
    a(anb paramanb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BoxBulletComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<anb, CharSequence>
  {
    public static final b akge;
    
    static
    {
      AppMethodBeat.i(371627);
      akge = new b();
      AppMethodBeat.o(371627);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BoxBulletComment;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<anb, CharSequence>
  {
    public static final c akgf;
    
    static
    {
      AppMethodBeat.i(371621);
      akgf = new c();
      AppMethodBeat.o(371621);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.c
 * JD-Core Version:    0.7.0.1
 */