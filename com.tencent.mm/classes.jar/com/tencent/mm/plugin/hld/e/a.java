package com.tencent.mm.plugin.hld.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.candidate.e;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.Keyboard;
import com.tencent.mm.plugin.hld.keyboard.Keyboard.a;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.info.Candidate;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener;", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "context", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/Context;Landroid/content/res/Resources;)V", "getContext", "()Landroid/content/Context;", "lastImeKeyParam", "Lcom/tencent/mm/plugin/hld/api/ImeKeyParam;", "getResources", "()Landroid/content/res/Resources;", "commitText", "", "text", "", "fromPending", "", "checkPairSymbol", "deleteText", "deleteLen", "", "handleActionKey", "handleFirstSymbol", "keyParam", "handleNormalSymbol", "processInputType", "Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "handleThirdSymbol", "processType", "hanleSecondSymbol", "onCancelPress", "onFunction", "functionCode", "args", "", "onPrePress", "onPress", "onPressEmoji", "", "onSpecialPress", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.hld.a.c
{
  public static final a.a JqN;
  private com.tencent.mm.plugin.hld.a.g JqO;
  private final Context context;
  private final Resources oJY;
  
  static
  {
    AppMethodBeat.i(311525);
    JqN = new a.a((byte)0);
    AppMethodBeat.o(311525);
  }
  
  public a(Context paramContext, Resources paramResources)
  {
    AppMethodBeat.i(311465);
    this.context = paramContext;
    this.oJY = paramResources;
    AppMethodBeat.o(311465);
  }
  
  private static void Yi(int paramInt)
  {
    AppMethodBeat.i(311504);
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).fKG();
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.a.b)localObject).Yi(paramInt);
      }
    }
    AppMethodBeat.o(311504);
  }
  
  private final void a(CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(311480);
    Object localObject;
    if (paramCharSequence != null)
    {
      if (!paramBoolean1) {
        break label94;
      }
      paramCharSequence = paramCharSequence.toString();
      localObject = this.context.getString(a.j.wxime_separator);
      s.s(localObject, "context.getString(R.string.wxime_separator)");
    }
    label94:
    for (paramCharSequence = kotlin.n.n.m(paramCharSequence, (String)localObject, "", false);; paramCharSequence = paramCharSequence.toString())
    {
      localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject != null)
      {
        localObject = ((d)localObject).fKG();
        if (localObject != null) {
          ((com.tencent.mm.plugin.hld.a.b)localObject).c((CharSequence)paramCharSequence, paramBoolean2);
        }
      }
      AppMethodBeat.o(311480);
      return;
    }
  }
  
  private static void fKq()
  {
    AppMethodBeat.i(311512);
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).fKG();
      if (localObject != null) {
        ((com.tencent.mm.plugin.hld.a.b)localObject).fKq();
      }
    }
    AppMethodBeat.o(311512);
  }
  
  public final void K(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(311626);
    Log.i("WxIme.ImeKeyboardActionListener", "onFunction %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramObject = l.JyV;
      l.iv(this.context);
      AppMethodBeat.o(311626);
      return;
    case 1: 
      localObject1 = e.Jon;
      if (e.fKQ())
      {
        localObject1 = e.Jon;
        e.fKR();
      }
      if ((paramObject instanceof Keyboard.a))
      {
        switch (((Keyboard.a)paramObject).Jrn)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(311626);
          return;
          localObject1 = com.tencent.mm.plugin.hld.model.n.JvW;
          if (!com.tencent.mm.plugin.hld.model.n.fMH())
          {
            paramObject = com.tencent.mm.plugin.hld.model.n.JvW;
            com.tencent.mm.plugin.hld.model.n.fMN();
            AppMethodBeat.o(311626);
            return;
          }
          localObject1 = com.tencent.mm.plugin.hld.model.g.JuL;
          if (!com.tencent.mm.plugin.hld.model.g.fMj()) {
            break;
          }
          Yi(((Keyboard.a)paramObject).Jro);
          AppMethodBeat.o(311626);
          return;
          localObject1 = com.tencent.mm.plugin.hld.model.g.JuL;
          paramInt = com.tencent.mm.plugin.hld.model.g.fMl();
          localObject1 = new StringBuilder("DELETE_TYPE_EDIT_TEXT ");
          localObject2 = l.JyV;
          Log.d("WxIme.ImeKeyboardActionListener", l.fOH() + ' ' + paramInt);
          localObject1 = l.JyV;
          if (l.fOH())
          {
            paramObject = com.tencent.mm.plugin.hld.model.g.JuL;
            if (com.tencent.mm.plugin.hld.model.g.fMl() == 3)
            {
              paramObject = com.tencent.mm.plugin.hld.model.g.JuL;
              paramObject = com.tencent.mm.plugin.hld.model.g.fMn();
              if (paramObject != null) {
                paramObject.reset();
              }
            }
            Yi(1);
            AppMethodBeat.o(311626);
            return;
          }
          Yi(((Keyboard.a)paramObject).Jro);
        }
      }
      Log.e("WxIme.ImeKeyboardActionListener", "onFunction delete key why here???");
      AppMethodBeat.o(311626);
      return;
    case 5: 
      com.tencent.mm.plugin.hld.model.g.JuL.a(com.tencent.mm.plugin.hld.keyboard.c.Jrs);
      AppMethodBeat.o(311626);
      return;
    case 9: 
      com.tencent.mm.plugin.hld.model.g.JuL.Yu(com.tencent.mm.plugin.hld.model.g.fMq());
      AppMethodBeat.o(311626);
      return;
    case 7: 
      com.tencent.mm.plugin.hld.model.g.JuL.a(com.tencent.mm.plugin.hld.keyboard.c.Jrr);
      AppMethodBeat.o(311626);
      return;
    case 8: 
      paramObject = com.tencent.mm.plugin.hld.model.g.JuL;
      localObject1 = com.tencent.mm.plugin.hld.f.i.JyA;
      paramObject.Yu(com.tencent.mm.plugin.hld.f.i.fMo());
      AppMethodBeat.o(311626);
      return;
    case 4: 
      com.tencent.mm.plugin.hld.model.g.JuL.a(com.tencent.mm.plugin.hld.keyboard.c.Jrt);
      AppMethodBeat.o(311626);
      return;
    case 10: 
      paramObject = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.wY(false);
      AppMethodBeat.o(311626);
      return;
    case 11: 
      paramObject = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.wY(true);
      AppMethodBeat.o(311626);
      return;
    case 2: 
      paramObject = com.tencent.mm.plugin.hld.model.g.JuL;
      if (com.tencent.mm.plugin.hld.model.g.fMl() == 2)
      {
        paramObject = com.tencent.mm.plugin.hld.model.g.JuL;
        if (com.tencent.mm.plugin.hld.model.g.fMj())
        {
          com.tencent.mm.plugin.hld.model.n.JvW.fMR();
          fKq();
          AppMethodBeat.o(311626);
          return;
        }
        paramObject = com.tencent.mm.plugin.hld.model.n.JvW;
        a(com.tencent.mm.plugin.hld.model.n.fMP(), true, true);
        com.tencent.mm.plugin.hld.model.n.JvW.fMR();
        AppMethodBeat.o(311626);
        return;
      }
      fKq();
      AppMethodBeat.o(311626);
      return;
    case 6: 
      paramObject = com.tencent.mm.plugin.hld.model.g.JuL;
      if (com.tencent.mm.plugin.hld.model.g.fMl() == 2)
      {
        paramObject = com.tencent.mm.plugin.hld.model.n.JvW;
        localObject2 = com.tencent.mm.plugin.hld.model.n.fMS();
        paramObject = com.tencent.mm.plugin.hld.model.n.JvW;
        localObject1 = ((Candidate)localObject2).text;
        s.s(localObject1, "candidate.text");
        localObject2 = ((Candidate)localObject2).id;
        s.s(localObject2, "candidate.id");
        com.tencent.mm.plugin.hld.model.n.a(paramObject, (String)localObject1, (byte[])localObject2, null, true, 0L, false, 52);
        paramObject = k.JvH;
        k.jr(1, 0);
        AppMethodBeat.o(311626);
        return;
      }
      a(this, (CharSequence)" ", false, 6);
      AppMethodBeat.o(311626);
      return;
    case 12: 
      a(this, (CharSequence)"\n", false, 6);
      AppMethodBeat.o(311626);
      return;
    }
    paramObject = e.Jon;
    if (e.fKQ())
    {
      paramObject = e.Jon;
      e.fKR();
    }
    com.tencent.mm.plugin.hld.model.n.JvW.fMR();
    AppMethodBeat.o(311626);
  }
  
  public final void Yl(int paramInt)
  {
    AppMethodBeat.i(311639);
    K(paramInt, null);
    AppMethodBeat.o(311639);
  }
  
  public final void a(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(311530);
    Object localObject1 = l.JyV;
    if (l.fKH())
    {
      AppMethodBeat.o(311530);
      return;
    }
    this.JqO = null;
    Object localObject2;
    if (!Util.isNullOrNil(paramg.text))
    {
      localObject1 = com.tencent.mm.plugin.hld.f.b.Jyf;
      localObject2 = com.tencent.mm.plugin.hld.f.b.aIv(paramg.text);
      localObject1 = com.tencent.mm.plugin.hld.model.h.Jvy;
    }
    switch (b.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    default: 
      AppMethodBeat.o(311530);
      return;
    case 1: 
      localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
    }
    for (;;)
    {
      this.JqO = paramg;
      break;
      localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
      if (!com.tencent.mm.plugin.hld.model.n.fMH())
      {
        localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
        com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
      }
    }
  }
  
  public final void aIj(String paramString)
  {
    AppMethodBeat.i(311598);
    Object localObject1 = com.tencent.mm.plugin.hld.model.n.JvW;
    if (com.tencent.mm.plugin.hld.model.n.fMH())
    {
      localObject1 = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject1 != null)
      {
        localObject1 = ((d)localObject1).fKG();
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.hld.a.b)localObject1).c((CharSequence)paramString, false);
          AppMethodBeat.o(311598);
        }
      }
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.hld.model.n.JvW;
      Object localObject2 = com.tencent.mm.plugin.hld.model.n.fMS();
      localObject1 = com.tencent.mm.plugin.hld.model.n.JvW;
      String str = ((Candidate)localObject2).text;
      s.s(str, "candidate.text");
      localObject2 = ((Candidate)localObject2).id;
      s.s(localObject2, "candidate.id");
      com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.n)localObject1, str, (byte[])localObject2, paramString, false, 0L, false, 56);
    }
    AppMethodBeat.o(311598);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.g paramg)
  {
    int j = 0;
    AppMethodBeat.i(311557);
    Object localObject1 = com.tencent.mm.plugin.hld.f.b.Jyf;
    Object localObject2;
    if (paramg == null)
    {
      localObject1 = null;
      localObject2 = com.tencent.mm.plugin.hld.f.b.aIv((String)localObject1);
      localObject1 = l.JyV;
      localObject3 = new StringBuilder("onPress ");
      if (paramg != null) {
        break label138;
      }
      localObject1 = null;
      label51:
      l.jC("WxIme.ImeKeyboardActionListener", localObject1 + ' ' + localObject2);
      localObject1 = e.Jon;
      if (e.fKQ())
      {
        localObject1 = e.Jon;
        e.fKR();
      }
      localObject1 = l.JyV;
      if (!l.fKH()) {
        break label155;
      }
      if (paramg != null) {
        break label147;
      }
    }
    label138:
    label147:
    for (paramg = null;; paramg = paramg.text)
    {
      a(this, (CharSequence)paramg, false, 2);
      AppMethodBeat.o(311557);
      return;
      localObject1 = paramg.text;
      break;
      localObject1 = paramg.text;
      break label51;
    }
    label155:
    if (paramg != null) {
      paramg.keyType = ((com.tencent.mm.plugin.hld.symbol.i)localObject2).ordinal();
    }
    localObject1 = com.tencent.mm.plugin.hld.model.h.Jvz;
    switch (b.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    }
    label706:
    for (;;)
    {
      paramg = com.tencent.mm.plugin.hld.model.g.JuL;
      paramg = com.tencent.mm.plugin.hld.model.g.fMr();
      int i = j;
      if (paramg != null)
      {
        i = j;
        if (paramg.getUpperMode() == 2) {
          i = 1;
        }
      }
      if (i != 0)
      {
        paramg = com.tencent.mm.plugin.hld.model.g.fMr();
        if (paramg != null) {
          paramg.Yr(1);
        }
        paramg = com.tencent.mm.plugin.hld.model.g.fMr();
        if (paramg != null) {
          paramg.fLM();
        }
      }
      this.JqO = null;
      AppMethodBeat.o(311557);
      return;
      localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
      paramg = com.tencent.mm.plugin.hld.model.g.JuL;
      if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrt))
      {
        com.tencent.mm.plugin.hld.model.g.JuL.Yu(com.tencent.mm.plugin.hld.model.g.fMq());
        continue;
        if (paramg == null) {}
        for (paramg = null; paramg == null; paramg = ah.aiuX)
        {
          Log.e("WxIme.ImeKeyboardActionListener", "handleFirstSymbol keyParam is null");
          break;
          localObject1 = paramg.text;
          if (localObject1 != null) {
            break label368;
          }
          paramg = null;
          if (paramg == null) {
            Log.e("WxIme.ImeKeyboardActionListener", "handleFirstSymbol text is null");
          }
        }
        label368:
        localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
        if (com.tencent.mm.plugin.hld.model.n.fMH())
        {
          a(this, (CharSequence)localObject1, true, 2);
          paramg = com.tencent.mm.plugin.hld.f.b.Jyf;
          if (!com.tencent.mm.plugin.hld.f.b.aIw((String)localObject1))
          {
            paramg = com.tencent.mm.plugin.hld.f.b.Jyf;
            if (!com.tencent.mm.plugin.hld.f.b.aIx((String)localObject1))
            {
              paramg = com.tencent.mm.plugin.hld.model.n.JvW;
              com.tencent.mm.plugin.hld.model.n.aIq((String)localObject1);
            }
          }
        }
        for (;;)
        {
          paramg = com.tencent.mm.plugin.hld.model.g.JuL;
          if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrt)) {
            com.tencent.mm.plugin.hld.model.g.JuL.Yu(com.tencent.mm.plugin.hld.model.g.fMq());
          }
          paramg = ah.aiuX;
          break;
          localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
          Object localObject4 = com.tencent.mm.plugin.hld.model.n.fMS();
          localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
          localObject3 = ((Candidate)localObject4).text;
          s.s(localObject3, "candidate.text");
          localObject4 = ((Candidate)localObject4).id;
          s.s(localObject4, "candidate.id");
          com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.n)localObject2, (String)localObject3, (byte[])localObject4, (String)localObject1, false, paramg.JnG, false, 40);
          paramg = k.JvH;
          k.jr(1, 0);
        }
        if (paramg == null) {}
        for (paramg = null; paramg == null; paramg = ah.aiuX)
        {
          Log.e("WxIme.ImeKeyboardActionListener", "hanleSecondSymbol keyParam is null");
          break;
          localObject2 = paramg.text;
          if (localObject2 != null) {
            break label581;
          }
          paramg = null;
          if (paramg == null) {
            Log.e("WxIme.ImeKeyboardActionListener", "hanleSecondSymbol text is null");
          }
        }
        label581:
        localObject3 = com.tencent.mm.plugin.hld.model.n.JvW;
        if (com.tencent.mm.plugin.hld.model.n.fMH())
        {
          a(this, (CharSequence)localObject2, true, 2);
          paramg = com.tencent.mm.plugin.hld.model.n.JvW;
          com.tencent.mm.plugin.hld.model.n.aIq((String)localObject2);
        }
        for (;;)
        {
          paramg = com.tencent.mm.plugin.hld.model.g.JuL;
          if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrt)) {
            com.tencent.mm.plugin.hld.model.g.JuL.Yu(com.tencent.mm.plugin.hld.model.g.fMq());
          }
          paramg = ah.aiuX;
          break;
          localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
          com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
        }
        if (paramg == null) {}
        for (paramg = null;; paramg = ah.aiuX)
        {
          if (paramg != null) {
            break label706;
          }
          Log.e("WxIme.ImeKeyboardActionListener", "handleThirdSymbol keyParam is null");
          break;
          localObject2 = paramg.text;
          if (localObject2 != null) {
            break label708;
          }
          paramg = null;
          if (paramg == null) {
            Log.e("WxIme.ImeKeyboardActionListener", "handleThirdSymbol text is null");
          }
        }
      }
    }
    label708:
    Object localObject3 = com.tencent.mm.plugin.hld.model.n.JvW;
    if (com.tencent.mm.plugin.hld.model.n.fMH())
    {
      a(this, (CharSequence)localObject2, true, 2);
      paramg = com.tencent.mm.plugin.hld.f.b.Jyf;
      if (!com.tencent.mm.plugin.hld.f.b.aIw((String)localObject2))
      {
        paramg = com.tencent.mm.plugin.hld.f.b.Jyf;
        if (!com.tencent.mm.plugin.hld.f.b.aIx((String)localObject2))
        {
          paramg = com.tencent.mm.plugin.hld.model.n.JvW;
          com.tencent.mm.plugin.hld.model.n.aIq((String)localObject2);
        }
      }
    }
    for (;;)
    {
      paramg = ah.aiuX;
      break;
      localObject2 = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.a((com.tencent.mm.plugin.hld.model.h)localObject1, paramg);
    }
  }
  
  public final void c(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(311572);
    Object localObject = l.JyV;
    if (l.fKH())
    {
      AppMethodBeat.o(311572);
      return;
    }
    if ((this.JqO != null) && (!Util.isNullOrNil(paramg.text)))
    {
      localObject = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.a(com.tencent.mm.plugin.hld.model.h.JvA, paramg);
    }
    this.JqO = null;
    AppMethodBeat.o(311572);
  }
  
  public final void d(com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(311584);
    Object localObject = l.JyV;
    if (l.fKH())
    {
      AppMethodBeat.o(311584);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.a(com.tencent.mm.plugin.hld.model.h.Jvz, paramg);
    this.JqO = null;
    AppMethodBeat.o(311584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.e.a
 * JD-Core Version:    0.7.0.1
 */