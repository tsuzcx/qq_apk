package com.tencent.mm.emoji.debug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.w;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.ce.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI
  extends MMActivity
{
  private static boolean gTX;
  private static boolean gTY;
  public static final EmojiDebugUI.c gTZ;
  private final String TAG;
  private final LinkedList<a> gTV;
  private RecyclerView gTW;
  
  static
  {
    AppMethodBeat.i(161812);
    gTZ = new EmojiDebugUI.c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.gTV = new LinkedList();
    AppMethodBeat.o(105360);
  }
  
  public final int getLayoutId()
  {
    return 2131493918;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(105359);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new EmojiDebugUI.i(this));
    this.gTW = ((RecyclerView)findViewById(2131299976));
    paramBundle = this.gTW;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.gTW;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new e());
    }
    paramBundle = this.gTW;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new w((Context)this, 1));
    }
    paramBundle = this.gTW;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
    }
    this.gTV.add(new d("预览裁剪方式", ar.a.OiP, j.listOf(new String[] { "GPU", "CPU" }), j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.gTV.add(new b("临时屏蔽小尾巴", "", (kotlin.g.a.a)new EmojiDebugUI.t(this)));
    this.gTV.add(new b("重置自拍更新红点", "", (kotlin.g.a.a)new EmojiDebugUI.ad(this)));
    this.gTV.add(new h(""));
    this.gTV.add(new b("Test parse egg", "", (kotlin.g.a.a)ae.gUC));
    this.gTV.add(new b("测试打开网页", "", (kotlin.g.a.a)new EmojiDebugUI.af(this)));
    this.gTV.add(new b("测试预加载", "", (kotlin.g.a.a)EmojiDebugUI.ag.gUD));
    this.gTV.add(new h(""));
    this.gTV.add(new b("Start Sticker Preview", "", (kotlin.g.a.a)new ah(this)));
    this.gTV.add(new b("copy preview", "", (kotlin.g.a.a)new ai(this)));
    this.gTV.add(new b("Clean Sticker Cache", "", (kotlin.g.a.a)aj.gUE));
    this.gTV.add(new b("test parse", "", (kotlin.g.a.a)new j(this)));
    this.gTV.add(new b("Mock Download Fail", (kotlin.g.a.a)k.gUm, (kotlin.g.a.a)l.gUn));
    this.gTV.add(new h("Emoji Res"));
    this.gTV.add(new b("dump color_emoji", "", (kotlin.g.a.a)new m(this)));
    this.gTV.add(new b("merge color_emoji", "", (kotlin.g.a.a)new n(this)));
    this.gTV.add(new b("parse anim emoji", "", (kotlin.g.a.a)new o(this)));
    this.gTV.add(new b("get smiley", "", (kotlin.g.a.a)new p(this)));
    this.gTV.add(new d("Sticker Panel Switch", ar.a.OiU, j.listOf(new String[] { "use remote config", "enable", "disable" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = MultiProcessMMKV.getMMKV("xlab_effect_config");
    this.gTV.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (kotlin.g.a.a)new q(this, paramBundle)));
    this.gTV.add(new g((kotlin.g.a.a)EmojiDebugUI.r.gUv, (kotlin.g.a.a)new EmojiDebugUI.s(paramBundle), (kotlin.g.a.a)new u(this, paramBundle)));
    this.gTV.add(new d("Use CDN?", ar.a.OiQ, j.listOf(new String[] { "remote config", "yes", "no" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.gTV.size();
    paramBundle = new b("Egg Spring: Stop CGI?", gTX);
    paramBundle.gUc = ((kotlin.g.a.a)new v(this, i));
    this.gTV.add(paramBundle);
    i = this.gTV.size();
    paramBundle = new b("Egg Spring: Stop CDN?", gTY);
    paramBundle.gUc = ((kotlin.g.a.a)new w(this, i));
    this.gTV.add(paramBundle);
    this.gTV.add(new b("Egg res Info", "", (kotlin.g.a.a)EmojiDebugUI.x.gUy));
    this.gTV.add(new h(""));
    this.gTV.add(new b("GetDesigner", "", (kotlin.g.a.a)EmojiDebugUI.y.gUz));
    this.gTV.add(new h("Emoji Suggest"));
    this.gTV.add(new b("Show Words", "", (kotlin.g.a.a)new EmojiDebugUI.z(this)));
    this.gTV.add(new b("Clear Cache", "", (kotlin.g.a.a)EmojiDebugUI.aa.gUA));
    this.gTV.add(new b("Update Word List", "", (kotlin.g.a.a)EmojiDebugUI.ab.gUB));
    this.gTV.add(new b("Emoji Suggest config", "", (kotlin.g.a.a)new EmojiDebugUI.ac(this)));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "textSize", "", "title", "", "value", "plugin-emojisdk_release"})
  public abstract class a
  {
    public abstract String auk();
    
    public float aul()
    {
      return 0.0F;
    }
    
    public abstract void onClick();
    
    public abstract String value();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final ae gUC;
    
    static
    {
      AppMethodBeat.i(105352);
      gUC = new ae();
      AppMethodBeat.o(105352);
    }
    
    ae()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ah
    extends q
    implements kotlin.g.a.a<x>
  {
    ah(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ai
    extends q
    implements kotlin.g.a.a<x>
  {
    ai(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class aj
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final aj gUE;
    
    static
    {
      AppMethodBeat.i(199860);
      gUE = new aj();
      AppMethodBeat.o(199860);
    }
    
    aj()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
  public final class b
    extends EmojiDebugUI.a
  {
    private kotlin.g.a.a<String> gUb;
    kotlin.g.a.a<x> gUc;
    private final String title;
    
    public b(String paramString, kotlin.g.a.a<x> parama)
    {
      this(paramString, (kotlin.g.a.a)new q(parama) {}, locala);
      AppMethodBeat.i(105332);
      AppMethodBeat.o(105332);
    }
    
    public b(kotlin.g.a.a<String> parama, kotlin.g.a.a<x> parama1)
    {
      super();
      AppMethodBeat.i(177044);
      this.title = parama;
      this.gUb = parama1;
      Object localObject;
      this.gUc = localObject;
      AppMethodBeat.o(177044);
    }
    
    public final String auk()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.gUc;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
      localObject = EmojiDebugUI.a(EmojiDebugUI.this);
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null)
        {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
          AppMethodBeat.o(105331);
          return;
        }
      }
      AppMethodBeat.o(105331);
    }
    
    public final String value()
    {
      AppMethodBeat.i(177043);
      String str = (String)this.gUb.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class d<T>
    extends EmojiDebugUI.a
  {
    final ar.a gUe;
    private final List<String> gUf;
    final List<T> gUg;
    private final String title;
    
    public d(ar.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.gUe = paramList;
      this.gUf = paramList1;
      this.gUg = localObject;
      AppMethodBeat.o(105336);
    }
    
    public final String auk()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)this.gUf).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)EmojiDebugUI.this, "", this.gUf, j.p((Iterable)j.r((Collection)this.gUf)), "", (h.e)new a(this));
      AppMethodBeat.o(105335);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.gUg.indexOf(EmojiDebugUI.a(this.gUe, this.gUg.get(0)));
      if ((i >= 0) && (i < this.gUf.size()))
      {
        str = (String)this.gUf.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.gUf.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
    static final class a
      implements h.e
    {
      a(EmojiDebugUI.d paramd) {}
      
      public final void cy(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(105333);
        EmojiDebugUI.b(this.gUh.gUe, this.gUh.gUg.get(paramInt2));
        Object localObject = EmojiDebugUI.a(this.gUh.gUa);
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null)
          {
            ((RecyclerView.a)localObject).notifyDataSetChanged();
            AppMethodBeat.o(105333);
            return;
          }
        }
        AppMethodBeat.o(105333);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
  public final class e
    extends RecyclerView.a<EmojiDebugUI.f>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(105339);
      int i = EmojiDebugUI.b(this.gUa).size();
      AppMethodBeat.o(105339);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(EmojiDebugUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(105337);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((EmojiDebugUI.a)EmojiDebugUI.b(this.gUi.gUa).get(this.gUj)).onClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105337);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"})
  public final class g
    extends EmojiDebugUI.a
  {
    private final kotlin.g.a.a<x> gUc;
    private final kotlin.g.a.a<String> gUk;
    private final kotlin.g.a.a<String> gUl;
    
    public g(kotlin.g.a.a<String> parama, kotlin.g.a.a<x> parama1)
    {
      super();
      AppMethodBeat.i(105345);
      this.gUk = parama;
      this.gUl = parama1;
      Object localObject;
      this.gUc = localObject;
      AppMethodBeat.o(105345);
    }
    
    public final String auk()
    {
      AppMethodBeat.i(105342);
      String str = (String)this.gUk.invoke();
      AppMethodBeat.o(105342);
      return str;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105344);
      kotlin.g.a.a locala = this.gUc;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(105344);
        return;
      }
      AppMethodBeat.o(105344);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105343);
      String str = (String)this.gUl.invoke();
      AppMethodBeat.o(105343);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GroupItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "onClick", "", "textSize", "", "value", "plugin-emojisdk_release"})
  public final class h
    extends EmojiDebugUI.a
  {
    private final String title;
    
    public h()
    {
      super();
      AppMethodBeat.i(199836);
      this.title = localObject;
      AppMethodBeat.o(199836);
    }
    
    public final String auk()
    {
      return this.title;
    }
    
    public final float aul()
    {
      return 30.0F;
    }
    
    public final void onClick() {}
    
    public final String value()
    {
      return "";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<String>
  {
    public static final k gUm;
    
    static
    {
      AppMethodBeat.i(105348);
      gUm = new k();
      AppMethodBeat.o(105348);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final l gUn;
    
    static
    {
      AppMethodBeat.i(199837);
      gUn = new l();
      AppMethodBeat.o(199837);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(EmojiDebugUI paramEmojiDebugUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<x>
  {
    u(EmojiDebugUI paramEmojiDebugUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<x>
  {
    v(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<x>
  {
    w(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI
 * JD-Core Version:    0.7.0.1
 */