package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class h2
  extends ob
{
  public int g = 0;
  public String h = "";
  public String i = "";
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public String n = "";
  public String o = "";
  public String p = "";
  public final String q;
  
  public h2(fc paramfc, String paramString)
  {
    super(paramfc);
    this.q = paramString;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      this.g = paramJSONObject.getInt("state");
      boolean bool = paramJSONObject.has("qqacct_count");
      if (bool) {
        this.h = paramJSONObject.getString("qqacct_count");
      } else {
        this.h = "";
      }
      p4.p().e().f.h = this.h;
      if (paramJSONObject.has("provide_count")) {
        this.i = paramJSONObject.getString("provide_count");
      } else {
        this.i = "";
      }
      p4.p().e().f.g = this.i;
      p4.p().e().f.f = this.i;
      if (paramJSONObject.has("mpay_last_deposit")) {
        this.l = paramJSONObject.getInt("mpay_last_deposit");
      }
      if (paramJSONObject.has("mpay_total_amount"))
      {
        this.j = paramJSONObject.getInt("mpay_total_amount");
        p4.p().e().e.h = this.j;
      }
      if (paramJSONObject.has("mpay_card_amount")) {
        this.k = paramJSONObject.getInt("mpay_card_amount");
      }
      if (paramJSONObject.has("mpay_need_deposit")) {
        this.m = paramJSONObject.getInt("mpay_need_deposit");
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  /* Error */
  public final void b(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 111
    //   4: invokevirtual 69	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7: invokevirtual 117	java/lang/String:toString	()Ljava/lang/String;
    //   10: putfield 40	midas/x/h2:n	Ljava/lang/String;
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 119	midas/x/ob:b	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: goto +41 -> 63
    //   25: astore_3
    //   26: new 121	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 126
    //   39: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: aload_3
    //   46: invokevirtual 131	java/lang/Exception:toString	()Ljava/lang/String;
    //   49: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 133
    //   55: aload 4
    //   57: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 140	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: aload_1
    //   65: ldc 142
    //   67: invokevirtual 69	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: aload_2
    //   71: invokestatic 147	midas/x/n4:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: ldc 149
    //   76: invokestatic 154	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: putfield 42	midas/x/h2:o	Ljava/lang/String;
    //   82: goto +8 -> 90
    //   85: astore_3
    //   86: aload_3
    //   87: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   90: aload_0
    //   91: aload_1
    //   92: ldc 159
    //   94: invokevirtual 69	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: aload_2
    //   98: invokestatic 147	midas/x/n4:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: ldc 149
    //   103: invokestatic 154	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: putfield 44	midas/x/h2:p	Ljava/lang/String;
    //   109: return
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   115: return
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   121: return
    //   122: astore_2
    //   123: goto -110 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	h2
    //   0	126	1	paramJSONObject	JSONObject
    //   14	84	2	localObject	Object
    //   122	1	2	localException1	Exception
    //   19	2	3	str	String
    //   25	21	3	localException2	Exception
    //   85	2	3	localException3	Exception
    //   33	23	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	20	25	java/lang/Exception
    //   63	82	85	java/lang/Exception
    //   90	109	110	java/lang/Exception
    //   26	63	116	java/lang/Exception
    //   86	90	116	java/lang/Exception
    //   111	115	116	java/lang/Exception
    //   0	13	122	java/lang/Exception
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    try
    {
      this.g = paramJSONObject.getInt("state");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    try
    {
      this.g = paramJSONObject.getInt("state");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    try
    {
      this.b = paramJSONObject.getString("msg").toString();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    Object localObject = new String(paramgb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetCardBillInfoAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.a == 0)
      {
        if (this.q.equals("mcardstatus")) {
          a((JSONObject)localObject);
        } else if (this.q.equals("towxsign")) {
          b((JSONObject)localObject);
        } else if (this.q.equals("towxunsign")) {
          c((JSONObject)localObject);
        } else if (this.q.equals("querywxresult")) {
          d((JSONObject)localObject);
        }
      }
      else
      {
        this.b = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
        if (!((String)localObject).equals(""))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("系统繁忙,请稍后再试 (");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(")");
          this.b = localStringBuilder.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public int g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public int k()
  {
    return this.g;
  }
  
  public String l()
  {
    return this.n;
  }
  
  public String m()
  {
    return this.p;
  }
  
  public String n()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h2
 * JD-Core Version:    0.7.0.1
 */