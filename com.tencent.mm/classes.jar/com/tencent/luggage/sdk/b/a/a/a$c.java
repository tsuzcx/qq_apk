package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/config/ExptMapping$Factory;", "", "()V", "createEmpty", "Lcom/tencent/luggage/sdk/jsapi/component/config/ExptMapping;", "createForFeatureValue", "exptFeatureValue", "", "luggage-wechat-nano-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
{
  public static final c eqV;
  
  static
  {
    AppMethodBeat.i(220305);
    eqV = new c();
    AppMethodBeat.o(220305);
  }
  
  public static final a arn()
  {
    AppMethodBeat.i(220302);
    a locala = new a((byte)0);
    AppMethodBeat.o(220302);
    return locala;
  }
  
  /* Error */
  public static final a fp(String paramString)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: checkcast 60	java/lang/CharSequence
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +12 -> 23
    //   14: aload_2
    //   15: invokeinterface 64 1 0
    //   20: ifne +16 -> 36
    //   23: iconst_1
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq +15 -> 41
    //   29: ldc 58
    //   31: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aconst_null
    //   35: areturn
    //   36: iconst_0
    //   37: istore_1
    //   38: goto -13 -> 25
    //   41: new 66	org/json/JSONArray
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 69	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   49: astore_3
    //   50: new 6	com/tencent/luggage/sdk/b/a/a/a
    //   53: dup
    //   54: iconst_0
    //   55: invokespecial 53	com/tencent/luggage/sdk/b/a/a/a:<init>	(B)V
    //   58: astore_2
    //   59: aload_3
    //   60: new 9	com/tencent/luggage/sdk/b/a/a/a$c$a
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 72	com/tencent/luggage/sdk/b/a/a/a$c$a:<init>	(Lcom/tencent/luggage/sdk/b/a/a/a;)V
    //   68: checkcast 74	kotlin/g/a/b
    //   71: invokestatic 80	com/tencent/luggage/sdk/h/c:a	(Lorg/json/JSONArray;Lkotlin/g/a/b;)V
    //   74: ldc 58
    //   76: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_2
    //   80: areturn
    //   81: astore_2
    //   82: ldc 82
    //   84: new 84	java/lang/StringBuilder
    //   87: dup
    //   88: ldc 86
    //   90: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: ldc 93
    //   99: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: ldc 58
    //   114: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_3
    //   120: ldc 82
    //   122: new 84	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 86
    //   128: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: ldc 108
    //   137: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_3
    //   141: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: goto -76 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   24	14	1	i	int
    //   9	71	2	localObject	Object
    //   81	22	2	localJSONException1	org.json.JSONException
    //   49	11	3	localJSONArray	org.json.JSONArray
    //   119	22	3	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   41	50	81	org/json/JSONException
    //   59	74	119	org/json/JSONException
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "key", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<String, ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */