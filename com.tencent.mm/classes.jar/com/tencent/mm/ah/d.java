package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d
  extends f
{
  public int dBB = 0;
  public EmojiInfo fPB;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20233);
    if (paramb.type == 2001) {
      if (this.fPB != null) {
        break label47;
      }
    }
    label47:
    for (paramb = new EmojiInfo();; paramb = this.fPB)
    {
      e.a(paramStringBuilder, paramb, this.dBB);
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
      paramb.field_md5 = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.md5"));
      paramb.field_type = bs.getInt((String)paramMap.get(".msg.appmsg.emoji.type"), 0);
      paramb.field_width = bs.getInt((String)paramMap.get(".msg.appmsg.emoji.width"), 0);
      paramb.field_height = bs.getInt((String)paramMap.get(".msg.appmsg.emoji.height"), 0);
      paramb.field_size = bs.getInt((String)paramMap.get(".msg.appmsg.emoji.len"), 0);
      paramb.field_aeskey = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.aeskey"));
      paramb.field_cdnUrl = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.cdnurl"));
      paramb.field_encrypturl = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.encrypturl"));
      paramb.field_externUrl = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externurl"));
      paramb.field_externMd5 = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externmd5"));
      paramb.field_groupId = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.productid"));
      paramb.field_designerID = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.designerid"));
      paramb.field_attachedText = bs.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.attachedtext"));
      paramb.field_temp = 1;
      paramb.field_catalog = EmojiInfo.Jss;
      paramb.field_state = EmojiInfo.Kgh;
      this.fPB = paramb;
      this.dBB = bs.getInt((String)paramMap.get(".msg.appmsg.emoji.localreceivestatus"), 0);
      if (k.getEmojiStorageMgr().GXZ.aOT(paramb.field_md5) == null) {
        k.getEmojiStorageMgr().GXZ.J(this.fPB);
      }
      ac.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", new Object[] { this.fPB });
    }
    AppMethodBeat.o(20234);
  }
  
  public final f alG()
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