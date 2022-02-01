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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/candidate/ImeClipBoardListener;", "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "()V", "TAG", "", "mClipboardContent", "", "mEmojiFilterMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mHasClipBoard", "", "addFilterEmoji", "", "emojiStr", "closeClipContent", "getClipboardContent", "hasClipBoard", "onPrimaryClipChanged", "registerListener", "releaseListener", "plugin-hld_release"})
public final class e
  implements ClipboardManager.OnPrimaryClipChangedListener
{
  private static boolean DuR;
  private static CharSequence DuS;
  private static HashMap<String, Integer> DuT;
  public static final e DuU;
  
  static
  {
    AppMethodBeat.i(210124);
    DuU = new e();
    DuS = (CharSequence)"";
    DuT = new HashMap();
    AppMethodBeat.o(210124);
  }
  
  public static boolean eCO()
  {
    return DuR;
  }
  
  public static void eCP()
  {
    AppMethodBeat.i(210113);
    DuR = false;
    Object localObject = com.tencent.mm.plugin.hld.f.d.DGV;
    com.tencent.mm.plugin.hld.f.d.ac(DuS);
    DuS = (CharSequence)"";
    localObject = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
      if (localObject != null)
      {
        if (((b)localObject).eCq() != true) {
          break label89;
        }
        localObject = g.DCm;
        localObject = g.eEl();
        if (localObject == null) {
          break label89;
        }
        ((ImeCandidateView)localObject).eCJ();
        AppMethodBeat.o(210113);
        return;
      }
    }
    AppMethodBeat.o(210113);
    return;
    label89:
    AppMethodBeat.o(210113);
  }
  
  public static CharSequence eCQ()
  {
    return DuS;
  }
  
  public final void eCN()
  {
    AppMethodBeat.i(210110);
    DuS = (CharSequence)"";
    DuR = false;
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(210110);
      throw ((Throwable)localObject);
    }
    localObject = (ClipboardManager)localObject;
    try
    {
      ((ClipboardManager)localObject).addPrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)this);
      AppMethodBeat.o(210110);
      return;
    }
    catch (Exception localException)
    {
      Log.e("WxIme.ImeClipBoardListener", "registerListener " + localException.getMessage());
      AppMethodBeat.o(210110);
    }
  }
  
  public final void onPrimaryClipChanged()
  {
    AppMethodBeat.i(210120);
    Object localObject = n.DEn;
    if (!n.eEE())
    {
      Log.d("WxIme.ImeClipBoardListener", "onPrimaryClipChanged has pending input");
      AppMethodBeat.o(210120);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.d.DGV;
    localObject = com.tencent.mm.plugin.hld.f.d.getText();
    DuS = (CharSequence)localObject;
    if (Util.isNullOrNil((CharSequence)localObject))
    {
      DuS = (CharSequence)"";
      AppMethodBeat.o(210120);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.d.DGV;
    if (Util.isEqual(com.tencent.mm.plugin.hld.f.d.eGd(), DuS))
    {
      DuS = (CharSequence)"";
      AppMethodBeat.o(210120);
      return;
    }
    localObject = (Map)DuT;
    CharSequence localCharSequence = DuS;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      AppMethodBeat.o(210120);
      throw ((Throwable)localObject);
    }
    if (((Map)localObject).containsKey(localCharSequence))
    {
      localObject = ((Map)DuT).get(DuS);
      if (localObject == null) {
        p.iCn();
      }
      if (((Number)localObject).intValue() > 0)
      {
        localObject = (Integer)((Map)DuT).get(DuS);
        if (localObject != null) {
          ((Integer)localObject).intValue();
        }
        DuS = (CharSequence)"";
        AppMethodBeat.o(210120);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.hld.f.d.DGV;
    com.tencent.mm.plugin.hld.f.d.ac((CharSequence)"");
    DuR = true;
    localObject = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
      if ((localObject != null) && (((b)localObject).eCq() == true))
      {
        localObject = g.DCm;
        localObject = g.eEl();
        if (localObject != null) {
          ((ImeCandidateView)localObject).eCJ();
        }
      }
    }
    Log.d("WxIme.ImeClipBoardListener", "onPrimaryClipChanged " + DuS + ' ' + DuR);
    AppMethodBeat.o(210120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.candidate.e
 * JD-Core Version:    0.7.0.1
 */