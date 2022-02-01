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
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.a.j;
import d.g.a.a;
import d.y;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI
  extends MMActivity
{
  private static boolean fOa;
  private static boolean fOb;
  public static final EmojiDebugUI.c fOc;
  private final String TAG;
  private final LinkedList<a> fNY;
  private RecyclerView fNZ;
  
  static
  {
    AppMethodBeat.i(161812);
    fOc = new EmojiDebugUI.c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.fNY = new LinkedList();
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
    this.fNZ = ((RecyclerView)findViewById(2131299363));
    paramBundle = this.fNZ;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = this.fNZ;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new e());
    }
    paramBundle = this.fNZ;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new w((Context)this));
    }
    paramBundle = this.fNZ;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
    }
    this.fNY.add(new d("预览裁剪方式", ah.a.GTe, j.listOf(new String[] { "GPU", "CPU" }), j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.fNY.add(new b("临时屏蔽小尾巴", "", (a)new EmojiDebugUI.t(this)));
    this.fNY.add(new b("重置自拍更新红点", "", (a)new EmojiDebugUI.u(this)));
    this.fNY.add(new b("Test parse egg", "", (a)v.fOw));
    this.fNY.add(new b("Start Sticker Preview", "", (a)new w(this)));
    this.fNY.add(new b("Clean Sticker Cache", "", (a)x.fOx));
    this.fNY.add(new b("Mock Download Fail", (a)y.fOy, (a)z.fOz));
    this.fNY.add(new d("Sticker Panel Switch", ah.a.GTj, j.listOf(new String[] { "use remote config", "enable", "disable" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = aw.aKT("xlab_effect_config");
    this.fNY.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (a)new aa(this, paramBundle)));
    this.fNY.add(new g((a)EmojiDebugUI.j.fOp, (a)new EmojiDebugUI.k(paramBundle), (a)new l(this, paramBundle)));
    this.fNY.add(new d("Use CDN?", ah.a.GTf, j.listOf(new String[] { "remote config", "yes", "no" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.fNY.size();
    paramBundle = new b("Egg Spring: Stop CGI?", fOa);
    paramBundle.fOf = ((a)new m(this, i));
    this.fNY.add(paramBundle);
    i = this.fNY.size();
    paramBundle = new b("Egg Spring: Stop CDN?", fOb);
    paramBundle.fOf = ((a)new n(this, i));
    this.fNY.add(paramBundle);
    this.fNY.add(new b("GetDesigner", "", (a)o.fOt));
    this.fNY.add(new h("Emoji Suggest"));
    this.fNY.add(new b("Show Words", "", (a)new p(this)));
    this.fNY.add(new b("Clear Cache", "", (a)q.fOu));
    this.fNY.add(new b("Update Word List", "", (a)r.fOv));
    this.fNY.add(new b("Emoji Suggest config", "", (a)new s(this)));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "title", "", "value", "plugin-emojisdk_release"})
  public abstract class a
  {
    public abstract String abN();
    
    public abstract void onClick();
    
    public abstract String value();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class aa
    extends d.g.b.l
    implements a<y>
  {
    aa(EmojiDebugUI paramEmojiDebugUI, aw paramaw)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
  public final class b
    extends EmojiDebugUI.a
  {
    private a<String> fOe;
    a<y> fOf;
    private final String title;
    
    public b(a<String> parama, a<y> parama1)
    {
      super();
      AppMethodBeat.i(177044);
      this.title = parama;
      this.fOe = parama1;
      Object localObject;
      this.fOf = localObject;
      AppMethodBeat.o(177044);
    }
    
    public b(String paramString, a<y> parama)
    {
      this(paramString, (a)new d.g.b.l(parama) {}, locala);
      AppMethodBeat.i(105332);
      AppMethodBeat.o(105332);
    }
    
    public final String abN()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.fOf;
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
      String str = (String)this.fOe.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class d<T>
    extends EmojiDebugUI.a
  {
    final ah.a fOh;
    private final List<String> fOi;
    final List<T> fOj;
    private final String title;
    
    public d(ah.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.fOh = paramList;
      this.fOi = paramList1;
      this.fOj = localObject;
      AppMethodBeat.o(105336);
    }
    
    public final String abN()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)this.fOi).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)EmojiDebugUI.this, "", this.fOi, j.l((Iterable)j.o((Collection)this.fOi)), "", (h.d)new a(this));
      AppMethodBeat.o(105335);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.fOj.indexOf(EmojiDebugUI.a(this.fOh, this.fOj.get(0)));
      if ((i >= 0) && (i < this.fOi.size()))
      {
        str = (String)this.fOi.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.fOi.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
    static final class a
      implements h.d
    {
      a(EmojiDebugUI.d paramd) {}
      
      public final void ct(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(105333);
        EmojiDebugUI.b(this.fOk.fOh, this.fOk.fOj.get(paramInt2));
        Object localObject = EmojiDebugUI.a(this.fOk.fOd);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
  public final class e
    extends RecyclerView.a<EmojiDebugUI.f>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(105339);
      int i = EmojiDebugUI.b(this.fOd).size();
      AppMethodBeat.o(105339);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(EmojiDebugUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(105337);
        ((EmojiDebugUI.a)EmojiDebugUI.b(this.fOl.fOd).get(this.fOm)).onClick();
        AppMethodBeat.o(105337);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"})
  public final class g
    extends EmojiDebugUI.a
  {
    private final a<y> fOf;
    private final a<String> fOn;
    private final a<String> fOo;
    
    public g(a<String> parama, a<y> parama1)
    {
      super();
      AppMethodBeat.i(105345);
      this.fOn = parama;
      this.fOo = parama1;
      Object localObject;
      this.fOf = localObject;
      AppMethodBeat.o(105345);
    }
    
    public final String abN()
    {
      AppMethodBeat.i(105342);
      String str = (String)this.fOn.invoke();
      AppMethodBeat.o(105342);
      return str;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105344);
      a locala = this.fOf;
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
      String str = (String)this.fOo.invoke();
      AppMethodBeat.o(105343);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GroupItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class h
    extends EmojiDebugUI.a
  {
    private final String title;
    
    public h()
    {
      super();
      AppMethodBeat.i(209807);
      this.title = localObject;
      AppMethodBeat.o(209807);
    }
    
    public final String abN()
    {
      return this.title;
    }
    
    public final void onClick() {}
    
    public final String value()
    {
      return "";
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements a<y>
  {
    l(EmojiDebugUI paramEmojiDebugUI, aw paramaw)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements a<y>
  {
    m(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements a<y>
  {
    n(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.l
    implements a<y>
  {
    public static final o fOt;
    
    static
    {
      AppMethodBeat.i(183950);
      fOt = new o();
      AppMethodBeat.o(183950);
    }
    
    o()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements a<y>
  {
    p(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements a<y>
  {
    public static final q fOu;
    
    static
    {
      AppMethodBeat.i(209810);
      fOu = new q();
      AppMethodBeat.o(209810);
    }
    
    q()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.l
    implements a<y>
  {
    public static final r fOv;
    
    static
    {
      AppMethodBeat.i(209812);
      fOv = new r();
      AppMethodBeat.o(209812);
    }
    
    r()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements a<y>
  {
    s(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements a<y>
  {
    public static final v fOw;
    
    static
    {
      AppMethodBeat.i(105352);
      fOw = new v();
      AppMethodBeat.o(105352);
    }
    
    v()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements a<y>
  {
    w(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements a<y>
  {
    public static final x fOx;
    
    static
    {
      AppMethodBeat.i(105355);
      fOx = new x();
      AppMethodBeat.o(105355);
    }
    
    x()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.l
    implements a<String>
  {
    public static final y fOy;
    
    static
    {
      AppMethodBeat.i(177048);
      fOy = new y();
      AppMethodBeat.o(177048);
    }
    
    y()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class z
    extends d.g.b.l
    implements a<y>
  {
    public static final z fOz;
    
    static
    {
      AppMethodBeat.i(105357);
      fOz = new z();
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