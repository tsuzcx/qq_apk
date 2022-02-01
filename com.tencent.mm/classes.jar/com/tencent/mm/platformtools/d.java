package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import f.a.a.a.a.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/platformtools/BaseProtoPage;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "()V", "TAG", "", "filePath", "clearPage", "", "constructor", "readFromFile", "Ljava/util/LinkedList;", "writeToFile", "dataList", "plugin-comm_release"})
public class d<T extends com.tencent.mm.bx.a>
{
  private final String TAG = "MicroMsg.BaseProtoPage";
  private String filePath;
  
  protected final void IK(String paramString)
  {
    AppMethodBeat.i(169171);
    p.h(paramString, "filePath");
    this.filePath = paramString;
    AppMethodBeat.o(169171);
  }
  
  public final LinkedList<T> aQn()
  {
    AppMethodBeat.i(169173);
    Object localObject1 = this.filePath;
    if (localObject1 == null) {
      p.bcb("filePath");
    }
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e(this.TAG, "file path [%s] is invalid!");
      AppMethodBeat.o(169173);
      return null;
    }
    v localv2;
    for (;;)
    {
      try
      {
        localObject1 = this.filePath;
        if (localObject1 == null) {
          p.bcb("filePath");
        }
        if (!i.fv((String)localObject1))
        {
          localObject1 = this.TAG;
          localObject3 = new StringBuilder("file ");
          localObject4 = this.filePath;
          if (localObject4 == null) {
            p.bcb("filePath");
          }
          ad.i((String)localObject1, (String)localObject4 + " is not exist!");
          return null;
        }
        try
        {
          localObject1 = this.filePath;
          if (localObject1 == null) {
            p.bcb("filePath");
          }
          localObject3 = this.filePath;
          if (localObject3 == null) {
            p.bcb("filePath");
          }
          localObject3 = i.aY((String)localObject1, 0, (int)i.aYo((String)localObject3));
          localObject4 = f.a.a.a.a.a.gxF();
          localObject1 = new f.a.a.a.a((byte[])localObject3, (b)localObject4);
          localObject5 = ((f.a.a.a.a)localObject1).alQ(((f.a.a.a.a)localObject1).gxD());
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
            localObject1 = new v("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            AppMethodBeat.o(169173);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ad.e(this.TAG, "parse proto from file occur error: " + localException.getMessage());
          return null;
        }
        localObject7 = ((java.lang.reflect.ParameterizedType)localObject7).getActualTypeArguments()[0];
        if (localObject7 == null)
        {
          v localv1 = new v("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(169173);
          throw localv1;
        }
      }
      finally
      {
        AppMethodBeat.o(169173);
      }
      Object localObject7 = ((Class)localObject7).newInstance();
      if (localObject7 == null)
      {
        localv2 = new v("null cannot be cast to non-null type T");
        AppMethodBeat.o(169173);
        throw localv2;
      }
      localObject7 = (com.tencent.mm.bx.a)localObject7;
      if (localObject6 == null) {
        p.gfZ();
      }
      Object localObject6 = new f.a.a.a.a((byte[])localObject6, (b)localObject4);
      for (boolean bool = true; bool; bool = ((com.tencent.mm.bx.a)localObject7).populateBuilderWithField((f.a.a.a.a)localObject6, (com.tencent.mm.bx.a)localObject7, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject6))) {}
      localv2.add(localObject7);
    }
    Object localObject4 = this.TAG;
    Object localObject3 = new StringBuilder("read ").append(localv2.size()).append(" items (total size ").append(localObject3.length).append(") from file ");
    Object localObject5 = this.filePath;
    if (localObject5 == null) {
      p.bcb("filePath");
    }
    ad.i((String)localObject4, (String)localObject5);
    AppMethodBeat.o(169173);
    return localv2;
  }
  
  public final void aQo()
  {
    AppMethodBeat.i(169174);
    String str1 = this.filePath;
    if (str1 == null) {
      p.bcb("filePath");
    }
    if (bt.isNullOrNil(str1))
    {
      str1 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("file path [");
      String str2 = this.filePath;
      if (str2 == null) {
        p.bcb("filePath");
      }
      ad.e(str1, str2 + "] is invalid!");
      AppMethodBeat.o(169174);
      return;
    }
    try
    {
      str1 = this.filePath;
      if (str1 == null) {
        p.bcb("filePath");
      }
      i.deleteFile(str1);
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
      p.bcb("filePath");
    }
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e(this.TAG, "file path [%s] is invalid!");
      AppMethodBeat.o(169172);
      return;
    }
    try
    {
      localObject1 = this.filePath;
      if (localObject1 == null) {
        p.bcb("filePath");
      }
      localObject1 = new e((String)localObject1);
      if (!i.fv(((e)localObject1).getParent())) {
        i.aYg(((e)localObject1).getParent());
      }
      localObject1 = this.filePath;
      if (localObject1 == null) {
        p.bcb("filePath");
      }
      if (!i.fv((String)localObject1))
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("create new file ");
        str = this.filePath;
        if (str == null) {
          p.bcb("filePath");
        }
        ad.i((String)localObject1, str);
        localObject1 = this.filePath;
        if (localObject1 == null) {
          p.bcb("filePath");
        }
        i.aYs((String)localObject1);
      }
      try
      {
        int i = f.a.a.a.c(1, 8, paramLinkedList);
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("write ").append(paramLinkedList.size()).append(" items (total size ").append(i).append(") to file ");
        str = this.filePath;
        if (str == null) {
          p.bcb("filePath");
        }
        ad.i((String)localObject1, str);
        localObject1 = new byte[i];
        localObject2 = new f.a.a.c.a((byte[])localObject1);
        ((f.a.a.c.a)localObject2).e(1, 8, paramLinkedList);
        ((f.a.a.c.a)localObject2).gxO();
        paramLinkedList = this.filePath;
        if (paramLinkedList == null) {
          p.bcb("filePath");
        }
        i.C(paramLinkedList, (byte[])localObject1);
      }
      catch (IOException paramLinkedList)
      {
        for (;;)
        {
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("write to file ");
          str = this.filePath;
          if (str == null) {
            p.bcb("filePath");
          }
          ad.e((String)localObject1, str + " occur error: " + paramLinkedList.getMessage());
          paramLinkedList = z.MKo;
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