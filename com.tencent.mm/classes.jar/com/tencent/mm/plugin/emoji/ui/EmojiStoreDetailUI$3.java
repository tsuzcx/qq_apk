package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class EmojiStoreDetailUI$3
  implements AdapterView.OnItemClickListener
{
  EmojiStoreDetailUI$3(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(53423);
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView instanceof EmojiInfo))
    {
      paramAdapterView = (EmojiInfo)paramAdapterView;
      paramView = new zg();
      if ((bo.isNullOrNil(paramView.Md5)) || (paramView.Md5.equals(paramAdapterView.field_md5)))
      {
        paramView.Md5 = b.dP(paramAdapterView.field_md5, paramView.Md5);
        paramView.Md5 = b.dP(paramView.Md5, "");
        paramView.Url = b.dP(paramAdapterView.field_cdnUrl, paramView.Url);
        paramView.ThumbUrl = b.dP(paramAdapterView.field_thumbUrl, paramView.ThumbUrl);
        paramView.wQg = b.dP(paramAdapterView.field_designerID, paramView.wQg);
        paramView.EncryptUrl = b.dP(paramAdapterView.field_encrypturl, paramView.EncryptUrl);
        paramView.AesKey = b.dP(paramAdapterView.field_aeskey, paramView.AesKey);
        paramView.ProductID = b.dP(paramAdapterView.field_groupId, paramView.ProductID);
        paramView.ExternUrl = b.dP(paramAdapterView.field_externUrl, paramView.ExternUrl);
        paramView.ExternMd5 = b.dP(paramAdapterView.field_externMd5, paramView.ExternMd5);
        paramView.ActivityID = b.dP(paramAdapterView.field_activityid, paramView.ActivityID);
        paramView.wQh = b.dP(paramAdapterView.field_attachedText, paramView.wQh);
        paramView.wQi = b.dP(paramAdapterView.field_attachTextColor, paramView.wQi);
        paramView.wQj = b.dP(paramAdapterView.field_lensId, paramView.wQj);
      }
      EmojiStoreDetailUI.a(this.lnA, paramView);
      h.qsU.e(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(this.lnA)), paramAdapterView.field_designerID, paramAdapterView.field_groupId, Integer.valueOf(26) });
    }
    AppMethodBeat.o(53423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.3
 * JD-Core Version:    0.7.0.1
 */