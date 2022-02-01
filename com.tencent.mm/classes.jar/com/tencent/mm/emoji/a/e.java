package com.tencent.mm.emoji.a;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "", "()V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "holderCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "holderPool", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "rootLocation", "", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;)V", "checkMatch", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "checkMatchPatMsg", "", "playedIndex", "checkRevoke", "", "createHolder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "index", "animKey", "content", "emojiKey", "onStop", "setPlayingKey", "itemHolder", "updateItemView", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "Companion", "StateCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e.a mfS;
  public FrameLayout mfE;
  private final int[] mfT;
  public final d mfU;
  private final c.a mfV;
  public String mfW;
  public b mfX;
  
  static
  {
    AppMethodBeat.i(242335);
    mfS = new e.a((byte)0);
    TAG = "MicroMsg.EmojiDynamicController";
    AppMethodBeat.o(242335);
  }
  
  public e()
  {
    AppMethodBeat.i(242309);
    this.mfT = new int[2];
    this.mfU = new d();
    this.mfV = ((c.a)new c.a()
    {
      public final void a(long paramAnonymousLong, String paramAnonymousString, b.a paramAnonymousa)
      {
        AppMethodBeat.i(242350);
        s.u(paramAnonymousString, "animKey");
        s.u(paramAnonymousa, "config");
        e.b localb = this.mfY.mfX;
        if (localb != null) {
          localb.a(paramAnonymousLong, paramAnonymousString, paramAnonymousa);
        }
        AppMethodBeat.o(242350);
      }
      
      public final void a(String paramAnonymousString, b.a paramAnonymousa)
      {
        AppMethodBeat.i(242340);
        s.u(paramAnonymousString, "animKey");
        s.u(paramAnonymousa, "config");
        e.b localb = this.mfY.mfX;
        if (localb != null) {
          localb.a(paramAnonymousString, paramAnonymousa);
        }
        AppMethodBeat.o(242340);
      }
      
      public final void d(c paramAnonymousc)
      {
        AppMethodBeat.i(242334);
        s.u(paramAnonymousc, "holder");
        e.a(this.mfY).e(paramAnonymousc);
        AppMethodBeat.o(242334);
      }
    });
    AppMethodBeat.o(242309);
  }
  
  private final c a(cc paramcc, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(242325);
    c localc = this.mfU.aUm();
    localc.msgId = paramcc.field_msgId;
    localc.Ej(paramString1);
    localc.mfD = paramInt;
    localc.msgType = paramcc.getType();
    localc.mfE = this.mfE;
    localc.mfQ = this.mfV;
    if (paramcc.field_isSend == 1)
    {
      localc.mfP = new q();
      paramcc = localc.mfP;
      if (paramcc != null)
      {
        paramString1 = com.tencent.mm.emoji.d.a.mmh;
        if (com.tencent.mm.emoji.d.a.aVX())
        {
          paramInt = 1;
          paramcc.ily = paramInt;
        }
      }
      else
      {
        paramcc = com.tencent.mm.emoji.d.a.mmh;
        com.tencent.mm.emoji.d.a.fl(false);
      }
    }
    else
    {
      paramcc = localc.mfP;
      if (paramcc != null) {
        paramcc.kh(this.mfW);
      }
      paramcc = localc.mfP;
      if (paramcc != null) {
        paramcc.kg(paramString2);
      }
      if (a(localc, paramString3)) {
        break label215;
      }
      paramcc = localc.mfP;
      if (paramcc != null) {
        paramcc.ilv = 2;
      }
      paramcc = localc.mfP;
      if (paramcc != null) {
        paramcc.bMH();
      }
      this.mfU.e(localc);
    }
    for (;;)
    {
      AppMethodBeat.o(242325);
      return localc;
      paramInt = 0;
      break;
      label215:
      paramcc = localc.mfP;
      if (paramcc != null) {
        paramcc.ilv = 1;
      }
    }
  }
  
  private static boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(242320);
    s.u(paramc, "itemHolder");
    s.u(paramString, "emojiKey");
    Log.i(TAG, s.X("setPlayingKey: ", paramString));
    Object localObject1 = f.mfZ;
    Object localObject2 = ((Iterable)f.aUn().mfy).iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (s.p(((b.a)localObject1).key, paramString))
        {
          paramString = (String)localObject1;
          localObject1 = (b.a)paramString;
          if (localObject1 == null) {
            break label381;
          }
          paramString = com.tencent.mm.emoji.f.c.moq;
          paramString = s.X(com.tencent.mm.emoji.f.c.aWD(), ((b.a)localObject1).mfz);
          if (!y.ZC(paramString)) {
            break label367;
          }
          s.u(localObject1, "config");
          s.u(paramString, "filePath");
          paramc.mfK = ((b.a)localObject1);
          localObject1 = paramc.mfK;
          if ((localObject1 != null) && (((b.a)localObject1).mfA != null))
          {
            localObject2 = paramc.mfQ;
            if (localObject2 != null) {
              ((c.a)localObject2).a(paramc.mfC, (b.a)localObject1);
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramc.mfI = new com.tencent.mm.plugin.gif.h(y.bi(paramString, 0, -1));
        if (paramc.mfI == null) {
          continue;
        }
        paramString = paramc.mfP;
        if (paramString != null) {
          paramString.ilw = 1;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(paramc.TAG, (Throwable)paramString, "create anim", new Object[0]);
        if (!(paramString instanceof MMGIFException)) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(711, 21);
        paramString = paramc.mfP;
        if (paramString == null) {
          continue;
        }
        paramString.ilw = 2;
        paramString = paramc.mfP;
        if (paramString == null) {
          continue;
        }
        paramString.ilx = 1;
        continue;
        int i = paramString.JhE;
        continue;
      }
      paramString = paramc.mfI;
      if (paramString != null) {
        continue;
      }
      i = 1;
      paramString = paramc.mfI;
      if (paramString != null) {
        paramString.JhH = i;
      }
      paramString = paramc.mfI;
      if (paramString != null) {
        paramString.preDraw();
      }
      paramc = paramc.mfI;
      if (paramc != null) {
        paramc.mIsRunning = false;
      }
      AppMethodBeat.o(242320);
      return true;
      paramString = null;
      break;
      paramString = paramc.mfP;
      if (paramString != null) {
        paramString.ilw = 2;
      }
    }
    label367:
    paramc = f.mfZ;
    f.a.aUs();
    for (;;)
    {
      AppMethodBeat.o(242320);
      return false;
      label381:
      Log.i(TAG, "setPlayingKey: no config");
    }
  }
  
  public final int a(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(242347);
    s.u(paramcc, "msgInfo");
    Object localObject1 = f.mfZ;
    localObject1 = f.a.t(paramcc);
    Object localObject2 = (Collection)localObject1;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(242347);
      return 0;
    }
    int k = ((List)localObject1).size();
    int j;
    String str;
    Object localObject3;
    if (paramInt < k)
    {
      j = paramInt;
      i = j + 1;
      localObject2 = (String)((List)localObject1).get(j);
      str = com.tencent.mm.plugin.emoji.g.d.apg((String)localObject2);
      localObject3 = (CharSequence)str;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label230;
      }
    }
    label230:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        localObject3 = paramcc.field_msgId + '_' + j;
        Log.i(TAG, s.X("checkMatchPatMsg: ", localObject3));
        if (this.mfU.Ek((String)localObject3) == null) {
          a(paramcc, j, (String)localObject3, (String)localObject2, str);
        }
      }
      paramInt = i;
      if (i < k) {
        break;
      }
      paramInt = ((List)localObject1).size();
      AppMethodBeat.o(242347);
      return paramInt;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(242363);
    s.u(parama, "viewProvider");
    if (this.mfU.mfR.size() > 0)
    {
      localObject = this.mfE;
      if (localObject != null) {
        ((FrameLayout)localObject).getLocationInWindow(this.mfT);
      }
    }
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)this.mfU.mfR).iterator();
    label158:
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      View localView = parama.ht(localc.msgId);
      boolean bool;
      if (localView != null)
      {
        bool = localc.b(parama.c(localView, localc.mfC));
        localc.u(this.mfT);
      }
      for (;;)
      {
        if (!bool) {
          break label158;
        }
        ((ArrayList)localObject).add(localc);
        break;
        bool = localc.b(null);
      }
    }
    parama = ((Iterable)localObject).iterator();
    while (parama.hasNext())
    {
      localObject = (c)parama.next();
      this.mfU.e((c)localObject);
    }
    AppMethodBeat.o(242363);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(242354);
    Log.i(TAG, s.X("onStop: ", Integer.valueOf(this.mfU.mfR.size())));
    Iterator localIterator = ((Iterable)this.mfU.mfR).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stop();
    }
    this.mfU.mfR.clear();
    AppMethodBeat.o(242354);
  }
  
  public final boolean r(cc paramcc)
  {
    AppMethodBeat.i(242339);
    s.u(paramcc, "msgInfo");
    Object localObject = f.mfZ;
    String str = f.a.s(paramcc);
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(242339);
      return false;
    }
    if (paramcc.jbQ())
    {
      localObject = com.tencent.mm.plugin.emoji.g.d.apg(str);
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label135;
      }
    }
    label135:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        a(paramcc, 0, String.valueOf(paramcc.field_msgId), str, (String)localObject);
      }
      AppMethodBeat.o(242339);
      return false;
      localObject = com.tencent.mm.plugin.emoji.g.d.apf(str);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "animKey", "", "config", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "onScreenEffect", "onStart", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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