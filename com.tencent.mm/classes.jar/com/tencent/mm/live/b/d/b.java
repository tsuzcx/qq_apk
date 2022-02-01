package com.tencent.mm.live.b.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.f.c;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"})
public final class b
{
  public static final b gTR;
  
  static
  {
    AppMethodBeat.i(215906);
    gTR = new b();
    AppMethodBeat.o(215906);
  }
  
  private static List<a> Z(List<? extends bvm> paramList)
  {
    AppMethodBeat.i(215905);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((bvm)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(215905);
    return paramList;
  }
  
  private static void a(bvm parambvm)
  {
    AppMethodBeat.i(215903);
    if (!bu.isNullOrNil(parambvm.fUv))
    {
      String str = parambvm.fUv;
      p.g(str, "liveMessage.headimgurl");
      if (!n.nG(str, "/0")) {
        parambvm.fUv += "/0";
      }
    }
    AppMethodBeat.o(215903);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends bvm> paramList, String paramString)
  {
    AppMethodBeat.i(215901);
    p.h(paramArrayList, "local");
    p.h(paramList, "remote");
    p.h(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)Z(paramList));
      i(paramArrayList);
      AppMethodBeat.o(215901);
      return;
    }
    int i = 0;
    int k = ((a)j.jn((List)paramArrayList)).heF;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bvm)localIterator.next();
      int j = i;
      if (((bvm)localObject).Hip > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!p.i(((bvm)localObject).Hio, paramString))
        {
          localObject = b((bvm)localObject);
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
    AppMethodBeat.o(215901);
  }
  
  private static a b(bvm parambvm)
  {
    AppMethodBeat.i(215904);
    a(parambvm);
    int i = parambvm.GaV;
    Object localObject = f.c.gPJ;
    CharSequence localCharSequence;
    if (i == f.c.ann())
    {
      localObject = parambvm.content;
      localObject = ((e)g.ab(e.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject != null)
      {
        localCharSequence = n.trim((CharSequence)localObject);
        if (localCharSequence != null) {}
      }
      else
      {
        AppMethodBeat.o(215904);
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
      String str = parambvm.fUv;
      p.g(str, "liveMessage.headimgurl");
      parambvm = new a((String)localObject, str, localCharSequence, parambvm.GaV, parambvm.Hip);
      AppMethodBeat.o(215904);
      return parambvm;
      localObject = "";
      continue;
      localObject = parambvm.content;
      p.g(localObject, "liveMessage.content");
      if (localObject == null)
      {
        parambvm = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(215904);
        throw parambvm;
      }
      localCharSequence = (CharSequence)n.trim((CharSequence)localObject).toString();
      localObject = parambvm.Hio;
      p.g(localObject, "liveMessage.identity_id");
    }
  }
  
  private static void i(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(215902);
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
    AppMethodBeat.o(215902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.d.b
 * JD-Core Version:    0.7.0.1
 */