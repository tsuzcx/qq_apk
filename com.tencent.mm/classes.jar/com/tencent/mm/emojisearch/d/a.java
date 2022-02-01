package com.tencent.mm.emojisearch.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emojisearch/report/EmojiSearchReport;", "", "()V", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_ICON", "", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_MORE", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_STORE", "EMOJI_SEARCH_ENTRANCE_KV_KEY", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEARCH_RESULT", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEND_EMOJI", "EMOJI_SEARCH_EXPOSE_KV_KEY", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_EDITTEXT_BRING", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_USER_INPUT", "chatId", "", "query", "querySource", "reportCount", "reportIndex", "reportMD5", "searchId", "sessionId", "enableReport", "", "start", "", "markClickSearchMore", "", "markClickSearchStore", "markSearchResultByEmojiInfo", "emojiInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "totalCount", "index", "markSearchResultByMd5", "md5List", "markSendEmoji", "md5", "position", "markShowEmojiSearchPanel", "plugin-emojisdk_release"})
public final class a
{
  private static String gVs;
  private static int gXY;
  private static String hes;
  private static int het;
  private static String heu;
  private static int hev;
  public static final a hew;
  private static String query;
  private static String sessionId;
  
  static
  {
    AppMethodBeat.i(200036);
    hew = new a();
    gVs = "";
    query = "";
    hes = "";
    sessionId = "";
    het = 1;
    heu = "";
    AppMethodBeat.o(200036);
  }
  
  public static void Fb(String paramString)
  {
    AppMethodBeat.i(200033);
    p.h(paramString, "chatId");
    hes = String.valueOf(System.currentTimeMillis());
    gVs = paramString;
    h.CyF.a(21160, new Object[] { hes, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(200033);
  }
  
  public static void R(String paramString, int paramInt)
  {
    AppMethodBeat.i(200032);
    p.h(paramString, "md5");
    h.CyF.a(21159, new Object[] { query, sessionId, hes, Integer.valueOf(2), paramString, Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(het), gVs, Integer.valueOf(hev) });
    AppMethodBeat.o(200032);
  }
  
  public static void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200030);
    p.h(paramString1, "query");
    p.h(paramString2, "sessionId");
    p.h(paramArrayList, "md5List");
    query = paramString1;
    sessionId = paramString2;
    het = paramInt2;
    gXY = paramInt1;
    hev = paramInt3;
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next()).append("#");
    }
    paramArrayList = localStringBuffer.toString();
    p.g(paramArrayList, "md5String.toString()");
    heu = paramArrayList;
    h.CyF.a(21159, new Object[] { paramString1, paramString2, hes, Integer.valueOf(1), heu, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), gVs, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(200030);
  }
  
  public static void awA()
  {
    AppMethodBeat.i(200035);
    h.CyF.a(21160, new Object[] { hes, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    AppMethodBeat.o(200035);
  }
  
  public static void awz()
  {
    AppMethodBeat.i(200034);
    h.CyF.a(21160, new Object[] { hes, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(200034);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200031);
    p.h(paramArrayList, "emojiInfoList");
    gXY = paramInt1;
    hev = paramInt2;
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)paramArrayList.next();
      p.g(localEmojiInfo, "emoji");
      localStringBuffer.append(localEmojiInfo.getMd5()).append("#");
    }
    paramArrayList = localStringBuffer.toString();
    p.g(paramArrayList, "md5String.toString()");
    heu = paramArrayList;
    h.CyF.a(21159, new Object[] { query, sessionId, hes, Integer.valueOf(1), heu, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(het), gVs, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(200031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emojisearch.d.a
 * JD-Core Version:    0.7.0.1
 */