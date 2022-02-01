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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.b;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.c.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "FROM_USER_NAME", "", "getFROM_USER_NAME", "()Ljava/lang/String;", "setFROM_USER_NAME", "(Ljava/lang/String;)V", "TO_USER_NAME", "getTO_USER_NAME", "setTO_USER_NAME", "switchBlackList", "", "getSwitchBlackList", "()Z", "setSwitchBlackList", "(Z)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTestUsername", "Companion", "plugin-gamelife_release"})
public final class TestUI
  extends MMActivity
{
  private static final String TAG = "MicroMsg.TestUI";
  private static final String uLc = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String uLd = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  private static String uLe;
  public static final a uLf;
  private HashMap _$_findViewCache;
  String uKZ = uLc;
  String uLa = uLd;
  boolean uLb = true;
  
  static
  {
    AppMethodBeat.i(212314);
    uLf = new a((byte)0);
    TAG = "MicroMsg.TestUI";
    uLc = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    uLd = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    uLe = "S1_BgAAdQoEcfnVwzCiSbiVnB7BOg@gamelifesess";
    AppMethodBeat.o(212314);
  }
  
  private View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(212315);
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
    AppMethodBeat.o(212315);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496406;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212313);
    super.onCreate(paramBundle);
    p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    paramBundle = com.tencent.mm.kernel.a.aiF();
    if (paramBundle == null) {}
    for (;;)
    {
      ((Button)findViewById(2131308132)).setOnClickListener((View.OnClickListener)new b(this));
      ((Button)findViewById(2131308131)).setOnClickListener((View.OnClickListener)new j(this));
      ((Button)findViewById(2131308129)).setOnClickListener((View.OnClickListener)new k(this));
      ((Button)findViewById(2131308200)).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)findViewById(2131308201)).setOnClickListener((View.OnClickListener)new m(this));
      ((Button)findViewById(2131308130)).setOnClickListener((View.OnClickListener)n.uLk);
      ((Button)findViewById(2131308202)).setOnClickListener((View.OnClickListener)o.uLl);
      ((Button)findViewById(2131308223)).setOnClickListener((View.OnClickListener)p.uLm);
      ((Button)findViewById(2131308096)).setOnClickListener((View.OnClickListener)q.uLn);
      ((Button)findViewById(2131302575)).setOnClickListener((View.OnClickListener)c.uLh);
      findViewById(2131308123);
      ((Button)findViewById(2131308199)).setOnClickListener((View.OnClickListener)new d(this));
      ((Button)_$_findCachedViewById(2131306894)).setOnClickListener((View.OnClickListener)new e(this));
      ((Button)_$_findCachedViewById(2131305707)).setOnClickListener((View.OnClickListener)f.uLi);
      ((Button)_$_findCachedViewById(2131308105)).setOnClickListener((View.OnClickListener)new g(this));
      ((Button)_$_findCachedViewById(2131308214)).setOnClickListener((View.OnClickListener)new h(this));
      ((Button)_$_findCachedViewById(2131308081)).setOnClickListener((View.OnClickListener)i.uLj);
      AppMethodBeat.o(212313);
      return;
      switch (paramBundle.hashCode())
      {
      default: 
        break;
      case -1552608050: 
        if (paramBundle.equals("3191137690"))
        {
          this.uLa = uLd;
          this.uKZ = uLc;
        }
        break;
      case 226066304: 
        if (paramBundle.equals("3193176932"))
        {
          this.uLa = uLc;
          this.uKZ = uLd;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI$Companion;", "", "()V", "SESSION_ID", "", "getSESSION_ID", "()Ljava/lang/String;", "setSESSION_ID", "(Ljava/lang/String;)V", "T1_USERNAME", "getT1_USERNAME", "T2_USERNAME", "getT2_USERNAME", "TAG", "getTAG", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212290);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = this.uLg.uLa;
      localObject = this.uLg.uKZ;
      p.h(paramView, "fromUserName");
      p.h(localObject, "toUserName");
      ae.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getChatSessionId, fromUsrName = " + paramView + " , toUserName = " + (String)localObject);
      new com.tencent.mm.plugin.gamelife.c.c(paramView, (String)localObject).aET();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212290);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c uLh;
    
    static
    {
      AppMethodBeat.i(212292);
      uLh = new c();
      AppMethodBeat.o(212292);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212291);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = TestUI.uLf;
      g.a.d(TestUI.ddM(), 2L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212291);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212293);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = TestUI.uLf;
      paramView = new com.tencent.mm.plugin.byp.b.c(TestUI.ddM(), this.uLg.uLa, this.uLg.uKZ, "this is the first gamelife text");
      x.hSf.ajk().b((n)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212293);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212294);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = this.uLg;
      localObject = new Intent((Context)this.uLg, GameLifeConversationUI.class);
      ((Intent)localObject).putExtra("TEST", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212294);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    public static final f uLi;
    
    static
    {
      AppMethodBeat.i(212296);
      uLi = new f();
      AppMethodBeat.o(212296);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212295);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).clearDB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212295);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212297);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      int i = 0;
      while (i <= 50)
      {
        localObject = new com.tencent.mm.plugin.gamelife.e.a();
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_sessionId = "test".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_digest = "digest".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_updateTime = System.currentTimeMillis();
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_talker = "talker".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.gamelife.e.a)localObject).field_selfUserName = this.uLg.uLa;
        paramView.insert((com.tencent.mm.sdk.e.c)localObject);
        i += 1;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212297);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212298);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterChattingUI((Context)this.uLg, this.uLg.uLa, this.uLg.uKZ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212298);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    public static final i uLj;
    
    static
    {
      AppMethodBeat.i(212300);
      uLj = new i();
      AppMethodBeat.o(212300);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212299);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).anA(((com.tencent.mm.plugin.gamelife.e.a)paramView.dE(0, 1).get(0)).field_sessionId);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212299);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212301);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = new LinkedList((Collection)j.listOf(new String[] { this.uLg.uLa, this.uLg.uKZ }));
      p.h(paramView, "userNameList");
      ae.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getChatUserInfo, userNameList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.d(paramView).aET();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212301);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212302);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = this.uLg.uKZ;
      p.h(paramView, "userName");
      ae.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getBlackList, userName = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.a(paramView).aET();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212302);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212303);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      g.a.g(this.uLg.uKZ, this.uLg.uLb, false);
      paramView = this.uLg;
      if (!this.uLg.uLb) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.uLb = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212303);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212304);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      g.a.g(this.uLg.uKZ, this.uLg.uLb, true);
      paramView = this.uLg;
      if (!this.uLg.uLb) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.uLb = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212304);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n uLk;
    
    static
    {
      AppMethodBeat.i(212306);
      uLk = new n();
      AppMethodBeat.o(212306);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212305);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = TestUI.uLf;
      paramView = new LinkedList((Collection)j.listOf(TestUI.ddM()));
      p.h(paramView, "sessionIdList");
      ae.i(com.tencent.mm.plugin.gamelife.c.g.access$getTAG$cp(), "getSessionData, sesseionIdList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.b(paramView).aET();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212305);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o uLl;
    
    static
    {
      AppMethodBeat.i(212308);
      uLl = new o();
      AppMethodBeat.o(212308);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212307);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = TestUI.uLf;
      g.a.d(TestUI.ddM(), 1L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212307);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    public static final p uLm;
    
    static
    {
      AppMethodBeat.i(212310);
      uLm = new p();
      AppMethodBeat.o(212310);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212309);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = TestUI.uLf;
      g.a.d(TestUI.ddM(), 1L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212309);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    public static final q uLn;
    
    static
    {
      AppMethodBeat.i(212312);
      uLn = new q();
      AppMethodBeat.o(212312);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212311);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.gamelife.c.g.uJj;
      paramView = TestUI.uLf;
      g.a.d(TestUI.ddM(), 2L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212311);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI
 * JD-Core Version:    0.7.0.1
 */