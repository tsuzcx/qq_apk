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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"})
public final class LiveUIG
  extends MMActivity
{
  public static final c gZc;
  private final LinkedList<d> gYZ;
  private a gZa;
  private ListView gZb;
  
  static
  {
    AppMethodBeat.i(212838);
    gZc = new c((byte)0);
    AppMethodBeat.o(212838);
  }
  
  public LiveUIG()
  {
    AppMethodBeat.i(212837);
    this.gYZ = new LinkedList();
    AppMethodBeat.o(212837);
  }
  
  public final int getLayoutId()
  {
    return 2131496337;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212836);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131307721);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(212836);
      throw paramBundle;
    }
    this.gZb = ((ListView)paramBundle);
    this.gZa = new a();
    paramBundle = this.gZb;
    if (paramBundle == null) {
      p.gfZ();
    }
    a locala = this.gZa;
    if (locala == null) {
      p.bcb("adapter");
    }
    paramBundle.setAdapter((ListAdapter)locala);
    this.gYZ.add(new b("Live Mode 开关", al.a.IIX, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gYZ.add(new b("Live DebugView 开关", al.a.IIZ, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gYZ.add(new b("主播自定义房间id", al.a.IJa, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gYZ.add(new b("观众自定义房间id", al.a.IJb, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gYZ.add(new b("Live Entrance 开关", al.a.IIY, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gYZ.add(new b("观众首次微信群直播功能使用条款", al.a.IJF, new String[] { "open", "close" }, new int[] { 1, 0 }));
    AppMethodBeat.o(212836);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(212829);
      int i = LiveUIG.b(this.gZd).size();
      AppMethodBeat.o(212829);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(212830);
      Object localObject = LiveUIG.b(this.gZd).get(paramInt);
      p.g(localObject, "selectsList[position]");
      AppMethodBeat.o(212830);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(212831);
      p.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.gZd);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.live.ui.LiveUIG.ITestMenu");
        AppMethodBeat.o(212831);
        throw paramView;
      }
      paramViewGroup = (LiveUIG.d)paramViewGroup;
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.aer() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(212831);
      return paramView;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveUIG.d paramd, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(212828);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.gZe.cy((View)paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212828);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"})
  public final class b
    implements LiveUIG.d
  {
    private String gZg;
    al.a gZh;
    private String[] gZi;
    Object gZj;
    
    public b(al.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(212835);
      this.gZg = parama;
      this.gZh = paramArrayOfString;
      this.gZi = paramObject;
      this.gZj = localObject;
      AppMethodBeat.o(212835);
    }
    
    public final String aer()
    {
      return this.gZg;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(212834);
      p.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.gZi.length;
      while (i < j)
      {
        paramView.add(this.gZi[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)LiveUIG.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(212834);
    }
    
    public final String value()
    {
      AppMethodBeat.i(212833);
      if ((this.gZj instanceof long[]))
      {
        localObject1 = g.ajC();
        p.g(localObject1, "MMKernel.storage()");
      }
      int k;
      int i;
      int i1;
      int j;
      for (int m = (int)((e)localObject1).ajl().a(this.gZh, 0L);; m = ((e)localObject1).ajl().getInt(this.gZh, 0))
      {
        k = -1;
        localObject2 = this.gZj;
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
        localObject1 = g.ajC();
        p.g(localObject1, "MMKernel.storage()");
      }
      Object localObject2 = this.gZj;
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
      if ((n >= 0) && (n < this.gZi.length))
      {
        localObject1 = this.gZi[n];
        AppMethodBeat.o(212833);
        return localObject1;
      }
      AppMethodBeat.o(212833);
      return "";
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(LiveUIG.b paramb) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(212832);
        al.a locala;
        Object localObject3;
        try
        {
          Object localObject1 = this.gZk.gZj;
          if (!(localObject1 instanceof long[])) {
            break label132;
          }
          localObject1 = g.ajC();
          p.g(localObject1, "MMKernel.storage()");
          localObject1 = ((e)localObject1).ajl();
          locala = this.gZk.gZh;
          localObject3 = this.gZk.gZj;
          if (localObject3 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(212832);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicorMsg.LiveSettingUI", (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(212832);
          return;
        }
        localException.set(locala, Long.valueOf(((long[])localObject3)[paramInt1]));
        for (;;)
        {
          LiveUIG.a(this.gZk.gZd).notifyDataSetChanged();
          AppMethodBeat.o(212832);
          return;
          label132:
          if ((localException instanceof int[]))
          {
            Object localObject2 = g.ajC();
            p.g(localObject2, "MMKernel.storage()");
            localObject2 = ((e)localObject2).ajl();
            locala = this.gZk.gZh;
            localObject3 = this.gZk.gZj;
            if (localObject3 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(212832);
              throw ((Throwable)localObject2);
            }
            ((ai)localObject2).set(locala, Integer.valueOf(((int[])localObject3)[paramInt1]));
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIG$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class c {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-logic_release"})
  public static abstract interface d
  {
    public abstract String aer();
    
    public abstract void cy(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG
 * JD-Core Version:    0.7.0.1
 */