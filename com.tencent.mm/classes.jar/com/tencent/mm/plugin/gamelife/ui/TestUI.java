package com.tencent.mm.plugin.gamelife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.c.c;
import com.tencent.mm.plugin.gamelife.c.g;
import com.tencent.mm.plugin.gamelife.c.g.a;
import com.tencent.mm.plugin.gamelife.d.c;
import com.tencent.mm.plugin.gamelife.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "FROM_USER_NAME", "", "getFROM_USER_NAME", "()Ljava/lang/String;", "setFROM_USER_NAME", "(Ljava/lang/String;)V", "TO_USER_NAME", "getTO_USER_NAME", "setTO_USER_NAME", "switchBlackList", "", "getSwitchBlackList", "()Z", "setSwitchBlackList", "(Z)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTestUsername", "Companion", "plugin-gamelife_release"})
public final class TestUI
  extends MMActivity
{
  private static final String Dja = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String Djb = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  private static String Djc;
  public static final a Djd;
  private static final String TAG = "MicroMsg.TestUI";
  String DiX = Dja;
  String DiY = Djb;
  boolean DiZ = true;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(202830);
    Djd = new a((byte)0);
    TAG = "MicroMsg.TestUI";
    Dja = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    Djb = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    Djc = "S1_BgAAdQoEcfnVwzCiSbiVnB7BOg@gamelifesess";
    AppMethodBeat.o(202830);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(202832);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(202832);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202831);
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
    AppMethodBeat.o(202831);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return d.d.Dge;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202827);
    super.onCreate(paramBundle);
    p.j(h.aHE(), "MMKernel.account()");
    paramBundle = com.tencent.mm.kernel.b.aGq();
    if (paramBundle == null) {}
    for (;;)
    {
      ((Button)findViewById(d.c.DfU)).setOnClickListener((View.OnClickListener)new b(this));
      ((Button)findViewById(d.c.DfT)).setOnClickListener((View.OnClickListener)new j(this));
      ((Button)findViewById(d.c.DfR)).setOnClickListener((View.OnClickListener)new k(this));
      ((Button)findViewById(d.c.DfY)).setOnClickListener((View.OnClickListener)new l(this));
      ((Button)findViewById(d.c.DfZ)).setOnClickListener((View.OnClickListener)new m(this));
      ((Button)findViewById(d.c.DfS)).setOnClickListener((View.OnClickListener)n.Dji);
      ((Button)findViewById(d.c.Dga)).setOnClickListener((View.OnClickListener)o.Djj);
      ((Button)findViewById(d.c.Dgc)).setOnClickListener((View.OnClickListener)p.Djk);
      ((Button)findViewById(d.c.DfL)).setOnClickListener((View.OnClickListener)q.Djl);
      ((Button)findViewById(d.c.DfE)).setOnClickListener((View.OnClickListener)c.Djf);
      findViewById(d.c.DfN);
      ((Button)findViewById(d.c.DfX)).setOnClickListener((View.OnClickListener)new d(this));
      ((Button)_$_findCachedViewById(d.c.DfF)).setOnClickListener((View.OnClickListener)new TestUI.e(this));
      ((Button)_$_findCachedViewById(d.c.clear)).setOnClickListener((View.OnClickListener)TestUI.f.Djg);
      ((Button)_$_findCachedViewById(d.c.DfM)).setOnClickListener((View.OnClickListener)new TestUI.g(this));
      ((Button)_$_findCachedViewById(d.c.Dgb)).setOnClickListener((View.OnClickListener)new TestUI.h(this));
      ((Button)_$_findCachedViewById(d.c.DfI)).setOnClickListener((View.OnClickListener)TestUI.i.Djh);
      AppMethodBeat.o(202827);
      return;
      switch (paramBundle.hashCode())
      {
      default: 
        break;
      case -1552608050: 
        if (paramBundle.equals("3191137690"))
        {
          this.DiY = Djb;
          this.DiX = Dja;
        }
        break;
      case 226066304: 
        if (paramBundle.equals("3193176932"))
        {
          this.DiY = Dja;
          this.DiX = Djb;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/TestUI$Companion;", "", "()V", "SESSION_ID", "", "getSESSION_ID", "()Ljava/lang/String;", "setSESSION_ID", "(Ljava/lang/String;)V", "T1_USERNAME", "getT1_USERNAME", "T2_USERNAME", "getT2_USERNAME", "TAG", "getTAG", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203107);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = g.Dhf;
      paramView = this.Dje.DiY;
      localObject = this.Dje.DiX;
      p.k(paramView, "fromUserName");
      p.k(localObject, "toUserName");
      Log.i(g.access$getTAG$cp(), "getChatSessionId, fromUsrName = " + paramView + " , toUserName = " + (String)localObject);
      new c(paramView, (String)localObject, 0, null).bhW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203107);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    public static final c Djf;
    
    static
    {
      AppMethodBeat.i(203517);
      Djf = new c();
      AppMethodBeat.o(203517);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203515);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = TestUI.Djd;
      g.a.c(TestUI.eAD(), 2L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203515);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204108);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = TestUI.Djd;
      paramView = new com.tencent.mm.plugin.byp.b.d(TestUI.eAD(), this.Dje.DiY, this.Dje.DiX, "this is the first gamelife text");
      aa.lDv.aGZ().b((q)paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204108);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203176);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = new LinkedList((Collection)j.listOf(new String[] { this.Dje.DiY, this.Dje.DiX }));
      p.k(paramView, "userNameList");
      Log.i(g.access$getTAG$cp(), "getChatUserInfo, userNameList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.d(paramView).bhW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203176);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203444);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = this.Dje.DiX;
      p.k(paramView, "userName");
      Log.i(g.access$getTAG$cp(), "getBlackList, userName = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.a(paramView).bhW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203444);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203159);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      g.a.h(this.Dje.DiX, this.Dje.DiZ, false);
      paramView = this.Dje;
      if (!this.Dje.DiZ) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.DiZ = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203159);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(TestUI paramTestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202815);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      g.a.h(this.Dje.DiX, this.Dje.DiZ, true);
      paramView = this.Dje;
      if (!this.Dje.DiZ) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.DiZ = bool;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202815);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    public static final n Dji;
    
    static
    {
      AppMethodBeat.i(202914);
      Dji = new n();
      AppMethodBeat.o(202914);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202913);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = TestUI.Djd;
      paramView = new LinkedList((Collection)j.listOf(TestUI.eAD()));
      p.k(paramView, "sessionIdList");
      Log.i(g.access$getTAG$cp(), "getSessionData, sesseionIdList = ".concat(String.valueOf(paramView)));
      new com.tencent.mm.plugin.gamelife.c.b(paramView).bhW();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202913);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    public static final o Djj;
    
    static
    {
      AppMethodBeat.i(203912);
      Djj = new o();
      AppMethodBeat.o(203912);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203911);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = TestUI.Djd;
      g.a.c(TestUI.eAD(), 1L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203911);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    public static final p Djk;
    
    static
    {
      AppMethodBeat.i(204311);
      Djk = new p();
      AppMethodBeat.o(204311);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204310);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = TestUI.Djd;
      g.a.c(TestUI.eAD(), 1L, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204310);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    public static final q Djl;
    
    static
    {
      AppMethodBeat.i(204470);
      Djl = new q();
      AppMethodBeat.o(204470);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204468);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.Dhf;
      paramView = TestUI.Djd;
      g.a.c(TestUI.eAD(), 2L, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/TestUI$onCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204468);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.TestUI
 * JD-Core Version:    0.7.0.1
 */