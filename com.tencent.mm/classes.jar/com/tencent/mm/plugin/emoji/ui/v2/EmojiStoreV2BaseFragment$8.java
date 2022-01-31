package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.p;

final class EmojiStoreV2BaseFragment$8
  implements Runnable
{
  EmojiStoreV2BaseFragment$8(EmojiStoreV2BaseFragment paramEmojiStoreV2BaseFragment, GetEmotionListResponse paramGetEmotionListResponse) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(53578);
    int i;
    if (this.lpa != null)
    {
      if (this.lpa != null) {
        break label95;
      }
      i = 0;
      if (this.lpa != null) {
        break label106;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.loZ.bmb()) });
      i.getEmojiStorageMgr().yNq.a(this.loZ.bmb(), this.lpa);
      AppMethodBeat.o(53578);
      return;
      label95:
      i = this.lpa.EmotionCount;
      break;
      label106:
      if (this.lpa.ReqBuf != null) {
        j = this.lpa.ReqBuf.computeSize();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.8
 * JD-Core Version:    0.7.0.1
 */