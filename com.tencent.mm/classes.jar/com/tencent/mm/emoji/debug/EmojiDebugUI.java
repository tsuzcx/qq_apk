package com.tencent.mm.emoji.debug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.w;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.a.j;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI
  extends MMActivity
{
  private static boolean gjS;
  private static boolean gjT;
  public static final EmojiDebugUI.c gjU;
  private final String TAG;
  private final LinkedList<EmojiDebugUI.a> gjQ;
  private RecyclerView gjR;
  
  static
  {
    AppMethodBeat.i(161812);
    gjU = new EmojiDebugUI.c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.gjQ = new LinkedList();
    AppMethodBeat.o(105360);
  }
  
  public final int getLayoutId()
  {
    return 2131493769;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(105359);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new EmojiDebugUI.i(this));
    this.gjR = ((RecyclerView)findViewById(2131299363));
    paramBundle = this.gjR;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.gjR;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new EmojiDebugUI.e(this));
    }
    paramBundle = this.gjR;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new w((Context)this));
    }
    paramBundle = this.gjR;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
    }
    this.gjQ.add(new d("预览裁剪方式", am.a.Jaj, j.listOf(new String[] { "GPU", "CPU" }), j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.gjQ.add(new b("临时屏蔽小尾巴", "", (a)new EmojiDebugUI.t(this)));
    this.gjQ.add(new b("重置自拍更新红点", "", (a)new EmojiDebugUI.v(this)));
    this.gjQ.add(new b("Test parse egg", "", (a)EmojiDebugUI.w.gko));
    this.gjQ.add(new b("Start Sticker Preview", "", (a)new x(this)));
    this.gjQ.add(new b("copy preview", "", (a)new EmojiDebugUI.y(this)));
    this.gjQ.add(new b("Clean Sticker Cache", "", (a)z.gkp));
    this.gjQ.add(new b("Mock Download Fail", (a)aa.gkq, (a)ab.gkr));
    this.gjQ.add(new d("Sticker Panel Switch", am.a.Jao, j.listOf(new String[] { "use remote config", "enable", "disable" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = ay.aRW("xlab_effect_config");
    this.gjQ.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (a)new j(this, paramBundle)));
    this.gjQ.add(new EmojiDebugUI.g(this, (a)EmojiDebugUI.k.gki, (a)new EmojiDebugUI.l(paramBundle), (a)new m(this, paramBundle)));
    this.gjQ.add(new d("Use CDN?", am.a.Jak, j.listOf(new String[] { "remote config", "yes", "no" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.gjQ.size();
    paramBundle = new b("Egg Spring: Stop CGI?", gjS);
    paramBundle.gjX = ((a)new n(this, i));
    this.gjQ.add(paramBundle);
    i = this.gjQ.size();
    paramBundle = new b("Egg Spring: Stop CDN?", gjT);
    paramBundle.gjX = ((a)new o(this, i));
    this.gjQ.add(paramBundle);
    this.gjQ.add(new b("GetDesigner", "", (a)p.gkl));
    this.gjQ.add(new EmojiDebugUI.h(this, "Emoji Suggest"));
    this.gjQ.add(new b("Show Words", "", (a)new q(this)));
    this.gjQ.add(new b("Clear Cache", "", (a)EmojiDebugUI.r.gkm));
    this.gjQ.add(new b("Update Word List", "", (a)s.gkn));
    this.gjQ.add(new b("Emoji Suggest config", "", (a)new u(this)));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements a<String>
  {
    public static final aa gkq;
    
    static
    {
      AppMethodBeat.i(105357);
      gkq = new aa();
      AppMethodBeat.o(105357);
    }
    
    aa()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class ab
    extends q
    implements a<z>
  {
    public static final ab gkr;
    
    static
    {
      AppMethodBeat.i(188541);
      gkr = new ab();
      AppMethodBeat.o(188541);
    }
    
    ab()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
  public final class b
    extends EmojiDebugUI.a
  {
    private a<String> gjW;
    a<z> gjX;
    private final String title;
    
    public b(a<String> parama, a<z> parama1)
    {
      super();
      AppMethodBeat.i(177044);
      this.title = parama;
      this.gjW = parama1;
      Object localObject;
      this.gjX = localObject;
      AppMethodBeat.o(177044);
    }
    
    public b(String paramString, a<z> parama)
    {
      this(paramString, (a)new q(parama) {}, locala);
      AppMethodBeat.i(105332);
      AppMethodBeat.o(105332);
    }
    
    public final String aeD()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.gjX;
      if (localObject != null) {
        ((a)localObject).invoke();
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
      String str = (String)this.gjW.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class d<T>
    extends EmojiDebugUI.a
  {
    final am.a gjZ;
    private final List<String> gka;
    final List<T> gkb;
    private final String title;
    
    public d(am.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.gjZ = paramList;
      this.gka = paramList1;
      this.gkb = localObject;
      AppMethodBeat.o(105336);
    }
    
    public final String aeD()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)this.gka).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)EmojiDebugUI.this, "", this.gka, j.l((Iterable)j.o((Collection)this.gka)), "", (h.d)new a(this));
      AppMethodBeat.o(105335);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.gkb.indexOf(EmojiDebugUI.a(this.gjZ, this.gkb.get(0)));
      if ((i >= 0) && (i < this.gka.size()))
      {
        str = (String)this.gka.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.gka.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
    static final class a
      implements h.d
    {
      a(EmojiDebugUI.d paramd) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(105333);
        EmojiDebugUI.b(this.gkc.gjZ, this.gkc.gkb.get(paramInt2));
        Object localObject = EmojiDebugUI.a(this.gkc.gjV);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<z>
  {
    j(EmojiDebugUI paramEmojiDebugUI, ay paramay)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements a<z>
  {
    m(EmojiDebugUI paramEmojiDebugUI, ay paramay)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements a<z>
  {
    n(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements a<z>
  {
    o(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements a<z>
  {
    public static final p gkl;
    
    static
    {
      AppMethodBeat.i(188534);
      gkl = new p();
      AppMethodBeat.o(188534);
    }
    
    p()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements a<z>
  {
    q(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements a<z>
  {
    public static final s gkn;
    
    static
    {
      AppMethodBeat.i(188539);
      gkn = new s();
      AppMethodBeat.o(188539);
    }
    
    s()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements a<z>
  {
    u(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements a<z>
  {
    x(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements a<z>
  {
    public static final z gkp;
    
    static
    {
      AppMethodBeat.i(177048);
      gkp = new z();
      AppMethodBeat.o(177048);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI
 * JD-Core Version:    0.7.0.1
 */