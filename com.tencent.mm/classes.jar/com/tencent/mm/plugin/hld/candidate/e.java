package com.tencent.mm.plugin.hld.candidate;

import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/candidate/ImeClipBoardListener;", "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "()V", "TAG", "", "mClipboardContent", "", "mEmojiFilterMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mHasClipBoard", "", "addFilterEmoji", "", "emojiStr", "closeClipContent", "getClipboardContent", "hasClipBoard", "onPrimaryClipChanged", "registerListener", "releaseListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements ClipboardManager.OnPrimaryClipChangedListener
{
  public static final e Jon;
  private static boolean Joo;
  private static CharSequence Jop;
  private static HashMap<String, Integer> Joq;
  
  static
  {
    AppMethodBeat.i(312862);
    Jon = new e();
    Jop = (CharSequence)"";
    Joq = new HashMap();
    AppMethodBeat.o(312862);
  }
  
  public static boolean fKQ()
  {
    return Joo;
  }
  
  public static void fKR()
  {
    AppMethodBeat.i(312853);
    Joo = false;
    Object localObject = com.tencent.mm.plugin.hld.f.d.Jyl;
    com.tencent.mm.plugin.hld.f.d.al(Jop);
    Jop = (CharSequence)"";
    localObject = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if ((localObject == null) || (((b)localObject).fKu() != true)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = g.JuL;
        localObject = g.fMn();
        if (localObject != null) {
          ((ImeCandidateView)localObject).fKM();
        }
      }
      AppMethodBeat.o(312853);
      return;
    }
  }
  
  public static CharSequence fKS()
  {
    return Jop;
  }
  
  public final void fKP()
  {
    AppMethodBeat.i(312868);
    Jop = (CharSequence)"";
    Joo = false;
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(312868);
      throw ((Throwable)localObject);
    }
    localObject = (ClipboardManager)localObject;
    try
    {
      ((ClipboardManager)localObject).addPrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)this);
      AppMethodBeat.o(312868);
      return;
    }
    catch (Exception localException)
    {
      Log.e("WxIme.ImeClipBoardListener", s.X("registerListener ", localException.getMessage()));
      AppMethodBeat.o(312868);
    }
  }
  
  public final void onPrimaryClipChanged()
  {
    AppMethodBeat.i(312879);
    Object localObject = n.JvW;
    if (!n.fMH())
    {
      Log.d("WxIme.ImeClipBoardListener", "onPrimaryClipChanged has pending input");
      AppMethodBeat.o(312879);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.d.Jyl;
    localObject = com.tencent.mm.plugin.hld.f.d.getText();
    Jop = (CharSequence)localObject;
    if (Util.isNullOrNil((CharSequence)localObject))
    {
      Jop = (CharSequence)"";
      AppMethodBeat.o(312879);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.d.Jyl;
    if (Util.isEqual(com.tencent.mm.plugin.hld.f.d.fNP(), Jop))
    {
      Jop = (CharSequence)"";
      AppMethodBeat.o(312879);
      return;
    }
    localObject = (Map)Joq;
    CharSequence localCharSequence = Jop;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(312879);
      throw ((Throwable)localObject);
    }
    if (((Map)localObject).containsKey(localCharSequence))
    {
      localObject = ((Map)Joq).get(Jop);
      s.checkNotNull(localObject);
      if (((Number)localObject).intValue() > 0)
      {
        localObject = (Integer)((Map)Joq).get(Jop);
        if (localObject != null) {
          ((Integer)localObject).intValue();
        }
        Jop = (CharSequence)"";
        AppMethodBeat.o(312879);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.hld.f.d.Jyl;
    com.tencent.mm.plugin.hld.f.d.al((CharSequence)"");
    Joo = true;
    localObject = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if ((localObject == null) || (((b)localObject).fKu() != true)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = g.JuL;
        localObject = g.fMn();
        if (localObject != null) {
          ((ImeCandidateView)localObject).fKM();
        }
      }
      Log.d("WxIme.ImeClipBoardListener", "onPrimaryClipChanged " + Jop + ' ' + Joo);
      AppMethodBeat.o(312879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.e
 * JD-Core Version:    0.7.0.1
 */