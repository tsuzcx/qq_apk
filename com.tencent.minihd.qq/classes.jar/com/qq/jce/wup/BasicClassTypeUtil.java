package com.qq.jce.wup;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BasicClassTypeUtil
{
  private static ClassLoader classLoader = null;
  private static boolean classLoaderInitialize = true;
  
  private static void addType(ArrayList<String> paramArrayList, String paramString)
  {
    int i = paramString.length();
    int j;
    do
    {
      j = i;
      if (paramString.charAt(i - 1) != '>') {
        break;
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    paramArrayList.add(0, uni2JavaType(paramString.substring(0, j)));
  }
  
  /* Error */
  public static Object createClassByName(String paramString)
    throws ObjectCreateException
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 54
    //   3: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +10 -> 16
    //   9: iconst_0
    //   10: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: astore_1
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: ldc 66
    //   19: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +8 -> 30
    //   25: iconst_0
    //   26: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   29: areturn
    //   30: aload_0
    //   31: ldc 73
    //   33: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +8 -> 44
    //   39: iconst_0
    //   40: invokestatic 78	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   43: areturn
    //   44: aload_0
    //   45: ldc 80
    //   47: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +8 -> 58
    //   53: dconst_0
    //   54: invokestatic 85	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   57: areturn
    //   58: aload_0
    //   59: ldc 87
    //   61: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifeq +8 -> 72
    //   67: fconst_0
    //   68: invokestatic 92	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   71: areturn
    //   72: aload_0
    //   73: ldc 94
    //   75: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +8 -> 86
    //   81: lconst_0
    //   82: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: areturn
    //   86: aload_0
    //   87: ldc 101
    //   89: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +8 -> 100
    //   95: iconst_0
    //   96: invokestatic 106	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   99: areturn
    //   100: aload_0
    //   101: ldc 108
    //   103: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +13 -> 119
    //   109: new 110	java/lang/IllegalArgumentException
    //   112: dup
    //   113: ldc 112
    //   115: invokespecial 115	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   118: athrow
    //   119: aload_0
    //   120: ldc 117
    //   122: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +6 -> 131
    //   128: ldc 119
    //   130: areturn
    //   131: aload_0
    //   132: ldc 121
    //   134: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifeq +11 -> 148
    //   140: new 40	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 122	java/util/ArrayList:<init>	()V
    //   147: areturn
    //   148: aload_0
    //   149: ldc 124
    //   151: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +11 -> 165
    //   157: new 126	java/util/HashMap
    //   160: dup
    //   161: invokespecial 127	java/util/HashMap:<init>	()V
    //   164: areturn
    //   165: aload_0
    //   166: ldc 129
    //   168: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +6 -> 177
    //   174: ldc 129
    //   176: areturn
    //   177: aload_0
    //   178: astore_1
    //   179: aload_0
    //   180: ldc 131
    //   182: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifne -171 -> 14
    //   188: getstatic 12	com/qq/jce/wup/BasicClassTypeUtil:classLoader	Ljava/lang/ClassLoader;
    //   191: ifnull +30 -> 221
    //   194: aload_0
    //   195: getstatic 14	com/qq/jce/wup/BasicClassTypeUtil:classLoaderInitialize	Z
    //   198: getstatic 12	com/qq/jce/wup/BasicClassTypeUtil:classLoader	Ljava/lang/ClassLoader;
    //   201: invokestatic 137	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   204: astore_0
    //   205: aload_0
    //   206: iconst_0
    //   207: anewarray 133	java/lang/Class
    //   210: invokevirtual 141	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokevirtual 147	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   220: areturn
    //   221: aload_0
    //   222: invokestatic 150	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   225: astore_0
    //   226: goto -21 -> 205
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   234: new 50	com/qq/jce/wup/ObjectCreateException
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 156	com/qq/jce/wup/ObjectCreateException:<init>	(Ljava/lang/Exception;)V
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramString	String
    //   13	166	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   188	205	229	java/lang/Exception
    //   205	221	229	java/lang/Exception
    //   221	226	229	java/lang/Exception
  }
  
  public static Object createClassByUni(String paramString)
    throws ObjectCreateException
  {
    paramString = getTypeList(paramString);
    Object localObject2 = null;
    Iterator localIterator = paramString.iterator();
    paramString = null;
    Object localObject1 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject2 = createClassByName((String)localIterator.next());
      if ((localObject2 instanceof String)) {
        if ("Array".equals((String)localObject2))
        {
          if (localObject1 != null) {
            break label308;
          }
          localObject2 = Array.newInstance(Byte.class, 0);
          localObject3 = localObject1;
          localObject1 = paramString;
          paramString = (String)localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = paramString;
      paramString = (String)localObject3;
      break;
      if ("?".equals((String)localObject2))
      {
        localObject3 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject3;
      }
      else if (localObject1 == null)
      {
        localObject1 = localObject2;
        localObject3 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject3;
      }
      else
      {
        paramString = (String)localObject2;
        continue;
        if ((localObject2 instanceof List))
        {
          if ((localObject1 != null) && ((localObject1 instanceof Byte)))
          {
            localObject3 = Array.newInstance(Byte.class, 1);
            Array.set(localObject3, 0, localObject1);
            localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
          else
          {
            if (localObject1 != null) {
              ((List)localObject2).add(localObject1);
            }
            localObject3 = null;
            localObject1 = paramString;
            paramString = (String)localObject3;
          }
        }
        else
        {
          if ((localObject2 instanceof Map))
          {
            int i;
            if (localObject1 != null)
            {
              i = 1;
              label239:
              if (paramString == null) {
                break label276;
              }
            }
            label276:
            for (int j = 1;; j = 0)
            {
              if ((j & i) != 0) {
                ((Map)localObject2).put(localObject1, paramString);
              }
              paramString = null;
              localObject1 = null;
              break;
              i = 0;
              break label239;
            }
          }
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            localObject3 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject3;
          }
          else
          {
            paramString = (String)localObject2;
            continue;
            return localObject2;
            label308:
            localObject3 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public static String getClassTransName(String paramString)
  {
    String str;
    if (paramString.equals("int")) {
      str = "Integer";
    }
    do
    {
      return str;
      if (paramString.equals("boolean")) {
        return "Boolean";
      }
      if (paramString.equals("byte")) {
        return "Byte";
      }
      if (paramString.equals("double")) {
        return "Double";
      }
      if (paramString.equals("float")) {
        return "Float";
      }
      if (paramString.equals("long")) {
        return "Long";
      }
      if (paramString.equals("short")) {
        return "Short";
      }
      str = paramString;
    } while (!paramString.equals("char"));
    return "Character";
  }
  
  public static ArrayList<String> getTypeList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    int i = paramString.indexOf("<");
    while (m < i)
    {
      addType(localArrayList, paramString.substring(m, i));
      int n = i + 1;
      i = paramString.indexOf("<", n);
      int k = paramString.indexOf(",", n);
      int j = i;
      if (i == -1) {
        j = k;
      }
      m = n;
      i = j;
      if (k != -1)
      {
        m = n;
        i = j;
        if (k < j)
        {
          i = k;
          m = n;
        }
      }
    }
    addType(localArrayList, paramString.substring(m, paramString.length()));
    return localArrayList;
  }
  
  public static String getVariableInit(String paramString1, String paramString2)
  {
    if (paramString2.equals("int")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("boolean")) {
      return paramString2 + " " + paramString1 + "=false ;\n";
    }
    if (paramString2.equals("byte")) {
      return paramString2 + " " + paramString1 + " ;\n";
    }
    if (paramString2.equals("double")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("float")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("long")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("short")) {
      return paramString2 + " " + paramString1 + "=0 ;\n";
    }
    if (paramString2.equals("char")) {
      return paramString2 + " " + paramString1 + " ;\n";
    }
    return paramString2 + " " + paramString1 + " = null ;\n";
  }
  
  public static boolean isBasicType(String paramString)
  {
    if (paramString.equals("int")) {}
    while ((paramString.equals("boolean")) || (paramString.equals("byte")) || (paramString.equals("double")) || (paramString.equals("float")) || (paramString.equals("long")) || (paramString.equals("short")) || (paramString.equals("char")) || (paramString.equals("Integer")) || (paramString.equals("Boolean")) || (paramString.equals("Byte")) || (paramString.equals("Double")) || (paramString.equals("Float")) || (paramString.equals("Long")) || (paramString.equals("Short")) || (paramString.equals("Char"))) {
      return true;
    }
    return false;
  }
  
  public static String java2UniType(String paramString)
  {
    String str;
    if ((paramString.equals("java.lang.Integer")) || (paramString.equals("int"))) {
      str = "int32";
    }
    do
    {
      return str;
      if ((paramString.equals("java.lang.Boolean")) || (paramString.equals("boolean"))) {
        return "bool";
      }
      if ((paramString.equals("java.lang.Byte")) || (paramString.equals("byte"))) {
        return "char";
      }
      if ((paramString.equals("java.lang.Double")) || (paramString.equals("double"))) {
        return "double";
      }
      if ((paramString.equals("java.lang.Float")) || (paramString.equals("float"))) {
        return "float";
      }
      if ((paramString.equals("java.lang.Long")) || (paramString.equals("long"))) {
        return "int64";
      }
      if ((paramString.equals("java.lang.Short")) || (paramString.equals("short"))) {
        return "short";
      }
      if (paramString.equals("java.lang.Character")) {
        throw new IllegalArgumentException("can not support java.lang.Character");
      }
      if (paramString.equals("java.lang.String")) {
        return "string";
      }
      if (paramString.equals("java.util.List")) {
        return "list";
      }
      str = paramString;
    } while (!paramString.equals("java.util.Map"));
    return "map";
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new ArrayList();
    paramArrayOfString.add("char");
    paramArrayOfString.add("list<char>");
    paramArrayOfString.add("list<list<char>>");
    paramArrayOfString.add("map<short,string>");
    paramArrayOfString.add("map<double,map<float,list<bool>>>");
    paramArrayOfString.add("map<int64,list<Test.UserInfo>>");
    paramArrayOfString.add("map<short,Test.FriendInfo>");
    paramArrayOfString = paramArrayOfString.iterator();
    while (paramArrayOfString.hasNext())
    {
      ArrayList localArrayList = getTypeList((String)paramArrayOfString.next());
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        System.out.println(str);
      }
      Collections.reverse(localArrayList);
      System.out.println("-------------finished " + transTypeList(localArrayList));
    }
  }
  
  public static void setClassLoader(boolean paramBoolean, ClassLoader paramClassLoader)
  {
    classLoaderInitialize = paramBoolean;
    classLoader = paramClassLoader;
  }
  
  public static String transTypeList(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramArrayList.set(i, java2UniType((String)paramArrayList.get(i)));
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    if (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (str.equals("list"))
      {
        paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
        paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("map"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
        else if (str.equals("Array"))
        {
          paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
          paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
        }
      }
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  public static String uni2JavaType(String paramString)
  {
    String str;
    if (paramString.equals("int32")) {
      str = "java.lang.Integer";
    }
    do
    {
      return str;
      if (paramString.equals("bool")) {
        return "java.lang.Boolean";
      }
      if (paramString.equals("char")) {
        return "java.lang.Byte";
      }
      if (paramString.equals("double")) {
        return "java.lang.Double";
      }
      if (paramString.equals("float")) {
        return "java.lang.Float";
      }
      if (paramString.equals("int64")) {
        return "java.lang.Long";
      }
      if (paramString.equals("short")) {
        return "java.lang.Short";
      }
      if (paramString.equals("string")) {
        return "java.lang.String";
      }
      if (paramString.equals("list")) {
        return "java.util.List";
      }
      str = paramString;
    } while (!paramString.equals("map"));
    return "java.util.Map";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.qq.jce.wup.BasicClassTypeUtil
 * JD-Core Version:    0.7.0.1
 */