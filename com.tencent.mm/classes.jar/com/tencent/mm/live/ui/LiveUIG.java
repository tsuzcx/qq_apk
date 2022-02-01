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
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"})
public final class LiveUIG
  extends MMActivity
{
  public static final LiveUIG.c gFs;
  private final LinkedList<d> gFp;
  private a gFq;
  private ListView gFr;
  
  static
  {
    AppMethodBeat.i(190548);
    gFs = new LiveUIG.c((byte)0);
    AppMethodBeat.o(190548);
  }
  
  public LiveUIG()
  {
    AppMethodBeat.i(190547);
    this.gFp = new LinkedList();
    AppMethodBeat.o(190547);
  }
  
  public final int getLayoutId()
  {
    return 2131496337;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190546);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131307721);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(190546);
      throw paramBundle;
    }
    this.gFr = ((ListView)paramBundle);
    this.gFq = new a();
    paramBundle = this.gFr;
    if (paramBundle == null) {
      k.fOy();
    }
    a locala = this.gFq;
    if (locala == null) {
      k.aVY("adapter");
    }
    paramBundle.setAdapter((ListAdapter)locala);
    this.gFp.add(new b("Live Mode 开关", ah.a.GWa, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gFp.add(new b("Live DebugView 开关", ah.a.GWc, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gFp.add(new b("主播自定义房间id", ah.a.GWd, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gFp.add(new b("观众自定义房间id", ah.a.GWe, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gFp.add(new b("Live Entrance 开关", ah.a.GWb, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.gFp.add(new b("观众首次微信群直播功能使用条款", ah.a.GWE, new String[] { "open", "close" }, new int[] { 1, 0 }));
    AppMethodBeat.o(190546);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"})
  public final class a
    extends BaseAdapter
  {
    public final int getCount()
    {
      AppMethodBeat.i(190539);
      int i = LiveUIG.b(this.gFt).size();
      AppMethodBeat.o(190539);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(190540);
      Object localObject = LiveUIG.b(this.gFt).get(paramInt);
      k.g(localObject, "selectsList[position]");
      AppMethodBeat.o(190540);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    @SuppressLint({"SetTextI18n"})
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(190541);
      k.h(paramViewGroup, "parent");
      paramView = new TextView((Context)this.gFt);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.live.ui.LiveUIG.ITestMenu");
        AppMethodBeat.o(190541);
        throw paramView;
      }
      paramViewGroup = (LiveUIG.d)paramViewGroup;
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.abN() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(a.fromDPToPix(ai.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener((View.OnClickListener)new a(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(190541);
      return paramView;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveUIG.d paramd, TextView paramTextView) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190538);
        this.gFu.cx((View)paramView);
        AppMethodBeat.o(190538);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"})
  public final class b
    implements LiveUIG.d
  {
    private String gFw;
    ah.a gFx;
    private String[] gFy;
    Object gFz;
    
    public b(ah.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(190545);
      this.gFw = parama;
      this.gFx = paramArrayOfString;
      this.gFy = paramObject;
      this.gFz = localObject;
      AppMethodBeat.o(190545);
    }
    
    public final String abN()
    {
      return this.gFw;
    }
    
    public final void cx(View paramView)
    {
      AppMethodBeat.i(190544);
      k.h(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int j = this.gFy.length;
      while (i < j)
      {
        paramView.add(this.gFy[i]);
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      h.a((Context)LiveUIG.this, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
      AppMethodBeat.o(190544);
    }
    
    public final String value()
    {
      AppMethodBeat.i(190543);
      if ((this.gFz instanceof long[]))
      {
        localObject1 = g.agR();
        k.g(localObject1, "MMKernel.storage()");
      }
      int k;
      int i;
      int i1;
      int j;
      for (int m = (int)((e)localObject1).agA().a(this.gFx, 0L);; m = ((e)localObject1).agA().getInt(this.gFx, 0))
      {
        k = -1;
        localObject2 = this.gFz;
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
        localObject1 = g.agR();
        k.g(localObject1, "MMKernel.storage()");
      }
      Object localObject2 = this.gFz;
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
      if ((n >= 0) && (n < this.gFy.length))
      {
        localObject1 = this.gFy[n];
        AppMethodBeat.o(190543);
        return localObject1;
      }
      AppMethodBeat.o(190543);
      return "";
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
    static final class a
      implements h.d
    {
      a(LiveUIG.b paramb) {}
      
      public final void ct(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(190542);
        ah.a locala;
        Object localObject3;
        try
        {
          Object localObject1 = this.gFA.gFz;
          if (!(localObject1 instanceof long[])) {
            break label132;
          }
          localObject1 = g.agR();
          k.g(localObject1, "MMKernel.storage()");
          localObject1 = ((e)localObject1).agA();
          locala = this.gFA.gFx;
          localObject3 = this.gFA.gFz;
          if (localObject3 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
            AppMethodBeat.o(190542);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicorMsg.LiveSettingUI", (Throwable)localException, "", new Object[0]);
          AppMethodBeat.o(190542);
          return;
        }
        localException.set(locala, Long.valueOf(((long[])localObject3)[paramInt1]));
        for (;;)
        {
          LiveUIG.a(this.gFA.gFt).notifyDataSetChanged();
          AppMethodBeat.o(190542);
          return;
          label132:
          if ((localException instanceof int[]))
          {
            Object localObject2 = g.agR();
            k.g(localObject2, "MMKernel.storage()");
            localObject2 = ((e)localObject2).agA();
            locala = this.gFA.gFx;
            localObject3 = this.gFA.gFz;
            if (localObject3 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
              AppMethodBeat.o(190542);
              throw ((Throwable)localObject2);
            }
            ((ae)localObject2).set(locala, Integer.valueOf(((int[])localObject3)[paramInt1]));
          }
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-logic_release"})
  public static abstract interface d
  {
    public abstract String abN();
    
    public abstract void cx(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG
 * JD-Core Version:    0.7.0.1
 */