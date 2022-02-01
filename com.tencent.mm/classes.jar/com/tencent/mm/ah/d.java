package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d
  extends f
{
  public int dPe = 0;
  public EmojiInfo glt;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20233);
    if (paramb.type == 2001) {
      if (this.glt != null) {
        break label47;
      }
    }
    label47:
    for (paramb = new EmojiInfo();; paramb = this.glt)
    {
      e.a(paramStringBuilder, paramb, this.dPe);
      AppMethodBeat.o(20233);
      return;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20234);
    if (paramb.type == 2001)
    {
      paramb = new EmojiInfo();
      paramb.field_md5 = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.md5"));
      paramb.field_type = bu.getInt((String)paramMap.get(".msg.appmsg.emoji.type"), 0);
      paramb.field_width = bu.getInt((String)paramMap.get(".msg.appmsg.emoji.width"), 0);
      paramb.field_height = bu.getInt((String)paramMap.get(".msg.appmsg.emoji.height"), 0);
      paramb.field_size = bu.getInt((String)paramMap.get(".msg.appmsg.emoji.len"), 0);
      paramb.field_aeskey = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.aeskey"));
      paramb.field_cdnUrl = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.cdnurl"));
      paramb.field_encrypturl = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.encrypturl"));
      paramb.field_externUrl = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externurl"));
      paramb.field_externMd5 = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externmd5"));
      paramb.field_groupId = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.productid"));
      paramb.field_designerID = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.designerid"));
      paramb.field_attachedText = bu.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.attachedtext"));
      paramb.field_temp = 1;
      paramb.field_catalog = EmojiInfo.OzU;
      paramb.field_state = EmojiInfo.OAk;
      this.glt = paramb;
      this.dPe = bu.getInt((String)paramMap.get(".msg.appmsg.emoji.localreceivestatus"), 0);
      if (k.getEmojiStorageMgr().JfU.aWl(paramb.field_md5) == null) {
        k.getEmojiStorageMgr().JfU.I(this.glt);
      }
      ae.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", new Object[] { this.glt });
    }
    AppMethodBeat.o(20234);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(20232);
    d locald = new d();
    AppMethodBeat.o(20232);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.d
 * JD-Core Version:    0.7.0.1
 */