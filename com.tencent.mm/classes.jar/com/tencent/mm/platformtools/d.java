package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import g.a.a.a.a.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/platformtools/BaseProtoPage;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "()V", "TAG", "", "filePath", "clearPage", "", "constructor", "readFromFile", "Ljava/util/LinkedList;", "writeToFile", "dataList", "plugin-comm_release"})
public class d<T extends com.tencent.mm.cd.a>
{
  private final String TAG = "MicroMsg.BaseProtoPage";
  private String filePath;
  
  protected final void ZI(String paramString)
  {
    AppMethodBeat.i(169171);
    p.k(paramString, "filePath");
    this.filePath = paramString;
    AppMethodBeat.o(169171);
  }
  
  public final LinkedList<T> bvg()
  {
    AppMethodBeat.i(169173);
    Object localObject1 = this.filePath;
    if (localObject1 == null) {
      p.bGy("filePath");
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e(this.TAG, "file path [%s] is invalid!");
      AppMethodBeat.o(169173);
      return null;
    }
    t localt2;
    for (;;)
    {
      try
      {
        localObject1 = this.filePath;
        if (localObject1 == null) {
          p.bGy("filePath");
        }
        if (!u.agG((String)localObject1))
        {
          localObject1 = this.TAG;
          localObject3 = new StringBuilder("file ");
          localObject4 = this.filePath;
          if (localObject4 == null) {
            p.bGy("filePath");
          }
          Log.i((String)localObject1, (String)localObject4 + " is not exist!");
          return null;
        }
        try
        {
          localObject1 = this.filePath;
          if (localObject1 == null) {
            p.bGy("filePath");
          }
          localObject3 = this.filePath;
          if (localObject3 == null) {
            p.bGy("filePath");
          }
          localObject3 = u.aY((String)localObject1, 0, (int)u.bBQ((String)localObject3));
          localObject4 = g.a.a.a.a.a.iUt();
          localObject1 = new g.a.a.a.a((byte[])localObject3, (b)localObject4);
          localObject5 = ((g.a.a.a.a)localObject1).aGc(((g.a.a.a.a)localObject1).iUr());
          localObject1 = new LinkedList();
          p.j(localObject5, "listLst");
          localObject5 = ((Iterable)localObject5).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (byte[])((Iterator)localObject5).next();
          localObject7 = getClass().getGenericSuperclass();
          if (localObject7 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            AppMethodBeat.o(169173);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, "parse proto from file occur error: " + localException.getMessage());
          return null;
        }
        localObject7 = ((java.lang.reflect.ParameterizedType)localObject7).getActualTypeArguments()[0];
        if (localObject7 == null)
        {
          t localt1 = new t("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(169173);
          throw localt1;
        }
      }
      finally
      {
        AppMethodBeat.o(169173);
      }
      Object localObject7 = ((Class)localObject7).newInstance();
      if (localObject7 == null)
      {
        localt2 = new t("null cannot be cast to non-null type T");
        AppMethodBeat.o(169173);
        throw localt2;
      }
      localObject7 = (com.tencent.mm.cd.a)localObject7;
      if (localObject6 == null) {
        p.iCn();
      }
      Object localObject6 = new g.a.a.a.a((byte[])localObject6, (b)localObject4);
      for (boolean bool = true; bool; bool = ((com.tencent.mm.cd.a)localObject7).populateBuilderWithField((g.a.a.a.a)localObject6, (com.tencent.mm.cd.a)localObject7, com.tencent.mm.cd.a.getNextFieldNumber((g.a.a.a.a)localObject6))) {}
      localt2.add(localObject7);
    }
    Object localObject4 = this.TAG;
    Object localObject3 = new StringBuilder("read ").append(localt2.size()).append(" items (total size ").append(localObject3.length).append(") from file ");
    Object localObject5 = this.filePath;
    if (localObject5 == null) {
      p.bGy("filePath");
    }
    Log.i((String)localObject4, (String)localObject5);
    AppMethodBeat.o(169173);
    return localt2;
  }
  
  public final void bvh()
  {
    AppMethodBeat.i(169174);
    String str1 = this.filePath;
    if (str1 == null) {
      p.bGy("filePath");
    }
    if (Util.isNullOrNil(str1))
    {
      str1 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("file path [");
      String str2 = this.filePath;
      if (str2 == null) {
        p.bGy("filePath");
      }
      Log.e(str1, str2 + "] is invalid!");
      AppMethodBeat.o(169174);
      return;
    }
    try
    {
      str1 = this.filePath;
      if (str1 == null) {
        p.bGy("filePath");
      }
      u.deleteFile(str1);
      return;
    }
    finally
    {
      AppMethodBeat.o(169174);
    }
  }
  
  public final void r(LinkedList<T> paramLinkedList)
  {
    AppMethodBeat.i(169172);
    p.k(paramLinkedList, "dataList");
    Object localObject1 = this.filePath;
    if (localObject1 == null) {
      p.bGy("filePath");
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e(this.TAG, "file path [%s] is invalid!");
      AppMethodBeat.o(169172);
      return;
    }
    try
    {
      localObject1 = this.filePath;
      if (localObject1 == null) {
        p.bGy("filePath");
      }
      localObject1 = new q((String)localObject1);
      if (!u.agG(((q)localObject1).ifA())) {
        u.bBD(((q)localObject1).ifA());
      }
      localObject1 = this.filePath;
      if (localObject1 == null) {
        p.bGy("filePath");
      }
      if (!u.agG((String)localObject1))
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("create new file ");
        str = this.filePath;
        if (str == null) {
          p.bGy("filePath");
        }
        Log.i((String)localObject1, str);
        localObject1 = this.filePath;
        if (localObject1 == null) {
          p.bGy("filePath");
        }
        u.bBV((String)localObject1);
      }
      try
      {
        int i = g.a.a.a.c(1, 8, paramLinkedList);
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("write ").append(paramLinkedList.size()).append(" items (total size ").append(i).append(") to file ");
        str = this.filePath;
        if (str == null) {
          p.bGy("filePath");
        }
        Log.i((String)localObject1, str);
        localObject1 = new byte[i];
        localObject2 = new g.a.a.c.a((byte[])localObject1);
        ((g.a.a.c.a)localObject2).e(1, 8, paramLinkedList);
        ((g.a.a.c.a)localObject2).iUC();
        paramLinkedList = this.filePath;
        if (paramLinkedList == null) {
          p.bGy("filePath");
        }
        u.H(paramLinkedList, (byte[])localObject1);
      }
      catch (IOException paramLinkedList)
      {
        for (;;)
        {
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("write to file ");
          str = this.filePath;
          if (str == null) {
            p.bGy("filePath");
          }
          Log.e((String)localObject1, str + " occur error: " + paramLinkedList.getMessage());
          paramLinkedList = x.aazN;
        }
      }
      return;
    }
    finally
    {
      Object localObject2;
      String str;
      AppMethodBeat.o(169172);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.d
 * JD-Core Version:    0.7.0.1
 */