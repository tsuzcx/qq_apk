package com.tencent.mm.emojisearch.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/report/EmojiSearchReport;", "", "()V", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_ICON", "", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_MORE", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_STORE", "EMOJI_SEARCH_ENTRANCE_KV_KEY", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEARCH_RESULT", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEND_EMOJI", "EMOJI_SEARCH_EXPOSE_KV_KEY", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_EDITTEXT_BRING", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_USER_INPUT", "chatId", "", "query", "querySource", "reportCount", "reportIndex", "reportMD5", "searchId", "sessionId", "enableReport", "", "start", "", "markClickSearchMore", "", "markClickSearchStore", "markSearchResultByEmojiInfo", "emojiInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "totalCount", "index", "markSearchResultByMd5", "md5List", "markSendEmoji", "md5", "position", "markShowEmojiSearchPanel", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static String mfW;
  private static int miq;
  public static final a moZ;
  private static String mpa;
  private static int mpb;
  private static String mpc;
  private static int mpd;
  private static String query;
  private static String sessionId;
  
  static
  {
    AppMethodBeat.i(231498);
    moZ = new a();
    mfW = "";
    query = "";
    mpa = "";
    sessionId = "";
    mpb = 1;
    mpc = "";
    AppMethodBeat.o(231498);
  }
  
  public static void EA(String paramString)
  {
    AppMethodBeat.i(231480);
    s.u(paramString, "chatId");
    mpa = String.valueOf(System.currentTimeMillis());
    mfW = paramString;
    h.OAn.b(21160, new Object[] { mpa, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(231480);
  }
  
  public static void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(231458);
    s.u(paramString1, "query");
    s.u(paramString2, "sessionId");
    s.u(paramArrayList, "md5List");
    query = paramString1;
    sessionId = paramString2;
    mpb = paramInt2;
    miq = paramInt1;
    mpd = paramInt3;
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next()).append("#");
    }
    paramArrayList = localStringBuffer.toString();
    s.s(paramArrayList, "md5String.toString()");
    mpc = paramArrayList;
    h.OAn.b(21159, new Object[] { paramString1, mpa, paramString2, Integer.valueOf(1), mpc, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), mfW, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(231458);
  }
  
  public static void aWP()
  {
    AppMethodBeat.i(231488);
    h.OAn.b(21160, new Object[] { mpa, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(231488);
  }
  
  public static void aWQ()
  {
    AppMethodBeat.i(231495);
    h.OAn.b(21160, new Object[] { mpa, sessionId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    AppMethodBeat.o(231495);
  }
  
  public static void ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(231471);
    s.u(paramString, "md5");
    h.OAn.b(21159, new Object[] { query, mpa, sessionId, Integer.valueOf(2), paramString, Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(mpb), mfW, Integer.valueOf(mpd) });
    AppMethodBeat.o(231471);
  }
  
  public static void e(ArrayList<EmojiInfo> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231464);
    s.u(paramArrayList, "emojiInfoList");
    miq = paramInt1;
    mpd = paramInt2;
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append(((EmojiInfo)paramArrayList.next()).getMd5()).append("#");
    }
    paramArrayList = localStringBuffer.toString();
    s.s(paramArrayList, "md5String.toString()");
    mpc = paramArrayList;
    h.OAn.b(21159, new Object[] { query, mpa, sessionId, Integer.valueOf(1), mpc, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(mpb), mfW, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(231464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emojisearch.c.a
 * JD-Core Version:    0.7.0.1
 */