package com.tencent.mm.plugin.hld.f;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeClipboardUtil;", "", "()V", "TAG", "", "getCloseClipContent", "getText", "", "saveCloseClipContent", "", "content", "updateClipContent", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Jyl;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(311561);
    Jyl = new d();
    TAG = "WxIme.WxImeDictUtil";
    AppMethodBeat.o(311561);
  }
  
  public static void aIy(String paramString)
  {
    AppMethodBeat.i(311554);
    if (paramString == null)
    {
      AppMethodBeat.o(311554);
      return;
    }
    paramString = ClipData.newPlainText((CharSequence)"Label", (CharSequence)paramString);
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(311554);
      throw paramString;
    }
    ((ClipboardManager)localObject).setPrimaryClip(paramString);
    AppMethodBeat.o(311554);
  }
  
  public static void al(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(311540);
    s.u(paramCharSequence, "content");
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putString("ime_close_clip_content", paramCharSequence.toString());
      }
    }
    AppMethodBeat.o(311540);
  }
  
  public static String fNP()
  {
    AppMethodBeat.i(311546);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311546);
      return "";
    }
    localObject = ((MultiProcessMMKV)localObject).getString("ime_close_clip_content", "");
    if (localObject == null)
    {
      AppMethodBeat.o(311546);
      return "";
    }
    AppMethodBeat.o(311546);
    return localObject;
  }
  
  public static CharSequence getText()
  {
    AppMethodBeat.i(311536);
    Object localObject = MMApplicationContext.getContext().getSystemService("clipboard");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(311536);
      throw ((Throwable)localObject);
    }
    localObject = ((ClipboardManager)localObject).getPrimaryClip();
    if ((localObject == null) || (((ClipData)localObject).getItemCount() <= 0))
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(311536);
      return localObject;
    }
    localObject = ((ClipData)localObject).getItemAt(0);
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(311536);
      return localObject;
    }
    localObject = ((ClipData.Item)localObject).getText();
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(311536);
      return localObject;
    }
    AppMethodBeat.o(311536);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.d
 * JD-Core Version:    0.7.0.1
 */