package com.tencent.mm.plugin.kitchen.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.d;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;
import java.util.HashMap;

final class KvInfoUI$6
  implements AdapterView.OnItemClickListener
{
  KvInfoUI$6(KvInfoUI paramKvInfoUI) {}
  
  public final void onItemClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(114448);
    paramAdapterView = (d)KvInfoUI.b(this.nXL).getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(114448);
      return;
    }
    if ((paramAdapterView.cqq == null) || (paramAdapterView.cqq.length() <= 0)) {
      paramAdapterView.cqq = ag.cE(paramAdapterView.value);
    }
    paramAdapterView = paramAdapterView.cqq;
    paramAdapterView = (String)j.chT().qtm.get(paramAdapterView);
    if (KvInfoUI.c(this.nXL) != null) {
      KvInfoUI.c(this.nXL).dismiss();
    }
    if (!bo.isNullOrNil(paramAdapterView)) {
      KvInfoUI.a(this.nXL, h.a(this.nXL, paramAdapterView, "", this.nXL.getString(2131297018), this.nXL.getString(2131296895), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114446);
          paramAnonymousDialogInterface.cancel();
          AppMethodBeat.o(114446);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114447);
          try
          {
            ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("kv_info", paramAdapterView));
            Toast.makeText(KvInfoUI.6.this.nXL.getContext(), KvInfoUI.6.this.nXL.getContext().getString(2131296896), 0).show();
            AppMethodBeat.o(114447);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            ab.e("MicroMsg.KvInfoUI", "copy error [%s]", new Object[] { paramAnonymousDialogInterface.toString() });
            Toast.makeText(KvInfoUI.6.this.nXL.getContext(), "copy failure", 0).show();
            AppMethodBeat.o(114447);
          }
        }
      }, -1));
    }
    AppMethodBeat.o(114448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.6
 * JD-Core Version:    0.7.0.1
 */