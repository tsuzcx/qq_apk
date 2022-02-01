package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bo;
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
  private static boolean Sv(String paramString)
  {
    AppMethodBeat.i(21840);
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (bv.L(str, "msg") != null)
    {
      AppMethodBeat.o(21840);
      return true;
    }
    AppMethodBeat.o(21840);
    return false;
  }
  
  public final int a(hy paramhy, bo parambo, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(21841);
    if (bs.isNullOrNil(parambo.field_content)) {}
    Object localObject1;
    for (int i = 0;; i = parambo.field_content.getBytes().length)
    {
      localObject2 = au.aOb(parambo.field_content).GXs.trim();
      localObject1 = localObject2;
      if (!Sv((String)localObject2))
      {
        localObject2 = parambo.field_content;
        localObject1 = localObject2;
        if (!Sv((String)localObject2))
        {
          localObject2 = a.a(parambo, paramhy);
          localObject1 = localObject2;
          if (parambo.field_isSend != 1)
          {
            localObject1 = localObject2;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.sQ(parambo.field_talker)) {
              localObject1 = parambo.field_talker + " :\n " + (String)localObject2;
            }
          }
        }
      }
      if ((localObject1 != null) && (Sv((String)localObject1))) {
        break;
      }
      ac.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(21841);
      return -1;
    }
    Object localObject2 = new crm();
    ((crm)localObject2).aJV(bs.bG((String)localObject1, ""));
    paramhy.DPV = ((crm)localObject2);
    parambo = b.bFw().bFx().bEN().aOT(parambo.field_imgPath);
    if ((parambo != null) && (parambo.fxI()))
    {
      AppMethodBeat.o(21841);
      return i;
    }
    int j;
    if (parambo != null) {
      if (TextUtils.isEmpty(parambo.field_groupId))
      {
        localObject1 = b.bFw().bFx().awQ();
        localObject1 = (String)localObject1 + parambo.JC() + "_thumb";
        if (com.tencent.mm.vfs.i.aSp((String)localObject1) < 0L)
        {
          ac.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(21841);
          return -1;
        }
        j = i.a(new i.a((String)localObject1, paramhy, paramLinkedList, 4, "_thumb")) + i;
        if ((!TextUtils.isEmpty(parambo.field_groupId)) || (!parambo.fdp())) {
          break label550;
        }
        localObject1 = b.bFw().bFx().awQ();
        parambo = (String)localObject1 + parambo.JC();
        localObject1 = au.aOb(z.a(paramhy.DPV));
        i = j + i.a(new i.a(parambo, paramhy, paramLinkedList, b.bFw().bFx().bEN().aOT(((au)localObject1).md5)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21841);
      return i;
      localObject1 = b.bFw().bFx().awQ();
      localObject1 = (String)localObject1 + parambo.field_groupId + "/" + parambo.JC() + "_cover";
      if (com.tencent.mm.vfs.i.aSp((String)localObject1) < 0L)
      {
        ac.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(21841);
        return -1;
      }
      j = i.a(new i.a((String)localObject1, paramhy, paramLinkedList, 4, "_thumb")) + i;
      break;
      label550:
      boolean bool;
      if ((parambo.field_catalog == EmojiInfo.Jsu) || (parambo.field_catalog == EmojiInfo.Jsx) || (parambo.field_catalog == EmojiInfo.Jsw)) {
        bool = true;
      }
      for (;;)
      {
        i = j;
        if (!bool) {
          break;
        }
        localObject1 = b.bFw().bFx().awQ();
        parambo = (String)localObject1 + parambo.field_groupId + "/" + parambo.JC();
        localObject1 = au.aOb(z.a(paramhy.DPV));
        i = j + i.a(new i.a(parambo, paramhy, paramLinkedList, b.bFw().bFx().bEN().aOT(((au)localObject1).md5)));
        break;
        localObject1 = parambo.ghd();
        if (bs.isNullOrNil((String)localObject1)) {
          bool = false;
        } else {
          bool = new e((String)localObject1).exists();
        }
      }
    }
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    boolean bool = true;
    AppMethodBeat.i(21842);
    parambo.setContent(paramhy.DPV.FEm);
    paramString = paramhy.DPT.FEm;
    Object localObject1 = paramhy.DPU.FEm;
    if (((String)b.bFw().bFx().agA().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramhy.DPV.FEm;
      localObject1 = bv.L((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fn((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      ac.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramString.md5);
    if (localObject2 == null)
    {
      ac.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(21842);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.Sy(paramString.md5);
      if (!bs.isNullOrNil((String)localObject3))
      {
        paramString.md5 = ((String)localObject3);
        ac.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.dcO = ((String)localObject1);
    }
    parambo.setType(47);
    parambo.rf(paramString.md5);
    Object localObject3 = paramString.iaC;
    if ((!((EmojiInfo)localObject2).CC()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambo.setContent(au.a((String)localObject3, 0L, bool, paramString.md5, false, ""));
      if (!((EmojiInfo)localObject2).fdp())
      {
        localObject2 = b.bFw().bFx().awQ();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label533;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhy, 4, (String)localObject2 + paramString.md5 + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhy, 5, (String)localObject2 + paramString.md5);
      }
    }
    for (;;)
    {
      paramhy = new EmojiInfo((String)localObject2);
      paramhy.field_md5 = paramString.md5;
      paramhy.field_svrid = paramString.id;
      paramhy.field_catalog = EmojiInfo.Jss;
      paramhy.field_type = paramString.GXO;
      paramhy.field_size = paramString.GXP;
      paramhy.field_state = EmojiInfo.Kgd;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramhy.field_groupId = ((String)localObject1);
      }
      if (!bs.isNullOrNil(paramString.GXX)) {
        paramhy.field_activityid = paramString.GXX;
      }
      b.bFw().bFx().bEN().replace(paramhy);
      ac.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.u(parambo))));
      AppMethodBeat.o(21842);
      return 0;
      bool = false;
      break;
      label533:
      localObject3 = new e((String)localObject2 + (String)localObject1);
      if (!((e)localObject3).exists()) {
        ((e)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhy, 4, (String)localObject2 + (String)localObject1 + "/" + paramString.md5 + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramhy, 5, (String)localObject2 + (String)localObject1 + "/" + paramString.md5);
    }
  }
  
  static final class a
  {
    public static String mSF = "<msg>";
    public static String mSG = "</msg>";
    
    public static String Sy(String paramString)
    {
      AppMethodBeat.i(21838);
      paramString = a.SJ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(21838);
        return null;
      }
      paramString = paramString.mXi;
      AppMethodBeat.o(21838);
      return paramString;
    }
    
    public static String a(bo parambo, hy paramhy)
    {
      AppMethodBeat.i(21839);
      EmojiInfo localEmojiInfo = b.bFw().bFx().bEN().aOT(parambo.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(21839);
        return null;
      }
      Object localObject = a.SK(localEmojiInfo.JC());
      parambo = (bo)localObject;
      if (localObject == null) {
        parambo = new a.a(localEmojiInfo.JC(), localEmojiInfo.JC(), localEmojiInfo.JC(), localEmojiInfo.JC());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramhy.DPT.FEm);
        localXmlSerializer.attribute(null, "tousername", paramhy.DPU.FEm);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.fxL());
        localXmlSerializer.attribute(null, "md5", parambo.mXj);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", parambo.mXi);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.CC())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramhy = bv.L(localEmojiInfo.getContent(), "gameext");
          parambo = bs.bG((String)paramhy.get(".gameext.$type"), "");
          paramhy = bs.bG((String)paramhy.get(".gameext.$content"), "");
          if ((parambo.equals("")) || (paramhy.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(21839);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(parambo));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramhy));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        parambo = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException parambo)
      {
        try
        {
          parambo = parambo.substring(parambo.indexOf(mSF), parambo.indexOf(mSG) + mSG.length());
          ac.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(parambo)));
          AppMethodBeat.o(21839);
          return parambo;
        }
        catch (Exception parambo)
        {
          AppMethodBeat.o(21839);
        }
        parambo = parambo;
        ac.printErrStackTrace("MicroMsg.EmojiConvert", parambo, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalArgumentException parambo)
      {
        ac.printErrStackTrace("MicroMsg.EmojiConvert", parambo, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IllegalStateException parambo)
      {
        ac.printErrStackTrace("MicroMsg.EmojiConvert", parambo, "", new Object[0]);
        AppMethodBeat.o(21839);
        return "";
      }
      catch (IOException parambo)
      {
        ac.printErrStackTrace("MicroMsg.EmojiConvert", parambo, "", new Object[0]);
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