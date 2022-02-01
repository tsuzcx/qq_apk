package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
public final class RecordTypeSelectView$c
  extends RecyclerView.a<RecyclerView.v>
{
  private Context context;
  
  public RecordTypeSelectView$c(Context paramContext)
  {
    AppMethodBeat.i(254515);
    this.context = localObject;
    AppMethodBeat.o(254515);
  }
  
  private final int Mh(int paramInt)
  {
    AppMethodBeat.i(254514);
    paramInt = (com.tencent.mm.cb.a.jn(this.context) - paramInt) / 2;
    AppMethodBeat.o(254514);
    return paramInt;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(254511);
    p.h(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(this.context).inflate(2131494604, paramViewGroup, false);
    paramViewGroup = (RecyclerView.v)new b(paramViewGroup, paramViewGroup);
    AppMethodBeat.o(254511);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, final int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(254513);
    p.h(paramv, "viewHolder");
    paramv = paramv.aus;
    if (paramv == null)
    {
      paramv = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(254513);
      throw paramv;
    }
    paramv = (TextView)paramv;
    paramv.setText((CharSequence)RecordTypeSelectView.d(this.whB).get(paramInt));
    float f = paramv.getPaint().measureText((String)RecordTypeSelectView.d(this.whB).get(paramInt)) + com.tencent.mm.cb.a.aG(this.context, 2131165303);
    Log.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + paramInt + " width:" + f);
    Object localObject = paramv.getLayoutParams();
    if (localObject == null)
    {
      paramv = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(254513);
      throw paramv;
    }
    localObject = (RecyclerView.LayoutParams)localObject;
    if (paramInt == 0) {}
    for (int i = Mh((int)f);; i = 0)
    {
      ((RecyclerView.LayoutParams)localObject).setMarginStart(i);
      localObject = paramv.getLayoutParams();
      if (localObject != null) {
        break;
      }
      paramv = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(254513);
      throw paramv;
    }
    localObject = (RecyclerView.LayoutParams)localObject;
    i = j;
    if (paramInt == getItemCount() - 1) {
      i = Mh((int)f);
    }
    ((RecyclerView.LayoutParams)localObject).setMarginEnd(i);
    if (paramInt == RecordTypeSelectView.a(this.whB)) {}
    for (f = 1.0F;; f = 0.5F)
    {
      paramv.setAlpha(f);
      paramv.setTag(Integer.valueOf(paramInt));
      paramv.setOnClickListener((View.OnClickListener)new a(this, paramInt));
      AppMethodBeat.o(254513);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(254512);
    int i = RecordTypeSelectView.d(this.whB).size();
    AppMethodBeat.o(254512);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(RecordTypeSelectView.c paramc, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254510);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      RecordTypeSelectView.e(this.whC.whB).invoke(Integer.valueOf(paramInt));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254510);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
  public static final class b
    extends RecyclerView.v
  {
    b(View paramView1, View paramView2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView.c
 * JD-Core Version:    0.7.0.1
 */