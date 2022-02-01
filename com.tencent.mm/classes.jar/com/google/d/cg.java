package com.google.d;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class cg
{
  static void a(ce paramce, StringBuilder paramStringBuilder, int paramInt)
  {
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    Object localObject2 = new TreeSet();
    Object localObject3 = paramce.getClass().getDeclaredMethods();
    int j = localObject3.length;
    int i = 0;
    Object localObject4;
    while (i < j)
    {
      localObject4 = localObject3[i];
      localHashMap.put(((Method)localObject4).getName(), localObject4);
      if (((Method)localObject4).getParameterTypes().length == 0)
      {
        ((Map)localObject1).put(((Method)localObject4).getName(), localObject4);
        if (((Method)localObject4).getName().startsWith("get")) {
          ((Set)localObject2).add(((Method)localObject4).getName());
        }
      }
      i += 1;
    }
    localObject2 = ((Set)localObject2).iterator();
    label625:
    label894:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject3 = ((String)localObject4).replaceFirst("get", "");
      Object localObject5;
      if ((((String)localObject3).endsWith("List")) && (!((String)localObject3).endsWith("OrBuilderList")) && (!((String)localObject3).equals("List")))
      {
        localObject5 = ((String)localObject3).substring(0, 1).toLowerCase() + ((String)localObject3).substring(1, ((String)localObject3).length() - 4);
        Method localMethod = (Method)((Map)localObject1).get(localObject4);
        if ((localMethod != null) && (localMethod.getReturnType().equals(List.class)))
        {
          a(paramStringBuilder, paramInt, ed((String)localObject5), be.invokeOrDie(localMethod, paramce, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject3).endsWith("Map")) && (!((String)localObject3).equals("Map")))
      {
        localObject5 = ((String)localObject3).substring(0, 1).toLowerCase() + ((String)localObject3).substring(1, ((String)localObject3).length() - 3);
        localObject4 = (Method)((Map)localObject1).get(localObject4);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(Map.class)) && (!((Method)localObject4).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject4).getModifiers())))
        {
          a(paramStringBuilder, paramInt, ed((String)localObject5), be.invokeOrDie((Method)localObject4, paramce, new Object[0]));
          continue;
        }
      }
      if (((Method)localHashMap.get("set".concat(String.valueOf(localObject3))) != null) && ((!((String)localObject3).endsWith("Bytes")) || (!((Map)localObject1).containsKey("get" + ((String)localObject3).substring(0, ((String)localObject3).length() - 5)))))
      {
        localObject4 = ((String)localObject3).substring(0, 1).toLowerCase() + ((String)localObject3).substring(1);
        localObject5 = (Method)((Map)localObject1).get("get".concat(String.valueOf(localObject3)));
        localObject3 = (Method)((Map)localObject1).get("has".concat(String.valueOf(localObject3)));
        if (localObject5 != null)
        {
          localObject5 = be.invokeOrDie((Method)localObject5, paramce, new Object[0]);
          boolean bool;
          if (localObject3 == null) {
            if ((localObject5 instanceof Boolean)) {
              if (!((Boolean)localObject5).booleanValue())
              {
                bool = true;
                if (bool) {
                  break label869;
                }
                bool = true;
              }
            }
          }
          for (;;)
          {
            if (!bool) {
              break label894;
            }
            a(paramStringBuilder, paramInt, ed((String)localObject4), localObject5);
            break;
            bool = false;
            break label625;
            if ((localObject5 instanceof Integer))
            {
              if (((Integer)localObject5).intValue() == 0)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject5 instanceof Float))
            {
              if (((Float)localObject5).floatValue() == 0.0F)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject5 instanceof Double))
            {
              if (((Double)localObject5).doubleValue() == 0.0D)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject5 instanceof String))
            {
              bool = localObject5.equals("");
              break label625;
            }
            if ((localObject5 instanceof h))
            {
              bool = localObject5.equals(h.dIJ);
              break label625;
            }
            if ((localObject5 instanceof ce))
            {
              if (localObject5 == ((ce)localObject5).getDefaultInstanceForType())
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            if ((localObject5 instanceof Enum))
            {
              if (((Enum)localObject5).ordinal() == 0)
              {
                bool = true;
                break label625;
              }
              bool = false;
              break label625;
            }
            bool = false;
            break label625;
            bool = false;
            continue;
            bool = ((Boolean)be.invokeOrDie((Method)localObject3, paramce, new Object[0])).booleanValue();
          }
        }
      }
    }
    label869:
    if ((paramce instanceof be.a))
    {
      localObject1 = ((be.a)paramce).dRL.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        ((Map.Entry)((Iterator)localObject1).next()).getKey();
        throw null;
      }
    }
    if (((be)paramce).dRI != null) {
      ((be)paramce).dRI.b(paramStringBuilder, paramInt);
    }
  }
  
  static final void a(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    int k = 0;
    int j = 0;
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        a(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        a(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
      }
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
      paramStringBuilder.append(": \"").append(dj.f(h.dS((String)paramObject))).append('"');
      return;
    }
    if ((paramObject instanceof h))
    {
      paramStringBuilder.append(": \"").append(dj.f((h)paramObject)).append('"');
      return;
    }
    if ((paramObject instanceof be))
    {
      paramStringBuilder.append(" {");
      a((be)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      a(paramStringBuilder, paramInt + 2, "key", paramString.getKey());
      a(paramStringBuilder, paramInt + 2, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      i = k;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ").append(paramObject.toString());
  }
  
  private static final String ed(String paramString)
  {
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
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.cg
 * JD-Core Version:    0.7.0.1
 */