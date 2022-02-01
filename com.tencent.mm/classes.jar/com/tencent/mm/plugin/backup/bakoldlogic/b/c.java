package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.e;
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
  private static boolean Ol(String paramString)
  {
    AppMethodBeat.i(21840);
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (bw.K(str, "msg") != null)
    {
      AppMethodBeat.o(21840);
      return true;
    }
    AppMethodBeat.o(21840);
    return false;
  }
  
  public final int a(hu paramhu, bl parambl, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21841);
    if (bt.isNullOrNil(parambl.field_content)) {}
    Object localObject1;
    for (int i = 0;; i = parambl.field_content.getBytes().length)
    {
      localObject2 = ar.aIF(parambl.field_content).Fys.trim();
      localObject1 = localObject2;
      if (!Ol((String)localObject2))
      {
        localObject2 = parambl.field_content;
        localObject1 = localObject2;
        if (!Ol((String)localObject2))
        {
          localObject2 = a.a(parambl, paramhu);
          localObject1 = localObject2;
          if (parambl.field_isSend != 1)
          {
            localObject1 = localObject2;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.pF(parambl.field_talker)) {
              localObject1 = parambl.field_talker + " :\n " + (String)localObject2;
            }
          }
        }
      }
      if ((localObject1 != null) && (Ol((String)localObject1))) {
        break;
      }
      ad.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(21841);
      return -1;
    }
    Object localObject2 = new cmf();
    ((cmf)localObject2).aEE(bt.by((String)localObject1, ""));
    paramhu.Cxz = ((cmf)localObject2);
    parambl = b.byA().byB().bxR().aJx(parambl.field_imgPath);
    if ((parambl != null) && (parambl.fZQ()))
    {
      AppMethodBeat.o(21841);
      return i;
    }
    int j;
    if (parambl != null) {
      if (TextUtils.isEmpty(parambl.field_groupId))
      {
        localObject1 = b.byA().byB().aqb();
        localObject1 = (String)localObject1 + parambl.JS() + "_thumb";
        if (com.tencent.mm.vfs.i.aMN((String)localObject1) < 0L)
        {
          ad.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(21841);
          return -1;
        }
        j = i.a(new i.a((String)localObject1, paramhu, paramLinkedList, 4, "_thumb")) + i;
        if ((!TextUtils.isEmpty(parambl.field_groupId)) || (!parambl.fZM())) {
          break label550;
        }
        localObject1 = b.byA().byB().aqb();
        parambl = (String)localObject1 + parambl.JS();
        localObject1 = ar.aIF(z.a(paramhu.Cxz));
        i = j + i.a(new i.a(parambl, paramhu, paramLinkedList, b.byA().byB().bxR().aJx(((ar)localObject1).md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21841);
      return i;
      localObject1 = b.byA().byB().aqb();
      localObject1 = (String)localObject1 + parambl.field_groupId + "/" + parambl.JS() + "_cover";
      if (com.tencent.mm.vfs.i.aMN((String)localObject1) < 0L)
      {
        ad.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(21841);
        return -1;
      }
      j = i.a(new i.a((String)localObject1, paramhu, paramLinkedList, 4, "_thumb")) + i;
      break;
      label550:
      boolean bool;
      if ((parambl.field_catalog == EmojiInfo.LBS) || (parambl.field_catalog == EmojiInfo.LBV) || (parambl.field_catalog == EmojiInfo.LBU)) {
        bool = true;
      }
      for (;;)
      {
        i = j;
        if (!bool) {
          break;
        }
        localObject1 = b.byA().byB().aqb();
        parambl = (String)localObject1 + parambl.field_groupId + "/" + parambl.JS();
        localObject1 = ar.aIF(z.a(paramhu.Cxz));
        i = j + i.a(new i.a(parambl, paramhu, paramLinkedList, b.byA().byB().bxR().aJx(((ar)localObject1).md5)));
        break;
        localObject1 = parambl.gaa();
        if (bt.isNullOrNil((String)localObject1)) {
          bool = false;
        } else {
          bool = new e((String)localObject1).exists();
        }
      }
    }
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    parambl.setContent(paramhu.Cxz.Ehn);
    paramString = paramhu.Cxx.Ehn;
    Object localObject1 = paramhu.Cxy.Ehn;
    if (((String)b.byA().byB().afk().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramhu.Cxz.Ehn;
      localObject1 = bw.K((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fa((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      ad.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(paramString.md5);
    if (localObject2 == null)
    {
      ad.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.Oo(paramString.md5);
      if (!bt.isNullOrNil((String)localObject3))
      {
        paramString.md5 = ((String)localObject3);
        ad.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.dft = ((String)localObject1);
    }
    parambl.setType(47);
    parambl.nZ(paramString.md5);
    Object localObject3 = paramString.hAb;
    if ((!((EmojiInfo)localObject2).CZ()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambl.setContent(ar.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).fZM())
      {
        localObject2 = b.byA().byB().aqb();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label533;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhu, 4, (String)localObject2 + paramString.md5 + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhu, 5, (String)localObject2 + paramString.md5);
      }
    }
    for (;;)
    {
      paramhu = new EmojiInfo((String)localObject2);
      paramhu.field_md5 = paramString.md5;
      paramhu.field_svrid = paramString.id;
      paramhu.field_catalog = EmojiInfo.LBQ;
      paramhu.field_type = paramString.FyN;
      paramhu.field_size = paramString.FyO;
      paramhu.field_state = EmojiInfo.LCc;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramhu.field_groupId = ((String)localObject1);
      }
      if (!bt.isNullOrNil(paramString.FyW)) {
        paramhu.field_activityid = paramString.FyW;
      }
      b.byA().byB().bxR().replace(paramhu);
      ad.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambl))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label533:
      localObject3 = new e((String)localObject2 + (String)localObject1);
      if (!((e)localObject3).exists()) {
        ((e)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhu, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhu, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String mqD = "<msg>";
    public static String mqE = "</msg>";
    
    public static String Oo(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.Oz(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.mvh;
      AppMethodBeat.o(21838);
      return paramString;
    }
    
    public static String a(bl parambl, hu paramhu)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.byA().byB().bxR().aJx(parambl.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.OA(localEmojiInfo.JS());
      parambl = (bl)localObject;
      if (localObject == null) {
        parambl = new a.a(localEmojiInfo.JS(), localEmojiInfo.JS(), localEmojiInfo.JS(), localEmojiInfo.JS());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramhu.Cxx.Ehn);
        localXmlSerializer.attribute(null, "tousername", paramhu.Cxy.Ehn);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.fZT());
        localXmlSerializer.attribute(null, "md5", parambl.mvi);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", parambl.mvh);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.CZ())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramhu = bw.K(localEmojiInfo.getContent(), "gameext");
          parambl = bt.by((String)paramhu.get(".gameext.$type"), "");
          paramhu = bt.by((String)paramhu.get(".gameext.$content"), "");
          if ((parambl.equals("")) || (paramhu.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(parambl));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramhu));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        parambl = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException parambl)
      {
        try
        {
          parambl = parambl.substring(parambl.indexOf(mqD), parambl.indexOf(mqE) + mqE.length());
          ad.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(parambl)));
          AppMethodBeat.o(21839);
          return parambl;
        }
        catch (Exception parambl)
        {
          AppMethodBeat.o(21839);
        }
        parambl = parambl;
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambl, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalArgumentException parambl)
      {
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambl, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalStateException parambl)
      {
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambl, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IOException parambl)
      {
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambl, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */