package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class e
  extends c<dhg>
{
  public e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(105501);
    dhf localdhf = new dhf();
    dhg localdhg = new dhg();
    localdhf.MD5 = paramEmojiInfo.field_md5;
    localdhf.Exy = true;
    localdhf.Ext = paramBoolean;
    ArrayList localArrayList = paramEmojiInfo.fZZ();
    if (localArrayList != null) {
      localdhf.Exu.addAll((Collection)localArrayList);
    }
    localdhf.Ddq = paramEmojiInfo.field_attachedText;
    localdhf.Ddr = paramEmojiInfo.field_attachTextColor;
    localdhf.Exv = paramEmojiInfo.field_imitateMd5;
    localdhf.Dds = paramEmojiInfo.field_lensId;
    localdhf.Scene = 0;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.c((a)localdhf);
    paramEmojiInfo.d((a)localdhg);
    paramEmojiInfo.wg("/cgi-bin/micromsg-bin/mmuploademojiprepare");
    paramEmojiInfo.nB(3886);
    c(paramEmojiInfo.atI());
    AppMethodBeat.o(105501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */