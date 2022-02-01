package com.tencent.mm.live.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"})
public final class LiveUIG$b
  implements LiveUIG.d
{
  private String qPW;
  ae.a qPX;
  private String[] qPY;
  Object qPZ;
  
  public LiveUIG$b(String paramString, ae.a parama, String[] paramArrayOfString, Object paramObject)
  {
    AppMethodBeat.i(203304);
    this.qPW = parama;
    this.qPX = paramArrayOfString;
    this.qPY = paramObject;
    this.qPZ = localObject;
    AppMethodBeat.o(203304);
  }
  
  public final String aaO()
  {
    return this.qPW;
  }
  
  public final void dT(View paramView)
  {
    AppMethodBeat.i(203303);
    k.h(paramView, "view");
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int j = this.qPY.length;
    while (i < j)
    {
      paramView.add(this.qPY[i]);
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)this.KyR, "", (List)paramView, (List)localLinkedList, "", (h.d)new a(this));
    AppMethodBeat.o(203303);
  }
  
  public final String value()
  {
    AppMethodBeat.i(203302);
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
      AppMethodBeat.o(203302);
      return localObject1;
    }
    AppMethodBeat.o(203302);
    return "";
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
  static final class a
    implements h.d
  {
    a(LiveUIG.b paramb) {}
    
    public final void cv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203301);
      ae.a locala;
      Object localObject3;
      try
      {
        Object localObject1 = this.KyT.qPZ;
        if (!(localObject1 instanceof long[])) {
          break label132;
        }
        localObject1 = g.afB();
        k.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).afk();
        locala = this.KyT.qPX;
        localObject3 = this.KyT.qPZ;
        if (localObject3 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(203301);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicorMsg.LiveSettingUI", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(203301);
        return;
      }
      localException.set(locala, Long.valueOf(((long[])localObject3)[paramInt1]));
      for (;;)
      {
        LiveUIG.a(this.KyT.KyR).notifyDataSetChanged();
        AppMethodBeat.o(203301);
        return;
        label132:
        if ((localException instanceof int[]))
        {
          Object localObject2 = g.afB();
          k.g(localObject2, "MMKernel.storage()");
          localObject2 = ((e)localObject2).afk();
          locala = this.KyT.qPX;
          localObject3 = this.KyT.qPZ;
          if (localObject3 == null)
          {
            localObject2 = new v("null cannot be cast to non-null type kotlin.IntArray");
            AppMethodBeat.o(203301);
            throw ((Throwable)localObject2);
          }
          ((ab)localObject2).set(locala, Integer.valueOf(((int[])localObject3)[paramInt1]));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG.b
 * JD-Core Version:    0.7.0.1
 */