package com.tencent.mm.live.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.e;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"})
public final class LiveUIG
  extends MMActivity
{
  public static final c kJi;
  private final LinkedList<d> kJf;
  private a kJg;
  private ListView kJh;
  
  static
  {
    AppMethodBeat.i(197712);
    kJi = new c((byte)0);
    AppMethodBeat.o(197712);
  }
  
  public LiveUIG()
  {
    AppMethodBeat.i(197711);
    this.kJf = new LinkedList();
    AppMethodBeat.o(197711);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197708);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.e.live_profile);
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(197708);
      throw paramBundle;
    }
    this.kJh = ((ListView)paramBundle);
    this.kJg = new a();
    paramBundle = this.kJh;
    if (paramBundle == null) {
      p.iCn();
    }
    a locala = this.kJg;
    if (locala == null) {
      p.bGy("adapter");
    }
    paramBundle.setAdapter((ListAdapter)locala);
    this.kJf.add(new b("Live Mode 开关", ar.a.VCv, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.kJf.add(new b("Live DebugView 开关", ar.a.VCx, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.kJf.add(new b("主播自定义房间id", ar.a.VCy, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.kJf.add(new b("观众自定义房间id", ar.a.VCz, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.kJf.add(new b("Live Entrance 开关", ar.a.VCw, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.kJf.add(new b("观众首次微信群直播功能使用条款", ar.a.VDi, new String[] { "open", "close" }, new int[] { 1, 0 }));
    AppMethodBeat.o(197708);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(188829);
      int i = LiveUIG.b(this.kJj).size();
      AppMethodBeat.o(188829);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(188832);
      Object localObject = LiveUIG.b(this.kJj).get(paramInt);
      p.j(localObject, "selectsList[position]");
      AppMethodBeat.o(188832);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(188836);
      p.k(paramViewGroup, "parent");
      paramView = new TextView((Context)this.kJj);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.live.ui.LiveUIG.ITestMenu");
        AppMethodBeat.o(188836);
        throw paramView;
      }
      paramViewGroup = (LiveUIG.d)paramViewGroup;
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.aBd() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(188836);
      return paramView;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveUIG.d paramd, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(193929);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.kJk.cI((View)paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193929);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"})
  public final class b
    implements LiveUIG.d
  {
    private String kJm;
    ar.a kJn;
    private String[] kJo;
    Object kJp;
    
    public b(ar.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(196246);
      this.kJm = parama;
      this.kJn = paramArrayOfString;
      this.kJo = paramObject;
      this.kJp = localObject;
      AppMethodBeat.o(196246);
    }
    
    public final String aBd()
    {
      return this.kJm;
    }
    
    public final void cI(View paramView)
    {
      AppMethodBeat.i(196242);
      p.k(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.kJo.length;
      while (i < j)
      {
        paramView.add(this.kJo[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      com.tencent.mm.ui.base.h.a((Context)LiveUIG.this, "", (List)paramView, (List)localLinkedList, "", (h.e)new a(this));
      AppMethodBeat.o(196242);
    }
    
    public final String value()
    {
      AppMethodBeat.i(196237);
      if ((this.kJp instanceof long[]))
      {
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
      }
      int k;
      int i;
      int i1;
      int j;
      for (int m = (int)((f)localObject1).aHp().a(this.kJn, 0L);; m = ((f)localObject1).aHp().getInt(this.kJn, 0))
      {
        k = -1;
        localObject2 = this.kJp;
        localObject1 = localObject2;
        if (!(localObject2 instanceof int[])) {
          localObject1 = null;
        }
        localObject1 = (int[])localObject1;
        i = k;
        if (localObject1 == null) {
          break;
        }
        i1 = localObject1.length;
        n = 0;
        j = 0;
        for (;;)
        {
          i = k;
          if (n >= i1) {
            break;
          }
          if (localObject1[n] == m) {
            k = j;
          }
          n += 1;
          j += 1;
        }
        localObject1 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject1, "MMKernel.storage()");
      }
      Object localObject2 = this.kJp;
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof long[])) {
        localObject1 = null;
      }
      localObject1 = (long[])localObject1;
      if (localObject1 != null)
      {
        i1 = localObject1.length;
        k = 0;
        n = 0;
        j = i;
        i = n;
        for (;;)
        {
          n = j;
          if (k >= i1) {
            break;
          }
          if ((int)localObject1[k] == m) {
            j = i;
          }
          k += 1;
          i += 1;
        }
      }
      int n = i;
      if ((n >= 0) && (n < this.kJo.length))
      {
        localObject1 = this.kJo[n];
        AppMethodBeat.o(196237);
        return localObject1;
      }
      AppMethodBeat.o(196237);
      return "";
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.e
    {
      a(LiveUIG.b paramb) {}
      
      public final void cS(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(197797);
        ar.a locala;
        Object localObject3;
        try
        {
          Object localObject1 = this.kJq.kJp;
          if (!(localObject1 instanceof long[])) {
            break label132;
          }
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          localObject1 = ((f)localObject1).aHp();
          locala = this.kJq.kJn;
          localObject3 = this.kJq.kJp;
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(197797);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicorMsg.LiveSettingUI", (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(197797);
          return;
        }
        localException.set(locala, Long.valueOf(((long[])localObject3)[paramInt1]));
        for (;;)
        {
          LiveUIG.a(this.kJq.kJj).notifyDataSetChanged();
          AppMethodBeat.o(197797);
          return;
          label132:
          if ((localException instanceof int[]))
          {
            Object localObject2 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject2, "MMKernel.storage()");
            localObject2 = ((f)localObject2).aHp();
            locala = this.kJq.kJn;
            localObject3 = this.kJq.kJp;
            if (localObject3 == null)
            {
              localObject2 = new t("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(197797);
              throw ((Throwable)localObject2);
            }
            ((ao)localObject2).set(locala, Integer.valueOf(((int[])localObject3)[paramInt1]));
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIG$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-logic_release"})
  public static abstract interface d
  {
    public abstract String aBd();
    
    public abstract void cI(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG
 * JD-Core Version:    0.7.0.1
 */