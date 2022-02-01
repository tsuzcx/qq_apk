package com.tencent.mm.plugin.choosemsgfile.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.h.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI;
import com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;

public final class a
  implements com.tencent.mm.choosemsgfile.compat.a
{
  public final void a(Activity paramActivity, final String paramString1, int paramInt, String paramString2, final a.a parama)
  {
    AppMethodBeat.i(170096);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("scene_from", 11);
    localIntent.putExtra("Select_Conv_ui_title", paramActivity.getString(2131757576));
    localIntent.putExtra("KChooseMsgFileType", paramString1);
    localIntent.putExtra("KChooseMsgFileCount", paramInt);
    localIntent.putExtra("KChooseMsgFileExtension", paramString2);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772132);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
    paramString1 = new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(123221);
        Log.i("MicroMsg.ChooseMsgFileService", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Log.d("MicroMsg.ChooseMsgFileService", "data:%s", new Object[] { paramAnonymousIntent });
        com.tencent.mm.plugin.choosemsgfile.b.d.c.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent, parama);
        AppMethodBeat.o(123221);
      }
    };
    if ((paramActivity instanceof f.e)) {
      f.aK(paramActivity).b(new f.c()
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(170094);
          if (b.qoN == paramAnonymousInt1)
          {
            paramString1.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
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
      com.tencent.mm.br.c.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, b.qoN);
      AppMethodBeat.o(170096);
      return;
      if ((paramActivity instanceof MMActivity)) {
        ((MMActivity)paramActivity).mmSetOnActivityResultCallback(paramString1);
      } else if ((paramActivity instanceof MMFragmentActivity)) {
        ((MMFragmentActivity)paramActivity).setMMOnFragmentActivityResult(new MMFragmentActivity.b()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(170095);
            paramString1.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
            AppMethodBeat.o(170095);
          }
        });
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt, String paramString3, a.a parama)
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
  
  public final void g(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123222);
    ChooseMsgFileShowUI.t(paramContext, paramString1, paramString2);
    AppMethodBeat.o(123222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a
 * JD-Core Version:    0.7.0.1
 */