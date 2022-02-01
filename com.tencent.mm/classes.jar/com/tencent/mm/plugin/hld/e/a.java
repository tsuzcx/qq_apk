package com.tencent.mm.plugin.hld.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.candidate.e;
import com.tencent.mm.plugin.hld.keyboard.Keyboard;
import com.tencent.mm.plugin.hld.keyboard.Keyboard.a;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Candidate;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener;", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "context", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/Context;Landroid/content/res/Resources;)V", "getContext", "()Landroid/content/Context;", "lastImeKeyParam", "Lcom/tencent/mm/plugin/hld/api/ImeKeyParam;", "getResources", "()Landroid/content/res/Resources;", "commitText", "", "text", "", "fromPending", "", "checkPairSymbol", "deleteText", "deleteLen", "", "handleActionKey", "handleFirstSymbol", "keyParam", "handleNormalSymbol", "processInputType", "Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "handleThirdSymbol", "processType", "hanleSecondSymbol", "onCancelPress", "onFunction", "functionCode", "args", "", "onPrePress", "onPress", "onPressEmoji", "", "onSpecialPress", "Companion", "plugin-hld_release"})
public final class a
  implements com.tencent.mm.plugin.hld.a.c
{
  public static final a DxJ;
  private com.tencent.mm.plugin.hld.a.g DxI;
  private final Context context;
  private final Resources lRm;
  
  static
  {
    AppMethodBeat.i(214761);
    DxJ = new a((byte)0);
    AppMethodBeat.o(214761);
  }
  
  public a(Context paramContext, Resources paramResources)
  {
    AppMethodBeat.i(214760);
    this.context = paramContext;
    this.lRm = paramResources;
    AppMethodBeat.o(214760);
  }
  
  private static void Um(int paramInt)
  {
    AppMethodBeat.i(214757);
    Object localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).eCD();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.hld.a.b)localObject).Um(paramInt);
        AppMethodBeat.o(214757);
        return;
      }
    }
    AppMethodBeat.o(214757);
  }
  
  private final void a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(214754);
    if (paramCharSequence != null)
    {
      Object localObject;
      if (paramBoolean1)
      {
        paramCharSequence = paramCharSequence.toString();
        localObject = this.context.getString(a.j.wxime_separator);
        p.j(localObject, "context.getString(R.string.wxime_separator)");
      }
      for (paramCharSequence = kotlin.n.n.l(paramCharSequence, (String)localObject, "", false);; paramCharSequence = paramCharSequence.toString())
      {
        localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (localObject == null) {
          break;
        }
        localObject = ((d)localObject).eCD();
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.hld.a.b)localObject).c((CharSequence)paramCharSequence, paramBoolean2);
        AppMethodBeat.o(214754);
        return;
      }
      AppMethodBeat.o(214754);
      return;
    }
    AppMethodBeat.o(214754);
  }
  
  private static void eCm()
  {
    AppMethodBeat.i(214759);
    Object localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).eCD();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.hld.a.b)localObject).eCm();
        AppMethodBeat.o(214759);
        return;
      }
    }
    AppMethodBeat.o(214759);
  }
  
  public final void Up(int paramInt)
  {
    AppMethodBeat.i(214751);
    q(paramInt, null);
    AppMethodBeat.o(214751);
  }
  
  public final void a(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(214740);
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      AppMethodBeat.o(214740);
      return;
    }
    this.DxI = null;
    Object localObject2;
    if (!Util.isNullOrNil(paramg.text))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.b.DGL;
      localObject2 = com.tencent.mm.plugin.hld.f.b.aLD(paramg.text);
      localObject1 = com.tencent.mm.plugin.hld.model.h.DCP;
    }
    switch (b.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    default: 
      AppMethodBeat.o(214740);
      return;
    case 1: 
      localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
    }
    for (;;)
    {
      this.DxI = paramg;
      break;
      localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
      if (!com.tencent.mm.plugin.hld.model.n.eEE())
      {
        localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
        com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
      }
    }
  }
  
  public final void aLs(String paramString)
  {
    AppMethodBeat.i(214746);
    Object localObject1 = com.tencent.mm.plugin.hld.model.n.DEn;
    if (com.tencent.mm.plugin.hld.model.n.eEE())
    {
      localObject1 = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject1 != null)
      {
        localObject1 = ((d)localObject1).eCD();
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.hld.a.b)localObject1).c((CharSequence)paramString, false);
          AppMethodBeat.o(214746);
          return;
        }
      }
      AppMethodBeat.o(214746);
      return;
    }
    localObject1 = com.tencent.mm.plugin.hld.model.n.DEn;
    Object localObject2 = com.tencent.mm.plugin.hld.model.n.eEP();
    localObject1 = com.tencent.mm.plugin.hld.model.n.DEn;
    String str = ((Candidate)localObject2).text;
    p.j(str, "candidate.text");
    localObject2 = ((Candidate)localObject2).id;
    p.j(localObject2, "candidate.id");
    com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.n)localObject1, str, (byte[])localObject2, paramString, false, 0L, false, 56);
    AppMethodBeat.o(214746);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(214742);
    Object localObject1 = com.tencent.mm.plugin.hld.f.b.DGL;
    Object localObject2 = com.tencent.mm.plugin.hld.f.b.aLD(paramg.text);
    localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeKeyboardActionListener", "onPress " + paramg.text + ' ' + localObject2);
    localObject1 = e.DuU;
    if (e.eCO())
    {
      localObject1 = e.DuU;
      e.eCP();
    }
    localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      a(this, (CharSequence)paramg.text, false, 2);
      AppMethodBeat.o(214742);
      return;
    }
    paramg.keyType = ((com.tencent.mm.plugin.hld.symbol.i)localObject2).ordinal();
    localObject1 = com.tencent.mm.plugin.hld.model.h.DCQ;
    switch (b.jLJ[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      paramg = com.tencent.mm.plugin.hld.model.g.DCm;
      paramg = com.tencent.mm.plugin.hld.model.g.eEp();
      if ((paramg != null) && (paramg.getUpperMode() == 2))
      {
        paramg = com.tencent.mm.plugin.hld.model.g.eEp();
        if (paramg != null) {
          paramg.Uu(1);
        }
        paramg = com.tencent.mm.plugin.hld.model.g.eEp();
        if (paramg != null) {
          paramg.eDK();
        }
      }
      this.DxI = null;
      AppMethodBeat.o(214742);
      return;
      localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
      paramg = com.tencent.mm.plugin.hld.model.g.DCm;
      if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyp))
      {
        com.tencent.mm.plugin.hld.model.g.DCm.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
        continue;
        localObject1 = paramg.text;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
          if (com.tencent.mm.plugin.hld.model.n.eEE())
          {
            a(this, (CharSequence)localObject1, true, 2);
            paramg = com.tencent.mm.plugin.hld.f.b.DGL;
            if (!com.tencent.mm.plugin.hld.f.b.aLE((String)localObject1))
            {
              paramg = com.tencent.mm.plugin.hld.f.b.DGL;
              if (!com.tencent.mm.plugin.hld.f.b.aLF((String)localObject1))
              {
                paramg = com.tencent.mm.plugin.hld.model.n.DEn;
                com.tencent.mm.plugin.hld.model.n.aLz((String)localObject1);
              }
            }
          }
          for (;;)
          {
            paramg = com.tencent.mm.plugin.hld.model.g.DCm;
            if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyp)) {
              break;
            }
            com.tencent.mm.plugin.hld.model.g.DCm.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
            break;
            localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
            Object localObject4 = com.tencent.mm.plugin.hld.model.n.eEP();
            localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
            localObject3 = ((Candidate)localObject4).text;
            p.j(localObject3, "candidate.text");
            localObject4 = ((Candidate)localObject4).id;
            p.j(localObject4, "candidate.id");
            com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.n)localObject2, (String)localObject3, (byte[])localObject4, (String)localObject1, false, paramg.Dui, false, 40);
            paramg = k.DDb;
            k.hN(1, 0);
          }
        }
        Log.e("WxIme.ImeKeyboardActionListener", "handleFirstSymbol text is null");
        continue;
        localObject2 = paramg.text;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.plugin.hld.model.n.DEn;
          if (com.tencent.mm.plugin.hld.model.n.eEE())
          {
            a(this, (CharSequence)localObject2, true, 2);
            paramg = com.tencent.mm.plugin.hld.model.n.DEn;
            com.tencent.mm.plugin.hld.model.n.aLz((String)localObject2);
          }
          for (;;)
          {
            paramg = com.tencent.mm.plugin.hld.model.g.DCm;
            if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyp)) {
              break;
            }
            com.tencent.mm.plugin.hld.model.g.DCm.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
            break;
            localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
            com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
          }
        }
        Log.e("WxIme.ImeKeyboardActionListener", "hanleSecondSymbol text is null");
        continue;
        localObject2 = paramg.text;
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.plugin.hld.model.n.DEn;
          if (com.tencent.mm.plugin.hld.model.n.eEE())
          {
            a(this, (CharSequence)localObject2, true, 2);
            paramg = com.tencent.mm.plugin.hld.f.b.DGL;
            if (!com.tencent.mm.plugin.hld.f.b.aLE((String)localObject2))
            {
              paramg = com.tencent.mm.plugin.hld.f.b.DGL;
              if (!com.tencent.mm.plugin.hld.f.b.aLF((String)localObject2))
              {
                paramg = com.tencent.mm.plugin.hld.model.n.DEn;
                com.tencent.mm.plugin.hld.model.n.aLz((String)localObject2);
              }
            }
          }
          else
          {
            localObject2 = com.tencent.mm.plugin.hld.model.n.DEn;
            com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
          }
        }
        else
        {
          Log.e("WxIme.ImeKeyboardActionListener", "handleThirdSymbol text is null");
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(214743);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      AppMethodBeat.o(214743);
      return;
    }
    if ((this.DxI != null) && (!Util.isNullOrNil(paramg.text)))
    {
      localObject = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.a(com.tencent.mm.plugin.hld.model.h.DCR, paramg);
    }
    this.DxI = null;
    AppMethodBeat.o(214743);
  }
  
  public final void d(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(214745);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      AppMethodBeat.o(214745);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.a(com.tencent.mm.plugin.hld.model.h.DCQ, paramg);
    this.DxI = null;
    AppMethodBeat.o(214745);
  }
  
  public final void q(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(214748);
    Log.i("WxIme.ImeKeyboardActionListener", "onFunction %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramObject = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.ha(this.context);
      AppMethodBeat.o(214748);
      return;
    case 1: 
      localObject1 = e.DuU;
      if (e.eCO())
      {
        localObject1 = e.DuU;
        e.eCP();
      }
      if ((paramObject instanceof Keyboard.a))
      {
        switch (((Keyboard.a)paramObject).Dyj)
        {
        default: 
          AppMethodBeat.o(214748);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.hld.model.n.DEn;
          if (!com.tencent.mm.plugin.hld.model.n.eEE())
          {
            paramObject = com.tencent.mm.plugin.hld.model.n.DEn;
            com.tencent.mm.plugin.hld.model.n.eEK();
            AppMethodBeat.o(214748);
            return;
          }
          localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
          if (com.tencent.mm.plugin.hld.model.g.eEh()) {
            Um(((Keyboard.a)paramObject).Dyk);
          }
          AppMethodBeat.o(214748);
          return;
        }
        localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
        paramInt = com.tencent.mm.plugin.hld.model.g.eEj();
        localObject1 = new StringBuilder("DELETE_TYPE_EDIT_TEXT ");
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        Log.d("WxIme.ImeKeyboardActionListener", com.tencent.mm.plugin.hld.f.l.eGY() + ' ' + paramInt);
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eGY())
        {
          paramObject = com.tencent.mm.plugin.hld.model.g.DCm;
          if (com.tencent.mm.plugin.hld.model.g.eEj() == 3)
          {
            paramObject = com.tencent.mm.plugin.hld.model.g.DCm;
            paramObject = com.tencent.mm.plugin.hld.model.g.eEl();
            if (paramObject != null) {
              paramObject.reset();
            }
          }
          Um(1);
          AppMethodBeat.o(214748);
          return;
        }
        Um(((Keyboard.a)paramObject).Dyk);
        AppMethodBeat.o(214748);
        return;
      }
      Log.e("WxIme.ImeKeyboardActionListener", "onFunction delete key why here???");
      AppMethodBeat.o(214748);
      return;
    case 5: 
      com.tencent.mm.plugin.hld.model.g.DCm.a(com.tencent.mm.plugin.hld.keyboard.c.Dyo);
      AppMethodBeat.o(214748);
      return;
    case 9: 
      com.tencent.mm.plugin.hld.model.g.DCm.Ux(com.tencent.mm.plugin.hld.model.g.eEo());
      AppMethodBeat.o(214748);
      return;
    case 7: 
      com.tencent.mm.plugin.hld.model.g.DCm.a(com.tencent.mm.plugin.hld.keyboard.c.Dyn);
      AppMethodBeat.o(214748);
      return;
    case 8: 
      paramObject = com.tencent.mm.plugin.hld.model.g.DCm;
      localObject1 = com.tencent.mm.plugin.hld.f.i.DHq;
      paramObject.Ux(com.tencent.mm.plugin.hld.f.i.eEm());
      AppMethodBeat.o(214748);
      return;
    case 4: 
      com.tencent.mm.plugin.hld.model.g.DCm.a(com.tencent.mm.plugin.hld.keyboard.c.Dyp);
      AppMethodBeat.o(214748);
      return;
    case 10: 
      paramObject = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.sS(false);
      AppMethodBeat.o(214748);
      return;
    case 11: 
      paramObject = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.sS(true);
      AppMethodBeat.o(214748);
      return;
    case 2: 
      paramObject = com.tencent.mm.plugin.hld.model.g.DCm;
      if (com.tencent.mm.plugin.hld.model.g.eEj() == 2)
      {
        paramObject = com.tencent.mm.plugin.hld.model.g.DCm;
        if (com.tencent.mm.plugin.hld.model.g.eEh())
        {
          com.tencent.mm.plugin.hld.model.n.DEn.eEO();
          eCm();
          AppMethodBeat.o(214748);
          return;
        }
        paramObject = com.tencent.mm.plugin.hld.model.n.DEn;
        a(com.tencent.mm.plugin.hld.model.n.eEM(), true, true);
        com.tencent.mm.plugin.hld.model.n.DEn.eEO();
        AppMethodBeat.o(214748);
        return;
      }
      eCm();
      AppMethodBeat.o(214748);
      return;
    case 6: 
      paramObject = com.tencent.mm.plugin.hld.model.g.DCm;
      if (com.tencent.mm.plugin.hld.model.g.eEj() == 2)
      {
        paramObject = com.tencent.mm.plugin.hld.model.n.DEn;
        localObject2 = com.tencent.mm.plugin.hld.model.n.eEP();
        paramObject = com.tencent.mm.plugin.hld.model.n.DEn;
        localObject1 = ((Candidate)localObject2).text;
        p.j(localObject1, "candidate.text");
        localObject2 = ((Candidate)localObject2).id;
        p.j(localObject2, "candidate.id");
        com.tencent.mm.plugin.hld.model.n.a(paramObject, (String)localObject1, (byte[])localObject2, null, true, 0L, false, 52);
        paramObject = k.DDb;
        k.hN(1, 0);
        AppMethodBeat.o(214748);
        return;
      }
      a(this, (CharSequence)" ", false, 6);
      AppMethodBeat.o(214748);
      return;
    case 12: 
      a(this, (CharSequence)"\n", false, 6);
      AppMethodBeat.o(214748);
      return;
    }
    paramObject = e.DuU;
    if (e.eCO())
    {
      paramObject = e.DuU;
      e.eCP();
    }
    com.tencent.mm.plugin.hld.model.n.DEn.eEO();
    AppMethodBeat.o(214748);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.e.a
 * JD-Core Version:    0.7.0.1
 */