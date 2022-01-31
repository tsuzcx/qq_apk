package com.tencent.mm.plugin.masssend.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class MassSendMsgUI$8
  implements TextWatcher
{
  MassSendMsgUI$8(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = String.valueOf(paramCharSequence);
    String str = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
    Bitmap localBitmap;
    if (((MassSendMsgUI.a(this.mbI) == null) || (!MassSendMsgUI.a(this.mbI).isShowing())) && (o.YY(str)))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.c.e(str, 300, 300, false);
      if (localBitmap == null) {
        y.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
      }
    }
    else
    {
      return;
    }
    ImageView localImageView = new ImageView(this.mbI);
    localImageView.setImageBitmap(localBitmap);
    paramInt2 = this.mbI.getResources().getDimensionPixelSize(R.f.LargePadding);
    localImageView.setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
    MassSendMsgUI.a(this.mbI, h.a(this.mbI, this.mbI.getString(R.l.chatting_send_img_confirm), localImageView, this.mbI.getString(R.l.app_ok), this.mbI.getString(R.l.app_cancel), new MassSendMsgUI.8.1(this, str), null));
    paramCharSequence = paramCharSequence.substring(0, paramInt1) + paramCharSequence.substring(paramInt1 + paramInt3);
    MassSendMsgUI.b(this.mbI).r(paramCharSequence, -1, false);
    MassSendMsgUI.EM(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.8
 * JD-Core Version:    0.7.0.1
 */