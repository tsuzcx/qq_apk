package com.tencent.mm.plugin.editor.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.protocal.protobuf.afy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static String Tb(String paramString)
  {
    AppMethodBeat.i(181670);
    paramString = g.getMessageDigest((paramString + 18 + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(181670);
    return paramString;
  }
  
  public static String a(afy paramafy)
  {
    AppMethodBeat.i(181671);
    gs localgs = new gs();
    localgs.dkc.type = 27;
    localgs.dkc.dke = paramafy;
    com.tencent.mm.sdk.b.a.ESL.l(localgs);
    paramafy = localgs.dkd.thumbPath;
    AppMethodBeat.o(181671);
    return paramafy;
  }
  
  public static ArrayList<com.tencent.mm.plugin.editor.model.a.a> a(Object paramObject, List<String> paramList)
  {
    AppMethodBeat.i(181673);
    if (paramObject == null)
    {
      AppMethodBeat.o(181673);
      return null;
    }
    paramObject = (ArrayList)paramObject;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramObject.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.editor.model.a.a)((Iterator)localObject1).next();
      if (((com.tencent.mm.plugin.editor.model.a.a)localObject2).getType() != 1) {
        localArrayList.add(localObject2);
      }
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      if (((String)localObject1).trim().equals("<ThisisNoteNodeHrObj>"))
      {
        localObject1 = new i();
        ((i)localObject1).omv = false;
        ((i)localObject1).omB = false;
        if (i < localArrayList.size()) {
          localArrayList.add(i, localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localObject1);
        continue;
        if (!((String)localObject1).trim().equals("<ThisisNoteNodeObj>"))
        {
          localObject2 = new j();
          ((j)localObject2).content = ((String)localObject1);
          ((j)localObject2).omv = false;
          ((j)localObject2).omB = false;
          ((j)localObject2).dkb = Tb(localObject2.toString());
          if (i < localArrayList.size()) {
            localArrayList.add(i, localObject2);
          } else {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    paramObject.clear();
    paramObject.addAll(localArrayList);
    AppMethodBeat.o(181673);
    return localArrayList;
  }
  
  public static String b(afy paramafy)
  {
    AppMethodBeat.i(181672);
    gs localgs = new gs();
    localgs.dkc.type = 27;
    localgs.dkc.dke = paramafy;
    com.tencent.mm.sdk.b.a.ESL.l(localgs);
    paramafy = localgs.dkd.path;
    AppMethodBeat.o(181672);
    return paramafy;
  }
  
  public static float mI(long paramLong)
  {
    float f1 = 1.0F;
    AppMethodBeat.i(181669);
    float f2 = (float)paramLong / 1000.0F;
    if (f2 < 1.0F) {}
    for (;;)
    {
      f1 = Math.round(f1);
      AppMethodBeat.o(181669);
      return f1;
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.b
 * JD-Core Version:    0.7.0.1
 */