package b.a.a.a.a.a.a.a;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.sdk.platformtools.as;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lmain/java/com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "TAG", "", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmKv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmKv$delegate", "Lkotlin/Lazy;", "sMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "resotre", "save", "uninit", "plugin-appbrand-integration_release"})
public final class a
{
  private static final HashMap<String, bn> CKS;
  private static final f CKT;
  public static final a CKU;
  
  static
  {
    AppMethodBeat.i(135278);
    eOJ = new k[] { (k)v.a(new t(v.aG(a.class), "mmKv", "getMmKv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    CKU = new a();
    CKS = new HashMap();
    CKT = g.j((a.f.a.a)a.a.CKV);
    AppMethodBeat.o(135278);
  }
  
  private static as eqM()
  {
    AppMethodBeat.i(144011);
    as localas = (as)CKT.getValue();
    AppMethodBeat.o(144011);
    return localas;
  }
  
  public final void Eg(String paramString)
  {
    try
    {
      AppMethodBeat.i(144012);
      j.q(paramString, "appId");
      bn localbn = new bn();
      ((Map)CKS).put(paramString, localbn);
      AppMethodBeat.o(144012);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void afj(String paramString)
  {
    try
    {
      AppMethodBeat.i(144013);
      j.q(paramString, "appId");
      bn localbn = azy(paramString);
      if (localbn != null) {
        eqM().putString(paramString, localbn.Ff()).commit();
      }
      AppMethodBeat.o(144013);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void azx(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 116
    //   10: invokestatic 122	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 139	b/a/a/a/a/a/a/a/a:eqM	()Lcom/tencent/mm/sdk/platformtools/as;
    //   16: aload_1
    //   17: ldc 156
    //   19: invokevirtual 160	com/tencent/mm/sdk/platformtools/as:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: aload 4
    //   29: ifnonnull +6 -> 35
    //   32: ldc 156
    //   34: astore_3
    //   35: aload_3
    //   36: ldc 162
    //   38: invokestatic 165	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: aload_3
    //   42: checkcast 167	java/lang/CharSequence
    //   45: invokeinterface 171 1 0
    //   50: ifle +40 -> 90
    //   53: iconst_1
    //   54: istore_2
    //   55: iload_2
    //   56: ifeq +26 -> 82
    //   59: new 124	com/tencent/mm/g/b/a/bn
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 173	com/tencent/mm/g/b/a/bn:<init>	(Ljava/lang/String;)V
    //   67: astore_3
    //   68: getstatic 80	b/a/a/a/a/a/a/a/a:CKS	Ljava/util/HashMap;
    //   71: checkcast 127	java/util/Map
    //   74: aload_1
    //   75: aload_3
    //   76: invokeinterface 131 3 0
    //   81: pop
    //   82: ldc 155
    //   84: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: iconst_0
    //   91: istore_2
    //   92: goto -37 -> 55
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	paramString	String
    //   54	38	2	i	int
    //   26	50	3	localObject	Object
    //   22	6	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	24	95	finally
    //   35	53	95	finally
    //   59	82	95	finally
    //   82	87	95	finally
  }
  
  public final bn azy(String paramString)
  {
    try
    {
      AppMethodBeat.i(144015);
      j.q(paramString, "appId");
      paramString = (bn)CKS.get(paramString);
      AppMethodBeat.o(144015);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final void azz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 179
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 116
    //   10: invokestatic 122	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 181	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 183
    //   19: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 137	b/a/a/a/a/a/a/a/a:azy	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/bn;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +50 -> 80
    //   33: aload_2
    //   34: invokevirtual 187	com/tencent/mm/g/b/a/bn:Fg	()Ljava/lang/String;
    //   37: astore_2
    //   38: ldc 189
    //   40: aload_3
    //   41: aload_2
    //   42: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 202	com/tencent/luggage/g/d:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 80	b/a/a/a/a/a/a/a/a:CKS	Ljava/util/HashMap;
    //   54: aload_1
    //   55: invokevirtual 205	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: invokestatic 139	b/a/a/a/a/a/a/a/a:eqM	()Lcom/tencent/mm/sdk/platformtools/as;
    //   62: aload_1
    //   63: invokevirtual 208	com/tencent/mm/sdk/platformtools/as:remove	(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   66: invokeinterface 153 1 0
    //   71: pop
    //   72: ldc 179
    //   74: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aconst_null
    //   81: astore_2
    //   82: goto -44 -> 38
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramString	String
    //   28	54	2	localObject	Object
    //   22	19	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	29	85	finally
    //   33	38	85	finally
    //   38	77	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     b.a.a.a.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */