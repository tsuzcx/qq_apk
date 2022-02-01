package com.tencent.mm.chatroom.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.SeeRoomManagerUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a
  implements e.b
{
  public com.tencent.mm.chatroom.e.a grL;
  
  public a()
  {
    AppMethodBeat.i(12445);
    this.grL = new com.tencent.mm.chatroom.e.a();
    AppMethodBeat.o(12445);
  }
  
  public final CharSequence a(final Map<String, String> paramMap, String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(194011);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramString = (String)paramMap.get(paramString + ".title");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194011);
      return "";
    }
    SpannableString localSpannableString = l.c(MMApplicationContext.getContext(), paramString);
    localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
    {
      public final void onClickImp(View paramAnonymousView)
      {
        AppMethodBeat.i(12444);
        if ((paramWeakReference != null) && (paramWeakReference.get() != null))
        {
          Object localObject = paramBundle.getString("conv_talker_username");
          paramAnonymousView = (Context)paramWeakReference.get();
          Intent localIntent = new Intent(paramAnonymousView, SeeRoomManagerUI.class);
          localIntent.setFlags(32768);
          localIntent.putExtra("RoomInfo_Id", (String)localObject);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/chatroom/manager/ChatroomNewXmlMgr$1", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/chatroom/manager/ChatroomNewXmlMgr$1", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((e)g.af(e.class)).a("link_admin_explain", paramMap, paramBundle);
        }
        AppMethodBeat.o(12444);
      }
    }, 0, paramString.length(), 33);
    localSpannableStringBuilder.append(localSpannableString);
    AppMethodBeat.o(194011);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.a
 * JD-Core Version:    0.7.0.1
 */