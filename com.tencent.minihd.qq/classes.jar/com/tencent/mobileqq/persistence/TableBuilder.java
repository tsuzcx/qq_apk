package com.tencent.mobileqq.persistence;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TableBuilder
{
  public static final String a = "_id";
  public static final Map a = new HashMap();
  private static final Map b = new ConcurrentHashMap();
  private static final Map c = new ConcurrentHashMap();
  private static final Map d = new HashMap();
  private static final Map e = new HashMap();
  
  static
  {
    a.put(Byte.TYPE, "INTEGER");
    a.put(Boolean.TYPE, "INTEGER");
    a.put(Short.TYPE, "INTEGER");
    a.put(Integer.TYPE, "INTEGER");
    a.put(Long.TYPE, "INTEGER");
    a.put(String.class, "TEXT");
    a.put([B.class, "BLOB");
    a.put(Float.TYPE, "REAL");
    a.put(Double.TYPE, "REAL");
  }
  
  public static Entity a(Class paramClass)
  {
    Entity localEntity2 = (Entity)e.get(paramClass);
    Entity localEntity1 = localEntity2;
    if (localEntity2 == null)
    {
      localEntity1 = (Entity)paramClass.newInstance();
      e.put(paramClass, localEntity1);
    }
    return localEntity1;
  }
  
  public static String a(Entity paramEntity)
  {
    String str1 = paramEntity.getTableName();
    if (d.containsKey(str1)) {
      return (String)d.get(str1);
    }
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
    paramEntity = paramEntity.getClassForTable();
    Object localObject1 = a(paramEntity).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Field localField = (Field)((Iterator)localObject1).next();
      String str2 = localField.getName();
      Object localObject2 = localField.getType();
      localObject2 = (String)a.get(localObject2);
      if (localObject2 != null)
      {
        localStringBuilder.append(',');
        localStringBuilder.append(str2 + " " + (String)localObject2);
        if (localField.isAnnotationPresent(unique.class)) {
          localStringBuilder.append(" UNIQUE");
        } else if (localField.isAnnotationPresent(defaultzero.class)) {
          localStringBuilder.append(" default 0");
        }
      }
    }
    if (paramEntity.isAnnotationPresent(uniqueConstraints.class))
    {
      paramEntity = (uniqueConstraints)paramEntity.getAnnotation(uniqueConstraints.class);
      localObject1 = paramEntity.columnNames();
      localStringBuilder.append(",UNIQUE(" + (String)localObject1 + ")");
      paramEntity = paramEntity.clause().toString();
      localStringBuilder.append(" ON CONFLICT " + paramEntity);
    }
    localStringBuilder.append(')');
    paramEntity = localStringBuilder.toString();
    d.put(str1, paramEntity);
    return paramEntity;
  }
  
  public static String a(Class paramClass)
  {
    return a(paramClass).getTableName();
  }
  
  public static String a(String paramString)
  {
    return "DROP TABLE IF EXISTS " + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean) {
      return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3 + " default " + 0;
    }
    return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3;
  }
  
  public static List a(Entity paramEntity)
  {
    Class localClass = paramEntity.getClassForTable();
    Object localObject1 = (List)b.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      paramEntity = new ArrayList();
      localObject1 = localClass.getFields();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((!Modifier.isStatic(localObject2.getModifiers())) && (!localObject2.isAnnotationPresent(notColumn.class))) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      b.put(localClass, paramEntity);
    }
    return paramEntity;
  }
  
  public static List a(Class paramClass)
  {
    Object localObject1 = null;
    try
    {
      paramClass = ((Entity)paramClass.newInstance()).getClassForTable();
      Object localObject2 = (List)b.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = paramClass.getFields();
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          if ((!Modifier.isStatic(localObject3.getModifiers())) && (!localObject3.isAnnotationPresent(notColumn.class))) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = (Class)localObject1;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = (Class)localObject1;
      }
      b.put(paramClass, localObject1);
    }
    return localObject1;
  }
  
  public static String b(Class paramClass)
  {
    try
    {
      paramClass = a(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static List b(Entity paramEntity)
  {
    Class localClass = paramEntity.getClassForTable();
    Object localObject1 = (List)c.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      paramEntity = new ArrayList();
      localObject1 = localClass.getFields();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(localObject2.getModifiers())) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      c.put(localClass, paramEntity);
    }
    return paramEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TableBuilder
 * JD-Core Version:    0.7.0.1
 */