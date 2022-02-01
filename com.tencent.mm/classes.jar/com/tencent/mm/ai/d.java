package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d
  extends f
{
  public int dNO = 0;
  public EmojiInfo gjb;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20233);
    if (paramb.type == 2001) {
      if (this.gjb != null) {
        break label47;
      }
    }
    label47:
    for (paramb = new EmojiInfo();; paramb = this.gjb)
    {
      e.a(paramStringBuilder, paramb, this.dNO);
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
      paramb.field_md5 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.md5"));
      paramb.field_type = bt.getInt((String)paramMap.get(".msg.appmsg.emoji.type"), 0);
      paramb.field_width = bt.getInt((String)paramMap.get(".msg.appmsg.emoji.width"), 0);
      paramb.field_height = bt.getInt((String)paramMap.get(".msg.appmsg.emoji.height"), 0);
      paramb.field_size = bt.getInt((String)paramMap.get(".msg.appmsg.emoji.len"), 0);
      paramb.field_aeskey = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.aeskey"));
      paramb.field_cdnUrl = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.cdnurl"));
      paramb.field_encrypturl = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.encrypturl"));
      paramb.field_externUrl = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externurl"));
      paramb.field_externMd5 = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externmd5"));
      paramb.field_groupId = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.productid"));
      paramb.field_designerID = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.designerid"));
      paramb.field_attachedText = bt.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.attachedtext"));
      paramb.field_temp = 1;
      paramb.field_catalog = EmojiInfo.OeN;
      paramb.field_state = EmojiInfo.Ofd;
      this.gjb = paramb;
      this.dNO = bt.getInt((String)paramMap.get(".msg.appmsg.emoji.localreceivestatus"), 0);
      if (k.getEmojiStorageMgr().ILn.aUK(paramb.field_md5) == null) {
        k.getEmojiStorageMgr().ILn.I(this.gjb);
      }
      ad.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", new Object[] { this.gjb });
    }
    AppMethodBeat.o(20234);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(20232);
    d locald = new d();
    AppMethodBeat.o(20232);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.d
 * JD-Core Version:    0.7.0.1
 */