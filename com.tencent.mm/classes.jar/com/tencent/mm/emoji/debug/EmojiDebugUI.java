package com.tencent.mm.emoji.debug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.c;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.s;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "addEmoji", "", "md5", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "md5List", "", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI
  extends MMActivity
{
  private static boolean jEB;
  private static boolean jEC;
  public static final EmojiDebugUI.c jED;
  private final String TAG;
  private RecyclerView jEA;
  private final LinkedList<a> jEz;
  
  static
  {
    AppMethodBeat.i(161812);
    jED = new EmojiDebugUI.c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.jEz = new LinkedList();
    AppMethodBeat.o(105360);
  }
  
  public final int getLayoutId()
  {
    return a.h.emoji_debug_ui;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(105359);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new EmojiDebugUI.l(this));
    this.jEA = ((RecyclerView)findViewById(a.g.emoji_debug_recycler));
    paramBundle = this.jEA;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.jEA;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new e());
    }
    paramBundle = this.jEA;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new i((Context)this, 1));
    }
    paramBundle = this.jEA;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
    }
    this.jEz.add(new d("预览裁剪方式", ar.a.Vxf, j.listOf(new String[] { "GPU", "CPU" }), j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.jEz.add(new b("临时屏蔽小尾巴", "", (kotlin.g.a.a)new EmojiDebugUI.w(this)));
    this.jEz.add(new b("重置自拍更新红点", "", (kotlin.g.a.a)new EmojiDebugUI.ah(this)));
    this.jEz.add(new h(""));
    this.jEz.add(new b("Test parse egg", "", (kotlin.g.a.a)EmojiDebugUI.an.jFu));
    this.jEz.add(new b("test parse anim", "", (kotlin.g.a.a)new ao(this)));
    this.jEz.add(new b("测试打开网页", "", (kotlin.g.a.a)new EmojiDebugUI.ap(this)));
    this.jEz.add(new b("测试预加载", "", (kotlin.g.a.a)EmojiDebugUI.aq.jFv));
    this.jEz.add(new b("Test Sync Emoji", "", (kotlin.g.a.a)new ar(this)));
    this.jEz.add(new b("Test Add Emoji", "", (kotlin.g.a.a)new as(this)));
    this.jEz.add(new b("Test Clear Emoji", "", (kotlin.g.a.a)new m(this)));
    this.jEz.add(new b("game in", "", (kotlin.g.a.a)new EmojiDebugUI.n(this)));
    this.jEz.add(new b("game out", "", (kotlin.g.a.a)new o(this)));
    this.jEz.add(new h(""));
    this.jEz.add(new b("Start Sticker Preview", "", (kotlin.g.a.a)new EmojiDebugUI.p(this)));
    this.jEz.add(new b("copy preview", "", (kotlin.g.a.a)new EmojiDebugUI.q(this)));
    this.jEz.add(new b("Clean Sticker Cache", "", (kotlin.g.a.a)EmojiDebugUI.r.jFd));
    this.jEz.add(new b("test parse", "", (kotlin.g.a.a)new EmojiDebugUI.s(this)));
    this.jEz.add(new b("Mock Download Fail", (kotlin.g.a.a)t.jFe, (kotlin.g.a.a)u.jFf));
    this.jEz.add(new h("Emoji Res"));
    this.jEz.add(new b("dump color_emoji", "", (kotlin.g.a.a)new v(this)));
    this.jEz.add(new b("merge color_emoji", "", (kotlin.g.a.a)new x(this)));
    this.jEz.add(new b("parse anim emoji", "", (kotlin.g.a.a)new y(this)));
    this.jEz.add(new b("get smiley", "", (kotlin.g.a.a)new z(this)));
    this.jEz.add(new d("Sticker Panel Switch", ar.a.Vxk, j.listOf(new String[] { "use remote config", "enable", "disable" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = MultiProcessMMKV.getMMKV("xlab_effect_config");
    this.jEz.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (kotlin.g.a.a)new aa(this, paramBundle)));
    this.jEz.add(new g((kotlin.g.a.a)EmojiDebugUI.ab.jFn, (kotlin.g.a.a)new EmojiDebugUI.ac(paramBundle), (kotlin.g.a.a)new ad(this, paramBundle)));
    this.jEz.add(new d("Use CDN?", ar.a.Vxg, j.listOf(new String[] { "remote config", "yes", "no" }), j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.jEz.size();
    paramBundle = new b("Egg Spring: Stop CGI?", jEB);
    paramBundle.jEG = ((kotlin.g.a.a)new ae(this, i));
    this.jEz.add(paramBundle);
    i = this.jEz.size();
    paramBundle = new b("Egg Spring: Stop CDN?", jEC);
    paramBundle.jEG = ((kotlin.g.a.a)new af(this, i));
    this.jEz.add(paramBundle);
    this.jEz.add(new b("Egg res Info", "", (kotlin.g.a.a)EmojiDebugUI.ag.jFq));
    this.jEz.add(new h(""));
    this.jEz.add(new b("GetDesigner", "", (kotlin.g.a.a)ai.jFr));
    this.jEz.add(new h("Emoji Suggest"));
    this.jEz.add(new b("Show Words", "", (kotlin.g.a.a)new aj(this)));
    this.jEz.add(new b("Clear Cache", "", (kotlin.g.a.a)ak.jFs));
    this.jEz.add(new b("Update Word List", "", (kotlin.g.a.a)al.jFt));
    this.jEz.add(new b("Emoji Suggest config", "", (kotlin.g.a.a)new am(this)));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "textSize", "", "title", "", "value", "plugin-emojisdk_release"})
  public abstract class a
  {
    public abstract String aBd();
    
    public float aBe()
    {
      return 0.0F;
    }
    
    public abstract void onClick();
    
    public abstract String value();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.a<x>
  {
    aa(EmojiDebugUI paramEmojiDebugUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ad
    extends q
    implements kotlin.g.a.a<x>
  {
    ad(EmojiDebugUI paramEmojiDebugUI, MultiProcessMMKV paramMultiProcessMMKV)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.a<x>
  {
    ae(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.a<x>
  {
    af(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ai
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final ai jFr;
    
    static
    {
      AppMethodBeat.i(228447);
      jFr = new ai();
      AppMethodBeat.o(228447);
    }
    
    ai()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aj
    extends q
    implements kotlin.g.a.a<x>
  {
    aj(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ak
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final ak jFs;
    
    static
    {
      AppMethodBeat.i(226467);
      jFs = new ak();
      AppMethodBeat.o(226467);
    }
    
    ak()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class al
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final al jFt;
    
    static
    {
      AppMethodBeat.i(224180);
      jFt = new al();
      AppMethodBeat.o(224180);
    }
    
    al()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class am
    extends q
    implements kotlin.g.a.a<x>
  {
    am(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ao
    extends q
    implements kotlin.g.a.a<x>
  {
    ao(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ar
    extends q
    implements kotlin.g.a.a<x>
  {
    ar(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class as
    extends q
    implements kotlin.g.a.a<x>
  {
    as(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
  public final class b
    extends EmojiDebugUI.a
  {
    private kotlin.g.a.a<String> jEF;
    kotlin.g.a.a<x> jEG;
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
      this.jEF = parama1;
      Object localObject;
      this.jEG = localObject;
      AppMethodBeat.o(177044);
    }
    
    public final String aBd()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.jEG;
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
      String str = (String)this.jEF.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
  public final class d<T>
    extends EmojiDebugUI.a
  {
    final ar.a jEI;
    private final List<String> jEJ;
    final List<T> jEK;
    private final String title;
    
    public d(ar.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.jEI = paramList;
      this.jEJ = paramList1;
      this.jEK = localObject;
      AppMethodBeat.o(105336);
    }
    
    public final String aBd()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)this.jEJ).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)EmojiDebugUI.this, "", this.jEJ, j.p((Iterable)j.p((Collection)this.jEJ)), "", (h.e)new a(this));
      AppMethodBeat.o(105335);
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.jEK.indexOf(EmojiDebugUI.a(this.jEI, this.jEK.get(0)));
      if ((i >= 0) && (i < this.jEJ.size()))
      {
        str = (String)this.jEJ.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.jEJ.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
    static final class a
      implements h.e
    {
      a(EmojiDebugUI.d paramd) {}
      
      public final void cS(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(105333);
        EmojiDebugUI.b(this.jEL.jEI, this.jEL.jEK.get(paramInt2));
        Object localObject = EmojiDebugUI.a(this.jEL.jEE);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
  public final class e
    extends RecyclerView.a<EmojiDebugUI.f>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(105339);
      int i = EmojiDebugUI.b(this.jEE).size();
      AppMethodBeat.o(105339);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(EmojiDebugUI.e parame, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(105337);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((EmojiDebugUI.a)EmojiDebugUI.b(this.jEM.jEE).get(this.jEN)).onClick();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105337);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Landroid/widget/TextView;)V", "textView", "getTextView", "()Landroid/widget/TextView;", "plugin-emojisdk_release"})
  public final class f
    extends RecyclerView.v
  {
    final TextView bFR;
    
    public f()
    {
      super();
      AppMethodBeat.i(105341);
      this.bFR = localObject;
      AppMethodBeat.o(105341);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"})
  public final class g
    extends EmojiDebugUI.a
  {
    private final kotlin.g.a.a<x> jEG;
    private final kotlin.g.a.a<String> jEO;
    private final kotlin.g.a.a<String> jEP;
    
    public g(kotlin.g.a.a<String> parama, kotlin.g.a.a<x> parama1)
    {
      super();
      AppMethodBeat.i(105345);
      this.jEO = parama;
      this.jEP = parama1;
      Object localObject;
      this.jEG = localObject;
      AppMethodBeat.o(105345);
    }
    
    public final String aBd()
    {
      AppMethodBeat.i(105342);
      String str = (String)this.jEO.invoke();
      AppMethodBeat.o(105342);
      return str;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105344);
      kotlin.g.a.a locala = this.jEG;
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
      String str = (String)this.jEP.invoke();
      AppMethodBeat.o(105343);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GroupItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "onClick", "", "textSize", "", "value", "plugin-emojisdk_release"})
  public final class h
    extends EmojiDebugUI.a
  {
    private final String title;
    
    public h()
    {
      super();
      AppMethodBeat.i(226175);
      this.title = localObject;
      AppMethodBeat.o(226175);
    }
    
    public final String aBd()
    {
      return this.title;
    }
    
    public final float aBe()
    {
      return 30.0F;
    }
    
    public final void onClick() {}
    
    public final String value()
    {
      return "";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(EmojiDebugUI paramEmojiDebugUI, List paramList, aa.a parama1, aa.d paramd, s params, Object paramObject, aa.a parama2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    j(EmojiDebugUI paramEmojiDebugUI, String paramString, kotlin.g.a.b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<String>
  {
    public static final t jFe;
    
    static
    {
      AppMethodBeat.i(226521);
      jFe = new t();
      AppMethodBeat.o(226521);
    }
    
    t()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final u jFf;
    
    static
    {
      AppMethodBeat.i(227337);
      jFf = new u();
      AppMethodBeat.o(227337);
    }
    
    u()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<x>
  {
    v(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<x>
  {
    x(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.a<x>
  {
    y(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.a<x>
  {
    z(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI
 * JD-Core Version:    0.7.0.1
 */