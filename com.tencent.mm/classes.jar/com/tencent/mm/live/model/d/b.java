package com.tencent.mm.live.model.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.model.l.c;
import com.tencent.mm.live.view.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/util/LiveMessageMergeUtil;", "", "()V", "MAX_MSG_COUNT", "", "checkHeadImgUrl", "", "liveMessage", "Lcom/tencent/mm/protocal/protobuf/LiveMessage;", "checkMsgListSize", "local", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "merge", "remote", "", "selfID", "", "parseTemplateMsg", "parseTemplateMsgs", "msgList", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nbZ;
  
  static
  {
    AppMethodBeat.i(246797);
    nbZ = new b();
    AppMethodBeat.o(246797);
  }
  
  private static void a(dir paramdir)
  {
    AppMethodBeat.i(246774);
    if (!Util.isNullOrNil(paramdir.lMk))
    {
      String str = paramdir.lMk;
      s.s(str, "liveMessage.headimgurl");
      if (!n.rs(str, "/0")) {
        paramdir.lMk = s.X(paramdir.lMk, "/0");
      }
    }
    AppMethodBeat.o(246774);
  }
  
  public static void a(ArrayList<a> paramArrayList, List<? extends dir> paramList, String paramString)
  {
    AppMethodBeat.i(246756);
    s.u(paramArrayList, "local");
    s.u(paramList, "remote");
    s.u(paramString, "selfID");
    if (paramArrayList.size() == 0)
    {
      paramArrayList.addAll((Collection)bG(paramList));
      p(paramArrayList);
      AppMethodBeat.o(246756);
      return;
    }
    int i = 0;
    int k = ((a)p.oM((List)paramArrayList)).time;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (dir)localIterator.next();
      int j = i;
      if (((dir)localObject).aaNu > k) {
        j = 1;
      }
      i = j;
      if (j != 0)
      {
        i = j;
        if (!s.p(((dir)localObject).aaNt, paramString))
        {
          localObject = b((dir)localObject);
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
      paramArrayList.addAll((Collection)bG(paramList));
    }
    p(paramArrayList);
    AppMethodBeat.o(246756);
  }
  
  private static a b(dir paramdir)
  {
    AppMethodBeat.i(246782);
    a(paramdir);
    int i = paramdir.msg_type;
    Object localObject = l.c.mYi;
    CharSequence localCharSequence;
    if (i == l.c.bhq())
    {
      localObject = paramdir.content;
      localObject = ((e)h.ax(e.class)).b((String)localObject, new Bundle(), null, null);
      if (localObject == null) {}
      for (localCharSequence = null; localCharSequence == null; localCharSequence = n.bq((CharSequence)localObject))
      {
        AppMethodBeat.o(246782);
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
      String str = paramdir.lMk;
      s.s(str, "liveMessage.headimgurl");
      paramdir = new a((String)localObject, str, localCharSequence, paramdir.msg_type, paramdir.aaNu);
      AppMethodBeat.o(246782);
      return paramdir;
      localObject = "";
      continue;
      localObject = paramdir.content;
      s.s(localObject, "liveMessage.content");
      localCharSequence = (CharSequence)n.bq((CharSequence)localObject).toString();
      localObject = paramdir.aaNt;
      s.s(localObject, "liveMessage.identity_id");
    }
  }
  
  private static List<a> bG(List<? extends dir> paramList)
  {
    AppMethodBeat.i(246790);
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      a locala = b((dir)paramList.next());
      if (locala != null) {
        localArrayList.add(locala);
      }
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(246790);
    return paramList;
  }
  
  private static void p(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(246763);
    ArrayList localArrayList;
    int i;
    int k;
    if (paramArrayList.size() > 3000)
    {
      localArrayList = new ArrayList();
      i = 0;
      k = paramArrayList.size() - 3000;
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localArrayList.add(paramArrayList.get(i));
      if (j >= k)
      {
        paramArrayList.removeAll((Collection)localArrayList);
        AppMethodBeat.o(246763);
        return;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.d.b
 * JD-Core Version:    0.7.0.1
 */