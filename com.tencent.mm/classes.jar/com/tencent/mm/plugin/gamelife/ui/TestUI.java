package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.g;
import com.tencent.mm.plugin.gamelife.c.g.a;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.plugin.gamelife.f.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "FROM_USER_NAME", "", "getFROM_USER_NAME", "()Ljava/lang/String;", "setFROM_USER_NAME", "(Ljava/lang/String;)V", "TO_USER_NAME", "getTO_USER_NAME", "setTO_USER_NAME", "switchBlackList", "", "getSwitchBlackList", "()Z", "setSwitchBlackList", "(Z)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTestUsername", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TestUI
  extends MMActivity
{
  public static final TestUI.a JcD;
  private static final String JcH;
  private static final String JcI;
  private static String JcJ;
  private static final String TAG;
  private String JcE = JcH;
  private String JcF = JcI;
  private boolean JcG = true;
  
  static
  {
    AppMethodBeat.i(267986);
    JcD = new TestUI.a((byte)0);
    TAG = "MicroMsg.TestUI";
    JcH = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    JcI = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    JcJ = "S1_BgAAdQoEcfnVwzCiSbiVnB7BOg@gamelifesess";
    AppMethodBeat.o(267986);
  }
  
  private static final void a(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267860);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = g.JaZ;
    paramView = paramTestUI.JcF;
    paramTestUI = paramTestUI.JcE;
    kotlin.g.b.s.u(paramView, "fromUserName");
    kotlin.g.b.s.u(paramTestUI, "toUserName");
    Log.i(g.access$getTAG$cp(), "getChatSessionId, fromUsrName = " + paramView + " , toUserName = " + paramTestUI);
    new com.tencent.mm.plugin.gamelife.c.c(paramView, paramTestUI, 0, null).bFJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267860);
  }
  
  private static final void b(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267865);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = g.JaZ;
    paramTestUI = new LinkedList((Collection)kotlin.a.p.listOf(new String[] { paramTestUI.JcF, paramTestUI.JcE }));
    kotlin.g.b.s.u(paramTestUI, "userNameList");
    Log.i(g.access$getTAG$cp(), kotlin.g.b.s.X("getChatUserInfo, userNameList = ", paramTestUI));
    new com.tencent.mm.plugin.gamelife.c.d(paramTestUI).bFJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267865);
  }
  
  private static final void c(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267868);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = g.JaZ;
    paramTestUI = paramTestUI.JcE;
    kotlin.g.b.s.u(paramTestUI, "userName");
    Log.i(g.access$getTAG$cp(), kotlin.g.b.s.X("getBlackList, userName = ", paramTestUI));
    new com.tencent.mm.plugin.gamelife.c.a(paramTestUI).bFJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267868);
  }
  
  private static final void d(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267878);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = g.JaZ;
    g.a.j(paramTestUI.JcE, paramTestUI.JcG, false);
    if (!paramTestUI.JcG) {}
    for (boolean bool = true;; bool = false)
    {
      paramTestUI.JcG = bool;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267878);
      return;
    }
  }
  
  private static final void e(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267885);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = g.JaZ;
    g.a.j(paramTestUI.JcE, paramTestUI.JcG, true);
    if (!paramTestUI.JcG) {}
    for (boolean bool = true;; bool = false)
    {
      paramTestUI.JcG = bool;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267885);
      return;
    }
  }
  
  private static final void f(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267934);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramTestUI = new com.tencent.mm.plugin.byp.b.d(JcJ, paramTestUI.JcF, paramTestUI.JcE, "this is the first gamelife text");
    z.ovg.aZX().a((com.tencent.mm.am.p)paramTestUI, 0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267934);
  }
  
  private static final void g(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267949);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = new Intent((Context)paramTestUI, GameLifeConversationUI.class);
    paramView.putExtra("TEST", true);
    localObject = ah.aiuX;
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramTestUI, paramView.aYi(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "onCreate$lambda-12", "(Lcom/tencent/mm/plugin/gamelife/ui/TestUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramTestUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramTestUI, "com/tencent/mm/plugin/gamelife/ui/TestUI", "onCreate$lambda-12", "(Lcom/tencent/mm/plugin/gamelife/ui/TestUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267949);
  }
  
  private static final void h(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267963);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    paramView = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject = new com.tencent.mm.plugin.gamelife.f.a();
      ((com.tencent.mm.plugin.gamelife.f.a)localObject).field_sessionId = kotlin.g.b.s.X("test", Integer.valueOf(i));
      ((com.tencent.mm.plugin.gamelife.f.a)localObject).field_digest = kotlin.g.b.s.X("digest", Integer.valueOf(i));
      ((com.tencent.mm.plugin.gamelife.f.a)localObject).field_updateTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.gamelife.f.a)localObject).field_talker = kotlin.g.b.s.X("talker", Integer.valueOf(i));
      ((com.tencent.mm.plugin.gamelife.f.a)localObject).field_selfUserName = paramTestUI.JcF;
      paramView.insert((IAutoDBItem)localObject);
      if (j > 50)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267963);
        return;
      }
    }
  }
  
  private static final void hA(View paramView)
  {
    AppMethodBeat.i(267906);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = g.JaZ;
    g.a.c(JcJ, 1L, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267906);
  }
  
  private static final void hB(View paramView)
  {
    AppMethodBeat.i(267915);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = g.JaZ;
    g.a.c(JcJ, 2L, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267915);
  }
  
  private static final void hC(View paramView)
  {
    AppMethodBeat.i(267924);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = g.JaZ;
    g.a.c(JcJ, 2L, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267924);
  }
  
  private static final void hD(View paramView)
  {
    AppMethodBeat.i(267956);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    ((PluginGameLife)h.az(PluginGameLife.class)).clearDB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267956);
  }
  
  private static final void hE(View paramView)
  {
    AppMethodBeat.i(267977);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
    ((com.tencent.mm.plugin.gamelife.a.c)h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aHw(((com.tencent.mm.plugin.gamelife.f.a)paramView.fg(0, 1).get(0)).field_sessionId);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267977);
  }
  
  private static final void hy(View paramView)
  {
    AppMethodBeat.i(267894);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = g.JaZ;
    paramView = new LinkedList((Collection)kotlin.a.p.listOf(JcJ));
    kotlin.g.b.s.u(paramView, "sessionIdList");
    Log.i(g.access$getTAG$cp(), kotlin.g.b.s.X("getSessionData, sesseionIdList = ", paramView));
    new com.tencent.mm.plugin.gamelife.c.b(paramView).bFJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267894);
  }
  
  private static final void hz(View paramView)
  {
    AppMethodBeat.i(267898);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = g.JaZ;
    g.a.c(JcJ, 1L, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267898);
  }
  
  private static final void i(TestUI paramTestUI, View paramView)
  {
    AppMethodBeat.i(267970);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramTestUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramTestUI, "this$0");
    ((PluginGameLife)h.az(PluginGameLife.class)).enterChattingUI((Context)paramTestUI, paramTestUI.JcF, paramTestUI.JcE, 0, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gamelife/ui/TestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267970);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return d.d.IZZ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(268105);
    super.onCreate(paramBundle);
    h.baC();
    paramBundle = com.tencent.mm.kernel.b.aZs();
    if (kotlin.g.b.s.p(paramBundle, "3193176932"))
    {
      this.JcF = JcH;
      this.JcE = JcI;
    }
    for (;;)
    {
      ((Button)findViewById(d.c.IZP)).setOnClickListener(new TestUI..ExternalSyntheticLambda7(this));
      ((Button)findViewById(d.c.IZO)).setOnClickListener(new TestUI..ExternalSyntheticLambda3(this));
      ((Button)findViewById(d.c.IZM)).setOnClickListener(new TestUI..ExternalSyntheticLambda0(this));
      ((Button)findViewById(d.c.IZT)).setOnClickListener(new TestUI..ExternalSyntheticLambda4(this));
      ((Button)findViewById(d.c.IZU)).setOnClickListener(new TestUI..ExternalSyntheticLambda5(this));
      ((Button)findViewById(d.c.IZN)).setOnClickListener(TestUI..ExternalSyntheticLambda11.INSTANCE);
      ((Button)findViewById(d.c.IZV)).setOnClickListener(TestUI..ExternalSyntheticLambda10.INSTANCE);
      ((Button)findViewById(d.c.IZX)).setOnClickListener(TestUI..ExternalSyntheticLambda15.INSTANCE);
      ((Button)findViewById(d.c.IZG)).setOnClickListener(TestUI..ExternalSyntheticLambda12.INSTANCE);
      ((Button)findViewById(d.c.IZz)).setOnClickListener(TestUI..ExternalSyntheticLambda13.INSTANCE);
      findViewById(d.c.IZI);
      ((Button)findViewById(d.c.IZS)).setOnClickListener(new TestUI..ExternalSyntheticLambda6(this));
      ((Button)findViewById(d.c.IZA)).setOnClickListener(new TestUI..ExternalSyntheticLambda2(this));
      ((Button)findViewById(d.c.clear)).setOnClickListener(TestUI..ExternalSyntheticLambda14.INSTANCE);
      ((Button)findViewById(d.c.IZH)).setOnClickListener(new TestUI..ExternalSyntheticLambda8(this));
      ((Button)findViewById(d.c.IZW)).setOnClickListener(new TestUI..ExternalSyntheticLambda1(this));
      ((Button)findViewById(d.c.IZD)).setOnClickListener(TestUI..ExternalSyntheticLambda9.INSTANCE);
      AppMethodBeat.o(268105);
      return;
      if (kotlin.g.b.s.p(paramBundle, "3191137690"))
      {
        this.JcF = JcI;
        this.JcE = JcH;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI
 * JD-Core Version:    0.7.0.1
 */