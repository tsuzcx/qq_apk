package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dl.a;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.flutter.a.a.a
  implements com.tencent.mm.al.f
{
  private com.tencent.mm.sdk.b.c<hu> pEA;
  private byte[] pEs;
  private byte[] pEt;
  private b pEu;
  private b pEv;
  private a pEw;
  private c pEx;
  public Map<String, Boolean> pEy;
  private com.tencent.mm.sdk.b.c<dl> pEz;
  
  public h()
  {
    AppMethodBeat.i(108599);
    this.pEy = new HashMap();
    this.pEz = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(dl paramAnonymousdl)
      {
        AppMethodBeat.i(108596);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Flutter.FlutterEmoticonMethodChannelLogic", "EmotionStateChange %s %d %d", new Object[] { paramAnonymousdl.doj.dok, Integer.valueOf(paramAnonymousdl.doj.progress), Integer.valueOf(paramAnonymousdl.doj.status) });
        com.tencent.mm.flutter.a.b.b localb;
        String str;
        int i;
        int j;
        JSONObject localJSONObject;
        if (h.this.pEy.containsKey(paramAnonymousdl.doj.dok))
        {
          localb = (com.tencent.mm.flutter.a.b.b)((com.tencent.mm.plugin.flutter.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.flutter.a.a.class)).aO(com.tencent.mm.flutter.a.b.b.class);
          str = paramAnonymousdl.doj.dok;
          i = paramAnonymousdl.doj.status;
          j = paramAnonymousdl.doj.progress;
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("productId", str);
          localJSONObject.put("status", i);
          localJSONObject.put("progress", j);
          label156:
          localb.e("onEmoticonDownloadCallback", localJSONObject.toString());
          if (paramAnonymousdl.doj.progress >= 100) {
            h.this.pEy.remove(paramAnonymousdl.doj.dok);
          }
          AppMethodBeat.o(108596);
          return false;
        }
        catch (Exception localException)
        {
          break label156;
        }
      }
    };
    this.pEA = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(108599);
  }
  
  private static LinkedList<Object> X(LinkedList paramLinkedList)
  {
    AppMethodBeat.i(108627);
    if (paramLinkedList.size() > 0) {}
    for (Object localObject1 = paramLinkedList.get(0);; localObject1 = null)
    {
      if ((localObject1.getClass().isPrimitive()) || ((localObject1 instanceof String)))
      {
        AppMethodBeat.o(108627);
        return paramLinkedList;
      }
      if ((localObject1 instanceof cwt))
      {
        localObject1 = new LinkedList();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext()) {
          ((LinkedList)localObject1).add(paramLinkedList.next().toString());
        }
        AppMethodBeat.o(108627);
        return localObject1;
      }
      if ((localObject1 instanceof com.tencent.mm.bx.a))
      {
        localObject1 = new LinkedList();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          Object localObject2 = paramLinkedList.next();
          ((LinkedList)localObject1).add(b(localObject2, localObject2.getClass()));
        }
        AppMethodBeat.o(108627);
        return localObject1;
      }
      AppMethodBeat.o(108627);
      return null;
    }
  }
  
  /* Error */
  private static <T> T a(Map<String, Object> paramMap, Class<T> paramClass)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 141	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   9: astore_2
    //   10: aload_0
    //   11: invokeinterface 147 1 0
    //   16: invokeinterface 150 1 0
    //   21: astore_0
    //   22: aload_0
    //   23: invokeinterface 115 1 0
    //   28: ifeq +199 -> 227
    //   31: aload_0
    //   32: invokeinterface 119 1 0
    //   37: checkcast 152	java/util/Map$Entry
    //   40: astore 4
    //   42: aload_1
    //   43: aload 4
    //   45: invokeinterface 155 1 0
    //   50: checkcast 103	java/lang/String
    //   53: invokevirtual 159	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull -36 -> 22
    //   61: aload 4
    //   63: invokeinterface 162 1 0
    //   68: instanceof 143
    //   71: ifeq +28 -> 99
    //   74: aload_3
    //   75: aload_2
    //   76: aload 4
    //   78: invokeinterface 162 1 0
    //   83: checkcast 143	java/util/Map
    //   86: aload_3
    //   87: invokevirtual 167	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   90: invokestatic 169	com/tencent/mm/plugin/emoji/model/h:a	(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;
    //   93: invokevirtual 173	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -74 -> 22
    //   99: aload 4
    //   101: invokeinterface 162 1 0
    //   106: instanceof 175
    //   109: ifeq +103 -> 212
    //   112: aload 4
    //   114: invokeinterface 162 1 0
    //   119: checkcast 175	java/util/List
    //   122: astore 4
    //   124: new 81	java/util/LinkedList
    //   127: dup
    //   128: invokespecial 106	java/util/LinkedList:<init>	()V
    //   131: astore 5
    //   133: aload 4
    //   135: invokeinterface 176 1 0
    //   140: astore 6
    //   142: aload 6
    //   144: invokeinterface 115 1 0
    //   149: ifeq +53 -> 202
    //   152: aload 6
    //   154: invokeinterface 119 1 0
    //   159: astore 7
    //   161: aload 7
    //   163: instanceof 143
    //   166: ifeq +25 -> 191
    //   169: aload 5
    //   171: aload 7
    //   173: checkcast 143	java/util/Map
    //   176: aload 7
    //   178: invokevirtual 95	java/lang/Object:getClass	()Ljava/lang/Class;
    //   181: invokestatic 169	com/tencent/mm/plugin/emoji/model/h:a	(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;
    //   184: invokevirtual 127	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: goto -46 -> 142
    //   191: aload 5
    //   193: aload 7
    //   195: invokevirtual 127	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   198: pop
    //   199: goto -57 -> 142
    //   202: aload_3
    //   203: aload_2
    //   204: aload 4
    //   206: invokevirtual 173	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   209: goto -187 -> 22
    //   212: aload_3
    //   213: aload_2
    //   214: aload 4
    //   216: invokeinterface 162 1 0
    //   221: invokevirtual 173	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   224: goto -202 -> 22
    //   227: ldc 138
    //   229: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_2
    //   233: areturn
    //   234: astore_0
    //   235: ldc 138
    //   237: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_3
    //   243: goto -221 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramMap	Map<String, Object>
    //   0	246	1	paramClass	Class<T>
    //   9	224	2	localObject1	Object
    //   56	157	3	localField	Field
    //   242	1	3	localException	Exception
    //   40	175	4	localObject2	Object
    //   131	61	5	localLinkedList	LinkedList
    //   140	13	6	localIterator	Iterator
    //   159	35	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	22	234	java/lang/Exception
    //   22	42	234	java/lang/Exception
    //   42	57	242	java/lang/Exception
    //   61	96	242	java/lang/Exception
    //   99	142	242	java/lang/Exception
    //   142	188	242	java/lang/Exception
    //   191	199	242	java/lang/Exception
    //   202	209	242	java/lang/Exception
    //   212	224	242	java/lang/Exception
  }
  
  private static JSONObject a(GetEmotionDetailResponse paramGetEmotionDetailResponse)
  {
    AppMethodBeat.i(108623);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(paramGetEmotionDetailResponse.EmotionDetail, localJSONObject);
      label21:
      AppMethodBeat.o(108623);
      return localJSONObject;
    }
    catch (Exception paramGetEmotionDetailResponse)
    {
      break label21;
    }
  }
  
  private static JSONObject a(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(108624);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(paramGetEmotionListResponse, localJSONObject);
      label18:
      AppMethodBeat.o(108624);
      return localJSONObject;
    }
    catch (Exception paramGetEmotionListResponse)
    {
      break label18;
    }
  }
  
  private static JSONObject a(GetEmotionRewardResponse paramGetEmotionRewardResponse)
  {
    AppMethodBeat.i(108622);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(paramGetEmotionRewardResponse, localJSONObject);
      label18:
      AppMethodBeat.o(108622);
      return localJSONObject;
    }
    catch (Exception paramGetEmotionRewardResponse)
    {
      break label18;
    }
  }
  
  private static void a(d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108620);
    try
    {
      paramJSONObject.put("finish", 1);
      label13:
      paramd.cgL().result = paramJSONObject.toString();
      paramd.cgL().callback.run();
      AppMethodBeat.o(108620);
      return;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  private static void a(Object paramObject, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108628);
    a(b(paramObject, paramObject.getClass()), paramJSONObject);
    AppMethodBeat.o(108628);
  }
  
  private static void a(LinkedList<? extends Object> paramLinkedList, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(108630);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = paramLinkedList.next();
      Object localObject2;
      if ((localObject1 instanceof LinkedList))
      {
        localObject2 = new JSONArray();
        a((LinkedList)localObject1, (JSONArray)localObject2);
        paramJSONArray.put(localObject2);
      }
      else if ((localObject1 instanceof Map))
      {
        localObject2 = new JSONObject();
        a((Map)localObject1, (JSONObject)localObject2);
        paramJSONArray.put(localObject2);
      }
      else
      {
        paramJSONArray.put(localObject1);
      }
    }
    AppMethodBeat.o(108630);
  }
  
  private static void a(Map<String, ? extends Object> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108629);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject;
      if ((localEntry.getValue() instanceof Map))
      {
        localObject = new JSONObject();
        a((Map)localEntry.getValue(), (JSONObject)localObject);
        paramJSONObject.put((String)localEntry.getKey(), localObject);
      }
      else if ((localEntry.getValue() instanceof LinkedList))
      {
        localObject = new JSONArray();
        a((LinkedList)localEntry.getValue(), (JSONArray)localObject);
        paramJSONObject.put((String)localEntry.getKey(), localObject);
      }
      else
      {
        paramJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(108629);
  }
  
  private static HashMap<String, Object> b(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(108626);
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getFields();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < j) {
        localObject1 = paramClass[i];
      }
      try
      {
        Object localObject2 = localObject1.get(paramObject);
        if (localObject2 == null) {
          break label170;
        }
        if ((localObject1.getType().isPrimitive()) || ((localObject2 instanceof String)))
        {
          localHashMap.put(localObject1.getName(), localObject2);
        }
        else if ((localObject2 instanceof com.tencent.mm.bx.a))
        {
          localObject2 = b(localObject2, localObject1.getType());
          localHashMap.put(localObject1.getName(), localObject2);
        }
        else if ((localObject2 instanceof LinkedList))
        {
          localObject2 = X((LinkedList)localObject2);
          if (localObject2 != null) {
            localHashMap.put(localObject1.getName(), localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        label170:
        break label170;
      }
      AppMethodBeat.o(108626);
      return localHashMap;
      i += 1;
    }
  }
  
  private static void b(d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108621);
    if (paramJSONObject != null) {}
    for (paramd.cgL().result = paramJSONObject.toString();; paramd.cgL().result = null)
    {
      paramd.cgL().callback.run();
      AppMethodBeat.o(108621);
      return;
    }
  }
  
  public final void a(final int paramInt, final com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108616);
    ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.i.class)).a(aj.getContext(), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108592);
        Intent localIntent = com.tencent.mm.plugin.websearch.api.ad.eMd();
        com.tencent.mm.plugin.websearch.api.ad.b(localIntent, 24);
        localIntent.putExtra("ftsneedkeyboard", true);
        localIntent.putExtra("key_load_js_without_delay", true);
        localIntent.putExtra("ftsInitToSearch", true);
        com.tencent.mm.bs.d.b(paramc.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
        com.tencent.mm.plugin.report.service.g.yhR.f(13054, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), "" });
        AppMethodBeat.o(108592);
      }
    });
    paramc.result = "{}";
    paramc.callback.run();
    AppMethodBeat.o(108616);
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108607);
    if (this.pEw != null)
    {
      com.tencent.mm.kernel.g.aiU().b(412, this);
      com.tencent.mm.kernel.g.aiU().a(this.pEw);
    }
    this.pEw = new a(paramString, paramInt);
    this.pEw.pEF = paramc;
    com.tencent.mm.kernel.g.aiU().a(412, this);
    com.tencent.mm.kernel.g.aiU().a(this.pEw, 0);
    AppMethodBeat.o(108607);
  }
  
  public final void a(String paramString, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108606);
    if (this.pEx != null)
    {
      com.tencent.mm.kernel.g.aiU().b(822, this);
      com.tencent.mm.kernel.g.aiU().a(this.pEx);
    }
    this.pEx = new c(paramString, o.pGg);
    this.pEx.pEF = paramc;
    com.tencent.mm.kernel.g.aiU().a(822, this);
    com.tencent.mm.kernel.g.aiU().a(this.pEx, 0);
    AppMethodBeat.o(108606);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108611);
    this.pEz.alive();
    this.pEy.put(paramString1, Boolean.TRUE);
    paramString1 = new com.tencent.mm.plugin.emoji.f.g(paramString1, null, paramString2);
    long l = System.currentTimeMillis();
    paramString2 = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    paramString2 = com.tencent.mm.ao.c.a("downzip", l, com.tencent.mm.kernel.a.getUin(), "emoji");
    paramString1.pFL = true;
    paramString1.ibe = paramString2;
    com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
    paramc.result = paramString2;
    paramc.callback.run();
    AppMethodBeat.o(108611);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(108608);
    paramString2 = new com.tencent.mm.plugin.emoji.f.g(paramString1, paramString2, paramString3);
    if (com.tencent.mm.plugin.emoji.h.a.ach(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Flutter.FlutterEmoticonMethodChannelLogic", "stop tuzi downloading");
      com.tencent.mm.plugin.emoji.f.a.cgX().cgZ();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString4))
      {
        com.tencent.mm.ao.f.aGI().EQ(paramString4);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Flutter.FlutterEmoticonMethodChannelLogic", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { paramString4 });
      }
      k.cgV().h(paramString1, paramInt, 0, paramString4);
      paramString1 = new com.tencent.mm.plugin.emoji.f.q(paramString1, 2);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramString1, 0);
      AppMethodBeat.o(108608);
      return;
      com.tencent.mm.kernel.g.ajB().gAO.a(paramString2);
      if (this.pEy.containsKey(paramString1)) {
        this.pEy.remove(paramString1);
      }
    }
  }
  
  public final void a(final String paramString, final Map<String, Object> paramMap, final com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108618);
    Object localObject = (PackThumbExt)a(paramMap, PackThumbExt.class);
    paramMap = new EmojiInfo();
    paramMap.field_md5 = ((PackThumbExt)localObject).Md5;
    paramMap.field_thumbUrl = ((PackThumbExt)localObject).ThumbUrl;
    paramMap.field_cdnUrl = ((PackThumbExt)localObject).CDNUrl;
    paramMap.field_aeskey = ((PackThumbExt)localObject).AesKey;
    paramMap.field_encrypturl = ((PackThumbExt)localObject).EncryptUrl;
    paramMap.field_externUrl = ((PackThumbExt)localObject).ExternUrl;
    paramMap.field_externMd5 = ((PackThumbExt)localObject).ExternMd5;
    paramMap.field_activityid = ((PackThumbExt)localObject).ActivityID;
    paramMap.field_groupId = paramString;
    paramMap.field_catalog = 84;
    paramMap.field_reserved4 |= EmojiInfo.Ofi;
    paramString = new com.tencent.mm.vfs.e(aj.getContext().getCacheDir(), ((PackThumbExt)localObject).Md5);
    if (!paramString.exists())
    {
      if (paramMap.fOu())
      {
        paramMap = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().s(paramMap);
        com.tencent.mm.vfs.i.e(com.tencent.mm.vfs.q.B(paramString.fOK()), paramMap, paramMap.length);
      }
    }
    else
    {
      paramc.result = com.tencent.mm.vfs.q.B(paramString.fOK());
      paramc.callback.run();
      AppMethodBeat.o(108618);
      return;
    }
    localObject = com.tencent.mm.emoji.loader.e.giz;
    com.tencent.mm.emoji.loader.e.a(paramMap, new i.a()
    {
      public final void dg(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108595);
        if (paramAnonymousBoolean)
        {
          byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().s(paramMap);
          com.tencent.mm.vfs.i.e(com.tencent.mm.vfs.q.B(paramString.fOK()), arrayOfByte, arrayOfByte.length);
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(108593);
              h.2.this.pEB.result = com.tencent.mm.vfs.q.B(h.2.this.pED.fOK());
              h.2.this.pEB.callback.run();
              AppMethodBeat.o(108593);
            }
          });
          AppMethodBeat.o(108595);
          return;
        }
        com.tencent.e.h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108594);
            h.2.this.pEB.result = "";
            h.2.this.pEB.callback.run();
            AppMethodBeat.o(108594);
          }
        });
        AppMethodBeat.o(108595);
      }
    });
    AppMethodBeat.o(108618);
  }
  
  public final void a(Map<String, Object> paramMap, String paramString, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108617);
    paramMap = (EmotionDetail)a(paramMap, EmotionDetail.class);
    if (paramMap != null) {
      j.a((MMActivity)paramc.context, paramString, paramMap.ProductID, paramMap.PackName, paramMap.PackDesc, paramMap.IconUrl, paramMap.OldRedirectUrl, paramMap.PackFlag);
    }
    AppMethodBeat.o(108617);
  }
  
  public final void b(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108602);
    if (this.pEu != null)
    {
      com.tencent.mm.kernel.g.aiU().b(411, this);
      com.tencent.mm.kernel.g.aiU().a(this.pEu);
    }
    this.pEu = new b(5, this.pEs);
    this.pEu.pEF = paramc;
    com.tencent.mm.kernel.g.aiU().a(411, this);
    com.tencent.mm.kernel.g.aiU().a(this.pEu, 0);
    AppMethodBeat.o(108602);
  }
  
  public final void b(String paramString, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108612);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Flutter.FlutterEmoticonMethodChannelLogic", "checkLocalEmotionData");
    if ((com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) && (k.getEmojiStorageMgr().ILo.aUC(paramString)))
    {
      if (k.getEmojiStorageMgr().ILn.aUE(paramString) <= 0) {
        break label174;
      }
      Object localObject = new StringBuilder();
      com.tencent.mm.emoji.d.a locala = com.tencent.mm.emoji.d.a.gqn;
      localObject = new com.tencent.mm.vfs.e(com.tencent.mm.emoji.d.a.agp() + paramString);
      if (((com.tencent.mm.vfs.e)localObject).exists())
      {
        localObject = ((com.tencent.mm.vfs.e)localObject).fOM();
        if ((localObject != null) && (localObject.length > 0))
        {
          paramc.result = Boolean.TRUE;
          paramc.callback.run();
          AppMethodBeat.o(108612);
          return;
        }
        k.getEmojiStorageMgr().ILo.aUD(paramString);
        k.getEmojiStorageMgr().ILn.aUO(paramString);
      }
    }
    for (;;)
    {
      paramc.result = Boolean.FALSE;
      paramc.callback.run();
      AppMethodBeat.o(108612);
      return;
      label174:
      k.getEmojiStorageMgr().ILn.aUO(paramString);
    }
  }
  
  public final void c(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108603);
    Map localMap = k.cgV().pEh;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(localMap, localJSONObject);
      label26:
      paramc.result = localJSONObject.toString();
      paramc.callback.run();
      AppMethodBeat.o(108603);
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public final void create()
  {
    AppMethodBeat.i(108600);
    super.create();
    this.pEA.alive();
    AppMethodBeat.o(108600);
  }
  
  public final void d(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108604);
    Object localObject = k.getEmojiStorageMgr().ILo.fsV();
    JSONObject localJSONObject1 = new JSONObject();
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        a(localEntry.getValue(), localJSONObject2);
        localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
      }
      catch (Exception localException) {}
    }
    paramc.result = localJSONObject1.toString();
    paramc.callback.run();
    AppMethodBeat.o(108604);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(108601);
    super.destroy();
    this.pEA.dead();
    this.pEz.dead();
    AppMethodBeat.o(108601);
  }
  
  public final void e(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108605);
    if (this.pEv != null)
    {
      com.tencent.mm.kernel.g.aiU().b(411, this);
      com.tencent.mm.kernel.g.aiU().a(this.pEv);
    }
    this.pEv = new b(9, this.pEt);
    this.pEv.pEF = paramc;
    com.tencent.mm.kernel.g.aiU().a(411, this);
    com.tencent.mm.kernel.g.aiU().a(this.pEv, 0);
    AppMethodBeat.o(108605);
  }
  
  public final void f(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108609);
    this.pEs = null;
    GetEmotionListResponse localGetEmotionListResponse = k.getEmojiStorageMgr().ILq.abh(5);
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList.size() > 0) && (localGetEmotionListResponse.BannerSetList.size() > 0))
    {
      paramc.result = a(localGetEmotionListResponse).toString();
      paramc.callback.run();
      AppMethodBeat.o(108609);
      return;
    }
    paramc.result = null;
    paramc.callback.run();
    AppMethodBeat.o(108609);
  }
  
  public final void g(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108610);
    this.pEt = null;
    GetEmotionListResponse localGetEmotionListResponse = k.getEmojiStorageMgr().ILq.abh(9);
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList.size() > 0) && (localGetEmotionListResponse.BannerSetList.size() > 0))
    {
      paramc.result = a(localGetEmotionListResponse).toString();
      paramc.callback.run();
      AppMethodBeat.o(108610);
      return;
    }
    paramc.result = null;
    paramc.callback.run();
    AppMethodBeat.o(108610);
  }
  
  public final void h(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108613);
    paramc.result = (aj.getContext().getString(2131758243) + ac.fks());
    paramc.callback.run();
    AppMethodBeat.o(108613);
  }
  
  public final void i(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108614);
    paramc.result = (aj.getContext().getString(2131758289) + ac.fks());
    paramc.callback.run();
    AppMethodBeat.o(108614);
  }
  
  public final void j(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(108615);
    String str = y.AH("emoje_stroe");
    y.aBq().F(str, true).k("prePublishId", "emoje_stroe");
    paramc.result = str;
    paramc.callback.run();
    AppMethodBeat.o(108615);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(108619);
    if ((paramn instanceof com.tencent.mm.plugin.emoji.f.n))
    {
      com.tencent.mm.kernel.g.aiU().b(411, this);
      if (!paramn.equals(this.pEu)) {
        break label191;
      }
      if ((paramInt1 != 0) && (paramInt1 != 4)) {
        break label180;
      }
      this.pEs = this.pEu.pGa;
      paramString = this.pEu.chj();
      if ((paramInt2 != 0) && (paramInt2 != 2)) {
        break label166;
      }
      if ((paramString == null) || (paramString.EmotionList.size() <= 0)) {
        break label152;
      }
      b(this.pEu, a(paramString));
    }
    for (;;)
    {
      this.pEu = null;
      AppMethodBeat.o(108619);
      return;
      if ((paramn instanceof l))
      {
        com.tencent.mm.kernel.g.aiU().b(412, this);
        break;
      }
      if (!(paramn instanceof o)) {
        break;
      }
      com.tencent.mm.kernel.g.aiU().b(822, this);
      break;
      label152:
      a(this.pEu, a(paramString));
      continue;
      label166:
      a(this.pEu, a(paramString));
      continue;
      label180:
      b(this.pEu, null);
    }
    label191:
    if (paramn.equals(this.pEv))
    {
      if ((paramInt1 == 0) || (paramInt1 == 4))
      {
        this.pEt = this.pEv.pGa;
        paramString = this.pEv.chj();
        if ((paramInt2 == 0) || (paramInt2 == 2)) {
          if ((paramString != null) && (paramString.EmotionList.size() > 0)) {
            b(this.pEv, a(paramString));
          }
        }
      }
      for (;;)
      {
        this.pEv = null;
        AppMethodBeat.o(108619);
        return;
        a(this.pEv, a(paramString));
        continue;
        a(this.pEv, a(paramString));
        continue;
        b(this.pEv, null);
      }
    }
    if (paramn.equals(this.pEw))
    {
      if (((paramInt1 == 0) && (paramInt2 == 0)) || ((paramInt1 == 4) && (paramInt2 == 5)))
      {
        paramString = this.pEw.chh();
        b(this.pEw, a(paramString));
      }
      for (;;)
      {
        this.pEw = null;
        AppMethodBeat.o(108619);
        return;
        b(this.pEw, null);
      }
    }
    if (paramn.equals(this.pEx))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label439;
      }
      paramString = this.pEx.chl();
      b(this.pEx, a(paramString));
    }
    for (;;)
    {
      this.pEx = null;
      AppMethodBeat.o(108619);
      return;
      label439:
      b(this.pEx, null);
    }
  }
  
  final class a
    extends l
    implements h.d
  {
    com.tencent.mm.flutter.c pEF;
    
    public a(String paramString, int paramInt)
    {
      super(5, paramInt);
    }
    
    public final com.tencent.mm.flutter.c cgL()
    {
      return this.pEF;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.emoji.f.n
    implements h.d
  {
    com.tencent.mm.flutter.c pEF;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      super(paramArrayOfByte, 2);
    }
    
    public final com.tencent.mm.flutter.c cgL()
    {
      return this.pEF;
    }
  }
  
  final class c
    extends o
    implements h.d
  {
    com.tencent.mm.flutter.c pEF;
    
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    public final com.tencent.mm.flutter.c cgL()
    {
      return this.pEF;
    }
  }
  
  static abstract interface d
  {
    public abstract com.tencent.mm.flutter.c cgL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h
 * JD-Core Version:    0.7.0.1
 */