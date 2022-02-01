package com.tencent.mm.emoji.debug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.w;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.a.j;
import d.g.a.a;
import d.y;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI
  extends MMActivity
{
  private static boolean fKu;
  private static boolean fKv;
  public static final c fKw;
  private final String TAG;
  private final LinkedList<a> fKs;
  private RecyclerView fKt;
  
  static
  {
    AppMethodBeat.i(161812);
    fKw = new c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.fKs = new LinkedList();
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
    setBackBtn((MenuItem.OnMenuItemClickListener)new EmojiDebugUI.h(this));
    this.fKt = ((RecyclerView)findViewById(2131299363));
    paramBundle = this.fKt;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.fKt;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new e());
    }
    paramBundle = this.fKt;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new w((Context)this));
    }
    paramBundle = this.fKt;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
    }
    this.fKs.add(new d("预览裁剪方式", ae.a.Fvk, j.listOf(new String[] { "GPU", "CPU" }), j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.fKs.add(new b("临时屏蔽小尾巴", "", (a)new EmojiDebugUI.p(this)));
    this.fKs.add(new b("重置自拍更新红点", "", (a)new EmojiDebugUI.q(this)));
    this.fKs.add(new b("Test parse egg", "", (a)r.fKO));
    this.fKs.add(new b("Start Sticker Preview", "", (a)new s(this)));
    this.fKs.add(new b("Clean Sticker Cache", "", (a)t.fKP));
    this.fKs.add(new b("Mock Download Fail", (a)u.fKQ, (a)v.fKR));
    this.fKs.add(new d("Sticker Panel Switch", ae.a.Fvp, j.listOf(new String[] { "use remote config", "enable", "disable" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = ax.aFC("xlab_effect_config");
    this.fKs.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (a)new w(this, paramBundle)));
    this.fKs.add(new g((a)EmojiDebugUI.i.fKJ, (a)new EmojiDebugUI.j(paramBundle), (a)new k(this, paramBundle)));
    this.fKs.add(new d("Use CDN?", ae.a.Fvl, j.listOf(new String[] { "remote config", "yes", "no" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.fKs.size();
    paramBundle = new b("Egg Spring: Stop CGI?", fKu);
    paramBundle.fKz = ((a)new l(this, i));
    this.fKs.add(paramBundle);
    i = this.fKs.size();
    paramBundle = new b("Egg Spring: Stop CDN?", fKv);
    paramBundle.fKz = ((a)new m(this, i));
    this.fKs.add(paramBundle);
    this.fKs.add(new b("GetDesigner", "", (a)n.fKN));
    this.fKs.add(new b("Show Words", "", (a)new EmojiDebugUI.o(this)));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "title", "", "value", "plugin-emojisdk_release"})
  public abstract class a
  {
    public abstract String aaO();
    
    public abstract void onClick();
    
    public abstract String value();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
  public final class b
    extends EmojiDebugUI.a
  {
    private a<String> fKy;
    a<y> fKz;
    private final String title;
    
    public b(a<String> parama, a<y> parama1)
    {
      super();
      AppMethodBeat.i(177044);
      this.title = parama;
      this.fKy = parama1;
      Object localObject;
      this.fKz = localObject;
      AppMethodBeat.o(177044);
    }
    
    public b(String paramString, a<y> parama)
    {
      this(paramString, (a)new d.g.b.l(parama) {}, locala);
      AppMethodBeat.i(105332);
      AppMethodBeat.o(105332);
    }
    
    public final String aaO()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.fKz;
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
      String str = (String)this.fKy.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$Companion;", "", "()V", "stopCDN", "", "getStopCDN", "()Z", "setStopCDN", "(Z)V", "stopCGI", "getStopCGI", "setStopCGI", "plugin-emojisdk_release"})
  public static final class c {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class d<T>
    extends EmojiDebugUI.a
  {
    final ae.a fKB;
    private final List<String> fKC;
    final List<T> fKD;
    private final String title;
    
    public d(ae.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.fKB = paramList;
      this.fKC = paramList1;
      this.fKD = localObject;
      AppMethodBeat.o(105336);
    }
    
    public final String aaO()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)this.fKC).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)EmojiDebugUI.this, "", this.fKC, j.m((Iterable)j.n((Collection)this.fKC)), "", (h.d)new a(this));
      AppMethodBeat.o(105335);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.fKD.indexOf(EmojiDebugUI.a(this.fKB, this.fKD.get(0)));
      if ((i >= 0) && (i < this.fKC.size()))
      {
        str = (String)this.fKC.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.fKC.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
    static final class a
      implements h.d
    {
      a(EmojiDebugUI.d paramd) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(105333);
        EmojiDebugUI.b(this.fKE.fKB, this.fKE.fKD.get(paramInt2));
        Object localObject = EmojiDebugUI.a(this.fKE.fKx);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
  public final class e
    extends RecyclerView.a<EmojiDebugUI.f>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(105339);
      int i = EmojiDebugUI.b(this.fKx).size();
      AppMethodBeat.o(105339);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(EmojiDebugUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(105337);
        ((EmojiDebugUI.a)EmojiDebugUI.b(this.fKF.fKx).get(this.fKG)).onClick();
        AppMethodBeat.o(105337);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Landroid/widget/TextView;)V", "textView", "getTextView", "()Landroid/widget/TextView;", "plugin-emojisdk_release"})
  public final class f
    extends RecyclerView.v
  {
    final TextView ss;
    
    public f()
    {
      super();
      AppMethodBeat.i(105341);
      this.ss = localObject;
      AppMethodBeat.o(105341);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"})
  public final class g
    extends EmojiDebugUI.a
  {
    private final a<String> fKH;
    private final a<String> fKI;
    private final a<y> fKz;
    
    public g(a<String> parama, a<y> parama1)
    {
      super();
      AppMethodBeat.i(105345);
      this.fKH = parama;
      this.fKI = parama1;
      Object localObject;
      this.fKz = localObject;
      AppMethodBeat.o(105345);
    }
    
    public final String aaO()
    {
      AppMethodBeat.i(105342);
      String str = (String)this.fKH.invoke();
      AppMethodBeat.o(105342);
      return str;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105344);
      a locala = this.fKz;
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
      String str = (String)this.fKI.invoke();
      AppMethodBeat.o(105343);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements a<y>
  {
    k(EmojiDebugUI paramEmojiDebugUI, ax paramax)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements a<y>
  {
    l(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements a<y>
  {
    m(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements a<y>
  {
    public static final n fKN;
    
    static
    {
      AppMethodBeat.i(183950);
      fKN = new n();
      AppMethodBeat.o(183950);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.l
    implements a<y>
  {
    public static final r fKO;
    
    static
    {
      AppMethodBeat.i(105352);
      fKO = new r();
      AppMethodBeat.o(105352);
    }
    
    r()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements a<y>
  {
    s(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements a<y>
  {
    public static final t fKP;
    
    static
    {
      AppMethodBeat.i(105355);
      fKP = new t();
      AppMethodBeat.o(105355);
    }
    
    t()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements a<String>
  {
    public static final u fKQ;
    
    static
    {
      AppMethodBeat.i(177048);
      fKQ = new u();
      AppMethodBeat.o(177048);
    }
    
    u()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements a<y>
  {
    public static final v fKR;
    
    static
    {
      AppMethodBeat.i(105357);
      fKR = new v();
      AppMethodBeat.o(105357);
    }
    
    v()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements a<y>
  {
    w(EmojiDebugUI paramEmojiDebugUI, ax paramax)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI
 * JD-Core Version:    0.7.0.1
 */