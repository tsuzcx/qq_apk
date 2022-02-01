package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private static boolean agB(String paramString)
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
  
  public final int a(is paramis, ca paramca, String paramString, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(231599);
    if (Util.isNullOrNil(paramca.field_content)) {}
    for (int i = 0;; i = paramca.field_content.getBytes().length)
    {
      localObject = be.bkr(paramca.field_content).Oph.trim();
      paramString = (String)localObject;
      if (!agB((String)localObject))
      {
        localObject = paramca.field_content;
        paramString = (String)localObject;
        if (!agB((String)localObject))
        {
          localObject = a.a(paramca, paramis);
          paramString = (String)localObject;
          if (paramca.field_isSend != 1)
          {
            paramString = (String)localObject;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.Eq(paramca.field_talker)) {
              paramString = paramca.field_talker + " :\n " + (String)localObject;
            }
          }
        }
      }
      if ((paramString != null) && (agB(paramString))) {
        break;
      }
      Log.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(paramString)));
      AppMethodBeat.o(231599);
      return -1;
    }
    Object localObject = new dqi();
    ((dqi)localObject).bhy(Util.nullAs(paramString, ""));
    paramis.KHn = ((dqi)localObject);
    paramca = b.chw().chx().cgN().blk(paramca.field_imgPath);
    if ((paramca != null) && (paramca.hRB()))
    {
      AppMethodBeat.o(231599);
      return i;
    }
    int j;
    if (paramca != null) {
      if (TextUtils.isEmpty(paramca.field_groupId))
      {
        paramString = b.chw().chx().aTd();
        paramString = paramString + paramca.getMd5() + "_thumb";
        if (s.boW(paramString) < 0L)
        {
          Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(231599);
          return -1;
        }
        j = i.a(new i.a(paramString, paramis, paramLinkedList, 4, false, "_thumb", false)) + i;
        if ((!TextUtils.isEmpty(paramca.field_groupId)) || (!paramca.hRx())) {
          break label530;
        }
        paramString = b.chw().chx().aTd();
        paramca = paramString + paramca.getMd5();
        paramString = be.bkr(z.a(paramis.KHn));
        i = j + i.a(new i.a(paramca, paramis, paramLinkedList, false, false, b.chw().chx().cgN().blk(paramString.md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(231599);
      return i;
      paramString = b.chw().chx().aTd();
      paramString = paramString + paramca.field_groupId + "/" + paramca.getMd5() + "_cover";
      if (s.boW(paramString) < 0L)
      {
        Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(231599);
        return -1;
      }
      j = i.a(new i.a(paramString, paramis, paramLinkedList, 4, false, "_thumb", false)) + i;
      break;
      label530:
      boolean bool;
      if ((paramca.field_catalog == EmojiInfo.Uur) || (paramca.field_catalog == EmojiInfo.Uuu) || (paramca.field_catalog == EmojiInfo.Uut)) {
        bool = true;
      }
      for (;;)
      {
        i = j;
        if (!bool) {
          break;
        }
        paramString = b.chw().chx().aTd();
        paramca = paramString + paramca.field_groupId + "/" + paramca.getMd5();
        paramString = be.bkr(z.a(paramis.KHn));
        i = j + i.a(new i.a(paramca, paramis, paramLinkedList, false, false, b.chw().chx().cgN().blk(paramString.md5)));
        break;
        paramString = paramca.hRM();
        if (Util.isNullOrNil(paramString)) {
          bool = false;
        } else {
          bool = new o(paramString).exists();
        }
      }
    }
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    paramca.setContent(paramis.KHn.MTo);
    paramString = paramis.KHl.MTo;
    Object localObject1 = paramis.KHm.MTo;
    if (((String)b.chw().chx().azQ().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramis.KHn.MTo;
      localObject1 = XmlParser.parseXml((String)localObject2, "msg", null);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fT((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      Log.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramString.md5);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.agE(paramString.md5);
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
    paramca.setType(47);
    paramca.Cz(paramString.md5);
    Object localObject3 = paramString.jsh;
    if ((!((EmojiInfo)localObject2).NA()) && (!((EmojiInfo)localObject2).isGif()))
    {
      paramca.setContent(be.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).hRx())
      {
        localObject2 = b.chw().chx().aTd();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label534;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramis, 4, (String)localObject2 + paramString.md5 + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramis, 5, (String)localObject2 + paramString.md5);
      }
    }
    for (;;)
    {
      paramis = new EmojiInfo((String)localObject2);
      paramis.field_md5 = paramString.md5;
      paramis.field_svrid = paramString.id;
      paramis.field_catalog = EmojiInfo.Uup;
      paramis.field_type = paramString.OpC;
      paramis.field_size = paramString.OpD;
      paramis.field_state = EmojiInfo.UuB;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramis.field_groupId = ((String)localObject1);
      }
      if (!Util.isNullOrNil(paramString.OpL)) {
        paramis.field_activityid = paramString.OpL;
      }
      b.chw().chx().cgN().replace(paramis);
      Log.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.x(paramca))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label534:
      localObject3 = new o((String)localObject2 + (String)localObject1);
      if (!((o)localObject3).exists()) {
        ((o)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramis, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramis, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String oJw = "<msg>";
    public static String oJx = "</msg>";
    
    public static String a(ca paramca, is paramis)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.chw().chx().cgN().blk(paramca.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.agO(localEmojiInfo.getMd5());
      paramca = (ca)localObject;
      if (localObject == null) {
        paramca = new a.a(localEmojiInfo.getMd5(), localEmojiInfo.getMd5(), localEmojiInfo.getMd5(), localEmojiInfo.getMd5());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramis.KHl.MTo);
        localXmlSerializer.attribute(null, "tousername", paramis.KHm.MTo);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.hRE());
        localXmlSerializer.attribute(null, "md5", paramca.oNY);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", paramca.oNX);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.NA())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramis = XmlParser.parseXml(localEmojiInfo.getContent(), "gameext", null);
          paramca = Util.nullAs((String)paramis.get(".gameext.$type"), "");
          paramis = Util.nullAs((String)paramis.get(".gameext.$content"), "");
          if ((paramca.equals("")) || (paramis.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(paramca));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramis));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        paramca = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException paramca)
      {
        try
        {
          paramca = paramca.substring(paramca.indexOf(oJw), paramca.indexOf(oJx) + oJx.length());
          Log.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(paramca)));
          AppMethodBeat.o(21839);
          return paramca;
        }
        catch (Exception paramca)
        {
          AppMethodBeat.o(21839);
        }
        paramca = paramca;
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramca, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalArgumentException paramca)
      {
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramca, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalStateException paramca)
      {
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramca, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IOException paramca)
      {
        Log.printErrStackTrace("MicroMsg.EmojiConvert", paramca, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
    }
    
    public static String agE(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.agN(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.oNX;
      AppMethodBeat.o(21838);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */