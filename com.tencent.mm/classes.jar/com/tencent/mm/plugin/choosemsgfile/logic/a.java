package com.tencent.mm.plugin.choosemsgfile.logic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.a.h;
import com.tencent.mm.plugin.choosemsgfile.logic.c.b;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.c;

public final class a
  implements com.tencent.mm.choosemsgfile.compat.a
{
  public final void a(Activity paramActivity, final String paramString1, int paramInt, String paramString2, final com.tencent.mm.choosemsgfile.compat.a.a parama)
  {
    AppMethodBeat.i(170096);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("scene_from", 11);
    localIntent.putExtra("Select_Conv_ui_title", paramActivity.getString(a.h.choose_msg_file_select_conversation));
    localIntent.putExtra("KChooseMsgFileType", paramString1);
    localIntent.putExtra("KChooseMsgFileCount", paramInt);
    localIntent.putExtra("KChooseMsgFileExtension", paramString2);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", com.tencent.mm.plugin.choosemsgfile.a.a.push_up_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", com.tencent.mm.plugin.choosemsgfile.a.a.push_down_out);
    paramString1 = new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123221);
        Log.i("MicroMsg.ChooseMsgFileService", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Log.d("MicroMsg.ChooseMsgFileService", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.logic.c.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, parama);
        AppMethodBeat.o(123221);
      }
    };
    if ((paramActivity instanceof e.e)) {
      e.bt(paramActivity).b(new e.c()
      {
        public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(170094);
          if (b.wQM == paramAnonymousInt1)
          {
            paramString1.mmOnActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
            AppMethodBeat.o(170094);
            return true;
          }
          AppMethodBeat.o(170094);
          return false;
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.br.c.d(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, b.wQM);
      AppMethodBeat.o(170096);
      return;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).mmSetOnActivityResultCallback(paramString1);
      } else if ((paramActivity instanceof MMFragmentActivity)) {
        ((MMFragmentActivity)paramActivity).setMMOnFragmentActivityResult(new MMFragmentActivity.c()
        {
          public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(170095);
            paramString1.mmOnActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
            AppMethodBeat.o(170095);
          }
        });
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, com.tencent.mm.choosemsgfile.compat.a.a parama)
  {
    AppMethodBeat.i(123223);
    if ("file".equals(paramString2))
    {
      ChooseMsgFileListUI.a(paramMMActivity, paramString1, paramInt, paramString3, parama);
      AppMethodBeat.o(123223);
      return;
    }
    ChooseMsgFileUI.a(paramMMActivity, paramString1, paramString2, paramInt, paramString3, parama);
    AppMethodBeat.o(123223);
  }
  
  public final void k(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123222);
    ChooseMsgFileShowUI.x(paramContext, paramString1, paramString2);
    AppMethodBeat.o(123222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a
 * JD-Core Version:    0.7.0.1
 */