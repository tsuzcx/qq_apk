package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzaan
{
  static String zza(zzaal paramzzaal, String paramString)
  {
    AppMethodBeat.i(3340);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(paramString);
    zza(paramzzaal, localStringBuilder, 0);
    paramzzaal = localStringBuilder.toString();
    AppMethodBeat.o(3340);
    return paramzzaal;
  }
  
  private static void zza(zzaal paramzzaal, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(3341);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject2 = paramzzaal.getClass().getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localHashMap2.put(((Method)localObject3).getName(), localObject3);
      if (((Method)localObject3).getParameterTypes().length == 0)
      {
        localHashMap1.put(((Method)localObject3).getName(), localObject3);
        if (((Method)localObject3).getName().startsWith("get")) {
          ((Set)localObject1).add(((Method)localObject3).getName());
        }
      }
      i += 1;
    }
    Object localObject3 = ((Set)localObject1).iterator();
    label568:
    label1082:
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (String)((Iterator)localObject3).next();
      Object localObject4 = ((String)localObject2).replaceFirst("get", "");
      Object localObject5;
      if ((((String)localObject4).endsWith("List")) && (!((String)localObject4).endsWith("OrBuilderList")) && (!((String)localObject4).equals("List")))
      {
        localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject5 = String.valueOf(((String)localObject4).substring(1, ((String)localObject4).length() - 4));
        if (((String)localObject5).length() != 0) {}
        for (localObject1 = ((String)localObject1).concat((String)localObject5);; localObject1 = new String((String)localObject1))
        {
          localObject5 = (Method)localHashMap1.get(localObject2);
          if ((localObject5 == null) || (!((Method)localObject5).getReturnType().equals(List.class))) {
            break label324;
          }
          zzb(paramStringBuilder, paramInt, zzfk((String)localObject1), zzzq.zza((Method)localObject5, paramzzaal, new Object[0]));
          break;
        }
      }
      label324:
      if ((((String)localObject4).endsWith("Map")) && (!((String)localObject4).equals("Map")))
      {
        localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject5 = String.valueOf(((String)localObject4).substring(1, ((String)localObject4).length() - 3));
        if (((String)localObject5).length() != 0) {}
        for (localObject1 = ((String)localObject1).concat((String)localObject5);; localObject1 = new String((String)localObject1))
        {
          localObject2 = (Method)localHashMap1.get(localObject2);
          if ((localObject2 == null) || (!((Method)localObject2).getReturnType().equals(Map.class)) || (((Method)localObject2).isAnnotationPresent(Deprecated.class)) || (!Modifier.isPublic(((Method)localObject2).getModifiers()))) {
            break label484;
          }
          zzb(paramStringBuilder, paramInt, zzfk((String)localObject1), zzzq.zza((Method)localObject2, paramzzaal, new Object[0]));
          break;
        }
      }
      label484:
      localObject1 = String.valueOf(localObject4);
      label508:
      boolean bool;
      if (((String)localObject1).length() != 0)
      {
        localObject1 = "set".concat((String)localObject1);
        if ((Method)localHashMap2.get(localObject1) == null) {
          break label783;
        }
        if (((String)localObject4).endsWith("Bytes"))
        {
          localObject1 = String.valueOf(((String)localObject4).substring(0, ((String)localObject4).length() - 5));
          if (((String)localObject1).length() == 0) {
            break label785;
          }
          localObject1 = "get".concat((String)localObject1);
          if (localHashMap1.containsKey(localObject1)) {
            break label797;
          }
        }
        localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject2 = String.valueOf(((String)localObject4).substring(1));
        if (((String)localObject2).length() == 0) {
          break label799;
        }
        localObject1 = ((String)localObject1).concat((String)localObject2);
        label623:
        localObject2 = String.valueOf(localObject4);
        if (((String)localObject2).length() == 0) {
          break label813;
        }
        localObject2 = "get".concat((String)localObject2);
        localObject5 = (Method)localHashMap1.get(localObject2);
        localObject2 = String.valueOf(localObject4);
        if (((String)localObject2).length() == 0) {
          break label827;
        }
        localObject2 = "has".concat((String)localObject2);
        localObject2 = (Method)localHashMap1.get(localObject2);
        if (localObject5 == null) {
          continue;
        }
        localObject4 = zzzq.zza((Method)localObject5, paramzzaal, new Object[0]);
        if (localObject2 != null) {
          break label1063;
        }
        if (!(localObject4 instanceof Boolean)) {
          break label847;
        }
        if (((Boolean)localObject4).booleanValue()) {
          break label841;
        }
        bool = true;
        label743:
        if (bool) {
          break label1057;
        }
        bool = true;
      }
      for (;;)
      {
        if (!bool) {
          break label1082;
        }
        zzb(paramStringBuilder, paramInt, zzfk((String)localObject1), localObject4);
        break;
        localObject1 = new String("set");
        break label508;
        break;
        localObject1 = new String("get");
        break label568;
        break;
        localObject1 = new String((String)localObject1);
        break label623;
        localObject2 = new String("get");
        break label647;
        label827:
        localObject2 = new String("has");
        break label685;
        label841:
        bool = false;
        break label743;
        label847:
        if ((localObject4 instanceof Integer))
        {
          if (((Integer)localObject4).intValue() == 0)
          {
            bool = true;
            break label743;
          }
          bool = false;
          break label743;
        }
        if ((localObject4 instanceof Float))
        {
          if (((Float)localObject4).floatValue() == 0.0F)
          {
            bool = true;
            break label743;
          }
          bool = false;
          break label743;
        }
        if ((localObject4 instanceof Double))
        {
          if (((Double)localObject4).doubleValue() == 0.0D)
          {
            bool = true;
            break label743;
          }
          bool = false;
          break label743;
        }
        if ((localObject4 instanceof String))
        {
          bool = localObject4.equals("");
          break label743;
        }
        if ((localObject4 instanceof zzyw))
        {
          bool = localObject4.equals(zzyw.zzbqx);
          break label743;
        }
        if ((localObject4 instanceof zzaal))
        {
          if (localObject4 == ((zzaal)localObject4).zztz())
          {
            bool = true;
            break label743;
          }
          bool = false;
          break label743;
        }
        if ((localObject4 instanceof Enum))
        {
          if (((Enum)localObject4).ordinal() == 0)
          {
            bool = true;
            break label743;
          }
          bool = false;
          break label743;
        }
        bool = false;
        break label743;
        bool = false;
        continue;
        bool = ((Boolean)zzzq.zza((Method)localObject2, paramzzaal, new Object[0])).booleanValue();
      }
    }
    label647:
    label685:
    if ((paramzzaal instanceof zzzq.zza))
    {
      paramzzaal = ((zzzq.zza)paramzzaal).zzbsb.iterator();
      if (paramzzaal.hasNext())
      {
        ((Map.Entry)paramzzaal.next()).getKey();
        paramzzaal = new NoSuchMethodError();
        AppMethodBeat.o(3341);
        throw paramzzaal;
      }
    }
    label783:
    label785:
    label797:
    label799:
    label813:
    AppMethodBeat.o(3341);
    label1057:
    label1063:
    return;
  }
  
  static final void zzb(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(3342);
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        zzb(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      AppMethodBeat.o(3342);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        zzb(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
      }
      AppMethodBeat.o(3342);
      return;
    }
    paramStringBuilder.append('\n');
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"").append(zzabg.zza(zzyw.zzfi((String)paramObject))).append('"');
      AppMethodBeat.o(3342);
      return;
    }
    if ((paramObject instanceof zzyw))
    {
      paramStringBuilder.append(": \"").append(zzabg.zza((zzyw)paramObject)).append('"');
      AppMethodBeat.o(3342);
      return;
    }
    if ((paramObject instanceof zzzq))
    {
      paramStringBuilder.append(" {");
      zza((zzzq)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      AppMethodBeat.o(3342);
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      zzb(paramStringBuilder, paramInt + 2, "key", paramString.getKey());
      zzb(paramStringBuilder, paramInt + 2, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      i = k;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      AppMethodBeat.o(3342);
      return;
    }
    paramStringBuilder.append(": ").append(paramObject.toString());
    AppMethodBeat.o(3342);
  }
  
  private static final String zzfk(String paramString)
  {
    AppMethodBeat.i(3343);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(3343);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaan
 * JD-Core Version:    0.7.0.1
 */