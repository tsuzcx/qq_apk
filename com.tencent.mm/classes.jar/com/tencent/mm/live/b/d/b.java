package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.o.d;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b
{
  public static final b hLo;
  
  static
  {
    AppMethodBeat.i(207865);
    hLo = new b();
    AppMethodBeat.o(207865);
  }
  
  private static void a(cix paramcix)
  {
    AppMethodBeat.i(207862);
    if (!Util.isNullOrNil(paramcix.gzC))
    {
      String str = paramcix.gzC;
      p.g(str, "liveMessage.headimgurl");
      if (!n.K(str, "/0", false)) {
        paramcix.gzC += "/0";
      }
    }
    AppMethodBeat.o(207862);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends cix> paramList, String paramString)
  {
    AppMethodBeat.i(207860);
    p.h(paramArrayList, "local");
    p.h(paramList, "remote");
    p.h(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)ah(paramList));
      m(paramArrayList);
      AppMethodBeat.o(207860);
      return;
    }
    int i = 0;
    int k = ((a)j.ku((List)paramArrayList)).hXs;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (cix)localIterator.next();
      int j = i;
      if (((cix)localObject).MnS > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!p.j(((cix)localObject).MnR, paramString))
        {
          localObject = b((cix)localObject);
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
      paramArrayList.addAll((Collection)ah(paramList));
    }
    m(paramArrayList);
    AppMethodBeat.o(207860);
  }
  
  private static List<a> ah(List<? extends cix> paramList)
  {
    AppMethodBeat.i(207864);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((cix)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(207864);
    return paramList;
  }
  
  private static a b(cix paramcix)
  {
    AppMethodBeat.i(207863);
    a(paramcix);
    int i = paramcix.ybm;
    Object localObject = o.d.hGL;
    CharSequence localCharSequence;
    if (i == o.d.aFz())
    {
      localObject = paramcix.content;
      localObject = ((e)g.af(e.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject != null)
      {
        localCharSequence = n.trim((CharSequence)localObject);
        if (localCharSequence != null) {}
      }
      else
      {
        AppMethodBeat.o(207863);
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
      String str = paramcix.gzC;
      p.g(str, "liveMessage.headimgurl");
      paramcix = new a((String)localObject, str, localCharSequence, paramcix.ybm, paramcix.MnS);
      AppMethodBeat.o(207863);
      return paramcix;
      localObject = "";
      continue;
      localObject = paramcix.content;
      p.g(localObject, "liveMessage.content");
      if (localObject == null)
      {
        paramcix = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(207863);
        throw paramcix;
      }
      localCharSequence = (CharSequence)n.trim((CharSequence)localObject).toString();
      localObject = paramcix.MnR;
      p.g(localObject, "liveMessage.identity_id");
    }
  }
  
  private static void m(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(207861);
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
    AppMethodBeat.o(207861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.d.b
 * JD-Core Version:    0.7.0.1
 */