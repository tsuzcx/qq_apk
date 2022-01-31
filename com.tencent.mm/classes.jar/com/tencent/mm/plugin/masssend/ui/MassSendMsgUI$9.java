package com.tencent.mm.plugin.masssend.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class MassSendMsgUI$9
  implements TextWatcher
{
  MassSendMsgUI$9(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(22833);
    paramCharSequence = String.valueOf(paramCharSequence);
    String str = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
    if (((MassSendMsgUI.a(this.oCj) == null) || (!MassSendMsgUI.a(this.oCj).isShowing())) && (r.aoX(str)))
    {
      Bitmap localBitmap = d.d(str, 300, 300, false);
      if (localBitmap == null)
      {
        ab.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
        AppMethodBeat.o(22833);
        return;
      }
      ImageView localImageView = new ImageView(this.oCj);
      localImageView.setImageBitmap(localBitmap);
      paramInt2 = this.oCj.getResources().getDimensionPixelSize(2131427772);
      localImageView.setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
      MassSendMsgUI.a(this.oCj, h.a(this.oCj, this.oCj.getString(2131298319), localImageView, this.oCj.getString(2131297018), this.oCj.getString(2131296888), new MassSendMsgUI.9.1(this, str), null));
      paramCharSequence = paramCharSequence.substring(0, paramInt1) + paramCharSequence.substring(paramInt1 + paramInt3);
      MassSendMsgUI.b(this.oCj).u(paramCharSequence, -1, false);
      MassSendMsgUI.Qd(paramCharSequence);
    }
    AppMethodBeat.o(22833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.9
 * JD-Core Version:    0.7.0.1
 */