package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.aa;
import com.tencent.mm.plugin.game.protobuf.ak;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.plugin.game.protobuf.bi;
import com.tencent.mm.plugin.game.protobuf.d;
import com.tencent.mm.plugin.game.protobuf.dk;
import com.tencent.mm.plugin.game.protobuf.dw;
import com.tencent.mm.plugin.game.protobuf.en;
import com.tencent.mm.plugin.game.protobuf.eo;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.game.protobuf.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static GetGameCenterGlobalSettingResponse Czb;
  
  public static String evZ()
  {
    AppMethodBeat.i(207084);
    String str = c.ewp() + "globalconfig";
    AppMethodBeat.o(207084);
    return str;
  }
  
  /* Error */
  public static void ewa()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 45
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 47	com/tencent/mm/plugin/game/commlib/a:Czb	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   11: ifnull +12 -> 23
    //   14: ldc 45
    //   16: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   26: lstore_0
    //   27: new 55	com/tencent/mm/vfs/q
    //   30: dup
    //   31: invokestatic 57	com/tencent/mm/plugin/game/commlib/a:evZ	()Ljava/lang/String;
    //   34: invokespecial 60	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: new 62	com/tencent/mm/vfs/t
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 65	com/tencent/mm/vfs/t:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 68	com/tencent/mm/vfs/q:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_3
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 72	com/tencent/mm/vfs/t:read	([B)I
    //   60: pop
    //   61: new 74	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse
    //   64: dup
    //   65: invokespecial 75	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: putstatic 47	com/tencent/mm/plugin/game/commlib/a:Czb	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   75: aload 4
    //   77: aload_3
    //   78: invokevirtual 79	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   81: pop
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 82	com/tencent/mm/vfs/t:close	()V
    //   90: ldc 84
    //   92: new 17	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 86
    //   98: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   104: lload_0
    //   105: lsub
    //   106: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 45
    //   117: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -101 -> 19
    //   123: astore_2
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: ldc 84
    //   134: new 17	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 97
    //   140: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -74 -> 82
    //   159: astore_2
    //   160: goto -70 -> 90
    //   163: astore_3
    //   164: goto -32 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	79	0	l	long
    //   46	41	2	localt	com.tencent.mm.vfs.t
    //   123	5	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   159	1	2	localIOException	java.io.IOException
    //   37	41	3	localObject3	Object
    //   129	15	3	localException1	java.lang.Exception
    //   163	1	3	localException2	java.lang.Exception
    //   68	8	4	localGetGameCenterGlobalSettingResponse	GetGameCenterGlobalSettingResponse
    // Exception table:
    //   from	to	target	type
    //   3	19	123	finally
    //   23	27	123	finally
    //   27	47	123	finally
    //   47	82	123	finally
    //   86	90	123	finally
    //   90	120	123	finally
    //   132	156	123	finally
    //   27	47	129	java/lang/Exception
    //   86	90	159	java/io/IOException
    //   47	82	163	java/lang/Exception
  }
  
  public static ao ewb()
  {
    AppMethodBeat.i(149392);
    Object localObject = null;
    if (Czb != null)
    {
      ao localao = Czb.GameDetailSetting;
      localObject = localao;
      if (localao != null)
      {
        Log.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localao.CNg), localao.CMD });
        localObject = localao;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149392);
      return localObject;
      ewa();
    }
  }
  
  public static dw ewc()
  {
    AppMethodBeat.i(149393);
    if (Czb != null)
    {
      if (Czb.StatusBarStyle != null) {
        Log.i("MicroMsg.GameConfigManager", "getStatusBarStyle color:%s, darkModeColor:%s, style:%s", new Object[] { Czb.StatusBarStyle.lmL, Czb.StatusBarStyle.CRy, Czb.StatusBarStyle.CLD });
      }
      dw localdw = Czb.StatusBarStyle;
      AppMethodBeat.o(149393);
      return localdw;
    }
    ewa();
    AppMethodBeat.o(149393);
    return null;
  }
  
  public static boolean ewd()
  {
    AppMethodBeat.i(149394);
    if (Czb != null)
    {
      if (Czb.WepkgControl != null)
      {
        boolean bool = Czb.WepkgControl.CRV;
        AppMethodBeat.o(149394);
        return bool;
      }
    }
    else {
      ewa();
    }
    AppMethodBeat.o(149394);
    return false;
  }
  
  public static List<String> ewe()
  {
    AppMethodBeat.i(149397);
    if (Czb != null)
    {
      if (Czb.WepkgControl != null)
      {
        Object localObject = Czb.WepkgControl.CRX;
        if (!Util.isNullOrNil((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            dk localdk = (dk)((Iterator)localObject).next();
            if ((localdk != null) && (!Util.isNullOrNil(localdk.CNL))) {
              localArrayList.add(localdk.CNL);
            }
          }
          AppMethodBeat.o(149397);
          return localArrayList;
        }
      }
    }
    else {
      ewa();
    }
    AppMethodBeat.o(149397);
    return null;
  }
  
  public static int ewf()
  {
    AppMethodBeat.i(149398);
    if (Czb != null)
    {
      if (Czb.WebViewControl != null)
      {
        int i = Czb.WebViewControl.CRU;
        AppMethodBeat.o(149398);
        return i;
      }
      AppMethodBeat.o(149398);
      return 3600;
    }
    ewa();
    AppMethodBeat.o(149398);
    return 3600;
  }
  
  public static bc ewg()
  {
    AppMethodBeat.i(207091);
    if (Czb != null)
    {
      if (Czb.GameLifeSetting != null)
      {
        bc localbc = Czb.GameLifeSetting;
        AppMethodBeat.o(207091);
        return localbc;
      }
    }
    else {
      ewa();
    }
    AppMethodBeat.o(207091);
    return null;
  }
  
  public static k ewh()
  {
    AppMethodBeat.i(207092);
    if (Czb != null)
    {
      if (Czb.GameLifeSetting != null)
      {
        k localk = Czb.GameLifeSetting.CPj;
        AppMethodBeat.o(207092);
        return localk;
      }
    }
    else {
      ewa();
    }
    AppMethodBeat.o(207092);
    return null;
  }
  
  public static aa ewi()
  {
    AppMethodBeat.i(207093);
    if (Czb != null)
    {
      if (Czb.GameLifeSetting != null)
      {
        aa localaa = Czb.GameLifeSetting.CPk;
        AppMethodBeat.o(207093);
        return localaa;
      }
    }
    else {
      ewa();
    }
    AppMethodBeat.o(207093);
    return null;
  }
  
  public static q ewj()
  {
    AppMethodBeat.i(207095);
    if (Czb != null)
    {
      if (Czb.GameLifeSetting != null)
      {
        q localq = Czb.GameLifeSetting.CPl;
        AppMethodBeat.o(207095);
        return localq;
      }
    }
    else {
      ewa();
    }
    AppMethodBeat.o(207095);
    return null;
  }
  
  public static bi ewk()
  {
    AppMethodBeat.i(207096);
    if (Czb != null)
    {
      bi localbi = Czb.GeneralJumpInfo;
      AppMethodBeat.o(207096);
      return localbi;
    }
    ewa();
    AppMethodBeat.o(207096);
    return null;
  }
  
  public static JSONArray ewl()
  {
    AppMethodBeat.i(207098);
    JSONArray localJSONArray = new JSONArray();
    Object localObject;
    if (Czb != null) {
      localObject = Czb.GameCommunityInfo;
    }
    for (;;)
    {
      label46:
      d locald;
      JSONObject localJSONObject;
      if ((localObject != null) && (((ak)localObject).COp != null))
      {
        localObject = ((ak)localObject).COp.iterator();
        if (((Iterator)localObject).hasNext())
        {
          locald = (d)((Iterator)localObject).next();
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("appId", locald.lVG);
        localJSONObject.put("gameName", locald.CMH);
        localJSONObject.put("albumName", locald.CMI);
        localJSONObject.put("defaultTitle", locald.CMJ);
        label121:
        localJSONArray.put(localJSONObject);
        break label46;
        ewa();
        localObject = null;
        continue;
        AppMethodBeat.o(207098);
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        break label121;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.a
 * JD-Core Version:    0.7.0.1
 */