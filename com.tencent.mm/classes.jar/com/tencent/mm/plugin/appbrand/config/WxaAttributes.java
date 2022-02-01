package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.je;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;>;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes
  extends je
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO;
  private a rbA;
  private c rbB;
  private WxaVersionInfo rbC;
  private List<WxaAttributes.WxaEntryInfo> rbD = null;
  private b rbE;
  
  static
  {
    AppMethodBeat.i(123525);
    DB_INFO = je.aJm();
    AppMethodBeat.o(123525);
  }
  
  public static JSONObject XU(String paramString)
  {
    AppMethodBeat.i(323420);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(323420);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(323420);
      return paramString;
    }
    catch (JSONException paramString)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.WxaAttributes", paramString, "createJsonObjectOrNull", new Object[0]);
      AppMethodBeat.o(323420);
    }
    return null;
  }
  
  private List<WxaAttributes.b.a> n(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(123523);
    Object localObject;
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        int j = paramJSONArray.length();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = paramJSONArray.getJSONObject(i);
          WxaAttributes.b.a locala = new WxaAttributes.b.a();
          locala.name = ((JSONObject)localObject).optString("name", "");
          locala.type = ((JSONObject)localObject).optInt("type");
          JSONObject localJSONObject = new JSONObject(((JSONObject)localObject).optString("value", ""));
          locala.userName = localJSONObject.optString("userName", "");
          locala.hzy = localJSONObject.optString("pagePath", "");
          locala.version = localJSONObject.optInt("version");
          locala.rbQ = n(((JSONObject)localObject).optJSONArray("sub_button_list"));
          localArrayList.add(locala);
          i += 1;
        }
        localObject = null;
      }
      catch (JSONException paramJSONArray)
      {
        AppMethodBeat.o(123523);
        return null;
      }
    }
    AppMethodBeat.o(123523);
    return localObject;
  }
  
  public final a cld()
  {
    AppMethodBeat.i(123518);
    if (this.rbA == null) {
      this.rbA = a.XV(this.field_appInfo);
    }
    a locala = this.rbA;
    AppMethodBeat.o(123518);
    return locala;
  }
  
  /* Error */
  public final c cle()
  {
    // Byte code:
    //   0: ldc 202
    //   2: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   9: ifnonnull +968 -> 977
    //   12: new 99	org/json/JSONObject
    //   15: dup
    //   16: aload_0
    //   17: getfield 207	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_dynamicInfo	Ljava/lang/String;
    //   20: invokespecial 102	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: astore 6
    //   29: aload 5
    //   31: ifnonnull +12 -> 43
    //   34: new 99	org/json/JSONObject
    //   37: dup
    //   38: invokespecial 208	org/json/JSONObject:<init>	()V
    //   41: astore 6
    //   43: aload_0
    //   44: new 46	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c
    //   47: dup
    //   48: invokespecial 209	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:<init>	()V
    //   51: putfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   54: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   57: lstore_2
    //   58: aload 6
    //   60: ldc 215
    //   62: invokevirtual 218	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   65: astore 5
    //   67: aload 5
    //   69: ifnonnull +971 -> 1040
    //   72: new 99	org/json/JSONObject
    //   75: dup
    //   76: invokespecial 208	org/json/JSONObject:<init>	()V
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   85: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   88: aload 5
    //   90: ldc 224
    //   92: iconst_5
    //   93: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   96: putfield 230	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:eqc	I
    //   99: aload_0
    //   100: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   103: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   106: aload 5
    //   108: ldc 232
    //   110: iconst_5
    //   111: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   114: putfield 235	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbT	I
    //   117: aload_0
    //   118: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   121: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   124: aload 5
    //   126: ldc 237
    //   128: iconst_5
    //   129: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   132: putfield 240	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbU	I
    //   135: aload_0
    //   136: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   139: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   142: aload 5
    //   144: ldc 242
    //   146: iconst_5
    //   147: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   150: putfield 245	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qYQ	I
    //   153: aload_0
    //   154: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   157: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   160: aload 5
    //   162: ldc 247
    //   164: sipush 600
    //   167: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   170: putfield 250	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epG	I
    //   173: aload_0
    //   174: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   177: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   180: aload 5
    //   182: ldc 252
    //   184: bipush 10
    //   186: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   189: putfield 255	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epH	I
    //   192: aload_0
    //   193: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   196: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   199: aload 5
    //   201: ldc_w 257
    //   204: bipush 10
    //   206: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   209: putfield 260	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epI	I
    //   212: aload_0
    //   213: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   216: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   219: aload 5
    //   221: ldc_w 262
    //   224: bipush 10
    //   226: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   229: putfield 265	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epJ	I
    //   232: aload_0
    //   233: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   236: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   239: aload 5
    //   241: ldc_w 267
    //   244: iconst_5
    //   245: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   248: putfield 270	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epK	I
    //   251: aload_0
    //   252: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   255: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   258: aload 5
    //   260: ldc_w 272
    //   263: iconst_1
    //   264: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   267: putfield 275	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epL	I
    //   270: aload_0
    //   271: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   274: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   277: astore 7
    //   279: aload 5
    //   281: ldc_w 277
    //   284: iconst_0
    //   285: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   288: ifeq +608 -> 896
    //   291: iconst_1
    //   292: istore 4
    //   294: aload 7
    //   296: iload 4
    //   298: putfield 281	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epM	Z
    //   301: aload_0
    //   302: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   305: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   308: astore 7
    //   310: aload 5
    //   312: ldc_w 283
    //   315: iconst_0
    //   316: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   319: ifeq +583 -> 902
    //   322: iconst_1
    //   323: istore 4
    //   325: aload 7
    //   327: iload 4
    //   329: putfield 286	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:epN	Z
    //   332: aload_0
    //   333: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   336: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   339: aload 5
    //   341: ldc_w 288
    //   344: bipush 10
    //   346: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   349: putfield 291	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbV	I
    //   352: aload_0
    //   353: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   356: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   359: aload 5
    //   361: ldc_w 293
    //   364: sipush 300
    //   367: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   370: putfield 296	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbW	I
    //   373: aload_0
    //   374: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   377: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   380: aload 5
    //   382: ldc_w 298
    //   385: bipush 100
    //   387: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   390: putfield 301	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbX	I
    //   393: aload_0
    //   394: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   397: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   400: aload 5
    //   402: ldc_w 303
    //   405: iconst_5
    //   406: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   409: putfield 306	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbY	I
    //   412: aload_0
    //   413: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   416: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   419: astore 7
    //   421: aload 5
    //   423: ldc_w 308
    //   426: iconst_0
    //   427: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   430: ifle +478 -> 908
    //   433: iconst_1
    //   434: istore 4
    //   436: aload 7
    //   438: iload 4
    //   440: putfield 311	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qYR	Z
    //   443: aload_0
    //   444: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   447: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   450: aload 5
    //   452: ldc_w 313
    //   455: iconst_5
    //   456: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   459: putfield 316	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qYW	I
    //   462: aload_0
    //   463: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   466: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   469: aload 5
    //   471: ldc_w 318
    //   474: sipush 300
    //   477: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   480: putfield 321	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qYX	I
    //   483: aload_0
    //   484: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   487: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   490: astore 7
    //   492: aload 5
    //   494: ldc_w 323
    //   497: iconst_0
    //   498: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   501: ifeq +413 -> 914
    //   504: iconst_1
    //   505: istore 4
    //   507: aload 7
    //   509: iload 4
    //   511: putfield 326	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:eqa	Z
    //   514: aload_0
    //   515: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   518: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   521: astore 7
    //   523: aload 5
    //   525: ldc_w 328
    //   528: iconst_0
    //   529: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   532: ifle +388 -> 920
    //   535: iconst_1
    //   536: istore 4
    //   538: aload 7
    //   540: iload 4
    //   542: putfield 331	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qRE	Z
    //   545: aload_0
    //   546: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   549: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   552: astore 7
    //   554: aload 5
    //   556: ldc_w 333
    //   559: iconst_0
    //   560: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   563: ifle +363 -> 926
    //   566: iconst_1
    //   567: istore 4
    //   569: aload 7
    //   571: iload 4
    //   573: putfield 336	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qRF	Z
    //   576: aload_0
    //   577: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   580: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   583: aload 5
    //   585: ldc_w 338
    //   588: iconst_0
    //   589: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   592: putfield 341	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qRG	I
    //   595: aload_0
    //   596: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   599: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   602: aload 5
    //   604: ldc_w 343
    //   607: bipush 7
    //   609: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   612: putfield 346	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qRH	I
    //   615: aload_0
    //   616: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   619: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   622: aload 5
    //   624: ldc_w 348
    //   627: iconst_0
    //   628: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   631: putfield 351	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rbZ	I
    //   634: aload_0
    //   635: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   638: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   641: astore 7
    //   643: aload 5
    //   645: ldc_w 353
    //   648: iconst_0
    //   649: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   652: ifle +280 -> 932
    //   655: iconst_1
    //   656: istore 4
    //   658: aload 7
    //   660: iload 4
    //   662: putfield 356	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rca	Z
    //   665: aload_0
    //   666: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   669: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   672: aload 5
    //   674: ldc_w 358
    //   677: iconst_0
    //   678: invokevirtual 227	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   681: putfield 361	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:qYr	I
    //   684: aload_0
    //   685: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   688: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   691: aload 5
    //   693: ldc_w 363
    //   696: ldc2_w 364
    //   699: invokevirtual 369	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   702: putfield 373	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rcb	J
    //   705: aload_0
    //   706: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   709: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   712: aload 5
    //   714: ldc_w 375
    //   717: ldc2_w 376
    //   720: invokevirtual 369	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   723: putfield 380	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rcc	J
    //   726: aload_0
    //   727: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   730: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   733: aload 5
    //   735: ldc_w 382
    //   738: lconst_0
    //   739: invokevirtual 369	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   742: putfield 385	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rcd	J
    //   745: aload_0
    //   746: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   749: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   752: aload 5
    //   754: ldc_w 387
    //   757: ldc2_w 376
    //   760: invokevirtual 369	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   763: putfield 390	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rce	J
    //   766: aload_0
    //   767: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   770: getfield 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbR	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   773: aload 5
    //   775: ldc_w 392
    //   778: ldc 135
    //   780: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   783: getstatic 398	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   786: invokevirtual 404	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   789: putfield 408	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:rcf	[B
    //   792: aload 6
    //   794: ldc_w 410
    //   797: invokevirtual 172	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   800: astore 5
    //   802: aload 5
    //   804: ifnull +134 -> 938
    //   807: aload_0
    //   808: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   811: new 412	java/util/LinkedList
    //   814: dup
    //   815: invokespecial 413	java/util/LinkedList:<init>	()V
    //   818: putfield 416	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbS	Ljava/util/List;
    //   821: iconst_0
    //   822: istore_1
    //   823: iload_1
    //   824: aload 5
    //   826: invokevirtual 126	org/json/JSONArray:length	()I
    //   829: if_icmpge +109 -> 938
    //   832: aload 5
    //   834: iload_1
    //   835: invokevirtual 418	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   838: astore 6
    //   840: aload 6
    //   842: ifnull +39 -> 881
    //   845: aload_0
    //   846: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   849: getfield 416	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:rbS	Ljava/util/List;
    //   852: new 420	android/util/Pair
    //   855: dup
    //   856: aload 6
    //   858: ldc_w 422
    //   861: invokevirtual 425	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   864: aload 6
    //   866: ldc_w 427
    //   869: invokevirtual 425	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   872: invokespecial 430	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   875: invokeinterface 183 2 0
    //   880: pop
    //   881: iload_1
    //   882: iconst_1
    //   883: iadd
    //   884: istore_1
    //   885: goto -62 -> 823
    //   888: astore 5
    //   890: aconst_null
    //   891: astore 5
    //   893: goto -868 -> 25
    //   896: iconst_0
    //   897: istore 4
    //   899: goto -605 -> 294
    //   902: iconst_0
    //   903: istore 4
    //   905: goto -580 -> 325
    //   908: iconst_0
    //   909: istore 4
    //   911: goto -475 -> 436
    //   914: iconst_0
    //   915: istore 4
    //   917: goto -410 -> 507
    //   920: iconst_0
    //   921: istore 4
    //   923: goto -385 -> 538
    //   926: iconst_0
    //   927: istore 4
    //   929: goto -360 -> 569
    //   932: iconst_0
    //   933: istore 4
    //   935: goto -277 -> 658
    //   938: ldc 104
    //   940: ldc_w 432
    //   943: iconst_2
    //   944: anewarray 108	java/lang/Object
    //   947: dup
    //   948: iconst_0
    //   949: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   952: lload_2
    //   953: lsub
    //   954: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   957: aastore
    //   958: dup
    //   959: iconst_1
    //   960: aload_0
    //   961: getfield 207	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_dynamicInfo	Ljava/lang/String;
    //   964: invokestatic 441	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   967: invokevirtual 442	java/lang/String:length	()I
    //   970: invokestatic 447	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   973: aastore
    //   974: invokestatic 450	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   977: aload_0
    //   978: getfield 204	com/tencent/mm/plugin/appbrand/config/WxaAttributes:rbB	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   981: astore 5
    //   983: ldc 202
    //   985: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   988: aload 5
    //   990: areturn
    //   991: astore 5
    //   993: ldc 104
    //   995: ldc_w 432
    //   998: iconst_2
    //   999: anewarray 108	java/lang/Object
    //   1002: dup
    //   1003: iconst_0
    //   1004: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1007: lload_2
    //   1008: lsub
    //   1009: invokestatic 438	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1012: aastore
    //   1013: dup
    //   1014: iconst_1
    //   1015: aload_0
    //   1016: getfield 207	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_dynamicInfo	Ljava/lang/String;
    //   1019: invokestatic 441	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   1022: invokevirtual 442	java/lang/String:length	()I
    //   1025: invokestatic 447	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1028: aastore
    //   1029: invokestatic 450	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1032: ldc 202
    //   1034: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1037: aload 5
    //   1039: athrow
    //   1040: goto -959 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1043	0	this	WxaAttributes
    //   822	63	1	i	int
    //   57	951	2	l	long
    //   292	642	4	bool	boolean
    //   23	810	5	localObject1	Object
    //   888	1	5	localException	Exception
    //   891	98	5	localc	c
    //   991	47	5	localObject2	Object
    //   27	838	6	localObject3	Object
    //   277	382	7	locala	WxaAttributes.c.a
    // Exception table:
    //   from	to	target	type
    //   12	25	888	java/lang/Exception
    //   58	67	991	finally
    //   72	81	991	finally
    //   81	291	991	finally
    //   294	322	991	finally
    //   325	433	991	finally
    //   436	504	991	finally
    //   507	535	991	finally
    //   538	566	991	finally
    //   569	655	991	finally
    //   658	802	991	finally
    //   807	821	991	finally
    //   823	840	991	finally
    //   845	881	991	finally
  }
  
  public final WxaVersionInfo clf()
  {
    AppMethodBeat.i(123520);
    if ((this.rbC == null) && (!Util.isNullOrNil(this.field_versionInfo)))
    {
      localWxaVersionInfo = WxaVersionInfo.XW(this.field_versionInfo);
      this.rbC = localWxaVersionInfo;
      AppMethodBeat.o(123520);
      return localWxaVersionInfo;
    }
    WxaVersionInfo localWxaVersionInfo = this.rbC;
    AppMethodBeat.o(123520);
    return localWxaVersionInfo;
  }
  
  public final List<WxaAttributes.WxaEntryInfo> clg()
  {
    AppMethodBeat.i(123521);
    if ((this.rbD == null) && (!Util.isNullOrNil(this.field_bindWxaInfo))) {
      try
      {
        JSONArray localJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
        if (localJSONArray != null)
        {
          this.rbD = new LinkedList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject != null)
            {
              String str = localJSONObject.optString("username");
              if (!Util.isNullOrNil(str))
              {
                WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
                localWxaEntryInfo.username = str;
                localWxaEntryInfo.title = localJSONObject.optString("title");
                localWxaEntryInfo.iconUrl = localJSONObject.optString("icon_url");
                this.rbD.add(localWxaEntryInfo);
              }
            }
            i += 1;
          }
        }
        localList = this.rbD;
      }
      catch (Exception localException)
      {
        this.rbD = null;
      }
    }
    List localList;
    AppMethodBeat.o(123521);
    return localList;
  }
  
  public final b clh()
  {
    AppMethodBeat.i(123522);
    if ((this.rbE == null) && (!Util.isNullOrNil(this.field_bizMenu))) {}
    try
    {
      Object localObject = new JSONObject(this.field_bizMenu);
      this.rbE = new b();
      this.rbE.hda = ((JSONObject)localObject).optInt("interactive_mode", 0);
      this.rbE.type = ((JSONObject)localObject).optInt("type", 0);
      this.rbE.rbP = n(((JSONObject)localObject).optJSONArray("button_list"));
      localObject = this.rbE;
      AppMethodBeat.o(123522);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.rbE = null;
      }
    }
  }
  
  public final void cli()
  {
    int i = 0;
    AppMethodBeat.i(323449);
    String str1 = String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s)START >>>>>>", new Object[] { this.field_username, this.field_appId, this.field_nickname });
    String str2 = ">>> field_appInfo=" + this.field_appInfo;
    String str3 = ">>> field_versionInfo=" + this.field_versionInfo;
    String str4 = ">>> field_dynamicInfo=" + this.field_dynamicInfo;
    String str5 = String.format(Locale.ENGLISH, ">>>>>> WxaAttributes(%s|%s|%s) END >>>>>>", new Object[] { this.field_username, this.field_appId, this.field_nickname });
    while (i < 5)
    {
      com.tencent.stubs.logger.Log.println(4, "MicroMsg.AppBrand.WxaAttributes", new String[] { str1, str2, str3, str4, str5 }[i]);
      i += 1;
    }
    AppMethodBeat.o(323449);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(123517);
    super.convertFrom(paramCursor);
    this.rbA = null;
    this.rbB = null;
    this.rbC = null;
    this.rbD = null;
    this.rbE = null;
    AppMethodBeat.o(123517);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123524);
    String str = "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    AppMethodBeat.o(123524);
    return str;
  }
  
  public static final class HalfPage
    implements Parcelable
  {
    public static final Parcelable.Creator<HalfPage> CREATOR;
    public String rbF;
    
    static
    {
      AppMethodBeat.i(323411);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(323411);
    }
    
    protected HalfPage()
    {
      this.rbF = "default";
    }
    
    protected HalfPage(Parcel paramParcel)
    {
      AppMethodBeat.i(323407);
      this.rbF = "default";
      this.rbF = paramParcel.readString();
      AppMethodBeat.o(323407);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(323414);
      paramParcel.writeString(this.rbF);
      AppMethodBeat.o(323414);
    }
  }
  
  public static class WxaPluginCodeInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPluginCodeInfo> CREATOR;
    public List<Integer> contexts;
    public String md5;
    public String prefixPath;
    public String provider;
    public String qGf;
    public boolean rch;
    public long rci;
    public int version;
    
    static
    {
      AppMethodBeat.i(123500);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123500);
    }
    
    public WxaPluginCodeInfo()
    {
      AppMethodBeat.i(175234);
      this.contexts = new LinkedList();
      AppMethodBeat.o(175234);
    }
    
    protected WxaPluginCodeInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123499);
      this.contexts = new LinkedList();
      this.provider = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.md5 = paramParcel.readString();
      this.prefixPath = paramParcel.readString();
      if (paramParcel.readByte() == 1) {}
      for (;;)
      {
        this.rch = bool;
        if (this.contexts == null) {
          this.contexts = new LinkedList();
        }
        paramParcel.readList(this.contexts, Integer.class.getClassLoader());
        this.rci = paramParcel.readLong();
        this.qGf = paramParcel.readString();
        AppMethodBeat.o(123499);
        return;
        bool = false;
      }
    }
    
    public static List<WxaPluginCodeInfo> a(List<WxaAttributes.WxaWidgetInfo> paramList, Object paramObject, int paramInt)
    {
      AppMethodBeat.i(323408);
      Object localObject = null;
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (paramList = (List<WxaAttributes.WxaWidgetInfo>)localObject; localIterator.hasNext(); paramList = ((WxaAttributes.WxaWidgetInfo)localObject).rcG)
        {
          localObject = (WxaAttributes.WxaWidgetInfo)localIterator.next();
          if (((WxaAttributes.WxaWidgetInfo)localObject).hDq != paramInt) {
            break label76;
          }
        }
      }
      for (;;)
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = dU(paramObject);
        }
        AppMethodBeat.o(323408);
        return localObject;
        label76:
        break;
        paramList = null;
      }
    }
    
    public static List<WxaPluginCodeInfo> dU(Object paramObject)
    {
      AppMethodBeat.i(323415);
      if (paramObject == null)
      {
        AppMethodBeat.o(323415);
        return null;
      }
      for (;;)
      {
        int i;
        try
        {
          if ((paramObject instanceof String))
          {
            paramObject = new JSONArray((String)paramObject);
            if (paramObject != null)
            {
              i = paramObject.length();
              if (i != 0) {}
            }
            else
            {
              AppMethodBeat.o(323415);
              return null;
            }
          }
          else
          {
            if ((paramObject instanceof JSONArray))
            {
              paramObject = (JSONArray)paramObject;
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", new Object[] { paramObject.getClass().getName() });
            paramObject = null;
            continue;
          }
          LinkedList localLinkedList = new LinkedList();
          i = 0;
          if (i < paramObject.length())
          {
            JSONObject localJSONObject = paramObject.getJSONObject(i);
            if (localJSONObject == null) {
              break label360;
            }
            WxaPluginCodeInfo localWxaPluginCodeInfo = new WxaPluginCodeInfo();
            localWxaPluginCodeInfo.provider = localJSONObject.optString("plugin_id");
            localWxaPluginCodeInfo.version = localJSONObject.optInt("inner_version");
            localWxaPluginCodeInfo.md5 = localJSONObject.optString("md5");
            localWxaPluginCodeInfo.prefixPath = localJSONObject.optString("prefix_path");
            if (!localJSONObject.optBoolean("auto_update"))
            {
              if (localJSONObject.optInt("auto_update", 0) <= 0) {
                break label367;
              }
              break label355;
              localWxaPluginCodeInfo.rch = bool;
              JSONArray localJSONArray = localJSONObject.optJSONArray("contexts");
              if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
                break label372;
              }
              localWxaPluginCodeInfo.contexts.add(Integer.valueOf(0));
              localWxaPluginCodeInfo.rci = localJSONObject.optLong("dev_key");
              localWxaPluginCodeInfo.qGf = localJSONObject.optString("version_desc");
              localLinkedList.add(localWxaPluginCodeInfo);
              break label360;
              if (j < localJSONArray.length())
              {
                localWxaPluginCodeInfo.contexts.add(Integer.valueOf(localJSONArray.optInt(j)));
                j += 1;
                continue;
              }
              continue;
            }
          }
          else
          {
            AppMethodBeat.o(323415);
            return localLinkedList;
          }
        }
        catch (JSONException paramObject)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramObject });
          AppMethodBeat.o(323415);
          return null;
        }
        label355:
        boolean bool = true;
        continue;
        label360:
        i += 1;
        continue;
        label367:
        bool = false;
        continue;
        label372:
        int j = 0;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123498);
      paramParcel.writeString(this.provider);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.prefixPath);
      if (this.rch) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeList(this.contexts);
        paramParcel.writeLong(this.rci);
        paramParcel.writeString(this.qGf);
        AppMethodBeat.o(123498);
        return;
      }
    }
  }
  
  public static final class WxaVersionCoverImageInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionCoverImageInfo> CREATOR;
    public String rcj;
    public String rck;
    
    static
    {
      AppMethodBeat.i(123504);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123504);
    }
    
    public WxaVersionCoverImageInfo() {}
    
    protected WxaVersionCoverImageInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123503);
      this.rcj = paramParcel.readString();
      this.rck = paramParcel.readString();
      AppMethodBeat.o(123503);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123502);
      paramParcel.writeString(this.rcj);
      paramParcel.writeString(this.rck);
      AppMethodBeat.o(123502);
    }
  }
  
  public static final class WxaVersionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
    public int appVersion;
    public int eoZ;
    public boolean euO;
    public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
    public List<WxaAttributes.WxaWidgetInfo> oVI;
    public long rcA;
    public String rcB;
    public String rcl;
    public String rcm;
    public WxaAttributes.WxaVersionCoverImageInfo rcn;
    public List<WxaAttributes.WxaPluginCodeInfo> rco;
    public int rcp;
    public boolean rcq;
    public String rcr;
    public String rcs;
    public String rct;
    public long rcu;
    public String rcv;
    public String rcw;
    public String rcx;
    public String rcy;
    public WxaAttributes.HalfPage rcz;
    
    static
    {
      AppMethodBeat.i(123509);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123509);
    }
    
    public WxaVersionInfo()
    {
      this.rcv = "";
      this.rcw = "";
      this.rcx = "";
      this.rcy = "";
      this.euO = false;
    }
    
    protected WxaVersionInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123508);
      this.rcv = "";
      this.rcw = "";
      this.rcx = "";
      this.rcy = "";
      this.euO = false;
      this.appVersion = paramParcel.readInt();
      this.eoZ = paramParcel.readInt();
      this.rcl = paramParcel.readString();
      this.rcm = paramParcel.readString();
      this.rcn = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
      this.rco = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.rcp = paramParcel.readInt();
      this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.rcq = bool1;
        this.rcr = paramParcel.readString();
        this.rcs = paramParcel.readString();
        this.rct = paramParcel.readString();
        this.oVI = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        this.rcv = paramParcel.readString();
        this.rcw = paramParcel.readString();
        this.rcx = paramParcel.readString();
        this.rcy = paramParcel.readString();
        if (paramParcel.readByte() <= 0) {
          break label248;
        }
      }
      label248:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.euO = bool1;
        this.rcA = paramParcel.readLong();
        this.rcz = ((WxaAttributes.HalfPage)paramParcel.readParcelable(WxaAttributes.HalfPage.class.getClassLoader()));
        AppMethodBeat.o(123508);
        return;
        bool1 = false;
        break;
      }
    }
    
    public static WxaVersionInfo XW(String paramString)
    {
      AppMethodBeat.i(123506);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123506);
        return null;
      }
      l = Util.currentTicks();
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        WxaVersionInfo localWxaVersionInfo = new WxaVersionInfo();
        localWxaVersionInfo.appVersion = localJSONObject1.optInt("AppVersion", 0);
        localWxaVersionInfo.eoZ = localJSONObject1.optInt("VersionState", -1);
        localWxaVersionInfo.rcl = localJSONObject1.optString("VersionMD5");
        localWxaVersionInfo.rcm = localJSONObject1.optString("device_orientation");
        localWxaVersionInfo.rcs = localJSONObject1.optString("client_js_ext_info");
        localWxaVersionInfo.rcp = localJSONObject1.optInt("code_size");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
        if (localJSONObject2 != null)
        {
          localWxaVersionInfo.rcn = new WxaAttributes.WxaVersionCoverImageInfo();
          localWxaVersionInfo.rcn.rcj = localJSONObject2.optString("url");
          localWxaVersionInfo.rcn.rck = localJSONObject2.optString("progressbar_color");
        }
        JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
        if (localJSONObject3 != null)
        {
          localJSONObject2 = localJSONObject3.optJSONObject("white_style");
          localJSONObject3 = localJSONObject3.optJSONObject("black_style");
          if (localJSONObject2 != null)
          {
            if (localJSONObject2.has("navigation_bar_text_color")) {
              localWxaVersionInfo.rcv = localJSONObject2.optString("navigation_bar_text_color");
            }
            if (localJSONObject2.has("background_color")) {
              localWxaVersionInfo.rcw = localJSONObject2.optString("background_color");
            }
          }
          if (localJSONObject3 != null)
          {
            if (localJSONObject3.has("navigation_bar_text_color")) {
              localWxaVersionInfo.rcx = localJSONObject3.optString("navigation_bar_text_color");
            }
            if (localJSONObject3.has("background_color")) {
              localWxaVersionInfo.rcy = localJSONObject3.optString("background_color");
            }
          }
        }
        localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.o(localJSONObject1.optJSONArray("module_list"));
        localWxaVersionInfo.rcq = localJSONObject1.optBoolean("UseModule", false);
        localWxaVersionInfo.rcr = localJSONObject1.optString("EntranceModule");
        localWxaVersionInfo.rct = localJSONObject1.optString("without_lib_md5");
        localWxaVersionInfo.oVI = WxaAttributes.WxaWidgetInfo.p(localJSONObject1.optJSONArray("widget_list"));
        localWxaVersionInfo.rco = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.oVI, localJSONObject1.opt("separated_plugin_list"), 22);
        localWxaVersionInfo.rcu = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
        localWxaVersionInfo.euO = localJSONObject1.optBoolean("resizable", false);
        localJSONObject2 = localJSONObject1.optJSONObject("halfPage");
        localWxaVersionInfo.rcz = new WxaAttributes.HalfPage();
        if (localJSONObject2 != null) {
          localWxaVersionInfo.rcz.rbF = localJSONObject2.optString("firstPageNavigationStyle");
        }
        localWxaVersionInfo.rcA = localJSONObject1.optLong("template_id", -1L);
        localWxaVersionInfo.rcB = localJSONObject1.optString("renderer");
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        paramString = localWxaVersionInfo;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
          paramString = null;
        }
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        AppMethodBeat.o(123506);
      }
      AppMethodBeat.o(123506);
      return paramString;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(123507);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.eoZ);
      paramParcel.writeString(this.rcl);
      paramParcel.writeString(this.rcm);
      paramParcel.writeParcelable(this.rcn, paramInt);
      paramParcel.writeTypedList(this.rco);
      paramParcel.writeInt(this.rcp);
      paramParcel.writeTypedList(this.moduleList);
      byte b;
      if (this.rcq)
      {
        b = 1;
        paramParcel.writeByte(b);
        paramParcel.writeString(this.rcr);
        paramParcel.writeString(this.rcs);
        paramParcel.writeString(this.rct);
        paramParcel.writeTypedList(this.oVI);
        paramParcel.writeString(this.rcv);
        paramParcel.writeString(this.rcw);
        paramParcel.writeString(this.rcx);
        paramParcel.writeString(this.rcy);
        if (!this.euO) {
          break label195;
        }
      }
      for (;;)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeLong(this.rcA);
        paramParcel.writeParcelable(this.rcz, paramInt);
        AppMethodBeat.o(123507);
        return;
        b = 0;
        break;
        label195:
        i = 0;
      }
    }
  }
  
  public static class WxaVersionModuleInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaVersionModuleInfo> CREATOR;
    public String[] aliases;
    public boolean independent;
    public String md5;
    public String name;
    public List<WxaAttributes.WxaPluginCodeInfo> rcC;
    public List<WxaAttributes.WxaWidgetInfo> rcD;
    private JSONObject rcE;
    public String rct;
    public int size;
    
    static
    {
      AppMethodBeat.i(123516);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(123516);
    }
    
    public WxaVersionModuleInfo() {}
    
    protected WxaVersionModuleInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(123515);
      this.name = paramParcel.readString();
      this.md5 = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.independent = bool;
        this.size = paramParcel.readInt();
        this.aliases = paramParcel.createStringArray();
        this.rcC = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
        this.rct = paramParcel.readString();
        this.rcD = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
        AppMethodBeat.o(123515);
        return;
      }
    }
    
    private static String[] S(JSONObject paramJSONObject)
    {
      int i = 0;
      AppMethodBeat.i(123513);
      paramJSONObject = paramJSONObject.optJSONArray("alias");
      if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
      {
        AppMethodBeat.o(123513);
        return new String[0];
      }
      String[] arrayOfString = new String[paramJSONObject.length()];
      while (i < paramJSONObject.length())
      {
        arrayOfString[i] = paramJSONObject.optString(i);
        i += 1;
      }
      AppMethodBeat.o(123513);
      return arrayOfString;
    }
    
    public static List<WxaVersionModuleInfo> XX(String paramString)
    {
      AppMethodBeat.i(123512);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(123512);
        return null;
      }
      try
      {
        Object localObject = new JSONArray(paramString);
        int i = ((JSONArray)localObject).length();
        if (i <= 0)
        {
          AppMethodBeat.o(123512);
          return null;
        }
        localObject = o((JSONArray)localObject);
        AppMethodBeat.o(123512);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
        AppMethodBeat.o(123512);
      }
      return null;
    }
    
    public static List<WxaVersionModuleInfo> o(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(123511);
      if (paramJSONArray == null)
      {
        AppMethodBeat.o(123511);
        return null;
      }
      try
      {
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            WxaVersionModuleInfo localWxaVersionModuleInfo = new WxaVersionModuleInfo();
            localWxaVersionModuleInfo.rcE = localJSONObject;
            localWxaVersionModuleInfo.name = localJSONObject.getString("name");
            localWxaVersionModuleInfo.md5 = localJSONObject.getString("md5");
            localWxaVersionModuleInfo.size = localJSONObject.optInt("size", 0);
            localWxaVersionModuleInfo.independent = localJSONObject.optBoolean("independent", false);
            localWxaVersionModuleInfo.aliases = S(localJSONObject);
            localWxaVersionModuleInfo.rct = localJSONObject.optString("without_lib_md5");
            localWxaVersionModuleInfo.rcD = WxaAttributes.WxaWidgetInfo.p(localJSONObject.optJSONArray("widget_list"));
            localWxaVersionModuleInfo.rcC = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionModuleInfo.rcD, localJSONObject.opt("separated_plugin_list"), 23);
            localLinkedList.add(localWxaVersionModuleInfo);
          }
          i += 1;
        }
        AppMethodBeat.o(123511);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(123511);
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(123514);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.md5);
      if (this.independent) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.size);
        paramParcel.writeStringArray(this.aliases);
        paramParcel.writeTypedList(this.rcC);
        paramParcel.writeString(this.rct);
        paramParcel.writeTypedList(this.rcD);
        AppMethodBeat.o(123514);
        return;
      }
    }
  }
  
  public static class WxaWidgetInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaWidgetInfo> CREATOR;
    public int hDq;
    public String rcF;
    public List<WxaAttributes.WxaPluginCodeInfo> rcG;
    
    static
    {
      AppMethodBeat.i(175239);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(175239);
    }
    
    public WxaWidgetInfo() {}
    
    protected WxaWidgetInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(175238);
      this.hDq = paramParcel.readInt();
      this.rcF = paramParcel.readString();
      this.rcG = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      AppMethodBeat.o(175238);
    }
    
    public static List<WxaWidgetInfo> XY(String paramString)
    {
      AppMethodBeat.i(175236);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(175236);
        return null;
      }
      try
      {
        paramString = p(new JSONArray(paramString));
        AppMethodBeat.o(175236);
        return paramString;
      }
      catch (JSONException paramString)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
        AppMethodBeat.o(175236);
      }
      return null;
    }
    
    public static List<WxaWidgetInfo> p(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(323301);
      if (paramJSONArray != null) {}
      try
      {
        int i = paramJSONArray.length();
        if (i <= 0)
        {
          AppMethodBeat.o(323301);
          return null;
        }
        LinkedList localLinkedList = new LinkedList();
        i = 0;
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            WxaWidgetInfo localWxaWidgetInfo = new WxaWidgetInfo();
            localWxaWidgetInfo.hDq = localJSONObject.optInt("package_type");
            localWxaWidgetInfo.rcF = localJSONObject.optString("wxapkg_md5");
            if (org.apache.commons.c.a.contains(com.tencent.mm.cq.a.agWK, localWxaWidgetInfo.hDq))
            {
              localWxaWidgetInfo.rcG = WxaAttributes.WxaPluginCodeInfo.dU(localJSONObject.opt("separated_plugin_list"));
              localLinkedList.add(localWxaWidgetInfo);
            }
          }
          i += 1;
        }
        AppMethodBeat.o(323301);
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
        AppMethodBeat.o(323301);
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(175237);
      paramParcel.writeInt(this.hDq);
      paramParcel.writeString(this.rcF);
      paramParcel.writeTypedList(this.rcG);
      AppMethodBeat.o(175237);
    }
  }
  
  public static final class a
  {
    public String appId;
    public long eqh = 0L;
    public int nOX = 0;
    public int originalFlag;
    public long qQd = 0L;
    public String qXZ;
    public int qYa = 0;
    public int qZg;
    public int qZh;
    public String rbG;
    private int rbH;
    public List<String> rbI;
    public List<String> rbJ;
    public List<String> rbK;
    public List<String> rbL;
    public List<String> rbM;
    public List<String> rbN;
    public String rbO;
    public int serviceType;
    
    public static a XV(String paramString)
    {
      AppMethodBeat.i(123490);
      if (Util.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
        AppMethodBeat.o(123490);
        return null;
      }
      l = Util.currentTicks();
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        a locala = new a();
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("RunningFlagInfo");
        if (localJSONObject2 != null)
        {
          locala.eqh = localJSONObject2.optLong("RunningFlag");
          locala.rbG = localJSONObject2.optString("AppOpenForbiddenUrl");
          locala.qQd = localJSONObject2.optLong("CanNotStarWxaBeforeTime", 0L);
        }
        localJSONObject2 = localJSONObject1.optJSONObject("Network");
        if (localJSONObject2 != null)
        {
          locala.rbI = ak.q(localJSONObject2.optJSONArray("RequestDomain"));
          locala.rbJ = ak.q(localJSONObject2.optJSONArray("WsRequestDomain"));
          locala.rbK = ak.q(localJSONObject2.optJSONArray("UploadDomain"));
          locala.rbL = ak.q(localJSONObject2.optJSONArray("DownloadDomain"));
          locala.rbM = ak.q(localJSONObject2.optJSONArray("UDPDomain"));
          locala.rbN = ak.q(localJSONObject2.optJSONArray("TCPDomain"));
        }
        locala.appId = localJSONObject1.optString("Appid");
        locala.rbH = localJSONObject1.optInt("WechatPluginApp", 0);
        locala.serviceType = localJSONObject1.optInt("AppServiceType", 0);
        locala.rbO = localJSONObject1.optString("fromBusinessUsername");
        locala.originalFlag = localJSONObject1.optInt("OriginalFlag", 0);
        locala.qXZ = localJSONObject1.optString("OriginalRedirectUrl");
        locala.nOX = localJSONObject1.optInt("ShowRelievedBuyFlag", 0);
        locala.qYa = localJSONObject1.optInt("AgeAppropriateLevel", 0);
        locala.qZg = localJSONObject1.optInt("SystemAuthBizScene", 0);
        locala.qZh = localJSONObject1.optInt("SystemAuthFrequencyLimitFlag", 0);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaAppInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        paramString = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[] { paramString, localException });
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaAppInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
          paramString = null;
        }
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaAppInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        AppMethodBeat.o(123490);
      }
      AppMethodBeat.o(123490);
      return paramString;
    }
    
    public final boolean aqJ()
    {
      return this.serviceType == 4;
    }
    
    public final boolean clj()
    {
      return (this.rbH > 0) || (this.serviceType == 7);
    }
  }
  
  public static final class b
  {
    public int hda;
    public List<WxaAttributes.b.a> rbP;
    public int type;
  }
  
  public static final class c
  {
    public a rbR;
    public List<Pair<String, String>> rbS;
    
    public c()
    {
      AppMethodBeat.i(123491);
      this.rbR = new a();
      AppMethodBeat.o(123491);
    }
    
    public static final class a
    {
      public int epG;
      public int epH;
      public int epI;
      public int epJ;
      public int epK;
      public int epL;
      public boolean epM;
      public boolean epN;
      public boolean eqa;
      public int eqc;
      public boolean qRE;
      public boolean qRF;
      public int qRG;
      public int qRH;
      public int qYQ;
      public boolean qYR;
      public int qYW;
      public int qYX;
      public int qYr;
      public int rbT;
      public int rbU;
      public int rbV;
      public int rbW;
      public int rbX;
      public int rbY;
      public int rbZ;
      public boolean rca;
      public long rcb;
      public long rcc;
      public long rcd;
      public long rce;
      public byte[] rcf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes
 * JD-Core Version:    0.7.0.1
 */