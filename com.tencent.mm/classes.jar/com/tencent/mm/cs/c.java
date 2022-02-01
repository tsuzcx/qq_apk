package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c
{
  static final Pattern agYW;
  public static final Object bfF;
  private final Map<String, Object> map;
  
  static
  {
    AppMethodBeat.i(231701);
    agYW = Pattern.compile("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?");
    bfF = new c.a((byte)0);
    AppMethodBeat.o(231701);
  }
  
  public c()
  {
    AppMethodBeat.i(231611);
    this.map = new HashMap();
    AppMethodBeat.o(231611);
  }
  
  public c(g paramg)
  {
    this();
    AppMethodBeat.i(231620);
    if (paramg.jQt() != '{')
    {
      paramg = paramg.bFc("A JSONObject text must begin with '{'");
      AppMethodBeat.o(231620);
      throw paramg;
    }
    do
    {
      paramg.cLO();
      String str;
      switch (paramg.jQt())
      {
      default: 
        paramg.cLO();
        str = paramg.jQu().toString();
        if (paramg.jQt() != ':')
        {
          paramg = paramg.bFc("Expected a ':' after a key");
          AppMethodBeat.o(231620);
          throw paramg;
        }
        break;
      case '\000': 
        paramg = paramg.bFc("A JSONObject text must end with '}'");
        AppMethodBeat.o(231620);
        throw paramg;
      case '}': 
        AppMethodBeat.o(231620);
        return;
      }
      if (str != null)
      {
        if (opt(str) != null)
        {
          paramg = paramg.bFc("Duplicate key \"" + str + "\"");
          AppMethodBeat.o(231620);
          throw paramg;
        }
        Object localObject = paramg.jQu();
        if (localObject != null) {
          V(str, localObject);
        }
      }
      switch (paramg.jQt())
      {
      default: 
        paramg = paramg.bFc("Expected a ',' or '}'");
        AppMethodBeat.o(231620);
        throw paramg;
      }
    } while (paramg.jQt() != '}');
    AppMethodBeat.o(231620);
    return;
    AppMethodBeat.o(231620);
  }
  
  /* Error */
  private c(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 52	com/tencent/mm/cs/c:<init>	()V
    //   4: ldc 114
    //   6: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   13: astore 7
    //   15: aload 7
    //   17: invokevirtual 124	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   20: ifnull +227 -> 247
    //   23: iconst_1
    //   24: istore_2
    //   25: iload_2
    //   26: ifeq +226 -> 252
    //   29: aload 7
    //   31: invokevirtual 128	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   34: astore 9
    //   36: aload 9
    //   38: arraylength
    //   39: istore 4
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: iload 4
    //   46: if_icmpge +447 -> 493
    //   49: aload 9
    //   51: iload_2
    //   52: aaload
    //   53: astore 10
    //   55: aload 10
    //   57: invokevirtual 134	java/lang/reflect/Method:getModifiers	()I
    //   60: istore_3
    //   61: iload_3
    //   62: invokestatic 140	java/lang/reflect/Modifier:isPublic	(I)Z
    //   65: ifeq +175 -> 240
    //   68: iload_3
    //   69: invokestatic 143	java/lang/reflect/Modifier:isStatic	(I)Z
    //   72: ifne +168 -> 240
    //   75: aload 10
    //   77: invokevirtual 147	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   80: arraylength
    //   81: ifne +159 -> 240
    //   84: aload 10
    //   86: invokevirtual 151	java/lang/reflect/Method:isBridge	()Z
    //   89: ifne +151 -> 240
    //   92: aload 10
    //   94: invokevirtual 154	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   97: getstatic 160	java/lang/Void:TYPE	Ljava/lang/Class;
    //   100: if_acmpeq +140 -> 240
    //   103: aload 10
    //   105: invokevirtual 163	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   108: astore 7
    //   110: ldc 164
    //   112: aload 7
    //   114: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne +145 -> 262
    //   120: ldc 172
    //   122: aload 7
    //   124: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifne +135 -> 262
    //   130: iconst_1
    //   131: istore_3
    //   132: iload_3
    //   133: ifeq +107 -> 240
    //   136: aload 10
    //   138: ldc 174
    //   140: invokestatic 178	com/tencent/mm/cs/c:b	(Ljava/lang/reflect/Method;Ljava/lang/Class;)I
    //   143: istore_3
    //   144: iload_3
    //   145: ifle +122 -> 267
    //   148: aload 10
    //   150: ldc 180
    //   152: invokestatic 178	com/tencent/mm/cs/c:b	(Ljava/lang/reflect/Method;Ljava/lang/Class;)I
    //   155: istore 5
    //   157: iload 5
    //   159: iflt +9 -> 168
    //   162: iload_3
    //   163: iload 5
    //   165: if_icmpgt +102 -> 267
    //   168: aconst_null
    //   169: astore 7
    //   171: aload 7
    //   173: ifnull +67 -> 240
    //   176: aload 7
    //   178: invokevirtual 183	java/lang/String:isEmpty	()Z
    //   181: ifne +59 -> 240
    //   184: aload 10
    //   186: aload_1
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokevirtual 187	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   194: astore 8
    //   196: aload 8
    //   198: ifnull +42 -> 240
    //   201: aload_0
    //   202: getfield 50	com/tencent/mm/cs/c:map	Ljava/util/Map;
    //   205: aload 7
    //   207: aload 8
    //   209: invokestatic 191	com/tencent/mm/cs/c:wrap	(Ljava/lang/Object;)Ljava/lang/Object;
    //   212: invokeinterface 197 3 0
    //   217: pop
    //   218: aload 8
    //   220: instanceof 199
    //   223: istore 6
    //   225: iload 6
    //   227: ifeq +13 -> 240
    //   230: aload 8
    //   232: checkcast 199	java/io/Closeable
    //   235: invokeinterface 202 1 0
    //   240: iload_2
    //   241: iconst_1
    //   242: iadd
    //   243: istore_2
    //   244: goto -201 -> 43
    //   247: iconst_0
    //   248: istore_2
    //   249: goto -224 -> 25
    //   252: aload 7
    //   254: invokevirtual 205	java/lang/Class:getDeclaredMethods	()[Ljava/lang/reflect/Method;
    //   257: astore 9
    //   259: goto -223 -> 36
    //   262: iconst_0
    //   263: istore_3
    //   264: goto -132 -> 132
    //   267: aload 10
    //   269: ldc 180
    //   271: invokestatic 209	com/tencent/mm/cs/c:a	(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   274: checkcast 180	com/tencent/mm/cs/e
    //   277: astore 7
    //   279: aload 7
    //   281: ifnull +38 -> 319
    //   284: aload 7
    //   286: invokeinterface 212 1 0
    //   291: ifnull +28 -> 319
    //   294: aload 7
    //   296: invokeinterface 212 1 0
    //   301: invokevirtual 183	java/lang/String:isEmpty	()Z
    //   304: ifne +15 -> 319
    //   307: aload 7
    //   309: invokeinterface 212 1 0
    //   314: astore 7
    //   316: goto -145 -> 171
    //   319: aload 10
    //   321: invokevirtual 163	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   324: astore 7
    //   326: aload 7
    //   328: ldc 214
    //   330: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   333: ifeq +46 -> 379
    //   336: aload 7
    //   338: invokevirtual 221	java/lang/String:length	()I
    //   341: iconst_3
    //   342: if_icmple +37 -> 379
    //   345: aload 7
    //   347: iconst_3
    //   348: invokevirtual 225	java/lang/String:substring	(I)Ljava/lang/String;
    //   351: astore 8
    //   353: aload 8
    //   355: invokevirtual 221	java/lang/String:length	()I
    //   358: ifeq +15 -> 373
    //   361: aload 8
    //   363: iconst_0
    //   364: invokevirtual 229	java/lang/String:charAt	(I)C
    //   367: invokestatic 235	java/lang/Character:isLowerCase	(C)Z
    //   370: ifeq +45 -> 415
    //   373: aconst_null
    //   374: astore 7
    //   376: goto -205 -> 171
    //   379: aload 7
    //   381: ldc 237
    //   383: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   386: ifeq +23 -> 409
    //   389: aload 7
    //   391: invokevirtual 221	java/lang/String:length	()I
    //   394: iconst_2
    //   395: if_icmple +14 -> 409
    //   398: aload 7
    //   400: iconst_2
    //   401: invokevirtual 225	java/lang/String:substring	(I)Ljava/lang/String;
    //   404: astore 8
    //   406: goto -53 -> 353
    //   409: aconst_null
    //   410: astore 7
    //   412: goto -241 -> 171
    //   415: aload 8
    //   417: invokevirtual 221	java/lang/String:length	()I
    //   420: iconst_1
    //   421: if_icmpne +16 -> 437
    //   424: aload 8
    //   426: getstatic 243	java/util/Locale:ROOT	Ljava/util/Locale;
    //   429: invokevirtual 247	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   432: astore 7
    //   434: goto -263 -> 171
    //   437: aload 8
    //   439: astore 7
    //   441: aload 8
    //   443: iconst_1
    //   444: invokevirtual 229	java/lang/String:charAt	(I)C
    //   447: invokestatic 250	java/lang/Character:isUpperCase	(C)Z
    //   450: ifne -16 -> 434
    //   453: new 86	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   460: aload 8
    //   462: iconst_0
    //   463: iconst_1
    //   464: invokevirtual 254	java/lang/String:substring	(II)Ljava/lang/String;
    //   467: getstatic 243	java/util/Locale:ROOT	Ljava/util/Locale;
    //   470: invokevirtual 247	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   473: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 8
    //   478: iconst_1
    //   479: invokevirtual 225	java/lang/String:substring	(I)Ljava/lang/String;
    //   482: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: astore 7
    //   490: goto -56 -> 434
    //   493: ldc 114
    //   495: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: return
    //   499: astore 7
    //   501: goto -261 -> 240
    //   504: astore 7
    //   506: goto -266 -> 240
    //   509: astore 7
    //   511: goto -271 -> 240
    //   514: astore 7
    //   516: goto -276 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	c
    //   0	519	1	paramObject	Object
    //   24	225	2	i	int
    //   60	204	3	j	int
    //   39	8	4	k	int
    //   155	11	5	m	int
    //   223	3	6	bool	boolean
    //   13	476	7	localObject1	Object
    //   499	1	7	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   504	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   509	1	7	localIllegalAccessException	java.lang.IllegalAccessException
    //   514	1	7	localIOException	IOException
    //   194	283	8	localObject2	Object
    //   34	224	9	arrayOfMethod	Method[]
    //   53	267	10	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   184	196	499	java/lang/reflect/InvocationTargetException
    //   201	225	499	java/lang/reflect/InvocationTargetException
    //   230	240	499	java/lang/reflect/InvocationTargetException
    //   184	196	504	java/lang/IllegalArgumentException
    //   201	225	504	java/lang/IllegalArgumentException
    //   230	240	504	java/lang/IllegalArgumentException
    //   184	196	509	java/lang/IllegalAccessException
    //   201	225	509	java/lang/IllegalAccessException
    //   230	240	509	java/lang/IllegalAccessException
    //   230	240	514	java/io/IOException
  }
  
  public c(String paramString)
  {
    this(new g(paramString));
    AppMethodBeat.i(231637);
    AppMethodBeat.o(231637);
  }
  
  private c(Map<?, ?> paramMap)
  {
    AppMethodBeat.i(231627);
    if (paramMap == null)
    {
      this.map = new HashMap();
      AppMethodBeat.o(231627);
      return;
    }
    this.map = new HashMap(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getKey() == null)
      {
        paramMap = new NullPointerException("Null key.");
        AppMethodBeat.o(231627);
        throw paramMap;
      }
      Object localObject = localEntry.getValue();
      if (localObject != null) {
        this.map.put(String.valueOf(localEntry.getKey()), wrap(localObject));
      }
    }
    AppMethodBeat.o(231627);
  }
  
  private c V(String paramString, Object paramObject)
  {
    AppMethodBeat.i(231655);
    if (paramString == null)
    {
      paramString = new NullPointerException("Null key.");
      AppMethodBeat.o(231655);
      throw paramString;
    }
    if (paramObject != null)
    {
      hc(paramObject);
      this.map.put(paramString, paramObject);
    }
    for (;;)
    {
      AppMethodBeat.o(231655);
      return this;
      remove(paramString);
    }
  }
  
  private Writer a(Writer paramWriter, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231698);
    for (;;)
    {
      String str;
      try
      {
        i = length();
        paramWriter.write(123);
        if (i == 1)
        {
          localObject = (Map.Entry)entrySet().iterator().next();
          str = (String)((Map.Entry)localObject).getKey();
          paramWriter.write(bEZ(str));
          paramWriter.write(58);
          if (paramInt1 > 0) {
            paramWriter.write(32);
          }
          try
          {
            a(paramWriter, ((Map.Entry)localObject).getValue(), paramInt1, paramInt2);
            paramWriter.write(125);
            AppMethodBeat.o(231698);
            return paramWriter;
          }
          catch (Exception paramWriter)
          {
            paramWriter = new b("Unable to write JSONObject value for key: ".concat(String.valueOf(str)), paramWriter);
            AppMethodBeat.o(231698);
            throw paramWriter;
          }
        }
        if (i == 0) {
          continue;
        }
      }
      catch (IOException paramWriter)
      {
        paramWriter = new b(paramWriter);
        AppMethodBeat.o(231698);
        throw paramWriter;
      }
      int j = paramInt2 + paramInt1;
      Object localObject = entrySet().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (i != 0) {
          paramWriter.write(44);
        }
        if (paramInt1 > 0) {
          paramWriter.write(10);
        }
        a(paramWriter, j);
        str = (String)localEntry.getKey();
        paramWriter.write(bEZ(str));
        paramWriter.write(58);
        if (paramInt1 > 0) {
          paramWriter.write(32);
        }
        try
        {
          a(paramWriter, localEntry.getValue(), paramInt1, j);
          i = 1;
        }
        catch (Exception paramWriter)
        {
          paramWriter = new b("Unable to write JSONObject value for key: ".concat(String.valueOf(str)), paramWriter);
          AppMethodBeat.o(231698);
          throw paramWriter;
        }
      }
      if (paramInt1 > 0) {
        paramWriter.write(10);
      }
      a(paramWriter, paramInt2);
    }
  }
  
  static final Writer a(Writer paramWriter, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231696);
    if ((paramObject == null) || (paramObject.equals(null))) {
      paramWriter.write("null");
    }
    for (;;)
    {
      AppMethodBeat.o(231696);
      return paramWriter;
      String str;
      if ((paramObject instanceof f)) {
        for (;;)
        {
          try
          {
            str = ((f)paramObject).jQp();
            if (str != null)
            {
              paramObject = str.toString();
              paramWriter.write(paramObject);
            }
          }
          catch (Exception paramWriter)
          {
            paramWriter = new b(paramWriter);
            AppMethodBeat.o(231696);
            throw paramWriter;
          }
          paramObject = bEZ(paramObject.toString());
        }
      }
      if ((paramObject instanceof Number))
      {
        paramObject = (Number)paramObject;
        if (paramObject == null)
        {
          paramWriter = new b("Null pointer");
          AppMethodBeat.o(231696);
          throw paramWriter;
        }
        hc(paramObject);
        str = paramObject.toString();
        paramObject = str;
        if (str.indexOf('.') > 0)
        {
          paramObject = str;
          if (str.indexOf('e') < 0)
          {
            paramObject = str;
            if (str.indexOf('E') < 0)
            {
              while (str.endsWith("0")) {
                str = str.substring(0, str.length() - 1);
              }
              paramObject = str;
              if (str.endsWith(".")) {
                paramObject = str.substring(0, str.length() - 1);
              }
            }
          }
        }
        if (agYW.matcher(paramObject).matches()) {
          paramWriter.write(paramObject);
        } else {
          a(paramObject, paramWriter);
        }
      }
      else if ((paramObject instanceof Boolean))
      {
        paramWriter.write(paramObject.toString());
      }
      else if ((paramObject instanceof Enum))
      {
        paramWriter.write(bEZ(((Enum)paramObject).name()));
      }
      else if ((paramObject instanceof c))
      {
        ((c)paramObject).a(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof a))
      {
        ((a)paramObject).a(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof Map))
      {
        new c((Map)paramObject).a(paramWriter, paramInt1, paramInt2);
      }
      else if ((paramObject instanceof Collection))
      {
        new a((Collection)paramObject).a(paramWriter, paramInt1, paramInt2);
      }
      else if (paramObject.getClass().isArray())
      {
        new a(paramObject).a(paramWriter, paramInt1, paramInt2);
      }
      else
      {
        a(paramObject.toString(), paramWriter);
      }
    }
  }
  
  private static Writer a(String paramString, Writer paramWriter)
  {
    AppMethodBeat.i(231668);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramWriter.write("\"\"");
      AppMethodBeat.o(231668);
      return paramWriter;
    }
    int m = paramString.length();
    paramWriter.write(34);
    int i = 0;
    int j = 0;
    if (i < m)
    {
      int k = paramString.charAt(i);
      switch (k)
      {
      default: 
        if ((k < 32) || ((k >= 128) && (k < 160)) || ((k >= 8192) && (k < 8448)))
        {
          paramWriter.write("\\u");
          String str = Integer.toHexString(k);
          paramWriter.write("0000", 0, 4 - str.length());
          paramWriter.write(str);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        paramWriter.write(92);
        paramWriter.write(k);
        continue;
        if (j == 60) {
          paramWriter.write(92);
        }
        paramWriter.write(k);
        continue;
        paramWriter.write("\\b");
        continue;
        paramWriter.write("\\t");
        continue;
        paramWriter.write("\\n");
        continue;
        paramWriter.write("\\f");
        continue;
        paramWriter.write("\\r");
      }
    }
    paramWriter.write(34);
    AppMethodBeat.o(231668);
    return paramWriter;
  }
  
  private static <A extends Annotation> A a(Method paramMethod, Class<A> paramClass)
  {
    AppMethodBeat.i(231646);
    if ((paramMethod == null) || (paramClass == null))
    {
      AppMethodBeat.o(231646);
      return null;
    }
    if (paramMethod.isAnnotationPresent(paramClass))
    {
      paramMethod = paramMethod.getAnnotation(paramClass);
      AppMethodBeat.o(231646);
      return paramMethod;
    }
    Class localClass = paramMethod.getDeclaringClass();
    if (localClass.getSuperclass() == null)
    {
      AppMethodBeat.o(231646);
      return null;
    }
    Class[] arrayOfClass = localClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < j) {
        localObject = arrayOfClass[i];
      }
      try
      {
        localObject = a(((Class)localObject).getMethod(paramMethod.getName(), paramMethod.getParameterTypes()), paramClass);
        AppMethodBeat.o(231646);
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        i += 1;
        continue;
        try
        {
          paramMethod = a(localClass.getSuperclass().getMethod(paramMethod.getName(), paramMethod.getParameterTypes()), paramClass);
          AppMethodBeat.o(231646);
          return paramMethod;
        }
        catch (SecurityException paramMethod)
        {
          AppMethodBeat.o(231646);
          return null;
        }
        catch (NoSuchMethodException paramMethod)
        {
          AppMethodBeat.o(231646);
          return null;
        }
      }
      catch (SecurityException localSecurityException)
      {
        label120:
        break label120;
      }
    }
  }
  
  static final void a(Writer paramWriter, int paramInt)
  {
    AppMethodBeat.i(231697);
    int i = 0;
    while (i < paramInt)
    {
      paramWriter.write(32);
      i += 1;
    }
    AppMethodBeat.o(231697);
  }
  
  private static int b(Method paramMethod, Class<? extends Annotation> paramClass)
  {
    AppMethodBeat.i(231651);
    if ((paramMethod == null) || (paramClass == null))
    {
      AppMethodBeat.o(231651);
      return -1;
    }
    if (paramMethod.isAnnotationPresent(paramClass))
    {
      AppMethodBeat.o(231651);
      return 1;
    }
    Class localClass1 = paramMethod.getDeclaringClass();
    if (localClass1.getSuperclass() == null)
    {
      AppMethodBeat.o(231651);
      return -1;
    }
    Class[] arrayOfClass = localClass1.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      Class localClass2;
      if (i < j) {
        localClass2 = arrayOfClass[i];
      }
      try
      {
        int k = b(localClass2.getMethod(paramMethod.getName(), paramMethod.getParameterTypes()), paramClass);
        if (k > 0)
        {
          AppMethodBeat.o(231651);
          return k + 1;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        i += 1;
        continue;
        try
        {
          i = b(localClass1.getSuperclass().getMethod(paramMethod.getName(), paramMethod.getParameterTypes()), paramClass);
          if (i > 0)
          {
            AppMethodBeat.o(231651);
            return i + 1;
          }
          AppMethodBeat.o(231651);
          return -1;
        }
        catch (SecurityException paramMethod)
        {
          AppMethodBeat.o(231651);
          return -1;
        }
        catch (NoSuchMethodException paramMethod)
        {
          AppMethodBeat.o(231651);
          return -1;
        }
      }
      catch (SecurityException localSecurityException)
      {
        label121:
        break label121;
      }
    }
  }
  
  private static String bEZ(String paramString)
  {
    AppMethodBeat.i(231660);
    StringWriter localStringWriter = new StringWriter();
    synchronized (localStringWriter.getBuffer())
    {
      try
      {
        paramString = a(paramString, localStringWriter).toString();
        AppMethodBeat.o(231660);
        return paramString;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(231660);
        return "";
      }
    }
  }
  
  private static Number bFa(String paramString)
  {
    AppMethodBeat.i(231683);
    int j = paramString.charAt(0);
    if (((j >= 48) && (j <= 57)) || (j == 45))
    {
      int i;
      if ((paramString.indexOf('.') >= 0) || (paramString.indexOf('e') >= 0) || (paramString.indexOf('E') >= 0) || ("-0".equals(paramString))) {
        i = 1;
      }
      while (i != 0) {
        try
        {
          BigDecimal localBigDecimal = new BigDecimal(paramString);
          if ((j == 45) && (BigDecimal.ZERO.compareTo(localBigDecimal) == 0))
          {
            double d = -0.0D;
            AppMethodBeat.o(231683);
            return Double.valueOf(d);
            i = 0;
          }
          else
          {
            AppMethodBeat.o(231683);
            return localBigDecimal;
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            Object localObject = Double.valueOf(paramString);
            if ((((Double)localObject).isNaN()) || (((Double)localObject).isInfinite()))
            {
              localObject = new NumberFormatException("val [" + paramString + "] is not a valid number.");
              AppMethodBeat.o(231683);
              throw ((Throwable)localObject);
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
            AppMethodBeat.o(231683);
            throw paramString;
          }
          AppMethodBeat.o(231683);
          return localNumberFormatException2;
        }
      }
      if ((j == 48) && (paramString.length() > 1))
      {
        i = paramString.charAt(1);
        if ((i >= 48) && (i <= 57))
        {
          paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
          AppMethodBeat.o(231683);
          throw paramString;
        }
      }
      else if ((j == 45) && (paramString.length() > 2))
      {
        i = paramString.charAt(1);
        j = paramString.charAt(2);
        if ((i == 48) && (j >= 48) && (j <= 57))
        {
          paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
          AppMethodBeat.o(231683);
          throw paramString;
        }
      }
      paramString = new BigInteger(paramString);
      if (paramString.bitLength() <= 31)
      {
        i = paramString.intValue();
        AppMethodBeat.o(231683);
        return Integer.valueOf(i);
      }
      if (paramString.bitLength() <= 63)
      {
        long l = paramString.longValue();
        AppMethodBeat.o(231683);
        return Long.valueOf(l);
      }
      AppMethodBeat.o(231683);
      return paramString;
    }
    paramString = new NumberFormatException("val [" + paramString + "] is not a valid number.");
    AppMethodBeat.o(231683);
    throw paramString;
  }
  
  public static Object bFb(String paramString)
  {
    AppMethodBeat.i(231686);
    if ("".equals(paramString))
    {
      AppMethodBeat.o(231686);
      return paramString;
    }
    if ("true".equalsIgnoreCase(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(231686);
      return paramString;
    }
    if ("false".equalsIgnoreCase(paramString))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(231686);
      return paramString;
    }
    if ("null".equalsIgnoreCase(paramString))
    {
      paramString = bfF;
      AppMethodBeat.o(231686);
      return paramString;
    }
    int i = paramString.charAt(0);
    if (((i >= 48) && (i <= 57)) || (i == 45)) {
      try
      {
        Number localNumber = bFa(paramString);
        AppMethodBeat.o(231686);
        return localNumber;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(231686);
    return paramString;
  }
  
  private Set<Map.Entry<String, Object>> entrySet()
  {
    AppMethodBeat.i(231640);
    Set localSet = this.map.entrySet();
    AppMethodBeat.o(231640);
    return localSet;
  }
  
  private static boolean f(Number paramNumber)
  {
    AppMethodBeat.i(231676);
    if (((paramNumber instanceof Double)) && ((((Double)paramNumber).isInfinite()) || (((Double)paramNumber).isNaN())))
    {
      AppMethodBeat.o(231676);
      return false;
    }
    if (((paramNumber instanceof Float)) && ((((Float)paramNumber).isInfinite()) || (((Float)paramNumber).isNaN())))
    {
      AppMethodBeat.o(231676);
      return false;
    }
    AppMethodBeat.o(231676);
    return true;
  }
  
  public static void hc(Object paramObject)
  {
    AppMethodBeat.i(231687);
    if (((paramObject instanceof Number)) && (!f((Number)paramObject)))
    {
      paramObject = new b("JSON does not allow non-finite numbers.");
      AppMethodBeat.o(231687);
      throw paramObject;
    }
    AppMethodBeat.o(231687);
  }
  
  private String jQo()
  {
    AppMethodBeat.i(231688);
    Object localObject1 = new StringWriter();
    synchronized (((StringWriter)localObject1).getBuffer())
    {
      localObject1 = a((Writer)localObject1, 0, 0).toString();
      AppMethodBeat.o(231688);
      return localObject1;
    }
  }
  
  private Object remove(String paramString)
  {
    AppMethodBeat.i(231672);
    paramString = this.map.remove(paramString);
    AppMethodBeat.o(231672);
    return paramString;
  }
  
  public static Object wrap(Object paramObject)
  {
    AppMethodBeat.i(231692);
    try
    {
      if (bfF.equals(paramObject))
      {
        paramObject = bfF;
        AppMethodBeat.o(231692);
        return paramObject;
      }
      if ((!(paramObject instanceof c)) && (!(paramObject instanceof a)) && (!bfF.equals(paramObject)) && (!(paramObject instanceof f)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof String)) && (!(paramObject instanceof BigInteger)) && (!(paramObject instanceof BigDecimal)))
      {
        boolean bool = paramObject instanceof Enum;
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(231692);
        return paramObject;
      }
      if ((paramObject instanceof Collection))
      {
        paramObject = new a((Collection)paramObject);
        AppMethodBeat.o(231692);
        return paramObject;
      }
      if (paramObject.getClass().isArray())
      {
        paramObject = new a(paramObject);
        AppMethodBeat.o(231692);
        return paramObject;
      }
      if ((paramObject instanceof Map))
      {
        paramObject = new c((Map)paramObject);
        AppMethodBeat.o(231692);
        return paramObject;
      }
      Object localObject = paramObject.getClass().getPackage();
      if (localObject != null) {}
      for (localObject = ((Package)localObject).getName(); (((String)localObject).startsWith("java.")) || (((String)localObject).startsWith("javax.")) || (paramObject.getClass().getClassLoader() == null); localObject = "")
      {
        paramObject = paramObject.toString();
        AppMethodBeat.o(231692);
        return paramObject;
      }
      paramObject = new c(paramObject);
      AppMethodBeat.o(231692);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      AppMethodBeat.o(231692);
    }
    return null;
  }
  
  public final c U(String paramString, Object paramObject)
  {
    AppMethodBeat.i(231703);
    hc(paramObject);
    Object localObject = opt(paramString);
    if (localObject == null)
    {
      localObject = paramObject;
      if ((paramObject instanceof a)) {
        localObject = new a().hb(paramObject);
      }
      V(paramString, localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(231703);
      return this;
      if ((localObject instanceof a)) {
        ((a)localObject).hb(paramObject);
      } else {
        V(paramString, new a().hb(localObject).hb(paramObject));
      }
    }
  }
  
  public final Set<String> keySet()
  {
    AppMethodBeat.i(231704);
    Set localSet = this.map.keySet();
    AppMethodBeat.o(231704);
    return localSet;
  }
  
  public final int length()
  {
    AppMethodBeat.i(231706);
    int i = this.map.size();
    AppMethodBeat.o(231706);
    return i;
  }
  
  public final Object opt(String paramString)
  {
    AppMethodBeat.i(231707);
    if (paramString == null)
    {
      AppMethodBeat.o(231707);
      return null;
    }
    paramString = this.map.get(paramString);
    AppMethodBeat.o(231707);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(231709);
    try
    {
      String str = jQo();
      AppMethodBeat.o(231709);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(231709);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.c
 * JD-Core Version:    0.7.0.1
 */