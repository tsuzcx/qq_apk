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
    AppMethodBeat.i(40130);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(paramString);
    zza(paramzzaal, localStringBuilder, 0);
    paramzzaal = localStringBuilder.toString();
    AppMethodBeat.o(40130);
    return paramzzaal;
  }
  
  private static void zza(zzaal paramzzaal, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(40131);
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
    label567:
    label1081:
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
            break label323;
          }
          zzb(paramStringBuilder, paramInt, zzfk((String)localObject1), zzzq.zza((Method)localObject5, paramzzaal, new Object[0]));
          break;
        }
      }
      label323:
      if ((((String)localObject4).endsWith("Map")) && (!((String)localObject4).equals("Map")))
      {
        localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject5 = String.valueOf(((String)localObject4).substring(1, ((String)localObject4).length() - 3));
        if (((String)localObject5).length() != 0) {}
        for (localObject1 = ((String)localObject1).concat((String)localObject5);; localObject1 = new String((String)localObject1))
        {
          localObject2 = (Method)localHashMap1.get(localObject2);
          if ((localObject2 == null) || (!((Method)localObject2).getReturnType().equals(Map.class)) || (((Method)localObject2).isAnnotationPresent(Deprecated.class)) || (!Modifier.isPublic(((Method)localObject2).getModifiers()))) {
            break label483;
          }
          zzb(paramStringBuilder, paramInt, zzfk((String)localObject1), zzzq.zza((Method)localObject2, paramzzaal, new Object[0]));
          break;
        }
      }
      label483:
      localObject1 = String.valueOf(localObject4);
      label507:
      boolean bool;
      if (((String)localObject1).length() != 0)
      {
        localObject1 = "set".concat((String)localObject1);
        if ((Method)localHashMap2.get(localObject1) == null) {
          break label782;
        }
        if (((String)localObject4).endsWith("Bytes"))
        {
          localObject1 = String.valueOf(((String)localObject4).substring(0, ((String)localObject4).length() - 5));
          if (((String)localObject1).length() == 0) {
            break label784;
          }
          localObject1 = "get".concat((String)localObject1);
          if (localHashMap1.containsKey(localObject1)) {
            break label796;
          }
        }
        localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject2 = String.valueOf(((String)localObject4).substring(1));
        if (((String)localObject2).length() == 0) {
          break label798;
        }
        localObject1 = ((String)localObject1).concat((String)localObject2);
        label622:
        localObject2 = String.valueOf(localObject4);
        if (((String)localObject2).length() == 0) {
          break label812;
        }
        localObject2 = "get".concat((String)localObject2);
        localObject5 = (Method)localHashMap1.get(localObject2);
        localObject2 = String.valueOf(localObject4);
        if (((String)localObject2).length() == 0) {
          break label826;
        }
        localObject2 = "has".concat((String)localObject2);
        localObject2 = (Method)localHashMap1.get(localObject2);
        if (localObject5 == null) {
          continue;
        }
        localObject4 = zzzq.zza((Method)localObject5, paramzzaal, new Object[0]);
        if (localObject2 != null) {
          break label1062;
        }
        if (!(localObject4 instanceof Boolean)) {
          break label846;
        }
        if (((Boolean)localObject4).booleanValue()) {
          break label840;
        }
        bool = true;
        label742:
        if (bool) {
          break label1056;
        }
        bool = true;
      }
      for (;;)
      {
        if (!bool) {
          break label1081;
        }
        zzb(paramStringBuilder, paramInt, zzfk((String)localObject1), localObject4);
        break;
        localObject1 = new String("set");
        break label507;
        break;
        localObject1 = new String("get");
        break label567;
        break;
        localObject1 = new String((String)localObject1);
        break label622;
        localObject2 = new String("get");
        break label646;
        label826:
        localObject2 = new String("has");
        break label684;
        label840:
        bool = false;
        break label742;
        label846:
        if ((localObject4 instanceof Integer))
        {
          if (((Integer)localObject4).intValue() == 0)
          {
            bool = true;
            break label742;
          }
          bool = false;
          break label742;
        }
        if ((localObject4 instanceof Float))
        {
          if (((Float)localObject4).floatValue() == 0.0F)
          {
            bool = true;
            break label742;
          }
          bool = false;
          break label742;
        }
        if ((localObject4 instanceof Double))
        {
          if (((Double)localObject4).doubleValue() == 0.0D)
          {
            bool = true;
            break label742;
          }
          bool = false;
          break label742;
        }
        if ((localObject4 instanceof String))
        {
          bool = localObject4.equals("");
          break label742;
        }
        if ((localObject4 instanceof zzyw))
        {
          bool = localObject4.equals(zzyw.zzbqx);
          break label742;
        }
        if ((localObject4 instanceof zzaal))
        {
          if (localObject4 == ((zzaal)localObject4).zztz())
          {
            bool = true;
            break label742;
          }
          bool = false;
          break label742;
        }
        if ((localObject4 instanceof Enum))
        {
          if (((Enum)localObject4).ordinal() == 0)
          {
            bool = true;
            break label742;
          }
          bool = false;
          break label742;
        }
        bool = false;
        break label742;
        bool = false;
        continue;
        bool = ((Boolean)zzzq.zza((Method)localObject2, paramzzaal, new Object[0])).booleanValue();
      }
    }
    label646:
    label684:
    if ((paramzzaal instanceof zzzq.zza))
    {
      paramzzaal = ((zzzq.zza)paramzzaal).zzbsb.iterator();
      if (paramzzaal.hasNext())
      {
        ((Map.Entry)paramzzaal.next()).getKey();
        paramzzaal = new NoSuchMethodError();
        AppMethodBeat.o(40131);
        throw paramzzaal;
      }
    }
    label782:
    label784:
    label796:
    label798:
    label812:
    AppMethodBeat.o(40131);
    label1056:
    label1062:
    return;
  }
  
  static final void zzb(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(40132);
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        zzb(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      AppMethodBeat.o(40132);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        zzb(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
      }
      AppMethodBeat.o(40132);
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
      AppMethodBeat.o(40132);
      return;
    }
    if ((paramObject instanceof zzyw))
    {
      paramStringBuilder.append(": \"").append(zzabg.zza((zzyw)paramObject)).append('"');
      AppMethodBeat.o(40132);
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
      AppMethodBeat.o(40132);
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
      AppMethodBeat.o(40132);
      return;
    }
    paramStringBuilder.append(": ").append(paramObject.toString());
    AppMethodBeat.o(40132);
  }
  
  private static final String zzfk(String paramString)
  {
    AppMethodBeat.i(40133);
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
    AppMethodBeat.o(40133);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaan
 * JD-Core Version:    0.7.0.1
 */