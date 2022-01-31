package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  /* Error */
  public static void a(android.widget.TextView paramTextView, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +9 -> 19
    //   13: ldc 9
    //   15: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: aload_1
    //   20: ldc 20
    //   22: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 32	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifne +11 -> 41
    //   33: aload_0
    //   34: aload_3
    //   35: invokestatic 38	com/tencent/mm/plugin/appbrand/s/g:Fm	(Ljava/lang/String;)I
    //   38: invokevirtual 43	android/widget/TextView:setTextColor	(I)V
    //   41: aload_0
    //   42: iconst_0
    //   43: aload_1
    //   44: ldc 45
    //   46: invokevirtual 49	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   49: d2f
    //   50: invokestatic 53	com/tencent/mm/plugin/appbrand/s/g:aA	(F)F
    //   53: invokevirtual 57	android/widget/TextView:setTextSize	(IF)V
    //   56: aload_1
    //   57: ldc 59
    //   59: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: ldc 61
    //   65: aload_3
    //   66: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +108 -> 177
    //   72: aload_0
    //   73: iconst_3
    //   74: invokevirtual 70	android/widget/TextView:setGravity	(I)V
    //   77: aload_1
    //   78: ldc 72
    //   80: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_3
    //   84: ldc 74
    //   86: aload_3
    //   87: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +121 -> 211
    //   93: aload_0
    //   94: invokevirtual 78	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   97: iconst_1
    //   98: invokevirtual 84	android/text/TextPaint:setFakeBoldText	(Z)V
    //   101: aload_1
    //   102: ldc 86
    //   104: aload_0
    //   105: invokevirtual 90	android/widget/TextView:getTextSize	()F
    //   108: ldc 91
    //   110: fmul
    //   111: invokestatic 97	java/lang/Math:round	(F)I
    //   114: invokestatic 100	com/tencent/mm/plugin/appbrand/s/g:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   117: istore_2
    //   118: aload_0
    //   119: instanceof 102
    //   122: ifeq +11 -> 133
    //   125: aload_0
    //   126: checkcast 102	com/tencent/mm/plugin/appbrand/widget/e
    //   129: iload_2
    //   130: invokevirtual 105	com/tencent/mm/plugin/appbrand/widget/e:setLineHeight	(I)V
    //   133: aload_1
    //   134: ldc 107
    //   136: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: ldc 109
    //   142: aload_3
    //   143: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +89 -> 235
    //   149: aload_0
    //   150: getstatic 115	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   153: invokevirtual 119	android/widget/TextView:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)V
    //   156: aload_0
    //   157: iconst_1
    //   158: invokevirtual 122	android/widget/TextView:setSingleLine	(Z)V
    //   161: aload_0
    //   162: aload_1
    //   163: ldc 124
    //   165: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokevirtual 128	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   171: ldc 9
    //   173: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: return
    //   177: ldc 130
    //   179: aload_3
    //   180: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifeq +11 -> 194
    //   186: aload_0
    //   187: iconst_1
    //   188: invokevirtual 70	android/widget/TextView:setGravity	(I)V
    //   191: goto -114 -> 77
    //   194: ldc 132
    //   196: aload_3
    //   197: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq -123 -> 77
    //   203: aload_0
    //   204: iconst_5
    //   205: invokevirtual 70	android/widget/TextView:setGravity	(I)V
    //   208: goto -131 -> 77
    //   211: ldc 134
    //   213: aload_3
    //   214: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq -116 -> 101
    //   220: aload_0
    //   221: invokevirtual 78	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   224: iconst_0
    //   225: invokevirtual 84	android/text/TextPaint:setFakeBoldText	(Z)V
    //   228: goto -127 -> 101
    //   231: astore_3
    //   232: goto -131 -> 101
    //   235: ldc 136
    //   237: aload_3
    //   238: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +11 -> 252
    //   244: aload_0
    //   245: iconst_1
    //   246: invokevirtual 122	android/widget/TextView:setSingleLine	(Z)V
    //   249: goto -88 -> 161
    //   252: ldc 138
    //   254: aload_3
    //   255: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +11 -> 269
    //   261: aload_0
    //   262: iconst_0
    //   263: invokevirtual 122	android/widget/TextView:setSingleLine	(Z)V
    //   266: goto -105 -> 161
    //   269: ldc 140
    //   271: aload_3
    //   272: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifeq -114 -> 161
    //   278: aload_0
    //   279: iconst_0
    //   280: invokevirtual 122	android/widget/TextView:setSingleLine	(Z)V
    //   283: goto -122 -> 161
    //   286: astore_0
    //   287: ldc 9
    //   289: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: return
    //   293: astore_3
    //   294: goto -238 -> 56
    //   297: astore_3
    //   298: goto -257 -> 41
    //   301: astore_3
    //   302: goto -225 -> 77
    //   305: astore_3
    //   306: goto -145 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramTextView	android.widget.TextView
    //   0	309	1	paramJSONObject	JSONObject
    //   117	13	2	i	int
    //   25	189	3	str	java.lang.String
    //   231	41	3	localJSONException1	JSONException
    //   293	1	3	localJSONException2	JSONException
    //   297	1	3	localJSONException3	JSONException
    //   301	1	3	localJSONException4	JSONException
    //   305	1	3	localJSONException5	JSONException
    // Exception table:
    //   from	to	target	type
    //   77	101	231	org/json/JSONException
    //   211	228	231	org/json/JSONException
    //   161	171	286	org/json/JSONException
    //   41	56	293	org/json/JSONException
    //   19	41	297	org/json/JSONException
    //   56	77	301	org/json/JSONException
    //   177	191	301	org/json/JSONException
    //   194	208	301	org/json/JSONException
    //   133	161	305	org/json/JSONException
    //   235	249	305	org/json/JSONException
    //   252	266	305	org/json/JSONException
    //   269	283	305	org/json/JSONException
  }
  
  public static void a(e parame, com.tencent.mm.plugin.appbrand.widget.c.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126630);
    if ((parama == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(126630);
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("iconPath");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = ((com.tencent.mm.plugin.appbrand.e.b)parame.q(com.tencent.mm.plugin.appbrand.e.b.class)).b(parame, paramJSONObject);
        ((com.tencent.mm.plugin.appbrand.e.a)parame.q(com.tencent.mm.plugin.appbrand.e.a.class)).a(paramJSONObject, new b.1(parama));
      }
      AppMethodBeat.o(126630);
      return;
    }
    catch (NullPointerException parame)
    {
      d.printErrStackTrace("Luggage.ViewAttributeHelper", parame, "attachImageViewAttribute", new Object[0]);
      AppMethodBeat.o(126630);
      return;
    }
    catch (JSONException parame)
    {
      label84:
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b
 * JD-Core Version:    0.7.0.1
 */