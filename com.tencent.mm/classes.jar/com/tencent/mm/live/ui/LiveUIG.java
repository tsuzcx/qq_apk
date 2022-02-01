package com.tencent.mm.live.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveUIG
  extends MMActivity
{
  public static final c nlF;
  private final LinkedList<d> nlG;
  private a nlH;
  private ListView nlI;
  
  static
  {
    AppMethodBeat.i(246303);
    nlF = new c((byte)0);
    AppMethodBeat.o(246303);
  }
  
  public LiveUIG()
  {
    AppMethodBeat.i(246283);
    this.nlG = new LinkedList();
    AppMethodBeat.o(246283);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_setting_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246323);
    super.onCreate(paramBundle);
    paramBundle = findViewById(b.e.live_profile);
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(246323);
      throw paramBundle;
    }
    this.nlI = ((ListView)paramBundle);
    this.nlH = new a();
    ListView localListView = this.nlI;
    s.checkNotNull(localListView);
    a locala = this.nlH;
    paramBundle = locala;
    if (locala == null)
    {
      s.bIx("adapter");
      paramBundle = null;
    }
    localListView.setAdapter((ListAdapter)paramBundle);
    this.nlG.add(new b("Live Mode 开关", at.a.adfo, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.nlG.add(new b("Live DebugView 开关", at.a.adfq, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.nlG.add(new b("主播自定义房间id", at.a.adfs, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.nlG.add(new b("观众自定义房间id", at.a.adft, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.nlG.add(new b("Live Entrance 开关", at.a.adfp, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.nlG.add(new b("观众首次微信群直播功能使用条款", at.a.adgd, new String[] { "open", "close" }, new int[] { 1, 0 }));
    AppMethodBeat.o(246323);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends BaseAdapter
  {
    public a()
    {
      AppMethodBeat.i(246242);
      AppMethodBeat.o(246242);
    }
    
    private static final void a(LiveUIG.d paramd, TextView paramTextView, View paramView)
    {
      AppMethodBeat.i(246251);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramd);
      localb.cH(paramTextView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramd, "$item");
      s.u(paramTextView, "$textView");
      paramd.di((View)paramTextView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246251);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(246264);
      int i = LiveUIG.b(this.nlJ).size();
      AppMethodBeat.o(246264);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(246269);
      Object localObject = LiveUIG.b(this.nlJ).get(paramInt);
      s.s(localObject, "selectsList[position]");
      AppMethodBeat.o(246269);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(246285);
      s.u(paramViewGroup, "parent");
      paramView = new TextView((Context)this.nlJ);
      paramViewGroup = (LiveUIG.d)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText((CharSequence)(paramViewGroup.aUa() + "->:" + paramViewGroup.value()));
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new LiveUIG.a..ExternalSyntheticLambda0(paramViewGroup, paramView));
      paramView = (View)paramView;
      AppMethodBeat.o(246285);
      return paramView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements LiveUIG.d
  {
    private String nlK;
    private at.a nlL;
    private String[] nlM;
    private Object nlN;
    
    public b(at.a parama, String[] paramArrayOfString, Object paramObject)
    {
      AppMethodBeat.i(246253);
      this.nlK = parama;
      this.nlL = paramArrayOfString;
      this.nlM = paramObject;
      this.nlN = localObject;
      AppMethodBeat.o(246253);
    }
    
    private static final void a(b paramb, LiveUIG paramLiveUIG, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246263);
      s.u(paramb, "this$0");
      s.u(paramLiveUIG, "this$1");
      try
      {
        Object localObject = paramb.nlN;
        if ((localObject instanceof long[])) {
          h.baE().ban().set(paramb.nlL, Long.valueOf(((long[])paramb.nlN)[paramInt1]));
        }
        for (;;)
        {
          paramLiveUIG = LiveUIG.a(paramLiveUIG);
          paramb = paramLiveUIG;
          if (paramLiveUIG == null)
          {
            s.bIx("adapter");
            paramb = null;
          }
          paramb.notifyDataSetChanged();
          AppMethodBeat.o(246263);
          return;
          if ((localObject instanceof int[])) {
            h.baE().ban().set(paramb.nlL, Integer.valueOf(((int[])paramb.nlN)[paramInt1]));
          }
        }
        return;
      }
      catch (Exception paramb)
      {
        Log.printErrStackTrace("MicorMsg.LiveSettingUI", (Throwable)paramb, "", new Object[0]);
        AppMethodBeat.o(246263);
      }
    }
    
    public final String aUa()
    {
      return this.nlK;
    }
    
    public final void di(View paramView)
    {
      AppMethodBeat.i(246293);
      s.u(paramView, "view");
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      int k = this.nlM.length - 1;
      if (k >= 0) {}
      for (;;)
      {
        int j = i + 1;
        paramView.add(this.nlM[i]);
        localLinkedList.add(Integer.valueOf(i));
        if (j > k)
        {
          k.a((Context)LiveUIG.this, "", (List)paramView, (List)localLinkedList, "", new LiveUIG.b..ExternalSyntheticLambda0(this, LiveUIG.this));
          AppMethodBeat.o(246293);
          return;
        }
        i = j;
      }
    }
    
    public final String value()
    {
      AppMethodBeat.i(246276);
      int k;
      if ((this.nlN instanceof long[]))
      {
        k = (int)h.baE().ban().a(this.nlL, 0L);
        localObject = this.nlN;
        if (!(localObject instanceof int[])) {
          break label118;
        }
      }
      int n;
      int m;
      int j;
      label118:
      for (Object localObject = (int[])localObject;; localObject = null)
      {
        if (localObject == null) {
          break label252;
        }
        n = localObject.length;
        m = 0;
        i = 0;
        j = -1;
        while (m < n)
        {
          if (localObject[m] == k) {
            j = i;
          }
          m += 1;
          i += 1;
        }
        k = h.baE().ban().getInt(this.nlL, 0);
        break;
      }
      label252:
      for (int i = j;; i = -1)
      {
        localObject = this.nlN;
        if ((localObject instanceof long[])) {}
        for (localObject = (long[])localObject; localObject != null; localObject = null)
        {
          int i1 = localObject.length;
          m = 0;
          n = 0;
          j = i;
          i = n;
          for (;;)
          {
            n = j;
            if (m >= i1) {
              break;
            }
            if ((int)localObject[m] == k) {
              j = i;
            }
            m += 1;
            i += 1;
          }
        }
        n = i;
        if ((n >= 0) && (n < this.nlM.length))
        {
          localObject = this.nlM[n];
          AppMethodBeat.o(246276);
          return localObject;
        }
        AppMethodBeat.o(246276);
        return "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIG$Companion;", "", "()V", "TAG", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract String aUa();
    
    public abstract void di(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG
 * JD-Core Version:    0.7.0.1
 */