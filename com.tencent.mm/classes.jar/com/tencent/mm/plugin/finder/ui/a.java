package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;", "", "activity", "Landroid/app/Activity;", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "", "_vals", "(Landroid/app/Activity;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "getActivity", "()Landroid/app/Activity;", "value", "getValue", "()Ljava/lang/String;", "get", "field", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "plugin-finder_release"})
public final class a
{
  private final Activity activity;
  ah.a gFx;
  private String[] gFy;
  Object gFz;
  
  public a(Activity paramActivity, ah.a parama, String[] paramArrayOfString, Object paramObject)
  {
    AppMethodBeat.i(203074);
    this.activity = paramActivity;
    this.gFx = parama;
    this.gFy = paramArrayOfString;
    this.gFz = paramObject;
    AppMethodBeat.o(203074);
  }
  
  public final void a(final MMPreference paramMMPreference, final k paramk)
  {
    AppMethodBeat.i(203073);
    d.g.b.k.h(paramMMPreference, "activity");
    d.g.b.k.h(paramk, "operation");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    int j = this.gFy.length;
    while (i < j)
    {
      localLinkedList1.add(this.gFy[i]);
      localLinkedList2.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)paramMMPreference, "", (List)localLinkedList1, (List)localLinkedList2, "", (h.d)new a(this, paramk, paramMMPreference));
    AppMethodBeat.o(203073);
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(203072);
    if ((this.gFz instanceof long[]))
    {
      localObject1 = g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
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
      d.g.b.k.g(localObject1, "MMKernel.storage()");
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
      AppMethodBeat.o(203072);
      return localObject1;
    }
    AppMethodBeat.o(203072);
    return "";
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
  static final class a
    implements h.d
  {
    a(a parama, k paramk, MMPreference paramMMPreference) {}
    
    public final void ct(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203071);
      Object localObject3;
      Object localObject4;
      try
      {
        Object localObject1 = this.rFq.gFz;
        if (!(localObject1 instanceof long[])) {
          break label146;
        }
        localObject1 = g.agR();
        d.g.b.k.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).agA();
        localObject3 = this.rFq.gFx;
        localObject4 = this.rFq.gFz;
        if (localObject4 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(203071);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        localObject3 = FinderDebugSettingsUI2.rHb;
        ac.printErrStackTrace(FinderDebugSettingsUI2.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(203071);
        return;
      }
      localException.set((ah.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
      for (;;)
      {
        paramk.refresh();
        paramMMPreference.getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(203071);
        return;
        label146:
        if ((localException instanceof int[]))
        {
          Object localObject2 = g.agR();
          d.g.b.k.g(localObject2, "MMKernel.storage()");
          localObject2 = ((e)localObject2).agA();
          localObject3 = this.rFq.gFx;
          localObject4 = this.rFq.gFz;
          if (localObject4 == null)
          {
            localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(203071);
            throw ((Throwable)localObject2);
          }
          ((ae)localObject2).set((ah.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.a
 * JD-Core Version:    0.7.0.1
 */