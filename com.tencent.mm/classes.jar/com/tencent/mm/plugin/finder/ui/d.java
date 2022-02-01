package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.f;
import d.g.b.k;
import d.v;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;", "", "activity", "Landroid/app/Activity;", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "", "_vals", "(Landroid/app/Activity;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "getActivity", "()Landroid/app/Activity;", "value", "getValue", "()Ljava/lang/String;", "get", "field", "showAlert", "", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "operation", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "plugin-finder_release"})
public final class d
{
  private final Activity activity;
  ae.a qPX;
  private String[] qPY;
  Object qPZ;
  
  public d(Activity paramActivity, ae.a parama, String[] paramArrayOfString, Object paramObject)
  {
    AppMethodBeat.i(199104);
    this.activity = paramActivity;
    this.qPX = parama;
    this.qPY = paramArrayOfString;
    this.qPZ = paramObject;
    AppMethodBeat.o(199104);
  }
  
  public final void a(final MMPreference paramMMPreference, final l paraml)
  {
    AppMethodBeat.i(199103);
    k.h(paramMMPreference, "activity");
    k.h(paraml, "operation");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int i = 0;
    int j = this.qPY.length;
    while (i < j)
    {
      localLinkedList1.add(this.qPY[i]);
      localLinkedList2.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)paramMMPreference, "", (List)localLinkedList1, (List)localLinkedList2, "", (h.d)new a(this, paraml, paramMMPreference));
    AppMethodBeat.o(199103);
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(199102);
    if ((this.qPZ instanceof long[]))
    {
      localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
    }
    int k;
    int i;
    int i1;
    int j;
    for (int m = (int)((e)localObject1).afk().a(this.qPX, 0L);; m = ((e)localObject1).afk().getInt(this.qPX, 0))
    {
      k = -1;
      localObject2 = this.qPZ;
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
      localObject1 = g.afB();
      k.g(localObject1, "MMKernel.storage()");
    }
    Object localObject2 = this.qPZ;
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
    if ((n >= 0) && (n < this.qPY.length))
    {
      localObject1 = this.qPY[n];
      AppMethodBeat.o(199102);
      return localObject1;
    }
    AppMethodBeat.o(199102);
    return "";
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
  static final class a
    implements h.d
  {
    a(d paramd, l paraml, MMPreference paramMMPreference) {}
    
    public final void cv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199101);
      Object localObject3;
      Object localObject4;
      try
      {
        Object localObject1 = this.KXG.qPZ;
        if (!(localObject1 instanceof long[])) {
          break label146;
        }
        localObject1 = g.afB();
        k.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).afk();
        localObject3 = this.KXG.qPX;
        localObject4 = this.KXG.qPZ;
        if (localObject4 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(199101);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        localObject3 = FinderDebugSettingsUI2.KYf;
        ad.printErrStackTrace(FinderDebugSettingsUI2.access$getTAG$cp(), (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(199101);
        return;
      }
      localException.set((ae.a)localObject3, Long.valueOf(((long[])localObject4)[paramInt1]));
      for (;;)
      {
        paraml.refresh();
        paramMMPreference.getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(199101);
        return;
        label146:
        if ((localException instanceof int[]))
        {
          Object localObject2 = g.afB();
          k.g(localObject2, "MMKernel.storage()");
          localObject2 = ((e)localObject2).afk();
          localObject3 = this.KXG.qPX;
          localObject4 = this.KXG.qPZ;
          if (localObject4 == null)
          {
            localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(199101);
            throw ((Throwable)localObject2);
          }
          ((ab)localObject2).set((ae.a)localObject3, Integer.valueOf(((int[])localObject4)[paramInt1]));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.d
 * JD-Core Version:    0.7.0.1
 */