package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.q;
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
  private static boolean aof(String paramString)
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
  
  public final int a(ih paramih, ca paramca, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList)
  {
    AppMethodBeat.i(286343);
    if (Util.isNullOrNil(paramca.field_content)) {}
    for (int i = 0;; i = paramca.field_content.getBytes().length)
    {
      localObject = be.bwQ(paramca.field_content).VFa.trim();
      paramString = (String)localObject;
      if (!aof((String)localObject))
      {
        localObject = paramca.field_content;
        paramString = (String)localObject;
        if (!aof((String)localObject))
        {
          localObject = a.a(paramca, paramih);
          paramString = (String)localObject;
          if (paramca.field_isSend != 1)
          {
            paramString = (String)localObject;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.Lj(paramca.field_talker)) {
              paramString = paramca.field_talker + " :\n " + (String)localObject;
            }
          }
        }
      }
      if ((paramString != null) && (aof(paramString))) {
        break;
      }
      Log.d("MicroMsg.BakOldItemEmoji", "emoji error" + Util.secPrint(paramString));
      AppMethodBeat.o(286343);
      return -1;
    }
    Object localObject = new eaf();
    ((eaf)localObject).btQ(Util.nullAs(paramString, ""));
    paramih.RIF = ((eaf)localObject);
    paramca = b.cuH().cuI().ctY().bxK(paramca.field_imgPath);
    if ((paramca != null) && (paramca.hBu()))
    {
      AppMethodBeat.o(286343);
      return i;
    }
    int j;
    if (paramca != null) {
      if (TextUtils.isEmpty(paramca.field_groupId))
      {
        paramString = b.cuH().cuI().bcb();
        paramString = paramString + paramca.getMd5() + "_thumb";
        if (com.tencent.mm.vfs.u.bBQ(paramString) < 0L)
        {
          Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(286343);
          return -1;
        }
        j = i.a(new i.a(paramString, paramih, paramLinkedList, 4, false, "_thumb", false)) + i;
        if ((!TextUtils.isEmpty(paramca.field_groupId)) || (!paramca.hBp())) {
          break label540;
        }
        paramString = b.cuH().cuI().bcb();
        paramca = paramString + paramca.getMd5();
        paramString = be.bwQ(z.a(paramih.RIF));
        i = j + i.a(new i.a(paramca, paramih, paramLinkedList, false, false, b.cuH().cuI().ctY().bxK(paramString.md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(286343);
      return i;
      paramString = b.cuH().cuI().bcb();
      paramString = paramString + paramca.field_groupId + "/" + paramca.getMd5() + "_cover";
      if (com.tencent.mm.vfs.u.bBQ(paramString) < 0L)
      {
        Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(286343);
        return -1;
      }
      j = i.a(new i.a(paramString, paramih, paramLinkedList, 4, false, "_thumb", false)) + i;
      break;
      label540:
      i = j;
      if (paramca.hBr())
      {
        paramString = b.cuH().cuI().bcb();
        paramca = paramString + paramca.field_groupId + "/" + paramca.getMd5();
        paramString = be.bwQ(z.a(paramih.RIF));
        i = j + i.a(new i.a(paramca, paramih, paramLinkedList, false, false, b.cuH().cuI().ctY().bxK(paramString.md5)));
      }
    }
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    paramca.setContent(paramih.RIF.Ufy);
    paramString = paramih.RID.Ufy;
    Object localObject1 = paramih.RIE.Ufy;
    if (((String)b.cuH().cuI().aHp().b(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramih.RIF.Ufy;
      localObject1 = XmlParser.parseXml((String)localObject2, "msg", null);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().gg((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      Log.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramString.md5);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.aoi(paramString.md5);
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
    paramca.Jn(paramString.md5);
    Object localObject3 = paramString.mhK;
    if ((!((EmojiInfo)localObject2).Qv()) && (!((EmojiInfo)localObject2).isGif()))
    {
      paramca.setContent(be.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).hBp())
      {
        localObject2 = b.cuH().cuI().bcb();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label534;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramih, 4, (String)localObject2 + paramString.md5 + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramih, 5, (String)localObject2 + paramString.md5);
      }
    }
    for (;;)
    {
      paramih = new EmojiInfo((String)localObject2);
      paramih.field_md5 = paramString.md5;
      paramih.field_svrid = paramString.id;
      paramih.field_catalog = EmojiInfo.YCx;
      paramih.field_type = paramString.VFv;
      paramih.field_size = paramString.VFw;
      paramih.field_state = EmojiInfo.ZuD;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramih.field_groupId = ((String)localObject1);
      }
      if (!Util.isNullOrNil(paramString.VFE)) {
        paramih.field_activityid = paramString.VFE;
      }
      b.cuH().cuI().ctY().replace(paramih);
      Log.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.z(paramca))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label534:
      localObject3 = new q((String)localObject2 + (String)localObject1);
      if (!((q)localObject3).ifE()) {
        ((q)localObject3).ifL();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramih, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramih, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String rLm = "<msg>";
    public static String rLn = "</msg>";
    
    public static String a(ca paramca, ih paramih)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.cuH().cuI().ctY().bxK(paramca.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.aos(localEmojiInfo.getMd5());
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
        localXmlSerializer.attribute(null, "fromusername", paramih.RID.Ufy);
        localXmlSerializer.attribute(null, "tousername", paramih.RIE.Ufy);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.hBx());
        localXmlSerializer.attribute(null, "md5", paramca.rPV);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", paramca.rPU);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.Qv())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramih = XmlParser.parseXml(localEmojiInfo.getContent(), "gameext", null);
          paramca = Util.nullAs((String)paramih.get(".gameext.$type"), "");
          paramih = Util.nullAs((String)paramih.get(".gameext.$content"), "");
          if ((paramca.equals("")) || (paramih.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(paramca));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramih));
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
          paramca = paramca.substring(paramca.indexOf(rLm), paramca.indexOf(rLn) + rLn.length());
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
    
    public static String aoi(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.aor(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.rPU;
      AppMethodBeat.o(21838);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */