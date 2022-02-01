package com.tencent.mm.chatroom.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.am;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public final class b
{
  public static void F(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(241311);
    Object localObject = new am().kB(paramString);
    ((am)localObject).ila = 2L;
    ((am)localObject).bMH();
    localObject = new f(paramContext, 1, false);
    final View localView = View.inflate(paramContext, a.f.lGl, null);
    Button localButton = (Button)localView.findViewById(a.e.lEH);
    TextView localTextView = (TextView)localView.findViewById(a.e.lEI);
    PAGView localPAGView = (PAGView)localView.findViewById(a.e.lEJ);
    localPAGView.setFile(PAGFile.Load(paramContext.getAssets(), "conv_box_guide_navigation.pag"));
    localPAGView.setRepeatCount(0);
    localPAGView.play();
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(241307);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/util/ConvBoxTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        b.this.cyW();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/util/ConvBoxTip$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241307);
      }
    });
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(241313);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/util/ConvBoxTip$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        b.this.cyW();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(paramContext, "com.tencent.mm.ui.LauncherUI");
        localObject = MMApplicationContext.getDefaultPreference();
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().putBoolean("conversation_box_tip", true).apply();
        }
        paramAnonymousView.setFlags(67108864);
        localObject = paramContext;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/chatroom/util/ConvBoxTip$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject).startActivity((Intent)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/chatroom/util/ConvBoxTip$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView = new am().kB(paramString);
        paramAnonymousView.ila = 3L;
        paramAnonymousView.bMH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/util/ConvBoxTip$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241313);
      }
    });
    ((f)localObject).Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(241301);
        paramAnonymouss.clear();
        b.this.setFooterView(null);
        b.this.setFooterView(localView);
        AppMethodBeat.o(241301);
      }
    };
    ((f)localObject).aeLi = new f.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(241304);
        b.this.stop();
        AppMethodBeat.o(241304);
      }
    };
    ((f)localObject).uR(true);
    ((f)localObject).dDn();
    AppMethodBeat.o(241311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.h.b
 * JD-Core Version:    0.7.0.1
 */