package c.t.m.g;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bd
  extends bc
  implements w
{
  br a = new br("HttpSchedulerClient");
  u b;
  
  /* Error */
  static void a(u paramu, org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_1
    //   4: invokevirtual 35	org/json/JSONArray:length	()I
    //   7: if_icmpge +183 -> 190
    //   10: aload_1
    //   11: iload_2
    //   12: invokevirtual 39	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   15: astore 8
    //   17: aload 8
    //   19: ldc 41
    //   21: invokevirtual 47	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   24: astore 5
    //   26: aload 8
    //   28: ldc 49
    //   30: invokevirtual 47	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   33: astore 6
    //   35: aload 8
    //   37: ldc 51
    //   39: invokevirtual 55	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 7
    //   44: aload 8
    //   46: ldc 57
    //   48: invokevirtual 55	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 8
    //   53: aload 5
    //   55: ifnull +127 -> 182
    //   58: aload 6
    //   60: ifnull +122 -> 182
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: aload 5
    //   68: invokevirtual 35	org/json/JSONArray:length	()I
    //   71: if_icmpge +111 -> 182
    //   74: new 59	c/t/m/g/v
    //   77: dup
    //   78: aload 5
    //   80: iload_3
    //   81: invokevirtual 63	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   84: aload 7
    //   86: invokespecial 66	c/t/m/g/v:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore 9
    //   91: aload 9
    //   93: aload 8
    //   95: invokestatic 72	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: putfield 76	c/t/m/g/v:d	I
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: aload 6
    //   108: invokevirtual 35	org/json/JSONArray:length	()I
    //   111: if_icmpge +47 -> 158
    //   114: aload 6
    //   116: iload 4
    //   118: invokevirtual 63	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   121: astore 10
    //   123: new 78	c/t/m/g/n
    //   126: dup
    //   127: invokespecial 79	c/t/m/g/n:<init>	()V
    //   130: astore 11
    //   132: aload 11
    //   134: aload 10
    //   136: invokevirtual 82	c/t/m/g/n:a	(Ljava/lang/String;)Z
    //   139: ifeq +57 -> 196
    //   142: aload 9
    //   144: getfield 86	c/t/m/g/v:c	Ljava/util/List;
    //   147: aload 11
    //   149: invokeinterface 92 2 0
    //   154: pop
    //   155: goto +41 -> 196
    //   158: aload_0
    //   159: getfield 97	c/t/m/g/u:b	Ljava/util/Map;
    //   162: aload 9
    //   164: getfield 100	c/t/m/g/v:a	Ljava/lang/String;
    //   167: aload 9
    //   169: invokeinterface 106 3 0
    //   174: pop
    //   175: iload_3
    //   176: iconst_1
    //   177: iadd
    //   178: istore_3
    //   179: goto -114 -> 65
    //   182: iload_2
    //   183: iconst_1
    //   184: iadd
    //   185: istore_2
    //   186: goto -184 -> 2
    //   189: astore_0
    //   190: return
    //   191: astore 9
    //   193: goto -18 -> 175
    //   196: iload 4
    //   198: iconst_1
    //   199: iadd
    //   200: istore 4
    //   202: goto -98 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramu	u
    //   0	205	1	paramJSONArray	org.json.JSONArray
    //   1	185	2	i	int
    //   64	115	3	j	int
    //   102	99	4	k	int
    //   24	55	5	localJSONArray1	org.json.JSONArray
    //   33	82	6	localJSONArray2	org.json.JSONArray
    //   42	43	7	str1	String
    //   15	79	8	localObject	java.lang.Object
    //   89	79	9	localv	v
    //   191	1	9	localThrowable	java.lang.Throwable
    //   121	14	10	str2	String
    //   130	18	11	localn	n
    // Exception table:
    //   from	to	target	type
    //   2	53	189	java/lang/Exception
    //   65	91	189	java/lang/Exception
    //   91	101	189	java/lang/Exception
    //   104	155	189	java/lang/Exception
    //   158	175	189	java/lang/Exception
    //   91	101	191	java/lang/Throwable
  }
  
  public final List<v> a()
  {
    if ((this.b != null) && (this.b.a.equals(x.b())))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.b.entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Map.Entry)localIterator.next()).getValue());
      }
      return localArrayList;
    }
    m.i().post(new be(this));
    return null;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.a.a(paramString1, paramArrayOfByte);
    m.i().post(new be(this));
  }
  
  public final String b()
  {
    return "accessscheduler";
  }
  
  public final void c()
  {
    cf.d().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.bd
 * JD-Core Version:    0.7.0.1
 */