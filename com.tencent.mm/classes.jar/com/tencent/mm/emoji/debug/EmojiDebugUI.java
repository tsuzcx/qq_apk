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
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.al.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI
  extends MMActivity
{
  private static boolean ghA;
  private static boolean ghB;
  public static final EmojiDebugUI.c ghC;
  private final String TAG;
  private final LinkedList<EmojiDebugUI.a> ghy;
  private RecyclerView ghz;
  
  static
  {
    AppMethodBeat.i(161812);
    ghC = new EmojiDebugUI.c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.ghy = new LinkedList();
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
    this.ghz = ((RecyclerView)findViewById(2131299363));
    paramBundle = this.ghz;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.ghz;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new EmojiDebugUI.e(this));
    }
    paramBundle = this.ghz;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new w((Context)this));
    }
    paramBundle = this.ghz;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
    }
    this.ghy.add(new d("预览裁剪方式", al.a.IFJ, j.listOf(new String[] { "GPU", "CPU" }), j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.ghy.add(new b("临时屏蔽小尾巴", "", (a)new EmojiDebugUI.t(this)));
    this.ghy.add(new b("重置自拍更新红点", "", (a)new EmojiDebugUI.u(this)));
    this.ghy.add(new b("Test parse egg", "", (a)v.ghW));
    this.ghy.add(new b("Start Sticker Preview", "", (a)new w(this)));
    this.ghy.add(new b("Clean Sticker Cache", "", (a)x.ghX));
    this.ghy.add(new b("Mock Download Fail", (a)y.ghY, (a)z.ghZ));
    this.ghy.add(new d("Sticker Panel Switch", al.a.IFO, j.listOf(new String[] { "use remote config", "enable", "disable" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = ax.aQz("xlab_effect_config");
    this.ghy.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (a)new aa(this, paramBundle)));
    this.ghy.add(new EmojiDebugUI.g(this, (a)EmojiDebugUI.j.ghP, (a)new EmojiDebugUI.k(paramBundle), (a)new l(this, paramBundle)));
    this.ghy.add(new d("Use CDN?", al.a.IFK, j.listOf(new String[] { "remote config", "yes", "no" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.ghy.size();
    paramBundle = new b("Egg Spring: Stop CGI?", ghA);
    paramBundle.ghF = ((a)new m(this, i));
    this.ghy.add(paramBundle);
    i = this.ghy.size();
    paramBundle = new b("Egg Spring: Stop CDN?", ghB);
    paramBundle.ghF = ((a)new n(this, i));
    this.ghy.add(paramBundle);
    this.ghy.add(new b("GetDesigner", "", (a)o.ghT));
    this.ghy.add(new EmojiDebugUI.h(this, "Emoji Suggest"));
    this.ghy.add(new b("Show Words", "", (a)new p(this)));
    this.ghy.add(new b("Clear Cache", "", (a)EmojiDebugUI.q.ghU));
    this.ghy.add(new b("Update Word List", "", (a)r.ghV));
    this.ghy.add(new b("Emoji Suggest config", "", (a)new s(this)));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements a<z>
  {
    aa(EmojiDebugUI paramEmojiDebugUI, ax paramax)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
  public final class b
    extends EmojiDebugUI.a
  {
    private a<String> ghE;
    a<z> ghF;
    private final String title;
    
    public b(a<String> parama, a<z> parama1)
    {
      super();
      AppMethodBeat.i(177044);
      this.title = parama;
      this.ghE = parama1;
      Object localObject;
      this.ghF = localObject;
      AppMethodBeat.o(177044);
    }
    
    public b(String paramString, a<z> parama)
    {
      this(paramString, (a)new q(parama) {}, locala);
      AppMethodBeat.i(105332);
      AppMethodBeat.o(105332);
    }
    
    public final String aer()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.ghF;
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
      String str = (String)this.ghE.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class d<T>
    extends EmojiDebugUI.a
  {
    final al.a ghH;
    private final List<String> ghI;
    final List<T> ghJ;
    private final String title;
    
    public d(al.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.ghH = paramList;
      this.ghI = paramList1;
      this.ghJ = localObject;
      AppMethodBeat.o(105336);
    }
    
    public final String aer()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)this.ghI).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)EmojiDebugUI.this, "", this.ghI, j.l((Iterable)j.o((Collection)this.ghI)), "", (h.d)new a(this));
      AppMethodBeat.o(105335);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.ghJ.indexOf(EmojiDebugUI.a(this.ghH, this.ghJ.get(0)));
      if ((i >= 0) && (i < this.ghI.size()))
      {
        str = (String)this.ghI.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.ghI.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
    static final class a
      implements h.d
    {
      a(EmojiDebugUI.d paramd) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(105333);
        EmojiDebugUI.b(this.ghK.ghH, this.ghK.ghJ.get(paramInt2));
        Object localObject = EmojiDebugUI.a(this.ghK.ghD);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<z>
  {
    l(EmojiDebugUI paramEmojiDebugUI, ax paramax)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements a<z>
  {
    m(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements a<z>
  {
    n(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements a<z>
  {
    public static final o ghT;
    
    static
    {
      AppMethodBeat.i(183950);
      ghT = new o();
      AppMethodBeat.o(183950);
    }
    
    o()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements a<z>
  {
    p(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements a<z>
  {
    public static final r ghV;
    
    static
    {
      AppMethodBeat.i(218931);
      ghV = new r();
      AppMethodBeat.o(218931);
    }
    
    r()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements a<z>
  {
    s(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements a<z>
  {
    public static final v ghW;
    
    static
    {
      AppMethodBeat.i(105352);
      ghW = new v();
      AppMethodBeat.o(105352);
    }
    
    v()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements a<z>
  {
    w(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements a<z>
  {
    public static final x ghX;
    
    static
    {
      AppMethodBeat.i(105355);
      ghX = new x();
      AppMethodBeat.o(105355);
    }
    
    x()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements a<String>
  {
    public static final y ghY;
    
    static
    {
      AppMethodBeat.i(177048);
      ghY = new y();
      AppMethodBeat.o(177048);
    }
    
    y()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements a<z>
  {
    public static final z ghZ;
    
    static
    {
      AppMethodBeat.i(105357);
      ghZ = new z();
      AppMethodBeat.o(105357);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI
 * JD-Core Version:    0.7.0.1
 */