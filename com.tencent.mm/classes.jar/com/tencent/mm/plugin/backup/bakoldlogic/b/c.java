package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bu;
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
  private static boolean VT(String paramString)
  {
    AppMethodBeat.i(21840);
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (bw.M(str, "msg") != null)
    {
      AppMethodBeat.o(21840);
      return true;
    }
    AppMethodBeat.o(21840);
    return false;
  }
  
  public final int a(if paramif, bu parambu, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21841);
    if (bt.isNullOrNil(parambu.field_content)) {}
    Object localObject1;
    for (int i = 0;; i = parambu.field_content.getBytes().length)
    {
      localObject2 = ay.aTS(parambu.field_content).IKG.trim();
      localObject1 = localObject2;
      if (!VT((String)localObject2))
      {
        localObject2 = parambu.field_content;
        localObject1 = localObject2;
        if (!VT((String)localObject2))
        {
          localObject2 = a.a(parambu, paramif);
          localObject1 = localObject2;
          if (parambu.field_isSend != 1)
          {
            localObject1 = localObject2;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.vF(parambu.field_talker)) {
              localObject1 = parambu.field_talker + " :\n " + (String)localObject2;
            }
          }
        }
      }
      if ((localObject1 != null) && (VT((String)localObject1))) {
        break;
      }
      ad.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(21841);
      return -1;
    }
    Object localObject2 = new cwt();
    ((cwt)localObject2).aPy(bt.bI((String)localObject1, ""));
    paramif.Fvk = ((cwt)localObject2);
    parambu = b.bJF().bJG().bIW().aUK(parambu.field_imgPath);
    if ((parambu != null) && (parambu.fOy()))
    {
      AppMethodBeat.o(21841);
      return i;
    }
    int j;
    if (parambu != null) {
      if (TextUtils.isEmpty(parambu.field_groupId))
      {
        localObject1 = b.bJF().bJG().azF();
        localObject1 = (String)localObject1 + parambu.Lb() + "_thumb";
        if (com.tencent.mm.vfs.i.aYo((String)localObject1) < 0L)
        {
          ad.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(21841);
          return -1;
        }
        j = i.a(new i.a((String)localObject1, paramif, paramLinkedList, 4, "_thumb")) + i;
        if ((!TextUtils.isEmpty(parambu.field_groupId)) || (!parambu.fOu())) {
          break label550;
        }
        localObject1 = b.bJF().bJG().azF();
        parambu = (String)localObject1 + parambu.Lb();
        localObject1 = ay.aTS(z.a(paramif.Fvk));
        i = j + i.a(new i.a(parambu, paramif, paramLinkedList, b.bJF().bJG().bIW().aUK(((ay)localObject1).md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21841);
      return i;
      localObject1 = b.bJF().bJG().azF();
      localObject1 = (String)localObject1 + parambu.field_groupId + "/" + parambu.Lb() + "_cover";
      if (com.tencent.mm.vfs.i.aYo((String)localObject1) < 0L)
      {
        ad.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(21841);
        return -1;
      }
      j = i.a(new i.a((String)localObject1, paramif, paramLinkedList, 4, "_thumb")) + i;
      break;
      label550:
      boolean bool;
      if ((parambu.field_catalog == EmojiInfo.OeP) || (parambu.field_catalog == EmojiInfo.OeS) || (parambu.field_catalog == EmojiInfo.OeR)) {
        bool = true;
      }
      for (;;)
      {
        i = j;
        if (!bool) {
          break;
        }
        localObject1 = b.bJF().bJG().azF();
        parambu = (String)localObject1 + parambu.field_groupId + "/" + parambu.Lb();
        localObject1 = ay.aTS(z.a(paramif.Fvk));
        i = j + i.a(new i.a(parambu, paramif, paramLinkedList, b.bJF().bJG().bIW().aUK(((ay)localObject1).md5)));
        break;
        localObject1 = parambu.gzQ();
        if (bt.isNullOrNil((String)localObject1)) {
          bool = false;
        } else {
          bool = new e((String)localObject1).exists();
        }
      }
    }
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    parambu.setContent(paramif.Fvk.HoB);
    paramString = paramif.Fvi.HoB;
    Object localObject1 = paramif.Fvj.HoB;
    if (((String)b.bJF().bJG().ajl().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramif.Fvk.HoB;
      localObject1 = bw.M((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fx((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      ad.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(paramString.md5);
    if (localObject2 == null)
    {
      ad.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.VW(paramString.md5);
      if (!bt.isNullOrNil((String)localObject3))
      {
        paramString.md5 = ((String)localObject3);
        ad.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.dok = ((String)localObject1);
    }
    parambu.setType(47);
    parambu.tO(paramString.md5);
    Object localObject3 = paramString.itY;
    if ((!((EmojiInfo)localObject2).Eb()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambu.setContent(ay.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).fOu())
      {
        localObject2 = b.bJF().bJG().azF();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label533;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 4, (String)localObject2 + paramString.md5 + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 5, (String)localObject2 + paramString.md5);
      }
    }
    for (;;)
    {
      paramif = new EmojiInfo((String)localObject2);
      paramif.field_md5 = paramString.md5;
      paramif.field_svrid = paramString.id;
      paramif.field_catalog = EmojiInfo.OeN;
      paramif.field_type = paramString.ILc;
      paramif.field_size = paramString.ILd;
      paramif.field_state = EmojiInfo.OeZ;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramif.field_groupId = ((String)localObject1);
      }
      if (!bt.isNullOrNil(paramString.ILl)) {
        paramif.field_activityid = paramString.ILl;
      }
      b.bJF().bJG().bIW().replace(paramif);
      ad.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambu))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label533:
      localObject3 = new e((String)localObject2 + (String)localObject1);
      if (!((e)localObject3).exists()) {
        ((e)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String ntd = "<msg>";
    public static String nte = "</msg>";
    
    public static String VW(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.Wh(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.nxF;
      AppMethodBeat.o(21838);
      return paramString;
    }
    
    public static String a(bu parambu, if paramif)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.bJF().bJG().bIW().aUK(parambu.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.Wi(localEmojiInfo.Lb());
      parambu = (bu)localObject;
      if (localObject == null) {
        parambu = new a.a(localEmojiInfo.Lb(), localEmojiInfo.Lb(), localEmojiInfo.Lb(), localEmojiInfo.Lb());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramif.Fvi.HoB);
        localXmlSerializer.attribute(null, "tousername", paramif.Fvj.HoB);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.gzI());
        localXmlSerializer.attribute(null, "md5", parambu.nxG);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", parambu.nxF);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.Eb())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramif = bw.M(localEmojiInfo.getContent(), "gameext");
          parambu = bt.bI((String)paramif.get(".gameext.$type"), "");
          paramif = bt.bI((String)paramif.get(".gameext.$content"), "");
          if ((parambu.equals("")) || (paramif.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(parambu));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramif));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        parambu = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException parambu)
      {
        try
        {
          parambu = parambu.substring(parambu.indexOf(ntd), parambu.indexOf(nte) + nte.length());
          ad.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(parambu)));
          AppMethodBeat.o(21839);
          return parambu;
        }
        catch (Exception parambu)
        {
          AppMethodBeat.o(21839);
        }
        parambu = parambu;
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambu, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalArgumentException parambu)
      {
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambu, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalStateException parambu)
      {
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambu, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IOException parambu)
      {
        ad.printErrStackTrace("MicroMsg.EmojiConvert", parambu, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */