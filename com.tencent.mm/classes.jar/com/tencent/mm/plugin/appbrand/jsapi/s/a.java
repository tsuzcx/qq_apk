package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  /* Error */
  public static void a(android.widget.TextView paramTextView, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: ldc 10
    //   12: invokevirtual 16	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: invokestatic 22	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   20: ifne +11 -> 31
    //   23: aload_0
    //   24: aload_3
    //   25: invokestatic 28	com/tencent/mm/plugin/appbrand/u/h:wE	(Ljava/lang/String;)I
    //   28: invokevirtual 34	android/widget/TextView:setTextColor	(I)V
    //   31: aload_0
    //   32: iconst_0
    //   33: aload_1
    //   34: ldc 36
    //   36: invokevirtual 40	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   39: d2f
    //   40: invokestatic 44	com/tencent/mm/plugin/appbrand/u/h:am	(F)F
    //   43: invokevirtual 48	android/widget/TextView:setTextSize	(IF)V
    //   46: aload_1
    //   47: ldc 50
    //   49: invokevirtual 16	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_3
    //   53: ldc 52
    //   55: aload_3
    //   56: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +105 -> 164
    //   62: aload_0
    //   63: iconst_3
    //   64: invokevirtual 61	android/widget/TextView:setGravity	(I)V
    //   67: aload_1
    //   68: ldc 63
    //   70: invokevirtual 16	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_3
    //   74: ldc 65
    //   76: aload_3
    //   77: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +118 -> 198
    //   83: aload_0
    //   84: invokevirtual 69	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   87: iconst_1
    //   88: invokevirtual 75	android/text/TextPaint:setFakeBoldText	(Z)V
    //   91: aload_1
    //   92: ldc 77
    //   94: aload_0
    //   95: invokevirtual 81	android/widget/TextView:getTextSize	()F
    //   98: ldc 82
    //   100: fmul
    //   101: invokestatic 88	java/lang/Math:round	(F)I
    //   104: invokestatic 91	com/tencent/mm/plugin/appbrand/u/h:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   107: istore_2
    //   108: aload_0
    //   109: instanceof 93
    //   112: ifeq +11 -> 123
    //   115: aload_0
    //   116: checkcast 93	com/tencent/mm/plugin/appbrand/widget/f
    //   119: iload_2
    //   120: invokevirtual 96	com/tencent/mm/plugin/appbrand/widget/f:setLineHeight	(I)V
    //   123: aload_1
    //   124: ldc 98
    //   126: invokevirtual 16	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_3
    //   130: ldc 100
    //   132: aload_3
    //   133: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: ifeq +86 -> 222
    //   139: aload_0
    //   140: getstatic 106	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   143: invokevirtual 110	android/widget/TextView:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)V
    //   146: aload_0
    //   147: iconst_1
    //   148: invokevirtual 113	android/widget/TextView:setSingleLine	(Z)V
    //   151: aload_0
    //   152: aload_1
    //   153: ldc 115
    //   155: invokevirtual 16	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 119	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   161: return
    //   162: astore_0
    //   163: return
    //   164: ldc 121
    //   166: aload_3
    //   167: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +11 -> 181
    //   173: aload_0
    //   174: iconst_1
    //   175: invokevirtual 61	android/widget/TextView:setGravity	(I)V
    //   178: goto -111 -> 67
    //   181: ldc 123
    //   183: aload_3
    //   184: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq -120 -> 67
    //   190: aload_0
    //   191: iconst_5
    //   192: invokevirtual 61	android/widget/TextView:setGravity	(I)V
    //   195: goto -128 -> 67
    //   198: ldc 125
    //   200: aload_3
    //   201: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq -113 -> 91
    //   207: aload_0
    //   208: invokevirtual 69	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   211: iconst_0
    //   212: invokevirtual 75	android/text/TextPaint:setFakeBoldText	(Z)V
    //   215: goto -124 -> 91
    //   218: astore_3
    //   219: goto -128 -> 91
    //   222: ldc 127
    //   224: aload_3
    //   225: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifeq +11 -> 239
    //   231: aload_0
    //   232: iconst_1
    //   233: invokevirtual 113	android/widget/TextView:setSingleLine	(Z)V
    //   236: goto -85 -> 151
    //   239: ldc 129
    //   241: aload_3
    //   242: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifeq +11 -> 256
    //   248: aload_0
    //   249: iconst_0
    //   250: invokevirtual 113	android/widget/TextView:setSingleLine	(Z)V
    //   253: goto -102 -> 151
    //   256: ldc 131
    //   258: aload_3
    //   259: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq -111 -> 151
    //   265: aload_0
    //   266: iconst_0
    //   267: invokevirtual 113	android/widget/TextView:setSingleLine	(Z)V
    //   270: goto -119 -> 151
    //   273: astore_3
    //   274: goto -228 -> 46
    //   277: astore_3
    //   278: goto -247 -> 31
    //   281: astore_3
    //   282: goto -215 -> 67
    //   285: astore_3
    //   286: goto -135 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramTextView	android.widget.TextView
    //   0	289	1	paramJSONObject	JSONObject
    //   107	13	2	i	int
    //   15	186	3	str	java.lang.String
    //   218	41	3	localJSONException1	JSONException
    //   273	1	3	localJSONException2	JSONException
    //   277	1	3	localJSONException3	JSONException
    //   281	1	3	localJSONException4	JSONException
    //   285	1	3	localJSONException5	JSONException
    // Exception table:
    //   from	to	target	type
    //   151	161	162	org/json/JSONException
    //   67	91	218	org/json/JSONException
    //   198	215	218	org/json/JSONException
    //   31	46	273	org/json/JSONException
    //   9	31	277	org/json/JSONException
    //   46	67	281	org/json/JSONException
    //   164	178	281	org/json/JSONException
    //   181	195	281	org/json/JSONException
    //   123	151	285	org/json/JSONException
    //   222	236	285	org/json/JSONException
    //   239	253	285	org/json/JSONException
    //   256	270	285	org/json/JSONException
  }
  
  public static void a(e parame, ImageView paramImageView, JSONObject paramJSONObject)
  {
    if ((paramImageView == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.getString("iconPath");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramJSONObject = ((b)parame.i(b.class)).b(parame, paramJSONObject);
          parame = (com.tencent.mm.plugin.appbrand.d.a)parame.i(com.tencent.mm.plugin.appbrand.d.a.class);
          Bitmap localBitmap = parame.ba(paramJSONObject);
          if (localBitmap == null) {
            parame.a(paramImageView, paramJSONObject);
          }
          if ((localBitmap == null) || (localBitmap.isRecycled()))
          {
            paramImageView.setImageBitmap(null);
            return;
          }
          paramImageView.setImageBitmap(localBitmap);
          return;
        }
      }
      catch (JSONException parame) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a
 * JD-Core Version:    0.7.0.1
 */