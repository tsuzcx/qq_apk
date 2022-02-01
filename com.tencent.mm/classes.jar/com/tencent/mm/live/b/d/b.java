package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.e.c;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "merge", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b
{
  public static final b FwG;
  
  static
  {
    AppMethodBeat.i(202799);
    FwG = new b();
    AppMethodBeat.o(202799);
  }
  
  private static void a(eat parameat)
  {
    AppMethodBeat.i(202796);
    if (!bt.isNullOrNil(parameat.fvv))
    {
      String str = parameat.fvv;
      k.g(str, "liveMessage.headimgurl");
      if (!n.mB(str, "/0")) {
        parameat.fvv += "/0";
      }
    }
    AppMethodBeat.o(202796);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends eat> paramList, String paramString)
  {
    AppMethodBeat.i(202795);
    k.h(paramArrayList, "local");
    k.h(paramList, "remote");
    k.h(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)dv(paramList));
      AppMethodBeat.o(202795);
      return;
    }
    int i = 0;
    int k = ((a)j.iA((List)paramArrayList)).tGD;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (eat)localIterator.next();
      int j = i;
      if (((eat)localObject).Lzj > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!k.g(((eat)localObject).Lzi, paramString))
        {
          localObject = b((eat)localObject);
          i = j;
          if (localObject != null)
          {
            paramArrayList.add(localObject);
            i = j;
          }
        }
      }
    }
    if (paramList.size() - paramArrayList.size() > 10)
    {
      paramArrayList.clear();
      paramArrayList.addAll((Collection)dv(paramList));
    }
    AppMethodBeat.o(202795);
  }
  
  private static a b(eat parameat)
  {
    AppMethodBeat.i(202797);
    a(parameat);
    int i = parameat.CJZ;
    Object localObject = e.c.qYs;
    CharSequence localCharSequence;
    if (i == e.c.emb())
    {
      localObject = parameat.content;
      localObject = ((f)g.ab(f.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject != null)
      {
        localCharSequence = n.trim((CharSequence)localObject);
        if (localCharSequence != null) {}
      }
      else
      {
        AppMethodBeat.o(202797);
        return null;
      }
      i = n.a(localCharSequence, "：", 0, false, 6);
      if (i > 0)
      {
        localObject = localCharSequence.subSequence(0, i).toString();
        localCharSequence = localCharSequence.subSequence(i + 1, localCharSequence.length());
      }
    }
    for (;;)
    {
      String str = parameat.fvv;
      k.g(str, "liveMessage.headimgurl");
      parameat = new a((String)localObject, str, localCharSequence, parameat.CJZ, parameat.Lzj);
      AppMethodBeat.o(202797);
      return parameat;
      localObject = "";
      continue;
      localObject = parameat.content;
      k.g(localObject, "liveMessage.content");
      if (localObject == null)
      {
        parameat = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(202797);
        throw parameat;
      }
      localCharSequence = (CharSequence)n.trim((CharSequence)localObject).toString();
      localObject = parameat.Lzi;
      k.g(localObject, "liveMessage.identity_id");
    }
  }
  
  private static List<a> dv(List<? extends eat> paramList)
  {
    AppMethodBeat.i(202798);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((eat)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(202798);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.d.b
 * JD-Core Version:    0.7.0.1
 */