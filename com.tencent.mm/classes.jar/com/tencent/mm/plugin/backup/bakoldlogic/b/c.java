package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  private static boolean WF(String paramString)
  {
    AppMethodBeat.i(21840);
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (bx.M(str, "msg") != null)
    {
      AppMethodBeat.o(21840);
      return true;
    }
    AppMethodBeat.o(21840);
    return false;
  }
  
  public final int a(if paramif, bv parambv, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21841);
    if (bu.isNullOrNil(parambv.field_content)) {}
    Object localObject1;
    for (int i = 0;; i = parambv.field_content.getBytes().length)
    {
      localObject2 = az.aVt(parambv.field_content).Jfn.trim();
      localObject1 = localObject2;
      if (!WF((String)localObject2))
      {
        localObject2 = parambv.field_content;
        localObject1 = localObject2;
        if (!WF((String)localObject2))
        {
          localObject2 = a.a(parambv, paramif);
          localObject1 = localObject2;
          if (parambv.field_isSend != 1)
          {
            localObject1 = localObject2;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.wb(parambv.field_talker)) {
              localObject1 = parambv.field_talker + " :\n " + (String)localObject2;
            }
          }
        }
      }
      if ((localObject1 != null) && (WF((String)localObject1))) {
        break;
      }
      ae.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(21841);
      return -1;
    }
    Object localObject2 = new cxn();
    ((cxn)localObject2).aQV(bu.bI((String)localObject1, ""));
    paramif.FNI = ((cxn)localObject2);
    parambv = b.bKD().bKE().bJU().aWl(parambv.field_imgPath);
    if ((parambv != null) && (parambv.fxr()))
    {
      AppMethodBeat.o(21841);
      return i;
    }
    int j;
    if (parambv != null) {
      if (TextUtils.isEmpty(parambv.field_groupId))
      {
        localObject1 = b.bKD().bKE().azV();
        localObject1 = (String)localObject1 + parambv.Lj() + "_thumb";
        if (o.aZR((String)localObject1) < 0L)
        {
          ae.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(21841);
          return -1;
        }
        j = i.a(new i.a((String)localObject1, paramif, paramLinkedList, 4, "_thumb")) + i;
        if ((!TextUtils.isEmpty(parambv.field_groupId)) || (!parambv.fxn())) {
          break label550;
        }
        localObject1 = b.bKD().bKE().azV();
        parambv = (String)localObject1 + parambv.Lj();
        localObject1 = az.aVt(z.a(paramif.FNI));
        i = j + i.a(new i.a(parambv, paramif, paramLinkedList, b.bKD().bKE().bJU().aWl(((az)localObject1).md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21841);
      return i;
      localObject1 = b.bKD().bKE().azV();
      localObject1 = (String)localObject1 + parambv.field_groupId + "/" + parambv.Lj() + "_cover";
      if (o.aZR((String)localObject1) < 0L)
      {
        ae.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(21841);
        return -1;
      }
      j = i.a(new i.a((String)localObject1, paramif, paramLinkedList, 4, "_thumb")) + i;
      break;
      label550:
      boolean bool;
      if ((parambv.field_catalog == EmojiInfo.OzW) || (parambv.field_catalog == EmojiInfo.OzZ) || (parambv.field_catalog == EmojiInfo.OzY)) {
        bool = true;
      }
      for (;;)
      {
        i = j;
        if (!bool) {
          break;
        }
        localObject1 = b.bKD().bKE().azV();
        parambv = (String)localObject1 + parambv.field_groupId + "/" + parambv.Lj();
        localObject1 = az.aVt(z.a(paramif.FNI));
        i = j + i.a(new i.a(parambv, paramif, paramLinkedList, b.bKD().bKE().bJU().aWl(((az)localObject1).md5)));
        break;
        localObject1 = parambv.fSQ();
        if (bu.isNullOrNil((String)localObject1)) {
          bool = false;
        } else {
          bool = new k((String)localObject1).exists();
        }
      }
    }
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    parambv.setContent(paramif.FNI.HId);
    paramString = paramif.FNG.HId;
    Object localObject1 = paramif.FNH.HId;
    if (((String)b.bKD().bKE().ajA().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramif.FNI.HId;
      localObject1 = bx.M((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fB((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      ae.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramString.md5);
    if (localObject2 == null)
    {
      ae.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.WI(paramString.md5);
      if (!bu.isNullOrNil((String)localObject3))
      {
        paramString.md5 = ((String)localObject3);
        ae.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.dpp = ((String)localObject1);
    }
    parambv.setType(47);
    parambv.uj(paramString.md5);
    Object localObject3 = paramString.iwS;
    if ((!((EmojiInfo)localObject2).Ee()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambv.setContent(az.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).fxn())
      {
        localObject2 = b.bKD().bKE().azV();
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
      paramif.field_catalog = EmojiInfo.OzU;
      paramif.field_type = paramString.JfJ;
      paramif.field_size = paramString.JfK;
      paramif.field_state = EmojiInfo.OAg;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramif.field_groupId = ((String)localObject1);
      }
      if (!bu.isNullOrNil(paramString.JfS)) {
        paramif.field_activityid = paramString.JfS;
      }
      b.bKD().bKE().bJU().replace(paramif);
      ae.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.v(parambv))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label533:
      localObject3 = new k((String)localObject2 + (String)localObject1);
      if (!((k)localObject3).exists()) {
        ((k)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramif, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String nyy = "<msg>";
    public static String nyz = "</msg>";
    
    public static String WI(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.WT(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.nDa;
      AppMethodBeat.o(21838);
      return paramString;
    }
    
    public static String a(bv parambv, if paramif)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.bKD().bKE().bJU().aWl(parambv.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.WU(localEmojiInfo.Lj());
      parambv = (bv)localObject;
      if (localObject == null) {
        parambv = new a.a(localEmojiInfo.Lj(), localEmojiInfo.Lj(), localEmojiInfo.Lj(), localEmojiInfo.Lj());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramif.FNG.HId);
        localXmlSerializer.attribute(null, "tousername", paramif.FNH.HId);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.fxu());
        localXmlSerializer.attribute(null, "md5", parambv.nDb);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", parambv.nDa);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.Ee())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramif = bx.M(localEmojiInfo.getContent(), "gameext");
          parambv = bu.bI((String)paramif.get(".gameext.$type"), "");
          paramif = bu.bI((String)paramif.get(".gameext.$content"), "");
          if ((parambv.equals("")) || (paramif.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(parambv));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramif));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        parambv = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException parambv)
      {
        try
        {
          parambv = parambv.substring(parambv.indexOf(nyy), parambv.indexOf(nyz) + nyz.length());
          ae.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(parambv)));
          AppMethodBeat.o(21839);
          return parambv;
        }
        catch (Exception parambv)
        {
          AppMethodBeat.o(21839);
        }
        parambv = parambv;
        ae.printErrStackTrace("MicroMsg.EmojiConvert", parambv, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalArgumentException parambv)
      {
        ae.printErrStackTrace("MicroMsg.EmojiConvert", parambv, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalStateException parambv)
      {
        ae.printErrStackTrace("MicroMsg.EmojiConvert", parambv, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IOException parambv)
      {
        ae.printErrStackTrace("MicroMsg.EmojiConvert", parambv, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */