package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.f.c;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b
{
  public static final b gRj;
  
  static
  {
    AppMethodBeat.i(212286);
    gRj = new b();
    AppMethodBeat.o(212286);
  }
  
  private static List<a> Z(List<? extends bus> paramList)
  {
    AppMethodBeat.i(212285);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((bus)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(212285);
    return paramList;
  }
  
  private static void a(bus parambus)
  {
    AppMethodBeat.i(212283);
    if (!bt.isNullOrNil(parambus.fSp))
    {
      String str = parambus.fSp;
      p.g(str, "liveMessage.headimgurl");
      if (!n.nA(str, "/0")) {
        parambus.fSp += "/0";
      }
    }
    AppMethodBeat.o(212283);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends bus> paramList, String paramString)
  {
    AppMethodBeat.i(212281);
    p.h(paramArrayList, "local");
    p.h(paramList, "remote");
    p.h(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)Z(paramList));
      i(paramArrayList);
      AppMethodBeat.o(212281);
      return;
    }
    int i = 0;
    int k = ((a)j.je((List)paramArrayList)).hbR;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bus)localIterator.next();
      int j = i;
      if (((bus)localObject).GON > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!p.i(((bus)localObject).GOM, paramString))
        {
          localObject = b((bus)localObject);
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
      paramArrayList.addAll((Collection)Z(paramList));
    }
    i(paramArrayList);
    AppMethodBeat.o(212281);
  }
  
  private static a b(bus parambus)
  {
    AppMethodBeat.i(212284);
    a(parambus);
    int i = parambus.FIy;
    Object localObject = f.c.gNa;
    CharSequence localCharSequence;
    if (i == f.c.amY())
    {
      localObject = parambus.content;
      localObject = ((e)g.ab(e.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject != null)
      {
        localCharSequence = n.trim((CharSequence)localObject);
        if (localCharSequence != null) {}
      }
      else
      {
        AppMethodBeat.o(212284);
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
      String str = parambus.fSp;
      p.g(str, "liveMessage.headimgurl");
      parambus = new a((String)localObject, str, localCharSequence, parambus.FIy, parambus.GON);
      AppMethodBeat.o(212284);
      return parambus;
      localObject = "";
      continue;
      localObject = parambus.content;
      p.g(localObject, "liveMessage.content");
      if (localObject == null)
      {
        parambus = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(212284);
        throw parambus;
      }
      localCharSequence = (CharSequence)n.trim((CharSequence)localObject).toString();
      localObject = parambus.GOM;
      p.g(localObject, "liveMessage.identity_id");
    }
  }
  
  private static void i(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(212282);
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
    AppMethodBeat.o(212282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.d.b
 * JD-Core Version:    0.7.0.1
 */