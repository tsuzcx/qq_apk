package com.tencent.mm.plugin.choosemsgfile.b;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements com.tencent.mm.choosemsgfile.compat.a
{
  public final void a(MMActivity paramMMActivity, String paramString1, int paramInt, String paramString2, a.a parama)
  {
    AppMethodBeat.i(54252);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("scene_from", 11);
    localIntent.putExtra("Select_Conv_ui_title", paramMMActivity.getContext().getString(2131298366));
    localIntent.putExtra("KChooseMsgFileType", paramString1);
    localIntent.putExtra("KChooseMsgFileCount", paramInt);
    localIntent.putExtra("KChooseMsgFileExtension", paramString2);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2131034230);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    d.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, 291, new a.1(this, parama));
    AppMethodBeat.o(54252);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, a.a parama)
  {
    AppMethodBeat.i(54251);
    if ("file".equals(paramString2))
    {
      ChooseMsgFileListUI.b(paramMMActivity, paramString1, paramInt, paramString3, parama);
      AppMethodBeat.o(54251);
      return;
    }
    ChooseMsgFileUI.a(paramMMActivity, paramString1, paramString2, paramInt, paramString3, parama);
    AppMethodBeat.o(54251);
  }
  
  public final void h(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54250);
    ChooseMsgFileShowUI.q(paramContext, paramString1, paramString2);
    AppMethodBeat.o(54250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a
 * JD-Core Version:    0.7.0.1
 */