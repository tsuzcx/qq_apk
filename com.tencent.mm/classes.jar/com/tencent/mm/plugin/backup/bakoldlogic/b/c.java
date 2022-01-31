package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
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
  private static boolean Gk(String paramString)
  {
    AppMethodBeat.i(17783);
    int i = paramString.indexOf('<');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i);
    }
    if (br.F(str, "msg") != null)
    {
      AppMethodBeat.o(17783);
      return true;
    }
    AppMethodBeat.o(17783);
    return false;
  }
  
  public final int a(gx paramgx, bi parambi, LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(17784);
    if (bo.isNullOrNil(parambi.field_content)) {}
    Object localObject1;
    for (int i = 0;; i = parambi.field_content.getBytes().length)
    {
      localObject2 = ap.arZ(parambi.field_content).yML.trim();
      localObject1 = localObject2;
      if (!Gk((String)localObject2))
      {
        localObject2 = parambi.field_content;
        localObject1 = localObject2;
        if (!Gk((String)localObject2))
        {
          localObject2 = a.a(parambi, paramgx);
          localObject1 = localObject2;
          if (parambi.field_isSend != 1)
          {
            localObject1 = localObject2;
            if (com.tencent.mm.plugin.backup.bakoldlogic.d.d.lA(parambi.field_talker)) {
              localObject1 = parambi.field_talker + " :\n " + (String)localObject2;
            }
          }
        }
      }
      if ((localObject1 != null) && (Gk((String)localObject1))) {
        break;
      }
      ab.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(17784);
      return -1;
    }
    Object localObject2 = new bwc();
    ((bwc)localObject2).aoF(bo.bf((String)localObject1, ""));
    paramgx.woR = ((bwc)localObject2);
    parambi = b.aVr().aVs().aUI().asP(parambi.field_imgPath);
    if ((parambi != null) && (parambi.dzq()))
    {
      AppMethodBeat.o(17784);
      return i;
    }
    int j;
    if (parambi != null) {
      if (TextUtils.isEmpty(parambi.field_groupId))
      {
        localObject1 = b.aVr().aVs().YP();
        localObject1 = (String)localObject1 + parambi.Al() + "_thumb";
        if (e.cM((String)localObject1) < 0)
        {
          ab.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
          AppMethodBeat.o(17784);
          return -1;
        }
        j = i.a(new i.a((String)localObject1, paramgx, paramLinkedList, 4, "_thumb")) + i;
        if ((!TextUtils.isEmpty(parambi.field_groupId)) || (!parambi.dzn())) {
          break label547;
        }
        localObject1 = b.aVr().aVs().YP();
        parambi = (String)localObject1 + parambi.Al();
        localObject1 = ap.arZ(aa.a(paramgx.woR));
        i = j + i.a(new i.a(parambi, paramgx, paramLinkedList, b.aVr().aVs().aUI().asP(((ap)localObject1).cqq)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(17784);
      return i;
      localObject1 = b.aVr().aVs().YP();
      localObject1 = (String)localObject1 + parambi.field_groupId + File.separator + parambi.Al() + "_cover";
      if (e.cM((String)localObject1) < 0)
      {
        ab.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
        AppMethodBeat.o(17784);
        return -1;
      }
      j = i.a(new i.a((String)localObject1, paramgx, paramLinkedList, 4, "_thumb")) + i;
      break;
      label547:
      i = j;
      if (parambi.dzp())
      {
        localObject1 = b.aVr().aVs().YP();
        parambi = (String)localObject1 + parambi.field_groupId + File.separator + parambi.Al();
        localObject1 = ap.arZ(aa.a(paramgx.woR));
        i = j + i.a(new i.a(parambi, paramgx, paramLinkedList, b.aVr().aVs().aUI().asP(((ap)localObject1).cqq)));
      }
    }
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    boolean bool = true;
    AppMethodBeat.i(17785);
    parambi.setContent(paramgx.woR.xJE);
    paramString = paramgx.woP.xJE;
    Object localObject1 = paramgx.woQ.xJE;
    if (((String)b.aVr().aVs().Ru().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramgx.woR.xJE;
      localObject1 = br.F((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().dN((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      ab.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(17785);
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramString.cqq);
    if (localObject2 == null)
    {
      ab.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
      AppMethodBeat.o(17785);
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = a.Gn(paramString.cqq);
      if (!bo.isNullOrNil((String)localObject3))
      {
        paramString.cqq = ((String)localObject3);
        ab.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.cqx = ((String)localObject1);
    }
    parambi.setType(47);
    parambi.kk(paramString.cqq);
    Object localObject3 = paramString.fXq;
    if ((!((EmojiInfo)localObject2).vY()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambi.setContent(ap.a((String)localObject3, 0L, bool, paramString.cqq, false, ""));
      if (!((EmojiInfo)localObject2).dzn())
      {
        localObject2 = b.aVr().aVs().YP();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label533;
        }
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramgx, 4, (String)localObject2 + paramString.cqq + "_thumb");
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramgx, 5, (String)localObject2 + paramString.cqq);
      }
    }
    for (;;)
    {
      paramgx = new EmojiInfo((String)localObject2);
      paramgx.field_md5 = paramString.cqq;
      paramgx.field_svrid = paramString.id;
      paramgx.field_catalog = EmojiInfo.yPg;
      paramgx.field_type = paramString.yNc;
      paramgx.field_size = paramString.yNd;
      paramgx.field_state = EmojiInfo.yPs;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramgx.field_groupId = ((String)localObject1);
      }
      if (!bo.isNullOrNil(paramString.yNl)) {
        paramgx.field_activityid = paramString.yNl;
      }
      b.aVr().aVs().aUI().replace(paramgx);
      ab.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.l(parambi))));
      AppMethodBeat.o(17785);
      return 0;
      bool = false;
      break;
      label533:
      localObject3 = new File((String)localObject2 + (String)localObject1);
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramgx, 4, (String)localObject2 + (String)localObject1 + File.separator + paramString.cqq + "_cover");
      com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(paramgx, 5, (String)localObject2 + (String)localObject1 + File.separator + paramString.cqq);
    }
  }
  
  static final class a
  {
    public static String jzf = "<msg>";
    public static String jzg = "</msg>";
    
    public static String Gn(String paramString)
    {
      AppMethodBeat.i(17781);
      paramString = a.Gx(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(17781);
        return null;
      }
      paramString = paramString.jDN;
      AppMethodBeat.o(17781);
      return paramString;
    }
    
    public static String a(bi parambi, gx paramgx)
    {
      AppMethodBeat.i(17782);
      EmojiInfo localEmojiInfo = b.aVr().aVs().aUI().asP(parambi.field_imgPath);
      if (localEmojiInfo == null)
      {
        AppMethodBeat.o(17782);
        return null;
      }
      Object localObject = a.Gy(localEmojiInfo.Al());
      parambi = (bi)localObject;
      if (localObject == null) {
        parambi = new a.a(localEmojiInfo.Al(), localEmojiInfo.Al(), localEmojiInfo.Al(), localEmojiInfo.Al());
      }
      localObject = new StringWriter();
      try
      {
        XmlSerializer localXmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
        localXmlSerializer.setOutput((Writer)localObject);
        localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
        localXmlSerializer.startTag(null, "msg");
        localXmlSerializer.startTag(null, "emoji");
        localXmlSerializer.attribute(null, "fromusername", paramgx.woP.xJE);
        localXmlSerializer.attribute(null, "tousername", paramgx.woQ.xJE);
        localXmlSerializer.attribute(null, "type", localEmojiInfo.field_type);
        localXmlSerializer.attribute(null, "idbuffer", localEmojiInfo.dzu());
        localXmlSerializer.attribute(null, "md5", parambi.jDO);
        localXmlSerializer.attribute(null, "len", "1024");
        localXmlSerializer.attribute(null, "androidmd5", parambi.jDN);
        localXmlSerializer.attribute(null, "androidlen", "1024");
        localXmlSerializer.attribute(null, "productid", localEmojiInfo.field_groupId);
        localXmlSerializer.endTag(null, "emoji");
        if (localEmojiInfo.vY())
        {
          localXmlSerializer.startTag(null, "gameext");
          paramgx = br.F(localEmojiInfo.getContent(), "gameext");
          parambi = bo.bf((String)paramgx.get(".gameext.$type"), "");
          paramgx = bo.bf((String)paramgx.get(".gameext.$content"), "");
          if ((parambi.equals("")) || (paramgx.equals("")))
          {
            ((StringWriter)localObject).close();
            AppMethodBeat.o(17782);
            return "";
          }
          localXmlSerializer.attribute(null, "type", String.valueOf(parambi));
          localXmlSerializer.attribute(null, "content", String.valueOf(paramgx));
          localXmlSerializer.endTag(null, "gameext");
        }
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        ((StringWriter)localObject).flush();
        ((StringWriter)localObject).close();
        parambi = ((StringWriter)localObject).getBuffer().toString();
        return "";
      }
      catch (XmlPullParserException parambi)
      {
        try
        {
          parambi = parambi.substring(parambi.indexOf(jzf), parambi.indexOf(jzg) + jzg.length());
          ab.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(parambi)));
          AppMethodBeat.o(17782);
          return parambi;
        }
        catch (Exception parambi)
        {
          AppMethodBeat.o(17782);
        }
        parambi = parambi;
        ab.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        AppMethodBeat.o(17782);
        return "";
      }
      catch (IllegalArgumentException parambi)
      {
        ab.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        AppMethodBeat.o(17782);
        return "";
      }
      catch (IllegalStateException parambi)
      {
        ab.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        AppMethodBeat.o(17782);
        return "";
      }
      catch (IOException parambi)
      {
        ab.printErrStackTrace("MicroMsg.EmojiConvert", parambi, "", new Object[0]);
        AppMethodBeat.o(17782);
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.c
 * JD-Core Version:    0.7.0.1
 */