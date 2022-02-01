package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class c
  implements j
{
  private static boolean ahC(String paramString)
  {
    AppMethodBeat.i(21840);
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (XmlParser.parseXml(str, "msg", null) != null)
    {
      AppMethodBeat.o(21840);
      return true;
    }
    AppMethodBeat.o(21840);
    return false;
  }
  
  public final int a(jd paramjd, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(300725);
    if (Util.isNullOrNil(paramcc.field_content)) {}
    for (int i = 0;; i = paramcc.field_content.getBytes().length)
    {
      localObject = bg.byj(paramcc.field_content).adiN.trim();
      paramString = (String)localObject;
      if (!ahC((String)localObject))
      {
        localObject = paramcc.field_content;
        paramString = (String)localObject;
        if (!ahC((String)localObject))
        {
          localObject = a.a(paramcc, paramjd);
          paramString = (String)localObject;
          if (paramcc.field_isSend != 1)
          {
            paramString = (String)localObject;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.DQ(paramcc.field_talker)) {
              paramString = paramcc.field_talker + " :\n " + (String)localObject;
            }
          }
        }
      }
      if ((paramString != null) && (ahC(paramString))) {
        break;
      }
      Log.d("MicroMsg.BakOldItemEmoji", "emoji error" + Util.secPrint(paramString));
      AppMethodBeat.o(300725);
      return -1;
    }
    Object localObject = new etl();
    ((etl)localObject).btH(Util.nullAs(paramString, ""));
    paramjd.YFG = ((etl)localObject);
    paramcc = b.cXr().cXs().cWI().bza(paramcc.field_imgPath);
    if ((paramcc != null) && (paramcc.kMe()))
    {
      AppMethodBeat.o(300725);
      return i;
    }
    int j;
    if (paramcc != null) {
      if (TextUtils.isEmpty(paramcc.field_groupId))
      {
        paramString = b.cXr().cXs().bzQ();
        paramString = paramString + paramcc.getMd5() + "_thumb";
        if (y.bEl(paramString) < 0L)
        {
          Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(300725);
          return -1;
        }
        j = i.a(new i.a(paramString, paramjd, paramLinkedList, 4, false, "_thumb", false)) + i;
        if ((!TextUtils.isEmpty(paramcc.field_groupId)) || (!paramcc.kLZ())) {
          break label540;
        }
        paramString = b.cXr().cXs().bzQ();
        paramcc = paramString + paramcc.getMd5();
        paramString = bg.byj(w.a(paramjd.YFG));
        i = j + i.a(new i.a(paramcc, paramjd, paramLinkedList, false, false, b.cXr().cXs().cWI().bza(paramString.md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(300725);
      return i;
      paramString = b.cXr().cXs().bzQ();
      paramString = paramString + paramcc.field_groupId + "/" + paramcc.getMd5() + "_cover";
      if (y.bEl(paramString) < 0L)
      {
        Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(300725);
        return -1;
      }
      j = i.a(new i.a(paramString, paramjd, paramLinkedList, 4, false, "_thumb", false)) + i;
      break;
      label540:
      i = j;
      if (paramcc.kMb())
      {
        paramString = b.cXr().cXs().bzQ();
        paramcc = paramString + paramcc.field_groupId + "/" + paramcc.getMd5();
        paramString = bg.byj(w.a(paramjd.YFG));
        i = j + i.a(new i.a(paramcc, paramjd, paramLinkedList, false, false, b.cXr().cXs().cWI().bza(paramString.md5)));
      }
    }
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    paramcc.setContent(paramjd.YFG.abwM);
    paramString = paramjd.YFE.abwM;
    Object localObject1 = paramjd.YFF.abwM;
    if (((String)b.cXr().cXs().ban().d(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramjd.YFG.abwM;
      localObject1 = XmlParser.parseXml((String)localObject2, "msg", null);
      paramString = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().gM((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      Log.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramString.md5);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.ahF(paramString.md5);
      if (!Util.isNullOrNil((String)localObject3))
      {
        paramString.md5 = ((String)localObject3);
        Log.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.productId = ((String)localObject1);
    }
    paramcc.setType(47);
    paramcc.BT(paramString.md5);
    Object localObject3 = paramString.paV;
    if ((!((EmojiInfo)localObject2).aqJ()) && (!((EmojiInfo)localObject2).isGif()))
    {
      paramcc.setContent(bg.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).kLZ())
      {
        localObject2 = b.cXr().cXs().bzQ();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label534;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramjd, 4, (String)localObject2 + paramString.md5 + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramjd, 5, (String)localObject2 + paramString.md5);
      }
    }
    for (;;)
    {
      paramjd = new EmojiInfo((String)localObject2);
      paramjd.field_md5 = paramString.md5;
      paramjd.field_svrid = paramString.id;
      paramjd.field_catalog = EmojiInfo.aklG;
      paramjd.field_type = paramString.adji;
      paramjd.field_size = paramString.adjj;
      paramjd.field_state = EmojiInfo.aklS;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramjd.field_groupId = ((String)localObject1);
      }
      if (!Util.isNullOrNil(paramString.adjr)) {
        paramjd.field_activityid = paramString.adjr;
      }
      b.cXr().cXs().cWI().replace(paramjd);
      Log.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.B(paramcc))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label534:
      localObject3 = new com.tencent.mm.vfs.u((String)localObject2 + (String)localObject1);
      if (!((com.tencent.mm.vfs.u)localObject3).jKS()) {
        ((com.tencent.mm.vfs.u)localObject3).jKY();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramjd, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramjd, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String uWA = "<msg>";
    public static String uWB = "</msg>";
    
    public static String a(cc paramcc, jd paramjd)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.cXr().cXs().cWI().bza(paramcc.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.ahP(localEmojiInfo.getMd5());
      paramcc = (cc)localObject;
      if (localObject == null) {
        paramcc = new a.a(localEmojiInfo.getMd5(), localEmojiInfo.getMd5(), localEmojiInfo.getMd5(), localEmojiInfo.getMd5());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramjd.YFE.abwM);
        localXmlSerializer.attribute(null, "tousername", paramjd.YFF.abwM);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.kMh());
        localXmlSerializer.attribute(null, "md5", paramcc.vbk);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", paramcc.vbj);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.aqJ())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramjd = XmlParser.parseXml(localEmojiInfo.getContent(), "gameext", null);
          paramcc = Util.nullAs((String)paramjd.get(".gameext.$type"), "");
          paramjd = Util.nullAs((String)paramjd.get(".gameext.$content"), "");
          if ((paramcc.equals("")) || (paramjd.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(paramcc));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramjd));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        paramcc = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException paramcc)
      {
        try
        {
          paramcc = paramcc.substring(paramcc.indexOf(uWA), paramcc.indexOf(uWB) + uWB.length());
          Log.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(paramcc)));
          AppMethodBeat.o(21839);
          return paramcc;
        }
        catch (Exception paramcc)
        {
          AppMethodBeat.o(21839);
        }
        paramcc = paramcc;
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramcc, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalArgumentException paramcc)
      {
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramcc, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalStateException paramcc)
      {
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramcc, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IOException paramcc)
      {
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramcc, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
    }
    
    public static String ahF(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.ahO(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.vbj;
      AppMethodBeat.o(21838);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */