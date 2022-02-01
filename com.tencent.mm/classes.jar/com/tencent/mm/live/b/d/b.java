package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.l.c;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.protocal.protobuf.crs;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b
{
  public static final b kyI;
  
  static
  {
    AppMethodBeat.i(197144);
    kyI = new b();
    AppMethodBeat.o(197144);
  }
  
  private static void a(crs paramcrs)
  {
    AppMethodBeat.i(197129);
    if (!Util.isNullOrNil(paramcrs.jjF))
    {
      String str = paramcrs.jjF;
      p.j(str, "liveMessage.headimgurl");
      if (!n.pu(str, "/0")) {
        paramcrs.jjF += "/0";
      }
    }
    AppMethodBeat.o(197129);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends crs> paramList, String paramString)
  {
    AppMethodBeat.i(197124);
    p.k(paramArrayList, "local");
    p.k(paramList, "remote");
    p.k(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)af(paramList));
      m(paramArrayList);
      AppMethodBeat.o(197124);
      return;
    }
    int i = 0;
    int k = ((a)j.lq((List)paramArrayList)).time;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (crs)localIterator.next();
      int j = i;
      if (((crs)localObject).TyM > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!p.h(((crs)localObject).TyL, paramString))
        {
          localObject = b((crs)localObject);
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
      paramArrayList.addAll((Collection)af(paramList));
    }
    m(paramArrayList);
    AppMethodBeat.o(197124);
  }
  
  private static List<a> af(List<? extends crs> paramList)
  {
    AppMethodBeat.i(197142);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((crs)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(197142);
    return paramList;
  }
  
  private static a b(crs paramcrs)
  {
    AppMethodBeat.i(197138);
    a(paramcrs);
    int i = paramcrs.msg_type;
    Object localObject = l.c.kuq;
    CharSequence localCharSequence;
    if (i == l.c.aNF())
    {
      localObject = paramcrs.content;
      localObject = ((e)h.ae(e.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject != null)
      {
        localCharSequence = n.bb((CharSequence)localObject);
        if (localCharSequence != null) {}
      }
      else
      {
        AppMethodBeat.o(197138);
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
      String str = paramcrs.jjF;
      p.j(str, "liveMessage.headimgurl");
      paramcrs = new a((String)localObject, str, localCharSequence, paramcrs.msg_type, paramcrs.TyM);
      AppMethodBeat.o(197138);
      return paramcrs;
      localObject = "";
      continue;
      localObject = paramcrs.content;
      p.j(localObject, "liveMessage.content");
      if (localObject == null)
      {
        paramcrs = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(197138);
        throw paramcrs;
      }
      localCharSequence = (CharSequence)n.bb((CharSequence)localObject).toString();
      localObject = paramcrs.TyL;
      p.j(localObject, "liveMessage.identity_id");
    }
  }
  
  private static void m(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(197125);
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
    AppMethodBeat.o(197125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.d.b
 * JD-Core Version:    0.7.0.1
 */