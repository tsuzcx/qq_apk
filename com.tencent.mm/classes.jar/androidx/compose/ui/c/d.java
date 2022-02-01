package androidx.compose.ui.c;

import androidx.compose.ui.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/focus/FocusManagerImpl;", "Landroidx/compose/ui/focus/FocusManager;", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "clearFocus", "", "force", "", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "takeFocus", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  public final e auO;
  
  private d(e parame)
  {
    AppMethodBeat.i(204364);
    this.auO = parame;
    AppMethodBeat.o(204364);
  }
  
  public final boolean cw(int paramInt)
  {
    AppMethodBeat.i(204382);
    androidx.compose.ui.i.o localo2 = this.auO.sq();
    s.u(localo2, "$this$moveFocus");
    androidx.compose.ui.n.n localn = androidx.compose.ui.n.n.beP;
    androidx.compose.ui.i.o localo1 = n.c(localo2);
    if (localo1 == null)
    {
      AppMethodBeat.o(204382);
      return false;
    }
    g localg = new g();
    Object localObject1 = localo1.aPj;
    if (localObject1 != null) {
      ((j)localObject1).a(localg);
    }
    localObject1 = a.auH;
    if (a.C(paramInt, a.sh())) {
      localObject1 = localg.auT;
    }
    for (;;)
    {
      Object localObject2 = i.avb;
      if (s.p(localObject1, i.ss())) {
        break label492;
      }
      ((i)localObject1).requestFocus();
      AppMethodBeat.o(204382);
      return true;
      localObject1 = a.auH;
      if (a.C(paramInt, a.si()))
      {
        localObject1 = localg.auU;
      }
      else
      {
        localObject1 = a.auH;
        if (a.C(paramInt, a.sl()))
        {
          localObject1 = localg.auV;
        }
        else
        {
          localObject1 = a.auH;
          if (a.C(paramInt, a.sm()))
          {
            localObject1 = localg.auW;
          }
          else
          {
            localObject1 = a.auH;
            if (a.C(paramInt, a.sj()))
            {
              switch (n.a.$EnumSwitchMapping$0[localn.ordinal()])
              {
              default: 
                localObject1 = new p();
                AppMethodBeat.o(204382);
                throw ((Throwable)localObject1);
              case 2: 
                localObject1 = localg.auZ;
                label253:
                localObject2 = i.avb;
                if (s.p(localObject1, i.ss())) {
                  break;
                }
              }
              for (localObject2 = localObject1;; localObject2 = null)
              {
                localObject1 = localObject2;
                if (localObject2 != null) {
                  break;
                }
                localObject1 = localg.auX;
                break;
                localObject1 = localg.ava;
                break label253;
              }
            }
            localObject1 = a.auH;
            if (a.C(paramInt, a.sk()))
            {
              switch (n.a.$EnumSwitchMapping$0[localn.ordinal()])
              {
              default: 
                localObject1 = new p();
                AppMethodBeat.o(204382);
                throw ((Throwable)localObject1);
              case 2: 
                localObject1 = localg.ava;
                label369:
                localObject2 = i.avb;
                if (s.p(localObject1, i.ss())) {
                  break;
                }
              }
              for (localObject2 = localObject1;; localObject2 = null)
              {
                localObject1 = localObject2;
                if (localObject2 != null) {
                  break;
                }
                localObject1 = localg.auY;
                break;
                localObject1 = localg.auZ;
                break label369;
              }
            }
            localObject1 = a.auH;
            if (a.C(paramInt, a.sn()))
            {
              localObject1 = i.avb;
              localObject1 = i.ss();
            }
            else
            {
              localObject1 = a.auH;
              if (!a.C(paramInt, a.so())) {
                break;
              }
              localObject1 = i.avb;
              localObject1 = i.ss();
            }
          }
        }
      }
    }
    localObject1 = (Throwable)new IllegalStateException("Invalid FocusDirection".toString());
    AppMethodBeat.o(204382);
    throw ((Throwable)localObject1);
    label492:
    localObject1 = a.auH;
    boolean bool;
    if (a.C(paramInt, a.sh()))
    {
      bool = true;
      if (!bool) {
        break label540;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(204382);
        return false;
        localObject1 = a.auH;
        bool = a.C(paramInt, a.si());
        break;
        label540:
        localObject1 = a.auH;
        if (a.C(paramInt, a.sj()))
        {
          bool = true;
          label556:
          if (!bool) {
            break label597;
          }
          bool = true;
          label562:
          if (!bool) {
            break label612;
          }
        }
        for (bool = true;; bool = a.C(paramInt, a.sm()))
        {
          if (!bool) {
            break label627;
          }
          localObject1 = o.a(localo2, paramInt);
          break;
          localObject1 = a.auH;
          bool = a.C(paramInt, a.sk());
          break label556;
          label597:
          localObject1 = a.auH;
          bool = a.C(paramInt, a.sl());
          break label562;
          label612:
          localObject1 = a.auH;
        }
        label627:
        localObject1 = a.auH;
        if (a.C(paramInt, a.sn()))
        {
          switch (n.a.$EnumSwitchMapping$0[localn.ordinal()])
          {
          default: 
            localObject1 = new p();
            AppMethodBeat.o(204382);
            throw ((Throwable)localObject1);
          case 1: 
            localObject1 = a.auH;
          }
          for (paramInt = a.sj();; paramInt = a.sk())
          {
            localObject1 = o.a(localo1, paramInt);
            break;
            localObject1 = a.auH;
          }
        }
        localObject1 = a.auH;
        if (a.C(paramInt, a.so()))
        {
          localObject1 = localo1.xZ();
        }
        else
        {
          localObject1 = (Throwable)new IllegalStateException("Invalid FocusDirection".toString());
          AppMethodBeat.o(204382);
          throw ((Throwable)localObject1);
        }
      }
    }
    m.a((androidx.compose.ui.i.o)localObject1);
    AppMethodBeat.o(204382);
    return true;
  }
  
  public final void sp()
  {
    AppMethodBeat.i(204370);
    Object localObject = this.auO.auP;
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new p();
      AppMethodBeat.o(204370);
      throw ((Throwable)localObject);
    }
    for (int i = 1;; i = 0)
    {
      if ((m.a(this.auO.sq(), true)) && (i != 0)) {
        this.auO.a(l.ave);
      }
      AppMethodBeat.o(204370);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.d
 * JD-Core Version:    0.7.0.1
 */