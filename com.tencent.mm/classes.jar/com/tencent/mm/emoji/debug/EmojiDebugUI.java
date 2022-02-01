package com.tencent.mm.emoji.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "addEmoji", "", "md5", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "md5List", "", "createNewColorEmojiFile", "srcResDirPath", "saveFilePath", "emojiVersion", "", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiDebugUI
  extends MMActivity
{
  public static final EmojiDebugUI.c mev;
  private static boolean mey;
  private static boolean mez;
  private final String TAG;
  private final LinkedList<EmojiDebugUI.a> mew;
  private RecyclerView mex;
  
  static
  {
    AppMethodBeat.i(161812);
    mev = new EmojiDebugUI.c((byte)0);
    AppMethodBeat.o(161812);
  }
  
  public EmojiDebugUI()
  {
    AppMethodBeat.i(105360);
    this.TAG = "MicroMsg.EmojiDebugUI";
    this.mew = new LinkedList();
    AppMethodBeat.o(105360);
  }
  
  private static final ah a(EmojiDebugUI paramEmojiDebugUI, String paramString, b paramb, b.a parama)
  {
    AppMethodBeat.i(242299);
    s.u(paramEmojiDebugUI, "this$0");
    s.u(paramString, "$md5");
    s.u(paramb, "$callback");
    int i = parama.errType;
    int j = parama.errCode;
    Log.i(paramEmojiDebugUI.TAG, "addEmoji: " + i + ", " + j);
    if ((i == 0) && (j == 0))
    {
      paramEmojiDebugUI = bl.jba().adju.bza(paramString);
      if (paramEmojiDebugUI.field_catalog != EmojiInfo.aklM)
      {
        paramEmojiDebugUI.field_catalog = EmojiInfo.aklM;
        paramEmojiDebugUI.field_reserved3 = (bl.jba().adju.jdH() + 1);
        bl.jba().adju.M(paramEmojiDebugUI);
        bl.jba().adju.V(0, p.listOf(paramString));
      }
      paramb.invoke(Boolean.TRUE);
    }
    for (;;)
    {
      paramEmojiDebugUI = ah.aiuX;
      AppMethodBeat.o(242299);
      return paramEmojiDebugUI;
      paramb.invoke(Boolean.FALSE);
      d.uiThread((a)new EmojiDebugUI.j(paramEmojiDebugUI, i, j));
    }
  }
  
  private static final void a(ah.a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(242288);
    s.u(parama, "$cancel");
    parama.aiwY = true;
    AppMethodBeat.o(242288);
  }
  
  private static final boolean a(EmojiDebugUI paramEmojiDebugUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(242285);
    s.u(paramEmojiDebugUI, "this$0");
    paramEmojiDebugUI.finish();
    AppMethodBeat.o(242285);
    return true;
  }
  
  public final int getLayoutId()
  {
    return a.h.emoji_debug_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(105359);
    super.onCreate(paramBundle);
    if ((!WeChatEnvironment.hasDebugger()) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
      finish();
    }
    setBackBtn(new EmojiDebugUI..ExternalSyntheticLambda1(this));
    this.mex = ((RecyclerView)findViewById(a.g.emoji_debug_recycler));
    paramBundle = this.mex;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.mex;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new EmojiDebugUI.e(this));
    }
    paramBundle = this.mex;
    if (paramBundle != null) {
      paramBundle.a((RecyclerView.h)new h((Context)this, 1));
    }
    paramBundle = this.mex;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.bZE.notifyChanged();
      }
    }
    this.mew.add(new d("预览裁剪方式", at.a.acYQ, p.listOf(new String[] { "GPU", "CPU" }), p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })));
    this.mew.add(new b("临时屏蔽小尾巴", "", (a)new EmojiDebugUI.v(this)));
    this.mew.add(new b("重置自拍更新红点", "", (a)new EmojiDebugUI.ag(this)));
    this.mew.add(new b("custom from clipboard", "", (a)new ar(this)));
    this.mew.add(new EmojiDebugUI.h(this, ""));
    this.mew.add(new b("Test parse egg", "", (a)EmojiDebugUI.as.mff));
    this.mew.add(new b("list egg", "", (a)new EmojiDebugUI.at(this)));
    this.mew.add(new b("test parse anim", "", (a)new EmojiDebugUI.au(this)));
    this.mew.add(new b("测试打开网页", "", (a)new EmojiDebugUI.av(this)));
    this.mew.add(new b("测试预加载", "", (a)EmojiDebugUI.aw.mfi));
    this.mew.add(new b("Test Sync Emoji", "", (a)new EmojiDebugUI.l(this)));
    this.mew.add(new b("Test Add Emoji", "", (a)new m(this)));
    this.mew.add(new b("Test Clear Emoji", "", (a)new EmojiDebugUI.n(this)));
    this.mew.add(new b("game in", "", (a)new EmojiDebugUI.o(this)));
    this.mew.add(new b("game out", "", (a)new p(this)));
    this.mew.add(new EmojiDebugUI.h(this, ""));
    this.mew.add(new b("Start Sticker Preview", "", (a)new q(this)));
    this.mew.add(new b("copy preview", "", (a)new EmojiDebugUI.r(this)));
    this.mew.add(new b("Clean Sticker Cache", "", (a)EmojiDebugUI.s.meS));
    this.mew.add(new b("test parse", "", (a)new EmojiDebugUI.t(this)));
    this.mew.add(new b("Mock Download Fail", (a)EmojiDebugUI.u.meT, (a)EmojiDebugUI.w.meU));
    this.mew.add(new EmojiDebugUI.h(this, "Emoji Res"));
    this.mew.add(new b("dump new system emoji", "", (a)new EmojiDebugUI.x(this)));
    this.mew.add(new b("make new emoji", "", (a)new EmojiDebugUI.y(this)));
    this.mew.add(new b("make new basic emoji", "", (a)new EmojiDebugUI.z(this)));
    this.mew.add(new b("make new emoji by png", "", (a)new EmojiDebugUI.aa(this)));
    this.mew.add(new b("parse anim emoji", "", (a)new EmojiDebugUI.ab(this)));
    this.mew.add(new b("get smiley", "", (a)new EmojiDebugUI.ac(this)));
    this.mew.add(new d("Sticker Panel Switch", at.a.acYW, p.listOf(new String[] { "use remote config", "enable", "disable" }), p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    paramBundle = MultiProcessMMKV.getMMKV("xlab_effect_config");
    this.mew.add(new b("Toggle multi thread", String.valueOf(paramBundle.getBoolean("multi_thread", false)), (a)new ad(paramBundle, this)));
    this.mew.add(new EmojiDebugUI.g(this, (a)EmojiDebugUI.ae.meX, (a)new EmojiDebugUI.af(paramBundle), (a)new ah(paramBundle, this)));
    this.mew.add(new d("Use CDN?", at.a.acYS, p.listOf(new String[] { "remote config", "yes", "no" }), p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })));
    final int i = this.mew.size();
    paramBundle = new b("Egg Spring: Stop CGI?", s.X("", Boolean.valueOf(mey)));
    paramBundle.meC = ((a)new ai(this, i));
    this.mew.add(paramBundle);
    i = this.mew.size();
    paramBundle = new b("Egg Spring: Stop CDN?", s.X("", Boolean.valueOf(mez)));
    paramBundle.meC = ((a)new aj(this, i));
    this.mew.add(paramBundle);
    this.mew.add(new b("Egg res Info", "", (a)EmojiDebugUI.ak.mfa));
    this.mew.add(new EmojiDebugUI.h(this, ""));
    this.mew.add(new b("GetDesigner", "", (a)al.mfb));
    this.mew.add(new EmojiDebugUI.h(this, "Emoji Suggest"));
    this.mew.add(new b("Show Words", "", (a)new am(this)));
    this.mew.add(new b("Clear Cache", "", (a)an.mfc));
    this.mew.add(new b("Update Word List", "", (a)ao.mfd));
    this.mew.add(new b("Emoji Suggest config", "", (a)new ap(this)));
    this.mew.add(new b("清除秒剪权限请求缓存", "", (a)EmojiDebugUI.aq.mfe));
    AppMethodBeat.o(105359);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends u
    implements a<ah>
  {
    ad(MultiProcessMMKV paramMultiProcessMMKV, EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends u
    implements a<ah>
  {
    ah(MultiProcessMMKV paramMultiProcessMMKV, EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ai
    extends u
    implements a<ah>
  {
    ai(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aj
    extends u
    implements a<ah>
  {
    aj(EmojiDebugUI paramEmojiDebugUI, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class al
    extends u
    implements a<ah>
  {
    public static final al mfb;
    
    static
    {
      AppMethodBeat.i(242291);
      mfb = new al();
      AppMethodBeat.o(242291);
    }
    
    al()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class am
    extends u
    implements a<ah>
  {
    am(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class an
    extends u
    implements a<ah>
  {
    public static final an mfc;
    
    static
    {
      AppMethodBeat.i(242294);
      mfc = new an();
      AppMethodBeat.o(242294);
    }
    
    an()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ao
    extends u
    implements a<ah>
  {
    public static final ao mfd;
    
    static
    {
      AppMethodBeat.i(242257);
      mfd = new ao();
      AppMethodBeat.o(242257);
    }
    
    ao()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ap
    extends u
    implements a<ah>
  {
    ap(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ar
    extends u
    implements a<ah>
  {
    ar(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends EmojiDebugUI.a
  {
    private a<String> meB;
    a<ah> meC;
    private final String title;
    
    public b(String paramString, a<ah> parama)
    {
      this(paramString, (a)new u(parama) {}, locala);
      AppMethodBeat.i(105332);
      AppMethodBeat.o(105332);
    }
    
    public b(a<String> parama, a<ah> parama1)
    {
      super();
      AppMethodBeat.i(177044);
      this.title = parama;
      this.meB = parama1;
      Object localObject;
      this.meC = localObject;
      AppMethodBeat.o(177044);
    }
    
    public final String aUa()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105331);
      Object localObject = this.meC;
      if (localObject != null) {
        ((a)localObject).invoke();
      }
      localObject = EmojiDebugUI.b(EmojiDebugUI.this);
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
      }
      AppMethodBeat.o(105331);
    }
    
    public final String value()
    {
      AppMethodBeat.i(177043);
      String str = (String)this.meB.invoke();
      AppMethodBeat.o(177043);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d<T>
    extends EmojiDebugUI.a
  {
    private final at.a meE;
    private final List<String> meF;
    private final List<T> meG;
    private final String title;
    
    public d(at.a parama, List<String> paramList, List<? extends T> paramList1)
    {
      super();
      AppMethodBeat.i(105336);
      this.title = parama;
      this.meE = paramList;
      this.meF = paramList1;
      this.meG = localObject;
      AppMethodBeat.o(105336);
    }
    
    private static final void a(EmojiDebugUI paramEmojiDebugUI, d paramd, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242227);
      s.u(paramEmojiDebugUI, "this$0");
      s.u(paramd, "this$1");
      EmojiDebugUI.b(paramd.meE, paramd.meG.get(paramInt2));
      paramEmojiDebugUI = EmojiDebugUI.b(paramEmojiDebugUI);
      if (paramEmojiDebugUI != null)
      {
        paramEmojiDebugUI = paramEmojiDebugUI.getAdapter();
        if (paramEmojiDebugUI != null) {
          paramEmojiDebugUI.bZE.notifyChanged();
        }
      }
      AppMethodBeat.o(242227);
    }
    
    public final String aUa()
    {
      return this.title;
    }
    
    public final void onClick()
    {
      AppMethodBeat.i(105335);
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int k = this.meF.size() - 1;
      if (k >= 0) {}
      for (;;)
      {
        int j = i + 1;
        localLinkedList.add(Integer.valueOf(i));
        if (j > k)
        {
          k.a((Context)EmojiDebugUI.this, "", this.meF, p.p((Iterable)p.F((Collection)this.meF)), "", new EmojiDebugUI.d..ExternalSyntheticLambda0(EmojiDebugUI.this, this));
          AppMethodBeat.o(105335);
          return;
        }
        i = j;
      }
    }
    
    public final String value()
    {
      AppMethodBeat.i(105334);
      int i = this.meG.indexOf(EmojiDebugUI.a(this.meE, this.meG.get(0)));
      if ((i >= 0) && (i < this.meF.size()))
      {
        str = (String)this.meF.get(i);
        AppMethodBeat.o(105334);
        return str;
      }
      String str = (String)this.meF.get(0);
      AppMethodBeat.o(105334);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements a<ah>
  {
    m(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements a<ah>
  {
    p(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
    
    private static final ah a(EmojiDebugUI paramEmojiDebugUI, b.a parama)
    {
      AppMethodBeat.i(242246);
      s.u(paramEmojiDebugUI, "this$0");
      parama = bl.jba().adju.bza("9bd1281af3a31710a45b84d736363691");
      EmojiInfo localEmojiInfo = bl.jba().adju.bza("08f223fa83f1ca34e143d1e580252c7c");
      parama.field_catalog = EmojiGroupInfo.aklE;
      localEmojiInfo.field_catalog = EmojiGroupInfo.aklE;
      parama.field_reserved3 = 0;
      localEmojiInfo.field_reserved3 = 0;
      bl.jba().adju.M(parama);
      bl.jba().adju.M(localEmojiInfo);
      Toast.makeText((Context)paramEmojiDebugUI, (CharSequence)"done", 0).show();
      paramEmojiDebugUI = ah.aiuX;
      AppMethodBeat.o(242246);
      return paramEmojiDebugUI;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements a<ah>
  {
    q(EmojiDebugUI paramEmojiDebugUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.debug.EmojiDebugUI
 * JD-Core Version:    0.7.0.1
 */