package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class f
  extends com.tencent.mm.al.a<dsm>
{
  public f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    dsl localdsl = new dsl();
    dsm localdsm = new dsm();
    localdsl.MD5 = paramEmojiInfo.field_md5;
    localdsl.HFo = true;
    localdsl.HFj = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.gzP();
    if (localArrayList != null) {
      localdsl.HFk.addAll((Collection)localArrayList);
    }
    localdsl.GdZ = paramEmojiInfo.field_attachedText;
    localdsl.Gea = paramEmojiInfo.field_attachTextColor;
    localdsl.HFl = paramEmojiInfo.field_imitateMd5;
    localdsl.Geb = paramEmojiInfo.field_lensId;
    localdsl.Scene = 0;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.c((com.tencent.mm.bx.a)localdsl);
    paramEmojiInfo.d((com.tencent.mm.bx.a)localdsm);
    paramEmojiInfo.Dl("/cgi-bin/micromsg-bin/mmuploademojiprepare");
    paramEmojiInfo.oP(3886);
    c(paramEmojiInfo.aDC());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */