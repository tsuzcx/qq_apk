package com.tencent.mm.emoji.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "", "()V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "holderCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "holderPool", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "rootLocation", "", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;)V", "checkMatch", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "checkRevoke", "", "onStop", "setPlayingKey", "itemHolder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "emojiKey", "updateItemView", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "Companion", "StateCallback", "plugin-emojisdk_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiDynamicController";
  public static final e.a gVu;
  public FrameLayout gUY;
  public final d gVq;
  private final c.a gVr;
  public String gVs;
  public b gVt;
  private final int[] osr;
  
  static
  {
    AppMethodBeat.i(199893);
    gVu = new e.a((byte)0);
    TAG = "MicroMsg.EmojiDynamicController";
    AppMethodBeat.o(199893);
  }
  
  public e()
  {
    AppMethodBeat.i(199892);
    this.osr = new int[2];
    this.gVq = new d();
    this.gVr = ((c.a)new c.a()
    {
      public final void a(long paramAnonymousLong, b.b paramAnonymousb)
      {
        AppMethodBeat.i(199888);
        p.h(paramAnonymousb, "effect");
        e.b localb = this.gVv.gVt;
        if (localb != null)
        {
          localb.a(paramAnonymousLong, paramAnonymousb);
          AppMethodBeat.o(199888);
          return;
        }
        AppMethodBeat.o(199888);
      }
      
      public final void a(b.b paramAnonymousb)
      {
        AppMethodBeat.i(199887);
        p.h(paramAnonymousb, "effect");
        e.b localb = this.gVv.gVt;
        if (localb != null)
        {
          localb.a(paramAnonymousb);
          AppMethodBeat.o(199887);
          return;
        }
        AppMethodBeat.o(199887);
      }
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(199886);
        p.h(paramAnonymousc, "holder");
        e.a(this.gVv).b(paramAnonymousc);
        AppMethodBeat.o(199886);
      }
    });
    AppMethodBeat.o(199892);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(199891);
    p.h(parama, "viewProvider");
    Object localObject1;
    if (this.gVq.gVo.size() > 0)
    {
      localObject1 = this.gUY;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).getLocationInWindow(this.osr);
      }
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.gVq.gVo).iterator();
    label157:
    label289:
    label337:
    label853:
    label856:
    label879:
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localObject1 = parama.zh(localc.msgId);
      boolean bool;
      Object localObject2;
      int i;
      float f1;
      float f2;
      float f3;
      float f4;
      if (localObject1 != null)
      {
        bool = localc.b(parama.ck((View)localObject1));
        localObject2 = this.osr;
        p.h(localObject2, "rootLocation");
        MMNeat7extView localMMNeat7extView = localc.gVa;
        if (localMMNeat7extView != null)
        {
          localObject1 = localMMNeat7extView.getLayout();
          if (localObject1 == null) {
            break label856;
          }
          i = (int)((com.tencent.neattextview.textview.layout.a)localObject1).getLineWidth(0);
          localObject1 = a.gUT;
          localObject1 = a.a.a(localMMNeat7extView);
          int[] arrayOfInt = new int[2];
          localMMNeat7extView.getLocationInWindow(arrayOfInt);
          int j = arrayOfInt[0];
          int k = localObject2[0];
          int m = arrayOfInt[1];
          int n = localObject2[1];
          f1 = ((PointF)localObject1).x;
          f2 = j - k;
          f3 = ((PointF)localObject1).y;
          f4 = m - n;
          if (localc.gVb != null) {
            break label289;
          }
          Log.i(localc.TAG, "updateView: no drawable");
        }
      }
      for (;;)
      {
        if (!bool) {
          break label879;
        }
        localArrayList.add(localc);
        break;
        localObject1 = null;
        break label157;
        if (localc.gUY == null)
        {
          Log.i(localc.TAG, "updateView: no rootView");
        }
        else
        {
          if (localc.gUZ == null)
          {
            localObject1 = localc.gUY;
            if (localObject1 == null) {
              break label782;
            }
            localObject1 = ((FrameLayout)localObject1).getContext();
            localc.gUZ = new MMAnimateView((Context)localObject1);
            localObject1 = localc.gUY;
            if (localObject1 != null) {
              ((FrameLayout)localObject1).addView((View)localc.gUZ, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(i, i));
            }
            localObject1 = localc.gUZ;
            if (localObject1 != null) {
              ((MMAnimateView)localObject1).setVisibility(8);
            }
          }
          localObject1 = localc.gUZ;
          if (localObject1 != null)
          {
            localObject1 = ((MMAnimateView)localObject1).getLayoutParams();
            localObject1 = (FrameLayout.LayoutParams)localObject1;
            if (localObject1 != null) {
              break label794;
            }
            localObject1 = new FrameLayout.LayoutParams(i, i);
            localObject2 = localc.gUZ;
            if (localObject2 != null) {
              ((MMAnimateView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
          for (;;)
          {
            localObject1 = localc.gUZ;
            if (localObject1 != null) {
              ((MMAnimateView)localObject1).setTranslationX(f2 + f1 - i / 2);
            }
            localObject1 = localc.gUZ;
            if (localObject1 != null) {
              ((MMAnimateView)localObject1).setTranslationY(f3 + f4 - i / 2);
            }
            if (localc.gVd) {
              break label853;
            }
            localObject1 = localc.gVi;
            if (localObject1 != null) {
              ((com.tencent.mm.g.b.a.l)localObject1).bfK();
            }
            localObject1 = localc.gUY;
            if ((localObject1 != null) && (((FrameLayout)localObject1).getVisibility() == 8))
            {
              localObject1 = localc.gUY;
              if (localObject1 != null) {
                ((FrameLayout)localObject1).setVisibility(0);
              }
            }
            localObject1 = localc.gUZ;
            if ((localObject1 != null) && (((MMAnimateView)localObject1).getVisibility() == 8))
            {
              localObject1 = localc.gUZ;
              if (localObject1 != null) {
                ((MMAnimateView)localObject1).setVisibility(0);
              }
            }
            localObject1 = localc.gUZ;
            if (localObject1 != null) {
              ((MMAnimateView)localObject1).setImageDrawable((Drawable)localc.gVb);
            }
            com.tencent.mm.ac.d.C(localc.gVg);
            localObject1 = localc.gVc;
            if (localObject1 != null)
            {
              localObject1 = ((b.a)localObject1).gUX;
              if ((localObject1 != null) && (((b.b)localObject1).delay >= 0)) {
                com.tencent.mm.ac.d.a(((b.b)localObject1).delay, localc.gVg);
              }
            }
            localc.gVd = true;
            com.tencent.mm.ac.d.C(localc.gVh);
            localObject1 = localc.gUZ;
            if (localObject1 == null) {
              break label853;
            }
            ((MMAnimateView)localObject1).animate().scaleX(1.5F).scaleY(1.5F).setDuration(0L).withEndAction((Runnable)new c.d((MMAnimateView)localObject1, localc));
            break;
            localObject1 = null;
            break label337;
            localObject1 = null;
            break label428;
            if ((((FrameLayout.LayoutParams)localObject1).width != i) || (((FrameLayout.LayoutParams)localObject1).height != i))
            {
              ((FrameLayout.LayoutParams)localObject1).width = i;
              ((FrameLayout.LayoutParams)localObject1).height = i;
              localObject2 = localc.gUZ;
              if (localObject2 != null) {
                ((MMAnimateView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              }
            }
          }
          continue;
          Log.i(localc.TAG, "updateView: no layout");
          continue;
          bool = localc.b(null);
        }
      }
    }
    label428:
    parama = ((Iterable)localArrayList).iterator();
    label782:
    label794:
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.gVq.b((c)localObject1);
    }
    AppMethodBeat.o(199891);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(199890);
    Log.i(TAG, "onStop: " + this.gVq.gVo.size());
    Iterator localIterator = ((Iterable)this.gVq.gVo).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).stop();
    }
    this.gVq.gVo.clear();
    AppMethodBeat.o(199890);
  }
  
  public final boolean q(ca paramca)
  {
    AppMethodBeat.i(199889);
    p.h(paramca, "msgInfo");
    Object localObject1 = f.gVz;
    Object localObject3 = f.a.r(paramca);
    localObject1 = (CharSequence)localObject3;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199889);
      return false;
    }
    Object localObject2 = com.tencent.mm.plugin.emoji.h.b.anj((String)localObject3);
    localObject1 = (CharSequence)localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        Object localObject4 = this.gVq;
        long l = paramca.ajL();
        localObject1 = new c();
        ((c)localObject1).msgId = l;
        ((d)localObject4).gVo.add(localObject1);
        ((c)localObject1).msgId = paramca.ajL();
        ((c)localObject1).gUY = this.gUY;
        ((c)localObject1).gVj = this.gVr;
        if (paramca.ajN() == 1)
        {
          ((c)localObject1).gVi = new com.tencent.mm.g.b.a.l();
          paramca = ((c)localObject1).gVi;
          if (paramca != null)
          {
            localObject4 = com.tencent.mm.emoji.c.a.hbZ;
            if (!com.tencent.mm.emoji.c.a.avY()) {
              break label619;
            }
            i = 1;
            label207:
            paramca.jE(i);
          }
          paramca = com.tencent.mm.emoji.c.a.hbZ;
          com.tencent.mm.emoji.c.a.ed(false);
        }
        paramca = ((c)localObject1).gVi;
        if (paramca != null) {
          paramca.hQ(this.gVs);
        }
        paramca = ((c)localObject1).gVi;
        if (paramca != null) {
          paramca.hP((String)localObject3);
        }
        p.h(localObject1, "itemHolder");
        p.h(localObject2, "emojiKey");
        Log.i(TAG, "setPlayingKey: ".concat(String.valueOf(localObject2)));
        paramca = f.gVz;
        localObject3 = ((Iterable)f.auu().gUV).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            paramca = ((Iterator)localObject3).next();
            if (p.j(((b.a)paramca).key, localObject2))
            {
              label343:
              localObject2 = (b.a)paramca;
              if (localObject2 == null) {
                break label737;
              }
              paramca = new StringBuilder();
              localObject3 = com.tencent.mm.emoji.e.a.hdT;
              paramca = com.tencent.mm.emoji.e.a.aww() + ((b.a)localObject2).gUW;
              if (!s.YS(paramca)) {
                break label725;
              }
              p.h(localObject2, "config");
              p.h(paramca, "filePath");
              ((c)localObject1).gVc = ((b.a)localObject2);
              localObject2 = ((c)localObject1).gVc;
              if (localObject2 != null)
              {
                localObject2 = ((b.a)localObject2).gUX;
                if (localObject2 != null)
                {
                  localObject3 = ((c)localObject1).gVj;
                  if (localObject3 != null) {
                    ((c.a)localObject3).a((b.b)localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      ((c)localObject1).gVb = new com.tencent.mm.plugin.gif.h(s.aW(paramca, 0, -1));
      if (((c)localObject1).gVb == null) {
        break label629;
      }
      paramca = ((c)localObject1).gVi;
      if (paramca != null) {
        paramca.jD(1);
      }
    }
    catch (Exception paramca)
    {
      for (;;)
      {
        label502:
        Log.printErrStackTrace(((c)localObject1).TAG, (Throwable)paramca, "create anim", new Object[0]);
        label619:
        label629:
        if ((paramca instanceof MMGIFException))
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(711, 21);
          paramca = ((c)localObject1).gVi;
          if (paramca != null) {
            paramca.jD(2);
          }
          paramca = ((c)localObject1).gVi;
          if (paramca != null)
          {
            paramca.abZ();
            continue;
            i = 1;
          }
        }
      }
    }
    paramca = ((c)localObject1).gVb;
    if (paramca != null)
    {
      i = paramca.dXA();
      paramca = ((c)localObject1).gVb;
      if (paramca != null) {
        paramca.OH(i);
      }
      paramca = ((c)localObject1).gVb;
      if (paramca != null) {
        paramca.rU();
      }
      paramca = ((c)localObject1).gVb;
      if (paramca != null) {
        paramca.pause();
      }
      i = 1;
      if (i != 0) {
        break label749;
      }
      paramca = ((c)localObject1).gVi;
      if (paramca != null) {
        paramca.jC(2);
      }
      paramca = ((c)localObject1).gVi;
      if (paramca != null) {
        paramca.bfK();
      }
      this.gVq.b((c)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(199889);
      return false;
      i = 0;
      break;
      i = 0;
      break label207;
      paramca = null;
      break label343;
      paramca = ((c)localObject1).gVi;
      if (paramca == null) {
        break label502;
      }
      paramca.jD(2);
      break label502;
      label725:
      paramca = f.gVz;
      f.a.auz();
      for (;;)
      {
        i = 0;
        break;
        label737:
        Log.i(TAG, "setPlayingKey: no config");
      }
      label749:
      paramca = ((c)localObject1).gVi;
      if (paramca != null) {
        paramca.jC(1);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "effect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "onScreenEffect", "onStart", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void a(long paramLong, b.b paramb);
    
    public abstract void a(b.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.e
 * JD-Core Version:    0.7.0.1
 */