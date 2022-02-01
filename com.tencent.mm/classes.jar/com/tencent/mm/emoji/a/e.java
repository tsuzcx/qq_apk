package com.tencent.mm.emoji.a;

import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.o;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "", "()V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "holderCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "holderPool", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "rootLocation", "", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;)V", "checkMatch", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "checkMatchPatMsg", "", "playedIndex", "checkRevoke", "", "createHolder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "index", "animKey", "content", "emojiKey", "onStop", "setPlayingKey", "itemHolder", "updateItemView", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "Companion", "StateCallback", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiDynamicController";
  public static final e.a jGq;
  public FrameLayout jFQ;
  private final int[] jGl;
  public final d jGm;
  private final c.a jGn;
  public String jGo;
  public b jGp;
  
  static
  {
    AppMethodBeat.i(228530);
    jGq = new e.a((byte)0);
    TAG = "MicroMsg.EmojiDynamicController";
    AppMethodBeat.o(228530);
  }
  
  public e()
  {
    AppMethodBeat.i(228528);
    this.jGl = new int[2];
    this.jGm = new d();
    this.jGn = ((c.a)new c.a()
    {
      public final void a(long paramAnonymousLong, String paramAnonymousString, b.a paramAnonymousa)
      {
        AppMethodBeat.i(226329);
        p.k(paramAnonymousString, "animKey");
        p.k(paramAnonymousa, "config");
        e.b localb = this.jGr.jGp;
        if (localb != null)
        {
          localb.a(paramAnonymousLong, paramAnonymousString, paramAnonymousa);
          AppMethodBeat.o(226329);
          return;
        }
        AppMethodBeat.o(226329);
      }
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(226327);
        p.k(paramAnonymousc, "holder");
        e.a(this.jGr).b(paramAnonymousc);
        AppMethodBeat.o(226327);
      }
      
      public final void a(String paramAnonymousString, b.a paramAnonymousa)
      {
        AppMethodBeat.i(226328);
        p.k(paramAnonymousString, "animKey");
        p.k(paramAnonymousa, "config");
        e.b localb = this.jGr.jGp;
        if (localb != null)
        {
          localb.a(paramAnonymousString, paramAnonymousa);
          AppMethodBeat.o(226328);
          return;
        }
        AppMethodBeat.o(226328);
      }
    });
    AppMethodBeat.o(228528);
  }
  
  private final c a(ca paramca, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228526);
    Object localObject = this.jGm;
    paramca.apG();
    localObject = ((d)localObject).aBo();
    ((c)localObject).msgId = paramca.apG();
    ((c)localObject).LD(paramString1);
    ((c)localObject).jFP = paramInt;
    ((c)localObject).msgType = paramca.getType();
    ((c)localObject).jFQ = this.jFQ;
    ((c)localObject).jGc = this.jGn;
    if (paramca.apA() == 1)
    {
      ((c)localObject).jGb = new o();
      paramca = ((c)localObject).jGb;
      if (paramca != null)
      {
        paramString1 = com.tencent.mm.emoji.c.a.jNj;
        if (com.tencent.mm.emoji.c.a.aCX())
        {
          paramInt = 1;
          paramca.kY(paramInt);
        }
      }
      else
      {
        paramca = com.tencent.mm.emoji.c.a.jNj;
        com.tencent.mm.emoji.c.a.eA(false);
      }
    }
    else
    {
      paramca = ((c)localObject).jGb;
      if (paramca != null) {
        paramca.iI(this.jGo);
      }
      paramca = ((c)localObject).jGb;
      if (paramca != null) {
        paramca.iH(paramString2);
      }
      if (a((c)localObject, paramString3)) {
        break label226;
      }
      paramca = ((c)localObject).jGb;
      if (paramca != null) {
        paramca.kW(2);
      }
      paramca = ((c)localObject).jGb;
      if (paramca != null) {
        paramca.bpa();
      }
      this.jGm.b((c)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(228526);
      return localObject;
      paramInt = 0;
      break;
      label226:
      paramca = ((c)localObject).jGb;
      if (paramca != null) {
        paramca.kW(1);
      }
    }
  }
  
  private static boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(228508);
    p.k(paramc, "itemHolder");
    p.k(paramString, "emojiKey");
    Log.i(TAG, "setPlayingKey: ".concat(String.valueOf(paramString)));
    Object localObject1 = f.jGv;
    Object localObject2 = ((Iterable)f.aBp().jFL).iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (p.h(((b.a)localObject1).key, paramString))
        {
          paramString = (String)localObject1;
          paramString = (b.a)paramString;
          if (paramString == null) {
            break label402;
          }
          localObject1 = new StringBuilder();
          localObject2 = com.tencent.mm.emoji.e.a.jPz;
          localObject1 = com.tencent.mm.emoji.e.a.aDE() + paramString.jFM;
          if (!u.agG((String)localObject1)) {
            break label388;
          }
          p.k(paramString, "config");
          p.k(localObject1, "filePath");
          paramc.jFW = paramString;
          paramString = paramc.jFW;
          if ((paramString != null) && (paramString.jFN != null))
          {
            localObject2 = paramc.jGc;
            if (localObject2 != null) {
              ((c.a)localObject2).a(paramc.jFO, paramString);
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramc.jFU = new com.tencent.mm.plugin.gif.h(u.aY((String)localObject1, 0, -1));
        if (paramc.jFU == null) {
          continue;
        }
        paramString = paramc.jGb;
        if (paramString != null) {
          paramString.kX(1);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(paramc.TAG, (Throwable)paramString, "create anim", new Object[0]);
        if (!(paramString instanceof MMGIFException)) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(711, 21);
        paramString = paramc.jGb;
        if (paramString == null) {
          continue;
        }
        paramString.kX(2);
        paramString = paramc.jGb;
        if (paramString == null) {
          continue;
        }
        paramString.agM();
        continue;
        int i = 1;
        continue;
      }
      paramString = paramc.jFU;
      if (paramString == null) {
        continue;
      }
      i = paramString.eAY();
      paramString = paramc.jFU;
      if (paramString != null) {
        paramString.Uh(i);
      }
      paramString = paramc.jFU;
      if (paramString != null) {
        paramString.pI();
      }
      paramc = paramc.jFU;
      if (paramc != null) {
        paramc.pause();
      }
      AppMethodBeat.o(228508);
      return true;
      paramString = null;
      break;
      paramString = paramc.jGb;
      if (paramString != null) {
        paramString.kX(2);
      }
    }
    label388:
    paramc = f.jGv;
    f.a.aBu();
    for (;;)
    {
      AppMethodBeat.o(228508);
      return false;
      label402:
      Log.i(TAG, "setPlayingKey: no config");
    }
  }
  
  public final int a(ca paramca, int paramInt)
  {
    AppMethodBeat.i(228488);
    p.k(paramca, "msgInfo");
    Object localObject1 = f.jGv;
    localObject1 = f.a.t(paramca);
    if (((Collection)localObject1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228488);
      return 0;
    }
    int j = ((List)localObject1).size();
    if (paramInt < j)
    {
      String str1 = (String)((List)localObject1).get(paramInt);
      String str2 = com.tencent.mm.plugin.emoji.i.b.avg(str1);
      Object localObject2 = (CharSequence)str2;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramca.apG() + '_' + paramInt;
          Log.i(TAG, "checkMatchPatMsg: ".concat(String.valueOf(localObject2)));
          if (this.jGm.LE((String)localObject2) == null) {
            a(paramca, paramInt, (String)localObject2, str1, str2);
          }
        }
        paramInt += 1;
        break;
      }
    }
    paramInt = ((List)localObject1).size();
    AppMethodBeat.o(228488);
    return paramInt;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(228519);
    p.k(parama, "viewProvider");
    Object localObject;
    if (this.jGm.jGk.size() > 0)
    {
      localObject = this.jFQ;
      if (localObject != null) {
        ((FrameLayout)localObject).getLocationInWindow(this.jGl);
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.jGm.jGk).iterator();
    label165:
    label335:
    label348:
    label371:
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localObject = parama.Fl(localc.msgId);
      boolean bool;
      if (localObject != null)
      {
        bool = localc.b(parama.c((View)localObject, localc.jFO));
        int[] arrayOfInt1 = this.jGl;
        p.k(arrayOfInt1, "rootLocation");
        MMNeat7extView localMMNeat7extView = localc.jFS;
        if (localMMNeat7extView != null)
        {
          localObject = localMMNeat7extView.getLayout();
          if (localObject == null) {
            break label348;
          }
          localObject = a.jFJ;
          localObject = a.a.a(localMMNeat7extView);
          int[] arrayOfInt2 = new int[2];
          localMMNeat7extView.getLocationInWindow(arrayOfInt2);
          int i = arrayOfInt2[0] - arrayOfInt1[0];
          int j = arrayOfInt2[1] - arrayOfInt1[1];
          if (!((RectF)localObject).isEmpty()) {
            break label335;
          }
          localMMNeat7extView.post((Runnable)new c.e(localc, localMMNeat7extView, i, j));
          ((RectF)localObject).set(localc.jFV);
          float f1 = ((RectF)localObject).centerX();
          float f2 = i;
          float f3 = localMMNeat7extView.getPaddingLeft();
          float f4 = ((RectF)localObject).centerY();
          localc.c(f1 + f2 + f3, j + f4 + localMMNeat7extView.getPaddingTop(), (int)((RectF)localObject).width());
        }
      }
      for (;;)
      {
        if (!bool) {
          break label371;
        }
        localArrayList.add(localc);
        break;
        localObject = null;
        break label165;
        localc.jFV.set((RectF)localObject);
        break label258;
        Log.i(localc.TAG, "updateView: no layout");
        continue;
        bool = localc.b(null);
      }
    }
    label258:
    parama = ((Iterable)localArrayList).iterator();
    while (parama.hasNext())
    {
      localObject = (c)parama.next();
      this.jGm.b((c)localObject);
    }
    AppMethodBeat.o(228519);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(228491);
    Log.i(TAG, "onStop: " + this.jGm.jGk.size());
    Iterator localIterator = ((Iterable)this.jGm.jGk).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stop();
    }
    this.jGm.jGk.clear();
    AppMethodBeat.o(228491);
  }
  
  public final boolean r(ca paramca)
  {
    AppMethodBeat.i(228479);
    p.k(paramca, "msgInfo");
    Object localObject = f.jGv;
    String str = f.a.s(paramca);
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228479);
      return false;
    }
    if (paramca.hzL())
    {
      localObject = com.tencent.mm.plugin.emoji.i.b.avg(str);
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label135;
      }
    }
    label135:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        a(paramca, 0, String.valueOf(paramca.apG()), str, (String)localObject);
      }
      AppMethodBeat.o(228479);
      return false;
      localObject = com.tencent.mm.plugin.emoji.i.b.avf(str);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "animKey", "", "config", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "onScreenEffect", "onStart", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, String paramString, b.a parama);
    
    public abstract void a(String paramString, b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */