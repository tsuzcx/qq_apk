package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d
  extends f
{
  public int eha = 0;
  public EmojiInfo gWm;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.i.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20233);
    if (paramb.type == 2001) {
      if (this.gWm != null) {
        break label47;
      }
    }
    label47:
    for (paramb = new EmojiInfo();; paramb = this.gWm)
    {
      e.a(paramStringBuilder, paramb, this.eha);
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
      paramb.field_md5 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.md5"));
      paramb.field_type = Util.getInt((String)paramMap.get(".msg.appmsg.emoji.type"), 0);
      paramb.field_width = Util.getInt((String)paramMap.get(".msg.appmsg.emoji.width"), 0);
      paramb.field_height = Util.getInt((String)paramMap.get(".msg.appmsg.emoji.height"), 0);
      paramb.field_size = Util.getInt((String)paramMap.get(".msg.appmsg.emoji.len"), 0);
      paramb.field_aeskey = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.aeskey"));
      paramb.field_cdnUrl = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.cdnurl"));
      paramb.field_encrypturl = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.encrypturl"));
      paramb.field_externUrl = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externurl"));
      paramb.field_externMd5 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.externmd5"));
      paramb.field_groupId = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.productid"));
      paramb.field_designerID = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.designerid"));
      paramb.field_attachedText = Util.nullAsNil((String)paramMap.get(".msg.appmsg.emoji.attachedtext"));
      paramb.field_temp = 1;
      paramb.field_catalog = EmojiInfo.Uup;
      paramb.field_state = EmojiInfo.UuF;
      this.gWm = paramb;
      this.eha = Util.getInt((String)paramMap.get(".msg.appmsg.emoji.localreceivestatus"), 0);
      if (k.getEmojiStorageMgr().OpN.blk(paramb.field_md5) == null) {
        k.getEmojiStorageMgr().OpN.J(this.gWm);
      }
      Log.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", new Object[] { this.gWm });
    }
    AppMethodBeat.o(20234);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(20232);
    d locald = new d();
    AppMethodBeat.o(20232);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.d
 * JD-Core Version:    0.7.0.1
 */