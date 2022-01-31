package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import java.io.File;
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
  private static boolean xr(String paramString)
  {
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    return bn.s(str, "msg") != null;
  }
  
  public final int a(fo paramfo, bi parambi, LinkedList<u> paramLinkedList)
  {
    int i;
    Object localObject2;
    Object localObject1;
    int j;
    if (bk.bl(parambi.field_content))
    {
      i = 0;
      localObject2 = ap.abP(parambi.field_content).uAC.trim();
      localObject1 = localObject2;
      if (!xr((String)localObject2))
      {
        localObject2 = parambi.field_content;
        localObject1 = localObject2;
        if (!xr((String)localObject2))
        {
          localObject2 = a.a(parambi, paramfo);
          localObject1 = localObject2;
          if (parambi.field_isSend != 1)
          {
            localObject1 = localObject2;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.fn(parambi.field_talker)) {
              localObject1 = parambi.field_talker + " :\n " + (String)localObject2;
            }
          }
        }
      }
      if ((localObject1 != null) && (xr((String)localObject1))) {
        break label174;
      }
      y.d("MicroMsg.BakOldItemEmoji", "emoji error" + (String)localObject1);
      j = -1;
    }
    label174:
    do
    {
      return j;
      i = parambi.field_content.getBytes().length;
      break;
      localObject2 = new bml();
      ((bml)localObject2).YI(bk.aM((String)localObject1, ""));
      paramfo.svH = ((bml)localObject2);
      parambi = b.avO().avP().avg().acC(parambi.field_imgPath);
      if (parambi == null) {
        break label234;
      }
      j = i;
    } while (parambi.cwC());
    label234:
    if (parambi != null) {
      if (TextUtils.isEmpty(parambi.field_groupId))
      {
        localObject1 = b.avO().avP().FL();
        localObject1 = (String)localObject1 + parambi.Wv() + "_thumb";
        if (e.bJ((String)localObject1) < 0)
        {
          y.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          return -1;
        }
        j = i.a(new i.a((String)localObject1, paramfo, paramLinkedList, 4, "_thumb")) + i;
        if ((!TextUtils.isEmpty(parambi.field_groupId)) || (!parambi.cwz())) {
          break label523;
        }
        localObject1 = b.avO().avP().FL();
        parambi = (String)localObject1 + parambi.Wv();
        localObject1 = ap.abP(aa.a(paramfo.svH));
        i = j + i.a(new i.a(parambi, paramfo, paramLinkedList, b.avO().avP().avg().acC(((ap)localObject1).bIW)));
      }
    }
    for (;;)
    {
      return i;
      localObject1 = b.avO().avP().FL();
      localObject1 = (String)localObject1 + parambi.field_groupId + File.separator + parambi.Wv() + "_cover";
      if (e.bJ((String)localObject1) < 0)
      {
        y.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        return -1;
      }
      j = i.a(new i.a((String)localObject1, paramfo, paramLinkedList, 4, "_thumb")) + i;
      break;
      label523:
      i = j;
      if (parambi.cwB())
      {
        localObject1 = b.avO().avP().FL();
        parambi = (String)localObject1 + parambi.field_groupId + File.separator + parambi.Wv();
        localObject1 = ap.abP(aa.a(paramfo.svH));
        i = j + i.a(new i.a(parambi, paramfo, paramLinkedList, b.avO().avP().avg().acC(((ap)localObject1).bIW)));
      }
    }
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    boolean bool = true;
    parambi.setContent(paramfo.svH.tFO);
    paramString = paramfo.svF.tFO;
    Object localObject1 = paramfo.svG.tFO;
    if (((String)b.avO().avP().Dz().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramfo.svH.tFO;
      localObject1 = bn.s((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cM((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      y.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramString.bIW);
    if (localObject2 == null)
    {
      y.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.xu(paramString.bIW);
      if (!bk.bl((String)localObject3))
      {
        paramString.bIW = ((String)localObject3);
        y.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.bJd = ((String)localObject1);
    }
    parambi.setType(47);
    parambi.ed(paramString.bIW);
    Object localObject3 = paramString.eHA;
    if ((!((EmojiInfo)localObject2).ZH()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambi.setContent(ap.a((String)localObject3, 0L, bool, paramString.bIW, false, ""));
      if (!((EmojiInfo)localObject2).cwz())
      {
        localObject2 = b.avO().avP().FL();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label518;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramfo, 4, (String)localObject2 + paramString.bIW + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramfo, 5, (String)localObject2 + paramString.bIW);
      }
    }
    for (;;)
    {
      paramfo = new EmojiInfo((String)localObject2);
      paramfo.field_md5 = paramString.bIW;
      paramfo.field_svrid = paramString.id;
      paramfo.field_catalog = EmojiInfo.uCT;
      paramfo.field_type = paramString.uAR;
      paramfo.field_size = paramString.uAS;
      paramfo.field_state = EmojiInfo.uDf;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramfo.field_groupId = ((String)localObject1);
      }
      if (!bk.bl(paramString.uBa)) {
        paramfo.field_activityid = paramString.uBa;
      }
      b.avO().avP().avg().a(paramfo);
      long l = com.tencent.mm.plugin.backup.bakoldlogic.d.d.h(parambi);
      y.d("MicroMsg.BakOldItemEmoji", "id " + l);
      return 0;
      bool = false;
      break;
      label518:
      localObject3 = new File((String)localObject2 + (String)localObject1);
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramfo, 4, (String)localObject2 + (String)localObject1 + File.separator + paramString.bIW + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramfo, 5, (String)localObject2 + (String)localObject1 + File.separator + paramString.bIW);
    }
  }
  
  private static final class a
  {
    public static String hFI = "<msg>";
    public static String hFJ = "</msg>";
    
    public static String a(bi parambi, fo paramfo)
    {
      EmojiInfo localEmojiInfo = b.avO().avP().avg().acC(parambi.field_imgPath);
      if (localEmojiInfo == null) {
        return null;
      }
      Object localObject = a.xF(localEmojiInfo.Wv());
      parambi = (bi)localObject;
      if (localObject == null) {
        parambi = new a.a(localEmojiInfo.Wv(), localEmojiInfo.Wv(), localEmojiInfo.Wv(), localEmojiInfo.Wv());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramfo.svF.tFO);
        localXmlSerializer.attribute(null, "tousername", paramfo.svG.tFO);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.cwG());
        localXmlSerializer.attribute(null, "md5", parambi.hKl);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", parambi.hKk);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.ZH())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramfo = bn.s(localEmojiInfo.getContent(), "gameext");
          parambi = bk.aM((String)paramfo.get(".gameext.$type"), "");
          paramfo = bk.aM((String)paramfo.get(".gameext.$content"), "");
          if ((parambi.equals("")) || (paramfo.equals("")))
          {
            ((StringWriter)localObject).close();
            return "";
          }
          localXmlSerializer.attribute(null, "type", parambi);
          localXmlSerializer.attribute(null, "content", paramfo);
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        parambi = ((StringWriter)localObject).getBuffer().toString();
        try
        {
          parambi = parambi.substring(parambi.indexOf(hFI), parambi.indexOf(hFJ) + hFJ.length());
          y.d("MicroMsg.EmojiConvert", "xml " + parambi);
          return parambi;
        }
        catch (Exception parambi)
        {
          return "";
        }
        return "";
      }
      catch (XmlPullParserException parambi)
      {
        y.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        return "";
      }
      catch (IllegalArgumentException parambi)
      {
        y.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        return "";
      }
      catch (IllegalStateException parambi)
      {
        y.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        return "";
      }
      catch (IOException parambi)
      {
        y.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
      }
    }
    
    public static String xu(String paramString)
    {
      paramString = a.xE(paramString);
      if (paramString == null) {
        return null;
      }
      return paramString.hKk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */