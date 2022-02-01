package com.tencent.mm.plugin.hld.f;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeClipboardUtil;", "", "()V", "TAG", "", "getCloseClipContent", "getText", "", "saveCloseClipContent", "", "content", "updateClipContent", "plugin-hld_release"})
public final class d
{
  public static final d DGV;
  private static final String TAG = "WxIme.WxImeDictUtil";
  
  static
  {
    AppMethodBeat.i(216346);
    DGV = new d();
    TAG = "WxIme.WxImeDictUtil";
    AppMethodBeat.o(216346);
  }
  
  public static void ac(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(216344);
    p.k(paramCharSequence, "content");
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("ime_close_clip_content", paramCharSequence.toString());
        AppMethodBeat.o(216344);
        return;
      }
    }
    AppMethodBeat.o(216344);
  }
  
  public static String eGd()
  {
    AppMethodBeat.i(216345);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      String str = ((MultiProcessMMKV)localObject).getString("ime_close_clip_content", "");
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(216345);
    return localObject;
  }
  
  public static CharSequence getText()
  {
    AppMethodBeat.i(216343);
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(216343);
      throw ((Throwable)localObject);
    }
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if ((localObject == null) || (((ClipData)localObject).getItemCount() <= 0))
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(216343);
      return localObject;
    }
    localObject = ((ClipData)localObject).getItemAt(0);
    if (localObject != null)
    {
      CharSequence localCharSequence = ((ClipData.Item)localObject).getText();
      localObject = localCharSequence;
      if (localCharSequence != null) {}
    }
    else
    {
      localObject = (CharSequence)"";
    }
    AppMethodBeat.o(216343);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.d
 * JD-Core Version:    0.7.0.1
 */