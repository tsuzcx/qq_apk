package a.j.b.a.c.e.b.a;

import a.i.b;
import a.i.b.a;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public static final c Cqa;
  private static final Map<String, String> map;
  
  static
  {
    AppMethodBeat.i(121306);
    Cqa = new c();
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = a.a.j.listOf(new String[] { "Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D" });
    Object localObject2 = (b)a.a.j.e((Collection)localObject1);
    a.f.b.j.q(localObject2, "receiver$0");
    a.f.b.j.q((Number)Integer.valueOf(2), "step");
    Object localObject3 = b.BNx;
    int j = ((b)localObject2).BNv;
    int k = ((b)localObject2).BNw;
    if (((b)localObject2).hAu > 0)
    {
      i = 2;
      localObject2 = b.a.aO(j, k, i);
      i = ((b)localObject2).BNv;
      j = ((b)localObject2).BNw;
      k = ((b)localObject2).hAu;
      if (k <= 0) {
        break label347;
      }
      if (i > j) {
        break label355;
      }
    }
    label347:
    while (i >= j)
    {
      for (;;)
      {
        localMap.put("kotlin/" + (String)((List)localObject1).get(i), ((List)localObject1).get(i + 1));
        localMap.put("kotlin/" + (String)((List)localObject1).get(i) + "Array", "[" + (String)((List)localObject1).get(i + 1));
        if (i == j) {
          break;
        }
        i += k;
      }
      i = -2;
      break;
    }
    label355:
    localMap.put("kotlin/Unit", "V");
    localObject1 = new c.a(localMap);
    ((c.a)localObject1).jr("Any", "java/lang/Object");
    ((c.a)localObject1).jr("Nothing", "java/lang/Void");
    ((c.a)localObject1).jr("Annotation", "java/lang/annotation/Annotation");
    localObject2 = a.a.j.listOf(new String[] { "String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((c.a)localObject1).jr((String)localObject3, "java/lang/".concat(String.valueOf(localObject3)));
    }
    localObject2 = a.a.j.listOf(new String[] { "Iterator", "Collection", "List", "Set", "Map", "ListIterator" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((c.a)localObject1).jr("collections/".concat(String.valueOf(localObject3)), "java/util/".concat(String.valueOf(localObject3)));
      ((c.a)localObject1).jr("collections/Mutable".concat(String.valueOf(localObject3)), "java/util/".concat(String.valueOf(localObject3)));
    }
    ((c.a)localObject1).jr("collections/Iterable", "java/lang/Iterable");
    ((c.a)localObject1).jr("collections/MutableIterable", "java/lang/Iterable");
    ((c.a)localObject1).jr("collections/Map.Entry", "java/util/Map$Entry");
    ((c.a)localObject1).jr("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    int i = 0;
    while (i <= 22)
    {
      ((c.a)localObject1).jr("Function".concat(String.valueOf(i)), "kotlin/jvm/functions/Function".concat(String.valueOf(i)));
      ((c.a)localObject1).jr("reflect/KFunction".concat(String.valueOf(i)), "kotlin/reflect/KFunction");
      i += 1;
    }
    localObject2 = a.a.j.listOf(new String[] { "Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      ((c.a)localObject1).jr((String)localObject3 + ".Companion", "kotlin/jvm/internal/" + (String)localObject3 + "CompanionObject");
    }
    map = localMap;
    AppMethodBeat.o(121306);
  }
  
  public static final String ayR(String paramString)
  {
    AppMethodBeat.i(121305);
    a.f.b.j.q(paramString, "classId");
    String str2 = (String)map.get(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = "L" + m.a(paramString, '.', '$') + ';';
    }
    AppMethodBeat.o(121305);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.c
 * JD-Core Version:    0.7.0.1
 */