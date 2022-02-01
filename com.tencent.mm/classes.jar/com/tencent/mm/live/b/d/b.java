package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.f.c;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b
{
  public static final b gxy;
  
  static
  {
    AppMethodBeat.i(190000);
    gxy = new b();
    AppMethodBeat.o(190000);
  }
  
  private static List<a> Y(List<? extends bqf> paramList)
  {
    AppMethodBeat.i(189999);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((bqf)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(189999);
    return paramList;
  }
  
  private static void a(bqf parambqf)
  {
    AppMethodBeat.i(189997);
    if (!bs.isNullOrNil(parambqf.fzc))
    {
      String str = parambqf.fzc;
      k.g(str, "liveMessage.headimgurl");
      if (!n.nc(str, "/0")) {
        parambqf.fzc += "/0";
      }
    }
    AppMethodBeat.o(189997);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends bqf> paramList, String paramString)
  {
    AppMethodBeat.i(189995);
    k.h(paramArrayList, "local");
    k.h(paramList, "remote");
    k.h(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)Y(paramList));
      i(paramArrayList);
      AppMethodBeat.o(189995);
      return;
    }
    int i = 0;
    int k = ((a)j.iQ((List)paramArrayList)).gIh;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bqf)localIterator.next();
      int j = i;
      if (((bqf)localObject).Ffj > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!k.g(((bqf)localObject).Ffi, paramString))
        {
          localObject = b((bqf)localObject);
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
      paramArrayList.addAll((Collection)Y(paramList));
    }
    i(paramArrayList);
    AppMethodBeat.o(189995);
  }
  
  private static a b(bqf parambqf)
  {
    AppMethodBeat.i(189998);
    a(parambqf);
    int i = parambqf.EcB;
    Object localObject = f.c.gtp;
    CharSequence localCharSequence;
    if (i == f.c.akm())
    {
      localObject = parambqf.content;
      localObject = ((f)g.ab(f.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject != null)
      {
        localCharSequence = n.trim((CharSequence)localObject);
        if (localCharSequence != null) {}
      }
      else
      {
        AppMethodBeat.o(189998);
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
      String str = parambqf.fzc;
      k.g(str, "liveMessage.headimgurl");
      parambqf = new a((String)localObject, str, localCharSequence, parambqf.EcB, parambqf.Ffj);
      AppMethodBeat.o(189998);
      return parambqf;
      localObject = "";
      continue;
      localObject = parambqf.content;
      k.g(localObject, "liveMessage.content");
      if (localObject == null)
      {
        parambqf = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(189998);
        throw parambqf;
      }
      localCharSequence = (CharSequence)n.trim((CharSequence)localObject).toString();
      localObject = parambqf.Ffi;
      k.g(localObject, "liveMessage.identity_id");
    }
  }
  
  private static void i(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(189996);
    if (paramArrayList.size() > 3000)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = paramArrayList.size();
      while (i < j - 3000)
      {
        localArrayList.add(paramArrayList.get(i));
        i += 1;
      }
      paramArrayList.removeAll((Collection)localArrayList);
    }
    AppMethodBeat.o(189996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.d.b
 * JD-Core Version:    0.7.0.1
 */