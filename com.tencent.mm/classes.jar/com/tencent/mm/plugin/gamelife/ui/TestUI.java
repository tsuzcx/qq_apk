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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "FROM_USER_NAME", "", "getFROM_USER_NAME", "()Ljava/lang/String;", "setFROM_USER_NAME", "(Ljava/lang/String;)V", "TO_USER_NAME", "getTO_USER_NAME", "setTO_USER_NAME", "switchBlackList", "", "getSwitchBlackList", "()Z", "setSwitchBlackList", "(Z)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTestUsername", "Companion", "plugin-gamelife_release"})
public final class TestUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.TestUI";
  public static final a uzA;
  private static final String uzx = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String uzy = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  private static String uzz;
  private HashMap _$_findViewCache;
  String uzu = uzx;
  String uzv = uzy;
  boolean uzw = true;
  
  static
  {
    AppMethodBeat.i(211525);
    uzA = new a((byte)0);
    TAG = "MicroMsg.TestUI";
    uzx = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    uzy = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    uzz = "S1_BgAAdQoEcfnVwzCiSbiVnB7BOg@gamelifesess";
    AppMethodBeat.o(211525);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(211526);
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
    AppMethodBeat.o(211526);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496406;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211524);
    super.onCreate(paramBundle);
    p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
    paramBundle = com.tencent.mm.kernel.a.aiq();
    if (paramBundle == null) {}
    for (;;)
    {
      ((Button)findViewById(2131308132)).setOnClickListener((View.OnClickListener)new b(this));
      ((Button)findViewById(2131308131)).setOnClickListener((View.OnClickListener)new j(this));
      ((Button)findViewById(2131308129)).setOnClickListener((View.OnClickListener)new k(this));
      ((Button)findViewById(2131308200)).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)findViewById(2131308201)).setOnClickListener((View.OnClickListener)new m(this));
      ((Button)findViewById(2131308130)).setOnClickListener((View.OnClickListener)n.uzF);
      ((Button)findViewById(2131308202)).setOnClickListener((View.OnClickListener)o.uzG);
      ((Button)findViewById(2131308223)).setOnClickListener((View.OnClickListener)p.uzH);
      ((Button)findViewById(2131308096)).setOnClickListener((View.OnClickListener)q.uzI);
      ((Button)findViewById(2131302575)).setOnClickListener((View.OnClickListener)c.uzC);
      findViewById(2131308123);
      ((Button)findViewById(2131308199)).setOnClickListener((View.OnClickListener)new d(this));
      ((Button)_$_findCachedViewById(2131306894)).setOnClickListener((View.OnClickListener)new e(this));
      ((Button)_$_findCachedViewById(2131305707)).setOnClickListener((View.OnClickListener)f.uzD);
      ((Button)_$_findCachedViewById(2131308105)).setOnClickListener((View.OnClickListener)new g(this));
      ((Button)_$_findCachedViewById(2131308214)).setOnClickListener((View.OnClickListener)new h(this));
      ((Button)_$_findCachedViewById(2131308081)).setOnClickListener((View.OnClickListener)i.uzE);
      AppMethodBeat.o(211524);
      return;
      switch (paramBundle.hashCode())
      {
      default: 
        break;
      case -1552608050: 
        if (paramBundle.equals("3191137690"))
        {
          this.uzv = uzy;
          this.uzu = uzx;
        }
        break;
      case 226066304: 
        if (paramBundle.equals("3193176932"))
        {
          this.uzv = uzx;
          this.uzu = uzy;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI$Companion;", "", "()V", "SESSION_ID", "", "getSESSION_ID", "()Ljava/lang/String;", "setSESSION_ID", "(Ljava/lang/String;)V", "T1_USERNAME", "getT1_USERNAME", "T2_USERNAME", "getT2_USERNAME", "TAG", "getTAG", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211501);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = this.uzB.uzv;
      localObject = this.uzB.uzu;
      p.h(paramView, "fromUserName");
      p.h(localObject, "toUserName");
      ad.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getChatSessionId, fromUsrName = " + paramView + " , toUserName = " + (String)localObject);
      new com.tencent.mm.plugin.gamelife.c.c(paramView, (String)localObject).aED();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211501);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c uzC;
    
    static
    {
      AppMethodBeat.i(211503);
      uzC = new c();
      AppMethodBeat.o(211503);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211502);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = TestUI.uzA;
      g.a.d(TestUI.daV(), 2L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211502);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211504);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = TestUI.uzA;
      paramView = new com.tencent.mm.plugin.byp.b.c(TestUI.daV(), this.uzB.uzv, this.uzB.uzu, "this is the first gamelife text");
      x.hPm.aiV().b((n)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211504);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211505);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.uzB;
      localObject = new Intent((Context)this.uzB, GameLifeConversationUI.class);
      ((Intent)localObject).putExtra("TEST", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211505);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    public static final f uzD;
    
    static
    {
      AppMethodBeat.i(211507);
      uzD = new f();
      AppMethodBeat.o(211507);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211506);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).clearDB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211506);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211508);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      int i = 0;
      while (i <= 50)
      {
        localObject = new com.tencent.mm.plugin.gamelife.e.a();
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_sessionId = "test".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_digest = "digest".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_updateTime = System.currentTimeMillis();
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_talker = "talker".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_selfUserName = this.uzB.uzv;
        paramView.insert((com.tencent.mm.sdk.e.c)localObject);
        i += 1;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211508);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211509);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterChattingUI((Context)this.uzB, this.uzB.uzv, this.uzB.uzu);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211509);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    public static final i uzE;
    
    static
    {
      AppMethodBeat.i(211511);
      uzE = new i();
      AppMethodBeat.o(211511);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211510);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).amB(((com.tencent.mm.plugin.gamelife.e.a)paramView.dE(0, 1).get(0)).field_sessionId);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211510);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211512);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = new LinkedList((Collection)j.listOf(new String[] { this.uzB.uzv, this.uzB.uzu }));
      p.h(paramView, "userNameList");
      ad.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getChatUserInfo, userNameList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.d(paramView).aED();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211512);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211513);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = this.uzB.uzu;
      p.h(paramView, "userName");
      ad.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getBlackList, userName = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.a(paramView).aED();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211513);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211514);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      g.a.g(this.uzB.uzu, this.uzB.uzw, false);
      paramView = this.uzB;
      if (!this.uzB.uzw) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.uzw = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211514);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211515);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      g.a.g(this.uzB.uzu, this.uzB.uzw, true);
      paramView = this.uzB;
      if (!this.uzB.uzw) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.uzw = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211515);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n uzF;
    
    static
    {
      AppMethodBeat.i(211517);
      uzF = new n();
      AppMethodBeat.o(211517);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211516);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = TestUI.uzA;
      paramView = new LinkedList((Collection)j.listOf(TestUI.daV()));
      p.h(paramView, "sessionIdList");
      ad.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getSessionData, sesseionIdList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.b(paramView).aED();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211516);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o uzG;
    
    static
    {
      AppMethodBeat.i(211519);
      uzG = new o();
      AppMethodBeat.o(211519);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211518);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = TestUI.uzA;
      g.a.d(TestUI.daV(), 1L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211518);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    public static final p uzH;
    
    static
    {
      AppMethodBeat.i(211521);
      uzH = new p();
      AppMethodBeat.o(211521);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211520);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = TestUI.uzA;
      g.a.d(TestUI.daV(), 1L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211520);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    public static final q uzI;
    
    static
    {
      AppMethodBeat.i(211523);
      uzI = new q();
      AppMethodBeat.o(211523);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211522);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uxG;
      paramView = TestUI.uzA;
      g.a.d(TestUI.daV(), 2L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211522);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI
 * JD-Core Version:    0.7.0.1
 */