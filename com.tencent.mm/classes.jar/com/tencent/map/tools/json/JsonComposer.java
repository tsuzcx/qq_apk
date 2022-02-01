package com.tencent.map.tools.json;

import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public abstract class JsonComposer
  implements JsonEncoder, JsonParser
{
  private static Map<Class, Map<Field, String>> sClassJsonMap = new HashMap();
  private boolean mAllowEmpty = true;
  private Map<Class, JsonParser.Deserializer> mClassDeserializer = new HashMap();
  private Map<Field, JsonParser.Deserializer> mFieldDeserializer = new HashMap();
  private String mFieldNamePrefix;
  private FieldNameStyle mFieldNameStyle = FieldNameStyle.HUMP;
  private Map<Field, String> mJsonFields;
  
  private void checkJsonComposerElements()
  {
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      try
      {
        Object localObject1 = (JsonType)getClass().getAnnotation(JsonType.class);
        if (localObject1 != null)
        {
          this.mAllowEmpty = ((JsonType)localObject1).allowEmpty();
          this.mFieldNameStyle = ((JsonType)localObject1).fieldNameStyle();
          this.mFieldNamePrefix = ((JsonType)localObject1).fieldNamePrefix();
          localObject1 = ((JsonType)localObject1).deserializer();
          if (localObject1 != JsonParser.Deserializer.class)
          {
            localObject1 = (JsonParser.Deserializer)Util.newInstance((Class)localObject1, new Object[0]);
            this.mClassDeserializer.put(getClass(), localObject1);
          }
        }
        this.mJsonFields = ((Map)sClassJsonMap.get(getClass()));
        localObject3 = new ArrayList();
        if (this.mJsonFields == null)
        {
          this.mJsonFields = new Hashtable();
          localObject1 = getClass();
          if (localObject1 != JsonComposer.class)
          {
            ((Collection)localObject3).addAll(Arrays.asList(((Class)localObject1).getDeclaredFields()));
            localObject1 = ((Class)localObject1).getSuperclass();
            continue;
          }
          sClassJsonMap.put(getClass(), this.mJsonFields);
          localObject1 = localObject3;
          localObject1 = ((Collection)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (Field)((Iterator)localObject1).next();
          if ((Modifier.isStatic(((Field)localObject3).getModifiers())) || (Modifier.isTransient(((Field)localObject3).getModifiers())) || (Modifier.isFinal(((Field)localObject3).getModifiers()))) {
            continue;
          }
          localObject4 = (JsonType)((Field)localObject3).getType().getAnnotation(JsonType.class);
          if (localObject4 != null)
          {
            localObject4 = ((JsonType)localObject4).deserializer();
            if (localObject4 != JsonParser.Deserializer.class)
            {
              localObject4 = (JsonParser.Deserializer)Util.newInstance((Class)localObject4, new Object[0]);
              this.mFieldDeserializer.put(localObject3, localObject4);
            }
          }
          localObject4 = (Json)((Field)localObject3).getAnnotation(Json.class);
          if (localObject4 == null) {
            break label428;
          }
          if (!((Json)localObject4).ignore())
          {
            if (!TextUtils.isEmpty(((Json)localObject4).name())) {
              break label408;
            }
            this.mJsonFields.put(localObject3, translateFieldName(((Field)localObject3).getName()));
          }
          localObject4 = ((Json)localObject4).deserializer();
          if (localObject4 == JsonParser.Deserializer.class) {
            continue;
          }
          localObject4 = (JsonParser.Deserializer)Util.newInstance((Class)localObject4, new Object[0]);
          this.mFieldDeserializer.put(localObject3, localObject4);
          continue;
        }
        Set localSet = this.mJsonFields.keySet();
      }
      finally {}
      continue;
      label408:
      this.mJsonFields.put(localObject3, ((Json)localObject4).name());
      continue;
      label428:
      if (!((Field)localObject3).getName().contains("this")) {
        this.mJsonFields.put(localObject3, translateFieldName(((Field)localObject3).getName()));
      }
    }
  }
  
  private String pickString(String paramString)
  {
    String str;
    do
    {
      Object localObject;
      if (TextUtils.isEmpty(paramString)) {
        localObject = paramString;
      }
      do
      {
        int j;
        int i;
        do
        {
          return localObject;
          j = paramString.indexOf("<");
          int k = paramString.lastIndexOf(">");
          i = j;
          if (j < 0) {
            i = 0;
          }
          j = k;
          if (k < 0) {
            j = paramString.length();
          }
          localObject = paramString;
        } while (j <= i);
        str = paramString.substring(i + 1, j);
        localObject = str;
      } while (!str.contains("<"));
      paramString = str;
    } while (str.contains(">"));
    return str;
  }
  
  private String translateFieldName(String paramString)
  {
    Object localObject = paramString;
    if (this.mFieldNamePrefix != null)
    {
      localObject = paramString;
      if (paramString.startsWith(this.mFieldNamePrefix))
      {
        localObject = paramString.substring(this.mFieldNamePrefix.length(), this.mFieldNamePrefix.length() + 1);
        paramString = paramString.substring(this.mFieldNamePrefix.length() + 1);
        localObject = ((String)localObject).toLowerCase() + paramString;
      }
    }
    paramString = (String)localObject;
    if (this.mFieldNameStyle == FieldNameStyle.UNDERLINE)
    {
      paramString = Pattern.compile("[A-Z]").matcher((CharSequence)localObject);
      localObject = new StringBuffer();
      while (paramString.find()) {
        paramString.appendReplacement((StringBuffer)localObject, "_" + paramString.group(0).toLowerCase());
      }
      paramString.appendTail((StringBuffer)localObject);
      paramString = ((StringBuffer)localObject).toString();
    }
    return paramString;
  }
  
  protected boolean onEachItemParse(String paramString, Object paramObject)
  {
    return false;
  }
  
  protected boolean onEachItemToJson(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    return false;
  }
  
  /* Error */
  public void parse(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 285	com/tencent/map/tools/json/JsonComposer:checkJsonComposerElements	()V
    //   4: aload_0
    //   5: getfield 47	com/tencent/map/tools/json/JsonComposer:mClassDeserializer	Ljava/util/Map;
    //   8: aload_0
    //   9: invokevirtual 52	java/lang/Object:getClass	()Ljava/lang/Class;
    //   12: invokeinterface 95 2 0
    //   17: checkcast 79	com/tencent/map/tools/json/JsonParser$Deserializer
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +21 -> 43
    //   25: aload_2
    //   26: aload_0
    //   27: aload_0
    //   28: invokevirtual 52	java/lang/Object:getClass	()Ljava/lang/Class;
    //   31: invokevirtual 286	java/lang/Class:getName	()Ljava/lang/String;
    //   34: aload_1
    //   35: invokeinterface 290 4 0
    //   40: pop
    //   41: return
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 97	com/tencent/map/tools/json/JsonComposer:mJsonFields	Ljava/util/Map;
    //   47: invokeinterface 293 1 0
    //   52: invokeinterface 296 1 0
    //   57: astore_3
    //   58: aload_3
    //   59: invokeinterface 131 1 0
    //   64: ifeq -23 -> 41
    //   67: aload_3
    //   68: invokeinterface 135 1 0
    //   73: checkcast 298	java/util/Map$Entry
    //   76: astore_2
    //   77: aload_2
    //   78: invokeinterface 301 1 0
    //   83: checkcast 137	java/lang/reflect/Field
    //   86: astore 4
    //   88: aload 4
    //   90: iconst_1
    //   91: invokevirtual 305	java/lang/reflect/Field:setAccessible	(Z)V
    //   94: aload 4
    //   96: invokevirtual 156	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   99: astore 6
    //   101: aload_1
    //   102: aload_2
    //   103: invokeinterface 308 1 0
    //   108: checkcast 187	java/lang/String
    //   111: invokevirtual 314	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   114: astore 5
    //   116: aload_0
    //   117: getfield 45	com/tencent/map/tools/json/JsonComposer:mFieldDeserializer	Ljava/util/Map;
    //   120: aload 4
    //   122: invokeinterface 95 2 0
    //   127: checkcast 79	com/tencent/map/tools/json/JsonParser$Deserializer
    //   130: astore 7
    //   132: aload 7
    //   134: ifnull +33 -> 167
    //   137: aload 4
    //   139: aload_0
    //   140: aload 7
    //   142: aload_0
    //   143: aload_2
    //   144: invokeinterface 308 1 0
    //   149: checkcast 187	java/lang/String
    //   152: aload 5
    //   154: invokeinterface 290 4 0
    //   159: invokevirtual 318	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   162: goto -104 -> 58
    //   165: astore 7
    //   167: aload_0
    //   168: aload_2
    //   169: invokeinterface 308 1 0
    //   174: checkcast 187	java/lang/String
    //   177: aload 5
    //   179: invokevirtual 320	com/tencent/map/tools/json/JsonComposer:onEachItemParse	(Ljava/lang/String;Ljava/lang/Object;)Z
    //   182: ifne -124 -> 58
    //   185: aload 5
    //   187: instanceof 322
    //   190: ifeq +170 -> 360
    //   193: aload 4
    //   195: invokevirtual 326	java/lang/reflect/Field:getGenericType	()Ljava/lang/reflect/Type;
    //   198: astore_2
    //   199: aload_2
    //   200: instanceof 328
    //   203: ifeq +115 -> 318
    //   206: aload_0
    //   207: aload_2
    //   208: invokevirtual 329	java/lang/Object:toString	()Ljava/lang/String;
    //   211: invokespecial 331	com/tencent/map/tools/json/JsonComposer:pickString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore_2
    //   215: aload_2
    //   216: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifne -161 -> 58
    //   222: aload_2
    //   223: aload_0
    //   224: invokevirtual 52	java/lang/Object:getClass	()Ljava/lang/Class;
    //   227: invokevirtual 335	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   230: invokestatic 339	com/tencent/map/tools/Util:findClass	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    //   233: astore 6
    //   235: aload 6
    //   237: ifnull -179 -> 58
    //   240: aconst_null
    //   241: astore_2
    //   242: ldc_w 295
    //   245: aload 4
    //   247: invokevirtual 156	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   250: invokevirtual 343	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   253: ifeq +31 -> 284
    //   256: ldc_w 345
    //   259: aload 5
    //   261: checkcast 322	org/json/JSONArray
    //   264: aload 6
    //   266: iconst_0
    //   267: anewarray 4	java/lang/Object
    //   270: invokestatic 351	com/tencent/map/tools/json/JsonUtils:parseTo	(Ljava/lang/Class;Lorg/json/JSONArray;Ljava/lang/Class;[Ljava/lang/Object;)Ljava/util/Collection;
    //   273: astore_2
    //   274: aload 4
    //   276: aload_0
    //   277: aload_2
    //   278: invokevirtual 318	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   281: goto -223 -> 58
    //   284: ldc_w 353
    //   287: aload 4
    //   289: invokevirtual 156	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   292: invokevirtual 343	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   295: ifeq -21 -> 274
    //   298: ldc 99
    //   300: aload 5
    //   302: checkcast 322	org/json/JSONArray
    //   305: aload 6
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokestatic 351	com/tencent/map/tools/json/JsonUtils:parseTo	(Ljava/lang/Class;Lorg/json/JSONArray;Ljava/lang/Class;[Ljava/lang/Object;)Ljava/util/Collection;
    //   314: astore_2
    //   315: goto -41 -> 274
    //   318: aload_2
    //   319: checkcast 56	java/lang/Class
    //   322: invokevirtual 356	java/lang/Class:isArray	()Z
    //   325: ifeq -267 -> 58
    //   328: aload_2
    //   329: checkcast 56	java/lang/Class
    //   332: invokevirtual 359	java/lang/Class:getComponentType	()Ljava/lang/Class;
    //   335: astore_2
    //   336: aload 5
    //   338: checkcast 322	org/json/JSONArray
    //   341: aload_2
    //   342: invokestatic 363	com/tencent/map/tools/json/JsonUtils:parseToArray	(Lorg/json/JSONArray;Ljava/lang/Class;)Ljava/lang/Object;
    //   345: astore_2
    //   346: aload 4
    //   348: aload_0
    //   349: aload_2
    //   350: invokevirtual 318	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   353: goto -295 -> 58
    //   356: astore_2
    //   357: goto -299 -> 58
    //   360: aload 5
    //   362: instanceof 310
    //   365: ifeq +35 -> 400
    //   368: aload 5
    //   370: checkcast 310	org/json/JSONObject
    //   373: aload 4
    //   375: invokevirtual 156	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   378: iconst_0
    //   379: anewarray 4	java/lang/Object
    //   382: invokestatic 367	com/tencent/map/tools/json/JsonUtils:parseToModel	(Lorg/json/JSONObject;Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   385: astore_2
    //   386: aload 4
    //   388: aload_0
    //   389: aload_2
    //   390: invokevirtual 318	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   393: goto -335 -> 58
    //   396: astore_2
    //   397: goto -339 -> 58
    //   400: aload 6
    //   402: ldc 187
    //   404: if_acmpne +21 -> 425
    //   407: aload 4
    //   409: aload_0
    //   410: aload 5
    //   412: invokestatic 371	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   415: invokevirtual 318	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   418: goto -360 -> 58
    //   421: astore_2
    //   422: goto -364 -> 58
    //   425: aload 6
    //   427: getstatic 377	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   430: if_acmpne +28 -> 458
    //   433: aload 5
    //   435: instanceof 373
    //   438: ifeq +20 -> 458
    //   441: aload 4
    //   443: aload_0
    //   444: aload 5
    //   446: checkcast 373	java/lang/Boolean
    //   449: invokevirtual 380	java/lang/Boolean:booleanValue	()Z
    //   452: invokevirtual 384	java/lang/reflect/Field:setBoolean	(Ljava/lang/Object;Z)V
    //   455: goto -397 -> 58
    //   458: aload 6
    //   460: getstatic 387	java/lang/Byte:TYPE	Ljava/lang/Class;
    //   463: if_acmpne +28 -> 491
    //   466: aload 5
    //   468: instanceof 386
    //   471: ifeq +20 -> 491
    //   474: aload 4
    //   476: aload_0
    //   477: aload 5
    //   479: checkcast 386	java/lang/Byte
    //   482: invokevirtual 391	java/lang/Byte:byteValue	()B
    //   485: invokevirtual 395	java/lang/reflect/Field:setByte	(Ljava/lang/Object;B)V
    //   488: goto -430 -> 58
    //   491: aload 6
    //   493: getstatic 398	java/lang/Character:TYPE	Ljava/lang/Class;
    //   496: if_acmpne +28 -> 524
    //   499: aload 5
    //   501: instanceof 397
    //   504: ifeq +20 -> 524
    //   507: aload 4
    //   509: aload_0
    //   510: aload 5
    //   512: checkcast 397	java/lang/Character
    //   515: invokevirtual 402	java/lang/Character:charValue	()C
    //   518: invokevirtual 406	java/lang/reflect/Field:setChar	(Ljava/lang/Object;C)V
    //   521: goto -463 -> 58
    //   524: aload 6
    //   526: getstatic 409	java/lang/Double:TYPE	Ljava/lang/Class;
    //   529: if_acmpne +53 -> 582
    //   532: aload 5
    //   534: instanceof 411
    //   537: ifeq +20 -> 557
    //   540: aload 4
    //   542: aload_0
    //   543: aload 5
    //   545: checkcast 411	java/lang/Number
    //   548: invokevirtual 415	java/lang/Number:doubleValue	()D
    //   551: invokevirtual 419	java/lang/reflect/Field:setDouble	(Ljava/lang/Object;D)V
    //   554: goto -496 -> 58
    //   557: aload 5
    //   559: instanceof 187
    //   562: ifeq -504 -> 58
    //   565: aload 4
    //   567: aload_0
    //   568: aload 5
    //   570: checkcast 187	java/lang/String
    //   573: invokestatic 423	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   576: invokevirtual 419	java/lang/reflect/Field:setDouble	(Ljava/lang/Object;D)V
    //   579: goto -521 -> 58
    //   582: aload 6
    //   584: getstatic 426	java/lang/Float:TYPE	Ljava/lang/Class;
    //   587: if_acmpne +53 -> 640
    //   590: aload 5
    //   592: instanceof 411
    //   595: ifeq +20 -> 615
    //   598: aload 4
    //   600: aload_0
    //   601: aload 5
    //   603: checkcast 411	java/lang/Number
    //   606: invokevirtual 430	java/lang/Number:floatValue	()F
    //   609: invokevirtual 434	java/lang/reflect/Field:setFloat	(Ljava/lang/Object;F)V
    //   612: goto -554 -> 58
    //   615: aload 5
    //   617: instanceof 187
    //   620: ifeq -562 -> 58
    //   623: aload 4
    //   625: aload_0
    //   626: aload 5
    //   628: checkcast 187	java/lang/String
    //   631: invokestatic 438	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   634: invokevirtual 434	java/lang/reflect/Field:setFloat	(Ljava/lang/Object;F)V
    //   637: goto -579 -> 58
    //   640: aload 6
    //   642: getstatic 441	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   645: if_acmpne +53 -> 698
    //   648: aload 5
    //   650: instanceof 411
    //   653: ifeq +20 -> 673
    //   656: aload 4
    //   658: aload_0
    //   659: aload 5
    //   661: checkcast 411	java/lang/Number
    //   664: invokevirtual 444	java/lang/Number:intValue	()I
    //   667: invokevirtual 448	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   670: goto -612 -> 58
    //   673: aload 5
    //   675: instanceof 187
    //   678: ifeq -620 -> 58
    //   681: aload 4
    //   683: aload_0
    //   684: aload 5
    //   686: checkcast 187	java/lang/String
    //   689: invokestatic 451	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   692: invokevirtual 448	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   695: goto -637 -> 58
    //   698: aload 6
    //   700: getstatic 454	java/lang/Long:TYPE	Ljava/lang/Class;
    //   703: if_acmpne +53 -> 756
    //   706: aload 5
    //   708: instanceof 411
    //   711: ifeq +20 -> 731
    //   714: aload 4
    //   716: aload_0
    //   717: aload 5
    //   719: checkcast 411	java/lang/Number
    //   722: invokevirtual 458	java/lang/Number:longValue	()J
    //   725: invokevirtual 462	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   728: goto -670 -> 58
    //   731: aload 5
    //   733: instanceof 187
    //   736: ifeq -678 -> 58
    //   739: aload 4
    //   741: aload_0
    //   742: aload 5
    //   744: checkcast 187	java/lang/String
    //   747: invokestatic 466	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   750: invokevirtual 462	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   753: goto -695 -> 58
    //   756: aload 6
    //   758: getstatic 469	java/lang/Short:TYPE	Ljava/lang/Class;
    //   761: if_acmpne +53 -> 814
    //   764: aload 5
    //   766: instanceof 411
    //   769: ifeq +20 -> 789
    //   772: aload 4
    //   774: aload_0
    //   775: aload 5
    //   777: checkcast 411	java/lang/Number
    //   780: invokevirtual 473	java/lang/Number:shortValue	()S
    //   783: invokevirtual 477	java/lang/reflect/Field:setShort	(Ljava/lang/Object;S)V
    //   786: goto -728 -> 58
    //   789: aload 5
    //   791: instanceof 187
    //   794: ifeq -736 -> 58
    //   797: aload 4
    //   799: aload_0
    //   800: aload 5
    //   802: checkcast 187	java/lang/String
    //   805: invokestatic 481	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   808: invokevirtual 477	java/lang/reflect/Field:setShort	(Ljava/lang/Object;S)V
    //   811: goto -753 -> 58
    //   814: aload 5
    //   816: ifnull -758 -> 58
    //   819: aload 4
    //   821: aload_0
    //   822: aload 5
    //   824: invokevirtual 318	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   827: goto -769 -> 58
    //   830: astore_2
    //   831: goto -773 -> 58
    //   834: astore_2
    //   835: goto -777 -> 58
    //   838: astore_2
    //   839: goto -781 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	JsonComposer
    //   0	842	1	paramJSONObject	JSONObject
    //   20	6	2	localDeserializer1	JsonParser.Deserializer
    //   42	1	2	localJSONException	org.json.JSONException
    //   76	274	2	localObject1	Object
    //   356	1	2	localIllegalAccessException1	java.lang.IllegalAccessException
    //   385	5	2	localObject2	Object
    //   396	1	2	localIllegalAccessException2	java.lang.IllegalAccessException
    //   421	1	2	localIllegalAccessException3	java.lang.IllegalAccessException
    //   830	1	2	localIllegalAccessException4	java.lang.IllegalAccessException
    //   834	1	2	localNumberFormatException	java.lang.NumberFormatException
    //   838	1	2	localIllegalAccessException5	java.lang.IllegalAccessException
    //   57	11	3	localIterator	Iterator
    //   86	734	4	localField	Field
    //   114	709	5	localObject3	Object
    //   99	658	6	localClass	Class
    //   130	11	7	localDeserializer2	JsonParser.Deserializer
    //   165	1	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   25	41	42	org/json/JSONException
    //   137	162	165	java/lang/Exception
    //   346	353	356	java/lang/IllegalAccessException
    //   386	393	396	java/lang/IllegalAccessException
    //   407	418	421	java/lang/IllegalAccessException
    //   215	235	830	java/lang/IllegalAccessException
    //   242	274	830	java/lang/IllegalAccessException
    //   274	281	830	java/lang/IllegalAccessException
    //   284	315	830	java/lang/IllegalAccessException
    //   425	455	834	java/lang/NumberFormatException
    //   458	488	834	java/lang/NumberFormatException
    //   491	521	834	java/lang/NumberFormatException
    //   524	554	834	java/lang/NumberFormatException
    //   557	579	834	java/lang/NumberFormatException
    //   582	612	834	java/lang/NumberFormatException
    //   615	637	834	java/lang/NumberFormatException
    //   640	670	834	java/lang/NumberFormatException
    //   673	695	834	java/lang/NumberFormatException
    //   698	728	834	java/lang/NumberFormatException
    //   731	753	834	java/lang/NumberFormatException
    //   756	786	834	java/lang/NumberFormatException
    //   789	811	834	java/lang/NumberFormatException
    //   819	827	834	java/lang/NumberFormatException
    //   425	455	838	java/lang/IllegalAccessException
    //   458	488	838	java/lang/IllegalAccessException
    //   491	521	838	java/lang/IllegalAccessException
    //   524	554	838	java/lang/IllegalAccessException
    //   557	579	838	java/lang/IllegalAccessException
    //   582	612	838	java/lang/IllegalAccessException
    //   615	637	838	java/lang/IllegalAccessException
    //   640	670	838	java/lang/IllegalAccessException
    //   673	695	838	java/lang/IllegalAccessException
    //   698	728	838	java/lang/IllegalAccessException
    //   731	753	838	java/lang/IllegalAccessException
    //   756	786	838	java/lang/IllegalAccessException
    //   789	811	838	java/lang/IllegalAccessException
    //   819	827	838	java/lang/IllegalAccessException
  }
  
  /* Error */
  public JSONObject toJson()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 285	com/tencent/map/tools/json/JsonComposer:checkJsonComposerElements	()V
    //   4: aload_0
    //   5: getfield 97	com/tencent/map/tools/json/JsonComposer:mJsonFields	Ljava/util/Map;
    //   8: invokeinterface 293 1 0
    //   13: astore_3
    //   14: new 310	org/json/JSONObject
    //   17: dup
    //   18: invokespecial 484	org/json/JSONObject:<init>	()V
    //   21: astore 5
    //   23: aload_3
    //   24: invokeinterface 296 1 0
    //   29: astore 6
    //   31: aload 6
    //   33: invokeinterface 131 1 0
    //   38: ifeq +556 -> 594
    //   41: aload 6
    //   43: invokeinterface 135 1 0
    //   48: checkcast 298	java/util/Map$Entry
    //   51: astore 7
    //   53: aload 7
    //   55: invokeinterface 301 1 0
    //   60: checkcast 137	java/lang/reflect/Field
    //   63: astore 4
    //   65: aload 4
    //   67: iconst_1
    //   68: invokevirtual 305	java/lang/reflect/Field:setAccessible	(Z)V
    //   71: aload 4
    //   73: invokevirtual 156	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   76: astore 8
    //   78: aload 4
    //   80: aload_0
    //   81: invokevirtual 485	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore_3
    //   85: aload_0
    //   86: aload 5
    //   88: aload 7
    //   90: invokeinterface 308 1 0
    //   95: checkcast 187	java/lang/String
    //   98: aload_3
    //   99: invokevirtual 487	com/tencent/map/tools/json/JsonComposer:onEachItemToJson	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)Z
    //   102: ifne -71 -> 31
    //   105: ldc 115
    //   107: aload 8
    //   109: invokevirtual 343	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   112: ifeq +144 -> 256
    //   115: aload 4
    //   117: aload_0
    //   118: invokevirtual 485	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 115	java/util/Collection
    //   124: astore 4
    //   126: new 322	org/json/JSONArray
    //   129: dup
    //   130: invokespecial 488	org/json/JSONArray:<init>	()V
    //   133: astore_3
    //   134: aload 4
    //   136: ifnull +62 -> 198
    //   139: aload 4
    //   141: invokeinterface 490 1 0
    //   146: ifne +52 -> 198
    //   149: aload 4
    //   151: invokeinterface 126 1 0
    //   156: astore 8
    //   158: aload 8
    //   160: invokeinterface 131 1 0
    //   165: ifeq +33 -> 198
    //   168: aload 8
    //   170: invokeinterface 135 1 0
    //   175: astore 9
    //   177: aload 9
    //   179: instanceof 6
    //   182: ifeq -24 -> 158
    //   185: aload_3
    //   186: aload 9
    //   188: invokestatic 494	com/tencent/map/tools/json/JsonUtils:modelToJson	(Ljava/lang/Object;)Lorg/json/JSONObject;
    //   191: invokevirtual 497	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   194: pop
    //   195: goto -37 -> 158
    //   198: aload 7
    //   200: invokeinterface 308 1 0
    //   205: checkcast 187	java/lang/String
    //   208: astore 7
    //   210: aload_0
    //   211: getfield 43	com/tencent/map/tools/json/JsonComposer:mAllowEmpty	Z
    //   214: ifne +393 -> 607
    //   217: aload 4
    //   219: ifnull +32 -> 251
    //   222: aload 4
    //   224: invokeinterface 490 1 0
    //   229: ifne +22 -> 251
    //   232: goto +375 -> 607
    //   235: aload 5
    //   237: aload 7
    //   239: aload_3
    //   240: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: goto -213 -> 31
    //   247: astore_3
    //   248: goto -217 -> 31
    //   251: aconst_null
    //   252: astore_3
    //   253: goto -18 -> 235
    //   256: aload 4
    //   258: aload_0
    //   259: invokevirtual 485	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: astore 4
    //   264: aload 4
    //   266: instanceof 408
    //   269: ifeq +30 -> 299
    //   272: aload 5
    //   274: aload 7
    //   276: invokeinterface 308 1 0
    //   281: checkcast 187	java/lang/String
    //   284: aload 4
    //   286: checkcast 408	java/lang/Double
    //   289: invokevirtual 501	java/lang/Double:doubleValue	()D
    //   292: invokevirtual 504	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   295: pop
    //   296: goto -265 -> 31
    //   299: aload 4
    //   301: instanceof 453
    //   304: ifeq +30 -> 334
    //   307: aload 5
    //   309: aload 7
    //   311: invokeinterface 308 1 0
    //   316: checkcast 187	java/lang/String
    //   319: aload 4
    //   321: checkcast 453	java/lang/Long
    //   324: invokevirtual 505	java/lang/Long:longValue	()J
    //   327: invokevirtual 508	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   330: pop
    //   331: goto -300 -> 31
    //   334: aload 4
    //   336: instanceof 440
    //   339: ifeq +30 -> 369
    //   342: aload 5
    //   344: aload 7
    //   346: invokeinterface 308 1 0
    //   351: checkcast 187	java/lang/String
    //   354: aload 4
    //   356: checkcast 440	java/lang/Integer
    //   359: invokevirtual 509	java/lang/Integer:intValue	()I
    //   362: invokevirtual 512	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   365: pop
    //   366: goto -335 -> 31
    //   369: aload 4
    //   371: instanceof 373
    //   374: ifeq +30 -> 404
    //   377: aload 5
    //   379: aload 7
    //   381: invokeinterface 308 1 0
    //   386: checkcast 187	java/lang/String
    //   389: aload 4
    //   391: checkcast 373	java/lang/Boolean
    //   394: invokevirtual 380	java/lang/Boolean:booleanValue	()Z
    //   397: invokevirtual 515	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   400: pop
    //   401: goto -370 -> 31
    //   404: aload 4
    //   406: instanceof 6
    //   409: ifeq +27 -> 436
    //   412: aload 5
    //   414: aload 7
    //   416: invokeinterface 308 1 0
    //   421: checkcast 187	java/lang/String
    //   424: aload 4
    //   426: invokestatic 494	com/tencent/map/tools/json/JsonUtils:modelToJson	(Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   432: pop
    //   433: goto -402 -> 31
    //   436: aload 4
    //   438: ifnull +110 -> 548
    //   441: aload 4
    //   443: invokevirtual 52	java/lang/Object:getClass	()Ljava/lang/Class;
    //   446: invokevirtual 356	java/lang/Class:isArray	()Z
    //   449: ifeq +99 -> 548
    //   452: getstatic 521	android/os/Build$VERSION:SDK_INT	I
    //   455: bipush 19
    //   457: if_icmplt +31 -> 488
    //   460: aload 5
    //   462: aload 7
    //   464: invokeinterface 308 1 0
    //   469: checkcast 187	java/lang/String
    //   472: new 322	org/json/JSONArray
    //   475: dup
    //   476: aload 4
    //   478: invokespecial 524	org/json/JSONArray:<init>	(Ljava/lang/Object;)V
    //   481: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: goto -454 -> 31
    //   488: aload 4
    //   490: invokestatic 530	java/lang/reflect/Array:getLength	(Ljava/lang/Object;)I
    //   493: istore_2
    //   494: new 322	org/json/JSONArray
    //   497: dup
    //   498: invokespecial 488	org/json/JSONArray:<init>	()V
    //   501: astore_3
    //   502: iconst_0
    //   503: istore_1
    //   504: iload_1
    //   505: iload_2
    //   506: if_icmpge +22 -> 528
    //   509: aload_3
    //   510: iload_1
    //   511: aload 4
    //   513: iload_1
    //   514: invokestatic 533	java/lang/reflect/Array:get	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   517: invokevirtual 536	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   520: pop
    //   521: iload_1
    //   522: iconst_1
    //   523: iadd
    //   524: istore_1
    //   525: goto -21 -> 504
    //   528: aload 5
    //   530: aload 7
    //   532: invokeinterface 308 1 0
    //   537: checkcast 187	java/lang/String
    //   540: aload_3
    //   541: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   544: pop
    //   545: goto -514 -> 31
    //   548: aload 7
    //   550: invokeinterface 308 1 0
    //   555: checkcast 187	java/lang/String
    //   558: astore 7
    //   560: aload 4
    //   562: astore_3
    //   563: aload 4
    //   565: ifnonnull +17 -> 582
    //   568: aload 4
    //   570: astore_3
    //   571: aload_0
    //   572: getfield 43	com/tencent/map/tools/json/JsonComposer:mAllowEmpty	Z
    //   575: ifeq +7 -> 582
    //   578: ldc_w 538
    //   581: astore_3
    //   582: aload 5
    //   584: aload 7
    //   586: aload_3
    //   587: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   590: pop
    //   591: goto -560 -> 31
    //   594: aload 5
    //   596: areturn
    //   597: astore_3
    //   598: goto -567 -> 31
    //   601: astore_3
    //   602: aconst_null
    //   603: astore_3
    //   604: goto -519 -> 85
    //   607: goto -372 -> 235
    //   610: astore_3
    //   611: goto -580 -> 31
    //   614: astore_3
    //   615: goto -584 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	JsonComposer
    //   503	22	1	i	int
    //   493	14	2	j	int
    //   13	227	3	localObject1	Object
    //   247	1	3	localJSONException1	org.json.JSONException
    //   252	335	3	localObject2	Object
    //   597	1	3	localIllegalAccessException1	java.lang.IllegalAccessException
    //   601	1	3	localIllegalAccessException2	java.lang.IllegalAccessException
    //   603	1	3	localObject3	Object
    //   610	1	3	localIllegalAccessException3	java.lang.IllegalAccessException
    //   614	1	3	localJSONException2	org.json.JSONException
    //   63	506	4	localObject4	Object
    //   21	574	5	localJSONObject	JSONObject
    //   29	13	6	localIterator	Iterator
    //   51	534	7	localObject5	Object
    //   76	93	8	localObject6	Object
    //   175	12	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   115	134	247	org/json/JSONException
    //   139	158	247	org/json/JSONException
    //   158	195	247	org/json/JSONException
    //   198	217	247	org/json/JSONException
    //   222	232	247	org/json/JSONException
    //   235	244	247	org/json/JSONException
    //   115	134	597	java/lang/IllegalAccessException
    //   139	158	597	java/lang/IllegalAccessException
    //   158	195	597	java/lang/IllegalAccessException
    //   198	217	597	java/lang/IllegalAccessException
    //   222	232	597	java/lang/IllegalAccessException
    //   235	244	597	java/lang/IllegalAccessException
    //   78	85	601	java/lang/IllegalAccessException
    //   256	296	610	java/lang/IllegalAccessException
    //   299	331	610	java/lang/IllegalAccessException
    //   334	366	610	java/lang/IllegalAccessException
    //   369	401	610	java/lang/IllegalAccessException
    //   404	433	610	java/lang/IllegalAccessException
    //   441	485	610	java/lang/IllegalAccessException
    //   488	502	610	java/lang/IllegalAccessException
    //   509	521	610	java/lang/IllegalAccessException
    //   528	545	610	java/lang/IllegalAccessException
    //   548	560	610	java/lang/IllegalAccessException
    //   571	578	610	java/lang/IllegalAccessException
    //   582	591	610	java/lang/IllegalAccessException
    //   256	296	614	org/json/JSONException
    //   299	331	614	org/json/JSONException
    //   334	366	614	org/json/JSONException
    //   369	401	614	org/json/JSONException
    //   404	433	614	org/json/JSONException
    //   441	485	614	org/json/JSONException
    //   488	502	614	org/json/JSONException
    //   509	521	614	org/json/JSONException
    //   528	545	614	org/json/JSONException
    //   548	560	614	org/json/JSONException
    //   571	578	614	org/json/JSONException
    //   582	591	614	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.json.JsonComposer
 * JD-Core Version:    0.7.0.1
 */