package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cg
  extends lh
{
  private int a = 0;
  private String b = "";
  private String c = "";
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private String h = "";
  private String i = "";
  private String n = "";
  private final String o;
  
  public cg(lw paramlw, String paramString)
  {
    super(paramlw);
    this.o = paramString;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getInt("state");
      if (paramJSONObject.has("qqacct_count")) {
        this.b = paramJSONObject.getString("qqacct_count");
      } else {
        this.b = "";
      }
      em.b().n().e.i = this.b;
      if (paramJSONObject.has("provide_count")) {
        this.c = paramJSONObject.getString("provide_count");
      } else {
        this.c = "";
      }
      em.b().n().e.h = this.c;
      em.b().n().e.g = this.c;
      if (paramJSONObject.has("mpay_last_deposit")) {
        this.f = paramJSONObject.getInt("mpay_last_deposit");
      }
      if (paramJSONObject.has("mpay_total_amount"))
      {
        this.d = paramJSONObject.getInt("mpay_total_amount");
        em.b().n().d.h = this.d;
      }
      if (paramJSONObject.has("mpay_card_amount")) {
        this.e = paramJSONObject.getInt("mpay_card_amount");
      }
      if (paramJSONObject.has("mpay_need_deposit")) {
        this.g = paramJSONObject.getInt("mpay_need_deposit");
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  /* Error */
  private void b(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 106
    //   4: invokevirtual 68	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7: invokevirtual 112	java/lang/String:toString	()Ljava/lang/String;
    //   10: putfield 40	midas/x/cg:h	Ljava/lang/String;
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 115	midas/x/cg:X	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: goto +41 -> 63
    //   25: astore_3
    //   26: new 117	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 122
    //   39: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: aload_3
    //   46: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   49: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 129
    //   55: aload 4
    //   57: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 136	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: aload_1
    //   65: ldc 138
    //   67: invokevirtual 68	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: aload_2
    //   71: invokestatic 143	midas/x/ek:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: ldc 145
    //   76: invokestatic 150	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: putfield 42	midas/x/cg:i	Ljava/lang/String;
    //   82: goto +8 -> 90
    //   85: astore_3
    //   86: aload_3
    //   87: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   90: aload_0
    //   91: aload_1
    //   92: ldc 155
    //   94: invokevirtual 68	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: aload_2
    //   98: invokestatic 143	midas/x/ek:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: ldc 145
    //   103: invokestatic 150	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: putfield 44	midas/x/cg:n	Ljava/lang/String;
    //   109: return
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   115: return
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   121: return
    //   122: astore_2
    //   123: goto -110 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	cg
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
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getInt("state");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getInt("state");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    try
    {
      this.k = paramJSONObject.getString("msg").toString();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    super.a(paramkz);
    Object localObject = new String(paramkz.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetCardBillInfoAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.j == 0)
      {
        if (this.o.equals("mcardstatus")) {
          a((JSONObject)localObject);
        } else if (this.o.equals("towxsign")) {
          b((JSONObject)localObject);
        } else if (this.o.equals("towxunsign")) {
          c((JSONObject)localObject);
        } else if (this.o.equals("querywxresult")) {
          d((JSONObject)localObject);
        }
      }
      else
      {
        this.k = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
        if (!((String)localObject).equals(""))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("系统繁忙,请稍后再试 (");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(")");
          this.k = localStringBuilder.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.a(paramkz);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.n;
  }
  
  public String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cg
 * JD-Core Version:    0.7.0.1
 */