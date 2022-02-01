package com.tencent.mm.emojisearch.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/report/EmojiSearchReport;", "", "()V", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_ICON", "", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_MORE", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_STORE", "EMOJI_SEARCH_ENTRANCE_KV_KEY", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEARCH_RESULT", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEND_EMOJI", "EMOJI_SEARCH_EXPOSE_KV_KEY", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_EDITTEXT_BRING", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_USER_INPUT", "chatId", "", "query", "querySource", "reportCount", "reportIndex", "reportMD5", "searchId", "sessionId", "enableReport", "", "start", "", "markClickSearchMore", "", "markClickSearchStore", "markSearchResultByEmojiInfo", "emojiInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "totalCount", "index", "markSearchResultByMd5", "md5List", "markSendEmoji", "md5", "position", "markShowEmojiSearchPanel", "plugin-emojisdk_release"})
public final class a
{
  private static String jGo;
  private static int jIY;
  private static String jQi;
  private static int jQj;
  private static String jQk;
  private static int jQl;
  public static final a jQm;
  private static String query;
  private static String sessionId;
  
  static
  {
    AppMethodBeat.i(225624);
    jQm = new a();
    jGo = "";
    query = "";
    jQi = "";
    sessionId = "";
    jQj = 1;
    jQk = "";
    AppMethodBeat.o(225624);
  }
  
  public static void LU(String paramString)
  {
    AppMethodBeat.i(225615);
    p.k(paramString, "chatId");
    jQi = String.valueOf(System.currentTimeMillis());
    jGo = paramString;
    h.IzE.a(21160, new Object[] { jQi, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(225615);
  }
  
  public static void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(225603);
    p.k(paramString1, "query");
    p.k(paramString2, "sessionId");
    p.k(paramArrayList, "md5List");
    query = paramString1;
    sessionId = paramString2;
    jQj = paramInt2;
    jIY = paramInt1;
    jQl = paramInt3;
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next()).append("#");
    }
    paramArrayList = localStringBuffer.toString();
    p.j(paramArrayList, "md5String.toString()");
    jQk = paramArrayList;
    h.IzE.a(21159, new Object[] { paramString1, jQi, paramString2, Integer.valueOf(1), jQk, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), jGo, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(225603);
  }
  
  public static void aDQ()
  {
    AppMethodBeat.i(225618);
    h.IzE.a(21160, new Object[] { jQi, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(225618);
  }
  
  public static void aDR()
  {
    AppMethodBeat.i(225621);
    h.IzE.a(21160, new Object[] { jQi, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    AppMethodBeat.o(225621);
  }
  
  public static void ai(String paramString, int paramInt)
  {
    AppMethodBeat.i(225613);
    p.k(paramString, "md5");
    h.IzE.a(21159, new Object[] { query, jQi, sessionId, Integer.valueOf(2), paramString, Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(jQj), jGo, Integer.valueOf(jQl) });
    AppMethodBeat.o(225613);
  }
  
  public static void b(ArrayList<EmojiInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225610);
    p.k(paramArrayList, "emojiInfoList");
    jIY = paramInt1;
    jQl = paramInt2;
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      EmojiInfo localEmojiInfo = (EmojiInfo)paramArrayList.next();
      p.j(localEmojiInfo, "emoji");
      localStringBuffer.append(localEmojiInfo.getMd5()).append("#");
    }
    paramArrayList = localStringBuffer.toString();
    p.j(paramArrayList, "md5String.toString()");
    jQk = paramArrayList;
    h.IzE.a(21159, new Object[] { query, jQi, sessionId, Integer.valueOf(1), jQk, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(jQj), jGo, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(225610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emojisearch.d.a
 * JD-Core Version:    0.7.0.1
 */