package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.al;
import com.tencent.mm.plugin.game.protobuf.ap;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.bj;
import com.tencent.mm.plugin.game.protobuf.d;
import com.tencent.mm.plugin.game.protobuf.do;
import com.tencent.mm.plugin.game.protobuf.ea;
import com.tencent.mm.plugin.game.protobuf.es;
import com.tencent.mm.plugin.game.protobuf.et;
import com.tencent.mm.plugin.game.protobuf.l;
import com.tencent.mm.plugin.game.protobuf.r;
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
  public static GetGameCenterGlobalSettingResponse IsN;
  
  public static String fDP()
  {
    AppMethodBeat.i(275335);
    String str = c.fEg() + "globalconfig";
    AppMethodBeat.o(275335);
    return str;
  }
  
  /* Error */
  public static void fDQ()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 45
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 47	com/tencent/mm/plugin/game/commlib/a:IsN	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   11: ifnull +12 -> 23
    //   14: ldc 45
    //   16: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   26: lstore_0
    //   27: new 55	com/tencent/mm/vfs/u
    //   30: dup
    //   31: invokestatic 57	com/tencent/mm/plugin/game/commlib/a:fDP	()Ljava/lang/String;
    //   34: invokespecial 60	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: new 62	com/tencent/mm/vfs/x
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 65	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 68	com/tencent/mm/vfs/u:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_3
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 72	com/tencent/mm/vfs/x:read	([B)I
    //   60: pop
    //   61: new 74	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse
    //   64: dup
    //   65: invokespecial 75	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: putstatic 47	com/tencent/mm/plugin/game/commlib/a:IsN	Lcom/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse;
    //   75: aload 4
    //   77: aload_3
    //   78: invokevirtual 79	com/tencent/mm/plugin/game/protobuf/GetGameCenterGlobalSettingResponse:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   81: pop
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 82	com/tencent/mm/vfs/x:close	()V
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
    //   46	41	2	localx	com.tencent.mm.vfs.x
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
  
  public static ap fDR()
  {
    AppMethodBeat.i(149392);
    Object localObject = null;
    if (IsN != null)
    {
      ap localap = IsN.GameDetailSetting;
      localObject = localap;
      if (localap != null)
      {
        Log.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localap.IHl), localap.IGI });
        localObject = localap;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149392);
      return localObject;
      fDQ();
    }
  }
  
  public static ea fDS()
  {
    AppMethodBeat.i(149393);
    if (IsN != null)
    {
      if (IsN.StatusBarStyle != null) {
        Log.i("MicroMsg.GameConfigManager", "getStatusBarStyle color:%s, darkModeColor:%s, style:%s", new Object[] { IsN.StatusBarStyle.nRQ, IsN.StatusBarStyle.ILO, IsN.StatusBarStyle.IFK });
      }
      ea localea = IsN.StatusBarStyle;
      AppMethodBeat.o(149393);
      return localea;
    }
    fDQ();
    AppMethodBeat.o(149393);
    return null;
  }
  
  public static boolean fDT()
  {
    AppMethodBeat.i(149394);
    if (IsN != null)
    {
      if (IsN.WepkgControl != null)
      {
        boolean bool = IsN.WepkgControl.IMl;
        AppMethodBeat.o(149394);
        return bool;
      }
    }
    else {
      fDQ();
    }
    AppMethodBeat.o(149394);
    return false;
  }
  
  public static List<String> fDU()
  {
    AppMethodBeat.i(149397);
    if (IsN != null)
    {
      if (IsN.WepkgControl != null)
      {
        Object localObject = IsN.WepkgControl.IMn;
        if (!Util.isNullOrNil((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            do localdo = (do)((Iterator)localObject).next();
            if ((localdo != null) && (!Util.isNullOrNil(localdo.IHV))) {
              localArrayList.add(localdo.IHV);
            }
          }
          AppMethodBeat.o(149397);
          return localArrayList;
        }
      }
    }
    else {
      fDQ();
    }
    AppMethodBeat.o(149397);
    return null;
  }
  
  public static int fDV()
  {
    AppMethodBeat.i(149398);
    if (IsN != null)
    {
      if (IsN.WebViewControl != null)
      {
        int i = IsN.WebViewControl.IMk;
        AppMethodBeat.o(149398);
        return i;
      }
      AppMethodBeat.o(149398);
      return 3600;
    }
    fDQ();
    AppMethodBeat.o(149398);
    return 3600;
  }
  
  public static bd fDW()
  {
    AppMethodBeat.i(275357);
    if (IsN != null)
    {
      if (IsN.GameLifeSetting != null)
      {
        bd localbd = IsN.GameLifeSetting;
        AppMethodBeat.o(275357);
        return localbd;
      }
    }
    else {
      fDQ();
    }
    AppMethodBeat.o(275357);
    return null;
  }
  
  public static l fDX()
  {
    AppMethodBeat.i(275361);
    if (IsN != null)
    {
      if (IsN.GameLifeSetting != null)
      {
        l locall = IsN.GameLifeSetting.IJt;
        AppMethodBeat.o(275361);
        return locall;
      }
    }
    else {
      fDQ();
    }
    AppMethodBeat.o(275361);
    return null;
  }
  
  public static r fDY()
  {
    AppMethodBeat.i(275365);
    if (IsN != null)
    {
      if (IsN.GameLifeSetting != null)
      {
        r localr = IsN.GameLifeSetting.IJv;
        AppMethodBeat.o(275365);
        return localr;
      }
    }
    else {
      fDQ();
    }
    AppMethodBeat.o(275365);
    return null;
  }
  
  public static bj fDZ()
  {
    AppMethodBeat.i(275371);
    if (IsN != null)
    {
      bj localbj = IsN.GeneralJumpInfo;
      AppMethodBeat.o(275371);
      return localbj;
    }
    fDQ();
    AppMethodBeat.o(275371);
    return null;
  }
  
  public static JSONArray fEa()
  {
    AppMethodBeat.i(275378);
    JSONArray localJSONArray = new JSONArray();
    Object localObject;
    if (IsN != null) {
      localObject = IsN.GameCommunityInfo;
    }
    for (;;)
    {
      label46:
      d locald;
      JSONObject localJSONObject;
      if ((localObject != null) && (((al)localObject).IIz != null))
      {
        localObject = ((al)localObject).IIz.iterator();
        if (((Iterator)localObject).hasNext())
        {
          locald = (d)((Iterator)localObject).next();
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("appId", locald.oOI);
        localJSONObject.put("gameName", locald.IGM);
        localJSONObject.put("albumName", locald.IGN);
        localJSONObject.put("defaultTitle", locald.IGO);
        label121:
        localJSONArray.put(localJSONObject);
        break label46;
        fDQ();
        localObject = null;
        continue;
        AppMethodBeat.o(275378);
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