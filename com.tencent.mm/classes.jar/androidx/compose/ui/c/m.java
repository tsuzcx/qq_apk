package androidx.compose.ui.c;

import androidx.compose.ui.i.f;
import androidx.compose.ui.i.j;
import androidx.compose.ui.i.o;
import androidx.compose.ui.i.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"captureFocus", "", "Landroidx/compose/ui/node/ModifiedFocusNode;", "clearFocus", "forcedClear", "freeFocus", "grantFocus", "", "propagateFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final void a(o paramo)
  {
    AppMethodBeat.i(204381);
    s.u(paramo, "<this>");
    Object localObject = paramo.yf();
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204381);
      return;
      paramo.b((k)paramo.yf());
      AppMethodBeat.o(204381);
      return;
      localObject = paramo.yg();
      if (localObject == null)
      {
        paramo = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(204381);
        throw paramo;
      }
      if (a((o)localObject, false))
      {
        b(paramo, false);
        paramo.d(null);
        AppMethodBeat.o(204381);
        return;
        localObject = paramo.xZ();
        if (localObject == null)
        {
          if (b(paramo))
          {
            b(paramo, false);
            AppMethodBeat.o(204381);
          }
        }
        else {
          a((o)localObject, paramo, false);
        }
      }
    }
  }
  
  private static final boolean a(o paramo1, o paramo2, boolean paramBoolean)
  {
    AppMethodBeat.i(204412);
    Object localObject;
    label217:
    label224:
    do
    {
      for (;;)
      {
        if (!paramo1.yi().contains(paramo2))
        {
          paramo1 = (Throwable)new IllegalStateException("Non child node cannot request focus.".toString());
          AppMethodBeat.o(204412);
          throw paramo1;
        }
        localObject = paramo1.yf();
        switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        default: 
          paramo1 = new kotlin.p();
          AppMethodBeat.o(204412);
          throw paramo1;
        case 1: 
          paramo1.a(l.avf);
          paramo1.d(paramo2);
          b(paramo2, false);
          AppMethodBeat.o(204412);
          return true;
        case 4: 
          localObject = paramo1.yg();
          if (localObject == null)
          {
            paramo1 = (Throwable)new IllegalArgumentException("Required value was null.".toString());
            AppMethodBeat.o(204412);
            throw paramo1;
          }
          if (a((o)localObject, false))
          {
            paramo1.d(paramo2);
            b(paramo2, false);
            AppMethodBeat.o(204412);
            return true;
          }
          AppMethodBeat.o(204412);
          return false;
        case 5: 
          localObject = paramo1.xZ();
          if (localObject != null) {
            break label224;
          }
          if (!b(paramo1)) {
            break label217;
          }
          paramo1.a(l.ave);
        }
      }
      AppMethodBeat.o(204412);
      return false;
    } while (a((o)localObject, paramo1, false));
    AppMethodBeat.o(204412);
    return false;
    AppMethodBeat.o(204412);
    return false;
    paramo1 = (Throwable)new IllegalStateException("non root FocusNode needs a focusable parent".toString());
    AppMethodBeat.o(204412);
    throw paramo1;
  }
  
  public static final boolean a(o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(204394);
    s.u(paramo, "<this>");
    Object localObject = paramo.yf();
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramo = new kotlin.p();
      AppMethodBeat.o(204394);
      throw paramo;
    case 1: 
      paramo.a(l.avj);
      AppMethodBeat.o(204394);
      return true;
    case 4: 
      localObject = paramo.yg();
      if (localObject == null)
      {
        paramo = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(204394);
        throw paramo;
      }
      paramBoolean = a((o)localObject, paramBoolean);
      if (paramBoolean)
      {
        paramo.a(l.avj);
        paramo.d(null);
      }
      AppMethodBeat.o(204394);
      return paramBoolean;
    case 2: 
      if (paramBoolean) {
        paramo.a(l.avj);
      }
      AppMethodBeat.o(204394);
      return paramBoolean;
    }
    AppMethodBeat.o(204394);
    return true;
  }
  
  private static final void b(o paramo, boolean paramBoolean)
  {
    AppMethodBeat.i(204401);
    for (;;)
    {
      o localo = (o)kotlin.a.p.oL(paramo.yi());
      if ((localo == null) || (!paramBoolean))
      {
        paramo.a(l.ave);
        AppMethodBeat.o(204401);
        return;
      }
      paramo.a(l.avf);
      paramo.d(localo);
      paramo = localo;
    }
  }
  
  private static final boolean b(o paramo)
  {
    AppMethodBeat.i(204417);
    paramo = paramo.aOb.aOl;
    if (paramo == null)
    {
      paramo = (Throwable)new IllegalArgumentException("Owner not initialized.".toString());
      AppMethodBeat.o(204417);
      throw paramo;
    }
    boolean bool = paramo.requestFocus();
    AppMethodBeat.o(204417);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.m
 * JD-Core Version:    0.7.0.1
 */