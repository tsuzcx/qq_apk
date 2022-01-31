package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.f.b;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;

public final class k
{
  public static Map<String, String> kmN = new k.1();
  private String bHI;
  private String bHJ;
  private int bUR;
  private String bssid;
  private String dmU;
  private String iGw;
  private int kmO;
  private String kmP;
  private String kmQ;
  private int kmR;
  private long kmS;
  private String kmT;
  private String kmU;
  private long kmV;
  private int result;
  private String ssid;
  
  public static String Dl(String paramString)
  {
    return m.Dn((String)kmN.get(paramString));
  }
  
  public static k.a aTx()
  {
    return new k.a((byte)0);
  }
  
  public final k aTy()
  {
    h.nFQ.f(12804, new Object[] { m.Dn(this.ssid), m.Dn(this.bssid), m.Dn(this.bHJ), m.Dn(this.bHI), Integer.valueOf(this.kmO), m.Dn(this.kmP), m.Dn(this.kmQ), m.Dn(this.iGw), Integer.valueOf(this.kmR), Long.valueOf(this.kmS), m.Dn(this.kmT), Integer.valueOf(this.result), Integer.valueOf(this.bUR), m.Dn(this.kmU), Long.valueOf(this.kmV), m.Dn(this.dmU) });
    return this;
  }
  
  /* Error */
  public final k b(final android.content.Intent paramIntent, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 140	com/tencent/mm/plugin/freewifi/m:D	(Landroid/content/Intent;)I
    //   4: istore_3
    //   5: iload_3
    //   6: bipush 31
    //   8: if_icmpeq +5 -> 13
    //   11: aload_0
    //   12: areturn
    //   13: new 142	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 143	org/json/JSONObject:<init>	()V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc 144
    //   26: aload_0
    //   27: getfield 70	com/tencent/mm/plugin/freewifi/k:ssid	Ljava/lang/String;
    //   30: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload 6
    //   36: ldc 149
    //   38: aload_0
    //   39: getfield 81	com/tencent/mm/plugin/freewifi/k:bssid	Ljava/lang/String;
    //   42: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   45: pop
    //   46: aload 6
    //   48: ldc 151
    //   50: aload_0
    //   51: getfield 86	com/tencent/mm/plugin/freewifi/k:bHJ	Ljava/lang/String;
    //   54: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 6
    //   60: ldc 153
    //   62: aload_0
    //   63: getfield 91	com/tencent/mm/plugin/freewifi/k:bHI	Ljava/lang/String;
    //   66: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload 6
    //   72: ldc 155
    //   74: aload_0
    //   75: getfield 64	com/tencent/mm/plugin/freewifi/k:kmO	I
    //   78: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload 6
    //   84: ldc 160
    //   86: aload_0
    //   87: getfield 94	com/tencent/mm/plugin/freewifi/k:kmP	Ljava/lang/String;
    //   90: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload 6
    //   96: ldc 162
    //   98: aload_0
    //   99: getfield 97	com/tencent/mm/plugin/freewifi/k:kmQ	Ljava/lang/String;
    //   102: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 6
    //   108: ldc 164
    //   110: aload_0
    //   111: getfield 100	com/tencent/mm/plugin/freewifi/k:iGw	Ljava/lang/String;
    //   114: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 6
    //   120: ldc 166
    //   122: aload_0
    //   123: getfield 77	com/tencent/mm/plugin/freewifi/k:kmR	I
    //   126: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload 6
    //   132: ldc 168
    //   134: aload_0
    //   135: getfield 67	com/tencent/mm/plugin/freewifi/k:kmS	J
    //   138: invokevirtual 171	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload 6
    //   144: ldc 173
    //   146: aload_0
    //   147: getfield 103	com/tencent/mm/plugin/freewifi/k:kmT	Ljava/lang/String;
    //   150: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 6
    //   156: ldc 174
    //   158: aload_0
    //   159: getfield 84	com/tencent/mm/plugin/freewifi/k:result	I
    //   162: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload 6
    //   168: ldc 176
    //   170: aload_0
    //   171: getfield 89	com/tencent/mm/plugin/freewifi/k:bUR	I
    //   174: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 6
    //   180: ldc 178
    //   182: aload_0
    //   183: getfield 106	com/tencent/mm/plugin/freewifi/k:kmU	Ljava/lang/String;
    //   186: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   189: pop
    //   190: aload 6
    //   192: ldc 180
    //   194: aload_0
    //   195: getfield 79	com/tencent/mm/plugin/freewifi/k:kmV	J
    //   198: invokevirtual 171	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload 6
    //   204: ldc 182
    //   206: aload_0
    //   207: getfield 109	com/tencent/mm/plugin/freewifi/k:dmU	Ljava/lang/String;
    //   210: invokevirtual 148	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload 6
    //   216: ldc 184
    //   218: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   221: invokevirtual 171	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload 6
    //   227: invokevirtual 194	org/json/JSONObject:toString	()Ljava/lang/String;
    //   230: astore 6
    //   232: aload_1
    //   233: ldc 196
    //   235: invokevirtual 201	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   238: astore 7
    //   240: aload 7
    //   242: invokestatic 205	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   245: ifeq +120 -> 365
    //   248: aload_1
    //   249: ldc 196
    //   251: aload 6
    //   253: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   256: pop
    //   257: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   260: lstore 4
    //   262: aload_1
    //   263: ldc 211
    //   265: invokevirtual 201	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore 6
    //   270: aload_1
    //   271: ldc 196
    //   273: invokevirtual 201	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_1
    //   277: iload_2
    //   278: ifeq +123 -> 401
    //   281: invokestatic 217	com/tencent/mm/plugin/freewifi/model/j:aUm	()Lcom/tencent/mm/plugin/freewifi/model/c;
    //   284: invokevirtual 223	com/tencent/mm/plugin/freewifi/model/c:aTT	()Lcom/tencent/mm/sdk/platformtools/ah;
    //   287: new 6	com/tencent/mm/plugin/freewifi/k$2
    //   290: dup
    //   291: aload_0
    //   292: aload 6
    //   294: iload_3
    //   295: aload_1
    //   296: lload 4
    //   298: invokespecial 226	com/tencent/mm/plugin/freewifi/k$2:<init>	(Lcom/tencent/mm/plugin/freewifi/k;Ljava/lang/String;ILjava/lang/String;J)V
    //   301: invokevirtual 232	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   304: pop
    //   305: aload_0
    //   306: areturn
    //   307: astore_1
    //   308: ldc 234
    //   310: new 236	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 238
    //   316: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: aload_1
    //   320: invokestatic 244	com/tencent/mm/plugin/freewifi/m:g	(Ljava/lang/Exception;)Ljava/lang/String;
    //   323: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 254	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: areturn
    //   334: astore 7
    //   336: ldc 234
    //   338: new 236	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 256
    //   345: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload 7
    //   350: invokestatic 244	com/tencent/mm/plugin/freewifi/m:g	(Ljava/lang/Exception;)Ljava/lang/String;
    //   353: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 254	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -137 -> 225
    //   365: aload_1
    //   366: ldc 196
    //   368: new 236	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   375: aload 7
    //   377: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: ldc_w 259
    //   383: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 6
    //   388: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   397: pop
    //   398: goto -141 -> 257
    //   401: aload_0
    //   402: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	k
    //   0	403	1	paramIntent	android.content.Intent
    //   0	403	2	paramBoolean	boolean
    //   4	291	3	i	int
    //   260	37	4	l	long
    //   20	367	6	localObject	Object
    //   238	3	7	str	String
    //   334	42	7	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   0	5	307	java/lang/Exception
    //   13	22	307	java/lang/Exception
    //   22	225	307	java/lang/Exception
    //   225	257	307	java/lang/Exception
    //   257	277	307	java/lang/Exception
    //   281	305	307	java/lang/Exception
    //   336	362	307	java/lang/Exception
    //   365	398	307	java/lang/Exception
    //   22	225	334	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k
 * JD-Core Version:    0.7.0.1
 */