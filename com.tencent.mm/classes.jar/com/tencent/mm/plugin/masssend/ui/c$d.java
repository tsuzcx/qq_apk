package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class c$d
  implements View.OnClickListener
{
  private String id;
  
  public c$d(c paramc, String paramString)
  {
    this.id = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26408);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
    if (c.b(this.znT) != null)
    {
      c.a(this.znT, c.b(this.znT).aDQ(this.id));
      this.znT.notifyDataSetChanged();
    }
    a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.d
 * JD-Core Version:    0.7.0.1
 */