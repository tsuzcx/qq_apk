package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.luckymoney.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public class d
  extends f
{
  public int ihA = 0;
  public EmojiInfo mgK;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, com.tencent.mm.g.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20233);
    if (paramb.type == 2001) {
      if (this.mgK != null) {
        break label47;
      }
    }
    label47:
    for (paramb = new EmojiInfo();; paramb = this.mgK)
    {
      e.a(paramStringBuilder, paramb, this.ihA);
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
      paramb.field_catalog = EmojiInfo.aklG;
      paramb.field_state = EmojiInfo.aklW;
      this.mgK = paramb;
      this.ihA = Util.getInt((String)paramMap.get(".msg.appmsg.emoji.localreceivestatus"), 0);
      if ((paramMap.get(".msg.appmsg.emoji.localreceivestatus") == null) && (paramMap.get(".msg.appmsg.wcpayinfo.receivestatus") != null)) {
        this.ihA = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.receivestatus"), 0);
      }
      if (s.getEmojiStorageMgr().adju.bza(paramb.field_md5) == null) {
        s.getEmojiStorageMgr().adju.K(this.mgK);
      }
      Log.d("MicroMsg.AppContentLuckyMoneyEmogiPiece", "EmojiInfo: %s", new Object[] { this.mgK });
    }
    AppMethodBeat.o(20234);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(20232);
    d locald = new d();
    AppMethodBeat.o(20232);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.message.d
 * JD-Core Version:    0.7.0.1
 */