package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class MassSendMsgUI$10
  implements AppPanel.a
{
  MassSendMsgUI$10(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void bPA() {}
  
  public final void bPB() {}
  
  public final void bPo()
  {
    AppMethodBeat.i(22834);
    Toast.makeText(this.oCj, this.oCj.getString(2131301540), 0).show();
    AppMethodBeat.o(22834);
  }
  
  public final void bPp()
  {
    AppMethodBeat.i(22835);
    Toast.makeText(this.oCj, this.oCj.getString(2131301522), 0).show();
    AppMethodBeat.o(22835);
  }
  
  public final void bPq()
  {
    AppMethodBeat.i(22836);
    Toast.makeText(this.oCj, this.oCj.getString(2131301538), 0).show();
    AppMethodBeat.o(22836);
  }
  
  public final void bPr()
  {
    AppMethodBeat.i(22837);
    Toast.makeText(this.oCj, this.oCj.getString(2131301531), 0).show();
    AppMethodBeat.o(22837);
  }
  
  public final void bPs()
  {
    AppMethodBeat.i(22838);
    Toast.makeText(this.oCj, this.oCj.getString(2131301522), 0).show();
    AppMethodBeat.o(22838);
  }
  
  public final void bPt()
  {
    AppMethodBeat.i(22840);
    a.gmO.bo(this.oCj);
    AppMethodBeat.o(22840);
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(22841);
    Toast.makeText(this.oCj, this.oCj.getString(2131301522), 0).show();
    AppMethodBeat.o(22841);
  }
  
  public final void bPv() {}
  
  public final void bPw()
  {
    AppMethodBeat.i(22842);
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 13);
    d.b(this.oCj, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
    AppMethodBeat.o(22842);
  }
  
  public final void bPx()
  {
    AppMethodBeat.i(22844);
    Toast.makeText(this.oCj, this.oCj.getString(2131301532), 0).show();
    AppMethodBeat.o(22844);
  }
  
  public final void bPy() {}
  
  public final void bPz() {}
  
  public final void d(f paramf) {}
  
  public final void yQ(int paramInt)
  {
    AppMethodBeat.i(22839);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22839);
      return;
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.oCj, 1, 1, 0, 3, null);
      AppMethodBeat.o(22839);
      return;
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(e.esr);
      if ((!localb.exists()) && (!localb.mkdirs()))
      {
        Toast.makeText(this.oCj, this.oCj.getString(2131298329), 1).show();
        AppMethodBeat.o(22839);
        return;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.oCj.getContext(), "android.permission.CAMERA", 16, "", "");
      ab.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this.oCj.getContext() });
      if (!bool)
      {
        AppMethodBeat.o(22839);
        return;
      }
      MassSendMsgUI.c(this.oCj);
    }
  }
  
  public final void yR(int paramInt)
  {
    AppMethodBeat.i(22843);
    MassSendMsgUI.a(this.oCj, paramInt);
    AppMethodBeat.o(22843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.10
 * JD-Core Version:    0.7.0.1
 */