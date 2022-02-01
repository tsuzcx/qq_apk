package com.tencent.mm.plugin.gamelife.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.c;
import com.tencent.mm.plugin.gamelife.c.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "FROM_USER_NAME", "", "getFROM_USER_NAME", "()Ljava/lang/String;", "setFROM_USER_NAME", "(Ljava/lang/String;)V", "TO_USER_NAME", "getTO_USER_NAME", "setTO_USER_NAME", "switchBlackList", "", "getSwitchBlackList", "()Z", "setSwitchBlackList", "(Z)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTestUsername", "Companion", "plugin-gamelife_release"})
public final class TestUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.TestUI";
  private static final String ydw = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String ydx = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  private static String ydy;
  public static final a ydz;
  private HashMap _$_findViewCache;
  String ydt = ydw;
  String ydu = ydx;
  boolean ydv = true;
  
  static
  {
    AppMethodBeat.i(241557);
    ydz = new a((byte)0);
    TAG = "MicroMsg.TestUI";
    ydw = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    ydx = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    ydy = "S1_BgAAdQoEcfnVwzCiSbiVnB7BOg@gamelifesess";
    AppMethodBeat.o(241557);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(241559);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(241559);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(241558);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(241558);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494974;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241556);
    super.onCreate(paramBundle);
    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    paramBundle = com.tencent.mm.kernel.a.ayV();
    if (paramBundle == null) {}
    for (;;)
    {
      ((Button)findViewById(2131302125)).setOnClickListener((View.OnClickListener)new b(this));
      ((Button)findViewById(2131302119)).setOnClickListener((View.OnClickListener)new j(this));
      ((Button)findViewById(2131302116)).setOnClickListener((View.OnClickListener)new k(this));
      ((Button)findViewById(2131307650)).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)findViewById(2131307651)).setOnClickListener((View.OnClickListener)new m(this));
      ((Button)findViewById(2131302118)).setOnClickListener((View.OnClickListener)n.ydE);
      ((Button)findViewById(2131307658)).setOnClickListener((View.OnClickListener)o.ydF);
      ((Button)findViewById(2131309567)).setOnClickListener((View.OnClickListener)p.ydG);
      ((Button)findViewById(2131299718)).setOnClickListener((View.OnClickListener)q.ydH);
      ((Button)findViewById(2131297966)).setOnClickListener((View.OnClickListener)c.ydB);
      findViewById(2131302021);
      ((Button)findViewById(2131307631)).setOnClickListener((View.OnClickListener)new d(this));
      ((Button)_$_findCachedViewById(2131299241)).setOnClickListener((View.OnClickListener)new e(this));
      ((Button)_$_findCachedViewById(2131298742)).setOnClickListener((View.OnClickListener)f.ydC);
      ((Button)_$_findCachedViewById(2131300695)).setOnClickListener((View.OnClickListener)new TestUI.g(this));
      ((Button)_$_findCachedViewById(2131308362)).setOnClickListener((View.OnClickListener)new h(this));
      ((Button)_$_findCachedViewById(2131299481)).setOnClickListener((View.OnClickListener)TestUI.i.ydD);
      AppMethodBeat.o(241556);
      return;
      switch (paramBundle.hashCode())
      {
      default: 
        break;
      case -1552608050: 
        if (paramBundle.equals("3191137690"))
        {
          this.ydu = ydx;
          this.ydt = ydw;
        }
        break;
      case 226066304: 
        if (paramBundle.equals("3193176932"))
        {
          this.ydu = ydw;
          this.ydt = ydx;
        }
        break;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI$Companion;", "", "()V", "SESSION_ID", "", "getSESSION_ID", "()Ljava/lang/String;", "setSESSION_ID", "(Ljava/lang/String;)V", "T1_USERNAME", "getT1_USERNAME", "T2_USERNAME", "getT2_USERNAME", "TAG", "getTAG", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241533);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = this.ydA.ydu;
      localObject = this.ydA.ydt;
      p.h(paramView, "fromUserName");
      p.h(localObject, "toUserName");
      Log.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getChatSessionId, fromUsrName = " + paramView + " , toUserName = " + (String)localObject);
      new c(paramView, (String)localObject, 0, null).aYI();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241533);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c ydB;
    
    static
    {
      AppMethodBeat.i(241535);
      ydB = new c();
      AppMethodBeat.o(241535);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241534);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = TestUI.ydz;
      g.a.d(TestUI.dXv(), 2L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241534);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241536);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = TestUI.ydz;
      paramView = new com.tencent.mm.plugin.byp.b.d(TestUI.dXv(), this.ydA.ydu, this.ydA.ydt, "this is the first gamelife text");
      aa.iNn.azA().b((q)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241536);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241537);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.ydA;
      localObject = new Intent((Context)this.ydA, GameLifeConversationUI.class);
      ((Intent)localObject).putExtra("TEST", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241537);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    public static final f ydC;
    
    static
    {
      AppMethodBeat.i(241539);
      ydC = new f();
      AppMethodBeat.o(241539);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241538);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).clearDB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241538);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241541);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).enterChattingUI((Context)this.ydA, this.ydA.ydu, this.ydA.ydt, 0, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241541);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241544);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = new LinkedList((Collection)j.listOf(new String[] { this.ydA.ydu, this.ydA.ydt }));
      p.h(paramView, "userNameList");
      Log.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getChatUserInfo, userNameList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.d(paramView).aYI();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241544);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241545);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = this.ydA.ydt;
      p.h(paramView, "userName");
      Log.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getBlackList, userName = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.a(paramView).aYI();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241545);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241546);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      g.a.h(this.ydA.ydt, this.ydA.ydv, false);
      paramView = this.ydA;
      if (!this.ydA.ydv) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.ydv = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241546);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241547);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      g.a.h(this.ydA.ydt, this.ydA.ydv, true);
      paramView = this.ydA;
      if (!this.ydA.ydv) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.ydv = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(241547);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n ydE;
    
    static
    {
      AppMethodBeat.i(241549);
      ydE = new n();
      AppMethodBeat.o(241549);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241548);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = TestUI.ydz;
      paramView = new LinkedList((Collection)j.listOf(TestUI.dXv()));
      p.h(paramView, "sessionIdList");
      Log.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getSessionData, sesseionIdList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.b(paramView).aYI();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241548);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o ydF;
    
    static
    {
      AppMethodBeat.i(241551);
      ydF = new o();
      AppMethodBeat.o(241551);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241550);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = TestUI.ydz;
      g.a.d(TestUI.dXv(), 1L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241550);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    public static final p ydG;
    
    static
    {
      AppMethodBeat.i(241553);
      ydG = new p();
      AppMethodBeat.o(241553);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241552);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = TestUI.ydz;
      g.a.d(TestUI.dXv(), 1L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241552);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    public static final q ydH;
    
    static
    {
      AppMethodBeat.i(241555);
      ydH = new q();
      AppMethodBeat.o(241555);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(241554);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.gamelife.c.g.ybA;
      paramView = TestUI.ydz;
      g.a.d(TestUI.dXv(), 2L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI
 * JD-Core Version:    0.7.0.1
 */