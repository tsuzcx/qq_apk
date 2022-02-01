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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"})
public final class LiveUIG
  extends MMActivity
{
  public static final c hbP;
  private final LinkedList<d> hbM;
  private a hbN;
  private ListView hbO;
  
  static
  {
    AppMethodBeat.i(216466);
    hbP = new c((byte)0);
    AppMethodBeat.o(216466);
  }
  
  public LiveUIG()
  {
    AppMethodBeat.i(216465);
    this.hbM = new LinkedList();
    AppMethodBeat.o(216465);
  }
  
  public final int getLayoutId()
  {
    return 2131496337;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216464);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131307721);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(216464);
      throw paramBundle;
    }
    this.hbO = ((ListView)paramBundle);
    this.hbN = new a();
    paramBundle = this.hbO;
    if (paramBundle == null) {
      p.gkB();
    }
    a locala = this.hbN;
    if (locala == null) {
      p.bdF("adapter");
    }
    paramBundle.setAdapter((ListAdapter)locala);
    this.hbM.add(new b("Live Mode 开关", am.a.JdD, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.hbM.add(new b("Live DebugView 开关", am.a.JdF, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.hbM.add(new b("主播自定义房间id", am.a.JdG, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.hbM.add(new b("观众自定义房间id", am.a.JdH, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.hbM.add(new b("Live Entrance 开关", am.a.JdE, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.hbM.add(new b("观众首次微信群直播功能使用条款", am.a.Jel, new String[] { "open", "close" }, new int[] { 1, 0 }));
    AppMethodBeat.o(216464);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(216457);
      int i = LiveUIG.b(this.hbQ).size();
      AppMethodBeat.o(216457);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(216458);
      Object localObject = LiveUIG.b(this.hbQ).get(paramInt);
      p.g(localObject, "selectsList[position]");
      AppMethodBeat.o(216458);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(216459);
      p.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.hbQ);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.live.ui.LiveUIG.ITestMenu");
        AppMethodBeat.o(216459);
        throw paramView;
      }
      paramViewGroup = (LiveUIG.d)paramViewGroup;
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.aeD() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(216459);
      return paramView;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveUIG.d paramd, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(216456);
        b localb = new b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.hbR.cy((View)paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216456);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"})
  public final class b
    implements LiveUIG.d
  {
    private String hbT;
    am.a hbU;
    private String[] hbV;
    Object hbW;
    
    public b(am.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(216463);
      this.hbT = parama;
      this.hbU = paramArrayOfString;
      this.hbV = paramObject;
      this.hbW = localObject;
      AppMethodBeat.o(216463);
    }
    
    public final String aeD()
    {
      return this.hbT;
    }
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(216462);
      p.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.hbV.length;
      while (i < j)
      {
        paramView.add(this.hbV[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)LiveUIG.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(216462);
    }
    
    public final String value()
    {
      AppMethodBeat.i(216461);
      if ((this.hbW instanceof long[]))
      {
        localObject1 = g.ajR();
        p.g(localObject1, "MMKernel.storage()");
      }
      int k;
      int i;
      int i1;
      int j;
      for (int m = (int)((e)localObject1).ajA().a(this.hbU, 0L);; m = ((e)localObject1).ajA().getInt(this.hbU, 0))
      {
        k = -1;
        localObject2 = this.hbW;
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
        localObject1 = g.ajR();
        p.g(localObject1, "MMKernel.storage()");
      }
      Object localObject2 = this.hbW;
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
      if ((n >= 0) && (n < this.hbV.length))
      {
        localObject1 = this.hbV[n];
        AppMethodBeat.o(216461);
        return localObject1;
      }
      AppMethodBeat.o(216461);
      return "";
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(LiveUIG.b paramb) {}
      
      public final void cv(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(216460);
        am.a locala;
        Object localObject3;
        try
        {
          Object localObject1 = this.hbX.hbW;
          if (!(localObject1 instanceof long[])) {
            break label132;
          }
          localObject1 = g.ajR();
          p.g(localObject1, "MMKernel.storage()");
          localObject1 = ((e)localObject1).ajA();
          locala = this.hbX.hbU;
          localObject3 = this.hbX.hbW;
          if (localObject3 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(216460);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicorMsg.LiveSettingUI", (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(216460);
          return;
        }
        localException.set(locala, Long.valueOf(((long[])localObject3)[paramInt1]));
        for (;;)
        {
          LiveUIG.a(this.hbX.hbQ).notifyDataSetChanged();
          AppMethodBeat.o(216460);
          return;
          label132:
          if ((localException instanceof int[]))
          {
            Object localObject2 = g.ajR();
            p.g(localObject2, "MMKernel.storage()");
            localObject2 = ((e)localObject2).ajA();
            locala = this.hbX.hbU;
            localObject3 = this.hbX.hbW;
            if (localObject3 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(216460);
              throw ((Throwable)localObject2);
            }
            ((aj)localObject2).set(locala, Integer.valueOf(((int[])localObject3)[paramInt1]));
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIG$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class c {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-logic_release"})
  public static abstract interface d
  {
    public abstract String aeD();
    
    public abstract void cy(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG
 * JD-Core Version:    0.7.0.1
 */