package com.tencent.mm.emoji.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/panel/MMContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "inflater", "Landroid/view/LayoutInflater;", "getSystemService", "", "name", "", "plugin-emojisdk_release"})
public final class a
  extends ContextThemeWrapper
{
  private LayoutInflater exe;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    AppMethodBeat.i(63251);
    AppMethodBeat.o(63251);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(63250);
    j.q(paramString, "name");
    if (j.e("layout_inflater", paramString))
    {
      if (this.exe == null)
      {
        Object localObject = super.getSystemService(paramString);
        paramString = localObject;
        if (!(localObject instanceof LayoutInflater)) {
          paramString = null;
        }
        this.exe = w.b((LayoutInflater)paramString);
      }
      paramString = this.exe;
      AppMethodBeat.o(63250);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(63250);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a
 * JD-Core Version:    0.7.0.1
 */