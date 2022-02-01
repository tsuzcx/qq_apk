package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import g.a.a.a.a.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/platformtools/BaseProtoPage;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "()V", "TAG", "", "filePath", "clearPage", "", "constructor", "readFromFile", "Ljava/util/LinkedList;", "writeToFile", "dataList", "plugin-comm_release"})
public class d<T extends com.tencent.mm.bw.a>
{
  private final String TAG = "MicroMsg.BaseProtoPage";
  private String filePath;
  
  protected final void Sg(String paramString)
  {
    AppMethodBeat.i(169171);
    p.h(paramString, "filePath");
    this.filePath = paramString;
    AppMethodBeat.o(169171);
  }
  
  public final LinkedList<T> blq()
  {
    AppMethodBeat.i(169173);
    Object localObject1 = this.filePath;
    if (localObject1 == null) {
      p.btv("filePath");
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
          p.btv("filePath");
        }
        if (!s.YS((String)localObject1))
        {
          localObject1 = this.TAG;
          localObject3 = new StringBuilder("file ");
          localObject4 = this.filePath;
          if (localObject4 == null) {
            p.btv("filePath");
          }
          Log.i((String)localObject1, (String)localObject4 + " is not exist!");
          return null;
        }
        try
        {
          localObject1 = this.filePath;
          if (localObject1 == null) {
            p.btv("filePath");
          }
          localObject3 = this.filePath;
          if (localObject3 == null) {
            p.btv("filePath");
          }
          localObject3 = s.aW((String)localObject1, 0, (int)s.boW((String)localObject3));
          localObject4 = new g.a.a.a.a.a();
          localObject1 = new g.a.a.a.a((byte[])localObject3, (b)localObject4);
          localObject5 = ((g.a.a.a.a)localObject1).awh(((g.a.a.a.a)localObject1).hPk());
          localObject1 = new LinkedList();
          p.g(localObject5, "listLst");
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
      localObject7 = (com.tencent.mm.bw.a)localObject7;
      if (localObject6 == null) {
        p.hyc();
      }
      Object localObject6 = new g.a.a.a.a((byte[])localObject6, (b)localObject4);
      for (boolean bool = true; bool; bool = ((com.tencent.mm.bw.a)localObject7).populateBuilderWithField((g.a.a.a.a)localObject6, (com.tencent.mm.bw.a)localObject7, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject6))) {}
      localt2.add(localObject7);
    }
    Object localObject4 = this.TAG;
    Object localObject3 = new StringBuilder("read ").append(localt2.size()).append(" items (total size ").append(localObject3.length).append(") from file ");
    Object localObject5 = this.filePath;
    if (localObject5 == null) {
      p.btv("filePath");
    }
    Log.i((String)localObject4, (String)localObject5);
    AppMethodBeat.o(169173);
    return localt2;
  }
  
  public final void blr()
  {
    AppMethodBeat.i(169174);
    String str1 = this.filePath;
    if (str1 == null) {
      p.btv("filePath");
    }
    if (Util.isNullOrNil(str1))
    {
      str1 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("file path [");
      String str2 = this.filePath;
      if (str2 == null) {
        p.btv("filePath");
      }
      Log.e(str1, str2 + "] is invalid!");
      AppMethodBeat.o(169174);
      return;
    }
    try
    {
      str1 = this.filePath;
      if (str1 == null) {
        p.btv("filePath");
      }
      s.deleteFile(str1);
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
    p.h(paramLinkedList, "dataList");
    Object localObject1 = this.filePath;
    if (localObject1 == null) {
      p.btv("filePath");
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
        p.btv("filePath");
      }
      localObject1 = new o((String)localObject1);
      if (!s.YS(((o)localObject1).getParent())) {
        s.boN(((o)localObject1).getParent());
      }
      localObject1 = this.filePath;
      if (localObject1 == null) {
        p.btv("filePath");
      }
      if (!s.YS((String)localObject1))
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("create new file ");
        str = this.filePath;
        if (str == null) {
          p.btv("filePath");
        }
        Log.i((String)localObject1, str);
        localObject1 = this.filePath;
        if (localObject1 == null) {
          p.btv("filePath");
        }
        s.bpa((String)localObject1);
      }
      try
      {
        int i = g.a.a.a.c(1, 8, paramLinkedList);
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("write ").append(paramLinkedList.size()).append(" items (total size ").append(i).append(") to file ");
        str = this.filePath;
        if (str == null) {
          p.btv("filePath");
        }
        Log.i((String)localObject1, str);
        localObject1 = new byte[i];
        localObject2 = new g.a.a.c.a((byte[])localObject1);
        ((g.a.a.c.a)localObject2).e(1, 8, paramLinkedList);
        ((g.a.a.c.a)localObject2).hPu();
        paramLinkedList = this.filePath;
        if (paramLinkedList == null) {
          p.btv("filePath");
        }
        s.C(paramLinkedList, (byte[])localObject1);
      }
      catch (IOException paramLinkedList)
      {
        for (;;)
        {
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("write to file ");
          str = this.filePath;
          if (str == null) {
            p.btv("filePath");
          }
          Log.e((String)localObject1, str + " occur error: " + paramLinkedList.getMessage());
          paramLinkedList = x.SXb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.d
 * JD-Core Version:    0.7.0.1
 */